# Input env variables
CHART_NAME=$1
IMAGE_NAME=$2
REGISTRY_URL=$3
IMAGE_PULL_SECRET_NAME=$4
KUBERNETES_CLUSTER_NAME=$5
CLUSTER_NAMESPACE=$6
echo "$CHART_NAME"
echo "$IMAGE_NAME"
echo "$REGISTRY_URL"
echo "$IMAGE_PULL_SECRET_NAME"
echo "$KUBERNETES_CLUSTER_NAME"
echo "$CLUSTER_NAMESPACE"


#Check cluster availability
echo "=========================================================="
echo "CHECKING CLUSTER readiness and namespace existence"
IP_ADDR=$(kubectl get nodes --selector=kubernetes.io/role!=master -o jsonpath={.items[*].status.addresses[?\(@.type==\"ExternalIP\"\)].address})
if [ -z "${IP_ADDR}" ]; then
  echo -e "${KUBERNETES_CLUSTER_NAME} not created or workers not ready"
  exit 1
fi
#Check namespace availability
echo "Configuring cluster namespace"
if kubectl get namespace ${CLUSTER_NAMESPACE}; then
  echo -e "Namespace ${CLUSTER_NAMESPACE} found."
else
  kubectl create namespace ${CLUSTER_NAMESPACE}
  echo -e "Namespace ${CLUSTER_NAMESPACE} created."
fi

echo "=========================================================="
echo -e "Checking for presence of ${IMAGE_PULL_SECRET_NAME} imagePullSecret"
if ! kubectl get secret ${IMAGE_PULL_SECRET_NAME} --namespace ${CLUSTER_NAMESPACE}; then
  echo -e "${IMAGE_PULL_SECRET_NAME} not found in ${CLUSTER_NAMESPACE}, creating it"
  # for Container Registry, docker username is 'token' and email does not matter
  kubectl --namespace ${CLUSTER_NAMESPACE} create secret docker-registry ${IMAGE_PULL_SECRET_NAME} --docker-server=${REGISTRY_URL} --docker-password=${_BLUEMIX_API_KEY} --docker-username=iamapikey --docker-email=a@b.com
else
  echo -e "Namespace ${CLUSTER_NAMESPACE} already has an imagePullSecret for the docker registry."
fi

echo "=========================================================="
echo "CONFIGURING TILLER (Helm server-side component)"
helm init --upgrade
if ! kubectl get serviceaccount tiller --namespace kube-system; then
   echo "Tiller not configured yet"
   kubectl create serviceaccount --namespace kube-system tiller
   kubectl create clusterrolebinding tiller-cluster-rule --clusterrole=cluster-admin --serviceaccount=kube-system:tiller
   kubectl patch deploy --namespace kube-system tiller-deploy -p '{"spec":{"template":{"spec":{"serviceAccount":"tiller"}}}}'
else
    echo "Tiller is configured"
fi

kubectl rollout status -w deployment/tiller-deploy --namespace=kube-system
helm version

echo "=========================================================="
echo -e "CHECKING HELM releases in this namespace: ${CLUSTER_NAMESPACE}"
helm list --namespace ${CLUSTER_NAMESPACE}
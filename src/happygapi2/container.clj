(ns happygapi2.container
  "Kubernetes Engine API
Builds and manages container-based applications, powered by the open source Kubernetes technology.
See: https://cloud.google.com/container-engine/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-getServerConfig
  "Returns configuration info about the Google Kubernetes Engine service.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations/getServerConfig

name <string> The name (project and location) of the server config to get, specified in the format `projects/*/locations/*`.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) to return operations for. This field has been deprecated and replaced by the name field."
  ([name] (projects-locations-getServerConfig name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/{+name}/serverConfig",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-getJwks
  "Gets the public component of the cluster signing keys in JSON Web Key format.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/getJwks

parent <string> The cluster (project, location, cluster name) to get keys for. Specified in the format `projects/*/locations/*/clusters/*`."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://container.googleapis.com/v1/{+parent}/jwks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil}))

(defn projects-locations-clusters-updateMaster
  "Updates the master for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/updateMaster

name <string> The name (project, location, cluster) of the cluster to update. Specified in the format `projects/*/locations/*/clusters/*`.
UpdateMasterRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :masterVersion string,
 :name string}"
  [name UpdateMasterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:updateMaster",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpdateMasterRequest}))

(defn projects-locations-clusters-get
  "Gets the details of a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/get

name <string> The name (project, location, cluster) of the cluster to retrieve. Specified in the format `projects/*/locations/*/clusters/*`.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to retrieve. This field has been deprecated and replaced by the name field."
  ([name] (projects-locations-clusters-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://container.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-setResourceLabels
  "Sets labels on a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setResourceLabels

name <string> The name (project, location, cluster name) of the cluster to set labels. Specified in the format `projects/*/locations/*/clusters/*`.
SetLabelsRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :resourceLabels object,
 :labelFingerprint string,
 :name string}"
  [name SetLabelsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setResourceLabels",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLabelsRequest}))

(defn projects-locations-clusters-create
  "Creates a cluster, consisting of the specified number and type of Google Compute Engine instances. By default, the cluster is created in the project's [default network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks). One firewall is added for the cluster. After cluster creation, the Kubelet creates routes for each node to allow the containers on that node to communicate with all other instances in the cluster. Finally, an entry is added to the project's global metadata indicating which CIDR range the cluster is using.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/create

parent <string> The parent (project and location) where the cluster will be created. Specified in the format `projects/*/locations/*`.
CreateClusterRequest:
{:projectId string,
 :zone string,
 :cluster
 {:description string,
  :currentNodeCount integer,
  :meshCertificates {:enableCertificates boolean},
  :tpuIpv4CidrBlock string,
  :verticalPodAutoscaling {:enabled boolean},
  :nodePoolAutoConfig
  {:networkTags {:tags [string]},
   :resourceManagerTags {:tags object},
   :nodeKubeletConfig
   {:cpuManagerPolicy string,
    :cpuCfsQuota boolean,
    :cpuCfsQuotaPeriod string,
    :podPidsLimit string,
    :insecureKubeletReadonlyPortEnabled boolean}},
  :networkPolicy
  {:provider [PROVIDER_UNSPECIFIED CALICO], :enabled boolean},
  :instanceGroupUrls [string],
  :parentProductConfig {:productName string, :labels object},
  :autopilot
  {:enabled boolean, :workloadPolicyConfig {:allowNetAdmin boolean}},
  :monitoringConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER
      STORAGE
      HPA
      POD
      DAEMONSET
      DEPLOYMENT
      STATEFULSET
      CADVISOR
      KUBELET]]},
   :managedPrometheusConfig {:enabled boolean},
   :advancedDatapathObservabilityConfig
   {:enableMetrics boolean,
    :relayMode
    [RELAY_MODE_UNSPECIFIED DISABLED INTERNAL_VPC_LB EXTERNAL_LB],
    :enableRelay boolean}},
  :loggingConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      WORKLOADS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER]]}},
  :autoscaling
  {:enableNodeAutoprovisioning boolean,
   :resourceLimits
   [{:resourceType string, :minimum string, :maximum string}],
   :autoscalingProfile
   [PROFILE_UNSPECIFIED OPTIMIZE_UTILIZATION BALANCED],
   :autoprovisioningNodePoolDefaults
   {:serviceAccount string,
    :shieldedInstanceConfig
    {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
    :bootDiskKmsKey string,
    :imageType string,
    :oauthScopes [string],
    :diskType string,
    :diskSizeGb integer,
    :insecureKubeletReadonlyPortEnabled boolean,
    :management
    {:autoUpgrade boolean,
     :autoRepair boolean,
     :upgradeOptions AutoUpgradeOptions},
    :upgradeSettings
    {:maxSurge integer,
     :maxUnavailable integer,
     :strategy
     [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
     :blueGreenSettings BlueGreenSettings},
    :minCpuPlatform string},
   :autoprovisioningLocations [string]},
  :enableKubernetesAlpha boolean,
  :nodeConfig
  {:serviceAccount string,
   :tags [string],
   :labels object,
   :taints
   [{:key string,
     :value string,
     :effect
     [EFFECT_UNSPECIFIED NO_SCHEDULE PREFER_NO_SCHEDULE NO_EXECUTE]}],
   :ephemeralStorageLocalSsdConfig {:localSsdCount integer},
   :preemptible boolean,
   :shieldedInstanceConfig
   {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
   :loggingConfig
   {:variantConfig
    {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
   :bootDiskKmsKey string,
   :sandboxConfig {:type [UNSPECIFIED GVISOR]},
   :soleTenantConfig
   {:nodeAffinities
    [{:key string,
      :operator [OPERATOR_UNSPECIFIED IN NOT_IN],
      :values [string]}]},
   :localSsdCount integer,
   :nodeGroup string,
   :resourceManagerTags {:tags object},
   :secondaryBootDisks
   [{:mode [MODE_UNSPECIFIED CONTAINER_IMAGE_CACHE],
     :diskImage string}],
   :imageType string,
   :machineType string,
   :linuxNodeConfig
   {:sysctls object,
    :cgroupMode
    [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
    :hugepages {:hugepageSize2m integer, :hugepageSize1g integer}},
   :kubeletConfig
   {:cpuManagerPolicy string,
    :cpuCfsQuota boolean,
    :cpuCfsQuotaPeriod string,
    :podPidsLimit string,
    :insecureKubeletReadonlyPortEnabled boolean},
   :secondaryBootDiskUpdateStrategy object,
   :oauthScopes [string],
   :confidentialNodes {:enabled boolean},
   :resourceLabels object,
   :enableConfidentialStorage boolean,
   :diskType string,
   :advancedMachineFeatures
   {:threadsPerCore string, :enableNestedVirtualization boolean},
   :localNvmeSsdBlockConfig {:localSsdCount integer},
   :diskSizeGb integer,
   :reservationAffinity
   {:consumeReservationType
    [UNSPECIFIED NO_RESERVATION ANY_RESERVATION SPECIFIC_RESERVATION],
    :key string,
    :values [string]},
   :gcfsConfig {:enabled boolean},
   :workloadMetadataConfig
   {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
   :containerdConfig
   {:privateRegistryAccessConfig
    {:enabled boolean,
     :certificateAuthorityDomainConfig
     [CertificateAuthorityDomainConfig]}},
   :fastSocket {:enabled boolean},
   :metadata object,
   :spot boolean,
   :windowsNodeConfig
   {:osVersion
    [OS_VERSION_UNSPECIFIED OS_VERSION_LTSC2019 OS_VERSION_LTSC2022]},
   :accelerators
   [{:acceleratorCount string,
     :acceleratorType string,
     :gpuPartitionSize string,
     :gpuSharingConfig
     {:maxSharedClientsPerGpu string,
      :gpuSharingStrategy
      [GPU_SHARING_STRATEGY_UNSPECIFIED TIME_SHARING MPS]},
     :gpuDriverInstallationConfig
     {:gpuDriverVersion
      [GPU_DRIVER_VERSION_UNSPECIFIED
       INSTALLATION_DISABLED
       DEFAULT
       LATEST]}}],
   :gvnic {:enabled boolean},
   :minCpuPlatform string},
  :masterAuthorizedNetworksConfig
  {:enabled boolean,
   :cidrBlocks [{:displayName string, :cidrBlock string}],
   :gcpPublicCidrsAccessEnabled boolean},
  :satisfiesPzi boolean,
  :zone string,
  :databaseEncryption
  {:keyName string,
   :state [UNKNOWN ENCRYPTED DECRYPTED],
   :currentState
   [CURRENT_STATE_UNSPECIFIED
    CURRENT_STATE_ENCRYPTED
    CURRENT_STATE_DECRYPTED
    CURRENT_STATE_ENCRYPTION_PENDING
    CURRENT_STATE_ENCRYPTION_ERROR
    CURRENT_STATE_DECRYPTION_PENDING
    CURRENT_STATE_DECRYPTION_ERROR],
   :decryptionKeys [string],
   :lastOperationErrors
   [{:keyName string, :errorMessage string, :timestamp string}]},
  :masterAuth
  {:username string,
   :password string,
   :clientCertificateConfig {:issueClientCertificate boolean},
   :clusterCaCertificate string,
   :clientCertificate string,
   :clientKey string},
  :privateClusterConfig
  {:enablePrivateNodes boolean,
   :enablePrivateEndpoint boolean,
   :masterIpv4CidrBlock string,
   :privateEndpoint string,
   :publicEndpoint string,
   :peeringName string,
   :masterGlobalAccessConfig {:enabled boolean},
   :privateEndpointSubnetwork string},
  :loggingService string,
  :name string,
  :shieldedNodes {:enabled boolean},
  :initialClusterVersion string,
  :binaryAuthorization
  {:enabled boolean,
   :evaluationMode
   [EVALUATION_MODE_UNSPECIFIED
    DISABLED
    PROJECT_SINGLETON_POLICY_ENFORCE]},
  :statusMessage string,
  :defaultMaxPodsConstraint {:maxPodsPerNode string},
  :createTime string,
  :enableK8sBetaApis {:enabledApis [string]},
  :resourceUsageExportConfig
  {:bigqueryDestination {:datasetId string},
   :enableNetworkEgressMetering boolean,
   :consumptionMeteringConfig {:enabled boolean}},
  :selfLink string,
  :nodeIpv4CidrSize integer,
  :etag string,
  :networkConfig
  {:enableMultiNetworking boolean,
   :defaultSnatStatus {:disabled boolean},
   :enableIntraNodeVisibility boolean,
   :enableL4ilbSubsetting boolean,
   :datapathProvider
   [DATAPATH_PROVIDER_UNSPECIFIED LEGACY_DATAPATH ADVANCED_DATAPATH],
   :enableCiliumClusterwideNetworkPolicy boolean,
   :inTransitEncryptionConfig
   [IN_TRANSIT_ENCRYPTION_CONFIG_UNSPECIFIED
    IN_TRANSIT_ENCRYPTION_DISABLED
    IN_TRANSIT_ENCRYPTION_INTER_NODE_TRANSPARENT],
   :privateIpv6GoogleAccess
   [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
    PRIVATE_IPV6_GOOGLE_ACCESS_DISABLED
    PRIVATE_IPV6_GOOGLE_ACCESS_TO_GOOGLE
    PRIVATE_IPV6_GOOGLE_ACCESS_BIDIRECTIONAL],
   :dnsConfig
   {:clusterDns
    [PROVIDER_UNSPECIFIED PLATFORM_DEFAULT CLOUD_DNS KUBE_DNS],
    :clusterDnsScope [DNS_SCOPE_UNSPECIFIED CLUSTER_SCOPE VPC_SCOPE],
    :clusterDnsDomain string,
    :additiveVpcScopeDnsDomain string},
   :gatewayApiConfig
   {:channel
    [CHANNEL_UNSPECIFIED
     CHANNEL_DISABLED
     CHANNEL_EXPERIMENTAL
     CHANNEL_STANDARD]},
   :serviceExternalIpsConfig {:enabled boolean},
   :networkPerformanceConfig
   {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
   :enableFqdnNetworkPolicy boolean,
   :network string,
   :subnetwork string},
  :legacyAbac {:enabled boolean},
  :nodePools
  [{:instanceGroupUrls [string],
    :maxPodsConstraint {:maxPodsPerNode string},
    :podIpv4CidrSize integer,
    :autoscaling
    {:enabled boolean,
     :minNodeCount integer,
     :maxNodeCount integer,
     :autoprovisioned boolean,
     :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
     :totalMinNodeCount integer,
     :totalMaxNodeCount integer},
    :config
    {:serviceAccount string,
     :tags [string],
     :labels object,
     :taints
     [{:key string,
       :value string,
       :effect
       [EFFECT_UNSPECIFIED
        NO_SCHEDULE
        PREFER_NO_SCHEDULE
        NO_EXECUTE]}],
     :ephemeralStorageLocalSsdConfig {:localSsdCount integer},
     :preemptible boolean,
     :shieldedInstanceConfig
     {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
     :loggingConfig {:variantConfig LoggingVariantConfig},
     :bootDiskKmsKey string,
     :sandboxConfig {:type [UNSPECIFIED GVISOR]},
     :soleTenantConfig {:nodeAffinities [NodeAffinity]},
     :localSsdCount integer,
     :nodeGroup string,
     :resourceManagerTags {:tags object},
     :secondaryBootDisks
     [{:mode [MODE_UNSPECIFIED CONTAINER_IMAGE_CACHE],
       :diskImage string}],
     :imageType string,
     :machineType string,
     :linuxNodeConfig
     {:sysctls object,
      :cgroupMode
      [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
      :hugepages HugepagesConfig},
     :kubeletConfig
     {:cpuManagerPolicy string,
      :cpuCfsQuota boolean,
      :cpuCfsQuotaPeriod string,
      :podPidsLimit string,
      :insecureKubeletReadonlyPortEnabled boolean},
     :secondaryBootDiskUpdateStrategy object,
     :oauthScopes [string],
     :confidentialNodes {:enabled boolean},
     :resourceLabels object,
     :enableConfidentialStorage boolean,
     :diskType string,
     :advancedMachineFeatures
     {:threadsPerCore string, :enableNestedVirtualization boolean},
     :localNvmeSsdBlockConfig {:localSsdCount integer},
     :diskSizeGb integer,
     :reservationAffinity
     {:consumeReservationType
      [UNSPECIFIED
       NO_RESERVATION
       ANY_RESERVATION
       SPECIFIC_RESERVATION],
      :key string,
      :values [string]},
     :gcfsConfig {:enabled boolean},
     :workloadMetadataConfig
     {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
     :containerdConfig
     {:privateRegistryAccessConfig PrivateRegistryAccessConfig},
     :fastSocket {:enabled boolean},
     :metadata object,
     :spot boolean,
     :windowsNodeConfig
     {:osVersion
      [OS_VERSION_UNSPECIFIED
       OS_VERSION_LTSC2019
       OS_VERSION_LTSC2022]},
     :accelerators
     [{:acceleratorCount string,
       :acceleratorType string,
       :gpuPartitionSize string,
       :gpuSharingConfig GPUSharingConfig,
       :gpuDriverInstallationConfig GPUDriverInstallationConfig}],
     :gvnic {:enabled boolean},
     :minCpuPlatform string},
    :placementPolicy
    {:type [TYPE_UNSPECIFIED COMPACT],
     :tpuTopology string,
     :policyName string},
    :name string,
    :statusMessage string,
    :selfLink string,
    :etag string,
    :networkConfig
    {:createPodRange boolean,
     :additionalPodNetworkConfigs
     [{:subnetwork string,
       :secondaryPodRange string,
       :maxPodsPerNode MaxPodsConstraint}],
     :podRange string,
     :networkPerformanceConfig
     {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
     :podCidrOverprovisionConfig {:disable boolean},
     :podIpv4RangeUtilization number,
     :enablePrivateNodes boolean,
     :podIpv4CidrBlock string,
     :additionalNodeNetworkConfigs
     [{:network string, :subnetwork string}]},
    :locations [string],
    :initialNodeCount integer,
    :conditions
    [{:code
      [UNKNOWN
       GCE_STOCKOUT
       GKE_SERVICE_ACCOUNT_DELETED
       GCE_QUOTA_EXCEEDED
       SET_BY_OPERATOR
       CLOUD_KMS_KEY_ERROR
       CA_EXPIRING],
      :message string,
      :canonicalCode
      [OK
       CANCELLED
       UNKNOWN
       INVALID_ARGUMENT
       DEADLINE_EXCEEDED
       NOT_FOUND
       ALREADY_EXISTS
       PERMISSION_DENIED
       UNAUTHENTICATED
       RESOURCE_EXHAUSTED
       FAILED_PRECONDITION
       ABORTED
       OUT_OF_RANGE
       UNIMPLEMENTED
       INTERNAL
       UNAVAILABLE
       DATA_LOSS]}],
    :updateInfo
    {:blueGreenInfo
     {:phase
      [PHASE_UNSPECIFIED
       UPDATE_STARTED
       CREATING_GREEN_POOL
       CORDONING_BLUE_POOL
       DRAINING_BLUE_POOL
       NODE_POOL_SOAKING
       DELETING_BLUE_POOL
       ROLLBACK_STARTED],
      :blueInstanceGroupUrls [string],
      :greenInstanceGroupUrls [string],
      :bluePoolDeletionStartTime string,
      :greenPoolVersion string}},
    :status
    [STATUS_UNSPECIFIED
     PROVISIONING
     RUNNING
     RUNNING_WITH_ERROR
     RECONCILING
     STOPPING
     ERROR],
    :queuedProvisioning {:enabled boolean},
    :version string,
    :bestEffortProvisioning
    {:enabled boolean, :minProvisionNodes integer},
    :management
    {:autoUpgrade boolean,
     :autoRepair boolean,
     :upgradeOptions
     {:autoUpgradeStartTime string, :description string}},
    :upgradeSettings
    {:maxSurge integer,
     :maxUnavailable integer,
     :strategy
     [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
     :blueGreenSettings
     {:standardRolloutPolicy StandardRolloutPolicy,
      :nodePoolSoakDuration string}}}],
  :releaseChannel {:channel [UNSPECIFIED RAPID REGULAR STABLE]},
  :maintenancePolicy
  {:window
   {:dailyMaintenanceWindow {:startTime string, :duration string},
    :recurringWindow {:window TimeWindow, :recurrence string},
    :maintenanceExclusions object},
   :resourceVersion string},
  :locations [string],
  :clusterIpv4Cidr string,
  :costManagementConfig {:enabled boolean},
  :currentNodeVersion string,
  :confidentialNodes {:enabled boolean},
  :fleet {:project string, :membership string, :preRegistered boolean},
  :initialNodeCount integer,
  :conditions
  [{:code
    [UNKNOWN
     GCE_STOCKOUT
     GKE_SERVICE_ACCOUNT_DELETED
     GCE_QUOTA_EXCEEDED
     SET_BY_OPERATOR
     CLOUD_KMS_KEY_ERROR
     CA_EXPIRING],
    :message string,
    :canonicalCode
    [OK
     CANCELLED
     UNKNOWN
     INVALID_ARGUMENT
     DEADLINE_EXCEEDED
     NOT_FOUND
     ALREADY_EXISTS
     PERMISSION_DENIED
     UNAUTHENTICATED
     RESOURCE_EXHAUSTED
     FAILED_PRECONDITION
     ABORTED
     OUT_OF_RANGE
     UNIMPLEMENTED
     INTERNAL
     UNAVAILABLE
     DATA_LOSS]}],
  :resourceLabels object,
  :satisfiesPzs boolean,
  :securityPostureConfig
  {:mode [MODE_UNSPECIFIED DISABLED BASIC ENTERPRISE],
   :vulnerabilityMode
   [VULNERABILITY_MODE_UNSPECIFIED
    VULNERABILITY_DISABLED
    VULNERABILITY_BASIC
    VULNERABILITY_ENTERPRISE]},
  :status
  [STATUS_UNSPECIFIED
   PROVISIONING
   RUNNING
   RECONCILING
   STOPPING
   ERROR
   DEGRADED],
  :id string,
  :notificationConfig
  {:pubsub
   {:enabled boolean,
    :topic string,
    :filter
    {:eventType
     [[EVENT_TYPE_UNSPECIFIED
       UPGRADE_AVAILABLE_EVENT
       UPGRADE_EVENT
       SECURITY_BULLETIN_EVENT]]}}},
  :currentMasterVersion string,
  :nodePoolDefaults
  {:nodeConfigDefaults
   {:gcfsConfig {:enabled boolean},
    :loggingConfig {:variantConfig LoggingVariantConfig},
    :containerdConfig
    {:privateRegistryAccessConfig PrivateRegistryAccessConfig},
    :nodeKubeletConfig
    {:cpuManagerPolicy string,
     :cpuCfsQuota boolean,
     :cpuCfsQuotaPeriod string,
     :podPidsLimit string,
     :insecureKubeletReadonlyPortEnabled boolean}}},
  :authenticatorGroupsConfig {:enabled boolean, :securityGroup string},
  :identityServiceConfig {:enabled boolean},
  :workloadIdentityConfig {:workloadPool string},
  :expireTime string,
  :monitoringService string,
  :network string,
  :addonsConfig
  {:gcePersistentDiskCsiDriverConfig {:enabled boolean},
   :configConnectorConfig {:enabled boolean},
   :statefulHaConfig {:enabled boolean},
   :gkeBackupAgentConfig {:enabled boolean},
   :cloudRunConfig
   {:disabled boolean,
    :loadBalancerType
    [LOAD_BALANCER_TYPE_UNSPECIFIED
     LOAD_BALANCER_TYPE_EXTERNAL
     LOAD_BALANCER_TYPE_INTERNAL]},
   :networkPolicyConfig {:disabled boolean},
   :gcsFuseCsiDriverConfig {:enabled boolean},
   :httpLoadBalancing {:disabled boolean},
   :kubernetesDashboard {:disabled boolean},
   :dnsCacheConfig {:enabled boolean},
   :gcpFilestoreCsiDriverConfig {:enabled boolean},
   :horizontalPodAutoscaling {:disabled boolean}},
  :enterpriseConfig
  {:clusterTier [CLUSTER_TIER_UNSPECIFIED STANDARD ENTERPRISE]},
  :servicesIpv4Cidr string,
  :location string,
  :endpoint string,
  :enableTpu boolean,
  :subnetwork string,
  :labelFingerprint string,
  :ipAllocationPolicy
  {:clusterSecondaryRangeName string,
   :tpuIpv4CidrBlock string,
   :nodeIpv4Cidr string,
   :nodeIpv4CidrBlock string,
   :ipv6AccessType [IPV6_ACCESS_TYPE_UNSPECIFIED INTERNAL EXTERNAL],
   :stackType [STACK_TYPE_UNSPECIFIED IPV4 IPV4_IPV6],
   :useIpAliases boolean,
   :servicesIpv4CidrBlock string,
   :defaultPodIpv4RangeUtilization number,
   :additionalPodRangesConfig
   {:podRangeNames [string],
    :podRangeInfo [{:rangeName string, :utilization number}]},
   :podCidrOverprovisionConfig {:disable boolean},
   :clusterIpv4CidrBlock string,
   :clusterIpv4Cidr string,
   :subnetworkName string,
   :createSubnetwork boolean,
   :useRoutes boolean,
   :servicesIpv4Cidr string,
   :servicesSecondaryRangeName string,
   :subnetIpv6CidrBlock string,
   :servicesIpv6CidrBlock string}},
 :parent string}"
  [parent CreateClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+parent}/clusters",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateClusterRequest}))

(defn projects-locations-clusters-setAddons
  "Sets the addons for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setAddons

name <string> The name (project, location, cluster) of the cluster to set addons. Specified in the format `projects/*/locations/*/clusters/*`.
SetAddonsConfigRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :addonsConfig
 {:gcePersistentDiskCsiDriverConfig {:enabled boolean},
  :configConnectorConfig {:enabled boolean},
  :statefulHaConfig {:enabled boolean},
  :gkeBackupAgentConfig {:enabled boolean},
  :cloudRunConfig
  {:disabled boolean,
   :loadBalancerType
   [LOAD_BALANCER_TYPE_UNSPECIFIED
    LOAD_BALANCER_TYPE_EXTERNAL
    LOAD_BALANCER_TYPE_INTERNAL]},
  :networkPolicyConfig {:disabled boolean},
  :gcsFuseCsiDriverConfig {:enabled boolean},
  :httpLoadBalancing {:disabled boolean},
  :kubernetesDashboard {:disabled boolean},
  :dnsCacheConfig {:enabled boolean},
  :gcpFilestoreCsiDriverConfig {:enabled boolean},
  :horizontalPodAutoscaling {:disabled boolean}},
 :name string}"
  [name SetAddonsConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setAddons",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetAddonsConfigRequest}))

(defn projects-locations-clusters-update
  "Updates the settings of a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/update

name <string> The name (project, location, cluster) of the cluster to update. Specified in the format `projects/*/locations/*/clusters/*`.
UpdateClusterRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :update
 {:desiredIntraNodeVisibilityConfig {:enabled boolean},
  :desiredNodePoolAutoConfigResourceManagerTags {:tags object},
  :desiredBinaryAuthorization
  {:enabled boolean,
   :evaluationMode
   [EVALUATION_MODE_UNSPECIFIED
    DISABLED
    PROJECT_SINGLETON_POLICY_ENFORCE]},
  :desiredDefaultSnatStatus {:disabled boolean},
  :desiredDatabaseEncryption
  {:keyName string,
   :state [UNKNOWN ENCRYPTED DECRYPTED],
   :currentState
   [CURRENT_STATE_UNSPECIFIED
    CURRENT_STATE_ENCRYPTED
    CURRENT_STATE_DECRYPTED
    CURRENT_STATE_ENCRYPTION_PENDING
    CURRENT_STATE_ENCRYPTION_ERROR
    CURRENT_STATE_DECRYPTION_PENDING
    CURRENT_STATE_DECRYPTION_ERROR],
   :decryptionKeys [string],
   :lastOperationErrors
   [{:keyName string, :errorMessage string, :timestamp string}]},
  :desiredAddonsConfig
  {:gcePersistentDiskCsiDriverConfig {:enabled boolean},
   :configConnectorConfig {:enabled boolean},
   :statefulHaConfig {:enabled boolean},
   :gkeBackupAgentConfig {:enabled boolean},
   :cloudRunConfig
   {:disabled boolean,
    :loadBalancerType
    [LOAD_BALANCER_TYPE_UNSPECIFIED
     LOAD_BALANCER_TYPE_EXTERNAL
     LOAD_BALANCER_TYPE_INTERNAL]},
   :networkPolicyConfig {:disabled boolean},
   :gcsFuseCsiDriverConfig {:enabled boolean},
   :httpLoadBalancing {:disabled boolean},
   :kubernetesDashboard {:disabled boolean},
   :dnsCacheConfig {:enabled boolean},
   :gcpFilestoreCsiDriverConfig {:enabled boolean},
   :horizontalPodAutoscaling {:disabled boolean}},
  :desiredK8sBetaApis {:enabledApis [string]},
  :desiredEnableMultiNetworking boolean,
  :desiredStackType [STACK_TYPE_UNSPECIFIED IPV4 IPV4_IPV6],
  :desiredEnableCiliumClusterwideNetworkPolicy boolean,
  :desiredNodePoolId string,
  :desiredMonitoringConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER
      STORAGE
      HPA
      POD
      DAEMONSET
      DEPLOYMENT
      STATEFULSET
      CADVISOR
      KUBELET]]},
   :managedPrometheusConfig {:enabled boolean},
   :advancedDatapathObservabilityConfig
   {:enableMetrics boolean,
    :relayMode
    [RELAY_MODE_UNSPECIFIED DISABLED INTERNAL_VPC_LB EXTERNAL_LB],
    :enableRelay boolean}},
  :desiredLocations [string],
  :desiredLoggingConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      WORKLOADS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER]]}},
  :desiredFleet
  {:project string, :membership string, :preRegistered boolean},
  :desiredResourceUsageExportConfig
  {:bigqueryDestination {:datasetId string},
   :enableNetworkEgressMetering boolean,
   :consumptionMeteringConfig {:enabled boolean}},
  :enableK8sBetaApis {:enabledApis [string]},
  :desiredAuthenticatorGroupsConfig
  {:enabled boolean, :securityGroup string},
  :desiredGatewayApiConfig
  {:channel
   [CHANNEL_UNSPECIFIED
    CHANNEL_DISABLED
    CHANNEL_EXPERIMENTAL
    CHANNEL_STANDARD]},
  :desiredIdentityServiceConfig {:enabled boolean},
  :desiredMeshCertificates {:enableCertificates boolean},
  :etag string,
  :desiredImageType string,
  :desiredLoggingService string,
  :desiredNodePoolAutoscaling
  {:enabled boolean,
   :minNodeCount integer,
   :maxNodeCount integer,
   :autoprovisioned boolean,
   :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
   :totalMinNodeCount integer,
   :totalMaxNodeCount integer},
  :desiredNodeVersion string,
  :additionalPodRangesConfig
  {:podRangeNames [string],
   :podRangeInfo [{:rangeName string, :utilization number}]},
  :desiredDnsConfig
  {:clusterDns
   [PROVIDER_UNSPECIFIED PLATFORM_DEFAULT CLOUD_DNS KUBE_DNS],
   :clusterDnsScope [DNS_SCOPE_UNSPECIFIED CLUSTER_SCOPE VPC_SCOPE],
   :clusterDnsDomain string,
   :additiveVpcScopeDnsDomain string},
  :desiredParentProductConfig {:productName string, :labels object},
  :desiredPrivateClusterConfig
  {:enablePrivateNodes boolean,
   :enablePrivateEndpoint boolean,
   :masterIpv4CidrBlock string,
   :privateEndpoint string,
   :publicEndpoint string,
   :peeringName string,
   :masterGlobalAccessConfig {:enabled boolean},
   :privateEndpointSubnetwork string},
  :desiredGcfsConfig {:enabled boolean},
  :desiredDatapathProvider
  [DATAPATH_PROVIDER_UNSPECIFIED LEGACY_DATAPATH ADVANCED_DATAPATH],
  :desiredNodePoolAutoConfigNetworkTags {:tags [string]},
  :desiredReleaseChannel {:channel [UNSPECIFIED RAPID REGULAR STABLE]},
  :desiredSecurityPostureConfig
  {:mode [MODE_UNSPECIFIED DISABLED BASIC ENTERPRISE],
   :vulnerabilityMode
   [VULNERABILITY_MODE_UNSPECIFIED
    VULNERABILITY_DISABLED
    VULNERABILITY_BASIC
    VULNERABILITY_ENTERPRISE]},
  :desiredContainerdConfig
  {:privateRegistryAccessConfig
   {:enabled boolean,
    :certificateAuthorityDomainConfig
    [{:fqdns [string],
      :gcpSecretManagerCertificateConfig
      GCPSecretManagerCertificateConfig}]}},
  :desiredEnableFqdnNetworkPolicy boolean,
  :removedAdditionalPodRangesConfig
  {:podRangeNames [string],
   :podRangeInfo [{:rangeName string, :utilization number}]},
  :desiredCostManagementConfig {:enabled boolean},
  :desiredWorkloadIdentityConfig {:workloadPool string},
  :desiredNetworkPerformanceConfig
  {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
  :desiredL4ilbSubsettingConfig {:enabled boolean},
  :desiredPrivateIpv6GoogleAccess
  [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
   PRIVATE_IPV6_GOOGLE_ACCESS_DISABLED
   PRIVATE_IPV6_GOOGLE_ACCESS_TO_GOOGLE
   PRIVATE_IPV6_GOOGLE_ACCESS_BIDIRECTIONAL],
  :desiredNodePoolAutoConfigKubeletConfig
  {:cpuManagerPolicy string,
   :cpuCfsQuota boolean,
   :cpuCfsQuotaPeriod string,
   :podPidsLimit string,
   :insecureKubeletReadonlyPortEnabled boolean},
  :desiredServiceExternalIpsConfig {:enabled boolean},
  :desiredEnablePrivateEndpoint boolean,
  :desiredMonitoringService string,
  :desiredShieldedNodes {:enabled boolean},
  :desiredAutopilotWorkloadPolicyConfig {:allowNetAdmin boolean},
  :desiredNodeKubeletConfig
  {:cpuManagerPolicy string,
   :cpuCfsQuota boolean,
   :cpuCfsQuotaPeriod string,
   :podPidsLimit string,
   :insecureKubeletReadonlyPortEnabled boolean},
  :desiredInTransitEncryptionConfig
  [IN_TRANSIT_ENCRYPTION_CONFIG_UNSPECIFIED
   IN_TRANSIT_ENCRYPTION_DISABLED
   IN_TRANSIT_ENCRYPTION_INTER_NODE_TRANSPARENT],
  :desiredNodePoolLoggingConfig
  {:variantConfig
   {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
  :desiredMasterVersion string,
  :desiredClusterAutoscaling
  {:enableNodeAutoprovisioning boolean,
   :resourceLimits
   [{:resourceType string, :minimum string, :maximum string}],
   :autoscalingProfile
   [PROFILE_UNSPECIFIED OPTIMIZE_UTILIZATION BALANCED],
   :autoprovisioningNodePoolDefaults
   {:serviceAccount string,
    :shieldedInstanceConfig
    {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
    :bootDiskKmsKey string,
    :imageType string,
    :oauthScopes [string],
    :diskType string,
    :diskSizeGb integer,
    :insecureKubeletReadonlyPortEnabled boolean,
    :management
    {:autoUpgrade boolean,
     :autoRepair boolean,
     :upgradeOptions AutoUpgradeOptions},
    :upgradeSettings
    {:maxSurge integer,
     :maxUnavailable integer,
     :strategy
     [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
     :blueGreenSettings BlueGreenSettings},
    :minCpuPlatform string},
   :autoprovisioningLocations [string]},
  :desiredNotificationConfig
  {:pubsub
   {:enabled boolean,
    :topic string,
    :filter
    {:eventType
     [[EVENT_TYPE_UNSPECIFIED
       UPGRADE_AVAILABLE_EVENT
       UPGRADE_EVENT
       SECURITY_BULLETIN_EVENT]]}}},
  :desiredMasterAuthorizedNetworksConfig
  {:enabled boolean,
   :cidrBlocks [{:displayName string, :cidrBlock string}],
   :gcpPublicCidrsAccessEnabled boolean},
  :desiredVerticalPodAutoscaling {:enabled boolean}},
 :name string}"
  [name UpdateClusterRequest]
  (client/api-request
    {:method "PUT",
     :uri-template "https://container.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpdateClusterRequest}))

(defn projects-locations-clusters-delete
  "Deletes the cluster, including the Kubernetes endpoint and all worker nodes. Firewalls and routes that were configured during cluster creation are also deleted. Other Google Compute Engine resources that might be in use by the cluster, such as load balancer resources, are not deleted if they weren't present when the cluster was initially created.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/delete

name <string> The name (project, location, cluster) of the cluster to delete. Specified in the format `projects/*/locations/*/clusters/*`.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to delete. This field has been deprecated and replaced by the name field."
  ([name] (projects-locations-clusters-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://container.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-setLogging
  "Sets the logging service for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setLogging

name <string> The name (project, location, cluster) of the cluster to set logging. Specified in the format `projects/*/locations/*/clusters/*`.
SetLoggingServiceRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :loggingService string,
 :name string}"
  [name SetLoggingServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setLogging",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLoggingServiceRequest}))

(defn projects-locations-clusters-setMasterAuth
  "Sets master auth materials. Currently supports changing the admin password or a specific cluster, either via password generation or explicitly setting the password.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setMasterAuth

name <string> The name (project, location, cluster) of the cluster to set auth. Specified in the format `projects/*/locations/*/clusters/*`.
SetMasterAuthRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :action [UNKNOWN SET_PASSWORD GENERATE_PASSWORD SET_USERNAME],
 :update
 {:username string,
  :password string,
  :clientCertificateConfig {:issueClientCertificate boolean},
  :clusterCaCertificate string,
  :clientCertificate string,
  :clientKey string},
 :name string}"
  [name SetMasterAuthRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setMasterAuth",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMasterAuthRequest}))

(defn projects-locations-clusters-list
  "Lists all clusters owned by a project in either the specified zone or all zones.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/list

parent <string> The parent (project and location) where the clusters will be listed. Specified in the format `projects/*/locations/*`. Location \"-\" matches all zones and all regions.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides, or \"-\" for all zones. This field has been deprecated and replaced by the parent field."
  ([parent] (projects-locations-clusters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-checkAutopilotCompatibility
  "Checks the cluster compatibility with Autopilot mode, and returns a list of compatibility issues.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/checkAutopilotCompatibility

name <string> The name (project, location, cluster) of the cluster to retrieve. Specified in the format `projects/*/locations/*/clusters/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:checkAutopilotCompatibility",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-clusters-setNetworkPolicy
  "Enables or disables Network Policy for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setNetworkPolicy

name <string> The name (project, location, cluster name) of the cluster to set networking policy. Specified in the format `projects/*/locations/*/clusters/*`.
SetNetworkPolicyRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :networkPolicy
 {:provider [PROVIDER_UNSPECIFIED CALICO], :enabled boolean},
 :name string}"
  [name SetNetworkPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setNetworkPolicy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNetworkPolicyRequest}))

(defn projects-locations-clusters-setMonitoring
  "Sets the monitoring service for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setMonitoring

name <string> The name (project, location, cluster) of the cluster to set monitoring. Specified in the format `projects/*/locations/*/clusters/*`.
SetMonitoringServiceRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :monitoringService string,
 :name string}"
  [name SetMonitoringServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setMonitoring",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMonitoringServiceRequest}))

(defn projects-locations-clusters-startIpRotation
  "Starts master IP rotation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/startIpRotation

name <string> The name (project, location, cluster name) of the cluster to start IP rotation. Specified in the format `projects/*/locations/*/clusters/*`.
StartIPRotationRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :name string,
 :rotateCredentials boolean}"
  [name StartIPRotationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:startIpRotation",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartIPRotationRequest}))

(defn projects-locations-clusters-completeIpRotation
  "Completes master IP rotation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/completeIpRotation

name <string> The name (project, location, cluster name) of the cluster to complete IP rotation. Specified in the format `projects/*/locations/*/clusters/*`.
CompleteIPRotationRequest:
{:projectId string, :zone string, :clusterId string, :name string}"
  [name CompleteIPRotationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:completeIpRotation",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CompleteIPRotationRequest}))

(defn projects-locations-clusters-setLocations
  "Sets the locations for a specific cluster. Deprecated. Use [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update) instead.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setLocations

name <string> The name (project, location, cluster) of the cluster to set locations. Specified in the format `projects/*/locations/*/clusters/*`.
SetLocationsRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :locations [string],
 :name string}"
  [name SetLocationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setLocations",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLocationsRequest}))

(defn projects-locations-clusters-setLegacyAbac
  "Enables or disables the ABAC authorization mechanism on a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setLegacyAbac

name <string> The name (project, location, cluster name) of the cluster to set legacy abac. Specified in the format `projects/*/locations/*/clusters/*`.
SetLegacyAbacRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :enabled boolean,
 :name string}"
  [name SetLegacyAbacRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setLegacyAbac",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLegacyAbacRequest}))

(defn projects-locations-clusters-setMaintenancePolicy
  "Sets the maintenance policy for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters/setMaintenancePolicy

name <string> The name (project, location, cluster name) of the cluster to set maintenance policy. Specified in the format `projects/*/locations/*/clusters/*`.
SetMaintenancePolicyRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :maintenancePolicy
 {:window
  {:dailyMaintenanceWindow {:startTime string, :duration string},
   :recurringWindow
   {:window
    {:maintenanceExclusionOptions MaintenanceExclusionOptions,
     :startTime string,
     :endTime string},
    :recurrence string},
   :maintenanceExclusions object},
  :resourceVersion string},
 :name string}"
  [name SetMaintenancePolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setMaintenancePolicy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMaintenancePolicyRequest}))

(defn projects-locations-clusters-nodePools-rollback
  "Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last upgrade successfully completed.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/rollback

name <string> The name (project, location, cluster, node pool id) of the node poll to rollback upgrade. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.
RollbackNodePoolUpgradeRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :name string,
 :respectPdb boolean}"
  [name RollbackNodePoolUpgradeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:rollback",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RollbackNodePoolUpgradeRequest}))

(defn projects-locations-clusters-nodePools-get
  "Retrieves the requested node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/get

name <string> The name (project, location, cluster, node pool id) of the node pool to get. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool. This field has been deprecated and replaced by the name field."
  ([name] (projects-locations-clusters-nodePools-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://container.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-nodePools-create
  "Creates a node pool for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/create

parent <string> The parent (project, location, cluster name) where the node pool will be created. Specified in the format `projects/*/locations/*/clusters/*`.
CreateNodePoolRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePool
 {:instanceGroupUrls [string],
  :maxPodsConstraint {:maxPodsPerNode string},
  :podIpv4CidrSize integer,
  :autoscaling
  {:enabled boolean,
   :minNodeCount integer,
   :maxNodeCount integer,
   :autoprovisioned boolean,
   :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
   :totalMinNodeCount integer,
   :totalMaxNodeCount integer},
  :config
  {:serviceAccount string,
   :tags [string],
   :labels object,
   :taints
   [{:key string,
     :value string,
     :effect
     [EFFECT_UNSPECIFIED NO_SCHEDULE PREFER_NO_SCHEDULE NO_EXECUTE]}],
   :ephemeralStorageLocalSsdConfig {:localSsdCount integer},
   :preemptible boolean,
   :shieldedInstanceConfig
   {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
   :loggingConfig
   {:variantConfig
    {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
   :bootDiskKmsKey string,
   :sandboxConfig {:type [UNSPECIFIED GVISOR]},
   :soleTenantConfig
   {:nodeAffinities
    [{:key string,
      :operator [OPERATOR_UNSPECIFIED IN NOT_IN],
      :values [string]}]},
   :localSsdCount integer,
   :nodeGroup string,
   :resourceManagerTags {:tags object},
   :secondaryBootDisks
   [{:mode [MODE_UNSPECIFIED CONTAINER_IMAGE_CACHE],
     :diskImage string}],
   :imageType string,
   :machineType string,
   :linuxNodeConfig
   {:sysctls object,
    :cgroupMode
    [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
    :hugepages {:hugepageSize2m integer, :hugepageSize1g integer}},
   :kubeletConfig
   {:cpuManagerPolicy string,
    :cpuCfsQuota boolean,
    :cpuCfsQuotaPeriod string,
    :podPidsLimit string,
    :insecureKubeletReadonlyPortEnabled boolean},
   :secondaryBootDiskUpdateStrategy object,
   :oauthScopes [string],
   :confidentialNodes {:enabled boolean},
   :resourceLabels object,
   :enableConfidentialStorage boolean,
   :diskType string,
   :advancedMachineFeatures
   {:threadsPerCore string, :enableNestedVirtualization boolean},
   :localNvmeSsdBlockConfig {:localSsdCount integer},
   :diskSizeGb integer,
   :reservationAffinity
   {:consumeReservationType
    [UNSPECIFIED NO_RESERVATION ANY_RESERVATION SPECIFIC_RESERVATION],
    :key string,
    :values [string]},
   :gcfsConfig {:enabled boolean},
   :workloadMetadataConfig
   {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
   :containerdConfig
   {:privateRegistryAccessConfig
    {:enabled boolean,
     :certificateAuthorityDomainConfig
     [CertificateAuthorityDomainConfig]}},
   :fastSocket {:enabled boolean},
   :metadata object,
   :spot boolean,
   :windowsNodeConfig
   {:osVersion
    [OS_VERSION_UNSPECIFIED OS_VERSION_LTSC2019 OS_VERSION_LTSC2022]},
   :accelerators
   [{:acceleratorCount string,
     :acceleratorType string,
     :gpuPartitionSize string,
     :gpuSharingConfig
     {:maxSharedClientsPerGpu string,
      :gpuSharingStrategy
      [GPU_SHARING_STRATEGY_UNSPECIFIED TIME_SHARING MPS]},
     :gpuDriverInstallationConfig
     {:gpuDriverVersion
      [GPU_DRIVER_VERSION_UNSPECIFIED
       INSTALLATION_DISABLED
       DEFAULT
       LATEST]}}],
   :gvnic {:enabled boolean},
   :minCpuPlatform string},
  :placementPolicy
  {:type [TYPE_UNSPECIFIED COMPACT],
   :tpuTopology string,
   :policyName string},
  :name string,
  :statusMessage string,
  :selfLink string,
  :etag string,
  :networkConfig
  {:createPodRange boolean,
   :additionalPodNetworkConfigs
   [{:subnetwork string,
     :secondaryPodRange string,
     :maxPodsPerNode {:maxPodsPerNode string}}],
   :podRange string,
   :networkPerformanceConfig
   {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
   :podCidrOverprovisionConfig {:disable boolean},
   :podIpv4RangeUtilization number,
   :enablePrivateNodes boolean,
   :podIpv4CidrBlock string,
   :additionalNodeNetworkConfigs
   [{:network string, :subnetwork string}]},
  :locations [string],
  :initialNodeCount integer,
  :conditions
  [{:code
    [UNKNOWN
     GCE_STOCKOUT
     GKE_SERVICE_ACCOUNT_DELETED
     GCE_QUOTA_EXCEEDED
     SET_BY_OPERATOR
     CLOUD_KMS_KEY_ERROR
     CA_EXPIRING],
    :message string,
    :canonicalCode
    [OK
     CANCELLED
     UNKNOWN
     INVALID_ARGUMENT
     DEADLINE_EXCEEDED
     NOT_FOUND
     ALREADY_EXISTS
     PERMISSION_DENIED
     UNAUTHENTICATED
     RESOURCE_EXHAUSTED
     FAILED_PRECONDITION
     ABORTED
     OUT_OF_RANGE
     UNIMPLEMENTED
     INTERNAL
     UNAVAILABLE
     DATA_LOSS]}],
  :updateInfo
  {:blueGreenInfo
   {:phase
    [PHASE_UNSPECIFIED
     UPDATE_STARTED
     CREATING_GREEN_POOL
     CORDONING_BLUE_POOL
     DRAINING_BLUE_POOL
     NODE_POOL_SOAKING
     DELETING_BLUE_POOL
     ROLLBACK_STARTED],
    :blueInstanceGroupUrls [string],
    :greenInstanceGroupUrls [string],
    :bluePoolDeletionStartTime string,
    :greenPoolVersion string}},
  :status
  [STATUS_UNSPECIFIED
   PROVISIONING
   RUNNING
   RUNNING_WITH_ERROR
   RECONCILING
   STOPPING
   ERROR],
  :queuedProvisioning {:enabled boolean},
  :version string,
  :bestEffortProvisioning
  {:enabled boolean, :minProvisionNodes integer},
  :management
  {:autoUpgrade boolean,
   :autoRepair boolean,
   :upgradeOptions
   {:autoUpgradeStartTime string, :description string}},
  :upgradeSettings
  {:maxSurge integer,
   :maxUnavailable integer,
   :strategy [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
   :blueGreenSettings
   {:standardRolloutPolicy
    {:batchPercentage number,
     :batchNodeCount integer,
     :batchSoakDuration string},
    :nodePoolSoakDuration string}}},
 :parent string}"
  [parent CreateNodePoolRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+parent}/nodePools",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateNodePoolRequest}))

(defn projects-locations-clusters-nodePools-setAutoscaling
  "Sets the autoscaling settings for the specified node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/setAutoscaling

name <string> The name (project, location, cluster, node pool) of the node pool to set autoscaler settings. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.
SetNodePoolAutoscalingRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :autoscaling
 {:enabled boolean,
  :minNodeCount integer,
  :maxNodeCount integer,
  :autoprovisioned boolean,
  :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
  :totalMinNodeCount integer,
  :totalMaxNodeCount integer},
 :name string}"
  [name SetNodePoolAutoscalingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setAutoscaling",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNodePoolAutoscalingRequest}))

(defn projects-locations-clusters-nodePools-setManagement
  "Sets the NodeManagement options for a node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/setManagement

name <string> The name (project, location, cluster, node pool id) of the node pool to set management properties. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.
SetNodePoolManagementRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :management
 {:autoUpgrade boolean,
  :autoRepair boolean,
  :upgradeOptions {:autoUpgradeStartTime string, :description string}},
 :name string}"
  [name SetNodePoolManagementRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setManagement",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNodePoolManagementRequest}))

(defn projects-locations-clusters-nodePools-completeUpgrade
  "CompleteNodePoolUpgrade will signal an on-going node pool upgrade to complete.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/completeUpgrade

name <string> The name (project, location, cluster, node pool id) of the node pool to complete upgrade. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.
CompleteNodePoolUpgradeRequest:
object"
  [name CompleteNodePoolUpgradeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:completeUpgrade",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CompleteNodePoolUpgradeRequest}))

(defn projects-locations-clusters-nodePools-update
  "Updates the version and/or image type for the specified node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/update

name <string> The name (project, location, cluster, node pool) of the node pool to update. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.
UpdateNodePoolRequest:
{:tags {:tags [string]},
 :labels {:labels object},
 :taints
 {:taints
  [{:key string,
    :value string,
    :effect
    [EFFECT_UNSPECIFIED NO_SCHEDULE PREFER_NO_SCHEDULE NO_EXECUTE]}]},
 :nodePoolId string,
 :loggingConfig
 {:variantConfig
  {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
 :zone string,
 :name string,
 :resourceManagerTags {:tags object},
 :clusterId string,
 :etag string,
 :imageType string,
 :machineType string,
 :linuxNodeConfig
 {:sysctls object,
  :cgroupMode [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
  :hugepages {:hugepageSize2m integer, :hugepageSize1g integer}},
 :kubeletConfig
 {:cpuManagerPolicy string,
  :cpuCfsQuota boolean,
  :cpuCfsQuotaPeriod string,
  :podPidsLimit string,
  :insecureKubeletReadonlyPortEnabled boolean},
 :locations [string],
 :confidentialNodes {:enabled boolean},
 :nodeNetworkConfig
 {:createPodRange boolean,
  :additionalPodNetworkConfigs
  [{:subnetwork string,
    :secondaryPodRange string,
    :maxPodsPerNode {:maxPodsPerNode string}}],
  :podRange string,
  :networkPerformanceConfig
  {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
  :podCidrOverprovisionConfig {:disable boolean},
  :podIpv4RangeUtilization number,
  :enablePrivateNodes boolean,
  :podIpv4CidrBlock string,
  :additionalNodeNetworkConfigs
  [{:network string, :subnetwork string}]},
 :resourceLabels {:labels object},
 :diskType string,
 :queuedProvisioning {:enabled boolean},
 :projectId string,
 :diskSizeGb string,
 :gcfsConfig {:enabled boolean},
 :workloadMetadataConfig
 {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
 :containerdConfig
 {:privateRegistryAccessConfig
  {:enabled boolean,
   :certificateAuthorityDomainConfig
   [{:fqdns [string],
     :gcpSecretManagerCertificateConfig {:secretUri string}}]}},
 :fastSocket {:enabled boolean},
 :windowsNodeConfig
 {:osVersion
  [OS_VERSION_UNSPECIFIED OS_VERSION_LTSC2019 OS_VERSION_LTSC2022]},
 :nodeVersion string,
 :accelerators
 [{:acceleratorCount string,
   :acceleratorType string,
   :gpuPartitionSize string,
   :gpuSharingConfig
   {:maxSharedClientsPerGpu string,
    :gpuSharingStrategy
    [GPU_SHARING_STRATEGY_UNSPECIFIED TIME_SHARING MPS]},
   :gpuDriverInstallationConfig
   {:gpuDriverVersion
    [GPU_DRIVER_VERSION_UNSPECIFIED
     INSTALLATION_DISABLED
     DEFAULT
     LATEST]}}],
 :gvnic {:enabled boolean},
 :upgradeSettings
 {:maxSurge integer,
  :maxUnavailable integer,
  :strategy [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
  :blueGreenSettings
  {:standardRolloutPolicy
   {:batchPercentage number,
    :batchNodeCount integer,
    :batchSoakDuration string},
   :nodePoolSoakDuration string}}}"
  [name UpdateNodePoolRequest]
  (client/api-request
    {:method "PUT",
     :uri-template "https://container.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpdateNodePoolRequest}))

(defn projects-locations-clusters-nodePools-delete
  "Deletes a node pool from a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/delete

name <string> The name (project, location, cluster, node pool id) of the node pool to delete. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool to delete. This field has been deprecated and replaced by the name field."
  ([name] (projects-locations-clusters-nodePools-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://container.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-nodePools-setSize
  "Sets the size for a specific node pool. The new size will be used for all replicas, including future replicas created by modifying NodePool.locations.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/setSize

name <string> The name (project, location, cluster, node pool id) of the node pool to set size. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`.
SetNodePoolSizeRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :nodeCount integer,
 :name string}"
  [name SetNodePoolSizeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:setSize",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNodePoolSizeRequest}))

(defn projects-locations-clusters-nodePools-list
  "Lists the node pools for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.nodePools/list

parent <string> The parent (project, location, cluster name) where the node pools will be listed. Specified in the format `projects/*/locations/*/clusters/*`.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the parent field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the parent field."
  ([parent] (projects-locations-clusters-nodePools-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/{+parent}/nodePools",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-well-known-getOpenid-configuration
  "Gets the OIDC discovery document for the cluster. See the [OpenID Connect Discovery 1.0 specification](https://openid.net/specs/openid-connect-discovery-1_0.html) for details.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.clusters.well-known/getOpenid-configuration

parent <string> The cluster (project, location, cluster name) to get the discovery document for. Specified in the format `projects/*/locations/*/clusters/*`."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://container.googleapis.com/v1/{+parent}/.well-known/openid-configuration",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil}))

(defn projects-locations-operations-list
  "Lists all operations in a project in a specific zone or all zones.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.operations/list

parent <string> The parent (project and location) where the operations will be listed. Specified in the format `projects/*/locations/*`. Location \"-\" matches all zones and all regions.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) to return operations for, or `-` for all zones. This field has been deprecated and replaced by the parent field."
  ([parent] (projects-locations-operations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/{+parent}/operations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the specified operation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.operations/get

name <string> The name (project, location, operation id) of the operation to get. Specified in the format `projects/*/locations/*/operations/*`.

optional:
projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
operationId <string> Deprecated. The server-assigned `name` of the operation. This field has been deprecated and replaced by the name field."
  ([name] (projects-locations-operations-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://container.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-cancel
  "Cancels the specified operation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.locations.operations/cancel

name <string> The name (project, location, operation id) of the operation to cancel. Specified in the format `projects/*/locations/*/operations/*`.
CancelOperationRequest:
{:projectId string, :zone string, :operationId string, :name string}"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-zones-getServerconfig
  "Returns configuration info about the Google Kubernetes Engine service.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones/getServerconfig

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) to return operations for. This field has been deprecated and replaced by the name field.

optional:
name <string> The name (project and location) of the server config to get, specified in the format `projects/*/locations/*`."
  ([projectId zone]
    (projects-zones-getServerconfig projectId zone nil))
  ([projectId zone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/serverconfig",
       :uri-template-args {:projectId projectId, :zone zone},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-clusters-monitoring
  "Sets the monitoring service for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/monitoring

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
SetMonitoringServiceRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :monitoringService string,
 :name string}"
  [projectId zone clusterId SetMonitoringServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/monitoring",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMonitoringServiceRequest}))

(defn projects-zones-clusters-get
  "Gets the details of a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/get

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to retrieve. This field has been deprecated and replaced by the name field.

optional:
name <string> The name (project, location, cluster) of the cluster to retrieve. Specified in the format `projects/*/locations/*/clusters/*`."
  ([projectId zone clusterId]
    (projects-zones-clusters-get projectId zone clusterId nil))
  ([projectId zone clusterId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}",
       :uri-template-args
       {:projectId projectId, :zone zone, :clusterId clusterId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-clusters-create
  "Creates a cluster, consisting of the specified number and type of Google Compute Engine instances. By default, the cluster is created in the project's [default network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks). One firewall is added for the cluster. After cluster creation, the Kubelet creates routes for each node to allow the containers on that node to communicate with all other instances in the cluster. Finally, an entry is added to the project's global metadata indicating which CIDR range the cluster is using.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/create

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the parent field.
CreateClusterRequest:
{:projectId string,
 :zone string,
 :cluster
 {:description string,
  :currentNodeCount integer,
  :meshCertificates {:enableCertificates boolean},
  :tpuIpv4CidrBlock string,
  :verticalPodAutoscaling {:enabled boolean},
  :nodePoolAutoConfig
  {:networkTags {:tags [string]},
   :resourceManagerTags {:tags object},
   :nodeKubeletConfig
   {:cpuManagerPolicy string,
    :cpuCfsQuota boolean,
    :cpuCfsQuotaPeriod string,
    :podPidsLimit string,
    :insecureKubeletReadonlyPortEnabled boolean}},
  :networkPolicy
  {:provider [PROVIDER_UNSPECIFIED CALICO], :enabled boolean},
  :instanceGroupUrls [string],
  :parentProductConfig {:productName string, :labels object},
  :autopilot
  {:enabled boolean, :workloadPolicyConfig {:allowNetAdmin boolean}},
  :monitoringConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER
      STORAGE
      HPA
      POD
      DAEMONSET
      DEPLOYMENT
      STATEFULSET
      CADVISOR
      KUBELET]]},
   :managedPrometheusConfig {:enabled boolean},
   :advancedDatapathObservabilityConfig
   {:enableMetrics boolean,
    :relayMode
    [RELAY_MODE_UNSPECIFIED DISABLED INTERNAL_VPC_LB EXTERNAL_LB],
    :enableRelay boolean}},
  :loggingConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      WORKLOADS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER]]}},
  :autoscaling
  {:enableNodeAutoprovisioning boolean,
   :resourceLimits
   [{:resourceType string, :minimum string, :maximum string}],
   :autoscalingProfile
   [PROFILE_UNSPECIFIED OPTIMIZE_UTILIZATION BALANCED],
   :autoprovisioningNodePoolDefaults
   {:serviceAccount string,
    :shieldedInstanceConfig
    {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
    :bootDiskKmsKey string,
    :imageType string,
    :oauthScopes [string],
    :diskType string,
    :diskSizeGb integer,
    :insecureKubeletReadonlyPortEnabled boolean,
    :management
    {:autoUpgrade boolean,
     :autoRepair boolean,
     :upgradeOptions AutoUpgradeOptions},
    :upgradeSettings
    {:maxSurge integer,
     :maxUnavailable integer,
     :strategy
     [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
     :blueGreenSettings BlueGreenSettings},
    :minCpuPlatform string},
   :autoprovisioningLocations [string]},
  :enableKubernetesAlpha boolean,
  :nodeConfig
  {:serviceAccount string,
   :tags [string],
   :labels object,
   :taints
   [{:key string,
     :value string,
     :effect
     [EFFECT_UNSPECIFIED NO_SCHEDULE PREFER_NO_SCHEDULE NO_EXECUTE]}],
   :ephemeralStorageLocalSsdConfig {:localSsdCount integer},
   :preemptible boolean,
   :shieldedInstanceConfig
   {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
   :loggingConfig
   {:variantConfig
    {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
   :bootDiskKmsKey string,
   :sandboxConfig {:type [UNSPECIFIED GVISOR]},
   :soleTenantConfig
   {:nodeAffinities
    [{:key string,
      :operator [OPERATOR_UNSPECIFIED IN NOT_IN],
      :values [string]}]},
   :localSsdCount integer,
   :nodeGroup string,
   :resourceManagerTags {:tags object},
   :secondaryBootDisks
   [{:mode [MODE_UNSPECIFIED CONTAINER_IMAGE_CACHE],
     :diskImage string}],
   :imageType string,
   :machineType string,
   :linuxNodeConfig
   {:sysctls object,
    :cgroupMode
    [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
    :hugepages {:hugepageSize2m integer, :hugepageSize1g integer}},
   :kubeletConfig
   {:cpuManagerPolicy string,
    :cpuCfsQuota boolean,
    :cpuCfsQuotaPeriod string,
    :podPidsLimit string,
    :insecureKubeletReadonlyPortEnabled boolean},
   :secondaryBootDiskUpdateStrategy object,
   :oauthScopes [string],
   :confidentialNodes {:enabled boolean},
   :resourceLabels object,
   :enableConfidentialStorage boolean,
   :diskType string,
   :advancedMachineFeatures
   {:threadsPerCore string, :enableNestedVirtualization boolean},
   :localNvmeSsdBlockConfig {:localSsdCount integer},
   :diskSizeGb integer,
   :reservationAffinity
   {:consumeReservationType
    [UNSPECIFIED NO_RESERVATION ANY_RESERVATION SPECIFIC_RESERVATION],
    :key string,
    :values [string]},
   :gcfsConfig {:enabled boolean},
   :workloadMetadataConfig
   {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
   :containerdConfig
   {:privateRegistryAccessConfig
    {:enabled boolean,
     :certificateAuthorityDomainConfig
     [CertificateAuthorityDomainConfig]}},
   :fastSocket {:enabled boolean},
   :metadata object,
   :spot boolean,
   :windowsNodeConfig
   {:osVersion
    [OS_VERSION_UNSPECIFIED OS_VERSION_LTSC2019 OS_VERSION_LTSC2022]},
   :accelerators
   [{:acceleratorCount string,
     :acceleratorType string,
     :gpuPartitionSize string,
     :gpuSharingConfig
     {:maxSharedClientsPerGpu string,
      :gpuSharingStrategy
      [GPU_SHARING_STRATEGY_UNSPECIFIED TIME_SHARING MPS]},
     :gpuDriverInstallationConfig
     {:gpuDriverVersion
      [GPU_DRIVER_VERSION_UNSPECIFIED
       INSTALLATION_DISABLED
       DEFAULT
       LATEST]}}],
   :gvnic {:enabled boolean},
   :minCpuPlatform string},
  :masterAuthorizedNetworksConfig
  {:enabled boolean,
   :cidrBlocks [{:displayName string, :cidrBlock string}],
   :gcpPublicCidrsAccessEnabled boolean},
  :satisfiesPzi boolean,
  :zone string,
  :databaseEncryption
  {:keyName string,
   :state [UNKNOWN ENCRYPTED DECRYPTED],
   :currentState
   [CURRENT_STATE_UNSPECIFIED
    CURRENT_STATE_ENCRYPTED
    CURRENT_STATE_DECRYPTED
    CURRENT_STATE_ENCRYPTION_PENDING
    CURRENT_STATE_ENCRYPTION_ERROR
    CURRENT_STATE_DECRYPTION_PENDING
    CURRENT_STATE_DECRYPTION_ERROR],
   :decryptionKeys [string],
   :lastOperationErrors
   [{:keyName string, :errorMessage string, :timestamp string}]},
  :masterAuth
  {:username string,
   :password string,
   :clientCertificateConfig {:issueClientCertificate boolean},
   :clusterCaCertificate string,
   :clientCertificate string,
   :clientKey string},
  :privateClusterConfig
  {:enablePrivateNodes boolean,
   :enablePrivateEndpoint boolean,
   :masterIpv4CidrBlock string,
   :privateEndpoint string,
   :publicEndpoint string,
   :peeringName string,
   :masterGlobalAccessConfig {:enabled boolean},
   :privateEndpointSubnetwork string},
  :loggingService string,
  :name string,
  :shieldedNodes {:enabled boolean},
  :initialClusterVersion string,
  :binaryAuthorization
  {:enabled boolean,
   :evaluationMode
   [EVALUATION_MODE_UNSPECIFIED
    DISABLED
    PROJECT_SINGLETON_POLICY_ENFORCE]},
  :statusMessage string,
  :defaultMaxPodsConstraint {:maxPodsPerNode string},
  :createTime string,
  :enableK8sBetaApis {:enabledApis [string]},
  :resourceUsageExportConfig
  {:bigqueryDestination {:datasetId string},
   :enableNetworkEgressMetering boolean,
   :consumptionMeteringConfig {:enabled boolean}},
  :selfLink string,
  :nodeIpv4CidrSize integer,
  :etag string,
  :networkConfig
  {:enableMultiNetworking boolean,
   :defaultSnatStatus {:disabled boolean},
   :enableIntraNodeVisibility boolean,
   :enableL4ilbSubsetting boolean,
   :datapathProvider
   [DATAPATH_PROVIDER_UNSPECIFIED LEGACY_DATAPATH ADVANCED_DATAPATH],
   :enableCiliumClusterwideNetworkPolicy boolean,
   :inTransitEncryptionConfig
   [IN_TRANSIT_ENCRYPTION_CONFIG_UNSPECIFIED
    IN_TRANSIT_ENCRYPTION_DISABLED
    IN_TRANSIT_ENCRYPTION_INTER_NODE_TRANSPARENT],
   :privateIpv6GoogleAccess
   [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
    PRIVATE_IPV6_GOOGLE_ACCESS_DISABLED
    PRIVATE_IPV6_GOOGLE_ACCESS_TO_GOOGLE
    PRIVATE_IPV6_GOOGLE_ACCESS_BIDIRECTIONAL],
   :dnsConfig
   {:clusterDns
    [PROVIDER_UNSPECIFIED PLATFORM_DEFAULT CLOUD_DNS KUBE_DNS],
    :clusterDnsScope [DNS_SCOPE_UNSPECIFIED CLUSTER_SCOPE VPC_SCOPE],
    :clusterDnsDomain string,
    :additiveVpcScopeDnsDomain string},
   :gatewayApiConfig
   {:channel
    [CHANNEL_UNSPECIFIED
     CHANNEL_DISABLED
     CHANNEL_EXPERIMENTAL
     CHANNEL_STANDARD]},
   :serviceExternalIpsConfig {:enabled boolean},
   :networkPerformanceConfig
   {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
   :enableFqdnNetworkPolicy boolean,
   :network string,
   :subnetwork string},
  :legacyAbac {:enabled boolean},
  :nodePools
  [{:instanceGroupUrls [string],
    :maxPodsConstraint {:maxPodsPerNode string},
    :podIpv4CidrSize integer,
    :autoscaling
    {:enabled boolean,
     :minNodeCount integer,
     :maxNodeCount integer,
     :autoprovisioned boolean,
     :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
     :totalMinNodeCount integer,
     :totalMaxNodeCount integer},
    :config
    {:serviceAccount string,
     :tags [string],
     :labels object,
     :taints
     [{:key string,
       :value string,
       :effect
       [EFFECT_UNSPECIFIED
        NO_SCHEDULE
        PREFER_NO_SCHEDULE
        NO_EXECUTE]}],
     :ephemeralStorageLocalSsdConfig {:localSsdCount integer},
     :preemptible boolean,
     :shieldedInstanceConfig
     {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
     :loggingConfig {:variantConfig LoggingVariantConfig},
     :bootDiskKmsKey string,
     :sandboxConfig {:type [UNSPECIFIED GVISOR]},
     :soleTenantConfig {:nodeAffinities [NodeAffinity]},
     :localSsdCount integer,
     :nodeGroup string,
     :resourceManagerTags {:tags object},
     :secondaryBootDisks
     [{:mode [MODE_UNSPECIFIED CONTAINER_IMAGE_CACHE],
       :diskImage string}],
     :imageType string,
     :machineType string,
     :linuxNodeConfig
     {:sysctls object,
      :cgroupMode
      [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
      :hugepages HugepagesConfig},
     :kubeletConfig
     {:cpuManagerPolicy string,
      :cpuCfsQuota boolean,
      :cpuCfsQuotaPeriod string,
      :podPidsLimit string,
      :insecureKubeletReadonlyPortEnabled boolean},
     :secondaryBootDiskUpdateStrategy object,
     :oauthScopes [string],
     :confidentialNodes {:enabled boolean},
     :resourceLabels object,
     :enableConfidentialStorage boolean,
     :diskType string,
     :advancedMachineFeatures
     {:threadsPerCore string, :enableNestedVirtualization boolean},
     :localNvmeSsdBlockConfig {:localSsdCount integer},
     :diskSizeGb integer,
     :reservationAffinity
     {:consumeReservationType
      [UNSPECIFIED
       NO_RESERVATION
       ANY_RESERVATION
       SPECIFIC_RESERVATION],
      :key string,
      :values [string]},
     :gcfsConfig {:enabled boolean},
     :workloadMetadataConfig
     {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
     :containerdConfig
     {:privateRegistryAccessConfig PrivateRegistryAccessConfig},
     :fastSocket {:enabled boolean},
     :metadata object,
     :spot boolean,
     :windowsNodeConfig
     {:osVersion
      [OS_VERSION_UNSPECIFIED
       OS_VERSION_LTSC2019
       OS_VERSION_LTSC2022]},
     :accelerators
     [{:acceleratorCount string,
       :acceleratorType string,
       :gpuPartitionSize string,
       :gpuSharingConfig GPUSharingConfig,
       :gpuDriverInstallationConfig GPUDriverInstallationConfig}],
     :gvnic {:enabled boolean},
     :minCpuPlatform string},
    :placementPolicy
    {:type [TYPE_UNSPECIFIED COMPACT],
     :tpuTopology string,
     :policyName string},
    :name string,
    :statusMessage string,
    :selfLink string,
    :etag string,
    :networkConfig
    {:createPodRange boolean,
     :additionalPodNetworkConfigs
     [{:subnetwork string,
       :secondaryPodRange string,
       :maxPodsPerNode MaxPodsConstraint}],
     :podRange string,
     :networkPerformanceConfig
     {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
     :podCidrOverprovisionConfig {:disable boolean},
     :podIpv4RangeUtilization number,
     :enablePrivateNodes boolean,
     :podIpv4CidrBlock string,
     :additionalNodeNetworkConfigs
     [{:network string, :subnetwork string}]},
    :locations [string],
    :initialNodeCount integer,
    :conditions
    [{:code
      [UNKNOWN
       GCE_STOCKOUT
       GKE_SERVICE_ACCOUNT_DELETED
       GCE_QUOTA_EXCEEDED
       SET_BY_OPERATOR
       CLOUD_KMS_KEY_ERROR
       CA_EXPIRING],
      :message string,
      :canonicalCode
      [OK
       CANCELLED
       UNKNOWN
       INVALID_ARGUMENT
       DEADLINE_EXCEEDED
       NOT_FOUND
       ALREADY_EXISTS
       PERMISSION_DENIED
       UNAUTHENTICATED
       RESOURCE_EXHAUSTED
       FAILED_PRECONDITION
       ABORTED
       OUT_OF_RANGE
       UNIMPLEMENTED
       INTERNAL
       UNAVAILABLE
       DATA_LOSS]}],
    :updateInfo
    {:blueGreenInfo
     {:phase
      [PHASE_UNSPECIFIED
       UPDATE_STARTED
       CREATING_GREEN_POOL
       CORDONING_BLUE_POOL
       DRAINING_BLUE_POOL
       NODE_POOL_SOAKING
       DELETING_BLUE_POOL
       ROLLBACK_STARTED],
      :blueInstanceGroupUrls [string],
      :greenInstanceGroupUrls [string],
      :bluePoolDeletionStartTime string,
      :greenPoolVersion string}},
    :status
    [STATUS_UNSPECIFIED
     PROVISIONING
     RUNNING
     RUNNING_WITH_ERROR
     RECONCILING
     STOPPING
     ERROR],
    :queuedProvisioning {:enabled boolean},
    :version string,
    :bestEffortProvisioning
    {:enabled boolean, :minProvisionNodes integer},
    :management
    {:autoUpgrade boolean,
     :autoRepair boolean,
     :upgradeOptions
     {:autoUpgradeStartTime string, :description string}},
    :upgradeSettings
    {:maxSurge integer,
     :maxUnavailable integer,
     :strategy
     [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
     :blueGreenSettings
     {:standardRolloutPolicy StandardRolloutPolicy,
      :nodePoolSoakDuration string}}}],
  :releaseChannel {:channel [UNSPECIFIED RAPID REGULAR STABLE]},
  :maintenancePolicy
  {:window
   {:dailyMaintenanceWindow {:startTime string, :duration string},
    :recurringWindow {:window TimeWindow, :recurrence string},
    :maintenanceExclusions object},
   :resourceVersion string},
  :locations [string],
  :clusterIpv4Cidr string,
  :costManagementConfig {:enabled boolean},
  :currentNodeVersion string,
  :confidentialNodes {:enabled boolean},
  :fleet {:project string, :membership string, :preRegistered boolean},
  :initialNodeCount integer,
  :conditions
  [{:code
    [UNKNOWN
     GCE_STOCKOUT
     GKE_SERVICE_ACCOUNT_DELETED
     GCE_QUOTA_EXCEEDED
     SET_BY_OPERATOR
     CLOUD_KMS_KEY_ERROR
     CA_EXPIRING],
    :message string,
    :canonicalCode
    [OK
     CANCELLED
     UNKNOWN
     INVALID_ARGUMENT
     DEADLINE_EXCEEDED
     NOT_FOUND
     ALREADY_EXISTS
     PERMISSION_DENIED
     UNAUTHENTICATED
     RESOURCE_EXHAUSTED
     FAILED_PRECONDITION
     ABORTED
     OUT_OF_RANGE
     UNIMPLEMENTED
     INTERNAL
     UNAVAILABLE
     DATA_LOSS]}],
  :resourceLabels object,
  :satisfiesPzs boolean,
  :securityPostureConfig
  {:mode [MODE_UNSPECIFIED DISABLED BASIC ENTERPRISE],
   :vulnerabilityMode
   [VULNERABILITY_MODE_UNSPECIFIED
    VULNERABILITY_DISABLED
    VULNERABILITY_BASIC
    VULNERABILITY_ENTERPRISE]},
  :status
  [STATUS_UNSPECIFIED
   PROVISIONING
   RUNNING
   RECONCILING
   STOPPING
   ERROR
   DEGRADED],
  :id string,
  :notificationConfig
  {:pubsub
   {:enabled boolean,
    :topic string,
    :filter
    {:eventType
     [[EVENT_TYPE_UNSPECIFIED
       UPGRADE_AVAILABLE_EVENT
       UPGRADE_EVENT
       SECURITY_BULLETIN_EVENT]]}}},
  :currentMasterVersion string,
  :nodePoolDefaults
  {:nodeConfigDefaults
   {:gcfsConfig {:enabled boolean},
    :loggingConfig {:variantConfig LoggingVariantConfig},
    :containerdConfig
    {:privateRegistryAccessConfig PrivateRegistryAccessConfig},
    :nodeKubeletConfig
    {:cpuManagerPolicy string,
     :cpuCfsQuota boolean,
     :cpuCfsQuotaPeriod string,
     :podPidsLimit string,
     :insecureKubeletReadonlyPortEnabled boolean}}},
  :authenticatorGroupsConfig {:enabled boolean, :securityGroup string},
  :identityServiceConfig {:enabled boolean},
  :workloadIdentityConfig {:workloadPool string},
  :expireTime string,
  :monitoringService string,
  :network string,
  :addonsConfig
  {:gcePersistentDiskCsiDriverConfig {:enabled boolean},
   :configConnectorConfig {:enabled boolean},
   :statefulHaConfig {:enabled boolean},
   :gkeBackupAgentConfig {:enabled boolean},
   :cloudRunConfig
   {:disabled boolean,
    :loadBalancerType
    [LOAD_BALANCER_TYPE_UNSPECIFIED
     LOAD_BALANCER_TYPE_EXTERNAL
     LOAD_BALANCER_TYPE_INTERNAL]},
   :networkPolicyConfig {:disabled boolean},
   :gcsFuseCsiDriverConfig {:enabled boolean},
   :httpLoadBalancing {:disabled boolean},
   :kubernetesDashboard {:disabled boolean},
   :dnsCacheConfig {:enabled boolean},
   :gcpFilestoreCsiDriverConfig {:enabled boolean},
   :horizontalPodAutoscaling {:disabled boolean}},
  :enterpriseConfig
  {:clusterTier [CLUSTER_TIER_UNSPECIFIED STANDARD ENTERPRISE]},
  :servicesIpv4Cidr string,
  :location string,
  :endpoint string,
  :enableTpu boolean,
  :subnetwork string,
  :labelFingerprint string,
  :ipAllocationPolicy
  {:clusterSecondaryRangeName string,
   :tpuIpv4CidrBlock string,
   :nodeIpv4Cidr string,
   :nodeIpv4CidrBlock string,
   :ipv6AccessType [IPV6_ACCESS_TYPE_UNSPECIFIED INTERNAL EXTERNAL],
   :stackType [STACK_TYPE_UNSPECIFIED IPV4 IPV4_IPV6],
   :useIpAliases boolean,
   :servicesIpv4CidrBlock string,
   :defaultPodIpv4RangeUtilization number,
   :additionalPodRangesConfig
   {:podRangeNames [string],
    :podRangeInfo [{:rangeName string, :utilization number}]},
   :podCidrOverprovisionConfig {:disable boolean},
   :clusterIpv4CidrBlock string,
   :clusterIpv4Cidr string,
   :subnetworkName string,
   :createSubnetwork boolean,
   :useRoutes boolean,
   :servicesIpv4Cidr string,
   :servicesSecondaryRangeName string,
   :subnetIpv6CidrBlock string,
   :servicesIpv6CidrBlock string}},
 :parent string}"
  [projectId zone CreateClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters",
     :uri-template-args {:projectId projectId, :zone zone},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateClusterRequest}))

(defn projects-zones-clusters-update
  "Updates the settings of a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/update

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
UpdateClusterRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :update
 {:desiredIntraNodeVisibilityConfig {:enabled boolean},
  :desiredNodePoolAutoConfigResourceManagerTags {:tags object},
  :desiredBinaryAuthorization
  {:enabled boolean,
   :evaluationMode
   [EVALUATION_MODE_UNSPECIFIED
    DISABLED
    PROJECT_SINGLETON_POLICY_ENFORCE]},
  :desiredDefaultSnatStatus {:disabled boolean},
  :desiredDatabaseEncryption
  {:keyName string,
   :state [UNKNOWN ENCRYPTED DECRYPTED],
   :currentState
   [CURRENT_STATE_UNSPECIFIED
    CURRENT_STATE_ENCRYPTED
    CURRENT_STATE_DECRYPTED
    CURRENT_STATE_ENCRYPTION_PENDING
    CURRENT_STATE_ENCRYPTION_ERROR
    CURRENT_STATE_DECRYPTION_PENDING
    CURRENT_STATE_DECRYPTION_ERROR],
   :decryptionKeys [string],
   :lastOperationErrors
   [{:keyName string, :errorMessage string, :timestamp string}]},
  :desiredAddonsConfig
  {:gcePersistentDiskCsiDriverConfig {:enabled boolean},
   :configConnectorConfig {:enabled boolean},
   :statefulHaConfig {:enabled boolean},
   :gkeBackupAgentConfig {:enabled boolean},
   :cloudRunConfig
   {:disabled boolean,
    :loadBalancerType
    [LOAD_BALANCER_TYPE_UNSPECIFIED
     LOAD_BALANCER_TYPE_EXTERNAL
     LOAD_BALANCER_TYPE_INTERNAL]},
   :networkPolicyConfig {:disabled boolean},
   :gcsFuseCsiDriverConfig {:enabled boolean},
   :httpLoadBalancing {:disabled boolean},
   :kubernetesDashboard {:disabled boolean},
   :dnsCacheConfig {:enabled boolean},
   :gcpFilestoreCsiDriverConfig {:enabled boolean},
   :horizontalPodAutoscaling {:disabled boolean}},
  :desiredK8sBetaApis {:enabledApis [string]},
  :desiredEnableMultiNetworking boolean,
  :desiredStackType [STACK_TYPE_UNSPECIFIED IPV4 IPV4_IPV6],
  :desiredEnableCiliumClusterwideNetworkPolicy boolean,
  :desiredNodePoolId string,
  :desiredMonitoringConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER
      STORAGE
      HPA
      POD
      DAEMONSET
      DEPLOYMENT
      STATEFULSET
      CADVISOR
      KUBELET]]},
   :managedPrometheusConfig {:enabled boolean},
   :advancedDatapathObservabilityConfig
   {:enableMetrics boolean,
    :relayMode
    [RELAY_MODE_UNSPECIFIED DISABLED INTERNAL_VPC_LB EXTERNAL_LB],
    :enableRelay boolean}},
  :desiredLocations [string],
  :desiredLoggingConfig
  {:componentConfig
   {:enableComponents
    [[COMPONENT_UNSPECIFIED
      SYSTEM_COMPONENTS
      WORKLOADS
      APISERVER
      SCHEDULER
      CONTROLLER_MANAGER]]}},
  :desiredFleet
  {:project string, :membership string, :preRegistered boolean},
  :desiredResourceUsageExportConfig
  {:bigqueryDestination {:datasetId string},
   :enableNetworkEgressMetering boolean,
   :consumptionMeteringConfig {:enabled boolean}},
  :enableK8sBetaApis {:enabledApis [string]},
  :desiredAuthenticatorGroupsConfig
  {:enabled boolean, :securityGroup string},
  :desiredGatewayApiConfig
  {:channel
   [CHANNEL_UNSPECIFIED
    CHANNEL_DISABLED
    CHANNEL_EXPERIMENTAL
    CHANNEL_STANDARD]},
  :desiredIdentityServiceConfig {:enabled boolean},
  :desiredMeshCertificates {:enableCertificates boolean},
  :etag string,
  :desiredImageType string,
  :desiredLoggingService string,
  :desiredNodePoolAutoscaling
  {:enabled boolean,
   :minNodeCount integer,
   :maxNodeCount integer,
   :autoprovisioned boolean,
   :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
   :totalMinNodeCount integer,
   :totalMaxNodeCount integer},
  :desiredNodeVersion string,
  :additionalPodRangesConfig
  {:podRangeNames [string],
   :podRangeInfo [{:rangeName string, :utilization number}]},
  :desiredDnsConfig
  {:clusterDns
   [PROVIDER_UNSPECIFIED PLATFORM_DEFAULT CLOUD_DNS KUBE_DNS],
   :clusterDnsScope [DNS_SCOPE_UNSPECIFIED CLUSTER_SCOPE VPC_SCOPE],
   :clusterDnsDomain string,
   :additiveVpcScopeDnsDomain string},
  :desiredParentProductConfig {:productName string, :labels object},
  :desiredPrivateClusterConfig
  {:enablePrivateNodes boolean,
   :enablePrivateEndpoint boolean,
   :masterIpv4CidrBlock string,
   :privateEndpoint string,
   :publicEndpoint string,
   :peeringName string,
   :masterGlobalAccessConfig {:enabled boolean},
   :privateEndpointSubnetwork string},
  :desiredGcfsConfig {:enabled boolean},
  :desiredDatapathProvider
  [DATAPATH_PROVIDER_UNSPECIFIED LEGACY_DATAPATH ADVANCED_DATAPATH],
  :desiredNodePoolAutoConfigNetworkTags {:tags [string]},
  :desiredReleaseChannel {:channel [UNSPECIFIED RAPID REGULAR STABLE]},
  :desiredSecurityPostureConfig
  {:mode [MODE_UNSPECIFIED DISABLED BASIC ENTERPRISE],
   :vulnerabilityMode
   [VULNERABILITY_MODE_UNSPECIFIED
    VULNERABILITY_DISABLED
    VULNERABILITY_BASIC
    VULNERABILITY_ENTERPRISE]},
  :desiredContainerdConfig
  {:privateRegistryAccessConfig
   {:enabled boolean,
    :certificateAuthorityDomainConfig
    [{:fqdns [string],
      :gcpSecretManagerCertificateConfig
      GCPSecretManagerCertificateConfig}]}},
  :desiredEnableFqdnNetworkPolicy boolean,
  :removedAdditionalPodRangesConfig
  {:podRangeNames [string],
   :podRangeInfo [{:rangeName string, :utilization number}]},
  :desiredCostManagementConfig {:enabled boolean},
  :desiredWorkloadIdentityConfig {:workloadPool string},
  :desiredNetworkPerformanceConfig
  {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
  :desiredL4ilbSubsettingConfig {:enabled boolean},
  :desiredPrivateIpv6GoogleAccess
  [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
   PRIVATE_IPV6_GOOGLE_ACCESS_DISABLED
   PRIVATE_IPV6_GOOGLE_ACCESS_TO_GOOGLE
   PRIVATE_IPV6_GOOGLE_ACCESS_BIDIRECTIONAL],
  :desiredNodePoolAutoConfigKubeletConfig
  {:cpuManagerPolicy string,
   :cpuCfsQuota boolean,
   :cpuCfsQuotaPeriod string,
   :podPidsLimit string,
   :insecureKubeletReadonlyPortEnabled boolean},
  :desiredServiceExternalIpsConfig {:enabled boolean},
  :desiredEnablePrivateEndpoint boolean,
  :desiredMonitoringService string,
  :desiredShieldedNodes {:enabled boolean},
  :desiredAutopilotWorkloadPolicyConfig {:allowNetAdmin boolean},
  :desiredNodeKubeletConfig
  {:cpuManagerPolicy string,
   :cpuCfsQuota boolean,
   :cpuCfsQuotaPeriod string,
   :podPidsLimit string,
   :insecureKubeletReadonlyPortEnabled boolean},
  :desiredInTransitEncryptionConfig
  [IN_TRANSIT_ENCRYPTION_CONFIG_UNSPECIFIED
   IN_TRANSIT_ENCRYPTION_DISABLED
   IN_TRANSIT_ENCRYPTION_INTER_NODE_TRANSPARENT],
  :desiredNodePoolLoggingConfig
  {:variantConfig
   {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
  :desiredMasterVersion string,
  :desiredClusterAutoscaling
  {:enableNodeAutoprovisioning boolean,
   :resourceLimits
   [{:resourceType string, :minimum string, :maximum string}],
   :autoscalingProfile
   [PROFILE_UNSPECIFIED OPTIMIZE_UTILIZATION BALANCED],
   :autoprovisioningNodePoolDefaults
   {:serviceAccount string,
    :shieldedInstanceConfig
    {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
    :bootDiskKmsKey string,
    :imageType string,
    :oauthScopes [string],
    :diskType string,
    :diskSizeGb integer,
    :insecureKubeletReadonlyPortEnabled boolean,
    :management
    {:autoUpgrade boolean,
     :autoRepair boolean,
     :upgradeOptions AutoUpgradeOptions},
    :upgradeSettings
    {:maxSurge integer,
     :maxUnavailable integer,
     :strategy
     [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
     :blueGreenSettings BlueGreenSettings},
    :minCpuPlatform string},
   :autoprovisioningLocations [string]},
  :desiredNotificationConfig
  {:pubsub
   {:enabled boolean,
    :topic string,
    :filter
    {:eventType
     [[EVENT_TYPE_UNSPECIFIED
       UPGRADE_AVAILABLE_EVENT
       UPGRADE_EVENT
       SECURITY_BULLETIN_EVENT]]}}},
  :desiredMasterAuthorizedNetworksConfig
  {:enabled boolean,
   :cidrBlocks [{:displayName string, :cidrBlock string}],
   :gcpPublicCidrsAccessEnabled boolean},
  :desiredVerticalPodAutoscaling {:enabled boolean}},
 :name string}"
  [projectId zone clusterId UpdateClusterRequest]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpdateClusterRequest}))

(defn projects-zones-clusters-delete
  "Deletes the cluster, including the Kubernetes endpoint and all worker nodes. Firewalls and routes that were configured during cluster creation are also deleted. Other Google Compute Engine resources that might be in use by the cluster, such as load balancer resources, are not deleted if they weren't present when the cluster was initially created.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/delete

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to delete. This field has been deprecated and replaced by the name field.

optional:
name <string> The name (project, location, cluster) of the cluster to delete. Specified in the format `projects/*/locations/*/clusters/*`."
  ([projectId zone clusterId]
    (projects-zones-clusters-delete projectId zone clusterId nil))
  ([projectId zone clusterId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}",
       :uri-template-args
       {:projectId projectId, :zone zone, :clusterId clusterId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-clusters-legacyAbac
  "Enables or disables the ABAC authorization mechanism on a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/legacyAbac

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to update. This field has been deprecated and replaced by the name field.
SetLegacyAbacRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :enabled boolean,
 :name string}"
  [projectId zone clusterId SetLegacyAbacRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/legacyAbac",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLegacyAbacRequest}))

(defn projects-zones-clusters-locations
  "Sets the locations for a specific cluster. Deprecated. Use [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update) instead.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/locations

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
SetLocationsRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :locations [string],
 :name string}"
  [projectId zone clusterId SetLocationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/locations",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLocationsRequest}))

(defn projects-zones-clusters-logging
  "Sets the logging service for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/logging

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
SetLoggingServiceRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :loggingService string,
 :name string}"
  [projectId zone clusterId SetLoggingServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/logging",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLoggingServiceRequest}))

(defn projects-zones-clusters-resourceLabels
  "Sets labels on a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/resourceLabels

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
SetLabelsRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :resourceLabels object,
 :labelFingerprint string,
 :name string}"
  [projectId zone clusterId SetLabelsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/resourceLabels",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetLabelsRequest}))

(defn projects-zones-clusters-setMasterAuth
  "Sets master auth materials. Currently supports changing the admin password or a specific cluster, either via password generation or explicitly setting the password.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/setMasterAuth

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
SetMasterAuthRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :action [UNKNOWN SET_PASSWORD GENERATE_PASSWORD SET_USERNAME],
 :update
 {:username string,
  :password string,
  :clientCertificateConfig {:issueClientCertificate boolean},
  :clusterCaCertificate string,
  :clientCertificate string,
  :clientKey string},
 :name string}"
  [projectId zone clusterId SetMasterAuthRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMasterAuth",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMasterAuthRequest}))

(defn projects-zones-clusters-list
  "Lists all clusters owned by a project in either the specified zone or all zones.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/list

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides, or \"-\" for all zones. This field has been deprecated and replaced by the parent field.

optional:
parent <string> The parent (project and location) where the clusters will be listed. Specified in the format `projects/*/locations/*`. Location \"-\" matches all zones and all regions."
  ([projectId zone] (projects-zones-clusters-list projectId zone nil))
  ([projectId zone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters",
       :uri-template-args {:projectId projectId, :zone zone},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-clusters-setNetworkPolicy
  "Enables or disables Network Policy for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/setNetworkPolicy

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
SetNetworkPolicyRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :networkPolicy
 {:provider [PROVIDER_UNSPECIFIED CALICO], :enabled boolean},
 :name string}"
  [projectId zone clusterId SetNetworkPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setNetworkPolicy",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNetworkPolicyRequest}))

(defn projects-zones-clusters-addons
  "Sets the addons for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/addons

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
SetAddonsConfigRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :addonsConfig
 {:gcePersistentDiskCsiDriverConfig {:enabled boolean},
  :configConnectorConfig {:enabled boolean},
  :statefulHaConfig {:enabled boolean},
  :gkeBackupAgentConfig {:enabled boolean},
  :cloudRunConfig
  {:disabled boolean,
   :loadBalancerType
   [LOAD_BALANCER_TYPE_UNSPECIFIED
    LOAD_BALANCER_TYPE_EXTERNAL
    LOAD_BALANCER_TYPE_INTERNAL]},
  :networkPolicyConfig {:disabled boolean},
  :gcsFuseCsiDriverConfig {:enabled boolean},
  :httpLoadBalancing {:disabled boolean},
  :kubernetesDashboard {:disabled boolean},
  :dnsCacheConfig {:enabled boolean},
  :gcpFilestoreCsiDriverConfig {:enabled boolean},
  :horizontalPodAutoscaling {:disabled boolean}},
 :name string}"
  [projectId zone clusterId SetAddonsConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/addons",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetAddonsConfigRequest}))

(defn projects-zones-clusters-startIpRotation
  "Starts master IP rotation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/startIpRotation

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
StartIPRotationRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :name string,
 :rotateCredentials boolean}"
  [projectId zone clusterId StartIPRotationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:startIpRotation",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartIPRotationRequest}))

(defn projects-zones-clusters-completeIpRotation
  "Completes master IP rotation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/completeIpRotation

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
CompleteIPRotationRequest:
{:projectId string, :zone string, :clusterId string, :name string}"
  [projectId zone clusterId CompleteIPRotationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:completeIpRotation",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CompleteIPRotationRequest}))

(defn projects-zones-clusters-master
  "Updates the master for a specific cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/master

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
UpdateMasterRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :masterVersion string,
 :name string}"
  [projectId zone clusterId UpdateMasterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/master",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpdateMasterRequest}))

(defn projects-zones-clusters-setMaintenancePolicy
  "Sets the maintenance policy for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters/setMaintenancePolicy

projectId <string> Required. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects).
zone <string> Required. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides.
clusterId <string> Required. The name of the cluster to update.
SetMaintenancePolicyRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :maintenancePolicy
 {:window
  {:dailyMaintenanceWindow {:startTime string, :duration string},
   :recurringWindow
   {:window
    {:maintenanceExclusionOptions MaintenanceExclusionOptions,
     :startTime string,
     :endTime string},
    :recurrence string},
   :maintenanceExclusions object},
  :resourceVersion string},
 :name string}"
  [projectId zone clusterId SetMaintenancePolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMaintenancePolicy",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMaintenancePolicyRequest}))

(defn projects-zones-clusters-nodePools-rollback
  "Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last upgrade successfully completed.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/rollback

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to rollback. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool to rollback. This field has been deprecated and replaced by the name field.
RollbackNodePoolUpgradeRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :name string,
 :respectPdb boolean}"
  [projectId zone clusterId nodePoolId RollbackNodePoolUpgradeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}:rollback",
     :uri-template-args
     {:projectId projectId,
      :zone zone,
      :clusterId clusterId,
      :nodePoolId nodePoolId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RollbackNodePoolUpgradeRequest}))

(defn projects-zones-clusters-nodePools-get
  "Retrieves the requested node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/get

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool. This field has been deprecated and replaced by the name field.

optional:
name <string> The name (project, location, cluster, node pool id) of the node pool to get. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`."
  ([projectId zone clusterId nodePoolId]
    (projects-zones-clusters-nodePools-get
      projectId
      zone
      clusterId
      nodePoolId
      nil))
  ([projectId zone clusterId nodePoolId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}",
       :uri-template-args
       {:projectId projectId,
        :zone zone,
        :clusterId clusterId,
        :nodePoolId nodePoolId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-clusters-nodePools-autoscaling
  "Sets the autoscaling settings for the specified node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/autoscaling

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool to upgrade. This field has been deprecated and replaced by the name field.
SetNodePoolAutoscalingRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :autoscaling
 {:enabled boolean,
  :minNodeCount integer,
  :maxNodeCount integer,
  :autoprovisioned boolean,
  :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
  :totalMinNodeCount integer,
  :totalMaxNodeCount integer},
 :name string}"
  [projectId zone clusterId nodePoolId SetNodePoolAutoscalingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/autoscaling",
     :uri-template-args
     {:projectId projectId,
      :zone zone,
      :clusterId clusterId,
      :nodePoolId nodePoolId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNodePoolAutoscalingRequest}))

(defn projects-zones-clusters-nodePools-create
  "Creates a node pool for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/create

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the parent field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the parent field.
CreateNodePoolRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePool
 {:instanceGroupUrls [string],
  :maxPodsConstraint {:maxPodsPerNode string},
  :podIpv4CidrSize integer,
  :autoscaling
  {:enabled boolean,
   :minNodeCount integer,
   :maxNodeCount integer,
   :autoprovisioned boolean,
   :locationPolicy [LOCATION_POLICY_UNSPECIFIED BALANCED ANY],
   :totalMinNodeCount integer,
   :totalMaxNodeCount integer},
  :config
  {:serviceAccount string,
   :tags [string],
   :labels object,
   :taints
   [{:key string,
     :value string,
     :effect
     [EFFECT_UNSPECIFIED NO_SCHEDULE PREFER_NO_SCHEDULE NO_EXECUTE]}],
   :ephemeralStorageLocalSsdConfig {:localSsdCount integer},
   :preemptible boolean,
   :shieldedInstanceConfig
   {:enableSecureBoot boolean, :enableIntegrityMonitoring boolean},
   :loggingConfig
   {:variantConfig
    {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
   :bootDiskKmsKey string,
   :sandboxConfig {:type [UNSPECIFIED GVISOR]},
   :soleTenantConfig
   {:nodeAffinities
    [{:key string,
      :operator [OPERATOR_UNSPECIFIED IN NOT_IN],
      :values [string]}]},
   :localSsdCount integer,
   :nodeGroup string,
   :resourceManagerTags {:tags object},
   :secondaryBootDisks
   [{:mode [MODE_UNSPECIFIED CONTAINER_IMAGE_CACHE],
     :diskImage string}],
   :imageType string,
   :machineType string,
   :linuxNodeConfig
   {:sysctls object,
    :cgroupMode
    [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
    :hugepages {:hugepageSize2m integer, :hugepageSize1g integer}},
   :kubeletConfig
   {:cpuManagerPolicy string,
    :cpuCfsQuota boolean,
    :cpuCfsQuotaPeriod string,
    :podPidsLimit string,
    :insecureKubeletReadonlyPortEnabled boolean},
   :secondaryBootDiskUpdateStrategy object,
   :oauthScopes [string],
   :confidentialNodes {:enabled boolean},
   :resourceLabels object,
   :enableConfidentialStorage boolean,
   :diskType string,
   :advancedMachineFeatures
   {:threadsPerCore string, :enableNestedVirtualization boolean},
   :localNvmeSsdBlockConfig {:localSsdCount integer},
   :diskSizeGb integer,
   :reservationAffinity
   {:consumeReservationType
    [UNSPECIFIED NO_RESERVATION ANY_RESERVATION SPECIFIC_RESERVATION],
    :key string,
    :values [string]},
   :gcfsConfig {:enabled boolean},
   :workloadMetadataConfig
   {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
   :containerdConfig
   {:privateRegistryAccessConfig
    {:enabled boolean,
     :certificateAuthorityDomainConfig
     [CertificateAuthorityDomainConfig]}},
   :fastSocket {:enabled boolean},
   :metadata object,
   :spot boolean,
   :windowsNodeConfig
   {:osVersion
    [OS_VERSION_UNSPECIFIED OS_VERSION_LTSC2019 OS_VERSION_LTSC2022]},
   :accelerators
   [{:acceleratorCount string,
     :acceleratorType string,
     :gpuPartitionSize string,
     :gpuSharingConfig
     {:maxSharedClientsPerGpu string,
      :gpuSharingStrategy
      [GPU_SHARING_STRATEGY_UNSPECIFIED TIME_SHARING MPS]},
     :gpuDriverInstallationConfig
     {:gpuDriverVersion
      [GPU_DRIVER_VERSION_UNSPECIFIED
       INSTALLATION_DISABLED
       DEFAULT
       LATEST]}}],
   :gvnic {:enabled boolean},
   :minCpuPlatform string},
  :placementPolicy
  {:type [TYPE_UNSPECIFIED COMPACT],
   :tpuTopology string,
   :policyName string},
  :name string,
  :statusMessage string,
  :selfLink string,
  :etag string,
  :networkConfig
  {:createPodRange boolean,
   :additionalPodNetworkConfigs
   [{:subnetwork string,
     :secondaryPodRange string,
     :maxPodsPerNode {:maxPodsPerNode string}}],
   :podRange string,
   :networkPerformanceConfig
   {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
   :podCidrOverprovisionConfig {:disable boolean},
   :podIpv4RangeUtilization number,
   :enablePrivateNodes boolean,
   :podIpv4CidrBlock string,
   :additionalNodeNetworkConfigs
   [{:network string, :subnetwork string}]},
  :locations [string],
  :initialNodeCount integer,
  :conditions
  [{:code
    [UNKNOWN
     GCE_STOCKOUT
     GKE_SERVICE_ACCOUNT_DELETED
     GCE_QUOTA_EXCEEDED
     SET_BY_OPERATOR
     CLOUD_KMS_KEY_ERROR
     CA_EXPIRING],
    :message string,
    :canonicalCode
    [OK
     CANCELLED
     UNKNOWN
     INVALID_ARGUMENT
     DEADLINE_EXCEEDED
     NOT_FOUND
     ALREADY_EXISTS
     PERMISSION_DENIED
     UNAUTHENTICATED
     RESOURCE_EXHAUSTED
     FAILED_PRECONDITION
     ABORTED
     OUT_OF_RANGE
     UNIMPLEMENTED
     INTERNAL
     UNAVAILABLE
     DATA_LOSS]}],
  :updateInfo
  {:blueGreenInfo
   {:phase
    [PHASE_UNSPECIFIED
     UPDATE_STARTED
     CREATING_GREEN_POOL
     CORDONING_BLUE_POOL
     DRAINING_BLUE_POOL
     NODE_POOL_SOAKING
     DELETING_BLUE_POOL
     ROLLBACK_STARTED],
    :blueInstanceGroupUrls [string],
    :greenInstanceGroupUrls [string],
    :bluePoolDeletionStartTime string,
    :greenPoolVersion string}},
  :status
  [STATUS_UNSPECIFIED
   PROVISIONING
   RUNNING
   RUNNING_WITH_ERROR
   RECONCILING
   STOPPING
   ERROR],
  :queuedProvisioning {:enabled boolean},
  :version string,
  :bestEffortProvisioning
  {:enabled boolean, :minProvisionNodes integer},
  :management
  {:autoUpgrade boolean,
   :autoRepair boolean,
   :upgradeOptions
   {:autoUpgradeStartTime string, :description string}},
  :upgradeSettings
  {:maxSurge integer,
   :maxUnavailable integer,
   :strategy [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
   :blueGreenSettings
   {:standardRolloutPolicy
    {:batchPercentage number,
     :batchNodeCount integer,
     :batchSoakDuration string},
    :nodePoolSoakDuration string}}},
 :parent string}"
  [projectId zone clusterId CreateNodePoolRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools",
     :uri-template-args
     {:projectId projectId, :zone zone, :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateNodePoolRequest}))

(defn projects-zones-clusters-nodePools-setManagement
  "Sets the NodeManagement options for a node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/setManagement

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to update. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool to update. This field has been deprecated and replaced by the name field.
SetNodePoolManagementRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :management
 {:autoUpgrade boolean,
  :autoRepair boolean,
  :upgradeOptions {:autoUpgradeStartTime string, :description string}},
 :name string}"
  [projectId zone clusterId nodePoolId SetNodePoolManagementRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setManagement",
     :uri-template-args
     {:projectId projectId,
      :zone zone,
      :clusterId clusterId,
      :nodePoolId nodePoolId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNodePoolManagementRequest}))

(defn projects-zones-clusters-nodePools-update
  "Updates the version and/or image type for the specified node pool.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/update

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to upgrade. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool to upgrade. This field has been deprecated and replaced by the name field.
UpdateNodePoolRequest:
{:tags {:tags [string]},
 :labels {:labels object},
 :taints
 {:taints
  [{:key string,
    :value string,
    :effect
    [EFFECT_UNSPECIFIED NO_SCHEDULE PREFER_NO_SCHEDULE NO_EXECUTE]}]},
 :nodePoolId string,
 :loggingConfig
 {:variantConfig
  {:variant [VARIANT_UNSPECIFIED DEFAULT MAX_THROUGHPUT]}},
 :zone string,
 :name string,
 :resourceManagerTags {:tags object},
 :clusterId string,
 :etag string,
 :imageType string,
 :machineType string,
 :linuxNodeConfig
 {:sysctls object,
  :cgroupMode [CGROUP_MODE_UNSPECIFIED CGROUP_MODE_V1 CGROUP_MODE_V2],
  :hugepages {:hugepageSize2m integer, :hugepageSize1g integer}},
 :kubeletConfig
 {:cpuManagerPolicy string,
  :cpuCfsQuota boolean,
  :cpuCfsQuotaPeriod string,
  :podPidsLimit string,
  :insecureKubeletReadonlyPortEnabled boolean},
 :locations [string],
 :confidentialNodes {:enabled boolean},
 :nodeNetworkConfig
 {:createPodRange boolean,
  :additionalPodNetworkConfigs
  [{:subnetwork string,
    :secondaryPodRange string,
    :maxPodsPerNode {:maxPodsPerNode string}}],
  :podRange string,
  :networkPerformanceConfig
  {:totalEgressBandwidthTier [TIER_UNSPECIFIED TIER_1]},
  :podCidrOverprovisionConfig {:disable boolean},
  :podIpv4RangeUtilization number,
  :enablePrivateNodes boolean,
  :podIpv4CidrBlock string,
  :additionalNodeNetworkConfigs
  [{:network string, :subnetwork string}]},
 :resourceLabels {:labels object},
 :diskType string,
 :queuedProvisioning {:enabled boolean},
 :projectId string,
 :diskSizeGb string,
 :gcfsConfig {:enabled boolean},
 :workloadMetadataConfig
 {:mode [MODE_UNSPECIFIED GCE_METADATA GKE_METADATA]},
 :containerdConfig
 {:privateRegistryAccessConfig
  {:enabled boolean,
   :certificateAuthorityDomainConfig
   [{:fqdns [string],
     :gcpSecretManagerCertificateConfig {:secretUri string}}]}},
 :fastSocket {:enabled boolean},
 :windowsNodeConfig
 {:osVersion
  [OS_VERSION_UNSPECIFIED OS_VERSION_LTSC2019 OS_VERSION_LTSC2022]},
 :nodeVersion string,
 :accelerators
 [{:acceleratorCount string,
   :acceleratorType string,
   :gpuPartitionSize string,
   :gpuSharingConfig
   {:maxSharedClientsPerGpu string,
    :gpuSharingStrategy
    [GPU_SHARING_STRATEGY_UNSPECIFIED TIME_SHARING MPS]},
   :gpuDriverInstallationConfig
   {:gpuDriverVersion
    [GPU_DRIVER_VERSION_UNSPECIFIED
     INSTALLATION_DISABLED
     DEFAULT
     LATEST]}}],
 :gvnic {:enabled boolean},
 :upgradeSettings
 {:maxSurge integer,
  :maxUnavailable integer,
  :strategy [NODE_POOL_UPDATE_STRATEGY_UNSPECIFIED BLUE_GREEN SURGE],
  :blueGreenSettings
  {:standardRolloutPolicy
   {:batchPercentage number,
    :batchNodeCount integer,
    :batchSoakDuration string},
   :nodePoolSoakDuration string}}}"
  [projectId zone clusterId nodePoolId UpdateNodePoolRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/update",
     :uri-template-args
     {:projectId projectId,
      :zone zone,
      :clusterId clusterId,
      :nodePoolId nodePoolId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpdateNodePoolRequest}))

(defn projects-zones-clusters-nodePools-delete
  "Deletes a node pool from a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/delete

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool to delete. This field has been deprecated and replaced by the name field.

optional:
name <string> The name (project, location, cluster, node pool id) of the node pool to delete. Specified in the format `projects/*/locations/*/clusters/*/nodePools/*`."
  ([projectId zone clusterId nodePoolId]
    (projects-zones-clusters-nodePools-delete
      projectId
      zone
      clusterId
      nodePoolId
      nil))
  ([projectId zone clusterId nodePoolId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}",
       :uri-template-args
       {:projectId projectId,
        :zone zone,
        :clusterId clusterId,
        :nodePoolId nodePoolId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-clusters-nodePools-setSize
  "Sets the size for a specific node pool. The new size will be used for all replicas, including future replicas created by modifying NodePool.locations.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/setSize

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
clusterId <string> Deprecated. The name of the cluster to update. This field has been deprecated and replaced by the name field.
nodePoolId <string> Deprecated. The name of the node pool to update. This field has been deprecated and replaced by the name field.
SetNodePoolSizeRequest:
{:projectId string,
 :zone string,
 :clusterId string,
 :nodePoolId string,
 :nodeCount integer,
 :name string}"
  [projectId zone clusterId nodePoolId SetNodePoolSizeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setSize",
     :uri-template-args
     {:projectId projectId,
      :zone zone,
      :clusterId clusterId,
      :nodePoolId nodePoolId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetNodePoolSizeRequest}))

(defn projects-zones-clusters-nodePools-list
  "Lists the node pools for a cluster.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.clusters.nodePools/list

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the parent field.
clusterId <string> Deprecated. The name of the cluster. This field has been deprecated and replaced by the parent field.

optional:
parent <string> The parent (project, location, cluster name) where the node pools will be listed. Specified in the format `projects/*/locations/*/clusters/*`."
  ([projectId zone clusterId]
    (projects-zones-clusters-nodePools-list
      projectId
      zone
      clusterId
      nil))
  ([projectId zone clusterId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools",
       :uri-template-args
       {:projectId projectId, :zone zone, :clusterId clusterId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-operations-list
  "Lists all operations in a project in a specific zone or all zones.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.operations/list

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the parent field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) to return operations for, or `-` for all zones. This field has been deprecated and replaced by the parent field.

optional:
parent <string> The parent (project and location) where the operations will be listed. Specified in the format `projects/*/locations/*`. Location \"-\" matches all zones and all regions."
  ([projectId zone]
    (projects-zones-operations-list projectId zone nil))
  ([projectId zone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/operations",
       :uri-template-args {:projectId projectId, :zone zone},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-operations-get
  "Gets the specified operation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.operations/get

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the cluster resides. This field has been deprecated and replaced by the name field.
operationId <string> Deprecated. The server-assigned `name` of the operation. This field has been deprecated and replaced by the name field.

optional:
name <string> The name (project, location, operation id) of the operation to get. Specified in the format `projects/*/locations/*/operations/*`."
  ([projectId zone operationId]
    (projects-zones-operations-get projectId zone operationId nil))
  ([projectId zone operationId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/operations/{operationId}",
       :uri-template-args
       {:projectId projectId, :zone zone, :operationId operationId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-zones-operations-cancel
  "Cancels the specified operation.
https://cloud.google.com/container-engine/reference/rest/v1/projects.zones.operations/cancel

projectId <string> Deprecated. The Google Developers Console [project ID or project number](https://cloud.google.com/resource-manager/docs/creating-managing-projects). This field has been deprecated and replaced by the name field.
zone <string> Deprecated. The name of the Google Compute Engine [zone](https://cloud.google.com/compute/docs/zones#available) in which the operation resides. This field has been deprecated and replaced by the name field.
operationId <string> Deprecated. The server-assigned `name` of the operation. This field has been deprecated and replaced by the name field.
CancelOperationRequest:
{:projectId string, :zone string, :operationId string, :name string}"
  [projectId zone operationId CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://container.googleapis.com/v1/projects/{projectId}/zones/{zone}/operations/{operationId}:cancel",
     :uri-template-args
     {:projectId projectId, :zone zone, :operationId operationId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-aggregated-usableSubnetworks-list
  "Lists subnetworks that are usable for creating clusters in a project.
https://cloud.google.com/container-engine/reference/rest/v1/projects.aggregated.usableSubnetworks/list

parent <string> The parent project where subnetworks are usable. Specified in the format `projects/*`.

optional:
filter <string> Filtering currently only supports equality on the networkProjectId and must be in the form: \"networkProjectId=[PROJECTID]\", where `networkProjectId` is the project which owns the listed subnetworks. This defaults to the parent project ID.
pageSize <integer> The max number of results per page that should be returned. If the number of available results is larger than `page_size`, a `next_page_token` is returned which can be used to get the next page of results in subsequent requests. Acceptable values are 0 to 500, inclusive. (Default: 500)"
  ([parent] (projects-aggregated-usableSubnetworks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://container.googleapis.com/v1/{+parent}/aggregated/usableSubnetworks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

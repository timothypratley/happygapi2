(ns happygapi2.dataproc
  "Cloud Dataproc API
Manages Hadoop-based clusters and jobs on Google Cloud Platform.
See: https://cloud.google.com/dataproc/"
  (:require [happy.oauth2.client :as client]))

(defn projects-regions-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-regions-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataproc.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-operations-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.operations/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-regions-operations-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.operations/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-regions-operations-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.operations/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-regions-autoscalingPolicies-create
  "Creates new autoscaling policy.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/create

parent <string> Required. The \"resource name\" of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.create, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.autoscalingPolicies.create, the resource name of the location has the following format: projects/{project_id}/locations/{location}
AutoscalingPolicy:
{:id string,
 :name string,
 :basicAlgorithm
 {:yarnConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number},
  :sparkStandaloneConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number,
   :removeOnlyIdleWorkers boolean},
  :cooldownPeriod string},
 :workerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :secondaryWorkerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :labels object}"
  [parent AutoscalingPolicy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+parent}/autoscalingPolicies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AutoscalingPolicy}))

(defn projects-regions-autoscalingPolicies-update
  "Updates (replaces) autoscaling policy.Disabled check for update_mask, because all updates will be full replacements.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/update

name <string> Output only. The \"resource name\" of the autoscaling policy, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies, the resource name of the policy has the following format: projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id} For projects.locations.autoscalingPolicies, the resource name of the policy has the following format: projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}
AutoscalingPolicy:
{:id string,
 :name string,
 :basicAlgorithm
 {:yarnConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number},
  :sparkStandaloneConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number,
   :removeOnlyIdleWorkers boolean},
  :cooldownPeriod string},
 :workerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :secondaryWorkerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :labels object}"
  [name AutoscalingPolicy]
  (client/api-request
    {:method "PUT",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AutoscalingPolicy}))

(defn projects-regions-autoscalingPolicies-get
  "Retrieves autoscaling policy.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/get

name <string> Required. The \"resource name\" of the autoscaling policy, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.get, the resource name of the policy has the following format: projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id} For projects.locations.autoscalingPolicies.get, the resource name of the policy has the following format: projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-autoscalingPolicies-list
  "Lists autoscaling policies in the project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/list

parent <string> Required. The \"resource name\" of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.list, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.autoscalingPolicies.list, the resource name of the location has the following format: projects/{project_id}/locations/{location}

optional:
pageSize <integer> Optional. The maximum number of results to return in each response. Must be less than or equal to 1000. Defaults to 100."
  ([parent] (projects-regions-autoscalingPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/autoscalingPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-autoscalingPolicies-delete
  "Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by one or more clusters.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/delete

name <string> Required. The \"resource name\" of the autoscaling policy, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.delete, the resource name of the policy has the following format: projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id} For projects.locations.autoscalingPolicies.delete, the resource name of the policy has the following format: projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-autoscalingPolicies-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-regions-autoscalingPolicies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-regions-autoscalingPolicies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.autoscalingPolicies/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-regions-clusters-get
  "Gets the resource representation for a cluster in a project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/get

projectId <string> Required. The ID of the Google Cloud Platform project that the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
clusterName <string> Required. The cluster name."
  [projectId region clusterName]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}",
     :uri-template-args
     {:projectId projectId, :region region, :clusterName clusterName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-clusters-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-regions-clusters-patch
  "Updates a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata). The cluster must be in a RUNNING state or an error is returned.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/patch

projectId <string> Required. The ID of the Google Cloud Platform project the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
clusterName <string> Required. The cluster name.
Cluster:
{:labels object,
 :clusterName string,
 :virtualClusterConfig
 {:stagingBucket string,
  :kubernetesClusterConfig
  {:kubernetesNamespace string,
   :gkeClusterConfig
   {:namespacedGkeDeploymentTarget
    {:targetGkeCluster string, :clusterNamespace string},
    :gkeClusterTarget string,
    :nodePoolTarget
    [{:nodePool string,
      :roles
      [[ROLE_UNSPECIFIED
        DEFAULT
        CONTROLLER
        SPARK_DRIVER
        SPARK_EXECUTOR]],
      :nodePoolConfig GkeNodePoolConfig}]},
   :kubernetesSoftwareConfig
   {:componentVersion object, :properties object}},
  :auxiliaryServicesConfig
  {:metastoreConfig {:dataprocMetastoreService string},
   :sparkHistoryServerConfig {:dataprocCluster string}}},
 :config
 {:configBucket string,
  :gceClusterConfig
  {:serviceAccount string,
   :tags [string],
   :shieldedInstanceConfig
   {:enableSecureBoot boolean,
    :enableVtpm boolean,
    :enableIntegrityMonitoring boolean},
   :nodeGroupAffinity {:nodeGroupUri string},
   :serviceAccountScopes [string],
   :privateIpv6GoogleAccess
   [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
    INHERIT_FROM_SUBNETWORK
    OUTBOUND
    BIDIRECTIONAL],
   :confidentialInstanceConfig {:enableConfidentialCompute boolean},
   :networkUri string,
   :reservationAffinity
   {:consumeReservationType
    [TYPE_UNSPECIFIED
     NO_RESERVATION
     ANY_RESERVATION
     SPECIFIC_RESERVATION],
    :key string,
    :values [string]},
   :subnetworkUri string,
   :metadata object,
   :zoneUri string,
   :internalIpOnly boolean},
  :auxiliaryNodeGroups
  [{:nodeGroup
    {:name string,
     :roles [[ROLE_UNSPECIFIED DRIVER]],
     :nodeGroupConfig
     {:minNumInstances integer,
      :diskConfig DiskConfig,
      :preemptibility
      [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
      :imageUri string,
      :startupConfig StartupConfig,
      :numInstances integer,
      :instanceNames [string],
      :managedGroupConfig ManagedGroupConfig,
      :instanceReferences [InstanceReference],
      :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
      :isPreemptible boolean,
      :machineTypeUri string,
      :accelerators [AcceleratorConfig],
      :minCpuPlatform string},
     :labels object},
    :nodeGroupId string}],
  :metastoreConfig {:dataprocMetastoreService string},
  :dataprocMetricConfig
  {:metrics
   [{:metricSource
     [METRIC_SOURCE_UNSPECIFIED
      MONITORING_AGENT_DEFAULTS
      HDFS
      SPARK
      YARN
      SPARK_HISTORY_SERVER
      HIVESERVER2
      HIVEMETASTORE
      FLINK],
     :metricOverrides [string]}]},
  :softwareConfig
  {:imageVersion string,
   :properties object,
   :optionalComponents
   [[COMPONENT_UNSPECIFIED
     ANACONDA
     DOCKER
     DRUID
     FLINK
     HBASE
     HIVE_WEBHCAT
     HUDI
     JUPYTER
     PRESTO
     TRINO
     RANGER
     SOLR
     ZEPPELIN
     ZOOKEEPER]]},
  :workerConfig
  {:minNumInstances integer,
   :diskConfig
   {:bootDiskType string,
    :bootDiskSizeGb integer,
    :numLocalSsds integer,
    :localSsdInterface string},
   :preemptibility
   [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
   :imageUri string,
   :startupConfig {:requiredRegistrationFraction number},
   :numInstances integer,
   :instanceNames [string],
   :managedGroupConfig
   {:instanceTemplateName string,
    :instanceGroupManagerName string,
    :instanceGroupManagerUri string},
   :instanceReferences
   [{:instanceName string,
     :instanceId string,
     :publicKey string,
     :publicEciesKey string}],
   :instanceFlexibilityPolicy
   {:instanceSelectionList [{:machineTypes [string], :rank integer}],
    :instanceSelectionResults
    [{:machineType string, :vmCount integer}]},
   :isPreemptible boolean,
   :machineTypeUri string,
   :accelerators
   [{:acceleratorTypeUri string, :acceleratorCount integer}],
   :minCpuPlatform string},
  :initializationActions
  [{:executableFile string, :executionTimeout string}],
  :securityConfig
  {:kerberosConfig
   {:kmsKeyUri string,
    :truststorePasswordUri string,
    :keyPasswordUri string,
    :kdcDbKeyUri string,
    :realm string,
    :tgtLifetimeHours integer,
    :keystoreUri string,
    :crossRealmTrustAdminServer string,
    :enableKerberos boolean,
    :crossRealmTrustKdc string,
    :rootPrincipalPasswordUri string,
    :keystorePasswordUri string,
    :crossRealmTrustRealm string,
    :truststoreUri string,
    :crossRealmTrustSharedPasswordUri string},
   :identityConfig {:userServiceAccountMapping object}},
  :masterConfig
  {:minNumInstances integer,
   :diskConfig
   {:bootDiskType string,
    :bootDiskSizeGb integer,
    :numLocalSsds integer,
    :localSsdInterface string},
   :preemptibility
   [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
   :imageUri string,
   :startupConfig {:requiredRegistrationFraction number},
   :numInstances integer,
   :instanceNames [string],
   :managedGroupConfig
   {:instanceTemplateName string,
    :instanceGroupManagerName string,
    :instanceGroupManagerUri string},
   :instanceReferences
   [{:instanceName string,
     :instanceId string,
     :publicKey string,
     :publicEciesKey string}],
   :instanceFlexibilityPolicy
   {:instanceSelectionList [{:machineTypes [string], :rank integer}],
    :instanceSelectionResults
    [{:machineType string, :vmCount integer}]},
   :isPreemptible boolean,
   :machineTypeUri string,
   :accelerators
   [{:acceleratorTypeUri string, :acceleratorCount integer}],
   :minCpuPlatform string},
  :lifecycleConfig
  {:idleDeleteTtl string,
   :autoDeleteTime string,
   :autoDeleteTtl string,
   :idleStartTime string},
  :secondaryWorkerConfig
  {:minNumInstances integer,
   :diskConfig
   {:bootDiskType string,
    :bootDiskSizeGb integer,
    :numLocalSsds integer,
    :localSsdInterface string},
   :preemptibility
   [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
   :imageUri string,
   :startupConfig {:requiredRegistrationFraction number},
   :numInstances integer,
   :instanceNames [string],
   :managedGroupConfig
   {:instanceTemplateName string,
    :instanceGroupManagerName string,
    :instanceGroupManagerUri string},
   :instanceReferences
   [{:instanceName string,
     :instanceId string,
     :publicKey string,
     :publicEciesKey string}],
   :instanceFlexibilityPolicy
   {:instanceSelectionList [{:machineTypes [string], :rank integer}],
    :instanceSelectionResults
    [{:machineType string, :vmCount integer}]},
   :isPreemptible boolean,
   :machineTypeUri string,
   :accelerators
   [{:acceleratorTypeUri string, :acceleratorCount integer}],
   :minCpuPlatform string},
  :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
  :tempBucket string,
  :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
  :gkeClusterConfig
  {:namespacedGkeDeploymentTarget
   {:targetGkeCluster string, :clusterNamespace string},
   :gkeClusterTarget string,
   :nodePoolTarget
   [{:nodePool string,
     :roles
     [[ROLE_UNSPECIFIED
       DEFAULT
       CONTROLLER
       SPARK_DRIVER
       SPARK_EXECUTOR]],
     :nodePoolConfig
     {:config GkeNodeConfig,
      :locations [string],
      :autoscaling GkeNodePoolAutoscalingConfig}}]},
  :autoscalingConfig {:policyUri string}},
 :status
 {:state
  [UNKNOWN
   CREATING
   RUNNING
   ERROR
   ERROR_DUE_TO_UPDATE
   DELETING
   UPDATING
   STOPPING
   STOPPED
   STARTING
   REPAIRING],
  :detail string,
  :stateStartTime string,
  :substate [UNSPECIFIED UNHEALTHY STALE_STATUS]},
 :projectId string,
 :clusterUuid string,
 :metrics {:hdfsMetrics object, :yarnMetrics object},
 :statusHistory
 [{:state
   [UNKNOWN
    CREATING
    RUNNING
    ERROR
    ERROR_DUE_TO_UPDATE
    DELETING
    UPDATING
    STOPPING
    STOPPED
    STARTING
    REPAIRING],
   :detail string,
   :stateStartTime string,
   :substate [UNSPECIFIED UNHEALTHY STALE_STATUS]}]}

optional:
gracefulDecommissionTimeout <string> Optional. Timeout for graceful YARN decommissioning. Graceful decommissioning allows removing nodes from the cluster without interrupting jobs in progress. Timeout specifies how long to wait for jobs in progress to finish before forcefully removing nodes (and potentially interrupting jobs). Default timeout is 0 (for forceful decommission), and the maximum allowed timeout is 1 day. (see JSON representation of Duration (https://developers.google.com/protocol-buffers/docs/proto3#json)).Only supported on Dataproc image versions 1.2 and higher.
updateMask <string> Required. Specifies the path, relative to Cluster, of the field to update. For example, to change the number of workers in a cluster to 5, the update_mask parameter would be specified as config.worker_config.num_instances, and the PATCH request body would specify the new value, as follows: { \"config\":{ \"workerConfig\":{ \"numInstances\":\"5\" } } } Similarly, to change the number of preemptible workers in a cluster to 5, the update_mask parameter would be config.secondary_worker_config.num_instances, and the PATCH request body would be set as follows: { \"config\":{ \"secondaryWorkerConfig\":{ \"numInstances\":\"5\" } } } *Note:* Currently, only the following fields can be updated: *Mask* *Purpose* *labels* Update labels *config.worker_config.num_instances* Resize primary worker group *config.secondary_worker_config.num_instances* Resize secondary worker group config.autoscaling_config.policy_uri Use, stop using, or change autoscaling policies 
requestId <string> Optional. A unique ID used to identify the request. If the server receives two UpdateClusterRequest (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#google.cloud.dataproc.v1.UpdateClusterRequest)s with the same id, then the second request will be ignored and the first google.longrunning.Operation created and stored in the backend is returned.It is recommended to always set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([projectId region clusterName Cluster]
    (projects-regions-clusters-patch
      projectId
      region
      clusterName
      Cluster
      nil))
  ([projectId region clusterName Cluster optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}",
       :uri-template-args
       {:projectId projectId,
        :region region,
        :clusterName clusterName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-regions-clusters-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-regions-clusters-injectCredentials
  "Inject encrypted credentials into all of the VMs in a cluster.The target cluster must be a personal auth cluster assigned to the user who is issuing the RPC.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/injectCredentials

project <string> Required. The ID of the Google Cloud Platform project the cluster belongs to, of the form projects/.
region <string> Required. The region containing the cluster, of the form regions/.
cluster <string> Required. The cluster, in the form clusters/.
InjectCredentialsRequest:
{:clusterUuid string, :credentialsCiphertext string}"
  [project region cluster InjectCredentialsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+project}/{+region}/{+cluster}:injectCredentials",
     :uri-template-args
     {:project project, :region region, :cluster cluster},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InjectCredentialsRequest}))

(defn projects-regions-clusters-create
  "Creates a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/create

projectId <string> Required. The ID of the Google Cloud Platform project that the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
Cluster:
{:labels object,
 :clusterName string,
 :virtualClusterConfig
 {:stagingBucket string,
  :kubernetesClusterConfig
  {:kubernetesNamespace string,
   :gkeClusterConfig
   {:namespacedGkeDeploymentTarget
    {:targetGkeCluster string, :clusterNamespace string},
    :gkeClusterTarget string,
    :nodePoolTarget
    [{:nodePool string,
      :roles
      [[ROLE_UNSPECIFIED
        DEFAULT
        CONTROLLER
        SPARK_DRIVER
        SPARK_EXECUTOR]],
      :nodePoolConfig GkeNodePoolConfig}]},
   :kubernetesSoftwareConfig
   {:componentVersion object, :properties object}},
  :auxiliaryServicesConfig
  {:metastoreConfig {:dataprocMetastoreService string},
   :sparkHistoryServerConfig {:dataprocCluster string}}},
 :config
 {:configBucket string,
  :gceClusterConfig
  {:serviceAccount string,
   :tags [string],
   :shieldedInstanceConfig
   {:enableSecureBoot boolean,
    :enableVtpm boolean,
    :enableIntegrityMonitoring boolean},
   :nodeGroupAffinity {:nodeGroupUri string},
   :serviceAccountScopes [string],
   :privateIpv6GoogleAccess
   [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
    INHERIT_FROM_SUBNETWORK
    OUTBOUND
    BIDIRECTIONAL],
   :confidentialInstanceConfig {:enableConfidentialCompute boolean},
   :networkUri string,
   :reservationAffinity
   {:consumeReservationType
    [TYPE_UNSPECIFIED
     NO_RESERVATION
     ANY_RESERVATION
     SPECIFIC_RESERVATION],
    :key string,
    :values [string]},
   :subnetworkUri string,
   :metadata object,
   :zoneUri string,
   :internalIpOnly boolean},
  :auxiliaryNodeGroups
  [{:nodeGroup
    {:name string,
     :roles [[ROLE_UNSPECIFIED DRIVER]],
     :nodeGroupConfig
     {:minNumInstances integer,
      :diskConfig DiskConfig,
      :preemptibility
      [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
      :imageUri string,
      :startupConfig StartupConfig,
      :numInstances integer,
      :instanceNames [string],
      :managedGroupConfig ManagedGroupConfig,
      :instanceReferences [InstanceReference],
      :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
      :isPreemptible boolean,
      :machineTypeUri string,
      :accelerators [AcceleratorConfig],
      :minCpuPlatform string},
     :labels object},
    :nodeGroupId string}],
  :metastoreConfig {:dataprocMetastoreService string},
  :dataprocMetricConfig
  {:metrics
   [{:metricSource
     [METRIC_SOURCE_UNSPECIFIED
      MONITORING_AGENT_DEFAULTS
      HDFS
      SPARK
      YARN
      SPARK_HISTORY_SERVER
      HIVESERVER2
      HIVEMETASTORE
      FLINK],
     :metricOverrides [string]}]},
  :softwareConfig
  {:imageVersion string,
   :properties object,
   :optionalComponents
   [[COMPONENT_UNSPECIFIED
     ANACONDA
     DOCKER
     DRUID
     FLINK
     HBASE
     HIVE_WEBHCAT
     HUDI
     JUPYTER
     PRESTO
     TRINO
     RANGER
     SOLR
     ZEPPELIN
     ZOOKEEPER]]},
  :workerConfig
  {:minNumInstances integer,
   :diskConfig
   {:bootDiskType string,
    :bootDiskSizeGb integer,
    :numLocalSsds integer,
    :localSsdInterface string},
   :preemptibility
   [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
   :imageUri string,
   :startupConfig {:requiredRegistrationFraction number},
   :numInstances integer,
   :instanceNames [string],
   :managedGroupConfig
   {:instanceTemplateName string,
    :instanceGroupManagerName string,
    :instanceGroupManagerUri string},
   :instanceReferences
   [{:instanceName string,
     :instanceId string,
     :publicKey string,
     :publicEciesKey string}],
   :instanceFlexibilityPolicy
   {:instanceSelectionList [{:machineTypes [string], :rank integer}],
    :instanceSelectionResults
    [{:machineType string, :vmCount integer}]},
   :isPreemptible boolean,
   :machineTypeUri string,
   :accelerators
   [{:acceleratorTypeUri string, :acceleratorCount integer}],
   :minCpuPlatform string},
  :initializationActions
  [{:executableFile string, :executionTimeout string}],
  :securityConfig
  {:kerberosConfig
   {:kmsKeyUri string,
    :truststorePasswordUri string,
    :keyPasswordUri string,
    :kdcDbKeyUri string,
    :realm string,
    :tgtLifetimeHours integer,
    :keystoreUri string,
    :crossRealmTrustAdminServer string,
    :enableKerberos boolean,
    :crossRealmTrustKdc string,
    :rootPrincipalPasswordUri string,
    :keystorePasswordUri string,
    :crossRealmTrustRealm string,
    :truststoreUri string,
    :crossRealmTrustSharedPasswordUri string},
   :identityConfig {:userServiceAccountMapping object}},
  :masterConfig
  {:minNumInstances integer,
   :diskConfig
   {:bootDiskType string,
    :bootDiskSizeGb integer,
    :numLocalSsds integer,
    :localSsdInterface string},
   :preemptibility
   [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
   :imageUri string,
   :startupConfig {:requiredRegistrationFraction number},
   :numInstances integer,
   :instanceNames [string],
   :managedGroupConfig
   {:instanceTemplateName string,
    :instanceGroupManagerName string,
    :instanceGroupManagerUri string},
   :instanceReferences
   [{:instanceName string,
     :instanceId string,
     :publicKey string,
     :publicEciesKey string}],
   :instanceFlexibilityPolicy
   {:instanceSelectionList [{:machineTypes [string], :rank integer}],
    :instanceSelectionResults
    [{:machineType string, :vmCount integer}]},
   :isPreemptible boolean,
   :machineTypeUri string,
   :accelerators
   [{:acceleratorTypeUri string, :acceleratorCount integer}],
   :minCpuPlatform string},
  :lifecycleConfig
  {:idleDeleteTtl string,
   :autoDeleteTime string,
   :autoDeleteTtl string,
   :idleStartTime string},
  :secondaryWorkerConfig
  {:minNumInstances integer,
   :diskConfig
   {:bootDiskType string,
    :bootDiskSizeGb integer,
    :numLocalSsds integer,
    :localSsdInterface string},
   :preemptibility
   [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
   :imageUri string,
   :startupConfig {:requiredRegistrationFraction number},
   :numInstances integer,
   :instanceNames [string],
   :managedGroupConfig
   {:instanceTemplateName string,
    :instanceGroupManagerName string,
    :instanceGroupManagerUri string},
   :instanceReferences
   [{:instanceName string,
     :instanceId string,
     :publicKey string,
     :publicEciesKey string}],
   :instanceFlexibilityPolicy
   {:instanceSelectionList [{:machineTypes [string], :rank integer}],
    :instanceSelectionResults
    [{:machineType string, :vmCount integer}]},
   :isPreemptible boolean,
   :machineTypeUri string,
   :accelerators
   [{:acceleratorTypeUri string, :acceleratorCount integer}],
   :minCpuPlatform string},
  :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
  :tempBucket string,
  :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
  :gkeClusterConfig
  {:namespacedGkeDeploymentTarget
   {:targetGkeCluster string, :clusterNamespace string},
   :gkeClusterTarget string,
   :nodePoolTarget
   [{:nodePool string,
     :roles
     [[ROLE_UNSPECIFIED
       DEFAULT
       CONTROLLER
       SPARK_DRIVER
       SPARK_EXECUTOR]],
     :nodePoolConfig
     {:config GkeNodeConfig,
      :locations [string],
      :autoscaling GkeNodePoolAutoscalingConfig}}]},
  :autoscalingConfig {:policyUri string}},
 :status
 {:state
  [UNKNOWN
   CREATING
   RUNNING
   ERROR
   ERROR_DUE_TO_UPDATE
   DELETING
   UPDATING
   STOPPING
   STOPPED
   STARTING
   REPAIRING],
  :detail string,
  :stateStartTime string,
  :substate [UNSPECIFIED UNHEALTHY STALE_STATUS]},
 :projectId string,
 :clusterUuid string,
 :metrics {:hdfsMetrics object, :yarnMetrics object},
 :statusHistory
 [{:state
   [UNKNOWN
    CREATING
    RUNNING
    ERROR
    ERROR_DUE_TO_UPDATE
    DELETING
    UPDATING
    STOPPING
    STOPPED
    STARTING
    REPAIRING],
   :detail string,
   :stateStartTime string,
   :substate [UNSPECIFIED UNHEALTHY STALE_STATUS]}]}

optional:
requestId <string> Optional. A unique ID used to identify the request. If the server receives two CreateClusterRequest (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#google.cloud.dataproc.v1.CreateClusterRequest)s with the same id, then the second request will be ignored and the first google.longrunning.Operation created and stored in the backend is returned.It is recommended to always set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
actionOnFailedPrimaryWorkers <string> Optional. Failure action when primary worker creation fails."
  ([projectId region Cluster]
    (projects-regions-clusters-create projectId region Cluster nil))
  ([projectId region Cluster optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters",
       :uri-template-args {:projectId projectId, :region region},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-regions-clusters-start
  "Starts a cluster in a project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/start

projectId <string> Required. The ID of the Google Cloud Platform project the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
clusterName <string> Required. The cluster name.
StartClusterRequest:
{:clusterUuid string, :requestId string}"
  [projectId region clusterName StartClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:start",
     :uri-template-args
     {:projectId projectId, :region region, :clusterName clusterName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartClusterRequest}))

(defn projects-regions-clusters-repair
  "Repairs a cluster.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/repair

projectId <string> Required. The ID of the Google Cloud Platform project the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
clusterName <string> Required. The cluster name.
RepairClusterRequest:
{:clusterUuid string,
 :requestId string,
 :nodePools
 [{:id string,
   :instanceNames [string],
   :repairAction [REPAIR_ACTION_UNSPECIFIED DELETE]}],
 :gracefulDecommissionTimeout string,
 :parentOperationId string}"
  [projectId region clusterName RepairClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:repair",
     :uri-template-args
     {:projectId projectId, :region region, :clusterName clusterName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RepairClusterRequest}))

(defn projects-regions-clusters-delete
  "Deletes a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata).
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/delete

projectId <string> Required. The ID of the Google Cloud Platform project that the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
clusterName <string> Required. The cluster name.

optional:
clusterUuid <string> Optional. Specifying the cluster_uuid means the RPC should fail (with error NOT_FOUND) if cluster with specified UUID does not exist.
requestId <string> Optional. A unique ID used to identify the request. If the server receives two DeleteClusterRequest (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#google.cloud.dataproc.v1.DeleteClusterRequest)s with the same id, then the second request will be ignored and the first google.longrunning.Operation created and stored in the backend is returned.It is recommended to always set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
gracefulTerminationTimeout <string> Optional. The graceful termination timeout for the deletion of the cluster. Indicate the time the request will wait to complete the running jobs on the cluster before its forceful deletion. Default value is 0 indicating that the user has not enabled the graceful termination. Value can be between 60 second and 6 Hours, in case the graceful termination is enabled. (There is no separate flag to check the enabling or disabling of graceful termination, it can be checked by the values in the field)."
  ([projectId region clusterName]
    (projects-regions-clusters-delete
      projectId
      region
      clusterName
      nil))
  ([projectId region clusterName optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}",
       :uri-template-args
       {:projectId projectId,
        :region region,
        :clusterName clusterName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-clusters-diagnose
  "Gets cluster diagnostic information. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata). After the operation completes, Operation.response contains DiagnoseClusterResults (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults).
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/diagnose

projectId <string> Required. The ID of the Google Cloud Platform project that the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
clusterName <string> Required. The cluster name.
DiagnoseClusterRequest:
{:tarballGcsDir string,
 :tarballAccess
 [TARBALL_ACCESS_UNSPECIFIED
  GOOGLE_CLOUD_SUPPORT
  GOOGLE_DATAPROC_DIAGNOSE],
 :diagnosisInterval {:startTime string, :endTime string},
 :job string,
 :yarnApplicationId string,
 :jobs [string],
 :yarnApplicationIds [string]}"
  [projectId region clusterName DiagnoseClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:diagnose",
     :uri-template-args
     {:projectId projectId, :region region, :clusterName clusterName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DiagnoseClusterRequest}))

(defn projects-regions-clusters-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-regions-clusters-stop
  "Stops a cluster in a project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/stop

projectId <string> Required. The ID of the Google Cloud Platform project the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.
clusterName <string> Required. The cluster name.
StopClusterRequest:
{:clusterUuid string, :requestId string}"
  [projectId region clusterName StopClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:stop",
     :uri-template-args
     {:projectId projectId, :region region, :clusterName clusterName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StopClusterRequest}))

(defn projects-regions-clusters-list
  "Lists all regions/{region}/clusters in a project alphabetically.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters/list

projectId <string> Required. The ID of the Google Cloud Platform project that the cluster belongs to.
region <string> Required. The Dataproc region in which to handle the request.

optional:
filter <string> Optional. A filter constraining the clusters to list. Filters are case-sensitive and have the following syntax:field = value AND field = value ...where field is one of status.state, clusterName, or labels.[KEY], and [KEY] is a label key. value can be * to match all values. status.state can be one of the following: ACTIVE, INACTIVE, CREATING, RUNNING, ERROR, DELETING, UPDATING, STOPPING, or STOPPED. ACTIVE contains the CREATING, UPDATING, and RUNNING states. INACTIVE contains the DELETING, ERROR, STOPPING, and STOPPED states. clusterName is the name of the cluster provided at creation time. Only the logical AND operator is supported; space-separated items are treated as having an implicit AND operator.Example filter:status.state = ACTIVE AND clusterName = mycluster AND labels.env = staging AND labels.starred = *
pageSize <integer> Optional. The standard List page size."
  ([projectId region]
    (projects-regions-clusters-list projectId region nil))
  ([projectId region optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/clusters",
       :uri-template-args {:projectId projectId, :region region},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-clusters-nodeGroups-create
  "Creates a node group in a cluster. The returned Operation.metadata is NodeGroupOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters.nodeGroups/create

parent <string> Required. The parent resource where this node group will be created. Format: projects/{project}/regions/{region}/clusters/{cluster}
NodeGroup:
{:name string,
 :roles [[ROLE_UNSPECIFIED DRIVER]],
 :nodeGroupConfig
 {:minNumInstances integer,
  :diskConfig
  {:bootDiskType string,
   :bootDiskSizeGb integer,
   :numLocalSsds integer,
   :localSsdInterface string},
  :preemptibility
  [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
  :imageUri string,
  :startupConfig {:requiredRegistrationFraction number},
  :numInstances integer,
  :instanceNames [string],
  :managedGroupConfig
  {:instanceTemplateName string,
   :instanceGroupManagerName string,
   :instanceGroupManagerUri string},
  :instanceReferences
  [{:instanceName string,
    :instanceId string,
    :publicKey string,
    :publicEciesKey string}],
  :instanceFlexibilityPolicy
  {:instanceSelectionList [{:machineTypes [string], :rank integer}],
   :instanceSelectionResults
   [{:machineType string, :vmCount integer}]},
  :isPreemptible boolean,
  :machineTypeUri string,
  :accelerators
  [{:acceleratorTypeUri string, :acceleratorCount integer}],
  :minCpuPlatform string},
 :labels object}

optional:
nodeGroupId <string> Optional. An optional node group ID. Generated if not specified.The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). Cannot begin or end with underscore or hyphen. Must consist of from 3 to 33 characters.
requestId <string> Optional. A unique ID used to identify the request. If the server receives two CreateNodeGroupRequest (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#google.cloud.dataproc.v1.CreateNodeGroupRequest) with the same ID, the second request is ignored and the first google.longrunning.Operation created and stored in the backend is returned.Recommendation: Set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
parentOperationId <string> Optional. operation id of the parent operation sending the create request"
  ([parent NodeGroup]
    (projects-regions-clusters-nodeGroups-create parent NodeGroup nil))
  ([parent NodeGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/nodeGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NodeGroup})))

(defn projects-regions-clusters-nodeGroups-resize
  "Resizes a node group in a cluster. The returned Operation.metadata is NodeGroupOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata).
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters.nodeGroups/resize

name <string> Required. The name of the node group to resize. Format: projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{nodeGroup}
ResizeNodeGroupRequest:
{:size integer,
 :requestId string,
 :gracefulDecommissionTimeout string,
 :parentOperationId string}"
  [name ResizeNodeGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}:resize",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResizeNodeGroupRequest}))

(defn projects-regions-clusters-nodeGroups-repair
  "Repair nodes in a node group.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters.nodeGroups/repair

name <string> Required. The name of the node group to resize. Format: projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{nodeGroup}
RepairNodeGroupRequest:
{:instanceNames [string],
 :repairAction [REPAIR_ACTION_UNSPECIFIED REPLACE],
 :requestId string}"
  [name RepairNodeGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}:repair",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RepairNodeGroupRequest}))

(defn projects-regions-clusters-nodeGroups-get
  "Gets the resource representation for a node group in a cluster.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.clusters.nodeGroups/get

name <string> Required. The name of the node group to retrieve. Format: projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{nodeGroup}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-jobs-get
  "Gets the resource representation for a job in a project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/get

projectId <string> Required. The ID of the Google Cloud Platform project that the job belongs to.
region <string> Required. The Dataproc region in which to handle the request.
jobId <string> Required. The job ID."
  [projectId region jobId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/jobs/{jobId}",
     :uri-template-args
     {:projectId projectId, :region region, :jobId jobId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-jobs-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-regions-jobs-patch
  "Updates a job in a project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/patch

projectId <string> Required. The ID of the Google Cloud Platform project that the job belongs to.
region <string> Required. The Dataproc region in which to handle the request.
jobId <string> Required. The job ID.
Job:
{:flinkJob
 {:mainJarFileUri string,
  :mainClass string,
  :args [string],
  :jarFileUris [string],
  :savepointUri string,
  :properties object,
  :loggingConfig {:driverLogLevels object}},
 :labels object,
 :sparkSqlJob
 {:queryFileUri string,
  :queryList {:queries [string]},
  :scriptVariables object,
  :properties object,
  :jarFileUris [string],
  :loggingConfig {:driverLogLevels object}},
 :prestoJob
 {:queryFileUri string,
  :queryList {:queries [string]},
  :continueOnFailure boolean,
  :outputFormat string,
  :clientTags [string],
  :properties object,
  :loggingConfig {:driverLogLevels object}},
 :scheduling {:maxFailuresPerHour integer, :maxFailuresTotal integer},
 :done boolean,
 :driverOutputResourceUri string,
 :pigJob
 {:queryFileUri string,
  :queryList {:queries [string]},
  :continueOnFailure boolean,
  :scriptVariables object,
  :properties object,
  :jarFileUris [string],
  :loggingConfig {:driverLogLevels object}},
 :yarnApplications
 [{:name string,
   :state
   [STATE_UNSPECIFIED
    NEW
    NEW_SAVING
    SUBMITTED
    ACCEPTED
    RUNNING
    FINISHED
    FAILED
    KILLED],
   :progress number,
   :trackingUrl string}],
 :hiveJob
 {:queryFileUri string,
  :queryList {:queries [string]},
  :continueOnFailure boolean,
  :scriptVariables object,
  :properties object,
  :jarFileUris [string]},
 :sparkJob
 {:mainJarFileUri string,
  :mainClass string,
  :args [string],
  :jarFileUris [string],
  :fileUris [string],
  :archiveUris [string],
  :properties object,
  :loggingConfig {:driverLogLevels object}},
 :reference {:projectId string, :jobId string},
 :trinoJob
 {:queryFileUri string,
  :queryList {:queries [string]},
  :continueOnFailure boolean,
  :outputFormat string,
  :clientTags [string],
  :properties object,
  :loggingConfig {:driverLogLevels object}},
 :status
 {:state
  [STATE_UNSPECIFIED
   PENDING
   SETUP_DONE
   RUNNING
   CANCEL_PENDING
   CANCEL_STARTED
   CANCELLED
   DONE
   ERROR
   ATTEMPT_FAILURE],
  :details string,
  :stateStartTime string,
  :substate [UNSPECIFIED SUBMITTED QUEUED STALE_STATUS]},
 :pysparkJob
 {:mainPythonFileUri string,
  :args [string],
  :pythonFileUris [string],
  :jarFileUris [string],
  :fileUris [string],
  :archiveUris [string],
  :properties object,
  :loggingConfig {:driverLogLevels object}},
 :sparkRJob
 {:mainRFileUri string,
  :args [string],
  :fileUris [string],
  :archiveUris [string],
  :properties object,
  :loggingConfig {:driverLogLevels object}},
 :driverSchedulingConfig {:memoryMb integer, :vcores integer},
 :jobUuid string,
 :placement
 {:clusterName string, :clusterUuid string, :clusterLabels object},
 :hadoopJob
 {:mainJarFileUri string,
  :mainClass string,
  :args [string],
  :jarFileUris [string],
  :fileUris [string],
  :archiveUris [string],
  :properties object,
  :loggingConfig {:driverLogLevels object}},
 :driverControlFilesUri string,
 :statusHistory
 [{:state
   [STATE_UNSPECIFIED
    PENDING
    SETUP_DONE
    RUNNING
    CANCEL_PENDING
    CANCEL_STARTED
    CANCELLED
    DONE
    ERROR
    ATTEMPT_FAILURE],
   :details string,
   :stateStartTime string,
   :substate [UNSPECIFIED SUBMITTED QUEUED STALE_STATUS]}]}

optional:
updateMask <string> Required. Specifies the path, relative to Job, of the field to update. For example, to update the labels of a Job the update_mask parameter would be specified as labels, and the PATCH request body would specify the new value. *Note:* Currently, labels is the only field that can be updated."
  ([projectId region jobId Job]
    (projects-regions-jobs-patch projectId region jobId Job nil))
  ([projectId region jobId Job optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/jobs/{jobId}",
       :uri-template-args
       {:projectId projectId, :region region, :jobId jobId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Job})))

(defn projects-regions-jobs-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-regions-jobs-submit
  "Submits a job to a cluster.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/submit

projectId <string> Required. The ID of the Google Cloud Platform project that the job belongs to.
region <string> Required. The Dataproc region in which to handle the request.
SubmitJobRequest:
{:job
 {:flinkJob
  {:mainJarFileUri string,
   :mainClass string,
   :args [string],
   :jarFileUris [string],
   :savepointUri string,
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :labels object,
  :sparkSqlJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :scriptVariables object,
   :properties object,
   :jarFileUris [string],
   :loggingConfig {:driverLogLevels object}},
  :prestoJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :outputFormat string,
   :clientTags [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :scheduling {:maxFailuresPerHour integer, :maxFailuresTotal integer},
  :done boolean,
  :driverOutputResourceUri string,
  :pigJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :scriptVariables object,
   :properties object,
   :jarFileUris [string],
   :loggingConfig {:driverLogLevels object}},
  :yarnApplications
  [{:name string,
    :state
    [STATE_UNSPECIFIED
     NEW
     NEW_SAVING
     SUBMITTED
     ACCEPTED
     RUNNING
     FINISHED
     FAILED
     KILLED],
    :progress number,
    :trackingUrl string}],
  :hiveJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :scriptVariables object,
   :properties object,
   :jarFileUris [string]},
  :sparkJob
  {:mainJarFileUri string,
   :mainClass string,
   :args [string],
   :jarFileUris [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :reference {:projectId string, :jobId string},
  :trinoJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :outputFormat string,
   :clientTags [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :status
  {:state
   [STATE_UNSPECIFIED
    PENDING
    SETUP_DONE
    RUNNING
    CANCEL_PENDING
    CANCEL_STARTED
    CANCELLED
    DONE
    ERROR
    ATTEMPT_FAILURE],
   :details string,
   :stateStartTime string,
   :substate [UNSPECIFIED SUBMITTED QUEUED STALE_STATUS]},
  :pysparkJob
  {:mainPythonFileUri string,
   :args [string],
   :pythonFileUris [string],
   :jarFileUris [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :sparkRJob
  {:mainRFileUri string,
   :args [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :driverSchedulingConfig {:memoryMb integer, :vcores integer},
  :jobUuid string,
  :placement
  {:clusterName string, :clusterUuid string, :clusterLabels object},
  :hadoopJob
  {:mainJarFileUri string,
   :mainClass string,
   :args [string],
   :jarFileUris [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :driverControlFilesUri string,
  :statusHistory
  [{:state
    [STATE_UNSPECIFIED
     PENDING
     SETUP_DONE
     RUNNING
     CANCEL_PENDING
     CANCEL_STARTED
     CANCELLED
     DONE
     ERROR
     ATTEMPT_FAILURE],
    :details string,
    :stateStartTime string,
    :substate [UNSPECIFIED SUBMITTED QUEUED STALE_STATUS]}]},
 :requestId string}"
  [projectId region SubmitJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/jobs:submit",
     :uri-template-args {:projectId projectId, :region region},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SubmitJobRequest}))

(defn projects-regions-jobs-delete
  "Deletes the job from the project. If the job is active, the delete fails, and the response returns FAILED_PRECONDITION.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/delete

projectId <string> Required. The ID of the Google Cloud Platform project that the job belongs to.
region <string> Required. The Dataproc region in which to handle the request.
jobId <string> Required. The job ID."
  [projectId region jobId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/jobs/{jobId}",
     :uri-template-args
     {:projectId projectId, :region region, :jobId jobId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-regions-jobs-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-regions-jobs-list
  "Lists regions/{region}/jobs in a project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/list

projectId <string> Required. The ID of the Google Cloud Platform project that the job belongs to.
region <string> Required. The Dataproc region in which to handle the request.

optional:
pageSize <integer> Optional. The number of results to return in each response.
clusterName <string> Optional. If set, the returned jobs list includes only jobs that were submitted to the named cluster.
jobStateMatcher <string> Optional. Specifies enumerated categories of jobs to list. (default = match ALL jobs).If filter is provided, jobStateMatcher will be ignored.
filter <string> Optional. A filter constraining the jobs to list. Filters are case-sensitive and have the following syntax:field = value AND field = value ...where field is status.state or labels.[KEY], and [KEY] is a label key. value can be * to match all values. status.state can be either ACTIVE or NON_ACTIVE. Only the logical AND operator is supported; space-separated items are treated as having an implicit AND operator.Example filter:status.state = ACTIVE AND labels.env = staging AND labels.starred = *"
  ([projectId region]
    (projects-regions-jobs-list projectId region nil))
  ([projectId region optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/jobs",
       :uri-template-args {:projectId projectId, :region region},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-jobs-submitAsOperation
  "Submits job to a cluster.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/submitAsOperation

projectId <string> Required. The ID of the Google Cloud Platform project that the job belongs to.
region <string> Required. The Dataproc region in which to handle the request.
SubmitJobRequest:
{:job
 {:flinkJob
  {:mainJarFileUri string,
   :mainClass string,
   :args [string],
   :jarFileUris [string],
   :savepointUri string,
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :labels object,
  :sparkSqlJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :scriptVariables object,
   :properties object,
   :jarFileUris [string],
   :loggingConfig {:driverLogLevels object}},
  :prestoJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :outputFormat string,
   :clientTags [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :scheduling {:maxFailuresPerHour integer, :maxFailuresTotal integer},
  :done boolean,
  :driverOutputResourceUri string,
  :pigJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :scriptVariables object,
   :properties object,
   :jarFileUris [string],
   :loggingConfig {:driverLogLevels object}},
  :yarnApplications
  [{:name string,
    :state
    [STATE_UNSPECIFIED
     NEW
     NEW_SAVING
     SUBMITTED
     ACCEPTED
     RUNNING
     FINISHED
     FAILED
     KILLED],
    :progress number,
    :trackingUrl string}],
  :hiveJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :scriptVariables object,
   :properties object,
   :jarFileUris [string]},
  :sparkJob
  {:mainJarFileUri string,
   :mainClass string,
   :args [string],
   :jarFileUris [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :reference {:projectId string, :jobId string},
  :trinoJob
  {:queryFileUri string,
   :queryList {:queries [string]},
   :continueOnFailure boolean,
   :outputFormat string,
   :clientTags [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :status
  {:state
   [STATE_UNSPECIFIED
    PENDING
    SETUP_DONE
    RUNNING
    CANCEL_PENDING
    CANCEL_STARTED
    CANCELLED
    DONE
    ERROR
    ATTEMPT_FAILURE],
   :details string,
   :stateStartTime string,
   :substate [UNSPECIFIED SUBMITTED QUEUED STALE_STATUS]},
  :pysparkJob
  {:mainPythonFileUri string,
   :args [string],
   :pythonFileUris [string],
   :jarFileUris [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :sparkRJob
  {:mainRFileUri string,
   :args [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :driverSchedulingConfig {:memoryMb integer, :vcores integer},
  :jobUuid string,
  :placement
  {:clusterName string, :clusterUuid string, :clusterLabels object},
  :hadoopJob
  {:mainJarFileUri string,
   :mainClass string,
   :args [string],
   :jarFileUris [string],
   :fileUris [string],
   :archiveUris [string],
   :properties object,
   :loggingConfig {:driverLogLevels object}},
  :driverControlFilesUri string,
  :statusHistory
  [{:state
    [STATE_UNSPECIFIED
     PENDING
     SETUP_DONE
     RUNNING
     CANCEL_PENDING
     CANCEL_STARTED
     CANCELLED
     DONE
     ERROR
     ATTEMPT_FAILURE],
    :details string,
    :stateStartTime string,
    :substate [UNSPECIFIED SUBMITTED QUEUED STALE_STATUS]}]},
 :requestId string}"
  [projectId region SubmitJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/jobs:submitAsOperation",
     :uri-template-args {:projectId projectId, :region region},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SubmitJobRequest}))

(defn projects-regions-jobs-cancel
  "Starts a job cancellation request. To access the job resource after cancellation, call regions/{region}/jobs.list (https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list) or regions/{region}/jobs.get (https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get).
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.jobs/cancel

projectId <string> Required. The ID of the Google Cloud Platform project that the job belongs to.
region <string> Required. The Dataproc region in which to handle the request.
jobId <string> Required. The job ID.
CancelJobRequest:
object"
  [projectId region jobId CancelJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/projects/{projectId}/regions/{region}/jobs/{jobId}:cancel",
     :uri-template-args
     {:projectId projectId, :region region, :jobId jobId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelJobRequest}))

(defn projects-regions-workflowTemplates-get
  "Retrieves the latest workflow template.Can retrieve previously instantiated template by specifying optional version parameter.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/get

name <string> Required. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.get, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates.get, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}

optional:
version <integer> Optional. The version of workflow template to retrieve. Only previously instantiated versions can be retrieved.If unspecified, retrieves the current version."
  ([name] (projects-regions-workflowTemplates-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataproc.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-workflowTemplates-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-regions-workflowTemplates-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-regions-workflowTemplates-instantiateInline
  "Instantiates a template and begins execution.This method is equivalent to executing the sequence CreateWorkflowTemplate, InstantiateWorkflowTemplate, DeleteWorkflowTemplate.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/instantiateInline

parent <string> Required. The resource name of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates,instantiateinline, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.workflowTemplates.instantiateinline, the resource name of the location has the following format: projects/{project_id}/locations/{location}
WorkflowTemplate:
{:labels object,
 :name string,
 :createTime string,
 :updateTime string,
 :jobs
 [{:flinkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :savepointUri string,
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :labels object,
   :prerequisiteStepIds [string],
   :sparkSqlJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :prestoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :scheduling
   {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :pigJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :hiveJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string]},
   :sparkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :stepId string,
   :trinoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :pysparkJob
   {:mainPythonFileUri string,
    :args [string],
    :pythonFileUris [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :sparkRJob
   {:mainRFileUri string,
    :args [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :hadoopJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}}}],
 :id string,
 :dagTimeout string,
 :version integer,
 :placement
 {:managedCluster
  {:clusterName string,
   :config
   {:configBucket string,
    :gceClusterConfig
    {:serviceAccount string,
     :tags [string],
     :shieldedInstanceConfig ShieldedInstanceConfig,
     :nodeGroupAffinity NodeGroupAffinity,
     :serviceAccountScopes [string],
     :privateIpv6GoogleAccess
     [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
      INHERIT_FROM_SUBNETWORK
      OUTBOUND
      BIDIRECTIONAL],
     :confidentialInstanceConfig ConfidentialInstanceConfig,
     :networkUri string,
     :reservationAffinity ReservationAffinity,
     :subnetworkUri string,
     :metadata object,
     :zoneUri string,
     :internalIpOnly boolean},
    :auxiliaryNodeGroups [{:nodeGroup NodeGroup, :nodeGroupId string}],
    :metastoreConfig {:dataprocMetastoreService string},
    :dataprocMetricConfig {:metrics [Metric]},
    :softwareConfig
    {:imageVersion string,
     :properties object,
     :optionalComponents
     [[COMPONENT_UNSPECIFIED
       ANACONDA
       DOCKER
       DRUID
       FLINK
       HBASE
       HIVE_WEBHCAT
       HUDI
       JUPYTER
       PRESTO
       TRINO
       RANGER
       SOLR
       ZEPPELIN
       ZOOKEEPER]]},
    :workerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :initializationActions
    [{:executableFile string, :executionTimeout string}],
    :securityConfig
    {:kerberosConfig KerberosConfig, :identityConfig IdentityConfig},
    :masterConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :lifecycleConfig
    {:idleDeleteTtl string,
     :autoDeleteTime string,
     :autoDeleteTtl string,
     :idleStartTime string},
    :secondaryWorkerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
    :tempBucket string,
    :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
    :gkeClusterConfig
    {:namespacedGkeDeploymentTarget NamespacedGkeDeploymentTarget,
     :gkeClusterTarget string,
     :nodePoolTarget [GkeNodePoolTarget]},
    :autoscalingConfig {:policyUri string}},
   :labels object},
  :clusterSelector {:zone string, :clusterLabels object}},
 :parameters
 [{:name string,
   :fields [string],
   :description string,
   :validation
   {:regex {:regexes [string]}, :values {:values [string]}}}],
 :encryptionConfig {:kmsKey string}}

optional:
requestId <string> Optional. A tag that prevents multiple concurrent workflow instances with the same tag from running. This mitigates risk of concurrent instances started due to retries.It is recommended to always set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The tag must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([parent WorkflowTemplate]
    (projects-regions-workflowTemplates-instantiateInline
      parent
      WorkflowTemplate
      nil))
  ([parent WorkflowTemplate optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/workflowTemplates:instantiateInline",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkflowTemplate})))

(defn projects-regions-workflowTemplates-create
  "Creates new workflow template.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/create

parent <string> Required. The resource name of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.create, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.workflowTemplates.create, the resource name of the location has the following format: projects/{project_id}/locations/{location}
WorkflowTemplate:
{:labels object,
 :name string,
 :createTime string,
 :updateTime string,
 :jobs
 [{:flinkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :savepointUri string,
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :labels object,
   :prerequisiteStepIds [string],
   :sparkSqlJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :prestoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :scheduling
   {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :pigJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :hiveJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string]},
   :sparkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :stepId string,
   :trinoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :pysparkJob
   {:mainPythonFileUri string,
    :args [string],
    :pythonFileUris [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :sparkRJob
   {:mainRFileUri string,
    :args [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :hadoopJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}}}],
 :id string,
 :dagTimeout string,
 :version integer,
 :placement
 {:managedCluster
  {:clusterName string,
   :config
   {:configBucket string,
    :gceClusterConfig
    {:serviceAccount string,
     :tags [string],
     :shieldedInstanceConfig ShieldedInstanceConfig,
     :nodeGroupAffinity NodeGroupAffinity,
     :serviceAccountScopes [string],
     :privateIpv6GoogleAccess
     [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
      INHERIT_FROM_SUBNETWORK
      OUTBOUND
      BIDIRECTIONAL],
     :confidentialInstanceConfig ConfidentialInstanceConfig,
     :networkUri string,
     :reservationAffinity ReservationAffinity,
     :subnetworkUri string,
     :metadata object,
     :zoneUri string,
     :internalIpOnly boolean},
    :auxiliaryNodeGroups [{:nodeGroup NodeGroup, :nodeGroupId string}],
    :metastoreConfig {:dataprocMetastoreService string},
    :dataprocMetricConfig {:metrics [Metric]},
    :softwareConfig
    {:imageVersion string,
     :properties object,
     :optionalComponents
     [[COMPONENT_UNSPECIFIED
       ANACONDA
       DOCKER
       DRUID
       FLINK
       HBASE
       HIVE_WEBHCAT
       HUDI
       JUPYTER
       PRESTO
       TRINO
       RANGER
       SOLR
       ZEPPELIN
       ZOOKEEPER]]},
    :workerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :initializationActions
    [{:executableFile string, :executionTimeout string}],
    :securityConfig
    {:kerberosConfig KerberosConfig, :identityConfig IdentityConfig},
    :masterConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :lifecycleConfig
    {:idleDeleteTtl string,
     :autoDeleteTime string,
     :autoDeleteTtl string,
     :idleStartTime string},
    :secondaryWorkerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
    :tempBucket string,
    :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
    :gkeClusterConfig
    {:namespacedGkeDeploymentTarget NamespacedGkeDeploymentTarget,
     :gkeClusterTarget string,
     :nodePoolTarget [GkeNodePoolTarget]},
    :autoscalingConfig {:policyUri string}},
   :labels object},
  :clusterSelector {:zone string, :clusterLabels object}},
 :parameters
 [{:name string,
   :fields [string],
   :description string,
   :validation
   {:regex {:regexes [string]}, :values {:values [string]}}}],
 :encryptionConfig {:kmsKey string}}"
  [parent WorkflowTemplate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+parent}/workflowTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body WorkflowTemplate}))

(defn projects-regions-workflowTemplates-update
  "Updates (replaces) workflow template. The updated template must contain version that matches the current server version.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/update

name <string> Output only. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}
WorkflowTemplate:
{:labels object,
 :name string,
 :createTime string,
 :updateTime string,
 :jobs
 [{:flinkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :savepointUri string,
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :labels object,
   :prerequisiteStepIds [string],
   :sparkSqlJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :prestoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :scheduling
   {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :pigJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :hiveJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string]},
   :sparkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :stepId string,
   :trinoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :pysparkJob
   {:mainPythonFileUri string,
    :args [string],
    :pythonFileUris [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :sparkRJob
   {:mainRFileUri string,
    :args [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :hadoopJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}}}],
 :id string,
 :dagTimeout string,
 :version integer,
 :placement
 {:managedCluster
  {:clusterName string,
   :config
   {:configBucket string,
    :gceClusterConfig
    {:serviceAccount string,
     :tags [string],
     :shieldedInstanceConfig ShieldedInstanceConfig,
     :nodeGroupAffinity NodeGroupAffinity,
     :serviceAccountScopes [string],
     :privateIpv6GoogleAccess
     [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
      INHERIT_FROM_SUBNETWORK
      OUTBOUND
      BIDIRECTIONAL],
     :confidentialInstanceConfig ConfidentialInstanceConfig,
     :networkUri string,
     :reservationAffinity ReservationAffinity,
     :subnetworkUri string,
     :metadata object,
     :zoneUri string,
     :internalIpOnly boolean},
    :auxiliaryNodeGroups [{:nodeGroup NodeGroup, :nodeGroupId string}],
    :metastoreConfig {:dataprocMetastoreService string},
    :dataprocMetricConfig {:metrics [Metric]},
    :softwareConfig
    {:imageVersion string,
     :properties object,
     :optionalComponents
     [[COMPONENT_UNSPECIFIED
       ANACONDA
       DOCKER
       DRUID
       FLINK
       HBASE
       HIVE_WEBHCAT
       HUDI
       JUPYTER
       PRESTO
       TRINO
       RANGER
       SOLR
       ZEPPELIN
       ZOOKEEPER]]},
    :workerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :initializationActions
    [{:executableFile string, :executionTimeout string}],
    :securityConfig
    {:kerberosConfig KerberosConfig, :identityConfig IdentityConfig},
    :masterConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :lifecycleConfig
    {:idleDeleteTtl string,
     :autoDeleteTime string,
     :autoDeleteTtl string,
     :idleStartTime string},
    :secondaryWorkerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
    :tempBucket string,
    :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
    :gkeClusterConfig
    {:namespacedGkeDeploymentTarget NamespacedGkeDeploymentTarget,
     :gkeClusterTarget string,
     :nodePoolTarget [GkeNodePoolTarget]},
    :autoscalingConfig {:policyUri string}},
   :labels object},
  :clusterSelector {:zone string, :clusterLabels object}},
 :parameters
 [{:name string,
   :fields [string],
   :description string,
   :validation
   {:regex {:regexes [string]}, :values {:values [string]}}}],
 :encryptionConfig {:kmsKey string}}"
  [name WorkflowTemplate]
  (client/api-request
    {:method "PUT",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body WorkflowTemplate}))

(defn projects-regions-workflowTemplates-delete
  "Deletes a workflow template. It does not cancel in-progress workflows.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/delete

name <string> Required. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.delete, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates.instantiate, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}

optional:
version <integer> Optional. The version of workflow template to delete. If specified, will only delete the template if the current server version matches specified version."
  ([name] (projects-regions-workflowTemplates-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataproc.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-workflowTemplates-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-regions-workflowTemplates-list
  "Lists workflows that match the specified filter in the request.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/list

parent <string> Required. The resource name of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates,list, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.workflowTemplates.list, the resource name of the location has the following format: projects/{project_id}/locations/{location}

optional:
pageSize <integer> Optional. The maximum number of results to return in each response."
  ([parent] (projects-regions-workflowTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/workflowTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-regions-workflowTemplates-instantiate
  "Instantiates a template and begins execution.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty.
https://cloud.google.com/dataproc/reference/rest/v1/projects.regions.workflowTemplates/instantiate

name <string> Required. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.instantiate, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates.instantiate, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}
InstantiateWorkflowTemplateRequest:
{:version integer, :requestId string, :parameters object}"
  [name InstantiateWorkflowTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+name}:instantiate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InstantiateWorkflowTemplateRequest}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataproc.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-batches-analyze
  "Analyze a Batch for possible recommendations and insights.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.batches/analyze

name <string> Required. The fully qualified name of the batch to analyze in the format \"projects/PROJECT_ID/locations/DATAPROC_REGION/batches/BATCH_ID\"
AnalyzeBatchRequest:
{:requestId string}"
  [name AnalyzeBatchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+name}:analyze",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AnalyzeBatchRequest}))

(defn projects-locations-batches-create
  "Creates a batch workload that executes asynchronously.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.batches/create

parent <string> Required. The parent resource where this batch will be created.
Batch:
{:labels object,
 :pysparkBatch
 {:mainPythonFileUri string,
  :args [string],
  :pythonFileUris [string],
  :jarFileUris [string],
  :fileUris [string],
  :archiveUris [string]},
 :creator string,
 :environmentConfig
 {:executionConfig
  {:serviceAccount string,
   :networkUri string,
   :subnetworkUri string,
   :networkTags [string],
   :kmsKey string,
   :idleTtl string,
   :ttl string,
   :stagingBucket string},
  :peripheralsConfig
  {:metastoreService string,
   :sparkHistoryServerConfig {:dataprocCluster string}}},
 :sparkRBatch
 {:mainRFileUri string,
  :args [string],
  :fileUris [string],
  :archiveUris [string]},
 :sparkBatch
 {:mainJarFileUri string,
  :mainClass string,
  :args [string],
  :jarFileUris [string],
  :fileUris [string],
  :archiveUris [string]},
 :runtimeConfig
 {:version string,
  :containerImage string,
  :properties object,
  :repositoryConfig {:pypiRepositoryConfig {:pypiRepository string}},
  :autotuningConfig
  {:scenarios
   [[SCENARIO_UNSPECIFIED SCALING BROADCAST_HASH_JOIN MEMORY]]},
  :cohort string},
 :name string,
 :operation string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  PENDING
  RUNNING
  CANCELLING
  CANCELLED
  SUCCEEDED
  FAILED],
 :runtimeInfo
 {:endpoints object,
  :outputUri string,
  :diagnosticOutputUri string,
  :approximateUsage
  {:milliDcuSeconds string,
   :shuffleStorageGbSeconds string,
   :milliAcceleratorSeconds string,
   :acceleratorType string},
  :currentUsage
  {:milliDcu string,
   :shuffleStorageGb string,
   :milliDcuPremium string,
   :shuffleStorageGbPremium string,
   :milliAccelerator string,
   :acceleratorType string,
   :snapshotTime string}},
 :uuid string,
 :stateTime string,
 :stateHistory
 [{:state
   [STATE_UNSPECIFIED
    PENDING
    RUNNING
    CANCELLING
    CANCELLED
    SUCCEEDED
    FAILED],
   :stateMessage string,
   :stateStartTime string}],
 :sparkSqlBatch
 {:queryFileUri string, :queryVariables object, :jarFileUris [string]},
 :stateMessage string}

optional:
batchId <string> Optional. The ID to use for the batch, which will become the final component of the batch's resource name.This value must be 4-63 characters. Valid characters are /[a-z][0-9]-/.
requestId <string> Optional. A unique ID used to identify the request. If the service receives two CreateBatchRequest (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#google.cloud.dataproc.v1.CreateBatchRequest)s with the same request_id, the second request is ignored and the Operation that corresponds to the first Batch created and stored in the backend is returned.Recommendation: Set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The value must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([parent Batch] (projects-locations-batches-create parent Batch nil))
  ([parent Batch optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/batches",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Batch})))

(defn projects-locations-batches-get
  "Gets the batch workload resource representation.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.batches/get

name <string> Required. The fully qualified name of the batch to retrieve in the format \"projects/PROJECT_ID/locations/DATAPROC_REGION/batches/BATCH_ID\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-batches-list
  "Lists batch workloads.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.batches/list

parent <string> Required. The parent, which owns this collection of batches.

optional:
pageSize <integer> Optional. The maximum number of batches to return in each response. The service may return fewer than this value. The default page size is 20; the maximum page size is 1000.
filter <string> Optional. A filter for the batches to return in the response.A filter is a logical expression constraining the values of various fields in each batch resource. Filters are case sensitive, and may contain multiple clauses combined with logical operators (AND/OR). Supported fields are batch_id, batch_uuid, state, create_time, and labels.e.g. state = RUNNING and create_time < \"2023-01-01T00:00:00Z\" filters for batches in state RUNNING that were created before 2023-01-01. state = RUNNING and labels.environment=production filters for batches in state in a RUNNING state that have a production environment label.See https://google.aip.dev/assets/misc/ebnf-filtering.txt for a detailed description of the filter syntax and a list of supported comparisons.
orderBy <string> Optional. Field(s) on which to sort the list of batches.Currently the only supported sort orders are unspecified (empty) and create_time desc to sort by most recently created batches first.See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-batches-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/batches",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-batches-delete
  "Deletes the batch workload resource. If the batch is not in a CANCELLED, SUCCEEDED or FAILED State, the delete operation fails and the response returns FAILED_PRECONDITION.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.batches/delete

name <string> Required. The fully qualified name of the batch to retrieve in the format \"projects/PROJECT_ID/locations/DATAPROC_REGION/batches/BATCH_ID\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-autoscalingPolicies-create
  "Creates new autoscaling policy.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/create

parent <string> Required. The \"resource name\" of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.create, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.autoscalingPolicies.create, the resource name of the location has the following format: projects/{project_id}/locations/{location}
AutoscalingPolicy:
{:id string,
 :name string,
 :basicAlgorithm
 {:yarnConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number},
  :sparkStandaloneConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number,
   :removeOnlyIdleWorkers boolean},
  :cooldownPeriod string},
 :workerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :secondaryWorkerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :labels object}"
  [parent AutoscalingPolicy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+parent}/autoscalingPolicies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AutoscalingPolicy}))

(defn projects-locations-autoscalingPolicies-update
  "Updates (replaces) autoscaling policy.Disabled check for update_mask, because all updates will be full replacements.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/update

name <string> Output only. The \"resource name\" of the autoscaling policy, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies, the resource name of the policy has the following format: projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id} For projects.locations.autoscalingPolicies, the resource name of the policy has the following format: projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}
AutoscalingPolicy:
{:id string,
 :name string,
 :basicAlgorithm
 {:yarnConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number},
  :sparkStandaloneConfig
  {:gracefulDecommissionTimeout string,
   :scaleUpFactor number,
   :scaleDownFactor number,
   :scaleUpMinWorkerFraction number,
   :scaleDownMinWorkerFraction number,
   :removeOnlyIdleWorkers boolean},
  :cooldownPeriod string},
 :workerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :secondaryWorkerConfig
 {:minInstances integer, :maxInstances integer, :weight integer},
 :labels object}"
  [name AutoscalingPolicy]
  (client/api-request
    {:method "PUT",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AutoscalingPolicy}))

(defn projects-locations-autoscalingPolicies-get
  "Retrieves autoscaling policy.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/get

name <string> Required. The \"resource name\" of the autoscaling policy, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.get, the resource name of the policy has the following format: projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id} For projects.locations.autoscalingPolicies.get, the resource name of the policy has the following format: projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-autoscalingPolicies-list
  "Lists autoscaling policies in the project.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/list

parent <string> Required. The \"resource name\" of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.list, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.autoscalingPolicies.list, the resource name of the location has the following format: projects/{project_id}/locations/{location}

optional:
pageSize <integer> Optional. The maximum number of results to return in each response. Must be less than or equal to 1000. Defaults to 100."
  ([parent] (projects-locations-autoscalingPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/autoscalingPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-autoscalingPolicies-delete
  "Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by one or more clusters.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/delete

name <string> Required. The \"resource name\" of the autoscaling policy, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.autoscalingPolicies.delete, the resource name of the policy has the following format: projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id} For projects.locations.autoscalingPolicies.delete, the resource name of the policy has the following format: projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-autoscalingPolicies-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-autoscalingPolicies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-autoscalingPolicies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.autoscalingPolicies/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-sessions-create
  "Create an interactive session asynchronously.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessions/create

parent <string> Required. The parent resource where this session will be created.
Session:
{:labels object,
 :creator string,
 :environmentConfig
 {:executionConfig
  {:serviceAccount string,
   :networkUri string,
   :subnetworkUri string,
   :networkTags [string],
   :kmsKey string,
   :idleTtl string,
   :ttl string,
   :stagingBucket string},
  :peripheralsConfig
  {:metastoreService string,
   :sparkHistoryServerConfig {:dataprocCluster string}}},
 :runtimeConfig
 {:version string,
  :containerImage string,
  :properties object,
  :repositoryConfig {:pypiRepositoryConfig {:pypiRepository string}},
  :autotuningConfig
  {:scenarios
   [[SCENARIO_UNSPECIFIED SCALING BROADCAST_HASH_JOIN MEMORY]]},
  :cohort string},
 :name string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED CREATING ACTIVE TERMINATING TERMINATED FAILED],
 :jupyterSession
 {:kernel [KERNEL_UNSPECIFIED PYTHON SCALA], :displayName string},
 :runtimeInfo
 {:endpoints object,
  :outputUri string,
  :diagnosticOutputUri string,
  :approximateUsage
  {:milliDcuSeconds string,
   :shuffleStorageGbSeconds string,
   :milliAcceleratorSeconds string,
   :acceleratorType string},
  :currentUsage
  {:milliDcu string,
   :shuffleStorageGb string,
   :milliDcuPremium string,
   :shuffleStorageGbPremium string,
   :milliAccelerator string,
   :acceleratorType string,
   :snapshotTime string}},
 :sessionTemplate string,
 :uuid string,
 :stateTime string,
 :stateHistory
 [{:state
   [STATE_UNSPECIFIED CREATING ACTIVE TERMINATING TERMINATED FAILED],
   :stateMessage string,
   :stateStartTime string}],
 :user string,
 :stateMessage string}

optional:
sessionId <string> Required. The ID to use for the session, which becomes the final component of the session's resource name.This value must be 4-63 characters. Valid characters are /a-z-/.
requestId <string> Optional. A unique ID used to identify the request. If the service receives two CreateSessionRequests (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#google.cloud.dataproc.v1.CreateSessionRequest)s with the same ID, the second request is ignored, and the first Session is created and stored in the backend.Recommendation: Set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The value must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([parent Session]
    (projects-locations-sessions-create parent Session nil))
  ([parent Session optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/sessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Session})))

(defn projects-locations-sessions-get
  "Gets the resource representation for an interactive session.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessions/get

name <string> Required. The name of the session to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sessions-list
  "Lists interactive sessions.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessions/list

parent <string> Required. The parent, which owns this collection of sessions.

optional:
pageSize <integer> Optional. The maximum number of sessions to return in each response. The service may return fewer than this value.
filter <string> Optional. A filter for the sessions to return in the response.A filter is a logical expression constraining the values of various fields in each session resource. Filters are case sensitive, and may contain multiple clauses combined with logical operators (AND, OR). Supported fields are session_id, session_uuid, state, create_time, and labels.Example: state = ACTIVE and create_time < \"2023-01-01T00:00:00Z\" is a filter for sessions in an ACTIVE state that were created before 2023-01-01. state = ACTIVE and labels.environment=production is a filter for sessions in an ACTIVE state that have a production environment label.See https://google.aip.dev/assets/misc/ebnf-filtering.txt for a detailed description of the filter syntax and a list of supported comparators."
  ([parent] (projects-locations-sessions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/sessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sessions-terminate
  "Terminates the interactive session.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessions/terminate

name <string> Required. The name of the session resource to terminate.
TerminateSessionRequest:
{:requestId string}"
  [name TerminateSessionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+name}:terminate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TerminateSessionRequest}))

(defn projects-locations-sessions-delete
  "Deletes the interactive session resource. If the session is not in terminal state, it is terminated, and then deleted.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessions/delete

name <string> Required. The name of the session resource to delete.

optional:
requestId <string> Optional. A unique ID used to identify the request. If the service receives two DeleteSessionRequest (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#google.cloud.dataproc.v1.DeleteSessionRequest)s with the same ID, the second request is ignored.Recommendation: Set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The value must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([name] (projects-locations-sessions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataproc.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sessionTemplates-create
  "Create a session template synchronously.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessionTemplates/create

parent <string> Required. The parent resource where this session template will be created.
SessionTemplate:
{:description string,
 :labels object,
 :creator string,
 :environmentConfig
 {:executionConfig
  {:serviceAccount string,
   :networkUri string,
   :subnetworkUri string,
   :networkTags [string],
   :kmsKey string,
   :idleTtl string,
   :ttl string,
   :stagingBucket string},
  :peripheralsConfig
  {:metastoreService string,
   :sparkHistoryServerConfig {:dataprocCluster string}}},
 :runtimeConfig
 {:version string,
  :containerImage string,
  :properties object,
  :repositoryConfig {:pypiRepositoryConfig {:pypiRepository string}},
  :autotuningConfig
  {:scenarios
   [[SCENARIO_UNSPECIFIED SCALING BROADCAST_HASH_JOIN MEMORY]]},
  :cohort string},
 :name string,
 :createTime string,
 :jupyterSession
 {:kernel [KERNEL_UNSPECIFIED PYTHON SCALA], :displayName string},
 :updateTime string,
 :uuid string}"
  [parent SessionTemplate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+parent}/sessionTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SessionTemplate}))

(defn projects-locations-sessionTemplates-patch
  "Updates the session template synchronously.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessionTemplates/patch

name <string> Required. The resource name of the session template.
SessionTemplate:
{:description string,
 :labels object,
 :creator string,
 :environmentConfig
 {:executionConfig
  {:serviceAccount string,
   :networkUri string,
   :subnetworkUri string,
   :networkTags [string],
   :kmsKey string,
   :idleTtl string,
   :ttl string,
   :stagingBucket string},
  :peripheralsConfig
  {:metastoreService string,
   :sparkHistoryServerConfig {:dataprocCluster string}}},
 :runtimeConfig
 {:version string,
  :containerImage string,
  :properties object,
  :repositoryConfig {:pypiRepositoryConfig {:pypiRepository string}},
  :autotuningConfig
  {:scenarios
   [[SCENARIO_UNSPECIFIED SCALING BROADCAST_HASH_JOIN MEMORY]]},
  :cohort string},
 :name string,
 :createTime string,
 :jupyterSession
 {:kernel [KERNEL_UNSPECIFIED PYTHON SCALA], :displayName string},
 :updateTime string,
 :uuid string}"
  [name SessionTemplate]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SessionTemplate}))

(defn projects-locations-sessionTemplates-get
  "Gets the resource representation for a session template.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessionTemplates/get

name <string> Required. The name of the session template to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sessionTemplates-list
  "Lists session templates.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessionTemplates/list

parent <string> Required. The parent that owns this collection of session templates.

optional:
pageSize <integer> Optional. The maximum number of sessions to return in each response. The service may return fewer than this value.
filter <string> Optional. A filter for the session templates to return in the response. Filters are case sensitive and have the following syntax:field = value AND field = value ..."
  ([parent] (projects-locations-sessionTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/sessionTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sessionTemplates-delete
  "Deletes a session template.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.sessionTemplates/delete

name <string> Required. The name of the session template resource to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-workflowTemplates-get
  "Retrieves the latest workflow template.Can retrieve previously instantiated template by specifying optional version parameter.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/get

name <string> Required. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.get, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates.get, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}

optional:
version <integer> Optional. The version of workflow template to retrieve. Only previously instantiated versions can be retrieved.If unspecified, retrieves the current version."
  ([name] (projects-locations-workflowTemplates-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataproc.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflowTemplates-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-workflowTemplates-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-workflowTemplates-instantiateInline
  "Instantiates a template and begins execution.This method is equivalent to executing the sequence CreateWorkflowTemplate, InstantiateWorkflowTemplate, DeleteWorkflowTemplate.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/instantiateInline

parent <string> Required. The resource name of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates,instantiateinline, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.workflowTemplates.instantiateinline, the resource name of the location has the following format: projects/{project_id}/locations/{location}
WorkflowTemplate:
{:labels object,
 :name string,
 :createTime string,
 :updateTime string,
 :jobs
 [{:flinkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :savepointUri string,
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :labels object,
   :prerequisiteStepIds [string],
   :sparkSqlJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :prestoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :scheduling
   {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :pigJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :hiveJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string]},
   :sparkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :stepId string,
   :trinoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :pysparkJob
   {:mainPythonFileUri string,
    :args [string],
    :pythonFileUris [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :sparkRJob
   {:mainRFileUri string,
    :args [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :hadoopJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}}}],
 :id string,
 :dagTimeout string,
 :version integer,
 :placement
 {:managedCluster
  {:clusterName string,
   :config
   {:configBucket string,
    :gceClusterConfig
    {:serviceAccount string,
     :tags [string],
     :shieldedInstanceConfig ShieldedInstanceConfig,
     :nodeGroupAffinity NodeGroupAffinity,
     :serviceAccountScopes [string],
     :privateIpv6GoogleAccess
     [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
      INHERIT_FROM_SUBNETWORK
      OUTBOUND
      BIDIRECTIONAL],
     :confidentialInstanceConfig ConfidentialInstanceConfig,
     :networkUri string,
     :reservationAffinity ReservationAffinity,
     :subnetworkUri string,
     :metadata object,
     :zoneUri string,
     :internalIpOnly boolean},
    :auxiliaryNodeGroups [{:nodeGroup NodeGroup, :nodeGroupId string}],
    :metastoreConfig {:dataprocMetastoreService string},
    :dataprocMetricConfig {:metrics [Metric]},
    :softwareConfig
    {:imageVersion string,
     :properties object,
     :optionalComponents
     [[COMPONENT_UNSPECIFIED
       ANACONDA
       DOCKER
       DRUID
       FLINK
       HBASE
       HIVE_WEBHCAT
       HUDI
       JUPYTER
       PRESTO
       TRINO
       RANGER
       SOLR
       ZEPPELIN
       ZOOKEEPER]]},
    :workerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :initializationActions
    [{:executableFile string, :executionTimeout string}],
    :securityConfig
    {:kerberosConfig KerberosConfig, :identityConfig IdentityConfig},
    :masterConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :lifecycleConfig
    {:idleDeleteTtl string,
     :autoDeleteTime string,
     :autoDeleteTtl string,
     :idleStartTime string},
    :secondaryWorkerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
    :tempBucket string,
    :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
    :gkeClusterConfig
    {:namespacedGkeDeploymentTarget NamespacedGkeDeploymentTarget,
     :gkeClusterTarget string,
     :nodePoolTarget [GkeNodePoolTarget]},
    :autoscalingConfig {:policyUri string}},
   :labels object},
  :clusterSelector {:zone string, :clusterLabels object}},
 :parameters
 [{:name string,
   :fields [string],
   :description string,
   :validation
   {:regex {:regexes [string]}, :values {:values [string]}}}],
 :encryptionConfig {:kmsKey string}}

optional:
requestId <string> Optional. A tag that prevents multiple concurrent workflow instances with the same tag from running. This mitigates risk of concurrent instances started due to retries.It is recommended to always set this value to a UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier).The tag must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([parent WorkflowTemplate]
    (projects-locations-workflowTemplates-instantiateInline
      parent
      WorkflowTemplate
      nil))
  ([parent WorkflowTemplate optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/workflowTemplates:instantiateInline",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkflowTemplate})))

(defn projects-locations-workflowTemplates-create
  "Creates new workflow template.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/create

parent <string> Required. The resource name of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.create, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.workflowTemplates.create, the resource name of the location has the following format: projects/{project_id}/locations/{location}
WorkflowTemplate:
{:labels object,
 :name string,
 :createTime string,
 :updateTime string,
 :jobs
 [{:flinkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :savepointUri string,
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :labels object,
   :prerequisiteStepIds [string],
   :sparkSqlJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :prestoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :scheduling
   {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :pigJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :hiveJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string]},
   :sparkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :stepId string,
   :trinoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :pysparkJob
   {:mainPythonFileUri string,
    :args [string],
    :pythonFileUris [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :sparkRJob
   {:mainRFileUri string,
    :args [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :hadoopJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}}}],
 :id string,
 :dagTimeout string,
 :version integer,
 :placement
 {:managedCluster
  {:clusterName string,
   :config
   {:configBucket string,
    :gceClusterConfig
    {:serviceAccount string,
     :tags [string],
     :shieldedInstanceConfig ShieldedInstanceConfig,
     :nodeGroupAffinity NodeGroupAffinity,
     :serviceAccountScopes [string],
     :privateIpv6GoogleAccess
     [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
      INHERIT_FROM_SUBNETWORK
      OUTBOUND
      BIDIRECTIONAL],
     :confidentialInstanceConfig ConfidentialInstanceConfig,
     :networkUri string,
     :reservationAffinity ReservationAffinity,
     :subnetworkUri string,
     :metadata object,
     :zoneUri string,
     :internalIpOnly boolean},
    :auxiliaryNodeGroups [{:nodeGroup NodeGroup, :nodeGroupId string}],
    :metastoreConfig {:dataprocMetastoreService string},
    :dataprocMetricConfig {:metrics [Metric]},
    :softwareConfig
    {:imageVersion string,
     :properties object,
     :optionalComponents
     [[COMPONENT_UNSPECIFIED
       ANACONDA
       DOCKER
       DRUID
       FLINK
       HBASE
       HIVE_WEBHCAT
       HUDI
       JUPYTER
       PRESTO
       TRINO
       RANGER
       SOLR
       ZEPPELIN
       ZOOKEEPER]]},
    :workerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :initializationActions
    [{:executableFile string, :executionTimeout string}],
    :securityConfig
    {:kerberosConfig KerberosConfig, :identityConfig IdentityConfig},
    :masterConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :lifecycleConfig
    {:idleDeleteTtl string,
     :autoDeleteTime string,
     :autoDeleteTtl string,
     :idleStartTime string},
    :secondaryWorkerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
    :tempBucket string,
    :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
    :gkeClusterConfig
    {:namespacedGkeDeploymentTarget NamespacedGkeDeploymentTarget,
     :gkeClusterTarget string,
     :nodePoolTarget [GkeNodePoolTarget]},
    :autoscalingConfig {:policyUri string}},
   :labels object},
  :clusterSelector {:zone string, :clusterLabels object}},
 :parameters
 [{:name string,
   :fields [string],
   :description string,
   :validation
   {:regex {:regexes [string]}, :values {:values [string]}}}],
 :encryptionConfig {:kmsKey string}}"
  [parent WorkflowTemplate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+parent}/workflowTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body WorkflowTemplate}))

(defn projects-locations-workflowTemplates-update
  "Updates (replaces) workflow template. The updated template must contain version that matches the current server version.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/update

name <string> Output only. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}
WorkflowTemplate:
{:labels object,
 :name string,
 :createTime string,
 :updateTime string,
 :jobs
 [{:flinkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :savepointUri string,
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :labels object,
   :prerequisiteStepIds [string],
   :sparkSqlJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :prestoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :scheduling
   {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :pigJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string],
    :loggingConfig {:driverLogLevels object}},
   :hiveJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :scriptVariables object,
    :properties object,
    :jarFileUris [string]},
   :sparkJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :stepId string,
   :trinoJob
   {:queryFileUri string,
    :queryList {:queries [string]},
    :continueOnFailure boolean,
    :outputFormat string,
    :clientTags [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :pysparkJob
   {:mainPythonFileUri string,
    :args [string],
    :pythonFileUris [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :sparkRJob
   {:mainRFileUri string,
    :args [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}},
   :hadoopJob
   {:mainJarFileUri string,
    :mainClass string,
    :args [string],
    :jarFileUris [string],
    :fileUris [string],
    :archiveUris [string],
    :properties object,
    :loggingConfig {:driverLogLevels object}}}],
 :id string,
 :dagTimeout string,
 :version integer,
 :placement
 {:managedCluster
  {:clusterName string,
   :config
   {:configBucket string,
    :gceClusterConfig
    {:serviceAccount string,
     :tags [string],
     :shieldedInstanceConfig ShieldedInstanceConfig,
     :nodeGroupAffinity NodeGroupAffinity,
     :serviceAccountScopes [string],
     :privateIpv6GoogleAccess
     [PRIVATE_IPV6_GOOGLE_ACCESS_UNSPECIFIED
      INHERIT_FROM_SUBNETWORK
      OUTBOUND
      BIDIRECTIONAL],
     :confidentialInstanceConfig ConfidentialInstanceConfig,
     :networkUri string,
     :reservationAffinity ReservationAffinity,
     :subnetworkUri string,
     :metadata object,
     :zoneUri string,
     :internalIpOnly boolean},
    :auxiliaryNodeGroups [{:nodeGroup NodeGroup, :nodeGroupId string}],
    :metastoreConfig {:dataprocMetastoreService string},
    :dataprocMetricConfig {:metrics [Metric]},
    :softwareConfig
    {:imageVersion string,
     :properties object,
     :optionalComponents
     [[COMPONENT_UNSPECIFIED
       ANACONDA
       DOCKER
       DRUID
       FLINK
       HBASE
       HIVE_WEBHCAT
       HUDI
       JUPYTER
       PRESTO
       TRINO
       RANGER
       SOLR
       ZEPPELIN
       ZOOKEEPER]]},
    :workerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :initializationActions
    [{:executableFile string, :executionTimeout string}],
    :securityConfig
    {:kerberosConfig KerberosConfig, :identityConfig IdentityConfig},
    :masterConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :lifecycleConfig
    {:idleDeleteTtl string,
     :autoDeleteTime string,
     :autoDeleteTtl string,
     :idleStartTime string},
    :secondaryWorkerConfig
    {:minNumInstances integer,
     :diskConfig DiskConfig,
     :preemptibility
     [PREEMPTIBILITY_UNSPECIFIED NON_PREEMPTIBLE PREEMPTIBLE SPOT],
     :imageUri string,
     :startupConfig StartupConfig,
     :numInstances integer,
     :instanceNames [string],
     :managedGroupConfig ManagedGroupConfig,
     :instanceReferences [InstanceReference],
     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
     :isPreemptible boolean,
     :machineTypeUri string,
     :accelerators [AcceleratorConfig],
     :minCpuPlatform string},
    :endpointConfig {:httpPorts object, :enableHttpPortAccess boolean},
    :tempBucket string,
    :encryptionConfig {:gcePdKmsKeyName string, :kmsKey string},
    :gkeClusterConfig
    {:namespacedGkeDeploymentTarget NamespacedGkeDeploymentTarget,
     :gkeClusterTarget string,
     :nodePoolTarget [GkeNodePoolTarget]},
    :autoscalingConfig {:policyUri string}},
   :labels object},
  :clusterSelector {:zone string, :clusterLabels object}},
 :parameters
 [{:name string,
   :fields [string],
   :description string,
   :validation
   {:regex {:regexes [string]}, :values {:values [string]}}}],
 :encryptionConfig {:kmsKey string}}"
  [name WorkflowTemplate]
  (client/api-request
    {:method "PUT",
     :uri-template "https://dataproc.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body WorkflowTemplate}))

(defn projects-locations-workflowTemplates-delete
  "Deletes a workflow template. It does not cancel in-progress workflows.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/delete

name <string> Required. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.delete, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates.instantiate, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}

optional:
version <integer> Optional. The version of workflow template to delete. If specified, will only delete the template if the current server version matches specified version."
  ([name] (projects-locations-workflowTemplates-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataproc.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflowTemplates-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-workflowTemplates-list
  "Lists workflows that match the specified filter in the request.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/list

parent <string> Required. The resource name of the region or location, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates,list, the resource name of the region has the following format: projects/{project_id}/regions/{region} For projects.locations.workflowTemplates.list, the resource name of the location has the following format: projects/{project_id}/locations/{location}

optional:
pageSize <integer> Optional. The maximum number of results to return in each response."
  ([parent] (projects-locations-workflowTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataproc.googleapis.com/v1/{+parent}/workflowTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflowTemplates-instantiate
  "Instantiates a template and begins execution.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty.
https://cloud.google.com/dataproc/reference/rest/v1/projects.locations.workflowTemplates/instantiate

name <string> Required. The resource name of the workflow template, as described in https://cloud.google.com/apis/design/resource_names. For projects.regions.workflowTemplates.instantiate, the resource name of the template has the following format: projects/{project_id}/regions/{region}/workflowTemplates/{template_id} For projects.locations.workflowTemplates.instantiate, the resource name of the template has the following format: projects/{project_id}/locations/{location}/workflowTemplates/{template_id}
InstantiateWorkflowTemplateRequest:
{:version integer, :requestId string, :parameters object}"
  [name InstantiateWorkflowTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataproc.googleapis.com/v1/{+name}:instantiate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InstantiateWorkflowTemplateRequest}))

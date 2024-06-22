(ns happygapi2.workstations
  "Cloud Workstations API
Allows administrators to create managed developer environments in the cloud. 
See: https://cloud.google.com/workstations"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workstations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workstations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://workstations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-workstationClusters-get
  "Returns the requested workstation cluster.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters/get

name <string> Required. Name of the requested resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workstations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-workstationClusters-list
  "Returns all workstation clusters in the specified location.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters/list

parent <string> Required. Parent resource name.

optional:
pageSize <integer> Optional. Maximum number of items to return."
  ([parent] (projects-locations-workstationClusters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstationClusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-create
  "Creates a new workstation cluster.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters/create

parent <string> Required. Parent resource name.
WorkstationCluster:
{:labels object,
 :deleteTime string,
 :controlPlaneIp string,
 :displayName string,
 :privateClusterConfig
 {:enablePrivateEndpoint boolean,
  :clusterHostname string,
  :serviceAttachmentUri string,
  :allowedProjects [string]},
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :reconciling boolean,
 :domainConfig {:domain string},
 :conditions [{:code integer, :message string, :details [object]}],
 :degraded boolean,
 :annotations object,
 :network string,
 :subnetwork string}

optional:
workstationClusterId <string> Required. ID to use for the workstation cluster.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it."
  ([parent WorkstationCluster]
    (projects-locations-workstationClusters-create
      parent
      WorkstationCluster
      nil))
  ([parent WorkstationCluster optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstationClusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkstationCluster})))

(defn projects-locations-workstationClusters-patch
  "Updates an existing workstation cluster.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters/patch

name <string> Identifier. Full name of this workstation cluster.
WorkstationCluster:
{:labels object,
 :deleteTime string,
 :controlPlaneIp string,
 :displayName string,
 :privateClusterConfig
 {:enablePrivateEndpoint boolean,
  :clusterHostname string,
  :serviceAttachmentUri string,
  :allowedProjects [string]},
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :reconciling boolean,
 :domainConfig {:domain string},
 :conditions [{:code integer, :message string, :details [object]}],
 :degraded boolean,
 :annotations object,
 :network string,
 :subnetwork string}

optional:
updateMask <string> Required. Mask that specifies which fields in the workstation cluster should be updated.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it.
allowMissing <boolean> Optional. If set, and the workstation cluster is not found, a new workstation cluster will be created. In this situation, update_mask is ignored."
  ([name WorkstationCluster]
    (projects-locations-workstationClusters-patch
      name
      WorkstationCluster
      nil))
  ([name WorkstationCluster optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://workstations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkstationCluster})))

(defn projects-locations-workstationClusters-delete
  "Deletes the specified workstation cluster.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters/delete

name <string> Required. Name of the workstation cluster to delete.

optional:
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not apply it.
etag <string> Optional. If set, the request will be rejected if the latest version of the workstation cluster on the server does not have this ETag.
force <boolean> Optional. If set, any workstation configurations and workstations in the workstation cluster are also deleted. Otherwise, the request only works if the workstation cluster has no configurations or workstations."
  ([name] (projects-locations-workstationClusters-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://workstations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-get
  "Returns the requested workstation configuration.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/get

name <string> Required. Name of the requested resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workstations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-workstationClusters-workstationConfigs-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-workstationClusters-workstationConfigs-listUsable
  "Returns all workstation configurations in the specified cluster on which the caller has the \"workstations.workstation.create\" permission.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/listUsable

parent <string> Required. Parent resource name.

optional:
pageSize <integer> Optional. Maximum number of items to return."
  ([parent]
    (projects-locations-workstationClusters-workstationConfigs-listUsable
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstationConfigs:listUsable",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-patch
  "Updates an existing workstation configuration.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/patch

name <string> Identifier. Full name of this workstation configuration.
WorkstationConfig:
{:runningTimeout string,
 :labels object,
 :deleteTime string,
 :persistentDirectories
 [{:gcePd
   {:sizeGb integer,
    :fsType string,
    :diskType string,
    :sourceSnapshot string,
    :reclaimPolicy [RECLAIM_POLICY_UNSPECIFIED DELETE RETAIN]},
   :mountPath string}],
 :ephemeralDirectories
 [{:gcePd
   {:diskType string,
    :sourceSnapshot string,
    :sourceImage string,
    :readOnly boolean},
   :mountPath string}],
 :displayName string,
 :enableAuditAgent boolean,
 :uid string,
 :name string,
 :disableTcpConnections boolean,
 :encryptionKey {:kmsKey string, :kmsKeyServiceAccount string},
 :readinessChecks [{:path string, :port integer}],
 :createTime string,
 :etag string,
 :updateTime string,
 :reconciling boolean,
 :host
 {:gceInstance
  {:serviceAccount string,
   :tags [string],
   :shieldedInstanceConfig
   {:enableSecureBoot boolean,
    :enableVtpm boolean,
    :enableIntegrityMonitoring boolean},
   :bootDiskSizeGb integer,
   :serviceAccountScopes [string],
   :disablePublicIpAddresses boolean,
   :machineType string,
   :enableNestedVirtualization boolean,
   :confidentialInstanceConfig {:enableConfidentialCompute boolean},
   :poolSize integer,
   :pooledInstances integer,
   :disableSsh boolean,
   :accelerators [{:type string, :count integer}]}},
 :idleTimeout string,
 :conditions [{:code integer, :message string, :details [object]}],
 :degraded boolean,
 :container
 {:image string,
  :command [string],
  :args [string],
  :env object,
  :workingDir string,
  :runAsUser integer},
 :annotations object,
 :replicaZones [string]}

optional:
updateMask <string> Required. Mask specifying which fields in the workstation configuration should be updated.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it.
allowMissing <boolean> Optional. If set and the workstation configuration is not found, a new workstation configuration will be created. In this situation, update_mask is ignored."
  ([name WorkstationConfig]
    (projects-locations-workstationClusters-workstationConfigs-patch
      name
      WorkstationConfig
      nil))
  ([name WorkstationConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://workstations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkstationConfig})))

(defn projects-locations-workstationClusters-workstationConfigs-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-workstationClusters-workstationConfigs-create
  "Creates a new workstation configuration.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/create

parent <string> Required. Parent resource name.
WorkstationConfig:
{:runningTimeout string,
 :labels object,
 :deleteTime string,
 :persistentDirectories
 [{:gcePd
   {:sizeGb integer,
    :fsType string,
    :diskType string,
    :sourceSnapshot string,
    :reclaimPolicy [RECLAIM_POLICY_UNSPECIFIED DELETE RETAIN]},
   :mountPath string}],
 :ephemeralDirectories
 [{:gcePd
   {:diskType string,
    :sourceSnapshot string,
    :sourceImage string,
    :readOnly boolean},
   :mountPath string}],
 :displayName string,
 :enableAuditAgent boolean,
 :uid string,
 :name string,
 :disableTcpConnections boolean,
 :encryptionKey {:kmsKey string, :kmsKeyServiceAccount string},
 :readinessChecks [{:path string, :port integer}],
 :createTime string,
 :etag string,
 :updateTime string,
 :reconciling boolean,
 :host
 {:gceInstance
  {:serviceAccount string,
   :tags [string],
   :shieldedInstanceConfig
   {:enableSecureBoot boolean,
    :enableVtpm boolean,
    :enableIntegrityMonitoring boolean},
   :bootDiskSizeGb integer,
   :serviceAccountScopes [string],
   :disablePublicIpAddresses boolean,
   :machineType string,
   :enableNestedVirtualization boolean,
   :confidentialInstanceConfig {:enableConfidentialCompute boolean},
   :poolSize integer,
   :pooledInstances integer,
   :disableSsh boolean,
   :accelerators [{:type string, :count integer}]}},
 :idleTimeout string,
 :conditions [{:code integer, :message string, :details [object]}],
 :degraded boolean,
 :container
 {:image string,
  :command [string],
  :args [string],
  :env object,
  :workingDir string,
  :runAsUser integer},
 :annotations object,
 :replicaZones [string]}

optional:
workstationConfigId <string> Required. ID to use for the workstation configuration.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it."
  ([parent WorkstationConfig]
    (projects-locations-workstationClusters-workstationConfigs-create
      parent
      WorkstationConfig
      nil))
  ([parent WorkstationConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkstationConfig})))

(defn projects-locations-workstationClusters-workstationConfigs-delete
  "Deletes the specified workstation configuration.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/delete

name <string> Required. Name of the workstation configuration to delete.

optional:
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it.
etag <string> Optional. If set, the request is rejected if the latest version of the workstation configuration on the server does not have this ETag.
force <boolean> Optional. If set, any workstations in the workstation configuration are also deleted. Otherwise, the request works only if the workstation configuration has no workstations."
  ([name]
    (projects-locations-workstationClusters-workstationConfigs-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://workstations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-workstationClusters-workstationConfigs-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-list
  "Returns all workstation configurations in the specified cluster.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs/list

parent <string> Required. Parent resource name.

optional:
pageSize <integer> Optional. Maximum number of items to return."
  ([parent]
    (projects-locations-workstationClusters-workstationConfigs-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-get
  "Returns the requested workstation.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/get

name <string> Required. Name of the requested resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workstations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-listUsable
  "Returns all workstations using the specified workstation configuration on which the caller has the \"workstations.workstations.use\" permission.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/listUsable

parent <string> Required. Parent resource name.

optional:
pageSize <integer> Optional. Maximum number of items to return."
  ([parent]
    (projects-locations-workstationClusters-workstationConfigs-workstations-listUsable
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstations:listUsable",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-patch
  "Updates an existing workstation.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/patch

name <string> Identifier. Full name of this workstation.
Workstation:
{:labels object,
 :deleteTime string,
 :startTime string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  STATE_STARTING
  STATE_RUNNING
  STATE_STOPPING
  STATE_STOPPED],
 :env object,
 :updateTime string,
 :reconciling boolean,
 :host string,
 :kmsKey string,
 :annotations object}

optional:
updateMask <string> Required. Mask specifying which fields in the workstation configuration should be updated.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it.
allowMissing <boolean> Optional. If set and the workstation configuration is not found, a new workstation configuration is created. In this situation, update_mask is ignored."
  ([name Workstation]
    (projects-locations-workstationClusters-workstationConfigs-workstations-patch
      name
      Workstation
      nil))
  ([name Workstation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://workstations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Workstation})))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-create
  "Creates a new workstation.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/create

parent <string> Required. Parent resource name.
Workstation:
{:labels object,
 :deleteTime string,
 :startTime string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  STATE_STARTING
  STATE_RUNNING
  STATE_STOPPING
  STATE_STOPPED],
 :env object,
 :updateTime string,
 :reconciling boolean,
 :host string,
 :kmsKey string,
 :annotations object}

optional:
workstationId <string> Required. ID to use for the workstation.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it."
  ([parent Workstation]
    (projects-locations-workstationClusters-workstationConfigs-workstations-create
      parent
      Workstation
      nil))
  ([parent Workstation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Workstation})))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-start
  "Starts running a workstation so that users can connect to it.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/start

name <string> Required. Name of the workstation to start.
StartWorkstationRequest:
{:validateOnly boolean, :etag string}"
  [name StartWorkstationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+name}:start",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartWorkstationRequest}))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-delete
  "Deletes the specified workstation.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/delete

name <string> Required. Name of the workstation to delete.

optional:
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually apply it.
etag <string> Optional. If set, the request will be rejected if the latest version of the workstation on the server does not have this ETag."
  ([name]
    (projects-locations-workstationClusters-workstationConfigs-workstations-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://workstations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-generateAccessToken
  "Returns a short-lived credential that can be used to send authenticated and authorized traffic to a workstation.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/generateAccessToken

workstation <string> Required. Name of the workstation for which the access token should be generated.
GenerateAccessTokenRequest:
{:expireTime string, :ttl string}"
  [workstation GenerateAccessTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+workstation}:generateAccessToken",
     :uri-template-args {:workstation workstation},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateAccessTokenRequest}))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-workstationClusters-workstationConfigs-workstations-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-stop
  "Stops running a workstation, reducing costs.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/stop

name <string> Required. Name of the workstation to stop.
StopWorkstationRequest:
{:validateOnly boolean, :etag string}"
  [name StopWorkstationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workstations.googleapis.com/v1/{+name}:stop",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StopWorkstationRequest}))

(defn projects-locations-workstationClusters-workstationConfigs-workstations-list
  "Returns all Workstations using the specified workstation configuration.
https://cloud.google.com/workstations/docs/reference/rest/v1/projects.locations.workstationClusters.workstationConfigs.workstations/list

parent <string> Required. Parent resource name.

optional:
pageSize <integer> Optional. Maximum number of items to return."
  ([parent]
    (projects-locations-workstationClusters-workstationConfigs-workstations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workstations.googleapis.com/v1/{+parent}/workstations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

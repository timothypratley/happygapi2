(ns happygapi2.tpu
  "Cloud TPU API
TPU API provides customers with access to Google TPU technology.
See: https://cloud.google.com/tpu/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://tpu.googleapis.com/v2/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-generateServiceIdentity
  "Generates the Cloud TPU service identity for the project.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations/generateServiceIdentity

parent <string> Required. The parent resource name.
GenerateServiceIdentityRequest:
object"
  [parent GenerateServiceIdentityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://tpu.googleapis.com/v2/{+parent}:generateServiceIdentity",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateServiceIdentityRequest}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://tpu.googleapis.com/v2/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template "https://tpu.googleapis.com/v2/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-nodes-list
  "Lists nodes.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/list

parent <string> Required. The parent resource name.

optional:
pageSize <integer> The maximum number of items to return."
  ([parent] (projects-locations-nodes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://tpu.googleapis.com/v2/{+parent}/nodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nodes-get
  "Gets the details of a node.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/get

name <string> Required. The resource name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-nodes-create
  "Creates a node.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/create

parent <string> Required. The parent resource name.
Node:
{:description string,
 :serviceAccount {:email string, :scope [string]},
 :tags [string],
 :labels object,
 :queuedResource string,
 :acceleratorType string,
 :shieldedInstanceConfig {:enableSecureBoot boolean},
 :schedulingConfig
 {:preemptible boolean, :reserved boolean, :spot boolean},
 :name string,
 :symptoms
 [{:createTime string,
   :symptomType
   [SYMPTOM_TYPE_UNSPECIFIED
    LOW_MEMORY
    OUT_OF_MEMORY
    EXECUTE_TIMED_OUT
    MESH_BUILD_FAIL
    HBM_OUT_OF_MEMORY
    PROJECT_ABUSE],
   :details string,
   :workerId string}],
 :healthDescription string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  RESTARTING
  REIMAGING
  DELETING
  REPAIRING
  STOPPED
  STOPPING
  STARTING
  PREEMPTED
  TERMINATED
  HIDING
  HIDDEN
  UNHIDING],
 :networkConfig
 {:network string,
  :subnetwork string,
  :enableExternalIps boolean,
  :canIpForward boolean,
  :queueCount integer},
 :dataDisks
 [{:sourceDisk string,
   :mode [DISK_MODE_UNSPECIFIED READ_WRITE READ_ONLY]}],
 :multisliceNode boolean,
 :acceleratorConfig
 {:type [TYPE_UNSPECIFIED V2 V3 V4 V5LITE_POD V5P], :topology string},
 :id string,
 :runtimeVersion string,
 :networkEndpoints
 [{:ipAddress string,
   :port integer,
   :accessConfig {:externalIp string}}],
 :health
 [HEALTH_UNSPECIFIED
  HEALTHY
  TIMEOUT
  UNHEALTHY_TENSORFLOW
  UNHEALTHY_MAINTENANCE],
 :apiVersion [API_VERSION_UNSPECIFIED V1_ALPHA1 V1 V2_ALPHA1 V2],
 :metadata object,
 :cidrBlock string}

optional:
nodeId <string> The unqualified resource name."
  ([parent Node] (projects-locations-nodes-create parent Node nil))
  ([parent Node optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://tpu.googleapis.com/v2/{+parent}/nodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Node})))

(defn projects-locations-nodes-delete
  "Deletes a node.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/delete

name <string> Required. The resource name."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-nodes-stop
  "Stops a node. This operation is only available with single TPU nodes.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/stop

name <string> Required. The resource name.
StopNodeRequest:
object"
  [name StopNodeRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://tpu.googleapis.com/v2/{+name}:stop",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StopNodeRequest}))

(defn projects-locations-nodes-start
  "Starts a node.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/start

name <string> Required. The resource name.
StartNodeRequest:
object"
  [name StartNodeRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://tpu.googleapis.com/v2/{+name}:start",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartNodeRequest}))

(defn projects-locations-nodes-patch
  "Updates the configurations of a node.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/patch

name <string> Output only. Immutable. The name of the TPU.
Node:
{:description string,
 :serviceAccount {:email string, :scope [string]},
 :tags [string],
 :labels object,
 :queuedResource string,
 :acceleratorType string,
 :shieldedInstanceConfig {:enableSecureBoot boolean},
 :schedulingConfig
 {:preemptible boolean, :reserved boolean, :spot boolean},
 :name string,
 :symptoms
 [{:createTime string,
   :symptomType
   [SYMPTOM_TYPE_UNSPECIFIED
    LOW_MEMORY
    OUT_OF_MEMORY
    EXECUTE_TIMED_OUT
    MESH_BUILD_FAIL
    HBM_OUT_OF_MEMORY
    PROJECT_ABUSE],
   :details string,
   :workerId string}],
 :healthDescription string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  RESTARTING
  REIMAGING
  DELETING
  REPAIRING
  STOPPED
  STOPPING
  STARTING
  PREEMPTED
  TERMINATED
  HIDING
  HIDDEN
  UNHIDING],
 :networkConfig
 {:network string,
  :subnetwork string,
  :enableExternalIps boolean,
  :canIpForward boolean,
  :queueCount integer},
 :dataDisks
 [{:sourceDisk string,
   :mode [DISK_MODE_UNSPECIFIED READ_WRITE READ_ONLY]}],
 :multisliceNode boolean,
 :acceleratorConfig
 {:type [TYPE_UNSPECIFIED V2 V3 V4 V5LITE_POD V5P], :topology string},
 :id string,
 :runtimeVersion string,
 :networkEndpoints
 [{:ipAddress string,
   :port integer,
   :accessConfig {:externalIp string}}],
 :health
 [HEALTH_UNSPECIFIED
  HEALTHY
  TIMEOUT
  UNHEALTHY_TENSORFLOW
  UNHEALTHY_MAINTENANCE],
 :apiVersion [API_VERSION_UNSPECIFIED V1_ALPHA1 V1 V2_ALPHA1 V2],
 :metadata object,
 :cidrBlock string}

optional:
updateMask <string> Required. Mask of fields from Node to update. Supported fields: [description, tags, labels, metadata, network_config.enable_external_ips]."
  ([name Node] (projects-locations-nodes-patch name Node nil))
  ([name Node optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://tpu.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Node})))

(defn projects-locations-nodes-getGuestAttributes
  "Retrieves the guest attributes for the node.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.nodes/getGuestAttributes

name <string> Required. The resource name.
GetGuestAttributesRequest:
{:queryPath string, :workerIds [string]}"
  [name GetGuestAttributesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://tpu.googleapis.com/v2/{+name}:getGuestAttributes",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetGuestAttributesRequest}))

(defn projects-locations-queuedResources-list
  "Lists queued resources.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.queuedResources/list

parent <string> Required. The parent resource name.

optional:
pageSize <integer> Optional. The maximum number of items to return."
  ([parent] (projects-locations-queuedResources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://tpu.googleapis.com/v2/{+parent}/queuedResources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-queuedResources-get
  "Gets details of a queued resource.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.queuedResources/get

name <string> Required. The resource name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-queuedResources-create
  "Creates a QueuedResource TPU instance.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.queuedResources/create

parent <string> Required. The parent resource name.
QueuedResource:
{:name string,
 :createTime string,
 :tpu
 {:nodeSpec
  [{:parent string,
    :nodeId string,
    :multisliceParams {:nodeCount integer, :nodeIdPrefix string},
    :node
    {:description string,
     :serviceAccount {:email string, :scope [string]},
     :tags [string],
     :labels object,
     :queuedResource string,
     :acceleratorType string,
     :shieldedInstanceConfig {:enableSecureBoot boolean},
     :schedulingConfig
     {:preemptible boolean, :reserved boolean, :spot boolean},
     :name string,
     :symptoms
     [{:createTime string,
       :symptomType
       [SYMPTOM_TYPE_UNSPECIFIED
        LOW_MEMORY
        OUT_OF_MEMORY
        EXECUTE_TIMED_OUT
        MESH_BUILD_FAIL
        HBM_OUT_OF_MEMORY
        PROJECT_ABUSE],
       :details string,
       :workerId string}],
     :healthDescription string,
     :createTime string,
     :state
     [STATE_UNSPECIFIED
      CREATING
      READY
      RESTARTING
      REIMAGING
      DELETING
      REPAIRING
      STOPPED
      STOPPING
      STARTING
      PREEMPTED
      TERMINATED
      HIDING
      HIDDEN
      UNHIDING],
     :networkConfig
     {:network string,
      :subnetwork string,
      :enableExternalIps boolean,
      :canIpForward boolean,
      :queueCount integer},
     :dataDisks
     [{:sourceDisk string,
       :mode [DISK_MODE_UNSPECIFIED READ_WRITE READ_ONLY]}],
     :multisliceNode boolean,
     :acceleratorConfig
     {:type [TYPE_UNSPECIFIED V2 V3 V4 V5LITE_POD V5P],
      :topology string},
     :id string,
     :runtimeVersion string,
     :networkEndpoints
     [{:ipAddress string, :port integer, :accessConfig AccessConfig}],
     :health
     [HEALTH_UNSPECIFIED
      HEALTHY
      TIMEOUT
      UNHEALTHY_TENSORFLOW
      UNHEALTHY_MAINTENANCE],
     :apiVersion [API_VERSION_UNSPECIFIED V1_ALPHA1 V1 V2_ALPHA1 V2],
     :metadata object,
     :cidrBlock string}}]},
 :spot object,
 :guaranteed {:minDuration string},
 :queueingPolicy
 {:validUntilDuration string,
  :validUntilTime string,
  :validAfterDuration string,
  :validAfterTime string,
  :validInterval {:startTime string, :endTime string}},
 :state
 {:activeData object,
  :failedData
  {:error {:code integer, :message string, :details [object]}},
  :suspendingData object,
  :acceptedData object,
  :deletingData object,
  :state
  [STATE_UNSPECIFIED
   CREATING
   ACCEPTED
   PROVISIONING
   FAILED
   DELETING
   ACTIVE
   SUSPENDING
   SUSPENDED
   WAITING_FOR_RESOURCES],
  :provisioningData object,
  :stateInitiator [STATE_INITIATOR_UNSPECIFIED USER SERVICE],
  :creatingData object,
  :suspendedData object},
 :reservationName string}

optional:
queuedResourceId <string> Optional. The unqualified resource name. Should follow the `^[A-Za-z0-9_.~+%-]+$` regex format.
requestId <string> Optional. Idempotent request UUID."
  ([parent QueuedResource]
    (projects-locations-queuedResources-create
      parent
      QueuedResource
      nil))
  ([parent QueuedResource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://tpu.googleapis.com/v2/{+parent}/queuedResources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body QueuedResource})))

(defn projects-locations-queuedResources-delete
  "Deletes a QueuedResource TPU instance.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.queuedResources/delete

name <string> Required. The resource name.

optional:
requestId <string> Optional. Idempotent request UUID.
force <boolean> Optional. If set to true, all running nodes belonging to this queued resource will be deleted first and then the queued resource will be deleted. Otherwise (i.e. force=false), the queued resource will only be deleted if its nodes have already been deleted or the queued resource is in the ACCEPTED, FAILED, or SUSPENDED state."
  ([name] (projects-locations-queuedResources-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://tpu.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-queuedResources-reset
  "Resets a QueuedResource TPU instance
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.queuedResources/reset

name <string> Required. The name of the queued resource.
ResetQueuedResourceRequest:
object"
  [name ResetQueuedResourceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://tpu.googleapis.com/v2/{+name}:reset",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetQueuedResourceRequest}))

(defn projects-locations-acceleratorTypes-list
  "Lists accelerator types supported by this API.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.acceleratorTypes/list

parent <string> Required. The parent resource name.

optional:
pageSize <integer> The maximum number of items to return.
filter <string> List filter.
orderBy <string> Sort results."
  ([parent] (projects-locations-acceleratorTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://tpu.googleapis.com/v2/{+parent}/acceleratorTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-acceleratorTypes-get
  "Gets AcceleratorType.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.acceleratorTypes/get

name <string> Required. The resource name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-runtimeVersions-list
  "Lists runtime versions supported by this API.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.runtimeVersions/list

parent <string> Required. The parent resource name.

optional:
pageSize <integer> The maximum number of items to return.
filter <string> List filter.
orderBy <string> Sort results."
  ([parent] (projects-locations-runtimeVersions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://tpu.googleapis.com/v2/{+parent}/runtimeVersions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-runtimeVersions-get
  "Gets a runtime version.
https://cloud.google.com/tpu/docs/reference/rest/v2/projects.locations.runtimeVersions/get

name <string> Required. The resource name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://tpu.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

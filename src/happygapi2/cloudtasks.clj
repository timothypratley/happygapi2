(ns happygapi2.cloudtasks
  "Cloud Tasks API
Manages the execution of large numbers of distributed requests.
See: https://cloud.google.com/tasks/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudtasks.googleapis.com/v2/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-updateCmekConfig
  "Creates or Updates a CMEK config. Updates the Customer Managed Encryption Key assotiated with the Cloud Tasks location (Creates if the key does not already exist). All new tasks created in the location will be encrypted at-rest with the KMS-key provided in the config.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations/updateCmekConfig

name <string> Output only. The config resource name which includes the project and location and must end in 'cmekConfig', in the format projects/PROJECT_ID/locations/LOCATION_ID/cmekConfig`
CmekConfig:
{:name string, :kmsKey string}

optional:
updateMask <string> List of fields to be updated in this request."
  ([name CmekConfig]
    (projects-locations-updateCmekConfig name CmekConfig nil))
  ([name CmekConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CmekConfig})))

(defn projects-locations-getCmekConfig
  "Gets the CMEK config. Gets the Customer Managed Encryption Key configured with the Cloud Tasks lcoation. By default there is no kms_key configured.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations/getCmekConfig

name <string> Required. The config. For example: projects/PROJECT_ID/locations/LOCATION_ID/CmekConfig`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-queues-get
  "Gets a queue.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/get

name <string> Required. The resource name of the queue. For example: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-queues-setIamPolicy
  "Sets the access control policy for a Queue. Replaces any existing policy. Note: The Cloud Console does not check queue-level IAM permissions yet. Project-level permissions are required to use the Cloud Console. Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission on the specified resource parent: * `cloudtasks.queues.setIamPolicy`
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-queues-patch
  "Updates a queue. This method creates the queue if it does not exist and updates the queue if it does exist. Queues created with this method allow tasks to live for a maximum of 31 days. After a task is 31 days old, the task will be deleted regardless of whether it was dispatched or not. WARNING: Using this method may have unintended side effects if you are using an App Engine `queue.yaml` or `queue.xml` file to manage your queues. Read [Overview of Queue Management and queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using this method.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/patch

name <string> Caller-specified and required in CreateQueue, after which it becomes output only. The queue name. The queue name must have the following format: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID` * `PROJECT_ID` can contain letters ([A-Za-z]), numbers ([0-9]), hyphens (-), colons (:), or periods (.). For more information, see [Identifying projects](https://cloud.google.com/resource-manager/docs/creating-managing-projects#identifying_projects) * `LOCATION_ID` is the canonical ID for the queue's location. The list of available locations can be obtained by calling ListLocations. For more information, see https://cloud.google.com/about/locations/. * `QUEUE_ID` can contain letters ([A-Za-z]), numbers ([0-9]), or hyphens (-). The maximum length is 100 characters.
Queue:
{:name string,
 :appEngineRoutingOverride
 {:service string, :version string, :instance string, :host string},
 :httpTarget
 {:uriOverride
  {:scheme [SCHEME_UNSPECIFIED HTTP HTTPS],
   :host string,
   :port string,
   :pathOverride {:path string},
   :queryOverride {:queryParams string},
   :uriOverrideEnforceMode
   [URI_OVERRIDE_ENFORCE_MODE_UNSPECIFIED IF_NOT_EXISTS ALWAYS]},
  :httpMethod
  [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
  :headerOverrides [{:header {:key string, :value string}}],
  :oauthToken {:serviceAccountEmail string, :scope string},
  :oidcToken {:serviceAccountEmail string, :audience string}},
 :rateLimits
 {:maxDispatchesPerSecond number,
  :maxBurstSize integer,
  :maxConcurrentDispatches integer},
 :retryConfig
 {:maxAttempts integer,
  :maxRetryDuration string,
  :minBackoff string,
  :maxBackoff string,
  :maxDoublings integer},
 :state [STATE_UNSPECIFIED RUNNING PAUSED DISABLED],
 :purgeTime string,
 :stackdriverLoggingConfig {:samplingRatio number}}

optional:
updateMask <string> A mask used to specify which fields of the queue are being updated. If empty, then all fields will be updated."
  ([name Queue] (projects-locations-queues-patch name Queue nil))
  ([name Queue optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Queue})))

(defn projects-locations-queues-testIamPermissions
  "Returns permissions that a caller has on a Queue. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-queues-create
  "Creates a queue. Queues created with this method allow tasks to live for a maximum of 31 days. After a task is 31 days old, the task will be deleted regardless of whether it was dispatched or not. WARNING: Using this method may have unintended side effects if you are using an App Engine `queue.yaml` or `queue.xml` file to manage your queues. Read [Overview of Queue Management and queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using this method.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/create

parent <string> Required. The location name in which the queue will be created. For example: `projects/PROJECT_ID/locations/LOCATION_ID` The list of allowed locations can be obtained by calling Cloud Tasks' implementation of ListLocations.
Queue:
{:name string,
 :appEngineRoutingOverride
 {:service string, :version string, :instance string, :host string},
 :httpTarget
 {:uriOverride
  {:scheme [SCHEME_UNSPECIFIED HTTP HTTPS],
   :host string,
   :port string,
   :pathOverride {:path string},
   :queryOverride {:queryParams string},
   :uriOverrideEnforceMode
   [URI_OVERRIDE_ENFORCE_MODE_UNSPECIFIED IF_NOT_EXISTS ALWAYS]},
  :httpMethod
  [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
  :headerOverrides [{:header {:key string, :value string}}],
  :oauthToken {:serviceAccountEmail string, :scope string},
  :oidcToken {:serviceAccountEmail string, :audience string}},
 :rateLimits
 {:maxDispatchesPerSecond number,
  :maxBurstSize integer,
  :maxConcurrentDispatches integer},
 :retryConfig
 {:maxAttempts integer,
  :maxRetryDuration string,
  :minBackoff string,
  :maxBackoff string,
  :maxDoublings integer},
 :state [STATE_UNSPECIFIED RUNNING PAUSED DISABLED],
 :purgeTime string,
 :stackdriverLoggingConfig {:samplingRatio number}}"
  [parent Queue]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+parent}/queues",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Queue}))

(defn projects-locations-queues-delete
  "Deletes a queue. This command will delete the queue even if it has tasks in it. Note: If you delete a queue, you may be prevented from creating a new queue with the same name as the deleted queue for a tombstone window of up to 3 days. During this window, the CreateQueue operation may appear to recreate the queue, but this can be misleading. If you attempt to create a queue with the same name as one that is in the tombstone window, run GetQueue to confirm that the queue creation was successful. If GetQueue returns 200 response code, your queue was successfully created with the name of the previously deleted queue. Otherwise, your queue did not successfully recreate. WARNING: Using this method may have unintended side effects if you are using an App Engine `queue.yaml` or `queue.xml` file to manage your queues. Read [Overview of Queue Management and queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using this method.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/delete

name <string> Required. The queue name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-queues-getIamPolicy
  "Gets the access control policy for a Queue. Returns an empty policy if the resource exists and does not have a policy set. Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission on the specified resource parent: * `cloudtasks.queues.getIamPolicy`
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-queues-list
  "Lists queues. Queues are returned in lexicographical order.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/list

parent <string> Required. The location name. For example: `projects/PROJECT_ID/locations/LOCATION_ID`

optional:
filter <string> `filter` can be used to specify a subset of queues. Any Queue field can be used as a filter and several operators as supported. For example: `<=, <, >=, >, !=, =, :`. The filter syntax is the same as described in [Stackdriver's Advanced Logs Filters](https://cloud.google.com/logging/docs/view/advanced_filters). Sample filter \"state: PAUSED\". Note that using filters might cause fewer queues than the requested page_size to be returned.
pageSize <integer> Requested page size. The maximum page size is 9800. If unspecified, the page size will be the maximum. Fewer queues than requested might be returned, even if more queues exist; use the next_page_token in the response to determine if more queues exist."
  ([parent] (projects-locations-queues-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudtasks.googleapis.com/v2/{+parent}/queues",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-queues-purge
  "Purges a queue by deleting all of its tasks. All tasks created before this method is called are permanently deleted. Purge operations can take up to one minute to take effect. Tasks might be dispatched before the purge takes effect. A purge is irreversible.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/purge

name <string> Required. The queue name. For example: `projects/PROJECT_ID/location/LOCATION_ID/queues/QUEUE_ID`
PurgeQueueRequest:
object"
  [name PurgeQueueRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+name}:purge",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PurgeQueueRequest}))

(defn projects-locations-queues-pause
  "Pauses the queue. If a queue is paused then the system will stop dispatching tasks until the queue is resumed via ResumeQueue. Tasks can still be added when the queue is paused. A queue is paused if its state is PAUSED.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/pause

name <string> Required. The queue name. For example: `projects/PROJECT_ID/location/LOCATION_ID/queues/QUEUE_ID`
PauseQueueRequest:
object"
  [name PauseQueueRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PauseQueueRequest}))

(defn projects-locations-queues-resume
  "Resume a queue. This method resumes a queue after it has been PAUSED or DISABLED. The state of a queue is stored in the queue's state; after calling this method it will be set to RUNNING. WARNING: Resuming many high-QPS queues at the same time can lead to target overloading. If you are resuming high-QPS queues, follow the 500/50/5 pattern described in [Managing Cloud Tasks Scaling Risks](https://cloud.google.com/tasks/docs/manage-cloud-task-scaling).
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues/resume

name <string> Required. The queue name. For example: `projects/PROJECT_ID/location/LOCATION_ID/queues/QUEUE_ID`
ResumeQueueRequest:
object"
  [name ResumeQueueRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResumeQueueRequest}))

(defn projects-locations-queues-tasks-list
  "Lists the tasks in a queue. By default, only the BASIC view is retrieved due to performance considerations; response_view controls the subset of information which is returned. The tasks may be returned in any order. The ordering may change at any time.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues.tasks/list

parent <string> Required. The queue name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID`

optional:
responseView <string> The response_view specifies which subset of the Task will be returned. By default response_view is BASIC; not all information is retrieved by default because some data, such as payloads, might be desirable to return only when needed because of its large size or because of the sensitivity of data that it contains. Authorization for FULL requires `cloudtasks.tasks.fullView` [Google IAM](https://cloud.google.com/iam/) permission on the Task resource.
pageSize <integer> Maximum page size. Fewer tasks than requested might be returned, even if more tasks exist; use next_page_token in the response to determine if more tasks exist. The maximum page size is 1000. If unspecified, the page size will be the maximum."
  ([parent] (projects-locations-queues-tasks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudtasks.googleapis.com/v2/{+parent}/tasks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-queues-tasks-get
  "Gets a task.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues.tasks/get

name <string> Required. The task name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`

optional:
responseView <string> The response_view specifies which subset of the Task will be returned. By default response_view is BASIC; not all information is retrieved by default because some data, such as payloads, might be desirable to return only when needed because of its large size or because of the sensitivity of data that it contains. Authorization for FULL requires `cloudtasks.tasks.fullView` [Google IAM](https://cloud.google.com/iam/) permission on the Task resource."
  ([name] (projects-locations-queues-tasks-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-queues-tasks-create
  "Creates a task and adds it to a queue. Tasks cannot be updated after creation; there is no UpdateTask command. * The maximum task size is 100KB.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues.tasks/create

parent <string> Required. The queue name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID` The queue must already exist.
CreateTaskRequest:
{:task
 {:responseCount integer,
  :dispatchCount integer,
  :name string,
  :scheduleTime string,
  :createTime string,
  :firstAttempt
  {:scheduleTime string,
   :dispatchTime string,
   :responseTime string,
   :responseStatus
   {:code integer, :message string, :details [object]}},
  :dispatchDeadline string,
  :httpRequest
  {:url string,
   :httpMethod
   [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
   :headers object,
   :body string,
   :oauthToken {:serviceAccountEmail string, :scope string},
   :oidcToken {:serviceAccountEmail string, :audience string}},
  :appEngineHttpRequest
  {:httpMethod
   [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
   :appEngineRouting
   {:service string, :version string, :instance string, :host string},
   :relativeUri string,
   :headers object,
   :body string},
  :view [VIEW_UNSPECIFIED BASIC FULL],
  :lastAttempt
  {:scheduleTime string,
   :dispatchTime string,
   :responseTime string,
   :responseStatus
   {:code integer, :message string, :details [object]}}},
 :responseView [VIEW_UNSPECIFIED BASIC FULL]}"
  [parent CreateTaskRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+parent}/tasks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateTaskRequest}))

(defn projects-locations-queues-tasks-delete
  "Deletes a task. A task can be deleted if it is scheduled or dispatched. A task cannot be deleted if it has executed successfully or permanently failed.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues.tasks/delete

name <string> Required. The task name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudtasks.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-queues-tasks-run
  "Forces a task to run now. When this method is called, Cloud Tasks will dispatch the task, even if the task is already running, the queue has reached its RateLimits or is PAUSED. This command is meant to be used for manual debugging. For example, RunTask can be used to retry a failed task after a fix has been made or to manually force a task to be dispatched now. The dispatched task is returned. That is, the task that is returned contains the status after the task is dispatched but before the task is received by its target. If Cloud Tasks receives a successful response from the task's target, then the task will be deleted; otherwise the task's schedule_time will be reset to the time that RunTask was called plus the retry delay specified in the queue's RetryConfig. RunTask returns NOT_FOUND when it is called on a task that has already succeeded or permanently failed.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues.tasks/run

name <string> Required. The task name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`
RunTaskRequest:
{:responseView [VIEW_UNSPECIFIED BASIC FULL]}"
  [name RunTaskRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://cloudtasks.googleapis.com/v2/{+name}:run",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RunTaskRequest}))

(defn projects-locations-queues-tasks-buffer
  "Creates and buffers a new task without the need to explicitly define a Task message. The queue must have HTTP target. To create the task with a custom ID, use the following format and set TASK_ID to your desired ID: projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID:buffer To create the task with an automatically generated ID, use the following format: projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks:buffer.
https://cloud.google.com/tasks/docs/reference/rest/v2/projects.locations.queues.tasks/buffer

queue <string> Required. The parent queue name. For example: projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID` The queue must already exist.
taskId <string> Optional. Task ID for the task being created. If not provided, Cloud Tasks generates an ID for the task.
BufferTaskRequest:
{:body {:contentType string, :data string, :extensions [object]}}"
  [queue taskId BufferTaskRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtasks.googleapis.com/v2/{+queue}/tasks/{taskId}:buffer",
     :uri-template-args {:queue queue, :taskId taskId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BufferTaskRequest}))

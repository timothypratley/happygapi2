(ns happygapi2.batch
  "Batch API
An API to manage the running of Batch resources on Google Cloud Platform.
See: https://cloud.google.com/batch/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://batch.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://batch.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://batch.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://batch.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://batch.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://batch.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-jobs-create
  "Create a Job.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.jobs/create

parent <string> Required. The parent resource name where the Job will be created. Pattern: \"projects/{project}/locations/{location}\"
Job:
{:labels object,
 :uid string,
 :name string,
 :allocationPolicy
 {:location {:allowedLocations [string]},
  :instances
  [{:policy
    {:machineType string,
     :minCpuPlatform string,
     :provisioningModel
     [PROVISIONING_MODEL_UNSPECIFIED STANDARD SPOT PREEMPTIBLE],
     :accelerators
     [{:type string,
       :count string,
       :installGpuDrivers boolean,
       :driverVersion string}],
     :bootDisk
     {:image string,
      :snapshot string,
      :type string,
      :sizeGb string,
      :diskInterface string},
     :disks
     [{:newDisk Disk, :existingDisk string, :deviceName string}],
     :reservation string},
    :instanceTemplate string,
    :installGpuDrivers boolean,
    :installOpsAgent boolean}],
  :serviceAccount {:email string, :scopes [string]},
  :labels object,
  :network
  {:networkInterfaces
   [{:network string,
     :subnetwork string,
     :noExternalIpAddress boolean}]},
  :placement {:collocation string, :maxDistance string},
  :tags [string]},
 :createTime string,
 :logsPolicy
 {:destination [DESTINATION_UNSPECIFIED CLOUD_LOGGING PATH],
  :logsPath string,
  :cloudLoggingOption {:useGenericTaskMonitoredResource boolean}},
 :updateTime string,
 :taskGroups
 [{:taskCountPerNode string,
   :parallelism string,
   :schedulingPolicy
   [SCHEDULING_POLICY_UNSPECIFIED AS_SOON_AS_POSSIBLE IN_ORDER],
   :name string,
   :taskSpec
   {:runnables
    [{:labels object,
      :script {:path string, :text string},
      :displayName string,
      :background boolean,
      :barrier {:name string},
      :ignoreExitStatus boolean,
      :container
      {:enableImageStreaming boolean,
       :imageUri string,
       :password string,
       :username string,
       :volumes [string],
       :commands [string],
       :entrypoint string,
       :options string,
       :blockExternalNetwork boolean},
      :environment
      {:variables object,
       :secretVariables object,
       :encryptedVariables KMSEnvMap},
      :timeout string,
      :alwaysRun boolean}],
    :computeResource
    {:cpuMilli string, :memoryMib string, :bootDiskMib string},
    :maxRunDuration string,
    :maxRetryCount integer,
    :lifecyclePolicies
    [{:action [ACTION_UNSPECIFIED RETRY_TASK FAIL_TASK],
      :actionCondition {:exitCodes [integer]}}],
    :environments object,
    :volumes
    [{:nfs {:server string, :remotePath string},
      :gcs {:remotePath string},
      :deviceName string,
      :mountPath string,
      :mountOptions [string]}],
    :environment
    {:variables object,
     :secretVariables object,
     :encryptedVariables {:keyName string, :cipherText string}}},
   :permissiveSsh boolean,
   :requireHostsFile boolean,
   :taskCount string,
   :runAsNonRoot boolean,
   :taskEnvironments
   [{:variables object,
     :secretVariables object,
     :encryptedVariables {:keyName string, :cipherText string}}]}],
 :notifications
 [{:pubsubTopic string,
   :message
   {:type [TYPE_UNSPECIFIED JOB_STATE_CHANGED TASK_STATE_CHANGED],
    :newJobState
    [STATE_UNSPECIFIED
     QUEUED
     SCHEDULED
     RUNNING
     SUCCEEDED
     FAILED
     DELETION_IN_PROGRESS],
    :newTaskState
    [STATE_UNSPECIFIED
     PENDING
     ASSIGNED
     RUNNING
     FAILED
     SUCCEEDED
     UNEXECUTED]}}],
 :priority string,
 :status
 {:state
  [STATE_UNSPECIFIED
   QUEUED
   SCHEDULED
   RUNNING
   SUCCEEDED
   FAILED
   DELETION_IN_PROGRESS],
  :statusEvents
  [{:type string,
    :description string,
    :eventTime string,
    :taskExecution {:exitCode integer},
    :taskState
    [STATE_UNSPECIFIED
     PENDING
     ASSIGNED
     RUNNING
     FAILED
     SUCCEEDED
     UNEXECUTED]}],
  :taskGroups object,
  :runDuration string}}

optional:
jobId <string> ID used to uniquely identify the Job within its parent scope. This field should contain at most 63 characters and must start with lowercase characters. Only lowercase characters, numbers and '-' are accepted. The '-' character cannot be the first or the last one. A system generated ID will be used if the field is not set. The job.name field in the request will be ignored and the created resource name of the Job will be \"{parent}/jobs/{job_id}\".
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Job] (projects-locations-jobs-create parent Job nil))
  ([parent Job optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://batch.googleapis.com/v1/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Job})))

(defn projects-locations-jobs-get
  "Get a Job specified by its resource name.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.jobs/get

name <string> Required. Job name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://batch.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-delete
  "Delete a Job.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.jobs/delete

name <string> Job name.

optional:
reason <string> Optional. Reason for this deletion.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-jobs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://batch.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-list
  "List all Jobs for a project within a region.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.jobs/list

parent <string> Parent path.

optional:
filter <string> List filter.
orderBy <string> Optional. Sort results. Supported are \"name\", \"name desc\", \"create_time\", and \"create_time desc\".
pageSize <integer> Page size."
  ([parent] (projects-locations-jobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://batch.googleapis.com/v1/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-taskGroups-tasks-get
  "Return a single Task.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.jobs.taskGroups.tasks/get

name <string> Required. Task name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://batch.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-taskGroups-tasks-list
  "List Tasks associated with a job.
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.jobs.taskGroups.tasks/list

parent <string> Required. Name of a TaskGroup from which Tasks are being requested. Pattern: \"projects/{project}/locations/{location}/jobs/{job}/taskGroups/{task_group}\"

optional:
filter <string> Task filter, null filter matches all Tasks. Filter string should be of the format State=TaskStatus.State e.g. State=RUNNING
pageSize <integer> Page size."
  ([parent] (projects-locations-jobs-taskGroups-tasks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://batch.googleapis.com/v1/{+parent}/tasks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-state-report
  "Report agent's state, e.g. agent status and tasks information
https://cloud.google.com/batch/docs/reference/rest/v1/projects.locations.state/report

parent <string> Required. Format: projects/{project}/locations/{location} {project} should be a project number.
ReportAgentStateRequest:
{:metadata
 {:creationTime string,
  :creator string,
  :instance string,
  :instanceId string,
  :zone string,
  :osRelease object,
  :machineType string,
  :instancePreemptionNoticeReceived boolean,
  :imageVersion string,
  :version string},
 :agentInfo
 {:state
  [AGENT_STATE_UNSPECIFIED AGENT_STARTING AGENT_RUNNING AGENT_STOPPED],
  :jobId string,
  :tasks
  [{:taskId string,
    :taskStatus
    {:state
     [STATE_UNSPECIFIED
      PENDING
      ASSIGNED
      RUNNING
      FAILED
      SUCCEEDED
      UNEXECUTED],
     :statusEvents
     [{:type string,
       :description string,
       :eventTime string,
       :taskExecution TaskExecution,
       :taskState
       [STATE_UNSPECIFIED
        PENDING
        ASSIGNED
        RUNNING
        FAILED
        SUCCEEDED
        UNEXECUTED]}]},
    :runnable string}],
  :reportTime string,
  :taskGroupId string},
 :agentTimingInfo
 {:bootTime string,
  :scriptStartupTime string,
  :agentStartupTime string}}"
  [parent ReportAgentStateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://batch.googleapis.com/v1/{+parent}/state:report",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ReportAgentStateRequest}))

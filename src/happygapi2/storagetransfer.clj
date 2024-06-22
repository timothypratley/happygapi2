(ns happygapi2.storagetransfer
  "Storage Transfer API
Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets. 
See: https://cloud.google.com/storage-transfer/docs/overview"
  (:require [happy.oauth2.client :as client]))

(defn transferOperations-list
  "Lists transfer operations. Operations are ordered by their creation time in reverse chronological order.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferOperations/list

name <string> Required. The name of the type being listed; must be `transferOperations`.
filter <string> Required. A list of query parameters specified as JSON text in the form of: `{\"projectId\":\"my_project_id\", \"jobNames\":[\"jobid1\",\"jobid2\",...], \"jobNamePattern\": \"job_name_pattern\", \"operationNames\":[\"opid1\",\"opid2\",...], \"operationNamePattern\": \"operation_name_pattern\", \"minCreationTime\": \"min_creation_time\", \"maxCreationTime\": \"max_creation_time\", \"transferStatuses\":[\"status1\",\"status2\",...]}` Since `jobNames`, `operationNames`, and `transferStatuses` support multiple values, they must be specified with array notation. `projectId` is the only argument that is required. If specified, `jobNamePattern` and `operationNamePattern` must match the full job or operation name respectively. '*' is a wildcard matching 0 or more characters. `minCreationTime` and `maxCreationTime` should be timestamps encoded as a string in the [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format. The valid values for `transferStatuses` are case-insensitive: IN_PROGRESS, PAUSED, SUCCESS, FAILED, and ABORTED.

optional:
pageSize <integer> The list page size. The max allowed value is 256."
  ([name filter] (transferOperations-list name filter nil))
  ([name filter optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storagetransfer.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {:filter filter} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn transferOperations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferOperations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://storagetransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn transferOperations-cancel
  "Cancels a transfer. Use the transferOperations.get method to check if the cancellation succeeded or if the operation completed despite the `cancel` request. When you cancel an operation, the currently running transfer is interrupted. For recurring transfer jobs, the next instance of the transfer job will still run. For example, if your job is configured to run every day at 1pm and you cancel Monday's operation at 1:05pm, Monday's transfer will stop. However, a transfer job will still be attempted on Tuesday. This applies only to currently running operations. If an operation is not currently running, `cancel` does nothing. *Caution:* Canceling a transfer job can leave your data in an unknown state. We recommend that you restore the state at both the destination and the source after the `cancel` request completes so that your data is in a consistent state. When you cancel a job, the next job computes a delta of files and may repair any inconsistent state. For instance, if you run a job every day, and today's job found 10 new files and transferred five files before you canceled the job, tomorrow's transfer operation will compute a new delta with the five files that were not copied today plus any new files discovered tomorrow.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferOperations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn transferOperations-pause
  "Pauses a transfer operation.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferOperations/pause

name <string> Required. The name of the transfer operation.
PauseTransferOperationRequest:
object"
  [name PauseTransferOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PauseTransferOperationRequest}))

(defn transferOperations-resume
  "Resumes a transfer operation that is paused.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferOperations/resume

name <string> Required. The name of the transfer operation.
ResumeTransferOperationRequest:
object"
  [name ResumeTransferOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResumeTransferOperationRequest}))

(defn googleServiceAccounts-get
  "Returns the Google service account that is used by Storage Transfer Service to access buckets in the project where transfers run or in other projects. Each Google service account is associated with one Google Cloud project. Users should add this service account to the Google Cloud Storage bucket ACLs to grant access to Storage Transfer Service. This service account is created and owned by Storage Transfer Service and can only be used by Storage Transfer Service.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/googleServiceAccounts/get

projectId <string> Required. The ID of the Google Cloud project that the Google service account is associated with."
  [projectId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/googleServiceAccounts/{projectId}",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn transferJobs-create
  "Creates a transfer job that runs periodically.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferJobs/create

TransferJob:
{:creationTime string,
 :description string,
 :schedule
 {:scheduleStartDate {:year integer, :month integer, :day integer},
  :scheduleEndDate {:year integer, :month integer, :day integer},
  :startTimeOfDay
  {:hours integer, :minutes integer, :seconds integer, :nanos integer},
  :endTimeOfDay
  {:hours integer, :minutes integer, :seconds integer, :nanos integer},
  :repeatInterval string},
 :loggingConfig
 {:logActions [[LOGGABLE_ACTION_UNSPECIFIED FIND DELETE COPY]],
  :logActionStates
  [[LOGGABLE_ACTION_STATE_UNSPECIFIED SUCCEEDED FAILED]],
  :enableOnpremGcsTransferLogs boolean},
 :name string,
 :lastModificationTime string,
 :eventStream
 {:name string,
  :eventStreamStartTime string,
  :eventStreamExpirationTime string},
 :latestOperationName string,
 :deletionTime string,
 :replicationSpec
 {:gcsDataSource
  {:bucketName string,
   :path string,
   :managedFolderTransferEnabled boolean},
  :gcsDataSink
  {:bucketName string,
   :path string,
   :managedFolderTransferEnabled boolean},
  :objectConditions
  {:minTimeElapsedSinceLastModification string,
   :maxTimeElapsedSinceLastModification string,
   :includePrefixes [string],
   :excludePrefixes [string],
   :lastModifiedSince string,
   :lastModifiedBefore string},
  :transferOptions
  {:overwriteObjectsAlreadyExistingInSink boolean,
   :deleteObjectsUniqueInSink boolean,
   :deleteObjectsFromSourceAfterTransfer boolean,
   :overwriteWhen [OVERWRITE_WHEN_UNSPECIFIED DIFFERENT NEVER ALWAYS],
   :metadataOptions
   {:storageClass
    [STORAGE_CLASS_UNSPECIFIED
     STORAGE_CLASS_DESTINATION_BUCKET_DEFAULT
     STORAGE_CLASS_PRESERVE
     STORAGE_CLASS_STANDARD
     STORAGE_CLASS_NEARLINE
     STORAGE_CLASS_COLDLINE
     STORAGE_CLASS_ARCHIVE],
    :timeCreated
    [TIME_CREATED_UNSPECIFIED
     TIME_CREATED_SKIP
     TIME_CREATED_PRESERVE_AS_CUSTOM_TIME],
    :temporaryHold
    [TEMPORARY_HOLD_UNSPECIFIED
     TEMPORARY_HOLD_SKIP
     TEMPORARY_HOLD_PRESERVE],
    :uid [UID_UNSPECIFIED UID_SKIP UID_NUMBER],
    :mode [MODE_UNSPECIFIED MODE_SKIP MODE_PRESERVE],
    :gid [GID_UNSPECIFIED GID_SKIP GID_NUMBER],
    :kmsKey
    [KMS_KEY_UNSPECIFIED
     KMS_KEY_DESTINATION_BUCKET_DEFAULT
     KMS_KEY_PRESERVE],
    :acl [ACL_UNSPECIFIED ACL_DESTINATION_BUCKET_DEFAULT ACL_PRESERVE],
    :symlink [SYMLINK_UNSPECIFIED SYMLINK_SKIP SYMLINK_PRESERVE]}}},
 :status [STATUS_UNSPECIFIED ENABLED DISABLED DELETED],
 :notificationConfig
 {:pubsubTopic string,
  :eventTypes
  [[EVENT_TYPE_UNSPECIFIED
    TRANSFER_OPERATION_SUCCESS
    TRANSFER_OPERATION_FAILED
    TRANSFER_OPERATION_ABORTED]],
  :payloadFormat [PAYLOAD_FORMAT_UNSPECIFIED NONE JSON]},
 :projectId string,
 :transferSpec
 {:awsS3CompatibleDataSource
  {:bucketName string,
   :path string,
   :endpoint string,
   :region string,
   :s3Metadata
   {:authMethod
    [AUTH_METHOD_UNSPECIFIED
     AUTH_METHOD_AWS_SIGNATURE_V4
     AUTH_METHOD_AWS_SIGNATURE_V2],
    :requestModel
    [REQUEST_MODEL_UNSPECIFIED
     REQUEST_MODEL_VIRTUAL_HOSTED_STYLE
     REQUEST_MODEL_PATH_STYLE],
    :protocol
    [NETWORK_PROTOCOL_UNSPECIFIED
     NETWORK_PROTOCOL_HTTPS
     NETWORK_PROTOCOL_HTTP],
    :listApi [LIST_API_UNSPECIFIED LIST_OBJECTS_V2 LIST_OBJECTS]}},
  :sourceAgentPoolName string,
  :transferOptions
  {:overwriteObjectsAlreadyExistingInSink boolean,
   :deleteObjectsUniqueInSink boolean,
   :deleteObjectsFromSourceAfterTransfer boolean,
   :overwriteWhen [OVERWRITE_WHEN_UNSPECIFIED DIFFERENT NEVER ALWAYS],
   :metadataOptions
   {:storageClass
    [STORAGE_CLASS_UNSPECIFIED
     STORAGE_CLASS_DESTINATION_BUCKET_DEFAULT
     STORAGE_CLASS_PRESERVE
     STORAGE_CLASS_STANDARD
     STORAGE_CLASS_NEARLINE
     STORAGE_CLASS_COLDLINE
     STORAGE_CLASS_ARCHIVE],
    :timeCreated
    [TIME_CREATED_UNSPECIFIED
     TIME_CREATED_SKIP
     TIME_CREATED_PRESERVE_AS_CUSTOM_TIME],
    :temporaryHold
    [TEMPORARY_HOLD_UNSPECIFIED
     TEMPORARY_HOLD_SKIP
     TEMPORARY_HOLD_PRESERVE],
    :uid [UID_UNSPECIFIED UID_SKIP UID_NUMBER],
    :mode [MODE_UNSPECIFIED MODE_SKIP MODE_PRESERVE],
    :gid [GID_UNSPECIFIED GID_SKIP GID_NUMBER],
    :kmsKey
    [KMS_KEY_UNSPECIFIED
     KMS_KEY_DESTINATION_BUCKET_DEFAULT
     KMS_KEY_PRESERVE],
    :acl [ACL_UNSPECIFIED ACL_DESTINATION_BUCKET_DEFAULT ACL_PRESERVE],
    :symlink [SYMLINK_UNSPECIFIED SYMLINK_SKIP SYMLINK_PRESERVE]}},
  :posixDataSink {:rootDirectory string},
  :gcsDataSource
  {:bucketName string,
   :path string,
   :managedFolderTransferEnabled boolean},
  :transferManifest {:location string},
  :hdfsDataSource {:path string},
  :sinkAgentPoolName string,
  :httpDataSource {:listUrl string},
  :posixDataSource {:rootDirectory string},
  :objectConditions
  {:minTimeElapsedSinceLastModification string,
   :maxTimeElapsedSinceLastModification string,
   :includePrefixes [string],
   :excludePrefixes [string],
   :lastModifiedSince string,
   :lastModifiedBefore string},
  :awsS3DataSource
  {:bucketName string,
   :awsAccessKey {:accessKeyId string, :secretAccessKey string},
   :path string,
   :roleArn string,
   :cloudfrontDomain string,
   :credentialsSecret string,
   :managedPrivateNetwork boolean},
  :gcsDataSink
  {:bucketName string,
   :path string,
   :managedFolderTransferEnabled boolean},
  :gcsIntermediateDataLocation
  {:bucketName string,
   :path string,
   :managedFolderTransferEnabled boolean},
  :azureBlobStorageDataSource
  {:storageAccount string,
   :azureCredentials {:sasToken string},
   :container string,
   :path string,
   :credentialsSecret string}}}"
  [TransferJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/transferJobs",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TransferJob}))

(defn transferJobs-patch
  "Updates a transfer job. Updating a job's transfer spec does not affect transfer operations that are running already. **Note:** The job's status field can be modified using this RPC (for example, to set a job's status to DELETED, DISABLED, or ENABLED).
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferJobs/patch

jobName <string> Required. The name of job to update.
UpdateTransferJobRequest:
{:projectId string,
 :transferJob
 {:creationTime string,
  :description string,
  :schedule
  {:scheduleStartDate {:year integer, :month integer, :day integer},
   :scheduleEndDate {:year integer, :month integer, :day integer},
   :startTimeOfDay
   {:hours integer,
    :minutes integer,
    :seconds integer,
    :nanos integer},
   :endTimeOfDay
   {:hours integer,
    :minutes integer,
    :seconds integer,
    :nanos integer},
   :repeatInterval string},
  :loggingConfig
  {:logActions [[LOGGABLE_ACTION_UNSPECIFIED FIND DELETE COPY]],
   :logActionStates
   [[LOGGABLE_ACTION_STATE_UNSPECIFIED SUCCEEDED FAILED]],
   :enableOnpremGcsTransferLogs boolean},
  :name string,
  :lastModificationTime string,
  :eventStream
  {:name string,
   :eventStreamStartTime string,
   :eventStreamExpirationTime string},
  :latestOperationName string,
  :deletionTime string,
  :replicationSpec
  {:gcsDataSource
   {:bucketName string,
    :path string,
    :managedFolderTransferEnabled boolean},
   :gcsDataSink
   {:bucketName string,
    :path string,
    :managedFolderTransferEnabled boolean},
   :objectConditions
   {:minTimeElapsedSinceLastModification string,
    :maxTimeElapsedSinceLastModification string,
    :includePrefixes [string],
    :excludePrefixes [string],
    :lastModifiedSince string,
    :lastModifiedBefore string},
   :transferOptions
   {:overwriteObjectsAlreadyExistingInSink boolean,
    :deleteObjectsUniqueInSink boolean,
    :deleteObjectsFromSourceAfterTransfer boolean,
    :overwriteWhen [OVERWRITE_WHEN_UNSPECIFIED DIFFERENT NEVER ALWAYS],
    :metadataOptions
    {:storageClass
     [STORAGE_CLASS_UNSPECIFIED
      STORAGE_CLASS_DESTINATION_BUCKET_DEFAULT
      STORAGE_CLASS_PRESERVE
      STORAGE_CLASS_STANDARD
      STORAGE_CLASS_NEARLINE
      STORAGE_CLASS_COLDLINE
      STORAGE_CLASS_ARCHIVE],
     :timeCreated
     [TIME_CREATED_UNSPECIFIED
      TIME_CREATED_SKIP
      TIME_CREATED_PRESERVE_AS_CUSTOM_TIME],
     :temporaryHold
     [TEMPORARY_HOLD_UNSPECIFIED
      TEMPORARY_HOLD_SKIP
      TEMPORARY_HOLD_PRESERVE],
     :uid [UID_UNSPECIFIED UID_SKIP UID_NUMBER],
     :mode [MODE_UNSPECIFIED MODE_SKIP MODE_PRESERVE],
     :gid [GID_UNSPECIFIED GID_SKIP GID_NUMBER],
     :kmsKey
     [KMS_KEY_UNSPECIFIED
      KMS_KEY_DESTINATION_BUCKET_DEFAULT
      KMS_KEY_PRESERVE],
     :acl
     [ACL_UNSPECIFIED ACL_DESTINATION_BUCKET_DEFAULT ACL_PRESERVE],
     :symlink [SYMLINK_UNSPECIFIED SYMLINK_SKIP SYMLINK_PRESERVE]}}},
  :status [STATUS_UNSPECIFIED ENABLED DISABLED DELETED],
  :notificationConfig
  {:pubsubTopic string,
   :eventTypes
   [[EVENT_TYPE_UNSPECIFIED
     TRANSFER_OPERATION_SUCCESS
     TRANSFER_OPERATION_FAILED
     TRANSFER_OPERATION_ABORTED]],
   :payloadFormat [PAYLOAD_FORMAT_UNSPECIFIED NONE JSON]},
  :projectId string,
  :transferSpec
  {:awsS3CompatibleDataSource
   {:bucketName string,
    :path string,
    :endpoint string,
    :region string,
    :s3Metadata
    {:authMethod
     [AUTH_METHOD_UNSPECIFIED
      AUTH_METHOD_AWS_SIGNATURE_V4
      AUTH_METHOD_AWS_SIGNATURE_V2],
     :requestModel
     [REQUEST_MODEL_UNSPECIFIED
      REQUEST_MODEL_VIRTUAL_HOSTED_STYLE
      REQUEST_MODEL_PATH_STYLE],
     :protocol
     [NETWORK_PROTOCOL_UNSPECIFIED
      NETWORK_PROTOCOL_HTTPS
      NETWORK_PROTOCOL_HTTP],
     :listApi [LIST_API_UNSPECIFIED LIST_OBJECTS_V2 LIST_OBJECTS]}},
   :sourceAgentPoolName string,
   :transferOptions
   {:overwriteObjectsAlreadyExistingInSink boolean,
    :deleteObjectsUniqueInSink boolean,
    :deleteObjectsFromSourceAfterTransfer boolean,
    :overwriteWhen [OVERWRITE_WHEN_UNSPECIFIED DIFFERENT NEVER ALWAYS],
    :metadataOptions
    {:storageClass
     [STORAGE_CLASS_UNSPECIFIED
      STORAGE_CLASS_DESTINATION_BUCKET_DEFAULT
      STORAGE_CLASS_PRESERVE
      STORAGE_CLASS_STANDARD
      STORAGE_CLASS_NEARLINE
      STORAGE_CLASS_COLDLINE
      STORAGE_CLASS_ARCHIVE],
     :timeCreated
     [TIME_CREATED_UNSPECIFIED
      TIME_CREATED_SKIP
      TIME_CREATED_PRESERVE_AS_CUSTOM_TIME],
     :temporaryHold
     [TEMPORARY_HOLD_UNSPECIFIED
      TEMPORARY_HOLD_SKIP
      TEMPORARY_HOLD_PRESERVE],
     :uid [UID_UNSPECIFIED UID_SKIP UID_NUMBER],
     :mode [MODE_UNSPECIFIED MODE_SKIP MODE_PRESERVE],
     :gid [GID_UNSPECIFIED GID_SKIP GID_NUMBER],
     :kmsKey
     [KMS_KEY_UNSPECIFIED
      KMS_KEY_DESTINATION_BUCKET_DEFAULT
      KMS_KEY_PRESERVE],
     :acl
     [ACL_UNSPECIFIED ACL_DESTINATION_BUCKET_DEFAULT ACL_PRESERVE],
     :symlink [SYMLINK_UNSPECIFIED SYMLINK_SKIP SYMLINK_PRESERVE]}},
   :posixDataSink {:rootDirectory string},
   :gcsDataSource
   {:bucketName string,
    :path string,
    :managedFolderTransferEnabled boolean},
   :transferManifest {:location string},
   :hdfsDataSource {:path string},
   :sinkAgentPoolName string,
   :httpDataSource {:listUrl string},
   :posixDataSource {:rootDirectory string},
   :objectConditions
   {:minTimeElapsedSinceLastModification string,
    :maxTimeElapsedSinceLastModification string,
    :includePrefixes [string],
    :excludePrefixes [string],
    :lastModifiedSince string,
    :lastModifiedBefore string},
   :awsS3DataSource
   {:bucketName string,
    :awsAccessKey {:accessKeyId string, :secretAccessKey string},
    :path string,
    :roleArn string,
    :cloudfrontDomain string,
    :credentialsSecret string,
    :managedPrivateNetwork boolean},
   :gcsDataSink
   {:bucketName string,
    :path string,
    :managedFolderTransferEnabled boolean},
   :gcsIntermediateDataLocation
   {:bucketName string,
    :path string,
    :managedFolderTransferEnabled boolean},
   :azureBlobStorageDataSource
   {:storageAccount string,
    :azureCredentials {:sasToken string},
    :container string,
    :path string,
    :credentialsSecret string}}},
 :updateTransferJobFieldMask string}"
  [jobName UpdateTransferJobRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/{+jobName}",
     :uri-template-args {:jobName jobName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpdateTransferJobRequest}))

(defn transferJobs-get
  "Gets a transfer job.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferJobs/get

jobName <string> Required. The job to get.
projectId <string> Required. The ID of the Google Cloud project that owns the job."
  [jobName projectId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/{+jobName}",
     :uri-template-args {:jobName jobName},
     :query-params {:projectId projectId},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn transferJobs-list
  "Lists transfer jobs.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferJobs/list

filter <string> Required. A list of query parameters specified as JSON text in the form of: `{\"projectId\":\"my_project_id\", \"jobNames\":[\"jobid1\",\"jobid2\",...], \"jobStatuses\":[\"status1\",\"status2\",...]}` Since `jobNames` and `jobStatuses` support multiple values, their values must be specified with array notation. `projectId` is required. `jobNames` and `jobStatuses` are optional. The valid values for `jobStatuses` are case-insensitive: ENABLED, DISABLED, and DELETED.

optional:
pageSize <integer> The list page size. The max allowed value is 256."
  ([filter] (transferJobs-list filter nil))
  ([filter optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storagetransfer.googleapis.com/v1/transferJobs",
       :uri-template-args {},
       :query-params (merge {:filter filter} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn transferJobs-run
  "Starts a new operation for the specified transfer job. A `TransferJob` has a maximum of one active `TransferOperation`. If this method is called while a `TransferOperation` is active, an error is returned.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferJobs/run

jobName <string> Required. The name of the transfer job.
RunTransferJobRequest:
{:projectId string}"
  [jobName RunTransferJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/{+jobName}:run",
     :uri-template-args {:jobName jobName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RunTransferJobRequest}))

(defn transferJobs-delete
  "Deletes a transfer job. Deleting a transfer job sets its status to DELETED.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/transferJobs/delete

jobName <string> Required. The job to delete.
projectId <string> Required. The ID of the Google Cloud project that owns the job."
  [jobName projectId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://storagetransfer.googleapis.com/v1/{+jobName}",
     :uri-template-args {:jobName jobName},
     :query-params {:projectId projectId},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-agentPools-create
  "Creates an agent pool resource.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/projects.agentPools/create

projectId <string> Required. The ID of the Google Cloud project that owns the agent pool.
AgentPool:
{:name string,
 :displayName string,
 :state [STATE_UNSPECIFIED CREATING CREATED DELETING],
 :bandwidthLimit {:limitMbps string}}

optional:
agentPoolId <string> Required. The ID of the agent pool to create. The `agent_pool_id` must meet the following requirements: * Length of 128 characters or less. * Not start with the string `goog`. * Start with a lowercase ASCII character, followed by: * Zero or more: lowercase Latin alphabet characters, numerals, hyphens (`-`), periods (`.`), underscores (`_`), or tildes (`~`). * One or more numerals or lowercase ASCII characters. As expressed by the regular expression: `^(?!goog)[a-z]([a-z0-9-._~]*[a-z0-9])?$`."
  ([projectId AgentPool]
    (projects-agentPools-create projectId AgentPool nil))
  ([projectId AgentPool optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storagetransfer.googleapis.com/v1/projects/{+projectId}/agentPools",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AgentPool})))

(defn projects-agentPools-patch
  "Updates an existing agent pool resource.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/projects.agentPools/patch

name <string> Required. Specifies a unique string that identifies the agent pool. Format: `projects/{project_id}/agentPools/{agent_pool_id}`
AgentPool:
{:name string,
 :displayName string,
 :state [STATE_UNSPECIFIED CREATING CREATED DELETING],
 :bandwidthLimit {:limitMbps string}}

optional:
updateMask <string> The [field mask] (https://developers.google.com/protocol-buffers/docs/reference/google.protobuf) of the fields in `agentPool` to update in this request. The following `agentPool` fields can be updated: * display_name * bandwidth_limit"
  ([name AgentPool] (projects-agentPools-patch name AgentPool nil))
  ([name AgentPool optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://storagetransfer.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AgentPool})))

(defn projects-agentPools-get
  "Gets an agent pool.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/projects.agentPools/get

name <string> Required. The name of the agent pool to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://storagetransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-agentPools-list
  "Lists agent pools.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/projects.agentPools/list

projectId <string> Required. The ID of the Google Cloud project that owns the job.

optional:
filter <string> An optional list of query parameters specified as JSON text in the form of: `{\"agentPoolNames\":[\"agentpool1\",\"agentpool2\",...]}` Since `agentPoolNames` support multiple values, its values must be specified with array notation. When the filter is either empty or not provided, the list returns all agent pools for the project.
pageSize <integer> The list page size. The max allowed value is `256`."
  ([projectId] (projects-agentPools-list projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storagetransfer.googleapis.com/v1/projects/{+projectId}/agentPools",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-agentPools-delete
  "Deletes an agent pool.
https://cloud.google.com/storage-transfer/docs/reference/rest/v1/projects.agentPools/delete

name <string> Required. The name of the agent pool to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://storagetransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

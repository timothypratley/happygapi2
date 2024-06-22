(ns happygapi2.aiplatform
  "Vertex AI API
Train high-quality custom machine learning models with minimal machine learning expertise and effort.
See: https://cloud.google.com/vertex-ai/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/vertex-ai

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/vertex-ai

name <string> The resource that owns the locations collection, if applicable.

optional:
pageSize <integer> The maximum number of results to return. If not set, the service selects a default.
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160)."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nasJobs-create
  "Creates a NasJob
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the NasJob in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1NasJob:
{:labels object,
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :name string,
 :endTime string,
 :createTime string,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :updateTime string,
 :nasJobSpec
 {:resumeNasJobId string,
  :searchSpaceSpec string,
  :multiTrialAlgorithmSpec
  {:trainTrialSpec
   {:trainTrialJobSpec
    {:serviceAccount string,
     :protectedArtifactLocationId string,
     :enableWebAccess boolean,
     :scheduling GoogleCloudAiplatformV1Scheduling,
     :enableDashboardAccess boolean,
     :experimentRun string,
     :persistentResourceId string,
     :tensorboard string,
     :workerPoolSpecs [GoogleCloudAiplatformV1WorkerPoolSpec],
     :reservedIpRanges [string],
     :baseOutputDirectory GoogleCloudAiplatformV1GcsDestination,
     :experiment string,
     :models [string],
     :network string},
    :maxParallelTrialCount integer,
    :frequency integer},
   :metric
   {:goal [GOAL_TYPE_UNSPECIFIED MAXIMIZE MINIMIZE], :metricId string},
   :multiTrialAlgorithm
   [MULTI_TRIAL_ALGORITHM_UNSPECIFIED
    REINFORCEMENT_LEARNING
    GRID_SEARCH],
   :searchTrialSpec
   {:maxTrialCount integer,
    :searchTrialJobSpec
    {:serviceAccount string,
     :protectedArtifactLocationId string,
     :enableWebAccess boolean,
     :scheduling GoogleCloudAiplatformV1Scheduling,
     :enableDashboardAccess boolean,
     :experimentRun string,
     :persistentResourceId string,
     :tensorboard string,
     :workerPoolSpecs [GoogleCloudAiplatformV1WorkerPoolSpec],
     :reservedIpRanges [string],
     :baseOutputDirectory GoogleCloudAiplatformV1GcsDestination,
     :experiment string,
     :models [string],
     :network string},
    :maxParallelTrialCount integer,
    :maxFailedTrialCount integer}}},
 :nasJobOutput
 {:multiTrialJobOutput
  {:trainTrials
   [{:startTime string,
     :id string,
     :finalMeasurement
     {:metrics [GoogleCloudAiplatformV1MeasurementMetric],
      :elapsedDuration string,
      :stepCount string},
     :state
     [STATE_UNSPECIFIED
      REQUESTED
      ACTIVE
      STOPPING
      SUCCEEDED
      INFEASIBLE],
     :endTime string}],
   :searchTrials
   [{:startTime string,
     :id string,
     :finalMeasurement
     {:metrics [GoogleCloudAiplatformV1MeasurementMetric],
      :elapsedDuration string,
      :stepCount string},
     :state
     [STATE_UNSPECIFIED
      REQUESTED
      ACTIVE
      STOPPING
      SUCCEEDED
      INFEASIBLE],
     :endTime string}]}},
 :error {:message string, :code integer, :details [object]},
 :enableRestrictedImageTraining boolean}"
  [parent GoogleCloudAiplatformV1NasJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/nasJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1NasJob}))

(defn projects-locations-nasJobs-delete
  "Deletes a NasJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NasJob resource to be deleted. Format: `projects/{project}/locations/{location}/nasJobs/{nas_job}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-nasJobs-get
  "Gets a NasJob
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NasJob resource. Format: `projects/{project}/locations/{location}/nasJobs/{nas_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-nasJobs-cancel
  "Cancels a NasJob. Starts asynchronous cancellation on the NasJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetNasJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the NasJob is not deleted; instead it becomes a job with a NasJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and NasJob.state is set to `CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NasJob to cancel. Format: `projects/{project}/locations/{location}/nasJobs/{nas_job}`
GoogleCloudAiplatformV1CancelNasJobRequest:
object"
  [name GoogleCloudAiplatformV1CancelNasJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CancelNasJobRequest}))

(defn projects-locations-nasJobs-list
  "Lists NasJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the NasJobs from. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The standard list page size.
readMask <string> Mask specifying which fields to read.
filter <string> The standard list filter. Supported fields: * `display_name` supports `=`, `!=` comparisons, and `:` wildcard. * `state` supports `=`, `!=` comparisons. * `create_time` supports `=`, `!=`,`<`, `<=`,`>`, `>=` comparisons. `create_time` must be in RFC 3339 format. * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* - key existence Some examples of using the filter are: * `state=\"JOB_STATE_SUCCEEDED\" AND display_name:\"my_job_*\"` * `state!=\"JOB_STATE_FAILED\" OR display_name=\"my_job\"` * `NOT display_name=\"my_job\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `labels.keyA=valueA` * `labels.keyB:*`"
  ([parent] (projects-locations-nasJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/nasJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nasJobs-nasTrialDetails-list
  "List top NasTrialDetails of a NasJob.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the NasJob resource. Format: `projects/{project}/locations/{location}/nasJobs/{nas_job}`

optional:
pageSize <integer> The standard list page size."
  ([parent]
    (projects-locations-nasJobs-nasTrialDetails-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/nasTrialDetails",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nasJobs-nasTrialDetails-get
  "Gets a NasTrialDetail.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NasTrialDetail resource. Format: `projects/{project}/locations/{location}/nasJobs/{nas_job}/nasTrialDetails/{nas_trial_detail}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimes-upgrade
  "Upgrades a NotebookRuntime.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NotebookRuntime resource to be upgrade. Instead of checking whether the name is in valid NotebookRuntime resource name format, directly throw NotFound exception if there is no such NotebookRuntime in spanner.
GoogleCloudAiplatformV1UpgradeNotebookRuntimeRequest:
object"
  [name GoogleCloudAiplatformV1UpgradeNotebookRuntimeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:upgrade",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1UpgradeNotebookRuntimeRequest}))

(defn projects-locations-notebookRuntimes-delete
  "Deletes a NotebookRuntime.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NotebookRuntime resource to be deleted. Instead of checking whether the name is in valid NotebookRuntime resource name format, directly throw NotFound exception if there is no such NotebookRuntime in spanner."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimes-assign
  "Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either returns an existing assignment or generates a new one.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to get the NotebookRuntime assignment. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1AssignNotebookRuntimeRequest:
{:notebookRuntimeId string,
 :notebookRuntime
 {:description string,
  :serviceAccount string,
  :labels object,
  :encryptionSpec {:kmsKeyName string},
  :proxyUri string,
  :idleShutdownConfig
  {:idleTimeout string, :idleShutdownDisabled boolean},
  :runtimeState
  [RUNTIME_STATE_UNSPECIFIED
   RUNNING
   BEING_STARTED
   BEING_STOPPED
   STOPPED
   BEING_UPGRADED
   ERROR
   INVALID],
  :expirationTime string,
  :satisfiesPzi boolean,
  :displayName string,
  :name string,
  :runtimeUser string,
  :createTime string,
  :isUpgradable boolean,
  :notebookRuntimeType
  [NOTEBOOK_RUNTIME_TYPE_UNSPECIFIED USER_DEFINED ONE_CLICK],
  :updateTime string,
  :satisfiesPzs boolean,
  :version string,
  :healthState [HEALTH_STATE_UNSPECIFIED HEALTHY UNHEALTHY],
  :networkTags [string],
  :notebookRuntimeTemplateRef {:notebookRuntimeTemplate string}},
 :notebookRuntimeTemplate string}"
  [parent GoogleCloudAiplatformV1AssignNotebookRuntimeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/notebookRuntimes:assign",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1AssignNotebookRuntimeRequest}))

(defn projects-locations-notebookRuntimes-get
  "Gets a NotebookRuntime.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NotebookRuntime resource. Instead of checking whether the name is in valid NotebookRuntime resource name format, directly throw NotFound exception if there is no such NotebookRuntime in spanner."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimes-list
  "Lists NotebookRuntimes in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location from which to list the NotebookRuntimes. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Optional. Mask specifying which fields to read.
orderBy <string> Optional. A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `display_name` * `create_time` * `update_time` Example: `display_name, create_time desc`.
filter <string> Optional. An expression for filtering the results of the request. For field names both snake_case and camelCase are supported. * `notebookRuntime` supports = and !=. `notebookRuntime` represents the NotebookRuntime ID, i.e. the last segment of the NotebookRuntime's resource name. * `displayName` supports = and != and regex. * `notebookRuntimeTemplate` supports = and !=. `notebookRuntimeTemplate` represents the NotebookRuntimeTemplate ID, i.e. the last segment of the NotebookRuntimeTemplate's resource name. * `healthState` supports = and !=. healthState enum: [HEALTHY, UNHEALTHY, HEALTH_STATE_UNSPECIFIED]. * `runtimeState` supports = and !=. runtimeState enum: [RUNTIME_STATE_UNSPECIFIED, RUNNING, BEING_STARTED, BEING_STOPPED, STOPPED, BEING_UPGRADED, ERROR, INVALID]. * `runtimeUser` supports = and !=. * API version is UI only: `uiState` supports = and !=. uiState enum: [UI_RESOURCE_STATE_UNSPECIFIED, UI_RESOURCE_STATE_BEING_CREATED, UI_RESOURCE_STATE_ACTIVE, UI_RESOURCE_STATE_BEING_DELETED, UI_RESOURCE_STATE_CREATION_FAILED]. * `notebookRuntimeType` supports = and !=. notebookRuntimeType enum: [USER_DEFINED, ONE_CLICK]. Some examples: * `notebookRuntime=\"notebookRuntime123\"` * `displayName=\"myDisplayName\"` and `displayName=~\"myDisplayNameRegex\"` * `notebookRuntimeTemplate=\"notebookRuntimeTemplate321\"` * `healthState=HEALTHY` * `runtimeState=RUNNING` * `runtimeUser=\"test@google.com\"` * `uiState=UI_RESOURCE_STATE_BEING_DELETED` * `notebookRuntimeType=USER_DEFINED`
pageSize <integer> Optional. The standard list page size."
  ([parent] (projects-locations-notebookRuntimes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/notebookRuntimes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimes-start
  "Starts a NotebookRuntime.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NotebookRuntime resource to be started. Instead of checking whether the name is in valid NotebookRuntime resource name format, directly throw NotFound exception if there is no such NotebookRuntime in spanner.
GoogleCloudAiplatformV1StartNotebookRuntimeRequest:
object"
  [name GoogleCloudAiplatformV1StartNotebookRuntimeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:start",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1StartNotebookRuntimeRequest}))

(defn projects-locations-notebookRuntimes-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-notebookRuntimes-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimes-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimes-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-notebookRuntimes-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimes-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimes-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-list
  "Lists Datasets in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the Dataset's parent resource. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read.
filter <string> An expression for filtering the results of the request. For field names both snake_case and camelCase are supported. * `display_name`: supports = and != * `metadata_schema_uri`: supports = and != * `labels` supports general map functions that is: * `labels.key=value` - key:value equality * `labels.key:* or labels:key - key existence * A key including a space must be quoted. `labels.\"a key\"`. Some examples: * `displayName=\"myDisplayName\"` * `labels.myKey=\"myValue\"`
pageSize <integer> The standard list page size.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `display_name` * `create_time` * `update_time`"
  ([parent] (projects-locations-datasets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/datasets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-export
  "Exports data from a Dataset.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Dataset resource. Format: `projects/{project}/locations/{location}/datasets/{dataset}`
GoogleCloudAiplatformV1ExportDataRequest:
{:exportConfig
 {:fractionSplit
  {:trainingFraction number,
   :testFraction number,
   :validationFraction number},
  :savedQueryId string,
  :filterSplit
  {:validationFilter string,
   :testFilter string,
   :trainingFilter string},
  :exportUse [EXPORT_USE_UNSPECIFIED CUSTOM_CODE_TRAINING],
  :annotationSchemaUri string,
  :gcsDestination {:outputUriPrefix string},
  :annotationsFilter string}}"
  [name GoogleCloudAiplatformV1ExportDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:export",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ExportDataRequest}))

(defn projects-locations-datasets-delete
  "Deletes a Dataset.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Dataset to delete. Format: `projects/{project}/locations/{location}/datasets/{dataset}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-patch
  "Updates a Dataset.
https://cloud.google.com/vertex-ai

name <string> Output only. The resource name of the Dataset.
GoogleCloudAiplatformV1Dataset:
{:description string,
 :labels object,
 :savedQueries
 [{:displayName string,
   :annotationSpecCount integer,
   :name string,
   :createTime string,
   :etag string,
   :annotationFilter string,
   :updateTime string,
   :supportAutomlTraining boolean,
   :metadata any,
   :problemType string}],
 :encryptionSpec {:kmsKeyName string},
 :metadataSchemaUri string,
 :displayName string,
 :name string,
 :createTime string,
 :metadataArtifact string,
 :etag string,
 :dataItemCount string,
 :updateTime string,
 :metadata any,
 :modelReference string}

optional:
updateMask <string> Required. The update mask applies to the resource. For the `FieldMask` definition, see google.protobuf.FieldMask. Updatable fields: * `display_name` * `description` * `labels`"
  ([name GoogleCloudAiplatformV1Dataset]
    (projects-locations-datasets-patch
      name
      GoogleCloudAiplatformV1Dataset
      nil))
  ([name GoogleCloudAiplatformV1Dataset optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Dataset})))

(defn projects-locations-datasets-import
  "Imports data into a Dataset.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Dataset resource. Format: `projects/{project}/locations/{location}/datasets/{dataset}`
GoogleCloudAiplatformV1ImportDataRequest:
{:importConfigs
 [{:dataItemLabels object,
   :gcsSource {:uris [string]},
   :annotationLabels object,
   :importSchemaUri string}]}"
  [name GoogleCloudAiplatformV1ImportDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:import",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ImportDataRequest}))

(defn projects-locations-datasets-searchDataItems
  "Searches DataItems in a Dataset.
https://cloud.google.com/vertex-ai

dataset <string> Required. The resource name of the Dataset from which to search DataItems. Format: `projects/{project}/locations/{location}/datasets/{dataset}`

optional:
fieldMask <string> Mask specifying which fields of DataItemView to read.
annotationsLimit <integer> If set, only up to this many of Annotations will be returned per DataItemView. The maximum value is 1000. If not set, the maximum value will be used.
savedQuery <string> The resource name of a SavedQuery(annotation set in UI). Format: `projects/{project}/locations/{location}/datasets/{dataset}/savedQueries/{saved_query}` All of the search will be done in the context of this SavedQuery.
orderByAnnotation.savedQuery <string> Required. Saved query of the Annotation. Only Annotations belong to this saved query will be considered for ordering.
orderByAnnotation.orderBy <string> A comma-separated list of annotation fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Must also specify saved_query.
dataLabelingJob <string> The resource name of a DataLabelingJob. Format: `projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}` If this field is set, all of the search will be done in the context of this DataLabelingJob.
annotationsFilter <string> An expression for filtering the Annotations that will be returned per DataItem. * `annotation_spec_id` - for = or !=.
orderByDataItem <string> A comma-separated list of data item fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending.
pageSize <integer> Requested page size. Server may return fewer results than requested. Default and maximum page size is 100.
dataItemFilter <string> An expression for filtering the DataItem that will be returned. * `data_item_id` - for = or !=. * `labeled` - for = or !=. * `has_annotation(ANNOTATION_SPEC_ID)` - true only for DataItem that have at least one annotation with annotation_spec_id = `ANNOTATION_SPEC_ID` in the context of SavedQuery or DataLabelingJob. For example: * `data_item=1` * `has_annotation(5)`
annotationFilters <string> An expression that specifies what Annotations will be returned per DataItem. Annotations satisfied either of the conditions will be returned. * `annotation_spec_id` - for = or !=. Must specify `saved_query_id=` - saved query id that annotations should belong to.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending."
  ([dataset] (projects-locations-datasets-searchDataItems dataset nil))
  ([dataset optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+dataset}:searchDataItems",
       :uri-template-args {:dataset dataset},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-create
  "Creates a Dataset.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the Dataset in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1Dataset:
{:description string,
 :labels object,
 :savedQueries
 [{:displayName string,
   :annotationSpecCount integer,
   :name string,
   :createTime string,
   :etag string,
   :annotationFilter string,
   :updateTime string,
   :supportAutomlTraining boolean,
   :metadata any,
   :problemType string}],
 :encryptionSpec {:kmsKeyName string},
 :metadataSchemaUri string,
 :displayName string,
 :name string,
 :createTime string,
 :metadataArtifact string,
 :etag string,
 :dataItemCount string,
 :updateTime string,
 :metadata any,
 :modelReference string}"
  [parent GoogleCloudAiplatformV1Dataset]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/datasets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1Dataset}))

(defn projects-locations-datasets-get
  "Gets a Dataset.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Dataset resource.

optional:
readMask <string> Mask specifying which fields to read."
  ([name] (projects-locations-datasets-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-dataItems-list
  "Lists DataItems in a Dataset.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Dataset to list DataItems from. Format: `projects/{project}/locations/{location}/datasets/{dataset}`

optional:
filter <string> The standard list filter.
readMask <string> Mask specifying which fields to read.
pageSize <integer> The standard list page size.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending."
  ([parent] (projects-locations-datasets-dataItems-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/dataItems",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-dataItems-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-dataItems-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-dataItems-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-datasets-dataItems-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-dataItems-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-datasets-dataItems-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-dataItems-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-dataItems-annotations-list
  "Lists Annotations belongs to a dataitem
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the DataItem to list Annotations from. Format: `projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}`

optional:
pageSize <integer> The standard list page size.
readMask <string> Mask specifying which fields to read.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending.
filter <string> The standard list filter."
  ([parent]
    (projects-locations-datasets-dataItems-annotations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/annotations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-dataItems-annotations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-dataItems-annotations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-dataItems-annotations-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-datasets-dataItems-annotations-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-dataItems-annotations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-datasets-dataItems-annotations-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-dataItems-annotations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-datasetVersions-create
  "Create a version from a Dataset.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the Dataset resource. Format: `projects/{project}/locations/{location}/datasets/{dataset}`
GoogleCloudAiplatformV1DatasetVersion:
{:createTime string,
 :etag string,
 :name string,
 :metadata any,
 :displayName string,
 :updateTime string,
 :bigQueryDatasetName string,
 :modelReference string}"
  [parent GoogleCloudAiplatformV1DatasetVersion]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/datasetVersions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1DatasetVersion}))

(defn projects-locations-datasets-datasetVersions-get
  "Gets a Dataset version.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Dataset version to delete. Format: `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`

optional:
readMask <string> Mask specifying which fields to read."
  ([name] (projects-locations-datasets-datasetVersions-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-datasetVersions-patch
  "Updates a DatasetVersion.
https://cloud.google.com/vertex-ai

name <string> Output only. The resource name of the DatasetVersion.
GoogleCloudAiplatformV1DatasetVersion:
{:createTime string,
 :etag string,
 :name string,
 :metadata any,
 :displayName string,
 :updateTime string,
 :bigQueryDatasetName string,
 :modelReference string}

optional:
updateMask <string> Required. The update mask applies to the resource. For the `FieldMask` definition, see google.protobuf.FieldMask. Updatable fields: * `display_name`"
  ([name GoogleCloudAiplatformV1DatasetVersion]
    (projects-locations-datasets-datasetVersions-patch
      name
      GoogleCloudAiplatformV1DatasetVersion
      nil))
  ([name GoogleCloudAiplatformV1DatasetVersion optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1DatasetVersion})))

(defn projects-locations-datasets-datasetVersions-list
  "Lists DatasetVersions in a Dataset.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Dataset to list DatasetVersions from. Format: `projects/{project}/locations/{location}/datasets/{dataset}`

optional:
pageSize <integer> Optional. The standard list page size.
filter <string> Optional. The standard list filter.
readMask <string> Optional. Mask specifying which fields to read.
orderBy <string> Optional. A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending."
  ([parent]
    (projects-locations-datasets-datasetVersions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/datasetVersions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-datasetVersions-delete
  "Deletes a Dataset version.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Dataset version to delete. Format: `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-datasetVersions-restore
  "Restores a dataset version.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the DatasetVersion resource. Format: `projects/{project}/locations/{location}/datasets/{dataset}/datasetVersions/{dataset_version}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:restore",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-datasets-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-datasets-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-annotationSpecs-get
  "Gets an AnnotationSpec.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the AnnotationSpec resource. Format: `projects/{project}/locations/{location}/datasets/{dataset}/annotationSpecs/{annotation_spec}`

optional:
readMask <string> Mask specifying which fields to read."
  ([name] (projects-locations-datasets-annotationSpecs-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-annotationSpecs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-annotationSpecs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-datasets-annotationSpecs-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-annotationSpecs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-datasets-annotationSpecs-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-annotationSpecs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-annotationSpecs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-savedQueries-delete
  "Deletes a SavedQuery.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the SavedQuery to delete. Format: `projects/{project}/locations/{location}/datasets/{dataset}/savedQueries/{saved_query}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-savedQueries-list
  "Lists SavedQueries in a Dataset.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Dataset to list SavedQueries from. Format: `projects/{project}/locations/{location}/datasets/{dataset}`

optional:
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending.
readMask <string> Mask specifying which fields to read.
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([parent] (projects-locations-datasets-savedQueries-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/savedQueries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-savedQueries-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-savedQueries-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-savedQueries-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-datasets-savedQueries-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-datasets-savedQueries-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-datasets-savedQueries-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-datasets-savedQueries-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-pipelineJobs-create
  "Creates a PipelineJob. A PipelineJob will run immediately when created.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the PipelineJob in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1PipelineJob:
{:serviceAccount string,
 :labels object,
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :runtimeConfig
 {:gcsOutputDirectory string,
  :parameters object,
  :failurePolicy
  [PIPELINE_FAILURE_POLICY_UNSPECIFIED
   PIPELINE_FAILURE_POLICY_FAIL_SLOW
   PIPELINE_FAILURE_POLICY_FAIL_FAST],
  :inputArtifacts object,
  :parameterValues object},
 :name string,
 :templateUri string,
 :endTime string,
 :createTime string,
 :reservedIpRanges [string],
 :preflightValidations boolean,
 :state
 [PIPELINE_STATE_UNSPECIFIED
  PIPELINE_STATE_QUEUED
  PIPELINE_STATE_PENDING
  PIPELINE_STATE_RUNNING
  PIPELINE_STATE_SUCCEEDED
  PIPELINE_STATE_FAILED
  PIPELINE_STATE_CANCELLING
  PIPELINE_STATE_CANCELLED
  PIPELINE_STATE_PAUSED],
 :updateTime string,
 :jobDetail
 {:pipelineRunContext
  {:description string,
   :labels object,
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :parentContexts [string],
   :metadata object,
   :schemaVersion string},
  :pipelineContext
  {:description string,
   :labels object,
   :schemaTitle string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :parentContexts [string],
   :metadata object,
   :schemaVersion string},
  :taskDetails
  [{:pipelineTaskStatus
    [{:state
      [STATE_UNSPECIFIED
       PENDING
       RUNNING
       SUCCEEDED
       CANCEL_PENDING
       CANCELLING
       CANCELLED
       FAILED
       SKIPPED
       NOT_TRIGGERED],
      :error {:message string, :code integer, :details [object]},
      :updateTime string}],
    :execution
    {:description string,
     :labels object,
     :schemaTitle string,
     :displayName string,
     :name string,
     :createTime string,
     :etag string,
     :state
     [STATE_UNSPECIFIED NEW RUNNING COMPLETE FAILED CACHED CANCELLED],
     :updateTime string,
     :metadata object,
     :schemaVersion string},
    :startTime string,
    :endTime string,
    :createTime string,
    :state
    [STATE_UNSPECIFIED
     PENDING
     RUNNING
     SUCCEEDED
     CANCEL_PENDING
     CANCELLING
     CANCELLED
     FAILED
     SKIPPED
     NOT_TRIGGERED],
    :inputs object,
    :parentTaskId string,
    :outputs object,
    :error {:message string, :code integer, :details [object]},
    :taskName string,
    :taskId string,
    :executorDetail
    {:containerDetail
     {:failedMainJobs [string],
      :failedPreCachingCheckJobs [string],
      :mainJob string,
      :preCachingCheckJob string},
     :customJobDetail {:job string, :failedJobs [string]}}}]},
 :error {:message string, :code integer, :details [object]},
 :network string,
 :pipelineSpec object,
 :scheduleName string,
 :templateMetadata {:version string}}

optional:
pipelineJobId <string> The ID to use for the PipelineJob, which will become the final component of the PipelineJob name. If not provided, an ID will be automatically generated. This value should be less than 128 characters, and valid characters are `/a-z-/`."
  ([parent GoogleCloudAiplatformV1PipelineJob]
    (projects-locations-pipelineJobs-create
      parent
      GoogleCloudAiplatformV1PipelineJob
      nil))
  ([parent GoogleCloudAiplatformV1PipelineJob optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/pipelineJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1PipelineJob})))

(defn projects-locations-pipelineJobs-batchCancel
  "Batch cancel PipelineJobs. Firstly the server will check if all the jobs are in non-terminal states, and skip the jobs that are already terminated. If the operation failed, none of the pipeline jobs are cancelled. The server will poll the states of all the pipeline jobs periodically to check the cancellation status. This operation will return an LRO.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the PipelineJobs' parent resource. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1BatchCancelPipelineJobsRequest:
{:names [string]}"
  [parent GoogleCloudAiplatformV1BatchCancelPipelineJobsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/pipelineJobs:batchCancel",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1BatchCancelPipelineJobsRequest}))

(defn projects-locations-pipelineJobs-batchDelete
  "Batch deletes PipelineJobs The Operation is atomic. If it fails, none of the PipelineJobs are deleted. If it succeeds, all of the PipelineJobs are deleted.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the PipelineJobs' parent resource. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1BatchDeletePipelineJobsRequest:
{:names [string]}"
  [parent GoogleCloudAiplatformV1BatchDeletePipelineJobsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/pipelineJobs:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1BatchDeletePipelineJobsRequest}))

(defn projects-locations-pipelineJobs-get
  "Gets a PipelineJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the PipelineJob resource. Format: `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-pipelineJobs-list
  "Lists PipelineJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the PipelineJobs from. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read.
filter <string> Lists the PipelineJobs that match the filter expression. The following fields are supported: * `pipeline_name`: Supports `=` and `!=` comparisons. * `display_name`: Supports `=`, `!=` comparisons, and `:` wildcard. * `pipeline_job_user_id`: Supports `=`, `!=` comparisons, and `:` wildcard. for example, can check if pipeline's display_name contains *step* by doing display_name:\\\"*step*\\\" * `state`: Supports `=` and `!=` comparisons. * `create_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `update_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `end_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `labels`: Supports key-value equality and key presence. * `template_uri`: Supports `=`, `!=` comparisons, and `:` wildcard. * `template_metadata.version`: Supports `=`, `!=` comparisons, and `:` wildcard. Filter expressions can be combined together using logical operators (`AND` & `OR`). For example: `pipeline_name=\"test\" AND create_time>\"2020-05-18T13:30:00Z\"`. The syntax to define filter expression is based on https://google.aip.dev/160. Examples: * `create_time>\"2021-05-18T00:00:00Z\" OR update_time>\"2020-05-18T00:00:00Z\"` PipelineJobs created or updated after 2020-05-18 00:00:00 UTC. * `labels.env = \"prod\"` PipelineJobs with label \"env\" set to \"prod\".
pageSize <integer> The standard list page size.
orderBy <string> A comma-separated list of fields to order by. The default sort order is in ascending order. Use \"desc\" after a field name for descending. You can have multiple order_by fields provided e.g. \"create_time desc, end_time\", \"end_time, start_time, update_time\" For example, using \"create_time desc, end_time\" will order results by create time in descending order, and if there are multiple jobs having the same create time, order them by the end time in ascending order. if order_by is not specified, it will order by default order is create time in descending order. Supported fields: * `create_time` * `update_time` * `end_time` * `start_time`"
  ([parent] (projects-locations-pipelineJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/pipelineJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-pipelineJobs-delete
  "Deletes a PipelineJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the PipelineJob resource to be deleted. Format: `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-pipelineJobs-cancel
  "Cancels a PipelineJob. Starts asynchronous cancellation on the PipelineJob. The server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can use PipelineService.GetPipelineJob or other methods to check whether the cancellation succeeded or whether the pipeline completed despite cancellation. On successful cancellation, the PipelineJob is not deleted; instead it becomes a pipeline with a PipelineJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and PipelineJob.state is set to `CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the PipelineJob to cancel. Format: `projects/{project}/locations/{location}/pipelineJobs/{pipeline_job}`
GoogleCloudAiplatformV1CancelPipelineJobRequest:
object"
  [name GoogleCloudAiplatformV1CancelPipelineJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CancelPipelineJobRequest}))

(defn projects-locations-pipelineJobs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-pipelineJobs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-pipelineJobs-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-pipelineJobs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-pipelineJobs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-pipelineJobs-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-pipelineJobs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tuningJobs-list
  "Lists TuningJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the TuningJobs from. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> Optional. The standard list page size.
filter <string> Optional. The standard list filter."
  ([parent] (projects-locations-tuningJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/tuningJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tuningJobs-get
  "Gets a TuningJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TuningJob resource. Format: `projects/{project}/locations/{location}/tuningJobs/{tuning_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tuningJobs-create
  "Creates a TuningJob. A created TuningJob right away will be attempted to be run.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the TuningJob in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1TuningJob:
{:description string,
 :labels object,
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :tunedModel {:endpoint string, :model string},
 :name string,
 :tunedModelDisplayName string,
 :endTime string,
 :createTime string,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :baseModel string,
 :updateTime string,
 :experiment string,
 :supervisedTuningSpec
 {:trainingDatasetUri string,
  :validationDatasetUri string,
  :hyperParameters
  {:learningRateMultiplier number,
   :adapterSize
   [ADAPTER_SIZE_UNSPECIFIED
    ADAPTER_SIZE_ONE
    ADAPTER_SIZE_FOUR
    ADAPTER_SIZE_EIGHT
    ADAPTER_SIZE_SIXTEEN],
   :epochCount string}},
 :tuningDataStats
 {:supervisedTuningDataStats
  {:tuningDatasetExampleCount string,
   :userInputTokenDistribution
   {:p5 number,
    :sum string,
    :buckets [{:count number, :left number, :right number}],
    :mean number,
    :p95 number,
    :max number,
    :min number,
    :median number},
   :userDatasetExamples
   [{:role string,
     :parts
     [{:functionResponse GoogleCloudAiplatformV1FunctionResponse,
       :text string,
       :functionCall GoogleCloudAiplatformV1FunctionCall,
       :videoMetadata GoogleCloudAiplatformV1VideoMetadata,
       :inlineData GoogleCloudAiplatformV1Blob,
       :fileData GoogleCloudAiplatformV1FileData}]}],
   :totalTuningCharacterCount string,
   :tuningStepCount string,
   :totalBillableCharacterCount string,
   :userOutputTokenDistribution
   {:p5 number,
    :sum string,
    :buckets [{:count number, :left number, :right number}],
    :mean number,
    :p95 number,
    :max number,
    :min number,
    :median number},
   :userMessagePerExampleDistribution
   {:p5 number,
    :sum string,
    :buckets [{:count number, :left number, :right number}],
    :mean number,
    :p95 number,
    :max number,
    :min number,
    :median number}}},
 :error {:message string, :code integer, :details [object]}}"
  [parent GoogleCloudAiplatformV1TuningJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/tuningJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1TuningJob}))

(defn projects-locations-tuningJobs-cancel
  "Cancels a TuningJob. Starts asynchronous cancellation on the TuningJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use GenAiTuningService.GetTuningJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the TuningJob is not deleted; instead it becomes a job with a TuningJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and TuningJob.state is set to `CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TuningJob to cancel. Format: `projects/{project}/locations/{location}/tuningJobs/{tuning_job}`
GoogleCloudAiplatformV1CancelTuningJobRequest:
object"
  [name GoogleCloudAiplatformV1CancelTuningJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CancelTuningJobRequest}))

(defn projects-locations-tuningJobs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-tuningJobs-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tuningJobs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tuningJobs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-list
  "Lists MetadataStores for a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The Location whose MetadataStores should be listed. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of Metadata Stores to return. The service may return fewer. Must be in range 1-1000, inclusive. Defaults to 100."
  ([parent] (projects-locations-metadataStores-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/metadataStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-create
  "Initializes a MetadataStore, including allocation of resources.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location where the MetadataStore should be created. Format: `projects/{project}/locations/{location}/`
GoogleCloudAiplatformV1MetadataStore:
{:description string,
 :dataplexConfig {:enabledPipelinesLineage boolean},
 :name string,
 :state {:diskUtilizationBytes string},
 :updateTime string,
 :encryptionSpec {:kmsKeyName string},
 :createTime string}

optional:
metadataStoreId <string> The {metadatastore} portion of the resource name with the format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}` If not provided, the MetadataStore's ID will be a UUID generated by the service. Must be 4-128 characters in length. Valid characters are `/a-z-/`. Must be unique across all MetadataStores in the parent Location. (Otherwise the request will fail with ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting MetadataStore.)"
  ([parent GoogleCloudAiplatformV1MetadataStore]
    (projects-locations-metadataStores-create
      parent
      GoogleCloudAiplatformV1MetadataStore
      nil))
  ([parent GoogleCloudAiplatformV1MetadataStore optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/metadataStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1MetadataStore})))

(defn projects-locations-metadataStores-get
  "Retrieves a specific MetadataStore.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the MetadataStore to retrieve. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-delete
  "Deletes a single MetadataStore and all its child resources (Artifacts, Executions, and Contexts).
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the MetadataStore to delete. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`

optional:
force <boolean> Deprecated: Field is no longer supported."
  ([name] (projects-locations-metadataStores-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-metadataStores-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-metadataStores-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-artifacts-get
  "Retrieves a specific Artifact.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Artifact to retrieve. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-artifacts-patch
  "Updates a stored Artifact.
https://cloud.google.com/vertex-ai

name <string> Output only. The resource name of the Artifact.
GoogleCloudAiplatformV1Artifact:
{:description string,
 :labels object,
 :schemaTitle string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED PENDING LIVE],
 :updateTime string,
 :uri string,
 :metadata object,
 :schemaVersion string}

optional:
updateMask <string> Optional. A FieldMask indicating which fields should be updated.
allowMissing <boolean> If set to true, and the Artifact is not found, a new Artifact is created."
  ([name GoogleCloudAiplatformV1Artifact]
    (projects-locations-metadataStores-artifacts-patch
      name
      GoogleCloudAiplatformV1Artifact
      nil))
  ([name GoogleCloudAiplatformV1Artifact optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Artifact})))

(defn projects-locations-metadataStores-artifacts-purge
  "Purges Artifacts.
https://cloud.google.com/vertex-ai

parent <string> Required. The metadata store to purge Artifacts from. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
GoogleCloudAiplatformV1PurgeArtifactsRequest:
{:force boolean, :filter string}"
  [parent GoogleCloudAiplatformV1PurgeArtifactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/artifacts:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1PurgeArtifactsRequest}))

(defn projects-locations-metadataStores-artifacts-create
  "Creates an Artifact associated with a MetadataStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the MetadataStore where the Artifact should be created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
GoogleCloudAiplatformV1Artifact:
{:description string,
 :labels object,
 :schemaTitle string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED PENDING LIVE],
 :updateTime string,
 :uri string,
 :metadata object,
 :schemaVersion string}

optional:
artifactId <string> The {artifact} portion of the resource name with the format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}` If not provided, the Artifact's ID will be a UUID generated by the service. Must be 4-128 characters in length. Valid characters are `/a-z-/`. Must be unique across all Artifacts in the parent MetadataStore. (Otherwise the request will fail with ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting Artifact.)"
  ([parent GoogleCloudAiplatformV1Artifact]
    (projects-locations-metadataStores-artifacts-create
      parent
      GoogleCloudAiplatformV1Artifact
      nil))
  ([parent GoogleCloudAiplatformV1Artifact optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Artifact})))

(defn projects-locations-metadataStores-artifacts-delete
  "Deletes an Artifact.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Artifact to delete. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}`

optional:
etag <string> Optional. The etag of the Artifact to delete. If this is provided, it must match the server's etag. Otherwise, the request will fail with a FAILED_PRECONDITION."
  ([name]
    (projects-locations-metadataStores-artifacts-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-artifacts-list
  "Lists Artifacts in the MetadataStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The MetadataStore whose Artifacts should be listed. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`

optional:
orderBy <string> How the list of messages is ordered. Specify the values to order by and an ordering operation. The default sorting order is ascending. To specify descending order for a field, users append a \" desc\" suffix; for example: \"foo desc, bar\". Subfields are specified with a `.` character, such as foo.bar. see https://google.aip.dev/132#ordering for more details.
filter <string> Filter specifying the boolean condition for the Artifacts to satisfy in order to be part of the result set. The syntax to define filter query is based on https://google.aip.dev/160. The supported set of filters include the following: * **Attribute filtering**: For example: `display_name = \"test\"`. Supported fields include: `name`, `display_name`, `uri`, `state`, `schema_title`, `create_time`, and `update_time`. Time fields, such as `create_time` and `update_time`, require values specified in RFC-3339 format. For example: `create_time = \"2020-11-19T11:30:00-04:00\"` * **Metadata field**: To filter on metadata fields use traversal operation as follows: `metadata..`. For example: `metadata.field_1.number_value = 10.0` In case the field name contains special characters (such as colon), one can embed it inside double quote. For example: `metadata.\"field:1\".number_value = 10.0` * **Context based filtering**: To filter Artifacts based on the contexts to which they belong, use the function operator with the full resource name `in_context()`. For example: `in_context(\"projects//locations//metadataStores//contexts/\")` Each of the above supported filter types can be combined together using logical operators (`AND` & `OR`). Maximum nested expression depth allowed is 5. For example: `display_name = \"test\" AND metadata.field1.bool_value = true`.
pageSize <integer> The maximum number of Artifacts to return. The service may return fewer. Must be in range 1-1000, inclusive. Defaults to 100."
  ([parent]
    (projects-locations-metadataStores-artifacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-artifacts-queryArtifactLineageSubgraph
  "Retrieves lineage of an Artifact represented through Artifacts and Executions connected by Event edges and returned as a LineageSubgraph.
https://cloud.google.com/vertex-ai

artifact <string> Required. The resource name of the Artifact whose Lineage needs to be retrieved as a LineageSubgraph. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/artifacts/{artifact}` The request may error with FAILED_PRECONDITION if the number of Artifacts, the number of Executions, or the number of Events that would be returned for the Context exceeds 1000.

optional:
maxHops <integer> Specifies the size of the lineage graph in terms of number of hops from the specified artifact. Negative Value: INVALID_ARGUMENT error is returned 0: Only input artifact is returned. No value: Transitive closure is performed to return the complete graph.
filter <string> Filter specifying the boolean condition for the Artifacts to satisfy in order to be part of the Lineage Subgraph. The syntax to define filter query is based on https://google.aip.dev/160. The supported set of filters include the following: * **Attribute filtering**: For example: `display_name = \"test\"` Supported fields include: `name`, `display_name`, `uri`, `state`, `schema_title`, `create_time`, and `update_time`. Time fields, such as `create_time` and `update_time`, require values specified in RFC-3339 format. For example: `create_time = \"2020-11-19T11:30:00-04:00\"` * **Metadata field**: To filter on metadata fields use traversal operation as follows: `metadata..`. For example: `metadata.field_1.number_value = 10.0` In case the field name contains special characters (such as colon), one can embed it inside double quote. For example: `metadata.\"field:1\".number_value = 10.0` Each of the above supported filter types can be combined together using logical operators (`AND` & `OR`). Maximum nested expression depth allowed is 5. For example: `display_name = \"test\" AND metadata.field1.bool_value = true`."
  ([artifact]
    (projects-locations-metadataStores-artifacts-queryArtifactLineageSubgraph
      artifact
      nil))
  ([artifact optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+artifact}:queryArtifactLineageSubgraph",
       :uri-template-args {:artifact artifact},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-artifacts-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-metadataStores-artifacts-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-artifacts-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-artifacts-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-artifacts-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-metadataStores-artifacts-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-artifacts-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-executions-patch
  "Updates a stored Execution.
https://cloud.google.com/vertex-ai

name <string> Output only. The resource name of the Execution.
GoogleCloudAiplatformV1Execution:
{:description string,
 :labels object,
 :schemaTitle string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED NEW RUNNING COMPLETE FAILED CACHED CANCELLED],
 :updateTime string,
 :metadata object,
 :schemaVersion string}

optional:
updateMask <string> Optional. A FieldMask indicating which fields should be updated.
allowMissing <boolean> If set to true, and the Execution is not found, a new Execution is created."
  ([name GoogleCloudAiplatformV1Execution]
    (projects-locations-metadataStores-executions-patch
      name
      GoogleCloudAiplatformV1Execution
      nil))
  ([name GoogleCloudAiplatformV1Execution optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Execution})))

(defn projects-locations-metadataStores-executions-addExecutionEvents
  "Adds Events to the specified Execution. An Event indicates whether an Artifact was used as an input or output for an Execution. If an Event already exists between the Execution and the Artifact, the Event is skipped.
https://cloud.google.com/vertex-ai

execution <string> Required. The resource name of the Execution that the Events connect Artifacts with. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`
GoogleCloudAiplatformV1AddExecutionEventsRequest:
{:events
 [{:type [TYPE_UNSPECIFIED INPUT OUTPUT],
   :artifact string,
   :labels object,
   :eventTime string,
   :execution string}]}"
  [execution GoogleCloudAiplatformV1AddExecutionEventsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+execution}:addExecutionEvents",
     :uri-template-args {:execution execution},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1AddExecutionEventsRequest}))

(defn projects-locations-metadataStores-executions-delete
  "Deletes an Execution.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Execution to delete. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`

optional:
etag <string> Optional. The etag of the Execution to delete. If this is provided, it must match the server's etag. Otherwise, the request will fail with a FAILED_PRECONDITION."
  ([name]
    (projects-locations-metadataStores-executions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-executions-create
  "Creates an Execution associated with a MetadataStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the MetadataStore where the Execution should be created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
GoogleCloudAiplatformV1Execution:
{:description string,
 :labels object,
 :schemaTitle string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED NEW RUNNING COMPLETE FAILED CACHED CANCELLED],
 :updateTime string,
 :metadata object,
 :schemaVersion string}

optional:
executionId <string> The {execution} portion of the resource name with the format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}` If not provided, the Execution's ID will be a UUID generated by the service. Must be 4-128 characters in length. Valid characters are `/a-z-/`. Must be unique across all Executions in the parent MetadataStore. (Otherwise the request will fail with ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting Execution.)"
  ([parent GoogleCloudAiplatformV1Execution]
    (projects-locations-metadataStores-executions-create
      parent
      GoogleCloudAiplatformV1Execution
      nil))
  ([parent GoogleCloudAiplatformV1Execution optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/executions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Execution})))

(defn projects-locations-metadataStores-executions-list
  "Lists Executions in the MetadataStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The MetadataStore whose Executions should be listed. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`

optional:
pageSize <integer> The maximum number of Executions to return. The service may return fewer. Must be in range 1-1000, inclusive. Defaults to 100.
orderBy <string> How the list of messages is ordered. Specify the values to order by and an ordering operation. The default sorting order is ascending. To specify descending order for a field, users append a \" desc\" suffix; for example: \"foo desc, bar\". Subfields are specified with a `.` character, such as foo.bar. see https://google.aip.dev/132#ordering for more details.
filter <string> Filter specifying the boolean condition for the Executions to satisfy in order to be part of the result set. The syntax to define filter query is based on https://google.aip.dev/160. Following are the supported set of filters: * **Attribute filtering**: For example: `display_name = \"test\"`. Supported fields include: `name`, `display_name`, `state`, `schema_title`, `create_time`, and `update_time`. Time fields, such as `create_time` and `update_time`, require values specified in RFC-3339 format. For example: `create_time = \"2020-11-19T11:30:00-04:00\"`. * **Metadata field**: To filter on metadata fields use traversal operation as follows: `metadata..` For example: `metadata.field_1.number_value = 10.0` In case the field name contains special characters (such as colon), one can embed it inside double quote. For example: `metadata.\"field:1\".number_value = 10.0` * **Context based filtering**: To filter Executions based on the contexts to which they belong use the function operator with the full resource name: `in_context()`. For example: `in_context(\"projects//locations//metadataStores//contexts/\")` Each of the above supported filters can be combined together using logical operators (`AND` & `OR`). Maximum nested expression depth allowed is 5. For example: `display_name = \"test\" AND metadata.field1.bool_value = true`."
  ([parent]
    (projects-locations-metadataStores-executions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/executions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-executions-purge
  "Purges Executions.
https://cloud.google.com/vertex-ai

parent <string> Required. The metadata store to purge Executions from. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
GoogleCloudAiplatformV1PurgeExecutionsRequest:
{:force boolean, :filter string}"
  [parent GoogleCloudAiplatformV1PurgeExecutionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/executions:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1PurgeExecutionsRequest}))

(defn projects-locations-metadataStores-executions-get
  "Retrieves a specific Execution.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Execution to retrieve. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-executions-queryExecutionInputsAndOutputs
  "Obtains the set of input and output Artifacts for this Execution, in the form of LineageSubgraph that also contains the Execution and connecting Events.
https://cloud.google.com/vertex-ai

execution <string> Required. The resource name of the Execution whose input and output Artifacts should be retrieved as a LineageSubgraph. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/executions/{execution}`"
  [execution]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+execution}:queryExecutionInputsAndOutputs",
     :uri-template-args {:execution execution},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-executions-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-executions-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-metadataStores-executions-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-executions-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-executions-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-executions-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-metadataStores-executions-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-contexts-get
  "Retrieves a specific Context.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Context to retrieve. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-contexts-patch
  "Updates a stored Context.
https://cloud.google.com/vertex-ai

name <string> Immutable. The resource name of the Context.
GoogleCloudAiplatformV1Context:
{:description string,
 :labels object,
 :schemaTitle string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :parentContexts [string],
 :metadata object,
 :schemaVersion string}

optional:
updateMask <string> Optional. A FieldMask indicating which fields should be updated.
allowMissing <boolean> If set to true, and the Context is not found, a new Context is created."
  ([name GoogleCloudAiplatformV1Context]
    (projects-locations-metadataStores-contexts-patch
      name
      GoogleCloudAiplatformV1Context
      nil))
  ([name GoogleCloudAiplatformV1Context optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Context})))

(defn projects-locations-metadataStores-contexts-addContextChildren
  "Adds a set of Contexts as children to a parent Context. If any of the child Contexts have already been added to the parent Context, they are simply skipped. If this call would create a cycle or cause any Context to have more than 10 parents, the request will fail with an INVALID_ARGUMENT error.
https://cloud.google.com/vertex-ai

context <string> Required. The resource name of the parent Context. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
GoogleCloudAiplatformV1AddContextChildrenRequest:
{:childContexts [string]}"
  [context GoogleCloudAiplatformV1AddContextChildrenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+context}:addContextChildren",
     :uri-template-args {:context context},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1AddContextChildrenRequest}))

(defn projects-locations-metadataStores-contexts-create
  "Creates a Context associated with a MetadataStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the MetadataStore where the Context should be created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
GoogleCloudAiplatformV1Context:
{:description string,
 :labels object,
 :schemaTitle string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :parentContexts [string],
 :metadata object,
 :schemaVersion string}

optional:
contextId <string> The {context} portion of the resource name with the format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`. If not provided, the Context's ID will be a UUID generated by the service. Must be 4-128 characters in length. Valid characters are `/a-z-/`. Must be unique across all Contexts in the parent MetadataStore. (Otherwise the request will fail with ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting Context.)"
  ([parent GoogleCloudAiplatformV1Context]
    (projects-locations-metadataStores-contexts-create
      parent
      GoogleCloudAiplatformV1Context
      nil))
  ([parent GoogleCloudAiplatformV1Context optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/contexts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Context})))

(defn projects-locations-metadataStores-contexts-queryContextLineageSubgraph
  "Retrieves Artifacts and Executions within the specified Context, connected by Event edges and returned as a LineageSubgraph.
https://cloud.google.com/vertex-ai

context <string> Required. The resource name of the Context whose Artifacts and Executions should be retrieved as a LineageSubgraph. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}` The request may error with FAILED_PRECONDITION if the number of Artifacts, the number of Executions, or the number of Events that would be returned for the Context exceeds 1000."
  [context]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+context}:queryContextLineageSubgraph",
     :uri-template-args {:context context},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-contexts-delete
  "Deletes a stored Context.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Context to delete. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`

optional:
force <boolean> The force deletion semantics is still undefined. Users should not use this field.
etag <string> Optional. The etag of the Context to delete. If this is provided, it must match the server's etag. Otherwise, the request will fail with a FAILED_PRECONDITION."
  ([name] (projects-locations-metadataStores-contexts-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-contexts-list
  "Lists Contexts on the MetadataStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The MetadataStore whose Contexts should be listed. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`

optional:
filter <string> Filter specifying the boolean condition for the Contexts to satisfy in order to be part of the result set. The syntax to define filter query is based on https://google.aip.dev/160. Following are the supported set of filters: * **Attribute filtering**: For example: `display_name = \"test\"`. Supported fields include: `name`, `display_name`, `schema_title`, `create_time`, and `update_time`. Time fields, such as `create_time` and `update_time`, require values specified in RFC-3339 format. For example: `create_time = \"2020-11-19T11:30:00-04:00\"`. * **Metadata field**: To filter on metadata fields use traversal operation as follows: `metadata..`. For example: `metadata.field_1.number_value = 10.0`. In case the field name contains special characters (such as colon), one can embed it inside double quote. For example: `metadata.\"field:1\".number_value = 10.0` * **Parent Child filtering**: To filter Contexts based on parent-child relationship use the HAS operator as follows: ``` parent_contexts: \"projects//locations//metadataStores//contexts/\" child_contexts: \"projects//locations//metadataStores//contexts/\" ``` Each of the above supported filters can be combined together using logical operators (`AND` & `OR`). Maximum nested expression depth allowed is 5. For example: `display_name = \"test\" AND metadata.field1.bool_value = true`.
pageSize <integer> The maximum number of Contexts to return. The service may return fewer. Must be in range 1-1000, inclusive. Defaults to 100.
orderBy <string> How the list of messages is ordered. Specify the values to order by and an ordering operation. The default sorting order is ascending. To specify descending order for a field, users append a \" desc\" suffix; for example: \"foo desc, bar\". Subfields are specified with a `.` character, such as foo.bar. see https://google.aip.dev/132#ordering for more details."
  ([parent]
    (projects-locations-metadataStores-contexts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/contexts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-contexts-addContextArtifactsAndExecutions
  "Adds a set of Artifacts and Executions to a Context. If any of the Artifacts or Executions have already been added to a Context, they are simply skipped.
https://cloud.google.com/vertex-ai

context <string> Required. The resource name of the Context that the Artifacts and Executions belong to. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
GoogleCloudAiplatformV1AddContextArtifactsAndExecutionsRequest:
{:artifacts [string], :executions [string]}"
  [context
   GoogleCloudAiplatformV1AddContextArtifactsAndExecutionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+context}:addContextArtifactsAndExecutions",
     :uri-template-args {:context context},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1AddContextArtifactsAndExecutionsRequest}))

(defn projects-locations-metadataStores-contexts-purge
  "Purges Contexts.
https://cloud.google.com/vertex-ai

parent <string> Required. The metadata store to purge Contexts from. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
GoogleCloudAiplatformV1PurgeContextsRequest:
{:filter string, :force boolean}"
  [parent GoogleCloudAiplatformV1PurgeContextsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/contexts:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1PurgeContextsRequest}))

(defn projects-locations-metadataStores-contexts-removeContextChildren
  "Remove a set of children contexts from a parent Context. If any of the child Contexts were NOT added to the parent Context, they are simply skipped.
https://cloud.google.com/vertex-ai

context <string> Required. The resource name of the parent Context. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/contexts/{context}`
GoogleCloudAiplatformV1RemoveContextChildrenRequest:
{:childContexts [string]}"
  [context GoogleCloudAiplatformV1RemoveContextChildrenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+context}:removeContextChildren",
     :uri-template-args {:context context},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1RemoveContextChildrenRequest}))

(defn projects-locations-metadataStores-contexts-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-contexts-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-contexts-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-metadataStores-contexts-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-contexts-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-contexts-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-metadataStores-contexts-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-metadataSchemas-get
  "Retrieves a specific MetadataSchema.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the MetadataSchema to retrieve. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/metadataSchemas/{metadataschema}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-metadataStores-metadataSchemas-list
  "Lists MetadataSchemas.
https://cloud.google.com/vertex-ai

parent <string> Required. The MetadataStore whose MetadataSchemas should be listed. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`

optional:
filter <string> A query to filter available MetadataSchemas for matching results.
pageSize <integer> The maximum number of MetadataSchemas to return. The service may return fewer. Must be in range 1-1000, inclusive. Defaults to 100."
  ([parent]
    (projects-locations-metadataStores-metadataSchemas-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/metadataSchemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-metadataStores-metadataSchemas-create
  "Creates a MetadataSchema.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the MetadataStore where the MetadataSchema should be created. Format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}`
GoogleCloudAiplatformV1MetadataSchema:
{:schemaType
 [METADATA_SCHEMA_TYPE_UNSPECIFIED
  ARTIFACT_TYPE
  EXECUTION_TYPE
  CONTEXT_TYPE],
 :name string,
 :createTime string,
 :description string,
 :schema string,
 :schemaVersion string}

optional:
metadataSchemaId <string> The {metadata_schema} portion of the resource name with the format: `projects/{project}/locations/{location}/metadataStores/{metadatastore}/metadataSchemas/{metadataschema}` If not provided, the MetadataStore's ID will be a UUID generated by the service. Must be 4-128 characters in length. Valid characters are `/a-z-/`. Must be unique across all MetadataSchemas in the parent Location. (Otherwise the request will fail with ALREADY_EXISTS, or PERMISSION_DENIED if the caller can't view the preexisting MetadataSchema.)"
  ([parent GoogleCloudAiplatformV1MetadataSchema]
    (projects-locations-metadataStores-metadataSchemas-create
      parent
      GoogleCloudAiplatformV1MetadataSchema
      nil))
  ([parent GoogleCloudAiplatformV1MetadataSchema optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/metadataSchemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1MetadataSchema})))

(defn projects-locations-deploymentResourcePools-get
  "Get a DeploymentResourcePool.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the DeploymentResourcePool to retrieve. Format: `projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deploymentResourcePools-list
  "List DeploymentResourcePools in a location.
https://cloud.google.com/vertex-ai

parent <string> Required. The parent Location which owns this collection of DeploymentResourcePools. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of DeploymentResourcePools to return. The service may return fewer than this value."
  ([parent]
    (projects-locations-deploymentResourcePools-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/deploymentResourcePools",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deploymentResourcePools-create
  "Create a DeploymentResourcePool.
https://cloud.google.com/vertex-ai

parent <string> Required. The parent location resource where this DeploymentResourcePool will be created. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1CreateDeploymentResourcePoolRequest:
{:deploymentResourcePoolId string,
 :deploymentResourcePool
 {:dedicatedResources
  {:machineSpec
   {:acceleratorCount integer,
    :machineType string,
    :acceleratorType
    [ACCELERATOR_TYPE_UNSPECIFIED
     NVIDIA_TESLA_K80
     NVIDIA_TESLA_P100
     NVIDIA_TESLA_V100
     NVIDIA_TESLA_P4
     NVIDIA_TESLA_T4
     NVIDIA_TESLA_A100
     NVIDIA_A100_80GB
     NVIDIA_L4
     NVIDIA_H100_80GB
     TPU_V2
     TPU_V3
     TPU_V4_POD
     TPU_V5_LITEPOD],
    :tpuTopology string},
   :minReplicaCount integer,
   :autoscalingMetricSpecs [{:metricName string, :target integer}],
   :maxReplicaCount integer},
  :name string,
  :createTime string,
  :disableContainerLogging boolean,
  :serviceAccount string,
  :encryptionSpec {:kmsKeyName string}}}"
  [parent GoogleCloudAiplatformV1CreateDeploymentResourcePoolRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/deploymentResourcePools",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CreateDeploymentResourcePoolRequest}))

(defn projects-locations-deploymentResourcePools-queryDeployedModels
  "List DeployedModels that have been deployed on this DeploymentResourcePool.
https://cloud.google.com/vertex-ai

deploymentResourcePool <string> Required. The name of the target DeploymentResourcePool to query. Format: `projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}`

optional:
pageSize <integer> The maximum number of DeployedModels to return. The service may return fewer than this value."
  ([deploymentResourcePool]
    (projects-locations-deploymentResourcePools-queryDeployedModels
      deploymentResourcePool
      nil))
  ([deploymentResourcePool optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+deploymentResourcePool}:queryDeployedModels",
       :uri-template-args
       {:deploymentResourcePool deploymentResourcePool},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deploymentResourcePools-delete
  "Delete a DeploymentResourcePool.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the DeploymentResourcePool to delete. Format: `projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deploymentResourcePools-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deploymentResourcePools-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deploymentResourcePools-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deploymentResourcePools-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-deploymentResourcePools-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deploymentResourcePools-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-deploymentResourcePools-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookExecutionJobs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-notebookExecutionJobs-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookExecutionJobs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookExecutionJobs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookExecutionJobs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-notebookExecutionJobs-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookExecutionJobs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-publishers-models-generateContent
  "Generate content with multimodal inputs.
https://cloud.google.com/vertex-ai

model <string> Required. The name of the publisher model requested to serve the prediction. Format: `projects/{project}/locations/{location}/publishers/*/models/*`
GoogleCloudAiplatformV1GenerateContentRequest:
{:toolConfig
 {:functionCallingConfig
  {:allowedFunctionNames [string],
   :mode [MODE_UNSPECIFIED AUTO ANY NONE]}},
 :contents
 [{:role string,
   :parts
   [{:functionResponse {:name string, :response object},
     :text string,
     :functionCall {:args object, :name string},
     :videoMetadata {:endOffset string, :startOffset string},
     :inlineData {:data string, :mimeType string},
     :fileData {:fileUri string, :mimeType string}}]}],
 :systemInstruction
 {:role string,
  :parts
  [{:functionResponse {:name string, :response object},
    :text string,
    :functionCall {:args object, :name string},
    :videoMetadata {:endOffset string, :startOffset string},
    :inlineData {:data string, :mimeType string},
    :fileData {:fileUri string, :mimeType string}}]},
 :safetySettings
 [{:category
   [HARM_CATEGORY_UNSPECIFIED
    HARM_CATEGORY_HATE_SPEECH
    HARM_CATEGORY_DANGEROUS_CONTENT
    HARM_CATEGORY_HARASSMENT
    HARM_CATEGORY_SEXUALLY_EXPLICIT],
   :method [HARM_BLOCK_METHOD_UNSPECIFIED SEVERITY PROBABILITY],
   :threshold
   [HARM_BLOCK_THRESHOLD_UNSPECIFIED
    BLOCK_LOW_AND_ABOVE
    BLOCK_MEDIUM_AND_ABOVE
    BLOCK_ONLY_HIGH
    BLOCK_NONE]}],
 :tools
 [{:retrieval
   {:disableAttribution boolean, :vertexAiSearch {:datastore string}},
   :googleSearchRetrieval object,
   :functionDeclarations
   [{:description string,
     :name string,
     :parameters
     {:description string,
      :enum [string],
      :properties object,
      :format string,
      :maxProperties string,
      :default any,
      :maximum number,
      :type
      [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
      :minLength string,
      :title string,
      :minProperties string,
      :minimum number,
      :minItems string,
      :maxLength string,
      :example any,
      :items
      {:description string,
       :enum [string],
       :properties object,
       :format string,
       :maxProperties string,
       :default any,
       :maximum number,
       :type
       [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
       :minLength string,
       :title string,
       :minProperties string,
       :minimum number,
       :minItems string,
       :maxLength string,
       :example any,
       :items GoogleCloudAiplatformV1Schema,
       :nullable boolean,
       :required [string],
       :maxItems string,
       :pattern string},
      :nullable boolean,
      :required [string],
      :maxItems string,
      :pattern string}}]}],
 :generationConfig
 {:responseMimeType string,
  :responseSchema
  {:description string,
   :enum [string],
   :properties object,
   :format string,
   :maxProperties string,
   :default any,
   :maximum number,
   :type [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
   :minLength string,
   :title string,
   :minProperties string,
   :minimum number,
   :minItems string,
   :maxLength string,
   :example any,
   :items
   {:description string,
    :enum [string],
    :properties object,
    :format string,
    :maxProperties string,
    :default any,
    :maximum number,
    :type
    [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
    :minLength string,
    :title string,
    :minProperties string,
    :minimum number,
    :minItems string,
    :maxLength string,
    :example any,
    :items
    {:description string,
     :enum [string],
     :properties object,
     :format string,
     :maxProperties string,
     :default any,
     :maximum number,
     :type
     [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
     :minLength string,
     :title string,
     :minProperties string,
     :minimum number,
     :minItems string,
     :maxLength string,
     :example any,
     :items GoogleCloudAiplatformV1Schema,
     :nullable boolean,
     :required [string],
     :maxItems string,
     :pattern string},
    :nullable boolean,
    :required [string],
    :maxItems string,
    :pattern string},
   :nullable boolean,
   :required [string],
   :maxItems string,
   :pattern string},
  :presencePenalty number,
  :stopSequences [string],
  :topP number,
  :maxOutputTokens integer,
  :frequencyPenalty number,
  :topK number,
  :candidateCount integer,
  :temperature number}}"
  [model GoogleCloudAiplatformV1GenerateContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+model}:generateContent",
     :uri-template-args {:model model},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1GenerateContentRequest}))

(defn projects-locations-publishers-models-serverStreamingPredict
  "Perform a server-side streaming online prediction request for Vertex LLM streaming.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1StreamingPredictRequest:
{:inputs
 [{:uintVal [integer],
   :floatVal [number],
   :dtype
   [DATA_TYPE_UNSPECIFIED
    BOOL
    STRING
    FLOAT
    DOUBLE
    INT8
    INT16
    INT32
    INT64
    UINT8
    UINT16
    UINT32
    UINT64],
   :uint64Val [string],
   :boolVal [boolean],
   :listVal
   [{:uintVal [integer],
     :floatVal [number],
     :dtype
     [DATA_TYPE_UNSPECIFIED
      BOOL
      STRING
      FLOAT
      DOUBLE
      INT8
      INT16
      INT32
      INT64
      UINT8
      UINT16
      UINT32
      UINT64],
     :uint64Val [string],
     :boolVal [boolean],
     :listVal
     [{:uintVal [integer],
       :floatVal [number],
       :dtype
       [DATA_TYPE_UNSPECIFIED
        BOOL
        STRING
        FLOAT
        DOUBLE
        INT8
        INT16
        INT32
        INT64
        UINT8
        UINT16
        UINT32
        UINT64],
       :uint64Val [string],
       :boolVal [boolean],
       :listVal
       [{:uintVal [integer],
         :floatVal [number],
         :dtype
         [DATA_TYPE_UNSPECIFIED
          BOOL
          STRING
          FLOAT
          DOUBLE
          INT8
          INT16
          INT32
          INT64
          UINT8
          UINT16
          UINT32
          UINT64],
         :uint64Val [string],
         :boolVal [boolean],
         :listVal [GoogleCloudAiplatformV1Tensor],
         :stringVal [string],
         :int64Val [string],
         :tensorVal string,
         :shape [string],
         :bytesVal [string],
         :intVal [integer],
         :doubleVal [number],
         :structVal object}],
       :stringVal [string],
       :int64Val [string],
       :tensorVal string,
       :shape [string],
       :bytesVal [string],
       :intVal [integer],
       :doubleVal [number],
       :structVal object}],
     :stringVal [string],
     :int64Val [string],
     :tensorVal string,
     :shape [string],
     :bytesVal [string],
     :intVal [integer],
     :doubleVal [number],
     :structVal object}],
   :stringVal [string],
   :int64Val [string],
   :tensorVal string,
   :shape [string],
   :bytesVal [string],
   :intVal [integer],
   :doubleVal [number],
   :structVal object}],
 :parameters
 {:uintVal [integer],
  :floatVal [number],
  :dtype
  [DATA_TYPE_UNSPECIFIED
   BOOL
   STRING
   FLOAT
   DOUBLE
   INT8
   INT16
   INT32
   INT64
   UINT8
   UINT16
   UINT32
   UINT64],
  :uint64Val [string],
  :boolVal [boolean],
  :listVal
  [{:uintVal [integer],
    :floatVal [number],
    :dtype
    [DATA_TYPE_UNSPECIFIED
     BOOL
     STRING
     FLOAT
     DOUBLE
     INT8
     INT16
     INT32
     INT64
     UINT8
     UINT16
     UINT32
     UINT64],
    :uint64Val [string],
    :boolVal [boolean],
    :listVal
    [{:uintVal [integer],
      :floatVal [number],
      :dtype
      [DATA_TYPE_UNSPECIFIED
       BOOL
       STRING
       FLOAT
       DOUBLE
       INT8
       INT16
       INT32
       INT64
       UINT8
       UINT16
       UINT32
       UINT64],
      :uint64Val [string],
      :boolVal [boolean],
      :listVal
      [{:uintVal [integer],
        :floatVal [number],
        :dtype
        [DATA_TYPE_UNSPECIFIED
         BOOL
         STRING
         FLOAT
         DOUBLE
         INT8
         INT16
         INT32
         INT64
         UINT8
         UINT16
         UINT32
         UINT64],
        :uint64Val [string],
        :boolVal [boolean],
        :listVal [GoogleCloudAiplatformV1Tensor],
        :stringVal [string],
        :int64Val [string],
        :tensorVal string,
        :shape [string],
        :bytesVal [string],
        :intVal [integer],
        :doubleVal [number],
        :structVal object}],
      :stringVal [string],
      :int64Val [string],
      :tensorVal string,
      :shape [string],
      :bytesVal [string],
      :intVal [integer],
      :doubleVal [number],
      :structVal object}],
    :stringVal [string],
    :int64Val [string],
    :tensorVal string,
    :shape [string],
    :bytesVal [string],
    :intVal [integer],
    :doubleVal [number],
    :structVal object}],
  :stringVal [string],
  :int64Val [string],
  :tensorVal string,
  :shape [string],
  :bytesVal [string],
  :intVal [integer],
  :doubleVal [number],
  :structVal object}}"
  [endpoint GoogleCloudAiplatformV1StreamingPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:serverStreamingPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1StreamingPredictRequest}))

(defn projects-locations-publishers-models-rawPredict
  "Perform an online prediction with an arbitrary HTTP payload. The response includes the following HTTP headers: * `X-Vertex-AI-Endpoint-Id`: ID of the Endpoint that served this prediction. * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's DeployedModel that served this prediction.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1RawPredictRequest:
{:httpBody {:extensions [object], :contentType string, :data string}}"
  [endpoint GoogleCloudAiplatformV1RawPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:rawPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1RawPredictRequest}))

(defn projects-locations-publishers-models-countTokens
  "Perform a token counting.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to perform token counting. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1CountTokensRequest:
{:contents
 [{:role string,
   :parts
   [{:functionResponse {:name string, :response object},
     :text string,
     :functionCall {:args object, :name string},
     :videoMetadata {:endOffset string, :startOffset string},
     :inlineData {:data string, :mimeType string},
     :fileData {:fileUri string, :mimeType string}}]}],
 :instances [any],
 :model string}"
  [endpoint GoogleCloudAiplatformV1CountTokensRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:countTokens",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CountTokensRequest}))

(defn projects-locations-publishers-models-streamGenerateContent
  "Generate content with multimodal inputs with streaming support.
https://cloud.google.com/vertex-ai

model <string> Required. The name of the publisher model requested to serve the prediction. Format: `projects/{project}/locations/{location}/publishers/*/models/*`
GoogleCloudAiplatformV1GenerateContentRequest:
{:toolConfig
 {:functionCallingConfig
  {:allowedFunctionNames [string],
   :mode [MODE_UNSPECIFIED AUTO ANY NONE]}},
 :contents
 [{:role string,
   :parts
   [{:functionResponse {:name string, :response object},
     :text string,
     :functionCall {:args object, :name string},
     :videoMetadata {:endOffset string, :startOffset string},
     :inlineData {:data string, :mimeType string},
     :fileData {:fileUri string, :mimeType string}}]}],
 :systemInstruction
 {:role string,
  :parts
  [{:functionResponse {:name string, :response object},
    :text string,
    :functionCall {:args object, :name string},
    :videoMetadata {:endOffset string, :startOffset string},
    :inlineData {:data string, :mimeType string},
    :fileData {:fileUri string, :mimeType string}}]},
 :safetySettings
 [{:category
   [HARM_CATEGORY_UNSPECIFIED
    HARM_CATEGORY_HATE_SPEECH
    HARM_CATEGORY_DANGEROUS_CONTENT
    HARM_CATEGORY_HARASSMENT
    HARM_CATEGORY_SEXUALLY_EXPLICIT],
   :method [HARM_BLOCK_METHOD_UNSPECIFIED SEVERITY PROBABILITY],
   :threshold
   [HARM_BLOCK_THRESHOLD_UNSPECIFIED
    BLOCK_LOW_AND_ABOVE
    BLOCK_MEDIUM_AND_ABOVE
    BLOCK_ONLY_HIGH
    BLOCK_NONE]}],
 :tools
 [{:retrieval
   {:disableAttribution boolean, :vertexAiSearch {:datastore string}},
   :googleSearchRetrieval object,
   :functionDeclarations
   [{:description string,
     :name string,
     :parameters
     {:description string,
      :enum [string],
      :properties object,
      :format string,
      :maxProperties string,
      :default any,
      :maximum number,
      :type
      [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
      :minLength string,
      :title string,
      :minProperties string,
      :minimum number,
      :minItems string,
      :maxLength string,
      :example any,
      :items
      {:description string,
       :enum [string],
       :properties object,
       :format string,
       :maxProperties string,
       :default any,
       :maximum number,
       :type
       [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
       :minLength string,
       :title string,
       :minProperties string,
       :minimum number,
       :minItems string,
       :maxLength string,
       :example any,
       :items GoogleCloudAiplatformV1Schema,
       :nullable boolean,
       :required [string],
       :maxItems string,
       :pattern string},
      :nullable boolean,
      :required [string],
      :maxItems string,
      :pattern string}}]}],
 :generationConfig
 {:responseMimeType string,
  :responseSchema
  {:description string,
   :enum [string],
   :properties object,
   :format string,
   :maxProperties string,
   :default any,
   :maximum number,
   :type [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
   :minLength string,
   :title string,
   :minProperties string,
   :minimum number,
   :minItems string,
   :maxLength string,
   :example any,
   :items
   {:description string,
    :enum [string],
    :properties object,
    :format string,
    :maxProperties string,
    :default any,
    :maximum number,
    :type
    [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
    :minLength string,
    :title string,
    :minProperties string,
    :minimum number,
    :minItems string,
    :maxLength string,
    :example any,
    :items
    {:description string,
     :enum [string],
     :properties object,
     :format string,
     :maxProperties string,
     :default any,
     :maximum number,
     :type
     [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
     :minLength string,
     :title string,
     :minProperties string,
     :minimum number,
     :minItems string,
     :maxLength string,
     :example any,
     :items GoogleCloudAiplatformV1Schema,
     :nullable boolean,
     :required [string],
     :maxItems string,
     :pattern string},
    :nullable boolean,
    :required [string],
    :maxItems string,
    :pattern string},
   :nullable boolean,
   :required [string],
   :maxItems string,
   :pattern string},
  :presencePenalty number,
  :stopSequences [string],
  :topP number,
  :maxOutputTokens integer,
  :frequencyPenalty number,
  :topK number,
  :candidateCount integer,
  :temperature number}}"
  [model GoogleCloudAiplatformV1GenerateContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+model}:streamGenerateContent",
     :uri-template-args {:model model},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1GenerateContentRequest}))

(defn projects-locations-publishers-models-predict
  "Perform an online prediction.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1PredictRequest:
{:parameters any, :instances [any]}"
  [endpoint GoogleCloudAiplatformV1PredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:predict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1PredictRequest}))

(defn projects-locations-publishers-models-streamRawPredict
  "Perform a streaming online prediction with an arbitrary HTTP payload.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1StreamRawPredictRequest:
{:httpBody {:extensions [object], :contentType string, :data string}}"
  [endpoint GoogleCloudAiplatformV1StreamRawPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:streamRawPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1StreamRawPredictRequest}))

(defn projects-locations-publishers-models-computeTokens
  "Return a list of tokens based on the input text.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to get lists of tokens and token ids.
GoogleCloudAiplatformV1ComputeTokensRequest:
{:instances [any]}"
  [endpoint GoogleCloudAiplatformV1ComputeTokensRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:computeTokens",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ComputeTokensRequest}))

(defn projects-locations-hyperparameterTuningJobs-list
  "Lists HyperparameterTuningJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the HyperparameterTuningJobs from. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter. Supported fields: * `display_name` supports `=`, `!=` comparisons, and `:` wildcard. * `state` supports `=`, `!=` comparisons. * `create_time` supports `=`, `!=`,`<`, `<=`,`>`, `>=` comparisons. `create_time` must be in RFC 3339 format. * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* - key existence Some examples of using the filter are: * `state=\"JOB_STATE_SUCCEEDED\" AND display_name:\"my_job_*\"` * `state!=\"JOB_STATE_FAILED\" OR display_name=\"my_job\"` * `NOT display_name=\"my_job\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `labels.keyA=valueA` * `labels.keyB:*`
readMask <string> Mask specifying which fields to read."
  ([parent]
    (projects-locations-hyperparameterTuningJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/hyperparameterTuningJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-hyperparameterTuningJobs-delete
  "Deletes a HyperparameterTuningJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the HyperparameterTuningJob resource to be deleted. Format: `projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-hyperparameterTuningJobs-cancel
  "Cancels a HyperparameterTuningJob. Starts asynchronous cancellation on the HyperparameterTuningJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetHyperparameterTuningJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the HyperparameterTuningJob is not deleted; instead it becomes a job with a HyperparameterTuningJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and HyperparameterTuningJob.state is set to `CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the HyperparameterTuningJob to cancel. Format: `projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`
GoogleCloudAiplatformV1CancelHyperparameterTuningJobRequest:
object"
  [name GoogleCloudAiplatformV1CancelHyperparameterTuningJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1CancelHyperparameterTuningJobRequest}))

(defn projects-locations-hyperparameterTuningJobs-create
  "Creates a HyperparameterTuningJob
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the HyperparameterTuningJob in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1HyperparameterTuningJob:
{:labels object,
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :name string,
 :endTime string,
 :trialJobSpec
 {:serviceAccount string,
  :protectedArtifactLocationId string,
  :enableWebAccess boolean,
  :scheduling
  {:timeout string,
   :disableRetries boolean,
   :restartJobOnWorkerRestart boolean},
  :enableDashboardAccess boolean,
  :experimentRun string,
  :persistentResourceId string,
  :tensorboard string,
  :workerPoolSpecs
  [{:pythonPackageSpec
    {:executorImageUri string,
     :pythonModule string,
     :args [string],
     :packageUris [string],
     :env [{:value string, :name string}]},
    :nfsMounts [{:server string, :mountPoint string, :path string}],
    :replicaCount string,
    :diskSpec {:bootDiskType string, :bootDiskSizeGb integer},
    :containerSpec
    {:command [string],
     :args [string],
     :env [{:value string, :name string}],
     :imageUri string},
    :machineSpec
    {:acceleratorCount integer,
     :machineType string,
     :acceleratorType
     [ACCELERATOR_TYPE_UNSPECIFIED
      NVIDIA_TESLA_K80
      NVIDIA_TESLA_P100
      NVIDIA_TESLA_V100
      NVIDIA_TESLA_P4
      NVIDIA_TESLA_T4
      NVIDIA_TESLA_A100
      NVIDIA_A100_80GB
      NVIDIA_L4
      NVIDIA_H100_80GB
      TPU_V2
      TPU_V3
      TPU_V4_POD
      TPU_V5_LITEPOD],
     :tpuTopology string}}],
  :reservedIpRanges [string],
  :baseOutputDirectory {:outputUriPrefix string},
  :experiment string,
  :models [string],
  :network string},
 :createTime string,
 :maxFailedTrialCount integer,
 :maxTrialCount integer,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :studySpec
 {:algorithm [ALGORITHM_UNSPECIFIED GRID_SEARCH RANDOM_SEARCH],
  :measurementSelectionType
  [MEASUREMENT_SELECTION_TYPE_UNSPECIFIED
   LAST_MEASUREMENT
   BEST_MEASUREMENT],
  :observationNoise [OBSERVATION_NOISE_UNSPECIFIED LOW HIGH],
  :studyStoppingConfig
  {:maxNumTrials integer,
   :maxDurationNoProgress string,
   :minNumTrials integer,
   :maximumRuntimeConstraint {:endTime string, :maxDuration string},
   :shouldStopAsap boolean,
   :maxNumTrialsNoProgress integer,
   :minimumRuntimeConstraint {:endTime string, :maxDuration string}},
  :decayCurveStoppingSpec {:useElapsedDuration boolean},
  :medianAutomatedStoppingSpec {:useElapsedDuration boolean},
  :parameters
  [{:discreteValueSpec {:defaultValue number, :values [number]},
    :categoricalValueSpec {:defaultValue string, :values [string]},
    :parameterId string,
    :conditionalParameterSpecs
    [{:parentCategoricalValues {:values [string]},
      :parentIntValues {:values [string]},
      :parentDiscreteValues {:values [number]},
      :parameterSpec
      {:discreteValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecDiscreteValueSpec,
       :categoricalValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecCategoricalValueSpec,
       :parameterId string,
       :conditionalParameterSpecs
       [GoogleCloudAiplatformV1StudySpecParameterSpecConditionalParameterSpec],
       :doubleValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecDoubleValueSpec,
       :scaleType
       [SCALE_TYPE_UNSPECIFIED
        UNIT_LINEAR_SCALE
        UNIT_LOG_SCALE
        UNIT_REVERSE_LOG_SCALE],
       :integerValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecIntegerValueSpec}}],
    :doubleValueSpec
    {:defaultValue number, :minValue number, :maxValue number},
    :scaleType
    [SCALE_TYPE_UNSPECIFIED
     UNIT_LINEAR_SCALE
     UNIT_LOG_SCALE
     UNIT_REVERSE_LOG_SCALE],
    :integerValueSpec
    {:maxValue string, :minValue string, :defaultValue string}}],
  :convexAutomatedStoppingSpec
  {:learningRateParameterName string,
   :minStepCount string,
   :updateAllStoppedTrials boolean,
   :useElapsedDuration boolean,
   :minMeasurementCount string,
   :maxStepCount string},
  :metrics
  [{:safetyConfig
    {:safetyThreshold number, :desiredMinSafeTrialsFraction number},
    :goal [GOAL_TYPE_UNSPECIFIED MAXIMIZE MINIMIZE],
    :metricId string}]},
 :updateTime string,
 :error {:message string, :code integer, :details [object]},
 :trials
 [{:clientId string,
   :customJob string,
   :startTime string,
   :measurements
   [{:metrics [{:value number, :metricId string}],
     :elapsedDuration string,
     :stepCount string}],
   :name string,
   :endTime string,
   :state
   [STATE_UNSPECIFIED REQUESTED ACTIVE STOPPING SUCCEEDED INFEASIBLE],
   :id string,
   :finalMeasurement
   {:metrics [{:value number, :metricId string}],
    :elapsedDuration string,
    :stepCount string},
   :infeasibleReason string,
   :webAccessUris object,
   :parameters [{:parameterId string, :value any}]}],
 :parallelTrialCount integer}"
  [parent GoogleCloudAiplatformV1HyperparameterTuningJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/hyperparameterTuningJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1HyperparameterTuningJob}))

(defn projects-locations-hyperparameterTuningJobs-get
  "Gets a HyperparameterTuningJob
https://cloud.google.com/vertex-ai

name <string> Required. The name of the HyperparameterTuningJob resource. Format: `projects/{project}/locations/{location}/hyperparameterTuningJobs/{hyperparameter_tuning_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-hyperparameterTuningJobs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-hyperparameterTuningJobs-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-hyperparameterTuningJobs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-hyperparameterTuningJobs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-hyperparameterTuningJobs-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-hyperparameterTuningJobs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-hyperparameterTuningJobs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-migratableResources-search
  "Searches all of the resources in automl.googleapis.com, datalabeling.googleapis.com and ml.googleapis.com that can be migrated to Vertex AI's given location.
https://cloud.google.com/vertex-ai

parent <string> Required. The location that the migratable resources should be searched from. It's the Vertex AI location that the resources can be migrated to, not the resources' original location. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1SearchMigratableResourcesRequest:
{:pageToken string, :pageSize integer, :filter string}"
  [parent GoogleCloudAiplatformV1SearchMigratableResourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/migratableResources:search",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1SearchMigratableResourcesRequest}))

(defn projects-locations-migratableResources-batchMigrate
  "Batch migrates resources from ml.googleapis.com, automl.googleapis.com, and datalabeling.googleapis.com to Vertex AI.
https://cloud.google.com/vertex-ai

parent <string> Required. The location of the migrated resource will live in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1BatchMigrateResourcesRequest:
{:migrateResourceRequests
 [{:migrateMlEngineModelVersionConfig
   {:endpoint string, :modelDisplayName string, :modelVersion string},
   :migrateAutomlDatasetConfig
   {:datasetDisplayName string, :dataset string},
   :migrateDataLabelingDatasetConfig
   {:datasetDisplayName string,
    :dataset string,
    :migrateDataLabelingAnnotatedDatasetConfigs
    [{:annotatedDataset string}]},
   :migrateAutomlModelConfig
   {:model string, :modelDisplayName string}}]}"
  [parent GoogleCloudAiplatformV1BatchMigrateResourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/migratableResources:batchMigrate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1BatchMigrateResourcesRequest}))

(defn projects-locations-migratableResources-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-migratableResources-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-migratableResources-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-migratableResources-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-migratableResources-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-migratableResources-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-migratableResources-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-get
  "Gets details of a single FeatureGroup.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the FeatureGroup resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureGroups-list
  "Lists FeatureGroups in a given project and location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list FeatureGroups. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of FeatureGroups to return. The service may return fewer than this value. If unspecified, at most 100 FeatureGroups will be returned. The maximum value is 100; any value greater than 100 will be coerced to 100.
filter <string> Lists the FeatureGroups that match the filter expression. The following fields are supported: * `create_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `update_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `labels`: Supports key-value equality and key presence. Examples: * `create_time > \"2020-01-01\" OR update_time > \"2020-01-01\"` FeatureGroups created or updated after 2020-01-01. * `labels.env = \"prod\"` FeatureGroups with label \"env\" set to \"prod\".
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported Fields: * `create_time` * `update_time`"
  ([parent] (projects-locations-featureGroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featureGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-patch
  "Updates the parameters of a single FeatureGroup.
https://cloud.google.com/vertex-ai

name <string> Identifier. Name of the FeatureGroup. Format: `projects/{project}/locations/{location}/featureGroups/{featureGroup}`
GoogleCloudAiplatformV1FeatureGroup:
{:bigQuery
 {:bigQuerySource {:inputUri string}, :entityIdColumns [string]},
 :labels object,
 :description string,
 :createTime string,
 :updateTime string,
 :name string,
 :etag string}

optional:
updateMask <string> Field mask is used to specify the fields to be overwritten in the FeatureGroup resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. Updatable fields: * `labels`"
  ([name GoogleCloudAiplatformV1FeatureGroup]
    (projects-locations-featureGroups-patch
      name
      GoogleCloudAiplatformV1FeatureGroup
      nil))
  ([name GoogleCloudAiplatformV1FeatureGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1FeatureGroup})))

(defn projects-locations-featureGroups-delete
  "Deletes a single FeatureGroup.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the FeatureGroup to be deleted. Format: `projects/{project}/locations/{location}/featureGroups/{feature_group}`

optional:
force <boolean> If set to true, any Features under this FeatureGroup will also be deleted. (Otherwise, the request will only work if the FeatureGroup has no Features.)"
  ([name] (projects-locations-featureGroups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-create
  "Creates a new FeatureGroup in a given project and location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create FeatureGroups. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1FeatureGroup:
{:bigQuery
 {:bigQuerySource {:inputUri string}, :entityIdColumns [string]},
 :labels object,
 :description string,
 :createTime string,
 :updateTime string,
 :name string,
 :etag string}

optional:
featureGroupId <string> Required. The ID to use for this FeatureGroup, which will become the final component of the FeatureGroup's resource name. This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first character cannot be a number. The value must be unique within the project and location."
  ([parent GoogleCloudAiplatformV1FeatureGroup]
    (projects-locations-featureGroups-create
      parent
      GoogleCloudAiplatformV1FeatureGroup
      nil))
  ([parent GoogleCloudAiplatformV1FeatureGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featureGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1FeatureGroup})))

(defn projects-locations-featureGroups-features-patch
  "Updates the parameters of a single Feature.
https://cloud.google.com/vertex-ai

name <string> Immutable. Name of the Feature. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}/features/{feature}` `projects/{project}/locations/{location}/featureGroups/{feature_group}/features/{feature}` The last part feature is assigned by the client. The feature can be up to 64 characters long and can consist only of ASCII Latin letters A-Z and a-z, underscore(_), and ASCII digits 0-9 starting with a letter. The value will be unique given an entity type.
GoogleCloudAiplatformV1Feature:
{:description string,
 :labels object,
 :disableMonitoring boolean,
 :valueType
 [VALUE_TYPE_UNSPECIFIED
  BOOL
  BOOL_ARRAY
  DOUBLE
  DOUBLE_ARRAY
  INT64
  INT64_ARRAY
  STRING
  STRING_ARRAY
  BYTES
  STRUCT],
 :versionColumnName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :pointOfContact string,
 :monitoringStatsAnomalies
 [{:featureStatsAnomaly
   {:startTime string,
    :score number,
    :statsUri string,
    :anomalyUri string,
    :distributionDeviation number,
    :endTime string,
    :anomalyDetectionThreshold number},
   :objective
   [OBJECTIVE_UNSPECIFIED IMPORT_FEATURE_ANALYSIS SNAPSHOT_ANALYSIS]}]}

optional:
updateMask <string> Field mask is used to specify the fields to be overwritten in the Features resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. Updatable fields: * `description` * `labels` * `disable_monitoring` (Not supported for FeatureRegistry Feature)"
  ([name GoogleCloudAiplatformV1Feature]
    (projects-locations-featureGroups-features-patch
      name
      GoogleCloudAiplatformV1Feature
      nil))
  ([name GoogleCloudAiplatformV1Feature optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Feature})))

(defn projects-locations-featureGroups-features-create
  "Creates a new Feature in a given FeatureGroup.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the EntityType or FeatureGroup to create a Feature. Format for entity_type as parent: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}` Format for feature_group as parent: `projects/{project}/locations/{location}/featureGroups/{feature_group}`
GoogleCloudAiplatformV1Feature:
{:description string,
 :labels object,
 :disableMonitoring boolean,
 :valueType
 [VALUE_TYPE_UNSPECIFIED
  BOOL
  BOOL_ARRAY
  DOUBLE
  DOUBLE_ARRAY
  INT64
  INT64_ARRAY
  STRING
  STRING_ARRAY
  BYTES
  STRUCT],
 :versionColumnName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :pointOfContact string,
 :monitoringStatsAnomalies
 [{:featureStatsAnomaly
   {:startTime string,
    :score number,
    :statsUri string,
    :anomalyUri string,
    :distributionDeviation number,
    :endTime string,
    :anomalyDetectionThreshold number},
   :objective
   [OBJECTIVE_UNSPECIFIED IMPORT_FEATURE_ANALYSIS SNAPSHOT_ANALYSIS]}]}

optional:
featureId <string> Required. The ID to use for the Feature, which will become the final component of the Feature's resource name. This value may be up to 128 characters, and valid characters are `[a-z0-9_]`. The first character cannot be a number. The value must be unique within an EntityType/FeatureGroup."
  ([parent GoogleCloudAiplatformV1Feature]
    (projects-locations-featureGroups-features-create
      parent
      GoogleCloudAiplatformV1Feature
      nil))
  ([parent GoogleCloudAiplatformV1Feature optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/features",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Feature})))

(defn projects-locations-featureGroups-features-get
  "Gets details of a single Feature.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Feature resource. Format for entity_type as parent: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}` Format for feature_group as parent: `projects/{project}/locations/{location}/featureGroups/{feature_group}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureGroups-features-list
  "Lists Features in a given FeatureGroup.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list Features. Format for entity_type as parent: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}` Format for feature_group as parent: `projects/{project}/locations/{location}/featureGroups/{feature_group}`

optional:
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `feature_id` * `value_type` (Not supported for FeatureRegistry Feature) * `create_time` * `update_time`
filter <string> Lists the Features that match the filter expression. The following filters are supported: * `value_type`: Supports = and != comparisons. * `create_time`: Supports =, !=, <, >, >=, and <= comparisons. Values must be in RFC 3339 format. * `update_time`: Supports =, !=, <, >, >=, and <= comparisons. Values must be in RFC 3339 format. * `labels`: Supports key-value equality as well as key presence. Examples: * `value_type = DOUBLE` --> Features whose type is DOUBLE. * `create_time > \\\"2020-01-31T15:30:00.000000Z\\\" OR update_time > \\\"2020-01-31T15:30:00.000000Z\\\"` --> EntityTypes created or updated after 2020-01-31T15:30:00.000000Z. * `labels.active = yes AND labels.env = prod` --> Features having both (active: yes) and (env: prod) labels. * `labels.env: *` --> Any Feature which has a label with 'env' as the key.
pageSize <integer> The maximum number of Features to return. The service may return fewer than this value. If unspecified, at most 1000 Features will be returned. The maximum value is 1000; any value greater than 1000 will be coerced to 1000.
latestStatsCount <integer> Only applicable for Vertex AI Feature Store (Legacy). If set, return the most recent ListFeaturesRequest.latest_stats_count of stats for each Feature in response. Valid value is [0, 10]. If number of stats exists < ListFeaturesRequest.latest_stats_count, return all existing stats.
readMask <string> Mask specifying which fields to read."
  ([parent]
    (projects-locations-featureGroups-features-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/features",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-features-delete
  "Deletes a single Feature.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Features to be deleted. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}/features/{feature}` `projects/{project}/locations/{location}/featureGroups/{feature_group}/features/{feature}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureGroups-features-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureGroups-features-operations-listWait
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-featureGroups-features-operations-listWait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-features-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureGroups-features-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-featureGroups-features-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-operations-listWait
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-featureGroups-operations-listWait name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-featureGroups-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureGroups-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureGroups-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-endpoints-streamGenerateContent
  "Generate content with multimodal inputs with streaming support.
https://cloud.google.com/vertex-ai

model <string> Required. The name of the publisher model requested to serve the prediction. Format: `projects/{project}/locations/{location}/publishers/*/models/*`
GoogleCloudAiplatformV1GenerateContentRequest:
{:toolConfig
 {:functionCallingConfig
  {:allowedFunctionNames [string],
   :mode [MODE_UNSPECIFIED AUTO ANY NONE]}},
 :contents
 [{:role string,
   :parts
   [{:functionResponse {:name string, :response object},
     :text string,
     :functionCall {:args object, :name string},
     :videoMetadata {:endOffset string, :startOffset string},
     :inlineData {:data string, :mimeType string},
     :fileData {:fileUri string, :mimeType string}}]}],
 :systemInstruction
 {:role string,
  :parts
  [{:functionResponse {:name string, :response object},
    :text string,
    :functionCall {:args object, :name string},
    :videoMetadata {:endOffset string, :startOffset string},
    :inlineData {:data string, :mimeType string},
    :fileData {:fileUri string, :mimeType string}}]},
 :safetySettings
 [{:category
   [HARM_CATEGORY_UNSPECIFIED
    HARM_CATEGORY_HATE_SPEECH
    HARM_CATEGORY_DANGEROUS_CONTENT
    HARM_CATEGORY_HARASSMENT
    HARM_CATEGORY_SEXUALLY_EXPLICIT],
   :method [HARM_BLOCK_METHOD_UNSPECIFIED SEVERITY PROBABILITY],
   :threshold
   [HARM_BLOCK_THRESHOLD_UNSPECIFIED
    BLOCK_LOW_AND_ABOVE
    BLOCK_MEDIUM_AND_ABOVE
    BLOCK_ONLY_HIGH
    BLOCK_NONE]}],
 :tools
 [{:retrieval
   {:disableAttribution boolean, :vertexAiSearch {:datastore string}},
   :googleSearchRetrieval object,
   :functionDeclarations
   [{:description string,
     :name string,
     :parameters
     {:description string,
      :enum [string],
      :properties object,
      :format string,
      :maxProperties string,
      :default any,
      :maximum number,
      :type
      [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
      :minLength string,
      :title string,
      :minProperties string,
      :minimum number,
      :minItems string,
      :maxLength string,
      :example any,
      :items
      {:description string,
       :enum [string],
       :properties object,
       :format string,
       :maxProperties string,
       :default any,
       :maximum number,
       :type
       [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
       :minLength string,
       :title string,
       :minProperties string,
       :minimum number,
       :minItems string,
       :maxLength string,
       :example any,
       :items GoogleCloudAiplatformV1Schema,
       :nullable boolean,
       :required [string],
       :maxItems string,
       :pattern string},
      :nullable boolean,
      :required [string],
      :maxItems string,
      :pattern string}}]}],
 :generationConfig
 {:responseMimeType string,
  :responseSchema
  {:description string,
   :enum [string],
   :properties object,
   :format string,
   :maxProperties string,
   :default any,
   :maximum number,
   :type [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
   :minLength string,
   :title string,
   :minProperties string,
   :minimum number,
   :minItems string,
   :maxLength string,
   :example any,
   :items
   {:description string,
    :enum [string],
    :properties object,
    :format string,
    :maxProperties string,
    :default any,
    :maximum number,
    :type
    [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
    :minLength string,
    :title string,
    :minProperties string,
    :minimum number,
    :minItems string,
    :maxLength string,
    :example any,
    :items
    {:description string,
     :enum [string],
     :properties object,
     :format string,
     :maxProperties string,
     :default any,
     :maximum number,
     :type
     [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
     :minLength string,
     :title string,
     :minProperties string,
     :minimum number,
     :minItems string,
     :maxLength string,
     :example any,
     :items GoogleCloudAiplatformV1Schema,
     :nullable boolean,
     :required [string],
     :maxItems string,
     :pattern string},
    :nullable boolean,
    :required [string],
    :maxItems string,
    :pattern string},
   :nullable boolean,
   :required [string],
   :maxItems string,
   :pattern string},
  :presencePenalty number,
  :stopSequences [string],
  :topP number,
  :maxOutputTokens integer,
  :frequencyPenalty number,
  :topK number,
  :candidateCount integer,
  :temperature number}}"
  [model GoogleCloudAiplatformV1GenerateContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+model}:streamGenerateContent",
     :uri-template-args {:model model},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1GenerateContentRequest}))

(defn projects-locations-endpoints-mutateDeployedModel
  "Updates an existing deployed model. Updatable fields include `min_replica_count`, `max_replica_count`, `autoscaling_metric_specs`, `disable_container_logging` (v1 only), and `enable_container_logging` (v1beta1 only).
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint resource into which to mutate a DeployedModel. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1MutateDeployedModelRequest:
{:updateMask string,
 :deployedModel
 {:serviceAccount string,
  :modelVersionId string,
  :disableContainerLogging boolean,
  :automaticResources
  {:minReplicaCount integer, :maxReplicaCount integer},
  :disableExplanations boolean,
  :displayName string,
  :explanationSpec
  {:metadata
   {:outputs object,
    :inputs object,
    :latentSpaceSource string,
    :featureAttributionsSchemaUri string},
   :parameters
   {:outputIndices [any],
    :examples
    {:exampleGcsSource GoogleCloudAiplatformV1ExamplesExampleGcsSource,
     :presets GoogleCloudAiplatformV1Presets,
     :nearestNeighborSearchConfig any,
     :neighborCount integer},
    :xraiAttribution
    {:blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer,
     :smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig},
    :topK integer,
    :sampledShapleyAttribution {:pathCount integer},
    :integratedGradientsAttribution
    {:smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig,
     :blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer}}},
  :dedicatedResources
  {:machineSpec
   {:acceleratorCount integer,
    :machineType string,
    :acceleratorType
    [ACCELERATOR_TYPE_UNSPECIFIED
     NVIDIA_TESLA_K80
     NVIDIA_TESLA_P100
     NVIDIA_TESLA_V100
     NVIDIA_TESLA_P4
     NVIDIA_TESLA_T4
     NVIDIA_TESLA_A100
     NVIDIA_A100_80GB
     NVIDIA_L4
     NVIDIA_H100_80GB
     TPU_V2
     TPU_V3
     TPU_V4_POD
     TPU_V5_LITEPOD],
    :tpuTopology string},
   :minReplicaCount integer,
   :autoscalingMetricSpecs [{:metricName string, :target integer}],
   :maxReplicaCount integer},
  :sharedResources string,
  :createTime string,
  :enableAccessLogging boolean,
  :id string,
  :privateEndpoints
  {:predictHttpUri string,
   :explainHttpUri string,
   :serviceAttachment string,
   :healthHttpUri string},
  :model string}}"
  [endpoint GoogleCloudAiplatformV1MutateDeployedModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:mutateDeployedModel",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1MutateDeployedModelRequest}))

(defn projects-locations-endpoints-explain
  "Perform an online explanation. If deployed_model_id is specified, the corresponding DeployModel must have explanation_spec populated. If deployed_model_id is not specified, all DeployedModels must have explanation_spec populated.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the explanation. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1ExplainRequest:
{:explanationSpecOverride
 {:examplesOverride
  {:crowdingCount integer,
   :dataFormat [DATA_FORMAT_UNSPECIFIED INSTANCES EMBEDDINGS],
   :returnEmbeddings boolean,
   :neighborCount integer,
   :restrictions
   [{:deny [string], :allow [string], :namespaceName string}]},
  :parameters
  {:outputIndices [any],
   :examples
   {:exampleGcsSource
    {:gcsSource GoogleCloudAiplatformV1GcsSource,
     :dataFormat [DATA_FORMAT_UNSPECIFIED JSONL]},
    :presets
    {:modality [MODALITY_UNSPECIFIED IMAGE TEXT TABULAR],
     :query [PRECISE FAST]},
    :nearestNeighborSearchConfig any,
    :neighborCount integer},
   :xraiAttribution
   {:blurBaselineConfig {:maxBlurSigma number},
    :stepCount integer,
    :smoothGradConfig
    {:noisySampleCount integer,
     :featureNoiseSigma GoogleCloudAiplatformV1FeatureNoiseSigma,
     :noiseSigma number}},
   :topK integer,
   :sampledShapleyAttribution {:pathCount integer},
   :integratedGradientsAttribution
   {:smoothGradConfig
    {:noisySampleCount integer,
     :featureNoiseSigma GoogleCloudAiplatformV1FeatureNoiseSigma,
     :noiseSigma number},
    :blurBaselineConfig {:maxBlurSigma number},
    :stepCount integer}},
  :metadata {:inputs object}},
 :instances [any],
 :deployedModelId string,
 :parameters any}"
  [endpoint GoogleCloudAiplatformV1ExplainRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:explain",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1ExplainRequest}))

(defn projects-locations-endpoints-get
  "Gets an Endpoint.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Endpoint resource. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-endpoints-directPredict
  "Perform an unary online prediction request to a gRPC model server for Vertex first-party products and frameworks.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1DirectPredictRequest:
{:inputs
 [{:uintVal [integer],
   :floatVal [number],
   :dtype
   [DATA_TYPE_UNSPECIFIED
    BOOL
    STRING
    FLOAT
    DOUBLE
    INT8
    INT16
    INT32
    INT64
    UINT8
    UINT16
    UINT32
    UINT64],
   :uint64Val [string],
   :boolVal [boolean],
   :listVal
   [{:uintVal [integer],
     :floatVal [number],
     :dtype
     [DATA_TYPE_UNSPECIFIED
      BOOL
      STRING
      FLOAT
      DOUBLE
      INT8
      INT16
      INT32
      INT64
      UINT8
      UINT16
      UINT32
      UINT64],
     :uint64Val [string],
     :boolVal [boolean],
     :listVal
     [{:uintVal [integer],
       :floatVal [number],
       :dtype
       [DATA_TYPE_UNSPECIFIED
        BOOL
        STRING
        FLOAT
        DOUBLE
        INT8
        INT16
        INT32
        INT64
        UINT8
        UINT16
        UINT32
        UINT64],
       :uint64Val [string],
       :boolVal [boolean],
       :listVal
       [{:uintVal [integer],
         :floatVal [number],
         :dtype
         [DATA_TYPE_UNSPECIFIED
          BOOL
          STRING
          FLOAT
          DOUBLE
          INT8
          INT16
          INT32
          INT64
          UINT8
          UINT16
          UINT32
          UINT64],
         :uint64Val [string],
         :boolVal [boolean],
         :listVal [GoogleCloudAiplatformV1Tensor],
         :stringVal [string],
         :int64Val [string],
         :tensorVal string,
         :shape [string],
         :bytesVal [string],
         :intVal [integer],
         :doubleVal [number],
         :structVal object}],
       :stringVal [string],
       :int64Val [string],
       :tensorVal string,
       :shape [string],
       :bytesVal [string],
       :intVal [integer],
       :doubleVal [number],
       :structVal object}],
     :stringVal [string],
     :int64Val [string],
     :tensorVal string,
     :shape [string],
     :bytesVal [string],
     :intVal [integer],
     :doubleVal [number],
     :structVal object}],
   :stringVal [string],
   :int64Val [string],
   :tensorVal string,
   :shape [string],
   :bytesVal [string],
   :intVal [integer],
   :doubleVal [number],
   :structVal object}],
 :parameters
 {:uintVal [integer],
  :floatVal [number],
  :dtype
  [DATA_TYPE_UNSPECIFIED
   BOOL
   STRING
   FLOAT
   DOUBLE
   INT8
   INT16
   INT32
   INT64
   UINT8
   UINT16
   UINT32
   UINT64],
  :uint64Val [string],
  :boolVal [boolean],
  :listVal
  [{:uintVal [integer],
    :floatVal [number],
    :dtype
    [DATA_TYPE_UNSPECIFIED
     BOOL
     STRING
     FLOAT
     DOUBLE
     INT8
     INT16
     INT32
     INT64
     UINT8
     UINT16
     UINT32
     UINT64],
    :uint64Val [string],
    :boolVal [boolean],
    :listVal
    [{:uintVal [integer],
      :floatVal [number],
      :dtype
      [DATA_TYPE_UNSPECIFIED
       BOOL
       STRING
       FLOAT
       DOUBLE
       INT8
       INT16
       INT32
       INT64
       UINT8
       UINT16
       UINT32
       UINT64],
      :uint64Val [string],
      :boolVal [boolean],
      :listVal
      [{:uintVal [integer],
        :floatVal [number],
        :dtype
        [DATA_TYPE_UNSPECIFIED
         BOOL
         STRING
         FLOAT
         DOUBLE
         INT8
         INT16
         INT32
         INT64
         UINT8
         UINT16
         UINT32
         UINT64],
        :uint64Val [string],
        :boolVal [boolean],
        :listVal [GoogleCloudAiplatformV1Tensor],
        :stringVal [string],
        :int64Val [string],
        :tensorVal string,
        :shape [string],
        :bytesVal [string],
        :intVal [integer],
        :doubleVal [number],
        :structVal object}],
      :stringVal [string],
      :int64Val [string],
      :tensorVal string,
      :shape [string],
      :bytesVal [string],
      :intVal [integer],
      :doubleVal [number],
      :structVal object}],
    :stringVal [string],
    :int64Val [string],
    :tensorVal string,
    :shape [string],
    :bytesVal [string],
    :intVal [integer],
    :doubleVal [number],
    :structVal object}],
  :stringVal [string],
  :int64Val [string],
  :tensorVal string,
  :shape [string],
  :bytesVal [string],
  :intVal [integer],
  :doubleVal [number],
  :structVal object}}"
  [endpoint GoogleCloudAiplatformV1DirectPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:directPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1DirectPredictRequest}))

(defn projects-locations-endpoints-undeployModel
  "Undeploys a Model from an Endpoint, removing a DeployedModel from it, and freeing all resources it's using.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint resource from which to undeploy a Model. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1UndeployModelRequest:
{:deployedModelId string, :trafficSplit object}"
  [endpoint GoogleCloudAiplatformV1UndeployModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:undeployModel",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1UndeployModelRequest}))

(defn projects-locations-endpoints-patch
  "Updates an Endpoint.
https://cloud.google.com/vertex-ai

name <string> Output only. The resource name of the Endpoint.
GoogleCloudAiplatformV1Endpoint:
{:description string,
 :labels object,
 :encryptionSpec {:kmsKeyName string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :trafficSplit object,
 :updateTime string,
 :predictRequestResponseLoggingConfig
 {:enabled boolean,
  :bigqueryDestination {:outputUri string},
  :samplingRate number},
 :enablePrivateServiceConnect boolean,
 :deployedModels
 [{:serviceAccount string,
   :modelVersionId string,
   :disableContainerLogging boolean,
   :automaticResources
   {:minReplicaCount integer, :maxReplicaCount integer},
   :disableExplanations boolean,
   :displayName string,
   :explanationSpec
   {:metadata
    {:outputs object,
     :inputs object,
     :latentSpaceSource string,
     :featureAttributionsSchemaUri string},
    :parameters
    {:outputIndices [any],
     :examples
     {:exampleGcsSource
      GoogleCloudAiplatformV1ExamplesExampleGcsSource,
      :presets GoogleCloudAiplatformV1Presets,
      :nearestNeighborSearchConfig any,
      :neighborCount integer},
     :xraiAttribution
     {:blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
      :stepCount integer,
      :smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig},
     :topK integer,
     :sampledShapleyAttribution {:pathCount integer},
     :integratedGradientsAttribution
     {:smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig,
      :blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
      :stepCount integer}}},
   :dedicatedResources
   {:machineSpec
    {:acceleratorCount integer,
     :machineType string,
     :acceleratorType
     [ACCELERATOR_TYPE_UNSPECIFIED
      NVIDIA_TESLA_K80
      NVIDIA_TESLA_P100
      NVIDIA_TESLA_V100
      NVIDIA_TESLA_P4
      NVIDIA_TESLA_T4
      NVIDIA_TESLA_A100
      NVIDIA_A100_80GB
      NVIDIA_L4
      NVIDIA_H100_80GB
      TPU_V2
      TPU_V3
      TPU_V4_POD
      TPU_V5_LITEPOD],
     :tpuTopology string},
    :minReplicaCount integer,
    :autoscalingMetricSpecs [{:metricName string, :target integer}],
    :maxReplicaCount integer},
   :sharedResources string,
   :createTime string,
   :enableAccessLogging boolean,
   :id string,
   :privateEndpoints
   {:predictHttpUri string,
    :explainHttpUri string,
    :serviceAttachment string,
    :healthHttpUri string},
   :model string}],
 :modelDeploymentMonitoringJob string,
 :privateServiceConnectConfig
 {:enablePrivateServiceConnect boolean, :projectAllowlist [string]},
 :network string}

optional:
updateMask <string> Required. The update mask applies to the resource. See google.protobuf.FieldMask."
  ([name GoogleCloudAiplatformV1Endpoint]
    (projects-locations-endpoints-patch
      name
      GoogleCloudAiplatformV1Endpoint
      nil))
  ([name GoogleCloudAiplatformV1Endpoint optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Endpoint})))

(defn projects-locations-endpoints-create
  "Creates an Endpoint.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the Endpoint in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1Endpoint:
{:description string,
 :labels object,
 :encryptionSpec {:kmsKeyName string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :trafficSplit object,
 :updateTime string,
 :predictRequestResponseLoggingConfig
 {:enabled boolean,
  :bigqueryDestination {:outputUri string},
  :samplingRate number},
 :enablePrivateServiceConnect boolean,
 :deployedModels
 [{:serviceAccount string,
   :modelVersionId string,
   :disableContainerLogging boolean,
   :automaticResources
   {:minReplicaCount integer, :maxReplicaCount integer},
   :disableExplanations boolean,
   :displayName string,
   :explanationSpec
   {:metadata
    {:outputs object,
     :inputs object,
     :latentSpaceSource string,
     :featureAttributionsSchemaUri string},
    :parameters
    {:outputIndices [any],
     :examples
     {:exampleGcsSource
      GoogleCloudAiplatformV1ExamplesExampleGcsSource,
      :presets GoogleCloudAiplatformV1Presets,
      :nearestNeighborSearchConfig any,
      :neighborCount integer},
     :xraiAttribution
     {:blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
      :stepCount integer,
      :smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig},
     :topK integer,
     :sampledShapleyAttribution {:pathCount integer},
     :integratedGradientsAttribution
     {:smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig,
      :blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
      :stepCount integer}}},
   :dedicatedResources
   {:machineSpec
    {:acceleratorCount integer,
     :machineType string,
     :acceleratorType
     [ACCELERATOR_TYPE_UNSPECIFIED
      NVIDIA_TESLA_K80
      NVIDIA_TESLA_P100
      NVIDIA_TESLA_V100
      NVIDIA_TESLA_P4
      NVIDIA_TESLA_T4
      NVIDIA_TESLA_A100
      NVIDIA_A100_80GB
      NVIDIA_L4
      NVIDIA_H100_80GB
      TPU_V2
      TPU_V3
      TPU_V4_POD
      TPU_V5_LITEPOD],
     :tpuTopology string},
    :minReplicaCount integer,
    :autoscalingMetricSpecs [{:metricName string, :target integer}],
    :maxReplicaCount integer},
   :sharedResources string,
   :createTime string,
   :enableAccessLogging boolean,
   :id string,
   :privateEndpoints
   {:predictHttpUri string,
    :explainHttpUri string,
    :serviceAttachment string,
    :healthHttpUri string},
   :model string}],
 :modelDeploymentMonitoringJob string,
 :privateServiceConnectConfig
 {:enablePrivateServiceConnect boolean, :projectAllowlist [string]},
 :network string}

optional:
endpointId <string> Immutable. The ID to use for endpoint, which will become the final component of the endpoint resource name. If not provided, Vertex AI will generate a value for this ID. If the first character is a letter, this value may be up to 63 characters, and valid characters are `[a-z0-9-]`. The last character must be a letter or number. If the first character is a number, this value may be up to 9 characters, and valid characters are `[0-9]` with no leading zeros. When using HTTP/JSON, this field is populated based on a query string argument, such as `?endpoint_id=12345`. This is the fallback for fields that are not included in either the URI or the body."
  ([parent GoogleCloudAiplatformV1Endpoint]
    (projects-locations-endpoints-create
      parent
      GoogleCloudAiplatformV1Endpoint
      nil))
  ([parent GoogleCloudAiplatformV1Endpoint optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/endpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Endpoint})))

(defn projects-locations-endpoints-delete
  "Deletes an Endpoint.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Endpoint resource to be deleted. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-endpoints-computeTokens
  "Return a list of tokens based on the input text.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to get lists of tokens and token ids.
GoogleCloudAiplatformV1ComputeTokensRequest:
{:instances [any]}"
  [endpoint GoogleCloudAiplatformV1ComputeTokensRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:computeTokens",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ComputeTokensRequest}))

(defn projects-locations-endpoints-list
  "Lists Endpoints in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location from which to list the Endpoints. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> Optional. The standard list page size.
readMask <string> Optional. Mask specifying which fields to read.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `display_name` * `create_time` * `update_time` Example: `display_name, create_time desc`.
filter <string> Optional. An expression for filtering the results of the request. For field names both snake_case and camelCase are supported. * `endpoint` supports `=` and `!=`. `endpoint` represents the Endpoint ID, i.e. the last segment of the Endpoint's resource name. * `display_name` supports `=` and `!=`. * `labels` supports general map functions that is: * `labels.key=value` - key:value equality * `labels.key:*` or `labels:key` - key existence * A key including a space must be quoted. `labels.\"a key\"`. * `base_model_name` only supports `=`. Some examples: * `endpoint=1` * `displayName=\"myDisplayName\"` * `labels.myKey=\"myValue\"` * `baseModelName=\"text-bison\"`"
  ([parent] (projects-locations-endpoints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/endpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-endpoints-serverStreamingPredict
  "Perform a server-side streaming online prediction request for Vertex LLM streaming.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1StreamingPredictRequest:
{:inputs
 [{:uintVal [integer],
   :floatVal [number],
   :dtype
   [DATA_TYPE_UNSPECIFIED
    BOOL
    STRING
    FLOAT
    DOUBLE
    INT8
    INT16
    INT32
    INT64
    UINT8
    UINT16
    UINT32
    UINT64],
   :uint64Val [string],
   :boolVal [boolean],
   :listVal
   [{:uintVal [integer],
     :floatVal [number],
     :dtype
     [DATA_TYPE_UNSPECIFIED
      BOOL
      STRING
      FLOAT
      DOUBLE
      INT8
      INT16
      INT32
      INT64
      UINT8
      UINT16
      UINT32
      UINT64],
     :uint64Val [string],
     :boolVal [boolean],
     :listVal
     [{:uintVal [integer],
       :floatVal [number],
       :dtype
       [DATA_TYPE_UNSPECIFIED
        BOOL
        STRING
        FLOAT
        DOUBLE
        INT8
        INT16
        INT32
        INT64
        UINT8
        UINT16
        UINT32
        UINT64],
       :uint64Val [string],
       :boolVal [boolean],
       :listVal
       [{:uintVal [integer],
         :floatVal [number],
         :dtype
         [DATA_TYPE_UNSPECIFIED
          BOOL
          STRING
          FLOAT
          DOUBLE
          INT8
          INT16
          INT32
          INT64
          UINT8
          UINT16
          UINT32
          UINT64],
         :uint64Val [string],
         :boolVal [boolean],
         :listVal [GoogleCloudAiplatformV1Tensor],
         :stringVal [string],
         :int64Val [string],
         :tensorVal string,
         :shape [string],
         :bytesVal [string],
         :intVal [integer],
         :doubleVal [number],
         :structVal object}],
       :stringVal [string],
       :int64Val [string],
       :tensorVal string,
       :shape [string],
       :bytesVal [string],
       :intVal [integer],
       :doubleVal [number],
       :structVal object}],
     :stringVal [string],
     :int64Val [string],
     :tensorVal string,
     :shape [string],
     :bytesVal [string],
     :intVal [integer],
     :doubleVal [number],
     :structVal object}],
   :stringVal [string],
   :int64Val [string],
   :tensorVal string,
   :shape [string],
   :bytesVal [string],
   :intVal [integer],
   :doubleVal [number],
   :structVal object}],
 :parameters
 {:uintVal [integer],
  :floatVal [number],
  :dtype
  [DATA_TYPE_UNSPECIFIED
   BOOL
   STRING
   FLOAT
   DOUBLE
   INT8
   INT16
   INT32
   INT64
   UINT8
   UINT16
   UINT32
   UINT64],
  :uint64Val [string],
  :boolVal [boolean],
  :listVal
  [{:uintVal [integer],
    :floatVal [number],
    :dtype
    [DATA_TYPE_UNSPECIFIED
     BOOL
     STRING
     FLOAT
     DOUBLE
     INT8
     INT16
     INT32
     INT64
     UINT8
     UINT16
     UINT32
     UINT64],
    :uint64Val [string],
    :boolVal [boolean],
    :listVal
    [{:uintVal [integer],
      :floatVal [number],
      :dtype
      [DATA_TYPE_UNSPECIFIED
       BOOL
       STRING
       FLOAT
       DOUBLE
       INT8
       INT16
       INT32
       INT64
       UINT8
       UINT16
       UINT32
       UINT64],
      :uint64Val [string],
      :boolVal [boolean],
      :listVal
      [{:uintVal [integer],
        :floatVal [number],
        :dtype
        [DATA_TYPE_UNSPECIFIED
         BOOL
         STRING
         FLOAT
         DOUBLE
         INT8
         INT16
         INT32
         INT64
         UINT8
         UINT16
         UINT32
         UINT64],
        :uint64Val [string],
        :boolVal [boolean],
        :listVal [GoogleCloudAiplatformV1Tensor],
        :stringVal [string],
        :int64Val [string],
        :tensorVal string,
        :shape [string],
        :bytesVal [string],
        :intVal [integer],
        :doubleVal [number],
        :structVal object}],
      :stringVal [string],
      :int64Val [string],
      :tensorVal string,
      :shape [string],
      :bytesVal [string],
      :intVal [integer],
      :doubleVal [number],
      :structVal object}],
    :stringVal [string],
    :int64Val [string],
    :tensorVal string,
    :shape [string],
    :bytesVal [string],
    :intVal [integer],
    :doubleVal [number],
    :structVal object}],
  :stringVal [string],
  :int64Val [string],
  :tensorVal string,
  :shape [string],
  :bytesVal [string],
  :intVal [integer],
  :doubleVal [number],
  :structVal object}}"
  [endpoint GoogleCloudAiplatformV1StreamingPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:serverStreamingPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1StreamingPredictRequest}))

(defn projects-locations-endpoints-rawPredict
  "Perform an online prediction with an arbitrary HTTP payload. The response includes the following HTTP headers: * `X-Vertex-AI-Endpoint-Id`: ID of the Endpoint that served this prediction. * `X-Vertex-AI-Deployed-Model-Id`: ID of the Endpoint's DeployedModel that served this prediction.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1RawPredictRequest:
{:httpBody {:extensions [object], :contentType string, :data string}}"
  [endpoint GoogleCloudAiplatformV1RawPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:rawPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1RawPredictRequest}))

(defn projects-locations-endpoints-streamRawPredict
  "Perform a streaming online prediction with an arbitrary HTTP payload.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1StreamRawPredictRequest:
{:httpBody {:extensions [object], :contentType string, :data string}}"
  [endpoint GoogleCloudAiplatformV1StreamRawPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:streamRawPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1StreamRawPredictRequest}))

(defn projects-locations-endpoints-predict
  "Perform an online prediction.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1PredictRequest:
{:parameters any, :instances [any]}"
  [endpoint GoogleCloudAiplatformV1PredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:predict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1PredictRequest}))

(defn projects-locations-endpoints-countTokens
  "Perform a token counting.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to perform token counting. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1CountTokensRequest:
{:contents
 [{:role string,
   :parts
   [{:functionResponse {:name string, :response object},
     :text string,
     :functionCall {:args object, :name string},
     :videoMetadata {:endOffset string, :startOffset string},
     :inlineData {:data string, :mimeType string},
     :fileData {:fileUri string, :mimeType string}}]}],
 :instances [any],
 :model string}"
  [endpoint GoogleCloudAiplatformV1CountTokensRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:countTokens",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CountTokensRequest}))

(defn projects-locations-endpoints-generateContent
  "Generate content with multimodal inputs.
https://cloud.google.com/vertex-ai

model <string> Required. The name of the publisher model requested to serve the prediction. Format: `projects/{project}/locations/{location}/publishers/*/models/*`
GoogleCloudAiplatformV1GenerateContentRequest:
{:toolConfig
 {:functionCallingConfig
  {:allowedFunctionNames [string],
   :mode [MODE_UNSPECIFIED AUTO ANY NONE]}},
 :contents
 [{:role string,
   :parts
   [{:functionResponse {:name string, :response object},
     :text string,
     :functionCall {:args object, :name string},
     :videoMetadata {:endOffset string, :startOffset string},
     :inlineData {:data string, :mimeType string},
     :fileData {:fileUri string, :mimeType string}}]}],
 :systemInstruction
 {:role string,
  :parts
  [{:functionResponse {:name string, :response object},
    :text string,
    :functionCall {:args object, :name string},
    :videoMetadata {:endOffset string, :startOffset string},
    :inlineData {:data string, :mimeType string},
    :fileData {:fileUri string, :mimeType string}}]},
 :safetySettings
 [{:category
   [HARM_CATEGORY_UNSPECIFIED
    HARM_CATEGORY_HATE_SPEECH
    HARM_CATEGORY_DANGEROUS_CONTENT
    HARM_CATEGORY_HARASSMENT
    HARM_CATEGORY_SEXUALLY_EXPLICIT],
   :method [HARM_BLOCK_METHOD_UNSPECIFIED SEVERITY PROBABILITY],
   :threshold
   [HARM_BLOCK_THRESHOLD_UNSPECIFIED
    BLOCK_LOW_AND_ABOVE
    BLOCK_MEDIUM_AND_ABOVE
    BLOCK_ONLY_HIGH
    BLOCK_NONE]}],
 :tools
 [{:retrieval
   {:disableAttribution boolean, :vertexAiSearch {:datastore string}},
   :googleSearchRetrieval object,
   :functionDeclarations
   [{:description string,
     :name string,
     :parameters
     {:description string,
      :enum [string],
      :properties object,
      :format string,
      :maxProperties string,
      :default any,
      :maximum number,
      :type
      [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
      :minLength string,
      :title string,
      :minProperties string,
      :minimum number,
      :minItems string,
      :maxLength string,
      :example any,
      :items
      {:description string,
       :enum [string],
       :properties object,
       :format string,
       :maxProperties string,
       :default any,
       :maximum number,
       :type
       [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
       :minLength string,
       :title string,
       :minProperties string,
       :minimum number,
       :minItems string,
       :maxLength string,
       :example any,
       :items GoogleCloudAiplatformV1Schema,
       :nullable boolean,
       :required [string],
       :maxItems string,
       :pattern string},
      :nullable boolean,
      :required [string],
      :maxItems string,
      :pattern string}}]}],
 :generationConfig
 {:responseMimeType string,
  :responseSchema
  {:description string,
   :enum [string],
   :properties object,
   :format string,
   :maxProperties string,
   :default any,
   :maximum number,
   :type [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
   :minLength string,
   :title string,
   :minProperties string,
   :minimum number,
   :minItems string,
   :maxLength string,
   :example any,
   :items
   {:description string,
    :enum [string],
    :properties object,
    :format string,
    :maxProperties string,
    :default any,
    :maximum number,
    :type
    [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
    :minLength string,
    :title string,
    :minProperties string,
    :minimum number,
    :minItems string,
    :maxLength string,
    :example any,
    :items
    {:description string,
     :enum [string],
     :properties object,
     :format string,
     :maxProperties string,
     :default any,
     :maximum number,
     :type
     [TYPE_UNSPECIFIED STRING NUMBER INTEGER BOOLEAN ARRAY OBJECT],
     :minLength string,
     :title string,
     :minProperties string,
     :minimum number,
     :minItems string,
     :maxLength string,
     :example any,
     :items GoogleCloudAiplatformV1Schema,
     :nullable boolean,
     :required [string],
     :maxItems string,
     :pattern string},
    :nullable boolean,
    :required [string],
    :maxItems string,
    :pattern string},
   :nullable boolean,
   :required [string],
   :maxItems string,
   :pattern string},
  :presencePenalty number,
  :stopSequences [string],
  :topP number,
  :maxOutputTokens integer,
  :frequencyPenalty number,
  :topK number,
  :candidateCount integer,
  :temperature number}}"
  [model GoogleCloudAiplatformV1GenerateContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+model}:generateContent",
     :uri-template-args {:model model},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1GenerateContentRequest}))

(defn projects-locations-endpoints-directRawPredict
  "Perform an unary online prediction request to a gRPC model server for custom containers.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint requested to serve the prediction. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1DirectRawPredictRequest:
{:input string, :methodName string}"
  [endpoint GoogleCloudAiplatformV1DirectRawPredictRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:directRawPredict",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GoogleCloudAiplatformV1DirectRawPredictRequest}))

(defn projects-locations-endpoints-deployModel
  "Deploys a Model into this Endpoint, creating a DeployedModel within it.
https://cloud.google.com/vertex-ai

endpoint <string> Required. The name of the Endpoint resource into which to deploy a Model. Format: `projects/{project}/locations/{location}/endpoints/{endpoint}`
GoogleCloudAiplatformV1DeployModelRequest:
{:trafficSplit object,
 :deployedModel
 {:serviceAccount string,
  :modelVersionId string,
  :disableContainerLogging boolean,
  :automaticResources
  {:minReplicaCount integer, :maxReplicaCount integer},
  :disableExplanations boolean,
  :displayName string,
  :explanationSpec
  {:metadata
   {:outputs object,
    :inputs object,
    :latentSpaceSource string,
    :featureAttributionsSchemaUri string},
   :parameters
   {:outputIndices [any],
    :examples
    {:exampleGcsSource GoogleCloudAiplatformV1ExamplesExampleGcsSource,
     :presets GoogleCloudAiplatformV1Presets,
     :nearestNeighborSearchConfig any,
     :neighborCount integer},
    :xraiAttribution
    {:blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer,
     :smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig},
    :topK integer,
    :sampledShapleyAttribution {:pathCount integer},
    :integratedGradientsAttribution
    {:smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig,
     :blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer}}},
  :dedicatedResources
  {:machineSpec
   {:acceleratorCount integer,
    :machineType string,
    :acceleratorType
    [ACCELERATOR_TYPE_UNSPECIFIED
     NVIDIA_TESLA_K80
     NVIDIA_TESLA_P100
     NVIDIA_TESLA_V100
     NVIDIA_TESLA_P4
     NVIDIA_TESLA_T4
     NVIDIA_TESLA_A100
     NVIDIA_A100_80GB
     NVIDIA_L4
     NVIDIA_H100_80GB
     TPU_V2
     TPU_V3
     TPU_V4_POD
     TPU_V5_LITEPOD],
    :tpuTopology string},
   :minReplicaCount integer,
   :autoscalingMetricSpecs [{:metricName string, :target integer}],
   :maxReplicaCount integer},
  :sharedResources string,
  :createTime string,
  :enableAccessLogging boolean,
  :id string,
  :privateEndpoints
  {:predictHttpUri string,
   :explainHttpUri string,
   :serviceAttachment string,
   :healthHttpUri string},
  :model string}}"
  [endpoint GoogleCloudAiplatformV1DeployModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+endpoint}:deployModel",
     :uri-template-args {:endpoint endpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1DeployModelRequest}))

(defn projects-locations-endpoints-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-endpoints-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-endpoints-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-endpoints-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-endpoints-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (projects-locations-endpoints-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-endpoints-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-trainingPipelines-cancel
  "Cancels a TrainingPipeline. Starts asynchronous cancellation on the TrainingPipeline. The server makes a best effort to cancel the pipeline, but success is not guaranteed. Clients can use PipelineService.GetTrainingPipeline or other methods to check whether the cancellation succeeded or whether the pipeline completed despite cancellation. On successful cancellation, the TrainingPipeline is not deleted; instead it becomes a pipeline with a TrainingPipeline.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and TrainingPipeline.state is set to `CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TrainingPipeline to cancel. Format: `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`
GoogleCloudAiplatformV1CancelTrainingPipelineRequest:
object"
  [name GoogleCloudAiplatformV1CancelTrainingPipelineRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CancelTrainingPipelineRequest}))

(defn projects-locations-trainingPipelines-delete
  "Deletes a TrainingPipeline.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TrainingPipeline resource to be deleted. Format: `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-trainingPipelines-list
  "Lists TrainingPipelines in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the TrainingPipelines from. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read.
filter <string> The standard list filter. Supported fields: * `display_name` supports `=`, `!=` comparisons, and `:` wildcard. * `state` supports `=`, `!=` comparisons. * `training_task_definition` `=`, `!=` comparisons, and `:` wildcard. * `create_time` supports `=`, `!=`,`<`, `<=`,`>`, `>=` comparisons. `create_time` must be in RFC 3339 format. * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* - key existence Some examples of using the filter are: * `state=\"PIPELINE_STATE_SUCCEEDED\" AND display_name:\"my_pipeline_*\"` * `state!=\"PIPELINE_STATE_FAILED\" OR display_name=\"my_pipeline\"` * `NOT display_name=\"my_pipeline\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `training_task_definition:\"*automl_text_classification*\"`
pageSize <integer> The standard list page size."
  ([parent] (projects-locations-trainingPipelines-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/trainingPipelines",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-trainingPipelines-get
  "Gets a TrainingPipeline.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TrainingPipeline resource. Format: `projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-trainingPipelines-create
  "Creates a TrainingPipeline. A created TrainingPipeline right away will be attempted to be run.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the TrainingPipeline in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1TrainingPipeline:
{:labels object,
 :modelToUpload
 {:description string,
  :labels object,
  :versionUpdateTime string,
  :versionId string,
  :predictSchemata
  {:predictionSchemaUri string,
   :instanceSchemaUri string,
   :parametersSchemaUri string},
  :artifactUri string,
  :pipelineJob string,
  :versionAliases [string],
  :supportedOutputStorageFormats [string],
  :containerSpec
  {:args [string],
   :healthRoute string,
   :imageUri string,
   :healthProbe
   {:exec {:command [string]},
    :periodSeconds integer,
    :timeoutSeconds integer},
   :command [string],
   :env [{:value string, :name string}],
   :deploymentTimeout string,
   :ports [{:containerPort integer}],
   :startupProbe
   {:exec {:command [string]},
    :periodSeconds integer,
    :timeoutSeconds integer},
   :grpcPorts [{:containerPort integer}],
   :sharedMemorySizeMb string,
   :predictRoute string},
  :encryptionSpec {:kmsKeyName string},
  :trainingPipeline string,
  :metadataSchemaUri string,
  :displayName string,
  :explanationSpec
  {:metadata
   {:outputs object,
    :inputs object,
    :latentSpaceSource string,
    :featureAttributionsSchemaUri string},
   :parameters
   {:outputIndices [any],
    :examples
    {:exampleGcsSource GoogleCloudAiplatformV1ExamplesExampleGcsSource,
     :presets GoogleCloudAiplatformV1Presets,
     :nearestNeighborSearchConfig any,
     :neighborCount integer},
    :xraiAttribution
    {:blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer,
     :smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig},
    :topK integer,
    :sampledShapleyAttribution {:pathCount integer},
    :integratedGradientsAttribution
    {:smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig,
     :blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer}}},
  :versionDescription string,
  :name string,
  :createTime string,
  :metadataArtifact string,
  :supportedInputStorageFormats [string],
  :etag string,
  :modelSourceInfo
  {:sourceType
   [MODEL_SOURCE_TYPE_UNSPECIFIED
    AUTOML
    CUSTOM
    BQML
    MODEL_GARDEN
    GENIE
    CUSTOM_TEXT_EMBEDDING
    MARKETPLACE],
   :copy boolean},
  :updateTime string,
  :originalModelInfo {:model string},
  :dataStats
  {:trainingDataItemsCount string,
   :testAnnotationsCount string,
   :testDataItemsCount string,
   :validationAnnotationsCount string,
   :validationDataItemsCount string,
   :trainingAnnotationsCount string},
  :deployedModels [{:deployedModelId string, :endpoint string}],
  :supportedDeploymentResourcesTypes
  [[DEPLOYMENT_RESOURCES_TYPE_UNSPECIFIED
    DEDICATED_RESOURCES
    AUTOMATIC_RESOURCES
    SHARED_RESOURCES]],
  :versionCreateTime string,
  :baseModelSource
  {:modelGardenSource {:publicModelName string},
   :genieSource {:baseModelUri string}},
  :metadata any,
  :supportedExportFormats
  [{:exportableContents
    [[EXPORTABLE_CONTENT_UNSPECIFIED ARTIFACT IMAGE]],
    :id string}]},
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :name string,
 :trainingTaskMetadata any,
 :endTime string,
 :modelId string,
 :createTime string,
 :state
 [PIPELINE_STATE_UNSPECIFIED
  PIPELINE_STATE_QUEUED
  PIPELINE_STATE_PENDING
  PIPELINE_STATE_RUNNING
  PIPELINE_STATE_SUCCEEDED
  PIPELINE_STATE_FAILED
  PIPELINE_STATE_CANCELLING
  PIPELINE_STATE_CANCELLED
  PIPELINE_STATE_PAUSED],
 :parentModel string,
 :updateTime string,
 :trainingTaskDefinition string,
 :inputDataConfig
 {:annotationSchemaUri string,
  :timestampSplit
  {:trainingFraction number,
   :validationFraction number,
   :key string,
   :testFraction number},
  :bigqueryDestination {:outputUri string},
  :fractionSplit
  {:testFraction number,
   :trainingFraction number,
   :validationFraction number},
  :predefinedSplit {:key string},
  :annotationsFilter string,
  :stratifiedSplit
  {:validationFraction number,
   :trainingFraction number,
   :key string,
   :testFraction number},
  :datasetId string,
  :gcsDestination {:outputUriPrefix string},
  :filterSplit
  {:validationFilter string,
   :trainingFilter string,
   :testFilter string},
  :persistMlUseAssignment boolean,
  :savedQueryId string},
 :trainingTaskInputs any,
 :error {:message string, :code integer, :details [object]}}"
  [parent GoogleCloudAiplatformV1TrainingPipeline]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/trainingPipelines",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1TrainingPipeline}))

(defn projects-locations-trainingPipelines-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-trainingPipelines-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-trainingPipelines-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-trainingPipelines-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-trainingPipelines-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-trainingPipelines-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-trainingPipelines-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-updateExplanationDataset
  "Incrementally update the dataset used for an examples model.
https://cloud.google.com/vertex-ai

model <string> Required. The resource name of the Model to update. Format: `projects/{project}/locations/{location}/models/{model}`
GoogleCloudAiplatformV1UpdateExplanationDatasetRequest:
{:examples
 {:exampleGcsSource
  {:gcsSource {:uris [string]},
   :dataFormat [DATA_FORMAT_UNSPECIFIED JSONL]},
  :presets
  {:modality [MODALITY_UNSPECIFIED IMAGE TEXT TABULAR],
   :query [PRECISE FAST]},
  :nearestNeighborSearchConfig any,
  :neighborCount integer}}"
  [model GoogleCloudAiplatformV1UpdateExplanationDatasetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+model}:updateExplanationDataset",
     :uri-template-args {:model model},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1UpdateExplanationDatasetRequest}))

(defn projects-locations-models-get
  "Gets a Model.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Model resource. Format: `projects/{project}/locations/{location}/models/{model}` In order to retrieve a specific version of the model, also provide the version ID or version alias. Example: `projects/{project}/locations/{location}/models/{model}@2` or `projects/{project}/locations/{location}/models/{model}@golden` If no version ID or alias is specified, the \"default\" version will be returned. The \"default\" version alias is created for the first version of the model, and can be moved to other versions later on. There will be exactly one default version."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-copy
  "Copies an already existing Vertex AI Model into the specified Location. The source Model must exist in the same Project. When copying custom Models, the users themselves are responsible for Model.metadata content to be region-agnostic, as well as making sure that any resources (e.g. files) it depends on remain accessible.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location into which to copy the Model. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1CopyModelRequest:
{:parentModel string,
 :sourceModel string,
 :encryptionSpec {:kmsKeyName string},
 :modelId string}"
  [parent GoogleCloudAiplatformV1CopyModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/models:copy",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CopyModelRequest}))

(defn projects-locations-models-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
{:policy
 {:bindings
  [{:role string,
    :condition
    {:title string,
     :description string,
     :expression string,
     :location string},
    :members [string]}],
  :etag string,
  :version integer}}"
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-models-patch
  "Updates a Model.
https://cloud.google.com/vertex-ai

name <string> The resource name of the Model.
GoogleCloudAiplatformV1Model:
{:description string,
 :labels object,
 :versionUpdateTime string,
 :versionId string,
 :predictSchemata
 {:predictionSchemaUri string,
  :instanceSchemaUri string,
  :parametersSchemaUri string},
 :artifactUri string,
 :pipelineJob string,
 :versionAliases [string],
 :supportedOutputStorageFormats [string],
 :containerSpec
 {:args [string],
  :healthRoute string,
  :imageUri string,
  :healthProbe
  {:exec {:command [string]},
   :periodSeconds integer,
   :timeoutSeconds integer},
  :command [string],
  :env [{:value string, :name string}],
  :deploymentTimeout string,
  :ports [{:containerPort integer}],
  :startupProbe
  {:exec {:command [string]},
   :periodSeconds integer,
   :timeoutSeconds integer},
  :grpcPorts [{:containerPort integer}],
  :sharedMemorySizeMb string,
  :predictRoute string},
 :encryptionSpec {:kmsKeyName string},
 :trainingPipeline string,
 :metadataSchemaUri string,
 :displayName string,
 :explanationSpec
 {:metadata
  {:outputs object,
   :inputs object,
   :latentSpaceSource string,
   :featureAttributionsSchemaUri string},
  :parameters
  {:outputIndices [any],
   :examples
   {:exampleGcsSource
    {:gcsSource GoogleCloudAiplatformV1GcsSource,
     :dataFormat [DATA_FORMAT_UNSPECIFIED JSONL]},
    :presets
    {:modality [MODALITY_UNSPECIFIED IMAGE TEXT TABULAR],
     :query [PRECISE FAST]},
    :nearestNeighborSearchConfig any,
    :neighborCount integer},
   :xraiAttribution
   {:blurBaselineConfig {:maxBlurSigma number},
    :stepCount integer,
    :smoothGradConfig
    {:noisySampleCount integer,
     :featureNoiseSigma GoogleCloudAiplatformV1FeatureNoiseSigma,
     :noiseSigma number}},
   :topK integer,
   :sampledShapleyAttribution {:pathCount integer},
   :integratedGradientsAttribution
   {:smoothGradConfig
    {:noisySampleCount integer,
     :featureNoiseSigma GoogleCloudAiplatformV1FeatureNoiseSigma,
     :noiseSigma number},
    :blurBaselineConfig {:maxBlurSigma number},
    :stepCount integer}}},
 :versionDescription string,
 :name string,
 :createTime string,
 :metadataArtifact string,
 :supportedInputStorageFormats [string],
 :etag string,
 :modelSourceInfo
 {:sourceType
  [MODEL_SOURCE_TYPE_UNSPECIFIED
   AUTOML
   CUSTOM
   BQML
   MODEL_GARDEN
   GENIE
   CUSTOM_TEXT_EMBEDDING
   MARKETPLACE],
  :copy boolean},
 :updateTime string,
 :originalModelInfo {:model string},
 :dataStats
 {:trainingDataItemsCount string,
  :testAnnotationsCount string,
  :testDataItemsCount string,
  :validationAnnotationsCount string,
  :validationDataItemsCount string,
  :trainingAnnotationsCount string},
 :deployedModels [{:deployedModelId string, :endpoint string}],
 :supportedDeploymentResourcesTypes
 [[DEPLOYMENT_RESOURCES_TYPE_UNSPECIFIED
   DEDICATED_RESOURCES
   AUTOMATIC_RESOURCES
   SHARED_RESOURCES]],
 :versionCreateTime string,
 :baseModelSource
 {:modelGardenSource {:publicModelName string},
  :genieSource {:baseModelUri string}},
 :metadata any,
 :supportedExportFormats
 [{:exportableContents
   [[EXPORTABLE_CONTENT_UNSPECIFIED ARTIFACT IMAGE]],
   :id string}]}

optional:
updateMask <string> Required. The update mask applies to the resource. For the `FieldMask` definition, see google.protobuf.FieldMask."
  ([name GoogleCloudAiplatformV1Model]
    (projects-locations-models-patch
      name
      GoogleCloudAiplatformV1Model
      nil))
  ([name GoogleCloudAiplatformV1Model optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Model})))

(defn projects-locations-models-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
permissions <string> The set of permissions to check for the `resource`. Permissions with wildcards (such as `*` or `storage.*`) are not allowed. For more information see [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions)."
  ([resource]
    (projects-locations-models-testIamPermissions resource nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:testIamPermissions",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-delete
  "Deletes a Model. A model cannot be deleted if any Endpoint resource has a DeployedModel based on the model in its deployed_models field.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Model resource to be deleted. Format: `projects/{project}/locations/{location}/models/{model}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-mergeVersionAliases
  "Merges a set of aliases for a Model version.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the model version to merge aliases, with a version ID explicitly included. Example: `projects/{project}/locations/{location}/models/{model}@1234`
GoogleCloudAiplatformV1MergeVersionAliasesRequest:
{:versionAliases [string]}"
  [name GoogleCloudAiplatformV1MergeVersionAliasesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:mergeVersionAliases",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1MergeVersionAliasesRequest}))

(defn projects-locations-models-export
  "Exports a trained, exportable Model to a location specified by the user. A Model is considered to be exportable if it has at least one supported export format.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the Model to export. The resource name may contain version id or version alias to specify the version, if no version is specified, the default version will be exported.
GoogleCloudAiplatformV1ExportModelRequest:
{:outputConfig
 {:exportFormatId string,
  :artifactDestination {:outputUriPrefix string},
  :imageDestination {:outputUri string}}}"
  [name GoogleCloudAiplatformV1ExportModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:export",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ExportModelRequest}))

(defn projects-locations-models-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-models-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-list
  "Lists Models in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the Models from. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The standard list page size.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `display_name` * `create_time` * `update_time` Example: `display_name, create_time desc`.
filter <string> An expression for filtering the results of the request. For field names both snake_case and camelCase are supported. * `model` supports = and !=. `model` represents the Model ID, i.e. the last segment of the Model's resource name. * `display_name` supports = and != * `labels` supports general map functions that is: * `labels.key=value` - key:value equality * `labels.key:* or labels:key - key existence * A key including a space must be quoted. `labels.\"a key\"`. * `base_model_name` only supports = Some examples: * `model=1234` * `displayName=\"myDisplayName\"` * `labels.myKey=\"myValue\"` * `baseModelName=\"text-bison\"`
readMask <string> Mask specifying which fields to read."
  ([parent] (projects-locations-models-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/models",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-listVersions
  "Lists versions of the specified model.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the model to list versions for.

optional:
filter <string> An expression for filtering the results of the request. For field names both snake_case and camelCase are supported. * `labels` supports general map functions that is: * `labels.key=value` - key:value equality * `labels.key:* or labels:key - key existence * A key including a space must be quoted. `labels.\"a key\"`. Some examples: * `labels.myKey=\"myValue\"`
readMask <string> Mask specifying which fields to read.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `create_time` * `update_time` Example: `update_time asc, create_time desc`.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-models-listVersions name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:listVersions",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-upload
  "Uploads a Model artifact into Vertex AI.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location into which to upload the Model. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1UploadModelRequest:
{:serviceAccount string,
 :parentModel string,
 :model
 {:description string,
  :labels object,
  :versionUpdateTime string,
  :versionId string,
  :predictSchemata
  {:predictionSchemaUri string,
   :instanceSchemaUri string,
   :parametersSchemaUri string},
  :artifactUri string,
  :pipelineJob string,
  :versionAliases [string],
  :supportedOutputStorageFormats [string],
  :containerSpec
  {:args [string],
   :healthRoute string,
   :imageUri string,
   :healthProbe
   {:exec {:command [string]},
    :periodSeconds integer,
    :timeoutSeconds integer},
   :command [string],
   :env [{:value string, :name string}],
   :deploymentTimeout string,
   :ports [{:containerPort integer}],
   :startupProbe
   {:exec {:command [string]},
    :periodSeconds integer,
    :timeoutSeconds integer},
   :grpcPorts [{:containerPort integer}],
   :sharedMemorySizeMb string,
   :predictRoute string},
  :encryptionSpec {:kmsKeyName string},
  :trainingPipeline string,
  :metadataSchemaUri string,
  :displayName string,
  :explanationSpec
  {:metadata
   {:outputs object,
    :inputs object,
    :latentSpaceSource string,
    :featureAttributionsSchemaUri string},
   :parameters
   {:outputIndices [any],
    :examples
    {:exampleGcsSource GoogleCloudAiplatformV1ExamplesExampleGcsSource,
     :presets GoogleCloudAiplatformV1Presets,
     :nearestNeighborSearchConfig any,
     :neighborCount integer},
    :xraiAttribution
    {:blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer,
     :smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig},
    :topK integer,
    :sampledShapleyAttribution {:pathCount integer},
    :integratedGradientsAttribution
    {:smoothGradConfig GoogleCloudAiplatformV1SmoothGradConfig,
     :blurBaselineConfig GoogleCloudAiplatformV1BlurBaselineConfig,
     :stepCount integer}}},
  :versionDescription string,
  :name string,
  :createTime string,
  :metadataArtifact string,
  :supportedInputStorageFormats [string],
  :etag string,
  :modelSourceInfo
  {:sourceType
   [MODEL_SOURCE_TYPE_UNSPECIFIED
    AUTOML
    CUSTOM
    BQML
    MODEL_GARDEN
    GENIE
    CUSTOM_TEXT_EMBEDDING
    MARKETPLACE],
   :copy boolean},
  :updateTime string,
  :originalModelInfo {:model string},
  :dataStats
  {:trainingDataItemsCount string,
   :testAnnotationsCount string,
   :testDataItemsCount string,
   :validationAnnotationsCount string,
   :validationDataItemsCount string,
   :trainingAnnotationsCount string},
  :deployedModels [{:deployedModelId string, :endpoint string}],
  :supportedDeploymentResourcesTypes
  [[DEPLOYMENT_RESOURCES_TYPE_UNSPECIFIED
    DEDICATED_RESOURCES
    AUTOMATIC_RESOURCES
    SHARED_RESOURCES]],
  :versionCreateTime string,
  :baseModelSource
  {:modelGardenSource {:publicModelName string},
   :genieSource {:baseModelUri string}},
  :metadata any,
  :supportedExportFormats
  [{:exportableContents
    [[EXPORTABLE_CONTENT_UNSPECIFIED ARTIFACT IMAGE]],
    :id string}]},
 :modelId string}"
  [parent GoogleCloudAiplatformV1UploadModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/models:upload",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1UploadModelRequest}))

(defn projects-locations-models-deleteVersion
  "Deletes a Model version. Model version can only be deleted if there are no DeployedModels created from it. Deleting the only version in the Model is not allowed. Use DeleteModel for deleting the Model instead.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the model version to be deleted, with a version ID explicitly included. Example: `projects/{project}/locations/{location}/models/{model}@1234`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:deleteVersion",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-models-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (projects-locations-models-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-evaluations-import
  "Imports an externally generated ModelEvaluation.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the parent model resource. Format: `projects/{project}/locations/{location}/models/{model}`
GoogleCloudAiplatformV1ImportModelEvaluationRequest:
{:modelEvaluation
 {:annotationSchemaUri string,
  :explanationSpecs
  [{:explanationType string,
    :explanationSpec
    {:metadata
     {:outputs object,
      :inputs object,
      :latentSpaceSource string,
      :featureAttributionsSchemaUri string},
     :parameters
     {:outputIndices [any],
      :examples GoogleCloudAiplatformV1Examples,
      :xraiAttribution GoogleCloudAiplatformV1XraiAttribution,
      :topK integer,
      :sampledShapleyAttribution
      GoogleCloudAiplatformV1SampledShapleyAttribution,
      :integratedGradientsAttribution
      GoogleCloudAiplatformV1IntegratedGradientsAttribution}}}],
  :dataItemSchemaUri string,
  :sliceDimensions [string],
  :displayName string,
  :name string,
  :createTime string,
  :metricsSchemaUri string,
  :modelExplanation
  {:meanAttributions
   [{:outputIndex [integer],
     :baselineOutputValue number,
     :instanceOutputValue number,
     :outputDisplayName string,
     :featureAttributions any,
     :approximationError number,
     :outputName string}]},
  :metadata any,
  :metrics any}}"
  [parent GoogleCloudAiplatformV1ImportModelEvaluationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/evaluations:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ImportModelEvaluationRequest}))

(defn projects-locations-models-evaluations-list
  "Lists ModelEvaluations in a Model.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Model to list the ModelEvaluations from. Format: `projects/{project}/locations/{location}/models/{model}`

optional:
filter <string> The standard list filter.
readMask <string> Mask specifying which fields to read.
pageSize <integer> The standard list page size."
  ([parent] (projects-locations-models-evaluations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/evaluations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-evaluations-get
  "Gets a ModelEvaluation.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the ModelEvaluation resource. Format: `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-evaluations-slices-batchImport
  "Imports a list of externally generated EvaluatedAnnotations.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the parent ModelEvaluationSlice resource. Format: `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`
GoogleCloudAiplatformV1BatchImportEvaluatedAnnotationsRequest:
{:evaluatedAnnotations
 [{:dataItemPayload any,
   :explanations
   [{:explanation
     {:neighbors [{:neighborId string, :neighborDistance number}],
      :attributions
      [{:outputIndex [integer],
        :baselineOutputValue number,
        :instanceOutputValue number,
        :outputDisplayName string,
        :featureAttributions any,
        :approximationError number,
        :outputName string}]},
     :explanationType string}],
   :type
   [EVALUATED_ANNOTATION_TYPE_UNSPECIFIED
    TRUE_POSITIVE
    FALSE_POSITIVE
    FALSE_NEGATIVE],
   :evaluatedDataItemViewId string,
   :predictions [any],
   :errorAnalysisAnnotations
   [{:outlierScore number,
     :queryType
     [QUERY_TYPE_UNSPECIFIED
      ALL_SIMILAR
      SAME_CLASS_SIMILAR
      SAME_CLASS_DISSIMILAR],
     :attributedItems
     [{:distance number, :annotationResourceName string}],
     :outlierThreshold number}],
   :groundTruths [any]}]}"
  [parent
   GoogleCloudAiplatformV1BatchImportEvaluatedAnnotationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}:batchImport",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1BatchImportEvaluatedAnnotationsRequest}))

(defn projects-locations-models-evaluations-slices-list
  "Lists ModelEvaluationSlices in a ModelEvaluation.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the ModelEvaluation to list the ModelEvaluationSlices from. Format: `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}`

optional:
filter <string> The standard list filter. * `slice.dimension` - for =.
readMask <string> Mask specifying which fields to read.
pageSize <integer> The standard list page size."
  ([parent]
    (projects-locations-models-evaluations-slices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/slices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-evaluations-slices-get
  "Gets a ModelEvaluationSlice.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the ModelEvaluationSlice resource. Format: `projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-evaluations-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-models-evaluations-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-models-evaluations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-evaluations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-evaluations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-models-evaluations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-models-evaluations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-customJobs-list
  "Lists CustomJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the CustomJobs from. Format: `projects/{project}/locations/{location}`

optional:
filter <string> The standard list filter. Supported fields: * `display_name` supports `=`, `!=` comparisons, and `:` wildcard. * `state` supports `=`, `!=` comparisons. * `create_time` supports `=`, `!=`,`<`, `<=`,`>`, `>=` comparisons. `create_time` must be in RFC 3339 format. * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* - key existence Some examples of using the filter are: * `state=\"JOB_STATE_SUCCEEDED\" AND display_name:\"my_job_*\"` * `state!=\"JOB_STATE_FAILED\" OR display_name=\"my_job\"` * `NOT display_name=\"my_job\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `labels.keyA=valueA` * `labels.keyB:*`
readMask <string> Mask specifying which fields to read.
pageSize <integer> The standard list page size."
  ([parent] (projects-locations-customJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/customJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-customJobs-create
  "Creates a CustomJob. A created CustomJob right away will be attempted to be run.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the CustomJob in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1CustomJob:
{:labels object,
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :name string,
 :jobSpec
 {:serviceAccount string,
  :protectedArtifactLocationId string,
  :enableWebAccess boolean,
  :scheduling
  {:timeout string,
   :disableRetries boolean,
   :restartJobOnWorkerRestart boolean},
  :enableDashboardAccess boolean,
  :experimentRun string,
  :persistentResourceId string,
  :tensorboard string,
  :workerPoolSpecs
  [{:pythonPackageSpec
    {:executorImageUri string,
     :pythonModule string,
     :args [string],
     :packageUris [string],
     :env [{:value string, :name string}]},
    :nfsMounts [{:server string, :mountPoint string, :path string}],
    :replicaCount string,
    :diskSpec {:bootDiskType string, :bootDiskSizeGb integer},
    :containerSpec
    {:command [string],
     :args [string],
     :env [{:value string, :name string}],
     :imageUri string},
    :machineSpec
    {:acceleratorCount integer,
     :machineType string,
     :acceleratorType
     [ACCELERATOR_TYPE_UNSPECIFIED
      NVIDIA_TESLA_K80
      NVIDIA_TESLA_P100
      NVIDIA_TESLA_V100
      NVIDIA_TESLA_P4
      NVIDIA_TESLA_T4
      NVIDIA_TESLA_A100
      NVIDIA_A100_80GB
      NVIDIA_L4
      NVIDIA_H100_80GB
      TPU_V2
      TPU_V3
      TPU_V4_POD
      TPU_V5_LITEPOD],
     :tpuTopology string}}],
  :reservedIpRanges [string],
  :baseOutputDirectory {:outputUriPrefix string},
  :experiment string,
  :models [string],
  :network string},
 :endTime string,
 :createTime string,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :updateTime string,
 :webAccessUris object,
 :error {:message string, :code integer, :details [object]}}"
  [parent GoogleCloudAiplatformV1CustomJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/customJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CustomJob}))

(defn projects-locations-customJobs-get
  "Gets a CustomJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the CustomJob resource. Format: `projects/{project}/locations/{location}/customJobs/{custom_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-customJobs-cancel
  "Cancels a CustomJob. Starts asynchronous cancellation on the CustomJob. The server makes a best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetCustomJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On successful cancellation, the CustomJob is not deleted; instead it becomes a job with a CustomJob.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`, and CustomJob.state is set to `CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the CustomJob to cancel. Format: `projects/{project}/locations/{location}/customJobs/{custom_job}`
GoogleCloudAiplatformV1CancelCustomJobRequest:
object"
  [name GoogleCloudAiplatformV1CancelCustomJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CancelCustomJobRequest}))

(defn projects-locations-customJobs-delete
  "Deletes a CustomJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the CustomJob resource to be deleted. Format: `projects/{project}/locations/{location}/customJobs/{custom_job}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-customJobs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-customJobs-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-customJobs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-customJobs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-customJobs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (projects-locations-customJobs-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-customJobs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-specialistPools-get
  "Gets a SpecialistPool.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the SpecialistPool resource. The form is `projects/{project}/locations/{location}/specialistPools/{specialist_pool}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-specialistPools-patch
  "Updates a SpecialistPool.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the SpecialistPool.
GoogleCloudAiplatformV1SpecialistPool:
{:pendingDataLabelingJobs [string],
 :specialistManagerEmails [string],
 :specialistManagersCount integer,
 :specialistWorkerEmails [string],
 :displayName string,
 :name string}

optional:
updateMask <string> Required. The update mask applies to the resource."
  ([name GoogleCloudAiplatformV1SpecialistPool]
    (projects-locations-specialistPools-patch
      name
      GoogleCloudAiplatformV1SpecialistPool
      nil))
  ([name GoogleCloudAiplatformV1SpecialistPool optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1SpecialistPool})))

(defn projects-locations-specialistPools-list
  "Lists SpecialistPools in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the SpecialistPool's parent resource. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read. FieldMask represents a set of
pageSize <integer> The standard list page size."
  ([parent] (projects-locations-specialistPools-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/specialistPools",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-specialistPools-delete
  "Deletes a SpecialistPool as well as all Specialists in the pool.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the SpecialistPool to delete. Format: `projects/{project}/locations/{location}/specialistPools/{specialist_pool}`

optional:
force <boolean> If set to true, any specialist managers in this SpecialistPool will also be deleted. (Otherwise, the request will only work if the SpecialistPool has no specialist managers.)"
  ([name] (projects-locations-specialistPools-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-specialistPools-create
  "Creates a SpecialistPool.
https://cloud.google.com/vertex-ai

parent <string> Required. The parent Project name for the new SpecialistPool. The form is `projects/{project}/locations/{location}`.
GoogleCloudAiplatformV1SpecialistPool:
{:pendingDataLabelingJobs [string],
 :specialistManagerEmails [string],
 :specialistManagersCount integer,
 :specialistWorkerEmails [string],
 :displayName string,
 :name string}"
  [parent GoogleCloudAiplatformV1SpecialistPool]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/specialistPools",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1SpecialistPool}))

(defn projects-locations-specialistPools-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-specialistPools-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-specialistPools-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-specialistPools-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-specialistPools-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-specialistPools-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-specialistPools-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-get
  "Gets a Study by name.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Study resource. Format: `projects/{project}/locations/{location}/studies/{study}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-delete
  "Deletes a Study.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Study resource to be deleted. Format: `projects/{project}/locations/{location}/studies/{study}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-lookup
  "Looks a study up using the user-defined display_name field instead of the fully qualified resource name.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to get the Study from. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1LookupStudyRequest:
{:displayName string}"
  [parent GoogleCloudAiplatformV1LookupStudyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/studies:lookup",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1LookupStudyRequest}))

(defn projects-locations-studies-list
  "Lists all the studies in a region for an associated project.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the Study from. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> Optional. The maximum number of studies to return per \"page\" of results. If unspecified, service will pick an appropriate default."
  ([parent] (projects-locations-studies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/studies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-studies-create
  "Creates a Study. A resource name will be generated after creation of the Study.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the CustomJob in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1Study:
{:studySpec
 {:algorithm [ALGORITHM_UNSPECIFIED GRID_SEARCH RANDOM_SEARCH],
  :measurementSelectionType
  [MEASUREMENT_SELECTION_TYPE_UNSPECIFIED
   LAST_MEASUREMENT
   BEST_MEASUREMENT],
  :observationNoise [OBSERVATION_NOISE_UNSPECIFIED LOW HIGH],
  :studyStoppingConfig
  {:maxNumTrials integer,
   :maxDurationNoProgress string,
   :minNumTrials integer,
   :maximumRuntimeConstraint {:endTime string, :maxDuration string},
   :shouldStopAsap boolean,
   :maxNumTrialsNoProgress integer,
   :minimumRuntimeConstraint {:endTime string, :maxDuration string}},
  :decayCurveStoppingSpec {:useElapsedDuration boolean},
  :medianAutomatedStoppingSpec {:useElapsedDuration boolean},
  :parameters
  [{:discreteValueSpec {:defaultValue number, :values [number]},
    :categoricalValueSpec {:defaultValue string, :values [string]},
    :parameterId string,
    :conditionalParameterSpecs
    [{:parentCategoricalValues {:values [string]},
      :parentIntValues {:values [string]},
      :parentDiscreteValues {:values [number]},
      :parameterSpec
      {:discreteValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecDiscreteValueSpec,
       :categoricalValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecCategoricalValueSpec,
       :parameterId string,
       :conditionalParameterSpecs
       [GoogleCloudAiplatformV1StudySpecParameterSpecConditionalParameterSpec],
       :doubleValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecDoubleValueSpec,
       :scaleType
       [SCALE_TYPE_UNSPECIFIED
        UNIT_LINEAR_SCALE
        UNIT_LOG_SCALE
        UNIT_REVERSE_LOG_SCALE],
       :integerValueSpec
       GoogleCloudAiplatformV1StudySpecParameterSpecIntegerValueSpec}}],
    :doubleValueSpec
    {:defaultValue number, :minValue number, :maxValue number},
    :scaleType
    [SCALE_TYPE_UNSPECIFIED
     UNIT_LINEAR_SCALE
     UNIT_LOG_SCALE
     UNIT_REVERSE_LOG_SCALE],
    :integerValueSpec
    {:maxValue string, :minValue string, :defaultValue string}}],
  :convexAutomatedStoppingSpec
  {:learningRateParameterName string,
   :minStepCount string,
   :updateAllStoppedTrials boolean,
   :useElapsedDuration boolean,
   :minMeasurementCount string,
   :maxStepCount string},
  :metrics
  [{:safetyConfig
    {:safetyThreshold number, :desiredMinSafeTrialsFraction number},
    :goal [GOAL_TYPE_UNSPECIFIED MAXIMIZE MINIMIZE],
    :metricId string}]},
 :state [STATE_UNSPECIFIED ACTIVE INACTIVE COMPLETED],
 :name string,
 :displayName string,
 :inactiveReason string,
 :createTime string}"
  [parent GoogleCloudAiplatformV1Study]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/studies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1Study}))

(defn projects-locations-studies-trials-get
  "Gets a Trial.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Trial resource. Format: `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-trials-create
  "Adds a user provided Trial to a Study.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Study to create the Trial in. Format: `projects/{project}/locations/{location}/studies/{study}`
GoogleCloudAiplatformV1Trial:
{:clientId string,
 :customJob string,
 :startTime string,
 :measurements
 [{:metrics [{:value number, :metricId string}],
   :elapsedDuration string,
   :stepCount string}],
 :name string,
 :endTime string,
 :state
 [STATE_UNSPECIFIED REQUESTED ACTIVE STOPPING SUCCEEDED INFEASIBLE],
 :id string,
 :finalMeasurement
 {:metrics [{:value number, :metricId string}],
  :elapsedDuration string,
  :stepCount string},
 :infeasibleReason string,
 :webAccessUris object,
 :parameters [{:parameterId string, :value any}]}"
  [parent GoogleCloudAiplatformV1Trial]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/trials",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1Trial}))

(defn projects-locations-studies-trials-delete
  "Deletes a Trial.
https://cloud.google.com/vertex-ai

name <string> Required. The Trial's name. Format: `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-trials-listOptimalTrials
  "Lists the pareto-optimal Trials for multi-objective Study or the optimal Trials for single-objective Study. The definition of pareto-optimal can be checked in wiki page. https://en.wikipedia.org/wiki/Pareto_efficiency
https://cloud.google.com/vertex-ai

parent <string> Required. The name of the Study that the optimal Trial belongs to.
GoogleCloudAiplatformV1ListOptimalTrialsRequest:
object"
  [parent GoogleCloudAiplatformV1ListOptimalTrialsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/trials:listOptimalTrials",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ListOptimalTrialsRequest}))

(defn projects-locations-studies-trials-stop
  "Stops a Trial.
https://cloud.google.com/vertex-ai

name <string> Required. The Trial's name. Format: `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
GoogleCloudAiplatformV1StopTrialRequest:
object"
  [name GoogleCloudAiplatformV1StopTrialRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}:stop",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1StopTrialRequest}))

(defn projects-locations-studies-trials-suggest
  "Adds one or more Trials to a Study, with parameter values suggested by Vertex AI Vizier. Returns a long-running operation associated with the generation of Trial suggestions. When this long-running operation succeeds, it will contain a SuggestTrialsResponse.
https://cloud.google.com/vertex-ai

parent <string> Required. The project and location that the Study belongs to. Format: `projects/{project}/locations/{location}/studies/{study}`
GoogleCloudAiplatformV1SuggestTrialsRequest:
{:contexts
 [{:description string,
   :parameters [{:parameterId string, :value any}]}],
 :clientId string,
 :suggestionCount integer}"
  [parent GoogleCloudAiplatformV1SuggestTrialsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/trials:suggest",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1SuggestTrialsRequest}))

(defn projects-locations-studies-trials-list
  "Lists the Trials associated with a Study.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Study to list the Trial from. Format: `projects/{project}/locations/{location}/studies/{study}`

optional:
pageSize <integer> Optional. The number of Trials to retrieve per \"page\" of results. If unspecified, the service will pick an appropriate default."
  ([parent] (projects-locations-studies-trials-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/trials",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-studies-trials-checkTrialEarlyStoppingState
  "Checks whether a Trial should stop or not. Returns a long-running operation. When the operation is successful, it will contain a CheckTrialEarlyStoppingStateResponse.
https://cloud.google.com/vertex-ai

trialName <string> Required. The Trial's name. Format: `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
GoogleCloudAiplatformV1CheckTrialEarlyStoppingStateRequest:
object"
  [trialName
   GoogleCloudAiplatformV1CheckTrialEarlyStoppingStateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+trialName}:checkTrialEarlyStoppingState",
     :uri-template-args {:trialName trialName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CheckTrialEarlyStoppingStateRequest}))

(defn projects-locations-studies-trials-complete
  "Marks a Trial as complete.
https://cloud.google.com/vertex-ai

name <string> Required. The Trial's name. Format: `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
GoogleCloudAiplatformV1CompleteTrialRequest:
{:finalMeasurement
 {:metrics [{:value number, :metricId string}],
  :elapsedDuration string,
  :stepCount string},
 :trialInfeasible boolean,
 :infeasibleReason string}"
  [name GoogleCloudAiplatformV1CompleteTrialRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:complete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CompleteTrialRequest}))

(defn projects-locations-studies-trials-addTrialMeasurement
  "Adds a measurement of the objective metrics to a Trial. This measurement is assumed to have been taken before the Trial is complete.
https://cloud.google.com/vertex-ai

trialName <string> Required. The name of the trial to add measurement. Format: `projects/{project}/locations/{location}/studies/{study}/trials/{trial}`
GoogleCloudAiplatformV1AddTrialMeasurementRequest:
{:measurement
 {:metrics [{:value number, :metricId string}],
  :elapsedDuration string,
  :stepCount string}}"
  [trialName GoogleCloudAiplatformV1AddTrialMeasurementRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+trialName}:addTrialMeasurement",
     :uri-template-args {:trialName trialName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1AddTrialMeasurementRequest}))

(defn projects-locations-studies-trials-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-studies-trials-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-studies-trials-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-trials-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (projects-locations-studies-trials-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-studies-trials-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-trials-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-studies-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-studies-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-studies-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-studies-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimeTemplates-patch
  "Updates a NotebookRuntimeTemplate.
https://cloud.google.com/vertex-ai

name <string> The resource name of the NotebookRuntimeTemplate.
GoogleCloudAiplatformV1NotebookRuntimeTemplate:
{:description string,
 :serviceAccount string,
 :machineSpec
 {:acceleratorCount integer,
  :machineType string,
  :acceleratorType
  [ACCELERATOR_TYPE_UNSPECIFIED
   NVIDIA_TESLA_K80
   NVIDIA_TESLA_P100
   NVIDIA_TESLA_V100
   NVIDIA_TESLA_P4
   NVIDIA_TESLA_T4
   NVIDIA_TESLA_A100
   NVIDIA_A100_80GB
   NVIDIA_L4
   NVIDIA_H100_80GB
   TPU_V2
   TPU_V3
   TPU_V4_POD
   TPU_V5_LITEPOD],
  :tpuTopology string},
 :labels object,
 :isDefault boolean,
 :encryptionSpec {:kmsKeyName string},
 :idleShutdownConfig
 {:idleTimeout string, :idleShutdownDisabled boolean},
 :networkSpec
 {:enableInternetAccess boolean, :network string, :subnetwork string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :notebookRuntimeType
 [NOTEBOOK_RUNTIME_TYPE_UNSPECIFIED USER_DEFINED ONE_CLICK],
 :updateTime string,
 :dataPersistentDiskSpec {:diskSizeGb string, :diskType string},
 :eucConfig {:bypassActasCheck boolean, :eucDisabled boolean},
 :networkTags [string],
 :shieldedVmConfig {:enableSecureBoot boolean}}

optional:
updateMask <string> Required. The update mask applies to the resource. For the `FieldMask` definition, see google.protobuf.FieldMask. Input format: `{paths: \"${updated_filed}\"}` Updatable fields: * `encryption_spec.kms_key_name`"
  ([name GoogleCloudAiplatformV1NotebookRuntimeTemplate]
    (projects-locations-notebookRuntimeTemplates-patch
      name
      GoogleCloudAiplatformV1NotebookRuntimeTemplate
      nil))
  ([name GoogleCloudAiplatformV1NotebookRuntimeTemplate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1NotebookRuntimeTemplate})))

(defn projects-locations-notebookRuntimeTemplates-delete
  "Deletes a NotebookRuntimeTemplate.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NotebookRuntimeTemplate resource to be deleted. Format: `projects/{project}/locations/{location}/notebookRuntimeTemplates/{notebook_runtime_template}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimeTemplates-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
{:policy
 {:bindings
  [{:role string,
    :condition
    {:title string,
     :description string,
     :expression string,
     :location string},
    :members [string]}],
  :etag string,
  :version integer}}"
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-notebookRuntimeTemplates-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
permissions <string> The set of permissions to check for the `resource`. Permissions with wildcards (such as `*` or `storage.*`) are not allowed. For more information see [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions)."
  ([resource]
    (projects-locations-notebookRuntimeTemplates-testIamPermissions
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:testIamPermissions",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimeTemplates-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-notebookRuntimeTemplates-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimeTemplates-create
  "Creates a NotebookRuntimeTemplate.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the NotebookRuntimeTemplate. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1NotebookRuntimeTemplate:
{:description string,
 :serviceAccount string,
 :machineSpec
 {:acceleratorCount integer,
  :machineType string,
  :acceleratorType
  [ACCELERATOR_TYPE_UNSPECIFIED
   NVIDIA_TESLA_K80
   NVIDIA_TESLA_P100
   NVIDIA_TESLA_V100
   NVIDIA_TESLA_P4
   NVIDIA_TESLA_T4
   NVIDIA_TESLA_A100
   NVIDIA_A100_80GB
   NVIDIA_L4
   NVIDIA_H100_80GB
   TPU_V2
   TPU_V3
   TPU_V4_POD
   TPU_V5_LITEPOD],
  :tpuTopology string},
 :labels object,
 :isDefault boolean,
 :encryptionSpec {:kmsKeyName string},
 :idleShutdownConfig
 {:idleTimeout string, :idleShutdownDisabled boolean},
 :networkSpec
 {:enableInternetAccess boolean, :network string, :subnetwork string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :notebookRuntimeType
 [NOTEBOOK_RUNTIME_TYPE_UNSPECIFIED USER_DEFINED ONE_CLICK],
 :updateTime string,
 :dataPersistentDiskSpec {:diskSizeGb string, :diskType string},
 :eucConfig {:bypassActasCheck boolean, :eucDisabled boolean},
 :networkTags [string],
 :shieldedVmConfig {:enableSecureBoot boolean}}

optional:
notebookRuntimeTemplateId <string> Optional. User specified ID for the notebook runtime template."
  ([parent GoogleCloudAiplatformV1NotebookRuntimeTemplate]
    (projects-locations-notebookRuntimeTemplates-create
      parent
      GoogleCloudAiplatformV1NotebookRuntimeTemplate
      nil))
  ([parent GoogleCloudAiplatformV1NotebookRuntimeTemplate optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/notebookRuntimeTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1NotebookRuntimeTemplate})))

(defn projects-locations-notebookRuntimeTemplates-list
  "Lists NotebookRuntimeTemplates in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location from which to list the NotebookRuntimeTemplates. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Optional. Mask specifying which fields to read.
pageSize <integer> Optional. The standard list page size.
filter <string> Optional. An expression for filtering the results of the request. For field names both snake_case and camelCase are supported. * `notebookRuntimeTemplate` supports = and !=. `notebookRuntimeTemplate` represents the NotebookRuntimeTemplate ID, i.e. the last segment of the NotebookRuntimeTemplate's resource name. * `display_name` supports = and != * `labels` supports general map functions that is: * `labels.key=value` - key:value equality * `labels.key:* or labels:key - key existence * A key including a space must be quoted. `labels.\"a key\"`. * `notebookRuntimeType` supports = and !=. notebookRuntimeType enum: [USER_DEFINED, ONE_CLICK]. Some examples: * `notebookRuntimeTemplate=notebookRuntimeTemplate123` * `displayName=\"myDisplayName\"` * `labels.myKey=\"myValue\"` * `notebookRuntimeType=USER_DEFINED`
orderBy <string> Optional. A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `display_name` * `create_time` * `update_time` Example: `display_name, create_time desc`."
  ([parent]
    (projects-locations-notebookRuntimeTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/notebookRuntimeTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimeTemplates-get
  "Gets a NotebookRuntimeTemplate.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the NotebookRuntimeTemplate resource. Format: `projects/{project}/locations/{location}/notebookRuntimeTemplates/{notebook_runtime_template}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimeTemplates-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimeTemplates-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notebookRuntimeTemplates-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-notebookRuntimeTemplates-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimeTemplates-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-notebookRuntimeTemplates-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notebookRuntimeTemplates-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-readSize
  "Returns the storage size for a given TensorBoard instance.
https://cloud.google.com/vertex-ai

tensorboard <string> Required. The name of the Tensorboard resource. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`"
  [tensorboard]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+tensorboard}:readSize",
     :uri-template-args {:tensorboard tensorboard},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-batchRead
  "Reads multiple TensorboardTimeSeries' data. The data point number limit is 1000 for scalars, 100 for tensors and blob references. If the number of data points stored is less than the limit, all data is returned. Otherwise, the number limit of data points is randomly selected from this time series and returned.
https://cloud.google.com/vertex-ai

tensorboard <string> Required. The resource name of the Tensorboard containing TensorboardTimeSeries to read data from. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`. The TensorboardTimeSeries referenced by time_series must be sub resources of this Tensorboard.

optional:
timeSeries <string> Required. The resource names of the TensorboardTimeSeries to read data from. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`"
  ([tensorboard]
    (projects-locations-tensorboards-batchRead tensorboard nil))
  ([tensorboard optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+tensorboard}:batchRead",
       :uri-template-args {:tensorboard tensorboard},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-patch
  "Updates a Tensorboard.
https://cloud.google.com/vertex-ai

name <string> Output only. Name of the Tensorboard. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
GoogleCloudAiplatformV1Tensorboard:
{:description string,
 :labels object,
 :isDefault boolean,
 :runCount integer,
 :encryptionSpec {:kmsKeyName string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :blobStoragePathPrefix string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Tensorboard resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field is overwritten if it's in the mask. If the user does not provide a mask then all fields are overwritten if new values are specified."
  ([name GoogleCloudAiplatformV1Tensorboard]
    (projects-locations-tensorboards-patch
      name
      GoogleCloudAiplatformV1Tensorboard
      nil))
  ([name GoogleCloudAiplatformV1Tensorboard optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Tensorboard})))

(defn projects-locations-tensorboards-readUsage
  "Returns a list of monthly active users for a given TensorBoard instance.
https://cloud.google.com/vertex-ai

tensorboard <string> Required. The name of the Tensorboard resource. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`"
  [tensorboard]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+tensorboard}:readUsage",
     :uri-template-args {:tensorboard tensorboard},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-list
  "Lists Tensorboards in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list Tensorboards. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read.
filter <string> Lists the Tensorboards that match the filter expression.
pageSize <integer> The maximum number of Tensorboards to return. The service may return fewer than this value. If unspecified, at most 100 Tensorboards are returned. The maximum value is 100; values above 100 are coerced to 100.
orderBy <string> Field to use to sort the list."
  ([parent] (projects-locations-tensorboards-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/tensorboards",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-tensorboards-create
  "Creates a Tensorboard.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the Tensorboard in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1Tensorboard:
{:description string,
 :labels object,
 :isDefault boolean,
 :runCount integer,
 :encryptionSpec {:kmsKeyName string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :blobStoragePathPrefix string}"
  [parent GoogleCloudAiplatformV1Tensorboard]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/tensorboards",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1Tensorboard}))

(defn projects-locations-tensorboards-delete
  "Deletes a Tensorboard.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Tensorboard to be deleted. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-get
  "Gets a Tensorboard.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Tensorboard resource. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-tensorboards-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-tensorboards-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-tensorboards-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-list
  "Lists TensorboardExperiments in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Tensorboard to list TensorboardExperiments. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`

optional:
orderBy <string> Field to use to sort the list.
readMask <string> Mask specifying which fields to read.
filter <string> Lists the TensorboardExperiments that match the filter expression.
pageSize <integer> The maximum number of TensorboardExperiments to return. The service may return fewer than this value. If unspecified, at most 50 TensorboardExperiments are returned. The maximum value is 1000; values above 1000 are coerced to 1000."
  ([parent]
    (projects-locations-tensorboards-experiments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/experiments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-tensorboards-experiments-delete
  "Deletes a TensorboardExperiment.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TensorboardExperiment to be deleted. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-patch
  "Updates a TensorboardExperiment.
https://cloud.google.com/vertex-ai

name <string> Output only. Name of the TensorboardExperiment. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
GoogleCloudAiplatformV1TensorboardExperiment:
{:description string,
 :name string,
 :displayName string,
 :updateTime string,
 :labels object,
 :source string,
 :createTime string,
 :etag string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the TensorboardExperiment resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field is overwritten if it's in the mask. If the user does not provide a mask then all fields are overwritten if new values are specified."
  ([name GoogleCloudAiplatformV1TensorboardExperiment]
    (projects-locations-tensorboards-experiments-patch
      name
      GoogleCloudAiplatformV1TensorboardExperiment
      nil))
  ([name GoogleCloudAiplatformV1TensorboardExperiment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1TensorboardExperiment})))

(defn projects-locations-tensorboards-experiments-create
  "Creates a TensorboardExperiment.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Tensorboard to create the TensorboardExperiment in. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}`
GoogleCloudAiplatformV1TensorboardExperiment:
{:description string,
 :name string,
 :displayName string,
 :updateTime string,
 :labels object,
 :source string,
 :createTime string,
 :etag string}

optional:
tensorboardExperimentId <string> Required. The ID to use for the Tensorboard experiment, which becomes the final component of the Tensorboard experiment's resource name. This value should be 1-128 characters, and valid characters are `/a-z-/`."
  ([parent GoogleCloudAiplatformV1TensorboardExperiment]
    (projects-locations-tensorboards-experiments-create
      parent
      GoogleCloudAiplatformV1TensorboardExperiment
      nil))
  ([parent GoogleCloudAiplatformV1TensorboardExperiment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/experiments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1TensorboardExperiment})))

(defn projects-locations-tensorboards-experiments-write
  "Write time series data points of multiple TensorboardTimeSeries in multiple TensorboardRun's. If any data fail to be ingested, an error is returned.
https://cloud.google.com/vertex-ai

tensorboardExperiment <string> Required. The resource name of the TensorboardExperiment to write data to. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
GoogleCloudAiplatformV1WriteTensorboardExperimentDataRequest:
{:writeRunDataRequests
 [{:timeSeriesData
   [{:valueType [VALUE_TYPE_UNSPECIFIED SCALAR TENSOR BLOB_SEQUENCE],
     :tensorboardTimeSeriesId string,
     :values
     [{:blobs {:values [GoogleCloudAiplatformV1TensorboardBlob]},
       :step string,
       :scalar {:value number},
       :wallTime string,
       :tensor {:value string, :versionNumber integer}}]}],
   :tensorboardRun string}]}"
  [tensorboardExperiment
   GoogleCloudAiplatformV1WriteTensorboardExperimentDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+tensorboardExperiment}:write",
     :uri-template-args {:tensorboardExperiment tensorboardExperiment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1WriteTensorboardExperimentDataRequest}))

(defn projects-locations-tensorboards-experiments-batchCreate
  "Batch create TensorboardTimeSeries that belong to a TensorboardExperiment.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the TensorboardExperiment to create the TensorboardTimeSeries in. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}` The TensorboardRuns referenced by the parent fields in the CreateTensorboardTimeSeriesRequest messages must be sub resources of this TensorboardExperiment.
GoogleCloudAiplatformV1BatchCreateTensorboardTimeSeriesRequest:
{:requests
 [{:tensorboardTimeSeries
   {:description string,
    :valueType [VALUE_TYPE_UNSPECIFIED SCALAR TENSOR BLOB_SEQUENCE],
    :displayName string,
    :name string,
    :createTime string,
    :etag string,
    :pluginData string,
    :updateTime string,
    :pluginName string,
    :metadata
    {:maxBlobSequenceLength string,
     :maxStep string,
     :maxWallTime string}},
   :tensorboardTimeSeriesId string,
   :parent string}]}"
  [parent
   GoogleCloudAiplatformV1BatchCreateTensorboardTimeSeriesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1BatchCreateTensorboardTimeSeriesRequest}))

(defn projects-locations-tensorboards-experiments-get
  "Gets a TensorboardExperiment.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TensorboardExperiment resource. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-tensorboards-experiments-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-tensorboards-experiments-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-experiments-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-tensorboards-experiments-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-experiments-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-patch
  "Updates a TensorboardRun.
https://cloud.google.com/vertex-ai

name <string> Output only. Name of the TensorboardRun. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
GoogleCloudAiplatformV1TensorboardRun:
{:description string,
 :etag string,
 :labels object,
 :name string,
 :updateTime string,
 :createTime string,
 :displayName string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the TensorboardRun resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field is overwritten if it's in the mask. If the user does not provide a mask then all fields are overwritten if new values are specified."
  ([name GoogleCloudAiplatformV1TensorboardRun]
    (projects-locations-tensorboards-experiments-runs-patch
      name
      GoogleCloudAiplatformV1TensorboardRun
      nil))
  ([name GoogleCloudAiplatformV1TensorboardRun optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1TensorboardRun})))

(defn projects-locations-tensorboards-experiments-runs-list
  "Lists TensorboardRuns in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the TensorboardExperiment to list TensorboardRuns. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`

optional:
pageSize <integer> The maximum number of TensorboardRuns to return. The service may return fewer than this value. If unspecified, at most 50 TensorboardRuns are returned. The maximum value is 1000; values above 1000 are coerced to 1000.
filter <string> Lists the TensorboardRuns that match the filter expression.
readMask <string> Mask specifying which fields to read.
orderBy <string> Field to use to sort the list."
  ([parent]
    (projects-locations-tensorboards-experiments-runs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/runs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-tensorboards-experiments-runs-batchCreate
  "Batch create TensorboardRuns.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the TensorboardExperiment to create the TensorboardRuns in. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}` The parent field in the CreateTensorboardRunRequest messages must match this field.
GoogleCloudAiplatformV1BatchCreateTensorboardRunsRequest:
{:requests
 [{:tensorboardRunId string,
   :tensorboardRun
   {:description string,
    :etag string,
    :labels object,
    :name string,
    :updateTime string,
    :createTime string,
    :displayName string},
   :parent string}]}"
  [parent GoogleCloudAiplatformV1BatchCreateTensorboardRunsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/runs:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1BatchCreateTensorboardRunsRequest}))

(defn projects-locations-tensorboards-experiments-runs-create
  "Creates a TensorboardRun.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the TensorboardExperiment to create the TensorboardRun in. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}`
GoogleCloudAiplatformV1TensorboardRun:
{:description string,
 :etag string,
 :labels object,
 :name string,
 :updateTime string,
 :createTime string,
 :displayName string}

optional:
tensorboardRunId <string> Required. The ID to use for the Tensorboard run, which becomes the final component of the Tensorboard run's resource name. This value should be 1-128 characters, and valid characters are `/a-z-/`."
  ([parent GoogleCloudAiplatformV1TensorboardRun]
    (projects-locations-tensorboards-experiments-runs-create
      parent
      GoogleCloudAiplatformV1TensorboardRun
      nil))
  ([parent GoogleCloudAiplatformV1TensorboardRun optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/runs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1TensorboardRun})))

(defn projects-locations-tensorboards-experiments-runs-write
  "Write time series data points into multiple TensorboardTimeSeries under a TensorboardRun. If any data fail to be ingested, an error is returned.
https://cloud.google.com/vertex-ai

tensorboardRun <string> Required. The resource name of the TensorboardRun to write data to. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
GoogleCloudAiplatformV1WriteTensorboardRunDataRequest:
{:timeSeriesData
 [{:valueType [VALUE_TYPE_UNSPECIFIED SCALAR TENSOR BLOB_SEQUENCE],
   :tensorboardTimeSeriesId string,
   :values
   [{:blobs {:values [{:id string, :data string}]},
     :step string,
     :scalar {:value number},
     :wallTime string,
     :tensor {:value string, :versionNumber integer}}]}],
 :tensorboardRun string}"
  [tensorboardRun
   GoogleCloudAiplatformV1WriteTensorboardRunDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+tensorboardRun}:write",
     :uri-template-args {:tensorboardRun tensorboardRun},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1WriteTensorboardRunDataRequest}))

(defn projects-locations-tensorboards-experiments-runs-get
  "Gets a TensorboardRun.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TensorboardRun resource. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-tensorboards-experiments-runs-delete
  "Deletes a TensorboardRun.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TensorboardRun to be deleted. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-delete
  "Deletes a TensorboardTimeSeries.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TensorboardTimeSeries to be deleted. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-readBlobData
  "Gets bytes of TensorboardBlobs. This is to allow reading blob data stored in consumer project's Cloud Storage bucket without users having to obtain Cloud Storage access permission.
https://cloud.google.com/vertex-ai

timeSeries <string> Required. The resource name of the TensorboardTimeSeries to list Blobs. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`

optional:
blobIds <string> IDs of the blobs to read."
  ([timeSeries]
    (projects-locations-tensorboards-experiments-runs-timeSeries-readBlobData
      timeSeries
      nil))
  ([timeSeries optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+timeSeries}:readBlobData",
       :uri-template-args {:timeSeries timeSeries},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-list
  "Lists TensorboardTimeSeries in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the TensorboardRun to list TensorboardTimeSeries. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`

optional:
orderBy <string> Field to use to sort the list.
filter <string> Lists the TensorboardTimeSeries that match the filter expression.
pageSize <integer> The maximum number of TensorboardTimeSeries to return. The service may return fewer than this value. If unspecified, at most 50 TensorboardTimeSeries are returned. The maximum value is 1000; values above 1000 are coerced to 1000.
readMask <string> Mask specifying which fields to read."
  ([parent]
    (projects-locations-tensorboards-experiments-runs-timeSeries-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/timeSeries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-create
  "Creates a TensorboardTimeSeries.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the TensorboardRun to create the TensorboardTimeSeries in. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}`
GoogleCloudAiplatformV1TensorboardTimeSeries:
{:description string,
 :valueType [VALUE_TYPE_UNSPECIFIED SCALAR TENSOR BLOB_SEQUENCE],
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :pluginData string,
 :updateTime string,
 :pluginName string,
 :metadata
 {:maxBlobSequenceLength string, :maxStep string, :maxWallTime string}}

optional:
tensorboardTimeSeriesId <string> Optional. The user specified unique ID to use for the TensorboardTimeSeries, which becomes the final component of the TensorboardTimeSeries's resource name. This value should match \"a-z0-9{0, 127}\""
  ([parent GoogleCloudAiplatformV1TensorboardTimeSeries]
    (projects-locations-tensorboards-experiments-runs-timeSeries-create
      parent
      GoogleCloudAiplatformV1TensorboardTimeSeries
      nil))
  ([parent GoogleCloudAiplatformV1TensorboardTimeSeries optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/timeSeries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1TensorboardTimeSeries})))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-read
  "Reads a TensorboardTimeSeries' data. By default, if the number of data points stored is less than 1000, all data is returned. Otherwise, 1000 data points is randomly selected from this time series and returned. This value can be changed by changing max_data_points, which can't be greater than 10k.
https://cloud.google.com/vertex-ai

tensorboardTimeSeries <string> Required. The resource name of the TensorboardTimeSeries to read data from. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`

optional:
maxDataPoints <integer> The maximum number of TensorboardTimeSeries' data to return. This value should be a positive integer. This value can be set to -1 to return all data.
filter <string> Reads the TensorboardTimeSeries' data that match the filter expression."
  ([tensorboardTimeSeries]
    (projects-locations-tensorboards-experiments-runs-timeSeries-read
      tensorboardTimeSeries
      nil))
  ([tensorboardTimeSeries optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+tensorboardTimeSeries}:read",
       :uri-template-args
       {:tensorboardTimeSeries tensorboardTimeSeries},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-get
  "Gets a TensorboardTimeSeries.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the TensorboardTimeSeries resource. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-patch
  "Updates a TensorboardTimeSeries.
https://cloud.google.com/vertex-ai

name <string> Output only. Name of the TensorboardTimeSeries.
GoogleCloudAiplatformV1TensorboardTimeSeries:
{:description string,
 :valueType [VALUE_TYPE_UNSPECIFIED SCALAR TENSOR BLOB_SEQUENCE],
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :pluginData string,
 :updateTime string,
 :pluginName string,
 :metadata
 {:maxBlobSequenceLength string, :maxStep string, :maxWallTime string}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the TensorboardTimeSeries resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field is overwritten if it's in the mask. If the user does not provide a mask then all fields are overwritten if new values are specified."
  ([name GoogleCloudAiplatformV1TensorboardTimeSeries]
    (projects-locations-tensorboards-experiments-runs-timeSeries-patch
      name
      GoogleCloudAiplatformV1TensorboardTimeSeries
      nil))
  ([name GoogleCloudAiplatformV1TensorboardTimeSeries optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1TensorboardTimeSeries})))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-exportTensorboardTimeSeries
  "Exports a TensorboardTimeSeries' data. Data is returned in paginated responses.
https://cloud.google.com/vertex-ai

tensorboardTimeSeries <string> Required. The resource name of the TensorboardTimeSeries to export data from. Format: `projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}`
GoogleCloudAiplatformV1ExportTensorboardTimeSeriesDataRequest:
{:pageSize integer, :orderBy string, :pageToken string, :filter string}"
  [tensorboardTimeSeries
   GoogleCloudAiplatformV1ExportTensorboardTimeSeriesDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+tensorboardTimeSeries}:exportTensorboardTimeSeries",
     :uri-template-args {:tensorboardTimeSeries tensorboardTimeSeries},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1ExportTensorboardTimeSeriesDataRequest}))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-tensorboards-experiments-runs-timeSeries-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-tensorboards-experiments-runs-timeSeries-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-experiments-runs-timeSeries-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-tensorboards-experiments-runs-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tensorboards-experiments-runs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tensorboards-experiments-runs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-tensorboards-experiments-runs-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-modelDeploymentMonitoringJobs-resume
  "Resumes a paused ModelDeploymentMonitoringJob. It will start to run from next scheduled time. A deleted ModelDeploymentMonitoringJob can't be resumed.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the ModelDeploymentMonitoringJob to resume. Format: `projects/{project}/locations/{location}/modelDeploymentMonitoringJobs/{model_deployment_monitoring_job}`
GoogleCloudAiplatformV1ResumeModelDeploymentMonitoringJobRequest:
object"
  [name
   GoogleCloudAiplatformV1ResumeModelDeploymentMonitoringJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1ResumeModelDeploymentMonitoringJobRequest}))

(defn projects-locations-modelDeploymentMonitoringJobs-searchModelDeploymentMonitoringStatsAnomalies
  "Searches Model Monitoring Statistics generated within a given time window.
https://cloud.google.com/vertex-ai

modelDeploymentMonitoringJob <string> Required. ModelDeploymentMonitoring Job resource name. Format: `projects/{project}/locations/{location}/modelDeploymentMonitoringJobs/{model_deployment_monitoring_job}`
GoogleCloudAiplatformV1SearchModelDeploymentMonitoringStatsAnomaliesRequest:
{:pageSize integer,
 :startTime string,
 :deployedModelId string,
 :endTime string,
 :pageToken string,
 :featureDisplayName string,
 :objectives
 [{:topFeatureCount integer,
   :type
   [MODEL_DEPLOYMENT_MONITORING_OBJECTIVE_TYPE_UNSPECIFIED
    RAW_FEATURE_SKEW
    RAW_FEATURE_DRIFT
    FEATURE_ATTRIBUTION_SKEW
    FEATURE_ATTRIBUTION_DRIFT]}]}"
  [modelDeploymentMonitoringJob
   GoogleCloudAiplatformV1SearchModelDeploymentMonitoringStatsAnomaliesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+modelDeploymentMonitoringJob}:searchModelDeploymentMonitoringStatsAnomalies",
     :uri-template-args
     {:modelDeploymentMonitoringJob modelDeploymentMonitoringJob},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1SearchModelDeploymentMonitoringStatsAnomaliesRequest}))

(defn projects-locations-modelDeploymentMonitoringJobs-delete
  "Deletes a ModelDeploymentMonitoringJob.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the model monitoring job to delete. Format: `projects/{project}/locations/{location}/modelDeploymentMonitoringJobs/{model_deployment_monitoring_job}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-modelDeploymentMonitoringJobs-create
  "Creates a ModelDeploymentMonitoringJob. It will run periodically on a configured interval.
https://cloud.google.com/vertex-ai

parent <string> Required. The parent of the ModelDeploymentMonitoringJob. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1ModelDeploymentMonitoringJob:
{:bigqueryTables
 [{:logType [LOG_TYPE_UNSPECIFIED PREDICT EXPLAIN],
   :requestResponseLoggingSchemaVersion string,
   :logSource [LOG_SOURCE_UNSPECIFIED TRAINING SERVING],
   :bigqueryTablePath string}],
 :labels object,
 :statsAnomaliesBaseDirectory {:outputUriPrefix string},
 :modelDeploymentMonitoringObjectiveConfigs
 [{:objectiveConfig
   {:trainingPredictionSkewDetectionConfig
    {:defaultSkewThreshold {:value number},
     :skewThresholds object,
     :attributionScoreSkewThresholds object},
    :explanationConfig
    {:enableFeatureAttributes boolean,
     :explanationBaseline
     {:predictionFormat [PREDICTION_FORMAT_UNSPECIFIED JSONL BIGQUERY],
      :gcs GoogleCloudAiplatformV1GcsDestination,
      :bigquery GoogleCloudAiplatformV1BigQueryDestination}},
    :trainingDataset
    {:loggingSamplingStrategy
     {:randomSampleConfig
      GoogleCloudAiplatformV1SamplingStrategyRandomSampleConfig},
     :targetField string,
     :dataFormat string,
     :gcsSource {:uris [string]},
     :bigquerySource {:inputUri string},
     :dataset string},
    :predictionDriftDetectionConfig
    {:attributionScoreDriftThresholds object,
     :driftThresholds object,
     :defaultDriftThreshold {:value number}}},
   :deployedModelId string}],
 :scheduleState
 [MONITORING_SCHEDULE_STATE_UNSPECIFIED PENDING OFFLINE RUNNING],
 :loggingSamplingStrategy {:randomSampleConfig {:sampleRate number}},
 :encryptionSpec {:kmsKeyName string},
 :modelDeploymentMonitoringScheduleConfig
 {:monitorWindow string, :monitorInterval string},
 :displayName string,
 :predictInstanceSchemaUri string,
 :name string,
 :analysisInstanceSchemaUri string,
 :createTime string,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :latestMonitoringPipelineMetadata
 {:runTime string,
  :status {:message string, :code integer, :details [object]}},
 :updateTime string,
 :nextScheduleTime string,
 :modelMonitoringAlertConfig
 {:enableLogging boolean,
  :notificationChannels [string],
  :emailAlertConfig {:userEmails [string]}},
 :error {:message string, :code integer, :details [object]},
 :logTtl string,
 :samplePredictInstance any,
 :endpoint string,
 :enableMonitoringPipelineLogs boolean}"
  [parent GoogleCloudAiplatformV1ModelDeploymentMonitoringJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/modelDeploymentMonitoringJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ModelDeploymentMonitoringJob}))

(defn projects-locations-modelDeploymentMonitoringJobs-patch
  "Updates a ModelDeploymentMonitoringJob.
https://cloud.google.com/vertex-ai

name <string> Output only. Resource name of a ModelDeploymentMonitoringJob.
GoogleCloudAiplatformV1ModelDeploymentMonitoringJob:
{:bigqueryTables
 [{:logType [LOG_TYPE_UNSPECIFIED PREDICT EXPLAIN],
   :requestResponseLoggingSchemaVersion string,
   :logSource [LOG_SOURCE_UNSPECIFIED TRAINING SERVING],
   :bigqueryTablePath string}],
 :labels object,
 :statsAnomaliesBaseDirectory {:outputUriPrefix string},
 :modelDeploymentMonitoringObjectiveConfigs
 [{:objectiveConfig
   {:trainingPredictionSkewDetectionConfig
    {:defaultSkewThreshold {:value number},
     :skewThresholds object,
     :attributionScoreSkewThresholds object},
    :explanationConfig
    {:enableFeatureAttributes boolean,
     :explanationBaseline
     {:predictionFormat [PREDICTION_FORMAT_UNSPECIFIED JSONL BIGQUERY],
      :gcs GoogleCloudAiplatformV1GcsDestination,
      :bigquery GoogleCloudAiplatformV1BigQueryDestination}},
    :trainingDataset
    {:loggingSamplingStrategy
     {:randomSampleConfig
      GoogleCloudAiplatformV1SamplingStrategyRandomSampleConfig},
     :targetField string,
     :dataFormat string,
     :gcsSource {:uris [string]},
     :bigquerySource {:inputUri string},
     :dataset string},
    :predictionDriftDetectionConfig
    {:attributionScoreDriftThresholds object,
     :driftThresholds object,
     :defaultDriftThreshold {:value number}}},
   :deployedModelId string}],
 :scheduleState
 [MONITORING_SCHEDULE_STATE_UNSPECIFIED PENDING OFFLINE RUNNING],
 :loggingSamplingStrategy {:randomSampleConfig {:sampleRate number}},
 :encryptionSpec {:kmsKeyName string},
 :modelDeploymentMonitoringScheduleConfig
 {:monitorWindow string, :monitorInterval string},
 :displayName string,
 :predictInstanceSchemaUri string,
 :name string,
 :analysisInstanceSchemaUri string,
 :createTime string,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :latestMonitoringPipelineMetadata
 {:runTime string,
  :status {:message string, :code integer, :details [object]}},
 :updateTime string,
 :nextScheduleTime string,
 :modelMonitoringAlertConfig
 {:enableLogging boolean,
  :notificationChannels [string],
  :emailAlertConfig {:userEmails [string]}},
 :error {:message string, :code integer, :details [object]},
 :logTtl string,
 :samplePredictInstance any,
 :endpoint string,
 :enableMonitoringPipelineLogs boolean}

optional:
updateMask <string> Required. The update mask is used to specify the fields to be overwritten in the ModelDeploymentMonitoringJob resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. For the objective config, the user can either provide the update mask for model_deployment_monitoring_objective_configs or any combination of its nested fields, such as: model_deployment_monitoring_objective_configs.objective_config.training_dataset. Updatable fields: * `display_name` * `model_deployment_monitoring_schedule_config` * `model_monitoring_alert_config` * `logging_sampling_strategy` * `labels` * `log_ttl` * `enable_monitoring_pipeline_logs` . and * `model_deployment_monitoring_objective_configs` . or * `model_deployment_monitoring_objective_configs.objective_config.training_dataset` * `model_deployment_monitoring_objective_configs.objective_config.training_prediction_skew_detection_config` * `model_deployment_monitoring_objective_configs.objective_config.prediction_drift_detection_config`"
  ([name GoogleCloudAiplatformV1ModelDeploymentMonitoringJob]
    (projects-locations-modelDeploymentMonitoringJobs-patch
      name
      GoogleCloudAiplatformV1ModelDeploymentMonitoringJob
      nil))
  ([name GoogleCloudAiplatformV1ModelDeploymentMonitoringJob optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1ModelDeploymentMonitoringJob})))

(defn projects-locations-modelDeploymentMonitoringJobs-get
  "Gets a ModelDeploymentMonitoringJob.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the ModelDeploymentMonitoringJob. Format: `projects/{project}/locations/{location}/modelDeploymentMonitoringJobs/{model_deployment_monitoring_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-modelDeploymentMonitoringJobs-list
  "Lists ModelDeploymentMonitoringJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The parent of the ModelDeploymentMonitoringJob. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter. Supported fields: * `display_name` supports `=`, `!=` comparisons, and `:` wildcard. * `state` supports `=`, `!=` comparisons. * `create_time` supports `=`, `!=`,`<`, `<=`,`>`, `>=` comparisons. `create_time` must be in RFC 3339 format. * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* - key existence Some examples of using the filter are: * `state=\"JOB_STATE_SUCCEEDED\" AND display_name:\"my_job_*\"` * `state!=\"JOB_STATE_FAILED\" OR display_name=\"my_job\"` * `NOT display_name=\"my_job\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `labels.keyA=valueA` * `labels.keyB:*`
readMask <string> Mask specifying which fields to read"
  ([parent]
    (projects-locations-modelDeploymentMonitoringJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/modelDeploymentMonitoringJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-modelDeploymentMonitoringJobs-pause
  "Pauses a ModelDeploymentMonitoringJob. If the job is running, the server makes a best effort to cancel the job. Will mark ModelDeploymentMonitoringJob.state to 'PAUSED'.
https://cloud.google.com/vertex-ai

name <string> Required. The resource name of the ModelDeploymentMonitoringJob to pause. Format: `projects/{project}/locations/{location}/modelDeploymentMonitoringJobs/{model_deployment_monitoring_job}`
GoogleCloudAiplatformV1PauseModelDeploymentMonitoringJobRequest:
object"
  [name
   GoogleCloudAiplatformV1PauseModelDeploymentMonitoringJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAiplatformV1PauseModelDeploymentMonitoringJobRequest}))

(defn projects-locations-modelDeploymentMonitoringJobs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-modelDeploymentMonitoringJobs-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-modelDeploymentMonitoringJobs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-modelDeploymentMonitoringJobs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-modelDeploymentMonitoringJobs-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-modelDeploymentMonitoringJobs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-modelDeploymentMonitoringJobs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataLabelingJobs-delete
  "Deletes a DataLabelingJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the DataLabelingJob to be deleted. Format: `projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataLabelingJobs-list
  "Lists DataLabelingJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The parent of the DataLabelingJob. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read. FieldMask represents a set of symbolic field paths. For example, the mask can be `paths: \"name\"`. The \"name\" here is a field in DataLabelingJob. If this field is not set, all fields of the DataLabelingJob are returned.
filter <string> The standard list filter. Supported fields: * `display_name` supports `=`, `!=` comparisons, and `:` wildcard. * `state` supports `=`, `!=` comparisons. * `create_time` supports `=`, `!=`,`<`, `<=`,`>`, `>=` comparisons. `create_time` must be in RFC 3339 format. * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* - key existence Some examples of using the filter are: * `state=\"JOB_STATE_SUCCEEDED\" AND display_name:\"my_job_*\"` * `state!=\"JOB_STATE_FAILED\" OR display_name=\"my_job\"` * `NOT display_name=\"my_job\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `labels.keyA=valueA` * `labels.keyB:*`
pageSize <integer> The standard list page size.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order by default. Use `desc` after a field name for descending."
  ([parent] (projects-locations-dataLabelingJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/dataLabelingJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataLabelingJobs-cancel
  "Cancels a DataLabelingJob. Success of cancellation is not guaranteed.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the DataLabelingJob. Format: `projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`
GoogleCloudAiplatformV1CancelDataLabelingJobRequest:
object"
  [name GoogleCloudAiplatformV1CancelDataLabelingJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CancelDataLabelingJobRequest}))

(defn projects-locations-dataLabelingJobs-get
  "Gets a DataLabelingJob.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the DataLabelingJob. Format: `projects/{project}/locations/{location}/dataLabelingJobs/{data_labeling_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataLabelingJobs-create
  "Creates a DataLabelingJob.
https://cloud.google.com/vertex-ai

parent <string> Required. The parent of the DataLabelingJob. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1DataLabelingJob:
{:labels object,
 :instructionUri string,
 :datasets [string],
 :encryptionSpec {:kmsKeyName string},
 :activeLearningConfig
 {:sampleConfig
  {:initialBatchSamplePercentage integer,
   :sampleStrategy [SAMPLE_STRATEGY_UNSPECIFIED UNCERTAINTY],
   :followingBatchSamplePercentage integer},
  :maxDataItemCount string,
  :maxDataItemPercentage integer,
  :trainingConfig {:timeoutTrainingMilliHours string}},
 :displayName string,
 :name string,
 :createTime string,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :updateTime string,
 :inputs any,
 :specialistPools [string],
 :labelerCount integer,
 :error {:message string, :code integer, :details [object]},
 :inputsSchemaUri string,
 :currentSpend {:units string, :nanos integer, :currencyCode string},
 :annotationLabels object,
 :labelingProgress integer}"
  [parent GoogleCloudAiplatformV1DataLabelingJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/dataLabelingJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1DataLabelingJob}))

(defn projects-locations-dataLabelingJobs-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataLabelingJobs-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-dataLabelingJobs-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataLabelingJobs-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-dataLabelingJobs-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataLabelingJobs-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataLabelingJobs-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-schedules-delete
  "Deletes a Schedule.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Schedule resource to be deleted. Format: `projects/{project}/locations/{location}/schedules/{schedule}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-schedules-create
  "Creates a Schedule.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the Schedule in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1Schedule:
{:nextRunTime string,
 :startTime string,
 :catchUp boolean,
 :displayName string,
 :name string,
 :endTime string,
 :lastPauseTime string,
 :maxConcurrentRunCount string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE PAUSED COMPLETED],
 :cron string,
 :lastResumeTime string,
 :updateTime string,
 :allowQueueing boolean,
 :lastScheduledRunResponse
 {:scheduledRunTime string, :runResponse string},
 :startedRunCount string,
 :createPipelineJobRequest
 {:pipelineJob
  {:serviceAccount string,
   :labels object,
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :runtimeConfig
   {:gcsOutputDirectory string,
    :parameters object,
    :failurePolicy
    [PIPELINE_FAILURE_POLICY_UNSPECIFIED
     PIPELINE_FAILURE_POLICY_FAIL_SLOW
     PIPELINE_FAILURE_POLICY_FAIL_FAST],
    :inputArtifacts object,
    :parameterValues object},
   :name string,
   :templateUri string,
   :endTime string,
   :createTime string,
   :reservedIpRanges [string],
   :preflightValidations boolean,
   :state
   [PIPELINE_STATE_UNSPECIFIED
    PIPELINE_STATE_QUEUED
    PIPELINE_STATE_PENDING
    PIPELINE_STATE_RUNNING
    PIPELINE_STATE_SUCCEEDED
    PIPELINE_STATE_FAILED
    PIPELINE_STATE_CANCELLING
    PIPELINE_STATE_CANCELLED
    PIPELINE_STATE_PAUSED],
   :updateTime string,
   :jobDetail
   {:pipelineRunContext
    {:description string,
     :labels object,
     :schemaTitle string,
     :displayName string,
     :name string,
     :createTime string,
     :etag string,
     :updateTime string,
     :parentContexts [string],
     :metadata object,
     :schemaVersion string},
    :pipelineContext
    {:description string,
     :labels object,
     :schemaTitle string,
     :displayName string,
     :name string,
     :createTime string,
     :etag string,
     :updateTime string,
     :parentContexts [string],
     :metadata object,
     :schemaVersion string},
    :taskDetails
    [{:pipelineTaskStatus
      [GoogleCloudAiplatformV1PipelineTaskDetailPipelineTaskStatus],
      :execution GoogleCloudAiplatformV1Execution,
      :startTime string,
      :endTime string,
      :createTime string,
      :state
      [STATE_UNSPECIFIED
       PENDING
       RUNNING
       SUCCEEDED
       CANCEL_PENDING
       CANCELLING
       CANCELLED
       FAILED
       SKIPPED
       NOT_TRIGGERED],
      :inputs object,
      :parentTaskId string,
      :outputs object,
      :error GoogleRpcStatus,
      :taskName string,
      :taskId string,
      :executorDetail
      GoogleCloudAiplatformV1PipelineTaskExecutorDetail}]},
   :error {:message string, :code integer, :details [object]},
   :network string,
   :pipelineSpec object,
   :scheduleName string,
   :templateMetadata {:version string}},
  :parent string,
  :pipelineJobId string},
 :maxRunCount string}"
  [parent GoogleCloudAiplatformV1Schedule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/schedules",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1Schedule}))

(defn projects-locations-schedules-pause
  "Pauses a Schedule. Will mark Schedule.state to 'PAUSED'. If the schedule is paused, no new runs will be created. Already created runs will NOT be paused or canceled.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Schedule resource to be paused. Format: `projects/{project}/locations/{location}/schedules/{schedule}`
GoogleCloudAiplatformV1PauseScheduleRequest:
object"
  [name GoogleCloudAiplatformV1PauseScheduleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1PauseScheduleRequest}))

(defn projects-locations-schedules-list
  "Lists Schedules in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the Schedules from. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The standard list page size. Default to 100 if not specified.
filter <string> Lists the Schedules that match the filter expression. The following fields are supported: * `display_name`: Supports `=`, `!=` comparisons, and `:` wildcard. * `state`: Supports `=` and `!=` comparisons. * `request`: Supports existence of the check. (e.g. `create_pipeline_job_request:*` --> Schedule has create_pipeline_job_request). * `create_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `start_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `end_time`: Supports `=`, `!=`, `<`, `>`, `<=`, `>=` comparisons and `:*` existence check. Values must be in RFC 3339 format. * `next_run_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. Filter expressions can be combined together using logical operators (`NOT`, `AND` & `OR`). The syntax to define filter expression is based on https://google.aip.dev/160. Examples: * `state=\"ACTIVE\" AND display_name:\"my_schedule_*\"` * `NOT display_name=\"my_schedule\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `end_time>\"2021-05-18T00:00:00Z\" OR NOT end_time:*` * `create_pipeline_job_request:*`
orderBy <string> A comma-separated list of fields to order by. The default sort order is in ascending order. Use \"desc\" after a field name for descending. You can have multiple order_by fields provided. For example, using \"create_time desc, end_time\" will order results by create time in descending order, and if there are multiple schedules having the same create time, order them by the end time in ascending order. If order_by is not specified, it will order by default with create_time in descending order. Supported fields: * `create_time` * `start_time` * `end_time` * `next_run_time`"
  ([parent] (projects-locations-schedules-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/schedules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-schedules-get
  "Gets a Schedule.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Schedule resource. Format: `projects/{project}/locations/{location}/schedules/{schedule}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-schedules-resume
  "Resumes a paused Schedule to start scheduling new runs. Will mark Schedule.state to 'ACTIVE'. Only paused Schedule can be resumed. When the Schedule is resumed, new runs will be scheduled starting from the next execution time after the current time based on the time_specification in the Schedule. If Schedule.catchUp is set up true, all missed runs will be scheduled for backfill first.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Schedule resource to be resumed. Format: `projects/{project}/locations/{location}/schedules/{schedule}`
GoogleCloudAiplatformV1ResumeScheduleRequest:
{:catchUp boolean}"
  [name GoogleCloudAiplatformV1ResumeScheduleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ResumeScheduleRequest}))

(defn projects-locations-schedules-patch
  "Updates an active or paused Schedule. When the Schedule is updated, new runs will be scheduled starting from the updated next execution time after the update time based on the time_specification in the updated Schedule. All unstarted runs before the update time will be skipped while already created runs will NOT be paused or canceled.
https://cloud.google.com/vertex-ai

name <string> Immutable. The resource name of the Schedule.
GoogleCloudAiplatformV1Schedule:
{:nextRunTime string,
 :startTime string,
 :catchUp boolean,
 :displayName string,
 :name string,
 :endTime string,
 :lastPauseTime string,
 :maxConcurrentRunCount string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE PAUSED COMPLETED],
 :cron string,
 :lastResumeTime string,
 :updateTime string,
 :allowQueueing boolean,
 :lastScheduledRunResponse
 {:scheduledRunTime string, :runResponse string},
 :startedRunCount string,
 :createPipelineJobRequest
 {:pipelineJob
  {:serviceAccount string,
   :labels object,
   :encryptionSpec {:kmsKeyName string},
   :startTime string,
   :displayName string,
   :runtimeConfig
   {:gcsOutputDirectory string,
    :parameters object,
    :failurePolicy
    [PIPELINE_FAILURE_POLICY_UNSPECIFIED
     PIPELINE_FAILURE_POLICY_FAIL_SLOW
     PIPELINE_FAILURE_POLICY_FAIL_FAST],
    :inputArtifacts object,
    :parameterValues object},
   :name string,
   :templateUri string,
   :endTime string,
   :createTime string,
   :reservedIpRanges [string],
   :preflightValidations boolean,
   :state
   [PIPELINE_STATE_UNSPECIFIED
    PIPELINE_STATE_QUEUED
    PIPELINE_STATE_PENDING
    PIPELINE_STATE_RUNNING
    PIPELINE_STATE_SUCCEEDED
    PIPELINE_STATE_FAILED
    PIPELINE_STATE_CANCELLING
    PIPELINE_STATE_CANCELLED
    PIPELINE_STATE_PAUSED],
   :updateTime string,
   :jobDetail
   {:pipelineRunContext
    {:description string,
     :labels object,
     :schemaTitle string,
     :displayName string,
     :name string,
     :createTime string,
     :etag string,
     :updateTime string,
     :parentContexts [string],
     :metadata object,
     :schemaVersion string},
    :pipelineContext
    {:description string,
     :labels object,
     :schemaTitle string,
     :displayName string,
     :name string,
     :createTime string,
     :etag string,
     :updateTime string,
     :parentContexts [string],
     :metadata object,
     :schemaVersion string},
    :taskDetails
    [{:pipelineTaskStatus
      [GoogleCloudAiplatformV1PipelineTaskDetailPipelineTaskStatus],
      :execution GoogleCloudAiplatformV1Execution,
      :startTime string,
      :endTime string,
      :createTime string,
      :state
      [STATE_UNSPECIFIED
       PENDING
       RUNNING
       SUCCEEDED
       CANCEL_PENDING
       CANCELLING
       CANCELLED
       FAILED
       SKIPPED
       NOT_TRIGGERED],
      :inputs object,
      :parentTaskId string,
      :outputs object,
      :error GoogleRpcStatus,
      :taskName string,
      :taskId string,
      :executorDetail
      GoogleCloudAiplatformV1PipelineTaskExecutorDetail}]},
   :error {:message string, :code integer, :details [object]},
   :network string,
   :pipelineSpec object,
   :scheduleName string,
   :templateMetadata {:version string}},
  :parent string,
  :pipelineJobId string},
 :maxRunCount string}

optional:
updateMask <string> Required. The update mask applies to the resource. See google.protobuf.FieldMask."
  ([name GoogleCloudAiplatformV1Schedule]
    (projects-locations-schedules-patch
      name
      GoogleCloudAiplatformV1Schedule
      nil))
  ([name GoogleCloudAiplatformV1Schedule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Schedule})))

(defn projects-locations-schedules-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (projects-locations-schedules-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-schedules-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-schedules-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-schedules-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-schedules-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-schedules-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-indexes-patch
  "Updates an Index.
https://cloud.google.com/vertex-ai

name <string> Output only. The resource name of the Index.
GoogleCloudAiplatformV1Index:
{:description string,
 :labels object,
 :indexStats
 {:sparseVectorsCount string,
  :shardsCount integer,
  :vectorsCount string},
 :encryptionSpec {:kmsKeyName string},
 :metadataSchemaUri string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :deployedIndexes
 [{:indexEndpoint string,
   :displayName string,
   :deployedIndexId string}],
 :updateTime string,
 :indexUpdateMethod
 [INDEX_UPDATE_METHOD_UNSPECIFIED BATCH_UPDATE STREAM_UPDATE],
 :metadata any}

optional:
updateMask <string> The update mask applies to the resource. For the `FieldMask` definition, see google.protobuf.FieldMask."
  ([name GoogleCloudAiplatformV1Index]
    (projects-locations-indexes-patch
      name
      GoogleCloudAiplatformV1Index
      nil))
  ([name GoogleCloudAiplatformV1Index optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Index})))

(defn projects-locations-indexes-removeDatapoints
  "Remove Datapoints from an Index.
https://cloud.google.com/vertex-ai

index <string> Required. The name of the Index resource to be updated. Format: `projects/{project}/locations/{location}/indexes/{index}`
GoogleCloudAiplatformV1RemoveDatapointsRequest:
{:datapointIds [string]}"
  [index GoogleCloudAiplatformV1RemoveDatapointsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+index}:removeDatapoints",
     :uri-template-args {:index index},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1RemoveDatapointsRequest}))

(defn projects-locations-indexes-get
  "Gets an Index.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Index resource. Format: `projects/{project}/locations/{location}/indexes/{index}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexes-list
  "Lists Indexes in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location from which to list the Indexes. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read.
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([parent] (projects-locations-indexes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/indexes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-indexes-create
  "Creates an Index.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the Index in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1Index:
{:description string,
 :labels object,
 :indexStats
 {:sparseVectorsCount string,
  :shardsCount integer,
  :vectorsCount string},
 :encryptionSpec {:kmsKeyName string},
 :metadataSchemaUri string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :deployedIndexes
 [{:indexEndpoint string,
   :displayName string,
   :deployedIndexId string}],
 :updateTime string,
 :indexUpdateMethod
 [INDEX_UPDATE_METHOD_UNSPECIFIED BATCH_UPDATE STREAM_UPDATE],
 :metadata any}"
  [parent GoogleCloudAiplatformV1Index]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/indexes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1Index}))

(defn projects-locations-indexes-delete
  "Deletes an Index. An Index can only be deleted when all its DeployedIndexes had been undeployed.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Index resource to be deleted. Format: `projects/{project}/locations/{location}/indexes/{index}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexes-upsertDatapoints
  "Add/update Datapoints into an Index.
https://cloud.google.com/vertex-ai

index <string> Required. The name of the Index resource to be updated. Format: `projects/{project}/locations/{location}/indexes/{index}`
GoogleCloudAiplatformV1UpsertDatapointsRequest:
{:updateMask string,
 :datapoints
 [{:restricts
   [{:namespace string, :denyList [string], :allowList [string]}],
   :featureVector [number],
   :crowdingTag {:crowdingAttribute string},
   :numericRestricts
   [{:valueInt string,
     :namespace string,
     :valueFloat number,
     :op
     [OPERATOR_UNSPECIFIED
      LESS
      LESS_EQUAL
      EQUAL
      GREATER_EQUAL
      GREATER
      NOT_EQUAL],
     :valueDouble number}],
   :sparseEmbedding {:dimensions [string], :values [number]},
   :datapointId string}]}"
  [index GoogleCloudAiplatformV1UpsertDatapointsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+index}:upsertDatapoints",
     :uri-template-args {:index index},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1UpsertDatapointsRequest}))

(defn projects-locations-indexes-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexes-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-indexes-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-indexes-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexes-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexes-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-indexes-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-searchFeatures
  "Searches Features matching a query in a given project.
https://cloud.google.com/vertex-ai

location <string> Required. The resource name of the Location to search Features. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of Features to return. The service may return fewer than this value. If unspecified, at most 100 Features will be returned. The maximum value is 100; any value greater than 100 will be coerced to 100.
query <string> Query string that is a conjunction of field-restricted queries and/or field-restricted filters. Field-restricted queries and filters can be combined using `AND` to form a conjunction. A field query is in the form FIELD:QUERY. This implicitly checks if QUERY exists as a substring within Feature's FIELD. The QUERY and the FIELD are converted to a sequence of words (i.e. tokens) for comparison. This is done by: * Removing leading/trailing whitespace and tokenizing the search value. Characters that are not one of alphanumeric `[a-zA-Z0-9]`, underscore `_`, or asterisk `*` are treated as delimiters for tokens. `*` is treated as a wildcard that matches characters within a token. * Ignoring case. * Prepending an asterisk to the first and appending an asterisk to the last token in QUERY. A QUERY must be either a singular token or a phrase. A phrase is one or multiple words enclosed in double quotation marks (\"). With phrases, the order of the words is important. Words in the phrase must be matching in order and consecutively. Supported FIELDs for field-restricted queries: * `feature_id` * `description` * `entity_type_id` Examples: * `feature_id: foo` --> Matches a Feature with ID containing the substring `foo` (eg. `foo`, `foofeature`, `barfoo`). * `feature_id: foo*feature` --> Matches a Feature with ID containing the substring `foo*feature` (eg. `foobarfeature`). * `feature_id: foo AND description: bar` --> Matches a Feature with ID containing the substring `foo` and description containing the substring `bar`. Besides field queries, the following exact-match filters are supported. The exact-match filters do not support wildcards. Unlike field-restricted queries, exact-match filters are case-sensitive. * `feature_id`: Supports = comparisons. * `description`: Supports = comparisons. Multi-token filters should be enclosed in quotes. * `entity_type_id`: Supports = comparisons. * `value_type`: Supports = and != comparisons. * `labels`: Supports key-value equality as well as key presence. * `featurestore_id`: Supports = comparisons. Examples: * `description = \"foo bar\"` --> Any Feature with description exactly equal to `foo bar` * `value_type = DOUBLE` --> Features whose type is DOUBLE. * `labels.active = yes AND labels.env = prod` --> Features having both (active: yes) and (env: prod) labels. * `labels.env: *` --> Any Feature which has a label with `env` as the key."
  ([location]
    (projects-locations-featurestores-searchFeatures location nil))
  ([location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+location}/featurestores:searchFeatures",
       :uri-template-args {:location location},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-get
  "Gets details of a single Featurestore.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Featurestore resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
{:policy
 {:bindings
  [{:role string,
    :condition
    {:title string,
     :description string,
     :expression string,
     :location string},
    :members [string]}],
  :etag string,
  :version integer}}"
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-featurestores-patch
  "Updates the parameters of a single Featurestore.
https://cloud.google.com/vertex-ai

name <string> Output only. Name of the Featurestore. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}`
GoogleCloudAiplatformV1Featurestore:
{:labels object,
 :onlineServingConfig
 {:fixedNodeCount integer,
  :scaling
  {:cpuUtilizationTarget integer,
   :minNodeCount integer,
   :maxNodeCount integer}},
 :encryptionSpec {:kmsKeyName string},
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED STABLE UPDATING],
 :onlineStorageTtlDays integer,
 :updateTime string}

optional:
updateMask <string> Field mask is used to specify the fields to be overwritten in the Featurestore resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. Updatable fields: * `labels` * `online_serving_config.fixed_node_count` * `online_serving_config.scaling` * `online_storage_ttl_days`"
  ([name GoogleCloudAiplatformV1Featurestore]
    (projects-locations-featurestores-patch
      name
      GoogleCloudAiplatformV1Featurestore
      nil))
  ([name GoogleCloudAiplatformV1Featurestore optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Featurestore})))

(defn projects-locations-featurestores-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
permissions <string> The set of permissions to check for the `resource`. Permissions with wildcards (such as `*` or `storage.*`) are not allowed. For more information see [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions)."
  ([resource]
    (projects-locations-featurestores-testIamPermissions resource nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:testIamPermissions",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-create
  "Creates a new Featurestore in a given project and location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create Featurestores. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1Featurestore:
{:labels object,
 :onlineServingConfig
 {:fixedNodeCount integer,
  :scaling
  {:cpuUtilizationTarget integer,
   :minNodeCount integer,
   :maxNodeCount integer}},
 :encryptionSpec {:kmsKeyName string},
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED STABLE UPDATING],
 :onlineStorageTtlDays integer,
 :updateTime string}

optional:
featurestoreId <string> Required. The ID to use for this Featurestore, which will become the final component of the Featurestore's resource name. This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first character cannot be a number. The value must be unique within the project and location."
  ([parent GoogleCloudAiplatformV1Featurestore]
    (projects-locations-featurestores-create
      parent
      GoogleCloudAiplatformV1Featurestore
      nil))
  ([parent GoogleCloudAiplatformV1Featurestore optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featurestores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Featurestore})))

(defn projects-locations-featurestores-delete
  "Deletes a single Featurestore. The Featurestore must not contain any EntityTypes or `force` must be set to true for the request to succeed.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Featurestore to be deleted. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}`

optional:
force <boolean> If set to true, any EntityTypes and Features for this Featurestore will also be deleted. (Otherwise, the request will only work if the Featurestore has no EntityTypes.)"
  ([name] (projects-locations-featurestores-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-featurestores-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-batchReadFeatureValues
  "Batch reads Feature values from a Featurestore. This API enables batch reading Feature values, where each read instance in the batch may read Feature values of entities from one or more EntityTypes. Point-in-time correctness is guaranteed for Feature values of each read instance as of each instance's read timestamp.
https://cloud.google.com/vertex-ai

featurestore <string> Required. The resource name of the Featurestore from which to query Feature values. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}`
GoogleCloudAiplatformV1BatchReadFeatureValuesRequest:
{:passThroughFields [{:fieldName string}],
 :entityTypeSpecs
 [{:entityTypeId string,
   :settings [{:destinationField string, :featureId string}],
   :featureSelector {:idMatcher {:ids [string]}}}],
 :csvReadInstances {:gcsSource {:uris [string]}},
 :startTime string,
 :destination
 {:bigqueryDestination {:outputUri string},
  :tfrecordDestination {:gcsDestination {:outputUriPrefix string}},
  :csvDestination {:gcsDestination {:outputUriPrefix string}}},
 :bigqueryReadInstances {:inputUri string}}"
  [featurestore GoogleCloudAiplatformV1BatchReadFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+featurestore}:batchReadFeatureValues",
     :uri-template-args {:featurestore featurestore},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1BatchReadFeatureValuesRequest}))

(defn projects-locations-featurestores-list
  "Lists Featurestores in a given project and location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list Featurestores. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of Featurestores to return. The service may return fewer than this value. If unspecified, at most 100 Featurestores will be returned. The maximum value is 100; any value greater than 100 will be coerced to 100.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported Fields: * `create_time` * `update_time` * `online_serving_config.fixed_node_count`
readMask <string> Mask specifying which fields to read.
filter <string> Lists the featurestores that match the filter expression. The following fields are supported: * `create_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `update_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `online_serving_config.fixed_node_count`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. * `labels`: Supports key-value equality and key presence. Examples: * `create_time > \"2020-01-01\" OR update_time > \"2020-01-01\"` Featurestores created or updated after 2020-01-01. * `labels.env = \"prod\"` Featurestores with label \"env\" set to \"prod\"."
  ([parent] (projects-locations-featurestores-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featurestores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-featurestores-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-featurestores-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-readFeatureValues
  "Reads Feature values of a specific entity of an EntityType. For reading feature values of multiple entities of an EntityType, please use StreamingReadFeatureValues.
https://cloud.google.com/vertex-ai

entityType <string> Required. The resource name of the EntityType for the entity being read. Value format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entityType}`. For example, for a machine learning model predicting user clicks on a website, an EntityType ID could be `user`.
GoogleCloudAiplatformV1ReadFeatureValuesRequest:
{:featureSelector {:idMatcher {:ids [string]}}, :entityId string}"
  [entityType GoogleCloudAiplatformV1ReadFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+entityType}:readFeatureValues",
     :uri-template-args {:entityType entityType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ReadFeatureValuesRequest}))

(defn projects-locations-featurestores-entityTypes-get
  "Gets details of a single EntityType.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the EntityType resource. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
{:policy
 {:bindings
  [{:role string,
    :condition
    {:title string,
     :description string,
     :expression string,
     :location string},
    :members [string]}],
  :etag string,
  :version integer}}"
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-featurestores-entityTypes-importFeatureValues
  "Imports Feature values into the Featurestore from a source storage. The progress of the import is tracked by the returned operation. The imported features are guaranteed to be visible to subsequent read operations after the operation is marked as successfully done. If an import operation fails, the Feature values returned from reads and exports may be inconsistent. If consistency is required, the caller must retry the same import request again and wait till the new operation returned is marked as successfully done. There are also scenarios where the caller can cause inconsistency. - Source data for import contains multiple distinct Feature values for the same entity ID and timestamp. - Source is modified during an import. This includes adding, updating, or removing source data and/or metadata. Examples of updating metadata include but are not limited to changing storage location, storage class, or retention policy. - Online serving cluster is under-provisioned.
https://cloud.google.com/vertex-ai

entityType <string> Required. The resource name of the EntityType grouping the Features for which values are being imported. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entityType}`
GoogleCloudAiplatformV1ImportFeatureValuesRequest:
{:disableOnlineServing boolean,
 :featureTimeField string,
 :csvSource {:gcsSource {:uris [string]}},
 :workerCount integer,
 :featureSpecs [{:sourceField string, :id string}],
 :entityIdField string,
 :bigquerySource {:inputUri string},
 :disableIngestionAnalysis boolean,
 :featureTime string,
 :avroSource {:gcsSource {:uris [string]}}}"
  [entityType GoogleCloudAiplatformV1ImportFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+entityType}:importFeatureValues",
     :uri-template-args {:entityType entityType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ImportFeatureValuesRequest}))

(defn projects-locations-featurestores-entityTypes-patch
  "Updates the parameters of a single EntityType.
https://cloud.google.com/vertex-ai

name <string> Immutable. Name of the EntityType. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}` The last part entity_type is assigned by the client. The entity_type can be up to 64 characters long and can consist only of ASCII Latin letters A-Z and a-z and underscore(_), and ASCII digits 0-9 starting with a letter. The value will be unique given a featurestore.
GoogleCloudAiplatformV1EntityType:
{:createTime string,
 :offlineStorageTtlDays integer,
 :updateTime string,
 :monitoringConfig
 {:numericalThresholdConfig {:value number},
  :snapshotAnalysis
  {:disabled boolean,
   :monitoringIntervalDays integer,
   :stalenessDays integer},
  :importFeaturesAnalysis
  {:anomalyDetectionBaseline
   [BASELINE_UNSPECIFIED
    LATEST_STATS
    MOST_RECENT_SNAPSHOT_STATS
    PREVIOUS_IMPORT_FEATURES_STATS],
   :state [STATE_UNSPECIFIED DEFAULT ENABLED DISABLED]},
  :categoricalThresholdConfig {:value number}},
 :name string,
 :description string,
 :etag string,
 :labels object}

optional:
updateMask <string> Field mask is used to specify the fields to be overwritten in the EntityType resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. Updatable fields: * `description` * `labels` * `monitoring_config.snapshot_analysis.disabled` * `monitoring_config.snapshot_analysis.monitoring_interval_days` * `monitoring_config.snapshot_analysis.staleness_days` * `monitoring_config.import_features_analysis.state` * `monitoring_config.import_features_analysis.anomaly_detection_baseline` * `monitoring_config.numerical_threshold_config.value` * `monitoring_config.categorical_threshold_config.value` * `offline_storage_ttl_days`"
  ([name GoogleCloudAiplatformV1EntityType]
    (projects-locations-featurestores-entityTypes-patch
      name
      GoogleCloudAiplatformV1EntityType
      nil))
  ([name GoogleCloudAiplatformV1EntityType optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1EntityType})))

(defn projects-locations-featurestores-entityTypes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
permissions <string> The set of permissions to check for the `resource`. Permissions with wildcards (such as `*` or `storage.*`) are not allowed. For more information see [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions)."
  ([resource]
    (projects-locations-featurestores-entityTypes-testIamPermissions
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:testIamPermissions",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-create
  "Creates a new EntityType in a given Featurestore.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Featurestore to create EntityTypes. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}`
GoogleCloudAiplatformV1EntityType:
{:createTime string,
 :offlineStorageTtlDays integer,
 :updateTime string,
 :monitoringConfig
 {:numericalThresholdConfig {:value number},
  :snapshotAnalysis
  {:disabled boolean,
   :monitoringIntervalDays integer,
   :stalenessDays integer},
  :importFeaturesAnalysis
  {:anomalyDetectionBaseline
   [BASELINE_UNSPECIFIED
    LATEST_STATS
    MOST_RECENT_SNAPSHOT_STATS
    PREVIOUS_IMPORT_FEATURES_STATS],
   :state [STATE_UNSPECIFIED DEFAULT ENABLED DISABLED]},
  :categoricalThresholdConfig {:value number}},
 :name string,
 :description string,
 :etag string,
 :labels object}

optional:
entityTypeId <string> Required. The ID to use for the EntityType, which will become the final component of the EntityType's resource name. This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first character cannot be a number. The value must be unique within a featurestore."
  ([parent GoogleCloudAiplatformV1EntityType]
    (projects-locations-featurestores-entityTypes-create
      parent
      GoogleCloudAiplatformV1EntityType
      nil))
  ([parent GoogleCloudAiplatformV1EntityType optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/entityTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1EntityType})))

(defn projects-locations-featurestores-entityTypes-deleteFeatureValues
  "Delete Feature values from Featurestore. The progress of the deletion is tracked by the returned operation. The deleted feature values are guaranteed to be invisible to subsequent read operations after the operation is marked as successfully done. If a delete feature values operation fails, the feature values returned from reads and exports may be inconsistent. If consistency is required, the caller must retry the same delete request again and wait till the new operation returned is marked as successfully done.
https://cloud.google.com/vertex-ai

entityType <string> Required. The resource name of the EntityType grouping the Features for which values are being deleted from. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entityType}`
GoogleCloudAiplatformV1DeleteFeatureValuesRequest:
{:selectTimeRangeAndFeature
 {:timeRange {:endTime string, :startTime string},
  :skipOnlineStorageDelete boolean,
  :featureSelector {:idMatcher {:ids [string]}}},
 :selectEntity
 {:entityIdSelector
  {:entityIdField string, :csvSource {:gcsSource {:uris [string]}}}}}"
  [entityType GoogleCloudAiplatformV1DeleteFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+entityType}:deleteFeatureValues",
     :uri-template-args {:entityType entityType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1DeleteFeatureValuesRequest}))

(defn projects-locations-featurestores-entityTypes-exportFeatureValues
  "Exports Feature values from all the entities of a target EntityType.
https://cloud.google.com/vertex-ai

entityType <string> Required. The resource name of the EntityType from which to export Feature values. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}`
GoogleCloudAiplatformV1ExportFeatureValuesRequest:
{:featureSelector {:idMatcher {:ids [string]}},
 :snapshotExport {:snapshotTime string, :startTime string},
 :destination
 {:bigqueryDestination {:outputUri string},
  :tfrecordDestination {:gcsDestination {:outputUriPrefix string}},
  :csvDestination {:gcsDestination {:outputUriPrefix string}}},
 :settings [{:destinationField string, :featureId string}],
 :fullExport {:endTime string, :startTime string}}"
  [entityType GoogleCloudAiplatformV1ExportFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+entityType}:exportFeatureValues",
     :uri-template-args {:entityType entityType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ExportFeatureValuesRequest}))

(defn projects-locations-featurestores-entityTypes-delete
  "Deletes a single EntityType. The EntityType must not have any Features or `force` must be set to true for the request to succeed.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the EntityType to be deleted. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}`

optional:
force <boolean> If set to true, any Features for this EntityType will also be deleted. (Otherwise, the request will only work if the EntityType has no Features.)"
  ([name]
    (projects-locations-featurestores-entityTypes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/vertex-ai

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-featurestores-entityTypes-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-writeFeatureValues
  "Writes Feature values of one or more entities of an EntityType. The Feature values are merged into existing entities if any. The Feature values to be written must have timestamp within the online storage retention.
https://cloud.google.com/vertex-ai

entityType <string> Required. The resource name of the EntityType for the entities being written. Value format: `projects/{project}/locations/{location}/featurestores/ {featurestore}/entityTypes/{entityType}`. For example, for a machine learning model predicting user clicks on a website, an EntityType ID could be `user`.
GoogleCloudAiplatformV1WriteFeatureValuesRequest:
{:payloads [{:featureValues object, :entityId string}]}"
  [entityType GoogleCloudAiplatformV1WriteFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+entityType}:writeFeatureValues",
     :uri-template-args {:entityType entityType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1WriteFeatureValuesRequest}))

(defn projects-locations-featurestores-entityTypes-list
  "Lists EntityTypes in a given Featurestore.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Featurestore to list EntityTypes. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}`

optional:
readMask <string> Mask specifying which fields to read.
pageSize <integer> The maximum number of EntityTypes to return. The service may return fewer than this value. If unspecified, at most 1000 EntityTypes will be returned. The maximum value is 1000; any value greater than 1000 will be coerced to 1000.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `entity_type_id` * `create_time` * `update_time`
filter <string> Lists the EntityTypes that match the filter expression. The following filters are supported: * `create_time`: Supports `=`, `!=`, `<`, `>`, `>=`, and `<=` comparisons. Values must be in RFC 3339 format. * `update_time`: Supports `=`, `!=`, `<`, `>`, `>=`, and `<=` comparisons. Values must be in RFC 3339 format. * `labels`: Supports key-value equality as well as key presence. Examples: * `create_time > \\\"2020-01-31T15:30:00.000000Z\\\" OR update_time > \\\"2020-01-31T15:30:00.000000Z\\\"` --> EntityTypes created or updated after 2020-01-31T15:30:00.000000Z. * `labels.active = yes AND labels.env = prod` --> EntityTypes having both (active: yes) and (env: prod) labels. * `labels.env: *` --> Any EntityType which has a label with 'env' as the key."
  ([parent]
    (projects-locations-featurestores-entityTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/entityTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-streamingReadFeatureValues
  "Reads Feature values for multiple entities. Depending on their size, data for different entities may be broken up across multiple responses.
https://cloud.google.com/vertex-ai

entityType <string> Required. The resource name of the entities' type. Value format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entityType}`. For example, for a machine learning model predicting user clicks on a website, an EntityType ID could be `user`.
GoogleCloudAiplatformV1StreamingReadFeatureValuesRequest:
{:entityIds [string], :featureSelector {:idMatcher {:ids [string]}}}"
  [entityType GoogleCloudAiplatformV1StreamingReadFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+entityType}:streamingReadFeatureValues",
     :uri-template-args {:entityType entityType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1StreamingReadFeatureValuesRequest}))

(defn projects-locations-featurestores-entityTypes-features-patch
  "Updates the parameters of a single Feature.
https://cloud.google.com/vertex-ai

name <string> Immutable. Name of the Feature. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}/features/{feature}` `projects/{project}/locations/{location}/featureGroups/{feature_group}/features/{feature}` The last part feature is assigned by the client. The feature can be up to 64 characters long and can consist only of ASCII Latin letters A-Z and a-z, underscore(_), and ASCII digits 0-9 starting with a letter. The value will be unique given an entity type.
GoogleCloudAiplatformV1Feature:
{:description string,
 :labels object,
 :disableMonitoring boolean,
 :valueType
 [VALUE_TYPE_UNSPECIFIED
  BOOL
  BOOL_ARRAY
  DOUBLE
  DOUBLE_ARRAY
  INT64
  INT64_ARRAY
  STRING
  STRING_ARRAY
  BYTES
  STRUCT],
 :versionColumnName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :pointOfContact string,
 :monitoringStatsAnomalies
 [{:featureStatsAnomaly
   {:startTime string,
    :score number,
    :statsUri string,
    :anomalyUri string,
    :distributionDeviation number,
    :endTime string,
    :anomalyDetectionThreshold number},
   :objective
   [OBJECTIVE_UNSPECIFIED IMPORT_FEATURE_ANALYSIS SNAPSHOT_ANALYSIS]}]}

optional:
updateMask <string> Field mask is used to specify the fields to be overwritten in the Features resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. Updatable fields: * `description` * `labels` * `disable_monitoring` (Not supported for FeatureRegistry Feature)"
  ([name GoogleCloudAiplatformV1Feature]
    (projects-locations-featurestores-entityTypes-features-patch
      name
      GoogleCloudAiplatformV1Feature
      nil))
  ([name GoogleCloudAiplatformV1Feature optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Feature})))

(defn projects-locations-featurestores-entityTypes-features-get
  "Gets details of a single Feature.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Feature resource. Format for entity_type as parent: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}` Format for feature_group as parent: `projects/{project}/locations/{location}/featureGroups/{feature_group}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-features-create
  "Creates a new Feature in a given EntityType.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the EntityType or FeatureGroup to create a Feature. Format for entity_type as parent: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}` Format for feature_group as parent: `projects/{project}/locations/{location}/featureGroups/{feature_group}`
GoogleCloudAiplatformV1Feature:
{:description string,
 :labels object,
 :disableMonitoring boolean,
 :valueType
 [VALUE_TYPE_UNSPECIFIED
  BOOL
  BOOL_ARRAY
  DOUBLE
  DOUBLE_ARRAY
  INT64
  INT64_ARRAY
  STRING
  STRING_ARRAY
  BYTES
  STRUCT],
 :versionColumnName string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :pointOfContact string,
 :monitoringStatsAnomalies
 [{:featureStatsAnomaly
   {:startTime string,
    :score number,
    :statsUri string,
    :anomalyUri string,
    :distributionDeviation number,
    :endTime string,
    :anomalyDetectionThreshold number},
   :objective
   [OBJECTIVE_UNSPECIFIED IMPORT_FEATURE_ANALYSIS SNAPSHOT_ANALYSIS]}]}

optional:
featureId <string> Required. The ID to use for the Feature, which will become the final component of the Feature's resource name. This value may be up to 128 characters, and valid characters are `[a-z0-9_]`. The first character cannot be a number. The value must be unique within an EntityType/FeatureGroup."
  ([parent GoogleCloudAiplatformV1Feature]
    (projects-locations-featurestores-entityTypes-features-create
      parent
      GoogleCloudAiplatformV1Feature
      nil))
  ([parent GoogleCloudAiplatformV1Feature optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/features",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1Feature})))

(defn projects-locations-featurestores-entityTypes-features-delete
  "Deletes a single Feature.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the Features to be deleted. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}/features/{feature}` `projects/{project}/locations/{location}/featureGroups/{feature_group}/features/{feature}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-features-batchCreate
  "Creates a batch of Features in a given EntityType.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the EntityType to create the batch of Features under. Format: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}`
GoogleCloudAiplatformV1BatchCreateFeaturesRequest:
{:requests
 [{:feature
   {:description string,
    :labels object,
    :disableMonitoring boolean,
    :valueType
    [VALUE_TYPE_UNSPECIFIED
     BOOL
     BOOL_ARRAY
     DOUBLE
     DOUBLE_ARRAY
     INT64
     INT64_ARRAY
     STRING
     STRING_ARRAY
     BYTES
     STRUCT],
    :versionColumnName string,
    :name string,
    :createTime string,
    :etag string,
    :updateTime string,
    :pointOfContact string,
    :monitoringStatsAnomalies
    [{:featureStatsAnomaly
      {:startTime string,
       :score number,
       :statsUri string,
       :anomalyUri string,
       :distributionDeviation number,
       :endTime string,
       :anomalyDetectionThreshold number},
      :objective
      [OBJECTIVE_UNSPECIFIED
       IMPORT_FEATURE_ANALYSIS
       SNAPSHOT_ANALYSIS]}]},
   :parent string,
   :featureId string}]}"
  [parent GoogleCloudAiplatformV1BatchCreateFeaturesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/features:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1BatchCreateFeaturesRequest}))

(defn projects-locations-featurestores-entityTypes-features-list
  "Lists Features in a given EntityType.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list Features. Format for entity_type as parent: `projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}` Format for feature_group as parent: `projects/{project}/locations/{location}/featureGroups/{feature_group}`

optional:
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `feature_id` * `value_type` (Not supported for FeatureRegistry Feature) * `create_time` * `update_time`
readMask <string> Mask specifying which fields to read.
filter <string> Lists the Features that match the filter expression. The following filters are supported: * `value_type`: Supports = and != comparisons. * `create_time`: Supports =, !=, <, >, >=, and <= comparisons. Values must be in RFC 3339 format. * `update_time`: Supports =, !=, <, >, >=, and <= comparisons. Values must be in RFC 3339 format. * `labels`: Supports key-value equality as well as key presence. Examples: * `value_type = DOUBLE` --> Features whose type is DOUBLE. * `create_time > \\\"2020-01-31T15:30:00.000000Z\\\" OR update_time > \\\"2020-01-31T15:30:00.000000Z\\\"` --> EntityTypes created or updated after 2020-01-31T15:30:00.000000Z. * `labels.active = yes AND labels.env = prod` --> Features having both (active: yes) and (env: prod) labels. * `labels.env: *` --> Any Feature which has a label with 'env' as the key.
pageSize <integer> The maximum number of Features to return. The service may return fewer than this value. If unspecified, at most 1000 Features will be returned. The maximum value is 1000; any value greater than 1000 will be coerced to 1000.
latestStatsCount <integer> Only applicable for Vertex AI Feature Store (Legacy). If set, return the most recent ListFeaturesRequest.latest_stats_count of stats for each Feature in response. Valid value is [0, 10]. If number of stats exists < ListFeaturesRequest.latest_stats_count, return all existing stats."
  ([parent]
    (projects-locations-featurestores-entityTypes-features-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/features",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-features-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-featurestores-entityTypes-features-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-features-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-features-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-features-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-featurestores-entityTypes-features-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-features-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featurestores-entityTypes-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-featurestores-entityTypes-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featurestores-entityTypes-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-featurestores-entityTypes-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-indexEndpoints-get
  "Gets an IndexEndpoint.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the IndexEndpoint resource. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexEndpoints-patch
  "Updates an IndexEndpoint.
https://cloud.google.com/vertex-ai

name <string> Output only. The resource name of the IndexEndpoint.
GoogleCloudAiplatformV1IndexEndpoint:
{:description string,
 :labels object,
 :publicEndpointDomainName string,
 :encryptionSpec {:kmsKeyName string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :publicEndpointEnabled boolean,
 :deployedIndexes
 [{:automaticResources
   {:minReplicaCount integer, :maxReplicaCount integer},
   :index string,
   :displayName string,
   :dedicatedResources
   {:machineSpec
    {:acceleratorCount integer,
     :machineType string,
     :acceleratorType
     [ACCELERATOR_TYPE_UNSPECIFIED
      NVIDIA_TESLA_K80
      NVIDIA_TESLA_P100
      NVIDIA_TESLA_V100
      NVIDIA_TESLA_P4
      NVIDIA_TESLA_T4
      NVIDIA_TESLA_A100
      NVIDIA_A100_80GB
      NVIDIA_L4
      NVIDIA_H100_80GB
      TPU_V2
      TPU_V3
      TPU_V4_POD
      TPU_V5_LITEPOD],
     :tpuTopology string},
    :minReplicaCount integer,
    :autoscalingMetricSpecs [{:metricName string, :target integer}],
    :maxReplicaCount integer},
   :createTime string,
   :reservedIpRanges [string],
   :indexSyncTime string,
   :enableAccessLogging boolean,
   :id string,
   :privateEndpoints
   {:serviceAttachment string,
    :pscAutomatedEndpoints
    [{:network string, :projectId string, :matchAddress string}],
    :matchGrpcAddress string},
   :deploymentGroup string,
   :deployedIndexAuthConfig
   {:authProvider {:allowedIssuers [string], :audiences [string]}}}],
 :updateTime string,
 :enablePrivateServiceConnect boolean,
 :privateServiceConnectConfig
 {:enablePrivateServiceConnect boolean, :projectAllowlist [string]},
 :network string}

optional:
updateMask <string> Required. The update mask applies to the resource. See google.protobuf.FieldMask."
  ([name GoogleCloudAiplatformV1IndexEndpoint]
    (projects-locations-indexEndpoints-patch
      name
      GoogleCloudAiplatformV1IndexEndpoint
      nil))
  ([name GoogleCloudAiplatformV1IndexEndpoint optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1IndexEndpoint})))

(defn projects-locations-indexEndpoints-undeployIndex
  "Undeploys an Index from an IndexEndpoint, removing a DeployedIndex from it, and freeing all resources it's using.
https://cloud.google.com/vertex-ai

indexEndpoint <string> Required. The name of the IndexEndpoint resource from which to undeploy an Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
GoogleCloudAiplatformV1UndeployIndexRequest:
{:deployedIndexId string}"
  [indexEndpoint GoogleCloudAiplatformV1UndeployIndexRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+indexEndpoint}:undeployIndex",
     :uri-template-args {:indexEndpoint indexEndpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1UndeployIndexRequest}))

(defn projects-locations-indexEndpoints-create
  "Creates an IndexEndpoint.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the IndexEndpoint in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1IndexEndpoint:
{:description string,
 :labels object,
 :publicEndpointDomainName string,
 :encryptionSpec {:kmsKeyName string},
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :publicEndpointEnabled boolean,
 :deployedIndexes
 [{:automaticResources
   {:minReplicaCount integer, :maxReplicaCount integer},
   :index string,
   :displayName string,
   :dedicatedResources
   {:machineSpec
    {:acceleratorCount integer,
     :machineType string,
     :acceleratorType
     [ACCELERATOR_TYPE_UNSPECIFIED
      NVIDIA_TESLA_K80
      NVIDIA_TESLA_P100
      NVIDIA_TESLA_V100
      NVIDIA_TESLA_P4
      NVIDIA_TESLA_T4
      NVIDIA_TESLA_A100
      NVIDIA_A100_80GB
      NVIDIA_L4
      NVIDIA_H100_80GB
      TPU_V2
      TPU_V3
      TPU_V4_POD
      TPU_V5_LITEPOD],
     :tpuTopology string},
    :minReplicaCount integer,
    :autoscalingMetricSpecs [{:metricName string, :target integer}],
    :maxReplicaCount integer},
   :createTime string,
   :reservedIpRanges [string],
   :indexSyncTime string,
   :enableAccessLogging boolean,
   :id string,
   :privateEndpoints
   {:serviceAttachment string,
    :pscAutomatedEndpoints
    [{:network string, :projectId string, :matchAddress string}],
    :matchGrpcAddress string},
   :deploymentGroup string,
   :deployedIndexAuthConfig
   {:authProvider {:allowedIssuers [string], :audiences [string]}}}],
 :updateTime string,
 :enablePrivateServiceConnect boolean,
 :privateServiceConnectConfig
 {:enablePrivateServiceConnect boolean, :projectAllowlist [string]},
 :network string}"
  [parent GoogleCloudAiplatformV1IndexEndpoint]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/indexEndpoints",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1IndexEndpoint}))

(defn projects-locations-indexEndpoints-readIndexDatapoints
  "Reads the datapoints/vectors of the given IDs. A maximum of 1000 datapoints can be retrieved in a batch.
https://cloud.google.com/vertex-ai

indexEndpoint <string> Required. The name of the index endpoint. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
GoogleCloudAiplatformV1ReadIndexDatapointsRequest:
{:ids [string], :deployedIndexId string}"
  [indexEndpoint GoogleCloudAiplatformV1ReadIndexDatapointsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+indexEndpoint}:readIndexDatapoints",
     :uri-template-args {:indexEndpoint indexEndpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1ReadIndexDatapointsRequest}))

(defn projects-locations-indexEndpoints-delete
  "Deletes an IndexEndpoint.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the IndexEndpoint resource to be deleted. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexEndpoints-list
  "Lists IndexEndpoints in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location from which to list the IndexEndpoints. Format: `projects/{project}/locations/{location}`

optional:
filter <string> Optional. An expression for filtering the results of the request. For field names both snake_case and camelCase are supported. * `index_endpoint` supports = and !=. `index_endpoint` represents the IndexEndpoint ID, ie. the last segment of the IndexEndpoint's resourcename. * `display_name` supports =, != and regex() (uses [re2](https://github.com/google/re2/wiki/Syntax) syntax) * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* or labels:key - key existence A key including a space must be quoted. `labels.\"a key\"`. Some examples: * `index_endpoint=\"1\"` * `display_name=\"myDisplayName\"` * `regex(display_name, \"^A\") -> The display name starts with an A. * `labels.myKey=\"myValue\"`
pageSize <integer> Optional. The standard list page size.
readMask <string> Optional. Mask specifying which fields to read."
  ([parent] (projects-locations-indexEndpoints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/indexEndpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-indexEndpoints-mutateDeployedIndex
  "Update an existing DeployedIndex under an IndexEndpoint.
https://cloud.google.com/vertex-ai

indexEndpoint <string> Required. The name of the IndexEndpoint resource into which to deploy an Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
GoogleCloudAiplatformV1DeployedIndex:
{:automaticResources
 {:minReplicaCount integer, :maxReplicaCount integer},
 :index string,
 :displayName string,
 :dedicatedResources
 {:machineSpec
  {:acceleratorCount integer,
   :machineType string,
   :acceleratorType
   [ACCELERATOR_TYPE_UNSPECIFIED
    NVIDIA_TESLA_K80
    NVIDIA_TESLA_P100
    NVIDIA_TESLA_V100
    NVIDIA_TESLA_P4
    NVIDIA_TESLA_T4
    NVIDIA_TESLA_A100
    NVIDIA_A100_80GB
    NVIDIA_L4
    NVIDIA_H100_80GB
    TPU_V2
    TPU_V3
    TPU_V4_POD
    TPU_V5_LITEPOD],
   :tpuTopology string},
  :minReplicaCount integer,
  :autoscalingMetricSpecs [{:metricName string, :target integer}],
  :maxReplicaCount integer},
 :createTime string,
 :reservedIpRanges [string],
 :indexSyncTime string,
 :enableAccessLogging boolean,
 :id string,
 :privateEndpoints
 {:serviceAttachment string,
  :pscAutomatedEndpoints
  [{:network string, :projectId string, :matchAddress string}],
  :matchGrpcAddress string},
 :deploymentGroup string,
 :deployedIndexAuthConfig
 {:authProvider {:allowedIssuers [string], :audiences [string]}}}"
  [indexEndpoint GoogleCloudAiplatformV1DeployedIndex]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+indexEndpoint}:mutateDeployedIndex",
     :uri-template-args {:indexEndpoint indexEndpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1DeployedIndex}))

(defn projects-locations-indexEndpoints-deployIndex
  "Deploys an Index into this IndexEndpoint, creating a DeployedIndex within it. Only non-empty Indexes can be deployed.
https://cloud.google.com/vertex-ai

indexEndpoint <string> Required. The name of the IndexEndpoint resource into which to deploy an Index. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
GoogleCloudAiplatformV1DeployIndexRequest:
{:deployedIndex
 {:automaticResources
  {:minReplicaCount integer, :maxReplicaCount integer},
  :index string,
  :displayName string,
  :dedicatedResources
  {:machineSpec
   {:acceleratorCount integer,
    :machineType string,
    :acceleratorType
    [ACCELERATOR_TYPE_UNSPECIFIED
     NVIDIA_TESLA_K80
     NVIDIA_TESLA_P100
     NVIDIA_TESLA_V100
     NVIDIA_TESLA_P4
     NVIDIA_TESLA_T4
     NVIDIA_TESLA_A100
     NVIDIA_A100_80GB
     NVIDIA_L4
     NVIDIA_H100_80GB
     TPU_V2
     TPU_V3
     TPU_V4_POD
     TPU_V5_LITEPOD],
    :tpuTopology string},
   :minReplicaCount integer,
   :autoscalingMetricSpecs [{:metricName string, :target integer}],
   :maxReplicaCount integer},
  :createTime string,
  :reservedIpRanges [string],
  :indexSyncTime string,
  :enableAccessLogging boolean,
  :id string,
  :privateEndpoints
  {:serviceAttachment string,
   :pscAutomatedEndpoints
   [{:network string, :projectId string, :matchAddress string}],
   :matchGrpcAddress string},
  :deploymentGroup string,
  :deployedIndexAuthConfig
  {:authProvider {:allowedIssuers [string], :audiences [string]}}}}"
  [indexEndpoint GoogleCloudAiplatformV1DeployIndexRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+indexEndpoint}:deployIndex",
     :uri-template-args {:indexEndpoint indexEndpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1DeployIndexRequest}))

(defn projects-locations-indexEndpoints-findNeighbors
  "Finds the nearest neighbors of each vector within the request.
https://cloud.google.com/vertex-ai

indexEndpoint <string> Required. The name of the index endpoint. Format: `projects/{project}/locations/{location}/indexEndpoints/{index_endpoint}`
GoogleCloudAiplatformV1FindNeighborsRequest:
{:deployedIndexId string,
 :returnFullDatapoint boolean,
 :queries
 [{:neighborCount integer,
   :datapoint
   {:restricts
    [{:namespace string, :denyList [string], :allowList [string]}],
    :featureVector [number],
    :crowdingTag {:crowdingAttribute string},
    :numericRestricts
    [{:valueInt string,
      :namespace string,
      :valueFloat number,
      :op
      [OPERATOR_UNSPECIFIED
       LESS
       LESS_EQUAL
       EQUAL
       GREATER_EQUAL
       GREATER
       NOT_EQUAL],
      :valueDouble number}],
    :sparseEmbedding {:dimensions [string], :values [number]},
    :datapointId string},
   :perCrowdingAttributeNeighborCount integer,
   :fractionLeafNodesToSearchOverride number,
   :approximateNeighborCount integer,
   :rrf {:alpha number}}]}"
  [indexEndpoint GoogleCloudAiplatformV1FindNeighborsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+indexEndpoint}:findNeighbors",
     :uri-template-args {:indexEndpoint indexEndpoint},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1FindNeighborsRequest}))

(defn projects-locations-indexEndpoints-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexEndpoints-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexEndpoints-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-indexEndpoints-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-indexEndpoints-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-indexEndpoints-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (projects-locations-indexEndpoints-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-batchPredictionJobs-cancel
  "Cancels a BatchPredictionJob. Starts asynchronous cancellation on the BatchPredictionJob. The server makes the best effort to cancel the job, but success is not guaranteed. Clients can use JobService.GetBatchPredictionJob or other methods to check whether the cancellation succeeded or whether the job completed despite cancellation. On a successful cancellation, the BatchPredictionJob is not deleted;instead its BatchPredictionJob.state is set to `CANCELLED`. Any files already outputted by the job are not deleted.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the BatchPredictionJob to cancel. Format: `projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`
GoogleCloudAiplatformV1CancelBatchPredictionJobRequest:
object"
  [name GoogleCloudAiplatformV1CancelBatchPredictionJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1CancelBatchPredictionJobRequest}))

(defn projects-locations-batchPredictionJobs-list
  "Lists BatchPredictionJobs in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the BatchPredictionJobs from. Format: `projects/{project}/locations/{location}`

optional:
readMask <string> Mask specifying which fields to read.
filter <string> The standard list filter. Supported fields: * `display_name` supports `=`, `!=` comparisons, and `:` wildcard. * `model_display_name` supports `=`, `!=` comparisons. * `state` supports `=`, `!=` comparisons. * `create_time` supports `=`, `!=`,`<`, `<=`,`>`, `>=` comparisons. `create_time` must be in RFC 3339 format. * `labels` supports general map functions that is: `labels.key=value` - key:value equality `labels.key:* - key existence Some examples of using the filter are: * `state=\"JOB_STATE_SUCCEEDED\" AND display_name:\"my_job_*\"` * `state!=\"JOB_STATE_FAILED\" OR display_name=\"my_job\"` * `NOT display_name=\"my_job\"` * `create_time>\"2021-05-18T00:00:00Z\"` * `labels.keyA=valueA` * `labels.keyB:*`
pageSize <integer> The standard list page size."
  ([parent] (projects-locations-batchPredictionJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/batchPredictionJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-batchPredictionJobs-get
  "Gets a BatchPredictionJob
https://cloud.google.com/vertex-ai

name <string> Required. The name of the BatchPredictionJob resource. Format: `projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-batchPredictionJobs-delete
  "Deletes a BatchPredictionJob. Can only be called on jobs that already finished.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the BatchPredictionJob resource to be deleted. Format: `projects/{project}/locations/{location}/batchPredictionJobs/{batch_prediction_job}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-batchPredictionJobs-create
  "Creates a BatchPredictionJob. A BatchPredictionJob once created will right away be attempted to start.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the BatchPredictionJob in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1BatchPredictionJob:
{:serviceAccount string,
 :modelVersionId string,
 :labels object,
 :disableContainerLogging boolean,
 :modelParameters any,
 :outputInfo
 {:gcsOutputDirectory string,
  :bigqueryOutputDataset string,
  :bigqueryOutputTable string},
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :explanationSpec
 {:metadata
  {:outputs object,
   :inputs object,
   :latentSpaceSource string,
   :featureAttributionsSchemaUri string},
  :parameters
  {:outputIndices [any],
   :examples
   {:exampleGcsSource
    {:gcsSource GoogleCloudAiplatformV1GcsSource,
     :dataFormat [DATA_FORMAT_UNSPECIFIED JSONL]},
    :presets
    {:modality [MODALITY_UNSPECIFIED IMAGE TEXT TABULAR],
     :query [PRECISE FAST]},
    :nearestNeighborSearchConfig any,
    :neighborCount integer},
   :xraiAttribution
   {:blurBaselineConfig {:maxBlurSigma number},
    :stepCount integer,
    :smoothGradConfig
    {:noisySampleCount integer,
     :featureNoiseSigma GoogleCloudAiplatformV1FeatureNoiseSigma,
     :noiseSigma number}},
   :topK integer,
   :sampledShapleyAttribution {:pathCount integer},
   :integratedGradientsAttribution
   {:smoothGradConfig
    {:noisySampleCount integer,
     :featureNoiseSigma GoogleCloudAiplatformV1FeatureNoiseSigma,
     :noiseSigma number},
    :blurBaselineConfig {:maxBlurSigma number},
    :stepCount integer}}},
 :dedicatedResources
 {:startingReplicaCount integer,
  :maxReplicaCount integer,
  :machineSpec
  {:acceleratorCount integer,
   :machineType string,
   :acceleratorType
   [ACCELERATOR_TYPE_UNSPECIFIED
    NVIDIA_TESLA_K80
    NVIDIA_TESLA_P100
    NVIDIA_TESLA_V100
    NVIDIA_TESLA_P4
    NVIDIA_TESLA_T4
    NVIDIA_TESLA_A100
    NVIDIA_A100_80GB
    NVIDIA_L4
    NVIDIA_H100_80GB
    TPU_V2
    TPU_V3
    TPU_V4_POD
    TPU_V5_LITEPOD],
   :tpuTopology string}},
 :completionStats
 {:successfulForecastPointCount string,
  :incompleteCount string,
  :failedCount string,
  :successfulCount string},
 :name string,
 :endTime string,
 :createTime string,
 :state
 [JOB_STATE_UNSPECIFIED
  JOB_STATE_QUEUED
  JOB_STATE_PENDING
  JOB_STATE_RUNNING
  JOB_STATE_SUCCEEDED
  JOB_STATE_FAILED
  JOB_STATE_CANCELLING
  JOB_STATE_CANCELLED
  JOB_STATE_PAUSED
  JOB_STATE_EXPIRED
  JOB_STATE_UPDATING
  JOB_STATE_PARTIALLY_SUCCEEDED],
 :updateTime string,
 :outputConfig
 {:predictionsFormat string,
  :bigqueryDestination {:outputUri string},
  :gcsDestination {:outputUriPrefix string}},
 :unmanagedContainerModel
 {:containerSpec
  {:args [string],
   :healthRoute string,
   :imageUri string,
   :healthProbe
   {:exec {:command [string]},
    :periodSeconds integer,
    :timeoutSeconds integer},
   :command [string],
   :env [{:value string, :name string}],
   :deploymentTimeout string,
   :ports [{:containerPort integer}],
   :startupProbe
   {:exec {:command [string]},
    :periodSeconds integer,
    :timeoutSeconds integer},
   :grpcPorts [{:containerPort integer}],
   :sharedMemorySizeMb string,
   :predictRoute string},
  :predictSchemata
  {:predictionSchemaUri string,
   :instanceSchemaUri string,
   :parametersSchemaUri string},
  :artifactUri string},
 :partialFailures
 [{:message string, :code integer, :details [object]}],
 :error {:message string, :code integer, :details [object]},
 :instanceConfig
 {:excludedFields [string],
  :keyField string,
  :includedFields [string],
  :instanceType string},
 :generateExplanation boolean,
 :inputConfig
 {:instancesFormat string,
  :gcsSource {:uris [string]},
  :bigquerySource {:inputUri string}},
 :manualBatchTuningParameters {:batchSize integer},
 :resourcesConsumed {:replicaHours number},
 :model string}"
  [parent GoogleCloudAiplatformV1BatchPredictionJob]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+parent}/batchPredictionJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1BatchPredictionJob}))

(defn projects-locations-featureOnlineStores-create
  "Creates a new FeatureOnlineStore in a given project and location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create FeatureOnlineStores. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1FeatureOnlineStore:
{:labels object,
 :optimized object,
 :encryptionSpec {:kmsKeyName string},
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED STABLE UPDATING],
 :updateTime string,
 :dedicatedServingEndpoint {:publicEndpointDomainName string},
 :bigtable
 {:autoScaling
  {:cpuUtilizationTarget integer,
   :maxNodeCount integer,
   :minNodeCount integer}}}

optional:
featureOnlineStoreId <string> Required. The ID to use for this FeatureOnlineStore, which will become the final component of the FeatureOnlineStore's resource name. This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first character cannot be a number. The value must be unique within the project and location."
  ([parent GoogleCloudAiplatformV1FeatureOnlineStore]
    (projects-locations-featureOnlineStores-create
      parent
      GoogleCloudAiplatformV1FeatureOnlineStore
      nil))
  ([parent GoogleCloudAiplatformV1FeatureOnlineStore optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featureOnlineStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1FeatureOnlineStore})))

(defn projects-locations-featureOnlineStores-list
  "Lists FeatureOnlineStores in a given project and location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list FeatureOnlineStores. Format: `projects/{project}/locations/{location}`

optional:
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported Fields: * `create_time` * `update_time`
filter <string> Lists the FeatureOnlineStores that match the filter expression. The following fields are supported: * `create_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `update_time`: Supports `=`, `!=`, `<`, `>`, `<=`, and `>=` comparisons. Values must be in RFC 3339 format. * `labels`: Supports key-value equality and key presence. Examples: * `create_time > \"2020-01-01\" OR update_time > \"2020-01-01\"` FeatureOnlineStores created or updated after 2020-01-01. * `labels.env = \"prod\"` FeatureOnlineStores with label \"env\" set to \"prod\".
pageSize <integer> The maximum number of FeatureOnlineStores to return. The service may return fewer than this value. If unspecified, at most 100 FeatureOnlineStores will be returned. The maximum value is 100; any value greater than 100 will be coerced to 100."
  ([parent] (projects-locations-featureOnlineStores-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featureOnlineStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-get
  "Gets details of a single FeatureOnlineStore.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the FeatureOnlineStore resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureOnlineStores-delete
  "Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not contain any FeatureViews.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the FeatureOnlineStore to be deleted. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`

optional:
force <boolean> If set to true, any FeatureViews and Features for this FeatureOnlineStore will also be deleted. (Otherwise, the request will only work if the FeatureOnlineStore has no FeatureViews.)"
  ([name] (projects-locations-featureOnlineStores-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-patch
  "Updates the parameters of a single FeatureOnlineStore.
https://cloud.google.com/vertex-ai

name <string> Identifier. Name of the FeatureOnlineStore. Format: `projects/{project}/locations/{location}/featureOnlineStores/{featureOnlineStore}`
GoogleCloudAiplatformV1FeatureOnlineStore:
{:labels object,
 :optimized object,
 :encryptionSpec {:kmsKeyName string},
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED STABLE UPDATING],
 :updateTime string,
 :dedicatedServingEndpoint {:publicEndpointDomainName string},
 :bigtable
 {:autoScaling
  {:cpuUtilizationTarget integer,
   :maxNodeCount integer,
   :minNodeCount integer}}}

optional:
updateMask <string> Field mask is used to specify the fields to be overwritten in the FeatureOnlineStore resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. Updatable fields: * `big_query_source` * `bigtable` * `labels` * `sync_config`"
  ([name GoogleCloudAiplatformV1FeatureOnlineStore]
    (projects-locations-featureOnlineStores-patch
      name
      GoogleCloudAiplatformV1FeatureOnlineStore
      nil))
  ([name GoogleCloudAiplatformV1FeatureOnlineStore optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1FeatureOnlineStore})))

(defn projects-locations-featureOnlineStores-featureViews-get
  "Gets details of a single FeatureView.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the FeatureView resource. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureOnlineStores-featureViews-delete
  "Deletes a single FeatureView.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the FeatureView to be deleted. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureOnlineStores-featureViews-sync
  "Triggers on-demand sync for the FeatureView.
https://cloud.google.com/vertex-ai

featureView <string> Required. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
GoogleCloudAiplatformV1SyncFeatureViewRequest:
object"
  [featureView GoogleCloudAiplatformV1SyncFeatureViewRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+featureView}:sync",
     :uri-template-args {:featureView featureView},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1SyncFeatureViewRequest}))

(defn projects-locations-featureOnlineStores-featureViews-fetchFeatureValues
  "Fetch feature values under a FeatureView.
https://cloud.google.com/vertex-ai

featureView <string> Required. FeatureView resource format `projects/{project}/locations/{location}/featureOnlineStores/{featureOnlineStore}/featureViews/{featureView}`
GoogleCloudAiplatformV1FetchFeatureValuesRequest:
{:dataFormat
 [FEATURE_VIEW_DATA_FORMAT_UNSPECIFIED KEY_VALUE PROTO_STRUCT],
 :dataKey {:key string, :compositeKey {:parts [string]}}}"
  [featureView GoogleCloudAiplatformV1FetchFeatureValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+featureView}:fetchFeatureValues",
     :uri-template-args {:featureView featureView},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1FetchFeatureValuesRequest}))

(defn projects-locations-featureOnlineStores-featureViews-list
  "Lists FeatureViews in a given FeatureOnlineStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the FeatureOnlineStore to list FeatureViews. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`

optional:
pageSize <integer> The maximum number of FeatureViews to return. The service may return fewer than this value. If unspecified, at most 1000 FeatureViews will be returned. The maximum value is 1000; any value greater than 1000 will be coerced to 1000.
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `feature_view_id` * `create_time` * `update_time`
filter <string> Lists the FeatureViews that match the filter expression. The following filters are supported: * `create_time`: Supports `=`, `!=`, `<`, `>`, `>=`, and `<=` comparisons. Values must be in RFC 3339 format. * `update_time`: Supports `=`, `!=`, `<`, `>`, `>=`, and `<=` comparisons. Values must be in RFC 3339 format. * `labels`: Supports key-value equality as well as key presence. Examples: * `create_time > \\\"2020-01-31T15:30:00.000000Z\\\" OR update_time > \\\"2020-01-31T15:30:00.000000Z\\\"` --> FeatureViews created or updated after 2020-01-31T15:30:00.000000Z. * `labels.active = yes AND labels.env = prod` --> FeatureViews having both (active: yes) and (env: prod) labels. * `labels.env: *` --> Any FeatureView which has a label with 'env' as the key."
  ([parent]
    (projects-locations-featureOnlineStores-featureViews-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featureViews",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-featureViews-patch
  "Updates the parameters of a single FeatureView.
https://cloud.google.com/vertex-ai

name <string> Identifier. Name of the FeatureView. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`
GoogleCloudAiplatformV1FeatureView:
{:labels object,
 :name string,
 :createTime string,
 :etag string,
 :syncConfig {:cron string},
 :indexConfig
 {:treeAhConfig {:leafNodeEmbeddingCount string},
  :bruteForceConfig object,
  :embeddingColumn string,
  :crowdingColumn string,
  :embeddingDimension integer,
  :filterColumns [string],
  :distanceMeasureType
  [DISTANCE_MEASURE_TYPE_UNSPECIFIED
   SQUARED_L2_DISTANCE
   COSINE_DISTANCE
   DOT_PRODUCT_DISTANCE]},
 :updateTime string,
 :bigQuerySource {:entityIdColumns [string], :uri string},
 :featureRegistrySource
 {:featureGroups [{:featureIds [string], :featureGroupId string}],
  :projectNumber string}}

optional:
updateMask <string> Field mask is used to specify the fields to be overwritten in the FeatureView resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then only the non-empty fields present in the request will be overwritten. Set the update_mask to `*` to override all fields. Updatable fields: * `labels` * `serviceAgentType`"
  ([name GoogleCloudAiplatformV1FeatureView]
    (projects-locations-featureOnlineStores-featureViews-patch
      name
      GoogleCloudAiplatformV1FeatureView
      nil))
  ([name GoogleCloudAiplatformV1FeatureView optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1FeatureView})))

(defn projects-locations-featureOnlineStores-featureViews-create
  "Creates a new FeatureView in a given FeatureOnlineStore.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the FeatureOnlineStore to create FeatureViews. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}`
GoogleCloudAiplatformV1FeatureView:
{:labels object,
 :name string,
 :createTime string,
 :etag string,
 :syncConfig {:cron string},
 :indexConfig
 {:treeAhConfig {:leafNodeEmbeddingCount string},
  :bruteForceConfig object,
  :embeddingColumn string,
  :crowdingColumn string,
  :embeddingDimension integer,
  :filterColumns [string],
  :distanceMeasureType
  [DISTANCE_MEASURE_TYPE_UNSPECIFIED
   SQUARED_L2_DISTANCE
   COSINE_DISTANCE
   DOT_PRODUCT_DISTANCE]},
 :updateTime string,
 :bigQuerySource {:entityIdColumns [string], :uri string},
 :featureRegistrySource
 {:featureGroups [{:featureIds [string], :featureGroupId string}],
  :projectNumber string}}

optional:
runSyncImmediately <boolean> Immutable. If set to true, one on demand sync will be run immediately, regardless whether the FeatureView.sync_config is configured or not.
featureViewId <string> Required. The ID to use for the FeatureView, which will become the final component of the FeatureView's resource name. This value may be up to 60 characters, and valid characters are `[a-z0-9_]`. The first character cannot be a number. The value must be unique within a FeatureOnlineStore."
  ([parent GoogleCloudAiplatformV1FeatureView]
    (projects-locations-featureOnlineStores-featureViews-create
      parent
      GoogleCloudAiplatformV1FeatureView
      nil))
  ([parent GoogleCloudAiplatformV1FeatureView optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featureViews",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1FeatureView})))

(defn projects-locations-featureOnlineStores-featureViews-searchNearestEntities
  "Search the nearest entities under a FeatureView. Search only works for indexable feature view; if a feature view isn't indexable, returns Invalid argument response.
https://cloud.google.com/vertex-ai

featureView <string> Required. FeatureView resource format `projects/{project}/locations/{location}/featureOnlineStores/{featureOnlineStore}/featureViews/{featureView}`
GoogleCloudAiplatformV1SearchNearestEntitiesRequest:
{:query
 {:neighborCount integer,
  :embedding {:value [number]},
  :perCrowdingAttributeNeighborCount integer,
  :parameters
  {:approximateNeighborCandidates integer,
   :leafNodesSearchFraction number},
  :entityId string,
  :stringFilters
  [{:name string, :allowTokens [string], :denyTokens [string]}]},
 :returnFullEntity boolean}"
  [featureView GoogleCloudAiplatformV1SearchNearestEntitiesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+featureView}:searchNearestEntities",
     :uri-template-args {:featureView featureView},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1SearchNearestEntitiesRequest}))

(defn projects-locations-featureOnlineStores-featureViews-featureViewSyncs-list
  "Lists FeatureViewSyncs in a given FeatureView.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the FeatureView to list FeatureViewSyncs. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}`

optional:
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `create_time`
filter <string> Lists the FeatureViewSyncs that match the filter expression. The following filters are supported: * `create_time`: Supports `=`, `!=`, `<`, `>`, `>=`, and `<=` comparisons. Values must be in RFC 3339 format. Examples: * `create_time > \\\"2020-01-31T15:30:00.000000Z\\\"` --> FeatureViewSyncs created after 2020-01-31T15:30:00.000000Z.
pageSize <integer> The maximum number of FeatureViewSyncs to return. The service may return fewer than this value. If unspecified, at most 1000 FeatureViewSyncs will be returned. The maximum value is 1000; any value greater than 1000 will be coerced to 1000."
  ([parent]
    (projects-locations-featureOnlineStores-featureViews-featureViewSyncs-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/featureViewSyncs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-featureViews-featureViewSyncs-get
  "Gets details of a single FeatureViewSync.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the FeatureViewSync resource. Format: `projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}/featureViewSyncs/{feature_view_sync}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureOnlineStores-featureViews-operations-listWait
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-featureOnlineStores-featureViews-operations-listWait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-featureViews-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-featureOnlineStores-featureViews-operations-wait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-featureViews-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureOnlineStores-featureViews-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureOnlineStores-operations-listWait
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-featureOnlineStores-operations-listWait
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-featureOnlineStores-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-featureOnlineStores-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-featureOnlineStores-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-persistentResources-delete
  "Deletes a PersistentResource.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the PersistentResource to be deleted. Format: `projects/{project}/locations/{location}/persistentResources/{persistent_resource}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-persistentResources-reboot
  "Reboots a PersistentResource.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the PersistentResource resource. Format: `projects/{project_id_or_number}/locations/{location_id}/persistentResources/{persistent_resource_id}`
GoogleCloudAiplatformV1RebootPersistentResourceRequest:
object"
  [name GoogleCloudAiplatformV1RebootPersistentResourceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:reboot",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAiplatformV1RebootPersistentResourceRequest}))

(defn projects-locations-persistentResources-list
  "Lists PersistentResources in a Location.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to list the PersistentResources from. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> Optional. The standard list page size."
  ([parent] (projects-locations-persistentResources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/persistentResources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-persistentResources-get
  "Gets a PersistentResource.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the PersistentResource resource. Format: `projects/{project_id_or_number}/locations/{location_id}/persistentResources/{persistent_resource_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-persistentResources-patch
  "Updates a PersistentResource.
https://cloud.google.com/vertex-ai

name <string> Immutable. Resource name of a PersistentResource.
GoogleCloudAiplatformV1PersistentResource:
{:labels object,
 :resourceRuntime {:accessUris object},
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :name string,
 :createTime string,
 :reservedIpRanges [string],
 :state
 [STATE_UNSPECIFIED
  PROVISIONING
  RUNNING
  STOPPING
  ERROR
  REBOOTING
  UPDATING],
 :updateTime string,
 :error {:message string, :code integer, :details [object]},
 :resourcePools
 [{:autoscalingSpec {:minReplicaCount string, :maxReplicaCount string},
   :replicaCount string,
   :machineSpec
   {:acceleratorCount integer,
    :machineType string,
    :acceleratorType
    [ACCELERATOR_TYPE_UNSPECIFIED
     NVIDIA_TESLA_K80
     NVIDIA_TESLA_P100
     NVIDIA_TESLA_V100
     NVIDIA_TESLA_P4
     NVIDIA_TESLA_T4
     NVIDIA_TESLA_A100
     NVIDIA_A100_80GB
     NVIDIA_L4
     NVIDIA_H100_80GB
     TPU_V2
     TPU_V3
     TPU_V4_POD
     TPU_V5_LITEPOD],
    :tpuTopology string},
   :id string,
   :diskSpec {:bootDiskType string, :bootDiskSizeGb integer},
   :usedReplicaCount string}],
 :network string,
 :resourceRuntimeSpec
 {:serviceAccountSpec
  {:serviceAccount string, :enableCustomServiceAccount boolean},
  :raySpec
  {:rayMetricSpec {:disabled boolean},
   :headNodeResourcePoolId string,
   :imageUri string,
   :resourcePoolImages object}}}

optional:
updateMask <string> Required. Specify the fields to be overwritten in the PersistentResource by the update method."
  ([name GoogleCloudAiplatformV1PersistentResource]
    (projects-locations-persistentResources-patch
      name
      GoogleCloudAiplatformV1PersistentResource
      nil))
  ([name GoogleCloudAiplatformV1PersistentResource optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1PersistentResource})))

(defn projects-locations-persistentResources-create
  "Creates a PersistentResource.
https://cloud.google.com/vertex-ai

parent <string> Required. The resource name of the Location to create the PersistentResource in. Format: `projects/{project}/locations/{location}`
GoogleCloudAiplatformV1PersistentResource:
{:labels object,
 :resourceRuntime {:accessUris object},
 :encryptionSpec {:kmsKeyName string},
 :startTime string,
 :displayName string,
 :name string,
 :createTime string,
 :reservedIpRanges [string],
 :state
 [STATE_UNSPECIFIED
  PROVISIONING
  RUNNING
  STOPPING
  ERROR
  REBOOTING
  UPDATING],
 :updateTime string,
 :error {:message string, :code integer, :details [object]},
 :resourcePools
 [{:autoscalingSpec {:minReplicaCount string, :maxReplicaCount string},
   :replicaCount string,
   :machineSpec
   {:acceleratorCount integer,
    :machineType string,
    :acceleratorType
    [ACCELERATOR_TYPE_UNSPECIFIED
     NVIDIA_TESLA_K80
     NVIDIA_TESLA_P100
     NVIDIA_TESLA_V100
     NVIDIA_TESLA_P4
     NVIDIA_TESLA_T4
     NVIDIA_TESLA_A100
     NVIDIA_A100_80GB
     NVIDIA_L4
     NVIDIA_H100_80GB
     TPU_V2
     TPU_V3
     TPU_V4_POD
     TPU_V5_LITEPOD],
    :tpuTopology string},
   :id string,
   :diskSpec {:bootDiskType string, :bootDiskSizeGb integer},
   :usedReplicaCount string}],
 :network string,
 :resourceRuntimeSpec
 {:serviceAccountSpec
  {:serviceAccount string, :enableCustomServiceAccount boolean},
  :raySpec
  {:rayMetricSpec {:disabled boolean},
   :headNodeResourcePoolId string,
   :imageUri string,
   :resourcePoolImages object}}}

optional:
persistentResourceId <string> Required. The ID to use for the PersistentResource, which become the final component of the PersistentResource's resource name. The maximum length is 63 characters, and valid characters are `/^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$/`."
  ([parent GoogleCloudAiplatformV1PersistentResource]
    (projects-locations-persistentResources-create
      parent
      GoogleCloudAiplatformV1PersistentResource
      nil))
  ([parent GoogleCloudAiplatformV1PersistentResource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+parent}/persistentResources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAiplatformV1PersistentResource})))

(defn projects-locations-persistentResources-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-persistentResources-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-persistentResources-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name]
    (projects-locations-persistentResources-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-persistentResources-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://aiplatform.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-persistentResources-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vertex-ai

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name]
    (projects-locations-persistentResources-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://aiplatform.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn publishers-models-get
  "Gets a Model Garden publisher model.
https://cloud.google.com/vertex-ai

name <string> Required. The name of the PublisherModel resource. Format: `publishers/{publisher}/models/{publisher_model}`

optional:
view <string> Optional. PublisherModel view specifying which fields to read.
languageCode <string> Optional. The IETF BCP-47 language code representing the language in which the publisher model's text information should be written in (see go/bcp47)."
  ([name] (publishers-models-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://aiplatform.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

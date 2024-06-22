(ns happygapi2.bigquery
  "BigQuery API
A data platform for customers to create, manage, share and query data.
See: https://cloud.google.com/bigquery/"
  (:require [happy.oauth2.client :as client]))

(defn datasets-delete
  "Deletes the dataset specified by the datasetId value. Before you can delete a dataset, you must delete all its tables, either manually or by specifying deleteContents. Immediately after deletion, you can create another dataset with the same name.
https://cloud.google.com/bigquery/docs/reference/rest/v2/datasets/delete

projectId <string> Required. Project ID of the dataset being deleted
datasetId <string> Required. Dataset ID of dataset being deleted

optional:
deleteContents <boolean> If True, delete all the tables in the dataset. If False and the dataset contains tables, the request will fail. Default is False"
  ([projectId datasetId] (datasets-delete projectId datasetId nil))
  ([projectId datasetId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}",
       :uri-template-args {:datasetId datasetId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn datasets-get
  "Returns the dataset specified by datasetID.
https://cloud.google.com/bigquery/docs/reference/rest/v2/datasets/get

projectId <string> Required. Project ID of the requested dataset
datasetId <string> Required. Dataset ID of the requested dataset

optional:
datasetView <string> Optional. Specifies the view that determines which dataset information is returned. By default, metadata and ACL information are returned."
  ([projectId datasetId] (datasets-get projectId datasetId nil))
  ([projectId datasetId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}",
       :uri-template-args {:datasetId datasetId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn datasets-insert
  "Creates a new empty dataset.
https://cloud.google.com/bigquery/docs/reference/rest/v2/datasets/insert

projectId <string> Required. Project ID of the new dataset
Dataset:
{:creationTime string,
 :description string,
 :externalCatalogDatasetOptions
 {:defaultStorageLocationUri string, :parameters object},
 :defaultEncryptionConfiguration {:kmsKeyName string},
 :defaultPartitionExpirationMs string,
 :tags [{:tagKey string, :tagValue string}],
 :labels object,
 :restrictions
 {:type [RESTRICTION_TYPE_UNSPECIFIED RESTRICTED_DATA_EGRESS]},
 :satisfiesPzi boolean,
 :linkedDatasetSource
 {:sourceDataset {:datasetId string, :projectId string}},
 :maxTimeTravelHours string,
 :selfLink string,
 :type string,
 :etag string,
 :externalDatasetReference
 {:connection string, :externalSource string},
 :defaultTableExpirationMs string,
 :linkedDatasetMetadata
 {:linkState [LINK_STATE_UNSPECIFIED LINKED UNLINKED]},
 :isCaseInsensitive boolean,
 :storageBillingModel
 [STORAGE_BILLING_MODEL_UNSPECIFIED LOGICAL PHYSICAL],
 :lastModifiedTime string,
 :resourceTags object,
 :defaultRoundingMode
 [ROUNDING_MODE_UNSPECIFIED ROUND_HALF_AWAY_FROM_ZERO ROUND_HALF_EVEN],
 :friendlyName string,
 :satisfiesPzs boolean,
 :id string,
 :kind string,
 :defaultCollation string,
 :access
 [{:role string,
   :iamMember string,
   :specialGroup string,
   :groupByEmail string,
   :routine {:datasetId string, :projectId string, :routineId string},
   :domain string,
   :userByEmail string,
   :dataset
   {:dataset {:datasetId string, :projectId string},
    :targetTypes [[TARGET_TYPE_UNSPECIFIED VIEWS ROUTINES]]},
   :view {:datasetId string, :projectId string, :tableId string}}],
 :location string,
 :datasetReference {:datasetId string, :projectId string}}"
  [projectId Dataset]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Dataset}))

(defn datasets-list
  "Lists all datasets in the specified project to which the user has been granted the READER dataset role.
https://cloud.google.com/bigquery/docs/reference/rest/v2/datasets/list

projectId <string> Required. Project ID of the datasets to be listed

optional:
all <boolean> Whether to list all datasets, including hidden ones
filter <string> An expression for filtering the results of the request by label. The syntax is \\\"labels.<name>[:<value>]\\\". Multiple filters can be ANDed together by connecting with a space. Example: \\\"labels.department:receiving labels.active\\\". See [Filtering datasets using labels](/bigquery/docs/filtering-labels#filtering_datasets_using_labels) for details.
maxResults <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection."
  ([projectId] (datasets-list projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn datasets-patch
  "Updates information in an existing dataset. The update method replaces the entire dataset resource, whereas the patch method only replaces fields that are provided in the submitted dataset resource. This method supports RFC5789 patch semantics.
https://cloud.google.com/bigquery/docs/reference/rest/v2/datasets/patch

projectId <string> Required. Project ID of the dataset being updated
datasetId <string> Required. Dataset ID of the dataset being updated
Dataset:
{:creationTime string,
 :description string,
 :externalCatalogDatasetOptions
 {:defaultStorageLocationUri string, :parameters object},
 :defaultEncryptionConfiguration {:kmsKeyName string},
 :defaultPartitionExpirationMs string,
 :tags [{:tagKey string, :tagValue string}],
 :labels object,
 :restrictions
 {:type [RESTRICTION_TYPE_UNSPECIFIED RESTRICTED_DATA_EGRESS]},
 :satisfiesPzi boolean,
 :linkedDatasetSource
 {:sourceDataset {:datasetId string, :projectId string}},
 :maxTimeTravelHours string,
 :selfLink string,
 :type string,
 :etag string,
 :externalDatasetReference
 {:connection string, :externalSource string},
 :defaultTableExpirationMs string,
 :linkedDatasetMetadata
 {:linkState [LINK_STATE_UNSPECIFIED LINKED UNLINKED]},
 :isCaseInsensitive boolean,
 :storageBillingModel
 [STORAGE_BILLING_MODEL_UNSPECIFIED LOGICAL PHYSICAL],
 :lastModifiedTime string,
 :resourceTags object,
 :defaultRoundingMode
 [ROUNDING_MODE_UNSPECIFIED ROUND_HALF_AWAY_FROM_ZERO ROUND_HALF_EVEN],
 :friendlyName string,
 :satisfiesPzs boolean,
 :id string,
 :kind string,
 :defaultCollation string,
 :access
 [{:role string,
   :iamMember string,
   :specialGroup string,
   :groupByEmail string,
   :routine {:datasetId string, :projectId string, :routineId string},
   :domain string,
   :userByEmail string,
   :dataset
   {:dataset {:datasetId string, :projectId string},
    :targetTypes [[TARGET_TYPE_UNSPECIFIED VIEWS ROUTINES]]},
   :view {:datasetId string, :projectId string, :tableId string}}],
 :location string,
 :datasetReference {:datasetId string, :projectId string}}"
  [projectId datasetId Dataset]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}",
     :uri-template-args {:datasetId datasetId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Dataset}))

(defn datasets-undelete
  "Undeletes a dataset which is within time travel window based on datasetId. If a time is specified, the dataset version deleted at that time is undeleted, else the last live version is undeleted.
https://cloud.google.com/bigquery/docs/reference/rest/v2/datasets/undelete

projectId <string> Required. Project ID of the dataset to be undeleted
datasetId <string> Required. Dataset ID of dataset being deleted
UndeleteDatasetRequest:
{:deletionTime string}"
  [projectId datasetId UndeleteDatasetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}:undelete",
     :uri-template-args {:datasetId datasetId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body UndeleteDatasetRequest}))

(defn datasets-update
  "Updates information in an existing dataset. The update method replaces the entire dataset resource, whereas the patch method only replaces fields that are provided in the submitted dataset resource.
https://cloud.google.com/bigquery/docs/reference/rest/v2/datasets/update

projectId <string> Required. Project ID of the dataset being updated
datasetId <string> Required. Dataset ID of the dataset being updated
Dataset:
{:creationTime string,
 :description string,
 :externalCatalogDatasetOptions
 {:defaultStorageLocationUri string, :parameters object},
 :defaultEncryptionConfiguration {:kmsKeyName string},
 :defaultPartitionExpirationMs string,
 :tags [{:tagKey string, :tagValue string}],
 :labels object,
 :restrictions
 {:type [RESTRICTION_TYPE_UNSPECIFIED RESTRICTED_DATA_EGRESS]},
 :satisfiesPzi boolean,
 :linkedDatasetSource
 {:sourceDataset {:datasetId string, :projectId string}},
 :maxTimeTravelHours string,
 :selfLink string,
 :type string,
 :etag string,
 :externalDatasetReference
 {:connection string, :externalSource string},
 :defaultTableExpirationMs string,
 :linkedDatasetMetadata
 {:linkState [LINK_STATE_UNSPECIFIED LINKED UNLINKED]},
 :isCaseInsensitive boolean,
 :storageBillingModel
 [STORAGE_BILLING_MODEL_UNSPECIFIED LOGICAL PHYSICAL],
 :lastModifiedTime string,
 :resourceTags object,
 :defaultRoundingMode
 [ROUNDING_MODE_UNSPECIFIED ROUND_HALF_AWAY_FROM_ZERO ROUND_HALF_EVEN],
 :friendlyName string,
 :satisfiesPzs boolean,
 :id string,
 :kind string,
 :defaultCollation string,
 :access
 [{:role string,
   :iamMember string,
   :specialGroup string,
   :groupByEmail string,
   :routine {:datasetId string, :projectId string, :routineId string},
   :domain string,
   :userByEmail string,
   :dataset
   {:dataset {:datasetId string, :projectId string},
    :targetTypes [[TARGET_TYPE_UNSPECIFIED VIEWS ROUTINES]]},
   :view {:datasetId string, :projectId string, :tableId string}}],
 :location string,
 :datasetReference {:datasetId string, :projectId string}}"
  [projectId datasetId Dataset]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}",
     :uri-template-args {:datasetId datasetId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Dataset}))

(defn jobs-cancel
  "Requests that a job be cancelled. This call will return immediately, and the client will need to poll for the job status to see if the cancel completed successfully. Cancelled jobs may still incur costs.
https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/cancel

projectId <string> Required. Project ID of the job to cancel
jobId <string> Required. Job ID of the job to cancel

optional:
location <string> The geographic location of the job. You must specify the location to run the job for the following scenarios: - If the location to run a job is not in the `us` or the `eu` multi-regional location - If the job's location is in a single region (for example, `us-central1`) For more information, see https://cloud.google.com/bigquery/docs/locations#specifying_your_location."
  ([projectId jobId] (jobs-cancel projectId jobId nil))
  ([projectId jobId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/jobs/{+jobId}/cancel",
       :uri-template-args {:jobId jobId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn jobs-delete
  "Requests the deletion of the metadata of a job. This call returns when the job's metadata is deleted.
https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/delete

projectId <string> Required. Project ID of the job for which metadata is to be deleted.
jobId <string> Required. Job ID of the job for which metadata is to be deleted. If this is a parent job which has child jobs, the metadata from all child jobs will be deleted as well. Direct deletion of the metadata of child jobs is not allowed.

optional:
location <string> The geographic location of the job. Required. See details at: https://cloud.google.com/bigquery/docs/locations#specifying_your_location."
  ([projectId jobId] (jobs-delete projectId jobId nil))
  ([projectId jobId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/jobs/{+jobId}/delete",
       :uri-template-args {:jobId jobId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn jobs-get
  "Returns information about a specific job. Job information is available for a six month period after creation. Requires that you're the person who ran the job, or have the Is Owner project role.
https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/get

projectId <string> Required. Project ID of the requested job.
jobId <string> Required. Job ID of the requested job.

optional:
location <string> The geographic location of the job. You must specify the location to run the job for the following scenarios: - If the location to run a job is not in the `us` or the `eu` multi-regional location - If the job's location is in a single region (for example, `us-central1`) For more information, see https://cloud.google.com/bigquery/docs/locations#specifying_your_location."
  ([projectId jobId] (jobs-get projectId jobId nil))
  ([projectId jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/jobs/{+jobId}",
       :uri-template-args {:jobId jobId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn jobs-getQueryResults
  "RPC to get the results of a query job.
https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/getQueryResults

projectId <string> Required. Project ID of the query job.
jobId <string> Required. Job ID of the query job.

optional:
formatOptions.useInt64Timestamp <boolean> Optional. Output timestamp as usec int64. Default is false.
location <string> The geographic location of the job. You must specify the location to run the job for the following scenarios: - If the location to run a job is not in the `us` or the `eu` multi-regional location - If the job's location is in a single region (for example, `us-central1`) For more information, see https://cloud.google.com/bigquery/docs/locations#specifying_your_location.
maxResults <integer> Maximum number of results to read.
startIndex <string> Zero-based index of the starting row.
timeoutMs <integer> Optional: Specifies the maximum amount of time, in milliseconds, that the client is willing to wait for the query to complete. By default, this limit is 10 seconds (10,000 milliseconds). If the query is complete, the jobComplete field in the response is true. If the query has not yet completed, jobComplete is false. You can request a longer timeout period in the timeoutMs field. However, the call is not guaranteed to wait for the specified timeout; it typically returns after around 200 seconds (200,000 milliseconds), even if the query is not complete. If jobComplete is false, you can continue to wait for the query to complete by calling the getQueryResults method until the jobComplete field in the getQueryResults response is true."
  ([projectId jobId] (jobs-getQueryResults projectId jobId nil))
  ([projectId jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/queries/{+jobId}",
       :uri-template-args {:jobId jobId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn jobs-insert
  "Starts a new asynchronous job. This API has two different kinds of endpoint URIs, as this method supports a variety of use cases. * The *Metadata* URI is used for most interactions, as it accepts the job configuration directly. * The *Upload* URI is ONLY for the case when you're sending both a load job configuration and a data stream together. In this case, the Upload URI accepts the job configuration and the data as two distinct multipart MIME parts.
https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/insert

projectId <string> Project ID of project that will be billed for the job.
Job:
{:principal_subject string,
 :selfLink string,
 :etag string,
 :user_email string,
 :jobReference {:jobId string, :location string, :projectId string},
 :statistics
 {:reservation_id string,
  :creationTime string,
  :load
  {:badRecords string,
   :inputFileBytes string,
   :inputFiles string,
   :outputBytes string,
   :outputRows string,
   :timeline
   [{:activeUnits string,
     :completedUnits string,
     :elapsedMs string,
     :estimatedRunnableUnits string,
     :pendingUnits string,
     :totalSlotMs string}]},
  :dataMaskingStatistics {:dataMaskingApplied boolean},
  :transactionInfo {:transactionId string},
  :copy {:copiedLogicalBytes string, :copiedRows string},
  :startTime string,
  :reservationUsage [{:name string, :slotMs string}],
  :endTime string,
  :totalSlotMs string,
  :completionRatio number,
  :numChildJobs string,
  :finalExecutionDurationMs string,
  :parentJobId string,
  :rowLevelSecurityStatistics {:rowLevelSecurityApplied boolean},
  :extract
  {:destinationUriFileCounts [string],
   :inputBytes string,
   :timeline
   [{:activeUnits string,
     :completedUnits string,
     :elapsedMs string,
     :estimatedRunnableUnits string,
     :pendingUnits string,
     :totalSlotMs string}]},
  :totalBytesProcessed string,
  :scriptStatistics
  {:evaluationKind [EVALUATION_KIND_UNSPECIFIED STATEMENT EXPRESSION],
   :stackFrames
   [{:endColumn integer,
     :endLine integer,
     :procedureId string,
     :startColumn integer,
     :startLine integer,
     :text string}]},
  :quotaDeferments [string],
  :query
  {:ddlOperationPerformed string,
   :totalBytesBilled string,
   :totalBytesProcessedAccuracy string,
   :schema
   {:fields
    [{:description string,
      :rangeElementType {:type string},
      :scale string,
      :policyTags {:names [string]},
      :name string,
      :foreignTypeDefinition string,
      :precision string,
      :fields [TableFieldSchema],
      :mode string,
      :type string,
      :collation string,
      :categories {:names [string]},
      :defaultValueExpression string,
      :maxLength string,
      :roundingMode
      [ROUNDING_MODE_UNSPECIFIED
       ROUND_HALF_AWAY_FROM_ZERO
       ROUND_HALF_EVEN]}],
    :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
   :undeclaredQueryParameters
   [{:name string,
     :parameterType
     {:arrayType QueryParameterType,
      :rangeElementType QueryParameterType,
      :structTypes
      [{:description string, :name string, :type QueryParameterType}],
      :type string},
     :parameterValue
     {:arrayValues [QueryParameterValue],
      :rangeValue RangeValue,
      :structValues object,
      :value string}}],
   :estimatedBytesProcessed string,
   :externalServiceCosts
   [{:bytesBilled string,
     :bytesProcessed string,
     :externalService string,
     :reservedSlotCount string,
     :slotMs string}],
   :ddlTargetRoutine
   {:datasetId string, :projectId string, :routineId string},
   :vectorSearchStatistics
   {:indexUnusedReasons
    [{:baseTable TableReference,
      :code
      [CODE_UNSPECIFIED
       INDEX_CONFIG_NOT_AVAILABLE
       PENDING_INDEX_CREATION
       BASE_TABLE_TRUNCATED
       INDEX_CONFIG_MODIFIED
       TIME_TRAVEL_QUERY
       NO_PRUNING_POWER
       UNINDEXED_SEARCH_FIELDS
       UNSUPPORTED_SEARCH_PATTERN
       OPTIMIZED_WITH_MATERIALIZED_VIEW
       SECURED_BY_DATA_MASKING
       MISMATCHED_TEXT_ANALYZER
       BASE_TABLE_TOO_SMALL
       BASE_TABLE_TOO_LARGE
       ESTIMATED_PERFORMANCE_GAIN_TOO_LOW
       NOT_SUPPORTED_IN_STANDARD_EDITION
       INDEX_SUPPRESSED_BY_FUNCTION_OPTION
       QUERY_CACHE_HIT
       INTERNAL_ERROR
       OTHER_REASON],
      :indexName string,
      :message string}],
    :indexUsageMode
    [INDEX_USAGE_MODE_UNSPECIFIED UNUSED PARTIALLY_USED FULLY_USED]},
   :ddlTargetTable
   {:datasetId string, :projectId string, :tableId string},
   :biEngineStatistics
   {:accelerationMode
    [BI_ENGINE_ACCELERATION_MODE_UNSPECIFIED
     BI_ENGINE_DISABLED
     PARTIAL_INPUT
     FULL_INPUT
     FULL_QUERY],
    :biEngineMode
    [ACCELERATION_MODE_UNSPECIFIED DISABLED PARTIAL FULL],
    :biEngineReasons
    [{:code
      [CODE_UNSPECIFIED
       NO_RESERVATION
       INSUFFICIENT_RESERVATION
       UNSUPPORTED_SQL_TEXT
       INPUT_TOO_LARGE
       OTHER_REASON
       TABLE_EXCLUDED],
      :message string}]},
   :reservationUsage [{:name string, :slotMs string}],
   :numDmlAffectedRows string,
   :dclTargetDataset {:datasetId string, :projectId string},
   :totalSlotMs string,
   :ddlTargetRowAccessPolicy
   {:datasetId string,
    :policyId string,
    :projectId string,
    :tableId string},
   :dmlStats
   {:deletedRowCount string,
    :insertedRowCount string,
    :updatedRowCount string},
   :referencedRoutines
   [{:datasetId string, :projectId string, :routineId string}],
   :statementType string,
   :materializedViewStatistics
   {:materializedView
    [{:chosen boolean,
      :estimatedBytesSaved string,
      :rejectedReason
      [REJECTED_REASON_UNSPECIFIED
       NO_DATA
       COST
       BASE_TABLE_TRUNCATED
       BASE_TABLE_DATA_CHANGE
       BASE_TABLE_PARTITION_EXPIRATION_CHANGE
       BASE_TABLE_EXPIRED_PARTITION
       BASE_TABLE_INCOMPATIBLE_METADATA_CHANGE
       TIME_ZONE
       OUT_OF_TIME_TRAVEL_WINDOW
       BASE_TABLE_FINE_GRAINED_SECURITY_POLICY
       BASE_TABLE_TOO_STALE],
      :tableReference TableReference}]},
   :dclTargetView
   {:datasetId string, :projectId string, :tableId string},
   :searchStatistics
   {:indexUnusedReasons
    [{:baseTable TableReference,
      :code
      [CODE_UNSPECIFIED
       INDEX_CONFIG_NOT_AVAILABLE
       PENDING_INDEX_CREATION
       BASE_TABLE_TRUNCATED
       INDEX_CONFIG_MODIFIED
       TIME_TRAVEL_QUERY
       NO_PRUNING_POWER
       UNINDEXED_SEARCH_FIELDS
       UNSUPPORTED_SEARCH_PATTERN
       OPTIMIZED_WITH_MATERIALIZED_VIEW
       SECURED_BY_DATA_MASKING
       MISMATCHED_TEXT_ANALYZER
       BASE_TABLE_TOO_SMALL
       BASE_TABLE_TOO_LARGE
       ESTIMATED_PERFORMANCE_GAIN_TOO_LOW
       NOT_SUPPORTED_IN_STANDARD_EDITION
       INDEX_SUPPRESSED_BY_FUNCTION_OPTION
       QUERY_CACHE_HIT
       INTERNAL_ERROR
       OTHER_REASON],
      :indexName string,
      :message string}],
    :indexUsageMode
    [INDEX_USAGE_MODE_UNSPECIFIED UNUSED PARTIALLY_USED FULLY_USED]},
   :billingTier integer,
   :modelTraining
   {:currentIteration integer, :expectedTotalIterations string},
   :queryPlan
   [{:completedParallelInputs string,
     :readMsMax string,
     :writeMsAvg string,
     :recordsRead string,
     :inputStages [string],
     :shuffleOutputBytes string,
     :name string,
     :computeMsAvg string,
     :steps [{:kind string, :substeps [string]}],
     :endMs string,
     :startMs string,
     :computeMode [COMPUTE_MODE_UNSPECIFIED BIGQUERY BI_ENGINE],
     :writeRatioMax number,
     :waitMsAvg string,
     :readRatioAvg number,
     :writeRatioAvg number,
     :status string,
     :id string,
     :computeRatioMax number,
     :waitMsMax string,
     :slotMs string,
     :waitRatioAvg number,
     :waitRatioMax number,
     :parallelInputs string,
     :writeMsMax string,
     :shuffleOutputBytesSpilled string,
     :recordsWritten string,
     :readMsAvg string,
     :computeRatioAvg number,
     :computeMsMax string,
     :readRatioMax number}],
   :ddlAffectedRowAccessPolicyCount string,
   :queryInfo {:optimizationDetails object},
   :mlStatistics
   {:hparamTrials
    [{:evalLoss number,
      :errorMessage string,
      :trialId string,
      :evaluationMetrics EvaluationMetrics,
      :endTimeMs string,
      :status
      [TRIAL_STATUS_UNSPECIFIED
       NOT_STARTED
       RUNNING
       SUCCEEDED
       FAILED
       INFEASIBLE
       STOPPED_EARLY],
      :hparams TrainingOptions,
      :startTimeMs string,
      :hparamTuningEvaluationMetrics EvaluationMetrics,
      :trainingLoss number}],
    :iterationResults
    [{:arimaResult ArimaResult,
      :clusterInfos [ClusterInfo],
      :durationMs string,
      :evalLoss number,
      :index integer,
      :learnRate number,
      :principalComponentInfos [PrincipalComponentInfo],
      :trainingLoss number}],
    :maxIterations string,
    :modelType
    [MODEL_TYPE_UNSPECIFIED
     LINEAR_REGRESSION
     LOGISTIC_REGRESSION
     KMEANS
     MATRIX_FACTORIZATION
     DNN_CLASSIFIER
     TENSORFLOW
     DNN_REGRESSOR
     XGBOOST
     BOOSTED_TREE_REGRESSOR
     BOOSTED_TREE_CLASSIFIER
     ARIMA
     AUTOML_REGRESSOR
     AUTOML_CLASSIFIER
     PCA
     DNN_LINEAR_COMBINED_CLASSIFIER
     DNN_LINEAR_COMBINED_REGRESSOR
     AUTOENCODER
     ARIMA_PLUS
     ARIMA_PLUS_XREG
     RANDOM_FOREST_REGRESSOR
     RANDOM_FOREST_CLASSIFIER
     TENSORFLOW_LITE
     ONNX
     TRANSFORM_ONLY],
    :trainingType
    [TRAINING_TYPE_UNSPECIFIED SINGLE_TRAINING HPARAM_TUNING]},
   :modelTrainingCurrentIteration integer,
   :exportDataStatistics {:fileCount string, :rowCount string},
   :totalBytesProcessed string,
   :referencedTables
   [{:datasetId string, :projectId string, :tableId string}],
   :transferredBytes string,
   :ddlTargetDataset {:datasetId string, :projectId string},
   :sparkStatistics
   {:endpoints object,
    :gcsStagingBucket string,
    :kmsKeyName string,
    :loggingInfo {:projectId string, :resourceType string},
    :sparkJobId string,
    :sparkJobLocation string},
   :ddlDestinationTable
   {:datasetId string, :projectId string, :tableId string},
   :performanceInsights
   {:avgPreviousExecutionMs string,
    :stagePerformanceChangeInsights
    [{:inputDataChange InputDataChange, :stageId string}],
    :stagePerformanceStandaloneInsights
    [{:biEngineReasons [BiEngineReason],
      :highCardinalityJoins [HighCardinalityJoin],
      :insufficientShuffleQuota boolean,
      :partitionSkew PartitionSkew,
      :slotContention boolean,
      :stageId string}]},
   :dclTargetTable
   {:datasetId string, :projectId string, :tableId string},
   :timeline
   [{:activeUnits string,
     :completedUnits string,
     :elapsedMs string,
     :estimatedRunnableUnits string,
     :pendingUnits string,
     :totalSlotMs string}],
   :totalPartitionsProcessed string,
   :metadataCacheStatistics
   {:tableMetadataCacheUsage
    [{:explanation string,
      :tableReference TableReference,
      :tableType string,
      :unusedReason
      [UNUSED_REASON_UNSPECIFIED
       EXCEEDED_MAX_STALENESS
       METADATA_CACHING_NOT_ENABLED
       OTHER_REASON]}]},
   :loadQueryStatistics
   {:badRecords string,
    :bytesTransferred string,
    :inputFileBytes string,
    :inputFiles string,
    :outputBytes string,
    :outputRows string},
   :cacheHit boolean,
   :modelTrainingExpectedTotalIteration string},
  :sessionInfo {:sessionId string}},
 :jobCreationReason
 {:code [CODE_UNSPECIFIED REQUESTED LONG_RUNNING LARGE_RESULTS OTHER]},
 :status
 {:errorResult
  {:debugInfo string,
   :location string,
   :message string,
   :reason string},
  :errors
  [{:debugInfo string,
    :location string,
    :message string,
    :reason string}],
  :state string},
 :id string,
 :kind string,
 :configuration
 {:copy
  {:createDisposition string,
   :destinationEncryptionConfiguration {:kmsKeyName string},
   :destinationExpirationTime string,
   :destinationTable
   {:datasetId string, :projectId string, :tableId string},
   :operationType
   [OPERATION_TYPE_UNSPECIFIED COPY SNAPSHOT RESTORE CLONE],
   :sourceTable
   {:datasetId string, :projectId string, :tableId string},
   :sourceTables
   [{:datasetId string, :projectId string, :tableId string}],
   :writeDisposition string},
  :dryRun boolean,
  :extract
  {:printHeader boolean,
   :destinationFormat string,
   :sourceModel
   {:datasetId string, :modelId string, :projectId string},
   :compression string,
   :sourceTable
   {:datasetId string, :projectId string, :tableId string},
   :useAvroLogicalTypes boolean,
   :modelExtractOptions {:trialId string},
   :fieldDelimiter string,
   :destinationUri string,
   :destinationUris [string]},
  :jobTimeoutMs string,
  :jobType string,
  :labels object,
  :load
  {:encoding string,
   :schema
   {:fields
    [{:description string,
      :rangeElementType {:type string},
      :scale string,
      :policyTags {:names [string]},
      :name string,
      :foreignTypeDefinition string,
      :precision string,
      :fields [TableFieldSchema],
      :mode string,
      :type string,
      :collation string,
      :categories {:names [string]},
      :defaultValueExpression string,
      :maxLength string,
      :roundingMode
      [ROUNDING_MODE_UNSPECIFIED
       ROUND_HALF_AWAY_FROM_ZERO
       ROUND_HALF_EVEN]}],
    :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
   :skipLeadingRows integer,
   :destinationTable
   {:datasetId string, :projectId string, :tableId string},
   :connectionProperties [{:key string, :value string}],
   :schemaInline string,
   :fileSetSpecType
   [FILE_SET_SPEC_TYPE_FILE_SYSTEM_MATCH
    FILE_SET_SPEC_TYPE_NEW_LINE_DELIMITED_MANIFEST],
   :allowJaggedRows boolean,
   :parquetOptions
   {:enableListInference boolean,
    :enumAsString boolean,
    :mapTargetType [MAP_TARGET_TYPE_UNSPECIFIED ARRAY_OF_STRUCT]},
   :autodetect boolean,
   :projectionFields [string],
   :preserveAsciiControlCharacters boolean,
   :columnNameCharacterMap
   [COLUMN_NAME_CHARACTER_MAP_UNSPECIFIED STRICT V1 V2],
   :timePartitioning
   {:expirationMs string,
    :field string,
    :requirePartitionFilter boolean,
    :type string},
   :sourceFormat string,
   :createDisposition string,
   :useAvroLogicalTypes boolean,
   :ignoreUnknownValues boolean,
   :allowQuotedNewlines boolean,
   :clustering {:fields [string]},
   :schemaUpdateOptions [string],
   :quote string,
   :writeDisposition string,
   :rangePartitioning
   {:field string,
    :range {:end string, :interval string, :start string}},
   :hivePartitioningOptions
   {:fields [string],
    :mode string,
    :requirePartitionFilter boolean,
    :sourceUriPrefix string},
   :fieldDelimiter string,
   :decimalTargetTypes
   [[DECIMAL_TARGET_TYPE_UNSPECIFIED NUMERIC BIGNUMERIC STRING]],
   :sourceUris [string],
   :maxBadRecords integer,
   :copyFilesOnly boolean,
   :nullMarker string,
   :createSession boolean,
   :destinationEncryptionConfiguration {:kmsKeyName string},
   :destinationTableProperties
   {:description string,
    :expirationTime string,
    :friendlyName string,
    :labels object},
   :schemaInlineFormat string,
   :referenceFileSchemaUri string,
   :jsonExtension [JSON_EXTENSION_UNSPECIFIED GEOJSON]},
  :query
  {:userDefinedFunctionResources
   [{:inlineCode string, :resourceUri string}],
   :maximumBillingTier integer,
   :maximumBytesBilled string,
   :queryParameters
   [{:name string,
     :parameterType
     {:arrayType QueryParameterType,
      :rangeElementType QueryParameterType,
      :structTypes
      [{:description string, :name string, :type QueryParameterType}],
      :type string},
     :parameterValue
     {:arrayValues [QueryParameterValue],
      :rangeValue RangeValue,
      :structValues object,
      :value string}}],
   :parameterMode string,
   :destinationTable
   {:datasetId string, :projectId string, :tableId string},
   :connectionProperties [{:key string, :value string}],
   :allowLargeResults boolean,
   :continuous boolean,
   :scriptOptions
   {:keyResultStatement
    [KEY_RESULT_STATEMENT_KIND_UNSPECIFIED LAST FIRST_SELECT],
    :statementByteBudget string,
    :statementTimeoutMs string},
   :defaultDataset {:datasetId string, :projectId string},
   :tableDefinitions object,
   :timePartitioning
   {:expirationMs string,
    :field string,
    :requirePartitionFilter boolean,
    :type string},
   :createDisposition string,
   :systemVariables {:types object, :values object},
   :preserveNulls boolean,
   :clustering {:fields [string]},
   :priority string,
   :schemaUpdateOptions [string],
   :flattenResults boolean,
   :writeDisposition string,
   :rangePartitioning
   {:field string,
    :range {:end string, :interval string, :start string}},
   :useQueryCache boolean,
   :query string,
   :useLegacySql boolean,
   :createSession boolean,
   :destinationEncryptionConfiguration {:kmsKeyName string}}}}"
  [projectId Job]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/jobs",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_only"
      "https://www.googleapis.com/auth/devstorage.read_write"],
     :body Job}))

(defn jobs-list
  "Lists all jobs that you started in the specified project. Job information is available for a six month period after creation. The job list is sorted in reverse chronological order, by job creation time. Requires the Can View project role, or the Is Owner project role if you set the allUsers property.
https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/list

projectId <string> Project ID of the jobs to list.

optional:
allUsers <boolean> Whether to display jobs owned by all users in the project. Default False.
maxCreationTime <string> Max value for job creation time, in milliseconds since the POSIX epoch. If set, only jobs created before or at this timestamp are returned.
parentJobId <string> If set, show only child jobs of the specified parent. Otherwise, show all top-level jobs.
stateFilter <string> Filter for job state
projection <string> Restrict information returned to a set of selected fields
maxResults <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection.
minCreationTime <string> Min value for job creation time, in milliseconds since the POSIX epoch. If set, only jobs created after or at this timestamp are returned."
  ([projectId] (jobs-list projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/jobs",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn jobs-query
  "Runs a BigQuery SQL query synchronously and returns query results if the query completes within a specified timeout.
https://cloud.google.com/bigquery/docs/reference/rest/v2/jobs/query

projectId <string> Required. Project ID of the query request.
QueryRequest:
{:dryRun boolean,
 :labels object,
 :maximumBytesBilled string,
 :queryParameters
 [{:name string,
   :parameterType
   {:arrayType
    {:arrayType
     {:arrayType QueryParameterType,
      :rangeElementType QueryParameterType,
      :structTypes
      [{:description string, :name string, :type QueryParameterType}],
      :type string},
     :rangeElementType
     {:arrayType QueryParameterType,
      :rangeElementType QueryParameterType,
      :structTypes
      [{:description string, :name string, :type QueryParameterType}],
      :type string},
     :structTypes
     [{:description string,
       :name string,
       :type
       {:arrayType QueryParameterType,
        :rangeElementType QueryParameterType,
        :structTypes
        [{:description string,
          :name string,
          :type QueryParameterType}],
        :type string}}],
     :type string},
    :rangeElementType
    {:arrayType
     {:arrayType QueryParameterType,
      :rangeElementType QueryParameterType,
      :structTypes
      [{:description string, :name string, :type QueryParameterType}],
      :type string},
     :rangeElementType
     {:arrayType QueryParameterType,
      :rangeElementType QueryParameterType,
      :structTypes
      [{:description string, :name string, :type QueryParameterType}],
      :type string},
     :structTypes
     [{:description string,
       :name string,
       :type
       {:arrayType QueryParameterType,
        :rangeElementType QueryParameterType,
        :structTypes
        [{:description string,
          :name string,
          :type QueryParameterType}],
        :type string}}],
     :type string},
    :structTypes
    [{:description string,
      :name string,
      :type
      {:arrayType
       {:arrayType QueryParameterType,
        :rangeElementType QueryParameterType,
        :structTypes
        [{:description string,
          :name string,
          :type QueryParameterType}],
        :type string},
       :rangeElementType
       {:arrayType QueryParameterType,
        :rangeElementType QueryParameterType,
        :structTypes
        [{:description string,
          :name string,
          :type QueryParameterType}],
        :type string},
       :structTypes
       [{:description string,
         :name string,
         :type
         {:arrayType QueryParameterType,
          :rangeElementType QueryParameterType,
          :structTypes
          [{:description string,
            :name string,
            :type QueryParameterType}],
          :type string}}],
       :type string}}],
    :type string},
   :parameterValue
   {:arrayValues
    [{:arrayValues
      [{:arrayValues [QueryParameterValue],
        :rangeValue RangeValue,
        :structValues object,
        :value string}],
      :rangeValue
      {:end QueryParameterValue, :start QueryParameterValue},
      :structValues object,
      :value string}],
    :rangeValue
    {:end
     {:arrayValues [QueryParameterValue],
      :rangeValue RangeValue,
      :structValues object,
      :value string},
     :start
     {:arrayValues [QueryParameterValue],
      :rangeValue RangeValue,
      :structValues object,
      :value string}},
    :structValues object,
    :value string}}],
 :parameterMode string,
 :connectionProperties [{:key string, :value string}],
 :jobCreationMode
 [JOB_CREATION_MODE_UNSPECIFIED
  JOB_CREATION_REQUIRED
  JOB_CREATION_OPTIONAL],
 :continuous boolean,
 :defaultDataset {:datasetId string, :projectId string},
 :preserveNulls boolean,
 :timeoutMs integer,
 :requestId string,
 :kind string,
 :useQueryCache boolean,
 :formatOptions {:useInt64Timestamp boolean},
 :query string,
 :useLegacySql boolean,
 :location string,
 :createSession boolean,
 :maxResults integer}"
  [projectId QueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/queries",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body QueryRequest}))

(defn models-delete
  "Deletes the model specified by modelId from the dataset.
https://cloud.google.com/bigquery/docs/reference/rest/v2/models/delete

projectId <string> Required. Project ID of the model to delete.
datasetId <string> Required. Dataset ID of the model to delete.
modelId <string> Required. Model ID of the model to delete."
  [projectId datasetId modelId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/models/{+modelId}",
     :uri-template-args
     {:datasetId datasetId, :modelId modelId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn models-get
  "Gets the specified model resource by model ID.
https://cloud.google.com/bigquery/docs/reference/rest/v2/models/get

projectId <string> Required. Project ID of the requested model.
datasetId <string> Required. Dataset ID of the requested model.
modelId <string> Required. Model ID of the requested model."
  [projectId datasetId modelId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/models/{+modelId}",
     :uri-template-args
     {:datasetId datasetId, :modelId modelId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn models-list
  "Lists all models in the specified dataset. Requires the READER dataset role. After retrieving the list of models, you can get information about a particular model by calling the models.get method.
https://cloud.google.com/bigquery/docs/reference/rest/v2/models/list

projectId <string> Required. Project ID of the models to list.
datasetId <string> Required. Dataset ID of the models to list.

optional:
maxResults <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection."
  ([projectId datasetId] (models-list projectId datasetId nil))
  ([projectId datasetId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/models",
       :uri-template-args {:datasetId datasetId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn models-patch
  "Patch specific fields in the specified model.
https://cloud.google.com/bigquery/docs/reference/rest/v2/models/patch

projectId <string> Required. Project ID of the model to patch.
datasetId <string> Required. Dataset ID of the model to patch.
modelId <string> Required. Model ID of the model to patch.
Model:
{:creationTime string,
 :description string,
 :labels object,
 :modelType
 [MODEL_TYPE_UNSPECIFIED
  LINEAR_REGRESSION
  LOGISTIC_REGRESSION
  KMEANS
  MATRIX_FACTORIZATION
  DNN_CLASSIFIER
  TENSORFLOW
  DNN_REGRESSOR
  XGBOOST
  BOOSTED_TREE_REGRESSOR
  BOOSTED_TREE_CLASSIFIER
  ARIMA
  AUTOML_REGRESSOR
  AUTOML_CLASSIFIER
  PCA
  DNN_LINEAR_COMBINED_CLASSIFIER
  DNN_LINEAR_COMBINED_REGRESSOR
  AUTOENCODER
  ARIMA_PLUS
  ARIMA_PLUS_XREG
  RANDOM_FOREST_REGRESSOR
  RANDOM_FOREST_CLASSIFIER
  TENSORFLOW_LITE
  ONNX
  TRANSFORM_ONLY],
 :transformColumns
 [{:name string,
   :transformSql string,
   :type
   {:arrayElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [{:name string, :type StandardSqlDataType}]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]}}],
 :expirationTime string,
 :bestTrialId string,
 :etag string,
 :optimalTrialIds [string],
 :lastModifiedTime string,
 :friendlyName string,
 :hparamSearchSpaces
 {:subsample
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :treeMethod {:candidates [string]},
  :maxTreeDepth
  {:candidates {:candidates [string]},
   :range {:max string, :min string}},
  :minSplitLoss
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :dropout
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :hiddenUnits {:candidates [{:elements [string]}]},
  :l1Reg
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :l2Reg
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :minTreeChildWeight
  {:candidates {:candidates [string]},
   :range {:max string, :min string}},
  :colsampleBylevel
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :numParallelTree
  {:candidates {:candidates [string]},
   :range {:max string, :min string}},
  :numClusters
  {:candidates {:candidates [string]},
   :range {:max string, :min string}},
  :learnRate
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :optimizer {:candidates [string]},
  :colsampleBynode
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :dartNormalizeType {:candidates [string]},
  :colsampleBytree
  {:candidates {:candidates [number]},
   :range {:max number, :min number}},
  :batchSize
  {:candidates {:candidates [string]},
   :range {:max string, :min string}},
  :boosterType {:candidates [string]},
  :numFactors
  {:candidates {:candidates [string]},
   :range {:max string, :min string}},
  :activationFn {:candidates [string]},
  :walsAlpha
  {:candidates {:candidates [number]},
   :range {:max number, :min number}}},
 :hparamTrials
 [{:evalLoss number,
   :errorMessage string,
   :trialId string,
   :evaluationMetrics
   {:arimaForecastingMetrics
    {:arimaFittingMetrics
     [{:aic number, :logLikelihood number, :variance number}],
     :arimaSingleModelForecastingMetrics
     [{:hasHolidayEffect boolean,
       :hasSpikesAndDips boolean,
       :arimaFittingMetrics ArimaFittingMetrics,
       :seasonalPeriods
       [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
         NO_SEASONALITY
         DAILY
         WEEKLY
         MONTHLY
         QUARTERLY
         YEARLY]],
       :timeSeriesIds [string],
       :nonSeasonalOrder ArimaOrder,
       :hasStepChanges boolean,
       :hasDrift boolean,
       :timeSeriesId string}],
     :hasDrift [boolean],
     :nonSeasonalOrder [{:d string, :p string, :q string}],
     :seasonalPeriods
     [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
       NO_SEASONALITY
       DAILY
       WEEKLY
       MONTHLY
       QUARTERLY
       YEARLY]],
     :timeSeriesId [string]},
    :binaryClassificationMetrics
    {:aggregateClassificationMetrics
     {:accuracy number,
      :f1Score number,
      :logLoss number,
      :precision number,
      :recall number,
      :rocAuc number,
      :threshold number},
     :binaryConfusionMatrixList
     [{:accuracy number,
       :falsePositives string,
       :precision number,
       :recall number,
       :positiveClassThreshold number,
       :truePositives string,
       :f1Score number,
       :trueNegatives string,
       :falseNegatives string}],
     :negativeLabel string,
     :positiveLabel string},
    :clusteringMetrics
    {:clusters
     [{:centroidId string,
       :count string,
       :featureValues [FeatureValue]}],
     :daviesBouldinIndex number,
     :meanSquaredDistance number},
    :dimensionalityReductionMetrics
    {:totalExplainedVarianceRatio number},
    :multiClassClassificationMetrics
    {:aggregateClassificationMetrics
     {:accuracy number,
      :f1Score number,
      :logLoss number,
      :precision number,
      :recall number,
      :rocAuc number,
      :threshold number},
     :confusionMatrixList
     [{:confidenceThreshold number, :rows [Row]}]},
    :rankingMetrics
    {:averageRank number,
     :meanAveragePrecision number,
     :meanSquaredError number,
     :normalizedDiscountedCumulativeGain number},
    :regressionMetrics
    {:meanAbsoluteError number,
     :meanSquaredError number,
     :meanSquaredLogError number,
     :medianAbsoluteError number,
     :rSquared number}},
   :endTimeMs string,
   :status
   [TRIAL_STATUS_UNSPECIFIED
    NOT_STARTED
    RUNNING
    SUCCEEDED
    FAILED
    INFEASIBLE
    STOPPED_EARLY],
   :hparams
   {:minRelativeProgress number,
    :decomposeTimeSeries boolean,
    :timeSeriesIdColumns [string],
    :hparamTuningObjectives
    [[HPARAM_TUNING_OBJECTIVE_UNSPECIFIED
      MEAN_ABSOLUTE_ERROR
      MEAN_SQUARED_ERROR
      MEAN_SQUARED_LOG_ERROR
      MEDIAN_ABSOLUTE_ERROR
      R_SQUARED
      EXPLAINED_VARIANCE
      PRECISION
      RECALL
      ACCURACY
      F1_SCORE
      LOG_LOSS
      ROC_AUC
      DAVIES_BOULDIN_INDEX
      MEAN_AVERAGE_PRECISION
      NORMALIZED_DISCOUNTED_CUMULATIVE_GAIN
      AVERAGE_RANK]],
    :subsample number,
    :treeMethod [TREE_METHOD_UNSPECIFIED AUTO EXACT APPROX HIST],
    :dataSplitMethod
    [DATA_SPLIT_METHOD_UNSPECIFIED
     RANDOM
     CUSTOM
     SEQUENTIAL
     NO_SPLIT
     AUTO_SPLIT],
    :maxTimeSeriesLength string,
    :maxTreeDepth string,
    :enableGlobalExplain boolean,
    :earlyStop boolean,
    :cleanSpikesAndDips boolean,
    :standardizeFeatures boolean,
    :minSplitLoss number,
    :distanceType [DISTANCE_TYPE_UNSPECIFIED EUCLIDEAN COSINE],
    :timeSeriesTimestampColumn string,
    :numTrials string,
    :itemColumn string,
    :timeSeriesDataColumn string,
    :dropout number,
    :adjustStepChanges boolean,
    :timeSeriesIdColumn string,
    :learnRateStrategy
    [LEARN_RATE_STRATEGY_UNSPECIFIED LINE_SEARCH CONSTANT],
    :hiddenUnits [string],
    :labelClassWeights object,
    :l2Regularization number,
    :dataSplitColumn string,
    :pcaExplainedVarianceRatio number,
    :categoryEncodingMethod
    [ENCODING_METHOD_UNSPECIFIED
     ONE_HOT_ENCODING
     LABEL_ENCODING
     DUMMY_ENCODING],
    :colorSpace [COLOR_SPACE_UNSPECIFIED RGB HSV YIQ YUV GRAYSCALE],
    :fitIntercept boolean,
    :includeDrift boolean,
    :xgboostVersion string,
    :minTimeSeriesLength string,
    :horizon string,
    :userColumn string,
    :maxParallelTrials string,
    :vertexAiModelVersionAliases [string],
    :kmeansInitializationMethod
    [KMEANS_INITIALIZATION_METHOD_UNSPECIFIED
     RANDOM
     CUSTOM
     KMEANS_PLUS_PLUS],
    :maxIterations string,
    :numPrincipalComponents string,
    :holidayRegions
    [[HOLIDAY_REGION_UNSPECIFIED
      GLOBAL
      NA
      JAPAC
      EMEA
      LAC
      AE
      AR
      AT
      AU
      BE
      BR
      CA
      CH
      CL
      CN
      CO
      CS
      CZ
      DE
      DK
      DZ
      EC
      EE
      EG
      ES
      FI
      FR
      GB
      GR
      HK
      HU
      ID
      IE
      IL
      IN
      IR
      IT
      JP
      KR
      LV
      MA
      MX
      MY
      NG
      NL
      NO
      NZ
      PE
      PH
      PK
      PL
      PT
      RO
      RS
      RU
      SA
      SE
      SG
      SI
      SK
      TH
      TR
      TW
      UA
      US
      VE
      VN
      ZA]],
    :instanceWeightColumn string,
    :minTreeChildWeight string,
    :pcaSolver [UNSPECIFIED FULL RANDOMIZED AUTO],
    :tfVersion string,
    :timeSeriesLengthFraction number,
    :colsampleBylevel number,
    :autoArimaMinOrder string,
    :sampledShapleyNumPaths string,
    :numParallelTree string,
    :feedbackType [FEEDBACK_TYPE_UNSPECIFIED IMPLICIT EXPLICIT],
    :numClusters string,
    :optimizationStrategy
    [OPTIMIZATION_STRATEGY_UNSPECIFIED
     BATCH_GRADIENT_DESCENT
     NORMAL_EQUATION],
    :dataFrequency
    [DATA_FREQUENCY_UNSPECIFIED
     AUTO_FREQUENCY
     YEARLY
     QUARTERLY
     MONTHLY
     WEEKLY
     DAILY
     HOURLY
     PER_MINUTE],
    :learnRate number,
    :modelUri string,
    :holidayRegion
    [HOLIDAY_REGION_UNSPECIFIED
     GLOBAL
     NA
     JAPAC
     EMEA
     LAC
     AE
     AR
     AT
     AU
     BE
     BR
     CA
     CH
     CL
     CN
     CO
     CS
     CZ
     DE
     DK
     DZ
     EC
     EE
     EG
     ES
     FI
     FR
     GB
     GR
     HK
     HU
     ID
     IE
     IL
     IN
     IR
     IT
     JP
     KR
     LV
     MA
     MX
     MY
     NG
     NL
     NO
     NZ
     PE
     PH
     PK
     PL
     PT
     RO
     RS
     RU
     SA
     SE
     SG
     SI
     SK
     TH
     TR
     TW
     UA
     US
     VE
     VN
     ZA],
    :optimizer string,
    :colsampleBynode number,
    :warmStart boolean,
    :dartNormalizeType [DART_NORMALIZE_TYPE_UNSPECIFIED TREE FOREST],
    :kmeansInitializationColumn string,
    :nonSeasonalOrder {:d string, :p string, :q string},
    :colsampleBytree number,
    :batchSize string,
    :autoClassWeights boolean,
    :modelRegistry [MODEL_REGISTRY_UNSPECIFIED VERTEX_AI],
    :scaleFeatures boolean,
    :autoArima boolean,
    :dataSplitEvalFraction number,
    :trendSmoothingWindowSize string,
    :boosterType [BOOSTER_TYPE_UNSPECIFIED GBTREE DART],
    :numFactors string,
    :l1RegActivation number,
    :l1Regularization number,
    :lossType [LOSS_TYPE_UNSPECIFIED MEAN_SQUARED_LOSS MEAN_LOG_LOSS],
    :approxGlobalFeatureContrib boolean,
    :integratedGradientsNumSteps string,
    :autoArimaMaxOrder string,
    :initialLearnRate number,
    :activationFn string,
    :calculatePValues boolean,
    :inputLabelColumns [string],
    :budgetHours number,
    :walsAlpha number},
   :startTimeMs string,
   :hparamTuningEvaluationMetrics
   {:arimaForecastingMetrics
    {:arimaFittingMetrics
     [{:aic number, :logLikelihood number, :variance number}],
     :arimaSingleModelForecastingMetrics
     [{:hasHolidayEffect boolean,
       :hasSpikesAndDips boolean,
       :arimaFittingMetrics ArimaFittingMetrics,
       :seasonalPeriods
       [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
         NO_SEASONALITY
         DAILY
         WEEKLY
         MONTHLY
         QUARTERLY
         YEARLY]],
       :timeSeriesIds [string],
       :nonSeasonalOrder ArimaOrder,
       :hasStepChanges boolean,
       :hasDrift boolean,
       :timeSeriesId string}],
     :hasDrift [boolean],
     :nonSeasonalOrder [{:d string, :p string, :q string}],
     :seasonalPeriods
     [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
       NO_SEASONALITY
       DAILY
       WEEKLY
       MONTHLY
       QUARTERLY
       YEARLY]],
     :timeSeriesId [string]},
    :binaryClassificationMetrics
    {:aggregateClassificationMetrics
     {:accuracy number,
      :f1Score number,
      :logLoss number,
      :precision number,
      :recall number,
      :rocAuc number,
      :threshold number},
     :binaryConfusionMatrixList
     [{:accuracy number,
       :falsePositives string,
       :precision number,
       :recall number,
       :positiveClassThreshold number,
       :truePositives string,
       :f1Score number,
       :trueNegatives string,
       :falseNegatives string}],
     :negativeLabel string,
     :positiveLabel string},
    :clusteringMetrics
    {:clusters
     [{:centroidId string,
       :count string,
       :featureValues [FeatureValue]}],
     :daviesBouldinIndex number,
     :meanSquaredDistance number},
    :dimensionalityReductionMetrics
    {:totalExplainedVarianceRatio number},
    :multiClassClassificationMetrics
    {:aggregateClassificationMetrics
     {:accuracy number,
      :f1Score number,
      :logLoss number,
      :precision number,
      :recall number,
      :rocAuc number,
      :threshold number},
     :confusionMatrixList
     [{:confidenceThreshold number, :rows [Row]}]},
    :rankingMetrics
    {:averageRank number,
     :meanAveragePrecision number,
     :meanSquaredError number,
     :normalizedDiscountedCumulativeGain number},
    :regressionMetrics
    {:meanAbsoluteError number,
     :meanSquaredError number,
     :meanSquaredLogError number,
     :medianAbsoluteError number,
     :rSquared number}},
   :trainingLoss number}],
 :trainingRuns
 [{:vertexAiModelId string,
   :trainingOptions
   {:minRelativeProgress number,
    :decomposeTimeSeries boolean,
    :timeSeriesIdColumns [string],
    :hparamTuningObjectives
    [[HPARAM_TUNING_OBJECTIVE_UNSPECIFIED
      MEAN_ABSOLUTE_ERROR
      MEAN_SQUARED_ERROR
      MEAN_SQUARED_LOG_ERROR
      MEDIAN_ABSOLUTE_ERROR
      R_SQUARED
      EXPLAINED_VARIANCE
      PRECISION
      RECALL
      ACCURACY
      F1_SCORE
      LOG_LOSS
      ROC_AUC
      DAVIES_BOULDIN_INDEX
      MEAN_AVERAGE_PRECISION
      NORMALIZED_DISCOUNTED_CUMULATIVE_GAIN
      AVERAGE_RANK]],
    :subsample number,
    :treeMethod [TREE_METHOD_UNSPECIFIED AUTO EXACT APPROX HIST],
    :dataSplitMethod
    [DATA_SPLIT_METHOD_UNSPECIFIED
     RANDOM
     CUSTOM
     SEQUENTIAL
     NO_SPLIT
     AUTO_SPLIT],
    :maxTimeSeriesLength string,
    :maxTreeDepth string,
    :enableGlobalExplain boolean,
    :earlyStop boolean,
    :cleanSpikesAndDips boolean,
    :standardizeFeatures boolean,
    :minSplitLoss number,
    :distanceType [DISTANCE_TYPE_UNSPECIFIED EUCLIDEAN COSINE],
    :timeSeriesTimestampColumn string,
    :numTrials string,
    :itemColumn string,
    :timeSeriesDataColumn string,
    :dropout number,
    :adjustStepChanges boolean,
    :timeSeriesIdColumn string,
    :learnRateStrategy
    [LEARN_RATE_STRATEGY_UNSPECIFIED LINE_SEARCH CONSTANT],
    :hiddenUnits [string],
    :labelClassWeights object,
    :l2Regularization number,
    :dataSplitColumn string,
    :pcaExplainedVarianceRatio number,
    :categoryEncodingMethod
    [ENCODING_METHOD_UNSPECIFIED
     ONE_HOT_ENCODING
     LABEL_ENCODING
     DUMMY_ENCODING],
    :colorSpace [COLOR_SPACE_UNSPECIFIED RGB HSV YIQ YUV GRAYSCALE],
    :fitIntercept boolean,
    :includeDrift boolean,
    :xgboostVersion string,
    :minTimeSeriesLength string,
    :horizon string,
    :userColumn string,
    :maxParallelTrials string,
    :vertexAiModelVersionAliases [string],
    :kmeansInitializationMethod
    [KMEANS_INITIALIZATION_METHOD_UNSPECIFIED
     RANDOM
     CUSTOM
     KMEANS_PLUS_PLUS],
    :maxIterations string,
    :numPrincipalComponents string,
    :holidayRegions
    [[HOLIDAY_REGION_UNSPECIFIED
      GLOBAL
      NA
      JAPAC
      EMEA
      LAC
      AE
      AR
      AT
      AU
      BE
      BR
      CA
      CH
      CL
      CN
      CO
      CS
      CZ
      DE
      DK
      DZ
      EC
      EE
      EG
      ES
      FI
      FR
      GB
      GR
      HK
      HU
      ID
      IE
      IL
      IN
      IR
      IT
      JP
      KR
      LV
      MA
      MX
      MY
      NG
      NL
      NO
      NZ
      PE
      PH
      PK
      PL
      PT
      RO
      RS
      RU
      SA
      SE
      SG
      SI
      SK
      TH
      TR
      TW
      UA
      US
      VE
      VN
      ZA]],
    :instanceWeightColumn string,
    :minTreeChildWeight string,
    :pcaSolver [UNSPECIFIED FULL RANDOMIZED AUTO],
    :tfVersion string,
    :timeSeriesLengthFraction number,
    :colsampleBylevel number,
    :autoArimaMinOrder string,
    :sampledShapleyNumPaths string,
    :numParallelTree string,
    :feedbackType [FEEDBACK_TYPE_UNSPECIFIED IMPLICIT EXPLICIT],
    :numClusters string,
    :optimizationStrategy
    [OPTIMIZATION_STRATEGY_UNSPECIFIED
     BATCH_GRADIENT_DESCENT
     NORMAL_EQUATION],
    :dataFrequency
    [DATA_FREQUENCY_UNSPECIFIED
     AUTO_FREQUENCY
     YEARLY
     QUARTERLY
     MONTHLY
     WEEKLY
     DAILY
     HOURLY
     PER_MINUTE],
    :learnRate number,
    :modelUri string,
    :holidayRegion
    [HOLIDAY_REGION_UNSPECIFIED
     GLOBAL
     NA
     JAPAC
     EMEA
     LAC
     AE
     AR
     AT
     AU
     BE
     BR
     CA
     CH
     CL
     CN
     CO
     CS
     CZ
     DE
     DK
     DZ
     EC
     EE
     EG
     ES
     FI
     FR
     GB
     GR
     HK
     HU
     ID
     IE
     IL
     IN
     IR
     IT
     JP
     KR
     LV
     MA
     MX
     MY
     NG
     NL
     NO
     NZ
     PE
     PH
     PK
     PL
     PT
     RO
     RS
     RU
     SA
     SE
     SG
     SI
     SK
     TH
     TR
     TW
     UA
     US
     VE
     VN
     ZA],
    :optimizer string,
    :colsampleBynode number,
    :warmStart boolean,
    :dartNormalizeType [DART_NORMALIZE_TYPE_UNSPECIFIED TREE FOREST],
    :kmeansInitializationColumn string,
    :nonSeasonalOrder {:d string, :p string, :q string},
    :colsampleBytree number,
    :batchSize string,
    :autoClassWeights boolean,
    :modelRegistry [MODEL_REGISTRY_UNSPECIFIED VERTEX_AI],
    :scaleFeatures boolean,
    :autoArima boolean,
    :dataSplitEvalFraction number,
    :trendSmoothingWindowSize string,
    :boosterType [BOOSTER_TYPE_UNSPECIFIED GBTREE DART],
    :numFactors string,
    :l1RegActivation number,
    :l1Regularization number,
    :lossType [LOSS_TYPE_UNSPECIFIED MEAN_SQUARED_LOSS MEAN_LOG_LOSS],
    :approxGlobalFeatureContrib boolean,
    :integratedGradientsNumSteps string,
    :autoArimaMaxOrder string,
    :initialLearnRate number,
    :activationFn string,
    :calculatePValues boolean,
    :inputLabelColumns [string],
    :budgetHours number,
    :walsAlpha number},
   :trainingStartTime string,
   :classLevelGlobalExplanations
   [{:classLabel string,
     :explanations [{:attribution number, :featureName string}]}],
   :startTime string,
   :evaluationMetrics
   {:arimaForecastingMetrics
    {:arimaFittingMetrics
     [{:aic number, :logLikelihood number, :variance number}],
     :arimaSingleModelForecastingMetrics
     [{:hasHolidayEffect boolean,
       :hasSpikesAndDips boolean,
       :arimaFittingMetrics ArimaFittingMetrics,
       :seasonalPeriods
       [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
         NO_SEASONALITY
         DAILY
         WEEKLY
         MONTHLY
         QUARTERLY
         YEARLY]],
       :timeSeriesIds [string],
       :nonSeasonalOrder ArimaOrder,
       :hasStepChanges boolean,
       :hasDrift boolean,
       :timeSeriesId string}],
     :hasDrift [boolean],
     :nonSeasonalOrder [{:d string, :p string, :q string}],
     :seasonalPeriods
     [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
       NO_SEASONALITY
       DAILY
       WEEKLY
       MONTHLY
       QUARTERLY
       YEARLY]],
     :timeSeriesId [string]},
    :binaryClassificationMetrics
    {:aggregateClassificationMetrics
     {:accuracy number,
      :f1Score number,
      :logLoss number,
      :precision number,
      :recall number,
      :rocAuc number,
      :threshold number},
     :binaryConfusionMatrixList
     [{:accuracy number,
       :falsePositives string,
       :precision number,
       :recall number,
       :positiveClassThreshold number,
       :truePositives string,
       :f1Score number,
       :trueNegatives string,
       :falseNegatives string}],
     :negativeLabel string,
     :positiveLabel string},
    :clusteringMetrics
    {:clusters
     [{:centroidId string,
       :count string,
       :featureValues [FeatureValue]}],
     :daviesBouldinIndex number,
     :meanSquaredDistance number},
    :dimensionalityReductionMetrics
    {:totalExplainedVarianceRatio number},
    :multiClassClassificationMetrics
    {:aggregateClassificationMetrics
     {:accuracy number,
      :f1Score number,
      :logLoss number,
      :precision number,
      :recall number,
      :rocAuc number,
      :threshold number},
     :confusionMatrixList
     [{:confidenceThreshold number, :rows [Row]}]},
    :rankingMetrics
    {:averageRank number,
     :meanAveragePrecision number,
     :meanSquaredError number,
     :normalizedDiscountedCumulativeGain number},
    :regressionMetrics
    {:meanAbsoluteError number,
     :meanSquaredError number,
     :meanSquaredLogError number,
     :medianAbsoluteError number,
     :rSquared number}},
   :modelLevelGlobalExplanation
   {:classLabel string,
    :explanations [{:attribution number, :featureName string}]},
   :dataSplitResult
   {:evaluationTable
    {:datasetId string, :projectId string, :tableId string},
    :testTable {:datasetId string, :projectId string, :tableId string},
    :trainingTable
    {:datasetId string, :projectId string, :tableId string}},
   :vertexAiModelVersion string,
   :results
   [{:arimaResult
     {:arimaModelInfo
      [{:hasHolidayEffect boolean,
        :hasSpikesAndDips boolean,
        :arimaFittingMetrics ArimaFittingMetrics,
        :seasonalPeriods
        [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
          NO_SEASONALITY
          DAILY
          WEEKLY
          MONTHLY
          QUARTERLY
          YEARLY]],
        :timeSeriesIds [string],
        :nonSeasonalOrder ArimaOrder,
        :arimaCoefficients ArimaCoefficients,
        :hasStepChanges boolean,
        :hasDrift boolean,
        :timeSeriesId string}],
      :seasonalPeriods
      [[SEASONAL_PERIOD_TYPE_UNSPECIFIED
        NO_SEASONALITY
        DAILY
        WEEKLY
        MONTHLY
        QUARTERLY
        YEARLY]]},
     :clusterInfos
     [{:centroidId string,
       :clusterRadius number,
       :clusterSize string}],
     :durationMs string,
     :evalLoss number,
     :index integer,
     :learnRate number,
     :principalComponentInfos
     [{:cumulativeExplainedVarianceRatio number,
       :explainedVariance number,
       :explainedVarianceRatio number,
       :principalComponentId string}],
     :trainingLoss number}]}],
 :defaultTrialId string,
 :featureColumns
 [{:name string,
   :type
   {:arrayElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [{:name string, :type StandardSqlDataType}]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]}}],
 :labelColumns
 [{:name string,
   :type
   {:arrayElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [{:name string, :type StandardSqlDataType}]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]}}],
 :remoteModelInfo
 {:connection string,
  :endpoint string,
  :maxBatchingRows string,
  :remoteModelVersion string,
  :remoteServiceType
  [REMOTE_SERVICE_TYPE_UNSPECIFIED
   CLOUD_AI_TRANSLATE_V3
   CLOUD_AI_VISION_V1
   CLOUD_AI_NATURAL_LANGUAGE_V1
   CLOUD_AI_SPEECH_TO_TEXT_V2],
  :speechRecognizer string},
 :location string,
 :encryptionConfiguration {:kmsKeyName string},
 :modelReference
 {:datasetId string, :modelId string, :projectId string}}"
  [projectId datasetId modelId Model]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/models/{+modelId}",
     :uri-template-args
     {:datasetId datasetId, :modelId modelId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Model}))

(defn projects-getServiceAccount
  "RPC to get the service account for a project used for interactions with Google Cloud KMS
https://cloud.google.com/bigquery/docs/reference/rest/v2/projects/getServiceAccount

projectId <string> Required. ID of the project."
  [projectId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/serviceAccount",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-list
  "RPC to list projects to which the user has been granted any project role. Users of this method are encouraged to consider the [Resource Manager](https://cloud.google.com/resource-manager/docs/) API, which provides the underlying data for this method and has more capabilities.
https://cloud.google.com/bigquery/docs/reference/rest/v2/projects/list

optional:
maxResults <integer> `maxResults` unset returns all results, up to 50 per page. Additionally, the number of projects in a page may be fewer than `maxResults` because projects are retrieved and then filtered to only projects with the BigQuery API enabled."
  ([] (projects-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn routines-delete
  "Deletes the routine specified by routineId from the dataset.
https://cloud.google.com/bigquery/docs/reference/rest/v2/routines/delete

projectId <string> Required. Project ID of the routine to delete
datasetId <string> Required. Dataset ID of the routine to delete
routineId <string> Required. Routine ID of the routine to delete"
  [projectId datasetId routineId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}",
     :uri-template-args
     {:datasetId datasetId,
      :projectId projectId,
      :routineId routineId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn routines-get
  "Gets the specified routine resource by routine ID.
https://cloud.google.com/bigquery/docs/reference/rest/v2/routines/get

projectId <string> Required. Project ID of the requested routine
datasetId <string> Required. Dataset ID of the requested routine
routineId <string> Required. Routine ID of the requested routine

optional:
readMask <string> If set, only the Routine fields in the field mask are returned in the response. If unset, all Routine fields are returned."
  ([projectId datasetId routineId]
    (routines-get projectId datasetId routineId nil))
  ([projectId datasetId routineId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}",
       :uri-template-args
       {:datasetId datasetId,
        :projectId projectId,
        :routineId routineId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn routines-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/bigquery/docs/reference/rest/v2/routines/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn routines-insert
  "Creates a new routine in the dataset.
https://cloud.google.com/bigquery/docs/reference/rest/v2/routines/insert

projectId <string> Required. Project ID of the new routine
datasetId <string> Required. Dataset ID of the new routine
Routine:
{:creationTime string,
 :description string,
 :remoteFunctionOptions
 {:connection string,
  :endpoint string,
  :maxBatchingRows string,
  :userDefinedContext object},
 :importedLibraries [string],
 :arguments
 [{:argumentKind [ARGUMENT_KIND_UNSPECIFIED FIXED_TYPE ANY_TYPE],
   :dataType
   {:arrayElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [{:name string, :type StandardSqlDataType}]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :isAggregate boolean,
   :mode [MODE_UNSPECIFIED IN OUT INOUT],
   :name string}],
 :securityMode [SECURITY_MODE_UNSPECIFIED DEFINER INVOKER],
 :etag string,
 :dataGovernanceType [DATA_GOVERNANCE_TYPE_UNSPECIFIED DATA_MASKING],
 :returnType
 {:arrayElementType
  {:arrayElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :rangeElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :structType {:fields [{:name string, :type StandardSqlDataType}]},
   :typeKind
   [TYPE_KIND_UNSPECIFIED
    INT64
    BOOL
    FLOAT64
    STRING
    BYTES
    TIMESTAMP
    DATE
    TIME
    DATETIME
    INTERVAL
    GEOGRAPHY
    NUMERIC
    BIGNUMERIC
    JSON
    ARRAY
    STRUCT
    RANGE]},
  :rangeElementType
  {:arrayElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :rangeElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :structType {:fields [{:name string, :type StandardSqlDataType}]},
   :typeKind
   [TYPE_KIND_UNSPECIFIED
    INT64
    BOOL
    FLOAT64
    STRING
    BYTES
    TIMESTAMP
    DATE
    TIME
    DATETIME
    INTERVAL
    GEOGRAPHY
    NUMERIC
    BIGNUMERIC
    JSON
    ARRAY
    STRUCT
    RANGE]},
  :structType
  {:fields
   [{:name string,
     :type
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]}}]},
  :typeKind
  [TYPE_KIND_UNSPECIFIED
   INT64
   BOOL
   FLOAT64
   STRING
   BYTES
   TIMESTAMP
   DATE
   TIME
   DATETIME
   INTERVAL
   GEOGRAPHY
   NUMERIC
   BIGNUMERIC
   JSON
   ARRAY
   STRUCT
   RANGE]},
 :routineType
 [ROUTINE_TYPE_UNSPECIFIED
  SCALAR_FUNCTION
  PROCEDURE
  TABLE_VALUED_FUNCTION
  AGGREGATE_FUNCTION],
 :lastModifiedTime string,
 :definitionBody string,
 :language [LANGUAGE_UNSPECIFIED SQL JAVASCRIPT PYTHON JAVA SCALA],
 :routineReference
 {:datasetId string, :projectId string, :routineId string},
 :returnTableType
 {:columns
  [{:name string,
    :type
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]}}]},
 :sparkOptions
 {:properties object,
  :archiveUris [string],
  :containerImage string,
  :mainClass string,
  :pyFileUris [string],
  :jarUris [string],
  :fileUris [string],
  :runtimeVersion string,
  :connection string,
  :mainFileUri string},
 :determinismLevel
 [DETERMINISM_LEVEL_UNSPECIFIED DETERMINISTIC NOT_DETERMINISTIC],
 :strictMode boolean}"
  [projectId datasetId Routine]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/routines",
     :uri-template-args {:datasetId datasetId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Routine}))

(defn routines-list
  "Lists all routines in the specified dataset. Requires the READER dataset role.
https://cloud.google.com/bigquery/docs/reference/rest/v2/routines/list

projectId <string> Required. Project ID of the routines to list
datasetId <string> Required. Dataset ID of the routines to list

optional:
filter <string> If set, then only the Routines matching this filter are returned. The supported format is `routineType:{RoutineType}`, where `{RoutineType}` is a RoutineType enum. For example: `routineType:SCALAR_FUNCTION`.
maxResults <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection.
readMask <string> If set, then only the Routine fields in the field mask, as well as project_id, dataset_id and routine_id, are returned in the response. If unset, then the following Routine fields are returned: etag, project_id, dataset_id, routine_id, routine_type, creation_time, last_modified_time, and language."
  ([projectId datasetId] (routines-list projectId datasetId nil))
  ([projectId datasetId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/routines",
       :uri-template-args {:datasetId datasetId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn routines-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/bigquery/docs/reference/rest/v2/routines/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:auditConfigs
  [{:auditLogConfigs
    [{:exemptedMembers [string],
      :logType
      [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ]}],
    :service string}],
  :bindings
  [{:condition
    {:description string,
     :expression string,
     :location string,
     :title string},
    :members [string],
    :role string}],
  :etag string,
  :version integer},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn routines-update
  "Updates information in an existing routine. The update method replaces the entire Routine resource.
https://cloud.google.com/bigquery/docs/reference/rest/v2/routines/update

projectId <string> Required. Project ID of the routine to update
datasetId <string> Required. Dataset ID of the routine to update
routineId <string> Required. Routine ID of the routine to update
Routine:
{:creationTime string,
 :description string,
 :remoteFunctionOptions
 {:connection string,
  :endpoint string,
  :maxBatchingRows string,
  :userDefinedContext object},
 :importedLibraries [string],
 :arguments
 [{:argumentKind [ARGUMENT_KIND_UNSPECIFIED FIXED_TYPE ANY_TYPE],
   :dataType
   {:arrayElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [{:name string, :type StandardSqlDataType}]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :isAggregate boolean,
   :mode [MODE_UNSPECIFIED IN OUT INOUT],
   :name string}],
 :securityMode [SECURITY_MODE_UNSPECIFIED DEFINER INVOKER],
 :etag string,
 :dataGovernanceType [DATA_GOVERNANCE_TYPE_UNSPECIFIED DATA_MASKING],
 :returnType
 {:arrayElementType
  {:arrayElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :rangeElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :structType {:fields [{:name string, :type StandardSqlDataType}]},
   :typeKind
   [TYPE_KIND_UNSPECIFIED
    INT64
    BOOL
    FLOAT64
    STRING
    BYTES
    TIMESTAMP
    DATE
    TIME
    DATETIME
    INTERVAL
    GEOGRAPHY
    NUMERIC
    BIGNUMERIC
    JSON
    ARRAY
    STRUCT
    RANGE]},
  :rangeElementType
  {:arrayElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :rangeElementType
   {:arrayElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :rangeElementType
    {:arrayElementType StandardSqlDataType,
     :rangeElementType StandardSqlDataType,
     :structType StandardSqlStructType,
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]},
    :structType {:fields [StandardSqlField]},
    :typeKind
    [TYPE_KIND_UNSPECIFIED
     INT64
     BOOL
     FLOAT64
     STRING
     BYTES
     TIMESTAMP
     DATE
     TIME
     DATETIME
     INTERVAL
     GEOGRAPHY
     NUMERIC
     BIGNUMERIC
     JSON
     ARRAY
     STRUCT
     RANGE]},
   :structType {:fields [{:name string, :type StandardSqlDataType}]},
   :typeKind
   [TYPE_KIND_UNSPECIFIED
    INT64
    BOOL
    FLOAT64
    STRING
    BYTES
    TIMESTAMP
    DATE
    TIME
    DATETIME
    INTERVAL
    GEOGRAPHY
    NUMERIC
    BIGNUMERIC
    JSON
    ARRAY
    STRUCT
    RANGE]},
  :structType
  {:fields
   [{:name string,
     :type
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]}}]},
  :typeKind
  [TYPE_KIND_UNSPECIFIED
   INT64
   BOOL
   FLOAT64
   STRING
   BYTES
   TIMESTAMP
   DATE
   TIME
   DATETIME
   INTERVAL
   GEOGRAPHY
   NUMERIC
   BIGNUMERIC
   JSON
   ARRAY
   STRUCT
   RANGE]},
 :routineType
 [ROUTINE_TYPE_UNSPECIFIED
  SCALAR_FUNCTION
  PROCEDURE
  TABLE_VALUED_FUNCTION
  AGGREGATE_FUNCTION],
 :lastModifiedTime string,
 :definitionBody string,
 :language [LANGUAGE_UNSPECIFIED SQL JAVASCRIPT PYTHON JAVA SCALA],
 :routineReference
 {:datasetId string, :projectId string, :routineId string},
 :returnTableType
 {:columns
  [{:name string,
    :type
    {:arrayElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :rangeElementType
     {:arrayElementType StandardSqlDataType,
      :rangeElementType StandardSqlDataType,
      :structType StandardSqlStructType,
      :typeKind
      [TYPE_KIND_UNSPECIFIED
       INT64
       BOOL
       FLOAT64
       STRING
       BYTES
       TIMESTAMP
       DATE
       TIME
       DATETIME
       INTERVAL
       GEOGRAPHY
       NUMERIC
       BIGNUMERIC
       JSON
       ARRAY
       STRUCT
       RANGE]},
     :structType {:fields [StandardSqlField]},
     :typeKind
     [TYPE_KIND_UNSPECIFIED
      INT64
      BOOL
      FLOAT64
      STRING
      BYTES
      TIMESTAMP
      DATE
      TIME
      DATETIME
      INTERVAL
      GEOGRAPHY
      NUMERIC
      BIGNUMERIC
      JSON
      ARRAY
      STRUCT
      RANGE]}}]},
 :sparkOptions
 {:properties object,
  :archiveUris [string],
  :containerImage string,
  :mainClass string,
  :pyFileUris [string],
  :jarUris [string],
  :fileUris [string],
  :runtimeVersion string,
  :connection string,
  :mainFileUri string},
 :determinismLevel
 [DETERMINISM_LEVEL_UNSPECIFIED DETERMINISTIC NOT_DETERMINISTIC],
 :strictMode boolean}"
  [projectId datasetId routineId Routine]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}",
     :uri-template-args
     {:datasetId datasetId,
      :projectId projectId,
      :routineId routineId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Routine}))

(defn rowAccessPolicies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/bigquery/docs/reference/rest/v2/rowAccessPolicies/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn rowAccessPolicies-list
  "Lists all row access policies on the specified table.
https://cloud.google.com/bigquery/docs/reference/rest/v2/rowAccessPolicies/list

projectId <string> Required. Project ID of the row access policies to list.
datasetId <string> Required. Dataset ID of row access policies to list.
tableId <string> Required. Table ID of the table to list row access policies.

optional:
pageSize <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection."
  ([projectId datasetId tableId]
    (rowAccessPolicies-list projectId datasetId tableId nil))
  ([projectId datasetId tableId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}/rowAccessPolicies",
       :uri-template-args
       {:datasetId datasetId, :projectId projectId, :tableId tableId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn rowAccessPolicies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/bigquery/docs/reference/rest/v2/rowAccessPolicies/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body TestIamPermissionsRequest}))

(defn tabledata-insertAll
  "Streams data into BigQuery one record at a time without needing to run a load job.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tabledata/insertAll

projectId <string> Required. Project ID of the destination.
datasetId <string> Required. Dataset ID of the destination.
tableId <string> Required. Table ID of the destination.
TableDataInsertAllRequest:
{:ignoreUnknownValues boolean,
 :kind string,
 :rows [{:insertId string, :json object}],
 :skipInvalidRows boolean,
 :templateSuffix string,
 :traceId string}"
  [projectId datasetId tableId TableDataInsertAllRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}/insertAll",
     :uri-template-args
     {:datasetId datasetId, :projectId projectId, :tableId tableId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/bigquery.insertdata"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TableDataInsertAllRequest}))

(defn tabledata-list
  "List the content of a table in rows.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tabledata/list

projectId <string> Required. Project id of the table to list.
datasetId <string> Required. Dataset id of the table to list.
tableId <string> Required. Table id of the table to list.

optional:
formatOptions.useInt64Timestamp <boolean> Optional. Output timestamp as usec int64. Default is false.
maxResults <integer> Row limit of the table.
selectedFields <string> Subset of fields to return, supports select into sub fields. Example: selected_fields = \"a,e.d.f\";
startIndex <string> Start row index of the table."
  ([projectId datasetId tableId]
    (tabledata-list projectId datasetId tableId nil))
  ([projectId datasetId tableId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}/data",
       :uri-template-args
       {:datasetId datasetId, :projectId projectId, :tableId tableId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tables-get
  "Gets the specified table resource by table ID. This method does not return the data in the table, it only returns the table resource, which describes the structure of this table.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/get

projectId <string> Required. Project ID of the requested table
datasetId <string> Required. Dataset ID of the requested table
tableId <string> Required. Table ID of the requested table

optional:
selectedFields <string> List of table schema fields to return (comma-separated). If unspecified, all fields are returned. A fieldMask cannot be used here because the fields will automatically be converted from camelCase to snake_case and the conversion will fail if there are underscores. Since these are fields in BigQuery table schemas, underscores are allowed.
view <string> Optional. Specifies the view that determines which table information is returned. By default, basic table information and storage statistics (STORAGE_STATS) are returned."
  ([projectId datasetId tableId]
    (tables-get projectId datasetId tableId nil))
  ([projectId datasetId tableId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}",
       :uri-template-args
       {:datasetId datasetId, :projectId projectId, :tableId tableId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tables-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:auditConfigs
  [{:auditLogConfigs
    [{:exemptedMembers [string],
      :logType
      [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ]}],
    :service string}],
  :bindings
  [{:condition
    {:description string,
     :expression string,
     :location string,
     :title string},
    :members [string],
    :role string}],
  :etag string,
  :version integer},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn tables-insert
  "Creates a new, empty table in the dataset.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/insert

projectId <string> Required. Project ID of the new table
datasetId <string> Required. Dataset ID of the new table
Table:
{:creationTime string,
 :description string,
 :maxStaleness string,
 :numBytes string,
 :schema
 {:fields
  [{:description string,
    :rangeElementType {:type string},
    :scale string,
    :policyTags {:names [string]},
    :name string,
    :foreignTypeDefinition string,
    :precision string,
    :fields
    [{:description string,
      :rangeElementType {:type string},
      :scale string,
      :policyTags {:names [string]},
      :name string,
      :foreignTypeDefinition string,
      :precision string,
      :fields
      [{:description string,
        :rangeElementType {:type string},
        :scale string,
        :policyTags {:names [string]},
        :name string,
        :foreignTypeDefinition string,
        :precision string,
        :fields [TableFieldSchema],
        :mode string,
        :type string,
        :collation string,
        :categories {:names [string]},
        :defaultValueExpression string,
        :maxLength string,
        :roundingMode
        [ROUNDING_MODE_UNSPECIFIED
         ROUND_HALF_AWAY_FROM_ZERO
         ROUND_HALF_EVEN]}],
      :mode string,
      :type string,
      :collation string,
      :categories {:names [string]},
      :defaultValueExpression string,
      :maxLength string,
      :roundingMode
      [ROUNDING_MODE_UNSPECIFIED
       ROUND_HALF_AWAY_FROM_ZERO
       ROUND_HALF_EVEN]}],
    :mode string,
    :type string,
    :collation string,
    :categories {:names [string]},
    :defaultValueExpression string,
    :maxLength string,
    :roundingMode
    [ROUNDING_MODE_UNSPECIFIED
     ROUND_HALF_AWAY_FROM_ZERO
     ROUND_HALF_EVEN]}],
  :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
 :labels object,
 :restrictions
 {:type [RESTRICTION_TYPE_UNSPECIFIED RESTRICTED_DATA_EGRESS]},
 :numTimeTravelPhysicalBytes string,
 :numLongTermBytes string,
 :numPhysicalBytes string,
 :numRows string,
 :expirationTime string,
 :tableReplicationInfo
 {:replicatedSourceLastRefreshTime string,
  :replicationError
  {:debugInfo string,
   :location string,
   :message string,
   :reason string},
  :replicationIntervalMs string,
  :replicationStatus
  [REPLICATION_STATUS_UNSPECIFIED
   ACTIVE
   SOURCE_DELETED
   PERMISSION_DENIED
   UNSUPPORTED_CONFIGURATION],
  :sourceTable
  {:datasetId string, :projectId string, :tableId string}},
 :numLongTermLogicalBytes string,
 :materializedViewStatus
 {:lastRefreshStatus
  {:debugInfo string,
   :location string,
   :message string,
   :reason string},
  :refreshWatermark string},
 :selfLink string,
 :type string,
 :etag string,
 :numTotalLogicalBytes string,
 :timePartitioning
 {:expirationMs string,
  :field string,
  :requirePartitionFilter boolean,
  :type string},
 :requirePartitionFilter boolean,
 :externalDataConfiguration
 {:schema
  {:fields
   [{:description string,
     :rangeElementType {:type string},
     :scale string,
     :policyTags {:names [string]},
     :name string,
     :foreignTypeDefinition string,
     :precision string,
     :fields
     [{:description string,
       :rangeElementType {:type string},
       :scale string,
       :policyTags {:names [string]},
       :name string,
       :foreignTypeDefinition string,
       :precision string,
       :fields [TableFieldSchema],
       :mode string,
       :type string,
       :collation string,
       :categories {:names [string]},
       :defaultValueExpression string,
       :maxLength string,
       :roundingMode
       [ROUNDING_MODE_UNSPECIFIED
        ROUND_HALF_AWAY_FROM_ZERO
        ROUND_HALF_EVEN]}],
     :mode string,
     :type string,
     :collation string,
     :categories {:names [string]},
     :defaultValueExpression string,
     :maxLength string,
     :roundingMode
     [ROUNDING_MODE_UNSPECIFIED
      ROUND_HALF_AWAY_FROM_ZERO
      ROUND_HALF_EVEN]}],
   :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
  :bigtableOptions
  {:columnFamilies
   [{:columns
     [{:encoding string,
       :fieldName string,
       :onlyReadLatest boolean,
       :qualifierEncoded string,
       :qualifierString string,
       :type string}],
     :encoding string,
     :familyId string,
     :onlyReadLatest boolean,
     :type string}],
   :ignoreUnspecifiedColumnFamilies boolean,
   :outputColumnFamiliesAsJson boolean,
   :readRowkeyAsString boolean},
  :connectionId string,
  :csvOptions
  {:allowJaggedRows boolean,
   :allowQuotedNewlines boolean,
   :encoding string,
   :fieldDelimiter string,
   :nullMarker string,
   :preserveAsciiControlCharacters boolean,
   :quote string,
   :skipLeadingRows string},
  :fileSetSpecType
  [FILE_SET_SPEC_TYPE_FILE_SYSTEM_MATCH
   FILE_SET_SPEC_TYPE_NEW_LINE_DELIMITED_MANIFEST],
  :parquetOptions
  {:enableListInference boolean,
   :enumAsString boolean,
   :mapTargetType [MAP_TARGET_TYPE_UNSPECIFIED ARRAY_OF_STRUCT]},
  :autodetect boolean,
  :compression string,
  :sourceFormat string,
  :ignoreUnknownValues boolean,
  :googleSheetsOptions {:range string, :skipLeadingRows string},
  :avroOptions {:useAvroLogicalTypes boolean},
  :hivePartitioningOptions
  {:fields [string],
   :mode string,
   :requirePartitionFilter boolean,
   :sourceUriPrefix string},
  :decimalTargetTypes
  [[DECIMAL_TARGET_TYPE_UNSPECIFIED NUMERIC BIGNUMERIC STRING]],
  :sourceUris [string],
  :maxBadRecords integer,
  :jsonOptions {:encoding string},
  :objectMetadata [OBJECT_METADATA_UNSPECIFIED DIRECTORY SIMPLE],
  :referenceFileSchemaUri string,
  :metadataCacheMode
  [METADATA_CACHE_MODE_UNSPECIFIED AUTOMATIC MANUAL],
  :jsonExtension [JSON_EXTENSION_UNSPECIFIED GEOJSON]},
 :lastModifiedTime string,
 :partitionDefinition {:partitionedColumn [{:field string}]},
 :resourceTags object,
 :defaultRoundingMode
 [ROUNDING_MODE_UNSPECIFIED ROUND_HALF_AWAY_FROM_ZERO ROUND_HALF_EVEN],
 :externalCatalogTableOptions
 {:connectionId string,
  :parameters object,
  :storageDescriptor
  {:inputFormat string,
   :locationUri string,
   :outputFormat string,
   :serdeInfo
   {:name string, :parameters object, :serializationLibrary string}}},
 :clustering {:fields [string]},
 :friendlyName string,
 :tableReference
 {:datasetId string, :projectId string, :tableId string},
 :id string,
 :rangePartitioning
 {:field string,
  :range {:end string, :interval string, :start string}},
 :kind string,
 :replicas [{:datasetId string, :projectId string, :tableId string}],
 :numCurrentPhysicalBytes string,
 :defaultCollation string,
 :cloneDefinition
 {:baseTableReference
  {:datasetId string, :projectId string, :tableId string},
  :cloneTime string},
 :numPartitions string,
 :numActiveLogicalBytes string,
 :tableConstraints
 {:foreignKeys
  [{:columnReferences
    [{:referencedColumn string, :referencingColumn string}],
    :name string,
    :referencedTable
    {:datasetId string, :projectId string, :tableId string}}],
  :primaryKey {:columns [string]}},
 :streamingBuffer
 {:estimatedBytes string,
  :estimatedRows string,
  :oldestEntryTime string},
 :numActivePhysicalBytes string,
 :biglakeConfiguration
 {:connectionId string,
  :fileFormat [FILE_FORMAT_UNSPECIFIED PARQUET],
  :storageUri string,
  :tableFormat [TABLE_FORMAT_UNSPECIFIED ICEBERG]},
 :location string,
 :numLongTermPhysicalBytes string,
 :materializedView
 {:allowNonIncrementalDefinition boolean,
  :enableRefresh boolean,
  :lastRefreshTime string,
  :maxStaleness string,
  :query string,
  :refreshIntervalMs string},
 :encryptionConfiguration {:kmsKeyName string},
 :numTotalPhysicalBytes string,
 :snapshotDefinition
 {:baseTableReference
  {:datasetId string, :projectId string, :tableId string},
  :snapshotTime string},
 :view
 {:foreignDefinitions [{:dialect string, :query string}],
  :privacyPolicy
  {:aggregationThresholdPolicy
   {:privacyUnitColumns [string], :threshold string},
   :differentialPrivacyPolicy
   {:deltaBudget number,
    :deltaBudgetRemaining number,
    :deltaPerQuery number,
    :epsilonBudget number,
    :epsilonBudgetRemaining number,
    :maxEpsilonPerQuery number,
    :maxGroupsContributed string,
    :privacyUnitColumn string},
   :joinRestrictionPolicy
   {:joinAllowedColumns [string],
    :joinCondition
    [JOIN_CONDITION_UNSPECIFIED
     JOIN_ANY
     JOIN_ALL
     JOIN_NOT_REQUIRED
     JOIN_BLOCKED]}},
  :query string,
  :useExplicitColumnNames boolean,
  :useLegacySql boolean,
  :userDefinedFunctionResources
  [{:inlineCode string, :resourceUri string}]},
 :model
 {:modelOptions
  {:labels [string], :lossType string, :modelType string},
  :trainingRuns
  [{:iterationResults
    [{:durationMs string,
      :evalLoss number,
      :index integer,
      :learnRate number,
      :trainingLoss number}],
    :startTime string,
    :state string,
    :trainingOptions
    {:earlyStop boolean,
     :learnRateStrategy string,
     :l1Reg number,
     :l2Reg number,
     :learnRate number,
     :minRelProgress number,
     :warmStart boolean,
     :maxIteration string,
     :lineSearchInitLearnRate number}}]}}"
  [projectId datasetId Table]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables",
     :uri-template-args {:datasetId datasetId, :projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Table}))

(defn tables-patch
  "Updates information in an existing table. The update method replaces the entire table resource, whereas the patch method only replaces fields that are provided in the submitted table resource. This method supports RFC5789 patch semantics.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/patch

projectId <string> Required. Project ID of the table to update
datasetId <string> Required. Dataset ID of the table to update
tableId <string> Required. Table ID of the table to update
Table:
{:creationTime string,
 :description string,
 :maxStaleness string,
 :numBytes string,
 :schema
 {:fields
  [{:description string,
    :rangeElementType {:type string},
    :scale string,
    :policyTags {:names [string]},
    :name string,
    :foreignTypeDefinition string,
    :precision string,
    :fields
    [{:description string,
      :rangeElementType {:type string},
      :scale string,
      :policyTags {:names [string]},
      :name string,
      :foreignTypeDefinition string,
      :precision string,
      :fields
      [{:description string,
        :rangeElementType {:type string},
        :scale string,
        :policyTags {:names [string]},
        :name string,
        :foreignTypeDefinition string,
        :precision string,
        :fields [TableFieldSchema],
        :mode string,
        :type string,
        :collation string,
        :categories {:names [string]},
        :defaultValueExpression string,
        :maxLength string,
        :roundingMode
        [ROUNDING_MODE_UNSPECIFIED
         ROUND_HALF_AWAY_FROM_ZERO
         ROUND_HALF_EVEN]}],
      :mode string,
      :type string,
      :collation string,
      :categories {:names [string]},
      :defaultValueExpression string,
      :maxLength string,
      :roundingMode
      [ROUNDING_MODE_UNSPECIFIED
       ROUND_HALF_AWAY_FROM_ZERO
       ROUND_HALF_EVEN]}],
    :mode string,
    :type string,
    :collation string,
    :categories {:names [string]},
    :defaultValueExpression string,
    :maxLength string,
    :roundingMode
    [ROUNDING_MODE_UNSPECIFIED
     ROUND_HALF_AWAY_FROM_ZERO
     ROUND_HALF_EVEN]}],
  :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
 :labels object,
 :restrictions
 {:type [RESTRICTION_TYPE_UNSPECIFIED RESTRICTED_DATA_EGRESS]},
 :numTimeTravelPhysicalBytes string,
 :numLongTermBytes string,
 :numPhysicalBytes string,
 :numRows string,
 :expirationTime string,
 :tableReplicationInfo
 {:replicatedSourceLastRefreshTime string,
  :replicationError
  {:debugInfo string,
   :location string,
   :message string,
   :reason string},
  :replicationIntervalMs string,
  :replicationStatus
  [REPLICATION_STATUS_UNSPECIFIED
   ACTIVE
   SOURCE_DELETED
   PERMISSION_DENIED
   UNSUPPORTED_CONFIGURATION],
  :sourceTable
  {:datasetId string, :projectId string, :tableId string}},
 :numLongTermLogicalBytes string,
 :materializedViewStatus
 {:lastRefreshStatus
  {:debugInfo string,
   :location string,
   :message string,
   :reason string},
  :refreshWatermark string},
 :selfLink string,
 :type string,
 :etag string,
 :numTotalLogicalBytes string,
 :timePartitioning
 {:expirationMs string,
  :field string,
  :requirePartitionFilter boolean,
  :type string},
 :requirePartitionFilter boolean,
 :externalDataConfiguration
 {:schema
  {:fields
   [{:description string,
     :rangeElementType {:type string},
     :scale string,
     :policyTags {:names [string]},
     :name string,
     :foreignTypeDefinition string,
     :precision string,
     :fields
     [{:description string,
       :rangeElementType {:type string},
       :scale string,
       :policyTags {:names [string]},
       :name string,
       :foreignTypeDefinition string,
       :precision string,
       :fields [TableFieldSchema],
       :mode string,
       :type string,
       :collation string,
       :categories {:names [string]},
       :defaultValueExpression string,
       :maxLength string,
       :roundingMode
       [ROUNDING_MODE_UNSPECIFIED
        ROUND_HALF_AWAY_FROM_ZERO
        ROUND_HALF_EVEN]}],
     :mode string,
     :type string,
     :collation string,
     :categories {:names [string]},
     :defaultValueExpression string,
     :maxLength string,
     :roundingMode
     [ROUNDING_MODE_UNSPECIFIED
      ROUND_HALF_AWAY_FROM_ZERO
      ROUND_HALF_EVEN]}],
   :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
  :bigtableOptions
  {:columnFamilies
   [{:columns
     [{:encoding string,
       :fieldName string,
       :onlyReadLatest boolean,
       :qualifierEncoded string,
       :qualifierString string,
       :type string}],
     :encoding string,
     :familyId string,
     :onlyReadLatest boolean,
     :type string}],
   :ignoreUnspecifiedColumnFamilies boolean,
   :outputColumnFamiliesAsJson boolean,
   :readRowkeyAsString boolean},
  :connectionId string,
  :csvOptions
  {:allowJaggedRows boolean,
   :allowQuotedNewlines boolean,
   :encoding string,
   :fieldDelimiter string,
   :nullMarker string,
   :preserveAsciiControlCharacters boolean,
   :quote string,
   :skipLeadingRows string},
  :fileSetSpecType
  [FILE_SET_SPEC_TYPE_FILE_SYSTEM_MATCH
   FILE_SET_SPEC_TYPE_NEW_LINE_DELIMITED_MANIFEST],
  :parquetOptions
  {:enableListInference boolean,
   :enumAsString boolean,
   :mapTargetType [MAP_TARGET_TYPE_UNSPECIFIED ARRAY_OF_STRUCT]},
  :autodetect boolean,
  :compression string,
  :sourceFormat string,
  :ignoreUnknownValues boolean,
  :googleSheetsOptions {:range string, :skipLeadingRows string},
  :avroOptions {:useAvroLogicalTypes boolean},
  :hivePartitioningOptions
  {:fields [string],
   :mode string,
   :requirePartitionFilter boolean,
   :sourceUriPrefix string},
  :decimalTargetTypes
  [[DECIMAL_TARGET_TYPE_UNSPECIFIED NUMERIC BIGNUMERIC STRING]],
  :sourceUris [string],
  :maxBadRecords integer,
  :jsonOptions {:encoding string},
  :objectMetadata [OBJECT_METADATA_UNSPECIFIED DIRECTORY SIMPLE],
  :referenceFileSchemaUri string,
  :metadataCacheMode
  [METADATA_CACHE_MODE_UNSPECIFIED AUTOMATIC MANUAL],
  :jsonExtension [JSON_EXTENSION_UNSPECIFIED GEOJSON]},
 :lastModifiedTime string,
 :partitionDefinition {:partitionedColumn [{:field string}]},
 :resourceTags object,
 :defaultRoundingMode
 [ROUNDING_MODE_UNSPECIFIED ROUND_HALF_AWAY_FROM_ZERO ROUND_HALF_EVEN],
 :externalCatalogTableOptions
 {:connectionId string,
  :parameters object,
  :storageDescriptor
  {:inputFormat string,
   :locationUri string,
   :outputFormat string,
   :serdeInfo
   {:name string, :parameters object, :serializationLibrary string}}},
 :clustering {:fields [string]},
 :friendlyName string,
 :tableReference
 {:datasetId string, :projectId string, :tableId string},
 :id string,
 :rangePartitioning
 {:field string,
  :range {:end string, :interval string, :start string}},
 :kind string,
 :replicas [{:datasetId string, :projectId string, :tableId string}],
 :numCurrentPhysicalBytes string,
 :defaultCollation string,
 :cloneDefinition
 {:baseTableReference
  {:datasetId string, :projectId string, :tableId string},
  :cloneTime string},
 :numPartitions string,
 :numActiveLogicalBytes string,
 :tableConstraints
 {:foreignKeys
  [{:columnReferences
    [{:referencedColumn string, :referencingColumn string}],
    :name string,
    :referencedTable
    {:datasetId string, :projectId string, :tableId string}}],
  :primaryKey {:columns [string]}},
 :streamingBuffer
 {:estimatedBytes string,
  :estimatedRows string,
  :oldestEntryTime string},
 :numActivePhysicalBytes string,
 :biglakeConfiguration
 {:connectionId string,
  :fileFormat [FILE_FORMAT_UNSPECIFIED PARQUET],
  :storageUri string,
  :tableFormat [TABLE_FORMAT_UNSPECIFIED ICEBERG]},
 :location string,
 :numLongTermPhysicalBytes string,
 :materializedView
 {:allowNonIncrementalDefinition boolean,
  :enableRefresh boolean,
  :lastRefreshTime string,
  :maxStaleness string,
  :query string,
  :refreshIntervalMs string},
 :encryptionConfiguration {:kmsKeyName string},
 :numTotalPhysicalBytes string,
 :snapshotDefinition
 {:baseTableReference
  {:datasetId string, :projectId string, :tableId string},
  :snapshotTime string},
 :view
 {:foreignDefinitions [{:dialect string, :query string}],
  :privacyPolicy
  {:aggregationThresholdPolicy
   {:privacyUnitColumns [string], :threshold string},
   :differentialPrivacyPolicy
   {:deltaBudget number,
    :deltaBudgetRemaining number,
    :deltaPerQuery number,
    :epsilonBudget number,
    :epsilonBudgetRemaining number,
    :maxEpsilonPerQuery number,
    :maxGroupsContributed string,
    :privacyUnitColumn string},
   :joinRestrictionPolicy
   {:joinAllowedColumns [string],
    :joinCondition
    [JOIN_CONDITION_UNSPECIFIED
     JOIN_ANY
     JOIN_ALL
     JOIN_NOT_REQUIRED
     JOIN_BLOCKED]}},
  :query string,
  :useExplicitColumnNames boolean,
  :useLegacySql boolean,
  :userDefinedFunctionResources
  [{:inlineCode string, :resourceUri string}]},
 :model
 {:modelOptions
  {:labels [string], :lossType string, :modelType string},
  :trainingRuns
  [{:iterationResults
    [{:durationMs string,
      :evalLoss number,
      :index integer,
      :learnRate number,
      :trainingLoss number}],
    :startTime string,
    :state string,
    :trainingOptions
    {:earlyStop boolean,
     :learnRateStrategy string,
     :l1Reg number,
     :l2Reg number,
     :learnRate number,
     :minRelProgress number,
     :warmStart boolean,
     :maxIteration string,
     :lineSearchInitLearnRate number}}]}}

optional:
autodetect_schema <boolean> Optional.  When true will autodetect schema, else will keep original schema"
  ([projectId datasetId tableId Table]
    (tables-patch projectId datasetId tableId Table nil))
  ([projectId datasetId tableId Table optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}",
       :uri-template-args
       {:datasetId datasetId, :projectId projectId, :tableId tableId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Table})))

(defn tables-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body TestIamPermissionsRequest}))

(defn tables-update
  "Updates information in an existing table. The update method replaces the entire Table resource, whereas the patch method only replaces fields that are provided in the submitted Table resource.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/update

projectId <string> Required. Project ID of the table to update
datasetId <string> Required. Dataset ID of the table to update
tableId <string> Required. Table ID of the table to update
Table:
{:creationTime string,
 :description string,
 :maxStaleness string,
 :numBytes string,
 :schema
 {:fields
  [{:description string,
    :rangeElementType {:type string},
    :scale string,
    :policyTags {:names [string]},
    :name string,
    :foreignTypeDefinition string,
    :precision string,
    :fields
    [{:description string,
      :rangeElementType {:type string},
      :scale string,
      :policyTags {:names [string]},
      :name string,
      :foreignTypeDefinition string,
      :precision string,
      :fields
      [{:description string,
        :rangeElementType {:type string},
        :scale string,
        :policyTags {:names [string]},
        :name string,
        :foreignTypeDefinition string,
        :precision string,
        :fields [TableFieldSchema],
        :mode string,
        :type string,
        :collation string,
        :categories {:names [string]},
        :defaultValueExpression string,
        :maxLength string,
        :roundingMode
        [ROUNDING_MODE_UNSPECIFIED
         ROUND_HALF_AWAY_FROM_ZERO
         ROUND_HALF_EVEN]}],
      :mode string,
      :type string,
      :collation string,
      :categories {:names [string]},
      :defaultValueExpression string,
      :maxLength string,
      :roundingMode
      [ROUNDING_MODE_UNSPECIFIED
       ROUND_HALF_AWAY_FROM_ZERO
       ROUND_HALF_EVEN]}],
    :mode string,
    :type string,
    :collation string,
    :categories {:names [string]},
    :defaultValueExpression string,
    :maxLength string,
    :roundingMode
    [ROUNDING_MODE_UNSPECIFIED
     ROUND_HALF_AWAY_FROM_ZERO
     ROUND_HALF_EVEN]}],
  :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
 :labels object,
 :restrictions
 {:type [RESTRICTION_TYPE_UNSPECIFIED RESTRICTED_DATA_EGRESS]},
 :numTimeTravelPhysicalBytes string,
 :numLongTermBytes string,
 :numPhysicalBytes string,
 :numRows string,
 :expirationTime string,
 :tableReplicationInfo
 {:replicatedSourceLastRefreshTime string,
  :replicationError
  {:debugInfo string,
   :location string,
   :message string,
   :reason string},
  :replicationIntervalMs string,
  :replicationStatus
  [REPLICATION_STATUS_UNSPECIFIED
   ACTIVE
   SOURCE_DELETED
   PERMISSION_DENIED
   UNSUPPORTED_CONFIGURATION],
  :sourceTable
  {:datasetId string, :projectId string, :tableId string}},
 :numLongTermLogicalBytes string,
 :materializedViewStatus
 {:lastRefreshStatus
  {:debugInfo string,
   :location string,
   :message string,
   :reason string},
  :refreshWatermark string},
 :selfLink string,
 :type string,
 :etag string,
 :numTotalLogicalBytes string,
 :timePartitioning
 {:expirationMs string,
  :field string,
  :requirePartitionFilter boolean,
  :type string},
 :requirePartitionFilter boolean,
 :externalDataConfiguration
 {:schema
  {:fields
   [{:description string,
     :rangeElementType {:type string},
     :scale string,
     :policyTags {:names [string]},
     :name string,
     :foreignTypeDefinition string,
     :precision string,
     :fields
     [{:description string,
       :rangeElementType {:type string},
       :scale string,
       :policyTags {:names [string]},
       :name string,
       :foreignTypeDefinition string,
       :precision string,
       :fields [TableFieldSchema],
       :mode string,
       :type string,
       :collation string,
       :categories {:names [string]},
       :defaultValueExpression string,
       :maxLength string,
       :roundingMode
       [ROUNDING_MODE_UNSPECIFIED
        ROUND_HALF_AWAY_FROM_ZERO
        ROUND_HALF_EVEN]}],
     :mode string,
     :type string,
     :collation string,
     :categories {:names [string]},
     :defaultValueExpression string,
     :maxLength string,
     :roundingMode
     [ROUNDING_MODE_UNSPECIFIED
      ROUND_HALF_AWAY_FROM_ZERO
      ROUND_HALF_EVEN]}],
   :foreignTypeInfo {:typeSystem [TYPE_SYSTEM_UNSPECIFIED HIVE]}},
  :bigtableOptions
  {:columnFamilies
   [{:columns
     [{:encoding string,
       :fieldName string,
       :onlyReadLatest boolean,
       :qualifierEncoded string,
       :qualifierString string,
       :type string}],
     :encoding string,
     :familyId string,
     :onlyReadLatest boolean,
     :type string}],
   :ignoreUnspecifiedColumnFamilies boolean,
   :outputColumnFamiliesAsJson boolean,
   :readRowkeyAsString boolean},
  :connectionId string,
  :csvOptions
  {:allowJaggedRows boolean,
   :allowQuotedNewlines boolean,
   :encoding string,
   :fieldDelimiter string,
   :nullMarker string,
   :preserveAsciiControlCharacters boolean,
   :quote string,
   :skipLeadingRows string},
  :fileSetSpecType
  [FILE_SET_SPEC_TYPE_FILE_SYSTEM_MATCH
   FILE_SET_SPEC_TYPE_NEW_LINE_DELIMITED_MANIFEST],
  :parquetOptions
  {:enableListInference boolean,
   :enumAsString boolean,
   :mapTargetType [MAP_TARGET_TYPE_UNSPECIFIED ARRAY_OF_STRUCT]},
  :autodetect boolean,
  :compression string,
  :sourceFormat string,
  :ignoreUnknownValues boolean,
  :googleSheetsOptions {:range string, :skipLeadingRows string},
  :avroOptions {:useAvroLogicalTypes boolean},
  :hivePartitioningOptions
  {:fields [string],
   :mode string,
   :requirePartitionFilter boolean,
   :sourceUriPrefix string},
  :decimalTargetTypes
  [[DECIMAL_TARGET_TYPE_UNSPECIFIED NUMERIC BIGNUMERIC STRING]],
  :sourceUris [string],
  :maxBadRecords integer,
  :jsonOptions {:encoding string},
  :objectMetadata [OBJECT_METADATA_UNSPECIFIED DIRECTORY SIMPLE],
  :referenceFileSchemaUri string,
  :metadataCacheMode
  [METADATA_CACHE_MODE_UNSPECIFIED AUTOMATIC MANUAL],
  :jsonExtension [JSON_EXTENSION_UNSPECIFIED GEOJSON]},
 :lastModifiedTime string,
 :partitionDefinition {:partitionedColumn [{:field string}]},
 :resourceTags object,
 :defaultRoundingMode
 [ROUNDING_MODE_UNSPECIFIED ROUND_HALF_AWAY_FROM_ZERO ROUND_HALF_EVEN],
 :externalCatalogTableOptions
 {:connectionId string,
  :parameters object,
  :storageDescriptor
  {:inputFormat string,
   :locationUri string,
   :outputFormat string,
   :serdeInfo
   {:name string, :parameters object, :serializationLibrary string}}},
 :clustering {:fields [string]},
 :friendlyName string,
 :tableReference
 {:datasetId string, :projectId string, :tableId string},
 :id string,
 :rangePartitioning
 {:field string,
  :range {:end string, :interval string, :start string}},
 :kind string,
 :replicas [{:datasetId string, :projectId string, :tableId string}],
 :numCurrentPhysicalBytes string,
 :defaultCollation string,
 :cloneDefinition
 {:baseTableReference
  {:datasetId string, :projectId string, :tableId string},
  :cloneTime string},
 :numPartitions string,
 :numActiveLogicalBytes string,
 :tableConstraints
 {:foreignKeys
  [{:columnReferences
    [{:referencedColumn string, :referencingColumn string}],
    :name string,
    :referencedTable
    {:datasetId string, :projectId string, :tableId string}}],
  :primaryKey {:columns [string]}},
 :streamingBuffer
 {:estimatedBytes string,
  :estimatedRows string,
  :oldestEntryTime string},
 :numActivePhysicalBytes string,
 :biglakeConfiguration
 {:connectionId string,
  :fileFormat [FILE_FORMAT_UNSPECIFIED PARQUET],
  :storageUri string,
  :tableFormat [TABLE_FORMAT_UNSPECIFIED ICEBERG]},
 :location string,
 :numLongTermPhysicalBytes string,
 :materializedView
 {:allowNonIncrementalDefinition boolean,
  :enableRefresh boolean,
  :lastRefreshTime string,
  :maxStaleness string,
  :query string,
  :refreshIntervalMs string},
 :encryptionConfiguration {:kmsKeyName string},
 :numTotalPhysicalBytes string,
 :snapshotDefinition
 {:baseTableReference
  {:datasetId string, :projectId string, :tableId string},
  :snapshotTime string},
 :view
 {:foreignDefinitions [{:dialect string, :query string}],
  :privacyPolicy
  {:aggregationThresholdPolicy
   {:privacyUnitColumns [string], :threshold string},
   :differentialPrivacyPolicy
   {:deltaBudget number,
    :deltaBudgetRemaining number,
    :deltaPerQuery number,
    :epsilonBudget number,
    :epsilonBudgetRemaining number,
    :maxEpsilonPerQuery number,
    :maxGroupsContributed string,
    :privacyUnitColumn string},
   :joinRestrictionPolicy
   {:joinAllowedColumns [string],
    :joinCondition
    [JOIN_CONDITION_UNSPECIFIED
     JOIN_ANY
     JOIN_ALL
     JOIN_NOT_REQUIRED
     JOIN_BLOCKED]}},
  :query string,
  :useExplicitColumnNames boolean,
  :useLegacySql boolean,
  :userDefinedFunctionResources
  [{:inlineCode string, :resourceUri string}]},
 :model
 {:modelOptions
  {:labels [string], :lossType string, :modelType string},
  :trainingRuns
  [{:iterationResults
    [{:durationMs string,
      :evalLoss number,
      :index integer,
      :learnRate number,
      :trainingLoss number}],
    :startTime string,
    :state string,
    :trainingOptions
    {:earlyStop boolean,
     :learnRateStrategy string,
     :l1Reg number,
     :l2Reg number,
     :learnRate number,
     :minRelProgress number,
     :warmStart boolean,
     :maxIteration string,
     :lineSearchInitLearnRate number}}]}}

optional:
autodetect_schema <boolean> Optional.  When true will autodetect schema, else will keep original schema"
  ([projectId datasetId tableId Table]
    (tables-update projectId datasetId tableId Table nil))
  ([projectId datasetId tableId Table optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}",
       :uri-template-args
       {:datasetId datasetId, :projectId projectId, :tableId tableId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Table})))

(defn tables-delete
  "Deletes the table specified by tableId from the dataset. If the table contains data, all the data will be deleted.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/delete

projectId <string> Required. Project ID of the table to delete
datasetId <string> Required. Dataset ID of the table to delete
tableId <string> Required. Table ID of the table to delete"
  [projectId datasetId tableId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}",
     :uri-template-args
     {:datasetId datasetId, :projectId projectId, :tableId tableId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn tables-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquery.googleapis.com/bigquery/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn tables-list
  "Lists all tables in the specified dataset. Requires the READER dataset role.
https://cloud.google.com/bigquery/docs/reference/rest/v2/tables/list

projectId <string> Required. Project ID of the tables to list
datasetId <string> Required. Dataset ID of the tables to list

optional:
maxResults <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection."
  ([projectId datasetId] (tables-list projectId datasetId nil))
  ([projectId datasetId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquery.googleapis.com/bigquery/v2/projects/{+projectId}/datasets/{+datasetId}/tables",
       :uri-template-args {:datasetId datasetId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(ns happygapi2.dataflow
  "Dataflow API
Manages Google Cloud Dataflow projects on Google Cloud Platform.
See: https://cloud.google.com/dataflow"
  (:require [happy.oauth2.client :as client]))

(defn projects-deleteSnapshots
  "Deletes a snapshot.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the snapshot belongs to.

optional:
snapshotId <string> The ID of the snapshot.
location <string> The location that contains this snapshot."
  ([projectId] (projects-deleteSnapshots projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/snapshots",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-workerMessages
  "Send a worker_message to the service.
https://cloud.google.com/dataflow

projectId <string> The project to send the WorkerMessages to.
SendWorkerMessagesRequest:
{:workerMessages
 [{:labels object,
   :streamingScalingReport
   {:maximumBytesCount integer,
    :outstandingBytesCount integer,
    :maximumThreadCount integer,
    :activeBundleCount integer,
    :activeThreadCount integer,
    :outstandingBundleCount integer,
    :maximumBytes string,
    :maximumBundleCount integer,
    :outstandingBytes string},
   :workerHealthReport
   {:vmIsHealthy boolean,
    :vmIsBroken boolean,
    :vmBrokenCode string,
    :msg string,
    :vmStartupTime string,
    :reportInterval string,
    :pods [object]},
   :workerShutdownNotice {:reason string},
   :time string,
   :workerThreadScalingReport {:currentThreadCount integer},
   :workerLifecycleEvent
   {:event
    [UNKNOWN_EVENT
     OS_START
     CONTAINER_START
     NETWORK_UP
     STAGING_FILES_DOWNLOAD_START
     STAGING_FILES_DOWNLOAD_FINISH
     SDK_INSTALL_START
     SDK_INSTALL_FINISH],
    :metadata object,
    :containerStartTime string},
   :perWorkerMetrics
   {:perStepNamespaceMetrics
    [{:metricsNamespace string,
      :originalStep string,
      :metricValues
      [{:metric string,
        :metricLabels object,
        :valueInt64 string,
        :valueHistogram DataflowHistogramValue}]}]},
   :dataSamplingReport
   {:elementsSampledBytes string,
    :elementsSampledCount string,
    :pcollectionsSampledCount string,
    :exceptionsSampledCount string,
    :bytesWrittenDelta string,
    :translationErrorsCount string,
    :persistenceErrorsCount string},
   :workerMessageCode {:code string, :parameters object},
   :workerMetrics
   {:cpuTime [{:timestamp string, :totalMs string, :rate number}],
    :memoryInfo
    [{:timestamp string,
      :totalGbMs string,
      :currentRssBytes string,
      :currentLimitBytes string,
      :currentOoms string}],
    :containers object}}],
 :location string}"
  [projectId SendWorkerMessagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/WorkerMessages",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body SendWorkerMessagesRequest}))

(defn projects-snapshots-get
  "Gets information about a snapshot.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the snapshot belongs to.
snapshotId <string> The ID of the snapshot.

optional:
location <string> The location that contains this snapshot."
  ([projectId snapshotId]
    (projects-snapshots-get projectId snapshotId nil))
  ([projectId snapshotId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/snapshots/{snapshotId}",
       :uri-template-args
       {:projectId projectId, :snapshotId snapshotId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-snapshots-list
  "Lists snapshots.
https://cloud.google.com/dataflow

projectId <string> The project ID to list snapshots for.

optional:
jobId <string> If specified, list snapshots created from this job.
location <string> The location to list snapshots in."
  ([projectId] (projects-snapshots-list projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/snapshots",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-jobs-create
  "Creates a Cloud Dataflow job. To create a job, we recommend using `projects.locations.jobs.create` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.create` is not recommended, as your job will always start in `us-central1`. Do not enter confidential information when you supply string values using the API.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the job belongs to.
Job:
{:labels object,
 :stepsLocation string,
 :executionInfo {:stages object},
 :jobMetadata
 {:sdkVersion
  {:version string,
   :versionDisplayName string,
   :sdkSupportStatus [UNKNOWN SUPPORTED STALE DEPRECATED UNSUPPORTED],
   :bugs
   [{:type [TYPE_UNSPECIFIED GENERAL PERFORMANCE DATALOSS],
     :severity [SEVERITY_UNSPECIFIED NOTICE WARNING SEVERE],
     :uri string}]},
  :spannerDetails
  [{:projectId string, :instanceId string, :databaseId string}],
  :bigqueryDetails
  [{:table string, :dataset string, :projectId string, :query string}],
  :bigTableDetails
  [{:projectId string, :instanceId string, :tableId string}],
  :pubsubDetails [{:topic string, :subscription string}],
  :fileDetails [{:filePattern string}],
  :datastoreDetails [{:namespace string, :projectId string}],
  :userDisplayProperties object},
 :clientRequestId string,
 :startTime string,
 :satisfiesPzi boolean,
 :stageStates
 [{:executionStageName string,
   :executionStageState
   [JOB_STATE_UNKNOWN
    JOB_STATE_STOPPED
    JOB_STATE_RUNNING
    JOB_STATE_DONE
    JOB_STATE_FAILED
    JOB_STATE_CANCELLED
    JOB_STATE_UPDATED
    JOB_STATE_DRAINING
    JOB_STATE_DRAINED
    JOB_STATE_PENDING
    JOB_STATE_CANCELLING
    JOB_STATE_QUEUED
    JOB_STATE_RESOURCE_CLEANING_UP],
   :currentStateTime string}],
 :name string,
 :steps [{:kind string, :name string, :properties object}],
 :createTime string,
 :currentStateTime string,
 :type [JOB_TYPE_UNKNOWN JOB_TYPE_BATCH JOB_TYPE_STREAMING],
 :transformNameMapping object,
 :replaceJobId string,
 :pipelineDescription
 {:originalPipelineTransform
  [{:kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :id string,
    :name string,
    :displayData
    [{:durationValue string,
      :key string,
      :int64Value string,
      :strValue string,
      :javaClassValue string,
      :label string,
      :floatValue number,
      :timestampValue string,
      :url string,
      :shortStrValue string,
      :namespace string,
      :boolValue boolean}],
    :outputCollectionName [string],
    :inputCollectionName [string]}],
  :executionPipelineStage
  [{:name string,
    :id string,
    :kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :inputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :outputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :prerequisiteStage [string],
    :componentTransform
    [{:userName string, :name string, :originalTransform string}],
    :componentSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string}]}],
  :displayData
  [{:durationValue string,
    :key string,
    :int64Value string,
    :strValue string,
    :javaClassValue string,
    :label string,
    :floatValue number,
    :timestampValue string,
    :url string,
    :shortStrValue string,
    :namespace string,
    :boolValue boolean}],
  :stepNamesHash string},
 :replacedByJobId string,
 :satisfiesPzs boolean,
 :currentState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :tempFiles [string],
 :id string,
 :createdFromSnapshotId string,
 :environment
 {:flexResourceSchedulingGoal
  [FLEXRS_UNSPECIFIED FLEXRS_SPEED_OPTIMIZED FLEXRS_COST_OPTIMIZED],
  :internalExperiments object,
  :experiments [string],
  :workerRegion string,
  :shuffleMode [SHUFFLE_MODE_UNSPECIFIED VM_BASED SERVICE_BASED],
  :debugOptions
  {:enableHotKeyLogging boolean,
   :dataSampling
   {:behaviors
    [[DATA_SAMPLING_BEHAVIOR_UNSPECIFIED
      DISABLED
      ALWAYS_ON
      EXCEPTIONS]]}},
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :sdkPipelineOptions object,
  :useStreamingEngineResourceBasedBilling boolean,
  :serviceKmsKeyName string,
  :tempStoragePrefix string,
  :serviceAccountEmail string,
  :clusterManagerApiService string,
  :userAgent object,
  :serviceOptions [string],
  :workerZone string,
  :version object,
  :workerPools
  [{:sdkHarnessContainerImages
    [{:containerImage string,
      :useSingleCorePerContainer boolean,
      :environmentId string,
      :capabilities [string]}],
    :diskSourceImage string,
    :zone string,
    :workerHarnessContainerImage string,
    :poolArgs object,
    :machineType string,
    :defaultPackageSet
    [DEFAULT_PACKAGE_SET_UNKNOWN
     DEFAULT_PACKAGE_SET_NONE
     DEFAULT_PACKAGE_SET_JAVA
     DEFAULT_PACKAGE_SET_PYTHON],
    :onHostMaintenance string,
    :dataDisks
    [{:sizeGb integer, :diskType string, :mountPoint string}],
    :numWorkers integer,
    :numThreadsPerWorker integer,
    :diskType string,
    :ipConfiguration
    [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
    :kind string,
    :taskrunnerSettings
    {:logToSerialconsole boolean,
     :continueOnException boolean,
     :logDir string,
     :commandlinesFileName string,
     :alsologtostderr boolean,
     :streamingWorkerMainClass string,
     :taskGroup string,
     :baseUrl string,
     :tempStoragePrefix string,
     :vmId string,
     :baseTaskDir string,
     :oauthScopes [string],
     :logUploadLocation string,
     :taskUser string,
     :languageHint string,
     :parallelWorkerSettings
     {:baseUrl string,
      :reportingEnabled boolean,
      :servicePath string,
      :shuffleServicePath string,
      :workerId string,
      :tempStoragePrefix string},
     :dataflowApiVersion string,
     :harnessCommand string,
     :workflowFileName string},
    :packages [{:name string, :location string}],
    :diskSizeGb integer,
    :network string,
    :teardownPolicy
    [TEARDOWN_POLICY_UNKNOWN
     TEARDOWN_ALWAYS
     TEARDOWN_ON_SUCCESS
     TEARDOWN_NEVER],
    :autoscalingSettings
    {:algorithm
     [AUTOSCALING_ALGORITHM_UNKNOWN
      AUTOSCALING_ALGORITHM_NONE
      AUTOSCALING_ALGORITHM_BASIC],
     :maxNumWorkers integer},
    :metadata object,
    :subnetwork string}],
  :dataset string},
 :projectId string,
 :requestedState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :location string,
 :runtimeUpdatableParams
 {:maxNumWorkers integer,
  :minNumWorkers integer,
  :workerUtilizationHint number}}

optional:
view <string> The level of information requested in response.
replaceJobId <string> Deprecated. This field is now in the Job message.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job."
  ([projectId Job] (projects-jobs-create projectId Job nil))
  ([projectId Job optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"],
       :body Job})))

(defn projects-jobs-get
  "Gets the state of the specified Cloud Dataflow job. To get the state of a job, we recommend using `projects.locations.jobs.get` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.get` is not recommended, as you can only get the state of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the job belongs to.
jobId <string> The job ID.

optional:
view <string> The level of information requested in response.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job."
  ([projectId jobId] (projects-jobs-get projectId jobId nil))
  ([projectId jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}",
       :uri-template-args {:projectId projectId, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-jobs-update
  "Updates the state of an existing Cloud Dataflow job. To update the state of an existing job, we recommend using `projects.locations.jobs.update` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.update` is not recommended, as you can only update the state of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the job belongs to.
jobId <string> The job ID.
Job:
{:labels object,
 :stepsLocation string,
 :executionInfo {:stages object},
 :jobMetadata
 {:sdkVersion
  {:version string,
   :versionDisplayName string,
   :sdkSupportStatus [UNKNOWN SUPPORTED STALE DEPRECATED UNSUPPORTED],
   :bugs
   [{:type [TYPE_UNSPECIFIED GENERAL PERFORMANCE DATALOSS],
     :severity [SEVERITY_UNSPECIFIED NOTICE WARNING SEVERE],
     :uri string}]},
  :spannerDetails
  [{:projectId string, :instanceId string, :databaseId string}],
  :bigqueryDetails
  [{:table string, :dataset string, :projectId string, :query string}],
  :bigTableDetails
  [{:projectId string, :instanceId string, :tableId string}],
  :pubsubDetails [{:topic string, :subscription string}],
  :fileDetails [{:filePattern string}],
  :datastoreDetails [{:namespace string, :projectId string}],
  :userDisplayProperties object},
 :clientRequestId string,
 :startTime string,
 :satisfiesPzi boolean,
 :stageStates
 [{:executionStageName string,
   :executionStageState
   [JOB_STATE_UNKNOWN
    JOB_STATE_STOPPED
    JOB_STATE_RUNNING
    JOB_STATE_DONE
    JOB_STATE_FAILED
    JOB_STATE_CANCELLED
    JOB_STATE_UPDATED
    JOB_STATE_DRAINING
    JOB_STATE_DRAINED
    JOB_STATE_PENDING
    JOB_STATE_CANCELLING
    JOB_STATE_QUEUED
    JOB_STATE_RESOURCE_CLEANING_UP],
   :currentStateTime string}],
 :name string,
 :steps [{:kind string, :name string, :properties object}],
 :createTime string,
 :currentStateTime string,
 :type [JOB_TYPE_UNKNOWN JOB_TYPE_BATCH JOB_TYPE_STREAMING],
 :transformNameMapping object,
 :replaceJobId string,
 :pipelineDescription
 {:originalPipelineTransform
  [{:kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :id string,
    :name string,
    :displayData
    [{:durationValue string,
      :key string,
      :int64Value string,
      :strValue string,
      :javaClassValue string,
      :label string,
      :floatValue number,
      :timestampValue string,
      :url string,
      :shortStrValue string,
      :namespace string,
      :boolValue boolean}],
    :outputCollectionName [string],
    :inputCollectionName [string]}],
  :executionPipelineStage
  [{:name string,
    :id string,
    :kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :inputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :outputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :prerequisiteStage [string],
    :componentTransform
    [{:userName string, :name string, :originalTransform string}],
    :componentSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string}]}],
  :displayData
  [{:durationValue string,
    :key string,
    :int64Value string,
    :strValue string,
    :javaClassValue string,
    :label string,
    :floatValue number,
    :timestampValue string,
    :url string,
    :shortStrValue string,
    :namespace string,
    :boolValue boolean}],
  :stepNamesHash string},
 :replacedByJobId string,
 :satisfiesPzs boolean,
 :currentState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :tempFiles [string],
 :id string,
 :createdFromSnapshotId string,
 :environment
 {:flexResourceSchedulingGoal
  [FLEXRS_UNSPECIFIED FLEXRS_SPEED_OPTIMIZED FLEXRS_COST_OPTIMIZED],
  :internalExperiments object,
  :experiments [string],
  :workerRegion string,
  :shuffleMode [SHUFFLE_MODE_UNSPECIFIED VM_BASED SERVICE_BASED],
  :debugOptions
  {:enableHotKeyLogging boolean,
   :dataSampling
   {:behaviors
    [[DATA_SAMPLING_BEHAVIOR_UNSPECIFIED
      DISABLED
      ALWAYS_ON
      EXCEPTIONS]]}},
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :sdkPipelineOptions object,
  :useStreamingEngineResourceBasedBilling boolean,
  :serviceKmsKeyName string,
  :tempStoragePrefix string,
  :serviceAccountEmail string,
  :clusterManagerApiService string,
  :userAgent object,
  :serviceOptions [string],
  :workerZone string,
  :version object,
  :workerPools
  [{:sdkHarnessContainerImages
    [{:containerImage string,
      :useSingleCorePerContainer boolean,
      :environmentId string,
      :capabilities [string]}],
    :diskSourceImage string,
    :zone string,
    :workerHarnessContainerImage string,
    :poolArgs object,
    :machineType string,
    :defaultPackageSet
    [DEFAULT_PACKAGE_SET_UNKNOWN
     DEFAULT_PACKAGE_SET_NONE
     DEFAULT_PACKAGE_SET_JAVA
     DEFAULT_PACKAGE_SET_PYTHON],
    :onHostMaintenance string,
    :dataDisks
    [{:sizeGb integer, :diskType string, :mountPoint string}],
    :numWorkers integer,
    :numThreadsPerWorker integer,
    :diskType string,
    :ipConfiguration
    [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
    :kind string,
    :taskrunnerSettings
    {:logToSerialconsole boolean,
     :continueOnException boolean,
     :logDir string,
     :commandlinesFileName string,
     :alsologtostderr boolean,
     :streamingWorkerMainClass string,
     :taskGroup string,
     :baseUrl string,
     :tempStoragePrefix string,
     :vmId string,
     :baseTaskDir string,
     :oauthScopes [string],
     :logUploadLocation string,
     :taskUser string,
     :languageHint string,
     :parallelWorkerSettings
     {:baseUrl string,
      :reportingEnabled boolean,
      :servicePath string,
      :shuffleServicePath string,
      :workerId string,
      :tempStoragePrefix string},
     :dataflowApiVersion string,
     :harnessCommand string,
     :workflowFileName string},
    :packages [{:name string, :location string}],
    :diskSizeGb integer,
    :network string,
    :teardownPolicy
    [TEARDOWN_POLICY_UNKNOWN
     TEARDOWN_ALWAYS
     TEARDOWN_ON_SUCCESS
     TEARDOWN_NEVER],
    :autoscalingSettings
    {:algorithm
     [AUTOSCALING_ALGORITHM_UNKNOWN
      AUTOSCALING_ALGORITHM_NONE
      AUTOSCALING_ALGORITHM_BASIC],
     :maxNumWorkers integer},
    :metadata object,
    :subnetwork string}],
  :dataset string},
 :projectId string,
 :requestedState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :location string,
 :runtimeUpdatableParams
 {:maxNumWorkers integer,
  :minNumWorkers integer,
  :workerUtilizationHint number}}

optional:
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job.
updateMask <string> The list of fields to update relative to Job. If empty, only RequestedJobState will be considered for update. If the FieldMask is not empty and RequestedJobState is none/empty, The fields specified in the update mask will be the only ones considered for update. If both RequestedJobState and update_mask are specified, an error will be returned as we cannot update both state and mask."
  ([projectId jobId Job]
    (projects-jobs-update projectId jobId Job nil))
  ([projectId jobId Job optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}",
       :uri-template-args {:projectId projectId, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"],
       :body Job})))

(defn projects-jobs-list
  "List the jobs of a project. To list the jobs of a project in a region, we recommend using `projects.locations.jobs.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To list the all jobs across all regions, use `projects.jobs.aggregated`. Using `projects.jobs.list` is not recommended, because you can only get the list of jobs that are running in `us-central1`. `projects.locations.jobs.list` and `projects.jobs.list` support filtering the list of jobs by name. Filtering by name isn't supported by `projects.jobs.aggregated`.
https://cloud.google.com/dataflow

projectId <string> The project which owns the jobs.

optional:
filter <string> The kind of filter to use.
view <string> Deprecated. ListJobs always returns summaries now. Use GetJob for other JobViews.
pageSize <integer> If there are many jobs, limit response to at most this many. The actual number of jobs returned will be the lesser of max_responses and an unspecified server-defined limit.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job.
name <string> Optional. The job name."
  ([projectId] (projects-jobs-list projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-jobs-aggregated
  "List the jobs of a project across all regions. **Note:** This method doesn't support filtering the list of jobs by name.
https://cloud.google.com/dataflow

projectId <string> The project which owns the jobs.

optional:
filter <string> The kind of filter to use.
view <string> Deprecated. ListJobs always returns summaries now. Use GetJob for other JobViews.
pageSize <integer> If there are many jobs, limit response to at most this many. The actual number of jobs returned will be the lesser of max_responses and an unspecified server-defined limit.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job.
name <string> Optional. The job name."
  ([projectId] (projects-jobs-aggregated projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs:aggregated",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-jobs-snapshot
  "Snapshot the state of a streaming job.
https://cloud.google.com/dataflow

projectId <string> The project which owns the job to be snapshotted.
jobId <string> The job to be snapshotted.
SnapshotJobRequest:
{:ttl string,
 :location string,
 :snapshotSources boolean,
 :description string}"
  [projectId jobId SnapshotJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}:snapshot",
     :uri-template-args {:projectId projectId, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body SnapshotJobRequest}))

(defn projects-jobs-getMetrics
  "Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.getMetrics` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.getMetrics` is not recommended, as you can only request the status of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> A project id.
jobId <string> The job to get metrics for.

optional:
startTime <string> Return only metric data that has changed since this time. Default is to return all information about all metrics for the job.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id."
  ([projectId jobId] (projects-jobs-getMetrics projectId jobId nil))
  ([projectId jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}/metrics",
       :uri-template-args {:projectId projectId, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-jobs-debug-getConfig
  "Get encoded debug configuration for component. Not cacheable.
https://cloud.google.com/dataflow

projectId <string> The project id.
jobId <string> The job id.
GetDebugConfigRequest:
{:workerId string, :componentId string, :location string}"
  [projectId jobId GetDebugConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}/debug/getConfig",
     :uri-template-args {:projectId projectId, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body GetDebugConfigRequest}))

(defn projects-jobs-debug-sendCapture
  "Send encoded debug capture data for component.
https://cloud.google.com/dataflow

projectId <string> The project id.
jobId <string> The job id.
SendDebugCaptureRequest:
{:workerId string,
 :componentId string,
 :data string,
 :dataFormat [DATA_FORMAT_UNSPECIFIED RAW JSON ZLIB BROTLI],
 :location string}"
  [projectId jobId SendDebugCaptureRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}/debug/sendCapture",
     :uri-template-args {:projectId projectId, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body SendDebugCaptureRequest}))

(defn projects-jobs-messages-list
  "Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.messages.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.messages.list` is not recommended, as you can only request the status of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> A project id.
jobId <string> The job to get messages about.

optional:
minimumImportance <string> Filter to only get messages with importance >= level
pageSize <integer> If specified, determines the maximum number of messages to return. If unspecified, the service may choose an appropriate default, or may return an arbitrarily large number of results.
startTime <string> If specified, return only messages with timestamps >= start_time. The default is the job creation time (i.e. beginning of messages).
endTime <string> Return only messages with timestamps < end_time. The default is now (i.e. return up to the latest messages available).
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id."
  ([projectId jobId] (projects-jobs-messages-list projectId jobId nil))
  ([projectId jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}/messages",
       :uri-template-args {:projectId projectId, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-jobs-workItems-reportStatus
  "Reports the status of dataflow WorkItems leased by a worker.
https://cloud.google.com/dataflow

projectId <string> The project which owns the WorkItem's job.
jobId <string> The job which the WorkItem is part of.
ReportWorkItemStatusRequest:
{:workerId string,
 :workItemStatuses
 [{:stopPosition
   {:end boolean,
    :key string,
    :byteOffset string,
    :recordIndex string,
    :shufflePosition string,
    :concatPosition
    {:index integer,
     :position
     {:end boolean,
      :key string,
      :byteOffset string,
      :recordIndex string,
      :shufflePosition string,
      :concatPosition ConcatPosition}}},
   :sourceFork
   {:primary
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :residual
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :primarySource
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :residualSource
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}},
   :sourceOperationResponse
   {:split
    {:outcome
     [SOURCE_SPLIT_OUTCOME_UNKNOWN
      SOURCE_SPLIT_OUTCOME_USE_CURRENT
      SOURCE_SPLIT_OUTCOME_SPLITTING_HAPPENED],
     :bundles
     [{:source Source,
       :derivationMode
       [SOURCE_DERIVATION_MODE_UNKNOWN
        SOURCE_DERIVATION_MODE_INDEPENDENT
        SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
        SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}],
     :shards
     [{:source Source,
       :derivationMode
       [SOURCE_DERIVATION_MODE_UNKNOWN
        SOURCE_DERIVATION_MODE_INDEPENDENT
        SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
        SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}]},
    :getMetadata
    {:metadata
     {:producesSortedKeys boolean,
      :infinite boolean,
      :estimatedSizeBytes string}}},
   :errors [{:code integer, :message string, :details [object]}],
   :reportedProgress
   {:position
    {:end boolean,
     :key string,
     :byteOffset string,
     :recordIndex string,
     :shufflePosition string,
     :concatPosition {:index integer, :position Position}},
    :fractionConsumed number,
    :remainingParallelism {:isInfinite boolean, :value number},
    :consumedParallelism {:isInfinite boolean, :value number}},
   :completed boolean,
   :workItemId string,
   :reportIndex string,
   :totalThrottlerWaitTimeSeconds number,
   :metricUpdates
   [{:cumulative boolean,
     :gauge any,
     :name {:origin string, :name string, :context object},
     :internal any,
     :updateTime string,
     :scalar any,
     :kind string,
     :distribution any,
     :set any,
     :meanSum any,
     :meanCount any}],
   :progress
   {:position
    {:end boolean,
     :key string,
     :byteOffset string,
     :recordIndex string,
     :shufflePosition string,
     :concatPosition {:index integer, :position Position}},
    :percentComplete number,
    :remainingTime string},
   :dynamicSourceSplit
   {:primary
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :residual
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}},
   :counterUpdates
   [{:integerMean
     {:sum {:lowBits integer, :highBits integer},
      :count {:lowBits integer, :highBits integer}},
     :nameAndKind
     {:name string,
      :kind
      [INVALID SUM MAX MIN MEAN OR AND SET DISTRIBUTION LATEST_VALUE]},
     :floatingPoint number,
     :cumulative boolean,
     :structuredNameAndMetadata
     {:name
      {:originalRequestingStepName string,
       :inputIndex integer,
       :name string,
       :executionStepName string,
       :workerId string,
       :origin [SYSTEM USER],
       :originNamespace string,
       :componentStepName string,
       :portion [ALL KEY VALUE],
       :originalStepName string},
      :metadata
      {:kind
       [INVALID SUM MAX MIN MEAN OR AND SET DISTRIBUTION LATEST_VALUE],
       :description string,
       :standardUnits
       [BYTES
        BYTES_PER_SEC
        MILLISECONDS
        MICROSECONDS
        NANOSECONDS
        TIMESTAMP_MSEC
        TIMESTAMP_USEC
        TIMESTAMP_NSEC],
       :otherUnits string}},
     :integerGauge
     {:value {:lowBits integer, :highBits integer}, :timestamp string},
     :shortId string,
     :floatingPointList {:elements [number]},
     :internal any,
     :integer {:lowBits integer, :highBits integer},
     :stringList {:elements [string]},
     :integerList {:elements [{:lowBits integer, :highBits integer}]},
     :distribution
     {:min {:lowBits integer, :highBits integer},
      :max {:lowBits integer, :highBits integer},
      :count {:lowBits integer, :highBits integer},
      :sum {:lowBits integer, :highBits integer},
      :sumOfSquares number,
      :histogram {:bucketCounts [string], :firstBucketOffset integer}},
     :floatingPointMean
     {:sum number, :count {:lowBits integer, :highBits integer}},
     :boolean boolean}],
   :requestedLeaseDuration string}],
 :currentWorkerTime string,
 :location string,
 :unifiedWorkerRequest object}"
  [projectId jobId ReportWorkItemStatusRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}/workItems:reportStatus",
     :uri-template-args {:projectId projectId, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body ReportWorkItemStatusRequest}))

(defn projects-jobs-workItems-lease
  "Leases a dataflow WorkItem to run.
https://cloud.google.com/dataflow

projectId <string> Identifies the project this worker belongs to.
jobId <string> Identifies the workflow job this worker belongs to.
LeaseWorkItemRequest:
{:workItemTypes [string],
 :workerCapabilities [string],
 :requestedLeaseDuration string,
 :currentWorkerTime string,
 :workerId string,
 :location string,
 :unifiedWorkerRequest object}"
  [projectId jobId LeaseWorkItemRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/jobs/{jobId}/workItems:lease",
     :uri-template-args {:projectId projectId, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body LeaseWorkItemRequest}))

(defn projects-templates-create
  "Creates a Cloud Dataflow job from a template. Do not enter confidential information when you supply string values using the API.
https://cloud.google.com/dataflow

projectId <string> Required. The ID of the Cloud Platform project that the job belongs to.
CreateJobFromTemplateRequest:
{:jobName string,
 :gcsPath string,
 :parameters object,
 :environment
 {:maxWorkers integer,
  :workerRegion string,
  :additionalExperiments [string],
  :zone string,
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :machineType string,
  :tempLocation string,
  :numWorkers integer,
  :serviceAccountEmail string,
  :bypassTempDirValidation boolean,
  :ipConfiguration
  [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
  :kmsKeyName string,
  :enableStreamingEngine boolean,
  :diskSizeGb integer,
  :network string,
  :workerZone string,
  :additionalUserLabels object,
  :subnetwork string},
 :location string}"
  [projectId CreateJobFromTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/templates",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body CreateJobFromTemplateRequest}))

(defn projects-templates-launch
  "Launch a template.
https://cloud.google.com/dataflow

projectId <string> Required. The ID of the Cloud Platform project that the job belongs to.
LaunchTemplateParameters:
{:jobName string,
 :parameters object,
 :environment
 {:maxWorkers integer,
  :workerRegion string,
  :additionalExperiments [string],
  :zone string,
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :machineType string,
  :tempLocation string,
  :numWorkers integer,
  :serviceAccountEmail string,
  :bypassTempDirValidation boolean,
  :ipConfiguration
  [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
  :kmsKeyName string,
  :enableStreamingEngine boolean,
  :diskSizeGb integer,
  :network string,
  :workerZone string,
  :additionalUserLabels object,
  :subnetwork string},
 :update boolean,
 :transformNameMapping object}

optional:
validateOnly <boolean> If true, the request is validated but not actually executed. Defaults to false.
gcsPath <string> A Cloud Storage path to the template to use to create the job. Must be valid Cloud Storage URL, beginning with `gs://`.
dynamicTemplate.gcsPath <string> Path to the dynamic template specification file on Cloud Storage. The file must be a JSON serialized `DynamicTemplateFileSpec` object.
dynamicTemplate.stagingLocation <string> Cloud Storage path for staging dependencies. Must be a valid Cloud Storage URL, beginning with `gs://`.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) to which to direct the request."
  ([projectId LaunchTemplateParameters]
    (projects-templates-launch projectId LaunchTemplateParameters nil))
  ([projectId LaunchTemplateParameters optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/templates:launch",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"],
       :body LaunchTemplateParameters})))

(defn projects-templates-get
  "Get the template associated with a template.
https://cloud.google.com/dataflow

projectId <string> Required. The ID of the Cloud Platform project that the job belongs to.

optional:
gcsPath <string> Required. A Cloud Storage path to the template from which to create the job. Must be valid Cloud Storage URL, beginning with 'gs://'.
view <string> The view to retrieve. Defaults to METADATA_ONLY.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) to which to direct the request."
  ([projectId] (projects-templates-get projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/templates:get",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-workerMessages
  "Send a worker_message to the service.
https://cloud.google.com/dataflow

projectId <string> The project to send the WorkerMessages to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job.
SendWorkerMessagesRequest:
{:workerMessages
 [{:labels object,
   :streamingScalingReport
   {:maximumBytesCount integer,
    :outstandingBytesCount integer,
    :maximumThreadCount integer,
    :activeBundleCount integer,
    :activeThreadCount integer,
    :outstandingBundleCount integer,
    :maximumBytes string,
    :maximumBundleCount integer,
    :outstandingBytes string},
   :workerHealthReport
   {:vmIsHealthy boolean,
    :vmIsBroken boolean,
    :vmBrokenCode string,
    :msg string,
    :vmStartupTime string,
    :reportInterval string,
    :pods [object]},
   :workerShutdownNotice {:reason string},
   :time string,
   :workerThreadScalingReport {:currentThreadCount integer},
   :workerLifecycleEvent
   {:event
    [UNKNOWN_EVENT
     OS_START
     CONTAINER_START
     NETWORK_UP
     STAGING_FILES_DOWNLOAD_START
     STAGING_FILES_DOWNLOAD_FINISH
     SDK_INSTALL_START
     SDK_INSTALL_FINISH],
    :metadata object,
    :containerStartTime string},
   :perWorkerMetrics
   {:perStepNamespaceMetrics
    [{:metricsNamespace string,
      :originalStep string,
      :metricValues
      [{:metric string,
        :metricLabels object,
        :valueInt64 string,
        :valueHistogram DataflowHistogramValue}]}]},
   :dataSamplingReport
   {:elementsSampledBytes string,
    :elementsSampledCount string,
    :pcollectionsSampledCount string,
    :exceptionsSampledCount string,
    :bytesWrittenDelta string,
    :translationErrorsCount string,
    :persistenceErrorsCount string},
   :workerMessageCode {:code string, :parameters object},
   :workerMetrics
   {:cpuTime [{:timestamp string, :totalMs string, :rate number}],
    :memoryInfo
    [{:timestamp string,
      :totalGbMs string,
      :currentRssBytes string,
      :currentLimitBytes string,
      :currentOoms string}],
    :containers object}}],
 :location string}"
  [projectId location SendWorkerMessagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/WorkerMessages",
     :uri-template-args {:projectId projectId, :location location},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body SendWorkerMessagesRequest}))

(defn projects-locations-snapshots-get
  "Gets information about a snapshot.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the snapshot belongs to.
location <string> The location that contains this snapshot.
snapshotId <string> The ID of the snapshot."
  [projectId location snapshotId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/snapshots/{snapshotId}",
     :uri-template-args
     {:projectId projectId,
      :location location,
      :snapshotId snapshotId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"]}))

(defn projects-locations-snapshots-delete
  "Deletes a snapshot.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the snapshot belongs to.
location <string> The location that contains this snapshot.
snapshotId <string> The ID of the snapshot."
  [projectId location snapshotId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/snapshots/{snapshotId}",
     :uri-template-args
     {:projectId projectId,
      :location location,
      :snapshotId snapshotId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"]}))

(defn projects-locations-snapshots-list
  "Lists snapshots.
https://cloud.google.com/dataflow

projectId <string> The project ID to list snapshots for.
location <string> The location to list snapshots in.

optional:
jobId <string> If specified, list snapshots created from this job."
  ([projectId location]
    (projects-locations-snapshots-list projectId location nil))
  ([projectId location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/snapshots",
       :uri-template-args {:projectId projectId, :location location},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-jobs-create
  "Creates a Cloud Dataflow job. To create a job, we recommend using `projects.locations.jobs.create` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.create` is not recommended, as your job will always start in `us-central1`. Do not enter confidential information when you supply string values using the API.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the job belongs to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job.
Job:
{:labels object,
 :stepsLocation string,
 :executionInfo {:stages object},
 :jobMetadata
 {:sdkVersion
  {:version string,
   :versionDisplayName string,
   :sdkSupportStatus [UNKNOWN SUPPORTED STALE DEPRECATED UNSUPPORTED],
   :bugs
   [{:type [TYPE_UNSPECIFIED GENERAL PERFORMANCE DATALOSS],
     :severity [SEVERITY_UNSPECIFIED NOTICE WARNING SEVERE],
     :uri string}]},
  :spannerDetails
  [{:projectId string, :instanceId string, :databaseId string}],
  :bigqueryDetails
  [{:table string, :dataset string, :projectId string, :query string}],
  :bigTableDetails
  [{:projectId string, :instanceId string, :tableId string}],
  :pubsubDetails [{:topic string, :subscription string}],
  :fileDetails [{:filePattern string}],
  :datastoreDetails [{:namespace string, :projectId string}],
  :userDisplayProperties object},
 :clientRequestId string,
 :startTime string,
 :satisfiesPzi boolean,
 :stageStates
 [{:executionStageName string,
   :executionStageState
   [JOB_STATE_UNKNOWN
    JOB_STATE_STOPPED
    JOB_STATE_RUNNING
    JOB_STATE_DONE
    JOB_STATE_FAILED
    JOB_STATE_CANCELLED
    JOB_STATE_UPDATED
    JOB_STATE_DRAINING
    JOB_STATE_DRAINED
    JOB_STATE_PENDING
    JOB_STATE_CANCELLING
    JOB_STATE_QUEUED
    JOB_STATE_RESOURCE_CLEANING_UP],
   :currentStateTime string}],
 :name string,
 :steps [{:kind string, :name string, :properties object}],
 :createTime string,
 :currentStateTime string,
 :type [JOB_TYPE_UNKNOWN JOB_TYPE_BATCH JOB_TYPE_STREAMING],
 :transformNameMapping object,
 :replaceJobId string,
 :pipelineDescription
 {:originalPipelineTransform
  [{:kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :id string,
    :name string,
    :displayData
    [{:durationValue string,
      :key string,
      :int64Value string,
      :strValue string,
      :javaClassValue string,
      :label string,
      :floatValue number,
      :timestampValue string,
      :url string,
      :shortStrValue string,
      :namespace string,
      :boolValue boolean}],
    :outputCollectionName [string],
    :inputCollectionName [string]}],
  :executionPipelineStage
  [{:name string,
    :id string,
    :kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :inputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :outputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :prerequisiteStage [string],
    :componentTransform
    [{:userName string, :name string, :originalTransform string}],
    :componentSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string}]}],
  :displayData
  [{:durationValue string,
    :key string,
    :int64Value string,
    :strValue string,
    :javaClassValue string,
    :label string,
    :floatValue number,
    :timestampValue string,
    :url string,
    :shortStrValue string,
    :namespace string,
    :boolValue boolean}],
  :stepNamesHash string},
 :replacedByJobId string,
 :satisfiesPzs boolean,
 :currentState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :tempFiles [string],
 :id string,
 :createdFromSnapshotId string,
 :environment
 {:flexResourceSchedulingGoal
  [FLEXRS_UNSPECIFIED FLEXRS_SPEED_OPTIMIZED FLEXRS_COST_OPTIMIZED],
  :internalExperiments object,
  :experiments [string],
  :workerRegion string,
  :shuffleMode [SHUFFLE_MODE_UNSPECIFIED VM_BASED SERVICE_BASED],
  :debugOptions
  {:enableHotKeyLogging boolean,
   :dataSampling
   {:behaviors
    [[DATA_SAMPLING_BEHAVIOR_UNSPECIFIED
      DISABLED
      ALWAYS_ON
      EXCEPTIONS]]}},
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :sdkPipelineOptions object,
  :useStreamingEngineResourceBasedBilling boolean,
  :serviceKmsKeyName string,
  :tempStoragePrefix string,
  :serviceAccountEmail string,
  :clusterManagerApiService string,
  :userAgent object,
  :serviceOptions [string],
  :workerZone string,
  :version object,
  :workerPools
  [{:sdkHarnessContainerImages
    [{:containerImage string,
      :useSingleCorePerContainer boolean,
      :environmentId string,
      :capabilities [string]}],
    :diskSourceImage string,
    :zone string,
    :workerHarnessContainerImage string,
    :poolArgs object,
    :machineType string,
    :defaultPackageSet
    [DEFAULT_PACKAGE_SET_UNKNOWN
     DEFAULT_PACKAGE_SET_NONE
     DEFAULT_PACKAGE_SET_JAVA
     DEFAULT_PACKAGE_SET_PYTHON],
    :onHostMaintenance string,
    :dataDisks
    [{:sizeGb integer, :diskType string, :mountPoint string}],
    :numWorkers integer,
    :numThreadsPerWorker integer,
    :diskType string,
    :ipConfiguration
    [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
    :kind string,
    :taskrunnerSettings
    {:logToSerialconsole boolean,
     :continueOnException boolean,
     :logDir string,
     :commandlinesFileName string,
     :alsologtostderr boolean,
     :streamingWorkerMainClass string,
     :taskGroup string,
     :baseUrl string,
     :tempStoragePrefix string,
     :vmId string,
     :baseTaskDir string,
     :oauthScopes [string],
     :logUploadLocation string,
     :taskUser string,
     :languageHint string,
     :parallelWorkerSettings
     {:baseUrl string,
      :reportingEnabled boolean,
      :servicePath string,
      :shuffleServicePath string,
      :workerId string,
      :tempStoragePrefix string},
     :dataflowApiVersion string,
     :harnessCommand string,
     :workflowFileName string},
    :packages [{:name string, :location string}],
    :diskSizeGb integer,
    :network string,
    :teardownPolicy
    [TEARDOWN_POLICY_UNKNOWN
     TEARDOWN_ALWAYS
     TEARDOWN_ON_SUCCESS
     TEARDOWN_NEVER],
    :autoscalingSettings
    {:algorithm
     [AUTOSCALING_ALGORITHM_UNKNOWN
      AUTOSCALING_ALGORITHM_NONE
      AUTOSCALING_ALGORITHM_BASIC],
     :maxNumWorkers integer},
    :metadata object,
    :subnetwork string}],
  :dataset string},
 :projectId string,
 :requestedState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :location string,
 :runtimeUpdatableParams
 {:maxNumWorkers integer,
  :minNumWorkers integer,
  :workerUtilizationHint number}}

optional:
view <string> The level of information requested in response.
replaceJobId <string> Deprecated. This field is now in the Job message."
  ([projectId location Job]
    (projects-locations-jobs-create projectId location Job nil))
  ([projectId location Job optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs",
       :uri-template-args {:projectId projectId, :location location},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"],
       :body Job})))

(defn projects-locations-jobs-get
  "Gets the state of the specified Cloud Dataflow job. To get the state of a job, we recommend using `projects.locations.jobs.get` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.get` is not recommended, as you can only get the state of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the job belongs to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job.
jobId <string> The job ID.

optional:
view <string> The level of information requested in response."
  ([projectId location jobId]
    (projects-locations-jobs-get projectId location jobId nil))
  ([projectId location jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}",
       :uri-template-args
       {:projectId projectId, :location location, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-jobs-update
  "Updates the state of an existing Cloud Dataflow job. To update the state of an existing job, we recommend using `projects.locations.jobs.update` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.update` is not recommended, as you can only update the state of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> The ID of the Cloud Platform project that the job belongs to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job.
jobId <string> The job ID.
Job:
{:labels object,
 :stepsLocation string,
 :executionInfo {:stages object},
 :jobMetadata
 {:sdkVersion
  {:version string,
   :versionDisplayName string,
   :sdkSupportStatus [UNKNOWN SUPPORTED STALE DEPRECATED UNSUPPORTED],
   :bugs
   [{:type [TYPE_UNSPECIFIED GENERAL PERFORMANCE DATALOSS],
     :severity [SEVERITY_UNSPECIFIED NOTICE WARNING SEVERE],
     :uri string}]},
  :spannerDetails
  [{:projectId string, :instanceId string, :databaseId string}],
  :bigqueryDetails
  [{:table string, :dataset string, :projectId string, :query string}],
  :bigTableDetails
  [{:projectId string, :instanceId string, :tableId string}],
  :pubsubDetails [{:topic string, :subscription string}],
  :fileDetails [{:filePattern string}],
  :datastoreDetails [{:namespace string, :projectId string}],
  :userDisplayProperties object},
 :clientRequestId string,
 :startTime string,
 :satisfiesPzi boolean,
 :stageStates
 [{:executionStageName string,
   :executionStageState
   [JOB_STATE_UNKNOWN
    JOB_STATE_STOPPED
    JOB_STATE_RUNNING
    JOB_STATE_DONE
    JOB_STATE_FAILED
    JOB_STATE_CANCELLED
    JOB_STATE_UPDATED
    JOB_STATE_DRAINING
    JOB_STATE_DRAINED
    JOB_STATE_PENDING
    JOB_STATE_CANCELLING
    JOB_STATE_QUEUED
    JOB_STATE_RESOURCE_CLEANING_UP],
   :currentStateTime string}],
 :name string,
 :steps [{:kind string, :name string, :properties object}],
 :createTime string,
 :currentStateTime string,
 :type [JOB_TYPE_UNKNOWN JOB_TYPE_BATCH JOB_TYPE_STREAMING],
 :transformNameMapping object,
 :replaceJobId string,
 :pipelineDescription
 {:originalPipelineTransform
  [{:kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :id string,
    :name string,
    :displayData
    [{:durationValue string,
      :key string,
      :int64Value string,
      :strValue string,
      :javaClassValue string,
      :label string,
      :floatValue number,
      :timestampValue string,
      :url string,
      :shortStrValue string,
      :namespace string,
      :boolValue boolean}],
    :outputCollectionName [string],
    :inputCollectionName [string]}],
  :executionPipelineStage
  [{:name string,
    :id string,
    :kind
    [UNKNOWN_KIND
     PAR_DO_KIND
     GROUP_BY_KEY_KIND
     FLATTEN_KIND
     READ_KIND
     WRITE_KIND
     CONSTANT_KIND
     SINGLETON_KIND
     SHUFFLE_KIND],
    :inputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :outputSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string,
      :sizeBytes string}],
    :prerequisiteStage [string],
    :componentTransform
    [{:userName string, :name string, :originalTransform string}],
    :componentSource
    [{:userName string,
      :name string,
      :originalTransformOrCollection string}]}],
  :displayData
  [{:durationValue string,
    :key string,
    :int64Value string,
    :strValue string,
    :javaClassValue string,
    :label string,
    :floatValue number,
    :timestampValue string,
    :url string,
    :shortStrValue string,
    :namespace string,
    :boolValue boolean}],
  :stepNamesHash string},
 :replacedByJobId string,
 :satisfiesPzs boolean,
 :currentState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :tempFiles [string],
 :id string,
 :createdFromSnapshotId string,
 :environment
 {:flexResourceSchedulingGoal
  [FLEXRS_UNSPECIFIED FLEXRS_SPEED_OPTIMIZED FLEXRS_COST_OPTIMIZED],
  :internalExperiments object,
  :experiments [string],
  :workerRegion string,
  :shuffleMode [SHUFFLE_MODE_UNSPECIFIED VM_BASED SERVICE_BASED],
  :debugOptions
  {:enableHotKeyLogging boolean,
   :dataSampling
   {:behaviors
    [[DATA_SAMPLING_BEHAVIOR_UNSPECIFIED
      DISABLED
      ALWAYS_ON
      EXCEPTIONS]]}},
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :sdkPipelineOptions object,
  :useStreamingEngineResourceBasedBilling boolean,
  :serviceKmsKeyName string,
  :tempStoragePrefix string,
  :serviceAccountEmail string,
  :clusterManagerApiService string,
  :userAgent object,
  :serviceOptions [string],
  :workerZone string,
  :version object,
  :workerPools
  [{:sdkHarnessContainerImages
    [{:containerImage string,
      :useSingleCorePerContainer boolean,
      :environmentId string,
      :capabilities [string]}],
    :diskSourceImage string,
    :zone string,
    :workerHarnessContainerImage string,
    :poolArgs object,
    :machineType string,
    :defaultPackageSet
    [DEFAULT_PACKAGE_SET_UNKNOWN
     DEFAULT_PACKAGE_SET_NONE
     DEFAULT_PACKAGE_SET_JAVA
     DEFAULT_PACKAGE_SET_PYTHON],
    :onHostMaintenance string,
    :dataDisks
    [{:sizeGb integer, :diskType string, :mountPoint string}],
    :numWorkers integer,
    :numThreadsPerWorker integer,
    :diskType string,
    :ipConfiguration
    [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
    :kind string,
    :taskrunnerSettings
    {:logToSerialconsole boolean,
     :continueOnException boolean,
     :logDir string,
     :commandlinesFileName string,
     :alsologtostderr boolean,
     :streamingWorkerMainClass string,
     :taskGroup string,
     :baseUrl string,
     :tempStoragePrefix string,
     :vmId string,
     :baseTaskDir string,
     :oauthScopes [string],
     :logUploadLocation string,
     :taskUser string,
     :languageHint string,
     :parallelWorkerSettings
     {:baseUrl string,
      :reportingEnabled boolean,
      :servicePath string,
      :shuffleServicePath string,
      :workerId string,
      :tempStoragePrefix string},
     :dataflowApiVersion string,
     :harnessCommand string,
     :workflowFileName string},
    :packages [{:name string, :location string}],
    :diskSizeGb integer,
    :network string,
    :teardownPolicy
    [TEARDOWN_POLICY_UNKNOWN
     TEARDOWN_ALWAYS
     TEARDOWN_ON_SUCCESS
     TEARDOWN_NEVER],
    :autoscalingSettings
    {:algorithm
     [AUTOSCALING_ALGORITHM_UNKNOWN
      AUTOSCALING_ALGORITHM_NONE
      AUTOSCALING_ALGORITHM_BASIC],
     :maxNumWorkers integer},
    :metadata object,
    :subnetwork string}],
  :dataset string},
 :projectId string,
 :requestedState
 [JOB_STATE_UNKNOWN
  JOB_STATE_STOPPED
  JOB_STATE_RUNNING
  JOB_STATE_DONE
  JOB_STATE_FAILED
  JOB_STATE_CANCELLED
  JOB_STATE_UPDATED
  JOB_STATE_DRAINING
  JOB_STATE_DRAINED
  JOB_STATE_PENDING
  JOB_STATE_CANCELLING
  JOB_STATE_QUEUED
  JOB_STATE_RESOURCE_CLEANING_UP],
 :location string,
 :runtimeUpdatableParams
 {:maxNumWorkers integer,
  :minNumWorkers integer,
  :workerUtilizationHint number}}

optional:
updateMask <string> The list of fields to update relative to Job. If empty, only RequestedJobState will be considered for update. If the FieldMask is not empty and RequestedJobState is none/empty, The fields specified in the update mask will be the only ones considered for update. If both RequestedJobState and update_mask are specified, an error will be returned as we cannot update both state and mask."
  ([projectId location jobId Job]
    (projects-locations-jobs-update projectId location jobId Job nil))
  ([projectId location jobId Job optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}",
       :uri-template-args
       {:projectId projectId, :location location, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"],
       :body Job})))

(defn projects-locations-jobs-list
  "List the jobs of a project. To list the jobs of a project in a region, we recommend using `projects.locations.jobs.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To list the all jobs across all regions, use `projects.jobs.aggregated`. Using `projects.jobs.list` is not recommended, because you can only get the list of jobs that are running in `us-central1`. `projects.locations.jobs.list` and `projects.jobs.list` support filtering the list of jobs by name. Filtering by name isn't supported by `projects.jobs.aggregated`.
https://cloud.google.com/dataflow

projectId <string> The project which owns the jobs.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains this job.

optional:
filter <string> The kind of filter to use.
view <string> Deprecated. ListJobs always returns summaries now. Use GetJob for other JobViews.
pageSize <integer> If there are many jobs, limit response to at most this many. The actual number of jobs returned will be the lesser of max_responses and an unspecified server-defined limit.
name <string> Optional. The job name."
  ([projectId location]
    (projects-locations-jobs-list projectId location nil))
  ([projectId location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs",
       :uri-template-args {:projectId projectId, :location location},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-jobs-snapshot
  "Snapshot the state of a streaming job.
https://cloud.google.com/dataflow

projectId <string> The project which owns the job to be snapshotted.
location <string> The location that contains this job.
jobId <string> The job to be snapshotted.
SnapshotJobRequest:
{:ttl string,
 :location string,
 :snapshotSources boolean,
 :description string}"
  [projectId location jobId SnapshotJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}:snapshot",
     :uri-template-args
     {:projectId projectId, :location location, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body SnapshotJobRequest}))

(defn projects-locations-jobs-getMetrics
  "Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.getMetrics` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.getMetrics` is not recommended, as you can only request the status of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> A project id.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id.
jobId <string> The job to get metrics for.

optional:
startTime <string> Return only metric data that has changed since this time. Default is to return all information about all metrics for the job."
  ([projectId location jobId]
    (projects-locations-jobs-getMetrics projectId location jobId nil))
  ([projectId location jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/metrics",
       :uri-template-args
       {:projectId projectId, :location location, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-jobs-getExecutionDetails
  "Request detailed information about the execution status of the job. EXPERIMENTAL. This API is subject to change or removal without notice.
https://cloud.google.com/dataflow

projectId <string> A project id.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id.
jobId <string> The job to get execution details for.

optional:
pageSize <integer> If specified, determines the maximum number of stages to return. If unspecified, the service may choose an appropriate default, or may return an arbitrarily large number of results."
  ([projectId location jobId]
    (projects-locations-jobs-getExecutionDetails
      projectId
      location
      jobId
      nil))
  ([projectId location jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/executionDetails",
       :uri-template-args
       {:projectId projectId, :location location, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-jobs-debug-getConfig
  "Get encoded debug configuration for component. Not cacheable.
https://cloud.google.com/dataflow

projectId <string> The project id.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id.
jobId <string> The job id.
GetDebugConfigRequest:
{:workerId string, :componentId string, :location string}"
  [projectId location jobId GetDebugConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/debug/getConfig",
     :uri-template-args
     {:projectId projectId, :location location, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body GetDebugConfigRequest}))

(defn projects-locations-jobs-debug-sendCapture
  "Send encoded debug capture data for component.
https://cloud.google.com/dataflow

projectId <string> The project id.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id.
jobId <string> The job id.
SendDebugCaptureRequest:
{:workerId string,
 :componentId string,
 :data string,
 :dataFormat [DATA_FORMAT_UNSPECIFIED RAW JSON ZLIB BROTLI],
 :location string}"
  [projectId location jobId SendDebugCaptureRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/debug/sendCapture",
     :uri-template-args
     {:projectId projectId, :location location, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body SendDebugCaptureRequest}))

(defn projects-locations-jobs-snapshots-list
  "Lists snapshots.
https://cloud.google.com/dataflow

projectId <string> The project ID to list snapshots for.
location <string> The location to list snapshots in.
jobId <string> If specified, list snapshots created from this job."
  [projectId location jobId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/snapshots",
     :uri-template-args
     {:projectId projectId, :location location, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"]}))

(defn projects-locations-jobs-messages-list
  "Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.messages.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.messages.list` is not recommended, as you can only request the status of jobs that are running in `us-central1`.
https://cloud.google.com/dataflow

projectId <string> A project id.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id.
jobId <string> The job to get messages about.

optional:
minimumImportance <string> Filter to only get messages with importance >= level
pageSize <integer> If specified, determines the maximum number of messages to return. If unspecified, the service may choose an appropriate default, or may return an arbitrarily large number of results.
startTime <string> If specified, return only messages with timestamps >= start_time. The default is the job creation time (i.e. beginning of messages).
endTime <string> Return only messages with timestamps < end_time. The default is now (i.e. return up to the latest messages available)."
  ([projectId location jobId]
    (projects-locations-jobs-messages-list
      projectId
      location
      jobId
      nil))
  ([projectId location jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/messages",
       :uri-template-args
       {:projectId projectId, :location location, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-jobs-stages-getExecutionDetails
  "Request detailed information about the execution status of a stage of the job. EXPERIMENTAL. This API is subject to change or removal without notice.
https://cloud.google.com/dataflow

projectId <string> A project id.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the job specified by job_id.
jobId <string> The job to get execution details for.
stageId <string> The stage for which to fetch information.

optional:
pageSize <integer> If specified, determines the maximum number of work items to return. If unspecified, the service may choose an appropriate default, or may return an arbitrarily large number of results.
startTime <string> Lower time bound of work items to include, by start time.
endTime <string> Upper time bound of work items to include, by start time."
  ([projectId location jobId stageId]
    (projects-locations-jobs-stages-getExecutionDetails
      projectId
      location
      jobId
      stageId
      nil))
  ([projectId location jobId stageId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/stages/{stageId}/executionDetails",
       :uri-template-args
       {:projectId projectId,
        :location location,
        :jobId jobId,
        :stageId stageId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-jobs-workItems-reportStatus
  "Reports the status of dataflow WorkItems leased by a worker.
https://cloud.google.com/dataflow

projectId <string> The project which owns the WorkItem's job.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the WorkItem's job.
jobId <string> The job which the WorkItem is part of.
ReportWorkItemStatusRequest:
{:workerId string,
 :workItemStatuses
 [{:stopPosition
   {:end boolean,
    :key string,
    :byteOffset string,
    :recordIndex string,
    :shufflePosition string,
    :concatPosition
    {:index integer,
     :position
     {:end boolean,
      :key string,
      :byteOffset string,
      :recordIndex string,
      :shufflePosition string,
      :concatPosition ConcatPosition}}},
   :sourceFork
   {:primary
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :residual
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :primarySource
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :residualSource
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}},
   :sourceOperationResponse
   {:split
    {:outcome
     [SOURCE_SPLIT_OUTCOME_UNKNOWN
      SOURCE_SPLIT_OUTCOME_USE_CURRENT
      SOURCE_SPLIT_OUTCOME_SPLITTING_HAPPENED],
     :bundles
     [{:source Source,
       :derivationMode
       [SOURCE_DERIVATION_MODE_UNKNOWN
        SOURCE_DERIVATION_MODE_INDEPENDENT
        SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
        SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}],
     :shards
     [{:source Source,
       :derivationMode
       [SOURCE_DERIVATION_MODE_UNKNOWN
        SOURCE_DERIVATION_MODE_INDEPENDENT
        SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
        SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}]},
    :getMetadata
    {:metadata
     {:producesSortedKeys boolean,
      :infinite boolean,
      :estimatedSizeBytes string}}},
   :errors [{:code integer, :message string, :details [object]}],
   :reportedProgress
   {:position
    {:end boolean,
     :key string,
     :byteOffset string,
     :recordIndex string,
     :shufflePosition string,
     :concatPosition {:index integer, :position Position}},
    :fractionConsumed number,
    :remainingParallelism {:isInfinite boolean, :value number},
    :consumedParallelism {:isInfinite boolean, :value number}},
   :completed boolean,
   :workItemId string,
   :reportIndex string,
   :totalThrottlerWaitTimeSeconds number,
   :metricUpdates
   [{:cumulative boolean,
     :gauge any,
     :name {:origin string, :name string, :context object},
     :internal any,
     :updateTime string,
     :scalar any,
     :kind string,
     :distribution any,
     :set any,
     :meanSum any,
     :meanCount any}],
   :progress
   {:position
    {:end boolean,
     :key string,
     :byteOffset string,
     :recordIndex string,
     :shufflePosition string,
     :concatPosition {:index integer, :position Position}},
    :percentComplete number,
    :remainingTime string},
   :dynamicSourceSplit
   {:primary
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]},
    :residual
    {:source
     {:spec object,
      :codec object,
      :baseSpecs [object],
      :metadata SourceMetadata,
      :doesNotNeedSplitting boolean},
     :derivationMode
     [SOURCE_DERIVATION_MODE_UNKNOWN
      SOURCE_DERIVATION_MODE_INDEPENDENT
      SOURCE_DERIVATION_MODE_CHILD_OF_CURRENT
      SOURCE_DERIVATION_MODE_SIBLING_OF_CURRENT]}},
   :counterUpdates
   [{:integerMean
     {:sum {:lowBits integer, :highBits integer},
      :count {:lowBits integer, :highBits integer}},
     :nameAndKind
     {:name string,
      :kind
      [INVALID SUM MAX MIN MEAN OR AND SET DISTRIBUTION LATEST_VALUE]},
     :floatingPoint number,
     :cumulative boolean,
     :structuredNameAndMetadata
     {:name
      {:originalRequestingStepName string,
       :inputIndex integer,
       :name string,
       :executionStepName string,
       :workerId string,
       :origin [SYSTEM USER],
       :originNamespace string,
       :componentStepName string,
       :portion [ALL KEY VALUE],
       :originalStepName string},
      :metadata
      {:kind
       [INVALID SUM MAX MIN MEAN OR AND SET DISTRIBUTION LATEST_VALUE],
       :description string,
       :standardUnits
       [BYTES
        BYTES_PER_SEC
        MILLISECONDS
        MICROSECONDS
        NANOSECONDS
        TIMESTAMP_MSEC
        TIMESTAMP_USEC
        TIMESTAMP_NSEC],
       :otherUnits string}},
     :integerGauge
     {:value {:lowBits integer, :highBits integer}, :timestamp string},
     :shortId string,
     :floatingPointList {:elements [number]},
     :internal any,
     :integer {:lowBits integer, :highBits integer},
     :stringList {:elements [string]},
     :integerList {:elements [{:lowBits integer, :highBits integer}]},
     :distribution
     {:min {:lowBits integer, :highBits integer},
      :max {:lowBits integer, :highBits integer},
      :count {:lowBits integer, :highBits integer},
      :sum {:lowBits integer, :highBits integer},
      :sumOfSquares number,
      :histogram {:bucketCounts [string], :firstBucketOffset integer}},
     :floatingPointMean
     {:sum number, :count {:lowBits integer, :highBits integer}},
     :boolean boolean}],
   :requestedLeaseDuration string}],
 :currentWorkerTime string,
 :location string,
 :unifiedWorkerRequest object}"
  [projectId location jobId ReportWorkItemStatusRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/workItems:reportStatus",
     :uri-template-args
     {:projectId projectId, :location location, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body ReportWorkItemStatusRequest}))

(defn projects-locations-jobs-workItems-lease
  "Leases a dataflow WorkItem to run.
https://cloud.google.com/dataflow

projectId <string> Identifies the project this worker belongs to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) that contains the WorkItem's job.
jobId <string> Identifies the workflow job this worker belongs to.
LeaseWorkItemRequest:
{:workItemTypes [string],
 :workerCapabilities [string],
 :requestedLeaseDuration string,
 :currentWorkerTime string,
 :workerId string,
 :location string,
 :unifiedWorkerRequest object}"
  [projectId location jobId LeaseWorkItemRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/workItems:lease",
     :uri-template-args
     {:projectId projectId, :location location, :jobId jobId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body LeaseWorkItemRequest}))

(defn projects-locations-templates-create
  "Creates a Cloud Dataflow job from a template. Do not enter confidential information when you supply string values using the API.
https://cloud.google.com/dataflow

projectId <string> Required. The ID of the Cloud Platform project that the job belongs to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) to which to direct the request.
CreateJobFromTemplateRequest:
{:jobName string,
 :gcsPath string,
 :parameters object,
 :environment
 {:maxWorkers integer,
  :workerRegion string,
  :additionalExperiments [string],
  :zone string,
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :machineType string,
  :tempLocation string,
  :numWorkers integer,
  :serviceAccountEmail string,
  :bypassTempDirValidation boolean,
  :ipConfiguration
  [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
  :kmsKeyName string,
  :enableStreamingEngine boolean,
  :diskSizeGb integer,
  :network string,
  :workerZone string,
  :additionalUserLabels object,
  :subnetwork string},
 :location string}"
  [projectId location CreateJobFromTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/templates",
     :uri-template-args {:projectId projectId, :location location},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body CreateJobFromTemplateRequest}))

(defn projects-locations-templates-launch
  "Launch a template.
https://cloud.google.com/dataflow

projectId <string> Required. The ID of the Cloud Platform project that the job belongs to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) to which to direct the request.
LaunchTemplateParameters:
{:jobName string,
 :parameters object,
 :environment
 {:maxWorkers integer,
  :workerRegion string,
  :additionalExperiments [string],
  :zone string,
  :streamingMode
  [STREAMING_MODE_UNSPECIFIED
   STREAMING_MODE_EXACTLY_ONCE
   STREAMING_MODE_AT_LEAST_ONCE],
  :machineType string,
  :tempLocation string,
  :numWorkers integer,
  :serviceAccountEmail string,
  :bypassTempDirValidation boolean,
  :ipConfiguration
  [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
  :kmsKeyName string,
  :enableStreamingEngine boolean,
  :diskSizeGb integer,
  :network string,
  :workerZone string,
  :additionalUserLabels object,
  :subnetwork string},
 :update boolean,
 :transformNameMapping object}

optional:
validateOnly <boolean> If true, the request is validated but not actually executed. Defaults to false.
gcsPath <string> A Cloud Storage path to the template to use to create the job. Must be valid Cloud Storage URL, beginning with `gs://`.
dynamicTemplate.gcsPath <string> Path to the dynamic template specification file on Cloud Storage. The file must be a JSON serialized `DynamicTemplateFileSpec` object.
dynamicTemplate.stagingLocation <string> Cloud Storage path for staging dependencies. Must be a valid Cloud Storage URL, beginning with `gs://`."
  ([projectId location LaunchTemplateParameters]
    (projects-locations-templates-launch
      projectId
      location
      LaunchTemplateParameters
      nil))
  ([projectId location LaunchTemplateParameters optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/templates:launch",
       :uri-template-args {:projectId projectId, :location location},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"],
       :body LaunchTemplateParameters})))

(defn projects-locations-templates-get
  "Get the template associated with a template.
https://cloud.google.com/dataflow

projectId <string> Required. The ID of the Cloud Platform project that the job belongs to.
location <string> The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) to which to direct the request.

optional:
gcsPath <string> Required. A Cloud Storage path to the template from which to create the job. Must be valid Cloud Storage URL, beginning with 'gs://'.
view <string> The view to retrieve. Defaults to METADATA_ONLY."
  ([projectId location]
    (projects-locations-templates-get projectId location nil))
  ([projectId location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/templates:get",
       :uri-template-args {:projectId projectId, :location location},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/compute"
        "https://www.googleapis.com/auth/compute.readonly"]})))

(defn projects-locations-flexTemplates-launch
  "Launch a job with a FlexTemplate.
https://cloud.google.com/dataflow

projectId <string> Required. The ID of the Cloud Platform project that the job belongs to.
location <string> Required. The [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints) to which to direct the request. E.g., us-central1, us-west1.
LaunchFlexTemplateRequest:
{:launchParameter
 {:jobName string,
  :containerSpec
  {:image string,
   :metadata
   {:name string,
    :description string,
    :parameters
    [{:hiddenUi boolean,
      :name string,
      :paramType
      [DEFAULT
       TEXT
       GCS_READ_BUCKET
       GCS_WRITE_BUCKET
       GCS_READ_FILE
       GCS_WRITE_FILE
       GCS_READ_FOLDER
       GCS_WRITE_FOLDER
       PUBSUB_TOPIC
       PUBSUB_SUBSCRIPTION
       BIGQUERY_TABLE
       JAVASCRIPT_UDF_FILE
       SERVICE_ACCOUNT
       MACHINE_TYPE
       KMS_KEY_NAME
       WORKER_REGION
       WORKER_ZONE
       BOOLEAN
       ENUM
       NUMBER
       KAFKA_TOPIC
       KAFKA_READ_TOPIC
       KAFKA_WRITE_TOPIC],
      :groupName string,
      :parentName string,
      :customMetadata object,
      :helpText string,
      :label string,
      :isOptional boolean,
      :defaultValue string,
      :enumOptions [ParameterMetadataEnumOption],
      :regexes [string],
      :parentTriggerValues [string]}],
    :streaming boolean,
    :supportsAtLeastOnce boolean,
    :supportsExactlyOnce boolean,
    :defaultStreamingMode string},
   :sdkInfo {:language [UNKNOWN JAVA PYTHON GO], :version string},
   :defaultEnvironment
   {:stagingLocation string,
    :enableLauncherVmSerialPortLogging boolean,
    :sdkContainerImage string,
    :autoscalingAlgorithm
    [AUTOSCALING_ALGORITHM_UNKNOWN
     AUTOSCALING_ALGORITHM_NONE
     AUTOSCALING_ALGORITHM_BASIC],
    :launcherMachineType string,
    :maxWorkers integer,
    :workerRegion string,
    :additionalExperiments [string],
    :zone string,
    :streamingMode
    [STREAMING_MODE_UNSPECIFIED
     STREAMING_MODE_EXACTLY_ONCE
     STREAMING_MODE_AT_LEAST_ONCE],
    :machineType string,
    :saveHeapDumpsToGcsPath string,
    :tempLocation string,
    :numWorkers integer,
    :serviceAccountEmail string,
    :ipConfiguration
    [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
    :kmsKeyName string,
    :enableStreamingEngine boolean,
    :dumpHeapOnOom boolean,
    :diskSizeGb integer,
    :network string,
    :workerZone string,
    :flexrsGoal
    [FLEXRS_UNSPECIFIED FLEXRS_SPEED_OPTIMIZED FLEXRS_COST_OPTIMIZED],
    :additionalUserLabels object,
    :subnetwork string},
   :imageRepositoryUsernameSecretId string,
   :imageRepositoryPasswordSecretId string,
   :imageRepositoryCertPath string},
  :containerSpecGcsPath string,
  :parameters object,
  :launchOptions object,
  :environment
  {:stagingLocation string,
   :enableLauncherVmSerialPortLogging boolean,
   :sdkContainerImage string,
   :autoscalingAlgorithm
   [AUTOSCALING_ALGORITHM_UNKNOWN
    AUTOSCALING_ALGORITHM_NONE
    AUTOSCALING_ALGORITHM_BASIC],
   :launcherMachineType string,
   :maxWorkers integer,
   :workerRegion string,
   :additionalExperiments [string],
   :zone string,
   :streamingMode
   [STREAMING_MODE_UNSPECIFIED
    STREAMING_MODE_EXACTLY_ONCE
    STREAMING_MODE_AT_LEAST_ONCE],
   :machineType string,
   :saveHeapDumpsToGcsPath string,
   :tempLocation string,
   :numWorkers integer,
   :serviceAccountEmail string,
   :ipConfiguration
   [WORKER_IP_UNSPECIFIED WORKER_IP_PUBLIC WORKER_IP_PRIVATE],
   :kmsKeyName string,
   :enableStreamingEngine boolean,
   :dumpHeapOnOom boolean,
   :diskSizeGb integer,
   :network string,
   :workerZone string,
   :flexrsGoal
   [FLEXRS_UNSPECIFIED FLEXRS_SPEED_OPTIMIZED FLEXRS_COST_OPTIMIZED],
   :additionalUserLabels object,
   :subnetwork string},
  :update boolean,
  :transformNameMappings object},
 :validateOnly boolean}"
  [projectId location LaunchFlexTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataflow.googleapis.com/v1b3/projects/{projectId}/locations/{location}/flexTemplates:launch",
     :uri-template-args {:projectId projectId, :location location},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/compute"
      "https://www.googleapis.com/auth/compute.readonly"],
     :body LaunchFlexTemplateRequest}))

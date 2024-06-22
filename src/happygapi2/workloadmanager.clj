(ns happygapi2.workloadmanager
  "Workload Manager API
Workload Manager is a service that provides tooling for enterprise workloads to automate the deployment and validation of your workloads against best practices and recommendations.
See: https://cloud.google.com/workload-manager/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workloadmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workloadmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://workloadmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workloadmanager.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-evaluations-list
  "Lists Evaluations in a given project and location.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations/list

parent <string> Required. Parent value for ListEvaluationsRequest

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filter to be applied when listing the evaluation results.
orderBy <string> Hint for how to order the results"
  ([parent] (projects-locations-evaluations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+parent}/evaluations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-evaluations-get
  "Gets details of a single Evaluation.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations/get

name <string> Required. Name of the resource"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workloadmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-evaluations-create
  "Creates a new Evaluation in a given project and location.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations/create

parent <string> Required. The resource prefix of the evaluation location using the form: `projects/{project_id}/locations/{location_id}`
Evaluation:
{:description string,
 :labels object,
 :schedule string,
 :resourceStatus
 {:rulesNewerVersions [string],
  :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING]},
 :name string,
 :createTime string,
 :ruleVersions [string],
 :updateTime string,
 :ruleNames [string],
 :resourceFilter
 {:scopes [string],
  :resourceIdPatterns [string],
  :inclusionLabels object,
  :gceInstanceFilter {:serviceAccounts [string]}},
 :bigQueryDestination
 {:destinationDataset string, :createNewResultsTable boolean},
 :customRulesBucket string}

optional:
evaluationId <string> Required. Id of the requesting object
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Evaluation]
    (projects-locations-evaluations-create parent Evaluation nil))
  ([parent Evaluation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+parent}/evaluations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Evaluation})))

(defn projects-locations-evaluations-delete
  "Deletes a single Evaluation.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations/delete

name <string> Required. Name of the resource

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
force <boolean> Optional. Followed the best practice from https://aip.dev/135#cascading-delete"
  ([name] (projects-locations-evaluations-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-evaluations-executions-list
  "Lists Executions in a given project and location.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations.executions/list

parent <string> Required. The resource prefix of the Execution using the form: 'projects/{project}/locations/{location}/evaluations/{evaluation}'

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent]
    (projects-locations-evaluations-executions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+parent}/executions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-evaluations-executions-get
  "Gets details of a single Execution.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations.executions/get

name <string> Required. Name of the resource"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workloadmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-evaluations-executions-run
  "Creates a new Execution in a given project and location.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations.executions/run

name <string> Required. The resource name of the Execution using the form: 'projects/{project}/locations/{location}/evaluations/{evaluation}/executions/{execution}'
RunEvaluationRequest:
{:executionId string,
 :execution
 {:labels object,
  :startTime string,
  :name string,
  :endTime string,
  :state [STATE_UNSPECIFIED RUNNING SUCCEEDED FAILED],
  :inventoryTime string,
  :externalDataSources
  [{:name string,
    :uri string,
    :type [TYPE_UNSPECIFIED BIG_QUERY_TABLE]}],
  :runType [TYPE_UNSPECIFIED ONE_TIME SCHEDULED],
  :evaluationId string},
 :requestId string}"
  [name RunEvaluationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workloadmanager.googleapis.com/v1/{+name}/executions:run",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RunEvaluationRequest}))

(defn projects-locations-evaluations-executions-delete
  "Deletes a single Execution.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations.executions/delete

name <string> Required. Name of the resource

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-evaluations-executions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-evaluations-executions-results-list
  "Lists the result of a single evaluation.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations.executions.results/list

parent <string> Required. The execution results. Format: {parent}/evaluations/*/executions/*/results

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results"
  ([parent]
    (projects-locations-evaluations-executions-results-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+parent}/results",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-evaluations-executions-scannedResources-list
  "List all scanned resources for a single Execution.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.evaluations.executions.scannedResources/list

parent <string> Required. parent for ListScannedResourcesRequest

optional:
rule <string> rule name
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent]
    (projects-locations-evaluations-executions-scannedResources-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+parent}/scannedResources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-rules-list
  "Lists rules in a given project.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.rules/list

parent <string> Required. The [project] on which to execute the request. The format is: projects/{project_id}/locations/{location} Currently, the pre-defined rules are global available to all projects and all regions

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filter based on primary_category, secondary_category
customRulesBucket <string> The Cloud Storage bucket name for custom rules."
  ([parent] (projects-locations-rules-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workloadmanager.googleapis.com/v1/{+parent}/rules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-insights-writeInsight
  "Write the data insights to workload manager data warehouse.
https://cloud.google.com/workload-manager/docs/reference/rest/v1/projects.locations.insights/writeInsight

location <string> Required. The GCP location. The format is: projects/{project}/locations/{location}.
WriteInsightRequest:
{:insight
 {:sentTime string,
  :sapValidation
  {:validationDetails
   [{:sapValidationType
     [SAP_VALIDATION_TYPE_UNSPECIFIED
      SYSTEM
      COROSYNC
      PACEMAKER
      HANA
      NETWEAVER
      HANA_SECURITY
      CUSTOM],
     :details object,
     :isPresent boolean}],
   :projectId string,
   :zone string},
  :sapDiscovery
  {:metadata
   {:definedSystem string,
    :sapProduct string,
    :environmentType string,
    :customerRegion string},
   :databaseLayer
   {:resources
    [{:resourceType
      [RESOURCE_TYPE_UNSPECIFIED
       RESOURCE_TYPE_COMPUTE
       RESOURCE_TYPE_STORAGE
       RESOURCE_TYPE_NETWORK],
      :resourceKind
      [RESOURCE_KIND_UNSPECIFIED
       RESOURCE_KIND_INSTANCE
       RESOURCE_KIND_DISK
       RESOURCE_KIND_ADDRESS
       RESOURCE_KIND_FILESTORE
       RESOURCE_KIND_HEALTH_CHECK
       RESOURCE_KIND_FORWARDING_RULE
       RESOURCE_KIND_BACKEND_SERVICE
       RESOURCE_KIND_SUBNETWORK
       RESOURCE_KIND_NETWORK
       RESOURCE_KIND_PUBLIC_ADDRESS
       RESOURCE_KIND_INSTANCE_GROUP],
      :resourceUri string,
      :relatedResources [string],
      :updateTime string,
      :instanceProperties SapDiscoveryResourceInstanceProperties}],
    :applicationProperties
    {:applicationType
     [APPLICATION_TYPE_UNSPECIFIED
      NETWEAVER
      NETWEAVER_ABAP
      NETWEAVER_JAVA],
     :ascsUri string,
     :nfsUri string,
     :kernelVersion string,
     :abap boolean,
     :appInstanceNumber string,
     :ascsInstanceNumber string,
     :ersInstanceNumber string},
    :databaseProperties
    {:databaseType [DATABASE_TYPE_UNSPECIFIED HANA MAX_DB DB2],
     :primaryInstanceUri string,
     :sharedNfsUri string,
     :databaseVersion string,
     :instanceNumber string,
     :databaseSid string},
    :hostProject string,
    :sid string,
    :topologyType
    [TOPOLOGY_TYPE_UNSPECIFIED TOPOLOGY_SCALE_UP TOPOLOGY_SCALE_OUT],
    :haHosts [string],
    :replicationSites
    [{:resources [SapDiscoveryResource],
      :applicationProperties
      SapDiscoveryComponentApplicationProperties,
      :databaseProperties SapDiscoveryComponentDatabaseProperties,
      :hostProject string,
      :sid string,
      :topologyType
      [TOPOLOGY_TYPE_UNSPECIFIED TOPOLOGY_SCALE_UP TOPOLOGY_SCALE_OUT],
      :haHosts [string],
      :replicationSites [SapDiscoveryComponent]}]},
   :applicationLayer
   {:resources
    [{:resourceType
      [RESOURCE_TYPE_UNSPECIFIED
       RESOURCE_TYPE_COMPUTE
       RESOURCE_TYPE_STORAGE
       RESOURCE_TYPE_NETWORK],
      :resourceKind
      [RESOURCE_KIND_UNSPECIFIED
       RESOURCE_KIND_INSTANCE
       RESOURCE_KIND_DISK
       RESOURCE_KIND_ADDRESS
       RESOURCE_KIND_FILESTORE
       RESOURCE_KIND_HEALTH_CHECK
       RESOURCE_KIND_FORWARDING_RULE
       RESOURCE_KIND_BACKEND_SERVICE
       RESOURCE_KIND_SUBNETWORK
       RESOURCE_KIND_NETWORK
       RESOURCE_KIND_PUBLIC_ADDRESS
       RESOURCE_KIND_INSTANCE_GROUP],
      :resourceUri string,
      :relatedResources [string],
      :updateTime string,
      :instanceProperties SapDiscoveryResourceInstanceProperties}],
    :applicationProperties
    {:applicationType
     [APPLICATION_TYPE_UNSPECIFIED
      NETWEAVER
      NETWEAVER_ABAP
      NETWEAVER_JAVA],
     :ascsUri string,
     :nfsUri string,
     :kernelVersion string,
     :abap boolean,
     :appInstanceNumber string,
     :ascsInstanceNumber string,
     :ersInstanceNumber string},
    :databaseProperties
    {:databaseType [DATABASE_TYPE_UNSPECIFIED HANA MAX_DB DB2],
     :primaryInstanceUri string,
     :sharedNfsUri string,
     :databaseVersion string,
     :instanceNumber string,
     :databaseSid string},
    :hostProject string,
    :sid string,
    :topologyType
    [TOPOLOGY_TYPE_UNSPECIFIED TOPOLOGY_SCALE_UP TOPOLOGY_SCALE_OUT],
    :haHosts [string],
    :replicationSites
    [{:resources [SapDiscoveryResource],
      :applicationProperties
      SapDiscoveryComponentApplicationProperties,
      :databaseProperties SapDiscoveryComponentDatabaseProperties,
      :hostProject string,
      :sid string,
      :topologyType
      [TOPOLOGY_TYPE_UNSPECIFIED TOPOLOGY_SCALE_UP TOPOLOGY_SCALE_OUT],
      :haHosts [string],
      :replicationSites [SapDiscoveryComponent]}]},
   :systemId string,
   :updateTime string,
   :projectNumber string,
   :workloadProperties
   {:productVersions [{:name string, :version string}],
    :softwareComponentVersions
    [{:name string,
      :version string,
      :extVersion string,
      :type string}]}},
  :sqlserverValidation
  {:agentVersion string,
   :validationDetails
   [{:type
     [SQLSERVER_VALIDATION_TYPE_UNSPECIFIED
      OS
      DB_LOG_DISK_SEPARATION
      DB_MAX_PARALLELISM
      DB_CXPACKET_WAITS
      DB_TRANSACTION_LOG_HANDLING
      DB_VIRTUAL_LOG_FILE_COUNT
      DB_BUFFER_POOL_EXTENSION
      DB_MAX_SERVER_MEMORY
      INSTANCE_METRICS
      DB_INDEX_FRAGMENTATION
      DB_TABLE_INDEX_COMPRESSION
      DB_BACKUP_POLICY],
     :details [{:fields object}]}],
   :projectId string,
   :instance string},
  :instanceId string},
 :requestId string,
 :agentVersion string}"
  [location WriteInsightRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workloadmanager.googleapis.com/v1/{+location}/insights:writeInsight",
     :uri-template-args {:location location},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body WriteInsightRequest}))

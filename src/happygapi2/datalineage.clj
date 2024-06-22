(ns happygapi2.datalineage
  "Data Lineage API

See: https://cloud.google.com/dataplex/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-batchSearchLinkProcesses
  "Retrieve information about LineageProcesses associated with specific links. LineageProcesses are transformation pipelines that result in data flowing from **source** to **target** assets. Links between assets represent this operation. If you have specific link names, you can use this method to verify which LineageProcesses contribute to creating those links. See the SearchLinks method for more information on how to retrieve link name. You can retrieve the LineageProcess information in every project where you have the `datalineage.events.get` permission. The project provided in the URL is used for Billing and Quota.
https://cloud.google.com/dataplex

parent <string> Required. The project and location where you want to search.
GoogleCloudDatacatalogLineageV1BatchSearchLinkProcessesRequest:
{:pageSize integer, :pageToken string, :links [string]}"
  [parent
   GoogleCloudDatacatalogLineageV1BatchSearchLinkProcessesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalineage.googleapis.com/v1/{+parent}:batchSearchLinkProcesses",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDatacatalogLineageV1BatchSearchLinkProcessesRequest}))

(defn projects-locations-searchLinks
  "Retrieve a list of links connected to a specific asset. Links represent the data flow between **source** (upstream) and **target** (downstream) assets in transformation pipelines. Links are stored in the same project as the Lineage Events that create them. You can retrieve links in every project where you have the `datalineage.events.get` permission. The project provided in the URL is used for Billing and Quota.
https://cloud.google.com/dataplex

parent <string> Required. The project and location you want search in.
GoogleCloudDatacatalogLineageV1SearchLinksRequest:
{:target {:fullyQualifiedName string},
 :source {:fullyQualifiedName string},
 :pageToken string,
 :pageSize integer}"
  [parent GoogleCloudDatacatalogLineageV1SearchLinksRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalineage.googleapis.com/v1/{+parent}:searchLinks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogLineageV1SearchLinksRequest}))

(defn projects-locations-processOpenLineageRunEvent
  "Creates new lineage events together with their parents: process and run. Updates the process and run if they already exist. Mapped from Open Lineage specification: https://github.com/OpenLineage/OpenLineage/blob/main/spec/OpenLineage.json.
https://cloud.google.com/dataplex

parent <string> Required. The name of the project and its location that should own the process, run, and lineage event.
object:
object

optional:
requestId <string> A unique identifier for this request. Restricted to 36 ASCII characters. A random UUID is recommended. This request is idempotent only if a `request_id` is provided."
  ([parent object]
    (projects-locations-processOpenLineageRunEvent parent object nil))
  ([parent object optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+parent}:processOpenLineageRunEvent",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body object})))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/dataplex

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datalineage.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/dataplex

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datalineage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/dataplex

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/dataplex

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datalineage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processes-patch
  "Updates a process.
https://cloud.google.com/dataplex

name <string> Immutable. The resource name of the lineage process. Format: `projects/{project}/locations/{location}/processes/{process}`. Can be specified or auto-assigned. {process} must be not longer than 200 characters and only contain characters in a set: `a-zA-Z0-9_-:.`
GoogleCloudDatacatalogLineageV1Process:
{:origin
 {:sourceType
  [SOURCE_TYPE_UNSPECIFIED
   CUSTOM
   BIGQUERY
   DATA_FUSION
   COMPOSER
   LOOKER_STUDIO
   DATAPROC],
  :name string},
 :name string,
 :attributes object,
 :displayName string}

optional:
updateMask <string> The list of fields to update. Currently not used. The whole message is updated.
allowMissing <boolean> If set to true and the process is not found, the request inserts it."
  ([name GoogleCloudDatacatalogLineageV1Process]
    (projects-locations-processes-patch
      name
      GoogleCloudDatacatalogLineageV1Process
      nil))
  ([name GoogleCloudDatacatalogLineageV1Process optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datalineage.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogLineageV1Process})))

(defn projects-locations-processes-list
  "List processes in the given project and location. List order is descending by insertion time.
https://cloud.google.com/dataplex

parent <string> Required. The name of the project and its location that owns this collection of processes.

optional:
pageSize <integer> The maximum number of processes to return. The service may return fewer than this value. If unspecified, at most 50 processes are returned. The maximum value is 100; values greater than 100 are cut to 100."
  ([parent] (projects-locations-processes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+parent}/processes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processes-delete
  "Deletes the process with the specified name.
https://cloud.google.com/dataplex

name <string> Required. The name of the process to delete.

optional:
allowMissing <boolean> If set to true and the process is not found, the request succeeds but the server doesn't perform any actions."
  ([name] (projects-locations-processes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datalineage.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processes-get
  "Gets the details of the specified process.
https://cloud.google.com/dataplex

name <string> Required. The name of the process to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datalineage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processes-create
  "Creates a new process.
https://cloud.google.com/dataplex

parent <string> Required. The name of the project and its location that should own the process.
GoogleCloudDatacatalogLineageV1Process:
{:origin
 {:sourceType
  [SOURCE_TYPE_UNSPECIFIED
   CUSTOM
   BIGQUERY
   DATA_FUSION
   COMPOSER
   LOOKER_STUDIO
   DATAPROC],
  :name string},
 :name string,
 :attributes object,
 :displayName string}

optional:
requestId <string> A unique identifier for this request. Restricted to 36 ASCII characters. A random UUID is recommended. This request is idempotent only if a `request_id` is provided."
  ([parent GoogleCloudDatacatalogLineageV1Process]
    (projects-locations-processes-create
      parent
      GoogleCloudDatacatalogLineageV1Process
      nil))
  ([parent GoogleCloudDatacatalogLineageV1Process optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+parent}/processes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogLineageV1Process})))

(defn projects-locations-processes-runs-patch
  "Updates a run.
https://cloud.google.com/dataplex

name <string> Immutable. The resource name of the run. Format: `projects/{project}/locations/{location}/processes/{process}/runs/{run}`. Can be specified or auto-assigned. {run} must be not longer than 200 characters and only contain characters in a set: `a-zA-Z0-9_-:.`
GoogleCloudDatacatalogLineageV1Run:
{:startTime string,
 :displayName string,
 :name string,
 :state [UNKNOWN STARTED COMPLETED FAILED ABORTED],
 :attributes object,
 :endTime string}

optional:
allowMissing <boolean> If set to true and the run is not found, the request creates it.
updateMask <string> The list of fields to update. Currently not used. The whole message is updated."
  ([name GoogleCloudDatacatalogLineageV1Run]
    (projects-locations-processes-runs-patch
      name
      GoogleCloudDatacatalogLineageV1Run
      nil))
  ([name GoogleCloudDatacatalogLineageV1Run optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datalineage.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogLineageV1Run})))

(defn projects-locations-processes-runs-list
  "Lists runs in the given project and location. List order is descending by `start_time`.
https://cloud.google.com/dataplex

parent <string> Required. The name of process that owns this collection of runs.

optional:
pageSize <integer> The maximum number of runs to return. The service may return fewer than this value. If unspecified, at most 50 runs are returned. The maximum value is 100; values greater than 100 are cut to 100."
  ([parent] (projects-locations-processes-runs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+parent}/runs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processes-runs-get
  "Gets the details of the specified run.
https://cloud.google.com/dataplex

name <string> Required. The name of the run to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datalineage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processes-runs-create
  "Creates a new run.
https://cloud.google.com/dataplex

parent <string> Required. The name of the process that should own the run.
GoogleCloudDatacatalogLineageV1Run:
{:startTime string,
 :displayName string,
 :name string,
 :state [UNKNOWN STARTED COMPLETED FAILED ABORTED],
 :attributes object,
 :endTime string}

optional:
requestId <string> A unique identifier for this request. Restricted to 36 ASCII characters. A random UUID is recommended. This request is idempotent only if a `request_id` is provided."
  ([parent GoogleCloudDatacatalogLineageV1Run]
    (projects-locations-processes-runs-create
      parent
      GoogleCloudDatacatalogLineageV1Run
      nil))
  ([parent GoogleCloudDatacatalogLineageV1Run optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+parent}/runs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogLineageV1Run})))

(defn projects-locations-processes-runs-delete
  "Deletes the run with the specified name.
https://cloud.google.com/dataplex

name <string> Required. The name of the run to delete.

optional:
allowMissing <boolean> If set to true and the run is not found, the request succeeds but the server doesn't perform any actions."
  ([name] (projects-locations-processes-runs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datalineage.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processes-runs-lineageEvents-delete
  "Deletes the lineage event with the specified name.
https://cloud.google.com/dataplex

name <string> Required. The name of the lineage event to delete.

optional:
allowMissing <boolean> If set to true and the lineage event is not found, the request succeeds but the server doesn't perform any actions."
  ([name]
    (projects-locations-processes-runs-lineageEvents-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datalineage.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processes-runs-lineageEvents-list
  "Lists lineage events in the given project and location. The list order is not defined.
https://cloud.google.com/dataplex

parent <string> Required. The name of the run that owns the collection of lineage events to get.

optional:
pageSize <integer> The maximum number of lineage events to return. The service may return fewer events than this value. If unspecified, at most 50 events are returned. The maximum value is 100; values greater than 100 are cut to 100."
  ([parent]
    (projects-locations-processes-runs-lineageEvents-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+parent}/lineageEvents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processes-runs-lineageEvents-get
  "Gets details of a specified lineage event.
https://cloud.google.com/dataplex

name <string> Required. The name of the lineage event to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datalineage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processes-runs-lineageEvents-create
  "Creates a new lineage event.
https://cloud.google.com/dataplex

parent <string> Required. The name of the run that should own the lineage event.
GoogleCloudDatacatalogLineageV1LineageEvent:
{:endTime string,
 :links
 [{:source {:fullyQualifiedName string},
   :target {:fullyQualifiedName string}}],
 :name string,
 :startTime string}

optional:
requestId <string> A unique identifier for this request. Restricted to 36 ASCII characters. A random UUID is recommended. This request is idempotent only if a `request_id` is provided."
  ([parent GoogleCloudDatacatalogLineageV1LineageEvent]
    (projects-locations-processes-runs-lineageEvents-create
      parent
      GoogleCloudDatacatalogLineageV1LineageEvent
      nil))
  ([parent GoogleCloudDatacatalogLineageV1LineageEvent optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datalineage.googleapis.com/v1/{+parent}/lineageEvents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogLineageV1LineageEvent})))

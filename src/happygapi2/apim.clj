(ns happygapi2.apim
  "API Management API
Enables users to discover shadow APIs in existing Google Cloud infrastructure.
See: https://cloud.google.com/apigee/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/apigee

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/apigee

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/apigee

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/apigee

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/apigee

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/apigee

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apim.googleapis.com/v1alpha/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-observationSources-create
  "CreateObservationSource creates a new ObservationSource but does not affect any deployed infrastructure. It is a configuration that can be used in an Observation Job to collect data about APIs running in user's dataplane.
https://cloud.google.com/apigee

parent <string> Required. Value for parent.
ObservationSource:
{:gclbObservationSource
 {:pscNetworkConfigs [{:network string, :subnetwork string}]},
 :name string,
 :state [STATE_UNSPECIFIED CREATING CREATED DELETING ERROR],
 :createTime string,
 :updateTime string}

optional:
observationSourceId <string> Required. The ID to use for the Observation Source. This value should be 4-63 characters, and valid characters are /a-z-/.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ObservationSource]
    (projects-locations-observationSources-create
      parent
      ObservationSource
      nil))
  ([parent ObservationSource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+parent}/observationSources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ObservationSource})))

(defn projects-locations-observationSources-get
  "GetObservationSource retrieves a single ObservationSource by name.
https://cloud.google.com/apigee

name <string> Required. The name of the ObservationSource to retrieve. Format: projects/{project}/locations/{location}/observationSources/{source}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-observationSources-list
  "ListObservationSources gets all ObservationSources for a given project and location
https://cloud.google.com/apigee

parent <string> Required. The parent, which owns this collection of ObservationSources. Format: projects/{project}/locations/{location}

optional:
pageSize <integer> Optional. The maximum number of ObservationSources to return. The service may return fewer than this value. If unspecified, at most 10 ObservationSources will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-observationSources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+parent}/observationSources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-observationSources-delete
  "DeleteObservationSource deletes an observation source. This method will fail if the observation source is currently being used by any ObservationJob, even if not enabled.
https://cloud.google.com/apigee

name <string> Required. Name of the resource Format: projects/{project}/locations/{location}/observationSources/{source}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-observationJobs-create
  "CreateObservationJob creates a new ObservationJob but does not have any effecton its own. It is a configuration that can be used in an Observation Job to collect data about existing APIs.
https://cloud.google.com/apigee

parent <string> Required. The parent resource where this ObservationJob will be created. Format: projects/{project}/locations/{location}
ObservationJob:
{:name string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ENABLING
  ENABLED
  DISABLING
  DISABLED
  DELETING
  ERROR],
 :sources [string],
 :createTime string,
 :updateTime string}

optional:
observationJobId <string> Required. The ID to use for the Observation Job. This value should be 4-63 characters, and valid characters are /a-z-/.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ObservationJob]
    (projects-locations-observationJobs-create
      parent
      ObservationJob
      nil))
  ([parent ObservationJob optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+parent}/observationJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ObservationJob})))

(defn projects-locations-observationJobs-get
  "GetObservationJob retrieves a single ObservationJob by name.
https://cloud.google.com/apigee

name <string> Required. The name of the ObservationJob to retrieve. Format: projects/{project}/locations/{location}/observationJobs/{job}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-observationJobs-list
  "ListObservationJobs gets all ObservationJobs for a given project and location
https://cloud.google.com/apigee

parent <string> Required. The parent, which owns this collection of ObservationJobs. Format: projects/{project}/locations/{location}

optional:
pageSize <integer> Optional. The maximum number of ObservationJobs to return. The service may return fewer than this value. If unspecified, at most 10 ObservationJobs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-observationJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+parent}/observationJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-observationJobs-delete
  "DeleteObservationJob deletes an ObservationJob. This method will fail if the observation job is currently being used by any ObservationSource, even if not enabled.
https://cloud.google.com/apigee

name <string> Required. Name of the resource Format: projects/{project}/locations/{location}/observationJobs/{observation_job}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-observationJobs-enable
  "Enables the given ObservationJob.
https://cloud.google.com/apigee

name <string> Required. The name of the ObservationJob to enable. Format: projects/{project}/locations/{location}/observationJobs/{job}
EnableObservationJobRequest:
object"
  [name EnableObservationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apim.googleapis.com/v1alpha/{+name}:enable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EnableObservationJobRequest}))

(defn projects-locations-observationJobs-disable
  "Disables the given ObservationJob.
https://cloud.google.com/apigee

name <string> Required. The name of the ObservationJob to disable. Format: projects/{project}/locations/{location}/observationJobs/{job}
DisableObservationJobRequest:
object"
  [name DisableObservationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apim.googleapis.com/v1alpha/{+name}:disable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DisableObservationJobRequest}))

(defn projects-locations-observationJobs-apiObservations-get
  "GetApiObservation retrieves a single ApiObservation by name.
https://cloud.google.com/apigee

name <string> Required. The name of the ApiObservation to retrieve. Format: projects/{project}/locations/{location}/observationJobs/{observation_job}/apiObservations/{api_observation}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-observationJobs-apiObservations-list
  "ListApiObservations gets all ApiObservations for a given project and location and ObservationJob
https://cloud.google.com/apigee

parent <string> Required. The parent, which owns this collection of ApiObservations. Format: projects/{project}/locations/{location}/observationJobs/{observation_job}

optional:
pageSize <integer> Optional. The maximum number of ApiObservations to return. The service may return fewer than this value. If unspecified, at most 10 ApiObservations will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-locations-observationJobs-apiObservations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+parent}/apiObservations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-observationJobs-apiObservations-apiOperations-get
  "GetApiOperation retrieves a single ApiOperation by name.
https://cloud.google.com/apigee

name <string> Required. The name of the ApiOperation to retrieve. Format: projects/{project}/locations/{location}/observationJobs/{observation_job}/apiObservations/{api_observation}/apiOperation/{api_operation}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apim.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-observationJobs-apiObservations-apiOperations-list
  "ListApiOperations gets all ApiOperations for a given project and location and ObservationJob and ApiObservation
https://cloud.google.com/apigee

parent <string> Required. The parent, which owns this collection of ApiOperations. Format: projects/{project}/locations/{location}/observationJobs/{observation_job}/apiObservations/{api_observation}

optional:
pageSize <integer> Optional. The maximum number of ApiOperations to return. The service may return fewer than this value. If unspecified, at most 10 ApiOperations will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-locations-observationJobs-apiObservations-apiOperations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apim.googleapis.com/v1alpha/{+parent}/apiOperations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

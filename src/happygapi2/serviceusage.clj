(ns happygapi2.serviceusage
  "Service Usage API
Enables services that service consumers want to use on Google Cloud Platform, lists the available or enabled services, or disables services that service consumers no longer use.
See: https://cloud.google.com/service-usage/docs/overview"
  (:require [happy.oauth2.client :as client]))

(defn services-disable
  "Disable a service so that it can no longer be used with a project. This prevents unintended usage that may cause unexpected billing charges or security leaks. It is not valid to call the disable method on a service that is not currently enabled. Callers will receive a `FAILED_PRECONDITION` status if the target service is not currently enabled.
https://cloud.google.com/service-usage/docs/reference/rest/v1/services/disable

name <string> Name of the consumer and service to disable the service on. The enable and disable methods currently only support projects. An example name would be: `projects/123/services/serviceusage.googleapis.com` where `123` is the project number.
DisableServiceRequest:
{:checkIfServiceHasUsage
 [CHECK_IF_SERVICE_HAS_USAGE_UNSPECIFIED SKIP CHECK],
 :disableDependentServices boolean}"
  [name DisableServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceusage.googleapis.com/v1/{+name}:disable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body DisableServiceRequest}))

(defn services-get
  "Returns the service configuration and enabled state for a given service.
https://cloud.google.com/service-usage/docs/reference/rest/v1/services/get

name <string> Name of the consumer and service to get the `ConsumerState` for. An example name would be: `projects/123/services/serviceusage.googleapis.com` where `123` is the project number."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://serviceusage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn services-list
  "List all services available to the specified project, and the current state of those services with respect to the project. The list includes all public services, all services for which the calling user has the `servicemanagement.services.bind` permission, and all services that have already been enabled on the project. The list can be filtered to only include services in a specific state, for example to only include services enabled on the project. WARNING: If you need to query enabled services frequently or across an organization, you should use [Cloud Asset Inventory API](https://cloud.google.com/asset-inventory/docs/apis), which provides higher throughput and richer filtering capability.
https://cloud.google.com/service-usage/docs/reference/rest/v1/services/list

parent <string> Parent to search for services on. An example name would be: `projects/123` where `123` is the project number.

optional:
pageSize <integer> Requested size of the next page of data. Requested page size cannot exceed 200. If not set, the default page size is 50.
filter <string> Only list services that conform to the given filter. The allowed filter strings are `state:ENABLED` and `state:DISABLED`."
  ([parent] (services-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://serviceusage.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn services-batchGet
  "Returns the service configurations and enabled states for a given list of services.
https://cloud.google.com/service-usage/docs/reference/rest/v1/services/batchGet

parent <string> Parent to retrieve services from. If this is set, the parent of all of the services specified in `names` must match this field. An example name would be: `projects/123` where `123` is the project number. The `BatchGetServices` method currently only supports projects.

optional:
names <string> Names of the services to retrieve. An example name would be: `projects/123/services/serviceusage.googleapis.com` where `123` is the project number. A single request can get a maximum of 30 services at a time."
  ([parent] (services-batchGet parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://serviceusage.googleapis.com/v1/{+parent}/services:batchGet",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn services-enable
  "Enable a service so that it can be used with a project.
https://cloud.google.com/service-usage/docs/reference/rest/v1/services/enable

name <string> Name of the consumer and service to enable the service on. The `EnableService` and `DisableService` methods currently only support projects. Enabling a service requires that the service is public or is shared with the user enabling the service. An example name would be: `projects/123/services/serviceusage.googleapis.com` where `123` is the project number.
EnableServiceRequest:
object"
  [name EnableServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceusage.googleapis.com/v1/{+name}:enable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body EnableServiceRequest}))

(defn services-batchEnable
  "Enable multiple services on a project. The operation is atomic: if enabling any service fails, then the entire batch fails, and no state changes occur. To enable a single service, use the `EnableService` method instead.
https://cloud.google.com/service-usage/docs/reference/rest/v1/services/batchEnable

parent <string> Parent to enable services on. An example name would be: `projects/123` where `123` is the project number. The `BatchEnableServices` method currently only supports projects.
BatchEnableServicesRequest:
{:serviceIds [string]}"
  [parent BatchEnableServicesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceusage.googleapis.com/v1/{+parent}/services:batchEnable",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body BatchEnableServicesRequest}))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/service-usage/docs/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://serviceusage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/service-usage/docs/reference/rest/v1/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceusage.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body CancelOperationRequest}))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/service-usage/docs/reference/rest/v1/operations/list

optional:
pageSize <integer> The standard list page size.
name <string> The name of the operation's parent resource.
filter <string> The standard list filter."
  ([] (operations-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://serviceusage.googleapis.com/v1/operations",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"]})))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/service-usage/docs/reference/rest/v1/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://serviceusage.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(ns happygapi2.apphub
  "App Hub API

See: https://cloud.google.com/app-hub/docs/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-lookupServiceProjectAttachment
  "Lists a service project attachment for a given service project. You can call this API from any project to find if it is attached to a host project.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations/lookupServiceProjectAttachment

name <string> Required. Service project ID and location to lookup service project attachment for. Only global location is supported. Expected format: `projects/{project}/locations/{location}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://apphub.googleapis.com/v1/{+name}:lookupServiceProjectAttachment",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-detachServiceProjectAttachment
  "Detaches a service project from a host project. You can call this API from any service project without needing access to the host project that it is attached to.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations/detachServiceProjectAttachment

name <string> Required. Service project id and location to detach from a host project. Only global location is supported. Expected format: `projects/{project}/locations/{location}`.
DetachServiceProjectAttachmentRequest:
object"
  [name DetachServiceProjectAttachmentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apphub.googleapis.com/v1/{+name}:detachServiceProjectAttachment",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DetachServiceProjectAttachmentRequest}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://apphub.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-serviceProjectAttachments-list
  "Lists service projects attached to the host project.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.serviceProjectAttachments/list

parent <string> Required. Host project ID and location to list service project attachments. Only global location is supported. Expected format: `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results.
orderBy <string> Optional. Hint for how to order the results."
  ([parent]
    (projects-locations-serviceProjectAttachments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/serviceProjectAttachments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceProjectAttachments-create
  "Attaches a service project to the host project.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.serviceProjectAttachments/create

parent <string> Required. Host project ID and location to which service project is being attached. Only global location is supported. Expected format: `projects/{project}/locations/{location}`.
ServiceProjectAttachment:
{:name string,
 :serviceProject string,
 :createTime string,
 :uid string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING]}

optional:
serviceProjectAttachmentId <string> Required. The service project attachment identifier must contain the project id of the service project specified in the service_project_attachment.service_project field.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ServiceProjectAttachment]
    (projects-locations-serviceProjectAttachments-create
      parent
      ServiceProjectAttachment
      nil))
  ([parent ServiceProjectAttachment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/serviceProjectAttachments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServiceProjectAttachment})))

(defn projects-locations-serviceProjectAttachments-get
  "Gets a service project attachment.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.serviceProjectAttachments/get

name <string> Required. Fully qualified name of the service project attachment to retrieve. Expected format: `projects/{project}/locations/{location}/serviceProjectAttachments/{serviceProjectAttachment}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serviceProjectAttachments-delete
  "Deletes a service project attachment.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.serviceProjectAttachments/delete

name <string> Required. Fully qualified name of the service project attachment to delete. Expected format: `projects/{project}/locations/{location}/serviceProjectAttachments/{serviceProjectAttachment}`.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-serviceProjectAttachments-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://apphub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-discoveredServices-list
  "Lists Discovered Services that can be added to an Application in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.discoveredServices/list

parent <string> Required. Project and location to list Discovered Services on. Expected format: `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results.
orderBy <string> Optional. Hint for how to order the results."
  ([parent] (projects-locations-discoveredServices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/discoveredServices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-discoveredServices-get
  "Gets a Discovered Service in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.discoveredServices/get

name <string> Required. Fully qualified name of the Discovered Service to fetch. Expected format: `projects/{project}/locations/{location}/discoveredServices/{discoveredService}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-discoveredServices-lookup
  "Lists a Discovered Service in a host project and location, with a given resource URI.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.discoveredServices/lookup

parent <string> Required. Host project ID and location to lookup Discovered Service in. Expected format: `projects/{project}/locations/{location}`.

optional:
uri <string> Required. Resource URI to find DiscoveredService for. Accepts both project number and project ID and does translation when needed."
  ([parent] (projects-locations-discoveredServices-lookup parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/discoveredServices:lookup",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-discoveredWorkloads-list
  "Lists Discovered Workloads that can be added to an Application in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.discoveredWorkloads/list

parent <string> Required. Project and location to list Discovered Workloads on. Expected format: `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results.
orderBy <string> Optional. Hint for how to order the results."
  ([parent] (projects-locations-discoveredWorkloads-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/discoveredWorkloads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-discoveredWorkloads-get
  "Gets a Discovered Workload in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.discoveredWorkloads/get

name <string> Required. Fully qualified name of the Discovered Workload to fetch. Expected format: `projects/{project}/locations/{location}/discoveredWorkloads/{discoveredWorkload}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-discoveredWorkloads-lookup
  "Lists a Discovered Workload in a host project and location, with a given resource URI.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.discoveredWorkloads/lookup

parent <string> Required. Host project ID and location to lookup Discovered Workload in. Expected format: `projects/{project}/locations/{location}`.

optional:
uri <string> Required. Resource URI to find Discovered Workload for. Accepts both project number and project ID and does translation when needed."
  ([parent] (projects-locations-discoveredWorkloads-lookup parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/discoveredWorkloads:lookup",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-applications-list
  "Lists Applications in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/list

parent <string> Required. Project and location to list Applications on. Expected format: `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results.
orderBy <string> Optional. Hint for how to order the results."
  ([parent] (projects-locations-applications-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/applications",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-applications-create
  "Creates an Application in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/create

parent <string> Required. Project and location to create Application in. Expected format: `projects/{project}/locations/{location}`.
Application:
{:description string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING],
 :scope {:type [TYPE_UNSPECIFIED REGIONAL]},
 :updateTime string,
 :attributes
 {:criticality
  {:type [TYPE_UNSPECIFIED MISSION_CRITICAL HIGH MEDIUM LOW]},
  :environment
  {:type [TYPE_UNSPECIFIED PRODUCTION STAGING TEST DEVELOPMENT]},
  :developerOwners [{:displayName string, :email string}],
  :operatorOwners [{:displayName string, :email string}],
  :businessOwners [{:displayName string, :email string}]}}

optional:
applicationId <string> Required. The Application identifier. Must contain only lowercase letters, numbers or hyphens, with the first character a letter, the last a letter or a number, and a 63 character maximum.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Application]
    (projects-locations-applications-create parent Application nil))
  ([parent Application optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/applications",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Application})))

(defn projects-locations-applications-get
  "Gets an Application in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/get

name <string> Required. Fully qualified name of the Application to fetch. Expected format: `projects/{project}/locations/{location}/applications/{application}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-applications-patch
  "Updates an Application in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/patch

name <string> Identifier. The resource name of an Application. Format: \"projects/{host-project-id}/locations/{location}/applications/{application-id}\"
Application:
{:description string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING],
 :scope {:type [TYPE_UNSPECIFIED REGIONAL]},
 :updateTime string,
 :attributes
 {:criticality
  {:type [TYPE_UNSPECIFIED MISSION_CRITICAL HIGH MEDIUM LOW]},
  :environment
  {:type [TYPE_UNSPECIFIED PRODUCTION STAGING TEST DEVELOPMENT]},
  :developerOwners [{:displayName string, :email string}],
  :operatorOwners [{:displayName string, :email string}],
  :businessOwners [{:displayName string, :email string}]}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Application resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. The API changes the values of the fields as specified in the update_mask. The API ignores the values of all fields not covered by the update_mask. You can also unset a field by not specifying it in the updated message, but adding the field to the mask. This clears whatever value the field previously had.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Application]
    (projects-locations-applications-patch name Application nil))
  ([name Application optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://apphub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Application})))

(defn projects-locations-applications-delete
  "Deletes an Application in a host project and location.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/delete

name <string> Required. Fully qualified name of the Application to delete. Expected format: `projects/{project}/locations/{location}/applications/{application}`.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-applications-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://apphub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-applications-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/setIamPolicy

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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apphub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-applications-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-applications-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-applications-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apphub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-applications-services-list
  "Lists Services in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.services/list

parent <string> Required. Fully qualified name of the parent Application to list Services for. Expected format: `projects/{project}/locations/{location}/applications/{application}`.

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results
orderBy <string> Optional. Hint for how to order the results"
  ([parent] (projects-locations-applications-services-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-applications-services-create
  "Creates a Service in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.services/create

parent <string> Required. Fully qualified name of the parent Application to create the Service in. Expected format: `projects/{project}/locations/{location}/applications/{application}`.
Service:
{:description string,
 :serviceProperties
 {:gcpProject string, :location string, :zone string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING DETACHED],
 :updateTime string,
 :serviceReference {:uri string},
 :discoveredService string,
 :attributes
 {:criticality
  {:type [TYPE_UNSPECIFIED MISSION_CRITICAL HIGH MEDIUM LOW]},
  :environment
  {:type [TYPE_UNSPECIFIED PRODUCTION STAGING TEST DEVELOPMENT]},
  :developerOwners [{:displayName string, :email string}],
  :operatorOwners [{:displayName string, :email string}],
  :businessOwners [{:displayName string, :email string}]}}

optional:
serviceId <string> Required. The Service identifier. Must contain only lowercase letters, numbers or hyphens, with the first character a letter, the last a letter or a number, and a 63 character maximum.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Service]
    (projects-locations-applications-services-create
      parent
      Service
      nil))
  ([parent Service optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Service})))

(defn projects-locations-applications-services-get
  "Gets a Service in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.services/get

name <string> Required. Fully qualified name of the Service to fetch. Expected format: `projects/{project}/locations/{location}/applications/{application}/services/{service}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-applications-services-patch
  "Updates a Service in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.services/patch

name <string> Identifier. The resource name of a Service. Format: \"projects/{host-project-id}/locations/{location}/applications/{application-id}/services/{service-id}\"
Service:
{:description string,
 :serviceProperties
 {:gcpProject string, :location string, :zone string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING DETACHED],
 :updateTime string,
 :serviceReference {:uri string},
 :discoveredService string,
 :attributes
 {:criticality
  {:type [TYPE_UNSPECIFIED MISSION_CRITICAL HIGH MEDIUM LOW]},
  :environment
  {:type [TYPE_UNSPECIFIED PRODUCTION STAGING TEST DEVELOPMENT]},
  :developerOwners [{:displayName string, :email string}],
  :operatorOwners [{:displayName string, :email string}],
  :businessOwners [{:displayName string, :email string}]}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Service resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. The API changes the values of the fields as specified in the update_mask. The API ignores the values of all fields not covered by the update_mask. You can also unset a field by not specifying it in the updated message, but adding the field to the mask. This clears whatever value the field previously had.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Service]
    (projects-locations-applications-services-patch name Service nil))
  ([name Service optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://apphub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Service})))

(defn projects-locations-applications-services-delete
  "Deletes a Service from an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.services/delete

name <string> Required. Fully qualified name of the Service to delete from an Application. Expected format: `projects/{project}/locations/{location}/applications/{application}/services/{service}`.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-applications-services-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://apphub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-applications-workloads-list
  "Lists Workloads in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.workloads/list

parent <string> Required. Fully qualified name of the parent Application to list Workloads for. Expected format: `projects/{project}/locations/{location}/applications/{application}`.

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results.
orderBy <string> Optional. Hint for how to order the results."
  ([parent]
    (projects-locations-applications-workloads-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/workloads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-applications-workloads-create
  "Creates a Workload in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.workloads/create

parent <string> Required. Fully qualified name of the Application to create Workload in. Expected format: `projects/{project}/locations/{location}/applications/{application}`.
Workload:
{:description string,
 :displayName string,
 :workloadProperties
 {:gcpProject string, :location string, :zone string},
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING DETACHED],
 :discoveredWorkload string,
 :updateTime string,
 :workloadReference {:uri string},
 :attributes
 {:criticality
  {:type [TYPE_UNSPECIFIED MISSION_CRITICAL HIGH MEDIUM LOW]},
  :environment
  {:type [TYPE_UNSPECIFIED PRODUCTION STAGING TEST DEVELOPMENT]},
  :developerOwners [{:displayName string, :email string}],
  :operatorOwners [{:displayName string, :email string}],
  :businessOwners [{:displayName string, :email string}]}}

optional:
workloadId <string> Required. The Workload identifier. Must contain only lowercase letters, numbers or hyphens, with the first character a letter, the last a letter or a number, and a 63 character maximum.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Workload]
    (projects-locations-applications-workloads-create
      parent
      Workload
      nil))
  ([parent Workload optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apphub.googleapis.com/v1/{+parent}/workloads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Workload})))

(defn projects-locations-applications-workloads-get
  "Gets a Workload in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.workloads/get

name <string> Required. Fully qualified name of the Workload to fetch. Expected format: `projects/{project}/locations/{location}/applications/{application}/workloads/{workload}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apphub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-applications-workloads-patch
  "Updates a Workload in an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.workloads/patch

name <string> Identifier. The resource name of the Workload. Format: \"projects/{host-project-id}/locations/{location}/applications/{application-id}/workloads/{workload-id}\"
Workload:
{:description string,
 :displayName string,
 :workloadProperties
 {:gcpProject string, :location string, :zone string},
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING DETACHED],
 :discoveredWorkload string,
 :updateTime string,
 :workloadReference {:uri string},
 :attributes
 {:criticality
  {:type [TYPE_UNSPECIFIED MISSION_CRITICAL HIGH MEDIUM LOW]},
  :environment
  {:type [TYPE_UNSPECIFIED PRODUCTION STAGING TEST DEVELOPMENT]},
  :developerOwners [{:displayName string, :email string}],
  :operatorOwners [{:displayName string, :email string}],
  :businessOwners [{:displayName string, :email string}]}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Workload resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. The API changes the values of the fields as specified in the update_mask. The API ignores the values of all fields not covered by the update_mask. You can also unset a field by not specifying it in the updated message, but adding the field to the mask. This clears whatever value the field previously had.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Workload]
    (projects-locations-applications-workloads-patch
      name
      Workload
      nil))
  ([name Workload optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://apphub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Workload})))

(defn projects-locations-applications-workloads-delete
  "Deletes a Workload from an Application.
https://cloud.google.com/app-hub/docs/reference/rest/v1/projects.locations.applications.workloads/delete

name <string> Required. Fully qualified name of the Workload to delete from an Application. Expected format: `projects/{project}/locations/{location}/applications/{application}/workloads/{workload}`.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-applications-workloads-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://apphub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(ns happygapi2.serviceconsumermanagement
  "Service Consumer Management API
Manages the service consumers of a Service Infrastructure service.
See: https://cloud.google.com/service-infrastructure/docs/overview"
  (:require [happy.oauth2.client :as client]))

(defn services-search
  "Search tenancy units for a managed service.
https://cloud.google.com/service-infrastructure/docs/overview

parent <string> Required. Service for which search is performed. services/{service} {service} the name of a service, for example 'service.googleapis.com'.

optional:
query <string> Optional. Set a query `{expression}` for querying tenancy units. Your `{expression}` must be in the format: `field_name=literal_string`. The `field_name` is the name of the field you want to compare. Supported fields are `tenant_resources.tag` and `tenant_resources.resource`. For example, to search tenancy units that contain at least one tenant resource with a given tag 'xyz', use the query `tenant_resources.tag=xyz`. To search tenancy units that contain at least one tenant resource with a given resource name 'projects/123456', use the query `tenant_resources.resource=projects/123456`. Multiple expressions can be joined with `AND`s. Tenancy units must match all expressions to be included in the result set. For example, `tenant_resources.tag=xyz AND tenant_resources.resource=projects/123456`
pageSize <integer> Optional. The maximum number of results returned by this request. Currently, the default maximum is set to 1000. If `page_size` isn't provided or the size provided is a number larger than 1000, it's automatically set to 1000."
  ([parent] (services-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://serviceconsumermanagement.googleapis.com/v1/{+parent}:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn services-tenancyUnits-addProject
  "Add a new tenant project to the tenancy unit. There can be a maximum of 1024 tenant projects in a tenancy unit. If there are previously failed `AddTenantProject` calls, you might need to call `RemoveTenantProject` first to resolve them before you can make another call to `AddTenantProject` with the same tag. Operation.
https://cloud.google.com/service-infrastructure/docs/overview

parent <string> Required. Name of the tenancy unit. Such as 'services/service.googleapis.com/projects/12345/tenancyUnits/abcd'.
AddTenantProjectRequest:
{:projectConfig
 {:tenantProjectPolicy
  {:policyBindings [{:members [string], :role string}]},
  :services [string],
  :folder string,
  :serviceAccountConfig
  {:tenantProjectRoles [string], :accountId string},
  :labels object,
  :billingConfig {:billingAccount string}},
 :tag string}"
  [parent AddTenantProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+parent}:addProject",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AddTenantProjectRequest}))

(defn services-tenancyUnits-deleteProject
  "Deletes the specified project resource identified by a tenant resource tag. The mothod removes a project lien with a 'TenantManager' origin if that was added. It will then attempt to delete the project. If that operation fails, this method also fails. After the project has been deleted, the tenant resource state is set to DELETED. To permanently remove resource metadata, call the `RemoveTenantProject` method. New resources with the same tag can't be added if there are existing resources in a DELETED state. Operation.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> Required. Name of the tenancy unit. Such as 'services/service.googleapis.com/projects/12345/tenancyUnits/abcd'.
DeleteTenantProjectRequest:
{:tag string}"
  [name DeleteTenantProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}:deleteProject",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DeleteTenantProjectRequest}))

(defn services-tenancyUnits-applyProjectConfig
  "Apply a configuration to an existing tenant project. This project must exist in an active state and have the original owner account. The caller must have permission to add a project to the given tenancy unit. The configuration is applied, but any existing settings on the project aren't modified. Specified policy bindings are applied. Existing bindings aren't modified. Specified services are activated. No service is deactivated. If specified, new billing configuration is applied. Omit a billing configuration to keep the existing one. A service account in the project is created if previously non existed. Specified labels will be appended to tenant project, note that the value of existing label key will be updated if the same label key is requested. The specified folder is ignored, as moving a tenant project to a different folder isn't supported. The operation fails if any of the steps fail, but no rollback of already applied configuration changes is attempted. Operation.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> Required. Name of the tenancy unit. Such as 'services/service.googleapis.com/projects/12345/tenancyUnits/abcd'.
ApplyTenantProjectConfigRequest:
{:projectConfig
 {:tenantProjectPolicy
  {:policyBindings [{:members [string], :role string}]},
  :services [string],
  :folder string,
  :serviceAccountConfig
  {:tenantProjectRoles [string], :accountId string},
  :labels object,
  :billingConfig {:billingAccount string}},
 :tag string}"
  [name ApplyTenantProjectConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}:applyProjectConfig",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ApplyTenantProjectConfigRequest}))

(defn services-tenancyUnits-create
  "Creates a tenancy unit with no tenant resources. If tenancy unit already exists, it will be returned, however, in this case, returned TenancyUnit does not have tenant_resources field set and ListTenancyUnits has to be used to get a complete TenancyUnit with all fields populated.
https://cloud.google.com/service-infrastructure/docs/overview

parent <string> Required. services/{service}/{collection id}/{resource id} {collection id} is the cloud resource collection type representing the service consumer, for example 'projects', or 'organizations'. {resource id} is the consumer numeric id, such as project number: '123456'. {service} the name of a managed service, such as 'service.googleapis.com'. Enables service binding using the new tenancy unit.
CreateTenancyUnitRequest:
{:tenancyUnitId string}"
  [parent CreateTenancyUnitRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+parent}/tenancyUnits",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateTenancyUnitRequest}))

(defn services-tenancyUnits-delete
  "Delete a tenancy unit. Before you delete the tenancy unit, there should be no tenant resources in it that aren't in a DELETED state. Operation.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> Required. Name of the tenancy unit to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn services-tenancyUnits-list
  "Find the tenancy unit for a managed service and service consumer. This method shouldn't be used in a service producer's runtime path, for example to find the tenant project number when creating VMs. Service producers must persist the tenant project's information after the project is created.
https://cloud.google.com/service-infrastructure/docs/overview

parent <string> Required. Managed service and service consumer. Required. services/{service}/{collection id}/{resource id} {collection id} is the cloud resource collection type representing the service consumer, for example 'projects', or 'organizations'. {resource id} is the consumer numeric id, such as project number: '123456'. {service} the name of a service, such as 'service.googleapis.com'.

optional:
filter <string> Optional. Filter expression over tenancy resources field. Optional.
pageSize <integer> Optional. The maximum number of results returned by this request."
  ([parent] (services-tenancyUnits-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://serviceconsumermanagement.googleapis.com/v1/{+parent}/tenancyUnits",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn services-tenancyUnits-attachProject
  "Attach an existing project to the tenancy unit as a new tenant resource. The project could either be the tenant project reserved by calling `AddTenantProject` under a tenancy unit of a service producer's project of a managed service, or from a separate project. The caller is checked against a set of permissions as if calling `AddTenantProject` on the same service consumer. To trigger the attachment, the targeted tenant project must be in a folder. Make sure the ServiceConsumerManagement service account is the owner of that project. These two requirements are already met if the project is reserved by calling `AddTenantProject`. Operation.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> Required. Name of the tenancy unit that the project will be attached to. Such as 'services/service.googleapis.com/projects/12345/tenancyUnits/abcd'.
AttachTenantProjectRequest:
{:tag string, :externalResource string, :reservedResource string}"
  [name AttachTenantProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}:attachProject",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AttachTenantProjectRequest}))

(defn services-tenancyUnits-removeProject
  "Removes the specified project resource identified by a tenant resource tag. The method removes the project lien with 'TenantManager' origin if that was added. It then attempts to delete the project. If that operation fails, this method also fails. Calls to remove already removed or non-existent tenant project succeed. After the project has been deleted, or if was already in a DELETED state, resource metadata is permanently removed from the tenancy unit. Operation.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> Required. Name of the tenancy unit. Such as 'services/service.googleapis.com/projects/12345/tenancyUnits/abcd'.
RemoveTenantProjectRequest:
{:tag string}"
  [name RemoveTenantProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}:removeProject",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RemoveTenantProjectRequest}))

(defn services-tenancyUnits-undeleteProject
  "Attempts to undelete a previously deleted tenant project. The project must be in a DELETED state. There are no guarantees that an undeleted project will be in a fully restored and functional state. Call the `ApplyTenantProjectConfig` method to update its configuration and then validate all managed service resources. Operation.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> Required. Name of the tenancy unit. Such as 'services/service.googleapis.com/projects/12345/tenancyUnits/abcd'.
UndeleteTenantProjectRequest:
{:tag string}"
  [name UndeleteTenantProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}:undeleteProject",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UndeleteTenantProjectRequest}))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://serviceconsumermanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/service-infrastructure/docs/overview

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://serviceconsumermanagement.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

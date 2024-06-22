(ns happygapi2.config
  "Infrastructure Manager API
Creates and manages Google Cloud Platform resources and infrastructure.
See: https://cloud.google.com/infrastructure-manager/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://config.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-deployments-get
  "Gets details about a Deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/get

name <string> Required. The name of the deployment. Format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deployments-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/setIamPolicy

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
     "https://config.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-deployments-deleteState
  "Deletes Terraform state file in a given deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/deleteState

name <string> Required. The name of the deployment in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
DeleteStatefileRequest:
{:lockId string}"
  [name DeleteStatefileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://config.googleapis.com/v1/{+name}:deleteState",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DeleteStatefileRequest}))

(defn projects-locations-deployments-patch
  "Updates a Deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/patch

name <string> Resource name of the deployment. Format: `projects/{project}/locations/{location}/deployments/{deployment}`
Deployment:
{:serviceAccount string,
 :labels object,
 :latestRevision string,
 :stateDetail string,
 :errorCode
 [ERROR_CODE_UNSPECIFIED
  REVISION_FAILED
  CLOUD_BUILD_PERMISSION_DENIED
  DELETE_BUILD_API_FAILED
  DELETE_BUILD_RUN_FAILED
  BUCKET_CREATION_PERMISSION_DENIED
  BUCKET_CREATION_FAILED],
 :lockState
 [LOCK_STATE_UNSPECIFIED
  LOCKED
  UNLOCKED
  LOCKING
  UNLOCKING
  LOCK_FAILED
  UNLOCK_FAILED],
 :name string,
 :errorLogs string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  UPDATING
  DELETING
  FAILED
  SUSPENDED
  DELETED],
 :tfVersion string,
 :updateTime string,
 :tfErrors
 [{:resourceAddress string,
   :httpResponseCode integer,
   :errorDescription string,
   :error {:code integer, :message string, :details [object]}}],
 :importExistingResources boolean,
 :artifactsGcsBucket string,
 :deleteLogs string,
 :annotations object,
 :workerPool string,
 :deleteBuild string,
 :deleteResults {:content string, :artifacts string, :outputs object},
 :tfVersionConstraint string,
 :quotaValidation [QUOTA_VALIDATION_UNSPECIFIED ENABLED ENFORCED],
 :terraformBlueprint
 {:gcsSource string,
  :gitSource {:repo string, :directory string, :ref string},
  :inputValues object}}

optional:
updateMask <string> Optional. Field mask used to specify the fields to be overwritten in the Deployment resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Deployment]
    (projects-locations-deployments-patch name Deployment nil))
  ([name Deployment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://config.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Deployment})))

(defn projects-locations-deployments-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://config.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-deployments-create
  "Creates a Deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/create

parent <string> Required. The parent in whose context the Deployment is created. The parent value is in the format: 'projects/{project_id}/locations/{location}'.
Deployment:
{:serviceAccount string,
 :labels object,
 :latestRevision string,
 :stateDetail string,
 :errorCode
 [ERROR_CODE_UNSPECIFIED
  REVISION_FAILED
  CLOUD_BUILD_PERMISSION_DENIED
  DELETE_BUILD_API_FAILED
  DELETE_BUILD_RUN_FAILED
  BUCKET_CREATION_PERMISSION_DENIED
  BUCKET_CREATION_FAILED],
 :lockState
 [LOCK_STATE_UNSPECIFIED
  LOCKED
  UNLOCKED
  LOCKING
  UNLOCKING
  LOCK_FAILED
  UNLOCK_FAILED],
 :name string,
 :errorLogs string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  UPDATING
  DELETING
  FAILED
  SUSPENDED
  DELETED],
 :tfVersion string,
 :updateTime string,
 :tfErrors
 [{:resourceAddress string,
   :httpResponseCode integer,
   :errorDescription string,
   :error {:code integer, :message string, :details [object]}}],
 :importExistingResources boolean,
 :artifactsGcsBucket string,
 :deleteLogs string,
 :annotations object,
 :workerPool string,
 :deleteBuild string,
 :deleteResults {:content string, :artifacts string, :outputs object},
 :tfVersionConstraint string,
 :quotaValidation [QUOTA_VALIDATION_UNSPECIFIED ENABLED ENFORCED],
 :terraformBlueprint
 {:gcsSource string,
  :gitSource {:repo string, :directory string, :ref string},
  :inputValues object}}

optional:
deploymentId <string> Required. The Deployment ID.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Deployment]
    (projects-locations-deployments-create parent Deployment nil))
  ([parent Deployment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://config.googleapis.com/v1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Deployment})))

(defn projects-locations-deployments-delete
  "Deletes a Deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/delete

name <string> Required. The name of the Deployment in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
force <boolean> Optional. If set to true, any revisions for this deployment will also be deleted. (Otherwise, the request will only work if the deployment has no revisions.)
deletePolicy <string> Optional. Policy on how resources actuated by the deployment should be deleted. If unspecified, the default behavior is to delete the underlying resources."
  ([name] (projects-locations-deployments-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://config.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deployments-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-deployments-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deployments-exportState
  "Exports Terraform state file from a given deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/exportState

parent <string> Required. The parent in whose context the statefile is listed. The parent value is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
ExportDeploymentStatefileRequest:
{:draft boolean}"
  [parent ExportDeploymentStatefileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://config.googleapis.com/v1/{+parent}:exportState",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportDeploymentStatefileRequest}))

(defn projects-locations-deployments-list
  "Lists Deployments in a given project and location.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/list

parent <string> Required. The parent in whose context the Deployments are listed. The parent value is in the format: 'projects/{project_id}/locations/{location}'.

optional:
pageSize <integer> When requesting a page of resources, 'page_size' specifies number of resources to return. If unspecified, at most 500 will be returned. The maximum value is 1000.
filter <string> Lists the Deployments that match the filter expression. A filter expression filters the resources listed in the response. The expression must be of the form '{field} {operator} {value}' where operators: '<', '>', '<=', '>=', '!=', '=', ':' are supported (colon ':' represents a HAS operator which is roughly synonymous with equality). {field} can refer to a proto or JSON field, or a synthetic field. Field names can be camelCase or snake_case. Examples: - Filter by name: name = \"projects/foo/locations/us-central1/deployments/bar - Filter by labels: - Resources that have a key called 'foo' labels.foo:* - Resources that have a key called 'foo' whose value is 'bar' labels.foo = bar - Filter by state: - Deployments in CREATING state. state=CREATING
orderBy <string> Field to use to sort the list."
  ([parent] (projects-locations-deployments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deployments-exportLock
  "Exports the lock info on a locked deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/exportLock

name <string> Required. The name of the deployment in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://config.googleapis.com/v1/{+name}:exportLock",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deployments-unlock
  "Unlocks a locked deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/unlock

name <string> Required. The name of the deployment in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
UnlockDeploymentRequest:
{:lockId string}"
  [name UnlockDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://config.googleapis.com/v1/{+name}:unlock",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UnlockDeploymentRequest}))

(defn projects-locations-deployments-importState
  "Imports Terraform state file in a given deployment. The state file does not take effect until the Deployment has been unlocked.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/importState

parent <string> Required. The parent in whose context the statefile is listed. The parent value is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
ImportStatefileRequest:
{:lockId string}"
  [parent ImportStatefileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://config.googleapis.com/v1/{+parent}:importState",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ImportStatefileRequest}))

(defn projects-locations-deployments-lock
  "Locks a deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments/lock

name <string> Required. The name of the deployment in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
LockDeploymentRequest:
object"
  [name LockDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://config.googleapis.com/v1/{+name}:lock",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body LockDeploymentRequest}))

(defn projects-locations-deployments-revisions-list
  "Lists Revisions of a deployment.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments.revisions/list

parent <string> Required. The parent in whose context the Revisions are listed. The parent value is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.

optional:
pageSize <integer> When requesting a page of resources, `page_size` specifies number of resources to return. If unspecified, at most 500 will be returned. The maximum value is 1000.
filter <string> Lists the Revisions that match the filter expression. A filter expression filters the resources listed in the response. The expression must be of the form '{field} {operator} {value}' where operators: '<', '>', '<=', '>=', '!=', '=', ':' are supported (colon ':' represents a HAS operator which is roughly synonymous with equality). {field} can refer to a proto or JSON field, or a synthetic field. Field names can be camelCase or snake_case. Examples: - Filter by name: name = \"projects/foo/locations/us-central1/deployments/dep/revisions/bar - Filter by labels: - Resources that have a key called 'foo' labels.foo:* - Resources that have a key called 'foo' whose value is 'bar' labels.foo = bar - Filter by state: - Revisions in CREATING state. state=CREATING
orderBy <string> Field to use to sort the list."
  ([parent] (projects-locations-deployments-revisions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+parent}/revisions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deployments-revisions-get
  "Gets details about a Revision.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments.revisions/get

name <string> Required. The name of the Revision in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deployments-revisions-exportState
  "Exports Terraform state file from a given revision.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments.revisions/exportState

parent <string> Required. The parent in whose context the statefile is listed. The parent value is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
ExportRevisionStatefileRequest:
object"
  [parent ExportRevisionStatefileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://config.googleapis.com/v1/{+parent}:exportState",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportRevisionStatefileRequest}))

(defn projects-locations-deployments-revisions-resources-get
  "Gets details about a Resource deployed by Infra Manager.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments.revisions.resources/get

name <string> Required. The name of the Resource in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}/resource/{resource}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deployments-revisions-resources-list
  "Lists Resources in a given revision.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.deployments.revisions.resources/list

parent <string> Required. The parent in whose context the Resources are listed. The parent value is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.

optional:
pageSize <integer> When requesting a page of resources, 'page_size' specifies number of resources to return. If unspecified, at most 500 will be returned. The maximum value is 1000.
filter <string> Lists the Resources that match the filter expression. A filter expression filters the resources listed in the response. The expression must be of the form '{field} {operator} {value}' where operators: '<', '>', '<=', '>=', '!=', '=', ':' are supported (colon ':' represents a HAS operator which is roughly synonymous with equality). {field} can refer to a proto or JSON field, or a synthetic field. Field names can be camelCase or snake_case. Examples: - Filter by name: name = \"projects/foo/locations/us-central1/deployments/dep/revisions/bar/resources/baz
orderBy <string> Field to use to sort the list."
  ([parent]
    (projects-locations-deployments-revisions-resources-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+parent}/resources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-previews-create
  "Creates a Preview.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.previews/create

parent <string> Required. The parent in whose context the Preview is created. The parent value is in the format: 'projects/{project_id}/locations/{location}'.
Preview:
{:serviceAccount string,
 :labels object,
 :errorCode
 [ERROR_CODE_UNSPECIFIED
  CLOUD_BUILD_PERMISSION_DENIED
  BUCKET_CREATION_PERMISSION_DENIED
  BUCKET_CREATION_FAILED
  DEPLOYMENT_LOCK_ACQUIRE_FAILED
  PREVIEW_BUILD_API_FAILED
  PREVIEW_BUILD_RUN_FAILED],
 :logs string,
 :name string,
 :errorStatus {:code integer, :message string, :details [object]},
 :errorLogs string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  SUCCEEDED
  APPLYING
  STALE
  DELETING
  FAILED
  DELETED],
 :tfVersion string,
 :tfErrors
 [{:resourceAddress string,
   :httpResponseCode integer,
   :errorDescription string,
   :error {:code integer, :message string, :details [object]}}],
 :build string,
 :artifactsGcsBucket string,
 :deployment string,
 :annotations object,
 :previewMode [PREVIEW_MODE_UNSPECIFIED DEFAULT DELETE],
 :workerPool string,
 :tfVersionConstraint string,
 :previewArtifacts {:content string, :artifacts string},
 :terraformBlueprint
 {:gcsSource string,
  :gitSource {:repo string, :directory string, :ref string},
  :inputValues object}}

optional:
previewId <string> Optional. The preview ID.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Preview]
    (projects-locations-previews-create parent Preview nil))
  ([parent Preview optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://config.googleapis.com/v1/{+parent}/previews",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Preview})))

(defn projects-locations-previews-get
  "Gets details about a Preview.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.previews/get

name <string> Required. The name of the preview. Format: 'projects/{project_id}/locations/{location}/previews/{preview}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-previews-list
  "Lists Previews in a given project and location.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.previews/list

parent <string> Required. The parent in whose context the Previews are listed. The parent value is in the format: 'projects/{project_id}/locations/{location}'.

optional:
pageSize <integer> Optional. When requesting a page of resources, 'page_size' specifies number of resources to return. If unspecified, at most 500 will be returned. The maximum value is 1000.
filter <string> Optional. Lists the Deployments that match the filter expression. A filter expression filters the resources listed in the response. The expression must be of the form '{field} {operator} {value}' where operators: '<', '>', '<=', '>=', '!=', '=', ':' are supported (colon ':' represents a HAS operator which is roughly synonymous with equality). {field} can refer to a proto or JSON field, or a synthetic field. Field names can be camelCase or snake_case. Examples: - Filter by name: name = \"projects/foo/locations/us-central1/deployments/bar - Filter by labels: - Resources that have a key called 'foo' labels.foo:* - Resources that have a key called 'foo' whose value is 'bar' labels.foo = bar - Filter by state: - Deployments in CREATING state. state=CREATING
orderBy <string> Optional. Field to use to sort the list."
  ([parent] (projects-locations-previews-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+parent}/previews",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-previews-delete
  "Deletes a Preview.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.previews/delete

name <string> Required. The name of the Preview in the format: 'projects/{project_id}/locations/{location}/previews/{preview}'.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-previews-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://config.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-previews-export
  "Export Preview results.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.previews/export

parent <string> Required. The preview whose results should be exported. The preview value is in the format: 'projects/{project_id}/locations/{location}/previews/{preview}'.
ExportPreviewResultRequest:
object"
  [parent ExportPreviewResultRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://config.googleapis.com/v1/{+parent}:export",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportPreviewResultRequest}))

(defn projects-locations-terraformVersions-list
  "Lists TerraformVersions in a given project and location.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.terraformVersions/list

parent <string> Required. The parent in whose context the TerraformVersions are listed. The parent value is in the format: 'projects/{project_id}/locations/{location}'.

optional:
pageSize <integer> Optional. When requesting a page of resources, 'page_size' specifies number of resources to return. If unspecified, at most 500 will be returned. The maximum value is 1000.
filter <string> Optional. Lists the TerraformVersions that match the filter expression. A filter expression filters the resources listed in the response. The expression must be of the form '{field} {operator} {value}' where operators: '<', '>', '<=', '>=', '!=', '=', ':' are supported (colon ':' represents a HAS operator which is roughly synonymous with equality). {field} can refer to a proto or JSON field, or a synthetic field. Field names can be camelCase or snake_case.
orderBy <string> Optional. Field to use to sort the list."
  ([parent] (projects-locations-terraformVersions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://config.googleapis.com/v1/{+parent}/terraformVersions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-terraformVersions-get
  "Gets details about a TerraformVersion.
https://cloud.google.com/infrastructure-manager/docs/reference/rest/v1/projects.locations.terraformVersions/get

name <string> Required. The name of the TerraformVersion. Format: 'projects/{project_id}/locations/{location}/terraformVersions/{terraform_version}'"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://config.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

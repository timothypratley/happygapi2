(ns happygapi2.apigeeregistry
  "Apigee Registry API

See: https://cloud.google.com/apigee/docs/apihub/what-is-api-hub"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-instances-create
  "Provisions instance resources for the Registry.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. Parent resource of the Instance, of the form: `projects/*/locations/*`
Instance:
{:name string,
 :createTime string,
 :updateTime string,
 :state
 [STATE_UNSPECIFIED INACTIVE CREATING ACTIVE UPDATING DELETING FAILED],
 :stateMessage string,
 :config {:location string, :cmekKeyName string},
 :build {:repo string, :commitId string, :commitTime string}}

optional:
instanceId <string> Required. Identifier to assign to the Instance. Must be unique within scope of the parent resource."
  ([parent Instance]
    (projects-locations-instances-create parent Instance nil))
  ([parent Instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-delete
  "Deletes the Registry instance.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the Instance to delete. Format: `projects/*/locations/*/instances/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-get
  "Gets details of a single Instance.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the Instance to retrieve. Format: `projects/*/locations/*/instances/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-instances-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-instances-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-list
  "Returns matching APIs.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of APIs. Format: `projects/*/locations/*`

optional:
pageSize <integer> The maximum number of APIs to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent] (projects-locations-apis-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/apis",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-get
  "Returns a specified API.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the API to retrieve. Format: `projects/*/locations/*/apis/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-create
  "Creates a specified API.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of APIs. Format: `projects/*/locations/*`
Api:
{:description string,
 :labels object,
 :availability string,
 :displayName string,
 :name string,
 :recommendedVersion string,
 :createTime string,
 :updateTime string,
 :annotations object,
 :recommendedDeployment string}

optional:
apiId <string> Required. The ID to use for the API, which will become the final component of the API's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent Api] (projects-locations-apis-create parent Api nil))
  ([parent Api optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/apis",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Api})))

(defn projects-locations-apis-patch
  "Used to modify a specified API.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
Api:
{:description string,
 :labels object,
 :availability string,
 :displayName string,
 :name string,
 :recommendedVersion string,
 :createTime string,
 :updateTime string,
 :annotations object,
 :recommendedDeployment string}

optional:
updateMask <string> The list of fields to be updated. If omitted, all fields are updated that are set in the request message (fields set to default values are ignored). If an asterisk \"*\" is specified, all fields are updated, including fields that are unspecified/default in the request.
allowMissing <boolean> If set to true, and the API is not found, a new API will be created. In this situation, `update_mask` is ignored."
  ([name Api] (projects-locations-apis-patch name Api nil))
  ([name Api optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Api})))

(defn projects-locations-apis-delete
  "Removes a specified API and all of the resources that it owns.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the API to delete. Format: `projects/*/locations/*/apis/*`

optional:
force <boolean> If set to true, any child resources will also be deleted. (Otherwise, the request will only work if there are no child resources.)"
  ([name] (projects-locations-apis-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-apis-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-apis-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-versions-list
  "Returns matching versions.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of versions. Format: `projects/*/locations/*/apis/*`

optional:
pageSize <integer> The maximum number of versions to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent] (projects-locations-apis-versions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-get
  "Returns a specified version.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the version to retrieve. Format: `projects/*/locations/*/apis/*/versions/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-create
  "Creates a specified version.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of versions. Format: `projects/*/locations/*/apis/*`
ApiVersion:
{:description string,
 :labels object,
 :displayName string,
 :name string,
 :createTime string,
 :state string,
 :updateTime string,
 :annotations object,
 :primarySpec string}

optional:
apiVersionId <string> Required. The ID to use for the version, which will become the final component of the version's resource name. This value should be 1-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent ApiVersion]
    (projects-locations-apis-versions-create parent ApiVersion nil))
  ([parent ApiVersion optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ApiVersion})))

(defn projects-locations-apis-versions-patch
  "Used to modify a specified version.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
ApiVersion:
{:description string,
 :labels object,
 :displayName string,
 :name string,
 :createTime string,
 :state string,
 :updateTime string,
 :annotations object,
 :primarySpec string}

optional:
updateMask <string> The list of fields to be updated. If omitted, all fields are updated that are set in the request message (fields set to default values are ignored). If an asterisk \"*\" is specified, all fields are updated, including fields that are unspecified/default in the request.
allowMissing <boolean> If set to true, and the version is not found, a new version will be created. In this situation, `update_mask` is ignored."
  ([name ApiVersion]
    (projects-locations-apis-versions-patch name ApiVersion nil))
  ([name ApiVersion optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ApiVersion})))

(defn projects-locations-apis-versions-delete
  "Removes a specified version and all of the resources that it owns.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the version to delete. Format: `projects/*/locations/*/apis/*/versions/*`

optional:
force <boolean> If set to true, any child resources will also be deleted. (Otherwise, the request will only work if there are no child resources.)"
  ([name] (projects-locations-apis-versions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-apis-versions-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-apis-versions-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-versions-specs-rollback
  "Sets the current revision to a specified prior revision. Note that this creates a new revision with a new revision ID.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The spec being rolled back.
RollbackApiSpecRequest:
{:revisionId string}"
  [name RollbackApiSpecRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:rollback",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RollbackApiSpecRequest}))

(defn projects-locations-apis-versions-specs-get
  "Returns a specified spec.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the spec to retrieve. Format: `projects/*/locations/*/apis/*/versions/*/specs/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-specs-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-apis-versions-specs-patch
  "Used to modify a specified spec.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
ApiSpec:
{:description string,
 :labels object,
 :hash string,
 :revisionCreateTime string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :revisionId string,
 :filename string,
 :sourceUri string,
 :mimeType string,
 :annotations object,
 :contents string,
 :revisionUpdateTime string}

optional:
updateMask <string> The list of fields to be updated. If omitted, all fields are updated that are set in the request message (fields set to default values are ignored). If an asterisk \"*\" is specified, all fields are updated, including fields that are unspecified/default in the request.
allowMissing <boolean> If set to true, and the spec is not found, a new spec will be created. In this situation, `update_mask` is ignored."
  ([name ApiSpec]
    (projects-locations-apis-versions-specs-patch name ApiSpec nil))
  ([name ApiSpec optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ApiSpec})))

(defn projects-locations-apis-versions-specs-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-versions-specs-create
  "Creates a specified spec.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of specs. Format: `projects/*/locations/*/apis/*/versions/*`
ApiSpec:
{:description string,
 :labels object,
 :hash string,
 :revisionCreateTime string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :revisionId string,
 :filename string,
 :sourceUri string,
 :mimeType string,
 :annotations object,
 :contents string,
 :revisionUpdateTime string}

optional:
apiSpecId <string> Required. The ID to use for the spec, which will become the final component of the spec's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent ApiSpec]
    (projects-locations-apis-versions-specs-create parent ApiSpec nil))
  ([parent ApiSpec optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/specs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ApiSpec})))

(defn projects-locations-apis-versions-specs-getContents
  "Returns the contents of a specified spec. If specs are stored with GZip compression, the default behavior is to return the spec uncompressed (the mime_type response field indicates the exact format returned).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the spec whose contents should be retrieved. Format: `projects/*/locations/*/apis/*/versions/*/specs/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:getContents",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-specs-delete
  "Removes a specified spec, all revisions, and all child resources (e.g., artifacts).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the spec to delete. Format: `projects/*/locations/*/apis/*/versions/*/specs/*`

optional:
force <boolean> If set to true, any child resources will also be deleted. (Otherwise, the request will only work if there are no child resources.)"
  ([name] (projects-locations-apis-versions-specs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-specs-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-apis-versions-specs-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-specs-list
  "Returns matching specs.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of specs. Format: `projects/*/locations/*/apis/*/versions/*`

optional:
pageSize <integer> The maximum number of specs to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields except contents.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent] (projects-locations-apis-versions-specs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/specs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-specs-tagRevision
  "Adds a tag to a specified revision of a spec.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the spec to be tagged, including the revision ID is optional. If a revision is not specified, it will tag the latest revision.
TagApiSpecRevisionRequest:
{:tag string}"
  [name TagApiSpecRevisionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:tagRevision",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TagApiSpecRevisionRequest}))

(defn projects-locations-apis-versions-specs-deleteRevision
  "Deletes a revision of a spec.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the spec revision to be deleted, with a revision ID explicitly included. Example: `projects/sample/locations/global/apis/petstore/versions/1.0.0/specs/openapi.yaml@c7cfa2a8`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:deleteRevision",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-specs-listRevisions
  "Lists all revisions of a spec. Revisions are returned in descending order of revision creation time.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the spec to list revisions for.

optional:
pageSize <integer> The maximum number of revisions to return per page.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields."
  ([name]
    (projects-locations-apis-versions-specs-listRevisions name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}:listRevisions",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-specs-artifacts-get
  "Returns a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to retrieve. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-specs-artifacts-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-apis-versions-specs-artifacts-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-versions-specs-artifacts-create
  "Creates a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}

optional:
artifactId <string> Required. The ID to use for the artifact, which will become the final component of the artifact's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent Artifact]
    (projects-locations-apis-versions-specs-artifacts-create
      parent
      Artifact
      nil))
  ([parent Artifact optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Artifact})))

(defn projects-locations-apis-versions-specs-artifacts-getContents
  "Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact whose contents should be retrieved. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:getContents",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-specs-artifacts-delete
  "Removes a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to delete. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-specs-artifacts-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-apis-versions-specs-artifacts-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-specs-artifacts-replaceArtifact
  "Used to replace a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}"
  [name Artifact]
  (client/api-request
    {:method "PUT",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Artifact}))

(defn projects-locations-apis-versions-specs-artifacts-list
  "Returns matching artifacts.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`

optional:
pageSize <integer> The maximum number of artifacts to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields except contents.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent]
    (projects-locations-apis-versions-specs-artifacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-artifacts-get
  "Returns a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to retrieve. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-artifacts-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-apis-versions-artifacts-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-versions-artifacts-create
  "Creates a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}

optional:
artifactId <string> Required. The ID to use for the artifact, which will become the final component of the artifact's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent Artifact]
    (projects-locations-apis-versions-artifacts-create
      parent
      Artifact
      nil))
  ([parent Artifact optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Artifact})))

(defn projects-locations-apis-versions-artifacts-getContents
  "Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact whose contents should be retrieved. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:getContents",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-artifacts-delete
  "Removes a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to delete. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-versions-artifacts-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-apis-versions-artifacts-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-versions-artifacts-replaceArtifact
  "Used to replace a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}"
  [name Artifact]
  (client/api-request
    {:method "PUT",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Artifact}))

(defn projects-locations-apis-versions-artifacts-list
  "Returns matching artifacts.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`

optional:
pageSize <integer> The maximum number of artifacts to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields except contents.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent]
    (projects-locations-apis-versions-artifacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-deployments-rollback
  "Sets the current revision to a specified prior revision. Note that this creates a new revision with a new revision ID.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The deployment being rolled back.
RollbackApiDeploymentRequest:
{:revisionId string}"
  [name RollbackApiDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:rollback",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RollbackApiDeploymentRequest}))

(defn projects-locations-apis-deployments-get
  "Returns a specified deployment.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the deployment to retrieve. Format: `projects/*/locations/*/apis/*/deployments/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-deployments-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-apis-deployments-patch
  "Used to modify a specified deployment.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
ApiDeployment:
{:description string,
 :endpointUri string,
 :labels object,
 :displayName string,
 :revisionCreateTime string,
 :name string,
 :createTime string,
 :revisionId string,
 :externalChannelUri string,
 :intendedAudience string,
 :apiSpecRevision string,
 :annotations object,
 :accessGuidance string,
 :revisionUpdateTime string}

optional:
updateMask <string> The list of fields to be updated. If omitted, all fields are updated that are set in the request message (fields set to default values are ignored). If an asterisk \"*\" is specified, all fields are updated, including fields that are unspecified/default in the request.
allowMissing <boolean> If set to true, and the deployment is not found, a new deployment will be created. In this situation, `update_mask` is ignored."
  ([name ApiDeployment]
    (projects-locations-apis-deployments-patch name ApiDeployment nil))
  ([name ApiDeployment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ApiDeployment})))

(defn projects-locations-apis-deployments-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-deployments-create
  "Creates a specified deployment.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of deployments. Format: `projects/*/locations/*/apis/*`
ApiDeployment:
{:description string,
 :endpointUri string,
 :labels object,
 :displayName string,
 :revisionCreateTime string,
 :name string,
 :createTime string,
 :revisionId string,
 :externalChannelUri string,
 :intendedAudience string,
 :apiSpecRevision string,
 :annotations object,
 :accessGuidance string,
 :revisionUpdateTime string}

optional:
apiDeploymentId <string> Required. The ID to use for the deployment, which will become the final component of the deployment's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent ApiDeployment]
    (projects-locations-apis-deployments-create
      parent
      ApiDeployment
      nil))
  ([parent ApiDeployment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ApiDeployment})))

(defn projects-locations-apis-deployments-delete
  "Removes a specified deployment, all revisions, and all child resources (e.g., artifacts).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the deployment to delete. Format: `projects/*/locations/*/apis/*/deployments/*`

optional:
force <boolean> If set to true, any child resources will also be deleted. (Otherwise, the request will only work if there are no child resources.)"
  ([name] (projects-locations-apis-deployments-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-deployments-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-apis-deployments-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-deployments-list
  "Returns matching deployments.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of deployments. Format: `projects/*/locations/*/apis/*`

optional:
pageSize <integer> The maximum number of deployments to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent] (projects-locations-apis-deployments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-deployments-tagRevision
  "Adds a tag to a specified revision of a deployment.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the deployment to be tagged, including the revision ID is optional. If a revision is not specified, it will tag the latest revision.
TagApiDeploymentRevisionRequest:
{:tag string}"
  [name TagApiDeploymentRevisionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:tagRevision",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TagApiDeploymentRevisionRequest}))

(defn projects-locations-apis-deployments-deleteRevision
  "Deletes a revision of a deployment.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the deployment revision to be deleted, with a revision ID explicitly included. Example: `projects/sample/locations/global/apis/petstore/deployments/prod@c7cfa2a8`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:deleteRevision",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-deployments-listRevisions
  "Lists all revisions of a deployment. Revisions are returned in descending order of revision creation time.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the deployment to list revisions for.

optional:
pageSize <integer> The maximum number of revisions to return per page.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields."
  ([name] (projects-locations-apis-deployments-listRevisions name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+name}:listRevisions",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-deployments-artifacts-list
  "Returns matching artifacts.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`

optional:
pageSize <integer> The maximum number of artifacts to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields except contents.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent]
    (projects-locations-apis-deployments-artifacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-deployments-artifacts-get
  "Returns a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to retrieve. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-deployments-artifacts-getContents
  "Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact whose contents should be retrieved. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:getContents",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-deployments-artifacts-create
  "Creates a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}

optional:
artifactId <string> Required. The ID to use for the artifact, which will become the final component of the artifact's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent Artifact]
    (projects-locations-apis-deployments-artifacts-create
      parent
      Artifact
      nil))
  ([parent Artifact optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Artifact})))

(defn projects-locations-apis-deployments-artifacts-replaceArtifact
  "Used to replace a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}"
  [name Artifact]
  (client/api-request
    {:method "PUT",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Artifact}))

(defn projects-locations-apis-deployments-artifacts-delete
  "Removes a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to delete. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-artifacts-get
  "Returns a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to retrieve. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-artifacts-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-apis-artifacts-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-apis-artifacts-create
  "Creates a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}

optional:
artifactId <string> Required. The ID to use for the artifact, which will become the final component of the artifact's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent Artifact]
    (projects-locations-apis-artifacts-create parent Artifact nil))
  ([parent Artifact optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Artifact})))

(defn projects-locations-apis-artifacts-getContents
  "Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact whose contents should be retrieved. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:getContents",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-artifacts-delete
  "Removes a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to delete. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-apis-artifacts-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-apis-artifacts-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-apis-artifacts-replaceArtifact
  "Used to replace a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}"
  [name Artifact]
  (client/api-request
    {:method "PUT",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Artifact}))

(defn projects-locations-apis-artifacts-list
  "Returns matching artifacts.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`

optional:
pageSize <integer> The maximum number of artifacts to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields except contents.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent] (projects-locations-apis-artifacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-artifacts-get
  "Returns a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to retrieve. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-artifacts-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-artifacts-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-artifacts-create
  "Creates a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}

optional:
artifactId <string> Required. The ID to use for the artifact, which will become the final component of the artifact's resource name. This value should be 4-63 characters, and valid characters are /a-z-/. Following AIP-162, IDs must not have the form of a UUID."
  ([parent Artifact]
    (projects-locations-artifacts-create parent Artifact nil))
  ([parent Artifact optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Artifact})))

(defn projects-locations-artifacts-getContents
  "Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned).
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact whose contents should be retrieved. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+name}:getContents",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-artifacts-delete
  "Removes a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Required. The name of the artifact to delete. Format: `{parent}/artifacts/*`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-artifacts-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-artifacts-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-artifacts-replaceArtifact
  "Used to replace a specified artifact.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

name <string> Resource name.
Artifact:
{:labels object,
 :hash string,
 :name string,
 :sizeBytes integer,
 :createTime string,
 :updateTime string,
 :mimeType string,
 :annotations object,
 :contents string}"
  [name Artifact]
  (client/api-request
    {:method "PUT",
     :uri-template "https://apigeeregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Artifact}))

(defn projects-locations-artifacts-list
  "Returns matching artifacts.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

parent <string> Required. The parent, which owns this collection of artifacts. Format: `{parent}`

optional:
pageSize <integer> The maximum number of artifacts to return. The service may return fewer than this value. If unspecified, at most 50 values will be returned. The maximum is 1000; values above 1000 will be coerced to 1000.
filter <string> An expression that can be used to filter the list. Filters use the Common Expression Language and can refer to all message fields except contents.
orderBy <string> A comma-separated list of fields, e.g. \"foo,bar\" Fields can be sorted in descending order using the \"desc\" identifier, e.g. \"foo desc,bar\""
  ([parent] (projects-locations-artifacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+parent}/artifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-runtime-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-runtime-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-runtime-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-runtime-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-documents-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-documents-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-documents-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://apigeeregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-documents-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/apigee/docs/apihub/what-is-api-hub

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://apigeeregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

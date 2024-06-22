(ns happygapi2.accesscontextmanager
  "Access Context Manager API
An API for setting attribute based access control to requests to Google Cloud services. *Warning:* Do not mix *v1alpha* and *v1* API usage in the same access policy. The v1alpha API supports new Access Context Manager features, which may have different attributes or behaviors that are not supported by v1. The practice of mixed API usage within a policy may result in the inability to update that policy, including any access levels or service perimeters belonging to it. It is not recommended to use both v1 and v1alpha for modifying policies with critical service perimeters. Modifications using v1alpha should be limited to policies with non-production/non-critical service perimeters.
See: https://cloud.google.com/access-context-manager/docs/reference/rest/"
  (:require [happy.oauth2.client :as client]))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn accessPolicies-list
  "Lists all access policies in an organization.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/list

optional:
parent <string> Required. Resource name for the container to list AccessPolicy instances from. Format: `organizations/{org_id}`
pageSize <integer> Number of AccessPolicy instances to include in the list. Default 100."
  ([] (accessPolicies-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/accessPolicies",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn accessPolicies-get
  "Returns an access policy based on the name.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/get

name <string> Required. Resource name for the access policy to get. Format `accessPolicies/{policy_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn accessPolicies-create
  "Creates an access policy. This method fails if the organization already has an access policy. The long-running operation has a successful status after the access policy propagates to long-lasting storage. Syntactic and basic semantic errors are returned in `metadata` as a BadRequest proto.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/create

AccessPolicy:
{:name string,
 :parent string,
 :title string,
 :scopes [string],
 :etag string}"
  [AccessPolicy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/accessPolicies",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AccessPolicy}))

(defn accessPolicies-patch
  "Updates an access policy. The long-running operation from this RPC has a successful status after the changes to the access policy propagate to long-lasting storage.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/patch

name <string> Output only. Resource name of the `AccessPolicy`. Format: `accessPolicies/{access_policy}`
AccessPolicy:
{:name string,
 :parent string,
 :title string,
 :scopes [string],
 :etag string}

optional:
updateMask <string> Required. Mask to control which fields get updated. Must be non-empty."
  ([name AccessPolicy] (accessPolicies-patch name AccessPolicy nil))
  ([name AccessPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AccessPolicy})))

(defn accessPolicies-delete
  "Deletes an access policy based on the resource name. The long-running operation has a successful status after the access policy is removed from long-lasting storage.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/delete

name <string> Required. Resource name for the access policy to delete. Format `accessPolicies/{policy_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn accessPolicies-setIamPolicy
  "Sets the IAM policy for the specified Access Context Manager access policy. This method replaces the existing IAM policy on the access policy. The IAM policy controls the set of users who can perform specific operations on the Access Context Manager access policy.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/setIamPolicy

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
     "https://accesscontextmanager.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn accessPolicies-getIamPolicy
  "Gets the IAM policy for the specified Access Context Manager access policy.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn accessPolicies-testIamPermissions
  "Returns the IAM permissions that the caller has on the specified Access Context Manager resource. The resource can be an AccessPolicy, AccessLevel, or ServicePerimeter. This method does not support other resources.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn accessPolicies-accessLevels-list
  "Lists all access levels for an access policy.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.accessLevels/list

parent <string> Required. Resource name for the access policy to list Access Levels from. Format: `accessPolicies/{policy_id}`

optional:
pageSize <integer> Number of Access Levels to include in the list. Default 100.
accessLevelFormat <string> Whether to return `BasicLevels` in the Cloud Common Expression language, as `CustomLevels`, rather than as `BasicLevels`. Defaults to returning `AccessLevels` in the format they were defined."
  ([parent] (accessPolicies-accessLevels-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+parent}/accessLevels",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn accessPolicies-accessLevels-get
  "Gets an access level based on the resource name.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.accessLevels/get

name <string> Required. Resource name for the Access Level. Format: `accessPolicies/{policy_id}/accessLevels/{access_level_id}`

optional:
accessLevelFormat <string> Whether to return `BasicLevels` in the Cloud Common Expression Language rather than as `BasicLevels`. Defaults to AS_DEFINED, where Access Levels are returned as `BasicLevels` or `CustomLevels` based on how they were created. If set to CEL, all Access Levels are returned as `CustomLevels`. In the CEL case, `BasicLevels` are translated to equivalent `CustomLevels`."
  ([name] (accessPolicies-accessLevels-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn accessPolicies-accessLevels-create
  "Creates an access level. The long-running operation from this RPC has a successful status after the access level propagates to long-lasting storage. If access levels contain errors, an error response is returned for the first error encountered.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.accessLevels/create

parent <string> Required. Resource name for the access policy which owns this Access Level. Format: `accessPolicies/{policy_id}`
AccessLevel:
{:name string,
 :title string,
 :description string,
 :basic
 {:conditions
  [{:ipSubnetworks [string],
    :devicePolicy
    {:requireScreenlock boolean,
     :allowedEncryptionStatuses
     [[ENCRYPTION_UNSPECIFIED
       ENCRYPTION_UNSUPPORTED
       UNENCRYPTED
       ENCRYPTED]],
     :osConstraints
     [{:osType
       [OS_UNSPECIFIED
        DESKTOP_MAC
        DESKTOP_WINDOWS
        DESKTOP_LINUX
        DESKTOP_CHROME_OS
        ANDROID
        IOS],
       :minimumVersion string,
       :requireVerifiedChromeOs boolean}],
     :allowedDeviceManagementLevels
     [[MANAGEMENT_UNSPECIFIED NONE BASIC COMPLETE]],
     :requireAdminApproval boolean,
     :requireCorpOwned boolean},
    :requiredAccessLevels [string],
    :negate boolean,
    :members [string],
    :regions [string],
    :vpcNetworkSources
    [{:vpcSubnetwork {:network string, :vpcIpSubnetworks [string]}}]}],
  :combiningFunction [AND OR]},
 :custom
 {:expr
  {:expression string,
   :title string,
   :description string,
   :location string}}}"
  [parent AccessLevel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+parent}/accessLevels",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AccessLevel}))

(defn accessPolicies-accessLevels-patch
  "Updates an access level. The long-running operation from this RPC has a successful status after the changes to the access level propagate to long-lasting storage. If access levels contain errors, an error response is returned for the first error encountered.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.accessLevels/patch

name <string> Resource name for the `AccessLevel`. Format: `accessPolicies/{access_policy}/accessLevels/{access_level}`. The `access_level` component must begin with a letter, followed by alphanumeric characters or `_`. Its maximum length is 50 characters. After you create an `AccessLevel`, you cannot change its `name`.
AccessLevel:
{:name string,
 :title string,
 :description string,
 :basic
 {:conditions
  [{:ipSubnetworks [string],
    :devicePolicy
    {:requireScreenlock boolean,
     :allowedEncryptionStatuses
     [[ENCRYPTION_UNSPECIFIED
       ENCRYPTION_UNSUPPORTED
       UNENCRYPTED
       ENCRYPTED]],
     :osConstraints
     [{:osType
       [OS_UNSPECIFIED
        DESKTOP_MAC
        DESKTOP_WINDOWS
        DESKTOP_LINUX
        DESKTOP_CHROME_OS
        ANDROID
        IOS],
       :minimumVersion string,
       :requireVerifiedChromeOs boolean}],
     :allowedDeviceManagementLevels
     [[MANAGEMENT_UNSPECIFIED NONE BASIC COMPLETE]],
     :requireAdminApproval boolean,
     :requireCorpOwned boolean},
    :requiredAccessLevels [string],
    :negate boolean,
    :members [string],
    :regions [string],
    :vpcNetworkSources
    [{:vpcSubnetwork {:network string, :vpcIpSubnetworks [string]}}]}],
  :combiningFunction [AND OR]},
 :custom
 {:expr
  {:expression string,
   :title string,
   :description string,
   :location string}}}

optional:
updateMask <string> Required. Mask to control which fields get updated. Must be non-empty."
  ([name AccessLevel]
    (accessPolicies-accessLevels-patch name AccessLevel nil))
  ([name AccessLevel optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AccessLevel})))

(defn accessPolicies-accessLevels-delete
  "Deletes an access level based on the resource name. The long-running operation from this RPC has a successful status after the access level has been removed from long-lasting storage.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.accessLevels/delete

name <string> Required. Resource name for the Access Level. Format: `accessPolicies/{policy_id}/accessLevels/{access_level_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn accessPolicies-accessLevels-replaceAll
  "Replaces all existing access levels in an access policy with the access levels provided. This is done atomically. The long-running operation from this RPC has a successful status after all replacements propagate to long-lasting storage. If the replacement contains errors, an error response is returned for the first error encountered. Upon error, the replacement is cancelled, and existing access levels are not affected. The Operation.response field contains ReplaceAccessLevelsResponse. Removing access levels contained in existing service perimeters result in an error.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.accessLevels/replaceAll

parent <string> Required. Resource name for the access policy which owns these Access Levels. Format: `accessPolicies/{policy_id}`
ReplaceAccessLevelsRequest:
{:accessLevels
 [{:name string,
   :title string,
   :description string,
   :basic
   {:conditions
    [{:ipSubnetworks [string],
      :devicePolicy
      {:requireScreenlock boolean,
       :allowedEncryptionStatuses
       [[ENCRYPTION_UNSPECIFIED
         ENCRYPTION_UNSUPPORTED
         UNENCRYPTED
         ENCRYPTED]],
       :osConstraints [OsConstraint],
       :allowedDeviceManagementLevels
       [[MANAGEMENT_UNSPECIFIED NONE BASIC COMPLETE]],
       :requireAdminApproval boolean,
       :requireCorpOwned boolean},
      :requiredAccessLevels [string],
      :negate boolean,
      :members [string],
      :regions [string],
      :vpcNetworkSources [{:vpcSubnetwork VpcSubNetwork}]}],
    :combiningFunction [AND OR]},
   :custom
   {:expr
    {:expression string,
     :title string,
     :description string,
     :location string}}}],
 :etag string}"
  [parent ReplaceAccessLevelsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+parent}/accessLevels:replaceAll",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ReplaceAccessLevelsRequest}))

(defn accessPolicies-accessLevels-testIamPermissions
  "Returns the IAM permissions that the caller has on the specified Access Context Manager resource. The resource can be an AccessPolicy, AccessLevel, or ServicePerimeter. This method does not support other resources.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.accessLevels/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn accessPolicies-servicePerimeters-list
  "Lists all service perimeters for an access policy.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/list

parent <string> Required. Resource name for the access policy to list Service Perimeters from. Format: `accessPolicies/{policy_id}`

optional:
pageSize <integer> Number of Service Perimeters to include in the list. Default 100."
  ([parent] (accessPolicies-servicePerimeters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+parent}/servicePerimeters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn accessPolicies-servicePerimeters-get
  "Gets a service perimeter based on the resource name.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/get

name <string> Required. Resource name for the Service Perimeter. Format: `accessPolicies/{policy_id}/servicePerimeters/{service_perimeters_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn accessPolicies-servicePerimeters-create
  "Creates a service perimeter. The long-running operation from this RPC has a successful status after the service perimeter propagates to long-lasting storage. If a service perimeter contains errors, an error response is returned for the first error encountered.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/create

parent <string> Required. Resource name for the access policy which owns this Service Perimeter. Format: `accessPolicies/{policy_id}`
ServicePerimeter:
{:name string,
 :title string,
 :description string,
 :perimeterType [PERIMETER_TYPE_REGULAR PERIMETER_TYPE_BRIDGE],
 :status
 {:resources [string],
  :accessLevels [string],
  :restrictedServices [string],
  :vpcAccessibleServices
  {:enableRestriction boolean, :allowedServices [string]},
  :ingressPolicies
  [{:ingressFrom
    {:sources [{:accessLevel string, :resource string}],
     :identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT]},
    :ingressTo
    {:operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :resources [string]}}],
  :egressPolicies
  [{:egressFrom
    {:identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT],
     :sources [{:accessLevel string}],
     :sourceRestriction
     [SOURCE_RESTRICTION_UNSPECIFIED
      SOURCE_RESTRICTION_ENABLED
      SOURCE_RESTRICTION_DISABLED]},
    :egressTo
    {:resources [string],
     :operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :externalResources [string]}}]},
 :spec
 {:resources [string],
  :accessLevels [string],
  :restrictedServices [string],
  :vpcAccessibleServices
  {:enableRestriction boolean, :allowedServices [string]},
  :ingressPolicies
  [{:ingressFrom
    {:sources [{:accessLevel string, :resource string}],
     :identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT]},
    :ingressTo
    {:operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :resources [string]}}],
  :egressPolicies
  [{:egressFrom
    {:identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT],
     :sources [{:accessLevel string}],
     :sourceRestriction
     [SOURCE_RESTRICTION_UNSPECIFIED
      SOURCE_RESTRICTION_ENABLED
      SOURCE_RESTRICTION_DISABLED]},
    :egressTo
    {:resources [string],
     :operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :externalResources [string]}}]},
 :useExplicitDryRunSpec boolean}"
  [parent ServicePerimeter]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+parent}/servicePerimeters",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ServicePerimeter}))

(defn accessPolicies-servicePerimeters-patch
  "Updates a service perimeter. The long-running operation from this RPC has a successful status after the service perimeter propagates to long-lasting storage. If a service perimeter contains errors, an error response is returned for the first error encountered.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/patch

name <string> Resource name for the `ServicePerimeter`. Format: `accessPolicies/{access_policy}/servicePerimeters/{service_perimeter}`. The `service_perimeter` component must begin with a letter, followed by alphanumeric characters or `_`. After you create a `ServicePerimeter`, you cannot change its `name`.
ServicePerimeter:
{:name string,
 :title string,
 :description string,
 :perimeterType [PERIMETER_TYPE_REGULAR PERIMETER_TYPE_BRIDGE],
 :status
 {:resources [string],
  :accessLevels [string],
  :restrictedServices [string],
  :vpcAccessibleServices
  {:enableRestriction boolean, :allowedServices [string]},
  :ingressPolicies
  [{:ingressFrom
    {:sources [{:accessLevel string, :resource string}],
     :identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT]},
    :ingressTo
    {:operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :resources [string]}}],
  :egressPolicies
  [{:egressFrom
    {:identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT],
     :sources [{:accessLevel string}],
     :sourceRestriction
     [SOURCE_RESTRICTION_UNSPECIFIED
      SOURCE_RESTRICTION_ENABLED
      SOURCE_RESTRICTION_DISABLED]},
    :egressTo
    {:resources [string],
     :operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :externalResources [string]}}]},
 :spec
 {:resources [string],
  :accessLevels [string],
  :restrictedServices [string],
  :vpcAccessibleServices
  {:enableRestriction boolean, :allowedServices [string]},
  :ingressPolicies
  [{:ingressFrom
    {:sources [{:accessLevel string, :resource string}],
     :identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT]},
    :ingressTo
    {:operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :resources [string]}}],
  :egressPolicies
  [{:egressFrom
    {:identities [string],
     :identityType
     [IDENTITY_TYPE_UNSPECIFIED
      ANY_IDENTITY
      ANY_USER_ACCOUNT
      ANY_SERVICE_ACCOUNT],
     :sources [{:accessLevel string}],
     :sourceRestriction
     [SOURCE_RESTRICTION_UNSPECIFIED
      SOURCE_RESTRICTION_ENABLED
      SOURCE_RESTRICTION_DISABLED]},
    :egressTo
    {:resources [string],
     :operations
     [{:serviceName string, :methodSelectors [MethodSelector]}],
     :externalResources [string]}}]},
 :useExplicitDryRunSpec boolean}

optional:
updateMask <string> Required. Mask to control which fields get updated. Must be non-empty."
  ([name ServicePerimeter]
    (accessPolicies-servicePerimeters-patch name ServicePerimeter nil))
  ([name ServicePerimeter optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServicePerimeter})))

(defn accessPolicies-servicePerimeters-delete
  "Deletes a service perimeter based on the resource name. The long-running operation from this RPC has a successful status after the service perimeter is removed from long-lasting storage.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/delete

name <string> Required. Resource name for the Service Perimeter. Format: `accessPolicies/{policy_id}/servicePerimeters/{service_perimeter_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn accessPolicies-servicePerimeters-replaceAll
  "Replace all existing service perimeters in an access policy with the service perimeters provided. This is done atomically. The long-running operation from this RPC has a successful status after all replacements propagate to long-lasting storage. Replacements containing errors result in an error response for the first error encountered. Upon an error, replacement are cancelled and existing service perimeters are not affected. The Operation.response field contains ReplaceServicePerimetersResponse.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/replaceAll

parent <string> Required. Resource name for the access policy which owns these Service Perimeters. Format: `accessPolicies/{policy_id}`
ReplaceServicePerimetersRequest:
{:servicePerimeters
 [{:name string,
   :title string,
   :description string,
   :perimeterType [PERIMETER_TYPE_REGULAR PERIMETER_TYPE_BRIDGE],
   :status
   {:resources [string],
    :accessLevels [string],
    :restrictedServices [string],
    :vpcAccessibleServices
    {:enableRestriction boolean, :allowedServices [string]},
    :ingressPolicies
    [{:ingressFrom
      {:sources [IngressSource],
       :identities [string],
       :identityType
       [IDENTITY_TYPE_UNSPECIFIED
        ANY_IDENTITY
        ANY_USER_ACCOUNT
        ANY_SERVICE_ACCOUNT]},
      :ingressTo {:operations [ApiOperation], :resources [string]}}],
    :egressPolicies
    [{:egressFrom
      {:identities [string],
       :identityType
       [IDENTITY_TYPE_UNSPECIFIED
        ANY_IDENTITY
        ANY_USER_ACCOUNT
        ANY_SERVICE_ACCOUNT],
       :sources [EgressSource],
       :sourceRestriction
       [SOURCE_RESTRICTION_UNSPECIFIED
        SOURCE_RESTRICTION_ENABLED
        SOURCE_RESTRICTION_DISABLED]},
      :egressTo
      {:resources [string],
       :operations [ApiOperation],
       :externalResources [string]}}]},
   :spec
   {:resources [string],
    :accessLevels [string],
    :restrictedServices [string],
    :vpcAccessibleServices
    {:enableRestriction boolean, :allowedServices [string]},
    :ingressPolicies
    [{:ingressFrom
      {:sources [IngressSource],
       :identities [string],
       :identityType
       [IDENTITY_TYPE_UNSPECIFIED
        ANY_IDENTITY
        ANY_USER_ACCOUNT
        ANY_SERVICE_ACCOUNT]},
      :ingressTo {:operations [ApiOperation], :resources [string]}}],
    :egressPolicies
    [{:egressFrom
      {:identities [string],
       :identityType
       [IDENTITY_TYPE_UNSPECIFIED
        ANY_IDENTITY
        ANY_USER_ACCOUNT
        ANY_SERVICE_ACCOUNT],
       :sources [EgressSource],
       :sourceRestriction
       [SOURCE_RESTRICTION_UNSPECIFIED
        SOURCE_RESTRICTION_ENABLED
        SOURCE_RESTRICTION_DISABLED]},
      :egressTo
      {:resources [string],
       :operations [ApiOperation],
       :externalResources [string]}}]},
   :useExplicitDryRunSpec boolean}],
 :etag string}"
  [parent ReplaceServicePerimetersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+parent}/servicePerimeters:replaceAll",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ReplaceServicePerimetersRequest}))

(defn accessPolicies-servicePerimeters-commit
  "Commits the dry-run specification for all the service perimeters in an access policy. A commit operation on a service perimeter involves copying its `spec` field to the `status` field of the service perimeter. Only service perimeters with `use_explicit_dry_run_spec` field set to true are affected by a commit operation. The long-running operation from this RPC has a successful status after the dry-run specifications for all the service perimeters have been committed. If a commit fails, it causes the long-running operation to return an error response and the entire commit operation is cancelled. When successful, the Operation.response field contains CommitServicePerimetersResponse. The `dry_run` and the `spec` fields are cleared after a successful commit operation.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/commit

parent <string> Required. Resource name for the parent Access Policy which owns all Service Perimeters in scope for the commit operation. Format: `accessPolicies/{policy_id}`
CommitServicePerimetersRequest:
{:etag string}"
  [parent CommitServicePerimetersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+parent}/servicePerimeters:commit",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CommitServicePerimetersRequest}))

(defn accessPolicies-servicePerimeters-testIamPermissions
  "Returns the IAM permissions that the caller has on the specified Access Context Manager resource. The resource can be an AccessPolicy, AccessLevel, or ServicePerimeter. This method does not support other resources.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.servicePerimeters/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn accessPolicies-authorizedOrgsDescs-list
  "Lists all authorized orgs descs for an access policy.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.authorizedOrgsDescs/list

parent <string> Required. Resource name for the access policy to list Authorized Orgs Desc from. Format: `accessPolicies/{policy_id}`

optional:
pageSize <integer> Number of Authorized Orgs Descs to include in the list. Default 100."
  ([parent] (accessPolicies-authorizedOrgsDescs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+parent}/authorizedOrgsDescs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn accessPolicies-authorizedOrgsDescs-get
  "Gets an authorized orgs desc based on the resource name.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.authorizedOrgsDescs/get

name <string> Required. Resource name for the Authorized Orgs Desc. Format: `accessPolicies/{policy_id}/authorizedOrgsDescs/{authorized_orgs_descs_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn accessPolicies-authorizedOrgsDescs-create
  "Creates an authorized orgs desc. The long-running operation from this RPC has a successful status after the authorized orgs desc propagates to long-lasting storage. If a authorized orgs desc contains errors, an error response is returned for the first error encountered. The name of this `AuthorizedOrgsDesc` will be assigned during creation.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.authorizedOrgsDescs/create

parent <string> Required. Resource name for the access policy which owns this Authorized Orgs Desc. Format: `accessPolicies/{policy_id}`
AuthorizedOrgsDesc:
{:name string,
 :authorizationType
 [AUTHORIZATION_TYPE_UNSPECIFIED AUTHORIZATION_TYPE_TRUST],
 :assetType
 [ASSET_TYPE_UNSPECIFIED
  ASSET_TYPE_DEVICE
  ASSET_TYPE_CREDENTIAL_STRENGTH],
 :authorizationDirection
 [AUTHORIZATION_DIRECTION_UNSPECIFIED
  AUTHORIZATION_DIRECTION_TO
  AUTHORIZATION_DIRECTION_FROM],
 :orgs [string]}"
  [parent AuthorizedOrgsDesc]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+parent}/authorizedOrgsDescs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AuthorizedOrgsDesc}))

(defn accessPolicies-authorizedOrgsDescs-patch
  "Updates an authorized orgs desc. The long-running operation from this RPC has a successful status after the authorized orgs desc propagates to long-lasting storage. If a authorized orgs desc contains errors, an error response is returned for the first error encountered. Only the organization list in `AuthorizedOrgsDesc` can be updated. The name, authorization_type, asset_type and authorization_direction cannot be updated.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.authorizedOrgsDescs/patch

name <string> Resource name for the `AuthorizedOrgsDesc`. Format: `accessPolicies/{access_policy}/authorizedOrgsDescs/{authorized_orgs_desc}`. The `authorized_orgs_desc` component must begin with a letter, followed by alphanumeric characters or `_`. After you create an `AuthorizedOrgsDesc`, you cannot change its `name`.
AuthorizedOrgsDesc:
{:name string,
 :authorizationType
 [AUTHORIZATION_TYPE_UNSPECIFIED AUTHORIZATION_TYPE_TRUST],
 :assetType
 [ASSET_TYPE_UNSPECIFIED
  ASSET_TYPE_DEVICE
  ASSET_TYPE_CREDENTIAL_STRENGTH],
 :authorizationDirection
 [AUTHORIZATION_DIRECTION_UNSPECIFIED
  AUTHORIZATION_DIRECTION_TO
  AUTHORIZATION_DIRECTION_FROM],
 :orgs [string]}

optional:
updateMask <string> Required. Mask to control which fields get updated. Must be non-empty."
  ([name AuthorizedOrgsDesc]
    (accessPolicies-authorizedOrgsDescs-patch
      name
      AuthorizedOrgsDesc
      nil))
  ([name AuthorizedOrgsDesc optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AuthorizedOrgsDesc})))

(defn accessPolicies-authorizedOrgsDescs-delete
  "Deletes an authorized orgs desc based on the resource name. The long-running operation from this RPC has a successful status after the authorized orgs desc is removed from long-lasting storage.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/accessPolicies.authorizedOrgsDescs/delete

name <string> Required. Resource name for the Authorized Orgs Desc. Format: `accessPolicies/{policy_id}/authorizedOrgsDesc/{authorized_orgs_desc_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn services-list
  "Lists all VPC-SC supported services.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/services/list

optional:
pageSize <integer> This flag specifies the maximum number of services to return per page. Default is 100."
  ([] (services-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/services",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn services-get
  "Returns a VPC-SC supported service based on the service name.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/services/get

name <string> The name of the service to get information about. The names must be in the same format as used in defining a service perimeter, for example, `storage.googleapis.com`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/services/{name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-gcpUserAccessBindings-list
  "Lists all GcpUserAccessBindings for a Google Cloud organization.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/organizations.gcpUserAccessBindings/list

parent <string> Required. Example: \"organizations/256\"

optional:
pageSize <integer> Optional. Maximum number of items to return. The server may return fewer items. If left blank, the server may return any number of items."
  ([parent] (organizations-gcpUserAccessBindings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+parent}/gcpUserAccessBindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-gcpUserAccessBindings-get
  "Gets the GcpUserAccessBinding with the given name.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/organizations.gcpUserAccessBindings/get

name <string> Required. Example: \"organizations/256/gcpUserAccessBindings/b3-BhcX_Ud5N\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-gcpUserAccessBindings-create
  "Creates a GcpUserAccessBinding. If the client specifies a name, the server ignores it. Fails if a resource already exists with the same group_key. Completion of this long-running operation does not necessarily signify that the new binding is deployed onto all affected users, which may take more time.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/organizations.gcpUserAccessBindings/create

parent <string> Required. Example: \"organizations/256\"
GcpUserAccessBinding:
{:name string,
 :groupKey string,
 :accessLevels [string],
 :dryRunAccessLevels [string],
 :restrictedClientApplications [{:clientId string, :name string}]}"
  [parent GcpUserAccessBinding]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+parent}/gcpUserAccessBindings",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GcpUserAccessBinding}))

(defn organizations-gcpUserAccessBindings-patch
  "Updates a GcpUserAccessBinding. Completion of this long-running operation does not necessarily signify that the changed binding is deployed onto all affected users, which may take more time.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/organizations.gcpUserAccessBindings/patch

name <string> Immutable. Assigned by the server during creation. The last segment has an arbitrary length and has only URI unreserved characters (as defined by [RFC 3986 Section 2.3](https://tools.ietf.org/html/rfc3986#section-2.3)). Should not be specified by the client during creation. Example: \"organizations/256/gcpUserAccessBindings/b3-BhcX_Ud5N\"
GcpUserAccessBinding:
{:name string,
 :groupKey string,
 :accessLevels [string],
 :dryRunAccessLevels [string],
 :restrictedClientApplications [{:clientId string, :name string}]}

optional:
updateMask <string> Required. Only the fields specified in this mask are updated. Because name and group_key cannot be changed, update_mask is required and may only contain the following fields: `access_levels`, `dry_run_access_levels`. update_mask { paths: \"access_levels\" }"
  ([name GcpUserAccessBinding]
    (organizations-gcpUserAccessBindings-patch
      name
      GcpUserAccessBinding
      nil))
  ([name GcpUserAccessBinding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accesscontextmanager.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GcpUserAccessBinding})))

(defn organizations-gcpUserAccessBindings-delete
  "Deletes a GcpUserAccessBinding. Completion of this long-running operation does not necessarily signify that the binding deletion is deployed onto all affected users, which may take more time.
https://cloud.google.com/access-context-manager/docs/reference/rest/v1/organizations.gcpUserAccessBindings/delete

name <string> Required. Example: \"organizations/256/gcpUserAccessBindings/b3-BhcX_Ud5N\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://accesscontextmanager.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

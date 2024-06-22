(ns happygapi2.iap
  "Cloud Identity-Aware Proxy API
Controls access to cloud applications running on Google Cloud Platform.
See: https://cloud.google.com/security/products/iap"
  (:require [happy.oauth2.client :as client]))

(defn setIamPolicy
  "Sets the access control policy for an Identity-Aware Proxy protected resource. Replaces any existing policy. More information about managing access via IAP can be found at: https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
https://cloud.google.com/security/products/iap/v1/docs/setIamPolicy

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
     "https://iap.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn getIamPolicy
  "Gets the access control policy for an Identity-Aware Proxy protected resource. More information about managing access via IAP can be found at: https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
https://cloud.google.com/security/products/iap/v1/docs/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://iap.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn testIamPermissions
  "Returns permissions that a caller has on the Identity-Aware Proxy protected resource. More information about managing access via IAP can be found at: https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
https://cloud.google.com/security/products/iap/v1/docs/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://iap.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn getIapSettings
  "Gets the IAP settings on a particular IAP protected resource.
https://cloud.google.com/security/products/iap/v1/docs/getIapSettings

name <string> Required. The resource name for which to retrieve the settings. Authorization: Requires the `getSettings` permission for the associated resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://iap.googleapis.com/v1/{+name}:iapSettings",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn updateIapSettings
  "Updates the IAP settings on a particular IAP protected resource. It replaces all fields unless the `update_mask` is set.
https://cloud.google.com/security/products/iap/v1/docs/updateIapSettings

name <string> Required. The resource name of the IAP protected resource.
IapSettings:
{:name string,
 :accessSettings
 {:gcipSettings {:tenantIds [string], :loginPageUri string},
  :corsSettings {:allowHttpOptions boolean},
  :oauthSettings {:loginHint string, :programmaticClients [string]},
  :policyDelegationSettings
  {:iamServiceName string,
   :iamPermission string,
   :resource
   {:name string,
    :type string,
    :service string,
    :labels object,
    :expectedNextState object,
    :nextStateOfTags
    {:tagsFullState TagsFullState,
     :tagsPartialState TagsPartialState,
     :tagsFullStateForChildResource TagsFullStateForChildResource}},
   :policyName {:type string, :id string, :region string}},
  :reauthSettings
  {:method
   [METHOD_UNSPECIFIED
    LOGIN
    PASSWORD
    SECURE_KEY
    ENROLLED_SECOND_FACTORS],
   :maxAge string,
   :policyType [POLICY_TYPE_UNSPECIFIED MINIMUM DEFAULT]},
  :allowedDomainsSettings {:enable boolean, :domains [string]},
  :workforceIdentitySettings
  {:workforcePools [string],
   :oauth2
   {:clientId string,
    :clientSecret string,
    :clientSecretSha256 string}},
  :identitySources
  [[IDENTITY_SOURCE_UNSPECIFIED WORKFORCE_IDENTITY_FEDERATION]]},
 :applicationSettings
 {:csmSettings {:rctokenAud string},
  :accessDeniedPageSettings
  {:accessDeniedPageUri string,
   :generateTroubleshootingUri boolean,
   :remediationTokenGenerationEnabled boolean},
  :cookieDomain string,
  :attributePropagationSettings
  {:expression string,
   :outputCredentials
   [[OUTPUT_CREDENTIALS_UNSPECIFIED HEADER JWT RCTOKEN]],
   :enable boolean}}}

optional:
updateMask <string> The field mask specifying which IAP settings should be updated. If omitted, then all of the settings are updated. See https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask. Note: All IAP reauth settings must always be set together, using the field mask: `iapSettings.accessSettings.reauthSettings`."
  ([name IapSettings] (updateIapSettings name IapSettings nil))
  ([name IapSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://iap.googleapis.com/v1/{+name}:iapSettings",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body IapSettings})))

(defn validateAttributeExpression
  "Validates that a given CEL expression conforms to IAP restrictions.
https://cloud.google.com/security/products/iap/v1/docs/validateAttributeExpression

name <string> Required. The resource name of the IAP protected resource.

optional:
expression <string> Required. User input string expression. Should be of the form `attributes.saml_attributes.filter(attribute, attribute.name in ['{attribute_name}', '{attribute_name}'])`"
  ([name] (validateAttributeExpression name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://iap.googleapis.com/v1/{+name}:validateAttributeExpression",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-iap_tunnel-locations-destGroups-list
  "Lists the existing TunnelDestGroups. To group across all locations, use a `-` as the location ID. For example: `/v1/projects/123/iap_tunnel/locations/-/destGroups`
https://cloud.google.com/security/products/iap/v1/docs/projects/iap_tunnel/locations/destGroups/list

parent <string> Required. Google Cloud Project ID and location. In the following format: `projects/{project_number/id}/iap_tunnel/locations/{location}`. A `-` can be used for the location to group across all locations.

optional:
pageSize <integer> The maximum number of groups to return. The service might return fewer than this value. If unspecified, at most 100 groups are returned. The maximum value is 1000; values above 1000 are coerced to 1000."
  ([parent] (projects-iap_tunnel-locations-destGroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://iap.googleapis.com/v1/{+parent}/destGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-iap_tunnel-locations-destGroups-create
  "Creates a new TunnelDestGroup.
https://cloud.google.com/security/products/iap/v1/docs/projects/iap_tunnel/locations/destGroups/create

parent <string> Required. Google Cloud Project ID and location. In the following format: `projects/{project_number/id}/iap_tunnel/locations/{location}`.
TunnelDestGroup:
{:name string, :cidrs [string], :fqdns [string]}

optional:
tunnelDestGroupId <string> Required. The ID to use for the TunnelDestGroup, which becomes the final component of the resource name. This value must be 4-63 characters, and valid characters are `[a-z]-`."
  ([parent TunnelDestGroup]
    (projects-iap_tunnel-locations-destGroups-create
      parent
      TunnelDestGroup
      nil))
  ([parent TunnelDestGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://iap.googleapis.com/v1/{+parent}/destGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TunnelDestGroup})))

(defn projects-iap_tunnel-locations-destGroups-get
  "Retrieves an existing TunnelDestGroup.
https://cloud.google.com/security/products/iap/v1/docs/projects/iap_tunnel/locations/destGroups/get

name <string> Required. Name of the TunnelDestGroup to be fetched. In the following format: `projects/{project_number/id}/iap_tunnel/locations/{location}/destGroups/{dest_group}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://iap.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-iap_tunnel-locations-destGroups-delete
  "Deletes a TunnelDestGroup.
https://cloud.google.com/security/products/iap/v1/docs/projects/iap_tunnel/locations/destGroups/delete

name <string> Required. Name of the TunnelDestGroup to delete. In the following format: `projects/{project_number/id}/iap_tunnel/locations/{location}/destGroups/{dest_group}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://iap.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-iap_tunnel-locations-destGroups-patch
  "Updates a TunnelDestGroup.
https://cloud.google.com/security/products/iap/v1/docs/projects/iap_tunnel/locations/destGroups/patch

name <string> Identifier. Identifier for the TunnelDestGroup. Must be unique within the project and contain only lower case letters (a-z) and dashes (-).
TunnelDestGroup:
{:name string, :cidrs [string], :fqdns [string]}

optional:
updateMask <string> A field mask that specifies which IAP settings to update. If omitted, then all of the settings are updated. See https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name TunnelDestGroup]
    (projects-iap_tunnel-locations-destGroups-patch
      name
      TunnelDestGroup
      nil))
  ([name TunnelDestGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://iap.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TunnelDestGroup})))

(defn projects-brands-list
  "Lists the existing brands for the project.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/list

parent <string> Required. GCP Project number/id. In the following format: projects/{project_number/id}."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template "https://iap.googleapis.com/v1/{+parent}/brands",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-brands-create
  "Constructs a new OAuth brand for the project if one does not exist. The created brand is \"internal only\", meaning that OAuth clients created under it only accept requests from users who belong to the same Google Workspace organization as the project. The brand is created in an un-reviewed status. NOTE: The \"internal only\" status can be manually changed in the Google Cloud Console. Requires that a brand does not already exist for the project, and that the specified support email is owned by the caller.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/create

parent <string> Required. GCP Project number/id under which the brand is to be created. In the following format: projects/{project_number/id}.
Brand:
{:name string,
 :supportEmail string,
 :applicationTitle string,
 :orgInternalOnly boolean}"
  [parent Brand]
  (client/api-request
    {:method "POST",
     :uri-template "https://iap.googleapis.com/v1/{+parent}/brands",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Brand}))

(defn projects-brands-get
  "Retrieves the OAuth brand of the project.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/get

name <string> Required. Name of the brand to be fetched. In the following format: projects/{project_number/id}/brands/{brand}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://iap.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-brands-identityAwareProxyClients-create
  "Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned by IAP. Requires that the brand for the project exists and that it is set for internal-only use.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/identityAwareProxyClients/create

parent <string> Required. Path to create the client in. In the following format: projects/{project_number/id}/brands/{brand}. The project must belong to a G Suite account.
IdentityAwareProxyClient:
{:name string, :secret string, :displayName string}"
  [parent IdentityAwareProxyClient]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://iap.googleapis.com/v1/{+parent}/identityAwareProxyClients",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentityAwareProxyClient}))

(defn projects-brands-identityAwareProxyClients-list
  "Lists the existing clients for the brand.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/identityAwareProxyClients/list

parent <string> Required. Full brand path. In the following format: projects/{project_number/id}/brands/{brand}.

optional:
pageSize <integer> The maximum number of clients to return. The service may return fewer than this value. If unspecified, at most 100 clients will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-brands-identityAwareProxyClients-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://iap.googleapis.com/v1/{+parent}/identityAwareProxyClients",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-brands-identityAwareProxyClients-get
  "Retrieves an Identity Aware Proxy (IAP) OAuth client. Requires that the client is owned by IAP.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/identityAwareProxyClients/get

name <string> Required. Name of the Identity Aware Proxy client to be fetched. In the following format: projects/{project_number/id}/brands/{brand}/identityAwareProxyClients/{client_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://iap.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-brands-identityAwareProxyClients-resetSecret
  "Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the secret was compromised. Requires that the client is owned by IAP.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/identityAwareProxyClients/resetSecret

name <string> Required. Name of the Identity Aware Proxy client to that will have its secret reset. In the following format: projects/{project_number/id}/brands/{brand}/identityAwareProxyClients/{client_id}.
ResetIdentityAwareProxyClientSecretRequest:
object"
  [name ResetIdentityAwareProxyClientSecretRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://iap.googleapis.com/v1/{+name}:resetSecret",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetIdentityAwareProxyClientSecretRequest}))

(defn projects-brands-identityAwareProxyClients-delete
  "Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing obsolete clients, managing the number of clients in a given project, and cleaning up after tests. Requires that the client is owned by IAP.
https://cloud.google.com/security/products/iap/v1/docs/projects/brands/identityAwareProxyClients/delete

name <string> Required. Name of the Identity Aware Proxy client to be deleted. In the following format: projects/{project_number/id}/brands/{brand}/identityAwareProxyClients/{client_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://iap.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

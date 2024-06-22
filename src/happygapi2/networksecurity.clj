(ns happygapi2.networksecurity
  "Network Security API

See: https://cloud.google.com/networking"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/networking

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/networking

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serverTlsPolicies-list
  "Lists ServerTlsPolicies in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the ServerTlsPolicies should be listed, specified in the format `projects/*/locations/{location}`.

optional:
pageSize <integer> Maximum number of ServerTlsPolicies to return per call."
  ([parent] (projects-locations-serverTlsPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/serverTlsPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serverTlsPolicies-get
  "Gets details of a single ServerTlsPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the ServerTlsPolicy to get. Must be in the format `projects/*/locations/{location}/serverTlsPolicies/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serverTlsPolicies-create
  "Creates a new ServerTlsPolicy in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the ServerTlsPolicy. Must be in the format `projects/*/locations/{location}`.
ServerTlsPolicy:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :labels object,
 :allowOpen boolean,
 :serverCertificate
 {:grpcEndpoint {:targetUri string},
  :certificateProviderInstance {:pluginInstance string}},
 :mtlsPolicy
 {:clientValidationMode
  [CLIENT_VALIDATION_MODE_UNSPECIFIED
   ALLOW_INVALID_OR_MISSING_CLIENT_CERT
   REJECT_INVALID],
  :clientValidationCa
  [{:grpcEndpoint {:targetUri string},
    :certificateProviderInstance {:pluginInstance string}}],
  :clientValidationTrustConfig string}}

optional:
serverTlsPolicyId <string> Required. Short name of the ServerTlsPolicy resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"server_mtls_policy\"."
  ([parent ServerTlsPolicy]
    (projects-locations-serverTlsPolicies-create
      parent
      ServerTlsPolicy
      nil))
  ([parent ServerTlsPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/serverTlsPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServerTlsPolicy})))

(defn projects-locations-serverTlsPolicies-patch
  "Updates the parameters of a single ServerTlsPolicy.
https://cloud.google.com/networking

name <string> Required. Name of the ServerTlsPolicy resource. It matches the pattern `projects/*/locations/{location}/serverTlsPolicies/{server_tls_policy}`
ServerTlsPolicy:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :labels object,
 :allowOpen boolean,
 :serverCertificate
 {:grpcEndpoint {:targetUri string},
  :certificateProviderInstance {:pluginInstance string}},
 :mtlsPolicy
 {:clientValidationMode
  [CLIENT_VALIDATION_MODE_UNSPECIFIED
   ALLOW_INVALID_OR_MISSING_CLIENT_CERT
   REJECT_INVALID],
  :clientValidationCa
  [{:grpcEndpoint {:targetUri string},
    :certificateProviderInstance {:pluginInstance string}}],
  :clientValidationTrustConfig string}}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the ServerTlsPolicy resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name ServerTlsPolicy]
    (projects-locations-serverTlsPolicies-patch
      name
      ServerTlsPolicy
      nil))
  ([name ServerTlsPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServerTlsPolicy})))

(defn projects-locations-serverTlsPolicies-delete
  "Deletes a single ServerTlsPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the ServerTlsPolicy to delete. Must be in the format `projects/*/locations/{location}/serverTlsPolicies/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serverTlsPolicies-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-serverTlsPolicies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-serverTlsPolicies-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serverTlsPolicies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-clientTlsPolicies-list
  "Lists ClientTlsPolicies in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the ClientTlsPolicies should be listed, specified in the format `projects/*/locations/{location}`.

optional:
pageSize <integer> Maximum number of ClientTlsPolicies to return per call."
  ([parent] (projects-locations-clientTlsPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/clientTlsPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clientTlsPolicies-get
  "Gets details of a single ClientTlsPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the ClientTlsPolicy to get. Must be in the format `projects/*/locations/{location}/clientTlsPolicies/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-clientTlsPolicies-create
  "Creates a new ClientTlsPolicy in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the ClientTlsPolicy. Must be in the format `projects/*/locations/{location}`.
ClientTlsPolicy:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :labels object,
 :sni string,
 :clientCertificate
 {:grpcEndpoint {:targetUri string},
  :certificateProviderInstance {:pluginInstance string}},
 :serverValidationCa
 [{:grpcEndpoint {:targetUri string},
   :certificateProviderInstance {:pluginInstance string}}]}

optional:
clientTlsPolicyId <string> Required. Short name of the ClientTlsPolicy resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"client_mtls_policy\"."
  ([parent ClientTlsPolicy]
    (projects-locations-clientTlsPolicies-create
      parent
      ClientTlsPolicy
      nil))
  ([parent ClientTlsPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/clientTlsPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ClientTlsPolicy})))

(defn projects-locations-clientTlsPolicies-patch
  "Updates the parameters of a single ClientTlsPolicy.
https://cloud.google.com/networking

name <string> Required. Name of the ClientTlsPolicy resource. It matches the pattern `projects/*/locations/{location}/clientTlsPolicies/{client_tls_policy}`
ClientTlsPolicy:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :labels object,
 :sni string,
 :clientCertificate
 {:grpcEndpoint {:targetUri string},
  :certificateProviderInstance {:pluginInstance string}},
 :serverValidationCa
 [{:grpcEndpoint {:targetUri string},
   :certificateProviderInstance {:pluginInstance string}}]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the ClientTlsPolicy resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name ClientTlsPolicy]
    (projects-locations-clientTlsPolicies-patch
      name
      ClientTlsPolicy
      nil))
  ([name ClientTlsPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ClientTlsPolicy})))

(defn projects-locations-clientTlsPolicies-delete
  "Deletes a single ClientTlsPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the ClientTlsPolicy to delete. Must be in the format `projects/*/locations/{location}/clientTlsPolicies/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-clientTlsPolicies-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-clientTlsPolicies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-clientTlsPolicies-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clientTlsPolicies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-firewallEndpointAssociations-list
  "Lists Associations in a given project and location.
https://cloud.google.com/networking

parent <string> Required. Parent value for ListAssociationsRequest

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results
orderBy <string> Hint for how to order the results"
  ([parent]
    (projects-locations-firewallEndpointAssociations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/firewallEndpointAssociations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-firewallEndpointAssociations-get
  "Gets details of a single FirewallEndpointAssociation.
https://cloud.google.com/networking

name <string> Required. Name of the resource"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-firewallEndpointAssociations-create
  "Creates a new FirewallEndpointAssociation in a given project and location.
https://cloud.google.com/networking

parent <string> Required. Value for parent.
FirewallEndpointAssociation:
{:labels object,
 :disabled boolean,
 :tlsInspectionPolicy string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING INACTIVE],
 :updateTime string,
 :firewallEndpoint string,
 :reconciling boolean,
 :network string}

optional:
firewallEndpointAssociationId <string> Optional. Id of the requesting object. If auto-generating Id server-side, remove this field and firewall_endpoint_association_id from the method_signature of Create RPC.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent FirewallEndpointAssociation]
    (projects-locations-firewallEndpointAssociations-create
      parent
      FirewallEndpointAssociation
      nil))
  ([parent FirewallEndpointAssociation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/firewallEndpointAssociations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body FirewallEndpointAssociation})))

(defn projects-locations-firewallEndpointAssociations-delete
  "Deletes a single FirewallEndpointAssociation.
https://cloud.google.com/networking

name <string> Required. Name of the resource

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-firewallEndpointAssociations-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-firewallEndpointAssociations-patch
  "Update a single FirewallEndpointAssociation.
https://cloud.google.com/networking

name <string> Immutable. Identifier. name of resource
FirewallEndpointAssociation:
{:labels object,
 :disabled boolean,
 :tlsInspectionPolicy string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING INACTIVE],
 :updateTime string,
 :firewallEndpoint string,
 :reconciling boolean,
 :network string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Association resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name FirewallEndpointAssociation]
    (projects-locations-firewallEndpointAssociations-patch
      name
      FirewallEndpointAssociation
      nil))
  ([name FirewallEndpointAssociation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body FirewallEndpointAssociation})))

(defn projects-locations-addressGroups-get
  "Gets details of a single address group.
https://cloud.google.com/networking

name <string> Required. A name of the AddressGroup to get. Must be in the format `projects/*/locations/{location}/addressGroups/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-addressGroups-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-addressGroups-patch
  "Updates the parameters of a single address group.
https://cloud.google.com/networking

name <string> Required. Name of the AddressGroup resource. It matches pattern `projects/*/locations/{location}/addressGroups/`.
AddressGroup:
{:description string,
 :labels object,
 :capacity integer,
 :name string,
 :createTime string,
 :selfLink string,
 :type [TYPE_UNSPECIFIED IPV4 IPV6],
 :updateTime string,
 :items [string]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the AddressGroup resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name AddressGroup]
    (projects-locations-addressGroups-patch name AddressGroup nil))
  ([name AddressGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AddressGroup})))

(defn projects-locations-addressGroups-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-addressGroups-create
  "Creates a new address group in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the AddressGroup. Must be in the format `projects/*/locations/{location}`.
AddressGroup:
{:description string,
 :labels object,
 :capacity integer,
 :name string,
 :createTime string,
 :selfLink string,
 :type [TYPE_UNSPECIFIED IPV4 IPV6],
 :updateTime string,
 :items [string]}

optional:
addressGroupId <string> Required. Short name of the AddressGroup resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"authz_policy\".
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent AddressGroup]
    (projects-locations-addressGroups-create parent AddressGroup nil))
  ([parent AddressGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/addressGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AddressGroup})))

(defn projects-locations-addressGroups-addItems
  "Adds items to an address group.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to add items to. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.
AddAddressGroupItemsRequest:
{:items [string], :requestId string}"
  [addressGroup AddAddressGroupItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+addressGroup}:addItems",
     :uri-template-args {:addressGroup addressGroup},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AddAddressGroupItemsRequest}))

(defn projects-locations-addressGroups-delete
  "Deletes a single address group.
https://cloud.google.com/networking

name <string> Required. A name of the AddressGroup to delete. Must be in the format `projects/*/locations/{location}/addressGroups/*`.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-addressGroups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-addressGroups-listReferences
  "Lists references of an address group.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to clone items to. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.

optional:
pageSize <integer> The maximum number of references to return. If unspecified, server will pick an appropriate default. Server may return fewer items than requested. A caller should only rely on response's next_page_token to determine if there are more AddressGroupUsers left to be queried."
  ([addressGroup]
    (projects-locations-addressGroups-listReferences addressGroup nil))
  ([addressGroup optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+addressGroup}:listReferences",
       :uri-template-args {:addressGroup addressGroup},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-addressGroups-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-addressGroups-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-addressGroups-list
  "Lists address groups in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the AddressGroups should be listed, specified in the format `projects/*/locations/{location}`.

optional:
pageSize <integer> Maximum number of AddressGroups to return per call."
  ([parent] (projects-locations-addressGroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/addressGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-addressGroups-cloneItems
  "Clones items from one address group to another.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to clone items to. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.
CloneAddressGroupItemsRequest:
{:sourceAddressGroup string, :requestId string}"
  [addressGroup CloneAddressGroupItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+addressGroup}:cloneItems",
     :uri-template-args {:addressGroup addressGroup},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CloneAddressGroupItemsRequest}))

(defn projects-locations-addressGroups-removeItems
  "Removes items from an address group.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to remove items from. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.
RemoveAddressGroupItemsRequest:
{:items [string], :requestId string}"
  [addressGroup RemoveAddressGroupItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+addressGroup}:removeItems",
     :uri-template-args {:addressGroup addressGroup},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RemoveAddressGroupItemsRequest}))

(defn projects-locations-authorizationPolicies-list
  "Lists AuthorizationPolicies in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the AuthorizationPolicies should be listed, specified in the format `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Maximum number of AuthorizationPolicies to return per call."
  ([parent] (projects-locations-authorizationPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/authorizationPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-authorizationPolicies-get
  "Gets details of a single AuthorizationPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the AuthorizationPolicy to get. Must be in the format `projects/{project}/locations/{location}/authorizationPolicies/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-authorizationPolicies-create
  "Creates a new AuthorizationPolicy in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the AuthorizationPolicy. Must be in the format `projects/{project}/locations/{location}`.
AuthorizationPolicy:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :labels object,
 :action [ACTION_UNSPECIFIED ALLOW DENY],
 :rules
 [{:sources [{:principals [string], :ipBlocks [string]}],
   :destinations
   [{:hosts [string],
     :ports [integer],
     :methods [string],
     :httpHeaderMatch {:regexMatch string, :headerName string}}]}]}

optional:
authorizationPolicyId <string> Required. Short name of the AuthorizationPolicy resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"authz_policy\"."
  ([parent AuthorizationPolicy]
    (projects-locations-authorizationPolicies-create
      parent
      AuthorizationPolicy
      nil))
  ([parent AuthorizationPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/authorizationPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AuthorizationPolicy})))

(defn projects-locations-authorizationPolicies-patch
  "Updates the parameters of a single AuthorizationPolicy.
https://cloud.google.com/networking

name <string> Required. Name of the AuthorizationPolicy resource. It matches pattern `projects/{project}/locations/{location}/authorizationPolicies/`.
AuthorizationPolicy:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :labels object,
 :action [ACTION_UNSPECIFIED ALLOW DENY],
 :rules
 [{:sources [{:principals [string], :ipBlocks [string]}],
   :destinations
   [{:hosts [string],
     :ports [integer],
     :methods [string],
     :httpHeaderMatch {:regexMatch string, :headerName string}}]}]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the AuthorizationPolicy resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name AuthorizationPolicy]
    (projects-locations-authorizationPolicies-patch
      name
      AuthorizationPolicy
      nil))
  ([name AuthorizationPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AuthorizationPolicy})))

(defn projects-locations-authorizationPolicies-delete
  "Deletes a single AuthorizationPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the AuthorizationPolicy to delete. Must be in the format `projects/{project}/locations/{location}/authorizationPolicies/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-authorizationPolicies-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-authorizationPolicies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-authorizationPolicies-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-authorizationPolicies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/networking

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/networking

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/networking

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/networking

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/networking

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-tlsInspectionPolicies-list
  "Lists TlsInspectionPolicies in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the TlsInspectionPolicies should be listed, specified in the format `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Maximum number of TlsInspectionPolicies to return per call."
  ([parent] (projects-locations-tlsInspectionPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/tlsInspectionPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tlsInspectionPolicies-get
  "Gets details of a single TlsInspectionPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the TlsInspectionPolicy to get. Must be in the format `projects/{project}/locations/{location}/tlsInspectionPolicies/{tls_inspection_policy}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tlsInspectionPolicies-create
  "Creates a new TlsInspectionPolicy in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the TlsInspectionPolicy. Must be in the format `projects/{project}/locations/{location}`.
TlsInspectionPolicy:
{:description string,
 :customTlsFeatures [string],
 :name string,
 :createTime string,
 :excludePublicCaSet boolean,
 :minTlsVersion
 [TLS_VERSION_UNSPECIFIED TLS_1_0 TLS_1_1 TLS_1_2 TLS_1_3],
 :updateTime string,
 :tlsFeatureProfile
 [PROFILE_UNSPECIFIED
  PROFILE_COMPATIBLE
  PROFILE_MODERN
  PROFILE_RESTRICTED
  PROFILE_CUSTOM],
 :trustConfig string,
 :caPool string}

optional:
tlsInspectionPolicyId <string> Required. Short name of the TlsInspectionPolicy resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"tls_inspection_policy1\"."
  ([parent TlsInspectionPolicy]
    (projects-locations-tlsInspectionPolicies-create
      parent
      TlsInspectionPolicy
      nil))
  ([parent TlsInspectionPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/tlsInspectionPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TlsInspectionPolicy})))

(defn projects-locations-tlsInspectionPolicies-patch
  "Updates the parameters of a single TlsInspectionPolicy.
https://cloud.google.com/networking

name <string> Required. Name of the resource. Name is of the form projects/{project}/locations/{location}/tlsInspectionPolicies/{tls_inspection_policy} tls_inspection_policy should match the pattern:(^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
TlsInspectionPolicy:
{:description string,
 :customTlsFeatures [string],
 :name string,
 :createTime string,
 :excludePublicCaSet boolean,
 :minTlsVersion
 [TLS_VERSION_UNSPECIFIED TLS_1_0 TLS_1_1 TLS_1_2 TLS_1_3],
 :updateTime string,
 :tlsFeatureProfile
 [PROFILE_UNSPECIFIED
  PROFILE_COMPATIBLE
  PROFILE_MODERN
  PROFILE_RESTRICTED
  PROFILE_CUSTOM],
 :trustConfig string,
 :caPool string}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the TlsInspectionPolicy resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name TlsInspectionPolicy]
    (projects-locations-tlsInspectionPolicies-patch
      name
      TlsInspectionPolicy
      nil))
  ([name TlsInspectionPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TlsInspectionPolicy})))

(defn projects-locations-tlsInspectionPolicies-delete
  "Deletes a single TlsInspectionPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the TlsInspectionPolicy to delete. Must be in the format `projects/{project}/locations/{location}/tlsInspectionPolicies/{tls_inspection_policy}`.

optional:
force <boolean> If set to true, any rules for this TlsInspectionPolicy will also be deleted. (Otherwise, the request will only work if the TlsInspectionPolicy has no rules.)"
  ([name] (projects-locations-tlsInspectionPolicies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-gatewaySecurityPolicies-list
  "Lists GatewaySecurityPolicies in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the GatewaySecurityPolicies should be listed, specified in the format `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Maximum number of GatewaySecurityPolicies to return per call."
  ([parent]
    (projects-locations-gatewaySecurityPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/gatewaySecurityPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-gatewaySecurityPolicies-get
  "Gets details of a single GatewaySecurityPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the GatewaySecurityPolicy to get. Must be in the format `projects/{project}/locations/{location}/gatewaySecurityPolicies/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-gatewaySecurityPolicies-create
  "Creates a new GatewaySecurityPolicy in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the GatewaySecurityPolicy. Must be in the format `projects/{project}/locations/{location}`.
GatewaySecurityPolicy:
{:name string,
 :createTime string,
 :updateTime string,
 :description string,
 :tlsInspectionPolicy string}

optional:
gatewaySecurityPolicyId <string> Required. Short name of the GatewaySecurityPolicy resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"gateway_security_policy1\"."
  ([parent GatewaySecurityPolicy]
    (projects-locations-gatewaySecurityPolicies-create
      parent
      GatewaySecurityPolicy
      nil))
  ([parent GatewaySecurityPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/gatewaySecurityPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GatewaySecurityPolicy})))

(defn projects-locations-gatewaySecurityPolicies-patch
  "Updates the parameters of a single GatewaySecurityPolicy.
https://cloud.google.com/networking

name <string> Required. Name of the resource. Name is of the form projects/{project}/locations/{location}/gatewaySecurityPolicies/{gateway_security_policy} gateway_security_policy should match the pattern:(^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
GatewaySecurityPolicy:
{:name string,
 :createTime string,
 :updateTime string,
 :description string,
 :tlsInspectionPolicy string}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the GatewaySecurityPolicy resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name GatewaySecurityPolicy]
    (projects-locations-gatewaySecurityPolicies-patch
      name
      GatewaySecurityPolicy
      nil))
  ([name GatewaySecurityPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GatewaySecurityPolicy})))

(defn projects-locations-gatewaySecurityPolicies-delete
  "Deletes a single GatewaySecurityPolicy.
https://cloud.google.com/networking

name <string> Required. A name of the GatewaySecurityPolicy to delete. Must be in the format `projects/{project}/locations/{location}/gatewaySecurityPolicies/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-gatewaySecurityPolicies-rules-list
  "Lists GatewaySecurityPolicyRules in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project, location and GatewaySecurityPolicy from which the GatewaySecurityPolicyRules should be listed, specified in the format `projects/{project}/locations/{location}/gatewaySecurityPolicies/{gatewaySecurityPolicy}`.

optional:
pageSize <integer> Maximum number of GatewaySecurityPolicyRules to return per call."
  ([parent]
    (projects-locations-gatewaySecurityPolicies-rules-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/rules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-gatewaySecurityPolicies-rules-get
  "Gets details of a single GatewaySecurityPolicyRule.
https://cloud.google.com/networking

name <string> Required. The name of the GatewaySecurityPolicyRule to retrieve. Format: projects/{project}/location/{location}/gatewaySecurityPolicies/*/rules/*"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-gatewaySecurityPolicies-rules-create
  "Creates a new GatewaySecurityPolicy in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent where this rule will be created. Format : projects/{project}/location/{location}/gatewaySecurityPolicies/*
GatewaySecurityPolicyRule:
{:description string,
 :name string,
 :createTime string,
 :updateTime string,
 :basicProfile [BASIC_PROFILE_UNSPECIFIED ALLOW DENY],
 :priority integer,
 :sessionMatcher string,
 :tlsInspectionEnabled boolean,
 :applicationMatcher string,
 :enabled boolean}

optional:
gatewaySecurityPolicyRuleId <string> The ID to use for the rule, which will become the final component of the rule's resource name. This value should be 4-63 characters, and valid characters are /a-z-/."
  ([parent GatewaySecurityPolicyRule]
    (projects-locations-gatewaySecurityPolicies-rules-create
      parent
      GatewaySecurityPolicyRule
      nil))
  ([parent GatewaySecurityPolicyRule optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/rules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GatewaySecurityPolicyRule})))

(defn projects-locations-gatewaySecurityPolicies-rules-patch
  "Updates the parameters of a single GatewaySecurityPolicyRule.
https://cloud.google.com/networking

name <string> Required. Immutable. Name of the resource. ame is the full resource name so projects/{project}/locations/{location}/gatewaySecurityPolicies/{gateway_security_policy}/rules/{rule} rule should match the pattern: (^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
GatewaySecurityPolicyRule:
{:description string,
 :name string,
 :createTime string,
 :updateTime string,
 :basicProfile [BASIC_PROFILE_UNSPECIFIED ALLOW DENY],
 :priority integer,
 :sessionMatcher string,
 :tlsInspectionEnabled boolean,
 :applicationMatcher string,
 :enabled boolean}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the GatewaySecurityPolicy resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name GatewaySecurityPolicyRule]
    (projects-locations-gatewaySecurityPolicies-rules-patch
      name
      GatewaySecurityPolicyRule
      nil))
  ([name GatewaySecurityPolicyRule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GatewaySecurityPolicyRule})))

(defn projects-locations-gatewaySecurityPolicies-rules-delete
  "Deletes a single GatewaySecurityPolicyRule.
https://cloud.google.com/networking

name <string> Required. A name of the GatewaySecurityPolicyRule to delete. Must be in the format `projects/{project}/locations/{location}/gatewaySecurityPolicies/{gatewaySecurityPolicy}/rules/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-urlLists-list
  "Lists UrlLists in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the UrlLists should be listed, specified in the format `projects/{project}/locations/{location}`.

optional:
pageSize <integer> Maximum number of UrlLists to return per call."
  ([parent] (projects-locations-urlLists-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/urlLists",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-urlLists-get
  "Gets details of a single UrlList.
https://cloud.google.com/networking

name <string> Required. A name of the UrlList to get. Must be in the format `projects/*/locations/{location}/urlLists/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-urlLists-create
  "Creates a new UrlList in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the UrlList. Must be in the format `projects/*/locations/{location}`.
UrlList:
{:name string,
 :createTime string,
 :updateTime string,
 :description string,
 :values [string]}

optional:
urlListId <string> Required. Short name of the UrlList resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"url_list\"."
  ([parent UrlList]
    (projects-locations-urlLists-create parent UrlList nil))
  ([parent UrlList optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/urlLists",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body UrlList})))

(defn projects-locations-urlLists-patch
  "Updates the parameters of a single UrlList.
https://cloud.google.com/networking

name <string> Required. Name of the resource provided by the user. Name is of the form projects/{project}/locations/{location}/urlLists/{url_list} url_list should match the pattern:(^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$).
UrlList:
{:name string,
 :createTime string,
 :updateTime string,
 :description string,
 :values [string]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the UrlList resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name UrlList] (projects-locations-urlLists-patch name UrlList nil))
  ([name UrlList optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body UrlList})))

(defn projects-locations-urlLists-delete
  "Deletes a single UrlList.
https://cloud.google.com/networking

name <string> Required. A name of the UrlList to delete. Must be in the format `projects/*/locations/{location}/urlLists/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/networking

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (organizations-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/networking

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/networking

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/networking

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn organizations-locations-addressGroups-get
  "Gets details of a single address group.
https://cloud.google.com/networking

name <string> Required. A name of the AddressGroup to get. Must be in the format `projects/*/locations/{location}/addressGroups/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-addressGroups-patch
  "Updates parameters of an address group.
https://cloud.google.com/networking

name <string> Required. Name of the AddressGroup resource. It matches pattern `projects/*/locations/{location}/addressGroups/`.
AddressGroup:
{:description string,
 :labels object,
 :capacity integer,
 :name string,
 :createTime string,
 :selfLink string,
 :type [TYPE_UNSPECIFIED IPV4 IPV6],
 :updateTime string,
 :items [string]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the AddressGroup resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name AddressGroup]
    (organizations-locations-addressGroups-patch
      name
      AddressGroup
      nil))
  ([name AddressGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AddressGroup})))

(defn organizations-locations-addressGroups-create
  "Creates a new address group in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the AddressGroup. Must be in the format `projects/*/locations/{location}`.
AddressGroup:
{:description string,
 :labels object,
 :capacity integer,
 :name string,
 :createTime string,
 :selfLink string,
 :type [TYPE_UNSPECIFIED IPV4 IPV6],
 :updateTime string,
 :items [string]}

optional:
addressGroupId <string> Required. Short name of the AddressGroup resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"authz_policy\".
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent AddressGroup]
    (organizations-locations-addressGroups-create
      parent
      AddressGroup
      nil))
  ([parent AddressGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/addressGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AddressGroup})))

(defn organizations-locations-addressGroups-addItems
  "Adds items to an address group.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to add items to. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.
AddAddressGroupItemsRequest:
{:items [string], :requestId string}"
  [addressGroup AddAddressGroupItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+addressGroup}:addItems",
     :uri-template-args {:addressGroup addressGroup},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AddAddressGroupItemsRequest}))

(defn organizations-locations-addressGroups-delete
  "Deletes an address group.
https://cloud.google.com/networking

name <string> Required. A name of the AddressGroup to delete. Must be in the format `projects/*/locations/{location}/addressGroups/*`.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (organizations-locations-addressGroups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-addressGroups-listReferences
  "Lists references of an address group.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to clone items to. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.

optional:
pageSize <integer> The maximum number of references to return. If unspecified, server will pick an appropriate default. Server may return fewer items than requested. A caller should only rely on response's next_page_token to determine if there are more AddressGroupUsers left to be queried."
  ([addressGroup]
    (organizations-locations-addressGroups-listReferences
      addressGroup
      nil))
  ([addressGroup optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+addressGroup}:listReferences",
       :uri-template-args {:addressGroup addressGroup},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-addressGroups-list
  "Lists address groups in a given project and location.
https://cloud.google.com/networking

parent <string> Required. The project and location from which the AddressGroups should be listed, specified in the format `projects/*/locations/{location}`.

optional:
pageSize <integer> Maximum number of AddressGroups to return per call."
  ([parent] (organizations-locations-addressGroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/addressGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-addressGroups-cloneItems
  "Clones items from one address group to another.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to clone items to. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.
CloneAddressGroupItemsRequest:
{:sourceAddressGroup string, :requestId string}"
  [addressGroup CloneAddressGroupItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+addressGroup}:cloneItems",
     :uri-template-args {:addressGroup addressGroup},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CloneAddressGroupItemsRequest}))

(defn organizations-locations-addressGroups-removeItems
  "Removes items from an address group.
https://cloud.google.com/networking

addressGroup <string> Required. A name of the AddressGroup to remove items from. Must be in the format `projects|organization/*/locations/{location}/addressGroups/*`.
RemoveAddressGroupItemsRequest:
{:items [string], :requestId string}"
  [addressGroup RemoveAddressGroupItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networksecurity.googleapis.com/v1/{+addressGroup}:removeItems",
     :uri-template-args {:addressGroup addressGroup},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RemoveAddressGroupItemsRequest}))

(defn organizations-locations-firewallEndpoints-list
  "Lists FirewallEndpoints in a given project and location.
https://cloud.google.com/networking

parent <string> Required. Parent value for ListEndpointsRequest

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results
orderBy <string> Hint for how to order the results"
  ([parent]
    (organizations-locations-firewallEndpoints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/firewallEndpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-firewallEndpoints-get
  "Gets details of a single Endpoint.
https://cloud.google.com/networking

name <string> Required. Name of the resource"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-firewallEndpoints-create
  "Creates a new FirewallEndpoint in a given project and location.
https://cloud.google.com/networking

parent <string> Required. Value for parent.
FirewallEndpoint:
{:description string,
 :associatedNetworks [string],
 :labels object,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING INACTIVE],
 :associations [{:name string, :network string}],
 :updateTime string,
 :reconciling boolean,
 :billingProjectId string}

optional:
firewallEndpointId <string> Required. Id of the requesting object. If auto-generating Id server-side, remove this field and firewall_endpoint_id from the method_signature of Create RPC.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent FirewallEndpoint]
    (organizations-locations-firewallEndpoints-create
      parent
      FirewallEndpoint
      nil))
  ([parent FirewallEndpoint optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/firewallEndpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body FirewallEndpoint})))

(defn organizations-locations-firewallEndpoints-delete
  "Deletes a single Endpoint.
https://cloud.google.com/networking

name <string> Required. Name of the resource

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (organizations-locations-firewallEndpoints-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-firewallEndpoints-patch
  "Update a single Endpoint.
https://cloud.google.com/networking

name <string> Immutable. Identifier. name of resource
FirewallEndpoint:
{:description string,
 :associatedNetworks [string],
 :labels object,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE DELETING INACTIVE],
 :associations [{:name string, :network string}],
 :updateTime string,
 :reconciling boolean,
 :billingProjectId string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Endpoint resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name FirewallEndpoint]
    (organizations-locations-firewallEndpoints-patch
      name
      FirewallEndpoint
      nil))
  ([name FirewallEndpoint optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body FirewallEndpoint})))

(defn organizations-locations-securityProfileGroups-list
  "Lists SecurityProfileGroups in a given organization and location.
https://cloud.google.com/networking

parent <string> Required. The project or organization and location from which the SecurityProfileGroups should be listed, specified in the format `projects|organizations/*/locations/{location}`.

optional:
pageSize <integer> Maximum number of SecurityProfileGroups to return per call."
  ([parent]
    (organizations-locations-securityProfileGroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/securityProfileGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-securityProfileGroups-get
  "Gets details of a single SecurityProfileGroup.
https://cloud.google.com/networking

name <string> Required. A name of the SecurityProfileGroup to get. Must be in the format `projects|organizations/*/locations/{location}/securityProfileGroups/{security_profile_group}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-securityProfileGroups-create
  "Creates a new SecurityProfileGroup in a given organization and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the SecurityProfileGroup. Must be in the format `projects|organizations/*/locations/{location}`.
SecurityProfileGroup:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :etag string,
 :labels object,
 :threatPreventionProfile string}

optional:
securityProfileGroupId <string> Required. Short name of the SecurityProfileGroup resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"security_profile_group1\"."
  ([parent SecurityProfileGroup]
    (organizations-locations-securityProfileGroups-create
      parent
      SecurityProfileGroup
      nil))
  ([parent SecurityProfileGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/securityProfileGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityProfileGroup})))

(defn organizations-locations-securityProfileGroups-patch
  "Updates the parameters of a single SecurityProfileGroup.
https://cloud.google.com/networking

name <string> Immutable. Identifier. Name of the SecurityProfileGroup resource. It matches pattern `projects|organizations/*/locations/{location}/securityProfileGroups/{security_profile_group}`.
SecurityProfileGroup:
{:name string,
 :description string,
 :createTime string,
 :updateTime string,
 :etag string,
 :labels object,
 :threatPreventionProfile string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the SecurityProfileGroup resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask."
  ([name SecurityProfileGroup]
    (organizations-locations-securityProfileGroups-patch
      name
      SecurityProfileGroup
      nil))
  ([name SecurityProfileGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityProfileGroup})))

(defn organizations-locations-securityProfileGroups-delete
  "Deletes a single SecurityProfileGroup.
https://cloud.google.com/networking

name <string> Required. A name of the SecurityProfileGroup to delete. Must be in the format `projects|organizations/*/locations/{location}/securityProfileGroups/{security_profile_group}`.

optional:
etag <string> Optional. If client provided etag is out of date, delete will return FAILED_PRECONDITION error."
  ([name]
    (organizations-locations-securityProfileGroups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-securityProfiles-list
  "Lists SecurityProfiles in a given organization and location.
https://cloud.google.com/networking

parent <string> Required. The project or organization and location from which the SecurityProfiles should be listed, specified in the format `projects|organizations/*/locations/{location}`.

optional:
pageSize <integer> Maximum number of SecurityProfiles to return per call."
  ([parent] (organizations-locations-securityProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/securityProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-securityProfiles-get
  "Gets details of a single SecurityProfile.
https://cloud.google.com/networking

name <string> Required. A name of the SecurityProfile to get. Must be in the format `projects|organizations/*/locations/{location}/securityProfiles/{security_profile_id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://networksecurity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-securityProfiles-create
  "Creates a new SecurityProfile in a given organization and location.
https://cloud.google.com/networking

parent <string> Required. The parent resource of the SecurityProfile. Must be in the format `projects|organizations/*/locations/{location}`.
SecurityProfile:
{:threatPreventionProfile
 {:severityOverrides
  [{:severity
    [SEVERITY_UNSPECIFIED INFORMATIONAL LOW MEDIUM HIGH CRITICAL],
    :action
    [THREAT_ACTION_UNSPECIFIED DEFAULT_ACTION ALLOW ALERT DENY]}],
  :threatOverrides
  [{:threatId string,
    :type
    [THREAT_TYPE_UNSPECIFIED
     UNKNOWN
     VULNERABILITY
     ANTIVIRUS
     SPYWARE
     DNS],
    :action
    [THREAT_ACTION_UNSPECIFIED DEFAULT_ACTION ALLOW ALERT DENY]}]},
 :name string,
 :description string,
 :createTime string,
 :updateTime string,
 :etag string,
 :labels object,
 :type [PROFILE_TYPE_UNSPECIFIED THREAT_PREVENTION]}

optional:
securityProfileId <string> Required. Short name of the SecurityProfile resource to be created. This value should be 1-63 characters long, containing only letters, numbers, hyphens, and underscores, and should not start with a number. E.g. \"security_profile1\"."
  ([parent SecurityProfile]
    (organizations-locations-securityProfiles-create
      parent
      SecurityProfile
      nil))
  ([parent SecurityProfile optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+parent}/securityProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityProfile})))

(defn organizations-locations-securityProfiles-patch
  "Updates the parameters of a single SecurityProfile.
https://cloud.google.com/networking

name <string> Immutable. Identifier. Name of the SecurityProfile resource. It matches pattern `projects|organizations/*/locations/{location}/securityProfiles/{security_profile}`.
SecurityProfile:
{:threatPreventionProfile
 {:severityOverrides
  [{:severity
    [SEVERITY_UNSPECIFIED INFORMATIONAL LOW MEDIUM HIGH CRITICAL],
    :action
    [THREAT_ACTION_UNSPECIFIED DEFAULT_ACTION ALLOW ALERT DENY]}],
  :threatOverrides
  [{:threatId string,
    :type
    [THREAT_TYPE_UNSPECIFIED
     UNKNOWN
     VULNERABILITY
     ANTIVIRUS
     SPYWARE
     DNS],
    :action
    [THREAT_ACTION_UNSPECIFIED DEFAULT_ACTION ALLOW ALERT DENY]}]},
 :name string,
 :description string,
 :createTime string,
 :updateTime string,
 :etag string,
 :labels object,
 :type [PROFILE_TYPE_UNSPECIFIED THREAT_PREVENTION]}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the SecurityProfile resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask."
  ([name SecurityProfile]
    (organizations-locations-securityProfiles-patch
      name
      SecurityProfile
      nil))
  ([name SecurityProfile optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityProfile})))

(defn organizations-locations-securityProfiles-delete
  "Deletes a single SecurityProfile.
https://cloud.google.com/networking

name <string> Required. A name of the SecurityProfile to delete. Must be in the format `projects|organizations/*/locations/{location}/securityProfiles/{security_profile_id}`.

optional:
etag <string> Optional. If client provided etag is out of date, delete will return FAILED_PRECONDITION error."
  ([name] (organizations-locations-securityProfiles-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networksecurity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

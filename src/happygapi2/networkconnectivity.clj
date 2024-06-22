(ns happygapi2.networkconnectivity
  "Network Connectivity API
This API enables connectivity with and between Google Cloud resources.
See: https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-regionalEndpoints-list
  "Lists RegionalEndpoints in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.regionalEndpoints/list

parent <string> Required. The parent resource's name of the RegionalEndpoint.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> A filter expression that filters the results listed in the response.
orderBy <string> Sort the results by a certain order."
  ([parent] (projects-locations-regionalEndpoints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/regionalEndpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-regionalEndpoints-get
  "Gets details of a single RegionalEndpoint.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.regionalEndpoints/get

name <string> Required. Name of the RegionalEndpoint resource to get. Format: `projects/{project}/locations/{location}/regionalEndpoints/{regional_endpoint}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-regionalEndpoints-create
  "Creates a new RegionalEndpoint in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.regionalEndpoints/create

parent <string> Required. The parent resource's name of the RegionalEndpoint.
RegionalEndpoint:
{:description string,
 :labels object,
 :address string,
 :pscForwardingRule string,
 :accessType [ACCESS_TYPE_UNSPECIFIED GLOBAL REGIONAL],
 :targetGoogleApi string,
 :name string,
 :createTime string,
 :updateTime string,
 :ipAddress string,
 :network string,
 :subnetwork string}

optional:
regionalEndpointId <string> Required. Unique id of the Regional Endpoint to be created.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, ignores the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent RegionalEndpoint]
    (projects-locations-regionalEndpoints-create
      parent
      RegionalEndpoint
      nil))
  ([parent RegionalEndpoint optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/regionalEndpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body RegionalEndpoint})))

(defn projects-locations-regionalEndpoints-delete
  "Deletes a single RegionalEndpoint.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.regionalEndpoints/delete

name <string> Required. The name of the RegionalEndpoint to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, ignores the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-regionalEndpoints-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionPolicies-list
  "Lists ServiceConnectionPolicies in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/list

parent <string> Required. The parent resource's name. ex. projects/123/locations/us-east1

optional:
pageSize <integer> The maximum number of results per page that should be returned.
filter <string> A filter expression that filters the results listed in the response.
orderBy <string> Sort the results by a certain order."
  ([parent]
    (projects-locations-serviceConnectionPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/serviceConnectionPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionPolicies-get
  "Gets details of a single ServiceConnectionPolicy.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/get

name <string> Required. Name of the ServiceConnectionPolicy to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serviceConnectionPolicies-create
  "Creates a new ServiceConnectionPolicy in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/create

parent <string> Required. The parent resource's name of the ServiceConnectionPolicy. ex. projects/123/locations/us-east1
ServiceConnectionPolicy:
{:description string,
 :labels object,
 :name string,
 :createTime string,
 :pscConfig {:subnetworks [string], :limit string},
 :etag string,
 :updateTime string,
 :serviceClass string,
 :pscConnections
 [{:consumerForwardingRule string,
   :pscConnectionId string,
   :consumerAddress string,
   :errorType
   [CONNECTION_ERROR_TYPE_UNSPECIFIED
    ERROR_INTERNAL
    ERROR_CONSUMER_SIDE
    ERROR_PRODUCER_SIDE],
   :state [STATE_UNSPECIFIED ACTIVE FAILED CREATING DELETING],
   :consumerTargetProject string,
   :producerInstanceId string,
   :gceOperation string,
   :error {:code integer, :message string, :details [object]},
   :errorInfo {:reason string, :domain string, :metadata object},
   :selectedSubnetwork string}],
 :network string,
 :infrastructure [INFRASTRUCTURE_UNSPECIFIED PSC]}

optional:
serviceConnectionPolicyId <string> Optional. Resource ID (i.e. 'foo' in '[...]/projects/p/locations/l/serviceConnectionPolicies/foo') See https://google.aip.dev/122#resource-id-segments Unique per location.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ServiceConnectionPolicy]
    (projects-locations-serviceConnectionPolicies-create
      parent
      ServiceConnectionPolicy
      nil))
  ([parent ServiceConnectionPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/serviceConnectionPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServiceConnectionPolicy})))

(defn projects-locations-serviceConnectionPolicies-patch
  "Updates the parameters of a single ServiceConnectionPolicy.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/patch

name <string> Immutable. The name of a ServiceConnectionPolicy. Format: projects/{project}/locations/{location}/serviceConnectionPolicies/{service_connection_policy} See: https://google.aip.dev/122#fields-representing-resource-names
ServiceConnectionPolicy:
{:description string,
 :labels object,
 :name string,
 :createTime string,
 :pscConfig {:subnetworks [string], :limit string},
 :etag string,
 :updateTime string,
 :serviceClass string,
 :pscConnections
 [{:consumerForwardingRule string,
   :pscConnectionId string,
   :consumerAddress string,
   :errorType
   [CONNECTION_ERROR_TYPE_UNSPECIFIED
    ERROR_INTERNAL
    ERROR_CONSUMER_SIDE
    ERROR_PRODUCER_SIDE],
   :state [STATE_UNSPECIFIED ACTIVE FAILED CREATING DELETING],
   :consumerTargetProject string,
   :producerInstanceId string,
   :gceOperation string,
   :error {:code integer, :message string, :details [object]},
   :errorInfo {:reason string, :domain string, :metadata object},
   :selectedSubnetwork string}],
 :network string,
 :infrastructure [INFRASTRUCTURE_UNSPECIFIED PSC]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the ServiceConnectionPolicy resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ServiceConnectionPolicy]
    (projects-locations-serviceConnectionPolicies-patch
      name
      ServiceConnectionPolicy
      nil))
  ([name ServiceConnectionPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServiceConnectionPolicy})))

(defn projects-locations-serviceConnectionPolicies-delete
  "Deletes a single ServiceConnectionPolicy.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/delete

name <string> Required. The name of the ServiceConnectionPolicy to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
etag <string> Optional. The etag is computed by the server, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name]
    (projects-locations-serviceConnectionPolicies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionPolicies-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/setIamPolicy

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
     "https://networkconnectivity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-serviceConnectionPolicies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-serviceConnectionPolicies-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionPolicies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionPolicies/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-global-hubs-listSpokes
  "Lists the Network Connectivity Center spokes associated with a specified hub and location. The list includes both spokes that are attached to the hub and spokes that have been proposed but not yet accepted.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/listSpokes

name <string> Required. The name of the hub.

optional:
spokeLocations <string> A list of locations. Specify one of the following: `[global]`, a single region (for example, `[us-central1]`), or a combination of values (for example, `[global, us-central1, us-west1]`). If the spoke_locations field is populated, the list of results includes only spokes in the specified location. If the spoke_locations field is not populated, the list of results includes spokes in all locations.
pageSize <integer> The maximum number of results to return per page.
filter <string> An expression that filters the list of results.
orderBy <string> Sort the results by name or create_time.
view <string> The view of the spoke to return. The view that you use determines which spoke fields are included in the response."
  ([name] (projects-locations-global-hubs-listSpokes name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}:listSpokes",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-get
  "Gets details about a Network Connectivity Center hub.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/get

name <string> Required. The name of the hub resource to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-hubs-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/setIamPolicy

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
     "https://networkconnectivity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-global-hubs-rejectSpoke
  "Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able to connect to other spokes that are attached to the hub.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/rejectSpoke

name <string> Required. The name of the hub from which to reject the spoke.
RejectHubSpokeRequest:
{:spokeUri string, :requestId string, :details string}"
  [name RejectHubSpokeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}:rejectSpoke",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RejectHubSpokeRequest}))

(defn projects-locations-global-hubs-patch
  "Updates the description and/or labels of a Network Connectivity Center hub.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/patch

name <string> Immutable. The name of the hub. Hub names must be unique. They use the following form: `projects/{project_number}/locations/global/hubs/{hub_id}`
Hub:
{:description string,
 :labels object,
 :spokeSummary
 {:spokeTypeCounts
  [{:spokeType
    [SPOKE_TYPE_UNSPECIFIED
     VPN_TUNNEL
     INTERCONNECT_ATTACHMENT
     ROUTER_APPLIANCE
     VPC_NETWORK],
    :count string}],
  :spokeStateCounts
  [{:state
    [STATE_UNSPECIFIED
     CREATING
     ACTIVE
     DELETING
     ACCEPTING
     REJECTING
     UPDATING
     INACTIVE
     OBSOLETE],
    :count string}],
  :spokeStateReasonCounts
  [{:stateReasonCode
    [CODE_UNSPECIFIED PENDING_REVIEW REJECTED PAUSED FAILED],
    :count string}]},
 :name string,
 :policyMode [POLICY_MODE_UNSPECIFIED PRESET],
 :routingVpcs
 [{:uri string, :requiredForNewSiteToSiteDataTransferSpokes boolean}],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  DELETING
  ACCEPTING
  REJECTING
  UPDATING
  INACTIVE
  OBSOLETE],
 :presetTopology [PRESET_TOPOLOGY_UNSPECIFIED MESH STAR],
 :routeTables [string],
 :updateTime string,
 :exportPsc boolean,
 :uniqueId string}

optional:
updateMask <string> Optional. In the case of an update to an existing hub, field mask is used to specify the fields to be overwritten. The fields specified in the update_mask are relative to the resource, not the full request. A field is overwritten if it is in the mask. If the user does not provide a mask, then all fields are overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check to see whether the original operation was received. If it was, the server ignores the second request. This behavior prevents clients from mistakenly creating duplicate commitments. The request ID must be a valid UUID, with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Hub] (projects-locations-global-hubs-patch name Hub nil))
  ([name Hub optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Hub})))

(defn projects-locations-global-hubs-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-global-hubs-create
  "Creates a new Network Connectivity Center hub in the specified project.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/create

parent <string> Required. The parent resource.
Hub:
{:description string,
 :labels object,
 :spokeSummary
 {:spokeTypeCounts
  [{:spokeType
    [SPOKE_TYPE_UNSPECIFIED
     VPN_TUNNEL
     INTERCONNECT_ATTACHMENT
     ROUTER_APPLIANCE
     VPC_NETWORK],
    :count string}],
  :spokeStateCounts
  [{:state
    [STATE_UNSPECIFIED
     CREATING
     ACTIVE
     DELETING
     ACCEPTING
     REJECTING
     UPDATING
     INACTIVE
     OBSOLETE],
    :count string}],
  :spokeStateReasonCounts
  [{:stateReasonCode
    [CODE_UNSPECIFIED PENDING_REVIEW REJECTED PAUSED FAILED],
    :count string}]},
 :name string,
 :policyMode [POLICY_MODE_UNSPECIFIED PRESET],
 :routingVpcs
 [{:uri string, :requiredForNewSiteToSiteDataTransferSpokes boolean}],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  DELETING
  ACCEPTING
  REJECTING
  UPDATING
  INACTIVE
  OBSOLETE],
 :presetTopology [PRESET_TOPOLOGY_UNSPECIFIED MESH STAR],
 :routeTables [string],
 :updateTime string,
 :exportPsc boolean,
 :uniqueId string}

optional:
hubId <string> Required. A unique identifier for the hub.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check to see whether the original operation was received. If it was, the server ignores the second request. This behavior prevents clients from mistakenly creating duplicate commitments. The request ID must be a valid UUID, with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Hub] (projects-locations-global-hubs-create parent Hub nil))
  ([parent Hub optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/hubs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Hub})))

(defn projects-locations-global-hubs-acceptSpoke
  "Accepts a proposal to attach a Network Connectivity Center spoke to a hub.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/acceptSpoke

name <string> Required. The name of the hub into which to accept the spoke.
AcceptHubSpokeRequest:
{:spokeUri string, :requestId string}"
  [name AcceptHubSpokeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}:acceptSpoke",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AcceptHubSpokeRequest}))

(defn projects-locations-global-hubs-delete
  "Deletes a Network Connectivity Center hub.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/delete

name <string> Required. The name of the hub to delete.

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check to see whether the original operation was received. If it was, the server ignores the second request. This behavior prevents clients from mistakenly creating duplicate commitments. The request ID must be a valid UUID, with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-global-hubs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-global-hubs-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-list
  "Lists the Network Connectivity Center hubs associated with a given project.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs/list

parent <string> Required. The parent resource's name.

optional:
pageSize <integer> The maximum number of results per page to return.
filter <string> An expression that filters the list of results.
orderBy <string> Sort the results by a certain order."
  ([parent] (projects-locations-global-hubs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/hubs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-routeTables-get
  "Gets details about a Network Connectivity Center route table.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.routeTables/get

name <string> Required. The name of the route table resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-hubs-routeTables-list
  "Lists route tables in a given hub.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.routeTables/list

parent <string> Required. The parent resource's name.

optional:
pageSize <integer> The maximum number of results to return per page.
filter <string> An expression that filters the list of results.
orderBy <string> Sort the results by a certain order."
  ([parent]
    (projects-locations-global-hubs-routeTables-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/routeTables",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-routeTables-routes-get
  "Gets details about the specified route.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.routeTables.routes/get

name <string> Required. The name of the route resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-hubs-routeTables-routes-list
  "Lists routes in a given route table.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.routeTables.routes/list

parent <string> Required. The parent resource's name.

optional:
pageSize <integer> The maximum number of results to return per page.
filter <string> An expression that filters the list of results.
orderBy <string> Sort the results by a certain order."
  ([parent]
    (projects-locations-global-hubs-routeTables-routes-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/routes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-groups-get
  "Gets details about a Network Connectivity Center group.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.groups/get

name <string> Required. The name of the route table resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-hubs-groups-list
  "Lists groups in a given hub.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.groups/list

parent <string> Required. The parent resource's name.

optional:
pageSize <integer> The maximum number of results to return per page.
filter <string> An expression that filters the list of results.
orderBy <string> Sort the results by a certain order."
  ([parent] (projects-locations-global-hubs-groups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/groups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-groups-patch
  "Updates the parameters of a Network Connectivity Center group.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.groups/patch

name <string> Immutable. The name of the group. Group names must be unique. They use the following form: `projects/{project_number}/locations/global/hubs/{hub}/groups/{group_id}`
Group:
{:description string,
 :labels object,
 :autoAccept {:autoAcceptProjects [string]},
 :uid string,
 :name string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  DELETING
  ACCEPTING
  REJECTING
  UPDATING
  INACTIVE
  OBSOLETE],
 :updateTime string,
 :routeTable string}

optional:
updateMask <string> Optional. In the case of an update to an existing group, field mask is used to specify the fields to be overwritten. The fields specified in the update_mask are relative to the resource, not the full request. A field is overwritten if it is in the mask. If the user does not provide a mask, then all fields are overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check to see whether the original operation was received. If it was, the server ignores the second request. This behavior prevents clients from mistakenly creating duplicate commitments. The request ID must be a valid UUID, with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Group]
    (projects-locations-global-hubs-groups-patch name Group nil))
  ([name Group optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Group})))

(defn projects-locations-global-hubs-groups-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.groups/setIamPolicy

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
     "https://networkconnectivity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-global-hubs-groups-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.groups/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-global-hubs-groups-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-hubs-groups-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.hubs.groups/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-global-policyBasedRoutes-list
  "Lists policy-based routes in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.policyBasedRoutes/list

parent <string> Required. The parent resource's name.

optional:
pageSize <integer> The maximum number of results per page that should be returned.
filter <string> A filter expression that filters the results listed in the response.
orderBy <string> Sort the results by a certain order."
  ([parent]
    (projects-locations-global-policyBasedRoutes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/policyBasedRoutes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-policyBasedRoutes-get
  "Gets details of a single policy-based route.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.policyBasedRoutes/get

name <string> Required. Name of the PolicyBasedRoute resource to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-policyBasedRoutes-create
  "Creates a new policy-based route in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.policyBasedRoutes/create

parent <string> Required. The parent resource's name of the PolicyBasedRoute.
PolicyBasedRoute:
{:description string,
 :labels object,
 :nextHopIlbIp string,
 :name string,
 :interconnectAttachment {:region string},
 :createTime string,
 :selfLink string,
 :warnings
 [{:code
   [WARNING_UNSPECIFIED RESOURCE_NOT_ACTIVE RESOURCE_BEING_MODIFIED],
   :data object,
   :warningMessage string}],
 :updateTime string,
 :filter
 {:ipProtocol string,
  :srcRange string,
  :destRange string,
  :protocolVersion [PROTOCOL_VERSION_UNSPECIFIED IPV4]},
 :priority integer,
 :kind string,
 :virtualMachine {:tags [string]},
 :network string,
 :nextHopOtherRoutes [OTHER_ROUTES_UNSPECIFIED DEFAULT_ROUTING]}

optional:
policyBasedRouteId <string> Required. Unique id for the policy-based route to create.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, ignores the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent PolicyBasedRoute]
    (projects-locations-global-policyBasedRoutes-create
      parent
      PolicyBasedRoute
      nil))
  ([parent PolicyBasedRoute optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/policyBasedRoutes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PolicyBasedRoute})))

(defn projects-locations-global-policyBasedRoutes-delete
  "Deletes a single policy-based route.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.policyBasedRoutes/delete

name <string> Required. Name of the policy-based route resource to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, ignores the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-global-policyBasedRoutes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-policyBasedRoutes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.policyBasedRoutes/setIamPolicy

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
     "https://networkconnectivity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-global-policyBasedRoutes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.policyBasedRoutes/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-global-policyBasedRoutes-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-policyBasedRoutes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.global.policyBasedRoutes/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-serviceConnectionTokens-get
  "Gets details of a single ServiceConnectionToken.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionTokens/get

name <string> Required. Name of the ServiceConnectionToken to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serviceConnectionTokens-list
  "Lists ServiceConnectionTokens in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionTokens/list

parent <string> Required. The parent resource's name. ex. projects/123/locations/us-east1

optional:
pageSize <integer> The maximum number of results per page that should be returned.
filter <string> A filter expression that filters the results listed in the response.
orderBy <string> Sort the results by a certain order."
  ([parent]
    (projects-locations-serviceConnectionTokens-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/serviceConnectionTokens",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionTokens-create
  "Creates a new ServiceConnectionToken in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionTokens/create

parent <string> Required. The parent resource's name of the ServiceConnectionToken. ex. projects/123/locations/us-east1
ServiceConnectionToken:
{:description string,
 :labels object,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :token string,
 :expireTime string,
 :network string}

optional:
serviceConnectionTokenId <string> Optional. Resource ID (i.e. 'foo' in '[...]/projects/p/locations/l/ServiceConnectionTokens/foo') See https://google.aip.dev/122#resource-id-segments Unique per location. If one is not provided, one will be generated.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ServiceConnectionToken]
    (projects-locations-serviceConnectionTokens-create
      parent
      ServiceConnectionToken
      nil))
  ([parent ServiceConnectionToken optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/serviceConnectionTokens",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServiceConnectionToken})))

(defn projects-locations-serviceConnectionTokens-delete
  "Deletes a single ServiceConnectionToken.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionTokens/delete

name <string> Required. The name of the ServiceConnectionToken to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
etag <string> Optional. The etag is computed by the server, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name] (projects-locations-serviceConnectionTokens-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionMaps-list
  "Lists ServiceConnectionMaps in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/list

parent <string> Required. The parent resource's name. ex. projects/123/locations/us-east1

optional:
pageSize <integer> The maximum number of results per page that should be returned.
filter <string> A filter expression that filters the results listed in the response.
orderBy <string> Sort the results by a certain order."
  ([parent] (projects-locations-serviceConnectionMaps-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/serviceConnectionMaps",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionMaps-get
  "Gets details of a single ServiceConnectionMap.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/get

name <string> Required. Name of the ServiceConnectionMap to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serviceConnectionMaps-create
  "Creates a new ServiceConnectionMap in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/create

parent <string> Required. The parent resource's name of the ServiceConnectionMap. ex. projects/123/locations/us-east1
ServiceConnectionMap:
{:description string,
 :labels object,
 :serviceClassUri string,
 :name string,
 :createTime string,
 :etag string,
 :producerPscConfigs [{:serviceAttachmentUri string}],
 :updateTime string,
 :token string,
 :serviceClass string,
 :consumerPscConfigs
 [{:project string,
   :network string,
   :disableGlobalAccess boolean,
   :state
   [STATE_UNSPECIFIED
    VALID
    CONNECTION_POLICY_MISSING
    POLICY_LIMIT_REACHED],
   :producerInstanceId string,
   :serviceAttachmentIpAddressMap object}],
 :infrastructure [INFRASTRUCTURE_UNSPECIFIED PSC],
 :consumerPscConnections
 [{:ip string,
   :pscConnectionId string,
   :errorType
   [CONNECTION_ERROR_TYPE_UNSPECIFIED
    ERROR_INTERNAL
    ERROR_CONSUMER_SIDE
    ERROR_PRODUCER_SIDE],
   :state [STATE_UNSPECIFIED ACTIVE FAILED CREATING DELETING],
   :project string,
   :producerInstanceId string,
   :gceOperation string,
   :error {:code integer, :message string, :details [object]},
   :forwardingRule string,
   :errorInfo {:reason string, :domain string, :metadata object},
   :network string,
   :selectedSubnetwork string,
   :serviceAttachmentUri string}]}

optional:
serviceConnectionMapId <string> Optional. Resource ID (i.e. 'foo' in '[...]/projects/p/locations/l/serviceConnectionMaps/foo') See https://google.aip.dev/122#resource-id-segments Unique per location. If one is not provided, one will be generated.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ServiceConnectionMap]
    (projects-locations-serviceConnectionMaps-create
      parent
      ServiceConnectionMap
      nil))
  ([parent ServiceConnectionMap optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/serviceConnectionMaps",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServiceConnectionMap})))

(defn projects-locations-serviceConnectionMaps-patch
  "Updates the parameters of a single ServiceConnectionMap.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/patch

name <string> Immutable. The name of a ServiceConnectionMap. Format: projects/{project}/locations/{location}/serviceConnectionMaps/{service_connection_map} See: https://google.aip.dev/122#fields-representing-resource-names
ServiceConnectionMap:
{:description string,
 :labels object,
 :serviceClassUri string,
 :name string,
 :createTime string,
 :etag string,
 :producerPscConfigs [{:serviceAttachmentUri string}],
 :updateTime string,
 :token string,
 :serviceClass string,
 :consumerPscConfigs
 [{:project string,
   :network string,
   :disableGlobalAccess boolean,
   :state
   [STATE_UNSPECIFIED
    VALID
    CONNECTION_POLICY_MISSING
    POLICY_LIMIT_REACHED],
   :producerInstanceId string,
   :serviceAttachmentIpAddressMap object}],
 :infrastructure [INFRASTRUCTURE_UNSPECIFIED PSC],
 :consumerPscConnections
 [{:ip string,
   :pscConnectionId string,
   :errorType
   [CONNECTION_ERROR_TYPE_UNSPECIFIED
    ERROR_INTERNAL
    ERROR_CONSUMER_SIDE
    ERROR_PRODUCER_SIDE],
   :state [STATE_UNSPECIFIED ACTIVE FAILED CREATING DELETING],
   :project string,
   :producerInstanceId string,
   :gceOperation string,
   :error {:code integer, :message string, :details [object]},
   :forwardingRule string,
   :errorInfo {:reason string, :domain string, :metadata object},
   :network string,
   :selectedSubnetwork string,
   :serviceAttachmentUri string}]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the ServiceConnectionMap resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ServiceConnectionMap]
    (projects-locations-serviceConnectionMaps-patch
      name
      ServiceConnectionMap
      nil))
  ([name ServiceConnectionMap optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServiceConnectionMap})))

(defn projects-locations-serviceConnectionMaps-delete
  "Deletes a single ServiceConnectionMap.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/delete

name <string> Required. The name of the ServiceConnectionMap to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
etag <string> Optional. The etag is computed by the server, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name] (projects-locations-serviceConnectionMaps-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionMaps-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/setIamPolicy

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
     "https://networkconnectivity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-serviceConnectionMaps-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-serviceConnectionMaps-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceConnectionMaps-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceConnectionMaps/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-spokes-list
  "Lists the Network Connectivity Center spokes in a specified project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/list

parent <string> Required. The parent resource.

optional:
pageSize <integer> The maximum number of results to return per page.
filter <string> An expression that filters the list of results.
orderBy <string> Sort the results by a certain order."
  ([parent] (projects-locations-spokes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/spokes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-spokes-get
  "Gets details about a Network Connectivity Center spoke.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/get

name <string> Required. The name of the spoke resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-spokes-create
  "Creates a Network Connectivity Center spoke.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/create

parent <string> Required. The parent resource.
Spoke:
{:description string,
 :linkedInterconnectAttachments
 {:uris [string], :siteToSiteDataTransfer boolean, :vpcNetwork string},
 :labels object,
 :spokeType
 [SPOKE_TYPE_UNSPECIFIED
  VPN_TUNNEL
  INTERCONNECT_ATTACHMENT
  ROUTER_APPLIANCE
  VPC_NETWORK],
 :group string,
 :hub string,
 :linkedVpcNetwork
 {:uri string,
  :excludeExportRanges [string],
  :includeExportRanges [string]},
 :name string,
 :reasons
 [{:code [CODE_UNSPECIFIED PENDING_REVIEW REJECTED PAUSED FAILED],
   :message string,
   :userDetails string}],
 :linkedRouterApplianceInstances
 {:instances [{:virtualMachine string, :ipAddress string}],
  :siteToSiteDataTransfer boolean,
  :vpcNetwork string},
 :createTime string,
 :linkedVpnTunnels
 {:uris [string], :siteToSiteDataTransfer boolean, :vpcNetwork string},
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  DELETING
  ACCEPTING
  REJECTING
  UPDATING
  INACTIVE
  OBSOLETE],
 :updateTime string,
 :uniqueId string}

optional:
spokeId <string> Required. Unique id for the spoke to create.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check to see whether the original operation was received. If it was, the server ignores the second request. This behavior prevents clients from mistakenly creating duplicate commitments. The request ID must be a valid UUID, with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Spoke] (projects-locations-spokes-create parent Spoke nil))
  ([parent Spoke optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/spokes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Spoke})))

(defn projects-locations-spokes-patch
  "Updates the parameters of a Network Connectivity Center spoke.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/patch

name <string> Immutable. The name of the spoke. Spoke names must be unique. They use the following form: `projects/{project_number}/locations/{region}/spokes/{spoke_id}`
Spoke:
{:description string,
 :linkedInterconnectAttachments
 {:uris [string], :siteToSiteDataTransfer boolean, :vpcNetwork string},
 :labels object,
 :spokeType
 [SPOKE_TYPE_UNSPECIFIED
  VPN_TUNNEL
  INTERCONNECT_ATTACHMENT
  ROUTER_APPLIANCE
  VPC_NETWORK],
 :group string,
 :hub string,
 :linkedVpcNetwork
 {:uri string,
  :excludeExportRanges [string],
  :includeExportRanges [string]},
 :name string,
 :reasons
 [{:code [CODE_UNSPECIFIED PENDING_REVIEW REJECTED PAUSED FAILED],
   :message string,
   :userDetails string}],
 :linkedRouterApplianceInstances
 {:instances [{:virtualMachine string, :ipAddress string}],
  :siteToSiteDataTransfer boolean,
  :vpcNetwork string},
 :createTime string,
 :linkedVpnTunnels
 {:uris [string], :siteToSiteDataTransfer boolean, :vpcNetwork string},
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  DELETING
  ACCEPTING
  REJECTING
  UPDATING
  INACTIVE
  OBSOLETE],
 :updateTime string,
 :uniqueId string}

optional:
updateMask <string> Optional. In the case of an update to an existing spoke, field mask is used to specify the fields to be overwritten. The fields specified in the update_mask are relative to the resource, not the full request. A field is overwritten if it is in the mask. If the user does not provide a mask, then all fields are overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check to see whether the original operation was received. If it was, the server ignores the second request. This behavior prevents clients from mistakenly creating duplicate commitments. The request ID must be a valid UUID, with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Spoke] (projects-locations-spokes-patch name Spoke nil))
  ([name Spoke optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Spoke})))

(defn projects-locations-spokes-delete
  "Deletes a Network Connectivity Center spoke.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/delete

name <string> Required. The name of the spoke to delete.

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check to see whether the original operation was received. If it was, the server ignores the second request. This behavior prevents clients from mistakenly creating duplicate commitments. The request ID must be a valid UUID, with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-spokes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-spokes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/setIamPolicy

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
     "https://networkconnectivity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-spokes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-spokes-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-spokes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.spokes/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-locations-serviceClasses-list
  "Lists ServiceClasses in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceClasses/list

parent <string> Required. The parent resource's name. ex. projects/123/locations/us-east1

optional:
pageSize <integer> The maximum number of results per page that should be returned.
filter <string> A filter expression that filters the results listed in the response.
orderBy <string> Sort the results by a certain order."
  ([parent] (projects-locations-serviceClasses-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/serviceClasses",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceClasses-get
  "Gets details of a single ServiceClass.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceClasses/get

name <string> Required. Name of the ServiceClass to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-serviceClasses-patch
  "Updates the parameters of a single ServiceClass.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceClasses/patch

name <string> Immutable. The name of a ServiceClass resource. Format: projects/{project}/locations/{location}/serviceClasses/{service_class} See: https://google.aip.dev/122#fields-representing-resource-names
ServiceClass:
{:name string,
 :serviceClass string,
 :createTime string,
 :updateTime string,
 :labels object,
 :description string,
 :etag string}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the ServiceClass resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ServiceClass]
    (projects-locations-serviceClasses-patch name ServiceClass nil))
  ([name ServiceClass optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ServiceClass})))

(defn projects-locations-serviceClasses-delete
  "Deletes a single ServiceClass.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceClasses/delete

name <string> Required. The name of the ServiceClass to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
etag <string> Optional. The etag is computed by the server, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name] (projects-locations-serviceClasses-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceClasses-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceClasses/setIamPolicy

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
     "https://networkconnectivity.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-serviceClasses-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceClasses/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-serviceClasses-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-serviceClasses-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.serviceClasses/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-internalRanges-list
  "Lists internal ranges in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.internalRanges/list

parent <string> Required. The parent resource's name.

optional:
pageSize <integer> The maximum number of results per page that should be returned.
filter <string> A filter expression that filters the results listed in the response.
orderBy <string> Sort the results by a certain order."
  ([parent] (projects-locations-internalRanges-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/internalRanges",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-internalRanges-get
  "Gets details of a single internal range.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.internalRanges/get

name <string> Required. Name of the InternalRange to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkconnectivity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-internalRanges-create
  "Creates a new internal range in a given project and location.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.internalRanges/create

parent <string> Required. The parent resource's name of the internal range.
InternalRange:
{:description string,
 :labels object,
 :targetCidrRange [string],
 :name string,
 :ipCidrRange string,
 :createTime string,
 :peering [PEERING_UNSPECIFIED FOR_SELF FOR_PEER NOT_SHARED],
 :updateTime string,
 :prefixLength integer,
 :usage [USAGE_UNSPECIFIED FOR_VPC EXTERNAL_TO_VPC],
 :overlaps
 [[OVERLAP_UNSPECIFIED
   OVERLAP_ROUTE_RANGE
   OVERLAP_EXISTING_SUBNET_RANGE]],
 :network string,
 :users [string]}

optional:
internalRangeId <string> Optional. Resource ID (i.e. 'foo' in '[...]/projects/p/locations/l/internalRanges/foo') See https://google.aip.dev/122#resource-id-segments Unique per location.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent InternalRange]
    (projects-locations-internalRanges-create
      parent
      InternalRange
      nil))
  ([parent InternalRange optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+parent}/internalRanges",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body InternalRange})))

(defn projects-locations-internalRanges-patch
  "Updates the parameters of a single internal range.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.internalRanges/patch

name <string> Immutable. The name of an internal range. Format: projects/{project}/locations/{location}/internalRanges/{internal_range} See: https://google.aip.dev/122#fields-representing-resource-names
InternalRange:
{:description string,
 :labels object,
 :targetCidrRange [string],
 :name string,
 :ipCidrRange string,
 :createTime string,
 :peering [PEERING_UNSPECIFIED FOR_SELF FOR_PEER NOT_SHARED],
 :updateTime string,
 :prefixLength integer,
 :usage [USAGE_UNSPECIFIED FOR_VPC EXTERNAL_TO_VPC],
 :overlaps
 [[OVERLAP_UNSPECIFIED
   OVERLAP_ROUTE_RANGE
   OVERLAP_EXISTING_SUBNET_RANGE]],
 :network string,
 :users [string]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the InternalRange resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name InternalRange]
    (projects-locations-internalRanges-patch name InternalRange nil))
  ([name InternalRange optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body InternalRange})))

(defn projects-locations-internalRanges-delete
  "Deletes a single internal range.
https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/rest/v1/projects.locations.internalRanges/delete

name <string> Required. The name of the internal range to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-internalRanges-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://networkconnectivity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

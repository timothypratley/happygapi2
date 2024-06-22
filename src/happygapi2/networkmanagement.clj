(ns happygapi2.networkmanagement
  "Network Management API
The Network Management API provides a collection of network performance monitoring and diagnostic capabilities.
See: https://cloud.google.com/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkmanagement.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-global-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkmanagement.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-global-connectivityTests-get
  "Gets the details of a specific Connectivity Test.
https://cloud.google.com

name <string> Required. `ConnectivityTest` resource name using the form: `projects/{project_id}/locations/global/connectivityTests/{test_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-connectivityTests-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com

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
     "https://networkmanagement.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-global-connectivityTests-patch
  "Updates the configuration of an existing `ConnectivityTest`. After you update a test, the reachability analysis is performed as part of the long running operation, which completes when the analysis completes. The Reachability state in the test resource is updated with the new result. If the endpoint specifications in `ConnectivityTest` are invalid (for example, they contain non-existent resources in the network, or the user does not have read permissions to the network configurations of listed projects), then the reachability result returns a value of UNKNOWN. If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result returns a value of `AMBIGUOUS`. See the documentation in `ConnectivityTest` for more details.
https://cloud.google.com

name <string> Identifier. Unique name of the resource using the form: `projects/{project_id}/locations/global/connectivityTests/{test_id}`
ConnectivityTest:
{:description string,
 :labels object,
 :protocol string,
 :displayName string,
 :name string,
 :createTime string,
 :relatedProjects [string],
 :source
 {:loadBalancerId string,
  :instance string,
  :forwardingRuleTarget
  [FORWARDING_RULE_TARGET_UNSPECIFIED
   INSTANCE
   LOAD_BALANCER
   VPN_GATEWAY
   PSC],
  :cloudFunction {:uri string},
  :gkeMasterCluster string,
  :appEngineVersion {:uri string},
  :loadBalancerType
  [LOAD_BALANCER_TYPE_UNSPECIFIED
   HTTPS_ADVANCED_LOAD_BALANCER
   HTTPS_LOAD_BALANCER
   REGIONAL_HTTPS_LOAD_BALANCER
   INTERNAL_HTTPS_LOAD_BALANCER
   SSL_PROXY_LOAD_BALANCER
   TCP_PROXY_LOAD_BALANCER
   INTERNAL_TCP_PROXY_LOAD_BALANCER
   NETWORK_LOAD_BALANCER
   LEGACY_NETWORK_LOAD_BALANCER
   TCP_UDP_INTERNAL_LOAD_BALANCER],
  :port integer,
  :networkType [NETWORK_TYPE_UNSPECIFIED GCP_NETWORK NON_GCP_NETWORK],
  :cloudSqlInstance string,
  :cloudRunRevision {:uri string},
  :forwardingRule string,
  :projectId string,
  :ipAddress string,
  :network string},
 :updateTime string,
 :reachabilityDetails
 {:result
  [RESULT_UNSPECIFIED REACHABLE UNREACHABLE AMBIGUOUS UNDETERMINED],
  :verifyTime string,
  :error {:code integer, :message string, :details [object]},
  :traces
  [{:endpointInfo
    {:sourceIp string,
     :destinationIp string,
     :protocol string,
     :sourcePort integer,
     :destinationPort integer,
     :sourceNetworkUri string,
     :destinationNetworkUri string,
     :sourceAgentUri string},
    :steps
    [{:description string,
      :deliver
      {:target
       [TARGET_UNSPECIFIED
        INSTANCE
        INTERNET
        GOOGLE_API
        GKE_MASTER
        CLOUD_SQL_INSTANCE
        PSC_PUBLISHED_SERVICE
        PSC_GOOGLE_API
        PSC_VPC_SC
        SERVERLESS_NEG
        STORAGE_BUCKET
        PRIVATE_NETWORK
        CLOUD_FUNCTION
        APP_ENGINE_VERSION
        CLOUD_RUN_REVISION
        GOOGLE_MANAGED_SERVICE],
       :resourceUri string,
       :ipAddress string,
       :storageBucket string,
       :pscGoogleApiTarget string},
      :instance
      {:displayName string,
       :uri string,
       :interface string,
       :networkUri string,
       :internalIp string,
       :externalIp string,
       :networkTags [string],
       :serviceAccount string},
      :loadBalancerBackendInfo
      {:instanceUri string,
       :networkEndpointGroupUri string,
       :pscServiceAttachmentUri string,
       :healthCheckUri string,
       :healthCheckFirewallsConfigState
       [HEALTH_CHECK_FIREWALLS_CONFIG_STATE_UNSPECIFIED
        FIREWALLS_CONFIGURED
        FIREWALLS_PARTIALLY_CONFIGURED
        FIREWALLS_NOT_CONFIGURED
        FIREWALLS_UNSUPPORTED],
       :backendBucketUri string,
       :name string,
       :pscGoogleApiTarget string,
       :backendServiceUri string,
       :instanceGroupUri string},
      :loadBalancer
      {:loadBalancerType
       [LOAD_BALANCER_TYPE_UNSPECIFIED
        INTERNAL_TCP_UDP
        NETWORK_TCP_UDP
        HTTP_PROXY
        TCP_PROXY
        SSL_PROXY],
       :healthCheckUri string,
       :backends [LoadBalancerBackend],
       :backendType
       [BACKEND_TYPE_UNSPECIFIED
        BACKEND_SERVICE
        TARGET_POOL
        TARGET_INSTANCE],
       :backendUri string},
      :cloudFunction
      {:displayName string,
       :uri string,
       :location string,
       :versionId string},
      :forward
      {:target
       [TARGET_UNSPECIFIED
        PEERING_VPC
        VPN_GATEWAY
        INTERCONNECT
        GKE_MASTER
        IMPORTED_CUSTOM_ROUTE_NEXT_HOP
        CLOUD_SQL_INSTANCE
        ANOTHER_PROJECT
        NCC_HUB
        ROUTER_APPLIANCE],
       :resourceUri string,
       :ipAddress string},
      :nat
      {:natGatewayName string,
       :protocol string,
       :newDestinationIp string,
       :type
       [TYPE_UNSPECIFIED
        INTERNAL_TO_EXTERNAL
        EXTERNAL_TO_INTERNAL
        CLOUD_NAT
        PRIVATE_SERVICE_CONNECT],
       :oldSourceIp string,
       :oldDestinationPort integer,
       :newSourcePort integer,
       :oldSourcePort integer,
       :networkUri string,
       :newSourceIp string,
       :newDestinationPort integer,
       :oldDestinationIp string,
       :routerUri string},
      :drop
      {:cause
       [CAUSE_UNSPECIFIED
        UNKNOWN_EXTERNAL_ADDRESS
        FOREIGN_IP_DISALLOWED
        FIREWALL_RULE
        NO_ROUTE
        ROUTE_BLACKHOLE
        ROUTE_WRONG_NETWORK
        ROUTE_NEXT_HOP_IP_ADDRESS_NOT_RESOLVED
        ROUTE_NEXT_HOP_RESOURCE_NOT_FOUND
        ROUTE_NEXT_HOP_INSTANCE_WRONG_NETWORK
        ROUTE_NEXT_HOP_INSTANCE_NON_PRIMARY_IP
        ROUTE_NEXT_HOP_FORWARDING_RULE_IP_MISMATCH
        ROUTE_NEXT_HOP_VPN_TUNNEL_NOT_ESTABLISHED
        ROUTE_NEXT_HOP_FORWARDING_RULE_TYPE_INVALID
        NO_ROUTE_FROM_INTERNET_TO_PRIVATE_IPV6_ADDRESS
        VPN_TUNNEL_LOCAL_SELECTOR_MISMATCH
        VPN_TUNNEL_REMOTE_SELECTOR_MISMATCH
        PRIVATE_TRAFFIC_TO_INTERNET
        PRIVATE_GOOGLE_ACCESS_DISALLOWED
        PRIVATE_GOOGLE_ACCESS_VIA_VPN_TUNNEL_UNSUPPORTED
        NO_EXTERNAL_ADDRESS
        UNKNOWN_INTERNAL_ADDRESS
        FORWARDING_RULE_MISMATCH
        FORWARDING_RULE_NO_INSTANCES
        FIREWALL_BLOCKING_LOAD_BALANCER_BACKEND_HEALTH_CHECK
        INSTANCE_NOT_RUNNING
        GKE_CLUSTER_NOT_RUNNING
        CLOUD_SQL_INSTANCE_NOT_RUNNING
        TRAFFIC_TYPE_BLOCKED
        GKE_MASTER_UNAUTHORIZED_ACCESS
        CLOUD_SQL_INSTANCE_UNAUTHORIZED_ACCESS
        DROPPED_INSIDE_GKE_SERVICE
        DROPPED_INSIDE_CLOUD_SQL_SERVICE
        GOOGLE_MANAGED_SERVICE_NO_PEERING
        GOOGLE_MANAGED_SERVICE_NO_PSC_ENDPOINT
        GKE_PSC_ENDPOINT_MISSING
        CLOUD_SQL_INSTANCE_NO_IP_ADDRESS
        GKE_CONTROL_PLANE_REGION_MISMATCH
        PUBLIC_GKE_CONTROL_PLANE_TO_PRIVATE_DESTINATION
        GKE_CONTROL_PLANE_NO_ROUTE
        CLOUD_SQL_INSTANCE_NOT_CONFIGURED_FOR_EXTERNAL_TRAFFIC
        PUBLIC_CLOUD_SQL_INSTANCE_TO_PRIVATE_DESTINATION
        CLOUD_SQL_INSTANCE_NO_ROUTE
        CLOUD_SQL_CONNECTOR_REQUIRED
        CLOUD_FUNCTION_NOT_ACTIVE
        VPC_CONNECTOR_NOT_SET
        VPC_CONNECTOR_NOT_RUNNING
        VPC_CONNECTOR_SERVERLESS_TRAFFIC_BLOCKED
        VPC_CONNECTOR_HEALTH_CHECK_TRAFFIC_BLOCKED
        FORWARDING_RULE_REGION_MISMATCH
        PSC_CONNECTION_NOT_ACCEPTED
        PSC_ENDPOINT_ACCESSED_FROM_PEERED_NETWORK
        PSC_NEG_PRODUCER_ENDPOINT_NO_GLOBAL_ACCESS
        PSC_NEG_PRODUCER_FORWARDING_RULE_MULTIPLE_PORTS
        CLOUD_SQL_PSC_NEG_UNSUPPORTED
        NO_NAT_SUBNETS_FOR_PSC_SERVICE_ATTACHMENT
        PSC_TRANSITIVITY_NOT_PROPAGATED
        HYBRID_NEG_NON_DYNAMIC_ROUTE_MATCHED
        HYBRID_NEG_NON_LOCAL_DYNAMIC_ROUTE_MATCHED
        CLOUD_RUN_REVISION_NOT_READY
        DROPPED_INSIDE_PSC_SERVICE_PRODUCER
        LOAD_BALANCER_HAS_NO_PROXY_SUBNET
        CLOUD_NAT_NO_ADDRESSES
        ROUTING_LOOP
        DROPPED_INSIDE_GOOGLE_MANAGED_SERVICE],
       :resourceUri string,
       :sourceIp string,
       :destinationIp string,
       :region string},
      :causesDrop boolean,
      :appEngineVersion
      {:displayName string,
       :uri string,
       :runtime string,
       :environment string},
      :state
      [STATE_UNSPECIFIED
       START_FROM_INSTANCE
       START_FROM_INTERNET
       START_FROM_GOOGLE_SERVICE
       START_FROM_PRIVATE_NETWORK
       START_FROM_GKE_MASTER
       START_FROM_CLOUD_SQL_INSTANCE
       START_FROM_CLOUD_FUNCTION
       START_FROM_APP_ENGINE_VERSION
       START_FROM_CLOUD_RUN_REVISION
       START_FROM_STORAGE_BUCKET
       START_FROM_PSC_PUBLISHED_SERVICE
       START_FROM_SERVERLESS_NEG
       APPLY_INGRESS_FIREWALL_RULE
       APPLY_EGRESS_FIREWALL_RULE
       APPLY_ROUTE
       APPLY_FORWARDING_RULE
       ANALYZE_LOAD_BALANCER_BACKEND
       SPOOFING_APPROVED
       ARRIVE_AT_INSTANCE
       ARRIVE_AT_INTERNAL_LOAD_BALANCER
       ARRIVE_AT_EXTERNAL_LOAD_BALANCER
       ARRIVE_AT_VPN_GATEWAY
       ARRIVE_AT_VPN_TUNNEL
       ARRIVE_AT_VPC_CONNECTOR
       NAT
       PROXY_CONNECTION
       DELIVER
       DROP
       FORWARD
       ABORT
       VIEWER_PERMISSION_MISSING],
      :route
      {:routeScope [ROUTE_SCOPE_UNSPECIFIED NETWORK NCC_HUB],
       :destPortRanges [string],
       :destIpRange string,
       :nccHubUri string,
       :displayName string,
       :protocols [string],
       :srcPortRanges [string],
       :nextHopType
       [NEXT_HOP_TYPE_UNSPECIFIED
        NEXT_HOP_IP
        NEXT_HOP_INSTANCE
        NEXT_HOP_NETWORK
        NEXT_HOP_PEERING
        NEXT_HOP_INTERCONNECT
        NEXT_HOP_VPN_TUNNEL
        NEXT_HOP_VPN_GATEWAY
        NEXT_HOP_INTERNET_GATEWAY
        NEXT_HOP_BLACKHOLE
        NEXT_HOP_ILB
        NEXT_HOP_ROUTER_APPLIANCE
        NEXT_HOP_NCC_HUB],
       :priority integer,
       :networkUri string,
       :nextHop string,
       :uri string,
       :srcIpRange string,
       :instanceTags [string],
       :nccSpokeUri string,
       :routeType
       [ROUTE_TYPE_UNSPECIFIED
        SUBNET
        STATIC
        DYNAMIC
        PEERING_SUBNET
        PEERING_STATIC
        PEERING_DYNAMIC
        POLICY_BASED]},
      :abort
      {:cause
       [CAUSE_UNSPECIFIED
        UNKNOWN_NETWORK
        UNKNOWN_PROJECT
        NO_EXTERNAL_IP
        UNINTENDED_DESTINATION
        SOURCE_ENDPOINT_NOT_FOUND
        MISMATCHED_SOURCE_NETWORK
        DESTINATION_ENDPOINT_NOT_FOUND
        MISMATCHED_DESTINATION_NETWORK
        UNKNOWN_IP
        GOOGLE_MANAGED_SERVICE_UNKNOWN_IP
        SOURCE_IP_ADDRESS_NOT_IN_SOURCE_NETWORK
        PERMISSION_DENIED
        PERMISSION_DENIED_NO_CLOUD_NAT_CONFIGS
        PERMISSION_DENIED_NO_NEG_ENDPOINT_CONFIGS
        NO_SOURCE_LOCATION
        INVALID_ARGUMENT
        TRACE_TOO_LONG
        INTERNAL_ERROR
        UNSUPPORTED
        MISMATCHED_IP_VERSION
        GKE_KONNECTIVITY_PROXY_UNSUPPORTED
        RESOURCE_CONFIG_NOT_FOUND
        VM_INSTANCE_CONFIG_NOT_FOUND
        NETWORK_CONFIG_NOT_FOUND
        FIREWALL_CONFIG_NOT_FOUND
        ROUTE_CONFIG_NOT_FOUND
        GOOGLE_MANAGED_SERVICE_AMBIGUOUS_PSC_ENDPOINT
        SOURCE_PSC_CLOUD_SQL_UNSUPPORTED
        SOURCE_FORWARDING_RULE_UNSUPPORTED
        NON_ROUTABLE_IP_ADDRESS
        UNKNOWN_ISSUE_IN_GOOGLE_MANAGED_PROJECT
        UNSUPPORTED_GOOGLE_MANAGED_PROJECT_CONFIG],
       :resourceUri string,
       :ipAddress string,
       :projectsMissingPermission [string]},
      :vpcConnector
      {:displayName string, :uri string, :location string},
      :proxyConnection
      {:protocol string,
       :newDestinationIp string,
       :subnetUri string,
       :oldSourceIp string,
       :oldDestinationPort integer,
       :newSourcePort integer,
       :oldSourcePort integer,
       :networkUri string,
       :newSourceIp string,
       :newDestinationPort integer,
       :oldDestinationIp string},
      :vpnTunnel
      {:sourceGatewayIp string,
       :remoteGatewayIp string,
       :displayName string,
       :region string,
       :networkUri string,
       :uri string,
       :remoteGateway string,
       :sourceGateway string,
       :routingType
       [ROUTING_TYPE_UNSPECIFIED ROUTE_BASED POLICY_BASED DYNAMIC]},
      :serverlessNeg {:negUri string},
      :cloudSqlInstance
      {:displayName string,
       :uri string,
       :networkUri string,
       :internalIp string,
       :externalIp string,
       :region string},
      :firewall
      {:displayName string,
       :targetTags [string],
       :policy string,
       :priority integer,
       :networkUri string,
       :targetServiceAccounts [string],
       :action string,
       :uri string,
       :firewallRuleType
       [FIREWALL_RULE_TYPE_UNSPECIFIED
        HIERARCHICAL_FIREWALL_POLICY_RULE
        VPC_FIREWALL_RULE
        IMPLIED_VPC_FIREWALL_RULE
        SERVERLESS_VPC_ACCESS_MANAGED_FIREWALL_RULE
        NETWORK_FIREWALL_POLICY_RULE
        NETWORK_REGIONAL_FIREWALL_POLICY_RULE
        UNSUPPORTED_FIREWALL_POLICY_RULE
        TRACKING_STATE],
       :direction string},
      :cloudRunRevision
      {:displayName string,
       :uri string,
       :location string,
       :serviceUri string},
      :forwardingRule
      {:pscServiceAttachmentUri string,
       :matchedPortRange string,
       :displayName string,
       :loadBalancerName string,
       :matchedProtocol string,
       :region string,
       :pscGoogleApiTarget string,
       :vip string,
       :networkUri string,
       :uri string,
       :target string},
      :projectId string,
      :googleService
      {:sourceIp string,
       :googleServiceType
       [GOOGLE_SERVICE_TYPE_UNSPECIFIED
        IAP
        GFE_PROXY_OR_HEALTH_CHECK_PROBER
        CLOUD_DNS
        GOOGLE_API
        GOOGLE_API_PSC
        GOOGLE_API_VPC_SC]},
      :storageBucket {:bucket string},
      :vpnGateway
      {:displayName string,
       :uri string,
       :networkUri string,
       :ipAddress string,
       :vpnTunnelUri string,
       :region string},
      :network
      {:displayName string, :uri string, :matchedIpRange string},
      :gkeMaster
      {:clusterUri string,
       :clusterNetworkUri string,
       :internalIp string,
       :externalIp string},
      :endpoint
      {:sourceIp string,
       :destinationIp string,
       :protocol string,
       :sourcePort integer,
       :destinationPort integer,
       :sourceNetworkUri string,
       :destinationNetworkUri string,
       :sourceAgentUri string}}],
    :forwardTraceId integer}]},
 :probingDetails
 {:abortCause
  [PROBING_ABORT_CAUSE_UNSPECIFIED
   PERMISSION_DENIED
   NO_SOURCE_LOCATION],
  :endpointInfo
  {:sourceIp string,
   :destinationIp string,
   :protocol string,
   :sourcePort integer,
   :destinationPort integer,
   :sourceNetworkUri string,
   :destinationNetworkUri string,
   :sourceAgentUri string},
  :result
  [PROBING_RESULT_UNSPECIFIED
   REACHABLE
   UNREACHABLE
   REACHABILITY_INCONSISTENT
   UNDETERMINED],
  :successfulProbeCount integer,
  :probingLatency
  {:latencyPercentiles [{:percent integer, :latencyMicros string}]},
  :error {:code integer, :message string, :details [object]},
  :destinationEgressLocation {:metropolitanArea string},
  :sentProbeCount integer,
  :verifyTime string},
 :bypassFirewallChecks boolean,
 :destination
 {:loadBalancerId string,
  :instance string,
  :forwardingRuleTarget
  [FORWARDING_RULE_TARGET_UNSPECIFIED
   INSTANCE
   LOAD_BALANCER
   VPN_GATEWAY
   PSC],
  :cloudFunction {:uri string},
  :gkeMasterCluster string,
  :appEngineVersion {:uri string},
  :loadBalancerType
  [LOAD_BALANCER_TYPE_UNSPECIFIED
   HTTPS_ADVANCED_LOAD_BALANCER
   HTTPS_LOAD_BALANCER
   REGIONAL_HTTPS_LOAD_BALANCER
   INTERNAL_HTTPS_LOAD_BALANCER
   SSL_PROXY_LOAD_BALANCER
   TCP_PROXY_LOAD_BALANCER
   INTERNAL_TCP_PROXY_LOAD_BALANCER
   NETWORK_LOAD_BALANCER
   LEGACY_NETWORK_LOAD_BALANCER
   TCP_UDP_INTERNAL_LOAD_BALANCER],
  :port integer,
  :networkType [NETWORK_TYPE_UNSPECIFIED GCP_NETWORK NON_GCP_NETWORK],
  :cloudSqlInstance string,
  :cloudRunRevision {:uri string},
  :forwardingRule string,
  :projectId string,
  :ipAddress string,
  :network string}}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field."
  ([name ConnectivityTest]
    (projects-locations-global-connectivityTests-patch
      name
      ConnectivityTest
      nil))
  ([name ConnectivityTest optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://networkmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ConnectivityTest})))

(defn projects-locations-global-connectivityTests-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-global-connectivityTests-create
  "Creates a new Connectivity Test. After you create a test, the reachability analysis is performed as part of the long running operation, which completes when the analysis completes. If the endpoint specifications in `ConnectivityTest` are invalid (for example, containing non-existent resources in the network, or you don't have read permissions to the network configurations of listed projects), then the reachability result returns a value of `UNKNOWN`. If the endpoint specifications in `ConnectivityTest` are incomplete, the reachability result returns a value of AMBIGUOUS. For more information, see the Connectivity Test documentation.
https://cloud.google.com

parent <string> Required. The parent resource of the Connectivity Test to create: `projects/{project_id}/locations/global`
ConnectivityTest:
{:description string,
 :labels object,
 :protocol string,
 :displayName string,
 :name string,
 :createTime string,
 :relatedProjects [string],
 :source
 {:loadBalancerId string,
  :instance string,
  :forwardingRuleTarget
  [FORWARDING_RULE_TARGET_UNSPECIFIED
   INSTANCE
   LOAD_BALANCER
   VPN_GATEWAY
   PSC],
  :cloudFunction {:uri string},
  :gkeMasterCluster string,
  :appEngineVersion {:uri string},
  :loadBalancerType
  [LOAD_BALANCER_TYPE_UNSPECIFIED
   HTTPS_ADVANCED_LOAD_BALANCER
   HTTPS_LOAD_BALANCER
   REGIONAL_HTTPS_LOAD_BALANCER
   INTERNAL_HTTPS_LOAD_BALANCER
   SSL_PROXY_LOAD_BALANCER
   TCP_PROXY_LOAD_BALANCER
   INTERNAL_TCP_PROXY_LOAD_BALANCER
   NETWORK_LOAD_BALANCER
   LEGACY_NETWORK_LOAD_BALANCER
   TCP_UDP_INTERNAL_LOAD_BALANCER],
  :port integer,
  :networkType [NETWORK_TYPE_UNSPECIFIED GCP_NETWORK NON_GCP_NETWORK],
  :cloudSqlInstance string,
  :cloudRunRevision {:uri string},
  :forwardingRule string,
  :projectId string,
  :ipAddress string,
  :network string},
 :updateTime string,
 :reachabilityDetails
 {:result
  [RESULT_UNSPECIFIED REACHABLE UNREACHABLE AMBIGUOUS UNDETERMINED],
  :verifyTime string,
  :error {:code integer, :message string, :details [object]},
  :traces
  [{:endpointInfo
    {:sourceIp string,
     :destinationIp string,
     :protocol string,
     :sourcePort integer,
     :destinationPort integer,
     :sourceNetworkUri string,
     :destinationNetworkUri string,
     :sourceAgentUri string},
    :steps
    [{:description string,
      :deliver
      {:target
       [TARGET_UNSPECIFIED
        INSTANCE
        INTERNET
        GOOGLE_API
        GKE_MASTER
        CLOUD_SQL_INSTANCE
        PSC_PUBLISHED_SERVICE
        PSC_GOOGLE_API
        PSC_VPC_SC
        SERVERLESS_NEG
        STORAGE_BUCKET
        PRIVATE_NETWORK
        CLOUD_FUNCTION
        APP_ENGINE_VERSION
        CLOUD_RUN_REVISION
        GOOGLE_MANAGED_SERVICE],
       :resourceUri string,
       :ipAddress string,
       :storageBucket string,
       :pscGoogleApiTarget string},
      :instance
      {:displayName string,
       :uri string,
       :interface string,
       :networkUri string,
       :internalIp string,
       :externalIp string,
       :networkTags [string],
       :serviceAccount string},
      :loadBalancerBackendInfo
      {:instanceUri string,
       :networkEndpointGroupUri string,
       :pscServiceAttachmentUri string,
       :healthCheckUri string,
       :healthCheckFirewallsConfigState
       [HEALTH_CHECK_FIREWALLS_CONFIG_STATE_UNSPECIFIED
        FIREWALLS_CONFIGURED
        FIREWALLS_PARTIALLY_CONFIGURED
        FIREWALLS_NOT_CONFIGURED
        FIREWALLS_UNSUPPORTED],
       :backendBucketUri string,
       :name string,
       :pscGoogleApiTarget string,
       :backendServiceUri string,
       :instanceGroupUri string},
      :loadBalancer
      {:loadBalancerType
       [LOAD_BALANCER_TYPE_UNSPECIFIED
        INTERNAL_TCP_UDP
        NETWORK_TCP_UDP
        HTTP_PROXY
        TCP_PROXY
        SSL_PROXY],
       :healthCheckUri string,
       :backends [LoadBalancerBackend],
       :backendType
       [BACKEND_TYPE_UNSPECIFIED
        BACKEND_SERVICE
        TARGET_POOL
        TARGET_INSTANCE],
       :backendUri string},
      :cloudFunction
      {:displayName string,
       :uri string,
       :location string,
       :versionId string},
      :forward
      {:target
       [TARGET_UNSPECIFIED
        PEERING_VPC
        VPN_GATEWAY
        INTERCONNECT
        GKE_MASTER
        IMPORTED_CUSTOM_ROUTE_NEXT_HOP
        CLOUD_SQL_INSTANCE
        ANOTHER_PROJECT
        NCC_HUB
        ROUTER_APPLIANCE],
       :resourceUri string,
       :ipAddress string},
      :nat
      {:natGatewayName string,
       :protocol string,
       :newDestinationIp string,
       :type
       [TYPE_UNSPECIFIED
        INTERNAL_TO_EXTERNAL
        EXTERNAL_TO_INTERNAL
        CLOUD_NAT
        PRIVATE_SERVICE_CONNECT],
       :oldSourceIp string,
       :oldDestinationPort integer,
       :newSourcePort integer,
       :oldSourcePort integer,
       :networkUri string,
       :newSourceIp string,
       :newDestinationPort integer,
       :oldDestinationIp string,
       :routerUri string},
      :drop
      {:cause
       [CAUSE_UNSPECIFIED
        UNKNOWN_EXTERNAL_ADDRESS
        FOREIGN_IP_DISALLOWED
        FIREWALL_RULE
        NO_ROUTE
        ROUTE_BLACKHOLE
        ROUTE_WRONG_NETWORK
        ROUTE_NEXT_HOP_IP_ADDRESS_NOT_RESOLVED
        ROUTE_NEXT_HOP_RESOURCE_NOT_FOUND
        ROUTE_NEXT_HOP_INSTANCE_WRONG_NETWORK
        ROUTE_NEXT_HOP_INSTANCE_NON_PRIMARY_IP
        ROUTE_NEXT_HOP_FORWARDING_RULE_IP_MISMATCH
        ROUTE_NEXT_HOP_VPN_TUNNEL_NOT_ESTABLISHED
        ROUTE_NEXT_HOP_FORWARDING_RULE_TYPE_INVALID
        NO_ROUTE_FROM_INTERNET_TO_PRIVATE_IPV6_ADDRESS
        VPN_TUNNEL_LOCAL_SELECTOR_MISMATCH
        VPN_TUNNEL_REMOTE_SELECTOR_MISMATCH
        PRIVATE_TRAFFIC_TO_INTERNET
        PRIVATE_GOOGLE_ACCESS_DISALLOWED
        PRIVATE_GOOGLE_ACCESS_VIA_VPN_TUNNEL_UNSUPPORTED
        NO_EXTERNAL_ADDRESS
        UNKNOWN_INTERNAL_ADDRESS
        FORWARDING_RULE_MISMATCH
        FORWARDING_RULE_NO_INSTANCES
        FIREWALL_BLOCKING_LOAD_BALANCER_BACKEND_HEALTH_CHECK
        INSTANCE_NOT_RUNNING
        GKE_CLUSTER_NOT_RUNNING
        CLOUD_SQL_INSTANCE_NOT_RUNNING
        TRAFFIC_TYPE_BLOCKED
        GKE_MASTER_UNAUTHORIZED_ACCESS
        CLOUD_SQL_INSTANCE_UNAUTHORIZED_ACCESS
        DROPPED_INSIDE_GKE_SERVICE
        DROPPED_INSIDE_CLOUD_SQL_SERVICE
        GOOGLE_MANAGED_SERVICE_NO_PEERING
        GOOGLE_MANAGED_SERVICE_NO_PSC_ENDPOINT
        GKE_PSC_ENDPOINT_MISSING
        CLOUD_SQL_INSTANCE_NO_IP_ADDRESS
        GKE_CONTROL_PLANE_REGION_MISMATCH
        PUBLIC_GKE_CONTROL_PLANE_TO_PRIVATE_DESTINATION
        GKE_CONTROL_PLANE_NO_ROUTE
        CLOUD_SQL_INSTANCE_NOT_CONFIGURED_FOR_EXTERNAL_TRAFFIC
        PUBLIC_CLOUD_SQL_INSTANCE_TO_PRIVATE_DESTINATION
        CLOUD_SQL_INSTANCE_NO_ROUTE
        CLOUD_SQL_CONNECTOR_REQUIRED
        CLOUD_FUNCTION_NOT_ACTIVE
        VPC_CONNECTOR_NOT_SET
        VPC_CONNECTOR_NOT_RUNNING
        VPC_CONNECTOR_SERVERLESS_TRAFFIC_BLOCKED
        VPC_CONNECTOR_HEALTH_CHECK_TRAFFIC_BLOCKED
        FORWARDING_RULE_REGION_MISMATCH
        PSC_CONNECTION_NOT_ACCEPTED
        PSC_ENDPOINT_ACCESSED_FROM_PEERED_NETWORK
        PSC_NEG_PRODUCER_ENDPOINT_NO_GLOBAL_ACCESS
        PSC_NEG_PRODUCER_FORWARDING_RULE_MULTIPLE_PORTS
        CLOUD_SQL_PSC_NEG_UNSUPPORTED
        NO_NAT_SUBNETS_FOR_PSC_SERVICE_ATTACHMENT
        PSC_TRANSITIVITY_NOT_PROPAGATED
        HYBRID_NEG_NON_DYNAMIC_ROUTE_MATCHED
        HYBRID_NEG_NON_LOCAL_DYNAMIC_ROUTE_MATCHED
        CLOUD_RUN_REVISION_NOT_READY
        DROPPED_INSIDE_PSC_SERVICE_PRODUCER
        LOAD_BALANCER_HAS_NO_PROXY_SUBNET
        CLOUD_NAT_NO_ADDRESSES
        ROUTING_LOOP
        DROPPED_INSIDE_GOOGLE_MANAGED_SERVICE],
       :resourceUri string,
       :sourceIp string,
       :destinationIp string,
       :region string},
      :causesDrop boolean,
      :appEngineVersion
      {:displayName string,
       :uri string,
       :runtime string,
       :environment string},
      :state
      [STATE_UNSPECIFIED
       START_FROM_INSTANCE
       START_FROM_INTERNET
       START_FROM_GOOGLE_SERVICE
       START_FROM_PRIVATE_NETWORK
       START_FROM_GKE_MASTER
       START_FROM_CLOUD_SQL_INSTANCE
       START_FROM_CLOUD_FUNCTION
       START_FROM_APP_ENGINE_VERSION
       START_FROM_CLOUD_RUN_REVISION
       START_FROM_STORAGE_BUCKET
       START_FROM_PSC_PUBLISHED_SERVICE
       START_FROM_SERVERLESS_NEG
       APPLY_INGRESS_FIREWALL_RULE
       APPLY_EGRESS_FIREWALL_RULE
       APPLY_ROUTE
       APPLY_FORWARDING_RULE
       ANALYZE_LOAD_BALANCER_BACKEND
       SPOOFING_APPROVED
       ARRIVE_AT_INSTANCE
       ARRIVE_AT_INTERNAL_LOAD_BALANCER
       ARRIVE_AT_EXTERNAL_LOAD_BALANCER
       ARRIVE_AT_VPN_GATEWAY
       ARRIVE_AT_VPN_TUNNEL
       ARRIVE_AT_VPC_CONNECTOR
       NAT
       PROXY_CONNECTION
       DELIVER
       DROP
       FORWARD
       ABORT
       VIEWER_PERMISSION_MISSING],
      :route
      {:routeScope [ROUTE_SCOPE_UNSPECIFIED NETWORK NCC_HUB],
       :destPortRanges [string],
       :destIpRange string,
       :nccHubUri string,
       :displayName string,
       :protocols [string],
       :srcPortRanges [string],
       :nextHopType
       [NEXT_HOP_TYPE_UNSPECIFIED
        NEXT_HOP_IP
        NEXT_HOP_INSTANCE
        NEXT_HOP_NETWORK
        NEXT_HOP_PEERING
        NEXT_HOP_INTERCONNECT
        NEXT_HOP_VPN_TUNNEL
        NEXT_HOP_VPN_GATEWAY
        NEXT_HOP_INTERNET_GATEWAY
        NEXT_HOP_BLACKHOLE
        NEXT_HOP_ILB
        NEXT_HOP_ROUTER_APPLIANCE
        NEXT_HOP_NCC_HUB],
       :priority integer,
       :networkUri string,
       :nextHop string,
       :uri string,
       :srcIpRange string,
       :instanceTags [string],
       :nccSpokeUri string,
       :routeType
       [ROUTE_TYPE_UNSPECIFIED
        SUBNET
        STATIC
        DYNAMIC
        PEERING_SUBNET
        PEERING_STATIC
        PEERING_DYNAMIC
        POLICY_BASED]},
      :abort
      {:cause
       [CAUSE_UNSPECIFIED
        UNKNOWN_NETWORK
        UNKNOWN_PROJECT
        NO_EXTERNAL_IP
        UNINTENDED_DESTINATION
        SOURCE_ENDPOINT_NOT_FOUND
        MISMATCHED_SOURCE_NETWORK
        DESTINATION_ENDPOINT_NOT_FOUND
        MISMATCHED_DESTINATION_NETWORK
        UNKNOWN_IP
        GOOGLE_MANAGED_SERVICE_UNKNOWN_IP
        SOURCE_IP_ADDRESS_NOT_IN_SOURCE_NETWORK
        PERMISSION_DENIED
        PERMISSION_DENIED_NO_CLOUD_NAT_CONFIGS
        PERMISSION_DENIED_NO_NEG_ENDPOINT_CONFIGS
        NO_SOURCE_LOCATION
        INVALID_ARGUMENT
        TRACE_TOO_LONG
        INTERNAL_ERROR
        UNSUPPORTED
        MISMATCHED_IP_VERSION
        GKE_KONNECTIVITY_PROXY_UNSUPPORTED
        RESOURCE_CONFIG_NOT_FOUND
        VM_INSTANCE_CONFIG_NOT_FOUND
        NETWORK_CONFIG_NOT_FOUND
        FIREWALL_CONFIG_NOT_FOUND
        ROUTE_CONFIG_NOT_FOUND
        GOOGLE_MANAGED_SERVICE_AMBIGUOUS_PSC_ENDPOINT
        SOURCE_PSC_CLOUD_SQL_UNSUPPORTED
        SOURCE_FORWARDING_RULE_UNSUPPORTED
        NON_ROUTABLE_IP_ADDRESS
        UNKNOWN_ISSUE_IN_GOOGLE_MANAGED_PROJECT
        UNSUPPORTED_GOOGLE_MANAGED_PROJECT_CONFIG],
       :resourceUri string,
       :ipAddress string,
       :projectsMissingPermission [string]},
      :vpcConnector
      {:displayName string, :uri string, :location string},
      :proxyConnection
      {:protocol string,
       :newDestinationIp string,
       :subnetUri string,
       :oldSourceIp string,
       :oldDestinationPort integer,
       :newSourcePort integer,
       :oldSourcePort integer,
       :networkUri string,
       :newSourceIp string,
       :newDestinationPort integer,
       :oldDestinationIp string},
      :vpnTunnel
      {:sourceGatewayIp string,
       :remoteGatewayIp string,
       :displayName string,
       :region string,
       :networkUri string,
       :uri string,
       :remoteGateway string,
       :sourceGateway string,
       :routingType
       [ROUTING_TYPE_UNSPECIFIED ROUTE_BASED POLICY_BASED DYNAMIC]},
      :serverlessNeg {:negUri string},
      :cloudSqlInstance
      {:displayName string,
       :uri string,
       :networkUri string,
       :internalIp string,
       :externalIp string,
       :region string},
      :firewall
      {:displayName string,
       :targetTags [string],
       :policy string,
       :priority integer,
       :networkUri string,
       :targetServiceAccounts [string],
       :action string,
       :uri string,
       :firewallRuleType
       [FIREWALL_RULE_TYPE_UNSPECIFIED
        HIERARCHICAL_FIREWALL_POLICY_RULE
        VPC_FIREWALL_RULE
        IMPLIED_VPC_FIREWALL_RULE
        SERVERLESS_VPC_ACCESS_MANAGED_FIREWALL_RULE
        NETWORK_FIREWALL_POLICY_RULE
        NETWORK_REGIONAL_FIREWALL_POLICY_RULE
        UNSUPPORTED_FIREWALL_POLICY_RULE
        TRACKING_STATE],
       :direction string},
      :cloudRunRevision
      {:displayName string,
       :uri string,
       :location string,
       :serviceUri string},
      :forwardingRule
      {:pscServiceAttachmentUri string,
       :matchedPortRange string,
       :displayName string,
       :loadBalancerName string,
       :matchedProtocol string,
       :region string,
       :pscGoogleApiTarget string,
       :vip string,
       :networkUri string,
       :uri string,
       :target string},
      :projectId string,
      :googleService
      {:sourceIp string,
       :googleServiceType
       [GOOGLE_SERVICE_TYPE_UNSPECIFIED
        IAP
        GFE_PROXY_OR_HEALTH_CHECK_PROBER
        CLOUD_DNS
        GOOGLE_API
        GOOGLE_API_PSC
        GOOGLE_API_VPC_SC]},
      :storageBucket {:bucket string},
      :vpnGateway
      {:displayName string,
       :uri string,
       :networkUri string,
       :ipAddress string,
       :vpnTunnelUri string,
       :region string},
      :network
      {:displayName string, :uri string, :matchedIpRange string},
      :gkeMaster
      {:clusterUri string,
       :clusterNetworkUri string,
       :internalIp string,
       :externalIp string},
      :endpoint
      {:sourceIp string,
       :destinationIp string,
       :protocol string,
       :sourcePort integer,
       :destinationPort integer,
       :sourceNetworkUri string,
       :destinationNetworkUri string,
       :sourceAgentUri string}}],
    :forwardTraceId integer}]},
 :probingDetails
 {:abortCause
  [PROBING_ABORT_CAUSE_UNSPECIFIED
   PERMISSION_DENIED
   NO_SOURCE_LOCATION],
  :endpointInfo
  {:sourceIp string,
   :destinationIp string,
   :protocol string,
   :sourcePort integer,
   :destinationPort integer,
   :sourceNetworkUri string,
   :destinationNetworkUri string,
   :sourceAgentUri string},
  :result
  [PROBING_RESULT_UNSPECIFIED
   REACHABLE
   UNREACHABLE
   REACHABILITY_INCONSISTENT
   UNDETERMINED],
  :successfulProbeCount integer,
  :probingLatency
  {:latencyPercentiles [{:percent integer, :latencyMicros string}]},
  :error {:code integer, :message string, :details [object]},
  :destinationEgressLocation {:metropolitanArea string},
  :sentProbeCount integer,
  :verifyTime string},
 :bypassFirewallChecks boolean,
 :destination
 {:loadBalancerId string,
  :instance string,
  :forwardingRuleTarget
  [FORWARDING_RULE_TARGET_UNSPECIFIED
   INSTANCE
   LOAD_BALANCER
   VPN_GATEWAY
   PSC],
  :cloudFunction {:uri string},
  :gkeMasterCluster string,
  :appEngineVersion {:uri string},
  :loadBalancerType
  [LOAD_BALANCER_TYPE_UNSPECIFIED
   HTTPS_ADVANCED_LOAD_BALANCER
   HTTPS_LOAD_BALANCER
   REGIONAL_HTTPS_LOAD_BALANCER
   INTERNAL_HTTPS_LOAD_BALANCER
   SSL_PROXY_LOAD_BALANCER
   TCP_PROXY_LOAD_BALANCER
   INTERNAL_TCP_PROXY_LOAD_BALANCER
   NETWORK_LOAD_BALANCER
   LEGACY_NETWORK_LOAD_BALANCER
   TCP_UDP_INTERNAL_LOAD_BALANCER],
  :port integer,
  :networkType [NETWORK_TYPE_UNSPECIFIED GCP_NETWORK NON_GCP_NETWORK],
  :cloudSqlInstance string,
  :cloudRunRevision {:uri string},
  :forwardingRule string,
  :projectId string,
  :ipAddress string,
  :network string}}

optional:
testId <string> Required. The logical name of the Connectivity Test in your project with the following restrictions: * Must contain only lowercase letters, numbers, and hyphens. * Must start with a letter. * Must be between 1-40 characters. * Must end with a number or a letter. * Must be unique within the customer project"
  ([parent ConnectivityTest]
    (projects-locations-global-connectivityTests-create
      parent
      ConnectivityTest
      nil))
  ([parent ConnectivityTest optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://networkmanagement.googleapis.com/v1/{+parent}/connectivityTests",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ConnectivityTest})))

(defn projects-locations-global-connectivityTests-delete
  "Deletes a specific `ConnectivityTest`.
https://cloud.google.com

name <string> Required. Connectivity Test resource name using the form: `projects/{project_id}/locations/global/connectivityTests/{test_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-connectivityTests-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-global-connectivityTests-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkmanagement.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-connectivityTests-list
  "Lists all Connectivity Tests owned by a project.
https://cloud.google.com

parent <string> Required. The parent resource of the Connectivity Tests: `projects/{project_id}/locations/global`

optional:
pageSize <integer> Number of `ConnectivityTests` to return.
filter <string> Lists the `ConnectivityTests` that match the filter expression. A filter expression filters the resources listed in the response. The expression must be of the form ` ` where operators: `<`, `>`, `<=`, `>=`, `!=`, `=`, `:` are supported (colon `:` represents a HAS operator which is roughly synonymous with equality). can refer to a proto or JSON field, or a synthetic field. Field names can be camelCase or snake_case. Examples: - Filter by name: name = \"projects/proj-1/locations/global/connectivityTests/test-1 - Filter by labels: - Resources that have a key called `foo` labels.foo:* - Resources that have a key called `foo` whose value is `bar` labels.foo = bar
orderBy <string> Field to use to sort the list."
  ([parent]
    (projects-locations-global-connectivityTests-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://networkmanagement.googleapis.com/v1/{+parent}/connectivityTests",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-connectivityTests-rerun
  "Rerun an existing `ConnectivityTest`. After the user triggers the rerun, the reachability analysis is performed as part of the long running operation, which completes when the analysis completes. Even though the test configuration remains the same, the reachability result may change due to underlying network configuration changes. If the endpoint specifications in `ConnectivityTest` become invalid (for example, specified resources are deleted in the network, or you lost read permissions to the network configurations of listed projects), then the reachability result returns a value of `UNKNOWN`.
https://cloud.google.com

name <string> Required. Connectivity Test resource name using the form: `projects/{project_id}/locations/global/connectivityTests/{test_id}`
RerunConnectivityTestRequest:
object"
  [name RerunConnectivityTestRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://networkmanagement.googleapis.com/v1/{+name}:rerun",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RerunConnectivityTestRequest}))

(ns happygapi2.servicenetworking
  "Service Networking API
Provides automatic management of network configurations necessary for certain services.
See: https://cloud.google.com/service-infrastructure/docs/service-networking/getting-started"
  (:require [happy.oauth2.client :as client]))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicenetworking.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"]})))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body CancelOperationRequest}))

(defn services-addSubnetwork
  "For service producers, provisions a new subnet in a peered service's shared VPC network in the requested region and with the requested size that's expressed as a CIDR range (number of leading bits of ipV4 network mask). The method checks against the assigned allocated ranges to find a non-conflicting IP address range. The method will reuse a subnet if subsequent calls contain the same subnet name, region, and prefix length. This method will make producer's tenant project to be a shared VPC service project as needed.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services/addSubnetwork

parent <string> Required. A tenant project in the service producer organization, in the following format: services/{service}/{collection-id}/{resource-id}. {collection-id} is the cloud resource collection type that represents the tenant project. Only `projects` are supported. {resource-id} is the tenant project numeric id, such as `123456`. {service} the name of the peering service, such as `service-peering.example.com`. This service must already be enabled in the service consumer's project.
AddSubnetworkRequest:
{:role string,
 :description string,
 :consumer string,
 :consumerNetwork string,
 :purpose string,
 :privateIpv6GoogleAccess string,
 :internalRange string,
 :subnetworkUsers [string],
 :checkServiceNetworkingUsePermission boolean,
 :outsideAllocationPublicIpRange string,
 :useCustomComputeIdempotencyWindow boolean,
 :requestedAddress string,
 :region string,
 :ipPrefixLength integer,
 :allowSubnetCidrRoutesOverlap boolean,
 :computeIdempotencyWindow string,
 :requestedRanges [string],
 :secondaryIpRangeSpecs
 [{:outsideAllocationPublicIpRange string,
   :rangeName string,
   :ipPrefixLength integer,
   :requestedAddress string}],
 :subnetwork string}"
  [parent AddSubnetworkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}:addSubnetwork",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body AddSubnetworkRequest}))

(defn services-disableVpcServiceControls
  "Disables VPC service controls for a connection.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services/disableVpcServiceControls

parent <string> The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
DisableVpcServiceControlsRequest:
{:consumerNetwork string}"
  [parent DisableVpcServiceControlsRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}:disableVpcServiceControls",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body DisableVpcServiceControlsRequest}))

(defn services-enableVpcServiceControls
  "Enables VPC service controls for a connection.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services/enableVpcServiceControls

parent <string> The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
EnableVpcServiceControlsRequest:
{:consumerNetwork string}"
  [parent EnableVpcServiceControlsRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}:enableVpcServiceControls",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body EnableVpcServiceControlsRequest}))

(defn services-searchRange
  "Service producers can use this method to find a currently unused range within consumer allocated ranges. This returned range is not reserved, and not guaranteed to remain unused. It will validate previously provided allocated ranges, find non-conflicting sub-range of requested size (expressed in number of leading bits of ipv4 network mask, as in CIDR range notation).
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services/searchRange

parent <string> Required. This is in a form services/{service}. {service} the name of the private access management service, for example 'service-peering.example.com'.
SearchRangeRequest:
{:ipPrefixLength integer, :network string}"
  [parent SearchRangeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}:searchRange",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body SearchRangeRequest}))

(defn services-validate
  "Service producers use this method to validate if the consumer provided network, project and requested range are valid. This allows them to use a fail-fast mechanism for consumer requests, and not have to wait for AddSubnetwork operation completion to determine if user request is invalid.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services/validate

parent <string> Required. This is in a form services/{service} where {service} is the name of the private access management service. For example 'service-peering.example.com'.
ValidateConsumerConfigRequest:
{:rangeReservation
 {:subnetworkCandidates
  [{:secondaryIpRanges [{:rangeName string, :ipCidrRange string}],
    :region string,
    :ipCidrRange string,
    :name string,
    :outsideAllocation boolean,
    :network string}],
  :ipPrefixLength integer,
  :requestedRanges [string],
  :secondaryRangeIpPrefixLengths [integer]},
 :validateNetwork boolean,
 :consumerProject {:projectNum string},
 :consumerNetwork string,
 :checkServiceNetworkingUsePermission boolean}"
  [parent ValidateConsumerConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}:validate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body ValidateConsumerConfigRequest}))

(defn services-dnsRecordSets-get
  "Producers can use this method to retrieve information about the DNS record set added to the private zone inside the shared tenant host project associated with a consumer network.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.dnsRecordSets/get

parent <string> Required. Parent resource identifying the connection which owns this collection of DNS zones in the format services/{service}.

optional:
zone <string> Required. The name of the zone containing the record set.
type <string> Required. RecordSet Type eg. type='A'. See the list of [Supported DNS Types](https://cloud.google.com/dns/records/json-record).
consumerNetwork <string> Required. The consumer network containing the record set. Must be in the form of projects/{project}/global/networks/{network}
domain <string> Required. The domain name of the zone containing the recordset."
  ([parent] (services-dnsRecordSets-get parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicenetworking.googleapis.com/v1/{+parent}/dnsRecordSets:get",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"]})))

(defn services-dnsRecordSets-update
  "Service producers can use this method to update DNS record sets from private DNS zones in the shared producer host project.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.dnsRecordSets/update

parent <string> Required. The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
UpdateDnsRecordSetRequest:
{:newDnsRecordSet
 {:domain string, :data [string], :type string, :ttl string},
 :zone string,
 :existingDnsRecordSet
 {:domain string, :data [string], :type string, :ttl string},
 :consumerNetwork string}"
  [parent UpdateDnsRecordSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/dnsRecordSets:update",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body UpdateDnsRecordSetRequest}))

(defn services-dnsRecordSets-add
  "Service producers can use this method to add DNS record sets to private DNS zones in the shared producer host project.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.dnsRecordSets/add

parent <string> Required. The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
AddDnsRecordSetRequest:
{:consumerNetwork string,
 :zone string,
 :dnsRecordSet
 {:domain string, :data [string], :type string, :ttl string}}"
  [parent AddDnsRecordSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/dnsRecordSets:add",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body AddDnsRecordSetRequest}))

(defn services-dnsRecordSets-list
  "Producers can use this method to retrieve a list of available DNS RecordSets available inside the private zone on the tenant host project accessible from their network.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.dnsRecordSets/list

parent <string> Required. The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.

optional:
zone <string> Required. The name of the private DNS zone in the shared producer host project from which the record set will be removed.
consumerNetwork <string> Required. The network that the consumer is using to connect with services. Must be in the form of projects/{project}/global/networks/{network} {project} is the project number, as in '12345' {network} is the network name."
  ([parent] (services-dnsRecordSets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicenetworking.googleapis.com/v1/{+parent}/dnsRecordSets:list",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"]})))

(defn services-dnsRecordSets-remove
  "Service producers can use this method to remove DNS record sets from private DNS zones in the shared producer host project.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.dnsRecordSets/remove

parent <string> Required. The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
RemoveDnsRecordSetRequest:
{:dnsRecordSet
 {:domain string, :data [string], :type string, :ttl string},
 :zone string,
 :consumerNetwork string}"
  [parent RemoveDnsRecordSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/dnsRecordSets:remove",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body RemoveDnsRecordSetRequest}))

(defn services-roles-add
  "Service producers can use this method to add roles in the shared VPC host project. Each role is bound to the provided member. Each role must be selected from within an allowlisted set of roles. Each role is applied at only the granularity specified in the allowlist.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.roles/add

parent <string> Required. This is in a form services/{service} where {service} is the name of the private access management service. For example 'service-peering.example.com'.
AddRolesRequest:
{:consumerNetwork string,
 :policyBinding [{:role string, :member string}]}"
  [parent AddRolesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/roles:add",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body AddRolesRequest}))

(defn services-dnsZones-remove
  "Service producers can use this method to remove private DNS zones in the shared producer host project and matching peering zones in the consumer project.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.dnsZones/remove

parent <string> Required. The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
RemoveDnsZoneRequest:
{:name string, :consumerNetwork string}"
  [parent RemoveDnsZoneRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/dnsZones:remove",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body RemoveDnsZoneRequest}))

(defn services-dnsZones-add
  "Service producers can use this method to add private DNS zones in the shared producer host project and matching peering zones in the consumer project.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.dnsZones/add

parent <string> Required. The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
AddDnsZoneRequest:
{:consumerNetwork string, :dnsSuffix string, :name string}"
  [parent AddDnsZoneRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/dnsZones:add",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body AddDnsZoneRequest}))

(defn services-connections-deleteConnection
  "Deletes a private service access connection.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.connections/deleteConnection

name <string> Required. The private service connection that connects to a service producer organization. The name includes both the private service name and the VPC network peering name in the format of `services/{peering_service_name}/connections/{vpc_peering_name}`. For Google services that support this functionality, this is `services/servicenetworking.googleapis.com/connections/servicenetworking-googleapis-com`.
DeleteConnectionRequest:
{:consumerNetwork string}"
  [name DeleteConnectionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body DeleteConnectionRequest}))

(defn services-connections-create
  "Creates a private connection that establishes a VPC Network Peering connection to a VPC network in the service producer's organization. The administrator of the service consumer's VPC network invokes this method. The administrator must assign one or more allocated IP ranges for provisioning subnetworks in the service producer's VPC network. This connection is used for all supported services in the service producer's organization, so it only needs to be invoked once.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.connections/create

parent <string> The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`.
Connection:
{:reservedPeeringRanges [string],
 :service string,
 :network string,
 :peering string}"
  [parent Connection]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/connections",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body Connection}))

(defn services-connections-patch
  "Updates the allocated ranges that are assigned to a connection.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.connections/patch

name <string> The private service connection that connects to a service producer organization. The name includes both the private service name and the VPC network peering name in the format of `services/{peering_service_name}/connections/{vpc_peering_name}`. For Google services that support this functionality, this is `services/servicenetworking.googleapis.com/connections/servicenetworking-googleapis-com`.
Connection:
{:reservedPeeringRanges [string],
 :service string,
 :network string,
 :peering string}

optional:
updateMask <string> The update mask. If this is omitted, it defaults to \"*\". You can only update the listed peering ranges.
force <boolean> If a previously defined allocated range is removed, force flag must be set to true."
  ([name Connection] (services-connections-patch name Connection nil))
  ([name Connection optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://servicenetworking.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"],
       :body Connection})))

(defn services-connections-list
  "List the private connections that are configured in a service consumer's VPC network.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.connections/list

parent <string> The service that is managing peering connectivity for a service producer's organization. For Google services that support this functionality, this value is `services/servicenetworking.googleapis.com`. If you specify `services/-` as the parameter value, all configured peering services are listed.

optional:
network <string> The name of service consumer's VPC network that's connected with service producer network through a private connection. The network name must be in the following format: `projects/{project}/global/networks/{network}`. {project} is a project number, such as in `12345` that includes the VPC service consumer's VPC network. {network} is the name of the service consumer's VPC network."
  ([parent] (services-connections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicenetworking.googleapis.com/v1/{+parent}/connections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"]})))

(defn services-projects-global-networks-getVpcServiceControls
  "Consumers use this method to find out the state of VPC Service Controls. The controls could be enabled or disabled for a connection.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks/getVpcServiceControls

name <string> Required. Name of the VPC Service Controls config to retrieve in the format: `services/{service}/projects/{project}/global/networks/{network}`. {service} is the peering service that is managing connectivity for the service producer's organization. For Google services that support this functionality, this value is `servicenetworking.googleapis.com`. {project} is a project number e.g. `12345` that contains the service consumer's VPC network. {network} is the name of the service consumer's VPC network."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+name}/vpcServiceControls",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn services-projects-global-networks-updateConsumerConfig
  "Service producers use this method to update the configuration of their connection including the import/export of custom routes and subnetwork routes with public IP.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks/updateConsumerConfig

parent <string> Required. Parent resource identifying the connection for which the consumer config is being updated in the format: `services/{service}/projects/{project}/global/networks/{network}` {service} is the peering service that is managing connectivity for the service producer's organization. For Google services that support this functionality, this value is `servicenetworking.googleapis.com`. {project} is the number of the project that contains the service consumer's VPC network e.g. `12345`. {network} is the name of the service consumer's VPC network.
UpdateConsumerConfigRequest:
{:consumerConfig
 {:producerExportCustomRoutes boolean,
  :producerImportSubnetRoutesWithPublicIp boolean,
  :cloudsqlConfigs
  [{:service string,
    :umbrellaProject string,
    :umbrellaNetwork string}],
  :producerNetwork string,
  :consumerExportCustomRoutes boolean,
  :producerExportSubnetRoutesWithPublicIp boolean,
  :reservedRanges
  [{:name string, :address string, :ipPrefixLength integer}],
  :vpcScReferenceArchitectureEnabled boolean,
  :consumerImportSubnetRoutesWithPublicIp boolean,
  :usedIpRanges [string],
  :consumerImportCustomRoutes boolean,
  :consumerExportSubnetRoutesWithPublicIp boolean,
  :producerImportCustomRoutes boolean}}"
  [parent UpdateConsumerConfigRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}:updateConsumerConfig",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body UpdateConsumerConfigRequest}))

(defn services-projects-global-networks-get
  "Service producers use this method to get the configuration of their connection including the import/export of custom routes and subnetwork routes with public IP.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks/get

name <string> Required. Name of the consumer config to retrieve in the format: `services/{service}/projects/{project}/global/networks/{network}`. {service} is the peering service that is managing connectivity for the service producer's organization. For Google services that support this functionality, this value is `servicenetworking.googleapis.com`. {project} is a project number e.g. `12345` that contains the service consumer's VPC network. {network} is the name of the service consumer's VPC network.

optional:
includeUsedIpRanges <boolean> Optional. When true, include the used IP ranges as part of the GetConsumerConfig output. This includes routes created inside the service networking network, consumer network, peers of the consumer network, and reserved ranges inside the service networking network. By default, this is false"
  ([name] (services-projects-global-networks-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicenetworking.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"]})))

(defn services-projects-global-networks-dnsZones-list
  "* Service producers can use this method to retrieve a list of available DNS zones in the shared producer host project and the matching peering zones in the consumer project. *
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks.dnsZones/list

parent <string> Required. Parent resource identifying the connection which owns this collection of DNS zones in the format services/{service}/projects/{project}/global/networks/{network} Service: The service that is managing connectivity for the service producer's organization. For Google services that support this functionality, this value is `servicenetworking.googleapis.com`. Projects: the consumer project containing the consumer network. Network: The consumer network accessible from the tenant project."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/dnsZones:list",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn services-projects-global-networks-dnsZones-get
  "Service producers can use this method to retrieve a DNS zone in the shared producer host project and the matching peering zones in consumer project
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks.dnsZones/get

name <string> Required. The network that the consumer is using to connect with services. Must be in the form of services/{service}/projects/{project}/global/networks/{network}/zones/{zoneName} Where {service} is the peering service that is managing connectivity for the service producer's organization. For Google services that support this {project} is the project number, as in '12345' {network} is the network name. {zoneName} is the DNS zone name"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn services-projects-global-networks-peeredDnsDomains-create
  "Creates a peered DNS domain which sends requests for records in given namespace originating in the service producer VPC network to the consumer VPC network to be resolved.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks.peeredDnsDomains/create

parent <string> Required. Parent resource identifying the connection for which the peered DNS domain will be created in the format: `services/{service}/projects/{project}/global/networks/{network}` {service} is the peering service that is managing connectivity for the service producer's organization. For Google services that support this functionality, this value is `servicenetworking.googleapis.com`. {project} is the number of the project that contains the service consumer's VPC network e.g. `12345`. {network} is the name of the service consumer's VPC network.
PeeredDnsDomain:
{:dnsSuffix string, :name string}"
  [parent PeeredDnsDomain]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/peeredDnsDomains",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body PeeredDnsDomain}))

(defn services-projects-global-networks-peeredDnsDomains-list
  "Lists peered DNS domains for a connection.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks.peeredDnsDomains/list

parent <string> Required. Parent resource identifying the connection which owns this collection of peered DNS domains in the format: `services/{service}/projects/{project}/global/networks/{network}`. {service} is the peering service that is managing connectivity for the service producer's organization. For Google services that support this functionality, this value is `servicenetworking.googleapis.com`. {project} is a project number e.g. `12345` that contains the service consumer's VPC network. {network} is the name of the service consumer's VPC network."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+parent}/peeredDnsDomains",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn services-projects-global-networks-peeredDnsDomains-delete
  "Deletes a peered DNS domain.
https://cloud.google.com/service-infrastructure/docs/service-networking/reference/rest/v1/services.projects.global.networks.peeredDnsDomains/delete

name <string> Required. The name of the peered DNS domain to delete in the format: `services/{service}/projects/{project}/global/networks/{network}/peeredDnsDomains/{name}`. {service} is the peering service that is managing connectivity for the service producer's organization. For Google services that support this functionality, this value is `servicenetworking.googleapis.com`. {project} is the number of the project that contains the service consumer's VPC network e.g. `12345`. {network} is the name of the service consumer's VPC network. {name} is the name of the peered DNS domain."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://servicenetworking.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

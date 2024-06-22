(ns happygapi2.dns
  "Cloud DNS API

See: https://cloud.google.com/dns/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-get
  "Fetches the representation of an existing Project.
https://cloud.google.com/dns/docs/reference/rest/v1/projects/get

project <string> Identifies the project addressed by this request.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project] (projects-get project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn dnsKeys-get
  "Fetches the representation of an existing DnsKey.
https://cloud.google.com/dns/docs/reference/rest/v1/dnsKeys/get

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
dnsKeyId <string> The identifier of the requested DnsKey.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection.
digestType <string> An optional comma-separated list of digest types to compute and display for key signing keys. If omitted, the recommended digest type is computed and displayed."
  ([project managedZone dnsKeyId]
    (dnsKeys-get project managedZone dnsKeyId nil))
  ([project managedZone dnsKeyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/dnsKeys/{dnsKeyId}",
       :uri-template-args
       {:project project,
        :managedZone managedZone,
        :dnsKeyId dnsKeyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn dnsKeys-list
  "Enumerates DnsKeys to a ResourceRecordSet collection.
https://cloud.google.com/dns/docs/reference/rest/v1/dnsKeys/list

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return.
digestType <string> An optional comma-separated list of digest types to compute and display for key signing keys. If omitted, the recommended digest type is computed and displayed."
  ([project managedZone] (dnsKeys-list project managedZone nil))
  ([project managedZone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/dnsKeys",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn policies-create
  "Creates a new Policy.
https://cloud.google.com/dns/docs/reference/rest/v1/policies/create

project <string> Identifies the project addressed by this request.
Policy:
{:id string,
 :name string,
 :enableInboundForwarding boolean,
 :description string,
 :networks [{:networkUrl string, :kind string}],
 :alternativeNameServerConfig
 {:targetNameServers
  [{:ipv4Address string,
    :forwardingPath [default private],
    :ipv6Address string,
    :kind string}],
  :kind string},
 :enableLogging boolean,
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project Policy] (policies-create project Policy nil))
  ([project Policy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/policies",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body Policy})))

(defn policies-get
  "Fetches the representation of an existing Policy.
https://cloud.google.com/dns/docs/reference/rest/v1/policies/get

project <string> Identifies the project addressed by this request.
policy <string> User given friendly name of the policy addressed by this request.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project policy] (policies-get project policy nil))
  ([project policy optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/policies/{policy}",
       :uri-template-args {:project project, :policy policy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn policies-list
  "Enumerates all Policies associated with a project.
https://cloud.google.com/dns/docs/reference/rest/v1/policies/list

project <string> Identifies the project addressed by this request.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return."
  ([project] (policies-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/policies",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn policies-delete
  "Deletes a previously created Policy. Fails if the policy is still being referenced by a network.
https://cloud.google.com/dns/docs/reference/rest/v1/policies/delete

project <string> Identifies the project addressed by this request.
policy <string> User given friendly name of the policy addressed by this request.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project policy] (policies-delete project policy nil))
  ([project policy optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/policies/{policy}",
       :uri-template-args {:project project, :policy policy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn policies-patch
  "Applies a partial update to an existing Policy.
https://cloud.google.com/dns/docs/reference/rest/v1/policies/patch

project <string> Identifies the project addressed by this request.
policy <string> User given friendly name of the policy addressed by this request.
Policy:
{:id string,
 :name string,
 :enableInboundForwarding boolean,
 :description string,
 :networks [{:networkUrl string, :kind string}],
 :alternativeNameServerConfig
 {:targetNameServers
  [{:ipv4Address string,
    :forwardingPath [default private],
    :ipv6Address string,
    :kind string}],
  :kind string},
 :enableLogging boolean,
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project policy Policy] (policies-patch project policy Policy nil))
  ([project policy Policy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/policies/{policy}",
       :uri-template-args {:project project, :policy policy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body Policy})))

(defn policies-update
  "Updates an existing Policy.
https://cloud.google.com/dns/docs/reference/rest/v1/policies/update

project <string> Identifies the project addressed by this request.
policy <string> User given friendly name of the policy addressed by this request.
Policy:
{:id string,
 :name string,
 :enableInboundForwarding boolean,
 :description string,
 :networks [{:networkUrl string, :kind string}],
 :alternativeNameServerConfig
 {:targetNameServers
  [{:ipv4Address string,
    :forwardingPath [default private],
    :ipv6Address string,
    :kind string}],
  :kind string},
 :enableLogging boolean,
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project policy Policy] (policies-update project policy Policy nil))
  ([project policy Policy optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/policies/{policy}",
       :uri-template-args {:project project, :policy policy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body Policy})))

(defn managedZones-get
  "Fetches the representation of an existing ManagedZone.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/get

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone] (managedZones-get project managedZone nil))
  ([project managedZone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn managedZones-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/setIamPolicy

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
     "https://dns.googleapis.com/dns/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn managedZones-patch
  "Applies a partial update to an existing ManagedZone.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/patch

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
ManagedZone:
{:creationTime string,
 :description string,
 :labels object,
 :peeringConfig
 {:targetNetwork
  {:networkUrl string, :deactivateTime string, :kind string},
  :kind string},
 :dnssecConfig
 {:state [off on transfer],
  :defaultKeySpecs
  [{:keyType [keySigning zoneSigning],
    :algorithm
    [rsasha1 rsasha256 rsasha512 ecdsap256sha256 ecdsap384sha384],
    :keyLength integer,
    :kind string}],
  :nonExistence [nsec nsec3],
  :kind string},
 :cloudLoggingConfig {:enableLogging boolean, :kind string},
 :name string,
 :nameServerSet string,
 :reverseLookupConfig {:kind string},
 :privateVisibilityConfig
 {:networks [{:networkUrl string, :kind string}],
  :gkeClusters [{:gkeClusterName string, :kind string}],
  :kind string},
 :serviceDirectoryConfig
 {:namespace
  {:namespaceUrl string, :deletionTime string, :kind string},
  :kind string},
 :forwardingConfig
 {:targetNameServers
  [{:ipv4Address string,
    :forwardingPath [default private],
    :ipv6Address string,
    :kind string}],
  :kind string},
 :dnsName string,
 :id string,
 :kind string,
 :nameServers [string],
 :visibility [public private]}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone ManagedZone]
    (managedZones-patch project managedZone ManagedZone nil))
  ([project managedZone ManagedZone optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ManagedZone})))

(defn managedZones-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this returns an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dns.googleapis.com/dns/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/ndev.clouddns.readonly"
      "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn managedZones-create
  "Creates a new ManagedZone.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/create

project <string> Identifies the project addressed by this request.
ManagedZone:
{:creationTime string,
 :description string,
 :labels object,
 :peeringConfig
 {:targetNetwork
  {:networkUrl string, :deactivateTime string, :kind string},
  :kind string},
 :dnssecConfig
 {:state [off on transfer],
  :defaultKeySpecs
  [{:keyType [keySigning zoneSigning],
    :algorithm
    [rsasha1 rsasha256 rsasha512 ecdsap256sha256 ecdsap384sha384],
    :keyLength integer,
    :kind string}],
  :nonExistence [nsec nsec3],
  :kind string},
 :cloudLoggingConfig {:enableLogging boolean, :kind string},
 :name string,
 :nameServerSet string,
 :reverseLookupConfig {:kind string},
 :privateVisibilityConfig
 {:networks [{:networkUrl string, :kind string}],
  :gkeClusters [{:gkeClusterName string, :kind string}],
  :kind string},
 :serviceDirectoryConfig
 {:namespace
  {:namespaceUrl string, :deletionTime string, :kind string},
  :kind string},
 :forwardingConfig
 {:targetNameServers
  [{:ipv4Address string,
    :forwardingPath [default private],
    :ipv6Address string,
    :kind string}],
  :kind string},
 :dnsName string,
 :id string,
 :kind string,
 :nameServers [string],
 :visibility [public private]}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project ManagedZone] (managedZones-create project ManagedZone nil))
  ([project ManagedZone optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ManagedZone})))

(defn managedZones-update
  "Updates an existing ManagedZone.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/update

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
ManagedZone:
{:creationTime string,
 :description string,
 :labels object,
 :peeringConfig
 {:targetNetwork
  {:networkUrl string, :deactivateTime string, :kind string},
  :kind string},
 :dnssecConfig
 {:state [off on transfer],
  :defaultKeySpecs
  [{:keyType [keySigning zoneSigning],
    :algorithm
    [rsasha1 rsasha256 rsasha512 ecdsap256sha256 ecdsap384sha384],
    :keyLength integer,
    :kind string}],
  :nonExistence [nsec nsec3],
  :kind string},
 :cloudLoggingConfig {:enableLogging boolean, :kind string},
 :name string,
 :nameServerSet string,
 :reverseLookupConfig {:kind string},
 :privateVisibilityConfig
 {:networks [{:networkUrl string, :kind string}],
  :gkeClusters [{:gkeClusterName string, :kind string}],
  :kind string},
 :serviceDirectoryConfig
 {:namespace
  {:namespaceUrl string, :deletionTime string, :kind string},
  :kind string},
 :forwardingConfig
 {:targetNameServers
  [{:ipv4Address string,
    :forwardingPath [default private],
    :ipv6Address string,
    :kind string}],
  :kind string},
 :dnsName string,
 :id string,
 :kind string,
 :nameServers [string],
 :visibility [public private]}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone ManagedZone]
    (managedZones-update project managedZone ManagedZone nil))
  ([project managedZone ManagedZone optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ManagedZone})))

(defn managedZones-delete
  "Deletes a previously created ManagedZone.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/delete

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone] (managedZones-delete project managedZone nil))
  ([project managedZone optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn managedZones-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GoogleIamV1GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dns.googleapis.com/dns/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/ndev.clouddns.readonly"
      "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
     :body GoogleIamV1GetIamPolicyRequest}))

(defn managedZones-list
  "Enumerates ManagedZones that have been created but not yet deleted.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZones/list

project <string> Identifies the project addressed by this request.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return.
dnsName <string> Restricts the list to return only zones with this domain name."
  ([project] (managedZones-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn resourceRecordSets-list
  "Enumerates ResourceRecordSets that you have created but not yet deleted.
https://cloud.google.com/dns/docs/reference/rest/v1/resourceRecordSets/list

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return.
name <string> Restricts the list to return only records with this fully qualified domain name.
type <string> Restricts the list to return only records of this type. If present, the \"name\" parameter must also be present."
  ([project managedZone]
    (resourceRecordSets-list project managedZone nil))
  ([project managedZone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/rrsets",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn resourceRecordSets-create
  "Creates a new ResourceRecordSet.
https://cloud.google.com/dns/docs/reference/rest/v1/resourceRecordSets/create

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
ResourceRecordSet:
{:name string,
 :type string,
 :ttl integer,
 :rrdatas [string],
 :signatureRrdatas [string],
 :routingPolicy
 {:geo
  {:items
   [{:location string,
     :rrdatas [string],
     :signatureRrdatas [string],
     :healthCheckedTargets
     {:internalLoadBalancers [RRSetRoutingPolicyLoadBalancerTarget]},
     :kind string}],
   :enableFencing boolean,
   :kind string},
  :wrr
  {:items
   [{:weight number,
     :rrdatas [string],
     :signatureRrdatas [string],
     :healthCheckedTargets
     {:internalLoadBalancers [RRSetRoutingPolicyLoadBalancerTarget]},
     :kind string}],
   :kind string},
  :primaryBackup
  {:primaryTargets
   {:internalLoadBalancers
    [{:loadBalancerType [none globalL7ilb regionalL4ilb regionalL7ilb],
      :ipAddress string,
      :port string,
      :ipProtocol [undefined tcp udp],
      :networkUrl string,
      :project string,
      :region string,
      :kind string}]},
   :backupGeoTargets
   {:items
    [{:location string,
      :rrdatas [string],
      :signatureRrdatas [string],
      :healthCheckedTargets RRSetRoutingPolicyHealthCheckTargets,
      :kind string}],
    :enableFencing boolean,
    :kind string},
   :trickleTraffic number,
   :kind string},
  :kind string},
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone ResourceRecordSet]
    (resourceRecordSets-create
      project
      managedZone
      ResourceRecordSet
      nil))
  ([project managedZone ResourceRecordSet optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/rrsets",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResourceRecordSet})))

(defn resourceRecordSets-get
  "Fetches the representation of an existing ResourceRecordSet.
https://cloud.google.com/dns/docs/reference/rest/v1/resourceRecordSets/get

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
name <string> Fully qualified domain name.
type <string> RRSet type.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone name type]
    (resourceRecordSets-get project managedZone name type nil))
  ([project managedZone name type optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/rrsets/{name}/{type}",
       :uri-template-args
       {:project project,
        :managedZone managedZone,
        :name name,
        :type type},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn resourceRecordSets-delete
  "Deletes a previously created ResourceRecordSet.
https://cloud.google.com/dns/docs/reference/rest/v1/resourceRecordSets/delete

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
name <string> Fully qualified domain name.
type <string> RRSet type.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone name type]
    (resourceRecordSets-delete project managedZone name type nil))
  ([project managedZone name type optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/rrsets/{name}/{type}",
       :uri-template-args
       {:project project,
        :managedZone managedZone,
        :name name,
        :type type},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn resourceRecordSets-patch
  "Applies a partial update to an existing ResourceRecordSet.
https://cloud.google.com/dns/docs/reference/rest/v1/resourceRecordSets/patch

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
name <string> Fully qualified domain name.
type <string> RRSet type.
ResourceRecordSet:
{:name string,
 :type string,
 :ttl integer,
 :rrdatas [string],
 :signatureRrdatas [string],
 :routingPolicy
 {:geo
  {:items
   [{:location string,
     :rrdatas [string],
     :signatureRrdatas [string],
     :healthCheckedTargets
     {:internalLoadBalancers [RRSetRoutingPolicyLoadBalancerTarget]},
     :kind string}],
   :enableFencing boolean,
   :kind string},
  :wrr
  {:items
   [{:weight number,
     :rrdatas [string],
     :signatureRrdatas [string],
     :healthCheckedTargets
     {:internalLoadBalancers [RRSetRoutingPolicyLoadBalancerTarget]},
     :kind string}],
   :kind string},
  :primaryBackup
  {:primaryTargets
   {:internalLoadBalancers
    [{:loadBalancerType [none globalL7ilb regionalL4ilb regionalL7ilb],
      :ipAddress string,
      :port string,
      :ipProtocol [undefined tcp udp],
      :networkUrl string,
      :project string,
      :region string,
      :kind string}]},
   :backupGeoTargets
   {:items
    [{:location string,
      :rrdatas [string],
      :signatureRrdatas [string],
      :healthCheckedTargets RRSetRoutingPolicyHealthCheckTargets,
      :kind string}],
    :enableFencing boolean,
    :kind string},
   :trickleTraffic number,
   :kind string},
  :kind string},
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone name type ResourceRecordSet]
    (resourceRecordSets-patch
      project
      managedZone
      name
      type
      ResourceRecordSet
      nil))
  ([project managedZone name type ResourceRecordSet optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/rrsets/{name}/{type}",
       :uri-template-args
       {:project project,
        :managedZone managedZone,
        :name name,
        :type type},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResourceRecordSet})))

(defn responsePolicyRules-create
  "Creates a new Response Policy Rule.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicyRules/create

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy containing the Response Policy Rule.
ResponsePolicyRule:
{:ruleName string,
 :dnsName string,
 :localData
 {:localDatas
  [{:name string,
    :type string,
    :ttl integer,
    :rrdatas [string],
    :signatureRrdatas [string],
    :routingPolicy
    {:geo
     {:items [RRSetRoutingPolicyGeoPolicyGeoPolicyItem],
      :enableFencing boolean,
      :kind string},
     :wrr
     {:items [RRSetRoutingPolicyWrrPolicyWrrPolicyItem], :kind string},
     :primaryBackup
     {:primaryTargets RRSetRoutingPolicyHealthCheckTargets,
      :backupGeoTargets RRSetRoutingPolicyGeoPolicy,
      :trickleTraffic number,
      :kind string},
     :kind string},
    :kind string}]},
 :behavior [behaviorUnspecified bypassResponsePolicy],
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy ResponsePolicyRule]
    (responsePolicyRules-create
      project
      responsePolicy
      ResponsePolicyRule
      nil))
  ([project responsePolicy ResponsePolicyRule optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules",
       :uri-template-args
       {:project project, :responsePolicy responsePolicy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResponsePolicyRule})))

(defn responsePolicyRules-get
  "Fetches the representation of an existing Response Policy Rule.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicyRules/get

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy containing the Response Policy Rule.
responsePolicyRule <string> User assigned name of the Response Policy Rule addressed by this request.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy responsePolicyRule]
    (responsePolicyRules-get
      project
      responsePolicy
      responsePolicyRule
      nil))
  ([project responsePolicy responsePolicyRule optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}",
       :uri-template-args
       {:project project,
        :responsePolicy responsePolicy,
        :responsePolicyRule responsePolicyRule},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn responsePolicyRules-delete
  "Deletes a previously created Response Policy Rule.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicyRules/delete

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy containing the Response Policy Rule.
responsePolicyRule <string> User assigned name of the Response Policy Rule addressed by this request.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy responsePolicyRule]
    (responsePolicyRules-delete
      project
      responsePolicy
      responsePolicyRule
      nil))
  ([project responsePolicy responsePolicyRule optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}",
       :uri-template-args
       {:project project,
        :responsePolicy responsePolicy,
        :responsePolicyRule responsePolicyRule},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn responsePolicyRules-list
  "Enumerates all Response Policy Rules associated with a project.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicyRules/list

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy to list.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return."
  ([project responsePolicy]
    (responsePolicyRules-list project responsePolicy nil))
  ([project responsePolicy optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules",
       :uri-template-args
       {:project project, :responsePolicy responsePolicy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn responsePolicyRules-patch
  "Applies a partial update to an existing Response Policy Rule.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicyRules/patch

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy containing the Response Policy Rule.
responsePolicyRule <string> User assigned name of the Response Policy Rule addressed by this request.
ResponsePolicyRule:
{:ruleName string,
 :dnsName string,
 :localData
 {:localDatas
  [{:name string,
    :type string,
    :ttl integer,
    :rrdatas [string],
    :signatureRrdatas [string],
    :routingPolicy
    {:geo
     {:items [RRSetRoutingPolicyGeoPolicyGeoPolicyItem],
      :enableFencing boolean,
      :kind string},
     :wrr
     {:items [RRSetRoutingPolicyWrrPolicyWrrPolicyItem], :kind string},
     :primaryBackup
     {:primaryTargets RRSetRoutingPolicyHealthCheckTargets,
      :backupGeoTargets RRSetRoutingPolicyGeoPolicy,
      :trickleTraffic number,
      :kind string},
     :kind string},
    :kind string}]},
 :behavior [behaviorUnspecified bypassResponsePolicy],
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy responsePolicyRule ResponsePolicyRule]
    (responsePolicyRules-patch
      project
      responsePolicy
      responsePolicyRule
      ResponsePolicyRule
      nil))
  ([project
    responsePolicy
    responsePolicyRule
    ResponsePolicyRule
    optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}",
       :uri-template-args
       {:project project,
        :responsePolicy responsePolicy,
        :responsePolicyRule responsePolicyRule},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResponsePolicyRule})))

(defn responsePolicyRules-update
  "Updates an existing Response Policy Rule.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicyRules/update

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy containing the Response Policy Rule.
responsePolicyRule <string> User assigned name of the Response Policy Rule addressed by this request.
ResponsePolicyRule:
{:ruleName string,
 :dnsName string,
 :localData
 {:localDatas
  [{:name string,
    :type string,
    :ttl integer,
    :rrdatas [string],
    :signatureRrdatas [string],
    :routingPolicy
    {:geo
     {:items [RRSetRoutingPolicyGeoPolicyGeoPolicyItem],
      :enableFencing boolean,
      :kind string},
     :wrr
     {:items [RRSetRoutingPolicyWrrPolicyWrrPolicyItem], :kind string},
     :primaryBackup
     {:primaryTargets RRSetRoutingPolicyHealthCheckTargets,
      :backupGeoTargets RRSetRoutingPolicyGeoPolicy,
      :trickleTraffic number,
      :kind string},
     :kind string},
    :kind string}]},
 :behavior [behaviorUnspecified bypassResponsePolicy],
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy responsePolicyRule ResponsePolicyRule]
    (responsePolicyRules-update
      project
      responsePolicy
      responsePolicyRule
      ResponsePolicyRule
      nil))
  ([project
    responsePolicy
    responsePolicyRule
    ResponsePolicyRule
    optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}",
       :uri-template-args
       {:project project,
        :responsePolicy responsePolicy,
        :responsePolicyRule responsePolicyRule},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResponsePolicyRule})))

(defn responsePolicies-create
  "Creates a new Response Policy
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicies/create

project <string> Identifies the project addressed by this request.
ResponsePolicy:
{:id string,
 :responsePolicyName string,
 :description string,
 :networks [{:networkUrl string, :kind string}],
 :gkeClusters [{:gkeClusterName string, :kind string}],
 :labels object,
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project ResponsePolicy]
    (responsePolicies-create project ResponsePolicy nil))
  ([project ResponsePolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResponsePolicy})))

(defn responsePolicies-get
  "Fetches the representation of an existing Response Policy.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicies/get

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy addressed by this request.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy]
    (responsePolicies-get project responsePolicy nil))
  ([project responsePolicy optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}",
       :uri-template-args
       {:project project, :responsePolicy responsePolicy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn responsePolicies-list
  "Enumerates all Response Policies associated with a project.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicies/list

project <string> Identifies the project addressed by this request.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return."
  ([project] (responsePolicies-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn responsePolicies-delete
  "Deletes a previously created Response Policy. Fails if the response policy is non-empty or still being referenced by a network.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicies/delete

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy addressed by this request.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy]
    (responsePolicies-delete project responsePolicy nil))
  ([project responsePolicy optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}",
       :uri-template-args
       {:project project, :responsePolicy responsePolicy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn responsePolicies-patch
  "Applies a partial update to an existing Response Policy.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicies/patch

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the response policy addressed by this request.
ResponsePolicy:
{:id string,
 :responsePolicyName string,
 :description string,
 :networks [{:networkUrl string, :kind string}],
 :gkeClusters [{:gkeClusterName string, :kind string}],
 :labels object,
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy ResponsePolicy]
    (responsePolicies-patch project responsePolicy ResponsePolicy nil))
  ([project responsePolicy ResponsePolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}",
       :uri-template-args
       {:project project, :responsePolicy responsePolicy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResponsePolicy})))

(defn responsePolicies-update
  "Updates an existing Response Policy.
https://cloud.google.com/dns/docs/reference/rest/v1/responsePolicies/update

project <string> Identifies the project addressed by this request.
responsePolicy <string> User assigned name of the Response Policy addressed by this request.
ResponsePolicy:
{:id string,
 :responsePolicyName string,
 :description string,
 :networks [{:networkUrl string, :kind string}],
 :gkeClusters [{:gkeClusterName string, :kind string}],
 :labels object,
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project responsePolicy ResponsePolicy]
    (responsePolicies-update
      project
      responsePolicy
      ResponsePolicy
      nil))
  ([project responsePolicy ResponsePolicy optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/responsePolicies/{responsePolicy}",
       :uri-template-args
       {:project project, :responsePolicy responsePolicy},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body ResponsePolicy})))

(defn managedZoneOperations-get
  "Fetches the representation of an existing Operation.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZoneOperations/get

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request.
operation <string> Identifies the operation addressed by this request (ID of the operation).

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone operation]
    (managedZoneOperations-get project managedZone operation nil))
  ([project managedZone operation optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/operations/{operation}",
       :uri-template-args
       {:project project,
        :managedZone managedZone,
        :operation operation},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn managedZoneOperations-list
  "Enumerates Operations for the given ManagedZone.
https://cloud.google.com/dns/docs/reference/rest/v1/managedZoneOperations/list

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return.
sortBy <string> Sorting criterion. The only supported values are START_TIME and ID."
  ([project managedZone]
    (managedZoneOperations-list project managedZone nil))
  ([project managedZone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/operations",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn changes-create
  "Atomically updates the ResourceRecordSet collection.
https://cloud.google.com/dns/docs/reference/rest/v1/changes/create

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
Change:
{:additions
 [{:name string,
   :type string,
   :ttl integer,
   :rrdatas [string],
   :signatureRrdatas [string],
   :routingPolicy
   {:geo
    {:items
     [{:location string,
       :rrdatas [string],
       :signatureRrdatas [string],
       :healthCheckedTargets RRSetRoutingPolicyHealthCheckTargets,
       :kind string}],
     :enableFencing boolean,
     :kind string},
    :wrr
    {:items
     [{:weight number,
       :rrdatas [string],
       :signatureRrdatas [string],
       :healthCheckedTargets RRSetRoutingPolicyHealthCheckTargets,
       :kind string}],
     :kind string},
    :primaryBackup
    {:primaryTargets
     {:internalLoadBalancers [RRSetRoutingPolicyLoadBalancerTarget]},
     :backupGeoTargets
     {:items [RRSetRoutingPolicyGeoPolicyGeoPolicyItem],
      :enableFencing boolean,
      :kind string},
     :trickleTraffic number,
     :kind string},
    :kind string},
   :kind string}],
 :deletions
 [{:name string,
   :type string,
   :ttl integer,
   :rrdatas [string],
   :signatureRrdatas [string],
   :routingPolicy
   {:geo
    {:items
     [{:location string,
       :rrdatas [string],
       :signatureRrdatas [string],
       :healthCheckedTargets RRSetRoutingPolicyHealthCheckTargets,
       :kind string}],
     :enableFencing boolean,
     :kind string},
    :wrr
    {:items
     [{:weight number,
       :rrdatas [string],
       :signatureRrdatas [string],
       :healthCheckedTargets RRSetRoutingPolicyHealthCheckTargets,
       :kind string}],
     :kind string},
    :primaryBackup
    {:primaryTargets
     {:internalLoadBalancers [RRSetRoutingPolicyLoadBalancerTarget]},
     :backupGeoTargets
     {:items [RRSetRoutingPolicyGeoPolicyGeoPolicyItem],
      :enableFencing boolean,
      :kind string},
     :trickleTraffic number,
     :kind string},
    :kind string},
   :kind string}],
 :startTime string,
 :id string,
 :status [pending done],
 :isServing boolean,
 :kind string}

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone Change]
    (changes-create project managedZone Change nil))
  ([project managedZone Change optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/changes",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"],
       :body Change})))

(defn changes-get
  "Fetches the representation of an existing Change.
https://cloud.google.com/dns/docs/reference/rest/v1/changes/get

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.
changeId <string> The identifier of the requested change, from a previous ResourceRecordSetsChangeResponse.

optional:
clientOperationId <string> For mutating operation requests only. An optional identifier specified by the client. Must be unique for operation resources in the Operations collection."
  ([project managedZone changeId]
    (changes-get project managedZone changeId nil))
  ([project managedZone changeId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/changes/{changeId}",
       :uri-template-args
       {:project project,
        :managedZone managedZone,
        :changeId changeId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

(defn changes-list
  "Enumerates Changes to a ResourceRecordSet collection.
https://cloud.google.com/dns/docs/reference/rest/v1/changes/list

project <string> Identifies the project addressed by this request.
managedZone <string> Identifies the managed zone addressed by this request. Can be the managed zone name or ID.

optional:
maxResults <integer> Optional. Maximum number of results to be returned. If unspecified, the server decides how many results to return.
sortBy <string> Sorting criterion. The only supported value is change sequence.
sortOrder <string> Sorting order direction: 'ascending' or 'descending'."
  ([project managedZone] (changes-list project managedZone nil))
  ([project managedZone optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dns.googleapis.com/dns/v1/projects/{project}/managedZones/{managedZone}/changes",
       :uri-template-args {:project project, :managedZone managedZone},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.clouddns.readonly"
        "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]})))

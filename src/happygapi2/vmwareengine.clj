(ns happygapi2.vmwareengine
  "VMware Engine API
The Google VMware Engine API lets you programmatically manage VMware environments.
See: https://cloud.google.com/vmware-engine"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-getDnsBindPermission
  "Gets all the principals having bind permission on the intranet VPC associated with the consumer project granted by the Grant API. DnsBindPermission is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

name <string> Required. The name of the resource which stores the users/service accounts having the permission to bind to the corresponding intranet VPC of the consumer project. DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/dnsBindPermission`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/vmware-engine

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/vmware-engine

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vmware-engine

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vmware-engine

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/vmware-engine

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-getDnsForwarding
  "Gets details of the `DnsForwarding` config.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of a `DnsForwarding` to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/dnsForwarding`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-get
  "Retrieves a `PrivateCloud` resource by its resource name.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the private cloud to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/vmware-engine

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
     "https://vmwareengine.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-privateClouds-patch
  "Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`. Only fields specified in `updateMask` are applied. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this private cloud. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
PrivateCloud:
{:description string,
 :deleteTime string,
 :nsx
 {:internalIp string,
  :version string,
  :state [STATE_UNSPECIFIED ACTIVE CREATING],
  :fqdn string},
 :uid string,
 :name string,
 :createTime string,
 :managementCluster
 {:clusterId string,
  :nodeTypeConfigs object,
  :stretchedClusterConfig
  {:preferredLocation string, :secondaryLocation string}},
 :type [STANDARD TIME_LIMITED STRETCHED],
 :state
 [STATE_UNSPECIFIED ACTIVE CREATING UPDATING FAILED DELETED PURGING],
 :networkConfig
 {:managementCidr string,
  :vmwareEngineNetwork string,
  :vmwareEngineNetworkCanonical string,
  :managementIpAddressLayoutVersion integer,
  :dnsServerIp string},
 :updateTime string,
 :hcx
 {:internalIp string,
  :version string,
  :state [STATE_UNSPECIFIED ACTIVE CREATING ACTIVATING],
  :fqdn string},
 :expireTime string,
 :vcenter
 {:internalIp string,
  :version string,
  :state [STATE_UNSPECIFIED ACTIVE CREATING],
  :fqdn string}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `PrivateCloud` resource by the update. The fields specified in `updateMask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name PrivateCloud]
    (projects-locations-privateClouds-patch name PrivateCloud nil))
  ([name PrivateCloud optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PrivateCloud})))

(defn projects-locations-privateClouds-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/vmware-engine

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-privateClouds-resetNsxCredentials
  "Resets credentials of the NSX appliance.
https://cloud.google.com/vmware-engine

privateCloud <string> Required. The resource name of the private cloud to reset credentials for. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
ResetNsxCredentialsRequest:
{:requestId string}"
  [privateCloud ResetNsxCredentialsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+privateCloud}:resetNsxCredentials",
     :uri-template-args {:privateCloud privateCloud},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetNsxCredentialsRequest}))

(defn projects-locations-privateClouds-create
  "Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional. Creating a private cloud also creates a [management cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location to create the new private cloud in. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a`
PrivateCloud:
{:description string,
 :deleteTime string,
 :nsx
 {:internalIp string,
  :version string,
  :state [STATE_UNSPECIFIED ACTIVE CREATING],
  :fqdn string},
 :uid string,
 :name string,
 :createTime string,
 :managementCluster
 {:clusterId string,
  :nodeTypeConfigs object,
  :stretchedClusterConfig
  {:preferredLocation string, :secondaryLocation string}},
 :type [STANDARD TIME_LIMITED STRETCHED],
 :state
 [STATE_UNSPECIFIED ACTIVE CREATING UPDATING FAILED DELETED PURGING],
 :networkConfig
 {:managementCidr string,
  :vmwareEngineNetwork string,
  :vmwareEngineNetworkCanonical string,
  :managementIpAddressLayoutVersion integer,
  :dnsServerIp string},
 :updateTime string,
 :hcx
 {:internalIp string,
  :version string,
  :state [STATE_UNSPECIFIED ACTIVE CREATING ACTIVATING],
  :fqdn string},
 :expireTime string,
 :vcenter
 {:internalIp string,
  :version string,
  :state [STATE_UNSPECIFIED ACTIVE CREATING],
  :fqdn string}}

optional:
privateCloudId <string> Required. The user-provided identifier of the private cloud to be created. This identifier must be unique among each `PrivateCloud` within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. True if you want the request to be validated and not executed; false otherwise."
  ([parent PrivateCloud]
    (projects-locations-privateClouds-create parent PrivateCloud nil))
  ([parent PrivateCloud optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/privateClouds",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PrivateCloud})))

(defn projects-locations-privateClouds-delete
  "Schedules a `PrivateCloud` resource for deletion. A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and `expireTime` set to the time when deletion is final and can no longer be reversed. The delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached, deletion is final and all private cloud resources are irreversibly removed and billing stops. During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can be polled using standard `GET` method for the whole period of deletion and purging. It will not be returned only when it is completely purged.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the private cloud to delete. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`

optional:
requestId <string> Optional. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
force <boolean> Optional. If set to true, cascade delete is enabled and all children of this private cloud resource are also deleted. When this flag is set to false, the private cloud will not be deleted if there are any children other than the management cluster. The management cluster is always deleted.
delayHours <integer> Optional. Time delay of the deletion specified in hours. The default value is `3`. Specifying a non-zero value for this field changes the value of `PrivateCloud.state` to `DELETED` and sets `expire_time` to the planned deletion time. Deletion can be cancelled before `expire_time` elapses using VmwareEngine.UndeletePrivateCloud. Specifying a value of `0` for this field instead begins the deletion process and ceases billing immediately. During the final deletion process, the value of `PrivateCloud.state` becomes `PURGING`."
  ([name] (projects-locations-privateClouds-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/vmware-engine

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-privateClouds-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-resetVcenterCredentials
  "Resets credentials of the Vcenter appliance.
https://cloud.google.com/vmware-engine

privateCloud <string> Required. The resource name of the private cloud to reset credentials for. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
ResetVcenterCredentialsRequest:
{:requestId string, :username string}"
  [privateCloud ResetVcenterCredentialsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+privateCloud}:resetVcenterCredentials",
     :uri-template-args {:privateCloud privateCloud},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetVcenterCredentialsRequest}))

(defn projects-locations-privateClouds-undelete
  "Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the private cloud scheduled for deletion. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
UndeletePrivateCloudRequest:
{:requestId string}"
  [name UndeletePrivateCloudRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+name}:undelete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UndeletePrivateCloudRequest}))

(defn projects-locations-privateClouds-showVcenterCredentials
  "Gets details of credentials for Vcenter appliance.
https://cloud.google.com/vmware-engine

privateCloud <string> Required. The resource name of the private cloud to be queried for credentials. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`

optional:
username <string> Optional. The username of the user to be queried for credentials. The default value of this field is CloudOwner@gve.local. The provided value must be one of the following: CloudOwner@gve.local, solution-user-01@gve.local, solution-user-02@gve.local, solution-user-03@gve.local, solution-user-04@gve.local, solution-user-05@gve.local, zertoadmin@gve.local."
  ([privateCloud]
    (projects-locations-privateClouds-showVcenterCredentials
      privateCloud
      nil))
  ([privateCloud optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+privateCloud}:showVcenterCredentials",
       :uri-template-args {:privateCloud privateCloud},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-list
  "Lists `PrivateCloud` resources in a given project and location.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to be queried for clusters. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a`

optional:
pageSize <integer> The maximum number of private clouds to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of private clouds, you can exclude the ones named `example-pc` by specifying `name != \"example-pc\"`. You can also filter nested fields. For example, you could specify `networkConfig.managementCidr = \"192.168.0.0/24\"` to include private clouds only if they have a matching address in their network configuration. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-pc\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"private-cloud-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"private-cloud-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent] (projects-locations-privateClouds-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/privateClouds",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-updateDnsForwarding
  "Updates the parameters of the `DnsForwarding` config, like associated domains. Only fields specified in `update_mask` are applied.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this DNS profile. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/dnsForwarding`
DnsForwarding:
{:name string,
 :createTime string,
 :updateTime string,
 :forwardingRules [{:domain string, :nameServers [string]}]}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `DnsForwarding` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name DnsForwarding]
    (projects-locations-privateClouds-updateDnsForwarding
      name
      DnsForwarding
      nil))
  ([name DnsForwarding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DnsForwarding})))

(defn projects-locations-privateClouds-showNsxCredentials
  "Gets details of credentials for NSX appliance.
https://cloud.google.com/vmware-engine

privateCloud <string> Required. The resource name of the private cloud to be queried for credentials. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`"
  [privateCloud]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+privateCloud}:showNsxCredentials",
     :uri-template-args {:privateCloud privateCloud},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-clusters-list
  "Lists `Cluster` resources in a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to query for clusters. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`

optional:
pageSize <integer> The maximum number of clusters to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string>  To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-cluster\") (nodeCount = \"3\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-cluster-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-cluster-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent]
    (projects-locations-privateClouds-clusters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-clusters-get
  "Retrieves a `Cluster` resource by its resource name.
https://cloud.google.com/vmware-engine

name <string> Required. The cluster resource name to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-clusters-create
  "Creates a new cluster in a given private cloud. Creating a new cluster provides additional nodes for use in the parent private cloud and requires sufficient [node quota](https://cloud.google.com/vmware-engine/quotas).
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to create a new cluster in. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
Cluster:
{:name string,
 :createTime string,
 :updateTime string,
 :state
 [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING REPAIRING],
 :management boolean,
 :uid string,
 :nodeTypeConfigs object,
 :stretchedClusterConfig
 {:preferredLocation string, :secondaryLocation string}}

optional:
clusterId <string> Required. The user-provided identifier of the new `Cluster`. This identifier must be unique among clusters within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. True if you want the request to be validated and not executed; false otherwise."
  ([parent Cluster]
    (projects-locations-privateClouds-clusters-create
      parent
      Cluster
      nil))
  ([parent Cluster optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-locations-privateClouds-clusters-patch
  "Modifies a `Cluster` resource. Only fields specified in `updateMask` are applied. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this cluster. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`
Cluster:
{:name string,
 :createTime string,
 :updateTime string,
 :state
 [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING REPAIRING],
 :management boolean,
 :uid string,
 :nodeTypeConfigs object,
 :stretchedClusterConfig
 {:preferredLocation string, :secondaryLocation string}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Cluster` resource by the update. The fields specified in the `updateMask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. True if you want the request to be validated and not executed; false otherwise."
  ([name Cluster]
    (projects-locations-privateClouds-clusters-patch name Cluster nil))
  ([name Cluster optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-locations-privateClouds-clusters-delete
  "Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down any workloads running on the cluster before deletion. You cannot delete the management cluster of a private cloud using this method.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the cluster to delete. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`

optional:
requestId <string> Optional. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-privateClouds-clusters-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-clusters-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/vmware-engine

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
     "https://vmwareengine.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-privateClouds-clusters-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/vmware-engine

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-privateClouds-clusters-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-clusters-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/vmware-engine

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-privateClouds-clusters-nodes-list
  "Lists nodes in a given cluster.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the cluster to be queried for nodes. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/clusters/my-cluster`

optional:
pageSize <integer> The maximum number of nodes to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500."
  ([parent]
    (projects-locations-privateClouds-clusters-nodes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/nodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-clusters-nodes-get
  "Gets details of a single node.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the node to retrieve. For example: `projects/{project}/locations/{location}/privateClouds/{private_cloud}/clusters/{cluster}/nodes/{node}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-externalAddresses-list
  "Lists external IP addresses assigned to VMware workload VMs in a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to be queried for external IP addresses. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`

optional:
pageSize <integer> The maximum number of external IP addresses to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of IP addresses, you can exclude the ones named `example-ip` by specifying `name != \"example-ip\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-ip\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-ip-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-ip-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent]
    (projects-locations-privateClouds-externalAddresses-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/externalAddresses",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-externalAddresses-get
  "Gets details of a single external IP address.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the external IP address to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/externalAddresses/my-ip`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-externalAddresses-create
  "Creates a new `ExternalAddress` resource in a given private cloud. The network policy that corresponds to the private cloud must have the external IP address network service enabled (`NetworkPolicy.external_ip`).
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to create a new external IP address in. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
ExternalAddress:
{:name string,
 :createTime string,
 :updateTime string,
 :internalIp string,
 :externalIp string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING],
 :uid string,
 :description string}

optional:
externalAddressId <string> Required. The user-provided identifier of the `ExternalAddress` to be created. This identifier must be unique among `ExternalAddress` resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ExternalAddress]
    (projects-locations-privateClouds-externalAddresses-create
      parent
      ExternalAddress
      nil))
  ([parent ExternalAddress optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/externalAddresses",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ExternalAddress})))

(defn projects-locations-privateClouds-externalAddresses-patch
  "Updates the parameters of a single external IP address. Only fields specified in `update_mask` are applied. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this external IP address. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/externalAddresses/my-address`
ExternalAddress:
{:name string,
 :createTime string,
 :updateTime string,
 :internalIp string,
 :externalIp string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING],
 :uid string,
 :description string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `ExternalAddress` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ExternalAddress]
    (projects-locations-privateClouds-externalAddresses-patch
      name
      ExternalAddress
      nil))
  ([name ExternalAddress optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ExternalAddress})))

(defn projects-locations-privateClouds-externalAddresses-delete
  "Deletes a single external IP address. When you delete an external IP address, connectivity between the external IP address and the corresponding internal IP address is lost.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the external IP address to delete. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/externalAddresses/my-ip`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-privateClouds-externalAddresses-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-subnets-list
  "Lists subnets in a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to be queried for subnets. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`

optional:
pageSize <integer> The maximum number of subnets to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500."
  ([parent] (projects-locations-privateClouds-subnets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/subnets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-subnets-get
  "Gets details of a single subnet.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the subnet to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/subnets/my-subnet`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-subnets-patch
  "Updates the parameters of a single subnet. Only fields specified in `update_mask` are applied. *Note*: This API is synchronous and always returns a successful `google.longrunning.Operation` (LRO). The returned LRO will only have `done` and `response` fields.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this subnet. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/subnets/my-subnet`
Subnet:
{:name string,
 :ipCidrRange string,
 :gatewayIp string,
 :type string,
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  CREATING
  UPDATING
  DELETING
  RECONCILING
  FAILED],
 :vlanId integer}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Subnet` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten."
  ([name Subnet]
    (projects-locations-privateClouds-subnets-patch name Subnet nil))
  ([name Subnet optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Subnet})))

(defn projects-locations-privateClouds-loggingServers-list
  "Lists logging servers configured for a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to be queried for logging servers. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`

optional:
pageSize <integer> The maximum number of logging servers to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of logging servers, you can exclude the ones named `example-server` by specifying `name != \"example-server\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-server\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-server-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-server-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent]
    (projects-locations-privateClouds-loggingServers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/loggingServers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-loggingServers-get
  "Gets details of a logging server.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the Logging Server to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/loggingServers/my-logging-server`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-loggingServers-create
  "Create a new logging server for a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to create a new Logging Server in. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
LoggingServer:
{:name string,
 :createTime string,
 :updateTime string,
 :hostname string,
 :port integer,
 :protocol [PROTOCOL_UNSPECIFIED UDP TCP TLS SSL RELP],
 :sourceType [SOURCE_TYPE_UNSPECIFIED ESXI VCSA],
 :uid string}

optional:
loggingServerId <string> Required. The user-provided identifier of the `LoggingServer` to be created. This identifier must be unique among `LoggingServer` resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent LoggingServer]
    (projects-locations-privateClouds-loggingServers-create
      parent
      LoggingServer
      nil))
  ([parent LoggingServer optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/loggingServers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body LoggingServer})))

(defn projects-locations-privateClouds-loggingServers-patch
  "Updates the parameters of a single logging server. Only fields specified in `update_mask` are applied.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this logging server. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/loggingServers/my-logging-server`
LoggingServer:
{:name string,
 :createTime string,
 :updateTime string,
 :hostname string,
 :port integer,
 :protocol [PROTOCOL_UNSPECIFIED UDP TCP TLS SSL RELP],
 :sourceType [SOURCE_TYPE_UNSPECIFIED ESXI VCSA],
 :uid string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `LoggingServer` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name LoggingServer]
    (projects-locations-privateClouds-loggingServers-patch
      name
      LoggingServer
      nil))
  ([name LoggingServer optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body LoggingServer})))

(defn projects-locations-privateClouds-loggingServers-delete
  "Deletes a single logging server.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the logging server to delete. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/loggingServers/my-logging-server`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-privateClouds-loggingServers-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-hcxActivationKeys-create
  "Creates a new HCX activation key in a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to create the key for. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/privateClouds/my-cloud`
HcxActivationKey:
{:name string,
 :createTime string,
 :state [STATE_UNSPECIFIED AVAILABLE CONSUMED CREATING],
 :activationKey string,
 :uid string}

optional:
hcxActivationKeyId <string> Required. The user-provided identifier of the `HcxActivationKey` to be created. This identifier must be unique among `HcxActivationKey` resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent HcxActivationKey]
    (projects-locations-privateClouds-hcxActivationKeys-create
      parent
      HcxActivationKey
      nil))
  ([parent HcxActivationKey optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/hcxActivationKeys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body HcxActivationKey})))

(defn projects-locations-privateClouds-hcxActivationKeys-list
  "Lists `HcxActivationKey` resources in a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to be queried for HCX activation keys. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/privateClouds/my-cloud`

optional:
pageSize <integer> The maximum number of HCX activation keys to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500."
  ([parent]
    (projects-locations-privateClouds-hcxActivationKeys-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/hcxActivationKeys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-hcxActivationKeys-get
  "Retrieves a `HcxActivationKey` resource by its resource name.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the HCX activation key to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/privateClouds/my-cloud/hcxActivationKeys/my-key`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-hcxActivationKeys-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/vmware-engine

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
     "https://vmwareengine.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-privateClouds-hcxActivationKeys-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/vmware-engine

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-privateClouds-hcxActivationKeys-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-hcxActivationKeys-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/vmware-engine

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-privateClouds-managementDnsZoneBindings-list
  "Lists Consumer VPCs bound to Management DNS Zone of a given private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to be queried for management DNS zone bindings. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`

optional:
pageSize <integer> The maximum number of management DNS zone bindings to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of Management DNS Zone Bindings, you can exclude the ones named `example-management-dns-zone-binding` by specifying `name != \"example-management-dns-zone-binding\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-management-dns-zone-binding\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-management-dns-zone-binding-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-management-dns-zone-binding-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent]
    (projects-locations-privateClouds-managementDnsZoneBindings-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/managementDnsZoneBindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-managementDnsZoneBindings-get
  "Retrieves a 'ManagementDnsZoneBinding' resource by its resource name.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the management DNS zone binding to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateClouds-managementDnsZoneBindings-create
  "Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS binding and the resource that represents the DNS binding of the consumer VPC network to the management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private cloud to create a new management DNS zone binding for. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud`
ManagementDnsZoneBinding:
{:name string,
 :createTime string,
 :updateTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING FAILED],
 :description string,
 :vpcNetwork string,
 :vmwareEngineNetwork string,
 :uid string}

optional:
managementDnsZoneBindingId <string> Required. The user-provided identifier of the `ManagementDnsZoneBinding` resource to be created. This identifier must be unique among `ManagementDnsZoneBinding` resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ManagementDnsZoneBinding]
    (projects-locations-privateClouds-managementDnsZoneBindings-create
      parent
      ManagementDnsZoneBinding
      nil))
  ([parent ManagementDnsZoneBinding optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/managementDnsZoneBindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ManagementDnsZoneBinding})))

(defn projects-locations-privateClouds-managementDnsZoneBindings-patch
  "Updates a `ManagementDnsZoneBinding` resource. Only fields specified in `update_mask` are applied.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this binding. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
ManagementDnsZoneBinding:
{:name string,
 :createTime string,
 :updateTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING FAILED],
 :description string,
 :vpcNetwork string,
 :vmwareEngineNetwork string,
 :uid string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `ManagementDnsZoneBinding` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ManagementDnsZoneBinding]
    (projects-locations-privateClouds-managementDnsZoneBindings-patch
      name
      ManagementDnsZoneBinding
      nil))
  ([name ManagementDnsZoneBinding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ManagementDnsZoneBinding})))

(defn projects-locations-privateClouds-managementDnsZoneBindings-delete
  "Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted, the corresponding consumer VPC network is no longer bound to the management DNS zone.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the management DNS zone binding to delete. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-privateClouds-managementDnsZoneBindings-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateClouds-managementDnsZoneBindings-repair
  "Retries to create a `ManagementDnsZoneBinding` resource that is in failed state.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the management DNS zone binding to repair. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a/privateClouds/my-cloud/managementDnsZoneBindings/my-management-dns-zone-binding`
RepairManagementDnsZoneBindingRequest:
{:requestId string}"
  [name RepairManagementDnsZoneBindingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+name}:repair",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RepairManagementDnsZoneBindingRequest}))

(defn projects-locations-networkPolicies-fetchExternalAddresses
  "Lists external IP addresses assigned to VMware workload VMs within the scope of the given network policy.
https://cloud.google.com/vmware-engine

networkPolicy <string> Required. The resource name of the network policy to query for assigned external IP addresses. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-policy`

optional:
pageSize <integer> The maximum number of external IP addresses to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500."
  ([networkPolicy]
    (projects-locations-networkPolicies-fetchExternalAddresses
      networkPolicy
      nil))
  ([networkPolicy optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+networkPolicy}:fetchExternalAddresses",
       :uri-template-args {:networkPolicy networkPolicy},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-networkPolicies-get
  "Retrieves a `NetworkPolicy` resource by its resource name.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the network policy to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-networkPolicies-list
  "Lists `NetworkPolicy` resources in a specified project and location.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location (region) to query for network policies. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1`

optional:
pageSize <integer> The maximum number of network policies to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of network policies, you can exclude the ones named `example-policy` by specifying `name != \"example-policy\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-policy\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-policy-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-policy-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent] (projects-locations-networkPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/networkPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-networkPolicies-create
  "Creates a new network policy in a given VMware Engine network of a project and location (region). A new network policy cannot be created if another network policy already exists in the same scope.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location (region) to create the new network policy in. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1`
NetworkPolicy:
{:description string,
 :internetAccess
 {:enabled boolean,
  :state [STATE_UNSPECIFIED UNPROVISIONED RECONCILING ACTIVE]},
 :uid string,
 :externalIp
 {:enabled boolean,
  :state [STATE_UNSPECIFIED UNPROVISIONED RECONCILING ACTIVE]},
 :name string,
 :createTime string,
 :updateTime string,
 :vmwareEngineNetworkCanonical string,
 :vmwareEngineNetwork string,
 :edgeServicesCidr string}

optional:
networkPolicyId <string> Required. The user-provided identifier of the network policy to be created. This identifier must be unique within parent `projects/{my-project}/locations/{us-central1}/networkPolicies` and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent NetworkPolicy]
    (projects-locations-networkPolicies-create
      parent
      NetworkPolicy
      nil))
  ([parent NetworkPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/networkPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NetworkPolicy})))

(defn projects-locations-networkPolicies-patch
  "Modifies a `NetworkPolicy` resource. Only the following fields can be updated: `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask` are applied. When updating a network policy, the external IP network service can only be disabled if there are no external IP addresses present in the scope of the policy. Also, a `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this network policy. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`
NetworkPolicy:
{:description string,
 :internetAccess
 {:enabled boolean,
  :state [STATE_UNSPECIFIED UNPROVISIONED RECONCILING ACTIVE]},
 :uid string,
 :externalIp
 {:enabled boolean,
  :state [STATE_UNSPECIFIED UNPROVISIONED RECONCILING ACTIVE]},
 :name string,
 :createTime string,
 :updateTime string,
 :vmwareEngineNetworkCanonical string,
 :vmwareEngineNetwork string,
 :edgeServicesCidr string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `NetworkPolicy` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name NetworkPolicy]
    (projects-locations-networkPolicies-patch name NetworkPolicy nil))
  ([name NetworkPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NetworkPolicy})))

(defn projects-locations-networkPolicies-delete
  "Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access service.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the network policy to delete. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-network-policy`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-networkPolicies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-networkPolicies-externalAccessRules-list
  "Lists `ExternalAccessRule` resources in the specified network policy.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the network policy to query for external access firewall rules. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-policy`

optional:
pageSize <integer> The maximum number of external access rules to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of external access rules, you can exclude the ones named `example-rule` by specifying `name != \"example-rule\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-rule\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-rule-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-rule-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent]
    (projects-locations-networkPolicies-externalAccessRules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/externalAccessRules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-networkPolicies-externalAccessRules-get
  "Gets details of a single external access rule.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the external access firewall rule to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-policy/externalAccessRules/my-rule`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-networkPolicies-externalAccessRules-create
  "Creates a new external access rule in a given network policy.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the network policy to create a new external access firewall rule in. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-policy`
ExternalAccessRule:
{:description string,
 :sourceIpRanges
 [{:ipAddress string,
   :ipAddressRange string,
   :externalAddress string}],
 :ipProtocol string,
 :destinationPorts [string],
 :uid string,
 :name string,
 :createTime string,
 :destinationIpRanges
 [{:ipAddress string,
   :ipAddressRange string,
   :externalAddress string}],
 :state [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING],
 :updateTime string,
 :sourcePorts [string],
 :priority integer,
 :action [ACTION_UNSPECIFIED ALLOW DENY]}

optional:
externalAccessRuleId <string> Required. The user-provided identifier of the `ExternalAccessRule` to be created. This identifier must be unique among `ExternalAccessRule` resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ExternalAccessRule]
    (projects-locations-networkPolicies-externalAccessRules-create
      parent
      ExternalAccessRule
      nil))
  ([parent ExternalAccessRule optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/externalAccessRules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ExternalAccessRule})))

(defn projects-locations-networkPolicies-externalAccessRules-patch
  "Updates the parameters of a single external access rule. Only fields specified in `update_mask` are applied.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of this external access rule. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-policy/externalAccessRules/my-rule`
ExternalAccessRule:
{:description string,
 :sourceIpRanges
 [{:ipAddress string,
   :ipAddressRange string,
   :externalAddress string}],
 :ipProtocol string,
 :destinationPorts [string],
 :uid string,
 :name string,
 :createTime string,
 :destinationIpRanges
 [{:ipAddress string,
   :ipAddressRange string,
   :externalAddress string}],
 :state [STATE_UNSPECIFIED ACTIVE CREATING UPDATING DELETING],
 :updateTime string,
 :sourcePorts [string],
 :priority integer,
 :action [ACTION_UNSPECIFIED ALLOW DENY]}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `ExternalAccessRule` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ExternalAccessRule]
    (projects-locations-networkPolicies-externalAccessRules-patch
      name
      ExternalAccessRule
      nil))
  ([name ExternalAccessRule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ExternalAccessRule})))

(defn projects-locations-networkPolicies-externalAccessRules-delete
  "Deletes a single external access rule.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the external access firewall rule to delete. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/networkPolicies/my-policy/externalAccessRules/my-rule`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if the original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-networkPolicies-externalAccessRules-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nodeTypes-list
  "Lists node types
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location to be queried for node types. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1-a`

optional:
pageSize <integer> The maximum number of node types to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of node types, you can exclude the ones named `standard-72` by specifying `name != \"standard-72\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"standard-72\") (virtual_cpu_count > 2) ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"standard-96\") AND (virtual_cpu_count > 2) OR (name = \"standard-72\") ```"
  ([parent] (projects-locations-nodeTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/nodeTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nodeTypes-get
  "Gets details of a single `NodeType`.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the node type to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-proj/locations/us-central1-a/nodeTypes/standard-72`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-networkPeerings-get
  "Retrieves a `NetworkPeering` resource by its resource name. The resource contains details of the network peering, such as peered networks, import and export custom route configurations, and peering state. NetworkPeering is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the network peering to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/networkPeerings/my-peering`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-networkPeerings-list
  "Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location (global) to query for network peerings. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global`

optional:
pageSize <integer> The maximum number of network peerings to return in one page. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of network peerings, you can exclude the ones named `example-peering` by specifying `name != \"example-peering\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-peering\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-peering-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-peering-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent] (projects-locations-networkPeerings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/networkPeerings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-networkPeerings-create
  "Creates a new network peering between the peer network and VMware Engine network provided in a `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location to create the new network peering in. This value is always `global`, because `NetworkPeering` is a global resource. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global`
NetworkPeering:
{:description string,
 :exportCustomRoutes boolean,
 :peerMtu integer,
 :importCustomRoutesWithPublicIp boolean,
 :peerNetwork string,
 :uid string,
 :name string,
 :exchangeSubnetRoutes boolean,
 :createTime string,
 :state [STATE_UNSPECIFIED INACTIVE ACTIVE CREATING DELETING],
 :stateDetails string,
 :updateTime string,
 :vmwareEngineNetwork string,
 :exportCustomRoutesWithPublicIp boolean,
 :importCustomRoutes boolean,
 :peerNetworkType
 [PEER_NETWORK_TYPE_UNSPECIFIED
  STANDARD
  VMWARE_ENGINE_NETWORK
  PRIVATE_SERVICES_ACCESS
  NETAPP_CLOUD_VOLUMES
  THIRD_PARTY_SERVICE
  DELL_POWERSCALE
  GOOGLE_CLOUD_NETAPP_VOLUMES]}

optional:
networkPeeringId <string> Required. The user-provided identifier of the new `NetworkPeering`. This identifier must be unique among `NetworkPeering` resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent NetworkPeering]
    (projects-locations-networkPeerings-create
      parent
      NetworkPeering
      nil))
  ([parent NetworkPeering optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/networkPeerings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NetworkPeering})))

(defn projects-locations-networkPeerings-delete
  "Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the network peering to be deleted. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/networkPeerings/my-peering`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-networkPeerings-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-networkPeerings-patch
  "Modifies a `NetworkPeering` resource. Only the `description` field can be updated. Only fields specified in `updateMask` are applied. NetworkPeering is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of the network peering. NetworkPeering is a global resource and location can only be global. Resource names are scheme-less URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/networkPeerings/my-peering`
NetworkPeering:
{:description string,
 :exportCustomRoutes boolean,
 :peerMtu integer,
 :importCustomRoutesWithPublicIp boolean,
 :peerNetwork string,
 :uid string,
 :name string,
 :exchangeSubnetRoutes boolean,
 :createTime string,
 :state [STATE_UNSPECIFIED INACTIVE ACTIVE CREATING DELETING],
 :stateDetails string,
 :updateTime string,
 :vmwareEngineNetwork string,
 :exportCustomRoutesWithPublicIp boolean,
 :importCustomRoutes boolean,
 :peerNetworkType
 [PEER_NETWORK_TYPE_UNSPECIFIED
  STANDARD
  VMWARE_ENGINE_NETWORK
  PRIVATE_SERVICES_ACCESS
  NETAPP_CLOUD_VOLUMES
  THIRD_PARTY_SERVICE
  DELL_POWERSCALE
  GOOGLE_CLOUD_NETAPP_VOLUMES]}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `NetworkPeering` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name NetworkPeering]
    (projects-locations-networkPeerings-patch name NetworkPeering nil))
  ([name NetworkPeering optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NetworkPeering})))

(defn projects-locations-networkPeerings-peeringRoutes-list
  "Lists the network peering routes exchanged over a peering connection. NetworkPeering is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the network peering to retrieve peering routes from. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/networkPeerings/my-peering`

optional:
pageSize <integer> The maximum number of peering routes to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. Currently, only filtering on the `direction` field is supported. To return routes imported from the peer network, provide \"direction=INCOMING\". To return routes exported from the VMware Engine network, provide \"direction=OUTGOING\". Other filter expressions return an error."
  ([parent]
    (projects-locations-networkPeerings-peeringRoutes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/peeringRoutes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-vmwareEngineNetworks-create
  "Creates a new VMware Engine network that can be used by a private cloud.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location to create the new VMware Engine network in. A VMware Engine network of type `LEGACY` is a regional resource, and a VMware Engine network of type `STANDARD` is a global resource. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global`
VmwareEngineNetwork:
{:description string,
 :vpcNetworks
 [{:type [TYPE_UNSPECIFIED INTRANET INTERNET GOOGLE_CLOUD],
   :network string}],
 :uid string,
 :name string,
 :createTime string,
 :type [TYPE_UNSPECIFIED LEGACY STANDARD],
 :etag string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE UPDATING DELETING],
 :updateTime string}

optional:
vmwareEngineNetworkId <string> Required. The user-provided identifier of the new VMware Engine network. This identifier must be unique among VMware Engine network resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * For networks of type LEGACY, adheres to the format: `{region-id}-default`. Replace `{region-id}` with the region where you want to create the VMware Engine network. For example, \"us-central1-default\". * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent VmwareEngineNetwork]
    (projects-locations-vmwareEngineNetworks-create
      parent
      VmwareEngineNetwork
      nil))
  ([parent VmwareEngineNetwork optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/vmwareEngineNetworks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body VmwareEngineNetwork})))

(defn projects-locations-vmwareEngineNetworks-patch
  "Modifies a VMware Engine network resource. Only the following fields can be updated: `description`. Only fields specified in `updateMask` are applied.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of the VMware Engine network. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/vmwareEngineNetworks/my-network`
VmwareEngineNetwork:
{:description string,
 :vpcNetworks
 [{:type [TYPE_UNSPECIFIED INTRANET INTERNET GOOGLE_CLOUD],
   :network string}],
 :uid string,
 :name string,
 :createTime string,
 :type [TYPE_UNSPECIFIED LEGACY STANDARD],
 :etag string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE UPDATING DELETING],
 :updateTime string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the VMware Engine network resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten. Only the following fields can be updated: `description`.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name VmwareEngineNetwork]
    (projects-locations-vmwareEngineNetworks-patch
      name
      VmwareEngineNetwork
      nil))
  ([name VmwareEngineNetwork optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body VmwareEngineNetwork})))

(defn projects-locations-vmwareEngineNetworks-delete
  "Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all resources that refer to it are deleted. For example, a private cloud, a network peering, and a network policy can all refer to the same VMware Engine network.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the VMware Engine network to be deleted. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/vmwareEngineNetworks/my-network`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
etag <string> Optional. Checksum used to ensure that the user-provided value is up to date before the server processes the request. The server compares provided checksum with the current checksum of the resource. If the user-provided value is out of date, this request returns an `ABORTED` error."
  ([name] (projects-locations-vmwareEngineNetworks-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-vmwareEngineNetworks-get
  "Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details of the VMware Engine network, such as its VMware Engine network type, peered networks in a service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`).
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the VMware Engine network to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/vmwareEngineNetworks/my-network`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-vmwareEngineNetworks-list
  "Lists `VmwareEngineNetwork` resources in a given project and location.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location to query for VMware Engine networks. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global`

optional:
pageSize <integer> The maximum number of results to return in one page. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of network peerings, you can exclude the ones named `example-network` by specifying `name != \"example-network\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-network\") (createTime > \"2021-04-12T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-network-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-network-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent] (projects-locations-vmwareEngineNetworks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/vmwareEngineNetworks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateConnections-create
  "Creates a new private connection that can be used for accessing private Clouds.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location to create the new private connection in. Private connection is a regional resource. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1`
PrivateConnection:
{:description string,
 :serviceNetwork string,
 :uid string,
 :name string,
 :createTime string,
 :type
 [TYPE_UNSPECIFIED
  PRIVATE_SERVICE_ACCESS
  NETAPP_CLOUD_VOLUMES
  DELL_POWERSCALE
  THIRD_PARTY_SERVICE],
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  UPDATING
  DELETING
  UNPROVISIONED
  FAILED],
 :peeringId string,
 :updateTime string,
 :vmwareEngineNetworkCanonical string,
 :vmwareEngineNetwork string,
 :peeringState
 [PEERING_STATE_UNSPECIFIED PEERING_ACTIVE PEERING_INACTIVE],
 :routingMode [ROUTING_MODE_UNSPECIFIED GLOBAL REGIONAL]}

optional:
privateConnectionId <string> Required. The user-provided identifier of the new private connection. This identifier must be unique among private connection resources within the parent and becomes the final token in the name URI. The identifier must meet the following requirements: * Only contains 1-63 alphanumeric characters and hyphens * Begins with an alphabetical character * Ends with a non-hyphen character * Not formatted as a UUID * Complies with [RFC 1034](https://datatracker.ietf.org/doc/html/rfc1034) (section 3.5)
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent PrivateConnection]
    (projects-locations-privateConnections-create
      parent
      PrivateConnection
      nil))
  ([parent PrivateConnection optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/privateConnections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PrivateConnection})))

(defn projects-locations-privateConnections-get
  "Retrieves a `PrivateConnection` resource by its resource name. The resource contains details of the private connection, such as connected network, routing mode and state.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the private connection to retrieve. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/privateConnections/my-connection`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateConnections-list
  "Lists `PrivateConnection` resources in a given project and location.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the location to query for private connections. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1`

optional:
pageSize <integer> The maximum number of private connections to return in one page. The maximum value is coerced to 1000. The default value of this field is 500.
filter <string> A filter expression that matches resources returned in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be `=`, `!=`, `>`, or `<`. For example, if you are filtering a list of private connections, you can exclude the ones named `example-connection` by specifying `name != \"example-connection\"`. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (name = \"example-connection\") (createTime > \"2022-09-22T08:15:10.40Z\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (name = \"example-connection-1\") AND (createTime > \"2021-04-12T08:15:10.40Z\") OR (name = \"example-connection-2\") ```
orderBy <string> Sorts list results by a certain order. By default, returned results are ordered by `name` in ascending order. You can also sort results in descending order based on the `name` value using `orderBy=\"name desc\"`. Currently, only ordering by `name` is supported."
  ([parent] (projects-locations-privateConnections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/privateConnections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateConnections-patch
  "Modifies a `PrivateConnection` resource. Only `description` and `routing_mode` fields can be updated. Only fields specified in `updateMask` are applied.
https://cloud.google.com/vmware-engine

name <string> Output only. The resource name of the private connection. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/privateConnections/my-connection`
PrivateConnection:
{:description string,
 :serviceNetwork string,
 :uid string,
 :name string,
 :createTime string,
 :type
 [TYPE_UNSPECIFIED
  PRIVATE_SERVICE_ACCESS
  NETAPP_CLOUD_VOLUMES
  DELL_POWERSCALE
  THIRD_PARTY_SERVICE],
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  UPDATING
  DELETING
  UNPROVISIONED
  FAILED],
 :peeringId string,
 :updateTime string,
 :vmwareEngineNetworkCanonical string,
 :vmwareEngineNetwork string,
 :peeringState
 [PEERING_STATE_UNSPECIFIED PEERING_ACTIVE PEERING_INACTIVE],
 :routingMode [ROUTING_MODE_UNSPECIFIED GLOBAL REGIONAL]}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `PrivateConnection` resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name PrivateConnection]
    (projects-locations-privateConnections-patch
      name
      PrivateConnection
      nil))
  ([name PrivateConnection optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PrivateConnection})))

(defn projects-locations-privateConnections-delete
  "Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware Engine network, the connected network becomes inaccessible to that VMware Engine network.
https://cloud.google.com/vmware-engine

name <string> Required. The resource name of the private connection to be deleted. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-central1/privateConnections/my-connection`

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server guarantees that a request doesn't result in creation of duplicate commitments for at least 60 minutes. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-privateConnections-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://vmwareengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateConnections-peeringRoutes-list
  "Lists the private connection routes exchanged over a peering connection.
https://cloud.google.com/vmware-engine

parent <string> Required. The resource name of the private connection to retrieve peering routes from. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/us-west1/privateConnections/my-connection`

optional:
pageSize <integer> The maximum number of peering routes to return in one page. The service may return fewer than this value. The maximum value is coerced to 1000. The default value of this field is 500."
  ([parent]
    (projects-locations-privateConnections-peeringRoutes-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vmwareengine.googleapis.com/v1/{+parent}/peeringRoutes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dnsBindPermission-grant
  "Grants the bind permission to the customer provided principal(user / service account) to bind their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

name <string> Required. The name of the resource which stores the users/service accounts having the permission to bind to the corresponding intranet VPC of the consumer project. DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/dnsBindPermission`
GrantDnsBindPermissionRequest:
{:principal {:user string, :serviceAccount string}, :requestId string}"
  [name GrantDnsBindPermissionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+name}:grant",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GrantDnsBindPermissionRequest}))

(defn projects-locations-dnsBindPermission-revoke
  "Revokes the bind permission from the customer provided principal(user / service account) on the intranet VPC associated with the consumer project. DnsBindPermission is a global resource and location can only be global.
https://cloud.google.com/vmware-engine

name <string> Required. The name of the resource which stores the users/service accounts having the permission to bind to the corresponding intranet VPC of the consumer project. DnsBindPermission is a global resource. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. For example: `projects/my-project/locations/global/dnsBindPermission`
RevokeDnsBindPermissionRequest:
{:principal {:user string, :serviceAccount string}, :requestId string}"
  [name RevokeDnsBindPermissionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://vmwareengine.googleapis.com/v1/{+name}:revoke",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RevokeDnsBindPermissionRequest}))

(ns happygapi2.gkehub
  "GKE Hub API

See: https://cloud.google.com/kubernetes-engine/fleet-management/docs/fleet-creation"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-memberships-get
  "Gets the details of a Membership.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/get

name <string> Required. The Membership resource name in the format `projects/*/locations/*/memberships/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-memberships-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/setIamPolicy

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
     "https://gkehub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-memberships-patch
  "Updates an existing Membership.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/patch

name <string> Required. The Membership resource name in the format `projects/*/locations/*/memberships/*`.
Membership:
{:description string,
 :labels object,
 :deleteTime string,
 :monitoringConfig
 {:projectId string,
  :location string,
  :cluster string,
  :kubernetesMetricsPrefix string,
  :clusterHash string},
 :name string,
 :authority
 {:issuer string,
  :workloadIdentityPool string,
  :identityProvider string,
  :oidcJwks string},
 :createTime string,
 :state
 {:code
  [CODE_UNSPECIFIED
   CREATING
   READY
   DELETING
   UPDATING
   SERVICE_UPDATING]},
 :lastConnectionTime string,
 :updateTime string,
 :externalId string,
 :uniqueId string,
 :endpoint
 {:gkeCluster {:resourceLink string, :clusterMissing boolean},
  :onPremCluster
  {:resourceLink string,
   :clusterMissing boolean,
   :adminCluster boolean,
   :clusterType
   [CLUSTERTYPE_UNSPECIFIED BOOTSTRAP HYBRID STANDALONE USER]},
  :multiCloudCluster {:resourceLink string, :clusterMissing boolean},
  :edgeCluster {:resourceLink string},
  :applianceCluster {:resourceLink string},
  :kubernetesMetadata
  {:kubernetesApiServerVersion string,
   :nodeProviderId string,
   :nodeCount integer,
   :vcpuCount integer,
   :memoryMb integer,
   :updateTime string},
  :kubernetesResource
  {:membershipCrManifest string,
   :membershipResources [{:manifest string, :clusterScoped boolean}],
   :connectResources [{:manifest string, :clusterScoped boolean}],
   :resourceOptions
   {:connectVersion string, :v1beta1Crd boolean, :k8sVersion string}},
  :googleManaged boolean}}

optional:
updateMask <string> Required. Mask of fields to update.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Membership]
    (projects-locations-memberships-patch name Membership nil))
  ([name Membership optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Membership})))

(defn projects-locations-memberships-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkehub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-memberships-create
  "Creates a new Membership. **This is currently only supported for GKE clusters on Google Cloud**. To register other clusters, follow the instructions at https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/create

parent <string> Required. The parent (project and location) where the Memberships will be created. Specified in the format `projects/*/locations/*`.
Membership:
{:description string,
 :labels object,
 :deleteTime string,
 :monitoringConfig
 {:projectId string,
  :location string,
  :cluster string,
  :kubernetesMetricsPrefix string,
  :clusterHash string},
 :name string,
 :authority
 {:issuer string,
  :workloadIdentityPool string,
  :identityProvider string,
  :oidcJwks string},
 :createTime string,
 :state
 {:code
  [CODE_UNSPECIFIED
   CREATING
   READY
   DELETING
   UPDATING
   SERVICE_UPDATING]},
 :lastConnectionTime string,
 :updateTime string,
 :externalId string,
 :uniqueId string,
 :endpoint
 {:gkeCluster {:resourceLink string, :clusterMissing boolean},
  :onPremCluster
  {:resourceLink string,
   :clusterMissing boolean,
   :adminCluster boolean,
   :clusterType
   [CLUSTERTYPE_UNSPECIFIED BOOTSTRAP HYBRID STANDALONE USER]},
  :multiCloudCluster {:resourceLink string, :clusterMissing boolean},
  :edgeCluster {:resourceLink string},
  :applianceCluster {:resourceLink string},
  :kubernetesMetadata
  {:kubernetesApiServerVersion string,
   :nodeProviderId string,
   :nodeCount integer,
   :vcpuCount integer,
   :memoryMb integer,
   :updateTime string},
  :kubernetesResource
  {:membershipCrManifest string,
   :membershipResources [{:manifest string, :clusterScoped boolean}],
   :connectResources [{:manifest string, :clusterScoped boolean}],
   :resourceOptions
   {:connectVersion string, :v1beta1Crd boolean, :k8sVersion string}},
  :googleManaged boolean}}

optional:
membershipId <string> Required. Client chosen ID for the membership. `membership_id` must be a valid RFC 1123 compliant DNS label: 1. At most 63 characters in length 2. It must consist of lower case alphanumeric characters or `-` 3. It must start and end with an alphanumeric character Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]*[a-z0-9])?`, with a maximum length of 63 characters.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Membership]
    (projects-locations-memberships-create parent Membership nil))
  ([parent Membership optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/memberships",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Membership})))

(defn projects-locations-memberships-delete
  "Removes a Membership. **This is currently only supported for GKE clusters on Google Cloud**. To unregister other clusters, follow the instructions at https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/delete

name <string> Required. The Membership resource name in the format `projects/*/locations/*/memberships/*`.

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
force <boolean> Optional. If set to true, any subresource from this Membership will also be deleted. Otherwise, the request will only work if the Membership has no subresource."
  ([name] (projects-locations-memberships-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-memberships-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-memberships-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-memberships-list
  "Lists Memberships in a given project and location.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/list

parent <string> Required. The parent (project and location) where the Memberships will be listed. Specified in the format `projects/*/locations/*`. `projects/*/locations/-` list memberships in all the regions.

optional:
pageSize <integer> Optional. When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned.
filter <string> Optional. Lists Memberships that match the filter expression, following the syntax outlined in https://google.aip.dev/160. Examples: - Name is `bar` in project `foo-proj` and location `global`: name = \"projects/foo-proj/locations/global/membership/bar\" - Memberships that have a label called `foo`: labels.foo:* - Memberships that have a label called `foo` whose value is `bar`: labels.foo = bar - Memberships in the CREATING state: state = CREATING
orderBy <string> Optional. One or more fields to compare and use to sort the output. See https://google.aip.dev/132#ordering."
  ([parent] (projects-locations-memberships-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/memberships",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-memberships-generateConnectManifest
  "Generates the manifest for deployment of the GKE connect agent. **This method is used internally by Google-provided libraries.** Most clients should not need to call this method directly.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships/generateConnectManifest

name <string> Required. The Membership resource name the Agent will associate with, in the format `projects/*/locations/*/memberships/*`.

optional:
namespace <string> Optional. Namespace for GKE Connect agent resources. Defaults to `gke-connect`. The Connect Agent is authorized automatically when run in the default namespace. Otherwise, explicit authorization must be granted with an additional IAM binding.
proxy <string> Optional. URI of a proxy if connectivity from the agent to gkeconnect.googleapis.com requires the use of a proxy. Format must be in the form `http(s)://{proxy_address}`, depending on the HTTP/HTTPS protocol supported by the proxy. This will direct the connect agent's outbound traffic through a HTTP(S) proxy.
version <string> Optional. The Connect agent version to use. Defaults to the most current version.
isUpgrade <boolean> Optional. If true, generate the resources for upgrade only. Some resources generated only for installation (e.g. secrets) will be excluded.
registry <string> Optional. The registry to fetch the connect agent image from. Defaults to gcr.io/gkeconnect.
imagePullSecretContent <string> Optional. The image pull secret content for the registry, if not public."
  ([name]
    (projects-locations-memberships-generateConnectManifest name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+name}:generateConnectManifest",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-memberships-bindings-get
  "Returns the details of a MembershipBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships.bindings/get

name <string> Required. The MembershipBinding resource name in the format `projects/*/locations/*/memberships/*/bindings/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-memberships-bindings-create
  "Creates a MembershipBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships.bindings/create

parent <string> Required. The parent (project and location) where the MembershipBinding will be created. Specified in the format `projects/*/locations/*/memberships/*`.
MembershipBinding:
{:scope string,
 :name string,
 :uid string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :labels object}

optional:
membershipBindingId <string> Required. The ID to use for the MembershipBinding."
  ([parent MembershipBinding]
    (projects-locations-memberships-bindings-create
      parent
      MembershipBinding
      nil))
  ([parent MembershipBinding optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/bindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body MembershipBinding})))

(defn projects-locations-memberships-bindings-patch
  "Updates a MembershipBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships.bindings/patch

name <string> The resource name for the membershipbinding itself `projects/{project}/locations/{location}/memberships/{membership}/bindings/{membershipbinding}`
MembershipBinding:
{:scope string,
 :name string,
 :uid string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :labels object}

optional:
updateMask <string> Required. The fields to be updated."
  ([name MembershipBinding]
    (projects-locations-memberships-bindings-patch
      name
      MembershipBinding
      nil))
  ([name MembershipBinding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body MembershipBinding})))

(defn projects-locations-memberships-bindings-delete
  "Deletes a MembershipBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships.bindings/delete

name <string> Required. The MembershipBinding resource name in the format `projects/*/locations/*/memberships/*/bindings/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-memberships-bindings-list
  "Lists MembershipBindings.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.memberships.bindings/list

parent <string> Required. The parent Membership for which the MembershipBindings will be listed. Specified in the format `projects/*/locations/*/memberships/*`.

optional:
pageSize <integer> Optional. When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned.
filter <string> Optional. Lists MembershipBindings that match the filter expression, following the syntax outlined in https://google.aip.dev/160."
  ([parent] (projects-locations-memberships-bindings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/bindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-scopes-listMemberships
  "Lists Memberships bound to a Scope. The response includes relevant Memberships from all regions.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/listMemberships

scopeName <string> Required. Name of the Scope, in the format `projects/*/locations/global/scopes/*`, to which the Memberships are bound.

optional:
filter <string> Optional. Lists Memberships that match the filter expression, following the syntax outlined in https://google.aip.dev/160. Currently, filtering can be done only based on Memberships's `name`, `labels`, `create_time`, `update_time`, and `unique_id`.
pageSize <integer> Optional. When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned. Pagination is currently not supported; therefore, setting this field does not have any impact for now."
  ([scopeName]
    (projects-locations-scopes-listMemberships scopeName nil))
  ([scopeName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+scopeName}:listMemberships",
       :uri-template-args {:scopeName scopeName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-scopes-get
  "Returns the details of a Scope.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/get

name <string> Required. The Scope resource name in the format `projects/*/locations/*/scopes/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-scopes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/setIamPolicy

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
     "https://gkehub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-scopes-patch
  "Updates a scopes.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/patch

name <string> The resource name for the scope `projects/{project}/locations/{location}/scopes/{scope}`
Scope:
{:name string,
 :uid string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :namespaceLabels object,
 :labels object}

optional:
updateMask <string> Required. The fields to be updated."
  ([name Scope] (projects-locations-scopes-patch name Scope nil))
  ([name Scope optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Scope})))

(defn projects-locations-scopes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkehub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-scopes-create
  "Creates a Scope.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/create

parent <string> Required. The parent (project and location) where the Scope will be created. Specified in the format `projects/*/locations/*`.
Scope:
{:name string,
 :uid string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :namespaceLabels object,
 :labels object}

optional:
scopeId <string> Required. Client chosen ID for the Scope. `scope_id` must be a ????"
  ([parent Scope] (projects-locations-scopes-create parent Scope nil))
  ([parent Scope optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/scopes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Scope})))

(defn projects-locations-scopes-listPermitted
  "Lists permitted Scopes.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/listPermitted

parent <string> Required. The parent (project and location) where the Scope will be listed. Specified in the format `projects/*/locations/*`.

optional:
pageSize <integer> Optional. When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned."
  ([parent] (projects-locations-scopes-listPermitted parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/scopes:listPermitted",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-scopes-delete
  "Deletes a Scope.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/delete

name <string> Required. The Scope resource name in the format `projects/*/locations/*/scopes/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-scopes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-scopes-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-scopes-list
  "Lists Scopes.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes/list

parent <string> Required. The parent (project and location) where the Scope will be listed. Specified in the format `projects/*/locations/*`.

optional:
pageSize <integer> Optional. When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned."
  ([parent] (projects-locations-scopes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/scopes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-scopes-namespaces-get
  "Returns the details of a fleet namespace.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.namespaces/get

name <string> Required. The Namespace resource name in the format `projects/*/locations/*/scopes/*/namespaces/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-scopes-namespaces-create
  "Creates a fleet namespace.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.namespaces/create

parent <string> Required. The parent (project and location) where the Namespace will be created. Specified in the format `projects/*/locations/*/scopes/*`.
Namespace:
{:labels object,
 :deleteTime string,
 :uid string,
 :name string,
 :createTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :scope string,
 :updateTime string,
 :namespaceLabels object}

optional:
scopeNamespaceId <string> Required. Client chosen ID for the Namespace. `namespace_id` must be a valid RFC 1123 compliant DNS label: 1. At most 63 characters in length 2. It must consist of lower case alphanumeric characters or `-` 3. It must start and end with an alphanumeric character Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]*[a-z0-9])?`, with a maximum length of 63 characters."
  ([parent Namespace]
    (projects-locations-scopes-namespaces-create parent Namespace nil))
  ([parent Namespace optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/namespaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Namespace})))

(defn projects-locations-scopes-namespaces-patch
  "Updates a fleet namespace.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.namespaces/patch

name <string> The resource name for the namespace `projects/{project}/locations/{location}/namespaces/{namespace}`
Namespace:
{:labels object,
 :deleteTime string,
 :uid string,
 :name string,
 :createTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :scope string,
 :updateTime string,
 :namespaceLabels object}

optional:
updateMask <string> Required. The fields to be updated."
  ([name Namespace]
    (projects-locations-scopes-namespaces-patch name Namespace nil))
  ([name Namespace optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Namespace})))

(defn projects-locations-scopes-namespaces-delete
  "Deletes a fleet namespace.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.namespaces/delete

name <string> Required. The Namespace resource name in the format `projects/*/locations/*/scopes/*/namespaces/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-scopes-namespaces-list
  "Lists fleet namespaces.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.namespaces/list

parent <string> Required. The parent (project and location) where the Features will be listed. Specified in the format `projects/*/locations/*/scopes/*`.

optional:
pageSize <integer> Optional. When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned."
  ([parent] (projects-locations-scopes-namespaces-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/namespaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-scopes-rbacrolebindings-get
  "Returns the details of a Scope RBACRoleBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.rbacrolebindings/get

name <string> Required. The RBACRoleBinding resource name in the format `projects/*/locations/*/scopes/*/rbacrolebindings/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-scopes-rbacrolebindings-create
  "Creates a Scope RBACRoleBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.rbacrolebindings/create

parent <string> Required. The parent (project and location) where the RBACRoleBinding will be created. Specified in the format `projects/*/locations/*/scopes/*`.
RBACRoleBinding:
{:role {:predefinedRole [UNKNOWN ADMIN EDIT VIEW ANTHOS_SUPPORT]},
 :labels object,
 :deleteTime string,
 :group string,
 :uid string,
 :name string,
 :createTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :updateTime string,
 :user string}

optional:
rbacrolebindingId <string> Required. Client chosen ID for the RBACRoleBinding. `rbacrolebinding_id` must be a valid RFC 1123 compliant DNS label: 1. At most 63 characters in length 2. It must consist of lower case alphanumeric characters or `-` 3. It must start and end with an alphanumeric character Which can be expressed as the regex: `[a-z0-9]([-a-z0-9]*[a-z0-9])?`, with a maximum length of 63 characters."
  ([parent RBACRoleBinding]
    (projects-locations-scopes-rbacrolebindings-create
      parent
      RBACRoleBinding
      nil))
  ([parent RBACRoleBinding optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/rbacrolebindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body RBACRoleBinding})))

(defn projects-locations-scopes-rbacrolebindings-patch
  "Updates a Scope RBACRoleBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.rbacrolebindings/patch

name <string> The resource name for the rbacrolebinding `projects/{project}/locations/{location}/scopes/{scope}/rbacrolebindings/{rbacrolebinding}` or `projects/{project}/locations/{location}/memberships/{membership}/rbacrolebindings/{rbacrolebinding}`
RBACRoleBinding:
{:role {:predefinedRole [UNKNOWN ADMIN EDIT VIEW ANTHOS_SUPPORT]},
 :labels object,
 :deleteTime string,
 :group string,
 :uid string,
 :name string,
 :createTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :updateTime string,
 :user string}

optional:
updateMask <string> Required. The fields to be updated."
  ([name RBACRoleBinding]
    (projects-locations-scopes-rbacrolebindings-patch
      name
      RBACRoleBinding
      nil))
  ([name RBACRoleBinding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body RBACRoleBinding})))

(defn projects-locations-scopes-rbacrolebindings-delete
  "Deletes a Scope RBACRoleBinding.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.rbacrolebindings/delete

name <string> Required. The RBACRoleBinding resource name in the format `projects/*/locations/*/scopes/*/rbacrolebindings/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-scopes-rbacrolebindings-list
  "Lists all Scope RBACRoleBindings.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.scopes.rbacrolebindings/list

parent <string> Required. The parent (project and location) where the Features will be listed. Specified in the format `projects/*/locations/*/scopes/*`.

optional:
pageSize <integer> Optional. When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned."
  ([parent]
    (projects-locations-scopes-rbacrolebindings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/rbacrolebindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-features-list
  "Lists Features in a given project and location.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/list

parent <string> Required. The parent (project and location) where the Features will be listed. Specified in the format `projects/*/locations/*`.

optional:
pageSize <integer> When requesting a 'page' of resources, `page_size` specifies number of resources to return. If unspecified or set to 0, all resources will be returned.
filter <string> Lists Features that match the filter expression, following the syntax outlined in https://google.aip.dev/160. Examples: - Feature with the name \"servicemesh\" in project \"foo-proj\": name = \"projects/foo-proj/locations/global/features/servicemesh\" - Features that have a label called `foo`: labels.foo:* - Features that have a label called `foo` whose value is `bar`: labels.foo = bar
orderBy <string> One or more fields to compare and use to sort the output. See https://google.aip.dev/132#ordering."
  ([parent] (projects-locations-features-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/features",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-features-get
  "Gets details of a single Feature.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/get

name <string> Required. The Feature resource name in the format `projects/*/locations/*/features/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-features-create
  "Adds a new Feature.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/create

parent <string> Required. The parent (project and location) where the Feature will be created. Specified in the format `projects/*/locations/*`.
Feature:
{:labels object,
 :deleteTime string,
 :scopeSpecs object,
 :name string,
 :membershipStates object,
 :createTime string,
 :state
 {:appdevexperience
  {:networkingInstallSucceeded
   {:code [CODE_UNSPECIFIED OK FAILED UNKNOWN], :description string}},
  :fleetobservability
  {:logging
   {:defaultLog
    {:code [CODE_UNSPECIFIED OK ERROR],
     :errors [FleetObservabilityFeatureError]},
    :scopeLog
    {:code [CODE_UNSPECIFIED OK ERROR],
     :errors [FleetObservabilityFeatureError]}},
   :monitoring
   {:state
    {:code [CODE_UNSPECIFIED OK ERROR],
     :errors [FleetObservabilityFeatureError]}}},
  :clusterupgrade
  {:downstreamFleets [string],
   :ignored object,
   :gkeState
   {:upgradeState
    [{:upgrade ClusterUpgradeGKEUpgrade,
      :status ClusterUpgradeUpgradeStatus,
      :stats object}],
    :conditions
    [{:type string,
      :status string,
      :reason string,
      :updateTime string}]}},
  :state
  {:code [CODE_UNSPECIFIED OK WARNING ERROR],
   :description string,
   :updateTime string}},
 :updateTime string,
 :resourceState
 {:state
  [STATE_UNSPECIFIED
   ENABLING
   ACTIVE
   DISABLING
   UPDATING
   SERVICE_UPDATING]},
 :spec
 {:multiclusteringress {:configMembership string},
  :appdevexperience object,
  :fleetobservability
  {:loggingConfig
   {:defaultConfig {:mode [MODE_UNSPECIFIED COPY MOVE]},
    :fleetScopeLogsConfig {:mode [MODE_UNSPECIFIED COPY MOVE]}}},
  :clusterupgrade
  {:upstreamFleets [string],
   :postConditions {:soaking string},
   :gkeUpgradeOverrides
   [{:upgrade {:name string, :version string},
     :postConditions {:soaking string}}]},
  :dataplanev2 {:enableEncryption boolean}},
 :membershipSpecs object,
 :scopeStates object,
 :fleetDefaultMemberConfig
 {:mesh
  {:controlPlane
   [CONTROL_PLANE_MANAGEMENT_UNSPECIFIED AUTOMATIC MANUAL],
   :management
   [MANAGEMENT_UNSPECIFIED MANAGEMENT_AUTOMATIC MANAGEMENT_MANUAL]},
  :configmanagement
  {:configSync
   {:git
    {:syncRepo string,
     :syncBranch string,
     :policyDir string,
     :syncWaitSecs string,
     :syncRev string,
     :secretType string,
     :httpsProxy string,
     :gcpServiceAccountEmail string},
    :sourceFormat string,
    :enabled boolean,
    :preventDrift boolean,
    :oci
    {:syncRepo string,
     :policyDir string,
     :syncWaitSecs string,
     :secretType string,
     :gcpServiceAccountEmail string},
    :allowVerticalScale boolean,
    :metricsGcpServiceAccountEmail string},
   :policyController
   {:monitoring
    {:backends
     [[MONITORING_BACKEND_UNSPECIFIED PROMETHEUS CLOUD_MONITORING]]},
    :exemptableNamespaces [string],
    :templateLibraryInstalled boolean,
    :updateTime string,
    :referentialRulesEnabled boolean,
    :mutationEnabled boolean,
    :logDeniesEnabled boolean,
    :auditIntervalSeconds string,
    :enabled boolean},
   :hierarchyController
   {:enabled boolean,
    :enablePodTreeLabels boolean,
    :enableHierarchicalResourceQuota boolean},
   :version string,
   :cluster string,
   :management
   [MANAGEMENT_UNSPECIFIED MANAGEMENT_AUTOMATIC MANAGEMENT_MANUAL]},
  :identityservice
  {:authMethods
   [{:oidcConfig
     {:scopes string,
      :clientId string,
      :deployCloudConsoleProxy boolean,
      :groupsClaim string,
      :enableAccessToken boolean,
      :userClaim string,
      :issuerUri string,
      :encryptedClientSecret string,
      :kubectlRedirectUri string,
      :userPrefix string,
      :extraParams string,
      :groupPrefix string,
      :certificateAuthorityData string,
      :clientSecret string},
     :azureadConfig
     {:clientId string,
      :tenant string,
      :kubectlRedirectUri string,
      :clientSecret string,
      :encryptedClientSecret string,
      :userClaim string,
      :groupFormat string},
     :googleConfig {:disable boolean},
     :samlConfig
     {:identityProviderId string,
      :identityProviderSsoUri string,
      :identityProviderCertificates [string],
      :userAttribute string,
      :groupsAttribute string,
      :userPrefix string,
      :groupPrefix string,
      :attributeMapping object},
     :ldapConfig
     {:server IdentityServiceServerConfig,
      :user IdentityServiceUserConfig,
      :group IdentityServiceGroupConfig,
      :serviceAccount IdentityServiceServiceAccountConfig},
     :name string,
     :proxy string}],
   :identityServiceOptions {:sessionDuration string}},
  :policycontroller
  {:policyControllerHubConfig
   {:monitoring
    {:backends
     [[MONITORING_BACKEND_UNSPECIFIED PROMETHEUS CLOUD_MONITORING]]},
    :installSpec
    [INSTALL_SPEC_UNSPECIFIED
     INSTALL_SPEC_NOT_INSTALLED
     INSTALL_SPEC_ENABLED
     INSTALL_SPEC_SUSPENDED
     INSTALL_SPEC_DETACHED],
    :constraintViolationLimit string,
    :exemptableNamespaces [string],
    :referentialRulesEnabled boolean,
    :mutationEnabled boolean,
    :logDeniesEnabled boolean,
    :deploymentConfigs object,
    :auditIntervalSeconds string,
    :policyContent
    {:bundles object,
     :templateLibrary PolicyControllerTemplateLibraryConfig}},
   :version string}}}

optional:
featureId <string> The ID of the feature to create.
requestId <string> A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Feature]
    (projects-locations-features-create parent Feature nil))
  ([parent Feature optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/features",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Feature})))

(defn projects-locations-features-delete
  "Removes a Feature.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/delete

name <string> Required. The Feature resource name in the format `projects/*/locations/*/features/*`.

optional:
force <boolean> If set to true, the delete will ignore any outstanding resources for this Feature (that is, `FeatureState.has_resources` is set to true). These resources will NOT be cleaned up or modified in any way.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-features-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-features-patch
  "Updates an existing Feature.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/patch

name <string> Required. The Feature resource name in the format `projects/*/locations/*/features/*`.
Feature:
{:labels object,
 :deleteTime string,
 :scopeSpecs object,
 :name string,
 :membershipStates object,
 :createTime string,
 :state
 {:appdevexperience
  {:networkingInstallSucceeded
   {:code [CODE_UNSPECIFIED OK FAILED UNKNOWN], :description string}},
  :fleetobservability
  {:logging
   {:defaultLog
    {:code [CODE_UNSPECIFIED OK ERROR],
     :errors [FleetObservabilityFeatureError]},
    :scopeLog
    {:code [CODE_UNSPECIFIED OK ERROR],
     :errors [FleetObservabilityFeatureError]}},
   :monitoring
   {:state
    {:code [CODE_UNSPECIFIED OK ERROR],
     :errors [FleetObservabilityFeatureError]}}},
  :clusterupgrade
  {:downstreamFleets [string],
   :ignored object,
   :gkeState
   {:upgradeState
    [{:upgrade ClusterUpgradeGKEUpgrade,
      :status ClusterUpgradeUpgradeStatus,
      :stats object}],
    :conditions
    [{:type string,
      :status string,
      :reason string,
      :updateTime string}]}},
  :state
  {:code [CODE_UNSPECIFIED OK WARNING ERROR],
   :description string,
   :updateTime string}},
 :updateTime string,
 :resourceState
 {:state
  [STATE_UNSPECIFIED
   ENABLING
   ACTIVE
   DISABLING
   UPDATING
   SERVICE_UPDATING]},
 :spec
 {:multiclusteringress {:configMembership string},
  :appdevexperience object,
  :fleetobservability
  {:loggingConfig
   {:defaultConfig {:mode [MODE_UNSPECIFIED COPY MOVE]},
    :fleetScopeLogsConfig {:mode [MODE_UNSPECIFIED COPY MOVE]}}},
  :clusterupgrade
  {:upstreamFleets [string],
   :postConditions {:soaking string},
   :gkeUpgradeOverrides
   [{:upgrade {:name string, :version string},
     :postConditions {:soaking string}}]},
  :dataplanev2 {:enableEncryption boolean}},
 :membershipSpecs object,
 :scopeStates object,
 :fleetDefaultMemberConfig
 {:mesh
  {:controlPlane
   [CONTROL_PLANE_MANAGEMENT_UNSPECIFIED AUTOMATIC MANUAL],
   :management
   [MANAGEMENT_UNSPECIFIED MANAGEMENT_AUTOMATIC MANAGEMENT_MANUAL]},
  :configmanagement
  {:configSync
   {:git
    {:syncRepo string,
     :syncBranch string,
     :policyDir string,
     :syncWaitSecs string,
     :syncRev string,
     :secretType string,
     :httpsProxy string,
     :gcpServiceAccountEmail string},
    :sourceFormat string,
    :enabled boolean,
    :preventDrift boolean,
    :oci
    {:syncRepo string,
     :policyDir string,
     :syncWaitSecs string,
     :secretType string,
     :gcpServiceAccountEmail string},
    :allowVerticalScale boolean,
    :metricsGcpServiceAccountEmail string},
   :policyController
   {:monitoring
    {:backends
     [[MONITORING_BACKEND_UNSPECIFIED PROMETHEUS CLOUD_MONITORING]]},
    :exemptableNamespaces [string],
    :templateLibraryInstalled boolean,
    :updateTime string,
    :referentialRulesEnabled boolean,
    :mutationEnabled boolean,
    :logDeniesEnabled boolean,
    :auditIntervalSeconds string,
    :enabled boolean},
   :hierarchyController
   {:enabled boolean,
    :enablePodTreeLabels boolean,
    :enableHierarchicalResourceQuota boolean},
   :version string,
   :cluster string,
   :management
   [MANAGEMENT_UNSPECIFIED MANAGEMENT_AUTOMATIC MANAGEMENT_MANUAL]},
  :identityservice
  {:authMethods
   [{:oidcConfig
     {:scopes string,
      :clientId string,
      :deployCloudConsoleProxy boolean,
      :groupsClaim string,
      :enableAccessToken boolean,
      :userClaim string,
      :issuerUri string,
      :encryptedClientSecret string,
      :kubectlRedirectUri string,
      :userPrefix string,
      :extraParams string,
      :groupPrefix string,
      :certificateAuthorityData string,
      :clientSecret string},
     :azureadConfig
     {:clientId string,
      :tenant string,
      :kubectlRedirectUri string,
      :clientSecret string,
      :encryptedClientSecret string,
      :userClaim string,
      :groupFormat string},
     :googleConfig {:disable boolean},
     :samlConfig
     {:identityProviderId string,
      :identityProviderSsoUri string,
      :identityProviderCertificates [string],
      :userAttribute string,
      :groupsAttribute string,
      :userPrefix string,
      :groupPrefix string,
      :attributeMapping object},
     :ldapConfig
     {:server IdentityServiceServerConfig,
      :user IdentityServiceUserConfig,
      :group IdentityServiceGroupConfig,
      :serviceAccount IdentityServiceServiceAccountConfig},
     :name string,
     :proxy string}],
   :identityServiceOptions {:sessionDuration string}},
  :policycontroller
  {:policyControllerHubConfig
   {:monitoring
    {:backends
     [[MONITORING_BACKEND_UNSPECIFIED PROMETHEUS CLOUD_MONITORING]]},
    :installSpec
    [INSTALL_SPEC_UNSPECIFIED
     INSTALL_SPEC_NOT_INSTALLED
     INSTALL_SPEC_ENABLED
     INSTALL_SPEC_SUSPENDED
     INSTALL_SPEC_DETACHED],
    :constraintViolationLimit string,
    :exemptableNamespaces [string],
    :referentialRulesEnabled boolean,
    :mutationEnabled boolean,
    :logDeniesEnabled boolean,
    :deploymentConfigs object,
    :auditIntervalSeconds string,
    :policyContent
    {:bundles object,
     :templateLibrary PolicyControllerTemplateLibraryConfig}},
   :version string}}}

optional:
updateMask <string> Mask of fields to update.
requestId <string> A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Feature] (projects-locations-features-patch name Feature nil))
  ([name Feature optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Feature})))

(defn projects-locations-features-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/setIamPolicy

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
     "https://gkehub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-features-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-features-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-features-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.features/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkehub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-fleets-create
  "Creates a fleet.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.fleets/create

parent <string> Required. The parent (project and location) where the Fleet will be created. Specified in the format `projects/*/locations/*`.
Fleet:
{:labels object,
 :deleteTime string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :updateTime string,
 :defaultClusterConfig
 {:securityPostureConfig
  {:mode [MODE_UNSPECIFIED DISABLED BASIC ENTERPRISE],
   :vulnerabilityMode
   [VULNERABILITY_MODE_UNSPECIFIED
    VULNERABILITY_DISABLED
    VULNERABILITY_BASIC
    VULNERABILITY_ENTERPRISE]},
  :binaryAuthorizationConfig
  {:evaluationMode
   [EVALUATION_MODE_UNSPECIFIED DISABLED POLICY_BINDINGS],
   :policyBindings [{:name string}]}}}"
  [parent Fleet]
  (client/api-request
    {:method "POST",
     :uri-template "https://gkehub.googleapis.com/v1/{+parent}/fleets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Fleet}))

(defn projects-locations-fleets-get
  "Returns the details of a fleet.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.fleets/get

name <string> Required. The Fleet resource name in the format `projects/*/locations/*/fleets/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-fleets-patch
  "Updates a fleet.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.fleets/patch

name <string> Output only. The full, unique resource name of this fleet in the format of `projects/{project}/locations/{location}/fleets/{fleet}`. Each Google Cloud project can have at most one fleet resource, named \"default\".
Fleet:
{:labels object,
 :deleteTime string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state {:code [CODE_UNSPECIFIED CREATING READY DELETING UPDATING]},
 :updateTime string,
 :defaultClusterConfig
 {:securityPostureConfig
  {:mode [MODE_UNSPECIFIED DISABLED BASIC ENTERPRISE],
   :vulnerabilityMode
   [VULNERABILITY_MODE_UNSPECIFIED
    VULNERABILITY_DISABLED
    VULNERABILITY_BASIC
    VULNERABILITY_ENTERPRISE]},
  :binaryAuthorizationConfig
  {:evaluationMode
   [EVALUATION_MODE_UNSPECIFIED DISABLED POLICY_BINDINGS],
   :policyBindings [{:name string}]}}}

optional:
updateMask <string> Required. The fields to be updated;"
  ([name Fleet] (projects-locations-fleets-patch name Fleet nil))
  ([name Fleet optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkehub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Fleet})))

(defn projects-locations-fleets-delete
  "Removes a Fleet. There must be no memberships remaining in the Fleet.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.fleets/delete

name <string> Required. The Fleet resource name in the format `projects/*/locations/*/fleets/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://gkehub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-fleets-list
  "Returns all fleets within an organization or a project that the caller has access to.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/projects.locations.fleets/list

parent <string> Required. The organization or project to list for Fleets under, in the format `organizations/*/locations/*` or `projects/*/locations/*`.

optional:
pageSize <integer> Optional. The maximum number of fleets to return. The service may return fewer than this value. If unspecified, at most 200 fleets will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-fleets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/fleets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-fleets-list
  "Returns all fleets within an organization or a project that the caller has access to.
https://cloud.google.com/kubernetes-engine/fleet-management/docs/reference/rest/v1/organizations.locations.fleets/list

parent <string> Required. The organization or project to list for Fleets under, in the format `organizations/*/locations/*` or `projects/*/locations/*`.

optional:
pageSize <integer> Optional. The maximum number of fleets to return. The service may return fewer than this value. If unspecified, at most 200 fleets will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (organizations-locations-fleets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkehub.googleapis.com/v1/{+parent}/fleets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

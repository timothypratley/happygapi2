(ns happygapi2.datafusion
  "Cloud Data Fusion API
Cloud Data Fusion is a fully-managed, cloud native, enterprise data integration service for quickly building and managing data pipelines. It provides a graphical interface to increase time efficiency and reduce complexity, and allows business users, developers, and data scientists to easily and reliably build scalable data integration solutions to cleanse, prepare, blend, transfer and transform data without having to wrestle with infrastructure.
See: https://cloud.google.com/data-fusion/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
includeUnrevealedLocations <boolean> If true, the returned list will include locations which are not yet revealed.
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datafusion.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datafusion.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datafusion.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datafusion.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-versions-list
  "Lists possible versions for Data Fusion instances in the specified project and location.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.versions/list

parent <string> Required. The project and location for which to retrieve instance information in the format projects/{project}/locations/{location}.

optional:
pageSize <integer> The maximum number of items to return.
latestPatchOnly <boolean> Whether or not to return the latest patch of every available minor version. If true, only the latest patch will be returned. Ex. if allowed versions is [6.1.1, 6.1.2, 6.2.0] then response will be [6.1.2, 6.2.0]"
  ([parent] (projects-locations-versions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-get
  "Gets details of a single Data Fusion instance.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/get

name <string> Required. The instance resource name in the format projects/{project}/locations/{location}/instances/{instance}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datafusion.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/setIamPolicy

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
     "https://datafusion.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-instances-restart
  "Restart a single Data Fusion instance. At the end of an operation instance is fully restarted.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/restart

name <string> Required. Name of the Data Fusion instance which need to be restarted in the form of projects/{project}/locations/{location}/instances/{instance}
RestartInstanceRequest:
object"
  [name RestartInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datafusion.googleapis.com/v1/{+name}:restart",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestartInstanceRequest}))

(defn projects-locations-instances-patch
  "Updates a single Data Fusion instance.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/patch

name <string> Output only. The name of this instance is in the form of projects/{project}/locations/{location}/instances/{instance}.
Instance:
{:description string,
 :serviceAccount string,
 :labels object,
 :dataplexDataLineageIntegrationEnabled boolean,
 :gcsBucket string,
 :zone string,
 :displayName string,
 :name string,
 :apiEndpoint string,
 :createTime string,
 :workforceIdentityServiceEndpoint string,
 :patchRevision string,
 :dataprocServiceAccount string,
 :type [TYPE_UNSPECIFIED BASIC ENTERPRISE DEVELOPER],
 :enableRbac boolean,
 :serviceEndpoint string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  FAILED
  DELETING
  UPGRADING
  RESTARTING
  UPDATING
  AUTO_UPDATING
  AUTO_UPGRADING
  DISABLED],
 :availableVersion
 [{:versionNumber string,
   :defaultVersion boolean,
   :availableFeatures [string],
   :type [TYPE_UNSPECIFIED TYPE_PREVIEW TYPE_GENERAL_AVAILABILITY]}],
 :networkConfig
 {:network string,
  :ipAllocation string,
  :connectionType
  [CONNECTION_TYPE_UNSPECIFIED
   VPC_PEERING
   PRIVATE_SERVICE_CONNECT_INTERFACES],
  :privateServiceConnectConfig
  {:networkAttachment string,
   :unreachableCidrBlock string,
   :effectiveUnreachableCidrBlock string}},
 :updateTime string,
 :enableStackdriverMonitoring boolean,
 :cryptoKeyConfig {:keyReference string},
 :p4ServiceAccount string,
 :satisfiesPzs boolean,
 :enableStackdriverLogging boolean,
 :enableZoneSeparation boolean,
 :options object,
 :eventPublishConfig {:enabled boolean, :topic string},
 :tenantProjectId string,
 :version string,
 :disabledReason [[DISABLED_REASON_UNSPECIFIED KMS_KEY_ISSUE]],
 :privateInstance boolean,
 :stateMessage string,
 :accelerators
 [{:acceleratorType
   [ACCELERATOR_TYPE_UNSPECIFIED
    CDC
    HEALTHCARE
    CCAI_INSIGHTS
    CLOUDSEARCH],
   :state [STATE_UNSPECIFIED ENABLED DISABLED UNKNOWN]}]}

optional:
updateMask <string> Field mask is used to specify the fields that the update will overwrite in an instance resource. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask, the label field will be overwritten."
  ([name Instance]
    (projects-locations-instances-patch name Instance nil))
  ([name Instance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datafusion.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datafusion.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-instances-create
  "Creates a new Data Fusion instance in the specified project and location.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/create

parent <string> Required. The instance's project and location in the format projects/{project}/locations/{location}.
Instance:
{:description string,
 :serviceAccount string,
 :labels object,
 :dataplexDataLineageIntegrationEnabled boolean,
 :gcsBucket string,
 :zone string,
 :displayName string,
 :name string,
 :apiEndpoint string,
 :createTime string,
 :workforceIdentityServiceEndpoint string,
 :patchRevision string,
 :dataprocServiceAccount string,
 :type [TYPE_UNSPECIFIED BASIC ENTERPRISE DEVELOPER],
 :enableRbac boolean,
 :serviceEndpoint string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  FAILED
  DELETING
  UPGRADING
  RESTARTING
  UPDATING
  AUTO_UPDATING
  AUTO_UPGRADING
  DISABLED],
 :availableVersion
 [{:versionNumber string,
   :defaultVersion boolean,
   :availableFeatures [string],
   :type [TYPE_UNSPECIFIED TYPE_PREVIEW TYPE_GENERAL_AVAILABILITY]}],
 :networkConfig
 {:network string,
  :ipAllocation string,
  :connectionType
  [CONNECTION_TYPE_UNSPECIFIED
   VPC_PEERING
   PRIVATE_SERVICE_CONNECT_INTERFACES],
  :privateServiceConnectConfig
  {:networkAttachment string,
   :unreachableCidrBlock string,
   :effectiveUnreachableCidrBlock string}},
 :updateTime string,
 :enableStackdriverMonitoring boolean,
 :cryptoKeyConfig {:keyReference string},
 :p4ServiceAccount string,
 :satisfiesPzs boolean,
 :enableStackdriverLogging boolean,
 :enableZoneSeparation boolean,
 :options object,
 :eventPublishConfig {:enabled boolean, :topic string},
 :tenantProjectId string,
 :version string,
 :disabledReason [[DISABLED_REASON_UNSPECIFIED KMS_KEY_ISSUE]],
 :privateInstance boolean,
 :stateMessage string,
 :accelerators
 [{:acceleratorType
   [ACCELERATOR_TYPE_UNSPECIFIED
    CDC
    HEALTHCARE
    CCAI_INSIGHTS
    CLOUDSEARCH],
   :state [STATE_UNSPECIFIED ENABLED DISABLED UNKNOWN]}]}

optional:
instanceId <string> Required. The name of the instance to create. Instance name can only contain lowercase alphanumeric characters and hyphens. It must start with a letter and must not end with a hyphen. It can have a maximum of 30 characters."
  ([parent Instance]
    (projects-locations-instances-create parent Instance nil))
  ([parent Instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-delete
  "Deletes a single Date Fusion instance.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/delete

name <string> Required. The instance resource name in the format projects/{project}/locations/{location}/instances/{instance}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datafusion.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-instances-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-list
  "Lists Data Fusion instances in the specified project and location.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances/list

parent <string> Required. The project and location for which to retrieve instance information in the format projects/{project}/locations/{location}. If the location is specified as '-' (wildcard), then all regions available to the project are queried, and the results are aggregated.

optional:
pageSize <integer> The maximum number of items to return.
filter <string> List filter.
orderBy <string> Sort results. Supported values are \"name\", \"name desc\", or \"\" (unsorted)."
  ([parent] (projects-locations-instances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-dnsPeerings-create
  "Creates DNS peering on the given resource.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances.dnsPeerings/create

parent <string> Required. The resource on which DNS peering will be created.
DnsPeering:
{:name string,
 :domain string,
 :description string,
 :targetProject string,
 :targetNetwork string}

optional:
dnsPeeringId <string> Required. The name of the peering to create."
  ([parent DnsPeering]
    (projects-locations-instances-dnsPeerings-create
      parent
      DnsPeering
      nil))
  ([parent DnsPeering optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+parent}/dnsPeerings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DnsPeering})))

(defn projects-locations-instances-dnsPeerings-delete
  "Deletes DNS peering on the given resource.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances.dnsPeerings/delete

name <string> Required. The name of the DNS peering zone to delete. Format: projects/{project}/locations/{location}/instances/{instance}/dnsPeerings/{dns_peering}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datafusion.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-dnsPeerings-list
  "Lists DNS peerings for a given resource.
https://cloud.google.com/data-fusion/docs/reference/rest/v1/projects.locations.instances.dnsPeerings/list

parent <string> Required. The parent, which owns this collection of dns peerings. Format: projects/{project}/locations/{location}/instances/{instance}

optional:
pageSize <integer> The maximum number of dns peerings to return. The service may return fewer than this value. If unspecified, at most 50 dns peerings will be returned. The maximum value is 200; values above 200 will be coerced to 200."
  ([parent] (projects-locations-instances-dnsPeerings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datafusion.googleapis.com/v1/{+parent}/dnsPeerings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(ns happygapi2.metastore
  "Dataproc Metastore API
The Dataproc Metastore API is used to manage the lifecycle and configuration of metastore services.
See: https://cloud.google.com/dataproc-metastore/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like \"displayName=tokyo\", and is documented in more detail in AIP-160 (https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://metastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://metastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://metastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-federations-list
  "Lists federations in a project and location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/list

parent <string> Required. The relative resource name of the location of metastore federations to list, in the following form: projects/{project_number}/locations/{location_id}.

optional:
pageSize <integer> Optional. The maximum number of federations to return. The response may contain less than the maximum number. If unspecified, no more than 500 services are returned. The maximum value is 1000; values above 1000 are changed to 1000.
filter <string> Optional. The filter to apply to list results.
orderBy <string> Optional. Specify the ordering of results as described in Sorting Order (https://cloud.google.com/apis/design/design_patterns#sorting_order). If not specified, the results will be sorted in the default order."
  ([parent] (projects-locations-federations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/federations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-federations-get
  "Gets the details of a single federation.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/get

name <string> Required. The relative resource name of the metastore federation to retrieve, in the following form:projects/{project_number}/locations/{location_id}/federations/{federation_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://metastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-federations-create
  "Creates a metastore federation in a project and location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/create

parent <string> Required. The relative resource name of the location in which to create a federation service, in the following form:projects/{project_number}/locations/{location_id}.
Federation:
{:endpointUri string,
 :labels object,
 :backendMetastores object,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE UPDATING DELETING ERROR],
 :updateTime string,
 :version string,
 :stateMessage string}

optional:
federationId <string> Required. The ID of the metastore federation, which is used as the final component of the metastore federation's name.This value must be between 2 and 63 characters long inclusive, begin with a letter, end with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([parent Federation]
    (projects-locations-federations-create parent Federation nil))
  ([parent Federation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/federations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Federation})))

(defn projects-locations-federations-patch
  "Updates the fields of a federation.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/patch

name <string> Immutable. The relative resource name of the federation, of the form: projects/{project_number}/locations/{location_id}/federations/{federation_id}`.
Federation:
{:endpointUri string,
 :labels object,
 :backendMetastores object,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE UPDATING DELETING ERROR],
 :updateTime string,
 :version string,
 :stateMessage string}

optional:
updateMask <string> Required. A field mask used to specify the fields to be overwritten in the metastore federation resource by the update. Fields specified in the update_mask are relative to the resource (not to the full request). A field is overwritten if it is in the mask.
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([name Federation]
    (projects-locations-federations-patch name Federation nil))
  ([name Federation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://metastore.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Federation})))

(defn projects-locations-federations-delete
  "Deletes a single federation.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/delete

name <string> Required. The relative resource name of the metastore federation to delete, in the following form:projects/{project_number}/locations/{location_id}/federations/{federation_id}.

optional:
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([name] (projects-locations-federations-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://metastore.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-federations-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
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
     "https://metastore.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-federations-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-federations-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-federations-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.federations/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-services-get
  "Gets the details of a single service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/get

name <string> Required. The relative resource name of the metastore service to retrieve, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://metastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-services-queryMetadata
  "Query Dataproc Metastore metadata.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/queryMetadata

service <string> Required. The relative resource name of the metastore service to query metadata, in the following format:projects/{project_id}/locations/{location_id}/services/{service_id}.
QueryMetadataRequest:
{:query string}"
  [service QueryMetadataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+service}:queryMetadata",
     :uri-template-args {:service service},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body QueryMetadataRequest}))

(defn projects-locations-services-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
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
     "https://metastore.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-services-patch
  "Updates the parameters of a single service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/patch

name <string> Immutable. The relative resource name of the metastore service, in the following format:projects/{project_number}/locations/{location_id}/services/{service_id}.
Service:
{:endpointUri string,
 :labels object,
 :tier [TIER_UNSPECIFIED DEVELOPER ENTERPRISE],
 :metadataManagementActivity
 {:metadataExports
  [{:destinationGcsUri string,
    :startTime string,
    :endTime string,
    :state [STATE_UNSPECIFIED RUNNING SUCCEEDED FAILED CANCELLED],
    :databaseDumpType [TYPE_UNSPECIFIED MYSQL AVRO]}],
  :restores
  [{:startTime string,
    :endTime string,
    :state [STATE_UNSPECIFIED RUNNING SUCCEEDED FAILED CANCELLED],
    :backup string,
    :type [RESTORE_TYPE_UNSPECIFIED FULL METADATA_ONLY],
    :details string,
    :backupLocation string}]},
 :telemetryConfig {:logFormat [LOG_FORMAT_UNSPECIFIED LEGACY JSON]},
 :scalingConfig
 {:instanceSize
  [INSTANCE_SIZE_UNSPECIFIED
   EXTRA_SMALL
   SMALL
   MEDIUM
   LARGE
   EXTRA_LARGE],
  :scalingFactor number},
 :uid string,
 :name string,
 :createTime string,
 :scheduledBackup
 {:enabled boolean,
  :cronSchedule string,
  :timeZone string,
  :nextScheduledTime string,
  :backupLocation string,
  :latestBackup
  {:backupId string,
   :startTime string,
   :state [STATE_UNSPECIFIED IN_PROGRESS SUCCEEDED FAILED],
   :duration string}},
 :hiveMetastoreConfig
 {:version string,
  :configOverrides object,
  :kerberosConfig
  {:keytab {:cloudSecret string},
   :principal string,
   :krb5ConfigGcsUri string},
  :endpointProtocol [ENDPOINT_PROTOCOL_UNSPECIFIED THRIFT GRPC],
  :auxiliaryVersions object},
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  SUSPENDING
  SUSPENDED
  UPDATING
  DELETING
  ERROR],
 :port integer,
 :networkConfig
 {:consumers
  [{:subnetwork string,
    :endpointUri string,
    :endpointLocation string}]},
 :releaseChannel [RELEASE_CHANNEL_UNSPECIFIED CANARY STABLE],
 :updateTime string,
 :artifactGcsUri string,
 :maintenanceWindow
 {:hourOfDay integer,
  :dayOfWeek
  [DAY_OF_WEEK_UNSPECIFIED
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY]},
 :databaseType [DATABASE_TYPE_UNSPECIFIED MYSQL SPANNER],
 :network string,
 :metadataIntegration {:dataCatalogConfig {:enabled boolean}},
 :deletionProtection boolean,
 :encryptionConfig {:kmsKey string},
 :stateMessage string}

optional:
updateMask <string> Required. A field mask used to specify the fields to be overwritten in the metastore service resource by the update. Fields specified in the update_mask are relative to the resource (not to the full request). A field is overwritten if it is in the mask.
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([name Service] (projects-locations-services-patch name Service nil))
  ([name Service optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://metastore.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Service})))

(defn projects-locations-services-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-services-restore
  "Restores a service from a backup.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/restore

service <string> Required. The relative resource name of the metastore service to run restore, in the following form:projects/{project_id}/locations/{location_id}/services/{service_id}.
RestoreServiceRequest:
{:backup string,
 :backupLocation string,
 :restoreType [RESTORE_TYPE_UNSPECIFIED FULL METADATA_ONLY],
 :requestId string}"
  [service RestoreServiceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+service}:restore",
     :uri-template-args {:service service},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestoreServiceRequest}))

(defn projects-locations-services-create
  "Creates a metastore service in a project and location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/create

parent <string> Required. The relative resource name of the location in which to create a metastore service, in the following form:projects/{project_number}/locations/{location_id}.
Service:
{:endpointUri string,
 :labels object,
 :tier [TIER_UNSPECIFIED DEVELOPER ENTERPRISE],
 :metadataManagementActivity
 {:metadataExports
  [{:destinationGcsUri string,
    :startTime string,
    :endTime string,
    :state [STATE_UNSPECIFIED RUNNING SUCCEEDED FAILED CANCELLED],
    :databaseDumpType [TYPE_UNSPECIFIED MYSQL AVRO]}],
  :restores
  [{:startTime string,
    :endTime string,
    :state [STATE_UNSPECIFIED RUNNING SUCCEEDED FAILED CANCELLED],
    :backup string,
    :type [RESTORE_TYPE_UNSPECIFIED FULL METADATA_ONLY],
    :details string,
    :backupLocation string}]},
 :telemetryConfig {:logFormat [LOG_FORMAT_UNSPECIFIED LEGACY JSON]},
 :scalingConfig
 {:instanceSize
  [INSTANCE_SIZE_UNSPECIFIED
   EXTRA_SMALL
   SMALL
   MEDIUM
   LARGE
   EXTRA_LARGE],
  :scalingFactor number},
 :uid string,
 :name string,
 :createTime string,
 :scheduledBackup
 {:enabled boolean,
  :cronSchedule string,
  :timeZone string,
  :nextScheduledTime string,
  :backupLocation string,
  :latestBackup
  {:backupId string,
   :startTime string,
   :state [STATE_UNSPECIFIED IN_PROGRESS SUCCEEDED FAILED],
   :duration string}},
 :hiveMetastoreConfig
 {:version string,
  :configOverrides object,
  :kerberosConfig
  {:keytab {:cloudSecret string},
   :principal string,
   :krb5ConfigGcsUri string},
  :endpointProtocol [ENDPOINT_PROTOCOL_UNSPECIFIED THRIFT GRPC],
  :auxiliaryVersions object},
 :state
 [STATE_UNSPECIFIED
  CREATING
  ACTIVE
  SUSPENDING
  SUSPENDED
  UPDATING
  DELETING
  ERROR],
 :port integer,
 :networkConfig
 {:consumers
  [{:subnetwork string,
    :endpointUri string,
    :endpointLocation string}]},
 :releaseChannel [RELEASE_CHANNEL_UNSPECIFIED CANARY STABLE],
 :updateTime string,
 :artifactGcsUri string,
 :maintenanceWindow
 {:hourOfDay integer,
  :dayOfWeek
  [DAY_OF_WEEK_UNSPECIFIED
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY]},
 :databaseType [DATABASE_TYPE_UNSPECIFIED MYSQL SPANNER],
 :network string,
 :metadataIntegration {:dataCatalogConfig {:enabled boolean}},
 :deletionProtection boolean,
 :encryptionConfig {:kmsKey string},
 :stateMessage string}

optional:
serviceId <string> Required. The ID of the metastore service, which is used as the final component of the metastore service's name.This value must be between 2 and 63 characters long inclusive, begin with a letter, end with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([parent Service]
    (projects-locations-services-create parent Service nil))
  ([parent Service optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Service})))

(defn projects-locations-services-delete
  "Deletes a single service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/delete

name <string> Required. The relative resource name of the metastore service to delete, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}.

optional:
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([name] (projects-locations-services-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://metastore.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-services-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-moveTableToDatabase
  "Move a table to another database.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/moveTableToDatabase

service <string> Required. The relative resource name of the metastore service to mutate metadata, in the following format:projects/{project_id}/locations/{location_id}/services/{service_id}.
MoveTableToDatabaseRequest:
{:tableName string, :dbName string, :destinationDbName string}"
  [service MoveTableToDatabaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+service}:moveTableToDatabase",
     :uri-template-args {:service service},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body MoveTableToDatabaseRequest}))

(defn projects-locations-services-list
  "Lists services in a project and location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/list

parent <string> Required. The relative resource name of the location of metastore services to list, in the following form:projects/{project_number}/locations/{location_id}.

optional:
pageSize <integer> Optional. The maximum number of services to return. The response may contain less than the maximum number. If unspecified, no more than 500 services are returned. The maximum value is 1000; values above 1000 are changed to 1000.
filter <string> Optional. The filter to apply to list results.
orderBy <string> Optional. Specify the ordering of results as described in Sorting Order (https://cloud.google.com/apis/design/design_patterns#sorting_order). If not specified, the results will be sorted in the default order."
  ([parent] (projects-locations-services-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-alterTableProperties
  "Alter metadata table properties.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/alterTableProperties

service <string> Required. The relative resource name of the Dataproc Metastore service that's being used to mutate metadata table properties, in the following format:projects/{project_id}/locations/{location_id}/services/{service_id}.
AlterTablePropertiesRequest:
{:tableName string, :updateMask string, :properties object}"
  [service AlterTablePropertiesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+service}:alterTableProperties",
     :uri-template-args {:service service},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AlterTablePropertiesRequest}))

(defn projects-locations-services-exportMetadata
  "Exports metadata from a service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/exportMetadata

service <string> Required. The relative resource name of the metastore service to run export, in the following form:projects/{project_id}/locations/{location_id}/services/{service_id}.
ExportMetadataRequest:
{:destinationGcsFolder string,
 :requestId string,
 :databaseDumpType [TYPE_UNSPECIFIED MYSQL AVRO]}"
  [service ExportMetadataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+service}:exportMetadata",
     :uri-template-args {:service service},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportMetadataRequest}))

(defn projects-locations-services-alterLocation
  "Alter metadata resource location. The metadata resource can be a database, table, or partition. This functionality only updates the parent directory for the respective metadata resource and does not transfer any existing data to the new location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services/alterLocation

service <string> Required. The relative resource name of the metastore service to mutate metadata, in the following format:projects/{project_id}/locations/{location_id}/services/{service_id}.
AlterMetadataResourceLocationRequest:
{:resourceName string, :locationUri string}"
  [service AlterMetadataResourceLocationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://metastore.googleapis.com/v1/{+service}:alterLocation",
     :uri-template-args {:service service},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AlterMetadataResourceLocationRequest}))

(defn projects-locations-services-metadataImports-list
  "Lists imports in a service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.metadataImports/list

parent <string> Required. The relative resource name of the service whose metadata imports to list, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}/metadataImports.

optional:
pageSize <integer> Optional. The maximum number of imports to return. The response may contain less than the maximum number. If unspecified, no more than 500 imports are returned. The maximum value is 1000; values above 1000 are changed to 1000.
filter <string> Optional. The filter to apply to list results.
orderBy <string> Optional. Specify the ordering of results as described in Sorting Order (https://cloud.google.com/apis/design/design_patterns#sorting_order). If not specified, the results will be sorted in the default order."
  ([parent]
    (projects-locations-services-metadataImports-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/metadataImports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-metadataImports-get
  "Gets details of a single import.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.metadataImports/get

name <string> Required. The relative resource name of the metadata import to retrieve, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}/metadataImports/{import_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://metastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-services-metadataImports-create
  "Creates a new MetadataImport in a given project and location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.metadataImports/create

parent <string> Required. The relative resource name of the service in which to create a metastore import, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}.
MetadataImport:
{:databaseDump
 {:databaseType [DATABASE_TYPE_UNSPECIFIED MYSQL],
  :gcsUri string,
  :sourceDatabase string,
  :type [TYPE_UNSPECIFIED MYSQL AVRO]},
 :name string,
 :description string,
 :createTime string,
 :updateTime string,
 :endTime string,
 :state [STATE_UNSPECIFIED RUNNING SUCCEEDED UPDATING FAILED]}

optional:
metadataImportId <string> Required. The ID of the metadata import, which is used as the final component of the metadata import's name.This value must be between 1 and 64 characters long, begin with a letter, end with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([parent MetadataImport]
    (projects-locations-services-metadataImports-create
      parent
      MetadataImport
      nil))
  ([parent MetadataImport optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/metadataImports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body MetadataImport})))

(defn projects-locations-services-metadataImports-patch
  "Updates a single import. Only the description field of MetadataImport is supported to be updated.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.metadataImports/patch

name <string> Immutable. The relative resource name of the metadata import, of the form:projects/{project_number}/locations/{location_id}/services/{service_id}/metadataImports/{metadata_import_id}.
MetadataImport:
{:databaseDump
 {:databaseType [DATABASE_TYPE_UNSPECIFIED MYSQL],
  :gcsUri string,
  :sourceDatabase string,
  :type [TYPE_UNSPECIFIED MYSQL AVRO]},
 :name string,
 :description string,
 :createTime string,
 :updateTime string,
 :endTime string,
 :state [STATE_UNSPECIFIED RUNNING SUCCEEDED UPDATING FAILED]}

optional:
updateMask <string> Required. A field mask used to specify the fields to be overwritten in the metadata import resource by the update. Fields specified in the update_mask are relative to the resource (not to the full request). A field is overwritten if it is in the mask.
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([name MetadataImport]
    (projects-locations-services-metadataImports-patch
      name
      MetadataImport
      nil))
  ([name MetadataImport optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://metastore.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body MetadataImport})))

(defn projects-locations-services-backups-list
  "Lists backups in a service.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.backups/list

parent <string> Required. The relative resource name of the service whose backups to list, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}/backups.

optional:
pageSize <integer> Optional. The maximum number of backups to return. The response may contain less than the maximum number. If unspecified, no more than 500 backups are returned. The maximum value is 1000; values above 1000 are changed to 1000.
filter <string> Optional. The filter to apply to list results.
orderBy <string> Optional. Specify the ordering of results as described in Sorting Order (https://cloud.google.com/apis/design/design_patterns#sorting_order). If not specified, the results will be sorted in the default order."
  ([parent] (projects-locations-services-backups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-backups-get
  "Gets details of a single backup.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.backups/get

name <string> Required. The relative resource name of the backup to retrieve, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}/backups/{backup_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://metastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-services-backups-create
  "Creates a new backup in a given project and location.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.backups/create

parent <string> Required. The relative resource name of the service in which to create a backup of the following form:projects/{project_number}/locations/{location_id}/services/{service_id}.
Backup:
{:name string,
 :createTime string,
 :endTime string,
 :state [STATE_UNSPECIFIED CREATING DELETING ACTIVE FAILED RESTORING],
 :serviceRevision
 {:endpointUri string,
  :labels object,
  :tier [TIER_UNSPECIFIED DEVELOPER ENTERPRISE],
  :metadataManagementActivity
  {:metadataExports
   [{:destinationGcsUri string,
     :startTime string,
     :endTime string,
     :state [STATE_UNSPECIFIED RUNNING SUCCEEDED FAILED CANCELLED],
     :databaseDumpType [TYPE_UNSPECIFIED MYSQL AVRO]}],
   :restores
   [{:startTime string,
     :endTime string,
     :state [STATE_UNSPECIFIED RUNNING SUCCEEDED FAILED CANCELLED],
     :backup string,
     :type [RESTORE_TYPE_UNSPECIFIED FULL METADATA_ONLY],
     :details string,
     :backupLocation string}]},
  :telemetryConfig {:logFormat [LOG_FORMAT_UNSPECIFIED LEGACY JSON]},
  :scalingConfig
  {:instanceSize
   [INSTANCE_SIZE_UNSPECIFIED
    EXTRA_SMALL
    SMALL
    MEDIUM
    LARGE
    EXTRA_LARGE],
   :scalingFactor number},
  :uid string,
  :name string,
  :createTime string,
  :scheduledBackup
  {:enabled boolean,
   :cronSchedule string,
   :timeZone string,
   :nextScheduledTime string,
   :backupLocation string,
   :latestBackup
   {:backupId string,
    :startTime string,
    :state [STATE_UNSPECIFIED IN_PROGRESS SUCCEEDED FAILED],
    :duration string}},
  :hiveMetastoreConfig
  {:version string,
   :configOverrides object,
   :kerberosConfig
   {:keytab {:cloudSecret string},
    :principal string,
    :krb5ConfigGcsUri string},
   :endpointProtocol [ENDPOINT_PROTOCOL_UNSPECIFIED THRIFT GRPC],
   :auxiliaryVersions object},
  :state
  [STATE_UNSPECIFIED
   CREATING
   ACTIVE
   SUSPENDING
   SUSPENDED
   UPDATING
   DELETING
   ERROR],
  :port integer,
  :networkConfig
  {:consumers
   [{:subnetwork string,
     :endpointUri string,
     :endpointLocation string}]},
  :releaseChannel [RELEASE_CHANNEL_UNSPECIFIED CANARY STABLE],
  :updateTime string,
  :artifactGcsUri string,
  :maintenanceWindow
  {:hourOfDay integer,
   :dayOfWeek
   [DAY_OF_WEEK_UNSPECIFIED
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY]},
  :databaseType [DATABASE_TYPE_UNSPECIFIED MYSQL SPANNER],
  :network string,
  :metadataIntegration {:dataCatalogConfig {:enabled boolean}},
  :deletionProtection boolean,
  :encryptionConfig {:kmsKey string},
  :stateMessage string},
 :description string,
 :restoringServices [string]}

optional:
backupId <string> Required. The ID of the backup, which is used as the final component of the backup's name.This value must be between 1 and 64 characters long, begin with a letter, end with a letter or number, and consist of alpha-numeric ASCII characters or hyphens.
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([parent Backup]
    (projects-locations-services-backups-create parent Backup nil))
  ([parent Backup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://metastore.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-services-backups-delete
  "Deletes a single backup.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.backups/delete

name <string> Required. The relative resource name of the backup to delete, in the following form:projects/{project_number}/locations/{location_id}/services/{service_id}/backups/{backup_id}.

optional:
requestId <string> Optional. A request ID. Specify a unique request ID to allow the server to ignore the request if it has completed. The server will ignore subsequent requests that provide a duplicate request ID for at least 60 minutes after the first request.For example, if an initial request times out, followed by another request with the same request ID, the server ignores the second request to prevent the creation of duplicate commitments.The request ID must be a valid UUID (https://en.wikipedia.org/wiki/Universally_unique_identifier#Format) A zero UUID (00000000-0000-0000-0000-000000000000) is not supported."
  ([name] (projects-locations-services-backups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://metastore.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-backups-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.backups/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
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
     "https://metastore.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-services-backups-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.backups/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-services-backups-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-databases-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.databases/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
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
     "https://metastore.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-services-databases-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.databases/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-services-databases-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-databases-tables-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.databases.tables/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
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
     "https://metastore.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-services-databases-tables-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataproc-metastore/docs/reference/rest/v1/projects.locations.services.databases.tables/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-services-databases-tables-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://metastore.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

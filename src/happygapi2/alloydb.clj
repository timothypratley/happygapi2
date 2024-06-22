(ns happygapi2.alloydb
  "AlloyDB API
AlloyDB for PostgreSQL is an open source-compatible database service that provides a powerful option for migrating, modernizing, or building commercial-grade applications. It offers full compatibility with standard PostgreSQL, and is more than 4x faster for transactional workloads and up to 100x faster for analytical queries than standard PostgreSQL in our performance tests. AlloyDB for PostgreSQL offers a 99.99 percent availability SLA inclusive of maintenance. AlloyDB is optimized for the most demanding use cases, allowing you to build new applications that require high transaction throughput, large database sizes, or multiple read resources; scale existing PostgreSQL workloads with no application changes; and modernize legacy proprietary databases. 
See: https://cloud.google.com/alloydb/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-clusters-list
  "Lists Clusters in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/list

parent <string> Required. The name of the parent resource. For the required format, see the comment on the Cluster.name field. Additionally, you can perform an aggregated list operation by specifying a value with the following format: * projects/{project}/locations/-

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results
orderBy <string> Optional. Hint for how to order the results"
  ([parent] (projects-locations-clusters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-get
  "Gets details of a single Cluster.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/get

name <string> Required. The name of the resource. For the required format, see the comment on the Cluster.name field.

optional:
view <string> Optional. The view of the cluster to return. Returns all default fields if not set."
  ([name] (projects-locations-clusters-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-create
  "Creates a new Cluster in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/create

parent <string> Required. The location of the new cluster. For the required format, see the comment on the Cluster.name field.
Cluster:
{:labels object,
 :continuousBackupConfig
 {:enabled boolean,
  :recoveryWindowDays integer,
  :encryptionConfig {:kmsKeyName string}},
 :databaseVersion
 [DATABASE_VERSION_UNSPECIFIED POSTGRES_13 POSTGRES_14 POSTGRES_15],
 :initialUser {:user string, :password string},
 :deleteTime string,
 :encryptionInfo
 {:encryptionType
  [TYPE_UNSPECIFIED
   GOOGLE_DEFAULT_ENCRYPTION
   CUSTOMER_MANAGED_ENCRYPTION],
  :kmsKeyVersions [string]},
 :displayName string,
 :uid string,
 :name string,
 :primaryConfig {:secondaryClusterNames [string]},
 :continuousBackupInfo
 {:encryptionInfo
  {:encryptionType
   [TYPE_UNSPECIFIED
    GOOGLE_DEFAULT_ENCRYPTION
    CUSTOMER_MANAGED_ENCRYPTION],
   :kmsKeyVersions [string]},
  :enabledTime string,
  :schedule
  [[DAY_OF_WEEK_UNSPECIFIED
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY]],
  :earliestRestorableTime string},
 :createTime string,
 :pscConfig {:pscEnabled boolean},
 :etag string,
 :maintenanceSchedule {:startTime string},
 :state
 [STATE_UNSPECIFIED
  READY
  STOPPED
  EMPTY
  CREATING
  DELETING
  FAILED
  BOOTSTRAPPING
  MAINTENANCE
  PROMOTING],
 :networkConfig {:network string, :allocatedIpRange string},
 :updateTime string,
 :reconciling boolean,
 :maintenanceUpdatePolicy
 {:maintenanceWindows
  [{:day
    [DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY],
    :startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer}}]},
 :automatedBackupPolicy
 {:weeklySchedule
  {:startTimes
   [{:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer}],
   :daysOfWeek
   [[DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY]]},
  :timeBasedRetention {:retentionPeriod string},
  :quantityBasedRetention {:count integer},
  :enabled boolean,
  :backupWindow string,
  :encryptionConfig {:kmsKeyName string},
  :location string,
  :labels object},
 :satisfiesPzs boolean,
 :migrationSource
 {:hostPort string,
  :referenceId string,
  :sourceType [MIGRATION_SOURCE_TYPE_UNSPECIFIED DMS]},
 :annotations object,
 :network string,
 :sslConfig
 {:sslMode
  [SSL_MODE_UNSPECIFIED
   SSL_MODE_ALLOW
   SSL_MODE_REQUIRE
   SSL_MODE_VERIFY_CA
   ALLOW_UNENCRYPTED_AND_ENCRYPTED
   ENCRYPTED_ONLY],
  :caSource [CA_SOURCE_UNSPECIFIED CA_SOURCE_MANAGED]},
 :secondaryConfig {:primaryClusterName string},
 :backupSource {:backupUid string, :backupName string},
 :clusterType [CLUSTER_TYPE_UNSPECIFIED PRIMARY SECONDARY],
 :encryptionConfig {:kmsKeyName string}}

optional:
clusterId <string> Required. ID of the requesting object.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the create request."
  ([parent Cluster]
    (projects-locations-clusters-create parent Cluster nil))
  ([parent Cluster optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-locations-clusters-patch
  "Updates the parameters of a single Cluster.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/patch

name <string> Output only. The name of the cluster resource with the format: * projects/{project}/locations/{region}/clusters/{cluster_id} where the cluster ID segment should satisfy the regex expression `[a-z0-9-]+`. For more details see https://google.aip.dev/122. The prefix of the cluster resource name is the name of the parent resource: * projects/{project}/locations/{region}
Cluster:
{:labels object,
 :continuousBackupConfig
 {:enabled boolean,
  :recoveryWindowDays integer,
  :encryptionConfig {:kmsKeyName string}},
 :databaseVersion
 [DATABASE_VERSION_UNSPECIFIED POSTGRES_13 POSTGRES_14 POSTGRES_15],
 :initialUser {:user string, :password string},
 :deleteTime string,
 :encryptionInfo
 {:encryptionType
  [TYPE_UNSPECIFIED
   GOOGLE_DEFAULT_ENCRYPTION
   CUSTOMER_MANAGED_ENCRYPTION],
  :kmsKeyVersions [string]},
 :displayName string,
 :uid string,
 :name string,
 :primaryConfig {:secondaryClusterNames [string]},
 :continuousBackupInfo
 {:encryptionInfo
  {:encryptionType
   [TYPE_UNSPECIFIED
    GOOGLE_DEFAULT_ENCRYPTION
    CUSTOMER_MANAGED_ENCRYPTION],
   :kmsKeyVersions [string]},
  :enabledTime string,
  :schedule
  [[DAY_OF_WEEK_UNSPECIFIED
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY]],
  :earliestRestorableTime string},
 :createTime string,
 :pscConfig {:pscEnabled boolean},
 :etag string,
 :maintenanceSchedule {:startTime string},
 :state
 [STATE_UNSPECIFIED
  READY
  STOPPED
  EMPTY
  CREATING
  DELETING
  FAILED
  BOOTSTRAPPING
  MAINTENANCE
  PROMOTING],
 :networkConfig {:network string, :allocatedIpRange string},
 :updateTime string,
 :reconciling boolean,
 :maintenanceUpdatePolicy
 {:maintenanceWindows
  [{:day
    [DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY],
    :startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer}}]},
 :automatedBackupPolicy
 {:weeklySchedule
  {:startTimes
   [{:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer}],
   :daysOfWeek
   [[DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY]]},
  :timeBasedRetention {:retentionPeriod string},
  :quantityBasedRetention {:count integer},
  :enabled boolean,
  :backupWindow string,
  :encryptionConfig {:kmsKeyName string},
  :location string,
  :labels object},
 :satisfiesPzs boolean,
 :migrationSource
 {:hostPort string,
  :referenceId string,
  :sourceType [MIGRATION_SOURCE_TYPE_UNSPECIFIED DMS]},
 :annotations object,
 :network string,
 :sslConfig
 {:sslMode
  [SSL_MODE_UNSPECIFIED
   SSL_MODE_ALLOW
   SSL_MODE_REQUIRE
   SSL_MODE_VERIFY_CA
   ALLOW_UNENCRYPTED_AND_ENCRYPTED
   ENCRYPTED_ONLY],
  :caSource [CA_SOURCE_UNSPECIFIED CA_SOURCE_MANAGED]},
 :secondaryConfig {:primaryClusterName string},
 :backupSource {:backupUid string, :backupName string},
 :clusterType [CLUSTER_TYPE_UNSPECIFIED PRIMARY SECONDARY],
 :encryptionConfig {:kmsKeyName string}}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the Cluster resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the update request.
allowMissing <boolean> Optional. If set to true, update succeeds even if cluster is not found. In that case, a new cluster is created and `update_mask` is ignored."
  ([name Cluster] (projects-locations-clusters-patch name Cluster nil))
  ([name Cluster optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-locations-clusters-delete
  "Deletes a single Cluster.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/delete

name <string> Required. The name of the resource. For the required format, see the comment on the Cluster.name field.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
etag <string> Optional. The current etag of the Cluster. If an etag is provided and does not match the current etag of the Cluster, deletion will be blocked and an ABORTED error will be returned.
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the delete.
force <boolean> Optional. Whether to cascade delete child instances for given cluster."
  ([name] (projects-locations-clusters-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-promote
  "Promotes a SECONDARY cluster. This turns down replication from the PRIMARY cluster and promotes a secondary cluster into its own standalone cluster. Imperative only.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/promote

name <string> Required. The name of the resource. For the required format, see the comment on the Cluster.name field
PromoteClusterRequest:
{:requestId string, :etag string, :validateOnly boolean}"
  [name PromoteClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}:promote",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PromoteClusterRequest}))

(defn projects-locations-clusters-restore
  "Creates a new Cluster in a given project and location, with a volume restored from the provided source, either a backup ID or a point-in-time and a source cluster.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/restore

parent <string> Required. The name of the parent resource. For the required format, see the comment on the Cluster.name field.
RestoreClusterRequest:
{:backupSource {:backupUid string, :backupName string},
 :continuousBackupSource {:cluster string, :pointInTime string},
 :clusterId string,
 :cluster
 {:labels object,
  :continuousBackupConfig
  {:enabled boolean,
   :recoveryWindowDays integer,
   :encryptionConfig {:kmsKeyName string}},
  :databaseVersion
  [DATABASE_VERSION_UNSPECIFIED POSTGRES_13 POSTGRES_14 POSTGRES_15],
  :initialUser {:user string, :password string},
  :deleteTime string,
  :encryptionInfo
  {:encryptionType
   [TYPE_UNSPECIFIED
    GOOGLE_DEFAULT_ENCRYPTION
    CUSTOMER_MANAGED_ENCRYPTION],
   :kmsKeyVersions [string]},
  :displayName string,
  :uid string,
  :name string,
  :primaryConfig {:secondaryClusterNames [string]},
  :continuousBackupInfo
  {:encryptionInfo
   {:encryptionType
    [TYPE_UNSPECIFIED
     GOOGLE_DEFAULT_ENCRYPTION
     CUSTOMER_MANAGED_ENCRYPTION],
    :kmsKeyVersions [string]},
   :enabledTime string,
   :schedule
   [[DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY]],
   :earliestRestorableTime string},
  :createTime string,
  :pscConfig {:pscEnabled boolean},
  :etag string,
  :maintenanceSchedule {:startTime string},
  :state
  [STATE_UNSPECIFIED
   READY
   STOPPED
   EMPTY
   CREATING
   DELETING
   FAILED
   BOOTSTRAPPING
   MAINTENANCE
   PROMOTING],
  :networkConfig {:network string, :allocatedIpRange string},
  :updateTime string,
  :reconciling boolean,
  :maintenanceUpdatePolicy
  {:maintenanceWindows
   [{:day
     [DAY_OF_WEEK_UNSPECIFIED
      MONDAY
      TUESDAY
      WEDNESDAY
      THURSDAY
      FRIDAY
      SATURDAY
      SUNDAY],
     :startTime
     {:hours integer,
      :minutes integer,
      :seconds integer,
      :nanos integer}}]},
  :automatedBackupPolicy
  {:weeklySchedule
   {:startTimes
    [{:hours integer,
      :minutes integer,
      :seconds integer,
      :nanos integer}],
    :daysOfWeek
    [[DAY_OF_WEEK_UNSPECIFIED
      MONDAY
      TUESDAY
      WEDNESDAY
      THURSDAY
      FRIDAY
      SATURDAY
      SUNDAY]]},
   :timeBasedRetention {:retentionPeriod string},
   :quantityBasedRetention {:count integer},
   :enabled boolean,
   :backupWindow string,
   :encryptionConfig {:kmsKeyName string},
   :location string,
   :labels object},
  :satisfiesPzs boolean,
  :migrationSource
  {:hostPort string,
   :referenceId string,
   :sourceType [MIGRATION_SOURCE_TYPE_UNSPECIFIED DMS]},
  :annotations object,
  :network string,
  :sslConfig
  {:sslMode
   [SSL_MODE_UNSPECIFIED
    SSL_MODE_ALLOW
    SSL_MODE_REQUIRE
    SSL_MODE_VERIFY_CA
    ALLOW_UNENCRYPTED_AND_ENCRYPTED
    ENCRYPTED_ONLY],
   :caSource [CA_SOURCE_UNSPECIFIED CA_SOURCE_MANAGED]},
  :secondaryConfig {:primaryClusterName string},
  :backupSource {:backupUid string, :backupName string},
  :clusterType [CLUSTER_TYPE_UNSPECIFIED PRIMARY SECONDARY],
  :encryptionConfig {:kmsKeyName string}},
 :requestId string,
 :validateOnly boolean}"
  [parent RestoreClusterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://alloydb.googleapis.com/v1/{+parent}/clusters:restore",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestoreClusterRequest}))

(defn projects-locations-clusters-createsecondary
  "Creates a cluster of type SECONDARY in the given location using the primary cluster as the source.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters/createsecondary

parent <string> Required. The location of the new cluster. For the required format, see the comment on the Cluster.name field.
Cluster:
{:labels object,
 :continuousBackupConfig
 {:enabled boolean,
  :recoveryWindowDays integer,
  :encryptionConfig {:kmsKeyName string}},
 :databaseVersion
 [DATABASE_VERSION_UNSPECIFIED POSTGRES_13 POSTGRES_14 POSTGRES_15],
 :initialUser {:user string, :password string},
 :deleteTime string,
 :encryptionInfo
 {:encryptionType
  [TYPE_UNSPECIFIED
   GOOGLE_DEFAULT_ENCRYPTION
   CUSTOMER_MANAGED_ENCRYPTION],
  :kmsKeyVersions [string]},
 :displayName string,
 :uid string,
 :name string,
 :primaryConfig {:secondaryClusterNames [string]},
 :continuousBackupInfo
 {:encryptionInfo
  {:encryptionType
   [TYPE_UNSPECIFIED
    GOOGLE_DEFAULT_ENCRYPTION
    CUSTOMER_MANAGED_ENCRYPTION],
   :kmsKeyVersions [string]},
  :enabledTime string,
  :schedule
  [[DAY_OF_WEEK_UNSPECIFIED
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY]],
  :earliestRestorableTime string},
 :createTime string,
 :pscConfig {:pscEnabled boolean},
 :etag string,
 :maintenanceSchedule {:startTime string},
 :state
 [STATE_UNSPECIFIED
  READY
  STOPPED
  EMPTY
  CREATING
  DELETING
  FAILED
  BOOTSTRAPPING
  MAINTENANCE
  PROMOTING],
 :networkConfig {:network string, :allocatedIpRange string},
 :updateTime string,
 :reconciling boolean,
 :maintenanceUpdatePolicy
 {:maintenanceWindows
  [{:day
    [DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY],
    :startTime
    {:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer}}]},
 :automatedBackupPolicy
 {:weeklySchedule
  {:startTimes
   [{:hours integer,
     :minutes integer,
     :seconds integer,
     :nanos integer}],
   :daysOfWeek
   [[DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY]]},
  :timeBasedRetention {:retentionPeriod string},
  :quantityBasedRetention {:count integer},
  :enabled boolean,
  :backupWindow string,
  :encryptionConfig {:kmsKeyName string},
  :location string,
  :labels object},
 :satisfiesPzs boolean,
 :migrationSource
 {:hostPort string,
  :referenceId string,
  :sourceType [MIGRATION_SOURCE_TYPE_UNSPECIFIED DMS]},
 :annotations object,
 :network string,
 :sslConfig
 {:sslMode
  [SSL_MODE_UNSPECIFIED
   SSL_MODE_ALLOW
   SSL_MODE_REQUIRE
   SSL_MODE_VERIFY_CA
   ALLOW_UNENCRYPTED_AND_ENCRYPTED
   ENCRYPTED_ONLY],
  :caSource [CA_SOURCE_UNSPECIFIED CA_SOURCE_MANAGED]},
 :secondaryConfig {:primaryClusterName string},
 :backupSource {:backupUid string, :backupName string},
 :clusterType [CLUSTER_TYPE_UNSPECIFIED PRIMARY SECONDARY],
 :encryptionConfig {:kmsKeyName string}}

optional:
clusterId <string> Required. ID of the requesting object (the secondary cluster).
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the create request."
  ([parent Cluster]
    (projects-locations-clusters-createsecondary parent Cluster nil))
  ([parent Cluster optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/clusters:createsecondary",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-locations-clusters-instances-failover
  "Forces a Failover for a highly available instance. Failover promotes the HA standby instance as the new primary. Imperative only.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/failover

name <string> Required. The name of the resource. For the required format, see the comment on the Instance.name field.
FailoverInstanceRequest:
{:requestId string, :validateOnly boolean}"
  [name FailoverInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://alloydb.googleapis.com/v1/{+name}:failover",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body FailoverInstanceRequest}))

(defn projects-locations-clusters-instances-get
  "Gets details of a single Instance.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/get

name <string> Required. The name of the resource. For the required format, see the comment on the Instance.name field.

optional:
view <string> The view of the instance to return."
  ([name] (projects-locations-clusters-instances-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-instances-injectFault
  "Injects fault in an instance. Imperative only.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/injectFault

name <string> Required. The name of the resource. For the required format, see the comment on the Instance.name field.
InjectFaultRequest:
{:faultType [FAULT_TYPE_UNSPECIFIED STOP_VM],
 :requestId string,
 :validateOnly boolean}"
  [name InjectFaultRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://alloydb.googleapis.com/v1/{+name}:injectFault",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InjectFaultRequest}))

(defn projects-locations-clusters-instances-restart
  "Restart an Instance in a cluster. Imperative only.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/restart

name <string> Required. The name of the resource. For the required format, see the comment on the Instance.name field.
RestartInstanceRequest:
{:requestId string, :validateOnly boolean}"
  [name RestartInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}:restart",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestartInstanceRequest}))

(defn projects-locations-clusters-instances-patch
  "Updates the parameters of a single Instance.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/patch

name <string> Output only. The name of the instance resource with the format: * projects/{project}/locations/{region}/clusters/{cluster_id}/instances/{instance_id} where the cluster and instance ID segments should satisfy the regex expression `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`, e.g. 1-63 characters of lowercase letters, numbers, and dashes, starting with a letter, and ending with a letter or number. For more details see https://google.aip.dev/122. The prefix of the instance resource name is the name of the parent resource: * projects/{project}/locations/{region}/clusters/{cluster_id}
Instance:
{:availabilityType [AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
 :labels object,
 :pscInstanceConfig
 {:serviceAttachmentLink string,
  :allowedConsumerProjects [string],
  :pscDnsName string},
 :databaseFlags object,
 :deleteTime string,
 :clientConnectionConfig
 {:requireConnectors boolean,
  :sslConfig
  {:sslMode
   [SSL_MODE_UNSPECIFIED
    SSL_MODE_ALLOW
    SSL_MODE_REQUIRE
    SSL_MODE_VERIFY_CA
    ALLOW_UNENCRYPTED_AND_ENCRYPTED
    ENCRYPTED_ONLY],
   :caSource [CA_SOURCE_UNSPECIFIED CA_SOURCE_MANAGED]}},
 :instanceType [INSTANCE_TYPE_UNSPECIFIED PRIMARY READ_POOL SECONDARY],
 :displayName string,
 :uid string,
 :gceZone string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  READY
  STOPPED
  CREATING
  DELETING
  MAINTENANCE
  FAILED
  BOOTSTRAPPING
  PROMOTING],
 :machineConfig {:cpuCount integer},
 :networkConfig
 {:authorizedExternalNetworks [{:cidrRange string}],
  :enablePublicIp boolean},
 :updateTime string,
 :reconciling boolean,
 :readPoolConfig {:nodeCount integer},
 :publicIpAddress string,
 :nodes [{:zoneId string, :id string, :ip string, :state string}],
 :satisfiesPzs boolean,
 :annotations object,
 :ipAddress string,
 :queryInsightsConfig
 {:recordApplicationTags boolean,
  :recordClientAddress boolean,
  :queryStringLength integer,
  :queryPlansPerMinute integer},
 :writableNode {:zoneId string, :id string, :ip string, :state string}}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the Instance resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the update request.
allowMissing <boolean> Optional. If set to true, update succeeds even if instance is not found. In that case, a new instance is created and `update_mask` is ignored."
  ([name Instance]
    (projects-locations-clusters-instances-patch name Instance nil))
  ([name Instance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-clusters-instances-create
  "Creates a new Instance in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/create

parent <string> Required. The name of the parent resource. For the required format, see the comment on the Instance.name field.
Instance:
{:availabilityType [AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
 :labels object,
 :pscInstanceConfig
 {:serviceAttachmentLink string,
  :allowedConsumerProjects [string],
  :pscDnsName string},
 :databaseFlags object,
 :deleteTime string,
 :clientConnectionConfig
 {:requireConnectors boolean,
  :sslConfig
  {:sslMode
   [SSL_MODE_UNSPECIFIED
    SSL_MODE_ALLOW
    SSL_MODE_REQUIRE
    SSL_MODE_VERIFY_CA
    ALLOW_UNENCRYPTED_AND_ENCRYPTED
    ENCRYPTED_ONLY],
   :caSource [CA_SOURCE_UNSPECIFIED CA_SOURCE_MANAGED]}},
 :instanceType [INSTANCE_TYPE_UNSPECIFIED PRIMARY READ_POOL SECONDARY],
 :displayName string,
 :uid string,
 :gceZone string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  READY
  STOPPED
  CREATING
  DELETING
  MAINTENANCE
  FAILED
  BOOTSTRAPPING
  PROMOTING],
 :machineConfig {:cpuCount integer},
 :networkConfig
 {:authorizedExternalNetworks [{:cidrRange string}],
  :enablePublicIp boolean},
 :updateTime string,
 :reconciling boolean,
 :readPoolConfig {:nodeCount integer},
 :publicIpAddress string,
 :nodes [{:zoneId string, :id string, :ip string, :state string}],
 :satisfiesPzs boolean,
 :annotations object,
 :ipAddress string,
 :queryInsightsConfig
 {:recordApplicationTags boolean,
  :recordClientAddress boolean,
  :queryStringLength integer,
  :queryPlansPerMinute integer},
 :writableNode {:zoneId string, :id string, :ip string, :state string}}

optional:
instanceId <string> Required. ID of the requesting object.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the create request."
  ([parent Instance]
    (projects-locations-clusters-instances-create parent Instance nil))
  ([parent Instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-clusters-instances-delete
  "Deletes a single Instance.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/delete

name <string> Required. The name of the resource. For the required format, see the comment on the Instance.name field.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
etag <string> Optional. The current etag of the Instance. If an etag is provided and does not match the current etag of the Instance, deletion will be blocked and an ABORTED error will be returned.
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the delete."
  ([name] (projects-locations-clusters-instances-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-instances-createsecondary
  "Creates a new SECONDARY Instance in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/createsecondary

parent <string> Required. The name of the parent resource. For the required format, see the comment on the Instance.name field.
Instance:
{:availabilityType [AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
 :labels object,
 :pscInstanceConfig
 {:serviceAttachmentLink string,
  :allowedConsumerProjects [string],
  :pscDnsName string},
 :databaseFlags object,
 :deleteTime string,
 :clientConnectionConfig
 {:requireConnectors boolean,
  :sslConfig
  {:sslMode
   [SSL_MODE_UNSPECIFIED
    SSL_MODE_ALLOW
    SSL_MODE_REQUIRE
    SSL_MODE_VERIFY_CA
    ALLOW_UNENCRYPTED_AND_ENCRYPTED
    ENCRYPTED_ONLY],
   :caSource [CA_SOURCE_UNSPECIFIED CA_SOURCE_MANAGED]}},
 :instanceType [INSTANCE_TYPE_UNSPECIFIED PRIMARY READ_POOL SECONDARY],
 :displayName string,
 :uid string,
 :gceZone string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  READY
  STOPPED
  CREATING
  DELETING
  MAINTENANCE
  FAILED
  BOOTSTRAPPING
  PROMOTING],
 :machineConfig {:cpuCount integer},
 :networkConfig
 {:authorizedExternalNetworks [{:cidrRange string}],
  :enablePublicIp boolean},
 :updateTime string,
 :reconciling boolean,
 :readPoolConfig {:nodeCount integer},
 :publicIpAddress string,
 :nodes [{:zoneId string, :id string, :ip string, :state string}],
 :satisfiesPzs boolean,
 :annotations object,
 :ipAddress string,
 :queryInsightsConfig
 {:recordApplicationTags boolean,
  :recordClientAddress boolean,
  :queryStringLength integer,
  :queryPlansPerMinute integer},
 :writableNode {:zoneId string, :id string, :ip string, :state string}}

optional:
instanceId <string> Required. ID of the requesting object.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, performs request validation (e.g. permission checks and any other type of validation), but do not actually execute the create request."
  ([parent Instance]
    (projects-locations-clusters-instances-createsecondary
      parent
      Instance
      nil))
  ([parent Instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/instances:createsecondary",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-clusters-instances-list
  "Lists Instances in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/list

parent <string> Required. The name of the parent resource. For the required format, see the comment on the Instance.name field. Additionally, you can perform an aggregated list operation by specifying a value with one of the following formats: * projects/{project}/locations/-/clusters/- * projects/{project}/locations/{region}/clusters/-

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results
orderBy <string> Optional. Hint for how to order the results"
  ([parent] (projects-locations-clusters-instances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-instances-getConnectionInfo
  "Get instance metadata used for a connection.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.instances/getConnectionInfo

parent <string> Required. The name of the parent resource. The required format is: projects/{project}/locations/{location}/clusters/{cluster}/instances/{instance}

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent]
    (projects-locations-clusters-instances-getConnectionInfo
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/connectionInfo",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-users-list
  "Lists Users in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.users/list

parent <string> Required. Parent value for ListUsersRequest

optional:
pageSize <integer> Optional. Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Optional. Filtering results
orderBy <string> Optional. Hint for how to order the results"
  ([parent] (projects-locations-clusters-users-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/users",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-users-get
  "Gets details of a single User.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.users/get

name <string> Required. The name of the resource. For the required format, see the comment on the User.name field."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-clusters-users-create
  "Creates a new User in a given project, location, and cluster.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.users/create

parent <string> Required. Value for parent.
User:
{:name string,
 :password string,
 :databaseRoles [string],
 :userType [USER_TYPE_UNSPECIFIED ALLOYDB_BUILT_IN ALLOYDB_IAM_USER]}

optional:
userId <string> Required. ID of the requesting object.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, the backend validates the request, but doesn't actually execute it."
  ([parent User]
    (projects-locations-clusters-users-create parent User nil))
  ([parent User optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/users",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body User})))

(defn projects-locations-clusters-users-patch
  "Updates the parameters of a single User.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.users/patch

name <string> Output only. Name of the resource in the form of projects/{project}/locations/{location}/cluster/{cluster}/users/{user}.
User:
{:name string,
 :password string,
 :databaseRoles [string],
 :userType [USER_TYPE_UNSPECIFIED ALLOYDB_BUILT_IN ALLOYDB_IAM_USER]}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the User resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, the backend validates the request, but doesn't actually execute it.
allowMissing <boolean> Optional. Allow missing fields in the update mask."
  ([name User] (projects-locations-clusters-users-patch name User nil))
  ([name User optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body User})))

(defn projects-locations-clusters-users-delete
  "Deletes a single User.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.clusters.users/delete

name <string> Required. The name of the resource. For the required format, see the comment on the User.name field.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, the backend validates the request, but doesn't actually execute it."
  ([name] (projects-locations-clusters-users-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backups-list
  "Lists Backups in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.backups/list

parent <string> Required. Parent value for ListBackupsRequest

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results
orderBy <string> Hint for how to order the results"
  ([parent] (projects-locations-backups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backups-get
  "Gets details of a single Backup.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.backups/get

name <string> Required. Name of the resource"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://alloydb.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-backups-create
  "Creates a new Backup in a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.backups/create

parent <string> Required. Value for parent.
Backup:
{:description string,
 :labels object,
 :databaseVersion
 [DATABASE_VERSION_UNSPECIFIED POSTGRES_13 POSTGRES_14 POSTGRES_15],
 :clusterName string,
 :deleteTime string,
 :encryptionInfo
 {:encryptionType
  [TYPE_UNSPECIFIED
   GOOGLE_DEFAULT_ENCRYPTION
   CUSTOMER_MANAGED_ENCRYPTION],
  :kmsKeyVersions [string]},
 :displayName string,
 :uid string,
 :name string,
 :sizeBytes string,
 :createTime string,
 :type [TYPE_UNSPECIFIED ON_DEMAND AUTOMATED CONTINUOUS],
 :etag string,
 :state [STATE_UNSPECIFIED READY CREATING FAILED DELETING],
 :updateTime string,
 :reconciling boolean,
 :satisfiesPzs boolean,
 :expiryQuantity
 {:retentionCount integer, :totalRetentionCount integer},
 :annotations object,
 :expiryTime string,
 :clusterUid string,
 :encryptionConfig {:kmsKeyName string}}

optional:
backupId <string> Required. ID of the requesting object.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, the backend validates the request, but doesn't actually execute it."
  ([parent Backup]
    (projects-locations-backups-create parent Backup nil))
  ([parent Backup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-backups-patch
  "Updates the parameters of a single Backup.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.backups/patch

name <string> Output only. The name of the backup resource with the format: * projects/{project}/locations/{region}/backups/{backup_id} where the cluster and backup ID segments should satisfy the regex expression `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`, e.g. 1-63 characters of lowercase letters, numbers, and dashes, starting with a letter, and ending with a letter or number. For more details see https://google.aip.dev/122. The prefix of the backup resource name is the name of the parent resource: * projects/{project}/locations/{region}
Backup:
{:description string,
 :labels object,
 :databaseVersion
 [DATABASE_VERSION_UNSPECIFIED POSTGRES_13 POSTGRES_14 POSTGRES_15],
 :clusterName string,
 :deleteTime string,
 :encryptionInfo
 {:encryptionType
  [TYPE_UNSPECIFIED
   GOOGLE_DEFAULT_ENCRYPTION
   CUSTOMER_MANAGED_ENCRYPTION],
  :kmsKeyVersions [string]},
 :displayName string,
 :uid string,
 :name string,
 :sizeBytes string,
 :createTime string,
 :type [TYPE_UNSPECIFIED ON_DEMAND AUTOMATED CONTINUOUS],
 :etag string,
 :state [STATE_UNSPECIFIED READY CREATING FAILED DELETING],
 :updateTime string,
 :reconciling boolean,
 :satisfiesPzs boolean,
 :expiryQuantity
 {:retentionCount integer, :totalRetentionCount integer},
 :annotations object,
 :expiryTime string,
 :clusterUid string,
 :encryptionConfig {:kmsKeyName string}}

optional:
updateMask <string> Optional. Field mask is used to specify the fields to be overwritten in the Backup resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, the backend validates the request, but doesn't actually execute it.
allowMissing <boolean> Optional. If set to true, update succeeds even if instance is not found. In that case, a new backup is created and `update_mask` is ignored."
  ([name Backup] (projects-locations-backups-patch name Backup nil))
  ([name Backup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-backups-delete
  "Deletes a single Backup.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.backups/delete

name <string> Required. Name of the resource. For the required format, see the comment on the Backup.name field.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set, the backend validates the request, but doesn't actually execute it.
etag <string> Optional. The current etag of the Backup. If an etag is provided and does not match the current etag of the Backup, deletion will be blocked and an ABORTED error will be returned."
  ([name] (projects-locations-backups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://alloydb.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-supportedDatabaseFlags-list
  "Lists SupportedDatabaseFlags for a given project and location.
https://cloud.google.com/alloydb/docs/reference/rest/v1/projects.locations.supportedDatabaseFlags/list

parent <string> Required. The name of the parent resource. The required format is: * projects/{project}/locations/{location} Regardless of the parent specified here, as long it is contains a valid project and location, the service will return a static list of supported flags resources. Note that we do not yet support region-specific flags.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default."
  ([parent]
    (projects-locations-supportedDatabaseFlags-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://alloydb.googleapis.com/v1/{+parent}/supportedDatabaseFlags",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

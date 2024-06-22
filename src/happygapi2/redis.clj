(ns happygapi2.redis
  "Google Cloud Memorystore for Redis API
Creates and manages Redis instances on the Google Cloud Platform.
See: https://cloud.google.com/memorystore/docs/redis/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://redis.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://redis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://redis.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://redis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://redis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template "https://redis.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-clusters-list
  "Lists all Redis clusters owned by a project in either the specified location (region) or all locations. The location should have the following format: * `projects/{project_id}/locations/{location_id}` If `location_id` is specified as `-` (wildcard), then all regions available to the project are queried, and the results are aggregated.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.clusters/list

parent <string> Required. The resource name of the cluster location using the form: `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.

optional:
pageSize <integer> The maximum number of items to return. If not specified, a default value of 1000 will be used by the service. Regardless of the page_size value, the response may include a partial list and a caller should only rely on response's `next_page_token` to determine if there are more clusters left to be queried."
  ([parent] (projects-locations-clusters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://redis.googleapis.com/v1/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-get
  "Gets the details of a specific Redis cluster.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.clusters/get

name <string> Required. Redis cluster resource name using the form: `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id` refers to a GCP region."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://redis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-clusters-patch
  "Updates the metadata and configuration of a specific Redis cluster. Completed longrunning.Operation will contain the new cluster object in the response field. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.clusters/patch

name <string> Required. Unique name of the resource in this scope including project and location using the form: `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}`
Cluster:
{:nodeType
 [NODE_TYPE_UNSPECIFIED
  REDIS_SHARED_CORE_NANO
  REDIS_HIGHMEM_MEDIUM
  REDIS_HIGHMEM_XLARGE
  REDIS_STANDARD_SMALL],
 :uid string,
 :name string,
 :stateInfo
 {:updateInfo
  {:targetShardCount integer, :targetReplicaCount integer}},
 :sizeGb integer,
 :zoneDistributionConfig
 {:mode [ZONE_DISTRIBUTION_MODE_UNSPECIFIED MULTI_ZONE SINGLE_ZONE],
  :zone string},
 :createTime string,
 :discoveryEndpoints
 [{:address string, :port integer, :pscConfig {:network string}}],
 :authorizationMode
 [AUTH_MODE_UNSPECIFIED AUTH_MODE_IAM_AUTH AUTH_MODE_DISABLED],
 :state [STATE_UNSPECIFIED CREATING ACTIVE UPDATING DELETING],
 :deletionProtectionEnabled boolean,
 :shardCount integer,
 :redisConfigs object,
 :pscConfigs [{:network string}],
 :persistenceConfig
 {:mode [PERSISTENCE_MODE_UNSPECIFIED DISABLED RDB AOF],
  :rdbConfig
  {:rdbSnapshotPeriod
   [SNAPSHOT_PERIOD_UNSPECIFIED
    ONE_HOUR
    SIX_HOURS
    TWELVE_HOURS
    TWENTY_FOUR_HOURS],
   :rdbSnapshotStartTime string},
  :aofConfig
  {:appendFsync [APPEND_FSYNC_UNSPECIFIED NO EVERYSEC ALWAYS]}},
 :pscConnections
 [{:pscConnectionId string,
   :address string,
   :forwardingRule string,
   :projectId string,
   :network string}],
 :preciseSizeGb number,
 :replicaCount integer,
 :transitEncryptionMode
 [TRANSIT_ENCRYPTION_MODE_UNSPECIFIED
  TRANSIT_ENCRYPTION_MODE_DISABLED
  TRANSIT_ENCRYPTION_MODE_SERVER_AUTHENTICATION]}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field. The elements of the repeated paths field may only include these fields from Cluster: * `size_gb` * `replica_count`
requestId <string> Idempotent request UUID."
  ([name Cluster] (projects-locations-clusters-patch name Cluster nil))
  ([name Cluster optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://redis.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-locations-clusters-delete
  "Deletes a specific Redis cluster. Cluster stops serving and data is deleted.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.clusters/delete

name <string> Required. Redis cluster resource name using the form: `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}` where `location_id` refers to a GCP region.

optional:
requestId <string> Idempotent request UUID."
  ([name] (projects-locations-clusters-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://redis.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-clusters-create
  "Creates a Redis cluster based on the specified properties. The creation is executed asynchronously and callers may check the returned operation to track its progress. Once the operation is completed the Redis cluster will be fully functional. The completed longrunning.Operation will contain the new cluster object in the response field. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.clusters/create

parent <string> Required. The resource name of the cluster location using the form: `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
Cluster:
{:nodeType
 [NODE_TYPE_UNSPECIFIED
  REDIS_SHARED_CORE_NANO
  REDIS_HIGHMEM_MEDIUM
  REDIS_HIGHMEM_XLARGE
  REDIS_STANDARD_SMALL],
 :uid string,
 :name string,
 :stateInfo
 {:updateInfo
  {:targetShardCount integer, :targetReplicaCount integer}},
 :sizeGb integer,
 :zoneDistributionConfig
 {:mode [ZONE_DISTRIBUTION_MODE_UNSPECIFIED MULTI_ZONE SINGLE_ZONE],
  :zone string},
 :createTime string,
 :discoveryEndpoints
 [{:address string, :port integer, :pscConfig {:network string}}],
 :authorizationMode
 [AUTH_MODE_UNSPECIFIED AUTH_MODE_IAM_AUTH AUTH_MODE_DISABLED],
 :state [STATE_UNSPECIFIED CREATING ACTIVE UPDATING DELETING],
 :deletionProtectionEnabled boolean,
 :shardCount integer,
 :redisConfigs object,
 :pscConfigs [{:network string}],
 :persistenceConfig
 {:mode [PERSISTENCE_MODE_UNSPECIFIED DISABLED RDB AOF],
  :rdbConfig
  {:rdbSnapshotPeriod
   [SNAPSHOT_PERIOD_UNSPECIFIED
    ONE_HOUR
    SIX_HOURS
    TWELVE_HOURS
    TWENTY_FOUR_HOURS],
   :rdbSnapshotStartTime string},
  :aofConfig
  {:appendFsync [APPEND_FSYNC_UNSPECIFIED NO EVERYSEC ALWAYS]}},
 :pscConnections
 [{:pscConnectionId string,
   :address string,
   :forwardingRule string,
   :projectId string,
   :network string}],
 :preciseSizeGb number,
 :replicaCount integer,
 :transitEncryptionMode
 [TRANSIT_ENCRYPTION_MODE_UNSPECIFIED
  TRANSIT_ENCRYPTION_MODE_DISABLED
  TRANSIT_ENCRYPTION_MODE_SERVER_AUTHENTICATION]}

optional:
clusterId <string> Required. The logical name of the Redis cluster in the customer project with the following restrictions: * Must contain only lowercase letters, numbers, and hyphens. * Must start with a letter. * Must be between 1-63 characters. * Must end with a number or a letter. * Must be unique within the customer project / location
requestId <string> Idempotent request UUID."
  ([parent Cluster]
    (projects-locations-clusters-create parent Cluster nil))
  ([parent Cluster optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://redis.googleapis.com/v1/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-locations-clusters-getCertificateAuthority
  "Gets the details of certificate authority information for Redis cluster.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.clusters/getCertificateAuthority

name <string> Required. Redis cluster certificate authority resource name using the form: `projects/{project_id}/locations/{location_id}/clusters/{cluster_id}/certificateAuthority` where `location_id` refers to a GCP region."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://redis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-failover
  "Initiates a failover of the primary node to current replica node for a specific STANDARD tier Cloud Memorystore for Redis instance.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/failover

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region.
FailoverInstanceRequest:
{:dataProtectionMode
 [DATA_PROTECTION_MODE_UNSPECIFIED LIMITED_DATA_LOSS FORCE_DATA_LOSS]}"
  [name FailoverInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://redis.googleapis.com/v1/{+name}:failover",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body FailoverInstanceRequest}))

(defn projects-locations-instances-get
  "Gets the details of a specific Redis instance.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/get

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://redis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-patch
  "Updates the metadata and configuration of a specific Redis instance. Completed longrunning.Operation will contain the new instance object in the response field. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/patch

name <string> Required. Unique name of the resource in this scope including project and location using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` Note: Redis instances are managed and addressed at regional level so location_id here refers to a GCP region; however, users may choose which specific zone (or collection of zones for cross-zone instances) an instance should be provisioned in. Refer to location_id and alternative_location_id fields for more details.
Instance:
{:labels object,
 :tier [TIER_UNSPECIFIED BASIC STANDARD_HA],
 :connectMode
 [CONNECT_MODE_UNSPECIFIED DIRECT_PEERING PRIVATE_SERVICE_ACCESS],
 :memorySizeGb integer,
 :authEnabled boolean,
 :satisfiesPzi boolean,
 :redisVersion string,
 :displayName string,
 :locationId string,
 :customerManagedKey string,
 :name string,
 :reservedIpRange string,
 :statusMessage string,
 :createTime string,
 :secondaryIpRange string,
 :maintenanceSchedule
 {:startTime string,
  :endTime string,
  :canReschedule boolean,
  :scheduleDeadlineTime string},
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  UPDATING
  DELETING
  REPAIRING
  MAINTENANCE
  IMPORTING
  FAILING_OVER],
 :port integer,
 :suspensionReasons
 [[SUSPENSION_REASON_UNSPECIFIED CUSTOMER_MANAGED_KEY_ISSUE]],
 :redisConfigs object,
 :availableMaintenanceVersions [string],
 :maintenancePolicy
 {:createTime string,
  :updateTime string,
  :description string,
  :weeklyMaintenanceWindow
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
     :nanos integer},
    :duration string}]},
 :readReplicasMode
 [READ_REPLICAS_MODE_UNSPECIFIED
  READ_REPLICAS_DISABLED
  READ_REPLICAS_ENABLED],
 :persistenceIamIdentity string,
 :host string,
 :nodes [{:id string, :zone string}],
 :satisfiesPzs boolean,
 :readEndpointPort integer,
 :persistenceConfig
 {:persistenceMode [PERSISTENCE_MODE_UNSPECIFIED DISABLED RDB],
  :rdbSnapshotPeriod
  [SNAPSHOT_PERIOD_UNSPECIFIED
   ONE_HOUR
   SIX_HOURS
   TWELVE_HOURS
   TWENTY_FOUR_HOURS],
  :rdbNextSnapshotTime string,
  :rdbSnapshotStartTime string},
 :maintenanceVersion string,
 :serverCaCerts
 [{:serialNumber string,
   :cert string,
   :createTime string,
   :expireTime string,
   :sha1Fingerprint string}],
 :currentLocationId string,
 :readEndpoint string,
 :alternativeLocationId string,
 :replicaCount integer,
 :transitEncryptionMode
 [TRANSIT_ENCRYPTION_MODE_UNSPECIFIED SERVER_AUTHENTICATION DISABLED],
 :authorizedNetwork string}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field. The elements of the repeated paths field may only include these fields from Instance: * `displayName` * `labels` * `memorySizeGb` * `redisConfig` * `replica_count`"
  ([name Instance]
    (projects-locations-instances-patch name Instance nil))
  ([name Instance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://redis.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-getAuthString
  "Gets the AUTH string for a Redis instance. If AUTH is not enabled for the instance the response will be empty. This information is not included in the details returned to GetInstance.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/getAuthString

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://redis.googleapis.com/v1/{+name}/authString",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-rescheduleMaintenance
  "Reschedule maintenance for a given instance in a given project and location.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/rescheduleMaintenance

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region.
RescheduleMaintenanceRequest:
{:rescheduleType
 [RESCHEDULE_TYPE_UNSPECIFIED
  IMMEDIATE
  NEXT_AVAILABLE_WINDOW
  SPECIFIC_TIME],
 :scheduleTime string}"
  [name RescheduleMaintenanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://redis.googleapis.com/v1/{+name}:rescheduleMaintenance",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RescheduleMaintenanceRequest}))

(defn projects-locations-instances-create
  "Creates a Redis instance based on the specified tier and memory size. By default, the instance is accessible from the project's [default network](https://cloud.google.com/vpc/docs/vpc). The creation is executed asynchronously and callers may check the returned operation to track its progress. Once the operation is completed the Redis instance will be fully functional. Completed longrunning.Operation will contain the new instance object in the response field. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/create

parent <string> Required. The resource name of the instance location using the form: `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.
Instance:
{:labels object,
 :tier [TIER_UNSPECIFIED BASIC STANDARD_HA],
 :connectMode
 [CONNECT_MODE_UNSPECIFIED DIRECT_PEERING PRIVATE_SERVICE_ACCESS],
 :memorySizeGb integer,
 :authEnabled boolean,
 :satisfiesPzi boolean,
 :redisVersion string,
 :displayName string,
 :locationId string,
 :customerManagedKey string,
 :name string,
 :reservedIpRange string,
 :statusMessage string,
 :createTime string,
 :secondaryIpRange string,
 :maintenanceSchedule
 {:startTime string,
  :endTime string,
  :canReschedule boolean,
  :scheduleDeadlineTime string},
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  UPDATING
  DELETING
  REPAIRING
  MAINTENANCE
  IMPORTING
  FAILING_OVER],
 :port integer,
 :suspensionReasons
 [[SUSPENSION_REASON_UNSPECIFIED CUSTOMER_MANAGED_KEY_ISSUE]],
 :redisConfigs object,
 :availableMaintenanceVersions [string],
 :maintenancePolicy
 {:createTime string,
  :updateTime string,
  :description string,
  :weeklyMaintenanceWindow
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
     :nanos integer},
    :duration string}]},
 :readReplicasMode
 [READ_REPLICAS_MODE_UNSPECIFIED
  READ_REPLICAS_DISABLED
  READ_REPLICAS_ENABLED],
 :persistenceIamIdentity string,
 :host string,
 :nodes [{:id string, :zone string}],
 :satisfiesPzs boolean,
 :readEndpointPort integer,
 :persistenceConfig
 {:persistenceMode [PERSISTENCE_MODE_UNSPECIFIED DISABLED RDB],
  :rdbSnapshotPeriod
  [SNAPSHOT_PERIOD_UNSPECIFIED
   ONE_HOUR
   SIX_HOURS
   TWELVE_HOURS
   TWENTY_FOUR_HOURS],
  :rdbNextSnapshotTime string,
  :rdbSnapshotStartTime string},
 :maintenanceVersion string,
 :serverCaCerts
 [{:serialNumber string,
   :cert string,
   :createTime string,
   :expireTime string,
   :sha1Fingerprint string}],
 :currentLocationId string,
 :readEndpoint string,
 :alternativeLocationId string,
 :replicaCount integer,
 :transitEncryptionMode
 [TRANSIT_ENCRYPTION_MODE_UNSPECIFIED SERVER_AUTHENTICATION DISABLED],
 :authorizedNetwork string}

optional:
instanceId <string> Required. The logical name of the Redis instance in the customer project with the following restrictions: * Must contain only lowercase letters, numbers, and hyphens. * Must start with a letter. * Must be between 1-40 characters. * Must end with a number or a letter. * Must be unique within the customer project / location"
  ([parent Instance]
    (projects-locations-instances-create parent Instance nil))
  ([parent Instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://redis.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-delete
  "Deletes a specific Redis instance. Instance stops serving and data is deleted.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/delete

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://redis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-export
  "Export Redis instance data into a Redis RDB format file in Cloud Storage. Redis will continue serving during this operation. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/export

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region.
ExportInstanceRequest:
{:outputConfig {:gcsDestination {:uri string}}}"
  [name ExportInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://redis.googleapis.com/v1/{+name}:export",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportInstanceRequest}))

(defn projects-locations-instances-upgrade
  "Upgrades Redis instance to the newer Redis version specified in the request.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/upgrade

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region.
UpgradeInstanceRequest:
{:redisVersion string}"
  [name UpgradeInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://redis.googleapis.com/v1/{+name}:upgrade",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UpgradeInstanceRequest}))

(defn projects-locations-instances-list
  "Lists all Redis instances owned by a project in either the specified location (region) or all locations. The location should have the following format: * `projects/{project_id}/locations/{location_id}` If `location_id` is specified as `-` (wildcard), then all regions available to the project are queried, and the results are aggregated.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/list

parent <string> Required. The resource name of the instance location using the form: `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region.

optional:
pageSize <integer> The maximum number of items to return. If not specified, a default value of 1000 will be used by the service. Regardless of the page_size value, the response may include a partial list and a caller should only rely on response's `next_page_token` to determine if there are more instances left to be queried."
  ([parent] (projects-locations-instances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://redis.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-import
  "Import a Redis RDB snapshot file from Cloud Storage into a Redis instance. Redis may stop serving during this operation. Instance state will be IMPORTING for entire operation. When complete, the instance will contain only data from the imported file. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation.
https://cloud.google.com/memorystore/docs/redis/reference/rest/v1/projects.locations.instances/import

name <string> Required. Redis instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region.
ImportInstanceRequest:
{:inputConfig {:gcsSource {:uri string}}}"
  [name ImportInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://redis.googleapis.com/v1/{+name}:import",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ImportInstanceRequest}))

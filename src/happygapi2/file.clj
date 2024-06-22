(ns happygapi2.file
  "Cloud Filestore API
The Cloud Filestore API is used for creating and managing cloud file servers.
See: https://cloud.google.com/filestore/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations/list

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
       "https://file.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://file.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://file.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-instances-list
  "Lists all instances in a project for either a specified location or for all locations.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/list

parent <string> Required. The project and location for which to retrieve instance information, in the format `projects/{project_id}/locations/{location}`. In Cloud Filestore, locations map to Google Cloud zones, for example **us-west1-b**. To retrieve instance information for all locations, use \"-\" for the `{location}` value.

optional:
pageSize <integer> The maximum number of items to return.
orderBy <string> Sort results. Supported values are \"name\", \"name desc\" or \"\" (unsorted).
filter <string> List filter."
  ([parent] (projects-locations-instances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://file.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-get
  "Gets the details of a specific instance.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/get

name <string> Required. The instance resource name, in the format `projects/{project_id}/locations/{location}/instances/{instance_id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-create
  "Creates an instance. When creating from a backup, the capacity of the new instance needs to be equal to or larger than the capacity of the backup (and also equal to or larger than the minimum capacity of the tier).
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/create

parent <string> Required. The instance's project and location, in the format `projects/{project_id}/locations/{location}`. In Filestore, locations map to Google Cloud zones, for example **us-west1-b**.
Instance:
{:description string,
 :tags object,
 :labels object,
 :tier
 [TIER_UNSPECIFIED
  STANDARD
  PREMIUM
  BASIC_HDD
  BASIC_SSD
  HIGH_SCALE_SSD
  ENTERPRISE
  ZONAL
  REGIONAL],
 :fileShares
 [{:name string,
   :capacityGb string,
   :sourceBackup string,
   :nfsExportOptions
   [{:ipRanges [string],
     :accessMode [ACCESS_MODE_UNSPECIFIED READ_ONLY READ_WRITE],
     :squashMode [SQUASH_MODE_UNSPECIFIED NO_ROOT_SQUASH ROOT_SQUASH],
     :anonUid string,
     :anonGid string}]}],
 :satisfiesPzi boolean,
 :name string,
 :statusMessage string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  REPAIRING
  DELETING
  ERROR
  RESTORING
  SUSPENDED
  SUSPENDING
  RESUMING
  REVERTING
  PROMOTING],
 :suspensionReasons [[SUSPENSION_REASON_UNSPECIFIED KMS_KEY_ISSUE]],
 :networks
 [{:network string,
   :modes [[ADDRESS_MODE_UNSPECIFIED MODE_IPV4]],
   :reservedIpRange string,
   :ipAddresses [string],
   :connectMode
   [CONNECT_MODE_UNSPECIFIED DIRECT_PEERING PRIVATE_SERVICE_ACCESS]}],
 :satisfiesPzs boolean,
 :replication
 {:role [ROLE_UNSPECIFIED ACTIVE STANDBY],
  :replicas
  [{:state [STATE_UNSPECIFIED CREATING READY REMOVING FAILED],
    :stateReasons
    [[STATE_REASON_UNSPECIFIED PEER_INSTANCE_UNREACHABLE]],
    :peerInstance string,
    :lastActiveSyncTime string}]},
 :kmsKeyName string}

optional:
instanceId <string> Required. The name of the instance to create. The name must be unique for the specified project and location."
  ([parent Instance]
    (projects-locations-instances-create parent Instance nil))
  ([parent Instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://file.googleapis.com/v1/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-patch
  "Updates the settings of a specific instance.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/patch

name <string> Output only. The resource name of the instance, in the format `projects/{project}/locations/{location}/instances/{instance}`.
Instance:
{:description string,
 :tags object,
 :labels object,
 :tier
 [TIER_UNSPECIFIED
  STANDARD
  PREMIUM
  BASIC_HDD
  BASIC_SSD
  HIGH_SCALE_SSD
  ENTERPRISE
  ZONAL
  REGIONAL],
 :fileShares
 [{:name string,
   :capacityGb string,
   :sourceBackup string,
   :nfsExportOptions
   [{:ipRanges [string],
     :accessMode [ACCESS_MODE_UNSPECIFIED READ_ONLY READ_WRITE],
     :squashMode [SQUASH_MODE_UNSPECIFIED NO_ROOT_SQUASH ROOT_SQUASH],
     :anonUid string,
     :anonGid string}]}],
 :satisfiesPzi boolean,
 :name string,
 :statusMessage string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  REPAIRING
  DELETING
  ERROR
  RESTORING
  SUSPENDED
  SUSPENDING
  RESUMING
  REVERTING
  PROMOTING],
 :suspensionReasons [[SUSPENSION_REASON_UNSPECIFIED KMS_KEY_ISSUE]],
 :networks
 [{:network string,
   :modes [[ADDRESS_MODE_UNSPECIFIED MODE_IPV4]],
   :reservedIpRange string,
   :ipAddresses [string],
   :connectMode
   [CONNECT_MODE_UNSPECIFIED DIRECT_PEERING PRIVATE_SERVICE_ACCESS]}],
 :satisfiesPzs boolean,
 :replication
 {:role [ROLE_UNSPECIFIED ACTIVE STANDBY],
  :replicas
  [{:state [STATE_UNSPECIFIED CREATING READY REMOVING FAILED],
    :stateReasons
    [[STATE_REASON_UNSPECIFIED PEER_INSTANCE_UNREACHABLE]],
    :peerInstance string,
    :lastActiveSyncTime string}]},
 :kmsKeyName string}

optional:
updateMask <string> Mask of fields to update. At least one path must be supplied in this field. The elements of the repeated paths field may only include these fields: * \"description\" * \"file_shares\" * \"labels\""
  ([name Instance]
    (projects-locations-instances-patch name Instance nil))
  ([name Instance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://file.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-restore
  "Restores an existing instance's file share from a backup. The capacity of the instance needs to be equal to or larger than the capacity of the backup (and also equal to or larger than the minimum capacity of the tier).
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/restore

name <string> Required. The resource name of the instance, in the format `projects/{project_number}/locations/{location_id}/instances/{instance_id}`.
RestoreInstanceRequest:
{:fileShare string, :sourceBackup string}"
  [name RestoreInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://file.googleapis.com/v1/{+name}:restore",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestoreInstanceRequest}))

(defn projects-locations-instances-revert
  "Revert an existing instance's file system to a specified snapshot.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/revert

name <string> Required. The resource name of the instance, in the format `projects/{project_id}/locations/{location_id}/instances/{instance_id}`.
RevertInstanceRequest:
{:targetSnapshotId string}"
  [name RevertInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://file.googleapis.com/v1/{+name}:revert",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RevertInstanceRequest}))

(defn projects-locations-instances-delete
  "Deletes an instance.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/delete

name <string> Required. The instance resource name, in the format `projects/{project_id}/locations/{location}/instances/{instance_id}`

optional:
force <boolean> If set to true, all snapshots of the instance will also be deleted. (Otherwise, the request will only work if the instance has no snapshots.)"
  ([name] (projects-locations-instances-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://file.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-promoteReplica
  "Promote an standby instance (replica).
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances/promoteReplica

name <string> Required. The resource name of the instance, in the format `projects/{project_id}/locations/{location_id}/instances/{instance_id}`.
PromoteReplicaRequest:
object"
  [name PromoteReplicaRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://file.googleapis.com/v1/{+name}:promoteReplica",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PromoteReplicaRequest}))

(defn projects-locations-instances-snapshots-list
  "Lists all snapshots in a project for either a specified location or for all locations.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances.snapshots/list

parent <string> Required. The instance for which to retrieve snapshot information, in the format `projects/{project_id}/locations/{location}/instances/{instance_id}`.

optional:
pageSize <integer> The maximum number of items to return.
orderBy <string> Sort results. Supported values are \"name\", \"name desc\" or \"\" (unsorted).
filter <string> List filter."
  ([parent] (projects-locations-instances-snapshots-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://file.googleapis.com/v1/{+parent}/snapshots",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-snapshots-get
  "Gets the details of a specific snapshot.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances.snapshots/get

name <string> Required. The snapshot resource name, in the format `projects/{project_id}/locations/{location}/instances/{instance_id}/snapshots/{snapshot_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-snapshots-create
  "Creates a snapshot.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances.snapshots/create

parent <string> Required. The Filestore Instance to create the snapshots of, in the format `projects/{project_id}/locations/{location}/instances/{instance_id}`
Snapshot:
{:name string,
 :description string,
 :state [STATE_UNSPECIFIED CREATING READY DELETING],
 :createTime string,
 :labels object,
 :filesystemUsedBytes string,
 :tags object}

optional:
snapshotId <string> Required. The ID to use for the snapshot. The ID must be unique within the specified instance. This value must start with a lowercase letter followed by up to 62 lowercase letters, numbers, or hyphens, and cannot end with a hyphen."
  ([parent Snapshot]
    (projects-locations-instances-snapshots-create
      parent
      Snapshot
      nil))
  ([parent Snapshot optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://file.googleapis.com/v1/{+parent}/snapshots",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Snapshot})))

(defn projects-locations-instances-snapshots-delete
  "Deletes a snapshot.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances.snapshots/delete

name <string> Required. The snapshot resource name, in the format `projects/{project_id}/locations/{location}/instances/{instance_id}/snapshots/{snapshot_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-snapshots-patch
  "Updates the settings of a specific snapshot.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.instances.snapshots/patch

name <string> Output only. The resource name of the snapshot, in the format `projects/{project_id}/locations/{location_id}/instances/{instance_id}/snapshots/{snapshot_id}`.
Snapshot:
{:name string,
 :description string,
 :state [STATE_UNSPECIFIED CREATING READY DELETING],
 :createTime string,
 :labels object,
 :filesystemUsedBytes string,
 :tags object}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field."
  ([name Snapshot]
    (projects-locations-instances-snapshots-patch name Snapshot nil))
  ([name Snapshot optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://file.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Snapshot})))

(defn projects-locations-backups-list
  "Lists all backups in a project for either a specified location or for all locations.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.backups/list

parent <string> Required. The project and location for which to retrieve backup information, in the format `projects/{project_number}/locations/{location}`. In Filestore, backup locations map to Google Cloud regions, for example **us-west1**. To retrieve backup information for all locations, use \"-\" for the `{location}` value.

optional:
pageSize <integer> The maximum number of items to return.
orderBy <string> Sort results. Supported values are \"name\", \"name desc\" or \"\" (unsorted).
filter <string> List filter."
  ([parent] (projects-locations-backups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://file.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backups-get
  "Gets the details of a specific backup.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.backups/get

name <string> Required. The backup resource name, in the format `projects/{project_number}/locations/{location}/backups/{backup_id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-backups-create
  "Creates a backup.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.backups/create

parent <string> Required. The backup's project and location, in the format `projects/{project_number}/locations/{location}`. In Filestore, backup locations map to Google Cloud regions, for example **us-west1**.
Backup:
{:description string,
 :tags object,
 :labels object,
 :sourceInstance string,
 :downloadBytes string,
 :satisfiesPzi boolean,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING FINALIZING READY DELETING INVALID],
 :satisfiesPzs boolean,
 :sourceInstanceTier
 [TIER_UNSPECIFIED
  STANDARD
  PREMIUM
  BASIC_HDD
  BASIC_SSD
  HIGH_SCALE_SSD
  ENTERPRISE
  ZONAL
  REGIONAL],
 :sourceFileShare string,
 :kmsKey string,
 :storageBytes string,
 :capacityGb string}

optional:
backupId <string> Required. The ID to use for the backup. The ID must be unique within the specified project and location. This value must start with a lowercase letter followed by up to 62 lowercase letters, numbers, or hyphens, and cannot end with a hyphen. Values that do not match this pattern will trigger an INVALID_ARGUMENT error."
  ([parent Backup]
    (projects-locations-backups-create parent Backup nil))
  ([parent Backup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://file.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-backups-delete
  "Deletes a backup.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.backups/delete

name <string> Required. The backup resource name, in the format `projects/{project_number}/locations/{location}/backups/{backup_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://file.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-backups-patch
  "Updates the settings of a specific backup.
https://cloud.google.com/filestore/docs/reference/rest/v1/projects.locations.backups/patch

name <string> Output only. The resource name of the backup, in the format `projects/{project_number}/locations/{location_id}/backups/{backup_id}`.
Backup:
{:description string,
 :tags object,
 :labels object,
 :sourceInstance string,
 :downloadBytes string,
 :satisfiesPzi boolean,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING FINALIZING READY DELETING INVALID],
 :satisfiesPzs boolean,
 :sourceInstanceTier
 [TIER_UNSPECIFIED
  STANDARD
  PREMIUM
  BASIC_HDD
  BASIC_SSD
  HIGH_SCALE_SSD
  ENTERPRISE
  ZONAL
  REGIONAL],
 :sourceFileShare string,
 :kmsKey string,
 :storageBytes string,
 :capacityGb string}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field."
  ([name Backup] (projects-locations-backups-patch name Backup nil))
  ([name Backup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://file.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

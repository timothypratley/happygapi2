(ns happygapi2.baremetalsolution
  "Bare Metal Solution API
Provides ways to manage Bare Metal Solution hardware installed in a regional extension located near a Google Cloud data center.
See: https://cloud.google.com/bare-metal"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sshKeys-list
  "Lists the public SSH keys registered for the specified project. These SSH keys are used only for the interactive serial console feature.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.sshKeys/list

parent <string> Required. The parent containing the SSH keys. Currently, the only valid value for the location is \"global\".

optional:
pageSize <integer> The maximum number of items to return."
  ([parent] (projects-locations-sshKeys-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/sshKeys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sshKeys-create
  "Register a public SSH key in the specified project for use with the interactive serial console feature.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.sshKeys/create

parent <string> Required. The parent containing the SSH keys.
SSHKey:
{:name string, :publicKey string}

optional:
sshKeyId <string> Required. The ID to use for the key, which will become the final component of the key's resource name. This value must match the regex: [a-zA-Z0-9@.\\-_]{1,64}"
  ([parent SSHKey]
    (projects-locations-sshKeys-create parent SSHKey nil))
  ([parent SSHKey optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/sshKeys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SSHKey})))

(defn projects-locations-sshKeys-delete
  "Deletes a public SSH key registered in the specified project.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.sshKeys/delete

name <string> Required. The name of the SSH key to delete. Currently, the only valid value for the location is \"global\"."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-volumes-list
  "List storage volumes in a given project and location.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes/list

parent <string> Required. Parent value for ListVolumesRequest.

optional:
pageSize <integer> Requested page size. The server might return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> List filter."
  ([parent] (projects-locations-volumes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/volumes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-volumes-get
  "Get details of a single storage volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-volumes-patch
  "Update details of a single storage volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes/patch

name <string> Output only. The resource name of this `Volume`. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. Format: `projects/{project}/locations/{location}/volumes/{volume}`
Volume:
{:labels object,
 :autoGrownSizeGib string,
 :maxSizeGib string,
 :protocol [PROTOCOL_UNSPECIFIED FIBRE_CHANNEL NFS],
 :name string,
 :currentSizeGib string,
 :storageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
 :remainingSpaceGib string,
 :workloadProfile [WORKLOAD_PROFILE_UNSPECIFIED GENERIC HANA],
 :state [STATE_UNSPECIFIED CREATING READY DELETING UPDATING COOL_OFF],
 :bootVolume boolean,
 :performanceTier
 [VOLUME_PERFORMANCE_TIER_UNSPECIFIED
  VOLUME_PERFORMANCE_TIER_SHARED
  VOLUME_PERFORMANCE_TIER_ASSIGNED
  VOLUME_PERFORMANCE_TIER_HT
  VOLUME_PERFORMANCE_TIER_QOS2_PERFORMANCE],
 :pod string,
 :snapshotReservationDetail
 {:reservedSpaceGib string,
  :reservedSpaceUsedPercent integer,
  :reservedSpaceRemainingGib string,
  :reservedSpacePercent integer},
 :instances [string],
 :snapshotAutoDeleteBehavior
 [SNAPSHOT_AUTO_DELETE_BEHAVIOR_UNSPECIFIED
  DISABLED
  OLDEST_FIRST
  NEWEST_FIRST],
 :id string,
 :notes string,
 :originallyRequestedSizeGib string,
 :emergencySizeGib string,
 :requestedSizeGib string,
 :expireTime string,
 :snapshotEnabled boolean,
 :attached boolean}

optional:
updateMask <string> The list of fields to update. The only currently supported fields are: 'labels'"
  ([name Volume] (projects-locations-volumes-patch name Volume nil))
  ([name Volume optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Volume})))

(defn projects-locations-volumes-rename
  "RenameVolume sets a new name for a volume. Use with caution, previous names become immediately invalidated.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes/rename

name <string> Required. The `name` field is used to identify the volume. Format: projects/{project}/locations/{location}/volumes/{volume}
RenameVolumeRequest:
{:newVolumeId string}"
  [name RenameVolumeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RenameVolumeRequest}))

(defn projects-locations-volumes-evict
  "Skips volume's cooloff and deletes it now. Volume must be in cooloff state.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes/evict

name <string> Required. The name of the Volume.
EvictVolumeRequest:
object"
  [name EvictVolumeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:evict",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EvictVolumeRequest}))

(defn projects-locations-volumes-resize
  "Emergency Volume resize.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes/resize

volume <string> Required. Volume to resize.
ResizeVolumeRequest:
{:sizeGib string}"
  [volume ResizeVolumeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+volume}:resize",
     :uri-template-args {:volume volume},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResizeVolumeRequest}))

(defn projects-locations-volumes-snapshots-create
  "Takes a snapshot of a boot volume. Returns INVALID_ARGUMENT if called for a non-boot volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.snapshots/create

parent <string> Required. The volume to snapshot.
VolumeSnapshot:
{:name string,
 :id string,
 :description string,
 :createTime string,
 :storageVolume string,
 :type [SNAPSHOT_TYPE_UNSPECIFIED AD_HOC SCHEDULED]}"
  [parent VolumeSnapshot]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+parent}/snapshots",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body VolumeSnapshot}))

(defn projects-locations-volumes-snapshots-restoreVolumeSnapshot
  "Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called for a non-boot volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.snapshots/restoreVolumeSnapshot

volumeSnapshot <string> Required. Name of the snapshot which will be used to restore its parent volume.
RestoreVolumeSnapshotRequest:
object"
  [volumeSnapshot RestoreVolumeSnapshotRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+volumeSnapshot}:restoreVolumeSnapshot",
     :uri-template-args {:volumeSnapshot volumeSnapshot},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestoreVolumeSnapshotRequest}))

(defn projects-locations-volumes-snapshots-delete
  "Deletes a volume snapshot. Returns INVALID_ARGUMENT if called for a non-boot volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.snapshots/delete

name <string> Required. The name of the snapshot to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-volumes-snapshots-get
  "Returns the specified snapshot resource. Returns INVALID_ARGUMENT if called for a non-boot volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.snapshots/get

name <string> Required. The name of the snapshot."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-volumes-snapshots-list
  "Retrieves the list of snapshots for the specified volume. Returns a response with an empty list of snapshots if called for a non-boot volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.snapshots/list

parent <string> Required. Parent value for ListVolumesRequest.

optional:
pageSize <integer> Requested page size. The server might return fewer items than requested. If unspecified, server will pick an appropriate default."
  ([parent] (projects-locations-volumes-snapshots-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/snapshots",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-volumes-luns-get
  "Get details of a single storage logical unit number(LUN).
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.luns/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-volumes-luns-list
  "List storage volume luns for given storage volume.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.luns/list

parent <string> Required. Parent value for ListLunsRequest.

optional:
pageSize <integer> Requested page size. The server might return fewer items than requested. If unspecified, server will pick an appropriate default."
  ([parent] (projects-locations-volumes-luns-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/luns",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-volumes-luns-evict
  "Skips lun's cooloff and deletes it now. Lun must be in cooloff state.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.volumes.luns/evict

name <string> Required. The name of the lun.
EvictLunRequest:
object"
  [name EvictLunRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:evict",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EvictLunRequest}))

(defn projects-locations-networks-list
  "List network in a given project and location.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.networks/list

parent <string> Required. Parent value for ListNetworksRequest.

optional:
pageSize <integer> Requested page size. The server might return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> List filter."
  ([parent] (projects-locations-networks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/networks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-networks-listNetworkUsage
  "List all Networks (and used IPs for each Network) in the vendor account associated with the specified project.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.networks/listNetworkUsage

location <string> Required. Parent value (project and location)."
  [location]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+location}/networks:listNetworkUsage",
     :uri-template-args {:location location},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-networks-get
  "Get details of a single network.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.networks/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-networks-patch
  "Update details of a single network.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.networks/patch

name <string> Output only. The resource name of this `Network`. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. Format: `projects/{project}/locations/{location}/networks/{network}`
Network:
{:vlanId string,
 :labels object,
 :cidr string,
 :gatewayIp string,
 :mountPoints
 [{:instance string,
   :logicalInterface string,
   :defaultGateway boolean,
   :ipAddress string}],
 :vrfAttachment string,
 :name string,
 :macAddress [string],
 :servicesCidr string,
 :type [TYPE_UNSPECIFIED CLIENT PRIVATE],
 :state
 [STATE_UNSPECIFIED PROVISIONING PROVISIONED DEPROVISIONING UPDATING],
 :vrf
 {:name string,
  :state [STATE_UNSPECIFIED PROVISIONING PROVISIONED],
  :qosPolicy {:bandwidthGbps number},
  :vlanAttachments
  [{:peerVlanId string,
    :peerIp string,
    :routerIp string,
    :pairingKey string,
    :qosPolicy {:bandwidthGbps number},
    :id string,
    :interconnectAttachment string}]},
 :pod string,
 :id string,
 :ipAddress string,
 :reservations
 [{:startAddress string, :endAddress string, :note string}],
 :jumboFramesEnabled boolean}

optional:
updateMask <string> The list of fields to update. The only currently supported fields are: `labels`, `reservations`, `vrf.vlan_attachments`"
  ([name Network] (projects-locations-networks-patch name Network nil))
  ([name Network optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Network})))

(defn projects-locations-networks-rename
  "RenameNetwork sets a new name for a network. Use with caution, previous names become immediately invalidated.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.networks/rename

name <string> Required. The `name` field is used to identify the network. Format: projects/{project}/locations/{location}/networks/{network}
RenameNetworkRequest:
{:newNetworkId string}"
  [name RenameNetworkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RenameNetworkRequest}))

(defn projects-locations-instances-get
  "Get details about a single server.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-patch
  "Update details of a single server.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/patch

name <string> Immutable. The resource name of this `Instance`. Resource names are schemeless URIs that follow the conventions in https://cloud.google.com/apis/design/resource_names. Format: `projects/{project}/locations/{location}/instances/{instance}`
Instance:
{:labels object,
 :kmsKeyVersion string,
 :name string,
 :interactiveSerialConsoleEnabled boolean,
 :luns
 [{:wwid string,
   :storageVolume string,
   :bootLun boolean,
   :name string,
   :sizeGb string,
   :storageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
   :state
   [STATE_UNSPECIFIED CREATING UPDATING READY DELETING COOL_OFF],
   :shareable boolean,
   :instances [string],
   :id string,
   :expireTime string,
   :multiprotocolType [MULTIPROTOCOL_TYPE_UNSPECIFIED LINUX]}],
 :logicalInterfaces
 [{:logicalNetworkInterfaces
   [{:network string,
     :ipAddress string,
     :defaultGateway boolean,
     :networkType [TYPE_UNSPECIFIED CLIENT PRIVATE],
     :id string}],
   :name string,
   :interfaceIndex integer}],
 :sshKeys [string],
 :createTime string,
 :workloadProfile
 [WORKLOAD_PROFILE_UNSPECIFIED
  WORKLOAD_PROFILE_GENERIC
  WORKLOAD_PROFILE_HANA],
 :state
 [STATE_UNSPECIFIED
  PROVISIONING
  RUNNING
  DELETED
  UPDATING
  STARTING
  STOPPING
  SHUTDOWN],
 :networkTemplate string,
 :machineType string,
 :updateTime string,
 :volumes
 [{:labels object,
   :autoGrownSizeGib string,
   :maxSizeGib string,
   :protocol [PROTOCOL_UNSPECIFIED FIBRE_CHANNEL NFS],
   :name string,
   :currentSizeGib string,
   :storageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
   :remainingSpaceGib string,
   :workloadProfile [WORKLOAD_PROFILE_UNSPECIFIED GENERIC HANA],
   :state
   [STATE_UNSPECIFIED CREATING READY DELETING UPDATING COOL_OFF],
   :bootVolume boolean,
   :performanceTier
   [VOLUME_PERFORMANCE_TIER_UNSPECIFIED
    VOLUME_PERFORMANCE_TIER_SHARED
    VOLUME_PERFORMANCE_TIER_ASSIGNED
    VOLUME_PERFORMANCE_TIER_HT
    VOLUME_PERFORMANCE_TIER_QOS2_PERFORMANCE],
   :pod string,
   :snapshotReservationDetail
   {:reservedSpaceGib string,
    :reservedSpaceUsedPercent integer,
    :reservedSpaceRemainingGib string,
    :reservedSpacePercent integer},
   :instances [string],
   :snapshotAutoDeleteBehavior
   [SNAPSHOT_AUTO_DELETE_BEHAVIOR_UNSPECIFIED
    DISABLED
    OLDEST_FIRST
    NEWEST_FIRST],
   :id string,
   :notes string,
   :originallyRequestedSizeGib string,
   :emergencySizeGib string,
   :requestedSizeGib string,
   :expireTime string,
   :snapshotEnabled boolean,
   :attached boolean}],
 :networks
 [{:vlanId string,
   :labels object,
   :cidr string,
   :gatewayIp string,
   :mountPoints
   [{:instance string,
     :logicalInterface string,
     :defaultGateway boolean,
     :ipAddress string}],
   :vrfAttachment string,
   :name string,
   :macAddress [string],
   :servicesCidr string,
   :type [TYPE_UNSPECIFIED CLIENT PRIVATE],
   :state
   [STATE_UNSPECIFIED
    PROVISIONING
    PROVISIONED
    DEPROVISIONING
    UPDATING],
   :vrf
   {:name string,
    :state [STATE_UNSPECIFIED PROVISIONING PROVISIONED],
    :qosPolicy {:bandwidthGbps number},
    :vlanAttachments
    [{:peerVlanId string,
      :peerIp string,
      :routerIp string,
      :pairingKey string,
      :qosPolicy {:bandwidthGbps number},
      :id string,
      :interconnectAttachment string}]},
   :pod string,
   :id string,
   :ipAddress string,
   :reservations
   [{:startAddress string, :endAddress string, :note string}],
   :jumboFramesEnabled boolean}],
 :pod string,
 :hyperthreadingEnabled boolean,
 :id string,
 :loginInfo string,
 :osImage string,
 :firmwareVersion string}

optional:
updateMask <string> The list of fields to update. The currently supported fields are: `labels` `hyperthreading_enabled` `os_image` `ssh_keys` `kms_key_version`"
  ([name Instance]
    (projects-locations-instances-patch name Instance nil))
  ([name Instance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-locations-instances-reset
  "Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then turning it back on.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/reset

name <string> Required. Name of the resource.
ResetInstanceRequest:
object"
  [name ResetInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:reset",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetInstanceRequest}))

(defn projects-locations-instances-loadAuthInfo
  "Load auth info for a server.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/loadAuthInfo

name <string> Required. Name of the server."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:loadAuthInfo",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-start
  "Starts a server that was shutdown.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/start

name <string> Required. Name of the resource.
StartInstanceRequest:
object"
  [name StartInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:start",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartInstanceRequest}))

(defn projects-locations-instances-enableInteractiveSerialConsole
  "Enable the interactive serial console feature on an instance.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/enableInteractiveSerialConsole

name <string> Required. Name of the resource.
EnableInteractiveSerialConsoleRequest:
object"
  [name EnableInteractiveSerialConsoleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:enableInteractiveSerialConsole",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EnableInteractiveSerialConsoleRequest}))

(defn projects-locations-instances-disableHyperthreading
  "Perform disable hyperthreading operation on a single server.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/disableHyperthreading

name <string> Required. The `name` field is used to identify the instance. Format: projects/{project}/locations/{location}/instances/{instance}
DisableHyperthreadingRequest:
object"
  [name DisableHyperthreadingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:disableHyperthreading",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DisableHyperthreadingRequest}))

(defn projects-locations-instances-detachLun
  "Detach LUN from Instance.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/detachLun

instance <string> Required. Name of the instance.
DetachLunRequest:
{:lun string, :skipReboot boolean}"
  [instance DetachLunRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+instance}:detachLun",
     :uri-template-args {:instance instance},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DetachLunRequest}))

(defn projects-locations-instances-rename
  "RenameInstance sets a new name for an instance. Use with caution, previous names become immediately invalidated.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/rename

name <string> Required. The `name` field is used to identify the instance. Format: projects/{project}/locations/{location}/instances/{instance}
RenameInstanceRequest:
{:newInstanceId string}"
  [name RenameInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RenameInstanceRequest}))

(defn projects-locations-instances-reimage
  "Perform reimage operation on a single server.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/reimage

name <string> Required. The `name` field is used to identify the instance. Format: projects/{project}/locations/{location}/instances/{instance}
ReimageInstanceRequest:
{:osImage string, :kmsKeyVersion string, :sshKeys [string]}"
  [name ReimageInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:reimage",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ReimageInstanceRequest}))

(defn projects-locations-instances-stop
  "Stop a running server.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/stop

name <string> Required. Name of the resource.
StopInstanceRequest:
object"
  [name StopInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:stop",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StopInstanceRequest}))

(defn projects-locations-instances-list
  "List servers in a given project and location.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/list

parent <string> Required. Parent value for ListInstancesRequest.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, the server will pick an appropriate default.
filter <string> List filter."
  ([parent] (projects-locations-instances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-disableInteractiveSerialConsole
  "Disable the interactive serial console feature on an instance.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/disableInteractiveSerialConsole

name <string> Required. Name of the resource.
DisableInteractiveSerialConsoleRequest:
object"
  [name DisableInteractiveSerialConsoleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:disableInteractiveSerialConsole",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DisableInteractiveSerialConsoleRequest}))

(defn projects-locations-instances-enableHyperthreading
  "Perform enable hyperthreading operation on a single server.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.instances/enableHyperthreading

name <string> Required. The `name` field is used to identify the instance. Format: projects/{project}/locations/{location}/instances/{instance}
EnableHyperthreadingRequest:
object"
  [name EnableHyperthreadingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:enableHyperthreading",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EnableHyperthreadingRequest}))

(defn projects-locations-operations-get
  "Get details about an operation.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-provisioningConfigs-submit
  "Submit a provisiong configuration for a given project.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.provisioningConfigs/submit

parent <string> Required. The parent project and location containing the ProvisioningConfig.
SubmitProvisioningConfigRequest:
{:provisioningConfig
 {:customId string,
  :email string,
  :cloudConsoleUri string,
  :name string,
  :statusMessage string,
  :state
  [STATE_UNSPECIFIED
   DRAFT
   SUBMITTED
   PROVISIONING
   PROVISIONED
   VALIDATED
   CANCELLED
   FAILED],
  :handoverServiceAccount string,
  :updateTime string,
  :volumes
  [{:protocol [PROTOCOL_UNSPECIFIED PROTOCOL_FC PROTOCOL_NFS],
    :snapshotsEnabled boolean,
    :name string,
    :sizeGb integer,
    :type [TYPE_UNSPECIFIED FLASH DISK],
    :performanceTier
    [VOLUME_PERFORMANCE_TIER_UNSPECIFIED
     VOLUME_PERFORMANCE_TIER_SHARED
     VOLUME_PERFORMANCE_TIER_ASSIGNED
     VOLUME_PERFORMANCE_TIER_HT
     VOLUME_PERFORMANCE_TIER_QOS2_PERFORMANCE],
    :nfsExports
    [{:networkId string,
      :machineId string,
      :cidr string,
      :permissions [PERMISSIONS_UNSPECIFIED READ_ONLY READ_WRITE],
      :noRootSquash boolean,
      :allowSuid boolean,
      :allowDev boolean}],
    :gcpService string,
    :machineIds [string],
    :userNote string,
    :id string,
    :lunRanges [{:quantity integer, :sizeGb integer}]}],
  :vpcScEnabled boolean,
  :networks
  [{:vlanAttachments [{:id string, :pairingKey string}],
    :cidr string,
    :name string,
    :type [TYPE_UNSPECIFIED CLIENT PRIVATE],
    :serviceCidr
    [SERVICE_CIDR_UNSPECIFIED DISABLED HIGH_26 HIGH_27 HIGH_28],
    :vlanSameProject boolean,
    :bandwidth
    [BANDWIDTH_UNSPECIFIED BW_1_GBPS BW_2_GBPS BW_5_GBPS BW_10_GBPS],
    :gcpService string,
    :userNote string,
    :id string,
    :jumboFramesEnabled boolean}],
  :pod string,
  :instances
  [{:sshKeyNames [string],
    :accountNetworksEnabled boolean,
    :kmsKeyVersion string,
    :instanceType string,
    :name string,
    :logicalInterfaces
    [{:logicalNetworkInterfaces
      [{:network string,
        :ipAddress string,
        :defaultGateway boolean,
        :networkType [TYPE_UNSPECIFIED CLIENT PRIVATE],
        :id string}],
      :name string,
      :interfaceIndex integer}],
    :networkTemplate string,
    :networkConfig [NETWORKCONFIG_UNSPECIFIED SINGLE_VLAN MULTI_VLAN],
    :privateNetwork
    {:networkId string, :address string, :existingNetworkId string},
    :userNote string,
    :id string,
    :hyperthreading boolean,
    :clientNetwork
    {:networkId string, :address string, :existingNetworkId string},
    :osImage string}],
  :ticketId string,
  :location string},
 :email string}"
  [parent SubmitProvisioningConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+parent}/provisioningConfigs:submit",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SubmitProvisioningConfigRequest}))

(defn projects-locations-provisioningConfigs-get
  "Get ProvisioningConfig by name.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.provisioningConfigs/get

name <string> Required. Name of the ProvisioningConfig."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-provisioningConfigs-create
  "Create new ProvisioningConfig.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.provisioningConfigs/create

parent <string> Required. The parent project and location containing the ProvisioningConfig.
ProvisioningConfig:
{:customId string,
 :email string,
 :cloudConsoleUri string,
 :name string,
 :statusMessage string,
 :state
 [STATE_UNSPECIFIED
  DRAFT
  SUBMITTED
  PROVISIONING
  PROVISIONED
  VALIDATED
  CANCELLED
  FAILED],
 :handoverServiceAccount string,
 :updateTime string,
 :volumes
 [{:protocol [PROTOCOL_UNSPECIFIED PROTOCOL_FC PROTOCOL_NFS],
   :snapshotsEnabled boolean,
   :name string,
   :sizeGb integer,
   :type [TYPE_UNSPECIFIED FLASH DISK],
   :performanceTier
   [VOLUME_PERFORMANCE_TIER_UNSPECIFIED
    VOLUME_PERFORMANCE_TIER_SHARED
    VOLUME_PERFORMANCE_TIER_ASSIGNED
    VOLUME_PERFORMANCE_TIER_HT
    VOLUME_PERFORMANCE_TIER_QOS2_PERFORMANCE],
   :nfsExports
   [{:networkId string,
     :machineId string,
     :cidr string,
     :permissions [PERMISSIONS_UNSPECIFIED READ_ONLY READ_WRITE],
     :noRootSquash boolean,
     :allowSuid boolean,
     :allowDev boolean}],
   :gcpService string,
   :machineIds [string],
   :userNote string,
   :id string,
   :lunRanges [{:quantity integer, :sizeGb integer}]}],
 :vpcScEnabled boolean,
 :networks
 [{:vlanAttachments [{:id string, :pairingKey string}],
   :cidr string,
   :name string,
   :type [TYPE_UNSPECIFIED CLIENT PRIVATE],
   :serviceCidr
   [SERVICE_CIDR_UNSPECIFIED DISABLED HIGH_26 HIGH_27 HIGH_28],
   :vlanSameProject boolean,
   :bandwidth
   [BANDWIDTH_UNSPECIFIED BW_1_GBPS BW_2_GBPS BW_5_GBPS BW_10_GBPS],
   :gcpService string,
   :userNote string,
   :id string,
   :jumboFramesEnabled boolean}],
 :pod string,
 :instances
 [{:sshKeyNames [string],
   :accountNetworksEnabled boolean,
   :kmsKeyVersion string,
   :instanceType string,
   :name string,
   :logicalInterfaces
   [{:logicalNetworkInterfaces
     [{:network string,
       :ipAddress string,
       :defaultGateway boolean,
       :networkType [TYPE_UNSPECIFIED CLIENT PRIVATE],
       :id string}],
     :name string,
     :interfaceIndex integer}],
   :networkTemplate string,
   :networkConfig [NETWORKCONFIG_UNSPECIFIED SINGLE_VLAN MULTI_VLAN],
   :privateNetwork
   {:networkId string, :address string, :existingNetworkId string},
   :userNote string,
   :id string,
   :hyperthreading boolean,
   :clientNetwork
   {:networkId string, :address string, :existingNetworkId string},
   :osImage string}],
 :ticketId string,
 :location string}

optional:
email <string> Optional. Email provided to send a confirmation with provisioning config to."
  ([parent ProvisioningConfig]
    (projects-locations-provisioningConfigs-create
      parent
      ProvisioningConfig
      nil))
  ([parent ProvisioningConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/provisioningConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ProvisioningConfig})))

(defn projects-locations-provisioningConfigs-patch
  "Update existing ProvisioningConfig.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.provisioningConfigs/patch

name <string> Output only. The system-generated name of the provisioning config. This follows the UUID format.
ProvisioningConfig:
{:customId string,
 :email string,
 :cloudConsoleUri string,
 :name string,
 :statusMessage string,
 :state
 [STATE_UNSPECIFIED
  DRAFT
  SUBMITTED
  PROVISIONING
  PROVISIONED
  VALIDATED
  CANCELLED
  FAILED],
 :handoverServiceAccount string,
 :updateTime string,
 :volumes
 [{:protocol [PROTOCOL_UNSPECIFIED PROTOCOL_FC PROTOCOL_NFS],
   :snapshotsEnabled boolean,
   :name string,
   :sizeGb integer,
   :type [TYPE_UNSPECIFIED FLASH DISK],
   :performanceTier
   [VOLUME_PERFORMANCE_TIER_UNSPECIFIED
    VOLUME_PERFORMANCE_TIER_SHARED
    VOLUME_PERFORMANCE_TIER_ASSIGNED
    VOLUME_PERFORMANCE_TIER_HT
    VOLUME_PERFORMANCE_TIER_QOS2_PERFORMANCE],
   :nfsExports
   [{:networkId string,
     :machineId string,
     :cidr string,
     :permissions [PERMISSIONS_UNSPECIFIED READ_ONLY READ_WRITE],
     :noRootSquash boolean,
     :allowSuid boolean,
     :allowDev boolean}],
   :gcpService string,
   :machineIds [string],
   :userNote string,
   :id string,
   :lunRanges [{:quantity integer, :sizeGb integer}]}],
 :vpcScEnabled boolean,
 :networks
 [{:vlanAttachments [{:id string, :pairingKey string}],
   :cidr string,
   :name string,
   :type [TYPE_UNSPECIFIED CLIENT PRIVATE],
   :serviceCidr
   [SERVICE_CIDR_UNSPECIFIED DISABLED HIGH_26 HIGH_27 HIGH_28],
   :vlanSameProject boolean,
   :bandwidth
   [BANDWIDTH_UNSPECIFIED BW_1_GBPS BW_2_GBPS BW_5_GBPS BW_10_GBPS],
   :gcpService string,
   :userNote string,
   :id string,
   :jumboFramesEnabled boolean}],
 :pod string,
 :instances
 [{:sshKeyNames [string],
   :accountNetworksEnabled boolean,
   :kmsKeyVersion string,
   :instanceType string,
   :name string,
   :logicalInterfaces
   [{:logicalNetworkInterfaces
     [{:network string,
       :ipAddress string,
       :defaultGateway boolean,
       :networkType [TYPE_UNSPECIFIED CLIENT PRIVATE],
       :id string}],
     :name string,
     :interfaceIndex integer}],
   :networkTemplate string,
   :networkConfig [NETWORKCONFIG_UNSPECIFIED SINGLE_VLAN MULTI_VLAN],
   :privateNetwork
   {:networkId string, :address string, :existingNetworkId string},
   :userNote string,
   :id string,
   :hyperthreading boolean,
   :clientNetwork
   {:networkId string, :address string, :existingNetworkId string},
   :osImage string}],
 :ticketId string,
 :location string}

optional:
updateMask <string> Required. The list of fields to update.
email <string> Optional. Email provided to send a confirmation with provisioning config to."
  ([name ProvisioningConfig]
    (projects-locations-provisioningConfigs-patch
      name
      ProvisioningConfig
      nil))
  ([name ProvisioningConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ProvisioningConfig})))

(defn projects-locations-osImages-list
  "Retrieves the list of OS images which are currently approved.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.osImages/list

parent <string> Required. Parent value for ListOSImagesRequest.

optional:
pageSize <integer> Requested page size. The server might return fewer items than requested. If unspecified, server will pick an appropriate default. Notice that page_size field is not supported and won't be respected in the API request for now, will be updated when pagination is supported."
  ([parent] (projects-locations-osImages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/osImages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-osImages-get
  "Get details of a single OS image.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.osImages/get

name <string> Required. Name of the OS image."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-provisioningQuotas-list
  "List the budget details to provision resources on a given project.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.provisioningQuotas/list

parent <string> Required. Parent value for ListProvisioningQuotasRequest.

optional:
pageSize <integer> Requested page size. The server might return fewer items than requested. If unspecified, server will pick an appropriate default. Notice that page_size field is not supported and won't be respected in the API request for now, will be updated when pagination is supported."
  ([parent] (projects-locations-provisioningQuotas-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/provisioningQuotas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nfsShares-get
  "Get details of a single NFS share.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.nfsShares/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-nfsShares-list
  "List NFS shares.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.nfsShares/list

parent <string> Required. Parent value for ListNfsSharesRequest.

optional:
pageSize <integer> Requested page size. The server might return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> List filter."
  ([parent] (projects-locations-nfsShares-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+parent}/nfsShares",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-nfsShares-patch
  "Update details of a single NFS share.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.nfsShares/patch

name <string> Immutable. The name of the NFS share.
NfsShare:
{:labels object,
 :name string,
 :storageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
 :state [STATE_UNSPECIFIED PROVISIONED CREATING UPDATING DELETING],
 :volume string,
 :nfsShareId string,
 :pod string,
 :id string,
 :requestedSizeGib string,
 :allowedClients
 [{:network string,
   :shareIp string,
   :allowedClientsCidr string,
   :mountPermissions [MOUNT_PERMISSIONS_UNSPECIFIED READ READ_WRITE],
   :allowDev boolean,
   :allowSuid boolean,
   :noRootSquash boolean,
   :nfsPath string}]}

optional:
updateMask <string> The list of fields to update. The only currently supported fields are: `labels` `allowed_clients`"
  ([name NfsShare]
    (projects-locations-nfsShares-patch name NfsShare nil))
  ([name NfsShare optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://baremetalsolution.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NfsShare})))

(defn projects-locations-nfsShares-create
  "Create an NFS share.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.nfsShares/create

parent <string> Required. The parent project and location.
NfsShare:
{:labels object,
 :name string,
 :storageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
 :state [STATE_UNSPECIFIED PROVISIONED CREATING UPDATING DELETING],
 :volume string,
 :nfsShareId string,
 :pod string,
 :id string,
 :requestedSizeGib string,
 :allowedClients
 [{:network string,
   :shareIp string,
   :allowedClientsCidr string,
   :mountPermissions [MOUNT_PERMISSIONS_UNSPECIFIED READ READ_WRITE],
   :allowDev boolean,
   :allowSuid boolean,
   :noRootSquash boolean,
   :nfsPath string}]}"
  [parent NfsShare]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+parent}/nfsShares",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body NfsShare}))

(defn projects-locations-nfsShares-rename
  "RenameNfsShare sets a new name for an nfsshare. Use with caution, previous names become immediately invalidated.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.nfsShares/rename

name <string> Required. The `name` field is used to identify the nfsshare. Format: projects/{project}/locations/{location}/nfsshares/{nfsshare}
RenameNfsShareRequest:
{:newNfsshareId string}"
  [name RenameNfsShareRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RenameNfsShareRequest}))

(defn projects-locations-nfsShares-delete
  "Delete an NFS share. The underlying volume is automatically deleted.
https://cloud.google.com/bare-metal/docs/reference/rest/v2/projects.locations.nfsShares/delete

name <string> Required. The name of the NFS share to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://baremetalsolution.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

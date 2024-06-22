(ns happygapi2.migrationcenter
  "Migration Center API
A unified platform that helps you accelerate your end-to-end cloud journey from your current on-premises or cloud environments to Google Cloud.
See: https://cloud.google.com/migration-center/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-getSettings
  "Gets the details of regional settings.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations/getSettings

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-updateSettings
  "Updates the regional-level project settings.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations/updateSettings

name <string> Output only. The name of the resource.
Settings:
{:name string, :preferenceSet string, :disableCloudLogging boolean}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Settings` resource by the update. The values specified in the `update_mask` field are relative to the resource, not the full request. A field will be overwritten if it is in the mask. A single * value in the mask lets you to overwrite all fields.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Settings]
    (projects-locations-updateSettings name Settings nil))
  ([name Settings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Settings})))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-assets-list
  "Lists all the assets in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/list

parent <string> Required. Parent value for `ListAssetsRequest`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details.
view <string> View of the assets. Defaults to BASIC."
  ([parent] (projects-locations-assets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/assets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-assets-get
  "Gets the details of an asset.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/get

name <string> Required. Name of the resource.

optional:
view <string> View of the assets. Defaults to BASIC."
  ([name] (projects-locations-assets-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-assets-patch
  "Updates the parameters of an asset.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/patch

name <string> Output only. The full name of the asset.
Asset:
{:labels object,
 :performanceData
 {:dailyResourceUsageAggregations
  [{:date {:year integer, :month integer, :day integer},
    :cpu
    {:utilizationPercentage
     {:average number,
      :median number,
      :ninteyFifthPercentile number,
      :peak number}},
    :memory
    {:utilizationPercentage
     {:average number,
      :median number,
      :ninteyFifthPercentile number,
      :peak number}},
    :network
    {:ingressBps
     {:average number,
      :median number,
      :ninteyFifthPercentile number,
      :peak number},
     :egressBps
     {:average number,
      :median number,
      :ninteyFifthPercentile number,
      :peak number}},
    :disk
    {:iops
     {:average number,
      :median number,
      :ninteyFifthPercentile number,
      :peak number}}}]},
 :sources [string],
 :name string,
 :createTime string,
 :insightList
 {:insights
  [{:migrationInsight
    {:fit
     {:fitLevel [FIT_LEVEL_UNSPECIFIED FIT NO_FIT REQUIRES_EFFORT]},
     :computeEngineTarget {:shape ComputeEngineShapeDescriptor}},
    :genericInsight
    {:messageId string,
     :defaultMessage string,
     :additionalInformation [string]}}],
  :updateTime string},
 :updateTime string,
 :assignedGroups [string],
 :machineDetails
 {:powerState
  [POWER_STATE_UNSPECIFIED
   PENDING
   ACTIVE
   SUSPENDING
   SUSPENDED
   DELETING
   DELETED],
  :architecture
  {:cpuArchitecture string,
   :cpuName string,
   :vendor string,
   :cpuThreadCount integer,
   :cpuSocketCount integer,
   :bios
   {:biosName string,
    :id string,
    :manufacturer string,
    :version string,
    :releaseDate {:year integer, :month integer, :day integer},
    :smbiosUuid string},
   :firmwareType [FIRMWARE_TYPE_UNSPECIFIED BIOS EFI],
   :hyperthreading [CPU_HYPER_THREADING_UNSPECIFIED DISABLED ENABLED]},
  :coreCount integer,
  :createTime string,
  :guestOs
  {:osName string,
   :family
   [OS_FAMILY_UNKNOWN
    OS_FAMILY_WINDOWS
    OS_FAMILY_LINUX
    OS_FAMILY_UNIX],
   :version string,
   :config
   {:issue string,
    :fstab {:entries [FstabEntry]},
    :hosts {:entries [HostsEntry]},
    :nfsExports {:entries [NfsExport]},
    :selinuxMode
    [SE_LINUX_MODE_UNSPECIFIED
     SE_LINUX_MODE_DISABLED
     SE_LINUX_MODE_PERMISSIVE
     SE_LINUX_MODE_ENFORCING]},
   :runtime
   {:services {:entries [RunningService]},
    :processes {:entries [RunningProcess]},
    :network {:scanTime string, :connections NetworkConnectionList},
    :lastBootTime string,
    :domain string,
    :machineName string,
    :installedApps {:entries [GuestInstalledApplication]},
    :openFileList {:entries [OpenFileDetails]}}},
  :disks
  {:totalCapacityBytes string,
   :totalFreeBytes string,
   :disks
   {:entries
    [{:capacityBytes string,
      :freeBytes string,
      :diskLabel string,
      :diskLabelType string,
      :interfaceType
      [INTERFACE_TYPE_UNSPECIFIED IDE SATA SAS SCSI NVME FC ISCSI],
      :partitions DiskPartitionList,
      :hwAddress string,
      :vmware VmwareDiskConfig}]}},
  :memoryMb integer,
  :network
  {:primaryIpAddress string,
   :publicIpAddress string,
   :primaryMacAddress string,
   :adapters
   {:entries
    [{:adapterType string,
      :macAddress string,
      :addresses NetworkAddressList}]}},
  :uuid string,
  :machineName string,
  :platform
  {:vmwareDetails
   {:vcenterVersion string,
    :esxVersion string,
    :osid string,
    :vcenterFolder string,
    :vcenterUri string,
    :vcenterVmId string},
   :awsEc2Details {:machineTypeLabel string, :location string},
   :azureVmDetails
   {:machineTypeLabel string,
    :location string,
    :provisioningState string},
   :genericDetails {:location string},
   :physicalDetails {:location string}}},
 :attributes object}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Asset` resource by the update. The values specified in the `update_mask` field are relative to the resource, not the full request. A field will be overwritten if it is in the mask. A single * value in the mask lets you to overwrite all fields.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Asset] (projects-locations-assets-patch name Asset nil))
  ([name Asset optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Asset})))

(defn projects-locations-assets-batchUpdate
  "Updates the parameters of a list of assets.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/batchUpdate

parent <string> Required. Parent value for batch asset update.
BatchUpdateAssetsRequest:
{:requests
 [{:updateMask string,
   :asset
   {:labels object,
    :performanceData
    {:dailyResourceUsageAggregations
     [{:date Date,
       :cpu DailyResourceUsageAggregationCPU,
       :memory DailyResourceUsageAggregationMemory,
       :network DailyResourceUsageAggregationNetwork,
       :disk DailyResourceUsageAggregationDisk}]},
    :sources [string],
    :name string,
    :createTime string,
    :insightList
    {:insights
     [{:migrationInsight MigrationInsight,
       :genericInsight GenericInsight}],
     :updateTime string},
    :updateTime string,
    :assignedGroups [string],
    :machineDetails
    {:powerState
     [POWER_STATE_UNSPECIFIED
      PENDING
      ACTIVE
      SUSPENDING
      SUSPENDED
      DELETING
      DELETED],
     :architecture
     {:cpuArchitecture string,
      :cpuName string,
      :vendor string,
      :cpuThreadCount integer,
      :cpuSocketCount integer,
      :bios BiosDetails,
      :firmwareType [FIRMWARE_TYPE_UNSPECIFIED BIOS EFI],
      :hyperthreading
      [CPU_HYPER_THREADING_UNSPECIFIED DISABLED ENABLED]},
     :coreCount integer,
     :createTime string,
     :guestOs
     {:osName string,
      :family
      [OS_FAMILY_UNKNOWN
       OS_FAMILY_WINDOWS
       OS_FAMILY_LINUX
       OS_FAMILY_UNIX],
      :version string,
      :config GuestConfigDetails,
      :runtime GuestRuntimeDetails},
     :disks
     {:totalCapacityBytes string,
      :totalFreeBytes string,
      :disks DiskEntryList},
     :memoryMb integer,
     :network
     {:primaryIpAddress string,
      :publicIpAddress string,
      :primaryMacAddress string,
      :adapters NetworkAdapterList},
     :uuid string,
     :machineName string,
     :platform
     {:vmwareDetails VmwarePlatformDetails,
      :awsEc2Details AwsEc2PlatformDetails,
      :azureVmDetails AzureVmPlatformDetails,
      :genericDetails GenericPlatformDetails,
      :physicalDetails PhysicalPlatformDetails}},
    :attributes object},
   :requestId string}]}"
  [parent BatchUpdateAssetsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+parent}/assets:batchUpdate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchUpdateAssetsRequest}))

(defn projects-locations-assets-delete
  "Deletes an asset.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/delete

name <string> Required. Name of the resource.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-assets-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-assets-batchDelete
  "Deletes list of Assets.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/batchDelete

parent <string> Required. Parent value for batch asset delete.
BatchDeleteAssetsRequest:
{:names [string], :allowMissing boolean}"
  [parent BatchDeleteAssetsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+parent}/assets:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchDeleteAssetsRequest}))

(defn projects-locations-assets-reportAssetFrames
  "Reports a set of frames.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/reportAssetFrames

parent <string> Required. Parent of the resource.
Frames:
{:framesData
 [{:machineDetails
   {:powerState
    [POWER_STATE_UNSPECIFIED
     PENDING
     ACTIVE
     SUSPENDING
     SUSPENDED
     DELETING
     DELETED],
    :architecture
    {:cpuArchitecture string,
     :cpuName string,
     :vendor string,
     :cpuThreadCount integer,
     :cpuSocketCount integer,
     :bios
     {:biosName string,
      :id string,
      :manufacturer string,
      :version string,
      :releaseDate Date,
      :smbiosUuid string},
     :firmwareType [FIRMWARE_TYPE_UNSPECIFIED BIOS EFI],
     :hyperthreading
     [CPU_HYPER_THREADING_UNSPECIFIED DISABLED ENABLED]},
    :coreCount integer,
    :createTime string,
    :guestOs
    {:osName string,
     :family
     [OS_FAMILY_UNKNOWN
      OS_FAMILY_WINDOWS
      OS_FAMILY_LINUX
      OS_FAMILY_UNIX],
     :version string,
     :config
     {:issue string,
      :fstab FstabEntryList,
      :hosts HostsEntryList,
      :nfsExports NfsExportList,
      :selinuxMode
      [SE_LINUX_MODE_UNSPECIFIED
       SE_LINUX_MODE_DISABLED
       SE_LINUX_MODE_PERMISSIVE
       SE_LINUX_MODE_ENFORCING]},
     :runtime
     {:services RunningServiceList,
      :processes RunningProcessList,
      :network RuntimeNetworkInfo,
      :lastBootTime string,
      :domain string,
      :machineName string,
      :installedApps GuestInstalledApplicationList,
      :openFileList OpenFileList}},
    :disks
    {:totalCapacityBytes string,
     :totalFreeBytes string,
     :disks {:entries [DiskEntry]}},
    :memoryMb integer,
    :network
    {:primaryIpAddress string,
     :publicIpAddress string,
     :primaryMacAddress string,
     :adapters {:entries [NetworkAdapterDetails]}},
    :uuid string,
    :machineName string,
    :platform
    {:vmwareDetails
     {:vcenterVersion string,
      :esxVersion string,
      :osid string,
      :vcenterFolder string,
      :vcenterUri string,
      :vcenterVmId string},
     :awsEc2Details {:machineTypeLabel string, :location string},
     :azureVmDetails
     {:machineTypeLabel string,
      :location string,
      :provisioningState string},
     :genericDetails {:location string},
     :physicalDetails {:location string}}},
   :reportTime string,
   :labels object,
   :attributes object,
   :performanceSamples
   [{:sampleTime string,
     :memory {:utilizedPercentage number},
     :cpu {:utilizedPercentage number},
     :network {:averageIngressBps number, :averageEgressBps number},
     :disk {:averageIops number}}],
   :traceToken string,
   :collectionType
   [SOURCE_TYPE_UNKNOWN
    SOURCE_TYPE_UPLOAD
    SOURCE_TYPE_GUEST_OS_SCAN
    SOURCE_TYPE_INVENTORY_SCAN
    SOURCE_TYPE_CUSTOM
    SOURCE_TYPE_DISCOVERY_CLIENT]}]}

optional:
source <string> Required. Reference to a source."
  ([parent Frames]
    (projects-locations-assets-reportAssetFrames parent Frames nil))
  ([parent Frames optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/assets:reportAssetFrames",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Frames})))

(defn projects-locations-assets-aggregateValues
  "Aggregates the requested fields based on provided function.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.assets/aggregateValues

parent <string> Required. Parent value for `AggregateAssetsValuesRequest`.
AggregateAssetsValuesRequest:
{:aggregations
 [{:field string,
   :count object,
   :sum object,
   :histogram {:lowerBounds [number]},
   :frequency object}],
 :filter string}"
  [parent AggregateAssetsValuesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+parent}/assets:aggregateValues",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AggregateAssetsValuesRequest}))

(defn projects-locations-importJobs-create
  "Creates an import job.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs/create

parent <string> Required. Value for parent.
ImportJob:
{:labels object,
 :displayName string,
 :name string,
 :createTime string,
 :state
 [IMPORT_JOB_STATE_UNSPECIFIED
  IMPORT_JOB_STATE_PENDING
  IMPORT_JOB_STATE_RUNNING
  IMPORT_JOB_STATE_COMPLETED
  IMPORT_JOB_STATE_FAILED
  IMPORT_JOB_STATE_VALIDATING
  IMPORT_JOB_STATE_FAILED_VALIDATION
  IMPORT_JOB_STATE_READY],
 :updateTime string,
 :validationReport
 {:fileValidations
  [{:fileName string,
    :rowErrors
    [{:rowNumber integer,
      :vmName string,
      :vmUuid string,
      :errors
      [{:errorDetails string,
        :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]}],
    :partialReport boolean,
    :fileErrors
    [{:errorDetails string,
      :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]}],
  :jobErrors
  [{:errorDetails string,
    :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]},
 :completeTime string,
 :executionReport
 {:framesReported integer,
  :executionErrors
  {:fileValidations
   [{:fileName string,
     :rowErrors
     [{:rowNumber integer,
       :vmName string,
       :vmUuid string,
       :errors [ImportError]}],
     :partialReport boolean,
     :fileErrors
     [{:errorDetails string,
       :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]}],
   :jobErrors
   [{:errorDetails string,
     :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]},
  :totalRowsCount integer},
 :assetSource string}

optional:
importJobId <string> Required. ID of the import job.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ImportJob]
    (projects-locations-importJobs-create parent ImportJob nil))
  ([parent ImportJob optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/importJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ImportJob})))

(defn projects-locations-importJobs-list
  "Lists all import jobs.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs/list

parent <string> Required. Parent value for `ListImportJobsRequest`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details.
view <string> Optional. The level of details of each import job. Default value is BASIC."
  ([parent] (projects-locations-importJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/importJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-importJobs-get
  "Gets the details of an import job.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs/get

name <string> Required. Name of the resource.

optional:
view <string> Optional. The level of details of the import job. Default value is FULL."
  ([name] (projects-locations-importJobs-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-importJobs-delete
  "Deletes an import job.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs/delete

name <string> Required. Name of the resource.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
force <boolean> Optional. If set to `true`, any `ImportDataFiles` of this job will also be deleted If set to `false`, the request only works if the job has no data files."
  ([name] (projects-locations-importJobs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-importJobs-patch
  "Updates an import job.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs/patch

name <string> Output only. The full name of the import job.
ImportJob:
{:labels object,
 :displayName string,
 :name string,
 :createTime string,
 :state
 [IMPORT_JOB_STATE_UNSPECIFIED
  IMPORT_JOB_STATE_PENDING
  IMPORT_JOB_STATE_RUNNING
  IMPORT_JOB_STATE_COMPLETED
  IMPORT_JOB_STATE_FAILED
  IMPORT_JOB_STATE_VALIDATING
  IMPORT_JOB_STATE_FAILED_VALIDATION
  IMPORT_JOB_STATE_READY],
 :updateTime string,
 :validationReport
 {:fileValidations
  [{:fileName string,
    :rowErrors
    [{:rowNumber integer,
      :vmName string,
      :vmUuid string,
      :errors
      [{:errorDetails string,
        :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]}],
    :partialReport boolean,
    :fileErrors
    [{:errorDetails string,
      :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]}],
  :jobErrors
  [{:errorDetails string,
    :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]},
 :completeTime string,
 :executionReport
 {:framesReported integer,
  :executionErrors
  {:fileValidations
   [{:fileName string,
     :rowErrors
     [{:rowNumber integer,
       :vmName string,
       :vmUuid string,
       :errors [ImportError]}],
     :partialReport boolean,
     :fileErrors
     [{:errorDetails string,
       :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]}],
   :jobErrors
   [{:errorDetails string,
     :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO]}]},
  :totalRowsCount integer},
 :assetSource string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Asset` resource by the update. The values specified in the `update_mask` field are relative to the resource, not the full request. A field will be overwritten if it is in the mask. A single * value in the mask lets you to overwrite all fields.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name ImportJob]
    (projects-locations-importJobs-patch name ImportJob nil))
  ([name ImportJob optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ImportJob})))

(defn projects-locations-importJobs-validate
  "Validates an import job.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs/validate

name <string> Required. The name of the import job to validate.
ValidateImportJobRequest:
{:requestId string}"
  [name ValidateImportJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+name}:validate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ValidateImportJobRequest}))

(defn projects-locations-importJobs-run
  "Runs an import job.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs/run

name <string> Required. The name of the import job to run.
RunImportJobRequest:
{:requestId string}"
  [name RunImportJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+name}:run",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RunImportJobRequest}))

(defn projects-locations-importJobs-importDataFiles-get
  "Gets an import data file.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs.importDataFiles/get

name <string> Required. Name of the ImportDataFile."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-importJobs-importDataFiles-list
  "List import data files.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs.importDataFiles/list

parent <string> Required. Name of the parent of the `ImportDataFiles` resource.

optional:
pageSize <integer> The maximum number of data files to return. The service may return fewer than this value. If unspecified, at most 500 data files will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Filtering results.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent]
    (projects-locations-importJobs-importDataFiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/importDataFiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-importJobs-importDataFiles-create
  "Creates an import data file.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs.importDataFiles/create

parent <string> Required. Name of the parent of the ImportDataFile.
ImportDataFile:
{:name string,
 :displayName string,
 :format
 [IMPORT_JOB_FORMAT_UNSPECIFIED
  IMPORT_JOB_FORMAT_RVTOOLS_XLSX
  IMPORT_JOB_FORMAT_RVTOOLS_CSV
  IMPORT_JOB_FORMAT_EXPORTED_AWS_CSV
  IMPORT_JOB_FORMAT_EXPORTED_AZURE_CSV
  IMPORT_JOB_FORMAT_STRATOZONE_CSV],
 :createTime string,
 :state [STATE_UNSPECIFIED CREATING ACTIVE],
 :uploadFileInfo
 {:signedUri string, :headers object, :uriExpirationTime string}}

optional:
importDataFileId <string> Required. The ID of the new data file.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ImportDataFile]
    (projects-locations-importJobs-importDataFiles-create
      parent
      ImportDataFile
      nil))
  ([parent ImportDataFile optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/importDataFiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ImportDataFile})))

(defn projects-locations-importJobs-importDataFiles-delete
  "Delete an import data file.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.importJobs.importDataFiles/delete

name <string> Required. Name of the ImportDataFile to delete.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name]
    (projects-locations-importJobs-importDataFiles-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-groups-list
  "Lists all groups in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.groups/list

parent <string> Required. Parent value for `ListGroupsRequest`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-groups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/groups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-groups-get
  "Gets the details of a group.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.groups/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-groups-create
  "Creates a new group in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.groups/create

parent <string> Required. Value for parent.
Group:
{:name string,
 :createTime string,
 :updateTime string,
 :labels object,
 :displayName string,
 :description string}

optional:
groupId <string> Required. User specified ID for the group. It will become the last component of the group name. The ID must be unique within the project, must conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63 characters. The ID must match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Group] (projects-locations-groups-create parent Group nil))
  ([parent Group optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/groups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Group})))

(defn projects-locations-groups-patch
  "Updates the parameters of a group.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.groups/patch

name <string> Output only. The name of the group.
Group:
{:name string,
 :createTime string,
 :updateTime string,
 :labels object,
 :displayName string,
 :description string}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Group` resource by the update. The values specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. A single * value in the mask lets you to overwrite all fields.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Group] (projects-locations-groups-patch name Group nil))
  ([name Group optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Group})))

(defn projects-locations-groups-delete
  "Deletes a group.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.groups/delete

name <string> Required. Name of the group resource.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-groups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-groups-addAssets
  "Adds assets to a group.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.groups/addAssets

group <string> Required. Group reference.
AddAssetsToGroupRequest:
{:requestId string,
 :assets {:assetIds [string]},
 :allowExisting boolean}"
  [group AddAssetsToGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+group}:addAssets",
     :uri-template-args {:group group},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AddAssetsToGroupRequest}))

(defn projects-locations-groups-removeAssets
  "Removes assets from a group.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.groups/removeAssets

group <string> Required. Group reference.
RemoveAssetsFromGroupRequest:
{:requestId string, :assets {:assetIds [string]}, :allowMissing boolean}"
  [group RemoveAssetsFromGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+group}:removeAssets",
     :uri-template-args {:group group},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RemoveAssetsFromGroupRequest}))

(defn projects-locations-sources-list
  "Lists all the sources in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.sources/list

parent <string> Required. Parent value for `ListSourcesRequest`.

optional:
pageSize <integer> Requested page size. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default value.
filter <string> Filtering results.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-sources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/sources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sources-get
  "Gets the details of a source.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.sources/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sources-create
  "Creates a new source in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.sources/create

parent <string> Required. Value for parent.
Source:
{:description string,
 :pendingFrameCount integer,
 :displayName string,
 :name string,
 :createTime string,
 :type
 [SOURCE_TYPE_UNKNOWN
  SOURCE_TYPE_UPLOAD
  SOURCE_TYPE_GUEST_OS_SCAN
  SOURCE_TYPE_INVENTORY_SCAN
  SOURCE_TYPE_CUSTOM
  SOURCE_TYPE_DISCOVERY_CLIENT],
 :state [STATE_UNSPECIFIED ACTIVE DELETING INVALID],
 :updateTime string,
 :priority integer,
 :errorFrameCount integer,
 :managed boolean}

optional:
sourceId <string> Required. User specified ID for the source. It will become the last component of the source name. The ID must be unique within the project, must conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63 characters. The ID must match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Source]
    (projects-locations-sources-create parent Source nil))
  ([parent Source optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/sources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Source})))

(defn projects-locations-sources-patch
  "Updates the parameters of a source.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.sources/patch

name <string> Output only. The full name of the source.
Source:
{:description string,
 :pendingFrameCount integer,
 :displayName string,
 :name string,
 :createTime string,
 :type
 [SOURCE_TYPE_UNKNOWN
  SOURCE_TYPE_UPLOAD
  SOURCE_TYPE_GUEST_OS_SCAN
  SOURCE_TYPE_INVENTORY_SCAN
  SOURCE_TYPE_CUSTOM
  SOURCE_TYPE_DISCOVERY_CLIENT],
 :state [STATE_UNSPECIFIED ACTIVE DELETING INVALID],
 :updateTime string,
 :priority integer,
 :errorFrameCount integer,
 :managed boolean}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Source` resource by the update. The values specified in the `update_mask` field are relative to the resource, not the full request. A field will be overwritten if it is in the mask. A single * value in the mask lets you to overwrite all fields.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Source] (projects-locations-sources-patch name Source nil))
  ([name Source optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Source})))

(defn projects-locations-sources-delete
  "Deletes a source.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.sources/delete

name <string> Required. Name of the resource.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-sources-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sources-errorFrames-list
  "Lists all error frames in a given source and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.sources.errorFrames/list

parent <string> Required. Parent value (the source) for `ListErrorFramesRequest`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
view <string> Optional. An optional view mode to control the level of details of each error frame. The default is a BASIC frame view."
  ([parent] (projects-locations-sources-errorFrames-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/errorFrames",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sources-errorFrames-get
  "Gets the details of an error frame.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.sources.errorFrames/get

name <string> Required. The name of the frame to retrieve. Format: projects/{project}/locations/{location}/sources/{source}/errorFrames/{error_frame}

optional:
view <string> Optional. An optional view mode to control the level of details for the frame. The default is a basic frame view."
  ([name] (projects-locations-sources-errorFrames-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-preferenceSets-list
  "Lists all the preference sets in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.preferenceSets/list

parent <string> Required. Parent value for `ListPreferenceSetsRequest`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, at most 500 preference sets will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-preferenceSets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/preferenceSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-preferenceSets-get
  "Gets the details of a preference set.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.preferenceSets/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-preferenceSets-create
  "Creates a new preference set in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.preferenceSets/create

parent <string> Required. Value for parent.
PreferenceSet:
{:name string,
 :createTime string,
 :updateTime string,
 :displayName string,
 :description string,
 :virtualMachinePreferences
 {:targetProduct
  [COMPUTE_MIGRATION_TARGET_PRODUCT_UNSPECIFIED
   COMPUTE_MIGRATION_TARGET_PRODUCT_COMPUTE_ENGINE
   COMPUTE_MIGRATION_TARGET_PRODUCT_VMWARE_ENGINE
   COMPUTE_MIGRATION_TARGET_PRODUCT_SOLE_TENANCY],
  :regionPreferences {:preferredRegions [string]},
  :commitmentPlan
  [COMMITMENT_PLAN_UNSPECIFIED
   COMMITMENT_PLAN_NONE
   COMMITMENT_PLAN_ONE_YEAR
   COMMITMENT_PLAN_THREE_YEARS],
  :sizingOptimizationStrategy
  [SIZING_OPTIMIZATION_STRATEGY_UNSPECIFIED
   SIZING_OPTIMIZATION_STRATEGY_SAME_AS_SOURCE
   SIZING_OPTIMIZATION_STRATEGY_MODERATE
   SIZING_OPTIMIZATION_STRATEGY_AGGRESSIVE],
  :computeEnginePreferences
  {:persistentDiskType
   [PERSISTENT_DISK_TYPE_UNSPECIFIED
    PERSISTENT_DISK_TYPE_STANDARD
    PERSISTENT_DISK_TYPE_BALANCED
    PERSISTENT_DISK_TYPE_SSD],
   :machinePreferences {:allowedMachineSeries [{:code string}]},
   :licenseType
   [LICENSE_TYPE_UNSPECIFIED
    LICENSE_TYPE_DEFAULT
    LICENSE_TYPE_BRING_YOUR_OWN_LICENSE]},
  :vmwareEnginePreferences
  {:cpuOvercommitRatio number,
   :memoryOvercommitRatio number,
   :storageDeduplicationCompressionRatio number,
   :commitmentPlan
   [COMMITMENT_PLAN_UNSPECIFIED
    ON_DEMAND
    COMMITMENT_1_YEAR_MONTHLY_PAYMENTS
    COMMITMENT_3_YEAR_MONTHLY_PAYMENTS
    COMMITMENT_1_YEAR_UPFRONT_PAYMENT
    COMMITMENT_3_YEAR_UPFRONT_PAYMENT]},
  :soleTenancyPreferences
  {:cpuOvercommitRatio number,
   :hostMaintenancePolicy
   [HOST_MAINTENANCE_POLICY_UNSPECIFIED
    HOST_MAINTENANCE_POLICY_DEFAULT
    HOST_MAINTENANCE_POLICY_RESTART_IN_PLACE
    HOST_MAINTENANCE_POLICY_MIGRATE_WITHIN_NODE_GROUP],
   :commitmentPlan
   [COMMITMENT_PLAN_UNSPECIFIED
    ON_DEMAND
    COMMITMENT_1_YEAR
    COMMITMENT_3_YEAR],
   :nodeTypes [{:nodeName string}]}}}

optional:
preferenceSetId <string> Required. User specified ID for the preference set. It will become the last component of the preference set name. The ID must be unique within the project, must conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63 characters. The ID must match the regular expression `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent PreferenceSet]
    (projects-locations-preferenceSets-create
      parent
      PreferenceSet
      nil))
  ([parent PreferenceSet optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/preferenceSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PreferenceSet})))

(defn projects-locations-preferenceSets-patch
  "Updates the parameters of a preference set.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.preferenceSets/patch

name <string> Output only. Name of the preference set.
PreferenceSet:
{:name string,
 :createTime string,
 :updateTime string,
 :displayName string,
 :description string,
 :virtualMachinePreferences
 {:targetProduct
  [COMPUTE_MIGRATION_TARGET_PRODUCT_UNSPECIFIED
   COMPUTE_MIGRATION_TARGET_PRODUCT_COMPUTE_ENGINE
   COMPUTE_MIGRATION_TARGET_PRODUCT_VMWARE_ENGINE
   COMPUTE_MIGRATION_TARGET_PRODUCT_SOLE_TENANCY],
  :regionPreferences {:preferredRegions [string]},
  :commitmentPlan
  [COMMITMENT_PLAN_UNSPECIFIED
   COMMITMENT_PLAN_NONE
   COMMITMENT_PLAN_ONE_YEAR
   COMMITMENT_PLAN_THREE_YEARS],
  :sizingOptimizationStrategy
  [SIZING_OPTIMIZATION_STRATEGY_UNSPECIFIED
   SIZING_OPTIMIZATION_STRATEGY_SAME_AS_SOURCE
   SIZING_OPTIMIZATION_STRATEGY_MODERATE
   SIZING_OPTIMIZATION_STRATEGY_AGGRESSIVE],
  :computeEnginePreferences
  {:persistentDiskType
   [PERSISTENT_DISK_TYPE_UNSPECIFIED
    PERSISTENT_DISK_TYPE_STANDARD
    PERSISTENT_DISK_TYPE_BALANCED
    PERSISTENT_DISK_TYPE_SSD],
   :machinePreferences {:allowedMachineSeries [{:code string}]},
   :licenseType
   [LICENSE_TYPE_UNSPECIFIED
    LICENSE_TYPE_DEFAULT
    LICENSE_TYPE_BRING_YOUR_OWN_LICENSE]},
  :vmwareEnginePreferences
  {:cpuOvercommitRatio number,
   :memoryOvercommitRatio number,
   :storageDeduplicationCompressionRatio number,
   :commitmentPlan
   [COMMITMENT_PLAN_UNSPECIFIED
    ON_DEMAND
    COMMITMENT_1_YEAR_MONTHLY_PAYMENTS
    COMMITMENT_3_YEAR_MONTHLY_PAYMENTS
    COMMITMENT_1_YEAR_UPFRONT_PAYMENT
    COMMITMENT_3_YEAR_UPFRONT_PAYMENT]},
  :soleTenancyPreferences
  {:cpuOvercommitRatio number,
   :hostMaintenancePolicy
   [HOST_MAINTENANCE_POLICY_UNSPECIFIED
    HOST_MAINTENANCE_POLICY_DEFAULT
    HOST_MAINTENANCE_POLICY_RESTART_IN_PLACE
    HOST_MAINTENANCE_POLICY_MIGRATE_WITHIN_NODE_GROUP],
   :commitmentPlan
   [COMMITMENT_PLAN_UNSPECIFIED
    ON_DEMAND
    COMMITMENT_1_YEAR
    COMMITMENT_3_YEAR],
   :nodeTypes [{:nodeName string}]}}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `PreferenceSet` resource by the update. The values specified in the `update_mask` field are relative to the resource, not the full request. A field will be overwritten if it is in the mask. A single * value in the mask lets you to overwrite all fields.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name PreferenceSet]
    (projects-locations-preferenceSets-patch name PreferenceSet nil))
  ([name PreferenceSet optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PreferenceSet})))

(defn projects-locations-preferenceSets-delete
  "Deletes a preference set.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.preferenceSets/delete

name <string> Required. Name of the group resource.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-preferenceSets-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-reportConfigs-create
  "Creates a report configuration.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs/create

parent <string> Required. Value for parent.
ReportConfig:
{:name string,
 :createTime string,
 :updateTime string,
 :displayName string,
 :description string,
 :groupPreferencesetAssignments
 [{:group string, :preferenceSet string}]}

optional:
reportConfigId <string> Required. User specified ID for the report config. It will become the last component of the report config name. The ID must be unique within the project, must conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63 characters. The ID must match the regular expression: [a-z]([a-z0-9-]{0,61}[a-z0-9])?.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent ReportConfig]
    (projects-locations-reportConfigs-create parent ReportConfig nil))
  ([parent ReportConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/reportConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ReportConfig})))

(defn projects-locations-reportConfigs-get
  "Gets details of a single ReportConfig.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-reportConfigs-list
  "Lists ReportConfigs in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs/list

parent <string> Required. Parent value for `ListReportConfigsRequest`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-reportConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/reportConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-reportConfigs-delete
  "Deletes a ReportConfig.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs/delete

name <string> Required. Name of the resource.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
force <boolean> Optional. If set to `true`, any child `Reports` of this entity will also be deleted. If set to `false`, the request only works if the resource has no children."
  ([name] (projects-locations-reportConfigs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-reportConfigs-reports-create
  "Creates a report.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs.reports/create

parent <string> Required. Value for parent.
Report:
{:name string,
 :createTime string,
 :updateTime string,
 :displayName string,
 :description string,
 :type [TYPE_UNSPECIFIED TOTAL_COST_OF_OWNERSHIP],
 :state [STATE_UNSPECIFIED PENDING SUCCEEDED FAILED],
 :summary
 {:allAssetsStats
  {:totalCores string,
   :totalAssets string,
   :totalStorageBytes string,
   :totalMemoryBytes string,
   :coreCountHistogram
   {:buckets
    [{:lowerBound string, :upperBound string, :count string}]},
   :storageUtilizationChart {:used string, :free string},
   :operatingSystem {:dataPoints [{:label string, :value number}]},
   :storageBytesHistogram
   {:buckets
    [{:lowerBound string, :upperBound string, :count string}]},
   :memoryUtilizationChart {:used string, :free string},
   :memoryBytesHistogram
   {:buckets
    [{:lowerBound string, :upperBound string, :count string}]}},
  :groupFindings
  [{:displayName string,
    :description string,
    :assetAggregateStats
    {:totalCores string,
     :totalAssets string,
     :totalStorageBytes string,
     :totalMemoryBytes string,
     :coreCountHistogram
     {:buckets [ReportSummaryHistogramChartDataBucket]},
     :storageUtilizationChart {:used string, :free string},
     :operatingSystem {:dataPoints [ReportSummaryChartDataDataPoint]},
     :storageBytesHistogram
     {:buckets [ReportSummaryHistogramChartDataBucket]},
     :memoryUtilizationChart {:used string, :free string},
     :memoryBytesHistogram
     {:buckets [ReportSummaryHistogramChartDataBucket]}},
    :overlappingAssetCount string,
    :preferenceSetFindings
    [{:description string,
      :soleTenantFinding
      {:allocatedRegions [string],
       :allocatedAssetCount string,
       :nodeAllocations [ReportSummarySoleTenantNodeAllocation]},
      :vmwareEngineFinding
      {:allocatedRegions [string],
       :allocatedAssetCount string,
       :nodeAllocations [ReportSummaryVmwareNodeAllocation]},
      :displayName string,
      :monthlyCostOsLicense
      {:currencyCode string, :units string, :nanos integer},
      :monthlyCostStorage
      {:currencyCode string, :units string, :nanos integer},
      :computeEngineFinding
      {:allocatedRegions [string],
       :allocatedAssetCount string,
       :machineSeriesAllocations
       [ReportSummaryMachineSeriesAllocation],
       :allocatedDiskTypes
       [[PERSISTENT_DISK_TYPE_UNSPECIFIED
         PERSISTENT_DISK_TYPE_STANDARD
         PERSISTENT_DISK_TYPE_BALANCED
         PERSISTENT_DISK_TYPE_SSD]]},
      :monthlyCostNetworkEgress
      {:currencyCode string, :units string, :nanos integer},
      :machinePreferences
      {:targetProduct
       [COMPUTE_MIGRATION_TARGET_PRODUCT_UNSPECIFIED
        COMPUTE_MIGRATION_TARGET_PRODUCT_COMPUTE_ENGINE
        COMPUTE_MIGRATION_TARGET_PRODUCT_VMWARE_ENGINE
        COMPUTE_MIGRATION_TARGET_PRODUCT_SOLE_TENANCY],
       :regionPreferences RegionPreferences,
       :commitmentPlan
       [COMMITMENT_PLAN_UNSPECIFIED
        COMMITMENT_PLAN_NONE
        COMMITMENT_PLAN_ONE_YEAR
        COMMITMENT_PLAN_THREE_YEARS],
       :sizingOptimizationStrategy
       [SIZING_OPTIMIZATION_STRATEGY_UNSPECIFIED
        SIZING_OPTIMIZATION_STRATEGY_SAME_AS_SOURCE
        SIZING_OPTIMIZATION_STRATEGY_MODERATE
        SIZING_OPTIMIZATION_STRATEGY_AGGRESSIVE],
       :computeEnginePreferences ComputeEnginePreferences,
       :vmwareEnginePreferences VmwareEnginePreferences,
       :soleTenancyPreferences SoleTenancyPreferences},
      :monthlyCostTotal
      {:currencyCode string, :units string, :nanos integer},
      :monthlyCostOther
      {:currencyCode string, :units string, :nanos integer},
      :monthlyCostCompute
      {:currencyCode string, :units string, :nanos integer}}]}]}}

optional:
reportId <string> Required. User specified id for the report. It will become the last component of the report name. The id must be unique within the project, must conform with RFC-1034, is restricted to lower-cased letters, and has a maximum length of 63 characters. The id must match the regular expression: [a-z]([a-z0-9-]{0,61}[a-z0-9])?.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent Report]
    (projects-locations-reportConfigs-reports-create
      parent
      Report
      nil))
  ([parent Report optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/reports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Report})))

(defn projects-locations-reportConfigs-reports-get
  "Gets details of a single Report.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs.reports/get

name <string> Required. Name of the resource.

optional:
view <string> Determines what information to retrieve for the Report."
  ([name] (projects-locations-reportConfigs-reports-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-reportConfigs-reports-list
  "Lists Reports in a given ReportConfig.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs.reports/list

parent <string> Required. Parent value for `ListReportsRequest`.

optional:
pageSize <integer> Requested page size. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default value.
filter <string> Filtering results.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details.
view <string> Determines what information to retrieve for each Report."
  ([parent] (projects-locations-reportConfigs-reports-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/reports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-reportConfigs-reports-delete
  "Deletes a Report.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.reportConfigs.reports/delete

name <string> Required. Name of the resource.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-reportConfigs-reports-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-discoveryClients-create
  "Creates a new discovery client.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.discoveryClients/create

parent <string> Required. Parent resource.
DiscoveryClient:
{:description string,
 :serviceAccount string,
 :labels object,
 :errors [{:code integer, :message string, :details [object]}],
 :heartbeatTime string,
 :displayName string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE OFFLINE DEGRADED EXPIRED],
 :source string,
 :updateTime string,
 :ttl string,
 :expireTime string,
 :signalsEndpoint string,
 :version string}

optional:
discoveryClientId <string> Required. User specified ID for the discovery client. It will become the last component of the discovery client name. The ID must be unique within the project, is restricted to lower-cased letters and has a maximum length of 63 characters. The ID must match the regular expression: `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent DiscoveryClient]
    (projects-locations-discoveryClients-create
      parent
      DiscoveryClient
      nil))
  ([parent DiscoveryClient optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/discoveryClients",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DiscoveryClient})))

(defn projects-locations-discoveryClients-get
  "Gets the details of a discovery client.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.discoveryClients/get

name <string> Required. The discovery client name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://migrationcenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-discoveryClients-list
  "Lists all the discovery clients in a given project and location.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.discoveryClients/list

parent <string> Required. Parent resource.

optional:
pageSize <integer> Optional. The maximum number of items to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default value.
filter <string> Optional. Filter expression to filter results by.
orderBy <string> Optional. Field to sort by."
  ([parent] (projects-locations-discoveryClients-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+parent}/discoveryClients",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-discoveryClients-patch
  "Updates a discovery client.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.discoveryClients/patch

name <string> Output only. Identifier. Full name of this discovery client.
DiscoveryClient:
{:description string,
 :serviceAccount string,
 :labels object,
 :errors [{:code integer, :message string, :details [object]}],
 :heartbeatTime string,
 :displayName string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE OFFLINE DEGRADED EXPIRED],
 :source string,
 :updateTime string,
 :ttl string,
 :expireTime string,
 :signalsEndpoint string,
 :version string}

optional:
updateMask <string> Required. Update mask is used to specify the fields to be overwritten in the `DiscoveryClient` resource by the update. The values specified in the `update_mask` field are relative to the resource, not the full request. A field will be overwritten if it is in the mask. A single * value in the mask lets you to overwrite all fields.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name DiscoveryClient]
    (projects-locations-discoveryClients-patch
      name
      DiscoveryClient
      nil))
  ([name DiscoveryClient optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DiscoveryClient})))

(defn projects-locations-discoveryClients-sendHeartbeat
  "Sends a discovery client heartbeat. Healthy clients are expected to send heartbeats regularly (normally every few minutes).
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.discoveryClients/sendHeartbeat

name <string> Required. The discovery client name.
SendDiscoveryClientHeartbeatRequest:
{:version string,
 :errors [{:code integer, :message string, :details [object]}]}"
  [name SendDiscoveryClientHeartbeatRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://migrationcenter.googleapis.com/v1/{+name}:sendHeartbeat",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SendDiscoveryClientHeartbeatRequest}))

(defn projects-locations-discoveryClients-delete
  "Deletes a discovery client.
https://cloud.google.com/migration-center/docs/reference/rest/v1/projects.locations.discoveryClients/delete

name <string> Required. The discovery client name.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-discoveryClients-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://migrationcenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

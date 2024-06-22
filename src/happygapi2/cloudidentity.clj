(ns happygapi2.cloudidentity
  "Cloud Identity API
API for provisioning and managing identity resources.
See: https://cloud.google.com/identity/"
  (:require [happy.oauth2.client :as client]))

(defn devices-create
  "Creates a device. Only company-owned device may be created. **Note**: This method is available only to customers who have one of the following SKUs: Enterprise Standard, Enterprise Plus, Enterprise for Education, and Cloud Identity Premium
https://cloud.google.com/identity/docs/reference/rest/v1/devices/create

GoogleAppsCloudidentityDevicesV1Device:
{:networkOperator string,
 :otherAccounts [string],
 :releaseVersion string,
 :serialNumber string,
 :enabledUsbDebugging boolean,
 :deviceId string,
 :name string,
 :bootloaderVersion string,
 :ownerType [DEVICE_OWNERSHIP_UNSPECIFIED COMPANY BYOD],
 :meid string,
 :createTime string,
 :buildNumber string,
 :hostname string,
 :endpointVerificationSpecificAttributes
 {:certificateAttributes
  [{:certificateTemplate
    {:id string, :majorVersion integer, :minorVersion integer},
    :validityStartTime string,
    :serialNumber string,
    :thumbprint string,
    :validationState
    [CERTIFICATE_VALIDATION_STATE_UNSPECIFIED
     VALIDATION_SUCCESSFUL
     VALIDATION_FAILED],
    :issuer string,
    :validityExpirationTime string,
    :subject string,
    :fingerprint string}],
  :browserAttributes
  [{:lastProfileSyncTime string,
    :chromeBrowserInfo
    {:isThirdPartyBlockingEnabled boolean,
     :safeBrowsingProtectionLevel
     [SAFE_BROWSING_LEVEL_UNSPECIFIED DISABLED STANDARD ENHANCED],
     :isSecurityEventAnalysisEnabled boolean,
     :isBulkDataEntryAnalysisEnabled boolean,
     :isChromeCleanupEnabled boolean,
     :isBuiltInDnsClientEnabled boolean,
     :isRealtimeUrlCheckEnabled boolean,
     :isFileUploadAnalysisEnabled boolean,
     :browserVersion string,
     :isFileDownloadAnalysisEnabled boolean,
     :isChromeRemoteDesktopAppBlocked boolean,
     :browserManagementState
     [UNSPECIFIED
      UNMANAGED
      MANAGED_BY_OTHER_DOMAIN
      PROFILE_MANAGED
      BROWSER_MANAGED],
     :isSiteIsolationEnabled boolean,
     :passwordProtectionWarningTrigger
     [PASSWORD_PROTECTION_TRIGGER_UNSPECIFIED
      PROTECTION_OFF
      PASSWORD_REUSE
      PHISHING_REUSE]},
    :chromeProfileId string}],
  :additionalSignals object},
 :brand string,
 :kernelVersion string,
 :compromisedState
 [COMPROMISED_STATE_UNSPECIFIED COMPROMISED UNCOMPROMISED],
 :imei string,
 :basebandVersion string,
 :wifiMacAddresses [string],
 :securityPatchTime string,
 :lastSyncTime string,
 :deviceType
 [DEVICE_TYPE_UNSPECIFIED
  ANDROID
  IOS
  GOOGLE_SYNC
  WINDOWS
  MAC_OS
  LINUX
  CHROME_OS],
 :encryptionState
 [ENCRYPTION_STATE_UNSPECIFIED
  UNSUPPORTED_BY_DEVICE
  ENCRYPTED
  NOT_ENCRYPTED],
 :osVersion string,
 :manufacturer string,
 :androidSpecificAttributes
 {:enabledUnknownSources boolean,
  :supportsWorkProfile boolean,
  :ownerProfileAccount boolean,
  :ownershipPrivilege
  [OWNERSHIP_PRIVILEGE_UNSPECIFIED
   DEVICE_ADMINISTRATOR
   PROFILE_OWNER
   DEVICE_OWNER],
  :verifiedBoot boolean,
  :ctsProfileMatch boolean,
  :verifyAppsEnabled boolean,
  :hasPotentiallyHarmfulApps boolean},
 :enabledDeveloperOptions boolean,
 :unifiedDeviceId string,
 :assetTag string,
 :managementState
 [MANAGEMENT_STATE_UNSPECIFIED
  APPROVED
  BLOCKED
  PENDING
  UNPROVISIONED
  WIPING
  WIPED],
 :model string}

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs."
  ([GoogleAppsCloudidentityDevicesV1Device]
    (devices-create GoogleAppsCloudidentityDevicesV1Device nil))
  ([GoogleAppsCloudidentityDevicesV1Device optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://cloudidentity.googleapis.com/v1/devices",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"],
       :body GoogleAppsCloudidentityDevicesV1Device})))

(defn devices-get
  "Retrieves the specified device.
https://cloud.google.com/identity/docs/reference/rest/v1/devices/get

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in the format: `devices/{device}`, where device is the unique ID assigned to the Device.

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Customer in the format: `customers/{customer}`, where customer is the customer to whom the device belongs. If you're using this API for your own organization, use `customers/my_customer`. If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs."
  ([name] (devices-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"
        "https://www.googleapis.com/auth/cloud-identity.devices.readonly"]})))

(defn devices-list
  "Lists/Searches devices.
https://cloud.google.com/identity/docs/reference/rest/v1/devices/list

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer in the format: `customers/{customer}`, where customer is the customer to whom the device belongs. If you're using this API for your own organization, use `customers/my_customer`. If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs.
filter <string> Optional. Additional restrictions when fetching list of devices. For a list of search fields, refer to [Mobile device search fields](https://developers.google.com/admin-sdk/directory/v1/search-operators). Multiple search fields are separated by the space character.
pageSize <integer> Optional. The maximum number of Devices to return. If unspecified, at most 20 Devices will be returned. The maximum value is 100; values above 100 will be coerced to 100.
orderBy <string> Optional. Order specification for devices in the response. Only one of the following field names may be used to specify the order: `create_time`, `last_sync_time`, `model`, `os_version`, `device_type` and `serial_number`. `desc` may be specified optionally at the end to specify results to be sorted in descending order. Default order is ascending.
view <string> Optional. The view to use for the List request."
  ([] (devices-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudidentity.googleapis.com/v1/devices",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"
        "https://www.googleapis.com/auth/cloud-identity.devices.readonly"]})))

(defn devices-delete
  "Deletes the specified device.
https://cloud.google.com/identity/docs/reference/rest/v1/devices/delete

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}`, where device is the unique ID assigned to the Device.

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs."
  ([name] (devices-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"]})))

(defn devices-wipe
  "Wipes all data on the specified device.
https://cloud.google.com/identity/docs/reference/rest/v1/devices/wipe

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}/deviceUsers/{device_user}`, where device is the unique ID assigned to the Device, and device_user is the unique ID assigned to the User.
GoogleAppsCloudidentityDevicesV1WipeDeviceRequest:
{:customer string, :removeResetLock boolean}"
  [name GoogleAppsCloudidentityDevicesV1WipeDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:wipe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.devices"],
     :body GoogleAppsCloudidentityDevicesV1WipeDeviceRequest}))

(defn devices-cancelWipe
  "Cancels an unfinished device wipe. This operation can be used to cancel device wipe in the gap between the wipe operation returning success and the device being wiped. This operation is possible when the device is in a \"pending wipe\" state. The device enters the \"pending wipe\" state when a wipe device command is issued, but has not yet been sent to the device. The cancel wipe will fail if the wipe command has already been issued to the device.
https://cloud.google.com/identity/docs/reference/rest/v1/devices/cancelWipe

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}`, where device is the unique ID assigned to the Device.
GoogleAppsCloudidentityDevicesV1CancelWipeDeviceRequest:
{:customer string}"
  [name GoogleAppsCloudidentityDevicesV1CancelWipeDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:cancelWipe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.devices"],
     :body GoogleAppsCloudidentityDevicesV1CancelWipeDeviceRequest}))

(defn devices-deviceUsers-get
  "Retrieves the specified DeviceUser
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/get

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}/deviceUsers/{device_user}`, where device is the unique ID assigned to the Device, and device_user is the unique ID assigned to the User.

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs."
  ([name] (devices-deviceUsers-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"
        "https://www.googleapis.com/auth/cloud-identity.devices.readonly"]})))

(defn devices-deviceUsers-list
  "Lists/Searches DeviceUsers.
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/list

parent <string> Required. To list all DeviceUsers, set this to \"devices/-\". To list all DeviceUsers owned by a device, set this to the resource name of the device. Format: devices/{device}

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs.
filter <string> Optional. Additional restrictions when fetching list of devices. For a list of search fields, refer to [Mobile device search fields](https://developers.google.com/admin-sdk/directory/v1/search-operators). Multiple search fields are separated by the space character.
pageSize <integer> Optional. The maximum number of DeviceUsers to return. If unspecified, at most 5 DeviceUsers will be returned. The maximum value is 20; values above 20 will be coerced to 20.
orderBy <string> Optional. Order specification for devices in the response."
  ([parent] (devices-deviceUsers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/deviceUsers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"
        "https://www.googleapis.com/auth/cloud-identity.devices.readonly"]})))

(defn devices-deviceUsers-delete
  "Deletes the specified DeviceUser. This also revokes the user's access to device data.
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/delete

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}/deviceUsers/{device_user}`, where device is the unique ID assigned to the Device, and device_user is the unique ID assigned to the User.

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs."
  ([name] (devices-deviceUsers-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"]})))

(defn devices-deviceUsers-lookup
  "Looks up resource names of the DeviceUsers associated with the caller's credentials, as well as the properties provided in the request. This method must be called with end-user credentials with the scope: https://www.googleapis.com/auth/cloud-identity.devices.lookup If multiple properties are provided, only DeviceUsers having all of these properties are considered as matches - i.e. the query behaves like an AND. Different platforms require different amounts of information from the caller to ensure that the DeviceUser is uniquely identified. - iOS: No properties need to be passed, the caller's credentials are sufficient to identify the corresponding DeviceUser. - Android: Specifying the 'android_id' field is required. - Desktop: Specifying the 'raw_resource_id' field is required.
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/lookup

parent <string> Must be set to \"devices/-/deviceUsers\" to search across all DeviceUser belonging to the user.

optional:
pageSize <integer> The maximum number of DeviceUsers to return. If unspecified, at most 20 DeviceUsers will be returned. The maximum value is 20; values above 20 will be coerced to 20.
androidId <string> Android Id returned by [Settings.Secure#ANDROID_ID](https://developer.android.com/reference/android/provider/Settings.Secure.html#ANDROID_ID).
rawResourceId <string> Raw Resource Id used by Google Endpoint Verification. If the user is enrolled into Google Endpoint Verification, this id will be saved as the 'device_resource_id' field in the following platform dependent files. * macOS: ~/.secureConnect/context_aware_config.json * Windows: %USERPROFILE%\\AppData\\Local\\Google\\Endpoint Verification\\accounts.json * Linux: ~/.secureConnect/context_aware_config.json
userId <string> The user whose DeviceUser's resource name will be fetched. Must be set to 'me' to fetch the DeviceUser's resource name for the calling user."
  ([parent] (devices-deviceUsers-lookup parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}:lookup",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices.lookup"]})))

(defn devices-deviceUsers-approve
  "Approves device to access user data.
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/approve

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}/deviceUsers/{device_user}`, where device is the unique ID assigned to the Device, and device_user is the unique ID assigned to the User.
GoogleAppsCloudidentityDevicesV1ApproveDeviceUserRequest:
{:customer string}"
  [name GoogleAppsCloudidentityDevicesV1ApproveDeviceUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:approve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.devices"],
     :body GoogleAppsCloudidentityDevicesV1ApproveDeviceUserRequest}))

(defn devices-deviceUsers-block
  "Blocks device from accessing user data
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/block

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}/deviceUsers/{device_user}`, where device is the unique ID assigned to the Device, and device_user is the unique ID assigned to the User.
GoogleAppsCloudidentityDevicesV1BlockDeviceUserRequest:
{:customer string}"
  [name GoogleAppsCloudidentityDevicesV1BlockDeviceUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:block",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.devices"],
     :body GoogleAppsCloudidentityDevicesV1BlockDeviceUserRequest}))

(defn devices-deviceUsers-wipe
  "Wipes the user's account on a device. Other data on the device that is not associated with the user's work account is not affected. For example, if a Gmail app is installed on a device that is used for personal and work purposes, and the user is logged in to the Gmail app with their personal account as well as their work account, wiping the \"deviceUser\" by their work administrator will not affect their personal account within Gmail or other apps such as Photos.
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/wipe

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}/deviceUsers/{device_user}`, where device is the unique ID assigned to the Device, and device_user is the unique ID assigned to the User.
GoogleAppsCloudidentityDevicesV1WipeDeviceUserRequest:
{:customer string}"
  [name GoogleAppsCloudidentityDevicesV1WipeDeviceUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:wipe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.devices"],
     :body GoogleAppsCloudidentityDevicesV1WipeDeviceUserRequest}))

(defn devices-deviceUsers-cancelWipe
  "Cancels an unfinished user account wipe. This operation can be used to cancel device wipe in the gap between the wipe operation returning success and the device being wiped.
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers/cancelWipe

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Device in format: `devices/{device}/deviceUsers/{device_user}`, where device is the unique ID assigned to the Device, and device_user is the unique ID assigned to the User.
GoogleAppsCloudidentityDevicesV1CancelWipeDeviceUserRequest:
{:customer string}"
  [name GoogleAppsCloudidentityDevicesV1CancelWipeDeviceUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:cancelWipe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.devices"],
     :body
     GoogleAppsCloudidentityDevicesV1CancelWipeDeviceUserRequest}))

(defn devices-deviceUsers-clientStates-get
  "Gets the client state for the device user
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers.clientStates/get

name <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the ClientState in format: `devices/{device}/deviceUsers/{device_user}/clientStates/{partner}`, where `device` is the unique ID assigned to the Device, `device_user` is the unique ID assigned to the User and `partner` identifies the partner storing the data. To get the client state for devices belonging to your own organization, the `partnerId` is in the format: `customerId-*anystring*`. Where the `customerId` is your organization's customer ID and `anystring` is any suffix. This suffix is used in setting up Custom Access Levels in Context-Aware Access. You may use `my_customer` instead of the customer ID for devices managed by your own organization. You may specify `-` in place of the `{device}`, so the ClientState resource name can be: `devices/-/deviceUsers/{device_user_resource}/clientStates/{partner}`.

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs."
  ([name] (devices-deviceUsers-clientStates-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"
        "https://www.googleapis.com/auth/cloud-identity.devices.readonly"]})))

(defn devices-deviceUsers-clientStates-list
  "Lists the client states for the given search query.
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers.clientStates/list

parent <string> Required. To list all ClientStates, set this to \"devices/-/deviceUsers/-\". To list all ClientStates owned by a DeviceUser, set this to the resource name of the DeviceUser. Format: devices/{device}/deviceUsers/{deviceUser}

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs.
filter <string> Optional. Additional restrictions when fetching list of client states.
orderBy <string> Optional. Order specification for client states in the response."
  ([parent] (devices-deviceUsers-clientStates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/clientStates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"
        "https://www.googleapis.com/auth/cloud-identity.devices.readonly"]})))

(defn devices-deviceUsers-clientStates-patch
  "Updates the client state for the device user **Note**: This method is available only to customers who have one of the following SKUs: Enterprise Standard, Enterprise Plus, Enterprise for Education, and Cloud Identity Premium
https://cloud.google.com/identity/docs/reference/rest/v1/devices.deviceUsers.clientStates/patch

name <string> Output only. [Resource name](https://cloud.google.com/apis/design/resource_names) of the ClientState in format: `devices/{device}/deviceUsers/{device_user}/clientState/{partner}`, where partner corresponds to the partner storing the data. For partners belonging to the \"BeyondCorp Alliance\", this is the partner ID specified to you by Google. For all other callers, this is a string of the form: `{customer}-suffix`, where `customer` is your customer ID. The *suffix* is any string the caller specifies. This string will be displayed verbatim in the administration console. This suffix is used in setting up Custom Access Levels in Context-Aware Access. Your organization's customer ID can be obtained from the URL: `GET https://www.googleapis.com/admin/directory/v1/customers/my_customer` The `id` field in the response contains the customer ID starting with the letter 'C'. The customer ID to be used in this API is the string after the letter 'C' (not including 'C')
GoogleAppsCloudidentityDevicesV1ClientState:
{:scoreReason string,
 :assetTags [string],
 :customId string,
 :healthScore
 [HEALTH_SCORE_UNSPECIFIED VERY_POOR POOR NEUTRAL GOOD VERY_GOOD],
 :name string,
 :ownerType
 [OWNER_TYPE_UNSPECIFIED OWNER_TYPE_CUSTOMER OWNER_TYPE_PARTNER],
 :createTime string,
 :etag string,
 :lastUpdateTime string,
 :managed [MANAGED_STATE_UNSPECIFIED MANAGED UNMANAGED],
 :complianceState
 [COMPLIANCE_STATE_UNSPECIFIED COMPLIANT NON_COMPLIANT],
 :keyValuePairs object}

optional:
customer <string> Optional. [Resource name](https://cloud.google.com/apis/design/resource_names) of the customer. If you're using this API for your own organization, use `customers/my_customer` If you're using this API to manage another organization, use `customers/{customer}`, where customer is the customer to whom the device belongs.
updateMask <string> Optional. Comma-separated list of fully qualified names of fields to be updated. If not specified, all updatable fields in ClientState are updated."
  ([name GoogleAppsCloudidentityDevicesV1ClientState]
    (devices-deviceUsers-clientStates-patch
      name
      GoogleAppsCloudidentityDevicesV1ClientState
      nil))
  ([name GoogleAppsCloudidentityDevicesV1ClientState optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.devices"],
       :body GoogleAppsCloudidentityDevicesV1ClientState})))

(defn groups-get
  "Retrieves a `Group`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups/get

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the `Group` to retrieve. Must be of the form `groups/{group}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.groups"
      "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn groups-patch
  "Updates a `Group`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups/patch

name <string> Output only. The [resource name](https://cloud.google.com/apis/design/resource_names) of the `Group`. Shall be of the form `groups/{group}`.
Group:
{:description string,
 :labels object,
 :parent string,
 :displayName string,
 :name string,
 :createTime string,
 :updateTime string,
 :dynamicGroupMetadata
 {:queries
  [{:resourceType [RESOURCE_TYPE_UNSPECIFIED USER], :query string}],
  :status
  {:status
   [STATUS_UNSPECIFIED UP_TO_DATE UPDATING_MEMBERSHIPS INVALID_QUERY],
   :statusTime string}},
 :groupKey {:id string, :namespace string},
 :additionalGroupKeys [{:id string, :namespace string}]}

optional:
updateMask <string> Required. The names of fields to update. May only contain the following field names: `display_name`, `description`, `labels`."
  ([name Group] (groups-patch name Group nil))
  ([name Group optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Group})))

(defn groups-updateSecuritySettings
  "Update Security Settings
https://cloud.google.com/identity/docs/reference/rest/v1/groups/updateSecuritySettings

name <string> Output only. The resource name of the security settings. Shall be of the form `groups/{group_id}/securitySettings`.
SecuritySettings:
{:name string,
 :memberRestriction
 {:query string,
  :evaluation
  {:state
   [STATE_UNSPECIFIED
    EVALUATING
    COMPLIANT
    FORWARD_COMPLIANT
    NON_COMPLIANT]}}}

optional:
updateMask <string> Required. The fully-qualified names of fields to update. May only contain the following field: `member_restriction.query`."
  ([name SecuritySettings]
    (groups-updateSecuritySettings name SecuritySettings nil))
  ([name SecuritySettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body SecuritySettings})))

(defn groups-lookup
  "Looks up the [resource name](https://cloud.google.com/apis/design/resource_names) of a `Group` by its `EntityKey`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups/lookup

optional:
groupKey.id <string> The ID of the entity. For Google-managed entities, the `id` should be the email address of an existing group or user. Email addresses need to adhere to [name guidelines for users and groups](https://support.google.com/a/answer/9193374). For external-identity-mapped entities, the `id` must be a string conforming to the Identity Source's requirements. Must be unique within a `namespace`.
groupKey.namespace <string> The namespace in which the entity exists. If not specified, the `EntityKey` represents a Google-managed entity such as a Google user or a Google Group. If specified, the `EntityKey` represents an external-identity-mapped group. The namespace must correspond to an identity source created in Admin Console and must be in the form of `identitysources/{identity_source}`."
  ([] (groups-lookup nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/groups:lookup",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-create
  "Creates a Group.
https://cloud.google.com/identity/docs/reference/rest/v1/groups/create

Group:
{:description string,
 :labels object,
 :parent string,
 :displayName string,
 :name string,
 :createTime string,
 :updateTime string,
 :dynamicGroupMetadata
 {:queries
  [{:resourceType [RESOURCE_TYPE_UNSPECIFIED USER], :query string}],
  :status
  {:status
   [STATUS_UNSPECIFIED UP_TO_DATE UPDATING_MEMBERSHIPS INVALID_QUERY],
   :statusTime string}},
 :groupKey {:id string, :namespace string},
 :additionalGroupKeys [{:id string, :namespace string}]}

optional:
initialGroupConfig <string> Optional. The initial configuration option for the `Group`."
  ([Group] (groups-create Group nil))
  ([Group optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://cloudidentity.googleapis.com/v1/groups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Group})))

(defn groups-delete
  "Deletes a `Group`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups/delete

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the `Group` to retrieve. Must be of the form `groups/{group}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.groups"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn groups-search
  "Searches for `Group` resources matching a specified query.
https://cloud.google.com/identity/docs/reference/rest/v1/groups/search

optional:
query <string> Required. The search query. * Must be specified in [Common Expression Language](https://opensource.google/projects/cel). * Must contain equality operators on the parent, e.g. `parent == 'customers/{customer_id}'`. The `customer_id` must begin with \"C\" (for example, 'C046psxkn'). [Find your customer ID.] (https://support.google.com/cloudidentity/answer/10070793) * Can contain optional inclusion operators on `labels` such as `'cloudidentity.googleapis.com/groups.discussion_forum' in labels`). * Can contain an optional equality operator on `domain_name`. e.g. `domain_name == 'examplepetstore.com'` * Can contain optional `startsWith/contains/equality` operators on `group_key`, e.g. `group_key.startsWith('dev')`, `group_key.contains('dev'), group_key == 'dev@examplepetstore.com'` * Can contain optional `startsWith/contains/equality` operators on `display_name`, such as `display_name.startsWith('dev')` , `display_name.contains('dev')`, `display_name == 'dev'`
view <string> The level of detail to be returned. If unspecified, defaults to `View.BASIC`.
pageSize <integer> The maximum number of results to return. Note that the number of results returned may be less than this value even if there are more available results. To fetch all results, clients must continue calling this method repeatedly until the response no longer contains a `next_page_token`. If unspecified, defaults to 200 for `GroupView.BASIC` and 50 for `GroupView.FULL`. Must not be greater than 1000 for `GroupView.BASIC` or 500 for `GroupView.FULL`."
  ([] (groups-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/groups:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-getSecuritySettings
  "Get Security Settings
https://cloud.google.com/identity/docs/reference/rest/v1/groups/getSecuritySettings

name <string> Required. The security settings to retrieve. Format: `groups/{group_id}/securitySettings`

optional:
readMask <string> Field-level read mask of which fields to return. \"*\" returns all fields. If not specified, all fields will be returned. May only contain the following field: `member_restriction`."
  ([name] (groups-getSecuritySettings name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-list
  "Lists the `Group` resources under a customer or namespace.
https://cloud.google.com/identity/docs/reference/rest/v1/groups/list

optional:
parent <string> Required. The parent resource under which to list all `Group` resources. Must be of the form `identitysources/{identity_source}` for external- identity-mapped groups or `customers/{customer_id}` for Google Groups. The `customer_id` must begin with \"C\" (for example, 'C046psxkn'). [Find your customer ID.] (https://support.google.com/cloudidentity/answer/10070793)
view <string> The level of detail to be returned. If unspecified, defaults to `View.BASIC`.
pageSize <integer> The maximum number of results to return. Note that the number of results returned may be less than this value even if there are more available results. To fetch all results, clients must continue calling this method repeatedly until the response no longer contains a `next_page_token`. If unspecified, defaults to 200 for `View.BASIC` and to 50 for `View.FULL`. Must not be greater than 1000 for `View.BASIC` or 500 for `View.FULL`."
  ([] (groups-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudidentity.googleapis.com/v1/groups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-memberships-searchTransitiveMemberships
  "Search transitive memberships of a group. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the group is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. A transitive membership is any direct or indirect membership of a group. Actor must have view permissions to all transitive memberships.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/searchTransitiveMemberships

parent <string> [Resource name](https://cloud.google.com/apis/design/resource_names) of the group to search transitive memberships in. Format: `groups/{group}`, where `group` is the unique ID assigned to the Group.

optional:
pageSize <integer> The default page size is 200 (max 1000)."
  ([parent]
    (groups-memberships-searchTransitiveMemberships parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/memberships:searchTransitiveMemberships",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-memberships-checkTransitiveMembership
  "Check a potential member for membership in a group. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the member is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. A member has membership to a group as long as there is a single viewable transitive membership between the group and the member. The actor must have view permissions to at least one transitive membership between the member and group.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/checkTransitiveMembership

parent <string> [Resource name](https://cloud.google.com/apis/design/resource_names) of the group to check the transitive membership in. Format: `groups/{group}`, where `group` is the unique id assigned to the Group to which the Membership belongs to.

optional:
query <string> Required. A CEL expression that MUST include member specification. This is a `required` field. Certain groups are uniquely identified by both a 'member_key_id' and a 'member_key_namespace', which requires an additional query input: 'member_key_namespace'. Example query: `member_key_id == 'member_key_id_value'`"
  ([parent] (groups-memberships-checkTransitiveMembership parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/memberships:checkTransitiveMembership",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-memberships-get
  "Retrieves a `Membership`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/get

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the `Membership` to retrieve. Must be of the form `groups/{group}/memberships/{membership}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.groups"
      "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn groups-memberships-lookup
  "Looks up the [resource name](https://cloud.google.com/apis/design/resource_names) of a `Membership` by its `EntityKey`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/lookup

parent <string> Required. The parent `Group` resource under which to lookup the `Membership` name. Must be of the form `groups/{group}`.

optional:
memberKey.id <string> The ID of the entity. For Google-managed entities, the `id` should be the email address of an existing group or user. Email addresses need to adhere to [name guidelines for users and groups](https://support.google.com/a/answer/9193374). For external-identity-mapped entities, the `id` must be a string conforming to the Identity Source's requirements. Must be unique within a `namespace`.
memberKey.namespace <string> The namespace in which the entity exists. If not specified, the `EntityKey` represents a Google-managed entity such as a Google user or a Google Group. If specified, the `EntityKey` represents an external-identity-mapped group. The namespace must correspond to an identity source created in Admin Console and must be in the form of `identitysources/{identity_source}`."
  ([parent] (groups-memberships-lookup parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/memberships:lookup",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-memberships-getMembershipGraph
  "Get a membership graph of just a member or both a member and a group. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the member is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. Given a member, the response will contain all membership paths from the member. Given both a group and a member, the response will contain all membership paths between the group and the member.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/getMembershipGraph

parent <string> Required. [Resource name](https://cloud.google.com/apis/design/resource_names) of the group to search transitive memberships in. Format: `groups/{group}`, where `group` is the unique ID assigned to the Group to which the Membership belongs to. group can be a wildcard collection id \"-\". When a group is specified, the membership graph will be constrained to paths between the member (defined in the query) and the parent. If a wildcard collection is provided, all membership paths connected to the member will be returned.

optional:
query <string> Required. A CEL expression that MUST include member specification AND label(s). Certain groups are uniquely identified by both a 'member_key_id' and a 'member_key_namespace', which requires an additional query input: 'member_key_namespace'. Example query: `member_key_id == 'member_key_id_value' && in labels`"
  ([parent] (groups-memberships-getMembershipGraph parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/memberships:getMembershipGraph",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-memberships-create
  "Creates a `Membership`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/create

parent <string> Required. The parent `Group` resource under which to create the `Membership`. Must be of the form `groups/{group}`.
Membership:
{:name string,
 :preferredMemberKey {:id string, :namespace string},
 :createTime string,
 :updateTime string,
 :roles
 [{:name string,
   :expiryDetail {:expireTime string},
   :restrictionEvaluations
   {:memberRestrictionEvaluation
    {:state
     [STATE_UNSPECIFIED
      COMPLIANT
      FORWARD_COMPLIANT
      NON_COMPLIANT
      EVALUATING]}}}],
 :type
 [TYPE_UNSPECIFIED USER SERVICE_ACCOUNT GROUP SHARED_DRIVE OTHER],
 :deliverySetting
 [DELIVERY_SETTING_UNSPECIFIED ALL_MAIL DIGEST DAILY NONE DISABLED]}"
  [parent Membership]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+parent}/memberships",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.groups"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Membership}))

(defn groups-memberships-searchTransitiveGroups
  "Search transitive groups of a member. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the member is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. A transitive group is any group that has a direct or indirect membership to the member. Actor must have view permissions all transitive groups.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/searchTransitiveGroups

parent <string> [Resource name](https://cloud.google.com/apis/design/resource_names) of the group to search transitive memberships in. Format: `groups/{group}`, where `group` is always '-' as this API will search across all groups for a given member.

optional:
query <string> Required. A CEL expression that MUST include member specification AND label(s). This is a `required` field. Users can search on label attributes of groups. CONTAINS match ('in') is supported on labels. Identity-mapped groups are uniquely identified by both a `member_key_id` and a `member_key_namespace`, which requires an additional query input: `member_key_namespace`. Example query: `member_key_id == 'member_key_id_value' && in labels` Query may optionally contain equality operators on the parent of the group restricting the search within a particular customer, e.g. `parent == 'customers/{customer_id}'`. The `customer_id` must begin with \"C\" (for example, 'C046psxkn'). This filtering is only supported for Admins with groups read permissons on the input customer. Example query: `member_key_id == 'member_key_id_value' && in labels && parent == 'customers/C046psxkn'`
pageSize <integer> The default page size is 200 (max 1000)."
  ([parent] (groups-memberships-searchTransitiveGroups parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/memberships:searchTransitiveGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-memberships-modifyMembershipRoles
  "Modifies the `MembershipRole`s of a `Membership`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/modifyMembershipRoles

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the `Membership` whose roles are to be modified. Must be of the form `groups/{group}/memberships/{membership}`.
ModifyMembershipRolesRequest:
{:addRoles
 [{:name string,
   :expiryDetail {:expireTime string},
   :restrictionEvaluations
   {:memberRestrictionEvaluation
    {:state
     [STATE_UNSPECIFIED
      COMPLIANT
      FORWARD_COMPLIANT
      NON_COMPLIANT
      EVALUATING]}}}],
 :removeRoles [string],
 :updateRolesParams
 [{:fieldMask string,
   :membershipRole
   {:name string,
    :expiryDetail {:expireTime string},
    :restrictionEvaluations
    {:memberRestrictionEvaluation
     {:state
      [STATE_UNSPECIFIED
       COMPLIANT
       FORWARD_COMPLIANT
       NON_COMPLIANT
       EVALUATING]}}}}]}"
  [name ModifyMembershipRolesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:modifyMembershipRoles",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.groups"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body ModifyMembershipRolesRequest}))

(defn groups-memberships-delete
  "Deletes a `Membership`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/delete

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the `Membership` to delete. Must be of the form `groups/{group}/memberships/{membership}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-identity.groups"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn groups-memberships-list
  "Lists the `Membership`s within a `Group`.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/list

parent <string> Required. The parent `Group` resource under which to lookup the `Membership` name. Must be of the form `groups/{group}`.

optional:
view <string> The level of detail to be returned. If unspecified, defaults to `View.BASIC`.
pageSize <integer> The maximum number of results to return. Note that the number of results returned may be less than this value even if there are more available results. To fetch all results, clients must continue calling this method repeatedly until the response no longer contains a `next_page_token`. If unspecified, defaults to 200 for `GroupView.BASIC` and to 50 for `GroupView.FULL`. Must not be greater than 1000 for `GroupView.BASIC` or 500 for `GroupView.FULL`."
  ([parent] (groups-memberships-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/memberships",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn groups-memberships-searchDirectGroups
  "Searches direct groups of a member.
https://cloud.google.com/identity/docs/reference/rest/v1/groups.memberships/searchDirectGroups

parent <string> [Resource name](https://cloud.google.com/apis/design/resource_names) of the group to search transitive memberships in. Format: groups/{group_id}, where group_id is always '-' as this API will search across all groups for a given member.

optional:
query <string> Required. A CEL expression that MUST include member specification AND label(s). Users can search on label attributes of groups. CONTAINS match ('in') is supported on labels. Identity-mapped groups are uniquely identified by both a `member_key_id` and a `member_key_namespace`, which requires an additional query input: `member_key_namespace`. Example query: `member_key_id == 'member_key_id_value' && 'label_value' in labels`
pageSize <integer> The default page size is 200 (max 1000).
orderBy <string> The ordering of membership relation for the display name or email in the response. The syntax for this field can be found at https://cloud.google.com/apis/design/design_patterns#sorting_order. Example: Sort by the ascending display name: order_by=\"group_name\" or order_by=\"group_name asc\". Sort by the descending display name: order_by=\"group_name desc\". Sort by the ascending group key: order_by=\"group_key\" or order_by=\"group_key asc\". Sort by the descending group key: order_by=\"group_key desc\"."
  ([parent] (groups-memberships-searchDirectGroups parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/memberships:searchDirectGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-identity.groups"
        "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn inboundSamlSsoProfiles-create
  "Creates an InboundSamlSsoProfile for a customer. When the target customer has enabled [Multi-party approval for sensitive actions](https://support.google.com/a/answer/13790448), the `Operation` in the response will have `\"done\": false`, it will not have a response, and the metadata will have `\"state\": \"awaiting-multi-party-approval\"`.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles/create

InboundSamlSsoProfile:
{:name string,
 :customer string,
 :displayName string,
 :idpConfig
 {:entityId string,
  :singleSignOnServiceUri string,
  :logoutRedirectUri string,
  :changePasswordUri string},
 :spConfig {:entityId string, :assertionConsumerServiceUri string}}"
  [InboundSamlSsoProfile]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/inboundSamlSsoProfiles",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InboundSamlSsoProfile}))

(defn inboundSamlSsoProfiles-patch
  "Updates an InboundSamlSsoProfile. When the target customer has enabled [Multi-party approval for sensitive actions](https://support.google.com/a/answer/13790448), the `Operation` in the response will have `\"done\": false`, it will not have a response, and the metadata will have `\"state\": \"awaiting-multi-party-approval\"`.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles/patch

name <string> Output only. [Resource name](https://cloud.google.com/apis/design/resource_names) of the SAML SSO profile.
InboundSamlSsoProfile:
{:name string,
 :customer string,
 :displayName string,
 :idpConfig
 {:entityId string,
  :singleSignOnServiceUri string,
  :logoutRedirectUri string,
  :changePasswordUri string},
 :spConfig {:entityId string, :assertionConsumerServiceUri string}}

optional:
updateMask <string> Required. The list of fields to be updated."
  ([name InboundSamlSsoProfile]
    (inboundSamlSsoProfiles-patch name InboundSamlSsoProfile nil))
  ([name InboundSamlSsoProfile optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body InboundSamlSsoProfile})))

(defn inboundSamlSsoProfiles-delete
  "Deletes an InboundSamlSsoProfile.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles/delete

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the InboundSamlSsoProfile to delete. Format: `inboundSamlSsoProfiles/{sso_profile_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn inboundSamlSsoProfiles-get
  "Gets an InboundSamlSsoProfile.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles/get

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the InboundSamlSsoProfile to get. Format: `inboundSamlSsoProfiles/{sso_profile_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn inboundSamlSsoProfiles-list
  "Lists InboundSamlSsoProfiles for a customer.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles/list

optional:
filter <string> A [Common Expression Language](https://github.com/google/cel-spec) expression to filter the results. The only supported filter is filtering by customer. For example: `customer==\"customers/C0123abc\"`. Omitting the filter or specifying a filter of `customer==\"customers/my_customer\"` will return the profiles for the customer that the caller (authenticated user) belongs to.
pageSize <integer> The maximum number of InboundSamlSsoProfiles to return. The service may return fewer than this value. If omitted (or defaulted to zero) the server will use a sensible default. This default may change over time. The maximum allowed value is 100. Requests with page_size greater than that will be silently interpreted as having this maximum value."
  ([] (inboundSamlSsoProfiles-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/inboundSamlSsoProfiles",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn inboundSamlSsoProfiles-idpCredentials-delete
  "Deletes an IdpCredential.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles.idpCredentials/delete

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the IdpCredential to delete. Format: `inboundSamlSsoProfiles/{sso_profile_id}/idpCredentials/{idp_credential_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn inboundSamlSsoProfiles-idpCredentials-get
  "Gets an IdpCredential.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles.idpCredentials/get

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the IdpCredential to retrieve. Format: `inboundSamlSsoProfiles/{sso_profile_id}/idpCredentials/{idp_credential_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn inboundSamlSsoProfiles-idpCredentials-list
  "Returns a list of IdpCredentials in an InboundSamlSsoProfile.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles.idpCredentials/list

parent <string> Required. The parent, which owns this collection of `IdpCredential`s. Format: `inboundSamlSsoProfiles/{sso_profile_id}`

optional:
pageSize <integer> The maximum number of `IdpCredential`s to return. The service may return fewer than this value."
  ([parent] (inboundSamlSsoProfiles-idpCredentials-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/idpCredentials",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn inboundSamlSsoProfiles-idpCredentials-add
  "Adds an IdpCredential. Up to 2 credentials are allowed. When the target customer has enabled [Multi-party approval for sensitive actions](https://support.google.com/a/answer/13790448), the `Operation` in the response will have `\"done\": false`, it will not have a response, and the metadata will have `\"state\": \"awaiting-multi-party-approval\"`.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles.idpCredentials/add

parent <string> Required. The InboundSamlSsoProfile that owns the IdpCredential. Format: `inboundSamlSsoProfiles/{sso_profile_id}`
AddIdpCredentialRequest:
{:pemData string}"
  [parent AddIdpCredentialRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+parent}/idpCredentials:add",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AddIdpCredentialRequest}))

(defn inboundSsoAssignments-get
  "Gets an InboundSsoAssignment.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSsoAssignments/get

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the InboundSsoAssignment to fetch. Format: `inboundSsoAssignments/{assignment}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn inboundSsoAssignments-create
  "Creates an InboundSsoAssignment for users and devices in a `Customer` under a given `Group` or `OrgUnit`.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSsoAssignments/create

InboundSsoAssignment:
{:targetGroup string,
 :targetOrgUnit string,
 :name string,
 :customer string,
 :rank integer,
 :ssoMode
 [SSO_MODE_UNSPECIFIED SSO_OFF SAML_SSO DOMAIN_WIDE_SAML_IF_ENABLED],
 :samlSsoInfo {:inboundSamlSsoProfile string},
 :signInBehavior
 {:redirectCondition [REDIRECT_CONDITION_UNSPECIFIED NEVER]}}"
  [InboundSsoAssignment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/inboundSsoAssignments",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InboundSsoAssignment}))

(defn inboundSsoAssignments-patch
  "Updates an InboundSsoAssignment. The body of this request is the `inbound_sso_assignment` field and the `update_mask` is relative to that. For example: a PATCH to `/v1/inboundSsoAssignments/0abcdefg1234567&update_mask=rank` with a body of `{ \"rank\": 1 }` moves that (presumably group-targeted) SSO assignment to the highest priority and shifts any other group-targeted assignments down in priority.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSsoAssignments/patch

name <string> Output only. [Resource name](https://cloud.google.com/apis/design/resource_names) of the Inbound SSO Assignment.
InboundSsoAssignment:
{:targetGroup string,
 :targetOrgUnit string,
 :name string,
 :customer string,
 :rank integer,
 :ssoMode
 [SSO_MODE_UNSPECIFIED SSO_OFF SAML_SSO DOMAIN_WIDE_SAML_IF_ENABLED],
 :samlSsoInfo {:inboundSamlSsoProfile string},
 :signInBehavior
 {:redirectCondition [REDIRECT_CONDITION_UNSPECIFIED NEVER]}}

optional:
updateMask <string> Required. The list of fields to be updated."
  ([name InboundSsoAssignment]
    (inboundSsoAssignments-patch name InboundSsoAssignment nil))
  ([name InboundSsoAssignment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body InboundSsoAssignment})))

(defn inboundSsoAssignments-delete
  "Deletes an InboundSsoAssignment. To disable SSO, Create (or Update) an assignment that has `sso_mode` == `SSO_OFF`.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSsoAssignments/delete

name <string> Required. The [resource name](https://cloud.google.com/apis/design/resource_names) of the InboundSsoAssignment to delete. Format: `inboundSsoAssignments/{assignment}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn inboundSsoAssignments-list
  "Lists the InboundSsoAssignments for a `Customer`.
https://cloud.google.com/identity/docs/reference/rest/v1/inboundSsoAssignments/list

optional:
filter <string> A CEL expression to filter the results. The only supported filter is filtering by customer. For example: `customer==customers/C0123abc`. Omitting the filter or specifying a filter of `customer==customers/my_customer` will return the assignments for the customer that the caller (authenticated user) belongs to.
pageSize <integer> The maximum number of assignments to return. The service may return fewer than this value. If omitted (or defaulted to zero) the server will use a sensible default. This default may change over time. The maximum allowed value is 100, though requests with page_size greater than that will be silently interpreted as having this maximum value. This may increase in the futue."
  ([] (inboundSsoAssignments-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/inboundSsoAssignments",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn customers-userinvitations-get
  "Retrieves a UserInvitation resource. **Note:** New consumer accounts with the customer's verified domain created within the previous 48 hours will not appear in the result. This delay also applies to newly-verified domains.
https://cloud.google.com/identity/docs/reference/rest/v1/customers.userinvitations/get

name <string> Required. `UserInvitation` name in the format `customers/{customer}/userinvitations/{user_email_address}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudidentity.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn customers-userinvitations-list
  "Retrieves a list of UserInvitation resources. **Note:** New consumer accounts with the customer's verified domain created within the previous 48 hours will not appear in the result. This delay also applies to newly-verified domains.
https://cloud.google.com/identity/docs/reference/rest/v1/customers.userinvitations/list

parent <string> Required. The customer ID of the Google Workspace or Cloud Identity account the UserInvitation resources are associated with.

optional:
pageSize <integer> Optional. The maximum number of UserInvitation resources to return. If unspecified, at most 100 resources will be returned. The maximum value is 200; values above 200 will be set to 200.
filter <string> Optional. A query string for filtering `UserInvitation` results by their current state, in the format: `\"state=='invited'\"`.
orderBy <string> Optional. The sort order of the list results. You can sort the results in descending order based on either email or last update timestamp but not both, using `order_by=\"email desc\"`. Currently, sorting is supported for `update_time asc`, `update_time desc`, `email asc`, and `email desc`. If not specified, results will be returned based on `email asc` order."
  ([parent] (customers-userinvitations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudidentity.googleapis.com/v1/{+parent}/userinvitations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn customers-userinvitations-send
  "Sends a UserInvitation to email. If the `UserInvitation` does not exist for this request and it is a valid request, the request creates a `UserInvitation`. **Note:** The `get` and `list` methods have a 48-hour delay where newly-created consumer accounts will not appear in the results. You can still send a `UserInvitation` to those accounts if you know the unmanaged email address and IsInvitableUser==True.
https://cloud.google.com/identity/docs/reference/rest/v1/customers.userinvitations/send

name <string> Required. `UserInvitation` name in the format `customers/{customer}/userinvitations/{user_email_address}`
SendUserInvitationRequest:
object"
  [name SendUserInvitationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:send",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil,
     :body SendUserInvitationRequest}))

(defn customers-userinvitations-cancel
  "Cancels a UserInvitation that was already sent.
https://cloud.google.com/identity/docs/reference/rest/v1/customers.userinvitations/cancel

name <string> Required. `UserInvitation` name in the format `customers/{customer}/userinvitations/{user_email_address}`
CancelUserInvitationRequest:
object"
  [name CancelUserInvitationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil,
     :body CancelUserInvitationRequest}))

(defn customers-userinvitations-isInvitableUser
  "Verifies whether a user account is eligible to receive a UserInvitation (is an unmanaged account). Eligibility is based on the following criteria: * the email address is a consumer account and it's the primary email address of the account, and * the domain of the email address matches an existing verified Google Workspace or Cloud Identity domain If both conditions are met, the user is eligible. **Note:** This method is not supported for Workspace Essentials customers.
https://cloud.google.com/identity/docs/reference/rest/v1/customers.userinvitations/isInvitableUser

name <string> Required. `UserInvitation` name in the format `customers/{customer}/userinvitations/{user_email_address}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudidentity.googleapis.com/v1/{+name}:isInvitableUser",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

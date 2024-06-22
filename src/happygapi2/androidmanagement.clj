(ns happygapi2.androidmanagement
  "Android Management API
The Android Management API provides remote enterprise management of Android devices and apps.
See: https://developers.google.com/android/management"
  (:require [happy.oauth2.client :as client]))

(defn signupUrls-create
  "Creates an enterprise signup URL.
https://developers.google.com/android/management/reference/rest/v1/signupUrls/create

optional:
projectId <string> The ID of the Google Cloud Platform project which will own the enterprise.
callbackUrl <string> The callback URL that the admin will be redirected to after successfully creating an enterprise. Before redirecting there the system will add a query parameter to this URL named enterpriseToken which will contain an opaque token to be used for the create enterprise request. The URL will be parsed then reformatted in order to add the enterpriseToken parameter, so there may be some minor formatting changes.
adminEmail <string> Optional. Email address used to prefill the admin field of the enterprise signup form. This value is a hint only and can be altered by the user."
  ([] (signupUrls-create nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/signupUrls",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-create
  "Creates an enterprise. This is the last step in the enterprise signup flow. See also: SigninDetail
https://developers.google.com/android/management/reference/rest/v1/enterprises/create

Enterprise:
{:contactInfo
 {:contactEmail string,
  :dataProtectionOfficerName string,
  :dataProtectionOfficerEmail string,
  :dataProtectionOfficerPhone string,
  :euRepresentativeName string,
  :euRepresentativeEmail string,
  :euRepresentativePhone string},
 :enabledNotificationTypes
 [[NOTIFICATION_TYPE_UNSPECIFIED
   ENROLLMENT
   COMPLIANCE_REPORT
   STATUS_REPORT
   COMMAND
   USAGE_LOGS]],
 :enterpriseDisplayName string,
 :logo {:url string, :sha256Hash string},
 :name string,
 :pubsubTopic string,
 :primaryColor integer,
 :termsAndConditions
 [{:header {:localizedMessages object, :defaultMessage string},
   :content {:localizedMessages object, :defaultMessage string}}],
 :appAutoApprovalEnabled boolean,
 :googleAuthenticationSettings
 {:googleAuthenticationRequired
  [GOOGLE_AUTHENTICATION_REQUIRED_UNSPECIFIED NOT_REQUIRED REQUIRED]},
 :signinDetails
 [{:signinUrl string,
   :signinEnrollmentToken string,
   :qrCode string,
   :allowPersonalUsage
   [ALLOW_PERSONAL_USAGE_UNSPECIFIED
    PERSONAL_USAGE_ALLOWED
    PERSONAL_USAGE_DISALLOWED
    PERSONAL_USAGE_DISALLOWED_USERLESS],
   :tokenTag string}]}

optional:
projectId <string> The ID of the Google Cloud Platform project which will own the enterprise.
signupUrlName <string> The name of the SignupUrl used to sign up for the enterprise. Set this when creating a customer-managed enterprise (https://developers.google.com/android/management/create-enterprise#customer-managed_enterprises) and not when creating a deprecated EMM-managed enterprise (https://developers.google.com/android/management/create-enterprise#emm-managed_enterprises).
enterpriseToken <string> The enterprise token appended to the callback URL. Set this when creating a customer-managed enterprise (https://developers.google.com/android/management/create-enterprise#customer-managed_enterprises) and not when creating a deprecated EMM-managed enterprise (https://developers.google.com/android/management/create-enterprise#emm-managed_enterprises).
agreementAccepted <boolean> Whether the enterprise admin has seen and agreed to the managed Google Play Agreement (https://www.android.com/enterprise/terms/). Do not set this field for any customer-managed enterprise (https://developers.google.com/android/management/create-enterprise#customer-managed_enterprises). Set this to field to true for all EMM-managed enterprises (https://developers.google.com/android/management/create-enterprise#emm-managed_enterprises)."
  ([Enterprise] (enterprises-create Enterprise nil))
  ([Enterprise optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/enterprises",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"],
       :body Enterprise})))

(defn enterprises-delete
  "Permanently deletes an enterprise and all accounts and data associated with it. Warning: this will result in a cascaded deletion of all AM API devices associated with the deleted enterprise. Only available for EMM-managed enterprises.
https://developers.google.com/android/management/reference/rest/v1/enterprises/delete

name <string> The name of the enterprise in the form enterprises/{enterpriseId}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-get
  "Gets an enterprise.
https://developers.google.com/android/management/reference/rest/v1/enterprises/get

name <string> The name of the enterprise in the form enterprises/{enterpriseId}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-patch
  "Updates an enterprise. See also: SigninDetail
https://developers.google.com/android/management/reference/rest/v1/enterprises/patch

name <string> The name of the enterprise in the form enterprises/{enterpriseId}.
Enterprise:
{:contactInfo
 {:contactEmail string,
  :dataProtectionOfficerName string,
  :dataProtectionOfficerEmail string,
  :dataProtectionOfficerPhone string,
  :euRepresentativeName string,
  :euRepresentativeEmail string,
  :euRepresentativePhone string},
 :enabledNotificationTypes
 [[NOTIFICATION_TYPE_UNSPECIFIED
   ENROLLMENT
   COMPLIANCE_REPORT
   STATUS_REPORT
   COMMAND
   USAGE_LOGS]],
 :enterpriseDisplayName string,
 :logo {:url string, :sha256Hash string},
 :name string,
 :pubsubTopic string,
 :primaryColor integer,
 :termsAndConditions
 [{:header {:localizedMessages object, :defaultMessage string},
   :content {:localizedMessages object, :defaultMessage string}}],
 :appAutoApprovalEnabled boolean,
 :googleAuthenticationSettings
 {:googleAuthenticationRequired
  [GOOGLE_AUTHENTICATION_REQUIRED_UNSPECIFIED NOT_REQUIRED REQUIRED]},
 :signinDetails
 [{:signinUrl string,
   :signinEnrollmentToken string,
   :qrCode string,
   :allowPersonalUsage
   [ALLOW_PERSONAL_USAGE_UNSPECIFIED
    PERSONAL_USAGE_ALLOWED
    PERSONAL_USAGE_DISALLOWED
    PERSONAL_USAGE_DISALLOWED_USERLESS],
   :tokenTag string}]}

optional:
updateMask <string> The field mask indicating the fields to update. If not set, all modifiable fields will be modified."
  ([name Enterprise] (enterprises-patch name Enterprise nil))
  ([name Enterprise optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"],
       :body Enterprise})))

(defn enterprises-list
  "Lists EMM-managed enterprises. Only BASIC fields are returned.
https://developers.google.com/android/management/reference/rest/v1/enterprises/list

optional:
projectId <string> Required. The Cloud project ID of the EMM managing the enterprises.
pageSize <integer> The requested page size. The actual page size may be fixed to a min or max value.
view <string> Specifies which Enterprise fields to return. This method only supports BASIC."
  ([] (enterprises-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/enterprises",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-enrollmentTokens-create
  "Creates an enrollment token for a given enterprise. It's up to the caller's responsibility to manage the lifecycle of newly created tokens and deleting them when they're not intended to be used anymore. Once an enrollment token has been created, it's not possible to retrieve the token's content anymore using AM API. It is recommended for EMMs to securely store the token if it's intended to be reused.
https://developers.google.com/android/management/reference/rest/v1/enterprises/enrollmentTokens/create

parent <string> The name of the enterprise in the form enterprises/{enterpriseId}.
EnrollmentToken:
{:expirationTimestamp string,
 :oneTimeOnly boolean,
 :additionalData string,
 :name string,
 :value string,
 :duration string,
 :qrCode string,
 :user {:accountIdentifier string},
 :policyName string,
 :allowPersonalUsage
 [ALLOW_PERSONAL_USAGE_UNSPECIFIED
  PERSONAL_USAGE_ALLOWED
  PERSONAL_USAGE_DISALLOWED
  PERSONAL_USAGE_DISALLOWED_USERLESS]}"
  [parent EnrollmentToken]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+parent}/enrollmentTokens",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"],
     :body EnrollmentToken}))

(defn enterprises-enrollmentTokens-delete
  "Deletes an enrollment token. This operation invalidates the token, preventing its future use.
https://developers.google.com/android/management/reference/rest/v1/enterprises/enrollmentTokens/delete

name <string> The name of the enrollment token in the form enterprises/{enterpriseId}/enrollmentTokens/{enrollmentTokenId}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-enrollmentTokens-get
  "Gets an active, unexpired enrollment token. A partial view of the enrollment token is returned. Only the following fields are populated: name, expirationTimestamp, allowPersonalUsage, value, qrCode. This method is meant to help manage active enrollment tokens lifecycle. For security reasons, it's recommended to delete active enrollment tokens as soon as they're not intended to be used anymore.
https://developers.google.com/android/management/reference/rest/v1/enterprises/enrollmentTokens/get

name <string> Required. The name of the enrollment token in the form enterprises/{enterpriseId}/enrollmentTokens/{enrollmentTokenId}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-enrollmentTokens-list
  "Lists active, unexpired enrollment tokens for a given enterprise. The list items contain only a partial view of EnrollmentToken object. Only the following fields are populated: name, expirationTimestamp, allowPersonalUsage, value, qrCode. This method is meant to help manage active enrollment tokens lifecycle. For security reasons, it's recommended to delete active enrollment tokens as soon as they're not intended to be used anymore.
https://developers.google.com/android/management/reference/rest/v1/enterprises/enrollmentTokens/list

parent <string> Required. The name of the enterprise in the form enterprises/{enterpriseId}.

optional:
pageSize <integer> The requested page size. The service may return fewer than this value. If unspecified, at most 10 items will be returned. The maximum value is 100; values above 100 will be coerced to 100."
  ([parent] (enterprises-enrollmentTokens-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+parent}/enrollmentTokens",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-webTokens-create
  "Creates a web token to access an embeddable managed Google Play web UI for a given enterprise.
https://developers.google.com/android/management/reference/rest/v1/enterprises/webTokens/create

parent <string> The name of the enterprise in the form enterprises/{enterpriseId}.
WebToken:
{:name string,
 :value string,
 :permissions [[WEB_TOKEN_PERMISSION_UNSPECIFIED APPROVE_APPS]],
 :parentFrameUrl string,
 :enabledFeatures
 [[FEATURE_UNSPECIFIED
   PLAY_SEARCH
   PRIVATE_APPS
   WEB_APPS
   STORE_BUILDER
   MANAGED_CONFIGURATIONS
   ZERO_TOUCH_CUSTOMER_MANAGEMENT]]}"
  [parent WebToken]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+parent}/webTokens",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"],
     :body WebToken}))

(defn enterprises-devices-get
  "Gets a device. Deleted devices will respond with a 404 error.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/get

name <string> The name of the device in the form enterprises/{enterpriseId}/devices/{deviceId}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-devices-list
  "Lists devices for a given enterprise. Deleted devices are not returned in the response.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/list

parent <string> The name of the enterprise in the form enterprises/{enterpriseId}.

optional:
pageSize <integer> The requested page size. The actual page size may be fixed to a min or max value."
  ([parent] (enterprises-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-devices-patch
  "Updates a device.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/patch

name <string> The name of the device in the form enterprises/{enterpriseId}/devices/{deviceId}.
Device:
{:dpcMigrationInfo {:previousDpc string, :additionalData string},
 :previousDeviceNames [string],
 :appliedState
 [DEVICE_STATE_UNSPECIFIED
  ACTIVE
  DISABLED
  DELETED
  PROVISIONING
  LOST
  PREPARING_FOR_MIGRATION
  DEACTIVATED_BY_DEVICE_FINANCE],
 :memoryInfo {:totalRam string, :totalInternalStorage string},
 :networkInfo
 {:imei string,
  :meid string,
  :wifiMacAddress string,
  :networkOperatorName string,
  :telephonyInfos [{:phoneNumber string, :carrierName string}]},
 :softwareInfo
 {:systemUpdateInfo
  {:updateStatus
   [UPDATE_STATUS_UNKNOWN
    UP_TO_DATE
    UNKNOWN_UPDATE_AVAILABLE
    SECURITY_UPDATE_AVAILABLE
    OS_UPDATE_AVAILABLE],
   :updateReceivedTime string},
  :deviceKernelVersion string,
  :androidBuildNumber string,
  :androidDevicePolicyVersionName string,
  :securityPatchLevel string,
  :bootloaderVersion string,
  :androidVersion string,
  :deviceBuildSignature string,
  :androidBuildTime string,
  :androidDevicePolicyVersionCode integer,
  :primaryLanguageCode string},
 :policyCompliant boolean,
 :name string,
 :lastStatusReportTime string,
 :systemProperties object,
 :state
 [DEVICE_STATE_UNSPECIFIED
  ACTIVE
  DISABLED
  DELETED
  PROVISIONING
  LOST
  PREPARING_FOR_MIGRATION
  DEACTIVATED_BY_DEVICE_FINANCE],
 :apiLevel integer,
 :enrollmentTokenName string,
 :memoryEvents
 [{:eventType
   [MEMORY_EVENT_TYPE_UNSPECIFIED
    RAM_MEASURED
    INTERNAL_STORAGE_MEASURED
    EXTERNAL_STORAGE_DETECTED
    EXTERNAL_STORAGE_REMOVED
    EXTERNAL_STORAGE_MEASURED],
   :createTime string,
   :byteCount string}],
 :appliedPasswordPolicies
 [{:requirePasswordUnlock
   [REQUIRE_PASSWORD_UNLOCK_UNSPECIFIED
    USE_DEFAULT_DEVICE_TIMEOUT
    REQUIRE_EVERY_DAY],
   :unifiedLockSettings
   [UNIFIED_LOCK_SETTINGS_UNSPECIFIED
    ALLOW_UNIFIED_WORK_AND_PERSONAL_LOCK
    REQUIRE_SEPARATE_WORK_LOCK],
   :passwordScope [SCOPE_UNSPECIFIED SCOPE_DEVICE SCOPE_PROFILE],
   :passwordQuality
   [PASSWORD_QUALITY_UNSPECIFIED
    BIOMETRIC_WEAK
    SOMETHING
    NUMERIC
    NUMERIC_COMPLEX
    ALPHABETIC
    ALPHANUMERIC
    COMPLEX
    COMPLEXITY_LOW
    COMPLEXITY_MEDIUM
    COMPLEXITY_HIGH],
   :passwordMinimumNumeric integer,
   :passwordMinimumSymbols integer,
   :passwordMinimumUpperCase integer,
   :maximumFailedPasswordsForWipe integer,
   :passwordMinimumLength integer,
   :passwordMinimumNonLetter integer,
   :passwordExpirationTimeout string,
   :passwordHistoryLength integer,
   :passwordMinimumLetters integer,
   :passwordMinimumLowerCase integer}],
 :commonCriteriaModeInfo
 {:commonCriteriaModeStatus
  [COMMON_CRITERIA_MODE_STATUS_UNKNOWN
   COMMON_CRITERIA_MODE_DISABLED
   COMMON_CRITERIA_MODE_ENABLED]},
 :hardwareStatusSamples
 [{:createTime string,
   :batteryTemperatures [number],
   :cpuTemperatures [number],
   :gpuTemperatures [number],
   :skinTemperatures [number],
   :fanSpeeds [number],
   :cpuUsages [number]}],
 :enrollmentTokenData string,
 :enrollmentTime string,
 :managementMode
 [MANAGEMENT_MODE_UNSPECIFIED DEVICE_OWNER PROFILE_OWNER],
 :lastPolicyComplianceReportTime string,
 :ownership [OWNERSHIP_UNSPECIFIED COMPANY_OWNED PERSONALLY_OWNED],
 :appliedPolicyName string,
 :securityPosture
 {:devicePosture
  [POSTURE_UNSPECIFIED SECURE AT_RISK POTENTIALLY_COMPROMISED],
  :postureDetails
  [{:securityRisk
    [SECURITY_RISK_UNSPECIFIED
     UNKNOWN_OS
     COMPROMISED_OS
     HARDWARE_BACKED_EVALUATION_FAILED],
    :advice [{:localizedMessages object, :defaultMessage string}]}]},
 :powerManagementEvents
 [{:eventType
   [POWER_MANAGEMENT_EVENT_TYPE_UNSPECIFIED
    BATTERY_LEVEL_COLLECTED
    POWER_CONNECTED
    POWER_DISCONNECTED
    BATTERY_LOW
    BATTERY_OKAY
    BOOT_COMPLETED
    SHUTDOWN],
   :createTime string,
   :batteryLevel number}],
 :lastPolicySyncTime string,
 :deviceSettings
 {:isDeviceSecure boolean,
  :unknownSourcesEnabled boolean,
  :developmentSettingsEnabled boolean,
  :adbEnabled boolean,
  :isEncrypted boolean,
  :encryptionStatus
  [ENCRYPTION_STATUS_UNSPECIFIED
   UNSUPPORTED
   INACTIVE
   ACTIVATING
   ACTIVE
   ACTIVE_DEFAULT_KEY
   ACTIVE_PER_USER],
  :verifyAppsEnabled boolean},
 :hardwareInfo
 {:serialNumber string,
  :enterpriseSpecificId string,
  :skinShutdownTemperatures [number],
  :batteryThrottlingTemperatures [number],
  :hardware string,
  :brand string,
  :deviceBasebandVersion string,
  :gpuShutdownTemperatures [number],
  :manufacturer string,
  :skinThrottlingTemperatures [number],
  :batteryShutdownTemperatures [number],
  :cpuShutdownTemperatures [number],
  :gpuThrottlingTemperatures [number],
  :model string,
  :cpuThrottlingTemperatures [number]},
 :user {:accountIdentifier string},
 :displays
 [{:name string,
   :displayId integer,
   :refreshRate integer,
   :state [DISPLAY_STATE_UNSPECIFIED OFF ON DOZE SUSPENDED],
   :width integer,
   :height integer,
   :density integer}],
 :disabledReason {:localizedMessages object, :defaultMessage string},
 :userName string,
 :policyName string,
 :appliedPolicyVersion string,
 :nonComplianceDetails
 [{:settingName string,
   :nonComplianceReason
   [NON_COMPLIANCE_REASON_UNSPECIFIED
    API_LEVEL
    MANAGEMENT_MODE
    USER_ACTION
    INVALID_VALUE
    APP_NOT_INSTALLED
    UNSUPPORTED
    APP_INSTALLED
    PENDING
    APP_INCOMPATIBLE
    APP_NOT_UPDATED
    DEVICE_INCOMPATIBLE],
   :packageName string,
   :fieldPath string,
   :currentValue any,
   :installationFailureReason
   [INSTALLATION_FAILURE_REASON_UNSPECIFIED
    INSTALLATION_FAILURE_REASON_UNKNOWN
    IN_PROGRESS
    NOT_FOUND
    NOT_COMPATIBLE_WITH_DEVICE
    NOT_APPROVED
    PERMISSIONS_NOT_ACCEPTED
    NOT_AVAILABLE_IN_COUNTRY
    NO_LICENSES_REMAINING
    NOT_ENROLLED
    USER_INVALID
    NETWORK_ERROR_UNRELIABLE_CONNECTION
    INSUFFICIENT_STORAGE],
   :specificNonComplianceReason
   [SPECIFIC_NON_COMPLIANCE_REASON_UNSPECIFIED
    PASSWORD_POLICIES_USER_CREDENTIALS_CONFIRMATION_REQUIRED
    PASSWORD_POLICIES_PASSWORD_EXPIRED
    PASSWORD_POLICIES_PASSWORD_NOT_SUFFICIENT
    ONC_WIFI_INVALID_VALUE
    ONC_WIFI_API_LEVEL
    ONC_WIFI_INVALID_ENTERPRISE_CONFIG
    ONC_WIFI_USER_SHOULD_REMOVE_NETWORK
    ONC_WIFI_KEY_PAIR_ALIAS_NOT_CORRESPONDING_TO_EXISTING_KEY],
   :specificNonComplianceContext
   {:oncWifiContext {:wifiGuid string},
    :passwordPoliciesContext
    {:passwordPolicyScope
     [SCOPE_UNSPECIFIED SCOPE_DEVICE SCOPE_PROFILE]}}}],
 :applicationReports
 [{:packageName string,
   :packageSha256Hash string,
   :displayName string,
   :events
   [{:eventType
     [APPLICATION_EVENT_TYPE_UNSPECIFIED
      INSTALLED
      CHANGED
      DATA_CLEARED
      REMOVED
      REPLACED
      RESTARTED
      PINNED
      UNPINNED],
     :createTime string}],
   :installerPackageName string,
   :state [APPLICATION_STATE_UNSPECIFIED REMOVED INSTALLED],
   :userFacingType
   [USER_FACING_TYPE_UNSPECIFIED NOT_USER_FACING USER_FACING],
   :versionName string,
   :versionCode integer,
   :keyedAppStates
   [{:key string,
     :severity [SEVERITY_UNSPECIFIED INFO ERROR],
     :message string,
     :data string,
     :createTime string,
     :lastUpdateTime string}],
   :applicationSource
   [APPLICATION_SOURCE_UNSPECIFIED
    SYSTEM_APP_FACTORY_VERSION
    SYSTEM_APP_UPDATED_VERSION
    INSTALLED_FROM_PLAY_STORE],
   :signingKeyCertFingerprints [string]}]}

optional:
updateMask <string> The field mask indicating the fields to update. If not set, all modifiable fields will be modified."
  ([name Device] (enterprises-devices-patch name Device nil))
  ([name Device optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"],
       :body Device})))

(defn enterprises-devices-delete
  "Deletes a device. This operation wipes the device. Deleted devices do not show up in enterprises.devices.list calls and a 404 is returned from enterprises.devices.get.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/delete

name <string> The name of the device in the form enterprises/{enterpriseId}/devices/{deviceId}.

optional:
wipeDataFlags <string> Optional flags that control the device wiping behavior.
wipeReasonMessage <string> Optional. A short message displayed to the user before wiping the work profile on personal devices. This has no effect on company owned devices. The maximum message length is 200 characters."
  ([name] (enterprises-devices-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-devices-issueCommand
  "Issues a command to a device. The Operation resource returned contains a Command in its metadata field. Use the get operation method to get the status of the command.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/issueCommand

name <string> The name of the device in the form enterprises/{enterpriseId}/devices/{deviceId}.
Command:
{:startLostModeStatus
 {:status
  [STATUS_UNSPECIFIED
   SUCCESS
   RESET_PASSWORD_RECENTLY
   USER_EXIT_LOST_MODE_RECENTLY
   ALREADY_IN_LOST_MODE]},
 :errorCode
 [COMMAND_ERROR_CODE_UNSPECIFIED
  UNKNOWN
  API_LEVEL
  MANAGEMENT_MODE
  INVALID_VALUE
  UNSUPPORTED],
 :stopLostModeParams object,
 :createTime string,
 :type
 [COMMAND_TYPE_UNSPECIFIED
  LOCK
  RESET_PASSWORD
  REBOOT
  RELINQUISH_OWNERSHIP
  CLEAR_APP_DATA
  START_LOST_MODE
  STOP_LOST_MODE],
 :stopLostModeStatus
 {:status [STATUS_UNSPECIFIED SUCCESS NOT_IN_LOST_MODE]},
 :duration string,
 :resetPasswordFlags
 [[RESET_PASSWORD_FLAG_UNSPECIFIED
   REQUIRE_ENTRY
   DO_NOT_ASK_CREDENTIALS_ON_BOOT
   LOCK_NOW]],
 :clearAppsDataParams {:packageNames [string]},
 :clearAppsDataStatus {:results object},
 :newPassword string,
 :userName string,
 :startLostModeParams
 {:lostMessage {:localizedMessages object, :defaultMessage string},
  :lostPhoneNumber {:localizedMessages object, :defaultMessage string},
  :lostEmailAddress string,
  :lostStreetAddress
  {:localizedMessages object, :defaultMessage string},
  :lostOrganization
  {:localizedMessages object, :defaultMessage string}}}"
  [name Command]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}:issueCommand",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"],
     :body Command}))

(defn enterprises-devices-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (enterprises-devices-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-devices-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-devices-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED.
https://developers.google.com/android/management/reference/rest/v1/enterprises/devices/operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-policies-get
  "Gets a policy.
https://developers.google.com/android/management/reference/rest/v1/enterprises/policies/get

name <string> The name of the policy in the form enterprises/{enterpriseId}/policies/{policyId}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-policies-list
  "Lists policies for a given enterprise.
https://developers.google.com/android/management/reference/rest/v1/enterprises/policies/list

parent <string> The name of the enterprise in the form enterprises/{enterpriseId}.

optional:
pageSize <integer> The requested page size. The actual page size may be fixed to a min or max value."
  ([parent] (enterprises-policies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+parent}/policies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-policies-patch
  "Updates or creates a policy.
https://developers.google.com/android/management/reference/rest/v1/enterprises/policies/patch

name <string> The name of the policy in the form enterprises/{enterpriseId}/policies/{policyId}.
Policy:
{:outgoingBeamDisabled boolean,
 :openNetworkConfiguration object,
 :debuggingFeaturesAllowed boolean,
 :kioskCustomLauncherEnabled boolean,
 :kioskCustomization
 {:powerButtonActions
  [POWER_BUTTON_ACTIONS_UNSPECIFIED
   POWER_BUTTON_AVAILABLE
   POWER_BUTTON_BLOCKED],
  :systemErrorWarnings
  [SYSTEM_ERROR_WARNINGS_UNSPECIFIED
   ERROR_AND_WARNINGS_ENABLED
   ERROR_AND_WARNINGS_MUTED],
  :systemNavigation
  [SYSTEM_NAVIGATION_UNSPECIFIED
   NAVIGATION_ENABLED
   NAVIGATION_DISABLED
   HOME_BUTTON_ONLY],
  :statusBar
  [STATUS_BAR_UNSPECIFIED
   NOTIFICATIONS_AND_SYSTEM_INFO_ENABLED
   NOTIFICATIONS_AND_SYSTEM_INFO_DISABLED
   SYSTEM_INFO_ONLY],
  :deviceSettings
  [DEVICE_SETTINGS_UNSPECIFIED
   SETTINGS_ACCESS_ALLOWED
   SETTINGS_ACCESS_BLOCKED]},
 :wifiConfigDisabled boolean,
 :skipFirstUseHintsEnabled boolean,
 :statusBarDisabled boolean,
 :recommendedGlobalProxy
 {:host string,
  :port integer,
  :excludedHosts [string],
  :pacUri string},
 :cameraAccess
 [CAMERA_ACCESS_UNSPECIFIED
  CAMERA_ACCESS_USER_CHOICE
  CAMERA_ACCESS_DISABLED
  CAMERA_ACCESS_ENFORCED],
 :blockApplicationsEnabled boolean,
 :alwaysOnVpnPackage {:packageName string, :lockdownEnabled boolean},
 :bluetoothConfigDisabled boolean,
 :applications
 [{:installType
   [INSTALL_TYPE_UNSPECIFIED
    PREINSTALLED
    FORCE_INSTALLED
    BLOCKED
    AVAILABLE
    REQUIRED_FOR_SETUP
    KIOSK],
   :packageName string,
   :userControlSettings
   [USER_CONTROL_SETTINGS_UNSPECIFIED
    USER_CONTROL_ALLOWED
    USER_CONTROL_DISALLOWED],
   :managedConfiguration object,
   :credentialProviderPolicy
   [CREDENTIAL_PROVIDER_POLICY_UNSPECIFIED
    CREDENTIAL_PROVIDER_ALLOWED],
   :disabled boolean,
   :managedConfigurationTemplate
   {:templateId string, :configurationVariables object},
   :lockTaskAllowed boolean,
   :installConstraint
   [{:networkTypeConstraint
     [NETWORK_TYPE_CONSTRAINT_UNSPECIFIED
      INSTALL_ON_ANY_NETWORK
      INSTALL_ONLY_ON_UNMETERED_NETWORK],
     :chargingConstraint
     [CHARGING_CONSTRAINT_UNSPECIFIED
      CHARGING_NOT_REQUIRED
      INSTALL_ONLY_WHEN_CHARGING],
     :deviceIdleConstraint
     [DEVICE_IDLE_CONSTRAINT_UNSPECIFIED
      DEVICE_IDLE_NOT_REQUIRED
      INSTALL_ONLY_WHEN_DEVICE_IDLE]}],
   :delegatedScopes
   [[DELEGATED_SCOPE_UNSPECIFIED
     CERT_INSTALL
     MANAGED_CONFIGURATIONS
     BLOCK_UNINSTALL
     PERMISSION_GRANT
     PACKAGE_ACCESS
     ENABLE_SYSTEM_APP
     NETWORK_ACTIVITY_LOGS
     SECURITY_LOGS
     CERT_SELECTION]],
   :accessibleTrackIds [string],
   :minimumVersionCode integer,
   :extensionConfig
   {:signingKeyFingerprintsSha256 [string],
    :notificationReceiver string},
   :workProfileWidgets
   [WORK_PROFILE_WIDGETS_UNSPECIFIED
    WORK_PROFILE_WIDGETS_ALLOWED
    WORK_PROFILE_WIDGETS_DISALLOWED],
   :alwaysOnVpnLockdownExemption
   [ALWAYS_ON_VPN_LOCKDOWN_EXEMPTION_UNSPECIFIED
    VPN_LOCKDOWN_ENFORCED
    VPN_LOCKDOWN_EXEMPTION],
   :defaultPermissionPolicy
   [PERMISSION_POLICY_UNSPECIFIED PROMPT GRANT DENY],
   :permissionGrants
   [{:permission string,
     :policy [PERMISSION_POLICY_UNSPECIFIED PROMPT GRANT DENY]}],
   :connectedWorkAndPersonalApp
   [CONNECTED_WORK_AND_PERSONAL_APP_UNSPECIFIED
    CONNECTED_WORK_AND_PERSONAL_APP_DISALLOWED
    CONNECTED_WORK_AND_PERSONAL_APP_ALLOWED],
   :autoUpdateMode
   [AUTO_UPDATE_MODE_UNSPECIFIED
    AUTO_UPDATE_DEFAULT
    AUTO_UPDATE_POSTPONED
    AUTO_UPDATE_HIGH_PRIORITY],
   :installPriority integer}],
 :mountPhysicalMediaDisabled boolean,
 :stayOnPluggedModes
 [[BATTERY_PLUGGED_MODE_UNSPECIFIED AC USB WIRELESS]],
 :microphoneAccess
 [MICROPHONE_ACCESS_UNSPECIFIED
  MICROPHONE_ACCESS_USER_CHOICE
  MICROPHONE_ACCESS_DISABLED
  MICROPHONE_ACCESS_ENFORCED],
 :dataRoamingDisabled boolean,
 :maximumTimeToLock string,
 :screenCaptureDisabled boolean,
 :encryptionPolicy
 [ENCRYPTION_POLICY_UNSPECIFIED
  ENABLED_WITHOUT_PASSWORD
  ENABLED_WITH_PASSWORD],
 :keyguardDisabled boolean,
 :unmuteMicrophoneDisabled boolean,
 :deviceConnectivityManagement
 {:usbDataAccess
  [USB_DATA_ACCESS_UNSPECIFIED
   ALLOW_USB_DATA_TRANSFER
   DISALLOW_USB_FILE_TRANSFER
   DISALLOW_USB_DATA_TRANSFER],
  :configureWifi
  [CONFIGURE_WIFI_UNSPECIFIED
   ALLOW_CONFIGURING_WIFI
   DISALLOW_ADD_WIFI_CONFIG
   DISALLOW_CONFIGURING_WIFI],
  :wifiDirectSettings
  [WIFI_DIRECT_SETTINGS_UNSPECIFIED
   ALLOW_WIFI_DIRECT
   DISALLOW_WIFI_DIRECT],
  :tetheringSettings
  [TETHERING_SETTINGS_UNSPECIFIED
   ALLOW_ALL_TETHERING
   DISALLOW_WIFI_TETHERING
   DISALLOW_ALL_TETHERING],
  :wifiSsidPolicy
  {:wifiSsidPolicyType
   [WIFI_SSID_POLICY_TYPE_UNSPECIFIED
    WIFI_SSID_DENYLIST
    WIFI_SSID_ALLOWLIST],
   :wifiSsids [{:wifiSsid string}]}},
 :name string,
 :passwordRequirements
 {:requirePasswordUnlock
  [REQUIRE_PASSWORD_UNLOCK_UNSPECIFIED
   USE_DEFAULT_DEVICE_TIMEOUT
   REQUIRE_EVERY_DAY],
  :unifiedLockSettings
  [UNIFIED_LOCK_SETTINGS_UNSPECIFIED
   ALLOW_UNIFIED_WORK_AND_PERSONAL_LOCK
   REQUIRE_SEPARATE_WORK_LOCK],
  :passwordScope [SCOPE_UNSPECIFIED SCOPE_DEVICE SCOPE_PROFILE],
  :passwordQuality
  [PASSWORD_QUALITY_UNSPECIFIED
   BIOMETRIC_WEAK
   SOMETHING
   NUMERIC
   NUMERIC_COMPLEX
   ALPHABETIC
   ALPHANUMERIC
   COMPLEX
   COMPLEXITY_LOW
   COMPLEXITY_MEDIUM
   COMPLEXITY_HIGH],
  :passwordMinimumNumeric integer,
  :passwordMinimumSymbols integer,
  :passwordMinimumUpperCase integer,
  :maximumFailedPasswordsForWipe integer,
  :passwordMinimumLength integer,
  :passwordMinimumNonLetter integer,
  :passwordExpirationTimeout string,
  :passwordHistoryLength integer,
  :passwordMinimumLetters integer,
  :passwordMinimumLowerCase integer},
 :factoryResetDisabled boolean,
 :preferentialNetworkService
 [PREFERENTIAL_NETWORK_SERVICE_UNSPECIFIED
  PREFERENTIAL_NETWORK_SERVICE_DISABLED
  PREFERENTIAL_NETWORK_SERVICE_ENABLED],
 :permittedInputMethods {:packageNames [string]},
 :androidDevicePolicyTracks [[APP_TRACK_UNSPECIFIED PRODUCTION BETA]],
 :installUnknownSourcesAllowed boolean,
 :minimumApiLevel integer,
 :credentialsConfigDisabled boolean,
 :ensureVerifyAppsEnabled boolean,
 :networkEscapeHatchEnabled boolean,
 :keyguardDisabledFeatures
 [[KEYGUARD_DISABLED_FEATURE_UNSPECIFIED
   CAMERA
   NOTIFICATIONS
   UNREDACTED_NOTIFICATIONS
   TRUST_AGENTS
   DISABLE_FINGERPRINT
   DISABLE_REMOTE_INPUT
   FACE
   IRIS
   BIOMETRICS
   SHORTCUTS
   ALL_FEATURES]],
 :credentialProviderPolicyDefault
 [CREDENTIAL_PROVIDER_POLICY_DEFAULT_UNSPECIFIED
  CREDENTIAL_PROVIDER_DEFAULT_DISALLOWED
  CREDENTIAL_PROVIDER_DEFAULT_DISALLOWED_EXCEPT_SYSTEM],
 :cameraDisabled boolean,
 :deviceOwnerLockScreenInfo
 {:localizedMessages object, :defaultMessage string},
 :printingPolicy
 [PRINTING_POLICY_UNSPECIFIED PRINTING_DISALLOWED PRINTING_ALLOWED],
 :safeBootDisabled boolean,
 :autoTimeRequired boolean,
 :playStoreMode [PLAY_STORE_MODE_UNSPECIFIED WHITELIST BLACKLIST],
 :shareLocationDisabled boolean,
 :permittedAccessibilityServices {:packageNames [string]},
 :bluetoothDisabled boolean,
 :setupActions
 [{:launchApp {:packageName string},
   :title {:localizedMessages object, :defaultMessage string},
   :description {:localizedMessages object, :defaultMessage string}}],
 :personalUsagePolicies
 {:cameraDisabled boolean,
  :screenCaptureDisabled boolean,
  :accountTypesWithManagementDisabled [string],
  :maxDaysWithWorkOff integer,
  :personalPlayStoreMode
  [PLAY_STORE_MODE_UNSPECIFIED BLACKLIST BLOCKLIST ALLOWLIST],
  :personalApplications
  [{:packageName string,
    :installType [INSTALL_TYPE_UNSPECIFIED BLOCKED AVAILABLE]}]},
 :installAppsDisabled boolean,
 :frpAdminEmails [string],
 :passwordPolicies
 [{:requirePasswordUnlock
   [REQUIRE_PASSWORD_UNLOCK_UNSPECIFIED
    USE_DEFAULT_DEVICE_TIMEOUT
    REQUIRE_EVERY_DAY],
   :unifiedLockSettings
   [UNIFIED_LOCK_SETTINGS_UNSPECIFIED
    ALLOW_UNIFIED_WORK_AND_PERSONAL_LOCK
    REQUIRE_SEPARATE_WORK_LOCK],
   :passwordScope [SCOPE_UNSPECIFIED SCOPE_DEVICE SCOPE_PROFILE],
   :passwordQuality
   [PASSWORD_QUALITY_UNSPECIFIED
    BIOMETRIC_WEAK
    SOMETHING
    NUMERIC
    NUMERIC_COMPLEX
    ALPHABETIC
    ALPHANUMERIC
    COMPLEX
    COMPLEXITY_LOW
    COMPLEXITY_MEDIUM
    COMPLEXITY_HIGH],
   :passwordMinimumNumeric integer,
   :passwordMinimumSymbols integer,
   :passwordMinimumUpperCase integer,
   :maximumFailedPasswordsForWipe integer,
   :passwordMinimumLength integer,
   :passwordMinimumNonLetter integer,
   :passwordExpirationTimeout string,
   :passwordHistoryLength integer,
   :passwordMinimumLetters integer,
   :passwordMinimumLowerCase integer}],
 :accountTypesWithManagementDisabled [string],
 :adjustVolumeDisabled boolean,
 :smsDisabled boolean,
 :usbMassStorageEnabled boolean,
 :displaySettings
 {:screenBrightnessSettings
  {:screenBrightnessMode
   [SCREEN_BRIGHTNESS_MODE_UNSPECIFIED
    BRIGHTNESS_USER_CHOICE
    BRIGHTNESS_AUTOMATIC
    BRIGHTNESS_FIXED],
   :screenBrightness integer},
  :screenTimeoutSettings
  {:screenTimeoutMode
   [SCREEN_TIMEOUT_MODE_UNSPECIFIED
    SCREEN_TIMEOUT_USER_CHOICE
    SCREEN_TIMEOUT_ENFORCED],
   :screenTimeout string}},
 :setWallpaperDisabled boolean,
 :removeUserDisabled boolean,
 :deviceRadioState
 {:wifiState
  [WIFI_STATE_UNSPECIFIED
   WIFI_STATE_USER_CHOICE
   WIFI_ENABLED
   WIFI_DISABLED],
  :airplaneModeState
  [AIRPLANE_MODE_STATE_UNSPECIFIED
   AIRPLANE_MODE_USER_CHOICE
   AIRPLANE_MODE_DISABLED],
  :ultraWidebandState
  [ULTRA_WIDEBAND_STATE_UNSPECIFIED
   ULTRA_WIDEBAND_USER_CHOICE
   ULTRA_WIDEBAND_DISABLED],
  :cellularTwoGState
  [CELLULAR_TWO_G_STATE_UNSPECIFIED
   CELLULAR_TWO_G_USER_CHOICE
   CELLULAR_TWO_G_DISABLED],
  :minimumWifiSecurityLevel
  [MINIMUM_WIFI_SECURITY_LEVEL_UNSPECIFIED
   OPEN_NETWORK_SECURITY
   PERSONAL_NETWORK_SECURITY
   ENTERPRISE_NETWORK_SECURITY
   ENTERPRISE_BIT192_NETWORK_SECURITY]},
 :networkResetDisabled boolean,
 :appAutoUpdatePolicy
 [APP_AUTO_UPDATE_POLICY_UNSPECIFIED
  CHOICE_TO_THE_USER
  NEVER
  WIFI_ONLY
  ALWAYS],
 :shortSupportMessage
 {:localizedMessages object, :defaultMessage string},
 :tetheringConfigDisabled boolean,
 :usbFileTransferDisabled boolean,
 :oncCertificateProviders
 [{:contentProviderEndpoint
   {:uri string, :packageName string, :signingCertsSha256 [string]},
   :certificateReferences [string]}],
 :crossProfilePolicies
 {:showWorkContactsInPersonalProfile
  [SHOW_WORK_CONTACTS_IN_PERSONAL_PROFILE_UNSPECIFIED
   SHOW_WORK_CONTACTS_IN_PERSONAL_PROFILE_DISALLOWED
   SHOW_WORK_CONTACTS_IN_PERSONAL_PROFILE_ALLOWED
   SHOW_WORK_CONTACTS_IN_PERSONAL_PROFILE_DISALLOWED_EXCEPT_SYSTEM],
  :crossProfileCopyPaste
  [CROSS_PROFILE_COPY_PASTE_UNSPECIFIED
   COPY_FROM_WORK_TO_PERSONAL_DISALLOWED
   CROSS_PROFILE_COPY_PASTE_ALLOWED],
  :crossProfileDataSharing
  [CROSS_PROFILE_DATA_SHARING_UNSPECIFIED
   CROSS_PROFILE_DATA_SHARING_DISALLOWED
   DATA_SHARING_FROM_WORK_TO_PERSONAL_DISALLOWED
   CROSS_PROFILE_DATA_SHARING_ALLOWED],
  :workProfileWidgetsDefault
  [WORK_PROFILE_WIDGETS_DEFAULT_UNSPECIFIED
   WORK_PROFILE_WIDGETS_DEFAULT_ALLOWED
   WORK_PROFILE_WIDGETS_DEFAULT_DISALLOWED],
  :exemptionsToShowWorkContactsInPersonalProfile
  {:packageNames [string]}},
 :cellBroadcastsConfigDisabled boolean,
 :defaultPermissionPolicy
 [PERMISSION_POLICY_UNSPECIFIED PROMPT GRANT DENY],
 :choosePrivateKeyRules
 [{:urlPattern string,
   :packageNames [string],
   :privateKeyAlias string}],
 :permissionGrants
 [{:permission string,
   :policy [PERMISSION_POLICY_UNSPECIFIED PROMPT GRANT DENY]}],
 :outgoingCallsDisabled boolean,
 :vpnConfigDisabled boolean,
 :bluetoothContactSharingDisabled boolean,
 :statusReportingSettings
 {:commonCriteriaModeEnabled boolean,
  :systemPropertiesEnabled boolean,
  :powerManagementEventsEnabled boolean,
  :memoryInfoEnabled boolean,
  :applicationReportsEnabled boolean,
  :applicationReportingSettings {:includeRemovedApps boolean},
  :networkInfoEnabled boolean,
  :deviceSettingsEnabled boolean,
  :hardwareStatusEnabled boolean,
  :displayInfoEnabled boolean,
  :softwareInfoEnabled boolean},
 :modifyAccountsDisabled boolean,
 :addUserDisabled boolean,
 :createWindowsDisabled boolean,
 :version string,
 :locationMode
 [LOCATION_MODE_UNSPECIFIED
  HIGH_ACCURACY
  SENSORS_ONLY
  BATTERY_SAVING
  OFF
  LOCATION_USER_CHOICE
  LOCATION_ENFORCED
  LOCATION_DISABLED],
 :systemUpdate
 {:type [SYSTEM_UPDATE_TYPE_UNSPECIFIED AUTOMATIC WINDOWED POSTPONE],
  :startMinutes integer,
  :endMinutes integer,
  :freezePeriods
  [{:startDate {:year integer, :month integer, :day integer},
    :endDate {:year integer, :month integer, :day integer}}]},
 :policyEnforcementRules
 [{:settingName string,
   :blockAction
   {:blockAfterDays integer,
    :blockScope
    [BLOCK_SCOPE_UNSPECIFIED
     BLOCK_SCOPE_WORK_PROFILE
     BLOCK_SCOPE_DEVICE]},
   :wipeAction {:wipeAfterDays integer, :preserveFrp boolean}}],
 :uninstallAppsDisabled boolean,
 :advancedSecurityOverrides
 {:untrustedAppsPolicy
  [UNTRUSTED_APPS_POLICY_UNSPECIFIED
   DISALLOW_INSTALL
   ALLOW_INSTALL_IN_PERSONAL_PROFILE_ONLY
   ALLOW_INSTALL_DEVICE_WIDE],
  :googlePlayProtectVerifyApps
  [GOOGLE_PLAY_PROTECT_VERIFY_APPS_UNSPECIFIED
   VERIFY_APPS_ENFORCED
   VERIFY_APPS_USER_CHOICE],
  :developerSettings
  [DEVELOPER_SETTINGS_UNSPECIFIED
   DEVELOPER_SETTINGS_DISABLED
   DEVELOPER_SETTINGS_ALLOWED],
  :commonCriteriaMode
  [COMMON_CRITERIA_MODE_UNSPECIFIED
   COMMON_CRITERIA_MODE_DISABLED
   COMMON_CRITERIA_MODE_ENABLED],
  :personalAppsThatCanReadWorkNotifications [string],
  :mtePolicy
  [MTE_POLICY_UNSPECIFIED MTE_USER_CHOICE MTE_ENFORCED MTE_DISABLED]},
 :setUserIconDisabled boolean,
 :autoDateAndTimeZone
 [AUTO_DATE_AND_TIME_ZONE_UNSPECIFIED
  AUTO_DATE_AND_TIME_ZONE_USER_CHOICE
  AUTO_DATE_AND_TIME_ZONE_ENFORCED],
 :usageLog
 {:enabledLogTypes
  [[LOG_TYPE_UNSPECIFIED SECURITY_LOGS NETWORK_ACTIVITY_LOGS]],
  :uploadOnCellularAllowed
  [[LOG_TYPE_UNSPECIFIED SECURITY_LOGS NETWORK_ACTIVITY_LOGS]]},
 :longSupportMessage
 {:localizedMessages object, :defaultMessage string},
 :persistentPreferredActivities
 [{:receiverActivity string, :actions [string], :categories [string]}],
 :mobileNetworksConfigDisabled boolean,
 :funDisabled boolean,
 :complianceRules
 [{:nonComplianceDetailCondition
   {:settingName string,
    :nonComplianceReason
    [NON_COMPLIANCE_REASON_UNSPECIFIED
     API_LEVEL
     MANAGEMENT_MODE
     USER_ACTION
     INVALID_VALUE
     APP_NOT_INSTALLED
     UNSUPPORTED
     APP_INSTALLED
     PENDING
     APP_INCOMPATIBLE
     APP_NOT_UPDATED
     DEVICE_INCOMPATIBLE],
    :packageName string},
   :apiLevelCondition {:minApiLevel integer},
   :disableApps boolean,
   :packageNamesToDisable [string]}],
 :wifiConfigsLockdownEnabled boolean,
 :privateKeySelectionEnabled boolean}

optional:
updateMask <string> The field mask indicating the fields to update. If not set, all modifiable fields will be modified."
  ([name Policy] (enterprises-policies-patch name Policy nil))
  ([name Policy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"],
       :body Policy})))

(defn enterprises-policies-delete
  "Deletes a policy. This operation is only permitted if no devices are currently referencing the policy.
https://developers.google.com/android/management/reference/rest/v1/enterprises/policies/delete

name <string> The name of the policy in the form enterprises/{enterpriseId}/policies/{policyId}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-applications-get
  "Gets info about an application.
https://developers.google.com/android/management/reference/rest/v1/enterprises/applications/get

name <string> The name of the application in the form enterprises/{enterpriseId}/applications/{package_name}.

optional:
languageCode <string> The preferred language for localized application info, as a BCP47 tag (e.g. \"en-US\", \"de\"). If not specified the default language of the application will be used."
  ([name] (enterprises-applications-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-webApps-create
  "Creates a web app.
https://developers.google.com/android/management/reference/rest/v1/enterprises/webApps/create

parent <string> The name of the enterprise in the form enterprises/{enterpriseId}.
WebApp:
{:name string,
 :title string,
 :startUrl string,
 :icons [{:imageData string}],
 :displayMode
 [DISPLAY_MODE_UNSPECIFIED MINIMAL_UI STANDALONE FULL_SCREEN],
 :versionCode string}"
  [parent WebApp]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+parent}/webApps",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"],
     :body WebApp}))

(defn enterprises-webApps-get
  "Gets a web app.
https://developers.google.com/android/management/reference/rest/v1/enterprises/webApps/get

name <string> The name of the web app in the form enterprises/{enterpriseId}/webApp/{packageName}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-webApps-list
  "Lists web apps for a given enterprise.
https://developers.google.com/android/management/reference/rest/v1/enterprises/webApps/list

parent <string> The name of the enterprise in the form enterprises/{enterpriseId}.

optional:
pageSize <integer> The requested page size. This is a hint and the actual page size in the response may be different."
  ([parent] (enterprises-webApps-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+parent}/webApps",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn enterprises-webApps-patch
  "Updates a web app.
https://developers.google.com/android/management/reference/rest/v1/enterprises/webApps/patch

name <string> The name of the web app in the form enterprises/{enterpriseId}/webApps/{packageName}.
WebApp:
{:name string,
 :title string,
 :startUrl string,
 :icons [{:imageData string}],
 :displayMode
 [DISPLAY_MODE_UNSPECIFIED MINIMAL_UI STANDALONE FULL_SCREEN],
 :versionCode string}

optional:
updateMask <string> The field mask indicating the fields to update. If not set, all modifiable fields will be modified."
  ([name WebApp] (enterprises-webApps-patch name WebApp nil))
  ([name WebApp optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"],
       :body WebApp})))

(defn enterprises-webApps-delete
  "Deletes a web app.
https://developers.google.com/android/management/reference/rest/v1/enterprises/webApps/delete

name <string> The name of the web app in the form enterprises/{enterpriseId}/webApps/{packageName}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-migrationTokens-create
  "Creates a migration token, to migrate an existing device from being managed by the EMM's Device Policy Controller (DPC) to being managed by the Android Management API. See the guide (https://developers.google.com/android/management/dpc-migration) for more details.
https://developers.google.com/android/management/reference/rest/v1/enterprises/migrationTokens/create

parent <string> Required. The enterprise in which this migration token is created. This must be the same enterprise which already manages the device in the Play EMM API. Format: enterprises/{enterprise}
MigrationToken:
{:additionalData string,
 :deviceId string,
 :name string,
 :value string,
 :createTime string,
 :policy string,
 :managementMode
 [MANAGEMENT_MODE_UNSPECIFIED
  WORK_PROFILE_PERSONALLY_OWNED
  WORK_PROFILE_COMPANY_OWNED
  FULLY_MANAGED],
 :ttl string,
 :userId string,
 :expireTime string,
 :device string}"
  [parent MigrationToken]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+parent}/migrationTokens",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"],
     :body MigrationToken}))

(defn enterprises-migrationTokens-get
  "Gets a migration token.
https://developers.google.com/android/management/reference/rest/v1/enterprises/migrationTokens/get

name <string> Required. The name of the migration token to retrieve. Format: enterprises/{enterprise}/migrationTokens/{migration_token}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

(defn enterprises-migrationTokens-list
  "Lists migration tokens.
https://developers.google.com/android/management/reference/rest/v1/enterprises/migrationTokens/list

parent <string> Required. The enterprise which the migration tokens belong to. Format: enterprises/{enterprise}

optional:
pageSize <integer> The maximum number of migration tokens to return. Fewer migration tokens may be returned. If unspecified, at most 100 migration tokens will be returned. The maximum value is 100; values above 100 will be coerced to 100."
  ([parent] (enterprises-migrationTokens-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidmanagement.googleapis.com/v1/{+parent}/migrationTokens",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidmanagement"]})))

(defn provisioningInfo-get
  "Get the device provisioning information by the identifier provided in the sign-in url.
https://developers.google.com/android/management/reference/rest/v1/provisioningInfo/get

name <string> Required. The identifier that Android Device Policy passes to the 3P sign-in page in the form of provisioningInfo/{provisioning_info}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidmanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidmanagement"]}))

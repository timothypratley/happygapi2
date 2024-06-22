(ns happygapi2.androidenterprise
  "Google Play EMM API
Manages the deployment of apps to Android Enterprise devices.
See: https://developers.google.com/android/work/play/emm-api"
  (:require [happy.oauth2.client :as client]))

(defn installs-list
  "Retrieves the details of all apps installed on the specified device.
https://developers.google.com/android/work/play/emm-api/v1/installs/list

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device."
  [enterpriseId userId deviceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs",
     :uri-template-args
     {:enterpriseId enterpriseId, :userId userId, :deviceId deviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn installs-get
  "Retrieves details of an installation of an app on a device.
https://developers.google.com/android/work/play/emm-api/v1/installs/get

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device.
installId <string> The ID of the product represented by the install, e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId deviceId installId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :deviceId deviceId,
      :installId installId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn installs-update
  "Requests to install the latest version of an app to a device. If the app is already installed, then it is updated to the latest version if necessary.
https://developers.google.com/android/work/play/emm-api/v1/installs/update

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device.
installId <string> The ID of the product represented by the install, e.g. \"app:com.google.android.gm\".
Install:
{:productId string,
 :versionCode integer,
 :installState [installed installPending]}"
  [enterpriseId userId deviceId installId Install]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :deviceId deviceId,
      :installId installId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body Install}))

(defn installs-delete
  "Requests to remove an app from a device. A call to get or list will still show the app as installed on the device until it is actually removed. A successful response indicates that a removal request has been sent to the device. The call will be considered successful even if the app is not present on the device (e.g. it was never installed, or was removed by the user).
https://developers.google.com/android/work/play/emm-api/v1/installs/delete

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device.
installId <string> The ID of the product represented by the install, e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId deviceId installId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :deviceId deviceId,
      :installId installId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn storelayoutclusters-list
  "Retrieves the details of all clusters on the specified page.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutclusters/list

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page."
  [enterpriseId pageId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters",
     :uri-template-args {:enterpriseId enterpriseId, :pageId pageId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn storelayoutclusters-insert
  "Inserts a new cluster in a page.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutclusters/insert

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page.
StoreCluster:
{:id string,
 :name [{:locale string, :text string}],
 :productId [string],
 :orderInPage string}"
  [enterpriseId pageId StoreCluster]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters",
     :uri-template-args {:enterpriseId enterpriseId, :pageId pageId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body StoreCluster}))

(defn storelayoutclusters-get
  "Retrieves details of a cluster.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutclusters/get

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page.
clusterId <string> The ID of the cluster."
  [enterpriseId pageId clusterId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :pageId pageId,
      :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn storelayoutclusters-update
  "Updates a cluster.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutclusters/update

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page.
clusterId <string> The ID of the cluster.
StoreCluster:
{:id string,
 :name [{:locale string, :text string}],
 :productId [string],
 :orderInPage string}"
  [enterpriseId pageId clusterId StoreCluster]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :pageId pageId,
      :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body StoreCluster}))

(defn storelayoutclusters-delete
  "Deletes a cluster.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutclusters/delete

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page.
clusterId <string> The ID of the cluster."
  [enterpriseId pageId clusterId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :pageId pageId,
      :clusterId clusterId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn permissions-get
  "Retrieves details of an Android app permission for display to an enterprise admin.
https://developers.google.com/android/work/play/emm-api/v1/permissions/get

permissionId <string> The ID of the permission.

optional:
language <string> The BCP47 tag for the user's preferred language (e.g. \"en-US\", \"de\")"
  ([permissionId] (permissions-get permissionId nil))
  ([permissionId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/permissions/{permissionId}",
       :uri-template-args {:permissionId permissionId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn grouplicenses-list
  "Retrieves IDs of all products for which the enterprise has a group license. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/grouplicenses/list

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/groupLicenses",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn grouplicenses-get
  "Retrieves details of an enterprise's group license for a product. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/grouplicenses/get

enterpriseId <string> The ID of the enterprise.
groupLicenseId <string> The ID of the product the group license is for, e.g. \"app:com.google.android.gm\"."
  [enterpriseId groupLicenseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/groupLicenses/{groupLicenseId}",
     :uri-template-args
     {:enterpriseId enterpriseId, :groupLicenseId groupLicenseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn enterprises-setAccount
  "Sets the account that will be used to authenticate to the API as the enterprise.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/setAccount

enterpriseId <string> The ID of the enterprise.
EnterpriseAccount:
{:accountEmail string}"
  [enterpriseId EnterpriseAccount]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/account",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body EnterpriseAccount}))

(defn enterprises-getStoreLayout
  "Returns the store layout for the enterprise. If the store layout has not been set, returns \"basic\" as the store layout type and no homepage.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/getStoreLayout

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn enterprises-get
  "Retrieves the name and domain of an enterprise.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/get

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn enterprises-createWebToken
  "Returns a unique token to access an embeddable UI. To generate a web UI, pass the generated token into the managed Google Play javascript API. Each token may only be used to start one UI session. See the JavaScript API documentation for further information.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/createWebToken

enterpriseId <string> The ID of the enterprise.
AdministratorWebTokenSpec:
{:permission [[unknown approveApps manageMcm]],
 :parent string,
 :playSearch {:enabled boolean, :approveApps boolean},
 :privateApps {:enabled boolean},
 :webApps {:enabled boolean},
 :storeBuilder {:enabled boolean},
 :managedConfigurations {:enabled boolean},
 :zeroTouch {:enabled boolean}}"
  [enterpriseId AdministratorWebTokenSpec]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/createWebToken",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body AdministratorWebTokenSpec}))

(defn enterprises-createEnrollmentToken
  "Returns a token for device enrollment. The DPC can encode this token within the QR/NFC/zero-touch enrollment payload or fetch it before calling the on-device API to authenticate the user. The token can be generated for each device or reused across multiple devices.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/createEnrollmentToken

enterpriseId <string> The ID of the enterprise.

optional:
deviceType <string> Whether it’s a dedicated device or a knowledge worker device."
  ([enterpriseId] (enterprises-createEnrollmentToken enterpriseId nil))
  ([enterpriseId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/createEnrollmentToken",
       :uri-template-args {:enterpriseId enterpriseId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn enterprises-generateSignupUrl
  "Generates a sign-up URL.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/generateSignupUrl

optional:
callbackUrl <string> The callback URL to which the Admin will be redirected after successfully creating an enterprise. Before redirecting there the system will add a single query parameter to this URL named \"enterpriseToken\" which will contain an opaque token to be used for the CompleteSignup request. Beware that this means that the URL will be parsed, the parameter added and then a new URL formatted, i.e. there may be some minor formatting changes and, more importantly, the URL must be well-formed so that it can be parsed."
  ([] (enterprises-generateSignupUrl nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/signupUrl",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn enterprises-unenroll
  "Unenrolls an enterprise from the calling EMM.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/unenroll

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/unenroll",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn enterprises-completeSignup
  "Completes the signup flow, by specifying the Completion token and Enterprise token. This request must not be called multiple times for a given Enterprise Token.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/completeSignup

optional:
completionToken <string> The Completion token initially returned by GenerateSignupUrl.
enterpriseToken <string> The Enterprise token appended to the Callback URL."
  ([] (enterprises-completeSignup nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/completeSignup",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn enterprises-setStoreLayout
  "Sets the store layout for the enterprise. By default, storeLayoutType is set to \"basic\" and the basic store layout is enabled. The basic layout only contains apps approved by the admin, and that have been added to the available product set for a user (using the setAvailableProductSet call). Apps on the page are sorted in order of their product ID value. If you create a custom store layout (by setting storeLayoutType = \"custom\" and setting a homepage), the basic store layout is disabled.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/setStoreLayout

enterpriseId <string> The ID of the enterprise.
StoreLayout:
{:homepageId string, :storeLayoutType [unknown basic custom]}"
  [enterpriseId StoreLayout]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body StoreLayout}))

(defn enterprises-acknowledgeNotificationSet
  "Acknowledges notifications that were received from Enterprises.PullNotificationSet to prevent subsequent calls from returning the same notifications.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/acknowledgeNotificationSet

optional:
notificationSetId <string> The notification set ID as returned by Enterprises.PullNotificationSet. This must be provided."
  ([] (enterprises-acknowledgeNotificationSet nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/acknowledgeNotificationSet",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn enterprises-pullNotificationSet
  "Pulls and returns a notification set for the enterprises associated with the service account authenticated for the request. The notification set may be empty if no notification are pending. A notification set returned needs to be acknowledged within 20 seconds by calling Enterprises.AcknowledgeNotificationSet, unless the notification set is empty. Notifications that are not acknowledged within the 20 seconds will eventually be included again in the response to another PullNotificationSet request, and those that are never acknowledged will ultimately be deleted according to the Google Cloud Platform Pub/Sub system policy. Multiple requests might be performed concurrently to retrieve notifications, in which case the pending notifications (if any) will be split among each caller, if any are pending. If no notifications are present, an empty notification list is returned. Subsequent requests may return more notifications once they become available.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/pullNotificationSet

optional:
requestMode <string> The request mode for pulling notifications. Specifying waitForNotifications will cause the request to block and wait until one or more notifications are present, or return an empty notification list if no notifications are present after some time. Specifying returnImmediately will cause the request to immediately return the pending notifications, or an empty list if no notifications are present. If omitted, defaults to waitForNotifications."
  ([] (enterprises-pullNotificationSet nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/pullNotificationSet",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn enterprises-list
  "Looks up an enterprise by domain name. This is only supported for enterprises created via the Google-initiated creation flow. Lookup of the id is not needed for enterprises created via the EMM-initiated flow since the EMM learns the enterprise ID in the callback specified in the Enterprises.generateSignupUrl call.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/list

domain <string> Required. The exact primary domain name of the enterprise to look up."
  [domain]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises",
     :uri-template-args {},
     :query-params {:domain domain},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn enterprises-sendTestPushNotification
  "Sends a test notification to validate the EMM integration with the Google Cloud Pub/Sub service for this enterprise.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/sendTestPushNotification

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/sendTestPushNotification",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn enterprises-getServiceAccount
  "Returns a service account and credentials. The service account can be bound to the enterprise by calling setAccount. The service account is unique to this enterprise and EMM, and will be deleted if the enterprise is unbound. The credentials contain private key data and are not stored server-side. This method can only be called after calling Enterprises.Enroll or Enterprises.CompleteSignup, and before Enterprises.SetAccount; at other times it will return an error. Subsequent calls after the first will generate a new, unique set of credentials, and invalidate the previously generated credentials. Once the service account is bound to the enterprise, it can be managed using the serviceAccountKeys resource.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/getServiceAccount

enterpriseId <string> The ID of the enterprise.

optional:
keyType <string> The type of credential to return with the service account. Required."
  ([enterpriseId] (enterprises-getServiceAccount enterpriseId nil))
  ([enterpriseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/serviceAccount",
       :uri-template-args {:enterpriseId enterpriseId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn enterprises-enroll
  "Enrolls an enterprise with the calling EMM.
https://developers.google.com/android/work/play/emm-api/v1/enterprises/enroll

token <string> Required. The token provided by the enterprise to register the EMM.
Enterprise:
{:id string,
 :primaryDomain string,
 :name string,
 :administrator [{:email string}],
 :googleAuthenticationSettings
 {:googleAuthenticationRequired
  [googleAuthenticationRequiredUnspecified notRequired required],
  :dedicatedDevicesAllowed
  [dedicatedDevicesAllowedUnspecified disallowed allowed]}}"
  [token Enterprise]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/enroll",
     :uri-template-args {},
     :query-params {:token token},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body Enterprise}))

(defn entitlements-list
  "Lists all entitlements for the specified user. Only the ID is set. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/entitlements/list

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/entitlements",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn entitlements-get
  "Retrieves details of an entitlement. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/entitlements/get

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
entitlementId <string> The ID of the entitlement (a product ID), e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId entitlementId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :entitlementId entitlementId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn entitlements-update
  "Adds or updates an entitlement to an app for a user. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/entitlements/update

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
entitlementId <string> The ID of the entitlement (a product ID), e.g. \"app:com.google.android.gm\".
Entitlement:
{:productId string, :reason [free groupLicense userPurchase]}

optional:
install <boolean> Set to true to also install the product on all the user's devices where possible. Failure to install on one or more devices will not prevent this operation from returning successfully, as long as the entitlement was successfully assigned to the user."
  ([enterpriseId userId entitlementId Entitlement]
    (entitlements-update
      enterpriseId
      userId
      entitlementId
      Entitlement
      nil))
  ([enterpriseId userId entitlementId Entitlement optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}",
       :uri-template-args
       {:enterpriseId enterpriseId,
        :userId userId,
        :entitlementId entitlementId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"],
       :body Entitlement})))

(defn entitlements-delete
  "Removes an entitlement to an app for a user. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/entitlements/delete

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
entitlementId <string> The ID of the entitlement (a product ID), e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId entitlementId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :entitlementId entitlementId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn products-get
  "Retrieves details of a product for display to an enterprise admin.
https://developers.google.com/android/work/play/emm-api/v1/products/get

enterpriseId <string> The ID of the enterprise.
productId <string> The ID of the product, e.g. \"app:com.google.android.gm\".

optional:
language <string> The BCP47 tag for the user's preferred language (e.g. \"en-US\", \"de\")."
  ([enterpriseId productId] (products-get enterpriseId productId nil))
  ([enterpriseId productId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}",
       :uri-template-args
       {:enterpriseId enterpriseId, :productId productId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn products-list
  "Finds approved products that match a query, or all approved products if there is no query. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations. 
https://developers.google.com/android/work/play/emm-api/v1/products/list

enterpriseId <string> The ID of the enterprise.

optional:
maxResults <integer> Defines how many results the list operation should return. The default number depends on the resource collection.
token <string> Defines the token of the page to return, usually taken from TokenPagination. This can only be used if token paging is enabled.
approved <boolean> Specifies whether to search among all products (false) or among only products that have been approved (true). Only \"true\" is supported, and should be specified.
query <string> The search query as typed in the Google Play store search box. If omitted, all approved apps will be returned (using the pagination parameters), including apps that are not available in the store (e.g. unpublished apps).
language <string> The BCP47 tag for the user's preferred language (e.g. \"en-US\", \"de\"). Results are returned in the language best matching the preferred language."
  ([enterpriseId] (products-list enterpriseId nil))
  ([enterpriseId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products",
       :uri-template-args {:enterpriseId enterpriseId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn products-getPermissions
  "Retrieves the Android app permissions required by this app.
https://developers.google.com/android/work/play/emm-api/v1/products/getPermissions

enterpriseId <string> The ID of the enterprise.
productId <string> The ID of the product."
  [enterpriseId productId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}/permissions",
     :uri-template-args
     {:enterpriseId enterpriseId, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn products-generateApprovalUrl
  "Generates a URL that can be rendered in an iframe to display the permissions (if any) of a product. An enterprise admin must view these permissions and accept them on behalf of their organization in order to approve that product. Admins should accept the displayed permissions by interacting with a separate UI element in the EMM console, which in turn should trigger the use of this URL as the approvalUrlInfo.approvalUrl property in a Products.approve call to approve the product. This URL can only be used to display permissions for up to 1 day. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations. 
https://developers.google.com/android/work/play/emm-api/v1/products/generateApprovalUrl

enterpriseId <string> The ID of the enterprise.
productId <string> The ID of the product.

optional:
languageCode <string> The BCP 47 language code used for permission names and descriptions in the returned iframe, for instance \"en-US\"."
  ([enterpriseId productId]
    (products-generateApprovalUrl enterpriseId productId nil))
  ([enterpriseId productId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}/generateApprovalUrl",
       :uri-template-args
       {:enterpriseId enterpriseId, :productId productId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn products-approve
  " Approves the specified product and the relevant app permissions, if any. The maximum number of products that you can approve per enterprise customer is 1,000. To learn how to use managed Google Play to design and create a store layout to display approved products to your users, see Store Layout Design. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations. 
https://developers.google.com/android/work/play/emm-api/v1/products/approve

enterpriseId <string> The ID of the enterprise.
productId <string> The ID of the product.
ProductsApproveRequest:
{:approvalUrlInfo {:approvalUrl string},
 :approvedPermissions [currentPermissionsOnly allPermissions]}"
  [enterpriseId productId ProductsApproveRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}/approve",
     :uri-template-args
     {:enterpriseId enterpriseId, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body ProductsApproveRequest}))

(defn products-unapprove
  "Unapproves the specified product (and the relevant app permissions, if any) **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/products/unapprove

enterpriseId <string> The ID of the enterprise.
productId <string> The ID of the product."
  [enterpriseId productId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}/unapprove",
     :uri-template-args
     {:enterpriseId enterpriseId, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn products-getAppRestrictionsSchema
  "Retrieves the schema that defines the configurable properties for this product. All products have a schema, but this schema may be empty if no managed configurations have been defined. This schema can be used to populate a UI that allows an admin to configure the product. To apply a managed configuration based on the schema obtained using this API, see Managed Configurations through Play.
https://developers.google.com/android/work/play/emm-api/v1/products/getAppRestrictionsSchema

enterpriseId <string> The ID of the enterprise.
productId <string> The ID of the product.

optional:
language <string> The BCP47 tag for the user's preferred language (e.g. \"en-US\", \"de\")."
  ([enterpriseId productId]
    (products-getAppRestrictionsSchema enterpriseId productId nil))
  ([enterpriseId productId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}/appRestrictionsSchema",
       :uri-template-args
       {:enterpriseId enterpriseId, :productId productId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"]})))

(defn managedconfigurationssettings-list
  "Lists all the managed configurations settings for the specified app.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationssettings/list

enterpriseId <string> The ID of the enterprise.
productId <string> The ID of the product for which the managed configurations settings applies to."
  [enterpriseId productId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}/managedConfigurationsSettings",
     :uri-template-args
     {:enterpriseId enterpriseId, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn devices-list
  "Retrieves the IDs of all of a user's devices.
https://developers.google.com/android/work/play/emm-api/v1/devices/list

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn devices-get
  "Retrieves the details of a device.
https://developers.google.com/android/work/play/emm-api/v1/devices/get

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The ID of the device."
  [enterpriseId userId deviceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}",
     :uri-template-args
     {:enterpriseId enterpriseId, :userId userId, :deviceId deviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn devices-update
  "Updates the device policy. To ensure the policy is properly enforced, you need to prevent unmanaged accounts from accessing Google Play by setting the allowed_accounts in the managed configuration for the Google Play package. See restrict accounts in Google Play. When provisioning a new device, you should set the device policy using this method before adding the managed Google Play Account to the device, otherwise the policy will not be applied for a short period of time after adding the account to the device.
https://developers.google.com/android/work/play/emm-api/v1/devices/update

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The ID of the device.
Device:
{:report
 {:lastUpdatedTimestampMillis string,
  :appState
  [{:packageName string,
    :keyedAppState
    [{:key string,
      :stateTimestampMillis string,
      :severity [severityUnknown severityInfo severityError],
      :message string,
      :data string}]}]},
 :latestBuildFingerprint string,
 :sdkVersion integer,
 :managementType
 [managedDevice managedProfile containerApp unmanagedProfile],
 :androidId string,
 :policy
 {:autoUpdatePolicy
  [autoUpdatePolicyUnspecified choiceToTheUser never wifiOnly always],
  :productAvailabilityPolicy
  [productAvailabilityPolicyUnspecified whitelist all],
  :productPolicy
  [{:productId string,
    :tracks [[appTrackUnspecified production beta alpha]],
    :trackIds [string],
    :managedConfiguration
    {:kind string,
     :productId string,
     :managedProperty
     [{:key string,
       :valueBool boolean,
       :valueInteger integer,
       :valueString string,
       :valueStringArray [string],
       :valueBundle ManagedPropertyBundle,
       :valueBundleArray [ManagedPropertyBundle]}],
     :configurationVariables
     {:mcmId string, :variableSet [VariableSet]}},
    :autoInstallPolicy
    {:autoInstallMode
     [autoInstallModeUnspecified
      doNotAutoInstall
      autoInstallOnce
      forceAutoInstall],
     :autoInstallPriority integer,
     :autoInstallConstraint
     [{:networkTypeConstraint
       [networkTypeConstraintUnspecified anyNetwork unmeteredNetwork],
       :chargingStateConstraint
       [chargingStateConstraintUnspecified
        chargingNotRequired
        chargingRequired],
       :deviceIdleStateConstraint
       [deviceIdleStateConstraintUnspecified
        deviceIdleNotRequired
        deviceIdleRequired]}],
     :minimumVersionCode integer},
    :autoUpdateMode
    [autoUpdateModeUnspecified
     autoUpdateDefault
     autoUpdatePostponed
     autoUpdateHighPriority],
    :enterpriseAuthenticationAppLinkConfigs [{:uri string}]}],
  :maintenanceWindow
  {:startTimeAfterMidnightMs string, :durationMs string},
  :deviceReportPolicy
  [deviceReportPolicyUnspecified
   deviceReportDisabled
   deviceReportEnabled]},
 :product string,
 :device string,
 :maker string,
 :retailBrand string,
 :model string}

optional:
updateMask <string> Mask that identifies which fields to update. If not set, all modifiable fields will be modified. When set in a query parameter, this field should be specified as updateMask=<field1>,<field2>,..."
  ([enterpriseId userId deviceId Device]
    (devices-update enterpriseId userId deviceId Device nil))
  ([enterpriseId userId deviceId Device optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}",
       :uri-template-args
       {:enterpriseId enterpriseId,
        :userId userId,
        :deviceId deviceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidenterprise"],
       :body Device})))

(defn devices-getState
  "Retrieves whether a device's access to Google services is enabled or disabled. The device state takes effect only if enforcing EMM policies on Android devices is enabled in the Google Admin Console. Otherwise, the device state is ignored and all devices are allowed access to Google services. This is only supported for Google-managed users.
https://developers.google.com/android/work/play/emm-api/v1/devices/getState

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The ID of the device."
  [enterpriseId userId deviceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/state",
     :uri-template-args
     {:enterpriseId enterpriseId, :userId userId, :deviceId deviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn devices-setState
  "Sets whether a device's access to Google services is enabled or disabled. The device state takes effect only if enforcing EMM policies on Android devices is enabled in the Google Admin Console. Otherwise, the device state is ignored and all devices are allowed access to Google services. This is only supported for Google-managed users.
https://developers.google.com/android/work/play/emm-api/v1/devices/setState

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The ID of the device.
DeviceState:
{:accountState [enabled disabled]}"
  [enterpriseId userId deviceId DeviceState]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/state",
     :uri-template-args
     {:enterpriseId enterpriseId, :userId userId, :deviceId deviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body DeviceState}))

(defn devices-forceReportUpload
  "Uploads a report containing any changes in app states on the device since the last report was generated. You can call this method up to 3 times every 24 hours for a given device. If you exceed the quota, then the Google Play EMM API returns HTTP 429 Too Many Requests.
https://developers.google.com/android/work/play/emm-api/v1/devices/forceReportUpload

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The ID of the device."
  [enterpriseId userId deviceId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/forceReportUpload",
     :uri-template-args
     {:enterpriseId enterpriseId, :userId userId, :deviceId deviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn serviceaccountkeys-insert
  "Generates new credentials for the service account associated with this enterprise. The calling service account must have been retrieved by calling Enterprises.GetServiceAccount and must have been set as the enterprise service account by calling Enterprises.SetAccount. Only the type of the key should be populated in the resource to be inserted.
https://developers.google.com/android/work/play/emm-api/v1/serviceaccountkeys/insert

enterpriseId <string> The ID of the enterprise.
ServiceAccountKey:
{:id string,
 :type [googleCredentials pkcs12],
 :data string,
 :publicData string}"
  [enterpriseId ServiceAccountKey]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/serviceAccountKeys",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body ServiceAccountKey}))

(defn serviceaccountkeys-list
  "Lists all active credentials for the service account associated with this enterprise. Only the ID and key type are returned. The calling service account must have been retrieved by calling Enterprises.GetServiceAccount and must have been set as the enterprise service account by calling Enterprises.SetAccount.
https://developers.google.com/android/work/play/emm-api/v1/serviceaccountkeys/list

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/serviceAccountKeys",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn serviceaccountkeys-delete
  "Removes and invalidates the specified credentials for the service account associated with this enterprise. The calling service account must have been retrieved by calling Enterprises.GetServiceAccount and must have been set as the enterprise service account by calling Enterprises.SetAccount.
https://developers.google.com/android/work/play/emm-api/v1/serviceaccountkeys/delete

enterpriseId <string> The ID of the enterprise.
keyId <string> The ID of the key."
  [enterpriseId keyId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/serviceAccountKeys/{keyId}",
     :uri-template-args {:enterpriseId enterpriseId, :keyId keyId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn webapps-get
  "Gets an existing web app.
https://developers.google.com/android/work/play/emm-api/v1/webapps/get

enterpriseId <string> The ID of the enterprise.
webAppId <string> The ID of the web app."
  [enterpriseId webAppId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/webApps/{webAppId}",
     :uri-template-args
     {:enterpriseId enterpriseId, :webAppId webAppId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn webapps-list
  "Retrieves the details of all web apps for a given enterprise.
https://developers.google.com/android/work/play/emm-api/v1/webapps/list

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/webApps",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn webapps-insert
  "Creates a new web app for the enterprise.
https://developers.google.com/android/work/play/emm-api/v1/webapps/insert

enterpriseId <string> The ID of the enterprise.
WebApp:
{:webAppId string,
 :title string,
 :startUrl string,
 :icons [{:imageData string}],
 :displayMode [displayModeUnspecified minimalUi standalone fullScreen],
 :versionCode string,
 :isPublished boolean}"
  [enterpriseId WebApp]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/webApps",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body WebApp}))

(defn webapps-update
  "Updates an existing web app.
https://developers.google.com/android/work/play/emm-api/v1/webapps/update

enterpriseId <string> The ID of the enterprise.
webAppId <string> The ID of the web app.
WebApp:
{:webAppId string,
 :title string,
 :startUrl string,
 :icons [{:imageData string}],
 :displayMode [displayModeUnspecified minimalUi standalone fullScreen],
 :versionCode string,
 :isPublished boolean}"
  [enterpriseId webAppId WebApp]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/webApps/{webAppId}",
     :uri-template-args
     {:enterpriseId enterpriseId, :webAppId webAppId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body WebApp}))

(defn webapps-delete
  "Deletes an existing web app.
https://developers.google.com/android/work/play/emm-api/v1/webapps/delete

enterpriseId <string> The ID of the enterprise.
webAppId <string> The ID of the web app."
  [enterpriseId webAppId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/webApps/{webAppId}",
     :uri-template-args
     {:enterpriseId enterpriseId, :webAppId webAppId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn managedconfigurationsforuser-list
  "Lists all the per-user managed configurations for the specified user. Only the ID is set.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsforuser/list

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn managedconfigurationsforuser-get
  "Retrieves details of a per-user managed configuration for an app for the specified user.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsforuser/get

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
managedConfigurationForUserId <string> The ID of the managed configuration (a product ID), e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId managedConfigurationForUserId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :managedConfigurationForUserId managedConfigurationForUserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn managedconfigurationsforuser-update
  "Adds or updates the managed configuration settings for an app for the specified user. If you support the Managed configurations iframe, you can apply managed configurations to a user by specifying an mcmId and its associated configuration variables (if any) in the request. Alternatively, all EMMs can apply managed configurations by passing a list of managed properties.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsforuser/update

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
managedConfigurationForUserId <string> The ID of the managed configuration (a product ID), e.g. \"app:com.google.android.gm\".
ManagedConfiguration:
{:kind string,
 :productId string,
 :managedProperty
 [{:key string,
   :valueBool boolean,
   :valueInteger integer,
   :valueString string,
   :valueStringArray [string],
   :valueBundle
   {:managedProperty
    [{:key string,
      :valueBool boolean,
      :valueInteger integer,
      :valueString string,
      :valueStringArray [string],
      :valueBundle {:managedProperty [ManagedProperty]},
      :valueBundleArray [{:managedProperty [ManagedProperty]}]}]},
   :valueBundleArray
   [{:managedProperty
     [{:key string,
       :valueBool boolean,
       :valueInteger integer,
       :valueString string,
       :valueStringArray [string],
       :valueBundle {:managedProperty [ManagedProperty]},
       :valueBundleArray [{:managedProperty [ManagedProperty]}]}]}]}],
 :configurationVariables
 {:mcmId string,
  :variableSet [{:placeholder string, :userValue string}]}}"
  [enterpriseId
   userId
   managedConfigurationForUserId
   ManagedConfiguration]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :managedConfigurationForUserId managedConfigurationForUserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body ManagedConfiguration}))

(defn managedconfigurationsforuser-delete
  "Removes a per-user managed configuration for an app for the specified user.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsforuser/delete

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
managedConfigurationForUserId <string> The ID of the managed configuration (a product ID), e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId managedConfigurationForUserId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :managedConfigurationForUserId managedConfigurationForUserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn grouplicenseusers-list
  "Retrieves the IDs of the users who have been granted entitlements under the license. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/grouplicenseusers/list

enterpriseId <string> The ID of the enterprise.
groupLicenseId <string> The ID of the product the group license is for, e.g. \"app:com.google.android.gm\"."
  [enterpriseId groupLicenseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/groupLicenses/{groupLicenseId}/users",
     :uri-template-args
     {:enterpriseId enterpriseId, :groupLicenseId groupLicenseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn managedconfigurationsfordevice-list
  "Lists all the per-device managed configurations for the specified device. Only the ID is set.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsfordevice/list

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device."
  [enterpriseId userId deviceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice",
     :uri-template-args
     {:enterpriseId enterpriseId, :userId userId, :deviceId deviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn managedconfigurationsfordevice-get
  "Retrieves details of a per-device managed configuration.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsfordevice/get

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device.
managedConfigurationForDeviceId <string> The ID of the managed configuration (a product ID), e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId deviceId managedConfigurationForDeviceId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :deviceId deviceId,
      :managedConfigurationForDeviceId
      managedConfigurationForDeviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn managedconfigurationsfordevice-update
  "Adds or updates a per-device managed configuration for an app for the specified device.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsfordevice/update

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device.
managedConfigurationForDeviceId <string> The ID of the managed configuration (a product ID), e.g. \"app:com.google.android.gm\".
ManagedConfiguration:
{:kind string,
 :productId string,
 :managedProperty
 [{:key string,
   :valueBool boolean,
   :valueInteger integer,
   :valueString string,
   :valueStringArray [string],
   :valueBundle
   {:managedProperty
    [{:key string,
      :valueBool boolean,
      :valueInteger integer,
      :valueString string,
      :valueStringArray [string],
      :valueBundle {:managedProperty [ManagedProperty]},
      :valueBundleArray [{:managedProperty [ManagedProperty]}]}]},
   :valueBundleArray
   [{:managedProperty
     [{:key string,
       :valueBool boolean,
       :valueInteger integer,
       :valueString string,
       :valueStringArray [string],
       :valueBundle {:managedProperty [ManagedProperty]},
       :valueBundleArray [{:managedProperty [ManagedProperty]}]}]}]}],
 :configurationVariables
 {:mcmId string,
  :variableSet [{:placeholder string, :userValue string}]}}"
  [enterpriseId
   userId
   deviceId
   managedConfigurationForDeviceId
   ManagedConfiguration]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :deviceId deviceId,
      :managedConfigurationForDeviceId
      managedConfigurationForDeviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body ManagedConfiguration}))

(defn managedconfigurationsfordevice-delete
  "Removes a per-device managed configuration for an app for the specified device.
https://developers.google.com/android/work/play/emm-api/v1/managedconfigurationsfordevice/delete

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
deviceId <string> The Android ID of the device.
managedConfigurationForDeviceId <string> The ID of the managed configuration (a product ID), e.g. \"app:com.google.android.gm\"."
  [enterpriseId userId deviceId managedConfigurationForDeviceId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}",
     :uri-template-args
     {:enterpriseId enterpriseId,
      :userId userId,
      :deviceId deviceId,
      :managedConfigurationForDeviceId
      managedConfigurationForDeviceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn users-get
  "Retrieves a user's details.
https://developers.google.com/android/work/play/emm-api/v1/users/get

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn users-insert
  "Creates a new EMM-managed user. The Users resource passed in the body of the request should include an accountIdentifier and an accountType. If a corresponding user already exists with the same account identifier, the user will be updated with the resource. In this case only the displayName field can be changed.
https://developers.google.com/android/work/play/emm-api/v1/users/insert

enterpriseId <string> The ID of the enterprise.
User:
{:id string,
 :managementType [googleManaged emmManaged],
 :accountType [deviceAccount userAccount],
 :primaryEmail string,
 :accountIdentifier string,
 :displayName string}"
  [enterpriseId User]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body User}))

(defn users-generateAuthenticationToken
  "Generates an authentication token which the device policy client can use to provision the given EMM-managed user account on a device. The generated token is single-use and expires after a few minutes. You can provision a maximum of 10 devices per user. This call only works with EMM-managed accounts.
https://developers.google.com/android/work/play/emm-api/v1/users/generateAuthenticationToken

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/authenticationToken",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn users-update
  "Updates the details of an EMM-managed user. Can be used with EMM-managed users only (not Google managed users). Pass the new details in the Users resource in the request body. Only the displayName field can be changed. Other fields must either be unset or have the currently active value.
https://developers.google.com/android/work/play/emm-api/v1/users/update

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
User:
{:id string,
 :managementType [googleManaged emmManaged],
 :accountType [deviceAccount userAccount],
 :primaryEmail string,
 :accountIdentifier string,
 :displayName string}"
  [enterpriseId userId User]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body User}))

(defn users-delete
  "Deleted an EMM-managed user.
https://developers.google.com/android/work/play/emm-api/v1/users/delete

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn users-revokeDeviceAccess
  "Revokes access to all devices currently provisioned to the user. The user will no longer be able to use the managed Play store on any of their managed devices. This call only works with EMM-managed accounts.
https://developers.google.com/android/work/play/emm-api/v1/users/revokeDeviceAccess

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/deviceAccess",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn users-list
  "Looks up a user by primary email address. This is only supported for Google-managed users. Lookup of the id is not needed for EMM-managed users because the id is already returned in the result of the Users.insert call.
https://developers.google.com/android/work/play/emm-api/v1/users/list

enterpriseId <string> The ID of the enterprise.
email <string> Required. The exact primary email address of the user to look up."
  [enterpriseId email]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {:email email},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn users-getAvailableProductSet
  "Retrieves the set of products a user is entitled to access. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/users/getAvailableProductSet

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user."
  [enterpriseId userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/availableProductSet",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn users-setAvailableProductSet
  "Modifies the set of products that a user is entitled to access (referred to as *whitelisted* products). Only products that are approved or products that were previously approved (products with revoked approval) can be whitelisted. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations.
https://developers.google.com/android/work/play/emm-api/v1/users/setAvailableProductSet

enterpriseId <string> The ID of the enterprise.
userId <string> The ID of the user.
ProductSet:
{:productId [string],
 :productSetBehavior [unknown whitelist includeAll allApproved],
 :productVisibility
 [{:productId string,
   :tracks [[appTrackUnspecified production beta alpha]],
   :trackIds [string]}]}"
  [enterpriseId userId ProductSet]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/availableProductSet",
     :uri-template-args {:enterpriseId enterpriseId, :userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body ProductSet}))

(defn storelayoutpages-list
  "Retrieves the details of all pages in the store.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutpages/list

enterpriseId <string> The ID of the enterprise."
  [enterpriseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn storelayoutpages-insert
  "Inserts a new store page.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutpages/insert

enterpriseId <string> The ID of the enterprise.
StorePage:
{:id string, :name [{:locale string, :text string}], :link [string]}"
  [enterpriseId StorePage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages",
     :uri-template-args {:enterpriseId enterpriseId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body StorePage}))

(defn storelayoutpages-get
  "Retrieves details of a store page.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutpages/get

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page."
  [enterpriseId pageId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}",
     :uri-template-args {:enterpriseId enterpriseId, :pageId pageId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

(defn storelayoutpages-update
  "Updates the content of a store page.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutpages/update

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page.
StorePage:
{:id string, :name [{:locale string, :text string}], :link [string]}"
  [enterpriseId pageId StorePage]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}",
     :uri-template-args {:enterpriseId enterpriseId, :pageId pageId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"],
     :body StorePage}))

(defn storelayoutpages-delete
  "Deletes a store page.
https://developers.google.com/android/work/play/emm-api/v1/storelayoutpages/delete

enterpriseId <string> The ID of the enterprise.
pageId <string> The ID of the page."
  [enterpriseId pageId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidenterprise.googleapis.com/androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}",
     :uri-template-args {:enterpriseId enterpriseId, :pageId pageId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidenterprise"]}))

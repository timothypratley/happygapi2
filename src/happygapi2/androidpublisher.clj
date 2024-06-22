(ns happygapi2.androidpublisher
  "Google Play Android Developer API
Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to "insert" an Edit, make changes as necessary, and then "commit" it. 
See: https://developers.google.com/android-publisher"
  (:require [happy.oauth2.client :as client]))

(defn orders-refund
  "Refunds a user's subscription or in-app purchase order. Orders older than 3 years cannot be refunded.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which this subscription or in-app item was purchased (for example, 'com.some.thing').
orderId <string> The order ID provided to the user when the subscription or in-app order was purchased.

optional:
revoke <boolean> Whether to revoke the purchased item. If set to true, access to the subscription or in-app item will be terminated immediately. If the item is a recurring subscription, all future payments will also be terminated. Consumed in-app items need to be handled by developer's app. (optional)."
  ([packageName orderId] (orders-refund packageName orderId nil))
  ([packageName orderId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/orders/{orderId}:refund",
       :uri-template-args {:packageName packageName, :orderId orderId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn externaltransactions-createexternaltransaction
  "Creates a new external transaction.
https://developers.google.com/android-publisher

parent <string> Required. The parent resource where this external transaction will be created. Format: applications/{package_name}
ExternalTransaction:
{:packageName string,
 :currentPreTaxAmount {:priceMicros string, :currency string},
 :oneTimeTransaction {:externalTransactionToken string},
 :currentTaxAmount {:priceMicros string, :currency string},
 :transactionTime string,
 :createTime string,
 :externalTransactionId string,
 :transactionState
 [TRANSACTION_STATE_UNSPECIFIED
  TRANSACTION_REPORTED
  TRANSACTION_CANCELED],
 :originalTaxAmount {:priceMicros string, :currency string},
 :originalPreTaxAmount {:priceMicros string, :currency string},
 :testPurchase object,
 :userTaxAddress {:regionCode string, :administrativeArea string},
 :recurringTransaction
 {:initialExternalTransactionId string,
  :externalTransactionToken string,
  :migratedTransactionProgram
  [EXTERNAL_TRANSACTION_PROGRAM_UNSPECIFIED
   USER_CHOICE_BILLING
   ALTERNATIVE_BILLING_ONLY],
  :externalSubscription
  {:subscriptionType
   [SUBSCRIPTION_TYPE_UNSPECIFIED RECURRING PREPAID]},
  :otherRecurringProduct object}}

optional:
externalTransactionId <string> Required. The id to use for the external transaction. Must be unique across all other transactions for the app. This value should be 1-63 characters and valid characters are /a-zA-Z0-9_-/. Do not use this field to store any Personally Identifiable Information (PII) such as emails. Attempting to store PII in this field may result in requests being blocked."
  ([parent ExternalTransaction]
    (externaltransactions-createexternaltransaction
      parent
      ExternalTransaction
      nil))
  ([parent ExternalTransaction optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/{+parent}/externalTransactions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body ExternalTransaction})))

(defn externaltransactions-refundexternaltransaction
  "Refunds or partially refunds an existing external transaction.
https://developers.google.com/android-publisher

name <string> Required. The name of the external transaction that will be refunded. Format: applications/{package_name}/externalTransactions/{external_transaction}
RefundExternalTransactionRequest:
{:partialRefund
 {:refundId string,
  :refundPreTaxAmount {:priceMicros string, :currency string}},
 :fullRefund object,
 :refundTime string}"
  [name RefundExternalTransactionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/{+name}:refund",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body RefundExternalTransactionRequest}))

(defn externaltransactions-getexternaltransaction
  "Gets an existing external transaction.
https://developers.google.com/android-publisher

name <string> Required. The name of the external transaction to retrieve. Format: applications/{package_name}/externalTransactions/{external_transaction}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn generatedapks-list
  "Returns download metadata for all APKs that were generated from a given app bundle.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
versionCode <integer> Version code of the app bundle."
  [packageName versionCode]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/generatedApks/{versionCode}",
     :uri-template-args
     {:packageName packageName, :versionCode versionCode},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn generatedapks-download
  "Downloads a single signed APK generated from an app bundle.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
versionCode <integer> Version code of the app bundle.
downloadId <string> Download ID, which uniquely identifies the APK to download. Can be obtained from the response of `generatedapks.list` method."
  [packageName versionCode downloadId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/generatedApks/{versionCode}/downloads/{downloadId}:download",
     :uri-template-args
     {:packageName packageName,
      :versionCode versionCode,
      :downloadId downloadId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn applications-dataSafety
  "Writes the Safety Labels declaration of an app.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the app.
SafetyLabelsUpdateRequest:
{:safetyLabels string}"
  [packageName SafetyLabelsUpdateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/dataSafety",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body SafetyLabelsUpdateRequest}))

(defn applications-deviceTierConfigs-create
  "Creates a new device tier config for an app.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
DeviceTierConfig:
{:deviceTierConfigId string,
 :deviceGroups
 [{:name string,
   :deviceSelectors
   [{:deviceRam {:minBytes string, :maxBytes string},
     :includedDeviceIds [{:buildBrand string, :buildDevice string}],
     :excludedDeviceIds [{:buildBrand string, :buildDevice string}],
     :requiredSystemFeatures [{:name string}],
     :forbiddenSystemFeatures [{:name string}]}]}],
 :deviceTierSet
 {:deviceTiers [{:deviceGroupNames [string], :level integer}]},
 :userCountrySets [{:name string, :countryCodes [string]}]}

optional:
allowUnknownDevices <boolean> Whether the service should accept device IDs that are unknown to Play's device catalog."
  ([packageName DeviceTierConfig]
    (applications-deviceTierConfigs-create
      packageName
      DeviceTierConfig
      nil))
  ([packageName DeviceTierConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/deviceTierConfigs",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body DeviceTierConfig})))

(defn applications-deviceTierConfigs-get
  "Returns a particular device tier config.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
deviceTierConfigId <string> Required. Id of an existing device tier config."
  [packageName deviceTierConfigId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/deviceTierConfigs/{deviceTierConfigId}",
     :uri-template-args
     {:packageName packageName,
      :deviceTierConfigId deviceTierConfigId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn applications-deviceTierConfigs-list
  "Returns created device tier configs, ordered by descending creation time.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.

optional:
pageSize <integer> The maximum number of device tier configs to return. The service may return fewer than this value. If unspecified, at most 10 device tier configs will be returned. The maximum value for this field is 100; values above 100 will be coerced to 100. Device tier configs will be ordered by descending creation time."
  ([packageName] (applications-deviceTierConfigs-list packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/deviceTierConfigs",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn inappproducts-get
  "Gets an in-app product, which can be a managed product or a subscription. This method should no longer be used to retrieve subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
sku <string> Unique identifier for the in-app product."
  [packageName sku]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts/{sku}",
     :uri-template-args {:packageName packageName, :sku sku},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn inappproducts-insert
  "Creates an in-app product (a managed product or a subscription). This method should no longer be used to create subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
InAppProduct:
{:packageName string,
 :subscriptionTaxesAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :purchaseType [purchaseTypeUnspecified managedUser subscription],
 :sku string,
 :prices object,
 :trialPeriod string,
 :status [statusUnspecified active inactive],
 :subscriptionPeriod string,
 :gracePeriod string,
 :managedProductTaxesAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :defaultPrice {:priceMicros string, :currency string},
 :listings object,
 :defaultLanguage string}

optional:
autoConvertMissingPrices <boolean> If true the prices for all regions targeted by the parent app that don't have a price specified for this in-app product will be auto converted to the target currency based on the default price. Defaults to false."
  ([packageName InAppProduct]
    (inappproducts-insert packageName InAppProduct nil))
  ([packageName InAppProduct optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body InAppProduct})))

(defn inappproducts-patch
  "Patches an in-app product (a managed product or a subscription). This method should no longer be used to update subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
sku <string> Unique identifier for the in-app product.
InAppProduct:
{:packageName string,
 :subscriptionTaxesAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :purchaseType [purchaseTypeUnspecified managedUser subscription],
 :sku string,
 :prices object,
 :trialPeriod string,
 :status [statusUnspecified active inactive],
 :subscriptionPeriod string,
 :gracePeriod string,
 :managedProductTaxesAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :defaultPrice {:priceMicros string, :currency string},
 :listings object,
 :defaultLanguage string}

optional:
autoConvertMissingPrices <boolean> If true the prices for all regions targeted by the parent app that don't have a price specified for this in-app product will be auto converted to the target currency based on the default price. Defaults to false.
latencyTolerance <string> Optional. The latency tolerance for the propagation of this product update. Defaults to latency-sensitive."
  ([packageName sku InAppProduct]
    (inappproducts-patch packageName sku InAppProduct nil))
  ([packageName sku InAppProduct optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts/{sku}",
       :uri-template-args {:packageName packageName, :sku sku},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body InAppProduct})))

(defn inappproducts-batchUpdate
  "Updates or inserts one or more in-app products (managed products or subscriptions). Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput. This method should no longer be used to update subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
InappproductsBatchUpdateRequest:
{:requests
 [{:packageName string,
   :sku string,
   :autoConvertMissingPrices boolean,
   :inappproduct
   {:packageName string,
    :subscriptionTaxesAndComplianceSettings
    {:eeaWithdrawalRightType
     [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
      WITHDRAWAL_RIGHT_DIGITAL_CONTENT
      WITHDRAWAL_RIGHT_SERVICE],
     :taxRateInfoByRegionCode object,
     :isTokenizedDigitalAsset boolean},
    :purchaseType [purchaseTypeUnspecified managedUser subscription],
    :sku string,
    :prices object,
    :trialPeriod string,
    :status [statusUnspecified active inactive],
    :subscriptionPeriod string,
    :gracePeriod string,
    :managedProductTaxesAndComplianceSettings
    {:eeaWithdrawalRightType
     [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
      WITHDRAWAL_RIGHT_DIGITAL_CONTENT
      WITHDRAWAL_RIGHT_SERVICE],
     :taxRateInfoByRegionCode object,
     :isTokenizedDigitalAsset boolean},
    :defaultPrice {:priceMicros string, :currency string},
    :listings object,
    :defaultLanguage string},
   :allowMissing boolean,
   :latencyTolerance
   [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}]}"
  [packageName InappproductsBatchUpdateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts:batchUpdate",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body InappproductsBatchUpdateRequest}))

(defn inappproducts-batchGet
  "Reads multiple in-app products, which can be managed products or subscriptions. This method should not be used to retrieve subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.

optional:
sku <string> Unique identifier for the in-app products."
  ([packageName] (inappproducts-batchGet packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts:batchGet",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn inappproducts-update
  "Updates an in-app product (a managed product or a subscription). This method should no longer be used to update subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
sku <string> Unique identifier for the in-app product.
InAppProduct:
{:packageName string,
 :subscriptionTaxesAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :purchaseType [purchaseTypeUnspecified managedUser subscription],
 :sku string,
 :prices object,
 :trialPeriod string,
 :status [statusUnspecified active inactive],
 :subscriptionPeriod string,
 :gracePeriod string,
 :managedProductTaxesAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :defaultPrice {:priceMicros string, :currency string},
 :listings object,
 :defaultLanguage string}

optional:
autoConvertMissingPrices <boolean> If true the prices for all regions targeted by the parent app that don't have a price specified for this in-app product will be auto converted to the target currency based on the default price. Defaults to false.
allowMissing <boolean> If set to true, and the in-app product with the given package_name and sku doesn't exist, the in-app product will be created.
latencyTolerance <string> Optional. The latency tolerance for the propagation of this product update. Defaults to latency-sensitive."
  ([packageName sku InAppProduct]
    (inappproducts-update packageName sku InAppProduct nil))
  ([packageName sku InAppProduct optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts/{sku}",
       :uri-template-args {:packageName packageName, :sku sku},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body InAppProduct})))

(defn inappproducts-delete
  "Deletes an in-app product (a managed product or a subscription). This method should no longer be used to delete subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
sku <string> Unique identifier for the in-app product.

optional:
latencyTolerance <string> Optional. The latency tolerance for the propagation of this product update. Defaults to latency-sensitive."
  ([packageName sku] (inappproducts-delete packageName sku nil))
  ([packageName sku optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts/{sku}",
       :uri-template-args {:packageName packageName, :sku sku},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn inappproducts-batchDelete
  "Deletes in-app products (managed products or subscriptions). Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput. This method should not be used to delete subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
InappproductsBatchDeleteRequest:
{:requests
 [{:packageName string,
   :sku string,
   :latencyTolerance
   [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}]}"
  [packageName InappproductsBatchDeleteRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts:batchDelete",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body InappproductsBatchDeleteRequest}))

(defn inappproducts-list
  "Lists all in-app products - both managed products and subscriptions. If an app has a large number of in-app products, the response may be paginated. In this case the response field `tokenPagination.nextPageToken` will be set and the caller should provide its value as a `token` request parameter to retrieve the next page. This method should no longer be used to retrieve subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.

optional:
token <string> Pagination token. If empty, list starts at the first product.
startIndex <integer> Deprecated and ignored. Set the `token` parameter to retrieve the next page.
maxResults <integer> Deprecated and ignored. The page size is determined by the server."
  ([packageName] (inappproducts-list packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/inappproducts",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn internalappsharingartifacts-uploadapk
  "Uploads an APK to internal app sharing. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See [Timeouts and Errors](https://developers.google.com/api-client-library/java/google-api-java-client/errors) for an example in java.
https://developers.google.com/android-publisher

packageName <string> Package name of the app."
  [packageName]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/internalappsharing/{packageName}/artifacts/apk",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn internalappsharingartifacts-uploadbundle
  "Uploads an app bundle to internal app sharing. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See [Timeouts and Errors](https://developers.google.com/api-client-library/java/google-api-java-client/errors) for an example in java.
https://developers.google.com/android-publisher

packageName <string> Package name of the app."
  [packageName]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/internalappsharing/{packageName}/artifacts/bundle",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn grants-create
  "Grant access for a user to the given package.
https://developers.google.com/android-publisher

parent <string> Required. The user which needs permission. Format: developers/{developer}/users/{user}
Grant:
{:name string,
 :packageName string,
 :appLevelPermissions
 [[APP_LEVEL_PERMISSION_UNSPECIFIED
   CAN_ACCESS_APP
   CAN_VIEW_FINANCIAL_DATA
   CAN_MANAGE_PERMISSIONS
   CAN_REPLY_TO_REVIEWS
   CAN_MANAGE_PUBLIC_APKS
   CAN_MANAGE_TRACK_APKS
   CAN_MANAGE_TRACK_USERS
   CAN_MANAGE_PUBLIC_LISTING
   CAN_MANAGE_DRAFT_APPS
   CAN_MANAGE_ORDERS
   CAN_MANAGE_APP_CONTENT
   CAN_VIEW_NON_FINANCIAL_DATA
   CAN_VIEW_APP_QUALITY
   CAN_MANAGE_DEEPLINKS]]}"
  [parent Grant]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/{+parent}/grants",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Grant}))

(defn grants-patch
  "Updates access for the user to the given package.
https://developers.google.com/android-publisher

name <string> Required. Resource name for this grant, following the pattern \"developers/{developer}/users/{email}/grants/{package_name}\". If this grant is for a draft app, the app ID will be used in this resource name instead of the package name.
Grant:
{:name string,
 :packageName string,
 :appLevelPermissions
 [[APP_LEVEL_PERMISSION_UNSPECIFIED
   CAN_ACCESS_APP
   CAN_VIEW_FINANCIAL_DATA
   CAN_MANAGE_PERMISSIONS
   CAN_REPLY_TO_REVIEWS
   CAN_MANAGE_PUBLIC_APKS
   CAN_MANAGE_TRACK_APKS
   CAN_MANAGE_TRACK_USERS
   CAN_MANAGE_PUBLIC_LISTING
   CAN_MANAGE_DRAFT_APPS
   CAN_MANAGE_ORDERS
   CAN_MANAGE_APP_CONTENT
   CAN_VIEW_NON_FINANCIAL_DATA
   CAN_VIEW_APP_QUALITY
   CAN_MANAGE_DEEPLINKS]]}

optional:
updateMask <string> Optional. The list of fields to be updated."
  ([name Grant] (grants-patch name Grant nil))
  ([name Grant optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body Grant})))

(defn grants-delete
  "Removes all access for the user to the given package or developer account.
https://developers.google.com/android-publisher

name <string> Required. The name of the grant to delete. Format: developers/{developer}/users/{email}/grants/{package_name}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn monetization-convertRegionPrices
  "Calculates the region prices, using today's exchange rate and country-specific pricing patterns, based on the price in the request for a set of regions.
https://developers.google.com/android-publisher

packageName <string> Required. The app package name.
ConvertRegionPricesRequest:
{:price {:currencyCode string, :units string, :nanos integer}}"
  [packageName ConvertRegionPricesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/pricing:convertRegionPrices",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ConvertRegionPricesRequest}))

(defn monetization-subscriptions-get
  "Reads a single subscription.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the subscription to get.
productId <string> Required. The unique product ID of the subscription to get."
  [packageName productId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}",
     :uri-template-args
     {:packageName packageName, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn monetization-subscriptions-batchGet
  "Reads one or more subscriptions.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the subscriptions should be retrieved. Must be equal to the package_name field on all the requests.

optional:
productIds <string> Required. A list of up to 100 subscription product IDs to retrieve. All the IDs must be different."
  ([packageName] (monetization-subscriptions-batchGet packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions:batchGet",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn monetization-subscriptions-list
  "Lists all subscriptions under a given app.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the subscriptions should be read.

optional:
pageSize <integer> The maximum number of subscriptions to return. The service may return fewer than this value. If unspecified, at most 50 subscriptions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
showArchived <boolean> Deprecated: subscription archiving is not supported."
  ([packageName] (monetization-subscriptions-list packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn monetization-subscriptions-create
  "Creates a new subscription. Newly added base plans will remain in draft state until activated.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the subscription should be created. Must be equal to the package_name field on the Subscription resource.
Subscription:
{:packageName string,
 :productId string,
 :basePlans
 [{:basePlanId string,
   :state [STATE_UNSPECIFIED DRAFT ACTIVE INACTIVE],
   :autoRenewingBasePlanType
   {:billingPeriodDuration string,
    :gracePeriodDuration string,
    :accountHoldDuration string,
    :resubscribeState
    [RESUBSCRIBE_STATE_UNSPECIFIED
     RESUBSCRIBE_STATE_ACTIVE
     RESUBSCRIBE_STATE_INACTIVE],
    :prorationMode
    [SUBSCRIPTION_PRORATION_MODE_UNSPECIFIED
     SUBSCRIPTION_PRORATION_MODE_CHARGE_ON_NEXT_BILLING_DATE
     SUBSCRIPTION_PRORATION_MODE_CHARGE_FULL_PRICE_IMMEDIATELY],
    :legacyCompatible boolean,
    :legacyCompatibleSubscriptionOfferId string},
   :prepaidBasePlanType
   {:billingPeriodDuration string,
    :timeExtension
    [TIME_EXTENSION_UNSPECIFIED
     TIME_EXTENSION_ACTIVE
     TIME_EXTENSION_INACTIVE]},
   :installmentsBasePlanType
   {:billingPeriodDuration string,
    :committedPaymentsCount integer,
    :renewalType
    [RENEWAL_TYPE_UNSPECIFIED
     RENEWAL_TYPE_RENEWS_WITHOUT_COMMITMENT
     RENEWAL_TYPE_RENEWS_WITH_COMMITMENT],
    :gracePeriodDuration string,
    :accountHoldDuration string,
    :resubscribeState
    [RESUBSCRIBE_STATE_UNSPECIFIED
     RESUBSCRIBE_STATE_ACTIVE
     RESUBSCRIBE_STATE_INACTIVE],
    :prorationMode
    [SUBSCRIPTION_PRORATION_MODE_UNSPECIFIED
     SUBSCRIPTION_PRORATION_MODE_CHARGE_ON_NEXT_BILLING_DATE
     SUBSCRIPTION_PRORATION_MODE_CHARGE_FULL_PRICE_IMMEDIATELY]},
   :regionalConfigs
   [{:regionCode string,
     :newSubscriberAvailability boolean,
     :price {:currencyCode string, :units string, :nanos integer}}],
   :offerTags [{:tag string}],
   :otherRegionsConfig
   {:usdPrice {:currencyCode string, :units string, :nanos integer},
    :eurPrice {:currencyCode string, :units string, :nanos integer},
    :newSubscriberAvailability boolean}}],
 :listings
 [{:languageCode string,
   :title string,
   :benefits [string],
   :description string}],
 :archived boolean,
 :taxAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :restrictedPaymentCountries {:regionCodes [string]}}

optional:
productId <string> Required. The ID to use for the subscription. For the requirements on this format, see the documentation of the product_id field on the Subscription resource.
regionsVersion.version <string> Required. A string representing the version of available regions being used for the specified resource. Regional prices for the resource have to be specified according to the information published in [this article](https://support.google.com/googleplay/android-developer/answer/10532353). Each time the supported locations substantially change, the version will be incremented. Using this field will ensure that creating and updating the resource with an older region's version and set of regional prices and currencies will succeed even though a new version is available. The latest version is 2022/02."
  ([packageName Subscription]
    (monetization-subscriptions-create packageName Subscription nil))
  ([packageName Subscription optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body Subscription})))

(defn monetization-subscriptions-patch
  "Updates an existing subscription.
https://developers.google.com/android-publisher

packageName <string> Immutable. Package name of the parent app.
productId <string> Immutable. Unique product ID of the product. Unique within the parent app. Product IDs must be composed of lower-case letters (a-z), numbers (0-9), underscores (_) and dots (.). It must start with a lower-case letter or number, and be between 1 and 40 (inclusive) characters in length.
Subscription:
{:packageName string,
 :productId string,
 :basePlans
 [{:basePlanId string,
   :state [STATE_UNSPECIFIED DRAFT ACTIVE INACTIVE],
   :autoRenewingBasePlanType
   {:billingPeriodDuration string,
    :gracePeriodDuration string,
    :accountHoldDuration string,
    :resubscribeState
    [RESUBSCRIBE_STATE_UNSPECIFIED
     RESUBSCRIBE_STATE_ACTIVE
     RESUBSCRIBE_STATE_INACTIVE],
    :prorationMode
    [SUBSCRIPTION_PRORATION_MODE_UNSPECIFIED
     SUBSCRIPTION_PRORATION_MODE_CHARGE_ON_NEXT_BILLING_DATE
     SUBSCRIPTION_PRORATION_MODE_CHARGE_FULL_PRICE_IMMEDIATELY],
    :legacyCompatible boolean,
    :legacyCompatibleSubscriptionOfferId string},
   :prepaidBasePlanType
   {:billingPeriodDuration string,
    :timeExtension
    [TIME_EXTENSION_UNSPECIFIED
     TIME_EXTENSION_ACTIVE
     TIME_EXTENSION_INACTIVE]},
   :installmentsBasePlanType
   {:billingPeriodDuration string,
    :committedPaymentsCount integer,
    :renewalType
    [RENEWAL_TYPE_UNSPECIFIED
     RENEWAL_TYPE_RENEWS_WITHOUT_COMMITMENT
     RENEWAL_TYPE_RENEWS_WITH_COMMITMENT],
    :gracePeriodDuration string,
    :accountHoldDuration string,
    :resubscribeState
    [RESUBSCRIBE_STATE_UNSPECIFIED
     RESUBSCRIBE_STATE_ACTIVE
     RESUBSCRIBE_STATE_INACTIVE],
    :prorationMode
    [SUBSCRIPTION_PRORATION_MODE_UNSPECIFIED
     SUBSCRIPTION_PRORATION_MODE_CHARGE_ON_NEXT_BILLING_DATE
     SUBSCRIPTION_PRORATION_MODE_CHARGE_FULL_PRICE_IMMEDIATELY]},
   :regionalConfigs
   [{:regionCode string,
     :newSubscriberAvailability boolean,
     :price {:currencyCode string, :units string, :nanos integer}}],
   :offerTags [{:tag string}],
   :otherRegionsConfig
   {:usdPrice {:currencyCode string, :units string, :nanos integer},
    :eurPrice {:currencyCode string, :units string, :nanos integer},
    :newSubscriberAvailability boolean}}],
 :listings
 [{:languageCode string,
   :title string,
   :benefits [string],
   :description string}],
 :archived boolean,
 :taxAndComplianceSettings
 {:eeaWithdrawalRightType
  [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
   WITHDRAWAL_RIGHT_DIGITAL_CONTENT
   WITHDRAWAL_RIGHT_SERVICE],
  :taxRateInfoByRegionCode object,
  :isTokenizedDigitalAsset boolean},
 :restrictedPaymentCountries {:regionCodes [string]}}

optional:
updateMask <string> Required. The list of fields to be updated.
regionsVersion.version <string> Required. A string representing the version of available regions being used for the specified resource. Regional prices for the resource have to be specified according to the information published in [this article](https://support.google.com/googleplay/android-developer/answer/10532353). Each time the supported locations substantially change, the version will be incremented. Using this field will ensure that creating and updating the resource with an older region's version and set of regional prices and currencies will succeed even though a new version is available. The latest version is 2022/02.
allowMissing <boolean> Optional. If set to true, and the subscription with the given package_name and product_id doesn't exist, the subscription will be created. If a new subscription is created, update_mask is ignored.
latencyTolerance <string> Optional. The latency tolerance for the propagation of this product update. Defaults to latency-sensitive."
  ([packageName productId Subscription]
    (monetization-subscriptions-patch
      packageName
      productId
      Subscription
      nil))
  ([packageName productId Subscription optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}",
       :uri-template-args
       {:packageName packageName, :productId productId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body Subscription})))

(defn monetization-subscriptions-batchUpdate
  "Updates a batch of subscriptions. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the subscriptions should be updated. Must be equal to the package_name field on all the Subscription resources.
BatchUpdateSubscriptionsRequest:
{:requests
 [{:subscription
   {:packageName string,
    :productId string,
    :basePlans
    [{:basePlanId string,
      :state [STATE_UNSPECIFIED DRAFT ACTIVE INACTIVE],
      :autoRenewingBasePlanType
      {:billingPeriodDuration string,
       :gracePeriodDuration string,
       :accountHoldDuration string,
       :resubscribeState
       [RESUBSCRIBE_STATE_UNSPECIFIED
        RESUBSCRIBE_STATE_ACTIVE
        RESUBSCRIBE_STATE_INACTIVE],
       :prorationMode
       [SUBSCRIPTION_PRORATION_MODE_UNSPECIFIED
        SUBSCRIPTION_PRORATION_MODE_CHARGE_ON_NEXT_BILLING_DATE
        SUBSCRIPTION_PRORATION_MODE_CHARGE_FULL_PRICE_IMMEDIATELY],
       :legacyCompatible boolean,
       :legacyCompatibleSubscriptionOfferId string},
      :prepaidBasePlanType
      {:billingPeriodDuration string,
       :timeExtension
       [TIME_EXTENSION_UNSPECIFIED
        TIME_EXTENSION_ACTIVE
        TIME_EXTENSION_INACTIVE]},
      :installmentsBasePlanType
      {:billingPeriodDuration string,
       :committedPaymentsCount integer,
       :renewalType
       [RENEWAL_TYPE_UNSPECIFIED
        RENEWAL_TYPE_RENEWS_WITHOUT_COMMITMENT
        RENEWAL_TYPE_RENEWS_WITH_COMMITMENT],
       :gracePeriodDuration string,
       :accountHoldDuration string,
       :resubscribeState
       [RESUBSCRIBE_STATE_UNSPECIFIED
        RESUBSCRIBE_STATE_ACTIVE
        RESUBSCRIBE_STATE_INACTIVE],
       :prorationMode
       [SUBSCRIPTION_PRORATION_MODE_UNSPECIFIED
        SUBSCRIPTION_PRORATION_MODE_CHARGE_ON_NEXT_BILLING_DATE
        SUBSCRIPTION_PRORATION_MODE_CHARGE_FULL_PRICE_IMMEDIATELY]},
      :regionalConfigs
      [{:regionCode string,
        :newSubscriberAvailability boolean,
        :price Money}],
      :offerTags [{:tag string}],
      :otherRegionsConfig
      {:usdPrice Money,
       :eurPrice Money,
       :newSubscriberAvailability boolean}}],
    :listings
    [{:languageCode string,
      :title string,
      :benefits [string],
      :description string}],
    :archived boolean,
    :taxAndComplianceSettings
    {:eeaWithdrawalRightType
     [WITHDRAWAL_RIGHT_TYPE_UNSPECIFIED
      WITHDRAWAL_RIGHT_DIGITAL_CONTENT
      WITHDRAWAL_RIGHT_SERVICE],
     :taxRateInfoByRegionCode object,
     :isTokenizedDigitalAsset boolean},
    :restrictedPaymentCountries {:regionCodes [string]}},
   :updateMask string,
   :regionsVersion {:version string},
   :allowMissing boolean,
   :latencyTolerance
   [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}]}"
  [packageName BatchUpdateSubscriptionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions:batchUpdate",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body BatchUpdateSubscriptionsRequest}))

(defn monetization-subscriptions-delete
  "Deletes a subscription. A subscription can only be deleted if it has never had a base plan published.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the app of the subscription to delete.
productId <string> Required. The unique product ID of the subscription to delete."
  [packageName productId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}",
     :uri-template-args
     {:packageName packageName, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn monetization-subscriptions-archive
  "Deprecated: subscription archiving is not supported.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the app of the subscription to delete.
productId <string> Required. The unique product ID of the subscription to delete.
ArchiveSubscriptionRequest:
object"
  [packageName productId ArchiveSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}:archive",
     :uri-template-args
     {:packageName packageName, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ArchiveSubscriptionRequest}))

(defn monetization-subscriptions-basePlans-delete
  "Deletes a base plan. Can only be done for draft base plans. This action is irreversible.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the base plan to delete.
productId <string> Required. The parent subscription (ID) of the base plan to delete.
basePlanId <string> Required. The unique offer ID of the base plan to delete."
  [packageName productId basePlanId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn monetization-subscriptions-basePlans-activate
  "Activates a base plan. Once activated, base plans will be available to new subscribers.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the base plan to activate.
productId <string> Required. The parent subscription (ID) of the base plan to activate.
basePlanId <string> Required. The unique base plan ID of the base plan to activate.
ActivateBasePlanRequest:
{:packageName string,
 :productId string,
 :basePlanId string,
 :latencyTolerance
 [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}"
  [packageName productId basePlanId ActivateBasePlanRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}:activate",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ActivateBasePlanRequest}))

(defn monetization-subscriptions-basePlans-deactivate
  "Deactivates a base plan. Once deactivated, the base plan will become unavailable to new subscribers, but existing subscribers will maintain their subscription
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the base plan to deactivate.
productId <string> Required. The parent subscription (ID) of the base plan to deactivate.
basePlanId <string> Required. The unique base plan ID of the base plan to deactivate.
DeactivateBasePlanRequest:
{:packageName string,
 :productId string,
 :basePlanId string,
 :latencyTolerance
 [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}"
  [packageName productId basePlanId DeactivateBasePlanRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}:deactivate",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body DeactivateBasePlanRequest}))

(defn monetization-subscriptions-basePlans-batchUpdateStates
  "Activates or deactivates base plans across one or multiple subscriptions. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the updated base plans.
productId <string> Required. The product ID of the parent subscription, if all updated base plans belong to the same subscription. If this batch update spans multiple subscriptions, set this field to \"-\". Must be set.
BatchUpdateBasePlanStatesRequest:
{:requests
 [{:activateBasePlanRequest
   {:packageName string,
    :productId string,
    :basePlanId string,
    :latencyTolerance
    [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]},
   :deactivateBasePlanRequest
   {:packageName string,
    :productId string,
    :basePlanId string,
    :latencyTolerance
    [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}}]}"
  [packageName productId BatchUpdateBasePlanStatesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans:batchUpdateStates",
     :uri-template-args
     {:packageName packageName, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body BatchUpdateBasePlanStatesRequest}))

(defn monetization-subscriptions-basePlans-migratePrices
  "Migrates subscribers who are receiving an historical subscription price to the currently-offered price for the specified region. Requests will cause price change notifications to be sent to users who are currently receiving an historical price older than the supplied timestamp. Subscribers who do not agree to the new price will have their subscription ended at the next renewal.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the parent app. Must be equal to the package_name field on the Subscription resource.
productId <string> Required. The ID of the subscription to update. Must be equal to the product_id field on the Subscription resource.
basePlanId <string> Required. The unique base plan ID of the base plan to update prices on.
MigrateBasePlanPricesRequest:
{:packageName string,
 :productId string,
 :basePlanId string,
 :regionalPriceMigrations
 [{:regionCode string,
   :oldestAllowedPriceVersionTime string,
   :priceIncreaseType
   [PRICE_INCREASE_TYPE_UNSPECIFIED
    PRICE_INCREASE_TYPE_OPT_IN
    PRICE_INCREASE_TYPE_OPT_OUT]}],
 :regionsVersion {:version string},
 :latencyTolerance
 [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}"
  [packageName productId basePlanId MigrateBasePlanPricesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}:migratePrices",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body MigrateBasePlanPricesRequest}))

(defn monetization-subscriptions-basePlans-batchMigratePrices
  "Batch variant of the MigrateBasePlanPrices endpoint. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the subscriptions should be created or updated. Must be equal to the package_name field on all the Subscription resources.
productId <string> Required. The product ID of the parent subscription, if all updated offers belong to the same subscription. If this batch update spans multiple subscriptions, set this field to \"-\". Must be set.
BatchMigrateBasePlanPricesRequest:
{:requests
 [{:packageName string,
   :productId string,
   :basePlanId string,
   :regionalPriceMigrations
   [{:regionCode string,
     :oldestAllowedPriceVersionTime string,
     :priceIncreaseType
     [PRICE_INCREASE_TYPE_UNSPECIFIED
      PRICE_INCREASE_TYPE_OPT_IN
      PRICE_INCREASE_TYPE_OPT_OUT]}],
   :regionsVersion {:version string},
   :latencyTolerance
   [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}]}"
  [packageName productId BatchMigrateBasePlanPricesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans:batchMigratePrices",
     :uri-template-args
     {:packageName packageName, :productId productId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body BatchMigrateBasePlanPricesRequest}))

(defn monetization-subscriptions-basePlans-offers-get
  "Reads a single offer
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the offer to get.
productId <string> Required. The parent subscription (ID) of the offer to get.
basePlanId <string> Required. The parent base plan (ID) of the offer to get.
offerId <string> Required. The unique offer ID of the offer to get."
  [packageName productId basePlanId offerId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId,
      :offerId offerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn monetization-subscriptions-basePlans-offers-batchUpdateStates
  "Updates a batch of subscription offer states. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the updated subscription offers. Must be equal to the package_name field on all the updated SubscriptionOffer resources.
productId <string> Required. The product ID of the parent subscription, if all updated offers belong to the same subscription. If this request spans multiple subscriptions, set this field to \"-\". Must be set.
basePlanId <string> Required. The parent base plan (ID) for which the offers should be updated. May be specified as '-' to update offers from multiple base plans.
BatchUpdateSubscriptionOfferStatesRequest:
{:requests
 [{:activateSubscriptionOfferRequest
   {:packageName string,
    :productId string,
    :basePlanId string,
    :offerId string,
    :latencyTolerance
    [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]},
   :deactivateSubscriptionOfferRequest
   {:packageName string,
    :productId string,
    :basePlanId string,
    :offerId string,
    :latencyTolerance
    [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
     PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}}]}"
  [packageName
   productId
   basePlanId
   BatchUpdateSubscriptionOfferStatesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers:batchUpdateStates",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body BatchUpdateSubscriptionOfferStatesRequest}))

(defn monetization-subscriptions-basePlans-offers-patch
  "Updates an existing subscription offer.
https://developers.google.com/android-publisher

packageName <string> Required. Immutable. The package name of the app the parent subscription belongs to.
productId <string> Required. Immutable. The ID of the parent subscription this offer belongs to.
basePlanId <string> Required. Immutable. The ID of the base plan to which this offer is an extension.
offerId <string> Required. Immutable. Unique ID of this subscription offer. Must be unique within the base plan.
SubscriptionOffer:
{:packageName string,
 :regionalConfigs
 [{:regionCode string, :newSubscriberAvailability boolean}],
 :basePlanId string,
 :state [STATE_UNSPECIFIED DRAFT ACTIVE INACTIVE],
 :productId string,
 :offerTags [{:tag string}],
 :otherRegionsConfig {:otherRegionsNewSubscriberAvailability boolean},
 :offerId string,
 :phases
 [{:recurrenceCount integer,
   :duration string,
   :regionalConfigs
   [{:regionCode string,
     :price {:currencyCode string, :units string, :nanos integer},
     :relativeDiscount number,
     :absoluteDiscount
     {:currencyCode string, :units string, :nanos integer},
     :free object}],
   :otherRegionsConfig
   {:otherRegionsPrices
    {:usdPrice {:currencyCode string, :units string, :nanos integer},
     :eurPrice {:currencyCode string, :units string, :nanos integer}},
    :relativeDiscount number,
    :absoluteDiscounts
    {:usdPrice {:currencyCode string, :units string, :nanos integer},
     :eurPrice {:currencyCode string, :units string, :nanos integer}},
    :free object}}],
 :targeting
 {:acquisitionRule
  {:scope
   {:thisSubscription object,
    :anySubscriptionInApp object,
    :specificSubscriptionInApp string}},
  :upgradeRule
  {:oncePerUser boolean,
   :scope
   {:thisSubscription object,
    :anySubscriptionInApp object,
    :specificSubscriptionInApp string},
   :billingPeriodDuration string}}}

optional:
updateMask <string> Required. The list of fields to be updated.
regionsVersion.version <string> Required. A string representing the version of available regions being used for the specified resource. Regional prices for the resource have to be specified according to the information published in [this article](https://support.google.com/googleplay/android-developer/answer/10532353). Each time the supported locations substantially change, the version will be incremented. Using this field will ensure that creating and updating the resource with an older region's version and set of regional prices and currencies will succeed even though a new version is available. The latest version is 2022/02.
allowMissing <boolean> Optional. If set to true, and the subscription offer with the given package_name, product_id, base_plan_id and offer_id doesn't exist, an offer will be created. If a new offer is created, update_mask is ignored.
latencyTolerance <string> Optional. The latency tolerance for the propagation of this product update. Defaults to latency-sensitive."
  ([packageName productId basePlanId offerId SubscriptionOffer]
    (monetization-subscriptions-basePlans-offers-patch
      packageName
      productId
      basePlanId
      offerId
      SubscriptionOffer
      nil))
  ([packageName
    productId
    basePlanId
    offerId
    SubscriptionOffer
    optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}",
       :uri-template-args
       {:packageName packageName,
        :productId productId,
        :basePlanId basePlanId,
        :offerId offerId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body SubscriptionOffer})))

(defn monetization-subscriptions-basePlans-offers-batchUpdate
  "Updates a batch of subscription offers. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the updated subscription offers. Must be equal to the package_name field on all the updated SubscriptionOffer resources.
productId <string> Required. The product ID of the parent subscription, if all updated offers belong to the same subscription. If this request spans multiple subscriptions, set this field to \"-\". Must be set.
basePlanId <string> Required. The parent base plan (ID) for which the offers should be updated. May be specified as '-' to update offers from multiple base plans.
BatchUpdateSubscriptionOffersRequest:
{:requests
 [{:subscriptionOffer
   {:packageName string,
    :regionalConfigs
    [{:regionCode string, :newSubscriberAvailability boolean}],
    :basePlanId string,
    :state [STATE_UNSPECIFIED DRAFT ACTIVE INACTIVE],
    :productId string,
    :offerTags [{:tag string}],
    :otherRegionsConfig
    {:otherRegionsNewSubscriberAvailability boolean},
    :offerId string,
    :phases
    [{:recurrenceCount integer,
      :duration string,
      :regionalConfigs
      [{:regionCode string,
        :price Money,
        :relativeDiscount number,
        :absoluteDiscount Money,
        :free RegionalSubscriptionOfferPhaseFreePriceOverride}],
      :otherRegionsConfig
      {:otherRegionsPrices OtherRegionsSubscriptionOfferPhasePrices,
       :relativeDiscount number,
       :absoluteDiscounts OtherRegionsSubscriptionOfferPhasePrices,
       :free OtherRegionsSubscriptionOfferPhaseFreePriceOverride}}],
    :targeting
    {:acquisitionRule {:scope TargetingRuleScope},
     :upgradeRule
     {:oncePerUser boolean,
      :scope TargetingRuleScope,
      :billingPeriodDuration string}}},
   :updateMask string,
   :regionsVersion {:version string},
   :allowMissing boolean,
   :latencyTolerance
   [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
    PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}]}"
  [packageName
   productId
   basePlanId
   BatchUpdateSubscriptionOffersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers:batchUpdate",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body BatchUpdateSubscriptionOffersRequest}))

(defn monetization-subscriptions-basePlans-offers-create
  "Creates a new subscription offer. Only auto-renewing base plans can have subscription offers. The offer state will be DRAFT until it is activated.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the offer should be created. Must be equal to the package_name field on the Subscription resource.
productId <string> Required. The parent subscription (ID) for which the offer should be created. Must be equal to the product_id field on the SubscriptionOffer resource.
basePlanId <string> Required. The parent base plan (ID) for which the offer should be created. Must be equal to the base_plan_id field on the SubscriptionOffer resource.
SubscriptionOffer:
{:packageName string,
 :regionalConfigs
 [{:regionCode string, :newSubscriberAvailability boolean}],
 :basePlanId string,
 :state [STATE_UNSPECIFIED DRAFT ACTIVE INACTIVE],
 :productId string,
 :offerTags [{:tag string}],
 :otherRegionsConfig {:otherRegionsNewSubscriberAvailability boolean},
 :offerId string,
 :phases
 [{:recurrenceCount integer,
   :duration string,
   :regionalConfigs
   [{:regionCode string,
     :price {:currencyCode string, :units string, :nanos integer},
     :relativeDiscount number,
     :absoluteDiscount
     {:currencyCode string, :units string, :nanos integer},
     :free object}],
   :otherRegionsConfig
   {:otherRegionsPrices
    {:usdPrice {:currencyCode string, :units string, :nanos integer},
     :eurPrice {:currencyCode string, :units string, :nanos integer}},
    :relativeDiscount number,
    :absoluteDiscounts
    {:usdPrice {:currencyCode string, :units string, :nanos integer},
     :eurPrice {:currencyCode string, :units string, :nanos integer}},
    :free object}}],
 :targeting
 {:acquisitionRule
  {:scope
   {:thisSubscription object,
    :anySubscriptionInApp object,
    :specificSubscriptionInApp string}},
  :upgradeRule
  {:oncePerUser boolean,
   :scope
   {:thisSubscription object,
    :anySubscriptionInApp object,
    :specificSubscriptionInApp string},
   :billingPeriodDuration string}}}

optional:
offerId <string> Required. The ID to use for the offer. For the requirements on this format, see the documentation of the offer_id field on the SubscriptionOffer resource.
regionsVersion.version <string> Required. A string representing the version of available regions being used for the specified resource. Regional prices for the resource have to be specified according to the information published in [this article](https://support.google.com/googleplay/android-developer/answer/10532353). Each time the supported locations substantially change, the version will be incremented. Using this field will ensure that creating and updating the resource with an older region's version and set of regional prices and currencies will succeed even though a new version is available. The latest version is 2022/02."
  ([packageName productId basePlanId SubscriptionOffer]
    (monetization-subscriptions-basePlans-offers-create
      packageName
      productId
      basePlanId
      SubscriptionOffer
      nil))
  ([packageName productId basePlanId SubscriptionOffer optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers",
       :uri-template-args
       {:packageName packageName,
        :productId productId,
        :basePlanId basePlanId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body SubscriptionOffer})))

(defn monetization-subscriptions-basePlans-offers-batchGet
  "Reads one or more subscription offers.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the subscriptions should be created or updated. Must be equal to the package_name field on all the requests.
productId <string> Required. The product ID of the parent subscription, if all updated offers belong to the same subscription. If this request spans multiple subscriptions, set this field to \"-\". Must be set.
basePlanId <string> Required. The parent base plan (ID) for which the offers should be read. May be specified as '-' to read offers from multiple base plans.
BatchGetSubscriptionOffersRequest:
{:requests
 [{:packageName string,
   :productId string,
   :basePlanId string,
   :offerId string}]}"
  [packageName productId basePlanId BatchGetSubscriptionOffersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers:batchGet",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body BatchGetSubscriptionOffersRequest}))

(defn monetization-subscriptions-basePlans-offers-delete
  "Deletes a subscription offer. Can only be done for draft offers. This action is irreversible.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the offer to delete.
productId <string> Required. The parent subscription (ID) of the offer to delete.
basePlanId <string> Required. The parent base plan (ID) of the offer to delete.
offerId <string> Required. The unique offer ID of the offer to delete."
  [packageName productId basePlanId offerId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId,
      :offerId offerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn monetization-subscriptions-basePlans-offers-deactivate
  "Deactivates a subscription offer. Once deactivated, existing subscribers will maintain their subscription, but the offer will become unavailable to new subscribers.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the offer to deactivate.
productId <string> Required. The parent subscription (ID) of the offer to deactivate.
basePlanId <string> Required. The parent base plan (ID) of the offer to deactivate.
offerId <string> Required. The unique offer ID of the offer to deactivate.
DeactivateSubscriptionOfferRequest:
{:packageName string,
 :productId string,
 :basePlanId string,
 :offerId string,
 :latencyTolerance
 [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}"
  [packageName
   productId
   basePlanId
   offerId
   DeactivateSubscriptionOfferRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}:deactivate",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId,
      :offerId offerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body DeactivateSubscriptionOfferRequest}))

(defn monetization-subscriptions-basePlans-offers-list
  "Lists all offers under a given subscription.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) for which the subscriptions should be read.
productId <string> Required. The parent subscription (ID) for which the offers should be read. May be specified as '-' to read all offers under an app.
basePlanId <string> Required. The parent base plan (ID) for which the offers should be read. May be specified as '-' to read all offers under a subscription or an app. Must be specified as '-' if product_id is specified as '-'.

optional:
pageSize <integer> The maximum number of subscriptions to return. The service may return fewer than this value. If unspecified, at most 50 subscriptions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([packageName productId basePlanId]
    (monetization-subscriptions-basePlans-offers-list
      packageName
      productId
      basePlanId
      nil))
  ([packageName productId basePlanId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers",
       :uri-template-args
       {:packageName packageName,
        :productId productId,
        :basePlanId basePlanId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn monetization-subscriptions-basePlans-offers-activate
  "Activates a subscription offer. Once activated, subscription offers will be available to new subscribers.
https://developers.google.com/android-publisher

packageName <string> Required. The parent app (package name) of the offer to activate.
productId <string> Required. The parent subscription (ID) of the offer to activate.
basePlanId <string> Required. The parent base plan (ID) of the offer to activate.
offerId <string> Required. The unique offer ID of the offer to activate.
ActivateSubscriptionOfferRequest:
{:packageName string,
 :productId string,
 :basePlanId string,
 :offerId string,
 :latencyTolerance
 [PRODUCT_UPDATE_LATENCY_TOLERANCE_UNSPECIFIED
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_SENSITIVE
  PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT]}"
  [packageName
   productId
   basePlanId
   offerId
   ActivateSubscriptionOfferRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}:activate",
     :uri-template-args
     {:packageName packageName,
      :productId productId,
      :basePlanId basePlanId,
      :offerId offerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ActivateSubscriptionOfferRequest}))

(defn purchases-products-get
  "Checks the purchase and consumption status of an inapp item.
https://developers.google.com/android-publisher

packageName <string> The package name of the application the inapp product was sold in (for example, 'com.some.thing').
productId <string> The inapp product SKU (for example, 'com.some.thing.inapp1').
token <string> The token provided to the user's device when the inapp product was purchased."
  [packageName productId token]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/products/{productId}/tokens/{token}",
     :uri-template-args
     {:packageName packageName, :productId productId, :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn purchases-products-acknowledge
  "Acknowledges a purchase of an inapp item.
https://developers.google.com/android-publisher

packageName <string> The package name of the application the inapp product was sold in (for example, 'com.some.thing').
productId <string> The inapp product SKU (for example, 'com.some.thing.inapp1').
token <string> The token provided to the user's device when the inapp product was purchased.
ProductPurchasesAcknowledgeRequest:
{:developerPayload string}"
  [packageName productId token ProductPurchasesAcknowledgeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/products/{productId}/tokens/{token}:acknowledge",
     :uri-template-args
     {:packageName packageName, :productId productId, :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ProductPurchasesAcknowledgeRequest}))

(defn purchases-products-consume
  "Consumes a purchase for an inapp item.
https://developers.google.com/android-publisher

packageName <string> The package name of the application the inapp product was sold in (for example, 'com.some.thing').
productId <string> The inapp product SKU (for example, 'com.some.thing.inapp1').
token <string> The token provided to the user's device when the inapp product was purchased."
  [packageName productId token]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/products/{productId}/tokens/{token}:consume",
     :uri-template-args
     {:packageName packageName, :productId productId, :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn purchases-subscriptions-get
  "Checks whether a user's subscription purchase is valid and returns its expiry time.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which this subscription was purchased (for example, 'com.some.thing').
subscriptionId <string> The purchased subscription ID (for example, 'monthly001').
token <string> The token provided to the user's device when the subscription was purchased."
  [packageName subscriptionId token]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}",
     :uri-template-args
     {:packageName packageName,
      :subscriptionId subscriptionId,
      :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn purchases-subscriptions-cancel
  "Cancels a user's subscription purchase. The subscription remains valid until its expiration time.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which this subscription was purchased (for example, 'com.some.thing').
subscriptionId <string> The purchased subscription ID (for example, 'monthly001').
token <string> The token provided to the user's device when the subscription was purchased."
  [packageName subscriptionId token]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:cancel",
     :uri-template-args
     {:packageName packageName,
      :subscriptionId subscriptionId,
      :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn purchases-subscriptions-defer
  "Defers a user's subscription purchase until a specified future expiration time.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which this subscription was purchased (for example, 'com.some.thing').
subscriptionId <string> The purchased subscription ID (for example, 'monthly001').
token <string> The token provided to the user's device when the subscription was purchased.
SubscriptionPurchasesDeferRequest:
{:deferralInfo
 {:expectedExpiryTimeMillis string, :desiredExpiryTimeMillis string}}"
  [packageName subscriptionId token SubscriptionPurchasesDeferRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:defer",
     :uri-template-args
     {:packageName packageName,
      :subscriptionId subscriptionId,
      :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body SubscriptionPurchasesDeferRequest}))

(defn purchases-subscriptions-refund
  "Refunds a user's subscription purchase, but the subscription remains valid until its expiration time and it will continue to recur.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which this subscription was purchased (for example, 'com.some.thing').
subscriptionId <string> \"The purchased subscription ID (for example, 'monthly001').
token <string> The token provided to the user's device when the subscription was purchased."
  [packageName subscriptionId token]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:refund",
     :uri-template-args
     {:packageName packageName,
      :subscriptionId subscriptionId,
      :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn purchases-subscriptions-revoke
  "Refunds and immediately revokes a user's subscription purchase. Access to the subscription will be terminated immediately and it will stop recurring.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which this subscription was purchased (for example, 'com.some.thing').
subscriptionId <string> The purchased subscription ID (for example, 'monthly001').
token <string> The token provided to the user's device when the subscription was purchased."
  [packageName subscriptionId token]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:revoke",
     :uri-template-args
     {:packageName packageName,
      :subscriptionId subscriptionId,
      :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn purchases-subscriptions-acknowledge
  "Acknowledges a subscription purchase.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which this subscription was purchased (for example, 'com.some.thing').
subscriptionId <string> The purchased subscription ID (for example, 'monthly001').
token <string> The token provided to the user's device when the subscription was purchased.
SubscriptionPurchasesAcknowledgeRequest:
{:developerPayload string}"
  [packageName
   subscriptionId
   token
   SubscriptionPurchasesAcknowledgeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:acknowledge",
     :uri-template-args
     {:packageName packageName,
      :subscriptionId subscriptionId,
      :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body SubscriptionPurchasesAcknowledgeRequest}))

(defn purchases-subscriptionsv2-get
  "Get metadata about a subscription
https://developers.google.com/android-publisher

packageName <string> The package of the application for which this subscription was purchased (for example, 'com.some.thing').
token <string> Required. The token provided to the user's device when the subscription was purchased."
  [packageName token]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptionsv2/tokens/{token}",
     :uri-template-args {:packageName packageName, :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn purchases-subscriptionsv2-revoke
  "Revoke a subscription purchase for the user.
https://developers.google.com/android-publisher

packageName <string> Required. The package of the application for which this subscription was purchased (for example, 'com.some.thing').
token <string> Required. The token provided to the user's device when the subscription was purchased.
RevokeSubscriptionPurchaseRequest:
{:revocationContext {:proratedRefund object}}"
  [packageName token RevokeSubscriptionPurchaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/subscriptionsv2/tokens/{token}:revoke",
     :uri-template-args {:packageName packageName, :token token},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body RevokeSubscriptionPurchaseRequest}))

(defn purchases-voidedpurchases-list
  "Lists the purchases that were canceled, refunded or charged-back.
https://developers.google.com/android-publisher

packageName <string> The package name of the application for which voided purchases need to be returned (for example, 'com.some.thing').

optional:
maxResults <integer> Defines how many results the list operation should return. The default number depends on the resource collection.
startIndex <integer> Defines the index of the first element to return. This can only be used if indexed paging is enabled.
token <string> Defines the token of the page to return, usually taken from TokenPagination. This can only be used if token paging is enabled.
startTime <string> The time, in milliseconds since the Epoch, of the oldest voided purchase that you want to see in the response. The value of this parameter cannot be older than 30 days and is ignored if a pagination token is set. Default value is current time minus 30 days. Note: This filter is applied on the time at which the record is seen as voided by our systems and not the actual voided time returned in the response.
endTime <string> The time, in milliseconds since the Epoch, of the newest voided purchase that you want to see in the response. The value of this parameter cannot be greater than the current time and is ignored if a pagination token is set. Default value is current time. Note: This filter is applied on the time at which the record is seen as voided by our systems and not the actual voided time returned in the response.
type <integer> The type of voided purchases that you want to see in the response. Possible values are: 0. Only voided in-app product purchases will be returned in the response. This is the default value. 1. Both voided in-app purchases and voided subscription purchases will be returned in the response. Note: Before requesting to receive voided subscription purchases, you must switch to use orderId in the response which uniquely identifies one-time purchases and subscriptions. Otherwise, you will receive multiple subscription orders with the same PurchaseToken, because subscription renewal orders share the same PurchaseToken.
includeQuantityBasedPartialRefund <boolean> Optional. Whether to include voided purchases of quantity-based partial refunds, which are applicable only to multi-quantity purchases. If true, additional voided purchases may be returned with voidedQuantity that indicates the refund quantity of a quantity-based partial refund. The default value is false."
  ([packageName] (purchases-voidedpurchases-list packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/purchases/voidedpurchases",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn edits-insert
  "Creates a new edit for an app.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
AppEdit:
{:id string, :expiryTimeSeconds string}"
  [packageName AppEdit]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body AppEdit}))

(defn edits-get
  "Gets an app edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-delete
  "Deletes an app edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-commit
  "Commits an app edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.

optional:
changesNotSentForReview <boolean> Indicates that the changes in this edit will not be reviewed until they are explicitly sent for review from the Google Play Console UI. These changes will be added to any other changes that are not yet sent for review."
  ([packageName editId] (edits-commit packageName editId nil))
  ([packageName editId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}:commit",
       :uri-template-args {:packageName packageName, :editId editId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn edits-validate
  "Validates an app edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}:validate",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-countryavailability-get
  "Gets country availability.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
track <string> The track to read from."
  [packageName editId track]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/countryAvailability/{track}",
     :uri-template-args
     {:packageName packageName, :editId editId, :track track},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-bundles-list
  "Lists all current Android App Bundles of the app and edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/bundles",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-bundles-upload
  "Uploads a new Android App Bundle to this edit. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See [Timeouts and Errors](https://developers.google.com/api-client-library/java/google-api-java-client/errors) for an example in java.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.

optional:
ackBundleInstallationWarning <boolean> Must be set to true if the app bundle installation may trigger a warning on user devices (for example, if installation size may be over a threshold, typically 100 MB).
deviceTierConfigId <string> Device tier config (DTC) to be used for generating deliverables (APKs). Contains id of the DTC or \"LATEST\" for last uploaded DTC."
  ([packageName editId] (edits-bundles-upload packageName editId nil))
  ([packageName editId optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/bundles",
       :uri-template-args {:packageName packageName, :editId editId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn edits-images-list
  "Lists all images. The response may be empty.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German). There must be a store listing for the specified language.
imageType <string> Type of the Image. Providing an image type that refers to no images will return an empty response."
  [packageName editId language imageType]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :language language,
      :imageType imageType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-images-delete
  "Deletes the image (specified by id) from the edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German).
imageType <string> Type of the Image.
imageId <string> Unique identifier an image within the set of images attached to this edit."
  [packageName editId language imageType imageId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}/{imageId}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :language language,
      :imageType imageType,
      :imageId imageId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-images-deleteall
  "Deletes all images for the specified language and image type. Returns an empty response if no images are found.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German). Providing a language that is not supported by the App is a no-op.
imageType <string> Type of the Image. Providing an image type that refers to no images is a no-op."
  [packageName editId language imageType]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :language language,
      :imageType imageType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-images-upload
  "Uploads an image of the specified language and image type, and adds to the edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German). Providing a language that is not supported by the App is a no-op.
imageType <string> Type of the Image."
  [packageName editId language imageType]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :language language,
      :imageType imageType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-tracks-get
  "Gets a track.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
track <string> Identifier of the track. [More on track name](https://developers.google.com/android-publisher/tracks#ff-track-name)"
  [packageName editId track]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks/{track}",
     :uri-template-args
     {:packageName packageName, :editId editId, :track track},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-tracks-list
  "Lists all tracks.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-tracks-update
  "Updates a track.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
track <string> Identifier of the track. [More on track name](https://developers.google.com/android-publisher/tracks#ff-track-name)
Track:
{:track string,
 :releases
 [{:name string,
   :versionCodes [string],
   :releaseNotes [{:language string, :text string}],
   :status [statusUnspecified draft inProgress halted completed],
   :userFraction number,
   :countryTargeting
   {:countries [string], :includeRestOfWorld boolean},
   :inAppUpdatePriority integer}]}"
  [packageName editId track Track]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks/{track}",
     :uri-template-args
     {:packageName packageName, :editId editId, :track track},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Track}))

(defn edits-tracks-patch
  "Patches a track.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
track <string> Identifier of the track. [More on track name](https://developers.google.com/android-publisher/tracks#ff-track-name)
Track:
{:track string,
 :releases
 [{:name string,
   :versionCodes [string],
   :releaseNotes [{:language string, :text string}],
   :status [statusUnspecified draft inProgress halted completed],
   :userFraction number,
   :countryTargeting
   {:countries [string], :includeRestOfWorld boolean},
   :inAppUpdatePriority integer}]}"
  [packageName editId track Track]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks/{track}",
     :uri-template-args
     {:packageName packageName, :editId editId, :track track},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Track}))

(defn edits-tracks-create
  "Creates a new track.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the app.
editId <string> Required. Identifier of the edit.
TrackConfig:
{:track string,
 :type [TRACK_TYPE_UNSPECIFIED CLOSED_TESTING],
 :formFactor [FORM_FACTOR_UNSPECIFIED DEFAULT WEAR AUTOMOTIVE]}"
  [packageName editId TrackConfig]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body TrackConfig}))

(defn edits-deobfuscationfiles-upload
  "Uploads a new deobfuscation file and attaches to the specified APK.
https://developers.google.com/android-publisher

packageName <string> Unique identifier for the Android app.
editId <string> Unique identifier for this edit.
apkVersionCode <integer> The version code of the APK whose Deobfuscation File is being uploaded.
deobfuscationFileType <string> The type of the deobfuscation file."
  [packageName editId apkVersionCode deobfuscationFileType]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/deobfuscationFiles/{deobfuscationFileType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :apkVersionCode apkVersionCode,
      :deobfuscationFileType deobfuscationFileType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-apks-upload
  "Uploads an APK and adds to the current edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-apks-list
  "Lists all current APKs of the app and edit.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-apks-addexternallyhosted
  "Creates a new APK without uploading the APK itself to Google Play, instead hosting the APK at a specified URL. This function is only available to organizations using Managed Play whose application is configured to restrict distribution to the organizations.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
ApksAddExternallyHostedRequest:
{:externallyHostedApk
 {:usesFeatures [string],
  :fileSize string,
  :packageName string,
  :nativeCodes [string],
  :externallyHostedUrl string,
  :certificateBase64s [string],
  :fileSha256Base64 string,
  :versionName string,
  :minimumSdk integer,
  :maximumSdk integer,
  :versionCode integer,
  :fileSha1Base64 string,
  :applicationLabel string,
  :usesPermissions [{:name string, :maxSdkVersion integer}],
  :iconBase64 string}}"
  [packageName editId ApksAddExternallyHostedRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/externallyHosted",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ApksAddExternallyHostedRequest}))

(defn edits-details-get
  "Gets details of an app.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/details",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-details-update
  "Updates details of an app.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
AppDetails:
{:defaultLanguage string,
 :contactWebsite string,
 :contactEmail string,
 :contactPhone string}"
  [packageName editId AppDetails]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/details",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body AppDetails}))

(defn edits-details-patch
  "Patches details of an app.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
AppDetails:
{:defaultLanguage string,
 :contactWebsite string,
 :contactEmail string,
 :contactPhone string}"
  [packageName editId AppDetails]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/details",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body AppDetails}))

(defn edits-testers-get
  "Gets testers. Note: Testers resource does not support email lists.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
track <string> The track to read from."
  [packageName editId track]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/testers/{track}",
     :uri-template-args
     {:packageName packageName, :editId editId, :track track},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-testers-update
  "Updates testers. Note: Testers resource does not support email lists.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
track <string> The track to update.
Testers:
{:googleGroups [string]}"
  [packageName editId track Testers]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/testers/{track}",
     :uri-template-args
     {:packageName packageName, :editId editId, :track track},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Testers}))

(defn edits-testers-patch
  "Patches testers. Note: Testers resource does not support email lists.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
track <string> The track to update.
Testers:
{:googleGroups [string]}"
  [packageName editId track Testers]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/testers/{track}",
     :uri-template-args
     {:packageName packageName, :editId editId, :track track},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Testers}))

(defn edits-listings-update
  "Creates or updates a localized store listing.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German).
Listing:
{:language string,
 :title string,
 :fullDescription string,
 :shortDescription string,
 :video string}"
  [packageName editId language Listing]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}",
     :uri-template-args
     {:packageName packageName, :editId editId, :language language},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Listing}))

(defn edits-listings-patch
  "Patches a localized store listing.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German).
Listing:
{:language string,
 :title string,
 :fullDescription string,
 :shortDescription string,
 :video string}"
  [packageName editId language Listing]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}",
     :uri-template-args
     {:packageName packageName, :editId editId, :language language},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Listing}))

(defn edits-listings-get
  "Gets a localized store listing.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German)."
  [packageName editId language]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}",
     :uri-template-args
     {:packageName packageName, :editId editId, :language language},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-listings-list
  "Lists all localized store listings.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-listings-delete
  "Deletes a localized store listing.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
language <string> Language localization code (a BCP-47 language tag; for example, \"de-AT\" for Austrian German)."
  [packageName editId language]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}",
     :uri-template-args
     {:packageName packageName, :editId editId, :language language},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-listings-deleteall
  "Deletes all store listings.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit."
  [packageName editId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/listings",
     :uri-template-args {:packageName packageName, :editId editId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-expansionfiles-get
  "Fetches the expansion file configuration for the specified APK.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
apkVersionCode <integer> The version code of the APK whose expansion file configuration is being read or modified.
expansionFileType <string> The file type of the file configuration which is being read or modified."
  [packageName editId apkVersionCode expansionFileType]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :apkVersionCode apkVersionCode,
      :expansionFileType expansionFileType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn edits-expansionfiles-update
  "Updates the APK's expansion file configuration to reference another APK's expansion file. To add a new expansion file use the Upload method.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
apkVersionCode <integer> The version code of the APK whose expansion file configuration is being read or modified.
expansionFileType <string> The file type of the file configuration which is being read or modified.
ExpansionFile:
{:referencesVersion integer, :fileSize string}"
  [packageName editId apkVersionCode expansionFileType ExpansionFile]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :apkVersionCode apkVersionCode,
      :expansionFileType expansionFileType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ExpansionFile}))

(defn edits-expansionfiles-patch
  "Patches the APK's expansion file configuration to reference another APK's expansion file. To add a new expansion file use the Upload method.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
apkVersionCode <integer> The version code of the APK whose expansion file configuration is being read or modified.
expansionFileType <string> The file type of the expansion file configuration which is being updated.
ExpansionFile:
{:referencesVersion integer, :fileSize string}"
  [packageName editId apkVersionCode expansionFileType ExpansionFile]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :apkVersionCode apkVersionCode,
      :expansionFileType expansionFileType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ExpansionFile}))

(defn edits-expansionfiles-upload
  "Uploads a new expansion file and attaches to the specified APK.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
editId <string> Identifier of the edit.
apkVersionCode <integer> The version code of the APK whose expansion file configuration is being read or modified.
expansionFileType <string> The file type of the expansion file configuration which is being updated."
  [packageName editId apkVersionCode expansionFileType]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}",
     :uri-template-args
     {:packageName packageName,
      :editId editId,
      :apkVersionCode apkVersionCode,
      :expansionFileType expansionFileType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn reviews-get
  "Gets a single review.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
reviewId <string> Unique identifier for a review.

optional:
translationLanguage <string> Language localization code."
  ([packageName reviewId] (reviews-get packageName reviewId nil))
  ([packageName reviewId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/reviews/{reviewId}",
       :uri-template-args
       {:packageName packageName, :reviewId reviewId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn reviews-list
  "Lists all reviews.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.

optional:
token <string> Pagination token. If empty, list starts at the first review.
startIndex <integer> The index of the first element to return.
maxResults <integer> How many results the list operation should return.
translationLanguage <string> Language localization code."
  ([packageName] (reviews-list packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/reviews",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn reviews-reply
  "Replies to a single review, or updates an existing reply.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
reviewId <string> Unique identifier for a review.
ReviewsReplyRequest:
{:replyText string}"
  [packageName reviewId ReviewsReplyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/reviews/{reviewId}:reply",
     :uri-template-args {:packageName packageName, :reviewId reviewId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body ReviewsReplyRequest}))

(defn systemapks-variants-create
  "Creates an APK which is suitable for inclusion in a system image from an already uploaded Android App Bundle.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
versionCode <string> The version code of the App Bundle.
Variant:
{:variantId integer,
 :deviceSpec
 {:supportedAbis [string],
  :supportedLocales [string],
  :screenDensity integer},
 :options
 {:uncompressedNativeLibraries boolean,
  :uncompressedDexFiles boolean,
  :rotated boolean}}"
  [packageName versionCode Variant]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants",
     :uri-template-args
     {:packageName packageName, :versionCode versionCode},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body Variant}))

(defn systemapks-variants-list
  "Returns the list of previously created system APK variants.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
versionCode <string> The version code of the App Bundle."
  [packageName versionCode]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants",
     :uri-template-args
     {:packageName packageName, :versionCode versionCode},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn systemapks-variants-get
  "Returns a previously created system APK variant.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
versionCode <string> The version code of the App Bundle.
variantId <integer> The ID of a previously created system APK variant."
  [packageName versionCode variantId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants/{variantId}",
     :uri-template-args
     {:packageName packageName,
      :versionCode versionCode,
      :variantId variantId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn systemapks-variants-download
  "Downloads a previously created system APK which is suitable for inclusion in a system image.
https://developers.google.com/android-publisher

packageName <string> Package name of the app.
versionCode <string> The version code of the App Bundle.
variantId <integer> The ID of a previously created system APK variant."
  [packageName versionCode variantId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants/{variantId}:download",
     :uri-template-args
     {:packageName packageName,
      :versionCode versionCode,
      :variantId variantId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

(defn apprecovery-create
  "Create an app recovery action with recovery status as DRAFT. Note that this action does not execute the recovery action.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the app on which recovery action is performed.
CreateDraftAppRecoveryRequest:
{:targeting
 {:regions {:regionCode [string]},
  :androidSdks {:sdkLevels [string]},
  :allUsers {:isAllUsersRequested boolean},
  :versionList {:versionCodes [string]},
  :versionRange {:versionCodeStart string, :versionCodeEnd string}},
 :remoteInAppUpdate {:isRemoteInAppUpdateRequested boolean}}"
  [packageName CreateDraftAppRecoveryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/appRecoveries",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body CreateDraftAppRecoveryRequest}))

(defn apprecovery-deploy
  "Deploy an already created app recovery action with recovery status DRAFT. Note that this action activates the recovery action for all targeted users and changes its status to ACTIVE.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the app for which recovery action is deployed.
appRecoveryId <string> Required. ID corresponding to the app recovery action to deploy.
DeployAppRecoveryRequest:
object"
  [packageName appRecoveryId DeployAppRecoveryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/appRecoveries/{appRecoveryId}:deploy",
     :uri-template-args
     {:packageName packageName, :appRecoveryId appRecoveryId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body DeployAppRecoveryRequest}))

(defn apprecovery-appRecoveries
  "List all app recovery action resources associated with a particular package name and app version.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the app for which list of recovery actions is requested.

optional:
versionCode <string> Required. Version code targeted by the list of recovery actions."
  ([packageName] (apprecovery-appRecoveries packageName nil))
  ([packageName optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/appRecoveries",
       :uri-template-args {:packageName packageName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn apprecovery-addTargeting
  "Incrementally update targeting for a recovery action. Note that only the criteria selected during the creation of recovery action can be expanded.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the app for which recovery action is to be updated.
appRecoveryId <string> Required. ID corresponding to the app recovery action.
AddTargetingRequest:
{:targetingUpdate
 {:regions {:regionCode [string]},
  :androidSdks {:sdkLevels [string]},
  :allUsers {:isAllUsersRequested boolean}}}"
  [packageName appRecoveryId AddTargetingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/appRecoveries/{appRecoveryId}:addTargeting",
     :uri-template-args
     {:packageName packageName, :appRecoveryId appRecoveryId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body AddTargetingRequest}))

(defn apprecovery-cancel
  "Cancel an already executing app recovery action. Note that this action changes status of the recovery action to CANCELED.
https://developers.google.com/android-publisher

packageName <string> Required. Package name of the app for which recovery action cancellation is requested.
appRecoveryId <string> Required. ID corresponding to the app recovery action.
CancelAppRecoveryRequest:
object"
  [packageName appRecoveryId CancelAppRecoveryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/applications/{packageName}/appRecoveries/{appRecoveryId}:cancel",
     :uri-template-args
     {:packageName packageName, :appRecoveryId appRecoveryId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body CancelAppRecoveryRequest}))

(defn users-create
  "Grant access for a user to the given developer account.
https://developers.google.com/android-publisher

parent <string> Required. The developer account to add the user to. Format: developers/{developer}
User:
{:name string,
 :email string,
 :accessState
 [ACCESS_STATE_UNSPECIFIED
  INVITED
  INVITATION_EXPIRED
  ACCESS_GRANTED
  ACCESS_EXPIRED],
 :expirationTime string,
 :partial boolean,
 :developerAccountPermissions
 [[DEVELOPER_LEVEL_PERMISSION_UNSPECIFIED
   CAN_SEE_ALL_APPS
   CAN_VIEW_FINANCIAL_DATA_GLOBAL
   CAN_MANAGE_PERMISSIONS_GLOBAL
   CAN_EDIT_GAMES_GLOBAL
   CAN_PUBLISH_GAMES_GLOBAL
   CAN_REPLY_TO_REVIEWS_GLOBAL
   CAN_MANAGE_PUBLIC_APKS_GLOBAL
   CAN_MANAGE_TRACK_APKS_GLOBAL
   CAN_MANAGE_TRACK_USERS_GLOBAL
   CAN_MANAGE_PUBLIC_LISTING_GLOBAL
   CAN_MANAGE_DRAFT_APPS_GLOBAL
   CAN_CREATE_MANAGED_PLAY_APPS_GLOBAL
   CAN_CHANGE_MANAGED_PLAY_SETTING_GLOBAL
   CAN_MANAGE_ORDERS_GLOBAL
   CAN_MANAGE_APP_CONTENT_GLOBAL
   CAN_VIEW_NON_FINANCIAL_DATA_GLOBAL
   CAN_VIEW_APP_QUALITY_GLOBAL
   CAN_MANAGE_DEEPLINKS_GLOBAL]],
 :grants
 [{:name string,
   :packageName string,
   :appLevelPermissions
   [[APP_LEVEL_PERMISSION_UNSPECIFIED
     CAN_ACCESS_APP
     CAN_VIEW_FINANCIAL_DATA
     CAN_MANAGE_PERMISSIONS
     CAN_REPLY_TO_REVIEWS
     CAN_MANAGE_PUBLIC_APKS
     CAN_MANAGE_TRACK_APKS
     CAN_MANAGE_TRACK_USERS
     CAN_MANAGE_PUBLIC_LISTING
     CAN_MANAGE_DRAFT_APPS
     CAN_MANAGE_ORDERS
     CAN_MANAGE_APP_CONTENT
     CAN_VIEW_NON_FINANCIAL_DATA
     CAN_VIEW_APP_QUALITY
     CAN_MANAGE_DEEPLINKS]]}]}"
  [parent User]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/{+parent}/users",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body User}))

(defn users-list
  "Lists all users with access to a developer account.
https://developers.google.com/android-publisher

parent <string> Required. The developer account to fetch users from. Format: developers/{developer}

optional:
pageSize <integer> The maximum number of results to return. This must be set to -1 to disable pagination."
  ([parent] (users-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/{+parent}/users",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"]})))

(defn users-patch
  "Updates access for the user to the developer account.
https://developers.google.com/android-publisher

name <string> Required. Resource name for this user, following the pattern \"developers/{developer}/users/{email}\".
User:
{:name string,
 :email string,
 :accessState
 [ACCESS_STATE_UNSPECIFIED
  INVITED
  INVITATION_EXPIRED
  ACCESS_GRANTED
  ACCESS_EXPIRED],
 :expirationTime string,
 :partial boolean,
 :developerAccountPermissions
 [[DEVELOPER_LEVEL_PERMISSION_UNSPECIFIED
   CAN_SEE_ALL_APPS
   CAN_VIEW_FINANCIAL_DATA_GLOBAL
   CAN_MANAGE_PERMISSIONS_GLOBAL
   CAN_EDIT_GAMES_GLOBAL
   CAN_PUBLISH_GAMES_GLOBAL
   CAN_REPLY_TO_REVIEWS_GLOBAL
   CAN_MANAGE_PUBLIC_APKS_GLOBAL
   CAN_MANAGE_TRACK_APKS_GLOBAL
   CAN_MANAGE_TRACK_USERS_GLOBAL
   CAN_MANAGE_PUBLIC_LISTING_GLOBAL
   CAN_MANAGE_DRAFT_APPS_GLOBAL
   CAN_CREATE_MANAGED_PLAY_APPS_GLOBAL
   CAN_CHANGE_MANAGED_PLAY_SETTING_GLOBAL
   CAN_MANAGE_ORDERS_GLOBAL
   CAN_MANAGE_APP_CONTENT_GLOBAL
   CAN_VIEW_NON_FINANCIAL_DATA_GLOBAL
   CAN_VIEW_APP_QUALITY_GLOBAL
   CAN_MANAGE_DEEPLINKS_GLOBAL]],
 :grants
 [{:name string,
   :packageName string,
   :appLevelPermissions
   [[APP_LEVEL_PERMISSION_UNSPECIFIED
     CAN_ACCESS_APP
     CAN_VIEW_FINANCIAL_DATA
     CAN_MANAGE_PERMISSIONS
     CAN_REPLY_TO_REVIEWS
     CAN_MANAGE_PUBLIC_APKS
     CAN_MANAGE_TRACK_APKS
     CAN_MANAGE_TRACK_USERS
     CAN_MANAGE_PUBLIC_LISTING
     CAN_MANAGE_DRAFT_APPS
     CAN_MANAGE_ORDERS
     CAN_MANAGE_APP_CONTENT
     CAN_VIEW_NON_FINANCIAL_DATA
     CAN_VIEW_APP_QUALITY
     CAN_MANAGE_DEEPLINKS]]}]}

optional:
updateMask <string> Optional. The list of fields to be updated."
  ([name User] (users-patch name User nil))
  ([name User optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androidpublisher.googleapis.com/androidpublisher/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/androidpublisher"],
       :body User})))

(defn users-delete
  "Removes all access for the user to the given developer account.
https://developers.google.com/android-publisher

name <string> Required. The name of the user to delete. Format: developers/{developer}/users/{email}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androidpublisher.googleapis.com/androidpublisher/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"]}))

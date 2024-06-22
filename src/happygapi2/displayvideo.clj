(ns happygapi2.displayvideo
  "Display & Video 360 API
Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
See: https://developers.google.com/display-video/api/guides/getting-started/overview"
  (:require [happy.oauth2.client :as client]))

(defn googleAudiences-get
  "Gets a Google audience.
https://developers.google.com/display-video/api/guides/getting-started/overview

googleAudienceId <string> Required. The ID of the Google audience to fetch.

optional:
partnerId <string> The ID of the partner that has access to the fetched Google audience.
advertiserId <string> The ID of the advertiser that has access to the fetched Google audience."
  ([googleAudienceId] (googleAudiences-get googleAudienceId nil))
  ([googleAudienceId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/googleAudiences/{+googleAudienceId}",
       :uri-template-args {:googleAudienceId googleAudienceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn googleAudiences-list
  "Lists Google audiences. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> The ID of the partner that has access to the fetched Google audiences.
advertiserId <string> The ID of the advertiser that has access to the fetched Google audiences.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `googleAudienceId` (default) * `displayName` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by Google audience fields. Supported syntax: * Filter expressions for Google audiences can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `displayName` Examples: * All Google audiences for which the display name contains \"Google\": `displayName:\"Google\"`. The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (googleAudiences-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/googleAudiences",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn floodlightGroups-get
  "Gets a Floodlight group.
https://developers.google.com/display-video/api/guides/getting-started/overview

floodlightGroupId <string> Required. The ID of the Floodlight group to fetch.

optional:
partnerId <string> Required. The partner context by which the Floodlight group is being accessed."
  ([floodlightGroupId] (floodlightGroups-get floodlightGroupId nil))
  ([floodlightGroupId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/floodlightGroups/{+floodlightGroupId}",
       :uri-template-args {:floodlightGroupId floodlightGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn floodlightGroups-patch
  "Updates an existing Floodlight group. Returns the updated Floodlight group if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

floodlightGroupId <string> Output only. The unique ID of the Floodlight group. Assigned by the system.
FloodlightGroup:
{:name string,
 :floodlightGroupId string,
 :displayName string,
 :webTagType
 [WEB_TAG_TYPE_UNSPECIFIED
  WEB_TAG_TYPE_NONE
  WEB_TAG_TYPE_IMAGE
  WEB_TAG_TYPE_DYNAMIC],
 :lookbackWindow {:clickDays integer, :impressionDays integer},
 :customVariables object,
 :activeViewConfig
 {:displayName string,
  :minimumViewability
  [VIEWABILITY_PERCENT_UNSPECIFIED
   VIEWABILITY_PERCENT_0
   VIEWABILITY_PERCENT_25
   VIEWABILITY_PERCENT_50
   VIEWABILITY_PERCENT_75
   VIEWABILITY_PERCENT_100],
  :minimumVolume
  [VIDEO_VOLUME_PERCENT_UNSPECIFIED
   VIDEO_VOLUME_PERCENT_0
   VIDEO_VOLUME_PERCENT_10],
  :minimumDuration
  [VIDEO_DURATION_UNSPECIFIED
   VIDEO_DURATION_SECONDS_NONE
   VIDEO_DURATION_SECONDS_0
   VIDEO_DURATION_SECONDS_1
   VIDEO_DURATION_SECONDS_2
   VIDEO_DURATION_SECONDS_3
   VIDEO_DURATION_SECONDS_4
   VIDEO_DURATION_SECONDS_5
   VIDEO_DURATION_SECONDS_6
   VIDEO_DURATION_SECONDS_7
   VIDEO_DURATION_SECONDS_8
   VIDEO_DURATION_SECONDS_9
   VIDEO_DURATION_SECONDS_10
   VIDEO_DURATION_SECONDS_11
   VIDEO_DURATION_SECONDS_12
   VIDEO_DURATION_SECONDS_13
   VIDEO_DURATION_SECONDS_14
   VIDEO_DURATION_SECONDS_15
   VIDEO_DURATION_SECONDS_30
   VIDEO_DURATION_SECONDS_45
   VIDEO_DURATION_SECONDS_60],
  :minimumQuartile
  [VIDEO_DURATION_QUARTILE_UNSPECIFIED
   VIDEO_DURATION_QUARTILE_NONE
   VIDEO_DURATION_QUARTILE_FIRST
   VIDEO_DURATION_QUARTILE_SECOND
   VIDEO_DURATION_QUARTILE_THIRD
   VIDEO_DURATION_QUARTILE_FOURTH]}}

optional:
partnerId <string> Required. The partner context by which the Floodlight group is being accessed.
updateMask <string> Required. The mask to control which fields to update."
  ([floodlightGroupId FloodlightGroup]
    (floodlightGroups-patch floodlightGroupId FloodlightGroup nil))
  ([floodlightGroupId FloodlightGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/floodlightGroups/{floodlightGroupId}",
       :uri-template-args {:floodlightGroupId floodlightGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body FloodlightGroup})))

(defn floodlightGroups-floodlightActivities-get
  "Gets a Floodlight activity.
https://developers.google.com/display-video/api/guides/getting-started/overview

floodlightGroupId <string> Required. The ID of the parent Floodlight group to which the requested Floodlight activity belongs.
floodlightActivityId <string> Required. The ID of the Floodlight activity to fetch.

optional:
partnerId <string> Required. The ID of the partner through which the Floodlight activity is being accessed."
  ([floodlightGroupId floodlightActivityId]
    (floodlightGroups-floodlightActivities-get
      floodlightGroupId
      floodlightActivityId
      nil))
  ([floodlightGroupId floodlightActivityId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/floodlightGroups/{+floodlightGroupId}/floodlightActivities/{+floodlightActivityId}",
       :uri-template-args
       {:floodlightGroupId floodlightGroupId,
        :floodlightActivityId floodlightActivityId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn floodlightGroups-floodlightActivities-list
  "Lists Floodlight activities in a Floodlight group.
https://developers.google.com/display-video/api/guides/getting-started/overview

floodlightGroupId <string> Required. The ID of the parent Floodlight group to which the requested Floodlight activities belong.

optional:
partnerId <string> Required. The ID of the partner through which the Floodlight activities are being accessed.
pageSize <integer> Optional. Requested page size. Must be between `1` and `100`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Optional. Field by which to sort the list. Acceptable values are: * `displayName` (default) * `floodlightActivityId` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`."
  ([floodlightGroupId]
    (floodlightGroups-floodlightActivities-list floodlightGroupId nil))
  ([floodlightGroupId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/floodlightGroups/{+floodlightGroupId}/floodlightActivities",
       :uri-template-args {:floodlightGroupId floodlightGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn guaranteedOrders-create
  "Creates a new guaranteed order. Returns the newly created guaranteed order if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

GuaranteedOrder:
{:guaranteedOrderId string,
 :defaultAdvertiserId string,
 :readAccessInherited boolean,
 :displayName string,
 :readAdvertiserIds [string],
 :name string,
 :readWritePartnerId string,
 :updateTime string,
 :publisherName string,
 :status
 {:entityStatus
  [ENTITY_STATUS_UNSPECIFIED
   ENTITY_STATUS_ACTIVE
   ENTITY_STATUS_ARCHIVED
   ENTITY_STATUS_DRAFT
   ENTITY_STATUS_PAUSED
   ENTITY_STATUS_SCHEDULED_FOR_DELETION],
  :entityPauseReason string,
  :configStatus
  [GUARANTEED_ORDER_CONFIG_STATUS_UNSPECIFIED PENDING COMPLETED]},
 :readWriteAdvertiserId string,
 :exchange
 [EXCHANGE_UNSPECIFIED
  EXCHANGE_GOOGLE_AD_MANAGER
  EXCHANGE_APPNEXUS
  EXCHANGE_BRIGHTROLL
  EXCHANGE_ADFORM
  EXCHANGE_ADMETA
  EXCHANGE_ADMIXER
  EXCHANGE_ADSMOGO
  EXCHANGE_ADSWIZZ
  EXCHANGE_BIDSWITCH
  EXCHANGE_BRIGHTROLL_DISPLAY
  EXCHANGE_CADREON
  EXCHANGE_DAILYMOTION
  EXCHANGE_FIVE
  EXCHANGE_FLUCT
  EXCHANGE_FREEWHEEL
  EXCHANGE_GENIEE
  EXCHANGE_GUMGUM
  EXCHANGE_IMOBILE
  EXCHANGE_IBILLBOARD
  EXCHANGE_IMPROVE_DIGITAL
  EXCHANGE_INDEX
  EXCHANGE_KARGO
  EXCHANGE_MICROAD
  EXCHANGE_MOPUB
  EXCHANGE_NEND
  EXCHANGE_ONE_BY_AOL_DISPLAY
  EXCHANGE_ONE_BY_AOL_MOBILE
  EXCHANGE_ONE_BY_AOL_VIDEO
  EXCHANGE_OOYALA
  EXCHANGE_OPENX
  EXCHANGE_PERMODO
  EXCHANGE_PLATFORMONE
  EXCHANGE_PLATFORMID
  EXCHANGE_PUBMATIC
  EXCHANGE_PULSEPOINT
  EXCHANGE_REVENUEMAX
  EXCHANGE_RUBICON
  EXCHANGE_SMARTCLIP
  EXCHANGE_SMARTRTB
  EXCHANGE_SMARTSTREAMTV
  EXCHANGE_SOVRN
  EXCHANGE_SPOTXCHANGE
  EXCHANGE_STROER
  EXCHANGE_TEADSTV
  EXCHANGE_TELARIA
  EXCHANGE_TVN
  EXCHANGE_UNITED
  EXCHANGE_YIELDLAB
  EXCHANGE_YIELDMO
  EXCHANGE_UNRULYX
  EXCHANGE_OPEN8
  EXCHANGE_TRITON
  EXCHANGE_TRIPLELIFT
  EXCHANGE_TABOOLA
  EXCHANGE_INMOBI
  EXCHANGE_SMAATO
  EXCHANGE_AJA
  EXCHANGE_SUPERSHIP
  EXCHANGE_NEXSTAR_DIGITAL
  EXCHANGE_WAZE
  EXCHANGE_SOUNDCAST
  EXCHANGE_SHARETHROUGH
  EXCHANGE_FYBER
  EXCHANGE_RED_FOR_PUBLISHERS
  EXCHANGE_MEDIANET
  EXCHANGE_TAPJOY
  EXCHANGE_VISTAR
  EXCHANGE_DAX
  EXCHANGE_JCD
  EXCHANGE_PLACE_EXCHANGE
  EXCHANGE_APPLOVIN
  EXCHANGE_CONNATIX
  EXCHANGE_RESET_DIGITAL
  EXCHANGE_HIVESTACK
  EXCHANGE_DRAX
  EXCHANGE_APPLOVIN_GBID
  EXCHANGE_FYBER_GBID
  EXCHANGE_UNITY_GBID
  EXCHANGE_CHARTBOOST_GBID
  EXCHANGE_ADMOST_GBID
  EXCHANGE_TOPON_GBID],
 :legacyGuaranteedOrderId string,
 :defaultCampaignId string}

optional:
partnerId <string> The ID of the partner that the request is being made within.
advertiserId <string> The ID of the advertiser that the request is being made within."
  ([GuaranteedOrder] (guaranteedOrders-create GuaranteedOrder nil))
  ([GuaranteedOrder optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/guaranteedOrders",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body GuaranteedOrder})))

(defn guaranteedOrders-get
  "Gets a guaranteed order.
https://developers.google.com/display-video/api/guides/getting-started/overview

guaranteedOrderId <string> Required. The ID of the guaranteed order to fetch. The ID is of the format `{exchange}-{legacy_guaranteed_order_id}`

optional:
partnerId <string> The ID of the partner that has access to the guaranteed order.
advertiserId <string> The ID of the advertiser that has access to the guaranteed order."
  ([guaranteedOrderId] (guaranteedOrders-get guaranteedOrderId nil))
  ([guaranteedOrderId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/guaranteedOrders/{+guaranteedOrderId}",
       :uri-template-args {:guaranteedOrderId guaranteedOrderId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn guaranteedOrders-list
  "Lists guaranteed orders that are accessible to the current user. The order is defined by the order_by parameter. If a filter by entity_status is not specified, guaranteed orders with entity status `ENTITY_STATUS_ARCHIVED` will not be included in the results.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> The ID of the partner that has access to the guaranteed order.
advertiserId <string> The ID of the advertiser that has access to the guaranteed order.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. For example, `displayName desc`.
filter <string> Allows filtering by guaranteed order fields. * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `guaranteed_order_id` * `exchange` * `display_name` * `status.entityStatus` Examples: * All active guaranteed orders: `status.entityStatus=\"ENTITY_STATUS_ACTIVE\"` * Guaranteed orders belonging to Google Ad Manager or Rubicon exchanges: `exchange=\"EXCHANGE_GOOGLE_AD_MANAGER\" OR exchange=\"EXCHANGE_RUBICON\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (guaranteedOrders-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/guaranteedOrders",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn guaranteedOrders-patch
  "Updates an existing guaranteed order. Returns the updated guaranteed order if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

guaranteedOrderId <string> Output only. The unique identifier of the guaranteed order. The guaranteed order IDs have the format `{exchange}-{legacy_guaranteed_order_id}`.
GuaranteedOrder:
{:guaranteedOrderId string,
 :defaultAdvertiserId string,
 :readAccessInherited boolean,
 :displayName string,
 :readAdvertiserIds [string],
 :name string,
 :readWritePartnerId string,
 :updateTime string,
 :publisherName string,
 :status
 {:entityStatus
  [ENTITY_STATUS_UNSPECIFIED
   ENTITY_STATUS_ACTIVE
   ENTITY_STATUS_ARCHIVED
   ENTITY_STATUS_DRAFT
   ENTITY_STATUS_PAUSED
   ENTITY_STATUS_SCHEDULED_FOR_DELETION],
  :entityPauseReason string,
  :configStatus
  [GUARANTEED_ORDER_CONFIG_STATUS_UNSPECIFIED PENDING COMPLETED]},
 :readWriteAdvertiserId string,
 :exchange
 [EXCHANGE_UNSPECIFIED
  EXCHANGE_GOOGLE_AD_MANAGER
  EXCHANGE_APPNEXUS
  EXCHANGE_BRIGHTROLL
  EXCHANGE_ADFORM
  EXCHANGE_ADMETA
  EXCHANGE_ADMIXER
  EXCHANGE_ADSMOGO
  EXCHANGE_ADSWIZZ
  EXCHANGE_BIDSWITCH
  EXCHANGE_BRIGHTROLL_DISPLAY
  EXCHANGE_CADREON
  EXCHANGE_DAILYMOTION
  EXCHANGE_FIVE
  EXCHANGE_FLUCT
  EXCHANGE_FREEWHEEL
  EXCHANGE_GENIEE
  EXCHANGE_GUMGUM
  EXCHANGE_IMOBILE
  EXCHANGE_IBILLBOARD
  EXCHANGE_IMPROVE_DIGITAL
  EXCHANGE_INDEX
  EXCHANGE_KARGO
  EXCHANGE_MICROAD
  EXCHANGE_MOPUB
  EXCHANGE_NEND
  EXCHANGE_ONE_BY_AOL_DISPLAY
  EXCHANGE_ONE_BY_AOL_MOBILE
  EXCHANGE_ONE_BY_AOL_VIDEO
  EXCHANGE_OOYALA
  EXCHANGE_OPENX
  EXCHANGE_PERMODO
  EXCHANGE_PLATFORMONE
  EXCHANGE_PLATFORMID
  EXCHANGE_PUBMATIC
  EXCHANGE_PULSEPOINT
  EXCHANGE_REVENUEMAX
  EXCHANGE_RUBICON
  EXCHANGE_SMARTCLIP
  EXCHANGE_SMARTRTB
  EXCHANGE_SMARTSTREAMTV
  EXCHANGE_SOVRN
  EXCHANGE_SPOTXCHANGE
  EXCHANGE_STROER
  EXCHANGE_TEADSTV
  EXCHANGE_TELARIA
  EXCHANGE_TVN
  EXCHANGE_UNITED
  EXCHANGE_YIELDLAB
  EXCHANGE_YIELDMO
  EXCHANGE_UNRULYX
  EXCHANGE_OPEN8
  EXCHANGE_TRITON
  EXCHANGE_TRIPLELIFT
  EXCHANGE_TABOOLA
  EXCHANGE_INMOBI
  EXCHANGE_SMAATO
  EXCHANGE_AJA
  EXCHANGE_SUPERSHIP
  EXCHANGE_NEXSTAR_DIGITAL
  EXCHANGE_WAZE
  EXCHANGE_SOUNDCAST
  EXCHANGE_SHARETHROUGH
  EXCHANGE_FYBER
  EXCHANGE_RED_FOR_PUBLISHERS
  EXCHANGE_MEDIANET
  EXCHANGE_TAPJOY
  EXCHANGE_VISTAR
  EXCHANGE_DAX
  EXCHANGE_JCD
  EXCHANGE_PLACE_EXCHANGE
  EXCHANGE_APPLOVIN
  EXCHANGE_CONNATIX
  EXCHANGE_RESET_DIGITAL
  EXCHANGE_HIVESTACK
  EXCHANGE_DRAX
  EXCHANGE_APPLOVIN_GBID
  EXCHANGE_FYBER_GBID
  EXCHANGE_UNITY_GBID
  EXCHANGE_CHARTBOOST_GBID
  EXCHANGE_ADMOST_GBID
  EXCHANGE_TOPON_GBID],
 :legacyGuaranteedOrderId string,
 :defaultCampaignId string}

optional:
updateMask <string> Required. The mask to control which fields to update.
partnerId <string> The ID of the partner that the request is being made within.
advertiserId <string> The ID of the advertiser that the request is being made within."
  ([guaranteedOrderId GuaranteedOrder]
    (guaranteedOrders-patch guaranteedOrderId GuaranteedOrder nil))
  ([guaranteedOrderId GuaranteedOrder optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/guaranteedOrders/{+guaranteedOrderId}",
       :uri-template-args {:guaranteedOrderId guaranteedOrderId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body GuaranteedOrder})))

(defn guaranteedOrders-editGuaranteedOrderReadAccessors
  "Edits read advertisers of a guaranteed order.
https://developers.google.com/display-video/api/guides/getting-started/overview

guaranteedOrderId <string> Required. The ID of the guaranteed order to edit. The ID is of the format `{exchange}-{legacy_guaranteed_order_id}`
EditGuaranteedOrderReadAccessorsRequest:
{:partnerId string,
 :readAccessInherited boolean,
 :addedAdvertisers [string],
 :removedAdvertisers [string]}"
  [guaranteedOrderId EditGuaranteedOrderReadAccessorsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/guaranteedOrders/{+guaranteedOrderId}:editGuaranteedOrderReadAccessors",
     :uri-template-args {:guaranteedOrderId guaranteedOrderId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body EditGuaranteedOrderReadAccessorsRequest}))

(defn inventorySources-get
  "Gets an inventory source.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceId <string> Required. The ID of the inventory source to fetch.

optional:
partnerId <string> Required. The ID of the DV360 partner to which the fetched inventory source is permissioned.
advertiserId <string> Optional. The ID of the DV360 advertiser to which the fetched inventory source is permissioned. If the user only has access to the advertiser and not the parent partner, use this field to specify the relevant advertiser."
  ([inventorySourceId] (inventorySources-get inventorySourceId nil))
  ([inventorySourceId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySources/{+inventorySourceId}",
       :uri-template-args {:inventorySourceId inventorySourceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySources-list
  "Lists inventory sources that are accessible to the current user. The order is defined by the order_by parameter. If a filter by entity_status is not specified, inventory sources with entity status `ENTITY_STATUS_ARCHIVED` will not be included in the results.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> The ID of the partner that has access to the inventory source.
advertiserId <string> The ID of the advertiser that has access to the inventory source.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. For example, `displayName desc`.
filter <string> Allows filtering by inventory source fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `status.entityStatus` * `commitment` * `deliveryMethod` * `rateDetails.rateType` * `exchange` Examples: * All active inventory sources: `status.entityStatus=\"ENTITY_STATUS_ACTIVE\"` * Inventory sources belonging to Google Ad Manager or Rubicon exchanges: `exchange=\"EXCHANGE_GOOGLE_AD_MANAGER\" OR exchange=\"EXCHANGE_RUBICON\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (inventorySources-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySources",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySources-create
  "Creates a new inventory source. Returns the newly created inventory source if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

InventorySource:
{:guaranteedOrderId string,
 :timeRange {:startTime string, :endTime string},
 :displayName string,
 :readAdvertiserIds [string],
 :name string,
 :inventorySourceType
 [INVENTORY_SOURCE_TYPE_UNSPECIFIED
  INVENTORY_SOURCE_TYPE_PRIVATE
  INVENTORY_SOURCE_TYPE_AUCTION_PACKAGE],
 :commitment
 [INVENTORY_SOURCE_COMMITMENT_UNSPECIFIED
  INVENTORY_SOURCE_COMMITMENT_GUARANTEED
  INVENTORY_SOURCE_COMMITMENT_NON_GUARANTEED],
 :rateDetails
 {:inventorySourceRateType
  [INVENTORY_SOURCE_RATE_TYPE_UNSPECIFIED
   INVENTORY_SOURCE_RATE_TYPE_CPM_FIXED
   INVENTORY_SOURCE_RATE_TYPE_CPM_FLOOR
   INVENTORY_SOURCE_RATE_TYPE_CPD
   INVENTORY_SOURCE_RATE_TYPE_FLAT],
  :rate {:currencyCode string, :units string, :nanos integer},
  :unitsPurchased string,
  :minimumSpend {:currencyCode string, :units string, :nanos integer}},
 :updateTime string,
 :deliveryMethod
 [INVENTORY_SOURCE_DELIVERY_METHOD_UNSPECIFIED
  INVENTORY_SOURCE_DELIVERY_METHOD_PROGRAMMATIC
  INVENTORY_SOURCE_DELIVERY_METHOD_TAG],
 :publisherName string,
 :status
 {:entityStatus
  [ENTITY_STATUS_UNSPECIFIED
   ENTITY_STATUS_ACTIVE
   ENTITY_STATUS_ARCHIVED
   ENTITY_STATUS_DRAFT
   ENTITY_STATUS_PAUSED
   ENTITY_STATUS_SCHEDULED_FOR_DELETION],
  :entityPauseReason string,
  :sellerStatus
  [ENTITY_STATUS_UNSPECIFIED
   ENTITY_STATUS_ACTIVE
   ENTITY_STATUS_ARCHIVED
   ENTITY_STATUS_DRAFT
   ENTITY_STATUS_PAUSED
   ENTITY_STATUS_SCHEDULED_FOR_DELETION],
  :sellerPauseReason string,
  :configStatus
  [INVENTORY_SOURCE_CONFIG_STATUS_UNSPECIFIED
   INVENTORY_SOURCE_CONFIG_STATUS_PENDING
   INVENTORY_SOURCE_CONFIG_STATUS_COMPLETED]},
 :readWriteAccessors
 {:partner {:partnerId string},
  :advertisers {:advertiserIds [string]}},
 :inventorySourceId string,
 :exchange
 [EXCHANGE_UNSPECIFIED
  EXCHANGE_GOOGLE_AD_MANAGER
  EXCHANGE_APPNEXUS
  EXCHANGE_BRIGHTROLL
  EXCHANGE_ADFORM
  EXCHANGE_ADMETA
  EXCHANGE_ADMIXER
  EXCHANGE_ADSMOGO
  EXCHANGE_ADSWIZZ
  EXCHANGE_BIDSWITCH
  EXCHANGE_BRIGHTROLL_DISPLAY
  EXCHANGE_CADREON
  EXCHANGE_DAILYMOTION
  EXCHANGE_FIVE
  EXCHANGE_FLUCT
  EXCHANGE_FREEWHEEL
  EXCHANGE_GENIEE
  EXCHANGE_GUMGUM
  EXCHANGE_IMOBILE
  EXCHANGE_IBILLBOARD
  EXCHANGE_IMPROVE_DIGITAL
  EXCHANGE_INDEX
  EXCHANGE_KARGO
  EXCHANGE_MICROAD
  EXCHANGE_MOPUB
  EXCHANGE_NEND
  EXCHANGE_ONE_BY_AOL_DISPLAY
  EXCHANGE_ONE_BY_AOL_MOBILE
  EXCHANGE_ONE_BY_AOL_VIDEO
  EXCHANGE_OOYALA
  EXCHANGE_OPENX
  EXCHANGE_PERMODO
  EXCHANGE_PLATFORMONE
  EXCHANGE_PLATFORMID
  EXCHANGE_PUBMATIC
  EXCHANGE_PULSEPOINT
  EXCHANGE_REVENUEMAX
  EXCHANGE_RUBICON
  EXCHANGE_SMARTCLIP
  EXCHANGE_SMARTRTB
  EXCHANGE_SMARTSTREAMTV
  EXCHANGE_SOVRN
  EXCHANGE_SPOTXCHANGE
  EXCHANGE_STROER
  EXCHANGE_TEADSTV
  EXCHANGE_TELARIA
  EXCHANGE_TVN
  EXCHANGE_UNITED
  EXCHANGE_YIELDLAB
  EXCHANGE_YIELDMO
  EXCHANGE_UNRULYX
  EXCHANGE_OPEN8
  EXCHANGE_TRITON
  EXCHANGE_TRIPLELIFT
  EXCHANGE_TABOOLA
  EXCHANGE_INMOBI
  EXCHANGE_SMAATO
  EXCHANGE_AJA
  EXCHANGE_SUPERSHIP
  EXCHANGE_NEXSTAR_DIGITAL
  EXCHANGE_WAZE
  EXCHANGE_SOUNDCAST
  EXCHANGE_SHARETHROUGH
  EXCHANGE_FYBER
  EXCHANGE_RED_FOR_PUBLISHERS
  EXCHANGE_MEDIANET
  EXCHANGE_TAPJOY
  EXCHANGE_VISTAR
  EXCHANGE_DAX
  EXCHANGE_JCD
  EXCHANGE_PLACE_EXCHANGE
  EXCHANGE_APPLOVIN
  EXCHANGE_CONNATIX
  EXCHANGE_RESET_DIGITAL
  EXCHANGE_HIVESTACK
  EXCHANGE_DRAX
  EXCHANGE_APPLOVIN_GBID
  EXCHANGE_FYBER_GBID
  EXCHANGE_UNITY_GBID
  EXCHANGE_CHARTBOOST_GBID
  EXCHANGE_ADMOST_GBID
  EXCHANGE_TOPON_GBID],
 :dealId string,
 :creativeConfigs
 [{:creativeType
   [CREATIVE_TYPE_UNSPECIFIED
    CREATIVE_TYPE_STANDARD
    CREATIVE_TYPE_EXPANDABLE
    CREATIVE_TYPE_VIDEO
    CREATIVE_TYPE_NATIVE
    CREATIVE_TYPE_TEMPLATED_APP_INSTALL
    CREATIVE_TYPE_NATIVE_SITE_SQUARE
    CREATIVE_TYPE_TEMPLATED_APP_INSTALL_INTERSTITIAL
    CREATIVE_TYPE_LIGHTBOX
    CREATIVE_TYPE_NATIVE_APP_INSTALL
    CREATIVE_TYPE_NATIVE_APP_INSTALL_SQUARE
    CREATIVE_TYPE_AUDIO
    CREATIVE_TYPE_PUBLISHER_HOSTED
    CREATIVE_TYPE_NATIVE_VIDEO
    CREATIVE_TYPE_TEMPLATED_APP_INSTALL_VIDEO],
   :displayCreativeConfig
   {:creativeSize {:widthPixels integer, :heightPixels integer}},
   :videoCreativeConfig {:duration string}}],
 :inventorySourceProductType
 [INVENTORY_SOURCE_PRODUCT_TYPE_UNSPECIFIED
  PREFERRED_DEAL
  PRIVATE_AUCTION
  PROGRAMMATIC_GUARANTEED
  TAG_GUARANTEED
  YOUTUBE_RESERVE
  INSTANT_RESERVE
  GUARANTEED_PACKAGE
  PROGRAMMATIC_TV
  AUCTION_PACKAGE],
 :readPartnerIds [string]}

optional:
partnerId <string> The ID of the partner that the request is being made within.
advertiserId <string> The ID of the advertiser that the request is being made within."
  ([InventorySource] (inventorySources-create InventorySource nil))
  ([InventorySource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySources",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body InventorySource})))

(defn inventorySources-patch
  "Updates an existing inventory source. Returns the updated inventory source if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceId <string> Output only. The unique ID of the inventory source. Assigned by the system.
InventorySource:
{:guaranteedOrderId string,
 :timeRange {:startTime string, :endTime string},
 :displayName string,
 :readAdvertiserIds [string],
 :name string,
 :inventorySourceType
 [INVENTORY_SOURCE_TYPE_UNSPECIFIED
  INVENTORY_SOURCE_TYPE_PRIVATE
  INVENTORY_SOURCE_TYPE_AUCTION_PACKAGE],
 :commitment
 [INVENTORY_SOURCE_COMMITMENT_UNSPECIFIED
  INVENTORY_SOURCE_COMMITMENT_GUARANTEED
  INVENTORY_SOURCE_COMMITMENT_NON_GUARANTEED],
 :rateDetails
 {:inventorySourceRateType
  [INVENTORY_SOURCE_RATE_TYPE_UNSPECIFIED
   INVENTORY_SOURCE_RATE_TYPE_CPM_FIXED
   INVENTORY_SOURCE_RATE_TYPE_CPM_FLOOR
   INVENTORY_SOURCE_RATE_TYPE_CPD
   INVENTORY_SOURCE_RATE_TYPE_FLAT],
  :rate {:currencyCode string, :units string, :nanos integer},
  :unitsPurchased string,
  :minimumSpend {:currencyCode string, :units string, :nanos integer}},
 :updateTime string,
 :deliveryMethod
 [INVENTORY_SOURCE_DELIVERY_METHOD_UNSPECIFIED
  INVENTORY_SOURCE_DELIVERY_METHOD_PROGRAMMATIC
  INVENTORY_SOURCE_DELIVERY_METHOD_TAG],
 :publisherName string,
 :status
 {:entityStatus
  [ENTITY_STATUS_UNSPECIFIED
   ENTITY_STATUS_ACTIVE
   ENTITY_STATUS_ARCHIVED
   ENTITY_STATUS_DRAFT
   ENTITY_STATUS_PAUSED
   ENTITY_STATUS_SCHEDULED_FOR_DELETION],
  :entityPauseReason string,
  :sellerStatus
  [ENTITY_STATUS_UNSPECIFIED
   ENTITY_STATUS_ACTIVE
   ENTITY_STATUS_ARCHIVED
   ENTITY_STATUS_DRAFT
   ENTITY_STATUS_PAUSED
   ENTITY_STATUS_SCHEDULED_FOR_DELETION],
  :sellerPauseReason string,
  :configStatus
  [INVENTORY_SOURCE_CONFIG_STATUS_UNSPECIFIED
   INVENTORY_SOURCE_CONFIG_STATUS_PENDING
   INVENTORY_SOURCE_CONFIG_STATUS_COMPLETED]},
 :readWriteAccessors
 {:partner {:partnerId string},
  :advertisers {:advertiserIds [string]}},
 :inventorySourceId string,
 :exchange
 [EXCHANGE_UNSPECIFIED
  EXCHANGE_GOOGLE_AD_MANAGER
  EXCHANGE_APPNEXUS
  EXCHANGE_BRIGHTROLL
  EXCHANGE_ADFORM
  EXCHANGE_ADMETA
  EXCHANGE_ADMIXER
  EXCHANGE_ADSMOGO
  EXCHANGE_ADSWIZZ
  EXCHANGE_BIDSWITCH
  EXCHANGE_BRIGHTROLL_DISPLAY
  EXCHANGE_CADREON
  EXCHANGE_DAILYMOTION
  EXCHANGE_FIVE
  EXCHANGE_FLUCT
  EXCHANGE_FREEWHEEL
  EXCHANGE_GENIEE
  EXCHANGE_GUMGUM
  EXCHANGE_IMOBILE
  EXCHANGE_IBILLBOARD
  EXCHANGE_IMPROVE_DIGITAL
  EXCHANGE_INDEX
  EXCHANGE_KARGO
  EXCHANGE_MICROAD
  EXCHANGE_MOPUB
  EXCHANGE_NEND
  EXCHANGE_ONE_BY_AOL_DISPLAY
  EXCHANGE_ONE_BY_AOL_MOBILE
  EXCHANGE_ONE_BY_AOL_VIDEO
  EXCHANGE_OOYALA
  EXCHANGE_OPENX
  EXCHANGE_PERMODO
  EXCHANGE_PLATFORMONE
  EXCHANGE_PLATFORMID
  EXCHANGE_PUBMATIC
  EXCHANGE_PULSEPOINT
  EXCHANGE_REVENUEMAX
  EXCHANGE_RUBICON
  EXCHANGE_SMARTCLIP
  EXCHANGE_SMARTRTB
  EXCHANGE_SMARTSTREAMTV
  EXCHANGE_SOVRN
  EXCHANGE_SPOTXCHANGE
  EXCHANGE_STROER
  EXCHANGE_TEADSTV
  EXCHANGE_TELARIA
  EXCHANGE_TVN
  EXCHANGE_UNITED
  EXCHANGE_YIELDLAB
  EXCHANGE_YIELDMO
  EXCHANGE_UNRULYX
  EXCHANGE_OPEN8
  EXCHANGE_TRITON
  EXCHANGE_TRIPLELIFT
  EXCHANGE_TABOOLA
  EXCHANGE_INMOBI
  EXCHANGE_SMAATO
  EXCHANGE_AJA
  EXCHANGE_SUPERSHIP
  EXCHANGE_NEXSTAR_DIGITAL
  EXCHANGE_WAZE
  EXCHANGE_SOUNDCAST
  EXCHANGE_SHARETHROUGH
  EXCHANGE_FYBER
  EXCHANGE_RED_FOR_PUBLISHERS
  EXCHANGE_MEDIANET
  EXCHANGE_TAPJOY
  EXCHANGE_VISTAR
  EXCHANGE_DAX
  EXCHANGE_JCD
  EXCHANGE_PLACE_EXCHANGE
  EXCHANGE_APPLOVIN
  EXCHANGE_CONNATIX
  EXCHANGE_RESET_DIGITAL
  EXCHANGE_HIVESTACK
  EXCHANGE_DRAX
  EXCHANGE_APPLOVIN_GBID
  EXCHANGE_FYBER_GBID
  EXCHANGE_UNITY_GBID
  EXCHANGE_CHARTBOOST_GBID
  EXCHANGE_ADMOST_GBID
  EXCHANGE_TOPON_GBID],
 :dealId string,
 :creativeConfigs
 [{:creativeType
   [CREATIVE_TYPE_UNSPECIFIED
    CREATIVE_TYPE_STANDARD
    CREATIVE_TYPE_EXPANDABLE
    CREATIVE_TYPE_VIDEO
    CREATIVE_TYPE_NATIVE
    CREATIVE_TYPE_TEMPLATED_APP_INSTALL
    CREATIVE_TYPE_NATIVE_SITE_SQUARE
    CREATIVE_TYPE_TEMPLATED_APP_INSTALL_INTERSTITIAL
    CREATIVE_TYPE_LIGHTBOX
    CREATIVE_TYPE_NATIVE_APP_INSTALL
    CREATIVE_TYPE_NATIVE_APP_INSTALL_SQUARE
    CREATIVE_TYPE_AUDIO
    CREATIVE_TYPE_PUBLISHER_HOSTED
    CREATIVE_TYPE_NATIVE_VIDEO
    CREATIVE_TYPE_TEMPLATED_APP_INSTALL_VIDEO],
   :displayCreativeConfig
   {:creativeSize {:widthPixels integer, :heightPixels integer}},
   :videoCreativeConfig {:duration string}}],
 :inventorySourceProductType
 [INVENTORY_SOURCE_PRODUCT_TYPE_UNSPECIFIED
  PREFERRED_DEAL
  PRIVATE_AUCTION
  PROGRAMMATIC_GUARANTEED
  TAG_GUARANTEED
  YOUTUBE_RESERVE
  INSTANT_RESERVE
  GUARANTEED_PACKAGE
  PROGRAMMATIC_TV
  AUCTION_PACKAGE],
 :readPartnerIds [string]}

optional:
updateMask <string> Required. The mask to control which fields to update.
partnerId <string> The ID of the partner that the request is being made within.
advertiserId <string> The ID of the advertiser that the request is being made within."
  ([inventorySourceId InventorySource]
    (inventorySources-patch inventorySourceId InventorySource nil))
  ([inventorySourceId InventorySource optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySources/{+inventorySourceId}",
       :uri-template-args {:inventorySourceId inventorySourceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body InventorySource})))

(defn inventorySources-editInventorySourceReadWriteAccessors
  "Edits read/write accessors of an inventory source. Returns the updated read_write_accessors for the inventory source.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceId <string> Required. The ID of inventory source to update.
EditInventorySourceReadWriteAccessorsRequest:
{:partnerId string,
 :assignPartner boolean,
 :advertisersUpdate
 {:addedAdvertisers [string], :removedAdvertisers [string]}}"
  [inventorySourceId EditInventorySourceReadWriteAccessorsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/inventorySources/{+inventorySourceId}:editInventorySourceReadWriteAccessors",
     :uri-template-args {:inventorySourceId inventorySourceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body EditInventorySourceReadWriteAccessorsRequest}))

(defn firstAndThirdPartyAudiences-get
  "Gets a first and third party audience.
https://developers.google.com/display-video/api/guides/getting-started/overview

firstAndThirdPartyAudienceId <string> Required. The ID of the first and third party audience to fetch.

optional:
partnerId <string> The ID of the partner that has access to the fetched first and third party audience.
advertiserId <string> The ID of the advertiser that has access to the fetched first and third party audience."
  ([firstAndThirdPartyAudienceId]
    (firstAndThirdPartyAudiences-get firstAndThirdPartyAudienceId nil))
  ([firstAndThirdPartyAudienceId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/firstAndThirdPartyAudiences/{+firstAndThirdPartyAudienceId}",
       :uri-template-args
       {:firstAndThirdPartyAudienceId firstAndThirdPartyAudienceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn firstAndThirdPartyAudiences-list
  "Lists first and third party audiences. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> The ID of the partner that has access to the fetched first and third party audiences.
advertiserId <string> The ID of the advertiser that has access to the fetched first and third party audiences.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `firstAndThirdPartyAudienceId` (default) * `displayName` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by first and third party audience fields. Supported syntax: * Filter expressions for first and third party audiences can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `displayName` Examples: * All first and third party audiences for which the display name contains \"Google\": `displayName:\"Google\"`. The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (firstAndThirdPartyAudiences-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/firstAndThirdPartyAudiences",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn firstAndThirdPartyAudiences-create
  "Creates a FirstAndThirdPartyAudience. Only supported for the following audience_type: * `CUSTOMER_MATCH_CONTACT_INFO` * `CUSTOMER_MATCH_DEVICE_ID`
https://developers.google.com/display-video/api/guides/getting-started/overview

FirstAndThirdPartyAudience:
{:description string,
 :firstAndThirdPartyAudienceType
 [FIRST_AND_THIRD_PARTY_AUDIENCE_TYPE_UNSPECIFIED
  FIRST_AND_THIRD_PARTY_AUDIENCE_TYPE_FIRST_PARTY
  FIRST_AND_THIRD_PARTY_AUDIENCE_TYPE_THIRD_PARTY],
 :audienceSource
 [AUDIENCE_SOURCE_UNSPECIFIED
  DISPLAY_VIDEO_360
  CAMPAIGN_MANAGER
  AD_MANAGER
  SEARCH_ADS_360
  YOUTUBE
  ADS_DATA_HUB],
 :displayName string,
 :contactInfoList
 {:contactInfos
  [{:hashedFirstName string,
    :hashedLastName string,
    :countryCode string,
    :hashedEmails [string],
    :hashedPhoneNumbers [string],
    :zipCodes [string]}],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :name string,
 :audienceType
 [AUDIENCE_TYPE_UNSPECIFIED
  CUSTOMER_MATCH_CONTACT_INFO
  CUSTOMER_MATCH_DEVICE_ID
  CUSTOMER_MATCH_USER_ID
  ACTIVITY_BASED
  FREQUENCY_CAP
  TAG_BASED
  YOUTUBE_USERS
  LICENSED],
 :gmailAudienceSize string,
 :activeDisplayAudienceSize string,
 :membershipDurationDays string,
 :displayDesktopAudienceSize string,
 :appId string,
 :firstAndThirdPartyAudienceId string,
 :displayMobileWebAudienceSize string,
 :youtubeAudienceSize string,
 :mobileDeviceIdList
 {:mobileDeviceIds [string],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :displayAudienceSize string,
 :displayMobileAppAudienceSize string}

optional:
advertiserId <string> Required. The ID of the advertiser under whom the FirstAndThirdPartyAudience will be created."
  ([FirstAndThirdPartyAudience]
    (firstAndThirdPartyAudiences-create
      FirstAndThirdPartyAudience
      nil))
  ([FirstAndThirdPartyAudience optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/firstAndThirdPartyAudiences",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body FirstAndThirdPartyAudience})))

(defn firstAndThirdPartyAudiences-patch
  "Updates an existing FirstAndThirdPartyAudience. Only supported for the following audience_type: * `CUSTOMER_MATCH_CONTACT_INFO` * `CUSTOMER_MATCH_DEVICE_ID`
https://developers.google.com/display-video/api/guides/getting-started/overview

firstAndThirdPartyAudienceId <string> Output only. The unique ID of the first and third party audience. Assigned by the system.
FirstAndThirdPartyAudience:
{:description string,
 :firstAndThirdPartyAudienceType
 [FIRST_AND_THIRD_PARTY_AUDIENCE_TYPE_UNSPECIFIED
  FIRST_AND_THIRD_PARTY_AUDIENCE_TYPE_FIRST_PARTY
  FIRST_AND_THIRD_PARTY_AUDIENCE_TYPE_THIRD_PARTY],
 :audienceSource
 [AUDIENCE_SOURCE_UNSPECIFIED
  DISPLAY_VIDEO_360
  CAMPAIGN_MANAGER
  AD_MANAGER
  SEARCH_ADS_360
  YOUTUBE
  ADS_DATA_HUB],
 :displayName string,
 :contactInfoList
 {:contactInfos
  [{:hashedFirstName string,
    :hashedLastName string,
    :countryCode string,
    :hashedEmails [string],
    :hashedPhoneNumbers [string],
    :zipCodes [string]}],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :name string,
 :audienceType
 [AUDIENCE_TYPE_UNSPECIFIED
  CUSTOMER_MATCH_CONTACT_INFO
  CUSTOMER_MATCH_DEVICE_ID
  CUSTOMER_MATCH_USER_ID
  ACTIVITY_BASED
  FREQUENCY_CAP
  TAG_BASED
  YOUTUBE_USERS
  LICENSED],
 :gmailAudienceSize string,
 :activeDisplayAudienceSize string,
 :membershipDurationDays string,
 :displayDesktopAudienceSize string,
 :appId string,
 :firstAndThirdPartyAudienceId string,
 :displayMobileWebAudienceSize string,
 :youtubeAudienceSize string,
 :mobileDeviceIdList
 {:mobileDeviceIds [string],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :displayAudienceSize string,
 :displayMobileAppAudienceSize string}

optional:
updateMask <string> Required. The mask to control which fields to update. Updates are only supported for the following fields: * `displayName` * `description` * `membershipDurationDays`
advertiserId <string> Required. The ID of the owner advertiser of the updated FirstAndThirdPartyAudience."
  ([firstAndThirdPartyAudienceId FirstAndThirdPartyAudience]
    (firstAndThirdPartyAudiences-patch
      firstAndThirdPartyAudienceId
      FirstAndThirdPartyAudience
      nil))
  ([firstAndThirdPartyAudienceId FirstAndThirdPartyAudience optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/firstAndThirdPartyAudiences/{+firstAndThirdPartyAudienceId}",
       :uri-template-args
       {:firstAndThirdPartyAudienceId firstAndThirdPartyAudienceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body FirstAndThirdPartyAudience})))

(defn firstAndThirdPartyAudiences-editCustomerMatchMembers
  "Updates the member list of a Customer Match audience. Only supported for the following audience_type: * `CUSTOMER_MATCH_CONTACT_INFO` * `CUSTOMER_MATCH_DEVICE_ID`
https://developers.google.com/display-video/api/guides/getting-started/overview

firstAndThirdPartyAudienceId <string> Required. The ID of the Customer Match FirstAndThirdPartyAudience whose members will be edited.
EditCustomerMatchMembersRequest:
{:addedContactInfoList
 {:contactInfos
  [{:hashedFirstName string,
    :hashedLastName string,
    :countryCode string,
    :hashedEmails [string],
    :hashedPhoneNumbers [string],
    :zipCodes [string]}],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :addedMobileDeviceIdList
 {:mobileDeviceIds [string],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :removedContactInfoList
 {:contactInfos
  [{:hashedFirstName string,
    :hashedLastName string,
    :countryCode string,
    :hashedEmails [string],
    :hashedPhoneNumbers [string],
    :zipCodes [string]}],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :removedMobileDeviceIdList
 {:mobileDeviceIds [string],
  :consent
  {:adUserData
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED],
   :adPersonalization
   [CONSENT_STATUS_UNSPECIFIED
    CONSENT_STATUS_GRANTED
    CONSENT_STATUS_DENIED]}},
 :advertiserId string}"
  [firstAndThirdPartyAudienceId EditCustomerMatchMembersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/firstAndThirdPartyAudiences/{+firstAndThirdPartyAudienceId}:editCustomerMatchMembers",
     :uri-template-args
     {:firstAndThirdPartyAudienceId firstAndThirdPartyAudienceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body EditCustomerMatchMembersRequest}))

(defn advertisers-listAssignedTargetingOptions
  "Lists assigned targeting options of an advertiser across targeting types.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line item belongs to.

optional:
pageSize <integer> Requested page size. The size must be an integer between `1` and `5000`. If unspecified, the default is '5000'. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `targetingType` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `targetingType desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the `OR` logical operator. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=) operator`. Supported fields: * `targetingType` Examples: * targetingType with value TARGETING_TYPE_CHANNEL `targetingType=\"TARGETING_TYPE_CHANNEL\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId]
    (advertisers-listAssignedTargetingOptions advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}:listAssignedTargetingOptions",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-editAssignedTargetingOptions
  "Edits targeting options under a single advertiser. The operation will delete the assigned targeting options provided in BulkEditAdvertiserAssignedTargetingOptionsRequest.delete_requests and then create the assigned targeting options provided in BulkEditAdvertiserAssignedTargetingOptionsRequest.create_requests .
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser.
BulkEditAdvertiserAssignedTargetingOptionsRequest:
{:deleteRequests
 [{:targetingType
   [TARGETING_TYPE_UNSPECIFIED
    TARGETING_TYPE_CHANNEL
    TARGETING_TYPE_APP_CATEGORY
    TARGETING_TYPE_APP
    TARGETING_TYPE_URL
    TARGETING_TYPE_DAY_AND_TIME
    TARGETING_TYPE_AGE_RANGE
    TARGETING_TYPE_REGIONAL_LOCATION_LIST
    TARGETING_TYPE_PROXIMITY_LOCATION_LIST
    TARGETING_TYPE_GENDER
    TARGETING_TYPE_VIDEO_PLAYER_SIZE
    TARGETING_TYPE_USER_REWARDED_CONTENT
    TARGETING_TYPE_PARENTAL_STATUS
    TARGETING_TYPE_CONTENT_INSTREAM_POSITION
    TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
    TARGETING_TYPE_DEVICE_TYPE
    TARGETING_TYPE_AUDIENCE_GROUP
    TARGETING_TYPE_BROWSER
    TARGETING_TYPE_HOUSEHOLD_INCOME
    TARGETING_TYPE_ON_SCREEN_POSITION
    TARGETING_TYPE_THIRD_PARTY_VERIFIER
    TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
    TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
    TARGETING_TYPE_ENVIRONMENT
    TARGETING_TYPE_CARRIER_AND_ISP
    TARGETING_TYPE_OPERATING_SYSTEM
    TARGETING_TYPE_DEVICE_MAKE_MODEL
    TARGETING_TYPE_KEYWORD
    TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
    TARGETING_TYPE_VIEWABILITY
    TARGETING_TYPE_CATEGORY
    TARGETING_TYPE_INVENTORY_SOURCE
    TARGETING_TYPE_LANGUAGE
    TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
    TARGETING_TYPE_GEO_REGION
    TARGETING_TYPE_INVENTORY_SOURCE_GROUP
    TARGETING_TYPE_EXCHANGE
    TARGETING_TYPE_SUB_EXCHANGE
    TARGETING_TYPE_POI
    TARGETING_TYPE_BUSINESS_CHAIN
    TARGETING_TYPE_CONTENT_DURATION
    TARGETING_TYPE_CONTENT_STREAM_TYPE
    TARGETING_TYPE_NATIVE_CONTENT_POSITION
    TARGETING_TYPE_OMID
    TARGETING_TYPE_AUDIO_CONTENT_TYPE
    TARGETING_TYPE_CONTENT_GENRE
    TARGETING_TYPE_YOUTUBE_VIDEO
    TARGETING_TYPE_YOUTUBE_CHANNEL
    TARGETING_TYPE_SESSION_POSITION],
   :assignedTargetingOptionIds [string]}],
 :createRequests
 [{:targetingType
   [TARGETING_TYPE_UNSPECIFIED
    TARGETING_TYPE_CHANNEL
    TARGETING_TYPE_APP_CATEGORY
    TARGETING_TYPE_APP
    TARGETING_TYPE_URL
    TARGETING_TYPE_DAY_AND_TIME
    TARGETING_TYPE_AGE_RANGE
    TARGETING_TYPE_REGIONAL_LOCATION_LIST
    TARGETING_TYPE_PROXIMITY_LOCATION_LIST
    TARGETING_TYPE_GENDER
    TARGETING_TYPE_VIDEO_PLAYER_SIZE
    TARGETING_TYPE_USER_REWARDED_CONTENT
    TARGETING_TYPE_PARENTAL_STATUS
    TARGETING_TYPE_CONTENT_INSTREAM_POSITION
    TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
    TARGETING_TYPE_DEVICE_TYPE
    TARGETING_TYPE_AUDIENCE_GROUP
    TARGETING_TYPE_BROWSER
    TARGETING_TYPE_HOUSEHOLD_INCOME
    TARGETING_TYPE_ON_SCREEN_POSITION
    TARGETING_TYPE_THIRD_PARTY_VERIFIER
    TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
    TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
    TARGETING_TYPE_ENVIRONMENT
    TARGETING_TYPE_CARRIER_AND_ISP
    TARGETING_TYPE_OPERATING_SYSTEM
    TARGETING_TYPE_DEVICE_MAKE_MODEL
    TARGETING_TYPE_KEYWORD
    TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
    TARGETING_TYPE_VIEWABILITY
    TARGETING_TYPE_CATEGORY
    TARGETING_TYPE_INVENTORY_SOURCE
    TARGETING_TYPE_LANGUAGE
    TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
    TARGETING_TYPE_GEO_REGION
    TARGETING_TYPE_INVENTORY_SOURCE_GROUP
    TARGETING_TYPE_EXCHANGE
    TARGETING_TYPE_SUB_EXCHANGE
    TARGETING_TYPE_POI
    TARGETING_TYPE_BUSINESS_CHAIN
    TARGETING_TYPE_CONTENT_DURATION
    TARGETING_TYPE_CONTENT_STREAM_TYPE
    TARGETING_TYPE_NATIVE_CONTENT_POSITION
    TARGETING_TYPE_OMID
    TARGETING_TYPE_AUDIO_CONTENT_TYPE
    TARGETING_TYPE_CONTENT_GENRE
    TARGETING_TYPE_YOUTUBE_VIDEO
    TARGETING_TYPE_YOUTUBE_CHANNEL
    TARGETING_TYPE_SESSION_POSITION],
   :assignedTargetingOptions
   [{:contentGenreDetails
     {:targetingOptionId string,
      :displayName string,
      :negative boolean},
     :negativeKeywordListDetails {:negativeKeywordListId string},
     :parentalStatusDetails
     {:parentalStatus
      [PARENTAL_STATUS_UNSPECIFIED
       PARENTAL_STATUS_PARENT
       PARENTAL_STATUS_NOT_A_PARENT
       PARENTAL_STATUS_UNKNOWN]},
     :geoRegionDetails
     {:displayName string,
      :targetingOptionId string,
      :geoRegionType
      [GEO_REGION_TYPE_UNKNOWN
       GEO_REGION_TYPE_OTHER
       GEO_REGION_TYPE_COUNTRY
       GEO_REGION_TYPE_REGION
       GEO_REGION_TYPE_TERRITORY
       GEO_REGION_TYPE_PROVINCE
       GEO_REGION_TYPE_STATE
       GEO_REGION_TYPE_PREFECTURE
       GEO_REGION_TYPE_GOVERNORATE
       GEO_REGION_TYPE_CANTON
       GEO_REGION_TYPE_UNION_TERRITORY
       GEO_REGION_TYPE_AUTONOMOUS_COMMUNITY
       GEO_REGION_TYPE_DMA_REGION
       GEO_REGION_TYPE_METRO
       GEO_REGION_TYPE_CONGRESSIONAL_DISTRICT
       GEO_REGION_TYPE_COUNTY
       GEO_REGION_TYPE_MUNICIPALITY
       GEO_REGION_TYPE_CITY
       GEO_REGION_TYPE_POSTAL_CODE
       GEO_REGION_TYPE_DEPARTMENT
       GEO_REGION_TYPE_AIRPORT
       GEO_REGION_TYPE_TV_REGION
       GEO_REGION_TYPE_OKRUG
       GEO_REGION_TYPE_BOROUGH
       GEO_REGION_TYPE_CITY_REGION
       GEO_REGION_TYPE_ARRONDISSEMENT
       GEO_REGION_TYPE_NEIGHBORHOOD
       GEO_REGION_TYPE_UNIVERSITY
       GEO_REGION_TYPE_DISTRICT],
      :negative boolean},
     :regionalLocationListDetails
     {:regionalLocationListId string, :negative boolean},
     :browserDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :inventorySourceGroupDetails {:inventorySourceGroupId string},
     :nativeContentPositionDetails
     {:contentPosition
      [NATIVE_CONTENT_POSITION_UNSPECIFIED
       NATIVE_CONTENT_POSITION_UNKNOWN
       NATIVE_CONTENT_POSITION_IN_ARTICLE
       NATIVE_CONTENT_POSITION_IN_FEED
       NATIVE_CONTENT_POSITION_PERIPHERAL
       NATIVE_CONTENT_POSITION_RECOMMENDATION]},
     :assignedTargetingOptionId string,
     :operatingSystemDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :appCategoryDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :contentInstreamPositionDetails
     {:contentInstreamPosition
      [CONTENT_INSTREAM_POSITION_UNSPECIFIED
       CONTENT_INSTREAM_POSITION_PRE_ROLL
       CONTENT_INSTREAM_POSITION_MID_ROLL
       CONTENT_INSTREAM_POSITION_POST_ROLL
       CONTENT_INSTREAM_POSITION_UNKNOWN],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :inventorySourceDetails {:inventorySourceId string},
     :audioContentTypeDetails
     {:audioContentType
      [AUDIO_CONTENT_TYPE_UNSPECIFIED
       AUDIO_CONTENT_TYPE_UNKNOWN
       AUDIO_CONTENT_TYPE_MUSIC
       AUDIO_CONTENT_TYPE_BROADCAST
       AUDIO_CONTENT_TYPE_PODCAST]},
     :thirdPartyVerifierDetails
     {:adloox
      {:excludedAdlooxCategories
       [[ADLOOX_UNSPECIFIED
         ADULT_CONTENT_HARD
         ADULT_CONTENT_SOFT
         ILLEGAL_CONTENT
         BORDERLINE_CONTENT
         DISCRIMINATORY_CONTENT
         VIOLENT_CONTENT_WEAPONS
         LOW_VIEWABILITY_DOMAINS
         FRAUD]]},
      :doubleVerify
      {:brandSafetyCategories DoubleVerifyBrandSafetyCategories,
       :avoidedAgeRatings
       [[AGE_RATING_UNSPECIFIED
         APP_AGE_RATE_UNKNOWN
         APP_AGE_RATE_4_PLUS
         APP_AGE_RATE_9_PLUS
         APP_AGE_RATE_12_PLUS
         APP_AGE_RATE_17_PLUS
         APP_AGE_RATE_18_PLUS]],
       :appStarRating DoubleVerifyAppStarRating,
       :displayViewability DoubleVerifyDisplayViewability,
       :videoViewability DoubleVerifyVideoViewability,
       :fraudInvalidTraffic DoubleVerifyFraudInvalidTraffic,
       :customSegmentId string},
      :integralAdScience
      {:excludedIllegalDownloadsRisk
       [ILLEGAL_DOWNLOADS_UNSPECIFIED
        ILLEGAL_DOWNLOADS_HR
        ILLEGAL_DOWNLOADS_HMR],
       :excludedOffensiveLanguageRisk
       [OFFENSIVE_LANGUAGE_UNSPECIFIED
        OFFENSIVE_LANGUAGE_HR
        OFFENSIVE_LANGUAGE_HMR],
       :excludeUnrateable boolean,
       :excludedDrugsRisk [DRUGS_UNSPECIFIED DRUGS_HR DRUGS_HMR],
       :excludedGamblingRisk
       [GAMBLING_UNSPECIFIED GAMBLING_HR GAMBLING_HMR],
       :excludedAdultRisk [ADULT_UNSPECIFIED ADULT_HR ADULT_HMR],
       :displayViewability
       [PERFORMANCE_VIEWABILITY_UNSPECIFIED
        PERFORMANCE_VIEWABILITY_40
        PERFORMANCE_VIEWABILITY_50
        PERFORMANCE_VIEWABILITY_60
        PERFORMANCE_VIEWABILITY_70],
       :excludedViolenceRisk
       [VIOLENCE_UNSPECIFIED VIOLENCE_HR VIOLENCE_HMR],
       :traqScoreOption
       [TRAQ_UNSPECIFIED
        TRAQ_250
        TRAQ_500
        TRAQ_600
        TRAQ_700
        TRAQ_750
        TRAQ_875
        TRAQ_1000],
       :excludedHateSpeechRisk
       [HATE_SPEECH_UNSPECIFIED HATE_SPEECH_HR HATE_SPEECH_HMR],
       :videoViewability
       [VIDEO_VIEWABILITY_UNSPECIFIED
        VIDEO_VIEWABILITY_40
        VIDEO_VIEWABILITY_50
        VIDEO_VIEWABILITY_60
        VIDEO_VIEWABILITY_70],
       :excludedAdFraudRisk
       [SUSPICIOUS_ACTIVITY_UNSPECIFIED
        SUSPICIOUS_ACTIVITY_HR
        SUSPICIOUS_ACTIVITY_HMR],
       :customSegmentId [string],
       :excludedAlcoholRisk
       [ALCOHOL_UNSPECIFIED ALCOHOL_HR ALCOHOL_HMR]}},
     :name string,
     :onScreenPositionDetails
     {:targetingOptionId string,
      :onScreenPosition
      [ON_SCREEN_POSITION_UNSPECIFIED
       ON_SCREEN_POSITION_UNKNOWN
       ON_SCREEN_POSITION_ABOVE_THE_FOLD
       ON_SCREEN_POSITION_BELOW_THE_FOLD],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :videoPlayerSizeDetails
     {:videoPlayerSize
      [VIDEO_PLAYER_SIZE_UNSPECIFIED
       VIDEO_PLAYER_SIZE_SMALL
       VIDEO_PLAYER_SIZE_LARGE
       VIDEO_PLAYER_SIZE_HD
       VIDEO_PLAYER_SIZE_UNKNOWN]},
     :carrierAndIspDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :proximityLocationListDetails
     {:proximityLocationListId string,
      :proximityRadius number,
      :proximityRadiusUnit
      [PROXIMITY_RADIUS_UNIT_UNSPECIFIED
       PROXIMITY_RADIUS_UNIT_MILES
       PROXIMITY_RADIUS_UNIT_KILOMETERS]},
     :contentStreamTypeDetails
     {:targetingOptionId string,
      :contentStreamType
      [CONTENT_STREAM_TYPE_UNSPECIFIED
       CONTENT_LIVE_STREAM
       CONTENT_ON_DEMAND]},
     :digitalContentLabelExclusionDetails
     {:excludedContentRatingTier
      [CONTENT_RATING_TIER_UNSPECIFIED
       CONTENT_RATING_TIER_UNRATED
       CONTENT_RATING_TIER_GENERAL
       CONTENT_RATING_TIER_PARENTAL_GUIDANCE
       CONTENT_RATING_TIER_TEENS
       CONTENT_RATING_TIER_MATURE
       CONTENT_RATING_TIER_FAMILIES]},
     :ageRangeDetails
     {:ageRange
      [AGE_RANGE_UNSPECIFIED
       AGE_RANGE_18_24
       AGE_RANGE_25_34
       AGE_RANGE_35_44
       AGE_RANGE_45_54
       AGE_RANGE_55_64
       AGE_RANGE_65_PLUS
       AGE_RANGE_UNKNOWN
       AGE_RANGE_18_20
       AGE_RANGE_21_24
       AGE_RANGE_25_29
       AGE_RANGE_30_34
       AGE_RANGE_35_39
       AGE_RANGE_40_44
       AGE_RANGE_45_49
       AGE_RANGE_50_54
       AGE_RANGE_55_59
       AGE_RANGE_60_64]},
     :deviceMakeModelDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :categoryDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :inheritance
     [INHERITANCE_UNSPECIFIED
      NOT_INHERITED
      INHERITED_FROM_PARTNER
      INHERITED_FROM_ADVERTISER],
     :businessChainDetails
     {:displayName string,
      :targetingOptionId string,
      :proximityRadiusAmount number,
      :proximityRadiusUnit
      [DISTANCE_UNIT_UNSPECIFIED
       DISTANCE_UNIT_MILES
       DISTANCE_UNIT_KILOMETERS]},
     :audienceGroupDetails
     {:includedFirstAndThirdPartyAudienceGroups
      [{:settings [FirstAndThirdPartyAudienceTargetingSetting]}],
      :includedGoogleAudienceGroup
      {:settings [GoogleAudienceTargetingSetting]},
      :includedCustomListGroup
      {:settings [CustomListTargetingSetting]},
      :includedCombinedAudienceGroup
      {:settings [CombinedAudienceTargetingSetting]},
      :excludedFirstAndThirdPartyAudienceGroup
      {:settings [FirstAndThirdPartyAudienceTargetingSetting]},
      :excludedGoogleAudienceGroup
      {:settings [GoogleAudienceTargetingSetting]}},
     :channelDetails {:channelId string, :negative boolean},
     :contentDurationDetails
     {:targetingOptionId string,
      :contentDuration
      [CONTENT_DURATION_UNSPECIFIED
       CONTENT_DURATION_UNKNOWN
       CONTENT_DURATION_0_TO_1_MIN
       CONTENT_DURATION_1_TO_5_MIN
       CONTENT_DURATION_5_TO_15_MIN
       CONTENT_DURATION_15_TO_30_MIN
       CONTENT_DURATION_30_TO_60_MIN
       CONTENT_DURATION_OVER_60_MIN]},
     :targetingType
     [TARGETING_TYPE_UNSPECIFIED
      TARGETING_TYPE_CHANNEL
      TARGETING_TYPE_APP_CATEGORY
      TARGETING_TYPE_APP
      TARGETING_TYPE_URL
      TARGETING_TYPE_DAY_AND_TIME
      TARGETING_TYPE_AGE_RANGE
      TARGETING_TYPE_REGIONAL_LOCATION_LIST
      TARGETING_TYPE_PROXIMITY_LOCATION_LIST
      TARGETING_TYPE_GENDER
      TARGETING_TYPE_VIDEO_PLAYER_SIZE
      TARGETING_TYPE_USER_REWARDED_CONTENT
      TARGETING_TYPE_PARENTAL_STATUS
      TARGETING_TYPE_CONTENT_INSTREAM_POSITION
      TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
      TARGETING_TYPE_DEVICE_TYPE
      TARGETING_TYPE_AUDIENCE_GROUP
      TARGETING_TYPE_BROWSER
      TARGETING_TYPE_HOUSEHOLD_INCOME
      TARGETING_TYPE_ON_SCREEN_POSITION
      TARGETING_TYPE_THIRD_PARTY_VERIFIER
      TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
      TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
      TARGETING_TYPE_ENVIRONMENT
      TARGETING_TYPE_CARRIER_AND_ISP
      TARGETING_TYPE_OPERATING_SYSTEM
      TARGETING_TYPE_DEVICE_MAKE_MODEL
      TARGETING_TYPE_KEYWORD
      TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
      TARGETING_TYPE_VIEWABILITY
      TARGETING_TYPE_CATEGORY
      TARGETING_TYPE_INVENTORY_SOURCE
      TARGETING_TYPE_LANGUAGE
      TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
      TARGETING_TYPE_GEO_REGION
      TARGETING_TYPE_INVENTORY_SOURCE_GROUP
      TARGETING_TYPE_EXCHANGE
      TARGETING_TYPE_SUB_EXCHANGE
      TARGETING_TYPE_POI
      TARGETING_TYPE_BUSINESS_CHAIN
      TARGETING_TYPE_CONTENT_DURATION
      TARGETING_TYPE_CONTENT_STREAM_TYPE
      TARGETING_TYPE_NATIVE_CONTENT_POSITION
      TARGETING_TYPE_OMID
      TARGETING_TYPE_AUDIO_CONTENT_TYPE
      TARGETING_TYPE_CONTENT_GENRE
      TARGETING_TYPE_YOUTUBE_VIDEO
      TARGETING_TYPE_YOUTUBE_CHANNEL
      TARGETING_TYPE_SESSION_POSITION],
     :environmentDetails
     {:environment
      [ENVIRONMENT_UNSPECIFIED
       ENVIRONMENT_WEB_OPTIMIZED
       ENVIRONMENT_WEB_NOT_OPTIMIZED
       ENVIRONMENT_APP]},
     :poiDetails
     {:displayName string,
      :targetingOptionId string,
      :latitude number,
      :longitude number,
      :proximityRadiusAmount number,
      :proximityRadiusUnit
      [DISTANCE_UNIT_UNSPECIFIED
       DISTANCE_UNIT_MILES
       DISTANCE_UNIT_KILOMETERS]},
     :sensitiveCategoryExclusionDetails
     {:excludedSensitiveCategory
      [SENSITIVE_CATEGORY_UNSPECIFIED
       SENSITIVE_CATEGORY_ADULT
       SENSITIVE_CATEGORY_DEROGATORY
       SENSITIVE_CATEGORY_DOWNLOADS_SHARING
       SENSITIVE_CATEGORY_WEAPONS
       SENSITIVE_CATEGORY_GAMBLING
       SENSITIVE_CATEGORY_VIOLENCE
       SENSITIVE_CATEGORY_SUGGESTIVE
       SENSITIVE_CATEGORY_PROFANITY
       SENSITIVE_CATEGORY_ALCOHOL
       SENSITIVE_CATEGORY_DRUGS
       SENSITIVE_CATEGORY_TOBACCO
       SENSITIVE_CATEGORY_POLITICS
       SENSITIVE_CATEGORY_RELIGION
       SENSITIVE_CATEGORY_TRAGEDY
       SENSITIVE_CATEGORY_TRANSPORTATION_ACCIDENTS
       SENSITIVE_CATEGORY_SENSITIVE_SOCIAL_ISSUES
       SENSITIVE_CATEGORY_SHOCKING
       SENSITIVE_CATEGORY_EMBEDDED_VIDEO
       SENSITIVE_CATEGORY_LIVE_STREAMING_VIDEO]},
     :youtubeVideoDetails {:videoId string, :negative boolean},
     :sessionPositionDetails
     {:sessionPosition
      [SESSION_POSITION_UNSPECIFIED
       SESSION_POSITION_FIRST_IMPRESSION]},
     :deviceTypeDetails
     {:deviceType
      [DEVICE_TYPE_UNSPECIFIED
       DEVICE_TYPE_COMPUTER
       DEVICE_TYPE_CONNECTED_TV
       DEVICE_TYPE_SMART_PHONE
       DEVICE_TYPE_TABLET],
      :youtubeAndPartnersBidMultiplier number},
     :appDetails
     {:appId string,
      :displayName string,
      :negative boolean,
      :appPlatform
      [APP_PLATFORM_UNSPECIFIED
       APP_PLATFORM_IOS
       APP_PLATFORM_ANDROID
       APP_PLATFORM_ROKU
       APP_PLATFORM_AMAZON_FIRETV
       APP_PLATFORM_PLAYSTATION
       APP_PLATFORM_APPLE_TV
       APP_PLATFORM_XBOX
       APP_PLATFORM_SAMSUNG_TV
       APP_PLATFORM_ANDROID_TV
       APP_PLATFORM_GENERIC_CTV
       APP_PLATFORM_LG_TV
       APP_PLATFORM_VIZIO_TV]},
     :subExchangeDetails {:targetingOptionId string},
     :genderDetails
     {:gender
      [GENDER_UNSPECIFIED GENDER_MALE GENDER_FEMALE GENDER_UNKNOWN]},
     :languageDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :viewabilityDetails
     {:viewability
      [VIEWABILITY_UNSPECIFIED
       VIEWABILITY_10_PERCENT_OR_MORE
       VIEWABILITY_20_PERCENT_OR_MORE
       VIEWABILITY_30_PERCENT_OR_MORE
       VIEWABILITY_40_PERCENT_OR_MORE
       VIEWABILITY_50_PERCENT_OR_MORE
       VIEWABILITY_60_PERCENT_OR_MORE
       VIEWABILITY_70_PERCENT_OR_MORE
       VIEWABILITY_80_PERCENT_OR_MORE
       VIEWABILITY_90_PERCENT_OR_MORE]},
     :assignedTargetingOptionIdAlias string,
     :keywordDetails {:keyword string, :negative boolean},
     :urlDetails {:url string, :negative boolean},
     :exchangeDetails
     {:exchange
      [EXCHANGE_UNSPECIFIED
       EXCHANGE_GOOGLE_AD_MANAGER
       EXCHANGE_APPNEXUS
       EXCHANGE_BRIGHTROLL
       EXCHANGE_ADFORM
       EXCHANGE_ADMETA
       EXCHANGE_ADMIXER
       EXCHANGE_ADSMOGO
       EXCHANGE_ADSWIZZ
       EXCHANGE_BIDSWITCH
       EXCHANGE_BRIGHTROLL_DISPLAY
       EXCHANGE_CADREON
       EXCHANGE_DAILYMOTION
       EXCHANGE_FIVE
       EXCHANGE_FLUCT
       EXCHANGE_FREEWHEEL
       EXCHANGE_GENIEE
       EXCHANGE_GUMGUM
       EXCHANGE_IMOBILE
       EXCHANGE_IBILLBOARD
       EXCHANGE_IMPROVE_DIGITAL
       EXCHANGE_INDEX
       EXCHANGE_KARGO
       EXCHANGE_MICROAD
       EXCHANGE_MOPUB
       EXCHANGE_NEND
       EXCHANGE_ONE_BY_AOL_DISPLAY
       EXCHANGE_ONE_BY_AOL_MOBILE
       EXCHANGE_ONE_BY_AOL_VIDEO
       EXCHANGE_OOYALA
       EXCHANGE_OPENX
       EXCHANGE_PERMODO
       EXCHANGE_PLATFORMONE
       EXCHANGE_PLATFORMID
       EXCHANGE_PUBMATIC
       EXCHANGE_PULSEPOINT
       EXCHANGE_REVENUEMAX
       EXCHANGE_RUBICON
       EXCHANGE_SMARTCLIP
       EXCHANGE_SMARTRTB
       EXCHANGE_SMARTSTREAMTV
       EXCHANGE_SOVRN
       EXCHANGE_SPOTXCHANGE
       EXCHANGE_STROER
       EXCHANGE_TEADSTV
       EXCHANGE_TELARIA
       EXCHANGE_TVN
       EXCHANGE_UNITED
       EXCHANGE_YIELDLAB
       EXCHANGE_YIELDMO
       EXCHANGE_UNRULYX
       EXCHANGE_OPEN8
       EXCHANGE_TRITON
       EXCHANGE_TRIPLELIFT
       EXCHANGE_TABOOLA
       EXCHANGE_INMOBI
       EXCHANGE_SMAATO
       EXCHANGE_AJA
       EXCHANGE_SUPERSHIP
       EXCHANGE_NEXSTAR_DIGITAL
       EXCHANGE_WAZE
       EXCHANGE_SOUNDCAST
       EXCHANGE_SHARETHROUGH
       EXCHANGE_FYBER
       EXCHANGE_RED_FOR_PUBLISHERS
       EXCHANGE_MEDIANET
       EXCHANGE_TAPJOY
       EXCHANGE_VISTAR
       EXCHANGE_DAX
       EXCHANGE_JCD
       EXCHANGE_PLACE_EXCHANGE
       EXCHANGE_APPLOVIN
       EXCHANGE_CONNATIX
       EXCHANGE_RESET_DIGITAL
       EXCHANGE_HIVESTACK
       EXCHANGE_DRAX
       EXCHANGE_APPLOVIN_GBID
       EXCHANGE_FYBER_GBID
       EXCHANGE_UNITY_GBID
       EXCHANGE_CHARTBOOST_GBID
       EXCHANGE_ADMOST_GBID
       EXCHANGE_TOPON_GBID]},
     :dayAndTimeDetails
     {:dayOfWeek
      [DAY_OF_WEEK_UNSPECIFIED
       MONDAY
       TUESDAY
       WEDNESDAY
       THURSDAY
       FRIDAY
       SATURDAY
       SUNDAY],
      :startHour integer,
      :endHour integer,
      :timeZoneResolution
      [TIME_ZONE_RESOLUTION_UNSPECIFIED
       TIME_ZONE_RESOLUTION_END_USER
       TIME_ZONE_RESOLUTION_ADVERTISER]},
     :householdIncomeDetails
     {:householdIncome
      [HOUSEHOLD_INCOME_UNSPECIFIED
       HOUSEHOLD_INCOME_UNKNOWN
       HOUSEHOLD_INCOME_LOWER_50_PERCENT
       HOUSEHOLD_INCOME_TOP_41_TO_50_PERCENT
       HOUSEHOLD_INCOME_TOP_31_TO_40_PERCENT
       HOUSEHOLD_INCOME_TOP_21_TO_30_PERCENT
       HOUSEHOLD_INCOME_TOP_11_TO_20_PERCENT
       HOUSEHOLD_INCOME_TOP_10_PERCENT]},
     :authorizedSellerStatusDetails
     {:authorizedSellerStatus
      [AUTHORIZED_SELLER_STATUS_UNSPECIFIED
       AUTHORIZED_SELLER_STATUS_AUTHORIZED_DIRECT_SELLERS_ONLY
       AUTHORIZED_SELLER_STATUS_AUTHORIZED_AND_NON_PARTICIPATING_PUBLISHERS],
      :targetingOptionId string},
     :contentOutstreamPositionDetails
     {:contentOutstreamPosition
      [CONTENT_OUTSTREAM_POSITION_UNSPECIFIED
       CONTENT_OUTSTREAM_POSITION_UNKNOWN
       CONTENT_OUTSTREAM_POSITION_IN_ARTICLE
       CONTENT_OUTSTREAM_POSITION_IN_BANNER
       CONTENT_OUTSTREAM_POSITION_IN_FEED
       CONTENT_OUTSTREAM_POSITION_INTERSTITIAL],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :youtubeChannelDetails {:channelId string, :negative boolean},
     :userRewardedContentDetails
     {:targetingOptionId string,
      :userRewardedContent
      [USER_REWARDED_CONTENT_UNSPECIFIED
       USER_REWARDED_CONTENT_USER_REWARDED
       USER_REWARDED_CONTENT_NOT_USER_REWARDED]},
     :omidDetails
     {:omid [OMID_UNSPECIFIED OMID_FOR_MOBILE_DISPLAY_ADS]}}]}]}"
  [advertiserId BulkEditAdvertiserAssignedTargetingOptionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}:editAssignedTargetingOptions",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditAdvertiserAssignedTargetingOptionsRequest}))

(defn advertisers-get
  "Gets an advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser to fetch."
  [advertiserId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-list
  "Lists advertisers that are accessible to the current user. The order is defined by the order_by parameter. A single partner_id is required. Cross-partner listing is not supported.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> Required. The ID of the partner that the fetched advertisers should all belong to. The system only supports listing advertisers for one partner at a time.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) * `entityStatus` * `updateTime` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. For example, `displayName desc`.
filter <string> Allows filtering by advertiser fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. * A restriction has the form of `{field} {operator} {value}`. * The `updateTime` field must use the `GREATER THAN OR EQUAL TO (>=)` or `LESS THAN OR EQUAL TO (<=)` operators. * All other fields must use the `EQUALS (=)` operator. Supported fields: * `advertiserId` * `displayName` * `entityStatus` * `updateTime` (input in ISO 8601 format, or `YYYY-MM-DDTHH:MM:SSZ`) Examples: * All active advertisers under a partner: `entityStatus=\"ENTITY_STATUS_ACTIVE\"` * All advertisers with an update time less than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime<=\"2020-11-04T18:54:47Z\"` * All advertisers with an update time greater than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime>=\"2020-11-04T18:54:47Z\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (advertisers-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-create
  "Creates a new advertiser. Returns the newly created advertiser if successful. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors.
https://developers.google.com/display-video/api/guides/getting-started/overview

Advertiser:
{:creativeConfig
 {:iasClientId string,
  :obaComplianceDisabled boolean,
  :dynamicCreativeEnabled boolean,
  :videoCreativeDataSharingAuthorized boolean},
 :dataAccessConfig
 {:sdfConfig
  {:overridePartnerSdfConfig boolean,
   :sdfConfig
   {:version
    [SDF_VERSION_UNSPECIFIED
     SDF_VERSION_3_1
     SDF_VERSION_4
     SDF_VERSION_4_1
     SDF_VERSION_4_2
     SDF_VERSION_5
     SDF_VERSION_5_1
     SDF_VERSION_5_2
     SDF_VERSION_5_3
     SDF_VERSION_5_4
     SDF_VERSION_5_5
     SDF_VERSION_6
     SDF_VERSION_7
     SDF_VERSION_7_1],
    :adminEmail string}}},
 :displayName string,
 :name string,
 :billingConfig {:billingProfileId string},
 :adServerConfig
 {:thirdPartyOnlyConfig {:pixelOrderIdReportingEnabled boolean},
  :cmHybridConfig
  {:cmAccountId string,
   :cmFloodlightConfigId string,
   :cmAdvertiserIds [string],
   :cmSyncableSiteIds [string],
   :dv360ToCmDataSharingEnabled boolean,
   :dv360ToCmCostReportingEnabled boolean,
   :cmFloodlightLinkingAuthorized boolean}},
 :updateTime string,
 :advertiserId string,
 :servingConfig {:exemptTvFromViewabilityTargeting boolean},
 :integrationDetails {:integrationCode string, :details string},
 :prismaEnabled boolean,
 :partnerId string,
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION],
 :generalConfig
 {:domainUrl string, :timeZone string, :currencyCode string}}"
  [Advertiser]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body Advertiser}))

(defn advertisers-patch
  "Updates an existing advertiser. Returns the updated advertiser if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser. Assigned by the system.
Advertiser:
{:creativeConfig
 {:iasClientId string,
  :obaComplianceDisabled boolean,
  :dynamicCreativeEnabled boolean,
  :videoCreativeDataSharingAuthorized boolean},
 :dataAccessConfig
 {:sdfConfig
  {:overridePartnerSdfConfig boolean,
   :sdfConfig
   {:version
    [SDF_VERSION_UNSPECIFIED
     SDF_VERSION_3_1
     SDF_VERSION_4
     SDF_VERSION_4_1
     SDF_VERSION_4_2
     SDF_VERSION_5
     SDF_VERSION_5_1
     SDF_VERSION_5_2
     SDF_VERSION_5_3
     SDF_VERSION_5_4
     SDF_VERSION_5_5
     SDF_VERSION_6
     SDF_VERSION_7
     SDF_VERSION_7_1],
    :adminEmail string}}},
 :displayName string,
 :name string,
 :billingConfig {:billingProfileId string},
 :adServerConfig
 {:thirdPartyOnlyConfig {:pixelOrderIdReportingEnabled boolean},
  :cmHybridConfig
  {:cmAccountId string,
   :cmFloodlightConfigId string,
   :cmAdvertiserIds [string],
   :cmSyncableSiteIds [string],
   :dv360ToCmDataSharingEnabled boolean,
   :dv360ToCmCostReportingEnabled boolean,
   :cmFloodlightLinkingAuthorized boolean}},
 :updateTime string,
 :advertiserId string,
 :servingConfig {:exemptTvFromViewabilityTargeting boolean},
 :integrationDetails {:integrationCode string, :details string},
 :prismaEnabled boolean,
 :partnerId string,
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION],
 :generalConfig
 {:domainUrl string, :timeZone string, :currencyCode string}}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId Advertiser]
    (advertisers-patch advertiserId Advertiser nil))
  ([advertiserId Advertiser optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Advertiser})))

(defn advertisers-delete
  "Deletes an advertiser. Deleting an advertiser will delete all of its child resources, for example, campaigns, insertion orders and line items. A deleted advertiser cannot be recovered.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser we need to delete."
  [advertiserId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-audit
  "Audits an advertiser. Returns the counts of used entities per resource type under the advertiser provided. Used entities count towards their respective resource limit. See https://support.google.com/displayvideo/answer/6071450.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser to audit.

optional:
readMask <string> Optional. The specific fields to return. If no mask is specified, all fields in the response proto will be filled. Valid values are: * usedLineItemsCount * usedInsertionOrdersCount * usedCampaignsCount * channelsCount * negativelyTargetedChannelsCount * negativeKeywordListsCount * adGroupCriteriaCount * campaignCriteriaCount"
  ([advertiserId] (advertisers-audit advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}:audit",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-invoices-list
  "Lists invoices posted for an advertiser in a given month. Invoices generated by billing profiles with a \"Partner\" invoice level are not retrievable through this method.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser to list invoices for.

optional:
issueMonth <string> The month to list the invoices for. If not set, the request will retrieve invoices for the previous month. Must be in the format YYYYMM.
loiSapinInvoiceType <string> Select type of invoice to retrieve for Loi Sapin advertisers. Only applicable to Loi Sapin advertisers. Will be ignored otherwise.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified."
  ([advertiserId] (advertisers-invoices-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/invoices",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/display-video"
        "https://www.googleapis.com/auth/display-video-mediaplanning"]})))

(defn advertisers-invoices-lookupInvoiceCurrency
  "Retrieves the invoice currency used by an advertiser in a given month.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser to lookup currency for.

optional:
invoiceMonth <string> Month for which the currency is needed. If not set, the request will return existing currency settings for the advertiser. Must be in the format YYYYMM."
  ([advertiserId]
    (advertisers-invoices-lookupInvoiceCurrency advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/invoices:lookupInvoiceCurrency",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/display-video"
        "https://www.googleapis.com/auth/display-video-mediaplanning"]})))

(defn advertisers-locationLists-get
  "Gets a location list.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the fetched location list belongs.
locationListId <string> Required. The ID of the location list to fetch."
  [advertiserId locationListId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/locationLists/{+locationListId}",
     :uri-template-args
     {:advertiserId advertiserId, :locationListId locationListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-locationLists-list
  "Lists location lists based on a given advertiser id.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the fetched location lists belong.

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. Defaults to `100` if not set. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `locationListId` (default) * `displayName` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by location list fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `locationType` Examples: * All regional location list: `locationType=\"TARGETING_LOCATION_TYPE_REGIONAL\"` * All proximity location list: `locationType=\"TARGETING_LOCATION_TYPE_PROXIMITY\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-locationLists-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/locationLists",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-locationLists-create
  "Creates a new location list. Returns the newly created location list if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the location list belongs.
LocationList:
{:name string,
 :locationListId string,
 :displayName string,
 :locationType
 [TARGETING_LOCATION_TYPE_UNSPECIFIED
  TARGETING_LOCATION_TYPE_PROXIMITY
  TARGETING_LOCATION_TYPE_REGIONAL],
 :advertiserId string}"
  [advertiserId LocationList]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/locationLists",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body LocationList}))

(defn advertisers-locationLists-patch
  "Updates a location list. Returns the updated location list if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the location lists belongs.
locationListId <string> Output only. The unique ID of the location list. Assigned by the system.
LocationList:
{:name string,
 :locationListId string,
 :displayName string,
 :locationType
 [TARGETING_LOCATION_TYPE_UNSPECIFIED
  TARGETING_LOCATION_TYPE_PROXIMITY
  TARGETING_LOCATION_TYPE_REGIONAL],
 :advertiserId string}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId locationListId LocationList]
    (advertisers-locationLists-patch
      advertiserId
      locationListId
      LocationList
      nil))
  ([advertiserId locationListId LocationList optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/locationLists/{locationListId}",
       :uri-template-args
       {:advertiserId advertiserId, :locationListId locationListId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body LocationList})))

(defn advertisers-locationLists-assignedLocations-list
  "Lists locations assigned to a location list.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the location list belongs.
locationListId <string> Required. The ID of the location list to which these assignments are assigned.

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `assignedLocationId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be added to the field name. Example: `assignedLocationId desc`.
filter <string> Allows filtering by location list assignment fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the `OR` logical operator. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedLocationId` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId locationListId]
    (advertisers-locationLists-assignedLocations-list
      advertiserId
      locationListId
      nil))
  ([advertiserId locationListId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations",
       :uri-template-args
       {:advertiserId advertiserId, :locationListId locationListId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-locationLists-assignedLocations-create
  "Creates an assignment between a location and a location list.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the location list belongs.
locationListId <string> Required. The ID of the location list for which the assignment will be created.
AssignedLocation:
{:name string, :assignedLocationId string, :targetingOptionId string}"
  [advertiserId locationListId AssignedLocation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations",
     :uri-template-args
     {:advertiserId advertiserId, :locationListId locationListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body AssignedLocation}))

(defn advertisers-locationLists-assignedLocations-delete
  "Deletes the assignment between a location and a location list.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the location list belongs.
locationListId <string> Required. The ID of the location list to which this assignment is assigned.
assignedLocationId <string> Required. The ID of the assigned location to delete."
  [advertiserId locationListId assignedLocationId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations/{+assignedLocationId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :locationListId locationListId,
      :assignedLocationId assignedLocationId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-locationLists-assignedLocations-bulkEdit
  "Bulk edits multiple assignments between locations and a single location list. The operation will delete the assigned locations provided in deletedAssignedLocations and then create the assigned locations provided in createdAssignedLocations.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the location list belongs.
locationListId <string> Required. The ID of the location list to which these assignments are assigned.
BulkEditAssignedLocationsRequest:
{:deletedAssignedLocations [string],
 :createdAssignedLocations
 [{:name string,
   :assignedLocationId string,
   :targetingOptionId string}]}"
  [advertiserId locationListId BulkEditAssignedLocationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/locationLists/{+locationListId}/assignedLocations:bulkEdit",
     :uri-template-args
     {:advertiserId advertiserId, :locationListId locationListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditAssignedLocationsRequest}))

(defn advertisers-channels-get
  "Gets a channel for a partner or advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the fetched channel.
channelId <string> Required. The ID of the channel to fetch.

optional:
partnerId <string> The ID of the partner that owns the fetched channel."
  ([advertiserId channelId]
    (advertisers-channels-get advertiserId channelId nil))
  ([advertiserId channelId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/channels/{+channelId}",
       :uri-template-args
       {:advertiserId advertiserId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-channels-list
  "Lists channels for a partner or advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the channels.

optional:
partnerId <string> The ID of the partner that owns the channels.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) * `channelId` The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by channel fields. Supported syntax: * Filter expressions for channel can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `displayName` Examples: * All channels for which the display name contains \"google\": `displayName : \"google\"`. The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-channels-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/channels",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-channels-create
  "Creates a new channel. Returns the newly created channel if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the created channel.
Channel:
{:name string,
 :channelId string,
 :displayName string,
 :partnerId string,
 :advertiserId string,
 :positivelyTargetedLineItemCount string,
 :negativelyTargetedLineItemCount string}

optional:
partnerId <string> The ID of the partner that owns the created channel."
  ([advertiserId Channel]
    (advertisers-channels-create advertiserId Channel nil))
  ([advertiserId Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/channels",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Channel})))

(defn advertisers-channels-patch
  "Updates a channel. Returns the updated channel if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the created channel.
channelId <string> Output only. The unique ID of the channel. Assigned by the system.
Channel:
{:name string,
 :channelId string,
 :displayName string,
 :partnerId string,
 :advertiserId string,
 :positivelyTargetedLineItemCount string,
 :negativelyTargetedLineItemCount string}

optional:
partnerId <string> The ID of the partner that owns the created channel.
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId channelId Channel]
    (advertisers-channels-patch advertiserId channelId Channel nil))
  ([advertiserId channelId Channel optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/channels/{channelId}",
       :uri-template-args
       {:advertiserId advertiserId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Channel})))

(defn advertisers-channels-sites-list
  "Lists sites in a channel.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the parent channel.
channelId <string> Required. The ID of the parent channel to which the requested sites belong.

optional:
partnerId <string> The ID of the partner that owns the parent channel.
pageSize <integer> Requested page size. Must be between `1` and `10000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `urlOrAppId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be added to the field name. Example: `urlOrAppId desc`.
filter <string> Allows filtering by site fields. Supported syntax: * Filter expressions for site retrieval can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `urlOrAppId` Examples: * All sites for which the URL or app ID contains \"google\": `urlOrAppId : \"google\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId channelId]
    (advertisers-channels-sites-list advertiserId channelId nil))
  ([advertiserId channelId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/channels/{+channelId}/sites",
       :uri-template-args
       {:advertiserId advertiserId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-channels-sites-create
  "Creates a site in a channel.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the parent channel.
channelId <string> Required. The ID of the parent channel in which the site will be created.
Site:
{:name string, :urlOrAppId string}

optional:
partnerId <string> The ID of the partner that owns the parent channel."
  ([advertiserId channelId Site]
    (advertisers-channels-sites-create
      advertiserId
      channelId
      Site
      nil))
  ([advertiserId channelId Site optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/channels/{+channelId}/sites",
       :uri-template-args
       {:advertiserId advertiserId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Site})))

(defn advertisers-channels-sites-delete
  "Deletes a site from a channel.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the parent channel.
channelId <string> Required. The ID of the parent channel to which the site belongs.
urlOrAppId <string> Required. The URL or app ID of the site to delete.

optional:
partnerId <string> The ID of the partner that owns the parent channel."
  ([advertiserId channelId urlOrAppId]
    (advertisers-channels-sites-delete
      advertiserId
      channelId
      urlOrAppId
      nil))
  ([advertiserId channelId urlOrAppId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/channels/{+channelId}/sites/{+urlOrAppId}",
       :uri-template-args
       {:advertiserId advertiserId,
        :channelId channelId,
        :urlOrAppId urlOrAppId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-channels-sites-bulkEdit
  "Bulk edits sites under a single channel. The operation will delete the sites provided in BulkEditSitesRequest.deleted_sites and then create the sites provided in BulkEditSitesRequest.created_sites.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the parent channel.
channelId <string> Required. The ID of the parent channel to which the sites belong.
BulkEditSitesRequest:
{:partnerId string,
 :advertiserId string,
 :deletedSites [string],
 :createdSites [{:name string, :urlOrAppId string}]}"
  [advertiserId channelId BulkEditSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/channels/{+channelId}/sites:bulkEdit",
     :uri-template-args
     {:advertiserId advertiserId, :channelId channelId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditSitesRequest}))

(defn advertisers-channels-sites-replace
  "Replaces all of the sites under a single channel. The operation will replace the sites under a channel with the sites provided in ReplaceSitesRequest.new_sites. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser that owns the parent channel.
channelId <string> Required. The ID of the parent channel whose sites will be replaced.
ReplaceSitesRequest:
{:partnerId string,
 :advertiserId string,
 :newSites [{:name string, :urlOrAppId string}]}"
  [advertiserId channelId ReplaceSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/channels/{+channelId}/sites:replace",
     :uri-template-args
     {:advertiserId advertiserId, :channelId channelId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body ReplaceSitesRequest}))

(defn advertisers-assets-upload
  "Uploads an asset. Returns the ID of the newly uploaded asset if successful. The asset file size should be no more than 10 MB for images, 200 MB for ZIP files, and 1 GB for videos. Must be used within the [multipart media upload process](/display-video/api/guides/how-tos/upload#multipart). Examples using provided client libraries can be found in our [Creating Creatives guide](/display-video/api/guides/creating-creatives/overview#upload_an_asset).
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this asset belongs to.
CreateAssetRequest:
{:filename string}"
  [advertiserId CreateAssetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/assets",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body CreateAssetRequest}))

(defn advertisers-negativeKeywordLists-get
  "Gets a negative keyword list given an advertiser ID and a negative keyword list ID.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the fetched negative keyword list belongs.
negativeKeywordListId <string> Required. The ID of the negative keyword list to fetch."
  [advertiserId negativeKeywordListId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :negativeKeywordListId negativeKeywordListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-negativeKeywordLists-list
  "Lists negative keyword lists based on a given advertiser id.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the fetched negative keyword lists belong.

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. Defaults to `100` if not set. Returns error code `INVALID_ARGUMENT` if an invalid value is specified."
  ([advertiserId]
    (advertisers-negativeKeywordLists-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/negativeKeywordLists",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-negativeKeywordLists-create
  "Creates a new negative keyword list. Returns the newly created negative keyword list if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the negative keyword list will belong.
NegativeKeywordList:
{:name string,
 :negativeKeywordListId string,
 :displayName string,
 :advertiserId string,
 :targetedLineItemCount string}"
  [advertiserId NegativeKeywordList]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/negativeKeywordLists",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body NegativeKeywordList}))

(defn advertisers-negativeKeywordLists-patch
  "Updates a negative keyword list. Returns the updated negative keyword list if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the negative keyword list belongs.
negativeKeywordListId <string> Output only. The unique ID of the negative keyword list. Assigned by the system.
NegativeKeywordList:
{:name string,
 :negativeKeywordListId string,
 :displayName string,
 :advertiserId string,
 :targetedLineItemCount string}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId negativeKeywordListId NegativeKeywordList]
    (advertisers-negativeKeywordLists-patch
      advertiserId
      negativeKeywordListId
      NegativeKeywordList
      nil))
  ([advertiserId negativeKeywordListId NegativeKeywordList optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/negativeKeywordLists/{negativeKeywordListId}",
       :uri-template-args
       {:advertiserId advertiserId,
        :negativeKeywordListId negativeKeywordListId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body NegativeKeywordList})))

(defn advertisers-negativeKeywordLists-delete
  "Deletes a negative keyword list given an advertiser ID and a negative keyword list ID.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the negative keyword list belongs.
negativeKeywordListId <string> Required. The ID of the negative keyword list to delete."
  [advertiserId negativeKeywordListId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :negativeKeywordListId negativeKeywordListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-negativeKeywordLists-negativeKeywords-list
  "Lists negative keywords in a negative keyword list.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the parent negative keyword list belongs.
negativeKeywordListId <string> Required. The ID of the parent negative keyword list to which the requested negative keywords belong.

optional:
pageSize <integer> Requested page size. Must be between `1` and `1000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `keywordValue` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be added to the field name. Example: `keywordValue desc`.
filter <string> Allows filtering by negative keyword fields. Supported syntax: * Filter expressions for negative keywords can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `keywordValue` Examples: * All negative keywords for which the keyword value contains \"google\": `keywordValue : \"google\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId negativeKeywordListId]
    (advertisers-negativeKeywordLists-negativeKeywords-list
      advertiserId
      negativeKeywordListId
      nil))
  ([advertiserId negativeKeywordListId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords",
       :uri-template-args
       {:advertiserId advertiserId,
        :negativeKeywordListId negativeKeywordListId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-negativeKeywordLists-negativeKeywords-create
  "Creates a negative keyword in a negative keyword list.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the parent negative keyword list belongs.
negativeKeywordListId <string> Required. The ID of the parent negative keyword list in which the negative keyword will be created.
NegativeKeyword:
{:name string, :keywordValue string}"
  [advertiserId negativeKeywordListId NegativeKeyword]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords",
     :uri-template-args
     {:advertiserId advertiserId,
      :negativeKeywordListId negativeKeywordListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body NegativeKeyword}))

(defn advertisers-negativeKeywordLists-negativeKeywords-delete
  "Deletes a negative keyword from a negative keyword list.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the parent negative keyword list belongs.
negativeKeywordListId <string> Required. The ID of the parent negative keyword list to which the negative keyword belongs.
keywordValue <string> Required. The keyword value of the negative keyword to delete."
  [advertiserId negativeKeywordListId keywordValue]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords/{+keywordValue}",
     :uri-template-args
     {:advertiserId advertiserId,
      :negativeKeywordListId negativeKeywordListId,
      :keywordValue keywordValue},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-negativeKeywordLists-negativeKeywords-bulkEdit
  "Bulk edits negative keywords in a single negative keyword list. The operation will delete the negative keywords provided in BulkEditNegativeKeywordsRequest.deleted_negative_keywords and then create the negative keywords provided in BulkEditNegativeKeywordsRequest.created_negative_keywords. This operation is guaranteed to be atomic and will never result in a partial success or partial failure.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the parent negative keyword list belongs.
negativeKeywordListId <string> Required. The ID of the parent negative keyword list to which the negative keywords belong.
BulkEditNegativeKeywordsRequest:
{:deletedNegativeKeywords [string],
 :createdNegativeKeywords [{:name string, :keywordValue string}]}"
  [advertiserId negativeKeywordListId BulkEditNegativeKeywordsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords:bulkEdit",
     :uri-template-args
     {:advertiserId advertiserId,
      :negativeKeywordListId negativeKeywordListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditNegativeKeywordsRequest}))

(defn advertisers-negativeKeywordLists-negativeKeywords-replace
  "Replaces all negative keywords in a single negative keyword list. The operation will replace the keywords in a negative keyword list with keywords provided in ReplaceNegativeKeywordsRequest.new_negative_keywords.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the DV360 advertiser to which the parent negative keyword list belongs.
negativeKeywordListId <string> Required. The ID of the parent negative keyword list to which the negative keywords belong.
ReplaceNegativeKeywordsRequest:
{:newNegativeKeywords [{:name string, :keywordValue string}]}"
  [advertiserId negativeKeywordListId ReplaceNegativeKeywordsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords:replace",
     :uri-template-args
     {:advertiserId advertiserId,
      :negativeKeywordListId negativeKeywordListId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body ReplaceNegativeKeywordsRequest}))

(defn advertisers-lineItems-duplicate
  "Duplicates a line item. Returns the ID of the created line item if successful. YouTube & Partners line items cannot be created or updated using the API. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this line item belongs to.
lineItemId <string> Required. The ID of the line item to duplicate.
DuplicateLineItemRequest:
{:targetDisplayName string}"
  [advertiserId lineItemId DuplicateLineItemRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}:duplicate",
     :uri-template-args
     {:advertiserId advertiserId, :lineItemId lineItemId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body DuplicateLineItemRequest}))

(defn advertisers-lineItems-get
  "Gets a line item.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this line item belongs to.
lineItemId <string> Required. The ID of the line item to fetch."
  [advertiserId lineItemId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}",
     :uri-template-args
     {:advertiserId advertiserId, :lineItemId lineItemId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-lineItems-generateDefault
  "Creates a new line item with settings (including targeting) inherited from the insertion order and an `ENTITY_STATUS_DRAFT` entity_status. Returns the newly created line item if successful. There are default values based on the three fields: * The insertion order's insertion_order_type * The insertion order's automation_type * The given line_item_type YouTube & Partners line items cannot be created or updated using the API.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this line item belongs to.
GenerateDefaultLineItemRequest:
{:insertionOrderId string,
 :displayName string,
 :lineItemType
 [LINE_ITEM_TYPE_UNSPECIFIED
  LINE_ITEM_TYPE_DISPLAY_DEFAULT
  LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INSTALL
  LINE_ITEM_TYPE_VIDEO_DEFAULT
  LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INSTALL
  LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INVENTORY
  LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INVENTORY
  LINE_ITEM_TYPE_AUDIO_DEFAULT
  LINE_ITEM_TYPE_VIDEO_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_ACTION
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_AUDIO
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_TARGET_FREQUENCY
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIEW
  LINE_ITEM_TYPE_DISPLAY_OUT_OF_HOME
  LINE_ITEM_TYPE_VIDEO_OUT_OF_HOME],
 :mobileApp
 {:appId string,
  :platform [PLATFORM_UNSPECIFIED IOS ANDROID],
  :displayName string,
  :publisher string}}"
  [advertiserId GenerateDefaultLineItemRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems:generateDefault",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body GenerateDefaultLineItemRequest}))

(defn advertisers-lineItems-patch
  "Updates an existing line item. Returns the updated line item if successful. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * BulkEditAssignedTargetingOptions * BulkUpdateLineItems * assignedTargetingOptions.create * assignedTargetingOptions.delete YouTube & Partners line items cannot be created or updated using the API. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the line item belongs to.
lineItemId <string> Output only. The unique ID of the line item. Assigned by the system.
LineItem:
{:insertionOrderId string,
 :targetingExpansion
 {:enableOptimizedTargeting boolean,
  :audienceExpansionSeedListExcluded boolean,
  :audienceExpansionLevel
  [UNKNOWN NO_REACH LEAST_REACH MID_REACH MOST_REACH]},
 :lineItemType
 [LINE_ITEM_TYPE_UNSPECIFIED
  LINE_ITEM_TYPE_DISPLAY_DEFAULT
  LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INSTALL
  LINE_ITEM_TYPE_VIDEO_DEFAULT
  LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INSTALL
  LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INVENTORY
  LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INVENTORY
  LINE_ITEM_TYPE_AUDIO_DEFAULT
  LINE_ITEM_TYPE_VIDEO_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_ACTION
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_AUDIO
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_TARGET_FREQUENCY
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIEW
  LINE_ITEM_TYPE_DISPLAY_OUT_OF_HOME
  LINE_ITEM_TYPE_VIDEO_OUT_OF_HOME],
 :partnerCosts
 [{:costType
   [PARTNER_COST_TYPE_UNSPECIFIED
    PARTNER_COST_TYPE_ADLOOX
    PARTNER_COST_TYPE_ADLOOX_PREBID
    PARTNER_COST_TYPE_ADSAFE
    PARTNER_COST_TYPE_ADXPOSE
    PARTNER_COST_TYPE_AGGREGATE_KNOWLEDGE
    PARTNER_COST_TYPE_AGENCY_TRADING_DESK
    PARTNER_COST_TYPE_DV360_FEE
    PARTNER_COST_TYPE_COMSCORE_VCE
    PARTNER_COST_TYPE_DATA_MANAGEMENT_PLATFORM
    PARTNER_COST_TYPE_DEFAULT
    PARTNER_COST_TYPE_DOUBLE_VERIFY
    PARTNER_COST_TYPE_DOUBLE_VERIFY_PREBID
    PARTNER_COST_TYPE_EVIDON
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_VIDEO
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_PREBID
    PARTNER_COST_TYPE_MEDIA_COST_DATA
    PARTNER_COST_TYPE_MOAT_VIDEO
    PARTNER_COST_TYPE_NIELSEN_DAR
    PARTNER_COST_TYPE_SHOP_LOCAL
    PARTNER_COST_TYPE_TERACENT
    PARTNER_COST_TYPE_THIRD_PARTY_AD_SERVER
    PARTNER_COST_TYPE_TRUST_METRICS
    PARTNER_COST_TYPE_VIZU
    PARTNER_COST_TYPE_ADLINGO_FEE
    PARTNER_COST_TYPE_CUSTOM_FEE_1
    PARTNER_COST_TYPE_CUSTOM_FEE_2
    PARTNER_COST_TYPE_CUSTOM_FEE_3
    PARTNER_COST_TYPE_CUSTOM_FEE_4
    PARTNER_COST_TYPE_CUSTOM_FEE_5
    PARTNER_COST_TYPE_SCIBIDS_FEE],
   :feeType
   [PARTNER_COST_FEE_TYPE_UNSPECIFIED
    PARTNER_COST_FEE_TYPE_CPM_FEE
    PARTNER_COST_FEE_TYPE_MEDIA_FEE],
   :feeAmount string,
   :feePercentageMillis string,
   :invoiceType
   [PARTNER_COST_INVOICE_TYPE_UNSPECIFIED
    PARTNER_COST_INVOICE_TYPE_DV360
    PARTNER_COST_INVOICE_TYPE_PARTNER]}],
 :bidStrategy
 {:fixedBid {:bidAmountMicros string},
  :maximizeSpendAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :maxAverageCpmBidAmountMicros string,
   :raiseBidForDeals boolean,
   :customBiddingAlgorithmId string},
  :performanceGoalAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :performanceGoalAmountMicros string,
   :maxAverageCpmBidAmountMicros string,
   :customBiddingAlgorithmId string},
  :youtubeAndPartnersBid
  {:type
   [YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_UNSPECIFIED
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPA
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_RESERVE_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_LIFT
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSIONS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_ROAS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSION_VALUE],
   :value string,
   :adGroupEffectiveTargetCpaValue string,
   :adGroupEffectiveTargetCpaSource
   [BIDDING_SOURCE_UNSPECIFIED
    BIDDING_SOURCE_LINE_ITEM
    BIDDING_SOURCE_AD_GROUP]}},
 :displayName string,
 :name string,
 :campaignId string,
 :pacing
 {:pacingPeriod
  [PACING_PERIOD_UNSPECIFIED PACING_PERIOD_DAILY PACING_PERIOD_FLIGHT],
  :pacingType
  [PACING_TYPE_UNSPECIFIED
   PACING_TYPE_AHEAD
   PACING_TYPE_ASAP
   PACING_TYPE_EVEN],
  :dailyMaxMicros string,
  :dailyMaxImpressions string},
 :updateTime string,
 :frequencyCap
 {:unlimited boolean,
  :timeUnit
  [TIME_UNIT_UNSPECIFIED
   TIME_UNIT_LIFETIME
   TIME_UNIT_MONTHS
   TIME_UNIT_WEEKS
   TIME_UNIT_DAYS
   TIME_UNIT_HOURS
   TIME_UNIT_MINUTES],
  :timeUnitCount integer,
  :maxImpressions integer,
  :maxViews integer},
 :warningMessages
 [[LINE_ITEM_WARNING_MESSAGE_UNSPECIFIED
   INVALID_FLIGHT_DATES
   EXPIRED
   PENDING_FLIGHT
   ALL_PARTNER_ENABLED_EXCHANGES_NEGATIVELY_TARGETED
   INVALID_INVENTORY_SOURCE
   APP_INVENTORY_INVALID_SITE_TARGETING
   APP_INVENTORY_INVALID_AUDIENCE_LISTS
   NO_VALID_CREATIVE
   PARENT_INSERTION_ORDER_PAUSED
   PARENT_INSERTION_ORDER_EXPIRED]],
 :creativeIds [string],
 :lineItemId string,
 :advertiserId string,
 :youtubeAndPartnersSettings
 {:leadFormId string,
  :videoAdSequenceSettings
  {:minimumDuration
   [VIDEO_AD_SEQUENCE_MINIMUM_DURATION_UNSPECIFIED
    VIDEO_AD_SEQUENCE_MINIMUM_DURATION_WEEK
    VIDEO_AD_SEQUENCE_MINIMUM_DURATION_MONTH],
   :steps
   [{:stepId string,
     :adGroupId string,
     :previousStepId string,
     :interactionType
     [INTERACTION_TYPE_UNSPECIFIED
      INTERACTION_TYPE_PAID_VIEW
      INTERACTION_TYPE_SKIP
      INTERACTION_TYPE_IMPRESSION
      INTERACTION_TYPE_ENGAGED_IMPRESSION]}]},
  :inventorySourceSettings
  {:includeYoutube boolean,
   :includeGoogleTv boolean,
   :includeYoutubeVideoPartners boolean},
  :viewFrequencyCap
  {:unlimited boolean,
   :timeUnit
   [TIME_UNIT_UNSPECIFIED
    TIME_UNIT_LIFETIME
    TIME_UNIT_MONTHS
    TIME_UNIT_WEEKS
    TIME_UNIT_DAYS
    TIME_UNIT_HOURS
    TIME_UNIT_MINUTES],
   :timeUnitCount integer,
   :maxImpressions integer,
   :maxViews integer},
  :relatedVideoIds [string],
  :linkedMerchantId string,
  :contentCategory
  [YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_UNSPECIFIED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_STANDARD
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_EXPANDED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_LIMITED],
  :effectiveContentCategory
  [YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_UNSPECIFIED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_STANDARD
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_EXPANDED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_LIMITED],
  :targetFrequency
  {:targetCount string,
   :timeUnit
   [TIME_UNIT_UNSPECIFIED
    TIME_UNIT_LIFETIME
    TIME_UNIT_MONTHS
    TIME_UNIT_WEEKS
    TIME_UNIT_DAYS
    TIME_UNIT_HOURS
    TIME_UNIT_MINUTES],
   :timeUnitCount integer},
  :thirdPartyMeasurementConfigs
  {:viewabilityVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}],
   :brandSafetyVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}],
   :reachVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}],
   :brandLiftVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}]}},
 :integrationDetails {:integrationCode string, :details string},
 :partnerRevenueModel
 {:markupType
  [PARTNER_REVENUE_MODEL_MARKUP_TYPE_UNSPECIFIED
   PARTNER_REVENUE_MODEL_MARKUP_TYPE_CPM
   PARTNER_REVENUE_MODEL_MARKUP_TYPE_MEDIA_COST_MARKUP
   PARTNER_REVENUE_MODEL_MARKUP_TYPE_TOTAL_MEDIA_COST_MARKUP],
  :markupAmount string},
 :conversionCounting
 {:postViewCountPercentageMillis string,
  :floodlightActivityConfigs
  [{:floodlightActivityId string,
    :postClickLookbackWindowDays integer,
    :postViewLookbackWindowDays integer}]},
 :budget
 {:budgetAllocationType
  [LINE_ITEM_BUDGET_ALLOCATION_TYPE_UNSPECIFIED
   LINE_ITEM_BUDGET_ALLOCATION_TYPE_AUTOMATIC
   LINE_ITEM_BUDGET_ALLOCATION_TYPE_FIXED
   LINE_ITEM_BUDGET_ALLOCATION_TYPE_UNLIMITED],
  :budgetUnit
  [BUDGET_UNIT_UNSPECIFIED
   BUDGET_UNIT_CURRENCY
   BUDGET_UNIT_IMPRESSIONS],
  :maxAmount string},
 :mobileApp
 {:appId string,
  :platform [PLATFORM_UNSPECIFIED IOS ANDROID],
  :displayName string,
  :publisher string},
 :reservationType
 [RESERVATION_TYPE_UNSPECIFIED
  RESERVATION_TYPE_NOT_GUARANTEED
  RESERVATION_TYPE_PROGRAMMATIC_GUARANTEED
  RESERVATION_TYPE_TAG_GUARANTEED
  RESERVATION_TYPE_PETRA_VIRAL
  RESERVATION_TYPE_INSTANT_RESERVE],
 :flight
 {:flightDateType
  [LINE_ITEM_FLIGHT_DATE_TYPE_UNSPECIFIED
   LINE_ITEM_FLIGHT_DATE_TYPE_INHERITED
   LINE_ITEM_FLIGHT_DATE_TYPE_CUSTOM],
  :dateRange
  {:startDate {:year integer, :month integer, :day integer},
   :endDate {:year integer, :month integer, :day integer}}},
 :excludeNewExchanges boolean,
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId lineItemId LineItem]
    (advertisers-lineItems-patch advertiserId lineItemId LineItem nil))
  ([advertiserId lineItemId LineItem optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}",
       :uri-template-args
       {:advertiserId advertiserId, :lineItemId lineItemId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body LineItem})))

(defn advertisers-lineItems-create
  "Creates a new line item. Returns the newly created line item if successful. YouTube & Partners line items cannot be created or updated using the API.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the line item belongs to.
LineItem:
{:insertionOrderId string,
 :targetingExpansion
 {:enableOptimizedTargeting boolean,
  :audienceExpansionSeedListExcluded boolean,
  :audienceExpansionLevel
  [UNKNOWN NO_REACH LEAST_REACH MID_REACH MOST_REACH]},
 :lineItemType
 [LINE_ITEM_TYPE_UNSPECIFIED
  LINE_ITEM_TYPE_DISPLAY_DEFAULT
  LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INSTALL
  LINE_ITEM_TYPE_VIDEO_DEFAULT
  LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INSTALL
  LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INVENTORY
  LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INVENTORY
  LINE_ITEM_TYPE_AUDIO_DEFAULT
  LINE_ITEM_TYPE_VIDEO_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_ACTION
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_AUDIO
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE_OVER_THE_TOP
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_TARGET_FREQUENCY
  LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIEW
  LINE_ITEM_TYPE_DISPLAY_OUT_OF_HOME
  LINE_ITEM_TYPE_VIDEO_OUT_OF_HOME],
 :partnerCosts
 [{:costType
   [PARTNER_COST_TYPE_UNSPECIFIED
    PARTNER_COST_TYPE_ADLOOX
    PARTNER_COST_TYPE_ADLOOX_PREBID
    PARTNER_COST_TYPE_ADSAFE
    PARTNER_COST_TYPE_ADXPOSE
    PARTNER_COST_TYPE_AGGREGATE_KNOWLEDGE
    PARTNER_COST_TYPE_AGENCY_TRADING_DESK
    PARTNER_COST_TYPE_DV360_FEE
    PARTNER_COST_TYPE_COMSCORE_VCE
    PARTNER_COST_TYPE_DATA_MANAGEMENT_PLATFORM
    PARTNER_COST_TYPE_DEFAULT
    PARTNER_COST_TYPE_DOUBLE_VERIFY
    PARTNER_COST_TYPE_DOUBLE_VERIFY_PREBID
    PARTNER_COST_TYPE_EVIDON
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_VIDEO
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_PREBID
    PARTNER_COST_TYPE_MEDIA_COST_DATA
    PARTNER_COST_TYPE_MOAT_VIDEO
    PARTNER_COST_TYPE_NIELSEN_DAR
    PARTNER_COST_TYPE_SHOP_LOCAL
    PARTNER_COST_TYPE_TERACENT
    PARTNER_COST_TYPE_THIRD_PARTY_AD_SERVER
    PARTNER_COST_TYPE_TRUST_METRICS
    PARTNER_COST_TYPE_VIZU
    PARTNER_COST_TYPE_ADLINGO_FEE
    PARTNER_COST_TYPE_CUSTOM_FEE_1
    PARTNER_COST_TYPE_CUSTOM_FEE_2
    PARTNER_COST_TYPE_CUSTOM_FEE_3
    PARTNER_COST_TYPE_CUSTOM_FEE_4
    PARTNER_COST_TYPE_CUSTOM_FEE_5
    PARTNER_COST_TYPE_SCIBIDS_FEE],
   :feeType
   [PARTNER_COST_FEE_TYPE_UNSPECIFIED
    PARTNER_COST_FEE_TYPE_CPM_FEE
    PARTNER_COST_FEE_TYPE_MEDIA_FEE],
   :feeAmount string,
   :feePercentageMillis string,
   :invoiceType
   [PARTNER_COST_INVOICE_TYPE_UNSPECIFIED
    PARTNER_COST_INVOICE_TYPE_DV360
    PARTNER_COST_INVOICE_TYPE_PARTNER]}],
 :bidStrategy
 {:fixedBid {:bidAmountMicros string},
  :maximizeSpendAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :maxAverageCpmBidAmountMicros string,
   :raiseBidForDeals boolean,
   :customBiddingAlgorithmId string},
  :performanceGoalAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :performanceGoalAmountMicros string,
   :maxAverageCpmBidAmountMicros string,
   :customBiddingAlgorithmId string},
  :youtubeAndPartnersBid
  {:type
   [YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_UNSPECIFIED
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPA
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_RESERVE_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_LIFT
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSIONS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_ROAS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSION_VALUE],
   :value string,
   :adGroupEffectiveTargetCpaValue string,
   :adGroupEffectiveTargetCpaSource
   [BIDDING_SOURCE_UNSPECIFIED
    BIDDING_SOURCE_LINE_ITEM
    BIDDING_SOURCE_AD_GROUP]}},
 :displayName string,
 :name string,
 :campaignId string,
 :pacing
 {:pacingPeriod
  [PACING_PERIOD_UNSPECIFIED PACING_PERIOD_DAILY PACING_PERIOD_FLIGHT],
  :pacingType
  [PACING_TYPE_UNSPECIFIED
   PACING_TYPE_AHEAD
   PACING_TYPE_ASAP
   PACING_TYPE_EVEN],
  :dailyMaxMicros string,
  :dailyMaxImpressions string},
 :updateTime string,
 :frequencyCap
 {:unlimited boolean,
  :timeUnit
  [TIME_UNIT_UNSPECIFIED
   TIME_UNIT_LIFETIME
   TIME_UNIT_MONTHS
   TIME_UNIT_WEEKS
   TIME_UNIT_DAYS
   TIME_UNIT_HOURS
   TIME_UNIT_MINUTES],
  :timeUnitCount integer,
  :maxImpressions integer,
  :maxViews integer},
 :warningMessages
 [[LINE_ITEM_WARNING_MESSAGE_UNSPECIFIED
   INVALID_FLIGHT_DATES
   EXPIRED
   PENDING_FLIGHT
   ALL_PARTNER_ENABLED_EXCHANGES_NEGATIVELY_TARGETED
   INVALID_INVENTORY_SOURCE
   APP_INVENTORY_INVALID_SITE_TARGETING
   APP_INVENTORY_INVALID_AUDIENCE_LISTS
   NO_VALID_CREATIVE
   PARENT_INSERTION_ORDER_PAUSED
   PARENT_INSERTION_ORDER_EXPIRED]],
 :creativeIds [string],
 :lineItemId string,
 :advertiserId string,
 :youtubeAndPartnersSettings
 {:leadFormId string,
  :videoAdSequenceSettings
  {:minimumDuration
   [VIDEO_AD_SEQUENCE_MINIMUM_DURATION_UNSPECIFIED
    VIDEO_AD_SEQUENCE_MINIMUM_DURATION_WEEK
    VIDEO_AD_SEQUENCE_MINIMUM_DURATION_MONTH],
   :steps
   [{:stepId string,
     :adGroupId string,
     :previousStepId string,
     :interactionType
     [INTERACTION_TYPE_UNSPECIFIED
      INTERACTION_TYPE_PAID_VIEW
      INTERACTION_TYPE_SKIP
      INTERACTION_TYPE_IMPRESSION
      INTERACTION_TYPE_ENGAGED_IMPRESSION]}]},
  :inventorySourceSettings
  {:includeYoutube boolean,
   :includeGoogleTv boolean,
   :includeYoutubeVideoPartners boolean},
  :viewFrequencyCap
  {:unlimited boolean,
   :timeUnit
   [TIME_UNIT_UNSPECIFIED
    TIME_UNIT_LIFETIME
    TIME_UNIT_MONTHS
    TIME_UNIT_WEEKS
    TIME_UNIT_DAYS
    TIME_UNIT_HOURS
    TIME_UNIT_MINUTES],
   :timeUnitCount integer,
   :maxImpressions integer,
   :maxViews integer},
  :relatedVideoIds [string],
  :linkedMerchantId string,
  :contentCategory
  [YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_UNSPECIFIED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_STANDARD
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_EXPANDED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_LIMITED],
  :effectiveContentCategory
  [YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_UNSPECIFIED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_STANDARD
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_EXPANDED
   YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_LIMITED],
  :targetFrequency
  {:targetCount string,
   :timeUnit
   [TIME_UNIT_UNSPECIFIED
    TIME_UNIT_LIFETIME
    TIME_UNIT_MONTHS
    TIME_UNIT_WEEKS
    TIME_UNIT_DAYS
    TIME_UNIT_HOURS
    TIME_UNIT_MINUTES],
   :timeUnitCount integer},
  :thirdPartyMeasurementConfigs
  {:viewabilityVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}],
   :brandSafetyVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}],
   :reachVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}],
   :brandLiftVendorConfigs
   [{:vendor
     [THIRD_PARTY_VENDOR_UNSPECIFIED
      THIRD_PARTY_VENDOR_MOAT
      THIRD_PARTY_VENDOR_DOUBLE_VERIFY
      THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
      THIRD_PARTY_VENDOR_COMSCORE
      THIRD_PARTY_VENDOR_TELEMETRY
      THIRD_PARTY_VENDOR_MEETRICS
      THIRD_PARTY_VENDOR_ZEFR
      THIRD_PARTY_VENDOR_NIELSEN
      THIRD_PARTY_VENDOR_KANTAR
      THIRD_PARTY_VENDOR_DYNATA],
     :placementId string}]}},
 :integrationDetails {:integrationCode string, :details string},
 :partnerRevenueModel
 {:markupType
  [PARTNER_REVENUE_MODEL_MARKUP_TYPE_UNSPECIFIED
   PARTNER_REVENUE_MODEL_MARKUP_TYPE_CPM
   PARTNER_REVENUE_MODEL_MARKUP_TYPE_MEDIA_COST_MARKUP
   PARTNER_REVENUE_MODEL_MARKUP_TYPE_TOTAL_MEDIA_COST_MARKUP],
  :markupAmount string},
 :conversionCounting
 {:postViewCountPercentageMillis string,
  :floodlightActivityConfigs
  [{:floodlightActivityId string,
    :postClickLookbackWindowDays integer,
    :postViewLookbackWindowDays integer}]},
 :budget
 {:budgetAllocationType
  [LINE_ITEM_BUDGET_ALLOCATION_TYPE_UNSPECIFIED
   LINE_ITEM_BUDGET_ALLOCATION_TYPE_AUTOMATIC
   LINE_ITEM_BUDGET_ALLOCATION_TYPE_FIXED
   LINE_ITEM_BUDGET_ALLOCATION_TYPE_UNLIMITED],
  :budgetUnit
  [BUDGET_UNIT_UNSPECIFIED
   BUDGET_UNIT_CURRENCY
   BUDGET_UNIT_IMPRESSIONS],
  :maxAmount string},
 :mobileApp
 {:appId string,
  :platform [PLATFORM_UNSPECIFIED IOS ANDROID],
  :displayName string,
  :publisher string},
 :reservationType
 [RESERVATION_TYPE_UNSPECIFIED
  RESERVATION_TYPE_NOT_GUARANTEED
  RESERVATION_TYPE_PROGRAMMATIC_GUARANTEED
  RESERVATION_TYPE_TAG_GUARANTEED
  RESERVATION_TYPE_PETRA_VIRAL
  RESERVATION_TYPE_INSTANT_RESERVE],
 :flight
 {:flightDateType
  [LINE_ITEM_FLIGHT_DATE_TYPE_UNSPECIFIED
   LINE_ITEM_FLIGHT_DATE_TYPE_INHERITED
   LINE_ITEM_FLIGHT_DATE_TYPE_CUSTOM],
  :dateRange
  {:startDate {:year integer, :month integer, :day integer},
   :endDate {:year integer, :month integer, :day integer}}},
 :excludeNewExchanges boolean,
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}"
  [advertiserId LineItem]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body LineItem}))

(defn advertisers-lineItems-bulkUpdate
  "Updates multiple line items. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * BulkEditAssignedTargetingOptions * UpdateLineItem * assignedTargetingOptions.create * assignedTargetingOptions.delete YouTube & Partners line items cannot be created or updated using the API.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this line item belongs to.
BulkUpdateLineItemsRequest:
{:lineItemIds [string],
 :targetLineItem
 {:insertionOrderId string,
  :targetingExpansion
  {:enableOptimizedTargeting boolean,
   :audienceExpansionSeedListExcluded boolean,
   :audienceExpansionLevel
   [UNKNOWN NO_REACH LEAST_REACH MID_REACH MOST_REACH]},
  :lineItemType
  [LINE_ITEM_TYPE_UNSPECIFIED
   LINE_ITEM_TYPE_DISPLAY_DEFAULT
   LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INSTALL
   LINE_ITEM_TYPE_VIDEO_DEFAULT
   LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INSTALL
   LINE_ITEM_TYPE_DISPLAY_MOBILE_APP_INVENTORY
   LINE_ITEM_TYPE_VIDEO_MOBILE_APP_INVENTORY
   LINE_ITEM_TYPE_AUDIO_DEFAULT
   LINE_ITEM_TYPE_VIDEO_OVER_THE_TOP
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_ACTION
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_AUDIO
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_NON_SKIPPABLE_OVER_THE_TOP
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_REACH_OVER_THE_TOP
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_SIMPLE_OVER_THE_TOP
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_TARGET_FREQUENCY
   LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIEW
   LINE_ITEM_TYPE_DISPLAY_OUT_OF_HOME
   LINE_ITEM_TYPE_VIDEO_OUT_OF_HOME],
  :partnerCosts
  [{:costType
    [PARTNER_COST_TYPE_UNSPECIFIED
     PARTNER_COST_TYPE_ADLOOX
     PARTNER_COST_TYPE_ADLOOX_PREBID
     PARTNER_COST_TYPE_ADSAFE
     PARTNER_COST_TYPE_ADXPOSE
     PARTNER_COST_TYPE_AGGREGATE_KNOWLEDGE
     PARTNER_COST_TYPE_AGENCY_TRADING_DESK
     PARTNER_COST_TYPE_DV360_FEE
     PARTNER_COST_TYPE_COMSCORE_VCE
     PARTNER_COST_TYPE_DATA_MANAGEMENT_PLATFORM
     PARTNER_COST_TYPE_DEFAULT
     PARTNER_COST_TYPE_DOUBLE_VERIFY
     PARTNER_COST_TYPE_DOUBLE_VERIFY_PREBID
     PARTNER_COST_TYPE_EVIDON
     PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_VIDEO
     PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_PREBID
     PARTNER_COST_TYPE_MEDIA_COST_DATA
     PARTNER_COST_TYPE_MOAT_VIDEO
     PARTNER_COST_TYPE_NIELSEN_DAR
     PARTNER_COST_TYPE_SHOP_LOCAL
     PARTNER_COST_TYPE_TERACENT
     PARTNER_COST_TYPE_THIRD_PARTY_AD_SERVER
     PARTNER_COST_TYPE_TRUST_METRICS
     PARTNER_COST_TYPE_VIZU
     PARTNER_COST_TYPE_ADLINGO_FEE
     PARTNER_COST_TYPE_CUSTOM_FEE_1
     PARTNER_COST_TYPE_CUSTOM_FEE_2
     PARTNER_COST_TYPE_CUSTOM_FEE_3
     PARTNER_COST_TYPE_CUSTOM_FEE_4
     PARTNER_COST_TYPE_CUSTOM_FEE_5
     PARTNER_COST_TYPE_SCIBIDS_FEE],
    :feeType
    [PARTNER_COST_FEE_TYPE_UNSPECIFIED
     PARTNER_COST_FEE_TYPE_CPM_FEE
     PARTNER_COST_FEE_TYPE_MEDIA_FEE],
    :feeAmount string,
    :feePercentageMillis string,
    :invoiceType
    [PARTNER_COST_INVOICE_TYPE_UNSPECIFIED
     PARTNER_COST_INVOICE_TYPE_DV360
     PARTNER_COST_INVOICE_TYPE_PARTNER]}],
  :bidStrategy
  {:fixedBid {:bidAmountMicros string},
   :maximizeSpendAutoBid
   {:performanceGoalType
    [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
    :maxAverageCpmBidAmountMicros string,
    :raiseBidForDeals boolean,
    :customBiddingAlgorithmId string},
   :performanceGoalAutoBid
   {:performanceGoalType
    [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
     BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
    :performanceGoalAmountMicros string,
    :maxAverageCpmBidAmountMicros string,
    :customBiddingAlgorithmId string},
   :youtubeAndPartnersBid
   {:type
    [YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_UNSPECIFIED
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPV
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPM
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPA
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPM
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_RESERVE_CPM
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_LIFT
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSIONS
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPV
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_ROAS
     YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSION_VALUE],
    :value string,
    :adGroupEffectiveTargetCpaValue string,
    :adGroupEffectiveTargetCpaSource
    [BIDDING_SOURCE_UNSPECIFIED
     BIDDING_SOURCE_LINE_ITEM
     BIDDING_SOURCE_AD_GROUP]}},
  :displayName string,
  :name string,
  :campaignId string,
  :pacing
  {:pacingPeriod
   [PACING_PERIOD_UNSPECIFIED
    PACING_PERIOD_DAILY
    PACING_PERIOD_FLIGHT],
   :pacingType
   [PACING_TYPE_UNSPECIFIED
    PACING_TYPE_AHEAD
    PACING_TYPE_ASAP
    PACING_TYPE_EVEN],
   :dailyMaxMicros string,
   :dailyMaxImpressions string},
  :updateTime string,
  :frequencyCap
  {:unlimited boolean,
   :timeUnit
   [TIME_UNIT_UNSPECIFIED
    TIME_UNIT_LIFETIME
    TIME_UNIT_MONTHS
    TIME_UNIT_WEEKS
    TIME_UNIT_DAYS
    TIME_UNIT_HOURS
    TIME_UNIT_MINUTES],
   :timeUnitCount integer,
   :maxImpressions integer,
   :maxViews integer},
  :warningMessages
  [[LINE_ITEM_WARNING_MESSAGE_UNSPECIFIED
    INVALID_FLIGHT_DATES
    EXPIRED
    PENDING_FLIGHT
    ALL_PARTNER_ENABLED_EXCHANGES_NEGATIVELY_TARGETED
    INVALID_INVENTORY_SOURCE
    APP_INVENTORY_INVALID_SITE_TARGETING
    APP_INVENTORY_INVALID_AUDIENCE_LISTS
    NO_VALID_CREATIVE
    PARENT_INSERTION_ORDER_PAUSED
    PARENT_INSERTION_ORDER_EXPIRED]],
  :creativeIds [string],
  :lineItemId string,
  :advertiserId string,
  :youtubeAndPartnersSettings
  {:leadFormId string,
   :videoAdSequenceSettings
   {:minimumDuration
    [VIDEO_AD_SEQUENCE_MINIMUM_DURATION_UNSPECIFIED
     VIDEO_AD_SEQUENCE_MINIMUM_DURATION_WEEK
     VIDEO_AD_SEQUENCE_MINIMUM_DURATION_MONTH],
    :steps
    [{:stepId string,
      :adGroupId string,
      :previousStepId string,
      :interactionType
      [INTERACTION_TYPE_UNSPECIFIED
       INTERACTION_TYPE_PAID_VIEW
       INTERACTION_TYPE_SKIP
       INTERACTION_TYPE_IMPRESSION
       INTERACTION_TYPE_ENGAGED_IMPRESSION]}]},
   :inventorySourceSettings
   {:includeYoutube boolean,
    :includeGoogleTv boolean,
    :includeYoutubeVideoPartners boolean},
   :viewFrequencyCap
   {:unlimited boolean,
    :timeUnit
    [TIME_UNIT_UNSPECIFIED
     TIME_UNIT_LIFETIME
     TIME_UNIT_MONTHS
     TIME_UNIT_WEEKS
     TIME_UNIT_DAYS
     TIME_UNIT_HOURS
     TIME_UNIT_MINUTES],
    :timeUnitCount integer,
    :maxImpressions integer,
    :maxViews integer},
   :relatedVideoIds [string],
   :linkedMerchantId string,
   :contentCategory
   [YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_UNSPECIFIED
    YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_STANDARD
    YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_EXPANDED
    YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_LIMITED],
   :effectiveContentCategory
   [YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_UNSPECIFIED
    YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_STANDARD
    YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_EXPANDED
    YOUTUBE_AND_PARTNERS_CONTENT_CATEGORY_LIMITED],
   :targetFrequency
   {:targetCount string,
    :timeUnit
    [TIME_UNIT_UNSPECIFIED
     TIME_UNIT_LIFETIME
     TIME_UNIT_MONTHS
     TIME_UNIT_WEEKS
     TIME_UNIT_DAYS
     TIME_UNIT_HOURS
     TIME_UNIT_MINUTES],
    :timeUnitCount integer},
   :thirdPartyMeasurementConfigs
   {:viewabilityVendorConfigs
    [{:vendor
      [THIRD_PARTY_VENDOR_UNSPECIFIED
       THIRD_PARTY_VENDOR_MOAT
       THIRD_PARTY_VENDOR_DOUBLE_VERIFY
       THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
       THIRD_PARTY_VENDOR_COMSCORE
       THIRD_PARTY_VENDOR_TELEMETRY
       THIRD_PARTY_VENDOR_MEETRICS
       THIRD_PARTY_VENDOR_ZEFR
       THIRD_PARTY_VENDOR_NIELSEN
       THIRD_PARTY_VENDOR_KANTAR
       THIRD_PARTY_VENDOR_DYNATA],
      :placementId string}],
    :brandSafetyVendorConfigs
    [{:vendor
      [THIRD_PARTY_VENDOR_UNSPECIFIED
       THIRD_PARTY_VENDOR_MOAT
       THIRD_PARTY_VENDOR_DOUBLE_VERIFY
       THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
       THIRD_PARTY_VENDOR_COMSCORE
       THIRD_PARTY_VENDOR_TELEMETRY
       THIRD_PARTY_VENDOR_MEETRICS
       THIRD_PARTY_VENDOR_ZEFR
       THIRD_PARTY_VENDOR_NIELSEN
       THIRD_PARTY_VENDOR_KANTAR
       THIRD_PARTY_VENDOR_DYNATA],
      :placementId string}],
    :reachVendorConfigs
    [{:vendor
      [THIRD_PARTY_VENDOR_UNSPECIFIED
       THIRD_PARTY_VENDOR_MOAT
       THIRD_PARTY_VENDOR_DOUBLE_VERIFY
       THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
       THIRD_PARTY_VENDOR_COMSCORE
       THIRD_PARTY_VENDOR_TELEMETRY
       THIRD_PARTY_VENDOR_MEETRICS
       THIRD_PARTY_VENDOR_ZEFR
       THIRD_PARTY_VENDOR_NIELSEN
       THIRD_PARTY_VENDOR_KANTAR
       THIRD_PARTY_VENDOR_DYNATA],
      :placementId string}],
    :brandLiftVendorConfigs
    [{:vendor
      [THIRD_PARTY_VENDOR_UNSPECIFIED
       THIRD_PARTY_VENDOR_MOAT
       THIRD_PARTY_VENDOR_DOUBLE_VERIFY
       THIRD_PARTY_VENDOR_INTEGRAL_AD_SCIENCE
       THIRD_PARTY_VENDOR_COMSCORE
       THIRD_PARTY_VENDOR_TELEMETRY
       THIRD_PARTY_VENDOR_MEETRICS
       THIRD_PARTY_VENDOR_ZEFR
       THIRD_PARTY_VENDOR_NIELSEN
       THIRD_PARTY_VENDOR_KANTAR
       THIRD_PARTY_VENDOR_DYNATA],
      :placementId string}]}},
  :integrationDetails {:integrationCode string, :details string},
  :partnerRevenueModel
  {:markupType
   [PARTNER_REVENUE_MODEL_MARKUP_TYPE_UNSPECIFIED
    PARTNER_REVENUE_MODEL_MARKUP_TYPE_CPM
    PARTNER_REVENUE_MODEL_MARKUP_TYPE_MEDIA_COST_MARKUP
    PARTNER_REVENUE_MODEL_MARKUP_TYPE_TOTAL_MEDIA_COST_MARKUP],
   :markupAmount string},
  :conversionCounting
  {:postViewCountPercentageMillis string,
   :floodlightActivityConfigs
   [{:floodlightActivityId string,
     :postClickLookbackWindowDays integer,
     :postViewLookbackWindowDays integer}]},
  :budget
  {:budgetAllocationType
   [LINE_ITEM_BUDGET_ALLOCATION_TYPE_UNSPECIFIED
    LINE_ITEM_BUDGET_ALLOCATION_TYPE_AUTOMATIC
    LINE_ITEM_BUDGET_ALLOCATION_TYPE_FIXED
    LINE_ITEM_BUDGET_ALLOCATION_TYPE_UNLIMITED],
   :budgetUnit
   [BUDGET_UNIT_UNSPECIFIED
    BUDGET_UNIT_CURRENCY
    BUDGET_UNIT_IMPRESSIONS],
   :maxAmount string},
  :mobileApp
  {:appId string,
   :platform [PLATFORM_UNSPECIFIED IOS ANDROID],
   :displayName string,
   :publisher string},
  :reservationType
  [RESERVATION_TYPE_UNSPECIFIED
   RESERVATION_TYPE_NOT_GUARANTEED
   RESERVATION_TYPE_PROGRAMMATIC_GUARANTEED
   RESERVATION_TYPE_TAG_GUARANTEED
   RESERVATION_TYPE_PETRA_VIRAL
   RESERVATION_TYPE_INSTANT_RESERVE],
  :flight
  {:flightDateType
   [LINE_ITEM_FLIGHT_DATE_TYPE_UNSPECIFIED
    LINE_ITEM_FLIGHT_DATE_TYPE_INHERITED
    LINE_ITEM_FLIGHT_DATE_TYPE_CUSTOM],
   :dateRange
   {:startDate {:year integer, :month integer, :day integer},
    :endDate {:year integer, :month integer, :day integer}}},
  :excludeNewExchanges boolean,
  :entityStatus
  [ENTITY_STATUS_UNSPECIFIED
   ENTITY_STATUS_ACTIVE
   ENTITY_STATUS_ARCHIVED
   ENTITY_STATUS_DRAFT
   ENTITY_STATUS_PAUSED
   ENTITY_STATUS_SCHEDULED_FOR_DELETION]},
 :updateMask string}"
  [advertiserId BulkUpdateLineItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems:bulkUpdate",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkUpdateLineItemsRequest}))

(defn advertisers-lineItems-delete
  "Deletes a line item. Returns error code `NOT_FOUND` if the line item does not exist. The line item should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it. YouTube & Partners line items cannot be created or updated using the API.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser this line item belongs to.
lineItemId <string> The ID of the line item to delete."
  [advertiserId lineItemId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}",
     :uri-template-args
     {:advertiserId advertiserId, :lineItemId lineItemId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-lineItems-bulkEditAssignedTargetingOptions
  "Bulk edits targeting options under multiple line items. The operation will delete the assigned targeting options provided in BulkEditAssignedTargetingOptionsRequest.delete_requests and then create the assigned targeting options provided in BulkEditAssignedTargetingOptionsRequest.create_requests. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * lineItems.bulkUpdate * lineItems.patch * assignedTargetingOptions.create * assignedTargetingOptions.delete YouTube & Partners line items cannot be created or updated using the API.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line items belong to.
BulkEditAssignedTargetingOptionsRequest:
{:lineItemIds [string],
 :deleteRequests
 [{:targetingType
   [TARGETING_TYPE_UNSPECIFIED
    TARGETING_TYPE_CHANNEL
    TARGETING_TYPE_APP_CATEGORY
    TARGETING_TYPE_APP
    TARGETING_TYPE_URL
    TARGETING_TYPE_DAY_AND_TIME
    TARGETING_TYPE_AGE_RANGE
    TARGETING_TYPE_REGIONAL_LOCATION_LIST
    TARGETING_TYPE_PROXIMITY_LOCATION_LIST
    TARGETING_TYPE_GENDER
    TARGETING_TYPE_VIDEO_PLAYER_SIZE
    TARGETING_TYPE_USER_REWARDED_CONTENT
    TARGETING_TYPE_PARENTAL_STATUS
    TARGETING_TYPE_CONTENT_INSTREAM_POSITION
    TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
    TARGETING_TYPE_DEVICE_TYPE
    TARGETING_TYPE_AUDIENCE_GROUP
    TARGETING_TYPE_BROWSER
    TARGETING_TYPE_HOUSEHOLD_INCOME
    TARGETING_TYPE_ON_SCREEN_POSITION
    TARGETING_TYPE_THIRD_PARTY_VERIFIER
    TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
    TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
    TARGETING_TYPE_ENVIRONMENT
    TARGETING_TYPE_CARRIER_AND_ISP
    TARGETING_TYPE_OPERATING_SYSTEM
    TARGETING_TYPE_DEVICE_MAKE_MODEL
    TARGETING_TYPE_KEYWORD
    TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
    TARGETING_TYPE_VIEWABILITY
    TARGETING_TYPE_CATEGORY
    TARGETING_TYPE_INVENTORY_SOURCE
    TARGETING_TYPE_LANGUAGE
    TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
    TARGETING_TYPE_GEO_REGION
    TARGETING_TYPE_INVENTORY_SOURCE_GROUP
    TARGETING_TYPE_EXCHANGE
    TARGETING_TYPE_SUB_EXCHANGE
    TARGETING_TYPE_POI
    TARGETING_TYPE_BUSINESS_CHAIN
    TARGETING_TYPE_CONTENT_DURATION
    TARGETING_TYPE_CONTENT_STREAM_TYPE
    TARGETING_TYPE_NATIVE_CONTENT_POSITION
    TARGETING_TYPE_OMID
    TARGETING_TYPE_AUDIO_CONTENT_TYPE
    TARGETING_TYPE_CONTENT_GENRE
    TARGETING_TYPE_YOUTUBE_VIDEO
    TARGETING_TYPE_YOUTUBE_CHANNEL
    TARGETING_TYPE_SESSION_POSITION],
   :assignedTargetingOptionIds [string]}],
 :createRequests
 [{:targetingType
   [TARGETING_TYPE_UNSPECIFIED
    TARGETING_TYPE_CHANNEL
    TARGETING_TYPE_APP_CATEGORY
    TARGETING_TYPE_APP
    TARGETING_TYPE_URL
    TARGETING_TYPE_DAY_AND_TIME
    TARGETING_TYPE_AGE_RANGE
    TARGETING_TYPE_REGIONAL_LOCATION_LIST
    TARGETING_TYPE_PROXIMITY_LOCATION_LIST
    TARGETING_TYPE_GENDER
    TARGETING_TYPE_VIDEO_PLAYER_SIZE
    TARGETING_TYPE_USER_REWARDED_CONTENT
    TARGETING_TYPE_PARENTAL_STATUS
    TARGETING_TYPE_CONTENT_INSTREAM_POSITION
    TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
    TARGETING_TYPE_DEVICE_TYPE
    TARGETING_TYPE_AUDIENCE_GROUP
    TARGETING_TYPE_BROWSER
    TARGETING_TYPE_HOUSEHOLD_INCOME
    TARGETING_TYPE_ON_SCREEN_POSITION
    TARGETING_TYPE_THIRD_PARTY_VERIFIER
    TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
    TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
    TARGETING_TYPE_ENVIRONMENT
    TARGETING_TYPE_CARRIER_AND_ISP
    TARGETING_TYPE_OPERATING_SYSTEM
    TARGETING_TYPE_DEVICE_MAKE_MODEL
    TARGETING_TYPE_KEYWORD
    TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
    TARGETING_TYPE_VIEWABILITY
    TARGETING_TYPE_CATEGORY
    TARGETING_TYPE_INVENTORY_SOURCE
    TARGETING_TYPE_LANGUAGE
    TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
    TARGETING_TYPE_GEO_REGION
    TARGETING_TYPE_INVENTORY_SOURCE_GROUP
    TARGETING_TYPE_EXCHANGE
    TARGETING_TYPE_SUB_EXCHANGE
    TARGETING_TYPE_POI
    TARGETING_TYPE_BUSINESS_CHAIN
    TARGETING_TYPE_CONTENT_DURATION
    TARGETING_TYPE_CONTENT_STREAM_TYPE
    TARGETING_TYPE_NATIVE_CONTENT_POSITION
    TARGETING_TYPE_OMID
    TARGETING_TYPE_AUDIO_CONTENT_TYPE
    TARGETING_TYPE_CONTENT_GENRE
    TARGETING_TYPE_YOUTUBE_VIDEO
    TARGETING_TYPE_YOUTUBE_CHANNEL
    TARGETING_TYPE_SESSION_POSITION],
   :assignedTargetingOptions
   [{:contentGenreDetails
     {:targetingOptionId string,
      :displayName string,
      :negative boolean},
     :negativeKeywordListDetails {:negativeKeywordListId string},
     :parentalStatusDetails
     {:parentalStatus
      [PARENTAL_STATUS_UNSPECIFIED
       PARENTAL_STATUS_PARENT
       PARENTAL_STATUS_NOT_A_PARENT
       PARENTAL_STATUS_UNKNOWN]},
     :geoRegionDetails
     {:displayName string,
      :targetingOptionId string,
      :geoRegionType
      [GEO_REGION_TYPE_UNKNOWN
       GEO_REGION_TYPE_OTHER
       GEO_REGION_TYPE_COUNTRY
       GEO_REGION_TYPE_REGION
       GEO_REGION_TYPE_TERRITORY
       GEO_REGION_TYPE_PROVINCE
       GEO_REGION_TYPE_STATE
       GEO_REGION_TYPE_PREFECTURE
       GEO_REGION_TYPE_GOVERNORATE
       GEO_REGION_TYPE_CANTON
       GEO_REGION_TYPE_UNION_TERRITORY
       GEO_REGION_TYPE_AUTONOMOUS_COMMUNITY
       GEO_REGION_TYPE_DMA_REGION
       GEO_REGION_TYPE_METRO
       GEO_REGION_TYPE_CONGRESSIONAL_DISTRICT
       GEO_REGION_TYPE_COUNTY
       GEO_REGION_TYPE_MUNICIPALITY
       GEO_REGION_TYPE_CITY
       GEO_REGION_TYPE_POSTAL_CODE
       GEO_REGION_TYPE_DEPARTMENT
       GEO_REGION_TYPE_AIRPORT
       GEO_REGION_TYPE_TV_REGION
       GEO_REGION_TYPE_OKRUG
       GEO_REGION_TYPE_BOROUGH
       GEO_REGION_TYPE_CITY_REGION
       GEO_REGION_TYPE_ARRONDISSEMENT
       GEO_REGION_TYPE_NEIGHBORHOOD
       GEO_REGION_TYPE_UNIVERSITY
       GEO_REGION_TYPE_DISTRICT],
      :negative boolean},
     :regionalLocationListDetails
     {:regionalLocationListId string, :negative boolean},
     :browserDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :inventorySourceGroupDetails {:inventorySourceGroupId string},
     :nativeContentPositionDetails
     {:contentPosition
      [NATIVE_CONTENT_POSITION_UNSPECIFIED
       NATIVE_CONTENT_POSITION_UNKNOWN
       NATIVE_CONTENT_POSITION_IN_ARTICLE
       NATIVE_CONTENT_POSITION_IN_FEED
       NATIVE_CONTENT_POSITION_PERIPHERAL
       NATIVE_CONTENT_POSITION_RECOMMENDATION]},
     :assignedTargetingOptionId string,
     :operatingSystemDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :appCategoryDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :contentInstreamPositionDetails
     {:contentInstreamPosition
      [CONTENT_INSTREAM_POSITION_UNSPECIFIED
       CONTENT_INSTREAM_POSITION_PRE_ROLL
       CONTENT_INSTREAM_POSITION_MID_ROLL
       CONTENT_INSTREAM_POSITION_POST_ROLL
       CONTENT_INSTREAM_POSITION_UNKNOWN],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :inventorySourceDetails {:inventorySourceId string},
     :audioContentTypeDetails
     {:audioContentType
      [AUDIO_CONTENT_TYPE_UNSPECIFIED
       AUDIO_CONTENT_TYPE_UNKNOWN
       AUDIO_CONTENT_TYPE_MUSIC
       AUDIO_CONTENT_TYPE_BROADCAST
       AUDIO_CONTENT_TYPE_PODCAST]},
     :thirdPartyVerifierDetails
     {:adloox
      {:excludedAdlooxCategories
       [[ADLOOX_UNSPECIFIED
         ADULT_CONTENT_HARD
         ADULT_CONTENT_SOFT
         ILLEGAL_CONTENT
         BORDERLINE_CONTENT
         DISCRIMINATORY_CONTENT
         VIOLENT_CONTENT_WEAPONS
         LOW_VIEWABILITY_DOMAINS
         FRAUD]]},
      :doubleVerify
      {:brandSafetyCategories DoubleVerifyBrandSafetyCategories,
       :avoidedAgeRatings
       [[AGE_RATING_UNSPECIFIED
         APP_AGE_RATE_UNKNOWN
         APP_AGE_RATE_4_PLUS
         APP_AGE_RATE_9_PLUS
         APP_AGE_RATE_12_PLUS
         APP_AGE_RATE_17_PLUS
         APP_AGE_RATE_18_PLUS]],
       :appStarRating DoubleVerifyAppStarRating,
       :displayViewability DoubleVerifyDisplayViewability,
       :videoViewability DoubleVerifyVideoViewability,
       :fraudInvalidTraffic DoubleVerifyFraudInvalidTraffic,
       :customSegmentId string},
      :integralAdScience
      {:excludedIllegalDownloadsRisk
       [ILLEGAL_DOWNLOADS_UNSPECIFIED
        ILLEGAL_DOWNLOADS_HR
        ILLEGAL_DOWNLOADS_HMR],
       :excludedOffensiveLanguageRisk
       [OFFENSIVE_LANGUAGE_UNSPECIFIED
        OFFENSIVE_LANGUAGE_HR
        OFFENSIVE_LANGUAGE_HMR],
       :excludeUnrateable boolean,
       :excludedDrugsRisk [DRUGS_UNSPECIFIED DRUGS_HR DRUGS_HMR],
       :excludedGamblingRisk
       [GAMBLING_UNSPECIFIED GAMBLING_HR GAMBLING_HMR],
       :excludedAdultRisk [ADULT_UNSPECIFIED ADULT_HR ADULT_HMR],
       :displayViewability
       [PERFORMANCE_VIEWABILITY_UNSPECIFIED
        PERFORMANCE_VIEWABILITY_40
        PERFORMANCE_VIEWABILITY_50
        PERFORMANCE_VIEWABILITY_60
        PERFORMANCE_VIEWABILITY_70],
       :excludedViolenceRisk
       [VIOLENCE_UNSPECIFIED VIOLENCE_HR VIOLENCE_HMR],
       :traqScoreOption
       [TRAQ_UNSPECIFIED
        TRAQ_250
        TRAQ_500
        TRAQ_600
        TRAQ_700
        TRAQ_750
        TRAQ_875
        TRAQ_1000],
       :excludedHateSpeechRisk
       [HATE_SPEECH_UNSPECIFIED HATE_SPEECH_HR HATE_SPEECH_HMR],
       :videoViewability
       [VIDEO_VIEWABILITY_UNSPECIFIED
        VIDEO_VIEWABILITY_40
        VIDEO_VIEWABILITY_50
        VIDEO_VIEWABILITY_60
        VIDEO_VIEWABILITY_70],
       :excludedAdFraudRisk
       [SUSPICIOUS_ACTIVITY_UNSPECIFIED
        SUSPICIOUS_ACTIVITY_HR
        SUSPICIOUS_ACTIVITY_HMR],
       :customSegmentId [string],
       :excludedAlcoholRisk
       [ALCOHOL_UNSPECIFIED ALCOHOL_HR ALCOHOL_HMR]}},
     :name string,
     :onScreenPositionDetails
     {:targetingOptionId string,
      :onScreenPosition
      [ON_SCREEN_POSITION_UNSPECIFIED
       ON_SCREEN_POSITION_UNKNOWN
       ON_SCREEN_POSITION_ABOVE_THE_FOLD
       ON_SCREEN_POSITION_BELOW_THE_FOLD],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :videoPlayerSizeDetails
     {:videoPlayerSize
      [VIDEO_PLAYER_SIZE_UNSPECIFIED
       VIDEO_PLAYER_SIZE_SMALL
       VIDEO_PLAYER_SIZE_LARGE
       VIDEO_PLAYER_SIZE_HD
       VIDEO_PLAYER_SIZE_UNKNOWN]},
     :carrierAndIspDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :proximityLocationListDetails
     {:proximityLocationListId string,
      :proximityRadius number,
      :proximityRadiusUnit
      [PROXIMITY_RADIUS_UNIT_UNSPECIFIED
       PROXIMITY_RADIUS_UNIT_MILES
       PROXIMITY_RADIUS_UNIT_KILOMETERS]},
     :contentStreamTypeDetails
     {:targetingOptionId string,
      :contentStreamType
      [CONTENT_STREAM_TYPE_UNSPECIFIED
       CONTENT_LIVE_STREAM
       CONTENT_ON_DEMAND]},
     :digitalContentLabelExclusionDetails
     {:excludedContentRatingTier
      [CONTENT_RATING_TIER_UNSPECIFIED
       CONTENT_RATING_TIER_UNRATED
       CONTENT_RATING_TIER_GENERAL
       CONTENT_RATING_TIER_PARENTAL_GUIDANCE
       CONTENT_RATING_TIER_TEENS
       CONTENT_RATING_TIER_MATURE
       CONTENT_RATING_TIER_FAMILIES]},
     :ageRangeDetails
     {:ageRange
      [AGE_RANGE_UNSPECIFIED
       AGE_RANGE_18_24
       AGE_RANGE_25_34
       AGE_RANGE_35_44
       AGE_RANGE_45_54
       AGE_RANGE_55_64
       AGE_RANGE_65_PLUS
       AGE_RANGE_UNKNOWN
       AGE_RANGE_18_20
       AGE_RANGE_21_24
       AGE_RANGE_25_29
       AGE_RANGE_30_34
       AGE_RANGE_35_39
       AGE_RANGE_40_44
       AGE_RANGE_45_49
       AGE_RANGE_50_54
       AGE_RANGE_55_59
       AGE_RANGE_60_64]},
     :deviceMakeModelDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :categoryDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :inheritance
     [INHERITANCE_UNSPECIFIED
      NOT_INHERITED
      INHERITED_FROM_PARTNER
      INHERITED_FROM_ADVERTISER],
     :businessChainDetails
     {:displayName string,
      :targetingOptionId string,
      :proximityRadiusAmount number,
      :proximityRadiusUnit
      [DISTANCE_UNIT_UNSPECIFIED
       DISTANCE_UNIT_MILES
       DISTANCE_UNIT_KILOMETERS]},
     :audienceGroupDetails
     {:includedFirstAndThirdPartyAudienceGroups
      [{:settings [FirstAndThirdPartyAudienceTargetingSetting]}],
      :includedGoogleAudienceGroup
      {:settings [GoogleAudienceTargetingSetting]},
      :includedCustomListGroup
      {:settings [CustomListTargetingSetting]},
      :includedCombinedAudienceGroup
      {:settings [CombinedAudienceTargetingSetting]},
      :excludedFirstAndThirdPartyAudienceGroup
      {:settings [FirstAndThirdPartyAudienceTargetingSetting]},
      :excludedGoogleAudienceGroup
      {:settings [GoogleAudienceTargetingSetting]}},
     :channelDetails {:channelId string, :negative boolean},
     :contentDurationDetails
     {:targetingOptionId string,
      :contentDuration
      [CONTENT_DURATION_UNSPECIFIED
       CONTENT_DURATION_UNKNOWN
       CONTENT_DURATION_0_TO_1_MIN
       CONTENT_DURATION_1_TO_5_MIN
       CONTENT_DURATION_5_TO_15_MIN
       CONTENT_DURATION_15_TO_30_MIN
       CONTENT_DURATION_30_TO_60_MIN
       CONTENT_DURATION_OVER_60_MIN]},
     :targetingType
     [TARGETING_TYPE_UNSPECIFIED
      TARGETING_TYPE_CHANNEL
      TARGETING_TYPE_APP_CATEGORY
      TARGETING_TYPE_APP
      TARGETING_TYPE_URL
      TARGETING_TYPE_DAY_AND_TIME
      TARGETING_TYPE_AGE_RANGE
      TARGETING_TYPE_REGIONAL_LOCATION_LIST
      TARGETING_TYPE_PROXIMITY_LOCATION_LIST
      TARGETING_TYPE_GENDER
      TARGETING_TYPE_VIDEO_PLAYER_SIZE
      TARGETING_TYPE_USER_REWARDED_CONTENT
      TARGETING_TYPE_PARENTAL_STATUS
      TARGETING_TYPE_CONTENT_INSTREAM_POSITION
      TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
      TARGETING_TYPE_DEVICE_TYPE
      TARGETING_TYPE_AUDIENCE_GROUP
      TARGETING_TYPE_BROWSER
      TARGETING_TYPE_HOUSEHOLD_INCOME
      TARGETING_TYPE_ON_SCREEN_POSITION
      TARGETING_TYPE_THIRD_PARTY_VERIFIER
      TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
      TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
      TARGETING_TYPE_ENVIRONMENT
      TARGETING_TYPE_CARRIER_AND_ISP
      TARGETING_TYPE_OPERATING_SYSTEM
      TARGETING_TYPE_DEVICE_MAKE_MODEL
      TARGETING_TYPE_KEYWORD
      TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
      TARGETING_TYPE_VIEWABILITY
      TARGETING_TYPE_CATEGORY
      TARGETING_TYPE_INVENTORY_SOURCE
      TARGETING_TYPE_LANGUAGE
      TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
      TARGETING_TYPE_GEO_REGION
      TARGETING_TYPE_INVENTORY_SOURCE_GROUP
      TARGETING_TYPE_EXCHANGE
      TARGETING_TYPE_SUB_EXCHANGE
      TARGETING_TYPE_POI
      TARGETING_TYPE_BUSINESS_CHAIN
      TARGETING_TYPE_CONTENT_DURATION
      TARGETING_TYPE_CONTENT_STREAM_TYPE
      TARGETING_TYPE_NATIVE_CONTENT_POSITION
      TARGETING_TYPE_OMID
      TARGETING_TYPE_AUDIO_CONTENT_TYPE
      TARGETING_TYPE_CONTENT_GENRE
      TARGETING_TYPE_YOUTUBE_VIDEO
      TARGETING_TYPE_YOUTUBE_CHANNEL
      TARGETING_TYPE_SESSION_POSITION],
     :environmentDetails
     {:environment
      [ENVIRONMENT_UNSPECIFIED
       ENVIRONMENT_WEB_OPTIMIZED
       ENVIRONMENT_WEB_NOT_OPTIMIZED
       ENVIRONMENT_APP]},
     :poiDetails
     {:displayName string,
      :targetingOptionId string,
      :latitude number,
      :longitude number,
      :proximityRadiusAmount number,
      :proximityRadiusUnit
      [DISTANCE_UNIT_UNSPECIFIED
       DISTANCE_UNIT_MILES
       DISTANCE_UNIT_KILOMETERS]},
     :sensitiveCategoryExclusionDetails
     {:excludedSensitiveCategory
      [SENSITIVE_CATEGORY_UNSPECIFIED
       SENSITIVE_CATEGORY_ADULT
       SENSITIVE_CATEGORY_DEROGATORY
       SENSITIVE_CATEGORY_DOWNLOADS_SHARING
       SENSITIVE_CATEGORY_WEAPONS
       SENSITIVE_CATEGORY_GAMBLING
       SENSITIVE_CATEGORY_VIOLENCE
       SENSITIVE_CATEGORY_SUGGESTIVE
       SENSITIVE_CATEGORY_PROFANITY
       SENSITIVE_CATEGORY_ALCOHOL
       SENSITIVE_CATEGORY_DRUGS
       SENSITIVE_CATEGORY_TOBACCO
       SENSITIVE_CATEGORY_POLITICS
       SENSITIVE_CATEGORY_RELIGION
       SENSITIVE_CATEGORY_TRAGEDY
       SENSITIVE_CATEGORY_TRANSPORTATION_ACCIDENTS
       SENSITIVE_CATEGORY_SENSITIVE_SOCIAL_ISSUES
       SENSITIVE_CATEGORY_SHOCKING
       SENSITIVE_CATEGORY_EMBEDDED_VIDEO
       SENSITIVE_CATEGORY_LIVE_STREAMING_VIDEO]},
     :youtubeVideoDetails {:videoId string, :negative boolean},
     :sessionPositionDetails
     {:sessionPosition
      [SESSION_POSITION_UNSPECIFIED
       SESSION_POSITION_FIRST_IMPRESSION]},
     :deviceTypeDetails
     {:deviceType
      [DEVICE_TYPE_UNSPECIFIED
       DEVICE_TYPE_COMPUTER
       DEVICE_TYPE_CONNECTED_TV
       DEVICE_TYPE_SMART_PHONE
       DEVICE_TYPE_TABLET],
      :youtubeAndPartnersBidMultiplier number},
     :appDetails
     {:appId string,
      :displayName string,
      :negative boolean,
      :appPlatform
      [APP_PLATFORM_UNSPECIFIED
       APP_PLATFORM_IOS
       APP_PLATFORM_ANDROID
       APP_PLATFORM_ROKU
       APP_PLATFORM_AMAZON_FIRETV
       APP_PLATFORM_PLAYSTATION
       APP_PLATFORM_APPLE_TV
       APP_PLATFORM_XBOX
       APP_PLATFORM_SAMSUNG_TV
       APP_PLATFORM_ANDROID_TV
       APP_PLATFORM_GENERIC_CTV
       APP_PLATFORM_LG_TV
       APP_PLATFORM_VIZIO_TV]},
     :subExchangeDetails {:targetingOptionId string},
     :genderDetails
     {:gender
      [GENDER_UNSPECIFIED GENDER_MALE GENDER_FEMALE GENDER_UNKNOWN]},
     :languageDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :viewabilityDetails
     {:viewability
      [VIEWABILITY_UNSPECIFIED
       VIEWABILITY_10_PERCENT_OR_MORE
       VIEWABILITY_20_PERCENT_OR_MORE
       VIEWABILITY_30_PERCENT_OR_MORE
       VIEWABILITY_40_PERCENT_OR_MORE
       VIEWABILITY_50_PERCENT_OR_MORE
       VIEWABILITY_60_PERCENT_OR_MORE
       VIEWABILITY_70_PERCENT_OR_MORE
       VIEWABILITY_80_PERCENT_OR_MORE
       VIEWABILITY_90_PERCENT_OR_MORE]},
     :assignedTargetingOptionIdAlias string,
     :keywordDetails {:keyword string, :negative boolean},
     :urlDetails {:url string, :negative boolean},
     :exchangeDetails
     {:exchange
      [EXCHANGE_UNSPECIFIED
       EXCHANGE_GOOGLE_AD_MANAGER
       EXCHANGE_APPNEXUS
       EXCHANGE_BRIGHTROLL
       EXCHANGE_ADFORM
       EXCHANGE_ADMETA
       EXCHANGE_ADMIXER
       EXCHANGE_ADSMOGO
       EXCHANGE_ADSWIZZ
       EXCHANGE_BIDSWITCH
       EXCHANGE_BRIGHTROLL_DISPLAY
       EXCHANGE_CADREON
       EXCHANGE_DAILYMOTION
       EXCHANGE_FIVE
       EXCHANGE_FLUCT
       EXCHANGE_FREEWHEEL
       EXCHANGE_GENIEE
       EXCHANGE_GUMGUM
       EXCHANGE_IMOBILE
       EXCHANGE_IBILLBOARD
       EXCHANGE_IMPROVE_DIGITAL
       EXCHANGE_INDEX
       EXCHANGE_KARGO
       EXCHANGE_MICROAD
       EXCHANGE_MOPUB
       EXCHANGE_NEND
       EXCHANGE_ONE_BY_AOL_DISPLAY
       EXCHANGE_ONE_BY_AOL_MOBILE
       EXCHANGE_ONE_BY_AOL_VIDEO
       EXCHANGE_OOYALA
       EXCHANGE_OPENX
       EXCHANGE_PERMODO
       EXCHANGE_PLATFORMONE
       EXCHANGE_PLATFORMID
       EXCHANGE_PUBMATIC
       EXCHANGE_PULSEPOINT
       EXCHANGE_REVENUEMAX
       EXCHANGE_RUBICON
       EXCHANGE_SMARTCLIP
       EXCHANGE_SMARTRTB
       EXCHANGE_SMARTSTREAMTV
       EXCHANGE_SOVRN
       EXCHANGE_SPOTXCHANGE
       EXCHANGE_STROER
       EXCHANGE_TEADSTV
       EXCHANGE_TELARIA
       EXCHANGE_TVN
       EXCHANGE_UNITED
       EXCHANGE_YIELDLAB
       EXCHANGE_YIELDMO
       EXCHANGE_UNRULYX
       EXCHANGE_OPEN8
       EXCHANGE_TRITON
       EXCHANGE_TRIPLELIFT
       EXCHANGE_TABOOLA
       EXCHANGE_INMOBI
       EXCHANGE_SMAATO
       EXCHANGE_AJA
       EXCHANGE_SUPERSHIP
       EXCHANGE_NEXSTAR_DIGITAL
       EXCHANGE_WAZE
       EXCHANGE_SOUNDCAST
       EXCHANGE_SHARETHROUGH
       EXCHANGE_FYBER
       EXCHANGE_RED_FOR_PUBLISHERS
       EXCHANGE_MEDIANET
       EXCHANGE_TAPJOY
       EXCHANGE_VISTAR
       EXCHANGE_DAX
       EXCHANGE_JCD
       EXCHANGE_PLACE_EXCHANGE
       EXCHANGE_APPLOVIN
       EXCHANGE_CONNATIX
       EXCHANGE_RESET_DIGITAL
       EXCHANGE_HIVESTACK
       EXCHANGE_DRAX
       EXCHANGE_APPLOVIN_GBID
       EXCHANGE_FYBER_GBID
       EXCHANGE_UNITY_GBID
       EXCHANGE_CHARTBOOST_GBID
       EXCHANGE_ADMOST_GBID
       EXCHANGE_TOPON_GBID]},
     :dayAndTimeDetails
     {:dayOfWeek
      [DAY_OF_WEEK_UNSPECIFIED
       MONDAY
       TUESDAY
       WEDNESDAY
       THURSDAY
       FRIDAY
       SATURDAY
       SUNDAY],
      :startHour integer,
      :endHour integer,
      :timeZoneResolution
      [TIME_ZONE_RESOLUTION_UNSPECIFIED
       TIME_ZONE_RESOLUTION_END_USER
       TIME_ZONE_RESOLUTION_ADVERTISER]},
     :householdIncomeDetails
     {:householdIncome
      [HOUSEHOLD_INCOME_UNSPECIFIED
       HOUSEHOLD_INCOME_UNKNOWN
       HOUSEHOLD_INCOME_LOWER_50_PERCENT
       HOUSEHOLD_INCOME_TOP_41_TO_50_PERCENT
       HOUSEHOLD_INCOME_TOP_31_TO_40_PERCENT
       HOUSEHOLD_INCOME_TOP_21_TO_30_PERCENT
       HOUSEHOLD_INCOME_TOP_11_TO_20_PERCENT
       HOUSEHOLD_INCOME_TOP_10_PERCENT]},
     :authorizedSellerStatusDetails
     {:authorizedSellerStatus
      [AUTHORIZED_SELLER_STATUS_UNSPECIFIED
       AUTHORIZED_SELLER_STATUS_AUTHORIZED_DIRECT_SELLERS_ONLY
       AUTHORIZED_SELLER_STATUS_AUTHORIZED_AND_NON_PARTICIPATING_PUBLISHERS],
      :targetingOptionId string},
     :contentOutstreamPositionDetails
     {:contentOutstreamPosition
      [CONTENT_OUTSTREAM_POSITION_UNSPECIFIED
       CONTENT_OUTSTREAM_POSITION_UNKNOWN
       CONTENT_OUTSTREAM_POSITION_IN_ARTICLE
       CONTENT_OUTSTREAM_POSITION_IN_BANNER
       CONTENT_OUTSTREAM_POSITION_IN_FEED
       CONTENT_OUTSTREAM_POSITION_INTERSTITIAL],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :youtubeChannelDetails {:channelId string, :negative boolean},
     :userRewardedContentDetails
     {:targetingOptionId string,
      :userRewardedContent
      [USER_REWARDED_CONTENT_UNSPECIFIED
       USER_REWARDED_CONTENT_USER_REWARDED
       USER_REWARDED_CONTENT_NOT_USER_REWARDED]},
     :omidDetails
     {:omid [OMID_UNSPECIFIED OMID_FOR_MOBILE_DISPLAY_ADS]}}]}]}"
  [advertiserId BulkEditAssignedTargetingOptionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems:bulkEditAssignedTargetingOptions",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditAssignedTargetingOptionsRequest}))

(defn advertisers-lineItems-list
  "Lists line items in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, line items with `ENTITY_STATUS_ARCHIVED` will not be included in the results.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser to list line items for.

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) * `entityStatus` * `updateTime` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by line item fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * The `updateTime` field must use the `GREATER THAN OR EQUAL TO (>=)` or `LESS THAN OR EQUAL TO (<=)` operators. * All other fields must use the `EQUALS (=)` operator. Supported fields: * `campaignId` * `displayName` * `entityStatus` * `insertionOrderId` * `lineItemId` * `lineItemType` * `updateTime` (input in ISO 8601 format, or `YYYY-MM-DDTHH:MM:SSZ`) Examples: * All line items under an insertion order: `insertionOrderId=\"1234\"` * All `ENTITY_STATUS_ACTIVE` or `ENTITY_STATUS_PAUSED` and `LINE_ITEM_TYPE_DISPLAY_DEFAULT` line items under an advertiser: `(entityStatus=\"ENTITY_STATUS_ACTIVE\" OR entityStatus=\"ENTITY_STATUS_PAUSED\") AND lineItemType=\"LINE_ITEM_TYPE_DISPLAY_DEFAULT\"` * All line items with an update time less than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime<=\"2020-11-04T18:54:47Z\"` * All line items with an update time greater than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime>=\"2020-11-04T18:54:47Z\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-lineItems-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-lineItems-bulkListAssignedTargetingOptions
  "Lists assigned targeting options for multiple line items across targeting types.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line items belongs to.

optional:
lineItemIds <string> Required. The IDs of the line items to list assigned targeting options for.
pageSize <integer> Requested page size. The size must be an integer between `1` and `5000`. If unspecified, the default is `5000`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `lineItemId` (default) * `assignedTargetingOption.targetingType` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `targetingType desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR` on the same field. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `targetingType` * `inheritance` Examples: * `AssignedTargetingOption` resources of targeting type `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` or `TARGETING_TYPE_CHANNEL`: `targetingType=\"TARGETING_TYPE_PROXIMITY_LOCATION_LIST\" OR targetingType=\"TARGETING_TYPE_CHANNEL\"` * `AssignedTargetingOption` resources with inheritance status of `NOT_INHERITED` or `INHERITED_FROM_PARTNER`: `inheritance=\"NOT_INHERITED\" OR inheritance=\"INHERITED_FROM_PARTNER\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId]
    (advertisers-lineItems-bulkListAssignedTargetingOptions
      advertiserId
      nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems:bulkListAssignedTargetingOptions",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-lineItems-targetingTypes-assignedTargetingOptions-get
  "Gets a single targeting option assigned to a line item.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line item belongs to.
lineItemId <string> Required. The ID of the line item the assigned targeting option belongs to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_AUDIO_CONTENT_TYPE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_BUSINESS_CHAIN` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_CONTENT_DURATION` * `TARGETING_TYPE_CONTENT_GENRE` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_STREAM_TYPE` * `TARGETING_TYPE_DAY_AND_TIME` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_POI` * `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` * `TARGETING_TYPE_REGIONAL_LOCATION_LIST` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_VIEWABILITY` * `TARGETING_TYPE_YOUTUBE_CHANNEL` (only for `LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE` line items) * `TARGETING_TYPE_YOUTUBE_VIDEO` (only for `LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE` line items)
assignedTargetingOptionId <string> Required. An identifier unique to the targeting type in this line item that identifies the assigned targeting option being requested."
  [advertiserId lineItemId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :lineItemId lineItemId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-lineItems-targetingTypes-assignedTargetingOptions-list
  "Lists the targeting options assigned to a line item.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line item belongs to.
lineItemId <string> Required. The ID of the line item to list assigned targeting options for.
targetingType <string> Required. Identifies the type of assigned targeting options to list. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_AUDIO_CONTENT_TYPE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_BUSINESS_CHAIN` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_CONTENT_DURATION` * `TARGETING_TYPE_CONTENT_GENRE` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_STREAM_TYPE` * `TARGETING_TYPE_DAY_AND_TIME` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_POI` * `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` * `TARGETING_TYPE_REGIONAL_LOCATION_LIST` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_VIEWABILITY` * `TARGETING_TYPE_YOUTUBE_CHANNEL` (only for `LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE` line items) * `TARGETING_TYPE_YOUTUBE_VIDEO` (only for `LINE_ITEM_TYPE_YOUTUBE_AND_PARTNERS_VIDEO_SEQUENCE` line items)

optional:
pageSize <integer> Requested page size. Must be between `1` and `5000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `assignedTargetingOptionId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `assignedTargetingOptionId desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedTargetingOptionId` * `inheritance` Examples: * `AssignedTargetingOption` resources with ID 1 or 2: `assignedTargetingOptionId=\"1\" OR assignedTargetingOptionId=\"2\"` * `AssignedTargetingOption` resources with inheritance status of `NOT_INHERITED` or `INHERITED_FROM_PARTNER`: `inheritance=\"NOT_INHERITED\" OR inheritance=\"INHERITED_FROM_PARTNER\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId lineItemId targetingType]
    (advertisers-lineItems-targetingTypes-assignedTargetingOptions-list
      advertiserId
      lineItemId
      targetingType
      nil))
  ([advertiserId lineItemId targetingType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
       :uri-template-args
       {:advertiserId advertiserId,
        :lineItemId lineItemId,
        :targetingType targetingType},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-lineItems-targetingTypes-assignedTargetingOptions-create
  "Assigns a targeting option to a line item. Returns the assigned targeting option if successful. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * lineItems.bulkEditAssignedTargetingOptions * lineItems.bulkUpdate * lineItems.patch * DeleteLineItemAssignedTargetingOption YouTube & Partners line items cannot be created or updated using the API.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line item belongs to.
lineItemId <string> Required. The ID of the line item the assigned targeting option will belong to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_AUDIO_CONTENT_TYPE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_BUSINESS_CHAIN` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_CONTENT_DURATION` * `TARGETING_TYPE_CONTENT_GENRE` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_STREAM_TYPE` * `TARGETING_TYPE_DAY_AND_TIME` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_POI` * `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` * `TARGETING_TYPE_REGIONAL_LOCATION_LIST` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_VIEWABILITY`
AssignedTargetingOption:
{:contentGenreDetails
 {:targetingOptionId string, :displayName string, :negative boolean},
 :negativeKeywordListDetails {:negativeKeywordListId string},
 :parentalStatusDetails
 {:parentalStatus
  [PARENTAL_STATUS_UNSPECIFIED
   PARENTAL_STATUS_PARENT
   PARENTAL_STATUS_NOT_A_PARENT
   PARENTAL_STATUS_UNKNOWN]},
 :geoRegionDetails
 {:displayName string,
  :targetingOptionId string,
  :geoRegionType
  [GEO_REGION_TYPE_UNKNOWN
   GEO_REGION_TYPE_OTHER
   GEO_REGION_TYPE_COUNTRY
   GEO_REGION_TYPE_REGION
   GEO_REGION_TYPE_TERRITORY
   GEO_REGION_TYPE_PROVINCE
   GEO_REGION_TYPE_STATE
   GEO_REGION_TYPE_PREFECTURE
   GEO_REGION_TYPE_GOVERNORATE
   GEO_REGION_TYPE_CANTON
   GEO_REGION_TYPE_UNION_TERRITORY
   GEO_REGION_TYPE_AUTONOMOUS_COMMUNITY
   GEO_REGION_TYPE_DMA_REGION
   GEO_REGION_TYPE_METRO
   GEO_REGION_TYPE_CONGRESSIONAL_DISTRICT
   GEO_REGION_TYPE_COUNTY
   GEO_REGION_TYPE_MUNICIPALITY
   GEO_REGION_TYPE_CITY
   GEO_REGION_TYPE_POSTAL_CODE
   GEO_REGION_TYPE_DEPARTMENT
   GEO_REGION_TYPE_AIRPORT
   GEO_REGION_TYPE_TV_REGION
   GEO_REGION_TYPE_OKRUG
   GEO_REGION_TYPE_BOROUGH
   GEO_REGION_TYPE_CITY_REGION
   GEO_REGION_TYPE_ARRONDISSEMENT
   GEO_REGION_TYPE_NEIGHBORHOOD
   GEO_REGION_TYPE_UNIVERSITY
   GEO_REGION_TYPE_DISTRICT],
  :negative boolean},
 :regionalLocationListDetails
 {:regionalLocationListId string, :negative boolean},
 :browserDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inventorySourceGroupDetails {:inventorySourceGroupId string},
 :nativeContentPositionDetails
 {:contentPosition
  [NATIVE_CONTENT_POSITION_UNSPECIFIED
   NATIVE_CONTENT_POSITION_UNKNOWN
   NATIVE_CONTENT_POSITION_IN_ARTICLE
   NATIVE_CONTENT_POSITION_IN_FEED
   NATIVE_CONTENT_POSITION_PERIPHERAL
   NATIVE_CONTENT_POSITION_RECOMMENDATION]},
 :assignedTargetingOptionId string,
 :operatingSystemDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :appCategoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :contentInstreamPositionDetails
 {:contentInstreamPosition
  [CONTENT_INSTREAM_POSITION_UNSPECIFIED
   CONTENT_INSTREAM_POSITION_PRE_ROLL
   CONTENT_INSTREAM_POSITION_MID_ROLL
   CONTENT_INSTREAM_POSITION_POST_ROLL
   CONTENT_INSTREAM_POSITION_UNKNOWN],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :inventorySourceDetails {:inventorySourceId string},
 :audioContentTypeDetails
 {:audioContentType
  [AUDIO_CONTENT_TYPE_UNSPECIFIED
   AUDIO_CONTENT_TYPE_UNKNOWN
   AUDIO_CONTENT_TYPE_MUSIC
   AUDIO_CONTENT_TYPE_BROADCAST
   AUDIO_CONTENT_TYPE_PODCAST]},
 :thirdPartyVerifierDetails
 {:adloox
  {:excludedAdlooxCategories
   [[ADLOOX_UNSPECIFIED
     ADULT_CONTENT_HARD
     ADULT_CONTENT_SOFT
     ILLEGAL_CONTENT
     BORDERLINE_CONTENT
     DISCRIMINATORY_CONTENT
     VIOLENT_CONTENT_WEAPONS
     LOW_VIEWABILITY_DOMAINS
     FRAUD]]},
  :doubleVerify
  {:brandSafetyCategories
   {:avoidUnknownBrandSafetyCategory boolean,
    :avoidedHighSeverityCategories
    [[HIGHER_SEVERITY_UNSPECIFIED
      ADULT_CONTENT_PORNOGRAPHY
      COPYRIGHT_INFRINGEMENT
      SUBSTANCE_ABUSE
      GRAPHIC_VIOLENCE_WEAPONS
      HATE_PROFANITY
      CRIMINAL_SKILLS
      NUISANCE_INCENTIVIZED_MALWARE_CLUTTER]],
    :avoidedMediumSeverityCategories
    [[MEDIUM_SEVERITY_UNSPECIFIED
      AD_SERVERS
      ADULT_CONTENT_SWIMSUIT
      ALTERNATIVE_LIFESTYLES
      CELEBRITY_GOSSIP
      GAMBLING
      OCCULT
      SEX_EDUCATION
      DISASTER_AVIATION
      DISASTER_MAN_MADE
      DISASTER_NATURAL
      DISASTER_TERRORIST_EVENTS
      DISASTER_VEHICLE
      ALCOHOL
      SMOKING
      NEGATIVE_NEWS_FINANCIAL
      NON_ENGLISH
      PARKING_PAGE
      UNMODERATED_UGC
      INFLAMMATORY_POLITICS_AND_NEWS
      NEGATIVE_NEWS_PHARMACEUTICAL]]},
   :avoidedAgeRatings
   [[AGE_RATING_UNSPECIFIED
     APP_AGE_RATE_UNKNOWN
     APP_AGE_RATE_4_PLUS
     APP_AGE_RATE_9_PLUS
     APP_AGE_RATE_12_PLUS
     APP_AGE_RATE_17_PLUS
     APP_AGE_RATE_18_PLUS]],
   :appStarRating
   {:avoidedStarRating
    [APP_STAR_RATE_UNSPECIFIED
     APP_STAR_RATE_1_POINT_5_LESS
     APP_STAR_RATE_2_LESS
     APP_STAR_RATE_2_POINT_5_LESS
     APP_STAR_RATE_3_LESS
     APP_STAR_RATE_3_POINT_5_LESS
     APP_STAR_RATE_4_LESS
     APP_STAR_RATE_4_POINT_5_LESS],
    :avoidInsufficientStarRating boolean},
   :displayViewability
   {:iab
    [IAB_VIEWED_RATE_UNSPECIFIED
     IAB_VIEWED_RATE_80_PERCENT_HIGHER
     IAB_VIEWED_RATE_75_PERCENT_HIGHER
     IAB_VIEWED_RATE_70_PERCENT_HIGHER
     IAB_VIEWED_RATE_65_PERCENT_HIGHER
     IAB_VIEWED_RATE_60_PERCENT_HIGHER
     IAB_VIEWED_RATE_55_PERCENT_HIGHER
     IAB_VIEWED_RATE_50_PERCENT_HIGHER
     IAB_VIEWED_RATE_40_PERCENT_HIGHER
     IAB_VIEWED_RATE_30_PERCENT_HIGHER],
    :viewableDuring
    [AVERAGE_VIEW_DURATION_UNSPECIFIED
     AVERAGE_VIEW_DURATION_5_SEC
     AVERAGE_VIEW_DURATION_10_SEC
     AVERAGE_VIEW_DURATION_15_SEC]},
   :videoViewability
   {:videoIab
    [VIDEO_IAB_UNSPECIFIED
     IAB_VIEWABILITY_80_PERCENT_HIGHER
     IAB_VIEWABILITY_75_PERCENT_HIGHER
     IAB_VIEWABILITY_70_PERCENT_HIGHER
     IAB_VIEWABILITY_65_PERCENT_HIHGER
     IAB_VIEWABILITY_60_PERCENT_HIGHER
     IAB_VIEWABILITY_55_PERCENT_HIHGER
     IAB_VIEWABILITY_50_PERCENT_HIGHER
     IAB_VIEWABILITY_40_PERCENT_HIHGER
     IAB_VIEWABILITY_30_PERCENT_HIHGER],
    :videoViewableRate
    [VIDEO_VIEWABLE_RATE_UNSPECIFIED
     VIEWED_PERFORMANCE_40_PERCENT_HIGHER
     VIEWED_PERFORMANCE_35_PERCENT_HIGHER
     VIEWED_PERFORMANCE_30_PERCENT_HIGHER
     VIEWED_PERFORMANCE_25_PERCENT_HIGHER
     VIEWED_PERFORMANCE_20_PERCENT_HIGHER
     VIEWED_PERFORMANCE_10_PERCENT_HIGHER],
    :playerImpressionRate
    [PLAYER_SIZE_400X300_UNSPECIFIED
     PLAYER_SIZE_400X300_95
     PLAYER_SIZE_400X300_70
     PLAYER_SIZE_400X300_25
     PLAYER_SIZE_400X300_5]},
   :fraudInvalidTraffic
   {:avoidedFraudOption
    [FRAUD_UNSPECIFIED
     AD_IMPRESSION_FRAUD_100
     AD_IMPRESSION_FRAUD_50
     AD_IMPRESSION_FRAUD_25
     AD_IMPRESSION_FRAUD_10
     AD_IMPRESSION_FRAUD_8
     AD_IMPRESSION_FRAUD_6
     AD_IMPRESSION_FRAUD_4
     AD_IMPRESSION_FRAUD_2],
    :avoidInsufficientOption boolean},
   :customSegmentId string},
  :integralAdScience
  {:excludedIllegalDownloadsRisk
   [ILLEGAL_DOWNLOADS_UNSPECIFIED
    ILLEGAL_DOWNLOADS_HR
    ILLEGAL_DOWNLOADS_HMR],
   :excludedOffensiveLanguageRisk
   [OFFENSIVE_LANGUAGE_UNSPECIFIED
    OFFENSIVE_LANGUAGE_HR
    OFFENSIVE_LANGUAGE_HMR],
   :excludeUnrateable boolean,
   :excludedDrugsRisk [DRUGS_UNSPECIFIED DRUGS_HR DRUGS_HMR],
   :excludedGamblingRisk
   [GAMBLING_UNSPECIFIED GAMBLING_HR GAMBLING_HMR],
   :excludedAdultRisk [ADULT_UNSPECIFIED ADULT_HR ADULT_HMR],
   :displayViewability
   [PERFORMANCE_VIEWABILITY_UNSPECIFIED
    PERFORMANCE_VIEWABILITY_40
    PERFORMANCE_VIEWABILITY_50
    PERFORMANCE_VIEWABILITY_60
    PERFORMANCE_VIEWABILITY_70],
   :excludedViolenceRisk
   [VIOLENCE_UNSPECIFIED VIOLENCE_HR VIOLENCE_HMR],
   :traqScoreOption
   [TRAQ_UNSPECIFIED
    TRAQ_250
    TRAQ_500
    TRAQ_600
    TRAQ_700
    TRAQ_750
    TRAQ_875
    TRAQ_1000],
   :excludedHateSpeechRisk
   [HATE_SPEECH_UNSPECIFIED HATE_SPEECH_HR HATE_SPEECH_HMR],
   :videoViewability
   [VIDEO_VIEWABILITY_UNSPECIFIED
    VIDEO_VIEWABILITY_40
    VIDEO_VIEWABILITY_50
    VIDEO_VIEWABILITY_60
    VIDEO_VIEWABILITY_70],
   :excludedAdFraudRisk
   [SUSPICIOUS_ACTIVITY_UNSPECIFIED
    SUSPICIOUS_ACTIVITY_HR
    SUSPICIOUS_ACTIVITY_HMR],
   :customSegmentId [string],
   :excludedAlcoholRisk [ALCOHOL_UNSPECIFIED ALCOHOL_HR ALCOHOL_HMR]}},
 :name string,
 :onScreenPositionDetails
 {:targetingOptionId string,
  :onScreenPosition
  [ON_SCREEN_POSITION_UNSPECIFIED
   ON_SCREEN_POSITION_UNKNOWN
   ON_SCREEN_POSITION_ABOVE_THE_FOLD
   ON_SCREEN_POSITION_BELOW_THE_FOLD],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :videoPlayerSizeDetails
 {:videoPlayerSize
  [VIDEO_PLAYER_SIZE_UNSPECIFIED
   VIDEO_PLAYER_SIZE_SMALL
   VIDEO_PLAYER_SIZE_LARGE
   VIDEO_PLAYER_SIZE_HD
   VIDEO_PLAYER_SIZE_UNKNOWN]},
 :carrierAndIspDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :proximityLocationListDetails
 {:proximityLocationListId string,
  :proximityRadius number,
  :proximityRadiusUnit
  [PROXIMITY_RADIUS_UNIT_UNSPECIFIED
   PROXIMITY_RADIUS_UNIT_MILES
   PROXIMITY_RADIUS_UNIT_KILOMETERS]},
 :contentStreamTypeDetails
 {:targetingOptionId string,
  :contentStreamType
  [CONTENT_STREAM_TYPE_UNSPECIFIED
   CONTENT_LIVE_STREAM
   CONTENT_ON_DEMAND]},
 :digitalContentLabelExclusionDetails
 {:excludedContentRatingTier
  [CONTENT_RATING_TIER_UNSPECIFIED
   CONTENT_RATING_TIER_UNRATED
   CONTENT_RATING_TIER_GENERAL
   CONTENT_RATING_TIER_PARENTAL_GUIDANCE
   CONTENT_RATING_TIER_TEENS
   CONTENT_RATING_TIER_MATURE
   CONTENT_RATING_TIER_FAMILIES]},
 :ageRangeDetails
 {:ageRange
  [AGE_RANGE_UNSPECIFIED
   AGE_RANGE_18_24
   AGE_RANGE_25_34
   AGE_RANGE_35_44
   AGE_RANGE_45_54
   AGE_RANGE_55_64
   AGE_RANGE_65_PLUS
   AGE_RANGE_UNKNOWN
   AGE_RANGE_18_20
   AGE_RANGE_21_24
   AGE_RANGE_25_29
   AGE_RANGE_30_34
   AGE_RANGE_35_39
   AGE_RANGE_40_44
   AGE_RANGE_45_49
   AGE_RANGE_50_54
   AGE_RANGE_55_59
   AGE_RANGE_60_64]},
 :deviceMakeModelDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :categoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inheritance
 [INHERITANCE_UNSPECIFIED
  NOT_INHERITED
  INHERITED_FROM_PARTNER
  INHERITED_FROM_ADVERTISER],
 :businessChainDetails
 {:displayName string,
  :targetingOptionId string,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :audienceGroupDetails
 {:includedFirstAndThirdPartyAudienceGroups
  [{:settings
    [{:firstAndThirdPartyAudienceId string,
      :recency
      [RECENCY_NO_LIMIT
       RECENCY_1_MINUTE
       RECENCY_5_MINUTES
       RECENCY_10_MINUTES
       RECENCY_15_MINUTES
       RECENCY_30_MINUTES
       RECENCY_1_HOUR
       RECENCY_2_HOURS
       RECENCY_3_HOURS
       RECENCY_6_HOURS
       RECENCY_12_HOURS
       RECENCY_1_DAY
       RECENCY_2_DAYS
       RECENCY_3_DAYS
       RECENCY_5_DAYS
       RECENCY_7_DAYS
       RECENCY_10_DAYS
       RECENCY_14_DAYS
       RECENCY_15_DAYS
       RECENCY_21_DAYS
       RECENCY_28_DAYS
       RECENCY_30_DAYS
       RECENCY_40_DAYS
       RECENCY_45_DAYS
       RECENCY_60_DAYS
       RECENCY_90_DAYS
       RECENCY_120_DAYS
       RECENCY_180_DAYS
       RECENCY_270_DAYS
       RECENCY_365_DAYS]}]}],
  :includedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]},
  :includedCustomListGroup {:settings [{:customListId string}]},
  :includedCombinedAudienceGroup
  {:settings [{:combinedAudienceId string}]},
  :excludedFirstAndThirdPartyAudienceGroup
  {:settings
   [{:firstAndThirdPartyAudienceId string,
     :recency
     [RECENCY_NO_LIMIT
      RECENCY_1_MINUTE
      RECENCY_5_MINUTES
      RECENCY_10_MINUTES
      RECENCY_15_MINUTES
      RECENCY_30_MINUTES
      RECENCY_1_HOUR
      RECENCY_2_HOURS
      RECENCY_3_HOURS
      RECENCY_6_HOURS
      RECENCY_12_HOURS
      RECENCY_1_DAY
      RECENCY_2_DAYS
      RECENCY_3_DAYS
      RECENCY_5_DAYS
      RECENCY_7_DAYS
      RECENCY_10_DAYS
      RECENCY_14_DAYS
      RECENCY_15_DAYS
      RECENCY_21_DAYS
      RECENCY_28_DAYS
      RECENCY_30_DAYS
      RECENCY_40_DAYS
      RECENCY_45_DAYS
      RECENCY_60_DAYS
      RECENCY_90_DAYS
      RECENCY_120_DAYS
      RECENCY_180_DAYS
      RECENCY_270_DAYS
      RECENCY_365_DAYS]}]},
  :excludedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]}},
 :channelDetails {:channelId string, :negative boolean},
 :contentDurationDetails
 {:targetingOptionId string,
  :contentDuration
  [CONTENT_DURATION_UNSPECIFIED
   CONTENT_DURATION_UNKNOWN
   CONTENT_DURATION_0_TO_1_MIN
   CONTENT_DURATION_1_TO_5_MIN
   CONTENT_DURATION_5_TO_15_MIN
   CONTENT_DURATION_15_TO_30_MIN
   CONTENT_DURATION_30_TO_60_MIN
   CONTENT_DURATION_OVER_60_MIN]},
 :targetingType
 [TARGETING_TYPE_UNSPECIFIED
  TARGETING_TYPE_CHANNEL
  TARGETING_TYPE_APP_CATEGORY
  TARGETING_TYPE_APP
  TARGETING_TYPE_URL
  TARGETING_TYPE_DAY_AND_TIME
  TARGETING_TYPE_AGE_RANGE
  TARGETING_TYPE_REGIONAL_LOCATION_LIST
  TARGETING_TYPE_PROXIMITY_LOCATION_LIST
  TARGETING_TYPE_GENDER
  TARGETING_TYPE_VIDEO_PLAYER_SIZE
  TARGETING_TYPE_USER_REWARDED_CONTENT
  TARGETING_TYPE_PARENTAL_STATUS
  TARGETING_TYPE_CONTENT_INSTREAM_POSITION
  TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
  TARGETING_TYPE_DEVICE_TYPE
  TARGETING_TYPE_AUDIENCE_GROUP
  TARGETING_TYPE_BROWSER
  TARGETING_TYPE_HOUSEHOLD_INCOME
  TARGETING_TYPE_ON_SCREEN_POSITION
  TARGETING_TYPE_THIRD_PARTY_VERIFIER
  TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
  TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
  TARGETING_TYPE_ENVIRONMENT
  TARGETING_TYPE_CARRIER_AND_ISP
  TARGETING_TYPE_OPERATING_SYSTEM
  TARGETING_TYPE_DEVICE_MAKE_MODEL
  TARGETING_TYPE_KEYWORD
  TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
  TARGETING_TYPE_VIEWABILITY
  TARGETING_TYPE_CATEGORY
  TARGETING_TYPE_INVENTORY_SOURCE
  TARGETING_TYPE_LANGUAGE
  TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
  TARGETING_TYPE_GEO_REGION
  TARGETING_TYPE_INVENTORY_SOURCE_GROUP
  TARGETING_TYPE_EXCHANGE
  TARGETING_TYPE_SUB_EXCHANGE
  TARGETING_TYPE_POI
  TARGETING_TYPE_BUSINESS_CHAIN
  TARGETING_TYPE_CONTENT_DURATION
  TARGETING_TYPE_CONTENT_STREAM_TYPE
  TARGETING_TYPE_NATIVE_CONTENT_POSITION
  TARGETING_TYPE_OMID
  TARGETING_TYPE_AUDIO_CONTENT_TYPE
  TARGETING_TYPE_CONTENT_GENRE
  TARGETING_TYPE_YOUTUBE_VIDEO
  TARGETING_TYPE_YOUTUBE_CHANNEL
  TARGETING_TYPE_SESSION_POSITION],
 :environmentDetails
 {:environment
  [ENVIRONMENT_UNSPECIFIED
   ENVIRONMENT_WEB_OPTIMIZED
   ENVIRONMENT_WEB_NOT_OPTIMIZED
   ENVIRONMENT_APP]},
 :poiDetails
 {:displayName string,
  :targetingOptionId string,
  :latitude number,
  :longitude number,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :sensitiveCategoryExclusionDetails
 {:excludedSensitiveCategory
  [SENSITIVE_CATEGORY_UNSPECIFIED
   SENSITIVE_CATEGORY_ADULT
   SENSITIVE_CATEGORY_DEROGATORY
   SENSITIVE_CATEGORY_DOWNLOADS_SHARING
   SENSITIVE_CATEGORY_WEAPONS
   SENSITIVE_CATEGORY_GAMBLING
   SENSITIVE_CATEGORY_VIOLENCE
   SENSITIVE_CATEGORY_SUGGESTIVE
   SENSITIVE_CATEGORY_PROFANITY
   SENSITIVE_CATEGORY_ALCOHOL
   SENSITIVE_CATEGORY_DRUGS
   SENSITIVE_CATEGORY_TOBACCO
   SENSITIVE_CATEGORY_POLITICS
   SENSITIVE_CATEGORY_RELIGION
   SENSITIVE_CATEGORY_TRAGEDY
   SENSITIVE_CATEGORY_TRANSPORTATION_ACCIDENTS
   SENSITIVE_CATEGORY_SENSITIVE_SOCIAL_ISSUES
   SENSITIVE_CATEGORY_SHOCKING
   SENSITIVE_CATEGORY_EMBEDDED_VIDEO
   SENSITIVE_CATEGORY_LIVE_STREAMING_VIDEO]},
 :youtubeVideoDetails {:videoId string, :negative boolean},
 :sessionPositionDetails
 {:sessionPosition
  [SESSION_POSITION_UNSPECIFIED SESSION_POSITION_FIRST_IMPRESSION]},
 :deviceTypeDetails
 {:deviceType
  [DEVICE_TYPE_UNSPECIFIED
   DEVICE_TYPE_COMPUTER
   DEVICE_TYPE_CONNECTED_TV
   DEVICE_TYPE_SMART_PHONE
   DEVICE_TYPE_TABLET],
  :youtubeAndPartnersBidMultiplier number},
 :appDetails
 {:appId string,
  :displayName string,
  :negative boolean,
  :appPlatform
  [APP_PLATFORM_UNSPECIFIED
   APP_PLATFORM_IOS
   APP_PLATFORM_ANDROID
   APP_PLATFORM_ROKU
   APP_PLATFORM_AMAZON_FIRETV
   APP_PLATFORM_PLAYSTATION
   APP_PLATFORM_APPLE_TV
   APP_PLATFORM_XBOX
   APP_PLATFORM_SAMSUNG_TV
   APP_PLATFORM_ANDROID_TV
   APP_PLATFORM_GENERIC_CTV
   APP_PLATFORM_LG_TV
   APP_PLATFORM_VIZIO_TV]},
 :subExchangeDetails {:targetingOptionId string},
 :genderDetails
 {:gender
  [GENDER_UNSPECIFIED GENDER_MALE GENDER_FEMALE GENDER_UNKNOWN]},
 :languageDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :viewabilityDetails
 {:viewability
  [VIEWABILITY_UNSPECIFIED
   VIEWABILITY_10_PERCENT_OR_MORE
   VIEWABILITY_20_PERCENT_OR_MORE
   VIEWABILITY_30_PERCENT_OR_MORE
   VIEWABILITY_40_PERCENT_OR_MORE
   VIEWABILITY_50_PERCENT_OR_MORE
   VIEWABILITY_60_PERCENT_OR_MORE
   VIEWABILITY_70_PERCENT_OR_MORE
   VIEWABILITY_80_PERCENT_OR_MORE
   VIEWABILITY_90_PERCENT_OR_MORE]},
 :assignedTargetingOptionIdAlias string,
 :keywordDetails {:keyword string, :negative boolean},
 :urlDetails {:url string, :negative boolean},
 :exchangeDetails
 {:exchange
  [EXCHANGE_UNSPECIFIED
   EXCHANGE_GOOGLE_AD_MANAGER
   EXCHANGE_APPNEXUS
   EXCHANGE_BRIGHTROLL
   EXCHANGE_ADFORM
   EXCHANGE_ADMETA
   EXCHANGE_ADMIXER
   EXCHANGE_ADSMOGO
   EXCHANGE_ADSWIZZ
   EXCHANGE_BIDSWITCH
   EXCHANGE_BRIGHTROLL_DISPLAY
   EXCHANGE_CADREON
   EXCHANGE_DAILYMOTION
   EXCHANGE_FIVE
   EXCHANGE_FLUCT
   EXCHANGE_FREEWHEEL
   EXCHANGE_GENIEE
   EXCHANGE_GUMGUM
   EXCHANGE_IMOBILE
   EXCHANGE_IBILLBOARD
   EXCHANGE_IMPROVE_DIGITAL
   EXCHANGE_INDEX
   EXCHANGE_KARGO
   EXCHANGE_MICROAD
   EXCHANGE_MOPUB
   EXCHANGE_NEND
   EXCHANGE_ONE_BY_AOL_DISPLAY
   EXCHANGE_ONE_BY_AOL_MOBILE
   EXCHANGE_ONE_BY_AOL_VIDEO
   EXCHANGE_OOYALA
   EXCHANGE_OPENX
   EXCHANGE_PERMODO
   EXCHANGE_PLATFORMONE
   EXCHANGE_PLATFORMID
   EXCHANGE_PUBMATIC
   EXCHANGE_PULSEPOINT
   EXCHANGE_REVENUEMAX
   EXCHANGE_RUBICON
   EXCHANGE_SMARTCLIP
   EXCHANGE_SMARTRTB
   EXCHANGE_SMARTSTREAMTV
   EXCHANGE_SOVRN
   EXCHANGE_SPOTXCHANGE
   EXCHANGE_STROER
   EXCHANGE_TEADSTV
   EXCHANGE_TELARIA
   EXCHANGE_TVN
   EXCHANGE_UNITED
   EXCHANGE_YIELDLAB
   EXCHANGE_YIELDMO
   EXCHANGE_UNRULYX
   EXCHANGE_OPEN8
   EXCHANGE_TRITON
   EXCHANGE_TRIPLELIFT
   EXCHANGE_TABOOLA
   EXCHANGE_INMOBI
   EXCHANGE_SMAATO
   EXCHANGE_AJA
   EXCHANGE_SUPERSHIP
   EXCHANGE_NEXSTAR_DIGITAL
   EXCHANGE_WAZE
   EXCHANGE_SOUNDCAST
   EXCHANGE_SHARETHROUGH
   EXCHANGE_FYBER
   EXCHANGE_RED_FOR_PUBLISHERS
   EXCHANGE_MEDIANET
   EXCHANGE_TAPJOY
   EXCHANGE_VISTAR
   EXCHANGE_DAX
   EXCHANGE_JCD
   EXCHANGE_PLACE_EXCHANGE
   EXCHANGE_APPLOVIN
   EXCHANGE_CONNATIX
   EXCHANGE_RESET_DIGITAL
   EXCHANGE_HIVESTACK
   EXCHANGE_DRAX
   EXCHANGE_APPLOVIN_GBID
   EXCHANGE_FYBER_GBID
   EXCHANGE_UNITY_GBID
   EXCHANGE_CHARTBOOST_GBID
   EXCHANGE_ADMOST_GBID
   EXCHANGE_TOPON_GBID]},
 :dayAndTimeDetails
 {:dayOfWeek
  [DAY_OF_WEEK_UNSPECIFIED
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY],
  :startHour integer,
  :endHour integer,
  :timeZoneResolution
  [TIME_ZONE_RESOLUTION_UNSPECIFIED
   TIME_ZONE_RESOLUTION_END_USER
   TIME_ZONE_RESOLUTION_ADVERTISER]},
 :householdIncomeDetails
 {:householdIncome
  [HOUSEHOLD_INCOME_UNSPECIFIED
   HOUSEHOLD_INCOME_UNKNOWN
   HOUSEHOLD_INCOME_LOWER_50_PERCENT
   HOUSEHOLD_INCOME_TOP_41_TO_50_PERCENT
   HOUSEHOLD_INCOME_TOP_31_TO_40_PERCENT
   HOUSEHOLD_INCOME_TOP_21_TO_30_PERCENT
   HOUSEHOLD_INCOME_TOP_11_TO_20_PERCENT
   HOUSEHOLD_INCOME_TOP_10_PERCENT]},
 :authorizedSellerStatusDetails
 {:authorizedSellerStatus
  [AUTHORIZED_SELLER_STATUS_UNSPECIFIED
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_DIRECT_SELLERS_ONLY
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_AND_NON_PARTICIPATING_PUBLISHERS],
  :targetingOptionId string},
 :contentOutstreamPositionDetails
 {:contentOutstreamPosition
  [CONTENT_OUTSTREAM_POSITION_UNSPECIFIED
   CONTENT_OUTSTREAM_POSITION_UNKNOWN
   CONTENT_OUTSTREAM_POSITION_IN_ARTICLE
   CONTENT_OUTSTREAM_POSITION_IN_BANNER
   CONTENT_OUTSTREAM_POSITION_IN_FEED
   CONTENT_OUTSTREAM_POSITION_INTERSTITIAL],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :youtubeChannelDetails {:channelId string, :negative boolean},
 :userRewardedContentDetails
 {:targetingOptionId string,
  :userRewardedContent
  [USER_REWARDED_CONTENT_UNSPECIFIED
   USER_REWARDED_CONTENT_USER_REWARDED
   USER_REWARDED_CONTENT_NOT_USER_REWARDED]},
 :omidDetails {:omid [OMID_UNSPECIFIED OMID_FOR_MOBILE_DISPLAY_ADS]}}"
  [advertiserId lineItemId targetingType AssignedTargetingOption]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
     :uri-template-args
     {:advertiserId advertiserId,
      :lineItemId lineItemId,
      :targetingType targetingType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body AssignedTargetingOption}))

(defn advertisers-lineItems-targetingTypes-assignedTargetingOptions-delete
  "Deletes an assigned targeting option from a line item. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * lineItems.bulkEditAssignedTargetingOptions * lineItems.bulkUpdate * lineItems.patch * CreateLineItemAssignedTargetingOption YouTube & Partners line items cannot be created or updated using the API.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line item belongs to.
lineItemId <string> Required. The ID of the line item the assigned targeting option belongs to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_AUDIO_CONTENT_TYPE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_BUSINESS_CHAIN` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_CONTENT_DURATION` * `TARGETING_TYPE_CONTENT_GENRE` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_STREAM_TYPE` * `TARGETING_TYPE_DAY_AND_TIME` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_POI` * `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` * `TARGETING_TYPE_REGIONAL_LOCATION_LIST` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_VIEWABILITY`
assignedTargetingOptionId <string> Required. The ID of the assigned targeting option to delete."
  [advertiserId lineItemId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :lineItemId lineItemId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-campaigns-listAssignedTargetingOptions
  "Lists assigned targeting options of a campaign across targeting types.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the campaign belongs to.
campaignId <string> Required. The ID of the campaign to list assigned targeting options for.

optional:
pageSize <integer> Requested page size. The size must be an integer between `1` and `5000`. If unspecified, the default is `5000`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `targetingType` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `targetingType desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the `OR` logical operator. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `targetingType` * `inheritance` Examples: * `AssignedTargetingOption` resources of targeting type `TARGETING_TYPE_LANGUAGE` or `TARGETING_TYPE_GENDER`: `targetingType=\"TARGETING_TYPE_LANGUAGE\" OR targetingType=\"TARGETING_TYPE_GENDER\"` * `AssignedTargetingOption` resources with inheritance status of `NOT_INHERITED` or `INHERITED_FROM_PARTNER`: `inheritance=\"NOT_INHERITED\" OR inheritance=\"INHERITED_FROM_PARTNER\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId campaignId]
    (advertisers-campaigns-listAssignedTargetingOptions
      advertiserId
      campaignId
      nil))
  ([advertiserId campaignId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns/{+campaignId}:listAssignedTargetingOptions",
       :uri-template-args
       {:advertiserId advertiserId, :campaignId campaignId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-campaigns-get
  "Gets a campaign.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this campaign belongs to.
campaignId <string> Required. The ID of the campaign to fetch."
  [advertiserId campaignId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns/{+campaignId}",
     :uri-template-args
     {:advertiserId advertiserId, :campaignId campaignId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video"
      "https://www.googleapis.com/auth/display-video-mediaplanning"]}))

(defn advertisers-campaigns-list
  "Lists campaigns in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, campaigns with `ENTITY_STATUS_ARCHIVED` will not be included in the results.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser to list campaigns for.

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) * `entityStatus` * `updateTime` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by campaign fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * The `updateTime` field must use the `GREATER THAN OR EQUAL TO (>=)` or `LESS THAN OR EQUAL TO (<=)` operators. * All other fields must use the `EQUALS (=)` operator. Supported fields: * `campaignId` * `displayName` * `entityStatus` * `updateTime` (input in ISO 8601 format, or `YYYY-MM-DDTHH:MM:SSZ`) Examples: * All `ENTITY_STATUS_ACTIVE` or `ENTITY_STATUS_PAUSED` campaigns under an advertiser: `(entityStatus=\"ENTITY_STATUS_ACTIVE\" OR entityStatus=\"ENTITY_STATUS_PAUSED\")` * All campaigns with an update time less than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime<=\"2020-11-04T18:54:47Z\"` * All campaigns with an update time greater than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime>=\"2020-11-04T18:54:47Z\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-campaigns-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/display-video"
        "https://www.googleapis.com/auth/display-video-mediaplanning"]})))

(defn advertisers-campaigns-create
  "Creates a new campaign. Returns the newly created campaign if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the campaign belongs to.
Campaign:
{:displayName string,
 :name string,
 :campaignGoal
 {:campaignGoalType
  [CAMPAIGN_GOAL_TYPE_UNSPECIFIED
   CAMPAIGN_GOAL_TYPE_APP_INSTALL
   CAMPAIGN_GOAL_TYPE_BRAND_AWARENESS
   CAMPAIGN_GOAL_TYPE_OFFLINE_ACTION
   CAMPAIGN_GOAL_TYPE_ONLINE_ACTION],
  :performanceGoal
  {:performanceGoalType
   [PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    PERFORMANCE_GOAL_TYPE_CPM
    PERFORMANCE_GOAL_TYPE_CPC
    PERFORMANCE_GOAL_TYPE_CPA
    PERFORMANCE_GOAL_TYPE_CTR
    PERFORMANCE_GOAL_TYPE_VIEWABILITY
    PERFORMANCE_GOAL_TYPE_CPIAVC
    PERFORMANCE_GOAL_TYPE_CPE
    PERFORMANCE_GOAL_TYPE_CLICK_CVR
    PERFORMANCE_GOAL_TYPE_IMPRESSION_CVR
    PERFORMANCE_GOAL_TYPE_VCPM
    PERFORMANCE_GOAL_TYPE_VTR
    PERFORMANCE_GOAL_TYPE_AUDIO_COMPLETION_RATE
    PERFORMANCE_GOAL_TYPE_VIDEO_COMPLETION_RATE
    PERFORMANCE_GOAL_TYPE_OTHER],
   :performanceGoalAmountMicros string,
   :performanceGoalPercentageMicros string,
   :performanceGoalString string}},
 :campaignId string,
 :campaignBudgets
 [{:dateRange
   {:startDate {:year integer, :month integer, :day integer},
    :endDate {:year integer, :month integer, :day integer}},
   :budgetUnit
   [BUDGET_UNIT_UNSPECIFIED
    BUDGET_UNIT_CURRENCY
    BUDGET_UNIT_IMPRESSIONS],
   :displayName string,
   :prismaConfig
   {:prismaType
    [PRISMA_TYPE_UNSPECIFIED
     PRISMA_TYPE_DISPLAY
     PRISMA_TYPE_SEARCH
     PRISMA_TYPE_VIDEO
     PRISMA_TYPE_AUDIO
     PRISMA_TYPE_SOCIAL
     PRISMA_TYPE_FEE],
    :prismaCpeCode
    {:prismaClientCode string,
     :prismaProductCode string,
     :prismaEstimateCode string},
    :supplier string},
   :budgetId string,
   :invoiceGroupingId string,
   :budgetAmountMicros string,
   :externalBudgetId string,
   :externalBudgetSource
   [EXTERNAL_BUDGET_SOURCE_UNSPECIFIED
    EXTERNAL_BUDGET_SOURCE_NONE
    EXTERNAL_BUDGET_SOURCE_MEDIA_OCEAN]}],
 :updateTime string,
 :frequencyCap
 {:unlimited boolean,
  :timeUnit
  [TIME_UNIT_UNSPECIFIED
   TIME_UNIT_LIFETIME
   TIME_UNIT_MONTHS
   TIME_UNIT_WEEKS
   TIME_UNIT_DAYS
   TIME_UNIT_HOURS
   TIME_UNIT_MINUTES],
  :timeUnitCount integer,
  :maxImpressions integer,
  :maxViews integer},
 :advertiserId string,
 :campaignFlight
 {:plannedSpendAmountMicros string,
  :plannedDates
  {:startDate {:year integer, :month integer, :day integer},
   :endDate {:year integer, :month integer, :day integer}}},
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}"
  [advertiserId Campaign]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video"
      "https://www.googleapis.com/auth/display-video-mediaplanning"],
     :body Campaign}))

(defn advertisers-campaigns-patch
  "Updates an existing campaign. Returns the updated campaign if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the campaign belongs to.
campaignId <string> Output only. The unique ID of the campaign. Assigned by the system.
Campaign:
{:displayName string,
 :name string,
 :campaignGoal
 {:campaignGoalType
  [CAMPAIGN_GOAL_TYPE_UNSPECIFIED
   CAMPAIGN_GOAL_TYPE_APP_INSTALL
   CAMPAIGN_GOAL_TYPE_BRAND_AWARENESS
   CAMPAIGN_GOAL_TYPE_OFFLINE_ACTION
   CAMPAIGN_GOAL_TYPE_ONLINE_ACTION],
  :performanceGoal
  {:performanceGoalType
   [PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    PERFORMANCE_GOAL_TYPE_CPM
    PERFORMANCE_GOAL_TYPE_CPC
    PERFORMANCE_GOAL_TYPE_CPA
    PERFORMANCE_GOAL_TYPE_CTR
    PERFORMANCE_GOAL_TYPE_VIEWABILITY
    PERFORMANCE_GOAL_TYPE_CPIAVC
    PERFORMANCE_GOAL_TYPE_CPE
    PERFORMANCE_GOAL_TYPE_CLICK_CVR
    PERFORMANCE_GOAL_TYPE_IMPRESSION_CVR
    PERFORMANCE_GOAL_TYPE_VCPM
    PERFORMANCE_GOAL_TYPE_VTR
    PERFORMANCE_GOAL_TYPE_AUDIO_COMPLETION_RATE
    PERFORMANCE_GOAL_TYPE_VIDEO_COMPLETION_RATE
    PERFORMANCE_GOAL_TYPE_OTHER],
   :performanceGoalAmountMicros string,
   :performanceGoalPercentageMicros string,
   :performanceGoalString string}},
 :campaignId string,
 :campaignBudgets
 [{:dateRange
   {:startDate {:year integer, :month integer, :day integer},
    :endDate {:year integer, :month integer, :day integer}},
   :budgetUnit
   [BUDGET_UNIT_UNSPECIFIED
    BUDGET_UNIT_CURRENCY
    BUDGET_UNIT_IMPRESSIONS],
   :displayName string,
   :prismaConfig
   {:prismaType
    [PRISMA_TYPE_UNSPECIFIED
     PRISMA_TYPE_DISPLAY
     PRISMA_TYPE_SEARCH
     PRISMA_TYPE_VIDEO
     PRISMA_TYPE_AUDIO
     PRISMA_TYPE_SOCIAL
     PRISMA_TYPE_FEE],
    :prismaCpeCode
    {:prismaClientCode string,
     :prismaProductCode string,
     :prismaEstimateCode string},
    :supplier string},
   :budgetId string,
   :invoiceGroupingId string,
   :budgetAmountMicros string,
   :externalBudgetId string,
   :externalBudgetSource
   [EXTERNAL_BUDGET_SOURCE_UNSPECIFIED
    EXTERNAL_BUDGET_SOURCE_NONE
    EXTERNAL_BUDGET_SOURCE_MEDIA_OCEAN]}],
 :updateTime string,
 :frequencyCap
 {:unlimited boolean,
  :timeUnit
  [TIME_UNIT_UNSPECIFIED
   TIME_UNIT_LIFETIME
   TIME_UNIT_MONTHS
   TIME_UNIT_WEEKS
   TIME_UNIT_DAYS
   TIME_UNIT_HOURS
   TIME_UNIT_MINUTES],
  :timeUnitCount integer,
  :maxImpressions integer,
  :maxViews integer},
 :advertiserId string,
 :campaignFlight
 {:plannedSpendAmountMicros string,
  :plannedDates
  {:startDate {:year integer, :month integer, :day integer},
   :endDate {:year integer, :month integer, :day integer}}},
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId campaignId Campaign]
    (advertisers-campaigns-patch advertiserId campaignId Campaign nil))
  ([advertiserId campaignId Campaign optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns/{+campaignId}",
       :uri-template-args
       {:advertiserId advertiserId, :campaignId campaignId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/display-video"
        "https://www.googleapis.com/auth/display-video-mediaplanning"],
       :body Campaign})))

(defn advertisers-campaigns-delete
  "Permanently deletes a campaign. A deleted campaign cannot be recovered. The campaign should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser this campaign belongs to.
campaignId <string> The ID of the campaign we need to delete."
  [advertiserId campaignId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns/{+campaignId}",
     :uri-template-args
     {:advertiserId advertiserId, :campaignId campaignId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video"
      "https://www.googleapis.com/auth/display-video-mediaplanning"]}))

(defn advertisers-campaigns-targetingTypes-assignedTargetingOptions-get
  "Gets a single targeting option assigned to a campaign.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the campaign belongs to.
campaignId <string> Required. The ID of the campaign the assigned targeting option belongs to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_VIEWABILITY`
assignedTargetingOptionId <string> Required. An identifier unique to the targeting type in this campaign that identifies the assigned targeting option being requested."
  [advertiserId campaignId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns/{+campaignId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :campaignId campaignId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-campaigns-targetingTypes-assignedTargetingOptions-list
  "Lists the targeting options assigned to a campaign for a specified targeting type.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the campaign belongs to.
campaignId <string> Required. The ID of the campaign to list assigned targeting options for.
targetingType <string> Required. Identifies the type of assigned targeting options to list. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_VIEWABILITY`

optional:
pageSize <integer> Requested page size. Must be between `1` and `5000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `assignedTargetingOptionId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `assignedTargetingOptionId desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the `OR` logical operator. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedTargetingOptionId` * `inheritance` Examples: * `AssignedTargetingOption` resources with ID 1 or 2 `assignedTargetingOptionId=\"1\" OR assignedTargetingOptionId=\"2\"` * `AssignedTargetingOption` resources with inheritance status of `NOT_INHERITED` or `INHERITED_FROM_PARTNER` `inheritance=\"NOT_INHERITED\" OR inheritance=\"INHERITED_FROM_PARTNER\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId campaignId targetingType]
    (advertisers-campaigns-targetingTypes-assignedTargetingOptions-list
      advertiserId
      campaignId
      targetingType
      nil))
  ([advertiserId campaignId targetingType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/campaigns/{+campaignId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
       :uri-template-args
       {:advertiserId advertiserId,
        :campaignId campaignId,
        :targetingType targetingType},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-adGroupAds-get
  "Gets an ad group ad.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this ad group ad belongs to.
adGroupAdId <string> Required. The ID of the ad group ad to fetch."
  [advertiserId adGroupAdId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/adGroupAds/{+adGroupAdId}",
     :uri-template-args
     {:advertiserId advertiserId, :adGroupAdId adGroupAdId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-adGroupAds-list
  "Lists ad group ads.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the ad groups belongs to.

optional:
pageSize <integer> Optional. Requested page size. Must be between `1` and `100`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Optional. Field by which to sort the list. Acceptable values are: * `displayName` (default) * `entityStatus` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Optional. Allows filtering by custom ad group ad fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` and `OR`. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `adGroupId` * `displayName` * `entityStatus` * `adGroupAdId` Examples: * All ad group ads under an ad group: `adGroupId=\"1234\"` * All ad group ads under an ad group with an entityStatus of `ENTITY_STATUS_ACTIVE` or `ENTITY_STATUS_PAUSED`: `(entityStatus=\"ENTITY_STATUS_ACTIVE\" OR entityStatus=\"ENTITY_STATUS_PAUSED\") AND adGroupId=\"12345\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-adGroupAds-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/adGroupAds",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-creatives-get
  "Gets a creative.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this creative belongs to.
creativeId <string> Required. The ID of the creative to fetch."
  [advertiserId creativeId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/creatives/{+creativeId}",
     :uri-template-args
     {:advertiserId advertiserId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-creatives-list
  "Lists creatives in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, creatives with `ENTITY_STATUS_ARCHIVED` will not be included in the results.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser to list creatives for.

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `creativeId` (default) * `createTime` * `mediaDuration` * `dimensions` (sorts by width first, then by height) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `createTime desc`.
filter <string> Allows filtering by creative fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * The `lineItemIds` field must use the `HAS (:)` operator. * The `updateTime` field must use the `GREATER THAN OR EQUAL TO (>=)` or `LESS THAN OR EQUAL TO (<=)` operators. * All other fields must use the `EQUALS (=)` operator. * For `entityStatus`, `minDuration`, `maxDuration`, `updateTime`, and `dynamic` fields, there may be at most one restriction. Supported Fields: * `approvalStatus` * `creativeId` * `creativeType` * `dimensions` (input in the form of `{width}x{height}`) * `dynamic` * `entityStatus` * `exchangeReviewStatus` (input in the form of `{exchange}-{reviewStatus}`) * `lineItemIds` * `maxDuration` (input in the form of `{duration}s`. Only seconds are supported) * `minDuration` (input in the form of `{duration}s`. Only seconds are supported) * `updateTime` (input in ISO 8601 format, or `YYYY-MM-DDTHH:MM:SSZ`) Notes: * For `updateTime`, a creative resource's field value reflects the last time that a creative has been updated, which includes updates made by the system (e.g. creative review updates). Examples: * All native creatives: `creativeType=\"CREATIVE_TYPE_NATIVE\"` * All active creatives with 300x400 or 50x100 dimensions: `entityStatus=\"ENTITY_STATUS_ACTIVE\" AND (dimensions=\"300x400\" OR dimensions=\"50x100\")` * All dynamic creatives that are approved by AdX or AppNexus, with a minimum duration of 5 seconds and 200ms: `dynamic=\"true\" AND minDuration=\"5.2s\" AND (exchangeReviewStatus=\"EXCHANGE_GOOGLE_AD_MANAGER-REVIEW_STATUS_APPROVED\" OR exchangeReviewStatus=\"EXCHANGE_APPNEXUS-REVIEW_STATUS_APPROVED\")` * All video creatives that are associated with line item ID 1 or 2: `creativeType=\"CREATIVE_TYPE_VIDEO\" AND (lineItemIds:1 OR lineItemIds:2)` * Find creatives by multiple creative IDs: `creativeId=1 OR creativeId=2` * All creatives with an update time greater than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime>=\"2020-11-04T18:54:47Z\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-creatives-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/creatives",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-creatives-create
  "Creates a new creative. Returns the newly created creative if successful. A [\"Standard\" user role](//support.google.com/displayvideo/answer/2723011) or greater for the parent advertiser or partner is required to make this request.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the creative belongs to.
Creative:
{:requireMraid boolean,
 :skippable boolean,
 :reviewStatus
 {:approvalStatus
  [APPROVAL_STATUS_UNSPECIFIED
   APPROVAL_STATUS_PENDING_NOT_SERVABLE
   APPROVAL_STATUS_PENDING_SERVABLE
   APPROVAL_STATUS_APPROVED_SERVABLE
   APPROVAL_STATUS_REJECTED_NOT_SERVABLE],
  :creativeAndLandingPageReviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   REVIEW_STATUS_APPROVED
   REVIEW_STATUS_REJECTED
   REVIEW_STATUS_PENDING],
  :contentAndPolicyReviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   REVIEW_STATUS_APPROVED
   REVIEW_STATUS_REJECTED
   REVIEW_STATUS_PENDING],
  :exchangeReviewStatuses
  [{:exchange
    [EXCHANGE_UNSPECIFIED
     EXCHANGE_GOOGLE_AD_MANAGER
     EXCHANGE_APPNEXUS
     EXCHANGE_BRIGHTROLL
     EXCHANGE_ADFORM
     EXCHANGE_ADMETA
     EXCHANGE_ADMIXER
     EXCHANGE_ADSMOGO
     EXCHANGE_ADSWIZZ
     EXCHANGE_BIDSWITCH
     EXCHANGE_BRIGHTROLL_DISPLAY
     EXCHANGE_CADREON
     EXCHANGE_DAILYMOTION
     EXCHANGE_FIVE
     EXCHANGE_FLUCT
     EXCHANGE_FREEWHEEL
     EXCHANGE_GENIEE
     EXCHANGE_GUMGUM
     EXCHANGE_IMOBILE
     EXCHANGE_IBILLBOARD
     EXCHANGE_IMPROVE_DIGITAL
     EXCHANGE_INDEX
     EXCHANGE_KARGO
     EXCHANGE_MICROAD
     EXCHANGE_MOPUB
     EXCHANGE_NEND
     EXCHANGE_ONE_BY_AOL_DISPLAY
     EXCHANGE_ONE_BY_AOL_MOBILE
     EXCHANGE_ONE_BY_AOL_VIDEO
     EXCHANGE_OOYALA
     EXCHANGE_OPENX
     EXCHANGE_PERMODO
     EXCHANGE_PLATFORMONE
     EXCHANGE_PLATFORMID
     EXCHANGE_PUBMATIC
     EXCHANGE_PULSEPOINT
     EXCHANGE_REVENUEMAX
     EXCHANGE_RUBICON
     EXCHANGE_SMARTCLIP
     EXCHANGE_SMARTRTB
     EXCHANGE_SMARTSTREAMTV
     EXCHANGE_SOVRN
     EXCHANGE_SPOTXCHANGE
     EXCHANGE_STROER
     EXCHANGE_TEADSTV
     EXCHANGE_TELARIA
     EXCHANGE_TVN
     EXCHANGE_UNITED
     EXCHANGE_YIELDLAB
     EXCHANGE_YIELDMO
     EXCHANGE_UNRULYX
     EXCHANGE_OPEN8
     EXCHANGE_TRITON
     EXCHANGE_TRIPLELIFT
     EXCHANGE_TABOOLA
     EXCHANGE_INMOBI
     EXCHANGE_SMAATO
     EXCHANGE_AJA
     EXCHANGE_SUPERSHIP
     EXCHANGE_NEXSTAR_DIGITAL
     EXCHANGE_WAZE
     EXCHANGE_SOUNDCAST
     EXCHANGE_SHARETHROUGH
     EXCHANGE_FYBER
     EXCHANGE_RED_FOR_PUBLISHERS
     EXCHANGE_MEDIANET
     EXCHANGE_TAPJOY
     EXCHANGE_VISTAR
     EXCHANGE_DAX
     EXCHANGE_JCD
     EXCHANGE_PLACE_EXCHANGE
     EXCHANGE_APPLOVIN
     EXCHANGE_CONNATIX
     EXCHANGE_RESET_DIGITAL
     EXCHANGE_HIVESTACK
     EXCHANGE_DRAX
     EXCHANGE_APPLOVIN_GBID
     EXCHANGE_FYBER_GBID
     EXCHANGE_UNITY_GBID
     EXCHANGE_CHARTBOOST_GBID
     EXCHANGE_ADMOST_GBID
     EXCHANGE_TOPON_GBID],
    :status
    [REVIEW_STATUS_UNSPECIFIED
     REVIEW_STATUS_APPROVED
     REVIEW_STATUS_REJECTED
     REVIEW_STATUS_PENDING]}],
  :publisherReviewStatuses
  [{:publisherName string,
    :status
    [REVIEW_STATUS_UNSPECIFIED
     REVIEW_STATUS_APPROVED
     REVIEW_STATUS_REJECTED
     REVIEW_STATUS_PENDING]}]},
 :creativeAttributes
 [[CREATIVE_ATTRIBUTE_UNSPECIFIED
   CREATIVE_ATTRIBUTE_VAST
   CREATIVE_ATTRIBUTE_VPAID_LINEAR
   CREATIVE_ATTRIBUTE_VPAID_NON_LINEAR]],
 :trackerUrls [string],
 :iasCampaignMonitoring boolean,
 :displayName string,
 :assets
 [{:asset {:mediaId string, :content string},
   :role
   [ASSET_ROLE_UNSPECIFIED
    ASSET_ROLE_MAIN
    ASSET_ROLE_BACKUP
    ASSET_ROLE_POLITE_LOAD
    ASSET_ROLE_HEADLINE
    ASSET_ROLE_LONG_HEADLINE
    ASSET_ROLE_BODY
    ASSET_ROLE_LONG_BODY
    ASSET_ROLE_CAPTION_URL
    ASSET_ROLE_CALL_TO_ACTION
    ASSET_ROLE_ADVERTISER_NAME
    ASSET_ROLE_PRICE
    ASSET_ROLE_ANDROID_APP_ID
    ASSET_ROLE_IOS_APP_ID
    ASSET_ROLE_RATING
    ASSET_ROLE_ICON
    ASSET_ROLE_COVER_IMAGE]}],
 :skipOffset {:percentage string, :seconds string},
 :name string,
 :vpaid boolean,
 :universalAdId
 {:id string,
  :registry
  [UNIVERSAL_AD_REGISTRY_UNSPECIFIED
   UNIVERSAL_AD_REGISTRY_OTHER
   UNIVERSAL_AD_REGISTRY_AD_ID
   UNIVERSAL_AD_REGISTRY_CLEARCAST
   UNIVERSAL_AD_REGISTRY_DV360
   UNIVERSAL_AD_REGISTRY_CM]},
 :createTime string,
 :creativeType
 [CREATIVE_TYPE_UNSPECIFIED
  CREATIVE_TYPE_STANDARD
  CREATIVE_TYPE_EXPANDABLE
  CREATIVE_TYPE_VIDEO
  CREATIVE_TYPE_NATIVE
  CREATIVE_TYPE_TEMPLATED_APP_INSTALL
  CREATIVE_TYPE_NATIVE_SITE_SQUARE
  CREATIVE_TYPE_TEMPLATED_APP_INSTALL_INTERSTITIAL
  CREATIVE_TYPE_LIGHTBOX
  CREATIVE_TYPE_NATIVE_APP_INSTALL
  CREATIVE_TYPE_NATIVE_APP_INSTALL_SQUARE
  CREATIVE_TYPE_AUDIO
  CREATIVE_TYPE_PUBLISHER_HOSTED
  CREATIVE_TYPE_NATIVE_VIDEO
  CREATIVE_TYPE_TEMPLATED_APP_INSTALL_VIDEO],
 :lineItemIds [string],
 :expandingDirection
 [EXPANDING_DIRECTION_UNSPECIFIED
  EXPANDING_DIRECTION_NONE
  EXPANDING_DIRECTION_UP
  EXPANDING_DIRECTION_DOWN
  EXPANDING_DIRECTION_LEFT
  EXPANDING_DIRECTION_RIGHT
  EXPANDING_DIRECTION_UP_AND_LEFT
  EXPANDING_DIRECTION_UP_AND_RIGHT
  EXPANDING_DIRECTION_DOWN_AND_LEFT
  EXPANDING_DIRECTION_DOWN_AND_RIGHT
  EXPANDING_DIRECTION_UP_OR_DOWN
  EXPANDING_DIRECTION_LEFT_OR_RIGHT
  EXPANDING_DIRECTION_ANY_DIAGONAL],
 :mp3Audio boolean,
 :additionalDimensions [{:widthPixels integer, :heightPixels integer}],
 :html5Video boolean,
 :dimensions {:widthPixels integer, :heightPixels integer},
 :updateTime string,
 :jsTrackerUrl string,
 :thirdPartyUrls
 [{:type
   [THIRD_PARTY_URL_TYPE_UNSPECIFIED
    THIRD_PARTY_URL_TYPE_IMPRESSION
    THIRD_PARTY_URL_TYPE_CLICK_TRACKING
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_START
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_FIRST_QUARTILE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_MIDPOINT
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_THIRD_QUARTILE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_COMPLETE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_MUTE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_PAUSE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_REWIND
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_FULLSCREEN
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_STOP
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_CUSTOM
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_SKIP
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_PROGRESS],
   :url string}],
 :requirePingForAttribution boolean,
 :vastTagUrl string,
 :creativeId string,
 :counterEvents [{:name string, :reportingName string}],
 :dynamic boolean,
 :advertiserId string,
 :appendedTag string,
 :notes string,
 :transcodes
 [{:bitRateKbps string,
   :audioBitRateKbps string,
   :name string,
   :frameRate number,
   :transcoded boolean,
   :dimensions {:widthPixels integer, :heightPixels integer},
   :audioSampleRateHz string,
   :mimeType string,
   :fileSizeBytes string}],
 :oggAudio boolean,
 :progressOffset {:percentage string, :seconds string},
 :requireHtml5 boolean,
 :obaIcon
 {:resourceUrl string,
  :resourceMimeType string,
  :position
  [OBA_ICON_POSITION_UNSPECIFIED
   OBA_ICON_POSITION_UPPER_RIGHT
   OBA_ICON_POSITION_UPPER_LEFT
   OBA_ICON_POSITION_LOWER_RIGHT
   OBA_ICON_POSITION_LOWER_LEFT],
  :dimensions {:widthPixels integer, :heightPixels integer},
  :program string,
  :landingPageUrl string,
  :clickTrackingUrl string,
  :viewTrackingUrl string},
 :integrationCode string,
 :companionCreativeIds [string],
 :cmTrackingAd
 {:cmPlacementId string, :cmCreativeId string, :cmAdId string},
 :expandOnHover boolean,
 :hostingSource
 [HOSTING_SOURCE_UNSPECIFIED
  HOSTING_SOURCE_CM
  HOSTING_SOURCE_THIRD_PARTY
  HOSTING_SOURCE_HOSTED
  HOSTING_SOURCE_RICH_MEDIA],
 :timerEvents [{:name string, :reportingName string}],
 :cmPlacementId string,
 :mediaDuration string,
 :thirdPartyTag string,
 :exitEvents
 [{:type
   [EXIT_EVENT_TYPE_UNSPECIFIED
    EXIT_EVENT_TYPE_DEFAULT
    EXIT_EVENT_TYPE_BACKUP],
   :url string,
   :name string,
   :reportingName string}],
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}"
  [advertiserId Creative]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/creatives",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body Creative}))

(defn advertisers-creatives-patch
  "Updates an existing creative. Returns the updated creative if successful. A [\"Standard\" user role](//support.google.com/displayvideo/answer/2723011) or greater for the parent advertiser or partner is required to make this request.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the creative belongs to.
creativeId <string> Output only. The unique ID of the creative. Assigned by the system.
Creative:
{:requireMraid boolean,
 :skippable boolean,
 :reviewStatus
 {:approvalStatus
  [APPROVAL_STATUS_UNSPECIFIED
   APPROVAL_STATUS_PENDING_NOT_SERVABLE
   APPROVAL_STATUS_PENDING_SERVABLE
   APPROVAL_STATUS_APPROVED_SERVABLE
   APPROVAL_STATUS_REJECTED_NOT_SERVABLE],
  :creativeAndLandingPageReviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   REVIEW_STATUS_APPROVED
   REVIEW_STATUS_REJECTED
   REVIEW_STATUS_PENDING],
  :contentAndPolicyReviewStatus
  [REVIEW_STATUS_UNSPECIFIED
   REVIEW_STATUS_APPROVED
   REVIEW_STATUS_REJECTED
   REVIEW_STATUS_PENDING],
  :exchangeReviewStatuses
  [{:exchange
    [EXCHANGE_UNSPECIFIED
     EXCHANGE_GOOGLE_AD_MANAGER
     EXCHANGE_APPNEXUS
     EXCHANGE_BRIGHTROLL
     EXCHANGE_ADFORM
     EXCHANGE_ADMETA
     EXCHANGE_ADMIXER
     EXCHANGE_ADSMOGO
     EXCHANGE_ADSWIZZ
     EXCHANGE_BIDSWITCH
     EXCHANGE_BRIGHTROLL_DISPLAY
     EXCHANGE_CADREON
     EXCHANGE_DAILYMOTION
     EXCHANGE_FIVE
     EXCHANGE_FLUCT
     EXCHANGE_FREEWHEEL
     EXCHANGE_GENIEE
     EXCHANGE_GUMGUM
     EXCHANGE_IMOBILE
     EXCHANGE_IBILLBOARD
     EXCHANGE_IMPROVE_DIGITAL
     EXCHANGE_INDEX
     EXCHANGE_KARGO
     EXCHANGE_MICROAD
     EXCHANGE_MOPUB
     EXCHANGE_NEND
     EXCHANGE_ONE_BY_AOL_DISPLAY
     EXCHANGE_ONE_BY_AOL_MOBILE
     EXCHANGE_ONE_BY_AOL_VIDEO
     EXCHANGE_OOYALA
     EXCHANGE_OPENX
     EXCHANGE_PERMODO
     EXCHANGE_PLATFORMONE
     EXCHANGE_PLATFORMID
     EXCHANGE_PUBMATIC
     EXCHANGE_PULSEPOINT
     EXCHANGE_REVENUEMAX
     EXCHANGE_RUBICON
     EXCHANGE_SMARTCLIP
     EXCHANGE_SMARTRTB
     EXCHANGE_SMARTSTREAMTV
     EXCHANGE_SOVRN
     EXCHANGE_SPOTXCHANGE
     EXCHANGE_STROER
     EXCHANGE_TEADSTV
     EXCHANGE_TELARIA
     EXCHANGE_TVN
     EXCHANGE_UNITED
     EXCHANGE_YIELDLAB
     EXCHANGE_YIELDMO
     EXCHANGE_UNRULYX
     EXCHANGE_OPEN8
     EXCHANGE_TRITON
     EXCHANGE_TRIPLELIFT
     EXCHANGE_TABOOLA
     EXCHANGE_INMOBI
     EXCHANGE_SMAATO
     EXCHANGE_AJA
     EXCHANGE_SUPERSHIP
     EXCHANGE_NEXSTAR_DIGITAL
     EXCHANGE_WAZE
     EXCHANGE_SOUNDCAST
     EXCHANGE_SHARETHROUGH
     EXCHANGE_FYBER
     EXCHANGE_RED_FOR_PUBLISHERS
     EXCHANGE_MEDIANET
     EXCHANGE_TAPJOY
     EXCHANGE_VISTAR
     EXCHANGE_DAX
     EXCHANGE_JCD
     EXCHANGE_PLACE_EXCHANGE
     EXCHANGE_APPLOVIN
     EXCHANGE_CONNATIX
     EXCHANGE_RESET_DIGITAL
     EXCHANGE_HIVESTACK
     EXCHANGE_DRAX
     EXCHANGE_APPLOVIN_GBID
     EXCHANGE_FYBER_GBID
     EXCHANGE_UNITY_GBID
     EXCHANGE_CHARTBOOST_GBID
     EXCHANGE_ADMOST_GBID
     EXCHANGE_TOPON_GBID],
    :status
    [REVIEW_STATUS_UNSPECIFIED
     REVIEW_STATUS_APPROVED
     REVIEW_STATUS_REJECTED
     REVIEW_STATUS_PENDING]}],
  :publisherReviewStatuses
  [{:publisherName string,
    :status
    [REVIEW_STATUS_UNSPECIFIED
     REVIEW_STATUS_APPROVED
     REVIEW_STATUS_REJECTED
     REVIEW_STATUS_PENDING]}]},
 :creativeAttributes
 [[CREATIVE_ATTRIBUTE_UNSPECIFIED
   CREATIVE_ATTRIBUTE_VAST
   CREATIVE_ATTRIBUTE_VPAID_LINEAR
   CREATIVE_ATTRIBUTE_VPAID_NON_LINEAR]],
 :trackerUrls [string],
 :iasCampaignMonitoring boolean,
 :displayName string,
 :assets
 [{:asset {:mediaId string, :content string},
   :role
   [ASSET_ROLE_UNSPECIFIED
    ASSET_ROLE_MAIN
    ASSET_ROLE_BACKUP
    ASSET_ROLE_POLITE_LOAD
    ASSET_ROLE_HEADLINE
    ASSET_ROLE_LONG_HEADLINE
    ASSET_ROLE_BODY
    ASSET_ROLE_LONG_BODY
    ASSET_ROLE_CAPTION_URL
    ASSET_ROLE_CALL_TO_ACTION
    ASSET_ROLE_ADVERTISER_NAME
    ASSET_ROLE_PRICE
    ASSET_ROLE_ANDROID_APP_ID
    ASSET_ROLE_IOS_APP_ID
    ASSET_ROLE_RATING
    ASSET_ROLE_ICON
    ASSET_ROLE_COVER_IMAGE]}],
 :skipOffset {:percentage string, :seconds string},
 :name string,
 :vpaid boolean,
 :universalAdId
 {:id string,
  :registry
  [UNIVERSAL_AD_REGISTRY_UNSPECIFIED
   UNIVERSAL_AD_REGISTRY_OTHER
   UNIVERSAL_AD_REGISTRY_AD_ID
   UNIVERSAL_AD_REGISTRY_CLEARCAST
   UNIVERSAL_AD_REGISTRY_DV360
   UNIVERSAL_AD_REGISTRY_CM]},
 :createTime string,
 :creativeType
 [CREATIVE_TYPE_UNSPECIFIED
  CREATIVE_TYPE_STANDARD
  CREATIVE_TYPE_EXPANDABLE
  CREATIVE_TYPE_VIDEO
  CREATIVE_TYPE_NATIVE
  CREATIVE_TYPE_TEMPLATED_APP_INSTALL
  CREATIVE_TYPE_NATIVE_SITE_SQUARE
  CREATIVE_TYPE_TEMPLATED_APP_INSTALL_INTERSTITIAL
  CREATIVE_TYPE_LIGHTBOX
  CREATIVE_TYPE_NATIVE_APP_INSTALL
  CREATIVE_TYPE_NATIVE_APP_INSTALL_SQUARE
  CREATIVE_TYPE_AUDIO
  CREATIVE_TYPE_PUBLISHER_HOSTED
  CREATIVE_TYPE_NATIVE_VIDEO
  CREATIVE_TYPE_TEMPLATED_APP_INSTALL_VIDEO],
 :lineItemIds [string],
 :expandingDirection
 [EXPANDING_DIRECTION_UNSPECIFIED
  EXPANDING_DIRECTION_NONE
  EXPANDING_DIRECTION_UP
  EXPANDING_DIRECTION_DOWN
  EXPANDING_DIRECTION_LEFT
  EXPANDING_DIRECTION_RIGHT
  EXPANDING_DIRECTION_UP_AND_LEFT
  EXPANDING_DIRECTION_UP_AND_RIGHT
  EXPANDING_DIRECTION_DOWN_AND_LEFT
  EXPANDING_DIRECTION_DOWN_AND_RIGHT
  EXPANDING_DIRECTION_UP_OR_DOWN
  EXPANDING_DIRECTION_LEFT_OR_RIGHT
  EXPANDING_DIRECTION_ANY_DIAGONAL],
 :mp3Audio boolean,
 :additionalDimensions [{:widthPixels integer, :heightPixels integer}],
 :html5Video boolean,
 :dimensions {:widthPixels integer, :heightPixels integer},
 :updateTime string,
 :jsTrackerUrl string,
 :thirdPartyUrls
 [{:type
   [THIRD_PARTY_URL_TYPE_UNSPECIFIED
    THIRD_PARTY_URL_TYPE_IMPRESSION
    THIRD_PARTY_URL_TYPE_CLICK_TRACKING
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_START
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_FIRST_QUARTILE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_MIDPOINT
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_THIRD_QUARTILE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_COMPLETE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_MUTE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_PAUSE
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_REWIND
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_FULLSCREEN
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_STOP
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_CUSTOM
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_SKIP
    THIRD_PARTY_URL_TYPE_AUDIO_VIDEO_PROGRESS],
   :url string}],
 :requirePingForAttribution boolean,
 :vastTagUrl string,
 :creativeId string,
 :counterEvents [{:name string, :reportingName string}],
 :dynamic boolean,
 :advertiserId string,
 :appendedTag string,
 :notes string,
 :transcodes
 [{:bitRateKbps string,
   :audioBitRateKbps string,
   :name string,
   :frameRate number,
   :transcoded boolean,
   :dimensions {:widthPixels integer, :heightPixels integer},
   :audioSampleRateHz string,
   :mimeType string,
   :fileSizeBytes string}],
 :oggAudio boolean,
 :progressOffset {:percentage string, :seconds string},
 :requireHtml5 boolean,
 :obaIcon
 {:resourceUrl string,
  :resourceMimeType string,
  :position
  [OBA_ICON_POSITION_UNSPECIFIED
   OBA_ICON_POSITION_UPPER_RIGHT
   OBA_ICON_POSITION_UPPER_LEFT
   OBA_ICON_POSITION_LOWER_RIGHT
   OBA_ICON_POSITION_LOWER_LEFT],
  :dimensions {:widthPixels integer, :heightPixels integer},
  :program string,
  :landingPageUrl string,
  :clickTrackingUrl string,
  :viewTrackingUrl string},
 :integrationCode string,
 :companionCreativeIds [string],
 :cmTrackingAd
 {:cmPlacementId string, :cmCreativeId string, :cmAdId string},
 :expandOnHover boolean,
 :hostingSource
 [HOSTING_SOURCE_UNSPECIFIED
  HOSTING_SOURCE_CM
  HOSTING_SOURCE_THIRD_PARTY
  HOSTING_SOURCE_HOSTED
  HOSTING_SOURCE_RICH_MEDIA],
 :timerEvents [{:name string, :reportingName string}],
 :cmPlacementId string,
 :mediaDuration string,
 :thirdPartyTag string,
 :exitEvents
 [{:type
   [EXIT_EVENT_TYPE_UNSPECIFIED
    EXIT_EVENT_TYPE_DEFAULT
    EXIT_EVENT_TYPE_BACKUP],
   :url string,
   :name string,
   :reportingName string}],
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId creativeId Creative]
    (advertisers-creatives-patch advertiserId creativeId Creative nil))
  ([advertiserId creativeId Creative optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/creatives/{+creativeId}",
       :uri-template-args
       {:advertiserId advertiserId, :creativeId creativeId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Creative})))

(defn advertisers-creatives-delete
  "Deletes a creative. Returns error code `NOT_FOUND` if the creative does not exist. The creative should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, before it can be deleted. A [\"Standard\" user role](//support.google.com/displayvideo/answer/2723011) or greater for the parent advertiser or partner is required to make this request.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser this creative belongs to.
creativeId <string> The ID of the creative to be deleted."
  [advertiserId creativeId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/creatives/{+creativeId}",
     :uri-template-args
     {:advertiserId advertiserId, :creativeId creativeId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-targetingTypes-assignedTargetingOptions-get
  "Gets a single targeting option assigned to an advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_YOUTUBE_VIDEO` * `TARGETING_TYPE_YOUTUBE_CHANNEL` * `TARGETING_TYPE_KEYWORD`
assignedTargetingOptionId <string> Required. An identifier unique to the targeting type in this advertiser that identifies the assigned targeting option being requested."
  [advertiserId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-targetingTypes-assignedTargetingOptions-list
  "Lists the targeting options assigned to an advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser.
targetingType <string> Required. Identifies the type of assigned targeting options to list. Supported targeting types: * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_YOUTUBE_VIDEO` * `TARGETING_TYPE_YOUTUBE_CHANNEL` * `TARGETING_TYPE_KEYWORD`

optional:
pageSize <integer> Requested page size. Must be between `1` and `5000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `assignedTargetingOptionId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `assignedTargetingOptionId desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the `OR` logical operator. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedTargetingOptionId` Examples: * `AssignedTargetingOption` with ID 123456: `assignedTargetingOptionId=\"123456\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId targetingType]
    (advertisers-targetingTypes-assignedTargetingOptions-list
      advertiserId
      targetingType
      nil))
  ([advertiserId targetingType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
       :uri-template-args
       {:advertiserId advertiserId, :targetingType targetingType},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-targetingTypes-assignedTargetingOptions-create
  "Assigns a targeting option to an advertiser. Returns the assigned targeting option if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_KEYWORD`
AssignedTargetingOption:
{:contentGenreDetails
 {:targetingOptionId string, :displayName string, :negative boolean},
 :negativeKeywordListDetails {:negativeKeywordListId string},
 :parentalStatusDetails
 {:parentalStatus
  [PARENTAL_STATUS_UNSPECIFIED
   PARENTAL_STATUS_PARENT
   PARENTAL_STATUS_NOT_A_PARENT
   PARENTAL_STATUS_UNKNOWN]},
 :geoRegionDetails
 {:displayName string,
  :targetingOptionId string,
  :geoRegionType
  [GEO_REGION_TYPE_UNKNOWN
   GEO_REGION_TYPE_OTHER
   GEO_REGION_TYPE_COUNTRY
   GEO_REGION_TYPE_REGION
   GEO_REGION_TYPE_TERRITORY
   GEO_REGION_TYPE_PROVINCE
   GEO_REGION_TYPE_STATE
   GEO_REGION_TYPE_PREFECTURE
   GEO_REGION_TYPE_GOVERNORATE
   GEO_REGION_TYPE_CANTON
   GEO_REGION_TYPE_UNION_TERRITORY
   GEO_REGION_TYPE_AUTONOMOUS_COMMUNITY
   GEO_REGION_TYPE_DMA_REGION
   GEO_REGION_TYPE_METRO
   GEO_REGION_TYPE_CONGRESSIONAL_DISTRICT
   GEO_REGION_TYPE_COUNTY
   GEO_REGION_TYPE_MUNICIPALITY
   GEO_REGION_TYPE_CITY
   GEO_REGION_TYPE_POSTAL_CODE
   GEO_REGION_TYPE_DEPARTMENT
   GEO_REGION_TYPE_AIRPORT
   GEO_REGION_TYPE_TV_REGION
   GEO_REGION_TYPE_OKRUG
   GEO_REGION_TYPE_BOROUGH
   GEO_REGION_TYPE_CITY_REGION
   GEO_REGION_TYPE_ARRONDISSEMENT
   GEO_REGION_TYPE_NEIGHBORHOOD
   GEO_REGION_TYPE_UNIVERSITY
   GEO_REGION_TYPE_DISTRICT],
  :negative boolean},
 :regionalLocationListDetails
 {:regionalLocationListId string, :negative boolean},
 :browserDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inventorySourceGroupDetails {:inventorySourceGroupId string},
 :nativeContentPositionDetails
 {:contentPosition
  [NATIVE_CONTENT_POSITION_UNSPECIFIED
   NATIVE_CONTENT_POSITION_UNKNOWN
   NATIVE_CONTENT_POSITION_IN_ARTICLE
   NATIVE_CONTENT_POSITION_IN_FEED
   NATIVE_CONTENT_POSITION_PERIPHERAL
   NATIVE_CONTENT_POSITION_RECOMMENDATION]},
 :assignedTargetingOptionId string,
 :operatingSystemDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :appCategoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :contentInstreamPositionDetails
 {:contentInstreamPosition
  [CONTENT_INSTREAM_POSITION_UNSPECIFIED
   CONTENT_INSTREAM_POSITION_PRE_ROLL
   CONTENT_INSTREAM_POSITION_MID_ROLL
   CONTENT_INSTREAM_POSITION_POST_ROLL
   CONTENT_INSTREAM_POSITION_UNKNOWN],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :inventorySourceDetails {:inventorySourceId string},
 :audioContentTypeDetails
 {:audioContentType
  [AUDIO_CONTENT_TYPE_UNSPECIFIED
   AUDIO_CONTENT_TYPE_UNKNOWN
   AUDIO_CONTENT_TYPE_MUSIC
   AUDIO_CONTENT_TYPE_BROADCAST
   AUDIO_CONTENT_TYPE_PODCAST]},
 :thirdPartyVerifierDetails
 {:adloox
  {:excludedAdlooxCategories
   [[ADLOOX_UNSPECIFIED
     ADULT_CONTENT_HARD
     ADULT_CONTENT_SOFT
     ILLEGAL_CONTENT
     BORDERLINE_CONTENT
     DISCRIMINATORY_CONTENT
     VIOLENT_CONTENT_WEAPONS
     LOW_VIEWABILITY_DOMAINS
     FRAUD]]},
  :doubleVerify
  {:brandSafetyCategories
   {:avoidUnknownBrandSafetyCategory boolean,
    :avoidedHighSeverityCategories
    [[HIGHER_SEVERITY_UNSPECIFIED
      ADULT_CONTENT_PORNOGRAPHY
      COPYRIGHT_INFRINGEMENT
      SUBSTANCE_ABUSE
      GRAPHIC_VIOLENCE_WEAPONS
      HATE_PROFANITY
      CRIMINAL_SKILLS
      NUISANCE_INCENTIVIZED_MALWARE_CLUTTER]],
    :avoidedMediumSeverityCategories
    [[MEDIUM_SEVERITY_UNSPECIFIED
      AD_SERVERS
      ADULT_CONTENT_SWIMSUIT
      ALTERNATIVE_LIFESTYLES
      CELEBRITY_GOSSIP
      GAMBLING
      OCCULT
      SEX_EDUCATION
      DISASTER_AVIATION
      DISASTER_MAN_MADE
      DISASTER_NATURAL
      DISASTER_TERRORIST_EVENTS
      DISASTER_VEHICLE
      ALCOHOL
      SMOKING
      NEGATIVE_NEWS_FINANCIAL
      NON_ENGLISH
      PARKING_PAGE
      UNMODERATED_UGC
      INFLAMMATORY_POLITICS_AND_NEWS
      NEGATIVE_NEWS_PHARMACEUTICAL]]},
   :avoidedAgeRatings
   [[AGE_RATING_UNSPECIFIED
     APP_AGE_RATE_UNKNOWN
     APP_AGE_RATE_4_PLUS
     APP_AGE_RATE_9_PLUS
     APP_AGE_RATE_12_PLUS
     APP_AGE_RATE_17_PLUS
     APP_AGE_RATE_18_PLUS]],
   :appStarRating
   {:avoidedStarRating
    [APP_STAR_RATE_UNSPECIFIED
     APP_STAR_RATE_1_POINT_5_LESS
     APP_STAR_RATE_2_LESS
     APP_STAR_RATE_2_POINT_5_LESS
     APP_STAR_RATE_3_LESS
     APP_STAR_RATE_3_POINT_5_LESS
     APP_STAR_RATE_4_LESS
     APP_STAR_RATE_4_POINT_5_LESS],
    :avoidInsufficientStarRating boolean},
   :displayViewability
   {:iab
    [IAB_VIEWED_RATE_UNSPECIFIED
     IAB_VIEWED_RATE_80_PERCENT_HIGHER
     IAB_VIEWED_RATE_75_PERCENT_HIGHER
     IAB_VIEWED_RATE_70_PERCENT_HIGHER
     IAB_VIEWED_RATE_65_PERCENT_HIGHER
     IAB_VIEWED_RATE_60_PERCENT_HIGHER
     IAB_VIEWED_RATE_55_PERCENT_HIGHER
     IAB_VIEWED_RATE_50_PERCENT_HIGHER
     IAB_VIEWED_RATE_40_PERCENT_HIGHER
     IAB_VIEWED_RATE_30_PERCENT_HIGHER],
    :viewableDuring
    [AVERAGE_VIEW_DURATION_UNSPECIFIED
     AVERAGE_VIEW_DURATION_5_SEC
     AVERAGE_VIEW_DURATION_10_SEC
     AVERAGE_VIEW_DURATION_15_SEC]},
   :videoViewability
   {:videoIab
    [VIDEO_IAB_UNSPECIFIED
     IAB_VIEWABILITY_80_PERCENT_HIGHER
     IAB_VIEWABILITY_75_PERCENT_HIGHER
     IAB_VIEWABILITY_70_PERCENT_HIGHER
     IAB_VIEWABILITY_65_PERCENT_HIHGER
     IAB_VIEWABILITY_60_PERCENT_HIGHER
     IAB_VIEWABILITY_55_PERCENT_HIHGER
     IAB_VIEWABILITY_50_PERCENT_HIGHER
     IAB_VIEWABILITY_40_PERCENT_HIHGER
     IAB_VIEWABILITY_30_PERCENT_HIHGER],
    :videoViewableRate
    [VIDEO_VIEWABLE_RATE_UNSPECIFIED
     VIEWED_PERFORMANCE_40_PERCENT_HIGHER
     VIEWED_PERFORMANCE_35_PERCENT_HIGHER
     VIEWED_PERFORMANCE_30_PERCENT_HIGHER
     VIEWED_PERFORMANCE_25_PERCENT_HIGHER
     VIEWED_PERFORMANCE_20_PERCENT_HIGHER
     VIEWED_PERFORMANCE_10_PERCENT_HIGHER],
    :playerImpressionRate
    [PLAYER_SIZE_400X300_UNSPECIFIED
     PLAYER_SIZE_400X300_95
     PLAYER_SIZE_400X300_70
     PLAYER_SIZE_400X300_25
     PLAYER_SIZE_400X300_5]},
   :fraudInvalidTraffic
   {:avoidedFraudOption
    [FRAUD_UNSPECIFIED
     AD_IMPRESSION_FRAUD_100
     AD_IMPRESSION_FRAUD_50
     AD_IMPRESSION_FRAUD_25
     AD_IMPRESSION_FRAUD_10
     AD_IMPRESSION_FRAUD_8
     AD_IMPRESSION_FRAUD_6
     AD_IMPRESSION_FRAUD_4
     AD_IMPRESSION_FRAUD_2],
    :avoidInsufficientOption boolean},
   :customSegmentId string},
  :integralAdScience
  {:excludedIllegalDownloadsRisk
   [ILLEGAL_DOWNLOADS_UNSPECIFIED
    ILLEGAL_DOWNLOADS_HR
    ILLEGAL_DOWNLOADS_HMR],
   :excludedOffensiveLanguageRisk
   [OFFENSIVE_LANGUAGE_UNSPECIFIED
    OFFENSIVE_LANGUAGE_HR
    OFFENSIVE_LANGUAGE_HMR],
   :excludeUnrateable boolean,
   :excludedDrugsRisk [DRUGS_UNSPECIFIED DRUGS_HR DRUGS_HMR],
   :excludedGamblingRisk
   [GAMBLING_UNSPECIFIED GAMBLING_HR GAMBLING_HMR],
   :excludedAdultRisk [ADULT_UNSPECIFIED ADULT_HR ADULT_HMR],
   :displayViewability
   [PERFORMANCE_VIEWABILITY_UNSPECIFIED
    PERFORMANCE_VIEWABILITY_40
    PERFORMANCE_VIEWABILITY_50
    PERFORMANCE_VIEWABILITY_60
    PERFORMANCE_VIEWABILITY_70],
   :excludedViolenceRisk
   [VIOLENCE_UNSPECIFIED VIOLENCE_HR VIOLENCE_HMR],
   :traqScoreOption
   [TRAQ_UNSPECIFIED
    TRAQ_250
    TRAQ_500
    TRAQ_600
    TRAQ_700
    TRAQ_750
    TRAQ_875
    TRAQ_1000],
   :excludedHateSpeechRisk
   [HATE_SPEECH_UNSPECIFIED HATE_SPEECH_HR HATE_SPEECH_HMR],
   :videoViewability
   [VIDEO_VIEWABILITY_UNSPECIFIED
    VIDEO_VIEWABILITY_40
    VIDEO_VIEWABILITY_50
    VIDEO_VIEWABILITY_60
    VIDEO_VIEWABILITY_70],
   :excludedAdFraudRisk
   [SUSPICIOUS_ACTIVITY_UNSPECIFIED
    SUSPICIOUS_ACTIVITY_HR
    SUSPICIOUS_ACTIVITY_HMR],
   :customSegmentId [string],
   :excludedAlcoholRisk [ALCOHOL_UNSPECIFIED ALCOHOL_HR ALCOHOL_HMR]}},
 :name string,
 :onScreenPositionDetails
 {:targetingOptionId string,
  :onScreenPosition
  [ON_SCREEN_POSITION_UNSPECIFIED
   ON_SCREEN_POSITION_UNKNOWN
   ON_SCREEN_POSITION_ABOVE_THE_FOLD
   ON_SCREEN_POSITION_BELOW_THE_FOLD],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :videoPlayerSizeDetails
 {:videoPlayerSize
  [VIDEO_PLAYER_SIZE_UNSPECIFIED
   VIDEO_PLAYER_SIZE_SMALL
   VIDEO_PLAYER_SIZE_LARGE
   VIDEO_PLAYER_SIZE_HD
   VIDEO_PLAYER_SIZE_UNKNOWN]},
 :carrierAndIspDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :proximityLocationListDetails
 {:proximityLocationListId string,
  :proximityRadius number,
  :proximityRadiusUnit
  [PROXIMITY_RADIUS_UNIT_UNSPECIFIED
   PROXIMITY_RADIUS_UNIT_MILES
   PROXIMITY_RADIUS_UNIT_KILOMETERS]},
 :contentStreamTypeDetails
 {:targetingOptionId string,
  :contentStreamType
  [CONTENT_STREAM_TYPE_UNSPECIFIED
   CONTENT_LIVE_STREAM
   CONTENT_ON_DEMAND]},
 :digitalContentLabelExclusionDetails
 {:excludedContentRatingTier
  [CONTENT_RATING_TIER_UNSPECIFIED
   CONTENT_RATING_TIER_UNRATED
   CONTENT_RATING_TIER_GENERAL
   CONTENT_RATING_TIER_PARENTAL_GUIDANCE
   CONTENT_RATING_TIER_TEENS
   CONTENT_RATING_TIER_MATURE
   CONTENT_RATING_TIER_FAMILIES]},
 :ageRangeDetails
 {:ageRange
  [AGE_RANGE_UNSPECIFIED
   AGE_RANGE_18_24
   AGE_RANGE_25_34
   AGE_RANGE_35_44
   AGE_RANGE_45_54
   AGE_RANGE_55_64
   AGE_RANGE_65_PLUS
   AGE_RANGE_UNKNOWN
   AGE_RANGE_18_20
   AGE_RANGE_21_24
   AGE_RANGE_25_29
   AGE_RANGE_30_34
   AGE_RANGE_35_39
   AGE_RANGE_40_44
   AGE_RANGE_45_49
   AGE_RANGE_50_54
   AGE_RANGE_55_59
   AGE_RANGE_60_64]},
 :deviceMakeModelDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :categoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inheritance
 [INHERITANCE_UNSPECIFIED
  NOT_INHERITED
  INHERITED_FROM_PARTNER
  INHERITED_FROM_ADVERTISER],
 :businessChainDetails
 {:displayName string,
  :targetingOptionId string,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :audienceGroupDetails
 {:includedFirstAndThirdPartyAudienceGroups
  [{:settings
    [{:firstAndThirdPartyAudienceId string,
      :recency
      [RECENCY_NO_LIMIT
       RECENCY_1_MINUTE
       RECENCY_5_MINUTES
       RECENCY_10_MINUTES
       RECENCY_15_MINUTES
       RECENCY_30_MINUTES
       RECENCY_1_HOUR
       RECENCY_2_HOURS
       RECENCY_3_HOURS
       RECENCY_6_HOURS
       RECENCY_12_HOURS
       RECENCY_1_DAY
       RECENCY_2_DAYS
       RECENCY_3_DAYS
       RECENCY_5_DAYS
       RECENCY_7_DAYS
       RECENCY_10_DAYS
       RECENCY_14_DAYS
       RECENCY_15_DAYS
       RECENCY_21_DAYS
       RECENCY_28_DAYS
       RECENCY_30_DAYS
       RECENCY_40_DAYS
       RECENCY_45_DAYS
       RECENCY_60_DAYS
       RECENCY_90_DAYS
       RECENCY_120_DAYS
       RECENCY_180_DAYS
       RECENCY_270_DAYS
       RECENCY_365_DAYS]}]}],
  :includedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]},
  :includedCustomListGroup {:settings [{:customListId string}]},
  :includedCombinedAudienceGroup
  {:settings [{:combinedAudienceId string}]},
  :excludedFirstAndThirdPartyAudienceGroup
  {:settings
   [{:firstAndThirdPartyAudienceId string,
     :recency
     [RECENCY_NO_LIMIT
      RECENCY_1_MINUTE
      RECENCY_5_MINUTES
      RECENCY_10_MINUTES
      RECENCY_15_MINUTES
      RECENCY_30_MINUTES
      RECENCY_1_HOUR
      RECENCY_2_HOURS
      RECENCY_3_HOURS
      RECENCY_6_HOURS
      RECENCY_12_HOURS
      RECENCY_1_DAY
      RECENCY_2_DAYS
      RECENCY_3_DAYS
      RECENCY_5_DAYS
      RECENCY_7_DAYS
      RECENCY_10_DAYS
      RECENCY_14_DAYS
      RECENCY_15_DAYS
      RECENCY_21_DAYS
      RECENCY_28_DAYS
      RECENCY_30_DAYS
      RECENCY_40_DAYS
      RECENCY_45_DAYS
      RECENCY_60_DAYS
      RECENCY_90_DAYS
      RECENCY_120_DAYS
      RECENCY_180_DAYS
      RECENCY_270_DAYS
      RECENCY_365_DAYS]}]},
  :excludedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]}},
 :channelDetails {:channelId string, :negative boolean},
 :contentDurationDetails
 {:targetingOptionId string,
  :contentDuration
  [CONTENT_DURATION_UNSPECIFIED
   CONTENT_DURATION_UNKNOWN
   CONTENT_DURATION_0_TO_1_MIN
   CONTENT_DURATION_1_TO_5_MIN
   CONTENT_DURATION_5_TO_15_MIN
   CONTENT_DURATION_15_TO_30_MIN
   CONTENT_DURATION_30_TO_60_MIN
   CONTENT_DURATION_OVER_60_MIN]},
 :targetingType
 [TARGETING_TYPE_UNSPECIFIED
  TARGETING_TYPE_CHANNEL
  TARGETING_TYPE_APP_CATEGORY
  TARGETING_TYPE_APP
  TARGETING_TYPE_URL
  TARGETING_TYPE_DAY_AND_TIME
  TARGETING_TYPE_AGE_RANGE
  TARGETING_TYPE_REGIONAL_LOCATION_LIST
  TARGETING_TYPE_PROXIMITY_LOCATION_LIST
  TARGETING_TYPE_GENDER
  TARGETING_TYPE_VIDEO_PLAYER_SIZE
  TARGETING_TYPE_USER_REWARDED_CONTENT
  TARGETING_TYPE_PARENTAL_STATUS
  TARGETING_TYPE_CONTENT_INSTREAM_POSITION
  TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
  TARGETING_TYPE_DEVICE_TYPE
  TARGETING_TYPE_AUDIENCE_GROUP
  TARGETING_TYPE_BROWSER
  TARGETING_TYPE_HOUSEHOLD_INCOME
  TARGETING_TYPE_ON_SCREEN_POSITION
  TARGETING_TYPE_THIRD_PARTY_VERIFIER
  TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
  TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
  TARGETING_TYPE_ENVIRONMENT
  TARGETING_TYPE_CARRIER_AND_ISP
  TARGETING_TYPE_OPERATING_SYSTEM
  TARGETING_TYPE_DEVICE_MAKE_MODEL
  TARGETING_TYPE_KEYWORD
  TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
  TARGETING_TYPE_VIEWABILITY
  TARGETING_TYPE_CATEGORY
  TARGETING_TYPE_INVENTORY_SOURCE
  TARGETING_TYPE_LANGUAGE
  TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
  TARGETING_TYPE_GEO_REGION
  TARGETING_TYPE_INVENTORY_SOURCE_GROUP
  TARGETING_TYPE_EXCHANGE
  TARGETING_TYPE_SUB_EXCHANGE
  TARGETING_TYPE_POI
  TARGETING_TYPE_BUSINESS_CHAIN
  TARGETING_TYPE_CONTENT_DURATION
  TARGETING_TYPE_CONTENT_STREAM_TYPE
  TARGETING_TYPE_NATIVE_CONTENT_POSITION
  TARGETING_TYPE_OMID
  TARGETING_TYPE_AUDIO_CONTENT_TYPE
  TARGETING_TYPE_CONTENT_GENRE
  TARGETING_TYPE_YOUTUBE_VIDEO
  TARGETING_TYPE_YOUTUBE_CHANNEL
  TARGETING_TYPE_SESSION_POSITION],
 :environmentDetails
 {:environment
  [ENVIRONMENT_UNSPECIFIED
   ENVIRONMENT_WEB_OPTIMIZED
   ENVIRONMENT_WEB_NOT_OPTIMIZED
   ENVIRONMENT_APP]},
 :poiDetails
 {:displayName string,
  :targetingOptionId string,
  :latitude number,
  :longitude number,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :sensitiveCategoryExclusionDetails
 {:excludedSensitiveCategory
  [SENSITIVE_CATEGORY_UNSPECIFIED
   SENSITIVE_CATEGORY_ADULT
   SENSITIVE_CATEGORY_DEROGATORY
   SENSITIVE_CATEGORY_DOWNLOADS_SHARING
   SENSITIVE_CATEGORY_WEAPONS
   SENSITIVE_CATEGORY_GAMBLING
   SENSITIVE_CATEGORY_VIOLENCE
   SENSITIVE_CATEGORY_SUGGESTIVE
   SENSITIVE_CATEGORY_PROFANITY
   SENSITIVE_CATEGORY_ALCOHOL
   SENSITIVE_CATEGORY_DRUGS
   SENSITIVE_CATEGORY_TOBACCO
   SENSITIVE_CATEGORY_POLITICS
   SENSITIVE_CATEGORY_RELIGION
   SENSITIVE_CATEGORY_TRAGEDY
   SENSITIVE_CATEGORY_TRANSPORTATION_ACCIDENTS
   SENSITIVE_CATEGORY_SENSITIVE_SOCIAL_ISSUES
   SENSITIVE_CATEGORY_SHOCKING
   SENSITIVE_CATEGORY_EMBEDDED_VIDEO
   SENSITIVE_CATEGORY_LIVE_STREAMING_VIDEO]},
 :youtubeVideoDetails {:videoId string, :negative boolean},
 :sessionPositionDetails
 {:sessionPosition
  [SESSION_POSITION_UNSPECIFIED SESSION_POSITION_FIRST_IMPRESSION]},
 :deviceTypeDetails
 {:deviceType
  [DEVICE_TYPE_UNSPECIFIED
   DEVICE_TYPE_COMPUTER
   DEVICE_TYPE_CONNECTED_TV
   DEVICE_TYPE_SMART_PHONE
   DEVICE_TYPE_TABLET],
  :youtubeAndPartnersBidMultiplier number},
 :appDetails
 {:appId string,
  :displayName string,
  :negative boolean,
  :appPlatform
  [APP_PLATFORM_UNSPECIFIED
   APP_PLATFORM_IOS
   APP_PLATFORM_ANDROID
   APP_PLATFORM_ROKU
   APP_PLATFORM_AMAZON_FIRETV
   APP_PLATFORM_PLAYSTATION
   APP_PLATFORM_APPLE_TV
   APP_PLATFORM_XBOX
   APP_PLATFORM_SAMSUNG_TV
   APP_PLATFORM_ANDROID_TV
   APP_PLATFORM_GENERIC_CTV
   APP_PLATFORM_LG_TV
   APP_PLATFORM_VIZIO_TV]},
 :subExchangeDetails {:targetingOptionId string},
 :genderDetails
 {:gender
  [GENDER_UNSPECIFIED GENDER_MALE GENDER_FEMALE GENDER_UNKNOWN]},
 :languageDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :viewabilityDetails
 {:viewability
  [VIEWABILITY_UNSPECIFIED
   VIEWABILITY_10_PERCENT_OR_MORE
   VIEWABILITY_20_PERCENT_OR_MORE
   VIEWABILITY_30_PERCENT_OR_MORE
   VIEWABILITY_40_PERCENT_OR_MORE
   VIEWABILITY_50_PERCENT_OR_MORE
   VIEWABILITY_60_PERCENT_OR_MORE
   VIEWABILITY_70_PERCENT_OR_MORE
   VIEWABILITY_80_PERCENT_OR_MORE
   VIEWABILITY_90_PERCENT_OR_MORE]},
 :assignedTargetingOptionIdAlias string,
 :keywordDetails {:keyword string, :negative boolean},
 :urlDetails {:url string, :negative boolean},
 :exchangeDetails
 {:exchange
  [EXCHANGE_UNSPECIFIED
   EXCHANGE_GOOGLE_AD_MANAGER
   EXCHANGE_APPNEXUS
   EXCHANGE_BRIGHTROLL
   EXCHANGE_ADFORM
   EXCHANGE_ADMETA
   EXCHANGE_ADMIXER
   EXCHANGE_ADSMOGO
   EXCHANGE_ADSWIZZ
   EXCHANGE_BIDSWITCH
   EXCHANGE_BRIGHTROLL_DISPLAY
   EXCHANGE_CADREON
   EXCHANGE_DAILYMOTION
   EXCHANGE_FIVE
   EXCHANGE_FLUCT
   EXCHANGE_FREEWHEEL
   EXCHANGE_GENIEE
   EXCHANGE_GUMGUM
   EXCHANGE_IMOBILE
   EXCHANGE_IBILLBOARD
   EXCHANGE_IMPROVE_DIGITAL
   EXCHANGE_INDEX
   EXCHANGE_KARGO
   EXCHANGE_MICROAD
   EXCHANGE_MOPUB
   EXCHANGE_NEND
   EXCHANGE_ONE_BY_AOL_DISPLAY
   EXCHANGE_ONE_BY_AOL_MOBILE
   EXCHANGE_ONE_BY_AOL_VIDEO
   EXCHANGE_OOYALA
   EXCHANGE_OPENX
   EXCHANGE_PERMODO
   EXCHANGE_PLATFORMONE
   EXCHANGE_PLATFORMID
   EXCHANGE_PUBMATIC
   EXCHANGE_PULSEPOINT
   EXCHANGE_REVENUEMAX
   EXCHANGE_RUBICON
   EXCHANGE_SMARTCLIP
   EXCHANGE_SMARTRTB
   EXCHANGE_SMARTSTREAMTV
   EXCHANGE_SOVRN
   EXCHANGE_SPOTXCHANGE
   EXCHANGE_STROER
   EXCHANGE_TEADSTV
   EXCHANGE_TELARIA
   EXCHANGE_TVN
   EXCHANGE_UNITED
   EXCHANGE_YIELDLAB
   EXCHANGE_YIELDMO
   EXCHANGE_UNRULYX
   EXCHANGE_OPEN8
   EXCHANGE_TRITON
   EXCHANGE_TRIPLELIFT
   EXCHANGE_TABOOLA
   EXCHANGE_INMOBI
   EXCHANGE_SMAATO
   EXCHANGE_AJA
   EXCHANGE_SUPERSHIP
   EXCHANGE_NEXSTAR_DIGITAL
   EXCHANGE_WAZE
   EXCHANGE_SOUNDCAST
   EXCHANGE_SHARETHROUGH
   EXCHANGE_FYBER
   EXCHANGE_RED_FOR_PUBLISHERS
   EXCHANGE_MEDIANET
   EXCHANGE_TAPJOY
   EXCHANGE_VISTAR
   EXCHANGE_DAX
   EXCHANGE_JCD
   EXCHANGE_PLACE_EXCHANGE
   EXCHANGE_APPLOVIN
   EXCHANGE_CONNATIX
   EXCHANGE_RESET_DIGITAL
   EXCHANGE_HIVESTACK
   EXCHANGE_DRAX
   EXCHANGE_APPLOVIN_GBID
   EXCHANGE_FYBER_GBID
   EXCHANGE_UNITY_GBID
   EXCHANGE_CHARTBOOST_GBID
   EXCHANGE_ADMOST_GBID
   EXCHANGE_TOPON_GBID]},
 :dayAndTimeDetails
 {:dayOfWeek
  [DAY_OF_WEEK_UNSPECIFIED
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY],
  :startHour integer,
  :endHour integer,
  :timeZoneResolution
  [TIME_ZONE_RESOLUTION_UNSPECIFIED
   TIME_ZONE_RESOLUTION_END_USER
   TIME_ZONE_RESOLUTION_ADVERTISER]},
 :householdIncomeDetails
 {:householdIncome
  [HOUSEHOLD_INCOME_UNSPECIFIED
   HOUSEHOLD_INCOME_UNKNOWN
   HOUSEHOLD_INCOME_LOWER_50_PERCENT
   HOUSEHOLD_INCOME_TOP_41_TO_50_PERCENT
   HOUSEHOLD_INCOME_TOP_31_TO_40_PERCENT
   HOUSEHOLD_INCOME_TOP_21_TO_30_PERCENT
   HOUSEHOLD_INCOME_TOP_11_TO_20_PERCENT
   HOUSEHOLD_INCOME_TOP_10_PERCENT]},
 :authorizedSellerStatusDetails
 {:authorizedSellerStatus
  [AUTHORIZED_SELLER_STATUS_UNSPECIFIED
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_DIRECT_SELLERS_ONLY
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_AND_NON_PARTICIPATING_PUBLISHERS],
  :targetingOptionId string},
 :contentOutstreamPositionDetails
 {:contentOutstreamPosition
  [CONTENT_OUTSTREAM_POSITION_UNSPECIFIED
   CONTENT_OUTSTREAM_POSITION_UNKNOWN
   CONTENT_OUTSTREAM_POSITION_IN_ARTICLE
   CONTENT_OUTSTREAM_POSITION_IN_BANNER
   CONTENT_OUTSTREAM_POSITION_IN_FEED
   CONTENT_OUTSTREAM_POSITION_INTERSTITIAL],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :youtubeChannelDetails {:channelId string, :negative boolean},
 :userRewardedContentDetails
 {:targetingOptionId string,
  :userRewardedContent
  [USER_REWARDED_CONTENT_UNSPECIFIED
   USER_REWARDED_CONTENT_USER_REWARDED
   USER_REWARDED_CONTENT_NOT_USER_REWARDED]},
 :omidDetails {:omid [OMID_UNSPECIFIED OMID_FOR_MOBILE_DISPLAY_ADS]}}"
  [advertiserId targetingType AssignedTargetingOption]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
     :uri-template-args
     {:advertiserId advertiserId, :targetingType targetingType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body AssignedTargetingOption}))

(defn advertisers-targetingTypes-assignedTargetingOptions-delete
  "Deletes an assigned targeting option from an advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_KEYWORD`
assignedTargetingOptionId <string> Required. The ID of the assigned targeting option to delete."
  [advertiserId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-adGroups-bulkListAdGroupAssignedTargetingOptions
  "Lists assigned targeting options for multiple ad groups across targeting types. Inherited assigned targeting options are not included.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the line items belongs to.

optional:
adGroupIds <string> Required. The IDs of the ad groups to list assigned targeting options for.
pageSize <integer> Optional. Requested page size. The size must be an integer between `1` and `5000`. If unspecified, the default is `5000`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Optional. Field by which to sort the list. Acceptable values are: * `adGroupId` (default) * `assignedTargetingOption.targetingType` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `targetingType desc`.
filter <string> Optional. Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `targetingType` Examples: * `AssignedTargetingOption` resources of targeting type `TARGETING_TYPE_YOUTUBE_VIDEO` or `TARGETING_TYPE_YOUTUBE_CHANNEL`: `targetingType=\"TARGETING_TYPE_YOUTUBE_VIDEO\" OR targetingType=\"TARGETING_TYPE_YOUTUBE_CHANNEL\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId]
    (advertisers-adGroups-bulkListAdGroupAssignedTargetingOptions
      advertiserId
      nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/adGroups:bulkListAdGroupAssignedTargetingOptions",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-adGroups-get
  "Gets an ad group.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this ad group belongs to.
adGroupId <string> Required. The ID of the ad group to fetch."
  [advertiserId adGroupId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/adGroups/{+adGroupId}",
     :uri-template-args
     {:advertiserId advertiserId, :adGroupId adGroupId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-adGroups-list
  "Lists ad groups.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the ad groups belongs to.

optional:
pageSize <integer> Optional. Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Optional. Field by which to sort the list. Acceptable values are: * `displayName` (default) * `entityStatus` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Optional. Allows filtering by custom ad group fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` and `OR`. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported properties: * `adGroupId` * `displayName` * `entityStatus` * `lineItemId` * `adGroupFormat` Examples: * All ad groups under an line item: `lineItemId=\"1234\"` * All `ENTITY_STATUS_ACTIVE` or `ENTITY_STATUS_PAUSED` `AD_GROUP_FORMAT_IN_STREAM` ad groups under an advertiser: `(entityStatus=\"ENTITY_STATUS_ACTIVE\" OR entityStatus=\"ENTITY_STATUS_PAUSED\") AND adGroupFormat=\"AD_GROUP_FORMAT_IN_STREAM\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-adGroups-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/adGroups",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-adGroups-targetingTypes-assignedTargetingOptions-get
  "Gets a single targeting option assigned to an ad group. Inherited assigned targeting options are not included.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the ad group belongs to.
adGroupId <string> Required. The ID of the ad group the assigned targeting option belongs to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SESSION_POSITION` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_YOUTUBE_CHANNEL` * `TARGETING_TYPE_YOUTUBE_VIDEO`
assignedTargetingOptionId <string> Required. An identifier unique to the targeting type in this line item that identifies the assigned targeting option being requested."
  [advertiserId adGroupId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/adGroups/{+adGroupId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :adGroupId adGroupId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-adGroups-targetingTypes-assignedTargetingOptions-list
  "Lists the targeting options assigned to an ad group. Inherited assigned targeting options are not included.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the ad group belongs to.
adGroupId <string> Required. The ID of the ad group to list assigned targeting options for.
targetingType <string> Required. Identifies the type of assigned targeting options to list. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SESSION_POSITION` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_YOUTUBE_CHANNEL` * `TARGETING_TYPE_YOUTUBE_VIDEO`

optional:
pageSize <integer> Optional. Requested page size. Must be between `1` and `5000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Optional. Field by which to sort the list. Acceptable values are: * `assignedTargetingOptionId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `assignedTargetingOptionId desc`.
filter <string> Optional. Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedTargetingOptionId` Examples: * `AssignedTargetingOption` resources with ID 1 or 2: `assignedTargetingOptionId=\"1\" OR assignedTargetingOptionId=\"2\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId adGroupId targetingType]
    (advertisers-adGroups-targetingTypes-assignedTargetingOptions-list
      advertiserId
      adGroupId
      targetingType
      nil))
  ([advertiserId adGroupId targetingType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/adGroups/{+adGroupId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
       :uri-template-args
       {:advertiserId advertiserId,
        :adGroupId adGroupId,
        :targetingType targetingType},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-insertionOrders-listAssignedTargetingOptions
  "Lists assigned targeting options of an insertion order across targeting types.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the insertion order belongs to.
insertionOrderId <string> Required. The ID of the insertion order to list assigned targeting options for.

optional:
pageSize <integer> Requested page size. The size must be an integer between `1` and `5000`. If unspecified, the default is `5000`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `targetingType` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `targetingType desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `targetingType` * `inheritance` Examples: * `AssignedTargetingOption` resources of targeting type `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` or `TARGETING_TYPE_CHANNEL`: `targetingType=\"TARGETING_TYPE_PROXIMITY_LOCATION_LIST\" OR targetingType=\"TARGETING_TYPE_CHANNEL\"` * `AssignedTargetingOption` resources with inheritance status of `NOT_INHERITED` or `INHERITED_FROM_PARTNER`: `inheritance=\"NOT_INHERITED\" OR inheritance=\"INHERITED_FROM_PARTNER\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId insertionOrderId]
    (advertisers-insertionOrders-listAssignedTargetingOptions
      advertiserId
      insertionOrderId
      nil))
  ([advertiserId insertionOrderId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}:listAssignedTargetingOptions",
       :uri-template-args
       {:advertiserId advertiserId,
        :insertionOrderId insertionOrderId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-insertionOrders-get
  "Gets an insertion order. Returns error code `NOT_FOUND` if the insertion order does not exist.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser this insertion order belongs to.
insertionOrderId <string> Required. The ID of the insertion order to fetch."
  [advertiserId insertionOrderId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}",
     :uri-template-args
     {:advertiserId advertiserId, :insertionOrderId insertionOrderId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-insertionOrders-list
  "Lists insertion orders in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, insertion orders with `ENTITY_STATUS_ARCHIVED` will not be included in the results.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser to list insertion orders for.

optional:
pageSize <integer> Requested page size. Must be between `1` and `100`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * \"displayName\" (default) * \"entityStatus\" * \"updateTime\" The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by insertion order fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * The `updateTime` field must use the `GREATER THAN OR EQUAL TO (>=)` or `LESS THAN OR EQUAL TO (<=)` operators. * All other fields must use the `EQUALS (=)` operator. Supported fields: * `campaignId` * `displayName` * `entityStatus` * `updateTime` (input in ISO 8601 format, or `YYYY-MM-DDTHH:MM:SSZ`) Examples: * All insertion orders under a campaign: `campaignId=\"1234\"` * All `ENTITY_STATUS_ACTIVE` or `ENTITY_STATUS_PAUSED` insertion orders under an advertiser: `(entityStatus=\"ENTITY_STATUS_ACTIVE\" OR entityStatus=\"ENTITY_STATUS_PAUSED\")` * All insertion orders with an update time less than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime<=\"2020-11-04T18:54:47Z\"` * All insertion orders with an update time greater than or equal to 2020-11-04T18:54:47Z (format of ISO 8601): `updateTime>=\"2020-11-04T18:54:47Z\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId] (advertisers-insertionOrders-list advertiserId nil))
  ([advertiserId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders",
       :uri-template-args {:advertiserId advertiserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-insertionOrders-create
  "Creates a new insertion order. Returns the newly created insertion order if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the insertion order belongs to.
InsertionOrder:
{:insertionOrderId string,
 :partnerCosts
 [{:costType
   [PARTNER_COST_TYPE_UNSPECIFIED
    PARTNER_COST_TYPE_ADLOOX
    PARTNER_COST_TYPE_ADLOOX_PREBID
    PARTNER_COST_TYPE_ADSAFE
    PARTNER_COST_TYPE_ADXPOSE
    PARTNER_COST_TYPE_AGGREGATE_KNOWLEDGE
    PARTNER_COST_TYPE_AGENCY_TRADING_DESK
    PARTNER_COST_TYPE_DV360_FEE
    PARTNER_COST_TYPE_COMSCORE_VCE
    PARTNER_COST_TYPE_DATA_MANAGEMENT_PLATFORM
    PARTNER_COST_TYPE_DEFAULT
    PARTNER_COST_TYPE_DOUBLE_VERIFY
    PARTNER_COST_TYPE_DOUBLE_VERIFY_PREBID
    PARTNER_COST_TYPE_EVIDON
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_VIDEO
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_PREBID
    PARTNER_COST_TYPE_MEDIA_COST_DATA
    PARTNER_COST_TYPE_MOAT_VIDEO
    PARTNER_COST_TYPE_NIELSEN_DAR
    PARTNER_COST_TYPE_SHOP_LOCAL
    PARTNER_COST_TYPE_TERACENT
    PARTNER_COST_TYPE_THIRD_PARTY_AD_SERVER
    PARTNER_COST_TYPE_TRUST_METRICS
    PARTNER_COST_TYPE_VIZU
    PARTNER_COST_TYPE_ADLINGO_FEE
    PARTNER_COST_TYPE_CUSTOM_FEE_1
    PARTNER_COST_TYPE_CUSTOM_FEE_2
    PARTNER_COST_TYPE_CUSTOM_FEE_3
    PARTNER_COST_TYPE_CUSTOM_FEE_4
    PARTNER_COST_TYPE_CUSTOM_FEE_5
    PARTNER_COST_TYPE_SCIBIDS_FEE],
   :feeType
   [PARTNER_COST_FEE_TYPE_UNSPECIFIED
    PARTNER_COST_FEE_TYPE_CPM_FEE
    PARTNER_COST_FEE_TYPE_MEDIA_FEE],
   :feeAmount string,
   :feePercentageMillis string,
   :invoiceType
   [PARTNER_COST_INVOICE_TYPE_UNSPECIFIED
    PARTNER_COST_INVOICE_TYPE_DV360
    PARTNER_COST_INVOICE_TYPE_PARTNER]}],
 :kpi
 {:kpiType
  [KPI_TYPE_UNSPECIFIED
   KPI_TYPE_CPM
   KPI_TYPE_CPC
   KPI_TYPE_CPA
   KPI_TYPE_CTR
   KPI_TYPE_VIEWABILITY
   KPI_TYPE_CPIAVC
   KPI_TYPE_CPE
   KPI_TYPE_CPV
   KPI_TYPE_CLICK_CVR
   KPI_TYPE_IMPRESSION_CVR
   KPI_TYPE_VCPM
   KPI_TYPE_VTR
   KPI_TYPE_AUDIO_COMPLETION_RATE
   KPI_TYPE_VIDEO_COMPLETION_RATE
   KPI_TYPE_CPCL
   KPI_TYPE_CPCV
   KPI_TYPE_TOS10
   KPI_TYPE_MAXIMIZE_PACING
   KPI_TYPE_CUSTOM_IMPRESSION_VALUE_OVER_COST
   KPI_TYPE_OTHER],
  :kpiAmountMicros string,
  :kpiPercentageMicros string,
  :kpiString string,
  :kpiAlgorithmId string},
 :bidStrategy
 {:fixedBid {:bidAmountMicros string},
  :maximizeSpendAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :maxAverageCpmBidAmountMicros string,
   :raiseBidForDeals boolean,
   :customBiddingAlgorithmId string},
  :performanceGoalAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :performanceGoalAmountMicros string,
   :maxAverageCpmBidAmountMicros string,
   :customBiddingAlgorithmId string},
  :youtubeAndPartnersBid
  {:type
   [YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_UNSPECIFIED
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPA
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_RESERVE_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_LIFT
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSIONS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_ROAS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSION_VALUE],
   :value string,
   :adGroupEffectiveTargetCpaValue string,
   :adGroupEffectiveTargetCpaSource
   [BIDDING_SOURCE_UNSPECIFIED
    BIDDING_SOURCE_LINE_ITEM
    BIDDING_SOURCE_AD_GROUP]}},
 :displayName string,
 :name string,
 :campaignId string,
 :pacing
 {:pacingPeriod
  [PACING_PERIOD_UNSPECIFIED PACING_PERIOD_DAILY PACING_PERIOD_FLIGHT],
  :pacingType
  [PACING_TYPE_UNSPECIFIED
   PACING_TYPE_AHEAD
   PACING_TYPE_ASAP
   PACING_TYPE_EVEN],
  :dailyMaxMicros string,
  :dailyMaxImpressions string},
 :updateTime string,
 :frequencyCap
 {:unlimited boolean,
  :timeUnit
  [TIME_UNIT_UNSPECIFIED
   TIME_UNIT_LIFETIME
   TIME_UNIT_MONTHS
   TIME_UNIT_WEEKS
   TIME_UNIT_DAYS
   TIME_UNIT_HOURS
   TIME_UNIT_MINUTES],
  :timeUnitCount integer,
  :maxImpressions integer,
  :maxViews integer},
 :optimizationObjective
 [OPTIMIZATION_OBJECTIVE_UNSPECIFIED
  CONVERSION
  CLICK
  BRAND_AWARENESS
  CUSTOM
  NO_OBJECTIVE],
 :advertiserId string,
 :integrationDetails {:integrationCode string, :details string},
 :budget
 {:budgetUnit
  [BUDGET_UNIT_UNSPECIFIED
   BUDGET_UNIT_CURRENCY
   BUDGET_UNIT_IMPRESSIONS],
  :automationType
  [INSERTION_ORDER_AUTOMATION_TYPE_UNSPECIFIED
   INSERTION_ORDER_AUTOMATION_TYPE_BUDGET
   INSERTION_ORDER_AUTOMATION_TYPE_NONE
   INSERTION_ORDER_AUTOMATION_TYPE_BID_BUDGET],
  :budgetSegments
  [{:budgetAmountMicros string,
    :description string,
    :dateRange
    {:startDate {:year integer, :month integer, :day integer},
     :endDate {:year integer, :month integer, :day integer}},
    :campaignBudgetId string}]},
 :reservationType
 [RESERVATION_TYPE_UNSPECIFIED
  RESERVATION_TYPE_NOT_GUARANTEED
  RESERVATION_TYPE_PROGRAMMATIC_GUARANTEED
  RESERVATION_TYPE_TAG_GUARANTEED
  RESERVATION_TYPE_PETRA_VIRAL
  RESERVATION_TYPE_INSTANT_RESERVE],
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION],
 :insertionOrderType
 [INSERTION_ORDER_TYPE_UNSPECIFIED RTB OVER_THE_TOP]}"
  [advertiserId InsertionOrder]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders",
     :uri-template-args {:advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body InsertionOrder}))

(defn advertisers-insertionOrders-patch
  "Updates an existing insertion order. Returns the updated insertion order if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Output only. The unique ID of the advertiser the insertion order belongs to.
insertionOrderId <string> Output only. The unique ID of the insertion order. Assigned by the system.
InsertionOrder:
{:insertionOrderId string,
 :partnerCosts
 [{:costType
   [PARTNER_COST_TYPE_UNSPECIFIED
    PARTNER_COST_TYPE_ADLOOX
    PARTNER_COST_TYPE_ADLOOX_PREBID
    PARTNER_COST_TYPE_ADSAFE
    PARTNER_COST_TYPE_ADXPOSE
    PARTNER_COST_TYPE_AGGREGATE_KNOWLEDGE
    PARTNER_COST_TYPE_AGENCY_TRADING_DESK
    PARTNER_COST_TYPE_DV360_FEE
    PARTNER_COST_TYPE_COMSCORE_VCE
    PARTNER_COST_TYPE_DATA_MANAGEMENT_PLATFORM
    PARTNER_COST_TYPE_DEFAULT
    PARTNER_COST_TYPE_DOUBLE_VERIFY
    PARTNER_COST_TYPE_DOUBLE_VERIFY_PREBID
    PARTNER_COST_TYPE_EVIDON
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_VIDEO
    PARTNER_COST_TYPE_INTEGRAL_AD_SCIENCE_PREBID
    PARTNER_COST_TYPE_MEDIA_COST_DATA
    PARTNER_COST_TYPE_MOAT_VIDEO
    PARTNER_COST_TYPE_NIELSEN_DAR
    PARTNER_COST_TYPE_SHOP_LOCAL
    PARTNER_COST_TYPE_TERACENT
    PARTNER_COST_TYPE_THIRD_PARTY_AD_SERVER
    PARTNER_COST_TYPE_TRUST_METRICS
    PARTNER_COST_TYPE_VIZU
    PARTNER_COST_TYPE_ADLINGO_FEE
    PARTNER_COST_TYPE_CUSTOM_FEE_1
    PARTNER_COST_TYPE_CUSTOM_FEE_2
    PARTNER_COST_TYPE_CUSTOM_FEE_3
    PARTNER_COST_TYPE_CUSTOM_FEE_4
    PARTNER_COST_TYPE_CUSTOM_FEE_5
    PARTNER_COST_TYPE_SCIBIDS_FEE],
   :feeType
   [PARTNER_COST_FEE_TYPE_UNSPECIFIED
    PARTNER_COST_FEE_TYPE_CPM_FEE
    PARTNER_COST_FEE_TYPE_MEDIA_FEE],
   :feeAmount string,
   :feePercentageMillis string,
   :invoiceType
   [PARTNER_COST_INVOICE_TYPE_UNSPECIFIED
    PARTNER_COST_INVOICE_TYPE_DV360
    PARTNER_COST_INVOICE_TYPE_PARTNER]}],
 :kpi
 {:kpiType
  [KPI_TYPE_UNSPECIFIED
   KPI_TYPE_CPM
   KPI_TYPE_CPC
   KPI_TYPE_CPA
   KPI_TYPE_CTR
   KPI_TYPE_VIEWABILITY
   KPI_TYPE_CPIAVC
   KPI_TYPE_CPE
   KPI_TYPE_CPV
   KPI_TYPE_CLICK_CVR
   KPI_TYPE_IMPRESSION_CVR
   KPI_TYPE_VCPM
   KPI_TYPE_VTR
   KPI_TYPE_AUDIO_COMPLETION_RATE
   KPI_TYPE_VIDEO_COMPLETION_RATE
   KPI_TYPE_CPCL
   KPI_TYPE_CPCV
   KPI_TYPE_TOS10
   KPI_TYPE_MAXIMIZE_PACING
   KPI_TYPE_CUSTOM_IMPRESSION_VALUE_OVER_COST
   KPI_TYPE_OTHER],
  :kpiAmountMicros string,
  :kpiPercentageMicros string,
  :kpiString string,
  :kpiAlgorithmId string},
 :bidStrategy
 {:fixedBid {:bidAmountMicros string},
  :maximizeSpendAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :maxAverageCpmBidAmountMicros string,
   :raiseBidForDeals boolean,
   :customBiddingAlgorithmId string},
  :performanceGoalAutoBid
  {:performanceGoalType
   [BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_UNSPECIFIED
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CPC
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_VIEWABLE_CPM
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CUSTOM_ALGO
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_CIVA
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_IVO_TEN
    BIDDING_STRATEGY_PERFORMANCE_GOAL_TYPE_AV_VIEWED],
   :performanceGoalAmountMicros string,
   :maxAverageCpmBidAmountMicros string,
   :customBiddingAlgorithmId string},
  :youtubeAndPartnersBid
  {:type
   [YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_UNSPECIFIED
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MANUAL_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPA
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_RESERVE_CPM
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_LIFT
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSIONS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_CPV
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_TARGET_ROAS
    YOUTUBE_AND_PARTNERS_BIDDING_STRATEGY_TYPE_MAXIMIZE_CONVERSION_VALUE],
   :value string,
   :adGroupEffectiveTargetCpaValue string,
   :adGroupEffectiveTargetCpaSource
   [BIDDING_SOURCE_UNSPECIFIED
    BIDDING_SOURCE_LINE_ITEM
    BIDDING_SOURCE_AD_GROUP]}},
 :displayName string,
 :name string,
 :campaignId string,
 :pacing
 {:pacingPeriod
  [PACING_PERIOD_UNSPECIFIED PACING_PERIOD_DAILY PACING_PERIOD_FLIGHT],
  :pacingType
  [PACING_TYPE_UNSPECIFIED
   PACING_TYPE_AHEAD
   PACING_TYPE_ASAP
   PACING_TYPE_EVEN],
  :dailyMaxMicros string,
  :dailyMaxImpressions string},
 :updateTime string,
 :frequencyCap
 {:unlimited boolean,
  :timeUnit
  [TIME_UNIT_UNSPECIFIED
   TIME_UNIT_LIFETIME
   TIME_UNIT_MONTHS
   TIME_UNIT_WEEKS
   TIME_UNIT_DAYS
   TIME_UNIT_HOURS
   TIME_UNIT_MINUTES],
  :timeUnitCount integer,
  :maxImpressions integer,
  :maxViews integer},
 :optimizationObjective
 [OPTIMIZATION_OBJECTIVE_UNSPECIFIED
  CONVERSION
  CLICK
  BRAND_AWARENESS
  CUSTOM
  NO_OBJECTIVE],
 :advertiserId string,
 :integrationDetails {:integrationCode string, :details string},
 :budget
 {:budgetUnit
  [BUDGET_UNIT_UNSPECIFIED
   BUDGET_UNIT_CURRENCY
   BUDGET_UNIT_IMPRESSIONS],
  :automationType
  [INSERTION_ORDER_AUTOMATION_TYPE_UNSPECIFIED
   INSERTION_ORDER_AUTOMATION_TYPE_BUDGET
   INSERTION_ORDER_AUTOMATION_TYPE_NONE
   INSERTION_ORDER_AUTOMATION_TYPE_BID_BUDGET],
  :budgetSegments
  [{:budgetAmountMicros string,
    :description string,
    :dateRange
    {:startDate {:year integer, :month integer, :day integer},
     :endDate {:year integer, :month integer, :day integer}},
    :campaignBudgetId string}]},
 :reservationType
 [RESERVATION_TYPE_UNSPECIFIED
  RESERVATION_TYPE_NOT_GUARANTEED
  RESERVATION_TYPE_PROGRAMMATIC_GUARANTEED
  RESERVATION_TYPE_TAG_GUARANTEED
  RESERVATION_TYPE_PETRA_VIRAL
  RESERVATION_TYPE_INSTANT_RESERVE],
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION],
 :insertionOrderType
 [INSERTION_ORDER_TYPE_UNSPECIFIED RTB OVER_THE_TOP]}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([advertiserId insertionOrderId InsertionOrder]
    (advertisers-insertionOrders-patch
      advertiserId
      insertionOrderId
      InsertionOrder
      nil))
  ([advertiserId insertionOrderId InsertionOrder optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}",
       :uri-template-args
       {:advertiserId advertiserId,
        :insertionOrderId insertionOrderId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body InsertionOrder})))

(defn advertisers-insertionOrders-delete
  "Deletes an insertion order. Returns error code `NOT_FOUND` if the insertion order does not exist. The insertion order should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> The ID of the advertiser this insertion order belongs to.
insertionOrderId <string> The ID of the insertion order to delete."
  [advertiserId insertionOrderId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}",
     :uri-template-args
     {:advertiserId advertiserId, :insertionOrderId insertionOrderId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-insertionOrders-targetingTypes-assignedTargetingOptions-get
  "Gets a single targeting option assigned to an insertion order.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the insertion order belongs to.
insertionOrderId <string> Required. The ID of the insertion order the assigned targeting option belongs to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_AUDIO_CONTENT_TYPE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_BUSINESS_CHAIN` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_CONTENT_DURATION` * `TARGETING_TYPE_CONTENT_GENRE` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_STREAM_TYPE` * `TARGETING_TYPE_DAY_AND_TIME` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_POI` * `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` * `TARGETING_TYPE_REGIONAL_LOCATION_LIST` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_VIEWABILITY`
assignedTargetingOptionId <string> Required. An identifier unique to the targeting type in this insertion order that identifies the assigned targeting option being requested."
  [advertiserId
   insertionOrderId
   targetingType
   assignedTargetingOptionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :insertionOrderId insertionOrderId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn advertisers-insertionOrders-targetingTypes-assignedTargetingOptions-list
  "Lists the targeting options assigned to an insertion order.
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the insertion order belongs to.
insertionOrderId <string> Required. The ID of the insertion order to list assigned targeting options for.
targetingType <string> Required. Identifies the type of assigned targeting options to list. Supported targeting types include: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_APP` * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AUDIENCE_GROUP` * `TARGETING_TYPE_AUDIO_CONTENT_TYPE` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_BUSINESS_CHAIN` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_CONTENT_DURATION` * `TARGETING_TYPE_CONTENT_GENRE` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_STREAM_TYPE` * `TARGETING_TYPE_DAY_AND_TIME` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_INVENTORY_SOURCE` * `TARGETING_TYPE_INVENTORY_SOURCE_GROUP` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OMID` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_POI` * `TARGETING_TYPE_PROXIMITY_LOCATION_LIST` * `TARGETING_TYPE_REGIONAL_LOCATION_LIST` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_THIRD_PARTY_VERIFIER` * `TARGETING_TYPE_URL` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_VIEWABILITY`

optional:
pageSize <integer> Requested page size. Must be between `1` and `5000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `assignedTargetingOptionId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `assignedTargetingOptionId desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedTargetingOptionId` * `inheritance` Examples: * `AssignedTargetingOption` resources with ID 1 or 2: `assignedTargetingOptionId=\"1\" OR assignedTargetingOptionId=\"2\"` * `AssignedTargetingOption` resources with inheritance status of `NOT_INHERITED` or `INHERITED_FROM_PARTNER`: `inheritance=\"NOT_INHERITED\" OR inheritance=\"INHERITED_FROM_PARTNER\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([advertiserId insertionOrderId targetingType]
    (advertisers-insertionOrders-targetingTypes-assignedTargetingOptions-list
      advertiserId
      insertionOrderId
      targetingType
      nil))
  ([advertiserId insertionOrderId targetingType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
       :uri-template-args
       {:advertiserId advertiserId,
        :insertionOrderId insertionOrderId,
        :targetingType targetingType},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn advertisers-insertionOrders-targetingTypes-assignedTargetingOptions-create
  "Assigns a targeting option to an insertion order. Returns the assigned targeting option if successful. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_VIEWABILITY`
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the insertion order belongs to.
insertionOrderId <string> Required. The ID of the insertion order the assigned targeting option will belong to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_VIEWABILITY`
AssignedTargetingOption:
{:contentGenreDetails
 {:targetingOptionId string, :displayName string, :negative boolean},
 :negativeKeywordListDetails {:negativeKeywordListId string},
 :parentalStatusDetails
 {:parentalStatus
  [PARENTAL_STATUS_UNSPECIFIED
   PARENTAL_STATUS_PARENT
   PARENTAL_STATUS_NOT_A_PARENT
   PARENTAL_STATUS_UNKNOWN]},
 :geoRegionDetails
 {:displayName string,
  :targetingOptionId string,
  :geoRegionType
  [GEO_REGION_TYPE_UNKNOWN
   GEO_REGION_TYPE_OTHER
   GEO_REGION_TYPE_COUNTRY
   GEO_REGION_TYPE_REGION
   GEO_REGION_TYPE_TERRITORY
   GEO_REGION_TYPE_PROVINCE
   GEO_REGION_TYPE_STATE
   GEO_REGION_TYPE_PREFECTURE
   GEO_REGION_TYPE_GOVERNORATE
   GEO_REGION_TYPE_CANTON
   GEO_REGION_TYPE_UNION_TERRITORY
   GEO_REGION_TYPE_AUTONOMOUS_COMMUNITY
   GEO_REGION_TYPE_DMA_REGION
   GEO_REGION_TYPE_METRO
   GEO_REGION_TYPE_CONGRESSIONAL_DISTRICT
   GEO_REGION_TYPE_COUNTY
   GEO_REGION_TYPE_MUNICIPALITY
   GEO_REGION_TYPE_CITY
   GEO_REGION_TYPE_POSTAL_CODE
   GEO_REGION_TYPE_DEPARTMENT
   GEO_REGION_TYPE_AIRPORT
   GEO_REGION_TYPE_TV_REGION
   GEO_REGION_TYPE_OKRUG
   GEO_REGION_TYPE_BOROUGH
   GEO_REGION_TYPE_CITY_REGION
   GEO_REGION_TYPE_ARRONDISSEMENT
   GEO_REGION_TYPE_NEIGHBORHOOD
   GEO_REGION_TYPE_UNIVERSITY
   GEO_REGION_TYPE_DISTRICT],
  :negative boolean},
 :regionalLocationListDetails
 {:regionalLocationListId string, :negative boolean},
 :browserDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inventorySourceGroupDetails {:inventorySourceGroupId string},
 :nativeContentPositionDetails
 {:contentPosition
  [NATIVE_CONTENT_POSITION_UNSPECIFIED
   NATIVE_CONTENT_POSITION_UNKNOWN
   NATIVE_CONTENT_POSITION_IN_ARTICLE
   NATIVE_CONTENT_POSITION_IN_FEED
   NATIVE_CONTENT_POSITION_PERIPHERAL
   NATIVE_CONTENT_POSITION_RECOMMENDATION]},
 :assignedTargetingOptionId string,
 :operatingSystemDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :appCategoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :contentInstreamPositionDetails
 {:contentInstreamPosition
  [CONTENT_INSTREAM_POSITION_UNSPECIFIED
   CONTENT_INSTREAM_POSITION_PRE_ROLL
   CONTENT_INSTREAM_POSITION_MID_ROLL
   CONTENT_INSTREAM_POSITION_POST_ROLL
   CONTENT_INSTREAM_POSITION_UNKNOWN],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :inventorySourceDetails {:inventorySourceId string},
 :audioContentTypeDetails
 {:audioContentType
  [AUDIO_CONTENT_TYPE_UNSPECIFIED
   AUDIO_CONTENT_TYPE_UNKNOWN
   AUDIO_CONTENT_TYPE_MUSIC
   AUDIO_CONTENT_TYPE_BROADCAST
   AUDIO_CONTENT_TYPE_PODCAST]},
 :thirdPartyVerifierDetails
 {:adloox
  {:excludedAdlooxCategories
   [[ADLOOX_UNSPECIFIED
     ADULT_CONTENT_HARD
     ADULT_CONTENT_SOFT
     ILLEGAL_CONTENT
     BORDERLINE_CONTENT
     DISCRIMINATORY_CONTENT
     VIOLENT_CONTENT_WEAPONS
     LOW_VIEWABILITY_DOMAINS
     FRAUD]]},
  :doubleVerify
  {:brandSafetyCategories
   {:avoidUnknownBrandSafetyCategory boolean,
    :avoidedHighSeverityCategories
    [[HIGHER_SEVERITY_UNSPECIFIED
      ADULT_CONTENT_PORNOGRAPHY
      COPYRIGHT_INFRINGEMENT
      SUBSTANCE_ABUSE
      GRAPHIC_VIOLENCE_WEAPONS
      HATE_PROFANITY
      CRIMINAL_SKILLS
      NUISANCE_INCENTIVIZED_MALWARE_CLUTTER]],
    :avoidedMediumSeverityCategories
    [[MEDIUM_SEVERITY_UNSPECIFIED
      AD_SERVERS
      ADULT_CONTENT_SWIMSUIT
      ALTERNATIVE_LIFESTYLES
      CELEBRITY_GOSSIP
      GAMBLING
      OCCULT
      SEX_EDUCATION
      DISASTER_AVIATION
      DISASTER_MAN_MADE
      DISASTER_NATURAL
      DISASTER_TERRORIST_EVENTS
      DISASTER_VEHICLE
      ALCOHOL
      SMOKING
      NEGATIVE_NEWS_FINANCIAL
      NON_ENGLISH
      PARKING_PAGE
      UNMODERATED_UGC
      INFLAMMATORY_POLITICS_AND_NEWS
      NEGATIVE_NEWS_PHARMACEUTICAL]]},
   :avoidedAgeRatings
   [[AGE_RATING_UNSPECIFIED
     APP_AGE_RATE_UNKNOWN
     APP_AGE_RATE_4_PLUS
     APP_AGE_RATE_9_PLUS
     APP_AGE_RATE_12_PLUS
     APP_AGE_RATE_17_PLUS
     APP_AGE_RATE_18_PLUS]],
   :appStarRating
   {:avoidedStarRating
    [APP_STAR_RATE_UNSPECIFIED
     APP_STAR_RATE_1_POINT_5_LESS
     APP_STAR_RATE_2_LESS
     APP_STAR_RATE_2_POINT_5_LESS
     APP_STAR_RATE_3_LESS
     APP_STAR_RATE_3_POINT_5_LESS
     APP_STAR_RATE_4_LESS
     APP_STAR_RATE_4_POINT_5_LESS],
    :avoidInsufficientStarRating boolean},
   :displayViewability
   {:iab
    [IAB_VIEWED_RATE_UNSPECIFIED
     IAB_VIEWED_RATE_80_PERCENT_HIGHER
     IAB_VIEWED_RATE_75_PERCENT_HIGHER
     IAB_VIEWED_RATE_70_PERCENT_HIGHER
     IAB_VIEWED_RATE_65_PERCENT_HIGHER
     IAB_VIEWED_RATE_60_PERCENT_HIGHER
     IAB_VIEWED_RATE_55_PERCENT_HIGHER
     IAB_VIEWED_RATE_50_PERCENT_HIGHER
     IAB_VIEWED_RATE_40_PERCENT_HIGHER
     IAB_VIEWED_RATE_30_PERCENT_HIGHER],
    :viewableDuring
    [AVERAGE_VIEW_DURATION_UNSPECIFIED
     AVERAGE_VIEW_DURATION_5_SEC
     AVERAGE_VIEW_DURATION_10_SEC
     AVERAGE_VIEW_DURATION_15_SEC]},
   :videoViewability
   {:videoIab
    [VIDEO_IAB_UNSPECIFIED
     IAB_VIEWABILITY_80_PERCENT_HIGHER
     IAB_VIEWABILITY_75_PERCENT_HIGHER
     IAB_VIEWABILITY_70_PERCENT_HIGHER
     IAB_VIEWABILITY_65_PERCENT_HIHGER
     IAB_VIEWABILITY_60_PERCENT_HIGHER
     IAB_VIEWABILITY_55_PERCENT_HIHGER
     IAB_VIEWABILITY_50_PERCENT_HIGHER
     IAB_VIEWABILITY_40_PERCENT_HIHGER
     IAB_VIEWABILITY_30_PERCENT_HIHGER],
    :videoViewableRate
    [VIDEO_VIEWABLE_RATE_UNSPECIFIED
     VIEWED_PERFORMANCE_40_PERCENT_HIGHER
     VIEWED_PERFORMANCE_35_PERCENT_HIGHER
     VIEWED_PERFORMANCE_30_PERCENT_HIGHER
     VIEWED_PERFORMANCE_25_PERCENT_HIGHER
     VIEWED_PERFORMANCE_20_PERCENT_HIGHER
     VIEWED_PERFORMANCE_10_PERCENT_HIGHER],
    :playerImpressionRate
    [PLAYER_SIZE_400X300_UNSPECIFIED
     PLAYER_SIZE_400X300_95
     PLAYER_SIZE_400X300_70
     PLAYER_SIZE_400X300_25
     PLAYER_SIZE_400X300_5]},
   :fraudInvalidTraffic
   {:avoidedFraudOption
    [FRAUD_UNSPECIFIED
     AD_IMPRESSION_FRAUD_100
     AD_IMPRESSION_FRAUD_50
     AD_IMPRESSION_FRAUD_25
     AD_IMPRESSION_FRAUD_10
     AD_IMPRESSION_FRAUD_8
     AD_IMPRESSION_FRAUD_6
     AD_IMPRESSION_FRAUD_4
     AD_IMPRESSION_FRAUD_2],
    :avoidInsufficientOption boolean},
   :customSegmentId string},
  :integralAdScience
  {:excludedIllegalDownloadsRisk
   [ILLEGAL_DOWNLOADS_UNSPECIFIED
    ILLEGAL_DOWNLOADS_HR
    ILLEGAL_DOWNLOADS_HMR],
   :excludedOffensiveLanguageRisk
   [OFFENSIVE_LANGUAGE_UNSPECIFIED
    OFFENSIVE_LANGUAGE_HR
    OFFENSIVE_LANGUAGE_HMR],
   :excludeUnrateable boolean,
   :excludedDrugsRisk [DRUGS_UNSPECIFIED DRUGS_HR DRUGS_HMR],
   :excludedGamblingRisk
   [GAMBLING_UNSPECIFIED GAMBLING_HR GAMBLING_HMR],
   :excludedAdultRisk [ADULT_UNSPECIFIED ADULT_HR ADULT_HMR],
   :displayViewability
   [PERFORMANCE_VIEWABILITY_UNSPECIFIED
    PERFORMANCE_VIEWABILITY_40
    PERFORMANCE_VIEWABILITY_50
    PERFORMANCE_VIEWABILITY_60
    PERFORMANCE_VIEWABILITY_70],
   :excludedViolenceRisk
   [VIOLENCE_UNSPECIFIED VIOLENCE_HR VIOLENCE_HMR],
   :traqScoreOption
   [TRAQ_UNSPECIFIED
    TRAQ_250
    TRAQ_500
    TRAQ_600
    TRAQ_700
    TRAQ_750
    TRAQ_875
    TRAQ_1000],
   :excludedHateSpeechRisk
   [HATE_SPEECH_UNSPECIFIED HATE_SPEECH_HR HATE_SPEECH_HMR],
   :videoViewability
   [VIDEO_VIEWABILITY_UNSPECIFIED
    VIDEO_VIEWABILITY_40
    VIDEO_VIEWABILITY_50
    VIDEO_VIEWABILITY_60
    VIDEO_VIEWABILITY_70],
   :excludedAdFraudRisk
   [SUSPICIOUS_ACTIVITY_UNSPECIFIED
    SUSPICIOUS_ACTIVITY_HR
    SUSPICIOUS_ACTIVITY_HMR],
   :customSegmentId [string],
   :excludedAlcoholRisk [ALCOHOL_UNSPECIFIED ALCOHOL_HR ALCOHOL_HMR]}},
 :name string,
 :onScreenPositionDetails
 {:targetingOptionId string,
  :onScreenPosition
  [ON_SCREEN_POSITION_UNSPECIFIED
   ON_SCREEN_POSITION_UNKNOWN
   ON_SCREEN_POSITION_ABOVE_THE_FOLD
   ON_SCREEN_POSITION_BELOW_THE_FOLD],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :videoPlayerSizeDetails
 {:videoPlayerSize
  [VIDEO_PLAYER_SIZE_UNSPECIFIED
   VIDEO_PLAYER_SIZE_SMALL
   VIDEO_PLAYER_SIZE_LARGE
   VIDEO_PLAYER_SIZE_HD
   VIDEO_PLAYER_SIZE_UNKNOWN]},
 :carrierAndIspDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :proximityLocationListDetails
 {:proximityLocationListId string,
  :proximityRadius number,
  :proximityRadiusUnit
  [PROXIMITY_RADIUS_UNIT_UNSPECIFIED
   PROXIMITY_RADIUS_UNIT_MILES
   PROXIMITY_RADIUS_UNIT_KILOMETERS]},
 :contentStreamTypeDetails
 {:targetingOptionId string,
  :contentStreamType
  [CONTENT_STREAM_TYPE_UNSPECIFIED
   CONTENT_LIVE_STREAM
   CONTENT_ON_DEMAND]},
 :digitalContentLabelExclusionDetails
 {:excludedContentRatingTier
  [CONTENT_RATING_TIER_UNSPECIFIED
   CONTENT_RATING_TIER_UNRATED
   CONTENT_RATING_TIER_GENERAL
   CONTENT_RATING_TIER_PARENTAL_GUIDANCE
   CONTENT_RATING_TIER_TEENS
   CONTENT_RATING_TIER_MATURE
   CONTENT_RATING_TIER_FAMILIES]},
 :ageRangeDetails
 {:ageRange
  [AGE_RANGE_UNSPECIFIED
   AGE_RANGE_18_24
   AGE_RANGE_25_34
   AGE_RANGE_35_44
   AGE_RANGE_45_54
   AGE_RANGE_55_64
   AGE_RANGE_65_PLUS
   AGE_RANGE_UNKNOWN
   AGE_RANGE_18_20
   AGE_RANGE_21_24
   AGE_RANGE_25_29
   AGE_RANGE_30_34
   AGE_RANGE_35_39
   AGE_RANGE_40_44
   AGE_RANGE_45_49
   AGE_RANGE_50_54
   AGE_RANGE_55_59
   AGE_RANGE_60_64]},
 :deviceMakeModelDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :categoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inheritance
 [INHERITANCE_UNSPECIFIED
  NOT_INHERITED
  INHERITED_FROM_PARTNER
  INHERITED_FROM_ADVERTISER],
 :businessChainDetails
 {:displayName string,
  :targetingOptionId string,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :audienceGroupDetails
 {:includedFirstAndThirdPartyAudienceGroups
  [{:settings
    [{:firstAndThirdPartyAudienceId string,
      :recency
      [RECENCY_NO_LIMIT
       RECENCY_1_MINUTE
       RECENCY_5_MINUTES
       RECENCY_10_MINUTES
       RECENCY_15_MINUTES
       RECENCY_30_MINUTES
       RECENCY_1_HOUR
       RECENCY_2_HOURS
       RECENCY_3_HOURS
       RECENCY_6_HOURS
       RECENCY_12_HOURS
       RECENCY_1_DAY
       RECENCY_2_DAYS
       RECENCY_3_DAYS
       RECENCY_5_DAYS
       RECENCY_7_DAYS
       RECENCY_10_DAYS
       RECENCY_14_DAYS
       RECENCY_15_DAYS
       RECENCY_21_DAYS
       RECENCY_28_DAYS
       RECENCY_30_DAYS
       RECENCY_40_DAYS
       RECENCY_45_DAYS
       RECENCY_60_DAYS
       RECENCY_90_DAYS
       RECENCY_120_DAYS
       RECENCY_180_DAYS
       RECENCY_270_DAYS
       RECENCY_365_DAYS]}]}],
  :includedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]},
  :includedCustomListGroup {:settings [{:customListId string}]},
  :includedCombinedAudienceGroup
  {:settings [{:combinedAudienceId string}]},
  :excludedFirstAndThirdPartyAudienceGroup
  {:settings
   [{:firstAndThirdPartyAudienceId string,
     :recency
     [RECENCY_NO_LIMIT
      RECENCY_1_MINUTE
      RECENCY_5_MINUTES
      RECENCY_10_MINUTES
      RECENCY_15_MINUTES
      RECENCY_30_MINUTES
      RECENCY_1_HOUR
      RECENCY_2_HOURS
      RECENCY_3_HOURS
      RECENCY_6_HOURS
      RECENCY_12_HOURS
      RECENCY_1_DAY
      RECENCY_2_DAYS
      RECENCY_3_DAYS
      RECENCY_5_DAYS
      RECENCY_7_DAYS
      RECENCY_10_DAYS
      RECENCY_14_DAYS
      RECENCY_15_DAYS
      RECENCY_21_DAYS
      RECENCY_28_DAYS
      RECENCY_30_DAYS
      RECENCY_40_DAYS
      RECENCY_45_DAYS
      RECENCY_60_DAYS
      RECENCY_90_DAYS
      RECENCY_120_DAYS
      RECENCY_180_DAYS
      RECENCY_270_DAYS
      RECENCY_365_DAYS]}]},
  :excludedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]}},
 :channelDetails {:channelId string, :negative boolean},
 :contentDurationDetails
 {:targetingOptionId string,
  :contentDuration
  [CONTENT_DURATION_UNSPECIFIED
   CONTENT_DURATION_UNKNOWN
   CONTENT_DURATION_0_TO_1_MIN
   CONTENT_DURATION_1_TO_5_MIN
   CONTENT_DURATION_5_TO_15_MIN
   CONTENT_DURATION_15_TO_30_MIN
   CONTENT_DURATION_30_TO_60_MIN
   CONTENT_DURATION_OVER_60_MIN]},
 :targetingType
 [TARGETING_TYPE_UNSPECIFIED
  TARGETING_TYPE_CHANNEL
  TARGETING_TYPE_APP_CATEGORY
  TARGETING_TYPE_APP
  TARGETING_TYPE_URL
  TARGETING_TYPE_DAY_AND_TIME
  TARGETING_TYPE_AGE_RANGE
  TARGETING_TYPE_REGIONAL_LOCATION_LIST
  TARGETING_TYPE_PROXIMITY_LOCATION_LIST
  TARGETING_TYPE_GENDER
  TARGETING_TYPE_VIDEO_PLAYER_SIZE
  TARGETING_TYPE_USER_REWARDED_CONTENT
  TARGETING_TYPE_PARENTAL_STATUS
  TARGETING_TYPE_CONTENT_INSTREAM_POSITION
  TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
  TARGETING_TYPE_DEVICE_TYPE
  TARGETING_TYPE_AUDIENCE_GROUP
  TARGETING_TYPE_BROWSER
  TARGETING_TYPE_HOUSEHOLD_INCOME
  TARGETING_TYPE_ON_SCREEN_POSITION
  TARGETING_TYPE_THIRD_PARTY_VERIFIER
  TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
  TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
  TARGETING_TYPE_ENVIRONMENT
  TARGETING_TYPE_CARRIER_AND_ISP
  TARGETING_TYPE_OPERATING_SYSTEM
  TARGETING_TYPE_DEVICE_MAKE_MODEL
  TARGETING_TYPE_KEYWORD
  TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
  TARGETING_TYPE_VIEWABILITY
  TARGETING_TYPE_CATEGORY
  TARGETING_TYPE_INVENTORY_SOURCE
  TARGETING_TYPE_LANGUAGE
  TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
  TARGETING_TYPE_GEO_REGION
  TARGETING_TYPE_INVENTORY_SOURCE_GROUP
  TARGETING_TYPE_EXCHANGE
  TARGETING_TYPE_SUB_EXCHANGE
  TARGETING_TYPE_POI
  TARGETING_TYPE_BUSINESS_CHAIN
  TARGETING_TYPE_CONTENT_DURATION
  TARGETING_TYPE_CONTENT_STREAM_TYPE
  TARGETING_TYPE_NATIVE_CONTENT_POSITION
  TARGETING_TYPE_OMID
  TARGETING_TYPE_AUDIO_CONTENT_TYPE
  TARGETING_TYPE_CONTENT_GENRE
  TARGETING_TYPE_YOUTUBE_VIDEO
  TARGETING_TYPE_YOUTUBE_CHANNEL
  TARGETING_TYPE_SESSION_POSITION],
 :environmentDetails
 {:environment
  [ENVIRONMENT_UNSPECIFIED
   ENVIRONMENT_WEB_OPTIMIZED
   ENVIRONMENT_WEB_NOT_OPTIMIZED
   ENVIRONMENT_APP]},
 :poiDetails
 {:displayName string,
  :targetingOptionId string,
  :latitude number,
  :longitude number,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :sensitiveCategoryExclusionDetails
 {:excludedSensitiveCategory
  [SENSITIVE_CATEGORY_UNSPECIFIED
   SENSITIVE_CATEGORY_ADULT
   SENSITIVE_CATEGORY_DEROGATORY
   SENSITIVE_CATEGORY_DOWNLOADS_SHARING
   SENSITIVE_CATEGORY_WEAPONS
   SENSITIVE_CATEGORY_GAMBLING
   SENSITIVE_CATEGORY_VIOLENCE
   SENSITIVE_CATEGORY_SUGGESTIVE
   SENSITIVE_CATEGORY_PROFANITY
   SENSITIVE_CATEGORY_ALCOHOL
   SENSITIVE_CATEGORY_DRUGS
   SENSITIVE_CATEGORY_TOBACCO
   SENSITIVE_CATEGORY_POLITICS
   SENSITIVE_CATEGORY_RELIGION
   SENSITIVE_CATEGORY_TRAGEDY
   SENSITIVE_CATEGORY_TRANSPORTATION_ACCIDENTS
   SENSITIVE_CATEGORY_SENSITIVE_SOCIAL_ISSUES
   SENSITIVE_CATEGORY_SHOCKING
   SENSITIVE_CATEGORY_EMBEDDED_VIDEO
   SENSITIVE_CATEGORY_LIVE_STREAMING_VIDEO]},
 :youtubeVideoDetails {:videoId string, :negative boolean},
 :sessionPositionDetails
 {:sessionPosition
  [SESSION_POSITION_UNSPECIFIED SESSION_POSITION_FIRST_IMPRESSION]},
 :deviceTypeDetails
 {:deviceType
  [DEVICE_TYPE_UNSPECIFIED
   DEVICE_TYPE_COMPUTER
   DEVICE_TYPE_CONNECTED_TV
   DEVICE_TYPE_SMART_PHONE
   DEVICE_TYPE_TABLET],
  :youtubeAndPartnersBidMultiplier number},
 :appDetails
 {:appId string,
  :displayName string,
  :negative boolean,
  :appPlatform
  [APP_PLATFORM_UNSPECIFIED
   APP_PLATFORM_IOS
   APP_PLATFORM_ANDROID
   APP_PLATFORM_ROKU
   APP_PLATFORM_AMAZON_FIRETV
   APP_PLATFORM_PLAYSTATION
   APP_PLATFORM_APPLE_TV
   APP_PLATFORM_XBOX
   APP_PLATFORM_SAMSUNG_TV
   APP_PLATFORM_ANDROID_TV
   APP_PLATFORM_GENERIC_CTV
   APP_PLATFORM_LG_TV
   APP_PLATFORM_VIZIO_TV]},
 :subExchangeDetails {:targetingOptionId string},
 :genderDetails
 {:gender
  [GENDER_UNSPECIFIED GENDER_MALE GENDER_FEMALE GENDER_UNKNOWN]},
 :languageDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :viewabilityDetails
 {:viewability
  [VIEWABILITY_UNSPECIFIED
   VIEWABILITY_10_PERCENT_OR_MORE
   VIEWABILITY_20_PERCENT_OR_MORE
   VIEWABILITY_30_PERCENT_OR_MORE
   VIEWABILITY_40_PERCENT_OR_MORE
   VIEWABILITY_50_PERCENT_OR_MORE
   VIEWABILITY_60_PERCENT_OR_MORE
   VIEWABILITY_70_PERCENT_OR_MORE
   VIEWABILITY_80_PERCENT_OR_MORE
   VIEWABILITY_90_PERCENT_OR_MORE]},
 :assignedTargetingOptionIdAlias string,
 :keywordDetails {:keyword string, :negative boolean},
 :urlDetails {:url string, :negative boolean},
 :exchangeDetails
 {:exchange
  [EXCHANGE_UNSPECIFIED
   EXCHANGE_GOOGLE_AD_MANAGER
   EXCHANGE_APPNEXUS
   EXCHANGE_BRIGHTROLL
   EXCHANGE_ADFORM
   EXCHANGE_ADMETA
   EXCHANGE_ADMIXER
   EXCHANGE_ADSMOGO
   EXCHANGE_ADSWIZZ
   EXCHANGE_BIDSWITCH
   EXCHANGE_BRIGHTROLL_DISPLAY
   EXCHANGE_CADREON
   EXCHANGE_DAILYMOTION
   EXCHANGE_FIVE
   EXCHANGE_FLUCT
   EXCHANGE_FREEWHEEL
   EXCHANGE_GENIEE
   EXCHANGE_GUMGUM
   EXCHANGE_IMOBILE
   EXCHANGE_IBILLBOARD
   EXCHANGE_IMPROVE_DIGITAL
   EXCHANGE_INDEX
   EXCHANGE_KARGO
   EXCHANGE_MICROAD
   EXCHANGE_MOPUB
   EXCHANGE_NEND
   EXCHANGE_ONE_BY_AOL_DISPLAY
   EXCHANGE_ONE_BY_AOL_MOBILE
   EXCHANGE_ONE_BY_AOL_VIDEO
   EXCHANGE_OOYALA
   EXCHANGE_OPENX
   EXCHANGE_PERMODO
   EXCHANGE_PLATFORMONE
   EXCHANGE_PLATFORMID
   EXCHANGE_PUBMATIC
   EXCHANGE_PULSEPOINT
   EXCHANGE_REVENUEMAX
   EXCHANGE_RUBICON
   EXCHANGE_SMARTCLIP
   EXCHANGE_SMARTRTB
   EXCHANGE_SMARTSTREAMTV
   EXCHANGE_SOVRN
   EXCHANGE_SPOTXCHANGE
   EXCHANGE_STROER
   EXCHANGE_TEADSTV
   EXCHANGE_TELARIA
   EXCHANGE_TVN
   EXCHANGE_UNITED
   EXCHANGE_YIELDLAB
   EXCHANGE_YIELDMO
   EXCHANGE_UNRULYX
   EXCHANGE_OPEN8
   EXCHANGE_TRITON
   EXCHANGE_TRIPLELIFT
   EXCHANGE_TABOOLA
   EXCHANGE_INMOBI
   EXCHANGE_SMAATO
   EXCHANGE_AJA
   EXCHANGE_SUPERSHIP
   EXCHANGE_NEXSTAR_DIGITAL
   EXCHANGE_WAZE
   EXCHANGE_SOUNDCAST
   EXCHANGE_SHARETHROUGH
   EXCHANGE_FYBER
   EXCHANGE_RED_FOR_PUBLISHERS
   EXCHANGE_MEDIANET
   EXCHANGE_TAPJOY
   EXCHANGE_VISTAR
   EXCHANGE_DAX
   EXCHANGE_JCD
   EXCHANGE_PLACE_EXCHANGE
   EXCHANGE_APPLOVIN
   EXCHANGE_CONNATIX
   EXCHANGE_RESET_DIGITAL
   EXCHANGE_HIVESTACK
   EXCHANGE_DRAX
   EXCHANGE_APPLOVIN_GBID
   EXCHANGE_FYBER_GBID
   EXCHANGE_UNITY_GBID
   EXCHANGE_CHARTBOOST_GBID
   EXCHANGE_ADMOST_GBID
   EXCHANGE_TOPON_GBID]},
 :dayAndTimeDetails
 {:dayOfWeek
  [DAY_OF_WEEK_UNSPECIFIED
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY],
  :startHour integer,
  :endHour integer,
  :timeZoneResolution
  [TIME_ZONE_RESOLUTION_UNSPECIFIED
   TIME_ZONE_RESOLUTION_END_USER
   TIME_ZONE_RESOLUTION_ADVERTISER]},
 :householdIncomeDetails
 {:householdIncome
  [HOUSEHOLD_INCOME_UNSPECIFIED
   HOUSEHOLD_INCOME_UNKNOWN
   HOUSEHOLD_INCOME_LOWER_50_PERCENT
   HOUSEHOLD_INCOME_TOP_41_TO_50_PERCENT
   HOUSEHOLD_INCOME_TOP_31_TO_40_PERCENT
   HOUSEHOLD_INCOME_TOP_21_TO_30_PERCENT
   HOUSEHOLD_INCOME_TOP_11_TO_20_PERCENT
   HOUSEHOLD_INCOME_TOP_10_PERCENT]},
 :authorizedSellerStatusDetails
 {:authorizedSellerStatus
  [AUTHORIZED_SELLER_STATUS_UNSPECIFIED
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_DIRECT_SELLERS_ONLY
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_AND_NON_PARTICIPATING_PUBLISHERS],
  :targetingOptionId string},
 :contentOutstreamPositionDetails
 {:contentOutstreamPosition
  [CONTENT_OUTSTREAM_POSITION_UNSPECIFIED
   CONTENT_OUTSTREAM_POSITION_UNKNOWN
   CONTENT_OUTSTREAM_POSITION_IN_ARTICLE
   CONTENT_OUTSTREAM_POSITION_IN_BANNER
   CONTENT_OUTSTREAM_POSITION_IN_FEED
   CONTENT_OUTSTREAM_POSITION_INTERSTITIAL],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :youtubeChannelDetails {:channelId string, :negative boolean},
 :userRewardedContentDetails
 {:targetingOptionId string,
  :userRewardedContent
  [USER_REWARDED_CONTENT_UNSPECIFIED
   USER_REWARDED_CONTENT_USER_REWARDED
   USER_REWARDED_CONTENT_NOT_USER_REWARDED]},
 :omidDetails {:omid [OMID_UNSPECIFIED OMID_FOR_MOBILE_DISPLAY_ADS]}}"
  [advertiserId insertionOrderId targetingType AssignedTargetingOption]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
     :uri-template-args
     {:advertiserId advertiserId,
      :insertionOrderId insertionOrderId,
      :targetingType targetingType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body AssignedTargetingOption}))

(defn advertisers-insertionOrders-targetingTypes-assignedTargetingOptions-delete
  "Deletes an assigned targeting option from an insertion order. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_VIEWABILITY`
https://developers.google.com/display-video/api/guides/getting-started/overview

advertiserId <string> Required. The ID of the advertiser the insertion order belongs to.
insertionOrderId <string> Required. The ID of the insertion order the assigned targeting option belongs to.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_VIEWABILITY`
assignedTargetingOptionId <string> Required. The ID of the assigned targeting option to delete."
  [advertiserId
   insertionOrderId
   targetingType
   assignedTargetingOptionId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:advertiserId advertiserId,
      :insertionOrderId insertionOrderId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn customLists-get
  "Gets a custom list.
https://developers.google.com/display-video/api/guides/getting-started/overview

customListId <string> Required. The ID of the custom list to fetch.

optional:
advertiserId <string> The ID of the DV360 advertiser that has access to the fetched custom lists."
  ([customListId] (customLists-get customListId nil))
  ([customListId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customLists/{+customListId}",
       :uri-template-args {:customListId customListId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customLists-list
  "Lists custom lists. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
advertiserId <string> The ID of the DV360 advertiser that has access to the fetched custom lists.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `customListId` (default) * `displayName` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by custom list fields. Supported syntax: * Filter expressions for custom lists can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `displayName` Examples: * All custom lists for which the display name contains \"Google\": `displayName:\"Google\"`. The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (customLists-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customLists",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySourceGroups-get
  "Gets an inventory source group.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceGroupId <string> Required. The ID of the inventory source group to fetch.

optional:
partnerId <string> The ID of the partner that has access to the inventory source group. A partner cannot access an advertiser-owned inventory source group.
advertiserId <string> The ID of the advertiser that has access to the inventory source group. If an inventory source group is partner-owned, only advertisers to which the group is explicitly shared can access the group."
  ([inventorySourceGroupId]
    (inventorySourceGroups-get inventorySourceGroupId nil))
  ([inventorySourceGroupId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups/{+inventorySourceGroupId}",
       :uri-template-args
       {:inventorySourceGroupId inventorySourceGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySourceGroups-list
  "Lists inventory source groups that are accessible to the current user. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> The ID of the partner that has access to the inventory source group. A partner cannot access advertiser-owned inventory source groups.
advertiserId <string> The ID of the advertiser that has access to the inventory source group. If an inventory source group is partner-owned, only advertisers to which the group is explicitly shared can access the group.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) * `inventorySourceGroupId` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. For example, `displayName desc`.
filter <string> Allows filtering by inventory source group fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `inventorySourceGroupId` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (inventorySourceGroups-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySourceGroups-create
  "Creates a new inventory source group. Returns the newly created inventory source group if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

InventorySourceGroup:
{:name string, :inventorySourceGroupId string, :displayName string}

optional:
partnerId <string> The ID of the partner that owns the inventory source group. Only this partner will have write access to this group. Only advertisers to which this group is explicitly shared will have read access to this group.
advertiserId <string> The ID of the advertiser that owns the inventory source group. The parent partner will not have access to this group."
  ([InventorySourceGroup]
    (inventorySourceGroups-create InventorySourceGroup nil))
  ([InventorySourceGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body InventorySourceGroup})))

(defn inventorySourceGroups-patch
  "Updates an inventory source group. Returns the updated inventory source group if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceGroupId <string> Output only. The unique ID of the inventory source group. Assigned by the system.
InventorySourceGroup:
{:name string, :inventorySourceGroupId string, :displayName string}

optional:
partnerId <string> The ID of the partner that owns the inventory source group. Only this partner has write access to this group.
advertiserId <string> The ID of the advertiser that owns the inventory source group. The parent partner does not have access to this group.
updateMask <string> Required. The mask to control which fields to update."
  ([inventorySourceGroupId InventorySourceGroup]
    (inventorySourceGroups-patch
      inventorySourceGroupId
      InventorySourceGroup
      nil))
  ([inventorySourceGroupId InventorySourceGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups/{inventorySourceGroupId}",
       :uri-template-args
       {:inventorySourceGroupId inventorySourceGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body InventorySourceGroup})))

(defn inventorySourceGroups-delete
  "Deletes an inventory source group.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceGroupId <string> Required. The ID of the inventory source group to delete.

optional:
partnerId <string> The ID of the partner that owns the inventory source group. Only this partner has write access to this group.
advertiserId <string> The ID of the advertiser that owns the inventory source group. The parent partner does not have access to this group."
  ([inventorySourceGroupId]
    (inventorySourceGroups-delete inventorySourceGroupId nil))
  ([inventorySourceGroupId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups/{+inventorySourceGroupId}",
       :uri-template-args
       {:inventorySourceGroupId inventorySourceGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySourceGroups-assignedInventorySources-list
  "Lists inventory sources assigned to an inventory source group.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceGroupId <string> Required. The ID of the inventory source group to which these assignments are assigned.

optional:
partnerId <string> The ID of the partner that has access to the assignment. If the parent inventory source group is advertiser-owned, the assignment cannot be accessed via a partner.
advertiserId <string> The ID of the advertiser that has access to the assignment. If the parent inventory source group is partner-owned, only advertisers to which the parent group is explicitly shared can access the assigned inventory source.
pageSize <integer> Requested page size. Must be between `1` and `100`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `assignedInventorySourceId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be added to the field name. Example: `assignedInventorySourceId desc`.
filter <string> Allows filtering by assigned inventory source fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the `OR` logical operator. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedInventorySourceId` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([inventorySourceGroupId]
    (inventorySourceGroups-assignedInventorySources-list
      inventorySourceGroupId
      nil))
  ([inventorySourceGroupId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources",
       :uri-template-args
       {:inventorySourceGroupId inventorySourceGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySourceGroups-assignedInventorySources-create
  "Creates an assignment between an inventory source and an inventory source group.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceGroupId <string> Required. The ID of the inventory source group to which the assignment will be assigned.
AssignedInventorySource:
{:name string,
 :assignedInventorySourceId string,
 :inventorySourceId string}

optional:
partnerId <string> The ID of the partner that owns the parent inventory source group. Only this partner will have write access to this assigned inventory source.
advertiserId <string> The ID of the advertiser that owns the parent inventory source group. The parent partner will not have access to this assigned inventory source."
  ([inventorySourceGroupId AssignedInventorySource]
    (inventorySourceGroups-assignedInventorySources-create
      inventorySourceGroupId
      AssignedInventorySource
      nil))
  ([inventorySourceGroupId AssignedInventorySource optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources",
       :uri-template-args
       {:inventorySourceGroupId inventorySourceGroupId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body AssignedInventorySource})))

(defn inventorySourceGroups-assignedInventorySources-delete
  "Deletes the assignment between an inventory source and an inventory source group.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceGroupId <string> Required. The ID of the inventory source group to which this assignment is assigned.
assignedInventorySourceId <string> Required. The ID of the assigned inventory source to delete.

optional:
partnerId <string> The ID of the partner that owns the parent inventory source group. Only this partner has write access to this assigned inventory source.
advertiserId <string> The ID of the advertiser that owns the parent inventory source group. The parent partner does not have access to this assigned inventory source."
  ([inventorySourceGroupId assignedInventorySourceId]
    (inventorySourceGroups-assignedInventorySources-delete
      inventorySourceGroupId
      assignedInventorySourceId
      nil))
  ([inventorySourceGroupId assignedInventorySourceId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://displayvideo.googleapis.com/v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources/{+assignedInventorySourceId}",
       :uri-template-args
       {:inventorySourceGroupId inventorySourceGroupId,
        :assignedInventorySourceId assignedInventorySourceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn inventorySourceGroups-assignedInventorySources-bulkEdit
  "Bulk edits multiple assignments between inventory sources and a single inventory source group. The operation will delete the assigned inventory sources provided in BulkEditAssignedInventorySourcesRequest.deleted_assigned_inventory_sources and then create the assigned inventory sources provided in BulkEditAssignedInventorySourcesRequest.created_assigned_inventory_sources.
https://developers.google.com/display-video/api/guides/getting-started/overview

inventorySourceGroupId <string> Required. The ID of the inventory source group to which the assignments are assigned.
BulkEditAssignedInventorySourcesRequest:
{:partnerId string,
 :advertiserId string,
 :deletedAssignedInventorySources [string],
 :createdAssignedInventorySources
 [{:name string,
   :assignedInventorySourceId string,
   :inventorySourceId string}]}"
  [inventorySourceGroupId BulkEditAssignedInventorySourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources:bulkEdit",
     :uri-template-args
     {:inventorySourceGroupId inventorySourceGroupId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditAssignedInventorySourcesRequest}))

(defn partners-editAssignedTargetingOptions
  "Edits targeting options under a single partner. The operation will delete the assigned targeting options provided in BulkEditPartnerAssignedTargetingOptionsRequest.deleteRequests and then create the assigned targeting options provided in BulkEditPartnerAssignedTargetingOptionsRequest.createRequests .
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> Required. The ID of the partner.
BulkEditPartnerAssignedTargetingOptionsRequest:
{:deleteRequests
 [{:targetingType
   [TARGETING_TYPE_UNSPECIFIED
    TARGETING_TYPE_CHANNEL
    TARGETING_TYPE_APP_CATEGORY
    TARGETING_TYPE_APP
    TARGETING_TYPE_URL
    TARGETING_TYPE_DAY_AND_TIME
    TARGETING_TYPE_AGE_RANGE
    TARGETING_TYPE_REGIONAL_LOCATION_LIST
    TARGETING_TYPE_PROXIMITY_LOCATION_LIST
    TARGETING_TYPE_GENDER
    TARGETING_TYPE_VIDEO_PLAYER_SIZE
    TARGETING_TYPE_USER_REWARDED_CONTENT
    TARGETING_TYPE_PARENTAL_STATUS
    TARGETING_TYPE_CONTENT_INSTREAM_POSITION
    TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
    TARGETING_TYPE_DEVICE_TYPE
    TARGETING_TYPE_AUDIENCE_GROUP
    TARGETING_TYPE_BROWSER
    TARGETING_TYPE_HOUSEHOLD_INCOME
    TARGETING_TYPE_ON_SCREEN_POSITION
    TARGETING_TYPE_THIRD_PARTY_VERIFIER
    TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
    TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
    TARGETING_TYPE_ENVIRONMENT
    TARGETING_TYPE_CARRIER_AND_ISP
    TARGETING_TYPE_OPERATING_SYSTEM
    TARGETING_TYPE_DEVICE_MAKE_MODEL
    TARGETING_TYPE_KEYWORD
    TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
    TARGETING_TYPE_VIEWABILITY
    TARGETING_TYPE_CATEGORY
    TARGETING_TYPE_INVENTORY_SOURCE
    TARGETING_TYPE_LANGUAGE
    TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
    TARGETING_TYPE_GEO_REGION
    TARGETING_TYPE_INVENTORY_SOURCE_GROUP
    TARGETING_TYPE_EXCHANGE
    TARGETING_TYPE_SUB_EXCHANGE
    TARGETING_TYPE_POI
    TARGETING_TYPE_BUSINESS_CHAIN
    TARGETING_TYPE_CONTENT_DURATION
    TARGETING_TYPE_CONTENT_STREAM_TYPE
    TARGETING_TYPE_NATIVE_CONTENT_POSITION
    TARGETING_TYPE_OMID
    TARGETING_TYPE_AUDIO_CONTENT_TYPE
    TARGETING_TYPE_CONTENT_GENRE
    TARGETING_TYPE_YOUTUBE_VIDEO
    TARGETING_TYPE_YOUTUBE_CHANNEL
    TARGETING_TYPE_SESSION_POSITION],
   :assignedTargetingOptionIds [string]}],
 :createRequests
 [{:targetingType
   [TARGETING_TYPE_UNSPECIFIED
    TARGETING_TYPE_CHANNEL
    TARGETING_TYPE_APP_CATEGORY
    TARGETING_TYPE_APP
    TARGETING_TYPE_URL
    TARGETING_TYPE_DAY_AND_TIME
    TARGETING_TYPE_AGE_RANGE
    TARGETING_TYPE_REGIONAL_LOCATION_LIST
    TARGETING_TYPE_PROXIMITY_LOCATION_LIST
    TARGETING_TYPE_GENDER
    TARGETING_TYPE_VIDEO_PLAYER_SIZE
    TARGETING_TYPE_USER_REWARDED_CONTENT
    TARGETING_TYPE_PARENTAL_STATUS
    TARGETING_TYPE_CONTENT_INSTREAM_POSITION
    TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
    TARGETING_TYPE_DEVICE_TYPE
    TARGETING_TYPE_AUDIENCE_GROUP
    TARGETING_TYPE_BROWSER
    TARGETING_TYPE_HOUSEHOLD_INCOME
    TARGETING_TYPE_ON_SCREEN_POSITION
    TARGETING_TYPE_THIRD_PARTY_VERIFIER
    TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
    TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
    TARGETING_TYPE_ENVIRONMENT
    TARGETING_TYPE_CARRIER_AND_ISP
    TARGETING_TYPE_OPERATING_SYSTEM
    TARGETING_TYPE_DEVICE_MAKE_MODEL
    TARGETING_TYPE_KEYWORD
    TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
    TARGETING_TYPE_VIEWABILITY
    TARGETING_TYPE_CATEGORY
    TARGETING_TYPE_INVENTORY_SOURCE
    TARGETING_TYPE_LANGUAGE
    TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
    TARGETING_TYPE_GEO_REGION
    TARGETING_TYPE_INVENTORY_SOURCE_GROUP
    TARGETING_TYPE_EXCHANGE
    TARGETING_TYPE_SUB_EXCHANGE
    TARGETING_TYPE_POI
    TARGETING_TYPE_BUSINESS_CHAIN
    TARGETING_TYPE_CONTENT_DURATION
    TARGETING_TYPE_CONTENT_STREAM_TYPE
    TARGETING_TYPE_NATIVE_CONTENT_POSITION
    TARGETING_TYPE_OMID
    TARGETING_TYPE_AUDIO_CONTENT_TYPE
    TARGETING_TYPE_CONTENT_GENRE
    TARGETING_TYPE_YOUTUBE_VIDEO
    TARGETING_TYPE_YOUTUBE_CHANNEL
    TARGETING_TYPE_SESSION_POSITION],
   :assignedTargetingOptions
   [{:contentGenreDetails
     {:targetingOptionId string,
      :displayName string,
      :negative boolean},
     :negativeKeywordListDetails {:negativeKeywordListId string},
     :parentalStatusDetails
     {:parentalStatus
      [PARENTAL_STATUS_UNSPECIFIED
       PARENTAL_STATUS_PARENT
       PARENTAL_STATUS_NOT_A_PARENT
       PARENTAL_STATUS_UNKNOWN]},
     :geoRegionDetails
     {:displayName string,
      :targetingOptionId string,
      :geoRegionType
      [GEO_REGION_TYPE_UNKNOWN
       GEO_REGION_TYPE_OTHER
       GEO_REGION_TYPE_COUNTRY
       GEO_REGION_TYPE_REGION
       GEO_REGION_TYPE_TERRITORY
       GEO_REGION_TYPE_PROVINCE
       GEO_REGION_TYPE_STATE
       GEO_REGION_TYPE_PREFECTURE
       GEO_REGION_TYPE_GOVERNORATE
       GEO_REGION_TYPE_CANTON
       GEO_REGION_TYPE_UNION_TERRITORY
       GEO_REGION_TYPE_AUTONOMOUS_COMMUNITY
       GEO_REGION_TYPE_DMA_REGION
       GEO_REGION_TYPE_METRO
       GEO_REGION_TYPE_CONGRESSIONAL_DISTRICT
       GEO_REGION_TYPE_COUNTY
       GEO_REGION_TYPE_MUNICIPALITY
       GEO_REGION_TYPE_CITY
       GEO_REGION_TYPE_POSTAL_CODE
       GEO_REGION_TYPE_DEPARTMENT
       GEO_REGION_TYPE_AIRPORT
       GEO_REGION_TYPE_TV_REGION
       GEO_REGION_TYPE_OKRUG
       GEO_REGION_TYPE_BOROUGH
       GEO_REGION_TYPE_CITY_REGION
       GEO_REGION_TYPE_ARRONDISSEMENT
       GEO_REGION_TYPE_NEIGHBORHOOD
       GEO_REGION_TYPE_UNIVERSITY
       GEO_REGION_TYPE_DISTRICT],
      :negative boolean},
     :regionalLocationListDetails
     {:regionalLocationListId string, :negative boolean},
     :browserDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :inventorySourceGroupDetails {:inventorySourceGroupId string},
     :nativeContentPositionDetails
     {:contentPosition
      [NATIVE_CONTENT_POSITION_UNSPECIFIED
       NATIVE_CONTENT_POSITION_UNKNOWN
       NATIVE_CONTENT_POSITION_IN_ARTICLE
       NATIVE_CONTENT_POSITION_IN_FEED
       NATIVE_CONTENT_POSITION_PERIPHERAL
       NATIVE_CONTENT_POSITION_RECOMMENDATION]},
     :assignedTargetingOptionId string,
     :operatingSystemDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :appCategoryDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :contentInstreamPositionDetails
     {:contentInstreamPosition
      [CONTENT_INSTREAM_POSITION_UNSPECIFIED
       CONTENT_INSTREAM_POSITION_PRE_ROLL
       CONTENT_INSTREAM_POSITION_MID_ROLL
       CONTENT_INSTREAM_POSITION_POST_ROLL
       CONTENT_INSTREAM_POSITION_UNKNOWN],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :inventorySourceDetails {:inventorySourceId string},
     :audioContentTypeDetails
     {:audioContentType
      [AUDIO_CONTENT_TYPE_UNSPECIFIED
       AUDIO_CONTENT_TYPE_UNKNOWN
       AUDIO_CONTENT_TYPE_MUSIC
       AUDIO_CONTENT_TYPE_BROADCAST
       AUDIO_CONTENT_TYPE_PODCAST]},
     :thirdPartyVerifierDetails
     {:adloox
      {:excludedAdlooxCategories
       [[ADLOOX_UNSPECIFIED
         ADULT_CONTENT_HARD
         ADULT_CONTENT_SOFT
         ILLEGAL_CONTENT
         BORDERLINE_CONTENT
         DISCRIMINATORY_CONTENT
         VIOLENT_CONTENT_WEAPONS
         LOW_VIEWABILITY_DOMAINS
         FRAUD]]},
      :doubleVerify
      {:brandSafetyCategories DoubleVerifyBrandSafetyCategories,
       :avoidedAgeRatings
       [[AGE_RATING_UNSPECIFIED
         APP_AGE_RATE_UNKNOWN
         APP_AGE_RATE_4_PLUS
         APP_AGE_RATE_9_PLUS
         APP_AGE_RATE_12_PLUS
         APP_AGE_RATE_17_PLUS
         APP_AGE_RATE_18_PLUS]],
       :appStarRating DoubleVerifyAppStarRating,
       :displayViewability DoubleVerifyDisplayViewability,
       :videoViewability DoubleVerifyVideoViewability,
       :fraudInvalidTraffic DoubleVerifyFraudInvalidTraffic,
       :customSegmentId string},
      :integralAdScience
      {:excludedIllegalDownloadsRisk
       [ILLEGAL_DOWNLOADS_UNSPECIFIED
        ILLEGAL_DOWNLOADS_HR
        ILLEGAL_DOWNLOADS_HMR],
       :excludedOffensiveLanguageRisk
       [OFFENSIVE_LANGUAGE_UNSPECIFIED
        OFFENSIVE_LANGUAGE_HR
        OFFENSIVE_LANGUAGE_HMR],
       :excludeUnrateable boolean,
       :excludedDrugsRisk [DRUGS_UNSPECIFIED DRUGS_HR DRUGS_HMR],
       :excludedGamblingRisk
       [GAMBLING_UNSPECIFIED GAMBLING_HR GAMBLING_HMR],
       :excludedAdultRisk [ADULT_UNSPECIFIED ADULT_HR ADULT_HMR],
       :displayViewability
       [PERFORMANCE_VIEWABILITY_UNSPECIFIED
        PERFORMANCE_VIEWABILITY_40
        PERFORMANCE_VIEWABILITY_50
        PERFORMANCE_VIEWABILITY_60
        PERFORMANCE_VIEWABILITY_70],
       :excludedViolenceRisk
       [VIOLENCE_UNSPECIFIED VIOLENCE_HR VIOLENCE_HMR],
       :traqScoreOption
       [TRAQ_UNSPECIFIED
        TRAQ_250
        TRAQ_500
        TRAQ_600
        TRAQ_700
        TRAQ_750
        TRAQ_875
        TRAQ_1000],
       :excludedHateSpeechRisk
       [HATE_SPEECH_UNSPECIFIED HATE_SPEECH_HR HATE_SPEECH_HMR],
       :videoViewability
       [VIDEO_VIEWABILITY_UNSPECIFIED
        VIDEO_VIEWABILITY_40
        VIDEO_VIEWABILITY_50
        VIDEO_VIEWABILITY_60
        VIDEO_VIEWABILITY_70],
       :excludedAdFraudRisk
       [SUSPICIOUS_ACTIVITY_UNSPECIFIED
        SUSPICIOUS_ACTIVITY_HR
        SUSPICIOUS_ACTIVITY_HMR],
       :customSegmentId [string],
       :excludedAlcoholRisk
       [ALCOHOL_UNSPECIFIED ALCOHOL_HR ALCOHOL_HMR]}},
     :name string,
     :onScreenPositionDetails
     {:targetingOptionId string,
      :onScreenPosition
      [ON_SCREEN_POSITION_UNSPECIFIED
       ON_SCREEN_POSITION_UNKNOWN
       ON_SCREEN_POSITION_ABOVE_THE_FOLD
       ON_SCREEN_POSITION_BELOW_THE_FOLD],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :videoPlayerSizeDetails
     {:videoPlayerSize
      [VIDEO_PLAYER_SIZE_UNSPECIFIED
       VIDEO_PLAYER_SIZE_SMALL
       VIDEO_PLAYER_SIZE_LARGE
       VIDEO_PLAYER_SIZE_HD
       VIDEO_PLAYER_SIZE_UNKNOWN]},
     :carrierAndIspDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :proximityLocationListDetails
     {:proximityLocationListId string,
      :proximityRadius number,
      :proximityRadiusUnit
      [PROXIMITY_RADIUS_UNIT_UNSPECIFIED
       PROXIMITY_RADIUS_UNIT_MILES
       PROXIMITY_RADIUS_UNIT_KILOMETERS]},
     :contentStreamTypeDetails
     {:targetingOptionId string,
      :contentStreamType
      [CONTENT_STREAM_TYPE_UNSPECIFIED
       CONTENT_LIVE_STREAM
       CONTENT_ON_DEMAND]},
     :digitalContentLabelExclusionDetails
     {:excludedContentRatingTier
      [CONTENT_RATING_TIER_UNSPECIFIED
       CONTENT_RATING_TIER_UNRATED
       CONTENT_RATING_TIER_GENERAL
       CONTENT_RATING_TIER_PARENTAL_GUIDANCE
       CONTENT_RATING_TIER_TEENS
       CONTENT_RATING_TIER_MATURE
       CONTENT_RATING_TIER_FAMILIES]},
     :ageRangeDetails
     {:ageRange
      [AGE_RANGE_UNSPECIFIED
       AGE_RANGE_18_24
       AGE_RANGE_25_34
       AGE_RANGE_35_44
       AGE_RANGE_45_54
       AGE_RANGE_55_64
       AGE_RANGE_65_PLUS
       AGE_RANGE_UNKNOWN
       AGE_RANGE_18_20
       AGE_RANGE_21_24
       AGE_RANGE_25_29
       AGE_RANGE_30_34
       AGE_RANGE_35_39
       AGE_RANGE_40_44
       AGE_RANGE_45_49
       AGE_RANGE_50_54
       AGE_RANGE_55_59
       AGE_RANGE_60_64]},
     :deviceMakeModelDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :categoryDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :inheritance
     [INHERITANCE_UNSPECIFIED
      NOT_INHERITED
      INHERITED_FROM_PARTNER
      INHERITED_FROM_ADVERTISER],
     :businessChainDetails
     {:displayName string,
      :targetingOptionId string,
      :proximityRadiusAmount number,
      :proximityRadiusUnit
      [DISTANCE_UNIT_UNSPECIFIED
       DISTANCE_UNIT_MILES
       DISTANCE_UNIT_KILOMETERS]},
     :audienceGroupDetails
     {:includedFirstAndThirdPartyAudienceGroups
      [{:settings [FirstAndThirdPartyAudienceTargetingSetting]}],
      :includedGoogleAudienceGroup
      {:settings [GoogleAudienceTargetingSetting]},
      :includedCustomListGroup
      {:settings [CustomListTargetingSetting]},
      :includedCombinedAudienceGroup
      {:settings [CombinedAudienceTargetingSetting]},
      :excludedFirstAndThirdPartyAudienceGroup
      {:settings [FirstAndThirdPartyAudienceTargetingSetting]},
      :excludedGoogleAudienceGroup
      {:settings [GoogleAudienceTargetingSetting]}},
     :channelDetails {:channelId string, :negative boolean},
     :contentDurationDetails
     {:targetingOptionId string,
      :contentDuration
      [CONTENT_DURATION_UNSPECIFIED
       CONTENT_DURATION_UNKNOWN
       CONTENT_DURATION_0_TO_1_MIN
       CONTENT_DURATION_1_TO_5_MIN
       CONTENT_DURATION_5_TO_15_MIN
       CONTENT_DURATION_15_TO_30_MIN
       CONTENT_DURATION_30_TO_60_MIN
       CONTENT_DURATION_OVER_60_MIN]},
     :targetingType
     [TARGETING_TYPE_UNSPECIFIED
      TARGETING_TYPE_CHANNEL
      TARGETING_TYPE_APP_CATEGORY
      TARGETING_TYPE_APP
      TARGETING_TYPE_URL
      TARGETING_TYPE_DAY_AND_TIME
      TARGETING_TYPE_AGE_RANGE
      TARGETING_TYPE_REGIONAL_LOCATION_LIST
      TARGETING_TYPE_PROXIMITY_LOCATION_LIST
      TARGETING_TYPE_GENDER
      TARGETING_TYPE_VIDEO_PLAYER_SIZE
      TARGETING_TYPE_USER_REWARDED_CONTENT
      TARGETING_TYPE_PARENTAL_STATUS
      TARGETING_TYPE_CONTENT_INSTREAM_POSITION
      TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
      TARGETING_TYPE_DEVICE_TYPE
      TARGETING_TYPE_AUDIENCE_GROUP
      TARGETING_TYPE_BROWSER
      TARGETING_TYPE_HOUSEHOLD_INCOME
      TARGETING_TYPE_ON_SCREEN_POSITION
      TARGETING_TYPE_THIRD_PARTY_VERIFIER
      TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
      TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
      TARGETING_TYPE_ENVIRONMENT
      TARGETING_TYPE_CARRIER_AND_ISP
      TARGETING_TYPE_OPERATING_SYSTEM
      TARGETING_TYPE_DEVICE_MAKE_MODEL
      TARGETING_TYPE_KEYWORD
      TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
      TARGETING_TYPE_VIEWABILITY
      TARGETING_TYPE_CATEGORY
      TARGETING_TYPE_INVENTORY_SOURCE
      TARGETING_TYPE_LANGUAGE
      TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
      TARGETING_TYPE_GEO_REGION
      TARGETING_TYPE_INVENTORY_SOURCE_GROUP
      TARGETING_TYPE_EXCHANGE
      TARGETING_TYPE_SUB_EXCHANGE
      TARGETING_TYPE_POI
      TARGETING_TYPE_BUSINESS_CHAIN
      TARGETING_TYPE_CONTENT_DURATION
      TARGETING_TYPE_CONTENT_STREAM_TYPE
      TARGETING_TYPE_NATIVE_CONTENT_POSITION
      TARGETING_TYPE_OMID
      TARGETING_TYPE_AUDIO_CONTENT_TYPE
      TARGETING_TYPE_CONTENT_GENRE
      TARGETING_TYPE_YOUTUBE_VIDEO
      TARGETING_TYPE_YOUTUBE_CHANNEL
      TARGETING_TYPE_SESSION_POSITION],
     :environmentDetails
     {:environment
      [ENVIRONMENT_UNSPECIFIED
       ENVIRONMENT_WEB_OPTIMIZED
       ENVIRONMENT_WEB_NOT_OPTIMIZED
       ENVIRONMENT_APP]},
     :poiDetails
     {:displayName string,
      :targetingOptionId string,
      :latitude number,
      :longitude number,
      :proximityRadiusAmount number,
      :proximityRadiusUnit
      [DISTANCE_UNIT_UNSPECIFIED
       DISTANCE_UNIT_MILES
       DISTANCE_UNIT_KILOMETERS]},
     :sensitiveCategoryExclusionDetails
     {:excludedSensitiveCategory
      [SENSITIVE_CATEGORY_UNSPECIFIED
       SENSITIVE_CATEGORY_ADULT
       SENSITIVE_CATEGORY_DEROGATORY
       SENSITIVE_CATEGORY_DOWNLOADS_SHARING
       SENSITIVE_CATEGORY_WEAPONS
       SENSITIVE_CATEGORY_GAMBLING
       SENSITIVE_CATEGORY_VIOLENCE
       SENSITIVE_CATEGORY_SUGGESTIVE
       SENSITIVE_CATEGORY_PROFANITY
       SENSITIVE_CATEGORY_ALCOHOL
       SENSITIVE_CATEGORY_DRUGS
       SENSITIVE_CATEGORY_TOBACCO
       SENSITIVE_CATEGORY_POLITICS
       SENSITIVE_CATEGORY_RELIGION
       SENSITIVE_CATEGORY_TRAGEDY
       SENSITIVE_CATEGORY_TRANSPORTATION_ACCIDENTS
       SENSITIVE_CATEGORY_SENSITIVE_SOCIAL_ISSUES
       SENSITIVE_CATEGORY_SHOCKING
       SENSITIVE_CATEGORY_EMBEDDED_VIDEO
       SENSITIVE_CATEGORY_LIVE_STREAMING_VIDEO]},
     :youtubeVideoDetails {:videoId string, :negative boolean},
     :sessionPositionDetails
     {:sessionPosition
      [SESSION_POSITION_UNSPECIFIED
       SESSION_POSITION_FIRST_IMPRESSION]},
     :deviceTypeDetails
     {:deviceType
      [DEVICE_TYPE_UNSPECIFIED
       DEVICE_TYPE_COMPUTER
       DEVICE_TYPE_CONNECTED_TV
       DEVICE_TYPE_SMART_PHONE
       DEVICE_TYPE_TABLET],
      :youtubeAndPartnersBidMultiplier number},
     :appDetails
     {:appId string,
      :displayName string,
      :negative boolean,
      :appPlatform
      [APP_PLATFORM_UNSPECIFIED
       APP_PLATFORM_IOS
       APP_PLATFORM_ANDROID
       APP_PLATFORM_ROKU
       APP_PLATFORM_AMAZON_FIRETV
       APP_PLATFORM_PLAYSTATION
       APP_PLATFORM_APPLE_TV
       APP_PLATFORM_XBOX
       APP_PLATFORM_SAMSUNG_TV
       APP_PLATFORM_ANDROID_TV
       APP_PLATFORM_GENERIC_CTV
       APP_PLATFORM_LG_TV
       APP_PLATFORM_VIZIO_TV]},
     :subExchangeDetails {:targetingOptionId string},
     :genderDetails
     {:gender
      [GENDER_UNSPECIFIED GENDER_MALE GENDER_FEMALE GENDER_UNKNOWN]},
     :languageDetails
     {:displayName string,
      :targetingOptionId string,
      :negative boolean},
     :viewabilityDetails
     {:viewability
      [VIEWABILITY_UNSPECIFIED
       VIEWABILITY_10_PERCENT_OR_MORE
       VIEWABILITY_20_PERCENT_OR_MORE
       VIEWABILITY_30_PERCENT_OR_MORE
       VIEWABILITY_40_PERCENT_OR_MORE
       VIEWABILITY_50_PERCENT_OR_MORE
       VIEWABILITY_60_PERCENT_OR_MORE
       VIEWABILITY_70_PERCENT_OR_MORE
       VIEWABILITY_80_PERCENT_OR_MORE
       VIEWABILITY_90_PERCENT_OR_MORE]},
     :assignedTargetingOptionIdAlias string,
     :keywordDetails {:keyword string, :negative boolean},
     :urlDetails {:url string, :negative boolean},
     :exchangeDetails
     {:exchange
      [EXCHANGE_UNSPECIFIED
       EXCHANGE_GOOGLE_AD_MANAGER
       EXCHANGE_APPNEXUS
       EXCHANGE_BRIGHTROLL
       EXCHANGE_ADFORM
       EXCHANGE_ADMETA
       EXCHANGE_ADMIXER
       EXCHANGE_ADSMOGO
       EXCHANGE_ADSWIZZ
       EXCHANGE_BIDSWITCH
       EXCHANGE_BRIGHTROLL_DISPLAY
       EXCHANGE_CADREON
       EXCHANGE_DAILYMOTION
       EXCHANGE_FIVE
       EXCHANGE_FLUCT
       EXCHANGE_FREEWHEEL
       EXCHANGE_GENIEE
       EXCHANGE_GUMGUM
       EXCHANGE_IMOBILE
       EXCHANGE_IBILLBOARD
       EXCHANGE_IMPROVE_DIGITAL
       EXCHANGE_INDEX
       EXCHANGE_KARGO
       EXCHANGE_MICROAD
       EXCHANGE_MOPUB
       EXCHANGE_NEND
       EXCHANGE_ONE_BY_AOL_DISPLAY
       EXCHANGE_ONE_BY_AOL_MOBILE
       EXCHANGE_ONE_BY_AOL_VIDEO
       EXCHANGE_OOYALA
       EXCHANGE_OPENX
       EXCHANGE_PERMODO
       EXCHANGE_PLATFORMONE
       EXCHANGE_PLATFORMID
       EXCHANGE_PUBMATIC
       EXCHANGE_PULSEPOINT
       EXCHANGE_REVENUEMAX
       EXCHANGE_RUBICON
       EXCHANGE_SMARTCLIP
       EXCHANGE_SMARTRTB
       EXCHANGE_SMARTSTREAMTV
       EXCHANGE_SOVRN
       EXCHANGE_SPOTXCHANGE
       EXCHANGE_STROER
       EXCHANGE_TEADSTV
       EXCHANGE_TELARIA
       EXCHANGE_TVN
       EXCHANGE_UNITED
       EXCHANGE_YIELDLAB
       EXCHANGE_YIELDMO
       EXCHANGE_UNRULYX
       EXCHANGE_OPEN8
       EXCHANGE_TRITON
       EXCHANGE_TRIPLELIFT
       EXCHANGE_TABOOLA
       EXCHANGE_INMOBI
       EXCHANGE_SMAATO
       EXCHANGE_AJA
       EXCHANGE_SUPERSHIP
       EXCHANGE_NEXSTAR_DIGITAL
       EXCHANGE_WAZE
       EXCHANGE_SOUNDCAST
       EXCHANGE_SHARETHROUGH
       EXCHANGE_FYBER
       EXCHANGE_RED_FOR_PUBLISHERS
       EXCHANGE_MEDIANET
       EXCHANGE_TAPJOY
       EXCHANGE_VISTAR
       EXCHANGE_DAX
       EXCHANGE_JCD
       EXCHANGE_PLACE_EXCHANGE
       EXCHANGE_APPLOVIN
       EXCHANGE_CONNATIX
       EXCHANGE_RESET_DIGITAL
       EXCHANGE_HIVESTACK
       EXCHANGE_DRAX
       EXCHANGE_APPLOVIN_GBID
       EXCHANGE_FYBER_GBID
       EXCHANGE_UNITY_GBID
       EXCHANGE_CHARTBOOST_GBID
       EXCHANGE_ADMOST_GBID
       EXCHANGE_TOPON_GBID]},
     :dayAndTimeDetails
     {:dayOfWeek
      [DAY_OF_WEEK_UNSPECIFIED
       MONDAY
       TUESDAY
       WEDNESDAY
       THURSDAY
       FRIDAY
       SATURDAY
       SUNDAY],
      :startHour integer,
      :endHour integer,
      :timeZoneResolution
      [TIME_ZONE_RESOLUTION_UNSPECIFIED
       TIME_ZONE_RESOLUTION_END_USER
       TIME_ZONE_RESOLUTION_ADVERTISER]},
     :householdIncomeDetails
     {:householdIncome
      [HOUSEHOLD_INCOME_UNSPECIFIED
       HOUSEHOLD_INCOME_UNKNOWN
       HOUSEHOLD_INCOME_LOWER_50_PERCENT
       HOUSEHOLD_INCOME_TOP_41_TO_50_PERCENT
       HOUSEHOLD_INCOME_TOP_31_TO_40_PERCENT
       HOUSEHOLD_INCOME_TOP_21_TO_30_PERCENT
       HOUSEHOLD_INCOME_TOP_11_TO_20_PERCENT
       HOUSEHOLD_INCOME_TOP_10_PERCENT]},
     :authorizedSellerStatusDetails
     {:authorizedSellerStatus
      [AUTHORIZED_SELLER_STATUS_UNSPECIFIED
       AUTHORIZED_SELLER_STATUS_AUTHORIZED_DIRECT_SELLERS_ONLY
       AUTHORIZED_SELLER_STATUS_AUTHORIZED_AND_NON_PARTICIPATING_PUBLISHERS],
      :targetingOptionId string},
     :contentOutstreamPositionDetails
     {:contentOutstreamPosition
      [CONTENT_OUTSTREAM_POSITION_UNSPECIFIED
       CONTENT_OUTSTREAM_POSITION_UNKNOWN
       CONTENT_OUTSTREAM_POSITION_IN_ARTICLE
       CONTENT_OUTSTREAM_POSITION_IN_BANNER
       CONTENT_OUTSTREAM_POSITION_IN_FEED
       CONTENT_OUTSTREAM_POSITION_INTERSTITIAL],
      :adType
      [AD_TYPE_UNSPECIFIED
       AD_TYPE_DISPLAY
       AD_TYPE_VIDEO
       AD_TYPE_AUDIO]},
     :youtubeChannelDetails {:channelId string, :negative boolean},
     :userRewardedContentDetails
     {:targetingOptionId string,
      :userRewardedContent
      [USER_REWARDED_CONTENT_UNSPECIFIED
       USER_REWARDED_CONTENT_USER_REWARDED
       USER_REWARDED_CONTENT_NOT_USER_REWARDED]},
     :omidDetails
     {:omid [OMID_UNSPECIFIED OMID_FOR_MOBILE_DISPLAY_ADS]}}]}]}"
  [partnerId BulkEditPartnerAssignedTargetingOptionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/partners/{+partnerId}:editAssignedTargetingOptions",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditPartnerAssignedTargetingOptionsRequest}))

(defn partners-get
  "Gets a partner.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> Required. The ID of the partner to fetch."
  [partnerId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/partners/{+partnerId}",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn partners-list
  "Lists partners that are accessible to the current user. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. For example, `displayName desc`.
filter <string> Allows filtering by partner fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `entityStatus` Examples: * All active partners: `entityStatus=\"ENTITY_STATUS_ACTIVE\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (partners-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://displayvideo.googleapis.com/v3/partners",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn partners-channels-get
  "Gets a channel for a partner or advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the fetched channel.
channelId <string> Required. The ID of the channel to fetch.

optional:
advertiserId <string> The ID of the advertiser that owns the fetched channel."
  ([partnerId channelId]
    (partners-channels-get partnerId channelId nil))
  ([partnerId channelId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/channels/{+channelId}",
       :uri-template-args {:partnerId partnerId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn partners-channels-list
  "Lists channels for a partner or advertiser.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the channels.

optional:
advertiserId <string> The ID of the advertiser that owns the channels.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) * `channelId` The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by channel fields. Supported syntax: * Filter expressions for channel can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `displayName` Examples: * All channels for which the display name contains \"google\": `displayName : \"google\"`. The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([partnerId] (partners-channels-list partnerId nil))
  ([partnerId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/channels",
       :uri-template-args {:partnerId partnerId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn partners-channels-create
  "Creates a new channel. Returns the newly created channel if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the created channel.
Channel:
{:name string,
 :channelId string,
 :displayName string,
 :partnerId string,
 :advertiserId string,
 :positivelyTargetedLineItemCount string,
 :negativelyTargetedLineItemCount string}

optional:
advertiserId <string> The ID of the advertiser that owns the created channel."
  ([partnerId Channel]
    (partners-channels-create partnerId Channel nil))
  ([partnerId Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/channels",
       :uri-template-args {:partnerId partnerId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Channel})))

(defn partners-channels-patch
  "Updates a channel. Returns the updated channel if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the created channel.
channelId <string> Output only. The unique ID of the channel. Assigned by the system.
Channel:
{:name string,
 :channelId string,
 :displayName string,
 :partnerId string,
 :advertiserId string,
 :positivelyTargetedLineItemCount string,
 :negativelyTargetedLineItemCount string}

optional:
advertiserId <string> The ID of the advertiser that owns the created channel.
updateMask <string> Required. The mask to control which fields to update."
  ([partnerId channelId Channel]
    (partners-channels-patch partnerId channelId Channel nil))
  ([partnerId channelId Channel optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/channels/{channelId}",
       :uri-template-args {:partnerId partnerId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Channel})))

(defn partners-channels-sites-list
  "Lists sites in a channel.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the parent channel.
channelId <string> Required. The ID of the parent channel to which the requested sites belong.

optional:
advertiserId <string> The ID of the advertiser that owns the parent channel.
pageSize <integer> Requested page size. Must be between `1` and `10000`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `urlOrAppId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be added to the field name. Example: `urlOrAppId desc`.
filter <string> Allows filtering by site fields. Supported syntax: * Filter expressions for site retrieval can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `urlOrAppId` Examples: * All sites for which the URL or app ID contains \"google\": `urlOrAppId : \"google\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([partnerId channelId]
    (partners-channels-sites-list partnerId channelId nil))
  ([partnerId channelId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/channels/{+channelId}/sites",
       :uri-template-args {:partnerId partnerId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn partners-channels-sites-create
  "Creates a site in a channel.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the parent channel.
channelId <string> Required. The ID of the parent channel in which the site will be created.
Site:
{:name string, :urlOrAppId string}

optional:
advertiserId <string> The ID of the advertiser that owns the parent channel."
  ([partnerId channelId Site]
    (partners-channels-sites-create partnerId channelId Site nil))
  ([partnerId channelId Site optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{partnerId}/channels/{+channelId}/sites",
       :uri-template-args {:partnerId partnerId, :channelId channelId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body Site})))

(defn partners-channels-sites-delete
  "Deletes a site from a channel.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the parent channel.
channelId <string> Required. The ID of the parent channel to which the site belongs.
urlOrAppId <string> Required. The URL or app ID of the site to delete.

optional:
advertiserId <string> The ID of the advertiser that owns the parent channel."
  ([partnerId channelId urlOrAppId]
    (partners-channels-sites-delete
      partnerId
      channelId
      urlOrAppId
      nil))
  ([partnerId channelId urlOrAppId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{partnerId}/channels/{+channelId}/sites/{+urlOrAppId}",
       :uri-template-args
       {:partnerId partnerId,
        :channelId channelId,
        :urlOrAppId urlOrAppId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn partners-channels-sites-bulkEdit
  "Bulk edits sites under a single channel. The operation will delete the sites provided in BulkEditSitesRequest.deleted_sites and then create the sites provided in BulkEditSitesRequest.created_sites.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the parent channel.
channelId <string> Required. The ID of the parent channel to which the sites belong.
BulkEditSitesRequest:
{:partnerId string,
 :advertiserId string,
 :deletedSites [string],
 :createdSites [{:name string, :urlOrAppId string}]}"
  [partnerId channelId BulkEditSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/partners/{partnerId}/channels/{+channelId}/sites:bulkEdit",
     :uri-template-args {:partnerId partnerId, :channelId channelId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body BulkEditSitesRequest}))

(defn partners-channels-sites-replace
  "Replaces all of the sites under a single channel. The operation will replace the sites under a channel with the sites provided in ReplaceSitesRequest.new_sites. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> The ID of the partner that owns the parent channel.
channelId <string> Required. The ID of the parent channel whose sites will be replaced.
ReplaceSitesRequest:
{:partnerId string,
 :advertiserId string,
 :newSites [{:name string, :urlOrAppId string}]}"
  [partnerId channelId ReplaceSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/partners/{partnerId}/channels/{+channelId}/sites:replace",
     :uri-template-args {:partnerId partnerId, :channelId channelId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body ReplaceSitesRequest}))

(defn partners-targetingTypes-assignedTargetingOptions-get
  "Gets a single targeting option assigned to a partner.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> Required. The ID of the partner.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_CHANNEL`
assignedTargetingOptionId <string> Required. An identifier unique to the targeting type in this partner that identifies the assigned targeting option being requested."
  [partnerId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:partnerId partnerId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn partners-targetingTypes-assignedTargetingOptions-list
  "Lists the targeting options assigned to a partner.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> Required. The ID of the partner.
targetingType <string> Required. Identifies the type of assigned targeting options to list. Supported targeting types: * `TARGETING_TYPE_CHANNEL`

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `assignedTargetingOptionId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `assignedTargetingOptionId desc`.
filter <string> Allows filtering by assigned targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `OR`. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `assignedTargetingOptionId` Examples: * `AssignedTargetingOption` resource with ID 123456: `assignedTargetingOptionId=\"123456\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([partnerId targetingType]
    (partners-targetingTypes-assignedTargetingOptions-list
      partnerId
      targetingType
      nil))
  ([partnerId targetingType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
       :uri-template-args
       {:partnerId partnerId, :targetingType targetingType},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn partners-targetingTypes-assignedTargetingOptions-create
  "Assigns a targeting option to a partner. Returns the assigned targeting option if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> Required. The ID of the partner.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_CHANNEL`
AssignedTargetingOption:
{:contentGenreDetails
 {:targetingOptionId string, :displayName string, :negative boolean},
 :negativeKeywordListDetails {:negativeKeywordListId string},
 :parentalStatusDetails
 {:parentalStatus
  [PARENTAL_STATUS_UNSPECIFIED
   PARENTAL_STATUS_PARENT
   PARENTAL_STATUS_NOT_A_PARENT
   PARENTAL_STATUS_UNKNOWN]},
 :geoRegionDetails
 {:displayName string,
  :targetingOptionId string,
  :geoRegionType
  [GEO_REGION_TYPE_UNKNOWN
   GEO_REGION_TYPE_OTHER
   GEO_REGION_TYPE_COUNTRY
   GEO_REGION_TYPE_REGION
   GEO_REGION_TYPE_TERRITORY
   GEO_REGION_TYPE_PROVINCE
   GEO_REGION_TYPE_STATE
   GEO_REGION_TYPE_PREFECTURE
   GEO_REGION_TYPE_GOVERNORATE
   GEO_REGION_TYPE_CANTON
   GEO_REGION_TYPE_UNION_TERRITORY
   GEO_REGION_TYPE_AUTONOMOUS_COMMUNITY
   GEO_REGION_TYPE_DMA_REGION
   GEO_REGION_TYPE_METRO
   GEO_REGION_TYPE_CONGRESSIONAL_DISTRICT
   GEO_REGION_TYPE_COUNTY
   GEO_REGION_TYPE_MUNICIPALITY
   GEO_REGION_TYPE_CITY
   GEO_REGION_TYPE_POSTAL_CODE
   GEO_REGION_TYPE_DEPARTMENT
   GEO_REGION_TYPE_AIRPORT
   GEO_REGION_TYPE_TV_REGION
   GEO_REGION_TYPE_OKRUG
   GEO_REGION_TYPE_BOROUGH
   GEO_REGION_TYPE_CITY_REGION
   GEO_REGION_TYPE_ARRONDISSEMENT
   GEO_REGION_TYPE_NEIGHBORHOOD
   GEO_REGION_TYPE_UNIVERSITY
   GEO_REGION_TYPE_DISTRICT],
  :negative boolean},
 :regionalLocationListDetails
 {:regionalLocationListId string, :negative boolean},
 :browserDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inventorySourceGroupDetails {:inventorySourceGroupId string},
 :nativeContentPositionDetails
 {:contentPosition
  [NATIVE_CONTENT_POSITION_UNSPECIFIED
   NATIVE_CONTENT_POSITION_UNKNOWN
   NATIVE_CONTENT_POSITION_IN_ARTICLE
   NATIVE_CONTENT_POSITION_IN_FEED
   NATIVE_CONTENT_POSITION_PERIPHERAL
   NATIVE_CONTENT_POSITION_RECOMMENDATION]},
 :assignedTargetingOptionId string,
 :operatingSystemDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :appCategoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :contentInstreamPositionDetails
 {:contentInstreamPosition
  [CONTENT_INSTREAM_POSITION_UNSPECIFIED
   CONTENT_INSTREAM_POSITION_PRE_ROLL
   CONTENT_INSTREAM_POSITION_MID_ROLL
   CONTENT_INSTREAM_POSITION_POST_ROLL
   CONTENT_INSTREAM_POSITION_UNKNOWN],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :inventorySourceDetails {:inventorySourceId string},
 :audioContentTypeDetails
 {:audioContentType
  [AUDIO_CONTENT_TYPE_UNSPECIFIED
   AUDIO_CONTENT_TYPE_UNKNOWN
   AUDIO_CONTENT_TYPE_MUSIC
   AUDIO_CONTENT_TYPE_BROADCAST
   AUDIO_CONTENT_TYPE_PODCAST]},
 :thirdPartyVerifierDetails
 {:adloox
  {:excludedAdlooxCategories
   [[ADLOOX_UNSPECIFIED
     ADULT_CONTENT_HARD
     ADULT_CONTENT_SOFT
     ILLEGAL_CONTENT
     BORDERLINE_CONTENT
     DISCRIMINATORY_CONTENT
     VIOLENT_CONTENT_WEAPONS
     LOW_VIEWABILITY_DOMAINS
     FRAUD]]},
  :doubleVerify
  {:brandSafetyCategories
   {:avoidUnknownBrandSafetyCategory boolean,
    :avoidedHighSeverityCategories
    [[HIGHER_SEVERITY_UNSPECIFIED
      ADULT_CONTENT_PORNOGRAPHY
      COPYRIGHT_INFRINGEMENT
      SUBSTANCE_ABUSE
      GRAPHIC_VIOLENCE_WEAPONS
      HATE_PROFANITY
      CRIMINAL_SKILLS
      NUISANCE_INCENTIVIZED_MALWARE_CLUTTER]],
    :avoidedMediumSeverityCategories
    [[MEDIUM_SEVERITY_UNSPECIFIED
      AD_SERVERS
      ADULT_CONTENT_SWIMSUIT
      ALTERNATIVE_LIFESTYLES
      CELEBRITY_GOSSIP
      GAMBLING
      OCCULT
      SEX_EDUCATION
      DISASTER_AVIATION
      DISASTER_MAN_MADE
      DISASTER_NATURAL
      DISASTER_TERRORIST_EVENTS
      DISASTER_VEHICLE
      ALCOHOL
      SMOKING
      NEGATIVE_NEWS_FINANCIAL
      NON_ENGLISH
      PARKING_PAGE
      UNMODERATED_UGC
      INFLAMMATORY_POLITICS_AND_NEWS
      NEGATIVE_NEWS_PHARMACEUTICAL]]},
   :avoidedAgeRatings
   [[AGE_RATING_UNSPECIFIED
     APP_AGE_RATE_UNKNOWN
     APP_AGE_RATE_4_PLUS
     APP_AGE_RATE_9_PLUS
     APP_AGE_RATE_12_PLUS
     APP_AGE_RATE_17_PLUS
     APP_AGE_RATE_18_PLUS]],
   :appStarRating
   {:avoidedStarRating
    [APP_STAR_RATE_UNSPECIFIED
     APP_STAR_RATE_1_POINT_5_LESS
     APP_STAR_RATE_2_LESS
     APP_STAR_RATE_2_POINT_5_LESS
     APP_STAR_RATE_3_LESS
     APP_STAR_RATE_3_POINT_5_LESS
     APP_STAR_RATE_4_LESS
     APP_STAR_RATE_4_POINT_5_LESS],
    :avoidInsufficientStarRating boolean},
   :displayViewability
   {:iab
    [IAB_VIEWED_RATE_UNSPECIFIED
     IAB_VIEWED_RATE_80_PERCENT_HIGHER
     IAB_VIEWED_RATE_75_PERCENT_HIGHER
     IAB_VIEWED_RATE_70_PERCENT_HIGHER
     IAB_VIEWED_RATE_65_PERCENT_HIGHER
     IAB_VIEWED_RATE_60_PERCENT_HIGHER
     IAB_VIEWED_RATE_55_PERCENT_HIGHER
     IAB_VIEWED_RATE_50_PERCENT_HIGHER
     IAB_VIEWED_RATE_40_PERCENT_HIGHER
     IAB_VIEWED_RATE_30_PERCENT_HIGHER],
    :viewableDuring
    [AVERAGE_VIEW_DURATION_UNSPECIFIED
     AVERAGE_VIEW_DURATION_5_SEC
     AVERAGE_VIEW_DURATION_10_SEC
     AVERAGE_VIEW_DURATION_15_SEC]},
   :videoViewability
   {:videoIab
    [VIDEO_IAB_UNSPECIFIED
     IAB_VIEWABILITY_80_PERCENT_HIGHER
     IAB_VIEWABILITY_75_PERCENT_HIGHER
     IAB_VIEWABILITY_70_PERCENT_HIGHER
     IAB_VIEWABILITY_65_PERCENT_HIHGER
     IAB_VIEWABILITY_60_PERCENT_HIGHER
     IAB_VIEWABILITY_55_PERCENT_HIHGER
     IAB_VIEWABILITY_50_PERCENT_HIGHER
     IAB_VIEWABILITY_40_PERCENT_HIHGER
     IAB_VIEWABILITY_30_PERCENT_HIHGER],
    :videoViewableRate
    [VIDEO_VIEWABLE_RATE_UNSPECIFIED
     VIEWED_PERFORMANCE_40_PERCENT_HIGHER
     VIEWED_PERFORMANCE_35_PERCENT_HIGHER
     VIEWED_PERFORMANCE_30_PERCENT_HIGHER
     VIEWED_PERFORMANCE_25_PERCENT_HIGHER
     VIEWED_PERFORMANCE_20_PERCENT_HIGHER
     VIEWED_PERFORMANCE_10_PERCENT_HIGHER],
    :playerImpressionRate
    [PLAYER_SIZE_400X300_UNSPECIFIED
     PLAYER_SIZE_400X300_95
     PLAYER_SIZE_400X300_70
     PLAYER_SIZE_400X300_25
     PLAYER_SIZE_400X300_5]},
   :fraudInvalidTraffic
   {:avoidedFraudOption
    [FRAUD_UNSPECIFIED
     AD_IMPRESSION_FRAUD_100
     AD_IMPRESSION_FRAUD_50
     AD_IMPRESSION_FRAUD_25
     AD_IMPRESSION_FRAUD_10
     AD_IMPRESSION_FRAUD_8
     AD_IMPRESSION_FRAUD_6
     AD_IMPRESSION_FRAUD_4
     AD_IMPRESSION_FRAUD_2],
    :avoidInsufficientOption boolean},
   :customSegmentId string},
  :integralAdScience
  {:excludedIllegalDownloadsRisk
   [ILLEGAL_DOWNLOADS_UNSPECIFIED
    ILLEGAL_DOWNLOADS_HR
    ILLEGAL_DOWNLOADS_HMR],
   :excludedOffensiveLanguageRisk
   [OFFENSIVE_LANGUAGE_UNSPECIFIED
    OFFENSIVE_LANGUAGE_HR
    OFFENSIVE_LANGUAGE_HMR],
   :excludeUnrateable boolean,
   :excludedDrugsRisk [DRUGS_UNSPECIFIED DRUGS_HR DRUGS_HMR],
   :excludedGamblingRisk
   [GAMBLING_UNSPECIFIED GAMBLING_HR GAMBLING_HMR],
   :excludedAdultRisk [ADULT_UNSPECIFIED ADULT_HR ADULT_HMR],
   :displayViewability
   [PERFORMANCE_VIEWABILITY_UNSPECIFIED
    PERFORMANCE_VIEWABILITY_40
    PERFORMANCE_VIEWABILITY_50
    PERFORMANCE_VIEWABILITY_60
    PERFORMANCE_VIEWABILITY_70],
   :excludedViolenceRisk
   [VIOLENCE_UNSPECIFIED VIOLENCE_HR VIOLENCE_HMR],
   :traqScoreOption
   [TRAQ_UNSPECIFIED
    TRAQ_250
    TRAQ_500
    TRAQ_600
    TRAQ_700
    TRAQ_750
    TRAQ_875
    TRAQ_1000],
   :excludedHateSpeechRisk
   [HATE_SPEECH_UNSPECIFIED HATE_SPEECH_HR HATE_SPEECH_HMR],
   :videoViewability
   [VIDEO_VIEWABILITY_UNSPECIFIED
    VIDEO_VIEWABILITY_40
    VIDEO_VIEWABILITY_50
    VIDEO_VIEWABILITY_60
    VIDEO_VIEWABILITY_70],
   :excludedAdFraudRisk
   [SUSPICIOUS_ACTIVITY_UNSPECIFIED
    SUSPICIOUS_ACTIVITY_HR
    SUSPICIOUS_ACTIVITY_HMR],
   :customSegmentId [string],
   :excludedAlcoholRisk [ALCOHOL_UNSPECIFIED ALCOHOL_HR ALCOHOL_HMR]}},
 :name string,
 :onScreenPositionDetails
 {:targetingOptionId string,
  :onScreenPosition
  [ON_SCREEN_POSITION_UNSPECIFIED
   ON_SCREEN_POSITION_UNKNOWN
   ON_SCREEN_POSITION_ABOVE_THE_FOLD
   ON_SCREEN_POSITION_BELOW_THE_FOLD],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :videoPlayerSizeDetails
 {:videoPlayerSize
  [VIDEO_PLAYER_SIZE_UNSPECIFIED
   VIDEO_PLAYER_SIZE_SMALL
   VIDEO_PLAYER_SIZE_LARGE
   VIDEO_PLAYER_SIZE_HD
   VIDEO_PLAYER_SIZE_UNKNOWN]},
 :carrierAndIspDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :proximityLocationListDetails
 {:proximityLocationListId string,
  :proximityRadius number,
  :proximityRadiusUnit
  [PROXIMITY_RADIUS_UNIT_UNSPECIFIED
   PROXIMITY_RADIUS_UNIT_MILES
   PROXIMITY_RADIUS_UNIT_KILOMETERS]},
 :contentStreamTypeDetails
 {:targetingOptionId string,
  :contentStreamType
  [CONTENT_STREAM_TYPE_UNSPECIFIED
   CONTENT_LIVE_STREAM
   CONTENT_ON_DEMAND]},
 :digitalContentLabelExclusionDetails
 {:excludedContentRatingTier
  [CONTENT_RATING_TIER_UNSPECIFIED
   CONTENT_RATING_TIER_UNRATED
   CONTENT_RATING_TIER_GENERAL
   CONTENT_RATING_TIER_PARENTAL_GUIDANCE
   CONTENT_RATING_TIER_TEENS
   CONTENT_RATING_TIER_MATURE
   CONTENT_RATING_TIER_FAMILIES]},
 :ageRangeDetails
 {:ageRange
  [AGE_RANGE_UNSPECIFIED
   AGE_RANGE_18_24
   AGE_RANGE_25_34
   AGE_RANGE_35_44
   AGE_RANGE_45_54
   AGE_RANGE_55_64
   AGE_RANGE_65_PLUS
   AGE_RANGE_UNKNOWN
   AGE_RANGE_18_20
   AGE_RANGE_21_24
   AGE_RANGE_25_29
   AGE_RANGE_30_34
   AGE_RANGE_35_39
   AGE_RANGE_40_44
   AGE_RANGE_45_49
   AGE_RANGE_50_54
   AGE_RANGE_55_59
   AGE_RANGE_60_64]},
 :deviceMakeModelDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :categoryDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :inheritance
 [INHERITANCE_UNSPECIFIED
  NOT_INHERITED
  INHERITED_FROM_PARTNER
  INHERITED_FROM_ADVERTISER],
 :businessChainDetails
 {:displayName string,
  :targetingOptionId string,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :audienceGroupDetails
 {:includedFirstAndThirdPartyAudienceGroups
  [{:settings
    [{:firstAndThirdPartyAudienceId string,
      :recency
      [RECENCY_NO_LIMIT
       RECENCY_1_MINUTE
       RECENCY_5_MINUTES
       RECENCY_10_MINUTES
       RECENCY_15_MINUTES
       RECENCY_30_MINUTES
       RECENCY_1_HOUR
       RECENCY_2_HOURS
       RECENCY_3_HOURS
       RECENCY_6_HOURS
       RECENCY_12_HOURS
       RECENCY_1_DAY
       RECENCY_2_DAYS
       RECENCY_3_DAYS
       RECENCY_5_DAYS
       RECENCY_7_DAYS
       RECENCY_10_DAYS
       RECENCY_14_DAYS
       RECENCY_15_DAYS
       RECENCY_21_DAYS
       RECENCY_28_DAYS
       RECENCY_30_DAYS
       RECENCY_40_DAYS
       RECENCY_45_DAYS
       RECENCY_60_DAYS
       RECENCY_90_DAYS
       RECENCY_120_DAYS
       RECENCY_180_DAYS
       RECENCY_270_DAYS
       RECENCY_365_DAYS]}]}],
  :includedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]},
  :includedCustomListGroup {:settings [{:customListId string}]},
  :includedCombinedAudienceGroup
  {:settings [{:combinedAudienceId string}]},
  :excludedFirstAndThirdPartyAudienceGroup
  {:settings
   [{:firstAndThirdPartyAudienceId string,
     :recency
     [RECENCY_NO_LIMIT
      RECENCY_1_MINUTE
      RECENCY_5_MINUTES
      RECENCY_10_MINUTES
      RECENCY_15_MINUTES
      RECENCY_30_MINUTES
      RECENCY_1_HOUR
      RECENCY_2_HOURS
      RECENCY_3_HOURS
      RECENCY_6_HOURS
      RECENCY_12_HOURS
      RECENCY_1_DAY
      RECENCY_2_DAYS
      RECENCY_3_DAYS
      RECENCY_5_DAYS
      RECENCY_7_DAYS
      RECENCY_10_DAYS
      RECENCY_14_DAYS
      RECENCY_15_DAYS
      RECENCY_21_DAYS
      RECENCY_28_DAYS
      RECENCY_30_DAYS
      RECENCY_40_DAYS
      RECENCY_45_DAYS
      RECENCY_60_DAYS
      RECENCY_90_DAYS
      RECENCY_120_DAYS
      RECENCY_180_DAYS
      RECENCY_270_DAYS
      RECENCY_365_DAYS]}]},
  :excludedGoogleAudienceGroup
  {:settings [{:googleAudienceId string}]}},
 :channelDetails {:channelId string, :negative boolean},
 :contentDurationDetails
 {:targetingOptionId string,
  :contentDuration
  [CONTENT_DURATION_UNSPECIFIED
   CONTENT_DURATION_UNKNOWN
   CONTENT_DURATION_0_TO_1_MIN
   CONTENT_DURATION_1_TO_5_MIN
   CONTENT_DURATION_5_TO_15_MIN
   CONTENT_DURATION_15_TO_30_MIN
   CONTENT_DURATION_30_TO_60_MIN
   CONTENT_DURATION_OVER_60_MIN]},
 :targetingType
 [TARGETING_TYPE_UNSPECIFIED
  TARGETING_TYPE_CHANNEL
  TARGETING_TYPE_APP_CATEGORY
  TARGETING_TYPE_APP
  TARGETING_TYPE_URL
  TARGETING_TYPE_DAY_AND_TIME
  TARGETING_TYPE_AGE_RANGE
  TARGETING_TYPE_REGIONAL_LOCATION_LIST
  TARGETING_TYPE_PROXIMITY_LOCATION_LIST
  TARGETING_TYPE_GENDER
  TARGETING_TYPE_VIDEO_PLAYER_SIZE
  TARGETING_TYPE_USER_REWARDED_CONTENT
  TARGETING_TYPE_PARENTAL_STATUS
  TARGETING_TYPE_CONTENT_INSTREAM_POSITION
  TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION
  TARGETING_TYPE_DEVICE_TYPE
  TARGETING_TYPE_AUDIENCE_GROUP
  TARGETING_TYPE_BROWSER
  TARGETING_TYPE_HOUSEHOLD_INCOME
  TARGETING_TYPE_ON_SCREEN_POSITION
  TARGETING_TYPE_THIRD_PARTY_VERIFIER
  TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION
  TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION
  TARGETING_TYPE_ENVIRONMENT
  TARGETING_TYPE_CARRIER_AND_ISP
  TARGETING_TYPE_OPERATING_SYSTEM
  TARGETING_TYPE_DEVICE_MAKE_MODEL
  TARGETING_TYPE_KEYWORD
  TARGETING_TYPE_NEGATIVE_KEYWORD_LIST
  TARGETING_TYPE_VIEWABILITY
  TARGETING_TYPE_CATEGORY
  TARGETING_TYPE_INVENTORY_SOURCE
  TARGETING_TYPE_LANGUAGE
  TARGETING_TYPE_AUTHORIZED_SELLER_STATUS
  TARGETING_TYPE_GEO_REGION
  TARGETING_TYPE_INVENTORY_SOURCE_GROUP
  TARGETING_TYPE_EXCHANGE
  TARGETING_TYPE_SUB_EXCHANGE
  TARGETING_TYPE_POI
  TARGETING_TYPE_BUSINESS_CHAIN
  TARGETING_TYPE_CONTENT_DURATION
  TARGETING_TYPE_CONTENT_STREAM_TYPE
  TARGETING_TYPE_NATIVE_CONTENT_POSITION
  TARGETING_TYPE_OMID
  TARGETING_TYPE_AUDIO_CONTENT_TYPE
  TARGETING_TYPE_CONTENT_GENRE
  TARGETING_TYPE_YOUTUBE_VIDEO
  TARGETING_TYPE_YOUTUBE_CHANNEL
  TARGETING_TYPE_SESSION_POSITION],
 :environmentDetails
 {:environment
  [ENVIRONMENT_UNSPECIFIED
   ENVIRONMENT_WEB_OPTIMIZED
   ENVIRONMENT_WEB_NOT_OPTIMIZED
   ENVIRONMENT_APP]},
 :poiDetails
 {:displayName string,
  :targetingOptionId string,
  :latitude number,
  :longitude number,
  :proximityRadiusAmount number,
  :proximityRadiusUnit
  [DISTANCE_UNIT_UNSPECIFIED
   DISTANCE_UNIT_MILES
   DISTANCE_UNIT_KILOMETERS]},
 :sensitiveCategoryExclusionDetails
 {:excludedSensitiveCategory
  [SENSITIVE_CATEGORY_UNSPECIFIED
   SENSITIVE_CATEGORY_ADULT
   SENSITIVE_CATEGORY_DEROGATORY
   SENSITIVE_CATEGORY_DOWNLOADS_SHARING
   SENSITIVE_CATEGORY_WEAPONS
   SENSITIVE_CATEGORY_GAMBLING
   SENSITIVE_CATEGORY_VIOLENCE
   SENSITIVE_CATEGORY_SUGGESTIVE
   SENSITIVE_CATEGORY_PROFANITY
   SENSITIVE_CATEGORY_ALCOHOL
   SENSITIVE_CATEGORY_DRUGS
   SENSITIVE_CATEGORY_TOBACCO
   SENSITIVE_CATEGORY_POLITICS
   SENSITIVE_CATEGORY_RELIGION
   SENSITIVE_CATEGORY_TRAGEDY
   SENSITIVE_CATEGORY_TRANSPORTATION_ACCIDENTS
   SENSITIVE_CATEGORY_SENSITIVE_SOCIAL_ISSUES
   SENSITIVE_CATEGORY_SHOCKING
   SENSITIVE_CATEGORY_EMBEDDED_VIDEO
   SENSITIVE_CATEGORY_LIVE_STREAMING_VIDEO]},
 :youtubeVideoDetails {:videoId string, :negative boolean},
 :sessionPositionDetails
 {:sessionPosition
  [SESSION_POSITION_UNSPECIFIED SESSION_POSITION_FIRST_IMPRESSION]},
 :deviceTypeDetails
 {:deviceType
  [DEVICE_TYPE_UNSPECIFIED
   DEVICE_TYPE_COMPUTER
   DEVICE_TYPE_CONNECTED_TV
   DEVICE_TYPE_SMART_PHONE
   DEVICE_TYPE_TABLET],
  :youtubeAndPartnersBidMultiplier number},
 :appDetails
 {:appId string,
  :displayName string,
  :negative boolean,
  :appPlatform
  [APP_PLATFORM_UNSPECIFIED
   APP_PLATFORM_IOS
   APP_PLATFORM_ANDROID
   APP_PLATFORM_ROKU
   APP_PLATFORM_AMAZON_FIRETV
   APP_PLATFORM_PLAYSTATION
   APP_PLATFORM_APPLE_TV
   APP_PLATFORM_XBOX
   APP_PLATFORM_SAMSUNG_TV
   APP_PLATFORM_ANDROID_TV
   APP_PLATFORM_GENERIC_CTV
   APP_PLATFORM_LG_TV
   APP_PLATFORM_VIZIO_TV]},
 :subExchangeDetails {:targetingOptionId string},
 :genderDetails
 {:gender
  [GENDER_UNSPECIFIED GENDER_MALE GENDER_FEMALE GENDER_UNKNOWN]},
 :languageDetails
 {:displayName string, :targetingOptionId string, :negative boolean},
 :viewabilityDetails
 {:viewability
  [VIEWABILITY_UNSPECIFIED
   VIEWABILITY_10_PERCENT_OR_MORE
   VIEWABILITY_20_PERCENT_OR_MORE
   VIEWABILITY_30_PERCENT_OR_MORE
   VIEWABILITY_40_PERCENT_OR_MORE
   VIEWABILITY_50_PERCENT_OR_MORE
   VIEWABILITY_60_PERCENT_OR_MORE
   VIEWABILITY_70_PERCENT_OR_MORE
   VIEWABILITY_80_PERCENT_OR_MORE
   VIEWABILITY_90_PERCENT_OR_MORE]},
 :assignedTargetingOptionIdAlias string,
 :keywordDetails {:keyword string, :negative boolean},
 :urlDetails {:url string, :negative boolean},
 :exchangeDetails
 {:exchange
  [EXCHANGE_UNSPECIFIED
   EXCHANGE_GOOGLE_AD_MANAGER
   EXCHANGE_APPNEXUS
   EXCHANGE_BRIGHTROLL
   EXCHANGE_ADFORM
   EXCHANGE_ADMETA
   EXCHANGE_ADMIXER
   EXCHANGE_ADSMOGO
   EXCHANGE_ADSWIZZ
   EXCHANGE_BIDSWITCH
   EXCHANGE_BRIGHTROLL_DISPLAY
   EXCHANGE_CADREON
   EXCHANGE_DAILYMOTION
   EXCHANGE_FIVE
   EXCHANGE_FLUCT
   EXCHANGE_FREEWHEEL
   EXCHANGE_GENIEE
   EXCHANGE_GUMGUM
   EXCHANGE_IMOBILE
   EXCHANGE_IBILLBOARD
   EXCHANGE_IMPROVE_DIGITAL
   EXCHANGE_INDEX
   EXCHANGE_KARGO
   EXCHANGE_MICROAD
   EXCHANGE_MOPUB
   EXCHANGE_NEND
   EXCHANGE_ONE_BY_AOL_DISPLAY
   EXCHANGE_ONE_BY_AOL_MOBILE
   EXCHANGE_ONE_BY_AOL_VIDEO
   EXCHANGE_OOYALA
   EXCHANGE_OPENX
   EXCHANGE_PERMODO
   EXCHANGE_PLATFORMONE
   EXCHANGE_PLATFORMID
   EXCHANGE_PUBMATIC
   EXCHANGE_PULSEPOINT
   EXCHANGE_REVENUEMAX
   EXCHANGE_RUBICON
   EXCHANGE_SMARTCLIP
   EXCHANGE_SMARTRTB
   EXCHANGE_SMARTSTREAMTV
   EXCHANGE_SOVRN
   EXCHANGE_SPOTXCHANGE
   EXCHANGE_STROER
   EXCHANGE_TEADSTV
   EXCHANGE_TELARIA
   EXCHANGE_TVN
   EXCHANGE_UNITED
   EXCHANGE_YIELDLAB
   EXCHANGE_YIELDMO
   EXCHANGE_UNRULYX
   EXCHANGE_OPEN8
   EXCHANGE_TRITON
   EXCHANGE_TRIPLELIFT
   EXCHANGE_TABOOLA
   EXCHANGE_INMOBI
   EXCHANGE_SMAATO
   EXCHANGE_AJA
   EXCHANGE_SUPERSHIP
   EXCHANGE_NEXSTAR_DIGITAL
   EXCHANGE_WAZE
   EXCHANGE_SOUNDCAST
   EXCHANGE_SHARETHROUGH
   EXCHANGE_FYBER
   EXCHANGE_RED_FOR_PUBLISHERS
   EXCHANGE_MEDIANET
   EXCHANGE_TAPJOY
   EXCHANGE_VISTAR
   EXCHANGE_DAX
   EXCHANGE_JCD
   EXCHANGE_PLACE_EXCHANGE
   EXCHANGE_APPLOVIN
   EXCHANGE_CONNATIX
   EXCHANGE_RESET_DIGITAL
   EXCHANGE_HIVESTACK
   EXCHANGE_DRAX
   EXCHANGE_APPLOVIN_GBID
   EXCHANGE_FYBER_GBID
   EXCHANGE_UNITY_GBID
   EXCHANGE_CHARTBOOST_GBID
   EXCHANGE_ADMOST_GBID
   EXCHANGE_TOPON_GBID]},
 :dayAndTimeDetails
 {:dayOfWeek
  [DAY_OF_WEEK_UNSPECIFIED
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY],
  :startHour integer,
  :endHour integer,
  :timeZoneResolution
  [TIME_ZONE_RESOLUTION_UNSPECIFIED
   TIME_ZONE_RESOLUTION_END_USER
   TIME_ZONE_RESOLUTION_ADVERTISER]},
 :householdIncomeDetails
 {:householdIncome
  [HOUSEHOLD_INCOME_UNSPECIFIED
   HOUSEHOLD_INCOME_UNKNOWN
   HOUSEHOLD_INCOME_LOWER_50_PERCENT
   HOUSEHOLD_INCOME_TOP_41_TO_50_PERCENT
   HOUSEHOLD_INCOME_TOP_31_TO_40_PERCENT
   HOUSEHOLD_INCOME_TOP_21_TO_30_PERCENT
   HOUSEHOLD_INCOME_TOP_11_TO_20_PERCENT
   HOUSEHOLD_INCOME_TOP_10_PERCENT]},
 :authorizedSellerStatusDetails
 {:authorizedSellerStatus
  [AUTHORIZED_SELLER_STATUS_UNSPECIFIED
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_DIRECT_SELLERS_ONLY
   AUTHORIZED_SELLER_STATUS_AUTHORIZED_AND_NON_PARTICIPATING_PUBLISHERS],
  :targetingOptionId string},
 :contentOutstreamPositionDetails
 {:contentOutstreamPosition
  [CONTENT_OUTSTREAM_POSITION_UNSPECIFIED
   CONTENT_OUTSTREAM_POSITION_UNKNOWN
   CONTENT_OUTSTREAM_POSITION_IN_ARTICLE
   CONTENT_OUTSTREAM_POSITION_IN_BANNER
   CONTENT_OUTSTREAM_POSITION_IN_FEED
   CONTENT_OUTSTREAM_POSITION_INTERSTITIAL],
  :adType
  [AD_TYPE_UNSPECIFIED AD_TYPE_DISPLAY AD_TYPE_VIDEO AD_TYPE_AUDIO]},
 :youtubeChannelDetails {:channelId string, :negative boolean},
 :userRewardedContentDetails
 {:targetingOptionId string,
  :userRewardedContent
  [USER_REWARDED_CONTENT_UNSPECIFIED
   USER_REWARDED_CONTENT_USER_REWARDED
   USER_REWARDED_CONTENT_NOT_USER_REWARDED]},
 :omidDetails {:omid [OMID_UNSPECIFIED OMID_FOR_MOBILE_DISPLAY_ADS]}}"
  [partnerId targetingType AssignedTargetingOption]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions",
     :uri-template-args
     {:partnerId partnerId, :targetingType targetingType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body AssignedTargetingOption}))

(defn partners-targetingTypes-assignedTargetingOptions-delete
  "Deletes an assigned targeting option from a partner.
https://developers.google.com/display-video/api/guides/getting-started/overview

partnerId <string> Required. The ID of the partner.
targetingType <string> Required. Identifies the type of this assigned targeting option. Supported targeting types: * `TARGETING_TYPE_CHANNEL`
assignedTargetingOptionId <string> Required. The ID of the assigned targeting option to delete."
  [partnerId targetingType assignedTargetingOptionId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}",
     :uri-template-args
     {:partnerId partnerId,
      :targetingType targetingType,
      :assignedTargetingOptionId assignedTargetingOptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"]}))

(defn combinedAudiences-get
  "Gets a combined audience.
https://developers.google.com/display-video/api/guides/getting-started/overview

combinedAudienceId <string> Required. The ID of the combined audience to fetch.

optional:
partnerId <string> The ID of the partner that has access to the fetched combined audience.
advertiserId <string> The ID of the advertiser that has access to the fetched combined audience."
  ([combinedAudienceId] (combinedAudiences-get combinedAudienceId nil))
  ([combinedAudienceId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/combinedAudiences/{+combinedAudienceId}",
       :uri-template-args {:combinedAudienceId combinedAudienceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn combinedAudiences-list
  "Lists combined audiences. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> The ID of the partner that has access to the fetched combined audiences.
advertiserId <string> The ID of the advertiser that has access to the fetched combined audiences.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `combinedAudienceId` (default) * `displayName` The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by combined audience fields. Supported syntax: * Filter expressions for combined audiences can only contain at most one restriction. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `HAS (:)` operator. Supported fields: * `displayName` Examples: * All combined audiences for which the display name contains \"Google\": `displayName : \"Google\"`. The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (combinedAudiences-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/combinedAudiences",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn targetingTypes-targetingOptions-get
  "Gets a single targeting option.
https://developers.google.com/display-video/api/guides/getting-started/overview

targetingType <string> Required. The type of targeting option to retrieve. Accepted values are: * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_VIEWABILITY` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_OMID`
targetingOptionId <string> Required. The ID of the of targeting option to retrieve.

optional:
advertiserId <string> Required. The Advertiser this request is being made in the context of."
  ([targetingType targetingOptionId]
    (targetingTypes-targetingOptions-get
      targetingType
      targetingOptionId
      nil))
  ([targetingType targetingOptionId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/targetingTypes/{+targetingType}/targetingOptions/{+targetingOptionId}",
       :uri-template-args
       {:targetingType targetingType,
        :targetingOptionId targetingOptionId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn targetingTypes-targetingOptions-list
  "Lists targeting options of a given type.
https://developers.google.com/display-video/api/guides/getting-started/overview

targetingType <string> Required. The type of targeting option to be listed. Accepted values are: * `TARGETING_TYPE_APP_CATEGORY` * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_VIDEO_PLAYER_SIZE` * `TARGETING_TYPE_USER_REWARDED_CONTENT` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_CONTENT_INSTREAM_POSITION` * `TARGETING_TYPE_CONTENT_OUTSTREAM_POSITION` * `TARGETING_TYPE_DEVICE_TYPE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_HOUSEHOLD_INCOME` * `TARGETING_TYPE_ON_SCREEN_POSITION` * `TARGETING_TYPE_CARRIER_AND_ISP` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_VIEWABILITY` * `TARGETING_TYPE_AUTHORIZED_SELLER_STATUS` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_EXCHANGE` * `TARGETING_TYPE_SUB_EXCHANGE` * `TARGETING_TYPE_NATIVE_CONTENT_POSITION` * `TARGETING_TYPE_OMID`

optional:
advertiserId <string> Required. The Advertiser this request is being made in the context of.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `targetingOptionId` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `targetingOptionId desc`.
filter <string> Allows filtering by targeting option fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `OR` logical operators. * A restriction has the form of `{field} {operator} {value}`. * All fields must use the `EQUALS (=)` operator. Supported fields: * `carrierAndIspDetails.type` * `geoRegionDetails.geoRegionType` * `targetingOptionId` Examples: * All `GEO REGION` targeting options that belong to sub type `GEO_REGION_TYPE_COUNTRY` or `GEO_REGION_TYPE_STATE`: `geoRegionDetails.geoRegionType=\"GEO_REGION_TYPE_COUNTRY\" OR geoRegionDetails.geoRegionType=\"GEO_REGION_TYPE_STATE\"` * All `CARRIER AND ISP` targeting options that belong to sub type `CARRIER_AND_ISP_TYPE_CARRIER`: `carrierAndIspDetails.type=\"CARRIER_AND_ISP_TYPE_CARRIER\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([targetingType]
    (targetingTypes-targetingOptions-list targetingType nil))
  ([targetingType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/targetingTypes/{+targetingType}/targetingOptions",
       :uri-template-args {:targetingType targetingType},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn targetingTypes-targetingOptions-search
  "Searches for targeting options of a given type based on the given search terms.
https://developers.google.com/display-video/api/guides/getting-started/overview

targetingType <string> Required. The type of targeting options to retrieve. Accepted values are: * `TARGETING_TYPE_GEO_REGION` * `TARGETING_TYPE_POI` * `TARGETING_TYPE_BUSINESS_CHAIN`
SearchTargetingOptionsRequest:
{:advertiserId string,
 :pageSize integer,
 :pageToken string,
 :poiSearchTerms {:poiQuery string},
 :businessChainSearchTerms
 {:businessChainQuery string, :regionQuery string},
 :geoRegionSearchTerms {:geoRegionQuery string}}"
  [targetingType SearchTargetingOptionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/targetingTypes/{+targetingType}/targetingOptions:search",
     :uri-template-args {:targetingType targetingType},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body SearchTargetingOptionsRequest}))

(defn customBiddingAlgorithms-uploadRules
  "Creates a rules reference object for an AlgorithmRules file. The resulting reference object provides a resource path where the AlgorithmRules file should be uploaded. This reference object should be included when creating a new CustomBiddingAlgorithmRules resource.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm that owns the rules resource.

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm."
  ([customBiddingAlgorithmId]
    (customBiddingAlgorithms-uploadRules customBiddingAlgorithmId nil))
  ([customBiddingAlgorithmId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}:uploadRules",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customBiddingAlgorithms-get
  "Gets a custom bidding algorithm.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm to fetch.

optional:
partnerId <string> The ID of the DV360 partner that has access to the custom bidding algorithm.
advertiserId <string> The ID of the DV360 partner that has access to the custom bidding algorithm."
  ([customBiddingAlgorithmId]
    (customBiddingAlgorithms-get customBiddingAlgorithmId nil))
  ([customBiddingAlgorithmId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customBiddingAlgorithms-list
  "Lists custom bidding algorithms that are accessible to the current user and can be used in bidding stratgies. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
partnerId <string> The ID of the DV360 partner that has access to the custom bidding algorithm.
advertiserId <string> The ID of the DV360 advertiser that has access to the custom bidding algorithm.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. Example: `displayName desc`.
filter <string> Allows filtering by custom bidding algorithm fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND`. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * The `customBiddingAlgorithmType` field must use the `EQUALS (=)` operator. * The `displayName` field must use the `HAS (:)` operator. Supported fields: * `customBiddingAlgorithmType` * `displayName` Examples: * All custom bidding algorithms for which the display name contains \"politics\": `displayName:\"politics\"`. * All custom bidding algorithms for which the type is \"SCRIPT_BASED\": `customBiddingAlgorithmType=SCRIPT_BASED` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (customBiddingAlgorithms-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customBiddingAlgorithms-create
  "Creates a new custom bidding algorithm. Returns the newly created custom bidding algorithm if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

CustomBiddingAlgorithm:
{:customBiddingAlgorithmType
 [CUSTOM_BIDDING_ALGORITHM_TYPE_UNSPECIFIED
  SCRIPT_BASED
  ADS_DATA_HUB_BASED
  GOAL_BUILDER_BASED
  RULE_BASED],
 :customBiddingAlgorithmId string,
 :displayName string,
 :name string,
 :sharedAdvertiserIds [string],
 :advertiserId string,
 :modelDetails
 [{:advertiserId string,
   :readinessState
   [READINESS_STATE_UNSPECIFIED
    READINESS_STATE_ACTIVE
    READINESS_STATE_INSUFFICIENT_DATA
    READINESS_STATE_TRAINING
    READINESS_STATE_NO_VALID_SCRIPT
    READINESS_STATE_EVALUATION_FAILURE],
   :suspensionState
   [SUSPENSION_STATE_UNSPECIFIED
    SUSPENSION_STATE_ENABLED
    SUSPENSION_STATE_DORMANT
    SUSPENSION_STATE_SUSPENDED]}],
 :partnerId string,
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}"
  [CustomBiddingAlgorithm]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body CustomBiddingAlgorithm}))

(defn customBiddingAlgorithms-patch
  "Updates an existing custom bidding algorithm. Returns the updated custom bidding algorithm if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Output only. The unique ID of the custom bidding algorithm. Assigned by the system.
CustomBiddingAlgorithm:
{:customBiddingAlgorithmType
 [CUSTOM_BIDDING_ALGORITHM_TYPE_UNSPECIFIED
  SCRIPT_BASED
  ADS_DATA_HUB_BASED
  GOAL_BUILDER_BASED
  RULE_BASED],
 :customBiddingAlgorithmId string,
 :displayName string,
 :name string,
 :sharedAdvertiserIds [string],
 :advertiserId string,
 :modelDetails
 [{:advertiserId string,
   :readinessState
   [READINESS_STATE_UNSPECIFIED
    READINESS_STATE_ACTIVE
    READINESS_STATE_INSUFFICIENT_DATA
    READINESS_STATE_TRAINING
    READINESS_STATE_NO_VALID_SCRIPT
    READINESS_STATE_EVALUATION_FAILURE],
   :suspensionState
   [SUSPENSION_STATE_UNSPECIFIED
    SUSPENSION_STATE_ENABLED
    SUSPENSION_STATE_DORMANT
    SUSPENSION_STATE_SUSPENDED]}],
 :partnerId string,
 :entityStatus
 [ENTITY_STATUS_UNSPECIFIED
  ENTITY_STATUS_ACTIVE
  ENTITY_STATUS_ARCHIVED
  ENTITY_STATUS_DRAFT
  ENTITY_STATUS_PAUSED
  ENTITY_STATUS_SCHEDULED_FOR_DELETION]}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([customBiddingAlgorithmId CustomBiddingAlgorithm]
    (customBiddingAlgorithms-patch
      customBiddingAlgorithmId
      CustomBiddingAlgorithm
      nil))
  ([customBiddingAlgorithmId CustomBiddingAlgorithm optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body CustomBiddingAlgorithm})))

(defn customBiddingAlgorithms-uploadScript
  "Creates a custom bidding script reference object for a script file. The resulting reference object provides a resource path to which the script file should be uploaded. This reference object should be included in when creating a new custom bidding script object.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm owns the script.

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm. Only this partner will have write access to this custom bidding script.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm."
  ([customBiddingAlgorithmId]
    (customBiddingAlgorithms-uploadScript
      customBiddingAlgorithmId
      nil))
  ([customBiddingAlgorithmId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}:uploadScript",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customBiddingAlgorithms-rules-create
  "Creates a new rules resource. Returns the newly created rules resource if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm that owns the rules resource.
CustomBiddingAlgorithmRules:
{:name string,
 :customBiddingAlgorithmId string,
 :customBiddingAlgorithmRulesId string,
 :createTime string,
 :active boolean,
 :state [STATE_UNSPECIFIED ACCEPTED REJECTED],
 :error
 {:errorCode
  [ERROR_CODE_UNSPECIFIED
   SYNTAX_ERROR
   CONSTRAINT_VIOLATION_ERROR
   INTERNAL_ERROR]},
 :rules {:resourceName string}}

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm. Only this partner will have write access to this rules resource.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm."
  ([customBiddingAlgorithmId CustomBiddingAlgorithmRules]
    (customBiddingAlgorithms-rules-create
      customBiddingAlgorithmId
      CustomBiddingAlgorithmRules
      nil))
  ([customBiddingAlgorithmId CustomBiddingAlgorithmRules optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/rules",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body CustomBiddingAlgorithmRules})))

(defn customBiddingAlgorithms-rules-get
  "Retrieves a rules resource.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm that owns the rules resource.
customBiddingAlgorithmRulesId <string> Required. The ID of the rules resource to fetch.

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm."
  ([customBiddingAlgorithmId customBiddingAlgorithmRulesId]
    (customBiddingAlgorithms-rules-get
      customBiddingAlgorithmId
      customBiddingAlgorithmRulesId
      nil))
  ([customBiddingAlgorithmId customBiddingAlgorithmRulesId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/rules/{+customBiddingAlgorithmRulesId}",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId,
        :customBiddingAlgorithmRulesId customBiddingAlgorithmRulesId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customBiddingAlgorithms-rules-list
  "Lists rules resources that belong to the given algorithm. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm that owns the rules resource.

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `createTime desc` (default) The default sorting order is descending. To specify ascending order for a field, the suffix \"desc\" should be removed. Example: `createTime`."
  ([customBiddingAlgorithmId]
    (customBiddingAlgorithms-rules-list customBiddingAlgorithmId nil))
  ([customBiddingAlgorithmId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/rules",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customBiddingAlgorithms-scripts-create
  "Creates a new custom bidding script. Returns the newly created script if successful.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm that owns the script.
CustomBiddingScript:
{:name string,
 :customBiddingAlgorithmId string,
 :customBiddingScriptId string,
 :createTime string,
 :active boolean,
 :state [STATE_UNSPECIFIED ACCEPTED REJECTED PENDING],
 :errors
 [{:errorCode
   [ERROR_CODE_UNSPECIFIED
    SYNTAX_ERROR
    DEPRECATED_SYNTAX
    INTERNAL_ERROR],
   :line string,
   :column string,
   :errorMessage string}],
 :script {:resourceName string}}

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm. Only this partner will have write access to this custom bidding script.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm."
  ([customBiddingAlgorithmId CustomBiddingScript]
    (customBiddingAlgorithms-scripts-create
      customBiddingAlgorithmId
      CustomBiddingScript
      nil))
  ([customBiddingAlgorithmId CustomBiddingScript optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/scripts",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"],
       :body CustomBiddingScript})))

(defn customBiddingAlgorithms-scripts-get
  "Gets a custom bidding script.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm owns the script.
customBiddingScriptId <string> Required. The ID of the custom bidding script to fetch.

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm. Only this partner will have write access to this custom bidding script.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm."
  ([customBiddingAlgorithmId customBiddingScriptId]
    (customBiddingAlgorithms-scripts-get
      customBiddingAlgorithmId
      customBiddingScriptId
      nil))
  ([customBiddingAlgorithmId customBiddingScriptId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/scripts/{+customBiddingScriptId}",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId,
        :customBiddingScriptId customBiddingScriptId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn customBiddingAlgorithms-scripts-list
  "Lists custom bidding scripts that belong to the given algorithm. The order is defined by the order_by parameter.
https://developers.google.com/display-video/api/guides/getting-started/overview

customBiddingAlgorithmId <string> Required. The ID of the custom bidding algorithm owns the script.

optional:
partnerId <string> The ID of the partner that owns the parent custom bidding algorithm. Only this partner will have write access to this custom bidding script.
advertiserId <string> The ID of the advertiser that owns the parent custom bidding algorithm.
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`. Returns error code `INVALID_ARGUMENT` if an invalid value is specified.
orderBy <string> Field by which to sort the list. Acceptable values are: * `createTime desc` (default) The default sorting order is descending. To specify ascending order for a field, the suffix \"desc\" should be removed. Example: `createTime`."
  ([customBiddingAlgorithmId]
    (customBiddingAlgorithms-scripts-list
      customBiddingAlgorithmId
      nil))
  ([customBiddingAlgorithmId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://displayvideo.googleapis.com/v3/customBiddingAlgorithms/{+customBiddingAlgorithmId}/scripts",
       :uri-template-args
       {:customBiddingAlgorithmId customBiddingAlgorithmId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/display-video"]})))

(defn media-upload
  "Uploads media. Upload is supported on the URI `/upload/media/{resource_name=**}?upload_type=media.` **Note**: Upload requests will not be successful without including `upload_type=media` query string.
https://developers.google.com/display-video/api/guides/getting-started/overview

resourceName <string> Name of the media that is being downloaded. See ReadRequest.resource_name.
GoogleBytestreamMedia:
{:resourceName string}"
  [resourceName GoogleBytestreamMedia]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/media/{+resourceName}",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video"
      "https://www.googleapis.com/auth/doubleclickbidmanager"],
     :body GoogleBytestreamMedia}))

(defn media-download
  "Downloads media. Download is supported on the URI `/download/{resource_name=**}?alt=media.` **Note**: Download requests will not be successful without including `alt=media` query string.
https://developers.google.com/display-video/api/guides/getting-started/overview

resourceName <string> Name of the media that is being downloaded. See ReadRequest.resource_name."
  [resourceName]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/download/{+resourceName}",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video"
      "https://www.googleapis.com/auth/doubleclickbidmanager"]}))

(defn sdfdownloadtasks-create
  "Creates an SDF Download Task. Returns an Operation. An SDF Download Task is a long-running, asynchronous operation. The metadata type of this operation is SdfDownloadTaskMetadata. If the request is successful, the response type of the operation is SdfDownloadTask. The response will not include the download files, which must be retrieved with media.download. The state of operation can be retrieved with sdfdownloadtask.operations.get. Any errors can be found in the error.message. Note that error.details is expected to be empty.
https://developers.google.com/display-video/api/guides/getting-started/overview

CreateSdfDownloadTaskRequest:
{:partnerId string,
 :advertiserId string,
 :parentEntityFilter
 {:fileType
  [[FILE_TYPE_UNSPECIFIED
    FILE_TYPE_CAMPAIGN
    FILE_TYPE_MEDIA_PRODUCT
    FILE_TYPE_INSERTION_ORDER
    FILE_TYPE_LINE_ITEM
    FILE_TYPE_AD_GROUP
    FILE_TYPE_AD]],
  :filterType
  [FILTER_TYPE_UNSPECIFIED
   FILTER_TYPE_NONE
   FILTER_TYPE_ADVERTISER_ID
   FILTER_TYPE_CAMPAIGN_ID
   FILTER_TYPE_MEDIA_PRODUCT_ID
   FILTER_TYPE_INSERTION_ORDER_ID
   FILTER_TYPE_LINE_ITEM_ID],
  :filterIds [string]},
 :idFilter
 {:campaignIds [string],
  :mediaProductIds [string],
  :insertionOrderIds [string],
  :lineItemIds [string],
  :adGroupIds [string],
  :adGroupAdIds [string]},
 :inventorySourceFilter {:inventorySourceIds [string]},
 :version
 [SDF_VERSION_UNSPECIFIED
  SDF_VERSION_3_1
  SDF_VERSION_4
  SDF_VERSION_4_1
  SDF_VERSION_4_2
  SDF_VERSION_5
  SDF_VERSION_5_1
  SDF_VERSION_5_2
  SDF_VERSION_5_3
  SDF_VERSION_5_4
  SDF_VERSION_5_5
  SDF_VERSION_6
  SDF_VERSION_7
  SDF_VERSION_7_1]}"
  [CreateSdfDownloadTaskRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/sdfdownloadtasks",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/display-video"],
     :body CreateSdfDownloadTaskRequest}))

(defn sdfdownloadtasks-operations-get
  "Gets the latest state of an asynchronous SDF download task operation. Clients should poll this method at intervals of 30 seconds.
https://developers.google.com/display-video/api/guides/getting-started/overview

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://displayvideo.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video"
      "https://www.googleapis.com/auth/doubleclickbidmanager"]}))

(defn users-get
  "Gets a user. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method.
https://developers.google.com/display-video/api/guides/getting-started/overview

userId <string> Required. The ID of the user to fetch."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://displayvideo.googleapis.com/v3/users/{+userId}",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video-user-management"]}))

(defn users-list
  "Lists users that are accessible to the current user. If two users have user roles on the same partner or advertiser, they can access each other. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method.
https://developers.google.com/display-video/api/guides/getting-started/overview

optional:
pageSize <integer> Requested page size. Must be between `1` and `200`. If unspecified will default to `100`.
orderBy <string> Field by which to sort the list. Acceptable values are: * `displayName` (default) The default sorting order is ascending. To specify descending order for a field, a suffix \"desc\" should be added to the field name. For example, `displayName desc`.
filter <string> Allows filtering by user fields. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by the logical operator `AND`. * A restriction has the form of `{field} {operator} {value}`. * The `displayName` and `email` fields must use the `HAS (:)` operator. * The `lastLoginTime` field must use either the `LESS THAN OR EQUAL TO (<=)` or `GREATER THAN OR EQUAL TO (>=)` operator. * All other fields must use the `EQUALS (=)` operator. Supported fields: * `assignedUserRole.advertiserId` * `assignedUserRole.entityType`: This is synthetic field of `AssignedUserRole` used for filtering. Identifies the type of entity to which the user role is assigned. Valid values are `Partner` and `Advertiser`. * `assignedUserRole.parentPartnerId`: This is a synthetic field of `AssignedUserRole` used for filtering. Identifies the parent partner of the entity to which the user role is assigned. * `assignedUserRole.partnerId` * `assignedUserRole.userRole` * `displayName` * `email` * `lastLoginTime` (input in ISO 8601 format, or `YYYY-MM-DDTHH:MM:SSZ`) Examples: * The user with `displayName` containing \"foo\": `displayName:\"foo\"` * The user with `email` containing \"bar\": `email:\"bar\"` * All users with standard user roles: `assignedUserRole.userRole=\"STANDARD\"` * All users with user roles for partner 123: `assignedUserRole.partnerId=\"123\"` * All users with user roles for advertiser 123: `assignedUserRole.advertiserId=\"123\"` * All users with partner level user roles: `entityType=\"PARTNER\"` * All users with user roles for partner 123 and advertisers under partner 123: `parentPartnerId=\"123\"` * All users that last logged in on or after 2023-01-01T00:00:00Z (format of ISO 8601): `lastLoginTime>=\"2023-01-01T00:00:00Z\"` The length of this field should be no more than 500 characters. Reference our [filter `LIST` requests](/display-video/api/guides/how-tos/filters) guide for more information."
  ([] (users-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://displayvideo.googleapis.com/v3/users",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/display-video-user-management"]})))

(defn users-create
  "Creates a new user. Returns the newly created user if successful. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method.
https://developers.google.com/display-video/api/guides/getting-started/overview

User:
{:name string,
 :userId string,
 :email string,
 :displayName string,
 :assignedUserRoles
 [{:assignedUserRoleId string,
   :partnerId string,
   :advertiserId string,
   :userRole
   [USER_ROLE_UNSPECIFIED
    ADMIN
    ADMIN_PARTNER_CLIENT
    STANDARD
    STANDARD_PLANNER
    STANDARD_PLANNER_LIMITED
    STANDARD_PARTNER_CLIENT
    READ_ONLY
    REPORTING_ONLY
    LIMITED_REPORTING_ONLY
    CREATIVE
    CREATIVE_ADMIN]}],
 :lastLoginTime string}"
  [User]
  (client/api-request
    {:method "POST",
     :uri-template "https://displayvideo.googleapis.com/v3/users",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video-user-management"],
     :body User}))

(defn users-patch
  "Updates an existing user. Returns the updated user if successful. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method.
https://developers.google.com/display-video/api/guides/getting-started/overview

userId <string> Output only. The unique ID of the user. Assigned by the system.
User:
{:name string,
 :userId string,
 :email string,
 :displayName string,
 :assignedUserRoles
 [{:assignedUserRoleId string,
   :partnerId string,
   :advertiserId string,
   :userRole
   [USER_ROLE_UNSPECIFIED
    ADMIN
    ADMIN_PARTNER_CLIENT
    STANDARD
    STANDARD_PLANNER
    STANDARD_PLANNER_LIMITED
    STANDARD_PARTNER_CLIENT
    READ_ONLY
    REPORTING_ONLY
    LIMITED_REPORTING_ONLY
    CREATIVE
    CREATIVE_ADMIN]}],
 :lastLoginTime string}

optional:
updateMask <string> Required. The mask to control which fields to update."
  ([userId User] (users-patch userId User nil))
  ([userId User optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://displayvideo.googleapis.com/v3/users/{+userId}",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/display-video-user-management"],
       :body User})))

(defn users-delete
  "Deletes a user. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method.
https://developers.google.com/display-video/api/guides/getting-started/overview

userId <string> Required. The ID of the user to delete."
  [userId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://displayvideo.googleapis.com/v3/users/{+userId}",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video-user-management"]}))

(defn users-bulkEditAssignedUserRoles
  "Bulk edits user roles for a user. The operation will delete the assigned user roles provided in BulkEditAssignedUserRolesRequest.deletedAssignedUserRoles and then assign the user roles provided in BulkEditAssignedUserRolesRequest.createdAssignedUserRoles. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method.
https://developers.google.com/display-video/api/guides/getting-started/overview

userId <string> Required. The ID of the user to which the assigned user roles belong.
BulkEditAssignedUserRolesRequest:
{:deletedAssignedUserRoles [string],
 :createdAssignedUserRoles
 [{:assignedUserRoleId string,
   :partnerId string,
   :advertiserId string,
   :userRole
   [USER_ROLE_UNSPECIFIED
    ADMIN
    ADMIN_PARTNER_CLIENT
    STANDARD
    STANDARD_PLANNER
    STANDARD_PLANNER_LIMITED
    STANDARD_PARTNER_CLIENT
    READ_ONLY
    REPORTING_ONLY
    LIMITED_REPORTING_ONLY
    CREATIVE
    CREATIVE_ADMIN]}]}"
  [userId BulkEditAssignedUserRolesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://displayvideo.googleapis.com/v3/users/{+userId}:bulkEditAssignedUserRoles",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/display-video-user-management"],
     :body BulkEditAssignedUserRolesRequest}))

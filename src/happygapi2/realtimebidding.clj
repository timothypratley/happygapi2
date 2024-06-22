(ns happygapi2.realtimebidding
  "Real-time Bidding API
Allows external bidders to manage their RTB integration with Google. This includes managing bidder endpoints, QPS quotas, configuring what ad inventory to receive via pretargeting, submitting creatives for verification, and accessing creative metadata such as approval status.
See: https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/"
  (:require [happy.oauth2.client :as client]))

(defn bidders-get
  "Gets a bidder account by its name.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders/get

name <string> Required. Name of the bidder to get. Format: `bidders/{bidderAccountId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn bidders-list
  "Lists all the bidder accounts that belong to the caller.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders/list

optional:
pageSize <integer> The maximum number of bidders to return. If unspecified, at most 100 bidders will be returned. The maximum value is 500; values above 500 will be coerced to 500."
  ([] (bidders-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/bidders",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn bidders-endpoints-get
  "Gets a bidder endpoint by its name.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.endpoints/get

name <string> Required. Name of the bidder endpoint to get. Format: `bidders/{bidderAccountId}/endpoints/{endpointId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn bidders-endpoints-list
  "Lists all the bidder's endpoints.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.endpoints/list

parent <string> Required. Name of the bidder whose endpoints will be listed. Format: `bidders/{bidderAccountId}`

optional:
pageSize <integer> The maximum number of endpoints to return. If unspecified, at most 100 endpoints will be returned. The maximum value is 500; values above 500 will be coerced to 500."
  ([parent] (bidders-endpoints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+parent}/endpoints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn bidders-endpoints-patch
  "Updates a bidder's endpoint.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.endpoints/patch

name <string> Output only. Name of the endpoint resource that must follow the pattern `bidders/{bidderAccountId}/endpoints/{endpointId}`, where {bidderAccountId} is the account ID of the bidder who operates this endpoint, and {endpointId} is a unique ID assigned by the server.
Endpoint:
{:name string,
 :url string,
 :maximumQps string,
 :tradingLocation
 [TRADING_LOCATION_UNSPECIFIED US_WEST US_EAST EUROPE ASIA],
 :bidProtocol
 [BID_PROTOCOL_UNSPECIFIED GOOGLE_RTB OPENRTB_JSON OPENRTB_PROTOBUF]}

optional:
updateMask <string> Field mask to use for partial in-place updates."
  ([name Endpoint] (bidders-endpoints-patch name Endpoint nil))
  ([name Endpoint optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
       :body Endpoint})))

(defn bidders-creatives-list
  "Lists creatives as they are at the time of the initial request. This call may take multiple hours to complete. For large, paginated requests, this method returns a snapshot of creatives at the time of request for the first page. `lastStatusUpdate` and `creativeServingDecision` may be outdated for creatives on sequential pages. We recommend [Google Cloud Pub/Sub](//cloud.google.com/pubsub/docs/overview) to view the latest status.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.creatives/list

parent <string> Required. Name of the parent buyer that owns the creatives. The pattern for this resource is either `buyers/{buyerAccountId}` or `bidders/{bidderAccountId}`. For `buyers/{buyerAccountId}`, the `buyerAccountId` can be one of the following: 1. The ID of the buyer that is accessing their own creatives. 2. The ID of the child seat buyer under a bidder account. So for listing creatives pertaining to the child seat buyer (`456`) under bidder account (`123`), you would use the pattern: `buyers/456`. 3. The ID of the bidder itself. So for listing creatives pertaining to bidder (`123`), you would use `buyers/123`. If you want to access all creatives pertaining to both the bidder and all of its child seat accounts, you would use `bidders/{bidderAccountId}`, for example, for all creatives pertaining to bidder (`123`), use `bidders/123`.

optional:
pageSize <integer> Requested page size. The server may return fewer creatives than requested (due to timeout constraint) even if more are available through another call. If unspecified, server will pick an appropriate default. Acceptable values are 1 to 1000, inclusive.
filter <string> Query string to filter creatives. If no filter is specified, all active creatives will be returned. Example: 'accountId=12345 AND (dealsStatus:DISAPPROVED AND disapprovalReason:UNACCEPTABLE_CONTENT) OR declaredAttributes:IS_COOKIE_TARGETED'
view <string> Controls the amount of information included in the response. By default only creativeServingDecision is included. To retrieve the entire creative resource (including the declared fields and the creative content) specify the view as \"FULL\"."
  ([parent] (bidders-creatives-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+parent}/creatives",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn bidders-creatives-watch
  "Watches all creatives pertaining to a bidder. It is sufficient to invoke this endpoint once per bidder. A Pub/Sub topic will be created and notifications will be pushed to the topic when any of the bidder's creatives change status. All of the bidder's service accounts will have access to read from the topic. Subsequent invocations of this method will return the existing Pub/Sub configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.creatives/watch

parent <string> Required. To watch all creatives pertaining to the bidder and all its child seat accounts, the bidder must follow the pattern `bidders/{bidderAccountId}`.
WatchCreativesRequest:
object"
  [parent WatchCreativesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+parent}/creatives:watch",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body WatchCreativesRequest}))

(defn bidders-pretargetingConfigs-get
  "Gets a pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/get

name <string> Required. Name of the pretargeting configuration to get. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn bidders-pretargetingConfigs-addTargetedSites
  "Adds targeted sites to the pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/addTargetedSites

pretargetingConfig <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
AddTargetedSitesRequest:
{:sites [string],
 :targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE]}"
  [pretargetingConfig AddTargetedSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+pretargetingConfig}:addTargetedSites",
     :uri-template-args {:pretargetingConfig pretargetingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body AddTargetedSitesRequest}))

(defn bidders-pretargetingConfigs-patch
  "Updates a pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/patch

name <string> Output only. Name of the pretargeting configuration that must follow the pattern `bidders/{bidder_account_id}/pretargetingConfigs/{config_id}`
PretargetingConfig:
{:billingId string,
 :geoTargeting {:includedIds [string], :excludedIds [string]},
 :includedMobileOperatingSystemIds [string],
 :invalidGeoIds [string],
 :verticalTargeting {:includedIds [string], :excludedIds [string]},
 :displayName string,
 :name string,
 :userListTargeting {:includedIds [string], :excludedIds [string]},
 :includedLanguages [string],
 :appTargeting
 {:mobileAppTargeting
  {:targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE],
   :values [string]},
  :mobileAppCategoryTargeting
  {:includedIds [string], :excludedIds [string]}},
 :webTargeting
 {:targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE],
  :values [string]},
 :allowedUserTargetingModes
 [[USER_TARGETING_MODE_UNSPECIFIED
   REMARKETING_ADS
   INTEREST_BASED_TARGETING]],
 :state [STATE_UNSPECIFIED ACTIVE SUSPENDED],
 :maximumQps string,
 :includedUserIdTypes
 [[USER_ID_TYPE_UNSPECIFIED
   HOSTED_MATCH_DATA
   GOOGLE_COOKIE
   DEVICE_ID
   PUBLISHER_PROVIDED_ID]],
 :includedPlatforms
 [[PLATFORM_UNSPECIFIED PERSONAL_COMPUTER PHONE TABLET CONNECTED_TV]],
 :excludedContentLabelIds [string],
 :interstitialTargeting
 [INTERSTITIAL_TARGETING_UNSPECIFIED
  ONLY_INTERSTITIAL_REQUESTS
  ONLY_NON_INTERSTITIAL_REQUESTS],
 :includedEnvironments [[ENVIRONMENT_UNSPECIFIED APP WEB]],
 :includedFormats [[CREATIVE_FORMAT_UNSPECIFIED HTML VAST NATIVE]],
 :minimumViewabilityDecile integer,
 :includedCreativeDimensions [{:width string, :height string}],
 :publisherTargeting
 {:targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE],
  :values [string]}}

optional:
updateMask <string> Field mask to use for partial in-place updates."
  ([name PretargetingConfig]
    (bidders-pretargetingConfigs-patch name PretargetingConfig nil))
  ([name PretargetingConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
       :body PretargetingConfig})))

(defn bidders-pretargetingConfigs-removeTargetedApps
  "Removes targeted apps from the pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/removeTargetedApps

pretargetingConfig <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
RemoveTargetedAppsRequest:
{:appIds [string]}"
  [pretargetingConfig RemoveTargetedAppsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+pretargetingConfig}:removeTargetedApps",
     :uri-template-args {:pretargetingConfig pretargetingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body RemoveTargetedAppsRequest}))

(defn bidders-pretargetingConfigs-removeTargetedPublishers
  "Removes targeted publishers from the pretargeting config.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/removeTargetedPublishers

pretargetingConfig <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
RemoveTargetedPublishersRequest:
{:publisherIds [string]}"
  [pretargetingConfig RemoveTargetedPublishersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+pretargetingConfig}:removeTargetedPublishers",
     :uri-template-args {:pretargetingConfig pretargetingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body RemoveTargetedPublishersRequest}))

(defn bidders-pretargetingConfigs-create
  "Creates a pretargeting configuration. A pretargeting configuration's state (PretargetingConfig.state) is active upon creation, and it will start to affect traffic shortly after. A bidder may create a maximum of 10 pretargeting configurations. Attempts to exceed this maximum results in a 400 bad request error.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/create

parent <string> Required. Name of the bidder to create the pretargeting configuration for. Format: bidders/{bidderAccountId}
PretargetingConfig:
{:billingId string,
 :geoTargeting {:includedIds [string], :excludedIds [string]},
 :includedMobileOperatingSystemIds [string],
 :invalidGeoIds [string],
 :verticalTargeting {:includedIds [string], :excludedIds [string]},
 :displayName string,
 :name string,
 :userListTargeting {:includedIds [string], :excludedIds [string]},
 :includedLanguages [string],
 :appTargeting
 {:mobileAppTargeting
  {:targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE],
   :values [string]},
  :mobileAppCategoryTargeting
  {:includedIds [string], :excludedIds [string]}},
 :webTargeting
 {:targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE],
  :values [string]},
 :allowedUserTargetingModes
 [[USER_TARGETING_MODE_UNSPECIFIED
   REMARKETING_ADS
   INTEREST_BASED_TARGETING]],
 :state [STATE_UNSPECIFIED ACTIVE SUSPENDED],
 :maximumQps string,
 :includedUserIdTypes
 [[USER_ID_TYPE_UNSPECIFIED
   HOSTED_MATCH_DATA
   GOOGLE_COOKIE
   DEVICE_ID
   PUBLISHER_PROVIDED_ID]],
 :includedPlatforms
 [[PLATFORM_UNSPECIFIED PERSONAL_COMPUTER PHONE TABLET CONNECTED_TV]],
 :excludedContentLabelIds [string],
 :interstitialTargeting
 [INTERSTITIAL_TARGETING_UNSPECIFIED
  ONLY_INTERSTITIAL_REQUESTS
  ONLY_NON_INTERSTITIAL_REQUESTS],
 :includedEnvironments [[ENVIRONMENT_UNSPECIFIED APP WEB]],
 :includedFormats [[CREATIVE_FORMAT_UNSPECIFIED HTML VAST NATIVE]],
 :minimumViewabilityDecile integer,
 :includedCreativeDimensions [{:width string, :height string}],
 :publisherTargeting
 {:targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE],
  :values [string]}}"
  [parent PretargetingConfig]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+parent}/pretargetingConfigs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body PretargetingConfig}))

(defn bidders-pretargetingConfigs-delete
  "Deletes a pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/delete

name <string> Required. The name of the pretargeting configuration to delete. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn bidders-pretargetingConfigs-suspend
  "Suspends a pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/suspend

name <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
SuspendPretargetingConfigRequest:
object"
  [name SuspendPretargetingConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+name}:suspend",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body SuspendPretargetingConfigRequest}))

(defn bidders-pretargetingConfigs-list
  "Lists all pretargeting configurations for a single bidder.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/list

parent <string> Required. Name of the bidder whose pretargeting configurations will be listed. Format: bidders/{bidderAccountId}

optional:
pageSize <integer> The maximum number of pretargeting configurations to return. If unspecified, at most 10 pretargeting configurations will be returned. The maximum value is 100; values above 100 will be coerced to 100."
  ([parent] (bidders-pretargetingConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+parent}/pretargetingConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn bidders-pretargetingConfigs-removeTargetedSites
  "Removes targeted sites from the pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/removeTargetedSites

pretargetingConfig <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
RemoveTargetedSitesRequest:
{:sites [string]}"
  [pretargetingConfig RemoveTargetedSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+pretargetingConfig}:removeTargetedSites",
     :uri-template-args {:pretargetingConfig pretargetingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body RemoveTargetedSitesRequest}))

(defn bidders-pretargetingConfigs-addTargetedApps
  "Adds targeted apps to the pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/addTargetedApps

pretargetingConfig <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
AddTargetedAppsRequest:
{:appIds [string],
 :targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE]}"
  [pretargetingConfig AddTargetedAppsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+pretargetingConfig}:addTargetedApps",
     :uri-template-args {:pretargetingConfig pretargetingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body AddTargetedAppsRequest}))

(defn bidders-pretargetingConfigs-activate
  "Activates a pretargeting configuration.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/activate

name <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
ActivatePretargetingConfigRequest:
object"
  [name ActivatePretargetingConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+name}:activate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body ActivatePretargetingConfigRequest}))

(defn bidders-pretargetingConfigs-addTargetedPublishers
  "Adds targeted publishers to the pretargeting config.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.pretargetingConfigs/addTargetedPublishers

pretargetingConfig <string> Required. The name of the pretargeting configuration. Format: bidders/{bidderAccountId}/pretargetingConfig/{configId}
AddTargetedPublishersRequest:
{:publisherIds [string],
 :targetingMode [TARGETING_MODE_UNSPECIFIED INCLUSIVE EXCLUSIVE]}"
  [pretargetingConfig AddTargetedPublishersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+pretargetingConfig}:addTargetedPublishers",
     :uri-template-args {:pretargetingConfig pretargetingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body AddTargetedPublishersRequest}))

(defn bidders-publisherConnections-list
  "Lists publisher connections for a given bidder.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.publisherConnections/list

parent <string> Required. Name of the bidder for which publishers have initiated connections. The pattern for this resource is `bidders/{bidder}` where `{bidder}` represents the account ID of the bidder.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested (due to timeout constraint) even if more are available through another call. If unspecified, the server will pick an appropriate default. Acceptable values are 1 to 5000, inclusive.
filter <string> Query string to filter publisher connections. Connections can be filtered by `displayName`, `publisherPlatform`, and `biddingState`. If no filter is specified, all publisher connections will be returned. Example: 'displayName=\"Great Publisher*\" AND publisherPlatform=ADMOB AND biddingState != PENDING' See https://google.aip.dev/160 for more information about filtering syntax.
orderBy <string> Order specification by which results should be sorted. If no sort order is specified, the results will be returned in alphabetic order based on the publisher's publisher code. Results can be sorted by `createTime`. Example: 'createTime DESC'."
  ([parent] (bidders-publisherConnections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+parent}/publisherConnections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn bidders-publisherConnections-get
  "Gets a publisher connection.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.publisherConnections/get

name <string> Required. Name of the publisher whose connection information is to be retrieved. In the pattern `bidders/{bidder}/publisherConnections/{publisher}` where `{bidder}` is the account ID of the bidder, and `{publisher}` is the ads.txt/app-ads.txt publisher ID. See publisherConnection.name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn bidders-publisherConnections-batchApprove
  "Batch approves multiple publisher connections.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.publisherConnections/batchApprove

parent <string> Required. The bidder for whom publisher connections will be approved. Format: `bidders/{bidder}` where `{bidder}` is the account ID of the bidder.
BatchApprovePublisherConnectionsRequest:
{:names [string]}"
  [parent BatchApprovePublisherConnectionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+parent}/publisherConnections:batchApprove",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body BatchApprovePublisherConnectionsRequest}))

(defn bidders-publisherConnections-batchReject
  "Batch rejects multiple publisher connections.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/bidders.publisherConnections/batchReject

parent <string> Required. The bidder for whom publisher connections will be rejected. Format: `bidders/{bidder}` where `{bidder}` is the account ID of the bidder.
BatchRejectPublisherConnectionsRequest:
{:names [string]}"
  [parent BatchRejectPublisherConnectionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+parent}/publisherConnections:batchReject",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body BatchRejectPublisherConnectionsRequest}))

(defn buyers-get
  "Gets a buyer account by its name.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers/get

name <string> Required. Name of the buyer to get. Format: `buyers/{buyerId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn buyers-list
  "Lists all buyer account information the calling buyer user or service account is permissioned to manage.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers/list

optional:
pageSize <integer> The maximum number of buyers to return. If unspecified, at most 100 buyers will be returned. The maximum value is 500; values above 500 will be coerced to 500."
  ([] (buyers-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/buyers",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn buyers-getRemarketingTag
  "This has been sunset as of October 2023, and will return an error response if called. For more information, see the release notes: https://developers.google.com/authorized-buyers/apis/relnotes#real-time-bidding-api Gets remarketing tag for a buyer. A remarketing tag is a piece of JavaScript code that can be placed on a web page. When a user visits a page containing a remarketing tag, Google adds the user to a user list.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers/getRemarketingTag

name <string> Required. To fetch the remarketing tag for an account, the name must follow the pattern `buyers/{accountId}`, where `{accountId}` represents the ID of the buyer that owns the remarketing tag. For a bidder accessing the remarketing tag on behalf of a child seat buyer, `{accountId}` should represent the ID of the child seat buyer. To fetch the remarketing tag for a specific user list, the name must follow the pattern `buyers/{accountId}/userLists/{userListId}`. See UserList.name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+name}:getRemarketingTag",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn buyers-creatives-list
  "Lists creatives as they are at the time of the initial request. This call may take multiple hours to complete. For large, paginated requests, this method returns a snapshot of creatives at the time of request for the first page. `lastStatusUpdate` and `creativeServingDecision` may be outdated for creatives on sequential pages. We recommend [Google Cloud Pub/Sub](//cloud.google.com/pubsub/docs/overview) to view the latest status.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.creatives/list

parent <string> Required. Name of the parent buyer that owns the creatives. The pattern for this resource is either `buyers/{buyerAccountId}` or `bidders/{bidderAccountId}`. For `buyers/{buyerAccountId}`, the `buyerAccountId` can be one of the following: 1. The ID of the buyer that is accessing their own creatives. 2. The ID of the child seat buyer under a bidder account. So for listing creatives pertaining to the child seat buyer (`456`) under bidder account (`123`), you would use the pattern: `buyers/456`. 3. The ID of the bidder itself. So for listing creatives pertaining to bidder (`123`), you would use `buyers/123`. If you want to access all creatives pertaining to both the bidder and all of its child seat accounts, you would use `bidders/{bidderAccountId}`, for example, for all creatives pertaining to bidder (`123`), use `bidders/123`.

optional:
pageSize <integer> Requested page size. The server may return fewer creatives than requested (due to timeout constraint) even if more are available through another call. If unspecified, server will pick an appropriate default. Acceptable values are 1 to 1000, inclusive.
filter <string> Query string to filter creatives. If no filter is specified, all active creatives will be returned. Example: 'accountId=12345 AND (dealsStatus:DISAPPROVED AND disapprovalReason:UNACCEPTABLE_CONTENT) OR declaredAttributes:IS_COOKIE_TARGETED'
view <string> Controls the amount of information included in the response. By default only creativeServingDecision is included. To retrieve the entire creative resource (including the declared fields and the creative content) specify the view as \"FULL\"."
  ([parent] (buyers-creatives-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+parent}/creatives",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn buyers-creatives-get
  "Gets a creative.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.creatives/get

name <string> Required. Name of the creative to retrieve. See creative.name.

optional:
view <string> Controls the amount of information included in the response. By default only creativeServingDecision is included. To retrieve the entire creative resource (including the declared fields and the creative content) specify the view as \"FULL\"."
  ([name] (buyers-creatives-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn buyers-creatives-create
  "Creates a creative.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.creatives/create

parent <string> Required. The name of the parent buyer that the new creative belongs to that must follow the pattern `buyers/{buyerAccountId}`, where `{buyerAccountId}` represents the account ID of the buyer who owns a creative. For a bidder accessing creatives on behalf of a child seat buyer, `{buyerAccountId}` should represent the account ID of the child seat buyer.
Creative:
{:dealIds [string],
 :video
 {:videoUrl string,
  :videoVastXml string,
  :videoMetadata
  {:isValidVast boolean,
   :isVpaid boolean,
   :skipOffset string,
   :duration string,
   :vastVersion
   [VAST_VERSION_UNSPECIFIED
    VAST_VERSION_1_0
    VAST_VERSION_2_0
    VAST_VERSION_3_0
    VAST_VERSION_4_0],
   :mediaFiles
   [{:mimeType
     [VIDEO_MIME_TYPE_UNSPECIFIED
      MIME_VIDEO_XFLV
      MIME_VIDEO_WEBM
      MIME_VIDEO_MP4
      MIME_VIDEO_OGG
      MIME_VIDEO_YT_HOSTED
      MIME_VIDEO_X_MS_WMV
      MIME_VIDEO_3GPP
      MIME_VIDEO_MOV
      MIME_APPLICATION_SWF
      MIME_APPLICATION_SURVEY
      MIME_APPLICATION_JAVASCRIPT
      MIME_APPLICATION_SILVERLIGHT
      MIME_APPLICATION_MPEGURL
      MIME_APPLICATION_MPEGDASH
      MIME_AUDIO_MP4A
      MIME_AUDIO_MP3
      MIME_AUDIO_OGG],
     :bitrate string}]}},
 :creativeServingDecision
 {:detectedProductCategories [integer],
  :detectedAdvertisers
  [{:advertiserId string,
    :advertiserName string,
    :brandId string,
    :brandName string}],
  :chinaPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :networkPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :adTechnologyProviders
  {:detectedProviderIds [string],
   :detectedGvlIds [string],
   :unidentifiedProviderDomains [string]},
  :detectedClickThroughUrls [string],
  :detectedSensitiveCategories [integer],
  :dealsPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :russiaPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :detectedDomains [string],
  :detectedLanguages [string],
  :platformPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :detectedAttributes
  [[ATTRIBUTE_UNSPECIFIED
    IMAGE_RICH_MEDIA
    ADOBE_FLASH_FLV
    IS_TAGGED
    IS_COOKIE_TARGETED
    IS_USER_INTEREST_TARGETED
    EXPANDING_DIRECTION_NONE
    EXPANDING_DIRECTION_UP
    EXPANDING_DIRECTION_DOWN
    EXPANDING_DIRECTION_LEFT
    EXPANDING_DIRECTION_RIGHT
    EXPANDING_DIRECTION_UP_LEFT
    EXPANDING_DIRECTION_UP_RIGHT
    EXPANDING_DIRECTION_DOWN_LEFT
    EXPANDING_DIRECTION_DOWN_RIGHT
    CREATIVE_TYPE_HTML
    CREATIVE_TYPE_VAST_VIDEO
    EXPANDING_DIRECTION_UP_OR_DOWN
    EXPANDING_DIRECTION_LEFT_OR_RIGHT
    EXPANDING_DIRECTION_ANY_DIAGONAL
    EXPANDING_ACTION_ROLLOVER_TO_EXPAND
    INSTREAM_VAST_VIDEO_TYPE_VPAID_FLASH
    RICH_MEDIA_CAPABILITY_TYPE_MRAID
    RICH_MEDIA_CAPABILITY_TYPE_FLASH
    RICH_MEDIA_CAPABILITY_TYPE_HTML5
    SKIPPABLE_INSTREAM_VIDEO
    RICH_MEDIA_CAPABILITY_TYPE_SSL
    RICH_MEDIA_CAPABILITY_TYPE_NON_SSL
    RICH_MEDIA_CAPABILITY_TYPE_INTERSTITIAL
    NON_SKIPPABLE_INSTREAM_VIDEO
    NATIVE_ELIGIBILITY_ELIGIBLE
    NON_VPAID
    NATIVE_ELIGIBILITY_NOT_ELIGIBLE
    ANY_INTERSTITIAL
    NON_INTERSTITIAL
    IN_BANNER_VIDEO
    RENDERING_SIZELESS_ADX
    OMSDK_1_0
    RENDERING_PLAYABLE]],
  :lastStatusUpdate string,
  :detectedVendorIds [integer]},
 :declaredVendorIds [integer],
 :declaredClickThroughUrls [string],
 :advertiserName string,
 :adChoicesDestinationUrl string,
 :name string,
 :impressionTrackingUrls [string],
 :apiUpdateTime string,
 :restrictedCategories [[RESTRICTED_CATEGORY_UNSPECIFIED ALCOHOL]],
 :creativeId string,
 :declaredAttributes
 [[ATTRIBUTE_UNSPECIFIED
   IMAGE_RICH_MEDIA
   ADOBE_FLASH_FLV
   IS_TAGGED
   IS_COOKIE_TARGETED
   IS_USER_INTEREST_TARGETED
   EXPANDING_DIRECTION_NONE
   EXPANDING_DIRECTION_UP
   EXPANDING_DIRECTION_DOWN
   EXPANDING_DIRECTION_LEFT
   EXPANDING_DIRECTION_RIGHT
   EXPANDING_DIRECTION_UP_LEFT
   EXPANDING_DIRECTION_UP_RIGHT
   EXPANDING_DIRECTION_DOWN_LEFT
   EXPANDING_DIRECTION_DOWN_RIGHT
   CREATIVE_TYPE_HTML
   CREATIVE_TYPE_VAST_VIDEO
   EXPANDING_DIRECTION_UP_OR_DOWN
   EXPANDING_DIRECTION_LEFT_OR_RIGHT
   EXPANDING_DIRECTION_ANY_DIAGONAL
   EXPANDING_ACTION_ROLLOVER_TO_EXPAND
   INSTREAM_VAST_VIDEO_TYPE_VPAID_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_MRAID
   RICH_MEDIA_CAPABILITY_TYPE_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_HTML5
   SKIPPABLE_INSTREAM_VIDEO
   RICH_MEDIA_CAPABILITY_TYPE_SSL
   RICH_MEDIA_CAPABILITY_TYPE_NON_SSL
   RICH_MEDIA_CAPABILITY_TYPE_INTERSTITIAL
   NON_SKIPPABLE_INSTREAM_VIDEO
   NATIVE_ELIGIBILITY_ELIGIBLE
   NON_VPAID
   NATIVE_ELIGIBILITY_NOT_ELIGIBLE
   ANY_INTERSTITIAL
   NON_INTERSTITIAL
   IN_BANNER_VIDEO
   RENDERING_SIZELESS_ADX
   OMSDK_1_0
   RENDERING_PLAYABLE]],
 :native
 {:clickLinkUrl string,
  :headline string,
  :starRating number,
  :logo {:url string, :width integer, :height integer},
  :advertiserName string,
  :appIcon {:url string, :width integer, :height integer},
  :priceDisplayText string,
  :callToAction string,
  :clickTrackingUrl string,
  :videoUrl string,
  :videoVastXml string,
  :image {:url string, :width integer, :height integer},
  :body string},
 :renderUrl string,
 :creativeFormat [CREATIVE_FORMAT_UNSPECIFIED HTML VIDEO NATIVE],
 :agencyId string,
 :declaredRestrictedCategories
 [[RESTRICTED_CATEGORY_UNSPECIFIED ALCOHOL]],
 :version integer,
 :accountId string,
 :html {:snippet string, :width integer, :height integer}}"
  [parent Creative]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+parent}/creatives",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body Creative}))

(defn buyers-creatives-patch
  "Updates a creative.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.creatives/patch

name <string> Output only. Name of the creative. Follows the pattern `buyers/{buyer}/creatives/{creative}`, where `{buyer}` represents the account ID of the buyer who owns the creative, and `{creative}` is the buyer-specific creative ID that references this creative in the bid response.
Creative:
{:dealIds [string],
 :video
 {:videoUrl string,
  :videoVastXml string,
  :videoMetadata
  {:isValidVast boolean,
   :isVpaid boolean,
   :skipOffset string,
   :duration string,
   :vastVersion
   [VAST_VERSION_UNSPECIFIED
    VAST_VERSION_1_0
    VAST_VERSION_2_0
    VAST_VERSION_3_0
    VAST_VERSION_4_0],
   :mediaFiles
   [{:mimeType
     [VIDEO_MIME_TYPE_UNSPECIFIED
      MIME_VIDEO_XFLV
      MIME_VIDEO_WEBM
      MIME_VIDEO_MP4
      MIME_VIDEO_OGG
      MIME_VIDEO_YT_HOSTED
      MIME_VIDEO_X_MS_WMV
      MIME_VIDEO_3GPP
      MIME_VIDEO_MOV
      MIME_APPLICATION_SWF
      MIME_APPLICATION_SURVEY
      MIME_APPLICATION_JAVASCRIPT
      MIME_APPLICATION_SILVERLIGHT
      MIME_APPLICATION_MPEGURL
      MIME_APPLICATION_MPEGDASH
      MIME_AUDIO_MP4A
      MIME_AUDIO_MP3
      MIME_AUDIO_OGG],
     :bitrate string}]}},
 :creativeServingDecision
 {:detectedProductCategories [integer],
  :detectedAdvertisers
  [{:advertiserId string,
    :advertiserName string,
    :brandId string,
    :brandName string}],
  :chinaPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :networkPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :adTechnologyProviders
  {:detectedProviderIds [string],
   :detectedGvlIds [string],
   :unidentifiedProviderDomains [string]},
  :detectedClickThroughUrls [string],
  :detectedSensitiveCategories [integer],
  :dealsPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :russiaPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :detectedDomains [string],
  :detectedLanguages [string],
  :platformPolicyCompliance
  {:status
   [STATUS_UNSPECIFIED
    PENDING_REVIEW
    DISAPPROVED
    APPROVED
    CERTIFICATE_REQUIRED],
   :topics
   [{:policyTopic string,
     :helpCenterUrl string,
     :evidences
     [{:destinationNotWorking DestinationNotWorkingEvidence,
       :destinationNotCrawlable DestinationNotCrawlableEvidence,
       :httpCall HttpCallEvidence,
       :domainCall DomainCallEvidence,
       :httpCookie HttpCookieEvidence,
       :destinationUrl DestinationUrlEvidence,
       :downloadSize DownloadSizeEvidence}],
     :missingCertificate boolean}]},
  :detectedAttributes
  [[ATTRIBUTE_UNSPECIFIED
    IMAGE_RICH_MEDIA
    ADOBE_FLASH_FLV
    IS_TAGGED
    IS_COOKIE_TARGETED
    IS_USER_INTEREST_TARGETED
    EXPANDING_DIRECTION_NONE
    EXPANDING_DIRECTION_UP
    EXPANDING_DIRECTION_DOWN
    EXPANDING_DIRECTION_LEFT
    EXPANDING_DIRECTION_RIGHT
    EXPANDING_DIRECTION_UP_LEFT
    EXPANDING_DIRECTION_UP_RIGHT
    EXPANDING_DIRECTION_DOWN_LEFT
    EXPANDING_DIRECTION_DOWN_RIGHT
    CREATIVE_TYPE_HTML
    CREATIVE_TYPE_VAST_VIDEO
    EXPANDING_DIRECTION_UP_OR_DOWN
    EXPANDING_DIRECTION_LEFT_OR_RIGHT
    EXPANDING_DIRECTION_ANY_DIAGONAL
    EXPANDING_ACTION_ROLLOVER_TO_EXPAND
    INSTREAM_VAST_VIDEO_TYPE_VPAID_FLASH
    RICH_MEDIA_CAPABILITY_TYPE_MRAID
    RICH_MEDIA_CAPABILITY_TYPE_FLASH
    RICH_MEDIA_CAPABILITY_TYPE_HTML5
    SKIPPABLE_INSTREAM_VIDEO
    RICH_MEDIA_CAPABILITY_TYPE_SSL
    RICH_MEDIA_CAPABILITY_TYPE_NON_SSL
    RICH_MEDIA_CAPABILITY_TYPE_INTERSTITIAL
    NON_SKIPPABLE_INSTREAM_VIDEO
    NATIVE_ELIGIBILITY_ELIGIBLE
    NON_VPAID
    NATIVE_ELIGIBILITY_NOT_ELIGIBLE
    ANY_INTERSTITIAL
    NON_INTERSTITIAL
    IN_BANNER_VIDEO
    RENDERING_SIZELESS_ADX
    OMSDK_1_0
    RENDERING_PLAYABLE]],
  :lastStatusUpdate string,
  :detectedVendorIds [integer]},
 :declaredVendorIds [integer],
 :declaredClickThroughUrls [string],
 :advertiserName string,
 :adChoicesDestinationUrl string,
 :name string,
 :impressionTrackingUrls [string],
 :apiUpdateTime string,
 :restrictedCategories [[RESTRICTED_CATEGORY_UNSPECIFIED ALCOHOL]],
 :creativeId string,
 :declaredAttributes
 [[ATTRIBUTE_UNSPECIFIED
   IMAGE_RICH_MEDIA
   ADOBE_FLASH_FLV
   IS_TAGGED
   IS_COOKIE_TARGETED
   IS_USER_INTEREST_TARGETED
   EXPANDING_DIRECTION_NONE
   EXPANDING_DIRECTION_UP
   EXPANDING_DIRECTION_DOWN
   EXPANDING_DIRECTION_LEFT
   EXPANDING_DIRECTION_RIGHT
   EXPANDING_DIRECTION_UP_LEFT
   EXPANDING_DIRECTION_UP_RIGHT
   EXPANDING_DIRECTION_DOWN_LEFT
   EXPANDING_DIRECTION_DOWN_RIGHT
   CREATIVE_TYPE_HTML
   CREATIVE_TYPE_VAST_VIDEO
   EXPANDING_DIRECTION_UP_OR_DOWN
   EXPANDING_DIRECTION_LEFT_OR_RIGHT
   EXPANDING_DIRECTION_ANY_DIAGONAL
   EXPANDING_ACTION_ROLLOVER_TO_EXPAND
   INSTREAM_VAST_VIDEO_TYPE_VPAID_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_MRAID
   RICH_MEDIA_CAPABILITY_TYPE_FLASH
   RICH_MEDIA_CAPABILITY_TYPE_HTML5
   SKIPPABLE_INSTREAM_VIDEO
   RICH_MEDIA_CAPABILITY_TYPE_SSL
   RICH_MEDIA_CAPABILITY_TYPE_NON_SSL
   RICH_MEDIA_CAPABILITY_TYPE_INTERSTITIAL
   NON_SKIPPABLE_INSTREAM_VIDEO
   NATIVE_ELIGIBILITY_ELIGIBLE
   NON_VPAID
   NATIVE_ELIGIBILITY_NOT_ELIGIBLE
   ANY_INTERSTITIAL
   NON_INTERSTITIAL
   IN_BANNER_VIDEO
   RENDERING_SIZELESS_ADX
   OMSDK_1_0
   RENDERING_PLAYABLE]],
 :native
 {:clickLinkUrl string,
  :headline string,
  :starRating number,
  :logo {:url string, :width integer, :height integer},
  :advertiserName string,
  :appIcon {:url string, :width integer, :height integer},
  :priceDisplayText string,
  :callToAction string,
  :clickTrackingUrl string,
  :videoUrl string,
  :videoVastXml string,
  :image {:url string, :width integer, :height integer},
  :body string},
 :renderUrl string,
 :creativeFormat [CREATIVE_FORMAT_UNSPECIFIED HTML VIDEO NATIVE],
 :agencyId string,
 :declaredRestrictedCategories
 [[RESTRICTED_CATEGORY_UNSPECIFIED ALCOHOL]],
 :version integer,
 :accountId string,
 :html {:snippet string, :width integer, :height integer}}

optional:
updateMask <string> Field mask to use for partial in-place updates."
  ([name Creative] (buyers-creatives-patch name Creative nil))
  ([name Creative optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
       :body Creative})))

(defn buyers-userLists-get
  "Gets a user list by its name.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.userLists/get

name <string> Required. The name of the user list to be retrieved. See UserList.name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(defn buyers-userLists-list
  "Lists the user lists visible to the current user.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.userLists/list

parent <string> Required. The name of the parent buyer for the user lists to be returned that must follow the pattern `buyers/{buyerAccountId}`, where `{buyerAccountId}` represents the account ID of the buyer who owns user lists. For a bidder accessing user lists on behalf of a child seat buyer , `{buyerAccountId}` should represent the account ID of the child seat buyer.

optional:
pageSize <integer> The number of results to return per page."
  ([parent] (buyers-userLists-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://realtimebidding.googleapis.com/v1/{+parent}/userLists",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/realtime-bidding"]})))

(defn buyers-userLists-create
  "Creates a new user list.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.userLists/create

parent <string> Required. The name of the parent buyer of the user list to be retrieved, which must follow the pattern `buyers/{buyerAccountId}`, where `{buyerAccountId}` represents the account ID of the buyer who owns the user list. For a bidder accessing user lists on behalf of a child seat buyer, `{buyerAccountId}` should represent the account ID of the child seat buyer.
UserList:
{:name string,
 :displayName string,
 :description string,
 :status [STATUS_UNSPECIFIED OPEN CLOSED],
 :urlRestriction
 {:url string,
  :restrictionType
  [RESTRICTION_TYPE_UNSPECIFIED
   CONTAINS
   EQUALS
   STARTS_WITH
   ENDS_WITH
   DOES_NOT_EQUAL
   DOES_NOT_CONTAIN
   DOES_NOT_START_WITH
   DOES_NOT_END_WITH],
  :startDate {:year integer, :month integer, :day integer},
  :endDate {:year integer, :month integer, :day integer}},
 :membershipDurationDays string}"
  [parent UserList]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+parent}/userLists",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body UserList}))

(defn buyers-userLists-update
  "Updates the given user list. Only user lists with URLRestrictions can be updated.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.userLists/update

name <string> Output only. Name of the user list that must follow the pattern `buyers/{buyer}/userLists/{user_list}`, where `{buyer}` represents the account ID of the buyer who owns the user list. For a bidder accessing user lists on behalf of a child seat buyer, `{buyer}` represents the account ID of the child seat buyer. `{user_list}` is an int64 identifier assigned by Google to uniquely identify a user list.
UserList:
{:name string,
 :displayName string,
 :description string,
 :status [STATUS_UNSPECIFIED OPEN CLOSED],
 :urlRestriction
 {:url string,
  :restrictionType
  [RESTRICTION_TYPE_UNSPECIFIED
   CONTAINS
   EQUALS
   STARTS_WITH
   ENDS_WITH
   DOES_NOT_EQUAL
   DOES_NOT_CONTAIN
   DOES_NOT_START_WITH
   DOES_NOT_END_WITH],
  :startDate {:year integer, :month integer, :day integer},
  :endDate {:year integer, :month integer, :day integer}},
 :membershipDurationDays string}"
  [name UserList]
  (client/api-request
    {:method "PUT",
     :uri-template "https://realtimebidding.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body UserList}))

(defn buyers-userLists-open
  "Changes the status of a user list to OPEN. This allows new users to be added to the user list.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.userLists/open

name <string> Required. The name of the user list to open. See UserList.name
OpenUserListRequest:
object"
  [name OpenUserListRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+name}:open",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body OpenUserListRequest}))

(defn buyers-userLists-close
  "Changes the status of a user list to CLOSED. This prevents new users from being added to the user list.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.userLists/close

name <string> Required. The name of the user list to close. See UserList.name
CloseUserListRequest:
object"
  [name CloseUserListRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+name}:close",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"],
     :body CloseUserListRequest}))

(defn buyers-userLists-getRemarketingTag
  "This has been sunset as of October 2023, and will return an error response if called. For more information, see the release notes: https://developers.google.com/authorized-buyers/apis/relnotes#real-time-bidding-api Gets remarketing tag for a buyer. A remarketing tag is a piece of JavaScript code that can be placed on a web page. When a user visits a page containing a remarketing tag, Google adds the user to a user list.
https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/v1/buyers.userLists/getRemarketingTag

name <string> Required. To fetch the remarketing tag for an account, the name must follow the pattern `buyers/{accountId}`, where `{accountId}` represents the ID of the buyer that owns the remarketing tag. For a bidder accessing the remarketing tag on behalf of a child seat buyer, `{accountId}` should represent the ID of the child seat buyer. To fetch the remarketing tag for a specific user list, the name must follow the pattern `buyers/{accountId}/userLists/{userListId}`. See UserList.name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://realtimebidding.googleapis.com/v1/{+name}:getRemarketingTag",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/realtime-bidding"]}))

(ns happygapi2.admob
  "AdMob API
The AdMob API allows publishers to programmatically get information about their AdMob account. 
See: https://developers.google.com/admob/api/"
  (:require [happy.oauth2.client :as client]))

(defn accounts-get
  "Gets information about the specified AdMob publisher account.
https://developers.google.com/admob/api/v1/reference/rest/v1/accounts/get

name <string> Resource name of the publisher account to retrieve. Example: accounts/pub-9876543210987654"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://admob.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/admob.readonly"
      "https://www.googleapis.com/auth/admob.report"]}))

(defn accounts-list
  "Lists the AdMob publisher account that was most recently signed in to from the AdMob UI. For more information, see https://support.google.com/admob/answer/10243672.
https://developers.google.com/admob/api/v1/reference/rest/v1/accounts/list

optional:
pageSize <integer> Maximum number of accounts to return."
  ([] (accounts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://admob.googleapis.com/v1/accounts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/admob.readonly"
        "https://www.googleapis.com/auth/admob.report"]})))

(defn accounts-networkReport-generate
  "Generates an AdMob Network report based on the provided report specification. Returns result of a server-side streaming RPC. The result is returned in a sequence of responses.
https://developers.google.com/admob/api/v1/reference/rest/v1/accounts/networkReport/generate

parent <string> Resource name of the account to generate the report for. Example: accounts/pub-9876543210987654
GenerateNetworkReportRequest:
{:reportSpec
 {:dateRange
  {:startDate {:year integer, :month integer, :day integer},
   :endDate {:year integer, :month integer, :day integer}},
  :dimensions
  [[DIMENSION_UNSPECIFIED
    DATE
    MONTH
    WEEK
    AD_UNIT
    APP
    AD_TYPE
    COUNTRY
    FORMAT
    PLATFORM
    MOBILE_OS_VERSION
    GMA_SDK_VERSION
    APP_VERSION_NAME
    SERVING_RESTRICTION]],
  :metrics
  [[METRIC_UNSPECIFIED
    AD_REQUESTS
    CLICKS
    ESTIMATED_EARNINGS
    IMPRESSIONS
    IMPRESSION_CTR
    IMPRESSION_RPM
    MATCHED_REQUESTS
    MATCH_RATE
    SHOW_RATE]],
  :dimensionFilters
  [{:matchesAny {:values [string]},
    :dimension
    [DIMENSION_UNSPECIFIED
     DATE
     MONTH
     WEEK
     AD_UNIT
     APP
     AD_TYPE
     COUNTRY
     FORMAT
     PLATFORM
     MOBILE_OS_VERSION
     GMA_SDK_VERSION
     APP_VERSION_NAME
     SERVING_RESTRICTION]}],
  :sortConditions
  [{:dimension
    [DIMENSION_UNSPECIFIED
     DATE
     MONTH
     WEEK
     AD_UNIT
     APP
     AD_TYPE
     COUNTRY
     FORMAT
     PLATFORM
     MOBILE_OS_VERSION
     GMA_SDK_VERSION
     APP_VERSION_NAME
     SERVING_RESTRICTION],
    :metric
    [METRIC_UNSPECIFIED
     AD_REQUESTS
     CLICKS
     ESTIMATED_EARNINGS
     IMPRESSIONS
     IMPRESSION_CTR
     IMPRESSION_RPM
     MATCHED_REQUESTS
     MATCH_RATE
     SHOW_RATE],
    :order [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING]}],
  :localizationSettings {:currencyCode string, :languageCode string},
  :maxReportRows integer,
  :timeZone string}}"
  [parent GenerateNetworkReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://admob.googleapis.com/v1/{+parent}/networkReport:generate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/admob.readonly"
      "https://www.googleapis.com/auth/admob.report"],
     :body GenerateNetworkReportRequest}))

(defn accounts-mediationReport-generate
  "Generates an AdMob Mediation report based on the provided report specification. Returns result of a server-side streaming RPC. The result is returned in a sequence of responses.
https://developers.google.com/admob/api/v1/reference/rest/v1/accounts/mediationReport/generate

parent <string> Resource name of the account to generate the report for. Example: accounts/pub-9876543210987654
GenerateMediationReportRequest:
{:reportSpec
 {:dateRange
  {:startDate {:year integer, :month integer, :day integer},
   :endDate {:year integer, :month integer, :day integer}},
  :dimensions
  [[DIMENSION_UNSPECIFIED
    DATE
    MONTH
    WEEK
    AD_SOURCE
    AD_SOURCE_INSTANCE
    AD_UNIT
    APP
    MEDIATION_GROUP
    COUNTRY
    FORMAT
    PLATFORM
    MOBILE_OS_VERSION
    GMA_SDK_VERSION
    APP_VERSION_NAME
    SERVING_RESTRICTION]],
  :metrics
  [[METRIC_UNSPECIFIED
    AD_REQUESTS
    CLICKS
    ESTIMATED_EARNINGS
    IMPRESSIONS
    IMPRESSION_CTR
    MATCHED_REQUESTS
    MATCH_RATE
    OBSERVED_ECPM]],
  :dimensionFilters
  [{:matchesAny {:values [string]},
    :dimension
    [DIMENSION_UNSPECIFIED
     DATE
     MONTH
     WEEK
     AD_SOURCE
     AD_SOURCE_INSTANCE
     AD_UNIT
     APP
     MEDIATION_GROUP
     COUNTRY
     FORMAT
     PLATFORM
     MOBILE_OS_VERSION
     GMA_SDK_VERSION
     APP_VERSION_NAME
     SERVING_RESTRICTION]}],
  :sortConditions
  [{:dimension
    [DIMENSION_UNSPECIFIED
     DATE
     MONTH
     WEEK
     AD_SOURCE
     AD_SOURCE_INSTANCE
     AD_UNIT
     APP
     MEDIATION_GROUP
     COUNTRY
     FORMAT
     PLATFORM
     MOBILE_OS_VERSION
     GMA_SDK_VERSION
     APP_VERSION_NAME
     SERVING_RESTRICTION],
    :metric
    [METRIC_UNSPECIFIED
     AD_REQUESTS
     CLICKS
     ESTIMATED_EARNINGS
     IMPRESSIONS
     IMPRESSION_CTR
     MATCHED_REQUESTS
     MATCH_RATE
     OBSERVED_ECPM],
    :order [SORT_ORDER_UNSPECIFIED ASCENDING DESCENDING]}],
  :localizationSettings {:currencyCode string, :languageCode string},
  :maxReportRows integer,
  :timeZone string}}"
  [parent GenerateMediationReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://admob.googleapis.com/v1/{+parent}/mediationReport:generate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/admob.readonly"
      "https://www.googleapis.com/auth/admob.report"],
     :body GenerateMediationReportRequest}))

(defn accounts-apps-list
  "List the apps under the specified AdMob account.
https://developers.google.com/admob/api/v1/reference/rest/v1/accounts/apps/list

parent <string> Required. Resource name of the account to list apps for. Example: accounts/pub-9876543210987654

optional:
pageSize <integer> The maximum number of apps to return. If unspecified or 0, at most 10,000 apps will be returned. The maximum value is 20,000; values above 20,000 will be coerced to 20,000."
  ([parent] (accounts-apps-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://admob.googleapis.com/v1/{+parent}/apps",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/admob.readonly"]})))

(defn accounts-adUnits-list
  "List the ad units under the specified AdMob account.
https://developers.google.com/admob/api/v1/reference/rest/v1/accounts/adUnits/list

parent <string> Required. Resource name of the account to list ad units for. Example: accounts/pub-9876543210987654

optional:
pageSize <integer> The maximum number of ad units to return. If unspecified or 0, at most 10,000 ad units will be returned. The maximum value is 20,000; values above 20,000 will be coerced to 20,000."
  ([parent] (accounts-adUnits-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://admob.googleapis.com/v1/{+parent}/adUnits",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/admob.readonly"]})))

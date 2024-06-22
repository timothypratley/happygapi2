(ns happygapi2.doubleclicksearch
  "Search Ads 360 API
The Search Ads 360 API allows developers to automate uploading conversions and downloading reports from Search Ads 360.
See: https://developers.google.com/search-ads"
  (:require [happy.oauth2.client :as client]))

(defn conversion-get
  "Retrieves a list of conversions from a DoubleClick Search engine account.
https://developers.google.com/search-ads

agencyId <string> Numeric ID of the agency.
advertiserId <string> Numeric ID of the advertiser.
engineAccountId <string> Numeric ID of the engine account.
endDate <integer> Last date (inclusive) on which to retrieve conversions. Format is yyyymmdd.
rowCount <integer> The number of conversions to return per call.
startDate <integer> First date (inclusive) on which to retrieve conversions. Format is yyyymmdd.
startRow <integer> The 0-based starting index for retrieving conversions results.

optional:
adId <string> Numeric ID of the ad.
adGroupId <string> Numeric ID of the ad group.
campaignId <string> Numeric ID of the campaign.
criterionId <string> Numeric ID of the criterion.
customerId <string> Customer ID of a client account in the new Search Ads 360 experience."
  ([agencyId
    advertiserId
    engineAccountId
    endDate
    rowCount
    startDate
    startRow]
    (conversion-get
      agencyId
      advertiserId
      engineAccountId
      endDate
      rowCount
      startDate
      startRow
      nil))
  ([agencyId
    advertiserId
    engineAccountId
    endDate
    rowCount
    startDate
    startRow
    optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/agency/{agencyId}/advertiser/{advertiserId}/engine/{engineAccountId}/conversion",
       :uri-template-args
       {:engineAccountId engineAccountId,
        :advertiserId advertiserId,
        :agencyId agencyId},
       :query-params
       (merge
         {:startDate startDate,
          :endDate endDate,
          :startRow startRow,
          :rowCount rowCount}
         optional),
       :scopes ["https://www.googleapis.com/auth/doubleclicksearch"]})))

(defn conversion-getByCustomerId
  "Retrieves a list of conversions from a DoubleClick Search engine account.
https://developers.google.com/search-ads

customerId <string> Customer ID of a client account in the new Search Ads 360 experience.
endDate <integer> Last date (inclusive) on which to retrieve conversions. Format is yyyymmdd.
rowCount <integer> The number of conversions to return per call.
startDate <integer> First date (inclusive) on which to retrieve conversions. Format is yyyymmdd.
startRow <integer> The 0-based starting index for retrieving conversions results.

optional:
adId <string> Numeric ID of the ad.
adGroupId <string> Numeric ID of the ad group.
campaignId <string> Numeric ID of the campaign.
criterionId <string> Numeric ID of the criterion.
engineAccountId <string> Numeric ID of the engine account.
advertiserId <string> Numeric ID of the advertiser.
agencyId <string> Numeric ID of the agency."
  ([customerId endDate rowCount startDate startRow]
    (conversion-getByCustomerId
      customerId
      endDate
      rowCount
      startDate
      startRow
      nil))
  ([customerId endDate rowCount startDate startRow optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/customer/{customerId}/conversion",
       :uri-template-args {:customerId customerId},
       :query-params
       (merge
         {:startDate startDate,
          :endDate endDate,
          :startRow startRow,
          :rowCount rowCount}
         optional),
       :scopes ["https://www.googleapis.com/auth/doubleclicksearch"]})))

(defn conversion-insert
  "Inserts a batch of new conversions into DoubleClick Search.
https://developers.google.com/search-ads

ConversionList:
{:conversion
 [{:productLanguage string,
   :countMillis string,
   :segmentationName string,
   :customDimension [{:name string, :value string}],
   :conversionTimestamp string,
   :customMetric [{:name string, :value number}],
   :adId string,
   :adUserDataConsent [UNKNOWN GRANTED DENIED],
   :dsConversionId string,
   :attributionModel string,
   :adGroupId string,
   :campaignId string,
   :conversionModifiedTimestamp string,
   :channel string,
   :type string,
   :segmentationType string,
   :state string,
   :productId string,
   :criterionId string,
   :customerId string,
   :engineAccountId string,
   :advertiserId string,
   :storeId string,
   :revenueMicros string,
   :segmentationId string,
   :deviceType string,
   :conversionId string,
   :productCountry string,
   :agencyId string,
   :productGroupId string,
   :currencyCode string,
   :inventoryAccountId string,
   :quantityMillis string,
   :clickId string,
   :floodlightOrderId string}],
 :kind string}"
  [ConversionList]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/conversion",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"],
     :body ConversionList}))

(defn conversion-update
  "Updates a batch of conversions in DoubleClick Search.
https://developers.google.com/search-ads

ConversionList:
{:conversion
 [{:productLanguage string,
   :countMillis string,
   :segmentationName string,
   :customDimension [{:name string, :value string}],
   :conversionTimestamp string,
   :customMetric [{:name string, :value number}],
   :adId string,
   :adUserDataConsent [UNKNOWN GRANTED DENIED],
   :dsConversionId string,
   :attributionModel string,
   :adGroupId string,
   :campaignId string,
   :conversionModifiedTimestamp string,
   :channel string,
   :type string,
   :segmentationType string,
   :state string,
   :productId string,
   :criterionId string,
   :customerId string,
   :engineAccountId string,
   :advertiserId string,
   :storeId string,
   :revenueMicros string,
   :segmentationId string,
   :deviceType string,
   :conversionId string,
   :productCountry string,
   :agencyId string,
   :productGroupId string,
   :currencyCode string,
   :inventoryAccountId string,
   :quantityMillis string,
   :clickId string,
   :floodlightOrderId string}],
 :kind string}"
  [ConversionList]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/conversion",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"],
     :body ConversionList}))

(defn conversion-updateAvailability
  "Updates the availabilities of a batch of floodlight activities in DoubleClick Search.
https://developers.google.com/search-ads

UpdateAvailabilityRequest:
{:availabilities
 [{:agencyId string,
   :advertiserId string,
   :segmentationType string,
   :segmentationId string,
   :segmentationName string,
   :availabilityTimestamp string,
   :customerId string}]}"
  [UpdateAvailabilityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/conversion/updateAvailability",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"],
     :body UpdateAvailabilityRequest}))

(defn reports-generate
  "Generates and returns a report immediately.
https://developers.google.com/search-ads

ReportRequest:
{:timeRange
 {:changedMetricsSinceTimestamp string,
  :changedAttributesSinceTimestamp string,
  :startDate string,
  :endDate string},
 :filters
 [{:column
   {:productReportPerspective string,
    :customMetricName string,
    :startDate string,
    :headerText string,
    :endDate string,
    :groupByColumn boolean,
    :platformSource string,
    :customDimensionName string,
    :savedColumnName string,
    :columnName string},
   :operator string,
   :values [any]}],
 :columns
 [{:productReportPerspective string,
   :customMetricName string,
   :startDate string,
   :headerText string,
   :endDate string,
   :groupByColumn boolean,
   :platformSource string,
   :customDimensionName string,
   :savedColumnName string,
   :columnName string}],
 :includeRemovedEntities boolean,
 :verifySingleTimeZone boolean,
 :includeDeletedEntities boolean,
 :statisticsCurrency string,
 :reportScope
 {:agencyId string,
  :advertiserId string,
  :engineAccountId string,
  :campaignId string,
  :adGroupId string,
  :keywordId string,
  :adId string},
 :reportType string,
 :startRow integer,
 :maxRowsPerFile integer,
 :rowCount integer,
 :downloadFormat string,
 :orderBy
 [{:column
   {:productReportPerspective string,
    :customMetricName string,
    :startDate string,
    :headerText string,
    :endDate string,
    :groupByColumn boolean,
    :platformSource string,
    :customDimensionName string,
    :savedColumnName string,
    :columnName string},
   :sortOrder string}]}"
  [ReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/reports/generate",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"],
     :body ReportRequest}))

(defn reports-get
  "Polls for the status of a report request.
https://developers.google.com/search-ads

reportId <string> ID of the report request being polled."
  [reportId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/reports/{reportId}",
     :uri-template-args {:reportId reportId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}))

(defn reports-getFile
  "Downloads a report file encoded in UTF-8.
https://developers.google.com/search-ads

reportId <string> ID of the report.
reportFragment <integer> The index of the report fragment to download."
  [reportId reportFragment]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/reports/{reportId}/files/{reportFragment}",
     :uri-template-args
     {:reportId reportId, :reportFragment reportFragment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}))

(defn reports-getIdMappingFile
  "Downloads a csv file(encoded in UTF-8) that contains ID mappings between legacy SA360 and new SA360. The file includes all children entities of the given advertiser(e.g. engine accounts, campaigns, ad groups, etc.) that exist in both legacy SA360 and new SA360.
https://developers.google.com/search-ads

agencyId <string> Legacy SA360 agency ID.
advertiserId <string> Legacy SA360 advertiser ID."
  [agencyId advertiserId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/agency/{agencyId}/advertiser/{advertiserId}/idmapping",
     :uri-template-args
     {:agencyId agencyId, :advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}))

(defn reports-request
  "Inserts a report request into the reporting system.
https://developers.google.com/search-ads

ReportRequest:
{:timeRange
 {:changedMetricsSinceTimestamp string,
  :changedAttributesSinceTimestamp string,
  :startDate string,
  :endDate string},
 :filters
 [{:column
   {:productReportPerspective string,
    :customMetricName string,
    :startDate string,
    :headerText string,
    :endDate string,
    :groupByColumn boolean,
    :platformSource string,
    :customDimensionName string,
    :savedColumnName string,
    :columnName string},
   :operator string,
   :values [any]}],
 :columns
 [{:productReportPerspective string,
   :customMetricName string,
   :startDate string,
   :headerText string,
   :endDate string,
   :groupByColumn boolean,
   :platformSource string,
   :customDimensionName string,
   :savedColumnName string,
   :columnName string}],
 :includeRemovedEntities boolean,
 :verifySingleTimeZone boolean,
 :includeDeletedEntities boolean,
 :statisticsCurrency string,
 :reportScope
 {:agencyId string,
  :advertiserId string,
  :engineAccountId string,
  :campaignId string,
  :adGroupId string,
  :keywordId string,
  :adId string},
 :reportType string,
 :startRow integer,
 :maxRowsPerFile integer,
 :rowCount integer,
 :downloadFormat string,
 :orderBy
 [{:column
   {:productReportPerspective string,
    :customMetricName string,
    :startDate string,
    :headerText string,
    :endDate string,
    :groupByColumn boolean,
    :platformSource string,
    :customDimensionName string,
    :savedColumnName string,
    :columnName string},
   :sortOrder string}]}"
  [ReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/reports",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"],
     :body ReportRequest}))

(defn savedColumns-list
  "Retrieve the list of saved columns for a specified advertiser.
https://developers.google.com/search-ads

agencyId <string> DS ID of the agency.
advertiserId <string> DS ID of the advertiser."
  [agencyId advertiserId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://doubleclicksearch.googleapis.com/doubleclicksearch/v2/agency/{agencyId}/advertiser/{advertiserId}/savedcolumns",
     :uri-template-args
     {:agencyId agencyId, :advertiserId advertiserId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}))

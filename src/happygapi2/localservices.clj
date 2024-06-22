(ns happygapi2.localservices
  "Local Services API

See: https://ads.google.com/intl/en_us/home/local-services-ads/"
  (:require [happy.oauth2.client :as client]))

(defn detailedLeadReports-search
  "Get detailed lead reports containing leads that have been received by all linked GLS accounts. Caller needs to provide their manager customer id and the associated auth credential that allows them read permissions on their linked accounts.
https://ads.google.com/intl/en_us/home/local-services-ads

optional:
startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
pageSize <integer> The maximum number of accounts to return. If the page size is unset, page size will default to 1000. Maximum page_size is 10000. Optional.
query <string> A query string for searching for account reports. Caller must provide a customer id of their MCC account with an associated Gaia Mint that allows read permission on their linked accounts. Search expressions are case insensitive. Example query: | Query | Description | |-------------------------|-----------------------------------------------| | manager_customer_id:123 | Get Detailed Lead Report for Manager with id | | | 123. | Required.
startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year."
  ([] (detailedLeadReports-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://localservices.googleapis.com/v1/detailedLeadReports:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adwords"]})))

(defn accountReports-search
  "Get account reports containing aggregate account data of all linked GLS accounts. Caller needs to provide their manager customer id and the associated auth credential that allows them read permissions on their linked accounts.
https://ads.google.com/intl/en_us/home/local-services-ads

optional:
startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
pageSize <integer> The maximum number of accounts to return. If the page size is unset, page size will default to 1000. Maximum page_size is 10000. Optional.
query <string> A query string for searching for account reports. Caller must provide a customer id of their MCC account with an associated Gaia Mint that allows read permission on their linked accounts. Search expressions are case insensitive. Example query: | Query | Description | |-------------------------|-----------------------------------------------| | manager_customer_id:123 | Get Account Report for Manager with id 123. | Required.
startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year."
  ([] (accountReports-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://localservices.googleapis.com/v1/accountReports:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adwords"]})))

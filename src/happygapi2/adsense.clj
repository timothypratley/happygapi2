(ns happygapi2.adsense
  "AdSense Management API
The AdSense Management API allows publishers to access their inventory and run earnings and performance reports.
See: https://developers.google.com/adsense/management/"
  (:require [happy.oauth2.client :as client]))

(defn accounts-get
  "Gets information about the selected AdSense account.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/get

name <string> Required. Account to get information about. Format: accounts/{account}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-list
  "Lists all accounts available to this user.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/list

optional:
pageSize <integer> The maximum number of accounts to include in the response, used for paging. If unspecified, at most 10000 accounts will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([] (accounts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://adsense.googleapis.com/v2/accounts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-listChildAccounts
  "Lists all accounts directly managed by the given AdSense account.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/listChildAccounts

parent <string> Required. The parent account, which owns the child accounts. Format: accounts/{account}

optional:
pageSize <integer> The maximum number of accounts to include in the response, used for paging. If unspecified, at most 10000 accounts will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-listChildAccounts parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}:listChildAccounts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-getAdBlockingRecoveryTag
  "Gets the ad blocking recovery tag of an account.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/getAdBlockingRecoveryTag

name <string> Required. The name of the account to get the tag for. Format: accounts/{account}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adsense.googleapis.com/v2/{+name}/adBlockingRecoveryTag",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-adclients-list
  "Lists all the ad clients available in an account.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/list

parent <string> Required. The account which owns the collection of ad clients. Format: accounts/{account}

optional:
pageSize <integer> The maximum number of ad clients to include in the response, used for paging. If unspecified, at most 10000 ad clients will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-adclients-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/adclients",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-adclients-get
  "Gets the ad client from the given resource name.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/get

name <string> Required. The name of the ad client to retrieve. Format: accounts/{account}/adclients/{adclient}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-adclients-getAdcode
  "Gets the AdSense code for a given ad client. This returns what was previously known as the 'auto ad code'. This is only supported for ad clients with a product_code of AFC. For more information, see [About the AdSense code](https://support.google.com/adsense/answer/9274634).
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/getAdcode

name <string> Required. Name of the ad client for which to get the adcode. Format: accounts/{account}/adclients/{adclient}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}/adcode",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-adclients-adunits-get
  "Gets an ad unit from a specified account and ad client.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/adunits/get

name <string> Required. AdUnit to get information about. Format: accounts/{account}/adclients/{adclient}/adunits/{adunit}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-adclients-adunits-list
  "Lists all ad units under a specified account and ad client.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/adunits/list

parent <string> Required. The ad client which owns the collection of ad units. Format: accounts/{account}/adclients/{adclient}

optional:
pageSize <integer> The maximum number of ad units to include in the response, used for paging. If unspecified, at most 10000 ad units will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-adclients-adunits-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/adunits",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-adclients-adunits-getAdcode
  "Gets the ad unit code for a given ad unit. For more information, see [About the AdSense code](https://support.google.com/adsense/answer/9274634) and [Where to place the ad code in your HTML](https://support.google.com/adsense/answer/9190028).
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/adunits/getAdcode

name <string> Required. Name of the adunit for which to get the adcode. Format: accounts/{account}/adclients/{adclient}/adunits/{adunit}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}/adcode",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-adclients-adunits-create
  "Creates an ad unit. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method. Note that ad units can only be created for ad clients with an \"AFC\" product code. For more info see the [AdClient resource](/adsense/management/reference/rest/v2/accounts.adclients). For now, this method can only be used to create `DISPLAY` ad units. See: https://support.google.com/adsense/answer/9183566
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/adunits/create

parent <string> Required. Ad client to create an ad unit under. Format: accounts/{account}/adclients/{adclient}
AdUnit:
{:name string,
 :reportingDimensionId string,
 :displayName string,
 :state [STATE_UNSPECIFIED ACTIVE ARCHIVED],
 :contentAdsSettings
 {:size string,
  :type [TYPE_UNSPECIFIED DISPLAY FEED ARTICLE MATCHED_CONTENT LINK]}}"
  [parent AdUnit]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adsense.googleapis.com/v2/{+parent}/adunits",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsense"],
     :body AdUnit}))

(defn accounts-adclients-adunits-patch
  "Updates an ad unit. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method. For now, this method can only be used to update `DISPLAY` ad units. See: https://support.google.com/adsense/answer/9183566
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/adunits/patch

name <string> Output only. Resource name of the ad unit. Format: accounts/{account}/adclients/{adclient}/adunits/{adunit}
AdUnit:
{:name string,
 :reportingDimensionId string,
 :displayName string,
 :state [STATE_UNSPECIFIED ACTIVE ARCHIVED],
 :contentAdsSettings
 {:size string,
  :type [TYPE_UNSPECIFIED DISPLAY FEED ARTICLE MATCHED_CONTENT LINK]}}

optional:
updateMask <string> The list of fields to update. If empty, a full update is performed."
  ([name AdUnit] (accounts-adclients-adunits-patch name AdUnit nil))
  ([name AdUnit optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://adsense.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsense"],
       :body AdUnit})))

(defn accounts-adclients-adunits-listLinkedCustomChannels
  "Lists all the custom channels available for an ad unit.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/adunits/listLinkedCustomChannels

parent <string> Required. The ad unit which owns the collection of custom channels. Format: accounts/{account}/adclients/{adclient}/adunits/{adunit}

optional:
pageSize <integer> The maximum number of custom channels to include in the response, used for paging. If unspecified, at most 10000 custom channels will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent]
    (accounts-adclients-adunits-listLinkedCustomChannels parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}:listLinkedCustomChannels",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-adclients-customchannels-listLinkedAdUnits
  "Lists all the ad units available for a custom channel.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/customchannels/listLinkedAdUnits

parent <string> Required. The custom channel which owns the collection of ad units. Format: accounts/{account}/adclients/{adclient}/customchannels/{customchannel}

optional:
pageSize <integer> The maximum number of ad units to include in the response, used for paging. If unspecified, at most 10000 ad units will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent]
    (accounts-adclients-customchannels-listLinkedAdUnits parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}:listLinkedAdUnits",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-adclients-customchannels-get
  "Gets information about the selected custom channel.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/customchannels/get

name <string> Required. Name of the custom channel. Format: accounts/{account}/adclients/{adclient}/customchannels/{customchannel}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-adclients-customchannels-list
  "Lists all the custom channels available in an ad client.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/customchannels/list

parent <string> Required. The ad client which owns the collection of custom channels. Format: accounts/{account}/adclients/{adclient}

optional:
pageSize <integer> The maximum number of custom channels to include in the response, used for paging. If unspecified, at most 10000 custom channels will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-adclients-customchannels-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/customchannels",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-adclients-customchannels-create
  "Creates a custom channel. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/customchannels/create

parent <string> Required. The ad client to create a custom channel under. Format: accounts/{account}/adclients/{adclient}
CustomChannel:
{:name string,
 :reportingDimensionId string,
 :displayName string,
 :active boolean}"
  [parent CustomChannel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://adsense.googleapis.com/v2/{+parent}/customchannels",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsense"],
     :body CustomChannel}))

(defn accounts-adclients-customchannels-patch
  "Updates a custom channel. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/customchannels/patch

name <string> Output only. Resource name of the custom channel. Format: accounts/{account}/adclients/{adclient}/customchannels/{customchannel}
CustomChannel:
{:name string,
 :reportingDimensionId string,
 :displayName string,
 :active boolean}

optional:
updateMask <string> The list of fields to update. If empty, a full update is performed."
  ([name CustomChannel]
    (accounts-adclients-customchannels-patch name CustomChannel nil))
  ([name CustomChannel optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://adsense.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsense"],
       :body CustomChannel})))

(defn accounts-adclients-customchannels-delete
  "Deletes a custom channel. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/customchannels/delete

name <string> Required. Name of the custom channel to delete. Format: accounts/{account}/adclients/{adclient}/customchannels/{customchannel}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsense"]}))

(defn accounts-adclients-urlchannels-get
  "Gets information about the selected url channel.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/urlchannels/get

name <string> Required. The name of the url channel to retrieve. Format: accounts/{account}/adclients/{adclient}/urlchannels/{urlchannel}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-adclients-urlchannels-list
  "Lists active url channels.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/adclients/urlchannels/list

parent <string> Required. The ad client which owns the collection of url channels. Format: accounts/{account}/adclients/{adclient}

optional:
pageSize <integer> The maximum number of url channels to include in the response, used for paging. If unspecified, at most 10000 url channels will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-adclients-urlchannels-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/urlchannels",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-alerts-list
  "Lists all the alerts available in an account.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/alerts/list

parent <string> Required. The account which owns the collection of alerts. Format: accounts/{account}

optional:
languageCode <string> The language to use for translating alert messages. If unspecified, this defaults to the user's display language. If the given language is not supported, alerts will be returned in English. The language is specified as an [IETF BCP-47 language code](https://en.wikipedia.org/wiki/IETF_language_tag)."
  ([parent] (accounts-alerts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/alerts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-payments-list
  "Lists all the payments available for an account.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/payments/list

parent <string> Required. The account which owns the collection of payments. Format: accounts/{account}"
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adsense.googleapis.com/v2/{+parent}/payments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-policyIssues-get
  "Gets information about the selected policy issue.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/policyIssues/get

name <string> Required. Name of the policy issue. Format: accounts/{account}/policyIssues/{policy_issue}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-policyIssues-list
  "Lists all the policy issues where the specified account is involved, both directly and through any AFP child accounts.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/policyIssues/list

parent <string> Required. The account for which policy issues are being retrieved. Format: accounts/{account}

optional:
pageSize <integer> The maximum number of policy issues to include in the response, used for paging. If unspecified, at most 10000 policy issues will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-policyIssues-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/policyIssues",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-reports-getSaved
  "Gets the saved report from the given resource name.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/reports/getSaved

name <string> Required. The name of the saved report to retrieve. Format: accounts/{account}/reports/{report}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}/saved",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-reports-generate
  "Generates an ad hoc report.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/reports/generate

account <string> Required. The account which owns the collection of reports. Format: accounts/{account}

optional:
dateRange <string> Date range of the report, if unset the range will be considered CUSTOM.
limit <integer> The maximum number of rows of report data to return. Reports producing more rows than the requested limit will be truncated. If unset, this defaults to 100,000 rows for `Reports.GenerateReport` and 1,000,000 rows for `Reports.GenerateCsvReport`, which are also the maximum values permitted here. Report truncation can be identified (for `Reports.GenerateReport` only) by comparing the number of rows returned to the value returned in `total_matched_rows`.
filters <string> A list of [filters](/adsense/management/reporting/filtering) to apply to the report. All provided filters must match in order for the data to be included in the report.
startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
dimensions <string> Dimensions to base the report on.
reportingTimeZone <string> Timezone in which to generate the report. If unspecified, this defaults to the account timezone. For more information, see [changing the time zone of your reports](https://support.google.com/adsense/answer/9830725).
endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
languageCode <string> The language to use for translating report output. If unspecified, this defaults to English (\"en\"). If the given language is not supported, report output will be returned in English. The language is specified as an [IETF BCP-47 language code](https://en.wikipedia.org/wiki/IETF_language_tag).
startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
currencyCode <string> The [ISO-4217 currency code](https://en.wikipedia.org/wiki/ISO_4217) to use when reporting on monetary metrics. Defaults to the account's currency if not set.
startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
metrics <string> Required. Reporting metrics.
endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
orderBy <string> The name of a dimension or metric to sort the resulting report on, can be prefixed with \"+\" to sort ascending or \"-\" to sort descending. If no prefix is specified, the column is sorted ascending."
  ([account] (accounts-reports-generate account nil))
  ([account optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+account}/reports:generate",
       :uri-template-args {:account account},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-reports-generateCsv
  "Generates a csv formatted ad hoc report.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/reports/generateCsv

account <string> Required. The account which owns the collection of reports. Format: accounts/{account}

optional:
dateRange <string> Date range of the report, if unset the range will be considered CUSTOM.
limit <integer> The maximum number of rows of report data to return. Reports producing more rows than the requested limit will be truncated. If unset, this defaults to 100,000 rows for `Reports.GenerateReport` and 1,000,000 rows for `Reports.GenerateCsvReport`, which are also the maximum values permitted here. Report truncation can be identified (for `Reports.GenerateReport` only) by comparing the number of rows returned to the value returned in `total_matched_rows`.
filters <string> A list of [filters](/adsense/management/reporting/filtering) to apply to the report. All provided filters must match in order for the data to be included in the report.
startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
dimensions <string> Dimensions to base the report on.
reportingTimeZone <string> Timezone in which to generate the report. If unspecified, this defaults to the account timezone. For more information, see [changing the time zone of your reports](https://support.google.com/adsense/answer/9830725).
endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
languageCode <string> The language to use for translating report output. If unspecified, this defaults to English (\"en\"). If the given language is not supported, report output will be returned in English. The language is specified as an [IETF BCP-47 language code](https://en.wikipedia.org/wiki/IETF_language_tag).
startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
currencyCode <string> The [ISO-4217 currency code](https://en.wikipedia.org/wiki/ISO_4217) to use when reporting on monetary metrics. Defaults to the account's currency if not set.
startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
metrics <string> Required. Reporting metrics.
endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
orderBy <string> The name of a dimension or metric to sort the resulting report on, can be prefixed with \"+\" to sort ascending or \"-\" to sort descending. If no prefix is specified, the column is sorted ascending."
  ([account] (accounts-reports-generateCsv account nil))
  ([account optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+account}/reports:generateCsv",
       :uri-template-args {:account account},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-reports-saved-generate
  "Generates a saved report.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/reports/saved/generate

name <string> Required. Name of the saved report. Format: accounts/{account}/reports/{report}

optional:
dateRange <string> Date range of the report, if unset the range will be considered CUSTOM.
startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
reportingTimeZone <string> Timezone in which to generate the report. If unspecified, this defaults to the account timezone. For more information, see [changing the time zone of your reports](https://support.google.com/adsense/answer/9830725).
endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
languageCode <string> The language to use for translating report output. If unspecified, this defaults to English (\"en\"). If the given language is not supported, report output will be returned in English. The language is specified as an [IETF BCP-47 language code](https://en.wikipedia.org/wiki/IETF_language_tag).
startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
currencyCode <string> The [ISO-4217 currency code](https://en.wikipedia.org/wiki/ISO_4217) to use when reporting on monetary metrics. Defaults to the account's currency if not set.
startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year."
  ([name] (accounts-reports-saved-generate name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+name}/saved:generate",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-reports-saved-generateCsv
  "Generates a csv formatted saved report.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/reports/saved/generateCsv

name <string> Required. Name of the saved report. Format: accounts/{account}/reports/{report}

optional:
dateRange <string> Date range of the report, if unset the range will be considered CUSTOM.
startDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
reportingTimeZone <string> Timezone in which to generate the report. If unspecified, this defaults to the account timezone. For more information, see [changing the time zone of your reports](https://support.google.com/adsense/answer/9830725).
endDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.day <integer> Day of a month. Must be from 1 to 31 and valid for the year and month, or 0 to specify a year by itself or a year and month where the day isn't significant.
languageCode <string> The language to use for translating report output. If unspecified, this defaults to English (\"en\"). If the given language is not supported, report output will be returned in English. The language is specified as an [IETF BCP-47 language code](https://en.wikipedia.org/wiki/IETF_language_tag).
startDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year.
currencyCode <string> The [ISO-4217 currency code](https://en.wikipedia.org/wiki/ISO_4217) to use when reporting on monetary metrics. Defaults to the account's currency if not set.
startDate.month <integer> Month of a year. Must be from 1 to 12, or 0 to specify a year without a month and day.
endDate.year <integer> Year of the date. Must be from 1 to 9999, or 0 to specify a date without a year."
  ([name] (accounts-reports-saved-generateCsv name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+name}/saved:generateCsv",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-reports-saved-list
  "Lists saved reports.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/reports/saved/list

parent <string> Required. The account which owns the collection of reports. Format: accounts/{account}

optional:
pageSize <integer> The maximum number of reports to include in the response, used for paging. If unspecified, at most 10000 reports will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-reports-saved-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/reports/saved",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

(defn accounts-sites-get
  "Gets information about the selected site.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/sites/get

name <string> Required. Name of the site. Format: accounts/{account}/sites/{site}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://adsense.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/adsense"
      "https://www.googleapis.com/auth/adsense.readonly"]}))

(defn accounts-sites-list
  "Lists all the sites available in an account.
https://developers.google.com/adsense/management/reference/rest/v2/accounts/sites/list

parent <string> Required. The account which owns the collection of sites. Format: accounts/{account}

optional:
pageSize <integer> The maximum number of sites to include in the response, used for paging. If unspecified, at most 10000 sites will be returned. The maximum value is 10000; values above 10000 will be coerced to 10000."
  ([parent] (accounts-sites-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://adsense.googleapis.com/v2/{+parent}/sites",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/adsense"
        "https://www.googleapis.com/auth/adsense.readonly"]})))

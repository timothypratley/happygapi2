(ns happygapi2.adsensehost
  "AdSense Host API
Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
See: https://developers.google.com/adsense/host/"
  (:require [happy.oauth2.client :as client]))

(defn accounts-get
  "Get information about the selected associated AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/get

accountId <string> Account to get information about."
  [accountId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}",
     :uri-template-args {:accountId accountId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn accounts-list
  "List hosted accounts associated with this AdSense account by ad client id.
https://developers.google.com/adsense/host/v4.1/docs/accounts/list

filterAdClientId <string> Ad clients to list accounts for."
  [filterAdClientId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts",
     :uri-template-args {},
     :query-params {:filterAdClientId filterAdClientId},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn accounts-adclients-get
  "Get information about one of the ad clients in the specified publisher's AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adclients/get

accountId <string> Account which contains the ad client.
adClientId <string> Ad client to get."
  [accountId adClientId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}",
     :uri-template-args {:accountId accountId, :adClientId adClientId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn accounts-adclients-list
  "List all hosted ad clients in the specified hosted account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adclients/list

accountId <string> Account for which to list ad clients.

optional:
maxResults <integer> The maximum number of ad clients to include in the response, used for paging."
  ([accountId] (accounts-adclients-list accountId nil))
  ([accountId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients",
       :uri-template-args {:accountId accountId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn accounts-adunits-delete
  "Delete the specified ad unit from the specified publisher AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adunits/delete

accountId <string> Account which contains the ad unit.
adClientId <string> Ad client for which to get ad unit.
adUnitId <string> Ad unit to delete."
  [accountId adClientId adUnitId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}",
     :uri-template-args
     {:accountId accountId,
      :adClientId adClientId,
      :adUnitId adUnitId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn accounts-adunits-get
  "Get the specified host ad unit in this AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adunits/get

accountId <string> Account which contains the ad unit.
adClientId <string> Ad client for which to get ad unit.
adUnitId <string> Ad unit to get."
  [accountId adClientId adUnitId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}",
     :uri-template-args
     {:accountId accountId,
      :adClientId adClientId,
      :adUnitId adUnitId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn accounts-adunits-getAdCode
  "Get ad code for the specified ad unit, attaching the specified host custom channels.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adunits/getAdCode

accountId <string> Account which contains the ad client.
adClientId <string> Ad client with contains the ad unit.
adUnitId <string> Ad unit to get the code for.

optional:
hostCustomChannelId <string> Host custom channel to attach to the ad code."
  ([accountId adClientId adUnitId]
    (accounts-adunits-getAdCode accountId adClientId adUnitId nil))
  ([accountId adClientId adUnitId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}/adcode",
       :uri-template-args
       {:accountId accountId,
        :adClientId adClientId,
        :adUnitId adUnitId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn accounts-adunits-insert
  "Insert the supplied ad unit into the specified publisher AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adunits/insert

accountId <string> Account which will contain the ad unit.
adClientId <string> Ad client into which to insert the ad unit.
AdUnit:
{:code string,
 :contentAdsSettings
 {:backupOption {:color string, :type string, :url string},
  :size string,
  :type string},
 :customStyle
 {:colors
  {:background string,
   :border string,
   :text string,
   :title string,
   :url string},
  :corners string,
  :font {:family string, :size string},
  :kind string},
 :id string,
 :kind string,
 :mobileContentAdsSettings
 {:markupLanguage string,
  :scriptingLanguage string,
  :size string,
  :type string},
 :name string,
 :status string}"
  [accountId adClientId AdUnit]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}/adunits",
     :uri-template-args {:accountId accountId, :adClientId adClientId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"],
     :body AdUnit}))

(defn accounts-adunits-list
  "List all ad units in the specified publisher's AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adunits/list

accountId <string> Account which contains the ad client.
adClientId <string> Ad client for which to list ad units.

optional:
includeInactive <boolean> Whether to include inactive ad units. Default: true.
maxResults <integer> The maximum number of ad units to include in the response, used for paging."
  ([accountId adClientId]
    (accounts-adunits-list accountId adClientId nil))
  ([accountId adClientId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}/adunits",
       :uri-template-args
       {:accountId accountId, :adClientId adClientId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn accounts-adunits-patch
  "Update the supplied ad unit in the specified publisher AdSense account. This method supports patch semantics.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adunits/patch

accountId <string> Account which contains the ad client.
adClientId <string> Ad client which contains the ad unit.
adUnitId <string> Ad unit to get.
AdUnit:
{:code string,
 :contentAdsSettings
 {:backupOption {:color string, :type string, :url string},
  :size string,
  :type string},
 :customStyle
 {:colors
  {:background string,
   :border string,
   :text string,
   :title string,
   :url string},
  :corners string,
  :font {:family string, :size string},
  :kind string},
 :id string,
 :kind string,
 :mobileContentAdsSettings
 {:markupLanguage string,
  :scriptingLanguage string,
  :size string,
  :type string},
 :name string,
 :status string}"
  [accountId adClientId adUnitId AdUnit]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}/adunits",
     :uri-template-args {:accountId accountId, :adClientId adClientId},
     :query-params {:adUnitId adUnitId},
     :scopes ["https://www.googleapis.com/auth/adsensehost"],
     :body AdUnit}))

(defn accounts-adunits-update
  "Update the supplied ad unit in the specified publisher AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/accounts/adunits/update

accountId <string> Account which contains the ad client.
adClientId <string> Ad client which contains the ad unit.
AdUnit:
{:code string,
 :contentAdsSettings
 {:backupOption {:color string, :type string, :url string},
  :size string,
  :type string},
 :customStyle
 {:colors
  {:background string,
   :border string,
   :text string,
   :title string,
   :url string},
  :corners string,
  :font {:family string, :size string},
  :kind string},
 :id string,
 :kind string,
 :mobileContentAdsSettings
 {:markupLanguage string,
  :scriptingLanguage string,
  :size string,
  :type string},
 :name string,
 :status string}"
  [accountId adClientId AdUnit]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/adclients/{adClientId}/adunits",
     :uri-template-args {:accountId accountId, :adClientId adClientId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"],
     :body AdUnit}))

(defn accounts-reports-generate
  "Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter.
https://developers.google.com/adsense/host/v4.1/docs/accounts/reports/generate

accountId <string> Hosted account upon which to report.
startDate <string> Start of the date range to report on in \"YYYY-MM-DD\" format, inclusive.
endDate <string> End of the date range to report on in \"YYYY-MM-DD\" format, inclusive.

optional:
locale <string> Optional locale to use for translating report output to a local language. Defaults to \"en_US\" if not specified.
filter <string> Filters to be run on the report.
dimension <string> Dimensions to base the report on.
startIndex <integer> Index of the first row of report data to return.
metric <string> Numeric columns to include in the report.
sort <string> The name of a dimension or metric to sort the resulting report on, optionally prefixed with \"+\" to sort ascending or \"-\" to sort descending. If no prefix is specified, the column is sorted ascending.
maxResults <integer> The maximum number of rows of report data to return."
  ([accountId startDate endDate]
    (accounts-reports-generate accountId startDate endDate nil))
  ([accountId startDate endDate optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/accounts/{accountId}/reports",
       :uri-template-args {:accountId accountId},
       :query-params
       (merge {:startDate startDate, :endDate endDate} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn adclients-get
  "Get information about one of the ad clients in the Host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/adclients/get

adClientId <string> Ad client to get."
  [adClientId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}",
     :uri-template-args {:adClientId adClientId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn adclients-list
  "List all host ad clients in this AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/adclients/list

optional:
maxResults <integer> The maximum number of ad clients to include in the response, used for paging."
  ([] (adclients-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/adclients",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn associationsessions-start
  "Create an association session for initiating an association with an AdSense user.
https://developers.google.com/adsense/host/v4.1/docs/associationsessions/start

productCode <string> Products to associate with the user.
websiteUrl <string> The URL of the user's hosted website.

optional:
callbackUrl <string> The URL to redirect the user to once association is completed. It receives a token parameter that can then be used to retrieve the associated account.
userLocale <string> The preferred locale of the user.
websiteLocale <string> The locale of the user's hosted website."
  ([productCode websiteUrl]
    (associationsessions-start productCode websiteUrl nil))
  ([productCode websiteUrl optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/associationsessions/start",
       :uri-template-args {},
       :query-params
       (merge
         {:productCode productCode, :websiteUrl websiteUrl}
         optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn associationsessions-verify
  "Verify an association session after the association callback returns from AdSense signup.
https://developers.google.com/adsense/host/v4.1/docs/associationsessions/verify

token <string> The token returned to the association callback URL."
  [token]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/associationsessions/verify",
     :uri-template-args {},
     :query-params {:token token},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn customchannels-delete
  "Delete a specific custom channel from the host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/customchannels/delete

adClientId <string> Ad client from which to delete the custom channel.
customChannelId <string> Custom channel to delete."
  [adClientId customChannelId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/customchannels/{customChannelId}",
     :uri-template-args
     {:adClientId adClientId, :customChannelId customChannelId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn customchannels-get
  "Get a specific custom channel from the host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/customchannels/get

adClientId <string> Ad client from which to get the custom channel.
customChannelId <string> Custom channel to get."
  [adClientId customChannelId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/customchannels/{customChannelId}",
     :uri-template-args
     {:adClientId adClientId, :customChannelId customChannelId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn customchannels-insert
  "Add a new custom channel to the host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/customchannels/insert

adClientId <string> Ad client to which the new custom channel will be added.
CustomChannel:
{:code string, :id string, :kind string, :name string}"
  [adClientId CustomChannel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/customchannels",
     :uri-template-args {:adClientId adClientId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"],
     :body CustomChannel}))

(defn customchannels-list
  "List all host custom channels in this AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/customchannels/list

adClientId <string> Ad client for which to list custom channels.

optional:
maxResults <integer> The maximum number of custom channels to include in the response, used for paging."
  ([adClientId] (customchannels-list adClientId nil))
  ([adClientId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/customchannels",
       :uri-template-args {:adClientId adClientId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn customchannels-patch
  "Update a custom channel in the host AdSense account. This method supports patch semantics.
https://developers.google.com/adsense/host/v4.1/docs/customchannels/patch

adClientId <string> Ad client in which the custom channel will be updated.
customChannelId <string> Custom channel to get.
CustomChannel:
{:code string, :id string, :kind string, :name string}"
  [adClientId customChannelId CustomChannel]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/customchannels",
     :uri-template-args {:adClientId adClientId},
     :query-params {:customChannelId customChannelId},
     :scopes ["https://www.googleapis.com/auth/adsensehost"],
     :body CustomChannel}))

(defn customchannels-update
  "Update a custom channel in the host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/customchannels/update

adClientId <string> Ad client in which the custom channel will be updated.
CustomChannel:
{:code string, :id string, :kind string, :name string}"
  [adClientId CustomChannel]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/customchannels",
     :uri-template-args {:adClientId adClientId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"],
     :body CustomChannel}))

(defn reports-generate
  "Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter.
https://developers.google.com/adsense/host/v4.1/docs/reports/generate

startDate <string> Start of the date range to report on in \"YYYY-MM-DD\" format, inclusive.
endDate <string> End of the date range to report on in \"YYYY-MM-DD\" format, inclusive.

optional:
locale <string> Optional locale to use for translating report output to a local language. Defaults to \"en_US\" if not specified.
filter <string> Filters to be run on the report.
dimension <string> Dimensions to base the report on.
startIndex <integer> Index of the first row of report data to return.
metric <string> Numeric columns to include in the report.
sort <string> The name of a dimension or metric to sort the resulting report on, optionally prefixed with \"+\" to sort ascending or \"-\" to sort descending. If no prefix is specified, the column is sorted ascending.
maxResults <integer> The maximum number of rows of report data to return."
  ([startDate endDate] (reports-generate startDate endDate nil))
  ([startDate endDate optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/reports",
       :uri-template-args {},
       :query-params
       (merge {:startDate startDate, :endDate endDate} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(defn urlchannels-delete
  "Delete a URL channel from the host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/urlchannels/delete

adClientId <string> Ad client from which to delete the URL channel.
urlChannelId <string> URL channel to delete."
  [adClientId urlChannelId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/urlchannels/{urlChannelId}",
     :uri-template-args
     {:adClientId adClientId, :urlChannelId urlChannelId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"]}))

(defn urlchannels-insert
  "Add a new URL channel to the host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/urlchannels/insert

adClientId <string> Ad client to which the new URL channel will be added.
UrlChannel:
{:id string, :kind string, :urlPattern string}"
  [adClientId UrlChannel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/urlchannels",
     :uri-template-args {:adClientId adClientId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/adsensehost"],
     :body UrlChannel}))

(defn urlchannels-list
  "List all host URL channels in the host AdSense account.
https://developers.google.com/adsense/host/v4.1/docs/urlchannels/list

adClientId <string> Ad client for which to list URL channels.

optional:
maxResults <integer> The maximum number of URL channels to include in the response, used for paging."
  ([adClientId] (urlchannels-list adClientId nil))
  ([adClientId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/adsensehost/v4.1/adclients/{adClientId}/urlchannels",
       :uri-template-args {:adClientId adClientId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/adsensehost"]})))

(ns happygapi2.searchconsole
  "Google Search Console API
The Search Console API provides access to both Search Console data (verified users only) and to public information on an URL basis (anyone)
See: https://developer.chrome.com/docs/lighthouse/overview/"
  (:require [happy.oauth2.client :as client]))

(defn sitemaps-get
  "Retrieves information about a specific sitemap.
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The site's URL, including protocol. For example: `http://www.example.com/`.
feedpath <string> The URL of the actual sitemap. For example: `http://www.example.com/sitemap.xml`."
  [siteUrl feedpath]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}/sitemaps/{feedpath}",
     :uri-template-args {:feedpath feedpath, :siteUrl siteUrl},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/webmasters"
      "https://www.googleapis.com/auth/webmasters.readonly"]}))

(defn sitemaps-list
  " Lists the [sitemaps-entries](/webmaster-tools/v3/sitemaps) submitted for this site, or included in the sitemap index file (if `sitemapIndex` is specified in the request).
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The site's URL, including protocol. For example: `http://www.example.com/`.

optional:
sitemapIndex <string>  A URL of a site's sitemap index. For example: `http://www.example.com/sitemapindex.xml`."
  ([siteUrl] (sitemaps-list siteUrl nil))
  ([siteUrl optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}/sitemaps",
       :uri-template-args {:siteUrl siteUrl},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/webmasters"
        "https://www.googleapis.com/auth/webmasters.readonly"]})))

(defn sitemaps-submit
  "Submits a sitemap for a site.
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The site's URL, including protocol. For example: `http://www.example.com/`.
feedpath <string> The URL of the actual sitemap. For example: `http://www.example.com/sitemap.xml`."
  [siteUrl feedpath]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}/sitemaps/{feedpath}",
     :uri-template-args {:siteUrl siteUrl, :feedpath feedpath},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/webmasters"]}))

(defn sitemaps-delete
  "Deletes a sitemap from the Sitemaps report. Does not stop Google from crawling this sitemap or the URLs that were previously crawled in the deleted sitemap.
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The site's URL, including protocol. For example: `http://www.example.com/`.
feedpath <string> The URL of the actual sitemap. For example: `http://www.example.com/sitemap.xml`."
  [siteUrl feedpath]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}/sitemaps/{feedpath}",
     :uri-template-args {:feedpath feedpath, :siteUrl siteUrl},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/webmasters"]}))

(defn sites-list
  " Lists the user's Search Console sites.
https://developer.chrome.com/docs/lighthouse/overview"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/webmasters"
      "https://www.googleapis.com/auth/webmasters.readonly"]}))

(defn sites-delete
  " Removes a site from the set of the user's Search Console sites.
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The URI of the property as defined in Search Console. **Examples:** `http://www.example.com/` or `sc-domain:example.com`."
  [siteUrl]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}",
     :uri-template-args {:siteUrl siteUrl},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/webmasters"]}))

(defn sites-add
  " Adds a site to the set of the user's sites in Search Console.
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The URL of the site to add."
  [siteUrl]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}",
     :uri-template-args {:siteUrl siteUrl},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/webmasters"]}))

(defn sites-get
  " Retrieves information about specific site.
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The URI of the property as defined in Search Console. **Examples:** `http://www.example.com/` or `sc-domain:example.com`."
  [siteUrl]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}",
     :uri-template-args {:siteUrl siteUrl},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/webmasters"
      "https://www.googleapis.com/auth/webmasters.readonly"]}))

(defn urlTestingTools-mobileFriendlyTest-run
  "Runs Mobile-Friendly Test for a given URL.
https://developer.chrome.com/docs/lighthouse/overview

RunMobileFriendlyTestRequest:
{:url string, :requestScreenshot boolean}"
  [RunMobileFriendlyTestRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://searchconsole.googleapis.com/v1/urlTestingTools/mobileFriendlyTest:run",
     :uri-template-args {},
     :query-params {},
     :scopes nil,
     :body RunMobileFriendlyTestRequest}))

(defn urlInspection-index-inspect
  "Index inspection.
https://developer.chrome.com/docs/lighthouse/overview

InspectUrlIndexRequest:
{:languageCode string, :siteUrl string, :inspectionUrl string}"
  [InspectUrlIndexRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://searchconsole.googleapis.com/v1/urlInspection/index:inspect",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/webmasters"
      "https://www.googleapis.com/auth/webmasters.readonly"],
     :body InspectUrlIndexRequest}))

(defn searchanalytics-query
  "Query your data with filters and parameters that you define. Returns zero or more rows grouped by the row keys that you define. You must define a date range of one or more days. When date is one of the group by values, any days without data are omitted from the result list. If you need to know which days have data, issue a broad date range query grouped by date for any metric, and see which day rows are returned.
https://developer.chrome.com/docs/lighthouse/overview

siteUrl <string> The site's URL, including protocol. For example: `http://www.example.com/`.
SearchAnalyticsQueryRequest:
{:searchType [WEB IMAGE VIDEO NEWS DISCOVER GOOGLE_NEWS],
 :startDate string,
 :dataState [DATA_STATE_UNSPECIFIED FINAL ALL],
 :type [WEB IMAGE VIDEO NEWS DISCOVER GOOGLE_NEWS],
 :rowLimit integer,
 :dimensions [[DATE QUERY PAGE COUNTRY DEVICE SEARCH_APPEARANCE]],
 :endDate string,
 :dimensionFilterGroups
 [{:filters
   [{:expression string,
     :operator
     [EQUALS
      NOT_EQUALS
      CONTAINS
      NOT_CONTAINS
      INCLUDING_REGEX
      EXCLUDING_REGEX],
     :dimension [QUERY PAGE COUNTRY DEVICE SEARCH_APPEARANCE]}],
   :groupType [AND]}],
 :startRow integer,
 :aggregationType [AUTO BY_PROPERTY BY_PAGE BY_NEWS_SHOWCASE_PANEL]}"
  [siteUrl SearchAnalyticsQueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://searchconsole.googleapis.com/webmasters/v3/sites/{siteUrl}/searchAnalytics/query",
     :uri-template-args {:siteUrl siteUrl},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/webmasters"
      "https://www.googleapis.com/auth/webmasters.readonly"],
     :body SearchAnalyticsQueryRequest}))

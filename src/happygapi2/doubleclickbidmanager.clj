(ns happygapi2.doubleclickbidmanager
  "DoubleClick Bid Manager API
DoubleClick Bid Manager API allows users to manage and create campaigns and reports.
See: https://developers.google.com/bid-manager/guides/getting-started-api"
  (:require [happy.oauth2.client :as client]))

(defn queries-create
  "Creates a query.
https://developers.google.com/bid-manager/guides/getting-started-api

Query:
{:queryId string,
 :metadata
 {:title string,
  :dataRange
  {:range
   [RANGE_UNSPECIFIED
    CUSTOM_DATES
    CURRENT_DAY
    PREVIOUS_DAY
    WEEK_TO_DATE
    MONTH_TO_DATE
    QUARTER_TO_DATE
    YEAR_TO_DATE
    PREVIOUS_WEEK
    PREVIOUS_MONTH
    PREVIOUS_QUARTER
    PREVIOUS_YEAR
    LAST_7_DAYS
    LAST_30_DAYS
    LAST_90_DAYS
    LAST_365_DAYS
    ALL_TIME
    LAST_14_DAYS
    LAST_60_DAYS],
   :customStartDate {:year integer, :month integer, :day integer},
   :customEndDate {:year integer, :month integer, :day integer}},
  :format [FORMAT_UNSPECIFIED CSV XLSX],
  :sendNotification boolean,
  :shareEmailAddress [string]},
 :params
 {:type
  [REPORT_TYPE_UNSPECIFIED
   STANDARD
   INVENTORY_AVAILABILITY
   AUDIENCE_COMPOSITION
   FLOODLIGHT
   YOUTUBE
   GRP
   YOUTUBE_PROGRAMMATIC_GUARANTEED
   REACH
   UNIQUE_REACH_AUDIENCE],
  :groupBys [string],
  :filters [{:type string, :value string}],
  :metrics [string],
  :options {:includeOnlyTargetedUserLists boolean}},
 :schedule
 {:startDate {:year integer, :month integer, :day integer},
  :endDate {:year integer, :month integer, :day integer},
  :frequency
  [FREQUENCY_UNSPECIFIED
   ONE_TIME
   DAILY
   WEEKLY
   SEMI_MONTHLY
   MONTHLY
   QUARTERLY
   YEARLY],
  :nextRunTimezoneCode string}}"
  [Query]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://doubleclickbidmanager.googleapis.com/v2/queries",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"],
     :body Query}))

(defn queries-delete
  "Deletes a query as well as the associated reports.
https://developers.google.com/bid-manager/guides/getting-started-api

queryId <string> Required. ID of query to delete."
  [queryId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://doubleclickbidmanager.googleapis.com/v2/queries/{queryId}",
     :uri-template-args {:queryId queryId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/doubleclickbidmanager"]}))

(defn queries-get
  "Retrieves a query.
https://developers.google.com/bid-manager/guides/getting-started-api

queryId <string> Required. ID of query to retrieve."
  [queryId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://doubleclickbidmanager.googleapis.com/v2/queries/{queryId}",
     :uri-template-args {:queryId queryId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/doubleclickbidmanager"]}))

(defn queries-list
  "Lists queries created by the current user.
https://developers.google.com/bid-manager/guides/getting-started-api

optional:
pageSize <integer> Maximum number of results per page. Must be between `1` and `100`. Defaults to `100` if unspecified.
orderBy <string> Name of a field used to order results. The default sorting order is ascending. To specify descending order for a field, append a \" desc\" suffix. For example \"metadata.title desc\". Sorting is only supported for the following fields: * `queryId` * `metadata.title`"
  ([] (queries-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://doubleclickbidmanager.googleapis.com/v2/queries",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/doubleclickbidmanager"]})))

(defn queries-run
  "Runs a stored query to generate a report.
https://developers.google.com/bid-manager/guides/getting-started-api

queryId <string> Required. ID of query to run.
RunQueryRequest:
{:dataRange
 {:range
  [RANGE_UNSPECIFIED
   CUSTOM_DATES
   CURRENT_DAY
   PREVIOUS_DAY
   WEEK_TO_DATE
   MONTH_TO_DATE
   QUARTER_TO_DATE
   YEAR_TO_DATE
   PREVIOUS_WEEK
   PREVIOUS_MONTH
   PREVIOUS_QUARTER
   PREVIOUS_YEAR
   LAST_7_DAYS
   LAST_30_DAYS
   LAST_90_DAYS
   LAST_365_DAYS
   ALL_TIME
   LAST_14_DAYS
   LAST_60_DAYS],
  :customStartDate {:year integer, :month integer, :day integer},
  :customEndDate {:year integer, :month integer, :day integer}}}

optional:
synchronous <boolean> Whether the query should be run synchronously. When true, this method will not return until the query has finished running. When false or not specified, this method will return immediately."
  ([queryId RunQueryRequest] (queries-run queryId RunQueryRequest nil))
  ([queryId RunQueryRequest optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://doubleclickbidmanager.googleapis.com/v2/queries/{queryId}:run",
       :uri-template-args {:queryId queryId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/doubleclickbidmanager"],
       :body RunQueryRequest})))

(defn queries-reports-list
  "Lists reports associated with a query.
https://developers.google.com/bid-manager/guides/getting-started-api

queryId <string> Required. ID of the query with which the reports are associated.

optional:
pageSize <integer> Maximum number of results per page. Must be between `1` and `100`. Defaults to `100` if unspecified.
orderBy <string> Name of a field used to order results. The default sorting order is ascending. To specify descending order for a field, append a \" desc\" suffix. For example \"key.reportId desc\". Sorting is only supported for the following fields: * `key.reportId`"
  ([queryId] (queries-reports-list queryId nil))
  ([queryId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://doubleclickbidmanager.googleapis.com/v2/queries/{queryId}/reports",
       :uri-template-args {:queryId queryId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/doubleclickbidmanager"]})))

(defn queries-reports-get
  "Retrieves a report.
https://developers.google.com/bid-manager/guides/getting-started-api

queryId <string> Required. ID of the query the report is associated with.
reportId <string> Required. ID of the report to retrieve."
  [queryId reportId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://doubleclickbidmanager.googleapis.com/v2/queries/{queryId}/reports/{reportId}",
     :uri-template-args {:queryId queryId, :reportId reportId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/doubleclickbidmanager"]}))

(ns happygapi2.youtubeAnalytics
  "YouTube Analytics API
Retrieves your YouTube Analytics data.
See: https://developers.google.com/youtube/analytics"
  (:require [happy.oauth2.client :as client]))

(defn groupItems-insert
  "Creates a group item.
https://developers.google.com/youtube/analytics/v2/docs/groupItems/insert

GroupItem:
{:etag string,
 :groupId string,
 :id string,
 :kind string,
 :resource {:kind string, :id string},
 :errors
 {:error
  [{:externalErrorMessage string,
    :code string,
    :argument [string],
    :domain string,
    :debugInfo string,
    :location string,
    :locationType [PATH OTHER PARAMETER]}],
  :requestId string,
  :code
  [BAD_REQUEST
   FORBIDDEN
   NOT_FOUND
   CONFLICT
   GONE
   PRECONDITION_FAILED
   INTERNAL_ERROR
   SERVICE_UNAVAILABLE]}}

optional:
onBehalfOfContentOwner <string> This parameter can only be used in a properly authorized request. **Note:** This parameter is intended exclusively for YouTube content partners that own and manage many different YouTube channels. The `onBehalfOfContentOwner` parameter indicates that the request's authorization credentials identify a YouTube user who is acting on behalf of the content owner specified in the parameter value. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The account that the user authenticates with must be linked to the specified YouTube content owner."
  ([GroupItem] (groupItems-insert GroupItem nil))
  ([GroupItem optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/groupItems",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"],
       :body GroupItem})))

(defn groupItems-list
  "Returns a collection of group items that match the API request parameters.
https://developers.google.com/youtube/analytics/v2/docs/groupItems/list

optional:
onBehalfOfContentOwner <string> This parameter can only be used in a properly authorized request. **Note:** This parameter is intended exclusively for YouTube content partners that own and manage many different YouTube channels. The `onBehalfOfContentOwner` parameter indicates that the request's authorization credentials identify a YouTube user who is acting on behalf of the content owner specified in the parameter value. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The account that the user authenticates with must be linked to the specified YouTube content owner.
groupId <string> The `groupId` parameter specifies the unique ID of the group for which you want to retrieve group items."
  ([] (groupItems-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/groupItems",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn groupItems-delete
  "Removes an item from a group.
https://developers.google.com/youtube/analytics/v2/docs/groupItems/delete

optional:
onBehalfOfContentOwner <string> This parameter can only be used in a properly authorized request. **Note:** This parameter is intended exclusively for YouTube content partners that own and manage many different YouTube channels. The `onBehalfOfContentOwner` parameter indicates that the request's authorization credentials identify a YouTube user who is acting on behalf of the content owner specified in the parameter value. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The account that the user authenticates with must be linked to the specified YouTube content owner.
id <string> The `id` parameter specifies the YouTube group item ID of the group item that is being deleted."
  ([] (groupItems-delete nil))
  ([optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/groupItems",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn reports-query
  "Retrieve your YouTube Analytics reports.
https://developers.google.com/youtube/analytics/v2/docs/reports/query

optional:
filters <string> A list of filters that should be applied when retrieving YouTube Analytics data. The [Available Reports](/youtube/analytics/v2/available_reports) document identifies the dimensions that can be used to filter each report, and the [Dimensions](/youtube/analytics/v2/dimsmets/dims) document defines those dimensions. If a request uses multiple filters, join them together with a semicolon (`;`), and the returned result table will satisfy both filters. For example, a filters parameter value of `video==dMH0bHeiRNg;country==IT` restricts the result set to include data for the given video in Italy.\",
startDate <string> The start date for fetching YouTube Analytics data. The value should be in `YYYY-MM-DD` format. required: true, pattern: \"[0-9]{4}-[0-9]{2}-[0-9]{2}
ids <string> Identifies the YouTube channel or content owner for which you are retrieving YouTube Analytics data. - To request data for a YouTube user, set the `ids` parameter value to `channel==CHANNEL_ID`, where `CHANNEL_ID` specifies the unique YouTube channel ID. - To request data for a YouTube CMS content owner, set the `ids` parameter value to `contentOwner==OWNER_NAME`, where `OWNER_NAME` is the CMS name of the content owner. required: true, pattern: [a-zA-Z]+==[a-zA-Z0-9_+-]+
dimensions <string> A comma-separated list of YouTube Analytics dimensions, such as `views` or `ageGroup,gender`. See the [Available Reports](/youtube/analytics/v2/available_reports) document for a list of the reports that you can retrieve and the dimensions used for those reports. Also see the [Dimensions](/youtube/analytics/v2/dimsmets/dims) document for definitions of those dimensions.\" pattern: [0-9a-zA-Z,]+
currency <string> The currency to which financial metrics should be converted. The default is US Dollar (USD). If the result contains no financial metrics, this flag will be ignored. Responds with an error if the specified currency is not recognized.\", pattern: [A-Z]{3}
includeHistoricalChannelData <boolean> If set to true historical data (i.e. channel data from before the linking of the channel to the content owner) will be retrieved.\",
endDate <string> The end date for fetching YouTube Analytics data. The value should be in `YYYY-MM-DD` format. required: true, pattern: [0-9]{4}-[0-9]{2}-[0-9]{2}
startIndex <integer> An index of the first entity to retrieve. Use this parameter as a pagination mechanism along with the max-results parameter (one-based, inclusive).\", minValue: 1
metrics <string> A comma-separated list of YouTube Analytics metrics, such as `views` or `likes,dislikes`. See the [Available Reports](/youtube/analytics/v2/available_reports) document for a list of the reports that you can retrieve and the metrics available in each report, and see the [Metrics](/youtube/analytics/v2/dimsmets/mets) document for definitions of those metrics. required: true, pattern: [0-9a-zA-Z,]+
sort <string> A comma-separated list of dimensions or metrics that determine the sort order for YouTube Analytics data. By default the sort order is ascending. The '`-`' prefix causes descending sort order.\", pattern: [-0-9a-zA-Z,]+
maxResults <integer> The maximum number of rows to include in the response.\", minValue: 1"
  ([] (reports-query nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/reports",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn groups-list
  "Returns a collection of groups that match the API request parameters. For example, you can retrieve all groups that the authenticated user owns, or you can retrieve one or more groups by their unique IDs.
https://developers.google.com/youtube/analytics/v2/docs/groups/list

optional:
mine <boolean> This parameter can only be used in a properly authorized request. Set this parameter's value to true to retrieve all groups owned by the authenticated user.
id <string> The `id` parameter specifies a comma-separated list of the YouTube group ID(s) for the resource(s) that are being retrieved. Each group must be owned by the authenticated user. In a `group` resource, the `id` property specifies the group's YouTube group ID. Note that if you do not specify a value for the `id` parameter, then you must set the `mine` parameter to `true`.
onBehalfOfContentOwner <string> This parameter can only be used in a properly authorized request. **Note:** This parameter is intended exclusively for YouTube content partners that own and manage many different YouTube channels. The `onBehalfOfContentOwner` parameter indicates that the request's authorization credentials identify a YouTube user who is acting on behalf of the content owner specified in the parameter value. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The account that the user authenticates with must be linked to the specified YouTube content owner."
  ([] (groups-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/groups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn groups-delete
  "Deletes a group.
https://developers.google.com/youtube/analytics/v2/docs/groups/delete

optional:
id <string> The `id` parameter specifies the YouTube group ID of the group that is being deleted.
onBehalfOfContentOwner <string> This parameter can only be used in a properly authorized request. **Note:** This parameter is intended exclusively for YouTube content partners that own and manage many different YouTube channels. The `onBehalfOfContentOwner` parameter indicates that the request's authorization credentials identify a YouTube user who is acting on behalf of the content owner specified in the parameter value. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The account that the user authenticates with must be linked to the specified YouTube content owner."
  ([] (groups-delete nil))
  ([optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/groups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn groups-insert
  "Creates a group.
https://developers.google.com/youtube/analytics/v2/docs/groups/insert

Group:
{:contentDetails {:itemType string, :itemCount string},
 :errors
 {:error
  [{:externalErrorMessage string,
    :code string,
    :argument [string],
    :domain string,
    :debugInfo string,
    :location string,
    :locationType [PATH OTHER PARAMETER]}],
  :requestId string,
  :code
  [BAD_REQUEST
   FORBIDDEN
   NOT_FOUND
   CONFLICT
   GONE
   PRECONDITION_FAILED
   INTERNAL_ERROR
   SERVICE_UNAVAILABLE]},
 :kind string,
 :etag string,
 :id string,
 :snippet {:title string, :publishedAt string}}

optional:
onBehalfOfContentOwner <string> This parameter can only be used in a properly authorized request. **Note:** This parameter is intended exclusively for YouTube content partners that own and manage many different YouTube channels. The `onBehalfOfContentOwner` parameter indicates that the request's authorization credentials identify a YouTube user who is acting on behalf of the content owner specified in the parameter value. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The account that the user authenticates with must be linked to the specified YouTube content owner."
  ([Group] (groups-insert Group nil))
  ([Group optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/groups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"],
       :body Group})))

(defn groups-update
  "Modifies a group. For example, you could change a group's title.
https://developers.google.com/youtube/analytics/v2/docs/groups/update

Group:
{:contentDetails {:itemType string, :itemCount string},
 :errors
 {:error
  [{:externalErrorMessage string,
    :code string,
    :argument [string],
    :domain string,
    :debugInfo string,
    :location string,
    :locationType [PATH OTHER PARAMETER]}],
  :requestId string,
  :code
  [BAD_REQUEST
   FORBIDDEN
   NOT_FOUND
   CONFLICT
   GONE
   PRECONDITION_FAILED
   INTERNAL_ERROR
   SERVICE_UNAVAILABLE]},
 :kind string,
 :etag string,
 :id string,
 :snippet {:title string, :publishedAt string}}

optional:
onBehalfOfContentOwner <string> This parameter can only be used in a properly authorized request. **Note:** This parameter is intended exclusively for YouTube content partners that own and manage many different YouTube channels. The `onBehalfOfContentOwner` parameter indicates that the request's authorization credentials identify a YouTube user who is acting on behalf of the content owner specified in the parameter value. It allows content owners to authenticate once and get access to all their video and channel data, without having to provide authentication credentials for each individual channel. The account that the user authenticates with must be linked to the specified YouTube content owner."
  ([Group] (groups-update Group nil))
  ([Group optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://youtubeanalytics.googleapis.com/v2/groups",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/youtube"
        "https://www.googleapis.com/auth/youtube.readonly"
        "https://www.googleapis.com/auth/youtubepartner"
        "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"],
       :body Group})))

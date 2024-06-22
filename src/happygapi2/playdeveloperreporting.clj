(ns happygapi2.playdeveloperreporting
  "Google Play Developer Reporting API

See: https://developers.google.com/play/developer/reporting"
  (:require [happy.oauth2.client :as client]))

(defn anomalies-list
  "Lists anomalies in any of the datasets.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/anomalies/list

parent <string> Required. Parent app for which anomalies were detected. Format: apps/{app}

optional:
pageSize <integer> Maximum size of the returned data. If unspecified, at most 10 anomalies will be returned. The maximum value is 100; values above 100 will be coerced to 100.
filter <string> Filtering criteria for anomalies. For basic filter guidance, please check: https://google.aip.dev/160. **Supported functions:** * `activeBetween(startTime, endTime)`: If specified, only list anomalies that were active in between `startTime` (inclusive) and `endTime` (exclusive). Both parameters are expected to conform to an RFC-3339 formatted string (e.g. `2012-04-21T11:30:00-04:00`). UTC offsets are supported. Both `startTime` and `endTime` accept the special value `UNBOUNDED`, to signify intervals with no lower or upper bound, respectively. Examples: * `activeBetween(\"2021-04-21T11:30:00Z\", \"2021-07-21T00:00:00Z\")` * `activeBetween(UNBOUNDED, \"2021-11-21T00:00:00-04:00\")` * `activeBetween(\"2021-07-21T00:00:00-04:00\", UNBOUNDED)`"
  ([parent] (anomalies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://playdeveloperreporting.googleapis.com/v1beta1/{+parent}/anomalies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/playdeveloperreporting"]})))

(defn apps-fetchReleaseFilterOptions
  "Describes filtering options for releases.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/apps/fetchReleaseFilterOptions

name <string> Required. Name of the resource, i.e. app the filtering options are for. Format: apps/{app}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:fetchReleaseFilterOptions",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(defn apps-search
  "Searches for Apps accessible by the user.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/apps/search

optional:
pageSize <integer> The maximum number of apps to return. The service may return fewer than this value. If unspecified, at most 50 apps will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([] (apps-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://playdeveloperreporting.googleapis.com/v1beta1/apps:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/playdeveloperreporting"]})))

(defn vitals-anrrate-get
  "Describes the properties of the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/anrrate/get

name <string> Required. The resource name. Format: apps/{app}/anrRateMetricSet"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(defn vitals-anrrate-query
  "Queries the metrics in the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/anrrate/query

name <string> Required. The resource name. Format: apps/{app}/anrRateMetricSet
GooglePlayDeveloperReportingV1beta1QueryAnrRateMetricSetRequest:
{:filter string,
 :dimensions [string],
 :userCohort [USER_COHORT_UNSPECIFIED OS_PUBLIC OS_BETA APP_TESTERS],
 :pageToken string,
 :timelineSpec
 {:aggregationPeriod
  [AGGREGATION_PERIOD_UNSPECIFIED HOURLY DAILY FULL_RANGE],
  :endTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer},
  :startTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer}},
 :metrics [string],
 :pageSize integer}"
  [name
   GooglePlayDeveloperReportingV1beta1QueryAnrRateMetricSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"],
     :body
     GooglePlayDeveloperReportingV1beta1QueryAnrRateMetricSetRequest}))

(defn vitals-crashrate-query
  "Queries the metrics in the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/crashrate/query

name <string> Required. The resource name. Format: apps/{app}/crashRateMetricSet
GooglePlayDeveloperReportingV1beta1QueryCrashRateMetricSetRequest:
{:pageToken string,
 :metrics [string],
 :filter string,
 :userCohort [USER_COHORT_UNSPECIFIED OS_PUBLIC OS_BETA APP_TESTERS],
 :dimensions [string],
 :timelineSpec
 {:aggregationPeriod
  [AGGREGATION_PERIOD_UNSPECIFIED HOURLY DAILY FULL_RANGE],
  :endTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer},
  :startTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer}},
 :pageSize integer}"
  [name
   GooglePlayDeveloperReportingV1beta1QueryCrashRateMetricSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"],
     :body
     GooglePlayDeveloperReportingV1beta1QueryCrashRateMetricSetRequest}))

(defn vitals-crashrate-get
  "Describes the properties of the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/crashrate/get

name <string> Required. The resource name. Format: apps/{app}/crashRateMetricSet"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(defn vitals-errors-counts-get
  "Describes the properties of the metrics set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/errors/counts/get

name <string> Required. Name of the errors metric set. Format: apps/{app}/errorCountMetricSet"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(defn vitals-errors-counts-query
  "Queries the metrics in the metrics set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/errors/counts/query

name <string> Required. The resource name. Format: apps/{app}/errorCountMetricSet
GooglePlayDeveloperReportingV1beta1QueryErrorCountMetricSetRequest:
{:dimensions [string],
 :filter string,
 :pageToken string,
 :timelineSpec
 {:aggregationPeriod
  [AGGREGATION_PERIOD_UNSPECIFIED HOURLY DAILY FULL_RANGE],
  :endTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer},
  :startTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer}},
 :pageSize integer,
 :metrics [string]}"
  [name
   GooglePlayDeveloperReportingV1beta1QueryErrorCountMetricSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"],
     :body
     GooglePlayDeveloperReportingV1beta1QueryErrorCountMetricSetRequest}))

(defn vitals-errors-reports-search
  "Searches all error reports received for an app.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/errors/reports/search

parent <string> Required. Parent resource of the reports, indicating the application for which they were received. Format: apps/{app}

optional:
interval.startTime.nanos <integer> Optional. Fractions of seconds in nanoseconds. Must be from 0 to 999,999,999, defaults to 0.
interval.startTime.day <integer> Optional. Day of month. Must be from 1 to 31 and valid for the year and month, or 0 if specifying a datetime without a day.
interval.startTime.seconds <integer> Optional. Seconds of minutes of the time. Must normally be from 0 to 59, defaults to 0. An API may allow the value 60 if it allows leap-seconds.
interval.endTime.seconds <integer> Optional. Seconds of minutes of the time. Must normally be from 0 to 59, defaults to 0. An API may allow the value 60 if it allows leap-seconds.
interval.startTime.year <integer> Optional. Year of date. Must be from 1 to 9999, or 0 if specifying a datetime without a year.
interval.startTime.utcOffset <string> UTC offset. Must be whole seconds, between -18 hours and +18 hours. For example, a UTC offset of -4:00 would be represented as { seconds: -14400 }.
interval.endTime.day <integer> Optional. Day of month. Must be from 1 to 31 and valid for the year and month, or 0 if specifying a datetime without a day.
interval.endTime.nanos <integer> Optional. Fractions of seconds in nanoseconds. Must be from 0 to 999,999,999, defaults to 0.
interval.endTime.minutes <integer> Optional. Minutes of hour of day. Must be from 0 to 59, defaults to 0.
interval.endTime.hours <integer> Optional. Hours of day in 24 hour format. Should be from 0 to 23, defaults to 0 (midnight). An API may choose to allow the value \"24:00:00\" for scenarios like business closing time.
interval.endTime.timeZone.version <string> Optional. IANA Time Zone Database version number, e.g. \"2019a\".
interval.endTime.utcOffset <string> UTC offset. Must be whole seconds, between -18 hours and +18 hours. For example, a UTC offset of -4:00 would be represented as { seconds: -14400 }.
interval.startTime.month <integer> Optional. Month of year. Must be from 1 to 12, or 0 if specifying a datetime without a month.
interval.startTime.hours <integer> Optional. Hours of day in 24 hour format. Should be from 0 to 23, defaults to 0 (midnight). An API may choose to allow the value \"24:00:00\" for scenarios like business closing time.
filter <string> A selection predicate to retrieve only a subset of the reports. For filtering basics, please check [AIP-160](https://google.aip.dev/160). ** Supported field names:** * `apiLevel`: Matches error reports that occurred in the requested Android versions (specified as the numeric API level) only. Example: `apiLevel = 28 OR apiLevel = 29`. * `versionCode`: Matches error reports that occurred in the requested app version codes only. Example: `versionCode = 123 OR versionCode = 456`. * `deviceModel`: Matches error issues that occurred in the requested devices. Example: `deviceModel = \"google/walleye\" OR deviceModel = \"google/marlin\"`. * `deviceBrand`: Matches error issues that occurred in the requested device brands. Example: `deviceBrand = \"Google\". * `deviceType`: Matches error reports that occurred in the requested device types. Example: `deviceType = \"PHONE\"`. * `errorIssueType`: Matches error reports of the requested types only. Valid candidates: `JAVA_CRASH`, `NATIVE_CRASH`, `ANR`. Example: `errorIssueType = JAVA_CRASH OR errorIssueType = NATIVE_CRASH`. * `errorIssueId`: Matches error reports belonging to the requested error issue ids only. Example: `errorIssueId = 1234 OR errorIssueId = 4567`. * `errorReportId`: Matches error reports with the requested error report id. Example: `errorReportId = 1234 OR errorReportId = 4567`. * `appProcessState`: Matches error reports on the process state of an app, indicating whether an app runs in the foreground (user-visible) or background. Valid candidates: `FOREGROUND`, `BACKGROUND`. Example: `appProcessState = FOREGROUND`. * `isUserPerceived`: Matches error reports that are user-perceived. It is not accompanied by any operators. Example: `isUserPerceived`. ** Supported operators:** * Comparison operators: The only supported comparison operator is equality. The filtered field must appear on the left hand side of the comparison. * Logical Operators: Logical operators `AND` and `OR` can be used to build complex filters following a conjunctive normal form (CNF), i.e., conjunctions of disjunctions. The `OR` operator takes precedence over `AND` so the use of parenthesis is not necessary when building CNF. The `OR` operator is only supported to build disjunctions that apply to the same field, e.g., `versionCode = 123 OR versionCode = ANR`. The filter expression `versionCode = 123 OR errorIssueType = ANR` is not valid. ** Examples ** Some valid filtering expressions: * `versionCode = 123 AND errorIssueType = ANR` * `versionCode = 123 AND errorIssueType = OR errorIssueType = CRASH` * `versionCode = 123 AND (errorIssueType = OR errorIssueType = CRASH)`
pageSize <integer> The maximum number of reports to return. The service may return fewer than this value. If unspecified, at most 50 reports will be returned. The maximum value is 100; values above 100 will be coerced to 100.
interval.startTime.minutes <integer> Optional. Minutes of hour of day. Must be from 0 to 59, defaults to 0.
interval.endTime.year <integer> Optional. Year of date. Must be from 1 to 9999, or 0 if specifying a datetime without a year.
interval.startTime.timeZone.id <string> IANA Time Zone Database time zone, e.g. \"America/New_York\".
interval.endTime.timeZone.id <string> IANA Time Zone Database time zone, e.g. \"America/New_York\".
interval.endTime.month <integer> Optional. Month of year. Must be from 1 to 12, or 0 if specifying a datetime without a month.
interval.startTime.timeZone.version <string> Optional. IANA Time Zone Database version number, e.g. \"2019a\"."
  ([parent] (vitals-errors-reports-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://playdeveloperreporting.googleapis.com/v1beta1/{+parent}/errorReports:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/playdeveloperreporting"]})))

(defn vitals-errors-issues-search
  "Searches all error issues in which reports have been grouped.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/errors/issues/search

parent <string> Required. Parent resource of the error issues, indicating the application for which they were received. Format: apps/{app}

optional:
interval.startTime.nanos <integer> Optional. Fractions of seconds in nanoseconds. Must be from 0 to 999,999,999, defaults to 0.
interval.startTime.day <integer> Optional. Day of month. Must be from 1 to 31 and valid for the year and month, or 0 if specifying a datetime without a day.
interval.startTime.seconds <integer> Optional. Seconds of minutes of the time. Must normally be from 0 to 59, defaults to 0. An API may allow the value 60 if it allows leap-seconds.
interval.endTime.seconds <integer> Optional. Seconds of minutes of the time. Must normally be from 0 to 59, defaults to 0. An API may allow the value 60 if it allows leap-seconds.
interval.startTime.year <integer> Optional. Year of date. Must be from 1 to 9999, or 0 if specifying a datetime without a year.
interval.startTime.utcOffset <string> UTC offset. Must be whole seconds, between -18 hours and +18 hours. For example, a UTC offset of -4:00 would be represented as { seconds: -14400 }.
interval.endTime.day <integer> Optional. Day of month. Must be from 1 to 31 and valid for the year and month, or 0 if specifying a datetime without a day.
interval.endTime.nanos <integer> Optional. Fractions of seconds in nanoseconds. Must be from 0 to 999,999,999, defaults to 0.
interval.endTime.minutes <integer> Optional. Minutes of hour of day. Must be from 0 to 59, defaults to 0.
interval.endTime.hours <integer> Optional. Hours of day in 24 hour format. Should be from 0 to 23, defaults to 0 (midnight). An API may choose to allow the value \"24:00:00\" for scenarios like business closing time.
interval.endTime.timeZone.version <string> Optional. IANA Time Zone Database version number, e.g. \"2019a\".
interval.endTime.utcOffset <string> UTC offset. Must be whole seconds, between -18 hours and +18 hours. For example, a UTC offset of -4:00 would be represented as { seconds: -14400 }.
interval.startTime.month <integer> Optional. Month of year. Must be from 1 to 12, or 0 if specifying a datetime without a month.
sampleErrorReportLimit <integer> Optional. Number of sample error reports to return per ErrorIssue. If unspecified, 0 will be used. *Note:* currently only 0 and 1 are supported.
interval.startTime.hours <integer> Optional. Hours of day in 24 hour format. Should be from 0 to 23, defaults to 0 (midnight). An API may choose to allow the value \"24:00:00\" for scenarios like business closing time.
filter <string> A selection predicate to retrieve only a subset of the issues. Counts in the returned error issues will only reflect occurrences that matched the filter. For filtering basics, please check [AIP-160](https://google.aip.dev/160). ** Supported field names:** * `apiLevel`: Matches error issues that occurred in the requested Android versions (specified as the numeric API level) only. Example: `apiLevel = 28 OR apiLevel = 29`. * `versionCode`: Matches error issues that occurred in the requested app version codes only. Example: `versionCode = 123 OR versionCode = 456`. * `deviceModel`: Matches error issues that occurred in the requested devices. Example: `deviceModel = \"google/walleye\" OR deviceModel = \"google/marlin\"`. * `deviceBrand`: Matches error issues that occurred in the requested device brands. Example: `deviceBrand = \"Google\". * `deviceType`: Matches error issues that occurred in the requested device types. Example: `deviceType = \"PHONE\"`. * `errorIssueType`: Matches error issues of the requested types only. Valid candidates: `CRASH`, `ANR`. Example: `errorIssueType = CRASH OR errorIssueType = ANR`. * `appProcessState`: Matches error issues on the process state of an app, indicating whether an app runs in the foreground (user-visible) or background. Valid candidates: `FOREGROUND`, `BACKGROUND`. Example: `appProcessState = FOREGROUND`. * `isUserPerceived`: Matches error issues that are user-perceived. It is not accompanied by any operators. Example: `isUserPerceived`. ** Supported operators:** * Comparison operators: The only supported comparison operator is equality. The filtered field must appear on the left hand side of the comparison. * Logical Operators: Logical operators `AND` and `OR` can be used to build complex filters following a conjunctive normal form (CNF), i.e., conjunctions of disjunctions. The `OR` operator takes precedence over `AND` so the use of parenthesis is not necessary when building CNF. The `OR` operator is only supported to build disjunctions that apply to the same field, e.g., `versionCode = 123 OR errorIssueType = ANR` is not a valid filter. ** Examples ** Some valid filtering expressions: * `versionCode = 123 AND errorIssueType = ANR` * `versionCode = 123 AND errorIssueType = OR errorIssueType = CRASH` * `versionCode = 123 AND (errorIssueType = OR errorIssueType = CRASH)`
pageSize <integer> The maximum number of error issues to return. The service may return fewer than this value. If unspecified, at most 50 error issues will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
interval.startTime.minutes <integer> Optional. Minutes of hour of day. Must be from 0 to 59, defaults to 0.
interval.endTime.year <integer> Optional. Year of date. Must be from 1 to 9999, or 0 if specifying a datetime without a year.
interval.startTime.timeZone.id <string> IANA Time Zone Database time zone, e.g. \"America/New_York\".
interval.endTime.timeZone.id <string> IANA Time Zone Database time zone, e.g. \"America/New_York\".
interval.endTime.month <integer> Optional. Month of year. Must be from 1 to 12, or 0 if specifying a datetime without a month.
orderBy <string> Specifies a field that will be used to order the results. ** Supported dimensions:** * `errorReportCount`: Orders issues by number of error reports. * `distinctUsers`: Orders issues by number of unique affected users. ** Supported operations:** * `asc` for ascending order. * `desc` for descending order. Format: A field and an operation, e.g., `errorReportCount desc` *Note:* currently only one field is supported at a time.
interval.startTime.timeZone.version <string> Optional. IANA Time Zone Database version number, e.g. \"2019a\"."
  ([parent] (vitals-errors-issues-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://playdeveloperreporting.googleapis.com/v1beta1/{+parent}/errorIssues:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/playdeveloperreporting"]})))

(defn vitals-slowrenderingrate-query
  "Queries the metrics in the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/slowrenderingrate/query

name <string> Required. The resource name. Format: apps/{app}/slowRenderingRateMetricSet
GooglePlayDeveloperReportingV1beta1QuerySlowRenderingRateMetricSetRequest:
{:pageToken string,
 :dimensions [string],
 :metrics [string],
 :pageSize integer,
 :timelineSpec
 {:aggregationPeriod
  [AGGREGATION_PERIOD_UNSPECIFIED HOURLY DAILY FULL_RANGE],
  :endTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer},
  :startTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer}},
 :userCohort [USER_COHORT_UNSPECIFIED OS_PUBLIC OS_BETA APP_TESTERS],
 :filter string}"
  [name
   GooglePlayDeveloperReportingV1beta1QuerySlowRenderingRateMetricSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"],
     :body
     GooglePlayDeveloperReportingV1beta1QuerySlowRenderingRateMetricSetRequest}))

(defn vitals-slowrenderingrate-get
  "Describes the properties of the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/slowrenderingrate/get

name <string> Required. The resource name. Format: apps/{app}/slowRenderingRateMetricSet"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(defn vitals-slowstartrate-get
  "Describes the properties of the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/slowstartrate/get

name <string> Required. The resource name. Format: apps/{app}/slowStartRateMetricSet"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(defn vitals-slowstartrate-query
  "Queries the metrics in the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/slowstartrate/query

name <string> Required. The resource name. Format: apps/{app}/slowStartRateMetricSet
GooglePlayDeveloperReportingV1beta1QuerySlowStartRateMetricSetRequest:
{:pageToken string,
 :metrics [string],
 :filter string,
 :timelineSpec
 {:aggregationPeriod
  [AGGREGATION_PERIOD_UNSPECIFIED HOURLY DAILY FULL_RANGE],
  :endTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer},
  :startTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer}},
 :userCohort [USER_COHORT_UNSPECIFIED OS_PUBLIC OS_BETA APP_TESTERS],
 :pageSize integer,
 :dimensions [string]}"
  [name
   GooglePlayDeveloperReportingV1beta1QuerySlowStartRateMetricSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"],
     :body
     GooglePlayDeveloperReportingV1beta1QuerySlowStartRateMetricSetRequest}))

(defn vitals-excessivewakeuprate-query
  "Queries the metrics in the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/excessivewakeuprate/query

name <string> Required. The resource name. Format: apps/{app}/excessiveWakeupRateMetricSet
GooglePlayDeveloperReportingV1beta1QueryExcessiveWakeupRateMetricSetRequest:
{:metrics [string],
 :pageSize integer,
 :timelineSpec
 {:aggregationPeriod
  [AGGREGATION_PERIOD_UNSPECIFIED HOURLY DAILY FULL_RANGE],
  :endTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer},
  :startTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer}},
 :dimensions [string],
 :pageToken string,
 :userCohort [USER_COHORT_UNSPECIFIED OS_PUBLIC OS_BETA APP_TESTERS],
 :filter string}"
  [name
   GooglePlayDeveloperReportingV1beta1QueryExcessiveWakeupRateMetricSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"],
     :body
     GooglePlayDeveloperReportingV1beta1QueryExcessiveWakeupRateMetricSetRequest}))

(defn vitals-excessivewakeuprate-get
  "Describes the properties of the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/excessivewakeuprate/get

name <string> Required. The resource name. Format: apps/{app}/excessiveWakeupRateMetricSet"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(defn vitals-stuckbackgroundwakelockrate-query
  "Queries the metrics in the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/stuckbackgroundwakelockrate/query

name <string> Required. The resource name. Format: apps/{app}/stuckBackgroundWakelockRateMetricSet
GooglePlayDeveloperReportingV1beta1QueryStuckBackgroundWakelockRateMetricSetRequest:
{:pageToken string,
 :metrics [string],
 :userCohort [USER_COHORT_UNSPECIFIED OS_PUBLIC OS_BETA APP_TESTERS],
 :timelineSpec
 {:aggregationPeriod
  [AGGREGATION_PERIOD_UNSPECIFIED HOURLY DAILY FULL_RANGE],
  :endTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer},
  :startTime
  {:timeZone {:version string, :id string},
   :day integer,
   :nanos integer,
   :month integer,
   :seconds integer,
   :year integer,
   :utcOffset string,
   :hours integer,
   :minutes integer}},
 :pageSize integer,
 :filter string,
 :dimensions [string]}"
  [name
   GooglePlayDeveloperReportingV1beta1QueryStuckBackgroundWakelockRateMetricSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}:query",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"],
     :body
     GooglePlayDeveloperReportingV1beta1QueryStuckBackgroundWakelockRateMetricSetRequest}))

(defn vitals-stuckbackgroundwakelockrate-get
  "Describes the properties of the metric set.
https://developers.google.com/play/developer/reporting/reference/rest/v1beta1/vitals/stuckbackgroundwakelockrate/get

name <string> Required. The resource name. Format: apps/{app}/stuckBackgroundWakelockRateMetricSet"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://playdeveloperreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/playdeveloperreporting"]}))

(ns happygapi2.clouderrorreporting
  "Error Reporting API
Groups and counts similar errors from cloud services and applications, reports new errors, and provides access to error groups and their associated errors. 
See: https://cloud.google.com/error-reporting/"
  (:require [happy.oauth2.client :as client]))

(defn projects-deleteEvents
  "Deletes all error events of a given project.
https://cloud.google.com/error-reporting/reference/rest/v1beta1/projects/deleteEvents

projectName <string> Required. The resource name of the Google Cloud Platform project. Written as `projects/{projectID}`, where `{projectID}` is the [Google Cloud Platform project ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`."
  [projectName]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://clouderrorreporting.googleapis.com/v1beta1/{+projectName}/events",
     :uri-template-args {:projectName projectName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-groups-get
  "Get the specified group.
https://cloud.google.com/error-reporting/reference/rest/v1beta1/projects/groups/get

groupName <string> Required. The group resource name. Written as `projects/{projectID}/groups/{group_id}`. Call groupStats.list to return a list of groups belonging to this project. Example: `projects/my-project-123/groups/my-group` In the group resource name, the `group_id` is a unique identifier for a particular error group. The identifier is derived from key parts of the error-log content and is treated as Service Data. For information about how Service Data is handled, see [Google Cloud Privacy Notice](https://cloud.google.com/terms/cloud-privacy-notice)."
  [groupName]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://clouderrorreporting.googleapis.com/v1beta1/{+groupName}",
     :uri-template-args {:groupName groupName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-groups-update
  "Replace the data for the specified group. Fails if the group does not exist.
https://cloud.google.com/error-reporting/reference/rest/v1beta1/projects/groups/update

name <string> The group resource name. Written as `projects/{projectID}/groups/{group_id}`. Example: `projects/my-project-123/groups/my-group` In the group resource name, the `group_id` is a unique identifier for a particular error group. The identifier is derived from key parts of the error-log content and is treated as Service Data. For information about how Service Data is handled, see [Google Cloud Privacy Notice](https://cloud.google.com/terms/cloud-privacy-notice).
ErrorGroup:
{:name string,
 :groupId string,
 :trackingIssues [{:url string}],
 :resolutionStatus
 [RESOLUTION_STATUS_UNSPECIFIED OPEN ACKNOWLEDGED RESOLVED MUTED]}"
  [name ErrorGroup]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://clouderrorreporting.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ErrorGroup}))

(defn projects-groupStats-list
  "Lists the specified groups.
https://cloud.google.com/error-reporting/reference/rest/v1beta1/projects/groupStats/list

projectName <string> Required. The resource name of the Google Cloud Platform project. Written as `projects/{projectID}` or `projects/{projectNumber}`, where `{projectID}` and `{projectNumber}` can be found in the [Google Cloud console](https://support.google.com/cloud/answer/6158840). Examples: `projects/my-project-123`, `projects/5551234`.

optional:
groupId <string> Optional. List all ErrorGroupStats with these IDs. The `group_id` is a unique identifier for a particular error group. The identifier is derived from key parts of the error-log content and is treated as Service Data. For information about how Service Data is handled, see [Google Cloud Privacy Notice] (https://cloud.google.com/terms/cloud-privacy-notice).
serviceFilter.resourceType <string> Optional. The exact value to match against [`ServiceContext.resource_type`](/error-reporting/reference/rest/v1beta1/ServiceContext#FIELDS.resource_type).
alignment <string> Optional. The alignment of the timed counts to be returned. Default is `ALIGNMENT_EQUAL_AT_END`.
alignmentTime <string> Optional. Time where the timed counts shall be aligned if rounded alignment is chosen. Default is 00:00 UTC.
pageSize <integer> Optional. The maximum number of results to return per response. Default is 20.
serviceFilter.version <string> Optional. The exact value to match against [`ServiceContext.version`](/error-reporting/reference/rest/v1beta1/ServiceContext#FIELDS.version).
timeRange.period <string> Restricts the query to the specified time range.
order <string> Optional. The sort order in which the results are returned. Default is `COUNT_DESC`.
timedCountDuration <string> Optional. The preferred duration for a single returned TimedCount. If not set, no timed counts are returned.
serviceFilter.service <string> Optional. The exact value to match against [`ServiceContext.service`](/error-reporting/reference/rest/v1beta1/ServiceContext#FIELDS.service)."
  ([projectName] (projects-groupStats-list projectName nil))
  ([projectName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouderrorreporting.googleapis.com/v1beta1/{+projectName}/groupStats",
       :uri-template-args {:projectName projectName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-events-list
  "Lists the specified events.
https://cloud.google.com/error-reporting/reference/rest/v1beta1/projects/events/list

projectName <string> Required. The resource name of the Google Cloud Platform project. Written as `projects/{projectID}`, where `{projectID}` is the [Google Cloud Platform project ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.

optional:
groupId <string> Required. The group for which events shall be returned. The `group_id` is a unique identifier for a particular error group. The identifier is derived from key parts of the error-log content and is treated as Service Data. For information about how Service Data is handled, see [Google Cloud Privacy Notice](https://cloud.google.com/terms/cloud-privacy-notice).
serviceFilter.service <string> Optional. The exact value to match against [`ServiceContext.service`](/error-reporting/reference/rest/v1beta1/ServiceContext#FIELDS.service).
serviceFilter.version <string> Optional. The exact value to match against [`ServiceContext.version`](/error-reporting/reference/rest/v1beta1/ServiceContext#FIELDS.version).
serviceFilter.resourceType <string> Optional. The exact value to match against [`ServiceContext.resource_type`](/error-reporting/reference/rest/v1beta1/ServiceContext#FIELDS.resource_type).
timeRange.period <string> Restricts the query to the specified time range.
pageSize <integer> Optional. The maximum number of results to return per response."
  ([projectName] (projects-events-list projectName nil))
  ([projectName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouderrorreporting.googleapis.com/v1beta1/{+projectName}/events",
       :uri-template-args {:projectName projectName},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-events-report
  "Report an individual error event and record the event to a log. This endpoint accepts **either** an OAuth token, **or** an [API key](https://support.google.com/cloud/answer/6158862) for authentication. To use an API key, append it to the URL as the value of a `key` parameter. For example: `POST https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456` **Note:** [Error Reporting] (https://cloud.google.com/error-reporting) is a global service built on Cloud Logging and can analyze log entries when all of the following are true: * The log entries are stored in a log bucket in the `global` location. * Customer-managed encryption keys (CMEK) are disabled on the log bucket. * The log bucket satisfies one of the following: * The log bucket is stored in the same project where the logs originated. * The logs were routed to a project, and then that project stored those logs in a log bucket that it owns.
https://cloud.google.com/error-reporting/reference/rest/v1beta1/projects/events/report

projectName <string> Required. The resource name of the Google Cloud Platform project. Written as `projects/{projectId}`, where `{projectId}` is the [Google Cloud Platform project ID](https://support.google.com/cloud/answer/6158840). Example: // `projects/my-project-123`.
ReportedErrorEvent:
{:eventTime string,
 :serviceContext
 {:service string, :version string, :resourceType string},
 :message string,
 :context
 {:httpRequest
  {:method string,
   :url string,
   :userAgent string,
   :referrer string,
   :responseStatusCode integer,
   :remoteIp string},
  :user string,
  :reportLocation
  {:filePath string, :lineNumber integer, :functionName string},
  :sourceReferences [{:repository string, :revisionId string}]}}"
  [projectName ReportedErrorEvent]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouderrorreporting.googleapis.com/v1beta1/{+projectName}/events:report",
     :uri-template-args {:projectName projectName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ReportedErrorEvent}))

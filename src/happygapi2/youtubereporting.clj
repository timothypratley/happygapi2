(ns happygapi2.youtubereporting
  "YouTube Reporting API
Schedules reporting jobs containing your YouTube Analytics data and downloads the resulting bulk data reports in the form of CSV files.
See: https://developers.google.com/youtube/reporting/v1/reports/"
  (:require [happy.oauth2.client :as client]))

(defn media-download
  "Method for media download. Download is supported on the URI `/v1/media/{+name}?alt=media`.
https://developers.google.com/youtube/reporting/v1/reports

resourceName <string> Name of the media that is being downloaded."
  [resourceName]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://youtubereporting.googleapis.com/v1/media/{+resourceName}",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
      "https://www.googleapis.com/auth/yt-analytics.readonly"]}))

(defn jobs-get
  "Gets a job.
https://developers.google.com/youtube/reporting/v1/reports

jobId <string> The ID of the job to retrieve.

optional:
onBehalfOfContentOwner <string> The content owner's external ID on which behalf the user is acting on. If not set, the user is acting for himself (his own channel)."
  ([jobId] (jobs-get jobId nil))
  ([jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtubereporting.googleapis.com/v1/jobs/{jobId}",
       :uri-template-args {:jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn jobs-delete
  "Deletes a job.
https://developers.google.com/youtube/reporting/v1/reports

jobId <string> The ID of the job to delete.

optional:
onBehalfOfContentOwner <string> The content owner's external ID on which behalf the user is acting on. If not set, the user is acting for himself (his own channel)."
  ([jobId] (jobs-delete jobId nil))
  ([jobId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://youtubereporting.googleapis.com/v1/jobs/{jobId}",
       :uri-template-args {:jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn jobs-create
  "Creates a job and returns it.
https://developers.google.com/youtube/reporting/v1/reports

Job:
{:expireTime string,
 :id string,
 :createTime string,
 :name string,
 :systemManaged boolean,
 :reportTypeId string}

optional:
onBehalfOfContentOwner <string> The content owner's external ID on which behalf the user is acting on. If not set, the user is acting for himself (his own channel)."
  ([Job] (jobs-create Job nil))
  ([Job optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://youtubereporting.googleapis.com/v1/jobs",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"],
       :body Job})))

(defn jobs-list
  "Lists jobs.
https://developers.google.com/youtube/reporting/v1/reports

optional:
onBehalfOfContentOwner <string> The content owner's external ID on which behalf the user is acting on. If not set, the user is acting for himself (his own channel).
includeSystemManaged <boolean> If set to true, also system-managed jobs will be returned; otherwise only user-created jobs will be returned. System-managed jobs can neither be modified nor deleted.
pageSize <integer> Requested page size. Server may return fewer jobs than requested. If unspecified, server will pick an appropriate default."
  ([] (jobs-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://youtubereporting.googleapis.com/v1/jobs",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn jobs-reports-get
  "Gets the metadata of a specific report.
https://developers.google.com/youtube/reporting/v1/reports

jobId <string> The ID of the job.
reportId <string> The ID of the report to retrieve.

optional:
onBehalfOfContentOwner <string> The content owner's external ID on which behalf the user is acting on. If not set, the user is acting for himself (his own channel)."
  ([jobId reportId] (jobs-reports-get jobId reportId nil))
  ([jobId reportId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtubereporting.googleapis.com/v1/jobs/{jobId}/reports/{reportId}",
       :uri-template-args {:reportId reportId, :jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn jobs-reports-list
  "Lists reports created by a specific job. Returns NOT_FOUND if the job does not exist.
https://developers.google.com/youtube/reporting/v1/reports

jobId <string> The ID of the job.

optional:
pageSize <integer> Requested page size. Server may return fewer report types than requested. If unspecified, server will pick an appropriate default.
startTimeBefore <string> If set, only reports whose start time is smaller than the specified date/time are returned.
createdAfter <string> If set, only reports created after the specified date/time are returned.
onBehalfOfContentOwner <string> The content owner's external ID on which behalf the user is acting on. If not set, the user is acting for himself (his own channel).
startTimeAtOrAfter <string> If set, only reports whose start time is greater than or equal the specified date/time are returned."
  ([jobId] (jobs-reports-list jobId nil))
  ([jobId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtubereporting.googleapis.com/v1/jobs/{jobId}/reports",
       :uri-template-args {:jobId jobId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(defn reportTypes-list
  "Lists report types.
https://developers.google.com/youtube/reporting/v1/reports

optional:
onBehalfOfContentOwner <string> The content owner's external ID on which behalf the user is acting on. If not set, the user is acting for himself (his own channel).
includeSystemManaged <boolean> If set to true, also system-managed report types will be returned; otherwise only the report types that can be used to create new reporting jobs will be returned.
pageSize <integer> Requested page size. Server may return fewer report types than requested. If unspecified, server will pick an appropriate default."
  ([] (reportTypes-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://youtubereporting.googleapis.com/v1/reportTypes",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
        "https://www.googleapis.com/auth/yt-analytics.readonly"]})))

(ns happygapi2.cloudscheduler
  "Cloud Scheduler API
Creates and manages jobs run on a regular recurring schedule.
See: https://cloud.google.com/scheduler/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudscheduler.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudscheduler.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-list
  "Lists jobs.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/list

parent <string> Required. The location name. For example: `projects/PROJECT_ID/locations/LOCATION_ID`.

optional:
pageSize <integer> Requested page size. The maximum page size is 500. If unspecified, the page size will be the maximum. Fewer jobs than requested might be returned, even if more jobs exist; use next_page_token to determine if more jobs exist."
  ([parent] (projects-locations-jobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudscheduler.googleapis.com/v1/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-get
  "Gets a job.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/get

name <string> Required. The job name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudscheduler.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-create
  "Creates a job.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/create

parent <string> Required. The location name. For example: `projects/PROJECT_ID/locations/LOCATION_ID`.
Job:
{:description string,
 :httpTarget
 {:uri string,
  :httpMethod
  [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
  :headers object,
  :body string,
  :oauthToken {:serviceAccountEmail string, :scope string},
  :oidcToken {:serviceAccountEmail string, :audience string}},
 :timeZone string,
 :schedule string,
 :userUpdateTime string,
 :name string,
 :scheduleTime string,
 :lastAttemptTime string,
 :state [STATE_UNSPECIFIED ENABLED PAUSED DISABLED UPDATE_FAILED],
 :attemptDeadline string,
 :status {:code integer, :message string, :details [object]},
 :retryConfig
 {:retryCount integer,
  :maxRetryDuration string,
  :minBackoffDuration string,
  :maxBackoffDuration string,
  :maxDoublings integer},
 :pubsubTarget {:topicName string, :data string, :attributes object},
 :appEngineHttpTarget
 {:httpMethod
  [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
  :appEngineRouting
  {:service string, :version string, :instance string, :host string},
  :relativeUri string,
  :headers object,
  :body string}}"
  [parent Job]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudscheduler.googleapis.com/v1/{+parent}/jobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Job}))

(defn projects-locations-jobs-patch
  "Updates a job. If successful, the updated Job is returned. If the job does not exist, `NOT_FOUND` is returned. If UpdateJob does not successfully return, it is possible for the job to be in an Job.State.UPDATE_FAILED state. A job in this state may not be executed. If this happens, retry the UpdateJob request until a successful response is received.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/patch

name <string> Optionally caller-specified in CreateJob, after which it becomes output only. The job name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`. * `PROJECT_ID` can contain letters ([A-Za-z]), numbers ([0-9]), hyphens (-), colons (:), or periods (.). For more information, see [Identifying projects](https://cloud.google.com/resource-manager/docs/creating-managing-projects#identifying_projects) * `LOCATION_ID` is the canonical ID for the job's location. The list of available locations can be obtained by calling ListLocations. For more information, see https://cloud.google.com/about/locations/. * `JOB_ID` can contain only letters ([A-Za-z]), numbers ([0-9]), hyphens (-), or underscores (_). The maximum length is 500 characters.
Job:
{:description string,
 :httpTarget
 {:uri string,
  :httpMethod
  [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
  :headers object,
  :body string,
  :oauthToken {:serviceAccountEmail string, :scope string},
  :oidcToken {:serviceAccountEmail string, :audience string}},
 :timeZone string,
 :schedule string,
 :userUpdateTime string,
 :name string,
 :scheduleTime string,
 :lastAttemptTime string,
 :state [STATE_UNSPECIFIED ENABLED PAUSED DISABLED UPDATE_FAILED],
 :attemptDeadline string,
 :status {:code integer, :message string, :details [object]},
 :retryConfig
 {:retryCount integer,
  :maxRetryDuration string,
  :minBackoffDuration string,
  :maxBackoffDuration string,
  :maxDoublings integer},
 :pubsubTarget {:topicName string, :data string, :attributes object},
 :appEngineHttpTarget
 {:httpMethod
  [HTTP_METHOD_UNSPECIFIED POST GET HEAD PUT DELETE PATCH OPTIONS],
  :appEngineRouting
  {:service string, :version string, :instance string, :host string},
  :relativeUri string,
  :headers object,
  :body string}}

optional:
updateMask <string> A mask used to specify which fields of the job are being updated."
  ([name Job] (projects-locations-jobs-patch name Job nil))
  ([name Job optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudscheduler.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Job})))

(defn projects-locations-jobs-delete
  "Deletes a job.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/delete

name <string> Required. The job name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudscheduler.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-pause
  "Pauses a job. If a job is paused then the system will stop executing the job until it is re-enabled via ResumeJob. The state of the job is stored in state; if paused it will be set to Job.State.PAUSED. A job must be in Job.State.ENABLED to be paused.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/pause

name <string> Required. The job name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
PauseJobRequest:
object"
  [name PauseJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudscheduler.googleapis.com/v1/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PauseJobRequest}))

(defn projects-locations-jobs-resume
  "Resume a job. This method reenables a job after it has been Job.State.PAUSED. The state of a job is stored in Job.state; after calling this method it will be set to Job.State.ENABLED. A job must be in Job.State.PAUSED to be resumed.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/resume

name <string> Required. The job name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
ResumeJobRequest:
object"
  [name ResumeJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudscheduler.googleapis.com/v1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResumeJobRequest}))

(defn projects-locations-jobs-run
  "Forces a job to run now. When this method is called, Cloud Scheduler will dispatch the job, even if the job is already running.
https://cloud.google.com/scheduler/docs/reference/rest/v1/projects.locations.jobs/run

name <string> Required. The job name. For example: `projects/PROJECT_ID/locations/LOCATION_ID/jobs/JOB_ID`.
RunJobRequest:
object"
  [name RunJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudscheduler.googleapis.com/v1/{+name}:run",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RunJobRequest}))

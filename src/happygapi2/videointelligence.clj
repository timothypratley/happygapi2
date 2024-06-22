(ns happygapi2.videointelligence
  "Cloud Video Intelligence API
Detects objects, explicit content, and scene changes in videos. It also specifies the region for annotation and transcribes speech to text. Supports both asynchronous API and streaming API.
See: https://cloud.google.com/video-intelligence/docs/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://videointelligence.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://videointelligence.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://videointelligence.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
GoogleLongrunning_CancelOperationRequest:
object"
  [name GoogleLongrunning_CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://videointelligence.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunning_CancelOperationRequest}))

(defn operations-projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/operations.projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://videointelligence.googleapis.com/v1/operations/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/operations.projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://videointelligence.googleapis.com/v1/operations/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/operations.projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://videointelligence.googleapis.com/v1/operations/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn videos-annotate
  "Performs asynchronous video annotation. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse` (results).
https://cloud.google.com/video-intelligence/docs/reference/rest/v1/videos/annotate

GoogleCloudVideointelligenceV1_AnnotateVideoRequest:
{:inputUri string,
 :inputContent string,
 :features
 [[FEATURE_UNSPECIFIED
   LABEL_DETECTION
   SHOT_CHANGE_DETECTION
   EXPLICIT_CONTENT_DETECTION
   FACE_DETECTION
   SPEECH_TRANSCRIPTION
   TEXT_DETECTION
   OBJECT_TRACKING
   LOGO_RECOGNITION
   PERSON_DETECTION]],
 :videoContext
 {:explicitContentDetectionConfig {:model string},
  :personDetectionConfig
  {:includeBoundingBoxes boolean,
   :includePoseLandmarks boolean,
   :includeAttributes boolean},
  :textDetectionConfig {:languageHints [string], :model string},
  :labelDetectionConfig
  {:labelDetectionMode
   [LABEL_DETECTION_MODE_UNSPECIFIED
    SHOT_MODE
    FRAME_MODE
    SHOT_AND_FRAME_MODE],
   :stationaryCamera boolean,
   :model string,
   :frameConfidenceThreshold number,
   :videoConfidenceThreshold number},
  :shotChangeDetectionConfig {:model string},
  :segments [{:startTimeOffset string, :endTimeOffset string}],
  :speechTranscriptionConfig
  {:diarizationSpeakerCount integer,
   :maxAlternatives integer,
   :enableAutomaticPunctuation boolean,
   :speechContexts [{:phrases [string]}],
   :enableSpeakerDiarization boolean,
   :audioTracks [integer],
   :languageCode string,
   :enableWordConfidence boolean,
   :filterProfanity boolean},
  :faceDetectionConfig
  {:model string,
   :includeBoundingBoxes boolean,
   :includeAttributes boolean},
  :objectTrackingConfig {:model string}},
 :outputUri string,
 :locationId string}"
  [GoogleCloudVideointelligenceV1_AnnotateVideoRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://videointelligence.googleapis.com/v1/videos:annotate",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudVideointelligenceV1_AnnotateVideoRequest}))

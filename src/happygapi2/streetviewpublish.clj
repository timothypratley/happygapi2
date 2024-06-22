(ns happygapi2.streetviewpublish
  "Street View Publish API
Publishes 360 photos to Google Maps, along with position, orientation, and connectivity metadata. Apps can offer an interface for positioning, connecting, and uploading user-generated Street View images. 
See: https://developers.google.com/streetview/publish/"
  (:require [happy.oauth2.client :as client]))

(defn photos-batchUpdate
  "Updates the metadata of Photos, such as pose, place association, connections, etc. Changing the pixels of photos is not supported. Note that if BatchUpdatePhotos fails, either critical fields are missing or there is an authentication error. Even if BatchUpdatePhotos succeeds, individual photos in the batch may have failures. These failures are specified in each PhotoResponse.status in BatchUpdatePhotosResponse.results. See UpdatePhoto for specific failures that can occur per photo. Only the fields specified in updateMask field are used. If `updateMask` is not present, the update applies to all fields. The number of UpdatePhotoRequest messages in a BatchUpdatePhotosRequest must not exceed 20. > Note: To update Pose.altitude, Pose.latLngPair has to be filled as well. Otherwise, the request will fail.
https://developers.google.com/streetview/publish/reference/rest/v1/photos/batchUpdate

BatchUpdatePhotosRequest:
{:updatePhotoRequests
 [{:updateMask string,
   :photo
   {:uploadTime string,
    :captureTime string,
    :thumbnailUrl string,
    :uploadReference {:uploadUrl string},
    :viewCount string,
    :transferStatus
    [TRANSFER_STATUS_UNKNOWN
     NEVER_TRANSFERRED
     PENDING
     COMPLETED
     REJECTED
     EXPIRED
     CANCELLED
     RECEIVED_VIA_TRANSFER],
    :pose
    {:accuracyMeters number,
     :latLngPair {:longitude number, :latitude number},
     :roll number,
     :gpsRecordTimestampUnixEpoch string,
     :heading number,
     :altitude number,
     :level {:number number, :name string},
     :pitch number},
    :shareLink string,
    :mapsPublishStatus
    [UNSPECIFIED_MAPS_PUBLISH_STATUS PUBLISHED REJECTED_UNKNOWN],
    :downloadUrl string,
    :connections [{:target {:id string}}],
    :places [{:placeId string, :languageCode string, :name string}],
    :photoId {:id string}}}]}"
  [BatchUpdatePhotosRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://streetviewpublish.googleapis.com/v1/photos:batchUpdate",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/streetviewpublish"],
     :body BatchUpdatePhotosRequest}))

(defn photos-batchGet
  "Gets the metadata of the specified Photo batch. Note that if BatchGetPhotos fails, either critical fields are missing or there is an authentication error. Even if BatchGetPhotos succeeds, individual photos in the batch may have failures. These failures are specified in each PhotoResponse.status in BatchGetPhotosResponse.results. See GetPhoto for specific failures that can occur per photo.
https://developers.google.com/streetview/publish/reference/rest/v1/photos/batchGet

optional:
languageCode <string> Optional. The BCP-47 language code, such as \"en-US\" or \"sr-Latn\". For more information, see http://www.unicode.org/reports/tr35/#Unicode_locale_identifier. If language_code is unspecified, the user's language preference for Google services is used.
view <string> Required. Specifies if a download URL for the photo bytes should be returned in the Photo response.
photoIds <string> Required. IDs of the Photos. For HTTP GET requests, the URL query parameter should be `photoIds=&photoIds=&...`."
  ([] (photos-batchGet nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://streetviewpublish.googleapis.com/v1/photos:batchGet",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/streetviewpublish"]})))

(defn photos-batchDelete
  "Deletes a list of Photos and their metadata. Note that if BatchDeletePhotos fails, either critical fields are missing or there is an authentication error. Even if BatchDeletePhotos succeeds, individual photos in the batch may have failures. These failures are specified in each PhotoResponse.status in BatchDeletePhotosResponse.results. See DeletePhoto for specific failures that can occur per photo.
https://developers.google.com/streetview/publish/reference/rest/v1/photos/batchDelete

BatchDeletePhotosRequest:
{:photoIds [string]}"
  [BatchDeletePhotosRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://streetviewpublish.googleapis.com/v1/photos:batchDelete",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/streetviewpublish"],
     :body BatchDeletePhotosRequest}))

(defn photos-list
  "Lists all the Photos that belong to the user. > Note: Recently created photos that are still being indexed are not returned in the response.
https://developers.google.com/streetview/publish/reference/rest/v1/photos/list

optional:
view <string> Required. Specifies if a download URL for the photos bytes should be returned in the Photos response.
pageSize <integer> Optional. The maximum number of photos to return. `pageSize` must be non-negative. If `pageSize` is zero or is not provided, the default page size of 100 is used. The number of photos returned in the response may be less than `pageSize` if the number of photos that belong to the user is less than `pageSize`.
filter <string> Optional. The filter expression. For example: `placeId=ChIJj61dQgK6j4AR4GeTYWZsKWw`. The filters supported are: `placeId`, `min_latitude`, `max_latitude`, `min_longitude`, `max_longitude`. See https://google.aip.dev/160 for more information.
languageCode <string> Optional. The BCP-47 language code, such as \"en-US\" or \"sr-Latn\". For more information, see http://www.unicode.org/reports/tr35/#Unicode_locale_identifier. If language_code is unspecified, the user's language preference for Google services is used."
  ([] (photos-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://streetviewpublish.googleapis.com/v1/photos",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/streetviewpublish"]})))

(defn photoSequences-list
  "Lists all the PhotoSequences that belong to the user, in descending CreatePhotoSequence timestamp order.
https://developers.google.com/streetview/publish/reference/rest/v1/photoSequences/list

optional:
pageSize <integer> Optional. The maximum number of photo sequences to return. `pageSize` must be non-negative. If `pageSize` is zero or is not provided, the default page size of 100 is used. The number of photo sequences returned in the response may be less than `pageSize` if the number of matches is less than `pageSize`. This is currently unimplemented but is in process.
filter <string> Optional. The filter expression. For example: `imagery_type=SPHERICAL`. The filters supported are: `imagery_type`, `processing_state`, `min_latitude`, `max_latitude`, `min_longitude`, `max_longitude`, `filename_query`, `min_capture_time_seconds`, `max_capture_time_seconds. See https://google.aip.dev/160 for more information. Filename queries should sent as a Phrase in order to support multiple words and special characters by adding escaped quotes. Ex: filename_query=\"example of a phrase.mp4\""
  ([] (photoSequences-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://streetviewpublish.googleapis.com/v1/photoSequences",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/streetviewpublish"]})))

(defn photoSequence-create
  "After the client finishes uploading the PhotoSequence with the returned UploadRef, CreatePhotoSequence extracts a sequence of 360 photos from a video or Extensible Device Metadata (XDM, http://www.xdm.org/) to be published to Street View on Google Maps. `CreatePhotoSequence` returns an Operation, with the PhotoSequence Id set in the `Operation.name` field. This method returns the following error codes: * google.rpc.Code.INVALID_ARGUMENT if the request is malformed. * google.rpc.Code.NOT_FOUND if the upload reference does not exist.
https://developers.google.com/streetview/publish/reference/rest/v1/photoSequence/create

PhotoSequence:
{:uploadTime string,
 :gpsSource [PHOTO_SEQUENCE CAMERA_MOTION_METADATA_TRACK],
 :imu
 {:accelMpsps [{:z number, :y number, :captureTime string, :x number}],
  :gyroRps [{:z number, :y number, :captureTime string, :x number}],
  :magUt [{:z number, :y number, :captureTime string, :x number}]},
 :distanceMeters number,
 :captureTimeOverride string,
 :rawGpsTimeline
 [{:accuracyMeters number,
   :latLngPair {:longitude number, :latitude number},
   :roll number,
   :gpsRecordTimestampUnixEpoch string,
   :heading number,
   :altitude number,
   :level {:number number, :name string},
   :pitch number}],
 :uploadReference {:uploadUrl string},
 :processingState
 [PROCESSING_STATE_UNSPECIFIED PENDING PROCESSING PROCESSED FAILED],
 :filename string,
 :photos
 [{:uploadTime string,
   :captureTime string,
   :thumbnailUrl string,
   :uploadReference {:uploadUrl string},
   :viewCount string,
   :transferStatus
   [TRANSFER_STATUS_UNKNOWN
    NEVER_TRANSFERRED
    PENDING
    COMPLETED
    REJECTED
    EXPIRED
    CANCELLED
    RECEIVED_VIA_TRANSFER],
   :pose
   {:accuracyMeters number,
    :latLngPair {:longitude number, :latitude number},
    :roll number,
    :gpsRecordTimestampUnixEpoch string,
    :heading number,
    :altitude number,
    :level {:number number, :name string},
    :pitch number},
   :shareLink string,
   :mapsPublishStatus
   [UNSPECIFIED_MAPS_PUBLISH_STATUS PUBLISHED REJECTED_UNKNOWN],
   :downloadUrl string,
   :connections [{:target {:id string}}],
   :places [{:placeId string, :languageCode string, :name string}],
   :photoId {:id string}}],
 :id string,
 :viewCount string,
 :failureDetails
 {:gpsDataGapDetails {:gapDuration string, :gapStartTime string},
  :imuDataGapDetails {:gapDuration string, :gapStartTime string},
  :notOutdoorsDetails {:startTime string},
  :insufficientGpsDetails {:gpsPointsFound integer},
  :noOverlapGpsDetails
  {:gpsStartTime string,
   :gpsEndTime string,
   :videoEndTime string,
   :videoStartTime string}},
 :sequenceBounds
 {:northeast {:longitude number, :latitude number},
  :southwest {:longitude number, :latitude number}},
 :failureReason
 [PROCESSING_FAILURE_REASON_UNSPECIFIED
  LOW_RESOLUTION
  DUPLICATE
  INSUFFICIENT_GPS
  NO_OVERLAP_GPS
  INVALID_GPS
  FAILED_TO_REFINE_POSITIONS
  TAKEDOWN
  CORRUPT_VIDEO
  INTERNAL
  INVALID_VIDEO_FORMAT
  INVALID_VIDEO_DIMENSIONS
  INVALID_CAPTURE_TIME
  GPS_DATA_GAP
  JUMPY_GPS
  INVALID_IMU
  INSUFFICIENT_IMU
  INSUFFICIENT_OVERLAP_TIME_SERIES
  IMU_DATA_GAP
  UNSUPPORTED_CAMERA
  NOT_OUTDOORS
  INSUFFICIENT_VIDEO_FRAMES
  INSUFFICIENT_MOVEMENT
  MAST_DOWN
  CAMERA_COVERED]}

optional:
inputType <string> Required. The input form of PhotoSequence."
  ([PhotoSequence] (photoSequence-create PhotoSequence nil))
  ([PhotoSequence optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://streetviewpublish.googleapis.com/v1/photoSequence",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/streetviewpublish"],
       :body PhotoSequence})))

(defn photoSequence-startUpload
  "Creates an upload session to start uploading photo sequence data. The upload URL of the returned UploadRef is used to upload the data for the `photoSequence`. After the upload is complete, the UploadRef is used with CreatePhotoSequence to create the PhotoSequence object entry.
https://developers.google.com/streetview/publish/reference/rest/v1/photoSequence/startUpload

Empty:
object"
  [Empty]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://streetviewpublish.googleapis.com/v1/photoSequence:startUpload",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/streetviewpublish"],
     :body Empty}))

(defn photoSequence-delete
  "Deletes a PhotoSequence and its metadata. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested photo sequence. * google.rpc.Code.NOT_FOUND if the photo sequence ID does not exist. * google.rpc.Code.FAILED_PRECONDITION if the photo sequence ID is not yet finished processing.
https://developers.google.com/streetview/publish/reference/rest/v1/photoSequence/delete

sequenceId <string> Required. ID of the PhotoSequence."
  [sequenceId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://streetviewpublish.googleapis.com/v1/photoSequence/{sequenceId}",
     :uri-template-args {:sequenceId sequenceId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/streetviewpublish"]}))

(defn photoSequence-get
  "Gets the metadata of the specified PhotoSequence via the Operation interface. This method returns the following three types of responses: * `Operation.done` = false, if the processing of PhotoSequence is not finished yet. * `Operation.done` = true and `Operation.error` is populated, if there was an error in processing. * `Operation.done` = true and `Operation.response` is poulated, which contains a PhotoSequence message. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested PhotoSequence. * google.rpc.Code.NOT_FOUND if the requested PhotoSequence does not exist.
https://developers.google.com/streetview/publish/reference/rest/v1/photoSequence/get

sequenceId <string> Required. ID of the photo sequence.

optional:
filter <string> Optional. The filter expression. For example: `published_status=PUBLISHED`. The filters supported are: `published_status`. See https://google.aip.dev/160 for more information.
view <string> Specifies if a download URL for the photo sequence should be returned in `download_url` of individual photos in the PhotoSequence response. > Note: Currently not implemented."
  ([sequenceId] (photoSequence-get sequenceId nil))
  ([sequenceId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://streetviewpublish.googleapis.com/v1/photoSequence/{sequenceId}",
       :uri-template-args {:sequenceId sequenceId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/streetviewpublish"]})))

(defn photo-create
  "After the client finishes uploading the photo with the returned UploadRef, CreatePhoto publishes the uploaded Photo to Street View on Google Maps. Currently, the only way to set heading, pitch, and roll in CreatePhoto is through the [Photo Sphere XMP metadata](https://developers.google.com/streetview/spherical-metadata) in the photo bytes. CreatePhoto ignores the `pose.heading`, `pose.pitch`, `pose.roll`, `pose.altitude`, and `pose.level` fields in Pose. This method returns the following error codes: * google.rpc.Code.INVALID_ARGUMENT if the request is malformed or if the uploaded photo is not a 360 photo. * google.rpc.Code.NOT_FOUND if the upload reference does not exist. * google.rpc.Code.RESOURCE_EXHAUSTED if the account has reached the storage limit.
https://developers.google.com/streetview/publish/reference/rest/v1/photo/create

Photo:
{:uploadTime string,
 :captureTime string,
 :thumbnailUrl string,
 :uploadReference {:uploadUrl string},
 :viewCount string,
 :transferStatus
 [TRANSFER_STATUS_UNKNOWN
  NEVER_TRANSFERRED
  PENDING
  COMPLETED
  REJECTED
  EXPIRED
  CANCELLED
  RECEIVED_VIA_TRANSFER],
 :pose
 {:accuracyMeters number,
  :latLngPair {:longitude number, :latitude number},
  :roll number,
  :gpsRecordTimestampUnixEpoch string,
  :heading number,
  :altitude number,
  :level {:number number, :name string},
  :pitch number},
 :shareLink string,
 :mapsPublishStatus
 [UNSPECIFIED_MAPS_PUBLISH_STATUS PUBLISHED REJECTED_UNKNOWN],
 :downloadUrl string,
 :connections [{:target {:id string}}],
 :places [{:placeId string, :languageCode string, :name string}],
 :photoId {:id string}}"
  [Photo]
  (client/api-request
    {:method "POST",
     :uri-template "https://streetviewpublish.googleapis.com/v1/photo",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/streetviewpublish"],
     :body Photo}))

(defn photo-startUpload
  "Creates an upload session to start uploading photo bytes. The method uses the upload URL of the returned UploadRef to upload the bytes for the Photo. In addition to the photo requirements shown in https://support.google.com/maps/answer/7012050?ref_topic=6275604, the photo must meet the following requirements: * Photo Sphere XMP metadata must be included in the photo metadata. See https://developers.google.com/streetview/spherical-metadata for the required fields. * The pixel size of the photo must meet the size requirements listed in https://support.google.com/maps/answer/7012050?ref_topic=6275604, and the photo must be a full 360 horizontally. After the upload completes, the method uses UploadRef with CreatePhoto to create the Photo object entry.
https://developers.google.com/streetview/publish/reference/rest/v1/photo/startUpload

Empty:
object"
  [Empty]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://streetviewpublish.googleapis.com/v1/photo:startUpload",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/streetviewpublish"],
     :body Empty}))

(defn photo-update
  "Updates the metadata of a Photo, such as pose, place association, connections, etc. Changing the pixels of a photo is not supported. Only the fields specified in the updateMask field are used. If `updateMask` is not present, the update applies to all fields. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested photo. * google.rpc.Code.INVALID_ARGUMENT if the request is malformed. * google.rpc.Code.NOT_FOUND if the requested photo does not exist. * google.rpc.Code.UNAVAILABLE if the requested Photo is still being indexed.
https://developers.google.com/streetview/publish/reference/rest/v1/photo/update

id <string> A unique identifier for a photo.
Photo:
{:uploadTime string,
 :captureTime string,
 :thumbnailUrl string,
 :uploadReference {:uploadUrl string},
 :viewCount string,
 :transferStatus
 [TRANSFER_STATUS_UNKNOWN
  NEVER_TRANSFERRED
  PENDING
  COMPLETED
  REJECTED
  EXPIRED
  CANCELLED
  RECEIVED_VIA_TRANSFER],
 :pose
 {:accuracyMeters number,
  :latLngPair {:longitude number, :latitude number},
  :roll number,
  :gpsRecordTimestampUnixEpoch string,
  :heading number,
  :altitude number,
  :level {:number number, :name string},
  :pitch number},
 :shareLink string,
 :mapsPublishStatus
 [UNSPECIFIED_MAPS_PUBLISH_STATUS PUBLISHED REJECTED_UNKNOWN],
 :downloadUrl string,
 :connections [{:target {:id string}}],
 :places [{:placeId string, :languageCode string, :name string}],
 :photoId {:id string}}

optional:
updateMask <string> Required. Mask that identifies fields on the photo metadata to update. If not present, the old Photo metadata is entirely replaced with the new Photo metadata in this request. The update fails if invalid fields are specified. Multiple fields can be specified in a comma-delimited list. The following fields are valid: * `pose.heading` * `pose.lat_lng_pair` * `pose.pitch` * `pose.roll` * `pose.level` * `pose.altitude` * `connections` * `places` > Note: When updateMask contains repeated fields, the entire set of repeated values get replaced with the new contents. For example, if updateMask contains `connections` and `UpdatePhotoRequest.photo.connections` is empty, all connections are removed."
  ([id Photo] (photo-update id Photo nil))
  ([id Photo optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://streetviewpublish.googleapis.com/v1/photo/{id}",
       :uri-template-args {:id id},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/streetviewpublish"],
       :body Photo})))

(defn photo-get
  "Gets the metadata of the specified Photo. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested Photo. * google.rpc.Code.NOT_FOUND if the requested Photo does not exist. * google.rpc.Code.UNAVAILABLE if the requested Photo is still being indexed.
https://developers.google.com/streetview/publish/reference/rest/v1/photo/get

photoId <string> Required. ID of the Photo.

optional:
languageCode <string> The BCP-47 language code, such as \"en-US\" or \"sr-Latn\". For more information, see http://www.unicode.org/reports/tr35/#Unicode_locale_identifier. If language_code is unspecified, the user's language preference for Google services is used.
view <string> Required. Specifies if a download URL for the photo bytes should be returned in the Photo response."
  ([photoId] (photo-get photoId nil))
  ([photoId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://streetviewpublish.googleapis.com/v1/photo/{photoId}",
       :uri-template-args {:photoId photoId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/streetviewpublish"]})))

(defn photo-delete
  "Deletes a Photo and its metadata. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested photo. * google.rpc.Code.NOT_FOUND if the photo ID does not exist.
https://developers.google.com/streetview/publish/reference/rest/v1/photo/delete

photoId <string> Required. ID of the Photo."
  [photoId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://streetviewpublish.googleapis.com/v1/photo/{photoId}",
     :uri-template-args {:photoId photoId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/streetviewpublish"]}))

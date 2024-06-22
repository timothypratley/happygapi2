(ns happygapi2.speech
  "Cloud Speech-to-Text API
Converts audio to text by applying powerful neural network models.
See: https://cloud.google.com/speech-to-text/docs/transcribe-api"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-phraseSets-create
  "Create a set of phrase hints. Each item in the set can be a single word or a multi-word phrase. The items in the PhraseSet are favored by the recognition model when you send a call that includes the PhraseSet.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.phraseSets/create

parent <string> Required. The parent resource where this phrase set will be created. Format: `projects/{project}/locations/{location}` Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu` (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global` location. To specify a region, use a [regional endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or `eu` location value.
CreatePhraseSetRequest:
{:phraseSetId string,
 :phraseSet
 {:boost number,
  :deleteTime string,
  :kmsKeyVersionName string,
  :displayName string,
  :uid string,
  :name string,
  :etag string,
  :state [STATE_UNSPECIFIED ACTIVE DELETED],
  :phrases [{:value string, :boost number}],
  :reconciling boolean,
  :kmsKeyName string,
  :annotations object,
  :expireTime string}}"
  [parent CreatePhraseSetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://speech.googleapis.com/v1/{+parent}/phraseSets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreatePhraseSetRequest}))

(defn projects-locations-phraseSets-get
  "Get a phrase set.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.phraseSets/get

name <string> Required. The name of the phrase set to retrieve. Format: `projects/{project}/locations/{location}/phraseSets/{phrase_set}` Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu` (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global` location. To specify a region, use a [regional endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or `eu` location value."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://speech.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-phraseSets-list
  "List phrase sets.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.phraseSets/list

parent <string> Required. The parent, which owns this collection of phrase set. Format: `projects/{project}/locations/{location}` Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu` (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global` location. To specify a region, use a [regional endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or `eu` location value.

optional:
pageSize <integer> The maximum number of phrase sets to return. The service may return fewer than this value. If unspecified, at most 50 phrase sets will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-phraseSets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://speech.googleapis.com/v1/{+parent}/phraseSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-phraseSets-patch
  "Update a phrase set.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.phraseSets/patch

name <string> The resource name of the phrase set.
PhraseSet:
{:boost number,
 :deleteTime string,
 :kmsKeyVersionName string,
 :displayName string,
 :uid string,
 :name string,
 :etag string,
 :state [STATE_UNSPECIFIED ACTIVE DELETED],
 :phrases [{:value string, :boost number}],
 :reconciling boolean,
 :kmsKeyName string,
 :annotations object,
 :expireTime string}

optional:
updateMask <string> The list of fields to be updated."
  ([name PhraseSet]
    (projects-locations-phraseSets-patch name PhraseSet nil))
  ([name PhraseSet optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://speech.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PhraseSet})))

(defn projects-locations-phraseSets-delete
  "Delete a phrase set.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.phraseSets/delete

name <string> Required. The name of the phrase set to delete. Format: `projects/{project}/locations/{location}/phraseSets/{phrase_set}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://speech.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-customClasses-create
  "Create a custom class.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.customClasses/create

parent <string> Required. The parent resource where this custom class will be created. Format: `projects/{project}/locations/{location}/customClasses` Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu` (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global` location. To specify a region, use a [regional endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or `eu` location value.
CreateCustomClassRequest:
{:customClassId string,
 :customClass
 {:deleteTime string,
  :kmsKeyVersionName string,
  :displayName string,
  :uid string,
  :name string,
  :etag string,
  :state [STATE_UNSPECIFIED ACTIVE DELETED],
  :customClassId string,
  :reconciling boolean,
  :kmsKeyName string,
  :annotations object,
  :expireTime string,
  :items [{:value string}]}}"
  [parent CreateCustomClassRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://speech.googleapis.com/v1/{+parent}/customClasses",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CreateCustomClassRequest}))

(defn projects-locations-customClasses-get
  "Get a custom class.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.customClasses/get

name <string> Required. The name of the custom class to retrieve. Format: `projects/{project}/locations/{location}/customClasses/{custom_class}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://speech.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-customClasses-list
  "List custom classes.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.customClasses/list

parent <string> Required. The parent, which owns this collection of custom classes. Format: `projects/{project}/locations/{location}/customClasses` Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu` (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global` location. To specify a region, use a [regional endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or `eu` location value.

optional:
pageSize <integer> The maximum number of custom classes to return. The service may return fewer than this value. If unspecified, at most 50 custom classes will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-customClasses-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://speech.googleapis.com/v1/{+parent}/customClasses",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-customClasses-patch
  "Update a custom class.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.customClasses/patch

name <string> The resource name of the custom class.
CustomClass:
{:deleteTime string,
 :kmsKeyVersionName string,
 :displayName string,
 :uid string,
 :name string,
 :etag string,
 :state [STATE_UNSPECIFIED ACTIVE DELETED],
 :customClassId string,
 :reconciling boolean,
 :kmsKeyName string,
 :annotations object,
 :expireTime string,
 :items [{:value string}]}

optional:
updateMask <string> The list of fields to be updated."
  ([name CustomClass]
    (projects-locations-customClasses-patch name CustomClass nil))
  ([name CustomClass optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://speech.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CustomClass})))

(defn projects-locations-customClasses-delete
  "Delete a custom class.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/projects.locations.customClasses/delete

name <string> Required. The name of the custom class to delete. Format: `projects/{project}/locations/{location}/customClasses/{custom_class}` Speech-to-Text supports three locations: `global`, `us` (US North America), and `eu` (Europe). If you are calling the `speech.googleapis.com` endpoint, use the `global` location. To specify a region, use a [regional endpoint](https://cloud.google.com/speech-to-text/docs/endpoints) with matching `us` or `eu` location value."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://speech.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/operations/list

optional:
name <string> The name of the operation's parent resource.
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([] (operations-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://speech.googleapis.com/v1/operations",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://speech.googleapis.com/v1/operations/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn speech-recognize
  "Performs synchronous speech recognition: receive results after all audio has been sent and processed.
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/speech/recognize

RecognizeRequest:
{:config
 {:encoding
  [ENCODING_UNSPECIFIED
   LINEAR16
   FLAC
   MULAW
   AMR
   AMR_WB
   OGG_OPUS
   SPEEX_WITH_HEADER_BYTE
   MP3
   WEBM_OPUS],
  :maxAlternatives integer,
  :enableAutomaticPunctuation boolean,
  :enableSpokenPunctuation boolean,
  :enableWordTimeOffsets boolean,
  :alternativeLanguageCodes [string],
  :enableSeparateRecognitionPerChannel boolean,
  :adaptation
  {:phraseSets
   [{:boost number,
     :deleteTime string,
     :kmsKeyVersionName string,
     :displayName string,
     :uid string,
     :name string,
     :etag string,
     :state [STATE_UNSPECIFIED ACTIVE DELETED],
     :phrases [{:value string, :boost number}],
     :reconciling boolean,
     :kmsKeyName string,
     :annotations object,
     :expireTime string}],
   :phraseSetReferences [string],
   :customClasses
   [{:deleteTime string,
     :kmsKeyVersionName string,
     :displayName string,
     :uid string,
     :name string,
     :etag string,
     :state [STATE_UNSPECIFIED ACTIVE DELETED],
     :customClassId string,
     :reconciling boolean,
     :kmsKeyName string,
     :annotations object,
     :expireTime string,
     :items [{:value string}]}],
   :abnfGrammar {:abnfStrings [string]}},
  :speechContexts [{:phrases [string], :boost number}],
  :enableSpokenEmojis boolean,
  :sampleRateHertz integer,
  :transcriptNormalization
  {:entries
   [{:search string, :replace string, :caseSensitive boolean}]},
  :languageCode string,
  :profanityFilter boolean,
  :enableWordConfidence boolean,
  :audioChannelCount integer,
  :metadata
  {:interactionType
   [INTERACTION_TYPE_UNSPECIFIED
    DISCUSSION
    PRESENTATION
    PHONE_CALL
    VOICEMAIL
    PROFESSIONALLY_PRODUCED
    VOICE_SEARCH
    VOICE_COMMAND
    DICTATION],
   :industryNaicsCodeOfAudio integer,
   :microphoneDistance
   [MICROPHONE_DISTANCE_UNSPECIFIED NEARFIELD MIDFIELD FARFIELD],
   :originalMediaType [ORIGINAL_MEDIA_TYPE_UNSPECIFIED AUDIO VIDEO],
   :recordingDeviceType
   [RECORDING_DEVICE_TYPE_UNSPECIFIED
    SMARTPHONE
    PC
    PHONE_LINE
    VEHICLE
    OTHER_OUTDOOR_DEVICE
    OTHER_INDOOR_DEVICE],
   :recordingDeviceName string,
   :originalMimeType string,
   :audioTopic string},
  :useEnhanced boolean,
  :diarizationConfig
  {:enableSpeakerDiarization boolean,
   :minSpeakerCount integer,
   :maxSpeakerCount integer,
   :speakerTag integer},
  :model string},
 :audio {:content string, :uri string}}"
  [RecognizeRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://speech.googleapis.com/v1/speech:recognize",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RecognizeRequest}))

(defn speech-longrunningrecognize
  "Performs asynchronous speech recognition: receive results via the google.longrunning.Operations interface. Returns either an `Operation.error` or an `Operation.response` which contains a `LongRunningRecognizeResponse` message. For more information on asynchronous speech recognition, see the [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize).
https://cloud.google.com/speech-to-text/docs/reference/rest/v1/speech/longrunningrecognize

LongRunningRecognizeRequest:
{:config
 {:encoding
  [ENCODING_UNSPECIFIED
   LINEAR16
   FLAC
   MULAW
   AMR
   AMR_WB
   OGG_OPUS
   SPEEX_WITH_HEADER_BYTE
   MP3
   WEBM_OPUS],
  :maxAlternatives integer,
  :enableAutomaticPunctuation boolean,
  :enableSpokenPunctuation boolean,
  :enableWordTimeOffsets boolean,
  :alternativeLanguageCodes [string],
  :enableSeparateRecognitionPerChannel boolean,
  :adaptation
  {:phraseSets
   [{:boost number,
     :deleteTime string,
     :kmsKeyVersionName string,
     :displayName string,
     :uid string,
     :name string,
     :etag string,
     :state [STATE_UNSPECIFIED ACTIVE DELETED],
     :phrases [{:value string, :boost number}],
     :reconciling boolean,
     :kmsKeyName string,
     :annotations object,
     :expireTime string}],
   :phraseSetReferences [string],
   :customClasses
   [{:deleteTime string,
     :kmsKeyVersionName string,
     :displayName string,
     :uid string,
     :name string,
     :etag string,
     :state [STATE_UNSPECIFIED ACTIVE DELETED],
     :customClassId string,
     :reconciling boolean,
     :kmsKeyName string,
     :annotations object,
     :expireTime string,
     :items [{:value string}]}],
   :abnfGrammar {:abnfStrings [string]}},
  :speechContexts [{:phrases [string], :boost number}],
  :enableSpokenEmojis boolean,
  :sampleRateHertz integer,
  :transcriptNormalization
  {:entries
   [{:search string, :replace string, :caseSensitive boolean}]},
  :languageCode string,
  :profanityFilter boolean,
  :enableWordConfidence boolean,
  :audioChannelCount integer,
  :metadata
  {:interactionType
   [INTERACTION_TYPE_UNSPECIFIED
    DISCUSSION
    PRESENTATION
    PHONE_CALL
    VOICEMAIL
    PROFESSIONALLY_PRODUCED
    VOICE_SEARCH
    VOICE_COMMAND
    DICTATION],
   :industryNaicsCodeOfAudio integer,
   :microphoneDistance
   [MICROPHONE_DISTANCE_UNSPECIFIED NEARFIELD MIDFIELD FARFIELD],
   :originalMediaType [ORIGINAL_MEDIA_TYPE_UNSPECIFIED AUDIO VIDEO],
   :recordingDeviceType
   [RECORDING_DEVICE_TYPE_UNSPECIFIED
    SMARTPHONE
    PC
    PHONE_LINE
    VEHICLE
    OTHER_OUTDOOR_DEVICE
    OTHER_INDOOR_DEVICE],
   :recordingDeviceName string,
   :originalMimeType string,
   :audioTopic string},
  :useEnhanced boolean,
  :diarizationConfig
  {:enableSpeakerDiarization boolean,
   :minSpeakerCount integer,
   :maxSpeakerCount integer,
   :speakerTag integer},
  :model string},
 :audio {:content string, :uri string},
 :outputConfig {:gcsUri string}}"
  [LongRunningRecognizeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://speech.googleapis.com/v1/speech:longrunningrecognize",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body LongRunningRecognizeRequest}))

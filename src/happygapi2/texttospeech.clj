(ns happygapi2.texttospeech
  "Cloud Text-to-Speech API
Synthesizes natural-sounding speech by applying powerful neural network models.
See: https://cloud.google.com/text-to-speech/"
  (:require [happy.oauth2.client :as client]))

(defn voices-list
  "Returns a list of Voice supported for synthesis.
https://cloud.google.com/text-to-speech/docs/reference/rest/v1/voices/list

optional:
languageCode <string> Optional. Recommended. [BCP-47](https://www.rfc-editor.org/rfc/bcp/bcp47.txt) language tag. If not specified, the API will return all supported voices. If specified, the ListVoices call will only return voices that can be used to synthesize this language_code. For example, if you specify `\"en-NZ\"`, all `\"en-NZ\"` voices will be returned. If you specify `\"no\"`, both `\"no-\\*\"` (Norwegian) and `\"nb-\\*\"` (Norwegian Bokmal) voices will be returned."
  ([] (voices-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://texttospeech.googleapis.com/v1/voices",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn text-synthesize
  "Synthesizes speech synchronously: receive results after all text input has been processed.
https://cloud.google.com/text-to-speech/docs/reference/rest/v1/text/synthesize

SynthesizeSpeechRequest:
{:input {:text string, :ssml string},
 :voice
 {:languageCode string,
  :name string,
  :ssmlGender [SSML_VOICE_GENDER_UNSPECIFIED MALE FEMALE NEUTRAL],
  :customVoice
  {:model string,
   :reportedUsage [REPORTED_USAGE_UNSPECIFIED REALTIME OFFLINE]}},
 :audioConfig
 {:audioEncoding
  [AUDIO_ENCODING_UNSPECIFIED LINEAR16 MP3 OGG_OPUS MULAW ALAW],
  :speakingRate number,
  :pitch number,
  :volumeGainDb number,
  :sampleRateHertz integer,
  :effectsProfileId [string]}}"
  [SynthesizeSpeechRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://texttospeech.googleapis.com/v1/text:synthesize",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SynthesizeSpeechRequest}))

(defn projects-locations-synthesizeLongAudio
  "Synthesizes long form text asynchronously.
https://cloud.google.com/text-to-speech/docs/reference/rest/v1/projects.locations/synthesizeLongAudio

parent <string> The resource states of the request in the form of `projects/*/locations/*`.
SynthesizeLongAudioRequest:
{:input {:text string, :ssml string},
 :audioConfig
 {:audioEncoding
  [AUDIO_ENCODING_UNSPECIFIED LINEAR16 MP3 OGG_OPUS MULAW ALAW],
  :speakingRate number,
  :pitch number,
  :volumeGainDb number,
  :sampleRateHertz integer,
  :effectsProfileId [string]},
 :outputGcsUri string,
 :voice
 {:languageCode string,
  :name string,
  :ssmlGender [SSML_VOICE_GENDER_UNSPECIFIED MALE FEMALE NEUTRAL],
  :customVoice
  {:model string,
   :reportedUsage [REPORTED_USAGE_UNSPECIFIED REALTIME OFFLINE]}}}"
  [parent SynthesizeLongAudioRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://texttospeech.googleapis.com/v1/{+parent}:synthesizeLongAudio",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SynthesizeLongAudioRequest}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/text-to-speech/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://texttospeech.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/text-to-speech/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://texttospeech.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/text-to-speech/docs/reference/rest/v1/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://texttospeech.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/text-to-speech/docs/reference/rest/v1/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://texttospeech.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

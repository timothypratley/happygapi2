(ns happygapi2.meet
  "Google Meet API
Create and manage meetings in Google Meet.
See: https://developers.google.com/meet/api/guides/overview"
  (:require [happy.oauth2.client :as client]))

(defn conferenceRecords-list
  "Lists the conference records. By default, ordered by start time and in descending order.
https://developers.google.com/meet/api/guides/overview

optional:
filter <string> Optional. User specified filtering condition in [EBNF format](https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_form). The following are the filterable fields: * `space.meeting_code` * `space.name` * `start_time` * `end_time` For example, `space.meeting_code = \"abc-mnop-xyz\"`.
pageSize <integer> Optional. Maximum number of conference records to return. The service might return fewer than this value. If unspecified, at most 25 conference records are returned. The maximum value is 100; values above 100 are coerced to 100. Maximum might change in the future."
  ([] (conferenceRecords-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://meet.googleapis.com/v2/conferenceRecords",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/meetings.space.created"
        "https://www.googleapis.com/auth/meetings.space.readonly"]})))

(defn conferenceRecords-get
  "Gets a conference record by conference ID.
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the conference."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://meet.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"
      "https://www.googleapis.com/auth/meetings.space.readonly"]}))

(defn conferenceRecords-recordings-list
  "Lists the recording resources from the conference record. By default, ordered by start time and in ascending order.
https://developers.google.com/meet/api/guides/overview

parent <string> Required. Format: `conferenceRecords/{conference_record}`

optional:
pageSize <integer> Maximum number of recordings to return. The service might return fewer than this value. If unspecified, at most 10 recordings are returned. The maximum value is 100; values above 100 are coerced to 100. Maximum might change in the future."
  ([parent] (conferenceRecords-recordings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://meet.googleapis.com/v2/{+parent}/recordings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/meetings.space.created"
        "https://www.googleapis.com/auth/meetings.space.readonly"]})))

(defn conferenceRecords-recordings-get
  "Gets a recording by recording ID.
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the recording."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://meet.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"
      "https://www.googleapis.com/auth/meetings.space.readonly"]}))

(defn conferenceRecords-transcripts-list
  "Lists the set of transcripts from the conference record. By default, ordered by start time and in ascending order.
https://developers.google.com/meet/api/guides/overview

parent <string> Required. Format: `conferenceRecords/{conference_record}`

optional:
pageSize <integer> Maximum number of transcripts to return. The service might return fewer than this value. If unspecified, at most 10 transcripts are returned. The maximum value is 100; values above 100 are coerced to 100. Maximum might change in the future."
  ([parent] (conferenceRecords-transcripts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://meet.googleapis.com/v2/{+parent}/transcripts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/meetings.space.created"
        "https://www.googleapis.com/auth/meetings.space.readonly"]})))

(defn conferenceRecords-transcripts-get
  "Gets a transcript by transcript ID.
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the transcript."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://meet.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"
      "https://www.googleapis.com/auth/meetings.space.readonly"]}))

(defn conferenceRecords-transcripts-entries-list
  "Lists the structured transcript entries per transcript. By default, ordered by start time and in ascending order. Note: The transcript entries returned by the Google Meet API might not match the transcription found in the Google Docs transcript file. This can occur when the Google Docs transcript file is modified after generation.
https://developers.google.com/meet/api/guides/overview

parent <string> Required. Format: `conferenceRecords/{conference_record}/transcripts/{transcript}`

optional:
pageSize <integer> Maximum number of entries to return. The service might return fewer than this value. If unspecified, at most 10 entries are returned. The maximum value is 100; values above 100 are coerced to 100. Maximum might change in the future."
  ([parent] (conferenceRecords-transcripts-entries-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://meet.googleapis.com/v2/{+parent}/entries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/meetings.space.created"
        "https://www.googleapis.com/auth/meetings.space.readonly"]})))

(defn conferenceRecords-transcripts-entries-get
  "Gets a `TranscriptEntry` resource by entry ID. Note: The transcript entries returned by the Google Meet API might not match the transcription found in the Google Docs transcript file. This can occur when the Google Docs transcript file is modified after generation.
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the `TranscriptEntry`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://meet.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"
      "https://www.googleapis.com/auth/meetings.space.readonly"]}))

(defn conferenceRecords-participants-list
  "Lists the participants in a conference record. By default, ordered by join time and in descending order. This API supports `fields` as standard parameters like every other API. However, when the `fields` request parameter is omitted, this API defaults to `'participants/*, next_page_token'`.
https://developers.google.com/meet/api/guides/overview

parent <string> Required. Format: `conferenceRecords/{conference_record}`

optional:
pageSize <integer> Maximum number of participants to return. The service might return fewer than this value. If unspecified, at most 100 participants are returned. The maximum value is 250; values above 250 are coerced to 250. Maximum might change in the future.
filter <string> Optional. User specified filtering condition in [EBNF format](https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_form). The following are the filterable fields: * `earliest_start_time` * `latest_end_time` For example, `latest_end_time IS NULL` returns active participants in the conference."
  ([parent] (conferenceRecords-participants-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://meet.googleapis.com/v2/{+parent}/participants",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/meetings.space.created"
        "https://www.googleapis.com/auth/meetings.space.readonly"]})))

(defn conferenceRecords-participants-get
  "Gets a participant by participant ID.
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the participant."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://meet.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"
      "https://www.googleapis.com/auth/meetings.space.readonly"]}))

(defn conferenceRecords-participants-participantSessions-list
  "Lists the participant sessions of a participant in a conference record. By default, ordered by join time and in descending order. This API supports `fields` as standard parameters like every other API. However, when the `fields` request parameter is omitted this API defaults to `'participantsessions/*, next_page_token'`.
https://developers.google.com/meet/api/guides/overview

parent <string> Required. Format: `conferenceRecords/{conference_record}/participants/{participant}`

optional:
filter <string> Optional. User specified filtering condition in [EBNF format](https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_form). The following are the filterable fields: * `start_time` * `end_time` For example, `end_time IS NULL` returns active participant sessions in the conference record.
pageSize <integer> Optional. Maximum number of participant sessions to return. The service might return fewer than this value. If unspecified, at most 100 participants are returned. The maximum value is 250; values above 250 are coerced to 250. Maximum might change in the future."
  ([parent]
    (conferenceRecords-participants-participantSessions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://meet.googleapis.com/v2/{+parent}/participantSessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/meetings.space.created"
        "https://www.googleapis.com/auth/meetings.space.readonly"]})))

(defn conferenceRecords-participants-participantSessions-get
  "Gets a participant session by participant session ID.
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the participant."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://meet.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"
      "https://www.googleapis.com/auth/meetings.space.readonly"]}))

(defn spaces-create
  "Creates a space.
https://developers.google.com/meet/api/guides/overview

Space:
{:config
 {:entryPointAccess
  [ENTRY_POINT_ACCESS_UNSPECIFIED ALL CREATOR_APP_ONLY],
  :accessType [ACCESS_TYPE_UNSPECIFIED OPEN TRUSTED RESTRICTED]},
 :name string,
 :meetingUri string,
 :activeConference {:conferenceRecord string},
 :meetingCode string}"
  [Space]
  (client/api-request
    {:method "POST",
     :uri-template "https://meet.googleapis.com/v2/spaces",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"],
     :body Space}))

(defn spaces-patch
  "Updates a space.
https://developers.google.com/meet/api/guides/overview

name <string> Immutable. Resource name of the space. Format: `spaces/{space}`
Space:
{:config
 {:entryPointAccess
  [ENTRY_POINT_ACCESS_UNSPECIFIED ALL CREATOR_APP_ONLY],
  :accessType [ACCESS_TYPE_UNSPECIFIED OPEN TRUSTED RESTRICTED]},
 :name string,
 :meetingUri string,
 :activeConference {:conferenceRecord string},
 :meetingCode string}

optional:
updateMask <string> Optional. Field mask used to specify the fields to be updated in the space. If update_mask isn't provided, it defaults to '*' and updates all fields provided in the request, including deleting fields not set in the request."
  ([name Space] (spaces-patch name Space nil))
  ([name Space optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://meet.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/meetings.space.created"],
       :body Space})))

(defn spaces-endActiveConference
  "Ends an active conference (if there's one).
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the space.
EndActiveConferenceRequest:
object"
  [name EndActiveConferenceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://meet.googleapis.com/v2/{+name}:endActiveConference",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"],
     :body EndActiveConferenceRequest}))

(defn spaces-get
  "Gets a space by `space_id` or `meeting_code`.
https://developers.google.com/meet/api/guides/overview

name <string> Required. Resource name of the space."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://meet.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/meetings.space.created"
      "https://www.googleapis.com/auth/meetings.space.readonly"]}))

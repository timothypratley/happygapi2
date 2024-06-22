(ns happygapi2.forms
  "Google Forms API
Reads and writes Google Forms and responses.
See: https://developers.google.com/forms/api/guides"
  (:require [happy.oauth2.client :as client]))

(defn forms-create
  "Create a new form using the title given in the provided form message in the request. *Important:* Only the form.info.title and form.info.document_title fields are copied to the new form. All other fields including the form description, items and settings are disallowed. To create a new form and add items, you must first call forms.create to create an empty form with a title and (optional) document title, and then call forms.update to add the items.
https://developers.google.com/forms/api/reference/rest/v1/forms/create

Form:
{:formId string,
 :info {:title string, :documentTitle string, :description string},
 :settings {:quizSettings {:isQuiz boolean}},
 :items
 [{:description string,
   :imageItem
   {:image
    {:sourceUri string,
     :contentUri string,
     :altText string,
     :properties
     {:alignment [ALIGNMENT_UNSPECIFIED LEFT RIGHT CENTER],
      :width integer}}},
   :pageBreakItem object,
   :questionItem
   {:question
    {:fileUploadQuestion
     {:folderId string,
      :types
      [[FILE_TYPE_UNSPECIFIED
        ANY
        DOCUMENT
        PRESENTATION
        SPREADSHEET
        DRAWING
        PDF
        IMAGE
        VIDEO
        AUDIO]],
      :maxFiles integer,
      :maxFileSize string},
     :choiceQuestion
     {:type [CHOICE_TYPE_UNSPECIFIED RADIO CHECKBOX DROP_DOWN],
      :options [Option],
      :shuffle boolean},
     :timeQuestion {:duration boolean},
     :rowQuestion {:title string},
     :scaleQuestion
     {:low integer,
      :high integer,
      :lowLabel string,
      :highLabel string},
     :textQuestion {:paragraph boolean},
     :questionId string,
     :grading
     {:pointValue integer,
      :correctAnswers CorrectAnswers,
      :whenRight Feedback,
      :whenWrong Feedback,
      :generalFeedback Feedback},
     :required boolean,
     :dateQuestion {:includeTime boolean, :includeYear boolean}},
    :image
    {:sourceUri string,
     :contentUri string,
     :altText string,
     :properties
     {:alignment [ALIGNMENT_UNSPECIFIED LEFT RIGHT CENTER],
      :width integer}}},
   :title string,
   :textItem object,
   :questionGroupItem
   {:grid
    {:columns
     {:type [CHOICE_TYPE_UNSPECIFIED RADIO CHECKBOX DROP_DOWN],
      :options [Option],
      :shuffle boolean},
     :shuffleQuestions boolean},
    :questions
    [{:fileUploadQuestion
      {:folderId string,
       :types
       [[FILE_TYPE_UNSPECIFIED
         ANY
         DOCUMENT
         PRESENTATION
         SPREADSHEET
         DRAWING
         PDF
         IMAGE
         VIDEO
         AUDIO]],
       :maxFiles integer,
       :maxFileSize string},
      :choiceQuestion
      {:type [CHOICE_TYPE_UNSPECIFIED RADIO CHECKBOX DROP_DOWN],
       :options [Option],
       :shuffle boolean},
      :timeQuestion {:duration boolean},
      :rowQuestion {:title string},
      :scaleQuestion
      {:low integer,
       :high integer,
       :lowLabel string,
       :highLabel string},
      :textQuestion {:paragraph boolean},
      :questionId string,
      :grading
      {:pointValue integer,
       :correctAnswers CorrectAnswers,
       :whenRight Feedback,
       :whenWrong Feedback,
       :generalFeedback Feedback},
      :required boolean,
      :dateQuestion {:includeTime boolean, :includeYear boolean}}],
    :image
    {:sourceUri string,
     :contentUri string,
     :altText string,
     :properties
     {:alignment [ALIGNMENT_UNSPECIFIED LEFT RIGHT CENTER],
      :width integer}}},
   :videoItem
   {:video
    {:youtubeUri string,
     :properties
     {:alignment [ALIGNMENT_UNSPECIFIED LEFT RIGHT CENTER],
      :width integer}},
    :caption string},
   :itemId string}],
 :revisionId string,
 :responderUri string,
 :linkedSheetId string}"
  [Form]
  (client/api-request
    {:method "POST",
     :uri-template "https://forms.googleapis.com/v1/forms",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/forms.body"],
     :body Form}))

(defn forms-get
  "Get a form.
https://developers.google.com/forms/api/reference/rest/v1/forms/get

formId <string> Required. The form ID."
  [formId]
  (client/api-request
    {:method "GET",
     :uri-template "https://forms.googleapis.com/v1/forms/{formId}",
     :uri-template-args {:formId formId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/forms.body"
      "https://www.googleapis.com/auth/forms.body.readonly"]}))

(defn forms-batchUpdate
  "Change the form with a batch of updates.
https://developers.google.com/forms/api/reference/rest/v1/forms/batchUpdate

formId <string> Required. The form ID.
BatchUpdateFormRequest:
{:includeFormInResponse boolean,
 :requests
 [{:updateFormInfo
   {:info {:title string, :documentTitle string, :description string},
    :updateMask string},
   :updateSettings
   {:settings {:quizSettings {:isQuiz boolean}}, :updateMask string},
   :createItem
   {:item
    {:description string,
     :imageItem {:image Image},
     :pageBreakItem object,
     :questionItem {:question Question, :image Image},
     :title string,
     :textItem object,
     :questionGroupItem
     {:grid Grid, :questions [Question], :image Image},
     :videoItem {:video Video, :caption string},
     :itemId string},
    :location {:index integer}},
   :moveItem
   {:originalLocation {:index integer}, :newLocation {:index integer}},
   :deleteItem {:location {:index integer}},
   :updateItem
   {:item
    {:description string,
     :imageItem {:image Image},
     :pageBreakItem object,
     :questionItem {:question Question, :image Image},
     :title string,
     :textItem object,
     :questionGroupItem
     {:grid Grid, :questions [Question], :image Image},
     :videoItem {:video Video, :caption string},
     :itemId string},
    :location {:index integer},
    :updateMask string}}],
 :writeControl {:requiredRevisionId string, :targetRevisionId string}}"
  [formId BatchUpdateFormRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://forms.googleapis.com/v1/forms/{formId}:batchUpdate",
     :uri-template-args {:formId formId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/forms.body"],
     :body BatchUpdateFormRequest}))

(defn forms-responses-get
  "Get one response from the form.
https://developers.google.com/forms/api/reference/rest/v1/forms.responses/get

formId <string> Required. The form ID.
responseId <string> Required. The response ID within the form."
  [formId responseId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://forms.googleapis.com/v1/forms/{formId}/responses/{responseId}",
     :uri-template-args {:formId formId, :responseId responseId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/forms.responses.readonly"]}))

(defn forms-responses-list
  "List a form's responses.
https://developers.google.com/forms/api/reference/rest/v1/forms.responses/list

formId <string> Required. ID of the Form whose responses to list.

optional:
filter <string> Which form responses to return. Currently, the only supported filters are: * timestamp > *N* which means to get all form responses submitted after (but not at) timestamp *N*. * timestamp >= *N* which means to get all form responses submitted at and after timestamp *N*. For both supported filters, timestamp must be formatted in RFC3339 UTC \"Zulu\" format. Examples: \"2014-10-02T15:01:23Z\" and \"2014-10-02T15:01:23.045123456Z\".
pageSize <integer> The maximum number of responses to return. The service may return fewer than this value. If unspecified or zero, at most 5000 responses are returned."
  ([formId] (forms-responses-list formId nil))
  ([formId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://forms.googleapis.com/v1/forms/{formId}/responses",
       :uri-template-args {:formId formId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/forms.responses.readonly"]})))

(defn forms-watches-create
  "Create a new watch. If a watch ID is provided, it must be unused. For each invoking project, the per form limit is one watch per Watch.EventType. A watch expires seven days after it is created (see Watch.expire_time).
https://developers.google.com/forms/api/reference/rest/v1/forms.watches/create

formId <string> Required. ID of the Form to watch.
CreateWatchRequest:
{:watch
 {:id string,
  :target {:topic {:topicName string}},
  :eventType [EVENT_TYPE_UNSPECIFIED SCHEMA RESPONSES],
  :createTime string,
  :expireTime string,
  :errorType
  [ERROR_TYPE_UNSPECIFIED
   PROJECT_NOT_AUTHORIZED
   NO_USER_ACCESS
   OTHER_ERRORS],
  :state [STATE_UNSPECIFIED ACTIVE SUSPENDED]},
 :watchId string}"
  [formId CreateWatchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://forms.googleapis.com/v1/forms/{formId}/watches",
     :uri-template-args {:formId formId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/forms.body"
      "https://www.googleapis.com/auth/forms.body.readonly"
      "https://www.googleapis.com/auth/forms.responses.readonly"],
     :body CreateWatchRequest}))

(defn forms-watches-list
  "Return a list of the watches owned by the invoking project. The maximum number of watches is two: For each invoker, the limit is one for each event type per form.
https://developers.google.com/forms/api/reference/rest/v1/forms.watches/list

formId <string> Required. ID of the Form whose watches to list."
  [formId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://forms.googleapis.com/v1/forms/{formId}/watches",
     :uri-template-args {:formId formId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/forms.body"
      "https://www.googleapis.com/auth/forms.body.readonly"
      "https://www.googleapis.com/auth/forms.responses.readonly"]}))

(defn forms-watches-renew
  "Renew an existing watch for seven days. The state of the watch after renewal is `ACTIVE`, and the `expire_time` is seven days from the renewal. Renewing a watch in an error state (e.g. `SUSPENDED`) succeeds if the error is no longer present, but fail otherwise. After a watch has expired, RenewWatch returns `NOT_FOUND`.
https://developers.google.com/forms/api/reference/rest/v1/forms.watches/renew

formId <string> Required. The ID of the Form.
watchId <string> Required. The ID of the Watch to renew.
RenewWatchRequest:
object"
  [formId watchId RenewWatchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://forms.googleapis.com/v1/forms/{formId}/watches/{watchId}:renew",
     :uri-template-args {:formId formId, :watchId watchId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/forms.body"
      "https://www.googleapis.com/auth/forms.body.readonly"
      "https://www.googleapis.com/auth/forms.responses.readonly"],
     :body RenewWatchRequest}))

(defn forms-watches-delete
  "Delete a watch.
https://developers.google.com/forms/api/reference/rest/v1/forms.watches/delete

formId <string> Required. The ID of the Form.
watchId <string> Required. The ID of the Watch to delete."
  [formId watchId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://forms.googleapis.com/v1/forms/{formId}/watches/{watchId}",
     :uri-template-args {:formId formId, :watchId watchId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/forms.body"
      "https://www.googleapis.com/auth/forms.body.readonly"
      "https://www.googleapis.com/auth/forms.responses.readonly"]}))

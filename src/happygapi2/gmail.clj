(ns happygapi2.gmail
  "Gmail API
The Gmail API lets you view and manage Gmail mailbox data like threads, messages, and labels.
See: https://developers.google.com/gmail/api/guides"
  (:require [happy.oauth2.client :as client]))

(defn users-getProfile
  "Gets the current user's Gmail profile.
https://developers.google.com/gmail/api/reference/rest/v1/users/getProfile

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/profile",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.compose"
      "https://www.googleapis.com/auth/gmail.metadata"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"]}))

(defn users-watch
  "Set up or update a push notification watch on the given user mailbox.
https://developers.google.com/gmail/api/reference/rest/v1/users/watch

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
WatchRequest:
{:labelIds [string],
 :labelFilterAction [include exclude],
 :labelFilterBehavior [include exclude],
 :topicName string}"
  [userId WatchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/watch",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.metadata"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"],
     :body WatchRequest}))

(defn users-stop
  "Stop receiving push notifications for the given user mailbox.
https://developers.google.com/gmail/api/reference/rest/v1/users/stop

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/stop",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.metadata"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"]}))

(defn users-drafts-delete
  "Immediately and permanently deletes the specified draft. Does not simply trash it.
https://developers.google.com/gmail/api/reference/rest/v1/users.drafts/delete

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the draft to delete."
  [userId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/drafts/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
      "https://www.googleapis.com/auth/gmail.compose"
      "https://www.googleapis.com/auth/gmail.modify"]}))

(defn users-drafts-create
  "Creates a new draft with the `DRAFT` label.
https://developers.google.com/gmail/api/reference/rest/v1/users.drafts/create

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
Draft:
{:id string,
 :message
 {:threadId string,
  :payload
  {:partId string,
   :mimeType string,
   :filename string,
   :headers [{:name string, :value string}],
   :body {:attachmentId string, :size integer, :data string},
   :parts
   [{:partId string,
     :mimeType string,
     :filename string,
     :headers [{:name string, :value string}],
     :body {:attachmentId string, :size integer, :data string},
     :parts
     [{:partId string,
       :mimeType string,
       :filename string,
       :headers [MessagePartHeader],
       :body MessagePartBody,
       :parts [MessagePart]}]}]},
  :historyId string,
  :raw string,
  :labelIds [string],
  :snippet string,
  :id string,
  :sizeEstimate integer,
  :internalDate string}}"
  [userId Draft]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/drafts",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
      "https://www.googleapis.com/auth/gmail.compose"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body Draft}))

(defn users-drafts-get
  "Gets the specified draft.
https://developers.google.com/gmail/api/reference/rest/v1/users.drafts/get

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the draft to retrieve.

optional:
format <string> The format to return the draft in."
  ([userId id] (users-drafts-get userId id nil))
  ([userId id optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/drafts/{id}",
       :uri-template-args {:userId userId, :id id},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.compose"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"]})))

(defn users-drafts-list
  "Lists the drafts in the user's mailbox.
https://developers.google.com/gmail/api/reference/rest/v1/users.drafts/list

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.

optional:
maxResults <integer> Maximum number of drafts to return. This field defaults to 100. The maximum allowed value for this field is 500.
q <string> Only return draft messages matching the specified query. Supports the same query format as the Gmail search box. For example, `\"from:someuser@example.com rfc822msgid: is:unread\"`.
includeSpamTrash <boolean> Include drafts from `SPAM` and `TRASH` in the results."
  ([userId] (users-drafts-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/drafts",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.compose"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"]})))

(defn users-drafts-send
  "Sends the specified, existing draft to the recipients in the `To`, `Cc`, and `Bcc` headers.
https://developers.google.com/gmail/api/reference/rest/v1/users.drafts/send

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
Draft:
{:id string,
 :message
 {:threadId string,
  :payload
  {:partId string,
   :mimeType string,
   :filename string,
   :headers [{:name string, :value string}],
   :body {:attachmentId string, :size integer, :data string},
   :parts
   [{:partId string,
     :mimeType string,
     :filename string,
     :headers [{:name string, :value string}],
     :body {:attachmentId string, :size integer, :data string},
     :parts
     [{:partId string,
       :mimeType string,
       :filename string,
       :headers [MessagePartHeader],
       :body MessagePartBody,
       :parts [MessagePart]}]}]},
  :historyId string,
  :raw string,
  :labelIds [string],
  :snippet string,
  :id string,
  :sizeEstimate integer,
  :internalDate string}}"
  [userId Draft]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/drafts/send",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
      "https://www.googleapis.com/auth/gmail.compose"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body Draft}))

(defn users-drafts-update
  "Replaces a draft's content.
https://developers.google.com/gmail/api/reference/rest/v1/users.drafts/update

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the draft to update.
Draft:
{:id string,
 :message
 {:threadId string,
  :payload
  {:partId string,
   :mimeType string,
   :filename string,
   :headers [{:name string, :value string}],
   :body {:attachmentId string, :size integer, :data string},
   :parts
   [{:partId string,
     :mimeType string,
     :filename string,
     :headers [{:name string, :value string}],
     :body {:attachmentId string, :size integer, :data string},
     :parts
     [{:partId string,
       :mimeType string,
       :filename string,
       :headers [MessagePartHeader],
       :body MessagePartBody,
       :parts [MessagePart]}]}]},
  :historyId string,
  :raw string,
  :labelIds [string],
  :snippet string,
  :id string,
  :sizeEstimate integer,
  :internalDate string}}"
  [userId id Draft]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/drafts/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
      "https://www.googleapis.com/auth/gmail.compose"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body Draft}))

(defn users-history-list
  "Lists the history of all changes to the given mailbox. History results are returned in chronological order (increasing `historyId`).
https://developers.google.com/gmail/api/reference/rest/v1/users.history/list

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.

optional:
maxResults <integer> Maximum number of history records to return. This field defaults to 100. The maximum allowed value for this field is 500.
startHistoryId <string> Required. Returns history records after the specified `startHistoryId`. The supplied `startHistoryId` should be obtained from the `historyId` of a message, thread, or previous `list` response. History IDs increase chronologically but are not contiguous with random gaps in between valid IDs. Supplying an invalid or out of date `startHistoryId` typically returns an `HTTP 404` error code. A `historyId` is typically valid for at least a week, but in some rare circumstances may be valid for only a few hours. If you receive an `HTTP 404` error response, your application should perform a full sync. If you receive no `nextPageToken` in the response, there are no updates to retrieve and you can store the returned `historyId` for a future request.
labelId <string> Only return messages with a label matching the ID.
historyTypes <string> History types to be returned by the function"
  ([userId] (users-history-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/history",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.metadata"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"]})))

(defn users-messages-get
  "Gets the specified message.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/get

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the message to retrieve. This ID is usually retrieved using `messages.list`. The ID is also contained in the result when a message is inserted (`messages.insert`) or imported (`messages.import`).

optional:
format <string> The format to return the message in.
metadataHeaders <string> When given and format is `METADATA`, only include headers specified."
  ([userId id] (users-messages-get userId id nil))
  ([userId id optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/{id}",
       :uri-template-args {:userId userId, :id id},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.addons.current.message.action"
        "https://www.googleapis.com/auth/gmail.addons.current.message.metadata"
        "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
        "https://www.googleapis.com/auth/gmail.metadata"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"]})))

(defn users-messages-insert
  "Directly inserts a message into only this user's mailbox similar to `IMAP APPEND`, bypassing most scanning and classification. Does not send a message.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/insert

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
Message:
{:threadId string,
 :payload
 {:partId string,
  :mimeType string,
  :filename string,
  :headers [{:name string, :value string}],
  :body {:attachmentId string, :size integer, :data string},
  :parts
  [{:partId string,
    :mimeType string,
    :filename string,
    :headers [{:name string, :value string}],
    :body {:attachmentId string, :size integer, :data string},
    :parts
    [{:partId string,
      :mimeType string,
      :filename string,
      :headers [{:name string, :value string}],
      :body {:attachmentId string, :size integer, :data string},
      :parts
      [{:partId string,
        :mimeType string,
        :filename string,
        :headers [MessagePartHeader],
        :body MessagePartBody,
        :parts [MessagePart]}]}]}]},
 :historyId string,
 :raw string,
 :labelIds [string],
 :snippet string,
 :id string,
 :sizeEstimate integer,
 :internalDate string}

optional:
internalDateSource <string> Source for Gmail's internal date of the message.
deleted <boolean> Mark the email as permanently deleted (not TRASH) and only visible in Google Vault to a Vault administrator. Only used for Google Workspace accounts."
  ([userId Message] (users-messages-insert userId Message nil))
  ([userId Message optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.insert"
        "https://www.googleapis.com/auth/gmail.modify"],
       :body Message})))

(defn users-messages-untrash
  "Removes the specified message from the trash.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/untrash

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the message to remove from Trash."
  [userId id]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/{id}/untrash",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"]}))

(defn users-messages-delete
  "Immediately and permanently deletes the specified message. This operation cannot be undone. Prefer `messages.trash` instead.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/delete

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the message to delete."
  [userId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes ["https://mail.google.com/"]}))

(defn users-messages-batchDelete
  "Deletes many messages by message ID. Provides no guarantees that messages were not already deleted or even existed at all.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/batchDelete

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
BatchDeleteMessagesRequest:
{:ids [string]}"
  [userId BatchDeleteMessagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/batchDelete",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes ["https://mail.google.com/"],
     :body BatchDeleteMessagesRequest}))

(defn users-messages-batchModify
  "Modifies the labels on the specified messages.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/batchModify

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
BatchModifyMessagesRequest:
{:ids [string], :addLabelIds [string], :removeLabelIds [string]}"
  [userId BatchModifyMessagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/batchModify",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body BatchModifyMessagesRequest}))

(defn users-messages-list
  "Lists the messages in the user's mailbox.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/list

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.

optional:
maxResults <integer> Maximum number of messages to return. This field defaults to 100. The maximum allowed value for this field is 500.
q <string> Only return messages matching the specified query. Supports the same query format as the Gmail search box. For example, `\"from:someuser@example.com rfc822msgid: is:unread\"`. Parameter cannot be used when accessing the api using the gmail.metadata scope.
labelIds <string> Only return messages with labels that match all of the specified label IDs. Messages in a thread might have labels that other messages in the same thread don't have. To learn more, see [Manage labels on messages and threads](https://developers.google.com/gmail/api/guides/labels#manage_labels_on_messages_threads).
includeSpamTrash <boolean> Include messages from `SPAM` and `TRASH` in the results."
  ([userId] (users-messages-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.metadata"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"]})))

(defn users-messages-send
  "Sends the specified message to the recipients in the `To`, `Cc`, and `Bcc` headers. For example usage, see [Sending email](https://developers.google.com/gmail/api/guides/sending).
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/send

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
Message:
{:threadId string,
 :payload
 {:partId string,
  :mimeType string,
  :filename string,
  :headers [{:name string, :value string}],
  :body {:attachmentId string, :size integer, :data string},
  :parts
  [{:partId string,
    :mimeType string,
    :filename string,
    :headers [{:name string, :value string}],
    :body {:attachmentId string, :size integer, :data string},
    :parts
    [{:partId string,
      :mimeType string,
      :filename string,
      :headers [{:name string, :value string}],
      :body {:attachmentId string, :size integer, :data string},
      :parts
      [{:partId string,
        :mimeType string,
        :filename string,
        :headers [MessagePartHeader],
        :body MessagePartBody,
        :parts [MessagePart]}]}]}]},
 :historyId string,
 :raw string,
 :labelIds [string],
 :snippet string,
 :id string,
 :sizeEstimate integer,
 :internalDate string}"
  [userId Message]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/send",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.addons.current.action.compose"
      "https://www.googleapis.com/auth/gmail.compose"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.send"],
     :body Message}))

(defn users-messages-import
  "Imports a message into only this user's mailbox, with standard email delivery scanning and classification similar to receiving via SMTP. This method doesn't perform SPF checks, so it might not work for some spam messages, such as those attempting to perform domain spoofing. This method does not send a message.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/import

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
Message:
{:threadId string,
 :payload
 {:partId string,
  :mimeType string,
  :filename string,
  :headers [{:name string, :value string}],
  :body {:attachmentId string, :size integer, :data string},
  :parts
  [{:partId string,
    :mimeType string,
    :filename string,
    :headers [{:name string, :value string}],
    :body {:attachmentId string, :size integer, :data string},
    :parts
    [{:partId string,
      :mimeType string,
      :filename string,
      :headers [{:name string, :value string}],
      :body {:attachmentId string, :size integer, :data string},
      :parts
      [{:partId string,
        :mimeType string,
        :filename string,
        :headers [MessagePartHeader],
        :body MessagePartBody,
        :parts [MessagePart]}]}]}]},
 :historyId string,
 :raw string,
 :labelIds [string],
 :snippet string,
 :id string,
 :sizeEstimate integer,
 :internalDate string}

optional:
internalDateSource <string> Source for Gmail's internal date of the message.
neverMarkSpam <boolean> Ignore the Gmail spam classifier decision and never mark this email as SPAM in the mailbox.
processForCalendar <boolean> Process calendar invites in the email and add any extracted meetings to the Google Calendar for this user.
deleted <boolean> Mark the email as permanently deleted (not TRASH) and only visible in Google Vault to a Vault administrator. Only used for Google Workspace accounts."
  ([userId Message] (users-messages-import userId Message nil))
  ([userId Message optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/import",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.insert"
        "https://www.googleapis.com/auth/gmail.modify"],
       :body Message})))

(defn users-messages-modify
  "Modifies the labels on the specified message.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/modify

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the message to modify.
ModifyMessageRequest:
{:addLabelIds [string], :removeLabelIds [string]}"
  [userId id ModifyMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/{id}/modify",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body ModifyMessageRequest}))

(defn users-messages-trash
  "Moves the specified message to the trash.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages/trash

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the message to Trash."
  [userId id]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/{id}/trash",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"]}))

(defn users-messages-attachments-get
  "Gets the specified message attachment.
https://developers.google.com/gmail/api/reference/rest/v1/users.messages.attachments/get

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
messageId <string> The ID of the message containing the attachment.
id <string> The ID of the attachment."
  [userId messageId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/messages/{messageId}/attachments/{id}",
     :uri-template-args {:userId userId, :messageId messageId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.addons.current.message.action"
      "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"]}))

(defn users-labels-create
  "Creates a new label.
https://developers.google.com/gmail/api/reference/rest/v1/users.labels/create

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
Label:
{:threadsUnread integer,
 :threadsTotal integer,
 :messagesTotal integer,
 :labelListVisibility [labelShow labelShowIfUnread labelHide],
 :color {:textColor string, :backgroundColor string},
 :messagesUnread integer,
 :name string,
 :messageListVisibility [show hide],
 :type [system user],
 :id string}"
  [userId Label]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/labels",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.labels"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body Label}))

(defn users-labels-delete
  "Immediately and permanently deletes the specified label and removes it from any messages and threads that it is applied to.
https://developers.google.com/gmail/api/reference/rest/v1/users.labels/delete

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the label to delete."
  [userId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/labels/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.labels"
      "https://www.googleapis.com/auth/gmail.modify"]}))

(defn users-labels-get
  "Gets the specified label.
https://developers.google.com/gmail/api/reference/rest/v1/users.labels/get

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the label to retrieve."
  [userId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/labels/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.labels"
      "https://www.googleapis.com/auth/gmail.metadata"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"]}))

(defn users-labels-list
  "Lists all labels in the user's mailbox.
https://developers.google.com/gmail/api/reference/rest/v1/users.labels/list

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/labels",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.labels"
      "https://www.googleapis.com/auth/gmail.metadata"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"]}))

(defn users-labels-update
  "Updates the specified label.
https://developers.google.com/gmail/api/reference/rest/v1/users.labels/update

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the label to update.
Label:
{:threadsUnread integer,
 :threadsTotal integer,
 :messagesTotal integer,
 :labelListVisibility [labelShow labelShowIfUnread labelHide],
 :color {:textColor string, :backgroundColor string},
 :messagesUnread integer,
 :name string,
 :messageListVisibility [show hide],
 :type [system user],
 :id string}"
  [userId id Label]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/labels/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.labels"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body Label}))

(defn users-labels-patch
  "Patch the specified label.
https://developers.google.com/gmail/api/reference/rest/v1/users.labels/patch

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the label to update.
Label:
{:threadsUnread integer,
 :threadsTotal integer,
 :messagesTotal integer,
 :labelListVisibility [labelShow labelShowIfUnread labelHide],
 :color {:textColor string, :backgroundColor string},
 :messagesUnread integer,
 :name string,
 :messageListVisibility [show hide],
 :type [system user],
 :id string}"
  [userId id Label]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/labels/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.labels"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body Label}))

(defn users-threads-trash
  "Moves the specified thread to the trash. Any messages that belong to the thread are also moved to the trash.
https://developers.google.com/gmail/api/reference/rest/v1/users.threads/trash

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the thread to Trash."
  [userId id]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/threads/{id}/trash",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"]}))

(defn users-threads-untrash
  "Removes the specified thread from the trash. Any messages that belong to the thread are also removed from the trash.
https://developers.google.com/gmail/api/reference/rest/v1/users.threads/untrash

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the thread to remove from Trash."
  [userId id]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/threads/{id}/untrash",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"]}))

(defn users-threads-delete
  "Immediately and permanently deletes the specified thread. Any messages that belong to the thread are also deleted. This operation cannot be undone. Prefer `threads.trash` instead.
https://developers.google.com/gmail/api/reference/rest/v1/users.threads/delete

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> ID of the Thread to delete."
  [userId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/threads/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes ["https://mail.google.com/"]}))

(defn users-threads-get
  "Gets the specified thread.
https://developers.google.com/gmail/api/reference/rest/v1/users.threads/get

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the thread to retrieve.

optional:
format <string> The format to return the messages in.
metadataHeaders <string> When given and format is METADATA, only include headers specified."
  ([userId id] (users-threads-get userId id nil))
  ([userId id optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/threads/{id}",
       :uri-template-args {:userId userId, :id id},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.addons.current.message.action"
        "https://www.googleapis.com/auth/gmail.addons.current.message.metadata"
        "https://www.googleapis.com/auth/gmail.addons.current.message.readonly"
        "https://www.googleapis.com/auth/gmail.metadata"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"]})))

(defn users-threads-list
  "Lists the threads in the user's mailbox.
https://developers.google.com/gmail/api/reference/rest/v1/users.threads/list

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.

optional:
maxResults <integer> Maximum number of threads to return. This field defaults to 100. The maximum allowed value for this field is 500.
q <string> Only return threads matching the specified query. Supports the same query format as the Gmail search box. For example, `\"from:someuser@example.com rfc822msgid: is:unread\"`. Parameter cannot be used when accessing the api using the gmail.metadata scope.
labelIds <string> Only return threads with labels that match all of the specified label IDs.
includeSpamTrash <boolean> Include threads from `SPAM` and `TRASH` in the results."
  ([userId] (users-threads-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/threads",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.metadata"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"]})))

(defn users-threads-modify
  "Modifies the labels applied to the thread. This applies to all messages in the thread.
https://developers.google.com/gmail/api/reference/rest/v1/users.threads/modify

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
id <string> The ID of the thread to modify.
ModifyThreadRequest:
{:addLabelIds [string], :removeLabelIds [string]}"
  [userId id ModifyThreadRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/threads/{id}/modify",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"],
     :body ModifyThreadRequest}))

(defn users-settings-getLanguage
  "Gets language settings.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/getLanguage

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/language",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-updateImap
  "Updates IMAP settings.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/updateImap

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
ImapSettings:
{:enabled boolean,
 :autoExpunge boolean,
 :expungeBehavior
 [expungeBehaviorUnspecified archive trash deleteForever],
 :maxFolderSize integer}"
  [userId ImapSettings]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/imap",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/gmail.settings.basic"],
     :body ImapSettings}))

(defn users-settings-getVacation
  "Gets vacation responder settings.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/getVacation

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/vacation",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-getAutoForwarding
  "Gets the auto-forwarding setting for the specified account.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/getAutoForwarding

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/autoForwarding",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-updateAutoForwarding
  "Updates the auto-forwarding setting for the specified account. A verified forwarding address must be specified when auto-forwarding is enabled. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/updateAutoForwarding

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
AutoForwarding:
{:enabled boolean,
 :emailAddress string,
 :disposition
 [dispositionUnspecified leaveInInbox archive trash markRead]}"
  [userId AutoForwarding]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/autoForwarding",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body AutoForwarding}))

(defn users-settings-updateVacation
  "Updates vacation responder settings.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/updateVacation

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
VacationSettings:
{:enableAutoReply boolean,
 :responseSubject string,
 :responseBodyPlainText string,
 :responseBodyHtml string,
 :restrictToContacts boolean,
 :restrictToDomain boolean,
 :startTime string,
 :endTime string}"
  [userId VacationSettings]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/vacation",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/gmail.settings.basic"],
     :body VacationSettings}))

(defn users-settings-updateLanguage
  "Updates language settings. If successful, the return object contains the `displayLanguage` that was saved for the user, which may differ from the value passed into the request. This is because the requested `displayLanguage` may not be directly supported by Gmail but have a close variant that is, and so the variant may be chosen and saved instead.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/updateLanguage

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
LanguageSettings:
{:displayLanguage string}"
  [userId LanguageSettings]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/language",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/gmail.settings.basic"],
     :body LanguageSettings}))

(defn users-settings-getImap
  "Gets IMAP settings.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/getImap

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/imap",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-getPop
  "Gets POP settings.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/getPop

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/pop",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-updatePop
  "Updates POP settings.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings/updatePop

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
PopSettings:
{:accessWindow [accessWindowUnspecified disabled fromNowOn allMail],
 :disposition
 [dispositionUnspecified leaveInInbox archive trash markRead]}"
  [userId PopSettings]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/pop",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/gmail.settings.basic"],
     :body PopSettings}))

(defn users-settings-sendAs-list
  "Lists the send-as aliases for the specified account. The result includes the primary send-as address associated with the account as well as any custom \"from\" aliases.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs/list

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-sendAs-get
  "Gets the specified send-as alias. Fails with an HTTP 404 error if the specified address is not a member of the collection.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs/get

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
sendAsEmail <string> The send-as alias to be retrieved."
  [userId sendAsEmail]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}",
     :uri-template-args {:userId userId, :sendAsEmail sendAsEmail},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-sendAs-create
  "Creates a custom \"from\" send-as alias. If an SMTP MSA is specified, Gmail will attempt to connect to the SMTP service to validate the configuration before creating the alias. If ownership verification is required for the alias, a message will be sent to the email address and the resource's verification status will be set to `pending`; otherwise, the resource will be created with verification status set to `accepted`. If a signature is provided, Gmail will sanitize the HTML before saving it with the alias. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs/create

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
SendAs:
{:treatAsAlias boolean,
 :isDefault boolean,
 :displayName string,
 :isPrimary boolean,
 :signature string,
 :sendAsEmail string,
 :verificationStatus [verificationStatusUnspecified accepted pending],
 :replyToAddress string,
 :smtpMsa
 {:host string,
  :port integer,
  :username string,
  :password string,
  :securityMode [securityModeUnspecified none ssl starttls]}}"
  [userId SendAs]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body SendAs}))

(defn users-settings-sendAs-update
  "Updates a send-as alias. If a signature is provided, Gmail will sanitize the HTML before saving it with the alias. Addresses other than the primary address for the account can only be updated by service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs/update

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
sendAsEmail <string> The send-as alias to be updated.
SendAs:
{:treatAsAlias boolean,
 :isDefault boolean,
 :displayName string,
 :isPrimary boolean,
 :signature string,
 :sendAsEmail string,
 :verificationStatus [verificationStatusUnspecified accepted pending],
 :replyToAddress string,
 :smtpMsa
 {:host string,
  :port integer,
  :username string,
  :password string,
  :securityMode [securityModeUnspecified none ssl starttls]}}"
  [userId sendAsEmail SendAs]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}",
     :uri-template-args {:userId userId, :sendAsEmail sendAsEmail},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body SendAs}))

(defn users-settings-sendAs-patch
  "Patch the specified send-as alias.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs/patch

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
sendAsEmail <string> The send-as alias to be updated.
SendAs:
{:treatAsAlias boolean,
 :isDefault boolean,
 :displayName string,
 :isPrimary boolean,
 :signature string,
 :sendAsEmail string,
 :verificationStatus [verificationStatusUnspecified accepted pending],
 :replyToAddress string,
 :smtpMsa
 {:host string,
  :port integer,
  :username string,
  :password string,
  :securityMode [securityModeUnspecified none ssl starttls]}}"
  [userId sendAsEmail SendAs]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}",
     :uri-template-args {:userId userId, :sendAsEmail sendAsEmail},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body SendAs}))

(defn users-settings-sendAs-delete
  "Deletes the specified send-as alias. Revokes any verification that may have been required for using it. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs/delete

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
sendAsEmail <string> The send-as alias to be deleted."
  [userId sendAsEmail]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}",
     :uri-template-args {:userId userId, :sendAsEmail sendAsEmail},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-sendAs-verify
  "Sends a verification email to the specified send-as alias address. The verification status must be `pending`. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs/verify

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
sendAsEmail <string> The send-as alias to be verified."
  [userId sendAsEmail]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/verify",
     :uri-template-args {:userId userId, :sendAsEmail sendAsEmail},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-sendAs-smimeInfo-list
  "Lists S/MIME configs for the specified send-as alias.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs.smimeInfo/list

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
sendAsEmail <string> The email address that appears in the \"From:\" header for mail sent using this alias."
  [userId sendAsEmail]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo",
     :uri-template-args {:userId userId, :sendAsEmail sendAsEmail},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-sendAs-smimeInfo-get
  "Gets the specified S/MIME config for the specified send-as alias.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs.smimeInfo/get

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
sendAsEmail <string> The email address that appears in the \"From:\" header for mail sent using this alias.
id <string> The immutable ID for the SmimeInfo."
  [userId sendAsEmail id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}",
     :uri-template-args
     {:userId userId, :sendAsEmail sendAsEmail, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-sendAs-smimeInfo-insert
  "Insert (upload) the given S/MIME config for the specified send-as alias. Note that pkcs12 format is required for the key.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs.smimeInfo/insert

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
sendAsEmail <string> The email address that appears in the \"From:\" header for mail sent using this alias.
SmimeInfo:
{:id string,
 :issuerCn string,
 :isDefault boolean,
 :expiration string,
 :pem string,
 :pkcs12 string,
 :encryptedKeyPassword string}"
  [userId sendAsEmail SmimeInfo]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo",
     :uri-template-args {:userId userId, :sendAsEmail sendAsEmail},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body SmimeInfo}))

(defn users-settings-sendAs-smimeInfo-delete
  "Deletes the specified S/MIME config for the specified send-as alias.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs.smimeInfo/delete

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
sendAsEmail <string> The email address that appears in the \"From:\" header for mail sent using this alias.
id <string> The immutable ID for the SmimeInfo."
  [userId sendAsEmail id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}",
     :uri-template-args
     {:userId userId, :sendAsEmail sendAsEmail, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-sendAs-smimeInfo-setDefault
  "Sets the default S/MIME config for the specified send-as alias.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.sendAs.smimeInfo/setDefault

userId <string> The user's email address. The special value `me` can be used to indicate the authenticated user.
sendAsEmail <string> The email address that appears in the \"From:\" header for mail sent using this alias.
id <string> The immutable ID for the SmimeInfo."
  [userId sendAsEmail id]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}/setDefault",
     :uri-template-args
     {:userId userId, :sendAsEmail sendAsEmail, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-cse-identities-create
  "Creates and configures a client-side encryption identity that's authorized to send mail from the user account. Google publishes the S/MIME certificate to a shared domain-wide directory so that people within a Google Workspace organization can encrypt and send mail to the identity.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.identities/create

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
CseIdentity:
{:emailAddress string,
 :primaryKeyPairId string,
 :signAndEncryptKeyPairs
 {:signingKeyPairId string, :encryptionKeyPairId string}}"
  [userId CseIdentity]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/identities",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body CseIdentity}))

(defn users-settings-cse-identities-delete
  "Deletes a client-side encryption identity. The authenticated user can no longer use the identity to send encrypted messages. You cannot restore the identity after you delete it. Instead, use the CreateCseIdentity method to create another identity with the same configuration.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.identities/delete

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
cseEmailAddress <string> The primary email address associated with the client-side encryption identity configuration that's removed."
  [userId cseEmailAddress]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/identities/{cseEmailAddress}",
     :uri-template-args
     {:userId userId, :cseEmailAddress cseEmailAddress},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-cse-identities-get
  "Retrieves a client-side encryption identity configuration.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.identities/get

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
cseEmailAddress <string> The primary email address associated with the client-side encryption identity configuration that's retrieved."
  [userId cseEmailAddress]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/identities/{cseEmailAddress}",
     :uri-template-args
     {:userId userId, :cseEmailAddress cseEmailAddress},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-cse-identities-list
  "Lists the client-side encrypted identities for an authenticated user.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.identities/list

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.

optional:
pageSize <integer> The number of identities to return. If not provided, the page size will default to 20 entries."
  ([userId] (users-settings-cse-identities-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/identities",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"
        "https://www.googleapis.com/auth/gmail.settings.basic"
        "https://www.googleapis.com/auth/gmail.settings.sharing"]})))

(defn users-settings-cse-identities-patch
  "Associates a different key pair with an existing client-side encryption identity. The updated key pair must validate against Google's [S/MIME certificate profiles](https://support.google.com/a/answer/7300887).
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.identities/patch

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
emailAddress <string> The email address of the client-side encryption identity to update.
CseIdentity:
{:emailAddress string,
 :primaryKeyPairId string,
 :signAndEncryptKeyPairs
 {:signingKeyPairId string, :encryptionKeyPairId string}}"
  [userId emailAddress CseIdentity]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/identities/{emailAddress}",
     :uri-template-args {:userId userId, :emailAddress emailAddress},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body CseIdentity}))

(defn users-settings-cse-keypairs-create
  "Creates and uploads a client-side encryption S/MIME public key certificate chain and private key metadata for the authenticated user.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.keypairs/create

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
CseKeyPair:
{:keyPairId string,
 :pkcs7 string,
 :pem string,
 :subjectEmailAddresses [string],
 :enablementState [stateUnspecified enabled disabled],
 :disableTime string,
 :privateKeyMetadata
 [{:privateKeyMetadataId string,
   :kaclsKeyMetadata {:kaclsUri string, :kaclsData string},
   :hardwareKeyMetadata {:description string}}]}"
  [userId CseKeyPair]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/keypairs",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body CseKeyPair}))

(defn users-settings-cse-keypairs-disable
  "Turns off a client-side encryption key pair. The authenticated user can no longer use the key pair to decrypt incoming CSE message texts or sign outgoing CSE mail. To regain access, use the EnableCseKeyPair to turn on the key pair. After 30 days, you can permanently delete the key pair by using the ObliterateCseKeyPair method.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.keypairs/disable

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
keyPairId <string> The identifier of the key pair to turn off.
DisableCseKeyPairRequest:
object"
  [userId keyPairId DisableCseKeyPairRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/keypairs/{keyPairId}:disable",
     :uri-template-args {:userId userId, :keyPairId keyPairId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body DisableCseKeyPairRequest}))

(defn users-settings-cse-keypairs-enable
  "Turns on a client-side encryption key pair that was turned off. The key pair becomes active again for any associated client-side encryption identities.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.keypairs/enable

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
keyPairId <string> The identifier of the key pair to turn on.
EnableCseKeyPairRequest:
object"
  [userId keyPairId EnableCseKeyPairRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/keypairs/{keyPairId}:enable",
     :uri-template-args {:userId userId, :keyPairId keyPairId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body EnableCseKeyPairRequest}))

(defn users-settings-cse-keypairs-get
  "Retrieves an existing client-side encryption key pair.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.keypairs/get

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
keyPairId <string> The identifier of the key pair to retrieve."
  [userId keyPairId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/keypairs/{keyPairId}",
     :uri-template-args {:userId userId, :keyPairId keyPairId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-cse-keypairs-list
  "Lists client-side encryption key pairs for an authenticated user.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.keypairs/list

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.

optional:
pageSize <integer> The number of key pairs to return. If not provided, the page size will default to 20 entries."
  ([userId] (users-settings-cse-keypairs-list userId nil))
  ([userId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/keypairs",
       :uri-template-args {:userId userId},
       :query-params (merge {} optional),
       :scopes
       ["https://mail.google.com/"
        "https://www.googleapis.com/auth/gmail.modify"
        "https://www.googleapis.com/auth/gmail.readonly"
        "https://www.googleapis.com/auth/gmail.settings.basic"
        "https://www.googleapis.com/auth/gmail.settings.sharing"]})))

(defn users-settings-cse-keypairs-obliterate
  "Deletes a client-side encryption key pair permanently and immediately. You can only permanently delete key pairs that have been turned off for more than 30 days. To turn off a key pair, use the DisableCseKeyPair method. Gmail can't restore or decrypt any messages that were encrypted by an obliterated key. Authenticated users and Google Workspace administrators lose access to reading the encrypted messages.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.cse.keypairs/obliterate

userId <string> The requester's primary email address. To indicate the authenticated user, you can use the special value `me`.
keyPairId <string> The identifier of the key pair to obliterate.
ObliterateCseKeyPairRequest:
object"
  [userId keyPairId ObliterateCseKeyPairRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/cse/keypairs/{keyPairId}:obliterate",
     :uri-template-args {:userId userId, :keyPairId keyPairId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.basic"
      "https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body ObliterateCseKeyPairRequest}))

(defn users-settings-filters-list
  "Lists the message filters of a Gmail user.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.filters/list

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/filters",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-filters-get
  "Gets a filter.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.filters/get

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
id <string> The ID of the filter to be fetched."
  [userId id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/filters/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-filters-create
  "Creates a filter. Note: you can only create a maximum of 1,000 filters.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.filters/create

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
Filter:
{:id string,
 :criteria
 {:excludeChats boolean,
  :hasAttachment boolean,
  :sizeComparison [unspecified smaller larger],
  :size integer,
  :negatedQuery string,
  :from string,
  :query string,
  :subject string,
  :to string},
 :action
 {:addLabelIds [string], :removeLabelIds [string], :forward string}}"
  [userId Filter]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/filters",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/gmail.settings.basic"],
     :body Filter}))

(defn users-settings-filters-delete
  "Immediately and permanently deletes the specified filter.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.filters/delete

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
id <string> The ID of the filter to be deleted."
  [userId id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/filters/{id}",
     :uri-template-args {:userId userId, :id id},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-forwardingAddresses-list
  "Lists the forwarding addresses for the specified account.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.forwardingAddresses/list

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/forwardingAddresses",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-forwardingAddresses-get
  "Gets the specified forwarding address.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.forwardingAddresses/get

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
forwardingEmail <string> The forwarding address to be retrieved."
  [userId forwardingEmail]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/forwardingAddresses/{forwardingEmail}",
     :uri-template-args
     {:userId userId, :forwardingEmail forwardingEmail},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-forwardingAddresses-create
  "Creates a forwarding address. If ownership verification is required, a message will be sent to the recipient and the resource's verification status will be set to `pending`; otherwise, the resource will be created with verification status set to `accepted`. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.forwardingAddresses/create

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
ForwardingAddress:
{:forwardingEmail string,
 :verificationStatus [verificationStatusUnspecified accepted pending]}"
  [userId ForwardingAddress]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/forwardingAddresses",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body ForwardingAddress}))

(defn users-settings-forwardingAddresses-delete
  "Deletes the specified forwarding address and revokes any verification that may have been required. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.forwardingAddresses/delete

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
forwardingEmail <string> The forwarding address to be deleted."
  [userId forwardingEmail]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/forwardingAddresses/{forwardingEmail}",
     :uri-template-args
     {:userId userId, :forwardingEmail forwardingEmail},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"]}))

(defn users-settings-delegates-list
  "Lists the delegates for the specified account. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.delegates/list

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user."
  [userId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/delegates",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-delegates-get
  "Gets the specified delegate. Note that a delegate user must be referred to by their primary email address, and not an email alias. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.delegates/get

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
delegateEmail <string> The email address of the user whose delegate relationship is to be retrieved."
  [userId delegateEmail]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/delegates/{delegateEmail}",
     :uri-template-args {:userId userId, :delegateEmail delegateEmail},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.googleapis.com/auth/gmail.modify"
      "https://www.googleapis.com/auth/gmail.readonly"
      "https://www.googleapis.com/auth/gmail.settings.basic"]}))

(defn users-settings-delegates-create
  "Adds a delegate with its verification status set directly to `accepted`, without sending any verification email. The delegate user must be a member of the same Google Workspace organization as the delegator user. Gmail imposes limitations on the number of delegates and delegators each user in a Google Workspace organization can have. These limits depend on your organization, but in general each user can have up to 25 delegates and up to 10 delegators. Note that a delegate user must be referred to by their primary email address, and not an email alias. Also note that when a new delegate is created, there may be up to a one minute delay before the new delegate is available for use. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.delegates/create

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
Delegate:
{:delegateEmail string,
 :verificationStatus
 [verificationStatusUnspecified accepted pending rejected expired]}"
  [userId Delegate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/delegates",
     :uri-template-args {:userId userId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"],
     :body Delegate}))

(defn users-settings-delegates-delete
  "Removes the specified delegate (which can be of any verification status), and revokes any verification that may have been required for using it. Note that a delegate user must be referred to by their primary email address, and not an email alias. This method is only available to service account clients that have been delegated domain-wide authority.
https://developers.google.com/gmail/api/reference/rest/v1/users.settings.delegates/delete

userId <string> User's email address. The special value \"me\" can be used to indicate the authenticated user.
delegateEmail <string> The email address of the user to be removed as a delegate."
  [userId delegateEmail]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://gmail.googleapis.com/gmail/v1/users/{userId}/settings/delegates/{delegateEmail}",
     :uri-template-args {:userId userId, :delegateEmail delegateEmail},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/gmail.settings.sharing"]}))

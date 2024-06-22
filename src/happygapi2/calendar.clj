(ns happygapi2.calendar
  "Calendar API
Manipulates events and other calendar data.
See: https://developers.google.com/calendar"
  (:require [happy.oauth2.client :as client]))

(defn acl-delete
  "Deletes an access control rule.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
ruleId <string> ACL rule identifier."
  [calendarId ruleId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/acl/{ruleId}",
     :uri-template-args {:calendarId calendarId, :ruleId ruleId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/calendar"]}))

(defn acl-get
  "Returns an access control rule.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
ruleId <string> ACL rule identifier."
  [calendarId ruleId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/acl/{ruleId}",
     :uri-template-args {:calendarId calendarId, :ruleId ruleId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/calendar"
      "https://www.googleapis.com/auth/calendar.readonly"]}))

(defn acl-insert
  "Creates an access control rule.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
AclRule:
{:etag string,
 :id string,
 :kind string,
 :role string,
 :scope {:type string, :value string}}

optional:
sendNotifications <boolean> Whether to send notifications about the calendar sharing change. Optional. The default is True."
  ([calendarId AclRule] (acl-insert calendarId AclRule nil))
  ([calendarId AclRule optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/acl",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"],
       :body AclRule})))

(defn acl-list
  "Returns the rules in the access control list for the calendar.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.

optional:
maxResults <integer> Maximum number of entries returned on one result page. By default the value is 100 entries. The page size can never be larger than 250 entries. Optional.
showDeleted <boolean> Whether to include deleted ACLs in the result. Deleted ACLs are represented by role equal to \"none\". Deleted ACLs will always be included if syncToken is provided. Optional. The default is False.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then. All entries deleted since the previous list request will always be in the result set and it is not allowed to set showDeleted to False.
If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries."
  ([calendarId] (acl-list calendarId nil))
  ([calendarId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/acl",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"]})))

(defn acl-patch
  "Updates an access control rule. This method supports patch semantics.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
ruleId <string> ACL rule identifier.
AclRule:
{:etag string,
 :id string,
 :kind string,
 :role string,
 :scope {:type string, :value string}}

optional:
sendNotifications <boolean> Whether to send notifications about the calendar sharing change. Note that there are no notifications on access removal. Optional. The default is True."
  ([calendarId ruleId AclRule]
    (acl-patch calendarId ruleId AclRule nil))
  ([calendarId ruleId AclRule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/acl/{ruleId}",
       :uri-template-args {:calendarId calendarId, :ruleId ruleId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"],
       :body AclRule})))

(defn acl-update
  "Updates an access control rule.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
ruleId <string> ACL rule identifier.
AclRule:
{:etag string,
 :id string,
 :kind string,
 :role string,
 :scope {:type string, :value string}}

optional:
sendNotifications <boolean> Whether to send notifications about the calendar sharing change. Note that there are no notifications on access removal. Optional. The default is True."
  ([calendarId ruleId AclRule]
    (acl-update calendarId ruleId AclRule nil))
  ([calendarId ruleId AclRule optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/acl/{ruleId}",
       :uri-template-args {:calendarId calendarId, :ruleId ruleId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"],
       :body AclRule})))

(defn acl-watch
  "Watch for changes to ACL resources.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}

optional:
maxResults <integer> Maximum number of entries returned on one result page. By default the value is 100 entries. The page size can never be larger than 250 entries. Optional.
showDeleted <boolean> Whether to include deleted ACLs in the result. Deleted ACLs are represented by role equal to \"none\". Deleted ACLs will always be included if syncToken is provided. Optional. The default is False.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then. All entries deleted since the previous list request will always be in the result set and it is not allowed to set showDeleted to False.
If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries."
  ([calendarId Channel] (acl-watch calendarId Channel nil))
  ([calendarId Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/acl/watch",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"],
       :body Channel})))

(defn calendarList-delete
  "Removes a calendar from the user's calendar list.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword."
  [calendarId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/calendar/v3/users/me/calendarList/{calendarId}",
     :uri-template-args {:calendarId calendarId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/calendar"]}))

(defn calendarList-get
  "Returns a calendar from the user's calendar list.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword."
  [calendarId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/calendar/v3/users/me/calendarList/{calendarId}",
     :uri-template-args {:calendarId calendarId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/calendar"
      "https://www.googleapis.com/auth/calendar.readonly"]}))

(defn calendarList-insert
  "Inserts an existing calendar into the user's calendar list.
https://developers.google.com/calendar

CalendarListEntry:
{:description string,
 :timeZone string,
 :deleted boolean,
 :notificationSettings
 {:notifications [{:method string, :type string}]},
 :primary boolean,
 :selected boolean,
 :summaryOverride string,
 :accessRole string,
 :etag string,
 :defaultReminders [{:method string, :minutes integer}],
 :summary string,
 :hidden boolean,
 :id string,
 :kind string,
 :conferenceProperties {:allowedConferenceSolutionTypes [string]},
 :backgroundColor string,
 :colorId string,
 :location string,
 :foregroundColor string}

optional:
colorRgbFormat <boolean> Whether to use the foregroundColor and backgroundColor fields to write the calendar colors (RGB). If this feature is used, the index-based colorId field will be set to the best matching option automatically. Optional. The default is False."
  ([CalendarListEntry] (calendarList-insert CalendarListEntry nil))
  ([CalendarListEntry optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/users/me/calendarList",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"],
       :body CalendarListEntry})))

(defn calendarList-list
  "Returns the calendars on the user's calendar list.
https://developers.google.com/calendar

optional:
maxResults <integer> Maximum number of entries returned on one result page. By default the value is 100 entries. The page size can never be larger than 250 entries. Optional.
minAccessRole <string> The minimum access role for the user in the returned entries. Optional. The default is no restriction.
showDeleted <boolean> Whether to include deleted calendar list entries in the result. Optional. The default is False.
showHidden <boolean> Whether to show hidden entries. Optional. The default is False.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then. If only read-only fields such as calendar properties or ACLs have changed, the entry won't be returned. All entries deleted and hidden since the previous list request will always be in the result set and it is not allowed to set showDeleted neither showHidden to False.
To ensure client state consistency minAccessRole query parameter cannot be specified together with nextSyncToken.
If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries."
  ([] (calendarList-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/calendar/v3/users/me/calendarList",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.readonly"]})))

(defn calendarList-patch
  "Updates an existing calendar on the user's calendar list. This method supports patch semantics.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
CalendarListEntry:
{:description string,
 :timeZone string,
 :deleted boolean,
 :notificationSettings
 {:notifications [{:method string, :type string}]},
 :primary boolean,
 :selected boolean,
 :summaryOverride string,
 :accessRole string,
 :etag string,
 :defaultReminders [{:method string, :minutes integer}],
 :summary string,
 :hidden boolean,
 :id string,
 :kind string,
 :conferenceProperties {:allowedConferenceSolutionTypes [string]},
 :backgroundColor string,
 :colorId string,
 :location string,
 :foregroundColor string}

optional:
colorRgbFormat <boolean> Whether to use the foregroundColor and backgroundColor fields to write the calendar colors (RGB). If this feature is used, the index-based colorId field will be set to the best matching option automatically. Optional. The default is False."
  ([calendarId CalendarListEntry]
    (calendarList-patch calendarId CalendarListEntry nil))
  ([calendarId CalendarListEntry optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/calendar/v3/users/me/calendarList/{calendarId}",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"],
       :body CalendarListEntry})))

(defn calendarList-update
  "Updates an existing calendar on the user's calendar list.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
CalendarListEntry:
{:description string,
 :timeZone string,
 :deleted boolean,
 :notificationSettings
 {:notifications [{:method string, :type string}]},
 :primary boolean,
 :selected boolean,
 :summaryOverride string,
 :accessRole string,
 :etag string,
 :defaultReminders [{:method string, :minutes integer}],
 :summary string,
 :hidden boolean,
 :id string,
 :kind string,
 :conferenceProperties {:allowedConferenceSolutionTypes [string]},
 :backgroundColor string,
 :colorId string,
 :location string,
 :foregroundColor string}

optional:
colorRgbFormat <boolean> Whether to use the foregroundColor and backgroundColor fields to write the calendar colors (RGB). If this feature is used, the index-based colorId field will be set to the best matching option automatically. Optional. The default is False."
  ([calendarId CalendarListEntry]
    (calendarList-update calendarId CalendarListEntry nil))
  ([calendarId CalendarListEntry optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://www.googleapis.com/calendar/v3/users/me/calendarList/{calendarId}",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/calendar"],
       :body CalendarListEntry})))

(defn calendarList-watch
  "Watch for changes to CalendarList resources.
https://developers.google.com/calendar

Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}

optional:
maxResults <integer> Maximum number of entries returned on one result page. By default the value is 100 entries. The page size can never be larger than 250 entries. Optional.
minAccessRole <string> The minimum access role for the user in the returned entries. Optional. The default is no restriction.
showDeleted <boolean> Whether to include deleted calendar list entries in the result. Optional. The default is False.
showHidden <boolean> Whether to show hidden entries. Optional. The default is False.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then. If only read-only fields such as calendar properties or ACLs have changed, the entry won't be returned. All entries deleted and hidden since the previous list request will always be in the result set and it is not allowed to set showDeleted neither showHidden to False.
To ensure client state consistency minAccessRole query parameter cannot be specified together with nextSyncToken.
If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries."
  ([Channel] (calendarList-watch Channel nil))
  ([Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/users/me/calendarList/watch",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.readonly"],
       :body Channel})))

(defn calendars-clear
  "Clears a primary calendar. This operation deletes all events associated with the primary calendar of an account.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword."
  [calendarId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/clear",
     :uri-template-args {:calendarId calendarId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/calendar"]}))

(defn calendars-delete
  "Deletes a secondary calendar. Use calendars.clear for clearing all events on primary calendars.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword."
  [calendarId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/calendar/v3/calendars/{calendarId}",
     :uri-template-args {:calendarId calendarId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/calendar"]}))

(defn calendars-get
  "Returns metadata for a calendar.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword."
  [calendarId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/calendar/v3/calendars/{calendarId}",
     :uri-template-args {:calendarId calendarId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/calendar"
      "https://www.googleapis.com/auth/calendar.readonly"]}))

(defn calendars-insert
  "Creates a secondary calendar.
https://developers.google.com/calendar

Calendar:
{:conferenceProperties {:allowedConferenceSolutionTypes [string]},
 :description string,
 :etag string,
 :id string,
 :kind string,
 :location string,
 :summary string,
 :timeZone string}"
  [Calendar]
  (client/api-request
    {:method "POST",
     :uri-template "https://www.googleapis.com/calendar/v3/calendars",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/calendar"],
     :body Calendar}))

(defn calendars-patch
  "Updates metadata for a calendar. This method supports patch semantics.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
Calendar:
{:conferenceProperties {:allowedConferenceSolutionTypes [string]},
 :description string,
 :etag string,
 :id string,
 :kind string,
 :location string,
 :summary string,
 :timeZone string}"
  [calendarId Calendar]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/calendar/v3/calendars/{calendarId}",
     :uri-template-args {:calendarId calendarId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/calendar"],
     :body Calendar}))

(defn calendars-update
  "Updates metadata for a calendar.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
Calendar:
{:conferenceProperties {:allowedConferenceSolutionTypes [string]},
 :description string,
 :etag string,
 :id string,
 :kind string,
 :location string,
 :summary string,
 :timeZone string}"
  [calendarId Calendar]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://www.googleapis.com/calendar/v3/calendars/{calendarId}",
     :uri-template-args {:calendarId calendarId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/calendar"],
     :body Calendar}))

(defn channels-stop
  "Stop watching resources through this channel
https://developers.google.com/calendar

Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}"
  [Channel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/calendar/v3/channels/stop",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/calendar"
      "https://www.googleapis.com/auth/calendar.events"
      "https://www.googleapis.com/auth/calendar.events.readonly"
      "https://www.googleapis.com/auth/calendar.readonly"
      "https://www.googleapis.com/auth/calendar.settings.readonly"],
     :body Channel}))

(defn colors-get
  "Returns the color definitions for calendars and events.
https://developers.google.com/calendar"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://www.googleapis.com/calendar/v3/colors",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/calendar"
      "https://www.googleapis.com/auth/calendar.readonly"]}))

(defn events-get
  "Returns an event based on its Google Calendar ID. To retrieve an event using its iCalendar ID, call the events.list method using the iCalUID parameter.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
eventId <string> Event identifier.

optional:
alwaysIncludeEmail <boolean> Deprecated and ignored. A value will always be returned in the email field for the organizer, creator and attendees, even if no real email address is available (i.e. a generated, non-working value will be provided).
maxAttendees <integer> The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned. Optional.
timeZone <string> Time zone used in the response. Optional. The default is the time zone of the calendar."
  ([calendarId eventId] (events-get calendarId eventId nil))
  ([calendarId eventId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}",
       :uri-template-args {:calendarId calendarId, :eventId eventId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"
        "https://www.googleapis.com/auth/calendar.events.readonly"
        "https://www.googleapis.com/auth/calendar.readonly"]})))

(defn events-insert
  "Creates an event.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
Event:
{:iCalUID string,
 :recurringEventId string,
 :description string,
 :eventType string,
 :creator
 {:displayName string, :email string, :id string, :self boolean},
 :privateCopy boolean,
 :extendedProperties {:private object, :shared object},
 :focusTimeProperties
 {:autoDeclineMode string, :chatStatus string, :declineMessage string},
 :updated string,
 :endTimeUnspecified boolean,
 :workingLocationProperties
 {:customLocation {:label string},
  :homeOffice any,
  :officeLocation
  {:buildingId string,
   :deskId string,
   :floorId string,
   :floorSectionId string,
   :label string},
  :type string},
 :attachments
 [{:fileId string,
   :fileUrl string,
   :iconLink string,
   :mimeType string,
   :title string}],
 :conferenceData
 {:conferenceId string,
  :conferenceSolution
  {:iconUri string, :key {:type string}, :name string},
  :createRequest
  {:conferenceSolutionKey {:type string},
   :requestId string,
   :status {:statusCode string}},
  :entryPoints
  [{:passcode string,
    :accessCode string,
    :entryPointFeatures [string],
    :password string,
    :pin string,
    :label string,
    :regionCode string,
    :meetingCode string,
    :entryPointType string,
    :uri string}],
  :notes string,
  :parameters {:addOnParameters {:parameters object}},
  :signature string},
 :htmlLink string,
 :start {:date string, :dateTime string, :timeZone string},
 :etag string,
 :created string,
 :guestsCanSeeOtherGuests boolean,
 :originalStartTime {:date string, :dateTime string, :timeZone string},
 :source {:title string, :url string},
 :summary string,
 :attendees
 [{:email string,
   :displayName string,
   :additionalGuests integer,
   :id string,
   :resource boolean,
   :optional boolean,
   :comment string,
   :responseStatus string,
   :self boolean,
   :organizer boolean}],
 :attendeesOmitted boolean,
 :anyoneCanAddSelf boolean,
 :status string,
 :locked boolean,
 :id string,
 :kind string,
 :sequence integer,
 :guestsCanInviteOthers boolean,
 :recurrence [string],
 :gadget
 {:display string,
  :height integer,
  :iconLink string,
  :link string,
  :preferences object,
  :title string,
  :type string,
  :width integer},
 :reminders
 {:overrides [{:method string, :minutes integer}],
  :useDefault boolean},
 :guestsCanModify boolean,
 :end {:date string, :dateTime string, :timeZone string},
 :outOfOfficeProperties
 {:autoDeclineMode string, :declineMessage string},
 :colorId string,
 :location string,
 :visibility string,
 :hangoutLink string,
 :organizer
 {:displayName string, :email string, :id string, :self boolean},
 :transparency string}

optional:
conferenceDataVersion <integer> Version number of conference data supported by the API client. Version 0 assumes no conference data support and ignores conference data in the event's body. Version 1 enables support for copying of ConferenceData as well as for creating new conferences using the createRequest field of conferenceData. The default is 0.
maxAttendees <integer> The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned. Optional.
sendNotifications <boolean> Deprecated. Please use sendUpdates instead.

Whether to send notifications about the creation of the new event. Note that some emails might still be sent even if you set the value to false. The default is false.
sendUpdates <string> Whether to send notifications about the creation of the new event. Note that some emails might still be sent. The default is false.
supportsAttachments <boolean> Whether API client performing operation supports event attachments. Optional. The default is False."
  ([calendarId Event] (events-insert calendarId Event nil))
  ([calendarId Event optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"],
       :body Event})))

(defn events-patch
  "Updates an event. This method supports patch semantics.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
eventId <string> Event identifier.
Event:
{:iCalUID string,
 :recurringEventId string,
 :description string,
 :eventType string,
 :creator
 {:displayName string, :email string, :id string, :self boolean},
 :privateCopy boolean,
 :extendedProperties {:private object, :shared object},
 :focusTimeProperties
 {:autoDeclineMode string, :chatStatus string, :declineMessage string},
 :updated string,
 :endTimeUnspecified boolean,
 :workingLocationProperties
 {:customLocation {:label string},
  :homeOffice any,
  :officeLocation
  {:buildingId string,
   :deskId string,
   :floorId string,
   :floorSectionId string,
   :label string},
  :type string},
 :attachments
 [{:fileId string,
   :fileUrl string,
   :iconLink string,
   :mimeType string,
   :title string}],
 :conferenceData
 {:conferenceId string,
  :conferenceSolution
  {:iconUri string, :key {:type string}, :name string},
  :createRequest
  {:conferenceSolutionKey {:type string},
   :requestId string,
   :status {:statusCode string}},
  :entryPoints
  [{:passcode string,
    :accessCode string,
    :entryPointFeatures [string],
    :password string,
    :pin string,
    :label string,
    :regionCode string,
    :meetingCode string,
    :entryPointType string,
    :uri string}],
  :notes string,
  :parameters {:addOnParameters {:parameters object}},
  :signature string},
 :htmlLink string,
 :start {:date string, :dateTime string, :timeZone string},
 :etag string,
 :created string,
 :guestsCanSeeOtherGuests boolean,
 :originalStartTime {:date string, :dateTime string, :timeZone string},
 :source {:title string, :url string},
 :summary string,
 :attendees
 [{:email string,
   :displayName string,
   :additionalGuests integer,
   :id string,
   :resource boolean,
   :optional boolean,
   :comment string,
   :responseStatus string,
   :self boolean,
   :organizer boolean}],
 :attendeesOmitted boolean,
 :anyoneCanAddSelf boolean,
 :status string,
 :locked boolean,
 :id string,
 :kind string,
 :sequence integer,
 :guestsCanInviteOthers boolean,
 :recurrence [string],
 :gadget
 {:display string,
  :height integer,
  :iconLink string,
  :link string,
  :preferences object,
  :title string,
  :type string,
  :width integer},
 :reminders
 {:overrides [{:method string, :minutes integer}],
  :useDefault boolean},
 :guestsCanModify boolean,
 :end {:date string, :dateTime string, :timeZone string},
 :outOfOfficeProperties
 {:autoDeclineMode string, :declineMessage string},
 :colorId string,
 :location string,
 :visibility string,
 :hangoutLink string,
 :organizer
 {:displayName string, :email string, :id string, :self boolean},
 :transparency string}

optional:
alwaysIncludeEmail <boolean> Deprecated and ignored. A value will always be returned in the email field for the organizer, creator and attendees, even if no real email address is available (i.e. a generated, non-working value will be provided).
conferenceDataVersion <integer> Version number of conference data supported by the API client. Version 0 assumes no conference data support and ignores conference data in the event's body. Version 1 enables support for copying of ConferenceData as well as for creating new conferences using the createRequest field of conferenceData. The default is 0.
maxAttendees <integer> The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned. Optional.
sendNotifications <boolean> Deprecated. Please use sendUpdates instead.

Whether to send notifications about the event update (for example, description changes, etc.). Note that some emails might still be sent even if you set the value to false. The default is false.
sendUpdates <string> Guests who should receive notifications about the event update (for example, title changes, etc.).
supportsAttachments <boolean> Whether API client performing operation supports event attachments. Optional. The default is False."
  ([calendarId eventId Event]
    (events-patch calendarId eventId Event nil))
  ([calendarId eventId Event optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}",
       :uri-template-args {:calendarId calendarId, :eventId eventId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"],
       :body Event})))

(defn events-move
  "Moves an event to another calendar, i.e. changes an event's organizer. Note that only default events can be moved; outOfOffice, focusTime, workingLocation and fromGmail events cannot be moved.
https://developers.google.com/calendar

calendarId <string> Calendar identifier of the source calendar where the event currently is on.
eventId <string> Event identifier.
destination <string> Calendar identifier of the target calendar where the event is to be moved to.

optional:
sendNotifications <boolean> Deprecated. Please use sendUpdates instead.

Whether to send notifications about the change of the event's organizer. Note that some emails might still be sent even if you set the value to false. The default is false.
sendUpdates <string> Guests who should receive notifications about the change of the event's organizer."
  ([calendarId eventId destination]
    (events-move calendarId eventId destination nil))
  ([calendarId eventId destination optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}/move",
       :uri-template-args {:calendarId calendarId, :eventId eventId},
       :query-params (merge {:destination destination} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"]})))

(defn events-update
  "Updates an event.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
eventId <string> Event identifier.
Event:
{:iCalUID string,
 :recurringEventId string,
 :description string,
 :eventType string,
 :creator
 {:displayName string, :email string, :id string, :self boolean},
 :privateCopy boolean,
 :extendedProperties {:private object, :shared object},
 :focusTimeProperties
 {:autoDeclineMode string, :chatStatus string, :declineMessage string},
 :updated string,
 :endTimeUnspecified boolean,
 :workingLocationProperties
 {:customLocation {:label string},
  :homeOffice any,
  :officeLocation
  {:buildingId string,
   :deskId string,
   :floorId string,
   :floorSectionId string,
   :label string},
  :type string},
 :attachments
 [{:fileId string,
   :fileUrl string,
   :iconLink string,
   :mimeType string,
   :title string}],
 :conferenceData
 {:conferenceId string,
  :conferenceSolution
  {:iconUri string, :key {:type string}, :name string},
  :createRequest
  {:conferenceSolutionKey {:type string},
   :requestId string,
   :status {:statusCode string}},
  :entryPoints
  [{:passcode string,
    :accessCode string,
    :entryPointFeatures [string],
    :password string,
    :pin string,
    :label string,
    :regionCode string,
    :meetingCode string,
    :entryPointType string,
    :uri string}],
  :notes string,
  :parameters {:addOnParameters {:parameters object}},
  :signature string},
 :htmlLink string,
 :start {:date string, :dateTime string, :timeZone string},
 :etag string,
 :created string,
 :guestsCanSeeOtherGuests boolean,
 :originalStartTime {:date string, :dateTime string, :timeZone string},
 :source {:title string, :url string},
 :summary string,
 :attendees
 [{:email string,
   :displayName string,
   :additionalGuests integer,
   :id string,
   :resource boolean,
   :optional boolean,
   :comment string,
   :responseStatus string,
   :self boolean,
   :organizer boolean}],
 :attendeesOmitted boolean,
 :anyoneCanAddSelf boolean,
 :status string,
 :locked boolean,
 :id string,
 :kind string,
 :sequence integer,
 :guestsCanInviteOthers boolean,
 :recurrence [string],
 :gadget
 {:display string,
  :height integer,
  :iconLink string,
  :link string,
  :preferences object,
  :title string,
  :type string,
  :width integer},
 :reminders
 {:overrides [{:method string, :minutes integer}],
  :useDefault boolean},
 :guestsCanModify boolean,
 :end {:date string, :dateTime string, :timeZone string},
 :outOfOfficeProperties
 {:autoDeclineMode string, :declineMessage string},
 :colorId string,
 :location string,
 :visibility string,
 :hangoutLink string,
 :organizer
 {:displayName string, :email string, :id string, :self boolean},
 :transparency string}

optional:
alwaysIncludeEmail <boolean> Deprecated and ignored. A value will always be returned in the email field for the organizer, creator and attendees, even if no real email address is available (i.e. a generated, non-working value will be provided).
conferenceDataVersion <integer> Version number of conference data supported by the API client. Version 0 assumes no conference data support and ignores conference data in the event's body. Version 1 enables support for copying of ConferenceData as well as for creating new conferences using the createRequest field of conferenceData. The default is 0.
maxAttendees <integer> The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned. Optional.
sendNotifications <boolean> Deprecated. Please use sendUpdates instead.

Whether to send notifications about the event update (for example, description changes, etc.). Note that some emails might still be sent even if you set the value to false. The default is false.
sendUpdates <string> Guests who should receive notifications about the event update (for example, title changes, etc.).
supportsAttachments <boolean> Whether API client performing operation supports event attachments. Optional. The default is False."
  ([calendarId eventId Event]
    (events-update calendarId eventId Event nil))
  ([calendarId eventId Event optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}",
       :uri-template-args {:calendarId calendarId, :eventId eventId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"],
       :body Event})))

(defn events-delete
  "Deletes an event.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
eventId <string> Event identifier.

optional:
sendNotifications <boolean> Deprecated. Please use sendUpdates instead.

Whether to send notifications about the deletion of the event. Note that some emails might still be sent even if you set the value to false. The default is false.
sendUpdates <string> Guests who should receive notifications about the deletion of the event."
  ([calendarId eventId] (events-delete calendarId eventId nil))
  ([calendarId eventId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}",
       :uri-template-args {:calendarId calendarId, :eventId eventId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"]})))

(defn events-instances
  "Returns instances of the specified recurring event.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
eventId <string> Recurring event identifier.

optional:
timeZone <string> Time zone used in the response. Optional. The default is the time zone of the calendar.
timeMin <string> Lower bound (inclusive) for an event's end time to filter by. Optional. The default is not to filter by end time. Must be an RFC3339 timestamp with mandatory time zone offset.
maxAttendees <integer> The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned. Optional.
originalStart <string> The original start time of the instance in the result. Optional.
showDeleted <boolean> Whether to include deleted events (with status equals \"cancelled\") in the result. Cancelled instances of recurring events will still be included if singleEvents is False. Optional. The default is False.
maxResults <integer> Maximum number of events returned on one result page. By default the value is 250 events. The page size can never be larger than 2500 events. Optional.
timeMax <string> Upper bound (exclusive) for an event's start time to filter by. Optional. The default is not to filter by start time. Must be an RFC3339 timestamp with mandatory time zone offset.
alwaysIncludeEmail <boolean> Deprecated and ignored. A value will always be returned in the email field for the organizer, creator and attendees, even if no real email address is available (i.e. a generated, non-working value will be provided)."
  ([calendarId eventId] (events-instances calendarId eventId nil))
  ([calendarId eventId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}/instances",
       :uri-template-args {:calendarId calendarId, :eventId eventId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"
        "https://www.googleapis.com/auth/calendar.events.readonly"
        "https://www.googleapis.com/auth/calendar.readonly"]})))

(defn events-list
  "Returns events on the specified calendar.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.

optional:
iCalUID <string> Specifies an event ID in the iCalendar format to be provided in the response. Optional. Use this if you want to search for an event by its iCalendar ID.
q <string> Free text search terms to find events that match these terms in the following fields:

- summary 
- description 
- location 
- attendee's displayName 
- attendee's email 
- organizer's displayName 
- organizer's email 
- workingLocationProperties.officeLocation.buildingId 
- workingLocationProperties.officeLocation.deskId 
- workingLocationProperties.officeLocation.label 
- workingLocationProperties.customLocation.label 
These search terms also match predefined keywords against all display title translations of working location, out-of-office, and focus-time events. For example, searching for \"Office\" or \"Bureau\" returns working location events of type officeLocation, whereas searching for \"Out of office\" or \"Abwesend\" returns out-of-office events. Optional.
timeZone <string> Time zone used in the response. Optional. The default is the time zone of the calendar.
showHiddenInvitations <boolean> Whether to include hidden invitations in the result. Optional. The default is False.
timeMin <string> Lower bound (exclusive) for an event's end time to filter by. Optional. The default is not to filter by end time. Must be an RFC3339 timestamp with mandatory time zone offset, for example, 2011-06-03T10:00:00-07:00, 2011-06-03T10:00:00Z. Milliseconds may be provided but are ignored. If timeMax is set, timeMin must be smaller than timeMax.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then. All events deleted since the previous list request will always be in the result set and it is not allowed to set showDeleted to False.
There are several query parameters that cannot be specified together with nextSyncToken to ensure consistency of the client state.

These are: 
- iCalUID 
- orderBy 
- privateExtendedProperty 
- q 
- sharedExtendedProperty 
- timeMin 
- timeMax 
- updatedMin All other query parameters should be the same as for the initial synchronization to avoid undefined behavior. If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries.
maxAttendees <integer> The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned. Optional.
eventTypes <string> Event types to return. Optional. This parameter can be repeated multiple times to return events of different types. If unset, returns all event types.
sharedExtendedProperty <string> Extended properties constraint specified as propertyName=value. Matches only shared properties. This parameter might be repeated multiple times to return events that match all given constraints.
privateExtendedProperty <string> Extended properties constraint specified as propertyName=value. Matches only private properties. This parameter might be repeated multiple times to return events that match all given constraints.
showDeleted <boolean> Whether to include deleted events (with status equals \"cancelled\") in the result. Cancelled instances of recurring events (but not the underlying recurring event) will still be included if showDeleted and singleEvents are both False. If showDeleted and singleEvents are both True, only single instances of deleted events (but not the underlying recurring events) are returned. Optional. The default is False.
updatedMin <string> Lower bound for an event's last modification time (as a RFC3339 timestamp) to filter by. When specified, entries deleted since this time will always be included regardless of showDeleted. Optional. The default is not to filter by last modification time.
singleEvents <boolean> Whether to expand recurring events into instances and only return single one-off events and instances of recurring events, but not the underlying recurring events themselves. Optional. The default is False.
maxResults <integer> Maximum number of events returned on one result page. The number of events in the resulting page may be less than this value, or none at all, even if there are more events matching the query. Incomplete pages can be detected by a non-empty nextPageToken field in the response. By default the value is 250 events. The page size can never be larger than 2500 events. Optional.
timeMax <string> Upper bound (exclusive) for an event's start time to filter by. Optional. The default is not to filter by start time. Must be an RFC3339 timestamp with mandatory time zone offset, for example, 2011-06-03T10:00:00-07:00, 2011-06-03T10:00:00Z. Milliseconds may be provided but are ignored. If timeMin is set, timeMax must be greater than timeMin.
orderBy <string> The order of the events returned in the result. Optional. The default is an unspecified, stable order.
alwaysIncludeEmail <boolean> Deprecated and ignored."
  ([calendarId] (events-list calendarId nil))
  ([calendarId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"
        "https://www.googleapis.com/auth/calendar.events.readonly"
        "https://www.googleapis.com/auth/calendar.readonly"]})))

(defn events-watch
  "Watch for changes to Events resources.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}

optional:
iCalUID <string> Specifies an event ID in the iCalendar format to be provided in the response. Optional. Use this if you want to search for an event by its iCalendar ID.
q <string> Free text search terms to find events that match these terms in the following fields:

- summary 
- description 
- location 
- attendee's displayName 
- attendee's email 
- organizer's displayName 
- organizer's email 
- workingLocationProperties.officeLocation.buildingId 
- workingLocationProperties.officeLocation.deskId 
- workingLocationProperties.officeLocation.label 
- workingLocationProperties.customLocation.label 
These search terms also match predefined keywords against all display title translations of working location, out-of-office, and focus-time events. For example, searching for \"Office\" or \"Bureau\" returns working location events of type officeLocation, whereas searching for \"Out of office\" or \"Abwesend\" returns out-of-office events. Optional.
timeZone <string> Time zone used in the response. Optional. The default is the time zone of the calendar.
showHiddenInvitations <boolean> Whether to include hidden invitations in the result. Optional. The default is False.
timeMin <string> Lower bound (exclusive) for an event's end time to filter by. Optional. The default is not to filter by end time. Must be an RFC3339 timestamp with mandatory time zone offset, for example, 2011-06-03T10:00:00-07:00, 2011-06-03T10:00:00Z. Milliseconds may be provided but are ignored. If timeMax is set, timeMin must be smaller than timeMax.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then. All events deleted since the previous list request will always be in the result set and it is not allowed to set showDeleted to False.
There are several query parameters that cannot be specified together with nextSyncToken to ensure consistency of the client state.

These are: 
- iCalUID 
- orderBy 
- privateExtendedProperty 
- q 
- sharedExtendedProperty 
- timeMin 
- timeMax 
- updatedMin All other query parameters should be the same as for the initial synchronization to avoid undefined behavior. If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries.
maxAttendees <integer> The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned. Optional.
eventTypes <string> Event types to return. Optional. This parameter can be repeated multiple times to return events of different types. If unset, returns all event types.
sharedExtendedProperty <string> Extended properties constraint specified as propertyName=value. Matches only shared properties. This parameter might be repeated multiple times to return events that match all given constraints.
privateExtendedProperty <string> Extended properties constraint specified as propertyName=value. Matches only private properties. This parameter might be repeated multiple times to return events that match all given constraints.
showDeleted <boolean> Whether to include deleted events (with status equals \"cancelled\") in the result. Cancelled instances of recurring events (but not the underlying recurring event) will still be included if showDeleted and singleEvents are both False. If showDeleted and singleEvents are both True, only single instances of deleted events (but not the underlying recurring events) are returned. Optional. The default is False.
updatedMin <string> Lower bound for an event's last modification time (as a RFC3339 timestamp) to filter by. When specified, entries deleted since this time will always be included regardless of showDeleted. Optional. The default is not to filter by last modification time.
singleEvents <boolean> Whether to expand recurring events into instances and only return single one-off events and instances of recurring events, but not the underlying recurring events themselves. Optional. The default is False.
maxResults <integer> Maximum number of events returned on one result page. The number of events in the resulting page may be less than this value, or none at all, even if there are more events matching the query. Incomplete pages can be detected by a non-empty nextPageToken field in the response. By default the value is 250 events. The page size can never be larger than 2500 events. Optional.
timeMax <string> Upper bound (exclusive) for an event's start time to filter by. Optional. The default is not to filter by start time. Must be an RFC3339 timestamp with mandatory time zone offset, for example, 2011-06-03T10:00:00-07:00, 2011-06-03T10:00:00Z. Milliseconds may be provided but are ignored. If timeMin is set, timeMax must be greater than timeMin.
orderBy <string> The order of the events returned in the result. Optional. The default is an unspecified, stable order.
alwaysIncludeEmail <boolean> Deprecated and ignored."
  ([calendarId Channel] (events-watch calendarId Channel nil))
  ([calendarId Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/watch",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"
        "https://www.googleapis.com/auth/calendar.events.readonly"
        "https://www.googleapis.com/auth/calendar.readonly"],
       :body Channel})))

(defn events-quickAdd
  "Creates an event based on a simple text string.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
text <string> The text describing the event to be created.

optional:
sendNotifications <boolean> Deprecated. Please use sendUpdates instead.

Whether to send notifications about the creation of the event. Note that some emails might still be sent even if you set the value to false. The default is false.
sendUpdates <string> Guests who should receive notifications about the creation of the new event."
  ([calendarId text] (events-quickAdd calendarId text nil))
  ([calendarId text optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/quickAdd",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {:text text} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"]})))

(defn events-import
  "Imports an event. This operation is used to add a private copy of an existing event to a calendar. Only events with an eventType of default may be imported.
Deprecated behavior: If a non-default event is imported, its type will be changed to default and any event-type-specific properties it may have will be dropped.
https://developers.google.com/calendar

calendarId <string> Calendar identifier. To retrieve calendar IDs call the calendarList.list method. If you want to access the primary calendar of the currently logged in user, use the \"primary\" keyword.
Event:
{:iCalUID string,
 :recurringEventId string,
 :description string,
 :eventType string,
 :creator
 {:displayName string, :email string, :id string, :self boolean},
 :privateCopy boolean,
 :extendedProperties {:private object, :shared object},
 :focusTimeProperties
 {:autoDeclineMode string, :chatStatus string, :declineMessage string},
 :updated string,
 :endTimeUnspecified boolean,
 :workingLocationProperties
 {:customLocation {:label string},
  :homeOffice any,
  :officeLocation
  {:buildingId string,
   :deskId string,
   :floorId string,
   :floorSectionId string,
   :label string},
  :type string},
 :attachments
 [{:fileId string,
   :fileUrl string,
   :iconLink string,
   :mimeType string,
   :title string}],
 :conferenceData
 {:conferenceId string,
  :conferenceSolution
  {:iconUri string, :key {:type string}, :name string},
  :createRequest
  {:conferenceSolutionKey {:type string},
   :requestId string,
   :status {:statusCode string}},
  :entryPoints
  [{:passcode string,
    :accessCode string,
    :entryPointFeatures [string],
    :password string,
    :pin string,
    :label string,
    :regionCode string,
    :meetingCode string,
    :entryPointType string,
    :uri string}],
  :notes string,
  :parameters {:addOnParameters {:parameters object}},
  :signature string},
 :htmlLink string,
 :start {:date string, :dateTime string, :timeZone string},
 :etag string,
 :created string,
 :guestsCanSeeOtherGuests boolean,
 :originalStartTime {:date string, :dateTime string, :timeZone string},
 :source {:title string, :url string},
 :summary string,
 :attendees
 [{:email string,
   :displayName string,
   :additionalGuests integer,
   :id string,
   :resource boolean,
   :optional boolean,
   :comment string,
   :responseStatus string,
   :self boolean,
   :organizer boolean}],
 :attendeesOmitted boolean,
 :anyoneCanAddSelf boolean,
 :status string,
 :locked boolean,
 :id string,
 :kind string,
 :sequence integer,
 :guestsCanInviteOthers boolean,
 :recurrence [string],
 :gadget
 {:display string,
  :height integer,
  :iconLink string,
  :link string,
  :preferences object,
  :title string,
  :type string,
  :width integer},
 :reminders
 {:overrides [{:method string, :minutes integer}],
  :useDefault boolean},
 :guestsCanModify boolean,
 :end {:date string, :dateTime string, :timeZone string},
 :outOfOfficeProperties
 {:autoDeclineMode string, :declineMessage string},
 :colorId string,
 :location string,
 :visibility string,
 :hangoutLink string,
 :organizer
 {:displayName string, :email string, :id string, :self boolean},
 :transparency string}

optional:
conferenceDataVersion <integer> Version number of conference data supported by the API client. Version 0 assumes no conference data support and ignores conference data in the event's body. Version 1 enables support for copying of ConferenceData as well as for creating new conferences using the createRequest field of conferenceData. The default is 0.
supportsAttachments <boolean> Whether API client performing operation supports event attachments. Optional. The default is False."
  ([calendarId Event] (events-import calendarId Event nil))
  ([calendarId Event optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/import",
       :uri-template-args {:calendarId calendarId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.events"],
       :body Event})))

(defn freebusy-query
  "Returns free/busy information for a set of calendars.
https://developers.google.com/calendar

FreeBusyRequest:
{:calendarExpansionMax integer,
 :groupExpansionMax integer,
 :items [{:id string}],
 :timeMax string,
 :timeMin string,
 :timeZone string}"
  [FreeBusyRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://www.googleapis.com/calendar/v3/freeBusy",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/calendar"
      "https://www.googleapis.com/auth/calendar.readonly"],
     :body FreeBusyRequest}))

(defn settings-get
  "Returns a single user setting.
https://developers.google.com/calendar

setting <string> The id of the user setting."
  [setting]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/calendar/v3/users/me/settings/{setting}",
     :uri-template-args {:setting setting},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/calendar"
      "https://www.googleapis.com/auth/calendar.readonly"
      "https://www.googleapis.com/auth/calendar.settings.readonly"]}))

(defn settings-list
  "Returns all user settings for the authenticated user.
https://developers.google.com/calendar

optional:
maxResults <integer> Maximum number of entries returned on one result page. By default the value is 100 entries. The page size can never be larger than 250 entries. Optional.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then.
If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries."
  ([] (settings-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/calendar/v3/users/me/settings",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.readonly"
        "https://www.googleapis.com/auth/calendar.settings.readonly"]})))

(defn settings-watch
  "Watch for changes to Settings resources.
https://developers.google.com/calendar

Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}

optional:
maxResults <integer> Maximum number of entries returned on one result page. By default the value is 100 entries. The page size can never be larger than 250 entries. Optional.
syncToken <string> Token obtained from the nextSyncToken field returned on the last page of results from the previous list request. It makes the result of this list request contain only entries that have changed since then.
If the syncToken expires, the server will respond with a 410 GONE response code and the client should clear its storage and perform a full synchronization without any syncToken.
Learn more about incremental synchronization.
Optional. The default is to return all entries."
  ([Channel] (settings-watch Channel nil))
  ([Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/calendar/v3/users/me/settings/watch",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/calendar"
        "https://www.googleapis.com/auth/calendar.readonly"
        "https://www.googleapis.com/auth/calendar.settings.readonly"],
       :body Channel})))

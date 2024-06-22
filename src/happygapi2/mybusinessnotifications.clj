(ns happygapi2.mybusinessnotifications
  "My Business Notifications API
The My Business Notification Settings API enables managing notification settings for business accounts. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
See: https://developers.google.com/my-business/"
  (:require [happy.oauth2.client :as client]))

(defn accounts-getNotificationSetting
  "Returns the pubsub notification settings for the account.
https://developers.google.com/my-business

name <string> Required. The resource name of the notification setting we are trying to fetch."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://mybusinessnotifications.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn accounts-updateNotificationSetting
  "Sets the pubsub notification setting for the account informing Google which topic to send pubsub notifications for. Use the notification_types field within notification_setting to manipulate the events an account wants to subscribe to. An account will only have one notification setting resource, and only one pubsub topic can be set. To delete the setting, update with an empty notification_types
https://developers.google.com/my-business

name <string> Required. The resource name this setting is for. This is of the form `accounts/{account_id}/notificationSetting`.
NotificationSetting:
{:name string,
 :pubsubTopic string,
 :notificationTypes
 [[NOTIFICATION_TYPE_UNSPECIFIED
   GOOGLE_UPDATE
   NEW_REVIEW
   UPDATED_REVIEW
   NEW_CUSTOMER_MEDIA
   NEW_QUESTION
   UPDATED_QUESTION
   NEW_ANSWER
   UPDATED_ANSWER
   DUPLICATE_LOCATION
   LOSS_OF_VOICE_OF_MERCHANT
   VOICE_OF_MERCHANT_UPDATED]]}

optional:
updateMask <string> Required. The specific fields that should be updated. The only editable field is notification_setting."
  ([name NotificationSetting]
    (accounts-updateNotificationSetting name NotificationSetting nil))
  ([name NotificationSetting optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://mybusinessnotifications.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body NotificationSetting})))

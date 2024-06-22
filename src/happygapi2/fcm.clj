(ns happygapi2.fcm
  "Firebase Cloud Messaging API
FCM send API that provides a cross-platform messaging solution to reliably deliver messages at no cost.
See: https://firebase.google.com/docs/cloud-messaging"
  (:require [happy.oauth2.client :as client]))

(defn projects-messages-send
  "Send a message to specified target (a registration token, topic or condition).
https://firebase.google.com/docs/cloud-messaging

parent <string> Required. It contains the Firebase project id (i.e. the unique identifier for your Firebase project), in the format of `projects/{project_id}`. For legacy support, the numeric project number with no padding is also supported in the format of `projects/{project_number}`.
SendMessageRequest:
{:validateOnly boolean,
 :message
 {:notification {:title string, :body string, :image string},
  :name string,
  :topic string,
  :token string,
  :webpush
  {:headers object,
   :data object,
   :notification object,
   :fcmOptions {:link string, :analyticsLabel string}},
  :android
  {:collapseKey string,
   :priority [NORMAL HIGH],
   :ttl string,
   :restrictedPackageName string,
   :data object,
   :notification
   {:sound string,
    :notificationCount integer,
    :color string,
    :bodyLocArgs [string],
    :titleLocArgs [string],
    :channelId string,
    :ticker string,
    :icon string,
    :bodyLocKey string,
    :bypassProxyNotification boolean,
    :title string,
    :localOnly boolean,
    :defaultSound boolean,
    :vibrateTimings [string],
    :titleLocKey string,
    :lightSettings
    {:color Color, :lightOnDuration string, :lightOffDuration string},
    :proxy [PROXY_UNSPECIFIED ALLOW DENY IF_PRIORITY_LOWERED],
    :sticky boolean,
    :clickAction string,
    :defaultLightSettings boolean,
    :image string,
    :eventTime string,
    :tag string,
    :defaultVibrateTimings boolean,
    :body string,
    :notificationPriority
    [PRIORITY_UNSPECIFIED
     PRIORITY_MIN
     PRIORITY_LOW
     PRIORITY_DEFAULT
     PRIORITY_HIGH
     PRIORITY_MAX],
    :visibility [VISIBILITY_UNSPECIFIED PRIVATE PUBLIC SECRET]},
   :fcmOptions {:analyticsLabel string},
   :directBootOk boolean},
  :condition string,
  :fcmOptions {:analyticsLabel string},
  :apns
  {:headers object,
   :payload object,
   :fcmOptions {:analyticsLabel string, :image string}},
  :data object}}"
  [parent SendMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://fcm.googleapis.com/v1/{+parent}/messages:send",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase.messaging"],
     :body SendMessageRequest}))

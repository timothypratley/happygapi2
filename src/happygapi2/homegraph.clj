(ns happygapi2.homegraph
  "HomeGraph API

See: https://developers.home.google.com/cloud-to-cloud/get-started"
  (:require [happy.oauth2.client :as client]))

(defn agentUsers-delete
  "Unlinks the given third-party user from your smart home Action. All data related to this user will be deleted. For more details on how users link their accounts, see [fulfillment and authentication](https://developers.home.google.com/cloud-to-cloud/primer/fulfillment). The third-party user's identity is passed in via the `agent_user_id` (see DeleteAgentUserRequest). This request must be authorized using service account credentials from your Actions console project.
https://developers.home.google.com/cloud-to-cloud/get-started

agentUserId <string> Required. Third-party user ID.

optional:
requestId <string> Request ID used for debugging."
  ([agentUserId] (agentUsers-delete agentUserId nil))
  ([agentUserId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://homegraph.googleapis.com/v1/{+agentUserId}",
       :uri-template-args {:agentUserId agentUserId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/homegraph"]})))

(defn devices-requestSync
  "Requests Google to send an `action.devices.SYNC` [intent](https://developers.home.google.com/cloud-to-cloud/intents/sync) to your smart home Action to update device metadata for the given user. The third-party user's identity is passed via the `agent_user_id` (see RequestSyncDevicesRequest). This request must be authorized using service account credentials from your Actions console project.
https://developers.home.google.com/cloud-to-cloud/get-started

RequestSyncDevicesRequest:
{:async boolean, :agentUserId string}"
  [RequestSyncDevicesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://homegraph.googleapis.com/v1/devices:requestSync",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/homegraph"],
     :body RequestSyncDevicesRequest}))

(defn devices-reportStateAndNotification
  "Reports device state and optionally sends device notifications. Called by your smart home Action when the state of a third-party device changes or you need to send a notification about the device. See [Implement Report State](https://developers.home.google.com/cloud-to-cloud/integration/report-state) for more information. This method updates the device state according to its declared [traits](https://developers.home.google.com/cloud-to-cloud/primer/device-types-and-traits). Publishing a new state value outside of these traits will result in an `INVALID_ARGUMENT` error response. The third-party user's identity is passed in via the `agent_user_id` (see ReportStateAndNotificationRequest). This request must be authorized using service account credentials from your Actions console project.
https://developers.home.google.com/cloud-to-cloud/get-started

ReportStateAndNotificationRequest:
{:payload {:devices {:notifications object, :states object}},
 :requestId string,
 :eventId string,
 :followUpToken string,
 :agentUserId string}"
  [ReportStateAndNotificationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://homegraph.googleapis.com/v1/devices:reportStateAndNotification",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/homegraph"],
     :body ReportStateAndNotificationRequest}))

(defn devices-sync
  "Gets all the devices associated with the given third-party user. The third-party user's identity is passed in via the `agent_user_id` (see SyncRequest). This request must be authorized using service account credentials from your Actions console project.
https://developers.home.google.com/cloud-to-cloud/get-started

SyncRequest:
{:agentUserId string, :requestId string}"
  [SyncRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://homegraph.googleapis.com/v1/devices:sync",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/homegraph"],
     :body SyncRequest}))

(defn devices-query
  "Gets the current states in Home Graph for the given set of the third-party user's devices. The third-party user's identity is passed in via the `agent_user_id` (see QueryRequest). This request must be authorized using service account credentials from your Actions console project.
https://developers.home.google.com/cloud-to-cloud/get-started

QueryRequest:
{:inputs [{:payload {:devices [{:id string}]}}],
 :agentUserId string,
 :requestId string}"
  [QueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://homegraph.googleapis.com/v1/devices:query",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/homegraph"],
     :body QueryRequest}))

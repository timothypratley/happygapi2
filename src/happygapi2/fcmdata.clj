(ns happygapi2.fcmdata
  "Firebase Cloud Messaging Data API
Provides additional information about Firebase Cloud Messaging (FCM) message sends and deliveries.
See: https://firebase.google.com/docs/cloud-messaging"
  (:require [happy.oauth2.client :as client]))

(defn projects-androidApps-deliveryData-list
  "List aggregate delivery data for the given Android application.
https://firebase.google.com/docs/cloud-messaging

parent <string> Required. The application for which to list delivery data. Format: `projects/{project_id}/androidApps/{app_id}`

optional:
pageSize <integer> The maximum number of entries to return. The service may return fewer than this value. If unspecified, at most 1,000 entries will be returned. The maximum value is 10,000; values above 10,000 will be capped to 10,000. This default may change over time."
  ([parent] (projects-androidApps-deliveryData-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://fcmdata.googleapis.com/v1beta1/{+parent}/deliveryData",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

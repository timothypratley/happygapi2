(ns happygapi2.driveactivity
  "Drive Activity API
Provides a historical view of activity in Google Drive.
See: https://developers.google.com/drive/activity/v2"
  (:require [happy.oauth2.client :as client]))

(defn activity-query
  "Query past activity in Google Drive.
https://developers.google.com/drive/activity/v2/reference/rest/v2/activity/query

QueryDriveActivityRequest:
{:itemName string,
 :ancestorName string,
 :consolidationStrategy {:none object, :legacy object},
 :pageSize integer,
 :pageToken string,
 :filter string}"
  [QueryDriveActivityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://driveactivity.googleapis.com/v2/activity:query",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.activity"
      "https://www.googleapis.com/auth/drive.activity.readonly"],
     :body QueryDriveActivityRequest}))

(ns happygapi2.groupsmigration
  "Groups Migration API
The Groups Migration API allows domain administrators to archive emails into Google groups.
See: https://developers.google.com/admin-sdk/groups-migration/v1/guides/overview"
  (:require [happy.oauth2.client :as client]))

(defn archive-insert
  "Inserts a new mail into the archive of the Google group.
https://developers.google.com/admin-sdk/groups-migration/v1/guides/overview

groupId <string> The group ID"
  [groupId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://groupsmigration.googleapis.com/groups/v1/groups/{groupId}/archive",
     :uri-template-args {:groupId groupId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/apps.groups.migration"]}))

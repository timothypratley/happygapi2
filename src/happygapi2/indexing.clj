(ns happygapi2.indexing
  "Web Search Indexing API
Notifies Google Web Search when your web pages change.
See: https://developers.google.com/search/apis/indexing-api/v3/quickstart"
  (:require [happy.oauth2.client :as client]))

(defn urlNotifications-publish
  "Notifies that a URL has been updated or deleted.
https://developers.google.com/search/apis/indexing-api/v3/quickstart

UrlNotification:
{:url string,
 :type [URL_NOTIFICATION_TYPE_UNSPECIFIED URL_UPDATED URL_DELETED],
 :notifyTime string}"
  [UrlNotification]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://indexing.googleapis.com/v3/urlNotifications:publish",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/indexing"],
     :body UrlNotification}))

(defn urlNotifications-getMetadata
  "Gets metadata about a Web Document. This method can _only_ be used to query URLs that were previously seen in successful Indexing API notifications. Includes the latest `UrlNotification` received via this API.
https://developers.google.com/search/apis/indexing-api/v3/quickstart

optional:
url <string> URL that is being queried."
  ([] (urlNotifications-getMetadata nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://indexing.googleapis.com/v3/urlNotifications/metadata",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/indexing"]})))

(ns happygapi2.chromeuxreport
  "Chrome UX Report API
The Chrome UX Report API lets you view real user experience data for millions of websites. 
See: https://developer.chrome.com/docs/crux/api/"
  (:require [happy.oauth2.client :as client]))

(defn records-queryRecord
  "Queries the Chrome User Experience for a single `record` for a given site. Returns a `record` that contains one or more `metrics` corresponding to performance data about the requested site.
https://developer.chrome.com/docs/crux/api

QueryRequest:
{:origin string,
 :url string,
 :effectiveConnectionType string,
 :formFactor [ALL_FORM_FACTORS PHONE DESKTOP TABLET],
 :metrics [string]}"
  [QueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromeuxreport.googleapis.com/v1/records:queryRecord",
     :uri-template-args {},
     :query-params {},
     :scopes nil,
     :body QueryRequest}))

(defn records-queryHistoryRecord
  "Queries the Chrome User Experience Report for a timeseries `history record` for a given site. Returns a `history record` that contains one or more `metric timeseries` corresponding to performance data about the requested site.
https://developer.chrome.com/docs/crux/api

QueryHistoryRequest:
{:origin string,
 :url string,
 :formFactor [ALL_FORM_FACTORS PHONE DESKTOP TABLET],
 :metrics [string]}"
  [QueryHistoryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://chromeuxreport.googleapis.com/v1/records:queryHistoryRecord",
     :uri-template-args {},
     :query-params {},
     :scopes nil,
     :body QueryHistoryRequest}))

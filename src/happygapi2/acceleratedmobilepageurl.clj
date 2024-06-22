(ns happygapi2.acceleratedmobilepageurl
  "Accelerated Mobile Pages (AMP) URL API
Retrieves the list of AMP URLs (and equivalent AMP Cache URLs) for a given list of public URL(s). 
See: https://developers.google.com/amp/cache/"
  (:require [happy.oauth2.client :as client]))

(defn ampUrls-batchGet
  "Returns AMP URL(s) and equivalent [AMP Cache URL(s)](/amp/cache/overview#amp-cache-url-format).
https://developers.google.com/amp/cache/reference/acceleratedmobilepageurl/rest/v1/ampUrls/batchGet

BatchGetAmpUrlsRequest:
{:urls [string], :lookupStrategy [FETCH_LIVE_DOC IN_INDEX_DOC]}"
  [BatchGetAmpUrlsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://acceleratedmobilepageurl.googleapis.com/v1/ampUrls:batchGet",
     :uri-template-args {},
     :query-params {},
     :scopes nil,
     :body BatchGetAmpUrlsRequest}))

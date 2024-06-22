(ns happygapi2.webfonts
  "Web Fonts Developer API
The Google Web Fonts Developer API lets you retrieve information about web fonts served by Google.
See: https://developers.google.com/fonts/docs/developer_api"
  (:require [happy.oauth2.client :as client]))

(defn webfonts-list
  "Retrieves the list of fonts currently served by the Google Fonts Developer API.
https://developers.google.com/fonts/docs/developer_api

optional:
sort <string> Enables sorting of the list.
capability <string> Controls the font urls in `Webfont.files`, by default, static ttf fonts are sent.
family <string> Filters by Webfont.family, using literal match. If not set, returns all families
subset <string> Filters by Webfont.subset, if subset is found in Webfont.subsets. If not set, returns all families."
  ([] (webfonts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://webfonts.googleapis.com/v1/webfonts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

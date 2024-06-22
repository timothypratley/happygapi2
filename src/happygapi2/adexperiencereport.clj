(ns happygapi2.adexperiencereport
  "Ad Experience Report API
Views Ad Experience Report data, and gets a list of sites that have a significant number of annoying ads.
See: https://developers.google.com/ad-experience-report/"
  (:require [happy.oauth2.client :as client]))

(defn sites-get
  "Gets a site's Ad Experience Report summary.
https://developers.google.com/ad-experience-report/v1/reference/rest/v1/sites/get

name <string> Required. The name of the site whose summary to get, e.g. `sites/http%3A%2F%2Fwww.google.com%2F`. Format: `sites/{site}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexperiencereport.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn violatingSites-list
  "Lists sites that are failing in the Ad Experience Report on at least one platform.
https://developers.google.com/ad-experience-report/v1/reference/rest/v1/violatingSites/list"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://adexperiencereport.googleapis.com/v1/violatingSites",
     :uri-template-args {},
     :query-params {},
     :scopes nil}))

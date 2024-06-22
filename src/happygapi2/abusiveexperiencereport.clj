(ns happygapi2.abusiveexperiencereport
  "Abusive Experience Report API
Views Abusive Experience Report data, and gets a list of sites that have a significant number of abusive experiences.
See: https://developers.google.com/abusive-experience-report/"
  (:require [happy.oauth2.client :as client]))

(defn sites-get
  "Gets a site's Abusive Experience Report summary.
https://developers.google.com/abusive-experience-report/v1/reference/rest/v1/sites/get

name <string> Required. The name of the site whose summary to get, e.g. `sites/http%3A%2F%2Fwww.google.com%2F`. Format: `sites/{site}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://abusiveexperiencereport.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn violatingSites-list
  "Lists sites that are failing in the Abusive Experience Report.
https://developers.google.com/abusive-experience-report/v1/reference/rest/v1/violatingSites/list"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://abusiveexperiencereport.googleapis.com/v1/violatingSites",
     :uri-template-args {},
     :query-params {},
     :scopes nil}))

(ns happygapi2.discovery
  "API Discovery Service
Provides information about other Google APIs, such as what APIs are available, the resource, and method details for each API.
See: https://developers.google.com/discovery/"
  (:require [happy.oauth2.client :as client]))

(defn apis-list
  "Retrieve the list of APIs supported at this endpoint.
https://developers.google.com/discovery

optional:
preferred <boolean> Return only the preferred version of an API.
name <string> Only include APIs with the given name."
  ([] (apis-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://www.googleapis.com/discovery/v1/apis",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

(defn apis-getRest
  "Retrieve the description of a particular version of an api.
https://developers.google.com/discovery

api <string> The name of the API.
version <string> The version of the API."
  [api version]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/discovery/v1/apis/{api}/{version}/rest",
     :uri-template-args {:api api, :version version},
     :query-params {},
     :scopes nil}))

(ns happygapi2.oauth2
  "Google OAuth2 API
Obtains end-user authorization grants for use with other Google APIs.
See: https://developers.google.com/identity/protocols/oauth2/"
  (:require [happy.oauth2.client :as client]))

(defn userinfo-get
  "
https://developers.google.com/identity/protocols/oauth2"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://www.googleapis.com/oauth2/v2/userinfo",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["openid"
      "https://www.googleapis.com/auth/userinfo.email"
      "https://www.googleapis.com/auth/userinfo.profile"]}))

(defn userinfo-v2-me-get
  "
https://developers.google.com/identity/protocols/oauth2"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://www.googleapis.com/userinfo/v2/me",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["openid"
      "https://www.googleapis.com/auth/userinfo.email"
      "https://www.googleapis.com/auth/userinfo.profile"]}))

(ns happygapi2.playcustomapp
  "Google Play Custom App Publishing API
API to create and publish custom Android apps
See: https://developers.google.com/android/work/play/custom-app-api/"
  (:require [happy.oauth2.client :as client]))

(defn accounts-customApps-create
  "Creates a new custom app.
https://developers.google.com/android/work/play/custom-app-api

account <string> Developer account ID.
CustomApp:
{:organizations [{:organizationName string, :organizationId string}],
 :packageName string,
 :title string,
 :languageCode string}"
  [account CustomApp]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playcustomapp.googleapis.com/playcustomapp/v1/accounts/{account}/customApps",
     :uri-template-args {:account account},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/androidpublisher"],
     :body CustomApp}))

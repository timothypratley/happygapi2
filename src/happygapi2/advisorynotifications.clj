(ns happygapi2.advisorynotifications
  "Advisory Notifications API
An API for accessing Advisory Notifications in Google Cloud
See: https://cloud.google.com/advisory-notifications/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-getSettings
  "Get notification settings.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/projects.locations/getSettings

name <string> Required. The resource name of the settings to retrieve. Format: organizations/{organization}/locations/{location}/settings or projects/{projects}/locations/{location}/settings."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://advisorynotifications.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-updateSettings
  "Update notification settings.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/projects.locations/updateSettings

name <string> Identifier. The resource name of the settings to retrieve. Format: organizations/{organization}/locations/{location}/settings or projects/{projects}/locations/{location}/settings.
GoogleCloudAdvisorynotificationsV1Settings:
{:name string, :notificationSettings object, :etag string}"
  [name GoogleCloudAdvisorynotificationsV1Settings]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://advisorynotifications.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAdvisorynotificationsV1Settings}))

(defn projects-locations-notifications-get
  "Gets a notification.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/projects.locations.notifications/get

name <string> Required. A name of the notification to retrieve. Format: organizations/{organization}/locations/{location}/notifications/{notification} or projects/{projects}/locations/{location}/notifications/{notification}.

optional:
languageCode <string> ISO code for requested localization language. If unset, will be interpereted as \"en\". If the requested language is valid, but not supported for this notification, English will be returned with an \"Not applicable\" LocalizationState. If the ISO code is invalid (i.e. not a real language), this RPC will throw an error."
  ([name] (projects-locations-notifications-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://advisorynotifications.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notifications-list
  "Lists notifications under a given parent.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/projects.locations.notifications/list

parent <string> Required. The parent, which owns this collection of notifications. Must be of the form \"organizations/{organization}/locations/{location}\" or \"projects/{project}/locations/{location}\".

optional:
view <string> Specifies which parts of the notification resource should be returned in the response.
pageSize <integer> The maximum number of notifications to return. The service may return fewer than this value. If unspecified or equal to 0, at most 50 notifications will be returned. The maximum value is 50; values above 50 will be coerced to 50.
languageCode <string> ISO code for requested localization language. If unset, will be interpereted as \"en\". If the requested language is valid, but not supported for this notification, English will be returned with an \"Not applicable\" LocalizationState. If the ISO code is invalid (i.e. not a real language), this RPC will throw an error."
  ([parent] (projects-locations-notifications-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://advisorynotifications.googleapis.com/v1/{+parent}/notifications",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-updateSettings
  "Update notification settings.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/organizations.locations/updateSettings

name <string> Identifier. The resource name of the settings to retrieve. Format: organizations/{organization}/locations/{location}/settings or projects/{projects}/locations/{location}/settings.
GoogleCloudAdvisorynotificationsV1Settings:
{:name string, :notificationSettings object, :etag string}"
  [name GoogleCloudAdvisorynotificationsV1Settings]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://advisorynotifications.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAdvisorynotificationsV1Settings}))

(defn organizations-locations-getSettings
  "Get notification settings.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/organizations.locations/getSettings

name <string> Required. The resource name of the settings to retrieve. Format: organizations/{organization}/locations/{location}/settings or projects/{projects}/locations/{location}/settings."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://advisorynotifications.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-notifications-get
  "Gets a notification.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/organizations.locations.notifications/get

name <string> Required. A name of the notification to retrieve. Format: organizations/{organization}/locations/{location}/notifications/{notification} or projects/{projects}/locations/{location}/notifications/{notification}.

optional:
languageCode <string> ISO code for requested localization language. If unset, will be interpereted as \"en\". If the requested language is valid, but not supported for this notification, English will be returned with an \"Not applicable\" LocalizationState. If the ISO code is invalid (i.e. not a real language), this RPC will throw an error."
  ([name] (organizations-locations-notifications-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://advisorynotifications.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-notifications-list
  "Lists notifications under a given parent.
https://cloud.google.com/advisory-notifications/docs/reference/rest/v1/organizations.locations.notifications/list

parent <string> Required. The parent, which owns this collection of notifications. Must be of the form \"organizations/{organization}/locations/{location}\" or \"projects/{project}/locations/{location}\".

optional:
view <string> Specifies which parts of the notification resource should be returned in the response.
pageSize <integer> The maximum number of notifications to return. The service may return fewer than this value. If unspecified or equal to 0, at most 50 notifications will be returned. The maximum value is 50; values above 50 will be coerced to 50.
languageCode <string> ISO code for requested localization language. If unset, will be interpereted as \"en\". If the requested language is valid, but not supported for this notification, English will be returned with an \"Not applicable\" LocalizationState. If the ISO code is invalid (i.e. not a real language), this RPC will throw an error."
  ([parent] (organizations-locations-notifications-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://advisorynotifications.googleapis.com/v1/{+parent}/notifications",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

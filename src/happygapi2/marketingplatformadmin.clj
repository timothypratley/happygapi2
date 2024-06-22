(ns happygapi2.marketingplatformadmin
  "Google Marketing Platform Admin API
The Google Marketing Platform Admin API allows for programmatic access to the Google Marketing Platform configuration data. You can use the Google Marketing Platform Admin API to manage links between your Google Marketing Platform organization and Google Analytics accounts, and to set the service level of your GA4 properties.
See: https://developers.google.com/marketing-platform/devguides/api/admin/v1"
  (:require [happy.oauth2.client :as client]))

(defn organizations-get
  "Lookup for a single organization.
https://developers.google.com/marketing-platform/devguides/api/admin/v1

name <string> Required. The name of the Organization to retrieve. Format: organizations/{org_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://marketingplatformadmin.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.read"
      "https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"]}))

(defn organizations-analyticsAccountLinks-delete
  "Deletes the AnalyticsAccountLink, which detaches the Analytics account from the Google Marketing Platform organization. User needs to be an org user, and admin on the Analytics account in order to delete the link.
https://developers.google.com/marketing-platform/devguides/api/admin/v1

name <string> Required. The name of the Analytics account link to delete. Format: organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://marketingplatformadmin.googleapis.com/v1alpha/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"]}))

(defn organizations-analyticsAccountLinks-setPropertyServiceLevel
  "Updates the service level for an Analytics property.
https://developers.google.com/marketing-platform/devguides/api/admin/v1

analyticsAccountLink <string> Required. The parent AnalyticsAccountLink scope where this property is in. Format: organizations/{org_id}/analyticsAccountLinks/{analytics_account_link_id}
SetPropertyServiceLevelRequest:
{:serviceLevel
 [ANALYTICS_SERVICE_LEVEL_UNSPECIFIED
  ANALYTICS_SERVICE_LEVEL_STANDARD
  ANALYTICS_SERVICE_LEVEL_360],
 :analyticsProperty string}"
  [analyticsAccountLink SetPropertyServiceLevelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://marketingplatformadmin.googleapis.com/v1alpha/{+analyticsAccountLink}:setPropertyServiceLevel",
     :uri-template-args {:analyticsAccountLink analyticsAccountLink},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"],
     :body SetPropertyServiceLevelRequest}))

(defn organizations-analyticsAccountLinks-list
  "Lists the Google Analytics accounts link to the specified Google Marketing Platform organization.
https://developers.google.com/marketing-platform/devguides/api/admin/v1

parent <string> Required. The parent organization, which owns this collection of Analytics account links. Format: organizations/{org_id}

optional:
pageSize <integer> Optional. The maximum number of Analytics account links to return in one call. The service may return fewer than this value. If unspecified, at most 50 Analytics account links will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (organizations-analyticsAccountLinks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://marketingplatformadmin.googleapis.com/v1alpha/{+parent}/analyticsAccountLinks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.read"
        "https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"]})))

(defn organizations-analyticsAccountLinks-create
  "Creates the link between the Analytics account and the Google Marketing Platform organization. User needs to be an org user, and admin on the Analytics account to create the link. If the account is already linked to an organization, user needs to unlink the account from the current organization, then try link again.
https://developers.google.com/marketing-platform/devguides/api/admin/v1

parent <string> Required. The parent resource where this Analytics account link will be created. Format: organizations/{org_id}
AnalyticsAccountLink:
{:displayName string,
 :name string,
 :analyticsAccount string,
 :linkVerificationState
 [LINK_VERIFICATION_STATE_UNSPECIFIED
  LINK_VERIFICATION_STATE_VERIFIED
  LINK_VERIFICATION_STATE_NOT_VERIFIED]}"
  [parent AnalyticsAccountLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://marketingplatformadmin.googleapis.com/v1alpha/{+parent}/analyticsAccountLinks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/marketingplatformadmin.analytics.update"],
     :body AnalyticsAccountLink}))

(ns happygapi2.playgrouping
  "Google Play Grouping API
playgrouping.googleapis.com API.
See: https://cloud.google.com/playgrouping/"
  (:require [happy.oauth2.client :as client]))

(defn apps-tokens-verify
  "Verify an API token by asserting the app and persona it belongs to. The verification is a protection against client-side attacks and will fail if the contents of the token don't match the provided values. A token must be verified before it can be used to manipulate user tags.
https://cloud.google.com/playgrouping

appPackage <string> Required. App the token belongs to. Format: apps/{package_name}
token <string> Required. The token to be verified. Format: tokens/{token}
VerifyTokenRequest:
{:persona string}"
  [appPackage token VerifyTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playgrouping.googleapis.com/v1alpha1/{+appPackage}/{+token}:verify",
     :uri-template-args {:appPackage appPackage, :token token},
     :query-params {},
     :scopes nil,
     :body VerifyTokenRequest}))

(defn apps-tokens-tags-createOrUpdate
  "Create or update tags for the user and app that are represented by the given token.
https://cloud.google.com/playgrouping

appPackage <string> Required. App whose tags are being manipulated. Format: apps/{package_name}
token <string> Required. Token for which the tags are being inserted or updated. Format: tokens/{token}
CreateOrUpdateTagsRequest:
{:tags
 [{:key string,
   :booleanValue boolean,
   :int64Value string,
   :stringValue string,
   :timeValue string}]}"
  [appPackage token CreateOrUpdateTagsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playgrouping.googleapis.com/v1alpha1/{+appPackage}/{+token}/tags:createOrUpdate",
     :uri-template-args {:appPackage appPackage, :token token},
     :query-params {},
     :scopes nil,
     :body CreateOrUpdateTagsRequest}))

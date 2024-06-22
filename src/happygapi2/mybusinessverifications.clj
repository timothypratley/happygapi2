(ns happygapi2.mybusinessverifications
  "My Business Verifications API
The My Business Verifications API provides an interface for taking verifications related actions for locations.
See: https://developers.google.com/my-business/"
  (:require [happy.oauth2.client :as client]))

(defn locations-getVoiceOfMerchantState
  "Gets the VoiceOfMerchant state.
https://developers.google.com/my-business

name <string> Required. Resource name of the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://mybusinessverifications.googleapis.com/v1/{+name}/VoiceOfMerchantState",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn locations-fetchVerificationOptions
  "Reports all eligible verification options for a location in a specific language.
https://developers.google.com/my-business

location <string> Required. The location to verify.
FetchVerificationOptionsRequest:
{:languageCode string,
 :context
 {:address
  {:sortingCode string,
   :locality string,
   :revision integer,
   :administrativeArea string,
   :addressLines [string],
   :organization string,
   :recipients [string],
   :languageCode string,
   :regionCode string,
   :postalCode string,
   :sublocality string}}}"
  [location FetchVerificationOptionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessverifications.googleapis.com/v1/{+location}:fetchVerificationOptions",
     :uri-template-args {:location location},
     :query-params {},
     :scopes nil,
     :body FetchVerificationOptionsRequest}))

(defn locations-verify
  "Starts the verification process for a location.
https://developers.google.com/my-business

name <string> Required. Resource name of the location to verify.
VerifyLocationRequest:
{:method
 [VERIFICATION_METHOD_UNSPECIFIED
  ADDRESS
  EMAIL
  PHONE_CALL
  SMS
  AUTO
  VETTED_PARTNER],
 :languageCode string,
 :emailAddress string,
 :mailerContact string,
 :phoneNumber string,
 :token {:tokenString string},
 :context
 {:address
  {:sortingCode string,
   :locality string,
   :revision integer,
   :administrativeArea string,
   :addressLines [string],
   :organization string,
   :recipients [string],
   :languageCode string,
   :regionCode string,
   :postalCode string,
   :sublocality string}}}"
  [name VerifyLocationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessverifications.googleapis.com/v1/{+name}:verify",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil,
     :body VerifyLocationRequest}))

(defn locations-verifications-complete
  "Completes a `PENDING` verification. It is only necessary for non `AUTO` verification methods. `AUTO` verification request is instantly `VERIFIED` upon creation.
https://developers.google.com/my-business

name <string> Required. Resource name of the verification to complete.
CompleteVerificationRequest:
{:pin string}"
  [name CompleteVerificationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://mybusinessverifications.googleapis.com/v1/{+name}:complete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil,
     :body CompleteVerificationRequest}))

(defn locations-verifications-list
  "List verifications of a location, ordered by create time.
https://developers.google.com/my-business

parent <string> Required. Resource name of the location that verification requests belong to.

optional:
pageSize <integer> How many verification to include per page. Minimum is 1, and the default and maximum page size is 100."
  ([parent] (locations-verifications-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://mybusinessverifications.googleapis.com/v1/{+parent}/verifications",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

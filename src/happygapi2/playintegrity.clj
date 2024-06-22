(ns happygapi2.playintegrity
  "Google Play Integrity API
The Play Integrity API helps you check that you're interacting with your genuine app on a genuine Android device powered by Google Play services. The Play Integrity API has replaced SafetyNet Attestation and Android Device Verification.
See: https://developer.android.com/google/play/integrity"
  (:require [happy.oauth2.client :as client]))

(defn decodeIntegrityToken
  "Decodes the integrity token and returns the token payload.
https://developer.android.com/google/play/integrity

packageName <string>  Package name of the app the attached integrity token belongs to.
DecodeIntegrityTokenRequest:
{:integrityToken string}"
  [packageName DecodeIntegrityTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://playintegrity.googleapis.com/v1/{+packageName}:decodeIntegrityToken",
     :uri-template-args {:packageName packageName},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/playintegrity"],
     :body DecodeIntegrityTokenRequest}))

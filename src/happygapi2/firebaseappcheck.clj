(ns happygapi2.firebaseappcheck
  "Firebase App Check API
Firebase App Check works alongside other Firebase services to help protect your backend resources from abuse, such as billing fraud or phishing.
See: https://firebase.google.com/docs/app-check"
  (:require [happy.oauth2.client :as client]))

(defn oauthClients-exchangeDebugToken
  "Validates a debug token secret that you have previously created using CreateDebugToken. If valid, returns an AppCheckToken. Note that a restrictive quota is enforced on this method to prevent accidental exposure of the app to abuse.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeDebugTokenRequest:
{:debugToken string, :limitedUse boolean}"
  [app GoogleFirebaseAppcheckV1ExchangeDebugTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeDebugToken",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeDebugTokenRequest}))

(defn oauthClients-exchangeAppAttestAttestation
  "Accepts an App Attest CBOR attestation and verifies it with Apple using your preconfigured team and bundle IDs. If valid, returns an attestation artifact that can later be exchanged for an AppCheckToken using ExchangeAppAttestAssertion. For convenience and performance, this method's response object will also contain an AppCheckToken (if the verification is successful).
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the iOS app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeAppAttestAttestationRequest:
{:limitedUse boolean,
 :keyId string,
 :challenge string,
 :attestationStatement string}"
  [app GoogleFirebaseAppcheckV1ExchangeAppAttestAttestationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeAppAttestAttestation",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body
     GoogleFirebaseAppcheckV1ExchangeAppAttestAttestationRequest}))

(defn oauthClients-exchangeAppAttestAssertion
  "Accepts an App Attest assertion and an artifact previously obtained from ExchangeAppAttestAttestation and verifies those with Apple. If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the iOS app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeAppAttestAssertionRequest:
{:assertion string,
 :challenge string,
 :artifact string,
 :limitedUse boolean}"
  [app GoogleFirebaseAppcheckV1ExchangeAppAttestAssertionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeAppAttestAssertion",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeAppAttestAssertionRequest}))

(defn oauthClients-generateAppAttestChallenge
  "Generates a challenge that protects the integrity of an immediately following call to ExchangeAppAttestAttestation or ExchangeAppAttestAssertion. A challenge should not be reused for multiple calls.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the iOS app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1GenerateAppAttestChallengeRequest:
object"
  [app GoogleFirebaseAppcheckV1GenerateAppAttestChallengeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:generateAppAttestChallenge",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1GenerateAppAttestChallengeRequest}))

(defn jwks-get
  "Returns a public JWK set as specified by [RFC 7517](https://tools.ietf.org/html/rfc7517) that can be used to verify App Check tokens. Exactly one of the public keys in the returned set will successfully validate any App Check token that is currently valid.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name to the public JWK set. Must always be exactly the string `jwks`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-generateAppAttestChallenge
  "Generates a challenge that protects the integrity of an immediately following call to ExchangeAppAttestAttestation or ExchangeAppAttestAssertion. A challenge should not be reused for multiple calls.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the iOS app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1GenerateAppAttestChallengeRequest:
object"
  [app GoogleFirebaseAppcheckV1GenerateAppAttestChallengeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:generateAppAttestChallenge",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1GenerateAppAttestChallengeRequest}))

(defn projects-apps-exchangeDeviceCheckToken
  "Accepts a [`device_token`](https://developer.apple.com/documentation/devicecheck/dcdevice) issued by DeviceCheck, and attempts to validate it with Apple. If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the iOS app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeDeviceCheckTokenRequest:
{:deviceToken string, :limitedUse boolean}"
  [app GoogleFirebaseAppcheckV1ExchangeDeviceCheckTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeDeviceCheckToken",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeDeviceCheckTokenRequest}))

(defn projects-apps-exchangeDebugToken
  "Validates a debug token secret that you have previously created using CreateDebugToken. If valid, returns an AppCheckToken. Note that a restrictive quota is enforced on this method to prevent accidental exposure of the app to abuse.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeDebugTokenRequest:
{:debugToken string, :limitedUse boolean}"
  [app GoogleFirebaseAppcheckV1ExchangeDebugTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeDebugToken",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeDebugTokenRequest}))

(defn projects-apps-exchangePlayIntegrityToken
  "Validates an [integrity verdict response token from Play Integrity](https://developer.android.com/google/play/integrity/verdict#decrypt-verify). If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the Android app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangePlayIntegrityTokenRequest:
{:limitedUse boolean, :playIntegrityToken string}"
  [app GoogleFirebaseAppcheckV1ExchangePlayIntegrityTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangePlayIntegrityToken",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangePlayIntegrityTokenRequest}))

(defn projects-apps-generatePlayIntegrityChallenge
  "Generates a challenge that protects the integrity of an immediately following integrity verdict request to the Play Integrity API. The next call to ExchangePlayIntegrityToken using the resulting integrity token will verify the presence and validity of the challenge. A challenge should not be reused for multiple calls.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1GeneratePlayIntegrityChallengeRequest:
object"
  [app GoogleFirebaseAppcheckV1GeneratePlayIntegrityChallengeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:generatePlayIntegrityChallenge",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body
     GoogleFirebaseAppcheckV1GeneratePlayIntegrityChallengeRequest}))

(defn projects-apps-exchangeRecaptchaV3Token
  "Validates a [reCAPTCHA v3 response token](https://developers.google.com/recaptcha/docs/v3). If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the web app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeRecaptchaV3TokenRequest:
{:limitedUse boolean, :recaptchaV3Token string}"
  [app GoogleFirebaseAppcheckV1ExchangeRecaptchaV3TokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeRecaptchaV3Token",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeRecaptchaV3TokenRequest}))

(defn projects-apps-exchangeSafetyNetToken
  "Validates a [SafetyNet token](https://developer.android.com/training/safetynet/attestation#request-attestation-step). If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the Android app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeSafetyNetTokenRequest:
{:safetyNetToken string}"
  [app GoogleFirebaseAppcheckV1ExchangeSafetyNetTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeSafetyNetToken",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeSafetyNetTokenRequest}))

(defn projects-apps-exchangeCustomToken
  "Validates a custom token signed using your project's Admin SDK service account credentials. If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeCustomTokenRequest:
{:customToken string, :limitedUse boolean}"
  [app GoogleFirebaseAppcheckV1ExchangeCustomTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeCustomToken",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeCustomTokenRequest}))

(defn projects-apps-exchangeAppAttestAssertion
  "Accepts an App Attest assertion and an artifact previously obtained from ExchangeAppAttestAttestation and verifies those with Apple. If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the iOS app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeAppAttestAssertionRequest:
{:assertion string,
 :challenge string,
 :artifact string,
 :limitedUse boolean}"
  [app GoogleFirebaseAppcheckV1ExchangeAppAttestAssertionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeAppAttestAssertion",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1ExchangeAppAttestAssertionRequest}))

(defn projects-apps-exchangeAppAttestAttestation
  "Accepts an App Attest CBOR attestation and verifies it with Apple using your preconfigured team and bundle IDs. If valid, returns an attestation artifact that can later be exchanged for an AppCheckToken using ExchangeAppAttestAssertion. For convenience and performance, this method's response object will also contain an AppCheckToken (if the verification is successful).
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the iOS app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeAppAttestAttestationRequest:
{:limitedUse boolean,
 :keyId string,
 :challenge string,
 :attestationStatement string}"
  [app GoogleFirebaseAppcheckV1ExchangeAppAttestAttestationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeAppAttestAttestation",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body
     GoogleFirebaseAppcheckV1ExchangeAppAttestAttestationRequest}))

(defn projects-apps-exchangeRecaptchaEnterpriseToken
  "Validates a [reCAPTCHA Enterprise response token](https://cloud.google.com/recaptcha-enterprise/docs/create-assessment#retrieve_token). If valid, returns an AppCheckToken.
https://firebase.google.com/docs/app-check

app <string> Required. The relative resource name of the web app, in the format: ``` projects/{project_number}/apps/{app_id} ``` If necessary, the `project_number` element can be replaced with the project ID of the Firebase project. Learn more about using project identifiers in Google's [AIP 2510](https://google.aip.dev/cloud/2510) standard.
GoogleFirebaseAppcheckV1ExchangeRecaptchaEnterpriseTokenRequest:
{:recaptchaEnterpriseToken string, :limitedUse boolean}"
  [app GoogleFirebaseAppcheckV1ExchangeRecaptchaEnterpriseTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+app}:exchangeRecaptchaEnterpriseToken",
     :uri-template-args {:app app},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body
     GoogleFirebaseAppcheckV1ExchangeRecaptchaEnterpriseTokenRequest}))

(defn projects-apps-debugTokens-create
  "Creates a new DebugToken for the specified app. For security reasons, after the creation operation completes, the `token` field cannot be updated or retrieved, but you can revoke the debug token using DeleteDebugToken. Each app can have a maximum of 20 debug tokens.
https://firebase.google.com/docs/app-check

parent <string> Required. The relative resource name of the parent app in which the specified DebugToken will be created, in the format: ``` projects/{project_number}/apps/{app_id} ```
GoogleFirebaseAppcheckV1DebugToken:
{:displayName string, :name string, :updateTime string, :token string}"
  [parent GoogleFirebaseAppcheckV1DebugToken]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+parent}/debugTokens",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1DebugToken}))

(defn projects-apps-debugTokens-list
  "Lists all DebugTokens for the specified app. For security reasons, the `token` field is never populated in the response.
https://firebase.google.com/docs/app-check

parent <string> Required. The relative resource name of the parent app for which to list each associated DebugToken, in the format: ``` projects/{project_number}/apps/{app_id} ```

optional:
pageSize <integer> The maximum number of DebugTokens to return in the response. Note that an app can have at most 20 debug tokens. The server may return fewer than this at its own discretion. If no value is specified (or too large a value is specified), the server will impose its own limit."
  ([parent] (projects-apps-debugTokens-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/debugTokens",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-apps-debugTokens-get
  "Gets the specified DebugToken. For security reasons, the `token` field is never populated in the response.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the debug token, in the format: ``` projects/{project_number}/apps/{app_id}/debugTokens/{debug_token_id} ```"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-debugTokens-patch
  "Updates the specified DebugToken. For security reasons, the `token` field cannot be updated, nor will it be populated in the response, but you can revoke the debug token using DeleteDebugToken.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the debug token, in the format: ``` projects/{project_number}/apps/{app_id}/debugTokens/{debug_token_id} ```
GoogleFirebaseAppcheckV1DebugToken:
{:displayName string, :name string, :updateTime string, :token string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the DebugToken to update. Example: `display_name`."
  ([name GoogleFirebaseAppcheckV1DebugToken]
    (projects-apps-debugTokens-patch
      name
      GoogleFirebaseAppcheckV1DebugToken
      nil))
  ([name GoogleFirebaseAppcheckV1DebugToken optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1DebugToken})))

(defn projects-apps-debugTokens-delete
  "Deletes the specified DebugToken. A deleted debug token cannot be used to exchange for an App Check token. Use this method when you suspect the secret `token` has been compromised or when you no longer need the debug token.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the DebugToken to delete, in the format: ``` projects/{project_number}/apps/{app_id}/debugTokens/{debug_token_id} ```"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-safetyNetConfig-get
  "Gets the SafetyNetConfig for the specified app.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the SafetyNetConfig, in the format: ``` projects/{project_number}/apps/{app_id}/safetyNetConfig ```"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-safetyNetConfig-batchGet
  "Atomically gets the SafetyNetConfigs for the specified list of apps.
https://firebase.google.com/docs/app-check

parent <string> Required. The parent project name shared by all SafetyNetConfigs being retrieved, in the format ``` projects/{project_number} ``` The parent collection in the `name` field of any resource being retrieved must match this field, or the entire batch fails.

optional:
names <string> Required. The relative resource names of the SafetyNetConfigs to retrieve, in the format ``` projects/{project_number}/apps/{app_id}/safetyNetConfig ``` A maximum of 100 objects can be retrieved in a batch."
  ([parent] (projects-apps-safetyNetConfig-batchGet parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/apps/-/safetyNetConfig:batchGet",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-apps-safetyNetConfig-patch
  "Updates the SafetyNetConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange SafetyNet tokens for App Check tokens.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the SafetyNet configuration object, in the format: ``` projects/{project_number}/apps/{app_id}/safetyNetConfig ```
GoogleFirebaseAppcheckV1SafetyNetConfig:
{:tokenTtl string, :name string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the SafetyNetConfig to update. Example: `token_ttl`."
  ([name GoogleFirebaseAppcheckV1SafetyNetConfig]
    (projects-apps-safetyNetConfig-patch
      name
      GoogleFirebaseAppcheckV1SafetyNetConfig
      nil))
  ([name GoogleFirebaseAppcheckV1SafetyNetConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1SafetyNetConfig})))

(defn projects-apps-recaptchaV3Config-get
  "Gets the RecaptchaV3Config for the specified app. For security reasons, the `site_secret` field is never populated in the response.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the RecaptchaV3Config, in the format: ``` projects/{project_number}/apps/{app_id}/recaptchaV3Config ```"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-recaptchaV3Config-batchGet
  "Atomically gets the RecaptchaV3Configs for the specified list of apps. For security reasons, the `site_secret` field is never populated in the response.
https://firebase.google.com/docs/app-check

parent <string> Required. The parent project name shared by all RecaptchaV3Configs being retrieved, in the format ``` projects/{project_number} ``` The parent collection in the `name` field of any resource being retrieved must match this field, or the entire batch fails.

optional:
names <string> Required. The relative resource names of the RecaptchaV3Configs to retrieve, in the format: ``` projects/{project_number}/apps/{app_id}/recaptchaV3Config ``` A maximum of 100 objects can be retrieved in a batch."
  ([parent] (projects-apps-recaptchaV3Config-batchGet parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/apps/-/recaptchaV3Config:batchGet",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-apps-recaptchaV3Config-patch
  "Updates the RecaptchaV3Config for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange reCAPTCHA V3 tokens for App Check tokens. For security reasons, the `site_secret` field is never populated in the response.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the reCAPTCHA v3 configuration object, in the format: ``` projects/{project_number}/apps/{app_id}/recaptchaV3Config ```
GoogleFirebaseAppcheckV1RecaptchaV3Config:
{:name string,
 :siteSecretSet boolean,
 :tokenTtl string,
 :siteSecret string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the RecaptchaV3Config to update. Example: `site_secret`."
  ([name GoogleFirebaseAppcheckV1RecaptchaV3Config]
    (projects-apps-recaptchaV3Config-patch
      name
      GoogleFirebaseAppcheckV1RecaptchaV3Config
      nil))
  ([name GoogleFirebaseAppcheckV1RecaptchaV3Config optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1RecaptchaV3Config})))

(defn projects-apps-deviceCheckConfig-patch
  "Updates the DeviceCheckConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange DeviceCheck tokens for App Check tokens. For security reasons, the `private_key` field is never populated in the response.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the DeviceCheck configuration object, in the format: ``` projects/{project_number}/apps/{app_id}/deviceCheckConfig ```
GoogleFirebaseAppcheckV1DeviceCheckConfig:
{:privateKeySet boolean,
 :keyId string,
 :privateKey string,
 :tokenTtl string,
 :name string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the DeviceCheckConfig to update. Example: `key_id,private_key`."
  ([name GoogleFirebaseAppcheckV1DeviceCheckConfig]
    (projects-apps-deviceCheckConfig-patch
      name
      GoogleFirebaseAppcheckV1DeviceCheckConfig
      nil))
  ([name GoogleFirebaseAppcheckV1DeviceCheckConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1DeviceCheckConfig})))

(defn projects-apps-deviceCheckConfig-get
  "Gets the DeviceCheckConfig for the specified app. For security reasons, the `private_key` field is never populated in the response.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the DeviceCheckConfig, in the format: ``` projects/{project_number}/apps/{app_id}/deviceCheckConfig ```"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-deviceCheckConfig-batchGet
  "Atomically gets the DeviceCheckConfigs for the specified list of apps. For security reasons, the `private_key` field is never populated in the response.
https://firebase.google.com/docs/app-check

parent <string> Required. The parent project name shared by all DeviceCheckConfigs being retrieved, in the format ``` projects/{project_number} ``` The parent collection in the `name` field of any resource being retrieved must match this field, or the entire batch fails.

optional:
names <string> Required. The relative resource names of the DeviceCheckConfigs to retrieve, in the format ``` projects/{project_number}/apps/{app_id}/deviceCheckConfig ``` A maximum of 100 objects can be retrieved in a batch."
  ([parent] (projects-apps-deviceCheckConfig-batchGet parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/apps/-/deviceCheckConfig:batchGet",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-apps-playIntegrityConfig-patch
  "Updates the PlayIntegrityConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange Play Integrity tokens for App Check tokens.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the Play Integrity configuration object, in the format: ``` projects/{project_number}/apps/{app_id}/playIntegrityConfig ```
GoogleFirebaseAppcheckV1PlayIntegrityConfig:
{:tokenTtl string, :name string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the PlayIntegrityConfig to update. Example: `token_ttl`."
  ([name GoogleFirebaseAppcheckV1PlayIntegrityConfig]
    (projects-apps-playIntegrityConfig-patch
      name
      GoogleFirebaseAppcheckV1PlayIntegrityConfig
      nil))
  ([name GoogleFirebaseAppcheckV1PlayIntegrityConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1PlayIntegrityConfig})))

(defn projects-apps-playIntegrityConfig-get
  "Gets the PlayIntegrityConfig for the specified app.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the PlayIntegrityConfig, in the format: ``` projects/{project_number}/apps/{app_id}/playIntegrityConfig ```"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-playIntegrityConfig-batchGet
  "Atomically gets the PlayIntegrityConfigs for the specified list of apps.
https://firebase.google.com/docs/app-check

parent <string> Required. The parent project name shared by all PlayIntegrityConfigs being retrieved, in the format ``` projects/{project_number} ``` The parent collection in the `name` field of any resource being retrieved must match this field, or the entire batch fails.

optional:
names <string> Required. The relative resource names of the PlayIntegrityConfigs to retrieve, in the format ``` projects/{project_number}/apps/{app_id}/playIntegrityConfig ``` A maximum of 100 objects can be retrieved in a batch."
  ([parent] (projects-apps-playIntegrityConfig-batchGet parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/apps/-/playIntegrityConfig:batchGet",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-apps-recaptchaEnterpriseConfig-patch
  "Updates the RecaptchaEnterpriseConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange reCAPTCHA Enterprise tokens for App Check tokens.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the reCAPTCHA Enterprise configuration object, in the format: ``` projects/{project_number}/apps/{app_id}/recaptchaEnterpriseConfig ```
GoogleFirebaseAppcheckV1RecaptchaEnterpriseConfig:
{:siteKey string, :tokenTtl string, :name string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the RecaptchaEnterpriseConfig to update. Example: `site_key`."
  ([name GoogleFirebaseAppcheckV1RecaptchaEnterpriseConfig]
    (projects-apps-recaptchaEnterpriseConfig-patch
      name
      GoogleFirebaseAppcheckV1RecaptchaEnterpriseConfig
      nil))
  ([name GoogleFirebaseAppcheckV1RecaptchaEnterpriseConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1RecaptchaEnterpriseConfig})))

(defn projects-apps-recaptchaEnterpriseConfig-batchGet
  "Atomically gets the RecaptchaEnterpriseConfigs for the specified list of apps.
https://firebase.google.com/docs/app-check

parent <string> Required. The parent project name shared by all RecaptchaEnterpriseConfigs being retrieved, in the format ``` projects/{project_number} ``` The parent collection in the `name` field of any resource being retrieved must match this field, or the entire batch fails.

optional:
names <string> Required. The relative resource names of the RecaptchaEnterpriseConfigs to retrieve, in the format: ``` projects/{project_number}/apps/{app_id}/recaptchaEnterpriseConfig ``` A maximum of 100 objects can be retrieved in a batch."
  ([parent]
    (projects-apps-recaptchaEnterpriseConfig-batchGet parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/apps/-/recaptchaEnterpriseConfig:batchGet",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-apps-recaptchaEnterpriseConfig-get
  "Gets the RecaptchaEnterpriseConfig for the specified app.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the RecaptchaEnterpriseConfig, in the format: ``` projects/{project_number}/apps/{app_id}/recaptchaEnterpriseConfig ```"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-appAttestConfig-patch
  "Updates the AppAttestConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange AppAttest tokens for App Check tokens.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the App Attest configuration object, in the format: ``` projects/{project_number}/apps/{app_id}/appAttestConfig ```
GoogleFirebaseAppcheckV1AppAttestConfig:
{:name string, :tokenTtl string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the AppAttestConfig to update. Example: `token_ttl`."
  ([name GoogleFirebaseAppcheckV1AppAttestConfig]
    (projects-apps-appAttestConfig-patch
      name
      GoogleFirebaseAppcheckV1AppAttestConfig
      nil))
  ([name GoogleFirebaseAppcheckV1AppAttestConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1AppAttestConfig})))

(defn projects-apps-appAttestConfig-get
  "Gets the AppAttestConfig for the specified app.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the AppAttestConfig, in the format: ``` projects/{project_number}/apps/{app_id}/appAttestConfig ```"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-apps-appAttestConfig-batchGet
  "Atomically gets the AppAttestConfigs for the specified list of apps.
https://firebase.google.com/docs/app-check

parent <string> Required. The parent project name shared by all AppAttestConfigs being retrieved, in the format ``` projects/{project_number} ``` The parent collection in the `name` field of any resource being retrieved must match this field, or the entire batch fails.

optional:
names <string> Required. The relative resource names of the AppAttestConfigs to retrieve, in the format ``` projects/{project_number}/apps/{app_id}/appAttestConfig ``` A maximum of 100 objects can be retrieved in a batch."
  ([parent] (projects-apps-appAttestConfig-batchGet parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/apps/-/appAttestConfig:batchGet",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-services-batchUpdate
  "Atomically updates the specified Service configurations.
https://firebase.google.com/docs/app-check

parent <string> Required. The parent project name shared by all Service configurations being updated, in the format ``` projects/{project_number} ``` The parent collection in the `name` field of any resource being updated must match this field, or the entire batch fails.
GoogleFirebaseAppcheckV1BatchUpdateServicesRequest:
{:requests
 [{:service {:enforcementMode [OFF UNENFORCED ENFORCED], :name string},
   :updateMask string}],
 :updateMask string}"
  [parent GoogleFirebaseAppcheckV1BatchUpdateServicesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+parent}/services:batchUpdate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body GoogleFirebaseAppcheckV1BatchUpdateServicesRequest}))

(defn projects-services-get
  "Gets the Service configuration for the specified service name.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the Service to retrieve, in the format: ``` projects/{project_number}/services/{service_id} ``` Note that the `service_id` element must be a supported service ID. Currently, the following service IDs are supported: * `firebasestorage.googleapis.com` (Cloud Storage for Firebase) * `firebasedatabase.googleapis.com` (Firebase Realtime Database) * `firestore.googleapis.com` (Cloud Firestore)"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappcheck.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-services-list
  "Lists all Service configurations for the specified project. Only Services which were explicitly configured using UpdateService or BatchUpdateServices will be returned.
https://firebase.google.com/docs/app-check

parent <string> Required. The relative resource name of the parent project for which to list each associated Service, in the format: ``` projects/{project_number} ```

optional:
pageSize <integer> The maximum number of Services to return in the response. Only explicitly configured services are returned. The server may return fewer than this at its own discretion. If no value is specified (or too large a value is specified), the server will impose its own limit."
  ([parent] (projects-services-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-services-patch
  "Updates the specified Service configuration.
https://firebase.google.com/docs/app-check

name <string> Required. The relative resource name of the service configuration object, in the format: ``` projects/{project_number}/services/{service_id} ``` Note that the `service_id` element must be a supported service ID. Currently, the following service IDs are supported: * `firebasestorage.googleapis.com` (Cloud Storage for Firebase) * `firebasedatabase.googleapis.com` (Firebase Realtime Database) * `firestore.googleapis.com` (Cloud Firestore)
GoogleFirebaseAppcheckV1Service:
{:enforcementMode [OFF UNENFORCED ENFORCED], :name string}

optional:
updateMask <string> Required. A comma-separated list of names of fields in the Service to update. Example: `enforcement_mode`."
  ([name GoogleFirebaseAppcheckV1Service]
    (projects-services-patch name GoogleFirebaseAppcheckV1Service nil))
  ([name GoogleFirebaseAppcheckV1Service optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappcheck.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body GoogleFirebaseAppcheckV1Service})))

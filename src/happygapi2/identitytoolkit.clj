(ns happygapi2.identitytoolkit
  "Google Identity Toolkit API
Help the third party sites to implement federated login.
See: https://developers.google.com/identity/toolkit/migrate-identityplatform"
  (:require [happy.oauth2.client :as client]))

(defn relyingparty-verifyPhoneNumber
  "Verifies ownership of a phone number and creates/updates the user account accordingly.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/verifyPhoneNumber

IdentitytoolkitRelyingpartyVerifyPhoneNumberRequest:
{:code string,
 :idToken string,
 :operation string,
 :phoneNumber string,
 :sessionInfo string,
 :temporaryProof string,
 :verificationProof string}"
  [IdentitytoolkitRelyingpartyVerifyPhoneNumberRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPhoneNumber",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyVerifyPhoneNumberRequest}))

(defn relyingparty-deleteAccount
  "Delete user account.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/deleteAccount

IdentitytoolkitRelyingpartyDeleteAccountRequest:
{:delegatedProjectNumber string, :idToken string, :localId string}"
  [IdentitytoolkitRelyingpartyDeleteAccountRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/deleteAccount",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyDeleteAccountRequest}))

(defn relyingparty-signupNewUser
  "Signup new user.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/signupNewUser

IdentitytoolkitRelyingpartySignupNewUserRequest:
{:tenantId string,
 :tenantProjectNumber string,
 :email string,
 :disabled boolean,
 :instanceId string,
 :password string,
 :displayName string,
 :idToken string,
 :captchaResponse string,
 :captchaChallenge string,
 :emailVerified boolean,
 :localId string,
 :photoUrl string,
 :phoneNumber string}"
  [IdentitytoolkitRelyingpartySignupNewUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/signupNewUser",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartySignupNewUserRequest}))

(defn relyingparty-setProjectConfig
  "Set project configuration.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/setProjectConfig

IdentitytoolkitRelyingpartySetProjectConfigRequest:
{:allowPasswordUser boolean,
 :authorizedDomains [string],
 :legacyResetPasswordTemplate
 {:body string,
  :format string,
  :from string,
  :fromDisplayName string,
  :replyTo string,
  :subject string},
 :changeEmailTemplate
 {:body string,
  :format string,
  :from string,
  :fromDisplayName string,
  :replyTo string,
  :subject string},
 :idpConfig
 [{:clientId string,
   :enabled boolean,
   :experimentPercent integer,
   :provider string,
   :secret string,
   :whitelistedAudiences [string]}],
 :apiKey string,
 :enableAnonymousUser boolean,
 :verifyEmailTemplate
 {:body string,
  :format string,
  :from string,
  :fromDisplayName string,
  :replyTo string,
  :subject string},
 :useEmailSending boolean,
 :delegatedProjectNumber string,
 :resetPasswordTemplate
 {:body string,
  :format string,
  :from string,
  :fromDisplayName string,
  :replyTo string,
  :subject string}}"
  [IdentitytoolkitRelyingpartySetProjectConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/setProjectConfig",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartySetProjectConfigRequest}))

(defn relyingparty-getProjectConfig
  "Get project configuration.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/getProjectConfig

optional:
delegatedProjectNumber <string> Delegated GCP project number of the request.
projectNumber <string> GCP project number of the request."
  ([] (relyingparty-getProjectConfig nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/identitytoolkit/v3/relyingparty/getProjectConfig",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn relyingparty-verifyPassword
  "Verifies the user entered password.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/verifyPassword

IdentitytoolkitRelyingpartyVerifyPasswordRequest:
{:tenantId string,
 :tenantProjectNumber string,
 :email string,
 :returnSecureToken boolean,
 :instanceId string,
 :password string,
 :idToken string,
 :captchaResponse string,
 :captchaChallenge string,
 :pendingIdToken string,
 :delegatedProjectNumber string}"
  [IdentitytoolkitRelyingpartyVerifyPasswordRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyVerifyPasswordRequest}))

(defn relyingparty-sendVerificationCode
  "Send SMS verification code.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/sendVerificationCode

IdentitytoolkitRelyingpartySendVerificationCodeRequest:
{:iosReceipt string,
 :iosSecret string,
 :phoneNumber string,
 :recaptchaToken string}"
  [IdentitytoolkitRelyingpartySendVerificationCodeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/sendVerificationCode",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartySendVerificationCodeRequest}))

(defn relyingparty-verifyCustomToken
  "Verifies the developer asserted ID token.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/verifyCustomToken

IdentitytoolkitRelyingpartyVerifyCustomTokenRequest:
{:delegatedProjectNumber string,
 :instanceId string,
 :returnSecureToken boolean,
 :token string}"
  [IdentitytoolkitRelyingpartyVerifyCustomTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyCustomToken",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyVerifyCustomTokenRequest}))

(defn relyingparty-verifyAssertion
  "Verifies the assertion returned by the IdP.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/verifyAssertion

IdentitytoolkitRelyingpartyVerifyAssertionRequest:
{:tenantId string,
 :tenantProjectNumber string,
 :autoCreate boolean,
 :returnSecureToken boolean,
 :sessionId string,
 :instanceId string,
 :idToken string,
 :requestUri string,
 :postBody string,
 :returnRefreshToken boolean,
 :pendingIdToken string,
 :returnIdpCredential boolean,
 :delegatedProjectNumber string}"
  [IdentitytoolkitRelyingpartyVerifyAssertionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyAssertion",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyVerifyAssertionRequest}))

(defn relyingparty-emailLinkSignin
  "Reset password for a user.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/emailLinkSignin

IdentitytoolkitRelyingpartyEmailLinkSigninRequest:
{:email string, :idToken string, :oobCode string}"
  [IdentitytoolkitRelyingpartyEmailLinkSigninRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/emailLinkSignin",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyEmailLinkSigninRequest}))

(defn relyingparty-getAccountInfo
  "Returns the account info.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/getAccountInfo

IdentitytoolkitRelyingpartyGetAccountInfoRequest:
{:delegatedProjectNumber string,
 :email [string],
 :idToken string,
 :localId [string],
 :phoneNumber [string]}"
  [IdentitytoolkitRelyingpartyGetAccountInfoRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/getAccountInfo",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyGetAccountInfoRequest}))

(defn relyingparty-resetPassword
  "Reset password for a user.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/resetPassword

IdentitytoolkitRelyingpartyResetPasswordRequest:
{:email string,
 :newPassword string,
 :oldPassword string,
 :oobCode string}"
  [IdentitytoolkitRelyingpartyResetPasswordRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/resetPassword",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyResetPasswordRequest}))

(defn relyingparty-getOobConfirmationCode
  "Get a code for user action confirmation.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/getOobConfirmationCode

Relyingparty:
{:newEmail string,
 :continueUrl string,
 :userIp string,
 :email string,
 :iOSAppStoreId string,
 :captchaResp string,
 :idToken string,
 :androidInstallApp boolean,
 :challenge string,
 :kind string,
 :requestType string,
 :iOSBundleId string,
 :androidPackageName string,
 :canHandleCodeInApp boolean,
 :androidMinimumVersion string}"
  [Relyingparty]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/getOobConfirmationCode",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Relyingparty}))

(defn relyingparty-signOutUser
  "Sign out user.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/signOutUser

IdentitytoolkitRelyingpartySignOutUserRequest:
{:instanceId string, :localId string}"
  [IdentitytoolkitRelyingpartySignOutUserRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/signOutUser",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartySignOutUserRequest}))

(defn relyingparty-getPublicKeys
  "Get token signing public key.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/getPublicKeys"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/publicKeys",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn relyingparty-setAccountInfo
  "Set account info for a user.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/setAccountInfo

IdentitytoolkitRelyingpartySetAccountInfoRequest:
{:email string,
 :deleteProvider [string],
 :returnSecureToken boolean,
 :validSince string,
 :instanceId string,
 :password string,
 :displayName string,
 :upgradeToFederatedLogin boolean,
 :customAttributes string,
 :createdAt string,
 :idToken string,
 :deleteAttribute [string],
 :captchaResponse string,
 :captchaChallenge string,
 :emailVerified boolean,
 :localId string,
 :photoUrl string,
 :oobCode string,
 :disableUser boolean,
 :phoneNumber string,
 :lastLoginAt string,
 :provider [string],
 :delegatedProjectNumber string}"
  [IdentitytoolkitRelyingpartySetAccountInfoRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/setAccountInfo",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartySetAccountInfoRequest}))

(defn relyingparty-uploadAccount
  "Batch upload existing user accounts.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/uploadAccount

IdentitytoolkitRelyingpartyUploadAccountRequest:
{:blockSize integer,
 :memoryCost integer,
 :targetProjectId string,
 :parallelization integer,
 :hashAlgorithm string,
 :cpuMemCost integer,
 :sanityCheck boolean,
 :dkLen integer,
 :allowOverwrite boolean,
 :rounds integer,
 :signerKey string,
 :saltSeparator string,
 :delegatedProjectNumber string,
 :users
 [{:salt string,
   :email string,
   :validSince string,
   :disabled boolean,
   :displayName string,
   :providerUserInfo
   [{:displayName string,
     :email string,
     :federatedId string,
     :phoneNumber string,
     :photoUrl string,
     :providerId string,
     :rawId string,
     :screenName string}],
   :customAttributes string,
   :createdAt string,
   :emailVerified boolean,
   :customAuth boolean,
   :localId string,
   :passwordUpdatedAt number,
   :photoUrl string,
   :rawPassword string,
   :passwordHash string,
   :version integer,
   :screenName string,
   :phoneNumber string,
   :lastLoginAt string}]}"
  [IdentitytoolkitRelyingpartyUploadAccountRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/uploadAccount",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body IdentitytoolkitRelyingpartyUploadAccountRequest}))

(defn relyingparty-downloadAccount
  "Batch download user accounts.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/downloadAccount

IdentitytoolkitRelyingpartyDownloadAccountRequest:
{:delegatedProjectNumber string,
 :maxResults integer,
 :nextPageToken string,
 :targetProjectId string}"
  [IdentitytoolkitRelyingpartyDownloadAccountRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/downloadAccount",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body IdentitytoolkitRelyingpartyDownloadAccountRequest}))

(defn relyingparty-getRecaptchaParam
  "Get recaptcha secure param.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/getRecaptchaParam"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/getRecaptchaParam",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn relyingparty-createAuthUri
  "Creates the URI used by the IdP to authenticate the user.
https://developers.google.com/identity/toolkit/migrate-identityplatform/v3/docs/relyingparty/createAuthUri

IdentitytoolkitRelyingpartyCreateAuthUriRequest:
{:tenantId string,
 :providerId string,
 :clientId string,
 :tenantProjectNumber string,
 :continueUri string,
 :sessionId string,
 :hostedDomain string,
 :otaApp string,
 :openidRealm string,
 :customParameter object,
 :authFlowType string,
 :oauthConsumerKey string,
 :oauthScope string,
 :appId string,
 :identifier string,
 :context string}"
  [IdentitytoolkitRelyingpartyCreateAuthUriRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/createAuthUri",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IdentitytoolkitRelyingpartyCreateAuthUriRequest}))

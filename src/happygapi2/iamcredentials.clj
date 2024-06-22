(ns happygapi2.iamcredentials
  "IAM Service Account Credentials API
Creates short-lived credentials for impersonating IAM service accounts. Disabling this API also disables the IAM API (iam.googleapis.com). However, enabling this API doesn't enable the IAM API. 
See: https://cloud.google.com/iam/docs/create-short-lived-credentials-direct"
  (:require [happy.oauth2.client :as client]))

(defn projects-serviceAccounts-generateAccessToken
  "Generates an OAuth 2.0 access token for a service account.
https://cloud.google.com/iam/docs/create-short-lived-credentials-direct

name <string> Required. The resource name of the service account for which the credentials are requested, in the following format: `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is required; replacing it with a project ID is invalid.
GenerateAccessTokenRequest:
{:delegates [string], :scope [string], :lifetime string}"
  [name GenerateAccessTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://iamcredentials.googleapis.com/v1/{+name}:generateAccessToken",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateAccessTokenRequest}))

(defn projects-serviceAccounts-generateIdToken
  "Generates an OpenID Connect ID token for a service account.
https://cloud.google.com/iam/docs/create-short-lived-credentials-direct

name <string> Required. The resource name of the service account for which the credentials are requested, in the following format: `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is required; replacing it with a project ID is invalid.
GenerateIdTokenRequest:
{:delegates [string], :audience string, :includeEmail boolean}"
  [name GenerateIdTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://iamcredentials.googleapis.com/v1/{+name}:generateIdToken",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateIdTokenRequest}))

(defn projects-serviceAccounts-signBlob
  "Signs a blob using a service account's system-managed private key.
https://cloud.google.com/iam/docs/create-short-lived-credentials-direct

name <string> Required. The resource name of the service account for which the credentials are requested, in the following format: `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is required; replacing it with a project ID is invalid.
SignBlobRequest:
{:delegates [string], :payload string}"
  [name SignBlobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://iamcredentials.googleapis.com/v1/{+name}:signBlob",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SignBlobRequest}))

(defn projects-serviceAccounts-signJwt
  "Signs a JWT using a service account's system-managed private key.
https://cloud.google.com/iam/docs/create-short-lived-credentials-direct

name <string> Required. The resource name of the service account for which the credentials are requested, in the following format: `projects/-/serviceAccounts/{ACCOUNT_EMAIL_OR_UNIQUEID}`. The `-` wildcard character is required; replacing it with a project ID is invalid.
SignJwtRequest:
{:delegates [string], :payload string}"
  [name SignJwtRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://iamcredentials.googleapis.com/v1/{+name}:signJwt",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SignJwtRequest}))

(ns happygapi2.cloudshell
  "Cloud Shell API
Allows users to start, configure, and connect to interactive shell sessions running in the cloud. 
See: https://cloud.google.com/shell/docs/"
  (:require [happy.oauth2.client :as client]))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/shell/docs/reference/rest/v1/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudshell.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/shell/docs/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudshell.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/shell/docs/reference/rest/v1/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudshell.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/shell/docs/reference/rest/v1/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudshell.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn users-environments-get
  "Gets an environment. Returns NOT_FOUND if the environment does not exist.
https://cloud.google.com/shell/docs/reference/rest/v1/users/environments/get

name <string> Required. Name of the requested resource, for example `users/me/environments/default` or `users/someone@example.com/environments/default`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudshell.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn users-environments-start
  "Starts an existing environment, allowing clients to connect to it. The returned operation will contain an instance of StartEnvironmentMetadata in its metadata field. Users can wait for the environment to start by polling this operation via GetOperation. Once the environment has finished starting and is ready to accept connections, the operation will contain a StartEnvironmentResponse in its response field.
https://cloud.google.com/shell/docs/reference/rest/v1/users/environments/start

name <string> Name of the resource that should be started, for example `users/me/environments/default` or `users/someone@example.com/environments/default`.
StartEnvironmentRequest:
{:accessToken string, :publicKeys [string]}"
  [name StartEnvironmentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudshell.googleapis.com/v1/{+name}:start",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartEnvironmentRequest}))

(defn users-environments-authorize
  "Sends OAuth credentials to a running environment on behalf of a user. When this completes, the environment will be authorized to run various Google Cloud command line tools without requiring the user to manually authenticate.
https://cloud.google.com/shell/docs/reference/rest/v1/users/environments/authorize

name <string> Name of the resource that should receive the credentials, for example `users/me/environments/default` or `users/someone@example.com/environments/default`.
AuthorizeEnvironmentRequest:
{:accessToken string, :idToken string, :expireTime string}"
  [name AuthorizeEnvironmentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudshell.googleapis.com/v1/{+name}:authorize",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AuthorizeEnvironmentRequest}))

(defn users-environments-addPublicKey
  "Adds a public SSH key to an environment, allowing clients with the corresponding private key to connect to that environment via SSH. If a key with the same content already exists, this will error with ALREADY_EXISTS.
https://cloud.google.com/shell/docs/reference/rest/v1/users/environments/addPublicKey

environment <string> Environment this key should be added to, e.g. `users/me/environments/default`.
AddPublicKeyRequest:
{:key string}"
  [environment AddPublicKeyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudshell.googleapis.com/v1/{+environment}:addPublicKey",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AddPublicKeyRequest}))

(defn users-environments-removePublicKey
  "Removes a public SSH key from an environment. Clients will no longer be able to connect to the environment using the corresponding private key. If a key with the same content is not present, this will error with NOT_FOUND.
https://cloud.google.com/shell/docs/reference/rest/v1/users/environments/removePublicKey

environment <string> Environment this key should be removed from, e.g. `users/me/environments/default`.
RemovePublicKeyRequest:
{:key string}"
  [environment RemovePublicKeyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudshell.googleapis.com/v1/{+environment}:removePublicKey",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RemovePublicKeyRequest}))

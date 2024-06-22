(ns happygapi2.cloudbuild
  "Cloud Build API
Creates and manages builds on Google Cloud Platform.
See: https://cloud.google.com/build/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/build/docs

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/build/docs

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudbuild.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connections-get
  "Gets details of a single connection.
https://cloud.google.com/build/docs

name <string> Required. The name of the Connection to retrieve. Format: `projects/*/locations/*/connections/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudbuild.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connections-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/build/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:updateMask string,
 :policy
 {:bindings
  [{:role string,
    :condition
    {:expression string,
     :title string,
     :location string,
     :description string},
    :members [string]}],
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:exemptedMembers [string],
      :logType
      [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ]}]}],
  :version integer,
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbuild.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-connections-patch
  "Updates a single connection.
https://cloud.google.com/build/docs

name <string> Immutable. The resource name of the connection, in the format `projects/{project}/locations/{location}/connections/{connection_id}`.
Connection:
{:disabled boolean,
 :name string,
 :githubEnterpriseConfig
 {:serverVersion string,
  :apiKey string,
  :hostUri string,
  :serviceDirectoryConfig {:service string},
  :privateKeySecretVersion string,
  :appSlug string,
  :appId string,
  :webhookSecretSecretVersion string,
  :appInstallationId string,
  :sslCa string},
 :createTime string,
 :etag string,
 :updateTime string,
 :bitbucketDataCenterConfig
 {:serviceDirectoryConfig {:service string},
  :readAuthorizerCredential
  {:username string, :userTokenSecretVersion string},
  :serverVersion string,
  :webhookSecretSecretVersion string,
  :authorizerCredential
  {:username string, :userTokenSecretVersion string},
  :sslCa string,
  :hostUri string},
 :reconciling boolean,
 :installationState
 {:actionUri string,
  :message string,
  :stage
  [STAGE_UNSPECIFIED
   PENDING_CREATE_APP
   PENDING_USER_OAUTH
   PENDING_INSTALL_APP
   COMPLETE]},
 :githubConfig
 {:appInstallationId string,
  :authorizerCredential
  {:oauthTokenSecretVersion string, :username string}},
 :bitbucketCloudConfig
 {:authorizerCredential
  {:username string, :userTokenSecretVersion string},
  :workspace string,
  :readAuthorizerCredential
  {:username string, :userTokenSecretVersion string},
  :webhookSecretSecretVersion string},
 :annotations object,
 :gitlabConfig
 {:authorizerCredential
  {:username string, :userTokenSecretVersion string},
  :sslCa string,
  :hostUri string,
  :serviceDirectoryConfig {:service string},
  :webhookSecretSecretVersion string,
  :readAuthorizerCredential
  {:username string, :userTokenSecretVersion string},
  :serverVersion string}}

optional:
etag <string> The current etag of the connection. If an etag is provided and does not match the current etag of the connection, update will be blocked and an ABORTED error will be returned.
updateMask <string> The list of fields to be updated.
allowMissing <boolean> If set to true, and the connection is not found a new connection will be created. In this situation `update_mask` is ignored. The creation will succeed only if the input connection has all the necessary information (e.g a github_config with both user_oauth_token and installation_id properties)."
  ([name Connection]
    (projects-locations-connections-patch name Connection nil))
  ([name Connection optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudbuild.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Connection})))

(defn projects-locations-connections-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/build/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbuild.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-connections-create
  "Creates a Connection.
https://cloud.google.com/build/docs

parent <string> Required. Project and location where the connection will be created. Format: `projects/*/locations/*`.
Connection:
{:disabled boolean,
 :name string,
 :githubEnterpriseConfig
 {:serverVersion string,
  :apiKey string,
  :hostUri string,
  :serviceDirectoryConfig {:service string},
  :privateKeySecretVersion string,
  :appSlug string,
  :appId string,
  :webhookSecretSecretVersion string,
  :appInstallationId string,
  :sslCa string},
 :createTime string,
 :etag string,
 :updateTime string,
 :bitbucketDataCenterConfig
 {:serviceDirectoryConfig {:service string},
  :readAuthorizerCredential
  {:username string, :userTokenSecretVersion string},
  :serverVersion string,
  :webhookSecretSecretVersion string,
  :authorizerCredential
  {:username string, :userTokenSecretVersion string},
  :sslCa string,
  :hostUri string},
 :reconciling boolean,
 :installationState
 {:actionUri string,
  :message string,
  :stage
  [STAGE_UNSPECIFIED
   PENDING_CREATE_APP
   PENDING_USER_OAUTH
   PENDING_INSTALL_APP
   COMPLETE]},
 :githubConfig
 {:appInstallationId string,
  :authorizerCredential
  {:oauthTokenSecretVersion string, :username string}},
 :bitbucketCloudConfig
 {:authorizerCredential
  {:username string, :userTokenSecretVersion string},
  :workspace string,
  :readAuthorizerCredential
  {:username string, :userTokenSecretVersion string},
  :webhookSecretSecretVersion string},
 :annotations object,
 :gitlabConfig
 {:authorizerCredential
  {:username string, :userTokenSecretVersion string},
  :sslCa string,
  :hostUri string,
  :serviceDirectoryConfig {:service string},
  :webhookSecretSecretVersion string,
  :readAuthorizerCredential
  {:username string, :userTokenSecretVersion string},
  :serverVersion string}}

optional:
connectionId <string> Required. The ID to use for the Connection, which will become the final component of the Connection's resource name. Names must be unique per-project per-location. Allows alphanumeric characters and any of -._~%!$&'()*+,;=@."
  ([parent Connection]
    (projects-locations-connections-create parent Connection nil))
  ([parent Connection optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+parent}/connections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Connection})))

(defn projects-locations-connections-delete
  "Deletes a single connection.
https://cloud.google.com/build/docs

name <string> Required. The name of the Connection to delete. Format: `projects/*/locations/*/connections/*`.

optional:
etag <string> The current etag of the connection. If an etag is provided and does not match the current etag of the connection, deletion will be blocked and an ABORTED error will be returned.
validateOnly <boolean> If set, validate the request, but do not actually post it."
  ([name] (projects-locations-connections-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://cloudbuild.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/build/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-connections-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-list
  "Lists Connections in a given project and location.
https://cloud.google.com/build/docs

parent <string> Required. The parent, which owns this collection of Connections. Format: `projects/*/locations/*`.

optional:
pageSize <integer> Number of results to return in the list."
  ([parent] (projects-locations-connections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+parent}/connections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-fetchLinkableRepositories
  "FetchLinkableRepositories get repositories from SCM that are accessible and could be added to the connection.
https://cloud.google.com/build/docs

connection <string> Required. The name of the Connection. Format: `projects/*/locations/*/connections/*`.

optional:
pageSize <integer> Number of results to return in the list. Default to 20."
  ([connection]
    (projects-locations-connections-fetchLinkableRepositories
      connection
      nil))
  ([connection optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+connection}:fetchLinkableRepositories",
       :uri-template-args {:connection connection},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-processWebhook
  "ProcessWebhook is called by the external SCM for notifying of events.
https://cloud.google.com/build/docs

parent <string> Required. Project and location where the webhook will be received. Format: `projects/*/locations/*`.
HttpBody:
{:extensions [object], :data string, :contentType string}

optional:
webhookKey <string> Arbitrary additional key to find the maching repository for a webhook event if needed."
  ([parent HttpBody]
    (projects-locations-connections-processWebhook
      parent
      HttpBody
      nil))
  ([parent HttpBody optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+parent}/connections:processWebhook",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil,
       :body HttpBody})))

(defn projects-locations-connections-repositories-fetchGitRefs
  "Fetch the list of branches or tags for a given repository.
https://cloud.google.com/build/docs

repository <string> Required. The resource name of the repository in the format `projects/*/locations/*/connections/*/repositories/*`.

optional:
pageSize <integer> Optional. Number of results to return in the list. Default to 20.
refType <string> Type of refs to fetch"
  ([repository]
    (projects-locations-connections-repositories-fetchGitRefs
      repository
      nil))
  ([repository optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+repository}:fetchGitRefs",
       :uri-template-args {:repository repository},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-repositories-get
  "Gets details of a single repository.
https://cloud.google.com/build/docs

name <string> Required. The name of the Repository to retrieve. Format: `projects/*/locations/*/connections/*/repositories/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudbuild.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connections-repositories-accessReadWriteToken
  "Fetches read/write token of a given repository.
https://cloud.google.com/build/docs

repository <string> Required. The resource name of the repository in the format `projects/*/locations/*/connections/*/repositories/*`.
FetchReadWriteTokenRequest:
object"
  [repository FetchReadWriteTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbuild.googleapis.com/v2/{+repository}:accessReadWriteToken",
     :uri-template-args {:repository repository},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body FetchReadWriteTokenRequest}))

(defn projects-locations-connections-repositories-batchCreate
  "Creates multiple repositories inside a connection.
https://cloud.google.com/build/docs

parent <string> Required. The connection to contain all the repositories being created. Format: projects/*/locations/*/connections/* The parent field in the CreateRepositoryRequest messages must either be empty or match this field.
BatchCreateRepositoriesRequest:
{:requests
 [{:parent string,
   :repositoryId string,
   :repository
   {:annotations object,
    :remoteUri string,
    :updateTime string,
    :etag string,
    :name string,
    :createTime string,
    :webhookId string}}]}"
  [parent BatchCreateRepositoriesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbuild.googleapis.com/v2/{+parent}/repositories:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchCreateRepositoriesRequest}))

(defn projects-locations-connections-repositories-list
  "Lists Repositories in a given connection.
https://cloud.google.com/build/docs

parent <string> Required. The parent, which owns this collection of Repositories. Format: `projects/*/locations/*/connections/*`.

optional:
pageSize <integer> Number of results to return in the list.
filter <string> A filter expression that filters resources listed in the response. Expressions must follow API improvement proposal [AIP-160](https://google.aip.dev/160). e.g. `remote_uri:\"https://github.com*\"`."
  ([parent]
    (projects-locations-connections-repositories-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+parent}/repositories",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-repositories-accessReadToken
  "Fetches read token of a given repository.
https://cloud.google.com/build/docs

repository <string> Required. The resource name of the repository in the format `projects/*/locations/*/connections/*/repositories/*`.
FetchReadTokenRequest:
object"
  [repository FetchReadTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbuild.googleapis.com/v2/{+repository}:accessReadToken",
     :uri-template-args {:repository repository},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body FetchReadTokenRequest}))

(defn projects-locations-connections-repositories-delete
  "Deletes a single repository.
https://cloud.google.com/build/docs

name <string> Required. The name of the Repository to delete. Format: `projects/*/locations/*/connections/*/repositories/*`.

optional:
validateOnly <boolean> If set, validate the request, but do not actually post it.
etag <string> The current etag of the repository. If an etag is provided and does not match the current etag of the repository, deletion will be blocked and an ABORTED error will be returned."
  ([name]
    (projects-locations-connections-repositories-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://cloudbuild.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-repositories-create
  "Creates a Repository.
https://cloud.google.com/build/docs

parent <string> Required. The connection to contain the repository. If the request is part of a BatchCreateRepositoriesRequest, this field should be empty or match the parent specified there.
Repository:
{:annotations object,
 :remoteUri string,
 :updateTime string,
 :etag string,
 :name string,
 :createTime string,
 :webhookId string}

optional:
repositoryId <string> Required. The ID to use for the repository, which will become the final component of the repository's resource name. This ID should be unique in the connection. Allows alphanumeric characters and any of -._~%!$&'()*+,;=@."
  ([parent Repository]
    (projects-locations-connections-repositories-create
      parent
      Repository
      nil))
  ([parent Repository optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudbuild.googleapis.com/v2/{+parent}/repositories",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Repository})))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/build/docs

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbuild.googleapis.com/v2/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/build/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudbuild.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

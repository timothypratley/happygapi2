(ns happygapi2.dataform
  "Dataform API
Service to develop, version control, and operationalize SQL pipelines in BigQuery.
See: https://cloud.google.com/dataform/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-readFile
  "Returns the contents of a file (inside a Repository). The Repository must not have a value for `git_remote_settings.url`.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/readFile

name <string> Required. The repository's name.

optional:
commitSha <string> Optional. The commit SHA for the commit to read from. If unset, the file will be read from HEAD.
path <string> Required. Full file path to read including filename, from repository root."
  ([name] (projects-locations-repositories-readFile name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+name}:readFile",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-get
  "Fetches a single Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/get

name <string> Required. The repository's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-repositories-patch
  "Updates a single Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/patch

name <string> Identifier. The repository's name.
Repository:
{:serviceAccount string,
 :labels object,
 :setAuthenticatedUserAdmin boolean,
 :workspaceCompilationOverrides
 {:defaultDatabase string, :schemaSuffix string, :tablePrefix string},
 :displayName string,
 :npmrcEnvironmentVariablesSecretVersion string,
 :name string,
 :createTime string,
 :gitRemoteSettings
 {:url string,
  :defaultBranch string,
  :authenticationTokenSecretVersion string,
  :sshAuthenticationConfig
  {:userPrivateKeySecretVersion string, :hostPublicKey string},
  :tokenStatus [TOKEN_STATUS_UNSPECIFIED NOT_FOUND INVALID VALID]},
 :kmsKeyName string,
 :dataEncryptionState {:kmsKeyVersionName string}}

optional:
updateMask <string> Optional. Specifies the fields to be updated in the repository. If left unset, all fields will be updated."
  ([name Repository]
    (projects-locations-repositories-patch name Repository nil))
  ([name Repository optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Repository})))

(defn projects-locations-repositories-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-repositories-create
  "Creates a new Repository in a given project and location.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/create

parent <string> Required. The location in which to create the repository. Must be in the format `projects/*/locations/*`.
Repository:
{:serviceAccount string,
 :labels object,
 :setAuthenticatedUserAdmin boolean,
 :workspaceCompilationOverrides
 {:defaultDatabase string, :schemaSuffix string, :tablePrefix string},
 :displayName string,
 :npmrcEnvironmentVariablesSecretVersion string,
 :name string,
 :createTime string,
 :gitRemoteSettings
 {:url string,
  :defaultBranch string,
  :authenticationTokenSecretVersion string,
  :sshAuthenticationConfig
  {:userPrivateKeySecretVersion string, :hostPublicKey string},
  :tokenStatus [TOKEN_STATUS_UNSPECIFIED NOT_FOUND INVALID VALID]},
 :kmsKeyName string,
 :dataEncryptionState {:kmsKeyVersionName string}}

optional:
repositoryId <string> Required. The ID to use for the repository, which will become the final component of the repository's resource name."
  ([parent Repository]
    (projects-locations-repositories-create parent Repository nil))
  ([parent Repository optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/repositories",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Repository})))

(defn projects-locations-repositories-delete
  "Deletes a single Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/delete

name <string> Required. The repository's name.

optional:
force <boolean> If set to true, any child resources of this repository will also be deleted. (Otherwise, the request will only succeed if the repository has no child resources.)"
  ([name] (projects-locations-repositories-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-fetchRemoteBranches
  "Fetches a Repository's remote branches.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/fetchRemoteBranches

name <string> Required. The repository's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:fetchRemoteBranches",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-repositories-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-queryDirectoryContents
  "Returns the contents of a given Repository directory. The Repository must not have a value for `git_remote_settings.url`.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/queryDirectoryContents

name <string> Required. The repository's name.

optional:
commitSha <string> Optional. The Commit SHA for the commit to query from. If unset, the directory will be queried from HEAD.
path <string> Optional. The directory's full path including directory name, relative to root. If left unset, the root is used.
pageSize <integer> Optional. Maximum number of paths to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default."
  ([name]
    (projects-locations-repositories-queryDirectoryContents name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+name}:queryDirectoryContents",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-list
  "Lists Repositories in a given project and location.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/list

parent <string> Required. The location in which to list repositories. Must be in the format `projects/*/locations/*`.

optional:
pageSize <integer> Optional. Maximum number of repositories to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default.
orderBy <string> Optional. This field only supports ordering by `name`. If unspecified, the server will choose the ordering. If specified, the default order is ascending for the `name` field.
filter <string> Optional. Filter for the returned list."
  ([parent] (projects-locations-repositories-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/repositories",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-fetchHistory
  "Fetches a Repository's history of commits. The Repository must not have a value for `git_remote_settings.url`.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/fetchHistory

name <string> Required. The repository's name.

optional:
pageSize <integer> Optional. Maximum number of commits to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default."
  ([name] (projects-locations-repositories-fetchHistory name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+name}:fetchHistory",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-commit
  "Applies a Git commit to a Repository. The Repository must not have a value for `git_remote_settings.url`.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/commit

name <string> Required. The repository's name.
CommitRepositoryChangesRequest:
{:commitMetadata
 {:author {:name string, :emailAddress string}, :commitMessage string},
 :requiredHeadCommitSha string,
 :fileOperations object}"
  [name CommitRepositoryChangesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:commit",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CommitRepositoryChangesRequest}))

(defn projects-locations-repositories-computeAccessTokenStatus
  "Computes a Repository's Git access token status.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories/computeAccessTokenStatus

name <string> Required. The repository's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:computeAccessTokenStatus",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workspaces-readFile
  "Returns the contents of a file (inside a Workspace).
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/readFile

workspace <string> Required. The workspace's name.

optional:
path <string> Required. The file's full path including filename, relative to the workspace root.
revision <string> Optional. The Git revision of the file to return. If left empty, the current contents of `path` will be returned."
  ([workspace]
    (projects-locations-repositories-workspaces-readFile
      workspace
      nil))
  ([workspace optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+workspace}:readFile",
       :uri-template-args {:workspace workspace},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workspaces-removeFile
  "Deletes a file (inside a Workspace).
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/removeFile

workspace <string> Required. The workspace's name.
RemoveFileRequest:
{:path string}"
  [workspace RemoveFileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+workspace}:removeFile",
     :uri-template-args {:workspace workspace},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RemoveFileRequest}))

(defn projects-locations-repositories-workspaces-get
  "Fetches a single Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/get

name <string> Required. The workspace's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workspaces-push
  "Pushes Git commits from a Workspace to the Repository's remote.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/push

name <string> Required. The workspace's name.
PushGitCommitsRequest:
{:remoteBranch string}"
  [name PushGitCommitsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:push",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PushGitCommitsRequest}))

(defn projects-locations-repositories-workspaces-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-repositories-workspaces-installNpmPackages
  "Installs dependency NPM packages (inside a Workspace).
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/installNpmPackages

workspace <string> Required. The workspace's name.
InstallNpmPackagesRequest:
object"
  [workspace InstallNpmPackagesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+workspace}:installNpmPackages",
     :uri-template-args {:workspace workspace},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InstallNpmPackagesRequest}))

(defn projects-locations-repositories-workspaces-fetchFileGitStatuses
  "Fetches Git statuses for the files in a Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/fetchFileGitStatuses

name <string> Required. The workspace's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:fetchFileGitStatuses",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workspaces-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-repositories-workspaces-reset
  "Performs a Git reset for uncommitted files in a Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/reset

name <string> Required. The workspace's name.
ResetWorkspaceChangesRequest:
{:paths [string], :clean boolean}"
  [name ResetWorkspaceChangesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:reset",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetWorkspaceChangesRequest}))

(defn projects-locations-repositories-workspaces-searchFiles
  "Finds the contents of a given Workspace directory by filter.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/searchFiles

workspace <string> Required. The workspace's name.

optional:
pageSize <integer> Optional. Maximum number of search results to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Optional filter for the returned list in filtering format. Filtering is only currently supported on the `path` field. See https://google.aip.dev/160 for details."
  ([workspace]
    (projects-locations-repositories-workspaces-searchFiles
      workspace
      nil))
  ([workspace optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+workspace}:searchFiles",
       :uri-template-args {:workspace workspace},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workspaces-create
  "Creates a new Workspace in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/create

parent <string> Required. The repository in which to create the workspace. Must be in the format `projects/*/locations/*/repositories/*`.
Workspace:
{:name string, :dataEncryptionState {:kmsKeyVersionName string}}

optional:
workspaceId <string> Required. The ID to use for the workspace, which will become the final component of the workspace's resource name."
  ([parent Workspace]
    (projects-locations-repositories-workspaces-create
      parent
      Workspace
      nil))
  ([parent Workspace optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/workspaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Workspace})))

(defn projects-locations-repositories-workspaces-delete
  "Deletes a single Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/delete

name <string> Required. The workspace resource's name."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workspaces-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-repositories-workspaces-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workspaces-queryDirectoryContents
  "Returns the contents of a given Workspace directory.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/queryDirectoryContents

workspace <string> Required. The workspace's name.

optional:
path <string> Optional. The directory's full path including directory name, relative to the workspace root. If left unset, the workspace root is used.
pageSize <integer> Optional. Maximum number of paths to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default."
  ([workspace]
    (projects-locations-repositories-workspaces-queryDirectoryContents
      workspace
      nil))
  ([workspace optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+workspace}:queryDirectoryContents",
       :uri-template-args {:workspace workspace},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workspaces-writeFile
  "Writes to a file (inside a Workspace).
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/writeFile

workspace <string> Required. The workspace's name.
WriteFileRequest:
{:path string, :contents string}"
  [workspace WriteFileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+workspace}:writeFile",
     :uri-template-args {:workspace workspace},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body WriteFileRequest}))

(defn projects-locations-repositories-workspaces-list
  "Lists Workspaces in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/list

parent <string> Required. The repository in which to list workspaces. Must be in the format `projects/*/locations/*/repositories/*`.

optional:
pageSize <integer> Optional. Maximum number of workspaces to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default.
orderBy <string> Optional. This field only supports ordering by `name`. If unspecified, the server will choose the ordering. If specified, the default order is ascending for the `name` field.
filter <string> Optional. Filter for the returned list."
  ([parent]
    (projects-locations-repositories-workspaces-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/workspaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workspaces-moveFile
  "Moves a file (inside a Workspace) to a new location.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/moveFile

workspace <string> Required. The workspace's name.
MoveFileRequest:
{:path string, :newPath string}"
  [workspace MoveFileRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+workspace}:moveFile",
     :uri-template-args {:workspace workspace},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body MoveFileRequest}))

(defn projects-locations-repositories-workspaces-commit
  "Applies a Git commit for uncommitted files in a Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/commit

name <string> Required. The workspace's name.
CommitWorkspaceChangesRequest:
{:author {:name string, :emailAddress string},
 :commitMessage string,
 :paths [string]}"
  [name CommitWorkspaceChangesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:commit",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CommitWorkspaceChangesRequest}))

(defn projects-locations-repositories-workspaces-makeDirectory
  "Creates a directory inside a Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/makeDirectory

workspace <string> Required. The workspace's name.
MakeDirectoryRequest:
{:path string}"
  [workspace MakeDirectoryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+workspace}:makeDirectory",
     :uri-template-args {:workspace workspace},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body MakeDirectoryRequest}))

(defn projects-locations-repositories-workspaces-moveDirectory
  "Moves a directory (inside a Workspace), and all of its contents, to a new location.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/moveDirectory

workspace <string> Required. The workspace's name.
MoveDirectoryRequest:
{:path string, :newPath string}"
  [workspace MoveDirectoryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+workspace}:moveDirectory",
     :uri-template-args {:workspace workspace},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body MoveDirectoryRequest}))

(defn projects-locations-repositories-workspaces-fetchFileDiff
  "Fetches Git diff for an uncommitted file in a Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/fetchFileDiff

workspace <string> Required. The workspace's name.

optional:
path <string> Required. The file's full path including filename, relative to the workspace root."
  ([workspace]
    (projects-locations-repositories-workspaces-fetchFileDiff
      workspace
      nil))
  ([workspace optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+workspace}:fetchFileDiff",
       :uri-template-args {:workspace workspace},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workspaces-fetchGitAheadBehind
  "Fetches Git ahead/behind against a remote branch.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/fetchGitAheadBehind

name <string> Required. The workspace's name.

optional:
remoteBranch <string> Optional. The name of the branch in the Git remote against which this workspace should be compared. If left unset, the repository's default branch name will be used."
  ([name]
    (projects-locations-repositories-workspaces-fetchGitAheadBehind
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+name}:fetchGitAheadBehind",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workspaces-pull
  "Pulls Git commits from the Repository's remote into a Workspace.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/pull

name <string> Required. The workspace's name.
PullGitCommitsRequest:
{:remoteBranch string, :author {:name string, :emailAddress string}}"
  [name PullGitCommitsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:pull",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PullGitCommitsRequest}))

(defn projects-locations-repositories-workspaces-removeDirectory
  "Deletes a directory (inside a Workspace) and all of its contents.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workspaces/removeDirectory

workspace <string> Required. The workspace's name.
RemoveDirectoryRequest:
{:path string}"
  [workspace RemoveDirectoryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+workspace}:removeDirectory",
     :uri-template-args {:workspace workspace},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RemoveDirectoryRequest}))

(defn projects-locations-repositories-releaseConfigs-list
  "Lists ReleaseConfigs in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.releaseConfigs/list

parent <string> Required. The repository in which to list release configs. Must be in the format `projects/*/locations/*/repositories/*`.

optional:
pageSize <integer> Optional. Maximum number of release configs to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default."
  ([parent]
    (projects-locations-repositories-releaseConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/releaseConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-releaseConfigs-get
  "Fetches a single ReleaseConfig.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.releaseConfigs/get

name <string> Required. The release config's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-releaseConfigs-create
  "Creates a new ReleaseConfig in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.releaseConfigs/create

parent <string> Required. The repository in which to create the release config. Must be in the format `projects/*/locations/*/repositories/*`.
ReleaseConfig:
{:name string,
 :gitCommitish string,
 :codeCompilationConfig
 {:defaultNotebookRuntimeOptions {:gcsOutputBucket string},
  :defaultDatabase string,
  :defaultLocation string,
  :databaseSuffix string,
  :defaultSchema string,
  :tablePrefix string,
  :assertionSchema string,
  :schemaSuffix string,
  :vars object},
 :cronSchedule string,
 :timeZone string,
 :recentScheduledReleaseRecords
 [{:compilationResult string,
   :errorStatus {:code integer, :message string, :details [object]},
   :releaseTime string}],
 :releaseCompilationResult string,
 :disabled boolean}

optional:
releaseConfigId <string> Required. The ID to use for the release config, which will become the final component of the release config's resource name."
  ([parent ReleaseConfig]
    (projects-locations-repositories-releaseConfigs-create
      parent
      ReleaseConfig
      nil))
  ([parent ReleaseConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/releaseConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ReleaseConfig})))

(defn projects-locations-repositories-releaseConfigs-patch
  "Updates a single ReleaseConfig.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.releaseConfigs/patch

name <string> Identifier. The release config's name.
ReleaseConfig:
{:name string,
 :gitCommitish string,
 :codeCompilationConfig
 {:defaultNotebookRuntimeOptions {:gcsOutputBucket string},
  :defaultDatabase string,
  :defaultLocation string,
  :databaseSuffix string,
  :defaultSchema string,
  :tablePrefix string,
  :assertionSchema string,
  :schemaSuffix string,
  :vars object},
 :cronSchedule string,
 :timeZone string,
 :recentScheduledReleaseRecords
 [{:compilationResult string,
   :errorStatus {:code integer, :message string, :details [object]},
   :releaseTime string}],
 :releaseCompilationResult string,
 :disabled boolean}

optional:
updateMask <string> Optional. Specifies the fields to be updated in the release config. If left unset, all fields will be updated."
  ([name ReleaseConfig]
    (projects-locations-repositories-releaseConfigs-patch
      name
      ReleaseConfig
      nil))
  ([name ReleaseConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ReleaseConfig})))

(defn projects-locations-repositories-releaseConfigs-delete
  "Deletes a single ReleaseConfig.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.releaseConfigs/delete

name <string> Required. The release config's name."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-compilationResults-list
  "Lists CompilationResults in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.compilationResults/list

parent <string> Required. The repository in which to list compilation results. Must be in the format `projects/*/locations/*/repositories/*`.

optional:
pageSize <integer> Optional. Maximum number of compilation results to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default.
orderBy <string> Optional. This field only supports ordering by `name` and `create_time`. If unspecified, the server will choose the ordering. If specified, the default order is ascending for the `name` field.
filter <string> Optional. Filter for the returned list."
  ([parent]
    (projects-locations-repositories-compilationResults-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/compilationResults",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-compilationResults-get
  "Fetches a single CompilationResult.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.compilationResults/get

name <string> Required. The compilation result's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-compilationResults-create
  "Creates a new CompilationResult in a given project and location.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.compilationResults/create

parent <string> Required. The repository in which to create the compilation result. Must be in the format `projects/*/locations/*/repositories/*`.
CompilationResult:
{:dataformCoreVersion string,
 :workspace string,
 :compilationErrors
 [{:message string,
   :stack string,
   :path string,
   :actionTarget {:database string, :schema string, :name string}}],
 :name string,
 :codeCompilationConfig
 {:defaultNotebookRuntimeOptions {:gcsOutputBucket string},
  :defaultDatabase string,
  :defaultLocation string,
  :databaseSuffix string,
  :defaultSchema string,
  :tablePrefix string,
  :assertionSchema string,
  :schemaSuffix string,
  :vars object},
 :releaseConfig string,
 :gitCommitish string,
 :dataEncryptionState {:kmsKeyVersionName string},
 :resolvedGitCommitSha string}"
  [parent CompilationResult]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+parent}/compilationResults",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CompilationResult}))

(defn projects-locations-repositories-compilationResults-query
  "Returns CompilationResultActions in a given CompilationResult.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.compilationResults/query

name <string> Required. The compilation result's name.

optional:
pageSize <integer> Optional. Maximum number of compilation results to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Optional filter for the returned list. Filtering is only currently supported on the `file_path` field."
  ([name]
    (projects-locations-repositories-compilationResults-query
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+name}:query",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workflowConfigs-list
  "Lists WorkflowConfigs in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowConfigs/list

parent <string> Required. The repository in which to list workflow configs. Must be in the format `projects/*/locations/*/repositories/*`.

optional:
pageSize <integer> Optional. Maximum number of workflow configs to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default."
  ([parent]
    (projects-locations-repositories-workflowConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/workflowConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workflowConfigs-get
  "Fetches a single WorkflowConfig.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowConfigs/get

name <string> Required. The workflow config's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workflowConfigs-create
  "Creates a new WorkflowConfig in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowConfigs/create

parent <string> Required. The repository in which to create the workflow config. Must be in the format `projects/*/locations/*/repositories/*`.
WorkflowConfig:
{:name string,
 :releaseConfig string,
 :invocationConfig
 {:includedTargets [{:database string, :schema string, :name string}],
  :includedTags [string],
  :transitiveDependenciesIncluded boolean,
  :transitiveDependentsIncluded boolean,
  :fullyRefreshIncrementalTablesEnabled boolean,
  :serviceAccount string},
 :cronSchedule string,
 :timeZone string,
 :recentScheduledExecutionRecords
 [{:workflowInvocation string,
   :errorStatus {:code integer, :message string, :details [object]},
   :executionTime string}]}

optional:
workflowConfigId <string> Required. The ID to use for the workflow config, which will become the final component of the workflow config's resource name."
  ([parent WorkflowConfig]
    (projects-locations-repositories-workflowConfigs-create
      parent
      WorkflowConfig
      nil))
  ([parent WorkflowConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/workflowConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkflowConfig})))

(defn projects-locations-repositories-workflowConfigs-patch
  "Updates a single WorkflowConfig.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowConfigs/patch

name <string> Identifier. The workflow config's name.
WorkflowConfig:
{:name string,
 :releaseConfig string,
 :invocationConfig
 {:includedTargets [{:database string, :schema string, :name string}],
  :includedTags [string],
  :transitiveDependenciesIncluded boolean,
  :transitiveDependentsIncluded boolean,
  :fullyRefreshIncrementalTablesEnabled boolean,
  :serviceAccount string},
 :cronSchedule string,
 :timeZone string,
 :recentScheduledExecutionRecords
 [{:workflowInvocation string,
   :errorStatus {:code integer, :message string, :details [object]},
   :executionTime string}]}

optional:
updateMask <string> Optional. Specifies the fields to be updated in the workflow config. If left unset, all fields will be updated."
  ([name WorkflowConfig]
    (projects-locations-repositories-workflowConfigs-patch
      name
      WorkflowConfig
      nil))
  ([name WorkflowConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body WorkflowConfig})))

(defn projects-locations-repositories-workflowConfigs-delete
  "Deletes a single WorkflowConfig.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowConfigs/delete

name <string> Required. The workflow config's name."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workflowInvocations-list
  "Lists WorkflowInvocations in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowInvocations/list

parent <string> Required. The parent resource of the WorkflowInvocation type. Must be in the format `projects/*/locations/*/repositories/*`.

optional:
pageSize <integer> Optional. Maximum number of workflow invocations to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default.
orderBy <string> Optional. This field only supports ordering by `name`. If unspecified, the server will choose the ordering. If specified, the default order is ascending for the `name` field.
filter <string> Optional. Filter for the returned list."
  ([parent]
    (projects-locations-repositories-workflowInvocations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+parent}/workflowInvocations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-workflowInvocations-get
  "Fetches a single WorkflowInvocation.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowInvocations/get

name <string> Required. The workflow invocation resource's name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workflowInvocations-create
  "Creates a new WorkflowInvocation in a given Repository.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowInvocations/create

parent <string> Required. The repository in which to create the workflow invocation. Must be in the format `projects/*/locations/*/repositories/*`.
WorkflowInvocation:
{:compilationResult string,
 :workflowConfig string,
 :name string,
 :invocationConfig
 {:includedTargets [{:database string, :schema string, :name string}],
  :includedTags [string],
  :transitiveDependenciesIncluded boolean,
  :transitiveDependentsIncluded boolean,
  :fullyRefreshIncrementalTablesEnabled boolean,
  :serviceAccount string},
 :state
 [STATE_UNSPECIFIED RUNNING SUCCEEDED CANCELLED FAILED CANCELING],
 :invocationTiming {:startTime string, :endTime string},
 :resolvedCompilationResult string,
 :dataEncryptionState {:kmsKeyVersionName string}}"
  [parent WorkflowInvocation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+parent}/workflowInvocations",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body WorkflowInvocation}))

(defn projects-locations-repositories-workflowInvocations-delete
  "Deletes a single WorkflowInvocation.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowInvocations/delete

name <string> Required. The workflow invocation resource's name."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataform.googleapis.com/v1beta1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-workflowInvocations-cancel
  "Requests cancellation of a running WorkflowInvocation.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowInvocations/cancel

name <string> Required. The workflow invocation resource's name.
CancelWorkflowInvocationRequest:
object"
  [name CancelWorkflowInvocationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelWorkflowInvocationRequest}))

(defn projects-locations-repositories-workflowInvocations-query
  "Returns WorkflowInvocationActions in a given WorkflowInvocation.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.workflowInvocations/query

name <string> Required. The workflow invocation's name.

optional:
pageSize <integer> Optional. Maximum number of workflow invocations to return. The server may return fewer items than requested. If unspecified, the server will pick an appropriate default."
  ([name]
    (projects-locations-repositories-workflowInvocations-query
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+name}:query",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-commentThreads-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.commentThreads/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-repositories-commentThreads-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.commentThreads/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-repositories-commentThreads-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-commentThreads-comments-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.commentThreads.comments/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-repositories-commentThreads-comments-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.repositories.commentThreads.comments/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-repositories-commentThreads-comments-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.collections/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-collections-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.collections/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-collections-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataform.googleapis.com/v1beta1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataform/reference/rest/v1beta1/projects.locations.collections/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataform.googleapis.com/v1beta1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

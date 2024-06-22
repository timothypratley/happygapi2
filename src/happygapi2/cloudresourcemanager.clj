(ns happygapi2.cloudresourcemanager
  "Cloud Resource Manager API
Creates, reads, and updates metadata for Google Cloud Platform resource containers.
See: https://cloud.google.com/resource-manager"
  (:require [happy.oauth2.client :as client]))

(defn projects-get
  "Retrieves the project identified by the specified `name` (for example, `projects/415104041262`). The caller must have `resourcemanager.projects.get` permission for this project.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/get

name <string> Required. The name of the project (for example, `projects/415104041262`)."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-setIamPolicy
  "Sets the IAM access control policy for the specified project, in the format `projects/{ProjectIdOrNumber}` e.g. projects/123. CAUTION: This method will replace the existing policy, and cannot be used to append additional IAM settings. Note: Removing service accounts from policies or changing their roles can render services completely inoperable. It is important to understand how the service account is being used before removing or updating its roles. The following constraints apply when using `setIamPolicy()`: + Project does not support `allUsers` and `allAuthenticatedUsers` as `members` in a `Binding` of a `Policy`. + The owner role can be granted to a `user`, `serviceAccount`, or a group that is part of an organization. For example, group@myownpersonaldomain.com could be added as an owner to a project in the myownpersonaldomain.com organization, but not the examplepetstore.com organization. + Service accounts can be made owners of a project directly without any restrictions. However, to be added as an owner, a user must be invited using the Cloud Platform console and must accept the invitation. + A user cannot be granted the owner role using `setIamPolicy()`. The user must be granted the owner role using the Cloud Platform Console and must explicitly accept the invitation. + Invitations to grant the owner role cannot be sent using `setIamPolicy()`; they must be sent only using the Cloud Platform Console. + If the project is not part of an organization, there must be at least one owner who has accepted the Terms of Service (ToS) agreement in the policy. Calling `setIamPolicy()` to remove the last ToS-accepted owner from the policy will fail. This restriction also applies to legacy projects that no longer have owners who have accepted the ToS. Edits to IAM policies will be rejected until the lack of a ToS-accepting owner is rectified. If the project is part of an organization, you can remove all owners, potentially making the organization inaccessible.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/setIamPolicy

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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-patch
  "Updates the `display_name` and labels of the project identified by the specified `name` (for example, `projects/415104041262`). Deleting all labels requires an update mask for labels field. The caller must have `resourcemanager.projects.update` permission for this project.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/patch

name <string> Output only. The unique resource name of the project. It is an int64 generated number prefixed by \"projects/\". Example: `projects/415104041262`
Project:
{:tags object,
 :labels object,
 :deleteTime string,
 :parent string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED ACTIVE DELETE_REQUESTED],
 :updateTime string,
 :projectId string}

optional:
updateMask <string> Optional. An update mask to selectively update fields."
  ([name Project] (projects-patch name Project nil))
  ([name Project optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Project})))

(defn projects-testIamPermissions
  "Returns permissions that a caller has on the specified project, in the format `projects/{ProjectIdOrNumber}` e.g. projects/123..
https://cloud.google.com/resource-manager/reference/rest/v3/projects/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body TestIamPermissionsRequest}))

(defn projects-create
  "Request that a new project be created. The result is an `Operation` which can be used to track the creation process. This process usually takes a few seconds, but can sometimes take much longer. The tracking `Operation` is automatically deleted after a few hours, so there is no need to call `DeleteOperation`.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/create

Project:
{:tags object,
 :labels object,
 :deleteTime string,
 :parent string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED ACTIVE DELETE_REQUESTED],
 :updateTime string,
 :projectId string}"
  [Project]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/projects",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Project}))

(defn projects-move
  "Move a project to another place in your resource hierarchy, under a new resource parent. Returns an operation which can be used to track the process of the project move workflow. Upon success, the `Operation.response` field will be populated with the moved project. The caller must have `resourcemanager.projects.move` permission on the project, on the project's current and proposed new parent. If project has no current parent, or it currently does not have an associated organization resource, you will also need the `resourcemanager.projects.setIamPolicy` permission in the project. 
https://cloud.google.com/resource-manager/reference/rest/v3/projects/move

name <string> Required. The name of the project to move.
MoveProjectRequest:
{:destinationParent string}"
  [name MoveProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body MoveProjectRequest}))

(defn projects-delete
  "Marks the project identified by the specified `name` (for example, `projects/415104041262`) for deletion. This method will only affect the project if it has a lifecycle state of ACTIVE. This method changes the Project's lifecycle state from ACTIVE to DELETE_REQUESTED. The deletion starts at an unspecified time, at which point the Project is no longer accessible. Until the deletion completes, you can check the lifecycle state checked by retrieving the project with GetProject, and the project remains visible to ListProjects. However, you cannot update the project. After the deletion completes, the project is not retrievable by the GetProject, ListProjects, and SearchProjects methods. This method behaves idempotently, such that deleting a `DELETE_REQUESTED` project will not cause an error, but also won't do anything. The caller must have `resourcemanager.projects.delete` permissions for this project.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/delete

name <string> Required. The name of the Project (for example, `projects/415104041262`)."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-search
  "Search for projects that the caller has the `resourcemanager.projects.get` permission on, and also satisfy the specified query. This method returns projects in an unspecified order. This method is eventually consistent with project mutations; this means that a newly created project may not appear in the results or recent updates to an existing project may not be reflected in the results. To retrieve the latest state of a project, use the GetProject method.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/search

optional:
query <string> Optional. A query string for searching for projects that the caller has `resourcemanager.projects.get` permission to. If multiple fields are included in the query, then it will return results that match any of the fields. Some eligible fields are: ``` | Field | Description | |-------------------------|----------------------------------------------| | displayName, name | Filters by displayName. | | parent | Project's parent (for example: folders/123, organizations/*). Prefer parent field over parent.type and parent.id.| | parent.type | Parent's type: `folder` or `organization`. | | parent.id | Parent's id number (for example: 123) | | id, projectId | Filters by projectId. | | state, lifecycleState | Filters by state. | | labels | Filters by label name or value. | | labels.\\ (where *key* is the name of a label) | Filters by label name.| ``` Search expressions are case insensitive. Some examples queries: ``` | Query | Description | |------------------|-----------------------------------------------------| | name:how* | The project's name starts with \"how\". | | name:Howl | The project's name is `Howl` or `howl`. | | name:HOWL | Equivalent to above. | | NAME:howl | Equivalent to above. | | labels.color:* | The project has the label `color`. | | labels.color:red | The project's label `color` has the value `red`. | | labels.color:red labels.size:big | The project's label `color` has the value `red` or its label `size` has the value `big`. | ``` If no query is specified, the call will return projects for which the user has the `resourcemanager.projects.get` permission.
pageSize <integer> Optional. The maximum number of projects to return in the response. The server can return fewer projects than requested. If unspecified, server picks an appropriate default."
  ([] (projects-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/projects:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-getIamPolicy
  "Returns the IAM access control policy for the specified project, in the format `projects/{ProjectIdOrNumber}` e.g. projects/123. Permission is denied if the policy or the resource do not exist.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn projects-undelete
  "Restores the project identified by the specified `name` (for example, `projects/415104041262`). You can only use this method for a project that has a lifecycle state of DELETE_REQUESTED. After deletion starts, the project cannot be restored. The caller must have `resourcemanager.projects.undelete` permission for this project.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/undelete

name <string> Required. The name of the project (for example, `projects/415104041262`). Required.
UndeleteProjectRequest:
object"
  [name UndeleteProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}:undelete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UndeleteProjectRequest}))

(defn projects-list
  "Lists projects that are direct children of the specified folder or organization resource. `list()` provides a strongly consistent view of the projects underneath the specified parent resource. `list()` returns projects sorted based upon the (ascending) lexical ordering of their `display_name`. The caller must have `resourcemanager.projects.list` permission on the identified parent.
https://cloud.google.com/resource-manager/reference/rest/v3/projects/list

optional:
parent <string> Required. The name of the parent resource whose projects are being listed. Only children of this parent resource are listed; descendants are not listed. If the parent is a folder, use the value `folders/{folder_id}`. If the parent is an organization, use the value `organizations/{org_id}`.
pageSize <integer> Optional. The maximum number of projects to return in the response. The server can return fewer projects than requested. If unspecified, server picks an appropriate default.
showDeleted <boolean> Optional. Indicate that projects in the `DELETE_REQUESTED` state should also be returned. Normally only `ACTIVE` projects are returned."
  ([] (projects-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/projects",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn folders-get
  "Retrieves a folder identified by the supplied resource name. Valid folder resource names have the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have `resourcemanager.folders.get` permission on the identified folder.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/get

name <string> Required. The resource name of the folder to retrieve. Must be of the form `folders/{folder_id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn folders-setIamPolicy
  "Sets the access control policy on a folder, replacing any existing policy. The `resource` field should be the folder's resource name, for example: \"folders/1234\". The caller must have `resourcemanager.folders.setIamPolicy` permission on the identified folder.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/setIamPolicy

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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn folders-patch
  "Updates a folder, changing its `display_name`. Changes to the folder `display_name` will be rejected if they violate either the `display_name` formatting rules or the naming constraints described in the CreateFolder documentation. The folder's `display_name` must start and end with a letter or digit, may contain letters, digits, spaces, hyphens and underscores and can be between 3 and 30 characters. This is captured by the regular expression: `\\p{L}\\p{N}{1,28}[\\p{L}\\p{N}]`. The caller must have `resourcemanager.folders.update` permission on the identified folder. If the update fails due to the unique name constraint then a `PreconditionFailure` explaining this violation will be returned in the Status.details field.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/patch

name <string> Output only. The resource name of the folder. Its format is `folders/{folder_id}`, for example: \"folders/1234\".
Folder:
{:tags object,
 :deleteTime string,
 :parent string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED ACTIVE DELETE_REQUESTED],
 :updateTime string}

optional:
updateMask <string> Required. Fields to be updated. Only the `display_name` can be updated."
  ([name Folder] (folders-patch name Folder nil))
  ([name Folder optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Folder})))

(defn folders-testIamPermissions
  "Returns permissions that a caller has on the specified folder. The `resource` field should be the folder's resource name, for example: \"folders/1234\". There are no permissions required for making this API call.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn folders-create
  "Creates a folder in the resource hierarchy. Returns an `Operation` which can be used to track the progress of the folder creation workflow. Upon success, the `Operation.response` field will be populated with the created Folder. In order to succeed, the addition of this new folder must not violate the folder naming, height, or fanout constraints. + The folder's `display_name` must be distinct from all other folders that share its parent. + The addition of the folder must not cause the active folder hierarchy to exceed a height of 10. Note, the full active + deleted folder hierarchy is allowed to reach a height of 20; this provides additional headroom when moving folders that contain deleted folders. + The addition of the folder must not cause the total number of folders under its parent to exceed 300. If the operation fails due to a folder constraint violation, some errors may be returned by the `CreateFolder` request, with status code `FAILED_PRECONDITION` and an error description. Other folder constraint violations will be communicated in the `Operation`, with the specific `PreconditionFailure` returned in the details list in the `Operation.error` field. The caller must have `resourcemanager.folders.create` permission on the identified parent.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/create

Folder:
{:tags object,
 :deleteTime string,
 :parent string,
 :displayName string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED ACTIVE DELETE_REQUESTED],
 :updateTime string}"
  [Folder]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/folders",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Folder}))

(defn folders-move
  "Moves a folder under a new resource parent. Returns an `Operation` which can be used to track the progress of the folder move workflow. Upon success, the `Operation.response` field will be populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the failure cause will be returned - if the failure occurs synchronously then the `FolderOperationError` will be returned in the `Status.details` field. If it occurs asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as an aid to stateless clients. Folder moves will be rejected if they violate either the naming, height, or fanout constraints described in the CreateFolder documentation. The caller must have `resourcemanager.folders.move` permission on the folder's current and proposed new parent.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/move

name <string> Required. The resource name of the Folder to move. Must be of the form folders/{folder_id}
MoveFolderRequest:
{:destinationParent string}"
  [name MoveFolderRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body MoveFolderRequest}))

(defn folders-delete
  "Requests deletion of a folder. The folder is moved into the DELETE_REQUESTED state immediately, and is deleted approximately 30 days later. This method may only be called on an empty folder, where a folder is empty if it doesn't contain any folders or projects in the ACTIVE state. If called on a folder in DELETE_REQUESTED state the operation will result in a no-op success. The caller must have `resourcemanager.folders.delete` permission on the identified folder.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/delete

name <string> Required. The resource name of the folder to be deleted. Must be of the form `folders/{folder_id}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-search
  "Search for folders that match specific filter criteria. `search()` provides an eventually consistent view of the folders a user has access to which meet the specified filter criteria. This will only return folders on which the caller has the permission `resourcemanager.folders.get`.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/search

optional:
pageSize <integer> Optional. The maximum number of folders to return in the response. The server can return fewer folders than requested. If unspecified, server picks an appropriate default.
query <string> Optional. Search criteria used to select the folders to return. If no search criteria is specified then all accessible folders will be returned. Query expressions can be used to restrict results based upon displayName, state and parent, where the operators `=` (`:`) `NOT`, `AND` and `OR` can be used along with the suffix wildcard symbol `*`. The `displayName` field in a query expression should use escaped quotes for values that include whitespace to prevent unexpected behavior. ``` | Field | Description | |-------------------------|----------------------------------------| | displayName | Filters by displayName. | | parent | Filters by parent (for example: folders/123). | | state, lifecycleState | Filters by state. | ``` Some example queries are: * Query `displayName=Test*` returns Folder resources whose display name starts with \"Test\". * Query `state=ACTIVE` returns Folder resources with `state` set to `ACTIVE`. * Query `parent=folders/123` returns Folder resources that have `folders/123` as a parent resource. * Query `parent=folders/123 AND state=ACTIVE` returns active Folder resources that have `folders/123` as a parent resource. * Query `displayName=\\\\\"Test String\\\\\"` returns Folder resources with display names that include both \"Test\" and \"String\"."
  ([] (folders-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/folders:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn folders-getIamPolicy
  "Gets the access control policy for a folder. The returned policy may be empty if no such policy or resource exists. The `resource` field should be the folder's resource name, for example: \"folders/1234\". The caller must have `resourcemanager.folders.getIamPolicy` permission on the identified folder.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn folders-undelete
  "Cancels the deletion request for a folder. This method may be called on a folder in any state. If the folder is in the ACTIVE state the result will be a no-op success. In order to succeed, the folder's parent must be in the ACTIVE state. In addition, reintroducing the folder into the tree must not violate folder naming, height, and fanout constraints described in the CreateFolder documentation. The caller must have `resourcemanager.folders.undelete` permission on the identified folder.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/undelete

name <string> Required. The resource name of the folder to undelete. Must be of the form `folders/{folder_id}`.
UndeleteFolderRequest:
object"
  [name UndeleteFolderRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}:undelete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UndeleteFolderRequest}))

(defn folders-list
  "Lists the folders that are direct descendants of supplied parent resource. `list()` provides a strongly consistent view of the folders underneath the specified parent resource. `list()` returns folders sorted based upon the (ascending) lexical ordering of their display_name. The caller must have `resourcemanager.folders.list` permission on the identified parent.
https://cloud.google.com/resource-manager/reference/rest/v3/folders/list

optional:
parent <string> Required. The name of the parent resource whose folders are being listed. Only children of this parent resource are listed; descendants are not listed. If the parent is a folder, use the value `folders/{folder_id}`. If the parent is an organization, use the value `organizations/{org_id}`. Access to this method is controlled by checking the `resourcemanager.folders.list` permission on the `parent`.
pageSize <integer> Optional. The maximum number of folders to return in the response. The server can return fewer folders than requested. If unspecified, server picks an appropriate default.
showDeleted <boolean> Optional. Controls whether folders in the DELETE_REQUESTED state should be returned. Defaults to false."
  ([] (folders-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/folders",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tagKeys-get
  "Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the key does not exist or the user does not have permission to view it.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/get

name <string> Required. A resource name in the format `tagKeys/{id}`, such as `tagKeys/123`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn tagKeys-setIamPolicy
  "Sets the access control policy on a TagKey, replacing any existing policy. The `resource` field should be the TagKey's resource name. For example, \"tagKeys/1234\". The caller must have `resourcemanager.tagKeys.setIamPolicy` permission on the identified tagValue.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/setIamPolicy

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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn tagKeys-patch
  "Updates the attributes of the TagKey resource.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/patch

name <string> Immutable. The resource name for a TagKey. Must be in the format `tagKeys/{tag_key_id}`, where `tag_key_id` is the generated numeric id for the TagKey.
TagKey:
{:description string,
 :parent string,
 :purpose [PURPOSE_UNSPECIFIED GCE_FIREWALL DATA_GOVERNANCE],
 :name string,
 :createTime string,
 :namespacedName string,
 :etag string,
 :updateTime string,
 :shortName string,
 :purposeData object}

optional:
updateMask <string> Fields to be updated. The mask may only contain `description` or `etag`. If omitted entirely, both `description` and `etag` are assumed to be significant.
validateOnly <boolean> Set as true to perform validations necessary for updating the resource, but not actually perform the action."
  ([name TagKey] (tagKeys-patch name TagKey nil))
  ([name TagKey optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TagKey})))

(defn tagKeys-testIamPermissions
  "Returns permissions that a caller has on the specified TagKey. The `resource` field should be the TagKey's resource name. For example, \"tagKeys/1234\". There are no permissions required for making this API call.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn tagKeys-create
  "Creates a new TagKey. If another request with the same parameters is sent while the original request is in process, the second request will receive an error. A maximum of 1000 TagKeys can exist under a parent at any given time.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/create

TagKey:
{:description string,
 :parent string,
 :purpose [PURPOSE_UNSPECIFIED GCE_FIREWALL DATA_GOVERNANCE],
 :name string,
 :createTime string,
 :namespacedName string,
 :etag string,
 :updateTime string,
 :shortName string,
 :purposeData object}

optional:
validateOnly <boolean> Optional. Set to true to perform validations necessary for creating the resource, but not actually perform the action."
  ([TagKey] (tagKeys-create TagKey nil))
  ([TagKey optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagKeys",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TagKey})))

(defn tagKeys-getNamespaced
  "Retrieves a TagKey by its namespaced name. This method will return `PERMISSION_DENIED` if the key does not exist or the user does not have permission to view it.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/getNamespaced

optional:
name <string> Required. A namespaced tag key name in the format `{parentId}/{tagKeyShort}`, such as `42/foo` for a key with short name \"foo\" under the organization with ID 42 or `r2-d2/bar` for a key with short name \"bar\" under the project `r2-d2`."
  ([] (tagKeys-getNamespaced nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagKeys/namespaced",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tagKeys-delete
  "Deletes a TagKey. The TagKey cannot be deleted if it has any child TagValues.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/delete

name <string> Required. The resource name of a TagKey to be deleted in the format `tagKeys/123`. The TagKey cannot be a parent of any existing TagValues or it will not be deleted successfully.

optional:
validateOnly <boolean> Optional. Set as true to perform validations necessary for deletion, but not actually perform the action.
etag <string> Optional. The etag known to the client for the expected state of the TagKey. This is to be used for optimistic concurrency."
  ([name] (tagKeys-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn tagKeys-getIamPolicy
  "Gets the access control policy for a TagKey. The returned policy may be empty if no such policy or resource exists. The `resource` field should be the TagKey's resource name. For example, \"tagKeys/1234\". The caller must have `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy` permission on the specified TagKey.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn tagKeys-list
  "Lists all TagKeys for a parent resource.
https://cloud.google.com/resource-manager/reference/rest/v3/tagKeys/list

optional:
parent <string> Required. The resource name of the TagKey's parent. Must be of the form `organizations/{org_id}` or `projects/{project_id}` or `projects/{project_number}`
pageSize <integer> Optional. The maximum number of TagKeys to return in the response. The server allows a maximum of 300 TagKeys to return. If unspecified, the server will use 100 as the default."
  ([] (tagKeys-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagKeys",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn organizations-get
  "Fetches an organization resource identified by the specified resource name.
https://cloud.google.com/resource-manager/reference/rest/v3/organizations/get

name <string> Required. The resource name of the Organization to fetch. This is the organization's relative path in the API, formatted as \"organizations/[organizationId]\". For example, \"organizations/1234\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn organizations-search
  "Searches organization resources that are visible to the user and satisfy the specified filter. This method returns organizations in an unspecified order. New organizations do not necessarily appear at the end of the results, and may take a small amount of time to appear. Search will only return organizations on which the user has the permission `resourcemanager.organizations.get` or has super admin privileges.
https://cloud.google.com/resource-manager/reference/rest/v3/organizations/search

optional:
pageSize <integer> Optional. The maximum number of organizations to return in the response. The server can return fewer organizations than requested. If unspecified, server picks an appropriate default.
query <string> Optional. An optional query string used to filter the Organizations to return in the response. Query rules are case-insensitive. ``` | Field | Description | |------------------|--------------------------------------------| | directoryCustomerId, owner.directoryCustomerId | Filters by directory customer id. | | domain | Filters by domain. | ``` Organizations may be queried by `directoryCustomerId` or by `domain`, where the domain is a G Suite domain, for example: * Query `directorycustomerid:123456789` returns Organization resources with `owner.directory_customer_id` equal to `123456789`. * Query `domain:google.com` returns Organization resources corresponding to the domain `google.com`."
  ([] (organizations-search nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/organizations:search",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn organizations-getIamPolicy
  "Gets the access control policy for an organization resource. The policy may be empty if no such policy or resource exists. The `resource` field should be the organization's resource name, for example: \"organizations/123\". Authorization requires the IAM permission `resourcemanager.organizations.getIamPolicy` on the specified organization.
https://cloud.google.com/resource-manager/reference/rest/v3/organizations/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn organizations-setIamPolicy
  "Sets the access control policy on an organization resource. Replaces any existing policy. The `resource` field should be the organization's resource name, for example: \"organizations/123\". Authorization requires the IAM permission `resourcemanager.organizations.setIamPolicy` on the specified organization.
https://cloud.google.com/resource-manager/reference/rest/v3/organizations/setIamPolicy

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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn organizations-testIamPermissions
  "Returns the permissions that a caller has on the specified organization. The `resource` field should be the organization's resource name, for example: \"organizations/123\". There are no permissions required for making this API call.
https://cloud.google.com/resource-manager/reference/rest/v3/organizations/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body TestIamPermissionsRequest}))

(defn liens-list
  "List all Liens applied to the `parent` resource. Callers of this method will require permission on the `parent` resource. For example, a Lien with a `parent` of `projects/1234` requires permission `resourcemanager.projects.get`.
https://cloud.google.com/resource-manager/reference/rest/v3/liens/list

optional:
parent <string> Required. The name of the resource to list all attached Liens. For example, `projects/1234`. (google.api.field_policy).resource_type annotation is not set since the parent depends on the meta api implementation. This field could be a project or other sub project resources.
pageSize <integer> The maximum number of items to return. This is a suggestion for the server. The server can return fewer liens than requested. If unspecified, server picks an appropriate default."
  ([] (liens-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/liens",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn liens-get
  "Retrieve a Lien by `name`. Callers of this method will require permission on the `parent` resource. For example, a Lien with a `parent` of `projects/1234` requires permission `resourcemanager.projects.get`
https://cloud.google.com/resource-manager/reference/rest/v3/liens/get

name <string> Required. The name/identifier of the Lien."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn liens-create
  "Create a Lien which applies to the resource denoted by the `parent` field. Callers of this method will require permission on the `parent` resource. For example, applying to `projects/1234` requires permission `resourcemanager.projects.updateLiens`. NOTE: Some resources may limit the number of Liens which may be applied.
https://cloud.google.com/resource-manager/reference/rest/v3/liens/create

Lien:
{:name string,
 :parent string,
 :restrictions [string],
 :reason string,
 :origin string,
 :createTime string}"
  [Lien]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/liens",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body Lien}))

(defn liens-delete
  "Delete a Lien by `name`. Callers of this method will require permission on the `parent` resource. For example, a Lien with a `parent` of `projects/1234` requires permission `resourcemanager.projects.updateLiens`.
https://cloud.google.com/resource-manager/reference/rest/v3/liens/delete

name <string> Required. The name/identifier of the Lien to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn effectiveTags-list
  "Return a list of effective tags for the given Google Cloud resource, as specified in `parent`.
https://cloud.google.com/resource-manager/reference/rest/v3/effectiveTags/list

optional:
parent <string> Required. The full resource name of a resource for which you want to list the effective tags. E.g. \"//cloudresourcemanager.googleapis.com/projects/123\"
pageSize <integer> Optional. The maximum number of effective tags to return in the response. The server allows a maximum of 300 effective tags to return in a single page. If unspecified, the server will use 100 as the default."
  ([] (effectiveTags-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/effectiveTags",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tagBindings-list
  "Lists the TagBindings for the given Google Cloud resource, as specified with `parent`. NOTE: The `parent` field is expected to be a full resource name: https://cloud.google.com/apis/design/resource_names#full_resource_name
https://cloud.google.com/resource-manager/reference/rest/v3/tagBindings/list

optional:
parent <string> Required. The full resource name of a resource for which you want to list existing TagBindings. E.g. \"//cloudresourcemanager.googleapis.com/projects/123\"
pageSize <integer> Optional. The maximum number of TagBindings to return in the response. The server allows a maximum of 300 TagBindings to return. If unspecified, the server will use 100 as the default."
  ([] (tagBindings-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagBindings",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tagBindings-create
  "Creates a TagBinding between a TagValue and a Google Cloud resource.
https://cloud.google.com/resource-manager/reference/rest/v3/tagBindings/create

TagBinding:
{:name string,
 :parent string,
 :tagValue string,
 :tagValueNamespacedName string}

optional:
validateOnly <boolean> Optional. Set to true to perform the validations necessary for creating the resource, but not actually perform the action."
  ([TagBinding] (tagBindings-create TagBinding nil))
  ([TagBinding optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagBindings",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TagBinding})))

(defn tagBindings-delete
  "Deletes a TagBinding.
https://cloud.google.com/resource-manager/reference/rest/v3/tagBindings/delete

name <string> Required. The name of the TagBinding. This is a String of the form: `tagBindings/{id}` (e.g. `tagBindings/%2F%2Fcloudresourcemanager.googleapis.com%2Fprojects%2F123/tagValues/456`)."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/resource-manager/reference/rest/v3/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn tagValues-get
  "Retrieves a TagValue. This method will return `PERMISSION_DENIED` if the value does not exist or the user does not have permission to view it.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/get

name <string> Required. Resource name for TagValue to be fetched in the format `tagValues/456`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn tagValues-setIamPolicy
  "Sets the access control policy on a TagValue, replacing any existing policy. The `resource` field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must have `resourcemanager.tagValues.setIamPolicy` permission on the identified tagValue.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/setIamPolicy

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
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn tagValues-patch
  "Updates the attributes of the TagValue resource.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/patch

name <string> Immutable. Resource name for TagValue in the format `tagValues/456`.
TagValue:
{:name string,
 :parent string,
 :shortName string,
 :namespacedName string,
 :description string,
 :createTime string,
 :updateTime string,
 :etag string}

optional:
updateMask <string> Optional. Fields to be updated.
validateOnly <boolean> Optional. True to perform validations necessary for updating the resource, but not actually perform the action."
  ([name TagValue] (tagValues-patch name TagValue nil))
  ([name TagValue optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TagValue})))

(defn tagValues-testIamPermissions
  "Returns permissions that a caller has on the specified TagValue. The `resource` field should be the TagValue's resource name. For example: `tagValues/1234`. There are no permissions required for making this API call.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn tagValues-create
  "Creates a TagValue as a child of the specified TagKey. If a another request with the same parameters is sent while the original request is in process the second request will receive an error. A maximum of 1000 TagValues can exist under a TagKey at any given time.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/create

TagValue:
{:name string,
 :parent string,
 :shortName string,
 :namespacedName string,
 :description string,
 :createTime string,
 :updateTime string,
 :etag string}

optional:
validateOnly <boolean> Optional. Set as true to perform the validations necessary for creating the resource, but not actually perform the action."
  ([TagValue] (tagValues-create TagValue nil))
  ([TagValue optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagValues",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TagValue})))

(defn tagValues-getNamespaced
  "Retrieves a TagValue by its namespaced name. This method will return `PERMISSION_DENIED` if the value does not exist or the user does not have permission to view it.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/getNamespaced

optional:
name <string> Required. A namespaced tag value name in the following format: `{parentId}/{tagKeyShort}/{tagValueShort}` Examples: - `42/foo/abc` for a value with short name \"abc\" under the key with short name \"foo\" under the organization with ID 42 - `r2-d2/bar/xyz` for a value with short name \"xyz\" under the key with short name \"bar\" under the project with ID \"r2-d2\""
  ([] (tagValues-getNamespaced nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagValues/namespaced",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tagValues-delete
  "Deletes a TagValue. The TagValue cannot have any bindings when it is deleted.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/delete

name <string> Required. Resource name for TagValue to be deleted in the format tagValues/456.

optional:
validateOnly <boolean> Optional. Set as true to perform the validations necessary for deletion, but not actually perform the action.
etag <string> Optional. The etag known to the client for the expected state of the TagValue. This is to be used for optimistic concurrency."
  ([name] (tagValues-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn tagValues-getIamPolicy
  "Gets the access control policy for a TagValue. The returned policy may be empty if no such policy or resource exists. The `resource` field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must have the `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on the identified TagValue to get the access control policy.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudresourcemanager.googleapis.com/v3/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body GetIamPolicyRequest}))

(defn tagValues-list
  "Lists all TagValues for a specific TagKey.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/list

optional:
parent <string> Required. Resource name for the parent of the TagValues to be listed, in the format `tagKeys/123` or `tagValues/123`.
pageSize <integer> Optional. The maximum number of TagValues to return in the response. The server allows a maximum of 300 TagValues to return. If unspecified, the server will use 100 as the default."
  ([] (tagValues-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/tagValues",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn tagValues-tagHolds-create
  "Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same resource and origin exists under the same TagValue.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/tagHolds/create

parent <string> Required. The resource name of the TagHold's parent TagValue. Must be of the form: `tagValues/{tag-value-id}`.
TagHold:
{:name string,
 :holder string,
 :origin string,
 :helpLink string,
 :createTime string}

optional:
validateOnly <boolean> Optional. Set to true to perform the validations necessary for creating the resource, but not actually perform the action."
  ([parent TagHold] (tagValues-tagHolds-create parent TagHold nil))
  ([parent TagHold optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+parent}/tagHolds",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TagHold})))

(defn tagValues-tagHolds-delete
  "Deletes a TagHold.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/tagHolds/delete

name <string> Required. The resource name of the TagHold to delete. Must be of the form: `tagValues/{tag-value-id}/tagHolds/{tag-hold-id}`.

optional:
validateOnly <boolean> Optional. Set to true to perform the validations necessary for deleting the resource, but not actually perform the action."
  ([name] (tagValues-tagHolds-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn tagValues-tagHolds-list
  "Lists TagHolds under a TagValue.
https://cloud.google.com/resource-manager/reference/rest/v3/tagValues/tagHolds/list

parent <string> Required. The resource name of the parent TagValue. Must be of the form: `tagValues/{tag-value-id}`.

optional:
pageSize <integer> Optional. The maximum number of TagHolds to return in the response. The server allows a maximum of 300 TagHolds to return. If unspecified, the server will use 100 as the default.
filter <string> Optional. Criteria used to select a subset of TagHolds parented by the TagValue to return. This field follows the syntax defined by aip.dev/160; the `holder` and `origin` fields are supported for filtering. Currently only `AND` syntax is supported. Some example queries are: * `holder = //compute.googleapis.com/compute/projects/myproject/regions/us-east-1/instanceGroupManagers/instance-group` * `origin = 35678234` * `holder = //compute.googleapis.com/compute/projects/myproject/regions/us-east-1/instanceGroupManagers/instance-group AND origin = 35678234`"
  ([parent] (tagValues-tagHolds-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudresourcemanager.googleapis.com/v3/{+parent}/tagHolds",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

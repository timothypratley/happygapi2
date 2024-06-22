(ns happygapi2.drive
  "Google Drive API
The Google Drive API allows clients to access resources from Google Drive.
See: https://developers.google.com/drive/"
  (:require [happy.oauth2.client :as client]))

(defn apps-get
  "Gets a specific app.
https://developers.google.com/drive/api/reference/rest/v3/apps/get

appId <string> The ID of the app."
  [appId]
  (client/api-request
    {:method "GET",
     :uri-template "https://www.googleapis.com/drive/v3/apps/{appId}",
     :uri-template-args {:appId appId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.appdata"
      "https://www.googleapis.com/auth/drive.apps.readonly"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.metadata"
      "https://www.googleapis.com/auth/drive.metadata.readonly"
      "https://www.googleapis.com/auth/drive.readonly"]}))

(defn apps-list
  "Lists a user's installed apps.
https://developers.google.com/drive/api/reference/rest/v3/apps/list

optional:
appFilterExtensions <string> A comma-separated list of file extensions to limit returned results. All results within the given app query scope which can open any of the given file extensions are included in the response. If `appFilterMimeTypes` are provided as well, the result is a union of the two resulting app lists.
appFilterMimeTypes <string> A comma-separated list of file extensions to limit returned results. All results within the given app query scope which can open any of the given MIME types will be included in the response. If `appFilterExtensions` are provided as well, the result is a union of the two resulting app lists.
languageCode <string> A language or locale code, as defined by BCP 47, with some extensions from Unicode's LDML format (http://www.unicode.org/reports/tr35/)."
  ([] (apps-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://www.googleapis.com/drive/v3/apps",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.apps.readonly"]})))

(defn permissions-create
  "Creates a permission for a file or shared drive. **Warning:** Concurrent permissions operations on the same file are not supported; only the last update is applied.
https://developers.google.com/drive/api/reference/rest/v3/permissions/create

fileId <string> The ID of the file or shared drive.
Permission:
{:role string,
 :deleted boolean,
 :allowFileDiscovery boolean,
 :expirationTime string,
 :displayName string,
 :emailAddress string,
 :type string,
 :permissionDetails
 [{:permissionType string,
   :inheritedFrom string,
   :role string,
   :inherited boolean}],
 :teamDrivePermissionDetails
 [{:teamDrivePermissionType string,
   :inheritedFrom string,
   :role string,
   :inherited boolean}],
 :id string,
 :kind string,
 :pendingOwner boolean,
 :domain string,
 :view string,
 :photoLink string}

optional:
transferOwnership <boolean> Whether to transfer ownership to the specified user and downgrade the current owner to a writer. This parameter is required as an acknowledgement of the side effect.
moveToNewOwnersRoot <boolean> This parameter will only take effect if the item is not in a shared drive and the request is attempting to transfer the ownership of the item. If set to `true`, the item will be moved to the new owner's My Drive root folder and all prior parents removed. If set to `false`, parents are not changed.
emailMessage <string> A plain text custom message to include in the notification email.
enforceSingleParent <boolean> Deprecated: See `moveToNewOwnersRoot` for details.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if the file ID parameter refers to a shared drive and the requester is an administrator of the domain to which the shared drive belongs.
sendNotificationEmail <boolean> Whether to send a notification email when sharing to users or groups. This defaults to true for users and groups, and is not allowed for other requests. It must not be disabled for ownership transfers.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead."
  ([fileId Permission] (permissions-create fileId Permission nil))
  ([fileId Permission optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/permissions",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"],
       :body Permission})))

(defn permissions-delete
  "Deletes a permission. **Warning:** Concurrent permissions operations on the same file are not supported; only the last update is applied.
https://developers.google.com/drive/api/reference/rest/v3/permissions/delete

fileId <string> The ID of the file or shared drive.
permissionId <string> The ID of the permission.

optional:
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if the file ID parameter refers to a shared drive and the requester is an administrator of the domain to which the shared drive belongs."
  ([fileId permissionId] (permissions-delete fileId permissionId nil))
  ([fileId permissionId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/permissions/{permissionId}",
       :uri-template-args {:fileId fileId, :permissionId permissionId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"]})))

(defn permissions-get
  "Gets a permission by ID.
https://developers.google.com/drive/api/reference/rest/v3/permissions/get

fileId <string> The ID of the file.
permissionId <string> The ID of the permission.

optional:
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if the file ID parameter refers to a shared drive and the requester is an administrator of the domain to which the shared drive belongs."
  ([fileId permissionId] (permissions-get fileId permissionId nil))
  ([fileId permissionId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/permissions/{permissionId}",
       :uri-template-args {:fileId fileId, :permissionId permissionId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn permissions-list
  "Lists a file's or shared drive's permissions.
https://developers.google.com/drive/api/reference/rest/v3/permissions/list

fileId <string> The ID of the file or shared drive.

optional:
pageSize <integer> The maximum number of permissions to return per page. When not set for files in a shared drive, at most 100 results will be returned. When not set for files that are not in a shared drive, the entire list will be returned.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if the file ID parameter refers to a shared drive and the requester is an administrator of the domain to which the shared drive belongs.
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported."
  ([fileId] (permissions-list fileId nil))
  ([fileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/permissions",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn permissions-update
  "Updates a permission with patch semantics. **Warning:** Concurrent permissions operations on the same file are not supported; only the last update is applied.
https://developers.google.com/drive/api/reference/rest/v3/permissions/update

fileId <string> The ID of the file or shared drive.
permissionId <string> The ID of the permission.
Permission:
{:role string,
 :deleted boolean,
 :allowFileDiscovery boolean,
 :expirationTime string,
 :displayName string,
 :emailAddress string,
 :type string,
 :permissionDetails
 [{:permissionType string,
   :inheritedFrom string,
   :role string,
   :inherited boolean}],
 :teamDrivePermissionDetails
 [{:teamDrivePermissionType string,
   :inheritedFrom string,
   :role string,
   :inherited boolean}],
 :id string,
 :kind string,
 :pendingOwner boolean,
 :domain string,
 :view string,
 :photoLink string}

optional:
removeExpiration <boolean> Whether to remove the expiration date.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
transferOwnership <boolean> Whether to transfer ownership to the specified user and downgrade the current owner to a writer. This parameter is required as an acknowledgement of the side effect.
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if the file ID parameter refers to a shared drive and the requester is an administrator of the domain to which the shared drive belongs."
  ([fileId permissionId Permission]
    (permissions-update fileId permissionId Permission nil))
  ([fileId permissionId Permission optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/permissions/{permissionId}",
       :uri-template-args {:fileId fileId, :permissionId permissionId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"],
       :body Permission})))

(defn teamdrives-create
  "Deprecated: Use `drives.create` instead.
https://developers.google.com/drive/api/reference/rest/v3/teamdrives/create

requestId <string> Required. An ID, such as a random UUID, which uniquely identifies this user's request for idempotent creation of a Team Drive. A repeated request by the same user and with the same request ID will avoid creating duplicates by attempting to create the same Team Drive. If the Team Drive already exists a 409 error will be returned.
TeamDrive:
{:capabilities
 {:canChangeDomainUsersOnlyRestriction boolean,
  :canCopy boolean,
  :canManageMembers boolean,
  :canTrashChildren boolean,
  :canChangeTeamDriveBackground boolean,
  :canDownload boolean,
  :canDeleteTeamDrive boolean,
  :canDeleteChildren boolean,
  :canListChildren boolean,
  :canRename boolean,
  :canRenameTeamDrive boolean,
  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction
  boolean,
  :canResetTeamDriveRestrictions boolean,
  :canReadRevisions boolean,
  :canChangeCopyRequiresWriterPermissionRestriction boolean,
  :canEdit boolean,
  :canComment boolean,
  :canChangeTeamMembersOnlyRestriction boolean,
  :canRemoveChildren boolean,
  :canAddChildren boolean,
  :canShare boolean},
 :restrictions
 {:copyRequiresWriterPermission boolean,
  :domainUsersOnly boolean,
  :teamMembersOnly boolean,
  :adminManagedRestrictions boolean,
  :sharingFoldersRequiresOrganizerPermission boolean},
 :themeId string,
 :backgroundImageFile
 {:id string, :xCoordinate number, :yCoordinate number, :width number},
 :name string,
 :orgUnitId string,
 :createdTime string,
 :id string,
 :kind string,
 :colorRgb string,
 :backgroundImageLink string}"
  [requestId TeamDrive]
  (client/api-request
    {:method "POST",
     :uri-template "https://www.googleapis.com/drive/v3/teamdrives",
     :uri-template-args {},
     :query-params {:requestId requestId},
     :scopes ["https://www.googleapis.com/auth/drive"],
     :body TeamDrive}))

(defn teamdrives-delete
  "Deprecated: Use `drives.delete` instead.
https://developers.google.com/drive/api/reference/rest/v3/teamdrives/delete

teamDriveId <string> The ID of the Team Drive"
  [teamDriveId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/drive/v3/teamdrives/{teamDriveId}",
     :uri-template-args {:teamDriveId teamDriveId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/drive"]}))

(defn teamdrives-get
  "Deprecated: Use `drives.get` instead.
https://developers.google.com/drive/api/reference/rest/v3/teamdrives/get

teamDriveId <string> The ID of the Team Drive

optional:
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if they are an administrator of the domain to which the Team Drive belongs."
  ([teamDriveId] (teamdrives-get teamDriveId nil))
  ([teamDriveId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/teamdrives/{teamDriveId}",
       :uri-template-args {:teamDriveId teamDriveId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn teamdrives-list
  "Deprecated: Use `drives.list` instead.
https://developers.google.com/drive/api/reference/rest/v3/teamdrives/list

optional:
pageSize <integer> Maximum number of Team Drives to return.
q <string> Query string for searching Team Drives.
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then all Team Drives of the domain in which the requester is an administrator are returned."
  ([] (teamdrives-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://www.googleapis.com/drive/v3/teamdrives",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn teamdrives-update
  "Deprecated: Use `drives.update` instead.
https://developers.google.com/drive/api/reference/rest/v3/teamdrives/update

teamDriveId <string> The ID of the Team Drive
TeamDrive:
{:capabilities
 {:canChangeDomainUsersOnlyRestriction boolean,
  :canCopy boolean,
  :canManageMembers boolean,
  :canTrashChildren boolean,
  :canChangeTeamDriveBackground boolean,
  :canDownload boolean,
  :canDeleteTeamDrive boolean,
  :canDeleteChildren boolean,
  :canListChildren boolean,
  :canRename boolean,
  :canRenameTeamDrive boolean,
  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction
  boolean,
  :canResetTeamDriveRestrictions boolean,
  :canReadRevisions boolean,
  :canChangeCopyRequiresWriterPermissionRestriction boolean,
  :canEdit boolean,
  :canComment boolean,
  :canChangeTeamMembersOnlyRestriction boolean,
  :canRemoveChildren boolean,
  :canAddChildren boolean,
  :canShare boolean},
 :restrictions
 {:copyRequiresWriterPermission boolean,
  :domainUsersOnly boolean,
  :teamMembersOnly boolean,
  :adminManagedRestrictions boolean,
  :sharingFoldersRequiresOrganizerPermission boolean},
 :themeId string,
 :backgroundImageFile
 {:id string, :xCoordinate number, :yCoordinate number, :width number},
 :name string,
 :orgUnitId string,
 :createdTime string,
 :id string,
 :kind string,
 :colorRgb string,
 :backgroundImageLink string}

optional:
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if they are an administrator of the domain to which the Team Drive belongs."
  ([teamDriveId TeamDrive]
    (teamdrives-update teamDriveId TeamDrive nil))
  ([teamDriveId TeamDrive optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/drive/v3/teamdrives/{teamDriveId}",
       :uri-template-args {:teamDriveId teamDriveId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/drive"],
       :body TeamDrive})))

(defn channels-stop
  "Stops watching resources through this channel.
https://developers.google.com/drive/api/reference/rest/v3/channels/stop

Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}"
  [Channel]
  (client/api-request
    {:method "POST",
     :uri-template "https://www.googleapis.com/drive/v3/channels/stop",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.appdata"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.meet.readonly"
      "https://www.googleapis.com/auth/drive.metadata"
      "https://www.googleapis.com/auth/drive.metadata.readonly"
      "https://www.googleapis.com/auth/drive.photos.readonly"
      "https://www.googleapis.com/auth/drive.readonly"],
     :body Channel}))

(defn comments-create
  "Creates a comment on a file.
https://developers.google.com/drive/api/reference/rest/v3/comments/create

fileId <string> The ID of the file.
Comment:
{:htmlContent string,
 :deleted boolean,
 :modifiedTime string,
 :content string,
 :resolved boolean,
 :author
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :replies
 [{:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :author
   {:displayName string,
    :kind string,
    :me boolean,
    :permissionId string,
    :emailAddress string,
    :photoLink string},
   :createdTime string,
   :id string,
   :kind string,
   :action string}],
 :createdTime string,
 :quotedFileContent {:mimeType string, :value string},
 :id string,
 :kind string,
 :anchor string}"
  [fileId Comment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/comments",
     :uri-template-args {:fileId fileId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"],
     :body Comment}))

(defn comments-delete
  "Deletes a comment.
https://developers.google.com/drive/api/reference/rest/v3/comments/delete

fileId <string> The ID of the file.
commentId <string> The ID of the comment."
  [fileId commentId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}",
     :uri-template-args {:fileId fileId, :commentId commentId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"]}))

(defn comments-get
  "Gets a comment by ID.
https://developers.google.com/drive/api/reference/rest/v3/comments/get

fileId <string> The ID of the file.
commentId <string> The ID of the comment.

optional:
includeDeleted <boolean> Whether to return deleted comments. Deleted comments will not include their original content."
  ([fileId commentId] (comments-get fileId commentId nil))
  ([fileId commentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}",
       :uri-template-args {:fileId fileId, :commentId commentId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn comments-list
  "Lists a file's comments.
https://developers.google.com/drive/api/reference/rest/v3/comments/list

fileId <string> The ID of the file.

optional:
includeDeleted <boolean> Whether to include deleted comments. Deleted comments will not include their original content.
pageSize <integer> The maximum number of comments to return per page.
startModifiedTime <string> The minimum value of 'modifiedTime' for the result comments (RFC 3339 date-time)."
  ([fileId] (comments-list fileId nil))
  ([fileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/comments",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn comments-update
  "Updates a comment with patch semantics.
https://developers.google.com/drive/api/reference/rest/v3/comments/update

fileId <string> The ID of the file.
commentId <string> The ID of the comment.
Comment:
{:htmlContent string,
 :deleted boolean,
 :modifiedTime string,
 :content string,
 :resolved boolean,
 :author
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :replies
 [{:htmlContent string,
   :deleted boolean,
   :modifiedTime string,
   :content string,
   :author
   {:displayName string,
    :kind string,
    :me boolean,
    :permissionId string,
    :emailAddress string,
    :photoLink string},
   :createdTime string,
   :id string,
   :kind string,
   :action string}],
 :createdTime string,
 :quotedFileContent {:mimeType string, :value string},
 :id string,
 :kind string,
 :anchor string}"
  [fileId commentId Comment]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}",
     :uri-template-args {:fileId fileId, :commentId commentId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"],
     :body Comment}))

(defn drives-create
  "Creates a shared drive.
https://developers.google.com/drive/api/reference/rest/v3/drives/create

requestId <string> Required. An ID, such as a random UUID, which uniquely identifies this user's request for idempotent creation of a shared drive. A repeated request by the same user and with the same request ID will avoid creating duplicates by attempting to create the same shared drive. If the shared drive already exists a 409 error will be returned.
Drive:
{:capabilities
 {:canChangeDomainUsersOnlyRestriction boolean,
  :canRenameDrive boolean,
  :canCopy boolean,
  :canManageMembers boolean,
  :canTrashChildren boolean,
  :canDownload boolean,
  :canChangeDriveMembersOnlyRestriction boolean,
  :canDeleteChildren boolean,
  :canListChildren boolean,
  :canRename boolean,
  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction
  boolean,
  :canReadRevisions boolean,
  :canDeleteDrive boolean,
  :canChangeCopyRequiresWriterPermissionRestriction boolean,
  :canEdit boolean,
  :canComment boolean,
  :canAddChildren boolean,
  :canChangeDriveBackground boolean,
  :canResetDriveRestrictions boolean,
  :canShare boolean},
 :restrictions
 {:copyRequiresWriterPermission boolean,
  :domainUsersOnly boolean,
  :driveMembersOnly boolean,
  :adminManagedRestrictions boolean,
  :sharingFoldersRequiresOrganizerPermission boolean},
 :themeId string,
 :backgroundImageFile
 {:id string, :xCoordinate number, :yCoordinate number, :width number},
 :name string,
 :orgUnitId string,
 :createdTime string,
 :hidden boolean,
 :id string,
 :kind string,
 :colorRgb string,
 :backgroundImageLink string}"
  [requestId Drive]
  (client/api-request
    {:method "POST",
     :uri-template "https://www.googleapis.com/drive/v3/drives",
     :uri-template-args {},
     :query-params {:requestId requestId},
     :scopes ["https://www.googleapis.com/auth/drive"],
     :body Drive}))

(defn drives-delete
  "Permanently deletes a shared drive for which the user is an `organizer`. The shared drive cannot contain any untrashed items.
https://developers.google.com/drive/api/reference/rest/v3/drives/delete

driveId <string> The ID of the shared drive.

optional:
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if they are an administrator of the domain to which the shared drive belongs.
allowItemDeletion <boolean> Whether any items inside the shared drive should also be deleted. This option is only supported when `useDomainAdminAccess` is also set to `true`."
  ([driveId] (drives-delete driveId nil))
  ([driveId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://www.googleapis.com/drive/v3/drives/{driveId}",
       :uri-template-args {:driveId driveId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/drive"]})))

(defn drives-get
  "Gets a shared drive's metadata by ID.
https://developers.google.com/drive/api/reference/rest/v3/drives/get

driveId <string> The ID of the shared drive.

optional:
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if they are an administrator of the domain to which the shared drive belongs."
  ([driveId] (drives-get driveId nil))
  ([driveId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/drives/{driveId}",
       :uri-template-args {:driveId driveId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn drives-hide
  "Hides a shared drive from the default view.
https://developers.google.com/drive/api/reference/rest/v3/drives/hide

driveId <string> The ID of the shared drive."
  [driveId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/drive/v3/drives/{driveId}/hide",
     :uri-template-args {:driveId driveId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/drive"]}))

(defn drives-list
  " Lists the user's shared drives. This method accepts the `q` parameter, which is a search query combining one or more search terms. For more information, see the [Search for shared drives](/drive/api/guides/search-shareddrives) guide.
https://developers.google.com/drive/api/reference/rest/v3/drives/list

optional:
pageSize <integer> Maximum number of shared drives to return per page.
q <string> Query string for searching shared drives.
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then all shared drives of the domain in which the requester is an administrator are returned."
  ([] (drives-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://www.googleapis.com/drive/v3/drives",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn drives-unhide
  "Restores a shared drive to the default view.
https://developers.google.com/drive/api/reference/rest/v3/drives/unhide

driveId <string> The ID of the shared drive."
  [driveId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/drive/v3/drives/{driveId}/unhide",
     :uri-template-args {:driveId driveId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/drive"]}))

(defn drives-update
  "Updates the metadata for a shared drive.
https://developers.google.com/drive/api/reference/rest/v3/drives/update

driveId <string> The ID of the shared drive.
Drive:
{:capabilities
 {:canChangeDomainUsersOnlyRestriction boolean,
  :canRenameDrive boolean,
  :canCopy boolean,
  :canManageMembers boolean,
  :canTrashChildren boolean,
  :canDownload boolean,
  :canChangeDriveMembersOnlyRestriction boolean,
  :canDeleteChildren boolean,
  :canListChildren boolean,
  :canRename boolean,
  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction
  boolean,
  :canReadRevisions boolean,
  :canDeleteDrive boolean,
  :canChangeCopyRequiresWriterPermissionRestriction boolean,
  :canEdit boolean,
  :canComment boolean,
  :canAddChildren boolean,
  :canChangeDriveBackground boolean,
  :canResetDriveRestrictions boolean,
  :canShare boolean},
 :restrictions
 {:copyRequiresWriterPermission boolean,
  :domainUsersOnly boolean,
  :driveMembersOnly boolean,
  :adminManagedRestrictions boolean,
  :sharingFoldersRequiresOrganizerPermission boolean},
 :themeId string,
 :backgroundImageFile
 {:id string, :xCoordinate number, :yCoordinate number, :width number},
 :name string,
 :orgUnitId string,
 :createdTime string,
 :hidden boolean,
 :id string,
 :kind string,
 :colorRgb string,
 :backgroundImageLink string}

optional:
useDomainAdminAccess <boolean> Issue the request as a domain administrator; if set to true, then the requester will be granted access if they are an administrator of the domain to which the shared drive belongs."
  ([driveId Drive] (drives-update driveId Drive nil))
  ([driveId Drive optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/drive/v3/drives/{driveId}",
       :uri-template-args {:driveId driveId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/drive"],
       :body Drive})))

(defn replies-create
  "Creates a reply to a comment.
https://developers.google.com/drive/api/reference/rest/v3/replies/create

fileId <string> The ID of the file.
commentId <string> The ID of the comment.
Reply:
{:htmlContent string,
 :deleted boolean,
 :modifiedTime string,
 :content string,
 :author
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :createdTime string,
 :id string,
 :kind string,
 :action string}"
  [fileId commentId Reply]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}/replies",
     :uri-template-args {:fileId fileId, :commentId commentId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"],
     :body Reply}))

(defn replies-delete
  "Deletes a reply.
https://developers.google.com/drive/api/reference/rest/v3/replies/delete

fileId <string> The ID of the file.
commentId <string> The ID of the comment.
replyId <string> The ID of the reply."
  [fileId commentId replyId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}/replies/{replyId}",
     :uri-template-args
     {:fileId fileId, :commentId commentId, :replyId replyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"]}))

(defn replies-get
  "Gets a reply by ID.
https://developers.google.com/drive/api/reference/rest/v3/replies/get

fileId <string> The ID of the file.
commentId <string> The ID of the comment.
replyId <string> The ID of the reply.

optional:
includeDeleted <boolean> Whether to return deleted replies. Deleted replies will not include their original content."
  ([fileId commentId replyId]
    (replies-get fileId commentId replyId nil))
  ([fileId commentId replyId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}/replies/{replyId}",
       :uri-template-args
       {:fileId fileId, :commentId commentId, :replyId replyId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn replies-list
  "Lists a comment's replies.
https://developers.google.com/drive/api/reference/rest/v3/replies/list

fileId <string> The ID of the file.
commentId <string> The ID of the comment.

optional:
includeDeleted <boolean> Whether to include deleted replies. Deleted replies will not include their original content.
pageSize <integer> The maximum number of replies to return per page."
  ([fileId commentId] (replies-list fileId commentId nil))
  ([fileId commentId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}/replies",
       :uri-template-args {:fileId fileId, :commentId commentId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn replies-update
  "Updates a reply with patch semantics.
https://developers.google.com/drive/api/reference/rest/v3/replies/update

fileId <string> The ID of the file.
commentId <string> The ID of the comment.
replyId <string> The ID of the reply.
Reply:
{:htmlContent string,
 :deleted boolean,
 :modifiedTime string,
 :content string,
 :author
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :createdTime string,
 :id string,
 :kind string,
 :action string}"
  [fileId commentId replyId Reply]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/comments/{commentId}/replies/{replyId}",
     :uri-template-args
     {:fileId fileId, :commentId commentId, :replyId replyId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"],
     :body Reply}))

(defn files-emptyTrash
  "Permanently deletes all of the user's trashed files.
https://developers.google.com/drive/api/reference/rest/v3/files/emptyTrash

optional:
enforceSingleParent <boolean> Deprecated: If an item is not in a shared drive and its last parent is deleted but the item itself is not, the item will be placed under its owner's root.
driveId <string> If set, empties the trash of the provided shared drive."
  ([] (files-emptyTrash nil))
  ([optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://www.googleapis.com/drive/v3/files/trash",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/drive"]})))

(defn files-get
  " Gets a file's metadata or content by ID. If you provide the URL parameter `alt=media`, then the response includes the file contents in the response body. Downloading content with `alt=media` only works if the file is stored in Drive. To download Google Docs, Sheets, and Slides use [`files.export`](/drive/api/reference/rest/v3/files/export) instead. For more information, see [Download & export files](/drive/api/guides/manage-downloads).
https://developers.google.com/drive/api/reference/rest/v3/files/get

fileId <string> The ID of the file.

optional:
acknowledgeAbuse <boolean> Whether the user is acknowledging the risk of downloading known malware or other abusive files. This is only applicable when alt=media.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response."
  ([fileId] (files-get fileId nil))
  ([fileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn files-copy
  "Creates a copy of a file and applies any requested updates with patch semantics.
https://developers.google.com/drive/api/reference/rest/v3/files/copy

fileId <string> The ID of the file.
File:
{:description string,
 :properties object,
 :isAppAuthorized boolean,
 :capabilities
 {:canDelete boolean,
  :canAddMyDriveParent boolean,
  :canTrash boolean,
  :canMoveChildrenOutOfTeamDrive boolean,
  :canCopy boolean,
  :canAddFolderFromAnotherDrive boolean,
  :canTrashChildren boolean,
  :canMoveChildrenWithinDrive boolean,
  :canDownload boolean,
  :canReadTeamDrive boolean,
  :canUntrash boolean,
  :canModifyEditorContentRestriction boolean,
  :canModifyLabels boolean,
  :canMoveChildrenOutOfDrive boolean,
  :canDeleteChildren boolean,
  :canListChildren boolean,
  :canAcceptOwnership boolean,
  :canRename boolean,
  :canRemoveContentRestriction boolean,
  :canChangeCopyRequiresWriterPermission boolean,
  :canModifyOwnerContentRestriction boolean,
  :canReadRevisions boolean,
  :canMoveItemIntoTeamDrive boolean,
  :canRemoveMyDriveParent boolean,
  :canModifyContentRestriction boolean,
  :canMoveItemOutOfDrive boolean,
  :canEdit boolean,
  :canComment boolean,
  :canRemoveChildren boolean,
  :canReadLabels boolean,
  :canAddChildren boolean,
  :canMoveItemWithinTeamDrive boolean,
  :canModifyContent boolean,
  :canShare boolean,
  :canMoveItemOutOfTeamDrive boolean,
  :canMoveChildrenWithinTeamDrive boolean,
  :canChangeViewersCanCopyContent boolean,
  :canChangeSecurityUpdateEnabled boolean,
  :canMoveTeamDriveItem boolean,
  :canReadDrive boolean,
  :canMoveItemWithinDrive boolean},
 :copyRequiresWriterPermission boolean,
 :imageMediaMetadata
 {:focalLength number,
  :aperture number,
  :rotation integer,
  :exposureBias number,
  :flashUsed boolean,
  :time string,
  :maxApertureValue number,
  :colorSpace string,
  :width integer,
  :lens string,
  :exposureMode string,
  :cameraModel string,
  :cameraMake string,
  :whiteBalance string,
  :exposureTime number,
  :subjectDistance integer,
  :meteringMode string,
  :isoSpeed integer,
  :location {:latitude number, :longitude number, :altitude number},
  :height integer,
  :sensor string},
 :sha256Checksum string,
 :modifiedTime string,
 :permissions
 [{:role string,
   :deleted boolean,
   :allowFileDiscovery boolean,
   :expirationTime string,
   :displayName string,
   :emailAddress string,
   :type string,
   :permissionDetails
   [{:permissionType string,
     :inheritedFrom string,
     :role string,
     :inherited boolean}],
   :teamDrivePermissionDetails
   [{:teamDrivePermissionType string,
     :inheritedFrom string,
     :role string,
     :inherited boolean}],
   :id string,
   :kind string,
   :pendingOwner boolean,
   :domain string,
   :view string,
   :photoLink string}],
 :owners
 [{:displayName string,
   :kind string,
   :me boolean,
   :permissionId string,
   :emailAddress string,
   :photoLink string}],
 :permissionIds [string],
 :headRevisionId string,
 :modifiedByMeTime string,
 :starred boolean,
 :fullFileExtension string,
 :exportLinks object,
 :contentRestrictions
 [{:readOnly boolean,
   :reason string,
   :type string,
   :restrictingUser
   {:displayName string,
    :kind string,
    :me boolean,
    :permissionId string,
    :emailAddress string,
    :photoLink string},
   :restrictionTime string,
   :ownerRestricted boolean,
   :systemRestricted boolean}],
 :name string,
 :viewersCanCopyContent boolean,
 :iconLink string,
 :teamDriveId string,
 :size string,
 :hasThumbnail boolean,
 :lastModifyingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :resourceKey string,
 :modifiedByMe boolean,
 :thumbnailVersion string,
 :folderColorRgb string,
 :createdTime string,
 :spaces [string],
 :fileExtension string,
 :trashed boolean,
 :id string,
 :thumbnailLink string,
 :writersCanShare boolean,
 :explicitlyTrashed boolean,
 :kind string,
 :parents [string],
 :driveId string,
 :sharedWithMeTime string,
 :viewedByMeTime string,
 :mimeType string,
 :trashingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :shared boolean,
 :labelInfo
 {:labels
  [{:id string, :revisionId string, :kind string, :fields object}]},
 :shortcutDetails
 {:targetId string, :targetMimeType string, :targetResourceKey string},
 :sharingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :md5Checksum string,
 :hasAugmentedPermissions boolean,
 :quotaBytesUsed string,
 :version string,
 :originalFilename string,
 :trashedTime string,
 :webViewLink string,
 :videoMediaMetadata
 {:width integer, :height integer, :durationMillis string},
 :viewedByMe boolean,
 :linkShareMetadata
 {:securityUpdateEligible boolean, :securityUpdateEnabled boolean},
 :sha1Checksum string,
 :contentHints
 {:indexableText string, :thumbnail {:image string, :mimeType string}},
 :appProperties object,
 :ownedByMe boolean,
 :webContentLink string}

optional:
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response.
enforceSingleParent <boolean> Deprecated. Copying files into multiple folders is no longer supported. Use shortcuts instead.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
ocrLanguage <string> A language hint for OCR processing during image import (ISO 639-1 code).
ignoreDefaultVisibility <boolean> Whether to ignore the domain's default visibility settings for the created file. Domain administrators can choose to make all uploaded files visible to the domain by default; this parameter bypasses that behavior for the request. Permissions are still inherited from parent folders.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
keepRevisionForever <boolean> Whether to set the 'keepForever' field in the new head revision. This is only applicable to files with binary content in Google Drive. Only 200 revisions for the file can be kept forever. If the limit is reached, try deleting pinned revisions."
  ([fileId File] (files-copy fileId File nil))
  ([fileId File optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/copy",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.photos.readonly"],
       :body File})))

(defn files-modifyLabels
  "Modifies the set of labels applied to a file. Returns a list of the labels that were added or modified.
https://developers.google.com/drive/api/reference/rest/v3/files/modifyLabels

fileId <string> The ID of the file to which the labels belong.
ModifyLabelsRequest:
{:labelModifications
 [{:labelId string,
   :fieldModifications
   [{:fieldId string,
     :kind string,
     :setDateValues [string],
     :setTextValues [string],
     :setSelectionValues [string],
     :setIntegerValues [string],
     :setUserValues [string],
     :unsetValues boolean}],
   :removeLabel boolean,
   :kind string}],
 :kind string}"
  [fileId ModifyLabelsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/modifyLabels",
     :uri-template-args {:fileId fileId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.metadata"],
     :body ModifyLabelsRequest}))

(defn files-create
  " Creates a new file. This method supports an */upload* URI and accepts uploaded media with the following characteristics: - *Maximum file size:* 5,120 GB - *Accepted Media MIME types:*`*/*` Note: Specify a valid MIME type, rather than the literal `*/*` value. The literal `*/*` is only used to indicate that any valid MIME type can be uploaded. For more information on uploading files, see [Upload file data](/drive/api/guides/manage-uploads). Apps creating shortcuts with `files.create` must specify the MIME type `application/vnd.google-apps.shortcut`. Apps should specify a file extension in the `name` property when inserting files with the API. For example, an operation to insert a JPEG file should specify something like `\"name\": \"cat.jpg\"` in the metadata. Subsequent `GET` requests include the read-only `fileExtension` property populated with the extension originally specified in the `title` property. When a Google Drive user requests to download a file, or when the file is downloaded through the sync client, Drive builds a full filename (with extension) based on the title. In cases where the extension is missing, Drive attempts to determine the extension based on the file's MIME type.
https://developers.google.com/drive/api/reference/rest/v3/files/create

File:
{:description string,
 :properties object,
 :isAppAuthorized boolean,
 :capabilities
 {:canDelete boolean,
  :canAddMyDriveParent boolean,
  :canTrash boolean,
  :canMoveChildrenOutOfTeamDrive boolean,
  :canCopy boolean,
  :canAddFolderFromAnotherDrive boolean,
  :canTrashChildren boolean,
  :canMoveChildrenWithinDrive boolean,
  :canDownload boolean,
  :canReadTeamDrive boolean,
  :canUntrash boolean,
  :canModifyEditorContentRestriction boolean,
  :canModifyLabels boolean,
  :canMoveChildrenOutOfDrive boolean,
  :canDeleteChildren boolean,
  :canListChildren boolean,
  :canAcceptOwnership boolean,
  :canRename boolean,
  :canRemoveContentRestriction boolean,
  :canChangeCopyRequiresWriterPermission boolean,
  :canModifyOwnerContentRestriction boolean,
  :canReadRevisions boolean,
  :canMoveItemIntoTeamDrive boolean,
  :canRemoveMyDriveParent boolean,
  :canModifyContentRestriction boolean,
  :canMoveItemOutOfDrive boolean,
  :canEdit boolean,
  :canComment boolean,
  :canRemoveChildren boolean,
  :canReadLabels boolean,
  :canAddChildren boolean,
  :canMoveItemWithinTeamDrive boolean,
  :canModifyContent boolean,
  :canShare boolean,
  :canMoveItemOutOfTeamDrive boolean,
  :canMoveChildrenWithinTeamDrive boolean,
  :canChangeViewersCanCopyContent boolean,
  :canChangeSecurityUpdateEnabled boolean,
  :canMoveTeamDriveItem boolean,
  :canReadDrive boolean,
  :canMoveItemWithinDrive boolean},
 :copyRequiresWriterPermission boolean,
 :imageMediaMetadata
 {:focalLength number,
  :aperture number,
  :rotation integer,
  :exposureBias number,
  :flashUsed boolean,
  :time string,
  :maxApertureValue number,
  :colorSpace string,
  :width integer,
  :lens string,
  :exposureMode string,
  :cameraModel string,
  :cameraMake string,
  :whiteBalance string,
  :exposureTime number,
  :subjectDistance integer,
  :meteringMode string,
  :isoSpeed integer,
  :location {:latitude number, :longitude number, :altitude number},
  :height integer,
  :sensor string},
 :sha256Checksum string,
 :modifiedTime string,
 :permissions
 [{:role string,
   :deleted boolean,
   :allowFileDiscovery boolean,
   :expirationTime string,
   :displayName string,
   :emailAddress string,
   :type string,
   :permissionDetails
   [{:permissionType string,
     :inheritedFrom string,
     :role string,
     :inherited boolean}],
   :teamDrivePermissionDetails
   [{:teamDrivePermissionType string,
     :inheritedFrom string,
     :role string,
     :inherited boolean}],
   :id string,
   :kind string,
   :pendingOwner boolean,
   :domain string,
   :view string,
   :photoLink string}],
 :owners
 [{:displayName string,
   :kind string,
   :me boolean,
   :permissionId string,
   :emailAddress string,
   :photoLink string}],
 :permissionIds [string],
 :headRevisionId string,
 :modifiedByMeTime string,
 :starred boolean,
 :fullFileExtension string,
 :exportLinks object,
 :contentRestrictions
 [{:readOnly boolean,
   :reason string,
   :type string,
   :restrictingUser
   {:displayName string,
    :kind string,
    :me boolean,
    :permissionId string,
    :emailAddress string,
    :photoLink string},
   :restrictionTime string,
   :ownerRestricted boolean,
   :systemRestricted boolean}],
 :name string,
 :viewersCanCopyContent boolean,
 :iconLink string,
 :teamDriveId string,
 :size string,
 :hasThumbnail boolean,
 :lastModifyingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :resourceKey string,
 :modifiedByMe boolean,
 :thumbnailVersion string,
 :folderColorRgb string,
 :createdTime string,
 :spaces [string],
 :fileExtension string,
 :trashed boolean,
 :id string,
 :thumbnailLink string,
 :writersCanShare boolean,
 :explicitlyTrashed boolean,
 :kind string,
 :parents [string],
 :driveId string,
 :sharedWithMeTime string,
 :viewedByMeTime string,
 :mimeType string,
 :trashingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :shared boolean,
 :labelInfo
 {:labels
  [{:id string, :revisionId string, :kind string, :fields object}]},
 :shortcutDetails
 {:targetId string, :targetMimeType string, :targetResourceKey string},
 :sharingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :md5Checksum string,
 :hasAugmentedPermissions boolean,
 :quotaBytesUsed string,
 :version string,
 :originalFilename string,
 :trashedTime string,
 :webViewLink string,
 :videoMediaMetadata
 {:width integer, :height integer, :durationMillis string},
 :viewedByMe boolean,
 :linkShareMetadata
 {:securityUpdateEligible boolean, :securityUpdateEnabled boolean},
 :sha1Checksum string,
 :contentHints
 {:indexableText string, :thumbnail {:image string, :mimeType string}},
 :appProperties object,
 :ownedByMe boolean,
 :webContentLink string}

optional:
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response.
enforceSingleParent <boolean> Deprecated. Creating files in multiple folders is no longer supported.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
useContentAsIndexableText <boolean> Whether to use the uploaded content as indexable text.
ocrLanguage <string> A language hint for OCR processing during image import (ISO 639-1 code).
ignoreDefaultVisibility <boolean> Whether to ignore the domain's default visibility settings for the created file. Domain administrators can choose to make all uploaded files visible to the domain by default; this parameter bypasses that behavior for the request. Permissions are still inherited from parent folders.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
keepRevisionForever <boolean> Whether to set the 'keepForever' field in the new head revision. This is only applicable to files with binary content in Google Drive. Only 200 revisions for the file can be kept forever. If the limit is reached, try deleting pinned revisions."
  ([File] (files-create File nil))
  ([File optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://www.googleapis.com/drive/v3/files",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"],
       :body File})))

(defn files-update
  " Updates a file's metadata and/or content. When calling this method, only populate fields in the request that you want to modify. When updating fields, some fields might be changed automatically, such as `modifiedDate`. This method supports patch semantics. This method supports an */upload* URI and accepts uploaded media with the following characteristics: - *Maximum file size:* 5,120 GB - *Accepted Media MIME types:*`*/*` Note: Specify a valid MIME type, rather than the literal `*/*` value. The literal `*/*` is only used to indicate that any valid MIME type can be uploaded. For more information on uploading files, see [Upload file data](/drive/api/guides/manage-uploads).
https://developers.google.com/drive/api/reference/rest/v3/files/update

fileId <string> The ID of the file.
File:
{:description string,
 :properties object,
 :isAppAuthorized boolean,
 :capabilities
 {:canDelete boolean,
  :canAddMyDriveParent boolean,
  :canTrash boolean,
  :canMoveChildrenOutOfTeamDrive boolean,
  :canCopy boolean,
  :canAddFolderFromAnotherDrive boolean,
  :canTrashChildren boolean,
  :canMoveChildrenWithinDrive boolean,
  :canDownload boolean,
  :canReadTeamDrive boolean,
  :canUntrash boolean,
  :canModifyEditorContentRestriction boolean,
  :canModifyLabels boolean,
  :canMoveChildrenOutOfDrive boolean,
  :canDeleteChildren boolean,
  :canListChildren boolean,
  :canAcceptOwnership boolean,
  :canRename boolean,
  :canRemoveContentRestriction boolean,
  :canChangeCopyRequiresWriterPermission boolean,
  :canModifyOwnerContentRestriction boolean,
  :canReadRevisions boolean,
  :canMoveItemIntoTeamDrive boolean,
  :canRemoveMyDriveParent boolean,
  :canModifyContentRestriction boolean,
  :canMoveItemOutOfDrive boolean,
  :canEdit boolean,
  :canComment boolean,
  :canRemoveChildren boolean,
  :canReadLabels boolean,
  :canAddChildren boolean,
  :canMoveItemWithinTeamDrive boolean,
  :canModifyContent boolean,
  :canShare boolean,
  :canMoveItemOutOfTeamDrive boolean,
  :canMoveChildrenWithinTeamDrive boolean,
  :canChangeViewersCanCopyContent boolean,
  :canChangeSecurityUpdateEnabled boolean,
  :canMoveTeamDriveItem boolean,
  :canReadDrive boolean,
  :canMoveItemWithinDrive boolean},
 :copyRequiresWriterPermission boolean,
 :imageMediaMetadata
 {:focalLength number,
  :aperture number,
  :rotation integer,
  :exposureBias number,
  :flashUsed boolean,
  :time string,
  :maxApertureValue number,
  :colorSpace string,
  :width integer,
  :lens string,
  :exposureMode string,
  :cameraModel string,
  :cameraMake string,
  :whiteBalance string,
  :exposureTime number,
  :subjectDistance integer,
  :meteringMode string,
  :isoSpeed integer,
  :location {:latitude number, :longitude number, :altitude number},
  :height integer,
  :sensor string},
 :sha256Checksum string,
 :modifiedTime string,
 :permissions
 [{:role string,
   :deleted boolean,
   :allowFileDiscovery boolean,
   :expirationTime string,
   :displayName string,
   :emailAddress string,
   :type string,
   :permissionDetails
   [{:permissionType string,
     :inheritedFrom string,
     :role string,
     :inherited boolean}],
   :teamDrivePermissionDetails
   [{:teamDrivePermissionType string,
     :inheritedFrom string,
     :role string,
     :inherited boolean}],
   :id string,
   :kind string,
   :pendingOwner boolean,
   :domain string,
   :view string,
   :photoLink string}],
 :owners
 [{:displayName string,
   :kind string,
   :me boolean,
   :permissionId string,
   :emailAddress string,
   :photoLink string}],
 :permissionIds [string],
 :headRevisionId string,
 :modifiedByMeTime string,
 :starred boolean,
 :fullFileExtension string,
 :exportLinks object,
 :contentRestrictions
 [{:readOnly boolean,
   :reason string,
   :type string,
   :restrictingUser
   {:displayName string,
    :kind string,
    :me boolean,
    :permissionId string,
    :emailAddress string,
    :photoLink string},
   :restrictionTime string,
   :ownerRestricted boolean,
   :systemRestricted boolean}],
 :name string,
 :viewersCanCopyContent boolean,
 :iconLink string,
 :teamDriveId string,
 :size string,
 :hasThumbnail boolean,
 :lastModifyingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :resourceKey string,
 :modifiedByMe boolean,
 :thumbnailVersion string,
 :folderColorRgb string,
 :createdTime string,
 :spaces [string],
 :fileExtension string,
 :trashed boolean,
 :id string,
 :thumbnailLink string,
 :writersCanShare boolean,
 :explicitlyTrashed boolean,
 :kind string,
 :parents [string],
 :driveId string,
 :sharedWithMeTime string,
 :viewedByMeTime string,
 :mimeType string,
 :trashingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :shared boolean,
 :labelInfo
 {:labels
  [{:id string, :revisionId string, :kind string, :fields object}]},
 :shortcutDetails
 {:targetId string, :targetMimeType string, :targetResourceKey string},
 :sharingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :md5Checksum string,
 :hasAugmentedPermissions boolean,
 :quotaBytesUsed string,
 :version string,
 :originalFilename string,
 :trashedTime string,
 :webViewLink string,
 :videoMediaMetadata
 {:width integer, :height integer, :durationMillis string},
 :viewedByMe boolean,
 :linkShareMetadata
 {:securityUpdateEligible boolean, :securityUpdateEnabled boolean},
 :sha1Checksum string,
 :contentHints
 {:indexableText string, :thumbnail {:image string, :mimeType string}},
 :appProperties object,
 :ownedByMe boolean,
 :webContentLink string}

optional:
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response.
removeParents <string> A comma-separated list of parent IDs to remove.
addParents <string> A comma-separated list of parent IDs to add.
enforceSingleParent <boolean> Deprecated: Adding files to multiple folders is no longer supported. Use shortcuts instead.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
useContentAsIndexableText <boolean> Whether to use the uploaded content as indexable text.
ocrLanguage <string> A language hint for OCR processing during image import (ISO 639-1 code).
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
keepRevisionForever <boolean> Whether to set the 'keepForever' field in the new head revision. This is only applicable to files with binary content in Google Drive. Only 200 revisions for the file can be kept forever. If the limit is reached, try deleting pinned revisions."
  ([fileId File] (files-update fileId File nil))
  ([fileId File optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.scripts"],
       :body File})))

(defn files-delete
  "Permanently deletes a file owned by the user without moving it to the trash. If the file belongs to a shared drive, the user must be an `organizer` on the parent folder. If the target is a folder, all descendants owned by the user are also deleted.
https://developers.google.com/drive/api/reference/rest/v3/files/delete

fileId <string> The ID of the file.

optional:
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
enforceSingleParent <boolean> Deprecated: If an item is not in a shared drive and its last parent is deleted but the item itself is not, the item will be placed under its owner's root."
  ([fileId] (files-delete fileId nil))
  ([fileId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"]})))

(defn files-export
  "Exports a Google Workspace document to the requested MIME type and returns exported byte content. Note that the exported content is limited to 10MB.
https://developers.google.com/drive/api/reference/rest/v3/files/export

fileId <string> The ID of the file.
mimeType <string> Required. The MIME type of the format requested for this export."
  [fileId mimeType]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/export",
     :uri-template-args {:fileId fileId},
     :query-params {:mimeType mimeType},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.meet.readonly"
      "https://www.googleapis.com/auth/drive.readonly"]}))

(defn files-list
  " Lists the user's files. This method accepts the `q` parameter, which is a search query combining one or more search terms. For more information, see the [Search for files & folders](/drive/api/guides/search-files) guide. *Note:* This method returns *all* files by default, including trashed files. If you don't want trashed files to appear in the list, use the `trashed=false` query parameter to remove trashed files from the results.
https://developers.google.com/drive/api/reference/rest/v3/files/list

optional:
q <string> A query for filtering the file results. See the \"Search for files & folders\" guide for supported syntax.
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response.
includeItemsFromAllDrives <boolean> Whether both My Drive and shared drive items should be included in results.
corpora <string> Bodies of items (files/documents) to which the query applies. Supported bodies are 'user', 'domain', 'drive', and 'allDrives'. Prefer 'user' or 'drive' to 'allDrives' for efficiency. By default, corpora is set to 'user'. However, this can change depending on the filter set through the 'q' parameter.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
corpus <string> Deprecated: The source of files to list. Use 'corpora' instead.
teamDriveId <string> Deprecated: Use `driveId` instead.
pageSize <integer> The maximum number of files to return per page. Partial or empty result pages are possible even before the end of the files list has been reached.
spaces <string> A comma-separated list of spaces to query within the corpora. Supported values are 'drive' and 'appDataFolder'.
includeTeamDriveItems <boolean> Deprecated: Use `includeItemsFromAllDrives` instead.
driveId <string> ID of the shared drive to search.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
orderBy <string> A comma-separated list of sort keys. Valid keys are 'createdTime', 'folder', 'modifiedByMeTime', 'modifiedTime', 'name', 'name_natural', 'quotaBytesUsed', 'recency', 'sharedWithMeTime', 'starred', and 'viewedByMeTime'. Each key sorts ascending by default, but can be reversed with the 'desc' modifier. Example usage: ?orderBy=folder,modifiedTime desc,name."
  ([] (files-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://www.googleapis.com/drive/v3/files",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn files-watch
  "Subscribes to changes to a file.
https://developers.google.com/drive/api/reference/rest/v3/files/watch

fileId <string> The ID of the file.
Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}

optional:
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
acknowledgeAbuse <boolean> Whether the user is acknowledging the risk of downloading known malware or other abusive files. This is only applicable when alt=media.
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response."
  ([fileId Channel] (files-watch fileId Channel nil))
  ([fileId Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/watch",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"],
       :body Channel})))

(defn files-listLabels
  "Lists the labels on a file.
https://developers.google.com/drive/api/reference/rest/v3/files/listLabels

fileId <string> The ID for the file.

optional:
maxResults <integer> The maximum number of labels to return per page. When not set, defaults to 100."
  ([fileId] (files-listLabels fileId nil))
  ([fileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/listLabels",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn files-generateIds
  "Generates a set of file IDs which can be provided in create or copy requests.
https://developers.google.com/drive/api/reference/rest/v3/files/generateIds

optional:
count <integer> The number of IDs to return.
space <string> The space in which the IDs can be used to create new files. Supported values are 'drive' and 'appDataFolder'. (Default: 'drive')
type <string> The type of items which the IDs can be used for. Supported values are 'files' and 'shortcuts'. Note that 'shortcuts' are only supported in the `drive` 'space'. (Default: 'files')"
  ([] (files-generateIds nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/generateIds",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"]})))

(defn revisions-delete
  "Permanently deletes a file version. You can only delete revisions for files with binary content in Google Drive, like images or videos. Revisions for other files, like Google Docs or Sheets, and the last remaining file version can't be deleted.
https://developers.google.com/drive/api/reference/rest/v3/revisions/delete

fileId <string> The ID of the file.
revisionId <string> The ID of the revision."
  [fileId revisionId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/revisions/{revisionId}",
     :uri-template-args {:fileId fileId, :revisionId revisionId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.appdata"
      "https://www.googleapis.com/auth/drive.file"]}))

(defn revisions-get
  "Gets a revision's metadata or content by ID.
https://developers.google.com/drive/api/reference/rest/v3/revisions/get

fileId <string> The ID of the file.
revisionId <string> The ID of the revision.

optional:
acknowledgeAbuse <boolean> Whether the user is acknowledging the risk of downloading known malware or other abusive files. This is only applicable when alt=media."
  ([fileId revisionId] (revisions-get fileId revisionId nil))
  ([fileId revisionId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/revisions/{revisionId}",
       :uri-template-args {:fileId fileId, :revisionId revisionId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn revisions-list
  "Lists a file's revisions.
https://developers.google.com/drive/api/reference/rest/v3/revisions/list

fileId <string> The ID of the file.

optional:
pageSize <integer> The maximum number of revisions to return per page."
  ([fileId] (revisions-list fileId nil))
  ([fileId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/files/{fileId}/revisions",
       :uri-template-args {:fileId fileId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn revisions-update
  "Updates a revision with patch semantics.
https://developers.google.com/drive/api/reference/rest/v3/revisions/update

fileId <string> The ID of the file.
revisionId <string> The ID of the revision.
Revision:
{:publishedOutsideDomain boolean,
 :modifiedTime string,
 :publishAuto boolean,
 :exportLinks object,
 :size string,
 :lastModifyingUser
 {:displayName string,
  :kind string,
  :me boolean,
  :permissionId string,
  :emailAddress string,
  :photoLink string},
 :id string,
 :kind string,
 :keepForever boolean,
 :mimeType string,
 :md5Checksum string,
 :publishedLink string,
 :originalFilename string,
 :published boolean}"
  [fileId revisionId Revision]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://www.googleapis.com/drive/v3/files/{fileId}/revisions/{revisionId}",
     :uri-template-args {:fileId fileId, :revisionId revisionId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.appdata"
      "https://www.googleapis.com/auth/drive.file"],
     :body Revision}))

(defn changes-getStartPageToken
  "Gets the starting pageToken for listing future changes.
https://developers.google.com/drive/api/reference/rest/v3/changes/getStartPageToken

optional:
driveId <string> The ID of the shared drive for which the starting pageToken for listing future changes from that shared drive will be returned.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead.
teamDriveId <string> Deprecated: Use `driveId` instead."
  ([] (changes-getStartPageToken nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://www.googleapis.com/drive/v3/changes/startPageToken",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn changes-list
  "Lists the changes for a user or shared drive.
https://developers.google.com/drive/api/reference/rest/v3/changes/list

pageToken <string> The token for continuing a previous list request on the next page. This should be set to the value of 'nextPageToken' from the previous response or to the response from the getStartPageToken method.

optional:
includeRemoved <boolean> Whether to include changes indicating that items have been removed from the list of changes, for example by deletion or loss of access.
restrictToMyDrive <boolean> Whether to restrict the results to changes inside the My Drive hierarchy. This omits changes to files such as those in the Application Data folder or shared files which have not been added to My Drive.
includeCorpusRemovals <boolean> Whether changes should include the file resource if the file is still accessible by the user at the time of the request, even when a file was removed from the list of changes and there will be no further change entries for this file.
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response.
includeItemsFromAllDrives <boolean> Whether both My Drive and shared drive items should be included in results.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
teamDriveId <string> Deprecated: Use `driveId` instead.
pageSize <integer> The maximum number of changes to return per page.
spaces <string> A comma-separated list of spaces to query within the corpora. Supported values are 'drive' and 'appDataFolder'.
includeTeamDriveItems <boolean> Deprecated: Use `includeItemsFromAllDrives` instead.
driveId <string> The shared drive from which changes will be returned. If specified the change IDs will be reflective of the shared drive; use the combined drive ID and change ID as an identifier.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead."
  ([pageToken] (changes-list pageToken nil))
  ([pageToken optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://www.googleapis.com/drive/v3/changes",
       :uri-template-args {},
       :query-params (merge {:pageToken pageToken} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"]})))

(defn changes-watch
  "Subscribes to changes for a user.
https://developers.google.com/drive/api/reference/rest/v3/changes/watch

pageToken <string> The token for continuing a previous list request on the next page. This should be set to the value of 'nextPageToken' from the previous response or to the response from the getStartPageToken method.
Channel:
{:address string,
 :resourceUri string,
 :payload boolean,
 :expiration string,
 :params object,
 :type string,
 :resourceId string,
 :token string,
 :id string,
 :kind string}

optional:
includeRemoved <boolean> Whether to include changes indicating that items have been removed from the list of changes, for example by deletion or loss of access.
restrictToMyDrive <boolean> Whether to restrict the results to changes inside the My Drive hierarchy. This omits changes to files such as those in the Application Data folder or shared files which have not been added to My Drive.
includeCorpusRemovals <boolean> Whether changes should include the file resource if the file is still accessible by the user at the time of the request, even when a file was removed from the list of changes and there will be no further change entries for this file.
includePermissionsForView <string> Specifies which additional view's permissions to include in the response. Only 'published' is supported.
includeLabels <string> A comma-separated list of IDs of labels to include in the `labelInfo` part of the response.
includeItemsFromAllDrives <boolean> Whether both My Drive and shared drive items should be included in results.
supportsAllDrives <boolean> Whether the requesting application supports both My Drives and shared drives.
teamDriveId <string> Deprecated: Use `driveId` instead.
pageSize <integer> The maximum number of changes to return per page.
spaces <string> A comma-separated list of spaces to query within the corpora. Supported values are 'drive' and 'appDataFolder'.
includeTeamDriveItems <boolean> Deprecated: Use `includeItemsFromAllDrives` instead.
driveId <string> The shared drive from which changes will be returned. If specified the change IDs will be reflective of the shared drive; use the combined drive ID and change ID as an identifier.
supportsTeamDrives <boolean> Deprecated: Use `supportsAllDrives` instead."
  ([pageToken Channel] (changes-watch pageToken Channel nil))
  ([pageToken Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://www.googleapis.com/drive/v3/changes/watch",
       :uri-template-args {},
       :query-params (merge {:pageToken pageToken} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.appdata"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.meet.readonly"
        "https://www.googleapis.com/auth/drive.metadata"
        "https://www.googleapis.com/auth/drive.metadata.readonly"
        "https://www.googleapis.com/auth/drive.photos.readonly"
        "https://www.googleapis.com/auth/drive.readonly"],
       :body Channel})))

(defn about-get
  "Gets information about the user, the user's Drive, and system capabilities.
https://developers.google.com/drive/api/reference/rest/v3/about/get"
  []
  (client/api-request
    {:method "GET",
     :uri-template "https://www.googleapis.com/drive/v3/about",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.appdata"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.metadata"
      "https://www.googleapis.com/auth/drive.metadata.readonly"
      "https://www.googleapis.com/auth/drive.photos.readonly"
      "https://www.googleapis.com/auth/drive.readonly"]}))

(ns happygapi2.keep
  "Google Keep API
The Google Keep API is used in an enterprise environment to manage Google Keep content and resolve issues identified by cloud security software.
See: https://developers.google.com/keep"
  (:require [happy.oauth2.client :as client]))

(defn notes-create
  "Creates a new note.
https://developers.google.com/keep/reference/rest/v1/notes/create

Note:
{:permissions
 [{:name string,
   :role [ROLE_UNSPECIFIED OWNER WRITER],
   :email string,
   :user {:email string},
   :group {:email string},
   :family object,
   :deleted boolean}],
 :trashTime string,
 :name string,
 :attachments [{:name string, :mimeType [string]}],
 :createTime string,
 :title string,
 :updateTime string,
 :trashed boolean,
 :body
 {:text {:text string},
  :list
  {:listItems
   [{:childListItems
     [{:childListItems [ListItem],
       :text TextContent,
       :checked boolean}],
     :text {:text string},
     :checked boolean}]}}}"
  [Note]
  (client/api-request
    {:method "POST",
     :uri-template "https://keep.googleapis.com/v1/notes",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/keep"],
     :body Note}))

(defn notes-get
  "Gets a note.
https://developers.google.com/keep/reference/rest/v1/notes/get

name <string> Required. Name of the resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://keep.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/keep"
      "https://www.googleapis.com/auth/keep.readonly"]}))

(defn notes-list
  "Lists notes. Every list call returns a page of results with `page_size` as the upper bound of returned items. A `page_size` of zero allows the server to choose the upper bound. The ListNotesResponse contains at most `page_size` entries. If there are more things left to list, it provides a `next_page_token` value. (Page tokens are opaque values.) To get the next page of results, copy the result's `next_page_token` into the next request's `page_token`. Repeat until the `next_page_token` returned with a page of results is empty. ListNotes return consistent results in the face of concurrent changes, or signals that it cannot with an ABORTED error.
https://developers.google.com/keep/reference/rest/v1/notes/list

optional:
pageSize <integer> The maximum number of results to return.
filter <string> Filter for list results. If no filter is supplied, the `trashed` filter is applied by default. Valid fields to filter by are: `create_time`, `update_time`, `trash_time`, and `trashed`. Filter syntax follows the [Google AIP filtering spec](https://aip.dev/160)."
  ([] (notes-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://keep.googleapis.com/v1/notes",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/keep"
        "https://www.googleapis.com/auth/keep.readonly"]})))

(defn notes-delete
  "Deletes a note. Caller must have the `OWNER` role on the note to delete. Deleting a note removes the resource immediately and cannot be undone. Any collaborators will lose access to the note.
https://developers.google.com/keep/reference/rest/v1/notes/delete

name <string> Required. Name of the note to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://keep.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/keep"]}))

(defn notes-permissions-batchCreate
  "Creates one or more permissions on the note. Only permissions with the `WRITER` role may be created. If adding any permission fails, then the entire request fails and no changes are made.
https://developers.google.com/keep/reference/rest/v1/notes/permissions/batchCreate

parent <string> The parent resource shared by all Permissions being created. Format: `notes/{note}` If this is set, the parent field in the CreatePermission messages must either be empty or match this field.
BatchCreatePermissionsRequest:
{:requests
 [{:parent string,
   :permission
   {:name string,
    :role [ROLE_UNSPECIFIED OWNER WRITER],
    :email string,
    :user {:email string},
    :group {:email string},
    :family object,
    :deleted boolean}}]}"
  [parent BatchCreatePermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://keep.googleapis.com/v1/{+parent}/permissions:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/keep"],
     :body BatchCreatePermissionsRequest}))

(defn notes-permissions-batchDelete
  "Deletes one or more permissions on the note. The specified entities will immediately lose access. A permission with the `OWNER` role can't be removed. If removing a permission fails, then the entire request fails and no changes are made. Returns a 400 bad request error if a specified permission does not exist on the note.
https://developers.google.com/keep/reference/rest/v1/notes/permissions/batchDelete

parent <string> The parent resource shared by all permissions being deleted. Format: `notes/{note}` If this is set, the parent of all of the permissions specified in the DeletePermissionRequest messages must match this field.
BatchDeletePermissionsRequest:
{:names [string]}"
  [parent BatchDeletePermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://keep.googleapis.com/v1/{+parent}/permissions:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/keep"],
     :body BatchDeletePermissionsRequest}))

(defn media-download
  "Gets an attachment. To download attachment media via REST requires the alt=media query parameter. Returns a 400 bad request error if attachment media is not available in the requested MIME type.
https://developers.google.com/keep/reference/rest/v1/media/download

name <string> Required. The name of the attachment.

optional:
mimeType <string> The IANA MIME type format requested. The requested MIME type must be one specified in the attachment.mime_type. Required when downloading attachment media and ignored otherwise."
  ([name] (media-download name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://keep.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/keep"
        "https://www.googleapis.com/auth/keep.readonly"]})))

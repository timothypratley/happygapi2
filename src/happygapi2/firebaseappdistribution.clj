(ns happygapi2.firebaseappdistribution
  "Firebase App Distribution API

See: https://firebase.google.com/products/app-distribution"
  (:require [happy.oauth2.client :as client]))

(defn media-upload
  "Uploads a binary. Uploading a binary can result in a new release being created, an update to an existing release, or a no-op if a release with the same binary already exists.
https://firebase.google.com/products/app-distribution

app <string> The name of the app resource. Format: `projects/{project_number}/apps/{app_id}`
GoogleFirebaseAppdistroV1UploadReleaseRequest:
{:blob
 {:path string,
  :sha256Hash string,
  :algorithm string,
  :hash string,
  :contentTypeInfo
  {:fromUrlPath string,
   :fromHeader string,
   :bestGuess string,
   :fromFileName string,
   :fromBytes string},
  :diffChecksumsResponse
  {:objectVersion string,
   :chunkSizeBytes string,
   :checksumsLocation
   {:path string,
    :objectId
    {:bucketName string, :generation string, :objectName string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:downloadReadHandle string,
     :blobId string,
     :readToken string,
     :blobGeneration string,
     :uploadMetadataContainer string},
    :inline string},
   :objectSizeBytes string,
   :objectLocation
   {:path string,
    :objectId
    {:bucketName string, :generation string, :objectName string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:downloadReadHandle string,
     :blobId string,
     :readToken string,
     :blobGeneration string,
     :uploadMetadataContainer string},
    :inline string}},
  :objectId
  {:bucketName string, :generation string, :objectName string},
  :crc32cHash integer,
  :isPotentialRetry boolean,
  :diffVersionResponse
  {:objectVersion string, :objectSizeBytes string},
  :blobRef string,
  :bigstoreObjectRef string,
  :cosmoBinaryReference string,
  :md5Hash string,
  :token string,
  :filename string,
  :diffUploadResponse
  {:originalObject
   {:path string,
    :objectId
    {:bucketName string, :generation string, :objectName string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:downloadReadHandle string,
     :blobId string,
     :readToken string,
     :blobGeneration string,
     :uploadMetadataContainer string},
    :inline string},
   :objectVersion string},
  :sha1Hash string,
  :diffDownloadResponse
  {:objectLocation
   {:path string,
    :objectId
    {:bucketName string, :generation string, :objectName string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:downloadReadHandle string,
     :blobId string,
     :readToken string,
     :blobGeneration string,
     :uploadMetadataContainer string},
    :inline string}},
  :compositeMedia
  [{:path string,
    :objectId
    {:bucketName string, :generation string, :objectName string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:downloadReadHandle string,
     :blobId string,
     :readToken string,
     :blobGeneration string,
     :uploadMetadataContainer string},
    :inline string}],
  :referenceType
  [PATH
   BLOB_REF
   INLINE
   GET_MEDIA
   COMPOSITE_MEDIA
   BIGSTORE_REF
   DIFF_VERSION_RESPONSE
   DIFF_CHECKSUMS_RESPONSE
   DIFF_DOWNLOAD_RESPONSE
   DIFF_UPLOAD_REQUEST
   DIFF_UPLOAD_RESPONSE
   COSMO_BINARY_REFERENCE
   ARBITRARY_BYTES],
  :length string,
  :downloadParameters
  {:allowGzipCompression boolean, :ignoreRange boolean},
  :blobstore2Info
  {:downloadReadHandle string,
   :blobId string,
   :readToken string,
   :blobGeneration string,
   :uploadMetadataContainer string},
  :hashVerified boolean,
  :contentType string,
  :diffUploadRequest
  {:objectVersion string,
   :checksumsInfo
   {:path string,
    :objectId
    {:bucketName string, :generation string, :objectName string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:downloadReadHandle string,
     :blobId string,
     :readToken string,
     :blobGeneration string,
     :uploadMetadataContainer string},
    :inline string},
   :objectInfo
   {:path string,
    :objectId
    {:bucketName string, :generation string, :objectName string},
    :crc32cHash integer,
    :blobRef string,
    :cosmoBinaryReference string,
    :md5Hash string,
    :sha1Hash string,
    :referenceType
    [PATH BLOB_REF INLINE BIGSTORE_REF COSMO_BINARY_REFERENCE],
    :length string,
    :blobstore2Info
    {:downloadReadHandle string,
     :blobId string,
     :readToken string,
     :blobGeneration string,
     :uploadMetadataContainer string},
    :inline string}},
  :timestamp string,
  :inline string,
  :mediaId string}}"
  [app GoogleFirebaseAppdistroV1UploadReleaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+app}/releases:upload",
     :uri-template-args {:app app},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleFirebaseAppdistroV1UploadReleaseRequest}))

(defn projects-groups-list
  "List groups.
https://firebase.google.com/products/app-distribution

parent <string> Required. The name of the project resource, which is the parent of the group resources. Format: `projects/{project_number}`

optional:
pageSize <integer> Optional. The maximum number of groups to return. The service may return fewer than this value. The valid range is [1-1000]; If unspecified (0), at most 25 groups are returned. Values above 1000 are coerced to 1000."
  ([parent] (projects-groups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+parent}/groups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-groups-create
  "Create a group.
https://firebase.google.com/products/app-distribution

parent <string> Required. The name of the project resource, which is the parent of the group resource. Format: `projects/{project_number}`
GoogleFirebaseAppdistroV1Group:
{:name string,
 :displayName string,
 :inviteLinkCount integer,
 :releaseCount integer,
 :testerCount integer}

optional:
groupId <string> Optional. The \"alias\" to use for the group, which will become the final component of the group's resource name. This value must be unique per project. The field is named `groupId` to comply with AIP guidance for user-specified IDs. This value should be 4-63 characters, and valid characters are `/a-z-/`. If not set, it will be generated based on the display name."
  ([parent GoogleFirebaseAppdistroV1Group]
    (projects-groups-create parent GoogleFirebaseAppdistroV1Group nil))
  ([parent GoogleFirebaseAppdistroV1Group optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+parent}/groups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleFirebaseAppdistroV1Group})))

(defn projects-groups-patch
  "Update a group.
https://firebase.google.com/products/app-distribution

name <string> The name of the group resource. Format: `projects/{project_number}/groups/{group_alias}`
GoogleFirebaseAppdistroV1Group:
{:name string,
 :displayName string,
 :inviteLinkCount integer,
 :releaseCount integer,
 :testerCount integer}

optional:
updateMask <string> The list of fields to update."
  ([name GoogleFirebaseAppdistroV1Group]
    (projects-groups-patch name GoogleFirebaseAppdistroV1Group nil))
  ([name GoogleFirebaseAppdistroV1Group optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleFirebaseAppdistroV1Group})))

(defn projects-groups-delete
  "Delete a group.
https://firebase.google.com/products/app-distribution

name <string> Required. The name of the group resource. Format: `projects/{project_number}/groups/{group_alias}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-groups-get
  "Get a group.
https://firebase.google.com/products/app-distribution

name <string> Required. The name of the group resource to retrieve. Format: `projects/{project_number}/groups/{group_alias}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-groups-batchLeave
  "Batch removed members from a group. The testers will lose access to all releases that the groups have access to.
https://firebase.google.com/products/app-distribution

group <string> Required. The name of the group resource from which testers are removed. Format: `projects/{project_number}/groups/{group_alias}`
GoogleFirebaseAppdistroV1BatchLeaveGroupRequest:
{:emails [string]}"
  [group GoogleFirebaseAppdistroV1BatchLeaveGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+group}:batchLeave",
     :uri-template-args {:group group},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleFirebaseAppdistroV1BatchLeaveGroupRequest}))

(defn projects-groups-batchJoin
  "Batch adds members to a group. The testers will gain access to all releases that the groups have access to.
https://firebase.google.com/products/app-distribution

group <string> Required. The name of the group resource to which testers are added. Format: `projects/{project_number}/groups/{group_alias}`
GoogleFirebaseAppdistroV1BatchJoinGroupRequest:
{:emails [string], :createMissingTesters boolean}"
  [group GoogleFirebaseAppdistroV1BatchJoinGroupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+group}:batchJoin",
     :uri-template-args {:group group},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleFirebaseAppdistroV1BatchJoinGroupRequest}))

(defn projects-apps-getAabInfo
  "Gets Android App Bundle (AAB) information for a Firebase app.
https://firebase.google.com/products/app-distribution

name <string> Required. The name of the `AabInfo` resource to retrieve. Format: `projects/{project_number}/apps/{app_id}/aabInfo`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-apps-releases-get
  "Gets a release.
https://firebase.google.com/products/app-distribution

name <string> Required. The name of the release resource to retrieve. Format: projects/{project_number}/apps/{app_id}/releases/{release_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-apps-releases-patch
  "Updates a release.
https://firebase.google.com/products/app-distribution

name <string> The name of the release resource. Format: `projects/{project_number}/apps/{app_id}/releases/{release_id}`
GoogleFirebaseAppdistroV1Release:
{:displayVersion string,
 :firebaseConsoleUri string,
 :releaseNotes {:text string},
 :name string,
 :binaryDownloadUri string,
 :testingUri string,
 :createTime string,
 :buildVersion string}

optional:
updateMask <string> The list of fields to update."
  ([name GoogleFirebaseAppdistroV1Release]
    (projects-apps-releases-patch
      name
      GoogleFirebaseAppdistroV1Release
      nil))
  ([name GoogleFirebaseAppdistroV1Release optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleFirebaseAppdistroV1Release})))

(defn projects-apps-releases-distribute
  "Distributes a release to testers. This call does the following: 1. Creates testers for the specified emails, if none exist. 2. Adds the testers and groups to the release. 3. Sends new testers an invitation email. 4. Sends existing testers a new release email. The request will fail with a `INVALID_ARGUMENT` if it contains a group that doesn't exist.
https://firebase.google.com/products/app-distribution

name <string> Required. The name of the release resource to distribute. Format: `projects/{project_number}/apps/{app_id}/releases/{release_id}`
GoogleFirebaseAppdistroV1DistributeReleaseRequest:
{:testerEmails [string], :groupAliases [string]}"
  [name GoogleFirebaseAppdistroV1DistributeReleaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}:distribute",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleFirebaseAppdistroV1DistributeReleaseRequest}))

(defn projects-apps-releases-batchDelete
  "Deletes releases. A maximum of 100 releases can be deleted per request.
https://firebase.google.com/products/app-distribution

parent <string> Required. The name of the app resource, which is the parent of the release resources. Format: `projects/{project_number}/apps/{app_id}`
GoogleFirebaseAppdistroV1BatchDeleteReleasesRequest:
{:names [string]}"
  [parent GoogleFirebaseAppdistroV1BatchDeleteReleasesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+parent}/releases:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleFirebaseAppdistroV1BatchDeleteReleasesRequest}))

(defn projects-apps-releases-list
  "Lists releases. By default, sorts by `createTime` in descending order.
https://firebase.google.com/products/app-distribution

parent <string> Required. The name of the app resource, which is the parent of the release resources. Format: `projects/{project_number}/apps/{app_id}`

optional:
orderBy <string> The fields used to order releases. Supported fields: - `createTime` To specify descending order for a field, append a \"desc\" suffix, for example, `createTime desc`. If this parameter is not set, releases are ordered by `createTime` in descending order.
pageSize <integer> The maximum number of releases to return. The service may return fewer than this value. The valid range is [1-100]; If unspecified (0), at most 25 releases are returned. Values above 100 are coerced to 100.
filter <string> The expression to filter releases listed in the response. To learn more about filtering, refer to [Google's AIP-160 standard](http://aip.dev/160). Supported fields: - `releaseNotes.text` supports `=` (can contain a wildcard character (`*`) at the beginning or end of the string) - `createTime` supports `<`, `<=`, `>` and `>=`, and expects an RFC-3339 formatted string Examples: - `createTime <= \"2021-09-08T00:00:00+04:00\"` - `releaseNotes.text=\"fixes\" AND createTime >= \"2021-09-08T00:00:00.0Z\"` - `releaseNotes.text=\"*v1.0.0-rc*\"`"
  ([parent] (projects-apps-releases-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+parent}/releases",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-apps-releases-feedbackReports-delete
  "Deletes a feedback report.
https://firebase.google.com/products/app-distribution

name <string> Required. The name of the feedback report to delete. Format: projects/{project_number}/apps/{app}/releases/{release}/feedbackReports/{feedback_report}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-apps-releases-feedbackReports-get
  "Gets a feedback report.
https://firebase.google.com/products/app-distribution

name <string> Required. The name of the feedback report to retrieve. Format: projects/{project_number}/apps/{app}/releases/{release}/feedbackReports/{feedback_report}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-apps-releases-feedbackReports-list
  "Lists feedback reports. By default, sorts by `createTime` in descending order.
https://firebase.google.com/products/app-distribution

parent <string> Required. The name of the release resource, which is the parent of the feedback report resources. Format: `projects/{project_number}/apps/{app}/releases/{release}`

optional:
pageSize <integer> The maximum number of feedback reports to return. The service may return fewer than this value. The valid range is [1-100]; If unspecified (0), at most 25 feedback reports are returned. Values above 100 are coerced to 100."
  ([parent] (projects-apps-releases-feedbackReports-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+parent}/feedbackReports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-apps-releases-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://firebase.google.com/products/app-distribution

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-apps-releases-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://firebase.google.com/products/app-distribution

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-apps-releases-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://firebase.google.com/products/app-distribution

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-apps-releases-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://firebase.google.com/products/app-distribution

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (projects-apps-releases-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-apps-releases-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://firebase.google.com/products/app-distribution

name <string> The name of the operation resource to wait on.
GoogleLongrunningWaitOperationRequest:
{:timeout string}"
  [name GoogleLongrunningWaitOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+name}:wait",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningWaitOperationRequest}))

(defn projects-testers-list
  "Lists testers and their resource ids.
https://firebase.google.com/products/app-distribution

parent <string> Required. The name of the project resource, which is the parent of the tester resources. Format: `projects/{project_number}`

optional:
pageSize <integer> Optional. The maximum number of testers to return. The service may return fewer than this value. The valid range is [1-1000]; If unspecified (0), at most 10 testers are returned. Values above 1000 are coerced to 1000.
filter <string> Optional. The expression to filter testers listed in the response. To learn more about filtering, refer to [Google's AIP-160 standard](http://aip.dev/160). Supported fields: - `name` - `displayName` - `groups` Example: - `name = \"projects/-/testers/*@example.com\"` - `displayName = \"Joe Sixpack\"` - `groups = \"projects/*/groups/qa-team\"`"
  ([parent] (projects-testers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+parent}/testers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-testers-batchAdd
  "Batch adds testers. This call adds testers for the specified emails if they don't already exist. Returns all testers specified in the request, including newly created and previously existing testers. This action is idempotent.
https://firebase.google.com/products/app-distribution

project <string> Required. The name of the project resource. Format: `projects/{project_number}`
GoogleFirebaseAppdistroV1BatchAddTestersRequest:
{:emails [string]}"
  [project GoogleFirebaseAppdistroV1BatchAddTestersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+project}/testers:batchAdd",
     :uri-template-args {:project project},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleFirebaseAppdistroV1BatchAddTestersRequest}))

(defn projects-testers-patch
  "Update a tester. If the testers joins a group they gain access to all releases that the group has access to.
https://firebase.google.com/products/app-distribution

name <string> The name of the tester resource. Format: `projects/{project_number}/testers/{email_address}`
GoogleFirebaseAppdistroV1Tester:
{:name string,
 :displayName string,
 :groups [string],
 :lastActivityTime string}

optional:
updateMask <string> The list of fields to update."
  ([name GoogleFirebaseAppdistroV1Tester]
    (projects-testers-patch name GoogleFirebaseAppdistroV1Tester nil))
  ([name GoogleFirebaseAppdistroV1Tester optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://firebaseappdistribution.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleFirebaseAppdistroV1Tester})))

(defn projects-testers-batchRemove
  "Batch removes testers. If found, this call deletes testers for the specified emails. Returns all deleted testers.
https://firebase.google.com/products/app-distribution

project <string> Required. The name of the project resource. Format: `projects/{project_number}`
GoogleFirebaseAppdistroV1BatchRemoveTestersRequest:
{:emails [string]}"
  [project GoogleFirebaseAppdistroV1BatchRemoveTestersRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseappdistribution.googleapis.com/v1/{+project}/testers:batchRemove",
     :uri-template-args {:project project},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleFirebaseAppdistroV1BatchRemoveTestersRequest}))

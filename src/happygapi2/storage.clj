(ns happygapi2.storage
  "Cloud Storage JSON API
Stores and retrieves potentially large, immutable data objects.
See: https://cloud.google.com/storage/docs/json_api"
  (:require [happy.oauth2.client :as client]))

(defn projects-hmacKeys-create
  "Creates a new HMAC key for the specified service account.
https://cloud.google.com/storage/docs/reference/rest/v1/projects.hmacKeys/create

projectId <string> Project ID owning the service account.
serviceAccountEmail <string> Email address of the service account.

optional:
userProject <string> The project to be billed for this request."
  ([projectId serviceAccountEmail]
    (projects-hmacKeys-create projectId serviceAccountEmail nil))
  ([projectId serviceAccountEmail optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/projects/{projectId}/hmacKeys",
       :uri-template-args {:projectId projectId},
       :query-params
       (merge {:serviceAccountEmail serviceAccountEmail} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn projects-hmacKeys-delete
  "Deletes an HMAC key.
https://cloud.google.com/storage/docs/reference/rest/v1/projects.hmacKeys/delete

projectId <string> Project ID owning the requested key
accessId <string> Name of the HMAC key to be deleted.

optional:
userProject <string> The project to be billed for this request."
  ([projectId accessId]
    (projects-hmacKeys-delete projectId accessId nil))
  ([projectId accessId optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/projects/{projectId}/hmacKeys/{accessId}",
       :uri-template-args {:accessId accessId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn projects-hmacKeys-get
  "Retrieves an HMAC key's metadata
https://cloud.google.com/storage/docs/reference/rest/v1/projects.hmacKeys/get

projectId <string> Project ID owning the service account of the requested key.
accessId <string> Name of the HMAC key.

optional:
userProject <string> The project to be billed for this request."
  ([projectId accessId] (projects-hmacKeys-get projectId accessId nil))
  ([projectId accessId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/projects/{projectId}/hmacKeys/{accessId}",
       :uri-template-args {:accessId accessId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"]})))

(defn projects-hmacKeys-list
  "Retrieves a list of HMAC keys matching the criteria.
https://cloud.google.com/storage/docs/reference/rest/v1/projects.hmacKeys/list

projectId <string> Name of the project in which to look for HMAC keys.

optional:
maxResults <integer> Maximum number of items to return in a single page of responses. The service uses this parameter or 250 items, whichever is smaller. The max number of items per page will also be limited by the number of distinct service accounts in the response. If the number of service accounts in a single response is too high, the page will truncated and a next page token will be returned.
serviceAccountEmail <string> If present, only keys for the given service account are returned.
showDeletedKeys <boolean> Whether or not to show keys in the DELETED state.
userProject <string> The project to be billed for this request."
  ([projectId] (projects-hmacKeys-list projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/projects/{projectId}/hmacKeys",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"]})))

(defn projects-hmacKeys-update
  "Updates the state of an HMAC key. See the HMAC Key resource descriptor for valid states.
https://cloud.google.com/storage/docs/reference/rest/v1/projects.hmacKeys/update

projectId <string> Project ID owning the service account of the updated key.
accessId <string> Name of the HMAC key being updated.
HmacKeyMetadata:
{:timeCreated string,
 :updated string,
 :selfLink string,
 :accessId string,
 :etag string,
 :state string,
 :serviceAccountEmail string,
 :id string,
 :kind string,
 :projectId string}

optional:
userProject <string> The project to be billed for this request."
  ([projectId accessId HmacKeyMetadata]
    (projects-hmacKeys-update projectId accessId HmacKeyMetadata nil))
  ([projectId accessId HmacKeyMetadata optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/projects/{projectId}/hmacKeys/{accessId}",
       :uri-template-args {:accessId accessId, :projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body HmacKeyMetadata})))

(defn projects-serviceAccount-get
  "Get the email address of this project's Google Cloud Storage service account.
https://cloud.google.com/storage/docs/reference/rest/v1/projects.serviceAccount/get

projectId <string> Project ID

optional:
userProject <string> The project to be billed for this request."
  ([projectId] (projects-serviceAccount-get projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/projects/{projectId}/serviceAccount",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn folders-delete
  "Permanently deletes a folder. Only applicable to buckets with hierarchical namespace enabled.
https://cloud.google.com/storage/docs/reference/rest/v1/folders/delete

bucket <string> Name of the bucket in which the folder resides.
folder <string> Name of a folder.

optional:
ifMetagenerationMatch <string> If set, only deletes the folder if its metageneration matches this value.
ifMetagenerationNotMatch <string> If set, only deletes the folder if its metageneration does not match this value."
  ([bucket folder] (folders-delete bucket folder nil))
  ([bucket folder optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/folders/{folder}",
       :uri-template-args {:bucket bucket, :folder folder},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn folders-get
  "Returns metadata for the specified folder. Only applicable to buckets with hierarchical namespace enabled.
https://cloud.google.com/storage/docs/reference/rest/v1/folders/get

bucket <string> Name of the bucket in which the folder resides.
folder <string> Name of a folder.

optional:
ifMetagenerationMatch <string> Makes the return of the folder metadata conditional on whether the folder's current metageneration matches the given value.
ifMetagenerationNotMatch <string> Makes the return of the folder metadata conditional on whether the folder's current metageneration does not match the given value."
  ([bucket folder] (folders-get bucket folder nil))
  ([bucket folder optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/folders/{folder}",
       :uri-template-args {:bucket bucket, :folder folder},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn folders-insert
  "Creates a new folder. Only applicable to buckets with hierarchical namespace enabled.
https://cloud.google.com/storage/docs/reference/rest/v1/folders/insert

bucket <string> Name of the bucket in which the folder resides.
Folder:
{:pendingRenameInfo {:operationId string},
 :name string,
 :createTime string,
 :selfLink string,
 :updateTime string,
 :id string,
 :kind string,
 :bucket string,
 :metageneration string}

optional:
recursive <boolean> If true, any parent folder which doesn’t exist will be created automatically."
  ([bucket Folder] (folders-insert bucket Folder nil))
  ([bucket Folder optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/folders",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Folder})))

(defn folders-list
  "Retrieves a list of folders matching the criteria. Only applicable to buckets with hierarchical namespace enabled.
https://cloud.google.com/storage/docs/reference/rest/v1/folders/list

bucket <string> Name of the bucket in which to look for folders.

optional:
delimiter <string> Returns results in a directory-like mode. The only supported value is '/'. If set, items will only contain folders that either exactly match the prefix, or are one level below the prefix.
endOffset <string> Filter results to folders whose names are lexicographically before endOffset. If startOffset is also set, the folders listed will have names between startOffset (inclusive) and endOffset (exclusive).
pageSize <integer> Maximum number of items to return in a single page of responses.
prefix <string> Filter results to folders whose paths begin with this prefix. If set, the value must either be an empty string or end with a '/'.
startOffset <string> Filter results to folders whose names are lexicographically equal to or after startOffset. If endOffset is also set, the folders listed will have names between startOffset (inclusive) and endOffset (exclusive)."
  ([bucket] (folders-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/folders",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn folders-rename
  "Renames a source folder to a destination folder. Only applicable to buckets with hierarchical namespace enabled.
https://cloud.google.com/storage/docs/reference/rest/v1/folders/rename

bucket <string> Name of the bucket in which the folders are in.
sourceFolder <string> Name of the source folder.
destinationFolder <string> Name of the destination folder.

optional:
ifSourceMetagenerationMatch <string> Makes the operation conditional on whether the source object's current metageneration matches the given value.
ifSourceMetagenerationNotMatch <string> Makes the operation conditional on whether the source object's current metageneration does not match the given value."
  ([bucket sourceFolder destinationFolder]
    (folders-rename bucket sourceFolder destinationFolder nil))
  ([bucket sourceFolder destinationFolder optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/folders/{sourceFolder}/renameTo/folders/{destinationFolder}",
       :uri-template-args
       {:bucket bucket,
        :destinationFolder destinationFolder,
        :sourceFolder sourceFolder},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn channels-stop
  "Stop watching resources through this channel
https://cloud.google.com/storage/docs/reference/rest/v1/channels/stop

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
     :uri-template
     "https://storage.googleapis.com/storage/v1/channels/stop",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_only"
      "https://www.googleapis.com/auth/devstorage.read_write"],
     :body Channel}))

(defn objects-compose
  "Concatenates a list of existing objects into a new object in the same bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/compose

destinationBucket <string> Name of the bucket containing the source objects. The destination object is stored in this bucket.
destinationObject <string> Name of the new object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
ComposeRequest:
{:destination
 {:contentDisposition string,
  :storageClass string,
  :contentEncoding string,
  :generation string,
  :timeCreated string,
  :temporaryHold boolean,
  :eventBasedHold boolean,
  :updated string,
  :name string,
  :retentionExpirationTime string,
  :selfLink string,
  :contentLanguage string,
  :etag string,
  :retention {:retainUntilTime string, :mode string},
  :size string,
  :md5Hash string,
  :cacheControl string,
  :timeStorageClassUpdated string,
  :timeDeleted string,
  :id string,
  :kind string,
  :mediaLink string,
  :kmsKeyName string,
  :softDeleteTime string,
  :customTime string,
  :componentCount integer,
  :acl
  [{:role string,
    :email string,
    :generation string,
    :projectTeam {:projectNumber string, :team string},
    :selfLink string,
    :etag string,
    :id string,
    :kind string,
    :domain string,
    :entity string,
    :entityId string,
    :object string,
    :bucket string}],
  :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
  :contentType string,
  :hardDeleteTime string,
  :metadata object,
  :crc32c string,
  :owner {:entity string, :entityId string},
  :bucket string,
  :metageneration string},
 :kind string,
 :sourceObjects
 [{:generation string,
   :name string,
   :objectPreconditions {:ifGenerationMatch string}}]}

optional:
destinationPredefinedAcl <string> Apply a predefined set of access controls to the destination object.
ifGenerationMatch <string> Makes the operation conditional on whether the object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the object's current metageneration matches the given value.
kmsKeyName <string> Resource name of the Cloud KMS key, of the form projects/my-project/locations/global/keyRings/my-kr/cryptoKeys/my-key, that will be used to encrypt the object. Overrides the object metadata's kms_key_name value, if any.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([destinationBucket destinationObject ComposeRequest]
    (objects-compose
      destinationBucket
      destinationObject
      ComposeRequest
      nil))
  ([destinationBucket destinationObject ComposeRequest optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{destinationBucket}/o/{destinationObject}/compose",
       :uri-template-args
       {:destinationBucket destinationBucket,
        :destinationObject destinationObject},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body ComposeRequest})))

(defn objects-watchAll
  "Watch for changes on all objects in a bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/watchAll

bucket <string> Name of the bucket in which to look for objects.
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
startOffset <string> Filter results to objects whose names are lexicographically equal to or after startOffset. If endOffset is also set, the objects listed will have names between startOffset (inclusive) and endOffset (exclusive).
endOffset <string> Filter results to objects whose names are lexicographically before endOffset. If startOffset is also set, the objects listed will have names between startOffset (inclusive) and endOffset (exclusive).
prefix <string> Filter results to objects whose names begin with this prefix.
delimiter <string> Returns results in a directory-like mode. items will contain only objects whose names, aside from the prefix, do not contain delimiter. Objects whose names, aside from the prefix, contain delimiter will have their name, truncated after the delimiter, returned in prefixes. Duplicate prefixes are omitted.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
includeTrailingDelimiter <boolean> If true, objects that end in exactly one instance of delimiter will have their metadata included in items in addition to prefixes.
versions <boolean> If true, lists all versions of an object as distinct results. The default is false. For more information, see Object Versioning.
projection <string> Set of properties to return. Defaults to noAcl.
maxResults <integer> Maximum number of items plus prefixes to return in a single page of responses. As duplicate prefixes are omitted, fewer total results may be returned than requested. The service will use this parameter or 1,000 items, whichever is smaller."
  ([bucket Channel] (objects-watchAll bucket Channel nil))
  ([bucket Channel optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/watch",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Channel})))

(defn objects-get
  "Retrieves an object or its metadata.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/get

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
ifGenerationMatch <string> Makes the operation conditional on whether the object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether the object's current metageneration does not match the given value.
ifGenerationNotMatch <string> Makes the operation conditional on whether the object's current generation does not match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the object's current metageneration matches the given value.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
softDeleted <boolean> If true, only soft-deleted object versions will be listed. The default is false. For more information, see Soft Delete.
projection <string> Set of properties to return. Defaults to noAcl."
  ([bucket object] (objects-get bucket object nil))
  ([bucket object optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}",
       :uri-template-args {:object object, :bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn objects-copy
  "Copies a source object to a destination object. Optionally overrides metadata.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/copy

sourceBucket <string> Name of the bucket in which to find the source object.
sourceObject <string> Name of the source object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
destinationBucket <string> Name of the bucket in which to store the new object. Overrides the provided object metadata's bucket value, if any.For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
destinationObject <string> Name of the new object. Required when the object metadata is not otherwise provided. Overrides the object metadata's name value, if any.
Object:
{:contentDisposition string,
 :storageClass string,
 :contentEncoding string,
 :generation string,
 :timeCreated string,
 :temporaryHold boolean,
 :eventBasedHold boolean,
 :updated string,
 :name string,
 :retentionExpirationTime string,
 :selfLink string,
 :contentLanguage string,
 :etag string,
 :retention {:retainUntilTime string, :mode string},
 :size string,
 :md5Hash string,
 :cacheControl string,
 :timeStorageClassUpdated string,
 :timeDeleted string,
 :id string,
 :kind string,
 :mediaLink string,
 :kmsKeyName string,
 :softDeleteTime string,
 :customTime string,
 :componentCount integer,
 :acl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
 :contentType string,
 :hardDeleteTime string,
 :metadata object,
 :crc32c string,
 :owner {:entity string, :entityId string},
 :bucket string,
 :metageneration string}

optional:
ifGenerationMatch <string> Makes the operation conditional on whether the destination object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether the destination object's current metageneration does not match the given value.
ifGenerationNotMatch <string> Makes the operation conditional on whether the destination object's current generation does not match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the destination object's current metageneration matches the given value.
destinationPredefinedAcl <string> Apply a predefined set of access controls to the destination object.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
ifSourceMetagenerationNotMatch <string> Makes the operation conditional on whether the source object's current metageneration does not match the given value.
destinationKmsKeyName <string> Resource name of the Cloud KMS key, of the form projects/my-project/locations/global/keyRings/my-kr/cryptoKeys/my-key, that will be used to encrypt the object. Overrides the object metadata's kms_key_name value, if any.
sourceGeneration <string> If present, selects a specific revision of the source object (as opposed to the latest version, the default).
ifSourceGenerationMatch <string> Makes the operation conditional on whether the source object's current generation matches the given value.
projection <string> Set of properties to return. Defaults to noAcl, unless the object resource specifies the acl property, when it defaults to full.
ifSourceGenerationNotMatch <string> Makes the operation conditional on whether the source object's current generation does not match the given value.
ifSourceMetagenerationMatch <string> Makes the operation conditional on whether the source object's current metageneration matches the given value."
  ([sourceBucket
    sourceObject
    destinationBucket
    destinationObject
    Object]
    (objects-copy
      sourceBucket
      sourceObject
      destinationBucket
      destinationObject
      Object
      nil))
  ([sourceBucket
    sourceObject
    destinationBucket
    destinationObject
    Object
    optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{sourceBucket}/o/{sourceObject}/copyTo/b/{destinationBucket}/o/{destinationObject}",
       :uri-template-args
       {:destinationBucket destinationBucket,
        :sourceBucket sourceBucket,
        :destinationObject destinationObject,
        :sourceObject sourceObject},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Object})))

(defn objects-setIamPolicy
  "Updates an IAM policy for the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/setIamPolicy

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
Policy:
{:bindings
 [{:condition
   {:description string,
    :expression string,
    :location string,
    :title string},
   :members [string],
   :role string}],
 :etag string,
 :kind string,
 :resourceId string,
 :version integer}

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object Policy]
    (objects-setIamPolicy bucket object Policy nil))
  ([bucket object Policy optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/iam",
       :uri-template-args {:bucket bucket, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Policy})))

(defn objects-insert
  "Stores a new object and metadata.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/insert

bucket <string> Name of the bucket in which to store the new object. Overrides the provided object metadata's bucket value, if any.
Object:
{:contentDisposition string,
 :storageClass string,
 :contentEncoding string,
 :generation string,
 :timeCreated string,
 :temporaryHold boolean,
 :eventBasedHold boolean,
 :updated string,
 :name string,
 :retentionExpirationTime string,
 :selfLink string,
 :contentLanguage string,
 :etag string,
 :retention {:retainUntilTime string, :mode string},
 :size string,
 :md5Hash string,
 :cacheControl string,
 :timeStorageClassUpdated string,
 :timeDeleted string,
 :id string,
 :kind string,
 :mediaLink string,
 :kmsKeyName string,
 :softDeleteTime string,
 :customTime string,
 :componentCount integer,
 :acl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
 :contentType string,
 :hardDeleteTime string,
 :metadata object,
 :crc32c string,
 :owner {:entity string, :entityId string},
 :bucket string,
 :metageneration string}

optional:
contentEncoding <string> If set, sets the contentEncoding property of the final object to this value. Setting this parameter is equivalent to setting the contentEncoding metadata property. This can be useful when uploading an object with uploadType=media to indicate the encoding of the content being uploaded.
predefinedAcl <string> Apply a predefined set of access controls to this object.
ifGenerationMatch <string> Makes the operation conditional on whether the object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether the object's current metageneration does not match the given value.
name <string> Name of the object. Required when the object metadata is not otherwise provided. Overrides the object metadata's name value, if any. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
ifGenerationNotMatch <string> Makes the operation conditional on whether the object's current generation does not match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the object's current metageneration matches the given value.
kmsKeyName <string> Resource name of the Cloud KMS key, of the form projects/my-project/locations/global/keyRings/my-kr/cryptoKeys/my-key, that will be used to encrypt the object. Overrides the object metadata's kms_key_name value, if any.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
projection <string> Set of properties to return. Defaults to noAcl, unless the object resource specifies the acl property, when it defaults to full."
  ([bucket Object] (objects-insert bucket Object nil))
  ([bucket Object optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Object})))

(defn objects-patch
  "Patches an object's metadata.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/patch

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
Object:
{:contentDisposition string,
 :storageClass string,
 :contentEncoding string,
 :generation string,
 :timeCreated string,
 :temporaryHold boolean,
 :eventBasedHold boolean,
 :updated string,
 :name string,
 :retentionExpirationTime string,
 :selfLink string,
 :contentLanguage string,
 :etag string,
 :retention {:retainUntilTime string, :mode string},
 :size string,
 :md5Hash string,
 :cacheControl string,
 :timeStorageClassUpdated string,
 :timeDeleted string,
 :id string,
 :kind string,
 :mediaLink string,
 :kmsKeyName string,
 :softDeleteTime string,
 :customTime string,
 :componentCount integer,
 :acl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
 :contentType string,
 :hardDeleteTime string,
 :metadata object,
 :crc32c string,
 :owner {:entity string, :entityId string},
 :bucket string,
 :metageneration string}

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
predefinedAcl <string> Apply a predefined set of access controls to this object.
ifGenerationMatch <string> Makes the operation conditional on whether the object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether the object's current metageneration does not match the given value.
ifGenerationNotMatch <string> Makes the operation conditional on whether the object's current generation does not match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the object's current metageneration matches the given value.
overrideUnlockedRetention <boolean> Must be true to remove the retention configuration, reduce its unlocked retention period, or change its mode from unlocked to locked.
userProject <string> The project to be billed for this request, for Requester Pays buckets.
projection <string> Set of properties to return. Defaults to full."
  ([bucket object Object] (objects-patch bucket object Object nil))
  ([bucket object Object optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}",
       :uri-template-args {:object object, :bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body Object})))

(defn objects-testIamPermissions
  "Tests a set of permissions on the given object to see which, if any, are held by the caller.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/testIamPermissions

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
permissions <string> Permissions to test.

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object permissions]
    (objects-testIamPermissions bucket object permissions nil))
  ([bucket object permissions optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/iam/testPermissions",
       :uri-template-args {:bucket bucket, :object object},
       :query-params (merge {:permissions permissions} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn objects-restore
  "Restores a soft-deleted object.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/restore

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see Encoding URI Path Parts.
generation <string> Selects a specific revision of this object.

optional:
ifGenerationMatch <string> Makes the operation conditional on whether the object's one live generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether none of the object's live metagenerations match the given value.
ifGenerationNotMatch <string> Makes the operation conditional on whether none of the object's live generations match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the object's one live metageneration matches the given value.
copySourceAcl <boolean> If true, copies the source object's ACL; otherwise, uses the bucket's default object ACL. The default is false.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
projection <string> Set of properties to return. Defaults to full."
  ([bucket object generation]
    (objects-restore bucket object generation nil))
  ([bucket object generation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/restore",
       :uri-template-args {:object object, :bucket bucket},
       :query-params (merge {:generation generation} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn objects-update
  "Updates an object's metadata.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/update

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
Object:
{:contentDisposition string,
 :storageClass string,
 :contentEncoding string,
 :generation string,
 :timeCreated string,
 :temporaryHold boolean,
 :eventBasedHold boolean,
 :updated string,
 :name string,
 :retentionExpirationTime string,
 :selfLink string,
 :contentLanguage string,
 :etag string,
 :retention {:retainUntilTime string, :mode string},
 :size string,
 :md5Hash string,
 :cacheControl string,
 :timeStorageClassUpdated string,
 :timeDeleted string,
 :id string,
 :kind string,
 :mediaLink string,
 :kmsKeyName string,
 :softDeleteTime string,
 :customTime string,
 :componentCount integer,
 :acl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
 :contentType string,
 :hardDeleteTime string,
 :metadata object,
 :crc32c string,
 :owner {:entity string, :entityId string},
 :bucket string,
 :metageneration string}

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
predefinedAcl <string> Apply a predefined set of access controls to this object.
ifGenerationMatch <string> Makes the operation conditional on whether the object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether the object's current metageneration does not match the given value.
ifGenerationNotMatch <string> Makes the operation conditional on whether the object's current generation does not match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the object's current metageneration matches the given value.
overrideUnlockedRetention <boolean> Must be true to remove the retention configuration, reduce its unlocked retention period, or change its mode from unlocked to locked.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
projection <string> Set of properties to return. Defaults to full."
  ([bucket object Object] (objects-update bucket object Object nil))
  ([bucket object Object optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}",
       :uri-template-args {:object object, :bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body Object})))

(defn objects-delete
  "Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for the bucket, or if the generation parameter is used.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/delete

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).

optional:
generation <string> If present, permanently deletes a specific revision of this object (as opposed to the latest version, the default).
ifGenerationMatch <string> Makes the operation conditional on whether the object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
ifGenerationNotMatch <string> Makes the operation conditional on whether the object's current generation does not match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the object's current metageneration matches the given value.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether the object's current metageneration does not match the given value.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object] (objects-delete bucket object nil))
  ([bucket object optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}",
       :uri-template-args {:bucket bucket, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn objects-getIamPolicy
  "Returns an IAM policy for the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/getIamPolicy

bucket <string> Name of the bucket in which the object resides.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object] (objects-getIamPolicy bucket object nil))
  ([bucket object optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/iam",
       :uri-template-args {:bucket bucket, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn objects-bulkRestore
  "Initiates a long-running bulk restore operation on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/bulkRestore

bucket <string> Name of the bucket in which the object resides.
BulkRestoreObjectsRequest:
{:allowOverwrite boolean,
 :softDeletedAfterTime string,
 :softDeletedBeforeTime string,
 :matchGlobs [string],
 :copySourceAcl boolean}"
  [bucket BulkRestoreObjectsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/o/bulkRestore",
     :uri-template-args {:bucket bucket},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"],
     :body BulkRestoreObjectsRequest}))

(defn objects-list
  "Retrieves a list of objects matching the criteria.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/list

bucket <string> Name of the bucket in which to look for objects.

optional:
startOffset <string> Filter results to objects whose names are lexicographically equal to or after startOffset. If endOffset is also set, the objects listed will have names between startOffset (inclusive) and endOffset (exclusive).
includeFoldersAsPrefixes <boolean> Only applicable if delimiter is set to '/'. If true, will also include folders and managed folders (besides objects) in the returned prefixes.
endOffset <string> Filter results to objects whose names are lexicographically before endOffset. If startOffset is also set, the objects listed will have names between startOffset (inclusive) and endOffset (exclusive).
prefix <string> Filter results to objects whose names begin with this prefix.
delimiter <string> Returns results in a directory-like mode. items will contain only objects whose names, aside from the prefix, do not contain delimiter. Objects whose names, aside from the prefix, contain delimiter will have their name, truncated after the delimiter, returned in prefixes. Duplicate prefixes are omitted.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
includeTrailingDelimiter <boolean> If true, objects that end in exactly one instance of delimiter will have their metadata included in items in addition to prefixes.
matchGlob <string> Filter results to objects and prefixes that match this glob pattern.
softDeleted <boolean> If true, only soft-deleted object versions will be listed. The default is false. For more information, see Soft Delete.
versions <boolean> If true, lists all versions of an object as distinct results. The default is false. For more information, see Object Versioning.
projection <string> Set of properties to return. Defaults to noAcl.
maxResults <integer> Maximum number of items plus prefixes to return in a single page of responses. As duplicate prefixes are omitted, fewer total results may be returned than requested. The service will use this parameter or 1,000 items, whichever is smaller."
  ([bucket] (objects-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn objects-rewrite
  "Rewrites a source object to a destination object. Optionally overrides metadata.
https://cloud.google.com/storage/docs/reference/rest/v1/objects/rewrite

sourceBucket <string> Name of the bucket in which to find the source object.
sourceObject <string> Name of the source object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
destinationBucket <string> Name of the bucket in which to store the new object. Overrides the provided object metadata's bucket value, if any.
destinationObject <string> Name of the new object. Required when the object metadata is not otherwise provided. Overrides the object metadata's name value, if any. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
Object:
{:contentDisposition string,
 :storageClass string,
 :contentEncoding string,
 :generation string,
 :timeCreated string,
 :temporaryHold boolean,
 :eventBasedHold boolean,
 :updated string,
 :name string,
 :retentionExpirationTime string,
 :selfLink string,
 :contentLanguage string,
 :etag string,
 :retention {:retainUntilTime string, :mode string},
 :size string,
 :md5Hash string,
 :cacheControl string,
 :timeStorageClassUpdated string,
 :timeDeleted string,
 :id string,
 :kind string,
 :mediaLink string,
 :kmsKeyName string,
 :softDeleteTime string,
 :customTime string,
 :componentCount integer,
 :acl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
 :contentType string,
 :hardDeleteTime string,
 :metadata object,
 :crc32c string,
 :owner {:entity string, :entityId string},
 :bucket string,
 :metageneration string}

optional:
ifGenerationMatch <string> Makes the operation conditional on whether the object's current generation matches the given value. Setting to 0 makes the operation succeed only if there are no live versions of the object.
maxBytesRewrittenPerCall <string> The maximum number of bytes that will be rewritten per rewrite request. Most callers shouldn't need to specify this parameter - it is primarily in place to support testing. If specified the value must be an integral multiple of 1 MiB (1048576). Also, this only applies to requests where the source and destination span locations and/or storage classes. Finally, this value must not change across rewrite calls else you'll get an error that the rewriteToken is invalid.
ifMetagenerationNotMatch <string> Makes the operation conditional on whether the destination object's current metageneration does not match the given value.
rewriteToken <string> Include this field (from the previous rewrite response) on each rewrite request after the first one, until the rewrite response 'done' flag is true. Calls that provide a rewriteToken can omit all other request fields, but if included those fields must match the values provided in the first rewrite request.
ifGenerationNotMatch <string> Makes the operation conditional on whether the object's current generation does not match the given value. If no live object exists, the precondition fails. Setting to 0 makes the operation succeed only if there is a live version of the object.
ifMetagenerationMatch <string> Makes the operation conditional on whether the destination object's current metageneration matches the given value.
destinationPredefinedAcl <string> Apply a predefined set of access controls to the destination object.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets.
ifSourceMetagenerationNotMatch <string> Makes the operation conditional on whether the source object's current metageneration does not match the given value.
destinationKmsKeyName <string> Resource name of the Cloud KMS key, of the form projects/my-project/locations/global/keyRings/my-kr/cryptoKeys/my-key, that will be used to encrypt the object. Overrides the object metadata's kms_key_name value, if any.
sourceGeneration <string> If present, selects a specific revision of the source object (as opposed to the latest version, the default).
ifSourceGenerationMatch <string> Makes the operation conditional on whether the source object's current generation matches the given value.
projection <string> Set of properties to return. Defaults to noAcl, unless the object resource specifies the acl property, when it defaults to full.
ifSourceGenerationNotMatch <string> Makes the operation conditional on whether the source object's current generation does not match the given value.
ifSourceMetagenerationMatch <string> Makes the operation conditional on whether the source object's current metageneration matches the given value."
  ([sourceBucket
    sourceObject
    destinationBucket
    destinationObject
    Object]
    (objects-rewrite
      sourceBucket
      sourceObject
      destinationBucket
      destinationObject
      Object
      nil))
  ([sourceBucket
    sourceObject
    destinationBucket
    destinationObject
    Object
    optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{sourceBucket}/o/{sourceObject}/rewriteTo/b/{destinationBucket}/o/{destinationObject}",
       :uri-template-args
       {:destinationBucket destinationBucket,
        :sourceBucket sourceBucket,
        :destinationObject destinationObject,
        :sourceObject sourceObject},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Object})))

(defn objectAccessControls-delete
  "Permanently deletes the ACL entry for the specified entity on the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objectAccessControls/delete

bucket <string> Name of a bucket.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object entity]
    (objectAccessControls-delete bucket object entity nil))
  ([bucket object entity optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/acl/{entity}",
       :uri-template-args
       {:bucket bucket, :entity entity, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn objectAccessControls-get
  "Returns the ACL entry for the specified entity on the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objectAccessControls/get

bucket <string> Name of a bucket.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object entity]
    (objectAccessControls-get bucket object entity nil))
  ([bucket object entity optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/acl/{entity}",
       :uri-template-args
       {:bucket bucket, :entity entity, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn objectAccessControls-insert
  "Creates a new ACL entry on the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objectAccessControls/insert

bucket <string> Name of a bucket.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
ObjectAccessControl:
{:role string,
 :email string,
 :generation string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :object string,
 :bucket string}

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object ObjectAccessControl]
    (objectAccessControls-insert
      bucket
      object
      ObjectAccessControl
      nil))
  ([bucket object ObjectAccessControl optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/acl",
       :uri-template-args {:bucket bucket, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body ObjectAccessControl})))

(defn objectAccessControls-list
  "Retrieves ACL entries on the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objectAccessControls/list

bucket <string> Name of a bucket.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object] (objectAccessControls-list bucket object nil))
  ([bucket object optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/acl",
       :uri-template-args {:bucket bucket, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn objectAccessControls-patch
  "Patches an ACL entry on the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objectAccessControls/patch

bucket <string> Name of a bucket.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.
ObjectAccessControl:
{:role string,
 :email string,
 :generation string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :object string,
 :bucket string}

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object entity ObjectAccessControl]
    (objectAccessControls-patch
      bucket
      object
      entity
      ObjectAccessControl
      nil))
  ([bucket object entity ObjectAccessControl optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/acl/{entity}",
       :uri-template-args
       {:bucket bucket, :entity entity, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body ObjectAccessControl})))

(defn objectAccessControls-update
  "Updates an ACL entry on the specified object.
https://cloud.google.com/storage/docs/reference/rest/v1/objectAccessControls/update

bucket <string> Name of a bucket.
object <string> Name of the object. For information about how to URL encode object names to be path safe, see [Encoding URI Path Parts](https://cloud.google.com/storage/docs/request-endpoints#encoding).
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.
ObjectAccessControl:
{:role string,
 :email string,
 :generation string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :object string,
 :bucket string}

optional:
generation <string> If present, selects a specific revision of this object (as opposed to the latest version, the default).
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket object entity ObjectAccessControl]
    (objectAccessControls-update
      bucket
      object
      entity
      ObjectAccessControl
      nil))
  ([bucket object entity ObjectAccessControl optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/o/{object}/acl/{entity}",
       :uri-template-args
       {:bucket bucket, :entity entity, :object object},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body ObjectAccessControl})))

(defn notifications-delete
  "Permanently deletes a notification subscription.
https://cloud.google.com/storage/docs/reference/rest/v1/notifications/delete

bucket <string> The parent bucket of the notification.
notification <string> ID of the notification to delete.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket notification]
    (notifications-delete bucket notification nil))
  ([bucket notification optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/notificationConfigs/{notification}",
       :uri-template-args {:bucket bucket, :notification notification},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn notifications-get
  "View a notification configuration.
https://cloud.google.com/storage/docs/reference/rest/v1/notifications/get

bucket <string> The parent bucket of the notification.
notification <string> Notification ID

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket notification] (notifications-get bucket notification nil))
  ([bucket notification optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/notificationConfigs/{notification}",
       :uri-template-args {:bucket bucket, :notification notification},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn notifications-insert
  "Creates a notification subscription for a given bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/notifications/insert

bucket <string> The parent bucket of the notification.
Notification:
{:payload_format string,
 :selfLink string,
 :etag string,
 :topic string,
 :event_types [string],
 :id string,
 :kind string,
 :custom_attributes object,
 :object_name_prefix string}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket Notification]
    (notifications-insert bucket Notification nil))
  ([bucket Notification optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/notificationConfigs",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Notification})))

(defn notifications-list
  "Retrieves a list of notification subscriptions for a given bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/notifications/list

bucket <string> Name of a Google Cloud Storage bucket.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket] (notifications-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/notificationConfigs",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn bucketAccessControls-delete
  "Permanently deletes the ACL entry for the specified entity on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/bucketAccessControls/delete

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity] (bucketAccessControls-delete bucket entity nil))
  ([bucket entity optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/acl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn bucketAccessControls-get
  "Returns the ACL entry for the specified entity on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/bucketAccessControls/get

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity] (bucketAccessControls-get bucket entity nil))
  ([bucket entity optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/acl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn bucketAccessControls-insert
  "Creates a new ACL entry on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/bucketAccessControls/insert

bucket <string> Name of a bucket.
BucketAccessControl:
{:role string,
 :email string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :bucket string}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket BucketAccessControl]
    (bucketAccessControls-insert bucket BucketAccessControl nil))
  ([bucket BucketAccessControl optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/acl",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body BucketAccessControl})))

(defn bucketAccessControls-list
  "Retrieves ACL entries on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/bucketAccessControls/list

bucket <string> Name of a bucket.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket] (bucketAccessControls-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/acl",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn bucketAccessControls-patch
  "Patches an ACL entry on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/bucketAccessControls/patch

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.
BucketAccessControl:
{:role string,
 :email string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :bucket string}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity BucketAccessControl]
    (bucketAccessControls-patch bucket entity BucketAccessControl nil))
  ([bucket entity BucketAccessControl optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/acl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body BucketAccessControl})))

(defn bucketAccessControls-update
  "Updates an ACL entry on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/bucketAccessControls/update

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.
BucketAccessControl:
{:role string,
 :email string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :bucket string}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity BucketAccessControl]
    (bucketAccessControls-update
      bucket
      entity
      BucketAccessControl
      nil))
  ([bucket entity BucketAccessControl optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/acl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body BucketAccessControl})))

(defn buckets-get
  "Returns metadata for the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/get

bucket <string> Name of a bucket.

optional:
ifMetagenerationMatch <string> Makes the return of the bucket metadata conditional on whether the bucket's current metageneration matches the given value.
ifMetagenerationNotMatch <string> Makes the return of the bucket metadata conditional on whether the bucket's current metageneration does not match the given value.
projection <string> Set of properties to return. Defaults to noAcl.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket] (buckets-get bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn buckets-setIamPolicy
  "Updates an IAM policy for the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/setIamPolicy

bucket <string> Name of a bucket.
Policy:
{:bindings
 [{:condition
   {:description string,
    :expression string,
    :location string,
    :title string},
   :members [string],
   :role string}],
 :etag string,
 :kind string,
 :resourceId string,
 :version integer}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket Policy] (buckets-setIamPolicy bucket Policy nil))
  ([bucket Policy optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/iam",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body Policy})))

(defn buckets-insert
  "Creates a new bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/insert

project <string> A valid API project identifier.
Bucket:
{:cors
 [{:maxAgeSeconds integer,
   :method [string],
   :origin [string],
   :responseHeader [string]}],
 :labels object,
 :rpo string,
 :customPlacementConfig {:dataLocations [string]},
 :storageClass string,
 :timeCreated string,
 :autoclass
 {:enabled boolean,
  :toggleTime string,
  :terminalStorageClass string,
  :terminalStorageClassUpdateTime string},
 :updated string,
 :name string,
 :billing {:requesterPays boolean},
 :hierarchicalNamespace {:enabled boolean},
 :selfLink string,
 :etag string,
 :objectRetention {:mode string},
 :lifecycle
 {:rule
  [{:action {:storageClass string, :type string},
    :condition
    {:customTimeBefore string,
     :age integer,
     :createdBefore string,
     :daysSinceNoncurrentTime integer,
     :matchesSuffix [string],
     :numNewerVersions integer,
     :matchesStorageClass [string],
     :matchesPattern string,
     :matchesPrefix [string],
     :noncurrentTimeBefore string,
     :isLive boolean,
     :daysSinceCustomTime integer}}]},
 :logging {:logBucket string, :logObjectPrefix string},
 :projectNumber string,
 :encryption {:defaultKmsKeyName string},
 :defaultObjectAcl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :satisfiesPZS boolean,
 :id string,
 :kind string,
 :retentionPolicy
 {:effectiveTime string, :isLocked boolean, :retentionPeriod string},
 :website {:mainPageSuffix string, :notFoundPage string},
 :acl
 [{:role string,
   :email string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :bucket string}],
 :locationType string,
 :softDeletePolicy
 {:retentionDurationSeconds string, :effectiveTime string},
 :iamConfiguration
 {:bucketPolicyOnly {:enabled boolean, :lockedTime string},
  :uniformBucketLevelAccess {:enabled boolean, :lockedTime string},
  :publicAccessPrevention string},
 :defaultEventBasedHold boolean,
 :versioning {:enabled boolean},
 :location string,
 :owner {:entity string, :entityId string},
 :metageneration string}

optional:
predefinedAcl <string> Apply a predefined set of access controls to this bucket.
predefinedDefaultObjectAcl <string> Apply a predefined set of default object access controls to this bucket.
projection <string> Set of properties to return. Defaults to noAcl, unless the bucket resource specifies acl or defaultObjectAcl properties, when it defaults to full.
userProject <string> The project to be billed for this request.
enableObjectRetention <boolean> When set to true, object retention is enabled for this bucket."
  ([project Bucket] (buckets-insert project Bucket nil))
  ([project Bucket optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://storage.googleapis.com/storage/v1/b",
       :uri-template-args {},
       :query-params (merge {:project project} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"],
       :body Bucket})))

(defn buckets-patch
  "Patches a bucket. Changes to the bucket will be readable immediately after writing, but configuration changes may take time to propagate.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/patch

bucket <string> Name of a bucket.
Bucket:
{:cors
 [{:maxAgeSeconds integer,
   :method [string],
   :origin [string],
   :responseHeader [string]}],
 :labels object,
 :rpo string,
 :customPlacementConfig {:dataLocations [string]},
 :storageClass string,
 :timeCreated string,
 :autoclass
 {:enabled boolean,
  :toggleTime string,
  :terminalStorageClass string,
  :terminalStorageClassUpdateTime string},
 :updated string,
 :name string,
 :billing {:requesterPays boolean},
 :hierarchicalNamespace {:enabled boolean},
 :selfLink string,
 :etag string,
 :objectRetention {:mode string},
 :lifecycle
 {:rule
  [{:action {:storageClass string, :type string},
    :condition
    {:customTimeBefore string,
     :age integer,
     :createdBefore string,
     :daysSinceNoncurrentTime integer,
     :matchesSuffix [string],
     :numNewerVersions integer,
     :matchesStorageClass [string],
     :matchesPattern string,
     :matchesPrefix [string],
     :noncurrentTimeBefore string,
     :isLive boolean,
     :daysSinceCustomTime integer}}]},
 :logging {:logBucket string, :logObjectPrefix string},
 :projectNumber string,
 :encryption {:defaultKmsKeyName string},
 :defaultObjectAcl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :satisfiesPZS boolean,
 :id string,
 :kind string,
 :retentionPolicy
 {:effectiveTime string, :isLocked boolean, :retentionPeriod string},
 :website {:mainPageSuffix string, :notFoundPage string},
 :acl
 [{:role string,
   :email string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :bucket string}],
 :locationType string,
 :softDeletePolicy
 {:retentionDurationSeconds string, :effectiveTime string},
 :iamConfiguration
 {:bucketPolicyOnly {:enabled boolean, :lockedTime string},
  :uniformBucketLevelAccess {:enabled boolean, :lockedTime string},
  :publicAccessPrevention string},
 :defaultEventBasedHold boolean,
 :versioning {:enabled boolean},
 :location string,
 :owner {:entity string, :entityId string},
 :metageneration string}

optional:
ifMetagenerationMatch <string> Makes the return of the bucket metadata conditional on whether the bucket's current metageneration matches the given value.
ifMetagenerationNotMatch <string> Makes the return of the bucket metadata conditional on whether the bucket's current metageneration does not match the given value.
predefinedAcl <string> Apply a predefined set of access controls to this bucket.
predefinedDefaultObjectAcl <string> Apply a predefined set of default object access controls to this bucket.
projection <string> Set of properties to return. Defaults to full.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket Bucket] (buckets-patch bucket Bucket nil))
  ([bucket Bucket optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body Bucket})))

(defn buckets-testIamPermissions
  "Tests a set of permissions on the given bucket to see which, if any, are held by the caller.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/testIamPermissions

bucket <string> Name of a bucket.
permissions <string> Permissions to test.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket permissions]
    (buckets-testIamPermissions bucket permissions nil))
  ([bucket permissions optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/iam/testPermissions",
       :uri-template-args {:bucket bucket},
       :query-params (merge {:permissions permissions} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn buckets-update
  "Updates a bucket. Changes to the bucket will be readable immediately after writing, but configuration changes may take time to propagate.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/update

bucket <string> Name of a bucket.
Bucket:
{:cors
 [{:maxAgeSeconds integer,
   :method [string],
   :origin [string],
   :responseHeader [string]}],
 :labels object,
 :rpo string,
 :customPlacementConfig {:dataLocations [string]},
 :storageClass string,
 :timeCreated string,
 :autoclass
 {:enabled boolean,
  :toggleTime string,
  :terminalStorageClass string,
  :terminalStorageClassUpdateTime string},
 :updated string,
 :name string,
 :billing {:requesterPays boolean},
 :hierarchicalNamespace {:enabled boolean},
 :selfLink string,
 :etag string,
 :objectRetention {:mode string},
 :lifecycle
 {:rule
  [{:action {:storageClass string, :type string},
    :condition
    {:customTimeBefore string,
     :age integer,
     :createdBefore string,
     :daysSinceNoncurrentTime integer,
     :matchesSuffix [string],
     :numNewerVersions integer,
     :matchesStorageClass [string],
     :matchesPattern string,
     :matchesPrefix [string],
     :noncurrentTimeBefore string,
     :isLive boolean,
     :daysSinceCustomTime integer}}]},
 :logging {:logBucket string, :logObjectPrefix string},
 :projectNumber string,
 :encryption {:defaultKmsKeyName string},
 :defaultObjectAcl
 [{:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}],
 :satisfiesPZS boolean,
 :id string,
 :kind string,
 :retentionPolicy
 {:effectiveTime string, :isLocked boolean, :retentionPeriod string},
 :website {:mainPageSuffix string, :notFoundPage string},
 :acl
 [{:role string,
   :email string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :bucket string}],
 :locationType string,
 :softDeletePolicy
 {:retentionDurationSeconds string, :effectiveTime string},
 :iamConfiguration
 {:bucketPolicyOnly {:enabled boolean, :lockedTime string},
  :uniformBucketLevelAccess {:enabled boolean, :lockedTime string},
  :publicAccessPrevention string},
 :defaultEventBasedHold boolean,
 :versioning {:enabled boolean},
 :location string,
 :owner {:entity string, :entityId string},
 :metageneration string}

optional:
ifMetagenerationMatch <string> Makes the return of the bucket metadata conditional on whether the bucket's current metageneration matches the given value.
ifMetagenerationNotMatch <string> Makes the return of the bucket metadata conditional on whether the bucket's current metageneration does not match the given value.
predefinedAcl <string> Apply a predefined set of access controls to this bucket.
predefinedDefaultObjectAcl <string> Apply a predefined set of default object access controls to this bucket.
projection <string> Set of properties to return. Defaults to full.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket Bucket] (buckets-update bucket Bucket nil))
  ([bucket Bucket optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body Bucket})))

(defn buckets-delete
  "Permanently deletes an empty bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/delete

bucket <string> Name of a bucket.

optional:
ifMetagenerationMatch <string> If set, only deletes the bucket if its metageneration matches this value.
ifMetagenerationNotMatch <string> If set, only deletes the bucket if its metageneration does not match this value.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket] (buckets-delete bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn buckets-getIamPolicy
  "Returns an IAM policy for the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/getIamPolicy

bucket <string> Name of a bucket.

optional:
optionsRequestedPolicyVersion <integer> The IAM policy format version to be returned. If the optionsRequestedPolicyVersion is for an older version that doesn't support part of the requested IAM policy, the request fails.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket] (buckets-getIamPolicy bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/iam",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn buckets-getStorageLayout
  "Returns the storage layout configuration for the specified bucket. Note that this operation requires storage.objects.list permission.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/getStorageLayout

bucket <string> Name of a bucket.

optional:
prefix <string> An optional prefix used for permission check. It is useful when the caller only has storage.objects.list permission under a specific prefix."
  ([bucket] (buckets-getStorageLayout bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/storageLayout",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn buckets-list
  "Retrieves a list of buckets for a given project.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/list

project <string> A valid API project identifier.

optional:
maxResults <integer> Maximum number of buckets to return in a single response. The service will use this parameter or 1,000 items, whichever is smaller.
prefix <string> Filter results to buckets whose names begin with this prefix.
projection <string> Set of properties to return. Defaults to noAcl.
userProject <string> The project to be billed for this request."
  ([project] (buckets-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://storage.googleapis.com/storage/v1/b",
       :uri-template-args {},
       :query-params (merge {:project project} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn buckets-lockRetentionPolicy
  "Locks retention policy on a bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets/lockRetentionPolicy

bucket <string> Name of a bucket.
ifMetagenerationMatch <string> Makes the operation conditional on whether bucket's current metageneration matches the given value.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket ifMetagenerationMatch]
    (buckets-lockRetentionPolicy bucket ifMetagenerationMatch nil))
  ([bucket ifMetagenerationMatch optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/lockRetentionPolicy",
       :uri-template-args {:bucket bucket},
       :query-params
       (merge {:ifMetagenerationMatch ifMetagenerationMatch} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn managedFolders-delete
  "Permanently deletes a managed folder.
https://cloud.google.com/storage/docs/reference/rest/v1/managedFolders/delete

bucket <string> Name of the bucket containing the managed folder.
managedFolder <string> The managed folder name/path.

optional:
ifMetagenerationMatch <string> If set, only deletes the managed folder if its metageneration matches this value.
ifMetagenerationNotMatch <string> If set, only deletes the managed folder if its metageneration does not match this value.
allowNonEmpty <boolean> Allows the deletion of a managed folder even if it is not empty. A managed folder is empty if there are no objects or managed folders that it applies to. Callers must have storage.managedFolders.setIamPolicy permission."
  ([bucket managedFolder]
    (managedFolders-delete bucket managedFolder nil))
  ([bucket managedFolder optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/managedFolders/{managedFolder}",
       :uri-template-args
       {:bucket bucket, :managedFolder managedFolder},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn managedFolders-get
  "Returns metadata of the specified managed folder.
https://cloud.google.com/storage/docs/reference/rest/v1/managedFolders/get

bucket <string> Name of the bucket containing the managed folder.
managedFolder <string> The managed folder name/path.

optional:
ifMetagenerationMatch <string> Makes the return of the managed folder metadata conditional on whether the managed folder's current metageneration matches the given value.
ifMetagenerationNotMatch <string> Makes the return of the managed folder metadata conditional on whether the managed folder's current metageneration does not match the given value."
  ([bucket managedFolder]
    (managedFolders-get bucket managedFolder nil))
  ([bucket managedFolder optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/managedFolders/{managedFolder}",
       :uri-template-args
       {:bucket bucket, :managedFolder managedFolder},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn managedFolders-getIamPolicy
  "Returns an IAM policy for the specified managed folder.
https://cloud.google.com/storage/docs/reference/rest/v1/managedFolders/getIamPolicy

bucket <string> Name of the bucket containing the managed folder.
managedFolder <string> The managed folder name/path.

optional:
optionsRequestedPolicyVersion <integer> The IAM policy format version to be returned. If the optionsRequestedPolicyVersion is for an older version that doesn't support part of the requested IAM policy, the request fails.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket managedFolder]
    (managedFolders-getIamPolicy bucket managedFolder nil))
  ([bucket managedFolder optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/managedFolders/{managedFolder}/iam",
       :uri-template-args
       {:bucket bucket, :managedFolder managedFolder},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn managedFolders-insert
  "Creates a new managed folder.
https://cloud.google.com/storage/docs/reference/rest/v1/managedFolders/insert

bucket <string> Name of the bucket containing the managed folder.
ManagedFolder:
{:bucket string,
 :id string,
 :kind string,
 :metageneration string,
 :name string,
 :selfLink string,
 :createTime string,
 :updateTime string}"
  [bucket ManagedFolder]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/managedFolders",
     :uri-template-args {:bucket bucket},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"],
     :body ManagedFolder}))

(defn managedFolders-list
  "Lists managed folders in the given bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/managedFolders/list

bucket <string> Name of the bucket containing the managed folder.

optional:
pageSize <integer> Maximum number of items to return in a single page of responses.
prefix <string> The managed folder name/path prefix to filter the output list of results."
  ([bucket] (managedFolders-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/managedFolders",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn managedFolders-setIamPolicy
  "Updates an IAM policy for the specified managed folder.
https://cloud.google.com/storage/docs/reference/rest/v1/managedFolders/setIamPolicy

bucket <string> Name of the bucket containing the managed folder.
managedFolder <string> The managed folder name/path.
Policy:
{:bindings
 [{:condition
   {:description string,
    :expression string,
    :location string,
    :title string},
   :members [string],
   :role string}],
 :etag string,
 :kind string,
 :resourceId string,
 :version integer}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket managedFolder Policy]
    (managedFolders-setIamPolicy bucket managedFolder Policy nil))
  ([bucket managedFolder Policy optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/managedFolders/{managedFolder}/iam",
       :uri-template-args
       {:bucket bucket, :managedFolder managedFolder},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body Policy})))

(defn managedFolders-testIamPermissions
  "Tests a set of permissions on the given managed folder to see which, if any, are held by the caller.
https://cloud.google.com/storage/docs/reference/rest/v1/managedFolders/testIamPermissions

bucket <string> Name of the bucket containing the managed folder.
managedFolder <string> The managed folder name/path.
permissions <string> Permissions to test.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket managedFolder permissions]
    (managedFolders-testIamPermissions
      bucket
      managedFolder
      permissions
      nil))
  ([bucket managedFolder permissions optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/managedFolders/{managedFolder}/iam/testPermissions",
       :uri-template-args
       {:bucket bucket, :managedFolder managedFolder},
       :query-params (merge {:permissions permissions} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn buckets-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets.operations/cancel

bucket <string> The parent bucket of the operation resource.
operationId <string> The ID of the operation resource."
  [bucket operationId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/operations/{operationId}/cancel",
     :uri-template-args {:bucket bucket, :operationId operationId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"]}))

(defn buckets-operations-get
  "Gets the latest state of a long-running operation.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets.operations/get

bucket <string> The parent bucket of the operation resource.
operationId <string> The ID of the operation resource."
  [bucket operationId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/operations/{operationId}",
     :uri-template-args {:bucket bucket, :operationId operationId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_only"
      "https://www.googleapis.com/auth/devstorage.read_write"]}))

(defn buckets-operations-list
  "Lists operations that match the specified filter in the request.
https://cloud.google.com/storage/docs/reference/rest/v1/buckets.operations/list

bucket <string> Name of the bucket in which to look for operations.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> Maximum number of items to return in a single page of responses. Fewer total results may be returned than requested. The service uses this parameter or 100 items, whichever is smaller."
  ([bucket] (buckets-operations-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/operations",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn anywhereCaches-insert
  "Creates an Anywhere Cache instance.
https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/insert

bucket <string> Name of the parent bucket.
AnywhereCache:
{:zone string,
 :createTime string,
 :selfLink string,
 :anywhereCacheId string,
 :state string,
 :updateTime string,
 :ttl string,
 :id string,
 :kind string,
 :pendingUpdate boolean,
 :admissionPolicy string,
 :bucket string}"
  [bucket AnywhereCache]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/anywhereCaches",
     :uri-template-args {:bucket bucket},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"],
     :body AnywhereCache}))

(defn anywhereCaches-update
  "Updates the config(ttl and admissionPolicy) of an Anywhere Cache instance.
https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/update

bucket <string> Name of the parent bucket.
anywhereCacheId <string> The ID of requested Anywhere Cache instance.
AnywhereCache:
{:zone string,
 :createTime string,
 :selfLink string,
 :anywhereCacheId string,
 :state string,
 :updateTime string,
 :ttl string,
 :id string,
 :kind string,
 :pendingUpdate boolean,
 :admissionPolicy string,
 :bucket string}"
  [bucket anywhereCacheId AnywhereCache]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/anywhereCaches/{anywhereCacheId}",
     :uri-template-args
     {:bucket bucket, :anywhereCacheId anywhereCacheId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"],
     :body AnywhereCache}))

(defn anywhereCaches-get
  "Returns the metadata of an Anywhere Cache instance.
https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/get

bucket <string> Name of the parent bucket.
anywhereCacheId <string> The ID of requested Anywhere Cache instance."
  [bucket anywhereCacheId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/anywhereCaches/{anywhereCacheId}",
     :uri-template-args
     {:bucket bucket, :anywhereCacheId anywhereCacheId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_only"
      "https://www.googleapis.com/auth/devstorage.read_write"]}))

(defn anywhereCaches-list
  "Returns a list of Anywhere Cache instances of the bucket matching the criteria.
https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/list

bucket <string> Name of the parent bucket.

optional:
pageSize <integer> Maximum number of items to return in a single page of responses. Maximum 1000."
  ([bucket] (anywhereCaches-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/anywhereCaches",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/devstorage.full_control"
        "https://www.googleapis.com/auth/devstorage.read_only"
        "https://www.googleapis.com/auth/devstorage.read_write"]})))

(defn anywhereCaches-pause
  "Pauses an Anywhere Cache instance.
https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/pause

bucket <string> Name of the parent bucket.
anywhereCacheId <string> The ID of requested Anywhere Cache instance."
  [bucket anywhereCacheId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/anywhereCaches/{anywhereCacheId}/pause",
     :uri-template-args
     {:bucket bucket, :anywhereCacheId anywhereCacheId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"]}))

(defn anywhereCaches-resume
  "Resumes a paused or disabled Anywhere Cache instance.
https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/resume

bucket <string> Name of the parent bucket.
anywhereCacheId <string> The ID of requested Anywhere Cache instance."
  [bucket anywhereCacheId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/anywhereCaches/{anywhereCacheId}/resume",
     :uri-template-args
     {:bucket bucket, :anywhereCacheId anywhereCacheId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"]}))

(defn anywhereCaches-disable
  "Disables an Anywhere Cache instance.
https://cloud.google.com/storage/docs/reference/rest/v1/anywhereCaches/disable

bucket <string> Name of the parent bucket.
anywhereCacheId <string> The ID of requested Anywhere Cache instance."
  [bucket anywhereCacheId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://storage.googleapis.com/storage/v1/b/{bucket}/anywhereCaches/{anywhereCacheId}/disable",
     :uri-template-args
     {:bucket bucket, :anywhereCacheId anywhereCacheId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/devstorage.full_control"
      "https://www.googleapis.com/auth/devstorage.read_write"]}))

(defn defaultObjectAccessControls-delete
  "Permanently deletes the default object ACL entry for the specified entity on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/defaultObjectAccessControls/delete

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity]
    (defaultObjectAccessControls-delete bucket entity nil))
  ([bucket entity optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/defaultObjectAcl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn defaultObjectAccessControls-get
  "Returns the default object ACL entry for the specified entity on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/defaultObjectAccessControls/get

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity] (defaultObjectAccessControls-get bucket entity nil))
  ([bucket entity optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/defaultObjectAcl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn defaultObjectAccessControls-insert
  "Creates a new default object ACL entry on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/defaultObjectAccessControls/insert

bucket <string> Name of a bucket.
ObjectAccessControl:
{:role string,
 :email string,
 :generation string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :object string,
 :bucket string}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket ObjectAccessControl]
    (defaultObjectAccessControls-insert
      bucket
      ObjectAccessControl
      nil))
  ([bucket ObjectAccessControl optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/defaultObjectAcl",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body ObjectAccessControl})))

(defn defaultObjectAccessControls-list
  "Retrieves default object ACL entries on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/defaultObjectAccessControls/list

bucket <string> Name of a bucket.

optional:
ifMetagenerationMatch <string> If present, only return default ACL listing if the bucket's current metageneration matches this value.
ifMetagenerationNotMatch <string> If present, only return default ACL listing if the bucket's current metageneration does not match the given value.
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket] (defaultObjectAccessControls-list bucket nil))
  ([bucket optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/defaultObjectAcl",
       :uri-template-args {:bucket bucket},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"]})))

(defn defaultObjectAccessControls-patch
  "Patches a default object ACL entry on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/defaultObjectAccessControls/patch

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.
ObjectAccessControl:
{:role string,
 :email string,
 :generation string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :object string,
 :bucket string}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity ObjectAccessControl]
    (defaultObjectAccessControls-patch
      bucket
      entity
      ObjectAccessControl
      nil))
  ([bucket entity ObjectAccessControl optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/defaultObjectAcl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body ObjectAccessControl})))

(defn defaultObjectAccessControls-update
  "Updates a default object ACL entry on the specified bucket.
https://cloud.google.com/storage/docs/reference/rest/v1/defaultObjectAccessControls/update

bucket <string> Name of a bucket.
entity <string> The entity holding the permission. Can be user-userId, user-emailAddress, group-groupId, group-emailAddress, allUsers, or allAuthenticatedUsers.
ObjectAccessControl:
{:role string,
 :email string,
 :generation string,
 :projectTeam {:projectNumber string, :team string},
 :selfLink string,
 :etag string,
 :id string,
 :kind string,
 :domain string,
 :entity string,
 :entityId string,
 :object string,
 :bucket string}

optional:
userProject <string> The project to be billed for this request. Required for Requester Pays buckets."
  ([bucket entity ObjectAccessControl]
    (defaultObjectAccessControls-update
      bucket
      entity
      ObjectAccessControl
      nil))
  ([bucket entity ObjectAccessControl optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://storage.googleapis.com/storage/v1/b/{bucket}/defaultObjectAcl/{entity}",
       :uri-template-args {:bucket bucket, :entity entity},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/devstorage.full_control"],
       :body ObjectAccessControl})))

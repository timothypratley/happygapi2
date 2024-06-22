(ns happygapi2.firebasestorage
  "Cloud Storage for Firebase API
The Cloud Storage for Firebase API enables programmatic management of Cloud Storage buckets for use in Firebase projects
See: https://firebase.google.com/docs/storage"
  (:require [happy.oauth2.client :as client]))

(defn projects-buckets-get
  "Gets a single linked storage bucket.
https://firebase.google.com/docs/storage

name <string> Required. Resource name of the bucket, mirrors the ID of the underlying Google Cloud Storage bucket, `projects/{project_id_or_number}/buckets/{bucket_id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebasestorage.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-buckets-list
  "Lists the linked storage buckets for a project.
https://firebase.google.com/docs/storage

parent <string> Required. Resource name of the parent Firebase project, `projects/{project_id_or_number}`.

optional:
pageSize <integer> The maximum number of buckets to return. If not set, the server will use a reasonable default."
  ([parent] (projects-buckets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebasestorage.googleapis.com/v1beta/{+parent}/buckets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"]})))

(defn projects-buckets-addFirebase
  "Links a Google Cloud Storage bucket to a Firebase project.
https://firebase.google.com/docs/storage

bucket <string> Required. Resource name of the bucket, mirrors the ID of the underlying Google Cloud Storage bucket, `projects/{project_id_or_number}/buckets/{bucket_id}`.
AddFirebaseRequest:
object"
  [bucket AddFirebaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasestorage.googleapis.com/v1beta/{+bucket}:addFirebase",
     :uri-template-args {:bucket bucket},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body AddFirebaseRequest}))

(defn projects-buckets-removeFirebase
  "Unlinks a linked Google Cloud Storage bucket from a Firebase project.
https://firebase.google.com/docs/storage

bucket <string> Required. Resource name of the bucket, mirrors the ID of the underlying Google Cloud Storage bucket, `projects/{project_id_or_number}/buckets/{bucket_id}`.
RemoveFirebaseRequest:
object"
  [bucket RemoveFirebaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasestorage.googleapis.com/v1beta/{+bucket}:removeFirebase",
     :uri-template-args {:bucket bucket},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body RemoveFirebaseRequest}))

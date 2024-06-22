(ns happygapi2.firebaseml
  "Firebase ML API
Access custom machine learning models hosted via Firebase ML.
See: https://firebase.google.com"
  (:require [happy.oauth2.client :as client]))

(defn operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://firebase.google.com

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://firebaseml.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://firebase.google.com

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://firebaseml.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://firebase.google.com

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebaseml.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

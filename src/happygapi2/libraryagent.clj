(ns happygapi2.libraryagent
  "Library Agent API
A simple Google Example Library API.
See: https://cloud.google.com/docs/quotas"
  (:require [happy.oauth2.client :as client]))

(defn shelves-list
  "Lists shelves. The order is unspecified but deterministic. Newly created shelves will not necessarily be added to the end of this list.
https://cloud.google.com/docs/quotas

optional:
pageSize <integer> Requested page size. Server may return fewer shelves than requested. If unspecified, server will pick an appropriate default."
  ([] (shelves-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://libraryagent.googleapis.com/v1/shelves",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn shelves-get
  "Gets a shelf. Returns NOT_FOUND if the shelf does not exist.
https://cloud.google.com/docs/quotas

name <string> Required. The name of the shelf to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://libraryagent.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn shelves-books-get
  "Gets a book. Returns NOT_FOUND if the book does not exist.
https://cloud.google.com/docs/quotas

name <string> Required. The name of the book to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://libraryagent.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn shelves-books-borrow
  "Borrow a book from the library. Returns the book if it is borrowed successfully. Returns NOT_FOUND if the book does not exist in the library. Returns quota exceeded error if the amount of books borrowed exceeds allocation quota in any dimensions.
https://cloud.google.com/docs/quotas

name <string> Required. The name of the book to borrow."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://libraryagent.googleapis.com/v1/{+name}:borrow",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn shelves-books-list
  "Lists books in a shelf. The order is unspecified but deterministic. Newly created books will not necessarily be added to the end of this list. Returns NOT_FOUND if the shelf does not exist.
https://cloud.google.com/docs/quotas

parent <string> Required. The name of the shelf whose books we'd like to list.

optional:
pageSize <integer> Requested page size. Server may return fewer books than requested. If unspecified, server will pick an appropriate default."
  ([parent] (shelves-books-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://libraryagent.googleapis.com/v1/{+parent}/books",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn shelves-books-return
  "Return a book to the library. Returns the book if it is returned to the library successfully. Returns error if the book does not belong to the library or the users didn't borrow before.
https://cloud.google.com/docs/quotas

name <string> Required. The name of the book to return."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://libraryagent.googleapis.com/v1/{+name}:return",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

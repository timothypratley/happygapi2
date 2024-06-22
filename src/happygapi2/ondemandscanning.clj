(ns happygapi2.ondemandscanning
  "On-Demand Scanning API
A service to scan container images for vulnerabilities.
See: https://cloud.google.com/artifact-analysis/docs/container-scanning-overview"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/artifact-analysis/docs/container-scanning-overview

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://ondemandscanning.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/artifact-analysis/docs/container-scanning-overview

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://ondemandscanning.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/artifact-analysis/docs/container-scanning-overview

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://ondemandscanning.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/artifact-analysis/docs/container-scanning-overview

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://ondemandscanning.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/artifact-analysis/docs/container-scanning-overview

name <string> The name of the operation resource to wait on.

optional:
timeout <string> The maximum duration to wait before timing out. If left blank, the wait will be at most the time permitted by the underlying HTTP/RPC protocol. If RPC context deadline is also specified, the shorter one will be used."
  ([name] (projects-locations-operations-wait name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://ondemandscanning.googleapis.com/v1/{+name}:wait",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-scans-analyzePackages
  "Initiates an analysis of the provided packages.
https://cloud.google.com/artifact-analysis/docs/container-scanning-overview

parent <string> Required. The parent of the resource for which analysis is requested. Format: projects/[project_name]/locations/[location]
AnalyzePackagesRequestV1:
{:resourceUri string,
 :packages
 [{:maintainer
   {:name string, :kind string, :email string, :url string},
   :package string,
   :architecture string,
   :fileLocation [{:filePath string}],
   :licenses [string],
   :unused string,
   :packageType
   [PACKAGE_TYPE_UNSPECIFIED
    OS
    MAVEN
    GO
    GO_STDLIB
    PYPI
    NPM
    NUGET
    RUBYGEMS
    RUST
    COMPOSER],
   :cpeUri string,
   :sourceVersion {:name string, :version string, :licenses [string]},
   :osVersion string,
   :dependencyChain [{:package string, :version string}],
   :binaryVersion {:name string, :version string, :licenses [string]},
   :os string,
   :hashDigest string,
   :version string,
   :patchedCve [string],
   :binarySourceInfo
   [{:binaryVersion
     {:name string, :version string, :licenses [string]},
     :sourceVersion
     {:name string, :version string, :licenses [string]}}]}],
 :includeOsvData boolean}"
  [parent AnalyzePackagesRequestV1]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://ondemandscanning.googleapis.com/v1/{+parent}/scans:analyzePackages",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AnalyzePackagesRequestV1}))

(defn projects-locations-scans-vulnerabilities-list
  "Lists vulnerabilities resulting from a successfully completed scan.
https://cloud.google.com/artifact-analysis/docs/container-scanning-overview

parent <string> Required. The parent of the collection of Vulnerabilities being requested. Format: projects/[project_name]/locations/[location]/scans/[scan_id]

optional:
pageSize <integer> The number of vulnerabilities to retrieve."
  ([parent] (projects-locations-scans-vulnerabilities-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://ondemandscanning.googleapis.com/v1/{+parent}/vulnerabilities",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

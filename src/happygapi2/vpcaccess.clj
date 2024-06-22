(ns happygapi2.vpcaccess
  "Serverless VPC Access API
API for managing VPC access connectors.
See: https://cloud.google.com/vpc/docs/configure-serverless-vpc-access"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vpcaccess.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vpcaccess.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vpcaccess.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connectors-create
  "Creates a Serverless VPC Access connector, returns an operation.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

parent <string> Required. The project ID and location in which the configuration should be created, specified in the format `projects/*/locations/*`.
Connector:
{:name string,
 :ipCidrRange string,
 :minInstances integer,
 :state [STATE_UNSPECIFIED READY CREATING DELETING ERROR UPDATING],
 :machineType string,
 :minThroughput integer,
 :network string,
 :maxInstances integer,
 :maxThroughput integer,
 :subnet {:name string, :projectId string},
 :connectedProjects [string]}

optional:
connectorId <string> Required. The ID to use for this connector."
  ([parent Connector]
    (projects-locations-connectors-create parent Connector nil))
  ([parent Connector optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://vpcaccess.googleapis.com/v1/{+parent}/connectors",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Connector})))

(defn projects-locations-connectors-patch
  "Updates a Serverless VPC Access connector, returns an operation.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

name <string> The resource name in the format `projects/*/locations/*/connectors/*`.
Connector:
{:name string,
 :ipCidrRange string,
 :minInstances integer,
 :state [STATE_UNSPECIFIED READY CREATING DELETING ERROR UPDATING],
 :machineType string,
 :minThroughput integer,
 :network string,
 :maxInstances integer,
 :maxThroughput integer,
 :subnet {:name string, :projectId string},
 :connectedProjects [string]}

optional:
updateMask <string> The fields to update on the entry group. If absent or empty, all modifiable fields are updated."
  ([name Connector]
    (projects-locations-connectors-patch name Connector nil))
  ([name Connector optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://vpcaccess.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Connector})))

(defn projects-locations-connectors-get
  "Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

name <string> Required. Name of a Serverless VPC Access connector to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://vpcaccess.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connectors-list
  "Lists Serverless VPC Access connectors.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

parent <string> Required. The project and location from which the routes should be listed.

optional:
pageSize <integer> Maximum number of functions to return per call."
  ([parent] (projects-locations-connectors-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://vpcaccess.googleapis.com/v1/{+parent}/connectors",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connectors-delete
  "Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist.
https://cloud.google.com/vpc/docs/configure-serverless-vpc-access

name <string> Required. Name of a Serverless VPC Access connector to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://vpcaccess.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

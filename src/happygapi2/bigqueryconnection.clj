(ns happygapi2.bigqueryconnection
  "BigQuery Connection API
Allows users to manage BigQuery connections to external data sources.
See: https://cloud.google.com/bigquery/docs/connections-api-intro"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-connections-create
  "Creates a new connection.
https://cloud.google.com/bigquery/docs/connections-api-intro

parent <string> Required. Parent resource name. Must be in the format `projects/{project_id}/locations/{location_id}`
Connection:
{:creationTime string,
 :description string,
 :aws {:accessRole {:iamRoleId string, :identity string}},
 :cloudResource {:serviceAccountId string},
 :hasCredential boolean,
 :cloudSpanner
 {:database string,
  :useParallelism boolean,
  :maxParallelism integer,
  :useServerlessAnalytics boolean,
  :useDataBoost boolean,
  :databaseRole string},
 :name string,
 :lastModifiedTime string,
 :friendlyName string,
 :kmsKeyName string,
 :azure
 {:application string,
  :clientId string,
  :objectId string,
  :customerTenantId string,
  :redirectUri string,
  :federatedApplicationClientId string,
  :identity string},
 :configuration
 {:connectorId string,
  :endpoint {:hostPort string},
  :authentication
  {:usernamePassword
   {:username string,
    :password
    {:plaintext string,
     :secretType [SECRET_TYPE_UNSPECIFIED PLAINTEXT]}},
   :serviceAccount string},
  :network {:privateServiceConnect {:networkAttachment string}},
  :asset {:database string, :googleCloudResource string}},
 :salesforceDataCloud
 {:instanceUri string, :identity string, :tenantId string},
 :spark
 {:serviceAccountId string,
  :metastoreServiceConfig {:metastoreService string},
  :sparkHistoryServerConfig {:dataprocCluster string}},
 :cloudSql
 {:instanceId string,
  :database string,
  :type [DATABASE_TYPE_UNSPECIFIED POSTGRES MYSQL],
  :credential {:username string, :password string},
  :serviceAccountId string}}

optional:
connectionId <string> Optional. Connection id that should be assigned to the created connection."
  ([parent Connection]
    (projects-locations-connections-create parent Connection nil))
  ([parent Connection optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigqueryconnection.googleapis.com/v1/{+parent}/connections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Connection})))

(defn projects-locations-connections-get
  "Returns specified connection.
https://cloud.google.com/bigquery/docs/connections-api-intro

name <string> Required. Name of the requested connection, for example: `projects/{project_id}/locations/{location_id}/connections/{connection_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigqueryconnection.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connections-list
  "Returns a list of connections in the given project.
https://cloud.google.com/bigquery/docs/connections-api-intro

parent <string> Required. Parent resource name. Must be in the form: `projects/{project_id}/locations/{location_id}`

optional:
pageSize <integer> Required. Page size."
  ([parent] (projects-locations-connections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigqueryconnection.googleapis.com/v1/{+parent}/connections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-patch
  "Updates the specified connection. For security reasons, also resets credential if connection properties are in the update field mask.
https://cloud.google.com/bigquery/docs/connections-api-intro

name <string> Required. Name of the connection to update, for example: `projects/{project_id}/locations/{location_id}/connections/{connection_id}`
Connection:
{:creationTime string,
 :description string,
 :aws {:accessRole {:iamRoleId string, :identity string}},
 :cloudResource {:serviceAccountId string},
 :hasCredential boolean,
 :cloudSpanner
 {:database string,
  :useParallelism boolean,
  :maxParallelism integer,
  :useServerlessAnalytics boolean,
  :useDataBoost boolean,
  :databaseRole string},
 :name string,
 :lastModifiedTime string,
 :friendlyName string,
 :kmsKeyName string,
 :azure
 {:application string,
  :clientId string,
  :objectId string,
  :customerTenantId string,
  :redirectUri string,
  :federatedApplicationClientId string,
  :identity string},
 :configuration
 {:connectorId string,
  :endpoint {:hostPort string},
  :authentication
  {:usernamePassword
   {:username string,
    :password
    {:plaintext string,
     :secretType [SECRET_TYPE_UNSPECIFIED PLAINTEXT]}},
   :serviceAccount string},
  :network {:privateServiceConnect {:networkAttachment string}},
  :asset {:database string, :googleCloudResource string}},
 :salesforceDataCloud
 {:instanceUri string, :identity string, :tenantId string},
 :spark
 {:serviceAccountId string,
  :metastoreServiceConfig {:metastoreService string},
  :sparkHistoryServerConfig {:dataprocCluster string}},
 :cloudSql
 {:instanceId string,
  :database string,
  :type [DATABASE_TYPE_UNSPECIFIED POSTGRES MYSQL],
  :credential {:username string, :password string},
  :serviceAccountId string}}

optional:
updateMask <string> Required. Update mask for the connection fields to be updated."
  ([name Connection]
    (projects-locations-connections-patch name Connection nil))
  ([name Connection optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigqueryconnection.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Connection})))

(defn projects-locations-connections-delete
  "Deletes connection and associated credential.
https://cloud.google.com/bigquery/docs/connections-api-intro

name <string> Required. Name of the deleted connection, for example: `projects/{project_id}/locations/{location_id}/connections/{connection_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigqueryconnection.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connections-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/bigquery/docs/connections-api-intro

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigqueryconnection.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-connections-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/bigquery/docs/connections-api-intro

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
     "https://bigqueryconnection.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-connections-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/bigquery/docs/connections-api-intro

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigqueryconnection.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(ns happygapi2.datastore
  "Cloud Datastore API
Accesses the schemaless NoSQL database to provide fully managed, robust, scalable storage for your application. 
See: https://cloud.google.com/datastore/"
  (:require [happy.oauth2.client :as client]))

(defn projects-rollback
  "Rolls back a transaction.
https://cloud.google.com/datastore/reference/rest/v1/projects/rollback

projectId <string> Required. The ID of the project against which to make the request.
RollbackRequest:
{:databaseId string, :transaction string}"
  [projectId RollbackRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:rollback",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body RollbackRequest}))

(defn projects-reserveIds
  "Prevents the supplied keys' IDs from being auto-allocated by Cloud Datastore.
https://cloud.google.com/datastore/reference/rest/v1/projects/reserveIds

projectId <string> Required. The ID of the project against which to make the request.
ReserveIdsRequest:
{:databaseId string,
 :keys
 [{:partitionId
   {:projectId string, :databaseId string, :namespaceId string},
   :path [{:kind string, :id string, :name string}]}]}"
  [projectId ReserveIdsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:reserveIds",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body ReserveIdsRequest}))

(defn projects-lookup
  "Looks up entities by key.
https://cloud.google.com/datastore/reference/rest/v1/projects/lookup

projectId <string> Required. The ID of the project against which to make the request.
LookupRequest:
{:databaseId string,
 :readOptions
 {:readConsistency [READ_CONSISTENCY_UNSPECIFIED STRONG EVENTUAL],
  :transaction string,
  :newTransaction
  {:readWrite {:previousTransaction string},
   :readOnly {:readTime string}},
  :readTime string},
 :keys
 [{:partitionId
   {:projectId string, :databaseId string, :namespaceId string},
   :path [{:kind string, :id string, :name string}]}],
 :propertyMask {:paths [string]}}"
  [projectId LookupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:lookup",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body LookupRequest}))

(defn projects-runQuery
  "Queries for entities.
https://cloud.google.com/datastore/reference/rest/v1/projects/runQuery

projectId <string> Required. The ID of the project against which to make the request.
RunQueryRequest:
{:databaseId string,
 :partitionId
 {:projectId string, :databaseId string, :namespaceId string},
 :readOptions
 {:readConsistency [READ_CONSISTENCY_UNSPECIFIED STRONG EVENTUAL],
  :transaction string,
  :newTransaction
  {:readWrite {:previousTransaction string},
   :readOnly {:readTime string}},
  :readTime string},
 :query
 {:limit integer,
  :offset integer,
  :endCursor string,
  :filter
  {:compositeFilter
   {:op [OPERATOR_UNSPECIFIED AND OR],
    :filters
    [{:compositeFilter CompositeFilter,
      :propertyFilter PropertyFilter}]},
   :propertyFilter
   {:property {:name string},
    :op
    [OPERATOR_UNSPECIFIED
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL
     EQUAL
     IN
     NOT_EQUAL
     HAS_ANCESTOR
     NOT_IN],
    :value
    {:keyValue Key,
     :blobValue string,
     :booleanValue boolean,
     :stringValue string,
     :geoPointValue LatLng,
     :entityValue Entity,
     :arrayValue ArrayValue,
     :doubleValue number,
     :timestampValue string,
     :integerValue string,
     :meaning integer,
     :excludeFromIndexes boolean,
     :nullValue [NULL_VALUE]}}},
  :kind [{:name string}],
  :order
  [{:property {:name string},
    :direction [DIRECTION_UNSPECIFIED ASCENDING DESCENDING]}],
  :distinctOn [{:name string}],
  :projection [{:property {:name string}}],
  :startCursor string},
 :gqlQuery
 {:queryString string,
  :allowLiterals boolean,
  :namedBindings object,
  :positionalBindings
  [{:value
    {:keyValue {:partitionId PartitionId, :path [PathElement]},
     :blobValue string,
     :booleanValue boolean,
     :stringValue string,
     :geoPointValue {:latitude number, :longitude number},
     :entityValue {:key Key, :properties object},
     :arrayValue {:values [Value]},
     :doubleValue number,
     :timestampValue string,
     :integerValue string,
     :meaning integer,
     :excludeFromIndexes boolean,
     :nullValue [NULL_VALUE]},
    :cursor string}]},
 :propertyMask {:paths [string]},
 :explainOptions {:analyze boolean}}"
  [projectId RunQueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:runQuery",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body RunQueryRequest}))

(defn projects-export
  "Exports a copy of all or a subset of entities from Google Cloud Datastore to another storage system, such as Google Cloud Storage. Recent updates to entities may not be reflected in the export. The export occurs in the background and its progress can be monitored and managed via the Operation resource that is created. The output of an export may only be used once the associated operation is done. If an export operation is cancelled before completion it may leave partial data behind in Google Cloud Storage.
https://cloud.google.com/datastore/reference/rest/v1/projects/export

projectId <string> Required. Project ID against which to make the request.
GoogleDatastoreAdminV1ExportEntitiesRequest:
{:labels object,
 :entityFilter {:kinds [string], :namespaceIds [string]},
 :outputUrlPrefix string}"
  [projectId GoogleDatastoreAdminV1ExportEntitiesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:export",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body GoogleDatastoreAdminV1ExportEntitiesRequest}))

(defn projects-beginTransaction
  "Begins a new transaction.
https://cloud.google.com/datastore/reference/rest/v1/projects/beginTransaction

projectId <string> Required. The ID of the project against which to make the request.
BeginTransactionRequest:
{:databaseId string,
 :transactionOptions
 {:readWrite {:previousTransaction string},
  :readOnly {:readTime string}}}"
  [projectId BeginTransactionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:beginTransaction",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body BeginTransactionRequest}))

(defn projects-commit
  "Commits a transaction, optionally creating, deleting or modifying some entities.
https://cloud.google.com/datastore/reference/rest/v1/projects/commit

projectId <string> Required. The ID of the project against which to make the request.
CommitRequest:
{:databaseId string,
 :mode [MODE_UNSPECIFIED TRANSACTIONAL NON_TRANSACTIONAL],
 :transaction string,
 :singleUseTransaction
 {:readWrite {:previousTransaction string},
  :readOnly {:readTime string}},
 :mutations
 [{:insert
   {:key
    {:partitionId
     {:projectId string, :databaseId string, :namespaceId string},
     :path [{:kind string, :id string, :name string}]},
    :properties object},
   :update
   {:key
    {:partitionId
     {:projectId string, :databaseId string, :namespaceId string},
     :path [{:kind string, :id string, :name string}]},
    :properties object},
   :upsert
   {:key
    {:partitionId
     {:projectId string, :databaseId string, :namespaceId string},
     :path [{:kind string, :id string, :name string}]},
    :properties object},
   :delete
   {:partitionId
    {:projectId string, :databaseId string, :namespaceId string},
    :path [{:kind string, :id string, :name string}]},
   :baseVersion string,
   :updateTime string,
   :propertyMask {:paths [string]}}]}"
  [projectId CommitRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:commit",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body CommitRequest}))

(defn projects-runAggregationQuery
  "Runs an aggregation query.
https://cloud.google.com/datastore/reference/rest/v1/projects/runAggregationQuery

projectId <string> Required. The ID of the project against which to make the request.
RunAggregationQueryRequest:
{:databaseId string,
 :partitionId
 {:projectId string, :databaseId string, :namespaceId string},
 :readOptions
 {:readConsistency [READ_CONSISTENCY_UNSPECIFIED STRONG EVENTUAL],
  :transaction string,
  :newTransaction
  {:readWrite {:previousTransaction string},
   :readOnly {:readTime string}},
  :readTime string},
 :aggregationQuery
 {:nestedQuery
  {:limit integer,
   :offset integer,
   :endCursor string,
   :filter
   {:compositeFilter
    {:op [OPERATOR_UNSPECIFIED AND OR], :filters [Filter]},
    :propertyFilter
    {:property PropertyReference,
     :op
     [OPERATOR_UNSPECIFIED
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL
      EQUAL
      IN
      NOT_EQUAL
      HAS_ANCESTOR
      NOT_IN],
     :value Value}},
   :kind [{:name string}],
   :order
   [{:property {:name string},
     :direction [DIRECTION_UNSPECIFIED ASCENDING DESCENDING]}],
   :distinctOn [{:name string}],
   :projection [{:property {:name string}}],
   :startCursor string},
  :aggregations
  [{:count {:upTo string},
    :sum {:property {:name string}},
    :avg {:property {:name string}},
    :alias string}]},
 :gqlQuery
 {:queryString string,
  :allowLiterals boolean,
  :namedBindings object,
  :positionalBindings
  [{:value
    {:keyValue {:partitionId PartitionId, :path [PathElement]},
     :blobValue string,
     :booleanValue boolean,
     :stringValue string,
     :geoPointValue {:latitude number, :longitude number},
     :entityValue {:key Key, :properties object},
     :arrayValue {:values [Value]},
     :doubleValue number,
     :timestampValue string,
     :integerValue string,
     :meaning integer,
     :excludeFromIndexes boolean,
     :nullValue [NULL_VALUE]},
    :cursor string}]},
 :explainOptions {:analyze boolean}}"
  [projectId RunAggregationQueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:runAggregationQuery",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body RunAggregationQueryRequest}))

(defn projects-allocateIds
  "Allocates IDs for the given keys, which is useful for referencing an entity before it is inserted.
https://cloud.google.com/datastore/reference/rest/v1/projects/allocateIds

projectId <string> Required. The ID of the project against which to make the request.
AllocateIdsRequest:
{:databaseId string,
 :keys
 [{:partitionId
   {:projectId string, :databaseId string, :namespaceId string},
   :path [{:kind string, :id string, :name string}]}]}"
  [projectId AllocateIdsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:allocateIds",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body AllocateIdsRequest}))

(defn projects-import
  "Imports entities into Google Cloud Datastore. Existing entities with the same key are overwritten. The import occurs in the background and its progress can be monitored and managed via the Operation resource that is created. If an ImportEntities operation is cancelled, it is possible that a subset of the data has already been imported to Cloud Datastore.
https://cloud.google.com/datastore/reference/rest/v1/projects/import

projectId <string> Required. Project ID against which to make the request.
GoogleDatastoreAdminV1ImportEntitiesRequest:
{:labels object,
 :inputUrl string,
 :entityFilter {:kinds [string], :namespaceIds [string]}}"
  [projectId GoogleDatastoreAdminV1ImportEntitiesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}:import",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body GoogleDatastoreAdminV1ImportEntitiesRequest}))

(defn projects-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/datastore/reference/rest/v1/projects/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datastore.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/datastore"]})))

(defn projects-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/datastore/reference/rest/v1/projects/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"]}))

(defn projects-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/datastore/reference/rest/v1/projects/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datastore.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"]}))

(defn projects-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/datastore/reference/rest/v1/projects/operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"]}))

(defn projects-indexes-create
  "Creates the specified index. A newly created index's initial state is `CREATING`. On completion of the returned google.longrunning.Operation, the state will be `READY`. If the index already exists, the call will return an `ALREADY_EXISTS` status. During index creation, the process could result in an error, in which case the index will move to the `ERROR` state. The process can be recovered by fixing the data that caused the error, removing the index with delete, then re-creating the index with create. Indexes with a single property cannot be created.
https://cloud.google.com/datastore/reference/rest/v1/projects/indexes/create

projectId <string> Project ID against which to make the request.
GoogleDatastoreAdminV1Index:
{:projectId string,
 :indexId string,
 :kind string,
 :ancestor [ANCESTOR_MODE_UNSPECIFIED NONE ALL_ANCESTORS],
 :properties
 [{:name string,
   :direction [DIRECTION_UNSPECIFIED ASCENDING DESCENDING]}],
 :state [STATE_UNSPECIFIED CREATING READY DELETING ERROR]}"
  [projectId GoogleDatastoreAdminV1Index]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}/indexes",
     :uri-template-args {:projectId projectId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"],
     :body GoogleDatastoreAdminV1Index}))

(defn projects-indexes-delete
  "Deletes an existing index. An index can only be deleted if it is in a `READY` or `ERROR` state. On successful execution of the request, the index will be in a `DELETING` state. And on completion of the returned google.longrunning.Operation, the index will be removed. During index deletion, the process could result in an error, in which case the index will move to the `ERROR` state. The process can be recovered by fixing the data that caused the error, followed by calling delete again.
https://cloud.google.com/datastore/reference/rest/v1/projects/indexes/delete

projectId <string> Project ID against which to make the request.
indexId <string> The resource ID of the index to delete."
  [projectId indexId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}/indexes/{indexId}",
     :uri-template-args {:projectId projectId, :indexId indexId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"]}))

(defn projects-indexes-get
  "Gets an index.
https://cloud.google.com/datastore/reference/rest/v1/projects/indexes/get

projectId <string> Project ID against which to make the request.
indexId <string> The resource ID of the index to get."
  [projectId indexId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://datastore.googleapis.com/v1/projects/{projectId}/indexes/{indexId}",
     :uri-template-args {:projectId projectId, :indexId indexId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/datastore"]}))

(defn projects-indexes-list
  "Lists the indexes that match the specified filters. Datastore uses an eventually consistent query to fetch the list of indexes and may occasionally return stale results.
https://cloud.google.com/datastore/reference/rest/v1/projects/indexes/list

projectId <string> Project ID against which to make the request.

optional:
filter <string> 
pageSize <integer> The maximum number of items to return. If zero, then all results will be returned."
  ([projectId] (projects-indexes-list projectId nil))
  ([projectId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datastore.googleapis.com/v1/projects/{projectId}/indexes",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/datastore"]})))

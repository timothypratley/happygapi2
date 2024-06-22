(ns happygapi2.datacatalog
  "Google Cloud Data Catalog API
A fully managed and highly scalable data discovery and metadata management service. 
See: https://cloud.google.com/data-catalog/docs/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-create
  "Creates an entry group. An entry group contains logically related entries together with [Cloud Identity and Access Management](/data-catalog/docs/concepts/iam) policies. These policies specify users who can create, edit, and view entries within entry groups. Data Catalog automatically creates entry groups with names that start with the `@` symbol for the following resources: * BigQuery entries (`@bigquery`) * Pub/Sub topics (`@pubsub`) * Dataproc Metastore services (`@dataproc_metastore_{SERVICE_NAME_HASH}`) You can create your own entry groups for Cloud Storage fileset entries and custom entries together with the corresponding IAM policies. User-created entry groups can't contain the `@` symbol, it is reserved for automatically created groups. Entry groups, like entries, can be searched. A maximum of 10,000 entry groups may be created per organization across all locations. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/create

parent <string> Required. The names of the project and location that the new entry group belongs to. Note: The entry group itself and its child resources might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1EntryGroup:
{:name string,
 :displayName string,
 :description string,
 :dataCatalogTimestamps
 {:createTime string, :updateTime string, :expireTime string}}

optional:
entryGroupId <string> Required. The ID of the entry group to create. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and must start with a letter or underscore. The maximum size is 64 bytes when encoded in UTF-8."
  ([parent GoogleCloudDatacatalogV1EntryGroup]
    (projects-locations-entryGroups-create
      parent
      GoogleCloudDatacatalogV1EntryGroup
      nil))
  ([parent GoogleCloudDatacatalogV1EntryGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/entryGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1EntryGroup})))

(defn projects-locations-entryGroups-get
  "Gets an entry group.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/get

name <string> Required. The name of the entry group to get.

optional:
readMask <string> The fields to return. If empty or omitted, all fields are returned."
  ([name] (projects-locations-entryGroups-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-patch
  "Updates an entry group. You must enable the Data Catalog API in the project identified by the `entry_group.name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/patch

name <string> Identifier. The resource name of the entry group in URL format. Note: The entry group itself and its child resources might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1EntryGroup:
{:name string,
 :displayName string,
 :description string,
 :dataCatalogTimestamps
 {:createTime string, :updateTime string, :expireTime string}}

optional:
updateMask <string> Names of fields whose values to overwrite on an entry group. If this parameter is absent or empty, all modifiable fields are overwritten. If such fields are non-required and omitted in the request body, their values are emptied."
  ([name GoogleCloudDatacatalogV1EntryGroup]
    (projects-locations-entryGroups-patch
      name
      GoogleCloudDatacatalogV1EntryGroup
      nil))
  ([name GoogleCloudDatacatalogV1EntryGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1EntryGroup})))

(defn projects-locations-entryGroups-delete
  "Deletes an entry group. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/delete

name <string> Required. The name of the entry group to delete.

optional:
force <boolean> Optional. If true, deletes all entries in the entry group."
  ([name] (projects-locations-entryGroups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-list
  "Lists entry groups.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/list

parent <string> Required. The name of the location that contains the entry groups to list. Can be provided as a URL.

optional:
pageSize <integer> Optional. The maximum number of items to return. Default is 10. Maximum limit is 1000. Throws an invalid argument if `page_size` is greater than 1000."
  ([parent] (projects-locations-entryGroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/entryGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-setIamPolicy
  "Sets an access control policy for a resource. Replaces any existing policy. Supported resources are: - Tag templates - Entry groups Note: This method sets policies only within Data Catalog and can't be used to manage policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources synced with the Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-entryGroups-getIamPolicy
  "Gets the access control policy for a resource. May return: * A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view it. * An empty policy if the resource exists but doesn't have a set policy. Supported resources are: - Tag templates - Entry groups Note: This method doesn't get policies from Google Cloud Platform resources ingested into Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-entryGroups-testIamPermissions
  "Gets your permissions on a resource. Returns an empty set of permissions if the resource doesn't exist. Supported resources are: - Tag templates - Entry groups Note: This method gets policies only within Data Catalog and can't be used to get policies from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources ingested into Data Catalog. No Google IAM permissions are required to call this method.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-entryGroups-entries-modifyEntryContacts
  "Modifies contacts, part of the business context of an Entry. To call this method, you must have the `datacatalog.entries.updateContacts` IAM permission on the corresponding project.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/modifyEntryContacts

name <string> Required. The full resource name of the entry.
GoogleCloudDatacatalogV1ModifyEntryContactsRequest:
{:contacts {:people [{:designation string, :email string}]}}"
  [name GoogleCloudDatacatalogV1ModifyEntryContactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:modifyEntryContacts",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1ModifyEntryContactsRequest}))

(defn projects-locations-entryGroups-entries-get
  "Gets an entry.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/get

name <string> Required. The name of the entry to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-entries-patch
  "Updates an existing entry. You must enable the Data Catalog API in the project identified by the `entry.name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/patch

name <string> Output only. Identifier. The resource name of an entry in URL format. Note: The entry itself and its child resources might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1Entry:
{:description string,
 :cloudBigtableSystemSpec {:instanceDisplayName string},
 :schema
 {:columns
  [{:description string,
    :subcolumns
    [{:description string,
      :subcolumns
      [{:description string,
        :subcolumns [GoogleCloudDatacatalogV1ColumnSchema],
        :rangeElementType
        GoogleCloudDatacatalogV1ColumnSchemaFieldElementType,
        :lookerColumnSpec
        GoogleCloudDatacatalogV1ColumnSchemaLookerColumnSpec,
        :mode string,
        :highestIndexingType
        [INDEXING_TYPE_UNSPECIFIED
         INDEXING_TYPE_NONE
         INDEXING_TYPE_NON_UNIQUE
         INDEXING_TYPE_UNIQUE
         INDEXING_TYPE_PRIMARY_KEY],
        :type string,
        :column string,
        :ordinalPosition integer,
        :gcRule string,
        :defaultValue string}],
      :rangeElementType {:type string},
      :lookerColumnSpec
      {:type
       [LOOKER_COLUMN_TYPE_UNSPECIFIED
        DIMENSION
        DIMENSION_GROUP
        FILTER
        MEASURE
        PARAMETER]},
      :mode string,
      :highestIndexingType
      [INDEXING_TYPE_UNSPECIFIED
       INDEXING_TYPE_NONE
       INDEXING_TYPE_NON_UNIQUE
       INDEXING_TYPE_UNIQUE
       INDEXING_TYPE_PRIMARY_KEY],
      :type string,
      :column string,
      :ordinalPosition integer,
      :gcRule string,
      :defaultValue string}],
    :rangeElementType {:type string},
    :lookerColumnSpec
    {:type
     [LOOKER_COLUMN_TYPE_UNSPECIFIED
      DIMENSION
      DIMENSION_GROUP
      FILTER
      MEASURE
      PARAMETER]},
    :mode string,
    :highestIndexingType
    [INDEXING_TYPE_UNSPECIFIED
     INDEXING_TYPE_NONE
     INDEXING_TYPE_NON_UNIQUE
     INDEXING_TYPE_UNIQUE
     INDEXING_TYPE_PRIMARY_KEY],
    :type string,
    :column string,
    :ordinalPosition integer,
    :gcRule string,
    :defaultValue string}]},
 :labels object,
 :bigqueryDateShardedSpec
 {:dataset string,
  :tablePrefix string,
  :shardCount string,
  :latestShardResource string},
 :userSpecifiedSystem string,
 :sourceSystemTimestamps
 {:createTime string, :updateTime string, :expireTime string},
 :displayName string,
 :name string,
 :businessContext
 {:entryOverview {:overview string},
  :contacts {:people [{:designation string, :email string}]}},
 :datasetSpec
 {:vertexDatasetSpec
  {:dataItemCount string,
   :dataType
   [DATA_TYPE_UNSPECIFIED
    TABLE
    IMAGE
    TEXT
    VIDEO
    CONVERSATION
    TIME_SERIES
    DOCUMENT
    TEXT_TO_SPEECH
    TRANSLATION
    STORE_VISION
    ENTERPRISE_KNOWLEDGE_GRAPH
    TEXT_PROMPT]}},
 :usageSignal
 {:updateTime string,
  :usageWithinTimeRange object,
  :commonUsageWithinTimeRange object,
  :favoriteCount string},
 :filesetSpec
 {:dataplexFileset
  {:dataplexSpec
   {:asset string,
    :dataFormat
    {:avro GoogleCloudDatacatalogV1PhysicalSchemaAvroSchema,
     :thrift GoogleCloudDatacatalogV1PhysicalSchemaThriftSchema,
     :protobuf GoogleCloudDatacatalogV1PhysicalSchemaProtobufSchema,
     :parquet GoogleCloudDatacatalogV1PhysicalSchemaParquetSchema,
     :orc GoogleCloudDatacatalogV1PhysicalSchemaOrcSchema,
     :csv GoogleCloudDatacatalogV1PhysicalSchemaCsvSchema},
    :compressionFormat string,
    :projectId string}}},
 :featureOnlineStoreSpec
 {:storageType [STORAGE_TYPE_UNSPECIFIED BIGTABLE OPTIMIZED]},
 :gcsFilesetSpec
 {:filePatterns [string],
  :sampleGcsFileSpecs
  [{:filePath string,
    :gcsTimestamps
    {:createTime string, :updateTime string, :expireTime string},
    :sizeBytes string}]},
 :type
 [ENTRY_TYPE_UNSPECIFIED
  TABLE
  MODEL
  DATA_STREAM
  FILESET
  CLUSTER
  DATABASE
  DATA_SOURCE_CONNECTION
  ROUTINE
  LAKE
  ZONE
  SERVICE
  DATABASE_SCHEMA
  DASHBOARD
  EXPLORE
  LOOK
  FEATURE_ONLINE_STORE
  FEATURE_VIEW
  FEATURE_GROUP],
 :bigqueryTableSpec
 {:tableSourceType
  [TABLE_SOURCE_TYPE_UNSPECIFIED
   BIGQUERY_VIEW
   BIGQUERY_TABLE
   BIGQUERY_MATERIALIZED_VIEW],
  :viewSpec {:viewQuery string},
  :tableSpec {:groupedEntry string}},
 :serviceSpec
 {:cloudBigtableInstanceSpec
  {:cloudBigtableClusterSpecs
   [{:displayName string,
     :location string,
     :type string,
     :linkedResource string}]}},
 :linkedResource string,
 :routineSpec
 {:routineType [ROUTINE_TYPE_UNSPECIFIED SCALAR_FUNCTION PROCEDURE],
  :language string,
  :routineArguments
  [{:name string,
    :mode [MODE_UNSPECIFIED IN OUT INOUT],
    :type string}],
  :returnType string,
  :definitionBody string,
  :bigqueryRoutineSpec {:importedLibraries [string]}},
 :dataSourceConnectionSpec
 {:bigqueryConnectionSpec
  {:connectionType [CONNECTION_TYPE_UNSPECIFIED CLOUD_SQL],
   :cloudSql
   {:instanceId string,
    :database string,
    :type [DATABASE_TYPE_UNSPECIFIED POSTGRES MYSQL]},
   :hasCredential boolean}},
 :modelSpec
 {:vertexModelSpec
  {:versionId string,
   :versionAliases [string],
   :versionDescription string,
   :vertexModelSourceInfo
   {:sourceType
    [MODEL_SOURCE_TYPE_UNSPECIFIED
     AUTOML
     CUSTOM
     BQML
     MODEL_GARDEN
     GENIE
     CUSTOM_TEXT_EMBEDDING
     MARKETPLACE],
    :copy boolean},
   :containerImageUri string}},
 :dataSource
 {:service [SERVICE_UNSPECIFIED CLOUD_STORAGE BIGQUERY],
  :resource string,
  :sourceEntry string,
  :storageProperties {:filePattern [string], :fileType string}},
 :lookerSystemSpec
 {:parentInstanceId string,
  :parentInstanceDisplayName string,
  :parentModelId string,
  :parentModelDisplayName string,
  :parentViewId string,
  :parentViewDisplayName string},
 :databaseTableSpec
 {:type [TABLE_TYPE_UNSPECIFIED NATIVE EXTERNAL],
  :dataplexTable
  {:externalTables
   [{:system
     [INTEGRATED_SYSTEM_UNSPECIFIED
      BIGQUERY
      CLOUD_PUBSUB
      DATAPROC_METASTORE
      DATAPLEX
      CLOUD_SPANNER
      CLOUD_BIGTABLE
      CLOUD_SQL
      LOOKER
      VERTEX_AI],
     :fullyQualifiedName string,
     :googleCloudResource string,
     :dataCatalogEntry string}],
   :dataplexSpec
   {:asset string,
    :dataFormat
    {:avro GoogleCloudDatacatalogV1PhysicalSchemaAvroSchema,
     :thrift GoogleCloudDatacatalogV1PhysicalSchemaThriftSchema,
     :protobuf GoogleCloudDatacatalogV1PhysicalSchemaProtobufSchema,
     :parquet GoogleCloudDatacatalogV1PhysicalSchemaParquetSchema,
     :orc GoogleCloudDatacatalogV1PhysicalSchemaOrcSchema,
     :csv GoogleCloudDatacatalogV1PhysicalSchemaCsvSchema},
    :compressionFormat string,
    :projectId string},
   :userManaged boolean},
  :databaseViewSpec
  {:viewType [VIEW_TYPE_UNSPECIFIED STANDARD_VIEW MATERIALIZED_VIEW],
   :baseTable string,
   :sqlQuery string}},
 :sqlDatabaseSystemSpec
 {:sqlEngine string, :databaseVersion string, :instanceHost string},
 :userSpecifiedType string,
 :integratedSystem
 [INTEGRATED_SYSTEM_UNSPECIFIED
  BIGQUERY
  CLOUD_PUBSUB
  DATAPROC_METASTORE
  DATAPLEX
  CLOUD_SPANNER
  CLOUD_BIGTABLE
  CLOUD_SQL
  LOOKER
  VERTEX_AI],
 :fullyQualifiedName string,
 :personalDetails {:starred boolean, :starTime string}}

optional:
updateMask <string> Names of fields whose values to overwrite on an entry. If this parameter is absent or empty, all modifiable fields are overwritten. If such fields are non-required and omitted in the request body, their values are emptied. You can modify only the fields listed below. For entries with type `DATA_STREAM`: * `schema` For entries with type `FILESET`: * `schema` * `display_name` * `description` * `gcs_fileset_spec` * `gcs_fileset_spec.file_patterns` For entries with `user_specified_type`: * `schema` * `display_name` * `description` * `user_specified_type` * `user_specified_system` * `linked_resource` * `source_system_timestamps`"
  ([name GoogleCloudDatacatalogV1Entry]
    (projects-locations-entryGroups-entries-patch
      name
      GoogleCloudDatacatalogV1Entry
      nil))
  ([name GoogleCloudDatacatalogV1Entry optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1Entry})))

(defn projects-locations-entryGroups-entries-testIamPermissions
  "Gets your permissions on a resource. Returns an empty set of permissions if the resource doesn't exist. Supported resources are: - Tag templates - Entry groups Note: This method gets policies only within Data Catalog and can't be used to get policies from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources ingested into Data Catalog. No Google IAM permissions are required to call this method.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-entryGroups-entries-create
  "Creates an entry. You can create entries only with 'FILESET', 'CLUSTER', 'DATA_STREAM', or custom types. Data Catalog automatically creates entries with other types during metadata ingestion from integrated systems. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project). An entry group can have a maximum of 100,000 entries.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/create

parent <string> Required. The name of the entry group this entry belongs to. Note: The entry itself and its child resources might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1Entry:
{:description string,
 :cloudBigtableSystemSpec {:instanceDisplayName string},
 :schema
 {:columns
  [{:description string,
    :subcolumns
    [{:description string,
      :subcolumns
      [{:description string,
        :subcolumns [GoogleCloudDatacatalogV1ColumnSchema],
        :rangeElementType
        GoogleCloudDatacatalogV1ColumnSchemaFieldElementType,
        :lookerColumnSpec
        GoogleCloudDatacatalogV1ColumnSchemaLookerColumnSpec,
        :mode string,
        :highestIndexingType
        [INDEXING_TYPE_UNSPECIFIED
         INDEXING_TYPE_NONE
         INDEXING_TYPE_NON_UNIQUE
         INDEXING_TYPE_UNIQUE
         INDEXING_TYPE_PRIMARY_KEY],
        :type string,
        :column string,
        :ordinalPosition integer,
        :gcRule string,
        :defaultValue string}],
      :rangeElementType {:type string},
      :lookerColumnSpec
      {:type
       [LOOKER_COLUMN_TYPE_UNSPECIFIED
        DIMENSION
        DIMENSION_GROUP
        FILTER
        MEASURE
        PARAMETER]},
      :mode string,
      :highestIndexingType
      [INDEXING_TYPE_UNSPECIFIED
       INDEXING_TYPE_NONE
       INDEXING_TYPE_NON_UNIQUE
       INDEXING_TYPE_UNIQUE
       INDEXING_TYPE_PRIMARY_KEY],
      :type string,
      :column string,
      :ordinalPosition integer,
      :gcRule string,
      :defaultValue string}],
    :rangeElementType {:type string},
    :lookerColumnSpec
    {:type
     [LOOKER_COLUMN_TYPE_UNSPECIFIED
      DIMENSION
      DIMENSION_GROUP
      FILTER
      MEASURE
      PARAMETER]},
    :mode string,
    :highestIndexingType
    [INDEXING_TYPE_UNSPECIFIED
     INDEXING_TYPE_NONE
     INDEXING_TYPE_NON_UNIQUE
     INDEXING_TYPE_UNIQUE
     INDEXING_TYPE_PRIMARY_KEY],
    :type string,
    :column string,
    :ordinalPosition integer,
    :gcRule string,
    :defaultValue string}]},
 :labels object,
 :bigqueryDateShardedSpec
 {:dataset string,
  :tablePrefix string,
  :shardCount string,
  :latestShardResource string},
 :userSpecifiedSystem string,
 :sourceSystemTimestamps
 {:createTime string, :updateTime string, :expireTime string},
 :displayName string,
 :name string,
 :businessContext
 {:entryOverview {:overview string},
  :contacts {:people [{:designation string, :email string}]}},
 :datasetSpec
 {:vertexDatasetSpec
  {:dataItemCount string,
   :dataType
   [DATA_TYPE_UNSPECIFIED
    TABLE
    IMAGE
    TEXT
    VIDEO
    CONVERSATION
    TIME_SERIES
    DOCUMENT
    TEXT_TO_SPEECH
    TRANSLATION
    STORE_VISION
    ENTERPRISE_KNOWLEDGE_GRAPH
    TEXT_PROMPT]}},
 :usageSignal
 {:updateTime string,
  :usageWithinTimeRange object,
  :commonUsageWithinTimeRange object,
  :favoriteCount string},
 :filesetSpec
 {:dataplexFileset
  {:dataplexSpec
   {:asset string,
    :dataFormat
    {:avro GoogleCloudDatacatalogV1PhysicalSchemaAvroSchema,
     :thrift GoogleCloudDatacatalogV1PhysicalSchemaThriftSchema,
     :protobuf GoogleCloudDatacatalogV1PhysicalSchemaProtobufSchema,
     :parquet GoogleCloudDatacatalogV1PhysicalSchemaParquetSchema,
     :orc GoogleCloudDatacatalogV1PhysicalSchemaOrcSchema,
     :csv GoogleCloudDatacatalogV1PhysicalSchemaCsvSchema},
    :compressionFormat string,
    :projectId string}}},
 :featureOnlineStoreSpec
 {:storageType [STORAGE_TYPE_UNSPECIFIED BIGTABLE OPTIMIZED]},
 :gcsFilesetSpec
 {:filePatterns [string],
  :sampleGcsFileSpecs
  [{:filePath string,
    :gcsTimestamps
    {:createTime string, :updateTime string, :expireTime string},
    :sizeBytes string}]},
 :type
 [ENTRY_TYPE_UNSPECIFIED
  TABLE
  MODEL
  DATA_STREAM
  FILESET
  CLUSTER
  DATABASE
  DATA_SOURCE_CONNECTION
  ROUTINE
  LAKE
  ZONE
  SERVICE
  DATABASE_SCHEMA
  DASHBOARD
  EXPLORE
  LOOK
  FEATURE_ONLINE_STORE
  FEATURE_VIEW
  FEATURE_GROUP],
 :bigqueryTableSpec
 {:tableSourceType
  [TABLE_SOURCE_TYPE_UNSPECIFIED
   BIGQUERY_VIEW
   BIGQUERY_TABLE
   BIGQUERY_MATERIALIZED_VIEW],
  :viewSpec {:viewQuery string},
  :tableSpec {:groupedEntry string}},
 :serviceSpec
 {:cloudBigtableInstanceSpec
  {:cloudBigtableClusterSpecs
   [{:displayName string,
     :location string,
     :type string,
     :linkedResource string}]}},
 :linkedResource string,
 :routineSpec
 {:routineType [ROUTINE_TYPE_UNSPECIFIED SCALAR_FUNCTION PROCEDURE],
  :language string,
  :routineArguments
  [{:name string,
    :mode [MODE_UNSPECIFIED IN OUT INOUT],
    :type string}],
  :returnType string,
  :definitionBody string,
  :bigqueryRoutineSpec {:importedLibraries [string]}},
 :dataSourceConnectionSpec
 {:bigqueryConnectionSpec
  {:connectionType [CONNECTION_TYPE_UNSPECIFIED CLOUD_SQL],
   :cloudSql
   {:instanceId string,
    :database string,
    :type [DATABASE_TYPE_UNSPECIFIED POSTGRES MYSQL]},
   :hasCredential boolean}},
 :modelSpec
 {:vertexModelSpec
  {:versionId string,
   :versionAliases [string],
   :versionDescription string,
   :vertexModelSourceInfo
   {:sourceType
    [MODEL_SOURCE_TYPE_UNSPECIFIED
     AUTOML
     CUSTOM
     BQML
     MODEL_GARDEN
     GENIE
     CUSTOM_TEXT_EMBEDDING
     MARKETPLACE],
    :copy boolean},
   :containerImageUri string}},
 :dataSource
 {:service [SERVICE_UNSPECIFIED CLOUD_STORAGE BIGQUERY],
  :resource string,
  :sourceEntry string,
  :storageProperties {:filePattern [string], :fileType string}},
 :lookerSystemSpec
 {:parentInstanceId string,
  :parentInstanceDisplayName string,
  :parentModelId string,
  :parentModelDisplayName string,
  :parentViewId string,
  :parentViewDisplayName string},
 :databaseTableSpec
 {:type [TABLE_TYPE_UNSPECIFIED NATIVE EXTERNAL],
  :dataplexTable
  {:externalTables
   [{:system
     [INTEGRATED_SYSTEM_UNSPECIFIED
      BIGQUERY
      CLOUD_PUBSUB
      DATAPROC_METASTORE
      DATAPLEX
      CLOUD_SPANNER
      CLOUD_BIGTABLE
      CLOUD_SQL
      LOOKER
      VERTEX_AI],
     :fullyQualifiedName string,
     :googleCloudResource string,
     :dataCatalogEntry string}],
   :dataplexSpec
   {:asset string,
    :dataFormat
    {:avro GoogleCloudDatacatalogV1PhysicalSchemaAvroSchema,
     :thrift GoogleCloudDatacatalogV1PhysicalSchemaThriftSchema,
     :protobuf GoogleCloudDatacatalogV1PhysicalSchemaProtobufSchema,
     :parquet GoogleCloudDatacatalogV1PhysicalSchemaParquetSchema,
     :orc GoogleCloudDatacatalogV1PhysicalSchemaOrcSchema,
     :csv GoogleCloudDatacatalogV1PhysicalSchemaCsvSchema},
    :compressionFormat string,
    :projectId string},
   :userManaged boolean},
  :databaseViewSpec
  {:viewType [VIEW_TYPE_UNSPECIFIED STANDARD_VIEW MATERIALIZED_VIEW],
   :baseTable string,
   :sqlQuery string}},
 :sqlDatabaseSystemSpec
 {:sqlEngine string, :databaseVersion string, :instanceHost string},
 :userSpecifiedType string,
 :integratedSystem
 [INTEGRATED_SYSTEM_UNSPECIFIED
  BIGQUERY
  CLOUD_PUBSUB
  DATAPROC_METASTORE
  DATAPLEX
  CLOUD_SPANNER
  CLOUD_BIGTABLE
  CLOUD_SQL
  LOOKER
  VERTEX_AI],
 :fullyQualifiedName string,
 :personalDetails {:starred boolean, :starTime string}}

optional:
entryId <string> Required. The ID of the entry to create. The ID must contain only letters (a-z, A-Z), numbers (0-9), and underscores (_). The maximum size is 64 bytes when encoded in UTF-8."
  ([parent GoogleCloudDatacatalogV1Entry]
    (projects-locations-entryGroups-entries-create
      parent
      GoogleCloudDatacatalogV1Entry
      nil))
  ([parent GoogleCloudDatacatalogV1Entry optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/entries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1Entry})))

(defn projects-locations-entryGroups-entries-delete
  "Deletes an existing entry. You can delete only the entries created by the CreateEntry method. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/delete

name <string> Required. The name of the entry to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-entries-star
  "Marks an Entry as starred by the current user. Starring information is private to each user.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/star

name <string> Required. The name of the entry to mark as starred.
GoogleCloudDatacatalogV1StarEntryRequest:
object"
  [name GoogleCloudDatacatalogV1StarEntryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:star",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1StarEntryRequest}))

(defn projects-locations-entryGroups-entries-getIamPolicy
  "Gets the access control policy for a resource. May return: * A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view it. * An empty policy if the resource exists but doesn't have a set policy. Supported resources are: - Tag templates - Entry groups Note: This method doesn't get policies from Google Cloud Platform resources ingested into Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-entryGroups-entries-list
  "Lists entries. Note: Currently, this method can list only custom entries. To get a list of both custom and automatically created entries, use SearchCatalog.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/list

parent <string> Required. The name of the entry group that contains the entries to list. Can be provided in URL format.

optional:
pageSize <integer> The maximum number of items to return. Default is 10. Maximum limit is 1000. Throws an invalid argument if `page_size` is more than 1000.
readMask <string> The fields to return for each entry. If empty or omitted, all fields are returned. For example, to return a list of entries with only the `name` field, set `read_mask` to only one path with the `name` value."
  ([parent] (projects-locations-entryGroups-entries-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/entries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-entries-modifyEntryOverview
  "Modifies entry overview, part of the business context of an Entry. To call this method, you must have the `datacatalog.entries.updateOverview` IAM permission on the corresponding project.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/modifyEntryOverview

name <string> Required. The full resource name of the entry.
GoogleCloudDatacatalogV1ModifyEntryOverviewRequest:
{:entryOverview {:overview string}}"
  [name GoogleCloudDatacatalogV1ModifyEntryOverviewRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:modifyEntryOverview",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1ModifyEntryOverviewRequest}))

(defn projects-locations-entryGroups-entries-unstar
  "Marks an Entry as NOT starred by the current user. Starring information is private to each user.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/unstar

name <string> Required. The name of the entry to mark as **not** starred.
GoogleCloudDatacatalogV1UnstarEntryRequest:
object"
  [name GoogleCloudDatacatalogV1UnstarEntryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:unstar",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1UnstarEntryRequest}))

(defn projects-locations-entryGroups-entries-import
  "Imports entries from a source, such as data previously dumped into a Cloud Storage bucket, into Data Catalog. Import of entries is a sync operation that reconciles the state of the third-party system with the Data Catalog. `ImportEntries` accepts source data snapshots of a third-party system. Snapshot should be delivered as a .wire or base65-encoded .txt file containing a sequence of Protocol Buffer messages of DumpItem type. `ImportEntries` returns a long-running operation resource that can be queried with Operations.GetOperation to return ImportEntriesMetadata and an ImportEntriesResponse message.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries/import

parent <string> Required. Target entry group for ingested entries.
GoogleCloudDatacatalogV1ImportEntriesRequest:
{:gcsBucketPath string, :jobId string}"
  [parent GoogleCloudDatacatalogV1ImportEntriesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+parent}/entries:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1ImportEntriesRequest}))

(defn projects-locations-entryGroups-entries-tags-create
  "Creates a tag and assigns it to: * An Entry if the method name is `projects.locations.entryGroups.entries.tags.create`. * Or EntryGroupif the method name is `projects.locations.entryGroups.tags.create`. Note: The project identified by the `parent` parameter for the [tag] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters) and the [tag template] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters) used to create the tag must be in the same organization.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create

parent <string> Required. The name of the resource to attach this tag to. Tags can be attached to entries or entry groups. An entry can have up to 1000 attached tags. Note: The tag and its child resources might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1Tag:
{:name string,
 :template string,
 :templateDisplayName string,
 :column string,
 :fields object}"
  [parent GoogleCloudDatacatalogV1Tag]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+parent}/tags",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1Tag}))

(defn projects-locations-entryGroups-entries-tags-patch
  "Updates an existing tag.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/patch

name <string> Identifier. The resource name of the tag in URL format where tag ID is a system-generated identifier. Note: The tag itself might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1Tag:
{:name string,
 :template string,
 :templateDisplayName string,
 :column string,
 :fields object}

optional:
updateMask <string> Names of fields whose values to overwrite on a tag. Currently, a tag has the only modifiable field with the name `fields`. In general, if this parameter is absent or empty, all modifiable fields are overwritten. If such fields are non-required and omitted in the request body, their values are emptied."
  ([name GoogleCloudDatacatalogV1Tag]
    (projects-locations-entryGroups-entries-tags-patch
      name
      GoogleCloudDatacatalogV1Tag
      nil))
  ([name GoogleCloudDatacatalogV1Tag optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1Tag})))

(defn projects-locations-entryGroups-entries-tags-delete
  "Deletes a tag.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/delete

name <string> Required. The name of the tag to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-entries-tags-list
  "Lists tags assigned to an Entry. The columns in the response are lowercased.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/list

parent <string> Required. The name of the Data Catalog resource to list the tags of. The resource can be an Entry or an EntryGroup (without `/entries/{entries}` at the end).

optional:
pageSize <integer> The maximum number of tags to return. Default is 10. Maximum limit is 1000."
  ([parent]
    (projects-locations-entryGroups-entries-tags-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/tags",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-entries-tags-reconcile
  "`ReconcileTags` creates or updates a list of tags on the entry. If the ReconcileTagsRequest.force_delete_missing parameter is set, the operation deletes tags not included in the input tag list. `ReconcileTags` returns a long-running operation resource that can be queried with Operations.GetOperation to return ReconcileTagsMetadata and a ReconcileTagsResponse message.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/reconcile

parent <string> Required. Name of Entry to be tagged.
GoogleCloudDatacatalogV1ReconcileTagsRequest:
{:tagTemplate string,
 :forceDeleteMissing boolean,
 :tags
 [{:name string,
   :template string,
   :templateDisplayName string,
   :column string,
   :fields object}]}"
  [parent GoogleCloudDatacatalogV1ReconcileTagsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+parent}/tags:reconcile",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1ReconcileTagsRequest}))

(defn projects-locations-entryGroups-tags-create
  "Creates a tag and assigns it to: * An Entry if the method name is `projects.locations.entryGroups.entries.tags.create`. * Or EntryGroupif the method name is `projects.locations.entryGroups.tags.create`. Note: The project identified by the `parent` parameter for the [tag] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters) and the [tag template] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters) used to create the tag must be in the same organization.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.tags/create

parent <string> Required. The name of the resource to attach this tag to. Tags can be attached to entries or entry groups. An entry can have up to 1000 attached tags. Note: The tag and its child resources might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1Tag:
{:name string,
 :template string,
 :templateDisplayName string,
 :column string,
 :fields object}"
  [parent GoogleCloudDatacatalogV1Tag]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+parent}/tags",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1Tag}))

(defn projects-locations-entryGroups-tags-patch
  "Updates an existing tag.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.tags/patch

name <string> Identifier. The resource name of the tag in URL format where tag ID is a system-generated identifier. Note: The tag itself might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1Tag:
{:name string,
 :template string,
 :templateDisplayName string,
 :column string,
 :fields object}

optional:
updateMask <string> Names of fields whose values to overwrite on a tag. Currently, a tag has the only modifiable field with the name `fields`. In general, if this parameter is absent or empty, all modifiable fields are overwritten. If such fields are non-required and omitted in the request body, their values are emptied."
  ([name GoogleCloudDatacatalogV1Tag]
    (projects-locations-entryGroups-tags-patch
      name
      GoogleCloudDatacatalogV1Tag
      nil))
  ([name GoogleCloudDatacatalogV1Tag optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1Tag})))

(defn projects-locations-entryGroups-tags-delete
  "Deletes a tag.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.tags/delete

name <string> Required. The name of the tag to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-tags-list
  "Lists tags assigned to an Entry. The columns in the response are lowercased.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.tags/list

parent <string> Required. The name of the Data Catalog resource to list the tags of. The resource can be an Entry or an EntryGroup (without `/entries/{entries}` at the end).

optional:
pageSize <integer> The maximum number of tags to return. Default is 10. Maximum limit is 1000."
  ([parent] (projects-locations-entryGroups-tags-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/tags",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tagTemplates-create
  "Creates a tag template. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create

parent <string> Required. The name of the project and the template location [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
GoogleCloudDatacatalogV1TagTemplate:
{:name string,
 :displayName string,
 :isPubliclyReadable boolean,
 :fields object,
 :dataplexTransferStatus
 [DATAPLEX_TRANSFER_STATUS_UNSPECIFIED MIGRATED]}

optional:
tagTemplateId <string> Required. The ID of the tag template to create. The ID must contain only lowercase letters (a-z), numbers (0-9), or underscores (_), and must start with a letter or underscore. The maximum size is 64 bytes when encoded in UTF-8."
  ([parent GoogleCloudDatacatalogV1TagTemplate]
    (projects-locations-tagTemplates-create
      parent
      GoogleCloudDatacatalogV1TagTemplate
      nil))
  ([parent GoogleCloudDatacatalogV1TagTemplate optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/tagTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1TagTemplate})))

(defn projects-locations-tagTemplates-get
  "Gets a tag template.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/get

name <string> Required. The name of the tag template to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tagTemplates-patch
  "Updates a tag template. You can't update template fields with this method. These fields are separate resources with their own create, update, and delete methods. You must enable the Data Catalog API in the project identified by the `tag_template.name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/patch

name <string> Identifier. The resource name of the tag template in URL format. Note: The tag template itself and its child resources might not be stored in the location specified in its name.
GoogleCloudDatacatalogV1TagTemplate:
{:name string,
 :displayName string,
 :isPubliclyReadable boolean,
 :fields object,
 :dataplexTransferStatus
 [DATAPLEX_TRANSFER_STATUS_UNSPECIFIED MIGRATED]}

optional:
updateMask <string> Names of fields whose values to overwrite on a tag template. Currently, only `display_name` and `is_publicly_readable` can be overwritten. If this parameter is absent or empty, all modifiable fields are overwritten. If such fields are non-required and omitted in the request body, their values are emptied. Note: Updating the `is_publicly_readable` field may require up to 12 hours to take effect in search results."
  ([name GoogleCloudDatacatalogV1TagTemplate]
    (projects-locations-tagTemplates-patch
      name
      GoogleCloudDatacatalogV1TagTemplate
      nil))
  ([name GoogleCloudDatacatalogV1TagTemplate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1TagTemplate})))

(defn projects-locations-tagTemplates-delete
  "Deletes a tag template and all tags that use it. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/delete

name <string> Required. The name of the tag template to delete.

optional:
force <boolean> Required. If true, deletes all tags that use this template. Currently, `true` is the only supported value."
  ([name] (projects-locations-tagTemplates-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tagTemplates-setIamPolicy
  "Sets an access control policy for a resource. Replaces any existing policy. Supported resources are: - Tag templates - Entry groups Note: This method sets policies only within Data Catalog and can't be used to manage policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources synced with the Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-tagTemplates-getIamPolicy
  "Gets the access control policy for a resource. May return: * A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view it. * An empty policy if the resource exists but doesn't have a set policy. Supported resources are: - Tag templates - Entry groups Note: This method doesn't get policies from Google Cloud Platform resources ingested into Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-tagTemplates-testIamPermissions
  "Gets your permissions on a resource. Returns an empty set of permissions if the resource doesn't exist. Supported resources are: - Tag templates - Entry groups Note: This method gets policies only within Data Catalog and can't be used to get policies from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources ingested into Data Catalog. No Google IAM permissions are required to call this method.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-tagTemplates-fields-create
  "Creates a field in a tag template. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates.fields/create

parent <string> Required. The name of the project and the template location [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
GoogleCloudDatacatalogV1TagTemplateField:
{:name string,
 :displayName string,
 :type
 {:primitiveType
  [PRIMITIVE_TYPE_UNSPECIFIED DOUBLE STRING BOOL TIMESTAMP RICHTEXT],
  :enumType {:allowedValues [{:displayName string}]}},
 :isRequired boolean,
 :description string,
 :order integer}

optional:
tagTemplateFieldId <string> Required. The ID of the tag template field to create. Note: Adding a required field to an existing template is *not* allowed. Field IDs can contain letters (both uppercase and lowercase), numbers (0-9), underscores (_) and dashes (-). Field IDs must be at least 1 character long and at most 128 characters long. Field IDs must also be unique within their template."
  ([parent GoogleCloudDatacatalogV1TagTemplateField]
    (projects-locations-tagTemplates-fields-create
      parent
      GoogleCloudDatacatalogV1TagTemplateField
      nil))
  ([parent GoogleCloudDatacatalogV1TagTemplateField optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/fields",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1TagTemplateField})))

(defn projects-locations-tagTemplates-fields-patch
  "Updates a field in a tag template. You can't update the field type with this method. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates.fields/patch

name <string> Required. The name of the tag template field.
GoogleCloudDatacatalogV1TagTemplateField:
{:name string,
 :displayName string,
 :type
 {:primitiveType
  [PRIMITIVE_TYPE_UNSPECIFIED DOUBLE STRING BOOL TIMESTAMP RICHTEXT],
  :enumType {:allowedValues [{:displayName string}]}},
 :isRequired boolean,
 :description string,
 :order integer}

optional:
updateMask <string> Optional. Names of fields whose values to overwrite on an individual field of a tag template. The following fields are modifiable: * `display_name` * `type.enum_type` * `is_required` If this parameter is absent or empty, all modifiable fields are overwritten. If such fields are non-required and omitted in the request body, their values are emptied with one exception: when updating an enum type, the provided values are merged with the existing values. Therefore, enum values can only be added, existing enum values cannot be deleted or renamed. Additionally, updating a template field from optional to required is *not* allowed."
  ([name GoogleCloudDatacatalogV1TagTemplateField]
    (projects-locations-tagTemplates-fields-patch
      name
      GoogleCloudDatacatalogV1TagTemplateField
      nil))
  ([name GoogleCloudDatacatalogV1TagTemplateField optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1TagTemplateField})))

(defn projects-locations-tagTemplates-fields-rename
  "Renames a field in a tag template. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates.fields/rename

name <string> Required. The name of the tag template field.
GoogleCloudDatacatalogV1RenameTagTemplateFieldRequest:
{:newTagTemplateFieldId string}"
  [name GoogleCloudDatacatalogV1RenameTagTemplateFieldRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1RenameTagTemplateFieldRequest}))

(defn projects-locations-tagTemplates-fields-delete
  "Deletes a field in a tag template and all uses of this field from the tags based on this template. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates.fields/delete

name <string> Required. The name of the tag template field to delete.

optional:
force <boolean> Required. If true, deletes this field from any tags that use it. Currently, `true` is the only supported value."
  ([name] (projects-locations-tagTemplates-fields-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tagTemplates-fields-enumValues-rename
  "Renames an enum value in a tag template. Within a single enum field, enum values must be unique.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates.fields.enumValues/rename

name <string> Required. The name of the enum field value.
GoogleCloudDatacatalogV1RenameTagTemplateFieldEnumValueRequest:
{:newEnumValueDisplayName string}"
  [name GoogleCloudDatacatalogV1RenameTagTemplateFieldEnumValueRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDatacatalogV1RenameTagTemplateFieldEnumValueRequest}))

(defn projects-locations-taxonomies-get
  "Gets a taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/get

name <string> Required. Resource name of the taxonomy to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-taxonomies-setIamPolicy
  "Sets the IAM policy for a policy tag or a taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-taxonomies-patch
  "Updates a taxonomy, including its display name, description, and activated policy types.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/patch

name <string> Identifier. Resource name of this taxonomy in URL format. Note: Policy tag manager generates unique taxonomy IDs.
GoogleCloudDatacatalogV1Taxonomy:
{:name string,
 :displayName string,
 :description string,
 :policyTagCount integer,
 :taxonomyTimestamps
 {:createTime string, :updateTime string, :expireTime string},
 :activatedPolicyTypes
 [[POLICY_TYPE_UNSPECIFIED FINE_GRAINED_ACCESS_CONTROL]],
 :service
 {:name
  [MANAGING_SYSTEM_UNSPECIFIED
   MANAGING_SYSTEM_DATAPLEX
   MANAGING_SYSTEM_OTHER],
  :identity string}}

optional:
updateMask <string> Specifies fields to update. If not set, defaults to all fields you can update. For more information, see [FieldMask] (https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask)."
  ([name GoogleCloudDatacatalogV1Taxonomy]
    (projects-locations-taxonomies-patch
      name
      GoogleCloudDatacatalogV1Taxonomy
      nil))
  ([name GoogleCloudDatacatalogV1Taxonomy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1Taxonomy})))

(defn projects-locations-taxonomies-testIamPermissions
  "Returns your permissions on a specified policy tag or taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-taxonomies-replace
  "Replaces (updates) a taxonomy and all its policy tags. The taxonomy and its entire hierarchy of policy tags must be represented literally by `SerializedTaxonomy` and the nested `SerializedPolicyTag` messages. This operation automatically does the following: - Deletes the existing policy tags that are missing from the `SerializedPolicyTag`. - Creates policy tags that don't have resource names. They are considered new. - Updates policy tags with valid resources names accordingly.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/replace

name <string> Required. Resource name of the taxonomy to update.
GoogleCloudDatacatalogV1ReplaceTaxonomyRequest:
{:serializedTaxonomy
 {:displayName string,
  :description string,
  :policyTags
  [{:policyTag string,
    :displayName string,
    :description string,
    :childPolicyTags
    [{:policyTag string,
      :displayName string,
      :description string,
      :childPolicyTags
      [{:policyTag string,
        :displayName string,
        :description string,
        :childPolicyTags
        [GoogleCloudDatacatalogV1SerializedPolicyTag]}]}]}],
  :activatedPolicyTypes
  [[POLICY_TYPE_UNSPECIFIED FINE_GRAINED_ACCESS_CONTROL]]}}"
  [name GoogleCloudDatacatalogV1ReplaceTaxonomyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+name}:replace",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1ReplaceTaxonomyRequest}))

(defn projects-locations-taxonomies-create
  "Creates a taxonomy in a specified project. The taxonomy is initially empty, that is, it doesn't contain policy tags.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/create

parent <string> Required. Resource name of the project that the taxonomy will belong to.
GoogleCloudDatacatalogV1Taxonomy:
{:name string,
 :displayName string,
 :description string,
 :policyTagCount integer,
 :taxonomyTimestamps
 {:createTime string, :updateTime string, :expireTime string},
 :activatedPolicyTypes
 [[POLICY_TYPE_UNSPECIFIED FINE_GRAINED_ACCESS_CONTROL]],
 :service
 {:name
  [MANAGING_SYSTEM_UNSPECIFIED
   MANAGING_SYSTEM_DATAPLEX
   MANAGING_SYSTEM_OTHER],
  :identity string}}"
  [parent GoogleCloudDatacatalogV1Taxonomy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+parent}/taxonomies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1Taxonomy}))

(defn projects-locations-taxonomies-delete
  "Deletes a taxonomy, including all policy tags in this taxonomy, their associated policies, and the policy tags references from BigQuery columns.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/delete

name <string> Required. Resource name of the taxonomy to delete. Note: All policy tags in this taxonomy are also deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-taxonomies-export
  "Exports taxonomies in the requested type and returns them, including their policy tags. The requested taxonomies must belong to the same project. This method generates `SerializedTaxonomy` protocol buffers with nested policy tags that can be used as input for `ImportTaxonomies` calls.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/export

parent <string> Required. Resource name of the project that the exported taxonomies belong to.

optional:
taxonomies <string> Required. Resource names of the taxonomies to export.
serializedTaxonomies <boolean> Serialized export taxonomies that contain all the policy tags as nested protocol buffers."
  ([parent] (projects-locations-taxonomies-export parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/taxonomies:export",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-taxonomies-getIamPolicy
  "Gets the IAM policy for a policy tag or a taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-taxonomies-list
  "Lists all taxonomies in a project in a particular location that you have a permission to view.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/list

parent <string> Required. Resource name of the project to list the taxonomies of.

optional:
pageSize <integer> The maximum number of items to return. Must be a value between 1 and 1000 inclusively. If not set, defaults to 50.
filter <string> Supported field for filter is 'service' and value is 'dataplex'. Eg: service=dataplex."
  ([parent] (projects-locations-taxonomies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/taxonomies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-taxonomies-import
  "Creates new taxonomies (including their policy tags) in a given project by importing from inlined or cross-regional sources. For a cross-regional source, new taxonomies are created by copying from a source in another region. For an inlined source, taxonomies and policy tags are created in bulk using nested protocol buffer structures.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies/import

parent <string> Required. Resource name of project that the imported taxonomies will belong to.
GoogleCloudDatacatalogV1ImportTaxonomiesRequest:
{:inlineSource
 {:taxonomies
  [{:displayName string,
    :description string,
    :policyTags
    [{:policyTag string,
      :displayName string,
      :description string,
      :childPolicyTags
      [{:policyTag string,
        :displayName string,
        :description string,
        :childPolicyTags
        [GoogleCloudDatacatalogV1SerializedPolicyTag]}]}],
    :activatedPolicyTypes
    [[POLICY_TYPE_UNSPECIFIED FINE_GRAINED_ACCESS_CONTROL]]}]},
 :crossRegionalSource {:taxonomy string}}"
  [parent GoogleCloudDatacatalogV1ImportTaxonomiesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+parent}/taxonomies:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1ImportTaxonomiesRequest}))

(defn projects-locations-taxonomies-policyTags-create
  "Creates a policy tag in a taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/create

parent <string> Required. Resource name of the taxonomy that the policy tag will belong to.
GoogleCloudDatacatalogV1PolicyTag:
{:name string,
 :displayName string,
 :description string,
 :parentPolicyTag string,
 :childPolicyTags [string]}"
  [parent GoogleCloudDatacatalogV1PolicyTag]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+parent}/policyTags",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1PolicyTag}))

(defn projects-locations-taxonomies-policyTags-delete
  "Deletes a policy tag together with the following: * All of its descendant policy tags, if any * Policies associated with the policy tag and its descendants * References from BigQuery table schema of the policy tag and its descendants
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/delete

name <string> Required. Resource name of the policy tag to delete. Note: All of its descendant policy tags are also deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-taxonomies-policyTags-patch
  "Updates a policy tag, including its display name, description, and parent policy tag.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/patch

name <string> Identifier. Resource name of this policy tag in the URL format. The policy tag manager generates unique taxonomy IDs and policy tag IDs.
GoogleCloudDatacatalogV1PolicyTag:
{:name string,
 :displayName string,
 :description string,
 :parentPolicyTag string,
 :childPolicyTags [string]}

optional:
updateMask <string> Specifies the fields to update. You can update only display name, description, and parent policy tag. If not set, defaults to all updatable fields. For more information, see [FieldMask] (https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask)."
  ([name GoogleCloudDatacatalogV1PolicyTag]
    (projects-locations-taxonomies-policyTags-patch
      name
      GoogleCloudDatacatalogV1PolicyTag
      nil))
  ([name GoogleCloudDatacatalogV1PolicyTag optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDatacatalogV1PolicyTag})))

(defn projects-locations-taxonomies-policyTags-list
  "Lists all policy tags in a taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/list

parent <string> Required. Resource name of the taxonomy to list the policy tags of.

optional:
pageSize <integer> The maximum number of items to return. Must be a value between 1 and 1000 inclusively. If not set, defaults to 50."
  ([parent] (projects-locations-taxonomies-policyTags-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/{+parent}/policyTags",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-taxonomies-policyTags-get
  "Gets a policy tag.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/get

name <string> Required. Resource name of the policy tag."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datacatalog.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-taxonomies-policyTags-getIamPolicy
  "Gets the IAM policy for a policy tag or a taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-taxonomies-policyTags-setIamPolicy
  "Sets the IAM policy for a policy tag or a taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-taxonomies-policyTags-testIamPermissions
  "Returns your permissions on a specified policy tag or taxonomy.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.taxonomies.policyTags/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn catalog-search
  "Searches Data Catalog for multiple resources like entries and tags that match a query. This is a [Custom Method] (https://cloud.google.com/apis/design/custom_methods) that doesn't return all information on a resource, only its ID and high level fields. To get more information, you can subsequently call specific get methods. Note: Data Catalog search queries don't guarantee full recall. Results that match your query might not be returned, even in subsequent result pages. Additionally, returned (and not returned) results can vary if you repeat search queries. For more information, see [Data Catalog search syntax] (https://cloud.google.com/data-catalog/docs/how-to/search-reference).
https://cloud.google.com/data-catalog/docs/reference/rest/v1/catalog/search

GoogleCloudDatacatalogV1SearchCatalogRequest:
{:scope
 {:includeOrgIds [string],
  :includeProjectIds [string],
  :includeGcpPublicDatasets boolean,
  :restrictedLocations [string],
  :starredOnly boolean,
  :includePublicTagTemplates boolean},
 :query string,
 :pageSize integer,
 :pageToken string,
 :orderBy string,
 :adminSearch boolean}"
  [GoogleCloudDatacatalogV1SearchCatalogRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datacatalog.googleapis.com/v1/catalog:search",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDatacatalogV1SearchCatalogRequest}))

(defn entries-lookup
  "Gets an entry by its target resource name. The resource name comes from the source Google Cloud Platform service.
https://cloud.google.com/data-catalog/docs/reference/rest/v1/entries/lookup

optional:
linkedResource <string> The full name of the Google Cloud Platform resource the Data Catalog entry represents. For more information, see [Full Resource Name] (https://cloud.google.com/apis/design/resource_names#full_resource_name). Full names are case-sensitive. For example: * `//bigquery.googleapis.com/projects/{PROJECT_ID}/datasets/{DATASET_ID}/tables/{TABLE_ID}` * `//pubsub.googleapis.com/projects/{PROJECT_ID}/topics/{TOPIC_ID}`
sqlResource <string> The SQL name of the entry. SQL names are case-sensitive. Examples: * `pubsub.topic.{PROJECT_ID}.{TOPIC_ID}` * `pubsub.topic.{PROJECT_ID}.`\\``{TOPIC.ID.SEPARATED.WITH.DOTS}`\\` * `bigquery.table.{PROJECT_ID}.{DATASET_ID}.{TABLE_ID}` * `bigquery.dataset.{PROJECT_ID}.{DATASET_ID}` * `datacatalog.entry.{PROJECT_ID}.{LOCATION_ID}.{ENTRY_GROUP_ID}.{ENTRY_ID}` Identifiers (`*_ID`) should comply with the [Lexical structure in Standard SQL] (https://cloud.google.com/bigquery/docs/reference/standard-sql/lexical).
fullyQualifiedName <string> [Fully Qualified Name (FQN)](https://cloud.google.com//data-catalog/docs/fully-qualified-names) of the resource. FQNs take two forms: * For non-regionalized resources: `{SYSTEM}:{PROJECT}.{PATH_TO_RESOURCE_SEPARATED_WITH_DOTS}` * For regionalized resources: `{SYSTEM}:{PROJECT}.{LOCATION_ID}.{PATH_TO_RESOURCE_SEPARATED_WITH_DOTS}` Example for a DPMS table: `dataproc_metastore:{PROJECT_ID}.{LOCATION_ID}.{INSTANCE_ID}.{DATABASE_ID}.{TABLE_ID}`
project <string> Project where the lookup should be performed. Required to lookup entry that is not a part of `DPMS` or `DATAPLEX` `integrated_system` using its `fully_qualified_name`. Ignored in other cases.
location <string> Location where the lookup should be performed. Required to lookup entry that is not a part of `DPMS` or `DATAPLEX` `integrated_system` using its `fully_qualified_name`. Ignored in other cases."
  ([] (entries-lookup nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datacatalog.googleapis.com/v1/entries:lookup",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

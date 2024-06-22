(ns happygapi2.biglake
  "BigLake API
The BigLake API provides access to BigLake Metastore, a serverless, fully managed, and highly available metastore for open-source data that can be used for querying Apache Iceberg tables in BigQuery.
See: https://cloud.google.com/bigquery/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-catalogs-create
  "Creates a new catalog.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs/create

parent <string> Required. The parent resource where this catalog will be created. Format: projects/{project_id_or_number}/locations/{location_id}
Catalog:
{:name string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :expireTime string}

optional:
catalogId <string> Required. The ID to use for the catalog, which will become the final component of the catalog's resource name."
  ([parent Catalog]
    (projects-locations-catalogs-create parent Catalog nil))
  ([parent Catalog optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://biglake.googleapis.com/v1/{+parent}/catalogs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Catalog})))

(defn projects-locations-catalogs-delete
  "Deletes an existing catalog specified by the catalog ID.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs/delete

name <string> Required. The name of the catalog to delete. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://biglake.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-catalogs-get
  "Gets the catalog specified by the resource name.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs/get

name <string> Required. The name of the catalog to retrieve. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://biglake.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-catalogs-list
  "List all catalogs in a specified project.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs/list

parent <string> Required. The parent, which owns this collection of catalogs. Format: projects/{project_id_or_number}/locations/{location_id}

optional:
pageSize <integer> The maximum number of catalogs to return. The service may return fewer than this value. If unspecified, at most 50 catalogs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-catalogs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://biglake.googleapis.com/v1/{+parent}/catalogs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-catalogs-databases-create
  "Creates a new database.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases/create

parent <string> Required. The parent resource where this database will be created. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
Database:
{:hiveOptions {:locationUri string, :parameters object},
 :name string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :expireTime string,
 :type [TYPE_UNSPECIFIED HIVE]}

optional:
databaseId <string> Required. The ID to use for the database, which will become the final component of the database's resource name."
  ([parent Database]
    (projects-locations-catalogs-databases-create parent Database nil))
  ([parent Database optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://biglake.googleapis.com/v1/{+parent}/databases",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Database})))

(defn projects-locations-catalogs-databases-delete
  "Deletes an existing database specified by the database ID.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases/delete

name <string> Required. The name of the database to delete. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://biglake.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-catalogs-databases-patch
  "Updates an existing database specified by the database ID.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases/patch

name <string> Output only. The resource name. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
Database:
{:hiveOptions {:locationUri string, :parameters object},
 :name string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :expireTime string,
 :type [TYPE_UNSPECIFIED HIVE]}

optional:
updateMask <string> The list of fields to update. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If not set, defaults to all of the fields that are allowed to update."
  ([name Database]
    (projects-locations-catalogs-databases-patch name Database nil))
  ([name Database optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://biglake.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Database})))

(defn projects-locations-catalogs-databases-get
  "Gets the database specified by the resource name.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases/get

name <string> Required. The name of the database to retrieve. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://biglake.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-catalogs-databases-list
  "List all databases in a specified catalog.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases/list

parent <string> Required. The parent, which owns this collection of databases. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}

optional:
pageSize <integer> The maximum number of databases to return. The service may return fewer than this value. If unspecified, at most 50 databases will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-catalogs-databases-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://biglake.googleapis.com/v1/{+parent}/databases",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-catalogs-databases-tables-create
  "Creates a new table.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases.tables/create

parent <string> Required. The parent resource where this table will be created. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
Table:
{:hiveOptions
 {:parameters object,
  :tableType string,
  :storageDescriptor
  {:locationUri string,
   :inputFormat string,
   :outputFormat string,
   :serdeInfo {:serializationLib string}}},
 :name string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :expireTime string,
 :type [TYPE_UNSPECIFIED HIVE],
 :etag string}

optional:
tableId <string> Required. The ID to use for the table, which will become the final component of the table's resource name."
  ([parent Table]
    (projects-locations-catalogs-databases-tables-create
      parent
      Table
      nil))
  ([parent Table optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://biglake.googleapis.com/v1/{+parent}/tables",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Table})))

(defn projects-locations-catalogs-databases-tables-delete
  "Deletes an existing table specified by the table ID.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases.tables/delete

name <string> Required. The name of the table to delete. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://biglake.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-catalogs-databases-tables-patch
  "Updates an existing table specified by the table ID.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases.tables/patch

name <string> Output only. The resource name. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
Table:
{:hiveOptions
 {:parameters object,
  :tableType string,
  :storageDescriptor
  {:locationUri string,
   :inputFormat string,
   :outputFormat string,
   :serdeInfo {:serializationLib string}}},
 :name string,
 :createTime string,
 :updateTime string,
 :deleteTime string,
 :expireTime string,
 :type [TYPE_UNSPECIFIED HIVE],
 :etag string}

optional:
updateMask <string> The list of fields to update. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If not set, defaults to all of the fields that are allowed to update."
  ([name Table]
    (projects-locations-catalogs-databases-tables-patch
      name
      Table
      nil))
  ([name Table optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://biglake.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Table})))

(defn projects-locations-catalogs-databases-tables-rename
  "Renames an existing table specified by the table ID.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases.tables/rename

name <string> Required. The table's `name` field is used to identify the table to rename. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
RenameTableRequest:
{:newName string}"
  [name RenameTableRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://biglake.googleapis.com/v1/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body RenameTableRequest}))

(defn projects-locations-catalogs-databases-tables-get
  "Gets the table specified by the resource name.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases.tables/get

name <string> Required. The name of the table to retrieve. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://biglake.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-catalogs-databases-tables-list
  "List all tables in a specified database.
https://cloud.google.com/bigquery/docs/reference/biglake/rest/v1/projects.locations.catalogs.databases.tables/list

parent <string> Required. The parent, which owns this collection of tables. Format: projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}

optional:
pageSize <integer> The maximum number of tables to return. The service may return fewer than this value. If unspecified, at most 50 tables will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
view <string> The view for the returned tables."
  ([parent]
    (projects-locations-catalogs-databases-tables-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://biglake.googleapis.com/v1/{+parent}/tables",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

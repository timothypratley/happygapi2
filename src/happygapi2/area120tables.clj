(ns happygapi2.area120tables
  "Area120 Tables API

See: https://support.google.com/area120-tables/answer/10011390"
  (:require [happy.oauth2.client :as client]))

(defn workspaces-list
  "Lists workspaces for the user.
https://support.google.com/area120-tables/answer/10011390

optional:
pageSize <integer> The maximum number of workspaces to return. The service may return fewer than this value. If unspecified, at most 10 workspaces are returned. The maximum value is 25; values above 25 are coerced to 25."
  ([] (workspaces-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://area120tables.googleapis.com/v1alpha1/workspaces",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/spreadsheets.readonly"
        "https://www.googleapis.com/auth/tables"]})))

(defn workspaces-get
  "Gets a workspace. Returns NOT_FOUND if the workspace does not exist.
https://support.google.com/area120-tables/answer/10011390

name <string> Required. The name of the workspace to retrieve. Format: workspaces/{workspace}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://area120tables.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/spreadsheets.readonly"
      "https://www.googleapis.com/auth/tables"]}))

(defn tables-get
  "Gets a table. Returns NOT_FOUND if the table does not exist.
https://support.google.com/area120-tables/answer/10011390

name <string> Required. The name of the table to retrieve. Format: tables/{table}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://area120tables.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/drive.readonly"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/spreadsheets.readonly"
      "https://www.googleapis.com/auth/tables"]}))

(defn tables-list
  "Lists tables for the user.
https://support.google.com/area120-tables/answer/10011390

optional:
pageSize <integer> The maximum number of tables to return. The service may return fewer than this value. If unspecified, at most 20 tables are returned. The maximum value is 100; values above 100 are coerced to 100.
orderBy <string> Optional. Sorting order for the list of tables on createTime/updateTime."
  ([] (tables-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://area120tables.googleapis.com/v1alpha1/tables",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/spreadsheets.readonly"
        "https://www.googleapis.com/auth/tables"]})))

(defn tables-rows-list
  "Lists rows in a table. Returns NOT_FOUND if the table does not exist.
https://support.google.com/area120-tables/answer/10011390

parent <string> Required. The parent table. Format: tables/{table}

optional:
orderBy <string> Optional. Sorting order for the list of rows on createTime/updateTime.
pageSize <integer> The maximum number of rows to return. The service may return fewer than this value. If unspecified, at most 50 rows are returned. The maximum value is 1,000; values above 1,000 are coerced to 1,000.
view <string> Optional. Column key to use for values in the row. Defaults to user entered name.
filter <string> Optional. Filter to only include resources matching the requirements. For more information, see [Filtering list results](https://support.google.com/area120-tables/answer/10503371)."
  ([parent] (tables-rows-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://area120tables.googleapis.com/v1alpha1/{+parent}/rows",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/spreadsheets.readonly"
        "https://www.googleapis.com/auth/tables"]})))

(defn tables-rows-patch
  "Updates a row.
https://support.google.com/area120-tables/answer/10011390

name <string> The resource name of the row. Row names have the form `tables/{table}/rows/{row}`. The name is ignored when creating a row.
Row:
{:updateTime string, :name string, :values object, :createTime string}

optional:
updateMask <string> The list of fields to update.
view <string> Optional. Column key to use for values in the row. Defaults to user entered name."
  ([name Row] (tables-rows-patch name Row nil))
  ([name Row optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://area120tables.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/tables"],
       :body Row})))

(defn tables-rows-delete
  "Deletes a row.
https://support.google.com/area120-tables/answer/10011390

name <string> Required. The name of the row to delete. Format: tables/{table}/rows/{row}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://area120tables.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/tables"]}))

(defn tables-rows-batchCreate
  "Creates multiple rows.
https://support.google.com/area120-tables/answer/10011390

parent <string> Required. The parent table where the rows will be created. Format: tables/{table}
BatchCreateRowsRequest:
{:requests
 [{:view [VIEW_UNSPECIFIED COLUMN_ID_VIEW],
   :parent string,
   :row
   {:updateTime string,
    :name string,
    :values object,
    :createTime string}}]}"
  [parent BatchCreateRowsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://area120tables.googleapis.com/v1alpha1/{+parent}/rows:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/tables"],
     :body BatchCreateRowsRequest}))

(defn tables-rows-batchUpdate
  "Updates multiple rows.
https://support.google.com/area120-tables/answer/10011390

parent <string> Required. The parent table shared by all rows being updated. Format: tables/{table}
BatchUpdateRowsRequest:
{:requests
 [{:view [VIEW_UNSPECIFIED COLUMN_ID_VIEW],
   :updateMask string,
   :row
   {:updateTime string,
    :name string,
    :values object,
    :createTime string}}]}"
  [parent BatchUpdateRowsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://area120tables.googleapis.com/v1alpha1/{+parent}/rows:batchUpdate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/tables"],
     :body BatchUpdateRowsRequest}))

(defn tables-rows-create
  "Creates a row.
https://support.google.com/area120-tables/answer/10011390

parent <string> Required. The parent table where this row will be created. Format: tables/{table}
Row:
{:updateTime string, :name string, :values object, :createTime string}

optional:
view <string> Optional. Column key to use for values in the row. Defaults to user entered name."
  ([parent Row] (tables-rows-create parent Row nil))
  ([parent Row optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://area120tables.googleapis.com/v1alpha1/{+parent}/rows",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/tables"],
       :body Row})))

(defn tables-rows-batchDelete
  "Deletes multiple rows.
https://support.google.com/area120-tables/answer/10011390

parent <string> Required. The parent table shared by all rows being deleted. Format: tables/{table}
BatchDeleteRowsRequest:
{:names [string]}"
  [parent BatchDeleteRowsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://area120tables.googleapis.com/v1alpha1/{+parent}/rows:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/drive.file"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/tables"],
     :body BatchDeleteRowsRequest}))

(defn tables-rows-get
  "Gets a row. Returns NOT_FOUND if the row does not exist in the table.
https://support.google.com/area120-tables/answer/10011390

name <string> Required. The name of the row to retrieve. Format: tables/{table}/rows/{row}

optional:
view <string> Optional. Column key to use for values in the row. Defaults to user entered name."
  ([name] (tables-rows-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://area120tables.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive"
        "https://www.googleapis.com/auth/drive.file"
        "https://www.googleapis.com/auth/drive.readonly"
        "https://www.googleapis.com/auth/spreadsheets"
        "https://www.googleapis.com/auth/spreadsheets.readonly"
        "https://www.googleapis.com/auth/tables"]})))

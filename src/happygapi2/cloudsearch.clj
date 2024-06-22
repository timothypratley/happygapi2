(ns happygapi2.cloudsearch
  "Cloud Search API
Cloud Search provides cloud-based search capabilities over Google Workspace data. The Cloud Search API allows indexing of non-Google Workspace data into Cloud Search.
See: https://developers.google.com/cloud-search/docs/guides/"
  (:require [happy.oauth2.client :as client]))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://developers.google.com/cloud-search/docs/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudsearch.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.debug"
      "https://www.googleapis.com/auth/cloud_search.indexing"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.indexing"
      "https://www.googleapis.com/auth/cloud_search.settings.query"]}))

(defn operations-lro-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://developers.google.com/cloud-search/docs/reference/rest/v1/operations.lro/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-lro-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/{+name}/lro",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.debug"
        "https://www.googleapis.com/auth/cloud_search.indexing"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"
        "https://www.googleapis.com/auth/cloud_search.settings.query"]})))

(defn debug-datasources-items-checkAccess
  "Checks whether an item is accessible by specified principal. Principal must be a user; groups and domain values aren't supported. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/debug.datasources.items/checkAccess

name <string> Item name, format: datasources/{source_id}/items/{item_id}
Principal:
{:gsuitePrincipal
 {:gsuiteUserEmail string,
  :gsuiteGroupEmail string,
  :gsuiteDomain boolean},
 :userResourceName string,
 :groupResourceName string}

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name Principal]
    (debug-datasources-items-checkAccess name Principal nil))
  ([name Principal optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/debug/{+name}:checkAccess",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.debug"],
       :body Principal})))

(defn debug-datasources-items-searchByViewUrl
  "Fetches the item whose viewUrl exactly matches that of the URL provided in the request. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/debug.datasources.items/searchByViewUrl

name <string> Source name, format: datasources/{source_id}
SearchItemsByViewUrlRequest:
{:viewUrl string,
 :pageToken string,
 :debugOptions {:enableDebugging boolean}}"
  [name SearchItemsByViewUrlRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/debug/{+name}/items:searchByViewUrl",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.debug"],
     :body SearchItemsByViewUrlRequest}))

(defn debug-datasources-items-unmappedids-list
  "List all unmapped identities for a specific item. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/debug.datasources.items.unmappedids/list

parent <string> The name of the item, in the following format: datasources/{source_id}/items/{ID}

optional:
pageSize <integer> Maximum number of items to fetch in a request. Defaults to 100.
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([parent] (debug-datasources-items-unmappedids-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/debug/{+parent}/unmappedids",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.debug"]})))

(defn debug-identitysources-unmappedids-list
  "Lists unmapped user identities for an identity source. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/debug.identitysources.unmappedids/list

parent <string> The name of the identity source, in the following format: identitysources/{source_id}

optional:
resolutionStatusCode <string> Limit users selection to this status.
pageSize <integer> Maximum number of items to fetch in a request. Defaults to 100.
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([parent] (debug-identitysources-unmappedids-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/debug/{+parent}/unmappedids",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.debug"]})))

(defn debug-identitysources-items-listForunmappedidentity
  "Lists names of items associated with an unmapped identity. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/debug.identitysources.items/listForunmappedidentity

parent <string> The name of the identity source, in the following format: identitysources/{source_id}}

optional:
userResourceName <string> 
groupResourceName <string> 
pageSize <integer> Maximum number of items to fetch in a request. Defaults to 100.
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([parent]
    (debug-identitysources-items-listForunmappedidentity parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/debug/{+parent}/items:forunmappedidentity",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.debug"]})))

(defn settings-getCustomer
  "Get customer settings. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings/getCustomer"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/settings/customer",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}))

(defn settings-updateCustomer
  "Update customer settings. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings/updateCustomer

CustomerSettings:
{:vpcSettings {:project string},
 :auditLoggingSettings
 {:project string,
  :logAdminReadActions boolean,
  :logDataWriteActions boolean,
  :logDataReadActions boolean}}

optional:
updateMask <string> Update mask to control which fields get updated. If you specify a field in the update_mask but don't specify its value here, that field will be cleared. If the mask is not present or empty, all fields will be updated. Currently supported field paths: vpc_settings and audit_logging_settings"
  ([CustomerSettings] (settings-updateCustomer CustomerSettings nil))
  ([CustomerSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/customer",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"],
       :body CustomerSettings})))

(defn settings-searchapplications-list
  "Lists all search applications. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/list

optional:
pageSize <integer> The maximum number of items to return.
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([] (settings-searchapplications-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/searchapplications",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.query"]})))

(defn settings-searchapplications-get
  "Gets the specified search application. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/get

name <string> The name of the search application. Format: searchapplications/{application_id}.

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (settings-searchapplications-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.query"]})))

(defn settings-searchapplications-create
  "Creates a search application. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/create

SearchApplication:
{:operationIds [string],
 :enableAuditLog boolean,
 :defaultSortOptions
 {:operatorName string, :sortOrder [ASCENDING DESCENDING]},
 :displayName string,
 :name string,
 :scoringConfig
 {:disableFreshness boolean, :disablePersonalization boolean},
 :dataSourceRestrictions
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :filterOptions
   [{:objectType string,
     :filter
     {:valueFilter {:operatorName string, :value Value},
      :compositeFilter
      {:logicOperator [AND OR NOT], :subFilters [Filter]}}}]}],
 :defaultFacetOptions
 [{:sourceName string,
   :objectType string,
   :operatorName string,
   :numFacetBuckets integer,
   :integerFacetingOptions {:integerBuckets [string]}}],
 :queryInterpretationConfig
 {:forceVerbatimMode boolean,
  :forceDisableSupplementalResults boolean},
 :sourceConfig
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :scoringConfig {:sourceImportance [DEFAULT LOW HIGH]},
   :crowdingConfig {:numResults integer, :numSuggestions integer}}],
 :returnResultThumbnailUrls boolean}"
  [SearchApplication]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/settings/searchapplications",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.query"],
     :body SearchApplication}))

(defn settings-searchapplications-update
  "Updates a search application. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/update

name <string> The name of the Search Application. Format: searchapplications/{application_id}.
SearchApplication:
{:operationIds [string],
 :enableAuditLog boolean,
 :defaultSortOptions
 {:operatorName string, :sortOrder [ASCENDING DESCENDING]},
 :displayName string,
 :name string,
 :scoringConfig
 {:disableFreshness boolean, :disablePersonalization boolean},
 :dataSourceRestrictions
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :filterOptions
   [{:objectType string,
     :filter
     {:valueFilter {:operatorName string, :value Value},
      :compositeFilter
      {:logicOperator [AND OR NOT], :subFilters [Filter]}}}]}],
 :defaultFacetOptions
 [{:sourceName string,
   :objectType string,
   :operatorName string,
   :numFacetBuckets integer,
   :integerFacetingOptions {:integerBuckets [string]}}],
 :queryInterpretationConfig
 {:forceVerbatimMode boolean,
  :forceDisableSupplementalResults boolean},
 :sourceConfig
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :scoringConfig {:sourceImportance [DEFAULT LOW HIGH]},
   :crowdingConfig {:numResults integer, :numSuggestions integer}}],
 :returnResultThumbnailUrls boolean}

optional:
updateMask <string> Only applies to [`settings.searchapplications.patch`](https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/patch). Update mask to control which fields to update. Example field paths: `search_application.name`, `search_application.displayName`. * If `update_mask` is non-empty, then only the fields specified in the `update_mask` are updated. * If you specify a field in the `update_mask`, but don't specify its value in the `search_application`, then that field is cleared. * If the `update_mask` is not present or empty or has the value `*`, then all fields are updated."
  ([name SearchApplication]
    (settings-searchapplications-update name SearchApplication nil))
  ([name SearchApplication optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.query"],
       :body SearchApplication})))

(defn settings-searchapplications-patch
  "Updates a search application. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/patch

name <string> The name of the Search Application. Format: searchapplications/{application_id}.
SearchApplication:
{:operationIds [string],
 :enableAuditLog boolean,
 :defaultSortOptions
 {:operatorName string, :sortOrder [ASCENDING DESCENDING]},
 :displayName string,
 :name string,
 :scoringConfig
 {:disableFreshness boolean, :disablePersonalization boolean},
 :dataSourceRestrictions
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :filterOptions
   [{:objectType string,
     :filter
     {:valueFilter {:operatorName string, :value Value},
      :compositeFilter
      {:logicOperator [AND OR NOT], :subFilters [Filter]}}}]}],
 :defaultFacetOptions
 [{:sourceName string,
   :objectType string,
   :operatorName string,
   :numFacetBuckets integer,
   :integerFacetingOptions {:integerBuckets [string]}}],
 :queryInterpretationConfig
 {:forceVerbatimMode boolean,
  :forceDisableSupplementalResults boolean},
 :sourceConfig
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :scoringConfig {:sourceImportance [DEFAULT LOW HIGH]},
   :crowdingConfig {:numResults integer, :numSuggestions integer}}],
 :returnResultThumbnailUrls boolean}

optional:
updateMask <string> Only applies to [`settings.searchapplications.patch`](https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/patch). Update mask to control which fields to update. Example field paths: `search_application.name`, `search_application.displayName`. * If `update_mask` is non-empty, then only the fields specified in the `update_mask` are updated. * If you specify a field in the `update_mask`, but don't specify its value in the `search_application`, then that field is cleared. * If the `update_mask` is not present or empty or has the value `*`, then all fields are updated."
  ([name SearchApplication]
    (settings-searchapplications-patch name SearchApplication nil))
  ([name SearchApplication optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.query"],
       :body SearchApplication})))

(defn settings-searchapplications-delete
  "Deletes a search application. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/delete

name <string> The name of the search application to be deleted. Format: applications/{application_id}.

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (settings-searchapplications-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.query"]})))

(defn settings-searchapplications-reset
  "Resets a search application to default settings. This will return an empty response. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.searchapplications/reset

name <string> The name of the search application to be reset. Format: applications/{application_id}.
ResetSearchApplicationRequest:
{:debugOptions {:enableDebugging boolean}}"
  [name ResetSearchApplicationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/settings/{+name}:reset",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.query"],
     :body ResetSearchApplicationRequest}))

(defn settings-datasources-create
  "Creates a datasource. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.datasources/create

DataSource:
{:operationIds [string],
 :displayName string,
 :name string,
 :returnThumbnailUrls boolean,
 :shortName string,
 :indexingServiceAccounts [string],
 :disableServing boolean,
 :disableModifications boolean,
 :itemsVisibility
 [{:gsuiteUserEmail string,
   :gsuiteGroupEmail string,
   :gsuiteDomain boolean}]}"
  [DataSource]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/settings/datasources",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.indexing"],
     :body DataSource}))

(defn settings-datasources-delete
  "Deletes a datasource. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.datasources/delete

name <string> The name of the datasource. Format: datasources/{source_id}.

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (settings-datasources-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"]})))

(defn settings-datasources-get
  "Gets a datasource. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.datasources/get

name <string> The name of the datasource resource. Format: datasources/{source_id}.

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (settings-datasources-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"]})))

(defn settings-datasources-update
  "Updates a datasource. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.datasources/update

name <string> The name of the datasource resource. Format: datasources/{source_id}. The name is ignored when creating a datasource.
UpdateDataSourceRequest:
{:source
 {:operationIds [string],
  :displayName string,
  :name string,
  :returnThumbnailUrls boolean,
  :shortName string,
  :indexingServiceAccounts [string],
  :disableServing boolean,
  :disableModifications boolean,
  :itemsVisibility
  [{:gsuiteUserEmail string,
    :gsuiteGroupEmail string,
    :gsuiteDomain boolean}]},
 :debugOptions {:enableDebugging boolean},
 :updateMask string}"
  [name UpdateDataSourceRequest]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/settings/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.indexing"],
     :body UpdateDataSourceRequest}))

(defn settings-datasources-patch
  "Updates a datasource. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.datasources/patch

name <string> The name of the datasource resource. Format: datasources/{source_id}. The name is ignored when creating a datasource.
DataSource:
{:operationIds [string],
 :displayName string,
 :name string,
 :returnThumbnailUrls boolean,
 :shortName string,
 :indexingServiceAccounts [string],
 :disableServing boolean,
 :disableModifications boolean,
 :itemsVisibility
 [{:gsuiteUserEmail string,
   :gsuiteGroupEmail string,
   :gsuiteDomain boolean}]}

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field.
updateMask <string> Only applies to [`settings.datasources.patch`](https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.datasources/patch). Update mask to control which fields to update. Example field paths: `name`, `displayName`. * If `update_mask` is non-empty, then only the fields specified in the `update_mask` are updated. * If you specify a field in the `update_mask`, but don't specify its value in the source, that field is cleared. * If the `update_mask` is not present or empty or has the value `*`, then all fields are updated."
  ([name DataSource] (settings-datasources-patch name DataSource nil))
  ([name DataSource optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"],
       :body DataSource})))

(defn settings-datasources-list
  "Lists datasources. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/settings.datasources/list

optional:
pageSize <integer> Maximum number of datasources to fetch in a request. The max value is 1000. The default value is 1000.
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([] (settings-datasources-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/settings/datasources",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"]})))

(defn initializeCustomer
  "Enables `third party` support in Google Cloud Search. **Note:** This API requires an admin account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1//initializeCustomer

InitializeCustomerRequest:
object"
  [InitializeCustomerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1:initializeCustomer",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.indexing"],
     :body InitializeCustomerRequest}))

(defn indexing-datasources-updateSchema
  "Updates the schema of a data source. This method does not perform incremental updates to the schema. Instead, this method updates the schema by overwriting the entire schema. **Note:** This API requires an admin or service account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources/updateSchema

name <string> The name of the data source to update Schema. Format: datasources/{source_id}
UpdateSchemaRequest:
{:validateOnly boolean,
 :schema
 {:objectDefinitions
  [{:name string,
    :options
    {:freshnessOptions
     {:freshnessProperty string, :freshnessDuration string},
     :displayOptions
     {:objectDisplayLabel string, :metalines [Metaline]},
     :suggestionFilteringOperators [string]},
    :propertyDefinitions
    [{:isSuggestable boolean,
      :timestampPropertyOptions
      {:operatorOptions TimestampOperatorOptions},
      :integerPropertyOptions
      {:orderedRanking [NO_ORDER ASCENDING DESCENDING],
       :minimumValue string,
       :maximumValue string,
       :operatorOptions IntegerOperatorOptions,
       :integerFacetingOptions IntegerFacetingOptions},
      :enumPropertyOptions
      {:possibleValues [EnumValuePair],
       :orderedRanking [NO_ORDER ASCENDING DESCENDING],
       :operatorOptions EnumOperatorOptions},
      :name string,
      :htmlPropertyOptions
      {:retrievalImportance RetrievalImportance,
       :operatorOptions HtmlOperatorOptions},
      :isWildcardSearchable boolean,
      :displayOptions {:displayLabel string},
      :isSortable boolean,
      :objectPropertyOptions
      {:subobjectProperties [PropertyDefinition]},
      :isReturnable boolean,
      :datePropertyOptions {:operatorOptions DateOperatorOptions},
      :isFacetable boolean,
      :textPropertyOptions
      {:retrievalImportance RetrievalImportance,
       :operatorOptions TextOperatorOptions},
      :doublePropertyOptions {:operatorOptions DoubleOperatorOptions},
      :booleanPropertyOptions
      {:operatorOptions BooleanOperatorOptions},
      :isRepeatable boolean}]}],
  :operationIds [string]},
 :debugOptions {:enableDebugging boolean}}"
  [name UpdateSchemaRequest]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/indexing/{+name}/schema",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.settings"
      "https://www.googleapis.com/auth/cloud_search.settings.indexing"],
     :body UpdateSchemaRequest}))

(defn indexing-datasources-getSchema
  "Gets the schema of a data source. **Note:** This API requires an admin or service account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources/getSchema

name <string> The name of the data source to get Schema. Format: datasources/{source_id}

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (indexing-datasources-getSchema name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/indexing/{+name}/schema",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"]})))

(defn indexing-datasources-deleteSchema
  "Deletes the schema of a data source. **Note:** This API requires an admin or service account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources/deleteSchema

name <string> The name of the data source to delete Schema. Format: datasources/{source_id}

optional:
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (indexing-datasources-deleteSchema name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/indexing/{+name}/schema",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.settings"
        "https://www.googleapis.com/auth/cloud_search.settings.indexing"]})))

(defn indexing-datasources-items-get
  "Gets Item resource by item name. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/get

name <string> The name of the item to get info. Format: datasources/{source_id}/items/{item_id}

optional:
connectorName <string> The name of connector making this call. Format: datasources/{source_id}/connectors/{ID}
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (indexing-datasources-items-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/indexing/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.indexing"]})))

(defn indexing-datasources-items-push
  "Pushes an item onto a queue for later polling and updating. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/push

name <string> The name of the item to push into the indexing queue. Format: datasources/{source_id}/items/{ID} This is a required field. The maximum length is 1536 characters.
PushItemRequest:
{:item
 {:type [UNSPECIFIED MODIFIED NOT_MODIFIED REPOSITORY_ERROR REQUEUE],
  :metadataHash string,
  :structuredDataHash string,
  :contentHash string,
  :payload string,
  :queue string,
  :repositoryError
  {:type
   [UNKNOWN
    NETWORK_ERROR
    DNS_ERROR
    CONNECTION_ERROR
    AUTHENTICATION_ERROR
    AUTHORIZATION_ERROR
    SERVER_ERROR
    QUOTA_EXCEEDED
    SERVICE_UNAVAILABLE
    CLIENT_ERROR],
   :httpStatusCode integer,
   :errorMessage string}},
 :connectorName string,
 :debugOptions {:enableDebugging boolean}}"
  [name PushItemRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/indexing/{+name}:push",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.indexing"],
     :body PushItemRequest}))

(defn indexing-datasources-items-index
  "Updates Item ACL, metadata, and content. It will insert the Item if it does not exist. This method does not support partial updates. Fields with no provided values are cleared out in the Cloud Search index. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/index

name <string> The name of the Item. Format: datasources/{source_id}/items/{item_id} This is a required field. The maximum length is 1536 characters.
IndexItemRequest:
{:item
 {:payload string,
  :queue string,
  :content
  {:contentFormat [UNSPECIFIED HTML TEXT RAW],
   :inlineContent string,
   :contentDataRef {:name string},
   :hash string},
  :name string,
  :status
  {:code [CODE_UNSPECIFIED ERROR MODIFIED NEW_ITEM ACCEPTED],
   :processingErrors
   [{:code
     [PROCESSING_ERROR_CODE_UNSPECIFIED
      MALFORMED_REQUEST
      UNSUPPORTED_CONTENT_FORMAT
      INDIRECT_BROKEN_ACL
      ACL_CYCLE],
     :errorMessage string,
     :fieldViolations [{:field string, :description string}]}],
   :repositoryErrors
   [{:type
     [UNKNOWN
      NETWORK_ERROR
      DNS_ERROR
      CONNECTION_ERROR
      AUTHENTICATION_ERROR
      AUTHORIZATION_ERROR
      SERVER_ERROR
      QUOTA_EXCEEDED
      SERVICE_UNAVAILABLE
      CLIENT_ERROR],
     :httpStatusCode integer,
     :errorMessage string}]},
  :acl
  {:inheritAclFrom string,
   :aclInheritanceType
   [NOT_APPLICABLE CHILD_OVERRIDE PARENT_OVERRIDE BOTH_PERMIT],
   :readers
   [{:gsuitePrincipal
     {:gsuiteUserEmail string,
      :gsuiteGroupEmail string,
      :gsuiteDomain boolean},
     :userResourceName string,
     :groupResourceName string}],
   :deniedReaders
   [{:gsuitePrincipal
     {:gsuiteUserEmail string,
      :gsuiteGroupEmail string,
      :gsuiteDomain boolean},
     :userResourceName string,
     :groupResourceName string}],
   :owners
   [{:gsuitePrincipal
     {:gsuiteUserEmail string,
      :gsuiteGroupEmail string,
      :gsuiteDomain boolean},
     :userResourceName string,
     :groupResourceName string}]},
  :itemType
  [UNSPECIFIED CONTENT_ITEM CONTAINER_ITEM VIRTUAL_CONTAINER_ITEM],
  :version string,
  :structuredData
  {:object
   {:properties
    [{:htmlValues HtmlValues,
      :name string,
      :booleanValue boolean,
      :integerValues IntegerValues,
      :textValues TextValues,
      :enumValues EnumValues,
      :dateValues DateValues,
      :timestampValues TimestampValues,
      :doubleValues DoubleValues,
      :objectValues ObjectValues}]},
   :hash string},
  :metadata
  {:hash string,
   :contextAttributes [{:name string, :values [string]}],
   :searchQualityMetadata {:quality number},
   :createTime string,
   :contentLanguage string,
   :keywords [string],
   :title string,
   :updateTime string,
   :objectType string,
   :interactions
   [{:type [UNSPECIFIED VIEW EDIT],
     :principal
     {:gsuitePrincipal GSuitePrincipal,
      :userResourceName string,
      :groupResourceName string},
     :interactionTime string}],
   :mimeType string,
   :containerName string,
   :sourceRepositoryUrl string}},
 :connectorName string,
 :mode [UNSPECIFIED SYNCHRONOUS ASYNCHRONOUS],
 :debugOptions {:enableDebugging boolean},
 :indexItemOptions {:allowUnknownGsuitePrincipals boolean}}"
  [name IndexItemRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/indexing/{+name}:index",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.indexing"],
     :body IndexItemRequest}))

(defn indexing-datasources-items-delete
  "Deletes Item resource for the specified resource name. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/delete

name <string> Required. The name of the item to delete. Format: datasources/{source_id}/items/{item_id}

optional:
version <string> Required. The incremented version of the item to delete from the index. The indexing system stores the version from the datasource as a byte string and compares the Item version in the index to the version of the queued Item using lexical ordering. Cloud Search Indexing won't delete any queued item with a version value that is less than or equal to the version of the currently indexed item. The maximum length for this field is 1024 bytes. For information on how item version affects the deletion process, refer to [Handle revisions after manual deletes](https://developers.google.com/cloud-search/docs/guides/operations).
connectorName <string> The name of connector making this call. Format: datasources/{source_id}/connectors/{ID}
mode <string> Required. The RequestMode for this request.
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (indexing-datasources-items-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/indexing/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.indexing"]})))

(defn indexing-datasources-items-deleteQueueItems
  "Deletes all items in a queue. This method is useful for deleting stale items. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/deleteQueueItems

name <string> The name of the Data Source to delete items in a queue. Format: datasources/{source_id}
DeleteQueueItemsRequest:
{:connectorName string,
 :queue string,
 :debugOptions {:enableDebugging boolean}}"
  [name DeleteQueueItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/indexing/{+name}/items:deleteQueueItems",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.indexing"],
     :body DeleteQueueItemsRequest}))

(defn indexing-datasources-items-poll
  "Polls for unreserved items from the indexing queue and marks a set as reserved, starting with items that have the oldest timestamp from the highest priority ItemStatus. The priority order is as follows: ERROR MODIFIED NEW_ITEM ACCEPTED Reserving items ensures that polling from other threads cannot create overlapping sets. After handling the reserved items, the client should put items back into the unreserved state, either by calling index, or by calling push with the type REQUEUE. Items automatically become available (unreserved) after 4 hours even if no update or push method is called. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/poll

name <string> The name of the Data Source to poll items. Format: datasources/{source_id}
PollItemsRequest:
{:connectorName string,
 :statusCodes [[CODE_UNSPECIFIED ERROR MODIFIED NEW_ITEM ACCEPTED]],
 :limit integer,
 :queue string,
 :debugOptions {:enableDebugging boolean}}"
  [name PollItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/indexing/{+name}/items:poll",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.indexing"],
     :body PollItemsRequest}))

(defn indexing-datasources-items-list
  "Lists all or a subset of Item resources. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/list

name <string> The name of the Data Source to list Items. Format: datasources/{source_id}

optional:
connectorName <string> The name of connector making this call. Format: datasources/{source_id}/connectors/{ID}
brief <boolean> When set to true, the indexing system only populates the following fields: name, version, queue. metadata.hash, metadata.title, metadata.sourceRepositoryURL, metadata.objectType, metadata.createTime, metadata.updateTime, metadata.contentLanguage, metadata.mimeType, structured_data.hash, content.hash, itemType, itemStatus.code, itemStatus.processingError.code, itemStatus.repositoryError.type, If this value is false, then all the fields are populated in Item.
pageSize <integer> Maximum number of items to fetch in a request. The max value is 1000 when brief is true. The max value is 10 if brief is false. The default value is 10
debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field."
  ([name] (indexing-datasources-items-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/indexing/{+name}/items",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.indexing"]})))

(defn indexing-datasources-items-unreserve
  "Unreserves all items from a queue, making them all eligible to be polled. This method is useful for resetting the indexing queue after a connector has been restarted. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/unreserve

name <string> The name of the Data Source to unreserve all items. Format: datasources/{source_id}
UnreserveItemsRequest:
{:connectorName string,
 :queue string,
 :debugOptions {:enableDebugging boolean}}"
  [name UnreserveItemsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/indexing/{+name}/items:unreserve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.indexing"],
     :body UnreserveItemsRequest}))

(defn indexing-datasources-items-upload
  "Creates an upload session for uploading item content. For items smaller than 100 KB, it's easier to embed the content inline within an index request. This API requires an admin or service account to execute. The service account used is the one whitelisted in the corresponding data source.
https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items/upload

name <string> The name of the Item to start a resumable upload. Format: datasources/{source_id}/items/{item_id}. The maximum length is 1536 bytes.
StartUploadItemRequest:
{:connectorName string, :debugOptions {:enableDebugging boolean}}"
  [name StartUploadItemRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/indexing/{+name}:upload",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.indexing"],
     :body StartUploadItemRequest}))

(defn query-suggest
  "Provides suggestions for autocompleting the query. **Note:** This API requires a standard end user account to execute. A service account can't perform Query API requests directly; to use a service account to perform queries, set up [Google Workspace domain-wide delegation of authority](https://developers.google.com/cloud-search/docs/guides/delegation/).
https://developers.google.com/cloud-search/docs/reference/rest/v1/query/suggest

SuggestRequest:
{:requestOptions
 {:languageCode string,
  :debugOptions {:enableDebugging boolean},
  :timeZone string,
  :searchApplicationId string},
 :query string,
 :dataSourceRestrictions
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :filterOptions
   [{:objectType string,
     :filter
     {:valueFilter {:operatorName string, :value Value},
      :compositeFilter
      {:logicOperator [AND OR NOT], :subFilters [Filter]}}}]}]}"
  [SuggestRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/query/suggest",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.query"],
     :body SuggestRequest}))

(defn query-search
  "The Cloud Search Query API provides the search method, which returns the most relevant results from a user query. The results can come from Google Workspace apps, such as Gmail or Google Drive, or they can come from data that you have indexed from a third party. **Note:** This API requires a standard end user account to execute. A service account can't perform Query API requests directly; to use a service account to perform queries, set up [Google Workspace domain-wide delegation of authority](https://developers.google.com/cloud-search/docs/guides/delegation/).
https://developers.google.com/cloud-search/docs/reference/rest/v1/query/search

SearchRequest:
{:sortOptions
 {:operatorName string, :sortOrder [ASCENDING DESCENDING]},
 :contextAttributes [{:name string, :values [string]}],
 :start integer,
 :requestOptions
 {:languageCode string,
  :debugOptions {:enableDebugging boolean},
  :timeZone string,
  :searchApplicationId string},
 :pageSize integer,
 :facetOptions
 [{:sourceName string,
   :objectType string,
   :operatorName string,
   :numFacetBuckets integer,
   :integerFacetingOptions {:integerBuckets [string]}}],
 :queryInterpretationOptions
 {:disableNlInterpretation boolean,
  :enableVerbatimMode boolean,
  :disableSupplementalResults boolean},
 :dataSourceRestrictions
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :filterOptions
   [{:objectType string,
     :filter
     {:valueFilter {:operatorName string, :value Value},
      :compositeFilter
      {:logicOperator [AND OR NOT], :subFilters [Filter]}}}]}],
 :query string}"
  [SearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/query/search",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.query"],
     :body SearchRequest}))

(defn query-removeActivity
  "Provides functionality to remove logged activity for a user. Currently to be used only for Chat 1p clients **Note:** This API requires a standard end user account to execute. A service account can't perform Remove Activity requests directly; to use a service account to perform queries, set up [Google Workspace domain-wide delegation of authority](https://developers.google.com/cloud-search/docs/guides/delegation/).
https://developers.google.com/cloud-search/docs/reference/rest/v1/query/removeActivity

RemoveActivityRequest:
{:userActivity {:queryActivity {:query string}},
 :requestOptions
 {:languageCode string,
  :debugOptions {:enableDebugging boolean},
  :timeZone string,
  :searchApplicationId string}}"
  [RemoveActivityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/query:removeActivity",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.query"],
     :body RemoveActivityRequest}))

(defn query-debugSearch
  "Returns Debug information for Cloud Search Query API provides the search method. **Note:** This API requires a standard end user account to execute. A service account can't perform Query API requests directly; to use a service account to perform queries, set up [Google Workspace domain-wide delegation of authority](https://developers.google.com/cloud-search/docs/guides/delegation/).
https://developers.google.com/cloud-search/docs/reference/rest/v1/query/debugSearch

SearchRequest:
{:sortOptions
 {:operatorName string, :sortOrder [ASCENDING DESCENDING]},
 :contextAttributes [{:name string, :values [string]}],
 :start integer,
 :requestOptions
 {:languageCode string,
  :debugOptions {:enableDebugging boolean},
  :timeZone string,
  :searchApplicationId string},
 :pageSize integer,
 :facetOptions
 [{:sourceName string,
   :objectType string,
   :operatorName string,
   :numFacetBuckets integer,
   :integerFacetingOptions {:integerBuckets [string]}}],
 :queryInterpretationOptions
 {:disableNlInterpretation boolean,
  :enableVerbatimMode boolean,
  :disableSupplementalResults boolean},
 :dataSourceRestrictions
 [{:source
   {:name string,
    :predefinedSource
    [NONE
     QUERY_HISTORY
     PERSON
     GOOGLE_DRIVE
     GOOGLE_GMAIL
     GOOGLE_SITES
     GOOGLE_GROUPS
     GOOGLE_CALENDAR
     GOOGLE_KEEP]},
   :filterOptions
   [{:objectType string,
     :filter
     {:valueFilter {:operatorName string, :value Value},
      :compositeFilter
      {:logicOperator [AND OR NOT], :subFilters [Filter]}}}]}],
 :query string}"
  [SearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/query:debugSearch",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.query"],
     :body SearchRequest}))

(defn query-sources-list
  "Returns list of sources that user can use for Search and Suggest APIs. **Note:** This API requires a standard end user account to execute. A service account can't perform Query API requests directly; to use a service account to perform queries, set up [Google Workspace domain-wide delegation of authority](https://developers.google.com/cloud-search/docs/guides/delegation/).
https://developers.google.com/cloud-search/docs/reference/rest/v1/query.sources/list

optional:
requestOptions.languageCode <string> The BCP-47 language code, such as \"en-US\" or \"sr-Latn\". For more information, see http://www.unicode.org/reports/tr35/#Unicode_locale_identifier. For translations. Set this field using the language set in browser or for the page. In the event that the user's language preference is known, set this field to the known user language. When specified, the documents in search results are biased towards the specified language. The Suggest API uses this field as a hint to make better third-party autocomplete predictions.
requestOptions.debugOptions.enableDebugging <boolean> If you are asked by Google to help with debugging, set this field. Otherwise, ignore this field.
requestOptions.timeZone <string> Current user's time zone id, such as \"America/Los_Angeles\" or \"Australia/Sydney\". These IDs are defined by [Unicode Common Locale Data Repository (CLDR)](http://cldr.unicode.org/) project, and currently available in the file [timezone.xml](http://unicode.org/repos/cldr/trunk/common/bcp47/timezone.xml). This field is used to correctly interpret date and time queries. If this field is not specified, the default time zone (UTC) is used.
requestOptions.searchApplicationId <string> The ID generated when you create a search application using the [admin console](https://support.google.com/a/answer/9043922)."
  ([] (query-sources-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/query/sources",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.query"]})))

(defn stats-getIndex
  "Gets indexed item statistics aggreggated across all data sources. This API only returns statistics for previous dates; it doesn't return statistics for the current day. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getIndex

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([] (stats-getIndex nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/index",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-getQuery
  "Get the query statistics for customer. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getQuery

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([] (stats-getQuery nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/query",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-getUser
  "Get the users statistics for customer. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getUser

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([] (stats-getUser nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/user",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-getSession
  "Get the # of search sessions, % of successful sessions with a click query statistics for customer. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getSession

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([] (stats-getSession nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/session",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-getSearchapplication
  "Get search application stats for customer. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats/getSearchapplication

optional:
startDate.year <integer> Year of date. Must be from 1 to 9999.
startDate.month <integer> Month of date. Must be from 1 to 12.
startDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
endDate.year <integer> Year of date. Must be from 1 to 9999.
endDate.month <integer> Month of date. Must be from 1 to 12.
endDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([] (stats-getSearchapplication nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/searchapplication",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-index-datasources-get
  "Gets indexed item statistics for a single data source. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.index.datasources/get

name <string> The resource id of the data source to retrieve statistics for, in the following format: \"datasources/{source_id}\"

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([name] (stats-index-datasources-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/index/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-query-searchapplications-get
  "Get the query statistics for search application. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.query.searchapplications/get

name <string> The resource id of the search application query stats, in the following format: searchapplications/{application_id}

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([name] (stats-query-searchapplications-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/query/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-user-searchapplications-get
  "Get the users statistics for search application. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.user.searchapplications/get

name <string> The resource id of the search application session stats, in the following format: searchapplications/{application_id}

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([name] (stats-user-searchapplications-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/user/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn stats-session-searchapplications-get
  "Get the # of search sessions, % of successful sessions with a click query statistics for search application. **Note:** This API requires a standard end user account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/stats.session.searchapplications/get

name <string> The resource id of the search application session stats, in the following format: searchapplications/{application_id}

optional:
fromDate.year <integer> Year of date. Must be from 1 to 9999.
fromDate.month <integer> Month of date. Must be from 1 to 12.
fromDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month.
toDate.year <integer> Year of date. Must be from 1 to 9999.
toDate.month <integer> Month of date. Must be from 1 to 12.
toDate.day <integer> Day of month. Must be from 1 to 31 and valid for the year and month."
  ([name] (stats-session-searchapplications-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudsearch.googleapis.com/v1/stats/session/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud_search"
        "https://www.googleapis.com/auth/cloud_search.stats"
        "https://www.googleapis.com/auth/cloud_search.stats.indexing"]})))

(defn media-upload
  "Uploads media for indexing. The upload endpoint supports direct and resumable upload protocols and is intended for large items that can not be [inlined during index requests](https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items#itemcontent). To index large content: 1. Call indexing.datasources.items.upload with the item name to begin an upload session and retrieve the UploadItemRef. 1. Call media.upload to upload the content, as a streaming request, using the same resource name from the UploadItemRef from step 1. 1. Call indexing.datasources.items.index to index the item. Populate the [ItemContent](/cloud-search/docs/reference/rest/v1/indexing.datasources.items#ItemContent) with the UploadItemRef from step 1. For additional information, see [Create a content connector using the REST API](https://developers.google.com/cloud-search/docs/guides/content-connector#rest). **Note:** This API requires a service account to execute.
https://developers.google.com/cloud-search/docs/reference/rest/v1/media/upload

resourceName <string> Name of the media that is being downloaded. See ReadRequest.resource_name.
Media:
{:resourceName string}"
  [resourceName Media]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudsearch.googleapis.com/v1/media/{+resourceName}",
     :uri-template-args {:resourceName resourceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud_search"
      "https://www.googleapis.com/auth/cloud_search.indexing"],
     :body Media}))

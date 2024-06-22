(ns happygapi2.discoveryengine
  "Discovery Engine API
Discovery Engine API.
See: https://cloud.google.com/discovery-engine/media/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-provision
  "Provisions the project resource. During the process, related systems will get prepared and initialized. Caller must read the [Terms for data use](https://cloud.google.com/retail/data-use-terms), and optionally specify in request to provide consent to that service terms.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of a Project, such as `projects/{project_id_or_number}`.
GoogleCloudDiscoveryengineV1ProvisionProjectRequest:
{:acceptDataUseTerms boolean, :dataUseTermsVersion string}"
  [name GoogleCloudDiscoveryengineV1ProvisionProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+name}:provision",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ProvisionProjectRequest}))

(defn projects-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-locations-collections-dataConnector-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-dataConnector-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataConnector-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-collections-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-completeQuery
  "Completes the specified user input with keyword suggestions.
https://cloud.google.com/discovery-engine/media/docs

dataStore <string> Required. The parent data store resource name for which the completion is performed, such as `projects/*/locations/global/collections/default_collection/dataStores/default_data_store`.

optional:
query <string> Required. The typeahead input used to fetch suggestions. Maximum length is 128 characters.
queryModel <string> Specifies the autocomplete data model. This overrides any model specified in the Configuration > Autocomplete section of the Cloud console. Currently supported values: * `document` - Using suggestions generated from user-imported documents. * `search-history` - Using suggestions generated from the past history of SearchService.Search API calls. Do not use it when there is no traffic for Search API. * `user-event` - Using suggestions generated from user-imported search events. * `document-completable` - Using suggestions taken directly from user-imported document fields marked as completable. Default values: * `document` is the default model for regular dataStores. * `search-history` is the default model for site search dataStores.
userPseudoId <string> A unique identifier for tracking visitors. For example, this could be implemented with an HTTP cookie, which should be able to uniquely identify a visitor on a single device. This unique identifier should not change if the visitor logs in or out of the website. This field should NOT have a fixed value such as `unknown_visitor`. This should be the same identifier as UserEvent.user_pseudo_id and SearchRequest.user_pseudo_id. The field must be a UTF-8 encoded string with a length limit of 128 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
includeTailSuggestions <boolean> Indicates if tail suggestions should be returned if there are no suggestions that match the full query. Even if set to true, if there are suggestions that match the full query, those are returned and no tail suggestions are returned."
  ([dataStore]
    (projects-locations-collections-dataStores-completeQuery
      dataStore
      nil))
  ([dataStore optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+dataStore}:completeQuery",
       :uri-template-args {:dataStore dataStore},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-create
  "Creates a DataStore. DataStore is for storing Documents. To serve these documents for Search, or Recommendation use case, an Engine needs to be created separately.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection}`.
GoogleCloudDiscoveryengineV1DataStore:
{:displayName string,
 :defaultSchemaId string,
 :name string,
 :industryVertical
 [INDUSTRY_VERTICAL_UNSPECIFIED GENERIC MEDIA HEALTHCARE_FHIR],
 :createTime string,
 :solutionTypes
 [[SOLUTION_TYPE_UNSPECIFIED
   SOLUTION_TYPE_RECOMMENDATION
   SOLUTION_TYPE_SEARCH
   SOLUTION_TYPE_CHAT
   SOLUTION_TYPE_GENERATIVE_CHAT]],
 :startingSchema
 {:structSchema object, :jsonSchema string, :name string},
 :contentConfig
 [CONTENT_CONFIG_UNSPECIFIED
  NO_CONTENT
  CONTENT_REQUIRED
  PUBLIC_WEBSITE],
 :documentProcessingConfig
 {:name string,
  :chunkingConfig
  {:layoutBasedChunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :defaultParsingConfig
  {:digitalParsingConfig object,
   :ocrParsingConfig
   {:enhancedDocumentElements [string], :useNativeText boolean},
   :layoutParsingConfig object},
  :parsingConfigOverrides object}}

optional:
dataStoreId <string> Required. The ID to use for the DataStore, which will become the final component of the DataStore's resource name. This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
createAdvancedSiteSearch <boolean> A boolean flag indicating whether user want to directly create an advanced data store for site search. If the data store is not configured as site search (GENERIC vertical and PUBLIC_WEBSITE content_config), this flag will be ignored."
  ([parent GoogleCloudDiscoveryengineV1DataStore]
    (projects-locations-collections-dataStores-create
      parent
      GoogleCloudDiscoveryengineV1DataStore
      nil))
  ([parent GoogleCloudDiscoveryengineV1DataStore optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/dataStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1DataStore})))

(defn projects-locations-collections-dataStores-get
  "Gets a DataStore.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of DataStore, such as `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`. If the caller does not have permission to access the DataStore, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the requested DataStore does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-list
  "Lists all the DataStores associated with the project.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent branch resource name, such as `projects/{project}/locations/{location}/collections/{collection_id}`. If the caller does not have permission to list DataStores under this location, regardless of whether or not this data store exists, a PERMISSION_DENIED error is returned.

optional:
pageSize <integer> Maximum number of DataStores to return. If unspecified, defaults to 10. The maximum allowed value is 50. Values above 50 will be coerced to 50. If this field is negative, an INVALID_ARGUMENT is returned.
filter <string> Filter by solution type . For example: `filter = 'solution_type:SOLUTION_TYPE_SEARCH'`"
  ([parent]
    (projects-locations-collections-dataStores-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/dataStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-delete
  "Deletes a DataStore.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of DataStore, such as `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`. If the caller does not have permission to delete the DataStore, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the DataStore to delete does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-patch
  "Updates a DataStore
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. The full resource name of the data store. Format: `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`. This field must be a UTF-8 encoded string with a length limit of 1024 characters.
GoogleCloudDiscoveryengineV1DataStore:
{:displayName string,
 :defaultSchemaId string,
 :name string,
 :industryVertical
 [INDUSTRY_VERTICAL_UNSPECIFIED GENERIC MEDIA HEALTHCARE_FHIR],
 :createTime string,
 :solutionTypes
 [[SOLUTION_TYPE_UNSPECIFIED
   SOLUTION_TYPE_RECOMMENDATION
   SOLUTION_TYPE_SEARCH
   SOLUTION_TYPE_CHAT
   SOLUTION_TYPE_GENERATIVE_CHAT]],
 :startingSchema
 {:structSchema object, :jsonSchema string, :name string},
 :contentConfig
 [CONTENT_CONFIG_UNSPECIFIED
  NO_CONTENT
  CONTENT_REQUIRED
  PUBLIC_WEBSITE],
 :documentProcessingConfig
 {:name string,
  :chunkingConfig
  {:layoutBasedChunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :defaultParsingConfig
  {:digitalParsingConfig object,
   :ocrParsingConfig
   {:enhancedDocumentElements [string], :useNativeText boolean},
   :layoutParsingConfig object},
  :parsingConfigOverrides object}}

optional:
updateMask <string> Indicates which fields in the provided DataStore to update. If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned."
  ([name GoogleCloudDiscoveryengineV1DataStore]
    (projects-locations-collections-dataStores-patch
      name
      GoogleCloudDiscoveryengineV1DataStore
      nil))
  ([name GoogleCloudDiscoveryengineV1DataStore optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1DataStore})))

(defn projects-locations-collections-dataStores-getSiteSearchEngine
  "Gets the SiteSearchEngine.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Resource name of SiteSearchEngine, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`. If the caller does not have permission to access the [SiteSearchEngine], regardless of whether or not it exists, a PERMISSION_DENIED error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-siteSearchEngine-enableAdvancedSiteSearch
  "Upgrade from basic site search to advanced site search.
https://cloud.google.com/discovery-engine/media/docs

siteSearchEngine <string> Required. Full resource name of the SiteSearchEngine, such as `projects/{project}/locations/{location}/dataStores/{data_store_id}/siteSearchEngine`.
GoogleCloudDiscoveryengineV1EnableAdvancedSiteSearchRequest:
object"
  [siteSearchEngine
   GoogleCloudDiscoveryengineV1EnableAdvancedSiteSearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+siteSearchEngine}:enableAdvancedSiteSearch",
     :uri-template-args {:siteSearchEngine siteSearchEngine},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1EnableAdvancedSiteSearchRequest}))

(defn projects-locations-collections-dataStores-siteSearchEngine-disableAdvancedSiteSearch
  "Downgrade from advanced site search to basic site search.
https://cloud.google.com/discovery-engine/media/docs

siteSearchEngine <string> Required. Full resource name of the SiteSearchEngine, such as `projects/{project}/locations/{location}/dataStores/{data_store_id}/siteSearchEngine`.
GoogleCloudDiscoveryengineV1DisableAdvancedSiteSearchRequest:
object"
  [siteSearchEngine
   GoogleCloudDiscoveryengineV1DisableAdvancedSiteSearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+siteSearchEngine}:disableAdvancedSiteSearch",
     :uri-template-args {:siteSearchEngine siteSearchEngine},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1DisableAdvancedSiteSearchRequest}))

(defn projects-locations-collections-dataStores-siteSearchEngine-recrawlUris
  "Request on-demand recrawl for a list of URIs.
https://cloud.google.com/discovery-engine/media/docs

siteSearchEngine <string> Required. Full resource name of the SiteSearchEngine, such as `projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine`.
GoogleCloudDiscoveryengineV1RecrawlUrisRequest:
{:uris [string]}"
  [siteSearchEngine GoogleCloudDiscoveryengineV1RecrawlUrisRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+siteSearchEngine}:recrawlUris",
     :uri-template-args {:siteSearchEngine siteSearchEngine},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1RecrawlUrisRequest}))

(defn projects-locations-collections-dataStores-siteSearchEngine-batchVerifyTargetSites
  "Verify target sites' ownership and validity. This API sends all the target sites under site search engine for verification.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource shared by all TargetSites being verified. `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
GoogleCloudDiscoveryengineV1BatchVerifyTargetSitesRequest:
object"
  [parent GoogleCloudDiscoveryengineV1BatchVerifyTargetSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}:batchVerifyTargetSites",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1BatchVerifyTargetSitesRequest}))

(defn projects-locations-collections-dataStores-siteSearchEngine-fetchDomainVerificationStatus
  "Returns list of target sites with its domain verification status. This method can only be called under data store with BASIC_SITE_SEARCH state at the moment.
https://cloud.google.com/discovery-engine/media/docs

siteSearchEngine <string> Required. The site search engine resource under which we fetch all the domain verification status. `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default. The maximum value is 1000; values above 1000 will be coerced to 1000. If this field is negative, an INVALID_ARGUMENT error is returned."
  ([siteSearchEngine]
    (projects-locations-collections-dataStores-siteSearchEngine-fetchDomainVerificationStatus
      siteSearchEngine
      nil))
  ([siteSearchEngine optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+siteSearchEngine}:fetchDomainVerificationStatus",
       :uri-template-args {:siteSearchEngine siteSearchEngine},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-siteSearchEngine-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-dataStores-siteSearchEngine-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-siteSearchEngine-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-create
  "Creates a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Parent resource name of TargetSite, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
GoogleCloudDiscoveryengineV1TargetSite:
{:providedUriPattern string,
 :exactMatch boolean,
 :name string,
 :indexingStatus
 [INDEXING_STATUS_UNSPECIFIED PENDING FAILED SUCCEEDED DELETING],
 :rootDomainUri string,
 :type [TYPE_UNSPECIFIED INCLUDE EXCLUDE],
 :updateTime string,
 :siteVerificationInfo
 {:siteVerificationState
  [SITE_VERIFICATION_STATE_UNSPECIFIED VERIFIED UNVERIFIED EXEMPTED],
  :verifyTime string},
 :failureReason {:quotaFailure {:totalRequiredQuota string}},
 :generatedUriPattern string}"
  [parent GoogleCloudDiscoveryengineV1TargetSite]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/targetSites",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1TargetSite}))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-batchCreate
  "Creates TargetSite in a batch.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource shared by all TargetSites being created. `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`. The parent field in the CreateBookRequest messages must either be empty or match this field.
GoogleCloudDiscoveryengineV1BatchCreateTargetSitesRequest:
{:requests
 [{:parent string,
   :targetSite
   {:providedUriPattern string,
    :exactMatch boolean,
    :name string,
    :indexingStatus
    [INDEXING_STATUS_UNSPECIFIED PENDING FAILED SUCCEEDED DELETING],
    :rootDomainUri string,
    :type [TYPE_UNSPECIFIED INCLUDE EXCLUDE],
    :updateTime string,
    :siteVerificationInfo
    {:siteVerificationState
     [SITE_VERIFICATION_STATE_UNSPECIFIED
      VERIFIED
      UNVERIFIED
      EXEMPTED],
     :verifyTime string},
    :failureReason {:quotaFailure {:totalRequiredQuota string}},
    :generatedUriPattern string}}]}"
  [parent GoogleCloudDiscoveryengineV1BatchCreateTargetSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/targetSites:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1BatchCreateTargetSitesRequest}))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-get
  "Gets a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of TargetSite, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`. If the caller does not have permission to access the TargetSite, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the requested TargetSite does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-patch
  "Updates a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

name <string> Output only. The fully qualified resource name of the target site. `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}` The `target_site_id` is system-generated.
GoogleCloudDiscoveryengineV1TargetSite:
{:providedUriPattern string,
 :exactMatch boolean,
 :name string,
 :indexingStatus
 [INDEXING_STATUS_UNSPECIFIED PENDING FAILED SUCCEEDED DELETING],
 :rootDomainUri string,
 :type [TYPE_UNSPECIFIED INCLUDE EXCLUDE],
 :updateTime string,
 :siteVerificationInfo
 {:siteVerificationState
  [SITE_VERIFICATION_STATE_UNSPECIFIED VERIFIED UNVERIFIED EXEMPTED],
  :verifyTime string},
 :failureReason {:quotaFailure {:totalRequiredQuota string}},
 :generatedUriPattern string}"
  [name GoogleCloudDiscoveryengineV1TargetSite]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1TargetSite}))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-delete
  "Deletes a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of TargetSite, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`. If the caller does not have permission to access the TargetSite, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the requested TargetSite does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-list
  "Gets a list of TargetSites.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent site search engine resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`. If the caller does not have permission to list TargetSites under this site search engine, regardless of whether or not this branch exists, a PERMISSION_DENIED error is returned.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default. The maximum value is 1000; values above 1000 will be coerced to 1000. If this field is negative, an INVALID_ARGUMENT error is returned."
  ([parent]
    (projects-locations-collections-dataStores-siteSearchEngine-targetSites-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/targetSites",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-dataStores-siteSearchEngine-targetSites-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-siteSearchEngine-targetSites-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-conversations-converse
  "Converses a conversation.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`. Use `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/-` to activate auto session mode, which automatically creates a new conversation inside a ConverseConversation session.
GoogleCloudDiscoveryengineV1ConverseConversationRequest:
{:query
 {:input string,
  :context {:contextDocuments [string], :activeDocument string}},
 :servingConfig string,
 :conversation
 {:name string,
  :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
  :userPseudoId string,
  :messages
  [{:userInput
    {:input string,
     :context {:contextDocuments [string], :activeDocument string}},
    :reply
    {:summary
     {:summaryText string,
      :summarySkippedReasons
      [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
        ADVERSARIAL_QUERY_IGNORED
        NON_SUMMARY_SEEKING_QUERY_IGNORED
        OUT_OF_DOMAIN_QUERY_IGNORED
        POTENTIAL_POLICY_VIOLATION
        LLM_ADDON_NOT_ENABLED]],
      :safetyAttributes
      GoogleCloudDiscoveryengineV1SearchResponseSummarySafetyAttributes,
      :summaryWithMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummarySummaryWithMetadata}},
    :createTime string}],
  :startTime string,
  :endTime string},
 :safeSearch boolean,
 :userLabels object,
 :summarySpec
 {:summaryResultCount integer,
  :includeCitations boolean,
  :ignoreAdversarialQuery boolean,
  :ignoreNonSummarySeekingQuery boolean,
  :modelPromptSpec {:preamble string},
  :languageCode string,
  :modelSpec {:version string},
  :useSemanticChunks boolean},
 :filter string,
 :boostSpec {:conditionBoostSpecs [{:condition string, :boost number}]}}"
  [name GoogleCloudDiscoveryengineV1ConverseConversationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+name}:converse",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ConverseConversationRequest}))

(defn projects-locations-collections-dataStores-conversations-create
  "Creates a Conversation. If the Conversation to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
GoogleCloudDiscoveryengineV1Conversation:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
 :userPseudoId string,
 :messages
 [{:userInput
   {:input string,
    :context {:contextDocuments [string], :activeDocument string}},
   :reply
   {:summary
    {:summaryText string,
     :summarySkippedReasons
     [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
       ADVERSARIAL_QUERY_IGNORED
       NON_SUMMARY_SEEKING_QUERY_IGNORED
       OUT_OF_DOMAIN_QUERY_IGNORED
       POTENTIAL_POLICY_VIOLATION
       LLM_ADDON_NOT_ENABLED]],
     :safetyAttributes {:categories [string], :scores [number]},
     :summaryWithMetadata
     {:summary string,
      :citationMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummaryCitationMetadata,
      :references
      [GoogleCloudDiscoveryengineV1SearchResponseSummaryReference]}}},
   :createTime string}],
 :startTime string,
 :endTime string}"
  [parent GoogleCloudDiscoveryengineV1Conversation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/conversations",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1Conversation}))

(defn projects-locations-collections-dataStores-conversations-delete
  "Deletes a Conversation. If the Conversation to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-conversations-patch
  "Updates a Conversation. Conversation action type cannot be changed. If the Conversation to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/{project}/locations/global/collections/{collection}/dataStore/*/conversations/*` or `projects/{project}/locations/global/collections/{collection}/engines/*/conversations/*`.
GoogleCloudDiscoveryengineV1Conversation:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
 :userPseudoId string,
 :messages
 [{:userInput
   {:input string,
    :context {:contextDocuments [string], :activeDocument string}},
   :reply
   {:summary
    {:summaryText string,
     :summarySkippedReasons
     [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
       ADVERSARIAL_QUERY_IGNORED
       NON_SUMMARY_SEEKING_QUERY_IGNORED
       OUT_OF_DOMAIN_QUERY_IGNORED
       POTENTIAL_POLICY_VIOLATION
       LLM_ADDON_NOT_ENABLED]],
     :safetyAttributes {:categories [string], :scores [number]},
     :summaryWithMetadata
     {:summary string,
      :citationMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummaryCitationMetadata,
      :references
      [GoogleCloudDiscoveryengineV1SearchResponseSummaryReference]}}},
   :createTime string}],
 :startTime string,
 :endTime string}

optional:
updateMask <string> Indicates which fields in the provided Conversation to update. The following are NOT supported: * Conversation.name If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Conversation]
    (projects-locations-collections-dataStores-conversations-patch
      name
      GoogleCloudDiscoveryengineV1Conversation
      nil))
  ([name GoogleCloudDiscoveryengineV1Conversation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Conversation})))

(defn projects-locations-collections-dataStores-conversations-get
  "Gets a Conversation.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-conversations-list
  "Lists all Conversations by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`

optional:
pageSize <integer> Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> A filter to apply on the list results. The supported features are: user_pseudo_id, state. Example: \"user_pseudo_id = some_id\"
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `update_time` * `create_time` * `conversation_name` Example: \"update_time desc\" \"create_time\""
  ([parent]
    (projects-locations-collections-dataStores-conversations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/conversations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-userEvents-write
  "Writes a single user event.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name. If the write user event action is applied in DataStore level, the format is: `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`. If the write user event action is applied in Location level, for example, the event with Document across multiple DataStore, the format is: `projects/{project}/locations/{location}`.
GoogleCloudDiscoveryengineV1UserEvent:
{:eventType string,
 :tagIds [string],
 :transactionInfo
 {:value number,
  :currency string,
  :transactionId string,
  :tax number,
  :cost number,
  :discountValue number},
 :sessionId string,
 :searchInfo {:searchQuery string, :orderBy string, :offset integer},
 :userPseudoId string,
 :dataStore string,
 :panel
 {:panelId string,
  :displayName string,
  :panelPosition integer,
  :totalPanels integer},
 :documents
 [{:id string,
   :name string,
   :uri string,
   :quantity integer,
   :promotionIds [string]}],
 :directUserRequest boolean,
 :filter string,
 :completionInfo
 {:selectedSuggestion string, :selectedPosition integer},
 :mediaInfo
 {:mediaProgressDuration string, :mediaProgressPercentage number},
 :pageInfo
 {:pageviewId string,
  :pageCategory string,
  :uri string,
  :referrerUri string},
 :eventTime string,
 :engine string,
 :promotionIds [string],
 :attributes object,
 :attributionToken string,
 :userInfo {:userId string, :userAgent string}}

optional:
writeAsync <boolean> If set to true, the user event is written asynchronously after validation, and the API responds without waiting for the write."
  ([parent GoogleCloudDiscoveryengineV1UserEvent]
    (projects-locations-collections-dataStores-userEvents-write
      parent
      GoogleCloudDiscoveryengineV1UserEvent
      nil))
  ([parent GoogleCloudDiscoveryengineV1UserEvent optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:write",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1UserEvent})))

(defn projects-locations-collections-dataStores-userEvents-collect
  "Writes a single user event from the browser. This uses a GET request to due to browser restriction of POST-ing to a third-party domain. This method is used only by the Discovery Engine API JavaScript pixel and Google Tag Manager. Users should not call this method directly.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent DataStore resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.

optional:
userEvent <string> Required. URL encoded UserEvent proto with a length limit of 2,000,000 characters.
uri <string> The URL including cgi-parameters but excluding the hash fragment with a length limit of 5,000 characters. This is often more useful than the referer URL, because many browsers only send the domain for third-party requests.
ets <string> The event timestamp in milliseconds. This prevents browser caching of otherwise identical get requests. The name is abbreviated to reduce the payload bytes."
  ([parent]
    (projects-locations-collections-dataStores-userEvents-collect
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:collect",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-userEvents-import
  "Bulk import of user events. Request processing might be synchronous. Events that already exist are skipped. Use this method for backfilling historical user events. Operation.response is of type ImportResponse. Note that it is possible for a subset of the items to be successfully inserted. Operation.metadata is of type ImportMetadata.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Parent DataStore resource name, of the form `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`
GoogleCloudDiscoveryengineV1ImportUserEventsRequest:
{:inlineSource
 {:userEvents
  [{:eventType string,
    :tagIds [string],
    :transactionInfo
    {:value number,
     :currency string,
     :transactionId string,
     :tax number,
     :cost number,
     :discountValue number},
    :sessionId string,
    :searchInfo
    {:searchQuery string, :orderBy string, :offset integer},
    :userPseudoId string,
    :dataStore string,
    :panel
    {:panelId string,
     :displayName string,
     :panelPosition integer,
     :totalPanels integer},
    :documents
    [{:id string,
      :name string,
      :uri string,
      :quantity integer,
      :promotionIds [string]}],
    :directUserRequest boolean,
    :filter string,
    :completionInfo
    {:selectedSuggestion string, :selectedPosition integer},
    :mediaInfo
    {:mediaProgressDuration string, :mediaProgressPercentage number},
    :pageInfo
    {:pageviewId string,
     :pageCategory string,
     :uri string,
     :referrerUri string},
    :eventTime string,
    :engine string,
    :promotionIds [string],
    :attributes object,
    :attributionToken string,
    :userInfo {:userId string, :userAgent string}}]},
 :gcsSource {:inputUris [string], :dataSchema string},
 :bigquerySource
 {:partitionDate {:year integer, :month integer, :day integer},
  :projectId string,
  :datasetId string,
  :tableId string,
  :gcsStagingDir string,
  :dataSchema string},
 :errorConfig {:gcsPrefix string}}"
  [parent GoogleCloudDiscoveryengineV1ImportUserEventsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ImportUserEventsRequest}))

(defn projects-locations-collections-dataStores-completionSuggestions-import
  "Imports CompletionSuggestions for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to import customer autocomplete suggestions. Follows pattern `projects/*/locations/*/collections/*/dataStores/*`
GoogleCloudDiscoveryengineV1ImportCompletionSuggestionsRequest:
{:inlineSource
 {:suggestions
  [{:globalScore number,
    :frequency string,
    :suggestion string,
    :languageCode string,
    :groupId string,
    :groupScore number,
    :alternativePhrases [string]}]},
 :gcsSource {:inputUris [string], :dataSchema string},
 :bigquerySource
 {:partitionDate {:year integer, :month integer, :day integer},
  :projectId string,
  :datasetId string,
  :tableId string,
  :gcsStagingDir string,
  :dataSchema string},
 :errorConfig {:gcsPrefix string}}"
  [parent
   GoogleCloudDiscoveryengineV1ImportCompletionSuggestionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/completionSuggestions:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1ImportCompletionSuggestionsRequest}))

(defn projects-locations-collections-dataStores-completionSuggestions-purge
  "Permanently deletes all CompletionSuggestions for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to purge completion suggestions. Follows pattern projects/*/locations/*/collections/*/dataStores/*.
GoogleCloudDiscoveryengineV1PurgeCompletionSuggestionsRequest:
object"
  [parent
   GoogleCloudDiscoveryengineV1PurgeCompletionSuggestionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/completionSuggestions:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1PurgeCompletionSuggestionsRequest}))

(defn projects-locations-collections-dataStores-branches-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-dataStores-branches-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-branches-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-branches-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-locations-collections-dataStores-branches-documents-get
  "Gets a Document.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of Document, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`. If the caller does not have permission to access the Document, regardless of whether or not it exists, a `PERMISSION_DENIED` error is returned. If the requested Document does not exist, a `NOT_FOUND` error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-branches-documents-list
  "Gets a list of Documents.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent branch resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`. Use `default_branch` as the branch ID, to list documents under the default branch. If the caller does not have permission to list Documents under this branch, regardless of whether or not this branch exists, a `PERMISSION_DENIED` error is returned.

optional:
pageSize <integer> Maximum number of Documents to return. If unspecified, defaults to 100. The maximum allowed value is 1000. Values above 1000 are set to 1000. If this field is negative, an `INVALID_ARGUMENT` error is returned."
  ([parent]
    (projects-locations-collections-dataStores-branches-documents-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/documents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-branches-documents-create
  "Creates a Document.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
GoogleCloudDiscoveryengineV1Document:
{:content {:rawBytes string, :uri string, :mimeType string},
 :parentDocumentId string,
 :name string,
 :indexTime string,
 :schemaId string,
 :structData object,
 :id string,
 :jsonData string,
 :derivedStructData object}

optional:
documentId <string> Required. The ID to use for the Document, which becomes the final component of the Document.name. If the caller does not have permission to create the Document, regardless of whether or not it exists, a `PERMISSION_DENIED` error is returned. This field must be unique among all Documents with the same parent. Otherwise, an `ALREADY_EXISTS` error is returned. This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned."
  ([parent GoogleCloudDiscoveryengineV1Document]
    (projects-locations-collections-dataStores-branches-documents-create
      parent
      GoogleCloudDiscoveryengineV1Document
      nil))
  ([parent GoogleCloudDiscoveryengineV1Document optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/documents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Document})))

(defn projects-locations-collections-dataStores-branches-documents-patch
  "Updates a Document.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. The full resource name of the document. Format: `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document_id}`. This field must be a UTF-8 encoded string with a length limit of 1024 characters.
GoogleCloudDiscoveryengineV1Document:
{:content {:rawBytes string, :uri string, :mimeType string},
 :parentDocumentId string,
 :name string,
 :indexTime string,
 :schemaId string,
 :structData object,
 :id string,
 :jsonData string,
 :derivedStructData object}

optional:
allowMissing <boolean> If set to `true` and the Document is not found, a new Document is be created.
updateMask <string> Indicates which fields in the provided imported 'document' to update. If not set, by default updates all fields."
  ([name GoogleCloudDiscoveryengineV1Document]
    (projects-locations-collections-dataStores-branches-documents-patch
      name
      GoogleCloudDiscoveryengineV1Document
      nil))
  ([name GoogleCloudDiscoveryengineV1Document optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Document})))

(defn projects-locations-collections-dataStores-branches-documents-delete
  "Deletes a Document.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of Document, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`. If the caller does not have permission to delete the Document, regardless of whether or not it exists, a `PERMISSION_DENIED` error is returned. If the Document to delete does not exist, a `NOT_FOUND` error is returned."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-branches-documents-import
  "Bulk import of multiple Documents. Request processing may be synchronous. Non-existing items are created. Note: It is possible for a subset of the Documents to be successfully updated.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent branch resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`. Requires create/update permission.
GoogleCloudDiscoveryengineV1ImportDocumentsRequest:
{:updateMask string,
 :autoGenerateIds boolean,
 :idField string,
 :bigquerySource
 {:partitionDate {:year integer, :month integer, :day integer},
  :projectId string,
  :datasetId string,
  :tableId string,
  :gcsStagingDir string,
  :dataSchema string},
 :spannerSource
 {:projectId string,
  :instanceId string,
  :databaseId string,
  :tableId string,
  :enableDataBoost boolean},
 :bigtableSource
 {:projectId string,
  :instanceId string,
  :tableId string,
  :bigtableOptions {:keyFieldName string, :families object}},
 :firestoreSource
 {:projectId string,
  :databaseId string,
  :collectionId string,
  :gcsStagingDir string},
 :reconciliationMode
 [RECONCILIATION_MODE_UNSPECIFIED INCREMENTAL FULL],
 :cloudSqlSource
 {:projectId string,
  :instanceId string,
  :databaseId string,
  :tableId string,
  :gcsStagingDir string,
  :offload boolean},
 :errorConfig {:gcsPrefix string},
 :alloyDbSource
 {:projectId string,
  :locationId string,
  :clusterId string,
  :databaseId string,
  :tableId string,
  :gcsStagingDir string},
 :inlineSource
 {:documents
  [{:content {:rawBytes string, :uri string, :mimeType string},
    :parentDocumentId string,
    :name string,
    :indexTime string,
    :schemaId string,
    :structData object,
    :id string,
    :jsonData string,
    :derivedStructData object}]},
 :fhirStoreSource {:fhirStore string, :gcsStagingDir string},
 :gcsSource {:inputUris [string], :dataSchema string}}"
  [parent GoogleCloudDiscoveryengineV1ImportDocumentsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/documents:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ImportDocumentsRequest}))

(defn projects-locations-collections-dataStores-branches-documents-purge
  "Permanently deletes all selected Documents in a branch. This process is asynchronous. Depending on the number of Documents to be deleted, this operation can take hours to complete. Before the delete operation completes, some Documents might still be returned by DocumentService.GetDocument or DocumentService.ListDocuments. To get a list of the Documents to be deleted, set PurgeDocumentsRequest.force to false.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
GoogleCloudDiscoveryengineV1PurgeDocumentsRequest:
{:filter string, :force boolean}"
  [parent GoogleCloudDiscoveryengineV1PurgeDocumentsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/documents:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1PurgeDocumentsRequest}))

(defn projects-locations-collections-dataStores-controls-create
  "Creates a Control. By default 1000 controls are allowed for a data store. A request can be submitted to adjust this limit. If the Control to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}` or `projects/{project_number}/locations/{location_id}/collections/{collection_id}/engines/{engine_id}`.
GoogleCloudDiscoveryengineV1Control:
{:useCases
 [[SEARCH_USE_CASE_UNSPECIFIED
   SEARCH_USE_CASE_SEARCH
   SEARCH_USE_CASE_BROWSE]],
 :solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :redirectAction {:redirectUri string},
 :synonymsAction {:synonyms [string]},
 :conditions
 [{:queryTerms [{:value string, :fullMatch boolean}],
   :activeTimeRange [{:startTime string, :endTime string}]}],
 :associatedServingConfigIds [string],
 :boostAction {:boost number, :filter string, :dataStore string},
 :filterAction {:filter string, :dataStore string}}

optional:
controlId <string> Required. The ID to use for the Control, which will become the final component of the Control's resource name. This value must be within 1-63 characters. Valid characters are /a-z-_/."
  ([parent GoogleCloudDiscoveryengineV1Control]
    (projects-locations-collections-dataStores-controls-create
      parent
      GoogleCloudDiscoveryengineV1Control
      nil))
  ([parent GoogleCloudDiscoveryengineV1Control optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/controls",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Control})))

(defn projects-locations-collections-dataStores-controls-delete
  "Deletes a Control. If the Control to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Control to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-controls-patch
  "Updates a Control. Control action type cannot be changed. If the Control to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/*/locations/global/dataStore/*/controls/*`
GoogleCloudDiscoveryengineV1Control:
{:useCases
 [[SEARCH_USE_CASE_UNSPECIFIED
   SEARCH_USE_CASE_SEARCH
   SEARCH_USE_CASE_BROWSE]],
 :solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :redirectAction {:redirectUri string},
 :synonymsAction {:synonyms [string]},
 :conditions
 [{:queryTerms [{:value string, :fullMatch boolean}],
   :activeTimeRange [{:startTime string, :endTime string}]}],
 :associatedServingConfigIds [string],
 :boostAction {:boost number, :filter string, :dataStore string},
 :filterAction {:filter string, :dataStore string}}

optional:
updateMask <string> Optional. Indicates which fields in the provided Control to update. The following are NOT supported: * Control.name * Control.solution_type If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Control]
    (projects-locations-collections-dataStores-controls-patch
      name
      GoogleCloudDiscoveryengineV1Control
      nil))
  ([name GoogleCloudDiscoveryengineV1Control optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Control})))

(defn projects-locations-collections-dataStores-controls-get
  "Gets a Control.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Control to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-controls-list
  "Lists all Controls by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}` or `projects/{project_number}/locations/{location_id}/collections/{collection_id}/engines/{engine_id}`.

optional:
pageSize <integer> Optional. Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> Optional. A filter to apply on the list results. Supported features: * List all the products under the parent branch if filter is unset. Currently this field is unsupported."
  ([parent]
    (projects-locations-collections-dataStores-controls-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/controls",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-suggestionDenyListEntries-import
  "Imports all SuggestionDenyListEntry for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to import denylist entries. Follows pattern projects/*/locations/*/collections/*/dataStores/*.
GoogleCloudDiscoveryengineV1ImportSuggestionDenyListEntriesRequest:
{:inlineSource
 {:entries
  [{:blockPhrase string,
    :matchOperator
    [MATCH_OPERATOR_UNSPECIFIED EXACT_MATCH CONTAINS]}]},
 :gcsSource {:inputUris [string], :dataSchema string}}"
  [parent
   GoogleCloudDiscoveryengineV1ImportSuggestionDenyListEntriesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/suggestionDenyListEntries:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1ImportSuggestionDenyListEntriesRequest}))

(defn projects-locations-collections-dataStores-suggestionDenyListEntries-purge
  "Permanently deletes all SuggestionDenyListEntry for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to import denylist entries. Follows pattern projects/*/locations/*/collections/*/dataStores/*.
GoogleCloudDiscoveryengineV1PurgeSuggestionDenyListEntriesRequest:
object"
  [parent
   GoogleCloudDiscoveryengineV1PurgeSuggestionDenyListEntriesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/suggestionDenyListEntries:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1PurgeSuggestionDenyListEntriesRequest}))

(defn projects-locations-collections-dataStores-models-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-dataStores-models-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-models-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-schemas-get
  "Gets a Schema.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The full resource name of the schema, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-schemas-list
  "Gets a list of Schemas.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.

optional:
pageSize <integer> The maximum number of Schemas to return. The service may return fewer than this value. If unspecified, at most 100 Schemas are returned. The maximum value is 1000; values above 1000 are set to 1000."
  ([parent]
    (projects-locations-collections-dataStores-schemas-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/schemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-schemas-create
  "Creates a Schema.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.
GoogleCloudDiscoveryengineV1Schema:
{:structSchema object, :jsonSchema string, :name string}

optional:
schemaId <string> Required. The ID to use for the Schema, which becomes the final component of the Schema.name. This field should conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length limit of 63 characters."
  ([parent GoogleCloudDiscoveryengineV1Schema]
    (projects-locations-collections-dataStores-schemas-create
      parent
      GoogleCloudDiscoveryengineV1Schema
      nil))
  ([parent GoogleCloudDiscoveryengineV1Schema optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/schemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Schema})))

(defn projects-locations-collections-dataStores-schemas-patch
  "Updates a Schema.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. The full resource name of the schema, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`. This field must be a UTF-8 encoded string with a length limit of 1024 characters.
GoogleCloudDiscoveryengineV1Schema:
{:structSchema object, :jsonSchema string, :name string}

optional:
allowMissing <boolean> If set to true, and the Schema is not found, a new Schema is created. In this situation, `update_mask` is ignored."
  ([name GoogleCloudDiscoveryengineV1Schema]
    (projects-locations-collections-dataStores-schemas-patch
      name
      GoogleCloudDiscoveryengineV1Schema
      nil))
  ([name GoogleCloudDiscoveryengineV1Schema optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Schema})))

(defn projects-locations-collections-dataStores-schemas-delete
  "Deletes a Schema.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The full resource name of the schema, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-schemas-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-dataStores-schemas-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-schemas-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-servingConfigs-search
  "Performs a search.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. The resource name of the Search serving config, such as `projects/*/locations/global/collections/default_collection/engines/*/servingConfigs/default_serving_config`, or `projects/*/locations/global/collections/default_collection/dataStores/default_data_store/servingConfigs/default_serving_config`. This field is used to identify the serving configuration name, set of models used to make the search.
GoogleCloudDiscoveryengineV1SearchRequest:
{:canonicalFilter string,
 :contentSearchSpec
 {:snippetSpec
  {:maxSnippetCount integer,
   :referenceOnly boolean,
   :returnSnippet boolean},
  :summarySpec
  {:summaryResultCount integer,
   :includeCitations boolean,
   :ignoreAdversarialQuery boolean,
   :ignoreNonSummarySeekingQuery boolean,
   :modelPromptSpec {:preamble string},
   :languageCode string,
   :modelSpec {:version string},
   :useSemanticChunks boolean},
  :extractiveContentSpec
  {:maxExtractiveAnswerCount integer,
   :maxExtractiveSegmentCount integer,
   :returnExtractiveSegmentScore boolean,
   :numPreviousSegments integer,
   :numNextSegments integer},
  :searchResultMode [SEARCH_RESULT_MODE_UNSPECIFIED DOCUMENTS CHUNKS],
  :chunkSpec {:numPreviousChunks integer, :numNextChunks integer}},
 :offset integer,
 :imageQuery {:imageBytes string},
 :params object,
 :userPseudoId string,
 :safeSearch boolean,
 :pageToken string,
 :facetSpecs
 [{:facetKey
   {:key string,
    :intervals
    [{:minimum number,
      :exclusiveMinimum number,
      :maximum number,
      :exclusiveMaximum number}],
    :restrictedValues [string],
    :prefixes [string],
    :contains [string],
    :caseInsensitive boolean,
    :orderBy string},
   :limit integer,
   :excludedFilterKeys [string],
   :enableDynamicPosition boolean}],
 :filter string,
 :languageCode string,
 :pageSize integer,
 :query string,
 :branch string,
 :userLabels object,
 :dataStoreSpecs [{:dataStore string}],
 :queryExpansionSpec
 {:condition [CONDITION_UNSPECIFIED DISABLED AUTO],
  :pinUnexpandedResults boolean},
 :boostSpec
 {:conditionBoostSpecs [{:condition string, :boost number}]},
 :spellCorrectionSpec {:mode [MODE_UNSPECIFIED SUGGESTION_ONLY AUTO]},
 :userInfo {:userId string, :userAgent string},
 :orderBy string}"
  [servingConfig GoogleCloudDiscoveryengineV1SearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:search",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1SearchRequest}))

(defn projects-locations-collections-dataStores-servingConfigs-answer
  "Answer query method.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. The resource name of the Search serving config, such as `projects/*/locations/global/collections/default_collection/engines/*/servingConfigs/default_serving_config`, or `projects/*/locations/global/collections/default_collection/dataStores/*/servingConfigs/default_serving_config`. This field is used to identify the serving configuration name, set of models used to make the search.
GoogleCloudDiscoveryengineV1AnswerQueryRequest:
{:relatedQuestionsSpec {:enable boolean},
 :safetySpec {:enable boolean},
 :queryUnderstandingSpec
 {:queryClassificationSpec
  {:types
   [[TYPE_UNSPECIFIED ADVERSARIAL_QUERY NON_ANSWER_SEEKING_QUERY]]},
  :queryRephraserSpec {:disable boolean}},
 :userPseudoId string,
 :asynchronousMode boolean,
 :searchSpec
 {:searchParams
  {:maxReturnResults integer,
   :filter string,
   :boostSpec
   {:conditionBoostSpecs [{:condition string, :boost number}]},
   :orderBy string,
   :searchResultMode [SEARCH_RESULT_MODE_UNSPECIFIED DOCUMENTS CHUNKS],
   :dataStoreSpecs [{:dataStore string}]},
  :searchResultList
  {:searchResults
   [{:unstructuredDocumentInfo
     {:document string,
      :uri string,
      :title string,
      :documentContexts
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoDocumentContext],
      :extractiveSegments
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoExtractiveSegment],
      :extractiveAnswers
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoExtractiveAnswer]},
     :chunkInfo {:chunk string, :content string}}]}},
 :query {:text string, :queryId string},
 :userLabels object,
 :answerGenerationSpec
 {:modelSpec {:modelVersion string},
  :promptSpec {:preamble string},
  :includeCitations boolean,
  :answerLanguageCode string,
  :ignoreAdversarialQuery boolean,
  :ignoreNonAnswerSeekingQuery boolean,
  :ignoreLowRelevantContent boolean},
 :session string}"
  [servingConfig GoogleCloudDiscoveryengineV1AnswerQueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:answer",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1AnswerQueryRequest}))

(defn projects-locations-collections-dataStores-servingConfigs-recommend
  "Makes a recommendation, which requires a contextual user event.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. Full resource name of a ServingConfig: `projects/*/locations/global/collections/*/engines/*/servingConfigs/*`, or `projects/*/locations/global/collections/*/dataStores/*/servingConfigs/*` One default serving config is created along with your recommendation engine creation. The engine ID is used as the ID of the default serving config. For example, for Engine `projects/*/locations/global/collections/*/engines/my-engine`, you can use `projects/*/locations/global/collections/*/engines/my-engine/servingConfigs/my-engine` for your RecommendationService.Recommend requests.
GoogleCloudDiscoveryengineV1RecommendRequest:
{:userEvent
 {:eventType string,
  :tagIds [string],
  :transactionInfo
  {:value number,
   :currency string,
   :transactionId string,
   :tax number,
   :cost number,
   :discountValue number},
  :sessionId string,
  :searchInfo {:searchQuery string, :orderBy string, :offset integer},
  :userPseudoId string,
  :dataStore string,
  :panel
  {:panelId string,
   :displayName string,
   :panelPosition integer,
   :totalPanels integer},
  :documents
  [{:id string,
    :name string,
    :uri string,
    :quantity integer,
    :promotionIds [string]}],
  :directUserRequest boolean,
  :filter string,
  :completionInfo
  {:selectedSuggestion string, :selectedPosition integer},
  :mediaInfo
  {:mediaProgressDuration string, :mediaProgressPercentage number},
  :pageInfo
  {:pageviewId string,
   :pageCategory string,
   :uri string,
   :referrerUri string},
  :eventTime string,
  :engine string,
  :promotionIds [string],
  :attributes object,
  :attributionToken string,
  :userInfo {:userId string, :userAgent string}},
 :pageSize integer,
 :filter string,
 :validateOnly boolean,
 :params object,
 :userLabels object}"
  [servingConfig GoogleCloudDiscoveryengineV1RecommendRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:recommend",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1RecommendRequest}))

(defn projects-locations-collections-dataStores-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-dataStores-operations-list
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-sessions-create
  "Creates a Session. If the Session to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
GoogleCloudDiscoveryengineV1Session:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS],
 :userPseudoId string,
 :turns [{:query {:text string, :queryId string}, :answer string}],
 :startTime string,
 :endTime string}"
  [parent GoogleCloudDiscoveryengineV1Session]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/sessions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1Session}))

(defn projects-locations-collections-dataStores-sessions-delete
  "Deletes a Session. If the Session to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Session to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-sessions-patch
  "Updates a Session. Session action type cannot be changed. If the Session to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/{project}/locations/global/collections/{collection}/engines/{engine}/sessions/*`
GoogleCloudDiscoveryengineV1Session:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS],
 :userPseudoId string,
 :turns [{:query {:text string, :queryId string}, :answer string}],
 :startTime string,
 :endTime string}

optional:
updateMask <string> Indicates which fields in the provided Session to update. The following are NOT supported: * Session.name If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Session]
    (projects-locations-collections-dataStores-sessions-patch
      name
      GoogleCloudDiscoveryengineV1Session
      nil))
  ([name GoogleCloudDiscoveryengineV1Session optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Session})))

(defn projects-locations-collections-dataStores-sessions-get
  "Gets a Session.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Session to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-dataStores-sessions-list
  "Lists all Sessions by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`

optional:
pageSize <integer> Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> A filter to apply on the list results. The supported features are: user_pseudo_id, state. Example: \"user_pseudo_id = some_id\"
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `update_time` * `create_time` * `session_name` Example: \"update_time desc\" \"create_time\""
  ([parent]
    (projects-locations-collections-dataStores-sessions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/sessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-dataStores-sessions-answers-get
  "Gets a Answer.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Answer to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/engines/{engine_id}/sessions/{session_id}/answers/{answer_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-create
  "Creates a Engine.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection}`.
GoogleCloudDiscoveryengineV1Engine:
{:solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :industryVertical
 [INDUSTRY_VERTICAL_UNSPECIFIED GENERIC MEDIA HEALTHCARE_FHIR],
 :createTime string,
 :updateTime string,
 :dataStoreIds [string],
 :searchEngineConfig
 {:searchTier
  [SEARCH_TIER_UNSPECIFIED
   SEARCH_TIER_STANDARD
   SEARCH_TIER_ENTERPRISE],
  :searchAddOns [[SEARCH_ADD_ON_UNSPECIFIED SEARCH_ADD_ON_LLM]]},
 :chatEngineMetadata {:dialogflowAgent string},
 :chatEngineConfig
 {:agentCreationConfig
  {:business string,
   :defaultLanguageCode string,
   :timeZone string,
   :location string},
  :dialogflowAgentToLink string},
 :commonConfig {:companyName string}}

optional:
engineId <string> Required. The ID to use for the Engine, which will become the final component of the Engine's resource name. This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned."
  ([parent GoogleCloudDiscoveryengineV1Engine]
    (projects-locations-collections-engines-create
      parent
      GoogleCloudDiscoveryengineV1Engine
      nil))
  ([parent GoogleCloudDiscoveryengineV1Engine optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/engines",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Engine})))

(defn projects-locations-collections-engines-delete
  "Deletes a Engine.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of Engine, such as `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`. If the caller does not have permission to delete the Engine, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the Engine to delete does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-patch
  "Updates an Engine
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. The fully qualified resource name of the engine. This field must be a UTF-8 encoded string with a length limit of 1024 characters. Format: `projects/{project_number}/locations/{location}/collections/{collection}/engines/{engine}` engine should be 1-63 characters, and valid characters are /a-z0-9*/. Otherwise, an INVALID_ARGUMENT error is returned.
GoogleCloudDiscoveryengineV1Engine:
{:solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :industryVertical
 [INDUSTRY_VERTICAL_UNSPECIFIED GENERIC MEDIA HEALTHCARE_FHIR],
 :createTime string,
 :updateTime string,
 :dataStoreIds [string],
 :searchEngineConfig
 {:searchTier
  [SEARCH_TIER_UNSPECIFIED
   SEARCH_TIER_STANDARD
   SEARCH_TIER_ENTERPRISE],
  :searchAddOns [[SEARCH_ADD_ON_UNSPECIFIED SEARCH_ADD_ON_LLM]]},
 :chatEngineMetadata {:dialogflowAgent string},
 :chatEngineConfig
 {:agentCreationConfig
  {:business string,
   :defaultLanguageCode string,
   :timeZone string,
   :location string},
  :dialogflowAgentToLink string},
 :commonConfig {:companyName string}}

optional:
updateMask <string> Indicates which fields in the provided Engine to update. If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned."
  ([name GoogleCloudDiscoveryengineV1Engine]
    (projects-locations-collections-engines-patch
      name
      GoogleCloudDiscoveryengineV1Engine
      nil))
  ([name GoogleCloudDiscoveryengineV1Engine optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Engine})))

(defn projects-locations-collections-engines-get
  "Gets a Engine.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of Engine, such as `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-list
  "Lists all the Engines associated with the project.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection_id}`.

optional:
pageSize <integer> Optional. Not supported.
filter <string> Optional. Filter by solution type. For example: solution_type=SOLUTION_TYPE_SEARCH"
  ([parent] (projects-locations-collections-engines-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/engines",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-engines-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-collections-engines-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-engines-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-controls-create
  "Creates a Control. By default 1000 controls are allowed for a data store. A request can be submitted to adjust this limit. If the Control to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}` or `projects/{project_number}/locations/{location_id}/collections/{collection_id}/engines/{engine_id}`.
GoogleCloudDiscoveryengineV1Control:
{:useCases
 [[SEARCH_USE_CASE_UNSPECIFIED
   SEARCH_USE_CASE_SEARCH
   SEARCH_USE_CASE_BROWSE]],
 :solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :redirectAction {:redirectUri string},
 :synonymsAction {:synonyms [string]},
 :conditions
 [{:queryTerms [{:value string, :fullMatch boolean}],
   :activeTimeRange [{:startTime string, :endTime string}]}],
 :associatedServingConfigIds [string],
 :boostAction {:boost number, :filter string, :dataStore string},
 :filterAction {:filter string, :dataStore string}}

optional:
controlId <string> Required. The ID to use for the Control, which will become the final component of the Control's resource name. This value must be within 1-63 characters. Valid characters are /a-z-_/."
  ([parent GoogleCloudDiscoveryengineV1Control]
    (projects-locations-collections-engines-controls-create
      parent
      GoogleCloudDiscoveryengineV1Control
      nil))
  ([parent GoogleCloudDiscoveryengineV1Control optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/controls",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Control})))

(defn projects-locations-collections-engines-controls-delete
  "Deletes a Control. If the Control to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Control to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-controls-patch
  "Updates a Control. Control action type cannot be changed. If the Control to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/*/locations/global/dataStore/*/controls/*`
GoogleCloudDiscoveryengineV1Control:
{:useCases
 [[SEARCH_USE_CASE_UNSPECIFIED
   SEARCH_USE_CASE_SEARCH
   SEARCH_USE_CASE_BROWSE]],
 :solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :redirectAction {:redirectUri string},
 :synonymsAction {:synonyms [string]},
 :conditions
 [{:queryTerms [{:value string, :fullMatch boolean}],
   :activeTimeRange [{:startTime string, :endTime string}]}],
 :associatedServingConfigIds [string],
 :boostAction {:boost number, :filter string, :dataStore string},
 :filterAction {:filter string, :dataStore string}}

optional:
updateMask <string> Optional. Indicates which fields in the provided Control to update. The following are NOT supported: * Control.name * Control.solution_type If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Control]
    (projects-locations-collections-engines-controls-patch
      name
      GoogleCloudDiscoveryengineV1Control
      nil))
  ([name GoogleCloudDiscoveryengineV1Control optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Control})))

(defn projects-locations-collections-engines-controls-get
  "Gets a Control.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Control to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-controls-list
  "Lists all Controls by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}` or `projects/{project_number}/locations/{location_id}/collections/{collection_id}/engines/{engine_id}`.

optional:
pageSize <integer> Optional. Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> Optional. A filter to apply on the list results. Supported features: * List all the products under the parent branch if filter is unset. Currently this field is unsupported."
  ([parent]
    (projects-locations-collections-engines-controls-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/controls",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-engines-servingConfigs-search
  "Performs a search.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. The resource name of the Search serving config, such as `projects/*/locations/global/collections/default_collection/engines/*/servingConfigs/default_serving_config`, or `projects/*/locations/global/collections/default_collection/dataStores/default_data_store/servingConfigs/default_serving_config`. This field is used to identify the serving configuration name, set of models used to make the search.
GoogleCloudDiscoveryengineV1SearchRequest:
{:canonicalFilter string,
 :contentSearchSpec
 {:snippetSpec
  {:maxSnippetCount integer,
   :referenceOnly boolean,
   :returnSnippet boolean},
  :summarySpec
  {:summaryResultCount integer,
   :includeCitations boolean,
   :ignoreAdversarialQuery boolean,
   :ignoreNonSummarySeekingQuery boolean,
   :modelPromptSpec {:preamble string},
   :languageCode string,
   :modelSpec {:version string},
   :useSemanticChunks boolean},
  :extractiveContentSpec
  {:maxExtractiveAnswerCount integer,
   :maxExtractiveSegmentCount integer,
   :returnExtractiveSegmentScore boolean,
   :numPreviousSegments integer,
   :numNextSegments integer},
  :searchResultMode [SEARCH_RESULT_MODE_UNSPECIFIED DOCUMENTS CHUNKS],
  :chunkSpec {:numPreviousChunks integer, :numNextChunks integer}},
 :offset integer,
 :imageQuery {:imageBytes string},
 :params object,
 :userPseudoId string,
 :safeSearch boolean,
 :pageToken string,
 :facetSpecs
 [{:facetKey
   {:key string,
    :intervals
    [{:minimum number,
      :exclusiveMinimum number,
      :maximum number,
      :exclusiveMaximum number}],
    :restrictedValues [string],
    :prefixes [string],
    :contains [string],
    :caseInsensitive boolean,
    :orderBy string},
   :limit integer,
   :excludedFilterKeys [string],
   :enableDynamicPosition boolean}],
 :filter string,
 :languageCode string,
 :pageSize integer,
 :query string,
 :branch string,
 :userLabels object,
 :dataStoreSpecs [{:dataStore string}],
 :queryExpansionSpec
 {:condition [CONDITION_UNSPECIFIED DISABLED AUTO],
  :pinUnexpandedResults boolean},
 :boostSpec
 {:conditionBoostSpecs [{:condition string, :boost number}]},
 :spellCorrectionSpec {:mode [MODE_UNSPECIFIED SUGGESTION_ONLY AUTO]},
 :userInfo {:userId string, :userAgent string},
 :orderBy string}"
  [servingConfig GoogleCloudDiscoveryengineV1SearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:search",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1SearchRequest}))

(defn projects-locations-collections-engines-servingConfigs-answer
  "Answer query method.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. The resource name of the Search serving config, such as `projects/*/locations/global/collections/default_collection/engines/*/servingConfigs/default_serving_config`, or `projects/*/locations/global/collections/default_collection/dataStores/*/servingConfigs/default_serving_config`. This field is used to identify the serving configuration name, set of models used to make the search.
GoogleCloudDiscoveryengineV1AnswerQueryRequest:
{:relatedQuestionsSpec {:enable boolean},
 :safetySpec {:enable boolean},
 :queryUnderstandingSpec
 {:queryClassificationSpec
  {:types
   [[TYPE_UNSPECIFIED ADVERSARIAL_QUERY NON_ANSWER_SEEKING_QUERY]]},
  :queryRephraserSpec {:disable boolean}},
 :userPseudoId string,
 :asynchronousMode boolean,
 :searchSpec
 {:searchParams
  {:maxReturnResults integer,
   :filter string,
   :boostSpec
   {:conditionBoostSpecs [{:condition string, :boost number}]},
   :orderBy string,
   :searchResultMode [SEARCH_RESULT_MODE_UNSPECIFIED DOCUMENTS CHUNKS],
   :dataStoreSpecs [{:dataStore string}]},
  :searchResultList
  {:searchResults
   [{:unstructuredDocumentInfo
     {:document string,
      :uri string,
      :title string,
      :documentContexts
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoDocumentContext],
      :extractiveSegments
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoExtractiveSegment],
      :extractiveAnswers
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoExtractiveAnswer]},
     :chunkInfo {:chunk string, :content string}}]}},
 :query {:text string, :queryId string},
 :userLabels object,
 :answerGenerationSpec
 {:modelSpec {:modelVersion string},
  :promptSpec {:preamble string},
  :includeCitations boolean,
  :answerLanguageCode string,
  :ignoreAdversarialQuery boolean,
  :ignoreNonAnswerSeekingQuery boolean,
  :ignoreLowRelevantContent boolean},
 :session string}"
  [servingConfig GoogleCloudDiscoveryengineV1AnswerQueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:answer",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1AnswerQueryRequest}))

(defn projects-locations-collections-engines-servingConfigs-recommend
  "Makes a recommendation, which requires a contextual user event.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. Full resource name of a ServingConfig: `projects/*/locations/global/collections/*/engines/*/servingConfigs/*`, or `projects/*/locations/global/collections/*/dataStores/*/servingConfigs/*` One default serving config is created along with your recommendation engine creation. The engine ID is used as the ID of the default serving config. For example, for Engine `projects/*/locations/global/collections/*/engines/my-engine`, you can use `projects/*/locations/global/collections/*/engines/my-engine/servingConfigs/my-engine` for your RecommendationService.Recommend requests.
GoogleCloudDiscoveryengineV1RecommendRequest:
{:userEvent
 {:eventType string,
  :tagIds [string],
  :transactionInfo
  {:value number,
   :currency string,
   :transactionId string,
   :tax number,
   :cost number,
   :discountValue number},
  :sessionId string,
  :searchInfo {:searchQuery string, :orderBy string, :offset integer},
  :userPseudoId string,
  :dataStore string,
  :panel
  {:panelId string,
   :displayName string,
   :panelPosition integer,
   :totalPanels integer},
  :documents
  [{:id string,
    :name string,
    :uri string,
    :quantity integer,
    :promotionIds [string]}],
  :directUserRequest boolean,
  :filter string,
  :completionInfo
  {:selectedSuggestion string, :selectedPosition integer},
  :mediaInfo
  {:mediaProgressDuration string, :mediaProgressPercentage number},
  :pageInfo
  {:pageviewId string,
   :pageCategory string,
   :uri string,
   :referrerUri string},
  :eventTime string,
  :engine string,
  :promotionIds [string],
  :attributes object,
  :attributionToken string,
  :userInfo {:userId string, :userAgent string}},
 :pageSize integer,
 :filter string,
 :validateOnly boolean,
 :params object,
 :userLabels object}"
  [servingConfig GoogleCloudDiscoveryengineV1RecommendRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:recommend",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1RecommendRequest}))

(defn projects-locations-collections-engines-conversations-converse
  "Converses a conversation.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`. Use `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/-` to activate auto session mode, which automatically creates a new conversation inside a ConverseConversation session.
GoogleCloudDiscoveryengineV1ConverseConversationRequest:
{:query
 {:input string,
  :context {:contextDocuments [string], :activeDocument string}},
 :servingConfig string,
 :conversation
 {:name string,
  :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
  :userPseudoId string,
  :messages
  [{:userInput
    {:input string,
     :context {:contextDocuments [string], :activeDocument string}},
    :reply
    {:summary
     {:summaryText string,
      :summarySkippedReasons
      [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
        ADVERSARIAL_QUERY_IGNORED
        NON_SUMMARY_SEEKING_QUERY_IGNORED
        OUT_OF_DOMAIN_QUERY_IGNORED
        POTENTIAL_POLICY_VIOLATION
        LLM_ADDON_NOT_ENABLED]],
      :safetyAttributes
      GoogleCloudDiscoveryengineV1SearchResponseSummarySafetyAttributes,
      :summaryWithMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummarySummaryWithMetadata}},
    :createTime string}],
  :startTime string,
  :endTime string},
 :safeSearch boolean,
 :userLabels object,
 :summarySpec
 {:summaryResultCount integer,
  :includeCitations boolean,
  :ignoreAdversarialQuery boolean,
  :ignoreNonSummarySeekingQuery boolean,
  :modelPromptSpec {:preamble string},
  :languageCode string,
  :modelSpec {:version string},
  :useSemanticChunks boolean},
 :filter string,
 :boostSpec {:conditionBoostSpecs [{:condition string, :boost number}]}}"
  [name GoogleCloudDiscoveryengineV1ConverseConversationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+name}:converse",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ConverseConversationRequest}))

(defn projects-locations-collections-engines-conversations-create
  "Creates a Conversation. If the Conversation to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
GoogleCloudDiscoveryengineV1Conversation:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
 :userPseudoId string,
 :messages
 [{:userInput
   {:input string,
    :context {:contextDocuments [string], :activeDocument string}},
   :reply
   {:summary
    {:summaryText string,
     :summarySkippedReasons
     [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
       ADVERSARIAL_QUERY_IGNORED
       NON_SUMMARY_SEEKING_QUERY_IGNORED
       OUT_OF_DOMAIN_QUERY_IGNORED
       POTENTIAL_POLICY_VIOLATION
       LLM_ADDON_NOT_ENABLED]],
     :safetyAttributes {:categories [string], :scores [number]},
     :summaryWithMetadata
     {:summary string,
      :citationMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummaryCitationMetadata,
      :references
      [GoogleCloudDiscoveryengineV1SearchResponseSummaryReference]}}},
   :createTime string}],
 :startTime string,
 :endTime string}"
  [parent GoogleCloudDiscoveryengineV1Conversation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/conversations",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1Conversation}))

(defn projects-locations-collections-engines-conversations-delete
  "Deletes a Conversation. If the Conversation to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-conversations-patch
  "Updates a Conversation. Conversation action type cannot be changed. If the Conversation to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/{project}/locations/global/collections/{collection}/dataStore/*/conversations/*` or `projects/{project}/locations/global/collections/{collection}/engines/*/conversations/*`.
GoogleCloudDiscoveryengineV1Conversation:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
 :userPseudoId string,
 :messages
 [{:userInput
   {:input string,
    :context {:contextDocuments [string], :activeDocument string}},
   :reply
   {:summary
    {:summaryText string,
     :summarySkippedReasons
     [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
       ADVERSARIAL_QUERY_IGNORED
       NON_SUMMARY_SEEKING_QUERY_IGNORED
       OUT_OF_DOMAIN_QUERY_IGNORED
       POTENTIAL_POLICY_VIOLATION
       LLM_ADDON_NOT_ENABLED]],
     :safetyAttributes {:categories [string], :scores [number]},
     :summaryWithMetadata
     {:summary string,
      :citationMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummaryCitationMetadata,
      :references
      [GoogleCloudDiscoveryengineV1SearchResponseSummaryReference]}}},
   :createTime string}],
 :startTime string,
 :endTime string}

optional:
updateMask <string> Indicates which fields in the provided Conversation to update. The following are NOT supported: * Conversation.name If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Conversation]
    (projects-locations-collections-engines-conversations-patch
      name
      GoogleCloudDiscoveryengineV1Conversation
      nil))
  ([name GoogleCloudDiscoveryengineV1Conversation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Conversation})))

(defn projects-locations-collections-engines-conversations-get
  "Gets a Conversation.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-conversations-list
  "Lists all Conversations by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`

optional:
pageSize <integer> Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> A filter to apply on the list results. The supported features are: user_pseudo_id, state. Example: \"user_pseudo_id = some_id\"
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `update_time` * `create_time` * `conversation_name` Example: \"update_time desc\" \"create_time\""
  ([parent]
    (projects-locations-collections-engines-conversations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/conversations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-engines-sessions-create
  "Creates a Session. If the Session to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
GoogleCloudDiscoveryengineV1Session:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS],
 :userPseudoId string,
 :turns [{:query {:text string, :queryId string}, :answer string}],
 :startTime string,
 :endTime string}"
  [parent GoogleCloudDiscoveryengineV1Session]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/sessions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1Session}))

(defn projects-locations-collections-engines-sessions-delete
  "Deletes a Session. If the Session to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Session to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-sessions-patch
  "Updates a Session. Session action type cannot be changed. If the Session to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/{project}/locations/global/collections/{collection}/engines/{engine}/sessions/*`
GoogleCloudDiscoveryengineV1Session:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS],
 :userPseudoId string,
 :turns [{:query {:text string, :queryId string}, :answer string}],
 :startTime string,
 :endTime string}

optional:
updateMask <string> Indicates which fields in the provided Session to update. The following are NOT supported: * Session.name If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Session]
    (projects-locations-collections-engines-sessions-patch
      name
      GoogleCloudDiscoveryengineV1Session
      nil))
  ([name GoogleCloudDiscoveryengineV1Session optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Session})))

(defn projects-locations-collections-engines-sessions-get
  "Gets a Session.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Session to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-collections-engines-sessions-list
  "Lists all Sessions by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`

optional:
pageSize <integer> Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> A filter to apply on the list results. The supported features are: user_pseudo_id, state. Example: \"user_pseudo_id = some_id\"
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `update_time` * `create_time` * `session_name` Example: \"update_time desc\" \"create_time\""
  ([parent]
    (projects-locations-collections-engines-sessions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/sessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-collections-engines-sessions-answers-get
  "Gets a Answer.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Answer to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/engines/{engine_id}/sessions/{session_id}/answers/{answer_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-completeQuery
  "Completes the specified user input with keyword suggestions.
https://cloud.google.com/discovery-engine/media/docs

dataStore <string> Required. The parent data store resource name for which the completion is performed, such as `projects/*/locations/global/collections/default_collection/dataStores/default_data_store`.

optional:
query <string> Required. The typeahead input used to fetch suggestions. Maximum length is 128 characters.
queryModel <string> Specifies the autocomplete data model. This overrides any model specified in the Configuration > Autocomplete section of the Cloud console. Currently supported values: * `document` - Using suggestions generated from user-imported documents. * `search-history` - Using suggestions generated from the past history of SearchService.Search API calls. Do not use it when there is no traffic for Search API. * `user-event` - Using suggestions generated from user-imported search events. * `document-completable` - Using suggestions taken directly from user-imported document fields marked as completable. Default values: * `document` is the default model for regular dataStores. * `search-history` is the default model for site search dataStores.
userPseudoId <string> A unique identifier for tracking visitors. For example, this could be implemented with an HTTP cookie, which should be able to uniquely identify a visitor on a single device. This unique identifier should not change if the visitor logs in or out of the website. This field should NOT have a fixed value such as `unknown_visitor`. This should be the same identifier as UserEvent.user_pseudo_id and SearchRequest.user_pseudo_id. The field must be a UTF-8 encoded string with a length limit of 128 characters. Otherwise, an `INVALID_ARGUMENT` error is returned.
includeTailSuggestions <boolean> Indicates if tail suggestions should be returned if there are no suggestions that match the full query. Even if set to true, if there are suggestions that match the full query, those are returned and no tail suggestions are returned."
  ([dataStore]
    (projects-locations-dataStores-completeQuery dataStore nil))
  ([dataStore optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+dataStore}:completeQuery",
       :uri-template-args {:dataStore dataStore},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-create
  "Creates a DataStore. DataStore is for storing Documents. To serve these documents for Search, or Recommendation use case, an Engine needs to be created separately.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection}`.
GoogleCloudDiscoveryengineV1DataStore:
{:displayName string,
 :defaultSchemaId string,
 :name string,
 :industryVertical
 [INDUSTRY_VERTICAL_UNSPECIFIED GENERIC MEDIA HEALTHCARE_FHIR],
 :createTime string,
 :solutionTypes
 [[SOLUTION_TYPE_UNSPECIFIED
   SOLUTION_TYPE_RECOMMENDATION
   SOLUTION_TYPE_SEARCH
   SOLUTION_TYPE_CHAT
   SOLUTION_TYPE_GENERATIVE_CHAT]],
 :startingSchema
 {:structSchema object, :jsonSchema string, :name string},
 :contentConfig
 [CONTENT_CONFIG_UNSPECIFIED
  NO_CONTENT
  CONTENT_REQUIRED
  PUBLIC_WEBSITE],
 :documentProcessingConfig
 {:name string,
  :chunkingConfig
  {:layoutBasedChunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :defaultParsingConfig
  {:digitalParsingConfig object,
   :ocrParsingConfig
   {:enhancedDocumentElements [string], :useNativeText boolean},
   :layoutParsingConfig object},
  :parsingConfigOverrides object}}

optional:
dataStoreId <string> Required. The ID to use for the DataStore, which will become the final component of the DataStore's resource name. This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
createAdvancedSiteSearch <boolean> A boolean flag indicating whether user want to directly create an advanced data store for site search. If the data store is not configured as site search (GENERIC vertical and PUBLIC_WEBSITE content_config), this flag will be ignored."
  ([parent GoogleCloudDiscoveryengineV1DataStore]
    (projects-locations-dataStores-create
      parent
      GoogleCloudDiscoveryengineV1DataStore
      nil))
  ([parent GoogleCloudDiscoveryengineV1DataStore optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/dataStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1DataStore})))

(defn projects-locations-dataStores-get
  "Gets a DataStore.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of DataStore, such as `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`. If the caller does not have permission to access the DataStore, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the requested DataStore does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-list
  "Lists all the DataStores associated with the project.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent branch resource name, such as `projects/{project}/locations/{location}/collections/{collection_id}`. If the caller does not have permission to list DataStores under this location, regardless of whether or not this data store exists, a PERMISSION_DENIED error is returned.

optional:
pageSize <integer> Maximum number of DataStores to return. If unspecified, defaults to 10. The maximum allowed value is 50. Values above 50 will be coerced to 50. If this field is negative, an INVALID_ARGUMENT is returned.
filter <string> Filter by solution type . For example: `filter = 'solution_type:SOLUTION_TYPE_SEARCH'`"
  ([parent] (projects-locations-dataStores-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/dataStores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-delete
  "Deletes a DataStore.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of DataStore, such as `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`. If the caller does not have permission to delete the DataStore, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the DataStore to delete does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-patch
  "Updates a DataStore
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. The full resource name of the data store. Format: `projects/{project}/locations/{location}/collections/{collection_id}/dataStores/{data_store_id}`. This field must be a UTF-8 encoded string with a length limit of 1024 characters.
GoogleCloudDiscoveryengineV1DataStore:
{:displayName string,
 :defaultSchemaId string,
 :name string,
 :industryVertical
 [INDUSTRY_VERTICAL_UNSPECIFIED GENERIC MEDIA HEALTHCARE_FHIR],
 :createTime string,
 :solutionTypes
 [[SOLUTION_TYPE_UNSPECIFIED
   SOLUTION_TYPE_RECOMMENDATION
   SOLUTION_TYPE_SEARCH
   SOLUTION_TYPE_CHAT
   SOLUTION_TYPE_GENERATIVE_CHAT]],
 :startingSchema
 {:structSchema object, :jsonSchema string, :name string},
 :contentConfig
 [CONTENT_CONFIG_UNSPECIFIED
  NO_CONTENT
  CONTENT_REQUIRED
  PUBLIC_WEBSITE],
 :documentProcessingConfig
 {:name string,
  :chunkingConfig
  {:layoutBasedChunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :defaultParsingConfig
  {:digitalParsingConfig object,
   :ocrParsingConfig
   {:enhancedDocumentElements [string], :useNativeText boolean},
   :layoutParsingConfig object},
  :parsingConfigOverrides object}}

optional:
updateMask <string> Indicates which fields in the provided DataStore to update. If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned."
  ([name GoogleCloudDiscoveryengineV1DataStore]
    (projects-locations-dataStores-patch
      name
      GoogleCloudDiscoveryengineV1DataStore
      nil))
  ([name GoogleCloudDiscoveryengineV1DataStore optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1DataStore})))

(defn projects-locations-dataStores-getSiteSearchEngine
  "Gets the SiteSearchEngine.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Resource name of SiteSearchEngine, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`. If the caller does not have permission to access the [SiteSearchEngine], regardless of whether or not it exists, a PERMISSION_DENIED error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-siteSearchEngine-enableAdvancedSiteSearch
  "Upgrade from basic site search to advanced site search.
https://cloud.google.com/discovery-engine/media/docs

siteSearchEngine <string> Required. Full resource name of the SiteSearchEngine, such as `projects/{project}/locations/{location}/dataStores/{data_store_id}/siteSearchEngine`.
GoogleCloudDiscoveryengineV1EnableAdvancedSiteSearchRequest:
object"
  [siteSearchEngine
   GoogleCloudDiscoveryengineV1EnableAdvancedSiteSearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+siteSearchEngine}:enableAdvancedSiteSearch",
     :uri-template-args {:siteSearchEngine siteSearchEngine},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1EnableAdvancedSiteSearchRequest}))

(defn projects-locations-dataStores-siteSearchEngine-disableAdvancedSiteSearch
  "Downgrade from advanced site search to basic site search.
https://cloud.google.com/discovery-engine/media/docs

siteSearchEngine <string> Required. Full resource name of the SiteSearchEngine, such as `projects/{project}/locations/{location}/dataStores/{data_store_id}/siteSearchEngine`.
GoogleCloudDiscoveryengineV1DisableAdvancedSiteSearchRequest:
object"
  [siteSearchEngine
   GoogleCloudDiscoveryengineV1DisableAdvancedSiteSearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+siteSearchEngine}:disableAdvancedSiteSearch",
     :uri-template-args {:siteSearchEngine siteSearchEngine},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1DisableAdvancedSiteSearchRequest}))

(defn projects-locations-dataStores-siteSearchEngine-recrawlUris
  "Request on-demand recrawl for a list of URIs.
https://cloud.google.com/discovery-engine/media/docs

siteSearchEngine <string> Required. Full resource name of the SiteSearchEngine, such as `projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine`.
GoogleCloudDiscoveryengineV1RecrawlUrisRequest:
{:uris [string]}"
  [siteSearchEngine GoogleCloudDiscoveryengineV1RecrawlUrisRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+siteSearchEngine}:recrawlUris",
     :uri-template-args {:siteSearchEngine siteSearchEngine},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1RecrawlUrisRequest}))

(defn projects-locations-dataStores-siteSearchEngine-targetSites-create
  "Creates a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Parent resource name of TargetSite, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`.
GoogleCloudDiscoveryengineV1TargetSite:
{:providedUriPattern string,
 :exactMatch boolean,
 :name string,
 :indexingStatus
 [INDEXING_STATUS_UNSPECIFIED PENDING FAILED SUCCEEDED DELETING],
 :rootDomainUri string,
 :type [TYPE_UNSPECIFIED INCLUDE EXCLUDE],
 :updateTime string,
 :siteVerificationInfo
 {:siteVerificationState
  [SITE_VERIFICATION_STATE_UNSPECIFIED VERIFIED UNVERIFIED EXEMPTED],
  :verifyTime string},
 :failureReason {:quotaFailure {:totalRequiredQuota string}},
 :generatedUriPattern string}"
  [parent GoogleCloudDiscoveryengineV1TargetSite]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/targetSites",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1TargetSite}))

(defn projects-locations-dataStores-siteSearchEngine-targetSites-batchCreate
  "Creates TargetSite in a batch.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource shared by all TargetSites being created. `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`. The parent field in the CreateBookRequest messages must either be empty or match this field.
GoogleCloudDiscoveryengineV1BatchCreateTargetSitesRequest:
{:requests
 [{:parent string,
   :targetSite
   {:providedUriPattern string,
    :exactMatch boolean,
    :name string,
    :indexingStatus
    [INDEXING_STATUS_UNSPECIFIED PENDING FAILED SUCCEEDED DELETING],
    :rootDomainUri string,
    :type [TYPE_UNSPECIFIED INCLUDE EXCLUDE],
    :updateTime string,
    :siteVerificationInfo
    {:siteVerificationState
     [SITE_VERIFICATION_STATE_UNSPECIFIED
      VERIFIED
      UNVERIFIED
      EXEMPTED],
     :verifyTime string},
    :failureReason {:quotaFailure {:totalRequiredQuota string}},
    :generatedUriPattern string}}]}"
  [parent GoogleCloudDiscoveryengineV1BatchCreateTargetSitesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/targetSites:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1BatchCreateTargetSitesRequest}))

(defn projects-locations-dataStores-siteSearchEngine-targetSites-get
  "Gets a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of TargetSite, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`. If the caller does not have permission to access the TargetSite, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the requested TargetSite does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-siteSearchEngine-targetSites-patch
  "Updates a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

name <string> Output only. The fully qualified resource name of the target site. `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}` The `target_site_id` is system-generated.
GoogleCloudDiscoveryengineV1TargetSite:
{:providedUriPattern string,
 :exactMatch boolean,
 :name string,
 :indexingStatus
 [INDEXING_STATUS_UNSPECIFIED PENDING FAILED SUCCEEDED DELETING],
 :rootDomainUri string,
 :type [TYPE_UNSPECIFIED INCLUDE EXCLUDE],
 :updateTime string,
 :siteVerificationInfo
 {:siteVerificationState
  [SITE_VERIFICATION_STATE_UNSPECIFIED VERIFIED UNVERIFIED EXEMPTED],
  :verifyTime string},
 :failureReason {:quotaFailure {:totalRequiredQuota string}},
 :generatedUriPattern string}"
  [name GoogleCloudDiscoveryengineV1TargetSite]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1TargetSite}))

(defn projects-locations-dataStores-siteSearchEngine-targetSites-delete
  "Deletes a TargetSite.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of TargetSite, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}`. If the caller does not have permission to access the TargetSite, regardless of whether or not it exists, a PERMISSION_DENIED error is returned. If the requested TargetSite does not exist, a NOT_FOUND error is returned."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-siteSearchEngine-targetSites-list
  "Gets a list of TargetSites.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent site search engine resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine`. If the caller does not have permission to list TargetSites under this site search engine, regardless of whether or not this branch exists, a PERMISSION_DENIED error is returned.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default. The maximum value is 1000; values above 1000 will be coerced to 1000. If this field is negative, an INVALID_ARGUMENT error is returned."
  ([parent]
    (projects-locations-dataStores-siteSearchEngine-targetSites-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/targetSites",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-conversations-converse
  "Converses a conversation.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`. Use `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/-` to activate auto session mode, which automatically creates a new conversation inside a ConverseConversation session.
GoogleCloudDiscoveryengineV1ConverseConversationRequest:
{:query
 {:input string,
  :context {:contextDocuments [string], :activeDocument string}},
 :servingConfig string,
 :conversation
 {:name string,
  :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
  :userPseudoId string,
  :messages
  [{:userInput
    {:input string,
     :context {:contextDocuments [string], :activeDocument string}},
    :reply
    {:summary
     {:summaryText string,
      :summarySkippedReasons
      [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
        ADVERSARIAL_QUERY_IGNORED
        NON_SUMMARY_SEEKING_QUERY_IGNORED
        OUT_OF_DOMAIN_QUERY_IGNORED
        POTENTIAL_POLICY_VIOLATION
        LLM_ADDON_NOT_ENABLED]],
      :safetyAttributes
      GoogleCloudDiscoveryengineV1SearchResponseSummarySafetyAttributes,
      :summaryWithMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummarySummaryWithMetadata}},
    :createTime string}],
  :startTime string,
  :endTime string},
 :safeSearch boolean,
 :userLabels object,
 :summarySpec
 {:summaryResultCount integer,
  :includeCitations boolean,
  :ignoreAdversarialQuery boolean,
  :ignoreNonSummarySeekingQuery boolean,
  :modelPromptSpec {:preamble string},
  :languageCode string,
  :modelSpec {:version string},
  :useSemanticChunks boolean},
 :filter string,
 :boostSpec {:conditionBoostSpecs [{:condition string, :boost number}]}}"
  [name GoogleCloudDiscoveryengineV1ConverseConversationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+name}:converse",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ConverseConversationRequest}))

(defn projects-locations-dataStores-conversations-create
  "Creates a Conversation. If the Conversation to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
GoogleCloudDiscoveryengineV1Conversation:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
 :userPseudoId string,
 :messages
 [{:userInput
   {:input string,
    :context {:contextDocuments [string], :activeDocument string}},
   :reply
   {:summary
    {:summaryText string,
     :summarySkippedReasons
     [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
       ADVERSARIAL_QUERY_IGNORED
       NON_SUMMARY_SEEKING_QUERY_IGNORED
       OUT_OF_DOMAIN_QUERY_IGNORED
       POTENTIAL_POLICY_VIOLATION
       LLM_ADDON_NOT_ENABLED]],
     :safetyAttributes {:categories [string], :scores [number]},
     :summaryWithMetadata
     {:summary string,
      :citationMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummaryCitationMetadata,
      :references
      [GoogleCloudDiscoveryengineV1SearchResponseSummaryReference]}}},
   :createTime string}],
 :startTime string,
 :endTime string}"
  [parent GoogleCloudDiscoveryengineV1Conversation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/conversations",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1Conversation}))

(defn projects-locations-dataStores-conversations-delete
  "Deletes a Conversation. If the Conversation to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-conversations-patch
  "Updates a Conversation. Conversation action type cannot be changed. If the Conversation to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/{project}/locations/global/collections/{collection}/dataStore/*/conversations/*` or `projects/{project}/locations/global/collections/{collection}/engines/*/conversations/*`.
GoogleCloudDiscoveryengineV1Conversation:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS COMPLETED],
 :userPseudoId string,
 :messages
 [{:userInput
   {:input string,
    :context {:contextDocuments [string], :activeDocument string}},
   :reply
   {:summary
    {:summaryText string,
     :summarySkippedReasons
     [[SUMMARY_SKIPPED_REASON_UNSPECIFIED
       ADVERSARIAL_QUERY_IGNORED
       NON_SUMMARY_SEEKING_QUERY_IGNORED
       OUT_OF_DOMAIN_QUERY_IGNORED
       POTENTIAL_POLICY_VIOLATION
       LLM_ADDON_NOT_ENABLED]],
     :safetyAttributes {:categories [string], :scores [number]},
     :summaryWithMetadata
     {:summary string,
      :citationMetadata
      GoogleCloudDiscoveryengineV1SearchResponseSummaryCitationMetadata,
      :references
      [GoogleCloudDiscoveryengineV1SearchResponseSummaryReference]}}},
   :createTime string}],
 :startTime string,
 :endTime string}

optional:
updateMask <string> Indicates which fields in the provided Conversation to update. The following are NOT supported: * Conversation.name If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Conversation]
    (projects-locations-dataStores-conversations-patch
      name
      GoogleCloudDiscoveryengineV1Conversation
      nil))
  ([name GoogleCloudDiscoveryengineV1Conversation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Conversation})))

(defn projects-locations-dataStores-conversations-get
  "Gets a Conversation.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Conversation to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/conversations/{conversation_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-conversations-list
  "Lists all Conversations by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`

optional:
pageSize <integer> Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> A filter to apply on the list results. The supported features are: user_pseudo_id, state. Example: \"user_pseudo_id = some_id\"
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `update_time` * `create_time` * `conversation_name` Example: \"update_time desc\" \"create_time\""
  ([parent]
    (projects-locations-dataStores-conversations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/conversations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-userEvents-write
  "Writes a single user event.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name. If the write user event action is applied in DataStore level, the format is: `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`. If the write user event action is applied in Location level, for example, the event with Document across multiple DataStore, the format is: `projects/{project}/locations/{location}`.
GoogleCloudDiscoveryengineV1UserEvent:
{:eventType string,
 :tagIds [string],
 :transactionInfo
 {:value number,
  :currency string,
  :transactionId string,
  :tax number,
  :cost number,
  :discountValue number},
 :sessionId string,
 :searchInfo {:searchQuery string, :orderBy string, :offset integer},
 :userPseudoId string,
 :dataStore string,
 :panel
 {:panelId string,
  :displayName string,
  :panelPosition integer,
  :totalPanels integer},
 :documents
 [{:id string,
   :name string,
   :uri string,
   :quantity integer,
   :promotionIds [string]}],
 :directUserRequest boolean,
 :filter string,
 :completionInfo
 {:selectedSuggestion string, :selectedPosition integer},
 :mediaInfo
 {:mediaProgressDuration string, :mediaProgressPercentage number},
 :pageInfo
 {:pageviewId string,
  :pageCategory string,
  :uri string,
  :referrerUri string},
 :eventTime string,
 :engine string,
 :promotionIds [string],
 :attributes object,
 :attributionToken string,
 :userInfo {:userId string, :userAgent string}}

optional:
writeAsync <boolean> If set to true, the user event is written asynchronously after validation, and the API responds without waiting for the write."
  ([parent GoogleCloudDiscoveryengineV1UserEvent]
    (projects-locations-dataStores-userEvents-write
      parent
      GoogleCloudDiscoveryengineV1UserEvent
      nil))
  ([parent GoogleCloudDiscoveryengineV1UserEvent optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:write",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1UserEvent})))

(defn projects-locations-dataStores-userEvents-collect
  "Writes a single user event from the browser. This uses a GET request to due to browser restriction of POST-ing to a third-party domain. This method is used only by the Discovery Engine API JavaScript pixel and Google Tag Manager. Users should not call this method directly.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent DataStore resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.

optional:
userEvent <string> Required. URL encoded UserEvent proto with a length limit of 2,000,000 characters.
uri <string> The URL including cgi-parameters but excluding the hash fragment with a length limit of 5,000 characters. This is often more useful than the referer URL, because many browsers only send the domain for third-party requests.
ets <string> The event timestamp in milliseconds. This prevents browser caching of otherwise identical get requests. The name is abbreviated to reduce the payload bytes."
  ([parent]
    (projects-locations-dataStores-userEvents-collect parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:collect",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-userEvents-import
  "Bulk import of user events. Request processing might be synchronous. Events that already exist are skipped. Use this method for backfilling historical user events. Operation.response is of type ImportResponse. Note that it is possible for a subset of the items to be successfully inserted. Operation.metadata is of type ImportMetadata.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Parent DataStore resource name, of the form `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`
GoogleCloudDiscoveryengineV1ImportUserEventsRequest:
{:inlineSource
 {:userEvents
  [{:eventType string,
    :tagIds [string],
    :transactionInfo
    {:value number,
     :currency string,
     :transactionId string,
     :tax number,
     :cost number,
     :discountValue number},
    :sessionId string,
    :searchInfo
    {:searchQuery string, :orderBy string, :offset integer},
    :userPseudoId string,
    :dataStore string,
    :panel
    {:panelId string,
     :displayName string,
     :panelPosition integer,
     :totalPanels integer},
    :documents
    [{:id string,
      :name string,
      :uri string,
      :quantity integer,
      :promotionIds [string]}],
    :directUserRequest boolean,
    :filter string,
    :completionInfo
    {:selectedSuggestion string, :selectedPosition integer},
    :mediaInfo
    {:mediaProgressDuration string, :mediaProgressPercentage number},
    :pageInfo
    {:pageviewId string,
     :pageCategory string,
     :uri string,
     :referrerUri string},
    :eventTime string,
    :engine string,
    :promotionIds [string],
    :attributes object,
    :attributionToken string,
    :userInfo {:userId string, :userAgent string}}]},
 :gcsSource {:inputUris [string], :dataSchema string},
 :bigquerySource
 {:partitionDate {:year integer, :month integer, :day integer},
  :projectId string,
  :datasetId string,
  :tableId string,
  :gcsStagingDir string,
  :dataSchema string},
 :errorConfig {:gcsPrefix string}}"
  [parent GoogleCloudDiscoveryengineV1ImportUserEventsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ImportUserEventsRequest}))

(defn projects-locations-dataStores-completionSuggestions-import
  "Imports CompletionSuggestions for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to import customer autocomplete suggestions. Follows pattern `projects/*/locations/*/collections/*/dataStores/*`
GoogleCloudDiscoveryengineV1ImportCompletionSuggestionsRequest:
{:inlineSource
 {:suggestions
  [{:globalScore number,
    :frequency string,
    :suggestion string,
    :languageCode string,
    :groupId string,
    :groupScore number,
    :alternativePhrases [string]}]},
 :gcsSource {:inputUris [string], :dataSchema string},
 :bigquerySource
 {:partitionDate {:year integer, :month integer, :day integer},
  :projectId string,
  :datasetId string,
  :tableId string,
  :gcsStagingDir string,
  :dataSchema string},
 :errorConfig {:gcsPrefix string}}"
  [parent
   GoogleCloudDiscoveryengineV1ImportCompletionSuggestionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/completionSuggestions:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1ImportCompletionSuggestionsRequest}))

(defn projects-locations-dataStores-completionSuggestions-purge
  "Permanently deletes all CompletionSuggestions for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to purge completion suggestions. Follows pattern projects/*/locations/*/collections/*/dataStores/*.
GoogleCloudDiscoveryengineV1PurgeCompletionSuggestionsRequest:
object"
  [parent
   GoogleCloudDiscoveryengineV1PurgeCompletionSuggestionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/completionSuggestions:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1PurgeCompletionSuggestionsRequest}))

(defn projects-locations-dataStores-branches-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-dataStores-branches-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-branches-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-branches-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-locations-dataStores-branches-documents-get
  "Gets a Document.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of Document, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`. If the caller does not have permission to access the Document, regardless of whether or not it exists, a `PERMISSION_DENIED` error is returned. If the requested Document does not exist, a `NOT_FOUND` error is returned."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-branches-documents-list
  "Gets a list of Documents.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent branch resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`. Use `default_branch` as the branch ID, to list documents under the default branch. If the caller does not have permission to list Documents under this branch, regardless of whether or not this branch exists, a `PERMISSION_DENIED` error is returned.

optional:
pageSize <integer> Maximum number of Documents to return. If unspecified, defaults to 100. The maximum allowed value is 1000. Values above 1000 are set to 1000. If this field is negative, an `INVALID_ARGUMENT` error is returned."
  ([parent]
    (projects-locations-dataStores-branches-documents-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/documents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-branches-documents-create
  "Creates a Document.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
GoogleCloudDiscoveryengineV1Document:
{:content {:rawBytes string, :uri string, :mimeType string},
 :parentDocumentId string,
 :name string,
 :indexTime string,
 :schemaId string,
 :structData object,
 :id string,
 :jsonData string,
 :derivedStructData object}

optional:
documentId <string> Required. The ID to use for the Document, which becomes the final component of the Document.name. If the caller does not have permission to create the Document, regardless of whether or not it exists, a `PERMISSION_DENIED` error is returned. This field must be unique among all Documents with the same parent. Otherwise, an `ALREADY_EXISTS` error is returned. This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length limit of 63 characters. Otherwise, an `INVALID_ARGUMENT` error is returned."
  ([parent GoogleCloudDiscoveryengineV1Document]
    (projects-locations-dataStores-branches-documents-create
      parent
      GoogleCloudDiscoveryengineV1Document
      nil))
  ([parent GoogleCloudDiscoveryengineV1Document optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/documents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Document})))

(defn projects-locations-dataStores-branches-documents-patch
  "Updates a Document.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. The full resource name of the document. Format: `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document_id}`. This field must be a UTF-8 encoded string with a length limit of 1024 characters.
GoogleCloudDiscoveryengineV1Document:
{:content {:rawBytes string, :uri string, :mimeType string},
 :parentDocumentId string,
 :name string,
 :indexTime string,
 :schemaId string,
 :structData object,
 :id string,
 :jsonData string,
 :derivedStructData object}

optional:
allowMissing <boolean> If set to `true` and the Document is not found, a new Document is be created.
updateMask <string> Indicates which fields in the provided imported 'document' to update. If not set, by default updates all fields."
  ([name GoogleCloudDiscoveryengineV1Document]
    (projects-locations-dataStores-branches-documents-patch
      name
      GoogleCloudDiscoveryengineV1Document
      nil))
  ([name GoogleCloudDiscoveryengineV1Document optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Document})))

(defn projects-locations-dataStores-branches-documents-delete
  "Deletes a Document.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. Full resource name of Document, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`. If the caller does not have permission to delete the Document, regardless of whether or not it exists, a `PERMISSION_DENIED` error is returned. If the Document to delete does not exist, a `NOT_FOUND` error is returned."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-branches-documents-import
  "Bulk import of multiple Documents. Request processing may be synchronous. Non-existing items are created. Note: It is possible for a subset of the Documents to be successfully updated.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent branch resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`. Requires create/update permission.
GoogleCloudDiscoveryengineV1ImportDocumentsRequest:
{:updateMask string,
 :autoGenerateIds boolean,
 :idField string,
 :bigquerySource
 {:partitionDate {:year integer, :month integer, :day integer},
  :projectId string,
  :datasetId string,
  :tableId string,
  :gcsStagingDir string,
  :dataSchema string},
 :spannerSource
 {:projectId string,
  :instanceId string,
  :databaseId string,
  :tableId string,
  :enableDataBoost boolean},
 :bigtableSource
 {:projectId string,
  :instanceId string,
  :tableId string,
  :bigtableOptions {:keyFieldName string, :families object}},
 :firestoreSource
 {:projectId string,
  :databaseId string,
  :collectionId string,
  :gcsStagingDir string},
 :reconciliationMode
 [RECONCILIATION_MODE_UNSPECIFIED INCREMENTAL FULL],
 :cloudSqlSource
 {:projectId string,
  :instanceId string,
  :databaseId string,
  :tableId string,
  :gcsStagingDir string,
  :offload boolean},
 :errorConfig {:gcsPrefix string},
 :alloyDbSource
 {:projectId string,
  :locationId string,
  :clusterId string,
  :databaseId string,
  :tableId string,
  :gcsStagingDir string},
 :inlineSource
 {:documents
  [{:content {:rawBytes string, :uri string, :mimeType string},
    :parentDocumentId string,
    :name string,
    :indexTime string,
    :schemaId string,
    :structData object,
    :id string,
    :jsonData string,
    :derivedStructData object}]},
 :fhirStoreSource {:fhirStore string, :gcsStagingDir string},
 :gcsSource {:inputUris [string], :dataSchema string}}"
  [parent GoogleCloudDiscoveryengineV1ImportDocumentsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/documents:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1ImportDocumentsRequest}))

(defn projects-locations-dataStores-branches-documents-purge
  "Permanently deletes all selected Documents in a branch. This process is asynchronous. Depending on the number of Documents to be deleted, this operation can take hours to complete. Before the delete operation completes, some Documents might still be returned by DocumentService.GetDocument or DocumentService.ListDocuments. To get a list of the Documents to be deleted, set PurgeDocumentsRequest.force to false.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}`.
GoogleCloudDiscoveryengineV1PurgeDocumentsRequest:
{:filter string, :force boolean}"
  [parent GoogleCloudDiscoveryengineV1PurgeDocumentsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/documents:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1PurgeDocumentsRequest}))

(defn projects-locations-dataStores-controls-create
  "Creates a Control. By default 1000 controls are allowed for a data store. A request can be submitted to adjust this limit. If the Control to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}` or `projects/{project_number}/locations/{location_id}/collections/{collection_id}/engines/{engine_id}`.
GoogleCloudDiscoveryengineV1Control:
{:useCases
 [[SEARCH_USE_CASE_UNSPECIFIED
   SEARCH_USE_CASE_SEARCH
   SEARCH_USE_CASE_BROWSE]],
 :solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :redirectAction {:redirectUri string},
 :synonymsAction {:synonyms [string]},
 :conditions
 [{:queryTerms [{:value string, :fullMatch boolean}],
   :activeTimeRange [{:startTime string, :endTime string}]}],
 :associatedServingConfigIds [string],
 :boostAction {:boost number, :filter string, :dataStore string},
 :filterAction {:filter string, :dataStore string}}

optional:
controlId <string> Required. The ID to use for the Control, which will become the final component of the Control's resource name. This value must be within 1-63 characters. Valid characters are /a-z-_/."
  ([parent GoogleCloudDiscoveryengineV1Control]
    (projects-locations-dataStores-controls-create
      parent
      GoogleCloudDiscoveryengineV1Control
      nil))
  ([parent GoogleCloudDiscoveryengineV1Control optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/controls",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Control})))

(defn projects-locations-dataStores-controls-delete
  "Deletes a Control. If the Control to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Control to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-controls-patch
  "Updates a Control. Control action type cannot be changed. If the Control to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/*/locations/global/dataStore/*/controls/*`
GoogleCloudDiscoveryengineV1Control:
{:useCases
 [[SEARCH_USE_CASE_UNSPECIFIED
   SEARCH_USE_CASE_SEARCH
   SEARCH_USE_CASE_BROWSE]],
 :solutionType
 [SOLUTION_TYPE_UNSPECIFIED
  SOLUTION_TYPE_RECOMMENDATION
  SOLUTION_TYPE_SEARCH
  SOLUTION_TYPE_CHAT
  SOLUTION_TYPE_GENERATIVE_CHAT],
 :displayName string,
 :name string,
 :redirectAction {:redirectUri string},
 :synonymsAction {:synonyms [string]},
 :conditions
 [{:queryTerms [{:value string, :fullMatch boolean}],
   :activeTimeRange [{:startTime string, :endTime string}]}],
 :associatedServingConfigIds [string],
 :boostAction {:boost number, :filter string, :dataStore string},
 :filterAction {:filter string, :dataStore string}}

optional:
updateMask <string> Optional. Indicates which fields in the provided Control to update. The following are NOT supported: * Control.name * Control.solution_type If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Control]
    (projects-locations-dataStores-controls-patch
      name
      GoogleCloudDiscoveryengineV1Control
      nil))
  ([name GoogleCloudDiscoveryengineV1Control optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Control})))

(defn projects-locations-dataStores-controls-get
  "Gets a Control.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Control to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}/controls/{control_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-controls-list
  "Lists all Controls by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection_id}/dataStores/{data_store_id}` or `projects/{project_number}/locations/{location_id}/collections/{collection_id}/engines/{engine_id}`.

optional:
pageSize <integer> Optional. Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> Optional. A filter to apply on the list results. Supported features: * List all the products under the parent branch if filter is unset. Currently this field is unsupported."
  ([parent] (projects-locations-dataStores-controls-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/controls",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-suggestionDenyListEntries-import
  "Imports all SuggestionDenyListEntry for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to import denylist entries. Follows pattern projects/*/locations/*/collections/*/dataStores/*.
GoogleCloudDiscoveryengineV1ImportSuggestionDenyListEntriesRequest:
{:inlineSource
 {:entries
  [{:blockPhrase string,
    :matchOperator
    [MATCH_OPERATOR_UNSPECIFIED EXACT_MATCH CONTAINS]}]},
 :gcsSource {:inputUris [string], :dataSchema string}}"
  [parent
   GoogleCloudDiscoveryengineV1ImportSuggestionDenyListEntriesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/suggestionDenyListEntries:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1ImportSuggestionDenyListEntriesRequest}))

(defn projects-locations-dataStores-suggestionDenyListEntries-purge
  "Permanently deletes all SuggestionDenyListEntry for a DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name for which to import denylist entries. Follows pattern projects/*/locations/*/collections/*/dataStores/*.
GoogleCloudDiscoveryengineV1PurgeSuggestionDenyListEntriesRequest:
object"
  [parent
   GoogleCloudDiscoveryengineV1PurgeSuggestionDenyListEntriesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/suggestionDenyListEntries:purge",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudDiscoveryengineV1PurgeSuggestionDenyListEntriesRequest}))

(defn projects-locations-dataStores-models-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name]
    (projects-locations-dataStores-models-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-models-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-schemas-get
  "Gets a Schema.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The full resource name of the schema, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-schemas-list
  "Gets a list of Schemas.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.

optional:
pageSize <integer> The maximum number of Schemas to return. The service may return fewer than this value. If unspecified, at most 100 Schemas are returned. The maximum value is 1000; values above 1000 are set to 1000."
  ([parent] (projects-locations-dataStores-schemas-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/schemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-schemas-create
  "Creates a Schema.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent data store resource name, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.
GoogleCloudDiscoveryengineV1Schema:
{:structSchema object, :jsonSchema string, :name string}

optional:
schemaId <string> Required. The ID to use for the Schema, which becomes the final component of the Schema.name. This field should conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with a length limit of 63 characters."
  ([parent GoogleCloudDiscoveryengineV1Schema]
    (projects-locations-dataStores-schemas-create
      parent
      GoogleCloudDiscoveryengineV1Schema
      nil))
  ([parent GoogleCloudDiscoveryengineV1Schema optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/schemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Schema})))

(defn projects-locations-dataStores-schemas-patch
  "Updates a Schema.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. The full resource name of the schema, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`. This field must be a UTF-8 encoded string with a length limit of 1024 characters.
GoogleCloudDiscoveryengineV1Schema:
{:structSchema object, :jsonSchema string, :name string}

optional:
allowMissing <boolean> If set to true, and the Schema is not found, a new Schema is created. In this situation, `update_mask` is ignored."
  ([name GoogleCloudDiscoveryengineV1Schema]
    (projects-locations-dataStores-schemas-patch
      name
      GoogleCloudDiscoveryengineV1Schema
      nil))
  ([name GoogleCloudDiscoveryengineV1Schema optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Schema})))

(defn projects-locations-dataStores-schemas-delete
  "Deletes a Schema.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The full resource name of the schema, in the format of `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-servingConfigs-search
  "Performs a search.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. The resource name of the Search serving config, such as `projects/*/locations/global/collections/default_collection/engines/*/servingConfigs/default_serving_config`, or `projects/*/locations/global/collections/default_collection/dataStores/default_data_store/servingConfigs/default_serving_config`. This field is used to identify the serving configuration name, set of models used to make the search.
GoogleCloudDiscoveryengineV1SearchRequest:
{:canonicalFilter string,
 :contentSearchSpec
 {:snippetSpec
  {:maxSnippetCount integer,
   :referenceOnly boolean,
   :returnSnippet boolean},
  :summarySpec
  {:summaryResultCount integer,
   :includeCitations boolean,
   :ignoreAdversarialQuery boolean,
   :ignoreNonSummarySeekingQuery boolean,
   :modelPromptSpec {:preamble string},
   :languageCode string,
   :modelSpec {:version string},
   :useSemanticChunks boolean},
  :extractiveContentSpec
  {:maxExtractiveAnswerCount integer,
   :maxExtractiveSegmentCount integer,
   :returnExtractiveSegmentScore boolean,
   :numPreviousSegments integer,
   :numNextSegments integer},
  :searchResultMode [SEARCH_RESULT_MODE_UNSPECIFIED DOCUMENTS CHUNKS],
  :chunkSpec {:numPreviousChunks integer, :numNextChunks integer}},
 :offset integer,
 :imageQuery {:imageBytes string},
 :params object,
 :userPseudoId string,
 :safeSearch boolean,
 :pageToken string,
 :facetSpecs
 [{:facetKey
   {:key string,
    :intervals
    [{:minimum number,
      :exclusiveMinimum number,
      :maximum number,
      :exclusiveMaximum number}],
    :restrictedValues [string],
    :prefixes [string],
    :contains [string],
    :caseInsensitive boolean,
    :orderBy string},
   :limit integer,
   :excludedFilterKeys [string],
   :enableDynamicPosition boolean}],
 :filter string,
 :languageCode string,
 :pageSize integer,
 :query string,
 :branch string,
 :userLabels object,
 :dataStoreSpecs [{:dataStore string}],
 :queryExpansionSpec
 {:condition [CONDITION_UNSPECIFIED DISABLED AUTO],
  :pinUnexpandedResults boolean},
 :boostSpec
 {:conditionBoostSpecs [{:condition string, :boost number}]},
 :spellCorrectionSpec {:mode [MODE_UNSPECIFIED SUGGESTION_ONLY AUTO]},
 :userInfo {:userId string, :userAgent string},
 :orderBy string}"
  [servingConfig GoogleCloudDiscoveryengineV1SearchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:search",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1SearchRequest}))

(defn projects-locations-dataStores-servingConfigs-answer
  "Answer query method.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. The resource name of the Search serving config, such as `projects/*/locations/global/collections/default_collection/engines/*/servingConfigs/default_serving_config`, or `projects/*/locations/global/collections/default_collection/dataStores/*/servingConfigs/default_serving_config`. This field is used to identify the serving configuration name, set of models used to make the search.
GoogleCloudDiscoveryengineV1AnswerQueryRequest:
{:relatedQuestionsSpec {:enable boolean},
 :safetySpec {:enable boolean},
 :queryUnderstandingSpec
 {:queryClassificationSpec
  {:types
   [[TYPE_UNSPECIFIED ADVERSARIAL_QUERY NON_ANSWER_SEEKING_QUERY]]},
  :queryRephraserSpec {:disable boolean}},
 :userPseudoId string,
 :asynchronousMode boolean,
 :searchSpec
 {:searchParams
  {:maxReturnResults integer,
   :filter string,
   :boostSpec
   {:conditionBoostSpecs [{:condition string, :boost number}]},
   :orderBy string,
   :searchResultMode [SEARCH_RESULT_MODE_UNSPECIFIED DOCUMENTS CHUNKS],
   :dataStoreSpecs [{:dataStore string}]},
  :searchResultList
  {:searchResults
   [{:unstructuredDocumentInfo
     {:document string,
      :uri string,
      :title string,
      :documentContexts
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoDocumentContext],
      :extractiveSegments
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoExtractiveSegment],
      :extractiveAnswers
      [GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultListSearchResultUnstructuredDocumentInfoExtractiveAnswer]},
     :chunkInfo {:chunk string, :content string}}]}},
 :query {:text string, :queryId string},
 :userLabels object,
 :answerGenerationSpec
 {:modelSpec {:modelVersion string},
  :promptSpec {:preamble string},
  :includeCitations boolean,
  :answerLanguageCode string,
  :ignoreAdversarialQuery boolean,
  :ignoreNonAnswerSeekingQuery boolean,
  :ignoreLowRelevantContent boolean},
 :session string}"
  [servingConfig GoogleCloudDiscoveryengineV1AnswerQueryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:answer",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1AnswerQueryRequest}))

(defn projects-locations-dataStores-servingConfigs-recommend
  "Makes a recommendation, which requires a contextual user event.
https://cloud.google.com/discovery-engine/media/docs

servingConfig <string> Required. Full resource name of a ServingConfig: `projects/*/locations/global/collections/*/engines/*/servingConfigs/*`, or `projects/*/locations/global/collections/*/dataStores/*/servingConfigs/*` One default serving config is created along with your recommendation engine creation. The engine ID is used as the ID of the default serving config. For example, for Engine `projects/*/locations/global/collections/*/engines/my-engine`, you can use `projects/*/locations/global/collections/*/engines/my-engine/servingConfigs/my-engine` for your RecommendationService.Recommend requests.
GoogleCloudDiscoveryengineV1RecommendRequest:
{:userEvent
 {:eventType string,
  :tagIds [string],
  :transactionInfo
  {:value number,
   :currency string,
   :transactionId string,
   :tax number,
   :cost number,
   :discountValue number},
  :sessionId string,
  :searchInfo {:searchQuery string, :orderBy string, :offset integer},
  :userPseudoId string,
  :dataStore string,
  :panel
  {:panelId string,
   :displayName string,
   :panelPosition integer,
   :totalPanels integer},
  :documents
  [{:id string,
    :name string,
    :uri string,
    :quantity integer,
    :promotionIds [string]}],
  :directUserRequest boolean,
  :filter string,
  :completionInfo
  {:selectedSuggestion string, :selectedPosition integer},
  :mediaInfo
  {:mediaProgressDuration string, :mediaProgressPercentage number},
  :pageInfo
  {:pageviewId string,
   :pageCategory string,
   :uri string,
   :referrerUri string},
  :eventTime string,
  :engine string,
  :promotionIds [string],
  :attributes object,
  :attributionToken string,
  :userInfo {:userId string, :userAgent string}},
 :pageSize integer,
 :filter string,
 :validateOnly boolean,
 :params object,
 :userLabels object}"
  [servingConfig GoogleCloudDiscoveryengineV1RecommendRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+servingConfig}:recommend",
     :uri-template-args {:servingConfig servingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1RecommendRequest}))

(defn projects-locations-dataStores-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-dataStores-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/discovery-engine/media/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-sessions-create
  "Creates a Session. If the Session to create already exists, an ALREADY_EXISTS error is returned.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. Full resource name of parent data store. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`
GoogleCloudDiscoveryengineV1Session:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS],
 :userPseudoId string,
 :turns [{:query {:text string, :queryId string}, :answer string}],
 :startTime string,
 :endTime string}"
  [parent GoogleCloudDiscoveryengineV1Session]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+parent}/sessions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1Session}))

(defn projects-locations-dataStores-sessions-delete
  "Deletes a Session. If the Session to delete does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Session to delete. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-sessions-patch
  "Updates a Session. Session action type cannot be changed. If the Session to update does not exist, a NOT_FOUND error is returned.
https://cloud.google.com/discovery-engine/media/docs

name <string> Immutable. Fully qualified name `projects/{project}/locations/global/collections/{collection}/engines/{engine}/sessions/*`
GoogleCloudDiscoveryengineV1Session:
{:name string,
 :state [STATE_UNSPECIFIED IN_PROGRESS],
 :userPseudoId string,
 :turns [{:query {:text string, :queryId string}, :answer string}],
 :startTime string,
 :endTime string}

optional:
updateMask <string> Indicates which fields in the provided Session to update. The following are NOT supported: * Session.name If not set or empty, all supported fields are updated."
  ([name GoogleCloudDiscoveryengineV1Session]
    (projects-locations-dataStores-sessions-patch
      name
      GoogleCloudDiscoveryengineV1Session
      nil))
  ([name GoogleCloudDiscoveryengineV1Session optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1Session})))

(defn projects-locations-dataStores-sessions-get
  "Gets a Session.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Session to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}/sessions/{session_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataStores-sessions-list
  "Lists all Sessions by their parent DataStore.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The data store resource name. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/dataStores/{data_store_id}`

optional:
pageSize <integer> Maximum number of results to return. If unspecified, defaults to 50. Max allowed value is 1000.
filter <string> A filter to apply on the list results. The supported features are: user_pseudo_id, state. Example: \"user_pseudo_id = some_id\"
orderBy <string> A comma-separated list of fields to order by, sorted in ascending order. Use \"desc\" after a field name for descending. Supported fields: * `update_time` * `create_time` * `session_name` Example: \"update_time desc\" \"create_time\""
  ([parent] (projects-locations-dataStores-sessions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/sessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataStores-sessions-answers-get
  "Gets a Answer.
https://cloud.google.com/discovery-engine/media/docs

name <string> Required. The resource name of the Answer to get. Format: `projects/{project_number}/locations/{location_id}/collections/{collection}/engines/{engine_id}/sessions/{session_id}/answers/{answer_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://discoveryengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-groundingConfigs-check
  "Performs a grounding check.
https://cloud.google.com/discovery-engine/media/docs

groundingConfig <string> Required. The resource name of the grounding config, such as `projects/*/locations/global/groundingConfigs/default_grounding_config`.
GoogleCloudDiscoveryengineV1CheckGroundingRequest:
{:answerCandidate string,
 :facts [{:factText string, :attributes object}],
 :groundingSpec {:citationThreshold number},
 :userLabels object}"
  [groundingConfig GoogleCloudDiscoveryengineV1CheckGroundingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+groundingConfig}:check",
     :uri-template-args {:groundingConfig groundingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1CheckGroundingRequest}))

(defn projects-locations-rankingConfigs-rank
  "Ranks a list of text records based on the given input query.
https://cloud.google.com/discovery-engine/media/docs

rankingConfig <string> Required. The resource name of the rank service config, such as `projects/{project_num}/locations/{location_id}/rankingConfigs/default_ranking_config`.
GoogleCloudDiscoveryengineV1RankRequest:
{:model string,
 :topN integer,
 :query string,
 :records
 [{:id string, :title string, :content string, :score number}],
 :ignoreRecordDetailsInResponse boolean,
 :userLabels object}"
  [rankingConfig GoogleCloudDiscoveryengineV1RankRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://discoveryengine.googleapis.com/v1/{+rankingConfig}:rank",
     :uri-template-args {:rankingConfig rankingConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDiscoveryengineV1RankRequest}))

(defn projects-locations-userEvents-write
  "Writes a single user event.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent resource name. If the write user event action is applied in DataStore level, the format is: `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`. If the write user event action is applied in Location level, for example, the event with Document across multiple DataStore, the format is: `projects/{project}/locations/{location}`.
GoogleCloudDiscoveryengineV1UserEvent:
{:eventType string,
 :tagIds [string],
 :transactionInfo
 {:value number,
  :currency string,
  :transactionId string,
  :tax number,
  :cost number,
  :discountValue number},
 :sessionId string,
 :searchInfo {:searchQuery string, :orderBy string, :offset integer},
 :userPseudoId string,
 :dataStore string,
 :panel
 {:panelId string,
  :displayName string,
  :panelPosition integer,
  :totalPanels integer},
 :documents
 [{:id string,
   :name string,
   :uri string,
   :quantity integer,
   :promotionIds [string]}],
 :directUserRequest boolean,
 :filter string,
 :completionInfo
 {:selectedSuggestion string, :selectedPosition integer},
 :mediaInfo
 {:mediaProgressDuration string, :mediaProgressPercentage number},
 :pageInfo
 {:pageviewId string,
  :pageCategory string,
  :uri string,
  :referrerUri string},
 :eventTime string,
 :engine string,
 :promotionIds [string],
 :attributes object,
 :attributionToken string,
 :userInfo {:userId string, :userAgent string}}

optional:
writeAsync <boolean> If set to true, the user event is written asynchronously after validation, and the API responds without waiting for the write."
  ([parent GoogleCloudDiscoveryengineV1UserEvent]
    (projects-locations-userEvents-write
      parent
      GoogleCloudDiscoveryengineV1UserEvent
      nil))
  ([parent GoogleCloudDiscoveryengineV1UserEvent optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:write",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDiscoveryengineV1UserEvent})))

(defn projects-locations-userEvents-collect
  "Writes a single user event from the browser. This uses a GET request to due to browser restriction of POST-ing to a third-party domain. This method is used only by the Discovery Engine API JavaScript pixel and Google Tag Manager. Users should not call this method directly.
https://cloud.google.com/discovery-engine/media/docs

parent <string> Required. The parent DataStore resource name, such as `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}`.

optional:
userEvent <string> Required. URL encoded UserEvent proto with a length limit of 2,000,000 characters.
uri <string> The URL including cgi-parameters but excluding the hash fragment with a length limit of 5,000 characters. This is often more useful than the referer URL, because many browsers only send the domain for third-party requests.
ets <string> The event timestamp in milliseconds. This prevents browser caching of otherwise identical get requests. The name is abbreviated to reduce the payload bytes."
  ([parent] (projects-locations-userEvents-collect parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://discoveryengine.googleapis.com/v1/{+parent}/userEvents:collect",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

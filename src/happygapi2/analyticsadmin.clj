(ns happygapi2.analyticsadmin
  "Google Analytics Admin API
Manage properties in Google Analytics. Warning: Creating multiple Customer Applications, Accounts, or Projects to simulate or act as a single Customer Application, Account, or Project (respectively) or to circumvent Service-specific usage limits or quotas is a direct violation of Google Cloud Platform Terms of Service as well as Google APIs Terms of Service. These actions can result in immediate termination of your GCP project(s) without any warning.
See: https://developers.google.com/analytics/devguides/config/?csw=1"
  (:require [happy.oauth2.client :as client]))

(defn accounts-patch
  "Updates an account.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/patch

name <string> Output only. Resource name of this account. Format: accounts/{account} Example: \"accounts/100\"
GoogleAnalyticsAdminV1betaAccount:
{:gmpOrganization string,
 :deleted boolean,
 :displayName string,
 :updateTime string,
 :name string,
 :createTime string,
 :regionCode string}

optional:
updateMask <string> Required. The list of fields to be updated. Field names must be in snake case (for example, \"field_to_update\"). Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaAccount]
    (accounts-patch name GoogleAnalyticsAdminV1betaAccount nil))
  ([name GoogleAnalyticsAdminV1betaAccount optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaAccount})))

(defn accounts-searchChangeHistoryEvents
  "Searches through all changes to an account or its children given the specified set of filters.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/searchChangeHistoryEvents

account <string> Required. The account resource for which to return change history resources. Format: accounts/{account} Example: \"accounts/100\"
GoogleAnalyticsAdminV1betaSearchChangeHistoryEventsRequest:
{:pageSize integer,
 :actorEmail [string],
 :resourceType
 [[CHANGE_HISTORY_RESOURCE_TYPE_UNSPECIFIED
   ACCOUNT
   PROPERTY
   FIREBASE_LINK
   GOOGLE_ADS_LINK
   GOOGLE_SIGNALS_SETTINGS
   CONVERSION_EVENT
   MEASUREMENT_PROTOCOL_SECRET
   DATA_RETENTION_SETTINGS
   DISPLAY_VIDEO_360_ADVERTISER_LINK
   DISPLAY_VIDEO_360_ADVERTISER_LINK_PROPOSAL
   DATA_STREAM
   ATTRIBUTION_SETTINGS]],
 :latestChangeTime string,
 :earliestChangeTime string,
 :action [[ACTION_TYPE_UNSPECIFIED CREATED UPDATED DELETED]],
 :pageToken string,
 :property string}"
  [account GoogleAnalyticsAdminV1betaSearchChangeHistoryEventsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+account}:searchChangeHistoryEvents",
     :uri-template-args {:account account},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaSearchChangeHistoryEventsRequest}))

(defn accounts-list
  "Returns all accounts accessible by the caller. Note that these accounts might not currently have GA4 properties. Soft-deleted (ie: \"trashed\") accounts are excluded by default. Returns an empty list if no relevant accounts are found.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/list

optional:
showDeleted <boolean> Whether to include soft-deleted (ie: \"trashed\") Accounts in the results. Accounts can be inspected to determine whether they are deleted or not.
pageSize <integer> The maximum number of resources to return. The service may return fewer than this value, even if there are additional pages. If unspecified, at most 50 resources will be returned. The maximum value is 200; (higher values will be coerced to the maximum)"
  ([] (accounts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/accounts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn accounts-runAccessReport
  "Returns a customized report of data access records. The report provides records of each time a user reads Google Analytics reporting data. Access records are retained for up to 2 years. Data Access Reports can be requested for a property. Reports may be requested for any property, but dimensions that aren't related to quota can only be requested on Google Analytics 360 properties. This method is only available to Administrators. These data access records include GA4 UI Reporting, GA4 UI Explorations, GA4 Data API, and other products like Firebase & Admob that can retrieve data from Google Analytics through a linkage. These records don't include property configuration changes like adding a stream or changing a property's time zone. For configuration change history, see [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/runAccessReport

entity <string> The Data Access Report supports requesting at the property level or account level. If requested at the account level, Data Access Reports include all access for all properties under that account. To request at the property level, entity should be for example 'properties/123' if \"123\" is your GA4 property ID. To request at the account level, entity should be for example 'accounts/1234' if \"1234\" is your GA4 Account ID.
GoogleAnalyticsAdminV1betaRunAccessReportRequest:
{:timeZone string,
 :limit string,
 :offset string,
 :dimensionFilter
 {:accessFilter
  {:fieldName string,
   :betweenFilter
   {:toValue {:int64Value string, :doubleValue number},
    :fromValue {:int64Value string, :doubleValue number}},
   :inListFilter {:caseSensitive boolean, :values [string]},
   :numericFilter
   {:value {:int64Value string, :doubleValue number},
    :operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL]},
   :stringFilter
   {:value string,
    :caseSensitive boolean,
    :matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP]}},
  :notExpression
  {:accessFilter
   {:fieldName string,
    :betweenFilter
    {:toValue GoogleAnalyticsAdminV1betaNumericValue,
     :fromValue GoogleAnalyticsAdminV1betaNumericValue},
    :inListFilter {:caseSensitive boolean, :values [string]},
    :numericFilter
    {:value GoogleAnalyticsAdminV1betaNumericValue,
     :operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL]},
    :stringFilter
    {:value string,
     :caseSensitive boolean,
     :matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP]}},
   :notExpression
   {:accessFilter
    {:fieldName string,
     :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
     :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
     :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
     :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
    :notExpression
    {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
     :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
     :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
     :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
    :orGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
    :andGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]}},
   :orGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]},
   :andGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]}},
  :orGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]},
  :andGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]}},
 :dimensions [{:dimensionName string}],
 :metricFilter
 {:accessFilter
  {:fieldName string,
   :betweenFilter
   {:toValue {:int64Value string, :doubleValue number},
    :fromValue {:int64Value string, :doubleValue number}},
   :inListFilter {:caseSensitive boolean, :values [string]},
   :numericFilter
   {:value {:int64Value string, :doubleValue number},
    :operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL]},
   :stringFilter
   {:value string,
    :caseSensitive boolean,
    :matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP]}},
  :notExpression
  {:accessFilter
   {:fieldName string,
    :betweenFilter
    {:toValue GoogleAnalyticsAdminV1betaNumericValue,
     :fromValue GoogleAnalyticsAdminV1betaNumericValue},
    :inListFilter {:caseSensitive boolean, :values [string]},
    :numericFilter
    {:value GoogleAnalyticsAdminV1betaNumericValue,
     :operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL]},
    :stringFilter
    {:value string,
     :caseSensitive boolean,
     :matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP]}},
   :notExpression
   {:accessFilter
    {:fieldName string,
     :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
     :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
     :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
     :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
    :notExpression
    {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
     :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
     :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
     :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
    :orGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
    :andGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]}},
   :orGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]},
   :andGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]}},
  :orGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]},
  :andGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]}},
 :dateRanges [{:startDate string, :endDate string}],
 :expandGroups boolean,
 :orderBys
 [{:desc boolean,
   :dimension
   {:orderType
    [ORDER_TYPE_UNSPECIFIED
     ALPHANUMERIC
     CASE_INSENSITIVE_ALPHANUMERIC
     NUMERIC],
    :dimensionName string},
   :metric {:metricName string}}],
 :metrics [{:metricName string}],
 :includeAllUsers boolean,
 :returnEntityQuota boolean}"
  [entity GoogleAnalyticsAdminV1betaRunAccessReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+entity}:runAccessReport",
     :uri-template-args {:entity entity},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body GoogleAnalyticsAdminV1betaRunAccessReportRequest}))

(defn accounts-getDataSharingSettings
  "Get data sharing settings on an account. Data sharing settings are singletons.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/getDataSharingSettings

name <string> Required. The name of the settings to lookup. Format: accounts/{account}/dataSharingSettings Example: \"accounts/1000/dataSharingSettings\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn accounts-delete
  "Marks target Account as soft-deleted (ie: \"trashed\") and returns it. This API does not have a method to restore soft-deleted accounts. However, they can be restored using the Trash Can UI. If the accounts are not restored before the expiration time, the account and all child resources (eg: Properties, GoogleAdsLinks, Streams, AccessBindings) will be permanently purged. https://support.google.com/analytics/answer/6154772 Returns an error if the target is not found.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/delete

name <string> Required. The name of the Account to soft-delete. Format: accounts/{account} Example: \"accounts/100\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn accounts-get
  "Lookup for a single Account.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/get

name <string> Required. The name of the account to lookup. Format: accounts/{account} Example: \"accounts/100\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn accounts-provisionAccountTicket
  "Requests a ticket for creating an account.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accounts/provisionAccountTicket

GoogleAnalyticsAdminV1betaProvisionAccountTicketRequest:
{:redirectUri string,
 :account
 {:gmpOrganization string,
  :deleted boolean,
  :displayName string,
  :updateTime string,
  :name string,
  :createTime string,
  :regionCode string}}"
  [GoogleAnalyticsAdminV1betaProvisionAccountTicketRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/accounts:provisionAccountTicket",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaProvisionAccountTicketRequest}))

(defn accountSummaries-list
  "Returns summaries of all accounts accessible by the caller.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/accountSummaries/list

optional:
pageSize <integer> The maximum number of AccountSummary resources to return. The service may return fewer than this value, even if there are additional pages. If unspecified, at most 50 resources will be returned. The maximum value is 200; (higher values will be coerced to the maximum)"
  ([] (accountSummaries-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/accountSummaries",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-get
  "Lookup for a single \"GA4\" Property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/get

name <string> Required. The name of the property to lookup. Format: properties/{property_id} Example: \"properties/1000\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-updateDataRetentionSettings
  "Updates the singleton data retention settings for this property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/updateDataRetentionSettings

name <string> Output only. Resource name for this DataRetentionSetting resource. Format: properties/{property}/dataRetentionSettings
GoogleAnalyticsAdminV1betaDataRetentionSettings:
{:eventDataRetention
 [RETENTION_DURATION_UNSPECIFIED
  TWO_MONTHS
  FOURTEEN_MONTHS
  TWENTY_SIX_MONTHS
  THIRTY_EIGHT_MONTHS
  FIFTY_MONTHS],
 :name string,
 :resetUserDataOnNewActivity boolean}

optional:
updateMask <string> Required. The list of fields to be updated. Field names must be in snake case (e.g., \"field_to_update\"). Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaDataRetentionSettings]
    (properties-updateDataRetentionSettings
      name
      GoogleAnalyticsAdminV1betaDataRetentionSettings
      nil))
  ([name GoogleAnalyticsAdminV1betaDataRetentionSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaDataRetentionSettings})))

(defn properties-getDataRetentionSettings
  "Returns the singleton data retention settings for this property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/getDataRetentionSettings

name <string> Required. The name of the settings to lookup. Format: properties/{property}/dataRetentionSettings Example: \"properties/1000/dataRetentionSettings\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-patch
  "Updates a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/patch

name <string> Output only. Resource name of this property. Format: properties/{property_id} Example: \"properties/1000\"
GoogleAnalyticsAdminV1betaProperty:
{:timeZone string,
 :deleteTime string,
 :parent string,
 :industryCategory
 [INDUSTRY_CATEGORY_UNSPECIFIED
  AUTOMOTIVE
  BUSINESS_AND_INDUSTRIAL_MARKETS
  FINANCE
  HEALTHCARE
  TECHNOLOGY
  TRAVEL
  OTHER
  ARTS_AND_ENTERTAINMENT
  BEAUTY_AND_FITNESS
  BOOKS_AND_LITERATURE
  FOOD_AND_DRINK
  GAMES
  HOBBIES_AND_LEISURE
  HOME_AND_GARDEN
  INTERNET_AND_TELECOM
  LAW_AND_GOVERNMENT
  NEWS
  ONLINE_COMMUNITIES
  PEOPLE_AND_SOCIETY
  PETS_AND_ANIMALS
  REAL_ESTATE
  REFERENCE
  SCIENCE
  SPORTS
  JOBS_AND_EDUCATION
  SHOPPING],
 :displayName string,
 :name string,
 :createTime string,
 :serviceLevel
 [SERVICE_LEVEL_UNSPECIFIED
  GOOGLE_ANALYTICS_STANDARD
  GOOGLE_ANALYTICS_360],
 :updateTime string,
 :account string,
 :expireTime string,
 :propertyType
 [PROPERTY_TYPE_UNSPECIFIED
  PROPERTY_TYPE_ORDINARY
  PROPERTY_TYPE_SUBPROPERTY
  PROPERTY_TYPE_ROLLUP],
 :currencyCode string}

optional:
updateMask <string> Required. The list of fields to be updated. Field names must be in snake case (e.g., \"field_to_update\"). Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaProperty]
    (properties-patch name GoogleAnalyticsAdminV1betaProperty nil))
  ([name GoogleAnalyticsAdminV1betaProperty optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaProperty})))

(defn properties-create
  "Creates an \"GA4\" property with the specified location and attributes.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/create

GoogleAnalyticsAdminV1betaProperty:
{:timeZone string,
 :deleteTime string,
 :parent string,
 :industryCategory
 [INDUSTRY_CATEGORY_UNSPECIFIED
  AUTOMOTIVE
  BUSINESS_AND_INDUSTRIAL_MARKETS
  FINANCE
  HEALTHCARE
  TECHNOLOGY
  TRAVEL
  OTHER
  ARTS_AND_ENTERTAINMENT
  BEAUTY_AND_FITNESS
  BOOKS_AND_LITERATURE
  FOOD_AND_DRINK
  GAMES
  HOBBIES_AND_LEISURE
  HOME_AND_GARDEN
  INTERNET_AND_TELECOM
  LAW_AND_GOVERNMENT
  NEWS
  ONLINE_COMMUNITIES
  PEOPLE_AND_SOCIETY
  PETS_AND_ANIMALS
  REAL_ESTATE
  REFERENCE
  SCIENCE
  SPORTS
  JOBS_AND_EDUCATION
  SHOPPING],
 :displayName string,
 :name string,
 :createTime string,
 :serviceLevel
 [SERVICE_LEVEL_UNSPECIFIED
  GOOGLE_ANALYTICS_STANDARD
  GOOGLE_ANALYTICS_360],
 :updateTime string,
 :account string,
 :expireTime string,
 :propertyType
 [PROPERTY_TYPE_UNSPECIFIED
  PROPERTY_TYPE_ORDINARY
  PROPERTY_TYPE_SUBPROPERTY
  PROPERTY_TYPE_ROLLUP],
 :currencyCode string}"
  [GoogleAnalyticsAdminV1betaProperty]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/properties",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaProperty}))

(defn properties-delete
  "Marks target Property as soft-deleted (ie: \"trashed\") and returns it. This API does not have a method to restore soft-deleted properties. However, they can be restored using the Trash Can UI. If the properties are not restored before the expiration time, the Property and all child resources (eg: GoogleAdsLinks, Streams, AccessBindings) will be permanently purged. https://support.google.com/analytics/answer/6154772 Returns an error if the target is not found, or is not a GA4 Property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/delete

name <string> Required. The name of the Property to soft-delete. Format: properties/{property_id} Example: \"properties/1000\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn properties-list
  "Returns child Properties under the specified parent Account. Only \"GA4\" properties will be returned. Properties will be excluded if the caller does not have access. Soft-deleted (ie: \"trashed\") properties are excluded by default. Returns an empty list if no relevant properties are found.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/list

optional:
pageSize <integer> The maximum number of resources to return. The service may return fewer than this value, even if there are additional pages. If unspecified, at most 50 resources will be returned. The maximum value is 200; (higher values will be coerced to the maximum)
filter <string> Required. An expression for filtering the results of the request. Fields eligible for filtering are: `parent:`(The resource name of the parent account/property) or `ancestor:`(The resource name of the parent account) or `firebase_project:`(The id or number of the linked firebase project). Some examples of filters: ``` | Filter | Description | |-----------------------------|-------------------------------------------| | parent:accounts/123 | The account with account id: 123. | | parent:properties/123 | The property with property id: 123. | | ancestor:accounts/123 | The account with account id: 123. | | firebase_project:project-id | The firebase project with id: project-id. | | firebase_project:123 | The firebase project with number: 123. | ```
showDeleted <boolean> Whether to include soft-deleted (ie: \"trashed\") Properties in the results. Properties can be inspected to determine whether they are deleted or not."
  ([] (properties-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/properties",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-acknowledgeUserDataCollection
  "Acknowledges the terms of user data collection for the specified property. This acknowledgement must be completed (either in the Google Analytics UI or through this API) before MeasurementProtocolSecret resources may be created.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/acknowledgeUserDataCollection

property <string> Required. The property for which to acknowledge user data collection.
GoogleAnalyticsAdminV1betaAcknowledgeUserDataCollectionRequest:
{:acknowledgement string}"
  [property
   GoogleAnalyticsAdminV1betaAcknowledgeUserDataCollectionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+property}:acknowledgeUserDataCollection",
     :uri-template-args {:property property},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body
     GoogleAnalyticsAdminV1betaAcknowledgeUserDataCollectionRequest}))

(defn properties-runAccessReport
  "Returns a customized report of data access records. The report provides records of each time a user reads Google Analytics reporting data. Access records are retained for up to 2 years. Data Access Reports can be requested for a property. Reports may be requested for any property, but dimensions that aren't related to quota can only be requested on Google Analytics 360 properties. This method is only available to Administrators. These data access records include GA4 UI Reporting, GA4 UI Explorations, GA4 Data API, and other products like Firebase & Admob that can retrieve data from Google Analytics through a linkage. These records don't include property configuration changes like adding a stream or changing a property's time zone. For configuration change history, see [searchChangeHistoryEvents](https://developers.google.com/analytics/devguides/config/admin/v1/rest/v1alpha/accounts/searchChangeHistoryEvents).
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/runAccessReport

entity <string> The Data Access Report supports requesting at the property level or account level. If requested at the account level, Data Access Reports include all access for all properties under that account. To request at the property level, entity should be for example 'properties/123' if \"123\" is your GA4 property ID. To request at the account level, entity should be for example 'accounts/1234' if \"1234\" is your GA4 Account ID.
GoogleAnalyticsAdminV1betaRunAccessReportRequest:
{:timeZone string,
 :limit string,
 :offset string,
 :dimensionFilter
 {:accessFilter
  {:fieldName string,
   :betweenFilter
   {:toValue {:int64Value string, :doubleValue number},
    :fromValue {:int64Value string, :doubleValue number}},
   :inListFilter {:caseSensitive boolean, :values [string]},
   :numericFilter
   {:value {:int64Value string, :doubleValue number},
    :operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL]},
   :stringFilter
   {:value string,
    :caseSensitive boolean,
    :matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP]}},
  :notExpression
  {:accessFilter
   {:fieldName string,
    :betweenFilter
    {:toValue GoogleAnalyticsAdminV1betaNumericValue,
     :fromValue GoogleAnalyticsAdminV1betaNumericValue},
    :inListFilter {:caseSensitive boolean, :values [string]},
    :numericFilter
    {:value GoogleAnalyticsAdminV1betaNumericValue,
     :operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL]},
    :stringFilter
    {:value string,
     :caseSensitive boolean,
     :matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP]}},
   :notExpression
   {:accessFilter
    {:fieldName string,
     :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
     :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
     :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
     :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
    :notExpression
    {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
     :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
     :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
     :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
    :orGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
    :andGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]}},
   :orGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]},
   :andGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]}},
  :orGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]},
  :andGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]}},
 :dimensions [{:dimensionName string}],
 :metricFilter
 {:accessFilter
  {:fieldName string,
   :betweenFilter
   {:toValue {:int64Value string, :doubleValue number},
    :fromValue {:int64Value string, :doubleValue number}},
   :inListFilter {:caseSensitive boolean, :values [string]},
   :numericFilter
   {:value {:int64Value string, :doubleValue number},
    :operation
    [OPERATION_UNSPECIFIED
     EQUAL
     LESS_THAN
     LESS_THAN_OR_EQUAL
     GREATER_THAN
     GREATER_THAN_OR_EQUAL]},
   :stringFilter
   {:value string,
    :caseSensitive boolean,
    :matchType
    [MATCH_TYPE_UNSPECIFIED
     EXACT
     BEGINS_WITH
     ENDS_WITH
     CONTAINS
     FULL_REGEXP
     PARTIAL_REGEXP]}},
  :notExpression
  {:accessFilter
   {:fieldName string,
    :betweenFilter
    {:toValue GoogleAnalyticsAdminV1betaNumericValue,
     :fromValue GoogleAnalyticsAdminV1betaNumericValue},
    :inListFilter {:caseSensitive boolean, :values [string]},
    :numericFilter
    {:value GoogleAnalyticsAdminV1betaNumericValue,
     :operation
     [OPERATION_UNSPECIFIED
      EQUAL
      LESS_THAN
      LESS_THAN_OR_EQUAL
      GREATER_THAN
      GREATER_THAN_OR_EQUAL]},
    :stringFilter
    {:value string,
     :caseSensitive boolean,
     :matchType
     [MATCH_TYPE_UNSPECIFIED
      EXACT
      BEGINS_WITH
      ENDS_WITH
      CONTAINS
      FULL_REGEXP
      PARTIAL_REGEXP]}},
   :notExpression
   {:accessFilter
    {:fieldName string,
     :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
     :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
     :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
     :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
    :notExpression
    {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
     :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
     :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
     :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
    :orGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
    :andGroup
    {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]}},
   :orGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]},
   :andGroup
   {:expressions
    [{:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup
      GoogleAnalyticsAdminV1betaAccessFilterExpressionList}]}},
  :orGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]},
  :andGroup
  {:expressions
   [{:accessFilter
     {:fieldName string,
      :betweenFilter GoogleAnalyticsAdminV1betaAccessBetweenFilter,
      :inListFilter GoogleAnalyticsAdminV1betaAccessInListFilter,
      :numericFilter GoogleAnalyticsAdminV1betaAccessNumericFilter,
      :stringFilter GoogleAnalyticsAdminV1betaAccessStringFilter},
     :notExpression
     {:accessFilter GoogleAnalyticsAdminV1betaAccessFilter,
      :notExpression GoogleAnalyticsAdminV1betaAccessFilterExpression,
      :orGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList,
      :andGroup GoogleAnalyticsAdminV1betaAccessFilterExpressionList},
     :orGroup
     {:expressions [GoogleAnalyticsAdminV1betaAccessFilterExpression]},
     :andGroup
     {:expressions
      [GoogleAnalyticsAdminV1betaAccessFilterExpression]}}]}},
 :dateRanges [{:startDate string, :endDate string}],
 :expandGroups boolean,
 :orderBys
 [{:desc boolean,
   :dimension
   {:orderType
    [ORDER_TYPE_UNSPECIFIED
     ALPHANUMERIC
     CASE_INSENSITIVE_ALPHANUMERIC
     NUMERIC],
    :dimensionName string},
   :metric {:metricName string}}],
 :metrics [{:metricName string}],
 :includeAllUsers boolean,
 :returnEntityQuota boolean}"
  [entity GoogleAnalyticsAdminV1betaRunAccessReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+entity}:runAccessReport",
     :uri-template-args {:entity entity},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"],
     :body GoogleAnalyticsAdminV1betaRunAccessReportRequest}))

(defn properties-firebaseLinks-delete
  "Deletes a FirebaseLink on a property
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/firebaseLinks/delete

name <string> Required. Format: properties/{property_id}/firebaseLinks/{firebase_link_id} Example: properties/1234/firebaseLinks/5678"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn properties-firebaseLinks-list
  "Lists FirebaseLinks on a property. Properties can have at most one FirebaseLink.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/firebaseLinks/list

parent <string> Required. Format: properties/{property_id} Example: properties/1234

optional:
pageSize <integer> The maximum number of resources to return. The service may return fewer than this value, even if there are additional pages. If unspecified, at most 50 resources will be returned. The maximum value is 200; (higher values will be coerced to the maximum)"
  ([parent] (properties-firebaseLinks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/firebaseLinks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-firebaseLinks-create
  "Creates a FirebaseLink. Properties can have at most one FirebaseLink.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/firebaseLinks/create

parent <string> Required. Format: properties/{property_id} Example: properties/1234
GoogleAnalyticsAdminV1betaFirebaseLink:
{:createTime string, :name string, :project string}"
  [parent GoogleAnalyticsAdminV1betaFirebaseLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/firebaseLinks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaFirebaseLink}))

(defn properties-customMetrics-list
  "Lists CustomMetrics on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/list

parent <string> Required. Example format: properties/1234

optional:
pageSize <integer> The maximum number of resources to return. If unspecified, at most 50 resources will be returned. The maximum value is 200 (higher values will be coerced to the maximum)."
  ([parent] (properties-customMetrics-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/customMetrics",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-customMetrics-create
  "Creates a CustomMetric.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/create

parent <string> Required. Example format: properties/1234
GoogleAnalyticsAdminV1betaCustomMetric:
{:scope [METRIC_SCOPE_UNSPECIFIED EVENT],
 :measurementUnit
 [MEASUREMENT_UNIT_UNSPECIFIED
  STANDARD
  CURRENCY
  FEET
  METERS
  KILOMETERS
  MILES
  MILLISECONDS
  SECONDS
  MINUTES
  HOURS],
 :name string,
 :description string,
 :restrictedMetricType
 [[RESTRICTED_METRIC_TYPE_UNSPECIFIED COST_DATA REVENUE_DATA]],
 :parameterName string,
 :displayName string}"
  [parent GoogleAnalyticsAdminV1betaCustomMetric]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/customMetrics",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaCustomMetric}))

(defn properties-customMetrics-get
  "Lookup for a single CustomMetric.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/get

name <string> Required. The name of the CustomMetric to get. Example format: properties/1234/customMetrics/5678"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-customMetrics-archive
  "Archives a CustomMetric on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/archive

name <string> Required. The name of the CustomMetric to archive. Example format: properties/1234/customMetrics/5678
GoogleAnalyticsAdminV1betaArchiveCustomMetricRequest:
object"
  [name GoogleAnalyticsAdminV1betaArchiveCustomMetricRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}:archive",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaArchiveCustomMetricRequest}))

(defn properties-customMetrics-patch
  "Updates a CustomMetric on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customMetrics/patch

name <string> Output only. Resource name for this CustomMetric resource. Format: properties/{property}/customMetrics/{customMetric}
GoogleAnalyticsAdminV1betaCustomMetric:
{:scope [METRIC_SCOPE_UNSPECIFIED EVENT],
 :measurementUnit
 [MEASUREMENT_UNIT_UNSPECIFIED
  STANDARD
  CURRENCY
  FEET
  METERS
  KILOMETERS
  MILES
  MILLISECONDS
  SECONDS
  MINUTES
  HOURS],
 :name string,
 :description string,
 :restrictedMetricType
 [[RESTRICTED_METRIC_TYPE_UNSPECIFIED COST_DATA REVENUE_DATA]],
 :parameterName string,
 :displayName string}

optional:
updateMask <string> Required. The list of fields to be updated. Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaCustomMetric]
    (properties-customMetrics-patch
      name
      GoogleAnalyticsAdminV1betaCustomMetric
      nil))
  ([name GoogleAnalyticsAdminV1betaCustomMetric optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaCustomMetric})))

(defn properties-conversionEvents-get
  "Retrieve a single conversion event.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/get

name <string> Required. The resource name of the conversion event to retrieve. Format: properties/{property}/conversionEvents/{conversion_event} Example: \"properties/123/conversionEvents/456\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-conversionEvents-list
  "Returns a list of conversion events in the specified parent property. Returns an empty list if no conversion events are found.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/list

parent <string> Required. The resource name of the parent property. Example: 'properties/123'

optional:
pageSize <integer> The maximum number of resources to return. If unspecified, at most 50 resources will be returned. The maximum value is 200; (higher values will be coerced to the maximum)"
  ([parent] (properties-conversionEvents-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/conversionEvents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-conversionEvents-delete
  "Deletes a conversion event in a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/delete

name <string> Required. The resource name of the conversion event to delete. Format: properties/{property}/conversionEvents/{conversion_event} Example: \"properties/123/conversionEvents/456\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn properties-conversionEvents-patch
  "Updates a conversion event with the specified attributes.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/patch

name <string> Output only. Resource name of this conversion event. Format: properties/{property}/conversionEvents/{conversion_event}
GoogleAnalyticsAdminV1betaConversionEvent:
{:createTime string,
 :countingMethod
 [CONVERSION_COUNTING_METHOD_UNSPECIFIED
  ONCE_PER_EVENT
  ONCE_PER_SESSION],
 :defaultConversionValue {:value number, :currencyCode string},
 :deletable boolean,
 :eventName string,
 :custom boolean,
 :name string}

optional:
updateMask <string> Required. The list of fields to be updated. Field names must be in snake case (e.g., \"field_to_update\"). Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaConversionEvent]
    (properties-conversionEvents-patch
      name
      GoogleAnalyticsAdminV1betaConversionEvent
      nil))
  ([name GoogleAnalyticsAdminV1betaConversionEvent optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaConversionEvent})))

(defn properties-conversionEvents-create
  "Creates a conversion event with the specified attributes.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/conversionEvents/create

parent <string> Required. The resource name of the parent property where this conversion event will be created. Format: properties/123
GoogleAnalyticsAdminV1betaConversionEvent:
{:createTime string,
 :countingMethod
 [CONVERSION_COUNTING_METHOD_UNSPECIFIED
  ONCE_PER_EVENT
  ONCE_PER_SESSION],
 :defaultConversionValue {:value number, :currencyCode string},
 :deletable boolean,
 :eventName string,
 :custom boolean,
 :name string}"
  [parent GoogleAnalyticsAdminV1betaConversionEvent]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/conversionEvents",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaConversionEvent}))

(defn properties-dataStreams-patch
  "Updates a DataStream on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/patch

name <string> Output only. Resource name of this Data Stream. Format: properties/{property_id}/dataStreams/{stream_id} Example: \"properties/1000/dataStreams/2000\"
GoogleAnalyticsAdminV1betaDataStream:
{:type
 [DATA_STREAM_TYPE_UNSPECIFIED
  WEB_DATA_STREAM
  ANDROID_APP_DATA_STREAM
  IOS_APP_DATA_STREAM],
 :name string,
 :androidAppStreamData {:packageName string, :firebaseAppId string},
 :iosAppStreamData {:bundleId string, :firebaseAppId string},
 :displayName string,
 :updateTime string,
 :createTime string,
 :webStreamData
 {:defaultUri string, :firebaseAppId string, :measurementId string}}

optional:
updateMask <string> Required. The list of fields to be updated. Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaDataStream]
    (properties-dataStreams-patch
      name
      GoogleAnalyticsAdminV1betaDataStream
      nil))
  ([name GoogleAnalyticsAdminV1betaDataStream optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaDataStream})))

(defn properties-dataStreams-get
  "Lookup for a single DataStream.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/get

name <string> Required. The name of the DataStream to get. Example format: properties/1234/dataStreams/5678"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-dataStreams-delete
  "Deletes a DataStream on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/delete

name <string> Required. The name of the DataStream to delete. Example format: properties/1234/dataStreams/5678"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn properties-dataStreams-list
  "Lists DataStreams on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/list

parent <string> Required. Example format: properties/1234

optional:
pageSize <integer> The maximum number of resources to return. If unspecified, at most 50 resources will be returned. The maximum value is 200 (higher values will be coerced to the maximum)."
  ([parent] (properties-dataStreams-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/dataStreams",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-dataStreams-create
  "Creates a DataStream.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/create

parent <string> Required. Example format: properties/1234
GoogleAnalyticsAdminV1betaDataStream:
{:type
 [DATA_STREAM_TYPE_UNSPECIFIED
  WEB_DATA_STREAM
  ANDROID_APP_DATA_STREAM
  IOS_APP_DATA_STREAM],
 :name string,
 :androidAppStreamData {:packageName string, :firebaseAppId string},
 :iosAppStreamData {:bundleId string, :firebaseAppId string},
 :displayName string,
 :updateTime string,
 :createTime string,
 :webStreamData
 {:defaultUri string, :firebaseAppId string, :measurementId string}}"
  [parent GoogleAnalyticsAdminV1betaDataStream]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/dataStreams",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaDataStream}))

(defn properties-dataStreams-eventEditRules-reorder
  "Changes the processing order of event edit rules on the specified stream.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/eventEditRules/reorder

parent <string> Required. Example format: properties/123/dataStreams/456
GoogleAnalyticsAdminV1betaReorderEventEditRulesRequest:
{:eventEditRules [string]}"
  [parent GoogleAnalyticsAdminV1betaReorderEventEditRulesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/eventEditRules:reorder",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body GoogleAnalyticsAdminV1betaReorderEventEditRulesRequest}))

(defn properties-dataStreams-measurementProtocolSecrets-list
  "Returns child MeasurementProtocolSecrets under the specified parent Property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/list

parent <string> Required. The resource name of the parent stream. Format: properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets

optional:
pageSize <integer> The maximum number of resources to return. If unspecified, at most 10 resources will be returned. The maximum value is 10. Higher values will be coerced to the maximum."
  ([parent]
    (properties-dataStreams-measurementProtocolSecrets-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/measurementProtocolSecrets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-dataStreams-measurementProtocolSecrets-delete
  "Deletes target MeasurementProtocolSecret.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/delete

name <string> Required. The name of the MeasurementProtocolSecret to delete. Format: properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets/{measurementProtocolSecret}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn properties-dataStreams-measurementProtocolSecrets-patch
  "Updates a measurement protocol secret.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/patch

name <string> Output only. Resource name of this secret. This secret may be a child of any type of stream. Format: properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets/{measurementProtocolSecret}
GoogleAnalyticsAdminV1betaMeasurementProtocolSecret:
{:displayName string, :name string, :secretValue string}

optional:
updateMask <string> Required. The list of fields to be updated. Omitted fields will not be updated."
  ([name GoogleAnalyticsAdminV1betaMeasurementProtocolSecret]
    (properties-dataStreams-measurementProtocolSecrets-patch
      name
      GoogleAnalyticsAdminV1betaMeasurementProtocolSecret
      nil))
  ([name GoogleAnalyticsAdminV1betaMeasurementProtocolSecret optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaMeasurementProtocolSecret})))

(defn properties-dataStreams-measurementProtocolSecrets-create
  "Creates a measurement protocol secret.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/create

parent <string> Required. The parent resource where this secret will be created. Format: properties/{property}/dataStreams/{dataStream}
GoogleAnalyticsAdminV1betaMeasurementProtocolSecret:
{:displayName string, :name string, :secretValue string}"
  [parent GoogleAnalyticsAdminV1betaMeasurementProtocolSecret]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/measurementProtocolSecrets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaMeasurementProtocolSecret}))

(defn properties-dataStreams-measurementProtocolSecrets-get
  "Lookup for a single \"GA4\" MeasurementProtocolSecret.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/dataStreams/measurementProtocolSecrets/get

name <string> Required. The name of the measurement protocol secret to lookup. Format: properties/{property}/dataStreams/{dataStream}/measurementProtocolSecrets/{measurementProtocolSecret}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-googleAdsLinks-list
  "Lists GoogleAdsLinks on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/list

parent <string> Required. Example format: properties/1234

optional:
pageSize <integer> The maximum number of resources to return. If unspecified, at most 50 resources will be returned. The maximum value is 200 (higher values will be coerced to the maximum)."
  ([parent] (properties-googleAdsLinks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/googleAdsLinks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-googleAdsLinks-patch
  "Updates a GoogleAdsLink on a property
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/patch

name <string> Output only. Format: properties/{propertyId}/googleAdsLinks/{googleAdsLinkId} Note: googleAdsLinkId is not the Google Ads customer ID.
GoogleAnalyticsAdminV1betaGoogleAdsLink:
{:name string,
 :creatorEmailAddress string,
 :adsPersonalizationEnabled boolean,
 :canManageClients boolean,
 :customerId string,
 :updateTime string,
 :createTime string}

optional:
updateMask <string> Required. The list of fields to be updated. Field names must be in snake case (e.g., \"field_to_update\"). Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaGoogleAdsLink]
    (properties-googleAdsLinks-patch
      name
      GoogleAnalyticsAdminV1betaGoogleAdsLink
      nil))
  ([name GoogleAnalyticsAdminV1betaGoogleAdsLink optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaGoogleAdsLink})))

(defn properties-googleAdsLinks-delete
  "Deletes a GoogleAdsLink on a property
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/delete

name <string> Required. Example format: properties/1234/googleAdsLinks/5678"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn properties-googleAdsLinks-create
  "Creates a GoogleAdsLink.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/googleAdsLinks/create

parent <string> Required. Example format: properties/1234
GoogleAnalyticsAdminV1betaGoogleAdsLink:
{:name string,
 :creatorEmailAddress string,
 :adsPersonalizationEnabled boolean,
 :canManageClients boolean,
 :customerId string,
 :updateTime string,
 :createTime string}"
  [parent GoogleAnalyticsAdminV1betaGoogleAdsLink]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/googleAdsLinks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaGoogleAdsLink}))

(defn properties-keyEvents-list
  "Returns a list of Key Events in the specified parent property. Returns an empty list if no Key Events are found.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/list

parent <string> Required. The resource name of the parent property. Example: 'properties/123'

optional:
pageSize <integer> The maximum number of resources to return. If unspecified, at most 50 resources will be returned. The maximum value is 200; (higher values will be coerced to the maximum)"
  ([parent] (properties-keyEvents-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/keyEvents",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-keyEvents-create
  "Creates a Key Event.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/create

parent <string> Required. The resource name of the parent property where this Key Event will be created. Format: properties/123
GoogleAnalyticsAdminV1betaKeyEvent:
{:eventName string,
 :deletable boolean,
 :countingMethod
 [COUNTING_METHOD_UNSPECIFIED ONCE_PER_EVENT ONCE_PER_SESSION],
 :createTime string,
 :defaultValue {:currencyCode string, :numericValue number},
 :name string,
 :custom boolean}"
  [parent GoogleAnalyticsAdminV1betaKeyEvent]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/keyEvents",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaKeyEvent}))

(defn properties-keyEvents-get
  "Retrieve a single Key Event.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/get

name <string> Required. The resource name of the Key Event to retrieve. Format: properties/{property}/keyEvents/{key_event} Example: \"properties/123/keyEvents/456\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-keyEvents-patch
  "Updates a Key Event.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/patch

name <string> Output only. Resource name of this key event. Format: properties/{property}/keyEvents/{key_event}
GoogleAnalyticsAdminV1betaKeyEvent:
{:eventName string,
 :deletable boolean,
 :countingMethod
 [COUNTING_METHOD_UNSPECIFIED ONCE_PER_EVENT ONCE_PER_SESSION],
 :createTime string,
 :defaultValue {:currencyCode string, :numericValue number},
 :name string,
 :custom boolean}

optional:
updateMask <string> Required. The list of fields to be updated. Field names must be in snake case (e.g., \"field_to_update\"). Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaKeyEvent]
    (properties-keyEvents-patch
      name
      GoogleAnalyticsAdminV1betaKeyEvent
      nil))
  ([name GoogleAnalyticsAdminV1betaKeyEvent optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaKeyEvent})))

(defn properties-keyEvents-delete
  "Deletes a Key Event.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/keyEvents/delete

name <string> Required. The resource name of the Key Event to delete. Format: properties/{property}/keyEvents/{key_event} Example: \"properties/123/keyEvents/456\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"]}))

(defn properties-customDimensions-create
  "Creates a CustomDimension.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/create

parent <string> Required. Example format: properties/1234
GoogleAnalyticsAdminV1betaCustomDimension:
{:scope [DIMENSION_SCOPE_UNSPECIFIED EVENT USER ITEM],
 :displayName string,
 :description string,
 :parameterName string,
 :name string,
 :disallowAdsPersonalization boolean}"
  [parent GoogleAnalyticsAdminV1betaCustomDimension]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+parent}/customDimensions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaCustomDimension}))

(defn properties-customDimensions-list
  "Lists CustomDimensions on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/list

parent <string> Required. Example format: properties/1234

optional:
pageSize <integer> The maximum number of resources to return. If unspecified, at most 50 resources will be returned. The maximum value is 200 (higher values will be coerced to the maximum)."
  ([parent] (properties-customDimensions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+parent}/customDimensions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/analytics.edit"
        "https://www.googleapis.com/auth/analytics.readonly"]})))

(defn properties-customDimensions-get
  "Lookup for a single CustomDimension.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/get

name <string> Required. The name of the CustomDimension to get. Example format: properties/1234/customDimensions/5678"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/analytics.edit"
      "https://www.googleapis.com/auth/analytics.readonly"]}))

(defn properties-customDimensions-patch
  "Updates a CustomDimension on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/patch

name <string> Output only. Resource name for this CustomDimension resource. Format: properties/{property}/customDimensions/{customDimension}
GoogleAnalyticsAdminV1betaCustomDimension:
{:scope [DIMENSION_SCOPE_UNSPECIFIED EVENT USER ITEM],
 :displayName string,
 :description string,
 :parameterName string,
 :name string,
 :disallowAdsPersonalization boolean}

optional:
updateMask <string> Required. The list of fields to be updated. Omitted fields will not be updated. To replace the entire entity, use one path with the string \"*\" to match all fields."
  ([name GoogleAnalyticsAdminV1betaCustomDimension]
    (properties-customDimensions-patch
      name
      GoogleAnalyticsAdminV1betaCustomDimension
      nil))
  ([name GoogleAnalyticsAdminV1betaCustomDimension optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://analyticsadmin.googleapis.com/v1beta/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/analytics.edit"],
       :body GoogleAnalyticsAdminV1betaCustomDimension})))

(defn properties-customDimensions-archive
  "Archives a CustomDimension on a property.
https://developers.google.com/analytics/devguides/config/?csw=1/v1beta/docs/properties/customDimensions/archive

name <string> Required. The name of the CustomDimension to archive. Example format: properties/1234/customDimensions/5678
GoogleAnalyticsAdminV1betaArchiveCustomDimensionRequest:
object"
  [name GoogleAnalyticsAdminV1betaArchiveCustomDimensionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticsadmin.googleapis.com/v1beta/{+name}:archive",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/analytics.edit"],
     :body GoogleAnalyticsAdminV1betaArchiveCustomDimensionRequest}))

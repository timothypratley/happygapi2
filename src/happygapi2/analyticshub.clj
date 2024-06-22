(ns happygapi2.analyticshub
  "Analytics Hub API
Exchange data and analytics assets securely and efficiently.
See: https://cloud.google.com/bigquery/docs/analytics-hub-introduction"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-dataExchanges-get
  "Gets the details of a data exchange.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. The resource name of the data exchange. e.g. `projects/myproject/locations/US/dataExchanges/123`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataExchanges-setIamPolicy
  "Sets the IAM policy.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

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
     "https://analyticshub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-dataExchanges-patch
  "Updates an existing data exchange.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Output only. The resource name of the data exchange. e.g. `projects/myproject/locations/US/dataExchanges/123`.
DataExchange:
{:name string,
 :displayName string,
 :description string,
 :primaryContact string,
 :documentation string,
 :listingCount integer,
 :icon string,
 :sharingEnvironmentConfig
 {:defaultExchangeConfig object,
  :dcrExchangeConfig
  {:singleSelectedResourceSharingRestriction boolean,
   :singleLinkedDatasetPerCleanroom boolean}}}

optional:
updateMask <string> Required. Field mask specifies the fields to update in the data exchange resource. The fields specified in the `updateMask` are relative to the resource and are not a full request."
  ([name DataExchange]
    (projects-locations-dataExchanges-patch name DataExchange nil))
  ([name DataExchange optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body DataExchange})))

(defn projects-locations-dataExchanges-testIamPermissions
  "Returns the permissions that a caller has.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-dataExchanges-create
  "Creates a new data exchange.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

parent <string> Required. The parent resource path of the data exchange. e.g. `projects/myproject/locations/US`.
DataExchange:
{:name string,
 :displayName string,
 :description string,
 :primaryContact string,
 :documentation string,
 :listingCount integer,
 :icon string,
 :sharingEnvironmentConfig
 {:defaultExchangeConfig object,
  :dcrExchangeConfig
  {:singleSelectedResourceSharingRestriction boolean,
   :singleLinkedDatasetPerCleanroom boolean}}}

optional:
dataExchangeId <string> Required. The ID of the data exchange. Must contain only Unicode letters, numbers (0-9), underscores (_). Should not use characters that require URL-escaping, or characters outside of ASCII, spaces. Max length: 100 bytes."
  ([parent DataExchange]
    (projects-locations-dataExchanges-create parent DataExchange nil))
  ([parent DataExchange optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+parent}/dataExchanges",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body DataExchange})))

(defn projects-locations-dataExchanges-listSubscriptions
  "Lists all subscriptions on a given Data Exchange or Listing.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

resource <string> Required. Resource name of the requested target. This resource may be either a Listing or a DataExchange. e.g. projects/123/locations/US/dataExchanges/456 OR e.g. projects/123/locations/US/dataExchanges/456/listings/789

optional:
includeDeletedSubscriptions <boolean> If selected, includes deleted subscriptions in the response (up to 63 days after deletion).
pageSize <integer> The maximum number of results to return in a single response page."
  ([resource]
    (projects-locations-dataExchanges-listSubscriptions resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+resource}:listSubscriptions",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataExchanges-delete
  "Deletes an existing data exchange.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. The full name of the data exchange resource that you want to delete. For example, `projects/myproject/locations/US/dataExchanges/123`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataExchanges-getIamPolicy
  "Gets the IAM policy.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-dataExchanges-list
  "Lists all data exchanges in a given project and location.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

parent <string> Required. The parent resource path of the data exchanges. e.g. `projects/myproject/locations/US`.

optional:
pageSize <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection."
  ([parent] (projects-locations-dataExchanges-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+parent}/dataExchanges",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataExchanges-subscribe
  "Creates a Subscription to a Data Exchange. This is a long-running operation as it will create one or more linked datasets.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. Resource name of the Data Exchange. e.g. `projects/publisherproject/locations/US/dataExchanges/123`
SubscribeDataExchangeRequest:
{:destination string, :subscription string, :subscriberContact string}"
  [name SubscribeDataExchangeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+name}:subscribe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SubscribeDataExchangeRequest}))

(defn projects-locations-dataExchanges-listings-get
  "Gets the details of a listing.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. The resource name of the listing. e.g. `projects/myproject/locations/US/dataExchanges/123/listings/456`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataExchanges-listings-setIamPolicy
  "Sets the IAM policy.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

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
     "https://analyticshub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-dataExchanges-listings-patch
  "Updates an existing listing.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Output only. The resource name of the listing. e.g. `projects/myproject/locations/US/dataExchanges/123/listings/456`
Listing:
{:description string,
 :requestAccess string,
 :publisher {:name string, :primaryContact string},
 :displayName string,
 :name string,
 :state [STATE_UNSPECIFIED ACTIVE],
 :dataProvider {:name string, :primaryContact string},
 :restrictedExportConfig
 {:enabled boolean,
  :restrictDirectTableAccess boolean,
  :restrictQueryResult boolean},
 :icon string,
 :documentation string,
 :categories
 [[CATEGORY_UNSPECIFIED
   CATEGORY_OTHERS
   CATEGORY_ADVERTISING_AND_MARKETING
   CATEGORY_COMMERCE
   CATEGORY_CLIMATE_AND_ENVIRONMENT
   CATEGORY_DEMOGRAPHICS
   CATEGORY_ECONOMICS
   CATEGORY_EDUCATION
   CATEGORY_ENERGY
   CATEGORY_FINANCIAL
   CATEGORY_GAMING
   CATEGORY_GEOSPATIAL
   CATEGORY_HEALTHCARE_AND_LIFE_SCIENCE
   CATEGORY_MEDIA
   CATEGORY_PUBLIC_SECTOR
   CATEGORY_RETAIL
   CATEGORY_SPORTS
   CATEGORY_SCIENCE_AND_RESEARCH
   CATEGORY_TRANSPORTATION_AND_LOGISTICS
   CATEGORY_TRAVEL_AND_TOURISM]],
 :primaryContact string,
 :bigqueryDataset
 {:dataset string,
  :selectedResources [{:table string}],
  :restrictedExportPolicy
  {:enabled boolean,
   :restrictDirectTableAccess boolean,
   :restrictQueryResult boolean}}}

optional:
updateMask <string> Required. Field mask specifies the fields to update in the listing resource. The fields specified in the `updateMask` are relative to the resource and are not a full request."
  ([name Listing]
    (projects-locations-dataExchanges-listings-patch name Listing nil))
  ([name Listing optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Listing})))

(defn projects-locations-dataExchanges-listings-testIamPermissions
  "Returns the permissions that a caller has.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-dataExchanges-listings-create
  "Creates a new listing.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

parent <string> Required. The parent resource path of the listing. e.g. `projects/myproject/locations/US/dataExchanges/123`.
Listing:
{:description string,
 :requestAccess string,
 :publisher {:name string, :primaryContact string},
 :displayName string,
 :name string,
 :state [STATE_UNSPECIFIED ACTIVE],
 :dataProvider {:name string, :primaryContact string},
 :restrictedExportConfig
 {:enabled boolean,
  :restrictDirectTableAccess boolean,
  :restrictQueryResult boolean},
 :icon string,
 :documentation string,
 :categories
 [[CATEGORY_UNSPECIFIED
   CATEGORY_OTHERS
   CATEGORY_ADVERTISING_AND_MARKETING
   CATEGORY_COMMERCE
   CATEGORY_CLIMATE_AND_ENVIRONMENT
   CATEGORY_DEMOGRAPHICS
   CATEGORY_ECONOMICS
   CATEGORY_EDUCATION
   CATEGORY_ENERGY
   CATEGORY_FINANCIAL
   CATEGORY_GAMING
   CATEGORY_GEOSPATIAL
   CATEGORY_HEALTHCARE_AND_LIFE_SCIENCE
   CATEGORY_MEDIA
   CATEGORY_PUBLIC_SECTOR
   CATEGORY_RETAIL
   CATEGORY_SPORTS
   CATEGORY_SCIENCE_AND_RESEARCH
   CATEGORY_TRANSPORTATION_AND_LOGISTICS
   CATEGORY_TRAVEL_AND_TOURISM]],
 :primaryContact string,
 :bigqueryDataset
 {:dataset string,
  :selectedResources [{:table string}],
  :restrictedExportPolicy
  {:enabled boolean,
   :restrictDirectTableAccess boolean,
   :restrictQueryResult boolean}}}

optional:
listingId <string> Required. The ID of the listing to create. Must contain only Unicode letters, numbers (0-9), underscores (_). Should not use characters that require URL-escaping, or characters outside of ASCII, spaces. Max length: 100 bytes."
  ([parent Listing]
    (projects-locations-dataExchanges-listings-create
      parent
      Listing
      nil))
  ([parent Listing optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+parent}/listings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Listing})))

(defn projects-locations-dataExchanges-listings-listSubscriptions
  "Lists all subscriptions on a given Data Exchange or Listing.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

resource <string> Required. Resource name of the requested target. This resource may be either a Listing or a DataExchange. e.g. projects/123/locations/US/dataExchanges/456 OR e.g. projects/123/locations/US/dataExchanges/456/listings/789

optional:
includeDeletedSubscriptions <boolean> If selected, includes deleted subscriptions in the response (up to 63 days after deletion).
pageSize <integer> The maximum number of results to return in a single response page."
  ([resource]
    (projects-locations-dataExchanges-listings-listSubscriptions
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+resource}:listSubscriptions",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataExchanges-listings-delete
  "Deletes a listing.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. Resource name of the listing to delete. e.g. `projects/myproject/locations/US/dataExchanges/123/listings/456`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataExchanges-listings-getIamPolicy
  "Gets the IAM policy.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-dataExchanges-listings-list
  "Lists all listings in a given project and location.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

parent <string> Required. The parent resource path of the listing. e.g. `projects/myproject/locations/US/dataExchanges/123`.

optional:
pageSize <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection."
  ([parent]
    (projects-locations-dataExchanges-listings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+parent}/listings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataExchanges-listings-subscribe
  "Subscribes to a listing. Currently, with Analytics Hub, you can create listings that reference only BigQuery datasets. Upon subscription to a listing for a BigQuery dataset, Analytics Hub creates a linked dataset in the subscriber's project.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. Resource name of the listing that you want to subscribe to. e.g. `projects/myproject/locations/US/dataExchanges/123/listings/456`.
SubscribeListingRequest:
{:destinationDataset
 {:datasetReference {:datasetId string, :projectId string},
  :friendlyName string,
  :description string,
  :labels object,
  :location string}}"
  [name SubscribeListingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+name}:subscribe",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SubscribeListingRequest}))

(defn projects-locations-subscriptions-refresh
  "Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher adds or removes data. This is a long-running operation as it may create many linked datasets.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. Resource name of the Subscription to refresh. e.g. `projects/subscriberproject/locations/US/subscriptions/123`
RefreshSubscriptionRequest:
object"
  [name RefreshSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+name}:refresh",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body RefreshSubscriptionRequest}))

(defn projects-locations-subscriptions-get
  "Gets the details of a Subscription.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. Resource name of the subscription. e.g. projects/123/locations/US/subscriptions/456"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-subscriptions-list
  "Lists all subscriptions in a given project and location.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

parent <string> Required. The parent resource path of the subscription. e.g. projects/myproject/locations/US

optional:
filter <string> An expression for filtering the results of the request. Eligible fields for filtering are: + `listing` + `data_exchange` Alternatively, a literal wrapped in double quotes may be provided. This will be checked for an exact match against both fields above. In all cases, the full Data Exchange or Listing resource name must be provided. Some example of using filters: + data_exchange=\"projects/myproject/locations/us/dataExchanges/123\" + listing=\"projects/123/locations/us/dataExchanges/456/listings/789\" + \"projects/myproject/locations/us/dataExchanges/123\"
pageSize <integer> The maximum number of results to return in a single response page."
  ([parent] (projects-locations-subscriptions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+parent}/subscriptions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-subscriptions-revoke
  "Revokes a given subscription.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. Resource name of the subscription to revoke. e.g. projects/123/locations/US/subscriptions/456
RevokeSubscriptionRequest:
object"
  [name RevokeSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+name}:revoke",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body RevokeSubscriptionRequest}))

(defn projects-locations-subscriptions-delete
  "Deletes a subscription.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

name <string> Required. Resource name of the subscription to delete. e.g. projects/123/locations/US/subscriptions/456"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://analyticshub.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-subscriptions-getIamPolicy
  "Gets the IAM policy.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://analyticshub.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-subscriptions-setIamPolicy
  "Sets the IAM policy.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

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
     "https://analyticshub.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn organizations-locations-dataExchanges-list
  "Lists all data exchanges from projects in a given organization and location.
https://cloud.google.com/bigquery/docs/analytics-hub-introduction

organization <string> Required. The organization resource path of the projects containing DataExchanges. e.g. `organizations/myorg/locations/US`.

optional:
pageSize <integer> The maximum number of results to return in a single response page. Leverage the page tokens to iterate through the entire collection."
  ([organization]
    (organizations-locations-dataExchanges-list organization nil))
  ([organization optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://analyticshub.googleapis.com/v1/{+organization}/dataExchanges",
       :uri-template-args {:organization organization},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

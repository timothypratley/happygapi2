(ns happygapi2.billingbudgets
  "Cloud Billing Budget API
The Cloud Billing Budget API stores Cloud Billing budgets, which define a budget plan and the rules to execute as spend is tracked against that plan.
See: https://cloud.google.com/billing/docs/how-to/budget-api-overview"
  (:require [happy.oauth2.client :as client]))

(defn billingAccounts-budgets-patch
  "Updates a budget and returns the updated budget. WARNING: There are some fields exposed on the Google Cloud Console that aren't available on this API. Budget fields that are not exposed in this API will not be changed by this method.
https://cloud.google.com/billing/docs/how-to/budget-api-overview

name <string> Output only. Resource name of the budget. The resource name implies the scope of a budget. Values are of the form `billingAccounts/{billingAccountId}/budgets/{budgetId}`.
GoogleCloudBillingBudgetsV1Budget:
{:etag string,
 :ownershipScope
 [OWNERSHIP_SCOPE_UNSPECIFIED ALL_USERS BILLING_ACCOUNT],
 :amount
 {:specifiedAmount
  {:currencyCode string, :nanos integer, :units string},
  :lastPeriodAmount object},
 :budgetFilter
 {:projects [string],
  :labels object,
  :calendarPeriod [CALENDAR_PERIOD_UNSPECIFIED MONTH QUARTER YEAR],
  :subaccounts [string],
  :resourceAncestors [string],
  :creditTypes [string],
  :customPeriod
  {:startDate {:month integer, :year integer, :day integer},
   :endDate {:month integer, :year integer, :day integer}},
  :services [string],
  :creditTypesTreatment
  [CREDIT_TYPES_TREATMENT_UNSPECIFIED
   INCLUDE_ALL_CREDITS
   EXCLUDE_ALL_CREDITS
   INCLUDE_SPECIFIED_CREDITS]},
 :thresholdRules
 [{:thresholdPercent number,
   :spendBasis [BASIS_UNSPECIFIED CURRENT_SPEND FORECASTED_SPEND]}],
 :name string,
 :displayName string,
 :notificationsRule
 {:schemaVersion string,
  :monitoringNotificationChannels [string],
  :disableDefaultIamRecipients boolean,
  :pubsubTopic string,
  :enableProjectLevelRecipients boolean}}

optional:
updateMask <string> Optional. Indicates which fields in the provided budget to update. Read-only fields (such as `name`) cannot be changed. If this is not provided, then only fields with non-default values from the request are updated. See https://developers.google.com/protocol-buffers/docs/proto3#default for more details about default values."
  ([name GoogleCloudBillingBudgetsV1Budget]
    (billingAccounts-budgets-patch
      name
      GoogleCloudBillingBudgetsV1Budget
      nil))
  ([name GoogleCloudBillingBudgetsV1Budget optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://billingbudgets.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudBillingBudgetsV1Budget})))

(defn billingAccounts-budgets-list
  "Returns a list of budgets for a billing account. WARNING: There are some fields exposed on the Google Cloud Console that aren't available on this API. When reading from the API, you will not see these fields in the return value, though they may have been set in the Cloud Console.
https://cloud.google.com/billing/docs/how-to/budget-api-overview

parent <string> Required. Name of billing account to list budgets under. Values are of the form `billingAccounts/{billingAccountId}`.

optional:
pageSize <integer> Optional. The maximum number of budgets to return per page. The default and maximum value are 100.
scope <string> Optional. Set the scope of the budgets to be returned, in the format of the resource name. The scope of a budget is the cost that it tracks, such as costs for a single project, or the costs for all projects in a folder. Only project scope (in the format of \"projects/project-id\" or \"projects/123\") is supported in this field. When this field is set to a project's resource name, the budgets returned are tracking the costs for that project."
  ([parent] (billingAccounts-budgets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://billingbudgets.googleapis.com/v1/{+parent}/budgets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn billingAccounts-budgets-get
  "Returns a budget. WARNING: There are some fields exposed on the Google Cloud Console that aren't available on this API. When reading from the API, you will not see these fields in the return value, though they may have been set in the Cloud Console.
https://cloud.google.com/billing/docs/how-to/budget-api-overview

name <string> Required. Name of budget to get. Values are of the form `billingAccounts/{billingAccountId}/budgets/{budgetId}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://billingbudgets.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn billingAccounts-budgets-delete
  "Deletes a budget. Returns successfully if already deleted.
https://cloud.google.com/billing/docs/how-to/budget-api-overview

name <string> Required. Name of the budget to delete. Values are of the form `billingAccounts/{billingAccountId}/budgets/{budgetId}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://billingbudgets.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn billingAccounts-budgets-create
  "Creates a new budget. See [Quotas and limits](https://cloud.google.com/billing/quotas) for more information on the limits of the number of budgets you can create.
https://cloud.google.com/billing/docs/how-to/budget-api-overview

parent <string> Required. The name of the billing account to create the budget in. Values are of the form `billingAccounts/{billingAccountId}`.
GoogleCloudBillingBudgetsV1Budget:
{:etag string,
 :ownershipScope
 [OWNERSHIP_SCOPE_UNSPECIFIED ALL_USERS BILLING_ACCOUNT],
 :amount
 {:specifiedAmount
  {:currencyCode string, :nanos integer, :units string},
  :lastPeriodAmount object},
 :budgetFilter
 {:projects [string],
  :labels object,
  :calendarPeriod [CALENDAR_PERIOD_UNSPECIFIED MONTH QUARTER YEAR],
  :subaccounts [string],
  :resourceAncestors [string],
  :creditTypes [string],
  :customPeriod
  {:startDate {:month integer, :year integer, :day integer},
   :endDate {:month integer, :year integer, :day integer}},
  :services [string],
  :creditTypesTreatment
  [CREDIT_TYPES_TREATMENT_UNSPECIFIED
   INCLUDE_ALL_CREDITS
   EXCLUDE_ALL_CREDITS
   INCLUDE_SPECIFIED_CREDITS]},
 :thresholdRules
 [{:thresholdPercent number,
   :spendBasis [BASIS_UNSPECIFIED CURRENT_SPEND FORECASTED_SPEND]}],
 :name string,
 :displayName string,
 :notificationsRule
 {:schemaVersion string,
  :monitoringNotificationChannels [string],
  :disableDefaultIamRecipients boolean,
  :pubsubTopic string,
  :enableProjectLevelRecipients boolean}}"
  [parent GoogleCloudBillingBudgetsV1Budget]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://billingbudgets.googleapis.com/v1/{+parent}/budgets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudBillingBudgetsV1Budget}))

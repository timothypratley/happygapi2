(ns happygapi2.cloudbilling
  "Cloud Billing API
Allows developers to manage billing for their Google Cloud Platform projects programmatically.
See: https://cloud.google.com/billing/docs/apis"
  (:require [happy.oauth2.client :as client]))

(defn billingAccounts-get
  "Gets information about a billing account. The current authenticated user must be a [viewer of the billing account](https://cloud.google.com/billing/docs/how-to/billing-access).
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/get

name <string> Required. The resource name of the billing account to retrieve. For example, `billingAccounts/012345-567890-ABCDEF`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudbilling.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-billing.readonly"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn billingAccounts-list
  "Lists the billing accounts that the current authenticated user has permission to [view](https://cloud.google.com/billing/docs/how-to/billing-access).
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/list

optional:
pageSize <integer> Requested page size. The maximum page size is 100; this is also the default.
filter <string> Options for how to filter the returned billing accounts. This only supports filtering for [subaccounts](https://cloud.google.com/billing/docs/concepts) under a single provided parent billing account. (for example, `master_billing_account=billingAccounts/012345-678901-ABCDEF`). Boolean algebra and other fields are not currently supported.
parent <string> Optional. The parent resource to list billing accounts from. Format: - `organizations/{organization_id}`, for example, `organizations/12345678` - `billingAccounts/{billing_account_id}`, for example, `billingAccounts/012345-567890-ABCDEF`"
  ([] (billingAccounts-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbilling.googleapis.com/v1/billingAccounts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-billing.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn billingAccounts-patch
  "Updates a billing account's fields. Currently the only field that can be edited is `display_name`. The current authenticated user must have the `billing.accounts.update` IAM permission, which is typically given to the [administrator](https://cloud.google.com/billing/docs/how-to/billing-access) of the billing account.
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/patch

name <string> Required. The name of the billing account resource to be updated.
BillingAccount:
{:name string,
 :open boolean,
 :displayName string,
 :masterBillingAccount string,
 :parent string}

optional:
updateMask <string> The update mask applied to the resource. Only \"display_name\" is currently supported."
  ([name BillingAccount]
    (billingAccounts-patch name BillingAccount nil))
  ([name BillingAccount optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudbilling.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body BillingAccount})))

(defn billingAccounts-create
  "This method creates [billing subaccounts](https://cloud.google.com/billing/docs/concepts#subaccounts). Google Cloud resellers should use the Channel Services APIs, [accounts.customers.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers/create) and [accounts.customers.entitlements.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers.entitlements/create). When creating a subaccount, the current authenticated user must have the `billing.accounts.update` IAM permission on the parent account, which is typically given to billing account [administrators](https://cloud.google.com/billing/docs/how-to/billing-access). This method will return an error if the parent account has not been provisioned for subaccounts.
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/create

BillingAccount:
{:name string,
 :open boolean,
 :displayName string,
 :masterBillingAccount string,
 :parent string}

optional:
parent <string> Optional. The parent to create a billing account from. Format: - `billingAccounts/{billing_account_id}`, for example, `billingAccounts/012345-567890-ABCDEF`"
  ([BillingAccount] (billingAccounts-create BillingAccount nil))
  ([BillingAccount optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudbilling.googleapis.com/v1/billingAccounts",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body BillingAccount})))

(defn billingAccounts-getIamPolicy
  "Gets the access control policy for a billing account. The caller must have the `billing.accounts.getIamPolicy` permission on the account, which is often given to billing account [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (billingAccounts-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbilling.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-billing.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn billingAccounts-setIamPolicy
  "Sets the access control policy for a billing account. Replaces any existing policy. The caller must have the `billing.accounts.setIamPolicy` permission on the account, which is often given to billing account [administrators](https://cloud.google.com/billing/docs/how-to/billing-access).
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/setIamPolicy

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
     "https://cloudbilling.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn billingAccounts-testIamPermissions
  "Tests the access control policy for a billing account. This method takes the resource and a set of permissions as input and returns the subset of the input permissions that the caller is allowed for that resource.
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbilling.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-billing.readonly"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn billingAccounts-move
  "Changes which parent organization a billing account belongs to.
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts/move

name <string> Required. The resource name of the billing account to move. Must be of the form `billingAccounts/{billing_account_id}`. The specified billing account cannot be a subaccount, since a subaccount always belongs to the same organization as its parent account.
MoveBillingAccountRequest:
{:destinationParent string}"
  [name MoveBillingAccountRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbilling.googleapis.com/v1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body MoveBillingAccountRequest}))

(defn billingAccounts-subAccounts-list
  "Lists the billing accounts that the current authenticated user has permission to [view](https://cloud.google.com/billing/docs/how-to/billing-access).
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts.subAccounts/list

parent <string> Optional. The parent resource to list billing accounts from. Format: - `organizations/{organization_id}`, for example, `organizations/12345678` - `billingAccounts/{billing_account_id}`, for example, `billingAccounts/012345-567890-ABCDEF`

optional:
pageSize <integer> Requested page size. The maximum page size is 100; this is also the default.
filter <string> Options for how to filter the returned billing accounts. This only supports filtering for [subaccounts](https://cloud.google.com/billing/docs/concepts) under a single provided parent billing account. (for example, `master_billing_account=billingAccounts/012345-678901-ABCDEF`). Boolean algebra and other fields are not currently supported."
  ([parent] (billingAccounts-subAccounts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbilling.googleapis.com/v1/{+parent}/subAccounts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-billing.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn billingAccounts-subAccounts-create
  "This method creates [billing subaccounts](https://cloud.google.com/billing/docs/concepts#subaccounts). Google Cloud resellers should use the Channel Services APIs, [accounts.customers.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers/create) and [accounts.customers.entitlements.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers.entitlements/create). When creating a subaccount, the current authenticated user must have the `billing.accounts.update` IAM permission on the parent account, which is typically given to billing account [administrators](https://cloud.google.com/billing/docs/how-to/billing-access). This method will return an error if the parent account has not been provisioned for subaccounts.
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts.subAccounts/create

parent <string> Optional. The parent to create a billing account from. Format: - `billingAccounts/{billing_account_id}`, for example, `billingAccounts/012345-567890-ABCDEF`
BillingAccount:
{:name string,
 :open boolean,
 :displayName string,
 :masterBillingAccount string,
 :parent string}"
  [parent BillingAccount]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbilling.googleapis.com/v1/{+parent}/subAccounts",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body BillingAccount}))

(defn billingAccounts-projects-list
  "Lists the projects associated with a billing account. The current authenticated user must have the `billing.resourceAssociations.list` IAM permission, which is often given to billing account [viewers](https://cloud.google.com/billing/docs/how-to/billing-access).
https://cloud.google.com/billing/docs/reference/rest/v1/billingAccounts.projects/list

name <string> Required. The resource name of the billing account associated with the projects that you want to list. For example, `billingAccounts/012345-567890-ABCDEF`.

optional:
pageSize <integer> Requested page size. The maximum page size is 100; this is also the default."
  ([name] (billingAccounts-projects-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbilling.googleapis.com/v1/{+name}/projects",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-billing.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-billingAccounts-list
  "Lists the billing accounts that the current authenticated user has permission to [view](https://cloud.google.com/billing/docs/how-to/billing-access).
https://cloud.google.com/billing/docs/reference/rest/v1/organizations.billingAccounts/list

parent <string> Optional. The parent resource to list billing accounts from. Format: - `organizations/{organization_id}`, for example, `organizations/12345678` - `billingAccounts/{billing_account_id}`, for example, `billingAccounts/012345-567890-ABCDEF`

optional:
pageSize <integer> Requested page size. The maximum page size is 100; this is also the default.
filter <string> Options for how to filter the returned billing accounts. This only supports filtering for [subaccounts](https://cloud.google.com/billing/docs/concepts) under a single provided parent billing account. (for example, `master_billing_account=billingAccounts/012345-678901-ABCDEF`). Boolean algebra and other fields are not currently supported."
  ([parent] (organizations-billingAccounts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbilling.googleapis.com/v1/{+parent}/billingAccounts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-billing.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-billingAccounts-create
  "This method creates [billing subaccounts](https://cloud.google.com/billing/docs/concepts#subaccounts). Google Cloud resellers should use the Channel Services APIs, [accounts.customers.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers/create) and [accounts.customers.entitlements.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers.entitlements/create). When creating a subaccount, the current authenticated user must have the `billing.accounts.update` IAM permission on the parent account, which is typically given to billing account [administrators](https://cloud.google.com/billing/docs/how-to/billing-access). This method will return an error if the parent account has not been provisioned for subaccounts.
https://cloud.google.com/billing/docs/reference/rest/v1/organizations.billingAccounts/create

parent <string> Optional. The parent to create a billing account from. Format: - `billingAccounts/{billing_account_id}`, for example, `billingAccounts/012345-567890-ABCDEF`
BillingAccount:
{:name string,
 :open boolean,
 :displayName string,
 :masterBillingAccount string,
 :parent string}"
  [parent BillingAccount]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudbilling.googleapis.com/v1/{+parent}/billingAccounts",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body BillingAccount}))

(defn organizations-billingAccounts-move
  "Changes which parent organization a billing account belongs to.
https://cloud.google.com/billing/docs/reference/rest/v1/organizations.billingAccounts/move

destinationParent <string> Required. The resource name of the Organization to move the billing account under. Must be of the form `organizations/{organization_id}`.
name <string> Required. The resource name of the billing account to move. Must be of the form `billingAccounts/{billing_account_id}`. The specified billing account cannot be a subaccount, since a subaccount always belongs to the same organization as its parent account."
  [destinationParent name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudbilling.googleapis.com/v1/{+destinationParent}/{+name}:move",
     :uri-template-args
     {:destinationParent destinationParent, :name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-getBillingInfo
  "Gets the billing information for a project. The current authenticated user must have the `resourcemanager.projects.get` permission for the project, which can be granted by assigning the [Project Viewer](https://cloud.google.com/iam/docs/understanding-roles#predefined_roles) role.
https://cloud.google.com/billing/docs/reference/rest/v1/projects/getBillingInfo

name <string> Required. The resource name of the project for which billing information is retrieved. For example, `projects/tokyo-rain-123`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudbilling.googleapis.com/v1/{+name}/billingInfo",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-billing.readonly"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-updateBillingInfo
  "Sets or updates the billing account associated with a project. You specify the new billing account by setting the `billing_account_name` in the `ProjectBillingInfo` resource to the resource name of a billing account. Associating a project with an open billing account enables billing on the project and allows charges for resource usage. If the project already had a billing account, this method changes the billing account used for resource usage charges. *Note:* Incurred charges that have not yet been reported in the transaction history of the Google Cloud Console might be billed to the new billing account, even if the charge occurred before the new billing account was assigned to the project. The current authenticated user must have ownership privileges for both the [project](https://cloud.google.com/docs/permissions-overview#h.bgs0oxofvnoo ) and the [billing account](https://cloud.google.com/billing/docs/how-to/billing-access). You can disable billing on the project by setting the `billing_account_name` field to empty. This action disassociates the current billing account from the project. Any billable activity of your in-use services will stop, and your application could stop functioning as expected. Any unbilled charges to date will be billed to the previously associated account. The current authenticated user must be either an owner of the project or an owner of the billing account for the project. Note that associating a project with a *closed* billing account will have much the same effect as disabling billing on the project: any paid resources used by the project will be shut down. Thus, unless you wish to disable billing, you should always call this method with the name of an *open* billing account.
https://cloud.google.com/billing/docs/reference/rest/v1/projects/updateBillingInfo

name <string> Required. The resource name of the project associated with the billing information that you want to update. For example, `projects/tokyo-rain-123`.
ProjectBillingInfo:
{:name string,
 :projectId string,
 :billingAccountName string,
 :billingEnabled boolean}"
  [name ProjectBillingInfo]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://cloudbilling.googleapis.com/v1/{+name}/billingInfo",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-billing"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body ProjectBillingInfo}))

(defn services-list
  "Lists all public cloud services.
https://cloud.google.com/billing/docs/reference/rest/v1/services/list

optional:
pageSize <integer> Requested page size. Defaults to 5000."
  ([] (services-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://cloudbilling.googleapis.com/v1/services",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-billing.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn services-skus-list
  "Lists all publicly available SKUs for a given cloud service.
https://cloud.google.com/billing/docs/reference/rest/v1/services.skus/list

parent <string> Required. The name of the service. Example: \"services/6F81-5844-456A\"

optional:
startTime <string> Optional inclusive start time of the time range for which the pricing versions will be returned. Timestamps in the future are not allowed. The time range has to be within a single calendar month in America/Los_Angeles timezone. Time range as a whole is optional. If not specified, the latest pricing will be returned (up to 12 hours old at most).
endTime <string> Optional exclusive end time of the time range for which the pricing versions will be returned. Timestamps in the future are not allowed. The time range has to be within a single calendar month in America/Los_Angeles timezone. Time range as a whole is optional. If not specified, the latest pricing will be returned (up to 12 hours old at most).
currencyCode <string> The ISO 4217 currency code for the pricing info in the response proto. Will use the conversion rate as of start_time. Optional. If not specified USD will be used.
pageSize <integer> Requested page size. Defaults to 5000."
  ([parent] (services-skus-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudbilling.googleapis.com/v1/{+parent}/skus",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-billing"
        "https://www.googleapis.com/auth/cloud-billing.readonly"
        "https://www.googleapis.com/auth/cloud-platform"]})))

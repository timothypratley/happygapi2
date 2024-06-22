(ns happygapi2.reseller
  "Google Workspace Reseller API
Perform common functions that are available on the Channel Services console at scale, like placing orders and viewing customer information
See: https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts"
  (:require [happy.oauth2.client :as client]))

(defn customers-get
  "Gets a customer account. Use this operation to see a customer account already in your reseller management, or to see the minimal account information for an existing customer that you do not manage. For more information about the API response for existing customers, see [retrieving a customer account](/admin-sdk/reseller/v1/how-tos/manage_customers#get_customer).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable."
  [customerId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}",
     :uri-template-args {:customerId customerId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/apps.order"
      "https://www.googleapis.com/auth/apps.order.readonly"]}))

(defn customers-insert
  "Orders a new customer's account. Before ordering a new customer account, establish whether the customer account already exists using the [`customers.get`](/admin-sdk/reseller/v1/reference/customers/get) If the customer account exists as a direct Google account or as a resold customer account from another reseller, use the `customerAuthToken\\` as described in [order a resold account for an existing customer](/admin-sdk/reseller/v1/how-tos/manage_customers#create_existing_customer). For more information about ordering a new customer account, see [order a new customer account](/admin-sdk/reseller/v1/how-tos/manage_customers#create_customer). After creating a new customer account, you must provision a user as an administrator. The customer's administrator is required to sign in to the Admin console and sign the G Suite via Reseller agreement to activate the account. Resellers are prohibited from signing the G Suite via Reseller agreement on the customer's behalf. For more information, see [order a new customer account](/admin-sdk/reseller/v1/how-tos/manage_customers#tos).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

Customer:
{:alternateEmail string,
 :postalAddress
 {:locality string,
  :contactName string,
  :addressLine1 string,
  :organizationName string,
  :region string,
  :addressLine3 string,
  :addressLine2 string,
  :kind string,
  :postalCode string,
  :countryCode string},
 :resourceUiUrl string,
 :customerType [customerTypeUnspecified domain team],
 :customerId string,
 :primaryAdmin {:primaryEmail string},
 :customerDomain string,
 :kind string,
 :customerDomainVerified boolean,
 :phoneNumber string}

optional:
customerAuthToken <string> The `customerAuthToken` query string is required when creating a resold account that transfers a direct customer's subscription or transfers another reseller customer's subscription to your reseller management. This is a hexadecimal authentication token needed to complete the subscription transfer. For more information, see the administrator help center."
  ([Customer] (customers-insert Customer nil))
  ([Customer optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://reseller.googleapis.com/apps/reseller/v1/customers",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/apps.order"],
       :body Customer})))

(defn customers-update
  "Updates a customer account's settings. You cannot update `customerType` via the Reseller API, but a `\"team\"` customer can verify their domain and become `customerType = \"domain\"`. For more information, see [update a customer's settings](/admin-sdk/reseller/v1/how-tos/manage_customers#update_customer).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
Customer:
{:alternateEmail string,
 :postalAddress
 {:locality string,
  :contactName string,
  :addressLine1 string,
  :organizationName string,
  :region string,
  :addressLine3 string,
  :addressLine2 string,
  :kind string,
  :postalCode string,
  :countryCode string},
 :resourceUiUrl string,
 :customerType [customerTypeUnspecified domain team],
 :customerId string,
 :primaryAdmin {:primaryEmail string},
 :customerDomain string,
 :kind string,
 :customerDomainVerified boolean,
 :phoneNumber string}"
  [customerId Customer]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}",
     :uri-template-args {:customerId customerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"],
     :body Customer}))

(defn customers-patch
  "Updates a customer account's settings. This method supports patch semantics. You cannot update `customerType` via the Reseller API, but a `\"team\"` customer can verify their domain and become `customerType = \"domain\"`. For more information, see [Verify your domain to unlock Essentials features](https://support.google.com/a/answer/9122284).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
Customer:
{:alternateEmail string,
 :postalAddress
 {:locality string,
  :contactName string,
  :addressLine1 string,
  :organizationName string,
  :region string,
  :addressLine3 string,
  :addressLine2 string,
  :kind string,
  :postalCode string,
  :countryCode string},
 :resourceUiUrl string,
 :customerType [customerTypeUnspecified domain team],
 :customerId string,
 :primaryAdmin {:primaryEmail string},
 :customerDomain string,
 :kind string,
 :customerDomainVerified boolean,
 :phoneNumber string}"
  [customerId Customer]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}",
     :uri-template-args {:customerId customerId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"],
     :body Customer}))

(defn resellernotify-getwatchdetails
  "Returns all the details of the watch corresponding to the reseller.
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/resellernotify/getwatchdetails",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/apps.order"
      "https://www.googleapis.com/auth/apps.order.readonly"]}))

(defn resellernotify-register
  "Registers a Reseller for receiving notifications.
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

optional:
serviceAccountEmailAddress <string> The service account which will own the created Cloud-PubSub topic."
  ([] (resellernotify-register nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://reseller.googleapis.com/apps/reseller/v1/resellernotify/register",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/apps.order"]})))

(defn resellernotify-unregister
  "Unregisters a Reseller for receiving notifications.
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

optional:
serviceAccountEmailAddress <string> The service account which owns the Cloud-PubSub topic."
  ([] (resellernotify-unregister nil))
  ([optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://reseller.googleapis.com/apps/reseller/v1/resellernotify/unregister",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/apps.order"]})))

(defn subscriptions-get
  "Gets a specific subscription. The `subscriptionId` can be found using the [Retrieve all reseller subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#get_all_subscriptions) method. For more information about retrieving a specific subscription, see the information descrived in [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#get_subscription).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method."
  [customerId subscriptionId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/apps.order"
      "https://www.googleapis.com/auth/apps.order.readonly"]}))

(defn subscriptions-insert
  "Creates or transfer a subscription. Create a subscription for a customer's account that you ordered using the [Order a new customer account](/admin-sdk/reseller/v1/reference/customers/insert.html) method. For more information about creating a subscription for different payment plans, see [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#create_subscription).\\ If you did not order the customer's account using the customer insert method, use the customer's `customerAuthToken` when creating a subscription for that customer. If transferring a G Suite subscription with an associated Google Drive or Google Vault subscription, use the [batch operation](/admin-sdk/reseller/v1/how-tos/batch.html) to transfer all of these subscriptions. For more information, see how to [transfer subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#transfer_a_subscription).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
Subscription:
{:skuName string,
 :creationTime string,
 :purchaseOrderId string,
 :billingMethod string,
 :trialSettings {:isInTrial boolean, :trialEndTime string},
 :suspensionReasons [string],
 :resourceUiUrl string,
 :customerId string,
 :transferInfo
 {:transferabilityExpirationTime string,
  :minimumTransferableSeats integer,
  :currentLegacySkuId string},
 :customerDomain string,
 :status string,
 :kind string,
 :skuId string,
 :seats
 {:numberOfSeats integer,
  :maximumNumberOfSeats integer,
  :licensedNumberOfSeats integer,
  :kind string},
 :plan
 {:planName string,
  :isCommitmentPlan boolean,
  :commitmentInterval {:startTime string, :endTime string}},
 :renewalSettings {:renewalType string, :kind string},
 :dealCode string,
 :subscriptionId string}

optional:
customerAuthToken <string> The `customerAuthToken` query string is required when creating a resold account that transfers a direct customer's subscription or transfers another reseller customer's subscription to your reseller management. This is a hexadecimal authentication token needed to complete the subscription transfer. For more information, see the administrator help center.
action <string> The intented insert action. The usage of this field is governed by certain policies which are being developed & tested currently. Hence, these might not work as intended. Once this is fully tested & available to consume, we will share more information about its usage, limitations and policy documentation.
sourceSkuId <string> The sku_id of the existing subscription to be upgraded or downgraded. This is required when action is SWITCH. The usage of this field is governed by certain policies which are being developed & tested currently. Hence, these might not work as intended. Once this is fully tested & available to consume, we will share more information about its usage, limitations and policy documentation."
  ([customerId Subscription]
    (subscriptions-insert customerId Subscription nil))
  ([customerId Subscription optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions",
       :uri-template-args {:customerId customerId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/apps.order"],
       :body Subscription})))

(defn subscriptions-changeRenewalSettings
  "Updates a user license's renewal settings. This is applicable for accounts with annual commitment plans only. For more information, see the description in [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#update_renewal).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method.
RenewalSettings:
{:renewalType string, :kind string}"
  [customerId subscriptionId RenewalSettings]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/changeRenewalSettings",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"],
     :body RenewalSettings}))

(defn subscriptions-delete
  "Cancels, suspends, or transfers a subscription to direct.
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method.
deletionType <string> The `deletionType` query string enables the cancellation, downgrade, or suspension of a subscription."
  [customerId subscriptionId deletionType]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {:deletionType deletionType},
     :scopes ["https://www.googleapis.com/auth/apps.order"]}))

(defn subscriptions-suspend
  "Suspends an active subscription. You can use this method to suspend a paid subscription that is currently in the `ACTIVE` state. * For `FLEXIBLE` subscriptions, billing is paused. * For `ANNUAL_MONTHLY_PAY` or `ANNUAL_YEARLY_PAY` subscriptions: * Suspending the subscription does not change the renewal date that was originally committed to. * A suspended subscription does not renew. If you activate the subscription after the original renewal date, a new annual subscription will be created, starting on the day of activation. We strongly encourage you to suspend subscriptions only for short periods of time as suspensions over 60 days may result in the subscription being cancelled.
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method."
  [customerId subscriptionId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/suspend",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"]}))

(defn subscriptions-list
  "Lists of subscriptions managed by the reseller. The list can be all subscriptions, all of a customer's subscriptions, or all of a customer's transferable subscriptions. Optionally, this method can filter the response by a `customerNamePrefix`. For more information, see [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

optional:
customerAuthToken <string> The `customerAuthToken` query string is required when creating a resold account that transfers a direct customer's subscription or transfers another reseller customer's subscription to your reseller management. This is a hexadecimal authentication token needed to complete the subscription transfer. For more information, see the administrator help center.
customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
customerNamePrefix <string> When retrieving all of your subscriptions and filtering for specific customers, you can enter a prefix for a customer name. Using an example customer group that includes `exam.com`, `example20.com` and `example.com`: - `exa` -- Returns all customer names that start with 'exa' which could include `exam.com`, `example20.com`, and `example.com`. A name prefix is similar to using a regular expression's asterisk, exa*. - `example` -- Returns `example20.com` and `example.com`. 
maxResults <integer> When retrieving a large list, the `maxResults` is the maximum number of results per page. The `nextPageToken` value takes you to the next page. The default is 20."
  ([] (subscriptions-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://reseller.googleapis.com/apps/reseller/v1/subscriptions",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/apps.order"
        "https://www.googleapis.com/auth/apps.order.readonly"]})))

(defn subscriptions-changePlan
  "Updates a subscription plan. Use this method to update a plan for a 30-day trial or a flexible plan subscription to an annual commitment plan with monthly or yearly payments. How a plan is updated differs depending on the plan and the products. For more information, see the description in [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#update_subscription_plan).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method.
ChangePlanRequest:
{:kind string,
 :planName string,
 :seats
 {:numberOfSeats integer,
  :maximumNumberOfSeats integer,
  :licensedNumberOfSeats integer,
  :kind string},
 :purchaseOrderId string,
 :dealCode string}"
  [customerId subscriptionId ChangePlanRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/changePlan",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"],
     :body ChangePlanRequest}))

(defn subscriptions-changeSeats
  "Updates a subscription's user license settings. For more information about updating an annual commitment plan or a flexible plan subscription’s licenses, see [Manage Subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#update_subscription_seat).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method.
Seats:
{:numberOfSeats integer,
 :maximumNumberOfSeats integer,
 :licensedNumberOfSeats integer,
 :kind string}"
  [customerId subscriptionId Seats]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/changeSeats",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"],
     :body Seats}))

(defn subscriptions-activate
  "Activates a subscription previously suspended by the reseller. If you did not suspend the customer subscription and it is suspended for any other reason, such as for abuse or a pending ToS acceptance, this call will not reactivate the customer subscription.
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method."
  [customerId subscriptionId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/activate",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"]}))

(defn subscriptions-startPaidService
  "Immediately move a 30-day free trial subscription to a paid service subscription. This method is only applicable if a payment plan has already been set up for the 30-day trial subscription. For more information, see [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#paid_service).
https://developers.google.com/admin-sdk/reseller/v1/how-tos/concepts

customerId <string> This can be either the customer's primary domain name or the customer's unique identifier. If the domain name for a customer changes, the old domain name cannot be used to access the customer, but the customer's unique identifier (as returned by the API) can always be used. We recommend storing the unique identifier in your systems where applicable.
subscriptionId <string> This is a required property. The `subscriptionId` is the subscription identifier and is unique for each customer. Since a `subscriptionId` changes when a subscription is updated, we recommend to not use this ID as a key for persistent data. And the `subscriptionId` can be found using the retrieve all reseller subscriptions method."
  [customerId subscriptionId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://reseller.googleapis.com/apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/startPaidService",
     :uri-template-args
     {:customerId customerId, :subscriptionId subscriptionId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/apps.order"]}))

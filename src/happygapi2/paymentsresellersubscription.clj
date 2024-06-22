(ns happygapi2.paymentsresellersubscription
  "Payments Reseller Subscription API

See: https://developers.google.com/payments/reseller/subscription/"
  (:require [happy.oauth2.client :as client]))

(defn partners-products-list
  "To retrieve the products that can be resold by the partner. It should be autenticated with a service account. - This API doesn't apply to YouTube products currently.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.products/list

parent <string> Required. The parent, the partner that can resell. Format: partners/{partner}

optional:
filter <string> Optional. Specifies the filters for the product results. The syntax is defined in https://google.aip.dev/160 with the following caveats: 1. Only the following features are supported: - Logical operator `AND` - Comparison operator `=` (no wildcards `*`) - Traversal operator `.` - Has operator `:` (no wildcards `*`) 2. Only the following fields are supported: - `regionCodes` - `youtubePayload.partnerEligibilityId` - `youtubePayload.postalCode` 3. Unless explicitly mentioned above, other features are not supported. Example: `regionCodes:US AND youtubePayload.postalCode=94043 AND youtubePayload.partnerEligibilityId=eligibility-id`
pageSize <integer> Optional. The maximum number of products to return. The service may return fewer than this value. If unspecified, at most 50 products will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (partners-products-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://paymentsresellersubscription.googleapis.com/v1/{+parent}/products",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["openid"]})))

(defn partners-promotions-findEligible
  "To find eligible promotions for the current user. The API requires user authorization via OAuth. The bare minimum oauth scope `openid` is sufficient, which will skip the consent screen.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.promotions/findEligible

parent <string> Required. The parent, the partner that can resell. Format: partners/{partner}
GoogleCloudPaymentsResellerSubscriptionV1FindEligiblePromotionsRequest:
{:pageToken string, :filter string, :pageSize integer}"
  [parent
   GoogleCloudPaymentsResellerSubscriptionV1FindEligiblePromotionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://paymentsresellersubscription.googleapis.com/v1/{+parent}/promotions:findEligible",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["openid"],
     :body
     GoogleCloudPaymentsResellerSubscriptionV1FindEligiblePromotionsRequest}))

(defn partners-promotions-list
  "Retrieves the promotions, such as free trial, that can be used by the partner. - This API doesn't apply to YouTube promotions currently. It should be autenticated with a service account.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.promotions/list

parent <string> Required. The parent, the partner that can resell. Format: partners/{partner}

optional:
filter <string> Optional. Specifies the filters for the promotion results. The syntax is defined in https://google.aip.dev/160 with the following caveats: 1. Only the following features are supported: - Logical operator `AND` - Comparison operator `=` (no wildcards `*`) - Traversal operator `.` - Has operator `:` (no wildcards `*`) 2. Only the following fields are supported: - `applicableProducts` - `regionCodes` - `youtubePayload.partnerEligibilityId` - `youtubePayload.postalCode` 3. Unless explicitly mentioned above, other features are not supported. Example: `applicableProducts:partners/partner1/products/product1 AND regionCodes:US AND youtubePayload.postalCode=94043 AND youtubePayload.partnerEligibilityId=eligibility-id`
pageSize <integer> Optional. The maximum number of promotions to return. The service may return fewer than this value. If unspecified, at most 50 products will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (partners-promotions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://paymentsresellersubscription.googleapis.com/v1/{+parent}/promotions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["openid"]})))

(defn partners-subscriptions-entitle
  "Used by partners to entitle a previously provisioned subscription to the current end user. The end user identity is inferred from the authorized credential of the request. This API must be authorized by the end user using OAuth.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.subscriptions/entitle

name <string> Required. The name of the subscription resource that is entitled to the current end user. It will have the format of \"partners/{partner_id}/subscriptions/{subscription_id}\"
GoogleCloudPaymentsResellerSubscriptionV1EntitleSubscriptionRequest:
{:lineItemEntitlementDetails
 [{:products [string], :lineItemIndex integer}]}"
  [name
   GoogleCloudPaymentsResellerSubscriptionV1EntitleSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://paymentsresellersubscription.googleapis.com/v1/{+name}:entitle",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["openid"],
     :body
     GoogleCloudPaymentsResellerSubscriptionV1EntitleSubscriptionRequest}))

(defn partners-subscriptions-cancel
  "Used by partners to cancel a subscription service either immediately or by the end of the current billing cycle for their customers. It should be called directly by the partner using service accounts.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.subscriptions/cancel

name <string> Required. The name of the subscription resource to be cancelled. It will have the format of \"partners/{partner_id}/subscriptions/{subscription_id}\"
GoogleCloudPaymentsResellerSubscriptionV1CancelSubscriptionRequest:
{:cancellationReason
 [CANCELLATION_REASON_UNSPECIFIED
  CANCELLATION_REASON_FRAUD
  CANCELLATION_REASON_REMORSE
  CANCELLATION_REASON_ACCIDENTAL_PURCHASE
  CANCELLATION_REASON_PAST_DUE
  CANCELLATION_REASON_ACCOUNT_CLOSED
  CANCELLATION_REASON_UPGRADE_DOWNGRADE
  CANCELLATION_REASON_USER_DELINQUENCY
  CANCELLATION_REASON_SYSTEM_ERROR
  CANCELLATION_REASON_SYSTEM_CANCEL
  CANCELLATION_REASON_OTHER],
 :cancelImmediately boolean}"
  [name
   GoogleCloudPaymentsResellerSubscriptionV1CancelSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://paymentsresellersubscription.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["openid"],
     :body
     GoogleCloudPaymentsResellerSubscriptionV1CancelSubscriptionRequest}))

(defn partners-subscriptions-provision
  "Used by partners to provision a subscription for their customers. This creates a subscription without associating it with the end user account. EntitleSubscription must be called separately using OAuth in order for the end user account to be associated with the subscription. It should be called directly by the partner using service accounts.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.subscriptions/provision

parent <string> Required. The parent resource name, which is the identifier of the partner. It will have the format of \"partners/{partner_id}\".
GoogleCloudPaymentsResellerSubscriptionV1Subscription:
{:promotions [string],
 :redirectUri string,
 :endUserEntitled boolean,
 :cancellationDetails
 {:reason
  [CANCELLATION_REASON_UNSPECIFIED
   CANCELLATION_REASON_FRAUD
   CANCELLATION_REASON_REMORSE
   CANCELLATION_REASON_ACCIDENTAL_PURCHASE
   CANCELLATION_REASON_PAST_DUE
   CANCELLATION_REASON_ACCOUNT_CLOSED
   CANCELLATION_REASON_UPGRADE_DOWNGRADE
   CANCELLATION_REASON_USER_DELINQUENCY
   CANCELLATION_REASON_SYSTEM_ERROR
   CANCELLATION_REASON_SYSTEM_CANCEL
   CANCELLATION_REASON_OTHER]},
 :freeTrialEndTime string,
 :cycleEndTime string,
 :products [string],
 :name string,
 :upgradeDowngradeDetails
 {:billingCycleSpec
  [BILLING_CYCLE_SPEC_UNSPECIFIED
   BILLING_CYCLE_SPEC_ALIGN_WITH_PREVIOUS_SUBSCRIPTION
   BILLING_CYCLE_SPEC_START_IMMEDIATELY],
  :previousSubscriptionId string},
 :purchaseTime string,
 :createTime string,
 :processingState
 [PROCESSING_STATE_UNSPECIFIED
  PROCESSING_STATE_CANCELLING
  PROCESSING_STATE_RECURRING],
 :state
 [STATE_UNSPECIFIED
  STATE_CREATED
  STATE_ACTIVE
  STATE_CANCELLED
  STATE_IN_GRACE_PERIOD
  STATE_CANCEL_AT_END_OF_CYCLE
  STATE_SUSPENDED],
 :renewalTime string,
 :updateTime string,
 :partnerUserToken string,
 :lineItems
 [{:description string,
   :amount {:currencyCode string, :amountMicros string},
   :finiteBillingCycleDetails {:billingCycleCountLimit string},
   :lineItemIndex integer,
   :oneTimeRecurrenceDetails
   {:servicePeriod {:startTime string, :endTime string}},
   :lineItemPromotionSpecs
   [{:freeTrialDuration
     {:count integer, :unit [UNIT_UNSPECIFIED MONTH DAY HOUR]},
     :introductoryPricingDetails
     {:introductoryPricingSpecs
      [{:discountAmount
        GoogleCloudPaymentsResellerSubscriptionV1Amount,
        :recurrenceCount integer,
        :discountRatioMicros string,
        :regionCode string}]},
     :promotion string,
     :type
     [PROMOTION_TYPE_UNSPECIFIED
      PROMOTION_TYPE_FREE_TRIAL
      PROMOTION_TYPE_INTRODUCTORY_PRICING]}],
   :state
   [LINE_ITEM_STATE_UNSPECIFIED
    LINE_ITEM_STATE_ACTIVE
    LINE_ITEM_STATE_INACTIVE
    LINE_ITEM_STATE_NEW
    LINE_ITEM_STATE_ACTIVATING
    LINE_ITEM_STATE_DEACTIVATING
    LINE_ITEM_STATE_WAITING_TO_DEACTIVATE
    LINE_ITEM_STATE_OFF_CYCLE_CHARGING],
   :productPayload
   {:googleOnePayload
    {:salesChannel
     [CHANNEL_UNSPECIFIED
      CHANNEL_RETAIL
      CHANNEL_ONLINE_WEB
      CHANNEL_ONLINE_ANDROID_APP
      CHANNEL_ONLINE_IOS_APP],
     :storeId string,
     :campaigns [string],
     :offering
     [OFFERING_UNSPECIFIED
      OFFERING_VAS_BUNDLE
      OFFERING_VAS_STANDALONE
      OFFERING_HARD_BUNDLE
      OFFERING_SOFT_BUNDLE]},
    :youtubePayload
    {:partnerEligibilityIds [string],
     :partnerPlanType
     [PARTNER_PLAN_TYPE_UNSPECIFIED
      PARTNER_PLAN_TYPE_STANDALONE
      PARTNER_PLAN_TYPE_HARD_BUNDLE
      PARTNER_PLAN_TYPE_SOFT_BUNDLE],
     :accessEndTime string}},
   :product string,
   :bundleDetails
   {:bundleElementDetails
    [{:userAccountLinkedTime string, :product string}]},
   :lineItemFreeTrialEndTime string,
   :recurrenceType
   [LINE_ITEM_RECURRENCE_TYPE_UNSPECIFIED
    LINE_ITEM_RECURRENCE_TYPE_PERIODIC
    LINE_ITEM_RECURRENCE_TYPE_ONE_TIME]}],
 :promotionSpecs
 [{:freeTrialDuration
   {:count integer, :unit [UNIT_UNSPECIFIED MONTH DAY HOUR]},
   :introductoryPricingDetails
   {:introductoryPricingSpecs
    [{:discountAmount {:currencyCode string, :amountMicros string},
      :recurrenceCount integer,
      :discountRatioMicros string,
      :regionCode string}]},
   :promotion string,
   :type
   [PROMOTION_TYPE_UNSPECIFIED
    PROMOTION_TYPE_FREE_TRIAL
    PROMOTION_TYPE_INTRODUCTORY_PRICING]}],
 :serviceLocation {:postalCode string, :regionCode string}}

optional:
subscriptionId <string> Required. Identifies the subscription resource on the Partner side. The value is restricted to 63 ASCII characters at the maximum. If a subscription was previously created with the same subscription_id, we will directly return that one."
  ([parent GoogleCloudPaymentsResellerSubscriptionV1Subscription]
    (partners-subscriptions-provision
      parent
      GoogleCloudPaymentsResellerSubscriptionV1Subscription
      nil))
  ([parent
    GoogleCloudPaymentsResellerSubscriptionV1Subscription
    optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://paymentsresellersubscription.googleapis.com/v1/{+parent}/subscriptions:provision",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["openid"],
       :body GoogleCloudPaymentsResellerSubscriptionV1Subscription})))

(defn partners-subscriptions-extend
  "[Opt-in only] Most partners should be on auto-extend by default. Used by partners to extend a subscription service for their customers on an ongoing basis for the subscription to remain active and renewable. It should be called directly by the partner using service accounts.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.subscriptions/extend

name <string> Required. The name of the subscription resource to be extended. It will have the format of \"partners/{partner_id}/subscriptions/{subscription_id}\".
GoogleCloudPaymentsResellerSubscriptionV1ExtendSubscriptionRequest:
{:requestId string,
 :extension
 {:partnerUserToken string,
  :duration {:count integer, :unit [UNIT_UNSPECIFIED MONTH DAY HOUR]}}}"
  [name
   GoogleCloudPaymentsResellerSubscriptionV1ExtendSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://paymentsresellersubscription.googleapis.com/v1/{+name}:extend",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["openid"],
     :body
     GoogleCloudPaymentsResellerSubscriptionV1ExtendSubscriptionRequest}))

(defn partners-subscriptions-create
  "Used by partners to create a subscription for their customers. The created subscription is associated with the end user inferred from the end user credentials. This API must be authorized by the end user using OAuth.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.subscriptions/create

parent <string> Required. The parent resource name, which is the identifier of the partner. It will have the format of \"partners/{partner_id}\".
GoogleCloudPaymentsResellerSubscriptionV1Subscription:
{:promotions [string],
 :redirectUri string,
 :endUserEntitled boolean,
 :cancellationDetails
 {:reason
  [CANCELLATION_REASON_UNSPECIFIED
   CANCELLATION_REASON_FRAUD
   CANCELLATION_REASON_REMORSE
   CANCELLATION_REASON_ACCIDENTAL_PURCHASE
   CANCELLATION_REASON_PAST_DUE
   CANCELLATION_REASON_ACCOUNT_CLOSED
   CANCELLATION_REASON_UPGRADE_DOWNGRADE
   CANCELLATION_REASON_USER_DELINQUENCY
   CANCELLATION_REASON_SYSTEM_ERROR
   CANCELLATION_REASON_SYSTEM_CANCEL
   CANCELLATION_REASON_OTHER]},
 :freeTrialEndTime string,
 :cycleEndTime string,
 :products [string],
 :name string,
 :upgradeDowngradeDetails
 {:billingCycleSpec
  [BILLING_CYCLE_SPEC_UNSPECIFIED
   BILLING_CYCLE_SPEC_ALIGN_WITH_PREVIOUS_SUBSCRIPTION
   BILLING_CYCLE_SPEC_START_IMMEDIATELY],
  :previousSubscriptionId string},
 :purchaseTime string,
 :createTime string,
 :processingState
 [PROCESSING_STATE_UNSPECIFIED
  PROCESSING_STATE_CANCELLING
  PROCESSING_STATE_RECURRING],
 :state
 [STATE_UNSPECIFIED
  STATE_CREATED
  STATE_ACTIVE
  STATE_CANCELLED
  STATE_IN_GRACE_PERIOD
  STATE_CANCEL_AT_END_OF_CYCLE
  STATE_SUSPENDED],
 :renewalTime string,
 :updateTime string,
 :partnerUserToken string,
 :lineItems
 [{:description string,
   :amount {:currencyCode string, :amountMicros string},
   :finiteBillingCycleDetails {:billingCycleCountLimit string},
   :lineItemIndex integer,
   :oneTimeRecurrenceDetails
   {:servicePeriod {:startTime string, :endTime string}},
   :lineItemPromotionSpecs
   [{:freeTrialDuration
     {:count integer, :unit [UNIT_UNSPECIFIED MONTH DAY HOUR]},
     :introductoryPricingDetails
     {:introductoryPricingSpecs
      [{:discountAmount
        GoogleCloudPaymentsResellerSubscriptionV1Amount,
        :recurrenceCount integer,
        :discountRatioMicros string,
        :regionCode string}]},
     :promotion string,
     :type
     [PROMOTION_TYPE_UNSPECIFIED
      PROMOTION_TYPE_FREE_TRIAL
      PROMOTION_TYPE_INTRODUCTORY_PRICING]}],
   :state
   [LINE_ITEM_STATE_UNSPECIFIED
    LINE_ITEM_STATE_ACTIVE
    LINE_ITEM_STATE_INACTIVE
    LINE_ITEM_STATE_NEW
    LINE_ITEM_STATE_ACTIVATING
    LINE_ITEM_STATE_DEACTIVATING
    LINE_ITEM_STATE_WAITING_TO_DEACTIVATE
    LINE_ITEM_STATE_OFF_CYCLE_CHARGING],
   :productPayload
   {:googleOnePayload
    {:salesChannel
     [CHANNEL_UNSPECIFIED
      CHANNEL_RETAIL
      CHANNEL_ONLINE_WEB
      CHANNEL_ONLINE_ANDROID_APP
      CHANNEL_ONLINE_IOS_APP],
     :storeId string,
     :campaigns [string],
     :offering
     [OFFERING_UNSPECIFIED
      OFFERING_VAS_BUNDLE
      OFFERING_VAS_STANDALONE
      OFFERING_HARD_BUNDLE
      OFFERING_SOFT_BUNDLE]},
    :youtubePayload
    {:partnerEligibilityIds [string],
     :partnerPlanType
     [PARTNER_PLAN_TYPE_UNSPECIFIED
      PARTNER_PLAN_TYPE_STANDALONE
      PARTNER_PLAN_TYPE_HARD_BUNDLE
      PARTNER_PLAN_TYPE_SOFT_BUNDLE],
     :accessEndTime string}},
   :product string,
   :bundleDetails
   {:bundleElementDetails
    [{:userAccountLinkedTime string, :product string}]},
   :lineItemFreeTrialEndTime string,
   :recurrenceType
   [LINE_ITEM_RECURRENCE_TYPE_UNSPECIFIED
    LINE_ITEM_RECURRENCE_TYPE_PERIODIC
    LINE_ITEM_RECURRENCE_TYPE_ONE_TIME]}],
 :promotionSpecs
 [{:freeTrialDuration
   {:count integer, :unit [UNIT_UNSPECIFIED MONTH DAY HOUR]},
   :introductoryPricingDetails
   {:introductoryPricingSpecs
    [{:discountAmount {:currencyCode string, :amountMicros string},
      :recurrenceCount integer,
      :discountRatioMicros string,
      :regionCode string}]},
   :promotion string,
   :type
   [PROMOTION_TYPE_UNSPECIFIED
    PROMOTION_TYPE_FREE_TRIAL
    PROMOTION_TYPE_INTRODUCTORY_PRICING]}],
 :serviceLocation {:postalCode string, :regionCode string}}

optional:
subscriptionId <string> Required. Identifies the subscription resource on the Partner side. The value is restricted to 63 ASCII characters at the maximum. If a subscription was previously created with the same subscription_id, we will directly return that one."
  ([parent GoogleCloudPaymentsResellerSubscriptionV1Subscription]
    (partners-subscriptions-create
      parent
      GoogleCloudPaymentsResellerSubscriptionV1Subscription
      nil))
  ([parent
    GoogleCloudPaymentsResellerSubscriptionV1Subscription
    optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://paymentsresellersubscription.googleapis.com/v1/{+parent}/subscriptions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["openid"],
       :body GoogleCloudPaymentsResellerSubscriptionV1Subscription})))

(defn partners-subscriptions-undoCancel
  "Revokes the pending cancellation of a subscription, which is currently in `STATE_CANCEL_AT_END_OF_CYCLE` state. If the subscription is already cancelled, the request will fail. - **This API doesn't apply to YouTube subscriptions.** It should be called directly by the partner using service accounts.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.subscriptions/undoCancel

name <string> Required. The name of the subscription resource whose pending cancellation needs to be undone. It will have the format of \"partners/{partner_id}/subscriptions/{subscription_id}\"
GoogleCloudPaymentsResellerSubscriptionV1UndoCancelSubscriptionRequest:
object"
  [name
   GoogleCloudPaymentsResellerSubscriptionV1UndoCancelSubscriptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://paymentsresellersubscription.googleapis.com/v1/{+name}:undoCancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["openid"],
     :body
     GoogleCloudPaymentsResellerSubscriptionV1UndoCancelSubscriptionRequest}))

(defn partners-subscriptions-get
  "Used by partners to get a subscription by id. It should be called directly by the partner using service accounts.
https://developers.google.com/payments/reseller/subscription/reference/rest/v1/partners.subscriptions/get

name <string> Required. The name of the subscription resource to retrieve. It will have the format of \"partners/{partner_id}/subscriptions/{subscription_id}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://paymentsresellersubscription.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["openid"]}))

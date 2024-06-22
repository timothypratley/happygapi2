(ns happygapi2.recaptchaenterprise
  "reCAPTCHA Enterprise API
Help protect your website from fraudulent activity, spam, and abuse without creating friction.
See: https://cloud.google.com/security/products/recaptcha"
  (:require [happy.oauth2.client :as client]))

(defn projects-relatedaccountgroups-list
  "List groups of related accounts.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/relatedaccountgroups/list

parent <string> Required. The name of the project to list related account groups from, in the format `projects/{project}`.

optional:
pageSize <integer> Optional. The maximum number of groups to return. The service might return fewer than this value. If unspecified, at most 50 groups are returned. The maximum value is 1000; values above 1000 are coerced to 1000."
  ([parent] (projects-relatedaccountgroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://recaptchaenterprise.googleapis.com/v1/{+parent}/relatedaccountgroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-relatedaccountgroups-memberships-list
  "Get memberships in a group of related accounts.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/relatedaccountgroups/memberships/list

parent <string> Required. The resource name for the related account group in the format `projects/{project}/relatedaccountgroups/{relatedaccountgroup}`.

optional:
pageSize <integer> Optional. The maximum number of accounts to return. The service might return fewer than this value. If unspecified, at most 50 accounts are returned. The maximum value is 1000; values above 1000 are coerced to 1000."
  ([parent]
    (projects-relatedaccountgroups-memberships-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://recaptchaenterprise.googleapis.com/v1/{+parent}/memberships",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-assessments-create
  "Creates an Assessment of the likelihood an event is legitimate.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/assessments/create

parent <string> Required. The name of the project in which the assessment will be created, in the format `projects/{project}`.
GoogleCloudRecaptchaenterpriseV1Assessment:
{:accountVerification
 {:username string,
  :languageCode string,
  :endpoints
  [{:lastVerificationTime string,
    :phoneNumber string,
    :emailAddress string,
    :requestToken string}],
  :latestVerificationResult
  [RESULT_UNSPECIFIED
   SUCCESS_USER_VERIFIED
   ERROR_USER_NOT_VERIFIED
   ERROR_SITE_ONBOARDING_INCOMPLETE
   ERROR_RECIPIENT_NOT_ALLOWED
   ERROR_RECIPIENT_ABUSE_LIMIT_EXHAUSTED
   ERROR_CRITICAL_INTERNAL
   ERROR_CUSTOMER_QUOTA_EXHAUSTED
   ERROR_VERIFICATION_BYPASSED
   ERROR_VERDICT_MISMATCH]},
 :riskAnalysis
 {:reasons
  [[CLASSIFICATION_REASON_UNSPECIFIED
    AUTOMATION
    UNEXPECTED_ENVIRONMENT
    TOO_MUCH_TRAFFIC
    UNEXPECTED_USAGE_PATTERNS
    LOW_CONFIDENCE_SCORE
    SUSPECTED_CARDING
    SUSPECTED_CHARGEBACK]],
  :extendedVerdictReasons [string],
  :score number},
 :accountDefenderAssessment
 {:labels
  [[ACCOUNT_DEFENDER_LABEL_UNSPECIFIED
    PROFILE_MATCH
    SUSPICIOUS_LOGIN_ACTIVITY
    SUSPICIOUS_ACCOUNT_CREATION
    RELATED_ACCOUNTS_NUMBER_HIGH]]},
 :phoneFraudAssessment
 {:smsTollFraudVerdict
  {:risk number,
   :reasons
   [[SMS_TOLL_FRAUD_REASON_UNSPECIFIED INVALID_PHONE_NUMBER]]}},
 :name string,
 :fraudSignals
 {:cardSignals
  {:cardLabels
   [[CARD_LABEL_UNSPECIFIED PREPAID VIRTUAL UNEXPECTED_LOCATION]]},
  :userSignals {:syntheticRisk number, :activeDaysLowerBound integer}},
 :event
 {:express boolean,
  :wafTokenAssessment boolean,
  :siteKey string,
  :firewallPolicyEvaluation boolean,
  :fraudPrevention [FRAUD_PREVENTION_UNSPECIFIED ENABLED DISABLED],
  :headers [string],
  :token string,
  :transactionData
  {:cardBin string,
   :shippingValue number,
   :transactionId string,
   :value number,
   :gatewayInfo
   {:cvvResponseCode string,
    :avsResponseCode string,
    :gatewayResponseCode string,
    :name string},
   :merchants
   [{:accountId string,
     :email string,
     :emailVerified boolean,
     :phoneVerified boolean,
     :phoneNumber string,
     :creationMs string}],
   :paymentMethod string,
   :currencyCode string,
   :cardLastFour string,
   :items
   [{:merchantAccountId string,
     :name string,
     :quantity string,
     :value number}],
   :shippingAddress
   {:address [string],
    :recipient string,
    :locality string,
    :regionCode string,
    :postalCode string,
    :administrativeArea string},
   :user
   {:accountId string,
    :email string,
    :emailVerified boolean,
    :phoneVerified boolean,
    :phoneNumber string,
    :creationMs string},
   :billingAddress
   {:address [string],
    :recipient string,
    :locality string,
    :regionCode string,
    :postalCode string,
    :administrativeArea string}},
  :userIpAddress string,
  :userAgent string,
  :ja3 string,
  :hashedAccountId string,
  :expectedAction string,
  :userInfo
  {:createAccountTime string,
   :accountId string,
   :userIds [{:phoneNumber string, :username string, :email string}]},
  :requestedUri string},
 :fraudPreventionAssessment
 {:behavioralTrustVerdict {:trust number},
  :stolenInstrumentVerdict {:risk number},
  :cardTestingVerdict {:risk number},
  :transactionRisk number},
 :firewallPolicyAssessment
 {:error {:code integer, :details [object], :message string},
  :firewallPolicy
  {:path string,
   :description string,
   :name string,
   :actions
   [{:block object,
     :setHeader {:key string, :value string},
     :includeRecaptchaScript object,
     :redirect object,
     :substitute {:path string},
     :allow object}],
   :condition string}},
 :privatePasswordLeakVerification
 {:reencryptedUserCredentialsHash string,
  :encryptedUserCredentialsHash string,
  :encryptedLeakMatchPrefixes [string],
  :lookupHashPrefix string},
 :tokenProperties
 {:invalidReason
  [INVALID_REASON_UNSPECIFIED
   UNKNOWN_INVALID_REASON
   MALFORMED
   EXPIRED
   DUPE
   MISSING
   BROWSER_ERROR],
  :androidPackageName string,
  :hostname string,
  :action string,
  :createTime string,
  :valid boolean,
  :iosBundleId string}}"
  [parent GoogleCloudRecaptchaenterpriseV1Assessment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+parent}/assessments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRecaptchaenterpriseV1Assessment}))

(defn projects-assessments-annotate
  "Annotates a previously created Assessment to provide additional information on whether the event turned out to be authentic or fraudulent.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/assessments/annotate

name <string> Required. The resource name of the Assessment, in the format `projects/{project}/assessments/{assessment}`.
GoogleCloudRecaptchaenterpriseV1AnnotateAssessmentRequest:
{:hashedAccountId string,
 :accountId string,
 :transactionEvent
 {:reason string,
  :eventTime string,
  :value number,
  :eventType
  [TRANSACTION_EVENT_TYPE_UNSPECIFIED
   MERCHANT_APPROVE
   MERCHANT_DENY
   MANUAL_REVIEW
   AUTHORIZATION
   AUTHORIZATION_DECLINE
   PAYMENT_CAPTURE
   PAYMENT_CAPTURE_DECLINE
   CANCEL
   CHARGEBACK_INQUIRY
   CHARGEBACK_ALERT
   FRAUD_NOTIFICATION
   CHARGEBACK
   CHARGEBACK_REPRESENTMENT
   CHARGEBACK_REVERSE
   REFUND_REQUEST
   REFUND_DECLINE
   REFUND
   REFUND_REVERSE]},
 :annotation
 [ANNOTATION_UNSPECIFIED
  LEGITIMATE
  FRAUDULENT
  PASSWORD_CORRECT
  PASSWORD_INCORRECT],
 :reasons
 [[REASON_UNSPECIFIED
   CHARGEBACK
   CHARGEBACK_FRAUD
   CHARGEBACK_DISPUTE
   REFUND
   REFUND_FRAUD
   TRANSACTION_ACCEPTED
   TRANSACTION_DECLINED
   PAYMENT_HEURISTICS
   INITIATED_TWO_FACTOR
   PASSED_TWO_FACTOR
   FAILED_TWO_FACTOR
   CORRECT_PASSWORD
   INCORRECT_PASSWORD
   SOCIAL_SPAM]]}"
  [name GoogleCloudRecaptchaenterpriseV1AnnotateAssessmentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+name}:annotate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRecaptchaenterpriseV1AnnotateAssessmentRequest}))

(defn projects-firewallpolicies-get
  "Returns the specified firewall policy.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/firewallpolicies/get

name <string> Required. The name of the requested policy, in the format `projects/{project}/firewallpolicies/{firewallpolicy}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-firewallpolicies-patch
  "Updates the specified firewall policy.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/firewallpolicies/patch

name <string> Identifier. The resource name for the FirewallPolicy in the format `projects/{project}/firewallpolicies/{firewallpolicy}`.
GoogleCloudRecaptchaenterpriseV1FirewallPolicy:
{:path string,
 :description string,
 :name string,
 :actions
 [{:block object,
   :setHeader {:key string, :value string},
   :includeRecaptchaScript object,
   :redirect object,
   :substitute {:path string},
   :allow object}],
 :condition string}

optional:
updateMask <string> Optional. The mask to control which fields of the policy get updated. If the mask is not present, all fields will be updated."
  ([name GoogleCloudRecaptchaenterpriseV1FirewallPolicy]
    (projects-firewallpolicies-patch
      name
      GoogleCloudRecaptchaenterpriseV1FirewallPolicy
      nil))
  ([name GoogleCloudRecaptchaenterpriseV1FirewallPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://recaptchaenterprise.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudRecaptchaenterpriseV1FirewallPolicy})))

(defn projects-firewallpolicies-create
  "Creates a new FirewallPolicy, specifying conditions at which reCAPTCHA Enterprise actions can be executed. A project may have a maximum of 1000 policies.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/firewallpolicies/create

parent <string> Required. The name of the project this policy will apply to, in the format `projects/{project}`.
GoogleCloudRecaptchaenterpriseV1FirewallPolicy:
{:path string,
 :description string,
 :name string,
 :actions
 [{:block object,
   :setHeader {:key string, :value string},
   :includeRecaptchaScript object,
   :redirect object,
   :substitute {:path string},
   :allow object}],
 :condition string}"
  [parent GoogleCloudRecaptchaenterpriseV1FirewallPolicy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+parent}/firewallpolicies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRecaptchaenterpriseV1FirewallPolicy}))

(defn projects-firewallpolicies-reorder
  "Reorders all firewall policies.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/firewallpolicies/reorder

parent <string> Required. The name of the project to list the policies for, in the format `projects/{project}`.
GoogleCloudRecaptchaenterpriseV1ReorderFirewallPoliciesRequest:
{:names [string]}"
  [parent
   GoogleCloudRecaptchaenterpriseV1ReorderFirewallPoliciesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+parent}/firewallpolicies:reorder",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudRecaptchaenterpriseV1ReorderFirewallPoliciesRequest}))

(defn projects-firewallpolicies-list
  "Returns the list of all firewall policies that belong to a project.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/firewallpolicies/list

parent <string> Required. The name of the project to list the policies for, in the format `projects/{project}`.

optional:
pageSize <integer> Optional. The maximum number of policies to return. Default is 10. Max limit is 1000."
  ([parent] (projects-firewallpolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://recaptchaenterprise.googleapis.com/v1/{+parent}/firewallpolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-firewallpolicies-delete
  "Deletes the specified firewall policy.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/firewallpolicies/delete

name <string> Required. The name of the policy to be deleted, in the format `projects/{project}/firewallpolicies/{firewallpolicy}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-relatedaccountgroupmemberships-search
  "Search group memberships related to a given account.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/relatedaccountgroupmemberships/search

project <string> Required. The name of the project to search related account group memberships from. Specify the project name in the following format: `projects/{project}`.
GoogleCloudRecaptchaenterpriseV1SearchRelatedAccountGroupMembershipsRequest:
{:pageSize integer,
 :pageToken string,
 :accountId string,
 :hashedAccountId string}"
  [project
   GoogleCloudRecaptchaenterpriseV1SearchRelatedAccountGroupMembershipsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+project}/relatedaccountgroupmemberships:search",
     :uri-template-args {:project project},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudRecaptchaenterpriseV1SearchRelatedAccountGroupMembershipsRequest}))

(defn projects-keys-delete
  "Deletes the specified key.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/delete

name <string> Required. The name of the key to be deleted, in the format `projects/{project}/keys/{key}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-keys-migrate
  "Migrates an existing key from reCAPTCHA to reCAPTCHA Enterprise. Once a key is migrated, it can be used from either product. SiteVerify requests are billed as CreateAssessment calls. You must be authenticated as one of the current owners of the reCAPTCHA Key, and your user must have the reCAPTCHA Enterprise Admin IAM role in the destination project.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/migrate

name <string> Required. The name of the key to be migrated, in the format `projects/{project}/keys/{key}`.
GoogleCloudRecaptchaenterpriseV1MigrateKeyRequest:
{:skipBillingCheck boolean}"
  [name GoogleCloudRecaptchaenterpriseV1MigrateKeyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+name}:migrate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRecaptchaenterpriseV1MigrateKeyRequest}))

(defn projects-keys-create
  "Creates a new reCAPTCHA Enterprise key.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/create

parent <string> Required. The name of the project in which the key will be created, in the format `projects/{project}`.
GoogleCloudRecaptchaenterpriseV1Key:
{:labels object,
 :wafSettings
 {:wafFeature
  [WAF_FEATURE_UNSPECIFIED
   CHALLENGE_PAGE
   SESSION_TOKEN
   ACTION_TOKEN
   EXPRESS],
  :wafService [WAF_SERVICE_UNSPECIFIED CA FASTLY CLOUDFLARE]},
 :displayName string,
 :name string,
 :webSettings
 {:allowAmpTraffic boolean,
  :challengeSecurityPreference
  [CHALLENGE_SECURITY_PREFERENCE_UNSPECIFIED
   USABILITY
   BALANCE
   SECURITY],
  :integrationType
  [INTEGRATION_TYPE_UNSPECIFIED SCORE CHECKBOX INVISIBLE],
  :allowedDomains [string],
  :allowAllDomains boolean},
 :createTime string,
 :androidSettings
 {:supportNonGoogleAppStoreDistribution boolean,
  :allowAllPackageNames boolean,
  :allowedPackageNames [string]},
 :testingOptions
 {:testingChallenge
  [TESTING_CHALLENGE_UNSPECIFIED NOCAPTCHA UNSOLVABLE_CHALLENGE],
  :testingScore number},
 :iosSettings
 {:allowedBundleIds [string],
  :appleDeveloperId
  {:privateKey string, :keyId string, :teamId string},
  :allowAllBundleIds boolean}}"
  [parent GoogleCloudRecaptchaenterpriseV1Key]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+parent}/keys",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRecaptchaenterpriseV1Key}))

(defn projects-keys-get
  "Returns the specified key.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/get

name <string> Required. The name of the requested key, in the format `projects/{project}/keys/{key}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-keys-getMetrics
  "Get some aggregated metrics for a Key. This data can be used to build dashboards.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/getMetrics

name <string> Required. The name of the requested metrics, in the format `projects/{project}/keys/{key}/metrics`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-keys-patch
  "Updates the specified key.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/patch

name <string> Identifier. The resource name for the Key in the format `projects/{project}/keys/{key}`.
GoogleCloudRecaptchaenterpriseV1Key:
{:labels object,
 :wafSettings
 {:wafFeature
  [WAF_FEATURE_UNSPECIFIED
   CHALLENGE_PAGE
   SESSION_TOKEN
   ACTION_TOKEN
   EXPRESS],
  :wafService [WAF_SERVICE_UNSPECIFIED CA FASTLY CLOUDFLARE]},
 :displayName string,
 :name string,
 :webSettings
 {:allowAmpTraffic boolean,
  :challengeSecurityPreference
  [CHALLENGE_SECURITY_PREFERENCE_UNSPECIFIED
   USABILITY
   BALANCE
   SECURITY],
  :integrationType
  [INTEGRATION_TYPE_UNSPECIFIED SCORE CHECKBOX INVISIBLE],
  :allowedDomains [string],
  :allowAllDomains boolean},
 :createTime string,
 :androidSettings
 {:supportNonGoogleAppStoreDistribution boolean,
  :allowAllPackageNames boolean,
  :allowedPackageNames [string]},
 :testingOptions
 {:testingChallenge
  [TESTING_CHALLENGE_UNSPECIFIED NOCAPTCHA UNSOLVABLE_CHALLENGE],
  :testingScore number},
 :iosSettings
 {:allowedBundleIds [string],
  :appleDeveloperId
  {:privateKey string, :keyId string, :teamId string},
  :allowAllBundleIds boolean}}

optional:
updateMask <string> Optional. The mask to control which fields of the key get updated. If the mask is not present, all fields will be updated."
  ([name GoogleCloudRecaptchaenterpriseV1Key]
    (projects-keys-patch name GoogleCloudRecaptchaenterpriseV1Key nil))
  ([name GoogleCloudRecaptchaenterpriseV1Key optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://recaptchaenterprise.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudRecaptchaenterpriseV1Key})))

(defn projects-keys-list
  "Returns the list of all keys that belong to a project.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/list

parent <string> Required. The name of the project that contains the keys that will be listed, in the format `projects/{project}`.

optional:
pageSize <integer> Optional. The maximum number of keys to return. Default is 10. Max limit is 1000."
  ([parent] (projects-keys-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://recaptchaenterprise.googleapis.com/v1/{+parent}/keys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-keys-retrieveLegacySecretKey
  "Returns the secret key related to the specified public key. You must use the legacy secret key only in a 3rd party integration with legacy reCAPTCHA.
https://cloud.google.com/security/products/recaptcha/v1/docs/projects/keys/retrieveLegacySecretKey

key <string> Required. The public key name linked to the requested secret key in the format `projects/{project}/keys/{key}`."
  [key]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://recaptchaenterprise.googleapis.com/v1/{+key}:retrieveLegacySecretKey",
     :uri-template-args {:key key},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

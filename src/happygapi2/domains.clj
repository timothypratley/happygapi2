(ns happygapi2.domains
  "Cloud Domains API
Enables management and configuration of domain names.
See: https://cloud.google.com/domains/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://domains.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://domains.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-registrations-retrieveRegisterParameters
  "Gets parameters needed to register a new domain name, including price and up-to-date availability. Use the returned values to call `RegisterDomain`.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/retrieveRegisterParameters

location <string> Required. The location. Must be in the format `projects/*/locations/*`.

optional:
domainName <string> Required. The domain name. Unicode domain names must be expressed in Punycode format."
  ([location]
    (projects-locations-registrations-retrieveRegisterParameters
      location
      nil))
  ([location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+location}/registrations:retrieveRegisterParameters",
       :uri-template-args {:location location},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-registrations-retrieveTransferParameters
  "Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Gets parameters needed to transfer a domain name from another registrar to Cloud Domains. For domains already managed by [Google Domains](https://domains.google/), use `ImportDomain` instead. Use the returned values to call `TransferDomain`.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/retrieveTransferParameters

location <string> Required. The location. Must be in the format `projects/*/locations/*`.

optional:
domainName <string> Required. The domain name. Unicode domain names must be expressed in Punycode format."
  ([location]
    (projects-locations-registrations-retrieveTransferParameters
      location
      nil))
  ([location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+location}/registrations:retrieveTransferParameters",
       :uri-template-args {:location location},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-registrations-get
  "Gets the details of a `Registration` resource.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/get

name <string> Required. The name of the `Registration` to get, in the format `projects/*/locations/*/registrations/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://domains.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-registrations-retrieveGoogleDomainsDnsRecords
  "Lists the DNS records from the Google Domains DNS zone for domains that use the deprecated `google_domains_dns` in the `Registration`'s `dns_settings`.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/retrieveGoogleDomainsDnsRecords

registration <string> Required. The name of the `Registration` whose Google Domains DNS records details you are retrieving, in the format `projects/*/locations/*/registrations/*`.

optional:
pageSize <integer> Optional. Maximum number of results to return."
  ([registration]
    (projects-locations-registrations-retrieveGoogleDomainsDnsRecords
      registration
      nil))
  ([registration optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+registration}:retrieveGoogleDomainsDnsRecords",
       :uri-template-args {:registration registration},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-registrations-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/setIamPolicy

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
     "https://domains.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-registrations-configureManagementSettings
  "Updates a `Registration`'s management settings.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/configureManagementSettings

registration <string> Required. The name of the `Registration` whose management settings are being updated, in the format `projects/*/locations/*/registrations/*`.
ConfigureManagementSettingsRequest:
{:managementSettings
 {:renewalMethod
  [RENEWAL_METHOD_UNSPECIFIED
   AUTOMATIC_RENEWAL
   MANUAL_RENEWAL
   RENEWAL_DISABLED],
  :preferredRenewalMethod
  [RENEWAL_METHOD_UNSPECIFIED
   AUTOMATIC_RENEWAL
   MANUAL_RENEWAL
   RENEWAL_DISABLED],
  :transferLockState [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED],
  :effectiveTransferLockState
  [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED]},
 :updateMask string}"
  [registration ConfigureManagementSettingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:configureManagementSettings",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ConfigureManagementSettingsRequest}))

(defn projects-locations-registrations-patch
  "Updates select fields of a `Registration` resource, notably `labels`. To update other fields, use the appropriate custom update method: * To update management settings, see `ConfigureManagementSettings` * To update DNS configuration, see `ConfigureDnsSettings` * To update contact information, see `ConfigureContactSettings`
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/patch

name <string> Output only. Name of the `Registration` resource, in the format `projects/*/locations/*/registrations/`.
Registration:
{:transferFailureReason
 [TRANSFER_FAILURE_REASON_UNSPECIFIED
  TRANSFER_FAILURE_REASON_UNKNOWN
  EMAIL_CONFIRMATION_FAILURE
  DOMAIN_NOT_REGISTERED
  DOMAIN_HAS_TRANSFER_LOCK
  INVALID_AUTHORIZATION_CODE
  TRANSFER_CANCELLED
  TRANSFER_REJECTED
  INVALID_REGISTRANT_EMAIL_ADDRESS
  DOMAIN_NOT_ELIGIBLE_FOR_TRANSFER
  TRANSFER_ALREADY_PENDING],
 :labels object,
 :supportedPrivacy
 [[CONTACT_PRIVACY_UNSPECIFIED
   PUBLIC_CONTACT_DATA
   PRIVATE_CONTACT_DATA
   REDACTED_CONTACT_DATA]],
 :dnsSettings
 {:customDns
  {:nameServers [string],
   :dsRecords
   [{:keyTag integer,
     :algorithm
     [ALGORITHM_UNSPECIFIED
      RSAMD5
      DH
      DSA
      ECC
      RSASHA1
      DSANSEC3SHA1
      RSASHA1NSEC3SHA1
      RSASHA256
      RSASHA512
      ECCGOST
      ECDSAP256SHA256
      ECDSAP384SHA384
      ED25519
      ED448
      INDIRECT
      PRIVATEDNS
      PRIVATEOID],
     :digestType [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
     :digest string}]},
  :googleDomainsDns
  {:nameServers [string],
   :dsState
   [DS_STATE_UNSPECIFIED DS_RECORDS_UNPUBLISHED DS_RECORDS_PUBLISHED],
   :dsRecords
   [{:keyTag integer,
     :algorithm
     [ALGORITHM_UNSPECIFIED
      RSAMD5
      DH
      DSA
      ECC
      RSASHA1
      DSANSEC3SHA1
      RSASHA1NSEC3SHA1
      RSASHA256
      RSASHA512
      ECCGOST
      ECDSAP256SHA256
      ECDSAP384SHA384
      ED25519
      ED448
      INDIRECT
      PRIVATEDNS
      PRIVATEOID],
     :digestType [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
     :digest string}]},
  :glueRecords
  [{:hostName string,
    :ipv4Addresses [string],
    :ipv6Addresses [string]}],
  :googleDomainsRedirectsDataAvailable boolean},
 :issues
 [[ISSUE_UNSPECIFIED
   CONTACT_SUPPORT
   UNVERIFIED_EMAIL
   PROBLEM_WITH_BILLING
   DNS_NOT_ACTIVATED]],
 :name string,
 :registerFailureReason
 [REGISTER_FAILURE_REASON_UNSPECIFIED
  REGISTER_FAILURE_REASON_UNKNOWN
  DOMAIN_NOT_AVAILABLE
  INVALID_CONTACTS],
 :createTime string,
 :managementSettings
 {:renewalMethod
  [RENEWAL_METHOD_UNSPECIFIED
   AUTOMATIC_RENEWAL
   MANUAL_RENEWAL
   RENEWAL_DISABLED],
  :preferredRenewalMethod
  [RENEWAL_METHOD_UNSPECIFIED
   AUTOMATIC_RENEWAL
   MANUAL_RENEWAL
   RENEWAL_DISABLED],
  :transferLockState [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED],
  :effectiveTransferLockState
  [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED]},
 :contactSettings
 {:privacy
  [CONTACT_PRIVACY_UNSPECIFIED
   PUBLIC_CONTACT_DATA
   PRIVATE_CONTACT_DATA
   REDACTED_CONTACT_DATA],
  :registrantContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string},
  :adminContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string},
  :technicalContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string}},
 :state
 [STATE_UNSPECIFIED
  REGISTRATION_PENDING
  REGISTRATION_FAILED
  TRANSFER_PENDING
  TRANSFER_FAILED
  IMPORT_PENDING
  ACTIVE
  SUSPENDED
  EXPORTED
  EXPIRED],
 :domainName string,
 :expireTime string,
 :pendingContactSettings
 {:privacy
  [CONTACT_PRIVACY_UNSPECIFIED
   PUBLIC_CONTACT_DATA
   PRIVATE_CONTACT_DATA
   REDACTED_CONTACT_DATA],
  :registrantContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string},
  :adminContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string},
  :technicalContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string}},
 :domainProperties
 [[DOMAIN_PROPERTY_UNSPECIFIED
   TRANSFER_LOCK_UNSUPPORTED_BY_REGISTRY
   REQUIRE_PUSH_TRANSFER]]}

optional:
updateMask <string> Required. The field mask describing which fields to update as a comma-separated list. For example, if only the labels are being updated, the `update_mask` is `\"labels\"`."
  ([name Registration]
    (projects-locations-registrations-patch name Registration nil))
  ([name Registration optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://domains.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Registration})))

(defn projects-locations-registrations-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-registrations-transfer
  "Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Transfers a domain name from another registrar to Cloud Domains. For domains already managed by [Google Domains](https://domains.google/), use `ImportDomain` instead. Before calling this method, go to the domain's current registrar to unlock the domain for transfer and retrieve the domain's transfer authorization code. Then call `RetrieveTransferParameters` to confirm that the domain is unlocked and to get values needed to build a call to this method. A successful call creates a `Registration` resource in state `TRANSFER_PENDING`. It can take several days to complete the transfer process. The registrant can often speed up this process by approving the transfer through the current registrar, either by clicking a link in an email from the registrar or by visiting the registrar's website. A few minutes after transfer approval, the resource transitions to state `ACTIVE`, indicating that the transfer was successful. If the transfer is rejected or the request expires without being approved, the resource can end up in state `TRANSFER_FAILED`. If transfer fails, you can safely delete the resource and retry the transfer.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/transfer

parent <string> Required. The parent resource of the `Registration`. Must be in the format `projects/*/locations/*`.
TransferDomainRequest:
{:registration
 {:transferFailureReason
  [TRANSFER_FAILURE_REASON_UNSPECIFIED
   TRANSFER_FAILURE_REASON_UNKNOWN
   EMAIL_CONFIRMATION_FAILURE
   DOMAIN_NOT_REGISTERED
   DOMAIN_HAS_TRANSFER_LOCK
   INVALID_AUTHORIZATION_CODE
   TRANSFER_CANCELLED
   TRANSFER_REJECTED
   INVALID_REGISTRANT_EMAIL_ADDRESS
   DOMAIN_NOT_ELIGIBLE_FOR_TRANSFER
   TRANSFER_ALREADY_PENDING],
  :labels object,
  :supportedPrivacy
  [[CONTACT_PRIVACY_UNSPECIFIED
    PUBLIC_CONTACT_DATA
    PRIVATE_CONTACT_DATA
    REDACTED_CONTACT_DATA]],
  :dnsSettings
  {:customDns
   {:nameServers [string],
    :dsRecords
    [{:keyTag integer,
      :algorithm
      [ALGORITHM_UNSPECIFIED
       RSAMD5
       DH
       DSA
       ECC
       RSASHA1
       DSANSEC3SHA1
       RSASHA1NSEC3SHA1
       RSASHA256
       RSASHA512
       ECCGOST
       ECDSAP256SHA256
       ECDSAP384SHA384
       ED25519
       ED448
       INDIRECT
       PRIVATEDNS
       PRIVATEOID],
      :digestType
      [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
      :digest string}]},
   :googleDomainsDns
   {:nameServers [string],
    :dsState
    [DS_STATE_UNSPECIFIED DS_RECORDS_UNPUBLISHED DS_RECORDS_PUBLISHED],
    :dsRecords
    [{:keyTag integer,
      :algorithm
      [ALGORITHM_UNSPECIFIED
       RSAMD5
       DH
       DSA
       ECC
       RSASHA1
       DSANSEC3SHA1
       RSASHA1NSEC3SHA1
       RSASHA256
       RSASHA512
       ECCGOST
       ECDSAP256SHA256
       ECDSAP384SHA384
       ED25519
       ED448
       INDIRECT
       PRIVATEDNS
       PRIVATEOID],
      :digestType
      [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
      :digest string}]},
   :glueRecords
   [{:hostName string,
     :ipv4Addresses [string],
     :ipv6Addresses [string]}],
   :googleDomainsRedirectsDataAvailable boolean},
  :issues
  [[ISSUE_UNSPECIFIED
    CONTACT_SUPPORT
    UNVERIFIED_EMAIL
    PROBLEM_WITH_BILLING
    DNS_NOT_ACTIVATED]],
  :name string,
  :registerFailureReason
  [REGISTER_FAILURE_REASON_UNSPECIFIED
   REGISTER_FAILURE_REASON_UNKNOWN
   DOMAIN_NOT_AVAILABLE
   INVALID_CONTACTS],
  :createTime string,
  :managementSettings
  {:renewalMethod
   [RENEWAL_METHOD_UNSPECIFIED
    AUTOMATIC_RENEWAL
    MANUAL_RENEWAL
    RENEWAL_DISABLED],
   :preferredRenewalMethod
   [RENEWAL_METHOD_UNSPECIFIED
    AUTOMATIC_RENEWAL
    MANUAL_RENEWAL
    RENEWAL_DISABLED],
   :transferLockState
   [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED],
   :effectiveTransferLockState
   [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED]},
  :contactSettings
  {:privacy
   [CONTACT_PRIVACY_UNSPECIFIED
    PUBLIC_CONTACT_DATA
    PRIVATE_CONTACT_DATA
    REDACTED_CONTACT_DATA],
   :registrantContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :adminContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :technicalContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string}},
  :state
  [STATE_UNSPECIFIED
   REGISTRATION_PENDING
   REGISTRATION_FAILED
   TRANSFER_PENDING
   TRANSFER_FAILED
   IMPORT_PENDING
   ACTIVE
   SUSPENDED
   EXPORTED
   EXPIRED],
  :domainName string,
  :expireTime string,
  :pendingContactSettings
  {:privacy
   [CONTACT_PRIVACY_UNSPECIFIED
    PUBLIC_CONTACT_DATA
    PRIVATE_CONTACT_DATA
    REDACTED_CONTACT_DATA],
   :registrantContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :adminContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :technicalContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string}},
  :domainProperties
  [[DOMAIN_PROPERTY_UNSPECIFIED
    TRANSFER_LOCK_UNSUPPORTED_BY_REGISTRY
    REQUIRE_PUSH_TRANSFER]]},
 :contactNotices
 [[CONTACT_NOTICE_UNSPECIFIED PUBLIC_CONTACT_DATA_ACKNOWLEDGEMENT]],
 :yearlyPrice {:currencyCode string, :units string, :nanos integer},
 :authorizationCode {:code string},
 :validateOnly boolean}"
  [parent TransferDomainRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+parent}/registrations:transfer",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TransferDomainRequest}))

(defn projects-locations-registrations-renewDomain
  "Renews a recently expired domain. This method can only be called on domains that expired in the previous 30 days. After the renewal, the new expiration time of the domain is one year after the old expiration time and you are charged a `yearly_price` for the renewal.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/renewDomain

registration <string> Required. The name of the `Registration` whish is being renewed, in the format `projects/*/locations/*/registrations/*`.
RenewDomainRequest:
{:yearlyPrice {:currencyCode string, :units string, :nanos integer},
 :validateOnly boolean}"
  [registration RenewDomainRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:renewDomain",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RenewDomainRequest}))

(defn projects-locations-registrations-resetAuthorizationCode
  "Resets the authorization code of the `Registration` to a new random string. You can call this method only after 60 days have elapsed since the initial domain registration. Domains that have the `REQUIRE_PUSH_TRANSFER` property in the list of `domain_properties` don't support authorization codes and must use the `InitiatePushTransfer` method to initiate the process to transfer the domain to a different registrar.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/resetAuthorizationCode

registration <string> Required. The name of the `Registration` whose authorization code is being reset, in the format `projects/*/locations/*/registrations/*`.
ResetAuthorizationCodeRequest:
object"
  [registration ResetAuthorizationCodeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:resetAuthorizationCode",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetAuthorizationCodeRequest}))

(defn projects-locations-registrations-configureContactSettings
  "Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's registrant contact . Caution: Please consider carefully any changes to contact privacy settings when changing from `REDACTED_CONTACT_DATA` to `PUBLIC_CONTACT_DATA.` There may be a delay in reflecting updates you make to registrant contact information such that any changes you make to contact privacy (including from `REDACTED_CONTACT_DATA` to `PUBLIC_CONTACT_DATA`) will be applied without delay but changes to registrant contact information may take a limited time to be publicized. This means that changes to contact privacy from `REDACTED_CONTACT_DATA` to `PUBLIC_CONTACT_DATA` may make the previous registrant contact data public until the modified registrant contact details are published.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/configureContactSettings

registration <string> Required. The name of the `Registration` whose contact settings are being updated, in the format `projects/*/locations/*/registrations/*`.
ConfigureContactSettingsRequest:
{:contactSettings
 {:privacy
  [CONTACT_PRIVACY_UNSPECIFIED
   PUBLIC_CONTACT_DATA
   PRIVATE_CONTACT_DATA
   REDACTED_CONTACT_DATA],
  :registrantContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string},
  :adminContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string},
  :technicalContact
  {:postalAddress
   {:sortingCode string,
    :locality string,
    :revision integer,
    :administrativeArea string,
    :addressLines [string],
    :organization string,
    :recipients [string],
    :languageCode string,
    :regionCode string,
    :postalCode string,
    :sublocality string},
   :email string,
   :phoneNumber string,
   :faxNumber string}},
 :updateMask string,
 :contactNotices
 [[CONTACT_NOTICE_UNSPECIFIED PUBLIC_CONTACT_DATA_ACKNOWLEDGEMENT]],
 :validateOnly boolean}"
  [registration ConfigureContactSettingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:configureContactSettings",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ConfigureContactSettingsRequest}))

(defn projects-locations-registrations-configureDnsSettings
  "Updates a `Registration`'s DNS settings.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/configureDnsSettings

registration <string> Required. The name of the `Registration` whose DNS settings are being updated, in the format `projects/*/locations/*/registrations/*`.
ConfigureDnsSettingsRequest:
{:dnsSettings
 {:customDns
  {:nameServers [string],
   :dsRecords
   [{:keyTag integer,
     :algorithm
     [ALGORITHM_UNSPECIFIED
      RSAMD5
      DH
      DSA
      ECC
      RSASHA1
      DSANSEC3SHA1
      RSASHA1NSEC3SHA1
      RSASHA256
      RSASHA512
      ECCGOST
      ECDSAP256SHA256
      ECDSAP384SHA384
      ED25519
      ED448
      INDIRECT
      PRIVATEDNS
      PRIVATEOID],
     :digestType [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
     :digest string}]},
  :googleDomainsDns
  {:nameServers [string],
   :dsState
   [DS_STATE_UNSPECIFIED DS_RECORDS_UNPUBLISHED DS_RECORDS_PUBLISHED],
   :dsRecords
   [{:keyTag integer,
     :algorithm
     [ALGORITHM_UNSPECIFIED
      RSAMD5
      DH
      DSA
      ECC
      RSASHA1
      DSANSEC3SHA1
      RSASHA1NSEC3SHA1
      RSASHA256
      RSASHA512
      ECCGOST
      ECDSAP256SHA256
      ECDSAP384SHA384
      ED25519
      ED448
      INDIRECT
      PRIVATEDNS
      PRIVATEOID],
     :digestType [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
     :digest string}]},
  :glueRecords
  [{:hostName string,
    :ipv4Addresses [string],
    :ipv6Addresses [string]}],
  :googleDomainsRedirectsDataAvailable boolean},
 :updateMask string,
 :validateOnly boolean}"
  [registration ConfigureDnsSettingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:configureDnsSettings",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ConfigureDnsSettingsRequest}))

(defn projects-locations-registrations-delete
  "Deletes a `Registration` resource. This method works on any `Registration` resource using [Subscription or Commitment billing](/domains/pricing#billing-models), provided that the resource was created at least 1 day in the past. When an active registration is successfully deleted, you can continue to use the domain in [Google Domains](https://domains.google/) until it expires. The calling user becomes the domain's sole owner in Google Domains, and permissions for the domain are subsequently managed there. The domain does not renew automatically unless the new owner sets up billing in Google Domains. After January 2024 you will only be able to delete `Registration` resources when `state` is one of: `EXPORTED`, `EXPIRED`,`REGISTRATION_FAILED` or `TRANSFER_FAILED`. See [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) for more details.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/delete

name <string> Required. The name of the `Registration` to delete, in the format `projects/*/locations/*/registrations/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://domains.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-registrations-initiatePushTransfer
  "Initiates the `Push Transfer` process to transfer the domain to another registrar. The process might complete instantly or might require confirmation or additional work. Check the emails sent to the email address of the registrant. The process is aborted after a timeout if it's not completed. This method is only supported for domains that have the `REQUIRE_PUSH_TRANSFER` property in the list of `domain_properties`. The domain must also be unlocked before it can be transferred to a different registrar. For more information, see [Transfer a registered domain to another registrar](https://cloud.google.com/domains/docs/transfer-domain-to-another-registrar).
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/initiatePushTransfer

registration <string> Required. The name of the `Registration` for which the push transfer is initiated, in the format `projects/*/locations/*/registrations/*`.
InitiatePushTransferRequest:
{:tag string}"
  [registration InitiatePushTransferRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:initiatePushTransfer",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InitiatePushTransferRequest}))

(defn projects-locations-registrations-export
  "Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Exports a `Registration` resource, such that it is no longer managed by Cloud Domains. When an active domain is successfully exported, you can continue to use the domain in [Google Domains](https://domains.google/) until it expires. The calling user becomes the domain's sole owner in Google Domains, and permissions for the domain are subsequently managed there. The domain does not renew automatically unless the new owner sets up billing in Google Domains.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/export

name <string> Required. The name of the `Registration` to export, in the format `projects/*/locations/*/registrations/*`.
ExportRegistrationRequest:
object"
  [name ExportRegistrationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://domains.googleapis.com/v1/{+name}:export",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportRegistrationRequest}))

(defn projects-locations-registrations-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-registrations-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-registrations-retrieveImportableDomains
  "Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Lists domain names from [Google Domains](https://domains.google/) that can be imported to Cloud Domains using the `ImportDomain` method. Since individual users can own domains in Google Domains, the list of domains returned depends on the individual user making the call. Domains already managed by Cloud Domains are not returned.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/retrieveImportableDomains

location <string> Required. The location. Must be in the format `projects/*/locations/*`.

optional:
pageSize <integer> Maximum number of results to return."
  ([location]
    (projects-locations-registrations-retrieveImportableDomains
      location
      nil))
  ([location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+location}/registrations:retrieveImportableDomains",
       :uri-template-args {:location location},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-registrations-list
  "Lists the `Registration` resources in a project.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/list

parent <string> Required. The project and location from which to list `Registration`s, specified in the format `projects/*/locations/*`.

optional:
pageSize <integer> Maximum number of results to return.
filter <string> Filter expression to restrict the `Registration`s returned. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, a boolean, or an enum value. The comparison operator should be one of =, !=, >, <, >=, <=, or : for prefix or wildcard matches. For example, to filter to a specific domain name, use an expression like `domainName=\"example.com\"`. You can also check for the existence of a field; for example, to find domains using custom DNS settings, use an expression like `dnsSettings.customDns:*`. You can also create compound filters by combining expressions with the `AND` and `OR` operators. For example, to find domains that are suspended or have specific issues flagged, use an expression like `(state=SUSPENDED) OR (issue:*)`."
  ([parent] (projects-locations-registrations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+parent}/registrations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-registrations-register
  "Registers a new domain name and creates a corresponding `Registration` resource. Call `RetrieveRegisterParameters` first to check availability of the domain name and determine parameters like price that are needed to build a call to this method. A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the domain was not registered successfully, and you can safely delete the resource and retry registration.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/register

parent <string> Required. The parent resource of the `Registration`. Must be in the format `projects/*/locations/*`.
RegisterDomainRequest:
{:registration
 {:transferFailureReason
  [TRANSFER_FAILURE_REASON_UNSPECIFIED
   TRANSFER_FAILURE_REASON_UNKNOWN
   EMAIL_CONFIRMATION_FAILURE
   DOMAIN_NOT_REGISTERED
   DOMAIN_HAS_TRANSFER_LOCK
   INVALID_AUTHORIZATION_CODE
   TRANSFER_CANCELLED
   TRANSFER_REJECTED
   INVALID_REGISTRANT_EMAIL_ADDRESS
   DOMAIN_NOT_ELIGIBLE_FOR_TRANSFER
   TRANSFER_ALREADY_PENDING],
  :labels object,
  :supportedPrivacy
  [[CONTACT_PRIVACY_UNSPECIFIED
    PUBLIC_CONTACT_DATA
    PRIVATE_CONTACT_DATA
    REDACTED_CONTACT_DATA]],
  :dnsSettings
  {:customDns
   {:nameServers [string],
    :dsRecords
    [{:keyTag integer,
      :algorithm
      [ALGORITHM_UNSPECIFIED
       RSAMD5
       DH
       DSA
       ECC
       RSASHA1
       DSANSEC3SHA1
       RSASHA1NSEC3SHA1
       RSASHA256
       RSASHA512
       ECCGOST
       ECDSAP256SHA256
       ECDSAP384SHA384
       ED25519
       ED448
       INDIRECT
       PRIVATEDNS
       PRIVATEOID],
      :digestType
      [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
      :digest string}]},
   :googleDomainsDns
   {:nameServers [string],
    :dsState
    [DS_STATE_UNSPECIFIED DS_RECORDS_UNPUBLISHED DS_RECORDS_PUBLISHED],
    :dsRecords
    [{:keyTag integer,
      :algorithm
      [ALGORITHM_UNSPECIFIED
       RSAMD5
       DH
       DSA
       ECC
       RSASHA1
       DSANSEC3SHA1
       RSASHA1NSEC3SHA1
       RSASHA256
       RSASHA512
       ECCGOST
       ECDSAP256SHA256
       ECDSAP384SHA384
       ED25519
       ED448
       INDIRECT
       PRIVATEDNS
       PRIVATEOID],
      :digestType
      [DIGEST_TYPE_UNSPECIFIED SHA1 SHA256 GOST3411 SHA384],
      :digest string}]},
   :glueRecords
   [{:hostName string,
     :ipv4Addresses [string],
     :ipv6Addresses [string]}],
   :googleDomainsRedirectsDataAvailable boolean},
  :issues
  [[ISSUE_UNSPECIFIED
    CONTACT_SUPPORT
    UNVERIFIED_EMAIL
    PROBLEM_WITH_BILLING
    DNS_NOT_ACTIVATED]],
  :name string,
  :registerFailureReason
  [REGISTER_FAILURE_REASON_UNSPECIFIED
   REGISTER_FAILURE_REASON_UNKNOWN
   DOMAIN_NOT_AVAILABLE
   INVALID_CONTACTS],
  :createTime string,
  :managementSettings
  {:renewalMethod
   [RENEWAL_METHOD_UNSPECIFIED
    AUTOMATIC_RENEWAL
    MANUAL_RENEWAL
    RENEWAL_DISABLED],
   :preferredRenewalMethod
   [RENEWAL_METHOD_UNSPECIFIED
    AUTOMATIC_RENEWAL
    MANUAL_RENEWAL
    RENEWAL_DISABLED],
   :transferLockState
   [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED],
   :effectiveTransferLockState
   [TRANSFER_LOCK_STATE_UNSPECIFIED UNLOCKED LOCKED]},
  :contactSettings
  {:privacy
   [CONTACT_PRIVACY_UNSPECIFIED
    PUBLIC_CONTACT_DATA
    PRIVATE_CONTACT_DATA
    REDACTED_CONTACT_DATA],
   :registrantContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :adminContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :technicalContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string}},
  :state
  [STATE_UNSPECIFIED
   REGISTRATION_PENDING
   REGISTRATION_FAILED
   TRANSFER_PENDING
   TRANSFER_FAILED
   IMPORT_PENDING
   ACTIVE
   SUSPENDED
   EXPORTED
   EXPIRED],
  :domainName string,
  :expireTime string,
  :pendingContactSettings
  {:privacy
   [CONTACT_PRIVACY_UNSPECIFIED
    PUBLIC_CONTACT_DATA
    PRIVATE_CONTACT_DATA
    REDACTED_CONTACT_DATA],
   :registrantContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :adminContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string},
   :technicalContact
   {:postalAddress
    {:sortingCode string,
     :locality string,
     :revision integer,
     :administrativeArea string,
     :addressLines [string],
     :organization string,
     :recipients [string],
     :languageCode string,
     :regionCode string,
     :postalCode string,
     :sublocality string},
    :email string,
    :phoneNumber string,
    :faxNumber string}},
  :domainProperties
  [[DOMAIN_PROPERTY_UNSPECIFIED
    TRANSFER_LOCK_UNSUPPORTED_BY_REGISTRY
    REQUIRE_PUSH_TRANSFER]]},
 :domainNotices [[DOMAIN_NOTICE_UNSPECIFIED HSTS_PRELOADED]],
 :contactNotices
 [[CONTACT_NOTICE_UNSPECIFIED PUBLIC_CONTACT_DATA_ACKNOWLEDGEMENT]],
 :yearlyPrice {:currencyCode string, :units string, :nanos integer},
 :validateOnly boolean}"
  [parent RegisterDomainRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+parent}/registrations:register",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RegisterDomainRequest}))

(defn projects-locations-registrations-retrieveGoogleDomainsForwardingConfig
  "Lists the deprecated domain and email forwarding configurations you set up in the deprecated Google Domains UI. The configuration is present only for domains with the `google_domains_redirects_data_available` set to `true` in the `Registration`'s `dns_settings`. A forwarding configuration might not work correctly if required DNS records are not present in the domain's authoritative DNS Zone.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/retrieveGoogleDomainsForwardingConfig

registration <string> Required. The name of the `Registration` whose Google Domains forwarding configuration details are being retrieved, in the format `projects/*/locations/*/registrations/*`."
  [registration]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:retrieveGoogleDomainsForwardingConfig",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-registrations-retrieveAuthorizationCode
  "Gets the authorization code of the `Registration` for the purpose of transferring the domain to another registrar. You can call this method only after 60 days have elapsed since the initial domain registration. Domains that have the `REQUIRE_PUSH_TRANSFER` property in the list of `domain_properties` don't support authorization codes and must use the `InitiatePushTransfer` method to initiate the process to transfer the domain to a different registrar.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/retrieveAuthorizationCode

registration <string> Required. The name of the `Registration` whose authorization code is being retrieved, in the format `projects/*/locations/*/registrations/*`."
  [registration]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://domains.googleapis.com/v1/{+registration}:retrieveAuthorizationCode",
     :uri-template-args {:registration registration},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-registrations-searchDomains
  "Searches for available domain names similar to the provided query. Availability results from this method are approximate; call `RetrieveRegisterParameters` on a domain before registering to confirm availability.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/searchDomains

location <string> Required. The location. Must be in the format `projects/*/locations/*`.

optional:
query <string> Required. String used to search for available domain names."
  ([location]
    (projects-locations-registrations-searchDomains location nil))
  ([location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://domains.googleapis.com/v1/{+location}/registrations:searchDomains",
       :uri-template-args {:location location},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-registrations-import
  "Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Imports a domain name from [Google Domains](https://domains.google/) for use in Cloud Domains. To transfer a domain from another registrar, use the `TransferDomain` method instead. Since individual users can own domains in Google Domains, the calling user must have ownership permission on the domain.
https://cloud.google.com/domains/docs/reference/rest/v1/projects.locations.registrations/import

parent <string> Required. The parent resource of the Registration. Must be in the format `projects/*/locations/*`.
ImportDomainRequest:
{:domainName string, :labels object}"
  [parent ImportDomainRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://domains.googleapis.com/v1/{+parent}/registrations:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ImportDomainRequest}))

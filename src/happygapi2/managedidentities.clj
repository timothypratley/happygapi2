(ns happygapi2.managedidentities
  "Managed Service for Microsoft Active Directory API
The Managed Service for Microsoft Active Directory API is used for managing a highly available, hardened service running Microsoft Active Directory (AD).
See: https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-global-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-global-domains-get
  "Gets information about a domain.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/get

name <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-domains-disableMigration
  "Disable Domain Migration
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/disableMigration

domain <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
DisableMigrationRequest:
object"
  [domain DisableMigrationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+domain}:disableMigration",
     :uri-template-args {:domain domain},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DisableMigrationRequest}))

(defn projects-locations-global-domains-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-global-domains-patch
  "Updates the metadata and configuration of a domain.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/patch

name <string> Required. The unique name of the domain using the form: `projects/{project_id}/locations/global/domains/{domain_name}`.
Domain:
{:labels object,
 :admin string,
 :name string,
 :reservedIpRange string,
 :statusMessage string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  UPDATING
  DELETING
  REPAIRING
  PERFORMING_MAINTENANCE
  UNAVAILABLE],
 :fqdn string,
 :updateTime string,
 :locations [string],
 :authorizedNetworks [string],
 :auditLogsEnabled boolean,
 :trusts
 [{:trustDirection
   [TRUST_DIRECTION_UNSPECIFIED INBOUND OUTBOUND BIDIRECTIONAL],
   :createTime string,
   :state
   [STATE_UNSPECIFIED
    CREATING
    UPDATING
    DELETING
    CONNECTED
    DISCONNECTED],
   :updateTime string,
   :targetDomainName string,
   :targetDnsIpAddresses [string],
   :trustHandshakeSecret string,
   :selectiveAuthentication boolean,
   :trustType [TRUST_TYPE_UNSPECIFIED FOREST EXTERNAL],
   :lastTrustHeartbeatTime string,
   :stateDescription string}]}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field. The elements of the repeated paths field may only include fields from Domain: * `labels` * `locations` * `authorized_networks` * `audit_logs_enabled`"
  ([name Domain]
    (projects-locations-global-domains-patch name Domain nil))
  ([name Domain optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Domain})))

(defn projects-locations-global-domains-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-global-domains-updateLdapssettings
  "Patches a single ldaps settings.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/updateLdapssettings

name <string> The resource name of the LDAPS settings. Uses the form: `projects/{project}/locations/{location}/domains/{domain}`.
LDAPSSettings:
{:name string,
 :certificate
 {:subject string,
  :thumbprint string,
  :subjectAlternativeName [string],
  :issuingCertificate
  {:subject string,
   :thumbprint string,
   :subjectAlternativeName [string],
   :issuingCertificate
   {:subject string,
    :thumbprint string,
    :subjectAlternativeName [string],
    :issuingCertificate
    {:subject string,
     :thumbprint string,
     :subjectAlternativeName [string],
     :issuingCertificate Certificate,
     :expireTime string},
    :expireTime string},
   :expireTime string},
  :expireTime string},
 :state [STATE_UNSPECIFIED UPDATING ACTIVE FAILED],
 :certificatePfx string,
 :certificatePassword string,
 :updateTime string}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name LDAPSSettings]
    (projects-locations-global-domains-updateLdapssettings
      name
      LDAPSSettings
      nil))
  ([name LDAPSSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+name}/ldapssettings",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body LDAPSSettings})))

(defn projects-locations-global-domains-restore
  "RestoreDomain restores domain backup mentioned in the RestoreDomainRequest
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/restore

name <string> Required. Resource name for the domain to which the backup belongs
RestoreDomainRequest:
{:backupId string}"
  [name RestoreDomainRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}:restore",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestoreDomainRequest}))

(defn projects-locations-global-domains-create
  "Creates a Microsoft AD domain.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/create

parent <string> Required. The resource project name and location using the form: `projects/{project_id}/locations/global`
Domain:
{:labels object,
 :admin string,
 :name string,
 :reservedIpRange string,
 :statusMessage string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  READY
  UPDATING
  DELETING
  REPAIRING
  PERFORMING_MAINTENANCE
  UNAVAILABLE],
 :fqdn string,
 :updateTime string,
 :locations [string],
 :authorizedNetworks [string],
 :auditLogsEnabled boolean,
 :trusts
 [{:trustDirection
   [TRUST_DIRECTION_UNSPECIFIED INBOUND OUTBOUND BIDIRECTIONAL],
   :createTime string,
   :state
   [STATE_UNSPECIFIED
    CREATING
    UPDATING
    DELETING
    CONNECTED
    DISCONNECTED],
   :updateTime string,
   :targetDomainName string,
   :targetDnsIpAddresses [string],
   :trustHandshakeSecret string,
   :selectiveAuthentication boolean,
   :trustType [TRUST_TYPE_UNSPECIFIED FOREST EXTERNAL],
   :lastTrustHeartbeatTime string,
   :stateDescription string}]}

optional:
domainName <string> Required. The fully qualified domain name. e.g. mydomain.myorganization.com, with the following restrictions: * Must contain only lowercase letters, numbers, periods and hyphens. * Must start with a letter. * Must contain between 2-64 characters. * Must end with a number or a letter. * Must not start with period. * First segment length (mydomain for example above) shouldn't exceed 15 chars. * The last segment cannot be fully numeric. * Must be unique within the customer project."
  ([parent Domain]
    (projects-locations-global-domains-create parent Domain nil))
  ([parent Domain optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+parent}/domains",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Domain})))

(defn projects-locations-global-domains-validateTrust
  "Validates a trust state, that the target domain is reachable, and that the target domain is able to accept incoming trust requests.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/validateTrust

name <string> Required. The resource domain name, project name, and location using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
ValidateTrustRequest:
{:trust
 {:trustDirection
  [TRUST_DIRECTION_UNSPECIFIED INBOUND OUTBOUND BIDIRECTIONAL],
  :createTime string,
  :state
  [STATE_UNSPECIFIED
   CREATING
   UPDATING
   DELETING
   CONNECTED
   DISCONNECTED],
  :updateTime string,
  :targetDomainName string,
  :targetDnsIpAddresses [string],
  :trustHandshakeSecret string,
  :selectiveAuthentication boolean,
  :trustType [TRUST_TYPE_UNSPECIFIED FOREST EXTERNAL],
  :lastTrustHeartbeatTime string,
  :stateDescription string}}"
  [name ValidateTrustRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}:validateTrust",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ValidateTrustRequest}))

(defn projects-locations-global-domains-getLdapssettings
  "Gets the domain ldaps settings.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/getLdapssettings

name <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}/ldapssettings",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-domains-checkMigrationPermission
  "CheckMigrationPermission API gets the current state of DomainMigration
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/checkMigrationPermission

domain <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
CheckMigrationPermissionRequest:
object"
  [domain CheckMigrationPermissionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+domain}:checkMigrationPermission",
     :uri-template-args {:domain domain},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CheckMigrationPermissionRequest}))

(defn projects-locations-global-domains-delete
  "Deletes a domain.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/delete

name <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-domains-detachTrust
  "Removes an AD trust.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/detachTrust

name <string> Required. The resource domain name, project name, and location using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
DetachTrustRequest:
{:trust
 {:trustDirection
  [TRUST_DIRECTION_UNSPECIFIED INBOUND OUTBOUND BIDIRECTIONAL],
  :createTime string,
  :state
  [STATE_UNSPECIFIED
   CREATING
   UPDATING
   DELETING
   CONNECTED
   DISCONNECTED],
  :updateTime string,
  :targetDomainName string,
  :targetDnsIpAddresses [string],
  :trustHandshakeSecret string,
  :selectiveAuthentication boolean,
  :trustType [TRUST_TYPE_UNSPECIFIED FOREST EXTERNAL],
  :lastTrustHeartbeatTime string,
  :stateDescription string}}"
  [name DetachTrustRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}:detachTrust",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DetachTrustRequest}))

(defn projects-locations-global-domains-extendSchema
  "Extend Schema for Domain
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/extendSchema

domain <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
ExtendSchemaRequest:
{:description string, :gcsPath string, :fileContents string}"
  [domain ExtendSchemaRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+domain}:extendSchema",
     :uri-template-args {:domain domain},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExtendSchemaRequest}))

(defn projects-locations-global-domains-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-global-domains-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-domains-list
  "Lists domains in a project.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/list

parent <string> Required. The resource name of the domain location using the form: `projects/{project_id}/locations/global`

optional:
pageSize <integer> Optional. The maximum number of items to return. If not specified, a default value of 1000 will be used. Regardless of the page_size value, the response may include a partial list. Callers should rely on a response's next_page_token to determine if there are additional results to list.
filter <string> Optional. A filter specifying constraints of a list operation. For example, `Domain.fqdn=\"mydomain.myorginization\"`.
orderBy <string> Optional. Specifies the ordering of results. See [Sorting order](https://cloud.google.com/apis/design/design_patterns#sorting_order) for more information."
  ([parent] (projects-locations-global-domains-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+parent}/domains",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-domains-domainJoinMachine
  "DomainJoinMachine API joins a Compute Engine VM to the domain
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/domainJoinMachine

domain <string> Required. The domain resource name using the form: projects/{project_id}/locations/global/domains/{domain_name}
DomainJoinMachineRequest:
{:vmIdToken string, :ouName string, :force boolean}"
  [domain DomainJoinMachineRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+domain}:domainJoinMachine",
     :uri-template-args {:domain domain},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DomainJoinMachineRequest}))

(defn projects-locations-global-domains-resetAdminPassword
  "Resets a domain's administrator password.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/resetAdminPassword

name <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
ResetAdminPasswordRequest:
object"
  [name ResetAdminPasswordRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}:resetAdminPassword",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResetAdminPasswordRequest}))

(defn projects-locations-global-domains-enableMigration
  "Enable Domain Migration
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/enableMigration

domain <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
EnableMigrationRequest:
{:migratingDomains [{:domainName string, :disableSidFiltering boolean}]}"
  [domain EnableMigrationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+domain}:enableMigration",
     :uri-template-args {:domain domain},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EnableMigrationRequest}))

(defn projects-locations-global-domains-attachTrust
  "Adds an AD trust to a domain.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/attachTrust

name <string> Required. The resource domain name, project name and location using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
AttachTrustRequest:
{:trust
 {:trustDirection
  [TRUST_DIRECTION_UNSPECIFIED INBOUND OUTBOUND BIDIRECTIONAL],
  :createTime string,
  :state
  [STATE_UNSPECIFIED
   CREATING
   UPDATING
   DELETING
   CONNECTED
   DISCONNECTED],
  :updateTime string,
  :targetDomainName string,
  :targetDnsIpAddresses [string],
  :trustHandshakeSecret string,
  :selectiveAuthentication boolean,
  :trustType [TRUST_TYPE_UNSPECIFIED FOREST EXTERNAL],
  :lastTrustHeartbeatTime string,
  :stateDescription string}}"
  [name AttachTrustRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}:attachTrust",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AttachTrustRequest}))

(defn projects-locations-global-domains-reconfigureTrust
  "Updates the DNS conditional forwarder.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/reconfigureTrust

name <string> Required. The resource domain name, project name and location using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
ReconfigureTrustRequest:
{:targetDomainName string, :targetDnsIpAddresses [string]}"
  [name ReconfigureTrustRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}:reconfigureTrust",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ReconfigureTrustRequest}))

(defn projects-locations-global-domains-backups-create
  "Creates a Backup for a domain.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/create

parent <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`
Backup:
{:name string,
 :labels object,
 :createTime string,
 :updateTime string,
 :type [TYPE_UNSPECIFIED ON_DEMAND SCHEDULED],
 :state [STATE_UNSPECIFIED CREATING ACTIVE FAILED DELETING],
 :statusMessage string}

optional:
backupId <string> Required. Backup Id, unique name to identify the backups with the following restrictions: * Must be lowercase letters, numbers, and hyphens * Must start with a letter. * Must contain between 1-63 characters. * Must end with a number or a letter. * Must be unique within the domain."
  ([parent Backup]
    (projects-locations-global-domains-backups-create
      parent
      Backup
      nil))
  ([parent Backup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-global-domains-backups-list
  "Lists Backup in a given project.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/list

parent <string> Required. The domain resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}`

optional:
pageSize <integer> Optional. The maximum number of items to return. If not specified, a default value of 1000 will be used by the service. Regardless of the page_size value, the response may include a partial list and a caller should only rely on response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Filter specifying constraints of a list operation.
orderBy <string> Optional. Specifies the ordering of results following syntax at https://cloud.google.com/apis/design/design_patterns#sorting_order."
  ([parent]
    (projects-locations-global-domains-backups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-domains-backups-get
  "Gets details of a single Backup.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/get

name <string> Required. The backup resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}/backups/{backup_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-domains-backups-patch
  "Updates the labels for specified Backup.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/patch

name <string> Output only. The unique name of the Backup in the form of `projects/{project_id}/locations/global/domains/{domain_name}/backups/{name}`
Backup:
{:name string,
 :labels object,
 :createTime string,
 :updateTime string,
 :type [TYPE_UNSPECIFIED ON_DEMAND SCHEDULED],
 :state [STATE_UNSPECIFIED CREATING ACTIVE FAILED DELETING],
 :statusMessage string}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field. The elements of the repeated paths field may only include these fields from Backup: * `labels`"
  ([name Backup]
    (projects-locations-global-domains-backups-patch name Backup nil))
  ([name Backup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-global-domains-backups-delete
  "Deletes identified Backup.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/delete

name <string> Required. The backup resource name using the form: `projects/{project_id}/locations/global/domains/{domain_name}/backups/{backup_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-domains-backups-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-global-domains-backups-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-global-domains-backups-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-domains-backups-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/backups/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-global-domains-sqlIntegrations-list
  "Lists SqlIntegrations in a given domain.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/sqlIntegrations/list

parent <string> Required. The resource name of the SqlIntegrations using the form: `projects/{project_id}/locations/global/domains/*`

optional:
pageSize <integer> Optional. The maximum number of items to return. If not specified, a default value of 1000 will be used by the service. Regardless of the page_size value, the response may include a partial list and a caller should only rely on response'ANIZATIONs next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Filter specifying constraints of a list operation. For example, `SqlIntegration.name=\"sql\"`.
orderBy <string> Optional. Specifies the ordering of results following syntax at https://cloud.google.com/apis/design/design_patterns#sorting_order."
  ([parent]
    (projects-locations-global-domains-sqlIntegrations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+parent}/sqlIntegrations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-domains-sqlIntegrations-get
  "Gets details of a single sqlIntegration.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/domains/sqlIntegrations/get

name <string> Required. SQLIntegration resource name using the form: `projects/{project_id}/locations/global/domains/{domain}/sqlIntegrations/{name}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-peerings-create
  "Creates a Peering for Managed AD instance.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/create

parent <string> Required. Resource project name and location using the form: `projects/{project_id}/locations/global`
Peering:
{:name string,
 :labels object,
 :authorizedNetwork string,
 :domainResource string,
 :createTime string,
 :updateTime string,
 :state [STATE_UNSPECIFIED CREATING CONNECTED DISCONNECTED DELETING],
 :statusMessage string}

optional:
peeringId <string> Required. Peering Id, unique name to identify peering. It should follow the regex format \"^(?:[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?)$\""
  ([parent Peering]
    (projects-locations-global-peerings-create parent Peering nil))
  ([parent Peering optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+parent}/peerings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Peering})))

(defn projects-locations-global-peerings-list
  "Lists Peerings in a given project.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/list

parent <string> Required. The resource name of the peering location using the form: `projects/{project_id}/locations/global`

optional:
pageSize <integer> Optional. The maximum number of items to return. If not specified, a default value of 1000 will be used by the service. Regardless of the page_size value, the response may include a partial list and a caller should only rely on response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Filter specifying constraints of a list operation. For example, `peering.authorized_network=\"projects/myprojectid/global/networks/mynetwork\"`.
orderBy <string> Optional. Specifies the ordering of results following syntax at https://cloud.google.com/apis/design/design_patterns#sorting_order."
  ([parent] (projects-locations-global-peerings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+parent}/peerings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-peerings-get
  "Gets details of a single Peering.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/get

name <string> Required. Peering resource name using the form: `projects/{project_id}/locations/global/peerings/{peering_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-peerings-patch
  "Updates the labels for specified Peering.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/patch

name <string> Output only. Unique name of the peering in this scope including projects and location using the form: `projects/{project_id}/locations/global/peerings/{peering_id}`.
Peering:
{:name string,
 :labels object,
 :authorizedNetwork string,
 :domainResource string,
 :createTime string,
 :updateTime string,
 :state [STATE_UNSPECIFIED CREATING CONNECTED DISCONNECTED DELETING],
 :statusMessage string}

optional:
updateMask <string> Required. Mask of fields to update. At least one path must be supplied in this field. The elements of the repeated paths field may only include these fields from Peering: * `labels`"
  ([name Peering]
    (projects-locations-global-peerings-patch name Peering nil))
  ([name Peering optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Peering})))

(defn projects-locations-global-peerings-delete
  "Deletes identified Peering.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/delete

name <string> Required. Peering resource name using the form: `projects/{project_id}/locations/global/peerings/{peering_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-peerings-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-global-peerings-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-global-peerings-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://managedidentities.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-global-peerings-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/managed-microsoft-ad/docs/overview/v1/docs/projects/locations/global/peerings/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://managedidentities.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

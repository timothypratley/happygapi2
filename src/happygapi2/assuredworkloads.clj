(ns happygapi2.assuredworkloads
  "Assured Workloads API

See: https://cloud.google.com/learnmoreurl"
  (:require [happy.oauth2.client :as client]))

(defn organizations-locations-workloads-get
  "Gets Assured Workload associated with a CRM Node
https://cloud.google.com/learnmoreurl

name <string> Required. The resource name of the Workload to fetch. This is the workloads's relative path in the API, formatted as \"organizations/{organization_id}/locations/{location_id}/workloads/{workload_id}\". For example, \"organizations/123/locations/us-east1/workloads/assured-workload-1\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://assuredworkloads.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-workloads-patch
  "Updates an existing workload. Currently allows updating of workload display_name and labels. For force updates don't set etag field in the Workload. Only one update operation per workload can be in progress.
https://cloud.google.com/learnmoreurl

name <string> Optional. The resource name of the workload. Format: organizations/{organization}/locations/{location}/workloads/{workload} Read-only.
GoogleCloudAssuredworkloadsV1Workload:
{:provisionedResourcesParent string,
 :compliantButDisallowedServices [string],
 :labels object,
 :kmsSettings {:rotationPeriod string, :nextRotationTime string},
 :partnerPermissions
 {:assuredWorkloadsMonitoring boolean,
  :serviceAccessApprover boolean,
  :dataLogsViewer boolean},
 :billingAccount string,
 :complianceStatus
 {:activeViolationCount integer,
  :acknowledgedResourceViolationCount integer,
  :acknowledgedViolationCount integer,
  :activeResourceViolationCount integer},
 :partner
 [PARTNER_UNSPECIFIED
  LOCAL_CONTROLS_BY_S3NS
  SOVEREIGN_CONTROLS_BY_T_SYSTEMS
  SOVEREIGN_CONTROLS_BY_SIA_MINSAIT
  SOVEREIGN_CONTROLS_BY_PSN],
 :resourceMonitoringEnabled boolean,
 :displayName string,
 :name string,
 :createTime string,
 :ekmProvisioningResponse
 {:ekmProvisioningState
  [EKM_PROVISIONING_STATE_UNSPECIFIED
   EKM_PROVISIONING_STATE_PENDING
   EKM_PROVISIONING_STATE_FAILED
   EKM_PROVISIONING_STATE_COMPLETED],
  :ekmProvisioningErrorDomain
  [EKM_PROVISIONING_ERROR_DOMAIN_UNSPECIFIED
   UNSPECIFIED_ERROR
   GOOGLE_SERVER_ERROR
   EXTERNAL_USER_ERROR
   EXTERNAL_PARTNER_ERROR
   TIMEOUT_ERROR],
  :ekmProvisioningErrorMapping
  [EKM_PROVISIONING_ERROR_MAPPING_UNSPECIFIED
   INVALID_SERVICE_ACCOUNT
   MISSING_METRICS_SCOPE_ADMIN_PERMISSION
   MISSING_EKM_CONNECTION_ADMIN_PERMISSION]},
 :etag string,
 :violationNotificationsEnabled boolean,
 :complianceRegime
 [COMPLIANCE_REGIME_UNSPECIFIED
  IL4
  CJIS
  FEDRAMP_HIGH
  FEDRAMP_MODERATE
  US_REGIONAL_ACCESS
  REGIONAL_CONTROLS_PREMIUM_US
  HIPAA
  HITRUST
  EU_REGIONS_AND_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_EU
  CA_REGIONS_AND_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_CA
  ITAR
  AU_REGIONS_AND_US_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_AU
  ASSURED_WORKLOADS_FOR_PARTNERS
  ISR_REGIONS
  REGIONAL_CONTROLS_PREMIUM_ISR
  ISR_REGIONS_AND_SUPPORT
  CA_PROTECTED_B
  IL5
  IL2
  JP_REGIONS_AND_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_JP
  KSA_REGIONS_AND_SUPPORT_WITH_SOVEREIGNTY_CONTROLS
  REGIONAL_CONTROLS],
 :saaEnrollmentResponse
 {:setupErrors
  [[SETUP_ERROR_UNSPECIFIED
    ERROR_INVALID_BASE_SETUP
    ERROR_MISSING_EXTERNAL_SIGNING_KEY
    ERROR_NOT_ALL_SERVICES_ENROLLED
    ERROR_SETUP_CHECK_FAILED]],
  :setupStatus
  [SETUP_STATE_UNSPECIFIED STATUS_PENDING STATUS_COMPLETE]},
 :resourceSettings
 [{:displayName string,
   :resourceId string,
   :resourceType
   [RESOURCE_TYPE_UNSPECIFIED
    CONSUMER_PROJECT
    CONSUMER_FOLDER
    ENCRYPTION_KEYS_PROJECT
    KEYRING]}],
 :kajEnrollmentState
 [KAJ_ENROLLMENT_STATE_UNSPECIFIED
  KAJ_ENROLLMENT_STATE_PENDING
  KAJ_ENROLLMENT_STATE_COMPLETE],
 :enableSovereignControls boolean,
 :resources
 [{:resourceType
   [RESOURCE_TYPE_UNSPECIFIED
    CONSUMER_PROJECT
    CONSUMER_FOLDER
    ENCRYPTION_KEYS_PROJECT
    KEYRING],
   :resourceId string}]}

optional:
updateMask <string> Required. The list of fields to be updated."
  ([name GoogleCloudAssuredworkloadsV1Workload]
    (organizations-locations-workloads-patch
      name
      GoogleCloudAssuredworkloadsV1Workload
      nil))
  ([name GoogleCloudAssuredworkloadsV1Workload optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://assuredworkloads.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAssuredworkloadsV1Workload})))

(defn organizations-locations-workloads-analyzeWorkloadMove
  "Analyzes a hypothetical move of a source resource to a target workload to surface compliance risks. The analysis is best effort and is not guaranteed to be exhaustive.
https://cloud.google.com/learnmoreurl

target <string> Required. The resource ID of the folder-based destination workload. This workload is where the source resource will hypothetically be moved to. Specify the workload's relative resource name, formatted as: \"organizations/{ORGANIZATION_ID}/locations/{LOCATION_ID}/workloads/{WORKLOAD_ID}\" For example: \"organizations/123/locations/us-east1/workloads/assured-workload-2\"

optional:
pageSize <integer> Optional. Page size. If a value is not specified, the default value of 10 is used.
assetTypes <string> Optional. List of asset types to be analyzed, including and under the source resource. If empty, all assets are analyzed. The complete list of asset types is available [here](https://cloud.google.com/asset-inventory/docs/supported-asset-types).
project <string> The source type is a project. Specify the project's relative resource name, formatted as either a project number or a project ID: \"projects/{PROJECT_NUMBER}\" or \"projects/{PROJECT_ID}\" For example: \"projects/951040570662\" when specifying a project number, or \"projects/my-project-123\" when specifying a project ID."
  ([target]
    (organizations-locations-workloads-analyzeWorkloadMove target nil))
  ([target optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://assuredworkloads.googleapis.com/v1/{+target}:analyzeWorkloadMove",
       :uri-template-args {:target target},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-workloads-enableResourceMonitoring
  "Enable resource violation monitoring for a workload.
https://cloud.google.com/learnmoreurl

name <string> Required. The `name` field is used to identify the workload. Format: organizations/{org_id}/locations/{location_id}/workloads/{workload_id}"
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://assuredworkloads.googleapis.com/v1/{+name}:enableResourceMonitoring",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-workloads-create
  "Creates Assured Workload.
https://cloud.google.com/learnmoreurl

parent <string> Required. The resource name of the new Workload's parent. Must be of the form `organizations/{org_id}/locations/{location_id}`.
GoogleCloudAssuredworkloadsV1Workload:
{:provisionedResourcesParent string,
 :compliantButDisallowedServices [string],
 :labels object,
 :kmsSettings {:rotationPeriod string, :nextRotationTime string},
 :partnerPermissions
 {:assuredWorkloadsMonitoring boolean,
  :serviceAccessApprover boolean,
  :dataLogsViewer boolean},
 :billingAccount string,
 :complianceStatus
 {:activeViolationCount integer,
  :acknowledgedResourceViolationCount integer,
  :acknowledgedViolationCount integer,
  :activeResourceViolationCount integer},
 :partner
 [PARTNER_UNSPECIFIED
  LOCAL_CONTROLS_BY_S3NS
  SOVEREIGN_CONTROLS_BY_T_SYSTEMS
  SOVEREIGN_CONTROLS_BY_SIA_MINSAIT
  SOVEREIGN_CONTROLS_BY_PSN],
 :resourceMonitoringEnabled boolean,
 :displayName string,
 :name string,
 :createTime string,
 :ekmProvisioningResponse
 {:ekmProvisioningState
  [EKM_PROVISIONING_STATE_UNSPECIFIED
   EKM_PROVISIONING_STATE_PENDING
   EKM_PROVISIONING_STATE_FAILED
   EKM_PROVISIONING_STATE_COMPLETED],
  :ekmProvisioningErrorDomain
  [EKM_PROVISIONING_ERROR_DOMAIN_UNSPECIFIED
   UNSPECIFIED_ERROR
   GOOGLE_SERVER_ERROR
   EXTERNAL_USER_ERROR
   EXTERNAL_PARTNER_ERROR
   TIMEOUT_ERROR],
  :ekmProvisioningErrorMapping
  [EKM_PROVISIONING_ERROR_MAPPING_UNSPECIFIED
   INVALID_SERVICE_ACCOUNT
   MISSING_METRICS_SCOPE_ADMIN_PERMISSION
   MISSING_EKM_CONNECTION_ADMIN_PERMISSION]},
 :etag string,
 :violationNotificationsEnabled boolean,
 :complianceRegime
 [COMPLIANCE_REGIME_UNSPECIFIED
  IL4
  CJIS
  FEDRAMP_HIGH
  FEDRAMP_MODERATE
  US_REGIONAL_ACCESS
  REGIONAL_CONTROLS_PREMIUM_US
  HIPAA
  HITRUST
  EU_REGIONS_AND_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_EU
  CA_REGIONS_AND_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_CA
  ITAR
  AU_REGIONS_AND_US_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_AU
  ASSURED_WORKLOADS_FOR_PARTNERS
  ISR_REGIONS
  REGIONAL_CONTROLS_PREMIUM_ISR
  ISR_REGIONS_AND_SUPPORT
  CA_PROTECTED_B
  IL5
  IL2
  JP_REGIONS_AND_SUPPORT
  REGIONAL_CONTROLS_PREMIUM_JP
  KSA_REGIONS_AND_SUPPORT_WITH_SOVEREIGNTY_CONTROLS
  REGIONAL_CONTROLS],
 :saaEnrollmentResponse
 {:setupErrors
  [[SETUP_ERROR_UNSPECIFIED
    ERROR_INVALID_BASE_SETUP
    ERROR_MISSING_EXTERNAL_SIGNING_KEY
    ERROR_NOT_ALL_SERVICES_ENROLLED
    ERROR_SETUP_CHECK_FAILED]],
  :setupStatus
  [SETUP_STATE_UNSPECIFIED STATUS_PENDING STATUS_COMPLETE]},
 :resourceSettings
 [{:displayName string,
   :resourceId string,
   :resourceType
   [RESOURCE_TYPE_UNSPECIFIED
    CONSUMER_PROJECT
    CONSUMER_FOLDER
    ENCRYPTION_KEYS_PROJECT
    KEYRING]}],
 :kajEnrollmentState
 [KAJ_ENROLLMENT_STATE_UNSPECIFIED
  KAJ_ENROLLMENT_STATE_PENDING
  KAJ_ENROLLMENT_STATE_COMPLETE],
 :enableSovereignControls boolean,
 :resources
 [{:resourceType
   [RESOURCE_TYPE_UNSPECIFIED
    CONSUMER_PROJECT
    CONSUMER_FOLDER
    ENCRYPTION_KEYS_PROJECT
    KEYRING],
   :resourceId string}]}

optional:
externalId <string> Optional. A identifier associated with the workload and underlying projects which allows for the break down of billing costs for a workload. The value provided for the identifier will add a label to the workload and contained projects with the identifier as the value."
  ([parent GoogleCloudAssuredworkloadsV1Workload]
    (organizations-locations-workloads-create
      parent
      GoogleCloudAssuredworkloadsV1Workload
      nil))
  ([parent GoogleCloudAssuredworkloadsV1Workload optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://assuredworkloads.googleapis.com/v1/{+parent}/workloads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudAssuredworkloadsV1Workload})))

(defn organizations-locations-workloads-restrictAllowedResources
  "Restrict the list of resources allowed in the Workload environment. The current list of allowed products can be found at https://cloud.google.com/assured-workloads/docs/supported-products In addition to assuredworkloads.workload.update permission, the user should also have orgpolicy.policy.set permission on the folder resource to use this functionality.
https://cloud.google.com/learnmoreurl

name <string> Required. The resource name of the Workload. This is the workloads's relative path in the API, formatted as \"organizations/{organization_id}/locations/{location_id}/workloads/{workload_id}\". For example, \"organizations/123/locations/us-east1/workloads/assured-workload-1\".
GoogleCloudAssuredworkloadsV1RestrictAllowedResourcesRequest:
{:restrictionType
 [RESTRICTION_TYPE_UNSPECIFIED
  ALLOW_ALL_GCP_RESOURCES
  ALLOW_COMPLIANT_RESOURCES
  APPEND_COMPLIANT_RESOURCES]}"
  [name GoogleCloudAssuredworkloadsV1RestrictAllowedResourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://assuredworkloads.googleapis.com/v1/{+name}:restrictAllowedResources",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAssuredworkloadsV1RestrictAllowedResourcesRequest}))

(defn organizations-locations-workloads-delete
  "Deletes the workload. Make sure that workload's direct children are already in a deleted state, otherwise the request will fail with a FAILED_PRECONDITION error. In addition to assuredworkloads.workload.delete permission, the user should also have orgpolicy.policy.set permission on the deleted folder to remove Assured Workloads OrgPolicies.
https://cloud.google.com/learnmoreurl

name <string> Required. The `name` field is used to identify the workload. Format: organizations/{org_id}/locations/{location_id}/workloads/{workload_id}

optional:
etag <string> Optional. The etag of the workload. If this is provided, it must match the server's etag."
  ([name] (organizations-locations-workloads-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://assuredworkloads.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-workloads-list
  "Lists Assured Workloads under a CRM Node.
https://cloud.google.com/learnmoreurl

parent <string> Required. Parent Resource to list workloads from. Must be of the form `organizations/{org_id}/locations/{location}`.

optional:
filter <string> A custom filter for filtering by properties of a workload. At this time, only filtering by labels is supported.
pageSize <integer> Page size."
  ([parent] (organizations-locations-workloads-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://assuredworkloads.googleapis.com/v1/{+parent}/workloads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-workloads-mutatePartnerPermissions
  "Update the permissions settings for an existing partner workload. For force updates don't set etag field in the Workload. Only one update operation per workload can be in progress.
https://cloud.google.com/learnmoreurl

name <string> Required. The `name` field is used to identify the workload. Format: organizations/{org_id}/locations/{location_id}/workloads/{workload_id}
GoogleCloudAssuredworkloadsV1MutatePartnerPermissionsRequest:
{:partnerPermissions
 {:assuredWorkloadsMonitoring boolean,
  :serviceAccessApprover boolean,
  :dataLogsViewer boolean},
 :updateMask string,
 :etag string}"
  [name GoogleCloudAssuredworkloadsV1MutatePartnerPermissionsRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://assuredworkloads.googleapis.com/v1/{+name}:mutatePartnerPermissions",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudAssuredworkloadsV1MutatePartnerPermissionsRequest}))

(defn organizations-locations-workloads-violations-list
  "Lists the Violations in the AssuredWorkload Environment. Callers may also choose to read across multiple Workloads as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard character instead of workload-id in the parent. Format `organizations/{org_id}/locations/{location}/workloads/-`
https://cloud.google.com/learnmoreurl

parent <string> Required. The Workload name. Format `organizations/{org_id}/locations/{location}/workloads/{workload}`.

optional:
interval.endTime <string> The end of the time window.
pageSize <integer> Optional. Page size.
filter <string> Optional. A custom filter for filtering by the Violations properties.
interval.startTime <string> The start of the time window."
  ([parent]
    (organizations-locations-workloads-violations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://assuredworkloads.googleapis.com/v1/{+parent}/violations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-workloads-violations-get
  "Retrieves Assured Workload Violation based on ID.
https://cloud.google.com/learnmoreurl

name <string> Required. The resource name of the Violation to fetch (ie. Violation.name). Format: organizations/{organization}/locations/{location}/workloads/{workload}/violations/{violation}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://assuredworkloads.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-workloads-violations-acknowledge
  "Acknowledges an existing violation. By acknowledging a violation, users acknowledge the existence of a compliance violation in their workload and decide to ignore it due to a valid business justification. Acknowledgement is a permanent operation and it cannot be reverted.
https://cloud.google.com/learnmoreurl

name <string> Required. The resource name of the Violation to acknowledge. Format: organizations/{organization}/locations/{location}/workloads/{workload}/violations/{violation}
GoogleCloudAssuredworkloadsV1AcknowledgeViolationRequest:
{:comment string,
 :nonCompliantOrgPolicy string,
 :acknowledgeType
 [ACKNOWLEDGE_TYPE_UNSPECIFIED
  SINGLE_VIOLATION
  EXISTING_CHILD_RESOURCE_VIOLATIONS]}"
  [name GoogleCloudAssuredworkloadsV1AcknowledgeViolationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://assuredworkloads.googleapis.com/v1/{+name}:acknowledge",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudAssuredworkloadsV1AcknowledgeViolationRequest}))

(defn organizations-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/learnmoreurl

name <string> The name of the operation's parent resource.

optional:
pageSize <integer> The standard list page size.
filter <string> The standard list filter."
  ([name] (organizations-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://assuredworkloads.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/learnmoreurl

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://assuredworkloads.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

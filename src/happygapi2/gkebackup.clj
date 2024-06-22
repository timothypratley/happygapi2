(ns happygapi2.gkebackup
  "Backup for GKE API
Backup for GKE is a managed Kubernetes workload backup and restore service for GKE clusters.
See: https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-locations-backupPlans-create
  "Creates a new BackupPlan in a given location.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/create

parent <string> Required. The location within which to create the BackupPlan. Format: `projects/*/locations/*`
BackupPlan:
{:description string,
 :rpoRiskReason string,
 :backupSchedule
 {:cronSchedule string,
  :paused boolean,
  :rpoConfig
  {:targetRpoMinutes integer,
   :exclusionWindows
   [{:startTime
     {:hours integer,
      :minutes integer,
      :seconds integer,
      :nanos integer},
     :duration string,
     :singleOccurrenceDate
     {:year integer, :month integer, :day integer},
     :daily boolean,
     :daysOfWeek
     {:daysOfWeek
      [[DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY]]}}]},
  :nextScheduledBackupTime string},
 :labels object,
 :stateReason string,
 :deactivated boolean,
 :cluster string,
 :uid string,
 :name string,
 :protectedPodCount integer,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  CLUSTER_PENDING
  PROVISIONING
  READY
  FAILED
  DEACTIVATED
  DELETING],
 :updateTime string,
 :backupConfig
 {:allNamespaces boolean,
  :selectedNamespaces {:namespaces [string]},
  :selectedApplications
  {:namespacedNames [{:namespace string, :name string}]},
  :includeVolumeData boolean,
  :includeSecrets boolean,
  :encryptionKey {:gcpKmsEncryptionKey string},
  :permissiveMode boolean},
 :retentionPolicy
 {:backupDeleteLockDays integer,
  :backupRetainDays integer,
  :locked boolean},
 :rpoRiskLevel integer}

optional:
backupPlanId <string> Required. The client-provided short name for the BackupPlan resource. This name must: - be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII letters, numbers, and dashes - start with a lower-case letter - end with a lower-case letter or number - be unique within the set of BackupPlans in this location"
  ([parent BackupPlan]
    (projects-locations-backupPlans-create parent BackupPlan nil))
  ([parent BackupPlan optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/backupPlans",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body BackupPlan})))

(defn projects-locations-backupPlans-list
  "Lists BackupPlans in a given location.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/list

parent <string> Required. The location that contains the BackupPlans to list. Format: `projects/*/locations/*`

optional:
pageSize <integer> Optional. The target number of results to return in a single response. If not specified, a default value will be chosen by the service. Note that the response may include a partial list and a caller should only rely on the response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Field match expression used to filter the results.
orderBy <string> Optional. Field by which to sort the results."
  ([parent] (projects-locations-backupPlans-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/backupPlans",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-get
  "Retrieve the details of a single BackupPlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/get

name <string> Required. Fully qualified BackupPlan name. Format: `projects/*/locations/*/backupPlans/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-backupPlans-patch
  "Update a BackupPlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/patch

name <string> Output only. The full name of the BackupPlan resource. Format: `projects/*/locations/*/backupPlans/*`
BackupPlan:
{:description string,
 :rpoRiskReason string,
 :backupSchedule
 {:cronSchedule string,
  :paused boolean,
  :rpoConfig
  {:targetRpoMinutes integer,
   :exclusionWindows
   [{:startTime
     {:hours integer,
      :minutes integer,
      :seconds integer,
      :nanos integer},
     :duration string,
     :singleOccurrenceDate
     {:year integer, :month integer, :day integer},
     :daily boolean,
     :daysOfWeek
     {:daysOfWeek
      [[DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY]]}}]},
  :nextScheduledBackupTime string},
 :labels object,
 :stateReason string,
 :deactivated boolean,
 :cluster string,
 :uid string,
 :name string,
 :protectedPodCount integer,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  CLUSTER_PENDING
  PROVISIONING
  READY
  FAILED
  DEACTIVATED
  DELETING],
 :updateTime string,
 :backupConfig
 {:allNamespaces boolean,
  :selectedNamespaces {:namespaces [string]},
  :selectedApplications
  {:namespacedNames [{:namespace string, :name string}]},
  :includeVolumeData boolean,
  :includeSecrets boolean,
  :encryptionKey {:gcpKmsEncryptionKey string},
  :permissiveMode boolean},
 :retentionPolicy
 {:backupDeleteLockDays integer,
  :backupRetainDays integer,
  :locked boolean},
 :rpoRiskLevel integer}

optional:
updateMask <string> Optional. This is used to specify the fields to be overwritten in the BackupPlan targeted for update. The values for each of these updated fields will be taken from the `backup_plan` provided with this request. Field names are relative to the root of the resource (e.g., `description`, `backup_config.include_volume_data`, etc.) If no `update_mask` is provided, all fields in `backup_plan` will be written to the target BackupPlan resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `backup_plan` are ignored and are not used to update the target BackupPlan."
  ([name BackupPlan]
    (projects-locations-backupPlans-patch name BackupPlan nil))
  ([name BackupPlan optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body BackupPlan})))

(defn projects-locations-backupPlans-delete
  "Deletes an existing BackupPlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/delete

name <string> Required. Fully qualified BackupPlan name. Format: `projects/*/locations/*/backupPlans/*`

optional:
etag <string> Optional. If provided, this value must match the current value of the target BackupPlan's etag field or the request is rejected."
  ([name] (projects-locations-backupPlans-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/setIamPolicy

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
     "https://gkebackup.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-backupPlans-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-backupPlans-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-backupPlans-backups-get
  "Retrieve the details of a single Backup.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/get

name <string> Required. Full name of the Backup resource. Format: `projects/*/locations/*/backupPlans/*/backups/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-backupPlans-backups-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/setIamPolicy

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
     "https://gkebackup.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-backupPlans-backups-patch
  "Update a Backup.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/patch

name <string> Output only. The fully qualified name of the Backup. `projects/*/locations/*/backupPlans/*/backups/*`
Backup:
{:description string,
 :labels object,
 :stateReason string,
 :retainExpireTime string,
 :volumeCount integer,
 :containsVolumeData boolean,
 :podCount integer,
 :configBackupSizeBytes string,
 :uid string,
 :name string,
 :encryptionKey {:gcpKmsEncryptionKey string},
 :sizeBytes string,
 :clusterMetadata
 {:cluster string,
  :k8sVersion string,
  :backupCrdVersions object,
  :gkeVersion string,
  :anthosVersion string},
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED CREATING IN_PROGRESS SUCCEEDED FAILED DELETING],
 :resourceCount integer,
 :retainDays integer,
 :allNamespaces boolean,
 :deleteLockDays integer,
 :updateTime string,
 :manual boolean,
 :selectedApplications
 {:namespacedNames [{:namespace string, :name string}]},
 :completeTime string,
 :selectedNamespaces {:namespaces [string]},
 :deleteLockExpireTime string,
 :containsSecrets boolean,
 :permissiveMode boolean}

optional:
updateMask <string> Optional. This is used to specify the fields to be overwritten in the Backup targeted for update. The values for each of these updated fields will be taken from the `backup_plan` provided with this request. Field names are relative to the root of the resource. If no `update_mask` is provided, all fields in `backup` will be written to the target Backup resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `backup` are ignored and are not used to update the target Backup."
  ([name Backup]
    (projects-locations-backupPlans-backups-patch name Backup nil))
  ([name Backup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-backupPlans-backups-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-backupPlans-backups-create
  "Creates a Backup for the given BackupPlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/create

parent <string> Required. The BackupPlan within which to create the Backup. Format: `projects/*/locations/*/backupPlans/*`
Backup:
{:description string,
 :labels object,
 :stateReason string,
 :retainExpireTime string,
 :volumeCount integer,
 :containsVolumeData boolean,
 :podCount integer,
 :configBackupSizeBytes string,
 :uid string,
 :name string,
 :encryptionKey {:gcpKmsEncryptionKey string},
 :sizeBytes string,
 :clusterMetadata
 {:cluster string,
  :k8sVersion string,
  :backupCrdVersions object,
  :gkeVersion string,
  :anthosVersion string},
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED CREATING IN_PROGRESS SUCCEEDED FAILED DELETING],
 :resourceCount integer,
 :retainDays integer,
 :allNamespaces boolean,
 :deleteLockDays integer,
 :updateTime string,
 :manual boolean,
 :selectedApplications
 {:namespacedNames [{:namespace string, :name string}]},
 :completeTime string,
 :selectedNamespaces {:namespaces [string]},
 :deleteLockExpireTime string,
 :containsSecrets boolean,
 :permissiveMode boolean}

optional:
backupId <string> Optional. The client-provided short name for the Backup resource. This name must: - be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII letters, numbers, and dashes - start with a lower-case letter - end with a lower-case letter or number - be unique within the set of Backups in this BackupPlan"
  ([parent Backup]
    (projects-locations-backupPlans-backups-create parent Backup nil))
  ([parent Backup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-locations-backupPlans-backups-delete
  "Deletes an existing Backup.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/delete

name <string> Required. Name of the Backup resource. Format: `projects/*/locations/*/backupPlans/*/backups/*`

optional:
etag <string> Optional. If provided, this value must match the current value of the target Backup's etag field or the request is rejected.
force <boolean> Optional. If set to true, any VolumeBackups below this Backup will also be deleted. Otherwise, the request will only succeed if the Backup has no VolumeBackups."
  ([name] (projects-locations-backupPlans-backups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-backups-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-backupPlans-backups-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-backups-list
  "Lists the Backups for a given BackupPlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/list

parent <string> Required. The BackupPlan that contains the Backups to list. Format: `projects/*/locations/*/backupPlans/*`

optional:
pageSize <integer> Optional. The target number of results to return in a single response. If not specified, a default value will be chosen by the service. Note that the response may include a partial list and a caller should only rely on the response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Field match expression used to filter the results.
orderBy <string> Optional. Field by which to sort the results."
  ([parent] (projects-locations-backupPlans-backups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-backups-getBackupIndexDownloadUrl
  "Retrieve the link to the backupIndex.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups/getBackupIndexDownloadUrl

backup <string> Required. Full name of Backup resource. Format: projects/{project}/locations/{location}/backupPlans/{backup_plan}/backups/{backup}"
  [backup]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+backup}:getBackupIndexDownloadUrl",
     :uri-template-args {:backup backup},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-backupPlans-backups-volumeBackups-list
  "Lists the VolumeBackups for a given Backup.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups.volumeBackups/list

parent <string> Required. The Backup that contains the VolumeBackups to list. Format: `projects/*/locations/*/backupPlans/*/backups/*`

optional:
pageSize <integer> Optional. The target number of results to return in a single response. If not specified, a default value will be chosen by the service. Note that the response may include a partial list and a caller should only rely on the response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Field match expression used to filter the results.
orderBy <string> Optional. Field by which to sort the results."
  ([parent]
    (projects-locations-backupPlans-backups-volumeBackups-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/volumeBackups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-backups-volumeBackups-get
  "Retrieve the details of a single VolumeBackup.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups.volumeBackups/get

name <string> Required. Full name of the VolumeBackup resource. Format: `projects/*/locations/*/backupPlans/*/backups/*/volumeBackups/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-backupPlans-backups-volumeBackups-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups.volumeBackups/setIamPolicy

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
     "https://gkebackup.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-backupPlans-backups-volumeBackups-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups.volumeBackups/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-backupPlans-backups-volumeBackups-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-backupPlans-backups-volumeBackups-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.backupPlans.backups.volumeBackups/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-restorePlans-create
  "Creates a new RestorePlan in a given location.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/create

parent <string> Required. The location within which to create the RestorePlan. Format: `projects/*/locations/*`
RestorePlan:
{:description string,
 :labels object,
 :stateReason string,
 :cluster string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED CLUSTER_PENDING READY FAILED DELETING],
 :updateTime string,
 :backupPlan string,
 :restoreConfig
 {:substitutionRules
  [{:targetNamespaces [string],
    :targetGroupKinds [{:resourceGroup string, :resourceKind string}],
    :targetJsonPath string,
    :originalValuePattern string,
    :newValue string}],
  :clusterResourceRestoreScope
  {:selectedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :excludedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :allGroupKinds boolean,
   :noGroupKinds boolean},
  :noNamespaces boolean,
  :namespacedResourceRestoreMode
  [NAMESPACED_RESOURCE_RESTORE_MODE_UNSPECIFIED
   DELETE_AND_RESTORE
   FAIL_ON_CONFLICT
   MERGE_SKIP_ON_CONFLICT
   MERGE_REPLACE_VOLUME_ON_CONFLICT
   MERGE_REPLACE_ON_CONFLICT],
  :volumeDataRestorePolicy
  [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
   RESTORE_VOLUME_DATA_FROM_BACKUP
   REUSE_VOLUME_HANDLE_FROM_BACKUP
   NO_VOLUME_DATA_RESTORATION],
  :volumeDataRestorePolicyBindings
  [{:policy
    [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
     RESTORE_VOLUME_DATA_FROM_BACKUP
     REUSE_VOLUME_HANDLE_FROM_BACKUP
     NO_VOLUME_DATA_RESTORATION],
    :volumeType [VOLUME_TYPE_UNSPECIFIED GCE_PERSISTENT_DISK]}],
  :excludedNamespaces {:namespaces [string]},
  :allNamespaces boolean,
  :selectedApplications
  {:namespacedNames [{:namespace string, :name string}]},
  :clusterResourceConflictPolicy
  [CLUSTER_RESOURCE_CONFLICT_POLICY_UNSPECIFIED
   USE_EXISTING_VERSION
   USE_BACKUP_VERSION],
  :transformationRules
  [{:fieldActions
    [{:op [OP_UNSPECIFIED REMOVE MOVE COPY ADD TEST REPLACE],
      :fromPath string,
      :path string,
      :value string}],
    :resourceFilter
    {:namespaces [string],
     :groupKinds [{:resourceGroup string, :resourceKind string}],
     :jsonPath string},
    :description string}],
  :selectedNamespaces {:namespaces [string]},
  :restoreOrder
  {:groupKindDependencies
   [{:satisfying {:resourceGroup string, :resourceKind string},
     :requiring {:resourceGroup string, :resourceKind string}}]}}}

optional:
restorePlanId <string> Required. The client-provided short name for the RestorePlan resource. This name must: - be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII letters, numbers, and dashes - start with a lower-case letter - end with a lower-case letter or number - be unique within the set of RestorePlans in this location"
  ([parent RestorePlan]
    (projects-locations-restorePlans-create parent RestorePlan nil))
  ([parent RestorePlan optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/restorePlans",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body RestorePlan})))

(defn projects-locations-restorePlans-list
  "Lists RestorePlans in a given location.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/list

parent <string> Required. The location that contains the RestorePlans to list. Format: `projects/*/locations/*`

optional:
pageSize <integer> Optional. The target number of results to return in a single response. If not specified, a default value will be chosen by the service. Note that the response may include a partial list and a caller should only rely on the response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Field match expression used to filter the results.
orderBy <string> Optional. Field by which to sort the results."
  ([parent] (projects-locations-restorePlans-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/restorePlans",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-get
  "Retrieve the details of a single RestorePlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/get

name <string> Required. Fully qualified RestorePlan name. Format: `projects/*/locations/*/restorePlans/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-restorePlans-patch
  "Update a RestorePlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/patch

name <string> Output only. The full name of the RestorePlan resource. Format: `projects/*/locations/*/restorePlans/*`.
RestorePlan:
{:description string,
 :labels object,
 :stateReason string,
 :cluster string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :state [STATE_UNSPECIFIED CLUSTER_PENDING READY FAILED DELETING],
 :updateTime string,
 :backupPlan string,
 :restoreConfig
 {:substitutionRules
  [{:targetNamespaces [string],
    :targetGroupKinds [{:resourceGroup string, :resourceKind string}],
    :targetJsonPath string,
    :originalValuePattern string,
    :newValue string}],
  :clusterResourceRestoreScope
  {:selectedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :excludedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :allGroupKinds boolean,
   :noGroupKinds boolean},
  :noNamespaces boolean,
  :namespacedResourceRestoreMode
  [NAMESPACED_RESOURCE_RESTORE_MODE_UNSPECIFIED
   DELETE_AND_RESTORE
   FAIL_ON_CONFLICT
   MERGE_SKIP_ON_CONFLICT
   MERGE_REPLACE_VOLUME_ON_CONFLICT
   MERGE_REPLACE_ON_CONFLICT],
  :volumeDataRestorePolicy
  [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
   RESTORE_VOLUME_DATA_FROM_BACKUP
   REUSE_VOLUME_HANDLE_FROM_BACKUP
   NO_VOLUME_DATA_RESTORATION],
  :volumeDataRestorePolicyBindings
  [{:policy
    [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
     RESTORE_VOLUME_DATA_FROM_BACKUP
     REUSE_VOLUME_HANDLE_FROM_BACKUP
     NO_VOLUME_DATA_RESTORATION],
    :volumeType [VOLUME_TYPE_UNSPECIFIED GCE_PERSISTENT_DISK]}],
  :excludedNamespaces {:namespaces [string]},
  :allNamespaces boolean,
  :selectedApplications
  {:namespacedNames [{:namespace string, :name string}]},
  :clusterResourceConflictPolicy
  [CLUSTER_RESOURCE_CONFLICT_POLICY_UNSPECIFIED
   USE_EXISTING_VERSION
   USE_BACKUP_VERSION],
  :transformationRules
  [{:fieldActions
    [{:op [OP_UNSPECIFIED REMOVE MOVE COPY ADD TEST REPLACE],
      :fromPath string,
      :path string,
      :value string}],
    :resourceFilter
    {:namespaces [string],
     :groupKinds [{:resourceGroup string, :resourceKind string}],
     :jsonPath string},
    :description string}],
  :selectedNamespaces {:namespaces [string]},
  :restoreOrder
  {:groupKindDependencies
   [{:satisfying {:resourceGroup string, :resourceKind string},
     :requiring {:resourceGroup string, :resourceKind string}}]}}}

optional:
updateMask <string> Optional. This is used to specify the fields to be overwritten in the RestorePlan targeted for update. The values for each of these updated fields will be taken from the `restore_plan` provided with this request. Field names are relative to the root of the resource. If no `update_mask` is provided, all fields in `restore_plan` will be written to the target RestorePlan resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `restore_plan` are ignored and are not used to update the target RestorePlan."
  ([name RestorePlan]
    (projects-locations-restorePlans-patch name RestorePlan nil))
  ([name RestorePlan optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body RestorePlan})))

(defn projects-locations-restorePlans-delete
  "Deletes an existing RestorePlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/delete

name <string> Required. Fully qualified RestorePlan name. Format: `projects/*/locations/*/restorePlans/*`

optional:
etag <string> Optional. If provided, this value must match the current value of the target RestorePlan's etag field or the request is rejected.
force <boolean> Optional. If set to true, any Restores below this RestorePlan will also be deleted. Otherwise, the request will only succeed if the RestorePlan has no Restores."
  ([name] (projects-locations-restorePlans-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/setIamPolicy

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
     "https://gkebackup.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-restorePlans-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-restorePlans-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-restorePlans-restores-create
  "Creates a new Restore for the given RestorePlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/create

parent <string> Required. The RestorePlan within which to create the Restore. Format: `projects/*/locations/*/restorePlans/*`
Restore:
{:description string,
 :resourcesExcludedCount integer,
 :labels object,
 :stateReason string,
 :backup string,
 :resourcesRestoredCount integer,
 :cluster string,
 :volumesRestoredCount integer,
 :resourcesFailedCount integer,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED CREATING IN_PROGRESS SUCCEEDED FAILED DELETING],
 :updateTime string,
 :filter
 {:inclusionFilters
  [{:groupKind {:resourceGroup string, :resourceKind string},
    :name string,
    :namespace string,
    :labels object}],
  :exclusionFilters
  [{:groupKind {:resourceGroup string, :resourceKind string},
    :name string,
    :namespace string,
    :labels object}]},
 :restoreConfig
 {:substitutionRules
  [{:targetNamespaces [string],
    :targetGroupKinds [{:resourceGroup string, :resourceKind string}],
    :targetJsonPath string,
    :originalValuePattern string,
    :newValue string}],
  :clusterResourceRestoreScope
  {:selectedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :excludedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :allGroupKinds boolean,
   :noGroupKinds boolean},
  :noNamespaces boolean,
  :namespacedResourceRestoreMode
  [NAMESPACED_RESOURCE_RESTORE_MODE_UNSPECIFIED
   DELETE_AND_RESTORE
   FAIL_ON_CONFLICT
   MERGE_SKIP_ON_CONFLICT
   MERGE_REPLACE_VOLUME_ON_CONFLICT
   MERGE_REPLACE_ON_CONFLICT],
  :volumeDataRestorePolicy
  [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
   RESTORE_VOLUME_DATA_FROM_BACKUP
   REUSE_VOLUME_HANDLE_FROM_BACKUP
   NO_VOLUME_DATA_RESTORATION],
  :volumeDataRestorePolicyBindings
  [{:policy
    [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
     RESTORE_VOLUME_DATA_FROM_BACKUP
     REUSE_VOLUME_HANDLE_FROM_BACKUP
     NO_VOLUME_DATA_RESTORATION],
    :volumeType [VOLUME_TYPE_UNSPECIFIED GCE_PERSISTENT_DISK]}],
  :excludedNamespaces {:namespaces [string]},
  :allNamespaces boolean,
  :selectedApplications
  {:namespacedNames [{:namespace string, :name string}]},
  :clusterResourceConflictPolicy
  [CLUSTER_RESOURCE_CONFLICT_POLICY_UNSPECIFIED
   USE_EXISTING_VERSION
   USE_BACKUP_VERSION],
  :transformationRules
  [{:fieldActions
    [{:op [OP_UNSPECIFIED REMOVE MOVE COPY ADD TEST REPLACE],
      :fromPath string,
      :path string,
      :value string}],
    :resourceFilter
    {:namespaces [string],
     :groupKinds [{:resourceGroup string, :resourceKind string}],
     :jsonPath string},
    :description string}],
  :selectedNamespaces {:namespaces [string]},
  :restoreOrder
  {:groupKindDependencies
   [{:satisfying {:resourceGroup string, :resourceKind string},
     :requiring {:resourceGroup string, :resourceKind string}}]}},
 :completeTime string,
 :volumeDataRestorePolicyOverrides
 [{:policy
   [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
    RESTORE_VOLUME_DATA_FROM_BACKUP
    REUSE_VOLUME_HANDLE_FROM_BACKUP
    NO_VOLUME_DATA_RESTORATION],
   :selectedPvcs
   {:namespacedNames [{:namespace string, :name string}]}}]}

optional:
restoreId <string> Required. The client-provided short name for the Restore resource. This name must: - be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII letters, numbers, and dashes - start with a lower-case letter - end with a lower-case letter or number - be unique within the set of Restores in this RestorePlan."
  ([parent Restore]
    (projects-locations-restorePlans-restores-create
      parent
      Restore
      nil))
  ([parent Restore optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/restores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Restore})))

(defn projects-locations-restorePlans-restores-list
  "Lists the Restores for a given RestorePlan.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/list

parent <string> Required. The RestorePlan that contains the Restores to list. Format: `projects/*/locations/*/restorePlans/*`

optional:
pageSize <integer> Optional. The target number of results to return in a single response. If not specified, a default value will be chosen by the service. Note that the response may include a partial list and a caller should only rely on the response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Field match expression used to filter the results.
orderBy <string> Optional. Field by which to sort the results."
  ([parent] (projects-locations-restorePlans-restores-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/restores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-restores-get
  "Retrieves the details of a single Restore.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/get

name <string> Required. Name of the restore resource. Format: `projects/*/locations/*/restorePlans/*/restores/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-restorePlans-restores-patch
  "Update a Restore.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/patch

name <string> Output only. The full name of the Restore resource. Format: `projects/*/locations/*/restorePlans/*/restores/*`
Restore:
{:description string,
 :resourcesExcludedCount integer,
 :labels object,
 :stateReason string,
 :backup string,
 :resourcesRestoredCount integer,
 :cluster string,
 :volumesRestoredCount integer,
 :resourcesFailedCount integer,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :state
 [STATE_UNSPECIFIED CREATING IN_PROGRESS SUCCEEDED FAILED DELETING],
 :updateTime string,
 :filter
 {:inclusionFilters
  [{:groupKind {:resourceGroup string, :resourceKind string},
    :name string,
    :namespace string,
    :labels object}],
  :exclusionFilters
  [{:groupKind {:resourceGroup string, :resourceKind string},
    :name string,
    :namespace string,
    :labels object}]},
 :restoreConfig
 {:substitutionRules
  [{:targetNamespaces [string],
    :targetGroupKinds [{:resourceGroup string, :resourceKind string}],
    :targetJsonPath string,
    :originalValuePattern string,
    :newValue string}],
  :clusterResourceRestoreScope
  {:selectedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :excludedGroupKinds [{:resourceGroup string, :resourceKind string}],
   :allGroupKinds boolean,
   :noGroupKinds boolean},
  :noNamespaces boolean,
  :namespacedResourceRestoreMode
  [NAMESPACED_RESOURCE_RESTORE_MODE_UNSPECIFIED
   DELETE_AND_RESTORE
   FAIL_ON_CONFLICT
   MERGE_SKIP_ON_CONFLICT
   MERGE_REPLACE_VOLUME_ON_CONFLICT
   MERGE_REPLACE_ON_CONFLICT],
  :volumeDataRestorePolicy
  [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
   RESTORE_VOLUME_DATA_FROM_BACKUP
   REUSE_VOLUME_HANDLE_FROM_BACKUP
   NO_VOLUME_DATA_RESTORATION],
  :volumeDataRestorePolicyBindings
  [{:policy
    [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
     RESTORE_VOLUME_DATA_FROM_BACKUP
     REUSE_VOLUME_HANDLE_FROM_BACKUP
     NO_VOLUME_DATA_RESTORATION],
    :volumeType [VOLUME_TYPE_UNSPECIFIED GCE_PERSISTENT_DISK]}],
  :excludedNamespaces {:namespaces [string]},
  :allNamespaces boolean,
  :selectedApplications
  {:namespacedNames [{:namespace string, :name string}]},
  :clusterResourceConflictPolicy
  [CLUSTER_RESOURCE_CONFLICT_POLICY_UNSPECIFIED
   USE_EXISTING_VERSION
   USE_BACKUP_VERSION],
  :transformationRules
  [{:fieldActions
    [{:op [OP_UNSPECIFIED REMOVE MOVE COPY ADD TEST REPLACE],
      :fromPath string,
      :path string,
      :value string}],
    :resourceFilter
    {:namespaces [string],
     :groupKinds [{:resourceGroup string, :resourceKind string}],
     :jsonPath string},
    :description string}],
  :selectedNamespaces {:namespaces [string]},
  :restoreOrder
  {:groupKindDependencies
   [{:satisfying {:resourceGroup string, :resourceKind string},
     :requiring {:resourceGroup string, :resourceKind string}}]}},
 :completeTime string,
 :volumeDataRestorePolicyOverrides
 [{:policy
   [VOLUME_DATA_RESTORE_POLICY_UNSPECIFIED
    RESTORE_VOLUME_DATA_FROM_BACKUP
    REUSE_VOLUME_HANDLE_FROM_BACKUP
    NO_VOLUME_DATA_RESTORATION],
   :selectedPvcs
   {:namespacedNames [{:namespace string, :name string}]}}]}

optional:
updateMask <string> Optional. This is used to specify the fields to be overwritten in the Restore targeted for update. The values for each of these updated fields will be taken from the `restore` provided with this request. Field names are relative to the root of the resource. If no `update_mask` is provided, all fields in `restore` will be written to the target Restore resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `restore` are ignored and are not used to update the target Restore."
  ([name Restore]
    (projects-locations-restorePlans-restores-patch name Restore nil))
  ([name Restore optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Restore})))

(defn projects-locations-restorePlans-restores-delete
  "Deletes an existing Restore.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/delete

name <string> Required. Full name of the Restore Format: `projects/*/locations/*/restorePlans/*/restores/*`

optional:
etag <string> Optional. If provided, this value must match the current value of the target Restore's etag field or the request is rejected.
force <boolean> Optional. If set to true, any VolumeRestores below this restore will also be deleted. Otherwise, the request will only succeed if the restore has no VolumeRestores."
  ([name] (projects-locations-restorePlans-restores-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-restores-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/setIamPolicy

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
     "https://gkebackup.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-restorePlans-restores-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-restorePlans-restores-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-restores-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-restorePlans-restores-volumeRestores-list
  "Lists the VolumeRestores for a given Restore.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores.volumeRestores/list

parent <string> Required. The Restore that contains the VolumeRestores to list. Format: `projects/*/locations/*/restorePlans/*/restores/*`

optional:
pageSize <integer> Optional. The target number of results to return in a single response. If not specified, a default value will be chosen by the service. Note that the response may include a partial list and a caller should only rely on the response's next_page_token to determine if there are more instances left to be queried.
filter <string> Optional. Field match expression used to filter the results.
orderBy <string> Optional. Field by which to sort the results."
  ([parent]
    (projects-locations-restorePlans-restores-volumeRestores-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+parent}/volumeRestores",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-restores-volumeRestores-get
  "Retrieve the details of a single VolumeRestore.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores.volumeRestores/get

name <string> Required. Full name of the VolumeRestore resource. Format: `projects/*/locations/*/restorePlans/*/restores/*/volumeRestores/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://gkebackup.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-restorePlans-restores-volumeRestores-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores.volumeRestores/setIamPolicy

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
     "https://gkebackup.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-restorePlans-restores-volumeRestores-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores.volumeRestores/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-restorePlans-restores-volumeRestores-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://gkebackup.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-restorePlans-restores-volumeRestores-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gke/reference/rest/v1/projects.locations.restorePlans.restores.volumeRestores/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://gkebackup.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

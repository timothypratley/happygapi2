(ns happygapi2.osconfig
  "OS Config API
OS management tools that can be used for patch management, patch compliance, and configuration management on VM instances.
See: https://cloud.google.com/compute/docs/osconfig/rest"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-global-getProjectFeatureSettings
  "GetProjectFeatureSettings returns the VM Manager feature settings for a project.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.global/getProjectFeatureSettings

name <string> Required. Name specifies the URL for the ProjectFeatureSettings resource: projects/project_id/locations/global/projectFeatureSettings."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-global-updateProjectFeatureSettings
  "UpdateProjectFeatureSettings sets the VM Manager features for a project.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.global/updateProjectFeatureSettings

name <string> Required. Immutable. Name specifies the URL for the ProjectFeatureSettings resource: projects/project_id/locations/global/projectFeatureSettings.
ProjectFeatureSettings:
{:name string,
 :patchAndConfigFeatureSet
 [PATCH_AND_CONFIG_FEATURE_SET_UNSPECIFIED OSCONFIG_B OSCONFIG_C]}

optional:
updateMask <string> Optional. Field mask that controls which fields of the ProjectFeatureSettings should be updated."
  ([name ProjectFeatureSettings]
    (projects-locations-global-updateProjectFeatureSettings
      name
      ProjectFeatureSettings
      nil))
  ([name ProjectFeatureSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://osconfig.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ProjectFeatureSettings})))

(defn projects-locations-osPolicyAssignments-create
  "Create an OS policy assignment. This method also creates the first revision of the OS policy assignment. This method returns a long running operation (LRO) that contains the rollout details. The rollout can be cancelled by cancelling the LRO. For more information, see [Method: projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/cancel).
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments/create

parent <string> Required. The parent resource name in the form: projects/{project}/locations/{location}. Note: Specify the zone of your VMs as the location.
OSPolicyAssignment:
{:description string,
 :baseline boolean,
 :deleted boolean,
 :rolloutState
 [ROLLOUT_STATE_UNSPECIFIED
  IN_PROGRESS
  CANCELLING
  CANCELLED
  SUCCEEDED],
 :revisionCreateTime string,
 :uid string,
 :name string,
 :revisionId string,
 :osPolicies
 [{:id string,
   :description string,
   :mode [MODE_UNSPECIFIED VALIDATION ENFORCEMENT],
   :resourceGroups
   [{:inventoryFilters [{:osShortName string, :osVersion string}],
     :resources
     [{:id string,
       :pkg
       {:desiredState [DESIRED_STATE_UNSPECIFIED INSTALLED REMOVED],
        :apt OSPolicyResourcePackageResourceAPT,
        :deb OSPolicyResourcePackageResourceDeb,
        :yum OSPolicyResourcePackageResourceYUM,
        :zypper OSPolicyResourcePackageResourceZypper,
        :rpm OSPolicyResourcePackageResourceRPM,
        :googet OSPolicyResourcePackageResourceGooGet,
        :msi OSPolicyResourcePackageResourceMSI},
       :repository
       {:apt OSPolicyResourceRepositoryResourceAptRepository,
        :yum OSPolicyResourceRepositoryResourceYumRepository,
        :zypper OSPolicyResourceRepositoryResourceZypperRepository,
        :goo OSPolicyResourceRepositoryResourceGooRepository},
       :exec
       {:validate OSPolicyResourceExecResourceExec,
        :enforce OSPolicyResourceExecResourceExec},
       :file
       {:file OSPolicyResourceFile,
        :content string,
        :path string,
        :state
        [DESIRED_STATE_UNSPECIFIED PRESENT ABSENT CONTENTS_MATCH],
        :permissions string}}]}],
   :allowNoResourceGroupMatch boolean}],
 :etag string,
 :reconciling boolean,
 :rollout
 {:disruptionBudget {:fixed integer, :percent integer},
  :minWaitDuration string},
 :instanceFilter
 {:all boolean,
  :inclusionLabels [{:labels object}],
  :exclusionLabels [{:labels object}],
  :inventories [{:osShortName string, :osVersion string}]}}

optional:
osPolicyAssignmentId <string> Required. The logical name of the OS policy assignment in the project with the following restrictions: * Must contain only lowercase letters, numbers, and hyphens. * Must start with a letter. * Must be between 1-63 characters. * Must end with a number or a letter. * Must be unique within the project.
requestId <string> Optional. A unique identifier for this request. Restricted to 36 ASCII characters. A random UUID is recommended. This request is only idempotent if a `request_id` is provided."
  ([parent OSPolicyAssignment]
    (projects-locations-osPolicyAssignments-create
      parent
      OSPolicyAssignment
      nil))
  ([parent OSPolicyAssignment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/osPolicyAssignments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body OSPolicyAssignment})))

(defn projects-locations-osPolicyAssignments-patch
  "Update an existing OS policy assignment. This method creates a new revision of the OS policy assignment. This method returns a long running operation (LRO) that contains the rollout details. The rollout can be cancelled by cancelling the LRO. For more information, see [Method: projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/cancel).
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments/patch

name <string> Resource name. Format: `projects/{project_number}/locations/{location}/osPolicyAssignments/{os_policy_assignment_id}` This field is ignored when you create an OS policy assignment.
OSPolicyAssignment:
{:description string,
 :baseline boolean,
 :deleted boolean,
 :rolloutState
 [ROLLOUT_STATE_UNSPECIFIED
  IN_PROGRESS
  CANCELLING
  CANCELLED
  SUCCEEDED],
 :revisionCreateTime string,
 :uid string,
 :name string,
 :revisionId string,
 :osPolicies
 [{:id string,
   :description string,
   :mode [MODE_UNSPECIFIED VALIDATION ENFORCEMENT],
   :resourceGroups
   [{:inventoryFilters [{:osShortName string, :osVersion string}],
     :resources
     [{:id string,
       :pkg
       {:desiredState [DESIRED_STATE_UNSPECIFIED INSTALLED REMOVED],
        :apt OSPolicyResourcePackageResourceAPT,
        :deb OSPolicyResourcePackageResourceDeb,
        :yum OSPolicyResourcePackageResourceYUM,
        :zypper OSPolicyResourcePackageResourceZypper,
        :rpm OSPolicyResourcePackageResourceRPM,
        :googet OSPolicyResourcePackageResourceGooGet,
        :msi OSPolicyResourcePackageResourceMSI},
       :repository
       {:apt OSPolicyResourceRepositoryResourceAptRepository,
        :yum OSPolicyResourceRepositoryResourceYumRepository,
        :zypper OSPolicyResourceRepositoryResourceZypperRepository,
        :goo OSPolicyResourceRepositoryResourceGooRepository},
       :exec
       {:validate OSPolicyResourceExecResourceExec,
        :enforce OSPolicyResourceExecResourceExec},
       :file
       {:file OSPolicyResourceFile,
        :content string,
        :path string,
        :state
        [DESIRED_STATE_UNSPECIFIED PRESENT ABSENT CONTENTS_MATCH],
        :permissions string}}]}],
   :allowNoResourceGroupMatch boolean}],
 :etag string,
 :reconciling boolean,
 :rollout
 {:disruptionBudget {:fixed integer, :percent integer},
  :minWaitDuration string},
 :instanceFilter
 {:all boolean,
  :inclusionLabels [{:labels object}],
  :exclusionLabels [{:labels object}],
  :inventories [{:osShortName string, :osVersion string}]}}

optional:
updateMask <string> Optional. Field mask that controls which fields of the assignment should be updated.
allowMissing <boolean> Optional. If set to true, and the OS policy assignment is not found, a new OS policy assignment will be created. In this situation, `update_mask` is ignored.
requestId <string> Optional. A unique identifier for this request. Restricted to 36 ASCII characters. A random UUID is recommended. This request is only idempotent if a `request_id` is provided."
  ([name OSPolicyAssignment]
    (projects-locations-osPolicyAssignments-patch
      name
      OSPolicyAssignment
      nil))
  ([name OSPolicyAssignment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://osconfig.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body OSPolicyAssignment})))

(defn projects-locations-osPolicyAssignments-get
  "Retrieve an existing OS policy assignment. This method always returns the latest revision. In order to retrieve a previous revision of the assignment, also provide the revision ID in the `name` parameter.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments/get

name <string> Required. The resource name of OS policy assignment. Format: `projects/{project}/locations/{location}/osPolicyAssignments/{os_policy_assignment}@{revisionId}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-osPolicyAssignments-list
  "List the OS policy assignments under the parent resource. For each OS policy assignment, the latest revision is returned.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments/list

parent <string> Required. The parent resource name.

optional:
pageSize <integer> The maximum number of assignments to return."
  ([parent] (projects-locations-osPolicyAssignments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/osPolicyAssignments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-osPolicyAssignments-listRevisions
  "List the OS policy assignment revisions for a given OS policy assignment.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments/listRevisions

name <string> Required. The name of the OS policy assignment to list revisions for.

optional:
pageSize <integer> The maximum number of revisions to return."
  ([name]
    (projects-locations-osPolicyAssignments-listRevisions name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+name}:listRevisions",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-osPolicyAssignments-delete
  "Delete the OS policy assignment. This method creates a new revision of the OS policy assignment. This method returns a long running operation (LRO) that contains the rollout details. The rollout can be cancelled by cancelling the LRO. If the LRO completes and is not cancelled, all revisions associated with the OS policy assignment are deleted. For more information, see [Method: projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/cancel).
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments/delete

name <string> Required. The name of the OS policy assignment to be deleted

optional:
requestId <string> Optional. A unique identifier for this request. Restricted to 36 ASCII characters. A random UUID is recommended. This request is only idempotent if a `request_id` is provided."
  ([name] (projects-locations-osPolicyAssignments-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://osconfig.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-osPolicyAssignments-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-osPolicyAssignments-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-instances-osPolicyAssignments-reports-get
  "Get the OS policy assignment report for the specified Compute Engine VM instance.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.instances.osPolicyAssignments.reports/get

name <string> Required. API resource name for OS policy assignment report. Format: `/projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/{assignment}/report` For `{project}`, either `project-number` or `project-id` can be provided. For `{instance_id}`, either Compute Engine `instance-id` or `instance-name` can be provided. For `{assignment_id}`, the OSPolicyAssignment id must be provided."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-osPolicyAssignments-reports-list
  "List OS policy assignment reports for all Compute Engine VM instances in the specified zone.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.instances.osPolicyAssignments.reports/list

parent <string> Required. The parent resource name. Format: `projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/{assignment}/reports` For `{project}`, either `project-number` or `project-id` can be provided. For `{instance}`, either `instance-name`, `instance-id`, or `-` can be provided. If '-' is provided, the response will include OSPolicyAssignmentReports for all instances in the project/location. For `{assignment}`, either `assignment-id` or `-` can be provided. If '-' is provided, the response will include OSPolicyAssignmentReports for all OSPolicyAssignments in the project/location. Either {instance} or {assignment} must be `-`. For example: `projects/{project}/locations/{location}/instances/{instance}/osPolicyAssignments/-/reports` returns all reports for the instance `projects/{project}/locations/{location}/instances/-/osPolicyAssignments/{assignment-id}/reports` returns all the reports for the given assignment across all instances. `projects/{project}/locations/{location}/instances/-/osPolicyAssignments/-/reports` returns all the reports for all assignments across all instances.

optional:
pageSize <integer> The maximum number of results to return.
filter <string> If provided, this field specifies the criteria that must be met by the `OSPolicyAssignmentReport` API resource that is included in the response."
  ([parent]
    (projects-locations-instances-osPolicyAssignments-reports-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/reports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-inventories-get
  "Get inventory data for the specified VM instance. If the VM has no associated inventory, the message `NOT_FOUND` is returned.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.instances.inventories/get

name <string> Required. API resource name for inventory resource. Format: `projects/{project}/locations/{location}/instances/{instance}/inventory` For `{project}`, either `project-number` or `project-id` can be provided. For `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.

optional:
view <string> Inventory view indicating what information should be included in the inventory resource. If unspecified, the default view is BASIC."
  ([name] (projects-locations-instances-inventories-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://osconfig.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-inventories-list
  "List inventory data for all VM instances in the specified zone.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.instances.inventories/list

parent <string> Required. The parent resource name. Format: `projects/{project}/locations/{location}/instances/-` For `{project}`, either `project-number` or `project-id` can be provided.

optional:
view <string> Inventory view indicating what information should be included in the inventory resource. If unspecified, the default view is BASIC.
pageSize <integer> The maximum number of results to return.
filter <string> If provided, this field specifies the criteria that must be met by a `Inventory` API resource to be included in the response."
  ([parent] (projects-locations-instances-inventories-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/inventories",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-instances-vulnerabilityReports-get
  "Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have vulnerability reports associated with them.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.instances.vulnerabilityReports/get

name <string> Required. API resource name for vulnerability resource. Format: `projects/{project}/locations/{location}/instances/{instance}/vulnerabilityReport` For `{project}`, either `project-number` or `project-id` can be provided. For `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-instances-vulnerabilityReports-list
  "List vulnerability reports for all VM instances in the specified zone.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.instances.vulnerabilityReports/list

parent <string> Required. The parent resource name. Format: `projects/{project}/locations/{location}/instances/-` For `{project}`, either `project-number` or `project-id` can be provided.

optional:
pageSize <integer> The maximum number of results to return.
filter <string> This field supports filtering by the severity level for the vulnerability. For a list of severity levels, see [Severity levels for vulnerabilities](https://cloud.google.com/container-analysis/docs/container-scanning-overview#severity_levels_for_vulnerabilities). The filter field follows the rules described in the [AIP-160](https://google.aip.dev/160) guidelines as follows: + **Filter for a specific severity type**: you can list reports that contain vulnerabilities that are classified as medium by specifying `vulnerabilities.details.severity:MEDIUM`. + **Filter for a range of severities** : you can list reports that have vulnerabilities that are classified as critical or high by specifying `vulnerabilities.details.severity:HIGH OR vulnerabilities.details.severity:CRITICAL`"
  ([parent]
    (projects-locations-instances-vulnerabilityReports-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/vulnerabilityReports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-patchJobs-execute
  "Patch VM instances by creating and running a patch job.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchJobs/execute

parent <string> Required. The project in which to run this patch in the form `projects/*`
ExecutePatchJobRequest:
{:description string,
 :instanceFilter
 {:all boolean,
  :groupLabels [{:labels object}],
  :zones [string],
  :instances [string],
  :instanceNamePrefixes [string]},
 :patchConfig
 {:windowsUpdate
  {:classifications
   [[CLASSIFICATION_UNSPECIFIED
     CRITICAL
     SECURITY
     DEFINITION
     DRIVER
     FEATURE_PACK
     SERVICE_PACK
     TOOL
     UPDATE_ROLLUP
     UPDATE]],
   :excludes [string],
   :exclusivePatches [string]},
  :zypper
  {:withOptional boolean,
   :withUpdate boolean,
   :categories [string],
   :severities [string],
   :excludes [string],
   :exclusivePatches [string]},
  :goo object,
  :apt
  {:type [TYPE_UNSPECIFIED DIST UPGRADE],
   :excludes [string],
   :exclusivePackages [string]},
  :rebootConfig [REBOOT_CONFIG_UNSPECIFIED DEFAULT ALWAYS NEVER],
  :migInstancesAllowed boolean,
  :postStep
  {:linuxExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]},
   :windowsExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]}},
  :yum
  {:security boolean,
   :minimal boolean,
   :excludes [string],
   :exclusivePackages [string]},
  :preStep
  {:linuxExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]},
   :windowsExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]}}},
 :duration string,
 :dryRun boolean,
 :displayName string,
 :rollout
 {:mode [MODE_UNSPECIFIED ZONE_BY_ZONE CONCURRENT_ZONES],
  :disruptionBudget {:fixed integer, :percent integer}}}"
  [parent ExecutePatchJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://osconfig.googleapis.com/v1/{+parent}/patchJobs:execute",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExecutePatchJobRequest}))

(defn projects-patchJobs-get
  "Get the patch job. This can be used to track the progress of an ongoing patch job or review the details of completed jobs.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchJobs/get

name <string> Required. Name of the patch in the form `projects/*/patchJobs/*`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-patchJobs-cancel
  "Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchJobs/cancel

name <string> Required. Name of the patch in the form `projects/*/patchJobs/*`
CancelPatchJobRequest:
object"
  [name CancelPatchJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelPatchJobRequest}))

(defn projects-patchJobs-list
  "Get a list of patch jobs.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchJobs/list

parent <string> Required. In the form of `projects/*`

optional:
pageSize <integer> The maximum number of instance status to return.
filter <string> If provided, this field specifies the criteria that must be met by patch jobs to be included in the response. Currently, filtering is only available on the patch_deployment field."
  ([parent] (projects-patchJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/patchJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-patchJobs-instanceDetails-list
  "Get a list of instance details for a given patch job.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchJobs.instanceDetails/list

parent <string> Required. The parent for the instances are in the form of `projects/*/patchJobs/*`.

optional:
pageSize <integer> The maximum number of instance details records to return. Default is 100.
filter <string> A filter expression that filters results listed in the response. This field supports filtering results by instance zone, name, state, or `failure_reason`."
  ([parent] (projects-patchJobs-instanceDetails-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/instanceDetails",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-patchDeployments-create
  "Create an OS Config patch deployment.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchDeployments/create

parent <string> Required. The project to apply this patch deployment to in the form `projects/*`.
PatchDeployment:
{:description string,
 :lastExecuteTime string,
 :name string,
 :patchConfig
 {:windowsUpdate
  {:classifications
   [[CLASSIFICATION_UNSPECIFIED
     CRITICAL
     SECURITY
     DEFINITION
     DRIVER
     FEATURE_PACK
     SERVICE_PACK
     TOOL
     UPDATE_ROLLUP
     UPDATE]],
   :excludes [string],
   :exclusivePatches [string]},
  :zypper
  {:withOptional boolean,
   :withUpdate boolean,
   :categories [string],
   :severities [string],
   :excludes [string],
   :exclusivePatches [string]},
  :goo object,
  :apt
  {:type [TYPE_UNSPECIFIED DIST UPGRADE],
   :excludes [string],
   :exclusivePackages [string]},
  :rebootConfig [REBOOT_CONFIG_UNSPECIFIED DEFAULT ALWAYS NEVER],
  :migInstancesAllowed boolean,
  :postStep
  {:linuxExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]},
   :windowsExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]}},
  :yum
  {:security boolean,
   :minimal boolean,
   :excludes [string],
   :exclusivePackages [string]},
  :preStep
  {:linuxExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]},
   :windowsExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]}}},
 :createTime string,
 :duration string,
 :state [STATE_UNSPECIFIED ACTIVE PAUSED],
 :updateTime string,
 :recurringSchedule
 {:timeZone {:id string, :version string},
  :lastExecuteTime string,
  :nextExecuteTime string,
  :startTime string,
  :endTime string,
  :frequency [FREQUENCY_UNSPECIFIED WEEKLY MONTHLY DAILY],
  :monthly
  {:weekDayOfMonth
   {:weekOrdinal integer,
    :dayOfWeek
    [DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY],
    :dayOffset integer},
   :monthDay integer},
  :weekly
  {:dayOfWeek
   [DAY_OF_WEEK_UNSPECIFIED
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY]},
  :timeOfDay
  {:hours integer,
   :minutes integer,
   :seconds integer,
   :nanos integer}},
 :oneTimeSchedule {:executeTime string},
 :rollout
 {:mode [MODE_UNSPECIFIED ZONE_BY_ZONE CONCURRENT_ZONES],
  :disruptionBudget {:fixed integer, :percent integer}},
 :instanceFilter
 {:all boolean,
  :groupLabels [{:labels object}],
  :zones [string],
  :instances [string],
  :instanceNamePrefixes [string]}}

optional:
patchDeploymentId <string> Required. A name for the patch deployment in the project. When creating a name the following rules apply: * Must contain only lowercase letters, numbers, and hyphens. * Must start with a letter. * Must be between 1-63 characters. * Must end with a number or a letter. * Must be unique within the project."
  ([parent PatchDeployment]
    (projects-patchDeployments-create parent PatchDeployment nil))
  ([parent PatchDeployment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/patchDeployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PatchDeployment})))

(defn projects-patchDeployments-get
  "Get an OS Config patch deployment.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchDeployments/get

name <string> Required. The resource name of the patch deployment in the form `projects/*/patchDeployments/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-patchDeployments-list
  "Get a page of OS Config patch deployments.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchDeployments/list

parent <string> Required. The resource name of the parent in the form `projects/*`.

optional:
pageSize <integer> Optional. The maximum number of patch deployments to return. Default is 100."
  ([parent] (projects-patchDeployments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://osconfig.googleapis.com/v1/{+parent}/patchDeployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-patchDeployments-delete
  "Delete an OS Config patch deployment.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchDeployments/delete

name <string> Required. The resource name of the patch deployment in the form `projects/*/patchDeployments/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-patchDeployments-patch
  "Update an OS Config patch deployment.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchDeployments/patch

name <string> Unique name for the patch deployment resource in a project. The patch deployment name is in the form: `projects/{project_id}/patchDeployments/{patch_deployment_id}`. This field is ignored when you create a new patch deployment.
PatchDeployment:
{:description string,
 :lastExecuteTime string,
 :name string,
 :patchConfig
 {:windowsUpdate
  {:classifications
   [[CLASSIFICATION_UNSPECIFIED
     CRITICAL
     SECURITY
     DEFINITION
     DRIVER
     FEATURE_PACK
     SERVICE_PACK
     TOOL
     UPDATE_ROLLUP
     UPDATE]],
   :excludes [string],
   :exclusivePatches [string]},
  :zypper
  {:withOptional boolean,
   :withUpdate boolean,
   :categories [string],
   :severities [string],
   :excludes [string],
   :exclusivePatches [string]},
  :goo object,
  :apt
  {:type [TYPE_UNSPECIFIED DIST UPGRADE],
   :excludes [string],
   :exclusivePackages [string]},
  :rebootConfig [REBOOT_CONFIG_UNSPECIFIED DEFAULT ALWAYS NEVER],
  :migInstancesAllowed boolean,
  :postStep
  {:linuxExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]},
   :windowsExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]}},
  :yum
  {:security boolean,
   :minimal boolean,
   :excludes [string],
   :exclusivePackages [string]},
  :preStep
  {:linuxExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]},
   :windowsExecStepConfig
   {:localPath string,
    :gcsObject
    {:bucket string, :object string, :generationNumber string},
    :allowedSuccessCodes [integer],
    :interpreter [INTERPRETER_UNSPECIFIED NONE SHELL POWERSHELL]}}},
 :createTime string,
 :duration string,
 :state [STATE_UNSPECIFIED ACTIVE PAUSED],
 :updateTime string,
 :recurringSchedule
 {:timeZone {:id string, :version string},
  :lastExecuteTime string,
  :nextExecuteTime string,
  :startTime string,
  :endTime string,
  :frequency [FREQUENCY_UNSPECIFIED WEEKLY MONTHLY DAILY],
  :monthly
  {:weekDayOfMonth
   {:weekOrdinal integer,
    :dayOfWeek
    [DAY_OF_WEEK_UNSPECIFIED
     MONDAY
     TUESDAY
     WEDNESDAY
     THURSDAY
     FRIDAY
     SATURDAY
     SUNDAY],
    :dayOffset integer},
   :monthDay integer},
  :weekly
  {:dayOfWeek
   [DAY_OF_WEEK_UNSPECIFIED
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY]},
  :timeOfDay
  {:hours integer,
   :minutes integer,
   :seconds integer,
   :nanos integer}},
 :oneTimeSchedule {:executeTime string},
 :rollout
 {:mode [MODE_UNSPECIFIED ZONE_BY_ZONE CONCURRENT_ZONES],
  :disruptionBudget {:fixed integer, :percent integer}},
 :instanceFilter
 {:all boolean,
  :groupLabels [{:labels object}],
  :zones [string],
  :instances [string],
  :instanceNamePrefixes [string]}}

optional:
updateMask <string> Optional. Field mask that controls which fields of the patch deployment should be updated."
  ([name PatchDeployment]
    (projects-patchDeployments-patch name PatchDeployment nil))
  ([name PatchDeployment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://osconfig.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PatchDeployment})))

(defn projects-patchDeployments-pause
  "Change state of patch deployment to \"PAUSED\". Patch deployment in paused state doesn't generate patch jobs.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchDeployments/pause

name <string> Required. The resource name of the patch deployment in the form `projects/*/patchDeployments/*`.
PausePatchDeploymentRequest:
object"
  [name PausePatchDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}:pause",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PausePatchDeploymentRequest}))

(defn projects-patchDeployments-resume
  "Change state of patch deployment back to \"ACTIVE\". Patch deployment in active state continues to generate patch jobs.
https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.patchDeployments/resume

name <string> Required. The resource name of the patch deployment in the form `projects/*/patchDeployments/*`.
ResumePatchDeploymentRequest:
object"
  [name ResumePatchDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://osconfig.googleapis.com/v1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResumePatchDeploymentRequest}))

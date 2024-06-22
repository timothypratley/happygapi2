(ns happygapi2.clouddeploy
  "Cloud Deploy API

See: https://cloud.google.com/deploy/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-getConfig
  "Gets the configuration for a location.
https://cloud.google.com/deploy

name <string> Required. Name of requested configuration."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/deploy

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/deploy

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/deploy

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/deploy

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/deploy

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/deploy

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-deliveryPipelines-get
  "Gets details of a single DeliveryPipeline.
https://cloud.google.com/deploy

name <string> Required. Name of the `DeliveryPipeline`. Format must be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deliveryPipelines-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/deploy

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
     "https://clouddeploy.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-deliveryPipelines-patch
  "Updates the parameters of a single DeliveryPipeline.
https://cloud.google.com/deploy

name <string> Optional. Name of the `DeliveryPipeline`. Format is `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}`. The `deliveryPipeline` component must match `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`
DeliveryPipeline:
{:description string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :suspended boolean,
 :updateTime string,
 :condition
 {:pipelineReadyCondition {:status boolean, :updateTime string},
  :targetsPresentCondition
  {:status boolean, :missingTargets [string], :updateTime string},
  :targetsTypeCondition {:status boolean, :errorDetails string}},
 :annotations object,
 :serialPipeline
 {:stages
  [{:targetId string,
    :profiles [string],
    :strategy
    {:standard
     {:verify boolean, :predeploy Predeploy, :postdeploy Postdeploy},
     :canary
     {:runtimeConfig RuntimeConfig,
      :canaryDeployment CanaryDeployment,
      :customCanaryDeployment CustomCanaryDeployment}},
    :deployParameters [{:values object, :matchTargetLabels object}]}]}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `DeliveryPipeline` resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it's in the mask. If the user doesn't provide a mask then all fields are overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, updating a `DeliveryPipeline` that does not exist will result in the creation of a new `DeliveryPipeline`.
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([name DeliveryPipeline]
    (projects-locations-deliveryPipelines-patch
      name
      DeliveryPipeline
      nil))
  ([name DeliveryPipeline optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DeliveryPipeline})))

(defn projects-locations-deliveryPipelines-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/deploy

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-deliveryPipelines-create
  "Creates a new DeliveryPipeline in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent collection in which the `DeliveryPipeline` should be created. Format should be `projects/{project_id}/locations/{location_name}`.
DeliveryPipeline:
{:description string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :suspended boolean,
 :updateTime string,
 :condition
 {:pipelineReadyCondition {:status boolean, :updateTime string},
  :targetsPresentCondition
  {:status boolean, :missingTargets [string], :updateTime string},
  :targetsTypeCondition {:status boolean, :errorDetails string}},
 :annotations object,
 :serialPipeline
 {:stages
  [{:targetId string,
    :profiles [string],
    :strategy
    {:standard
     {:verify boolean, :predeploy Predeploy, :postdeploy Postdeploy},
     :canary
     {:runtimeConfig RuntimeConfig,
      :canaryDeployment CanaryDeployment,
      :customCanaryDeployment CustomCanaryDeployment}},
    :deployParameters [{:values object, :matchTargetLabels object}]}]}}

optional:
deliveryPipelineId <string> Required. ID of the `DeliveryPipeline`.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([parent DeliveryPipeline]
    (projects-locations-deliveryPipelines-create
      parent
      DeliveryPipeline
      nil))
  ([parent DeliveryPipeline optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/deliveryPipelines",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DeliveryPipeline})))

(defn projects-locations-deliveryPipelines-delete
  "Deletes a single DeliveryPipeline.
https://cloud.google.com/deploy

name <string> Required. The name of the `DeliveryPipeline` to delete. Format should be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, then deleting an already deleted or non-existing `DeliveryPipeline` will succeed.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually post it.
force <boolean> Optional. If set to true, all child resources under this pipeline will also be deleted. Otherwise, the request will only work if the pipeline has no child resources.
etag <string> Optional. This checksum is computed by the server based on the value of other fields, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name] (projects-locations-deliveryPipelines-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/deploy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-deliveryPipelines-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-rollbackTarget
  "Creates a `Rollout` to roll back the specified target.
https://cloud.google.com/deploy

name <string> Required. The `DeliveryPipeline` for which the rollback `Rollout` should be created. Format should be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
RollbackTargetRequest:
{:targetId string,
 :rolloutId string,
 :releaseId string,
 :rolloutToRollBack string,
 :rollbackConfig
 {:rollout
  {:description string,
   :deployingBuild string,
   :rolledBackByRollouts [string],
   :labels object,
   :rollbackOfRollout string,
   :approveTime string,
   :uid string,
   :name string,
   :targetId string,
   :createTime string,
   :controllerRollout string,
   :etag string,
   :state
   [STATE_UNSPECIFIED
    SUCCEEDED
    FAILED
    IN_PROGRESS
    PENDING_APPROVAL
    APPROVAL_REJECTED
    PENDING
    PENDING_RELEASE
    CANCELLING
    CANCELLED
    HALTED],
   :deployStartTime string,
   :deployEndTime string,
   :phases
   [{:id string,
     :state
     [STATE_UNSPECIFIED
      PENDING
      IN_PROGRESS
      SUCCEEDED
      FAILED
      ABORTED
      SKIPPED],
     :skipMessage string,
     :deploymentJobs
     {:deployJob Job,
      :verifyJob Job,
      :predeployJob Job,
      :postdeployJob Job},
     :childRolloutJobs
     {:createRolloutJobs [Job], :advanceRolloutJobs [Job]}}],
   :annotations object,
   :enqueueTime string,
   :approvalState
   [APPROVAL_STATE_UNSPECIFIED
    NEEDS_APPROVAL
    DOES_NOT_NEED_APPROVAL
    APPROVED
    REJECTED],
   :failureReason string,
   :deployFailureCause
   [FAILURE_CAUSE_UNSPECIFIED
    CLOUD_BUILD_UNAVAILABLE
    EXECUTION_FAILED
    DEADLINE_EXCEEDED
    RELEASE_FAILED
    RELEASE_ABANDONED
    VERIFICATION_CONFIG_NOT_FOUND
    CLOUD_BUILD_REQUEST_FAILED
    OPERATION_FEATURE_NOT_SUPPORTED],
   :metadata
   {:cloudRun
    {:service string,
     :serviceUrls [string],
     :revision string,
     :job string},
    :automation
    {:promoteAutomationRun string,
     :advanceAutomationRuns [string],
     :repairAutomationRuns [string]},
    :custom {:values object}}},
  :startingPhaseId string},
 :validateOnly boolean}"
  [name RollbackTargetRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:rollbackTarget",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RollbackTargetRequest}))

(defn projects-locations-deliveryPipelines-list
  "Lists DeliveryPipelines in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent, which owns this collection of pipelines. Format must be `projects/{project_id}/locations/{location_name}`.

optional:
pageSize <integer> The maximum number of pipelines to return. The service may return fewer than this value. If unspecified, at most 50 pipelines will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Filter pipelines to be returned. See https://google.aip.dev/160 for more details.
orderBy <string> Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-deliveryPipelines-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/deliveryPipelines",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-releases-list
  "Lists Releases in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The `DeliveryPipeline` which owns this collection of `Release` objects.

optional:
pageSize <integer> Optional. The maximum number of `Release` objects to return. The service may return fewer than this value. If unspecified, at most 50 `Release` objects will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Optional. Filter releases to be returned. See https://google.aip.dev/160 for more details.
orderBy <string> Optional. Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent]
    (projects-locations-deliveryPipelines-releases-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/releases",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-releases-get
  "Gets details of a single Release.
https://cloud.google.com/deploy

name <string> Required. Name of the `Release`. Format must be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deliveryPipelines-releases-create
  "Creates a new Release in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent collection in which the `Release` should be created. Format should be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
Release:
{:description string,
 :labels object,
 :targetRenders object,
 :buildArtifacts [{:image string, :tag string}],
 :abandoned boolean,
 :renderEndTime string,
 :uid string,
 :name string,
 :customTargetTypeSnapshots
 [{:description string,
   :labels object,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :customActions
   {:renderAction string,
    :deployAction string,
    :includeSkaffoldModules
    [{:configs [string],
      :git {:repo string, :path string, :ref string},
      :googleCloudStorage {:source string, :path string},
      :googleCloudBuildRepo
      {:repository string, :path string, :ref string}}]},
   :customTargetTypeId string,
   :annotations object}],
 :createTime string,
 :etag string,
 :targetArtifacts object,
 :renderStartTime string,
 :skaffoldVersion string,
 :targetSnapshots
 [{:description string,
   :labels object,
   :run {:location string},
   :multiTarget {:targetIds [string]},
   :uid string,
   :name string,
   :targetId string,
   :createTime string,
   :customTarget {:customTargetType string},
   :etag string,
   :requireApproval boolean,
   :updateTime string,
   :gke {:cluster string, :internalIp boolean, :proxyUrl string},
   :executionConfigs
   [{:usages
     [[EXECUTION_ENVIRONMENT_USAGE_UNSPECIFIED
       RENDER
       DEPLOY
       VERIFY
       PREDEPLOY
       POSTDEPLOY]],
     :defaultPool {:serviceAccount string, :artifactStorage string},
     :privatePool
     {:workerPool string,
      :serviceAccount string,
      :artifactStorage string},
     :workerPool string,
     :serviceAccount string,
     :artifactStorage string,
     :executionTimeout string,
     :verbose boolean}],
   :annotations object,
   :anthosCluster {:membership string},
   :deployParameters object}],
 :condition
 {:releaseReadyCondition {:status boolean},
  :skaffoldSupportedCondition
  {:status boolean,
   :skaffoldSupportState
   [SKAFFOLD_SUPPORT_STATE_UNSPECIFIED
    SKAFFOLD_SUPPORT_STATE_SUPPORTED
    SKAFFOLD_SUPPORT_STATE_MAINTENANCE_MODE
    SKAFFOLD_SUPPORT_STATE_UNSUPPORTED],
   :maintenanceModeTime string,
   :supportExpirationTime string}},
 :skaffoldConfigUri string,
 :annotations object,
 :deliveryPipelineSnapshot
 {:description string,
  :labels object,
  :uid string,
  :name string,
  :createTime string,
  :etag string,
  :suspended boolean,
  :updateTime string,
  :condition
  {:pipelineReadyCondition {:status boolean, :updateTime string},
   :targetsPresentCondition
   {:status boolean, :missingTargets [string], :updateTime string},
   :targetsTypeCondition {:status boolean, :errorDetails string}},
  :annotations object,
  :serialPipeline
  {:stages
   [{:targetId string,
     :profiles [string],
     :strategy {:standard Standard, :canary Canary},
     :deployParameters
     [{:values object, :matchTargetLabels object}]}]}},
 :skaffoldConfigPath string,
 :renderState [RENDER_STATE_UNSPECIFIED SUCCEEDED FAILED IN_PROGRESS],
 :deployParameters object}

optional:
releaseId <string> Required. ID of the `Release`.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([parent Release]
    (projects-locations-deliveryPipelines-releases-create
      parent
      Release
      nil))
  ([parent Release optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/releases",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Release})))

(defn projects-locations-deliveryPipelines-releases-abandon
  "Abandons a Release in the Delivery Pipeline.
https://cloud.google.com/deploy

name <string> Required. Name of the Release. Format is `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}`.
AbandonReleaseRequest:
object"
  [name AbandonReleaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:abandon",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AbandonReleaseRequest}))

(defn projects-locations-deliveryPipelines-releases-rollouts-approve
  "Approves a Rollout.
https://cloud.google.com/deploy

name <string> Required. Name of the Rollout. Format is `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
ApproveRolloutRequest:
{:approved boolean}"
  [name ApproveRolloutRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:approve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ApproveRolloutRequest}))

(defn projects-locations-deliveryPipelines-releases-rollouts-advance
  "Advances a Rollout in a given project and location.
https://cloud.google.com/deploy

name <string> Required. Name of the Rollout. Format is `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
AdvanceRolloutRequest:
{:phaseId string}"
  [name AdvanceRolloutRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:advance",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AdvanceRolloutRequest}))

(defn projects-locations-deliveryPipelines-releases-rollouts-cancel
  "Cancels a Rollout in a given project and location.
https://cloud.google.com/deploy

name <string> Required. Name of the Rollout. Format is `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
CancelRolloutRequest:
object"
  [name CancelRolloutRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelRolloutRequest}))

(defn projects-locations-deliveryPipelines-releases-rollouts-list
  "Lists Rollouts in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The `Release` which owns this collection of `Rollout` objects.

optional:
pageSize <integer> Optional. The maximum number of `Rollout` objects to return. The service may return fewer than this value. If unspecified, at most 50 `Rollout` objects will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Optional. Filter rollouts to be returned. See https://google.aip.dev/160 for more details.
orderBy <string> Optional. Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent]
    (projects-locations-deliveryPipelines-releases-rollouts-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/rollouts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-releases-rollouts-get
  "Gets details of a single Rollout.
https://cloud.google.com/deploy

name <string> Required. Name of the `Rollout`. Format must be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deliveryPipelines-releases-rollouts-create
  "Creates a new Rollout in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent collection in which the `Rollout` should be created. Format should be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}`.
Rollout:
{:description string,
 :deployingBuild string,
 :rolledBackByRollouts [string],
 :labels object,
 :rollbackOfRollout string,
 :approveTime string,
 :uid string,
 :name string,
 :targetId string,
 :createTime string,
 :controllerRollout string,
 :etag string,
 :state
 [STATE_UNSPECIFIED
  SUCCEEDED
  FAILED
  IN_PROGRESS
  PENDING_APPROVAL
  APPROVAL_REJECTED
  PENDING
  PENDING_RELEASE
  CANCELLING
  CANCELLED
  HALTED],
 :deployStartTime string,
 :deployEndTime string,
 :phases
 [{:id string,
   :state
   [STATE_UNSPECIFIED
    PENDING
    IN_PROGRESS
    SUCCEEDED
    FAILED
    ABORTED
    SKIPPED],
   :skipMessage string,
   :deploymentJobs
   {:deployJob
    {:jobRun string,
     :advanceChildRolloutJob object,
     :state
     [STATE_UNSPECIFIED
      PENDING
      DISABLED
      IN_PROGRESS
      SUCCEEDED
      FAILED
      ABORTED
      SKIPPED
      IGNORED],
     :skipMessage string,
     :postdeployJob {:actions [string]},
     :id string,
     :createChildRolloutJob object,
     :verifyJob object,
     :deployJob object,
     :predeployJob {:actions [string]}},
    :verifyJob
    {:jobRun string,
     :advanceChildRolloutJob object,
     :state
     [STATE_UNSPECIFIED
      PENDING
      DISABLED
      IN_PROGRESS
      SUCCEEDED
      FAILED
      ABORTED
      SKIPPED
      IGNORED],
     :skipMessage string,
     :postdeployJob {:actions [string]},
     :id string,
     :createChildRolloutJob object,
     :verifyJob object,
     :deployJob object,
     :predeployJob {:actions [string]}},
    :predeployJob
    {:jobRun string,
     :advanceChildRolloutJob object,
     :state
     [STATE_UNSPECIFIED
      PENDING
      DISABLED
      IN_PROGRESS
      SUCCEEDED
      FAILED
      ABORTED
      SKIPPED
      IGNORED],
     :skipMessage string,
     :postdeployJob {:actions [string]},
     :id string,
     :createChildRolloutJob object,
     :verifyJob object,
     :deployJob object,
     :predeployJob {:actions [string]}},
    :postdeployJob
    {:jobRun string,
     :advanceChildRolloutJob object,
     :state
     [STATE_UNSPECIFIED
      PENDING
      DISABLED
      IN_PROGRESS
      SUCCEEDED
      FAILED
      ABORTED
      SKIPPED
      IGNORED],
     :skipMessage string,
     :postdeployJob {:actions [string]},
     :id string,
     :createChildRolloutJob object,
     :verifyJob object,
     :deployJob object,
     :predeployJob {:actions [string]}}},
   :childRolloutJobs
   {:createRolloutJobs
    [{:jobRun string,
      :advanceChildRolloutJob object,
      :state
      [STATE_UNSPECIFIED
       PENDING
       DISABLED
       IN_PROGRESS
       SUCCEEDED
       FAILED
       ABORTED
       SKIPPED
       IGNORED],
      :skipMessage string,
      :postdeployJob {:actions [string]},
      :id string,
      :createChildRolloutJob object,
      :verifyJob object,
      :deployJob object,
      :predeployJob {:actions [string]}}],
    :advanceRolloutJobs
    [{:jobRun string,
      :advanceChildRolloutJob object,
      :state
      [STATE_UNSPECIFIED
       PENDING
       DISABLED
       IN_PROGRESS
       SUCCEEDED
       FAILED
       ABORTED
       SKIPPED
       IGNORED],
      :skipMessage string,
      :postdeployJob {:actions [string]},
      :id string,
      :createChildRolloutJob object,
      :verifyJob object,
      :deployJob object,
      :predeployJob {:actions [string]}}]}}],
 :annotations object,
 :enqueueTime string,
 :approvalState
 [APPROVAL_STATE_UNSPECIFIED
  NEEDS_APPROVAL
  DOES_NOT_NEED_APPROVAL
  APPROVED
  REJECTED],
 :failureReason string,
 :deployFailureCause
 [FAILURE_CAUSE_UNSPECIFIED
  CLOUD_BUILD_UNAVAILABLE
  EXECUTION_FAILED
  DEADLINE_EXCEEDED
  RELEASE_FAILED
  RELEASE_ABANDONED
  VERIFICATION_CONFIG_NOT_FOUND
  CLOUD_BUILD_REQUEST_FAILED
  OPERATION_FEATURE_NOT_SUPPORTED],
 :metadata
 {:cloudRun
  {:service string,
   :serviceUrls [string],
   :revision string,
   :job string},
  :automation
  {:promoteAutomationRun string,
   :advanceAutomationRuns [string],
   :repairAutomationRuns [string]},
  :custom {:values object}}}

optional:
rolloutId <string> Required. ID of the `Rollout`.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made.
startingPhaseId <string> Optional. The starting phase ID for the `Rollout`. If empty the `Rollout` will start at the first phase."
  ([parent Rollout]
    (projects-locations-deliveryPipelines-releases-rollouts-create
      parent
      Rollout
      nil))
  ([parent Rollout optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/rollouts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Rollout})))

(defn projects-locations-deliveryPipelines-releases-rollouts-ignoreJob
  "Ignores the specified Job in a Rollout.
https://cloud.google.com/deploy

rollout <string> Required. Name of the Rollout. Format is `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
IgnoreJobRequest:
{:phaseId string, :jobId string}"
  [rollout IgnoreJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+rollout}:ignoreJob",
     :uri-template-args {:rollout rollout},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body IgnoreJobRequest}))

(defn projects-locations-deliveryPipelines-releases-rollouts-retryJob
  "Retries the specified Job in a Rollout.
https://cloud.google.com/deploy

rollout <string> Required. Name of the Rollout. Format is `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}`.
RetryJobRequest:
{:phaseId string, :jobId string}"
  [rollout RetryJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+rollout}:retryJob",
     :uri-template-args {:rollout rollout},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RetryJobRequest}))

(defn projects-locations-deliveryPipelines-releases-rollouts-jobRuns-list
  "Lists JobRuns in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The `Rollout` which owns this collection of `JobRun` objects.

optional:
pageSize <integer> Optional. The maximum number of `JobRun` objects to return. The service may return fewer than this value. If unspecified, at most 50 `JobRun` objects will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Optional. Filter results to be returned. See https://google.aip.dev/160 for more details.
orderBy <string> Optional. Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent]
    (projects-locations-deliveryPipelines-releases-rollouts-jobRuns-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/jobRuns",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-releases-rollouts-jobRuns-get
  "Gets details of a single JobRun.
https://cloud.google.com/deploy

name <string> Required. Name of the `JobRun`. Format must be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/releases/{release_name}/rollouts/{rollout_name}/jobRuns/{job_run_name}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deliveryPipelines-releases-rollouts-jobRuns-terminate
  "Terminates a Job Run in a given project and location.
https://cloud.google.com/deploy

name <string> Required. Name of the `JobRun`. Format must be `projects/{project}/locations/{location}/deliveryPipelines/{deliveryPipeline}/releases/{release}/rollouts/{rollout}/jobRuns/{jobRun}`.
TerminateJobRunRequest:
object"
  [name TerminateJobRunRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:terminate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TerminateJobRunRequest}))

(defn projects-locations-deliveryPipelines-automations-create
  "Creates a new Automation in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent collection in which the `Automation` should be created. Format should be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.
Automation:
{:description string,
 :serviceAccount string,
 :labels object,
 :selector {:targets [{:id string, :labels object}]},
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :rules
 [{:promoteReleaseRule
   {:id string,
    :wait string,
    :destinationTargetId string,
    :condition
    {:targetsPresentCondition
     {:status boolean, :missingTargets [string], :updateTime string}},
    :destinationPhase string},
   :advanceRolloutRule
   {:id string,
    :sourcePhases [string],
    :wait string,
    :condition
    {:targetsPresentCondition
     {:status boolean, :missingTargets [string], :updateTime string}}},
   :repairRolloutRule
   {:id string,
    :jobs [string],
    :condition
    {:targetsPresentCondition
     {:status boolean,
      :missingTargets [string],
      :updateTime string}}}}],
 :suspended boolean,
 :updateTime string,
 :annotations object}

optional:
automationId <string> Required. ID of the `Automation`.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([parent Automation]
    (projects-locations-deliveryPipelines-automations-create
      parent
      Automation
      nil))
  ([parent Automation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/automations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Automation})))

(defn projects-locations-deliveryPipelines-automations-patch
  "Updates the parameters of a single Automation resource.
https://cloud.google.com/deploy

name <string> Output only. Name of the `Automation`. Format is `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automations/{automation}`.
Automation:
{:description string,
 :serviceAccount string,
 :labels object,
 :selector {:targets [{:id string, :labels object}]},
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :rules
 [{:promoteReleaseRule
   {:id string,
    :wait string,
    :destinationTargetId string,
    :condition
    {:targetsPresentCondition
     {:status boolean, :missingTargets [string], :updateTime string}},
    :destinationPhase string},
   :advanceRolloutRule
   {:id string,
    :sourcePhases [string],
    :wait string,
    :condition
    {:targetsPresentCondition
     {:status boolean, :missingTargets [string], :updateTime string}}},
   :repairRolloutRule
   {:id string,
    :jobs [string],
    :condition
    {:targetsPresentCondition
     {:status boolean,
      :missingTargets [string],
      :updateTime string}}}}],
 :suspended boolean,
 :updateTime string,
 :annotations object}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `Automation` resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it's in the mask. If the user doesn't provide a mask then all fields are overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, updating a `Automation` that does not exist will result in the creation of a new `Automation`.
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([name Automation]
    (projects-locations-deliveryPipelines-automations-patch
      name
      Automation
      nil))
  ([name Automation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Automation})))

(defn projects-locations-deliveryPipelines-automations-delete
  "Deletes a single Automation resource.
https://cloud.google.com/deploy

name <string> Required. The name of the `Automation` to delete. Format should be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/automations/{automation_name}`.

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, then deleting an already deleted or non-existing `Automation` will succeed.
validateOnly <boolean> Optional. If set, validate the request and verify whether the resource exists, but do not actually post it.
etag <string> Optional. The weak etag of the request. This checksum is computed by the server based on the value of other fields, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name]
    (projects-locations-deliveryPipelines-automations-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-automations-get
  "Gets details of a single Automation.
https://cloud.google.com/deploy

name <string> Required. Name of the `Automation`. Format must be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}/automations/{automation_name}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deliveryPipelines-automations-list
  "Lists Automations in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent `Delivery Pipeline`, which owns this collection of automations. Format must be `projects/{project_id}/locations/{location_name}/deliveryPipelines/{pipeline_name}`.

optional:
pageSize <integer> The maximum number of automations to return. The service may return fewer than this value. If unspecified, at most 50 automations will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Filter automations to be returned. All fields can be used in the filter.
orderBy <string> Field to sort by."
  ([parent]
    (projects-locations-deliveryPipelines-automations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/automations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-automationRuns-get
  "Gets details of a single AutomationRun.
https://cloud.google.com/deploy

name <string> Required. Name of the `AutomationRun`. Format must be `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deliveryPipelines-automationRuns-list
  "Lists AutomationRuns in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent `Delivery Pipeline`, which owns this collection of automationRuns. Format must be `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}`.

optional:
pageSize <integer> The maximum number of automationRuns to return. The service may return fewer than this value. If unspecified, at most 50 automationRuns will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Filter automationRuns to be returned. All fields can be used in the filter.
orderBy <string> Field to sort by."
  ([parent]
    (projects-locations-deliveryPipelines-automationRuns-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/automationRuns",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deliveryPipelines-automationRuns-cancel
  "Cancels an AutomationRun. The `state` of the `AutomationRun` after cancelling is `CANCELLED`. `CancelAutomationRun` can be called on AutomationRun in the state `IN_PROGRESS` and `PENDING`; AutomationRun in a different state returns an `FAILED_PRECONDITION` error.
https://cloud.google.com/deploy

name <string> Required. Name of the `AutomationRun`. Format is `projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}`.
CancelAutomationRunRequest:
object"
  [name CancelAutomationRunRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelAutomationRunRequest}))

(defn projects-locations-targets-list
  "Lists Targets in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent, which owns this collection of targets. Format must be `projects/{project_id}/locations/{location_name}`.

optional:
pageSize <integer> Optional. The maximum number of `Target` objects to return. The service may return fewer than this value. If unspecified, at most 50 `Target` objects will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Optional. Filter targets to be returned. See https://google.aip.dev/160 for more details.
orderBy <string> Optional. Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-targets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/targets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-targets-get
  "Gets details of a single Target.
https://cloud.google.com/deploy

name <string> Required. Name of the `Target`. Format must be `projects/{project_id}/locations/{location_name}/targets/{target_name}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-targets-create
  "Creates a new Target in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent collection in which the `Target` should be created. Format should be `projects/{project_id}/locations/{location_name}`.
Target:
{:description string,
 :labels object,
 :run {:location string},
 :multiTarget {:targetIds [string]},
 :uid string,
 :name string,
 :targetId string,
 :createTime string,
 :customTarget {:customTargetType string},
 :etag string,
 :requireApproval boolean,
 :updateTime string,
 :gke {:cluster string, :internalIp boolean, :proxyUrl string},
 :executionConfigs
 [{:usages
   [[EXECUTION_ENVIRONMENT_USAGE_UNSPECIFIED
     RENDER
     DEPLOY
     VERIFY
     PREDEPLOY
     POSTDEPLOY]],
   :defaultPool {:serviceAccount string, :artifactStorage string},
   :privatePool
   {:workerPool string,
    :serviceAccount string,
    :artifactStorage string},
   :workerPool string,
   :serviceAccount string,
   :artifactStorage string,
   :executionTimeout string,
   :verbose boolean}],
 :annotations object,
 :anthosCluster {:membership string},
 :deployParameters object}

optional:
targetId <string> Required. ID of the `Target`.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([parent Target]
    (projects-locations-targets-create parent Target nil))
  ([parent Target optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/targets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Target})))

(defn projects-locations-targets-patch
  "Updates the parameters of a single Target.
https://cloud.google.com/deploy

name <string> Optional. Name of the `Target`. Format is `projects/{project}/locations/{location}/targets/{target}`. The `target` component must match `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`
Target:
{:description string,
 :labels object,
 :run {:location string},
 :multiTarget {:targetIds [string]},
 :uid string,
 :name string,
 :targetId string,
 :createTime string,
 :customTarget {:customTargetType string},
 :etag string,
 :requireApproval boolean,
 :updateTime string,
 :gke {:cluster string, :internalIp boolean, :proxyUrl string},
 :executionConfigs
 [{:usages
   [[EXECUTION_ENVIRONMENT_USAGE_UNSPECIFIED
     RENDER
     DEPLOY
     VERIFY
     PREDEPLOY
     POSTDEPLOY]],
   :defaultPool {:serviceAccount string, :artifactStorage string},
   :privatePool
   {:workerPool string,
    :serviceAccount string,
    :artifactStorage string},
   :workerPool string,
   :serviceAccount string,
   :artifactStorage string,
   :executionTimeout string,
   :verbose boolean}],
 :annotations object,
 :anthosCluster {:membership string},
 :deployParameters object}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Target resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it's in the mask. If the user doesn't provide a mask then all fields are overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, updating a `Target` that does not exist will result in the creation of a new `Target`.
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([name Target] (projects-locations-targets-patch name Target nil))
  ([name Target optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Target})))

(defn projects-locations-targets-delete
  "Deletes a single Target.
https://cloud.google.com/deploy

name <string> Required. The name of the `Target` to delete. Format should be `projects/{project_id}/locations/{location_name}/targets/{target_name}`.

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, then deleting an already deleted or non-existing `Target` will succeed.
validateOnly <boolean> Optional. If set, validate the request and preview the review, but do not actually post it.
etag <string> Optional. This checksum is computed by the server based on the value of other fields, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name] (projects-locations-targets-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-targets-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/deploy

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
     "https://clouddeploy.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-targets-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/deploy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-targets-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-targets-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/deploy

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://clouddeploy.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-customTargetTypes-list
  "Lists CustomTargetTypes in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent that owns this collection of custom target types. Format must be `projects/{project_id}/locations/{location_name}`.

optional:
pageSize <integer> Optional. The maximum number of `CustomTargetType` objects to return. The service may return fewer than this value. If unspecified, at most 50 `CustomTargetType` objects will be returned. The maximum value is 1000; values above 1000 will be set to 1000.
filter <string> Optional. Filter custom target types to be returned. See https://google.aip.dev/160 for more details.
orderBy <string> Optional. Field to sort by. See https://google.aip.dev/132#ordering for more details."
  ([parent] (projects-locations-customTargetTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/customTargetTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-customTargetTypes-get
  "Gets details of a single CustomTargetType.
https://cloud.google.com/deploy

name <string> Required. Name of the `CustomTargetType`. Format must be `projects/{project_id}/locations/{location_name}/customTargetTypes/{custom_target_type}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-customTargetTypes-create
  "Creates a new CustomTargetType in a given project and location.
https://cloud.google.com/deploy

parent <string> Required. The parent collection in which the `CustomTargetType` should be created. Format should be `projects/{project_id}/locations/{location_name}`.
CustomTargetType:
{:description string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :customActions
 {:renderAction string,
  :deployAction string,
  :includeSkaffoldModules
  [{:configs [string],
    :git {:repo string, :path string, :ref string},
    :googleCloudStorage {:source string, :path string},
    :googleCloudBuildRepo
    {:repository string, :path string, :ref string}}]},
 :customTargetTypeId string,
 :annotations object}

optional:
customTargetTypeId <string> Required. ID of the `CustomTargetType`.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([parent CustomTargetType]
    (projects-locations-customTargetTypes-create
      parent
      CustomTargetType
      nil))
  ([parent CustomTargetType optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+parent}/customTargetTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CustomTargetType})))

(defn projects-locations-customTargetTypes-patch
  "Updates a single CustomTargetType.
https://cloud.google.com/deploy

name <string> Optional. Name of the `CustomTargetType`. Format is `projects/{project}/locations/{location}/customTargetTypes/{customTargetType}`. The `customTargetType` component must match `[a-z]([a-z0-9-]{0,61}[a-z0-9])?`
CustomTargetType:
{:description string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :customActions
 {:renderAction string,
  :deployAction string,
  :includeSkaffoldModules
  [{:configs [string],
    :git {:repo string, :path string, :ref string},
    :googleCloudStorage {:source string, :path string},
    :googleCloudBuildRepo
    {:repository string, :path string, :ref string}}]},
 :customTargetTypeId string,
 :annotations object}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the `CustomTargetType` resource by the update. The fields specified in the update_mask are relative to the resource, not the full request. A field will be overwritten if it's in the mask. If the user doesn't provide a mask then all fields are overwritten.
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, updating a `CustomTargetType` that does not exist will result in the creation of a new `CustomTargetType`.
validateOnly <boolean> Optional. If set to true, the request is validated and the user is provided with an expected result, but no actual change is made."
  ([name CustomTargetType]
    (projects-locations-customTargetTypes-patch
      name
      CustomTargetType
      nil))
  ([name CustomTargetType optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CustomTargetType})))

(defn projects-locations-customTargetTypes-delete
  "Deletes a single CustomTargetType.
https://cloud.google.com/deploy

name <string> Required. The name of the `CustomTargetType` to delete. Format must be `projects/{project_id}/locations/{location_name}/customTargetTypes/{custom_target_type}`.

optional:
requestId <string> Optional. A request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server knows to ignore the request if it has already been completed. The server guarantees that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
allowMissing <boolean> Optional. If set to true, then deleting an already deleted or non-existing `CustomTargetType` will succeed.
validateOnly <boolean> Optional. If set to true, the request is validated but no actual change is made.
etag <string> Optional. This checksum is computed by the server based on the value of other fields, and may be sent on update and delete requests to ensure the client has an up-to-date value before proceeding."
  ([name] (projects-locations-customTargetTypes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://clouddeploy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-customTargetTypes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/deploy

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
     "https://clouddeploy.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-customTargetTypes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/deploy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-customTargetTypes-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://clouddeploy.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

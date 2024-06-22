(ns happygapi2.cloudfunctions
  "Cloud Functions API
Manages lightweight user-provided functions executed in response to events.
See: https://cloud.google.com/functions"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudfunctions.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-functions-get
  "Returns a function with the given name from the requested project.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/get

name <string> Required. The name of the function which details should be obtained.

optional:
revision <string> Optional. The optional version of the 1st gen function whose details should be obtained. The version of a 1st gen function is an integer that starts from 1 and gets incremented on redeployments. GCF may keep historical configs for old versions of 1st gen function. This field can be specified to fetch the historical configs. This field is valid only for GCF 1st gen function."
  ([name] (projects-locations-functions-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-functions-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/setIamPolicy

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
     "https://cloudfunctions.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-functions-setupFunctionUpgradeConfig
  "Creates a 2nd Gen copy of the function configuration based on the 1st Gen function with the given name. This is the first step of the multi step process to upgrade 1st Gen functions to 2nd Gen. Only 2nd Gen configuration is setup as part of this request and traffic continues to be served by 1st Gen.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/setupFunctionUpgradeConfig

name <string> Required. The name of the function which should have configuration copied for upgrade.
SetupFunctionUpgradeConfigRequest:
object"
  [name SetupFunctionUpgradeConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+name}:setupFunctionUpgradeConfig",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetupFunctionUpgradeConfigRequest}))

(defn projects-locations-functions-patch
  "Updates existing function.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/patch

name <string> A user-defined name of the function. Function names must be unique globally and match pattern `projects/*/locations/*/functions/*`
Function:
{:description string,
 :labels object,
 :name string,
 :createTime string,
 :upgradeInfo
 {:upgradeState
  [UPGRADE_STATE_UNSPECIFIED
   ELIGIBLE_FOR_2ND_GEN_UPGRADE
   UPGRADE_OPERATION_IN_PROGRESS
   SETUP_FUNCTION_UPGRADE_CONFIG_SUCCESSFUL
   SETUP_FUNCTION_UPGRADE_CONFIG_ERROR
   ABORT_FUNCTION_UPGRADE_ERROR
   REDIRECT_FUNCTION_UPGRADE_TRAFFIC_SUCCESSFUL
   REDIRECT_FUNCTION_UPGRADE_TRAFFIC_ERROR
   ROLLBACK_FUNCTION_UPGRADE_TRAFFIC_ERROR
   COMMIT_FUNCTION_UPGRADE_ERROR],
  :serviceConfig
  {:maxInstanceCount integer,
   :service string,
   :maxInstanceRequestConcurrency integer,
   :secretEnvironmentVariables
   [{:key string, :projectId string, :secret string, :version string}],
   :secretVolumes
   [{:mountPath string,
     :projectId string,
     :secret string,
     :versions [{:version string, :path string}]}],
   :revision string,
   :allTrafficOnLatestRevision boolean,
   :environmentVariables object,
   :vpcConnector string,
   :binaryAuthorizationPolicy string,
   :timeoutSeconds integer,
   :vpcConnectorEgressSettings
   [VPC_CONNECTOR_EGRESS_SETTINGS_UNSPECIFIED
    PRIVATE_RANGES_ONLY
    ALL_TRAFFIC],
   :availableMemory string,
   :serviceAccountEmail string,
   :securityLevel
   [SECURITY_LEVEL_UNSPECIFIED SECURE_ALWAYS SECURE_OPTIONAL],
   :minInstanceCount integer,
   :uri string,
   :availableCpu string,
   :ingressSettings
   [INGRESS_SETTINGS_UNSPECIFIED
    ALLOW_ALL
    ALLOW_INTERNAL_ONLY
    ALLOW_INTERNAL_AND_GCLB]},
  :eventTrigger
  {:eventType string,
   :service string,
   :triggerRegion string,
   :retryPolicy
   [RETRY_POLICY_UNSPECIFIED
    RETRY_POLICY_DO_NOT_RETRY
    RETRY_POLICY_RETRY],
   :channel string,
   :pubsubTopic string,
   :eventFilters
   [{:attribute string, :value string, :operator string}],
   :serviceAccountEmail string,
   :trigger string},
  :buildConfig
  {:serviceAccount string,
   :sourceToken string,
   :entryPoint string,
   :environmentVariables object,
   :source
   {:storageSource
    {:bucket string,
     :object string,
     :generation string,
     :sourceUploadUrl string},
    :repoSource
    {:branchName string,
     :tagName string,
     :commitSha string,
     :projectId string,
     :repoName string,
     :dir string},
    :gitUri string},
   :build string,
   :automaticUpdatePolicy object,
   :runtime string,
   :sourceProvenance
   {:resolvedStorageSource
    {:bucket string,
     :object string,
     :generation string,
     :sourceUploadUrl string},
    :resolvedRepoSource
    {:branchName string,
     :tagName string,
     :commitSha string,
     :projectId string,
     :repoName string,
     :dir string},
    :gitUri string},
   :dockerRepository string,
   :workerPool string,
   :onDeployUpdatePolicy {:runtimeVersion string},
   :dockerRegistry
   [DOCKER_REGISTRY_UNSPECIFIED
    CONTAINER_REGISTRY
    ARTIFACT_REGISTRY]}},
 :buildConfig
 {:serviceAccount string,
  :sourceToken string,
  :entryPoint string,
  :environmentVariables object,
  :source
  {:storageSource
   {:bucket string,
    :object string,
    :generation string,
    :sourceUploadUrl string},
   :repoSource
   {:branchName string,
    :tagName string,
    :commitSha string,
    :projectId string,
    :repoName string,
    :dir string},
   :gitUri string},
  :build string,
  :automaticUpdatePolicy object,
  :runtime string,
  :sourceProvenance
  {:resolvedStorageSource
   {:bucket string,
    :object string,
    :generation string,
    :sourceUploadUrl string},
   :resolvedRepoSource
   {:branchName string,
    :tagName string,
    :commitSha string,
    :projectId string,
    :repoName string,
    :dir string},
   :gitUri string},
  :dockerRepository string,
  :workerPool string,
  :onDeployUpdatePolicy {:runtimeVersion string},
  :dockerRegistry
  [DOCKER_REGISTRY_UNSPECIFIED CONTAINER_REGISTRY ARTIFACT_REGISTRY]},
 :state [STATE_UNSPECIFIED ACTIVE FAILED DEPLOYING DELETING UNKNOWN],
 :updateTime string,
 :eventTrigger
 {:eventType string,
  :service string,
  :triggerRegion string,
  :retryPolicy
  [RETRY_POLICY_UNSPECIFIED
   RETRY_POLICY_DO_NOT_RETRY
   RETRY_POLICY_RETRY],
  :channel string,
  :pubsubTopic string,
  :eventFilters [{:attribute string, :value string, :operator string}],
  :serviceAccountEmail string,
  :trigger string},
 :satisfiesPzs boolean,
 :serviceConfig
 {:maxInstanceCount integer,
  :service string,
  :maxInstanceRequestConcurrency integer,
  :secretEnvironmentVariables
  [{:key string, :projectId string, :secret string, :version string}],
  :secretVolumes
  [{:mountPath string,
    :projectId string,
    :secret string,
    :versions [{:version string, :path string}]}],
  :revision string,
  :allTrafficOnLatestRevision boolean,
  :environmentVariables object,
  :vpcConnector string,
  :binaryAuthorizationPolicy string,
  :timeoutSeconds integer,
  :vpcConnectorEgressSettings
  [VPC_CONNECTOR_EGRESS_SETTINGS_UNSPECIFIED
   PRIVATE_RANGES_ONLY
   ALL_TRAFFIC],
  :availableMemory string,
  :serviceAccountEmail string,
  :securityLevel
  [SECURITY_LEVEL_UNSPECIFIED SECURE_ALWAYS SECURE_OPTIONAL],
  :minInstanceCount integer,
  :uri string,
  :availableCpu string,
  :ingressSettings
  [INGRESS_SETTINGS_UNSPECIFIED
   ALLOW_ALL
   ALLOW_INTERNAL_ONLY
   ALLOW_INTERNAL_AND_GCLB]},
 :kmsKeyName string,
 :url string,
 :environment [ENVIRONMENT_UNSPECIFIED GEN_1 GEN_2],
 :stateMessages
 [{:severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
   :type string,
   :message string}]}

optional:
updateMask <string> The list of fields to be updated. If no field mask is provided, all provided fields in the request will be updated."
  ([name Function]
    (projects-locations-functions-patch name Function nil))
  ([name Function optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Function})))

(defn projects-locations-functions-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-functions-redirectFunctionUpgradeTraffic
  "Changes the traffic target of a function from the original 1st Gen function to the 2nd Gen copy. This is the second step of the multi step process to upgrade 1st Gen functions to 2nd Gen. After this operation, all new traffic will be served by 2nd Gen copy.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/redirectFunctionUpgradeTraffic

name <string> Required. The name of the function for which traffic target should be changed to 2nd Gen from 1st Gen.
RedirectFunctionUpgradeTrafficRequest:
object"
  [name RedirectFunctionUpgradeTrafficRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+name}:redirectFunctionUpgradeTraffic",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RedirectFunctionUpgradeTrafficRequest}))

(defn projects-locations-functions-create
  "Creates a new function. If a function with the given name already exists in the specified project, the long running operation will return `ALREADY_EXISTS` error.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/create

parent <string> Required. The project and location in which the function should be created, specified in the format `projects/*/locations/*`
Function:
{:description string,
 :labels object,
 :name string,
 :createTime string,
 :upgradeInfo
 {:upgradeState
  [UPGRADE_STATE_UNSPECIFIED
   ELIGIBLE_FOR_2ND_GEN_UPGRADE
   UPGRADE_OPERATION_IN_PROGRESS
   SETUP_FUNCTION_UPGRADE_CONFIG_SUCCESSFUL
   SETUP_FUNCTION_UPGRADE_CONFIG_ERROR
   ABORT_FUNCTION_UPGRADE_ERROR
   REDIRECT_FUNCTION_UPGRADE_TRAFFIC_SUCCESSFUL
   REDIRECT_FUNCTION_UPGRADE_TRAFFIC_ERROR
   ROLLBACK_FUNCTION_UPGRADE_TRAFFIC_ERROR
   COMMIT_FUNCTION_UPGRADE_ERROR],
  :serviceConfig
  {:maxInstanceCount integer,
   :service string,
   :maxInstanceRequestConcurrency integer,
   :secretEnvironmentVariables
   [{:key string, :projectId string, :secret string, :version string}],
   :secretVolumes
   [{:mountPath string,
     :projectId string,
     :secret string,
     :versions [{:version string, :path string}]}],
   :revision string,
   :allTrafficOnLatestRevision boolean,
   :environmentVariables object,
   :vpcConnector string,
   :binaryAuthorizationPolicy string,
   :timeoutSeconds integer,
   :vpcConnectorEgressSettings
   [VPC_CONNECTOR_EGRESS_SETTINGS_UNSPECIFIED
    PRIVATE_RANGES_ONLY
    ALL_TRAFFIC],
   :availableMemory string,
   :serviceAccountEmail string,
   :securityLevel
   [SECURITY_LEVEL_UNSPECIFIED SECURE_ALWAYS SECURE_OPTIONAL],
   :minInstanceCount integer,
   :uri string,
   :availableCpu string,
   :ingressSettings
   [INGRESS_SETTINGS_UNSPECIFIED
    ALLOW_ALL
    ALLOW_INTERNAL_ONLY
    ALLOW_INTERNAL_AND_GCLB]},
  :eventTrigger
  {:eventType string,
   :service string,
   :triggerRegion string,
   :retryPolicy
   [RETRY_POLICY_UNSPECIFIED
    RETRY_POLICY_DO_NOT_RETRY
    RETRY_POLICY_RETRY],
   :channel string,
   :pubsubTopic string,
   :eventFilters
   [{:attribute string, :value string, :operator string}],
   :serviceAccountEmail string,
   :trigger string},
  :buildConfig
  {:serviceAccount string,
   :sourceToken string,
   :entryPoint string,
   :environmentVariables object,
   :source
   {:storageSource
    {:bucket string,
     :object string,
     :generation string,
     :sourceUploadUrl string},
    :repoSource
    {:branchName string,
     :tagName string,
     :commitSha string,
     :projectId string,
     :repoName string,
     :dir string},
    :gitUri string},
   :build string,
   :automaticUpdatePolicy object,
   :runtime string,
   :sourceProvenance
   {:resolvedStorageSource
    {:bucket string,
     :object string,
     :generation string,
     :sourceUploadUrl string},
    :resolvedRepoSource
    {:branchName string,
     :tagName string,
     :commitSha string,
     :projectId string,
     :repoName string,
     :dir string},
    :gitUri string},
   :dockerRepository string,
   :workerPool string,
   :onDeployUpdatePolicy {:runtimeVersion string},
   :dockerRegistry
   [DOCKER_REGISTRY_UNSPECIFIED
    CONTAINER_REGISTRY
    ARTIFACT_REGISTRY]}},
 :buildConfig
 {:serviceAccount string,
  :sourceToken string,
  :entryPoint string,
  :environmentVariables object,
  :source
  {:storageSource
   {:bucket string,
    :object string,
    :generation string,
    :sourceUploadUrl string},
   :repoSource
   {:branchName string,
    :tagName string,
    :commitSha string,
    :projectId string,
    :repoName string,
    :dir string},
   :gitUri string},
  :build string,
  :automaticUpdatePolicy object,
  :runtime string,
  :sourceProvenance
  {:resolvedStorageSource
   {:bucket string,
    :object string,
    :generation string,
    :sourceUploadUrl string},
   :resolvedRepoSource
   {:branchName string,
    :tagName string,
    :commitSha string,
    :projectId string,
    :repoName string,
    :dir string},
   :gitUri string},
  :dockerRepository string,
  :workerPool string,
  :onDeployUpdatePolicy {:runtimeVersion string},
  :dockerRegistry
  [DOCKER_REGISTRY_UNSPECIFIED CONTAINER_REGISTRY ARTIFACT_REGISTRY]},
 :state [STATE_UNSPECIFIED ACTIVE FAILED DEPLOYING DELETING UNKNOWN],
 :updateTime string,
 :eventTrigger
 {:eventType string,
  :service string,
  :triggerRegion string,
  :retryPolicy
  [RETRY_POLICY_UNSPECIFIED
   RETRY_POLICY_DO_NOT_RETRY
   RETRY_POLICY_RETRY],
  :channel string,
  :pubsubTopic string,
  :eventFilters [{:attribute string, :value string, :operator string}],
  :serviceAccountEmail string,
  :trigger string},
 :satisfiesPzs boolean,
 :serviceConfig
 {:maxInstanceCount integer,
  :service string,
  :maxInstanceRequestConcurrency integer,
  :secretEnvironmentVariables
  [{:key string, :projectId string, :secret string, :version string}],
  :secretVolumes
  [{:mountPath string,
    :projectId string,
    :secret string,
    :versions [{:version string, :path string}]}],
  :revision string,
  :allTrafficOnLatestRevision boolean,
  :environmentVariables object,
  :vpcConnector string,
  :binaryAuthorizationPolicy string,
  :timeoutSeconds integer,
  :vpcConnectorEgressSettings
  [VPC_CONNECTOR_EGRESS_SETTINGS_UNSPECIFIED
   PRIVATE_RANGES_ONLY
   ALL_TRAFFIC],
  :availableMemory string,
  :serviceAccountEmail string,
  :securityLevel
  [SECURITY_LEVEL_UNSPECIFIED SECURE_ALWAYS SECURE_OPTIONAL],
  :minInstanceCount integer,
  :uri string,
  :availableCpu string,
  :ingressSettings
  [INGRESS_SETTINGS_UNSPECIFIED
   ALLOW_ALL
   ALLOW_INTERNAL_ONLY
   ALLOW_INTERNAL_AND_GCLB]},
 :kmsKeyName string,
 :url string,
 :environment [ENVIRONMENT_UNSPECIFIED GEN_1 GEN_2],
 :stateMessages
 [{:severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
   :type string,
   :message string}]}

optional:
functionId <string> The ID to use for the function, which will become the final component of the function's resource name. This value should be 4-63 characters, and valid characters are /a-z-/."
  ([parent Function]
    (projects-locations-functions-create parent Function nil))
  ([parent Function optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+parent}/functions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Function})))

(defn projects-locations-functions-generateUploadUrl
  "Returns a signed URL for uploading a function source code. For more information about the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls. Once the function source code upload is complete, the used signed URL should be provided in CreateFunction or UpdateFunction request as a reference to the function source code. When uploading source code to the generated signed URL, please follow these restrictions: * Source file type should be a zip file. * No credentials should be attached - the signed URLs provide access to the target bucket using internal service identity; if credentials were attached, the identity from the credentials would be used, but that identity does not have permissions to upload files to the URL. When making a HTTP PUT request, specify this header: * `content-type: application/zip` Do not specify this header: * `Authorization: Bearer YOUR_TOKEN`
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/generateUploadUrl

parent <string> Required. The project and location in which the Google Cloud Storage signed URL should be generated, specified in the format `projects/*/locations/*`.
GenerateUploadUrlRequest:
{:kmsKeyName string, :environment [ENVIRONMENT_UNSPECIFIED GEN_1 GEN_2]}"
  [parent GenerateUploadUrlRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+parent}/functions:generateUploadUrl",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateUploadUrlRequest}))

(defn projects-locations-functions-delete
  "Deletes a function with the given name from the specified project. If the given function is used by some trigger, the trigger will be updated to remove this function.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/delete

name <string> Required. The name of the function which should be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://cloudfunctions.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-functions-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-functions-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-functions-generateDownloadUrl
  "Returns a signed URL for downloading deployed function source code. The URL is only valid for a limited period and should be used within 30 minutes of generation. For more information about the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/generateDownloadUrl

name <string> Required. The name of function for which source code Google Cloud Storage signed URL should be generated.
GenerateDownloadUrlRequest:
object"
  [name GenerateDownloadUrlRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+name}:generateDownloadUrl",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateDownloadUrlRequest}))

(defn projects-locations-functions-commitFunctionUpgrade
  "Finalizes the upgrade after which function upgrade can not be rolled back. This is the last step of the multi step process to upgrade 1st Gen functions to 2nd Gen. Deletes all original 1st Gen related configuration and resources.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/commitFunctionUpgrade

name <string> Required. The name of the function for which upgrade should be finalized.
CommitFunctionUpgradeRequest:
object"
  [name CommitFunctionUpgradeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+name}:commitFunctionUpgrade",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CommitFunctionUpgradeRequest}))

(defn projects-locations-functions-list
  "Returns a list of functions that belong to the requested project.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/list

parent <string> Required. The project and location from which the function should be listed, specified in the format `projects/*/locations/*` If you want to list functions in all locations, use \"-\" in place of a location. When listing functions in all locations, if one or more location(s) are unreachable, the response will contain functions from all reachable locations along with the names of any unreachable locations.

optional:
pageSize <integer> Maximum number of functions to return per call. The largest allowed page_size is 1,000, if the page_size is omitted or specified as greater than 1,000 then it will be replaced as 1,000. The size of the list response can be less than specified when used with filters.
filter <string> The filter for Functions that match the filter expression, following the syntax outlined in https://google.aip.dev/160.
orderBy <string> The sorting order of the resources returned. Value should be a comma separated list of fields. The default sorting oder is ascending. See https://google.aip.dev/132#ordering."
  ([parent] (projects-locations-functions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+parent}/functions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-functions-rollbackFunctionUpgradeTraffic
  "Reverts the traffic target of a function from the 2nd Gen copy to the original 1st Gen function. After this operation, all new traffic would be served by the 1st Gen.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/rollbackFunctionUpgradeTraffic

name <string> Required. The name of the function for which traffic target should be changed back to 1st Gen from 2nd Gen.
RollbackFunctionUpgradeTrafficRequest:
object"
  [name RollbackFunctionUpgradeTrafficRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+name}:rollbackFunctionUpgradeTraffic",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RollbackFunctionUpgradeTrafficRequest}))

(defn projects-locations-functions-abortFunctionUpgrade
  "Aborts generation upgrade process for a function with the given name from the specified project. Deletes all 2nd Gen copy related configuration and resources which were created during the upgrade process.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.functions/abortFunctionUpgrade

name <string> Required. The name of the function for which upgrade should be aborted.
AbortFunctionUpgradeRequest:
object"
  [name AbortFunctionUpgradeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudfunctions.googleapis.com/v2/{+name}:abortFunctionUpgrade",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AbortFunctionUpgradeRequest}))

(defn projects-locations-runtimes-list
  "Returns a list of runtimes that are supported for the requested project.
https://cloud.google.com/functions/docs/reference/rest/v2/projects.locations.runtimes/list

parent <string> Required. The project and location from which the runtimes should be listed, specified in the format `projects/*/locations/*`

optional:
filter <string> The filter for Runtimes that match the filter expression, following the syntax outlined in https://google.aip.dev/160."
  ([parent] (projects-locations-runtimes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudfunctions.googleapis.com/v2/{+parent}/runtimes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

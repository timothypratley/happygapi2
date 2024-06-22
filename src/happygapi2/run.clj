(ns happygapi2.run
  "Cloud Run Admin API
Deploy and manage user provided container images that scale automatically based on incoming requests. The Cloud Run Admin API v1 follows the Knative Serving API specification, while v2 is aligned with Google Cloud AIP-based API standards, as described in https://google.aip.dev/.
See: https://cloud.google.com/run/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-exportMetadata
  "Export generated customer metadata for a given resource.
https://cloud.google.com/run

name <string> Required. The name of the resource of which metadata should be exported. Format: `projects/{project_id_or_number}/locations/{location}/services/{service}` for Service `projects/{project_id_or_number}/locations/{location}/services/{service}/revisions/{revision}` for Revision `projects/{project_id_or_number}/locations/{location}/jobs/{job}/executions/{execution}` for Execution"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://run.googleapis.com/v2/{+name}:exportMetadata",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-exportImageMetadata
  "Export image metadata for a given resource.
https://cloud.google.com/run

name <string> Required. The name of the resource of which image metadata should be exported. Format: `projects/{project_id_or_number}/locations/{location}/services/{service}/revisions/{revision}` for Revision `projects/{project_id_or_number}/locations/{location}/jobs/{job}/executions/{execution}` for Execution"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://run.googleapis.com/v2/{+name}:exportImageMetadata",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-exportImage
  "Export image for a given resource.
https://cloud.google.com/run

name <string> Required. The name of the resource of which image metadata should be exported. Format: `projects/{project_id_or_number}/locations/{location}/services/{service}/revisions/{revision}` for Revision `projects/{project_id_or_number}/locations/{location}/jobs/{job}/executions/{execution}` for Execution
GoogleCloudRunV2ExportImageRequest:
{:destinationRepo string}"
  [name GoogleCloudRunV2ExportImageRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://run.googleapis.com/v2/{+name}:exportImage",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRunV2ExportImageRequest}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/run

name <string> Required. To query for all of the operations for a project.

optional:
filter <string> Optional. A filter for matching the completed or in-progress operations. The supported formats of *filter* are: To query for only completed operations: done:true To query for only ongoing operations: done:false Must be empty to query for all of the latest operations for the given parent project.
pageSize <integer> The maximum number of records that should be returned. Requested page size cannot exceed 100. If not set or set to less than or equal to 0, the default page size is 100. ."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://run.googleapis.com/v2/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/run

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://run.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/run

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://run.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-wait
  "Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done.
https://cloud.google.com/run

name <string> The name of the operation resource to wait on.
GoogleLongrunningWaitOperationRequest:
{:timeout string}"
  [name GoogleLongrunningWaitOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://run.googleapis.com/v2/{+name}:wait",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningWaitOperationRequest}))

(defn projects-locations-jobs-get
  "Gets information about a Job.
https://cloud.google.com/run

name <string> Required. The full name of the Job. Format: projects/{project}/locations/{location}/jobs/{job}, where {project} can be project id or number."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://run.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-setIamPolicy
  "Sets the IAM Access control policy for the specified Job. Overwrites any existing policy.
https://cloud.google.com/run

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://run.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-jobs-run
  "Triggers creation of a new Execution of this Job.
https://cloud.google.com/run

name <string> Required. The full name of the Job. Format: projects/{project}/locations/{location}/jobs/{job}, where {project} can be project id or number.
GoogleCloudRunV2RunJobRequest:
{:validateOnly boolean,
 :etag string,
 :overrides
 {:containerOverrides
  [{:name string,
    :args [string],
    :env
    [{:name string,
      :value string,
      :valueSource {:secretKeyRef GoogleCloudRunV2SecretKeySelector}}],
    :clearArgs boolean}],
  :taskCount integer,
  :timeout string}}"
  [name GoogleCloudRunV2RunJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://run.googleapis.com/v2/{+name}:run",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRunV2RunJobRequest}))

(defn projects-locations-jobs-patch
  "Updates a Job.
https://cloud.google.com/run

name <string> The fully qualified name of this Job. Format: projects/{project}/locations/{location}/jobs/{job}
GoogleCloudRunV2Job:
{:labels object,
 :deleteTime string,
 :terminalCondition
 {:type string,
  :state
  [STATE_UNSPECIFIED
   CONDITION_PENDING
   CONDITION_RECONCILING
   CONDITION_FAILED
   CONDITION_SUCCEEDED],
  :message string,
  :lastTransitionTime string,
  :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
  :reason
  [COMMON_REASON_UNDEFINED
   UNKNOWN
   REVISION_FAILED
   PROGRESS_DEADLINE_EXCEEDED
   CONTAINER_MISSING
   CONTAINER_PERMISSION_DENIED
   CONTAINER_IMAGE_UNAUTHORIZED
   CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
   ENCRYPTION_KEY_PERMISSION_DENIED
   ENCRYPTION_KEY_CHECK_FAILED
   SECRETS_ACCESS_CHECK_FAILED
   WAITING_FOR_OPERATION
   IMMEDIATE_RETRY
   POSTPONED_RETRY
   INTERNAL],
  :revisionReason
  [REVISION_REASON_UNDEFINED
   PENDING
   RESERVE
   RETIRED
   RETIRING
   RECREATING
   HEALTH_CHECK_CONTAINER_ERROR
   CUSTOMIZED_PATH_RESPONSE_PENDING
   MIN_INSTANCES_NOT_PROVISIONED
   ACTIVE_REVISION_LIMIT_REACHED
   NO_DEPLOYMENT
   HEALTH_CHECK_SKIPPED
   MIN_INSTANCES_WARMING],
  :executionReason
  [EXECUTION_REASON_UNDEFINED
   JOB_STATUS_SERVICE_POLLING_ERROR
   NON_ZERO_EXIT_CODE
   CANCELLED
   CANCELLING
   DELETED]},
 :generation string,
 :creator string,
 :uid string,
 :name string,
 :executionCount integer,
 :binaryAuthorization
 {:useDefault boolean,
  :policy string,
  :breakglassJustification string},
 :client string,
 :createTime string,
 :etag string,
 :template
 {:labels object,
  :annotations object,
  :parallelism integer,
  :taskCount integer,
  :template
  {:containers
   [{:args [string],
     :volumeMounts [{:name string, :mountPath string}],
     :dependsOn [string],
     :name string,
     :command [string],
     :env
     [{:name string,
       :value string,
       :valueSource GoogleCloudRunV2EnvVarSource}],
     :ports [{:name string, :containerPort integer}],
     :startupProbe
     {:initialDelaySeconds integer,
      :timeoutSeconds integer,
      :periodSeconds integer,
      :failureThreshold integer,
      :httpGet GoogleCloudRunV2HTTPGetAction,
      :tcpSocket GoogleCloudRunV2TCPSocketAction,
      :grpc GoogleCloudRunV2GRPCAction},
     :livenessProbe
     {:initialDelaySeconds integer,
      :timeoutSeconds integer,
      :periodSeconds integer,
      :failureThreshold integer,
      :httpGet GoogleCloudRunV2HTTPGetAction,
      :tcpSocket GoogleCloudRunV2TCPSocketAction,
      :grpc GoogleCloudRunV2GRPCAction},
     :workingDir string,
     :image string,
     :resources
     {:limits object, :cpuIdle boolean, :startupCpuBoost boolean}}],
   :volumes
   [{:name string,
     :secret
     {:secret string,
      :items [GoogleCloudRunV2VersionToPath],
      :defaultMode integer},
     :cloudSqlInstance {:instances [string]},
     :emptyDir
     {:medium [MEDIUM_UNSPECIFIED MEMORY], :sizeLimit string},
     :nfs {:server string, :path string, :readOnly boolean},
     :gcs {:bucket string, :readOnly boolean}}],
   :maxRetries integer,
   :timeout string,
   :serviceAccount string,
   :executionEnvironment
   [EXECUTION_ENVIRONMENT_UNSPECIFIED
    EXECUTION_ENVIRONMENT_GEN1
    EXECUTION_ENVIRONMENT_GEN2],
   :encryptionKey string,
   :vpcAccess
   {:connector string,
    :egress [VPC_EGRESS_UNSPECIFIED ALL_TRAFFIC PRIVATE_RANGES_ONLY],
    :networkInterfaces
    [{:network string, :subnetwork string, :tags [string]}]}}},
 :lastModifier string,
 :observedGeneration string,
 :updateTime string,
 :reconciling boolean,
 :latestCreatedExecution
 {:name string, :createTime string, :completionTime string},
 :conditions
 [{:type string,
   :state
   [STATE_UNSPECIFIED
    CONDITION_PENDING
    CONDITION_RECONCILING
    CONDITION_FAILED
    CONDITION_SUCCEEDED],
   :message string,
   :lastTransitionTime string,
   :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
   :reason
   [COMMON_REASON_UNDEFINED
    UNKNOWN
    REVISION_FAILED
    PROGRESS_DEADLINE_EXCEEDED
    CONTAINER_MISSING
    CONTAINER_PERMISSION_DENIED
    CONTAINER_IMAGE_UNAUTHORIZED
    CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
    ENCRYPTION_KEY_PERMISSION_DENIED
    ENCRYPTION_KEY_CHECK_FAILED
    SECRETS_ACCESS_CHECK_FAILED
    WAITING_FOR_OPERATION
    IMMEDIATE_RETRY
    POSTPONED_RETRY
    INTERNAL],
   :revisionReason
   [REVISION_REASON_UNDEFINED
    PENDING
    RESERVE
    RETIRED
    RETIRING
    RECREATING
    HEALTH_CHECK_CONTAINER_ERROR
    CUSTOMIZED_PATH_RESPONSE_PENDING
    MIN_INSTANCES_NOT_PROVISIONED
    ACTIVE_REVISION_LIMIT_REACHED
    NO_DEPLOYMENT
    HEALTH_CHECK_SKIPPED
    MIN_INSTANCES_WARMING],
   :executionReason
   [EXECUTION_REASON_UNDEFINED
    JOB_STATUS_SERVICE_POLLING_ERROR
    NON_ZERO_EXIT_CODE
    CANCELLED
    CANCELLING
    DELETED]}],
 :clientVersion string,
 :satisfiesPzs boolean,
 :runExecutionToken string,
 :startExecutionToken string,
 :annotations object,
 :expireTime string,
 :launchStage
 [LAUNCH_STAGE_UNSPECIFIED
  UNIMPLEMENTED
  PRELAUNCH
  EARLY_ACCESS
  ALPHA
  BETA
  GA
  DEPRECATED]}

optional:
validateOnly <boolean> Indicates that the request should be validated and default values populated, without persisting the request or updating any resources.
allowMissing <boolean> Optional. If set to true, and if the Job does not exist, it will create a new one. Caller must have both create and update permissions for this call if this is set to true."
  ([name GoogleCloudRunV2Job]
    (projects-locations-jobs-patch name GoogleCloudRunV2Job nil))
  ([name GoogleCloudRunV2Job optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://run.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudRunV2Job})))

(defn projects-locations-jobs-testIamPermissions
  "Returns permissions that a caller has on the specified Project. There are no permissions required for making this API call.
https://cloud.google.com/run

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://run.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-jobs-create
  "Creates a Job.
https://cloud.google.com/run

parent <string> Required. The location and project in which this Job should be created. Format: projects/{project}/locations/{location}, where {project} can be project id or number.
GoogleCloudRunV2Job:
{:labels object,
 :deleteTime string,
 :terminalCondition
 {:type string,
  :state
  [STATE_UNSPECIFIED
   CONDITION_PENDING
   CONDITION_RECONCILING
   CONDITION_FAILED
   CONDITION_SUCCEEDED],
  :message string,
  :lastTransitionTime string,
  :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
  :reason
  [COMMON_REASON_UNDEFINED
   UNKNOWN
   REVISION_FAILED
   PROGRESS_DEADLINE_EXCEEDED
   CONTAINER_MISSING
   CONTAINER_PERMISSION_DENIED
   CONTAINER_IMAGE_UNAUTHORIZED
   CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
   ENCRYPTION_KEY_PERMISSION_DENIED
   ENCRYPTION_KEY_CHECK_FAILED
   SECRETS_ACCESS_CHECK_FAILED
   WAITING_FOR_OPERATION
   IMMEDIATE_RETRY
   POSTPONED_RETRY
   INTERNAL],
  :revisionReason
  [REVISION_REASON_UNDEFINED
   PENDING
   RESERVE
   RETIRED
   RETIRING
   RECREATING
   HEALTH_CHECK_CONTAINER_ERROR
   CUSTOMIZED_PATH_RESPONSE_PENDING
   MIN_INSTANCES_NOT_PROVISIONED
   ACTIVE_REVISION_LIMIT_REACHED
   NO_DEPLOYMENT
   HEALTH_CHECK_SKIPPED
   MIN_INSTANCES_WARMING],
  :executionReason
  [EXECUTION_REASON_UNDEFINED
   JOB_STATUS_SERVICE_POLLING_ERROR
   NON_ZERO_EXIT_CODE
   CANCELLED
   CANCELLING
   DELETED]},
 :generation string,
 :creator string,
 :uid string,
 :name string,
 :executionCount integer,
 :binaryAuthorization
 {:useDefault boolean,
  :policy string,
  :breakglassJustification string},
 :client string,
 :createTime string,
 :etag string,
 :template
 {:labels object,
  :annotations object,
  :parallelism integer,
  :taskCount integer,
  :template
  {:containers
   [{:args [string],
     :volumeMounts [{:name string, :mountPath string}],
     :dependsOn [string],
     :name string,
     :command [string],
     :env
     [{:name string,
       :value string,
       :valueSource GoogleCloudRunV2EnvVarSource}],
     :ports [{:name string, :containerPort integer}],
     :startupProbe
     {:initialDelaySeconds integer,
      :timeoutSeconds integer,
      :periodSeconds integer,
      :failureThreshold integer,
      :httpGet GoogleCloudRunV2HTTPGetAction,
      :tcpSocket GoogleCloudRunV2TCPSocketAction,
      :grpc GoogleCloudRunV2GRPCAction},
     :livenessProbe
     {:initialDelaySeconds integer,
      :timeoutSeconds integer,
      :periodSeconds integer,
      :failureThreshold integer,
      :httpGet GoogleCloudRunV2HTTPGetAction,
      :tcpSocket GoogleCloudRunV2TCPSocketAction,
      :grpc GoogleCloudRunV2GRPCAction},
     :workingDir string,
     :image string,
     :resources
     {:limits object, :cpuIdle boolean, :startupCpuBoost boolean}}],
   :volumes
   [{:name string,
     :secret
     {:secret string,
      :items [GoogleCloudRunV2VersionToPath],
      :defaultMode integer},
     :cloudSqlInstance {:instances [string]},
     :emptyDir
     {:medium [MEDIUM_UNSPECIFIED MEMORY], :sizeLimit string},
     :nfs {:server string, :path string, :readOnly boolean},
     :gcs {:bucket string, :readOnly boolean}}],
   :maxRetries integer,
   :timeout string,
   :serviceAccount string,
   :executionEnvironment
   [EXECUTION_ENVIRONMENT_UNSPECIFIED
    EXECUTION_ENVIRONMENT_GEN1
    EXECUTION_ENVIRONMENT_GEN2],
   :encryptionKey string,
   :vpcAccess
   {:connector string,
    :egress [VPC_EGRESS_UNSPECIFIED ALL_TRAFFIC PRIVATE_RANGES_ONLY],
    :networkInterfaces
    [{:network string, :subnetwork string, :tags [string]}]}}},
 :lastModifier string,
 :observedGeneration string,
 :updateTime string,
 :reconciling boolean,
 :latestCreatedExecution
 {:name string, :createTime string, :completionTime string},
 :conditions
 [{:type string,
   :state
   [STATE_UNSPECIFIED
    CONDITION_PENDING
    CONDITION_RECONCILING
    CONDITION_FAILED
    CONDITION_SUCCEEDED],
   :message string,
   :lastTransitionTime string,
   :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
   :reason
   [COMMON_REASON_UNDEFINED
    UNKNOWN
    REVISION_FAILED
    PROGRESS_DEADLINE_EXCEEDED
    CONTAINER_MISSING
    CONTAINER_PERMISSION_DENIED
    CONTAINER_IMAGE_UNAUTHORIZED
    CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
    ENCRYPTION_KEY_PERMISSION_DENIED
    ENCRYPTION_KEY_CHECK_FAILED
    SECRETS_ACCESS_CHECK_FAILED
    WAITING_FOR_OPERATION
    IMMEDIATE_RETRY
    POSTPONED_RETRY
    INTERNAL],
   :revisionReason
   [REVISION_REASON_UNDEFINED
    PENDING
    RESERVE
    RETIRED
    RETIRING
    RECREATING
    HEALTH_CHECK_CONTAINER_ERROR
    CUSTOMIZED_PATH_RESPONSE_PENDING
    MIN_INSTANCES_NOT_PROVISIONED
    ACTIVE_REVISION_LIMIT_REACHED
    NO_DEPLOYMENT
    HEALTH_CHECK_SKIPPED
    MIN_INSTANCES_WARMING],
   :executionReason
   [EXECUTION_REASON_UNDEFINED
    JOB_STATUS_SERVICE_POLLING_ERROR
    NON_ZERO_EXIT_CODE
    CANCELLED
    CANCELLING
    DELETED]}],
 :clientVersion string,
 :satisfiesPzs boolean,
 :runExecutionToken string,
 :startExecutionToken string,
 :annotations object,
 :expireTime string,
 :launchStage
 [LAUNCH_STAGE_UNSPECIFIED
  UNIMPLEMENTED
  PRELAUNCH
  EARLY_ACCESS
  ALPHA
  BETA
  GA
  DEPRECATED]}

optional:
jobId <string> Required. The unique identifier for the Job. The name of the job becomes {parent}/jobs/{job_id}.
validateOnly <boolean> Indicates that the request should be validated and default values populated, without persisting the request or creating any resources."
  ([parent GoogleCloudRunV2Job]
    (projects-locations-jobs-create parent GoogleCloudRunV2Job nil))
  ([parent GoogleCloudRunV2Job optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://run.googleapis.com/v2/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudRunV2Job})))

(defn projects-locations-jobs-delete
  "Deletes a Job.
https://cloud.google.com/run

name <string> Required. The full name of the Job. Format: projects/{project}/locations/{location}/jobs/{job}, where {project} can be project id or number.

optional:
validateOnly <boolean> Indicates that the request should be validated without actually deleting any resources.
etag <string> A system-generated fingerprint for this version of the resource. May be used to detect modification conflict during updates."
  ([name] (projects-locations-jobs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://run.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-getIamPolicy
  "Gets the IAM Access Control policy currently in effect for the given Job. This result does not include any inherited policies.
https://cloud.google.com/run

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-jobs-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://run.googleapis.com/v2/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-list
  "Lists Jobs. Results are sorted by creation time, descending.
https://cloud.google.com/run

parent <string> Required. The location and project to list resources on. Format: projects/{project}/locations/{location}, where {project} can be project id or number.

optional:
pageSize <integer> Maximum number of Jobs to return in this call.
showDeleted <boolean> If true, returns deleted (but unexpired) resources along with active ones."
  ([parent] (projects-locations-jobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://run.googleapis.com/v2/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-executions-exportStatus
  "Read the status of an image export operation.
https://cloud.google.com/run

name <string> Required. The name of the resource of which image export operation status has to be fetched. Format: `projects/{project_id_or_number}/locations/{location}/services/{service}/revisions/{revision}` for Revision `projects/{project_id_or_number}/locations/{location}/jobs/{job}/executions/{execution}` for Execution
operationId <string> Required. The operation id returned from ExportImage."
  [name operationId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://run.googleapis.com/v2/{+name}/{+operationId}:exportStatus",
     :uri-template-args {:name name, :operationId operationId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-executions-get
  "Gets information about an Execution.
https://cloud.google.com/run

name <string> Required. The full name of the Execution. Format: `projects/{project}/locations/{location}/jobs/{job}/executions/{execution}`, where `{project}` can be project id or number."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://run.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-executions-list
  "Lists Executions from a Job. Results are sorted by creation time, descending.
https://cloud.google.com/run

parent <string> Required. The Execution from which the Executions should be listed. To list all Executions across Jobs, use \"-\" instead of Job name. Format: `projects/{project}/locations/{location}/jobs/{job}`, where `{project}` can be project id or number.

optional:
pageSize <integer> Maximum number of Executions to return in this call.
showDeleted <boolean> If true, returns deleted (but unexpired) resources along with active ones."
  ([parent] (projects-locations-jobs-executions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://run.googleapis.com/v2/{+parent}/executions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-executions-delete
  "Deletes an Execution.
https://cloud.google.com/run

name <string> Required. The name of the Execution to delete. Format: `projects/{project}/locations/{location}/jobs/{job}/executions/{execution}`, where `{project}` can be project id or number.

optional:
validateOnly <boolean> Indicates that the request should be validated without actually deleting any resources.
etag <string> A system-generated fingerprint for this version of the resource. This may be used to detect modification conflict during updates."
  ([name] (projects-locations-jobs-executions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://run.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobs-executions-cancel
  "Cancels an Execution.
https://cloud.google.com/run

name <string> Required. The name of the Execution to cancel. Format: `projects/{project}/locations/{location}/jobs/{job}/executions/{execution}`, where `{project}` can be project id or number.
GoogleCloudRunV2CancelExecutionRequest:
{:validateOnly boolean, :etag string}"
  [name GoogleCloudRunV2CancelExecutionRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://run.googleapis.com/v2/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudRunV2CancelExecutionRequest}))

(defn projects-locations-jobs-executions-tasks-get
  "Gets information about a Task.
https://cloud.google.com/run

name <string> Required. The full name of the Task. Format: projects/{project}/locations/{location}/jobs/{job}/executions/{execution}/tasks/{task}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://run.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobs-executions-tasks-list
  "Lists Tasks from an Execution of a Job.
https://cloud.google.com/run

parent <string> Required. The Execution from which the Tasks should be listed. To list all Tasks across Executions of a Job, use \"-\" instead of Execution name. To list all Tasks across Jobs, use \"-\" instead of Job name. Format: projects/{project}/locations/{location}/jobs/{job}/executions/{execution}

optional:
pageSize <integer> Maximum number of Tasks to return in this call.
showDeleted <boolean> If true, returns deleted (but unexpired) resources along with active ones."
  ([parent] (projects-locations-jobs-executions-tasks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://run.googleapis.com/v2/{+parent}/tasks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-create
  "Creates a new Service in a given project and location.
https://cloud.google.com/run

parent <string> Required. The location and project in which this service should be created. Format: projects/{project}/locations/{location}, where {project} can be project id or number. Only lowercase characters, digits, and hyphens.
GoogleCloudRunV2Service:
{:description string,
 :labels object,
 :deleteTime string,
 :terminalCondition
 {:type string,
  :state
  [STATE_UNSPECIFIED
   CONDITION_PENDING
   CONDITION_RECONCILING
   CONDITION_FAILED
   CONDITION_SUCCEEDED],
  :message string,
  :lastTransitionTime string,
  :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
  :reason
  [COMMON_REASON_UNDEFINED
   UNKNOWN
   REVISION_FAILED
   PROGRESS_DEADLINE_EXCEEDED
   CONTAINER_MISSING
   CONTAINER_PERMISSION_DENIED
   CONTAINER_IMAGE_UNAUTHORIZED
   CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
   ENCRYPTION_KEY_PERMISSION_DENIED
   ENCRYPTION_KEY_CHECK_FAILED
   SECRETS_ACCESS_CHECK_FAILED
   WAITING_FOR_OPERATION
   IMMEDIATE_RETRY
   POSTPONED_RETRY
   INTERNAL],
  :revisionReason
  [REVISION_REASON_UNDEFINED
   PENDING
   RESERVE
   RETIRED
   RETIRING
   RECREATING
   HEALTH_CHECK_CONTAINER_ERROR
   CUSTOMIZED_PATH_RESPONSE_PENDING
   MIN_INSTANCES_NOT_PROVISIONED
   ACTIVE_REVISION_LIMIT_REACHED
   NO_DEPLOYMENT
   HEALTH_CHECK_SKIPPED
   MIN_INSTANCES_WARMING],
  :executionReason
  [EXECUTION_REASON_UNDEFINED
   JOB_STATUS_SERVICE_POLLING_ERROR
   NON_ZERO_EXIT_CODE
   CANCELLED
   CANCELLING
   DELETED]},
 :generation string,
 :ingress
 [INGRESS_TRAFFIC_UNSPECIFIED
  INGRESS_TRAFFIC_ALL
  INGRESS_TRAFFIC_INTERNAL_ONLY
  INGRESS_TRAFFIC_INTERNAL_LOAD_BALANCER
  INGRESS_TRAFFIC_NONE],
 :creator string,
 :traffic
 [{:type
   [TRAFFIC_TARGET_ALLOCATION_TYPE_UNSPECIFIED
    TRAFFIC_TARGET_ALLOCATION_TYPE_LATEST
    TRAFFIC_TARGET_ALLOCATION_TYPE_REVISION],
   :revision string,
   :percent integer,
   :tag string}],
 :uid string,
 :name string,
 :binaryAuthorization
 {:useDefault boolean,
  :policy string,
  :breakglassJustification string},
 :latestCreatedRevision string,
 :client string,
 :createTime string,
 :trafficStatuses
 [{:type
   [TRAFFIC_TARGET_ALLOCATION_TYPE_UNSPECIFIED
    TRAFFIC_TARGET_ALLOCATION_TYPE_LATEST
    TRAFFIC_TARGET_ALLOCATION_TYPE_REVISION],
   :revision string,
   :percent integer,
   :tag string,
   :uri string}],
 :etag string,
 :template
 {:serviceAccount string,
  :labels object,
  :maxInstanceRequestConcurrency integer,
  :revision string,
  :nodeSelector {:accelerator string},
  :healthCheckDisabled boolean,
  :encryptionKey string,
  :vpcAccess
  {:connector string,
   :egress [VPC_EGRESS_UNSPECIFIED ALL_TRAFFIC PRIVATE_RANGES_ONLY],
   :networkInterfaces
   [{:network string, :subnetwork string, :tags [string]}]},
  :containers
  [{:args [string],
    :volumeMounts [{:name string, :mountPath string}],
    :dependsOn [string],
    :name string,
    :command [string],
    :env
    [{:name string,
      :value string,
      :valueSource {:secretKeyRef GoogleCloudRunV2SecretKeySelector}}],
    :ports [{:name string, :containerPort integer}],
    :startupProbe
    {:initialDelaySeconds integer,
     :timeoutSeconds integer,
     :periodSeconds integer,
     :failureThreshold integer,
     :httpGet
     {:path string,
      :httpHeaders [GoogleCloudRunV2HTTPHeader],
      :port integer},
     :tcpSocket {:port integer},
     :grpc {:port integer, :service string}},
    :livenessProbe
    {:initialDelaySeconds integer,
     :timeoutSeconds integer,
     :periodSeconds integer,
     :failureThreshold integer,
     :httpGet
     {:path string,
      :httpHeaders [GoogleCloudRunV2HTTPHeader],
      :port integer},
     :tcpSocket {:port integer},
     :grpc {:port integer, :service string}},
    :workingDir string,
    :image string,
    :resources
    {:limits object, :cpuIdle boolean, :startupCpuBoost boolean}}],
  :executionEnvironment
  [EXECUTION_ENVIRONMENT_UNSPECIFIED
   EXECUTION_ENVIRONMENT_GEN1
   EXECUTION_ENVIRONMENT_GEN2],
  :volumes
  [{:name string,
    :secret
    {:secret string,
     :items [{:path string, :version string, :mode integer}],
     :defaultMode integer},
    :cloudSqlInstance {:instances [string]},
    :emptyDir {:medium [MEDIUM_UNSPECIFIED MEMORY], :sizeLimit string},
    :nfs {:server string, :path string, :readOnly boolean},
    :gcs {:bucket string, :readOnly boolean}}],
  :scaling {:minInstanceCount integer, :maxInstanceCount integer},
  :sessionAffinity boolean,
  :annotations object,
  :timeout string},
 :latestReadyRevision string,
 :lastModifier string,
 :observedGeneration string,
 :updateTime string,
 :reconciling boolean,
 :conditions
 [{:type string,
   :state
   [STATE_UNSPECIFIED
    CONDITION_PENDING
    CONDITION_RECONCILING
    CONDITION_FAILED
    CONDITION_SUCCEEDED],
   :message string,
   :lastTransitionTime string,
   :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
   :reason
   [COMMON_REASON_UNDEFINED
    UNKNOWN
    REVISION_FAILED
    PROGRESS_DEADLINE_EXCEEDED
    CONTAINER_MISSING
    CONTAINER_PERMISSION_DENIED
    CONTAINER_IMAGE_UNAUTHORIZED
    CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
    ENCRYPTION_KEY_PERMISSION_DENIED
    ENCRYPTION_KEY_CHECK_FAILED
    SECRETS_ACCESS_CHECK_FAILED
    WAITING_FOR_OPERATION
    IMMEDIATE_RETRY
    POSTPONED_RETRY
    INTERNAL],
   :revisionReason
   [REVISION_REASON_UNDEFINED
    PENDING
    RESERVE
    RETIRED
    RETIRING
    RECREATING
    HEALTH_CHECK_CONTAINER_ERROR
    CUSTOMIZED_PATH_RESPONSE_PENDING
    MIN_INSTANCES_NOT_PROVISIONED
    ACTIVE_REVISION_LIMIT_REACHED
    NO_DEPLOYMENT
    HEALTH_CHECK_SKIPPED
    MIN_INSTANCES_WARMING],
   :executionReason
   [EXECUTION_REASON_UNDEFINED
    JOB_STATUS_SERVICE_POLLING_ERROR
    NON_ZERO_EXIT_CODE
    CANCELLED
    CANCELLING
    DELETED]}],
 :clientVersion string,
 :satisfiesPzs boolean,
 :scaling {:minInstanceCount integer},
 :annotations object,
 :expireTime string,
 :uri string,
 :launchStage
 [LAUNCH_STAGE_UNSPECIFIED
  UNIMPLEMENTED
  PRELAUNCH
  EARLY_ACCESS
  ALPHA
  BETA
  GA
  DEPRECATED],
 :customAudiences [string],
 :defaultUriDisabled boolean}

optional:
serviceId <string> Required. The unique identifier for the Service. It must begin with letter, and cannot end with hyphen; must contain fewer than 50 characters. The name of the service becomes {parent}/services/{service_id}.
validateOnly <boolean> Indicates that the request should be validated and default values populated, without persisting the request or creating any resources."
  ([parent GoogleCloudRunV2Service]
    (projects-locations-services-create
      parent
      GoogleCloudRunV2Service
      nil))
  ([parent GoogleCloudRunV2Service optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://run.googleapis.com/v2/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudRunV2Service})))

(defn projects-locations-services-get
  "Gets information about a Service.
https://cloud.google.com/run

name <string> Required. The full name of the Service. Format: projects/{project}/locations/{location}/services/{service}, where {project} can be project id or number."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://run.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-services-list
  "Lists Services. Results are sorted by creation time, descending.
https://cloud.google.com/run

parent <string> Required. The location and project to list resources on. Location must be a valid Google Cloud region, and cannot be the \"-\" wildcard. Format: projects/{project}/locations/{location}, where {project} can be project id or number.

optional:
pageSize <integer> Maximum number of Services to return in this call.
showDeleted <boolean> If true, returns deleted (but unexpired) resources along with active ones."
  ([parent] (projects-locations-services-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://run.googleapis.com/v2/{+parent}/services",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-patch
  "Updates a Service.
https://cloud.google.com/run

name <string> The fully qualified name of this Service. In CreateServiceRequest, this field is ignored, and instead composed from CreateServiceRequest.parent and CreateServiceRequest.service_id. Format: projects/{project}/locations/{location}/services/{service_id}
GoogleCloudRunV2Service:
{:description string,
 :labels object,
 :deleteTime string,
 :terminalCondition
 {:type string,
  :state
  [STATE_UNSPECIFIED
   CONDITION_PENDING
   CONDITION_RECONCILING
   CONDITION_FAILED
   CONDITION_SUCCEEDED],
  :message string,
  :lastTransitionTime string,
  :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
  :reason
  [COMMON_REASON_UNDEFINED
   UNKNOWN
   REVISION_FAILED
   PROGRESS_DEADLINE_EXCEEDED
   CONTAINER_MISSING
   CONTAINER_PERMISSION_DENIED
   CONTAINER_IMAGE_UNAUTHORIZED
   CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
   ENCRYPTION_KEY_PERMISSION_DENIED
   ENCRYPTION_KEY_CHECK_FAILED
   SECRETS_ACCESS_CHECK_FAILED
   WAITING_FOR_OPERATION
   IMMEDIATE_RETRY
   POSTPONED_RETRY
   INTERNAL],
  :revisionReason
  [REVISION_REASON_UNDEFINED
   PENDING
   RESERVE
   RETIRED
   RETIRING
   RECREATING
   HEALTH_CHECK_CONTAINER_ERROR
   CUSTOMIZED_PATH_RESPONSE_PENDING
   MIN_INSTANCES_NOT_PROVISIONED
   ACTIVE_REVISION_LIMIT_REACHED
   NO_DEPLOYMENT
   HEALTH_CHECK_SKIPPED
   MIN_INSTANCES_WARMING],
  :executionReason
  [EXECUTION_REASON_UNDEFINED
   JOB_STATUS_SERVICE_POLLING_ERROR
   NON_ZERO_EXIT_CODE
   CANCELLED
   CANCELLING
   DELETED]},
 :generation string,
 :ingress
 [INGRESS_TRAFFIC_UNSPECIFIED
  INGRESS_TRAFFIC_ALL
  INGRESS_TRAFFIC_INTERNAL_ONLY
  INGRESS_TRAFFIC_INTERNAL_LOAD_BALANCER
  INGRESS_TRAFFIC_NONE],
 :creator string,
 :traffic
 [{:type
   [TRAFFIC_TARGET_ALLOCATION_TYPE_UNSPECIFIED
    TRAFFIC_TARGET_ALLOCATION_TYPE_LATEST
    TRAFFIC_TARGET_ALLOCATION_TYPE_REVISION],
   :revision string,
   :percent integer,
   :tag string}],
 :uid string,
 :name string,
 :binaryAuthorization
 {:useDefault boolean,
  :policy string,
  :breakglassJustification string},
 :latestCreatedRevision string,
 :client string,
 :createTime string,
 :trafficStatuses
 [{:type
   [TRAFFIC_TARGET_ALLOCATION_TYPE_UNSPECIFIED
    TRAFFIC_TARGET_ALLOCATION_TYPE_LATEST
    TRAFFIC_TARGET_ALLOCATION_TYPE_REVISION],
   :revision string,
   :percent integer,
   :tag string,
   :uri string}],
 :etag string,
 :template
 {:serviceAccount string,
  :labels object,
  :maxInstanceRequestConcurrency integer,
  :revision string,
  :nodeSelector {:accelerator string},
  :healthCheckDisabled boolean,
  :encryptionKey string,
  :vpcAccess
  {:connector string,
   :egress [VPC_EGRESS_UNSPECIFIED ALL_TRAFFIC PRIVATE_RANGES_ONLY],
   :networkInterfaces
   [{:network string, :subnetwork string, :tags [string]}]},
  :containers
  [{:args [string],
    :volumeMounts [{:name string, :mountPath string}],
    :dependsOn [string],
    :name string,
    :command [string],
    :env
    [{:name string,
      :value string,
      :valueSource {:secretKeyRef GoogleCloudRunV2SecretKeySelector}}],
    :ports [{:name string, :containerPort integer}],
    :startupProbe
    {:initialDelaySeconds integer,
     :timeoutSeconds integer,
     :periodSeconds integer,
     :failureThreshold integer,
     :httpGet
     {:path string,
      :httpHeaders [GoogleCloudRunV2HTTPHeader],
      :port integer},
     :tcpSocket {:port integer},
     :grpc {:port integer, :service string}},
    :livenessProbe
    {:initialDelaySeconds integer,
     :timeoutSeconds integer,
     :periodSeconds integer,
     :failureThreshold integer,
     :httpGet
     {:path string,
      :httpHeaders [GoogleCloudRunV2HTTPHeader],
      :port integer},
     :tcpSocket {:port integer},
     :grpc {:port integer, :service string}},
    :workingDir string,
    :image string,
    :resources
    {:limits object, :cpuIdle boolean, :startupCpuBoost boolean}}],
  :executionEnvironment
  [EXECUTION_ENVIRONMENT_UNSPECIFIED
   EXECUTION_ENVIRONMENT_GEN1
   EXECUTION_ENVIRONMENT_GEN2],
  :volumes
  [{:name string,
    :secret
    {:secret string,
     :items [{:path string, :version string, :mode integer}],
     :defaultMode integer},
    :cloudSqlInstance {:instances [string]},
    :emptyDir {:medium [MEDIUM_UNSPECIFIED MEMORY], :sizeLimit string},
    :nfs {:server string, :path string, :readOnly boolean},
    :gcs {:bucket string, :readOnly boolean}}],
  :scaling {:minInstanceCount integer, :maxInstanceCount integer},
  :sessionAffinity boolean,
  :annotations object,
  :timeout string},
 :latestReadyRevision string,
 :lastModifier string,
 :observedGeneration string,
 :updateTime string,
 :reconciling boolean,
 :conditions
 [{:type string,
   :state
   [STATE_UNSPECIFIED
    CONDITION_PENDING
    CONDITION_RECONCILING
    CONDITION_FAILED
    CONDITION_SUCCEEDED],
   :message string,
   :lastTransitionTime string,
   :severity [SEVERITY_UNSPECIFIED ERROR WARNING INFO],
   :reason
   [COMMON_REASON_UNDEFINED
    UNKNOWN
    REVISION_FAILED
    PROGRESS_DEADLINE_EXCEEDED
    CONTAINER_MISSING
    CONTAINER_PERMISSION_DENIED
    CONTAINER_IMAGE_UNAUTHORIZED
    CONTAINER_IMAGE_AUTHORIZATION_CHECK_FAILED
    ENCRYPTION_KEY_PERMISSION_DENIED
    ENCRYPTION_KEY_CHECK_FAILED
    SECRETS_ACCESS_CHECK_FAILED
    WAITING_FOR_OPERATION
    IMMEDIATE_RETRY
    POSTPONED_RETRY
    INTERNAL],
   :revisionReason
   [REVISION_REASON_UNDEFINED
    PENDING
    RESERVE
    RETIRED
    RETIRING
    RECREATING
    HEALTH_CHECK_CONTAINER_ERROR
    CUSTOMIZED_PATH_RESPONSE_PENDING
    MIN_INSTANCES_NOT_PROVISIONED
    ACTIVE_REVISION_LIMIT_REACHED
    NO_DEPLOYMENT
    HEALTH_CHECK_SKIPPED
    MIN_INSTANCES_WARMING],
   :executionReason
   [EXECUTION_REASON_UNDEFINED
    JOB_STATUS_SERVICE_POLLING_ERROR
    NON_ZERO_EXIT_CODE
    CANCELLED
    CANCELLING
    DELETED]}],
 :clientVersion string,
 :satisfiesPzs boolean,
 :scaling {:minInstanceCount integer},
 :annotations object,
 :expireTime string,
 :uri string,
 :launchStage
 [LAUNCH_STAGE_UNSPECIFIED
  UNIMPLEMENTED
  PRELAUNCH
  EARLY_ACCESS
  ALPHA
  BETA
  GA
  DEPRECATED],
 :customAudiences [string],
 :defaultUriDisabled boolean}

optional:
updateMask <string> Optional. The list of fields to be updated.
validateOnly <boolean> Indicates that the request should be validated and default values populated, without persisting the request or updating any resources.
allowMissing <boolean> Optional. If set to true, and if the Service does not exist, it will create a new one. The caller must have 'run.services.create' permissions if this is set to true and the Service does not exist."
  ([name GoogleCloudRunV2Service]
    (projects-locations-services-patch
      name
      GoogleCloudRunV2Service
      nil))
  ([name GoogleCloudRunV2Service optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://run.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudRunV2Service})))

(defn projects-locations-services-delete
  "Deletes a Service. This will cause the Service to stop serving traffic and will delete all revisions.
https://cloud.google.com/run

name <string> Required. The full name of the Service. Format: projects/{project}/locations/{location}/services/{service}, where {project} can be project id or number.

optional:
validateOnly <boolean> Indicates that the request should be validated without actually deleting any resources.
etag <string> A system-generated fingerprint for this version of the resource. May be used to detect modification conflict during updates."
  ([name] (projects-locations-services-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://run.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-getIamPolicy
  "Gets the IAM Access Control policy currently in effect for the given Cloud Run Service. This result does not include any inherited policies.
https://cloud.google.com/run

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-services-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://run.googleapis.com/v2/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-setIamPolicy
  "Sets the IAM Access control policy for the specified Service. Overwrites any existing policy.
https://cloud.google.com/run

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://run.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-services-testIamPermissions
  "Returns permissions that a caller has on the specified Project. There are no permissions required for making this API call.
https://cloud.google.com/run

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://run.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-services-revisions-exportStatus
  "Read the status of an image export operation.
https://cloud.google.com/run

name <string> Required. The name of the resource of which image export operation status has to be fetched. Format: `projects/{project_id_or_number}/locations/{location}/services/{service}/revisions/{revision}` for Revision `projects/{project_id_or_number}/locations/{location}/jobs/{job}/executions/{execution}` for Execution
operationId <string> Required. The operation id returned from ExportImage."
  [name operationId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://run.googleapis.com/v2/{+name}/{+operationId}:exportStatus",
     :uri-template-args {:name name, :operationId operationId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-services-revisions-get
  "Gets information about a Revision.
https://cloud.google.com/run

name <string> Required. The full name of the Revision. Format: projects/{project}/locations/{location}/services/{service}/revisions/{revision}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://run.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-services-revisions-list
  "Lists Revisions from a given Service, or from a given location. Results are sorted by creation time, descending.
https://cloud.google.com/run

parent <string> Required. The Service from which the Revisions should be listed. To list all Revisions across Services, use \"-\" instead of Service name. Format: projects/{project}/locations/{location}/services/{service}

optional:
pageSize <integer> Maximum number of revisions to return in this call.
showDeleted <boolean> If true, returns deleted (but unexpired) resources along with active ones."
  ([parent] (projects-locations-services-revisions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://run.googleapis.com/v2/{+parent}/revisions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-services-revisions-delete
  "Deletes a Revision.
https://cloud.google.com/run

name <string> Required. The name of the Revision to delete. Format: projects/{project}/locations/{location}/services/{service}/revisions/{revision}

optional:
validateOnly <boolean> Indicates that the request should be validated without actually deleting any resources.
etag <string> A system-generated fingerprint for this version of the resource. This may be used to detect modification conflict during updates."
  ([name] (projects-locations-services-revisions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://run.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

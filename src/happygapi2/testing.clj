(ns happygapi2.testing
  "Cloud Testing API
Allows developers to run automated tests for their mobile applications on Google infrastructure.
See: https://firebase.google.com/docs/test-lab/"
  (:require [happy.oauth2.client :as client]))

(defn projects-testMatrices-create
  "Creates and runs a matrix of tests according to the given specifications. Unsupported environments will be returned in the state UNSUPPORTED. A test matrix is limited to use at most 2000 devices in parallel. The returned matrix will not yet contain the executions that will be created for this matrix. Execution creation happens later on and will require a call to GetTestMatrix. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed or if the matrix tries to use too many simultaneous devices.
https://firebase.google.com/docs/test-lab

projectId <string> The GCE project under which this job will run.
TestMatrix:
{:extendedInvalidMatrixDetails [{:reason string, :message string}],
 :invalidMatrixDetails
 [INVALID_MATRIX_DETAILS_UNSPECIFIED
  DETAILS_UNAVAILABLE
  MALFORMED_APK
  MALFORMED_TEST_APK
  NO_MANIFEST
  NO_PACKAGE_NAME
  INVALID_PACKAGE_NAME
  TEST_SAME_AS_APP
  NO_INSTRUMENTATION
  NO_SIGNATURE
  INSTRUMENTATION_ORCHESTRATOR_INCOMPATIBLE
  NO_TEST_RUNNER_CLASS
  NO_LAUNCHER_ACTIVITY
  FORBIDDEN_PERMISSIONS
  INVALID_ROBO_DIRECTIVES
  INVALID_RESOURCE_NAME
  INVALID_DIRECTIVE_ACTION
  TEST_LOOP_INTENT_FILTER_NOT_FOUND
  SCENARIO_LABEL_NOT_DECLARED
  SCENARIO_LABEL_MALFORMED
  SCENARIO_NOT_DECLARED
  DEVICE_ADMIN_RECEIVER
  MALFORMED_XC_TEST_ZIP
  BUILT_FOR_IOS_SIMULATOR
  NO_TESTS_IN_XC_TEST_ZIP
  USE_DESTINATION_ARTIFACTS
  TEST_NOT_APP_HOSTED
  PLIST_CANNOT_BE_PARSED
  TEST_ONLY_APK
  MALFORMED_IPA
  MISSING_URL_SCHEME
  MALFORMED_APP_BUNDLE
  NO_CODE_APK
  INVALID_INPUT_APK
  INVALID_APK_PREVIEW_SDK
  MATRIX_TOO_LARGE
  TEST_QUOTA_EXCEEDED
  SERVICE_NOT_ACTIVATED
  UNKNOWN_PERMISSION_ERROR],
 :clientInfo
 {:name string, :clientInfoDetails [{:key string, :value string}]},
 :resultStorage
 {:googleCloudStorage {:gcsPath string},
  :toolResultsHistory {:projectId string, :historyId string},
  :toolResultsExecution
  {:projectId string, :historyId string, :executionId string},
  :resultsUrl string},
 :failFast boolean,
 :flakyTestAttempts integer,
 :state
 [TEST_STATE_UNSPECIFIED
  VALIDATING
  PENDING
  RUNNING
  FINISHED
  ERROR
  UNSUPPORTED_ENVIRONMENT
  INCOMPATIBLE_ENVIRONMENT
  INCOMPATIBLE_ARCHITECTURE
  CANCELLED
  INVALID],
 :outcomeSummary
 [OUTCOME_SUMMARY_UNSPECIFIED SUCCESS FAILURE INCONCLUSIVE SKIPPED],
 :testMatrixId string,
 :testExecutions
 [{:testDetails {:progressMessages [string], :errorMessage string},
   :matrixId string,
   :shard
   {:shardIndex integer,
    :numShards integer,
    :testTargetsForShard {:testTargets [string]},
    :estimatedShardDuration string},
   :state
   [TEST_STATE_UNSPECIFIED
    VALIDATING
    PENDING
    RUNNING
    FINISHED
    ERROR
    UNSUPPORTED_ENVIRONMENT
    INCOMPATIBLE_ENVIRONMENT
    INCOMPATIBLE_ARCHITECTURE
    CANCELLED
    INVALID],
   :id string,
   :environment
   {:androidDevice
    {:androidModelId string,
     :androidVersionId string,
     :locale string,
     :orientation string},
    :iosDevice
    {:iosModelId string,
     :iosVersionId string,
     :locale string,
     :orientation string}},
   :projectId string,
   :timestamp string,
   :testSpecification
   {:testTimeout string,
    :testSetup
    {:additionalApks [{:location FileReference, :packageName string}],
     :networkProfile string,
     :environmentVariables [{:key string, :value string}],
     :dontAutograntPermissions boolean,
     :directoriesToPull [string],
     :account {:googleAuto GoogleAuto},
     :systrace {:durationSeconds integer},
     :filesToPush [{:obbFile ObbFile, :regularFile RegularFile}],
     :initialSetupApks
     [{:location FileReference, :packageName string}]},
    :iosTestSetup
    {:networkProfile string,
     :additionalIpas [{:gcsPath string}],
     :pushFiles
     [{:content FileReference, :bundleId string, :devicePath string}],
     :pullDirectories
     [{:content FileReference, :bundleId string, :devicePath string}]},
    :androidRoboTest
    {:appInitialActivity string,
     :appBundle {:bundleLocation FileReference},
     :roboMode [ROBO_MODE_UNSPECIFIED ROBO_VERSION_1 ROBO_VERSION_2],
     :roboScript {:gcsPath string},
     :appApk {:gcsPath string},
     :maxSteps integer,
     :roboDirectives
     [{:resourceName string,
       :inputText string,
       :actionType
       [ACTION_TYPE_UNSPECIFIED SINGLE_CLICK ENTER_TEXT IGNORE]}],
     :startingIntents
     [{:launcherActivity LauncherActivityIntent,
       :startActivity StartActivityIntent,
       :noActivity NoActivityIntent,
       :timeout string}],
     :maxDepth integer,
     :appPackageId string},
    :iosTestLoop
    {:appIpa {:gcsPath string},
     :scenarios [integer],
     :appBundleId string},
    :androidInstrumentationTest
    {:orchestratorOption
     [ORCHESTRATOR_OPTION_UNSPECIFIED
      USE_ORCHESTRATOR
      DO_NOT_USE_ORCHESTRATOR],
     :appBundle {:bundleLocation FileReference},
     :testTargets [string],
     :shardingOption
     {:uniformSharding UniformSharding,
      :manualSharding ManualSharding,
      :smartSharding SmartSharding},
     :testRunnerClass string,
     :testApk {:gcsPath string},
     :testPackageId string,
     :appApk {:gcsPath string},
     :appPackageId string},
    :disableVideoRecording boolean,
    :iosRoboTest
    {:appIpa {:gcsPath string},
     :appBundleId string,
     :roboScript {:gcsPath string}},
    :iosXcTest
    {:testsZip {:gcsPath string},
     :xctestrun {:gcsPath string},
     :xcodeVersion string,
     :appBundleId string,
     :testSpecialEntitlements boolean},
    :androidTestLoop
    {:appApk {:gcsPath string},
     :appBundle {:bundleLocation FileReference},
     :appPackageId string,
     :scenarios [integer],
     :scenarioLabels [string]},
    :disablePerformanceMetrics boolean},
   :toolResultsStep
   {:projectId string,
    :historyId string,
    :executionId string,
    :stepId string}}],
 :environmentMatrix
 {:androidMatrix
  {:androidModelIds [string],
   :androidVersionIds [string],
   :locales [string],
   :orientations [string]},
  :androidDeviceList
  {:androidDevices
   [{:androidModelId string,
     :androidVersionId string,
     :locale string,
     :orientation string}]},
  :iosDeviceList
  {:iosDevices
   [{:iosModelId string,
     :iosVersionId string,
     :locale string,
     :orientation string}]}},
 :projectId string,
 :timestamp string,
 :testSpecification
 {:testTimeout string,
  :testSetup
  {:additionalApks
   [{:location {:gcsPath string}, :packageName string}],
   :networkProfile string,
   :environmentVariables [{:key string, :value string}],
   :dontAutograntPermissions boolean,
   :directoriesToPull [string],
   :account {:googleAuto object},
   :systrace {:durationSeconds integer},
   :filesToPush
   [{:obbFile {:obbFileName string, :obb FileReference},
     :regularFile {:content FileReference, :devicePath string}}],
   :initialSetupApks
   [{:location {:gcsPath string}, :packageName string}]},
  :iosTestSetup
  {:networkProfile string,
   :additionalIpas [{:gcsPath string}],
   :pushFiles
   [{:content {:gcsPath string},
     :bundleId string,
     :devicePath string}],
   :pullDirectories
   [{:content {:gcsPath string},
     :bundleId string,
     :devicePath string}]},
  :androidRoboTest
  {:appInitialActivity string,
   :appBundle {:bundleLocation {:gcsPath string}},
   :roboMode [ROBO_MODE_UNSPECIFIED ROBO_VERSION_1 ROBO_VERSION_2],
   :roboScript {:gcsPath string},
   :appApk {:gcsPath string},
   :maxSteps integer,
   :roboDirectives
   [{:resourceName string,
     :inputText string,
     :actionType
     [ACTION_TYPE_UNSPECIFIED SINGLE_CLICK ENTER_TEXT IGNORE]}],
   :startingIntents
   [{:launcherActivity object,
     :startActivity
     {:action string, :uri string, :categories [string]},
     :noActivity object,
     :timeout string}],
   :maxDepth integer,
   :appPackageId string},
  :iosTestLoop
  {:appIpa {:gcsPath string},
   :scenarios [integer],
   :appBundleId string},
  :androidInstrumentationTest
  {:orchestratorOption
   [ORCHESTRATOR_OPTION_UNSPECIFIED
    USE_ORCHESTRATOR
    DO_NOT_USE_ORCHESTRATOR],
   :appBundle {:bundleLocation {:gcsPath string}},
   :testTargets [string],
   :shardingOption
   {:uniformSharding {:numShards integer},
    :manualSharding {:testTargetsForShard [TestTargetsForShard]},
    :smartSharding {:targetedShardDuration string}},
   :testRunnerClass string,
   :testApk {:gcsPath string},
   :testPackageId string,
   :appApk {:gcsPath string},
   :appPackageId string},
  :disableVideoRecording boolean,
  :iosRoboTest
  {:appIpa {:gcsPath string},
   :appBundleId string,
   :roboScript {:gcsPath string}},
  :iosXcTest
  {:testsZip {:gcsPath string},
   :xctestrun {:gcsPath string},
   :xcodeVersion string,
   :appBundleId string,
   :testSpecialEntitlements boolean},
  :androidTestLoop
  {:appApk {:gcsPath string},
   :appBundle {:bundleLocation {:gcsPath string}},
   :appPackageId string,
   :scenarios [integer],
   :scenarioLabels [string]},
  :disablePerformanceMetrics boolean}}

optional:
requestId <string> A string id used to detect duplicated requests. Ids are automatically scoped to a project, so users should ensure the ID is unique per-project. A UUID is recommended. Optional, but strongly recommended."
  ([projectId TestMatrix]
    (projects-testMatrices-create projectId TestMatrix nil))
  ([projectId TestMatrix optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://testing.googleapis.com/v1/projects/{projectId}/testMatrices",
       :uri-template-args {:projectId projectId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TestMatrix})))

(defn projects-testMatrices-get
  "Checks the status of a test matrix and the executions once they are created. The test matrix will contain the list of test executions to run if and only if the resultStorage.toolResultsExecution fields have been populated. Note: Flaky test executions may be added to the matrix at a later stage. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Test Matrix does not exist
https://firebase.google.com/docs/test-lab

projectId <string> Cloud project that owns the test matrix.
testMatrixId <string> Unique test matrix id which was assigned by the service."
  [projectId testMatrixId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://testing.googleapis.com/v1/projects/{projectId}/testMatrices/{testMatrixId}",
     :uri-template-args
     {:projectId projectId, :testMatrixId testMatrixId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-testMatrices-cancel
  "Cancels unfinished test executions in a test matrix. This call returns immediately and cancellation proceeds asynchronously. If the matrix is already final, this operation will have no effect. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Test Matrix does not exist
https://firebase.google.com/docs/test-lab

projectId <string> Cloud project that owns the test.
testMatrixId <string> Test matrix that will be canceled."
  [projectId testMatrixId]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://testing.googleapis.com/v1/projects/{projectId}/testMatrices/{testMatrixId}:cancel",
     :uri-template-args
     {:projectId projectId, :testMatrixId testMatrixId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-deviceSessions-create
  "POST /v1/projects/{project_id}/deviceSessions
https://firebase.google.com/docs/test-lab

parent <string> Required. The Compute Engine project under which this device will be allocated. \"projects/{project_id}\"
DeviceSession:
{:displayName string,
 :inactivityTimeout string,
 :name string,
 :createTime string,
 :androidDevice
 {:androidModelId string,
  :androidVersionId string,
  :locale string,
  :orientation string},
 :state
 [SESSION_STATE_UNSPECIFIED
  REQUESTED
  PENDING
  ACTIVE
  EXPIRED
  FINISHED
  UNAVAILABLE
  ERROR],
 :ttl string,
 :stateHistories
 [{:sessionState
   [SESSION_STATE_UNSPECIFIED
    REQUESTED
    PENDING
    ACTIVE
    EXPIRED
    FINISHED
    UNAVAILABLE
    ERROR],
   :eventTime string,
   :stateMessage string}],
 :activeStartTime string,
 :expireTime string}"
  [parent DeviceSession]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://testing.googleapis.com/v1/{+parent}/deviceSessions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DeviceSession}))

(defn projects-deviceSessions-list
  "GET /v1/projects/{project_id}/deviceSessions Lists device Sessions owned by the project user.
https://firebase.google.com/docs/test-lab

parent <string> Required. The name of the parent to request, e.g. \"projects/{project_id}\"

optional:
pageSize <integer> Optional. The maximum number of DeviceSessions to return.
filter <string> Optional. If specified, responses will be filtered by the given filter. Allowed fields are: session_state."
  ([parent] (projects-deviceSessions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://testing.googleapis.com/v1/{+parent}/deviceSessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-deviceSessions-get
  "GET /v1/projects/{project_id}/deviceSessions/{device_session_id} Return a DeviceSession, which documents the allocation status and whether the device is allocated. Clients making requests from this API must poll GetDeviceSession.
https://firebase.google.com/docs/test-lab

name <string> Required. Name of the DeviceSession, e.g. \"projects/{project_id}/deviceSessions/{session_id}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://testing.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-deviceSessions-cancel
  "POST /v1/projects/{project_id}/deviceSessions/{device_session_id}:cancel Changes the DeviceSession to state FINISHED and terminates all connections. Canceled sessions are not deleted and can be retrieved or listed by the user until they expire based on the 28 day deletion policy.
https://firebase.google.com/docs/test-lab

name <string> Required. Name of the DeviceSession, e.g. \"projects/{project_id}/deviceSessions/{session_id}\"
CancelDeviceSessionRequest:
object"
  [name CancelDeviceSessionRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://testing.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelDeviceSessionRequest}))

(defn projects-deviceSessions-patch
  "PATCH /v1/projects/{projectId}/deviceSessions/deviceSessionId}:updateDeviceSession Updates the current device session to the fields described by the update_mask.
https://firebase.google.com/docs/test-lab

name <string> Optional. Name of the DeviceSession, e.g. \"projects/{project_id}/deviceSessions/{session_id}\"
DeviceSession:
{:displayName string,
 :inactivityTimeout string,
 :name string,
 :createTime string,
 :androidDevice
 {:androidModelId string,
  :androidVersionId string,
  :locale string,
  :orientation string},
 :state
 [SESSION_STATE_UNSPECIFIED
  REQUESTED
  PENDING
  ACTIVE
  EXPIRED
  FINISHED
  UNAVAILABLE
  ERROR],
 :ttl string,
 :stateHistories
 [{:sessionState
   [SESSION_STATE_UNSPECIFIED
    REQUESTED
    PENDING
    ACTIVE
    EXPIRED
    FINISHED
    UNAVAILABLE
    ERROR],
   :eventTime string,
   :stateMessage string}],
 :activeStartTime string,
 :expireTime string}

optional:
updateMask <string> Required. The list of fields to update."
  ([name DeviceSession]
    (projects-deviceSessions-patch name DeviceSession nil))
  ([name DeviceSession optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://testing.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DeviceSession})))

(defn applicationDetailService-getApkDetails
  "Gets the details of an Android application APK.
https://firebase.google.com/docs/test-lab

FileReference:
{:gcsPath string}

optional:
bundleLocation.gcsPath <string> A path to a file in Google Cloud Storage. Example: gs://build-app-1414623860166/app%40debug-unaligned.apk These paths are expected to be url encoded (percent encoding)"
  ([FileReference]
    (applicationDetailService-getApkDetails FileReference nil))
  ([FileReference optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://testing.googleapis.com/v1/applicationDetailService/getApkDetails",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body FileReference})))

(defn testEnvironmentCatalog-get
  "Gets the catalog of supported test environments. May return any of the following canonical error codes: - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the environment type does not exist - INTERNAL - if an internal error occurred
https://firebase.google.com/docs/test-lab

environmentType <string> Required. The type of environment that should be listed.

optional:
projectId <string> For authorization, the cloud project requesting the TestEnvironmentCatalog."
  ([environmentType] (testEnvironmentCatalog-get environmentType nil))
  ([environmentType optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://testing.googleapis.com/v1/testEnvironmentCatalog/{environmentType}",
       :uri-template-args {:environmentType environmentType},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

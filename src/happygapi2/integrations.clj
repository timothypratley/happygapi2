(ns happygapi2.integrations
  "Application Integration API

See: https://cloud.google.com/application-integration"
  (:require [happy.oauth2.client :as client]))

(defn callback-generateToken
  "Receives the auth code and auth config id to combine that with the client id and secret to retrieve access tokens from the token endpoint. Returns either a success or error message when it's done.
https://cloud.google.com/application-integration

optional:
state <string> The auth config id for the given request
code <string> The auth code for the given request
gcpProjectId <string> The gcp project id of the request
product <string> Which product sends the request
redirectUri <string> Redirect uri of the auth code request"
  ([] (callback-generateToken nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/callback:generateToken",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-getClientmetadata
  "Gets the metadata info for the requested client
https://cloud.google.com/application-integration

parent <string> Required. Required: The ID of the GCP Project to be provisioned."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/clientmetadata",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-getClients
  "Gets the client configuration for the given project and location resource name
https://cloud.google.com/application-integration

parent <string> Required. Required: The ID of the GCP Project to be provisioned."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/clients",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-integrations-test
  "Execute the integration in draft state
https://cloud.google.com/application-integration

name <string> Output only. Auto-generated primary key.
GoogleCloudIntegrationsV1alphaTestIntegrationsRequest:
{:inputParameters object,
 :parameters
 {:parameters
  [{:dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :masked boolean,
    :value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :key string}]},
 :integrationVersion
 {:triggerConfigsInternal
  [{:description string,
    :properties object,
    :cloudSchedulerConfig
    {:errorMessage string,
     :cronTab string,
     :location string,
     :serviceAccountEmail string},
    :triggerId string,
    :errorCatcherId string,
    :nextTasksExecutionPolicy
    [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
    :startTasks
    [{:taskNumber string,
      :combinedConditions
      [{:conditions [EnterpriseCrmEventbusProtoCondition]}],
      :condition string,
      :taskConfigId string,
      :label string,
      :description string}],
    :triggerCriteria
    {:condition string,
     :parameters
     {:parameters [EnterpriseCrmEventbusProtoParameterEntry]},
     :triggerCriteriaTaskImplementationClassName string},
    :alertConfig
    [{:clientId string,
      :numAggregationPeriods integer,
      :metricType
      [METRIC_TYPE_UNSPECIFIED
       EVENT_ERROR_RATE
       EVENT_WARNING_RATE
       TASK_ERROR_RATE
       TASK_WARNING_RATE
       TASK_RATE
       EVENT_RATE
       EVENT_AVERAGE_DURATION
       EVENT_PERCENTILE_DURATION
       TASK_AVERAGE_DURATION
       TASK_PERCENTILE_DURATION],
      :thresholdType
      [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
      :aggregationPeriod string,
      :alertDisabled boolean,
      :errorEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]},
      :onlyFinalAttempt boolean,
      :alertName string,
      :thresholdValue {:absolute string, :percentage integer},
      :durationThresholdMs string,
      :playbookUrl string,
      :warningEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]}}],
    :label string,
    :triggerType
    [UNKNOWN
     CLOUD_PUBSUB
     GOOPS
     SFDC_SYNC
     CRON
     API
     MANIFOLD_TRIGGER
     DATALAYER_DATA_CHANGE
     SFDC_CHANNEL
     CLOUD_PUBSUB_EXTERNAL
     SFDC_CDC_CHANNEL
     SFDC_PLATFORM_EVENTS_CHANNEL
     CLOUD_SCHEDULER
     INTEGRATION_CONNECTOR_TRIGGER
     PRIVATE_TRIGGER],
    :position {:x integer, :y integer},
    :triggerName string,
    :enabledClients [string],
    :triggerNumber string,
    :pauseWorkflowExecutions boolean}],
  :description string,
  :taskConfigsInternal
  [{:description string,
    :failurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :errorCatcherId string,
    :nextTasksExecutionPolicy
    [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
    :disableStrictTypeValidation boolean,
    :taskSpec string,
    :incomingEdgeCount integer,
    :createTime string,
    :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
    :preconditionLabel string,
    :rollbackStrategy
    {:taskNumbersToRollback [string],
     :rollbackTaskImplementationClassName string,
     :parameters
     {:parameters
      [EnterpriseCrmFrontendsEventbusProtoParameterEntry]}},
    :nextTasks
    [{:taskNumber string,
      :combinedConditions
      [{:conditions [EnterpriseCrmEventbusProtoCondition]}],
      :condition string,
      :taskConfigId string,
      :label string,
      :description string}],
    :synchronousCallFailurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :taskTemplateName string,
    :jsonValidationOption
    [UNSPECIFIED_JSON_VALIDATION_OPTION
     SKIP
     PRE_EXECUTION
     POST_EXECUTION
     PRE_POST_EXECUTION],
    :lastModifiedTime string,
    :alertConfigs
    [{:clientId string,
      :numAggregationPeriods integer,
      :metricType
      [METRIC_TYPE_UNSPECIFIED
       TASK_ERROR_RATE
       TASK_WARNING_RATE
       TASK_RATE
       TASK_AVERAGE_DURATION
       TASK_PERCENTILE_DURATION],
      :thresholdType
      [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
      :aggregationPeriod string,
      :alertDisabled boolean,
      :errorEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]},
      :onlyFinalAttempt boolean,
      :alertName string,
      :thresholdValue {:absolute string, :percentage integer},
      :durationThresholdMs string,
      :playbookUrl string,
      :warningEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]}}],
    :label string,
    :position {:x integer, :y integer},
    :taskEntity
    {:uiConfig
     {:taskUiModuleConfigs
      [EnterpriseCrmEventbusProtoTaskUiModuleConfig]},
     :metadata
     {:description string,
      :category
      [UNSPECIFIED_CATEGORY
       CUSTOM
       FLOW_CONTROL
       DATA_MANIPULATION
       SCRIPTING
       CONNECTOR
       HIDDEN
       CLOUD_SYSTEMS
       CUSTOM_TASK_TEMPLATE
       TASK_RECOMMENDATIONS],
      :defaultSpec string,
      :descriptiveName string,
      :tags [string],
      :externalCategory
      [UNSPECIFIED_EXTERNAL_CATEGORY
       CORE
       CONNECTORS
       EXTERNAL_HTTP
       EXTERNAL_INTEGRATION_SERVICES
       EXTERNAL_CUSTOMER_ACTIONS
       EXTERNAL_FLOW_CONTROL
       EXTERNAL_WORKSPACE
       EXTERNAL_SECURITY
       EXTERNAL_DATABASES
       EXTERNAL_ANALYTICS
       EXTERNAL_BYOC
       EXTERNAL_BYOT
       EXTERNAL_ARTIFICIAL_INTELIGENCE
       EXTERNAL_DATA_MANIPULATION],
      :system
      [UNSPECIFIED_SYSTEM
       GENERIC
       BUGANIZER
       SALESFORCE
       CLOUD_SQL
       PLX
       SHEETS
       GOOGLE_GROUPS
       EMAIL
       SPANNER
       DATA_BRIDGE],
      :codeSearchLink string,
      :externalCategorySequence integer,
      :admins [EnterpriseCrmEventbusProtoTaskMetadataAdmin],
      :name string,
      :g3DocLink string,
      :externalDocHtml string,
      :externalDocMarkdown string,
      :iconLink string,
      :defaultJsonValidationOption
      [UNSPECIFIED_JSON_VALIDATION_OPTION
       SKIP
       PRE_EXECUTION
       POST_EXECUTION
       PRE_POST_EXECUTION],
      :docMarkdown string,
      :standaloneExternalDocHtml string,
      :status [UNSPECIFIED_STATUS DEFAULT_INACTIVE ACTIVE],
      :externalDocLink string,
      :activeTaskName string,
      :isDeprecated boolean},
     :disabledForVpcSc boolean,
     :paramSpecs
     {:parameters [EnterpriseCrmFrontendsEventbusProtoParamSpecEntry]},
     :stats
     {:warningRate number,
      :dimensions EnterpriseCrmEventbusStatsDimensions,
      :qps number,
      :durationInSeconds number,
      :errorRate number},
     :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE]},
    :conditionalFailurePolicies
    {:defaultFailurePolicy
     {:retryCondition string,
      :intervalInSeconds string,
      :maxNumRetries integer,
      :retryStrategy
      [UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_WORKFLOW_WITH_BACKOFF]},
     :failurePolicies
     [{:retryCondition string,
       :intervalInSeconds string,
       :maxNumRetries integer,
       :retryStrategy
       [UNSPECIFIED
        IGNORE
        NONE
        FATAL
        FIXED_INTERVAL
        LINEAR_BACKOFF
        EXPONENTIAL_BACKOFF
        RESTART_WORKFLOW_WITH_BACKOFF]}]},
    :externalTaskType
    [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
    :creatorEmail string,
    :taskName string,
    :parameters object,
    :taskNumber string,
    :taskExecutionStrategy
    [WHEN_ALL_SUCCEED
     WHEN_ANY_SUCCEED
     WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
    :successPolicy {:finalState [UNSPECIFIED SUCCEEDED SUSPENDED]},
    :precondition string}],
  :name string,
  :triggerConfigs
  [{:description string,
    :properties object,
    :cloudSchedulerConfig
    {:errorMessage string,
     :serviceAccountEmail string,
     :cronTab string,
     :location string},
    :triggerId string,
    :errorCatcherId string,
    :nextTasksExecutionPolicy
    [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
     RUN_ALL_MATCH
     RUN_FIRST_MATCH],
    :startTasks
    [{:taskId string,
      :condition string,
      :description string,
      :taskConfigId string,
      :displayName string}],
    :alertConfig
    [{:metricType
      [METRIC_TYPE_UNSPECIFIED
       EVENT_ERROR_RATE
       EVENT_WARNING_RATE
       TASK_ERROR_RATE
       TASK_WARNING_RATE
       TASK_RATE
       EVENT_RATE
       EVENT_AVERAGE_DURATION
       EVENT_PERCENTILE_DURATION
       TASK_AVERAGE_DURATION
       TASK_PERCENTILE_DURATION],
      :thresholdType
      [THRESHOLD_TYPE_UNSPECIFIED EXPECTED_MIN EXPECTED_MAX],
      :displayName string,
      :aggregationPeriod string,
      :durationThreshold string,
      :onlyFinalAttempt boolean,
      :alertThreshold integer,
      :thresholdValue {:percentage integer, :absolute string},
      :disableAlert boolean}],
    :label string,
    :triggerType
    [TRIGGER_TYPE_UNSPECIFIED
     CRON
     API
     SFDC_CHANNEL
     CLOUD_PUBSUB_EXTERNAL
     SFDC_CDC_CHANNEL
     CLOUD_SCHEDULER
     INTEGRATION_CONNECTOR_TRIGGER
     PRIVATE_TRIGGER],
    :position {:x integer, :y integer},
    :trigger string,
    :triggerNumber string}],
  :integrationParameters
  [{:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean}],
  :cloudLoggingDetails
  {:enableCloudLogging boolean,
   :cloudLoggingSeverity
   [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
  :createTime string,
  :userLabel string,
  :state
  [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
  :lastModifierEmail string,
  :runAsServiceAccount string,
  :updateTime string,
  :taskConfigs
  [{:description string,
    :failurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer},
    :errorCatcherId string,
    :task string,
    :nextTasksExecutionPolicy
    [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
     RUN_ALL_MATCH
     RUN_FIRST_MATCH],
    :taskTemplate string,
    :displayName string,
    :nextTasks
    [{:taskId string,
      :condition string,
      :description string,
      :taskConfigId string,
      :displayName string}],
    :synchronousCallFailurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer},
    :jsonValidationOption
    [JSON_VALIDATION_OPTION_UNSPECIFIED
     SKIP
     PRE_EXECUTION
     POST_EXECUTION
     PRE_POST_EXECUTION],
    :position {:x integer, :y integer},
    :conditionalFailurePolicies
    {:failurePolicies
     [{:intervalTime string,
       :retryStrategy
       [RETRY_STRATEGY_UNSPECIFIED
        IGNORE
        NONE
        FATAL
        FIXED_INTERVAL
        LINEAR_BACKOFF
        EXPONENTIAL_BACKOFF
        RESTART_INTEGRATION_WITH_BACKOFF],
       :condition string,
       :maxRetries integer}],
     :defaultFailurePolicy
     {:intervalTime string,
      :retryStrategy
      [RETRY_STRATEGY_UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_INTEGRATION_WITH_BACKOFF],
      :condition string,
      :maxRetries integer}},
    :externalTaskType
    [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
    :taskId string,
    :parameters object,
    :taskExecutionStrategy
    [TASK_EXECUTION_STRATEGY_UNSPECIFIED
     WHEN_ALL_SUCCEED
     WHEN_ANY_SUCCEED
     WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
    :successPolicy
    {:finalState [FINAL_STATE_UNSPECIFIED SUCCEEDED SUSPENDED]}}],
  :errorCatcherConfigs
  [{:errorCatcherId string,
    :label string,
    :errorCatcherNumber string,
    :startErrorTasks
    [{:taskId string,
      :condition string,
      :description string,
      :taskConfigId string,
      :displayName string}],
    :description string,
    :position {:x integer, :y integer}}],
  :databasePersistencePolicy
  [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
   DATABASE_PERSISTENCE_DISABLED
   DATABASE_PERSISTENCE_ASYNC],
  :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
  :integrationConfigParameters
  [{:parameter
    {:containsLargeData boolean,
     :producer string,
     :key string,
     :displayName string,
     :isTransient boolean,
     :searchable boolean,
     :jsonSchema string,
     :dataType
     [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
      STRING_VALUE
      INT_VALUE
      DOUBLE_VALUE
      BOOLEAN_VALUE
      STRING_ARRAY
      INT_ARRAY
      DOUBLE_ARRAY
      BOOLEAN_ARRAY
      JSON_VALUE
      PROTO_VALUE
      PROTO_ARRAY],
     :defaultValue
     {:intValue string,
      :stringArray GoogleCloudIntegrationsV1alphaStringParameterArray,
      :booleanValue boolean,
      :stringValue string,
      :jsonValue string,
      :intArray GoogleCloudIntegrationsV1alphaIntParameterArray,
      :doubleArray GoogleCloudIntegrationsV1alphaDoubleParameterArray,
      :doubleValue number,
      :booleanArray
      GoogleCloudIntegrationsV1alphaBooleanParameterArray},
     :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
     :masked boolean},
    :value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}}}],
  :snapshotNumber string,
  :origin
  [UNSPECIFIED
   UI
   PIPER_V2
   PIPER_V3
   APPLICATION_IP_PROVISIONING
   TEST_CASE],
  :enableVariableMasking boolean,
  :integrationParametersInternal
  {:parameters
   [{:description string,
     :containsLargeData boolean,
     :children
     [{:description string,
       :containsLargeData boolean,
       :children
       [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry],
       :producer string,
       :key string,
       :protoDefName string,
       :name string,
       :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
       :isTransient boolean,
       :producedBy EnterpriseCrmEventbusProtoNodeIdentifier,
       :jsonSchema string,
       :protoDefPath string,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :defaultValue
       EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :attributes EnterpriseCrmEventbusProtoAttributes,
       :required boolean}],
     :producer string,
     :key string,
     :protoDefName string,
     :name string,
     :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
     :isTransient boolean,
     :producedBy
     {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
      :elementIdentifier string},
     :jsonSchema string,
     :protoDefPath string,
     :dataType
     [DATA_TYPE_UNSPECIFIED
      STRING_VALUE
      INT_VALUE
      DOUBLE_VALUE
      BOOLEAN_VALUE
      PROTO_VALUE
      SERIALIZED_OBJECT_VALUE
      STRING_ARRAY
      INT_ARRAY
      DOUBLE_ARRAY
      PROTO_ARRAY
      PROTO_ENUM
      BOOLEAN_ARRAY
      PROTO_ENUM_ARRAY
      BYTES
      BYTES_ARRAY
      NON_SERIALIZABLE_OBJECT
      JSON_VALUE],
     :defaultValue
     {:intValue string,
      :stringArray
      EnterpriseCrmFrontendsEventbusProtoStringParameterArray,
      :serializedObjectValue
      EnterpriseCrmFrontendsEventbusProtoSerializedObjectParameter,
      :booleanValue boolean,
      :stringValue string,
      :jsonValue string,
      :intArray EnterpriseCrmFrontendsEventbusProtoIntParameterArray,
      :doubleArray
      EnterpriseCrmFrontendsEventbusProtoDoubleParameterArray,
      :doubleValue number,
      :booleanArray
      EnterpriseCrmFrontendsEventbusProtoBooleanParameterArray,
      :protoArray
      EnterpriseCrmFrontendsEventbusProtoProtoParameterArray,
      :protoValue object},
     :attributes
     {:logSettings EnterpriseCrmEventbusProtoLogSettings,
      :isSearchable boolean,
      :searchable [UNSPECIFIED YES NO],
      :readOnly boolean,
      :dataType
      [DATA_TYPE_UNSPECIFIED EMAIL URL CURRENCY TIMESTAMP DOMAIN_NAME],
      :taskVisibility [string],
      :isRequired boolean,
      :defaultValue EnterpriseCrmEventbusProtoValueType,
      :masked boolean},
     :required boolean}]},
  :teardown
  {:teardownTaskConfigs
   [{:properties
     {:properties [EnterpriseCrmEventbusProtoPropertyEntry]},
     :nextTeardownTask {:name string},
     :name string,
     :parameters
     {:parameters [EnterpriseCrmEventbusProtoParameterEntry]},
     :teardownTaskImplementationClassName string,
     :creatorEmail string}]},
  :createdFromTemplate string,
  :lockHolder string,
  :parentTemplateId string},
 :testMode boolean,
 :triggerId string,
 :deadlineSecondsTime string,
 :clientId string,
 :configParameters object}"
  [name GoogleCloudIntegrationsV1alphaTestIntegrationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:test",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaTestIntegrationsRequest}))

(defn projects-locations-integrations-execute
  "Executes integrations synchronously by passing the trigger id in the request body. The request is not returned until the requested executions are either fulfilled or experienced an error. If the integration name is not specified (passing `-`), all of the associated integration under the given trigger_id will be executed. Otherwise only the specified integration for the given `trigger_id` is executed. This is helpful for execution the integration from UI.
https://cloud.google.com/application-integration

name <string> Required. The integration resource name.
GoogleCloudIntegrationsV1alphaExecuteIntegrationsRequest:
{:inputParameters object,
 :parameterEntries
 [{:dataType
   [DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    PROTO_VALUE
    SERIALIZED_OBJECT_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    PROTO_ARRAY
    PROTO_ENUM
    BOOLEAN_ARRAY
    PROTO_ENUM_ARRAY
    BYTES
    BYTES_ARRAY
    NON_SERIALIZABLE_OBJECT
    JSON_VALUE],
   :masked boolean,
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :serializedObjectValue {:objectValue string},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]},
    :protoArray {:protoValues [object]},
    :protoValue object},
   :key string}],
 :triggerId string,
 :doNotPropagateError boolean,
 :requestId string,
 :executionId string,
 :parameters
 {:parameters
  [{:dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :masked boolean,
    :value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :key string}]}}"
  [name GoogleCloudIntegrationsV1alphaExecuteIntegrationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:execute",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaExecuteIntegrationsRequest}))

(defn projects-locations-integrations-list
  "Returns the list of all integrations in the specified project.
https://cloud.google.com/application-integration

parent <string> Required. Project and location from which the integrations should be listed. Format: projects/{project}

optional:
filter <string> Filter on fields of IntegrationVersion. Fields can be compared with literal values by use of \":\" (containment), \"=\" (equality), \">\" (greater), \"<\" (less than), >=\" (greater than or equal to), \"<=\" (less than or equal to), and \"!=\" (inequality) operators. Negation, conjunction, and disjunction are written using NOT, AND, and OR keywords. For example, organization_id=\\\"1\\\" AND state=ACTIVE AND description:\"test\". Filtering cannot be performed on repeated fields like `task_config`.
orderBy <string> The results would be returned in order you specified here. Supported sort keys are: Descending sort order by \"last_modified_time\", \"created_time\", \"snapshot_number\". Ascending sort order by the integration name.
pageSize <integer> The page size for the resquest."
  ([parent] (projects-locations-integrations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/integrations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-integrations-schedule
  "Schedules an integration for execution by passing the trigger id and the scheduled time in the request body.
https://cloud.google.com/application-integration

name <string> The integration resource name.
GoogleCloudIntegrationsV1alphaScheduleIntegrationsRequest:
{:requestId string,
 :triggerId string,
 :scheduleTime string,
 :parameterEntries
 [{:dataType
   [DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    PROTO_VALUE
    SERIALIZED_OBJECT_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    PROTO_ARRAY
    PROTO_ENUM
    BOOLEAN_ARRAY
    PROTO_ENUM_ARRAY
    BYTES
    BYTES_ARRAY
    NON_SERIALIZABLE_OBJECT
    JSON_VALUE],
   :masked boolean,
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :serializedObjectValue {:objectValue string},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]},
    :protoArray {:protoValues [object]},
    :protoValue object},
   :key string}],
 :userGeneratedExecutionId string,
 :parameters
 {:parameters
  [{:value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :masked boolean,
    :key string}]},
 :inputParameters object}"
  [name GoogleCloudIntegrationsV1alphaScheduleIntegrationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:schedule",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaScheduleIntegrationsRequest}))

(defn projects-locations-integrations-delete
  "Delete the selected integration and all versions inside
https://cloud.google.com/application-integration

name <string> Required. The location resource of the request."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-integrations-executeEvent
  "Executes an integration on receiving events from Integration Connector triggers, Eventarc or CPS Trigger. Input data to integration is received in body in json format
https://cloud.google.com/application-integration

name <string> Required. The integration resource name. Format: projects/{gcp_project_id}/locations/{location}/integrations/{integration_id}
object:
object

optional:
triggerId <string> Required. Id of the integration trigger config. The trigger_id is in the format: `integration_connector_trigger/projects/{gcp_project_id}/location/{location}/connections/{connection_name}/subscriptions/{subscription_name}`."
  ([name object]
    (projects-locations-integrations-executeEvent name object nil))
  ([name object optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://integrations.googleapis.com/v1/{+name}:executeEvent",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body object})))

(defn projects-locations-integrations-versions-unpublish
  "Sets the status of the ACTIVE integration to SNAPSHOT with a new tag \"PREVIOUSLY_PUBLISHED\" after validating it. The \"HEAD\" and \"PUBLISH_REQUESTED\" tags do not change. This RPC throws an exception if the version being snapshot is not ACTIVE. Audit fields added include action, action_by, action_timestamp.
https://cloud.google.com/application-integration

name <string> Required. The version to deactivate. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}
GoogleCloudIntegrationsV1alphaUnpublishIntegrationVersionRequest:
object"
  [name
   GoogleCloudIntegrationsV1alphaUnpublishIntegrationVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:unpublish",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudIntegrationsV1alphaUnpublishIntegrationVersionRequest}))

(defn projects-locations-integrations-versions-get
  "Get a integration in the specified project.
https://cloud.google.com/application-integration

name <string> Required. The version to retrieve. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-integrations-versions-patch
  "Update a integration with a draft version in the specified project.
https://cloud.google.com/application-integration

name <string> Output only. Auto-generated primary key.
GoogleCloudIntegrationsV1alphaIntegrationVersion:
{:triggerConfigsInternal
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :cronTab string,
    :location string,
    :serviceAccountEmail string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :startTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :triggerCriteria
   {:condition string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :triggerCriteriaTaskImplementationClassName string},
   :alertConfig
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :triggerType
   [UNKNOWN
    CLOUD_PUBSUB
    GOOPS
    SFDC_SYNC
    CRON
    API
    MANIFOLD_TRIGGER
    DATALAYER_DATA_CHANGE
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    SFDC_PLATFORM_EVENTS_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :triggerName string,
   :enabledClients [string],
   :triggerNumber string,
   :pauseWorkflowExecutions boolean}],
 :description string,
 :taskConfigsInternal
 [{:description string,
   :failurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :disableStrictTypeValidation boolean,
   :taskSpec string,
   :incomingEdgeCount integer,
   :createTime string,
   :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
   :preconditionLabel string,
   :rollbackStrategy
   {:taskNumbersToRollback [string],
    :rollbackTaskImplementationClassName string,
    :parameters
    {:parameters
     [{:dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :masked boolean,
       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :key string}]}},
   :nextTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :synchronousCallFailurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :taskTemplateName string,
   :jsonValidationOption
   [UNSPECIFIED_JSON_VALIDATION_OPTION
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :lastModifiedTime string,
   :alertConfigs
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :position {:x integer, :y integer},
   :taskEntity
   {:uiConfig
    {:taskUiModuleConfigs
     [{:moduleId
       [UNSPECIFIED_TASK_MODULE
        LABEL
        ERROR_HANDLING
        TASK_PARAM_TABLE
        TASK_PARAM_FORM
        PRECONDITION
        SCRIPT_EDITOR
        RPC
        TASK_SUMMARY
        SUSPENSION
        RPC_TYPED
        SUB_WORKFLOW
        APPS_SCRIPT_NAVIGATOR
        SUB_WORKFLOW_FOR_EACH_LOOP
        FIELD_MAPPING
        README
        REST_CALLER
        SUB_WORKFLOW_SCATTER_GATHER
        CLOUD_SQL
        GENERIC_CONNECTOR_TASK]}]},
    :metadata
    {:description string,
     :category
     [UNSPECIFIED_CATEGORY
      CUSTOM
      FLOW_CONTROL
      DATA_MANIPULATION
      SCRIPTING
      CONNECTOR
      HIDDEN
      CLOUD_SYSTEMS
      CUSTOM_TASK_TEMPLATE
      TASK_RECOMMENDATIONS],
     :defaultSpec string,
     :descriptiveName string,
     :tags [string],
     :externalCategory
     [UNSPECIFIED_EXTERNAL_CATEGORY
      CORE
      CONNECTORS
      EXTERNAL_HTTP
      EXTERNAL_INTEGRATION_SERVICES
      EXTERNAL_CUSTOMER_ACTIONS
      EXTERNAL_FLOW_CONTROL
      EXTERNAL_WORKSPACE
      EXTERNAL_SECURITY
      EXTERNAL_DATABASES
      EXTERNAL_ANALYTICS
      EXTERNAL_BYOC
      EXTERNAL_BYOT
      EXTERNAL_ARTIFICIAL_INTELIGENCE
      EXTERNAL_DATA_MANIPULATION],
     :system
     [UNSPECIFIED_SYSTEM
      GENERIC
      BUGANIZER
      SALESFORCE
      CLOUD_SQL
      PLX
      SHEETS
      GOOGLE_GROUPS
      EMAIL
      SPANNER
      DATA_BRIDGE],
     :codeSearchLink string,
     :externalCategorySequence integer,
     :admins [{:googleGroupEmail string, :userEmail string}],
     :name string,
     :g3DocLink string,
     :externalDocHtml string,
     :externalDocMarkdown string,
     :iconLink string,
     :defaultJsonValidationOption
     [UNSPECIFIED_JSON_VALIDATION_OPTION
      SKIP
      PRE_EXECUTION
      POST_EXECUTION
      PRE_POST_EXECUTION],
     :docMarkdown string,
     :standaloneExternalDocHtml string,
     :status [UNSPECIFIED_STATUS DEFAULT_INACTIVE ACTIVE],
     :externalDocLink string,
     :activeTaskName string,
     :isDeprecated boolean},
    :disabledForVpcSc boolean,
    :paramSpecs
    {:parameters
     [{:validationRule
       EnterpriseCrmEventbusProtoParamSpecEntryValidationRule,
       :key string,
       :protoDef
       EnterpriseCrmEventbusProtoParamSpecEntryProtoDefinition,
       :config EnterpriseCrmEventbusProtoParamSpecEntryConfig,
       :isOutput boolean,
       :collectionElementClassName string,
       :className string,
       :jsonSchema string,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :defaultValue
       EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :isDeprecated boolean,
       :required boolean}]},
    :stats
    {:warningRate number,
     :dimensions
     {:clientId string,
      :triggerId string,
      :workflowId string,
      :retryAttempt [UNSPECIFIED FINAL RETRYABLE CANCELED],
      :warningEnumString string,
      :workflowName string,
      :enumFilterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :taskName string,
      :taskNumber string,
      :errorEnumString string},
     :qps number,
     :durationInSeconds number,
     :errorRate number},
    :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE]},
   :conditionalFailurePolicies
   {:defaultFailurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :failurePolicies
    [{:retryCondition string,
      :intervalInSeconds string,
      :maxNumRetries integer,
      :retryStrategy
      [UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_WORKFLOW_WITH_BACKOFF]}]},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :creatorEmail string,
   :taskName string,
   :parameters object,
   :taskNumber string,
   :taskExecutionStrategy
   [WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy {:finalState [UNSPECIFIED SUCCEEDED SUSPENDED]},
   :precondition string}],
 :name string,
 :triggerConfigs
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :serviceAccountEmail string,
    :cronTab string,
    :location string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :startTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :alertConfig
   [{:metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [THRESHOLD_TYPE_UNSPECIFIED EXPECTED_MIN EXPECTED_MAX],
     :displayName string,
     :aggregationPeriod string,
     :durationThreshold string,
     :onlyFinalAttempt boolean,
     :alertThreshold integer,
     :thresholdValue {:percentage integer, :absolute string},
     :disableAlert boolean}],
   :label string,
   :triggerType
   [TRIGGER_TYPE_UNSPECIFIED
    CRON
    API
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :trigger string,
   :triggerNumber string}],
 :integrationParameters
 [{:containsLargeData boolean,
   :producer string,
   :key string,
   :displayName string,
   :isTransient boolean,
   :searchable boolean,
   :jsonSchema string,
   :dataType
   [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    BOOLEAN_ARRAY
    JSON_VALUE
    PROTO_VALUE
    PROTO_ARRAY],
   :defaultValue
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}},
   :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
   :masked boolean}],
 :cloudLoggingDetails
 {:enableCloudLogging boolean,
  :cloudLoggingSeverity
  [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
 :createTime string,
 :userLabel string,
 :state [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :lastModifierEmail string,
 :runAsServiceAccount string,
 :updateTime string,
 :taskConfigs
 [{:description string,
   :failurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :errorCatcherId string,
   :task string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :taskTemplate string,
   :displayName string,
   :nextTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :synchronousCallFailurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :jsonValidationOption
   [JSON_VALIDATION_OPTION_UNSPECIFIED
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :position {:x integer, :y integer},
   :conditionalFailurePolicies
   {:failurePolicies
    [{:intervalTime string,
      :retryStrategy
      [RETRY_STRATEGY_UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_INTEGRATION_WITH_BACKOFF],
      :condition string,
      :maxRetries integer}],
    :defaultFailurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer}},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :taskId string,
   :parameters object,
   :taskExecutionStrategy
   [TASK_EXECUTION_STRATEGY_UNSPECIFIED
    WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy
   {:finalState [FINAL_STATE_UNSPECIFIED SUCCEEDED SUSPENDED]}}],
 :errorCatcherConfigs
 [{:errorCatcherId string,
   :label string,
   :errorCatcherNumber string,
   :startErrorTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :description string,
   :position {:x integer, :y integer}}],
 :databasePersistencePolicy
 [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
  DATABASE_PERSISTENCE_DISABLED
  DATABASE_PERSISTENCE_ASYNC],
 :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :integrationConfigParameters
 [{:parameter
   {:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean},
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}}}],
 :snapshotNumber string,
 :origin
 [UNSPECIFIED
  UI
  PIPER_V2
  PIPER_V3
  APPLICATION_IP_PROVISIONING
  TEST_CASE],
 :enableVariableMasking boolean,
 :integrationParametersInternal
 {:parameters
  [{:description string,
    :containsLargeData boolean,
    :children
    [{:description string,
      :containsLargeData boolean,
      :children
      [{:description string,
        :containsLargeData boolean,
        :children
        [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry],
        :producer string,
        :key string,
        :protoDefName string,
        :name string,
        :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
        :isTransient boolean,
        :producedBy EnterpriseCrmEventbusProtoNodeIdentifier,
        :jsonSchema string,
        :protoDefPath string,
        :dataType
        [DATA_TYPE_UNSPECIFIED
         STRING_VALUE
         INT_VALUE
         DOUBLE_VALUE
         BOOLEAN_VALUE
         PROTO_VALUE
         SERIALIZED_OBJECT_VALUE
         STRING_ARRAY
         INT_ARRAY
         DOUBLE_ARRAY
         PROTO_ARRAY
         PROTO_ENUM
         BOOLEAN_ARRAY
         PROTO_ENUM_ARRAY
         BYTES
         BYTES_ARRAY
         NON_SERIALIZABLE_OBJECT
         JSON_VALUE],
        :defaultValue
        EnterpriseCrmFrontendsEventbusProtoParameterValueType,
        :attributes EnterpriseCrmEventbusProtoAttributes,
        :required boolean}],
      :producer string,
      :key string,
      :protoDefName string,
      :name string,
      :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :isTransient boolean,
      :producedBy
      {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
       :elementIdentifier string},
      :jsonSchema string,
      :protoDefPath string,
      :dataType
      [DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       PROTO_VALUE
       SERIALIZED_OBJECT_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       PROTO_ARRAY
       PROTO_ENUM
       BOOLEAN_ARRAY
       PROTO_ENUM_ARRAY
       BYTES
       BYTES_ARRAY
       NON_SERIALIZABLE_OBJECT
       JSON_VALUE],
      :defaultValue
      {:intValue string,
       :stringArray
       EnterpriseCrmFrontendsEventbusProtoStringParameterArray,
       :serializedObjectValue
       EnterpriseCrmFrontendsEventbusProtoSerializedObjectParameter,
       :booleanValue boolean,
       :stringValue string,
       :jsonValue string,
       :intArray EnterpriseCrmFrontendsEventbusProtoIntParameterArray,
       :doubleArray
       EnterpriseCrmFrontendsEventbusProtoDoubleParameterArray,
       :doubleValue number,
       :booleanArray
       EnterpriseCrmFrontendsEventbusProtoBooleanParameterArray,
       :protoArray
       EnterpriseCrmFrontendsEventbusProtoProtoParameterArray,
       :protoValue object},
      :attributes
      {:logSettings EnterpriseCrmEventbusProtoLogSettings,
       :isSearchable boolean,
       :searchable [UNSPECIFIED YES NO],
       :readOnly boolean,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        EMAIL
        URL
        CURRENCY
        TIMESTAMP
        DOMAIN_NAME],
       :taskVisibility [string],
       :isRequired boolean,
       :defaultValue EnterpriseCrmEventbusProtoValueType,
       :masked boolean},
      :required boolean}],
    :producer string,
    :key string,
    :protoDefName string,
    :name string,
    :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :isTransient boolean,
    :producedBy
    {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
     :elementIdentifier string},
    :jsonSchema string,
    :protoDefPath string,
    :dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :attributes
    {:logSettings
     {:logFieldName string,
      :shorteningLimits EnterpriseCrmLoggingGwsFieldLimits,
      :seedPeriod [SEED_PERIOD_UNSPECIFIED DAY WEEK MONTH],
      :seedScope
      [SEED_SCOPE_UNSPECIFIED EVENT_NAME TIME_PERIOD PARAM_NAME],
      :sanitizeOptions EnterpriseCrmLoggingGwsSanitizeOptions},
     :isSearchable boolean,
     :searchable [UNSPECIFIED YES NO],
     :readOnly boolean,
     :dataType
     [DATA_TYPE_UNSPECIFIED EMAIL URL CURRENCY TIMESTAMP DOMAIN_NAME],
     :taskVisibility [string],
     :isRequired boolean,
     :defaultValue
     {:doubleValue number,
      :protoValue object,
      :intValue string,
      :booleanValue boolean,
      :intArray EnterpriseCrmEventbusProtoIntArray,
      :stringArray EnterpriseCrmEventbusProtoStringArray,
      :doubleArray EnterpriseCrmEventbusProtoDoubleArray,
      :stringValue string},
     :masked boolean},
    :required boolean}]},
 :teardown
 {:teardownTaskConfigs
  [{:properties
    {:properties
     [{:value EnterpriseCrmEventbusProtoValueType, :key string}]},
    :nextTeardownTask {:name string},
    :name string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :teardownTaskImplementationClassName string,
    :creatorEmail string}]},
 :createdFromTemplate string,
 :lockHolder string,
 :parentTemplateId string}

optional:
updateMask <string> Field mask specifying the fields in the above integration that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaIntegrationVersion]
    (projects-locations-integrations-versions-patch
      name
      GoogleCloudIntegrationsV1alphaIntegrationVersion
      nil))
  ([name GoogleCloudIntegrationsV1alphaIntegrationVersion optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaIntegrationVersion})))

(defn projects-locations-integrations-versions-create
  "Create a integration with a draft version in the specified project.
https://cloud.google.com/application-integration

parent <string> Required. The parent resource where this version will be created. Format: projects/{project}/locations/{location}/integrations/{integration}
GoogleCloudIntegrationsV1alphaIntegrationVersion:
{:triggerConfigsInternal
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :cronTab string,
    :location string,
    :serviceAccountEmail string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :startTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :triggerCriteria
   {:condition string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :triggerCriteriaTaskImplementationClassName string},
   :alertConfig
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :triggerType
   [UNKNOWN
    CLOUD_PUBSUB
    GOOPS
    SFDC_SYNC
    CRON
    API
    MANIFOLD_TRIGGER
    DATALAYER_DATA_CHANGE
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    SFDC_PLATFORM_EVENTS_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :triggerName string,
   :enabledClients [string],
   :triggerNumber string,
   :pauseWorkflowExecutions boolean}],
 :description string,
 :taskConfigsInternal
 [{:description string,
   :failurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :disableStrictTypeValidation boolean,
   :taskSpec string,
   :incomingEdgeCount integer,
   :createTime string,
   :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
   :preconditionLabel string,
   :rollbackStrategy
   {:taskNumbersToRollback [string],
    :rollbackTaskImplementationClassName string,
    :parameters
    {:parameters
     [{:dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :masked boolean,
       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :key string}]}},
   :nextTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :synchronousCallFailurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :taskTemplateName string,
   :jsonValidationOption
   [UNSPECIFIED_JSON_VALIDATION_OPTION
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :lastModifiedTime string,
   :alertConfigs
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :position {:x integer, :y integer},
   :taskEntity
   {:uiConfig
    {:taskUiModuleConfigs
     [{:moduleId
       [UNSPECIFIED_TASK_MODULE
        LABEL
        ERROR_HANDLING
        TASK_PARAM_TABLE
        TASK_PARAM_FORM
        PRECONDITION
        SCRIPT_EDITOR
        RPC
        TASK_SUMMARY
        SUSPENSION
        RPC_TYPED
        SUB_WORKFLOW
        APPS_SCRIPT_NAVIGATOR
        SUB_WORKFLOW_FOR_EACH_LOOP
        FIELD_MAPPING
        README
        REST_CALLER
        SUB_WORKFLOW_SCATTER_GATHER
        CLOUD_SQL
        GENERIC_CONNECTOR_TASK]}]},
    :metadata
    {:description string,
     :category
     [UNSPECIFIED_CATEGORY
      CUSTOM
      FLOW_CONTROL
      DATA_MANIPULATION
      SCRIPTING
      CONNECTOR
      HIDDEN
      CLOUD_SYSTEMS
      CUSTOM_TASK_TEMPLATE
      TASK_RECOMMENDATIONS],
     :defaultSpec string,
     :descriptiveName string,
     :tags [string],
     :externalCategory
     [UNSPECIFIED_EXTERNAL_CATEGORY
      CORE
      CONNECTORS
      EXTERNAL_HTTP
      EXTERNAL_INTEGRATION_SERVICES
      EXTERNAL_CUSTOMER_ACTIONS
      EXTERNAL_FLOW_CONTROL
      EXTERNAL_WORKSPACE
      EXTERNAL_SECURITY
      EXTERNAL_DATABASES
      EXTERNAL_ANALYTICS
      EXTERNAL_BYOC
      EXTERNAL_BYOT
      EXTERNAL_ARTIFICIAL_INTELIGENCE
      EXTERNAL_DATA_MANIPULATION],
     :system
     [UNSPECIFIED_SYSTEM
      GENERIC
      BUGANIZER
      SALESFORCE
      CLOUD_SQL
      PLX
      SHEETS
      GOOGLE_GROUPS
      EMAIL
      SPANNER
      DATA_BRIDGE],
     :codeSearchLink string,
     :externalCategorySequence integer,
     :admins [{:googleGroupEmail string, :userEmail string}],
     :name string,
     :g3DocLink string,
     :externalDocHtml string,
     :externalDocMarkdown string,
     :iconLink string,
     :defaultJsonValidationOption
     [UNSPECIFIED_JSON_VALIDATION_OPTION
      SKIP
      PRE_EXECUTION
      POST_EXECUTION
      PRE_POST_EXECUTION],
     :docMarkdown string,
     :standaloneExternalDocHtml string,
     :status [UNSPECIFIED_STATUS DEFAULT_INACTIVE ACTIVE],
     :externalDocLink string,
     :activeTaskName string,
     :isDeprecated boolean},
    :disabledForVpcSc boolean,
    :paramSpecs
    {:parameters
     [{:validationRule
       EnterpriseCrmEventbusProtoParamSpecEntryValidationRule,
       :key string,
       :protoDef
       EnterpriseCrmEventbusProtoParamSpecEntryProtoDefinition,
       :config EnterpriseCrmEventbusProtoParamSpecEntryConfig,
       :isOutput boolean,
       :collectionElementClassName string,
       :className string,
       :jsonSchema string,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :defaultValue
       EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :isDeprecated boolean,
       :required boolean}]},
    :stats
    {:warningRate number,
     :dimensions
     {:clientId string,
      :triggerId string,
      :workflowId string,
      :retryAttempt [UNSPECIFIED FINAL RETRYABLE CANCELED],
      :warningEnumString string,
      :workflowName string,
      :enumFilterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :taskName string,
      :taskNumber string,
      :errorEnumString string},
     :qps number,
     :durationInSeconds number,
     :errorRate number},
    :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE]},
   :conditionalFailurePolicies
   {:defaultFailurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :failurePolicies
    [{:retryCondition string,
      :intervalInSeconds string,
      :maxNumRetries integer,
      :retryStrategy
      [UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_WORKFLOW_WITH_BACKOFF]}]},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :creatorEmail string,
   :taskName string,
   :parameters object,
   :taskNumber string,
   :taskExecutionStrategy
   [WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy {:finalState [UNSPECIFIED SUCCEEDED SUSPENDED]},
   :precondition string}],
 :name string,
 :triggerConfigs
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :serviceAccountEmail string,
    :cronTab string,
    :location string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :startTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :alertConfig
   [{:metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [THRESHOLD_TYPE_UNSPECIFIED EXPECTED_MIN EXPECTED_MAX],
     :displayName string,
     :aggregationPeriod string,
     :durationThreshold string,
     :onlyFinalAttempt boolean,
     :alertThreshold integer,
     :thresholdValue {:percentage integer, :absolute string},
     :disableAlert boolean}],
   :label string,
   :triggerType
   [TRIGGER_TYPE_UNSPECIFIED
    CRON
    API
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :trigger string,
   :triggerNumber string}],
 :integrationParameters
 [{:containsLargeData boolean,
   :producer string,
   :key string,
   :displayName string,
   :isTransient boolean,
   :searchable boolean,
   :jsonSchema string,
   :dataType
   [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    BOOLEAN_ARRAY
    JSON_VALUE
    PROTO_VALUE
    PROTO_ARRAY],
   :defaultValue
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}},
   :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
   :masked boolean}],
 :cloudLoggingDetails
 {:enableCloudLogging boolean,
  :cloudLoggingSeverity
  [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
 :createTime string,
 :userLabel string,
 :state [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :lastModifierEmail string,
 :runAsServiceAccount string,
 :updateTime string,
 :taskConfigs
 [{:description string,
   :failurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :errorCatcherId string,
   :task string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :taskTemplate string,
   :displayName string,
   :nextTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :synchronousCallFailurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :jsonValidationOption
   [JSON_VALIDATION_OPTION_UNSPECIFIED
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :position {:x integer, :y integer},
   :conditionalFailurePolicies
   {:failurePolicies
    [{:intervalTime string,
      :retryStrategy
      [RETRY_STRATEGY_UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_INTEGRATION_WITH_BACKOFF],
      :condition string,
      :maxRetries integer}],
    :defaultFailurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer}},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :taskId string,
   :parameters object,
   :taskExecutionStrategy
   [TASK_EXECUTION_STRATEGY_UNSPECIFIED
    WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy
   {:finalState [FINAL_STATE_UNSPECIFIED SUCCEEDED SUSPENDED]}}],
 :errorCatcherConfigs
 [{:errorCatcherId string,
   :label string,
   :errorCatcherNumber string,
   :startErrorTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :description string,
   :position {:x integer, :y integer}}],
 :databasePersistencePolicy
 [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
  DATABASE_PERSISTENCE_DISABLED
  DATABASE_PERSISTENCE_ASYNC],
 :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :integrationConfigParameters
 [{:parameter
   {:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean},
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}}}],
 :snapshotNumber string,
 :origin
 [UNSPECIFIED
  UI
  PIPER_V2
  PIPER_V3
  APPLICATION_IP_PROVISIONING
  TEST_CASE],
 :enableVariableMasking boolean,
 :integrationParametersInternal
 {:parameters
  [{:description string,
    :containsLargeData boolean,
    :children
    [{:description string,
      :containsLargeData boolean,
      :children
      [{:description string,
        :containsLargeData boolean,
        :children
        [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry],
        :producer string,
        :key string,
        :protoDefName string,
        :name string,
        :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
        :isTransient boolean,
        :producedBy EnterpriseCrmEventbusProtoNodeIdentifier,
        :jsonSchema string,
        :protoDefPath string,
        :dataType
        [DATA_TYPE_UNSPECIFIED
         STRING_VALUE
         INT_VALUE
         DOUBLE_VALUE
         BOOLEAN_VALUE
         PROTO_VALUE
         SERIALIZED_OBJECT_VALUE
         STRING_ARRAY
         INT_ARRAY
         DOUBLE_ARRAY
         PROTO_ARRAY
         PROTO_ENUM
         BOOLEAN_ARRAY
         PROTO_ENUM_ARRAY
         BYTES
         BYTES_ARRAY
         NON_SERIALIZABLE_OBJECT
         JSON_VALUE],
        :defaultValue
        EnterpriseCrmFrontendsEventbusProtoParameterValueType,
        :attributes EnterpriseCrmEventbusProtoAttributes,
        :required boolean}],
      :producer string,
      :key string,
      :protoDefName string,
      :name string,
      :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :isTransient boolean,
      :producedBy
      {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
       :elementIdentifier string},
      :jsonSchema string,
      :protoDefPath string,
      :dataType
      [DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       PROTO_VALUE
       SERIALIZED_OBJECT_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       PROTO_ARRAY
       PROTO_ENUM
       BOOLEAN_ARRAY
       PROTO_ENUM_ARRAY
       BYTES
       BYTES_ARRAY
       NON_SERIALIZABLE_OBJECT
       JSON_VALUE],
      :defaultValue
      {:intValue string,
       :stringArray
       EnterpriseCrmFrontendsEventbusProtoStringParameterArray,
       :serializedObjectValue
       EnterpriseCrmFrontendsEventbusProtoSerializedObjectParameter,
       :booleanValue boolean,
       :stringValue string,
       :jsonValue string,
       :intArray EnterpriseCrmFrontendsEventbusProtoIntParameterArray,
       :doubleArray
       EnterpriseCrmFrontendsEventbusProtoDoubleParameterArray,
       :doubleValue number,
       :booleanArray
       EnterpriseCrmFrontendsEventbusProtoBooleanParameterArray,
       :protoArray
       EnterpriseCrmFrontendsEventbusProtoProtoParameterArray,
       :protoValue object},
      :attributes
      {:logSettings EnterpriseCrmEventbusProtoLogSettings,
       :isSearchable boolean,
       :searchable [UNSPECIFIED YES NO],
       :readOnly boolean,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        EMAIL
        URL
        CURRENCY
        TIMESTAMP
        DOMAIN_NAME],
       :taskVisibility [string],
       :isRequired boolean,
       :defaultValue EnterpriseCrmEventbusProtoValueType,
       :masked boolean},
      :required boolean}],
    :producer string,
    :key string,
    :protoDefName string,
    :name string,
    :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :isTransient boolean,
    :producedBy
    {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
     :elementIdentifier string},
    :jsonSchema string,
    :protoDefPath string,
    :dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :attributes
    {:logSettings
     {:logFieldName string,
      :shorteningLimits EnterpriseCrmLoggingGwsFieldLimits,
      :seedPeriod [SEED_PERIOD_UNSPECIFIED DAY WEEK MONTH],
      :seedScope
      [SEED_SCOPE_UNSPECIFIED EVENT_NAME TIME_PERIOD PARAM_NAME],
      :sanitizeOptions EnterpriseCrmLoggingGwsSanitizeOptions},
     :isSearchable boolean,
     :searchable [UNSPECIFIED YES NO],
     :readOnly boolean,
     :dataType
     [DATA_TYPE_UNSPECIFIED EMAIL URL CURRENCY TIMESTAMP DOMAIN_NAME],
     :taskVisibility [string],
     :isRequired boolean,
     :defaultValue
     {:doubleValue number,
      :protoValue object,
      :intValue string,
      :booleanValue boolean,
      :intArray EnterpriseCrmEventbusProtoIntArray,
      :stringArray EnterpriseCrmEventbusProtoStringArray,
      :doubleArray EnterpriseCrmEventbusProtoDoubleArray,
      :stringValue string},
     :masked boolean},
    :required boolean}]},
 :teardown
 {:teardownTaskConfigs
  [{:properties
    {:properties
     [{:value EnterpriseCrmEventbusProtoValueType, :key string}]},
    :nextTeardownTask {:name string},
    :name string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :teardownTaskImplementationClassName string,
    :creatorEmail string}]},
 :createdFromTemplate string,
 :lockHolder string,
 :parentTemplateId string}

optional:
createSampleIntegrations <boolean> Optional. Optional. Indicates if sample workflow should be created.
newIntegration <boolean> Set this flag to true, if draft version is to be created for a brand new integration. False, if the request is for an existing integration. For backward compatibility reasons, even if this flag is set to `false` and no existing integration is found, a new draft integration will still be created."
  ([parent GoogleCloudIntegrationsV1alphaIntegrationVersion]
    (projects-locations-integrations-versions-create
      parent
      GoogleCloudIntegrationsV1alphaIntegrationVersion
      nil))
  ([parent GoogleCloudIntegrationsV1alphaIntegrationVersion optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaIntegrationVersion})))

(defn projects-locations-integrations-versions-delete
  "Soft-deletes the integration. Changes the status of the integration to ARCHIVED. If the integration being ARCHIVED is tagged as \"HEAD\", the tag is removed from this snapshot and set to the previous non-ARCHIVED snapshot. The PUBLISH_REQUESTED, DUE_FOR_DELETION tags are removed too. This RPC throws an exception if the version being deleted is DRAFT, and if the `locked_by` user is not the same as the user performing the Delete. Audit fields updated include last_modified_timestamp, last_modified_by. Any existing lock is released when Deleting a integration. Currently, there is no undelete mechanism.
https://cloud.google.com/application-integration

name <string> Required. The version to delete. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-integrations-versions-downloadJsonPackage
  "Downloads an Integration version package like IntegrationVersion,Integration Config etc. Retrieves the IntegrationVersion package for a given `integration_id` and returns the response as a JSON.
https://cloud.google.com/application-integration

name <string> Required. Integration version name Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}

optional:
files <string> Optional. Integration related file to download like Integration Version, Config variable, testcase etc."
  ([name]
    (projects-locations-integrations-versions-downloadJsonPackage
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+name}:downloadJsonPackage",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-integrations-versions-list
  "Returns the list of all integration versions in the specified project.
https://cloud.google.com/application-integration

parent <string> Required. The parent resource where this version will be created. Format: projects/{project}/locations/{location}/integrations/{integration} Specifically, when parent equals: 1. projects//locations//integrations/, Meaning: \"List versions (with filter) for a particular integration\". 2. projects//locations//integrations/- Meaning: \"List versions (with filter) for a client within a particular region\". 3. projects//locations/-/integrations/- Meaning: \"List versions (with filter) for a client\".

optional:
fieldMask <string> The field mask which specifies the particular data to be returned.
filter <string> Filter on fields of IntegrationVersion. Fields can be compared with literal values by use of \":\" (containment), \"=\" (equality), \">\" (greater), \"<\" (less than), >=\" (greater than or equal to), \"<=\" (less than or equal to), and \"!=\" (inequality) operators. Negation, conjunction, and disjunction are written using NOT, AND, and OR keywords. For example, organization_id=\\\"1\\\" AND state=ACTIVE AND description:\"test\". Filtering cannot be performed on repeated fields like `task_config`.
orderBy <string> The results would be returned in order you specified here. Currently supported sort keys are: Descending sort order for \"last_modified_time\", \"created_time\", \"snapshot_number\" Ascending sort order for \"name\".
pageSize <integer> The maximum number of versions to return. The service may return fewer than this value. If unspecified, at most 50 versions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-integrations-versions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-integrations-versions-download
  "Downloads an integration. Retrieves the `IntegrationVersion` for a given `integration_id` and returns the response as a string.
https://cloud.google.com/application-integration

name <string> Required. The version to download. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}

optional:
files <string> Optional. Integration related file to download like Integration Json, Config variable, testcase etc.
fileFormat <string> File format for download request."
  ([name] (projects-locations-integrations-versions-download name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+name}:download",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-integrations-versions-publish
  "This RPC throws an exception if the integration is in ARCHIVED or ACTIVE state. This RPC throws an exception if the version being published is DRAFT, and if the `locked_by` user is not the same as the user performing the Publish. Audit fields updated include last_published_timestamp, last_published_by, last_modified_timestamp, last_modified_by. Any existing lock is on this integration is released.
https://cloud.google.com/application-integration

name <string> Required. The version to publish. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}
GoogleCloudIntegrationsV1alphaPublishIntegrationVersionRequest:
{:configParameters object}"
  [name GoogleCloudIntegrationsV1alphaPublishIntegrationVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:publish",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudIntegrationsV1alphaPublishIntegrationVersionRequest}))

(defn projects-locations-integrations-versions-upload
  "Uploads an integration. The content can be a previously downloaded integration. Performs the same function as CreateDraftIntegrationVersion, but accepts input in a string format, which holds the complete representation of the IntegrationVersion content.
https://cloud.google.com/application-integration

parent <string> Required. The version to upload. Format: projects/{project}/locations/{location}/integrations/{integration}
GoogleCloudIntegrationsV1alphaUploadIntegrationVersionRequest:
{:fileFormat [FILE_FORMAT_UNSPECIFIED JSON YAML], :content string}"
  [parent
   GoogleCloudIntegrationsV1alphaUploadIntegrationVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/versions:upload",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudIntegrationsV1alphaUploadIntegrationVersionRequest}))

(defn projects-locations-integrations-executions-get
  "Get an execution in the specified project.
https://cloud.google.com/application-integration

name <string> Required. The execution resource name. Format: projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_id}/executions/{execution_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-integrations-executions-download
  "Download the execution.
https://cloud.google.com/application-integration

name <string> Required. The execution resource name. Format: projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_id}/executions/{execution_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:download",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-integrations-executions-replay
  "Re-execute an existing execution, with same request parameters and execution strategy
https://cloud.google.com/application-integration

name <string> Required. The execution resource name. Format: projects/{gcp_project_id}/locations/{location}/integrations/{integration}/executions/{execution_id}
GoogleCloudIntegrationsV1alphaReplayExecutionRequest:
{:replayReason string}"
  [name GoogleCloudIntegrationsV1alphaReplayExecutionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:replay",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaReplayExecutionRequest}))

(defn projects-locations-integrations-executions-list
  "Lists the results of all the integration executions. The response includes the same information as the [execution log](https://cloud.google.com/application-integration/docs/viewing-logs) in the Integration UI.
https://cloud.google.com/application-integration

parent <string> Required. The parent resource name of the integration execution.

optional:
filterParams.workflowName <string> Workflow name.
filterParams.startTime <string> Start timestamp.
filterParams.parameterKey <string> Param key. DEPRECATED. User parameter_pair_key instead.
filterParams.parameterValue <string> Param value. DEPRECATED. User parameter_pair_value instead.
truncateParams <boolean> Optional. If true, the service will truncate the params to only keep the first 1000 characters of string params and empty the executions in order to make response smaller. Only works for UI and when the params fields are not filtered out.
filterParams.taskStatuses <string> List of possible task statuses.
snapshotMetadataWithoutParams <boolean> Optional. If true, the service will provide execution info with snapshot metadata only i.e. without event parameters.
filterParams.parameterPairValue <string> Param value in the key value pair filter.
filterParams.eventStatuses <string> List of possible event statuses.
filterParams.customFilter <string> Optional user-provided custom filter.
filterParams.parameterType <string> Param type.
filter <string> Optional. Standard filter field, we support filtering on following fields: workflow_name: the name of the integration. CreateTimestamp: the execution created time. event_execution_state: the state of the executions. execution_id: the id of the execution. trigger_id: the id of the trigger. parameter_type: the type of the parameters involved in the execution. All fields support for EQUALS, in additional: CreateTimestamp support for LESS_THAN, GREATER_THAN ParameterType support for HAS For example: \"parameter_type\" HAS \\\"string\\\" Also supports operators like AND, OR, NOT For example, trigger_id=\\\"id1\\\" AND workflow_name=\\\"testWorkflow\\\"
pageSize <integer> Optional. The size of entries in the response.
filterParams.executionId <string> Execution id.
filterParams.endTime <string> End timestamp.
readMask <string> Optional. View mask for the response data. If set, only the field specified will be returned as part of the result. If not set, all fields in event execution info will be filled and returned.
filterParams.parameterPairKey <string> Param key in the key value pair filter.
refreshAcl <boolean> Optional. If true, the service will use the most recent acl information to list event execution infos and renew the acl cache. Note that fetching the most recent acl is synchronous, so it will increase RPC call latency.
orderBy <string> Optional. The results would be returned in order you specified here. Currently supporting \"create_time\"."
  ([parent]
    (projects-locations-integrations-executions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/executions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-integrations-executions-suspensions-resolve
  "* Resolves (lifts/rejects) any number of suspensions. If the integration is already running, only the status of the suspension is updated. Otherwise, the suspended integration will begin execution again.
https://cloud.google.com/application-integration

name <string> Required. projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_name}/executions/{execution_name}/suspensions/{suspension_id}
GoogleCloudIntegrationsV1alphaResolveSuspensionRequest:
{:suspension
 {:lastModifyTime string,
  :name string,
  :createTime string,
  :integration string,
  :state [RESOLUTION_STATE_UNSPECIFIED PENDING REJECTED LIFTED],
  :suspensionConfig
  {:suspensionExpiration
   {:remindAfterMs integer,
    :expireAfterMs integer,
    :liftWhenExpired boolean},
   :customMessage string,
   :whoMayResolve
   [{:loasRole string,
     :googleGroup {:gaiaId string, :emailAddress string},
     :gaiaIdentity {:gaiaId string, :emailAddress string},
     :mdbGroup string}],
   :notifications
   [{:pubsubTopic string,
     :request
     {:postToQueueWithTriggerIdRequest
      GoogleInternalCloudCrmEventbusV3PostToQueueWithTriggerIdRequest,
      :suspensionInfoEventParameterKey string},
     :escalatorQueue string,
     :emailAddress
     {:email string,
      :name string,
      :tokens [EnterpriseCrmEventbusProtoToken]},
     :buganizerNotification
     {:templateId string,
      :componentId string,
      :assigneeEmailAddress string,
      :title string}}]},
  :audit {:resolveTime string, :resolver string},
  :approvalConfig
  {:expiration
   {:remindTime string, :liftWhenExpired boolean, :expireTime string},
   :customMessage string,
   :emailAddresses [string]},
  :eventExecutionInfoId string,
  :taskId string}}"
  [name GoogleCloudIntegrationsV1alphaResolveSuspensionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:resolve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaResolveSuspensionRequest}))

(defn projects-locations-integrations-executions-suspensions-lift
  "* Lifts suspension for the Suspension task. Fetch corresponding suspension with provided suspension Id, resolve suspension, and set up suspension result for the Suspension Task.
https://cloud.google.com/application-integration

name <string> Required. The resource that the suspension belongs to. \"projects/{project}/locations/{location}/products/{product}/integrations/{integration}/executions/{execution}/suspensions/{suspenion}\" format.
GoogleCloudIntegrationsV1alphaLiftSuspensionRequest:
{:suspensionResult string}"
  [name GoogleCloudIntegrationsV1alphaLiftSuspensionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:lift",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaLiftSuspensionRequest}))

(defn projects-locations-integrations-executions-suspensions-list
  "* Lists suspensions associated with a specific execution. Only those with permissions to resolve the relevant suspensions will be able to view them.
https://cloud.google.com/application-integration

parent <string> Required. projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_name}/executions/{execution_name}

optional:
pageSize <integer> Maximum number of entries in the response.
filter <string> Standard filter field.
orderBy <string> Field name to order by."
  ([parent]
    (projects-locations-integrations-executions-suspensions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/suspensions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-cloudFunctions-create
  "Creates a cloud function project.
https://cloud.google.com/application-integration

parent <string> Required. The project that the executed integration belongs to.
GoogleCloudIntegrationsV1alphaCreateCloudFunctionRequest:
{:functionRegion string, :projectId string, :functionName string}"
  [parent GoogleCloudIntegrationsV1alphaCreateCloudFunctionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/cloudFunctions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaCreateCloudFunctionRequest}))

(defn projects-locations-products-sfdcInstances-patch
  "Updates an sfdc instance. Updates the sfdc instance in spanner. Returns the sfdc instance.
https://cloud.google.com/application-integration

name <string> Resource name of the SFDC instance projects/{project}/locations/{location}/sfdcInstances/{sfdcInstance}.
GoogleCloudIntegrationsV1alphaSfdcInstance:
{:description string,
 :deleteTime string,
 :displayName string,
 :name string,
 :authConfigId [string],
 :createTime string,
 :serviceAuthority string,
 :updateTime string,
 :sfdcOrgId string}

optional:
updateMask <string> Field mask specifying the fields in the above SfdcInstance that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaSfdcInstance]
    (projects-locations-products-sfdcInstances-patch
      name
      GoogleCloudIntegrationsV1alphaSfdcInstance
      nil))
  ([name GoogleCloudIntegrationsV1alphaSfdcInstance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaSfdcInstance})))

(defn projects-locations-products-sfdcInstances-create
  "Creates an sfdc instance record. Store the sfdc instance in Spanner. Returns the sfdc instance.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaSfdcInstance:
{:description string,
 :deleteTime string,
 :displayName string,
 :name string,
 :authConfigId [string],
 :createTime string,
 :serviceAuthority string,
 :updateTime string,
 :sfdcOrgId string}"
  [parent GoogleCloudIntegrationsV1alphaSfdcInstance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/sfdcInstances",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaSfdcInstance}))

(defn projects-locations-products-sfdcInstances-get
  "Gets an sfdc instance. If the instance doesn't exist, Code.NOT_FOUND exception will be thrown.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcInstance."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-sfdcInstances-list
  "Lists all sfdc instances that match the filter. Restrict to sfdc instances belonging to the current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of SfdcInstances.

optional:
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100.
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters.
readMask <string> The mask which specifies fields that need to be returned in the SfdcInstance's response."
  ([parent]
    (projects-locations-products-sfdcInstances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/sfdcInstances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-sfdcInstances-delete
  "Deletes an sfdc instance.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcInstance."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-sfdcInstances-sfdcChannels-create
  "Creates an sfdc channel record. Store the sfdc channel in Spanner. Returns the sfdc channel.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaSfdcChannel:
{:description string,
 :lastReplayId string,
 :deleteTime string,
 :displayName string,
 :name string,
 :channelTopic string,
 :createTime string,
 :updateTime string,
 :isActive boolean}"
  [parent GoogleCloudIntegrationsV1alphaSfdcChannel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/sfdcChannels",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaSfdcChannel}))

(defn projects-locations-products-sfdcInstances-sfdcChannels-patch
  "Updates an sfdc channel. Updates the sfdc channel in spanner. Returns the sfdc channel.
https://cloud.google.com/application-integration

name <string> Resource name of the SFDC channel projects/{project}/locations/{location}/sfdcInstances/{sfdc_instance}/sfdcChannels/{sfdc_channel}.
GoogleCloudIntegrationsV1alphaSfdcChannel:
{:description string,
 :lastReplayId string,
 :deleteTime string,
 :displayName string,
 :name string,
 :channelTopic string,
 :createTime string,
 :updateTime string,
 :isActive boolean}

optional:
updateMask <string> Field mask specifying the fields in the above SfdcChannel that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaSfdcChannel]
    (projects-locations-products-sfdcInstances-sfdcChannels-patch
      name
      GoogleCloudIntegrationsV1alphaSfdcChannel
      nil))
  ([name GoogleCloudIntegrationsV1alphaSfdcChannel optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaSfdcChannel})))

(defn projects-locations-products-sfdcInstances-sfdcChannels-delete
  "Deletes an sfdc channel.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcChannel."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-sfdcInstances-sfdcChannels-list
  "Lists all sfdc channels that match the filter. Restrict to sfdc channels belonging to the current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of SfdcChannels.

optional:
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters.
readMask <string> The mask which specifies fields that need to be returned in the SfdcChannel's response.
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100."
  ([parent]
    (projects-locations-products-sfdcInstances-sfdcChannels-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/sfdcChannels",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-sfdcInstances-sfdcChannels-get
  "Gets an sfdc channel. If the channel doesn't exist, Code.NOT_FOUND exception will be thrown.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcChannel."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-authConfigs-delete
  "Deletes an auth config.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the AuthConfig."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-authConfigs-get
  "Gets a complete auth config. If the auth config doesn't exist, Code.NOT_FOUND exception will be thrown. Returns the decrypted auth config.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the AuthConfig."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-authConfigs-patch
  "Updates an auth config. If credential is updated, fetch the encrypted auth config from Spanner, decrypt with Cloud KMS key, update the credential fields, re-encrypt with Cloud KMS key and update the Spanner record. For other fields, directly update the Spanner record. Returns the encrypted auth config.
https://cloud.google.com/application-integration

name <string> Resource name of the auth config. For more information, see Manage authentication profiles. projects/{project}/locations/{location}/authConfigs/{authConfig}.
GoogleCloudIntegrationsV1alphaAuthConfig:
{:decryptedCredential
 {:oauth2ClientCredentials
  {:requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :clientId string,
   :clientSecret string,
   :tokenEndpoint string,
   :scope string},
  :authToken {:type string, :token string},
  :credentialType
  [CREDENTIAL_TYPE_UNSPECIFIED
   USERNAME_AND_PASSWORD
   API_KEY
   OAUTH2_AUTHORIZATION_CODE
   OAUTH2_IMPLICIT
   OAUTH2_CLIENT_CREDENTIALS
   OAUTH2_RESOURCE_OWNER_CREDENTIALS
   JWT
   AUTH_TOKEN
   SERVICE_ACCOUNT
   CLIENT_CERTIFICATE_ONLY
   OIDC_TOKEN],
  :usernameAndPassword {:password string, :username string},
  :jwt
  {:secret string, :jwtPayload string, :jwtHeader string, :jwt string},
  :serviceAccountCredentials {:serviceAccount string, :scope string},
  :oauth2AuthorizationCode
  {:clientId string,
   :tokenEndpoint string,
   :authEndpoint string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :applyReauthPolicy boolean,
   :authParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :authCode string,
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oauth2ResourceOwnerCredentials
  {:clientId string,
   :tokenEndpoint string,
   :password string,
   :username string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oidcToken
  {:serviceAccountEmail string,
   :audience string,
   :token string,
   :tokenExpireTime string}},
 :description string,
 :encryptedCredential string,
 :overrideValidTime string,
 :displayName string,
 :name string,
 :credentialType
 [CREDENTIAL_TYPE_UNSPECIFIED
  USERNAME_AND_PASSWORD
  API_KEY
  OAUTH2_AUTHORIZATION_CODE
  OAUTH2_IMPLICIT
  OAUTH2_CLIENT_CREDENTIALS
  OAUTH2_RESOURCE_OWNER_CREDENTIALS
  JWT
  AUTH_TOKEN
  SERVICE_ACCOUNT
  CLIENT_CERTIFICATE_ONLY
  OIDC_TOKEN],
 :expiryNotificationDuration [string],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  VALID
  INVALID
  SOFT_DELETED
  EXPIRED
  UNAUTHORIZED
  UNSUPPORTED],
 :lastModifierEmail string,
 :updateTime string,
 :reason string,
 :certificateId string,
 :creatorEmail string,
 :validTime string,
 :visibility
 [AUTH_CONFIG_VISIBILITY_UNSPECIFIED PRIVATE CLIENT_VISIBLE]}

optional:
updateMask <string> Field mask specifying the fields in the above AuthConfig that have been modified and need to be updated.
clientCertificate.passphrase <string> 'passphrase' should be left unset if private key is not encrypted. Note that 'passphrase' is not the password for web server, but an extra layer of security to protected private key.
clientCertificate.sslCertificate <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----
clientCertificate.encryptedPrivateKey <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----"
  ([name GoogleCloudIntegrationsV1alphaAuthConfig]
    (projects-locations-products-authConfigs-patch
      name
      GoogleCloudIntegrationsV1alphaAuthConfig
      nil))
  ([name GoogleCloudIntegrationsV1alphaAuthConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaAuthConfig})))

(defn projects-locations-products-authConfigs-list
  "Lists all auth configs that match the filter. Restrict to auth configs belong to the current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of AuthConfigs.

optional:
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters.
readMask <string> The mask which specifies fields that need to be returned in the AuthConfig's response.
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100."
  ([parent] (projects-locations-products-authConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/authConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-authConfigs-create
  "Creates an auth config record. Fetch corresponding credentials for specific auth types, e.g. access token for OAuth 2.0, JWT token for JWT. Encrypt the auth config with Cloud KMS and store the encrypted credentials in Spanner. Returns the encrypted auth config.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaAuthConfig:
{:decryptedCredential
 {:oauth2ClientCredentials
  {:requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :clientId string,
   :clientSecret string,
   :tokenEndpoint string,
   :scope string},
  :authToken {:type string, :token string},
  :credentialType
  [CREDENTIAL_TYPE_UNSPECIFIED
   USERNAME_AND_PASSWORD
   API_KEY
   OAUTH2_AUTHORIZATION_CODE
   OAUTH2_IMPLICIT
   OAUTH2_CLIENT_CREDENTIALS
   OAUTH2_RESOURCE_OWNER_CREDENTIALS
   JWT
   AUTH_TOKEN
   SERVICE_ACCOUNT
   CLIENT_CERTIFICATE_ONLY
   OIDC_TOKEN],
  :usernameAndPassword {:password string, :username string},
  :jwt
  {:secret string, :jwtPayload string, :jwtHeader string, :jwt string},
  :serviceAccountCredentials {:serviceAccount string, :scope string},
  :oauth2AuthorizationCode
  {:clientId string,
   :tokenEndpoint string,
   :authEndpoint string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :applyReauthPolicy boolean,
   :authParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :authCode string,
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oauth2ResourceOwnerCredentials
  {:clientId string,
   :tokenEndpoint string,
   :password string,
   :username string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oidcToken
  {:serviceAccountEmail string,
   :audience string,
   :token string,
   :tokenExpireTime string}},
 :description string,
 :encryptedCredential string,
 :overrideValidTime string,
 :displayName string,
 :name string,
 :credentialType
 [CREDENTIAL_TYPE_UNSPECIFIED
  USERNAME_AND_PASSWORD
  API_KEY
  OAUTH2_AUTHORIZATION_CODE
  OAUTH2_IMPLICIT
  OAUTH2_CLIENT_CREDENTIALS
  OAUTH2_RESOURCE_OWNER_CREDENTIALS
  JWT
  AUTH_TOKEN
  SERVICE_ACCOUNT
  CLIENT_CERTIFICATE_ONLY
  OIDC_TOKEN],
 :expiryNotificationDuration [string],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  VALID
  INVALID
  SOFT_DELETED
  EXPIRED
  UNAUTHORIZED
  UNSUPPORTED],
 :lastModifierEmail string,
 :updateTime string,
 :reason string,
 :certificateId string,
 :creatorEmail string,
 :validTime string,
 :visibility
 [AUTH_CONFIG_VISIBILITY_UNSPECIFIED PRIVATE CLIENT_VISIBLE]}

optional:
clientCertificate.sslCertificate <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----
clientCertificate.encryptedPrivateKey <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----
clientCertificate.passphrase <string> 'passphrase' should be left unset if private key is not encrypted. Note that 'passphrase' is not the password for web server, but an extra layer of security to protected private key."
  ([parent GoogleCloudIntegrationsV1alphaAuthConfig]
    (projects-locations-products-authConfigs-create
      parent
      GoogleCloudIntegrationsV1alphaAuthConfig
      nil))
  ([parent GoogleCloudIntegrationsV1alphaAuthConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/authConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaAuthConfig})))

(defn projects-locations-products-integrations-schedule
  "Schedules an integration for execution by passing the trigger id and the scheduled time in the request body.
https://cloud.google.com/application-integration

name <string> The integration resource name.
GoogleCloudIntegrationsV1alphaScheduleIntegrationsRequest:
{:requestId string,
 :triggerId string,
 :scheduleTime string,
 :parameterEntries
 [{:dataType
   [DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    PROTO_VALUE
    SERIALIZED_OBJECT_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    PROTO_ARRAY
    PROTO_ENUM
    BOOLEAN_ARRAY
    PROTO_ENUM_ARRAY
    BYTES
    BYTES_ARRAY
    NON_SERIALIZABLE_OBJECT
    JSON_VALUE],
   :masked boolean,
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :serializedObjectValue {:objectValue string},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]},
    :protoArray {:protoValues [object]},
    :protoValue object},
   :key string}],
 :userGeneratedExecutionId string,
 :parameters
 {:parameters
  [{:value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :masked boolean,
    :key string}]},
 :inputParameters object}"
  [name GoogleCloudIntegrationsV1alphaScheduleIntegrationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:schedule",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaScheduleIntegrationsRequest}))

(defn projects-locations-products-integrations-list
  "Returns the list of all integrations in the specified project.
https://cloud.google.com/application-integration

parent <string> Required. Project and location from which the integrations should be listed. Format: projects/{project}

optional:
pageSize <integer> The page size for the resquest.
orderBy <string> The results would be returned in order you specified here. Supported sort keys are: Descending sort order by \"last_modified_time\", \"created_time\", \"snapshot_number\". Ascending sort order by the integration name.
filter <string> Filter on fields of IntegrationVersion. Fields can be compared with literal values by use of \":\" (containment), \"=\" (equality), \">\" (greater), \"<\" (less than), >=\" (greater than or equal to), \"<=\" (less than or equal to), and \"!=\" (inequality) operators. Negation, conjunction, and disjunction are written using NOT, AND, and OR keywords. For example, organization_id=\\\"1\\\" AND state=ACTIVE AND description:\"test\". Filtering cannot be performed on repeated fields like `task_config`."
  ([parent] (projects-locations-products-integrations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/integrations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-integrations-test
  "Execute the integration in draft state
https://cloud.google.com/application-integration

name <string> Output only. Auto-generated primary key.
GoogleCloudIntegrationsV1alphaTestIntegrationsRequest:
{:inputParameters object,
 :parameters
 {:parameters
  [{:dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :masked boolean,
    :value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :key string}]},
 :integrationVersion
 {:triggerConfigsInternal
  [{:description string,
    :properties object,
    :cloudSchedulerConfig
    {:errorMessage string,
     :cronTab string,
     :location string,
     :serviceAccountEmail string},
    :triggerId string,
    :errorCatcherId string,
    :nextTasksExecutionPolicy
    [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
    :startTasks
    [{:taskNumber string,
      :combinedConditions
      [{:conditions [EnterpriseCrmEventbusProtoCondition]}],
      :condition string,
      :taskConfigId string,
      :label string,
      :description string}],
    :triggerCriteria
    {:condition string,
     :parameters
     {:parameters [EnterpriseCrmEventbusProtoParameterEntry]},
     :triggerCriteriaTaskImplementationClassName string},
    :alertConfig
    [{:clientId string,
      :numAggregationPeriods integer,
      :metricType
      [METRIC_TYPE_UNSPECIFIED
       EVENT_ERROR_RATE
       EVENT_WARNING_RATE
       TASK_ERROR_RATE
       TASK_WARNING_RATE
       TASK_RATE
       EVENT_RATE
       EVENT_AVERAGE_DURATION
       EVENT_PERCENTILE_DURATION
       TASK_AVERAGE_DURATION
       TASK_PERCENTILE_DURATION],
      :thresholdType
      [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
      :aggregationPeriod string,
      :alertDisabled boolean,
      :errorEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]},
      :onlyFinalAttempt boolean,
      :alertName string,
      :thresholdValue {:absolute string, :percentage integer},
      :durationThresholdMs string,
      :playbookUrl string,
      :warningEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]}}],
    :label string,
    :triggerType
    [UNKNOWN
     CLOUD_PUBSUB
     GOOPS
     SFDC_SYNC
     CRON
     API
     MANIFOLD_TRIGGER
     DATALAYER_DATA_CHANGE
     SFDC_CHANNEL
     CLOUD_PUBSUB_EXTERNAL
     SFDC_CDC_CHANNEL
     SFDC_PLATFORM_EVENTS_CHANNEL
     CLOUD_SCHEDULER
     INTEGRATION_CONNECTOR_TRIGGER
     PRIVATE_TRIGGER],
    :position {:x integer, :y integer},
    :triggerName string,
    :enabledClients [string],
    :triggerNumber string,
    :pauseWorkflowExecutions boolean}],
  :description string,
  :taskConfigsInternal
  [{:description string,
    :failurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :errorCatcherId string,
    :nextTasksExecutionPolicy
    [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
    :disableStrictTypeValidation boolean,
    :taskSpec string,
    :incomingEdgeCount integer,
    :createTime string,
    :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
    :preconditionLabel string,
    :rollbackStrategy
    {:taskNumbersToRollback [string],
     :rollbackTaskImplementationClassName string,
     :parameters
     {:parameters
      [EnterpriseCrmFrontendsEventbusProtoParameterEntry]}},
    :nextTasks
    [{:taskNumber string,
      :combinedConditions
      [{:conditions [EnterpriseCrmEventbusProtoCondition]}],
      :condition string,
      :taskConfigId string,
      :label string,
      :description string}],
    :synchronousCallFailurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :taskTemplateName string,
    :jsonValidationOption
    [UNSPECIFIED_JSON_VALIDATION_OPTION
     SKIP
     PRE_EXECUTION
     POST_EXECUTION
     PRE_POST_EXECUTION],
    :lastModifiedTime string,
    :alertConfigs
    [{:clientId string,
      :numAggregationPeriods integer,
      :metricType
      [METRIC_TYPE_UNSPECIFIED
       TASK_ERROR_RATE
       TASK_WARNING_RATE
       TASK_RATE
       TASK_AVERAGE_DURATION
       TASK_PERCENTILE_DURATION],
      :thresholdType
      [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
      :aggregationPeriod string,
      :alertDisabled boolean,
      :errorEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]},
      :onlyFinalAttempt boolean,
      :alertName string,
      :thresholdValue {:absolute string, :percentage integer},
      :durationThresholdMs string,
      :playbookUrl string,
      :warningEnumList
      {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
       :enumStrings [string]}}],
    :label string,
    :position {:x integer, :y integer},
    :taskEntity
    {:uiConfig
     {:taskUiModuleConfigs
      [EnterpriseCrmEventbusProtoTaskUiModuleConfig]},
     :metadata
     {:description string,
      :category
      [UNSPECIFIED_CATEGORY
       CUSTOM
       FLOW_CONTROL
       DATA_MANIPULATION
       SCRIPTING
       CONNECTOR
       HIDDEN
       CLOUD_SYSTEMS
       CUSTOM_TASK_TEMPLATE
       TASK_RECOMMENDATIONS],
      :defaultSpec string,
      :descriptiveName string,
      :tags [string],
      :externalCategory
      [UNSPECIFIED_EXTERNAL_CATEGORY
       CORE
       CONNECTORS
       EXTERNAL_HTTP
       EXTERNAL_INTEGRATION_SERVICES
       EXTERNAL_CUSTOMER_ACTIONS
       EXTERNAL_FLOW_CONTROL
       EXTERNAL_WORKSPACE
       EXTERNAL_SECURITY
       EXTERNAL_DATABASES
       EXTERNAL_ANALYTICS
       EXTERNAL_BYOC
       EXTERNAL_BYOT
       EXTERNAL_ARTIFICIAL_INTELIGENCE
       EXTERNAL_DATA_MANIPULATION],
      :system
      [UNSPECIFIED_SYSTEM
       GENERIC
       BUGANIZER
       SALESFORCE
       CLOUD_SQL
       PLX
       SHEETS
       GOOGLE_GROUPS
       EMAIL
       SPANNER
       DATA_BRIDGE],
      :codeSearchLink string,
      :externalCategorySequence integer,
      :admins [EnterpriseCrmEventbusProtoTaskMetadataAdmin],
      :name string,
      :g3DocLink string,
      :externalDocHtml string,
      :externalDocMarkdown string,
      :iconLink string,
      :defaultJsonValidationOption
      [UNSPECIFIED_JSON_VALIDATION_OPTION
       SKIP
       PRE_EXECUTION
       POST_EXECUTION
       PRE_POST_EXECUTION],
      :docMarkdown string,
      :standaloneExternalDocHtml string,
      :status [UNSPECIFIED_STATUS DEFAULT_INACTIVE ACTIVE],
      :externalDocLink string,
      :activeTaskName string,
      :isDeprecated boolean},
     :disabledForVpcSc boolean,
     :paramSpecs
     {:parameters [EnterpriseCrmFrontendsEventbusProtoParamSpecEntry]},
     :stats
     {:warningRate number,
      :dimensions EnterpriseCrmEventbusStatsDimensions,
      :qps number,
      :durationInSeconds number,
      :errorRate number},
     :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE]},
    :conditionalFailurePolicies
    {:defaultFailurePolicy
     {:retryCondition string,
      :intervalInSeconds string,
      :maxNumRetries integer,
      :retryStrategy
      [UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_WORKFLOW_WITH_BACKOFF]},
     :failurePolicies
     [{:retryCondition string,
       :intervalInSeconds string,
       :maxNumRetries integer,
       :retryStrategy
       [UNSPECIFIED
        IGNORE
        NONE
        FATAL
        FIXED_INTERVAL
        LINEAR_BACKOFF
        EXPONENTIAL_BACKOFF
        RESTART_WORKFLOW_WITH_BACKOFF]}]},
    :externalTaskType
    [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
    :creatorEmail string,
    :taskName string,
    :parameters object,
    :taskNumber string,
    :taskExecutionStrategy
    [WHEN_ALL_SUCCEED
     WHEN_ANY_SUCCEED
     WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
    :successPolicy {:finalState [UNSPECIFIED SUCCEEDED SUSPENDED]},
    :precondition string}],
  :name string,
  :triggerConfigs
  [{:description string,
    :properties object,
    :cloudSchedulerConfig
    {:errorMessage string,
     :serviceAccountEmail string,
     :cronTab string,
     :location string},
    :triggerId string,
    :errorCatcherId string,
    :nextTasksExecutionPolicy
    [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
     RUN_ALL_MATCH
     RUN_FIRST_MATCH],
    :startTasks
    [{:taskId string,
      :condition string,
      :description string,
      :taskConfigId string,
      :displayName string}],
    :alertConfig
    [{:metricType
      [METRIC_TYPE_UNSPECIFIED
       EVENT_ERROR_RATE
       EVENT_WARNING_RATE
       TASK_ERROR_RATE
       TASK_WARNING_RATE
       TASK_RATE
       EVENT_RATE
       EVENT_AVERAGE_DURATION
       EVENT_PERCENTILE_DURATION
       TASK_AVERAGE_DURATION
       TASK_PERCENTILE_DURATION],
      :thresholdType
      [THRESHOLD_TYPE_UNSPECIFIED EXPECTED_MIN EXPECTED_MAX],
      :displayName string,
      :aggregationPeriod string,
      :durationThreshold string,
      :onlyFinalAttempt boolean,
      :alertThreshold integer,
      :thresholdValue {:percentage integer, :absolute string},
      :disableAlert boolean}],
    :label string,
    :triggerType
    [TRIGGER_TYPE_UNSPECIFIED
     CRON
     API
     SFDC_CHANNEL
     CLOUD_PUBSUB_EXTERNAL
     SFDC_CDC_CHANNEL
     CLOUD_SCHEDULER
     INTEGRATION_CONNECTOR_TRIGGER
     PRIVATE_TRIGGER],
    :position {:x integer, :y integer},
    :trigger string,
    :triggerNumber string}],
  :integrationParameters
  [{:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean}],
  :cloudLoggingDetails
  {:enableCloudLogging boolean,
   :cloudLoggingSeverity
   [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
  :createTime string,
  :userLabel string,
  :state
  [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
  :lastModifierEmail string,
  :runAsServiceAccount string,
  :updateTime string,
  :taskConfigs
  [{:description string,
    :failurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer},
    :errorCatcherId string,
    :task string,
    :nextTasksExecutionPolicy
    [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
     RUN_ALL_MATCH
     RUN_FIRST_MATCH],
    :taskTemplate string,
    :displayName string,
    :nextTasks
    [{:taskId string,
      :condition string,
      :description string,
      :taskConfigId string,
      :displayName string}],
    :synchronousCallFailurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer},
    :jsonValidationOption
    [JSON_VALIDATION_OPTION_UNSPECIFIED
     SKIP
     PRE_EXECUTION
     POST_EXECUTION
     PRE_POST_EXECUTION],
    :position {:x integer, :y integer},
    :conditionalFailurePolicies
    {:failurePolicies
     [{:intervalTime string,
       :retryStrategy
       [RETRY_STRATEGY_UNSPECIFIED
        IGNORE
        NONE
        FATAL
        FIXED_INTERVAL
        LINEAR_BACKOFF
        EXPONENTIAL_BACKOFF
        RESTART_INTEGRATION_WITH_BACKOFF],
       :condition string,
       :maxRetries integer}],
     :defaultFailurePolicy
     {:intervalTime string,
      :retryStrategy
      [RETRY_STRATEGY_UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_INTEGRATION_WITH_BACKOFF],
      :condition string,
      :maxRetries integer}},
    :externalTaskType
    [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
    :taskId string,
    :parameters object,
    :taskExecutionStrategy
    [TASK_EXECUTION_STRATEGY_UNSPECIFIED
     WHEN_ALL_SUCCEED
     WHEN_ANY_SUCCEED
     WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
    :successPolicy
    {:finalState [FINAL_STATE_UNSPECIFIED SUCCEEDED SUSPENDED]}}],
  :errorCatcherConfigs
  [{:errorCatcherId string,
    :label string,
    :errorCatcherNumber string,
    :startErrorTasks
    [{:taskId string,
      :condition string,
      :description string,
      :taskConfigId string,
      :displayName string}],
    :description string,
    :position {:x integer, :y integer}}],
  :databasePersistencePolicy
  [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
   DATABASE_PERSISTENCE_DISABLED
   DATABASE_PERSISTENCE_ASYNC],
  :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
  :integrationConfigParameters
  [{:parameter
    {:containsLargeData boolean,
     :producer string,
     :key string,
     :displayName string,
     :isTransient boolean,
     :searchable boolean,
     :jsonSchema string,
     :dataType
     [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
      STRING_VALUE
      INT_VALUE
      DOUBLE_VALUE
      BOOLEAN_VALUE
      STRING_ARRAY
      INT_ARRAY
      DOUBLE_ARRAY
      BOOLEAN_ARRAY
      JSON_VALUE
      PROTO_VALUE
      PROTO_ARRAY],
     :defaultValue
     {:intValue string,
      :stringArray GoogleCloudIntegrationsV1alphaStringParameterArray,
      :booleanValue boolean,
      :stringValue string,
      :jsonValue string,
      :intArray GoogleCloudIntegrationsV1alphaIntParameterArray,
      :doubleArray GoogleCloudIntegrationsV1alphaDoubleParameterArray,
      :doubleValue number,
      :booleanArray
      GoogleCloudIntegrationsV1alphaBooleanParameterArray},
     :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
     :masked boolean},
    :value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}}}],
  :snapshotNumber string,
  :origin
  [UNSPECIFIED
   UI
   PIPER_V2
   PIPER_V3
   APPLICATION_IP_PROVISIONING
   TEST_CASE],
  :enableVariableMasking boolean,
  :integrationParametersInternal
  {:parameters
   [{:description string,
     :containsLargeData boolean,
     :children
     [{:description string,
       :containsLargeData boolean,
       :children
       [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry],
       :producer string,
       :key string,
       :protoDefName string,
       :name string,
       :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
       :isTransient boolean,
       :producedBy EnterpriseCrmEventbusProtoNodeIdentifier,
       :jsonSchema string,
       :protoDefPath string,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :defaultValue
       EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :attributes EnterpriseCrmEventbusProtoAttributes,
       :required boolean}],
     :producer string,
     :key string,
     :protoDefName string,
     :name string,
     :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
     :isTransient boolean,
     :producedBy
     {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
      :elementIdentifier string},
     :jsonSchema string,
     :protoDefPath string,
     :dataType
     [DATA_TYPE_UNSPECIFIED
      STRING_VALUE
      INT_VALUE
      DOUBLE_VALUE
      BOOLEAN_VALUE
      PROTO_VALUE
      SERIALIZED_OBJECT_VALUE
      STRING_ARRAY
      INT_ARRAY
      DOUBLE_ARRAY
      PROTO_ARRAY
      PROTO_ENUM
      BOOLEAN_ARRAY
      PROTO_ENUM_ARRAY
      BYTES
      BYTES_ARRAY
      NON_SERIALIZABLE_OBJECT
      JSON_VALUE],
     :defaultValue
     {:intValue string,
      :stringArray
      EnterpriseCrmFrontendsEventbusProtoStringParameterArray,
      :serializedObjectValue
      EnterpriseCrmFrontendsEventbusProtoSerializedObjectParameter,
      :booleanValue boolean,
      :stringValue string,
      :jsonValue string,
      :intArray EnterpriseCrmFrontendsEventbusProtoIntParameterArray,
      :doubleArray
      EnterpriseCrmFrontendsEventbusProtoDoubleParameterArray,
      :doubleValue number,
      :booleanArray
      EnterpriseCrmFrontendsEventbusProtoBooleanParameterArray,
      :protoArray
      EnterpriseCrmFrontendsEventbusProtoProtoParameterArray,
      :protoValue object},
     :attributes
     {:logSettings EnterpriseCrmEventbusProtoLogSettings,
      :isSearchable boolean,
      :searchable [UNSPECIFIED YES NO],
      :readOnly boolean,
      :dataType
      [DATA_TYPE_UNSPECIFIED EMAIL URL CURRENCY TIMESTAMP DOMAIN_NAME],
      :taskVisibility [string],
      :isRequired boolean,
      :defaultValue EnterpriseCrmEventbusProtoValueType,
      :masked boolean},
     :required boolean}]},
  :teardown
  {:teardownTaskConfigs
   [{:properties
     {:properties [EnterpriseCrmEventbusProtoPropertyEntry]},
     :nextTeardownTask {:name string},
     :name string,
     :parameters
     {:parameters [EnterpriseCrmEventbusProtoParameterEntry]},
     :teardownTaskImplementationClassName string,
     :creatorEmail string}]},
  :createdFromTemplate string,
  :lockHolder string,
  :parentTemplateId string},
 :testMode boolean,
 :triggerId string,
 :deadlineSecondsTime string,
 :clientId string,
 :configParameters object}"
  [name GoogleCloudIntegrationsV1alphaTestIntegrationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:test",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaTestIntegrationsRequest}))

(defn projects-locations-products-integrations-execute
  "Executes integrations synchronously by passing the trigger id in the request body. The request is not returned until the requested executions are either fulfilled or experienced an error. If the integration name is not specified (passing `-`), all of the associated integration under the given trigger_id will be executed. Otherwise only the specified integration for the given `trigger_id` is executed. This is helpful for execution the integration from UI.
https://cloud.google.com/application-integration

name <string> Required. The integration resource name.
GoogleCloudIntegrationsV1alphaExecuteIntegrationsRequest:
{:inputParameters object,
 :parameterEntries
 [{:dataType
   [DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    PROTO_VALUE
    SERIALIZED_OBJECT_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    PROTO_ARRAY
    PROTO_ENUM
    BOOLEAN_ARRAY
    PROTO_ENUM_ARRAY
    BYTES
    BYTES_ARRAY
    NON_SERIALIZABLE_OBJECT
    JSON_VALUE],
   :masked boolean,
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :serializedObjectValue {:objectValue string},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]},
    :protoArray {:protoValues [object]},
    :protoValue object},
   :key string}],
 :triggerId string,
 :doNotPropagateError boolean,
 :requestId string,
 :executionId string,
 :parameters
 {:parameters
  [{:dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :masked boolean,
    :value
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :key string}]}}"
  [name GoogleCloudIntegrationsV1alphaExecuteIntegrationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:execute",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaExecuteIntegrationsRequest}))

(defn projects-locations-products-integrations-executions-list
  "Lists the results of all the integration executions. The response includes the same information as the [execution log](https://cloud.google.com/application-integration/docs/viewing-logs) in the Integration UI.
https://cloud.google.com/application-integration

parent <string> Required. The parent resource name of the integration execution.

optional:
filterParams.workflowName <string> Workflow name.
filterParams.startTime <string> Start timestamp.
filterParams.parameterKey <string> Param key. DEPRECATED. User parameter_pair_key instead.
filterParams.parameterValue <string> Param value. DEPRECATED. User parameter_pair_value instead.
truncateParams <boolean> Optional. If true, the service will truncate the params to only keep the first 1000 characters of string params and empty the executions in order to make response smaller. Only works for UI and when the params fields are not filtered out.
filterParams.taskStatuses <string> List of possible task statuses.
snapshotMetadataWithoutParams <boolean> Optional. If true, the service will provide execution info with snapshot metadata only i.e. without event parameters.
filterParams.parameterPairValue <string> Param value in the key value pair filter.
filterParams.eventStatuses <string> List of possible event statuses.
filterParams.customFilter <string> Optional user-provided custom filter.
filterParams.parameterType <string> Param type.
filter <string> Optional. Standard filter field, we support filtering on following fields: workflow_name: the name of the integration. CreateTimestamp: the execution created time. event_execution_state: the state of the executions. execution_id: the id of the execution. trigger_id: the id of the trigger. parameter_type: the type of the parameters involved in the execution. All fields support for EQUALS, in additional: CreateTimestamp support for LESS_THAN, GREATER_THAN ParameterType support for HAS For example: \"parameter_type\" HAS \\\"string\\\" Also supports operators like AND, OR, NOT For example, trigger_id=\\\"id1\\\" AND workflow_name=\\\"testWorkflow\\\"
pageSize <integer> Optional. The size of entries in the response.
filterParams.executionId <string> Execution id.
filterParams.endTime <string> End timestamp.
readMask <string> Optional. View mask for the response data. If set, only the field specified will be returned as part of the result. If not set, all fields in event execution info will be filled and returned.
filterParams.parameterPairKey <string> Param key in the key value pair filter.
refreshAcl <boolean> Optional. If true, the service will use the most recent acl information to list event execution infos and renew the acl cache. Note that fetching the most recent acl is synchronous, so it will increase RPC call latency.
orderBy <string> Optional. The results would be returned in order you specified here. Currently supporting \"create_time\"."
  ([parent]
    (projects-locations-products-integrations-executions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/executions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-integrations-executions-get
  "Get an execution in the specified project.
https://cloud.google.com/application-integration

name <string> Required. The execution resource name. Format: projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_id}/executions/{execution_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-integrations-executions-download
  "Download the execution.
https://cloud.google.com/application-integration

name <string> Required. The execution resource name. Format: projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_id}/executions/{execution_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:download",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-integrations-executions-cancel
  "Cancellation of an execution
https://cloud.google.com/application-integration

name <string> Required. The execution resource name. Format: projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_id}/executions/{execution_id}
GoogleCloudIntegrationsV1alphaCancelExecutionRequest:
object"
  [name GoogleCloudIntegrationsV1alphaCancelExecutionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaCancelExecutionRequest}))

(defn projects-locations-products-integrations-executions-suspensions-list
  "* Lists suspensions associated with a specific execution. Only those with permissions to resolve the relevant suspensions will be able to view them.
https://cloud.google.com/application-integration

parent <string> Required. projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_name}/executions/{execution_name}

optional:
filter <string> Standard filter field.
orderBy <string> Field name to order by.
pageSize <integer> Maximum number of entries in the response."
  ([parent]
    (projects-locations-products-integrations-executions-suspensions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/suspensions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-integrations-executions-suspensions-resolve
  "* Resolves (lifts/rejects) any number of suspensions. If the integration is already running, only the status of the suspension is updated. Otherwise, the suspended integration will begin execution again.
https://cloud.google.com/application-integration

name <string> Required. projects/{gcp_project_id}/locations/{location}/products/{product}/integrations/{integration_name}/executions/{execution_name}/suspensions/{suspension_id}
GoogleCloudIntegrationsV1alphaResolveSuspensionRequest:
{:suspension
 {:lastModifyTime string,
  :name string,
  :createTime string,
  :integration string,
  :state [RESOLUTION_STATE_UNSPECIFIED PENDING REJECTED LIFTED],
  :suspensionConfig
  {:suspensionExpiration
   {:remindAfterMs integer,
    :expireAfterMs integer,
    :liftWhenExpired boolean},
   :customMessage string,
   :whoMayResolve
   [{:loasRole string,
     :googleGroup {:gaiaId string, :emailAddress string},
     :gaiaIdentity {:gaiaId string, :emailAddress string},
     :mdbGroup string}],
   :notifications
   [{:pubsubTopic string,
     :request
     {:postToQueueWithTriggerIdRequest
      GoogleInternalCloudCrmEventbusV3PostToQueueWithTriggerIdRequest,
      :suspensionInfoEventParameterKey string},
     :escalatorQueue string,
     :emailAddress
     {:email string,
      :name string,
      :tokens [EnterpriseCrmEventbusProtoToken]},
     :buganizerNotification
     {:templateId string,
      :componentId string,
      :assigneeEmailAddress string,
      :title string}}]},
  :audit {:resolveTime string, :resolver string},
  :approvalConfig
  {:expiration
   {:remindTime string, :liftWhenExpired boolean, :expireTime string},
   :customMessage string,
   :emailAddresses [string]},
  :eventExecutionInfoId string,
  :taskId string}}"
  [name GoogleCloudIntegrationsV1alphaResolveSuspensionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:resolve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaResolveSuspensionRequest}))

(defn projects-locations-products-integrations-executions-suspensions-lift
  "* Lifts suspension for the Suspension task. Fetch corresponding suspension with provided suspension Id, resolve suspension, and set up suspension result for the Suspension Task.
https://cloud.google.com/application-integration

name <string> Required. The resource that the suspension belongs to. \"projects/{project}/locations/{location}/products/{product}/integrations/{integration}/executions/{execution}/suspensions/{suspenion}\" format.
GoogleCloudIntegrationsV1alphaLiftSuspensionRequest:
{:suspensionResult string}"
  [name GoogleCloudIntegrationsV1alphaLiftSuspensionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:lift",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaLiftSuspensionRequest}))

(defn projects-locations-products-integrations-versions-unpublish
  "Sets the status of the ACTIVE integration to SNAPSHOT with a new tag \"PREVIOUSLY_PUBLISHED\" after validating it. The \"HEAD\" and \"PUBLISH_REQUESTED\" tags do not change. This RPC throws an exception if the version being snapshot is not ACTIVE. Audit fields added include action, action_by, action_timestamp.
https://cloud.google.com/application-integration

name <string> Required. The version to deactivate. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}
GoogleCloudIntegrationsV1alphaUnpublishIntegrationVersionRequest:
object"
  [name
   GoogleCloudIntegrationsV1alphaUnpublishIntegrationVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:unpublish",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudIntegrationsV1alphaUnpublishIntegrationVersionRequest}))

(defn projects-locations-products-integrations-versions-get
  "Get a integration in the specified project.
https://cloud.google.com/application-integration

name <string> Required. The version to retrieve. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-integrations-versions-patch
  "Update a integration with a draft version in the specified project.
https://cloud.google.com/application-integration

name <string> Output only. Auto-generated primary key.
GoogleCloudIntegrationsV1alphaIntegrationVersion:
{:triggerConfigsInternal
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :cronTab string,
    :location string,
    :serviceAccountEmail string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :startTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :triggerCriteria
   {:condition string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :triggerCriteriaTaskImplementationClassName string},
   :alertConfig
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :triggerType
   [UNKNOWN
    CLOUD_PUBSUB
    GOOPS
    SFDC_SYNC
    CRON
    API
    MANIFOLD_TRIGGER
    DATALAYER_DATA_CHANGE
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    SFDC_PLATFORM_EVENTS_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :triggerName string,
   :enabledClients [string],
   :triggerNumber string,
   :pauseWorkflowExecutions boolean}],
 :description string,
 :taskConfigsInternal
 [{:description string,
   :failurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :disableStrictTypeValidation boolean,
   :taskSpec string,
   :incomingEdgeCount integer,
   :createTime string,
   :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
   :preconditionLabel string,
   :rollbackStrategy
   {:taskNumbersToRollback [string],
    :rollbackTaskImplementationClassName string,
    :parameters
    {:parameters
     [{:dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :masked boolean,
       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :key string}]}},
   :nextTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :synchronousCallFailurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :taskTemplateName string,
   :jsonValidationOption
   [UNSPECIFIED_JSON_VALIDATION_OPTION
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :lastModifiedTime string,
   :alertConfigs
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :position {:x integer, :y integer},
   :taskEntity
   {:uiConfig
    {:taskUiModuleConfigs
     [{:moduleId
       [UNSPECIFIED_TASK_MODULE
        LABEL
        ERROR_HANDLING
        TASK_PARAM_TABLE
        TASK_PARAM_FORM
        PRECONDITION
        SCRIPT_EDITOR
        RPC
        TASK_SUMMARY
        SUSPENSION
        RPC_TYPED
        SUB_WORKFLOW
        APPS_SCRIPT_NAVIGATOR
        SUB_WORKFLOW_FOR_EACH_LOOP
        FIELD_MAPPING
        README
        REST_CALLER
        SUB_WORKFLOW_SCATTER_GATHER
        CLOUD_SQL
        GENERIC_CONNECTOR_TASK]}]},
    :metadata
    {:description string,
     :category
     [UNSPECIFIED_CATEGORY
      CUSTOM
      FLOW_CONTROL
      DATA_MANIPULATION
      SCRIPTING
      CONNECTOR
      HIDDEN
      CLOUD_SYSTEMS
      CUSTOM_TASK_TEMPLATE
      TASK_RECOMMENDATIONS],
     :defaultSpec string,
     :descriptiveName string,
     :tags [string],
     :externalCategory
     [UNSPECIFIED_EXTERNAL_CATEGORY
      CORE
      CONNECTORS
      EXTERNAL_HTTP
      EXTERNAL_INTEGRATION_SERVICES
      EXTERNAL_CUSTOMER_ACTIONS
      EXTERNAL_FLOW_CONTROL
      EXTERNAL_WORKSPACE
      EXTERNAL_SECURITY
      EXTERNAL_DATABASES
      EXTERNAL_ANALYTICS
      EXTERNAL_BYOC
      EXTERNAL_BYOT
      EXTERNAL_ARTIFICIAL_INTELIGENCE
      EXTERNAL_DATA_MANIPULATION],
     :system
     [UNSPECIFIED_SYSTEM
      GENERIC
      BUGANIZER
      SALESFORCE
      CLOUD_SQL
      PLX
      SHEETS
      GOOGLE_GROUPS
      EMAIL
      SPANNER
      DATA_BRIDGE],
     :codeSearchLink string,
     :externalCategorySequence integer,
     :admins [{:googleGroupEmail string, :userEmail string}],
     :name string,
     :g3DocLink string,
     :externalDocHtml string,
     :externalDocMarkdown string,
     :iconLink string,
     :defaultJsonValidationOption
     [UNSPECIFIED_JSON_VALIDATION_OPTION
      SKIP
      PRE_EXECUTION
      POST_EXECUTION
      PRE_POST_EXECUTION],
     :docMarkdown string,
     :standaloneExternalDocHtml string,
     :status [UNSPECIFIED_STATUS DEFAULT_INACTIVE ACTIVE],
     :externalDocLink string,
     :activeTaskName string,
     :isDeprecated boolean},
    :disabledForVpcSc boolean,
    :paramSpecs
    {:parameters
     [{:validationRule
       EnterpriseCrmEventbusProtoParamSpecEntryValidationRule,
       :key string,
       :protoDef
       EnterpriseCrmEventbusProtoParamSpecEntryProtoDefinition,
       :config EnterpriseCrmEventbusProtoParamSpecEntryConfig,
       :isOutput boolean,
       :collectionElementClassName string,
       :className string,
       :jsonSchema string,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :defaultValue
       EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :isDeprecated boolean,
       :required boolean}]},
    :stats
    {:warningRate number,
     :dimensions
     {:clientId string,
      :triggerId string,
      :workflowId string,
      :retryAttempt [UNSPECIFIED FINAL RETRYABLE CANCELED],
      :warningEnumString string,
      :workflowName string,
      :enumFilterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :taskName string,
      :taskNumber string,
      :errorEnumString string},
     :qps number,
     :durationInSeconds number,
     :errorRate number},
    :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE]},
   :conditionalFailurePolicies
   {:defaultFailurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :failurePolicies
    [{:retryCondition string,
      :intervalInSeconds string,
      :maxNumRetries integer,
      :retryStrategy
      [UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_WORKFLOW_WITH_BACKOFF]}]},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :creatorEmail string,
   :taskName string,
   :parameters object,
   :taskNumber string,
   :taskExecutionStrategy
   [WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy {:finalState [UNSPECIFIED SUCCEEDED SUSPENDED]},
   :precondition string}],
 :name string,
 :triggerConfigs
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :serviceAccountEmail string,
    :cronTab string,
    :location string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :startTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :alertConfig
   [{:metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [THRESHOLD_TYPE_UNSPECIFIED EXPECTED_MIN EXPECTED_MAX],
     :displayName string,
     :aggregationPeriod string,
     :durationThreshold string,
     :onlyFinalAttempt boolean,
     :alertThreshold integer,
     :thresholdValue {:percentage integer, :absolute string},
     :disableAlert boolean}],
   :label string,
   :triggerType
   [TRIGGER_TYPE_UNSPECIFIED
    CRON
    API
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :trigger string,
   :triggerNumber string}],
 :integrationParameters
 [{:containsLargeData boolean,
   :producer string,
   :key string,
   :displayName string,
   :isTransient boolean,
   :searchable boolean,
   :jsonSchema string,
   :dataType
   [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    BOOLEAN_ARRAY
    JSON_VALUE
    PROTO_VALUE
    PROTO_ARRAY],
   :defaultValue
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}},
   :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
   :masked boolean}],
 :cloudLoggingDetails
 {:enableCloudLogging boolean,
  :cloudLoggingSeverity
  [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
 :createTime string,
 :userLabel string,
 :state [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :lastModifierEmail string,
 :runAsServiceAccount string,
 :updateTime string,
 :taskConfigs
 [{:description string,
   :failurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :errorCatcherId string,
   :task string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :taskTemplate string,
   :displayName string,
   :nextTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :synchronousCallFailurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :jsonValidationOption
   [JSON_VALIDATION_OPTION_UNSPECIFIED
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :position {:x integer, :y integer},
   :conditionalFailurePolicies
   {:failurePolicies
    [{:intervalTime string,
      :retryStrategy
      [RETRY_STRATEGY_UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_INTEGRATION_WITH_BACKOFF],
      :condition string,
      :maxRetries integer}],
    :defaultFailurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer}},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :taskId string,
   :parameters object,
   :taskExecutionStrategy
   [TASK_EXECUTION_STRATEGY_UNSPECIFIED
    WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy
   {:finalState [FINAL_STATE_UNSPECIFIED SUCCEEDED SUSPENDED]}}],
 :errorCatcherConfigs
 [{:errorCatcherId string,
   :label string,
   :errorCatcherNumber string,
   :startErrorTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :description string,
   :position {:x integer, :y integer}}],
 :databasePersistencePolicy
 [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
  DATABASE_PERSISTENCE_DISABLED
  DATABASE_PERSISTENCE_ASYNC],
 :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :integrationConfigParameters
 [{:parameter
   {:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean},
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}}}],
 :snapshotNumber string,
 :origin
 [UNSPECIFIED
  UI
  PIPER_V2
  PIPER_V3
  APPLICATION_IP_PROVISIONING
  TEST_CASE],
 :enableVariableMasking boolean,
 :integrationParametersInternal
 {:parameters
  [{:description string,
    :containsLargeData boolean,
    :children
    [{:description string,
      :containsLargeData boolean,
      :children
      [{:description string,
        :containsLargeData boolean,
        :children
        [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry],
        :producer string,
        :key string,
        :protoDefName string,
        :name string,
        :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
        :isTransient boolean,
        :producedBy EnterpriseCrmEventbusProtoNodeIdentifier,
        :jsonSchema string,
        :protoDefPath string,
        :dataType
        [DATA_TYPE_UNSPECIFIED
         STRING_VALUE
         INT_VALUE
         DOUBLE_VALUE
         BOOLEAN_VALUE
         PROTO_VALUE
         SERIALIZED_OBJECT_VALUE
         STRING_ARRAY
         INT_ARRAY
         DOUBLE_ARRAY
         PROTO_ARRAY
         PROTO_ENUM
         BOOLEAN_ARRAY
         PROTO_ENUM_ARRAY
         BYTES
         BYTES_ARRAY
         NON_SERIALIZABLE_OBJECT
         JSON_VALUE],
        :defaultValue
        EnterpriseCrmFrontendsEventbusProtoParameterValueType,
        :attributes EnterpriseCrmEventbusProtoAttributes,
        :required boolean}],
      :producer string,
      :key string,
      :protoDefName string,
      :name string,
      :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :isTransient boolean,
      :producedBy
      {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
       :elementIdentifier string},
      :jsonSchema string,
      :protoDefPath string,
      :dataType
      [DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       PROTO_VALUE
       SERIALIZED_OBJECT_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       PROTO_ARRAY
       PROTO_ENUM
       BOOLEAN_ARRAY
       PROTO_ENUM_ARRAY
       BYTES
       BYTES_ARRAY
       NON_SERIALIZABLE_OBJECT
       JSON_VALUE],
      :defaultValue
      {:intValue string,
       :stringArray
       EnterpriseCrmFrontendsEventbusProtoStringParameterArray,
       :serializedObjectValue
       EnterpriseCrmFrontendsEventbusProtoSerializedObjectParameter,
       :booleanValue boolean,
       :stringValue string,
       :jsonValue string,
       :intArray EnterpriseCrmFrontendsEventbusProtoIntParameterArray,
       :doubleArray
       EnterpriseCrmFrontendsEventbusProtoDoubleParameterArray,
       :doubleValue number,
       :booleanArray
       EnterpriseCrmFrontendsEventbusProtoBooleanParameterArray,
       :protoArray
       EnterpriseCrmFrontendsEventbusProtoProtoParameterArray,
       :protoValue object},
      :attributes
      {:logSettings EnterpriseCrmEventbusProtoLogSettings,
       :isSearchable boolean,
       :searchable [UNSPECIFIED YES NO],
       :readOnly boolean,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        EMAIL
        URL
        CURRENCY
        TIMESTAMP
        DOMAIN_NAME],
       :taskVisibility [string],
       :isRequired boolean,
       :defaultValue EnterpriseCrmEventbusProtoValueType,
       :masked boolean},
      :required boolean}],
    :producer string,
    :key string,
    :protoDefName string,
    :name string,
    :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :isTransient boolean,
    :producedBy
    {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
     :elementIdentifier string},
    :jsonSchema string,
    :protoDefPath string,
    :dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :attributes
    {:logSettings
     {:logFieldName string,
      :shorteningLimits EnterpriseCrmLoggingGwsFieldLimits,
      :seedPeriod [SEED_PERIOD_UNSPECIFIED DAY WEEK MONTH],
      :seedScope
      [SEED_SCOPE_UNSPECIFIED EVENT_NAME TIME_PERIOD PARAM_NAME],
      :sanitizeOptions EnterpriseCrmLoggingGwsSanitizeOptions},
     :isSearchable boolean,
     :searchable [UNSPECIFIED YES NO],
     :readOnly boolean,
     :dataType
     [DATA_TYPE_UNSPECIFIED EMAIL URL CURRENCY TIMESTAMP DOMAIN_NAME],
     :taskVisibility [string],
     :isRequired boolean,
     :defaultValue
     {:doubleValue number,
      :protoValue object,
      :intValue string,
      :booleanValue boolean,
      :intArray EnterpriseCrmEventbusProtoIntArray,
      :stringArray EnterpriseCrmEventbusProtoStringArray,
      :doubleArray EnterpriseCrmEventbusProtoDoubleArray,
      :stringValue string},
     :masked boolean},
    :required boolean}]},
 :teardown
 {:teardownTaskConfigs
  [{:properties
    {:properties
     [{:value EnterpriseCrmEventbusProtoValueType, :key string}]},
    :nextTeardownTask {:name string},
    :name string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :teardownTaskImplementationClassName string,
    :creatorEmail string}]},
 :createdFromTemplate string,
 :lockHolder string,
 :parentTemplateId string}

optional:
updateMask <string> Field mask specifying the fields in the above integration that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaIntegrationVersion]
    (projects-locations-products-integrations-versions-patch
      name
      GoogleCloudIntegrationsV1alphaIntegrationVersion
      nil))
  ([name GoogleCloudIntegrationsV1alphaIntegrationVersion optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaIntegrationVersion})))

(defn projects-locations-products-integrations-versions-create
  "Create a integration with a draft version in the specified project.
https://cloud.google.com/application-integration

parent <string> Required. The parent resource where this version will be created. Format: projects/{project}/locations/{location}/integrations/{integration}
GoogleCloudIntegrationsV1alphaIntegrationVersion:
{:triggerConfigsInternal
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :cronTab string,
    :location string,
    :serviceAccountEmail string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :startTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :triggerCriteria
   {:condition string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :triggerCriteriaTaskImplementationClassName string},
   :alertConfig
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :triggerType
   [UNKNOWN
    CLOUD_PUBSUB
    GOOPS
    SFDC_SYNC
    CRON
    API
    MANIFOLD_TRIGGER
    DATALAYER_DATA_CHANGE
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    SFDC_PLATFORM_EVENTS_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :triggerName string,
   :enabledClients [string],
   :triggerNumber string,
   :pauseWorkflowExecutions boolean}],
 :description string,
 :taskConfigsInternal
 [{:description string,
   :failurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
   :disableStrictTypeValidation boolean,
   :taskSpec string,
   :incomingEdgeCount integer,
   :createTime string,
   :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
   :preconditionLabel string,
   :rollbackStrategy
   {:taskNumbersToRollback [string],
    :rollbackTaskImplementationClassName string,
    :parameters
    {:parameters
     [{:dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :masked boolean,
       :value EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :key string}]}},
   :nextTasks
   [{:taskNumber string,
     :combinedConditions
     [{:conditions
       [{:eventPropertyKey string,
         :operator
         [UNSET
          EQUALS
          CONTAINS
          LESS_THAN
          GREATER_THAN
          EXISTS
          DOES_NOT_EXIST
          IS_EMPTY
          IS_NOT_EMPTY],
         :value EnterpriseCrmEventbusProtoValueType}]}],
     :condition string,
     :taskConfigId string,
     :label string,
     :description string}],
   :synchronousCallFailurePolicy
   {:retryCondition string,
    :intervalInSeconds string,
    :maxNumRetries integer,
    :retryStrategy
    [UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_WORKFLOW_WITH_BACKOFF]},
   :taskTemplateName string,
   :jsonValidationOption
   [UNSPECIFIED_JSON_VALIDATION_OPTION
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :lastModifiedTime string,
   :alertConfigs
   [{:clientId string,
     :numAggregationPeriods integer,
     :metricType
     [METRIC_TYPE_UNSPECIFIED
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [UNSPECIFIED_THRESHOLD_TYPE EXPECTED_MIN EXPECTED_MAX],
     :aggregationPeriod string,
     :alertDisabled boolean,
     :errorEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]},
     :onlyFinalAttempt boolean,
     :alertName string,
     :thresholdValue {:absolute string, :percentage integer},
     :durationThresholdMs string,
     :playbookUrl string,
     :warningEnumList
     {:filterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :enumStrings [string]}}],
   :label string,
   :position {:x integer, :y integer},
   :taskEntity
   {:uiConfig
    {:taskUiModuleConfigs
     [{:moduleId
       [UNSPECIFIED_TASK_MODULE
        LABEL
        ERROR_HANDLING
        TASK_PARAM_TABLE
        TASK_PARAM_FORM
        PRECONDITION
        SCRIPT_EDITOR
        RPC
        TASK_SUMMARY
        SUSPENSION
        RPC_TYPED
        SUB_WORKFLOW
        APPS_SCRIPT_NAVIGATOR
        SUB_WORKFLOW_FOR_EACH_LOOP
        FIELD_MAPPING
        README
        REST_CALLER
        SUB_WORKFLOW_SCATTER_GATHER
        CLOUD_SQL
        GENERIC_CONNECTOR_TASK]}]},
    :metadata
    {:description string,
     :category
     [UNSPECIFIED_CATEGORY
      CUSTOM
      FLOW_CONTROL
      DATA_MANIPULATION
      SCRIPTING
      CONNECTOR
      HIDDEN
      CLOUD_SYSTEMS
      CUSTOM_TASK_TEMPLATE
      TASK_RECOMMENDATIONS],
     :defaultSpec string,
     :descriptiveName string,
     :tags [string],
     :externalCategory
     [UNSPECIFIED_EXTERNAL_CATEGORY
      CORE
      CONNECTORS
      EXTERNAL_HTTP
      EXTERNAL_INTEGRATION_SERVICES
      EXTERNAL_CUSTOMER_ACTIONS
      EXTERNAL_FLOW_CONTROL
      EXTERNAL_WORKSPACE
      EXTERNAL_SECURITY
      EXTERNAL_DATABASES
      EXTERNAL_ANALYTICS
      EXTERNAL_BYOC
      EXTERNAL_BYOT
      EXTERNAL_ARTIFICIAL_INTELIGENCE
      EXTERNAL_DATA_MANIPULATION],
     :system
     [UNSPECIFIED_SYSTEM
      GENERIC
      BUGANIZER
      SALESFORCE
      CLOUD_SQL
      PLX
      SHEETS
      GOOGLE_GROUPS
      EMAIL
      SPANNER
      DATA_BRIDGE],
     :codeSearchLink string,
     :externalCategorySequence integer,
     :admins [{:googleGroupEmail string, :userEmail string}],
     :name string,
     :g3DocLink string,
     :externalDocHtml string,
     :externalDocMarkdown string,
     :iconLink string,
     :defaultJsonValidationOption
     [UNSPECIFIED_JSON_VALIDATION_OPTION
      SKIP
      PRE_EXECUTION
      POST_EXECUTION
      PRE_POST_EXECUTION],
     :docMarkdown string,
     :standaloneExternalDocHtml string,
     :status [UNSPECIFIED_STATUS DEFAULT_INACTIVE ACTIVE],
     :externalDocLink string,
     :activeTaskName string,
     :isDeprecated boolean},
    :disabledForVpcSc boolean,
    :paramSpecs
    {:parameters
     [{:validationRule
       EnterpriseCrmEventbusProtoParamSpecEntryValidationRule,
       :key string,
       :protoDef
       EnterpriseCrmEventbusProtoParamSpecEntryProtoDefinition,
       :config EnterpriseCrmEventbusProtoParamSpecEntryConfig,
       :isOutput boolean,
       :collectionElementClassName string,
       :className string,
       :jsonSchema string,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        PROTO_VALUE
        SERIALIZED_OBJECT_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        PROTO_ARRAY
        PROTO_ENUM
        BOOLEAN_ARRAY
        PROTO_ENUM_ARRAY
        BYTES
        BYTES_ARRAY
        NON_SERIALIZABLE_OBJECT
        JSON_VALUE],
       :defaultValue
       EnterpriseCrmFrontendsEventbusProtoParameterValueType,
       :isDeprecated boolean,
       :required boolean}]},
    :stats
    {:warningRate number,
     :dimensions
     {:clientId string,
      :triggerId string,
      :workflowId string,
      :retryAttempt [UNSPECIFIED FINAL RETRYABLE CANCELED],
      :warningEnumString string,
      :workflowName string,
      :enumFilterType [DEFAULT_INCLUSIVE EXCLUSIVE],
      :taskName string,
      :taskNumber string,
      :errorEnumString string},
     :qps number,
     :durationInSeconds number,
     :errorRate number},
    :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE]},
   :conditionalFailurePolicies
   {:defaultFailurePolicy
    {:retryCondition string,
     :intervalInSeconds string,
     :maxNumRetries integer,
     :retryStrategy
     [UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_WORKFLOW_WITH_BACKOFF]},
    :failurePolicies
    [{:retryCondition string,
      :intervalInSeconds string,
      :maxNumRetries integer,
      :retryStrategy
      [UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_WORKFLOW_WITH_BACKOFF]}]},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :creatorEmail string,
   :taskName string,
   :parameters object,
   :taskNumber string,
   :taskExecutionStrategy
   [WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy {:finalState [UNSPECIFIED SUCCEEDED SUSPENDED]},
   :precondition string}],
 :name string,
 :triggerConfigs
 [{:description string,
   :properties object,
   :cloudSchedulerConfig
   {:errorMessage string,
    :serviceAccountEmail string,
    :cronTab string,
    :location string},
   :triggerId string,
   :errorCatcherId string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :startTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :alertConfig
   [{:metricType
     [METRIC_TYPE_UNSPECIFIED
      EVENT_ERROR_RATE
      EVENT_WARNING_RATE
      TASK_ERROR_RATE
      TASK_WARNING_RATE
      TASK_RATE
      EVENT_RATE
      EVENT_AVERAGE_DURATION
      EVENT_PERCENTILE_DURATION
      TASK_AVERAGE_DURATION
      TASK_PERCENTILE_DURATION],
     :thresholdType
     [THRESHOLD_TYPE_UNSPECIFIED EXPECTED_MIN EXPECTED_MAX],
     :displayName string,
     :aggregationPeriod string,
     :durationThreshold string,
     :onlyFinalAttempt boolean,
     :alertThreshold integer,
     :thresholdValue {:percentage integer, :absolute string},
     :disableAlert boolean}],
   :label string,
   :triggerType
   [TRIGGER_TYPE_UNSPECIFIED
    CRON
    API
    SFDC_CHANNEL
    CLOUD_PUBSUB_EXTERNAL
    SFDC_CDC_CHANNEL
    CLOUD_SCHEDULER
    INTEGRATION_CONNECTOR_TRIGGER
    PRIVATE_TRIGGER],
   :position {:x integer, :y integer},
   :trigger string,
   :triggerNumber string}],
 :integrationParameters
 [{:containsLargeData boolean,
   :producer string,
   :key string,
   :displayName string,
   :isTransient boolean,
   :searchable boolean,
   :jsonSchema string,
   :dataType
   [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
    STRING_VALUE
    INT_VALUE
    DOUBLE_VALUE
    BOOLEAN_VALUE
    STRING_ARRAY
    INT_ARRAY
    DOUBLE_ARRAY
    BOOLEAN_ARRAY
    JSON_VALUE
    PROTO_VALUE
    PROTO_ARRAY],
   :defaultValue
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}},
   :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
   :masked boolean}],
 :cloudLoggingDetails
 {:enableCloudLogging boolean,
  :cloudLoggingSeverity
  [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
 :createTime string,
 :userLabel string,
 :state [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :lastModifierEmail string,
 :runAsServiceAccount string,
 :updateTime string,
 :taskConfigs
 [{:description string,
   :failurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :errorCatcherId string,
   :task string,
   :nextTasksExecutionPolicy
   [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
    RUN_ALL_MATCH
    RUN_FIRST_MATCH],
   :taskTemplate string,
   :displayName string,
   :nextTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :synchronousCallFailurePolicy
   {:intervalTime string,
    :retryStrategy
    [RETRY_STRATEGY_UNSPECIFIED
     IGNORE
     NONE
     FATAL
     FIXED_INTERVAL
     LINEAR_BACKOFF
     EXPONENTIAL_BACKOFF
     RESTART_INTEGRATION_WITH_BACKOFF],
    :condition string,
    :maxRetries integer},
   :jsonValidationOption
   [JSON_VALIDATION_OPTION_UNSPECIFIED
    SKIP
    PRE_EXECUTION
    POST_EXECUTION
    PRE_POST_EXECUTION],
   :position {:x integer, :y integer},
   :conditionalFailurePolicies
   {:failurePolicies
    [{:intervalTime string,
      :retryStrategy
      [RETRY_STRATEGY_UNSPECIFIED
       IGNORE
       NONE
       FATAL
       FIXED_INTERVAL
       LINEAR_BACKOFF
       EXPONENTIAL_BACKOFF
       RESTART_INTEGRATION_WITH_BACKOFF],
      :condition string,
      :maxRetries integer}],
    :defaultFailurePolicy
    {:intervalTime string,
     :retryStrategy
     [RETRY_STRATEGY_UNSPECIFIED
      IGNORE
      NONE
      FATAL
      FIXED_INTERVAL
      LINEAR_BACKOFF
      EXPONENTIAL_BACKOFF
      RESTART_INTEGRATION_WITH_BACKOFF],
     :condition string,
     :maxRetries integer}},
   :externalTaskType
   [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
   :taskId string,
   :parameters object,
   :taskExecutionStrategy
   [TASK_EXECUTION_STRATEGY_UNSPECIFIED
    WHEN_ALL_SUCCEED
    WHEN_ANY_SUCCEED
    WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
   :successPolicy
   {:finalState [FINAL_STATE_UNSPECIFIED SUCCEEDED SUSPENDED]}}],
 :errorCatcherConfigs
 [{:errorCatcherId string,
   :label string,
   :errorCatcherNumber string,
   :startErrorTasks
   [{:taskId string,
     :condition string,
     :description string,
     :taskConfigId string,
     :displayName string}],
   :description string,
   :position {:x integer, :y integer}}],
 :databasePersistencePolicy
 [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
  DATABASE_PERSISTENCE_DISABLED
  DATABASE_PERSISTENCE_ASYNC],
 :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
 :integrationConfigParameters
 [{:parameter
   {:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean},
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}}}],
 :snapshotNumber string,
 :origin
 [UNSPECIFIED
  UI
  PIPER_V2
  PIPER_V3
  APPLICATION_IP_PROVISIONING
  TEST_CASE],
 :enableVariableMasking boolean,
 :integrationParametersInternal
 {:parameters
  [{:description string,
    :containsLargeData boolean,
    :children
    [{:description string,
      :containsLargeData boolean,
      :children
      [{:description string,
        :containsLargeData boolean,
        :children
        [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry],
        :producer string,
        :key string,
        :protoDefName string,
        :name string,
        :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
        :isTransient boolean,
        :producedBy EnterpriseCrmEventbusProtoNodeIdentifier,
        :jsonSchema string,
        :protoDefPath string,
        :dataType
        [DATA_TYPE_UNSPECIFIED
         STRING_VALUE
         INT_VALUE
         DOUBLE_VALUE
         BOOLEAN_VALUE
         PROTO_VALUE
         SERIALIZED_OBJECT_VALUE
         STRING_ARRAY
         INT_ARRAY
         DOUBLE_ARRAY
         PROTO_ARRAY
         PROTO_ENUM
         BOOLEAN_ARRAY
         PROTO_ENUM_ARRAY
         BYTES
         BYTES_ARRAY
         NON_SERIALIZABLE_OBJECT
         JSON_VALUE],
        :defaultValue
        EnterpriseCrmFrontendsEventbusProtoParameterValueType,
        :attributes EnterpriseCrmEventbusProtoAttributes,
        :required boolean}],
      :producer string,
      :key string,
      :protoDefName string,
      :name string,
      :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :isTransient boolean,
      :producedBy
      {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
       :elementIdentifier string},
      :jsonSchema string,
      :protoDefPath string,
      :dataType
      [DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       PROTO_VALUE
       SERIALIZED_OBJECT_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       PROTO_ARRAY
       PROTO_ENUM
       BOOLEAN_ARRAY
       PROTO_ENUM_ARRAY
       BYTES
       BYTES_ARRAY
       NON_SERIALIZABLE_OBJECT
       JSON_VALUE],
      :defaultValue
      {:intValue string,
       :stringArray
       EnterpriseCrmFrontendsEventbusProtoStringParameterArray,
       :serializedObjectValue
       EnterpriseCrmFrontendsEventbusProtoSerializedObjectParameter,
       :booleanValue boolean,
       :stringValue string,
       :jsonValue string,
       :intArray EnterpriseCrmFrontendsEventbusProtoIntParameterArray,
       :doubleArray
       EnterpriseCrmFrontendsEventbusProtoDoubleParameterArray,
       :doubleValue number,
       :booleanArray
       EnterpriseCrmFrontendsEventbusProtoBooleanParameterArray,
       :protoArray
       EnterpriseCrmFrontendsEventbusProtoProtoParameterArray,
       :protoValue object},
      :attributes
      {:logSettings EnterpriseCrmEventbusProtoLogSettings,
       :isSearchable boolean,
       :searchable [UNSPECIFIED YES NO],
       :readOnly boolean,
       :dataType
       [DATA_TYPE_UNSPECIFIED
        EMAIL
        URL
        CURRENCY
        TIMESTAMP
        DOMAIN_NAME],
       :taskVisibility [string],
       :isRequired boolean,
       :defaultValue EnterpriseCrmEventbusProtoValueType,
       :masked boolean},
      :required boolean}],
    :producer string,
    :key string,
    :protoDefName string,
    :name string,
    :inOutType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :isTransient boolean,
    :producedBy
    {:elementType [UNKNOWN_TYPE TASK_CONFIG TRIGGER_CONFIG],
     :elementIdentifier string},
    :jsonSchema string,
    :protoDefPath string,
    :dataType
    [DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     PROTO_VALUE
     SERIALIZED_OBJECT_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     PROTO_ARRAY
     PROTO_ENUM
     BOOLEAN_ARRAY
     PROTO_ENUM_ARRAY
     BYTES
     BYTES_ARRAY
     NON_SERIALIZABLE_OBJECT
     JSON_VALUE],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :serializedObjectValue {:objectValue string},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]},
     :protoArray {:protoValues [object]},
     :protoValue object},
    :attributes
    {:logSettings
     {:logFieldName string,
      :shorteningLimits EnterpriseCrmLoggingGwsFieldLimits,
      :seedPeriod [SEED_PERIOD_UNSPECIFIED DAY WEEK MONTH],
      :seedScope
      [SEED_SCOPE_UNSPECIFIED EVENT_NAME TIME_PERIOD PARAM_NAME],
      :sanitizeOptions EnterpriseCrmLoggingGwsSanitizeOptions},
     :isSearchable boolean,
     :searchable [UNSPECIFIED YES NO],
     :readOnly boolean,
     :dataType
     [DATA_TYPE_UNSPECIFIED EMAIL URL CURRENCY TIMESTAMP DOMAIN_NAME],
     :taskVisibility [string],
     :isRequired boolean,
     :defaultValue
     {:doubleValue number,
      :protoValue object,
      :intValue string,
      :booleanValue boolean,
      :intArray EnterpriseCrmEventbusProtoIntArray,
      :stringArray EnterpriseCrmEventbusProtoStringArray,
      :doubleArray EnterpriseCrmEventbusProtoDoubleArray,
      :stringValue string},
     :masked boolean},
    :required boolean}]},
 :teardown
 {:teardownTaskConfigs
  [{:properties
    {:properties
     [{:value EnterpriseCrmEventbusProtoValueType, :key string}]},
    :nextTeardownTask {:name string},
    :name string,
    :parameters
    {:parameters
     [{:value EnterpriseCrmEventbusProtoParameterValueType,
       :masked boolean,
       :key string}]},
    :teardownTaskImplementationClassName string,
    :creatorEmail string}]},
 :createdFromTemplate string,
 :lockHolder string,
 :parentTemplateId string}

optional:
newIntegration <boolean> Set this flag to true, if draft version is to be created for a brand new integration. False, if the request is for an existing integration. For backward compatibility reasons, even if this flag is set to `false` and no existing integration is found, a new draft integration will still be created.
createSampleIntegrations <boolean> Optional. Optional. Indicates if sample workflow should be created."
  ([parent GoogleCloudIntegrationsV1alphaIntegrationVersion]
    (projects-locations-products-integrations-versions-create
      parent
      GoogleCloudIntegrationsV1alphaIntegrationVersion
      nil))
  ([parent GoogleCloudIntegrationsV1alphaIntegrationVersion optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaIntegrationVersion})))

(defn projects-locations-products-integrations-versions-delete
  "Soft-deletes the integration. Changes the status of the integration to ARCHIVED. If the integration being ARCHIVED is tagged as \"HEAD\", the tag is removed from this snapshot and set to the previous non-ARCHIVED snapshot. The PUBLISH_REQUESTED, DUE_FOR_DELETION tags are removed too. This RPC throws an exception if the version being deleted is DRAFT, and if the `locked_by` user is not the same as the user performing the Delete. Audit fields updated include last_modified_timestamp, last_modified_by. Any existing lock is released when Deleting a integration. Currently, there is no undelete mechanism.
https://cloud.google.com/application-integration

name <string> Required. The version to delete. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-integrations-versions-list
  "Returns the list of all integration versions in the specified project.
https://cloud.google.com/application-integration

parent <string> Required. The parent resource where this version will be created. Format: projects/{project}/locations/{location}/integrations/{integration} Specifically, when parent equals: 1. projects//locations//integrations/, Meaning: \"List versions (with filter) for a particular integration\". 2. projects//locations//integrations/- Meaning: \"List versions (with filter) for a client within a particular region\". 3. projects//locations/-/integrations/- Meaning: \"List versions (with filter) for a client\".

optional:
fieldMask <string> The field mask which specifies the particular data to be returned.
filter <string> Filter on fields of IntegrationVersion. Fields can be compared with literal values by use of \":\" (containment), \"=\" (equality), \">\" (greater), \"<\" (less than), >=\" (greater than or equal to), \"<=\" (less than or equal to), and \"!=\" (inequality) operators. Negation, conjunction, and disjunction are written using NOT, AND, and OR keywords. For example, organization_id=\\\"1\\\" AND state=ACTIVE AND description:\"test\". Filtering cannot be performed on repeated fields like `task_config`.
orderBy <string> The results would be returned in order you specified here. Currently supported sort keys are: Descending sort order for \"last_modified_time\", \"created_time\", \"snapshot_number\" Ascending sort order for \"name\".
pageSize <integer> The maximum number of versions to return. The service may return fewer than this value. If unspecified, at most 50 versions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-locations-products-integrations-versions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-integrations-versions-takeoverEditLock
  "Clears the `locked_by` and `locked_at_timestamp`in the DRAFT version of this integration. It then performs the same action as the CreateDraftIntegrationVersion (i.e., copies the DRAFT version of the integration as a SNAPSHOT and then creates a new DRAFT version with the `locked_by` set to the `user_taking_over` and the `locked_at_timestamp` set to the current timestamp). Both the `locked_by` and `user_taking_over` are notified via email about the takeover. This RPC throws an exception if the integration is not in DRAFT status or if the `locked_by` and `locked_at_timestamp` fields are not set.The TakeoverEdit lock is treated the same as an edit of the integration, and hence shares ACLs with edit. Audit fields updated include last_modified_timestamp, last_modified_by.
https://cloud.google.com/application-integration

integrationVersion <string> Required. The version to take over edit lock. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}
GoogleCloudIntegrationsV1alphaTakeoverEditLockRequest:
object"
  [integrationVersion
   GoogleCloudIntegrationsV1alphaTakeoverEditLockRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+integrationVersion}:takeoverEditLock",
     :uri-template-args {:integrationVersion integrationVersion},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaTakeoverEditLockRequest}))

(defn projects-locations-products-integrations-versions-download
  "Downloads an integration. Retrieves the `IntegrationVersion` for a given `integration_id` and returns the response as a string.
https://cloud.google.com/application-integration

name <string> Required. The version to download. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}

optional:
files <string> Optional. Integration related file to download like Integration Json, Config variable, testcase etc.
fileFormat <string> File format for download request."
  ([name]
    (projects-locations-products-integrations-versions-download
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+name}:download",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-integrations-versions-publish
  "This RPC throws an exception if the integration is in ARCHIVED or ACTIVE state. This RPC throws an exception if the version being published is DRAFT, and if the `locked_by` user is not the same as the user performing the Publish. Audit fields updated include last_published_timestamp, last_published_by, last_modified_timestamp, last_modified_by. Any existing lock is on this integration is released.
https://cloud.google.com/application-integration

name <string> Required. The version to publish. Format: projects/{project}/locations/{location}/integrations/{integration}/versions/{version}
GoogleCloudIntegrationsV1alphaPublishIntegrationVersionRequest:
{:configParameters object}"
  [name GoogleCloudIntegrationsV1alphaPublishIntegrationVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:publish",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudIntegrationsV1alphaPublishIntegrationVersionRequest}))

(defn projects-locations-products-integrations-versions-upload
  "Uploads an integration. The content can be a previously downloaded integration. Performs the same function as CreateDraftIntegrationVersion, but accepts input in a string format, which holds the complete representation of the IntegrationVersion content.
https://cloud.google.com/application-integration

parent <string> Required. The version to upload. Format: projects/{project}/locations/{location}/integrations/{integration}
GoogleCloudIntegrationsV1alphaUploadIntegrationVersionRequest:
{:fileFormat [FILE_FORMAT_UNSPECIFIED JSON YAML], :content string}"
  [parent
   GoogleCloudIntegrationsV1alphaUploadIntegrationVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/versions:upload",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudIntegrationsV1alphaUploadIntegrationVersionRequest}))

(defn projects-locations-products-certificates-get
  "Get a certificates in the specified project.
https://cloud.google.com/application-integration

name <string> Required. The certificate to retrieve. Format: projects/{project}/locations/{location}/certificates/{certificate}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-certificates-delete
  "Delete a certificate
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the Certificate."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-products-certificates-list
  "List all the certificates that match the filter. Restrict to certificate of current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of Certificates.

optional:
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100.
readMask <string> The mask which specifies fields that need to be returned in the Certificate's response.
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters."
  ([parent] (projects-locations-products-certificates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/certificates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-products-certificates-create
  "Creates a new certificate. The certificate will be registered to the trawler service and will be encrypted using cloud KMS and stored in Spanner Returns the certificate.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaCertificate:
{:description string,
 :credentialId string,
 :displayName string,
 :requestorId string,
 :name string,
 :rawCertificate
 {:passphrase string,
  :encryptedPrivateKey string,
  :sslCertificate string},
 :validEndTime string,
 :validStartTime string,
 :certificateStatus [STATE_UNSPECIFIED ACTIVE EXPIRED]}"
  [parent GoogleCloudIntegrationsV1alphaCertificate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/certificates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaCertificate}))

(defn projects-locations-products-certificates-patch
  "Updates the certificate by id. If new certificate file is updated, it will register with the trawler service, re-encrypt with cloud KMS and update the Spanner record. Other fields will directly update the Spanner record. Returns the Certificate.
https://cloud.google.com/application-integration

name <string> Output only. Auto generated primary key
GoogleCloudIntegrationsV1alphaCertificate:
{:description string,
 :credentialId string,
 :displayName string,
 :requestorId string,
 :name string,
 :rawCertificate
 {:passphrase string,
  :encryptedPrivateKey string,
  :sslCertificate string},
 :validEndTime string,
 :validStartTime string,
 :certificateStatus [STATE_UNSPECIFIED ACTIVE EXPIRED]}

optional:
updateMask <string> Field mask specifying the fields in the above Certificate that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaCertificate]
    (projects-locations-products-certificates-patch
      name
      GoogleCloudIntegrationsV1alphaCertificate
      nil))
  ([name GoogleCloudIntegrationsV1alphaCertificate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaCertificate})))

(defn projects-locations-clients-switch
  "Update client from GMEK to CMEK
https://cloud.google.com/application-integration

parent <string> Required. Required: The ID of the GCP Project to be provisioned.
GoogleCloudIntegrationsV1alphaSwitchEncryptionRequest:
{:cloudKmsConfig
 {:key string,
  :kmsProjectId string,
  :keyVersion string,
  :kmsLocation string,
  :kmsRing string}}"
  [parent GoogleCloudIntegrationsV1alphaSwitchEncryptionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/clients:switch",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaSwitchEncryptionRequest}))

(defn projects-locations-clients-provision
  "Perform the provisioning steps to enable a user GCP project to use IP. If GCP project already registered on IP end via Apigee Integration, provisioning will fail.
https://cloud.google.com/application-integration

parent <string> Required. Required: The ID of the GCP Project to be provisioned.
GoogleCloudIntegrationsV1alphaProvisionClientRequest:
{:skipCpProvision boolean,
 :createSampleWorkflows boolean,
 :provisionGmek boolean,
 :cloudKmsConfig
 {:key string,
  :kmsProjectId string,
  :keyVersion string,
  :kmsLocation string,
  :kmsRing string},
 :runAsServiceAccount string}"
  [parent GoogleCloudIntegrationsV1alphaProvisionClientRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/clients:provision",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaProvisionClientRequest}))

(defn projects-locations-clients-replace
  "Update run-as service account for provisioned client
https://cloud.google.com/application-integration

parent <string> Required. Required: The ID of the GCP Project to be provisioned.
GoogleCloudIntegrationsV1alphaReplaceServiceAccountRequest:
{:runAsServiceAccount string}"
  [parent GoogleCloudIntegrationsV1alphaReplaceServiceAccountRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/clients:replace",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaReplaceServiceAccountRequest}))

(defn projects-locations-clients-deprovision
  "Perform the deprovisioning steps to disable a user GCP project to use IP and purge all related data in a wipeout-compliant way.
https://cloud.google.com/application-integration

parent <string> Required. Required: The ID of the GCP Project to be deprovisioned.
GoogleCloudIntegrationsV1alphaDeprovisionClientRequest:
object"
  [parent GoogleCloudIntegrationsV1alphaDeprovisionClientRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/clients:deprovision",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaDeprovisionClientRequest}))

(defn projects-locations-clients-switchVariableMasking
  "Update variable masking for provisioned client
https://cloud.google.com/application-integration

parent <string> Required. Required: The ID of the GCP Project to be provisioned.
GoogleCloudIntegrationsV1alphaSwitchVariableMaskingRequest:
{:enableVariableMasking boolean}"
  [parent GoogleCloudIntegrationsV1alphaSwitchVariableMaskingRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/clients:switchVariableMasking",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaSwitchVariableMaskingRequest}))

(defn projects-locations-sfdcInstances-delete
  "Deletes an sfdc instance.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcInstance."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sfdcInstances-create
  "Creates an sfdc instance record. Store the sfdc instance in Spanner. Returns the sfdc instance.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaSfdcInstance:
{:description string,
 :deleteTime string,
 :displayName string,
 :name string,
 :authConfigId [string],
 :createTime string,
 :serviceAuthority string,
 :updateTime string,
 :sfdcOrgId string}"
  [parent GoogleCloudIntegrationsV1alphaSfdcInstance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/sfdcInstances",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaSfdcInstance}))

(defn projects-locations-sfdcInstances-get
  "Gets an sfdc instance. If the instance doesn't exist, Code.NOT_FOUND exception will be thrown.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcInstance."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sfdcInstances-patch
  "Updates an sfdc instance. Updates the sfdc instance in spanner. Returns the sfdc instance.
https://cloud.google.com/application-integration

name <string> Resource name of the SFDC instance projects/{project}/locations/{location}/sfdcInstances/{sfdcInstance}.
GoogleCloudIntegrationsV1alphaSfdcInstance:
{:description string,
 :deleteTime string,
 :displayName string,
 :name string,
 :authConfigId [string],
 :createTime string,
 :serviceAuthority string,
 :updateTime string,
 :sfdcOrgId string}

optional:
updateMask <string> Field mask specifying the fields in the above SfdcInstance that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaSfdcInstance]
    (projects-locations-sfdcInstances-patch
      name
      GoogleCloudIntegrationsV1alphaSfdcInstance
      nil))
  ([name GoogleCloudIntegrationsV1alphaSfdcInstance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaSfdcInstance})))

(defn projects-locations-sfdcInstances-list
  "Lists all sfdc instances that match the filter. Restrict to sfdc instances belonging to the current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of SfdcInstances.

optional:
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters.
readMask <string> The mask which specifies fields that need to be returned in the SfdcInstance's response.
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100."
  ([parent] (projects-locations-sfdcInstances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/sfdcInstances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sfdcInstances-sfdcChannels-delete
  "Deletes an sfdc channel.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcChannel."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sfdcInstances-sfdcChannels-patch
  "Updates an sfdc channel. Updates the sfdc channel in spanner. Returns the sfdc channel.
https://cloud.google.com/application-integration

name <string> Resource name of the SFDC channel projects/{project}/locations/{location}/sfdcInstances/{sfdc_instance}/sfdcChannels/{sfdc_channel}.
GoogleCloudIntegrationsV1alphaSfdcChannel:
{:description string,
 :lastReplayId string,
 :deleteTime string,
 :displayName string,
 :name string,
 :channelTopic string,
 :createTime string,
 :updateTime string,
 :isActive boolean}

optional:
updateMask <string> Field mask specifying the fields in the above SfdcChannel that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaSfdcChannel]
    (projects-locations-sfdcInstances-sfdcChannels-patch
      name
      GoogleCloudIntegrationsV1alphaSfdcChannel
      nil))
  ([name GoogleCloudIntegrationsV1alphaSfdcChannel optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaSfdcChannel})))

(defn projects-locations-sfdcInstances-sfdcChannels-list
  "Lists all sfdc channels that match the filter. Restrict to sfdc channels belonging to the current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of SfdcChannels.

optional:
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters.
readMask <string> The mask which specifies fields that need to be returned in the SfdcChannel's response.
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100."
  ([parent]
    (projects-locations-sfdcInstances-sfdcChannels-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/sfdcChannels",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-sfdcInstances-sfdcChannels-get
  "Gets an sfdc channel. If the channel doesn't exist, Code.NOT_FOUND exception will be thrown.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the SfdcChannel."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-sfdcInstances-sfdcChannels-create
  "Creates an sfdc channel record. Store the sfdc channel in Spanner. Returns the sfdc channel.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaSfdcChannel:
{:description string,
 :lastReplayId string,
 :deleteTime string,
 :displayName string,
 :name string,
 :channelTopic string,
 :createTime string,
 :updateTime string,
 :isActive boolean}"
  [parent GoogleCloudIntegrationsV1alphaSfdcChannel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/sfdcChannels",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaSfdcChannel}))

(defn projects-locations-certificates-patch
  "Updates the certificate by id. If new certificate file is updated, it will register with the trawler service, re-encrypt with cloud KMS and update the Spanner record. Other fields will directly update the Spanner record. Returns the Certificate.
https://cloud.google.com/application-integration

name <string> Output only. Auto generated primary key
GoogleCloudIntegrationsV1alphaCertificate:
{:description string,
 :credentialId string,
 :displayName string,
 :requestorId string,
 :name string,
 :rawCertificate
 {:passphrase string,
  :encryptedPrivateKey string,
  :sslCertificate string},
 :validEndTime string,
 :validStartTime string,
 :certificateStatus [STATE_UNSPECIFIED ACTIVE EXPIRED]}

optional:
updateMask <string> Field mask specifying the fields in the above Certificate that have been modified and need to be updated."
  ([name GoogleCloudIntegrationsV1alphaCertificate]
    (projects-locations-certificates-patch
      name
      GoogleCloudIntegrationsV1alphaCertificate
      nil))
  ([name GoogleCloudIntegrationsV1alphaCertificate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaCertificate})))

(defn projects-locations-certificates-delete
  "Delete a certificate
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the Certificate."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-certificates-list
  "List all the certificates that match the filter. Restrict to certificate of current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of Certificates.

optional:
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100.
readMask <string> The mask which specifies fields that need to be returned in the Certificate's response.
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters."
  ([parent] (projects-locations-certificates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/certificates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-certificates-create
  "Creates a new certificate. The certificate will be registered to the trawler service and will be encrypted using cloud KMS and stored in Spanner Returns the certificate.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaCertificate:
{:description string,
 :credentialId string,
 :displayName string,
 :requestorId string,
 :name string,
 :rawCertificate
 {:passphrase string,
  :encryptedPrivateKey string,
  :sslCertificate string},
 :validEndTime string,
 :validStartTime string,
 :certificateStatus [STATE_UNSPECIFIED ACTIVE EXPIRED]}"
  [parent GoogleCloudIntegrationsV1alphaCertificate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/certificates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaCertificate}))

(defn projects-locations-certificates-get
  "Get a certificates in the specified project.
https://cloud.google.com/application-integration

name <string> Required. The certificate to retrieve. Format: projects/{project}/locations/{location}/certificates/{certificate}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-authConfigs-get
  "Gets a complete auth config. If the auth config doesn't exist, Code.NOT_FOUND exception will be thrown. Returns the decrypted auth config.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the AuthConfig."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-authConfigs-delete
  "Deletes an auth config.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the AuthConfig."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-authConfigs-patch
  "Updates an auth config. If credential is updated, fetch the encrypted auth config from Spanner, decrypt with Cloud KMS key, update the credential fields, re-encrypt with Cloud KMS key and update the Spanner record. For other fields, directly update the Spanner record. Returns the encrypted auth config.
https://cloud.google.com/application-integration

name <string> Resource name of the auth config. For more information, see Manage authentication profiles. projects/{project}/locations/{location}/authConfigs/{authConfig}.
GoogleCloudIntegrationsV1alphaAuthConfig:
{:decryptedCredential
 {:oauth2ClientCredentials
  {:requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :clientId string,
   :clientSecret string,
   :tokenEndpoint string,
   :scope string},
  :authToken {:type string, :token string},
  :credentialType
  [CREDENTIAL_TYPE_UNSPECIFIED
   USERNAME_AND_PASSWORD
   API_KEY
   OAUTH2_AUTHORIZATION_CODE
   OAUTH2_IMPLICIT
   OAUTH2_CLIENT_CREDENTIALS
   OAUTH2_RESOURCE_OWNER_CREDENTIALS
   JWT
   AUTH_TOKEN
   SERVICE_ACCOUNT
   CLIENT_CERTIFICATE_ONLY
   OIDC_TOKEN],
  :usernameAndPassword {:password string, :username string},
  :jwt
  {:secret string, :jwtPayload string, :jwtHeader string, :jwt string},
  :serviceAccountCredentials {:serviceAccount string, :scope string},
  :oauth2AuthorizationCode
  {:clientId string,
   :tokenEndpoint string,
   :authEndpoint string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :applyReauthPolicy boolean,
   :authParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :authCode string,
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oauth2ResourceOwnerCredentials
  {:clientId string,
   :tokenEndpoint string,
   :password string,
   :username string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oidcToken
  {:serviceAccountEmail string,
   :audience string,
   :token string,
   :tokenExpireTime string}},
 :description string,
 :encryptedCredential string,
 :overrideValidTime string,
 :displayName string,
 :name string,
 :credentialType
 [CREDENTIAL_TYPE_UNSPECIFIED
  USERNAME_AND_PASSWORD
  API_KEY
  OAUTH2_AUTHORIZATION_CODE
  OAUTH2_IMPLICIT
  OAUTH2_CLIENT_CREDENTIALS
  OAUTH2_RESOURCE_OWNER_CREDENTIALS
  JWT
  AUTH_TOKEN
  SERVICE_ACCOUNT
  CLIENT_CERTIFICATE_ONLY
  OIDC_TOKEN],
 :expiryNotificationDuration [string],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  VALID
  INVALID
  SOFT_DELETED
  EXPIRED
  UNAUTHORIZED
  UNSUPPORTED],
 :lastModifierEmail string,
 :updateTime string,
 :reason string,
 :certificateId string,
 :creatorEmail string,
 :validTime string,
 :visibility
 [AUTH_CONFIG_VISIBILITY_UNSPECIFIED PRIVATE CLIENT_VISIBLE]}

optional:
clientCertificate.sslCertificate <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----
clientCertificate.encryptedPrivateKey <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----
updateMask <string> Field mask specifying the fields in the above AuthConfig that have been modified and need to be updated.
clientCertificate.passphrase <string> 'passphrase' should be left unset if private key is not encrypted. Note that 'passphrase' is not the password for web server, but an extra layer of security to protected private key."
  ([name GoogleCloudIntegrationsV1alphaAuthConfig]
    (projects-locations-authConfigs-patch
      name
      GoogleCloudIntegrationsV1alphaAuthConfig
      nil))
  ([name GoogleCloudIntegrationsV1alphaAuthConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaAuthConfig})))

(defn projects-locations-authConfigs-list
  "Lists all auth configs that match the filter. Restrict to auth configs belong to the current client only.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of AuthConfigs.

optional:
filter <string> Filtering as supported in https://developers.google.com/authorized-buyers/apis/guides/list-filters.
pageSize <integer> The size of entries in the response. If unspecified, defaults to 100.
readMask <string> The mask which specifies fields that need to be returned in the AuthConfig's response."
  ([parent] (projects-locations-authConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/authConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-authConfigs-create
  "Creates an auth config record. Fetch corresponding credentials for specific auth types, e.g. access token for OAuth 2.0, JWT token for JWT. Encrypt the auth config with Cloud KMS and store the encrypted credentials in Spanner. Returns the encrypted auth config.
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaAuthConfig:
{:decryptedCredential
 {:oauth2ClientCredentials
  {:requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :clientId string,
   :clientSecret string,
   :tokenEndpoint string,
   :scope string},
  :authToken {:type string, :token string},
  :credentialType
  [CREDENTIAL_TYPE_UNSPECIFIED
   USERNAME_AND_PASSWORD
   API_KEY
   OAUTH2_AUTHORIZATION_CODE
   OAUTH2_IMPLICIT
   OAUTH2_CLIENT_CREDENTIALS
   OAUTH2_RESOURCE_OWNER_CREDENTIALS
   JWT
   AUTH_TOKEN
   SERVICE_ACCOUNT
   CLIENT_CERTIFICATE_ONLY
   OIDC_TOKEN],
  :usernameAndPassword {:password string, :username string},
  :jwt
  {:secret string, :jwtPayload string, :jwtHeader string, :jwt string},
  :serviceAccountCredentials {:serviceAccount string, :scope string},
  :oauth2AuthorizationCode
  {:clientId string,
   :tokenEndpoint string,
   :authEndpoint string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :applyReauthPolicy boolean,
   :authParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :authCode string,
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oauth2ResourceOwnerCredentials
  {:clientId string,
   :tokenEndpoint string,
   :password string,
   :username string,
   :scope string,
   :accessToken
   {:refreshToken string,
    :accessTokenExpireTime string,
    :accessToken string,
    :refreshTokenExpireTime string,
    :tokenType string},
   :requestType
   [REQUEST_TYPE_UNSPECIFIED
    REQUEST_BODY
    QUERY_PARAMETERS
    ENCODED_HEADER],
   :tokenParams
   {:valueType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :keyType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :entries
    [{:value GoogleCloudIntegrationsV1alphaParameterMapField,
      :key GoogleCloudIntegrationsV1alphaParameterMapField}]},
   :clientSecret string},
  :oidcToken
  {:serviceAccountEmail string,
   :audience string,
   :token string,
   :tokenExpireTime string}},
 :description string,
 :encryptedCredential string,
 :overrideValidTime string,
 :displayName string,
 :name string,
 :credentialType
 [CREDENTIAL_TYPE_UNSPECIFIED
  USERNAME_AND_PASSWORD
  API_KEY
  OAUTH2_AUTHORIZATION_CODE
  OAUTH2_IMPLICIT
  OAUTH2_CLIENT_CREDENTIALS
  OAUTH2_RESOURCE_OWNER_CREDENTIALS
  JWT
  AUTH_TOKEN
  SERVICE_ACCOUNT
  CLIENT_CERTIFICATE_ONLY
  OIDC_TOKEN],
 :expiryNotificationDuration [string],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  VALID
  INVALID
  SOFT_DELETED
  EXPIRED
  UNAUTHORIZED
  UNSUPPORTED],
 :lastModifierEmail string,
 :updateTime string,
 :reason string,
 :certificateId string,
 :creatorEmail string,
 :validTime string,
 :visibility
 [AUTH_CONFIG_VISIBILITY_UNSPECIFIED PRIVATE CLIENT_VISIBLE]}

optional:
clientCertificate.sslCertificate <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----
clientCertificate.encryptedPrivateKey <string> The ssl certificate encoded in PEM format. This string must include the begin header and end footer lines. For example, -----BEGIN CERTIFICATE----- MIICTTCCAbagAwIBAgIJAPT0tSKNxan/MA0GCSqGSIb3DQEBCwUAMCoxFzAVBgNV BAoTDkdvb2dsZSBURVNUSU5HMQ8wDQYDVQQDEwZ0ZXN0Q0EwHhcNMTUwMTAxMDAw MDAwWhcNMjUwMTAxMDAwMDAwWjAuMRcwFQYDVQQKEw5Hb29nbGUgVEVTVElORzET MBEGA1UEAwwKam9lQGJhbmFuYTCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA vDYFgMgxi5W488d9J7UpCInl0NXmZQpJDEHE4hvkaRlH7pnC71H0DLt0/3zATRP1 JzY2+eqBmbGl4/sgZKYv8UrLnNyQNUTsNx1iZAfPUflf5FwgVsai8BM0pUciq1NB xD429VFcrGZNucvFLh72RuRFIKH8WUpiK/iZNFkWhZ0CAwEAAaN3MHUwDgYDVR0P AQH/BAQDAgWgMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAMBgNVHRMB Af8EAjAAMBkGA1UdDgQSBBCVgnFBCWgL/iwCqnGrhTPQMBsGA1UdIwQUMBKAEKey Um2o4k2WiEVA0ldQvNYwDQYJKoZIhvcNAQELBQADgYEAYK986R4E3L1v+Q6esBtW JrUwA9UmJRSQr0N5w3o9XzarU37/bkjOP0Fw0k/A6Vv1n3vlciYfBFaBIam1qRHr 5dMsYf4CZS6w50r7hyzqyrwDoyNxkLnd2PdcHT/sym1QmflsjEs7pejtnohO6N2H wQW6M0H7Zt8claGRla4fKkg= -----END CERTIFICATE-----
clientCertificate.passphrase <string> 'passphrase' should be left unset if private key is not encrypted. Note that 'passphrase' is not the password for web server, but an extra layer of security to protected private key."
  ([parent GoogleCloudIntegrationsV1alphaAuthConfig]
    (projects-locations-authConfigs-create
      parent
      GoogleCloudIntegrationsV1alphaAuthConfig
      nil))
  ([parent GoogleCloudIntegrationsV1alphaAuthConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/authConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaAuthConfig})))

(defn projects-locations-appsScriptProjects-create
  "Creates an Apps Script project.
https://cloud.google.com/application-integration

parent <string> Required. The project that the executed integration belongs to.
GoogleCloudIntegrationsV1alphaCreateAppsScriptProjectRequest:
{:authConfigId string, :appsScriptProject string}"
  [parent GoogleCloudIntegrationsV1alphaCreateAppsScriptProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/appsScriptProjects",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudIntegrationsV1alphaCreateAppsScriptProjectRequest}))

(defn projects-locations-appsScriptProjects-link
  "Links a existing Apps Script project.
https://cloud.google.com/application-integration

parent <string> Required. The project that the executed integration belongs to.
GoogleCloudIntegrationsV1alphaLinkAppsScriptProjectRequest:
{:scriptId string}"
  [parent GoogleCloudIntegrationsV1alphaLinkAppsScriptProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/appsScriptProjects:link",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaLinkAppsScriptProjectRequest}))

(defn projects-locations-connections-list
  "Lists Connections in a given project and location.
https://cloud.google.com/application-integration

parent <string> Required. Parent resource of the Connection, of the form: `projects/*/locations/*`

optional:
orderBy <string> Order by parameters.
pageSize <integer> Page size.
filter <string> Filter."
  ([parent] (projects-locations-connections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/connections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-getConnectionSchemaMetadata
  "Lists the available entities and actions associated with a Connection.
https://cloud.google.com/application-integration

name <string> Required. ConnectionSchemaMetadata name. Format: projects/{project}/locations/{location}/connections/{connection}/connectionSchemaMetadata"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connections-runtimeEntitySchemas-list
  "Lists the JSON schemas for the properties of runtime entities, filtered by entity name.
https://cloud.google.com/application-integration

parent <string> Required. Parent resource of RuntimeEntitySchema. Format: projects/{project}/locations/{location}/connections/{connection}

optional:
pageSize <integer> Page size.
filter <string> Filter. Only the entity field with literal equality operator is supported."
  ([parent]
    (projects-locations-connections-runtimeEntitySchemas-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/runtimeEntitySchemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-runtimeActionSchemas-list
  "Lists the JSON schemas for the inputs and outputs of actions, filtered by action name.
https://cloud.google.com/application-integration

parent <string> Required. Parent resource of RuntimeActionSchema. Format: projects/{project}/locations/{location}/connections/{connection}

optional:
filter <string> Filter. Only the action field with literal equality operator is supported.
pageSize <integer> Page size."
  ([parent]
    (projects-locations-connections-runtimeActionSchemas-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/runtimeActionSchemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-templates-get
  "Get a template in the specified project.
https://cloud.google.com/application-integration

name <string> Required. The template to retrieve. Format: projects/{project}/locations/{location}/templates/{template}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-templates-patch
  "Updates the template by given id.
https://cloud.google.com/application-integration

name <string> Identifier. Resource name of the template.
GoogleCloudIntegrationsV1alphaTemplate:
{:description string,
 :clientId string,
 :tags [string],
 :sharedWith [string],
 :displayName string,
 :name string,
 :createTime string,
 :docLink string,
 :usageCount string,
 :updateTime string,
 :author string,
 :categories
 [[CATEGORY_UNSPECIFIED
   AI_MACHINE_LEARNING
   BUSINESS_INTELLIGENCE_
   COLLABORATION
   CUSTOMER_SERVICE
   DATABASES
   DEVELOPER
   DEVOPS_IT
   CONTENT_AND_FILES
   FINANCE_AND_ACCOUNTING
   HUMAN_RESOURCES
   OPERATIONS
   PRODUCT_PROJECT_MANAGEMENT
   PRODUCTIVITY
   SALES_AND_MARKETING
   UNIVERSAL_CONNECTORS
   UTILITY
   OTHERS]],
 :components
 [{:type [TYPE_UNSPECIFIED TRIGGER TASK CONNECTOR], :name string}],
 :lastUsedTime string,
 :templateBundle
 {:subIntegrationVersionTemplates
  [{:configParameters
    [{:parameter
      {:containsLargeData boolean,
       :producer string,
       :key string,
       :displayName string,
       :isTransient boolean,
       :searchable boolean,
       :jsonSchema string,
       :dataType
       [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        BOOLEAN_ARRAY
        JSON_VALUE
        PROTO_VALUE
        PROTO_ARRAY],
       :defaultValue GoogleCloudIntegrationsV1alphaValueType,
       :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
       :masked boolean},
      :value
      {:intValue string,
       :stringArray GoogleCloudIntegrationsV1alphaStringParameterArray,
       :booleanValue boolean,
       :stringValue string,
       :jsonValue string,
       :intArray GoogleCloudIntegrationsV1alphaIntParameterArray,
       :doubleArray GoogleCloudIntegrationsV1alphaDoubleParameterArray,
       :doubleValue number,
       :booleanArray
       GoogleCloudIntegrationsV1alphaBooleanParameterArray}}],
    :integrationVersion
    {:triggerConfigsInternal
     [{:description string,
       :properties object,
       :cloudSchedulerConfig
       EnterpriseCrmEventbusProtoCloudSchedulerConfig,
       :triggerId string,
       :errorCatcherId string,
       :nextTasksExecutionPolicy
       [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
       :startTasks [EnterpriseCrmEventbusProtoNextTask],
       :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
       :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
       :label string,
       :triggerType
       [UNKNOWN
        CLOUD_PUBSUB
        GOOPS
        SFDC_SYNC
        CRON
        API
        MANIFOLD_TRIGGER
        DATALAYER_DATA_CHANGE
        SFDC_CHANNEL
        CLOUD_PUBSUB_EXTERNAL
        SFDC_CDC_CHANNEL
        SFDC_PLATFORM_EVENTS_CHANNEL
        CLOUD_SCHEDULER
        INTEGRATION_CONNECTOR_TRIGGER
        PRIVATE_TRIGGER],
       :position EnterpriseCrmEventbusProtoCoordinate,
       :triggerName string,
       :enabledClients [string],
       :triggerNumber string,
       :pauseWorkflowExecutions boolean}],
     :description string,
     :taskConfigsInternal
     [{:description string,
       :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
       :errorCatcherId string,
       :nextTasksExecutionPolicy
       [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
       :disableStrictTypeValidation boolean,
       :taskSpec string,
       :incomingEdgeCount integer,
       :createTime string,
       :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
       :preconditionLabel string,
       :rollbackStrategy
       EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
       :nextTasks [EnterpriseCrmEventbusProtoNextTask],
       :synchronousCallFailurePolicy
       EnterpriseCrmEventbusProtoFailurePolicy,
       :taskTemplateName string,
       :jsonValidationOption
       [UNSPECIFIED_JSON_VALIDATION_OPTION
        SKIP
        PRE_EXECUTION
        POST_EXECUTION
        PRE_POST_EXECUTION],
       :lastModifiedTime string,
       :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
       :label string,
       :position EnterpriseCrmEventbusProtoCoordinate,
       :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
       :conditionalFailurePolicies
       EnterpriseCrmEventbusProtoConditionalFailurePolicies,
       :externalTaskType
       [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
       :creatorEmail string,
       :taskName string,
       :parameters object,
       :taskNumber string,
       :taskExecutionStrategy
       [WHEN_ALL_SUCCEED
        WHEN_ANY_SUCCEED
        WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
       :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
       :precondition string}],
     :name string,
     :triggerConfigs
     [{:description string,
       :properties object,
       :cloudSchedulerConfig
       GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
       :triggerId string,
       :errorCatcherId string,
       :nextTasksExecutionPolicy
       [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
        RUN_ALL_MATCH
        RUN_FIRST_MATCH],
       :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
       :alertConfig
       [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
       :label string,
       :triggerType
       [TRIGGER_TYPE_UNSPECIFIED
        CRON
        API
        SFDC_CHANNEL
        CLOUD_PUBSUB_EXTERNAL
        SFDC_CDC_CHANNEL
        CLOUD_SCHEDULER
        INTEGRATION_CONNECTOR_TRIGGER
        PRIVATE_TRIGGER],
       :position GoogleCloudIntegrationsV1alphaCoordinate,
       :trigger string,
       :triggerNumber string}],
     :integrationParameters
     [{:containsLargeData boolean,
       :producer string,
       :key string,
       :displayName string,
       :isTransient boolean,
       :searchable boolean,
       :jsonSchema string,
       :dataType
       [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        BOOLEAN_ARRAY
        JSON_VALUE
        PROTO_VALUE
        PROTO_ARRAY],
       :defaultValue GoogleCloudIntegrationsV1alphaValueType,
       :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
       :masked boolean}],
     :cloudLoggingDetails
     {:enableCloudLogging boolean,
      :cloudLoggingSeverity
      [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
     :createTime string,
     :userLabel string,
     :state
     [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
     :lastModifierEmail string,
     :runAsServiceAccount string,
     :updateTime string,
     :taskConfigs
     [{:description string,
       :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
       :errorCatcherId string,
       :task string,
       :nextTasksExecutionPolicy
       [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
        RUN_ALL_MATCH
        RUN_FIRST_MATCH],
       :taskTemplate string,
       :displayName string,
       :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
       :synchronousCallFailurePolicy
       GoogleCloudIntegrationsV1alphaFailurePolicy,
       :jsonValidationOption
       [JSON_VALIDATION_OPTION_UNSPECIFIED
        SKIP
        PRE_EXECUTION
        POST_EXECUTION
        PRE_POST_EXECUTION],
       :position GoogleCloudIntegrationsV1alphaCoordinate,
       :conditionalFailurePolicies
       GoogleCloudIntegrationsV1alphaConditionalFailurePolicies,
       :externalTaskType
       [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
       :taskId string,
       :parameters object,
       :taskExecutionStrategy
       [TASK_EXECUTION_STRATEGY_UNSPECIFIED
        WHEN_ALL_SUCCEED
        WHEN_ANY_SUCCEED
        WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
       :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
     :errorCatcherConfigs
     [{:errorCatcherId string,
       :label string,
       :errorCatcherNumber string,
       :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
       :description string,
       :position GoogleCloudIntegrationsV1alphaCoordinate}],
     :databasePersistencePolicy
     [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
      DATABASE_PERSISTENCE_DISABLED
      DATABASE_PERSISTENCE_ASYNC],
     :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
     :integrationConfigParameters
     [{:parameter GoogleCloudIntegrationsV1alphaIntegrationParameter,
       :value GoogleCloudIntegrationsV1alphaValueType}],
     :snapshotNumber string,
     :origin
     [UNSPECIFIED
      UI
      PIPER_V2
      PIPER_V3
      APPLICATION_IP_PROVISIONING
      TEST_CASE],
     :enableVariableMasking boolean,
     :integrationParametersInternal
     {:parameters
      [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
     :teardown
     {:teardownTaskConfigs
      [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
     :createdFromTemplate string,
     :lockHolder string,
     :parentTemplateId string}}],
  :integrationVersionTemplate
  {:configParameters
   [{:parameter
     {:containsLargeData boolean,
      :producer string,
      :key string,
      :displayName string,
      :isTransient boolean,
      :searchable boolean,
      :jsonSchema string,
      :dataType
      [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       BOOLEAN_ARRAY
       JSON_VALUE
       PROTO_VALUE
       PROTO_ARRAY],
      :defaultValue GoogleCloudIntegrationsV1alphaValueType,
      :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :masked boolean},
     :value
     {:intValue string,
      :stringArray GoogleCloudIntegrationsV1alphaStringParameterArray,
      :booleanValue boolean,
      :stringValue string,
      :jsonValue string,
      :intArray GoogleCloudIntegrationsV1alphaIntParameterArray,
      :doubleArray GoogleCloudIntegrationsV1alphaDoubleParameterArray,
      :doubleValue number,
      :booleanArray
      GoogleCloudIntegrationsV1alphaBooleanParameterArray}}],
   :integrationVersion
   {:triggerConfigsInternal
    [{:description string,
      :properties object,
      :cloudSchedulerConfig
      EnterpriseCrmEventbusProtoCloudSchedulerConfig,
      :triggerId string,
      :errorCatcherId string,
      :nextTasksExecutionPolicy
      [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
      :startTasks [EnterpriseCrmEventbusProtoNextTask],
      :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
      :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
      :label string,
      :triggerType
      [UNKNOWN
       CLOUD_PUBSUB
       GOOPS
       SFDC_SYNC
       CRON
       API
       MANIFOLD_TRIGGER
       DATALAYER_DATA_CHANGE
       SFDC_CHANNEL
       CLOUD_PUBSUB_EXTERNAL
       SFDC_CDC_CHANNEL
       SFDC_PLATFORM_EVENTS_CHANNEL
       CLOUD_SCHEDULER
       INTEGRATION_CONNECTOR_TRIGGER
       PRIVATE_TRIGGER],
      :position EnterpriseCrmEventbusProtoCoordinate,
      :triggerName string,
      :enabledClients [string],
      :triggerNumber string,
      :pauseWorkflowExecutions boolean}],
    :description string,
    :taskConfigsInternal
    [{:description string,
      :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
      :errorCatcherId string,
      :nextTasksExecutionPolicy
      [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
      :disableStrictTypeValidation boolean,
      :taskSpec string,
      :incomingEdgeCount integer,
      :createTime string,
      :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
      :preconditionLabel string,
      :rollbackStrategy
      EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
      :nextTasks [EnterpriseCrmEventbusProtoNextTask],
      :synchronousCallFailurePolicy
      EnterpriseCrmEventbusProtoFailurePolicy,
      :taskTemplateName string,
      :jsonValidationOption
      [UNSPECIFIED_JSON_VALIDATION_OPTION
       SKIP
       PRE_EXECUTION
       POST_EXECUTION
       PRE_POST_EXECUTION],
      :lastModifiedTime string,
      :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
      :label string,
      :position EnterpriseCrmEventbusProtoCoordinate,
      :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
      :conditionalFailurePolicies
      EnterpriseCrmEventbusProtoConditionalFailurePolicies,
      :externalTaskType
      [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
      :creatorEmail string,
      :taskName string,
      :parameters object,
      :taskNumber string,
      :taskExecutionStrategy
      [WHEN_ALL_SUCCEED
       WHEN_ANY_SUCCEED
       WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
      :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
      :precondition string}],
    :name string,
    :triggerConfigs
    [{:description string,
      :properties object,
      :cloudSchedulerConfig
      GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
      :triggerId string,
      :errorCatcherId string,
      :nextTasksExecutionPolicy
      [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
       RUN_ALL_MATCH
       RUN_FIRST_MATCH],
      :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
      :alertConfig
      [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
      :label string,
      :triggerType
      [TRIGGER_TYPE_UNSPECIFIED
       CRON
       API
       SFDC_CHANNEL
       CLOUD_PUBSUB_EXTERNAL
       SFDC_CDC_CHANNEL
       CLOUD_SCHEDULER
       INTEGRATION_CONNECTOR_TRIGGER
       PRIVATE_TRIGGER],
      :position GoogleCloudIntegrationsV1alphaCoordinate,
      :trigger string,
      :triggerNumber string}],
    :integrationParameters
    [{:containsLargeData boolean,
      :producer string,
      :key string,
      :displayName string,
      :isTransient boolean,
      :searchable boolean,
      :jsonSchema string,
      :dataType
      [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       BOOLEAN_ARRAY
       JSON_VALUE
       PROTO_VALUE
       PROTO_ARRAY],
      :defaultValue GoogleCloudIntegrationsV1alphaValueType,
      :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :masked boolean}],
    :cloudLoggingDetails
    {:enableCloudLogging boolean,
     :cloudLoggingSeverity
     [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
    :createTime string,
    :userLabel string,
    :state
    [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
    :lastModifierEmail string,
    :runAsServiceAccount string,
    :updateTime string,
    :taskConfigs
    [{:description string,
      :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
      :errorCatcherId string,
      :task string,
      :nextTasksExecutionPolicy
      [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
       RUN_ALL_MATCH
       RUN_FIRST_MATCH],
      :taskTemplate string,
      :displayName string,
      :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
      :synchronousCallFailurePolicy
      GoogleCloudIntegrationsV1alphaFailurePolicy,
      :jsonValidationOption
      [JSON_VALIDATION_OPTION_UNSPECIFIED
       SKIP
       PRE_EXECUTION
       POST_EXECUTION
       PRE_POST_EXECUTION],
      :position GoogleCloudIntegrationsV1alphaCoordinate,
      :conditionalFailurePolicies
      GoogleCloudIntegrationsV1alphaConditionalFailurePolicies,
      :externalTaskType
      [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
      :taskId string,
      :parameters object,
      :taskExecutionStrategy
      [TASK_EXECUTION_STRATEGY_UNSPECIFIED
       WHEN_ALL_SUCCEED
       WHEN_ANY_SUCCEED
       WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
      :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
    :errorCatcherConfigs
    [{:errorCatcherId string,
      :label string,
      :errorCatcherNumber string,
      :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
      :description string,
      :position GoogleCloudIntegrationsV1alphaCoordinate}],
    :databasePersistencePolicy
    [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
     DATABASE_PERSISTENCE_DISABLED
     DATABASE_PERSISTENCE_ASYNC],
    :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
    :integrationConfigParameters
    [{:parameter GoogleCloudIntegrationsV1alphaIntegrationParameter,
      :value GoogleCloudIntegrationsV1alphaValueType}],
    :snapshotNumber string,
    :origin
    [UNSPECIFIED
     UI
     PIPER_V2
     PIPER_V3
     APPLICATION_IP_PROVISIONING
     TEST_CASE],
    :enableVariableMasking boolean,
    :integrationParametersInternal
    {:parameters
     [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
    :teardown
    {:teardownTaskConfigs
     [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
    :createdFromTemplate string,
    :lockHolder string,
    :parentTemplateId string}}},
 :usageInfo string,
 :visibility [VISIBILITY_UNSPECIFIED PRIVATE SHARED PUBLIC]}

optional:
updateMask <string> Required. Field mask specifying the fields in the above template that have been modified and must be updated."
  ([name GoogleCloudIntegrationsV1alphaTemplate]
    (projects-locations-templates-patch
      name
      GoogleCloudIntegrationsV1alphaTemplate
      nil))
  ([name GoogleCloudIntegrationsV1alphaTemplate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://integrations.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudIntegrationsV1alphaTemplate})))

(defn projects-locations-templates-use
  "Use the template to create integration. This api would keep track of usage_count and last_used_time. PERMISSION_DENIED would be thrown if template is not accessible by client.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the Template.
GoogleCloudIntegrationsV1alphaUseTemplateRequest:
{:integration string,
 :configParameters
 [{:parameter
   {:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean},
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}}}],
 :integrationDescription string}"
  [name GoogleCloudIntegrationsV1alphaUseTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:use",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaUseTemplateRequest}))

(defn projects-locations-templates-create
  "Creates a new template
https://cloud.google.com/application-integration

parent <string> Required. \"projects/{project}/locations/{location}\" format.
GoogleCloudIntegrationsV1alphaTemplate:
{:description string,
 :clientId string,
 :tags [string],
 :sharedWith [string],
 :displayName string,
 :name string,
 :createTime string,
 :docLink string,
 :usageCount string,
 :updateTime string,
 :author string,
 :categories
 [[CATEGORY_UNSPECIFIED
   AI_MACHINE_LEARNING
   BUSINESS_INTELLIGENCE_
   COLLABORATION
   CUSTOMER_SERVICE
   DATABASES
   DEVELOPER
   DEVOPS_IT
   CONTENT_AND_FILES
   FINANCE_AND_ACCOUNTING
   HUMAN_RESOURCES
   OPERATIONS
   PRODUCT_PROJECT_MANAGEMENT
   PRODUCTIVITY
   SALES_AND_MARKETING
   UNIVERSAL_CONNECTORS
   UTILITY
   OTHERS]],
 :components
 [{:type [TYPE_UNSPECIFIED TRIGGER TASK CONNECTOR], :name string}],
 :lastUsedTime string,
 :templateBundle
 {:subIntegrationVersionTemplates
  [{:configParameters
    [{:parameter
      {:containsLargeData boolean,
       :producer string,
       :key string,
       :displayName string,
       :isTransient boolean,
       :searchable boolean,
       :jsonSchema string,
       :dataType
       [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        BOOLEAN_ARRAY
        JSON_VALUE
        PROTO_VALUE
        PROTO_ARRAY],
       :defaultValue GoogleCloudIntegrationsV1alphaValueType,
       :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
       :masked boolean},
      :value
      {:intValue string,
       :stringArray GoogleCloudIntegrationsV1alphaStringParameterArray,
       :booleanValue boolean,
       :stringValue string,
       :jsonValue string,
       :intArray GoogleCloudIntegrationsV1alphaIntParameterArray,
       :doubleArray GoogleCloudIntegrationsV1alphaDoubleParameterArray,
       :doubleValue number,
       :booleanArray
       GoogleCloudIntegrationsV1alphaBooleanParameterArray}}],
    :integrationVersion
    {:triggerConfigsInternal
     [{:description string,
       :properties object,
       :cloudSchedulerConfig
       EnterpriseCrmEventbusProtoCloudSchedulerConfig,
       :triggerId string,
       :errorCatcherId string,
       :nextTasksExecutionPolicy
       [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
       :startTasks [EnterpriseCrmEventbusProtoNextTask],
       :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
       :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
       :label string,
       :triggerType
       [UNKNOWN
        CLOUD_PUBSUB
        GOOPS
        SFDC_SYNC
        CRON
        API
        MANIFOLD_TRIGGER
        DATALAYER_DATA_CHANGE
        SFDC_CHANNEL
        CLOUD_PUBSUB_EXTERNAL
        SFDC_CDC_CHANNEL
        SFDC_PLATFORM_EVENTS_CHANNEL
        CLOUD_SCHEDULER
        INTEGRATION_CONNECTOR_TRIGGER
        PRIVATE_TRIGGER],
       :position EnterpriseCrmEventbusProtoCoordinate,
       :triggerName string,
       :enabledClients [string],
       :triggerNumber string,
       :pauseWorkflowExecutions boolean}],
     :description string,
     :taskConfigsInternal
     [{:description string,
       :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
       :errorCatcherId string,
       :nextTasksExecutionPolicy
       [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
       :disableStrictTypeValidation boolean,
       :taskSpec string,
       :incomingEdgeCount integer,
       :createTime string,
       :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
       :preconditionLabel string,
       :rollbackStrategy
       EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
       :nextTasks [EnterpriseCrmEventbusProtoNextTask],
       :synchronousCallFailurePolicy
       EnterpriseCrmEventbusProtoFailurePolicy,
       :taskTemplateName string,
       :jsonValidationOption
       [UNSPECIFIED_JSON_VALIDATION_OPTION
        SKIP
        PRE_EXECUTION
        POST_EXECUTION
        PRE_POST_EXECUTION],
       :lastModifiedTime string,
       :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
       :label string,
       :position EnterpriseCrmEventbusProtoCoordinate,
       :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
       :conditionalFailurePolicies
       EnterpriseCrmEventbusProtoConditionalFailurePolicies,
       :externalTaskType
       [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
       :creatorEmail string,
       :taskName string,
       :parameters object,
       :taskNumber string,
       :taskExecutionStrategy
       [WHEN_ALL_SUCCEED
        WHEN_ANY_SUCCEED
        WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
       :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
       :precondition string}],
     :name string,
     :triggerConfigs
     [{:description string,
       :properties object,
       :cloudSchedulerConfig
       GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
       :triggerId string,
       :errorCatcherId string,
       :nextTasksExecutionPolicy
       [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
        RUN_ALL_MATCH
        RUN_FIRST_MATCH],
       :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
       :alertConfig
       [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
       :label string,
       :triggerType
       [TRIGGER_TYPE_UNSPECIFIED
        CRON
        API
        SFDC_CHANNEL
        CLOUD_PUBSUB_EXTERNAL
        SFDC_CDC_CHANNEL
        CLOUD_SCHEDULER
        INTEGRATION_CONNECTOR_TRIGGER
        PRIVATE_TRIGGER],
       :position GoogleCloudIntegrationsV1alphaCoordinate,
       :trigger string,
       :triggerNumber string}],
     :integrationParameters
     [{:containsLargeData boolean,
       :producer string,
       :key string,
       :displayName string,
       :isTransient boolean,
       :searchable boolean,
       :jsonSchema string,
       :dataType
       [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
        STRING_VALUE
        INT_VALUE
        DOUBLE_VALUE
        BOOLEAN_VALUE
        STRING_ARRAY
        INT_ARRAY
        DOUBLE_ARRAY
        BOOLEAN_ARRAY
        JSON_VALUE
        PROTO_VALUE
        PROTO_ARRAY],
       :defaultValue GoogleCloudIntegrationsV1alphaValueType,
       :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
       :masked boolean}],
     :cloudLoggingDetails
     {:enableCloudLogging boolean,
      :cloudLoggingSeverity
      [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
     :createTime string,
     :userLabel string,
     :state
     [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
     :lastModifierEmail string,
     :runAsServiceAccount string,
     :updateTime string,
     :taskConfigs
     [{:description string,
       :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
       :errorCatcherId string,
       :task string,
       :nextTasksExecutionPolicy
       [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
        RUN_ALL_MATCH
        RUN_FIRST_MATCH],
       :taskTemplate string,
       :displayName string,
       :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
       :synchronousCallFailurePolicy
       GoogleCloudIntegrationsV1alphaFailurePolicy,
       :jsonValidationOption
       [JSON_VALIDATION_OPTION_UNSPECIFIED
        SKIP
        PRE_EXECUTION
        POST_EXECUTION
        PRE_POST_EXECUTION],
       :position GoogleCloudIntegrationsV1alphaCoordinate,
       :conditionalFailurePolicies
       GoogleCloudIntegrationsV1alphaConditionalFailurePolicies,
       :externalTaskType
       [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
       :taskId string,
       :parameters object,
       :taskExecutionStrategy
       [TASK_EXECUTION_STRATEGY_UNSPECIFIED
        WHEN_ALL_SUCCEED
        WHEN_ANY_SUCCEED
        WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
       :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
     :errorCatcherConfigs
     [{:errorCatcherId string,
       :label string,
       :errorCatcherNumber string,
       :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
       :description string,
       :position GoogleCloudIntegrationsV1alphaCoordinate}],
     :databasePersistencePolicy
     [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
      DATABASE_PERSISTENCE_DISABLED
      DATABASE_PERSISTENCE_ASYNC],
     :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
     :integrationConfigParameters
     [{:parameter GoogleCloudIntegrationsV1alphaIntegrationParameter,
       :value GoogleCloudIntegrationsV1alphaValueType}],
     :snapshotNumber string,
     :origin
     [UNSPECIFIED
      UI
      PIPER_V2
      PIPER_V3
      APPLICATION_IP_PROVISIONING
      TEST_CASE],
     :enableVariableMasking boolean,
     :integrationParametersInternal
     {:parameters
      [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
     :teardown
     {:teardownTaskConfigs
      [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
     :createdFromTemplate string,
     :lockHolder string,
     :parentTemplateId string}}],
  :integrationVersionTemplate
  {:configParameters
   [{:parameter
     {:containsLargeData boolean,
      :producer string,
      :key string,
      :displayName string,
      :isTransient boolean,
      :searchable boolean,
      :jsonSchema string,
      :dataType
      [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       BOOLEAN_ARRAY
       JSON_VALUE
       PROTO_VALUE
       PROTO_ARRAY],
      :defaultValue GoogleCloudIntegrationsV1alphaValueType,
      :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :masked boolean},
     :value
     {:intValue string,
      :stringArray GoogleCloudIntegrationsV1alphaStringParameterArray,
      :booleanValue boolean,
      :stringValue string,
      :jsonValue string,
      :intArray GoogleCloudIntegrationsV1alphaIntParameterArray,
      :doubleArray GoogleCloudIntegrationsV1alphaDoubleParameterArray,
      :doubleValue number,
      :booleanArray
      GoogleCloudIntegrationsV1alphaBooleanParameterArray}}],
   :integrationVersion
   {:triggerConfigsInternal
    [{:description string,
      :properties object,
      :cloudSchedulerConfig
      EnterpriseCrmEventbusProtoCloudSchedulerConfig,
      :triggerId string,
      :errorCatcherId string,
      :nextTasksExecutionPolicy
      [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
      :startTasks [EnterpriseCrmEventbusProtoNextTask],
      :triggerCriteria EnterpriseCrmEventbusProtoTriggerCriteria,
      :alertConfig [EnterpriseCrmEventbusProtoWorkflowAlertConfig],
      :label string,
      :triggerType
      [UNKNOWN
       CLOUD_PUBSUB
       GOOPS
       SFDC_SYNC
       CRON
       API
       MANIFOLD_TRIGGER
       DATALAYER_DATA_CHANGE
       SFDC_CHANNEL
       CLOUD_PUBSUB_EXTERNAL
       SFDC_CDC_CHANNEL
       SFDC_PLATFORM_EVENTS_CHANNEL
       CLOUD_SCHEDULER
       INTEGRATION_CONNECTOR_TRIGGER
       PRIVATE_TRIGGER],
      :position EnterpriseCrmEventbusProtoCoordinate,
      :triggerName string,
      :enabledClients [string],
      :triggerNumber string,
      :pauseWorkflowExecutions boolean}],
    :description string,
    :taskConfigsInternal
    [{:description string,
      :failurePolicy EnterpriseCrmEventbusProtoFailurePolicy,
      :errorCatcherId string,
      :nextTasksExecutionPolicy
      [UNSPECIFIED RUN_ALL_MATCH RUN_FIRST_MATCH],
      :disableStrictTypeValidation boolean,
      :taskSpec string,
      :incomingEdgeCount integer,
      :createTime string,
      :taskType [TASK ASIS_TEMPLATE IO_TEMPLATE],
      :preconditionLabel string,
      :rollbackStrategy
      EnterpriseCrmFrontendsEventbusProtoRollbackStrategy,
      :nextTasks [EnterpriseCrmEventbusProtoNextTask],
      :synchronousCallFailurePolicy
      EnterpriseCrmEventbusProtoFailurePolicy,
      :taskTemplateName string,
      :jsonValidationOption
      [UNSPECIFIED_JSON_VALIDATION_OPTION
       SKIP
       PRE_EXECUTION
       POST_EXECUTION
       PRE_POST_EXECUTION],
      :lastModifiedTime string,
      :alertConfigs [EnterpriseCrmEventbusProtoTaskAlertConfig],
      :label string,
      :position EnterpriseCrmEventbusProtoCoordinate,
      :taskEntity EnterpriseCrmFrontendsEventbusProtoTaskEntity,
      :conditionalFailurePolicies
      EnterpriseCrmEventbusProtoConditionalFailurePolicies,
      :externalTaskType
      [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
      :creatorEmail string,
      :taskName string,
      :parameters object,
      :taskNumber string,
      :taskExecutionStrategy
      [WHEN_ALL_SUCCEED
       WHEN_ANY_SUCCEED
       WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
      :successPolicy EnterpriseCrmEventbusProtoSuccessPolicy,
      :precondition string}],
    :name string,
    :triggerConfigs
    [{:description string,
      :properties object,
      :cloudSchedulerConfig
      GoogleCloudIntegrationsV1alphaCloudSchedulerConfig,
      :triggerId string,
      :errorCatcherId string,
      :nextTasksExecutionPolicy
      [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
       RUN_ALL_MATCH
       RUN_FIRST_MATCH],
      :startTasks [GoogleCloudIntegrationsV1alphaNextTask],
      :alertConfig
      [GoogleCloudIntegrationsV1alphaIntegrationAlertConfig],
      :label string,
      :triggerType
      [TRIGGER_TYPE_UNSPECIFIED
       CRON
       API
       SFDC_CHANNEL
       CLOUD_PUBSUB_EXTERNAL
       SFDC_CDC_CHANNEL
       CLOUD_SCHEDULER
       INTEGRATION_CONNECTOR_TRIGGER
       PRIVATE_TRIGGER],
      :position GoogleCloudIntegrationsV1alphaCoordinate,
      :trigger string,
      :triggerNumber string}],
    :integrationParameters
    [{:containsLargeData boolean,
      :producer string,
      :key string,
      :displayName string,
      :isTransient boolean,
      :searchable boolean,
      :jsonSchema string,
      :dataType
      [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
       STRING_VALUE
       INT_VALUE
       DOUBLE_VALUE
       BOOLEAN_VALUE
       STRING_ARRAY
       INT_ARRAY
       DOUBLE_ARRAY
       BOOLEAN_ARRAY
       JSON_VALUE
       PROTO_VALUE
       PROTO_ARRAY],
      :defaultValue GoogleCloudIntegrationsV1alphaValueType,
      :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
      :masked boolean}],
    :cloudLoggingDetails
    {:enableCloudLogging boolean,
     :cloudLoggingSeverity
     [CLOUD_LOGGING_SEVERITY_UNSPECIFIED INFO ERROR WARNING]},
    :createTime string,
    :userLabel string,
    :state
    [INTEGRATION_STATE_UNSPECIFIED DRAFT ACTIVE ARCHIVED SNAPSHOT],
    :lastModifierEmail string,
    :runAsServiceAccount string,
    :updateTime string,
    :taskConfigs
    [{:description string,
      :failurePolicy GoogleCloudIntegrationsV1alphaFailurePolicy,
      :errorCatcherId string,
      :task string,
      :nextTasksExecutionPolicy
      [NEXT_TASKS_EXECUTION_POLICY_UNSPECIFIED
       RUN_ALL_MATCH
       RUN_FIRST_MATCH],
      :taskTemplate string,
      :displayName string,
      :nextTasks [GoogleCloudIntegrationsV1alphaNextTask],
      :synchronousCallFailurePolicy
      GoogleCloudIntegrationsV1alphaFailurePolicy,
      :jsonValidationOption
      [JSON_VALIDATION_OPTION_UNSPECIFIED
       SKIP
       PRE_EXECUTION
       POST_EXECUTION
       PRE_POST_EXECUTION],
      :position GoogleCloudIntegrationsV1alphaCoordinate,
      :conditionalFailurePolicies
      GoogleCloudIntegrationsV1alphaConditionalFailurePolicies,
      :externalTaskType
      [EXTERNAL_TASK_TYPE_UNSPECIFIED NORMAL_TASK ERROR_TASK],
      :taskId string,
      :parameters object,
      :taskExecutionStrategy
      [TASK_EXECUTION_STRATEGY_UNSPECIFIED
       WHEN_ALL_SUCCEED
       WHEN_ANY_SUCCEED
       WHEN_ALL_TASKS_AND_CONDITIONS_SUCCEED],
      :successPolicy GoogleCloudIntegrationsV1alphaSuccessPolicy}],
    :errorCatcherConfigs
    [{:errorCatcherId string,
      :label string,
      :errorCatcherNumber string,
      :startErrorTasks [GoogleCloudIntegrationsV1alphaNextTask],
      :description string,
      :position GoogleCloudIntegrationsV1alphaCoordinate}],
    :databasePersistencePolicy
    [DATABASE_PERSISTENCE_POLICY_UNSPECIFIED
     DATABASE_PERSISTENCE_DISABLED
     DATABASE_PERSISTENCE_ASYNC],
    :status [UNKNOWN DRAFT ACTIVE ARCHIVED SNAPSHOT],
    :integrationConfigParameters
    [{:parameter GoogleCloudIntegrationsV1alphaIntegrationParameter,
      :value GoogleCloudIntegrationsV1alphaValueType}],
    :snapshotNumber string,
    :origin
    [UNSPECIFIED
     UI
     PIPER_V2
     PIPER_V3
     APPLICATION_IP_PROVISIONING
     TEST_CASE],
    :enableVariableMasking boolean,
    :integrationParametersInternal
    {:parameters
     [EnterpriseCrmFrontendsEventbusProtoWorkflowParameterEntry]},
    :teardown
    {:teardownTaskConfigs
     [EnterpriseCrmEventbusProtoTeardownTaskConfig]},
    :createdFromTemplate string,
    :lockHolder string,
    :parentTemplateId string}}},
 :usageInfo string,
 :visibility [VISIBILITY_UNSPECIFIED PRIVATE SHARED PUBLIC]}"
  [parent GoogleCloudIntegrationsV1alphaTemplate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/templates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaTemplate}))

(defn projects-locations-templates-unshare
  "Unshare a template from given clients. Owner of the template can unshare template with clients. Shared client can only unshare the template from itself. PERMISSION_DENIED would be thrown if request is not from owner or for unsharing itself.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the Template.
GoogleCloudIntegrationsV1alphaUnshareTemplateRequest:
{:resourceNames [string]}"
  [name GoogleCloudIntegrationsV1alphaUnshareTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:unshare",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaUnshareTemplateRequest}))

(defn projects-locations-templates-delete
  "Deletes a template
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the Template."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://integrations.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-templates-search
  "Search templates based on user query and filters. This api would query the templates and return a list of templates based on the user filter.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of Templates.

optional:
readMask <string> Optional. The mask which specifies fields that need to be returned in the template's response.
orderBy <string> Optional. The results would be returned in the order you specified here.
pageSize <integer> Optional. The size of the response entries. If unspecified, defaults to 100. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Standard filter field to filter templates. client_id filter won't be supported and will restrict to templates belonging to the current client only. Return all templates of the current client if the filter is empty. Also supports operators like AND, OR, NOT For example, \"status=\\\"ACTIVE\\\""
  ([parent] (projects-locations-templates-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/templates:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-templates-list
  "Lists all templates matching the filter.
https://cloud.google.com/application-integration

parent <string> Required. The client, which owns this collection of Templates.

optional:
filter <string> Optional. Standard filter field to filter templates. client_id filter won't be supported and will restrict to templates belonging to the current client only. Return all templates of the current client if the filter is empty. Also supports operators like AND, OR, NOT For example, \"status=\\\"ACTIVE\\\"
pageSize <integer> Optional. The size of the response entries. If unspecified, defaults to 100. The maximum value is 1000; values above 1000 will be coerced to 1000.
orderBy <string> Optional. The results would be returned in the order you specified here.
readMask <string> Optional. The mask which specifies fields that need to be returned in the template's response."
  ([parent] (projects-locations-templates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://integrations.googleapis.com/v1/{+parent}/templates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-templates-share
  "Share a template with other clients. Only the template owner can share the templates with other projects. PERMISSION_DENIED would be thrown if the request is not from the owner.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the Template.
GoogleCloudIntegrationsV1alphaShareTemplateRequest:
{:resourceNames [string]}"
  [name GoogleCloudIntegrationsV1alphaShareTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:share",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaShareTemplateRequest}))

(defn projects-locations-templates-import
  "Import the template to an existing integration. This api would keep track of usage_count and last_used_time. PERMISSION_DENIED would be thrown if template is not accessible by client.
https://cloud.google.com/application-integration

name <string> Required. The name that is associated with the Template.
GoogleCloudIntegrationsV1alphaImportTemplateRequest:
{:configParameters
 [{:parameter
   {:containsLargeData boolean,
    :producer string,
    :key string,
    :displayName string,
    :isTransient boolean,
    :searchable boolean,
    :jsonSchema string,
    :dataType
    [INTEGRATION_PARAMETER_DATA_TYPE_UNSPECIFIED
     STRING_VALUE
     INT_VALUE
     DOUBLE_VALUE
     BOOLEAN_VALUE
     STRING_ARRAY
     INT_ARRAY
     DOUBLE_ARRAY
     BOOLEAN_ARRAY
     JSON_VALUE
     PROTO_VALUE
     PROTO_ARRAY],
    :defaultValue
    {:intValue string,
     :stringArray {:stringValues [string]},
     :booleanValue boolean,
     :stringValue string,
     :jsonValue string,
     :intArray {:intValues [string]},
     :doubleArray {:doubleValues [number]},
     :doubleValue number,
     :booleanArray {:booleanValues [boolean]}},
    :inputOutputType [IN_OUT_TYPE_UNSPECIFIED IN OUT IN_OUT],
    :masked boolean},
   :value
   {:intValue string,
    :stringArray {:stringValues [string]},
    :booleanValue boolean,
    :stringValue string,
    :jsonValue string,
    :intArray {:intValues [string]},
    :doubleArray {:doubleValues [number]},
    :doubleValue number,
    :booleanArray {:booleanValues [boolean]}}}],
 :integration string}"
  [name GoogleCloudIntegrationsV1alphaImportTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+name}:import",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaImportTemplateRequest}))

(defn projects-locations-cloudFunctions-create
  "Creates a cloud function project.
https://cloud.google.com/application-integration

parent <string> Required. The project that the executed integration belongs to.
GoogleCloudIntegrationsV1alphaCreateCloudFunctionRequest:
{:functionRegion string, :projectId string, :functionName string}"
  [parent GoogleCloudIntegrationsV1alphaCreateCloudFunctionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://integrations.googleapis.com/v1/{+parent}/cloudFunctions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudIntegrationsV1alphaCreateCloudFunctionRequest}))

(defn connectorPlatformRegions-enumerate
  "Enumerates the regions for which Connector Platform is provisioned.
https://cloud.google.com/application-integration"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://integrations.googleapis.com/v1/connectorPlatformRegions:enumerate",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(ns happygapi2.servicemanagement
  "Service Management API
Google Service Management allows service producers to publish their services on Google Cloud Platform so that they can be discovered and used by service consumers.
See: https://cloud.google.com/service-infrastructure/docs"
  (:require [happy.oauth2.client :as client]))

(defn operations-list
  "Lists service operations that match the specified filter in the request.
https://cloud.google.com/service-infrastructure/docs

optional:
name <string> Not used.
filter <string> A string for filtering Operations. The following filter fields are supported: * serviceName: Required. Only `=` operator is allowed. * startTime: The time this job was started, in ISO 8601 format. Allowed operators are `>=`, `>`, `<=`, and `<`. * status: Can be `done`, `in_progress`, or `failed`. Allowed operators are `=`, and `!=`. Filter expression supports conjunction (AND) and disjunction (OR) logical operators. However, the serviceName restriction must be at the top-level and can only be combined with other restrictions via the AND logical operator. Examples: * `serviceName={some-service}.googleapis.com` * `serviceName={some-service}.googleapis.com AND startTime>=\"2017-02-01\"` * `serviceName={some-service}.googleapis.com AND status=done` * `serviceName={some-service}.googleapis.com AND (status=done OR startTime>=\"2017-02-01\")`
pageSize <integer> The maximum number of operations to return. If unspecified, defaults to 50. The maximum value is 100."
  ([] (operations-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicemanagement.googleapis.com/v1/operations",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/service.management"]})))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/service-infrastructure/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn services-get
  "Gets a managed service. Authentication is required unless the service is public.
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the `ServiceManager` overview for naming requirements. For example: `example.googleapis.com`."
  [serviceName]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services/{serviceName}",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/service.management"
      "https://www.googleapis.com/auth/service.management.readonly"]}))

(defn services-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/service-infrastructure/docs

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
     "https://servicemanagement.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body SetIamPolicyRequest}))

(defn services-generateConfigReport
  "Generates and returns a report (errors, warnings and changes from existing configurations) associated with GenerateConfigReportRequest.new_value If GenerateConfigReportRequest.old_value is specified, GenerateConfigReportRequest will contain a single ChangeReport based on the comparison between GenerateConfigReportRequest.new_value and GenerateConfigReportRequest.old_value. If GenerateConfigReportRequest.old_value is not specified, this method will compare GenerateConfigReportRequest.new_value with the last pushed service configuration.
https://cloud.google.com/service-infrastructure/docs

GenerateConfigReportRequest:
{:newConfig object, :oldConfig object}"
  [GenerateConfigReportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services:generateConfigReport",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body GenerateConfigReportRequest}))

(defn services-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/service-infrastructure/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/service.management"
      "https://www.googleapis.com/auth/service.management.readonly"],
     :body TestIamPermissionsRequest}))

(defn services-create
  "Creates a new managed service. A managed service is immutable, and is subject to mandatory 30-day data retention. You cannot move a service or recreate it within 30 days after deletion. One producer project can own no more than 500 services. For security and reliability purposes, a production service should be hosted in a dedicated producer project. Operation
https://cloud.google.com/service-infrastructure/docs

ManagedService:
{:serviceName string, :producerProjectId string}"
  [ManagedService]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body ManagedService}))

(defn services-delete
  "Deletes a managed service. This method will change the service to the `Soft-Delete` state for 30 days. Within this period, service producers may call UndeleteService to restore the service. After 30 days, the service will be permanently deleted. Operation
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`."
  [serviceName]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services/{serviceName}",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn services-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/service-infrastructure/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/service.management"
      "https://www.googleapis.com/auth/service.management.readonly"],
     :body GetIamPolicyRequest}))

(defn services-undelete
  "Revives a previously deleted managed service. The method restores the service using the configuration at the time the service was deleted. The target service must exist and must have been deleted within the last 30 days. Operation
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`."
  [serviceName]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services/{serviceName}:undelete",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"]}))

(defn services-getConfig
  "Gets a service configuration (version) for a managed service.
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.

optional:
configId <string> Required. The id of the service configuration resource. This field must be specified for the server to return all fields, including `SourceInfo`.
view <string> Specifies which parts of the Service Config should be returned in the response."
  ([serviceName] (services-getConfig serviceName nil))
  ([serviceName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicemanagement.googleapis.com/v1/services/{serviceName}/config",
       :uri-template-args {:serviceName serviceName},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/service.management"
        "https://www.googleapis.com/auth/service.management.readonly"]})))

(defn services-list
  "Lists managed services. Returns all public services. For authenticated users, also returns all services the calling user has \"servicemanagement.services.get\" permission for.
https://cloud.google.com/service-infrastructure/docs

optional:
producerProjectId <string> Include services produced by the specified project.
pageSize <integer> The max number of items to include in the response list. Page size is 50 if not specified. Maximum value is 500.
consumerId <string> Include services consumed by the specified consumer. The Google Service Management implementation accepts the following forms: - project:"
  ([] (services-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicemanagement.googleapis.com/v1/services",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/service.management"
        "https://www.googleapis.com/auth/service.management.readonly"]})))

(defn services-configs-list
  "Lists the history of the service configuration for a managed service, from the newest to the oldest.
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.

optional:
pageSize <integer> The max number of items to include in the response list. Page size is 50 if not specified. Maximum value is 100."
  ([serviceName] (services-configs-list serviceName nil))
  ([serviceName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicemanagement.googleapis.com/v1/services/{serviceName}/configs",
       :uri-template-args {:serviceName serviceName},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/service.management"
        "https://www.googleapis.com/auth/service.management.readonly"]})))

(defn services-configs-get
  "Gets a service configuration (version) for a managed service.
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.
configId <string> Required. The id of the service configuration resource. This field must be specified for the server to return all fields, including `SourceInfo`.

optional:
view <string> Specifies which parts of the Service Config should be returned in the response."
  ([serviceName configId]
    (services-configs-get serviceName configId nil))
  ([serviceName configId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicemanagement.googleapis.com/v1/services/{serviceName}/configs/{configId}",
       :uri-template-args
       {:serviceName serviceName, :configId configId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/service.management"
        "https://www.googleapis.com/auth/service.management.readonly"]})))

(defn services-configs-create
  "Creates a new service configuration (version) for a managed service. This method only stores the service configuration. To roll out the service configuration to backend systems please call CreateServiceRollout. Only the 100 most recent service configurations and ones referenced by existing rollouts are kept for each service. The rest will be deleted eventually.
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.
Service:
{:monitoring
 {:producerDestinations
  [{:monitoredResource string, :metrics [string]}],
  :consumerDestinations
  [{:monitoredResource string, :metrics [string]}]},
 :systemParameters
 {:rules
  [{:selector string,
    :parameters
    [{:name string, :httpHeader string, :urlQueryParameter string}]}]},
 :logs
 [{:name string,
   :labels
   [{:key string,
     :valueType [STRING BOOL INT64],
     :description string}],
   :description string,
   :displayName string}],
 :publishing
 {:codeownerGithubTeams [string],
  :methodSettings
  [{:selector string,
    :longRunning
    {:initialPollDelay string,
     :pollDelayMultiplier number,
     :maxPollDelay string,
     :totalPollTimeout string},
    :autoPopulatedFields [string]}],
  :newIssueUri string,
  :docTagPrefix string,
  :documentationUri string,
  :apiShortName string,
  :protoReferenceDocumentationUri string,
  :githubLabel string,
  :organization
  [CLIENT_LIBRARY_ORGANIZATION_UNSPECIFIED
   CLOUD
   ADS
   PHOTOS
   STREET_VIEW
   SHOPPING
   GEO
   GENERATIVE_AI],
  :restReferenceDocumentationUri string,
  :librarySettings
  [{:phpSettings
    {:common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]}},
    :rubySettings
    {:common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]}},
    :javaSettings
    {:libraryPackage string,
     :serviceClassNames object,
     :common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]}},
    :cppSettings
    {:common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]}},
    :pythonSettings
    {:common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]}},
    :restNumericEnums boolean,
    :dotnetSettings
    {:common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]},
     :renamedServices object,
     :renamedResources object,
     :ignoredResources [string],
     :forcedNamespaceAliases [string],
     :handwrittenSignatures [string]},
    :nodeSettings
    {:common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]}},
    :goSettings
    {:common
     {:referenceDocsUri string,
      :destinations
      [[CLIENT_LIBRARY_DESTINATION_UNSPECIFIED
        GITHUB
        PACKAGE_MANAGER]]}},
    :launchStage
    [LAUNCH_STAGE_UNSPECIFIED
     UNIMPLEMENTED
     PRELAUNCH
     EARLY_ACCESS
     ALPHA
     BETA
     GA
     DEPRECATED],
    :version string}]},
 :name string,
 :billing
 {:consumerDestinations
  [{:monitoredResource string, :metrics [string]}]},
 :producerProjectId string,
 :quota
 {:limits
  [{:description string,
    :unit string,
    :displayName string,
    :name string,
    :duration string,
    :values object,
    :freeTier string,
    :defaultLimit string,
    :maxLimit string,
    :metric string}],
  :metricRules [{:selector string, :metricCosts object}]},
 :title string,
 :documentation
 {:summary string,
  :pages
  [{:name string,
    :content string,
    :subpages
    [{:name string,
      :content string,
      :subpages
      [{:name string, :content string, :subpages [Page]}]}]}],
  :rules
  [{:selector string,
    :description string,
    :deprecationDescription string,
    :disableReplacementWords string}],
  :documentationRootUrl string,
  :serviceRootUrl string,
  :overview string,
  :sectionOverrides
  [{:name string,
    :content string,
    :subpages
    [{:name string,
      :content string,
      :subpages
      [{:name string, :content string, :subpages [Page]}]}]}]},
 :types
 [{:name string,
   :fields
   [{:typeUrl string,
     :number integer,
     :oneofIndex integer,
     :name string,
     :kind
     [TYPE_UNKNOWN
      TYPE_DOUBLE
      TYPE_FLOAT
      TYPE_INT64
      TYPE_UINT64
      TYPE_INT32
      TYPE_FIXED64
      TYPE_FIXED32
      TYPE_BOOL
      TYPE_STRING
      TYPE_GROUP
      TYPE_MESSAGE
      TYPE_BYTES
      TYPE_UINT32
      TYPE_ENUM
      TYPE_SFIXED32
      TYPE_SFIXED64
      TYPE_SINT32
      TYPE_SINT64],
     :jsonName string,
     :options [{:name string, :value object}],
     :packed boolean,
     :defaultValue string,
     :cardinality
     [CARDINALITY_UNKNOWN
      CARDINALITY_OPTIONAL
      CARDINALITY_REQUIRED
      CARDINALITY_REPEATED]}],
   :oneofs [string],
   :options [{:name string, :value object}],
   :sourceContext {:fileName string},
   :syntax [SYNTAX_PROTO2 SYNTAX_PROTO3 SYNTAX_EDITIONS],
   :edition string}],
 :logging
 {:producerDestinations [{:monitoredResource string, :logs [string]}],
  :consumerDestinations [{:monitoredResource string, :logs [string]}]},
 :endpoints
 [{:name string,
   :aliases [string],
   :target string,
   :allowCors boolean}],
 :configVersion integer,
 :sourceInfo {:sourceFiles [object]},
 :usage
 {:requirements [string],
  :rules
  [{:selector string,
    :allowUnregisteredCalls boolean,
    :skipServiceControl boolean}],
  :producerNotificationChannel string},
 :authentication
 {:rules
  [{:selector string,
    :oauth {:canonicalScopes string},
    :allowWithoutCredential boolean,
    :requirements [{:providerId string, :audiences string}]}],
  :providers
  [{:id string,
    :issuer string,
    :jwksUri string,
    :audiences string,
    :authorizationUrl string,
    :jwtLocations
    [{:header string,
      :query string,
      :cookie string,
      :valuePrefix string}]}]},
 :id string,
 :control
 {:environment string,
  :methodPolicies
  [{:selector string,
    :requestPolicies
    [{:selector string,
      :resourcePermission string,
      :resourceType string}]}]},
 :http
 {:rules
  [{:selector string,
    :get string,
    :patch string,
    :responseBody string,
    :custom {:kind string, :path string},
    :delete string,
    :additionalBindings
    [{:selector string,
      :get string,
      :patch string,
      :responseBody string,
      :custom {:kind string, :path string},
      :delete string,
      :additionalBindings
      [{:selector string,
        :get string,
        :patch string,
        :responseBody string,
        :custom CustomHttpPattern,
        :delete string,
        :additionalBindings [HttpRule],
        :post string,
        :put string,
        :body string}],
      :post string,
      :put string,
      :body string}],
    :post string,
    :put string,
    :body string}],
  :fullyDecodeReservedExpansion boolean},
 :context
 {:rules
  [{:selector string,
    :requested [string],
    :provided [string],
    :allowedRequestExtensions [string],
    :allowedResponseExtensions [string]}]},
 :monitoredResources
 [{:name string,
   :type string,
   :displayName string,
   :description string,
   :labels
   [{:key string,
     :valueType [STRING BOOL INT64],
     :description string}],
   :launchStage
   [LAUNCH_STAGE_UNSPECIFIED
    UNIMPLEMENTED
    PRELAUNCH
    EARLY_ACCESS
    ALPHA
    BETA
    GA
    DEPRECATED]}],
 :apis
 [{:name string,
   :methods
   [{:name string,
     :requestTypeUrl string,
     :requestStreaming boolean,
     :responseTypeUrl string,
     :responseStreaming boolean,
     :options [{:name string, :value object}],
     :syntax [SYNTAX_PROTO2 SYNTAX_PROTO3 SYNTAX_EDITIONS]}],
   :options [{:name string, :value object}],
   :version string,
   :sourceContext {:fileName string},
   :mixins [{:name string, :root string}],
   :syntax [SYNTAX_PROTO2 SYNTAX_PROTO3 SYNTAX_EDITIONS]}],
 :customError
 {:rules [{:selector string, :isErrorType boolean}], :types [string]},
 :systemTypes
 [{:name string,
   :fields
   [{:typeUrl string,
     :number integer,
     :oneofIndex integer,
     :name string,
     :kind
     [TYPE_UNKNOWN
      TYPE_DOUBLE
      TYPE_FLOAT
      TYPE_INT64
      TYPE_UINT64
      TYPE_INT32
      TYPE_FIXED64
      TYPE_FIXED32
      TYPE_BOOL
      TYPE_STRING
      TYPE_GROUP
      TYPE_MESSAGE
      TYPE_BYTES
      TYPE_UINT32
      TYPE_ENUM
      TYPE_SFIXED32
      TYPE_SFIXED64
      TYPE_SINT32
      TYPE_SINT64],
     :jsonName string,
     :options [{:name string, :value object}],
     :packed boolean,
     :defaultValue string,
     :cardinality
     [CARDINALITY_UNKNOWN
      CARDINALITY_OPTIONAL
      CARDINALITY_REQUIRED
      CARDINALITY_REPEATED]}],
   :oneofs [string],
   :options [{:name string, :value object}],
   :sourceContext {:fileName string},
   :syntax [SYNTAX_PROTO2 SYNTAX_PROTO3 SYNTAX_EDITIONS],
   :edition string}],
 :enums
 [{:name string,
   :enumvalue
   [{:name string,
     :number integer,
     :options [{:name string, :value object}]}],
   :options [{:name string, :value object}],
   :sourceContext {:fileName string},
   :syntax [SYNTAX_PROTO2 SYNTAX_PROTO3 SYNTAX_EDITIONS],
   :edition string}],
 :backend
 {:rules
  [{:selector string,
    :address string,
    :protocol string,
    :pathTranslation
    [PATH_TRANSLATION_UNSPECIFIED
     CONSTANT_ADDRESS
     APPEND_PATH_TO_ADDRESS],
    :operationDeadline number,
    :overridesByRequestProtocol object,
    :jwtAudience string,
    :minDeadline number,
    :deadline number,
    :disableAuth boolean}]},
 :metrics
 [{:description string,
   :labels
   [{:key string,
     :valueType [STRING BOOL INT64],
     :description string}],
   :valueType
   [VALUE_TYPE_UNSPECIFIED
    BOOL
    INT64
    DOUBLE
    STRING
    DISTRIBUTION
    MONEY],
   :monitoredResourceTypes [string],
   :unit string,
   :displayName string,
   :name string,
   :type string,
   :metricKind [METRIC_KIND_UNSPECIFIED GAUGE DELTA CUMULATIVE],
   :launchStage
   [LAUNCH_STAGE_UNSPECIFIED
    UNIMPLEMENTED
    PRELAUNCH
    EARLY_ACCESS
    ALPHA
    BETA
    GA
    DEPRECATED],
   :metadata
   {:launchStage
    [LAUNCH_STAGE_UNSPECIFIED
     UNIMPLEMENTED
     PRELAUNCH
     EARLY_ACCESS
     ALPHA
     BETA
     GA
     DEPRECATED],
    :samplePeriod string,
    :ingestDelay string}}]}"
  [serviceName Service]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services/{serviceName}/configs",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body Service}))

(defn services-configs-submit
  "Creates a new service configuration (version) for a managed service based on user-supplied configuration source files (for example: OpenAPI Specification). This method stores the source configurations as well as the generated service configuration. To rollout the service configuration to other services, please call CreateServiceRollout. Only the 100 most recent configuration sources and ones referenced by existing service configurtions are kept for each service. The rest will be deleted eventually. Operation
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.
SubmitConfigSourceRequest:
{:configSource
 {:id string,
  :files
  [{:filePath string,
    :fileContents string,
    :fileType
    [FILE_TYPE_UNSPECIFIED
     SERVICE_CONFIG_YAML
     OPEN_API_JSON
     OPEN_API_YAML
     FILE_DESCRIPTOR_SET_PROTO
     PROTO_FILE]}]},
 :validateOnly boolean}"
  [serviceName SubmitConfigSourceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services/{serviceName}/configs:submit",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body SubmitConfigSourceRequest}))

(defn services-rollouts-list
  "Lists the history of the service configuration rollouts for a managed service, from the newest to the oldest.
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.

optional:
pageSize <integer> The max number of items to include in the response list. Page size is 50 if not specified. Maximum value is 100.
filter <string> Required. Use `filter` to return subset of rollouts. The following filters are supported: -- By status. For example, `filter='status=SUCCESS'` -- By strategy. For example, `filter='strategy=TrafficPercentStrategy'`"
  ([serviceName] (services-rollouts-list serviceName nil))
  ([serviceName optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://servicemanagement.googleapis.com/v1/services/{serviceName}/rollouts",
       :uri-template-args {:serviceName serviceName},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/service.management"
        "https://www.googleapis.com/auth/service.management.readonly"]})))

(defn services-rollouts-get
  "Gets a service configuration rollout.
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.
rolloutId <string> Required. The id of the rollout resource."
  [serviceName rolloutId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services/{serviceName}/rollouts/{rolloutId}",
     :uri-template-args
     {:serviceName serviceName, :rolloutId rolloutId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/service.management"
      "https://www.googleapis.com/auth/service.management.readonly"]}))

(defn services-rollouts-create
  "Creates a new service configuration rollout. Based on rollout, the Google Service Management will roll out the service configurations to different backend services. For example, the logging configuration will be pushed to Google Cloud Logging. Please note that any previous pending and running Rollouts and associated Operations will be automatically cancelled so that the latest Rollout will not be blocked by previous Rollouts. Only the 100 most recent (in any state) and the last 10 successful (if not already part of the set of 100 most recent) rollouts are kept for each service. The rest will be deleted eventually. Operation
https://cloud.google.com/service-infrastructure/docs

serviceName <string> Required. The name of the service. See the [overview](https://cloud.google.com/service-management/overview) for naming requirements. For example: `example.googleapis.com`.
Rollout:
{:rolloutId string,
 :createTime string,
 :createdBy string,
 :status
 [ROLLOUT_STATUS_UNSPECIFIED
  IN_PROGRESS
  SUCCESS
  CANCELLED
  FAILED
  PENDING
  FAILED_ROLLED_BACK],
 :trafficPercentStrategy {:percentages object},
 :deleteServiceStrategy object,
 :serviceName string}"
  [serviceName Rollout]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/services/{serviceName}/rollouts",
     :uri-template-args {:serviceName serviceName},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body Rollout}))

(defn services-consumers-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/service-infrastructure/docs

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
     "https://servicemanagement.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/service.management"],
     :body SetIamPolicyRequest}))

(defn services-consumers-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/service-infrastructure/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/service.management"
      "https://www.googleapis.com/auth/service.management.readonly"],
     :body GetIamPolicyRequest}))

(defn services-consumers-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/service-infrastructure/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://servicemanagement.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/service.management"
      "https://www.googleapis.com/auth/service.management.readonly"],
     :body TestIamPermissionsRequest}))

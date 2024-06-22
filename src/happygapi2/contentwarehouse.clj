(ns happygapi2.contentwarehouse
  "Document AI Warehouse API

See: https://cloud.google.com/document-warehouse/docs/overview"
  (:require [happy.oauth2.client :as client]))

(defn projects-fetchAcl
  "Gets the access control policy for a resource. Returns NOT_FOUND error if the resource does not exist. Returns an empty policy if the resource exists but does not have a policy set.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects/fetchAcl

resource <string> Required. REQUIRED: The resource for which the policy is being requested. Format for document: projects/{project_number}/locations/{location}/documents/{document_id}. Format for collection: projects/{project_number}/locations/{location}/collections/{collection_id}. Format for project: projects/{project_number}.
GoogleCloudContentwarehouseV1FetchAclRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :projectOwner boolean}"
  [resource GoogleCloudContentwarehouseV1FetchAclRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+resource}:fetchAcl",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1FetchAclRequest}))

(defn projects-setAcl
  "Sets the access control policy for a resource. Replaces any existing policy.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects/setAcl

resource <string> Required. REQUIRED: The resource for which the policy is being requested. Format for document: projects/{project_number}/locations/{location}/documents/{document_id}. Format for collection: projects/{project_number}/locations/{location}/collections/{collection_id}. Format for project: projects/{project_number}.
GoogleCloudContentwarehouseV1SetAclRequest:
{:projectOwner boolean,
 :policy
 {:etag string,
  :version integer,
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:exemptedMembers [string],
      :logType
      [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ]}]}],
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:location string,
     :expression string,
     :description string,
     :title string}}]},
 :requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [resource GoogleCloudContentwarehouseV1SetAclRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+resource}:setAcl",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1SetAclRequest}))

(defn projects-locations-initialize
  "Provisions resources for given tenant project. Returns a long running operation.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations/initialize

location <string> Required. The location to be initialized Format: projects/{project_number}/locations/{location}.
GoogleCloudContentwarehouseV1InitializeProjectRequest:
{:databaseType [DB_UNKNOWN DB_INFRA_SPANNER DB_CLOUD_SQL_POSTGRES],
 :documentCreatorDefaultRole
 [DOCUMENT_CREATOR_DEFAULT_ROLE_UNSPECIFIED
  DOCUMENT_ADMIN
  DOCUMENT_EDITOR
  DOCUMENT_VIEWER],
 :kmsKey string,
 :accessControlMode
 [ACL_MODE_UNKNOWN
  ACL_MODE_UNIVERSAL_ACCESS
  ACL_MODE_DOCUMENT_LEVEL_ACCESS_CONTROL_BYOID
  ACL_MODE_DOCUMENT_LEVEL_ACCESS_CONTROL_GCI],
 :enableCalUserEmailLogging boolean}"
  [location GoogleCloudContentwarehouseV1InitializeProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+location}:initialize",
     :uri-template-args {:location location},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1InitializeProjectRequest}))

(defn projects-locations-getStatus
  "Get the project status.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations/getStatus

location <string> Required. The location to be queried Format: projects/{project_number}/locations/{location}."
  [location]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+location}:getStatus",
     :uri-template-args {:location location},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-runPipeline
  "Run a predefined pipeline.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations/runPipeline

name <string> Required. The resource name which owns the resources of the pipeline. Format: projects/{project_number}/locations/{location}.
GoogleCloudContentwarehouseV1RunPipelineRequest:
{:exportCdwPipeline
 {:docAiDataset string,
  :trainingSplitRatio number,
  :exportFolderPath string,
  :documents [string]},
 :requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :gcsIngestWithDocAiProcessorsPipeline
 {:inputPath string,
  :processorResultsFolderPath string,
  :splitClassifyProcessorInfo
  {:processorName string, :schemaName string, :documentType string},
  :pipelineConfig
  {:enableDocumentTextExtraction boolean,
   :documentAclPolicy
   {:etag string,
    :version integer,
    :auditConfigs
    [{:service string, :auditLogConfigs [GoogleIamV1AuditLogConfig]}],
    :bindings
    [{:role string, :members [string], :condition GoogleTypeExpr}]},
   :folder string,
   :cloudFunction string},
  :skipIngestedDocuments boolean,
  :extractProcessorInfos
  [{:processorName string, :schemaName string, :documentType string}]},
 :gcsIngestPipeline
 {:schemaName string,
  :inputPath string,
  :pipelineConfig
  {:enableDocumentTextExtraction boolean,
   :documentAclPolicy
   {:etag string,
    :version integer,
    :auditConfigs
    [{:service string, :auditLogConfigs [GoogleIamV1AuditLogConfig]}],
    :bindings
    [{:role string, :members [string], :condition GoogleTypeExpr}]},
   :folder string,
   :cloudFunction string},
  :skipIngestedDocuments boolean,
  :processorType string},
 :processWithDocAiPipeline
 {:documents [string],
  :processorResultsFolderPath string,
  :processorInfo
  {:processorName string, :schemaName string, :documentType string},
  :exportFolderPath string}}"
  [name GoogleCloudContentwarehouseV1RunPipelineRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}:runPipeline",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1RunPipelineRequest}))

(defn projects-locations-documentSchemas-list
  "Lists document schemas.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/list

parent <string> Required. The parent, which owns this collection of document schemas. Format: projects/{project_number}/locations/{location}.

optional:
pageSize <integer> The maximum number of document schemas to return. The service may return fewer than this value. If unspecified, at most 50 document schemas will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-documentSchemas-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contentwarehouse.googleapis.com/v1/{+parent}/documentSchemas",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-documentSchemas-delete
  "Deletes a document schema. Returns NOT_FOUND if the document schema does not exist. Returns BAD_REQUEST if the document schema has documents depending on it.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/delete

name <string> Required. The name of the document schema to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-documentSchemas-patch
  "Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the Document Schema is non-empty and does not equal the existing name. Supports only appending new properties, adding new ENUM possible values, and updating the EnumTypeOptions.validation_check_disabled flag for ENUM possible values. Updating existing properties will result into INVALID_ARGUMENT.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/patch

name <string> Required. The name of the document schema to update. Format: projects/{project_number}/locations/{location}/documentSchemas/{document_schema_id}.
GoogleCloudContentwarehouseV1UpdateDocumentSchemaRequest:
{:documentSchema
 {:createTime string,
  :name string,
  :updateTime string,
  :displayName string,
  :description string,
  :propertyDefinitions
  [{:propertyTypeOptions
    {:propertyDefinitions
     [{:propertyTypeOptions
       GoogleCloudContentwarehouseV1PropertyTypeOptions,
       :enumTypeOptions GoogleCloudContentwarehouseV1EnumTypeOptions,
       :displayName string,
       :isFilterable boolean,
       :name string,
       :isSearchable boolean,
       :retrievalImportance
       [RETRIEVAL_IMPORTANCE_UNSPECIFIED
        HIGHEST
        HIGHER
        HIGH
        MEDIUM
        LOW
        LOWEST],
       :schemaSources
       [GoogleCloudContentwarehouseV1PropertyDefinitionSchemaSource],
       :isMetadata boolean,
       :integerTypeOptions
       GoogleCloudContentwarehouseV1IntegerTypeOptions,
       :textTypeOptions GoogleCloudContentwarehouseV1TextTypeOptions,
       :isRequired boolean,
       :timestampTypeOptions
       GoogleCloudContentwarehouseV1TimestampTypeOptions,
       :floatTypeOptions GoogleCloudContentwarehouseV1FloatTypeOptions,
       :dateTimeTypeOptions
       GoogleCloudContentwarehouseV1DateTimeTypeOptions,
       :mapTypeOptions GoogleCloudContentwarehouseV1MapTypeOptions,
       :isRepeatable boolean}]},
    :enumTypeOptions
    {:possibleValues [string], :validationCheckDisabled boolean},
    :displayName string,
    :isFilterable boolean,
    :name string,
    :isSearchable boolean,
    :retrievalImportance
    [RETRIEVAL_IMPORTANCE_UNSPECIFIED
     HIGHEST
     HIGHER
     HIGH
     MEDIUM
     LOW
     LOWEST],
    :schemaSources [{:processorType string, :name string}],
    :isMetadata boolean,
    :integerTypeOptions object,
    :textTypeOptions object,
    :isRequired boolean,
    :timestampTypeOptions object,
    :floatTypeOptions object,
    :dateTimeTypeOptions object,
    :mapTypeOptions object,
    :isRepeatable boolean}],
  :documentIsFolder boolean}}"
  [name GoogleCloudContentwarehouseV1UpdateDocumentSchemaRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1UpdateDocumentSchemaRequest}))

(defn projects-locations-documentSchemas-create
  "Creates a document schema.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/create

parent <string> Required. The parent name.
GoogleCloudContentwarehouseV1DocumentSchema:
{:createTime string,
 :name string,
 :updateTime string,
 :displayName string,
 :description string,
 :propertyDefinitions
 [{:propertyTypeOptions
   {:propertyDefinitions
    [{:propertyTypeOptions
      {:propertyDefinitions
       [GoogleCloudContentwarehouseV1PropertyDefinition]},
      :enumTypeOptions
      {:possibleValues [string], :validationCheckDisabled boolean},
      :displayName string,
      :isFilterable boolean,
      :name string,
      :isSearchable boolean,
      :retrievalImportance
      [RETRIEVAL_IMPORTANCE_UNSPECIFIED
       HIGHEST
       HIGHER
       HIGH
       MEDIUM
       LOW
       LOWEST],
      :schemaSources [{:processorType string, :name string}],
      :isMetadata boolean,
      :integerTypeOptions object,
      :textTypeOptions object,
      :isRequired boolean,
      :timestampTypeOptions object,
      :floatTypeOptions object,
      :dateTimeTypeOptions object,
      :mapTypeOptions object,
      :isRepeatable boolean}]},
   :enumTypeOptions
   {:possibleValues [string], :validationCheckDisabled boolean},
   :displayName string,
   :isFilterable boolean,
   :name string,
   :isSearchable boolean,
   :retrievalImportance
   [RETRIEVAL_IMPORTANCE_UNSPECIFIED
    HIGHEST
    HIGHER
    HIGH
    MEDIUM
    LOW
    LOWEST],
   :schemaSources [{:processorType string, :name string}],
   :isMetadata boolean,
   :integerTypeOptions object,
   :textTypeOptions object,
   :isRequired boolean,
   :timestampTypeOptions object,
   :floatTypeOptions object,
   :dateTimeTypeOptions object,
   :mapTypeOptions object,
   :isRepeatable boolean}],
 :documentIsFolder boolean}"
  [parent GoogleCloudContentwarehouseV1DocumentSchema]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/documentSchemas",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1DocumentSchema}))

(defn projects-locations-documentSchemas-get
  "Gets a document schema. Returns NOT_FOUND if the document schema does not exist.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documentSchemas/get

name <string> Required. The name of the document schema to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-ruleSets-delete
  "Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/delete

name <string> Required. The name of the rule set to delete. Format: projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-ruleSets-get
  "Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/get

name <string> Required. The name of the rule set to retrieve. Format: projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-ruleSets-list
  "Lists rulesets.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/list

parent <string> Required. The parent, which owns this collection of document. Format: projects/{project_number}/locations/{location}.

optional:
pageSize <integer> The maximum number of rule sets to return. The service may return fewer than this value. If unspecified, at most 50 rule sets will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-ruleSets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contentwarehouse.googleapis.com/v1/{+parent}/ruleSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-ruleSets-patch
  "Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset is non-empty and does not equal the existing name.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/patch

name <string> Required. The name of the rule set to update. Format: projects/{project_number}/locations/{location}/ruleSets/{rule_set_id}.
GoogleCloudContentwarehouseV1UpdateRuleSetRequest:
{:ruleSet
 {:rules
  [{:triggerType
    [UNKNOWN ON_CREATE ON_UPDATE ON_CREATE_LINK ON_DELETE_LINK],
    :ruleId string,
    :description string,
    :actions
    [{:publishToPubSub {:topicId string, :messages [string]},
      :accessControl
      {:policy GoogleIamV1Policy,
       :operationType
       [UNKNOWN
        ADD_POLICY_BINDING
        REMOVE_POLICY_BINDING
        REPLACE_POLICY_BINDING]},
      :addToFolder {:folders [string]},
      :deleteDocumentAction {:enableHardDelete boolean},
      :dataUpdate {:entries object},
      :actionId string,
      :removeFromFolderAction {:condition string, :folder string},
      :dataValidation {:conditions object}}],
    :condition string}],
  :source string,
  :description string,
  :name string}}"
  [name GoogleCloudContentwarehouseV1UpdateRuleSetRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1UpdateRuleSetRequest}))

(defn projects-locations-ruleSets-create
  "Creates a ruleset.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.ruleSets/create

parent <string> Required. The parent name. Format: projects/{project_number}/locations/{location}.
GoogleCloudContentwarehouseV1RuleSet:
{:rules
 [{:triggerType
   [UNKNOWN ON_CREATE ON_UPDATE ON_CREATE_LINK ON_DELETE_LINK],
   :ruleId string,
   :description string,
   :actions
   [{:publishToPubSub {:topicId string, :messages [string]},
     :accessControl
     {:policy
      {:etag string,
       :version integer,
       :auditConfigs [GoogleIamV1AuditConfig],
       :bindings [GoogleIamV1Binding]},
      :operationType
      [UNKNOWN
       ADD_POLICY_BINDING
       REMOVE_POLICY_BINDING
       REPLACE_POLICY_BINDING]},
     :addToFolder {:folders [string]},
     :deleteDocumentAction {:enableHardDelete boolean},
     :dataUpdate {:entries object},
     :actionId string,
     :removeFromFolderAction {:condition string, :folder string},
     :dataValidation {:conditions object}}],
   :condition string}],
 :source string,
 :description string,
 :name string}"
  [parent GoogleCloudContentwarehouseV1RuleSet]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/ruleSets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1RuleSet}))

(defn projects-locations-documents-linkedTargets
  "Return all target document-links from the document.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/linkedTargets

parent <string> Required. The name of the document, for which all target links are returned. Format: projects/{project_number}/locations/{location}/documents/{target_document_id}.
GoogleCloudContentwarehouseV1ListLinkedTargetsRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [parent GoogleCloudContentwarehouseV1ListLinkedTargetsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/linkedTargets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1ListLinkedTargetsRequest}))

(defn projects-locations-documents-get
  "Gets a document. Returns NOT_FOUND if the document does not exist.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/get

name <string> Required. The name of the document to retrieve. Format: projects/{project_number}/locations/{location}/documents/{document_id} or projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
GoogleCloudContentwarehouseV1GetDocumentRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [name GoogleCloudContentwarehouseV1GetDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}:get",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1GetDocumentRequest}))

(defn projects-locations-documents-patch
  "Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does not equal the existing name.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/patch

name <string> Required. The name of the document to update. Format: projects/{project_number}/locations/{location}/documents/{document_id} or projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
GoogleCloudContentwarehouseV1UpdateDocumentRequest:
{:cloudAiDocumentOption
 {:customizedEntitiesPropertiesConversions object,
  :enableEntitiesConversions boolean},
 :requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :updateOptions
 {:mergeFieldsOptions
  {:replaceMessageFields boolean, :replaceRepeatedFields boolean},
  :updateType
  [UPDATE_TYPE_UNSPECIFIED
   UPDATE_TYPE_REPLACE
   UPDATE_TYPE_MERGE
   UPDATE_TYPE_INSERT_PROPERTIES_BY_NAMES
   UPDATE_TYPE_REPLACE_PROPERTIES_BY_NAMES
   UPDATE_TYPE_DELETE_PROPERTIES_BY_NAMES
   UPDATE_TYPE_MERGE_AND_REPLACE_OR_INSERT_PROPERTIES_BY_NAMES],
  :updateMask string},
 :document
 {:properties
  [{:mapProperty {:fields object},
    :floatValues {:values [number]},
    :name string,
    :integerValues {:values [integer]},
    :dateTimeValues
    {:values
     [{:timeZone GoogleTypeTimeZone,
       :day integer,
       :nanos integer,
       :month integer,
       :seconds integer,
       :year integer,
       :utcOffset string,
       :hours integer,
       :minutes integer}]},
    :textValues {:values [string]},
    :enumValues {:values [string]},
    :timestampValues
    {:values [{:timestampValue string, :textValue string}]},
    :propertyValues
    {:properties
     [{:mapProperty GoogleCloudContentwarehouseV1MapProperty,
       :floatValues GoogleCloudContentwarehouseV1FloatArray,
       :name string,
       :integerValues GoogleCloudContentwarehouseV1IntegerArray,
       :dateTimeValues GoogleCloudContentwarehouseV1DateTimeArray,
       :textValues GoogleCloudContentwarehouseV1TextArray,
       :enumValues GoogleCloudContentwarehouseV1EnumArray,
       :timestampValues GoogleCloudContentwarehouseV1TimestampArray,
       :propertyValues GoogleCloudContentwarehouseV1PropertyArray}]}}],
  :creator string,
  :rawDocumentPath string,
  :textExtractionDisabled boolean,
  :textExtractionEnabled boolean,
  :dispositionTime string,
  :displayName string,
  :documentSchemaName string,
  :name string,
  :cloudAiDocument
  {:textChanges
   [{:provenance
     [{:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED],
       :revision integer,
       :id integer}],
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :changedText string}],
   :content string,
   :textStyles
   [{:textDecoration string,
     :color {:blue number, :alpha number, :red number, :green number},
     :backgroundColor
     {:blue number, :alpha number, :red number, :green number},
     :fontFamily string,
     :fontWeight string,
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :fontSize {:unit string, :size number},
     :textStyle string}],
   :shardInfo
   {:textOffset string, :shardIndex string, :shardCount string},
   :entities
   [{:properties
     [{:properties [GoogleCloudDocumentaiV1DocumentEntity],
       :textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :type string,
       :redacted boolean,
       :mentionText string,
       :mentionId string,
       :id string,
       :normalizedValue
       GoogleCloudDocumentaiV1DocumentEntityNormalizedValue,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :pageAnchor GoogleCloudDocumentaiV1DocumentPageAnchor,
       :confidence number}],
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :type string,
     :redacted boolean,
     :mentionText string,
     :mentionId string,
     :id string,
     :normalizedValue
     {:addressValue GoogleTypePostalAddress,
      :floatValue number,
      :booleanValue boolean,
      :moneyValue GoogleTypeMoney,
      :integerValue integer,
      :dateValue GoogleTypeDate,
      :datetimeValue GoogleTypeDateTime,
      :text string},
     :provenance
     {:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED],
      :revision integer,
      :id integer},
     :pageAnchor
     {:pageRefs [GoogleCloudDocumentaiV1DocumentPageAnchorPageRef]},
     :confidence number}],
   :entityRelations
   [{:subjectId string, :relation string, :objectId string}],
   :pages
   [{:visualElements
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :type string}],
     :layout
     {:orientation
      [ORIENTATION_UNSPECIFIED PAGE_UP PAGE_RIGHT PAGE_DOWN PAGE_LEFT],
      :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
      :confidence number,
      :textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor},
     :formFields
     [{:correctedValueText string,
       :fieldName GoogleCloudDocumentaiV1DocumentPageLayout,
       :nameDetectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :fieldValue GoogleCloudDocumentaiV1DocumentPageLayout,
       :valueDetectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :valueType string,
       :correctedKeyText string}],
     :transforms
     [{:type integer, :cols integer, :data string, :rows integer}],
     :lines
     [{:provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :detectedBarcodes
     [{:barcode GoogleCloudDocumentaiV1Barcode,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout}],
     :tables
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :bodyRows [GoogleCloudDocumentaiV1DocumentPageTableTableRow],
       :headerRows
       [GoogleCloudDocumentaiV1DocumentPageTableTableRow]}],
     :paragraphs
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :imageQualityScores
     {:detectedDefects
      [GoogleCloudDocumentaiV1DocumentPageImageQualityScoresDetectedDefect],
      :qualityScore number},
     :detectedLanguages [{:confidence number, :languageCode string}],
     :dimension {:unit string, :height number, :width number},
     :provenance
     {:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED],
      :revision integer,
      :id integer},
     :blocks
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :image
     {:mimeType string,
      :content string,
      :width integer,
      :height integer},
     :tokens
     [{:provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :styleInfo GoogleCloudDocumentaiV1DocumentPageTokenStyleInfo,
       :detectedBreak
       GoogleCloudDocumentaiV1DocumentPageTokenDetectedBreak}],
     :pageNumber integer,
     :symbols
     [{:detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :layout GoogleCloudDocumentaiV1DocumentPageLayout}]}],
   :mimeType string,
   :revisions
   [{:processor string,
     :agent string,
     :createTime string,
     :parentIds [string],
     :parent [integer],
     :humanReview {:stateMessage string, :state string},
     :id string}],
   :error {:details [object], :message string, :code integer},
   :uri string,
   :text string},
  :createTime string,
  :title string,
  :updateTime string,
  :contentCategory
  [CONTENT_CATEGORY_UNSPECIFIED
   CONTENT_CATEGORY_IMAGE
   CONTENT_CATEGORY_AUDIO
   CONTENT_CATEGORY_VIDEO],
  :rawDocumentFileType
  [RAW_DOCUMENT_FILE_TYPE_UNSPECIFIED
   RAW_DOCUMENT_FILE_TYPE_PDF
   RAW_DOCUMENT_FILE_TYPE_DOCX
   RAW_DOCUMENT_FILE_TYPE_XLSX
   RAW_DOCUMENT_FILE_TYPE_PPTX
   RAW_DOCUMENT_FILE_TYPE_TEXT
   RAW_DOCUMENT_FILE_TYPE_TIFF],
  :updater string,
  :referenceId string,
  :displayUri string,
  :plainText string,
  :legalHold boolean,
  :inlineRawDocument string}}"
  [name GoogleCloudContentwarehouseV1UpdateDocumentRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1UpdateDocumentRequest}))

(defn projects-locations-documents-fetchAcl
  "Gets the access control policy for a resource. Returns NOT_FOUND error if the resource does not exist. Returns an empty policy if the resource exists but does not have a policy set.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/fetchAcl

resource <string> Required. REQUIRED: The resource for which the policy is being requested. Format for document: projects/{project_number}/locations/{location}/documents/{document_id}. Format for collection: projects/{project_number}/locations/{location}/collections/{collection_id}. Format for project: projects/{project_number}.
GoogleCloudContentwarehouseV1FetchAclRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :projectOwner boolean}"
  [resource GoogleCloudContentwarehouseV1FetchAclRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+resource}:fetchAcl",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1FetchAclRequest}))

(defn projects-locations-documents-create
  "Creates a document.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/create

parent <string> Required. The parent name. Format: projects/{project_number}/locations/{location}.
GoogleCloudContentwarehouseV1CreateDocumentRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :document
 {:properties
  [{:mapProperty {:fields object},
    :floatValues {:values [number]},
    :name string,
    :integerValues {:values [integer]},
    :dateTimeValues
    {:values
     [{:timeZone GoogleTypeTimeZone,
       :day integer,
       :nanos integer,
       :month integer,
       :seconds integer,
       :year integer,
       :utcOffset string,
       :hours integer,
       :minutes integer}]},
    :textValues {:values [string]},
    :enumValues {:values [string]},
    :timestampValues
    {:values [{:timestampValue string, :textValue string}]},
    :propertyValues
    {:properties
     [{:mapProperty GoogleCloudContentwarehouseV1MapProperty,
       :floatValues GoogleCloudContentwarehouseV1FloatArray,
       :name string,
       :integerValues GoogleCloudContentwarehouseV1IntegerArray,
       :dateTimeValues GoogleCloudContentwarehouseV1DateTimeArray,
       :textValues GoogleCloudContentwarehouseV1TextArray,
       :enumValues GoogleCloudContentwarehouseV1EnumArray,
       :timestampValues GoogleCloudContentwarehouseV1TimestampArray,
       :propertyValues GoogleCloudContentwarehouseV1PropertyArray}]}}],
  :creator string,
  :rawDocumentPath string,
  :textExtractionDisabled boolean,
  :textExtractionEnabled boolean,
  :dispositionTime string,
  :displayName string,
  :documentSchemaName string,
  :name string,
  :cloudAiDocument
  {:textChanges
   [{:provenance
     [{:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED],
       :revision integer,
       :id integer}],
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :changedText string}],
   :content string,
   :textStyles
   [{:textDecoration string,
     :color {:blue number, :alpha number, :red number, :green number},
     :backgroundColor
     {:blue number, :alpha number, :red number, :green number},
     :fontFamily string,
     :fontWeight string,
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :fontSize {:unit string, :size number},
     :textStyle string}],
   :shardInfo
   {:textOffset string, :shardIndex string, :shardCount string},
   :entities
   [{:properties
     [{:properties [GoogleCloudDocumentaiV1DocumentEntity],
       :textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :type string,
       :redacted boolean,
       :mentionText string,
       :mentionId string,
       :id string,
       :normalizedValue
       GoogleCloudDocumentaiV1DocumentEntityNormalizedValue,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :pageAnchor GoogleCloudDocumentaiV1DocumentPageAnchor,
       :confidence number}],
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :type string,
     :redacted boolean,
     :mentionText string,
     :mentionId string,
     :id string,
     :normalizedValue
     {:addressValue GoogleTypePostalAddress,
      :floatValue number,
      :booleanValue boolean,
      :moneyValue GoogleTypeMoney,
      :integerValue integer,
      :dateValue GoogleTypeDate,
      :datetimeValue GoogleTypeDateTime,
      :text string},
     :provenance
     {:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED],
      :revision integer,
      :id integer},
     :pageAnchor
     {:pageRefs [GoogleCloudDocumentaiV1DocumentPageAnchorPageRef]},
     :confidence number}],
   :entityRelations
   [{:subjectId string, :relation string, :objectId string}],
   :pages
   [{:visualElements
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :type string}],
     :layout
     {:orientation
      [ORIENTATION_UNSPECIFIED PAGE_UP PAGE_RIGHT PAGE_DOWN PAGE_LEFT],
      :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
      :confidence number,
      :textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor},
     :formFields
     [{:correctedValueText string,
       :fieldName GoogleCloudDocumentaiV1DocumentPageLayout,
       :nameDetectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :fieldValue GoogleCloudDocumentaiV1DocumentPageLayout,
       :valueDetectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :valueType string,
       :correctedKeyText string}],
     :transforms
     [{:type integer, :cols integer, :data string, :rows integer}],
     :lines
     [{:provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :detectedBarcodes
     [{:barcode GoogleCloudDocumentaiV1Barcode,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout}],
     :tables
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :bodyRows [GoogleCloudDocumentaiV1DocumentPageTableTableRow],
       :headerRows
       [GoogleCloudDocumentaiV1DocumentPageTableTableRow]}],
     :paragraphs
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :imageQualityScores
     {:detectedDefects
      [GoogleCloudDocumentaiV1DocumentPageImageQualityScoresDetectedDefect],
      :qualityScore number},
     :detectedLanguages [{:confidence number, :languageCode string}],
     :dimension {:unit string, :height number, :width number},
     :provenance
     {:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED],
      :revision integer,
      :id integer},
     :blocks
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :image
     {:mimeType string,
      :content string,
      :width integer,
      :height integer},
     :tokens
     [{:provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :styleInfo GoogleCloudDocumentaiV1DocumentPageTokenStyleInfo,
       :detectedBreak
       GoogleCloudDocumentaiV1DocumentPageTokenDetectedBreak}],
     :pageNumber integer,
     :symbols
     [{:detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :layout GoogleCloudDocumentaiV1DocumentPageLayout}]}],
   :mimeType string,
   :revisions
   [{:processor string,
     :agent string,
     :createTime string,
     :parentIds [string],
     :parent [integer],
     :humanReview {:stateMessage string, :state string},
     :id string}],
   :error {:details [object], :message string, :code integer},
   :uri string,
   :text string},
  :createTime string,
  :title string,
  :updateTime string,
  :contentCategory
  [CONTENT_CATEGORY_UNSPECIFIED
   CONTENT_CATEGORY_IMAGE
   CONTENT_CATEGORY_AUDIO
   CONTENT_CATEGORY_VIDEO],
  :rawDocumentFileType
  [RAW_DOCUMENT_FILE_TYPE_UNSPECIFIED
   RAW_DOCUMENT_FILE_TYPE_PDF
   RAW_DOCUMENT_FILE_TYPE_DOCX
   RAW_DOCUMENT_FILE_TYPE_XLSX
   RAW_DOCUMENT_FILE_TYPE_PPTX
   RAW_DOCUMENT_FILE_TYPE_TEXT
   RAW_DOCUMENT_FILE_TYPE_TIFF],
  :updater string,
  :referenceId string,
  :displayUri string,
  :plainText string,
  :legalHold boolean,
  :inlineRawDocument string},
 :policy
 {:etag string,
  :version integer,
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:exemptedMembers [string],
      :logType
      [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ]}]}],
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:location string,
     :expression string,
     :description string,
     :title string}}]},
 :createMask string,
 :cloudAiDocumentOption
 {:customizedEntitiesPropertiesConversions object,
  :enableEntitiesConversions boolean}}"
  [parent GoogleCloudContentwarehouseV1CreateDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/documents",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1CreateDocumentRequest}))

(defn projects-locations-documents-linkedSources
  "Return all source document-links from the document.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/linkedSources

parent <string> Required. The name of the document, for which all source links are returned. Format: projects/{project_number}/locations/{location}/documents/{source_document_id}.
GoogleCloudContentwarehouseV1ListLinkedSourcesRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :pageSize integer,
 :pageToken string}"
  [parent GoogleCloudContentwarehouseV1ListLinkedSourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/linkedSources",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1ListLinkedSourcesRequest}))

(defn projects-locations-documents-delete
  "Deletes a document. Returns NOT_FOUND if the document does not exist.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/delete

name <string> Required. The name of the document to delete. Format: projects/{project_number}/locations/{location}/documents/{document_id} or projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
GoogleCloudContentwarehouseV1DeleteDocumentRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [name GoogleCloudContentwarehouseV1DeleteDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}:delete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1DeleteDocumentRequest}))

(defn projects-locations-documents-search
  "Searches for documents using provided SearchDocumentsRequest. This call only returns documents that the caller has permission to search against.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/search

parent <string> Required. The parent, which owns this collection of documents. Format: projects/{project_number}/locations/{location}.
GoogleCloudContentwarehouseV1SearchDocumentsRequest:
{:totalResultSize
 [TOTAL_RESULT_SIZE_UNSPECIFIED ESTIMATED_SIZE ACTUAL_SIZE],
 :offset integer,
 :histogramQueries
 [{:histogramQuery string,
   :filters
   {:propertyNames [string],
    :documentSchemas [string],
    :yAxis [HISTOGRAM_YAXIS_DOCUMENT HISTOGRAM_YAXIS_PROPERTY]},
   :requirePreciseResultSize boolean}],
 :documentQuery
 {:documentSchemaNames [string],
  :customWeightsMetadata
  {:weightedSchemaProperties
   [{:propertyNames [string], :documentSchemaName string}]},
  :isNlQuery boolean,
  :folderNameFilter string,
  :fileTypeFilter
  {:fileType [FILE_TYPE_UNSPECIFIED ALL FOLDER DOCUMENT ROOT_FOLDER]},
  :documentNameFilter [string],
  :propertyFilter [{:documentSchemaName string, :condition string}],
  :query string,
  :timeFilters
  [{:timeField
    [TIME_FIELD_UNSPECIFIED CREATE_TIME UPDATE_TIME DISPOSITION_TIME],
    :timeRange {:endTime string, :startTime string}}],
  :queryContext [string],
  :documentCreatorFilter [string],
  :customPropertyFilter string},
 :requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :qaSizeLimit integer,
 :requireTotalSize boolean,
 :pageToken string,
 :pageSize integer,
 :orderBy string}"
  [parent GoogleCloudContentwarehouseV1SearchDocumentsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/documents:search",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1SearchDocumentsRequest}))

(defn projects-locations-documents-setAcl
  "Sets the access control policy for a resource. Replaces any existing policy.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/setAcl

resource <string> Required. REQUIRED: The resource for which the policy is being requested. Format for document: projects/{project_number}/locations/{location}/documents/{document_id}. Format for collection: projects/{project_number}/locations/{location}/collections/{collection_id}. Format for project: projects/{project_number}.
GoogleCloudContentwarehouseV1SetAclRequest:
{:projectOwner boolean,
 :policy
 {:etag string,
  :version integer,
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:exemptedMembers [string],
      :logType
      [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ]}]}],
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:location string,
     :expression string,
     :description string,
     :title string}}]},
 :requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [resource GoogleCloudContentwarehouseV1SetAclRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+resource}:setAcl",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1SetAclRequest}))

(defn projects-locations-documents-lock
  "Lock the document so the document cannot be updated by other users.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents/lock

name <string> Required. The name of the document to lock. Format: projects/{project_number}/locations/{location}/documents/{document}.
GoogleCloudContentwarehouseV1LockDocumentRequest:
{:lockingUser {:id string, :groupIds [string]}, :collectionId string}"
  [name GoogleCloudContentwarehouseV1LockDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}:lock",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1LockDocumentRequest}))

(defn projects-locations-documents-documentLinks-delete
  "Remove the link between the source and target documents.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.documentLinks/delete

name <string> Required. The name of the document-link to be deleted. Format: projects/{project_number}/locations/{location}/documents/{source_document_id}/documentLinks/{document_link_id}.
GoogleCloudContentwarehouseV1DeleteDocumentLinkRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [name GoogleCloudContentwarehouseV1DeleteDocumentLinkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}:delete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1DeleteDocumentLinkRequest}))

(defn projects-locations-documents-documentLinks-create
  "Create a link between a source document and a target document.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.documentLinks/create

parent <string> Required. Parent of the document-link to be created. parent of document-link should be a document. Format: projects/{project_number}/locations/{location}/documents/{source_document_id}.
GoogleCloudContentwarehouseV1CreateDocumentLinkRequest:
{:documentLink
 {:createTime string,
  :sourceDocumentReference
  {:deleteTime string,
   :displayName string,
   :documentIsRetentionFolder boolean,
   :snippet string,
   :createTime string,
   :documentName string,
   :updateTime string,
   :documentIsLegalHoldFolder boolean,
   :documentIsFolder boolean},
  :description string,
  :name string,
  :state [STATE_UNSPECIFIED ACTIVE SOFT_DELETED],
  :targetDocumentReference
  {:deleteTime string,
   :displayName string,
   :documentIsRetentionFolder boolean,
   :snippet string,
   :createTime string,
   :documentName string,
   :updateTime string,
   :documentIsLegalHoldFolder boolean,
   :documentIsFolder boolean},
  :updateTime string},
 :requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [parent GoogleCloudContentwarehouseV1CreateDocumentLinkRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/documentLinks",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1CreateDocumentLinkRequest}))

(defn projects-locations-documents-referenceId-patch
  "Updates a document. Returns INVALID_ARGUMENT if the name of the document is non-empty and does not equal the existing name.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.referenceId/patch

name <string> Required. The name of the document to update. Format: projects/{project_number}/locations/{location}/documents/{document_id} or projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
GoogleCloudContentwarehouseV1UpdateDocumentRequest:
{:cloudAiDocumentOption
 {:customizedEntitiesPropertiesConversions object,
  :enableEntitiesConversions boolean},
 :requestMetadata {:userInfo {:id string, :groupIds [string]}},
 :updateOptions
 {:mergeFieldsOptions
  {:replaceMessageFields boolean, :replaceRepeatedFields boolean},
  :updateType
  [UPDATE_TYPE_UNSPECIFIED
   UPDATE_TYPE_REPLACE
   UPDATE_TYPE_MERGE
   UPDATE_TYPE_INSERT_PROPERTIES_BY_NAMES
   UPDATE_TYPE_REPLACE_PROPERTIES_BY_NAMES
   UPDATE_TYPE_DELETE_PROPERTIES_BY_NAMES
   UPDATE_TYPE_MERGE_AND_REPLACE_OR_INSERT_PROPERTIES_BY_NAMES],
  :updateMask string},
 :document
 {:properties
  [{:mapProperty {:fields object},
    :floatValues {:values [number]},
    :name string,
    :integerValues {:values [integer]},
    :dateTimeValues
    {:values
     [{:timeZone GoogleTypeTimeZone,
       :day integer,
       :nanos integer,
       :month integer,
       :seconds integer,
       :year integer,
       :utcOffset string,
       :hours integer,
       :minutes integer}]},
    :textValues {:values [string]},
    :enumValues {:values [string]},
    :timestampValues
    {:values [{:timestampValue string, :textValue string}]},
    :propertyValues
    {:properties
     [{:mapProperty GoogleCloudContentwarehouseV1MapProperty,
       :floatValues GoogleCloudContentwarehouseV1FloatArray,
       :name string,
       :integerValues GoogleCloudContentwarehouseV1IntegerArray,
       :dateTimeValues GoogleCloudContentwarehouseV1DateTimeArray,
       :textValues GoogleCloudContentwarehouseV1TextArray,
       :enumValues GoogleCloudContentwarehouseV1EnumArray,
       :timestampValues GoogleCloudContentwarehouseV1TimestampArray,
       :propertyValues GoogleCloudContentwarehouseV1PropertyArray}]}}],
  :creator string,
  :rawDocumentPath string,
  :textExtractionDisabled boolean,
  :textExtractionEnabled boolean,
  :dispositionTime string,
  :displayName string,
  :documentSchemaName string,
  :name string,
  :cloudAiDocument
  {:textChanges
   [{:provenance
     [{:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED],
       :revision integer,
       :id integer}],
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :changedText string}],
   :content string,
   :textStyles
   [{:textDecoration string,
     :color {:blue number, :alpha number, :red number, :green number},
     :backgroundColor
     {:blue number, :alpha number, :red number, :green number},
     :fontFamily string,
     :fontWeight string,
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :fontSize {:unit string, :size number},
     :textStyle string}],
   :shardInfo
   {:textOffset string, :shardIndex string, :shardCount string},
   :entities
   [{:properties
     [{:properties [GoogleCloudDocumentaiV1DocumentEntity],
       :textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :type string,
       :redacted boolean,
       :mentionText string,
       :mentionId string,
       :id string,
       :normalizedValue
       GoogleCloudDocumentaiV1DocumentEntityNormalizedValue,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :pageAnchor GoogleCloudDocumentaiV1DocumentPageAnchor,
       :confidence number}],
     :textAnchor
     {:content string,
      :textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment]},
     :type string,
     :redacted boolean,
     :mentionText string,
     :mentionId string,
     :id string,
     :normalizedValue
     {:addressValue GoogleTypePostalAddress,
      :floatValue number,
      :booleanValue boolean,
      :moneyValue GoogleTypeMoney,
      :integerValue integer,
      :dateValue GoogleTypeDate,
      :datetimeValue GoogleTypeDateTime,
      :text string},
     :provenance
     {:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED],
      :revision integer,
      :id integer},
     :pageAnchor
     {:pageRefs [GoogleCloudDocumentaiV1DocumentPageAnchorPageRef]},
     :confidence number}],
   :entityRelations
   [{:subjectId string, :relation string, :objectId string}],
   :pages
   [{:visualElements
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :type string}],
     :layout
     {:orientation
      [ORIENTATION_UNSPECIFIED PAGE_UP PAGE_RIGHT PAGE_DOWN PAGE_LEFT],
      :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
      :confidence number,
      :textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor},
     :formFields
     [{:correctedValueText string,
       :fieldName GoogleCloudDocumentaiV1DocumentPageLayout,
       :nameDetectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :fieldValue GoogleCloudDocumentaiV1DocumentPageLayout,
       :valueDetectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :valueType string,
       :correctedKeyText string}],
     :transforms
     [{:type integer, :cols integer, :data string, :rows integer}],
     :lines
     [{:provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :detectedBarcodes
     [{:barcode GoogleCloudDocumentaiV1Barcode,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout}],
     :tables
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :bodyRows [GoogleCloudDocumentaiV1DocumentPageTableTableRow],
       :headerRows
       [GoogleCloudDocumentaiV1DocumentPageTableTableRow]}],
     :paragraphs
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :imageQualityScores
     {:detectedDefects
      [GoogleCloudDocumentaiV1DocumentPageImageQualityScoresDetectedDefect],
      :qualityScore number},
     :detectedLanguages [{:confidence number, :languageCode string}],
     :dimension {:unit string, :height number, :width number},
     :provenance
     {:parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED],
      :revision integer,
      :id integer},
     :blocks
     [{:layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage]}],
     :image
     {:mimeType string,
      :content string,
      :width integer,
      :height integer},
     :tokens
     [{:provenance GoogleCloudDocumentaiV1DocumentProvenance,
       :layout GoogleCloudDocumentaiV1DocumentPageLayout,
       :detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :styleInfo GoogleCloudDocumentaiV1DocumentPageTokenStyleInfo,
       :detectedBreak
       GoogleCloudDocumentaiV1DocumentPageTokenDetectedBreak}],
     :pageNumber integer,
     :symbols
     [{:detectedLanguages
       [GoogleCloudDocumentaiV1DocumentPageDetectedLanguage],
       :layout GoogleCloudDocumentaiV1DocumentPageLayout}]}],
   :mimeType string,
   :revisions
   [{:processor string,
     :agent string,
     :createTime string,
     :parentIds [string],
     :parent [integer],
     :humanReview {:stateMessage string, :state string},
     :id string}],
   :error {:details [object], :message string, :code integer},
   :uri string,
   :text string},
  :createTime string,
  :title string,
  :updateTime string,
  :contentCategory
  [CONTENT_CATEGORY_UNSPECIFIED
   CONTENT_CATEGORY_IMAGE
   CONTENT_CATEGORY_AUDIO
   CONTENT_CATEGORY_VIDEO],
  :rawDocumentFileType
  [RAW_DOCUMENT_FILE_TYPE_UNSPECIFIED
   RAW_DOCUMENT_FILE_TYPE_PDF
   RAW_DOCUMENT_FILE_TYPE_DOCX
   RAW_DOCUMENT_FILE_TYPE_XLSX
   RAW_DOCUMENT_FILE_TYPE_PPTX
   RAW_DOCUMENT_FILE_TYPE_TEXT
   RAW_DOCUMENT_FILE_TYPE_TIFF],
  :updater string,
  :referenceId string,
  :displayUri string,
  :plainText string,
  :legalHold boolean,
  :inlineRawDocument string}}"
  [name GoogleCloudContentwarehouseV1UpdateDocumentRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1UpdateDocumentRequest}))

(defn projects-locations-documents-referenceId-delete
  "Deletes a document. Returns NOT_FOUND if the document does not exist.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.referenceId/delete

name <string> Required. The name of the document to delete. Format: projects/{project_number}/locations/{location}/documents/{document_id} or projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
GoogleCloudContentwarehouseV1DeleteDocumentRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [name GoogleCloudContentwarehouseV1DeleteDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}:delete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1DeleteDocumentRequest}))

(defn projects-locations-documents-referenceId-get
  "Gets a document. Returns NOT_FOUND if the document does not exist.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.documents.referenceId/get

name <string> Required. The name of the document to retrieve. Format: projects/{project_number}/locations/{location}/documents/{document_id} or projects/{project_number}/locations/{location}/documents/referenceId/{reference_id}.
GoogleCloudContentwarehouseV1GetDocumentRequest:
{:requestMetadata {:userInfo {:id string, :groupIds [string]}}}"
  [name GoogleCloudContentwarehouseV1GetDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}:get",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1GetDocumentRequest}))

(defn projects-locations-synonymSets-delete
  "Deletes a SynonymSet for a given context. Throws a NOT_FOUND exception if the SynonymSet is not found.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/delete

name <string> Required. The name of the synonymSet to delete Format: projects/{project_number}/locations/{location}/synonymSets/{context}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-synonymSets-get
  "Gets a SynonymSet for a particular context. Throws a NOT_FOUND exception if the Synonymset does not exist
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/get

name <string> Required. The name of the synonymSet to retrieve Format: projects/{project_number}/locations/{location}/synonymSets/{context}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-synonymSets-list
  "Returns all SynonymSets (for all contexts) for the specified location.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/list

parent <string> Required. The parent name. Format: projects/{project_number}/locations/{location}.

optional:
pageSize <integer> The maximum number of synonymSets to return. The service may return fewer than this value. If unspecified, at most 50 rule sets will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-synonymSets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contentwarehouse.googleapis.com/v1/{+parent}/synonymSets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-synonymSets-patch
  "Remove the existing SynonymSet for the context and replaces it with a new one. Throws a NOT_FOUND exception if the SynonymSet is not found.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/patch

name <string> Required. The name of the synonymSet to update Format: projects/{project_number}/locations/{location}/synonymSets/{context}.
GoogleCloudContentwarehouseV1SynonymSet:
{:synonyms [{:words [string]}], :context string, :name string}"
  [name GoogleCloudContentwarehouseV1SynonymSet]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1SynonymSet}))

(defn projects-locations-synonymSets-create
  "Creates a SynonymSet for a single context. Throws an ALREADY_EXISTS exception if a synonymset already exists for the context.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.synonymSets/create

parent <string> Required. The parent name. Format: projects/{project_number}/locations/{location}.
GoogleCloudContentwarehouseV1SynonymSet:
{:synonyms [{:words [string]}], :context string, :name string}"
  [parent GoogleCloudContentwarehouseV1SynonymSet]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+parent}/synonymSets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContentwarehouseV1SynonymSet}))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/document-warehouse/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contentwarehouse.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

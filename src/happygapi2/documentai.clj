(ns happygapi2.documentai
  "Cloud Document AI API
Service to parse structured information from unstructured or semi-structured documents using state-of-the-art Google AI such as natural language, computer vision, translation, and AutoML.
See: https://cloud.google.com/document-ai/docs/"
  (:require [happy.oauth2.client :as client]))

(defn projects-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-fetchProcessorTypes
  "Fetches processor types. Note that we don't use ListProcessorTypes here, because it isn't paginated.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations/fetchProcessorTypes

parent <string> Required. The location of processor types to list. Format: `projects/{project}/locations/{location}`."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://documentai.googleapis.com/v1/{+parent}:fetchProcessorTypes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://documentai.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://documentai.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processors-disable
  "Disables a processor
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/disable

name <string> Required. The processor resource name to be disabled.
GoogleCloudDocumentaiV1DisableProcessorRequest:
object"
  [name GoogleCloudDocumentaiV1DisableProcessorRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:disable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1DisableProcessorRequest}))

(defn projects-locations-processors-setDefaultProcessorVersion
  "Set the default (active) version of a Processor that will be used in ProcessDocument and BatchProcessDocuments.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/setDefaultProcessorVersion

processor <string> Required. The resource name of the Processor to change default version.
GoogleCloudDocumentaiV1SetDefaultProcessorVersionRequest:
{:defaultProcessorVersion string}"
  [processor GoogleCloudDocumentaiV1SetDefaultProcessorVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+processor}:setDefaultProcessorVersion",
     :uri-template-args {:processor processor},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1SetDefaultProcessorVersionRequest}))

(defn projects-locations-processors-get
  "Gets a processor detail.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/get

name <string> Required. The processor resource name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processors-enable
  "Enables a processor
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/enable

name <string> Required. The processor resource name to be enabled.
GoogleCloudDocumentaiV1EnableProcessorRequest:
object"
  [name GoogleCloudDocumentaiV1EnableProcessorRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:enable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1EnableProcessorRequest}))

(defn projects-locations-processors-create
  "Creates a processor from the ProcessorType provided. The processor will be at `ENABLED` state by default after its creation. Note that this method requires the `documentai.processors.create` permission on the project, which is highly privileged. A user or service account with this permission can create new processors that can interact with any gcs bucket in your project.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/create

parent <string> Required. The parent (project and location) under which to create the processor. Format: `projects/{project}/locations/{location}`
GoogleCloudDocumentaiV1Processor:
{:satisfiesPzi boolean,
 :displayName string,
 :name string,
 :createTime string,
 :type string,
 :state
 [STATE_UNSPECIFIED
  ENABLED
  DISABLED
  ENABLING
  DISABLING
  CREATING
  FAILED
  DELETING],
 :satisfiesPzs boolean,
 :kmsKeyName string,
 :processorVersionAliases [{:alias string, :processorVersion string}],
 :processEndpoint string,
 :defaultProcessorVersion string}"
  [parent GoogleCloudDocumentaiV1Processor]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+parent}/processors",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1Processor}))

(defn projects-locations-processors-process
  "Processes a single document.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/process

name <string> Required. The resource name of the Processor or ProcessorVersion to use for processing. If a Processor is specified, the server will use its default version. Format: `projects/{project}/locations/{location}/processors/{processor}`, or `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
GoogleCloudDocumentaiV1ProcessRequest:
{:inlineDocument
 {:textChanges
  [{:textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :changedText string,
    :provenance
    [{:revision integer,
      :id integer,
      :parents [{:revision integer, :index integer, :id integer}],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED]}]}],
  :chunkedDocument
  {:chunks
   [{:chunkId string,
     :sourceBlockIds [string],
     :content string,
     :pageSpan {:pageStart integer, :pageEnd integer},
     :pageHeaders
     [{:text string,
       :pageSpan
       GoogleCloudDocumentaiV1DocumentChunkedDocumentChunkChunkPageSpan}],
     :pageFooters
     [{:text string,
       :pageSpan
       GoogleCloudDocumentaiV1DocumentChunkedDocumentChunkChunkPageSpan}]}]},
  :content string,
  :textStyles
  [{:textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :color {:red number, :green number, :blue number, :alpha number},
    :backgroundColor
    {:red number, :green number, :blue number, :alpha number},
    :fontWeight string,
    :textStyle string,
    :textDecoration string,
    :fontSize {:size number, :unit string},
    :fontFamily string}],
  :shardInfo
  {:shardIndex string, :shardCount string, :textOffset string},
  :entities
  [{:properties
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
      {:textSegments
       [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment],
       :content string},
      :type string,
      :redacted boolean,
      :mentionText string,
      :mentionId string,
      :id string,
      :normalizedValue
      {:moneyValue GoogleTypeMoney,
       :dateValue GoogleTypeDate,
       :datetimeValue GoogleTypeDateTime,
       :addressValue GoogleTypePostalAddress,
       :booleanValue boolean,
       :integerValue integer,
       :floatValue number,
       :text string},
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]},
      :pageAnchor
      {:pageRefs [GoogleCloudDocumentaiV1DocumentPageAnchorPageRef]},
      :confidence number}],
    :textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :type string,
    :redacted boolean,
    :mentionText string,
    :mentionId string,
    :id string,
    :normalizedValue
    {:moneyValue {:currencyCode string, :units string, :nanos integer},
     :dateValue {:year integer, :month integer, :day integer},
     :datetimeValue
     {:timeZone GoogleTypeTimeZone,
      :day integer,
      :nanos integer,
      :month integer,
      :seconds integer,
      :year integer,
      :utcOffset string,
      :hours integer,
      :minutes integer},
     :addressValue
     {:sortingCode string,
      :locality string,
      :revision integer,
      :administrativeArea string,
      :addressLines [string],
      :organization string,
      :recipients [string],
      :languageCode string,
      :regionCode string,
      :postalCode string,
      :sublocality string},
     :booleanValue boolean,
     :integerValue integer,
     :floatValue number,
     :text string},
    :provenance
    {:revision integer,
     :id integer,
     :parents [{:revision integer, :index integer, :id integer}],
     :type
     [OPERATION_TYPE_UNSPECIFIED
      ADD
      REMOVE
      UPDATE
      REPLACE
      EVAL_REQUESTED
      EVAL_APPROVED
      EVAL_SKIPPED]},
    :pageAnchor
    {:pageRefs
     [{:page string,
       :layoutType
       [LAYOUT_TYPE_UNSPECIFIED
        BLOCK
        PARAGRAPH
        LINE
        TOKEN
        VISUAL_ELEMENT
        TABLE
        FORM_FIELD],
       :layoutId string,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :confidence number}]},
    :confidence number}],
  :entityRelations
  [{:subjectId string, :objectId string, :relation string}],
  :pages
  [{:visualElements
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :type string,
      :detectedLanguages
      [{:languageCode string, :confidence number}]}],
    :layout
    {:textAnchor
     {:textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment],
      :content string},
     :confidence number,
     :boundingPoly
     {:vertices [GoogleCloudDocumentaiV1Vertex],
      :normalizedVertices [GoogleCloudDocumentaiV1NormalizedVertex]},
     :orientation
     [ORIENTATION_UNSPECIFIED PAGE_UP PAGE_RIGHT PAGE_DOWN PAGE_LEFT]},
    :formFields
    [{:fieldName
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :fieldValue
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :nameDetectedLanguages
      [{:languageCode string, :confidence number}],
      :valueDetectedLanguages
      [{:languageCode string, :confidence number}],
      :valueType string,
      :correctedKeyText string,
      :correctedValueText string,
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :transforms
    [{:rows integer, :cols integer, :type integer, :data string}],
    :lines
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :detectedBarcodes
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :barcode
      {:format string, :valueFormat string, :rawValue string}}],
    :tables
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :headerRows
      [{:cells [GoogleCloudDocumentaiV1DocumentPageTableTableCell]}],
      :bodyRows
      [{:cells [GoogleCloudDocumentaiV1DocumentPageTableTableCell]}],
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :paragraphs
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :imageQualityScores
    {:qualityScore number,
     :detectedDefects [{:type string, :confidence number}]},
    :detectedLanguages [{:languageCode string, :confidence number}],
    :dimension {:width number, :height number, :unit string},
    :provenance
    {:revision integer,
     :id integer,
     :parents [{:revision integer, :index integer, :id integer}],
     :type
     [OPERATION_TYPE_UNSPECIFIED
      ADD
      REMOVE
      UPDATE
      REPLACE
      EVAL_REQUESTED
      EVAL_APPROVED
      EVAL_SKIPPED]},
    :blocks
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :image
    {:content string,
     :mimeType string,
     :width integer,
     :height integer},
    :tokens
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedBreak
      {:type [TYPE_UNSPECIFIED SPACE WIDE_SPACE HYPHEN]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]},
      :styleInfo
      {:superscript boolean,
       :bold boolean,
       :smallcaps boolean,
       :handwritten boolean,
       :pixelFontSize number,
       :subscript boolean,
       :textColor GoogleTypeColor,
       :letterSpacing number,
       :fontType string,
       :underlined boolean,
       :fontWeight integer,
       :fontSize integer,
       :backgroundColor GoogleTypeColor,
       :italic boolean,
       :strikeout boolean}}],
    :pageNumber integer,
    :symbols
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages
      [{:languageCode string, :confidence number}]}]}],
  :documentLayout
  {:blocks
   [{:textBlock
     {:text string,
      :type string,
      :blocks
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlock]},
     :tableBlock
     {:headerRows
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutTableRow],
      :bodyRows
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutTableRow],
      :caption string},
     :listBlock
     {:listEntries
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutListEntry],
      :type string},
     :blockId string,
     :pageSpan {:pageStart integer, :pageEnd integer}}]},
  :mimeType string,
  :revisions
  [{:agent string,
    :processor string,
    :id string,
    :parent [integer],
    :parentIds [string],
    :createTime string,
    :humanReview {:state string, :stateMessage string}}],
  :error {:code integer, :message string, :details [object]},
  :uri string,
  :text string},
 :rawDocument {:content string, :mimeType string, :displayName string},
 :gcsDocument {:gcsUri string, :mimeType string},
 :skipHumanReview boolean,
 :fieldMask string,
 :processOptions
 {:individualPageSelector {:pages [integer]},
  :fromStart integer,
  :fromEnd integer,
  :ocrConfig
  {:hints {:languageHints [string]},
   :enableNativePdfParsing boolean,
   :enableImageQualityScores boolean,
   :advancedOcrOptions [string],
   :enableSymbol boolean,
   :computeStyleInfo boolean,
   :disableCharacterBoxesDetection boolean,
   :premiumFeatures
   {:enableSelectionMarkDetection boolean,
    :computeStyleInfo boolean,
    :enableMathOcr boolean}},
  :layoutConfig
  {:chunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :schemaOverride
  {:displayName string,
   :description string,
   :entityTypes
   [{:enumValues {:values [string]},
     :displayName string,
     :name string,
     :baseTypes [string],
     :properties
     [{:name string,
       :displayName string,
       :valueType string,
       :occurrenceType
       [OCCURRENCE_TYPE_UNSPECIFIED
        OPTIONAL_ONCE
        OPTIONAL_MULTIPLE
        REQUIRED_ONCE
        REQUIRED_MULTIPLE]}]}],
   :metadata
   {:documentSplitter boolean,
    :documentAllowMultipleLabels boolean,
    :prefixedNamingOnProperties boolean,
    :skipNamingValidation boolean}}},
 :labels object}"
  [name GoogleCloudDocumentaiV1ProcessRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:process",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1ProcessRequest}))

(defn projects-locations-processors-delete
  "Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes all artifacts associated with this processor.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/delete

name <string> Required. The processor resource name to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processors-list
  "Lists all processors which belong to this project.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/list

parent <string> Required. The parent (project and location) which owns this collection of Processors. Format: `projects/{project}/locations/{location}`

optional:
pageSize <integer> The maximum number of processors to return. If unspecified, at most `50` processors will be returned. The maximum value is `100`. Values above `100` will be coerced to `100`."
  ([parent] (projects-locations-processors-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://documentai.googleapis.com/v1/{+parent}/processors",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processors-batchProcess
  "LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in the [Document] format.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors/batchProcess

name <string> Required. The resource name of Processor or ProcessorVersion. Format: `projects/{project}/locations/{location}/processors/{processor}`, or `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
GoogleCloudDocumentaiV1BatchProcessRequest:
{:inputDocuments
 {:gcsPrefix {:gcsUriPrefix string},
  :gcsDocuments {:documents [{:gcsUri string, :mimeType string}]}},
 :documentOutputConfig
 {:gcsOutputConfig
  {:gcsUri string,
   :fieldMask string,
   :shardingConfig {:pagesPerShard integer, :pagesOverlap integer}}},
 :skipHumanReview boolean,
 :processOptions
 {:individualPageSelector {:pages [integer]},
  :fromStart integer,
  :fromEnd integer,
  :ocrConfig
  {:hints {:languageHints [string]},
   :enableNativePdfParsing boolean,
   :enableImageQualityScores boolean,
   :advancedOcrOptions [string],
   :enableSymbol boolean,
   :computeStyleInfo boolean,
   :disableCharacterBoxesDetection boolean,
   :premiumFeatures
   {:enableSelectionMarkDetection boolean,
    :computeStyleInfo boolean,
    :enableMathOcr boolean}},
  :layoutConfig
  {:chunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :schemaOverride
  {:displayName string,
   :description string,
   :entityTypes
   [{:enumValues {:values [string]},
     :displayName string,
     :name string,
     :baseTypes [string],
     :properties
     [{:name string,
       :displayName string,
       :valueType string,
       :occurrenceType
       [OCCURRENCE_TYPE_UNSPECIFIED
        OPTIONAL_ONCE
        OPTIONAL_MULTIPLE
        REQUIRED_ONCE
        REQUIRED_MULTIPLE]}]}],
   :metadata
   {:documentSplitter boolean,
    :documentAllowMultipleLabels boolean,
    :prefixedNamingOnProperties boolean,
    :skipNamingValidation boolean}}},
 :labels object}"
  [name GoogleCloudDocumentaiV1BatchProcessRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:batchProcess",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1BatchProcessRequest}))

(defn projects-locations-processors-processorVersions-undeploy
  "Undeploys the processor version.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/undeploy

name <string> Required. The processor version resource name to be undeployed.
GoogleCloudDocumentaiV1UndeployProcessorVersionRequest:
object"
  [name GoogleCloudDocumentaiV1UndeployProcessorVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:undeploy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1UndeployProcessorVersionRequest}))

(defn projects-locations-processors-processorVersions-get
  "Gets a processor version detail.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/get

name <string> Required. The processor resource name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processors-processorVersions-process
  "Processes a single document.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/process

name <string> Required. The resource name of the Processor or ProcessorVersion to use for processing. If a Processor is specified, the server will use its default version. Format: `projects/{project}/locations/{location}/processors/{processor}`, or `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
GoogleCloudDocumentaiV1ProcessRequest:
{:inlineDocument
 {:textChanges
  [{:textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :changedText string,
    :provenance
    [{:revision integer,
      :id integer,
      :parents [{:revision integer, :index integer, :id integer}],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED]}]}],
  :chunkedDocument
  {:chunks
   [{:chunkId string,
     :sourceBlockIds [string],
     :content string,
     :pageSpan {:pageStart integer, :pageEnd integer},
     :pageHeaders
     [{:text string,
       :pageSpan
       GoogleCloudDocumentaiV1DocumentChunkedDocumentChunkChunkPageSpan}],
     :pageFooters
     [{:text string,
       :pageSpan
       GoogleCloudDocumentaiV1DocumentChunkedDocumentChunkChunkPageSpan}]}]},
  :content string,
  :textStyles
  [{:textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :color {:red number, :green number, :blue number, :alpha number},
    :backgroundColor
    {:red number, :green number, :blue number, :alpha number},
    :fontWeight string,
    :textStyle string,
    :textDecoration string,
    :fontSize {:size number, :unit string},
    :fontFamily string}],
  :shardInfo
  {:shardIndex string, :shardCount string, :textOffset string},
  :entities
  [{:properties
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
      {:textSegments
       [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment],
       :content string},
      :type string,
      :redacted boolean,
      :mentionText string,
      :mentionId string,
      :id string,
      :normalizedValue
      {:moneyValue GoogleTypeMoney,
       :dateValue GoogleTypeDate,
       :datetimeValue GoogleTypeDateTime,
       :addressValue GoogleTypePostalAddress,
       :booleanValue boolean,
       :integerValue integer,
       :floatValue number,
       :text string},
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]},
      :pageAnchor
      {:pageRefs [GoogleCloudDocumentaiV1DocumentPageAnchorPageRef]},
      :confidence number}],
    :textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :type string,
    :redacted boolean,
    :mentionText string,
    :mentionId string,
    :id string,
    :normalizedValue
    {:moneyValue {:currencyCode string, :units string, :nanos integer},
     :dateValue {:year integer, :month integer, :day integer},
     :datetimeValue
     {:timeZone GoogleTypeTimeZone,
      :day integer,
      :nanos integer,
      :month integer,
      :seconds integer,
      :year integer,
      :utcOffset string,
      :hours integer,
      :minutes integer},
     :addressValue
     {:sortingCode string,
      :locality string,
      :revision integer,
      :administrativeArea string,
      :addressLines [string],
      :organization string,
      :recipients [string],
      :languageCode string,
      :regionCode string,
      :postalCode string,
      :sublocality string},
     :booleanValue boolean,
     :integerValue integer,
     :floatValue number,
     :text string},
    :provenance
    {:revision integer,
     :id integer,
     :parents [{:revision integer, :index integer, :id integer}],
     :type
     [OPERATION_TYPE_UNSPECIFIED
      ADD
      REMOVE
      UPDATE
      REPLACE
      EVAL_REQUESTED
      EVAL_APPROVED
      EVAL_SKIPPED]},
    :pageAnchor
    {:pageRefs
     [{:page string,
       :layoutType
       [LAYOUT_TYPE_UNSPECIFIED
        BLOCK
        PARAGRAPH
        LINE
        TOKEN
        VISUAL_ELEMENT
        TABLE
        FORM_FIELD],
       :layoutId string,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :confidence number}]},
    :confidence number}],
  :entityRelations
  [{:subjectId string, :objectId string, :relation string}],
  :pages
  [{:visualElements
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :type string,
      :detectedLanguages
      [{:languageCode string, :confidence number}]}],
    :layout
    {:textAnchor
     {:textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment],
      :content string},
     :confidence number,
     :boundingPoly
     {:vertices [GoogleCloudDocumentaiV1Vertex],
      :normalizedVertices [GoogleCloudDocumentaiV1NormalizedVertex]},
     :orientation
     [ORIENTATION_UNSPECIFIED PAGE_UP PAGE_RIGHT PAGE_DOWN PAGE_LEFT]},
    :formFields
    [{:fieldName
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :fieldValue
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :nameDetectedLanguages
      [{:languageCode string, :confidence number}],
      :valueDetectedLanguages
      [{:languageCode string, :confidence number}],
      :valueType string,
      :correctedKeyText string,
      :correctedValueText string,
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :transforms
    [{:rows integer, :cols integer, :type integer, :data string}],
    :lines
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :detectedBarcodes
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :barcode
      {:format string, :valueFormat string, :rawValue string}}],
    :tables
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :headerRows
      [{:cells [GoogleCloudDocumentaiV1DocumentPageTableTableCell]}],
      :bodyRows
      [{:cells [GoogleCloudDocumentaiV1DocumentPageTableTableCell]}],
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :paragraphs
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :imageQualityScores
    {:qualityScore number,
     :detectedDefects [{:type string, :confidence number}]},
    :detectedLanguages [{:languageCode string, :confidence number}],
    :dimension {:width number, :height number, :unit string},
    :provenance
    {:revision integer,
     :id integer,
     :parents [{:revision integer, :index integer, :id integer}],
     :type
     [OPERATION_TYPE_UNSPECIFIED
      ADD
      REMOVE
      UPDATE
      REPLACE
      EVAL_REQUESTED
      EVAL_APPROVED
      EVAL_SKIPPED]},
    :blocks
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :image
    {:content string,
     :mimeType string,
     :width integer,
     :height integer},
    :tokens
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedBreak
      {:type [TYPE_UNSPECIFIED SPACE WIDE_SPACE HYPHEN]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]},
      :styleInfo
      {:superscript boolean,
       :bold boolean,
       :smallcaps boolean,
       :handwritten boolean,
       :pixelFontSize number,
       :subscript boolean,
       :textColor GoogleTypeColor,
       :letterSpacing number,
       :fontType string,
       :underlined boolean,
       :fontWeight integer,
       :fontSize integer,
       :backgroundColor GoogleTypeColor,
       :italic boolean,
       :strikeout boolean}}],
    :pageNumber integer,
    :symbols
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages
      [{:languageCode string, :confidence number}]}]}],
  :documentLayout
  {:blocks
   [{:textBlock
     {:text string,
      :type string,
      :blocks
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlock]},
     :tableBlock
     {:headerRows
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutTableRow],
      :bodyRows
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutTableRow],
      :caption string},
     :listBlock
     {:listEntries
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutListEntry],
      :type string},
     :blockId string,
     :pageSpan {:pageStart integer, :pageEnd integer}}]},
  :mimeType string,
  :revisions
  [{:agent string,
    :processor string,
    :id string,
    :parent [integer],
    :parentIds [string],
    :createTime string,
    :humanReview {:state string, :stateMessage string}}],
  :error {:code integer, :message string, :details [object]},
  :uri string,
  :text string},
 :rawDocument {:content string, :mimeType string, :displayName string},
 :gcsDocument {:gcsUri string, :mimeType string},
 :skipHumanReview boolean,
 :fieldMask string,
 :processOptions
 {:individualPageSelector {:pages [integer]},
  :fromStart integer,
  :fromEnd integer,
  :ocrConfig
  {:hints {:languageHints [string]},
   :enableNativePdfParsing boolean,
   :enableImageQualityScores boolean,
   :advancedOcrOptions [string],
   :enableSymbol boolean,
   :computeStyleInfo boolean,
   :disableCharacterBoxesDetection boolean,
   :premiumFeatures
   {:enableSelectionMarkDetection boolean,
    :computeStyleInfo boolean,
    :enableMathOcr boolean}},
  :layoutConfig
  {:chunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :schemaOverride
  {:displayName string,
   :description string,
   :entityTypes
   [{:enumValues {:values [string]},
     :displayName string,
     :name string,
     :baseTypes [string],
     :properties
     [{:name string,
       :displayName string,
       :valueType string,
       :occurrenceType
       [OCCURRENCE_TYPE_UNSPECIFIED
        OPTIONAL_ONCE
        OPTIONAL_MULTIPLE
        REQUIRED_ONCE
        REQUIRED_MULTIPLE]}]}],
   :metadata
   {:documentSplitter boolean,
    :documentAllowMultipleLabels boolean,
    :prefixedNamingOnProperties boolean,
    :skipNamingValidation boolean}}},
 :labels object}"
  [name GoogleCloudDocumentaiV1ProcessRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:process",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1ProcessRequest}))

(defn projects-locations-processors-processorVersions-delete
  "Deletes the processor version, all artifacts under the processor version will be deleted.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/delete

name <string> Required. The processor version resource name to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processors-processorVersions-train
  "Trains a new processor version. Operation metadata is returned as TrainProcessorVersionMetadata.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/train

parent <string> Required. The parent (project, location and processor) to create the new version for. Format: `projects/{project}/locations/{location}/processors/{processor}`.
GoogleCloudDocumentaiV1TrainProcessorVersionRequest:
{:customDocumentExtractionOptions
 {:trainingMethod
  [TRAINING_METHOD_UNSPECIFIED MODEL_BASED TEMPLATE_BASED]},
 :foundationModelTuningOptions
 {:trainSteps integer, :learningRateMultiplier number},
 :processorVersion
 {:modelType
  [MODEL_TYPE_UNSPECIFIED MODEL_TYPE_GENERATIVE MODEL_TYPE_CUSTOM],
  :deprecationInfo
  {:deprecationTime string, :replacementProcessorVersion string},
  :kmsKeyVersionName string,
  :satisfiesPzi boolean,
  :displayName string,
  :name string,
  :createTime string,
  :state
  [STATE_UNSPECIFIED
   DEPLOYED
   DEPLOYING
   UNDEPLOYED
   UNDEPLOYING
   CREATING
   DELETING
   FAILED
   IMPORTING],
  :googleManaged boolean,
  :satisfiesPzs boolean,
  :latestEvaluation
  {:operation string,
   :evaluation string,
   :aggregateMetrics
   {:falsePositivesCount integer,
    :falseNegativesCount integer,
    :totalDocumentsCount integer,
    :precision number,
    :groundTruthDocumentCount integer,
    :recall number,
    :predictedDocumentCount integer,
    :truePositivesCount integer,
    :predictedOccurrencesCount integer,
    :groundTruthOccurrencesCount integer,
    :f1Score number},
   :aggregateMetricsExact
   {:falsePositivesCount integer,
    :falseNegativesCount integer,
    :totalDocumentsCount integer,
    :precision number,
    :groundTruthDocumentCount integer,
    :recall number,
    :predictedDocumentCount integer,
    :truePositivesCount integer,
    :predictedOccurrencesCount integer,
    :groundTruthOccurrencesCount integer,
    :f1Score number}},
  :kmsKeyName string,
  :documentSchema
  {:displayName string,
   :description string,
   :entityTypes
   [{:enumValues {:values [string]},
     :displayName string,
     :name string,
     :baseTypes [string],
     :properties
     [{:name string,
       :displayName string,
       :valueType string,
       :occurrenceType
       [OCCURRENCE_TYPE_UNSPECIFIED
        OPTIONAL_ONCE
        OPTIONAL_MULTIPLE
        REQUIRED_ONCE
        REQUIRED_MULTIPLE]}]}],
   :metadata
   {:documentSplitter boolean,
    :documentAllowMultipleLabels boolean,
    :prefixedNamingOnProperties boolean,
    :skipNamingValidation boolean}}},
 :documentSchema
 {:displayName string,
  :description string,
  :entityTypes
  [{:enumValues {:values [string]},
    :displayName string,
    :name string,
    :baseTypes [string],
    :properties
    [{:name string,
      :displayName string,
      :valueType string,
      :occurrenceType
      [OCCURRENCE_TYPE_UNSPECIFIED
       OPTIONAL_ONCE
       OPTIONAL_MULTIPLE
       REQUIRED_ONCE
       REQUIRED_MULTIPLE]}]}],
  :metadata
  {:documentSplitter boolean,
   :documentAllowMultipleLabels boolean,
   :prefixedNamingOnProperties boolean,
   :skipNamingValidation boolean}},
 :inputData
 {:trainingDocuments
  {:gcsPrefix {:gcsUriPrefix string},
   :gcsDocuments {:documents [{:gcsUri string, :mimeType string}]}},
  :testDocuments
  {:gcsPrefix {:gcsUriPrefix string},
   :gcsDocuments {:documents [{:gcsUri string, :mimeType string}]}}},
 :baseProcessorVersion string}"
  [parent GoogleCloudDocumentaiV1TrainProcessorVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+parent}/processorVersions:train",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1TrainProcessorVersionRequest}))

(defn projects-locations-processors-processorVersions-list
  "Lists all versions of a processor.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/list

parent <string> Required. The parent (project, location and processor) to list all versions. Format: `projects/{project}/locations/{location}/processors/{processor}`

optional:
pageSize <integer> The maximum number of processor versions to return. If unspecified, at most `10` processor versions will be returned. The maximum value is `20`. Values above `20` will be coerced to `20`."
  ([parent]
    (projects-locations-processors-processorVersions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://documentai.googleapis.com/v1/{+parent}/processorVersions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processors-processorVersions-batchProcess
  "LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in the [Document] format.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/batchProcess

name <string> Required. The resource name of Processor or ProcessorVersion. Format: `projects/{project}/locations/{location}/processors/{processor}`, or `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
GoogleCloudDocumentaiV1BatchProcessRequest:
{:inputDocuments
 {:gcsPrefix {:gcsUriPrefix string},
  :gcsDocuments {:documents [{:gcsUri string, :mimeType string}]}},
 :documentOutputConfig
 {:gcsOutputConfig
  {:gcsUri string,
   :fieldMask string,
   :shardingConfig {:pagesPerShard integer, :pagesOverlap integer}}},
 :skipHumanReview boolean,
 :processOptions
 {:individualPageSelector {:pages [integer]},
  :fromStart integer,
  :fromEnd integer,
  :ocrConfig
  {:hints {:languageHints [string]},
   :enableNativePdfParsing boolean,
   :enableImageQualityScores boolean,
   :advancedOcrOptions [string],
   :enableSymbol boolean,
   :computeStyleInfo boolean,
   :disableCharacterBoxesDetection boolean,
   :premiumFeatures
   {:enableSelectionMarkDetection boolean,
    :computeStyleInfo boolean,
    :enableMathOcr boolean}},
  :layoutConfig
  {:chunkingConfig
   {:chunkSize integer, :includeAncestorHeadings boolean}},
  :schemaOverride
  {:displayName string,
   :description string,
   :entityTypes
   [{:enumValues {:values [string]},
     :displayName string,
     :name string,
     :baseTypes [string],
     :properties
     [{:name string,
       :displayName string,
       :valueType string,
       :occurrenceType
       [OCCURRENCE_TYPE_UNSPECIFIED
        OPTIONAL_ONCE
        OPTIONAL_MULTIPLE
        REQUIRED_ONCE
        REQUIRED_MULTIPLE]}]}],
   :metadata
   {:documentSplitter boolean,
    :documentAllowMultipleLabels boolean,
    :prefixedNamingOnProperties boolean,
    :skipNamingValidation boolean}}},
 :labels object}"
  [name GoogleCloudDocumentaiV1BatchProcessRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:batchProcess",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1BatchProcessRequest}))

(defn projects-locations-processors-processorVersions-evaluateProcessorVersion
  "Evaluates a ProcessorVersion against annotated documents, producing an Evaluation.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/evaluateProcessorVersion

processorVersion <string> Required. The resource name of the ProcessorVersion to evaluate. `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`
GoogleCloudDocumentaiV1EvaluateProcessorVersionRequest:
{:evaluationDocuments
 {:gcsPrefix {:gcsUriPrefix string},
  :gcsDocuments {:documents [{:gcsUri string, :mimeType string}]}}}"
  [processorVersion
   GoogleCloudDocumentaiV1EvaluateProcessorVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+processorVersion}:evaluateProcessorVersion",
     :uri-template-args {:processorVersion processorVersion},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1EvaluateProcessorVersionRequest}))

(defn projects-locations-processors-processorVersions-deploy
  "Deploys the processor version.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions/deploy

name <string> Required. The processor version resource name to be deployed.
GoogleCloudDocumentaiV1DeployProcessorVersionRequest:
object"
  [name GoogleCloudDocumentaiV1DeployProcessorVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+name}:deploy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1DeployProcessorVersionRequest}))

(defn projects-locations-processors-processorVersions-evaluations-get
  "Retrieves a specific evaluation.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions.evaluations/get

name <string> Required. The resource name of the Evaluation to get. `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}/evaluations/{evaluation}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-processors-processorVersions-evaluations-list
  "Retrieves a set of evaluations for a given processor version.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.processorVersions.evaluations/list

parent <string> Required. The resource name of the ProcessorVersion to list evaluations for. `projects/{project}/locations/{location}/processors/{processor}/processorVersions/{processorVersion}`

optional:
pageSize <integer> The standard list page size. If unspecified, at most `5` evaluations are returned. The maximum value is `100`. Values above `100` are coerced to `100`."
  ([parent]
    (projects-locations-processors-processorVersions-evaluations-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://documentai.googleapis.com/v1/{+parent}/evaluations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processors-humanReviewConfig-reviewDocument
  "Send a document for Human Review. The input document should be processed by the specified processor.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processors.humanReviewConfig/reviewDocument

humanReviewConfig <string> Required. The resource name of the HumanReviewConfig that the document will be reviewed with.
GoogleCloudDocumentaiV1ReviewDocumentRequest:
{:inlineDocument
 {:textChanges
  [{:textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :changedText string,
    :provenance
    [{:revision integer,
      :id integer,
      :parents [{:revision integer, :index integer, :id integer}],
      :type
      [OPERATION_TYPE_UNSPECIFIED
       ADD
       REMOVE
       UPDATE
       REPLACE
       EVAL_REQUESTED
       EVAL_APPROVED
       EVAL_SKIPPED]}]}],
  :chunkedDocument
  {:chunks
   [{:chunkId string,
     :sourceBlockIds [string],
     :content string,
     :pageSpan {:pageStart integer, :pageEnd integer},
     :pageHeaders
     [{:text string,
       :pageSpan
       GoogleCloudDocumentaiV1DocumentChunkedDocumentChunkChunkPageSpan}],
     :pageFooters
     [{:text string,
       :pageSpan
       GoogleCloudDocumentaiV1DocumentChunkedDocumentChunkChunkPageSpan}]}]},
  :content string,
  :textStyles
  [{:textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :color {:red number, :green number, :blue number, :alpha number},
    :backgroundColor
    {:red number, :green number, :blue number, :alpha number},
    :fontWeight string,
    :textStyle string,
    :textDecoration string,
    :fontSize {:size number, :unit string},
    :fontFamily string}],
  :shardInfo
  {:shardIndex string, :shardCount string, :textOffset string},
  :entities
  [{:properties
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
      {:textSegments
       [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment],
       :content string},
      :type string,
      :redacted boolean,
      :mentionText string,
      :mentionId string,
      :id string,
      :normalizedValue
      {:moneyValue GoogleTypeMoney,
       :dateValue GoogleTypeDate,
       :datetimeValue GoogleTypeDateTime,
       :addressValue GoogleTypePostalAddress,
       :booleanValue boolean,
       :integerValue integer,
       :floatValue number,
       :text string},
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]},
      :pageAnchor
      {:pageRefs [GoogleCloudDocumentaiV1DocumentPageAnchorPageRef]},
      :confidence number}],
    :textAnchor
    {:textSegments [{:startIndex string, :endIndex string}],
     :content string},
    :type string,
    :redacted boolean,
    :mentionText string,
    :mentionId string,
    :id string,
    :normalizedValue
    {:moneyValue {:currencyCode string, :units string, :nanos integer},
     :dateValue {:year integer, :month integer, :day integer},
     :datetimeValue
     {:timeZone GoogleTypeTimeZone,
      :day integer,
      :nanos integer,
      :month integer,
      :seconds integer,
      :year integer,
      :utcOffset string,
      :hours integer,
      :minutes integer},
     :addressValue
     {:sortingCode string,
      :locality string,
      :revision integer,
      :administrativeArea string,
      :addressLines [string],
      :organization string,
      :recipients [string],
      :languageCode string,
      :regionCode string,
      :postalCode string,
      :sublocality string},
     :booleanValue boolean,
     :integerValue integer,
     :floatValue number,
     :text string},
    :provenance
    {:revision integer,
     :id integer,
     :parents [{:revision integer, :index integer, :id integer}],
     :type
     [OPERATION_TYPE_UNSPECIFIED
      ADD
      REMOVE
      UPDATE
      REPLACE
      EVAL_REQUESTED
      EVAL_APPROVED
      EVAL_SKIPPED]},
    :pageAnchor
    {:pageRefs
     [{:page string,
       :layoutType
       [LAYOUT_TYPE_UNSPECIFIED
        BLOCK
        PARAGRAPH
        LINE
        TOKEN
        VISUAL_ELEMENT
        TABLE
        FORM_FIELD],
       :layoutId string,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :confidence number}]},
    :confidence number}],
  :entityRelations
  [{:subjectId string, :objectId string, :relation string}],
  :pages
  [{:visualElements
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :type string,
      :detectedLanguages
      [{:languageCode string, :confidence number}]}],
    :layout
    {:textAnchor
     {:textSegments
      [GoogleCloudDocumentaiV1DocumentTextAnchorTextSegment],
      :content string},
     :confidence number,
     :boundingPoly
     {:vertices [GoogleCloudDocumentaiV1Vertex],
      :normalizedVertices [GoogleCloudDocumentaiV1NormalizedVertex]},
     :orientation
     [ORIENTATION_UNSPECIFIED PAGE_UP PAGE_RIGHT PAGE_DOWN PAGE_LEFT]},
    :formFields
    [{:fieldName
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :fieldValue
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :nameDetectedLanguages
      [{:languageCode string, :confidence number}],
      :valueDetectedLanguages
      [{:languageCode string, :confidence number}],
      :valueType string,
      :correctedKeyText string,
      :correctedValueText string,
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :transforms
    [{:rows integer, :cols integer, :type integer, :data string}],
    :lines
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :detectedBarcodes
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :barcode
      {:format string, :valueFormat string, :rawValue string}}],
    :tables
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :headerRows
      [{:cells [GoogleCloudDocumentaiV1DocumentPageTableTableCell]}],
      :bodyRows
      [{:cells [GoogleCloudDocumentaiV1DocumentPageTableTableCell]}],
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :paragraphs
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :imageQualityScores
    {:qualityScore number,
     :detectedDefects [{:type string, :confidence number}]},
    :detectedLanguages [{:languageCode string, :confidence number}],
    :dimension {:width number, :height number, :unit string},
    :provenance
    {:revision integer,
     :id integer,
     :parents [{:revision integer, :index integer, :id integer}],
     :type
     [OPERATION_TYPE_UNSPECIFIED
      ADD
      REMOVE
      UPDATE
      REPLACE
      EVAL_REQUESTED
      EVAL_APPROVED
      EVAL_SKIPPED]},
    :blocks
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]}}],
    :image
    {:content string,
     :mimeType string,
     :width integer,
     :height integer},
    :tokens
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedBreak
      {:type [TYPE_UNSPECIFIED SPACE WIDE_SPACE HYPHEN]},
      :detectedLanguages [{:languageCode string, :confidence number}],
      :provenance
      {:revision integer,
       :id integer,
       :parents [GoogleCloudDocumentaiV1DocumentProvenanceParent],
       :type
       [OPERATION_TYPE_UNSPECIFIED
        ADD
        REMOVE
        UPDATE
        REPLACE
        EVAL_REQUESTED
        EVAL_APPROVED
        EVAL_SKIPPED]},
      :styleInfo
      {:superscript boolean,
       :bold boolean,
       :smallcaps boolean,
       :handwritten boolean,
       :pixelFontSize number,
       :subscript boolean,
       :textColor GoogleTypeColor,
       :letterSpacing number,
       :fontType string,
       :underlined boolean,
       :fontWeight integer,
       :fontSize integer,
       :backgroundColor GoogleTypeColor,
       :italic boolean,
       :strikeout boolean}}],
    :pageNumber integer,
    :symbols
    [{:layout
      {:textAnchor GoogleCloudDocumentaiV1DocumentTextAnchor,
       :confidence number,
       :boundingPoly GoogleCloudDocumentaiV1BoundingPoly,
       :orientation
       [ORIENTATION_UNSPECIFIED
        PAGE_UP
        PAGE_RIGHT
        PAGE_DOWN
        PAGE_LEFT]},
      :detectedLanguages
      [{:languageCode string, :confidence number}]}]}],
  :documentLayout
  {:blocks
   [{:textBlock
     {:text string,
      :type string,
      :blocks
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlock]},
     :tableBlock
     {:headerRows
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutTableRow],
      :bodyRows
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutTableRow],
      :caption string},
     :listBlock
     {:listEntries
      [GoogleCloudDocumentaiV1DocumentDocumentLayoutDocumentLayoutBlockLayoutListEntry],
      :type string},
     :blockId string,
     :pageSpan {:pageStart integer, :pageEnd integer}}]},
  :mimeType string,
  :revisions
  [{:agent string,
    :processor string,
    :id string,
    :parent [integer],
    :parentIds [string],
    :createTime string,
    :humanReview {:state string, :stateMessage string}}],
  :error {:code integer, :message string, :details [object]},
  :uri string,
  :text string},
 :enableSchemaValidation boolean,
 :priority [DEFAULT URGENT],
 :documentSchema
 {:displayName string,
  :description string,
  :entityTypes
  [{:enumValues {:values [string]},
    :displayName string,
    :name string,
    :baseTypes [string],
    :properties
    [{:name string,
      :displayName string,
      :valueType string,
      :occurrenceType
      [OCCURRENCE_TYPE_UNSPECIFIED
       OPTIONAL_ONCE
       OPTIONAL_MULTIPLE
       REQUIRED_ONCE
       REQUIRED_MULTIPLE]}]}],
  :metadata
  {:documentSplitter boolean,
   :documentAllowMultipleLabels boolean,
   :prefixedNamingOnProperties boolean,
   :skipNamingValidation boolean}}}"
  [humanReviewConfig GoogleCloudDocumentaiV1ReviewDocumentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://documentai.googleapis.com/v1/{+humanReviewConfig}:reviewDocument",
     :uri-template-args {:humanReviewConfig humanReviewConfig},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDocumentaiV1ReviewDocumentRequest}))

(defn projects-locations-processorTypes-list
  "Lists the processor types that exist.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processorTypes/list

parent <string> Required. The location of processor types to list. Format: `projects/{project}/locations/{location}`.

optional:
pageSize <integer> The maximum number of processor types to return. If unspecified, at most `100` processor types will be returned. The maximum value is `500`. Values above `500` will be coerced to `500`."
  ([parent] (projects-locations-processorTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://documentai.googleapis.com/v1/{+parent}/processorTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-processorTypes-get
  "Gets a processor type detail.
https://cloud.google.com/document-ai/docs/reference/rest/v1/projects.locations.processorTypes/get

name <string> Required. The processor type resource name."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/document-ai/docs/reference/rest/v1/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://documentai.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

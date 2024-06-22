(ns happygapi2.dlp
  "Sensitive Data Protection (DLP)
Discover and protect your sensitive data. A fully managed service designed to help you discover, classify, and protect your valuable data assets with ease.
See: https://cloud.google.com/sensitive-data-protection/docs/"
  (:require [happy.oauth2.client :as client]))

(defn projects-jobTriggers-create
  "Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/create

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateJobTriggerRequest:
{:triggerId string,
 :jobTrigger
 {:description string,
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :inspectJob
  {:actions
   [{:publishToStackdriver object,
     :publishFindingsToCloudDataCatalog object,
     :saveFindings
     {:outputConfig GooglePrivacyDlpV2OutputStorageConfig},
     :jobNotificationEmails object,
     :pubSub {:topic string},
     :publishSummaryToCscc object,
     :deidentify
     {:transformationConfig GooglePrivacyDlpV2TransformationConfig,
      :cloudStorageOutput string,
      :transformationDetailsStorageConfig
      GooglePrivacyDlpV2TransformationDetailsStorageConfig,
      :fileTypesToTransform
      [[FILE_TYPE_UNSPECIFIED
        BINARY_FILE
        TEXT_FILE
        IMAGE
        WORD
        PDF
        AVRO
        CSV
        TSV
        POWERPOINT
        EXCEL]]}}],
   :storageConfig
   {:hybridOptions
    {:tableOptions GooglePrivacyDlpV2TableOptions,
     :labels object,
     :description string,
     :requiredFindingLabelKeys [string]},
    :datastoreOptions
    {:partitionId GooglePrivacyDlpV2PartitionId,
     :kind GooglePrivacyDlpV2KindExpression},
    :bigQueryOptions
    {:includedFields [GooglePrivacyDlpV2FieldId],
     :rowsLimitPercent integer,
     :excludedFields [GooglePrivacyDlpV2FieldId],
     :tableReference GooglePrivacyDlpV2BigQueryTable,
     :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :identifyingFields [GooglePrivacyDlpV2FieldId],
     :rowsLimit string},
    :timespanConfig
    {:endTime string,
     :enableAutoPopulationOfTimespanConfig boolean,
     :timestampField GooglePrivacyDlpV2FieldId,
     :startTime string},
    :cloudStorageOptions
    {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :fileTypes
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]],
     :bytesLimitPerFilePercent integer,
     :bytesLimitPerFile string,
     :filesLimitPercent integer,
     :fileSet GooglePrivacyDlpV2FileSet}},
   :inspectConfig
   {:ruleSet
    [{:rules [GooglePrivacyDlpV2InspectionRule],
      :infoTypes [GooglePrivacyDlpV2InfoType]}],
    :includeQuote boolean,
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
    :infoTypes
    [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string}],
    :excludeInfoTypes boolean,
    :customInfoTypes
    [{:infoType GooglePrivacyDlpV2InfoType,
      :surrogateType GooglePrivacyDlpV2SurrogateType,
      :sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :dictionary GooglePrivacyDlpV2Dictionary,
      :likelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY],
      :exclusionType
      [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
      :detectionRules [GooglePrivacyDlpV2DetectionRule],
      :regex GooglePrivacyDlpV2Regex,
      :storedType GooglePrivacyDlpV2StoredType}],
    :limits
    {:maxFindingsPerRequest integer,
     :maxFindingsPerItem integer,
     :maxFindingsPerInfoType [GooglePrivacyDlpV2InfoTypeLimit]},
    :minLikelihoodPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType,
      :minLikelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY]}]},
   :inspectTemplateName string},
  :name string,
  :createTime string,
  :triggers
  [{:schedule {:recurrencePeriodDuration string}, :manual object}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED HEALTHY PAUSED CANCELLED],
  :lastRunTime string},
 :locationId string}"
  [parent GooglePrivacyDlpV2CreateJobTriggerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/jobTriggers",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateJobTriggerRequest}))

(defn projects-jobTriggers-delete
  "Deletes a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/delete

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-jobTriggers-activate
  "Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the trigger event to occur.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/activate

name <string> Required. Resource name of the trigger to activate, for example `projects/dlp-test-project/jobTriggers/53234423`.
GooglePrivacyDlpV2ActivateJobTriggerRequest:
object"
  [name GooglePrivacyDlpV2ActivateJobTriggerRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dlp.googleapis.com/v2/{+name}:activate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2ActivateJobTriggerRequest}))

(defn projects-jobTriggers-list
  "Lists job triggers. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/list

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
type <string> The type of jobs. Will use `DlpJobType.INSPECT` if not set.
pageSize <integer> Size of the page. This value can be limited by a server.
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of triggeredJob fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the JobTrigger was created. - `update_time`: corresponds to the time the JobTrigger was last updated. - `last_run_time`: corresponds to the last time the JobTrigger ran. - `name`: corresponds to the JobTrigger's name. - `display_name`: corresponds to the JobTrigger's display name. - `status`: corresponds to JobTrigger's status.
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values for inspect triggers: - `status` - HEALTHY|PAUSED|CANCELLED - `inspected_storage` - DATASTORE|CLOUD_STORAGE|BIGQUERY - 'last_run_time` - RFC 3339 formatted timestamp, surrounded by quotation marks. Nanoseconds are ignored. - 'error_count' - Number of errors that have occurred while running. * The operator must be `=` or `!=` for status and inspected_storage. Examples: * inspected_storage = cloud_storage AND status = HEALTHY * inspected_storage = cloud_storage OR inspected_storage = bigquery * inspected_storage = cloud_storage AND (state = PAUSED OR state = HEALTHY) * last_run_time > \\\"2017-12-12T00:00:00+00:00\\\" The length of this field should be no more than 500 characters."
  ([parent] (projects-jobTriggers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/jobTriggers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-jobTriggers-get
  "Gets a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/get

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-jobTriggers-patch
  "Updates a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.jobTriggers/patch

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`.
GooglePrivacyDlpV2UpdateJobTriggerRequest:
{:jobTrigger
 {:description string,
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :inspectJob
  {:actions
   [{:publishToStackdriver object,
     :publishFindingsToCloudDataCatalog object,
     :saveFindings
     {:outputConfig GooglePrivacyDlpV2OutputStorageConfig},
     :jobNotificationEmails object,
     :pubSub {:topic string},
     :publishSummaryToCscc object,
     :deidentify
     {:transformationConfig GooglePrivacyDlpV2TransformationConfig,
      :cloudStorageOutput string,
      :transformationDetailsStorageConfig
      GooglePrivacyDlpV2TransformationDetailsStorageConfig,
      :fileTypesToTransform
      [[FILE_TYPE_UNSPECIFIED
        BINARY_FILE
        TEXT_FILE
        IMAGE
        WORD
        PDF
        AVRO
        CSV
        TSV
        POWERPOINT
        EXCEL]]}}],
   :storageConfig
   {:hybridOptions
    {:tableOptions GooglePrivacyDlpV2TableOptions,
     :labels object,
     :description string,
     :requiredFindingLabelKeys [string]},
    :datastoreOptions
    {:partitionId GooglePrivacyDlpV2PartitionId,
     :kind GooglePrivacyDlpV2KindExpression},
    :bigQueryOptions
    {:includedFields [GooglePrivacyDlpV2FieldId],
     :rowsLimitPercent integer,
     :excludedFields [GooglePrivacyDlpV2FieldId],
     :tableReference GooglePrivacyDlpV2BigQueryTable,
     :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :identifyingFields [GooglePrivacyDlpV2FieldId],
     :rowsLimit string},
    :timespanConfig
    {:endTime string,
     :enableAutoPopulationOfTimespanConfig boolean,
     :timestampField GooglePrivacyDlpV2FieldId,
     :startTime string},
    :cloudStorageOptions
    {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :fileTypes
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]],
     :bytesLimitPerFilePercent integer,
     :bytesLimitPerFile string,
     :filesLimitPercent integer,
     :fileSet GooglePrivacyDlpV2FileSet}},
   :inspectConfig
   {:ruleSet
    [{:rules [GooglePrivacyDlpV2InspectionRule],
      :infoTypes [GooglePrivacyDlpV2InfoType]}],
    :includeQuote boolean,
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
    :infoTypes
    [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string}],
    :excludeInfoTypes boolean,
    :customInfoTypes
    [{:infoType GooglePrivacyDlpV2InfoType,
      :surrogateType GooglePrivacyDlpV2SurrogateType,
      :sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :dictionary GooglePrivacyDlpV2Dictionary,
      :likelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY],
      :exclusionType
      [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
      :detectionRules [GooglePrivacyDlpV2DetectionRule],
      :regex GooglePrivacyDlpV2Regex,
      :storedType GooglePrivacyDlpV2StoredType}],
    :limits
    {:maxFindingsPerRequest integer,
     :maxFindingsPerItem integer,
     :maxFindingsPerInfoType [GooglePrivacyDlpV2InfoTypeLimit]},
    :minLikelihoodPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType,
      :minLikelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY]}]},
   :inspectTemplateName string},
  :name string,
  :createTime string,
  :triggers
  [{:schedule {:recurrencePeriodDuration string}, :manual object}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED HEALTHY PAUSED CANCELLED],
  :lastRunTime string},
 :updateMask string}"
  [name GooglePrivacyDlpV2UpdateJobTriggerRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateJobTriggerRequest}))

(defn projects-image-redact
  "Redacts potentially sensitive info from an image. This method has limits on input size, processing time, and output size. See https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.image/redact

parent <string> Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2RedactImageRequest:
{:imageRedactionConfigs
 [{:infoType
   {:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string},
   :redactAllText boolean,
   :redactionColor {:blue number, :green number, :red number}}],
 :byteItem
 {:data string,
  :type
  [BYTES_TYPE_UNSPECIFIED
   IMAGE
   IMAGE_JPEG
   IMAGE_BMP
   IMAGE_PNG
   IMAGE_SVG
   TEXT_UTF8
   WORD_DOCUMENT
   PDF
   POWERPOINT_DOCUMENT
   EXCEL_DOCUMENT
   AVRO
   CSV
   TSV]},
 :includeFindings boolean,
 :locationId string,
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]}}"
  [parent GooglePrivacyDlpV2RedactImageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/image:redact",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2RedactImageRequest}))

(defn projects-content-reidentify
  "Re-identifies content that has been de-identified. See https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.content/reidentify

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2ReidentifyContentRequest:
{:reidentifyConfig
 {:transformationErrorHandling
  {:leaveUntransformed object, :throwError object},
  :imageTransformations
  {:transforms
   [{:selectedInfoTypes {:infoTypes [GooglePrivacyDlpV2InfoType]},
     :allInfoTypes object,
     :redactionColor {:blue number, :green number, :red number},
     :allText object}]},
  :recordTransformations
  {:fieldTransformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypeTransformations
     {:transformations [GooglePrivacyDlpV2InfoTypeTransformation]},
     :fields [{:name string}],
     :condition {:expressions GooglePrivacyDlpV2Expressions}}],
   :recordSuppressions
   [{:condition {:expressions GooglePrivacyDlpV2Expressions}}]},
  :infoTypeTransformations
  {:transformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}]}},
 :inspectTemplateName string,
 :reidentifyTemplateName string,
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]},
 :item
 {:table
  {:rows
   [{:values
     [{:timeValue GoogleTypeTimeOfDay,
       :timestampValue string,
       :booleanValue boolean,
       :dayOfWeekValue
       [DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY],
       :dateValue GoogleTypeDate,
       :stringValue string,
       :floatValue number,
       :integerValue string}]}],
   :headers [{:name string}]},
  :byteItem
  {:data string,
   :type
   [BYTES_TYPE_UNSPECIFIED
    IMAGE
    IMAGE_JPEG
    IMAGE_BMP
    IMAGE_PNG
    IMAGE_SVG
    TEXT_UTF8
    WORD_DOCUMENT
    PDF
    POWERPOINT_DOCUMENT
    EXCEL_DOCUMENT
    AVRO
    CSV
    TSV]},
  :value string},
 :locationId string}"
  [parent GooglePrivacyDlpV2ReidentifyContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/content:reidentify",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2ReidentifyContentRequest}))

(defn projects-content-deidentify
  "De-identifies potentially sensitive info from a ContentItem. This method has limits on input size and output size. See https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.content/deidentify

parent <string> Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2DeidentifyContentRequest:
{:deidentifyConfig
 {:transformationErrorHandling
  {:leaveUntransformed object, :throwError object},
  :imageTransformations
  {:transforms
   [{:selectedInfoTypes {:infoTypes [GooglePrivacyDlpV2InfoType]},
     :allInfoTypes object,
     :redactionColor {:blue number, :green number, :red number},
     :allText object}]},
  :recordTransformations
  {:fieldTransformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypeTransformations
     {:transformations [GooglePrivacyDlpV2InfoTypeTransformation]},
     :fields [{:name string}],
     :condition {:expressions GooglePrivacyDlpV2Expressions}}],
   :recordSuppressions
   [{:condition {:expressions GooglePrivacyDlpV2Expressions}}]},
  :infoTypeTransformations
  {:transformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}]}},
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]},
 :inspectTemplateName string,
 :item
 {:table
  {:rows
   [{:values
     [{:timeValue GoogleTypeTimeOfDay,
       :timestampValue string,
       :booleanValue boolean,
       :dayOfWeekValue
       [DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY],
       :dateValue GoogleTypeDate,
       :stringValue string,
       :floatValue number,
       :integerValue string}]}],
   :headers [{:name string}]},
  :byteItem
  {:data string,
   :type
   [BYTES_TYPE_UNSPECIFIED
    IMAGE
    IMAGE_JPEG
    IMAGE_BMP
    IMAGE_PNG
    IMAGE_SVG
    TEXT_UTF8
    WORD_DOCUMENT
    PDF
    POWERPOINT_DOCUMENT
    EXCEL_DOCUMENT
    AVRO
    CSV
    TSV]},
  :value string},
 :deidentifyTemplateName string,
 :locationId string}"
  [parent GooglePrivacyDlpV2DeidentifyContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/content:deidentify",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2DeidentifyContentRequest}))

(defn projects-content-inspect
  "Finds potentially sensitive info in content. This method has limits on input size, processing time, and output size. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated. For how to guides, see https://cloud.google.com/sensitive-data-protection/docs/inspecting-images and https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.content/inspect

parent <string> Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2InspectContentRequest:
{:inspectTemplateName string,
 :locationId string,
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]},
 :item
 {:table
  {:rows
   [{:values
     [{:timeValue GoogleTypeTimeOfDay,
       :timestampValue string,
       :booleanValue boolean,
       :dayOfWeekValue
       [DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY],
       :dateValue GoogleTypeDate,
       :stringValue string,
       :floatValue number,
       :integerValue string}]}],
   :headers [{:name string}]},
  :byteItem
  {:data string,
   :type
   [BYTES_TYPE_UNSPECIFIED
    IMAGE
    IMAGE_JPEG
    IMAGE_BMP
    IMAGE_PNG
    IMAGE_SVG
    TEXT_UTF8
    WORD_DOCUMENT
    PDF
    POWERPOINT_DOCUMENT
    EXCEL_DOCUMENT
    AVRO
    CSV
    TSV]},
  :value string}}"
  [parent GooglePrivacyDlpV2InspectContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/content:inspect",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2InspectContentRequest}))

(defn projects-storedInfoTypes-patch
  "Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/patch

name <string> Required. Resource name of organization and storedInfoType to be updated, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342.
GooglePrivacyDlpV2UpdateStoredInfoTypeRequest:
{:updateMask string,
 :config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string}}"
  [name GooglePrivacyDlpV2UpdateStoredInfoTypeRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateStoredInfoTypeRequest}))

(defn projects-storedInfoTypes-get
  "Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/get

name <string> Required. Resource name of the organization and storedInfoType to be read, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-storedInfoTypes-delete
  "Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/delete

name <string> Required. Resource name of the organization and storedInfoType to be deleted, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-storedInfoTypes-create
  "Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateStoredInfoTypeRequest:
{:config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string},
 :locationId string,
 :storedInfoTypeId string}"
  [parent GooglePrivacyDlpV2CreateStoredInfoTypeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateStoredInfoTypeRequest}))

(defn projects-storedInfoTypes-list
  "Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.storedInfoTypes/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100.
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc, display_name, create_time desc` Supported fields are: - `create_time`: corresponds to the time the most recent version of the resource was created. - `state`: corresponds to the state of the resource. - `name`: corresponds to resource name. - `display_name`: corresponds to info type's display name."
  ([parent] (projects-storedInfoTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-deidentifyTemplates-create
  "Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDeidentifyTemplateRequest:
{:deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string},
 :locationId string,
 :templateId string}"
  [parent GooglePrivacyDlpV2CreateDeidentifyTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDeidentifyTemplateRequest}))

(defn projects-deidentifyTemplates-delete
  "Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/delete

name <string> Required. Resource name of the organization and deidentify template to be deleted, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-deidentifyTemplates-list
  "Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name."
  ([parent] (projects-deidentifyTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-deidentifyTemplates-get
  "Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/get

name <string> Required. Resource name of the organization and deidentify template to be read, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-deidentifyTemplates-patch
  "Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.deidentifyTemplates/patch

name <string> Required. Resource name of organization and deidentify template to be updated, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342.
GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest:
{:updateMask string,
 :deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string}}"
  [name GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest}))

(defn projects-dlpJobs-delete
  "Deletes a long-running DlpJob. This method indicates that the client is no longer interested in the DlpJob result. The job will be canceled if possible. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/delete

name <string> Required. The name of the DlpJob resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-dlpJobs-list
  "Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/list

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
type <string> The type of job. Defaults to `DlpJobType.INSPECT`
pageSize <integer> The standard list page size.
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values for inspect jobs: - `state` - PENDING|RUNNING|CANCELED|FINISHED|FAILED - `inspected_storage` - DATASTORE|CLOUD_STORAGE|BIGQUERY - `trigger_name` - The name of the trigger that created the job. - 'end_time` - Corresponds to the time the job finished. - 'start_time` - Corresponds to the time the job finished. * Supported fields for risk analysis jobs: - `state` - RUNNING|CANCELED|FINISHED|FAILED - 'end_time` - Corresponds to the time the job finished. - 'start_time` - Corresponds to the time the job finished. * The operator must be `=` or `!=`. Examples: * inspected_storage = cloud_storage AND state = done * inspected_storage = cloud_storage OR inspected_storage = bigquery * inspected_storage = cloud_storage AND (state = done OR state = canceled) * end_time > \\\"2017-12-12T00:00:00+00:00\\\" The length of this field should be no more than 500 characters.
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc, end_time asc, create_time desc` Supported fields are: - `create_time`: corresponds to the time the job was created. - `end_time`: corresponds to the time the job ended. - `name`: corresponds to the job's name. - `state`: corresponds to `state`"
  ([parent] (projects-dlpJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dlp.googleapis.com/v2/{+parent}/dlpJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-dlpJobs-get
  "Gets the latest state of a long-running DlpJob. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/get

name <string> Required. The name of the DlpJob resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-dlpJobs-create
  "Creates a new job to inspect storage or calculate risk metrics. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more. When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/create

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDlpJobRequest:
{:riskJob
 {:privacyMetric
  {:categoricalStatsConfig {:field {:name string}},
   :numericalStatsConfig {:field {:name string}},
   :deltaPresenceEstimationConfig
   {:auxiliaryTables
    [{:quasiIds [GooglePrivacyDlpV2QuasiIdentifierField],
      :relativeFrequency GooglePrivacyDlpV2FieldId,
      :table GooglePrivacyDlpV2BigQueryTable}],
    :regionCode string,
    :quasiIds
    [{:field GooglePrivacyDlpV2FieldId,
      :customTag string,
      :inferred GoogleProtobufEmpty,
      :infoType GooglePrivacyDlpV2InfoType}]},
   :kMapEstimationConfig
   {:quasiIds
    [{:customTag string,
      :inferred GoogleProtobufEmpty,
      :infoType GooglePrivacyDlpV2InfoType,
      :field GooglePrivacyDlpV2FieldId}],
    :auxiliaryTables
    [{:quasiIds [GooglePrivacyDlpV2QuasiIdField],
      :table GooglePrivacyDlpV2BigQueryTable,
      :relativeFrequency GooglePrivacyDlpV2FieldId}],
    :regionCode string},
   :lDiversityConfig
   {:quasiIds [{:name string}], :sensitiveAttribute {:name string}},
   :kAnonymityConfig
   {:entityId {:field GooglePrivacyDlpV2FieldId},
    :quasiIds [{:name string}]}},
  :sourceTable {:tableId string, :projectId string, :datasetId string},
  :actions
  [{:publishToStackdriver object,
    :publishFindingsToCloudDataCatalog object,
    :saveFindings
    {:outputConfig
     {:table GooglePrivacyDlpV2BigQueryTable,
      :outputSchema
      [OUTPUT_SCHEMA_UNSPECIFIED
       BASIC_COLUMNS
       GCS_COLUMNS
       DATASTORE_COLUMNS
       BIG_QUERY_COLUMNS
       ALL_COLUMNS]}},
    :jobNotificationEmails object,
    :pubSub {:topic string},
    :publishSummaryToCscc object,
    :deidentify
    {:transformationConfig
     {:deidentifyTemplate string,
      :structuredDeidentifyTemplate string,
      :imageRedactTemplate string},
     :cloudStorageOutput string,
     :transformationDetailsStorageConfig
     {:table GooglePrivacyDlpV2BigQueryTable},
     :fileTypesToTransform
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]]}}]},
 :locationId string,
 :jobId string,
 :inspectJob
 {:actions
  [{:publishToStackdriver object,
    :publishFindingsToCloudDataCatalog object,
    :saveFindings
    {:outputConfig
     {:table GooglePrivacyDlpV2BigQueryTable,
      :outputSchema
      [OUTPUT_SCHEMA_UNSPECIFIED
       BASIC_COLUMNS
       GCS_COLUMNS
       DATASTORE_COLUMNS
       BIG_QUERY_COLUMNS
       ALL_COLUMNS]}},
    :jobNotificationEmails object,
    :pubSub {:topic string},
    :publishSummaryToCscc object,
    :deidentify
    {:transformationConfig
     {:deidentifyTemplate string,
      :structuredDeidentifyTemplate string,
      :imageRedactTemplate string},
     :cloudStorageOutput string,
     :transformationDetailsStorageConfig
     {:table GooglePrivacyDlpV2BigQueryTable},
     :fileTypesToTransform
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]]}}],
  :storageConfig
  {:hybridOptions
   {:tableOptions {:identifyingFields [GooglePrivacyDlpV2FieldId]},
    :labels object,
    :description string,
    :requiredFindingLabelKeys [string]},
   :datastoreOptions
   {:partitionId {:projectId string, :namespaceId string},
    :kind {:name string}},
   :bigQueryOptions
   {:includedFields [{:name string}],
    :rowsLimitPercent integer,
    :excludedFields [{:name string}],
    :tableReference
    {:tableId string, :projectId string, :datasetId string},
    :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
    :identifyingFields [{:name string}],
    :rowsLimit string},
   :timespanConfig
   {:endTime string,
    :enableAutoPopulationOfTimespanConfig boolean,
    :timestampField {:name string},
    :startTime string},
   :cloudStorageOptions
   {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
    :fileTypes
    [[FILE_TYPE_UNSPECIFIED
      BINARY_FILE
      TEXT_FILE
      IMAGE
      WORD
      PDF
      AVRO
      CSV
      TSV
      POWERPOINT
      EXCEL]],
    :bytesLimitPerFilePercent integer,
    :bytesLimitPerFile string,
    :filesLimitPercent integer,
    :fileSet
    {:url string,
     :regexFileSet GooglePrivacyDlpV2CloudStorageRegexFileSet}}},
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :inspectTemplateName string}}"
  [parent GooglePrivacyDlpV2CreateDlpJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dlp.googleapis.com/v2/{+parent}/dlpJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDlpJobRequest}))

(defn projects-dlpJobs-cancel
  "Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to cancel the DlpJob, but success is not guaranteed. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.dlpJobs/cancel

name <string> Required. The name of the DlpJob resource to be cancelled.
GooglePrivacyDlpV2CancelDlpJobRequest:
object"
  [name GooglePrivacyDlpV2CancelDlpJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dlp.googleapis.com/v2/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CancelDlpJobRequest}))

(defn projects-locations-inspectTemplates-get
  "Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/get

name <string> Required. Resource name of the organization and inspectTemplate to be read, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-inspectTemplates-list
  "Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name."
  ([parent] (projects-locations-inspectTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-inspectTemplates-create
  "Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateInspectTemplateRequest:
{:templateId string,
 :locationId string,
 :inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string}}"
  [parent GooglePrivacyDlpV2CreateInspectTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateInspectTemplateRequest}))

(defn projects-locations-inspectTemplates-patch
  "Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/patch

name <string> Required. Resource name of organization and inspectTemplate to be updated, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342.
GooglePrivacyDlpV2UpdateInspectTemplateRequest:
{:inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string},
 :updateMask string}"
  [name GooglePrivacyDlpV2UpdateInspectTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateInspectTemplateRequest}))

(defn projects-locations-inspectTemplates-delete
  "Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.inspectTemplates/delete

name <string> Required. Resource name of the organization and inspectTemplate to be deleted, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tableDataProfiles-list
  "Lists table data profiles for an organization.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.tableDataProfiles/list

parent <string> Required. Resource name of the organization or project, for example `organizations/433245324/locations/europe` or `projects/project-id/locations/asia`.

optional:
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values: - `project_id` - The Google Cloud project ID. - `dataset_id` - The BigQuery dataset ID. - `table_id` - The ID of the BigQuery table. - `sensitivity_level` - HIGH|MODERATE|LOW - `data_risk_level` - HIGH|MODERATE|LOW - `resource_visibility`: PUBLIC|RESTRICTED - `status_code` - an RPC status code as defined in https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto * The operator must be `=` or `!=`. Examples: * `project_id = 12345 AND status_code = 1` * `project_id = 12345 AND sensitivity_level = HIGH` * `project_id = 12345 AND resource_visibility = PUBLIC` The length of this field should be no more than 500 characters.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Only one order field at a time is allowed. Examples: * `project_id asc` * `table_id` * `sensitivity_level desc` Supported fields are: - `project_id`: The Google Cloud project ID. - `dataset_id`: The ID of a BigQuery dataset. - `table_id`: The ID of a BigQuery table. - `sensitivity_level`: How sensitive the data in a table is, at most. - `data_risk_level`: How much risk is associated with this data. - `profile_last_generated`: When the profile was last updated in epoch seconds. - `last_modified`: The last time the resource was modified. - `resource_visibility`: Visibility restriction for this resource. - `row_count`: Number of rows in this resource.
pageSize <integer> Size of the page. This value can be limited by the server. If zero, server returns a page of max size 100."
  ([parent] (projects-locations-tableDataProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/tableDataProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-tableDataProfiles-delete
  "Delete a TableDataProfile. Will not prevent the profile from being regenerated if the table is still included in a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.tableDataProfiles/delete

name <string> Required. Resource name of the table data profile."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-tableDataProfiles-get
  "Gets a table data profile.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.tableDataProfiles/get

name <string> Required. Resource name, for example `organizations/12345/locations/us/tableDataProfiles/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-storedInfoTypes-get
  "Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/get

name <string> Required. Resource name of the organization and storedInfoType to be read, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-storedInfoTypes-delete
  "Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/delete

name <string> Required. Resource name of the organization and storedInfoType to be deleted, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-storedInfoTypes-create
  "Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateStoredInfoTypeRequest:
{:config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string},
 :locationId string,
 :storedInfoTypeId string}"
  [parent GooglePrivacyDlpV2CreateStoredInfoTypeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateStoredInfoTypeRequest}))

(defn projects-locations-storedInfoTypes-list
  "Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc, display_name, create_time desc` Supported fields are: - `create_time`: corresponds to the time the most recent version of the resource was created. - `state`: corresponds to the state of the resource. - `name`: corresponds to resource name. - `display_name`: corresponds to info type's display name.
locationId <string> Deprecated. This field has no effect."
  ([parent] (projects-locations-storedInfoTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-storedInfoTypes-patch
  "Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.storedInfoTypes/patch

name <string> Required. Resource name of organization and storedInfoType to be updated, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342.
GooglePrivacyDlpV2UpdateStoredInfoTypeRequest:
{:updateMask string,
 :config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string}}"
  [name GooglePrivacyDlpV2UpdateStoredInfoTypeRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateStoredInfoTypeRequest}))

(defn projects-locations-content-reidentify
  "Re-identifies content that has been de-identified. See https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.content/reidentify

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2ReidentifyContentRequest:
{:reidentifyConfig
 {:transformationErrorHandling
  {:leaveUntransformed object, :throwError object},
  :imageTransformations
  {:transforms
   [{:selectedInfoTypes {:infoTypes [GooglePrivacyDlpV2InfoType]},
     :allInfoTypes object,
     :redactionColor {:blue number, :green number, :red number},
     :allText object}]},
  :recordTransformations
  {:fieldTransformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypeTransformations
     {:transformations [GooglePrivacyDlpV2InfoTypeTransformation]},
     :fields [{:name string}],
     :condition {:expressions GooglePrivacyDlpV2Expressions}}],
   :recordSuppressions
   [{:condition {:expressions GooglePrivacyDlpV2Expressions}}]},
  :infoTypeTransformations
  {:transformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}]}},
 :inspectTemplateName string,
 :reidentifyTemplateName string,
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]},
 :item
 {:table
  {:rows
   [{:values
     [{:timeValue GoogleTypeTimeOfDay,
       :timestampValue string,
       :booleanValue boolean,
       :dayOfWeekValue
       [DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY],
       :dateValue GoogleTypeDate,
       :stringValue string,
       :floatValue number,
       :integerValue string}]}],
   :headers [{:name string}]},
  :byteItem
  {:data string,
   :type
   [BYTES_TYPE_UNSPECIFIED
    IMAGE
    IMAGE_JPEG
    IMAGE_BMP
    IMAGE_PNG
    IMAGE_SVG
    TEXT_UTF8
    WORD_DOCUMENT
    PDF
    POWERPOINT_DOCUMENT
    EXCEL_DOCUMENT
    AVRO
    CSV
    TSV]},
  :value string},
 :locationId string}"
  [parent GooglePrivacyDlpV2ReidentifyContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/content:reidentify",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2ReidentifyContentRequest}))

(defn projects-locations-content-inspect
  "Finds potentially sensitive info in content. This method has limits on input size, processing time, and output size. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated. For how to guides, see https://cloud.google.com/sensitive-data-protection/docs/inspecting-images and https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.content/inspect

parent <string> Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2InspectContentRequest:
{:inspectTemplateName string,
 :locationId string,
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]},
 :item
 {:table
  {:rows
   [{:values
     [{:timeValue GoogleTypeTimeOfDay,
       :timestampValue string,
       :booleanValue boolean,
       :dayOfWeekValue
       [DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY],
       :dateValue GoogleTypeDate,
       :stringValue string,
       :floatValue number,
       :integerValue string}]}],
   :headers [{:name string}]},
  :byteItem
  {:data string,
   :type
   [BYTES_TYPE_UNSPECIFIED
    IMAGE
    IMAGE_JPEG
    IMAGE_BMP
    IMAGE_PNG
    IMAGE_SVG
    TEXT_UTF8
    WORD_DOCUMENT
    PDF
    POWERPOINT_DOCUMENT
    EXCEL_DOCUMENT
    AVRO
    CSV
    TSV]},
  :value string}}"
  [parent GooglePrivacyDlpV2InspectContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/content:inspect",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2InspectContentRequest}))

(defn projects-locations-content-deidentify
  "De-identifies potentially sensitive info from a ContentItem. This method has limits on input size and output size. See https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.content/deidentify

parent <string> Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2DeidentifyContentRequest:
{:deidentifyConfig
 {:transformationErrorHandling
  {:leaveUntransformed object, :throwError object},
  :imageTransformations
  {:transforms
   [{:selectedInfoTypes {:infoTypes [GooglePrivacyDlpV2InfoType]},
     :allInfoTypes object,
     :redactionColor {:blue number, :green number, :red number},
     :allText object}]},
  :recordTransformations
  {:fieldTransformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypeTransformations
     {:transformations [GooglePrivacyDlpV2InfoTypeTransformation]},
     :fields [{:name string}],
     :condition {:expressions GooglePrivacyDlpV2Expressions}}],
   :recordSuppressions
   [{:condition {:expressions GooglePrivacyDlpV2Expressions}}]},
  :infoTypeTransformations
  {:transformations
   [{:primitiveTransformation
     {:dateShiftConfig GooglePrivacyDlpV2DateShiftConfig,
      :cryptoDeterministicConfig
      GooglePrivacyDlpV2CryptoDeterministicConfig,
      :replaceDictionaryConfig
      GooglePrivacyDlpV2ReplaceDictionaryConfig,
      :cryptoReplaceFfxFpeConfig
      GooglePrivacyDlpV2CryptoReplaceFfxFpeConfig,
      :cryptoHashConfig GooglePrivacyDlpV2CryptoHashConfig,
      :fixedSizeBucketingConfig
      GooglePrivacyDlpV2FixedSizeBucketingConfig,
      :characterMaskConfig GooglePrivacyDlpV2CharacterMaskConfig,
      :redactConfig GooglePrivacyDlpV2RedactConfig,
      :replaceWithInfoTypeConfig
      GooglePrivacyDlpV2ReplaceWithInfoTypeConfig,
      :timePartConfig GooglePrivacyDlpV2TimePartConfig,
      :bucketingConfig GooglePrivacyDlpV2BucketingConfig,
      :replaceConfig GooglePrivacyDlpV2ReplaceValueConfig},
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}]}},
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]},
 :inspectTemplateName string,
 :item
 {:table
  {:rows
   [{:values
     [{:timeValue GoogleTypeTimeOfDay,
       :timestampValue string,
       :booleanValue boolean,
       :dayOfWeekValue
       [DAY_OF_WEEK_UNSPECIFIED
        MONDAY
        TUESDAY
        WEDNESDAY
        THURSDAY
        FRIDAY
        SATURDAY
        SUNDAY],
       :dateValue GoogleTypeDate,
       :stringValue string,
       :floatValue number,
       :integerValue string}]}],
   :headers [{:name string}]},
  :byteItem
  {:data string,
   :type
   [BYTES_TYPE_UNSPECIFIED
    IMAGE
    IMAGE_JPEG
    IMAGE_BMP
    IMAGE_PNG
    IMAGE_SVG
    TEXT_UTF8
    WORD_DOCUMENT
    PDF
    POWERPOINT_DOCUMENT
    EXCEL_DOCUMENT
    AVRO
    CSV
    TSV]},
  :value string},
 :deidentifyTemplateName string,
 :locationId string}"
  [parent GooglePrivacyDlpV2DeidentifyContentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/content:deidentify",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2DeidentifyContentRequest}))

(defn projects-locations-columnDataProfiles-get
  "Gets a column data profile.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.columnDataProfiles/get

name <string> Required. Resource name, for example `organizations/12345/locations/us/columnDataProfiles/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-columnDataProfiles-list
  "Lists column data profiles for an organization.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.columnDataProfiles/list

parent <string> Required. Resource name of the organization or project, for example `organizations/433245324/locations/europe` or `projects/project-id/locations/asia`.

optional:
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values: - `table_data_profile_name` - The name of the related table data profile. - `project_id` - The Google Cloud project ID. (REQUIRED) - `dataset_id` - The BigQuery dataset ID. (REQUIRED) - `table_id` - The BigQuery table ID. (REQUIRED) - `field_id` - The ID of the BigQuery field. - `info_type` - The infotype detected in the resource. - `sensitivity_level` - HIGH|MEDIUM|LOW - `data_risk_level`: How much risk is associated with this data. - `status_code` - an RPC status code as defined in https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto * The operator must be `=` for project_id, dataset_id, and table_id. Other filters also support `!=`. Examples: * project_id = 12345 AND status_code = 1 * project_id = 12345 AND sensitivity_level = HIGH * project_id = 12345 AND info_type = STREET_ADDRESS The length of this field should be no more than 500 characters.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Only one order field at a time is allowed. Examples: * `project_id asc` * `table_id` * `sensitivity_level desc` Supported fields are: - `project_id`: The Google Cloud project ID. - `dataset_id`: The ID of a BigQuery dataset. - `table_id`: The ID of a BigQuery table. - `sensitivity_level`: How sensitive the data in a column is, at most. - `data_risk_level`: How much risk is associated with this data. - `profile_last_generated`: When the profile was last updated in epoch seconds.
pageSize <integer> Size of the page. This value can be limited by the server. If zero, server returns a page of max size 100."
  ([parent] (projects-locations-columnDataProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/columnDataProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dlpJobs-list
  "Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/list

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values for inspect jobs: - `state` - PENDING|RUNNING|CANCELED|FINISHED|FAILED - `inspected_storage` - DATASTORE|CLOUD_STORAGE|BIGQUERY - `trigger_name` - The name of the trigger that created the job. - 'end_time` - Corresponds to the time the job finished. - 'start_time` - Corresponds to the time the job finished. * Supported fields for risk analysis jobs: - `state` - RUNNING|CANCELED|FINISHED|FAILED - 'end_time` - Corresponds to the time the job finished. - 'start_time` - Corresponds to the time the job finished. * The operator must be `=` or `!=`. Examples: * inspected_storage = cloud_storage AND state = done * inspected_storage = cloud_storage OR inspected_storage = bigquery * inspected_storage = cloud_storage AND (state = done OR state = canceled) * end_time > \\\"2017-12-12T00:00:00+00:00\\\" The length of this field should be no more than 500 characters.
type <string> The type of job. Defaults to `DlpJobType.INSPECT`
pageSize <integer> The standard list page size.
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc, end_time asc, create_time desc` Supported fields are: - `create_time`: corresponds to the time the job was created. - `end_time`: corresponds to the time the job ended. - `name`: corresponds to the job's name. - `state`: corresponds to `state`"
  ([parent] (projects-locations-dlpJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dlp.googleapis.com/v2/{+parent}/dlpJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dlpJobs-finish
  "Finish a running hybrid DlpJob. Triggers the finalization steps and running of any enabled actions that have not yet run.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/finish

name <string> Required. The name of the DlpJob resource to be finished.
GooglePrivacyDlpV2FinishDlpJobRequest:
object"
  [name GooglePrivacyDlpV2FinishDlpJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dlp.googleapis.com/v2/{+name}:finish",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2FinishDlpJobRequest}))

(defn projects-locations-dlpJobs-create
  "Creates a new job to inspect storage or calculate risk metrics. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more. When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/create

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDlpJobRequest:
{:riskJob
 {:privacyMetric
  {:categoricalStatsConfig {:field {:name string}},
   :numericalStatsConfig {:field {:name string}},
   :deltaPresenceEstimationConfig
   {:auxiliaryTables
    [{:quasiIds [GooglePrivacyDlpV2QuasiIdentifierField],
      :relativeFrequency GooglePrivacyDlpV2FieldId,
      :table GooglePrivacyDlpV2BigQueryTable}],
    :regionCode string,
    :quasiIds
    [{:field GooglePrivacyDlpV2FieldId,
      :customTag string,
      :inferred GoogleProtobufEmpty,
      :infoType GooglePrivacyDlpV2InfoType}]},
   :kMapEstimationConfig
   {:quasiIds
    [{:customTag string,
      :inferred GoogleProtobufEmpty,
      :infoType GooglePrivacyDlpV2InfoType,
      :field GooglePrivacyDlpV2FieldId}],
    :auxiliaryTables
    [{:quasiIds [GooglePrivacyDlpV2QuasiIdField],
      :table GooglePrivacyDlpV2BigQueryTable,
      :relativeFrequency GooglePrivacyDlpV2FieldId}],
    :regionCode string},
   :lDiversityConfig
   {:quasiIds [{:name string}], :sensitiveAttribute {:name string}},
   :kAnonymityConfig
   {:entityId {:field GooglePrivacyDlpV2FieldId},
    :quasiIds [{:name string}]}},
  :sourceTable {:tableId string, :projectId string, :datasetId string},
  :actions
  [{:publishToStackdriver object,
    :publishFindingsToCloudDataCatalog object,
    :saveFindings
    {:outputConfig
     {:table GooglePrivacyDlpV2BigQueryTable,
      :outputSchema
      [OUTPUT_SCHEMA_UNSPECIFIED
       BASIC_COLUMNS
       GCS_COLUMNS
       DATASTORE_COLUMNS
       BIG_QUERY_COLUMNS
       ALL_COLUMNS]}},
    :jobNotificationEmails object,
    :pubSub {:topic string},
    :publishSummaryToCscc object,
    :deidentify
    {:transformationConfig
     {:deidentifyTemplate string,
      :structuredDeidentifyTemplate string,
      :imageRedactTemplate string},
     :cloudStorageOutput string,
     :transformationDetailsStorageConfig
     {:table GooglePrivacyDlpV2BigQueryTable},
     :fileTypesToTransform
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]]}}]},
 :locationId string,
 :jobId string,
 :inspectJob
 {:actions
  [{:publishToStackdriver object,
    :publishFindingsToCloudDataCatalog object,
    :saveFindings
    {:outputConfig
     {:table GooglePrivacyDlpV2BigQueryTable,
      :outputSchema
      [OUTPUT_SCHEMA_UNSPECIFIED
       BASIC_COLUMNS
       GCS_COLUMNS
       DATASTORE_COLUMNS
       BIG_QUERY_COLUMNS
       ALL_COLUMNS]}},
    :jobNotificationEmails object,
    :pubSub {:topic string},
    :publishSummaryToCscc object,
    :deidentify
    {:transformationConfig
     {:deidentifyTemplate string,
      :structuredDeidentifyTemplate string,
      :imageRedactTemplate string},
     :cloudStorageOutput string,
     :transformationDetailsStorageConfig
     {:table GooglePrivacyDlpV2BigQueryTable},
     :fileTypesToTransform
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]]}}],
  :storageConfig
  {:hybridOptions
   {:tableOptions {:identifyingFields [GooglePrivacyDlpV2FieldId]},
    :labels object,
    :description string,
    :requiredFindingLabelKeys [string]},
   :datastoreOptions
   {:partitionId {:projectId string, :namespaceId string},
    :kind {:name string}},
   :bigQueryOptions
   {:includedFields [{:name string}],
    :rowsLimitPercent integer,
    :excludedFields [{:name string}],
    :tableReference
    {:tableId string, :projectId string, :datasetId string},
    :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
    :identifyingFields [{:name string}],
    :rowsLimit string},
   :timespanConfig
   {:endTime string,
    :enableAutoPopulationOfTimespanConfig boolean,
    :timestampField {:name string},
    :startTime string},
   :cloudStorageOptions
   {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
    :fileTypes
    [[FILE_TYPE_UNSPECIFIED
      BINARY_FILE
      TEXT_FILE
      IMAGE
      WORD
      PDF
      AVRO
      CSV
      TSV
      POWERPOINT
      EXCEL]],
    :bytesLimitPerFilePercent integer,
    :bytesLimitPerFile string,
    :filesLimitPercent integer,
    :fileSet
    {:url string,
     :regexFileSet GooglePrivacyDlpV2CloudStorageRegexFileSet}}},
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :inspectTemplateName string}}"
  [parent GooglePrivacyDlpV2CreateDlpJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dlp.googleapis.com/v2/{+parent}/dlpJobs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDlpJobRequest}))

(defn projects-locations-dlpJobs-hybridInspect
  "Inspect hybrid content and store findings to a job. To review the findings, inspect the job. Inspection will occur asynchronously.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/hybridInspect

name <string> Required. Resource name of the job to execute a hybrid inspect on, for example `projects/dlp-test-project/dlpJob/53234423`.
GooglePrivacyDlpV2HybridInspectDlpJobRequest:
{:hybridItem
 {:findingDetails
  {:containerDetails
   {:updateTime string,
    :rootPath string,
    :fullPath string,
    :relativePath string,
    :projectId string,
    :type string,
    :version string},
   :labels object,
   :tableOptions {:identifyingFields [{:name string}]},
   :fileOffset string,
   :rowOffset string},
  :item
  {:table
   {:rows [{:values [GooglePrivacyDlpV2Value]}],
    :headers [{:name string}]},
   :byteItem
   {:data string,
    :type
    [BYTES_TYPE_UNSPECIFIED
     IMAGE
     IMAGE_JPEG
     IMAGE_BMP
     IMAGE_PNG
     IMAGE_SVG
     TEXT_UTF8
     WORD_DOCUMENT
     PDF
     POWERPOINT_DOCUMENT
     EXCEL_DOCUMENT
     AVRO
     CSV
     TSV]},
   :value string}}}"
  [name GooglePrivacyDlpV2HybridInspectDlpJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+name}:hybridInspect",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2HybridInspectDlpJobRequest}))

(defn projects-locations-dlpJobs-cancel
  "Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to cancel the DlpJob, but success is not guaranteed. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/cancel

name <string> Required. The name of the DlpJob resource to be cancelled.
GooglePrivacyDlpV2CancelDlpJobRequest:
object"
  [name GooglePrivacyDlpV2CancelDlpJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dlp.googleapis.com/v2/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CancelDlpJobRequest}))

(defn projects-locations-dlpJobs-get
  "Gets the latest state of a long-running DlpJob. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/get

name <string> Required. The name of the DlpJob resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dlpJobs-delete
  "Deletes a long-running DlpJob. This method indicates that the client is no longer interested in the DlpJob result. The job will be canceled if possible. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.dlpJobs/delete

name <string> Required. The name of the DlpJob resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deidentifyTemplates-get
  "Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/get

name <string> Required. Resource name of the organization and deidentify template to be read, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deidentifyTemplates-list
  "Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name.
locationId <string> Deprecated. This field has no effect.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100."
  ([parent] (projects-locations-deidentifyTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-deidentifyTemplates-delete
  "Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/delete

name <string> Required. Resource name of the organization and deidentify template to be deleted, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-deidentifyTemplates-create
  "Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDeidentifyTemplateRequest:
{:deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string},
 :locationId string,
 :templateId string}"
  [parent GooglePrivacyDlpV2CreateDeidentifyTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDeidentifyTemplateRequest}))

(defn projects-locations-deidentifyTemplates-patch
  "Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.deidentifyTemplates/patch

name <string> Required. Resource name of organization and deidentify template to be updated, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342.
GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest:
{:updateMask string,
 :deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string}}"
  [name GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest}))

(defn projects-locations-jobTriggers-hybridInspect
  "Inspect hybrid content and store findings to a trigger. The inspection will be processed asynchronously. To review the findings monitor the jobs within the trigger.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/hybridInspect

name <string> Required. Resource name of the trigger to execute a hybrid inspect on, for example `projects/dlp-test-project/jobTriggers/53234423`.
GooglePrivacyDlpV2HybridInspectJobTriggerRequest:
{:hybridItem
 {:findingDetails
  {:containerDetails
   {:updateTime string,
    :rootPath string,
    :fullPath string,
    :relativePath string,
    :projectId string,
    :type string,
    :version string},
   :labels object,
   :tableOptions {:identifyingFields [{:name string}]},
   :fileOffset string,
   :rowOffset string},
  :item
  {:table
   {:rows [{:values [GooglePrivacyDlpV2Value]}],
    :headers [{:name string}]},
   :byteItem
   {:data string,
    :type
    [BYTES_TYPE_UNSPECIFIED
     IMAGE
     IMAGE_JPEG
     IMAGE_BMP
     IMAGE_PNG
     IMAGE_SVG
     TEXT_UTF8
     WORD_DOCUMENT
     PDF
     POWERPOINT_DOCUMENT
     EXCEL_DOCUMENT
     AVRO
     CSV
     TSV]},
   :value string}}}"
  [name GooglePrivacyDlpV2HybridInspectJobTriggerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+name}:hybridInspect",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2HybridInspectJobTriggerRequest}))

(defn projects-locations-jobTriggers-get
  "Gets a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/get

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobTriggers-patch
  "Updates a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/patch

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`.
GooglePrivacyDlpV2UpdateJobTriggerRequest:
{:jobTrigger
 {:description string,
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :inspectJob
  {:actions
   [{:publishToStackdriver object,
     :publishFindingsToCloudDataCatalog object,
     :saveFindings
     {:outputConfig GooglePrivacyDlpV2OutputStorageConfig},
     :jobNotificationEmails object,
     :pubSub {:topic string},
     :publishSummaryToCscc object,
     :deidentify
     {:transformationConfig GooglePrivacyDlpV2TransformationConfig,
      :cloudStorageOutput string,
      :transformationDetailsStorageConfig
      GooglePrivacyDlpV2TransformationDetailsStorageConfig,
      :fileTypesToTransform
      [[FILE_TYPE_UNSPECIFIED
        BINARY_FILE
        TEXT_FILE
        IMAGE
        WORD
        PDF
        AVRO
        CSV
        TSV
        POWERPOINT
        EXCEL]]}}],
   :storageConfig
   {:hybridOptions
    {:tableOptions GooglePrivacyDlpV2TableOptions,
     :labels object,
     :description string,
     :requiredFindingLabelKeys [string]},
    :datastoreOptions
    {:partitionId GooglePrivacyDlpV2PartitionId,
     :kind GooglePrivacyDlpV2KindExpression},
    :bigQueryOptions
    {:includedFields [GooglePrivacyDlpV2FieldId],
     :rowsLimitPercent integer,
     :excludedFields [GooglePrivacyDlpV2FieldId],
     :tableReference GooglePrivacyDlpV2BigQueryTable,
     :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :identifyingFields [GooglePrivacyDlpV2FieldId],
     :rowsLimit string},
    :timespanConfig
    {:endTime string,
     :enableAutoPopulationOfTimespanConfig boolean,
     :timestampField GooglePrivacyDlpV2FieldId,
     :startTime string},
    :cloudStorageOptions
    {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :fileTypes
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]],
     :bytesLimitPerFilePercent integer,
     :bytesLimitPerFile string,
     :filesLimitPercent integer,
     :fileSet GooglePrivacyDlpV2FileSet}},
   :inspectConfig
   {:ruleSet
    [{:rules [GooglePrivacyDlpV2InspectionRule],
      :infoTypes [GooglePrivacyDlpV2InfoType]}],
    :includeQuote boolean,
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
    :infoTypes
    [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string}],
    :excludeInfoTypes boolean,
    :customInfoTypes
    [{:infoType GooglePrivacyDlpV2InfoType,
      :surrogateType GooglePrivacyDlpV2SurrogateType,
      :sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :dictionary GooglePrivacyDlpV2Dictionary,
      :likelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY],
      :exclusionType
      [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
      :detectionRules [GooglePrivacyDlpV2DetectionRule],
      :regex GooglePrivacyDlpV2Regex,
      :storedType GooglePrivacyDlpV2StoredType}],
    :limits
    {:maxFindingsPerRequest integer,
     :maxFindingsPerItem integer,
     :maxFindingsPerInfoType [GooglePrivacyDlpV2InfoTypeLimit]},
    :minLikelihoodPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType,
      :minLikelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY]}]},
   :inspectTemplateName string},
  :name string,
  :createTime string,
  :triggers
  [{:schedule {:recurrencePeriodDuration string}, :manual object}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED HEALTHY PAUSED CANCELLED],
  :lastRunTime string},
 :updateMask string}"
  [name GooglePrivacyDlpV2UpdateJobTriggerRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateJobTriggerRequest}))

(defn projects-locations-jobTriggers-activate
  "Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the trigger event to occur.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/activate

name <string> Required. Resource name of the trigger to activate, for example `projects/dlp-test-project/jobTriggers/53234423`.
GooglePrivacyDlpV2ActivateJobTriggerRequest:
object"
  [name GooglePrivacyDlpV2ActivateJobTriggerRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dlp.googleapis.com/v2/{+name}:activate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2ActivateJobTriggerRequest}))

(defn projects-locations-jobTriggers-list
  "Lists job triggers. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/list

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
pageSize <integer> Size of the page. This value can be limited by a server.
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of triggeredJob fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the JobTrigger was created. - `update_time`: corresponds to the time the JobTrigger was last updated. - `last_run_time`: corresponds to the last time the JobTrigger ran. - `name`: corresponds to the JobTrigger's name. - `display_name`: corresponds to the JobTrigger's display name. - `status`: corresponds to JobTrigger's status.
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values for inspect triggers: - `status` - HEALTHY|PAUSED|CANCELLED - `inspected_storage` - DATASTORE|CLOUD_STORAGE|BIGQUERY - 'last_run_time` - RFC 3339 formatted timestamp, surrounded by quotation marks. Nanoseconds are ignored. - 'error_count' - Number of errors that have occurred while running. * The operator must be `=` or `!=` for status and inspected_storage. Examples: * inspected_storage = cloud_storage AND status = HEALTHY * inspected_storage = cloud_storage OR inspected_storage = bigquery * inspected_storage = cloud_storage AND (state = PAUSED OR state = HEALTHY) * last_run_time > \\\"2017-12-12T00:00:00+00:00\\\" The length of this field should be no more than 500 characters.
type <string> The type of jobs. Will use `DlpJobType.INSPECT` if not set."
  ([parent] (projects-locations-jobTriggers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/jobTriggers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-jobTriggers-delete
  "Deletes a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/delete

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-jobTriggers-create
  "Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.jobTriggers/create

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateJobTriggerRequest:
{:triggerId string,
 :jobTrigger
 {:description string,
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :inspectJob
  {:actions
   [{:publishToStackdriver object,
     :publishFindingsToCloudDataCatalog object,
     :saveFindings
     {:outputConfig GooglePrivacyDlpV2OutputStorageConfig},
     :jobNotificationEmails object,
     :pubSub {:topic string},
     :publishSummaryToCscc object,
     :deidentify
     {:transformationConfig GooglePrivacyDlpV2TransformationConfig,
      :cloudStorageOutput string,
      :transformationDetailsStorageConfig
      GooglePrivacyDlpV2TransformationDetailsStorageConfig,
      :fileTypesToTransform
      [[FILE_TYPE_UNSPECIFIED
        BINARY_FILE
        TEXT_FILE
        IMAGE
        WORD
        PDF
        AVRO
        CSV
        TSV
        POWERPOINT
        EXCEL]]}}],
   :storageConfig
   {:hybridOptions
    {:tableOptions GooglePrivacyDlpV2TableOptions,
     :labels object,
     :description string,
     :requiredFindingLabelKeys [string]},
    :datastoreOptions
    {:partitionId GooglePrivacyDlpV2PartitionId,
     :kind GooglePrivacyDlpV2KindExpression},
    :bigQueryOptions
    {:includedFields [GooglePrivacyDlpV2FieldId],
     :rowsLimitPercent integer,
     :excludedFields [GooglePrivacyDlpV2FieldId],
     :tableReference GooglePrivacyDlpV2BigQueryTable,
     :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :identifyingFields [GooglePrivacyDlpV2FieldId],
     :rowsLimit string},
    :timespanConfig
    {:endTime string,
     :enableAutoPopulationOfTimespanConfig boolean,
     :timestampField GooglePrivacyDlpV2FieldId,
     :startTime string},
    :cloudStorageOptions
    {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :fileTypes
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]],
     :bytesLimitPerFilePercent integer,
     :bytesLimitPerFile string,
     :filesLimitPercent integer,
     :fileSet GooglePrivacyDlpV2FileSet}},
   :inspectConfig
   {:ruleSet
    [{:rules [GooglePrivacyDlpV2InspectionRule],
      :infoTypes [GooglePrivacyDlpV2InfoType]}],
    :includeQuote boolean,
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
    :infoTypes
    [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string}],
    :excludeInfoTypes boolean,
    :customInfoTypes
    [{:infoType GooglePrivacyDlpV2InfoType,
      :surrogateType GooglePrivacyDlpV2SurrogateType,
      :sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :dictionary GooglePrivacyDlpV2Dictionary,
      :likelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY],
      :exclusionType
      [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
      :detectionRules [GooglePrivacyDlpV2DetectionRule],
      :regex GooglePrivacyDlpV2Regex,
      :storedType GooglePrivacyDlpV2StoredType}],
    :limits
    {:maxFindingsPerRequest integer,
     :maxFindingsPerItem integer,
     :maxFindingsPerInfoType [GooglePrivacyDlpV2InfoTypeLimit]},
    :minLikelihoodPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType,
      :minLikelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY]}]},
   :inspectTemplateName string},
  :name string,
  :createTime string,
  :triggers
  [{:schedule {:recurrencePeriodDuration string}, :manual object}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED HEALTHY PAUSED CANCELLED],
  :lastRunTime string},
 :locationId string}"
  [parent GooglePrivacyDlpV2CreateJobTriggerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/jobTriggers",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateJobTriggerRequest}))

(defn projects-locations-projectDataProfiles-get
  "Gets a project data profile.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.projectDataProfiles/get

name <string> Required. Resource name, for example `organizations/12345/locations/us/projectDataProfiles/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-projectDataProfiles-list
  "Lists project data profiles for an organization.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.projectDataProfiles/list

parent <string> Required. organizations/{org_id}/locations/{loc_id}

optional:
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values: - `sensitivity_level` - HIGH|MODERATE|LOW - `data_risk_level` - HIGH|MODERATE|LOW - `status_code` - an RPC status code as defined in https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto * The operator must be `=` or `!=`. Examples: * `project_id = 12345 AND status_code = 1` * `project_id = 12345 AND sensitivity_level = HIGH` The length of this field should be no more than 500 characters.
pageSize <integer> Size of the page. This value can be limited by the server. If zero, server returns a page of max size 100.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Only one order field at a time is allowed. Examples: * `project_id` * `sensitivity_level desc` Supported fields are: - `project_id`: Google Cloud project ID - `sensitivity_level`: How sensitive the data in a project is, at most. - `data_risk_level`: How much risk is associated with this data. - `profile_last_generated`: When the profile was last updated in epoch seconds."
  ([parent] (projects-locations-projectDataProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/projectDataProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-image-redact
  "Redacts potentially sensitive info from an image. This method has limits on input size, processing time, and output size. See https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.image/redact

parent <string> Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2RedactImageRequest:
{:imageRedactionConfigs
 [{:infoType
   {:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string},
   :redactAllText boolean,
   :redactionColor {:blue number, :green number, :red number}}],
 :byteItem
 {:data string,
  :type
  [BYTES_TYPE_UNSPECIFIED
   IMAGE
   IMAGE_JPEG
   IMAGE_BMP
   IMAGE_PNG
   IMAGE_SVG
   TEXT_UTF8
   WORD_DOCUMENT
   PDF
   POWERPOINT_DOCUMENT
   EXCEL_DOCUMENT
   AVRO
   CSV
   TSV]},
 :includeFindings boolean,
 :locationId string,
 :inspectConfig
 {:ruleSet
  [{:rules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex},
      :exclusionRule
      {:matchingType
       [MATCHING_TYPE_UNSPECIFIED
        MATCHING_TYPE_FULL_MATCH
        MATCHING_TYPE_PARTIAL_MATCH
        MATCHING_TYPE_INVERSE_MATCH],
       :excludeInfoTypes GooglePrivacyDlpV2ExcludeInfoTypes,
       :dictionary GooglePrivacyDlpV2Dictionary,
       :excludeByHotword GooglePrivacyDlpV2ExcludeByHotword,
       :regex GooglePrivacyDlpV2Regex}}],
    :infoTypes
    [{:sensitivityScore
      {:score
       [SENSITIVITY_SCORE_UNSPECIFIED
        SENSITIVITY_LOW
        SENSITIVITY_MODERATE
        SENSITIVITY_HIGH]},
      :version string,
      :name string}]}],
  :includeQuote boolean,
  :minLikelihood
  [LIKELIHOOD_UNSPECIFIED
   VERY_UNLIKELY
   UNLIKELY
   POSSIBLE
   LIKELY
   VERY_LIKELY],
  :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
  :infoTypes
  [{:sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :version string,
    :name string}],
  :excludeInfoTypes boolean,
  :customInfoTypes
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :surrogateType object,
    :sensitivityScore
    {:score
     [SENSITIVITY_SCORE_UNSPECIFIED
      SENSITIVITY_LOW
      SENSITIVITY_MODERATE
      SENSITIVITY_HIGH]},
    :dictionary
    {:cloudStoragePath {:path string}, :wordList {:words [string]}},
    :likelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :exclusionType [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
    :detectionRules
    [{:hotwordRule
      {:proximity GooglePrivacyDlpV2Proximity,
       :likelihoodAdjustment GooglePrivacyDlpV2LikelihoodAdjustment,
       :hotwordRegex GooglePrivacyDlpV2Regex}}],
    :regex {:groupIndexes [integer], :pattern string},
    :storedType {:createTime string, :name string}}],
  :limits
  {:maxFindingsPerRequest integer,
   :maxFindingsPerItem integer,
   :maxFindingsPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :maxFindings integer}]},
  :minLikelihoodPerInfoType
  [{:infoType
    {:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string},
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY]}]}}"
  [parent GooglePrivacyDlpV2RedactImageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/image:redact",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2RedactImageRequest}))

(defn projects-locations-connections-patch
  "Update a Connection.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/patch

name <string> Required. Resource name in the format: `projects/{project}/locations/{location}/connections/{connection}`.
GooglePrivacyDlpV2UpdateConnectionRequest:
{:updateMask string,
 :connection
 {:name string,
  :state
  [CONNECTION_STATE_UNSPECIFIED MISSING_CREDENTIALS AVAILABLE ERROR],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :cloudSql
  {:connectionName string,
   :cloudSqlIam object,
   :maxConnections integer,
   :databaseEngine
   [DATABASE_ENGINE_UNKNOWN
    DATABASE_ENGINE_MYSQL
    DATABASE_ENGINE_POSTGRES],
   :usernamePassword
   {:username string, :passwordSecretVersionName string}}}}"
  [name GooglePrivacyDlpV2UpdateConnectionRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateConnectionRequest}))

(defn projects-locations-connections-create
  "Create a Connection to an external data source.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization): + Projects scope: `projects/`PROJECT_ID`/locations/`LOCATION_ID + Organizations scope: `organizations/`ORG_ID`/locations/`LOCATION_ID
GooglePrivacyDlpV2CreateConnectionRequest:
{:connection
 {:name string,
  :state
  [CONNECTION_STATE_UNSPECIFIED MISSING_CREDENTIALS AVAILABLE ERROR],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :cloudSql
  {:connectionName string,
   :cloudSqlIam object,
   :maxConnections integer,
   :databaseEngine
   [DATABASE_ENGINE_UNKNOWN
    DATABASE_ENGINE_MYSQL
    DATABASE_ENGINE_POSTGRES],
   :usernamePassword
   {:username string, :passwordSecretVersionName string}}}}"
  [parent GooglePrivacyDlpV2CreateConnectionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/connections",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateConnectionRequest}))

(defn projects-locations-connections-delete
  "Delete a Connection.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/delete

name <string> Required. Resource name of the Connection to be deleted, in the format: `projects/{project}/locations/{location}/connections/{connection}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connections-search
  "Searches for Connections in a parent.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/search

parent <string> Required. Parent name, typically an organization, without location. For example: `organizations/12345678`.

optional:
filter <string> Optional. Supported field/value: - `state` - MISSING|AVAILABLE|ERROR
pageSize <integer> Optional. Number of results per page, max 1000."
  ([parent] (projects-locations-connections-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/connections:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-list
  "Lists Connections in a parent.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/list

parent <string> Required. Parent name, for example: `projects/project-id/locations/global`.

optional:
pageSize <integer> Optional. Number of results per page, max 1000.
filter <string> Optional. Supported field/value: `state` - MISSING|AVAILABLE|ERROR"
  ([parent] (projects-locations-connections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/connections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connections-get
  "Get a Connection by name.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.connections/get

name <string> Required. Resource name in the format: `projects/{project}/locations/{location}/connections/{connection}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-discoveryConfigs-list
  "Lists discovery configurations.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/list

parent <string> Required. Parent resource name. The format of this value is as follows: `projects/`PROJECT_ID`/locations/`LOCATION_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
orderBy <string> Comma separated list of config fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `last_run_time`: corresponds to the last time the DiscoveryConfig ran. - `name`: corresponds to the DiscoveryConfig's name. - `status`: corresponds to DiscoveryConfig's status.
pageSize <integer> Size of the page. This value can be limited by a server."
  ([parent] (projects-locations-discoveryConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/discoveryConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-discoveryConfigs-patch
  "Updates a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/patch

name <string> Required. Resource name of the project and the configuration, for example `projects/dlp-test-project/discoveryConfigs/53234423`.
GooglePrivacyDlpV2UpdateDiscoveryConfigRequest:
{:updateMask string,
 :discoveryConfig
 {:inspectTemplates [string],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :name string,
  :createTime string,
  :orgConfig
  {:projectId string,
   :location {:folderId string, :organizationId string}},
  :targets
  [{:cloudSqlTarget
    {:filter
     {:databaseResourceReference
      GooglePrivacyDlpV2DatabaseResourceReference,
      :others GooglePrivacyDlpV2AllOtherDatabaseResources,
      :collection GooglePrivacyDlpV2DatabaseResourceCollection},
     :disabled object,
     :generationCadence
     {:schemaModifiedCadence GooglePrivacyDlpV2SchemaModifiedCadence,
      :refreshFrequency
      [UPDATE_FREQUENCY_UNSPECIFIED
       UPDATE_FREQUENCY_NEVER
       UPDATE_FREQUENCY_DAILY
       UPDATE_FREQUENCY_MONTHLY]},
     :conditions
     {:databaseEngines
      [[DATABASE_ENGINE_UNSPECIFIED
        ALL_SUPPORTED_DATABASE_ENGINES
        MYSQL
        POSTGRES]],
      :types
      [[DATABASE_RESOURCE_TYPE_UNSPECIFIED
        DATABASE_RESOURCE_TYPE_ALL_SUPPORTED_TYPES
        DATABASE_RESOURCE_TYPE_TABLE]]}},
    :bigQueryTarget
    {:cadence
     {:tableModifiedCadence
      GooglePrivacyDlpV2DiscoveryTableModifiedCadence,
      :schemaModifiedCadence
      GooglePrivacyDlpV2DiscoverySchemaModifiedCadence},
     :disabled object,
     :conditions
     {:types GooglePrivacyDlpV2BigQueryTableTypes,
      :orConditions GooglePrivacyDlpV2OrConditions,
      :createdAfter string,
      :typeCollection
      [BIG_QUERY_COLLECTION_UNSPECIFIED
       BIG_QUERY_COLLECTION_ALL_TYPES
       BIG_QUERY_COLLECTION_ONLY_SUPPORTED_TYPES]},
     :filter
     {:tables GooglePrivacyDlpV2BigQueryTableCollection,
      :tableReference GooglePrivacyDlpV2TableReference,
      :otherTables GooglePrivacyDlpV2AllOtherBigQueryTables}},
    :secretsTarget object}],
  :actions
  [{:exportData
    {:profileTable
     {:tableId string, :projectId string, :datasetId string}},
    :pubSubNotification
    {:detailOfMessage
     [DETAIL_LEVEL_UNSPECIFIED TABLE_PROFILE RESOURCE_NAME],
     :topic string,
     :pubsubCondition
     {:expressions GooglePrivacyDlpV2PubSubExpressions},
     :event
     [EVENT_TYPE_UNSPECIFIED
      NEW_PROFILE
      CHANGED_PROFILE
      SCORE_INCREASED
      ERROR_CHANGED]}}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED RUNNING PAUSED],
  :lastRunTime string}}"
  [name GooglePrivacyDlpV2UpdateDiscoveryConfigRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateDiscoveryConfigRequest}))

(defn projects-locations-discoveryConfigs-create
  "Creates a config for discovery to scan and profile storage.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization): + Projects scope: `projects/`PROJECT_ID`/locations/`LOCATION_ID + Organizations scope: `organizations/`ORG_ID`/locations/`LOCATION_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDiscoveryConfigRequest:
{:discoveryConfig
 {:inspectTemplates [string],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :name string,
  :createTime string,
  :orgConfig
  {:projectId string,
   :location {:folderId string, :organizationId string}},
  :targets
  [{:cloudSqlTarget
    {:filter
     {:databaseResourceReference
      GooglePrivacyDlpV2DatabaseResourceReference,
      :others GooglePrivacyDlpV2AllOtherDatabaseResources,
      :collection GooglePrivacyDlpV2DatabaseResourceCollection},
     :disabled object,
     :generationCadence
     {:schemaModifiedCadence GooglePrivacyDlpV2SchemaModifiedCadence,
      :refreshFrequency
      [UPDATE_FREQUENCY_UNSPECIFIED
       UPDATE_FREQUENCY_NEVER
       UPDATE_FREQUENCY_DAILY
       UPDATE_FREQUENCY_MONTHLY]},
     :conditions
     {:databaseEngines
      [[DATABASE_ENGINE_UNSPECIFIED
        ALL_SUPPORTED_DATABASE_ENGINES
        MYSQL
        POSTGRES]],
      :types
      [[DATABASE_RESOURCE_TYPE_UNSPECIFIED
        DATABASE_RESOURCE_TYPE_ALL_SUPPORTED_TYPES
        DATABASE_RESOURCE_TYPE_TABLE]]}},
    :bigQueryTarget
    {:cadence
     {:tableModifiedCadence
      GooglePrivacyDlpV2DiscoveryTableModifiedCadence,
      :schemaModifiedCadence
      GooglePrivacyDlpV2DiscoverySchemaModifiedCadence},
     :disabled object,
     :conditions
     {:types GooglePrivacyDlpV2BigQueryTableTypes,
      :orConditions GooglePrivacyDlpV2OrConditions,
      :createdAfter string,
      :typeCollection
      [BIG_QUERY_COLLECTION_UNSPECIFIED
       BIG_QUERY_COLLECTION_ALL_TYPES
       BIG_QUERY_COLLECTION_ONLY_SUPPORTED_TYPES]},
     :filter
     {:tables GooglePrivacyDlpV2BigQueryTableCollection,
      :tableReference GooglePrivacyDlpV2TableReference,
      :otherTables GooglePrivacyDlpV2AllOtherBigQueryTables}},
    :secretsTarget object}],
  :actions
  [{:exportData
    {:profileTable
     {:tableId string, :projectId string, :datasetId string}},
    :pubSubNotification
    {:detailOfMessage
     [DETAIL_LEVEL_UNSPECIFIED TABLE_PROFILE RESOURCE_NAME],
     :topic string,
     :pubsubCondition
     {:expressions GooglePrivacyDlpV2PubSubExpressions},
     :event
     [EVENT_TYPE_UNSPECIFIED
      NEW_PROFILE
      CHANGED_PROFILE
      SCORE_INCREASED
      ERROR_CHANGED]}}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED RUNNING PAUSED],
  :lastRunTime string},
 :configId string}"
  [parent GooglePrivacyDlpV2CreateDiscoveryConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/discoveryConfigs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDiscoveryConfigRequest}))

(defn projects-locations-discoveryConfigs-get
  "Gets a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/get

name <string> Required. Resource name of the project and the configuration, for example `projects/dlp-test-project/discoveryConfigs/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-discoveryConfigs-delete
  "Deletes a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.locations.discoveryConfigs/delete

name <string> Required. Resource name of the project and the config, for example `projects/dlp-test-project/discoveryConfigs/53234423`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-inspectTemplates-create
  "Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateInspectTemplateRequest:
{:templateId string,
 :locationId string,
 :inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string}}"
  [parent GooglePrivacyDlpV2CreateInspectTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateInspectTemplateRequest}))

(defn projects-inspectTemplates-list
  "Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name."
  ([parent] (projects-inspectTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-inspectTemplates-patch
  "Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/patch

name <string> Required. Resource name of organization and inspectTemplate to be updated, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342.
GooglePrivacyDlpV2UpdateInspectTemplateRequest:
{:inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string},
 :updateMask string}"
  [name GooglePrivacyDlpV2UpdateInspectTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateInspectTemplateRequest}))

(defn projects-inspectTemplates-get
  "Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/get

name <string> Required. Resource name of the organization and inspectTemplate to be read, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-inspectTemplates-delete
  "Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/projects.inspectTemplates/delete

name <string> Required. Resource name of the organization and inspectTemplate to be deleted, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn infoTypes-list
  "Returns a list of the sensitive information types that DLP API supports. See https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/infoTypes/list

optional:
locationId <string> Deprecated. This field has no effect.
filter <string> filter to only return infoTypes supported by certain parts of the API. Defaults to supported_by=INSPECT.
languageCode <string> BCP-47 language code for localized infoType friendly names. If omitted, or if localized strings are not available, en-US strings will be returned.
parent <string> The parent resource name. The format of this value is as follows: locations/ LOCATION_ID"
  ([] (infoTypes-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dlp.googleapis.com/v2/infoTypes",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-inspectTemplates-list
  "Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.inspectTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100."
  ([parent] (organizations-locations-inspectTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-inspectTemplates-patch
  "Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.inspectTemplates/patch

name <string> Required. Resource name of organization and inspectTemplate to be updated, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342.
GooglePrivacyDlpV2UpdateInspectTemplateRequest:
{:inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string},
 :updateMask string}"
  [name GooglePrivacyDlpV2UpdateInspectTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateInspectTemplateRequest}))

(defn organizations-locations-inspectTemplates-get
  "Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.inspectTemplates/get

name <string> Required. Resource name of the organization and inspectTemplate to be read, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-inspectTemplates-create
  "Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.inspectTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateInspectTemplateRequest:
{:templateId string,
 :locationId string,
 :inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string}}"
  [parent GooglePrivacyDlpV2CreateInspectTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateInspectTemplateRequest}))

(defn organizations-locations-inspectTemplates-delete
  "Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.inspectTemplates/delete

name <string> Required. Resource name of the organization and inspectTemplate to be deleted, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-tableDataProfiles-list
  "Lists table data profiles for an organization.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.tableDataProfiles/list

parent <string> Required. Resource name of the organization or project, for example `organizations/433245324/locations/europe` or `projects/project-id/locations/asia`.

optional:
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Only one order field at a time is allowed. Examples: * `project_id asc` * `table_id` * `sensitivity_level desc` Supported fields are: - `project_id`: The Google Cloud project ID. - `dataset_id`: The ID of a BigQuery dataset. - `table_id`: The ID of a BigQuery table. - `sensitivity_level`: How sensitive the data in a table is, at most. - `data_risk_level`: How much risk is associated with this data. - `profile_last_generated`: When the profile was last updated in epoch seconds. - `last_modified`: The last time the resource was modified. - `resource_visibility`: Visibility restriction for this resource. - `row_count`: Number of rows in this resource.
pageSize <integer> Size of the page. This value can be limited by the server. If zero, server returns a page of max size 100.
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values: - `project_id` - The Google Cloud project ID. - `dataset_id` - The BigQuery dataset ID. - `table_id` - The ID of the BigQuery table. - `sensitivity_level` - HIGH|MODERATE|LOW - `data_risk_level` - HIGH|MODERATE|LOW - `resource_visibility`: PUBLIC|RESTRICTED - `status_code` - an RPC status code as defined in https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto * The operator must be `=` or `!=`. Examples: * `project_id = 12345 AND status_code = 1` * `project_id = 12345 AND sensitivity_level = HIGH` * `project_id = 12345 AND resource_visibility = PUBLIC` The length of this field should be no more than 500 characters."
  ([parent]
    (organizations-locations-tableDataProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/tableDataProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-tableDataProfiles-delete
  "Delete a TableDataProfile. Will not prevent the profile from being regenerated if the table is still included in a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.tableDataProfiles/delete

name <string> Required. Resource name of the table data profile."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-tableDataProfiles-get
  "Gets a table data profile.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.tableDataProfiles/get

name <string> Required. Resource name, for example `organizations/12345/locations/us/tableDataProfiles/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-storedInfoTypes-list
  "Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.storedInfoTypes/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc, display_name, create_time desc` Supported fields are: - `create_time`: corresponds to the time the most recent version of the resource was created. - `state`: corresponds to the state of the resource. - `name`: corresponds to resource name. - `display_name`: corresponds to info type's display name."
  ([parent] (organizations-locations-storedInfoTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-storedInfoTypes-create
  "Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.storedInfoTypes/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateStoredInfoTypeRequest:
{:config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string},
 :locationId string,
 :storedInfoTypeId string}"
  [parent GooglePrivacyDlpV2CreateStoredInfoTypeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateStoredInfoTypeRequest}))

(defn organizations-locations-storedInfoTypes-patch
  "Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.storedInfoTypes/patch

name <string> Required. Resource name of organization and storedInfoType to be updated, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342.
GooglePrivacyDlpV2UpdateStoredInfoTypeRequest:
{:updateMask string,
 :config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string}}"
  [name GooglePrivacyDlpV2UpdateStoredInfoTypeRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateStoredInfoTypeRequest}))

(defn organizations-locations-storedInfoTypes-delete
  "Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.storedInfoTypes/delete

name <string> Required. Resource name of the organization and storedInfoType to be deleted, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-storedInfoTypes-get
  "Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.storedInfoTypes/get

name <string> Required. Resource name of the organization and storedInfoType to be read, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-columnDataProfiles-list
  "Lists column data profiles for an organization.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.columnDataProfiles/list

parent <string> Required. Resource name of the organization or project, for example `organizations/433245324/locations/europe` or `projects/project-id/locations/asia`.

optional:
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values: - `table_data_profile_name` - The name of the related table data profile. - `project_id` - The Google Cloud project ID. (REQUIRED) - `dataset_id` - The BigQuery dataset ID. (REQUIRED) - `table_id` - The BigQuery table ID. (REQUIRED) - `field_id` - The ID of the BigQuery field. - `info_type` - The infotype detected in the resource. - `sensitivity_level` - HIGH|MEDIUM|LOW - `data_risk_level`: How much risk is associated with this data. - `status_code` - an RPC status code as defined in https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto * The operator must be `=` for project_id, dataset_id, and table_id. Other filters also support `!=`. Examples: * project_id = 12345 AND status_code = 1 * project_id = 12345 AND sensitivity_level = HIGH * project_id = 12345 AND info_type = STREET_ADDRESS The length of this field should be no more than 500 characters.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Only one order field at a time is allowed. Examples: * `project_id asc` * `table_id` * `sensitivity_level desc` Supported fields are: - `project_id`: The Google Cloud project ID. - `dataset_id`: The ID of a BigQuery dataset. - `table_id`: The ID of a BigQuery table. - `sensitivity_level`: How sensitive the data in a column is, at most. - `data_risk_level`: How much risk is associated with this data. - `profile_last_generated`: When the profile was last updated in epoch seconds.
pageSize <integer> Size of the page. This value can be limited by the server. If zero, server returns a page of max size 100."
  ([parent]
    (organizations-locations-columnDataProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/columnDataProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-columnDataProfiles-get
  "Gets a column data profile.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.columnDataProfiles/get

name <string> Required. Resource name, for example `organizations/12345/locations/us/columnDataProfiles/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-dlpJobs-list
  "Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.dlpJobs/list

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values for inspect jobs: - `state` - PENDING|RUNNING|CANCELED|FINISHED|FAILED - `inspected_storage` - DATASTORE|CLOUD_STORAGE|BIGQUERY - `trigger_name` - The name of the trigger that created the job. - 'end_time` - Corresponds to the time the job finished. - 'start_time` - Corresponds to the time the job finished. * Supported fields for risk analysis jobs: - `state` - RUNNING|CANCELED|FINISHED|FAILED - 'end_time` - Corresponds to the time the job finished. - 'start_time` - Corresponds to the time the job finished. * The operator must be `=` or `!=`. Examples: * inspected_storage = cloud_storage AND state = done * inspected_storage = cloud_storage OR inspected_storage = bigquery * inspected_storage = cloud_storage AND (state = done OR state = canceled) * end_time > \\\"2017-12-12T00:00:00+00:00\\\" The length of this field should be no more than 500 characters.
type <string> The type of job. Defaults to `DlpJobType.INSPECT`
pageSize <integer> The standard list page size.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc, end_time asc, create_time desc` Supported fields are: - `create_time`: corresponds to the time the job was created. - `end_time`: corresponds to the time the job ended. - `name`: corresponds to the job's name. - `state`: corresponds to `state`"
  ([parent] (organizations-locations-dlpJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dlp.googleapis.com/v2/{+parent}/dlpJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-deidentifyTemplates-create
  "Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.deidentifyTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDeidentifyTemplateRequest:
{:deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string},
 :locationId string,
 :templateId string}"
  [parent GooglePrivacyDlpV2CreateDeidentifyTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDeidentifyTemplateRequest}))

(defn organizations-locations-deidentifyTemplates-get
  "Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.deidentifyTemplates/get

name <string> Required. Resource name of the organization and deidentify template to be read, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-deidentifyTemplates-delete
  "Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.deidentifyTemplates/delete

name <string> Required. Resource name of the organization and deidentify template to be deleted, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-deidentifyTemplates-list
  "Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.deidentifyTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100."
  ([parent]
    (organizations-locations-deidentifyTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-deidentifyTemplates-patch
  "Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.deidentifyTemplates/patch

name <string> Required. Resource name of organization and deidentify template to be updated, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342.
GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest:
{:updateMask string,
 :deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string}}"
  [name GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest}))

(defn organizations-locations-jobTriggers-delete
  "Deletes a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.jobTriggers/delete

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-jobTriggers-patch
  "Updates a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.jobTriggers/patch

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`.
GooglePrivacyDlpV2UpdateJobTriggerRequest:
{:jobTrigger
 {:description string,
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :inspectJob
  {:actions
   [{:publishToStackdriver object,
     :publishFindingsToCloudDataCatalog object,
     :saveFindings
     {:outputConfig GooglePrivacyDlpV2OutputStorageConfig},
     :jobNotificationEmails object,
     :pubSub {:topic string},
     :publishSummaryToCscc object,
     :deidentify
     {:transformationConfig GooglePrivacyDlpV2TransformationConfig,
      :cloudStorageOutput string,
      :transformationDetailsStorageConfig
      GooglePrivacyDlpV2TransformationDetailsStorageConfig,
      :fileTypesToTransform
      [[FILE_TYPE_UNSPECIFIED
        BINARY_FILE
        TEXT_FILE
        IMAGE
        WORD
        PDF
        AVRO
        CSV
        TSV
        POWERPOINT
        EXCEL]]}}],
   :storageConfig
   {:hybridOptions
    {:tableOptions GooglePrivacyDlpV2TableOptions,
     :labels object,
     :description string,
     :requiredFindingLabelKeys [string]},
    :datastoreOptions
    {:partitionId GooglePrivacyDlpV2PartitionId,
     :kind GooglePrivacyDlpV2KindExpression},
    :bigQueryOptions
    {:includedFields [GooglePrivacyDlpV2FieldId],
     :rowsLimitPercent integer,
     :excludedFields [GooglePrivacyDlpV2FieldId],
     :tableReference GooglePrivacyDlpV2BigQueryTable,
     :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :identifyingFields [GooglePrivacyDlpV2FieldId],
     :rowsLimit string},
    :timespanConfig
    {:endTime string,
     :enableAutoPopulationOfTimespanConfig boolean,
     :timestampField GooglePrivacyDlpV2FieldId,
     :startTime string},
    :cloudStorageOptions
    {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :fileTypes
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]],
     :bytesLimitPerFilePercent integer,
     :bytesLimitPerFile string,
     :filesLimitPercent integer,
     :fileSet GooglePrivacyDlpV2FileSet}},
   :inspectConfig
   {:ruleSet
    [{:rules [GooglePrivacyDlpV2InspectionRule],
      :infoTypes [GooglePrivacyDlpV2InfoType]}],
    :includeQuote boolean,
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
    :infoTypes
    [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string}],
    :excludeInfoTypes boolean,
    :customInfoTypes
    [{:infoType GooglePrivacyDlpV2InfoType,
      :surrogateType GooglePrivacyDlpV2SurrogateType,
      :sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :dictionary GooglePrivacyDlpV2Dictionary,
      :likelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY],
      :exclusionType
      [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
      :detectionRules [GooglePrivacyDlpV2DetectionRule],
      :regex GooglePrivacyDlpV2Regex,
      :storedType GooglePrivacyDlpV2StoredType}],
    :limits
    {:maxFindingsPerRequest integer,
     :maxFindingsPerItem integer,
     :maxFindingsPerInfoType [GooglePrivacyDlpV2InfoTypeLimit]},
    :minLikelihoodPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType,
      :minLikelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY]}]},
   :inspectTemplateName string},
  :name string,
  :createTime string,
  :triggers
  [{:schedule {:recurrencePeriodDuration string}, :manual object}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED HEALTHY PAUSED CANCELLED],
  :lastRunTime string},
 :updateMask string}"
  [name GooglePrivacyDlpV2UpdateJobTriggerRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateJobTriggerRequest}))

(defn organizations-locations-jobTriggers-get
  "Gets a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.jobTriggers/get

name <string> Required. Resource name of the project and the triggeredJob, for example `projects/dlp-test-project/jobTriggers/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-jobTriggers-list
  "Lists job triggers. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.jobTriggers/list

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
orderBy <string> Comma separated list of triggeredJob fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the JobTrigger was created. - `update_time`: corresponds to the time the JobTrigger was last updated. - `last_run_time`: corresponds to the last time the JobTrigger ran. - `name`: corresponds to the JobTrigger's name. - `display_name`: corresponds to the JobTrigger's display name. - `status`: corresponds to JobTrigger's status.
type <string> The type of jobs. Will use `DlpJobType.INSPECT` if not set.
pageSize <integer> Size of the page. This value can be limited by a server.
locationId <string> Deprecated. This field has no effect.
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values for inspect triggers: - `status` - HEALTHY|PAUSED|CANCELLED - `inspected_storage` - DATASTORE|CLOUD_STORAGE|BIGQUERY - 'last_run_time` - RFC 3339 formatted timestamp, surrounded by quotation marks. Nanoseconds are ignored. - 'error_count' - Number of errors that have occurred while running. * The operator must be `=` or `!=` for status and inspected_storage. Examples: * inspected_storage = cloud_storage AND status = HEALTHY * inspected_storage = cloud_storage OR inspected_storage = bigquery * inspected_storage = cloud_storage AND (state = PAUSED OR state = HEALTHY) * last_run_time > \\\"2017-12-12T00:00:00+00:00\\\" The length of this field should be no more than 500 characters."
  ([parent] (organizations-locations-jobTriggers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/jobTriggers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-jobTriggers-create
  "Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.jobTriggers/create

parent <string> Required. Parent resource name. The format of this value varies depending on whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateJobTriggerRequest:
{:triggerId string,
 :jobTrigger
 {:description string,
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :inspectJob
  {:actions
   [{:publishToStackdriver object,
     :publishFindingsToCloudDataCatalog object,
     :saveFindings
     {:outputConfig GooglePrivacyDlpV2OutputStorageConfig},
     :jobNotificationEmails object,
     :pubSub {:topic string},
     :publishSummaryToCscc object,
     :deidentify
     {:transformationConfig GooglePrivacyDlpV2TransformationConfig,
      :cloudStorageOutput string,
      :transformationDetailsStorageConfig
      GooglePrivacyDlpV2TransformationDetailsStorageConfig,
      :fileTypesToTransform
      [[FILE_TYPE_UNSPECIFIED
        BINARY_FILE
        TEXT_FILE
        IMAGE
        WORD
        PDF
        AVRO
        CSV
        TSV
        POWERPOINT
        EXCEL]]}}],
   :storageConfig
   {:hybridOptions
    {:tableOptions GooglePrivacyDlpV2TableOptions,
     :labels object,
     :description string,
     :requiredFindingLabelKeys [string]},
    :datastoreOptions
    {:partitionId GooglePrivacyDlpV2PartitionId,
     :kind GooglePrivacyDlpV2KindExpression},
    :bigQueryOptions
    {:includedFields [GooglePrivacyDlpV2FieldId],
     :rowsLimitPercent integer,
     :excludedFields [GooglePrivacyDlpV2FieldId],
     :tableReference GooglePrivacyDlpV2BigQueryTable,
     :sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :identifyingFields [GooglePrivacyDlpV2FieldId],
     :rowsLimit string},
    :timespanConfig
    {:endTime string,
     :enableAutoPopulationOfTimespanConfig boolean,
     :timestampField GooglePrivacyDlpV2FieldId,
     :startTime string},
    :cloudStorageOptions
    {:sampleMethod [SAMPLE_METHOD_UNSPECIFIED TOP RANDOM_START],
     :fileTypes
     [[FILE_TYPE_UNSPECIFIED
       BINARY_FILE
       TEXT_FILE
       IMAGE
       WORD
       PDF
       AVRO
       CSV
       TSV
       POWERPOINT
       EXCEL]],
     :bytesLimitPerFilePercent integer,
     :bytesLimitPerFile string,
     :filesLimitPercent integer,
     :fileSet GooglePrivacyDlpV2FileSet}},
   :inspectConfig
   {:ruleSet
    [{:rules [GooglePrivacyDlpV2InspectionRule],
      :infoTypes [GooglePrivacyDlpV2InfoType]}],
    :includeQuote boolean,
    :minLikelihood
    [LIKELIHOOD_UNSPECIFIED
     VERY_UNLIKELY
     UNLIKELY
     POSSIBLE
     LIKELY
     VERY_LIKELY],
    :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
    :infoTypes
    [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string}],
    :excludeInfoTypes boolean,
    :customInfoTypes
    [{:infoType GooglePrivacyDlpV2InfoType,
      :surrogateType GooglePrivacyDlpV2SurrogateType,
      :sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :dictionary GooglePrivacyDlpV2Dictionary,
      :likelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY],
      :exclusionType
      [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
      :detectionRules [GooglePrivacyDlpV2DetectionRule],
      :regex GooglePrivacyDlpV2Regex,
      :storedType GooglePrivacyDlpV2StoredType}],
    :limits
    {:maxFindingsPerRequest integer,
     :maxFindingsPerItem integer,
     :maxFindingsPerInfoType [GooglePrivacyDlpV2InfoTypeLimit]},
    :minLikelihoodPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType,
      :minLikelihood
      [LIKELIHOOD_UNSPECIFIED
       VERY_UNLIKELY
       UNLIKELY
       POSSIBLE
       LIKELY
       VERY_LIKELY]}]},
   :inspectTemplateName string},
  :name string,
  :createTime string,
  :triggers
  [{:schedule {:recurrencePeriodDuration string}, :manual object}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED HEALTHY PAUSED CANCELLED],
  :lastRunTime string},
 :locationId string}"
  [parent GooglePrivacyDlpV2CreateJobTriggerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/jobTriggers",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateJobTriggerRequest}))

(defn organizations-locations-projectDataProfiles-get
  "Gets a project data profile.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.projectDataProfiles/get

name <string> Required. Resource name, for example `organizations/12345/locations/us/projectDataProfiles/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-projectDataProfiles-list
  "Lists project data profiles for an organization.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.projectDataProfiles/list

parent <string> Required. organizations/{org_id}/locations/{loc_id}

optional:
filter <string> Allows filtering. Supported syntax: * Filter expressions are made up of one or more restrictions. * Restrictions can be combined by `AND` or `OR` logical operators. A sequence of restrictions implicitly uses `AND`. * A restriction has the form of `{field} {operator} {value}`. * Supported fields/values: - `sensitivity_level` - HIGH|MODERATE|LOW - `data_risk_level` - HIGH|MODERATE|LOW - `status_code` - an RPC status code as defined in https://github.com/googleapis/googleapis/blob/master/google/rpc/code.proto * The operator must be `=` or `!=`. Examples: * `project_id = 12345 AND status_code = 1` * `project_id = 12345 AND sensitivity_level = HIGH` The length of this field should be no more than 500 characters.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Only one order field at a time is allowed. Examples: * `project_id` * `sensitivity_level desc` Supported fields are: - `project_id`: Google Cloud project ID - `sensitivity_level`: How sensitive the data in a project is, at most. - `data_risk_level`: How much risk is associated with this data. - `profile_last_generated`: When the profile was last updated in epoch seconds.
pageSize <integer> Size of the page. This value can be limited by the server. If zero, server returns a page of max size 100."
  ([parent]
    (organizations-locations-projectDataProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/projectDataProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-connections-create
  "Create a Connection to an external data source.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.connections/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization): + Projects scope: `projects/`PROJECT_ID`/locations/`LOCATION_ID + Organizations scope: `organizations/`ORG_ID`/locations/`LOCATION_ID
GooglePrivacyDlpV2CreateConnectionRequest:
{:connection
 {:name string,
  :state
  [CONNECTION_STATE_UNSPECIFIED MISSING_CREDENTIALS AVAILABLE ERROR],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :cloudSql
  {:connectionName string,
   :cloudSqlIam object,
   :maxConnections integer,
   :databaseEngine
   [DATABASE_ENGINE_UNKNOWN
    DATABASE_ENGINE_MYSQL
    DATABASE_ENGINE_POSTGRES],
   :usernamePassword
   {:username string, :passwordSecretVersionName string}}}}"
  [parent GooglePrivacyDlpV2CreateConnectionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/connections",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateConnectionRequest}))

(defn organizations-locations-connections-delete
  "Delete a Connection.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.connections/delete

name <string> Required. Resource name of the Connection to be deleted, in the format: `projects/{project}/locations/{location}/connections/{connection}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-connections-search
  "Searches for Connections in a parent.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.connections/search

parent <string> Required. Parent name, typically an organization, without location. For example: `organizations/12345678`.

optional:
filter <string> Optional. Supported field/value: - `state` - MISSING|AVAILABLE|ERROR
pageSize <integer> Optional. Number of results per page, max 1000."
  ([parent] (organizations-locations-connections-search parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/connections:search",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-connections-get
  "Get a Connection by name.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.connections/get

name <string> Required. Resource name in the format: `projects/{project}/locations/{location}/connections/{connection}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-connections-patch
  "Update a Connection.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.connections/patch

name <string> Required. Resource name in the format: `projects/{project}/locations/{location}/connections/{connection}`.
GooglePrivacyDlpV2UpdateConnectionRequest:
{:updateMask string,
 :connection
 {:name string,
  :state
  [CONNECTION_STATE_UNSPECIFIED MISSING_CREDENTIALS AVAILABLE ERROR],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :cloudSql
  {:connectionName string,
   :cloudSqlIam object,
   :maxConnections integer,
   :databaseEngine
   [DATABASE_ENGINE_UNKNOWN
    DATABASE_ENGINE_MYSQL
    DATABASE_ENGINE_POSTGRES],
   :usernamePassword
   {:username string, :passwordSecretVersionName string}}}}"
  [name GooglePrivacyDlpV2UpdateConnectionRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateConnectionRequest}))

(defn organizations-locations-discoveryConfigs-create
  "Creates a config for discovery to scan and profile storage.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.discoveryConfigs/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization): + Projects scope: `projects/`PROJECT_ID`/locations/`LOCATION_ID + Organizations scope: `organizations/`ORG_ID`/locations/`LOCATION_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDiscoveryConfigRequest:
{:discoveryConfig
 {:inspectTemplates [string],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :name string,
  :createTime string,
  :orgConfig
  {:projectId string,
   :location {:folderId string, :organizationId string}},
  :targets
  [{:cloudSqlTarget
    {:filter
     {:databaseResourceReference
      GooglePrivacyDlpV2DatabaseResourceReference,
      :others GooglePrivacyDlpV2AllOtherDatabaseResources,
      :collection GooglePrivacyDlpV2DatabaseResourceCollection},
     :disabled object,
     :generationCadence
     {:schemaModifiedCadence GooglePrivacyDlpV2SchemaModifiedCadence,
      :refreshFrequency
      [UPDATE_FREQUENCY_UNSPECIFIED
       UPDATE_FREQUENCY_NEVER
       UPDATE_FREQUENCY_DAILY
       UPDATE_FREQUENCY_MONTHLY]},
     :conditions
     {:databaseEngines
      [[DATABASE_ENGINE_UNSPECIFIED
        ALL_SUPPORTED_DATABASE_ENGINES
        MYSQL
        POSTGRES]],
      :types
      [[DATABASE_RESOURCE_TYPE_UNSPECIFIED
        DATABASE_RESOURCE_TYPE_ALL_SUPPORTED_TYPES
        DATABASE_RESOURCE_TYPE_TABLE]]}},
    :bigQueryTarget
    {:cadence
     {:tableModifiedCadence
      GooglePrivacyDlpV2DiscoveryTableModifiedCadence,
      :schemaModifiedCadence
      GooglePrivacyDlpV2DiscoverySchemaModifiedCadence},
     :disabled object,
     :conditions
     {:types GooglePrivacyDlpV2BigQueryTableTypes,
      :orConditions GooglePrivacyDlpV2OrConditions,
      :createdAfter string,
      :typeCollection
      [BIG_QUERY_COLLECTION_UNSPECIFIED
       BIG_QUERY_COLLECTION_ALL_TYPES
       BIG_QUERY_COLLECTION_ONLY_SUPPORTED_TYPES]},
     :filter
     {:tables GooglePrivacyDlpV2BigQueryTableCollection,
      :tableReference GooglePrivacyDlpV2TableReference,
      :otherTables GooglePrivacyDlpV2AllOtherBigQueryTables}},
    :secretsTarget object}],
  :actions
  [{:exportData
    {:profileTable
     {:tableId string, :projectId string, :datasetId string}},
    :pubSubNotification
    {:detailOfMessage
     [DETAIL_LEVEL_UNSPECIFIED TABLE_PROFILE RESOURCE_NAME],
     :topic string,
     :pubsubCondition
     {:expressions GooglePrivacyDlpV2PubSubExpressions},
     :event
     [EVENT_TYPE_UNSPECIFIED
      NEW_PROFILE
      CHANGED_PROFILE
      SCORE_INCREASED
      ERROR_CHANGED]}}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED RUNNING PAUSED],
  :lastRunTime string},
 :configId string}"
  [parent GooglePrivacyDlpV2CreateDiscoveryConfigRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/discoveryConfigs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDiscoveryConfigRequest}))

(defn organizations-locations-discoveryConfigs-delete
  "Deletes a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.discoveryConfigs/delete

name <string> Required. Resource name of the project and the config, for example `projects/dlp-test-project/discoveryConfigs/53234423`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-discoveryConfigs-patch
  "Updates a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.discoveryConfigs/patch

name <string> Required. Resource name of the project and the configuration, for example `projects/dlp-test-project/discoveryConfigs/53234423`.
GooglePrivacyDlpV2UpdateDiscoveryConfigRequest:
{:updateMask string,
 :discoveryConfig
 {:inspectTemplates [string],
  :errors
  [{:details {:message string, :code integer, :details [object]},
    :timestamps [string]}],
  :displayName string,
  :name string,
  :createTime string,
  :orgConfig
  {:projectId string,
   :location {:folderId string, :organizationId string}},
  :targets
  [{:cloudSqlTarget
    {:filter
     {:databaseResourceReference
      GooglePrivacyDlpV2DatabaseResourceReference,
      :others GooglePrivacyDlpV2AllOtherDatabaseResources,
      :collection GooglePrivacyDlpV2DatabaseResourceCollection},
     :disabled object,
     :generationCadence
     {:schemaModifiedCadence GooglePrivacyDlpV2SchemaModifiedCadence,
      :refreshFrequency
      [UPDATE_FREQUENCY_UNSPECIFIED
       UPDATE_FREQUENCY_NEVER
       UPDATE_FREQUENCY_DAILY
       UPDATE_FREQUENCY_MONTHLY]},
     :conditions
     {:databaseEngines
      [[DATABASE_ENGINE_UNSPECIFIED
        ALL_SUPPORTED_DATABASE_ENGINES
        MYSQL
        POSTGRES]],
      :types
      [[DATABASE_RESOURCE_TYPE_UNSPECIFIED
        DATABASE_RESOURCE_TYPE_ALL_SUPPORTED_TYPES
        DATABASE_RESOURCE_TYPE_TABLE]]}},
    :bigQueryTarget
    {:cadence
     {:tableModifiedCadence
      GooglePrivacyDlpV2DiscoveryTableModifiedCadence,
      :schemaModifiedCadence
      GooglePrivacyDlpV2DiscoverySchemaModifiedCadence},
     :disabled object,
     :conditions
     {:types GooglePrivacyDlpV2BigQueryTableTypes,
      :orConditions GooglePrivacyDlpV2OrConditions,
      :createdAfter string,
      :typeCollection
      [BIG_QUERY_COLLECTION_UNSPECIFIED
       BIG_QUERY_COLLECTION_ALL_TYPES
       BIG_QUERY_COLLECTION_ONLY_SUPPORTED_TYPES]},
     :filter
     {:tables GooglePrivacyDlpV2BigQueryTableCollection,
      :tableReference GooglePrivacyDlpV2TableReference,
      :otherTables GooglePrivacyDlpV2AllOtherBigQueryTables}},
    :secretsTarget object}],
  :actions
  [{:exportData
    {:profileTable
     {:tableId string, :projectId string, :datasetId string}},
    :pubSubNotification
    {:detailOfMessage
     [DETAIL_LEVEL_UNSPECIFIED TABLE_PROFILE RESOURCE_NAME],
     :topic string,
     :pubsubCondition
     {:expressions GooglePrivacyDlpV2PubSubExpressions},
     :event
     [EVENT_TYPE_UNSPECIFIED
      NEW_PROFILE
      CHANGED_PROFILE
      SCORE_INCREASED
      ERROR_CHANGED]}}],
  :updateTime string,
  :status [STATUS_UNSPECIFIED RUNNING PAUSED],
  :lastRunTime string}}"
  [name GooglePrivacyDlpV2UpdateDiscoveryConfigRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateDiscoveryConfigRequest}))

(defn organizations-locations-discoveryConfigs-get
  "Gets a discovery configuration.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.discoveryConfigs/get

name <string> Required. Resource name of the project and the configuration, for example `projects/dlp-test-project/discoveryConfigs/53234423`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-discoveryConfigs-list
  "Lists discovery configurations.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.locations.discoveryConfigs/list

parent <string> Required. Parent resource name. The format of this value is as follows: `projects/`PROJECT_ID`/locations/`LOCATION_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
orderBy <string> Comma separated list of config fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `last_run_time`: corresponds to the last time the DiscoveryConfig ran. - `name`: corresponds to the DiscoveryConfig's name. - `status`: corresponds to DiscoveryConfig's status.
pageSize <integer> Size of the page. This value can be limited by a server."
  ([parent] (organizations-locations-discoveryConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/discoveryConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-deidentifyTemplates-get
  "Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.deidentifyTemplates/get

name <string> Required. Resource name of the organization and deidentify template to be read, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-deidentifyTemplates-delete
  "Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.deidentifyTemplates/delete

name <string> Required. Resource name of the organization and deidentify template to be deleted, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-deidentifyTemplates-create
  "Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.deidentifyTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateDeidentifyTemplateRequest:
{:deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string},
 :locationId string,
 :templateId string}"
  [parent GooglePrivacyDlpV2CreateDeidentifyTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateDeidentifyTemplateRequest}))

(defn organizations-deidentifyTemplates-list
  "Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.deidentifyTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name.
locationId <string> Deprecated. This field has no effect."
  ([parent] (organizations-deidentifyTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/deidentifyTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-deidentifyTemplates-patch
  "Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.deidentifyTemplates/patch

name <string> Required. Resource name of organization and deidentify template to be updated, for example `organizations/433245324/deidentifyTemplates/432452342` or projects/project-id/deidentifyTemplates/432452342.
GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest:
{:updateMask string,
 :deidentifyTemplate
 {:deidentifyConfig
  {:transformationErrorHandling
   {:leaveUntransformed object, :throwError object},
   :imageTransformations
   {:transforms
    [{:selectedInfoTypes GooglePrivacyDlpV2SelectedInfoTypes,
      :allInfoTypes GooglePrivacyDlpV2AllInfoTypes,
      :redactionColor GooglePrivacyDlpV2Color,
      :allText GooglePrivacyDlpV2AllText}]},
   :recordTransformations
   {:fieldTransformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypeTransformations
      GooglePrivacyDlpV2InfoTypeTransformations,
      :fields [GooglePrivacyDlpV2FieldId],
      :condition GooglePrivacyDlpV2RecordCondition}],
    :recordSuppressions
    [{:condition GooglePrivacyDlpV2RecordCondition}]},
   :infoTypeTransformations
   {:transformations
    [{:primitiveTransformation
      GooglePrivacyDlpV2PrimitiveTransformation,
      :infoTypes [GooglePrivacyDlpV2InfoType]}]}},
  :displayName string,
  :updateTime string,
  :name string,
  :description string,
  :createTime string}}"
  [name GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateDeidentifyTemplateRequest}))

(defn organizations-storedInfoTypes-create
  "Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.storedInfoTypes/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateStoredInfoTypeRequest:
{:config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string},
 :locationId string,
 :storedInfoTypeId string}"
  [parent GooglePrivacyDlpV2CreateStoredInfoTypeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateStoredInfoTypeRequest}))

(defn organizations-storedInfoTypes-patch
  "Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.storedInfoTypes/patch

name <string> Required. Resource name of organization and storedInfoType to be updated, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342.
GooglePrivacyDlpV2UpdateStoredInfoTypeRequest:
{:updateMask string,
 :config
 {:description string,
  :dictionary
  {:cloudStoragePath {:path string}, :wordList {:words [string]}},
  :largeCustomDictionary
  {:cloudStorageFileSet {:url string},
   :outputPath {:path string},
   :bigQueryField
   {:field {:name string},
    :table {:tableId string, :projectId string, :datasetId string}}},
  :regex {:groupIndexes [integer], :pattern string},
  :displayName string}}"
  [name GooglePrivacyDlpV2UpdateStoredInfoTypeRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateStoredInfoTypeRequest}))

(defn organizations-storedInfoTypes-delete
  "Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.storedInfoTypes/delete

name <string> Required. Resource name of the organization and storedInfoType to be deleted, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-storedInfoTypes-get
  "Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.storedInfoTypes/get

name <string> Required. Resource name of the organization and storedInfoType to be read, for example `organizations/433245324/storedInfoTypes/432452342` or projects/project-id/storedInfoTypes/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-storedInfoTypes-list
  "Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.storedInfoTypes/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc, display_name, create_time desc` Supported fields are: - `create_time`: corresponds to the time the most recent version of the resource was created. - `state`: corresponds to the state of the resource. - `name`: corresponds to resource name. - `display_name`: corresponds to info type's display name.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100."
  ([parent] (organizations-storedInfoTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/storedInfoTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-inspectTemplates-create
  "Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.inspectTemplates/create

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3
GooglePrivacyDlpV2CreateInspectTemplateRequest:
{:templateId string,
 :locationId string,
 :inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string}}"
  [parent GooglePrivacyDlpV2CreateInspectTemplateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2CreateInspectTemplateRequest}))

(defn organizations-inspectTemplates-get
  "Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.inspectTemplates/get

name <string> Required. Resource name of the organization and inspectTemplate to be read, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-inspectTemplates-list
  "Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.inspectTemplates/list

parent <string> Required. Parent resource name. The format of this value varies depending on the scope of the request (project or organization) and whether you have [specified a processing location](https://cloud.google.com/sensitive-data-protection/docs/specifying-location): + Projects scope, location specified: `projects/`PROJECT_ID`/locations/` LOCATION_ID + Projects scope, no location specified (defaults to global): `projects/`PROJECT_ID + Organizations scope, location specified: `organizations/`ORG_ID`/locations/`LOCATION_ID + Organizations scope, no location specified (defaults to global): `organizations/`ORG_ID The following example `parent` string specifies a parent project with the identifier `example-project`, and specifies the `europe-west3` location for processing data: parent=projects/example-project/locations/europe-west3

optional:
locationId <string> Deprecated. This field has no effect.
orderBy <string> Comma separated list of fields to order by, followed by `asc` or `desc` postfix. This list is case insensitive. The default sorting order is ascending. Redundant space characters are insignificant. Example: `name asc,update_time, create_time desc` Supported fields are: - `create_time`: corresponds to the time the template was created. - `update_time`: corresponds to the time the template was last updated. - `name`: corresponds to the template's name. - `display_name`: corresponds to the template's display name.
pageSize <integer> Size of the page. This value can be limited by the server. If zero server returns a page of max size 100."
  ([parent] (organizations-inspectTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/inspectTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-inspectTemplates-delete
  "Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.inspectTemplates/delete

name <string> Required. Resource name of the organization and inspectTemplate to be deleted, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-inspectTemplates-patch
  "Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/organizations.inspectTemplates/patch

name <string> Required. Resource name of organization and inspectTemplate to be updated, for example `organizations/433245324/inspectTemplates/432452342` or projects/project-id/inspectTemplates/432452342.
GooglePrivacyDlpV2UpdateInspectTemplateRequest:
{:inspectTemplate
 {:description string,
  :createTime string,
  :name string,
  :displayName string,
  :inspectConfig
  {:ruleSet
   [{:rules
     [{:hotwordRule GooglePrivacyDlpV2HotwordRule,
       :exclusionRule GooglePrivacyDlpV2ExclusionRule}],
     :infoTypes
     [{:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
       :version string,
       :name string}]}],
   :includeQuote boolean,
   :minLikelihood
   [LIKELIHOOD_UNSPECIFIED
    VERY_UNLIKELY
    UNLIKELY
    POSSIBLE
    LIKELY
    VERY_LIKELY],
   :contentOptions [[CONTENT_UNSPECIFIED CONTENT_TEXT CONTENT_IMAGE]],
   :infoTypes
   [{:sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :version string,
     :name string}],
   :excludeInfoTypes boolean,
   :customInfoTypes
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :surrogateType object,
     :sensitivityScore
     {:score
      [SENSITIVITY_SCORE_UNSPECIFIED
       SENSITIVITY_LOW
       SENSITIVITY_MODERATE
       SENSITIVITY_HIGH]},
     :dictionary
     {:cloudStoragePath GooglePrivacyDlpV2CloudStoragePath,
      :wordList GooglePrivacyDlpV2WordList},
     :likelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY],
     :exclusionType
     [EXCLUSION_TYPE_UNSPECIFIED EXCLUSION_TYPE_EXCLUDE],
     :detectionRules [{:hotwordRule GooglePrivacyDlpV2HotwordRule}],
     :regex {:groupIndexes [integer], :pattern string},
     :storedType {:createTime string, :name string}}],
   :limits
   {:maxFindingsPerRequest integer,
    :maxFindingsPerItem integer,
    :maxFindingsPerInfoType
    [{:infoType GooglePrivacyDlpV2InfoType, :maxFindings integer}]},
   :minLikelihoodPerInfoType
   [{:infoType
     {:sensitivityScore GooglePrivacyDlpV2SensitivityScore,
      :version string,
      :name string},
     :minLikelihood
     [LIKELIHOOD_UNSPECIFIED
      VERY_UNLIKELY
      UNLIKELY
      POSSIBLE
      LIKELY
      VERY_LIKELY]}]},
  :updateTime string},
 :updateMask string}"
  [name GooglePrivacyDlpV2UpdateInspectTemplateRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://dlp.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GooglePrivacyDlpV2UpdateInspectTemplateRequest}))

(defn locations-infoTypes-list
  "Returns a list of the sensitive information types that DLP API supports. See https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference to learn more.
https://cloud.google.com/sensitive-data-protection/docs/reference/rest/v2/locations.infoTypes/list

parent <string> The parent resource name. The format of this value is as follows: locations/ LOCATION_ID

optional:
filter <string> filter to only return infoTypes supported by certain parts of the API. Defaults to supported_by=INSPECT.
locationId <string> Deprecated. This field has no effect.
languageCode <string> BCP-47 language code for localized infoType friendly names. If omitted, or if localized strings are not available, en-US strings will be returned."
  ([parent] (locations-infoTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dlp.googleapis.com/v2/{+parent}/infoTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

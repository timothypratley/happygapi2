(ns happygapi2.contactcenterinsights
  "Contact Center AI Insights API

See: https://cloud.google.com/contact-center/insights/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-updateSettings
  "Updates project-level settings.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations/updateSettings

name <string> Immutable. The resource name of the settings resource. Format: projects/{project}/locations/{location}/settings
GoogleCloudContactcenterinsightsV1Settings:
{:pubsubNotificationSettings object,
 :conversationTtl string,
 :name string,
 :createTime string,
 :updateTime string,
 :speechConfig {:speechRecognizer string},
 :languageCode string,
 :redactionConfig
 {:inspectTemplate string, :deidentifyTemplate string},
 :analysisConfig
 {:uploadConversationAnalysisPercentage number,
  :annotatorSelector
  {:runPhraseMatcherAnnotator boolean,
   :runInterruptionAnnotator boolean,
   :runIssueModelAnnotator boolean,
   :runSilenceAnnotator boolean,
   :runSentimentAnnotator boolean,
   :runEntityAnnotator boolean,
   :phraseMatchers [string],
   :summarizationConfig
   {:summarizationModel
    [SUMMARIZATION_MODEL_UNSPECIFIED
     BASELINE_MODEL
     BASELINE_MODEL_V2_0],
    :conversationProfile string},
   :runIntentAnnotator boolean,
   :issueModels [string],
   :runSummarizationAnnotator boolean},
  :runtimeIntegrationAnalysisPercentage number}}

optional:
updateMask <string> Required. The list of fields to be updated."
  ([name GoogleCloudContactcenterinsightsV1Settings]
    (projects-locations-updateSettings
      name
      GoogleCloudContactcenterinsightsV1Settings
      nil))
  ([name GoogleCloudContactcenterinsightsV1Settings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudContactcenterinsightsV1Settings})))

(defn projects-locations-getSettings
  "Gets project-level settings.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations/getSettings

name <string> Required. The name of the settings resource to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-conversations-get
  "Gets a conversation.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/get

name <string> Required. The name of the conversation to get.

optional:
view <string> The level of details of the conversation. Default is `FULL`."
  ([name] (projects-locations-conversations-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversations-patch
  "Updates a conversation.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/patch

name <string> Immutable. The resource name of the conversation. Format: projects/{project}/locations/{location}/conversations/{conversation}
GoogleCloudContactcenterinsightsV1Conversation:
{:latestAnalysis
 {:analysisResult
  {:callAnalysisMetadata
   {:intents object,
    :silence {:silenceDuration string, :silencePercentage number},
    :annotations
    [{:annotationEndBoundary
      GoogleCloudContactcenterinsightsV1AnnotationBoundary,
      :entityMentionData
      GoogleCloudContactcenterinsightsV1EntityMentionData,
      :channelTag integer,
      :silenceData GoogleCloudContactcenterinsightsV1SilenceData,
      :sentimentData GoogleCloudContactcenterinsightsV1SentimentData,
      :annotationStartBoundary
      GoogleCloudContactcenterinsightsV1AnnotationBoundary,
      :intentMatchData
      GoogleCloudContactcenterinsightsV1IntentMatchData,
      :holdData GoogleCloudContactcenterinsightsV1HoldData,
      :phraseMatchData
      GoogleCloudContactcenterinsightsV1PhraseMatchData,
      :issueMatchData GoogleCloudContactcenterinsightsV1IssueMatchData,
      :interruptionData
      GoogleCloudContactcenterinsightsV1InterruptionData}],
    :entities object,
    :issueModelResult
    {:issues [GoogleCloudContactcenterinsightsV1IssueAssignment],
     :issueModel string},
    :sentiments
    [{:sentimentData GoogleCloudContactcenterinsightsV1SentimentData,
      :channelTag integer}],
    :phraseMatchers object},
   :endTime string},
  :name string,
  :requestTime string,
  :annotatorSelector
  {:runPhraseMatcherAnnotator boolean,
   :runInterruptionAnnotator boolean,
   :runIssueModelAnnotator boolean,
   :runSilenceAnnotator boolean,
   :runSentimentAnnotator boolean,
   :runEntityAnnotator boolean,
   :phraseMatchers [string],
   :summarizationConfig
   {:summarizationModel
    [SUMMARIZATION_MODEL_UNSPECIFIED
     BASELINE_MODEL
     BASELINE_MODEL_V2_0],
    :conversationProfile string},
   :runIntentAnnotator boolean,
   :issueModels [string],
   :runSummarizationAnnotator boolean},
  :createTime string},
 :labels object,
 :obfuscatedUserId string,
 :startTime string,
 :agentId string,
 :medium [MEDIUM_UNSPECIFIED PHONE_CALL CHAT],
 :name string,
 :runtimeAnnotations
 [{:smartComposeSuggestion
   {:queryRecord string,
    :metadata object,
    :suggestion string,
    :confidenceScore number},
   :endBoundary {:wordIndex integer, :transcriptIndex integer},
   :smartReply
   {:metadata object,
    :confidenceScore number,
    :queryRecord string,
    :reply string},
   :answerFeedback
   {:clicked boolean,
    :displayed boolean,
    :correctnessLevel
    [CORRECTNESS_LEVEL_UNSPECIFIED
     NOT_CORRECT
     PARTIALLY_CORRECT
     FULLY_CORRECT]},
   :createTime string,
   :startBoundary {:wordIndex integer, :transcriptIndex integer},
   :annotationId string,
   :dialogflowInteraction
   {:confidence number, :dialogflowIntentId string},
   :userInput {:generatorName string, :query string},
   :conversationSummarizationSuggestion
   {:metadata object,
    :text string,
    :textSections object,
    :answerRecord string,
    :conversationModel string,
    :confidence number},
   :faqAnswer
   {:confidenceScore number,
    :queryRecord string,
    :question string,
    :answer string,
    :metadata object,
    :source string},
   :articleSuggestion
   {:uri string,
    :title string,
    :source string,
    :confidenceScore number,
    :queryRecord string,
    :metadata object}}],
 :createTime string,
 :turnCount integer,
 :duration string,
 :updateTime string,
 :qualityMetadata
 {:waitDuration string,
  :agentInfo
  [{:agentId string,
    :team string,
    :displayName string,
    :dispositionCode string}],
  :menuPath string,
  :customerSatisfactionRating integer},
 :latestSummary
 {:metadata object,
  :text string,
  :textSections object,
  :answerRecord string,
  :conversationModel string,
  :confidence number},
 :ttl string,
 :languageCode string,
 :dataSource
 {:dialogflowSource {:audioUri string, :dialogflowConversation string},
  :gcsSource {:transcriptUri string, :audioUri string}},
 :expireTime string,
 :transcript
 {:transcriptSegments
  [{:dialogflowSegmentMetadata {:smartReplyAllowlistCovered boolean},
    :segmentParticipant
    {:dialogflowParticipantName string,
     :obfuscatedExternalUserId string,
     :role
     [ROLE_UNSPECIFIED HUMAN_AGENT AUTOMATED_AGENT END_USER ANY_AGENT],
     :dialogflowParticipant string,
     :userId string},
    :channelTag integer,
    :words
    [{:confidence number,
      :word string,
      :endOffset string,
      :startOffset string}],
    :sentiment {:score number, :magnitude number},
    :messageTime string,
    :languageCode string,
    :confidence number,
    :text string}]},
 :dialogflowIntents object,
 :callMetadata {:agentChannel integer, :customerChannel integer}}

optional:
updateMask <string> The list of fields to be updated. All possible fields can be updated by passing `*`, or a subset of the following updateable fields can be provided: * `agent_id` * `language_code` * `labels` * `metadata` * `quality_metadata` * `call_metadata` * `start_time` * `expire_time` or `ttl` * `data_source.gcs_source.audio_uri` or `data_source.dialogflow_source.audio_uri`"
  ([name GoogleCloudContactcenterinsightsV1Conversation]
    (projects-locations-conversations-patch
      name
      GoogleCloudContactcenterinsightsV1Conversation
      nil))
  ([name GoogleCloudContactcenterinsightsV1Conversation optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudContactcenterinsightsV1Conversation})))

(defn projects-locations-conversations-create
  "Creates a conversation. Does not support audio transcription or DLP redaction. Use `conversations.upload` instead.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/create

parent <string> Required. The parent resource of the conversation.
GoogleCloudContactcenterinsightsV1Conversation:
{:latestAnalysis
 {:analysisResult
  {:callAnalysisMetadata
   {:intents object,
    :silence {:silenceDuration string, :silencePercentage number},
    :annotations
    [{:annotationEndBoundary
      GoogleCloudContactcenterinsightsV1AnnotationBoundary,
      :entityMentionData
      GoogleCloudContactcenterinsightsV1EntityMentionData,
      :channelTag integer,
      :silenceData GoogleCloudContactcenterinsightsV1SilenceData,
      :sentimentData GoogleCloudContactcenterinsightsV1SentimentData,
      :annotationStartBoundary
      GoogleCloudContactcenterinsightsV1AnnotationBoundary,
      :intentMatchData
      GoogleCloudContactcenterinsightsV1IntentMatchData,
      :holdData GoogleCloudContactcenterinsightsV1HoldData,
      :phraseMatchData
      GoogleCloudContactcenterinsightsV1PhraseMatchData,
      :issueMatchData GoogleCloudContactcenterinsightsV1IssueMatchData,
      :interruptionData
      GoogleCloudContactcenterinsightsV1InterruptionData}],
    :entities object,
    :issueModelResult
    {:issues [GoogleCloudContactcenterinsightsV1IssueAssignment],
     :issueModel string},
    :sentiments
    [{:sentimentData GoogleCloudContactcenterinsightsV1SentimentData,
      :channelTag integer}],
    :phraseMatchers object},
   :endTime string},
  :name string,
  :requestTime string,
  :annotatorSelector
  {:runPhraseMatcherAnnotator boolean,
   :runInterruptionAnnotator boolean,
   :runIssueModelAnnotator boolean,
   :runSilenceAnnotator boolean,
   :runSentimentAnnotator boolean,
   :runEntityAnnotator boolean,
   :phraseMatchers [string],
   :summarizationConfig
   {:summarizationModel
    [SUMMARIZATION_MODEL_UNSPECIFIED
     BASELINE_MODEL
     BASELINE_MODEL_V2_0],
    :conversationProfile string},
   :runIntentAnnotator boolean,
   :issueModels [string],
   :runSummarizationAnnotator boolean},
  :createTime string},
 :labels object,
 :obfuscatedUserId string,
 :startTime string,
 :agentId string,
 :medium [MEDIUM_UNSPECIFIED PHONE_CALL CHAT],
 :name string,
 :runtimeAnnotations
 [{:smartComposeSuggestion
   {:queryRecord string,
    :metadata object,
    :suggestion string,
    :confidenceScore number},
   :endBoundary {:wordIndex integer, :transcriptIndex integer},
   :smartReply
   {:metadata object,
    :confidenceScore number,
    :queryRecord string,
    :reply string},
   :answerFeedback
   {:clicked boolean,
    :displayed boolean,
    :correctnessLevel
    [CORRECTNESS_LEVEL_UNSPECIFIED
     NOT_CORRECT
     PARTIALLY_CORRECT
     FULLY_CORRECT]},
   :createTime string,
   :startBoundary {:wordIndex integer, :transcriptIndex integer},
   :annotationId string,
   :dialogflowInteraction
   {:confidence number, :dialogflowIntentId string},
   :userInput {:generatorName string, :query string},
   :conversationSummarizationSuggestion
   {:metadata object,
    :text string,
    :textSections object,
    :answerRecord string,
    :conversationModel string,
    :confidence number},
   :faqAnswer
   {:confidenceScore number,
    :queryRecord string,
    :question string,
    :answer string,
    :metadata object,
    :source string},
   :articleSuggestion
   {:uri string,
    :title string,
    :source string,
    :confidenceScore number,
    :queryRecord string,
    :metadata object}}],
 :createTime string,
 :turnCount integer,
 :duration string,
 :updateTime string,
 :qualityMetadata
 {:waitDuration string,
  :agentInfo
  [{:agentId string,
    :team string,
    :displayName string,
    :dispositionCode string}],
  :menuPath string,
  :customerSatisfactionRating integer},
 :latestSummary
 {:metadata object,
  :text string,
  :textSections object,
  :answerRecord string,
  :conversationModel string,
  :confidence number},
 :ttl string,
 :languageCode string,
 :dataSource
 {:dialogflowSource {:audioUri string, :dialogflowConversation string},
  :gcsSource {:transcriptUri string, :audioUri string}},
 :expireTime string,
 :transcript
 {:transcriptSegments
  [{:dialogflowSegmentMetadata {:smartReplyAllowlistCovered boolean},
    :segmentParticipant
    {:dialogflowParticipantName string,
     :obfuscatedExternalUserId string,
     :role
     [ROLE_UNSPECIFIED HUMAN_AGENT AUTOMATED_AGENT END_USER ANY_AGENT],
     :dialogflowParticipant string,
     :userId string},
    :channelTag integer,
    :words
    [{:confidence number,
      :word string,
      :endOffset string,
      :startOffset string}],
    :sentiment {:score number, :magnitude number},
    :messageTime string,
    :languageCode string,
    :confidence number,
    :text string}]},
 :dialogflowIntents object,
 :callMetadata {:agentChannel integer, :customerChannel integer}}

optional:
conversationId <string> A unique ID for the new conversation. This ID will become the final component of the conversation's resource name. If no ID is specified, a server-generated ID will be used. This value should be 4-64 characters and must match the regular expression `^[a-z0-9-]{4,64}$`. Valid characters are `a-z-`"
  ([parent GoogleCloudContactcenterinsightsV1Conversation]
    (projects-locations-conversations-create
      parent
      GoogleCloudContactcenterinsightsV1Conversation
      nil))
  ([parent GoogleCloudContactcenterinsightsV1Conversation optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+parent}/conversations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudContactcenterinsightsV1Conversation})))

(defn projects-locations-conversations-delete
  "Deletes a conversation.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/delete

name <string> Required. The name of the conversation to delete.

optional:
force <boolean> If set to true, all of this conversation's analyses will also be deleted. Otherwise, the request will only succeed if the conversation has no analyses."
  ([name] (projects-locations-conversations-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversations-list
  "Lists conversations.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/list

parent <string> Required. The parent resource of the conversation.

optional:
view <string> The level of details of the conversation. Default is `BASIC`.
orderBy <string> Optional. The attribute by which to order conversations in the response. If empty, conversations will be ordered by descending creation time. Supported values are one of the following: * create_time * customer_satisfaction_rating * duration * latest_analysis * start_time * turn_count The default sort order is ascending. To specify order, append `asc` or `desc` (`create_time desc`). For more details, see [Google AIPs Ordering](https://google.aip.dev/132#ordering).
pageSize <integer> The maximum number of conversations to return in the response. A valid page size ranges from 0 to 1,000 inclusive. If the page size is zero or unspecified, a default page size of 100 will be chosen. Note that a call might return fewer results than the requested page size.
filter <string> A filter to reduce results to a specific subset. Useful for querying conversations with specific properties."
  ([parent] (projects-locations-conversations-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+parent}/conversations",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversations-ingest
  "Imports conversations and processes them according to the user's configuration.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/ingest

parent <string> Required. The parent resource for new conversations.
GoogleCloudContactcenterinsightsV1IngestConversationsRequest:
{:sampleSize integer,
 :transcriptObjectConfig
 {:medium [MEDIUM_UNSPECIFIED PHONE_CALL CHAT]},
 :gcsSource
 {:bucketObjectType [BUCKET_OBJECT_TYPE_UNSPECIFIED TRANSCRIPT AUDIO],
  :bucketUri string,
  :metadataBucketUri string,
  :customMetadataKeys [string]},
 :parent string,
 :speechConfig {:speechRecognizer string},
 :redactionConfig
 {:inspectTemplate string, :deidentifyTemplate string},
 :conversationConfig
 {:agentChannel integer, :agentId string, :customerChannel integer}}"
  [parent GoogleCloudContactcenterinsightsV1IngestConversationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/conversations:ingest",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudContactcenterinsightsV1IngestConversationsRequest}))

(defn projects-locations-conversations-calculateStats
  "Gets conversation statistics.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/calculateStats

location <string> Required. The location of the conversations.

optional:
filter <string> A filter to reduce results to a specific subset. This field is useful for getting statistics about conversations with specific properties."
  ([location]
    (projects-locations-conversations-calculateStats location nil))
  ([location optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+location}/conversations:calculateStats",
       :uri-template-args {:location location},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversations-bulkAnalyze
  "Analyzes multiple conversations in a single request.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/bulkAnalyze

parent <string> Required. The parent resource to create analyses in.
GoogleCloudContactcenterinsightsV1BulkAnalyzeConversationsRequest:
{:annotatorSelector
 {:runPhraseMatcherAnnotator boolean,
  :runInterruptionAnnotator boolean,
  :runIssueModelAnnotator boolean,
  :runSilenceAnnotator boolean,
  :runSentimentAnnotator boolean,
  :runEntityAnnotator boolean,
  :phraseMatchers [string],
  :summarizationConfig
  {:summarizationModel
   [SUMMARIZATION_MODEL_UNSPECIFIED
    BASELINE_MODEL
    BASELINE_MODEL_V2_0],
   :conversationProfile string},
  :runIntentAnnotator boolean,
  :issueModels [string],
  :runSummarizationAnnotator boolean},
 :parent string,
 :analysisPercentage number,
 :filter string}"
  [parent
   GoogleCloudContactcenterinsightsV1BulkAnalyzeConversationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/conversations:bulkAnalyze",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudContactcenterinsightsV1BulkAnalyzeConversationsRequest}))

(defn projects-locations-conversations-bulkDelete
  "Deletes multiple conversations in a single request.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/bulkDelete

parent <string> Required. The parent resource to delete conversations from. Format: projects/{project}/locations/{location}
GoogleCloudContactcenterinsightsV1BulkDeleteConversationsRequest:
{:filter string,
 :parent string,
 :maxDeleteCount integer,
 :force boolean}"
  [parent
   GoogleCloudContactcenterinsightsV1BulkDeleteConversationsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/conversations:bulkDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudContactcenterinsightsV1BulkDeleteConversationsRequest}))

(defn projects-locations-conversations-upload
  "Create a long-running conversation upload operation. This method differs from `CreateConversation` by allowing audio transcription and optional DLP redaction.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations/upload

parent <string> Required. The parent resource of the conversation.
GoogleCloudContactcenterinsightsV1UploadConversationRequest:
{:parent string,
 :conversationId string,
 :speechConfig {:speechRecognizer string},
 :redactionConfig
 {:inspectTemplate string, :deidentifyTemplate string},
 :conversation
 {:latestAnalysis
  {:analysisResult
   {:callAnalysisMetadata
    {:intents object,
     :silence
     GoogleCloudContactcenterinsightsV1ConversationLevelSilence,
     :annotations [GoogleCloudContactcenterinsightsV1CallAnnotation],
     :entities object,
     :issueModelResult
     GoogleCloudContactcenterinsightsV1IssueModelResult,
     :sentiments
     [GoogleCloudContactcenterinsightsV1ConversationLevelSentiment],
     :phraseMatchers object},
    :endTime string},
   :name string,
   :requestTime string,
   :annotatorSelector
   {:runPhraseMatcherAnnotator boolean,
    :runInterruptionAnnotator boolean,
    :runIssueModelAnnotator boolean,
    :runSilenceAnnotator boolean,
    :runSentimentAnnotator boolean,
    :runEntityAnnotator boolean,
    :phraseMatchers [string],
    :summarizationConfig
    {:summarizationModel
     [SUMMARIZATION_MODEL_UNSPECIFIED
      BASELINE_MODEL
      BASELINE_MODEL_V2_0],
     :conversationProfile string},
    :runIntentAnnotator boolean,
    :issueModels [string],
    :runSummarizationAnnotator boolean},
   :createTime string},
  :labels object,
  :obfuscatedUserId string,
  :startTime string,
  :agentId string,
  :medium [MEDIUM_UNSPECIFIED PHONE_CALL CHAT],
  :name string,
  :runtimeAnnotations
  [{:smartComposeSuggestion
    {:queryRecord string,
     :metadata object,
     :suggestion string,
     :confidenceScore number},
    :endBoundary {:wordIndex integer, :transcriptIndex integer},
    :smartReply
    {:metadata object,
     :confidenceScore number,
     :queryRecord string,
     :reply string},
    :answerFeedback
    {:clicked boolean,
     :displayed boolean,
     :correctnessLevel
     [CORRECTNESS_LEVEL_UNSPECIFIED
      NOT_CORRECT
      PARTIALLY_CORRECT
      FULLY_CORRECT]},
    :createTime string,
    :startBoundary {:wordIndex integer, :transcriptIndex integer},
    :annotationId string,
    :dialogflowInteraction
    {:confidence number, :dialogflowIntentId string},
    :userInput {:generatorName string, :query string},
    :conversationSummarizationSuggestion
    {:metadata object,
     :text string,
     :textSections object,
     :answerRecord string,
     :conversationModel string,
     :confidence number},
    :faqAnswer
    {:confidenceScore number,
     :queryRecord string,
     :question string,
     :answer string,
     :metadata object,
     :source string},
    :articleSuggestion
    {:uri string,
     :title string,
     :source string,
     :confidenceScore number,
     :queryRecord string,
     :metadata object}}],
  :createTime string,
  :turnCount integer,
  :duration string,
  :updateTime string,
  :qualityMetadata
  {:waitDuration string,
   :agentInfo
   [{:agentId string,
     :team string,
     :displayName string,
     :dispositionCode string}],
   :menuPath string,
   :customerSatisfactionRating integer},
  :latestSummary
  {:metadata object,
   :text string,
   :textSections object,
   :answerRecord string,
   :conversationModel string,
   :confidence number},
  :ttl string,
  :languageCode string,
  :dataSource
  {:dialogflowSource
   {:audioUri string, :dialogflowConversation string},
   :gcsSource {:transcriptUri string, :audioUri string}},
  :expireTime string,
  :transcript
  {:transcriptSegments
   [{:dialogflowSegmentMetadata {:smartReplyAllowlistCovered boolean},
     :segmentParticipant
     {:dialogflowParticipantName string,
      :obfuscatedExternalUserId string,
      :role
      [ROLE_UNSPECIFIED
       HUMAN_AGENT
       AUTOMATED_AGENT
       END_USER
       ANY_AGENT],
      :dialogflowParticipant string,
      :userId string},
     :channelTag integer,
     :words
     [{:confidence number,
       :word string,
       :endOffset string,
       :startOffset string}],
     :sentiment {:score number, :magnitude number},
     :messageTime string,
     :languageCode string,
     :confidence number,
     :text string}]},
  :dialogflowIntents object,
  :callMetadata {:agentChannel integer, :customerChannel integer}}}"
  [parent GoogleCloudContactcenterinsightsV1UploadConversationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/conversations:upload",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudContactcenterinsightsV1UploadConversationRequest}))

(defn projects-locations-conversations-analyses-create
  "Creates an analysis. The long running operation is done when the analysis has completed.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations.analyses/create

parent <string> Required. The parent resource of the analysis.
GoogleCloudContactcenterinsightsV1Analysis:
{:analysisResult
 {:callAnalysisMetadata
  {:intents object,
   :silence {:silenceDuration string, :silencePercentage number},
   :annotations
   [{:annotationEndBoundary
     {:wordIndex integer, :transcriptIndex integer},
     :entityMentionData
     {:sentiment GoogleCloudContactcenterinsightsV1SentimentData,
      :type [MENTION_TYPE_UNSPECIFIED PROPER COMMON],
      :entityUniqueId string},
     :channelTag integer,
     :silenceData object,
     :sentimentData {:score number, :magnitude number},
     :annotationStartBoundary
     {:wordIndex integer, :transcriptIndex integer},
     :intentMatchData {:intentUniqueId string},
     :holdData object,
     :phraseMatchData {:displayName string, :phraseMatcher string},
     :issueMatchData
     {:issueAssignment
      GoogleCloudContactcenterinsightsV1IssueAssignment},
     :interruptionData object}],
   :entities object,
   :issueModelResult
   {:issues [{:displayName string, :issue string, :score number}],
    :issueModel string},
   :sentiments
   [{:sentimentData {:score number, :magnitude number},
     :channelTag integer}],
   :phraseMatchers object},
  :endTime string},
 :name string,
 :requestTime string,
 :annotatorSelector
 {:runPhraseMatcherAnnotator boolean,
  :runInterruptionAnnotator boolean,
  :runIssueModelAnnotator boolean,
  :runSilenceAnnotator boolean,
  :runSentimentAnnotator boolean,
  :runEntityAnnotator boolean,
  :phraseMatchers [string],
  :summarizationConfig
  {:summarizationModel
   [SUMMARIZATION_MODEL_UNSPECIFIED
    BASELINE_MODEL
    BASELINE_MODEL_V2_0],
   :conversationProfile string},
  :runIntentAnnotator boolean,
  :issueModels [string],
  :runSummarizationAnnotator boolean},
 :createTime string}"
  [parent GoogleCloudContactcenterinsightsV1Analysis]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/analyses",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContactcenterinsightsV1Analysis}))

(defn projects-locations-conversations-analyses-get
  "Gets an analysis.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations.analyses/get

name <string> Required. The name of the analysis to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-conversations-analyses-delete
  "Deletes an analysis.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations.analyses/delete

name <string> Required. The name of the analysis to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-conversations-analyses-list
  "Lists analyses.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.conversations.analyses/list

parent <string> Required. The parent resource of the analyses.

optional:
filter <string> A filter to reduce results to a specific subset. Useful for querying conversations with specific properties.
pageSize <integer> The maximum number of analyses to return in the response. If this value is zero, the service will select a default size. A call might return fewer objects than requested. A non-empty `next_page_token` in the response indicates that more data is available."
  ([parent]
    (projects-locations-conversations-analyses-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+parent}/analyses",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-views-get
  "Gets a view.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.views/get

name <string> Required. The name of the view to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-views-create
  "Creates a view.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.views/create

parent <string> Required. The parent resource of the view. Required. The location to create a view for. Format: `projects//locations/` or `projects//locations/`
GoogleCloudContactcenterinsightsV1View:
{:displayName string,
 :value string,
 :name string,
 :createTime string,
 :updateTime string}"
  [parent GoogleCloudContactcenterinsightsV1View]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/views",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContactcenterinsightsV1View}))

(defn projects-locations-views-list
  "Lists views.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.views/list

parent <string> Required. The parent resource of the views.

optional:
pageSize <integer> The maximum number of views to return in the response. If this value is zero, the service will select a default size. A call may return fewer objects than requested. A non-empty `next_page_token` in the response indicates that more data is available."
  ([parent] (projects-locations-views-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+parent}/views",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-views-delete
  "Deletes a view.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.views/delete

name <string> Required. The name of the view to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-views-patch
  "Updates a view.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.views/patch

name <string> Immutable. The resource name of the view. Format: projects/{project}/locations/{location}/views/{view}
GoogleCloudContactcenterinsightsV1View:
{:displayName string,
 :value string,
 :name string,
 :createTime string,
 :updateTime string}

optional:
updateMask <string> The list of fields to be updated."
  ([name GoogleCloudContactcenterinsightsV1View]
    (projects-locations-views-patch
      name
      GoogleCloudContactcenterinsightsV1View
      nil))
  ([name GoogleCloudContactcenterinsightsV1View optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudContactcenterinsightsV1View})))

(defn projects-locations-issueModels-undeploy
  "Undeploys an issue model. An issue model can not be used in analysis after it has been undeployed.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/undeploy

name <string> Required. The issue model to undeploy.
GoogleCloudContactcenterinsightsV1UndeployIssueModelRequest:
{:name string}"
  [name GoogleCloudContactcenterinsightsV1UndeployIssueModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}:undeploy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudContactcenterinsightsV1UndeployIssueModelRequest}))

(defn projects-locations-issueModels-get
  "Gets an issue model.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/get

name <string> Required. The name of the issue model to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-issueModels-patch
  "Updates an issue model.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/patch

name <string> Immutable. The resource name of the issue model. Format: projects/{project}/locations/{location}/issueModels/{issue_model}
GoogleCloudContactcenterinsightsV1IssueModel:
{:modelType [MODEL_TYPE_UNSPECIFIED TYPE_V1 TYPE_V2],
 :displayName string,
 :name string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  UNDEPLOYED
  DEPLOYING
  DEPLOYED
  UNDEPLOYING
  DELETING],
 :updateTime string,
 :languageCode string,
 :inputDataConfig
 {:filter string,
  :medium [MEDIUM_UNSPECIFIED PHONE_CALL CHAT],
  :trainingConversationsCount string},
 :issueCount string,
 :trainingStats
 {:analyzedConversationsCount string,
  :issueStats object,
  :unclassifiedConversationsCount string}}

optional:
updateMask <string> The list of fields to be updated."
  ([name GoogleCloudContactcenterinsightsV1IssueModel]
    (projects-locations-issueModels-patch
      name
      GoogleCloudContactcenterinsightsV1IssueModel
      nil))
  ([name GoogleCloudContactcenterinsightsV1IssueModel optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudContactcenterinsightsV1IssueModel})))

(defn projects-locations-issueModels-create
  "Creates an issue model.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/create

parent <string> Required. The parent resource of the issue model.
GoogleCloudContactcenterinsightsV1IssueModel:
{:modelType [MODEL_TYPE_UNSPECIFIED TYPE_V1 TYPE_V2],
 :displayName string,
 :name string,
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  UNDEPLOYED
  DEPLOYING
  DEPLOYED
  UNDEPLOYING
  DELETING],
 :updateTime string,
 :languageCode string,
 :inputDataConfig
 {:filter string,
  :medium [MEDIUM_UNSPECIFIED PHONE_CALL CHAT],
  :trainingConversationsCount string},
 :issueCount string,
 :trainingStats
 {:analyzedConversationsCount string,
  :issueStats object,
  :unclassifiedConversationsCount string}}"
  [parent GoogleCloudContactcenterinsightsV1IssueModel]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/issueModels",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContactcenterinsightsV1IssueModel}))

(defn projects-locations-issueModels-calculateIssueModelStats
  "Gets an issue model's statistics.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/calculateIssueModelStats

issueModel <string> Required. The resource name of the issue model to query against."
  [issueModel]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+issueModel}:calculateIssueModelStats",
     :uri-template-args {:issueModel issueModel},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-issueModels-delete
  "Deletes an issue model.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/delete

name <string> Required. The name of the issue model to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-issueModels-export
  "Exports an issue model to the provided destination.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/export

name <string> Required. The issue model to export.
GoogleCloudContactcenterinsightsV1ExportIssueModelRequest:
{:name string, :gcsDestination {:objectUri string}}"
  [name GoogleCloudContactcenterinsightsV1ExportIssueModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}:export",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContactcenterinsightsV1ExportIssueModelRequest}))

(defn projects-locations-issueModels-list
  "Lists issue models.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/list

parent <string> Required. The parent resource of the issue model."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/issueModels",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-issueModels-import
  "Imports an issue model from a Cloud Storage bucket.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/import

parent <string> Required. The parent resource of the issue model.
GoogleCloudContactcenterinsightsV1ImportIssueModelRequest:
{:parent string,
 :gcsSource {:objectUri string},
 :createNewModel boolean}"
  [parent GoogleCloudContactcenterinsightsV1ImportIssueModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/issueModels:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContactcenterinsightsV1ImportIssueModelRequest}))

(defn projects-locations-issueModels-deploy
  "Deploys an issue model. Returns an error if a model is already deployed. An issue model can only be used in analysis after it has been deployed.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels/deploy

name <string> Required. The issue model to deploy.
GoogleCloudContactcenterinsightsV1DeployIssueModelRequest:
{:name string}"
  [name GoogleCloudContactcenterinsightsV1DeployIssueModelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}:deploy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContactcenterinsightsV1DeployIssueModelRequest}))

(defn projects-locations-issueModels-issues-get
  "Gets an issue.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels.issues/get

name <string> Required. The name of the issue to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-issueModels-issues-list
  "Lists issues.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels.issues/list

parent <string> Required. The parent resource of the issue."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/issues",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-issueModels-issues-delete
  "Deletes an issue.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels.issues/delete

name <string> Required. The name of the issue to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-issueModels-issues-patch
  "Updates an issue.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.issueModels.issues/patch

name <string> Immutable. The resource name of the issue. Format: projects/{project}/locations/{location}/issueModels/{issue_model}/issues/{issue}
GoogleCloudContactcenterinsightsV1Issue:
{:displayName string,
 :name string,
 :updateTime string,
 :sampleUtterances [string],
 :createTime string}

optional:
updateMask <string> The list of fields to be updated."
  ([name GoogleCloudContactcenterinsightsV1Issue]
    (projects-locations-issueModels-issues-patch
      name
      GoogleCloudContactcenterinsightsV1Issue
      nil))
  ([name GoogleCloudContactcenterinsightsV1Issue optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudContactcenterinsightsV1Issue})))

(defn projects-locations-phraseMatchers-create
  "Creates a phrase matcher.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.phraseMatchers/create

parent <string> Required. The parent resource of the phrase matcher. Required. The location to create a phrase matcher for. Format: `projects//locations/` or `projects//locations/`
GoogleCloudContactcenterinsightsV1PhraseMatcher:
{:displayName string,
 :revisionCreateTime string,
 :name string,
 :revisionId string,
 :activationUpdateTime string,
 :type [PHRASE_MATCHER_TYPE_UNSPECIFIED ALL_OF ANY_OF],
 :versionTag string,
 :updateTime string,
 :active boolean,
 :phraseMatchRuleGroups
 [{:phraseMatchRules
   [{:config {:exactMatchConfig {:caseSensitive boolean}},
     :negated boolean,
     :query string}],
   :type [PHRASE_MATCH_RULE_GROUP_TYPE_UNSPECIFIED ALL_OF ANY_OF]}],
 :roleMatch
 [ROLE_UNSPECIFIED HUMAN_AGENT AUTOMATED_AGENT END_USER ANY_AGENT]}"
  [parent GoogleCloudContactcenterinsightsV1PhraseMatcher]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/phraseMatchers",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudContactcenterinsightsV1PhraseMatcher}))

(defn projects-locations-phraseMatchers-patch
  "Updates a phrase matcher.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.phraseMatchers/patch

name <string> The resource name of the phrase matcher. Format: projects/{project}/locations/{location}/phraseMatchers/{phrase_matcher}
GoogleCloudContactcenterinsightsV1PhraseMatcher:
{:displayName string,
 :revisionCreateTime string,
 :name string,
 :revisionId string,
 :activationUpdateTime string,
 :type [PHRASE_MATCHER_TYPE_UNSPECIFIED ALL_OF ANY_OF],
 :versionTag string,
 :updateTime string,
 :active boolean,
 :phraseMatchRuleGroups
 [{:phraseMatchRules
   [{:config {:exactMatchConfig {:caseSensitive boolean}},
     :negated boolean,
     :query string}],
   :type [PHRASE_MATCH_RULE_GROUP_TYPE_UNSPECIFIED ALL_OF ANY_OF]}],
 :roleMatch
 [ROLE_UNSPECIFIED HUMAN_AGENT AUTOMATED_AGENT END_USER ANY_AGENT]}

optional:
updateMask <string> The list of fields to be updated."
  ([name GoogleCloudContactcenterinsightsV1PhraseMatcher]
    (projects-locations-phraseMatchers-patch
      name
      GoogleCloudContactcenterinsightsV1PhraseMatcher
      nil))
  ([name GoogleCloudContactcenterinsightsV1PhraseMatcher optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudContactcenterinsightsV1PhraseMatcher})))

(defn projects-locations-phraseMatchers-delete
  "Deletes a phrase matcher.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.phraseMatchers/delete

name <string> Required. The name of the phrase matcher to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-phraseMatchers-list
  "Lists phrase matchers.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.phraseMatchers/list

parent <string> Required. The parent resource of the phrase matcher.

optional:
filter <string> A filter to reduce results to a specific subset. Useful for querying phrase matchers with specific properties.
pageSize <integer> The maximum number of phrase matchers to return in the response. If this value is zero, the service will select a default size. A call might return fewer objects than requested. A non-empty `next_page_token` in the response indicates that more data is available."
  ([parent] (projects-locations-phraseMatchers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+parent}/phraseMatchers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-phraseMatchers-get
  "Gets a phrase matcher.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.phraseMatchers/get

name <string> Required. The name of the phrase matcher to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-insightsdata-export
  "Export insights data to a destination defined in the request body.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.insightsdata/export

parent <string> Required. The parent resource to export data from.
GoogleCloudContactcenterinsightsV1ExportInsightsDataRequest:
{:filter string,
 :parent string,
 :kmsKey string,
 :bigQueryDestination
 {:table string, :dataset string, :projectId string},
 :writeDisposition
 [WRITE_DISPOSITION_UNSPECIFIED WRITE_TRUNCATE WRITE_APPEND]}"
  [parent GoogleCloudContactcenterinsightsV1ExportInsightsDataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+parent}/insightsdata:export",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudContactcenterinsightsV1ExportInsightsDataRequest}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://contactcenterinsights.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/contact-center/insights/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://contactcenterinsights.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

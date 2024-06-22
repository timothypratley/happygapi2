(ns happygapi2.language
  "Cloud Natural Language API
Provides natural language understanding technologies, such as sentiment analysis, entity recognition, entity sentiment analysis, and other text annotations, to developers.
See: https://cloud.google.com/natural-language/"
  (:require [happy.oauth2.client :as client]))

(defn documents-moderateText
  "Moderates a document for harmful and sensitive categories.
https://cloud.google.com/natural-language/reference/rest/v2/documents/moderateText

ModerateTextRequest:
{:document
 {:gcsContentUri string,
  :languageCode string,
  :type [TYPE_UNSPECIFIED PLAIN_TEXT HTML],
  :content string}}"
  [ModerateTextRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://language.googleapis.com/v2/documents:moderateText",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-language"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body ModerateTextRequest}))

(defn documents-analyzeEntities
  "Finds named entities (currently proper names and common nouns) in the text along with entity types, probability, mentions for each entity, and other properties.
https://cloud.google.com/natural-language/reference/rest/v2/documents/analyzeEntities

AnalyzeEntitiesRequest:
{:document
 {:gcsContentUri string,
  :languageCode string,
  :type [TYPE_UNSPECIFIED PLAIN_TEXT HTML],
  :content string},
 :encodingType [NONE UTF8 UTF16 UTF32]}"
  [AnalyzeEntitiesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://language.googleapis.com/v2/documents:analyzeEntities",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-language"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body AnalyzeEntitiesRequest}))

(defn documents-analyzeSentiment
  "Analyzes the sentiment of the provided text.
https://cloud.google.com/natural-language/reference/rest/v2/documents/analyzeSentiment

AnalyzeSentimentRequest:
{:encodingType [NONE UTF8 UTF16 UTF32],
 :document
 {:gcsContentUri string,
  :languageCode string,
  :type [TYPE_UNSPECIFIED PLAIN_TEXT HTML],
  :content string}}"
  [AnalyzeSentimentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://language.googleapis.com/v2/documents:analyzeSentiment",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-language"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body AnalyzeSentimentRequest}))

(defn documents-annotateText
  "A convenience method that provides all features in one call.
https://cloud.google.com/natural-language/reference/rest/v2/documents/annotateText

AnnotateTextRequest:
{:features
 {:classifyText boolean,
  :extractEntities boolean,
  :moderateText boolean,
  :extractDocumentSentiment boolean},
 :encodingType [NONE UTF8 UTF16 UTF32],
 :document
 {:gcsContentUri string,
  :languageCode string,
  :type [TYPE_UNSPECIFIED PLAIN_TEXT HTML],
  :content string}}"
  [AnnotateTextRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://language.googleapis.com/v2/documents:annotateText",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-language"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body AnnotateTextRequest}))

(defn documents-classifyText
  "Classifies a document into categories.
https://cloud.google.com/natural-language/reference/rest/v2/documents/classifyText

ClassifyTextRequest:
{:document
 {:gcsContentUri string,
  :languageCode string,
  :type [TYPE_UNSPECIFIED PLAIN_TEXT HTML],
  :content string}}"
  [ClassifyTextRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://language.googleapis.com/v2/documents:classifyText",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-language"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body ClassifyTextRequest}))

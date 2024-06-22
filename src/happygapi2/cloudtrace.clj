(ns happygapi2.cloudtrace
  "Cloud Trace API
Sends application trace data to Cloud Trace for viewing. Trace data is collected for all App Engine applications by default. Trace data from other applications can be provided using this API. This library is used to interact with the Cloud Trace API directly. If you are looking to instrument your application for Cloud Trace, we recommend using OpenTelemetry. 
See: https://cloud.google.com/trace"
  (:require [happy.oauth2.client :as client]))

(defn projects-traces-batchWrite
  "Batch writes new spans to new or existing traces. You cannot update existing spans.
https://cloud.google.com/trace

name <string> Required. The name of the project where the spans belong. The format is `projects/[PROJECT_ID]`.
BatchWriteSpansRequest:
{:spans
 [{:spanId string,
   :startTime string,
   :displayName {:value string, :truncatedByteCount integer},
   :name string,
   :endTime string,
   :timeEvents
   {:timeEvent
    [{:time string,
      :annotation
      {:description TruncatableString, :attributes Attributes},
      :messageEvent
      {:type [TYPE_UNSPECIFIED SENT RECEIVED],
       :id string,
       :uncompressedSizeBytes string,
       :compressedSizeBytes string}}],
    :droppedAnnotationsCount integer,
    :droppedMessageEventsCount integer},
   :childSpanCount integer,
   :status {:code integer, :message string, :details [object]},
   :sameProcessAsParentSpan boolean,
   :parentSpanId string,
   :spanKind
   [SPAN_KIND_UNSPECIFIED INTERNAL SERVER CLIENT PRODUCER CONSUMER],
   :attributes {:attributeMap object, :droppedAttributesCount integer},
   :stackTrace
   {:stackFrames
    {:frame
     [{:functionName TruncatableString,
       :originalFunctionName TruncatableString,
       :fileName TruncatableString,
       :lineNumber string,
       :columnNumber string,
       :loadModule Module,
       :sourceVersion TruncatableString}],
     :droppedFramesCount integer},
    :stackTraceHashId string},
   :links
   {:link
    [{:traceId string,
      :spanId string,
      :type [TYPE_UNSPECIFIED CHILD_LINKED_SPAN PARENT_LINKED_SPAN],
      :attributes
      {:attributeMap object, :droppedAttributesCount integer}}],
    :droppedLinksCount integer}}]}"
  [name BatchWriteSpansRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudtrace.googleapis.com/v2/{+name}/traces:batchWrite",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/trace.append"],
     :body BatchWriteSpansRequest}))

(defn projects-traces-spans-createSpan
  "Creates a new span.
https://cloud.google.com/trace

name <string> Required. The resource name of the span in the following format: * `projects/[PROJECT_ID]/traces/[TRACE_ID]/spans/[SPAN_ID]` `[TRACE_ID]` is a unique identifier for a trace within a project; it is a 32-character hexadecimal encoding of a 16-byte array. It should not be zero. `[SPAN_ID]` is a unique identifier for a span within a trace; it is a 16-character hexadecimal encoding of an 8-byte array. It should not be zero. .
Span:
{:spanId string,
 :startTime string,
 :displayName {:value string, :truncatedByteCount integer},
 :name string,
 :endTime string,
 :timeEvents
 {:timeEvent
  [{:time string,
    :annotation
    {:description {:value string, :truncatedByteCount integer},
     :attributes
     {:attributeMap object, :droppedAttributesCount integer}},
    :messageEvent
    {:type [TYPE_UNSPECIFIED SENT RECEIVED],
     :id string,
     :uncompressedSizeBytes string,
     :compressedSizeBytes string}}],
  :droppedAnnotationsCount integer,
  :droppedMessageEventsCount integer},
 :childSpanCount integer,
 :status {:code integer, :message string, :details [object]},
 :sameProcessAsParentSpan boolean,
 :parentSpanId string,
 :spanKind
 [SPAN_KIND_UNSPECIFIED INTERNAL SERVER CLIENT PRODUCER CONSUMER],
 :attributes {:attributeMap object, :droppedAttributesCount integer},
 :stackTrace
 {:stackFrames
  {:frame
   [{:functionName {:value string, :truncatedByteCount integer},
     :originalFunctionName
     {:value string, :truncatedByteCount integer},
     :fileName {:value string, :truncatedByteCount integer},
     :lineNumber string,
     :columnNumber string,
     :loadModule
     {:module TruncatableString, :buildId TruncatableString},
     :sourceVersion {:value string, :truncatedByteCount integer}}],
   :droppedFramesCount integer},
  :stackTraceHashId string},
 :links
 {:link
  [{:traceId string,
    :spanId string,
    :type [TYPE_UNSPECIFIED CHILD_LINKED_SPAN PARENT_LINKED_SPAN],
    :attributes
    {:attributeMap object, :droppedAttributesCount integer}}],
  :droppedLinksCount integer}}"
  [name Span]
  (client/api-request
    {:method "POST",
     :uri-template "https://cloudtrace.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/trace.append"],
     :body Span}))

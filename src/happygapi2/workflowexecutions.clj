(ns happygapi2.workflowexecutions
  "Workflow Executions API
Execute workflows created with Workflows API.
See: https://cloud.google.com/workflows"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-workflows-triggerPubsubExecution
  "Triggers a new execution using the latest revision of the given workflow by a Pub/Sub push notification.
https://cloud.google.com/workflows

workflow <string> Required. Name of the workflow for which an execution should be created. Format: projects/{project}/locations/{location}/workflows/{workflow}
TriggerPubsubExecutionRequest:
{:subscription string,
 :message
 {:data string,
  :attributes object,
  :messageId string,
  :publishTime string,
  :orderingKey string},
 :GCPCloudEventsMode string,
 :deliveryAttempt integer}"
  [workflow TriggerPubsubExecutionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workflowexecutions.googleapis.com/v1/{+workflow}:triggerPubsubExecution",
     :uri-template-args {:workflow workflow},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TriggerPubsubExecutionRequest}))

(defn projects-locations-workflows-executions-list
  "Returns a list of executions which belong to the workflow with the given name. The method returns executions of all workflow revisions. Returned executions are ordered by their start time (newest first).
https://cloud.google.com/workflows

parent <string> Required. Name of the workflow for which the executions should be listed. Format: projects/{project}/locations/{location}/workflows/{workflow}

optional:
pageSize <integer> Maximum number of executions to return per call. Max supported value depends on the selected Execution view: it's 1000 for BASIC and 100 for FULL. The default value used if the field is not specified is 100, regardless of the selected view. Values greater than the max value will be coerced down to it.
view <string> Optional. A view defining which fields should be filled in the returned executions. The API will default to the BASIC view.
filter <string> Optional. Filters applied to the `[Executions.ListExecutions]` results. The following fields are supported for filtering: `executionId`, `state`, `createTime`, `startTime`, `endTime`, `duration`, `workflowRevisionId`, `stepName`, and `label`. For details, see AIP-160. For more information, see Filter executions. For example, if you are using the Google APIs Explorer: `state=\"SUCCEEDED\"` or `startTime>\"2023-08-01\" AND state=\"FAILED\"`
orderBy <string> Optional. Comma-separated list of fields that specify the ordering applied to the `[Executions.ListExecutions]` results. By default the ordering is based on descending `createTime`. The following fields are supported for ordering: `executionId`, `state`, `createTime`, `startTime`, `endTime`, `duration`, and `workflowRevisionId`. For details, see AIP-132."
  ([parent] (projects-locations-workflows-executions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflowexecutions.googleapis.com/v1/{+parent}/executions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflows-executions-create
  "Creates a new execution using the latest revision of the given workflow. For more information, see Execute a workflow.
https://cloud.google.com/workflows

parent <string> Required. Name of the workflow for which an execution should be created. Format: projects/{project}/locations/{location}/workflows/{workflow} The latest revision of the workflow will be used.
Execution:
{:labels object,
 :startTime string,
 :workflowRevisionId string,
 :name string,
 :endTime string,
 :createTime string,
 :duration string,
 :state
 [STATE_UNSPECIFIED
  ACTIVE
  SUCCEEDED
  FAILED
  CANCELLED
  UNAVAILABLE
  QUEUED],
 :stateError {:details string, :type [TYPE_UNSPECIFIED KMS_ERROR]},
 :argument string,
 :status {:currentSteps [{:routine string, :step string}]},
 :result string,
 :error
 {:payload string,
  :context string,
  :stackTrace
  {:elements
   [{:step string,
     :routine string,
     :position {:line string, :column string, :length string}}]}},
 :callLogLevel
 [CALL_LOG_LEVEL_UNSPECIFIED LOG_ALL_CALLS LOG_ERRORS_ONLY LOG_NONE],
 :disableConcurrencyQuotaOverflowBuffering boolean}"
  [parent Execution]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workflowexecutions.googleapis.com/v1/{+parent}/executions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Execution}))

(defn projects-locations-workflows-executions-get
  "Returns an execution of the given name.
https://cloud.google.com/workflows

name <string> Required. Name of the execution to be retrieved. Format: projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}

optional:
view <string> Optional. A view defining which fields should be filled in the returned execution. The API will default to the FULL view."
  ([name] (projects-locations-workflows-executions-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflowexecutions.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflows-executions-cancel
  "Cancels an execution of the given name.
https://cloud.google.com/workflows

name <string> Required. Name of the execution to be cancelled. Format: projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}
CancelExecutionRequest:
object"
  [name CancelExecutionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://workflowexecutions.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelExecutionRequest}))

(defn projects-locations-workflows-executions-exportData
  "Returns all metadata stored about an execution, excluding most data that is already accessible using other API methods.
https://cloud.google.com/workflows

name <string> Required. Name of the execution for which data is to be exported. Format: projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://workflowexecutions.googleapis.com/v1/{+name}:exportData",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-workflows-executions-callbacks-list
  "Returns a list of active callbacks that belong to the execution with the given name. The returned callbacks are ordered by callback ID.
https://cloud.google.com/workflows

parent <string> Required. Name of the execution for which the callbacks should be listed. Format: projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}

optional:
pageSize <integer> Maximum number of callbacks to return per call. The default value is 100 and is also the maximum value."
  ([parent]
    (projects-locations-workflows-executions-callbacks-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflowexecutions.googleapis.com/v1/{+parent}/callbacks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflows-executions-stepEntries-list
  "Lists step entries for the corresponding workflow execution. Returned entries are ordered by their create_time.
https://cloud.google.com/workflows

parent <string> Required. Name of the workflow execution to list entries for. Format: projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}/stepEntries/

optional:
pageSize <integer> Optional. Number of step entries to return per call. The default max is 1000.
skip <integer> Optional. The number of step entries to skip. It can be used with or without a pageToken. If used with a pageToken, then it indicates the number of step entries to skip starting from the requested page.
filter <string> Optional. Filters applied to the `[StepEntries.ListStepEntries]` results. The following fields are supported for filtering: `entryId`, `createTime`, `updateTime`, `routine`, `step`, `stepType`, `state`. For details, see AIP-160. For example, if you are using the Google APIs Explorer: `state=\"SUCCEEDED\"` or `createTime>\"2023-08-01\" AND state=\"FAILED\"`
orderBy <string> Optional. Comma-separated list of fields that specify the ordering applied to the `[StepEntries.ListStepEntries]` results. By default the ordering is based on ascending `entryId`. The following fields are supported for ordering: `entryId`, `createTime`, `updateTime`, `routine`, `step`, `stepType`, `state`. For details, see AIP-132."
  ([parent]
    (projects-locations-workflows-executions-stepEntries-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflowexecutions.googleapis.com/v1/{+parent}/stepEntries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflows-executions-stepEntries-get
  "Gets a step entry.
https://cloud.google.com/workflows

name <string> Required. The name of the step entry to retrieve. Format: projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}/stepEntries/{step_entry}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://workflowexecutions.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

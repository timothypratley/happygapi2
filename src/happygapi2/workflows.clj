(ns happygapi2.workflows
  "Workflows API
Manage workflow definitions. To execute workflows and manage executions, see the Workflows Executions API.
See: https://cloud.google.com/workflows"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflows.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workflows.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflows.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://workflows.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://workflows.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-workflows-list
  "Lists workflows in a given project and location. The default order is not specified.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.workflows/list

parent <string> Required. Project and location from which the workflows should be listed. Format: projects/{project}/locations/{location}

optional:
pageSize <integer> Maximum number of workflows to return per call. The service might return fewer than this value even if not at the end of the collection. If a value is not specified, a default value of 500 is used. The maximum permitted value is 1000 and values greater than 1000 are coerced down to 1000.
filter <string> Filter to restrict results to specific workflows. For details, see AIP-160. For example, if you are using the Google APIs Explorer: `state=\"SUCCEEDED\"` or `createTime>\"2023-08-01\" AND state=\"FAILED\"`
orderBy <string> Comma-separated list of fields that specify the order of the results. Default sorting order for a field is ascending. To specify descending order for a field, append a \"desc\" suffix. If not specified, the results are returned in an unspecified order."
  ([parent] (projects-locations-workflows-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflows.googleapis.com/v1/{+parent}/workflows",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflows-get
  "Gets details of a single workflow.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.workflows/get

name <string> Required. Name of the workflow for which information should be retrieved. Format: projects/{project}/locations/{location}/workflows/{workflow}

optional:
revisionId <string> Optional. The revision of the workflow to retrieve. If the revision_id is empty, the latest revision is retrieved. The format is \"000001-a4d\", where the first six characters define the zero-padded decimal revision number. They are followed by a hyphen and three hexadecimal characters."
  ([name] (projects-locations-workflows-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://workflows.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-workflows-create
  "Creates a new workflow. If a workflow with the specified name already exists in the specified project and location, the long running operation returns a ALREADY_EXISTS error.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.workflows/create

parent <string> Required. Project and location in which the workflow should be created. Format: projects/{project}/locations/{location}
Workflow:
{:description string,
 :serviceAccount string,
 :labels object,
 :allKmsKeysVersions [string],
 :cryptoKeyName string,
 :sourceContents string,
 :revisionCreateTime string,
 :name string,
 :createTime string,
 :revisionId string,
 :state [STATE_UNSPECIFIED ACTIVE UNAVAILABLE],
 :stateError {:details string, :type [TYPE_UNSPECIFIED KMS_ERROR]},
 :updateTime string,
 :userEnvVars object,
 :cryptoKeyVersion string,
 :callLogLevel
 [CALL_LOG_LEVEL_UNSPECIFIED LOG_ALL_CALLS LOG_ERRORS_ONLY LOG_NONE],
 :allKmsKeys [string]}

optional:
workflowId <string> Required. The ID of the workflow to be created. It has to fulfill the following requirements: * Must contain only letters, numbers, underscores and hyphens. * Must start with a letter. * Must be between 1-64 characters. * Must end with a number or a letter. * Must be unique within the customer project and location."
  ([parent Workflow]
    (projects-locations-workflows-create parent Workflow nil))
  ([parent Workflow optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://workflows.googleapis.com/v1/{+parent}/workflows",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Workflow})))

(defn projects-locations-workflows-delete
  "Deletes a workflow with the specified name. This method also cancels and deletes all running executions of the workflow.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.workflows/delete

name <string> Required. Name of the workflow to be deleted. Format: projects/{project}/locations/{location}/workflows/{workflow}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://workflows.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-workflows-patch
  "Updates an existing workflow. Running this method has no impact on already running executions of the workflow. A new revision of the workflow might be created as a result of a successful update operation. In that case, the new revision is used in new workflow executions.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.workflows/patch

name <string> The resource name of the workflow. Format: projects/{project}/locations/{location}/workflows/{workflow}. This is a workflow-wide field and is not tied to a specific revision.
Workflow:
{:description string,
 :serviceAccount string,
 :labels object,
 :allKmsKeysVersions [string],
 :cryptoKeyName string,
 :sourceContents string,
 :revisionCreateTime string,
 :name string,
 :createTime string,
 :revisionId string,
 :state [STATE_UNSPECIFIED ACTIVE UNAVAILABLE],
 :stateError {:details string, :type [TYPE_UNSPECIFIED KMS_ERROR]},
 :updateTime string,
 :userEnvVars object,
 :cryptoKeyVersion string,
 :callLogLevel
 [CALL_LOG_LEVEL_UNSPECIFIED LOG_ALL_CALLS LOG_ERRORS_ONLY LOG_NONE],
 :allKmsKeys [string]}

optional:
updateMask <string> List of fields to be updated. If not present, the entire workflow will be updated."
  ([name Workflow]
    (projects-locations-workflows-patch name Workflow nil))
  ([name Workflow optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://workflows.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Workflow})))

(defn projects-locations-workflows-listRevisions
  "Lists revisions for a given workflow.
https://cloud.google.com/workflows/docs/reference/rest/v1/projects.locations.workflows/listRevisions

name <string> Required. Workflow for which the revisions should be listed. Format: projects/{project}/locations/{location}/workflows/{workflow}

optional:
pageSize <integer> The maximum number of revisions to return per page. If a value is not specified, a default value of 20 is used. The maximum permitted value is 100. Values greater than 100 are coerced down to 100."
  ([name] (projects-locations-workflows-listRevisions name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://workflows.googleapis.com/v1/{+name}:listRevisions",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

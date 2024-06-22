(ns happygapi2.script
  "Apps Script API
Manages and executes Google Apps Script projects. 
See: https://developers.google.com/apps-script/api/concepts"
  (:require [happy.oauth2.client :as client]))

(defn scripts-run
  "Runs a function in an Apps Script project. The script project must be deployed for use with the Apps Script API and the calling application must share the same Cloud Platform project. This method requires authorization with an OAuth 2.0 token that includes at least one of the scopes listed in the [Authorization](#authorization-scopes) section; script projects that do not require authorization cannot be executed through this API. To find the correct scopes to include in the authentication token, open the script project **Overview** page and scroll down to \"Project OAuth Scopes.\" The error `403, PERMISSION_DENIED: The caller does not have permission` indicates that the Cloud Platform project used to authorize the request is not the same as the one used by the script.
https://developers.google.com/apps-script/api/reference/rest/v1/scripts/run

scriptId <string> The script ID of the script to be executed. Find the script ID on the **Project settings** page under \"IDs.\" As multiple executable APIs can be deployed in new IDE for same script, this field should be populated with DeploymentID generated while deploying in new IDE instead of script ID.
ExecutionRequest:
{:sessionState string,
 :function string,
 :devMode boolean,
 :parameters [any]}"
  [scriptId ExecutionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://script.googleapis.com/v1/scripts/{scriptId}:run",
     :uri-template-args {:scriptId scriptId},
     :query-params {},
     :scopes
     ["https://mail.google.com/"
      "https://www.google.com/calendar/feeds"
      "https://www.google.com/m8/feeds"
      "https://www.googleapis.com/auth/admin.directory.group"
      "https://www.googleapis.com/auth/admin.directory.user"
      "https://www.googleapis.com/auth/documents"
      "https://www.googleapis.com/auth/drive"
      "https://www.googleapis.com/auth/forms"
      "https://www.googleapis.com/auth/forms.currentonly"
      "https://www.googleapis.com/auth/groups"
      "https://www.googleapis.com/auth/spreadsheets"
      "https://www.googleapis.com/auth/userinfo.email"],
     :body ExecutionRequest}))

(defn processes-listScriptProcesses
  "List information about a script's executed processes, such as process type and current status.
https://developers.google.com/apps-script/api/reference/rest/v1/processes/listScriptProcesses

optional:
scriptProcessFilter.startTime <string> Optional field used to limit returned processes to those that were started on or after the given timestamp.
scriptProcessFilter.endTime <string> Optional field used to limit returned processes to those that completed on or before the given timestamp.
scriptProcessFilter.userAccessLevels <string> Optional field used to limit returned processes to those having one of the specified user access levels.
scriptId <string> The script ID of the project whose processes are listed.
scriptProcessFilter.deploymentId <string> Optional field used to limit returned processes to those originating from projects with a specific deployment ID.
pageSize <integer> The maximum number of returned processes per page of results. Defaults to 50.
scriptProcessFilter.functionName <string> Optional field used to limit returned processes to those originating from a script function with the given function name.
scriptProcessFilter.statuses <string> Optional field used to limit returned processes to those having one of the specified process statuses.
scriptProcessFilter.types <string> Optional field used to limit returned processes to those having one of the specified process types."
  ([] (processes-listScriptProcesses nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://script.googleapis.com/v1/processes:listScriptProcesses",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/script.processes"]})))

(defn processes-list
  "List information about processes made by or on behalf of a user, such as process type and current status.
https://developers.google.com/apps-script/api/reference/rest/v1/processes/list

optional:
userProcessFilter.deploymentId <string> Optional field used to limit returned processes to those originating from projects with a specific deployment ID.
userProcessFilter.functionName <string> Optional field used to limit returned processes to those originating from a script function with the given function name.
userProcessFilter.userAccessLevels <string> Optional field used to limit returned processes to those having one of the specified user access levels.
userProcessFilter.scriptId <string> Optional field used to limit returned processes to those originating from projects with a specific script ID.
userProcessFilter.statuses <string> Optional field used to limit returned processes to those having one of the specified process statuses.
pageSize <integer> The maximum number of returned processes per page of results. Defaults to 50.
userProcessFilter.types <string> Optional field used to limit returned processes to those having one of the specified process types.
userProcessFilter.startTime <string> Optional field used to limit returned processes to those that were started on or after the given timestamp.
userProcessFilter.endTime <string> Optional field used to limit returned processes to those that completed on or before the given timestamp.
userProcessFilter.projectName <string> Optional field used to limit returned processes to those originating from projects with project names containing a specific string."
  ([] (processes-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://script.googleapis.com/v1/processes",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/script.processes"]})))

(defn projects-create
  "Creates a new, empty script project with no script files and a base manifest file.
https://developers.google.com/apps-script/api/reference/rest/v1/projects/create

CreateProjectRequest:
{:parentId string, :title string}"
  [CreateProjectRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://script.googleapis.com/v1/projects",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/script.projects"],
     :body CreateProjectRequest}))

(defn projects-updateContent
  "Updates the content of the specified script project. This content is stored as the HEAD version, and is used when the script is executed as a trigger, in the script editor, in add-on preview mode, or as a web app or Apps Script API in development mode. This clears all the existing files in the project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects/updateContent

scriptId <string> The script project's Drive ID.
Content:
{:scriptId string,
 :files
 [{:updateTime string,
   :name string,
   :type [ENUM_TYPE_UNSPECIFIED SERVER_JS HTML JSON],
   :lastModifyUser
   {:photoUrl string, :domain string, :name string, :email string},
   :createTime string,
   :functionSet {:values [{:parameters [string], :name string}]},
   :source string}]}"
  [scriptId Content]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}/content",
     :uri-template-args {:scriptId scriptId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/script.projects"],
     :body Content}))

(defn projects-get
  "Gets a script project's metadata.
https://developers.google.com/apps-script/api/reference/rest/v1/projects/get

scriptId <string> The script project's Drive ID."
  [scriptId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}",
     :uri-template-args {:scriptId scriptId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/script.projects"
      "https://www.googleapis.com/auth/script.projects.readonly"]}))

(defn projects-getMetrics
  "Get metrics data for scripts, such as number of executions and active users.
https://developers.google.com/apps-script/api/reference/rest/v1/projects/getMetrics

scriptId <string> Required field indicating the script to get metrics for.

optional:
metricsFilter.deploymentId <string> Optional field indicating a specific deployment to retrieve metrics from.
metricsGranularity <string> Required field indicating what granularity of metrics are returned."
  ([scriptId] (projects-getMetrics scriptId nil))
  ([scriptId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://script.googleapis.com/v1/projects/{scriptId}/metrics",
       :uri-template-args {:scriptId scriptId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/script.metrics"]})))

(defn projects-getContent
  "Gets the content of the script project, including the code source and metadata for each script file.
https://developers.google.com/apps-script/api/reference/rest/v1/projects/getContent

scriptId <string> The script project's Drive ID.

optional:
versionNumber <integer> The version number of the project to retrieve. If not provided, the project's HEAD version is returned."
  ([scriptId] (projects-getContent scriptId nil))
  ([scriptId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://script.googleapis.com/v1/projects/{scriptId}/content",
       :uri-template-args {:scriptId scriptId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/script.projects"
        "https://www.googleapis.com/auth/script.projects.readonly"]})))

(defn projects-versions-list
  "List the versions of a script project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.versions/list

scriptId <string> The script project's Drive ID.

optional:
pageSize <integer> The maximum number of versions on each returned page. Defaults to 50."
  ([scriptId] (projects-versions-list scriptId nil))
  ([scriptId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://script.googleapis.com/v1/projects/{scriptId}/versions",
       :uri-template-args {:scriptId scriptId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/script.projects"
        "https://www.googleapis.com/auth/script.projects.readonly"]})))

(defn projects-versions-get
  "Gets a version of a script project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.versions/get

scriptId <string> The script project's Drive ID.
versionNumber <integer> The version number."
  [scriptId versionNumber]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}/versions/{versionNumber}",
     :uri-template-args
     {:scriptId scriptId, :versionNumber versionNumber},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/script.projects"
      "https://www.googleapis.com/auth/script.projects.readonly"]}))

(defn projects-versions-create
  "Creates a new immutable version using the current code, with a unique version number.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.versions/create

scriptId <string> The script project's Drive ID.
Version:
{:scriptId string,
 :description string,
 :versionNumber integer,
 :createTime string}"
  [scriptId Version]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}/versions",
     :uri-template-args {:scriptId scriptId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/script.projects"],
     :body Version}))

(defn projects-deployments-update
  "Updates a deployment of an Apps Script project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.deployments/update

scriptId <string> The script project's Drive ID.
deploymentId <string> The deployment ID for this deployment.
UpdateDeploymentRequest:
{:deploymentConfig
 {:description string,
  :versionNumber integer,
  :manifestFileName string,
  :scriptId string}}"
  [scriptId deploymentId UpdateDeploymentRequest]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}/deployments/{deploymentId}",
     :uri-template-args
     {:deploymentId deploymentId, :scriptId scriptId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/script.deployments"],
     :body UpdateDeploymentRequest}))

(defn projects-deployments-get
  "Gets a deployment of an Apps Script project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.deployments/get

scriptId <string> The script project's Drive ID.
deploymentId <string> The deployment ID."
  [scriptId deploymentId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}/deployments/{deploymentId}",
     :uri-template-args
     {:deploymentId deploymentId, :scriptId scriptId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/script.deployments"
      "https://www.googleapis.com/auth/script.deployments.readonly"]}))

(defn projects-deployments-delete
  "Deletes a deployment of an Apps Script project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.deployments/delete

scriptId <string> The script project's Drive ID.
deploymentId <string> The deployment ID to be undeployed."
  [scriptId deploymentId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}/deployments/{deploymentId}",
     :uri-template-args
     {:deploymentId deploymentId, :scriptId scriptId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/script.deployments"]}))

(defn projects-deployments-create
  "Creates a deployment of an Apps Script project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.deployments/create

scriptId <string> The script project's Drive ID.
DeploymentConfig:
{:description string,
 :versionNumber integer,
 :manifestFileName string,
 :scriptId string}"
  [scriptId DeploymentConfig]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://script.googleapis.com/v1/projects/{scriptId}/deployments",
     :uri-template-args {:scriptId scriptId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/script.deployments"],
     :body DeploymentConfig}))

(defn projects-deployments-list
  "Lists the deployments of an Apps Script project.
https://developers.google.com/apps-script/api/reference/rest/v1/projects.deployments/list

scriptId <string> The script project's Drive ID.

optional:
pageSize <integer> The maximum number of deployments on each returned page. Defaults to 50."
  ([scriptId] (projects-deployments-list scriptId nil))
  ([scriptId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://script.googleapis.com/v1/projects/{scriptId}/deployments",
       :uri-template-args {:scriptId scriptId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/script.deployments"
        "https://www.googleapis.com/auth/script.deployments.readonly"]})))

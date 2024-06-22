(ns happygapi2.composer
  "Cloud Composer API
Manages Apache Airflow environments on Google Cloud Platform.
See: https://cloud.google.com/composer/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://composer.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-environments-get
  "Get an existing environment.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/get

name <string> The resource name of the environment to get, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-environments-patch
  "Update an environment.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/patch

name <string> The relative resource name of the environment to update, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
Environment:
{:labels object,
 :config
 {:databaseConfig {:machineType string, :zone string},
  :gkeCluster string,
  :workloadsConfig
  {:scheduler
   {:cpu number, :memoryGb number, :storageGb number, :count integer},
   :webServer {:cpu number, :memoryGb number, :storageGb number},
   :worker
   {:cpu number,
    :memoryGb number,
    :storageGb number,
    :minCount integer,
    :maxCount integer},
   :triggerer {:count integer, :cpu number, :memoryGb number},
   :dagProcessor
   {:cpu number, :memoryGb number, :storageGb number, :count integer}},
  :airflowUri string,
  :airflowByoidUri string,
  :nodeConfig
  {:serviceAccount string,
   :composerNetworkAttachment string,
   :tags [string],
   :machineType string,
   :oauthScopes [string],
   :diskSizeGb integer,
   :network string,
   :composerInternalIpv4CidrBlock string,
   :enableIpMasqAgent boolean,
   :location string,
   :subnetwork string,
   :ipAllocationPolicy
   {:useIpAliases boolean,
    :clusterSecondaryRangeName string,
    :clusterIpv4CidrBlock string,
    :servicesSecondaryRangeName string,
    :servicesIpv4CidrBlock string}},
  :masterAuthorizedNetworksConfig
  {:enabled boolean,
   :cidrBlocks [{:displayName string, :cidrBlock string}]},
  :softwareConfig
  {:imageVersion string,
   :airflowConfigOverrides object,
   :pypiPackages object,
   :envVariables object,
   :pythonVersion string,
   :schedulerCount integer,
   :cloudDataLineageIntegration {:enabled boolean},
   :webServerPluginsMode
   [WEB_SERVER_PLUGINS_MODE_UNSPECIFIED
    PLUGINS_DISABLED
    PLUGINS_ENABLED]},
  :webServerNetworkAccessControl
  {:allowedIpRanges [{:value string, :description string}]},
  :privateEnvironmentConfig
  {:enablePrivatelyUsedPublicIps boolean,
   :cloudComposerNetworkIpv4ReservedRange string,
   :enablePrivateEnvironment boolean,
   :networkingConfig
   {:connectionType
    [CONNECTION_TYPE_UNSPECIFIED VPC_PEERING PRIVATE_SERVICE_CONNECT]},
   :webServerIpv4CidrBlock string,
   :privateClusterConfig
   {:enablePrivateEndpoint boolean,
    :masterIpv4CidrBlock string,
    :masterIpv4ReservedRange string},
   :cloudComposerNetworkIpv4CidrBlock string,
   :cloudSqlIpv4CidrBlock string,
   :webServerIpv4ReservedRange string,
   :enablePrivateBuildsOnly boolean,
   :cloudComposerConnectionSubnetwork string},
  :recoveryConfig
  {:scheduledSnapshotsConfig
   {:enabled boolean,
    :snapshotLocation string,
    :snapshotCreationSchedule string,
    :timeZone string}},
  :webServerConfig {:machineType string},
  :resilienceMode [RESILIENCE_MODE_UNSPECIFIED HIGH_RESILIENCE],
  :maintenanceWindow
  {:startTime string, :endTime string, :recurrence string},
  :dataRetentionConfig
  {:airflowMetadataRetentionConfig
   {:retentionMode
    [RETENTION_MODE_UNSPECIFIED
     RETENTION_MODE_ENABLED
     RETENTION_MODE_DISABLED],
    :retentionDays integer},
   :taskLogsRetentionConfig
   {:storageMode
    [TASK_LOGS_STORAGE_MODE_UNSPECIFIED
     CLOUD_LOGGING_AND_CLOUD_STORAGE
     CLOUD_LOGGING_ONLY]}},
  :nodeCount integer,
  :environmentSize
  [ENVIRONMENT_SIZE_UNSPECIFIED
   ENVIRONMENT_SIZE_SMALL
   ENVIRONMENT_SIZE_MEDIUM
   ENVIRONMENT_SIZE_LARGE],
  :encryptionConfig {:kmsKeyName string},
  :dagGcsPrefix string},
 :name string,
 :createTime string,
 :storageConfig {:bucket string},
 :state [STATE_UNSPECIFIED CREATING RUNNING UPDATING DELETING ERROR],
 :updateTime string,
 :satisfiesPzs boolean,
 :uuid string}

optional:
updateMask <string> Required. A comma-separated list of paths, relative to `Environment`, of fields to update. For example, to set the version of scikit-learn to install in the environment to 0.19.0 and to remove an existing installation of numpy, the `updateMask` parameter would include the following two `paths` values: \"config.softwareConfig.pypiPackages.scikit-learn\" and \"config.softwareConfig.pypiPackages.numpy\". The included patch environment would specify the scikit-learn version as follows: { \"config\":{ \"softwareConfig\":{ \"pypiPackages\":{ \"scikit-learn\":\"==0.19.0\" } } } } Note that in the above example, any existing PyPI packages other than scikit-learn and numpy will be unaffected. Only one update type may be included in a single request's `updateMask`. For example, one cannot update both the PyPI packages and labels in the same request. However, it is possible to update multiple members of a map field simultaneously in the same request. For example, to set the labels \"label1\" and \"label2\" while clearing \"label3\" (assuming it already exists), one can provide the paths \"labels.label1\", \"labels.label2\", and \"labels.label3\" and populate the patch environment as follows: { \"labels\":{ \"label1\":\"new-label1-value\" \"label2\":\"new-label2-value\" } } Note that in the above example, any existing labels that are not included in the `updateMask` will be unaffected. It is also possible to replace an entire map field by providing the map field's path in the `updateMask`. The new value of the field will be that which is provided in the patch environment. For example, to delete all pre-existing user-specified PyPI packages and install botocore at version 1.7.14, the `updateMask` would contain the path \"config.softwareConfig.pypiPackages\", and the patch environment would be the following: { \"config\":{ \"softwareConfig\":{ \"pypiPackages\":{ \"botocore\":\"==1.7.14\" } } } } **Note:** Only the following fields can be updated: * `config.softwareConfig.pypiPackages` * Replace all custom custom PyPI packages. If a replacement package map is not included in `environment`, all custom PyPI packages are cleared. It is an error to provide both this mask and a mask specifying an individual package. * `config.softwareConfig.pypiPackages.`packagename * Update the custom PyPI package *packagename*, preserving other packages. To delete the package, include it in `updateMask`, and omit the mapping for it in `environment.config.softwareConfig.pypiPackages`. It is an error to provide both a mask of this form and the `config.softwareConfig.pypiPackages` mask. * `labels` * Replace all environment labels. If a replacement labels map is not included in `environment`, all labels are cleared. It is an error to provide both this mask and a mask specifying one or more individual labels. * `labels.`labelName * Set the label named *labelName*, while preserving other labels. To delete the label, include it in `updateMask` and omit its mapping in `environment.labels`. It is an error to provide both a mask of this form and the `labels` mask. * `config.nodeCount` * Horizontally scale the number of nodes in the environment. An integer greater than or equal to 3 must be provided in the `config.nodeCount` field. Supported for Cloud Composer environments in versions composer-1.*.*-airflow-*.*.*. * `config.webServerNetworkAccessControl` * Replace the environment's current `WebServerNetworkAccessControl`. * `config.softwareConfig.airflowConfigOverrides` * Replace all Apache Airflow config overrides. If a replacement config overrides map is not included in `environment`, all config overrides are cleared. It is an error to provide both this mask and a mask specifying one or more individual config overrides. * `config.softwareConfig.airflowConfigOverrides.`section-name * Override the Apache Airflow config property *name* in the section named *section*, preserving other properties. To delete the property override, include it in `updateMask` and omit its mapping in `environment.config.softwareConfig.airflowConfigOverrides`. It is an error to provide both a mask of this form and the `config.softwareConfig.airflowConfigOverrides` mask. * `config.softwareConfig.envVariables` * Replace all environment variables. If a replacement environment variable map is not included in `environment`, all custom environment variables are cleared. * `config.softwareConfig.schedulerCount` * Horizontally scale the number of schedulers in Airflow. A positive integer not greater than the number of nodes must be provided in the `config.softwareConfig.schedulerCount` field. Supported for Cloud Composer environments in versions composer-1.*.*-airflow-2.*.*. * `config.databaseConfig.machineType` * Cloud SQL machine type used by Airflow database. It has to be one of: db-n1-standard-2, db-n1-standard-4, db-n1-standard-8 or db-n1-standard-16. Supported for Cloud Composer environments in versions composer-1.*.*-airflow-*.*.*. * `config.webServerConfig.machineType` * Machine type on which Airflow web server is running. It has to be one of: composer-n1-webserver-2, composer-n1-webserver-4 or composer-n1-webserver-8. Supported for Cloud Composer environments in versions composer-1.*.*-airflow-*.*.*."
  ([name Environment]
    (projects-locations-environments-patch name Environment nil))
  ([name Environment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://composer.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Environment})))

(defn projects-locations-environments-checkUpgrade
  "Check if an upgrade operation on the environment will succeed. In case of problems detailed info can be found in the returned Operation.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/checkUpgrade

environment <string> Required. The resource name of the environment to check upgrade for, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
CheckUpgradeRequest:
{:imageVersion string}"
  [environment CheckUpgradeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:checkUpgrade",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CheckUpgradeRequest}))

(defn projects-locations-environments-saveSnapshot
  "Creates a snapshots of a Cloud Composer environment. As a result of this operation, snapshot of environment's state is stored in a location specified in the SaveSnapshotRequest.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/saveSnapshot

environment <string> The resource name of the source environment in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
SaveSnapshotRequest:
{:snapshotLocation string}"
  [environment SaveSnapshotRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:saveSnapshot",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SaveSnapshotRequest}))

(defn projects-locations-environments-create
  "Create a new environment.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/create

parent <string> The parent must be of the form \"projects/{projectId}/locations/{locationId}\".
Environment:
{:labels object,
 :config
 {:databaseConfig {:machineType string, :zone string},
  :gkeCluster string,
  :workloadsConfig
  {:scheduler
   {:cpu number, :memoryGb number, :storageGb number, :count integer},
   :webServer {:cpu number, :memoryGb number, :storageGb number},
   :worker
   {:cpu number,
    :memoryGb number,
    :storageGb number,
    :minCount integer,
    :maxCount integer},
   :triggerer {:count integer, :cpu number, :memoryGb number},
   :dagProcessor
   {:cpu number, :memoryGb number, :storageGb number, :count integer}},
  :airflowUri string,
  :airflowByoidUri string,
  :nodeConfig
  {:serviceAccount string,
   :composerNetworkAttachment string,
   :tags [string],
   :machineType string,
   :oauthScopes [string],
   :diskSizeGb integer,
   :network string,
   :composerInternalIpv4CidrBlock string,
   :enableIpMasqAgent boolean,
   :location string,
   :subnetwork string,
   :ipAllocationPolicy
   {:useIpAliases boolean,
    :clusterSecondaryRangeName string,
    :clusterIpv4CidrBlock string,
    :servicesSecondaryRangeName string,
    :servicesIpv4CidrBlock string}},
  :masterAuthorizedNetworksConfig
  {:enabled boolean,
   :cidrBlocks [{:displayName string, :cidrBlock string}]},
  :softwareConfig
  {:imageVersion string,
   :airflowConfigOverrides object,
   :pypiPackages object,
   :envVariables object,
   :pythonVersion string,
   :schedulerCount integer,
   :cloudDataLineageIntegration {:enabled boolean},
   :webServerPluginsMode
   [WEB_SERVER_PLUGINS_MODE_UNSPECIFIED
    PLUGINS_DISABLED
    PLUGINS_ENABLED]},
  :webServerNetworkAccessControl
  {:allowedIpRanges [{:value string, :description string}]},
  :privateEnvironmentConfig
  {:enablePrivatelyUsedPublicIps boolean,
   :cloudComposerNetworkIpv4ReservedRange string,
   :enablePrivateEnvironment boolean,
   :networkingConfig
   {:connectionType
    [CONNECTION_TYPE_UNSPECIFIED VPC_PEERING PRIVATE_SERVICE_CONNECT]},
   :webServerIpv4CidrBlock string,
   :privateClusterConfig
   {:enablePrivateEndpoint boolean,
    :masterIpv4CidrBlock string,
    :masterIpv4ReservedRange string},
   :cloudComposerNetworkIpv4CidrBlock string,
   :cloudSqlIpv4CidrBlock string,
   :webServerIpv4ReservedRange string,
   :enablePrivateBuildsOnly boolean,
   :cloudComposerConnectionSubnetwork string},
  :recoveryConfig
  {:scheduledSnapshotsConfig
   {:enabled boolean,
    :snapshotLocation string,
    :snapshotCreationSchedule string,
    :timeZone string}},
  :webServerConfig {:machineType string},
  :resilienceMode [RESILIENCE_MODE_UNSPECIFIED HIGH_RESILIENCE],
  :maintenanceWindow
  {:startTime string, :endTime string, :recurrence string},
  :dataRetentionConfig
  {:airflowMetadataRetentionConfig
   {:retentionMode
    [RETENTION_MODE_UNSPECIFIED
     RETENTION_MODE_ENABLED
     RETENTION_MODE_DISABLED],
    :retentionDays integer},
   :taskLogsRetentionConfig
   {:storageMode
    [TASK_LOGS_STORAGE_MODE_UNSPECIFIED
     CLOUD_LOGGING_AND_CLOUD_STORAGE
     CLOUD_LOGGING_ONLY]}},
  :nodeCount integer,
  :environmentSize
  [ENVIRONMENT_SIZE_UNSPECIFIED
   ENVIRONMENT_SIZE_SMALL
   ENVIRONMENT_SIZE_MEDIUM
   ENVIRONMENT_SIZE_LARGE],
  :encryptionConfig {:kmsKeyName string},
  :dagGcsPrefix string},
 :name string,
 :createTime string,
 :storageConfig {:bucket string},
 :state [STATE_UNSPECIFIED CREATING RUNNING UPDATING DELETING ERROR],
 :updateTime string,
 :satisfiesPzs boolean,
 :uuid string}"
  [parent Environment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+parent}/environments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Environment}))

(defn projects-locations-environments-delete
  "Delete an environment.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/delete

name <string> The environment to delete, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-environments-pollAirflowCommand
  "Polls Airflow CLI command execution and fetches logs.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/pollAirflowCommand

environment <string> The resource name of the environment in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
PollAirflowCommandRequest:
{:executionId string,
 :pod string,
 :podNamespace string,
 :nextLineNumber integer}"
  [environment PollAirflowCommandRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:pollAirflowCommand",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PollAirflowCommandRequest}))

(defn projects-locations-environments-databaseFailover
  "Triggers database failover (only for highly resilient environments).
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/databaseFailover

environment <string> Target environment: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
DatabaseFailoverRequest:
object"
  [environment DatabaseFailoverRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:databaseFailover",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DatabaseFailoverRequest}))

(defn projects-locations-environments-fetchDatabaseProperties
  "Fetches database properties.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/fetchDatabaseProperties

environment <string> Required. The resource name of the environment, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\""
  [environment]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:fetchDatabaseProperties",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-environments-stopAirflowCommand
  "Stops Airflow CLI command execution.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/stopAirflowCommand

environment <string> The resource name of the environment in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\".
StopAirflowCommandRequest:
{:executionId string, :pod string, :podNamespace string, :force boolean}"
  [environment StopAirflowCommandRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:stopAirflowCommand",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StopAirflowCommandRequest}))

(defn projects-locations-environments-list
  "List environments.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/list

parent <string> List environments in the given project and location, in the form: \"projects/{projectId}/locations/{locationId}\"

optional:
pageSize <integer> The maximum number of environments to return."
  ([parent] (projects-locations-environments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://composer.googleapis.com/v1/{+parent}/environments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-environments-executeAirflowCommand
  "Executes Airflow CLI command.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/executeAirflowCommand

environment <string> The resource name of the environment in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\".
ExecuteAirflowCommandRequest:
{:command string, :subcommand string, :parameters [string]}"
  [environment ExecuteAirflowCommandRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:executeAirflowCommand",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExecuteAirflowCommandRequest}))

(defn projects-locations-environments-loadSnapshot
  "Loads a snapshot of a Cloud Composer environment. As a result of this operation, a snapshot of environment's specified in LoadSnapshotRequest is loaded into the environment.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments/loadSnapshot

environment <string> The resource name of the target environment in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
LoadSnapshotRequest:
{:snapshotPath string,
 :skipPypiPackagesInstallation boolean,
 :skipEnvironmentVariablesSetting boolean,
 :skipAirflowOverridesSetting boolean,
 :skipGcsDataCopying boolean}"
  [environment LoadSnapshotRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+environment}:loadSnapshot",
     :uri-template-args {:environment environment},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body LoadSnapshotRequest}))

(defn projects-locations-environments-workloads-list
  "Lists workloads in a Cloud Composer environment. Workload is a unit that runs a single Composer component. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.workloads/list

parent <string> Required. The environment name to get workloads for, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"

optional:
pageSize <integer> Optional. The maximum number of environments to return.
filter <string> Optional. The list filter. Currently only supports equality on the type field. The value of a field specified in the filter expression must be one ComposerWorkloadType enum option. It's possible to get multiple types using \"OR\" operator, e.g.: \"type=SCHEDULER OR type=CELERY_WORKER\". If not specified, all items are returned."
  ([parent]
    (projects-locations-environments-workloads-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://composer.googleapis.com/v1/{+parent}/workloads",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-environments-userWorkloadsSecrets-create
  "Creates a user workloads Secret. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsSecrets/create

parent <string> Required. The environment name to create a Secret for, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
UserWorkloadsSecret:
{:name string, :data object}"
  [parent UserWorkloadsSecret]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+parent}/userWorkloadsSecrets",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UserWorkloadsSecret}))

(defn projects-locations-environments-userWorkloadsSecrets-get
  "Gets an existing user workloads Secret. Values of the \"data\" field in the response are cleared. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsSecrets/get

name <string> Required. The resource name of the Secret to get, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}/userWorkloadsSecrets/{userWorkloadsSecretId}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-environments-userWorkloadsSecrets-list
  "Lists user workloads Secrets. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsSecrets/list

parent <string> Required. List Secrets in the given environment, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"

optional:
pageSize <integer> Optional. The maximum number of Secrets to return."
  ([parent]
    (projects-locations-environments-userWorkloadsSecrets-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://composer.googleapis.com/v1/{+parent}/userWorkloadsSecrets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-environments-userWorkloadsSecrets-update
  "Updates a user workloads Secret. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsSecrets/update

name <string> Identifier. The resource name of the Secret, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}/userWorkloadsSecrets/{userWorkloadsSecretId}\"
UserWorkloadsSecret:
{:name string, :data object}"
  [name UserWorkloadsSecret]
  (client/api-request
    {:method "PUT",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UserWorkloadsSecret}))

(defn projects-locations-environments-userWorkloadsSecrets-delete
  "Deletes a user workloads Secret. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsSecrets/delete

name <string> Required. The Secret to delete, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}/userWorkloadsSecrets/{userWorkloadsSecretId}\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-environments-userWorkloadsConfigMaps-create
  "Creates a user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsConfigMaps/create

parent <string> Required. The environment name to create a ConfigMap for, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"
UserWorkloadsConfigMap:
{:name string, :data object}"
  [parent UserWorkloadsConfigMap]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://composer.googleapis.com/v1/{+parent}/userWorkloadsConfigMaps",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UserWorkloadsConfigMap}))

(defn projects-locations-environments-userWorkloadsConfigMaps-get
  "Gets an existing user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsConfigMaps/get

name <string> Required. The resource name of the ConfigMap to get, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}/userWorkloadsConfigMaps/{userWorkloadsConfigMapId}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-environments-userWorkloadsConfigMaps-list
  "Lists user workloads ConfigMaps. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsConfigMaps/list

parent <string> Required. List ConfigMaps in the given environment, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}\"

optional:
pageSize <integer> Optional. The maximum number of ConfigMaps to return."
  ([parent]
    (projects-locations-environments-userWorkloadsConfigMaps-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://composer.googleapis.com/v1/{+parent}/userWorkloadsConfigMaps",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-environments-userWorkloadsConfigMaps-update
  "Updates a user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsConfigMaps/update

name <string> Identifier. The resource name of the ConfigMap, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}/userWorkloadsConfigMaps/{userWorkloadsConfigMapId}\"
UserWorkloadsConfigMap:
{:name string, :data object}"
  [name UserWorkloadsConfigMap]
  (client/api-request
    {:method "PUT",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UserWorkloadsConfigMap}))

(defn projects-locations-environments-userWorkloadsConfigMaps-delete
  "Deletes a user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.environments.userWorkloadsConfigMaps/delete

name <string> Required. The ConfigMap to delete, in the form: \"projects/{projectId}/locations/{locationId}/environments/{environmentId}/userWorkloadsConfigMaps/{userWorkloadsConfigMapId}\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://composer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-imageVersions-list
  "List ImageVersions for provided location.
https://cloud.google.com/composer/docs/reference/rest/v1/projects.locations.imageVersions/list

parent <string> List ImageVersions in the given project and location, in the form: \"projects/{projectId}/locations/{locationId}\"

optional:
pageSize <integer> The maximum number of image_versions to return.
includePastReleases <boolean> Whether or not image versions from old releases should be included."
  ([parent] (projects-locations-imageVersions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://composer.googleapis.com/v1/{+parent}/imageVersions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

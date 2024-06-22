(ns happygapi2.bigquerydatatransfer
  "BigQuery Data Transfer API
Schedule queries or transfer external data from SaaS applications to Google BigQuery on a regular basis.
See: https://cloud.google.com/bigquery/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-enrollDataSources
  "Enroll data sources in a user project. This allows users to create transfer configurations for these data sources. They will also appear in the ListDataSources RPC and as such, will appear in the [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents can be found in the public guide for [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and [Data Transfer Service](https://cloud.google.com/bigquery/docs/working-with-transfers).
https://cloud.google.com/bigquery/docs

name <string> Required. The name of the project resource in the form: `projects/{project_id}`
EnrollDataSourcesRequest:
{:dataSourceIds [string]}"
  [name EnrollDataSourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}:enrollDataSources",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body EnrollDataSourcesRequest}))

(defn projects-dataSources-get
  "Retrieves a supported data source and returns its settings.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/dataSources/{data_source_id}` or `projects/{project_id}/locations/{location_id}/dataSources/{data_source_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-dataSources-list
  "Lists supported data sources and returns their settings.
https://cloud.google.com/bigquery/docs

parent <string> Required. The BigQuery project id for which data sources should be returned. Must be in the form: `projects/{project_id}` or `projects/{project_id}/locations/{location_id}`

optional:
pageSize <integer> Page size. The default page size is the maximum value of 1000 results."
  ([parent] (projects-dataSources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/dataSources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-dataSources-checkValidCreds
  "Returns true if valid credentials exist for the given data source and requesting user.
https://cloud.google.com/bigquery/docs

name <string> Required. The data source in the form: `projects/{project_id}/dataSources/{data_source_id}` or `projects/{project_id}/locations/{location_id}/dataSources/{data_source_id}`.
CheckValidCredsRequest:
object"
  [name CheckValidCredsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}:checkValidCreds",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body CheckValidCredsRequest}))

(defn projects-transferConfigs-create
  "Creates a new data transfer configuration.
https://cloud.google.com/bigquery/docs

parent <string> Required. The BigQuery project id where the transfer configuration should be created. Must be in the format projects/{project_id}/locations/{location_id} or projects/{project_id}. If specified location and location of the destination bigquery dataset do not match - the request will fail.
TransferConfig:
{:notificationPubsubTopic string,
 :destinationDatasetId string,
 :nextRunTime string,
 :schedule string,
 :disabled boolean,
 :ownerInfo {:email string},
 :displayName string,
 :name string,
 :params object,
 :emailPreferences {:enableFailureEmail boolean},
 :state
 [TRANSFER_STATE_UNSPECIFIED
  PENDING
  RUNNING
  SUCCEEDED
  FAILED
  CANCELLED],
 :scheduleOptions
 {:disableAutoScheduling boolean, :startTime string, :endTime string},
 :updateTime string,
 :dataRefreshWindowDays integer,
 :dataSourceId string,
 :datasetRegion string,
 :userId string,
 :encryptionConfiguration {:kmsKeyName string}}

optional:
authorizationCode <string> Optional OAuth2 authorization code to use with this transfer configuration. This is required only if `transferConfig.dataSourceId` is 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain authorization_code, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=authorization_code&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to create the transfer config.
versionInfo <string> Optional version info. This is required only if `transferConfig.dataSourceId` is not 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain version info, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=version_info&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to create the transfer config.
serviceAccountName <string> Optional service account email. If this field is set, the transfer config will be created with this service account's credentials. It requires that the requesting user calling this API has permissions to act as this service account. Note that not all data sources support service account credentials when creating a transfer config. For the latest list of data sources, read about [using service accounts](https://cloud.google.com/bigquery-transfer/docs/use-service-accounts)."
  ([parent TransferConfig]
    (projects-transferConfigs-create parent TransferConfig nil))
  ([parent TransferConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/transferConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TransferConfig})))

(defn projects-transferConfigs-patch
  "Updates a data transfer configuration. All fields must be set, even if they are not updated.
https://cloud.google.com/bigquery/docs

name <string> Identifier. The resource name of the transfer config. Transfer config names have the form either `projects/{project_id}/locations/{region}/transferConfigs/{config_id}` or `projects/{project_id}/transferConfigs/{config_id}`, where `config_id` is usually a UUID, even though it is not guaranteed or required. The name is ignored when creating a transfer config.
TransferConfig:
{:notificationPubsubTopic string,
 :destinationDatasetId string,
 :nextRunTime string,
 :schedule string,
 :disabled boolean,
 :ownerInfo {:email string},
 :displayName string,
 :name string,
 :params object,
 :emailPreferences {:enableFailureEmail boolean},
 :state
 [TRANSFER_STATE_UNSPECIFIED
  PENDING
  RUNNING
  SUCCEEDED
  FAILED
  CANCELLED],
 :scheduleOptions
 {:disableAutoScheduling boolean, :startTime string, :endTime string},
 :updateTime string,
 :dataRefreshWindowDays integer,
 :dataSourceId string,
 :datasetRegion string,
 :userId string,
 :encryptionConfiguration {:kmsKeyName string}}

optional:
authorizationCode <string> Optional OAuth2 authorization code to use with this transfer configuration. This is required only if `transferConfig.dataSourceId` is 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain authorization_code, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=authorization_code&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to update the transfer config.
updateMask <string> Required. Required list of fields to be updated in this request.
versionInfo <string> Optional version info. This is required only if `transferConfig.dataSourceId` is not 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain version info, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=version_info&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to update the transfer config.
serviceAccountName <string> Optional service account email. If this field is set, the transfer config will be created with this service account's credentials. It requires that the requesting user calling this API has permissions to act as this service account. Note that not all data sources support service account credentials when creating a transfer config. For the latest list of data sources, read about [using service accounts](https://cloud.google.com/bigquery-transfer/docs/use-service-accounts)."
  ([name TransferConfig]
    (projects-transferConfigs-patch name TransferConfig nil))
  ([name TransferConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TransferConfig})))

(defn projects-transferConfigs-delete
  "Deletes a data transfer configuration, including any associated transfer runs and logs.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-transferConfigs-get
  "Returns information about a data transfer config.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-transferConfigs-list
  "Returns information about all transfer configs owned by a project in the specified location.
https://cloud.google.com/bigquery/docs

parent <string> Required. The BigQuery project id for which transfer configs should be returned: `projects/{project_id}` or `projects/{project_id}/locations/{location_id}`

optional:
dataSourceIds <string> When specified, only configurations of requested data sources are returned.
pageSize <integer> Page size. The default page size is the maximum value of 1000 results."
  ([parent] (projects-transferConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/transferConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-transferConfigs-scheduleRuns
  "Creates transfer runs for a time range [start_time, end_time]. For each date - or whatever granularity the data source supports - in the range, one transfer run is created. Note that runs are created per UTC time in the time range. DEPRECATED: use StartManualTransferRuns instead.
https://cloud.google.com/bigquery/docs

parent <string> Required. Transfer configuration name in the form: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`.
ScheduleTransferRunsRequest:
{:startTime string, :endTime string}"
  [parent ScheduleTransferRunsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+parent}:scheduleRuns",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body ScheduleTransferRunsRequest}))

(defn projects-transferConfigs-startManualRuns
  "Start manual transfer runs to be executed now with schedule_time equal to current time. The transfer runs can be created for a time range where the run_time is between start_time (inclusive) and end_time (exclusive), or for a specific run_time.
https://cloud.google.com/bigquery/docs

parent <string> Required. Transfer configuration name in the form: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`.
StartManualTransferRunsRequest:
{:requestedTimeRange {:startTime string, :endTime string},
 :requestedRunTime string}"
  [parent StartManualTransferRunsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+parent}:startManualRuns",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body StartManualTransferRunsRequest}))

(defn projects-transferConfigs-runs-get
  "Returns information about the particular transfer run.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}/runs/{run_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-transferConfigs-runs-delete
  "Deletes the specified transfer run.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}/runs/{run_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-transferConfigs-runs-list
  "Returns information about running and completed transfer runs.
https://cloud.google.com/bigquery/docs

parent <string> Required. Name of transfer configuration for which transfer runs should be retrieved. Format of transfer configuration resource name is: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`.

optional:
states <string> When specified, only transfer runs with requested states are returned.
pageSize <integer> Page size. The default page size is the maximum value of 1000 results.
runAttempt <string> Indicates how run attempts are to be pulled."
  ([parent] (projects-transferConfigs-runs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/runs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-transferConfigs-runs-transferLogs-list
  "Returns log messages for the transfer run.
https://cloud.google.com/bigquery/docs

parent <string> Required. Transfer run name in the form: `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}/runs/{run_id}`

optional:
pageSize <integer> Page size. The default page size is the maximum value of 1000 results.
messageTypes <string> Message types to return. If not populated - INFO, WARNING and ERROR messages are returned."
  ([parent]
    (projects-transferConfigs-runs-transferLogs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/transferLogs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-enrollDataSources
  "Enroll data sources in a user project. This allows users to create transfer configurations for these data sources. They will also appear in the ListDataSources RPC and as such, will appear in the [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents can be found in the public guide for [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and [Data Transfer Service](https://cloud.google.com/bigquery/docs/working-with-transfers).
https://cloud.google.com/bigquery/docs

name <string> Required. The name of the project resource in the form: `projects/{project_id}`
EnrollDataSourcesRequest:
{:dataSourceIds [string]}"
  [name EnrollDataSourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}:enrollDataSources",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body EnrollDataSourcesRequest}))

(defn projects-locations-unenrollDataSources
  "Unenroll data sources in a user project. This allows users to remove transfer configurations for these data sources. They will no longer appear in the ListDataSources RPC and will also no longer appear in the [BigQuery UI](https://console.cloud.google.com/bigquery). Data transfers configurations of unenrolled data sources will not be scheduled.
https://cloud.google.com/bigquery/docs

name <string> Required. The name of the project resource in the form: `projects/{project_id}`
UnenrollDataSourcesRequest:
{:dataSourceIds [string]}"
  [name UnenrollDataSourcesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}:unenrollDataSources",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body UnenrollDataSourcesRequest}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/bigquery/docs

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/bigquery/docs

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-dataSources-get
  "Retrieves a supported data source and returns its settings.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/dataSources/{data_source_id}` or `projects/{project_id}/locations/{location_id}/dataSources/{data_source_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-dataSources-list
  "Lists supported data sources and returns their settings.
https://cloud.google.com/bigquery/docs

parent <string> Required. The BigQuery project id for which data sources should be returned. Must be in the form: `projects/{project_id}` or `projects/{project_id}/locations/{location_id}`

optional:
pageSize <integer> Page size. The default page size is the maximum value of 1000 results."
  ([parent] (projects-locations-dataSources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/dataSources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-dataSources-checkValidCreds
  "Returns true if valid credentials exist for the given data source and requesting user.
https://cloud.google.com/bigquery/docs

name <string> Required. The data source in the form: `projects/{project_id}/dataSources/{data_source_id}` or `projects/{project_id}/locations/{location_id}/dataSources/{data_source_id}`.
CheckValidCredsRequest:
object"
  [name CheckValidCredsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}:checkValidCreds",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body CheckValidCredsRequest}))

(defn projects-locations-transferConfigs-create
  "Creates a new data transfer configuration.
https://cloud.google.com/bigquery/docs

parent <string> Required. The BigQuery project id where the transfer configuration should be created. Must be in the format projects/{project_id}/locations/{location_id} or projects/{project_id}. If specified location and location of the destination bigquery dataset do not match - the request will fail.
TransferConfig:
{:notificationPubsubTopic string,
 :destinationDatasetId string,
 :nextRunTime string,
 :schedule string,
 :disabled boolean,
 :ownerInfo {:email string},
 :displayName string,
 :name string,
 :params object,
 :emailPreferences {:enableFailureEmail boolean},
 :state
 [TRANSFER_STATE_UNSPECIFIED
  PENDING
  RUNNING
  SUCCEEDED
  FAILED
  CANCELLED],
 :scheduleOptions
 {:disableAutoScheduling boolean, :startTime string, :endTime string},
 :updateTime string,
 :dataRefreshWindowDays integer,
 :dataSourceId string,
 :datasetRegion string,
 :userId string,
 :encryptionConfiguration {:kmsKeyName string}}

optional:
authorizationCode <string> Optional OAuth2 authorization code to use with this transfer configuration. This is required only if `transferConfig.dataSourceId` is 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain authorization_code, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=authorization_code&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to create the transfer config.
versionInfo <string> Optional version info. This is required only if `transferConfig.dataSourceId` is not 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain version info, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=version_info&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to create the transfer config.
serviceAccountName <string> Optional service account email. If this field is set, the transfer config will be created with this service account's credentials. It requires that the requesting user calling this API has permissions to act as this service account. Note that not all data sources support service account credentials when creating a transfer config. For the latest list of data sources, read about [using service accounts](https://cloud.google.com/bigquery-transfer/docs/use-service-accounts)."
  ([parent TransferConfig]
    (projects-locations-transferConfigs-create
      parent
      TransferConfig
      nil))
  ([parent TransferConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/transferConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TransferConfig})))

(defn projects-locations-transferConfigs-patch
  "Updates a data transfer configuration. All fields must be set, even if they are not updated.
https://cloud.google.com/bigquery/docs

name <string> Identifier. The resource name of the transfer config. Transfer config names have the form either `projects/{project_id}/locations/{region}/transferConfigs/{config_id}` or `projects/{project_id}/transferConfigs/{config_id}`, where `config_id` is usually a UUID, even though it is not guaranteed or required. The name is ignored when creating a transfer config.
TransferConfig:
{:notificationPubsubTopic string,
 :destinationDatasetId string,
 :nextRunTime string,
 :schedule string,
 :disabled boolean,
 :ownerInfo {:email string},
 :displayName string,
 :name string,
 :params object,
 :emailPreferences {:enableFailureEmail boolean},
 :state
 [TRANSFER_STATE_UNSPECIFIED
  PENDING
  RUNNING
  SUCCEEDED
  FAILED
  CANCELLED],
 :scheduleOptions
 {:disableAutoScheduling boolean, :startTime string, :endTime string},
 :updateTime string,
 :dataRefreshWindowDays integer,
 :dataSourceId string,
 :datasetRegion string,
 :userId string,
 :encryptionConfiguration {:kmsKeyName string}}

optional:
authorizationCode <string> Optional OAuth2 authorization code to use with this transfer configuration. This is required only if `transferConfig.dataSourceId` is 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain authorization_code, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=authorization_code&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to update the transfer config.
updateMask <string> Required. Required list of fields to be updated in this request.
versionInfo <string> Optional version info. This is required only if `transferConfig.dataSourceId` is not 'youtube_channel' and new credentials are needed, as indicated by `CheckValidCreds`. In order to obtain version info, make a request to the following URL: https://bigquery.cloud.google.com/datatransfer/oauthz/auth?redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=version_info&client_id=client_id&scope=data_source_scopes * The client_id is the OAuth client_id of the a data source as returned by ListDataSources method. * data_source_scopes are the scopes returned by ListDataSources method. Note that this should not be set when `service_account_name` is used to update the transfer config.
serviceAccountName <string> Optional service account email. If this field is set, the transfer config will be created with this service account's credentials. It requires that the requesting user calling this API has permissions to act as this service account. Note that not all data sources support service account credentials when creating a transfer config. For the latest list of data sources, read about [using service accounts](https://cloud.google.com/bigquery-transfer/docs/use-service-accounts)."
  ([name TransferConfig]
    (projects-locations-transferConfigs-patch name TransferConfig nil))
  ([name TransferConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body TransferConfig})))

(defn projects-locations-transferConfigs-delete
  "Deletes a data transfer configuration, including any associated transfer runs and logs.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-transferConfigs-get
  "Returns information about a data transfer config.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-transferConfigs-list
  "Returns information about all transfer configs owned by a project in the specified location.
https://cloud.google.com/bigquery/docs

parent <string> Required. The BigQuery project id for which transfer configs should be returned: `projects/{project_id}` or `projects/{project_id}/locations/{location_id}`

optional:
dataSourceIds <string> When specified, only configurations of requested data sources are returned.
pageSize <integer> Page size. The default page size is the maximum value of 1000 results."
  ([parent] (projects-locations-transferConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/transferConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-transferConfigs-scheduleRuns
  "Creates transfer runs for a time range [start_time, end_time]. For each date - or whatever granularity the data source supports - in the range, one transfer run is created. Note that runs are created per UTC time in the time range. DEPRECATED: use StartManualTransferRuns instead.
https://cloud.google.com/bigquery/docs

parent <string> Required. Transfer configuration name in the form: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`.
ScheduleTransferRunsRequest:
{:startTime string, :endTime string}"
  [parent ScheduleTransferRunsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+parent}:scheduleRuns",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body ScheduleTransferRunsRequest}))

(defn projects-locations-transferConfigs-startManualRuns
  "Start manual transfer runs to be executed now with schedule_time equal to current time. The transfer runs can be created for a time range where the run_time is between start_time (inclusive) and end_time (exclusive), or for a specific run_time.
https://cloud.google.com/bigquery/docs

parent <string> Required. Transfer configuration name in the form: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`.
StartManualTransferRunsRequest:
{:requestedTimeRange {:startTime string, :endTime string},
 :requestedRunTime string}"
  [parent StartManualTransferRunsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+parent}:startManualRuns",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body StartManualTransferRunsRequest}))

(defn projects-locations-transferConfigs-runs-get
  "Returns information about the particular transfer run.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}/runs/{run_id}`"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-transferConfigs-runs-delete
  "Deletes the specified transfer run.
https://cloud.google.com/bigquery/docs

name <string> Required. The field will contain name of the resource requested, for example: `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}/runs/{run_id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquerydatatransfer.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-transferConfigs-runs-list
  "Returns information about running and completed transfer runs.
https://cloud.google.com/bigquery/docs

parent <string> Required. Name of transfer configuration for which transfer runs should be retrieved. Format of transfer configuration resource name is: `projects/{project_id}/transferConfigs/{config_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}`.

optional:
states <string> When specified, only transfer runs with requested states are returned.
pageSize <integer> Page size. The default page size is the maximum value of 1000 results.
runAttempt <string> Indicates how run attempts are to be pulled."
  ([parent] (projects-locations-transferConfigs-runs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/runs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-transferConfigs-runs-transferLogs-list
  "Returns log messages for the transfer run.
https://cloud.google.com/bigquery/docs

parent <string> Required. Transfer run name in the form: `projects/{project_id}/transferConfigs/{config_id}/runs/{run_id}` or `projects/{project_id}/locations/{location_id}/transferConfigs/{config_id}/runs/{run_id}`

optional:
pageSize <integer> Page size. The default page size is the maximum value of 1000 results.
messageTypes <string> Message types to return. If not populated - INFO, WARNING and ERROR messages are returned."
  ([parent]
    (projects-locations-transferConfigs-runs-transferLogs-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatatransfer.googleapis.com/v1/{+parent}/transferLogs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

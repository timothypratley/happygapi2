(ns happygapi2.appengine
  "App Engine Admin API
Provisions and manages developers' App Engine applications.
See: https://cloud.google.com/appengine/docs/admin-api/"
  (:require [happy.oauth2.client :as client]))

(defn apps-get
  "Gets information about an application.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/get

appsId <string> Part of `name`. Name of the Application resource to get. Example: apps/myapp.

optional:
includeExtraData <string> Options to include extra data"
  ([appsId] (apps-get appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-create
  "Creates an App Engine application for a Google Cloud Platform project. Required fields: id - The ID of the target Cloud Platform project. location - The region (https://cloud.google.com/appengine/docs/locations) where you want the App Engine application located.For more information about App Engine applications, see Managing Projects, Applications, and Billing (https://cloud.google.com/appengine/docs/standard/python/console/).
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/create

Application:
{:serviceAccount string,
 :gcrDomain string,
 :defaultBucket string,
 :codeBucket string,
 :locationId string,
 :servingStatus [UNSPECIFIED SERVING USER_DISABLED SYSTEM_DISABLED],
 :name string,
 :authDomain string,
 :dispatchRules [{:domain string, :path string, :service string}],
 :defaultHostname string,
 :iap
 {:enabled boolean,
  :oauth2ClientId string,
  :oauth2ClientSecret string,
  :oauth2ClientSecretSha256 string},
 :generatedCustomerMetadata object,
 :id string,
 :featureSettings
 {:splitHealthChecks boolean, :useContainerOptimizedOs boolean},
 :databaseType
 [DATABASE_TYPE_UNSPECIFIED
  CLOUD_DATASTORE
  CLOUD_FIRESTORE
  CLOUD_DATASTORE_COMPATIBILITY],
 :defaultCookieExpiration string}"
  [Application]
  (client/api-request
    {:method "POST",
     :uri-template "https://appengine.googleapis.com/v1/apps",
     :uri-template-args {},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Application}))

(defn apps-patch
  "Updates the specified Application resource. You can update the following fields: auth_domain - Google authentication domain for controlling user access to the application. default_cookie_expiration - Cookie expiration policy for the application. iap - Identity-Aware Proxy properties for the application.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/patch

appsId <string> Part of `name`. Name of the Application resource to update. Example: apps/myapp.
Application:
{:serviceAccount string,
 :gcrDomain string,
 :defaultBucket string,
 :codeBucket string,
 :locationId string,
 :servingStatus [UNSPECIFIED SERVING USER_DISABLED SYSTEM_DISABLED],
 :name string,
 :authDomain string,
 :dispatchRules [{:domain string, :path string, :service string}],
 :defaultHostname string,
 :iap
 {:enabled boolean,
  :oauth2ClientId string,
  :oauth2ClientSecret string,
  :oauth2ClientSecretSha256 string},
 :generatedCustomerMetadata object,
 :id string,
 :featureSettings
 {:splitHealthChecks boolean, :useContainerOptimizedOs boolean},
 :databaseType
 [DATABASE_TYPE_UNSPECIFIED
  CLOUD_DATASTORE
  CLOUD_FIRESTORE
  CLOUD_DATASTORE_COMPATIBILITY],
 :defaultCookieExpiration string}

optional:
updateMask <string> Required. Standard field mask for the set of fields to be updated."
  ([appsId Application] (apps-patch appsId Application nil))
  ([appsId Application optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Application})))

(defn apps-repair
  "Recreates the required App Engine features for the specified App Engine application, for example a Cloud Storage bucket or App Engine service account. Use this method if you receive an error message about a missing feature, for example, Error retrieving the App Engine service account. If you have deleted your App Engine service account, this will not be able to recreate it. Instead, you should attempt to use the IAM undelete API if possible at https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B\"name\"%3A\"projects%2F-%2FserviceAccounts%2Funique_id\"%2C\"resource\"%3A%7B%7D%7D . If the deletion was recent, the numeric ID can be found in the Cloud Console Activity Log.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/repair

appsId <string> Part of `name`. Name of the application to repair. Example: apps/myapp
RepairApplicationRequest:
object"
  [appsId RepairApplicationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}:repair",
     :uri-template-args {:appsId appsId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RepairApplicationRequest}))

(defn apps-listRuntimes
  "Lists all the available runtimes for the application.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/listRuntimes

appsId <string> Part of `parent`. Required. Name of the parent Application resource. Example: apps/myapp.

optional:
environment <string> Optional. The environment of the Application."
  ([appsId] (apps-listRuntimes appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}:listRuntimes",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/operations/list

appsId <string> Part of `name`. The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([appsId] (apps-operations-list appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/operations",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/operations/get

appsId <string> Part of `name`. The name of the operation resource.
operationsId <string> Part of `name`. See documentation of `appsId`."
  [appsId operationsId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/operations/{operationsId}",
     :uri-template-args {:appsId appsId, :operationsId operationsId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/appengine.admin"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn apps-services-list
  "Lists all the services in the application.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/list

appsId <string> Part of `parent`. Name of the parent Application resource. Example: apps/myapp.

optional:
pageSize <integer> Maximum results to return per page."
  ([appsId] (apps-services-list appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/services",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-services-get
  "Gets the current configuration of the specified service.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/get

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/services/default.
servicesId <string> Part of `name`. See documentation of `appsId`."
  [appsId servicesId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}",
     :uri-template-args {:appsId appsId, :servicesId servicesId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/appengine.admin"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn apps-services-patch
  "Updates the configuration of the specified service.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/patch

appsId <string> Part of `name`. Name of the resource to update. Example: apps/myapp/services/default.
servicesId <string> Part of `name`. See documentation of `appsId`.
Service:
{:name string,
 :id string,
 :split {:shardBy [UNSPECIFIED COOKIE IP RANDOM], :allocations object},
 :labels object,
 :networkSettings
 {:ingressTrafficAllowed
  [INGRESS_TRAFFIC_ALLOWED_UNSPECIFIED
   INGRESS_TRAFFIC_ALLOWED_ALL
   INGRESS_TRAFFIC_ALLOWED_INTERNAL_ONLY
   INGRESS_TRAFFIC_ALLOWED_INTERNAL_AND_LB]},
 :generatedCustomerMetadata object}

optional:
updateMask <string> Required. Standard field mask for the set of fields to be updated.
migrateTraffic <boolean> Set to true to gradually shift traffic to one or more versions that you specify. By default, traffic is shifted immediately. For gradual traffic migration, the target versions must be located within instances that are configured for both warmup requests (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#InboundServiceType) and automatic scaling (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#AutomaticScaling). You must specify the shardBy (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services#ShardBy) field in the Service resource. Gradual traffic migration is not supported in the App Engine flexible environment. For examples, see Migrating and Splitting Traffic (https://cloud.google.com/appengine/docs/admin-api/migrating-splitting-traffic)."
  ([appsId servicesId Service]
    (apps-services-patch appsId servicesId Service nil))
  ([appsId servicesId Service optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}",
       :uri-template-args {:appsId appsId, :servicesId servicesId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Service})))

(defn apps-services-delete
  "Deletes the specified service and all enclosed versions.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/delete

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/services/default.
servicesId <string> Part of `name`. See documentation of `appsId`."
  [appsId servicesId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}",
     :uri-template-args {:appsId appsId, :servicesId servicesId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn apps-services-versions-list
  "Lists the versions of a service.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/list

appsId <string> Part of `parent`. Name of the parent Service resource. Example: apps/myapp/services/default.
servicesId <string> Part of `parent`. See documentation of `appsId`.

optional:
view <string> Controls the set of fields returned in the List response.
pageSize <integer> Maximum results to return per page."
  ([appsId servicesId]
    (apps-services-versions-list appsId servicesId nil))
  ([appsId servicesId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions",
       :uri-template-args {:appsId appsId, :servicesId servicesId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-services-versions-get
  "Gets the specified Version resource. By default, only a BASIC_VIEW will be returned. Specify the FULL_VIEW parameter to get the full resource.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/get

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/services/default/versions/v1.
servicesId <string> Part of `name`. See documentation of `appsId`.
versionsId <string> Part of `name`. See documentation of `appsId`.

optional:
view <string> Controls the set of fields returned in the Get response."
  ([appsId servicesId versionsId]
    (apps-services-versions-get appsId servicesId versionsId nil))
  ([appsId servicesId versionsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}",
       :uri-template-args
       {:appsId appsId,
        :servicesId servicesId,
        :versionsId versionsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-services-versions-create
  "Deploys code and resource files to a new version.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/create

appsId <string> Part of `parent`. Name of the parent resource to create this version under. Example: apps/myapp/services/default.
servicesId <string> Part of `parent`. See documentation of `appsId`.
Version:
{:serviceAccount string,
 :runtimeChannel string,
 :appEngineApis boolean,
 :automaticScaling
 {:maxConcurrentRequests integer,
  :maxPendingLatency string,
  :requestUtilization
  {:targetRequestCountPerSecond integer,
   :targetConcurrentRequests integer},
  :maxTotalInstances integer,
  :standardSchedulerSettings
  {:targetCpuUtilization number,
   :targetThroughputUtilization number,
   :minInstances integer,
   :maxInstances integer},
  :diskUtilization
  {:targetWriteBytesPerSecond integer,
   :targetWriteOpsPerSecond integer,
   :targetReadBytesPerSecond integer,
   :targetReadOpsPerSecond integer},
  :cpuUtilization
  {:aggregationWindowLength string, :targetUtilization number},
  :coolDownPeriod string,
  :minPendingLatency string,
  :minTotalInstances integer,
  :minIdleInstances integer,
  :maxIdleInstances integer,
  :networkUtilization
  {:targetSentBytesPerSecond integer,
   :targetSentPacketsPerSecond integer,
   :targetReceivedBytesPerSecond integer,
   :targetReceivedPacketsPerSecond integer}},
 :createdBy string,
 :libraries [{:name string, :version string}],
 :nobuildFilesRegex string,
 :servingStatus [SERVING_STATUS_UNSPECIFIED SERVING STOPPED],
 :endpointsApiService
 {:name string,
  :configId string,
  :rolloutStrategy [UNSPECIFIED_ROLLOUT_STRATEGY FIXED MANAGED],
  :disableTraceSampling boolean},
 :name string,
 :versionUrl string,
 :createTime string,
 :vm boolean,
 :betaSettings object,
 :handlers
 [{:urlRegex string,
   :staticFiles
   {:path string,
    :uploadPathRegex string,
    :httpHeaders object,
    :mimeType string,
    :expiration string,
    :requireMatchingFile boolean,
    :applicationReadable boolean},
   :script {:scriptPath string},
   :apiEndpoint {:scriptPath string},
   :securityLevel
   [SECURE_UNSPECIFIED
    SECURE_DEFAULT
    SECURE_NEVER
    SECURE_OPTIONAL
    SECURE_ALWAYS],
   :login
   [LOGIN_UNSPECIFIED LOGIN_OPTIONAL LOGIN_ADMIN LOGIN_REQUIRED],
   :authFailAction
   [AUTH_FAIL_ACTION_UNSPECIFIED
    AUTH_FAIL_ACTION_REDIRECT
    AUTH_FAIL_ACTION_UNAUTHORIZED],
   :redirectHttpResponseCode
   [REDIRECT_HTTP_RESPONSE_CODE_UNSPECIFIED
    REDIRECT_HTTP_RESPONSE_CODE_301
    REDIRECT_HTTP_RESPONSE_CODE_302
    REDIRECT_HTTP_RESPONSE_CODE_303
    REDIRECT_HTTP_RESPONSE_CODE_307]}],
 :env string,
 :buildEnvVariables object,
 :threadsafe boolean,
 :runtimeMainExecutablePath string,
 :livenessCheck
 {:path string,
  :host string,
  :failureThreshold integer,
  :successThreshold integer,
  :checkInterval string,
  :timeout string,
  :initialDelay string},
 :envVariables object,
 :vpcAccessConnector
 {:name string,
  :egressSetting
  [EGRESS_SETTING_UNSPECIFIED ALL_TRAFFIC PRIVATE_IP_RANGES]},
 :generatedCustomerMetadata object,
 :id string,
 :runtime string,
 :manualScaling {:instances integer},
 :zones [string],
 :entrypoint {:shell string},
 :deployment
 {:files object,
  :container {:image string},
  :zip {:sourceUrl string, :filesCount integer},
  :cloudBuildOptions {:appYamlPath string, :cloudBuildTimeout string}},
 :errorHandlers
 [{:errorCode
   [ERROR_CODE_UNSPECIFIED
    ERROR_CODE_DEFAULT
    ERROR_CODE_OVER_QUOTA
    ERROR_CODE_DOS_API_DENIAL
    ERROR_CODE_TIMEOUT],
   :staticFile string,
   :mimeType string}],
 :network
 {:forwardedPorts [string],
  :instanceTag string,
  :name string,
  :subnetworkName string,
  :sessionAffinity boolean,
  :instanceIpMode [INSTANCE_IP_MODE_UNSPECIFIED EXTERNAL INTERNAL]},
 :instanceClass string,
 :inboundServices
 [[INBOUND_SERVICE_UNSPECIFIED
   INBOUND_SERVICE_MAIL
   INBOUND_SERVICE_MAIL_BOUNCE
   INBOUND_SERVICE_XMPP_ERROR
   INBOUND_SERVICE_XMPP_MESSAGE
   INBOUND_SERVICE_XMPP_SUBSCRIBE
   INBOUND_SERVICE_XMPP_PRESENCE
   INBOUND_SERVICE_CHANNEL_PRESENCE
   INBOUND_SERVICE_WARMUP]],
 :resources
 {:cpu number,
  :diskGb number,
  :memoryGb number,
  :volumes [{:name string, :volumeType string, :sizeGb number}],
  :kmsKeyReference string},
 :defaultExpiration string,
 :diskUsageBytes string,
 :flexibleRuntimeSettings
 {:operatingSystem string, :runtimeVersion string},
 :apiConfig
 {:authFailAction
  [AUTH_FAIL_ACTION_UNSPECIFIED
   AUTH_FAIL_ACTION_REDIRECT
   AUTH_FAIL_ACTION_UNAUTHORIZED],
  :login [LOGIN_UNSPECIFIED LOGIN_OPTIONAL LOGIN_ADMIN LOGIN_REQUIRED],
  :script string,
  :securityLevel
  [SECURE_UNSPECIFIED
   SECURE_DEFAULT
   SECURE_NEVER
   SECURE_OPTIONAL
   SECURE_ALWAYS],
  :url string},
 :healthCheck
 {:disableHealthCheck boolean,
  :host string,
  :healthyThreshold integer,
  :unhealthyThreshold integer,
  :restartThreshold integer,
  :checkInterval string,
  :timeout string},
 :basicScaling {:idleTimeout string, :maxInstances integer},
 :readinessCheck
 {:path string,
  :host string,
  :failureThreshold integer,
  :successThreshold integer,
  :checkInterval string,
  :timeout string,
  :appStartTimeout string},
 :runtimeApiVersion string}"
  [appsId servicesId Version]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions",
     :uri-template-args {:appsId appsId, :servicesId servicesId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Version}))

(defn apps-services-versions-patch
  "Updates the specified Version resource. You can specify the following fields depending on the App Engine environment and type of scaling that the version resource uses:Standard environment instance_class (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.instance_class)automatic scaling in the standard environment: automatic_scaling.min_idle_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.max_idle_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automaticScaling.standard_scheduler_settings.max_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings) automaticScaling.standard_scheduler_settings.min_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings) automaticScaling.standard_scheduler_settings.target_cpu_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings) automaticScaling.standard_scheduler_settings.target_throughput_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)basic scaling or manual scaling in the standard environment: serving_status (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status) manual_scaling.instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)Flexible environment serving_status (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)automatic scaling in the flexible environment: automatic_scaling.min_total_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.max_total_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.cool_down_period_sec (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.cpu_utilization.target_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)manual scaling in the flexible environment: manual_scaling.instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/patch

appsId <string> Part of `name`. Name of the resource to update. Example: apps/myapp/services/default/versions/1.
servicesId <string> Part of `name`. See documentation of `appsId`.
versionsId <string> Part of `name`. See documentation of `appsId`.
Version:
{:serviceAccount string,
 :runtimeChannel string,
 :appEngineApis boolean,
 :automaticScaling
 {:maxConcurrentRequests integer,
  :maxPendingLatency string,
  :requestUtilization
  {:targetRequestCountPerSecond integer,
   :targetConcurrentRequests integer},
  :maxTotalInstances integer,
  :standardSchedulerSettings
  {:targetCpuUtilization number,
   :targetThroughputUtilization number,
   :minInstances integer,
   :maxInstances integer},
  :diskUtilization
  {:targetWriteBytesPerSecond integer,
   :targetWriteOpsPerSecond integer,
   :targetReadBytesPerSecond integer,
   :targetReadOpsPerSecond integer},
  :cpuUtilization
  {:aggregationWindowLength string, :targetUtilization number},
  :coolDownPeriod string,
  :minPendingLatency string,
  :minTotalInstances integer,
  :minIdleInstances integer,
  :maxIdleInstances integer,
  :networkUtilization
  {:targetSentBytesPerSecond integer,
   :targetSentPacketsPerSecond integer,
   :targetReceivedBytesPerSecond integer,
   :targetReceivedPacketsPerSecond integer}},
 :createdBy string,
 :libraries [{:name string, :version string}],
 :nobuildFilesRegex string,
 :servingStatus [SERVING_STATUS_UNSPECIFIED SERVING STOPPED],
 :endpointsApiService
 {:name string,
  :configId string,
  :rolloutStrategy [UNSPECIFIED_ROLLOUT_STRATEGY FIXED MANAGED],
  :disableTraceSampling boolean},
 :name string,
 :versionUrl string,
 :createTime string,
 :vm boolean,
 :betaSettings object,
 :handlers
 [{:urlRegex string,
   :staticFiles
   {:path string,
    :uploadPathRegex string,
    :httpHeaders object,
    :mimeType string,
    :expiration string,
    :requireMatchingFile boolean,
    :applicationReadable boolean},
   :script {:scriptPath string},
   :apiEndpoint {:scriptPath string},
   :securityLevel
   [SECURE_UNSPECIFIED
    SECURE_DEFAULT
    SECURE_NEVER
    SECURE_OPTIONAL
    SECURE_ALWAYS],
   :login
   [LOGIN_UNSPECIFIED LOGIN_OPTIONAL LOGIN_ADMIN LOGIN_REQUIRED],
   :authFailAction
   [AUTH_FAIL_ACTION_UNSPECIFIED
    AUTH_FAIL_ACTION_REDIRECT
    AUTH_FAIL_ACTION_UNAUTHORIZED],
   :redirectHttpResponseCode
   [REDIRECT_HTTP_RESPONSE_CODE_UNSPECIFIED
    REDIRECT_HTTP_RESPONSE_CODE_301
    REDIRECT_HTTP_RESPONSE_CODE_302
    REDIRECT_HTTP_RESPONSE_CODE_303
    REDIRECT_HTTP_RESPONSE_CODE_307]}],
 :env string,
 :buildEnvVariables object,
 :threadsafe boolean,
 :runtimeMainExecutablePath string,
 :livenessCheck
 {:path string,
  :host string,
  :failureThreshold integer,
  :successThreshold integer,
  :checkInterval string,
  :timeout string,
  :initialDelay string},
 :envVariables object,
 :vpcAccessConnector
 {:name string,
  :egressSetting
  [EGRESS_SETTING_UNSPECIFIED ALL_TRAFFIC PRIVATE_IP_RANGES]},
 :generatedCustomerMetadata object,
 :id string,
 :runtime string,
 :manualScaling {:instances integer},
 :zones [string],
 :entrypoint {:shell string},
 :deployment
 {:files object,
  :container {:image string},
  :zip {:sourceUrl string, :filesCount integer},
  :cloudBuildOptions {:appYamlPath string, :cloudBuildTimeout string}},
 :errorHandlers
 [{:errorCode
   [ERROR_CODE_UNSPECIFIED
    ERROR_CODE_DEFAULT
    ERROR_CODE_OVER_QUOTA
    ERROR_CODE_DOS_API_DENIAL
    ERROR_CODE_TIMEOUT],
   :staticFile string,
   :mimeType string}],
 :network
 {:forwardedPorts [string],
  :instanceTag string,
  :name string,
  :subnetworkName string,
  :sessionAffinity boolean,
  :instanceIpMode [INSTANCE_IP_MODE_UNSPECIFIED EXTERNAL INTERNAL]},
 :instanceClass string,
 :inboundServices
 [[INBOUND_SERVICE_UNSPECIFIED
   INBOUND_SERVICE_MAIL
   INBOUND_SERVICE_MAIL_BOUNCE
   INBOUND_SERVICE_XMPP_ERROR
   INBOUND_SERVICE_XMPP_MESSAGE
   INBOUND_SERVICE_XMPP_SUBSCRIBE
   INBOUND_SERVICE_XMPP_PRESENCE
   INBOUND_SERVICE_CHANNEL_PRESENCE
   INBOUND_SERVICE_WARMUP]],
 :resources
 {:cpu number,
  :diskGb number,
  :memoryGb number,
  :volumes [{:name string, :volumeType string, :sizeGb number}],
  :kmsKeyReference string},
 :defaultExpiration string,
 :diskUsageBytes string,
 :flexibleRuntimeSettings
 {:operatingSystem string, :runtimeVersion string},
 :apiConfig
 {:authFailAction
  [AUTH_FAIL_ACTION_UNSPECIFIED
   AUTH_FAIL_ACTION_REDIRECT
   AUTH_FAIL_ACTION_UNAUTHORIZED],
  :login [LOGIN_UNSPECIFIED LOGIN_OPTIONAL LOGIN_ADMIN LOGIN_REQUIRED],
  :script string,
  :securityLevel
  [SECURE_UNSPECIFIED
   SECURE_DEFAULT
   SECURE_NEVER
   SECURE_OPTIONAL
   SECURE_ALWAYS],
  :url string},
 :healthCheck
 {:disableHealthCheck boolean,
  :host string,
  :healthyThreshold integer,
  :unhealthyThreshold integer,
  :restartThreshold integer,
  :checkInterval string,
  :timeout string},
 :basicScaling {:idleTimeout string, :maxInstances integer},
 :readinessCheck
 {:path string,
  :host string,
  :failureThreshold integer,
  :successThreshold integer,
  :checkInterval string,
  :timeout string,
  :appStartTimeout string},
 :runtimeApiVersion string}

optional:
updateMask <string> Standard field mask for the set of fields to be updated."
  ([appsId servicesId versionsId Version]
    (apps-services-versions-patch
      appsId
      servicesId
      versionsId
      Version
      nil))
  ([appsId servicesId versionsId Version optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}",
       :uri-template-args
       {:appsId appsId,
        :servicesId servicesId,
        :versionsId versionsId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Version})))

(defn apps-services-versions-delete
  "Deletes an existing Version resource.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/delete

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/services/default/versions/v1.
servicesId <string> Part of `name`. See documentation of `appsId`.
versionsId <string> Part of `name`. See documentation of `appsId`."
  [appsId servicesId versionsId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}",
     :uri-template-args
     {:appsId appsId, :servicesId servicesId, :versionsId versionsId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn apps-services-versions-instances-list
  "Lists the instances of a version.Tip: To aggregate details about instances over time, see the Stackdriver Monitoring API (https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.timeSeries/list).
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/instances/list

appsId <string> Part of `parent`. Name of the parent Version resource. Example: apps/myapp/services/default/versions/v1.
servicesId <string> Part of `parent`. See documentation of `appsId`.
versionsId <string> Part of `parent`. See documentation of `appsId`.

optional:
pageSize <integer> Maximum results to return per page."
  ([appsId servicesId versionsId]
    (apps-services-versions-instances-list
      appsId
      servicesId
      versionsId
      nil))
  ([appsId servicesId versionsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances",
       :uri-template-args
       {:appsId appsId,
        :servicesId servicesId,
        :versionsId versionsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-services-versions-instances-get
  "Gets instance information.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/instances/get

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/services/default/versions/v1/instances/instance-1.
servicesId <string> Part of `name`. See documentation of `appsId`.
versionsId <string> Part of `name`. See documentation of `appsId`.
instancesId <string> Part of `name`. See documentation of `appsId`."
  [appsId servicesId versionsId instancesId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}",
     :uri-template-args
     {:appsId appsId,
      :servicesId servicesId,
      :versionsId versionsId,
      :instancesId instancesId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/appengine.admin"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn apps-services-versions-instances-delete
  "Stops a running instance.The instance might be automatically recreated based on the scaling settings of the version. For more information, see \"How Instances are Managed\" (standard environment (https://cloud.google.com/appengine/docs/standard/python/how-instances-are-managed) | flexible environment (https://cloud.google.com/appengine/docs/flexible/python/how-instances-are-managed)).To ensure that instances are not re-created and avoid getting billed, you can stop all instances within the target version by changing the serving status of the version to STOPPED with the apps.services.versions.patch (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions/patch) method.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/instances/delete

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/services/default/versions/v1/instances/instance-1.
servicesId <string> Part of `name`. See documentation of `appsId`.
versionsId <string> Part of `name`. See documentation of `appsId`.
instancesId <string> Part of `name`. See documentation of `appsId`."
  [appsId servicesId versionsId instancesId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}",
     :uri-template-args
     {:appsId appsId,
      :servicesId servicesId,
      :versionsId versionsId,
      :instancesId instancesId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn apps-services-versions-instances-debug
  "Enables debugging on a VM instance. This allows you to use the SSH command to connect to the virtual machine where the instance lives. While in \"debug mode\", the instance continues to serve live traffic. You should delete the instance when you are done debugging and then allow the system to take over and determine if another instance should be started.Only applicable for instances in App Engine flexible environment.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/services/versions/instances/debug

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/services/default/versions/v1/instances/instance-1.
servicesId <string> Part of `name`. See documentation of `appsId`.
versionsId <string> Part of `name`. See documentation of `appsId`.
instancesId <string> Part of `name`. See documentation of `appsId`.
DebugInstanceRequest:
{:sshKey string}"
  [appsId servicesId versionsId instancesId DebugInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}:debug",
     :uri-template-args
     {:appsId appsId,
      :servicesId servicesId,
      :versionsId versionsId,
      :instancesId instancesId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DebugInstanceRequest}))

(defn apps-firewall-ingressRules-list
  "Lists the firewall rules of an application.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/firewall/ingressRules/list

appsId <string> Part of `parent`. Name of the Firewall collection to retrieve. Example: apps/myapp/firewall/ingressRules.

optional:
pageSize <integer> Maximum results to return per page.
matchingAddress <string> A valid IP Address. If set, only rules matching this address will be returned. The first returned rule will be the rule that fires on requests from this IP."
  ([appsId] (apps-firewall-ingressRules-list appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/firewall/ingressRules",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-firewall-ingressRules-batchUpdate
  "Replaces the entire firewall ruleset in one bulk operation. This overrides and replaces the rules of an existing firewall with the new rules.If the final rule does not match traffic with the '*' wildcard IP range, then an \"allow all\" rule is explicitly added to the end of the list.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/firewall/ingressRules/batchUpdate

appsId <string> Part of `name`. Name of the Firewall collection to set. Example: apps/myapp/firewall/ingressRules.
BatchUpdateIngressRulesRequest:
{:ingressRules
 [{:priority integer,
   :action [UNSPECIFIED_ACTION ALLOW DENY],
   :sourceRange string,
   :description string}]}"
  [appsId BatchUpdateIngressRulesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/firewall/ingressRules:batchUpdate",
     :uri-template-args {:appsId appsId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchUpdateIngressRulesRequest}))

(defn apps-firewall-ingressRules-create
  "Creates a firewall rule for the application.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/firewall/ingressRules/create

appsId <string> Part of `parent`. Name of the parent Firewall collection in which to create a new rule. Example: apps/myapp/firewall/ingressRules.
FirewallRule:
{:priority integer,
 :action [UNSPECIFIED_ACTION ALLOW DENY],
 :sourceRange string,
 :description string}"
  [appsId FirewallRule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/firewall/ingressRules",
     :uri-template-args {:appsId appsId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body FirewallRule}))

(defn apps-firewall-ingressRules-get
  "Gets the specified firewall rule.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/firewall/ingressRules/get

appsId <string> Part of `name`. Name of the Firewall resource to retrieve. Example: apps/myapp/firewall/ingressRules/100.
ingressRulesId <string> Part of `name`. See documentation of `appsId`."
  [appsId ingressRulesId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}",
     :uri-template-args
     {:appsId appsId, :ingressRulesId ingressRulesId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/appengine.admin"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn apps-firewall-ingressRules-patch
  "Updates the specified firewall rule.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/firewall/ingressRules/patch

appsId <string> Part of `name`. Name of the Firewall resource to update. Example: apps/myapp/firewall/ingressRules/100.
ingressRulesId <string> Part of `name`. See documentation of `appsId`.
FirewallRule:
{:priority integer,
 :action [UNSPECIFIED_ACTION ALLOW DENY],
 :sourceRange string,
 :description string}

optional:
updateMask <string> Standard field mask for the set of fields to be updated."
  ([appsId ingressRulesId FirewallRule]
    (apps-firewall-ingressRules-patch
      appsId
      ingressRulesId
      FirewallRule
      nil))
  ([appsId ingressRulesId FirewallRule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}",
       :uri-template-args
       {:appsId appsId, :ingressRulesId ingressRulesId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body FirewallRule})))

(defn apps-firewall-ingressRules-delete
  "Deletes the specified firewall rule.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/firewall/ingressRules/delete

appsId <string> Part of `name`. Name of the Firewall resource to delete. Example: apps/myapp/firewall/ingressRules/100.
ingressRulesId <string> Part of `name`. See documentation of `appsId`."
  [appsId ingressRulesId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}",
     :uri-template-args
     {:appsId appsId, :ingressRulesId ingressRulesId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn apps-authorizedDomains-list
  "Lists all domains the user is authorized to administer.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/authorizedDomains/list

appsId <string> Part of `parent`. Name of the parent Application resource. Example: apps/myapp.

optional:
pageSize <integer> Maximum results to return per page."
  ([appsId] (apps-authorizedDomains-list appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/authorizedDomains",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-authorizedCertificates-list
  "Lists all SSL certificates the user is authorized to administer.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/authorizedCertificates/list

appsId <string> Part of `parent`. Name of the parent Application resource. Example: apps/myapp.

optional:
view <string> Controls the set of fields returned in the LIST response.
pageSize <integer> Maximum results to return per page."
  ([appsId] (apps-authorizedCertificates-list appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/authorizedCertificates",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-authorizedCertificates-get
  "Gets the specified SSL certificate.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/authorizedCertificates/get

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/authorizedCertificates/12345.
authorizedCertificatesId <string> Part of `name`. See documentation of `appsId`.

optional:
view <string> Controls the set of fields returned in the GET response."
  ([appsId authorizedCertificatesId]
    (apps-authorizedCertificates-get
      appsId
      authorizedCertificatesId
      nil))
  ([appsId authorizedCertificatesId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}",
       :uri-template-args
       {:appsId appsId,
        :authorizedCertificatesId authorizedCertificatesId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-authorizedCertificates-create
  "Uploads the specified SSL certificate.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/authorizedCertificates/create

appsId <string> Part of `parent`. Name of the parent Application resource. Example: apps/myapp.
AuthorizedCertificate:
{:certificateRawData {:publicCertificate string, :privateKey string},
 :displayName string,
 :name string,
 :visibleDomainMappings [string],
 :id string,
 :domainMappingsCount integer,
 :domainNames [string],
 :managedCertificate
 {:lastRenewalTime string,
  :status
  [MANAGEMENT_STATUS_UNSPECIFIED
   OK
   PENDING
   FAILED_RETRYING_NOT_VISIBLE
   FAILED_PERMANENT
   FAILED_RETRYING_CAA_FORBIDDEN
   FAILED_RETRYING_CAA_CHECKING]},
 :expireTime string}"
  [appsId AuthorizedCertificate]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/authorizedCertificates",
     :uri-template-args {:appsId appsId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body AuthorizedCertificate}))

(defn apps-authorizedCertificates-patch
  "Updates the specified SSL certificate. To renew a certificate and maintain its existing domain mappings, update certificate_data with a new certificate. The new certificate must be applicable to the same domains as the original certificate. The certificate display_name may also be updated.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/authorizedCertificates/patch

appsId <string> Part of `name`. Name of the resource to update. Example: apps/myapp/authorizedCertificates/12345.
authorizedCertificatesId <string> Part of `name`. See documentation of `appsId`.
AuthorizedCertificate:
{:certificateRawData {:publicCertificate string, :privateKey string},
 :displayName string,
 :name string,
 :visibleDomainMappings [string],
 :id string,
 :domainMappingsCount integer,
 :domainNames [string],
 :managedCertificate
 {:lastRenewalTime string,
  :status
  [MANAGEMENT_STATUS_UNSPECIFIED
   OK
   PENDING
   FAILED_RETRYING_NOT_VISIBLE
   FAILED_PERMANENT
   FAILED_RETRYING_CAA_FORBIDDEN
   FAILED_RETRYING_CAA_CHECKING]},
 :expireTime string}

optional:
updateMask <string> Standard field mask for the set of fields to be updated. Updates are only supported on the certificate_raw_data and display_name fields."
  ([appsId authorizedCertificatesId AuthorizedCertificate]
    (apps-authorizedCertificates-patch
      appsId
      authorizedCertificatesId
      AuthorizedCertificate
      nil))
  ([appsId authorizedCertificatesId AuthorizedCertificate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}",
       :uri-template-args
       {:appsId appsId,
        :authorizedCertificatesId authorizedCertificatesId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AuthorizedCertificate})))

(defn apps-authorizedCertificates-delete
  "Deletes the specified SSL certificate.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/authorizedCertificates/delete

appsId <string> Part of `name`. Name of the resource to delete. Example: apps/myapp/authorizedCertificates/12345.
authorizedCertificatesId <string> Part of `name`. See documentation of `appsId`."
  [appsId authorizedCertificatesId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}",
     :uri-template-args
     {:appsId appsId,
      :authorizedCertificatesId authorizedCertificatesId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn apps-domainMappings-list
  "Lists the domain mappings on an application.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/domainMappings/list

appsId <string> Part of `parent`. Name of the parent Application resource. Example: apps/myapp.

optional:
pageSize <integer> Maximum results to return per page."
  ([appsId] (apps-domainMappings-list appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/domainMappings",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-domainMappings-get
  "Gets the specified domain mapping.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/domainMappings/get

appsId <string> Part of `name`. Name of the resource requested. Example: apps/myapp/domainMappings/example.com.
domainMappingsId <string> Part of `name`. See documentation of `appsId`."
  [appsId domainMappingsId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/domainMappings/{domainMappingsId}",
     :uri-template-args
     {:appsId appsId, :domainMappingsId domainMappingsId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/appengine.admin"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn apps-domainMappings-create
  "Maps a domain to an application. A user must be authorized to administer a domain in order to map it to an application. For a list of available authorized domains, see AuthorizedDomains.ListAuthorizedDomains.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/domainMappings/create

appsId <string> Part of `parent`. Name of the parent Application resource. Example: apps/myapp.
DomainMapping:
{:name string,
 :id string,
 :sslSettings
 {:certificateId string,
  :sslManagementType
  [SSL_MANAGEMENT_TYPE_UNSPECIFIED AUTOMATIC MANUAL],
  :pendingManagedCertificateId string},
 :resourceRecords
 [{:name string,
   :rrdata string,
   :type [RECORD_TYPE_UNSPECIFIED A AAAA CNAME]}]}

optional:
overrideStrategy <string> Whether the domain creation should override any existing mappings for this domain. By default, overrides are rejected."
  ([appsId DomainMapping]
    (apps-domainMappings-create appsId DomainMapping nil))
  ([appsId DomainMapping optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/domainMappings",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DomainMapping})))

(defn apps-domainMappings-patch
  "Updates the specified domain mapping. To map an SSL certificate to a domain mapping, update certificate_id to point to an AuthorizedCertificate resource. A user must be authorized to administer the associated domain in order to update a DomainMapping resource.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/domainMappings/patch

appsId <string> Part of `name`. Name of the resource to update. Example: apps/myapp/domainMappings/example.com.
domainMappingsId <string> Part of `name`. See documentation of `appsId`.
DomainMapping:
{:name string,
 :id string,
 :sslSettings
 {:certificateId string,
  :sslManagementType
  [SSL_MANAGEMENT_TYPE_UNSPECIFIED AUTOMATIC MANUAL],
  :pendingManagedCertificateId string},
 :resourceRecords
 [{:name string,
   :rrdata string,
   :type [RECORD_TYPE_UNSPECIFIED A AAAA CNAME]}]}

optional:
updateMask <string> Required. Standard field mask for the set of fields to be updated."
  ([appsId domainMappingsId DomainMapping]
    (apps-domainMappings-patch
      appsId
      domainMappingsId
      DomainMapping
      nil))
  ([appsId domainMappingsId DomainMapping optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/domainMappings/{domainMappingsId}",
       :uri-template-args
       {:appsId appsId, :domainMappingsId domainMappingsId},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body DomainMapping})))

(defn apps-domainMappings-delete
  "Deletes the specified domain mapping. A user must be authorized to administer the associated domain in order to delete a DomainMapping resource.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/domainMappings/delete

appsId <string> Part of `name`. Name of the resource to delete. Example: apps/myapp/domainMappings/example.com.
domainMappingsId <string> Part of `name`. See documentation of `appsId`."
  [appsId domainMappingsId]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/domainMappings/{domainMappingsId}",
     :uri-template-args
     {:appsId appsId, :domainMappingsId domainMappingsId},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn apps-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/locations/list

appsId <string> Part of `name`. The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like \"displayName=tokyo\", and is documented in more detail in AIP-160 (https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([appsId] (apps-locations-list appsId nil))
  ([appsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/apps/{appsId}/locations",
       :uri-template-args {:appsId appsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn apps-locations-get
  "Gets information about a location.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps/locations/get

appsId <string> Part of `name`. Resource name for the location.
locationsId <string> Part of `name`. See documentation of `appsId`."
  [appsId locationsId]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://appengine.googleapis.com/v1/apps/{appsId}/locations/{locationsId}",
     :uri-template-args {:appsId appsId, :locationsId locationsId},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/appengine.admin"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-applications-authorizedDomains-list
  "Lists all domains the user is authorized to administer.
https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/projects/locations/applications/authorizedDomains/list

projectsId <string> Part of `parent`. Name of the parent Application resource. Example: apps/myapp.
locationsId <string> Part of `parent`. See documentation of `projectsId`.
applicationsId <string> Part of `parent`. See documentation of `projectsId`.

optional:
pageSize <integer> Maximum results to return per page."
  ([projectsId locationsId applicationsId]
    (projects-locations-applications-authorizedDomains-list
      projectsId
      locationsId
      applicationsId
      nil))
  ([projectsId locationsId applicationsId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://appengine.googleapis.com/v1/projects/{projectsId}/locations/{locationsId}/applications/{applicationsId}/authorizedDomains",
       :uri-template-args
       {:projectsId projectsId,
        :locationsId locationsId,
        :applicationsId applicationsId},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/appengine.admin"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

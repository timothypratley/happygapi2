(ns happygapi2.websecurityscanner
  "Web Security Scanner API
Scans your Compute and App Engine apps for common web vulnerabilities.
See: https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/"
  (:require [happy.oauth2.client :as client]))

(defn projects-scanConfigs-create
  "Creates a new ScanConfig.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

parent <string> Required. The parent resource name where the scan is created, which should be a project resource name in the format 'projects/{projectId}'.
ScanConfig:
{:schedule {:intervalDurationDays integer, :scheduleTime string},
 :maxQps integer,
 :displayName string,
 :name string,
 :riskLevel [RISK_LEVEL_UNSPECIFIED NORMAL LOW],
 :managedScan boolean,
 :staticIpScan boolean,
 :exportToSecurityCommandCenter
 [EXPORT_TO_SECURITY_COMMAND_CENTER_UNSPECIFIED ENABLED DISABLED],
 :startingUrls [string],
 :authentication
 {:iapCredential
  {:iapTestServiceAccountInfo {:targetAudienceClientId string}},
  :googleAccount {:password string, :username string},
  :customAccount
  {:username string, :password string, :loginUrl string}},
 :userAgent
 [USER_AGENT_UNSPECIFIED CHROME_LINUX CHROME_ANDROID SAFARI_IPHONE],
 :blacklistPatterns [string],
 :ignoreHttpStatusErrors boolean}"
  [parent ScanConfig]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+parent}/scanConfigs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ScanConfig}))

(defn projects-scanConfigs-get
  "Gets a ScanConfig.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

name <string> Required. The resource name of the ScanConfig to be returned. The name follows the format of 'projects/{projectId}/scanConfigs/{scanConfigId}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-scanConfigs-start
  "Start a ScanRun according to the given ScanConfig.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

name <string> Required. The resource name of the ScanConfig to be used. The name follows the format of 'projects/{projectId}/scanConfigs/{scanConfigId}'.
StartScanRunRequest:
object"
  [name StartScanRunRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+name}:start",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartScanRunRequest}))

(defn projects-scanConfigs-patch
  "Updates a ScanConfig. This method support partial update of a ScanConfig.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

name <string> The resource name of the ScanConfig. The name follows the format of 'projects/{projectId}/scanConfigs/{scanConfigId}'. The ScanConfig IDs are generated by the system.
ScanConfig:
{:schedule {:intervalDurationDays integer, :scheduleTime string},
 :maxQps integer,
 :displayName string,
 :name string,
 :riskLevel [RISK_LEVEL_UNSPECIFIED NORMAL LOW],
 :managedScan boolean,
 :staticIpScan boolean,
 :exportToSecurityCommandCenter
 [EXPORT_TO_SECURITY_COMMAND_CENTER_UNSPECIFIED ENABLED DISABLED],
 :startingUrls [string],
 :authentication
 {:iapCredential
  {:iapTestServiceAccountInfo {:targetAudienceClientId string}},
  :googleAccount {:password string, :username string},
  :customAccount
  {:username string, :password string, :loginUrl string}},
 :userAgent
 [USER_AGENT_UNSPECIFIED CHROME_LINUX CHROME_ANDROID SAFARI_IPHONE],
 :blacklistPatterns [string],
 :ignoreHttpStatusErrors boolean}

optional:
updateMask <string> Required. The update mask applies to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name ScanConfig] (projects-scanConfigs-patch name ScanConfig nil))
  ([name ScanConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://websecurityscanner.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ScanConfig})))

(defn projects-scanConfigs-list
  "Lists ScanConfigs under a given project.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

parent <string> Required. The parent resource name, which should be a project resource name in the format 'projects/{projectId}'.

optional:
pageSize <integer> The maximum number of ScanConfigs to return, can be limited by server. If not specified or not positive, the implementation will select a reasonable value."
  ([parent] (projects-scanConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://websecurityscanner.googleapis.com/v1/{+parent}/scanConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-scanConfigs-delete
  "Deletes an existing ScanConfig and its child resources.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

name <string> Required. The resource name of the ScanConfig to be deleted. The name follows the format of 'projects/{projectId}/scanConfigs/{scanConfigId}'."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-scanConfigs-scanRuns-stop
  "Stops a ScanRun. The stopped ScanRun is returned.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

name <string> Required. The resource name of the ScanRun to be stopped. The name follows the format of 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.
StopScanRunRequest:
object"
  [name StopScanRunRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+name}:stop",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StopScanRunRequest}))

(defn projects-scanConfigs-scanRuns-list
  "Lists ScanRuns under a given ScanConfig, in descending order of ScanRun stop time.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

parent <string> Required. The parent resource name, which should be a scan resource name in the format 'projects/{projectId}/scanConfigs/{scanConfigId}'.

optional:
pageSize <integer> The maximum number of ScanRuns to return, can be limited by server. If not specified or not positive, the implementation will select a reasonable value."
  ([parent] (projects-scanConfigs-scanRuns-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://websecurityscanner.googleapis.com/v1/{+parent}/scanRuns",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-scanConfigs-scanRuns-get
  "Gets a ScanRun.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

name <string> Required. The resource name of the ScanRun to be returned. The name follows the format of 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-scanConfigs-scanRuns-findings-list
  "List Findings under a given ScanRun.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

parent <string> Required. The parent resource name, which should be a scan run resource name in the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.

optional:
pageSize <integer> The maximum number of Findings to return, can be limited by server. If not specified or not positive, the implementation will select a reasonable value.
filter <string> The filter expression. The expression must be in the format: . Supported field: 'finding_type'. Supported operator: '='."
  ([parent] (projects-scanConfigs-scanRuns-findings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://websecurityscanner.googleapis.com/v1/{+parent}/findings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-scanConfigs-scanRuns-findings-get
  "Gets a Finding.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

name <string> Required. The resource name of the Finding to be returned. The name follows the format of 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}/findings/{findingId}'."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-scanConfigs-scanRuns-findingTypeStats-list
  "List all FindingTypeStats under a given ScanRun.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

parent <string> Required. The parent resource name, which should be a scan run resource name in the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://websecurityscanner.googleapis.com/v1/{+parent}/findingTypeStats",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-scanConfigs-scanRuns-crawledUrls-list
  "List CrawledUrls under a given ScanRun.
https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview

parent <string> Required. The parent resource name, which should be a scan run resource name in the format 'projects/{projectId}/scanConfigs/{scanConfigId}/scanRuns/{scanRunId}'.

optional:
pageSize <integer> The maximum number of CrawledUrls to return, can be limited by server. If not specified or not positive, the implementation will select a reasonable value."
  ([parent]
    (projects-scanConfigs-scanRuns-crawledUrls-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://websecurityscanner.googleapis.com/v1/{+parent}/crawledUrls",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

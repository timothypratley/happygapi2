(ns happygapi2.resourcesettings
  "Resource Settings API
The Resource Settings API allows users to control and modify the behavior of their GCP resources (e.g., VM, firewall, Project, etc.) across the Cloud Resource Hierarchy.
See: https://cloud.google.com/resource-manager/docs/resource-settings/overview"
  (:require [happy.oauth2.client :as client]))

(defn folders-settings-patch
  "Updates a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if the setting is flagged as read only. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the setting value. On success, the response will contain only `name`, `local_value` and `etag`. The `metadata` and `effective_value` cannot be updated through this API. Note: the supplied setting will perform a full overwrite of the `local_value` field.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

name <string> The resource name of the setting. Must be in one of the following forms: * `projects/{project_number}/settings/{setting_name}` * `folders/{folder_id}/settings/{setting_name}` * `organizations/{organization_id}/settings/{setting_name}` For example, \"/projects/123/settings/gcp-enableMyFeature\"
GoogleCloudResourcesettingsV1Setting:
{:metadata
 {:dataType
  [DATA_TYPE_UNSPECIFIED
   BOOLEAN
   STRING
   STRING_SET
   ENUM_VALUE
   DURATION_VALUE
   STRING_MAP],
  :readOnly boolean,
  :defaultValue
  {:booleanValue boolean,
   :durationValue string,
   :stringValue string,
   :enumValue {:value string},
   :stringMapValue {:mappings object},
   :stringSetValue {:values [string]}},
  :description string,
  :displayName string},
 :name string,
 :etag string,
 :localValue
 {:booleanValue boolean,
  :durationValue string,
  :stringValue string,
  :enumValue {:value string},
  :stringMapValue {:mappings object},
  :stringSetValue {:values [string]}},
 :effectiveValue
 {:booleanValue boolean,
  :durationValue string,
  :stringValue string,
  :enumValue {:value string},
  :stringMapValue {:mappings object},
  :stringSetValue {:values [string]}}}"
  [name GoogleCloudResourcesettingsV1Setting]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://resourcesettings.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudResourcesettingsV1Setting}))

(defn folders-settings-get
  "Returns a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

name <string> Required. The name of the setting to get. See Setting for naming requirements.

optional:
view <string> The SettingView for this request."
  ([name] (folders-settings-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://resourcesettings.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-settings-list
  "Lists all the settings that are available on the Cloud resource `parent`.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

parent <string> Required. The project, folder, or organization that is the parent resource for this setting. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
view <string> The SettingView for this request.
pageSize <integer> Unused. The size of the page to be returned."
  ([parent] (folders-settings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://resourcesettings.googleapis.com/v1/{+parent}/settings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-settings-list
  "Lists all the settings that are available on the Cloud resource `parent`.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

parent <string> Required. The project, folder, or organization that is the parent resource for this setting. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
pageSize <integer> Unused. The size of the page to be returned.
view <string> The SettingView for this request."
  ([parent] (organizations-settings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://resourcesettings.googleapis.com/v1/{+parent}/settings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-settings-get
  "Returns a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

name <string> Required. The name of the setting to get. See Setting for naming requirements.

optional:
view <string> The SettingView for this request."
  ([name] (organizations-settings-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://resourcesettings.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-settings-patch
  "Updates a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if the setting is flagged as read only. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the setting value. On success, the response will contain only `name`, `local_value` and `etag`. The `metadata` and `effective_value` cannot be updated through this API. Note: the supplied setting will perform a full overwrite of the `local_value` field.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

name <string> The resource name of the setting. Must be in one of the following forms: * `projects/{project_number}/settings/{setting_name}` * `folders/{folder_id}/settings/{setting_name}` * `organizations/{organization_id}/settings/{setting_name}` For example, \"/projects/123/settings/gcp-enableMyFeature\"
GoogleCloudResourcesettingsV1Setting:
{:metadata
 {:dataType
  [DATA_TYPE_UNSPECIFIED
   BOOLEAN
   STRING
   STRING_SET
   ENUM_VALUE
   DURATION_VALUE
   STRING_MAP],
  :readOnly boolean,
  :defaultValue
  {:booleanValue boolean,
   :durationValue string,
   :stringValue string,
   :enumValue {:value string},
   :stringMapValue {:mappings object},
   :stringSetValue {:values [string]}},
  :description string,
  :displayName string},
 :name string,
 :etag string,
 :localValue
 {:booleanValue boolean,
  :durationValue string,
  :stringValue string,
  :enumValue {:value string},
  :stringMapValue {:mappings object},
  :stringSetValue {:values [string]}},
 :effectiveValue
 {:booleanValue boolean,
  :durationValue string,
  :stringValue string,
  :enumValue {:value string},
  :stringMapValue {:mappings object},
  :stringSetValue {:values [string]}}}"
  [name GoogleCloudResourcesettingsV1Setting]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://resourcesettings.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudResourcesettingsV1Setting}))

(defn projects-settings-patch
  "Updates a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if the setting is flagged as read only. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the setting value. On success, the response will contain only `name`, `local_value` and `etag`. The `metadata` and `effective_value` cannot be updated through this API. Note: the supplied setting will perform a full overwrite of the `local_value` field.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

name <string> The resource name of the setting. Must be in one of the following forms: * `projects/{project_number}/settings/{setting_name}` * `folders/{folder_id}/settings/{setting_name}` * `organizations/{organization_id}/settings/{setting_name}` For example, \"/projects/123/settings/gcp-enableMyFeature\"
GoogleCloudResourcesettingsV1Setting:
{:metadata
 {:dataType
  [DATA_TYPE_UNSPECIFIED
   BOOLEAN
   STRING
   STRING_SET
   ENUM_VALUE
   DURATION_VALUE
   STRING_MAP],
  :readOnly boolean,
  :defaultValue
  {:booleanValue boolean,
   :durationValue string,
   :stringValue string,
   :enumValue {:value string},
   :stringMapValue {:mappings object},
   :stringSetValue {:values [string]}},
  :description string,
  :displayName string},
 :name string,
 :etag string,
 :localValue
 {:booleanValue boolean,
  :durationValue string,
  :stringValue string,
  :enumValue {:value string},
  :stringMapValue {:mappings object},
  :stringSetValue {:values [string]}},
 :effectiveValue
 {:booleanValue boolean,
  :durationValue string,
  :stringValue string,
  :enumValue {:value string},
  :stringMapValue {:mappings object},
  :stringSetValue {:values [string]}}}"
  [name GoogleCloudResourcesettingsV1Setting]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://resourcesettings.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudResourcesettingsV1Setting}))

(defn projects-settings-get
  "Returns a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

name <string> Required. The name of the setting to get. See Setting for naming requirements.

optional:
view <string> The SettingView for this request."
  ([name] (projects-settings-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://resourcesettings.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-settings-list
  "Lists all the settings that are available on the Cloud resource `parent`.
https://cloud.google.com/resource-manager/docs/resource-settings/overview

parent <string> Required. The project, folder, or organization that is the parent resource for this setting. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
view <string> The SettingView for this request.
pageSize <integer> Unused. The size of the page to be returned."
  ([parent] (projects-settings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://resourcesettings.googleapis.com/v1/{+parent}/settings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

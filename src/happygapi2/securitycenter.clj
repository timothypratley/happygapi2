(ns happygapi2.securitycenter
  "Security Command Center API
Security Command Center API provides access to temporal views of assets and findings within an organization.
See: https://cloud.google.com/security/products/security-command-center"
  (:require [happy.oauth2.client :as client]))

(defn folders-findings-bulkMute
  "Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either an organization, folder or project. The findings matched by the filter will be muted after the LRO is done.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/findings/bulkMute

parent <string> Required. The parent, at which bulk action needs to be applied. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".
BulkMuteFindingsRequest:
{:filter string, :muteAnnotation string}"
  [parent BulkMuteFindingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/findings:bulkMute",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BulkMuteFindingsRequest}))

(defn folders-eventThreatDetectionSettings-validateCustomModule
  "Validates the given Event Threat Detection custom module.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/validateCustomModule

parent <string> Required. Resource name of the parent to validate the Custom Module under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".
ValidateEventThreatDetectionCustomModuleRequest:
{:rawText string, :type string}"
  [parent ValidateEventThreatDetectionCustomModuleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}:validateCustomModule",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ValidateEventThreatDetectionCustomModuleRequest}))

(defn folders-eventThreatDetectionSettings-customModules-create
  "Creates a resident Event Threat Detection custom module at the scope of the given Resource Manager parent, and also creates inherited custom modules for all descendants of the given parent. These modules are enabled by default.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/customModules/create

parent <string> Required. The new custom module's parent. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".
EventThreatDetectionCustomModule:
{:description string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :lastEditor string,
 :config object,
 :displayName string,
 :ancestorModule string,
 :name string,
 :type string,
 :updateTime string}"
  [parent EventThreatDetectionCustomModule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EventThreatDetectionCustomModule}))

(defn folders-eventThreatDetectionSettings-customModules-delete
  "Deletes the specified Event Threat Detection custom module and all of its descendants in the Resource Manager hierarchy. This method is only supported for resident custom modules.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/customModules/delete

name <string> Required. Name of the custom module to delete. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\"."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-eventThreatDetectionSettings-customModules-get
  "Gets an Event Threat Detection custom module.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/customModules/get

name <string> Required. Name of the custom module to get. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-eventThreatDetectionSettings-customModules-listDescendant
  "Lists all resident Event Threat Detection custom modules under the given Resource Manager parent and its descendants.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/customModules/listDescendant

parent <string> Required. Name of the parent to list custom modules under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (folders-eventThreatDetectionSettings-customModules-listDescendant
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules:listDescendant",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-eventThreatDetectionSettings-customModules-list
  "Lists all Event Threat Detection custom modules for the given Resource Manager parent. This includes resident modules defined at the scope of the parent along with modules inherited from ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/customModules/list

parent <string> Required. Name of the parent to list custom modules under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (folders-eventThreatDetectionSettings-customModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-eventThreatDetectionSettings-customModules-patch
  "Updates the Event Threat Detection custom module with the given name based on the given update mask. Updating the enablement state is supported for both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name or configuration of a module is supported for resident modules only. The type of a module cannot be changed.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/customModules/patch

name <string> Immutable. The resource name of the Event Threat Detection custom module. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\".
EventThreatDetectionCustomModule:
{:description string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :lastEditor string,
 :config object,
 :displayName string,
 :ancestorModule string,
 :name string,
 :type string,
 :updateTime string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name EventThreatDetectionCustomModule]
    (folders-eventThreatDetectionSettings-customModules-patch
      name
      EventThreatDetectionCustomModule
      nil))
  ([name EventThreatDetectionCustomModule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body EventThreatDetectionCustomModule})))

(defn folders-eventThreatDetectionSettings-effectiveCustomModules-get
  "Gets an effective Event Threat Detection custom module at the given level.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/effectiveCustomModules/get

name <string> Required. The resource name of the effective Event Threat Detection custom module. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/effectiveCustomModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/effectiveCustomModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/effectiveCustomModules/{module}\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-eventThreatDetectionSettings-effectiveCustomModules-list
  "Lists all effective Event Threat Detection custom modules for the given parent. This includes resident modules defined at the scope of the parent along with modules inherited from its ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/eventThreatDetectionSettings/effectiveCustomModules/list

parent <string> Required. Name of the parent to list custom modules for. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (folders-eventThreatDetectionSettings-effectiveCustomModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/effectiveCustomModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-assets-group
  "Filters an organization's assets and groups them by their specified properties.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/assets/group

parent <string> Required. The name of the parent to group the assets by. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GroupAssetsRequest:
{:filter string,
 :groupBy string,
 :compareDuration string,
 :readTime string,
 :pageToken string,
 :pageSize integer}"
  [parent GroupAssetsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/assets:group",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GroupAssetsRequest}))

(defn folders-assets-list
  "Lists an organization's assets.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/assets/list

parent <string> Required. The name of the parent resource that contains the assets. The value that you can specify on parent depends on the method in which you specify parent. You can specify one of the following values: \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
filter <string> Expression that defines the filter to apply across assets. The expression is a list of zero or more restrictions combined via logical operators `AND` and `OR`. Parentheses are supported, and `OR` has higher precedence than `AND`. Restrictions have the form ` ` and may have a `-` character in front of them to indicate negation. The fields map to those defined in the Asset resource. Examples include: * name * security_center_properties.resource_name * resource_properties.a_property * security_marks.marks.marka The supported operators are: * `=` for all value types. * `>`, `<`, `>=`, `<=` for integer values. * `:`, meaning substring matching, for strings. The supported value types are: * string literals in quotes. * integer literals without quotes. * boolean literals `true` and `false` without quotes. The following are the allowed field and operator combinations: * name: `=` * update_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `update_time = \"2019-06-10T16:07:18-07:00\"` `update_time = 1560208038000` * create_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `create_time = \"2019-06-10T16:07:18-07:00\"` `create_time = 1560208038000` * iam_policy.policy_blob: `=`, `:` * resource_properties: `=`, `:`, `>`, `<`, `>=`, `<=` * security_marks.marks: `=`, `:` * security_center_properties.resource_name: `=`, `:` * security_center_properties.resource_display_name: `=`, `:` * security_center_properties.resource_type: `=`, `:` * security_center_properties.resource_parent: `=`, `:` * security_center_properties.resource_parent_display_name: `=`, `:` * security_center_properties.resource_project: `=`, `:` * security_center_properties.resource_project_display_name: `=`, `:` * security_center_properties.resource_owners: `=`, `:` For example, `resource_properties.size = 100` is a valid filter string. Use a partial match on the empty string to filter based on a property existing: `resource_properties.my_property : \"\"` Use a negated partial match on the empty string to filter based on a property not existing: `-resource_properties.my_property : \"\"`
orderBy <string> Expression that defines what fields and order to use for sorting. The string value should follow SQL syntax: comma separated list of fields. For example: \"name,resource_properties.a_property\". The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be appended to the field name. For example: \"name desc,resource_properties.a_property\". Redundant space characters in the syntax are insignificant. \"name desc,resource_properties.a_property\" and \" name desc , resource_properties.a_property \" are equivalent. The following fields are supported: name update_time resource_properties security_marks.marks security_center_properties.resource_name security_center_properties.resource_display_name security_center_properties.resource_parent security_center_properties.resource_parent_display_name security_center_properties.resource_project security_center_properties.resource_project_display_name security_center_properties.resource_type
readTime <string> Time used as a reference point when filtering assets. The filter is limited to assets existing at the supplied time and their values are those at that specific time. Absence of this field will default to the API's version of NOW.
compareDuration <string> When compare_duration is set, the ListAssetsResult's \"state_change\" attribute is updated to indicate whether the asset was added, removed, or remained present during the compare_duration period of time that precedes the read_time. This is the time between (read_time - compare_duration) and read_time. The state_change value is derived based on the presence of the asset at the two points in time. Intermediate state changes between the two times don't affect the result. For example, the results aren't affected if the asset is removed and re-created again. Possible \"state_change\" values when compare_duration is specified: * \"ADDED\": indicates that the asset was not present at the start of compare_duration, but present at read_time. * \"REMOVED\": indicates that the asset was present at the start of compare_duration, but not present at read_time. * \"ACTIVE\": indicates that the asset was present at both the start and the end of the time period defined by compare_duration and read_time. If compare_duration is not specified, then the only possible state_change is \"UNUSED\", which will be the state_change set for all assets present at read_time.
fieldMask <string> A field mask to specify the ListAssetsResult fields to be listed in the response. An empty field mask will list all fields.
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (folders-assets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/assets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-assets-updateSecurityMarks
  "Updates security marks.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/assets/updateSecurityMarks

name <string> The relative resource name of the SecurityMarks. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Examples: \"organizations/{organization_id}/assets/{asset_id}/securityMarks\" \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}/securityMarks\".
SecurityMarks:
{:name string, :marks object, :canonicalName string}

optional:
updateMask <string> The FieldMask to use when updating the security marks resource. The field mask must not contain duplicate fields. If empty or set to \"marks\", all marks will be replaced. Individual marks can be updated using \"marks.\".
startTime <string> The time at which the updated SecurityMarks take effect. If not set uses current server time. Updates will be applied to the SecurityMarks that are active immediately preceding this time. Must be earlier or equal to the server time."
  ([name SecurityMarks]
    (folders-assets-updateSecurityMarks name SecurityMarks nil))
  ([name SecurityMarks optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityMarks})))

(defn folders-sources-list
  "Lists all sources belonging to an organization.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/list

parent <string> Required. Resource name of the parent of sources to list. Its format should be \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (folders-sources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/sources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-sources-findings-group
  "Filters an organization or source's findings and groups them by their specified properties. To group across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings, /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/findings/group

parent <string> Required. Name of the source to groupBy. Its format is \"organizations/[organization_id]/sources/[source_id]\", folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]. To groupBy across all sources provide a source_id of `-`. For example: organizations/{organization_id}/sources/-, folders/{folder_id}/sources/-, or projects/{project_id}/sources/-
GroupFindingsRequest:
{:filter string,
 :groupBy string,
 :readTime string,
 :compareDuration string,
 :pageToken string,
 :pageSize integer}"
  [parent GroupFindingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/findings:group",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GroupFindingsRequest}))

(defn folders-sources-findings-list
  "Lists an organization or source's findings. To list across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/findings/list

parent <string> Required. Name of the source the findings belong to. Its format is \"organizations/[organization_id]/sources/[source_id], folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]\". To list across all sources provide a source_id of `-`. For example: organizations/{organization_id}/sources/-, folders/{folder_id}/sources/- or projects/{projects_id}/sources/-

optional:
filter <string> Expression that defines the filter to apply across findings. The expression is a list of one or more restrictions combined via logical operators `AND` and `OR`. Parentheses are supported, and `OR` has higher precedence than `AND`. Restrictions have the form ` ` and may have a `-` character in front of them to indicate negation. Examples include: * name * source_properties.a_property * security_marks.marks.marka The supported operators are: * `=` for all value types. * `>`, `<`, `>=`, `<=` for integer values. * `:`, meaning substring matching, for strings. The supported value types are: * string literals in quotes. * integer literals without quotes. * boolean literals `true` and `false` without quotes. The following field and operator combinations are supported: * name: `=` * parent: `=`, `:` * resource_name: `=`, `:` * state: `=`, `:` * category: `=`, `:` * external_uri: `=`, `:` * event_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `event_time = \"2019-06-10T16:07:18-07:00\"` `event_time = 1560208038000` * severity: `=`, `:` * workflow_state: `=`, `:` * security_marks.marks: `=`, `:` * source_properties: `=`, `:`, `>`, `<`, `>=`, `<=` For example, `source_properties.size = 100` is a valid filter string. Use a partial match on the empty string to filter based on a property existing: `source_properties.my_property : \"\"` Use a negated partial match on the empty string to filter based on a property not existing: `-source_properties.my_property : \"\"` * resource: * resource.name: `=`, `:` * resource.parent_name: `=`, `:` * resource.parent_display_name: `=`, `:` * resource.project_name: `=`, `:` * resource.project_display_name: `=`, `:` * resource.type: `=`, `:` * resource.folders.resource_folder: `=`, `:` * resource.display_name: `=`, `:`
orderBy <string> Expression that defines what fields and order to use for sorting. The string value should follow SQL syntax: comma separated list of fields. For example: \"name,resource_properties.a_property\". The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be appended to the field name. For example: \"name desc,source_properties.a_property\". Redundant space characters in the syntax are insignificant. \"name desc,source_properties.a_property\" and \" name desc , source_properties.a_property \" are equivalent. The following fields are supported: name parent state category resource_name event_time source_properties security_marks.marks
readTime <string> Time used as a reference point when filtering findings. The filter is limited to findings existing at the supplied time and their values are those at that specific time. Absence of this field will default to the API's version of NOW.
compareDuration <string> When compare_duration is set, the ListFindingsResult's \"state_change\" attribute is updated to indicate whether the finding had its state changed, the finding's state remained unchanged, or if the finding was added in any state during the compare_duration period of time that precedes the read_time. This is the time between (read_time - compare_duration) and read_time. The state_change value is derived based on the presence and state of the finding at the two points in time. Intermediate state changes between the two times don't affect the result. For example, the results aren't affected if the finding is made inactive and then active again. Possible \"state_change\" values when compare_duration is specified: * \"CHANGED\": indicates that the finding was present and matched the given filter at the start of compare_duration, but changed its state at read_time. * \"UNCHANGED\": indicates that the finding was present and matched the given filter at the start of compare_duration and did not change state at read_time. * \"ADDED\": indicates that the finding did not match the given filter or was not present at the start of compare_duration, but was present at read_time. * \"REMOVED\": indicates that the finding was present and matched the filter at the start of compare_duration, but did not match the filter at read_time. If compare_duration is not specified, then the only possible state_change is \"UNUSED\", which will be the state_change set for all findings present at read_time.
fieldMask <string> A field mask to specify the Finding fields to be listed in the response. An empty field mask will list all fields.
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (folders-sources-findings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/findings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-sources-findings-setState
  "Updates the state of a finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/findings/setState

name <string> Required. The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
SetFindingStateRequest:
{:state [STATE_UNSPECIFIED ACTIVE INACTIVE], :startTime string}"
  [name SetFindingStateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+name}:setState",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetFindingStateRequest}))

(defn folders-sources-findings-setMute
  "Updates the mute state of a finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/findings/setMute

name <string> Required. The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
SetMuteRequest:
{:mute [MUTE_UNSPECIFIED MUTED UNMUTED UNDEFINED]}"
  [name SetMuteRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+name}:setMute",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMuteRequest}))

(defn folders-sources-findings-patch
  "Creates or updates a finding. The corresponding source must exist for a finding creation to succeed.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/findings/patch

name <string> The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
Finding:
{:description string,
 :category string,
 :externalSystems object,
 :exfiltration
 {:sources [{:name string, :components [string]}],
  :targets [{:name string, :components [string]}],
  :totalExfiltratedBytes string},
 :kernelRootkit
 {:unexpectedFtraceHandler boolean,
  :unexpectedReadOnlyDataModification boolean,
  :name string,
  :unexpectedKernelCodePages boolean,
  :unexpectedCodeModification boolean,
  :unexpectedProcessesInRunqueue boolean,
  :unexpectedSystemCallHandler boolean,
  :unexpectedInterruptHandler boolean,
  :unexpectedKprobeHandler boolean},
 :compliances [{:standard string, :version string, :ids [string]}],
 :kubernetes
 {:pods
  [{:ns string,
    :name string,
    :labels [{:name string, :value string}],
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}],
  :nodes [{:name string}],
  :nodePools [{:name string, :nodes [{:name string}]}],
  :roles
  [{:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
    :ns string,
    :name string}],
  :bindings
  [{:ns string,
    :name string,
    :role
    {:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
     :ns string,
     :name string},
    :subjects
    [{:kind [AUTH_TYPE_UNSPECIFIED USER SERVICEACCOUNT GROUP],
      :ns string,
      :name string}]}],
  :accessReviews
  [{:group string,
    :ns string,
    :name string,
    :resource string,
    :subresource string,
    :verb string,
    :version string}],
  :objects
  [{:group string,
    :kind string,
    :ns string,
    :name string,
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}]},
 :parent string,
 :cloudArmor
 {:securityPolicy {:name string, :type string, :preview boolean},
  :requests
  {:ratio number,
   :shortTermAllowed integer,
   :longTermAllowed integer,
   :longTermDenied integer},
  :adaptiveProtection {:confidence number},
  :attack
  {:volumePps integer, :volumeBps integer, :classification string},
  :threatVector string,
  :duration string},
 :contacts object,
 :application {:baseUri string, :fullUri string},
 :backupDisasterRecovery
 {:applications [string],
  :appliance string,
  :policies [string],
  :backupTemplate string,
  :backupCreateTime string,
  :storagePool string,
  :policyOptions [string],
  :host string,
  :backupType string,
  :profile string},
 :name string,
 :attackExposure
 {:score number,
  :latestCalculationTime string,
  :attackExposureResult string,
  :state [STATE_UNSPECIFIED CALCULATED NOT_CALCULATED],
  :exposedHighValueResourcesCount integer,
  :exposedMediumValueResourcesCount integer,
  :exposedLowValueResourcesCount integer},
 :toxicCombination
 {:attackExposureScore number, :relatedFindings [string]},
 :createTime string,
 :vulnerability
 {:cve
  {:id string,
   :references [{:source string, :uri string}],
   :cvssv3
   {:privilegesRequired
    [PRIVILEGES_REQUIRED_UNSPECIFIED
     PRIVILEGES_REQUIRED_NONE
     PRIVILEGES_REQUIRED_LOW
     PRIVILEGES_REQUIRED_HIGH],
    :availabilityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :baseScore number,
    :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
    :userInteraction
    [USER_INTERACTION_UNSPECIFIED
     USER_INTERACTION_NONE
     USER_INTERACTION_REQUIRED],
    :attackVector
    [ATTACK_VECTOR_UNSPECIFIED
     ATTACK_VECTOR_NETWORK
     ATTACK_VECTOR_ADJACENT
     ATTACK_VECTOR_LOCAL
     ATTACK_VECTOR_PHYSICAL],
    :attackComplexity
    [ATTACK_COMPLEXITY_UNSPECIFIED
     ATTACK_COMPLEXITY_LOW
     ATTACK_COMPLEXITY_HIGH],
    :confidentialityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :integrityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE]},
   :upstreamFixAvailable boolean,
   :impact [RISK_RATING_UNSPECIFIED LOW MEDIUM HIGH CRITICAL],
   :exploitationActivity
   [EXPLOITATION_ACTIVITY_UNSPECIFIED
    WIDE
    CONFIRMED
    AVAILABLE
    ANTICIPATED
    NO_KNOWN],
   :observedInTheWild boolean,
   :zeroDay boolean},
  :offendingPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :fixedPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :securityBulletin
  {:bulletinId string,
   :submissionTime string,
   :suggestedUpgradeVersion string}},
 :state [STATE_UNSPECIFIED ACTIVE INACTIVE],
 :containers
 [{:name string,
   :uri string,
   :imageId string,
   :labels [{:name string, :value string}],
   :createTime string}],
 :orgPolicies [{:name string}],
 :canonicalName string,
 :moduleName string,
 :nextSteps string,
 :externalUri string,
 :cloudDlpDataProfile
 {:dataProfile string,
  :parentType [PARENT_TYPE_UNSPECIFIED ORGANIZATION PROJECT]},
 :resourceName string,
 :securityMarks {:name string, :marks object, :canonicalName string},
 :sourceProperties object,
 :iamBindings
 [{:action [ACTION_UNSPECIFIED ADD REMOVE],
   :role string,
   :member string}],
 :muteUpdateTime string,
 :muteInitiator string,
 :cloudDlpInspection
 {:inspectJob string,
  :infoType string,
  :infoTypeCount string,
  :fullScan boolean},
 :notebook
 {:name string,
  :service string,
  :lastAuthor string,
  :notebookUpdateTime string},
 :parentDisplayName string,
 :indicator
 {:ipAddresses [string],
  :domains [string],
  :signatures
  [{:memoryHashSignature
    {:binaryFamily string,
     :detections [{:binary string, :percentPagesMatched number}]},
    :yaraRuleSignature {:yaraRule string},
    :signatureType
    [SIGNATURE_TYPE_UNSPECIFIED
     SIGNATURE_TYPE_PROCESS
     SIGNATURE_TYPE_FILE]}],
  :uris [string]},
 :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
 :files
 [{:path string,
   :size string,
   :sha256 string,
   :hashedSize string,
   :partiallyHashed boolean,
   :contents string,
   :diskPath {:partitionUuid string, :relativePath string}}],
 :mitreAttack
 {:primaryTactic
  [TACTIC_UNSPECIFIED
   RECONNAISSANCE
   RESOURCE_DEVELOPMENT
   INITIAL_ACCESS
   EXECUTION
   PERSISTENCE
   PRIVILEGE_ESCALATION
   DEFENSE_EVASION
   CREDENTIAL_ACCESS
   DISCOVERY
   LATERAL_MOVEMENT
   COLLECTION
   COMMAND_AND_CONTROL
   EXFILTRATION
   IMPACT],
  :primaryTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :additionalTactics
  [[TACTIC_UNSPECIFIED
    RECONNAISSANCE
    RESOURCE_DEVELOPMENT
    INITIAL_ACCESS
    EXECUTION
    PERSISTENCE
    PRIVILEGE_ESCALATION
    DEFENSE_EVASION
    CREDENTIAL_ACCESS
    DISCOVERY
    LATERAL_MOVEMENT
    COLLECTION
    COMMAND_AND_CONTROL
    EXFILTRATION
    IMPACT]],
  :additionalTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :version string},
 :loadBalancers [{:name string}],
 :database
 {:name string,
  :displayName string,
  :userName string,
  :query string,
  :grantees [string],
  :version string},
 :access
 {:serviceAccountDelegationInfo
  [{:principalEmail string, :principalSubject string}],
  :callerIp string,
  :userAgentFamily string,
  :userAgent string,
  :serviceAccountKeyName string,
  :principalSubject string,
  :principalEmail string,
  :serviceName string,
  :methodName string,
  :callerIpGeo {:regionCode string},
  :userName string},
 :eventTime string,
 :connections
 [{:destinationIp string,
   :destinationPort integer,
   :sourceIp string,
   :sourcePort integer,
   :protocol [PROTOCOL_UNSPECIFIED ICMP TCP UDP GRE ESP]}],
 :securityPosture
 {:name string,
  :revisionId string,
  :postureDeploymentResource string,
  :postureDeployment string,
  :changedPolicy string,
  :policySet string,
  :policy string,
  :policyDriftDetails
  [{:field string, :expectedValue string, :detectedValue string}]},
 :groupMemberships
 [{:groupType [GROUP_TYPE_UNSPECIFIED GROUP_TYPE_TOXIC_COMBINATION],
   :groupId string}],
 :processes
 [{:args [string],
   :binary
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :argumentsTruncated boolean,
   :libraries
   [{:path string,
     :size string,
     :sha256 string,
     :hashedSize string,
     :partiallyHashed boolean,
     :contents string,
     :diskPath {:partitionUuid string, :relativePath string}}],
   :script
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :name string,
   :envVariablesTruncated boolean,
   :parentPid string,
   :envVariables [{:name string, :val string}],
   :pid string}],
 :findingClass
 [FINDING_CLASS_UNSPECIFIED
  THREAT
  VULNERABILITY
  MISCONFIGURATION
  OBSERVATION
  SCC_ERROR
  POSTURE_VIOLATION
  TOXIC_COMBINATION],
 :logEntries
 [{:cloudLoggingEntry
   {:insertId string,
    :logId string,
    :resourceContainer string,
    :timestamp string}}],
 :mute [MUTE_UNSPECIFIED MUTED UNMUTED UNDEFINED]}

optional:
updateMask <string> The FieldMask to use when updating the finding resource. This field should not be specified when creating a finding. When updating a finding, an empty mask is treated as updating all mutable fields and replacing source_properties. Individual source_properties can be added/updated by using \"source_properties.\" in the field mask."
  ([name Finding] (folders-sources-findings-patch name Finding nil))
  ([name Finding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Finding})))

(defn folders-sources-findings-updateSecurityMarks
  "Updates security marks.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/findings/updateSecurityMarks

name <string> The relative resource name of the SecurityMarks. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Examples: \"organizations/{organization_id}/assets/{asset_id}/securityMarks\" \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}/securityMarks\".
SecurityMarks:
{:name string, :marks object, :canonicalName string}

optional:
updateMask <string> The FieldMask to use when updating the security marks resource. The field mask must not contain duplicate fields. If empty or set to \"marks\", all marks will be replaced. Individual marks can be updated using \"marks.\".
startTime <string> The time at which the updated SecurityMarks take effect. If not set uses current server time. Updates will be applied to the SecurityMarks that are active immediately preceding this time. Must be earlier or equal to the server time."
  ([name SecurityMarks]
    (folders-sources-findings-updateSecurityMarks
      name
      SecurityMarks
      nil))
  ([name SecurityMarks optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityMarks})))

(defn folders-sources-findings-externalSystems-patch
  "Updates external system. This is for a given finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/sources/findings/externalSystems/patch

name <string> Full resource name of the external system, for example: \"organizations/1234/sources/5678/findings/123456/externalSystems/jira\", \"folders/1234/sources/5678/findings/123456/externalSystems/jira\", \"projects/1234/sources/5678/findings/123456/externalSystems/jira\"
GoogleCloudSecuritycenterV1ExternalSystem:
{:assignees [string],
 :externalSystemUpdateTime string,
 :externalUid string,
 :name string,
 :ticketInfo
 {:id string,
  :assignee string,
  :description string,
  :uri string,
  :status string,
  :updateTime string},
 :caseCloseTime string,
 :caseCreateTime string,
 :status string,
 :caseSla string,
 :casePriority string,
 :caseUri string}

optional:
updateMask <string> The FieldMask to use when updating the external system resource. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1ExternalSystem]
    (folders-sources-findings-externalSystems-patch
      name
      GoogleCloudSecuritycenterV1ExternalSystem
      nil))
  ([name GoogleCloudSecuritycenterV1ExternalSystem optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1ExternalSystem})))

(defn folders-notificationConfigs-create
  "Creates a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/notificationConfigs/create

parent <string> Required. Resource name of the new notification config's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
NotificationConfig:
{:name string,
 :description string,
 :pubsubTopic string,
 :serviceAccount string,
 :streamingConfig {:filter string}}

optional:
configId <string> Required. Unique identifier provided by the client within the parent scope. It must be between 1 and 128 characters and contain alphanumeric characters, underscores, or hyphens only."
  ([parent NotificationConfig]
    (folders-notificationConfigs-create parent NotificationConfig nil))
  ([parent NotificationConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/notificationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NotificationConfig})))

(defn folders-notificationConfigs-delete
  "Deletes a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/notificationConfigs/delete

name <string> Required. Name of the notification config to delete. Its format is \"organizations/[organization_id]/notificationConfigs/[config_id]\", \"folders/[folder_id]/notificationConfigs/[config_id]\", or \"projects/[project_id]/notificationConfigs/[config_id]\"."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-notificationConfigs-get
  "Gets a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/notificationConfigs/get

name <string> Required. Name of the notification config to get. Its format is \"organizations/[organization_id]/notificationConfigs/[config_id]\", \"folders/[folder_id]/notificationConfigs/[config_id]\", or \"projects/[project_id]/notificationConfigs/[config_id]\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-notificationConfigs-list
  "Lists notification configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/notificationConfigs/list

parent <string> Required. The name of the parent in which to list the notification configurations. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (folders-notificationConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/notificationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-notificationConfigs-patch
  " Updates a notification config. The following update fields are allowed: description, pubsub_topic, streaming_config.filter
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/notificationConfigs/patch

name <string> The relative resource name of this notification config. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Example: \"organizations/{organization_id}/notificationConfigs/notify_public_bucket\", \"folders/{folder_id}/notificationConfigs/notify_public_bucket\", or \"projects/{project_id}/notificationConfigs/notify_public_bucket\".
NotificationConfig:
{:name string,
 :description string,
 :pubsubTopic string,
 :serviceAccount string,
 :streamingConfig {:filter string}}

optional:
updateMask <string> The FieldMask to use when updating the notification config. If empty all mutable fields will be updated."
  ([name NotificationConfig]
    (folders-notificationConfigs-patch name NotificationConfig nil))
  ([name NotificationConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NotificationConfig})))

(defn folders-bigQueryExports-get
  "Gets a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/bigQueryExports/get

name <string> Required. Name of the BigQuery export to retrieve. Its format is organizations/{organization}/bigQueryExports/{export_id}, folders/{folder}/bigQueryExports/{export_id}, or projects/{project}/bigQueryExports/{export_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-bigQueryExports-create
  "Creates a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/bigQueryExports/create

parent <string> Required. The name of the parent resource of the new BigQuery export. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1BigQueryExport:
{:name string,
 :description string,
 :filter string,
 :dataset string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string,
 :principal string}

optional:
bigQueryExportId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1BigQueryExport]
    (folders-bigQueryExports-create
      parent
      GoogleCloudSecuritycenterV1BigQueryExport
      nil))
  ([parent GoogleCloudSecuritycenterV1BigQueryExport optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/bigQueryExports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1BigQueryExport})))

(defn folders-bigQueryExports-delete
  "Deletes an existing BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/bigQueryExports/delete

name <string> Required. The name of the BigQuery export to delete. Its format is organizations/{organization}/bigQueryExports/{export_id}, folders/{folder}/bigQueryExports/{export_id}, or projects/{project}/bigQueryExports/{export_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-bigQueryExports-patch
  "Updates a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/bigQueryExports/patch

name <string> The relative resource name of this export. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name. Example format: \"organizations/{organization_id}/bigQueryExports/{export_id}\" Example format: \"folders/{folder_id}/bigQueryExports/{export_id}\" Example format: \"projects/{project_id}/bigQueryExports/{export_id}\" This field is provided in responses, and is ignored when provided in create requests.
GoogleCloudSecuritycenterV1BigQueryExport:
{:name string,
 :description string,
 :filter string,
 :dataset string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string,
 :principal string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1BigQueryExport]
    (folders-bigQueryExports-patch
      name
      GoogleCloudSecuritycenterV1BigQueryExport
      nil))
  ([name GoogleCloudSecuritycenterV1BigQueryExport optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1BigQueryExport})))

(defn folders-bigQueryExports-list
  "Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports under that level are also returned e.g. if requesting BigQuery exports under a folder, then all BigQuery exports immediately under the folder plus the ones created under the projects within the folder are returned.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/bigQueryExports/list

parent <string> Required. The parent, which owns the collection of BigQuery exports. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (folders-bigQueryExports-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/bigQueryExports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-locations-muteConfigs-create
  "Creates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/locations/muteConfigs/create

parent <string> Required. Resource name of the new mute configs's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
muteConfigId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1MuteConfig]
    (folders-locations-muteConfigs-create
      parent
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([parent GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn folders-locations-muteConfigs-delete
  "Deletes an existing mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/locations/muteConfigs/delete

name <string> Required. Name of the mute config to delete. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-locations-muteConfigs-get
  "Gets a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/locations/muteConfigs/get

name <string> Required. Name of the mute config to retrieve. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-locations-muteConfigs-list
  "Lists mute configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/locations/muteConfigs/list

parent <string> Required. The parent, which owns the collection of mute configs. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (folders-locations-muteConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-locations-muteConfigs-patch
  "Updates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/locations/muteConfigs/patch

name <string> This field will be ignored if provided on config creation. Format \"organizations/{organization}/muteConfigs/{mute_config}\" \"folders/{folder}/muteConfigs/{mute_config}\" \"projects/{project}/muteConfigs/{mute_config}\" \"organizations/{organization}/locations/global/muteConfigs/{mute_config}\" \"folders/{folder}/locations/global/muteConfigs/{mute_config}\" \"projects/{project}/locations/global/muteConfigs/{mute_config}\"
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1MuteConfig]
    (folders-locations-muteConfigs-patch
      name
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([name GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn folders-securityHealthAnalyticsSettings-customModules-create
  "Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent, and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the given parent. These modules are enabled by default.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/customModules/create

parent <string> Required. Resource name of the new custom module's parent. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"
GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule:
{:name string,
 :displayName string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :updateTime string,
 :lastEditor string,
 :ancestorModule string,
 :customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string}}"
  [parent
   GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule}))

(defn folders-securityHealthAnalyticsSettings-customModules-delete
  "Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM hierarchy. This method is only supported for resident custom modules.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/customModules/delete

name <string> Required. Name of the custom module to delete. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-securityHealthAnalyticsSettings-customModules-get
  "Retrieves a SecurityHealthAnalyticsCustomModule.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/customModules/get

name <string> Required. Name of the custom module to get. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-securityHealthAnalyticsSettings-customModules-listDescendant
  "Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent and all of the parent’s CRM descendants.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/customModules/listDescendant

parent <string> Required. Name of parent to list descendant custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (folders-securityHealthAnalyticsSettings-customModules-listDescendant
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules:listDescendant",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-securityHealthAnalyticsSettings-customModules-list
  "Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/customModules/list

parent <string> Required. Name of parent to list custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (folders-securityHealthAnalyticsSettings-customModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-securityHealthAnalyticsSettings-customModules-simulate
  "Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/customModules/simulate

parent <string> Required. The relative resource name of the organization, project, or folder. For more information about relative resource names, see [Relative Resource Name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) Example: `organizations/{organization_id}`
SimulateSecurityHealthAnalyticsCustomModuleRequest:
{:customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string},
 :resource
 {:resourceType string,
  :resourceData object,
  :iamPolicyData
  {:version integer,
   :bindings
   [{:role string,
     :members [string],
     :condition
     {:expression string,
      :title string,
      :description string,
      :location string}}],
   :auditConfigs
   [{:service string,
     :auditLogConfigs
     [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
       :exemptedMembers [string]}]}],
   :etag string}}}"
  [parent SimulateSecurityHealthAnalyticsCustomModuleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules:simulate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SimulateSecurityHealthAnalyticsCustomModuleRequest}))

(defn folders-securityHealthAnalyticsSettings-customModules-patch
  "Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update mask. Updating the enablement state is supported on both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name and custom config of a module is supported on resident modules only.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/customModules/patch

name <string> Immutable. The resource name of the custom module. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\" The id {customModule} is server-generated and is not user settable. It will be a numeric id containing 1-20 digits.
GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule:
{:name string,
 :displayName string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :updateTime string,
 :lastEditor string,
 :ancestorModule string,
 :customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string}}

optional:
updateMask <string> The list of fields to be updated. The only fields that can be updated are `enablement_state` and `custom_config`. If empty or set to the wildcard value `*`, both `enablement_state` and `custom_config` are updated."
  ([name
    GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule]
    (folders-securityHealthAnalyticsSettings-customModules-patch
      name
      GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule
      nil))
  ([name
    GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule
    optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body
       GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule})))

(defn folders-securityHealthAnalyticsSettings-effectiveCustomModules-get
  "Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/effectiveCustomModules/get

name <string> Required. Name of the effective custom module to get. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-securityHealthAnalyticsSettings-effectiveCustomModules-list
  "Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/securityHealthAnalyticsSettings/effectiveCustomModules/list

parent <string> Required. Name of parent to list effective custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (folders-securityHealthAnalyticsSettings-effectiveCustomModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/effectiveCustomModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-muteConfigs-create
  "Creates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/muteConfigs/create

parent <string> Required. Resource name of the new mute configs's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
muteConfigId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1MuteConfig]
    (folders-muteConfigs-create
      parent
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([parent GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn folders-muteConfigs-delete
  "Deletes an existing mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/muteConfigs/delete

name <string> Required. Name of the mute config to delete. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-muteConfigs-get
  "Gets a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/muteConfigs/get

name <string> Required. Name of the mute config to retrieve. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-muteConfigs-list
  "Lists mute configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/muteConfigs/list

parent <string> Required. The parent, which owns the collection of mute configs. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (folders-muteConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-muteConfigs-patch
  "Updates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/folders/muteConfigs/patch

name <string> This field will be ignored if provided on config creation. Format \"organizations/{organization}/muteConfigs/{mute_config}\" \"folders/{folder}/muteConfigs/{mute_config}\" \"projects/{project}/muteConfigs/{mute_config}\" \"organizations/{organization}/locations/global/muteConfigs/{mute_config}\" \"folders/{folder}/locations/global/muteConfigs/{mute_config}\" \"projects/{project}/locations/global/muteConfigs/{mute_config}\"
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1MuteConfig]
    (folders-muteConfigs-patch
      name
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([name GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn projects-findings-bulkMute
  "Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either an organization, folder or project. The findings matched by the filter will be muted after the LRO is done.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/findings/bulkMute

parent <string> Required. The parent, at which bulk action needs to be applied. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".
BulkMuteFindingsRequest:
{:filter string, :muteAnnotation string}"
  [parent BulkMuteFindingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/findings:bulkMute",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BulkMuteFindingsRequest}))

(defn projects-eventThreatDetectionSettings-validateCustomModule
  "Validates the given Event Threat Detection custom module.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/validateCustomModule

parent <string> Required. Resource name of the parent to validate the Custom Module under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".
ValidateEventThreatDetectionCustomModuleRequest:
{:rawText string, :type string}"
  [parent ValidateEventThreatDetectionCustomModuleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}:validateCustomModule",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ValidateEventThreatDetectionCustomModuleRequest}))

(defn projects-eventThreatDetectionSettings-customModules-create
  "Creates a resident Event Threat Detection custom module at the scope of the given Resource Manager parent, and also creates inherited custom modules for all descendants of the given parent. These modules are enabled by default.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/customModules/create

parent <string> Required. The new custom module's parent. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".
EventThreatDetectionCustomModule:
{:description string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :lastEditor string,
 :config object,
 :displayName string,
 :ancestorModule string,
 :name string,
 :type string,
 :updateTime string}"
  [parent EventThreatDetectionCustomModule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EventThreatDetectionCustomModule}))

(defn projects-eventThreatDetectionSettings-customModules-delete
  "Deletes the specified Event Threat Detection custom module and all of its descendants in the Resource Manager hierarchy. This method is only supported for resident custom modules.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/customModules/delete

name <string> Required. Name of the custom module to delete. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\"."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-eventThreatDetectionSettings-customModules-get
  "Gets an Event Threat Detection custom module.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/customModules/get

name <string> Required. Name of the custom module to get. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-eventThreatDetectionSettings-customModules-listDescendant
  "Lists all resident Event Threat Detection custom modules under the given Resource Manager parent and its descendants.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/customModules/listDescendant

parent <string> Required. Name of the parent to list custom modules under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-eventThreatDetectionSettings-customModules-listDescendant
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules:listDescendant",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-eventThreatDetectionSettings-customModules-list
  "Lists all Event Threat Detection custom modules for the given Resource Manager parent. This includes resident modules defined at the scope of the parent along with modules inherited from ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/customModules/list

parent <string> Required. Name of the parent to list custom modules under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-eventThreatDetectionSettings-customModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-eventThreatDetectionSettings-customModules-patch
  "Updates the Event Threat Detection custom module with the given name based on the given update mask. Updating the enablement state is supported for both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name or configuration of a module is supported for resident modules only. The type of a module cannot be changed.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/customModules/patch

name <string> Immutable. The resource name of the Event Threat Detection custom module. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\".
EventThreatDetectionCustomModule:
{:description string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :lastEditor string,
 :config object,
 :displayName string,
 :ancestorModule string,
 :name string,
 :type string,
 :updateTime string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name EventThreatDetectionCustomModule]
    (projects-eventThreatDetectionSettings-customModules-patch
      name
      EventThreatDetectionCustomModule
      nil))
  ([name EventThreatDetectionCustomModule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body EventThreatDetectionCustomModule})))

(defn projects-eventThreatDetectionSettings-effectiveCustomModules-get
  "Gets an effective Event Threat Detection custom module at the given level.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/effectiveCustomModules/get

name <string> Required. The resource name of the effective Event Threat Detection custom module. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/effectiveCustomModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/effectiveCustomModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/effectiveCustomModules/{module}\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-eventThreatDetectionSettings-effectiveCustomModules-list
  "Lists all effective Event Threat Detection custom modules for the given parent. This includes resident modules defined at the scope of the parent along with modules inherited from its ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/eventThreatDetectionSettings/effectiveCustomModules/list

parent <string> Required. Name of the parent to list custom modules for. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-eventThreatDetectionSettings-effectiveCustomModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/effectiveCustomModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-assets-group
  "Filters an organization's assets and groups them by their specified properties.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/assets/group

parent <string> Required. The name of the parent to group the assets by. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GroupAssetsRequest:
{:filter string,
 :groupBy string,
 :compareDuration string,
 :readTime string,
 :pageToken string,
 :pageSize integer}"
  [parent GroupAssetsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/assets:group",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GroupAssetsRequest}))

(defn projects-assets-list
  "Lists an organization's assets.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/assets/list

parent <string> Required. The name of the parent resource that contains the assets. The value that you can specify on parent depends on the method in which you specify parent. You can specify one of the following values: \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
filter <string> Expression that defines the filter to apply across assets. The expression is a list of zero or more restrictions combined via logical operators `AND` and `OR`. Parentheses are supported, and `OR` has higher precedence than `AND`. Restrictions have the form ` ` and may have a `-` character in front of them to indicate negation. The fields map to those defined in the Asset resource. Examples include: * name * security_center_properties.resource_name * resource_properties.a_property * security_marks.marks.marka The supported operators are: * `=` for all value types. * `>`, `<`, `>=`, `<=` for integer values. * `:`, meaning substring matching, for strings. The supported value types are: * string literals in quotes. * integer literals without quotes. * boolean literals `true` and `false` without quotes. The following are the allowed field and operator combinations: * name: `=` * update_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `update_time = \"2019-06-10T16:07:18-07:00\"` `update_time = 1560208038000` * create_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `create_time = \"2019-06-10T16:07:18-07:00\"` `create_time = 1560208038000` * iam_policy.policy_blob: `=`, `:` * resource_properties: `=`, `:`, `>`, `<`, `>=`, `<=` * security_marks.marks: `=`, `:` * security_center_properties.resource_name: `=`, `:` * security_center_properties.resource_display_name: `=`, `:` * security_center_properties.resource_type: `=`, `:` * security_center_properties.resource_parent: `=`, `:` * security_center_properties.resource_parent_display_name: `=`, `:` * security_center_properties.resource_project: `=`, `:` * security_center_properties.resource_project_display_name: `=`, `:` * security_center_properties.resource_owners: `=`, `:` For example, `resource_properties.size = 100` is a valid filter string. Use a partial match on the empty string to filter based on a property existing: `resource_properties.my_property : \"\"` Use a negated partial match on the empty string to filter based on a property not existing: `-resource_properties.my_property : \"\"`
orderBy <string> Expression that defines what fields and order to use for sorting. The string value should follow SQL syntax: comma separated list of fields. For example: \"name,resource_properties.a_property\". The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be appended to the field name. For example: \"name desc,resource_properties.a_property\". Redundant space characters in the syntax are insignificant. \"name desc,resource_properties.a_property\" and \" name desc , resource_properties.a_property \" are equivalent. The following fields are supported: name update_time resource_properties security_marks.marks security_center_properties.resource_name security_center_properties.resource_display_name security_center_properties.resource_parent security_center_properties.resource_parent_display_name security_center_properties.resource_project security_center_properties.resource_project_display_name security_center_properties.resource_type
readTime <string> Time used as a reference point when filtering assets. The filter is limited to assets existing at the supplied time and their values are those at that specific time. Absence of this field will default to the API's version of NOW.
compareDuration <string> When compare_duration is set, the ListAssetsResult's \"state_change\" attribute is updated to indicate whether the asset was added, removed, or remained present during the compare_duration period of time that precedes the read_time. This is the time between (read_time - compare_duration) and read_time. The state_change value is derived based on the presence of the asset at the two points in time. Intermediate state changes between the two times don't affect the result. For example, the results aren't affected if the asset is removed and re-created again. Possible \"state_change\" values when compare_duration is specified: * \"ADDED\": indicates that the asset was not present at the start of compare_duration, but present at read_time. * \"REMOVED\": indicates that the asset was present at the start of compare_duration, but not present at read_time. * \"ACTIVE\": indicates that the asset was present at both the start and the end of the time period defined by compare_duration and read_time. If compare_duration is not specified, then the only possible state_change is \"UNUSED\", which will be the state_change set for all assets present at read_time.
fieldMask <string> A field mask to specify the ListAssetsResult fields to be listed in the response. An empty field mask will list all fields.
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (projects-assets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/assets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-assets-updateSecurityMarks
  "Updates security marks.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/assets/updateSecurityMarks

name <string> The relative resource name of the SecurityMarks. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Examples: \"organizations/{organization_id}/assets/{asset_id}/securityMarks\" \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}/securityMarks\".
SecurityMarks:
{:name string, :marks object, :canonicalName string}

optional:
updateMask <string> The FieldMask to use when updating the security marks resource. The field mask must not contain duplicate fields. If empty or set to \"marks\", all marks will be replaced. Individual marks can be updated using \"marks.\".
startTime <string> The time at which the updated SecurityMarks take effect. If not set uses current server time. Updates will be applied to the SecurityMarks that are active immediately preceding this time. Must be earlier or equal to the server time."
  ([name SecurityMarks]
    (projects-assets-updateSecurityMarks name SecurityMarks nil))
  ([name SecurityMarks optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityMarks})))

(defn projects-sources-list
  "Lists all sources belonging to an organization.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/list

parent <string> Required. Resource name of the parent of sources to list. Its format should be \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (projects-sources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/sources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-sources-findings-group
  "Filters an organization or source's findings and groups them by their specified properties. To group across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings, /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/findings/group

parent <string> Required. Name of the source to groupBy. Its format is \"organizations/[organization_id]/sources/[source_id]\", folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]. To groupBy across all sources provide a source_id of `-`. For example: organizations/{organization_id}/sources/-, folders/{folder_id}/sources/-, or projects/{project_id}/sources/-
GroupFindingsRequest:
{:filter string,
 :groupBy string,
 :readTime string,
 :compareDuration string,
 :pageToken string,
 :pageSize integer}"
  [parent GroupFindingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/findings:group",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GroupFindingsRequest}))

(defn projects-sources-findings-list
  "Lists an organization or source's findings. To list across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/findings/list

parent <string> Required. Name of the source the findings belong to. Its format is \"organizations/[organization_id]/sources/[source_id], folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]\". To list across all sources provide a source_id of `-`. For example: organizations/{organization_id}/sources/-, folders/{folder_id}/sources/- or projects/{projects_id}/sources/-

optional:
filter <string> Expression that defines the filter to apply across findings. The expression is a list of one or more restrictions combined via logical operators `AND` and `OR`. Parentheses are supported, and `OR` has higher precedence than `AND`. Restrictions have the form ` ` and may have a `-` character in front of them to indicate negation. Examples include: * name * source_properties.a_property * security_marks.marks.marka The supported operators are: * `=` for all value types. * `>`, `<`, `>=`, `<=` for integer values. * `:`, meaning substring matching, for strings. The supported value types are: * string literals in quotes. * integer literals without quotes. * boolean literals `true` and `false` without quotes. The following field and operator combinations are supported: * name: `=` * parent: `=`, `:` * resource_name: `=`, `:` * state: `=`, `:` * category: `=`, `:` * external_uri: `=`, `:` * event_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `event_time = \"2019-06-10T16:07:18-07:00\"` `event_time = 1560208038000` * severity: `=`, `:` * workflow_state: `=`, `:` * security_marks.marks: `=`, `:` * source_properties: `=`, `:`, `>`, `<`, `>=`, `<=` For example, `source_properties.size = 100` is a valid filter string. Use a partial match on the empty string to filter based on a property existing: `source_properties.my_property : \"\"` Use a negated partial match on the empty string to filter based on a property not existing: `-source_properties.my_property : \"\"` * resource: * resource.name: `=`, `:` * resource.parent_name: `=`, `:` * resource.parent_display_name: `=`, `:` * resource.project_name: `=`, `:` * resource.project_display_name: `=`, `:` * resource.type: `=`, `:` * resource.folders.resource_folder: `=`, `:` * resource.display_name: `=`, `:`
orderBy <string> Expression that defines what fields and order to use for sorting. The string value should follow SQL syntax: comma separated list of fields. For example: \"name,resource_properties.a_property\". The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be appended to the field name. For example: \"name desc,source_properties.a_property\". Redundant space characters in the syntax are insignificant. \"name desc,source_properties.a_property\" and \" name desc , source_properties.a_property \" are equivalent. The following fields are supported: name parent state category resource_name event_time source_properties security_marks.marks
readTime <string> Time used as a reference point when filtering findings. The filter is limited to findings existing at the supplied time and their values are those at that specific time. Absence of this field will default to the API's version of NOW.
compareDuration <string> When compare_duration is set, the ListFindingsResult's \"state_change\" attribute is updated to indicate whether the finding had its state changed, the finding's state remained unchanged, or if the finding was added in any state during the compare_duration period of time that precedes the read_time. This is the time between (read_time - compare_duration) and read_time. The state_change value is derived based on the presence and state of the finding at the two points in time. Intermediate state changes between the two times don't affect the result. For example, the results aren't affected if the finding is made inactive and then active again. Possible \"state_change\" values when compare_duration is specified: * \"CHANGED\": indicates that the finding was present and matched the given filter at the start of compare_duration, but changed its state at read_time. * \"UNCHANGED\": indicates that the finding was present and matched the given filter at the start of compare_duration and did not change state at read_time. * \"ADDED\": indicates that the finding did not match the given filter or was not present at the start of compare_duration, but was present at read_time. * \"REMOVED\": indicates that the finding was present and matched the filter at the start of compare_duration, but did not match the filter at read_time. If compare_duration is not specified, then the only possible state_change is \"UNUSED\", which will be the state_change set for all findings present at read_time.
fieldMask <string> A field mask to specify the Finding fields to be listed in the response. An empty field mask will list all fields.
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (projects-sources-findings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/findings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-sources-findings-setState
  "Updates the state of a finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/findings/setState

name <string> Required. The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
SetFindingStateRequest:
{:state [STATE_UNSPECIFIED ACTIVE INACTIVE], :startTime string}"
  [name SetFindingStateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+name}:setState",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetFindingStateRequest}))

(defn projects-sources-findings-setMute
  "Updates the mute state of a finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/findings/setMute

name <string> Required. The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
SetMuteRequest:
{:mute [MUTE_UNSPECIFIED MUTED UNMUTED UNDEFINED]}"
  [name SetMuteRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+name}:setMute",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMuteRequest}))

(defn projects-sources-findings-patch
  "Creates or updates a finding. The corresponding source must exist for a finding creation to succeed.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/findings/patch

name <string> The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
Finding:
{:description string,
 :category string,
 :externalSystems object,
 :exfiltration
 {:sources [{:name string, :components [string]}],
  :targets [{:name string, :components [string]}],
  :totalExfiltratedBytes string},
 :kernelRootkit
 {:unexpectedFtraceHandler boolean,
  :unexpectedReadOnlyDataModification boolean,
  :name string,
  :unexpectedKernelCodePages boolean,
  :unexpectedCodeModification boolean,
  :unexpectedProcessesInRunqueue boolean,
  :unexpectedSystemCallHandler boolean,
  :unexpectedInterruptHandler boolean,
  :unexpectedKprobeHandler boolean},
 :compliances [{:standard string, :version string, :ids [string]}],
 :kubernetes
 {:pods
  [{:ns string,
    :name string,
    :labels [{:name string, :value string}],
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}],
  :nodes [{:name string}],
  :nodePools [{:name string, :nodes [{:name string}]}],
  :roles
  [{:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
    :ns string,
    :name string}],
  :bindings
  [{:ns string,
    :name string,
    :role
    {:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
     :ns string,
     :name string},
    :subjects
    [{:kind [AUTH_TYPE_UNSPECIFIED USER SERVICEACCOUNT GROUP],
      :ns string,
      :name string}]}],
  :accessReviews
  [{:group string,
    :ns string,
    :name string,
    :resource string,
    :subresource string,
    :verb string,
    :version string}],
  :objects
  [{:group string,
    :kind string,
    :ns string,
    :name string,
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}]},
 :parent string,
 :cloudArmor
 {:securityPolicy {:name string, :type string, :preview boolean},
  :requests
  {:ratio number,
   :shortTermAllowed integer,
   :longTermAllowed integer,
   :longTermDenied integer},
  :adaptiveProtection {:confidence number},
  :attack
  {:volumePps integer, :volumeBps integer, :classification string},
  :threatVector string,
  :duration string},
 :contacts object,
 :application {:baseUri string, :fullUri string},
 :backupDisasterRecovery
 {:applications [string],
  :appliance string,
  :policies [string],
  :backupTemplate string,
  :backupCreateTime string,
  :storagePool string,
  :policyOptions [string],
  :host string,
  :backupType string,
  :profile string},
 :name string,
 :attackExposure
 {:score number,
  :latestCalculationTime string,
  :attackExposureResult string,
  :state [STATE_UNSPECIFIED CALCULATED NOT_CALCULATED],
  :exposedHighValueResourcesCount integer,
  :exposedMediumValueResourcesCount integer,
  :exposedLowValueResourcesCount integer},
 :toxicCombination
 {:attackExposureScore number, :relatedFindings [string]},
 :createTime string,
 :vulnerability
 {:cve
  {:id string,
   :references [{:source string, :uri string}],
   :cvssv3
   {:privilegesRequired
    [PRIVILEGES_REQUIRED_UNSPECIFIED
     PRIVILEGES_REQUIRED_NONE
     PRIVILEGES_REQUIRED_LOW
     PRIVILEGES_REQUIRED_HIGH],
    :availabilityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :baseScore number,
    :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
    :userInteraction
    [USER_INTERACTION_UNSPECIFIED
     USER_INTERACTION_NONE
     USER_INTERACTION_REQUIRED],
    :attackVector
    [ATTACK_VECTOR_UNSPECIFIED
     ATTACK_VECTOR_NETWORK
     ATTACK_VECTOR_ADJACENT
     ATTACK_VECTOR_LOCAL
     ATTACK_VECTOR_PHYSICAL],
    :attackComplexity
    [ATTACK_COMPLEXITY_UNSPECIFIED
     ATTACK_COMPLEXITY_LOW
     ATTACK_COMPLEXITY_HIGH],
    :confidentialityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :integrityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE]},
   :upstreamFixAvailable boolean,
   :impact [RISK_RATING_UNSPECIFIED LOW MEDIUM HIGH CRITICAL],
   :exploitationActivity
   [EXPLOITATION_ACTIVITY_UNSPECIFIED
    WIDE
    CONFIRMED
    AVAILABLE
    ANTICIPATED
    NO_KNOWN],
   :observedInTheWild boolean,
   :zeroDay boolean},
  :offendingPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :fixedPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :securityBulletin
  {:bulletinId string,
   :submissionTime string,
   :suggestedUpgradeVersion string}},
 :state [STATE_UNSPECIFIED ACTIVE INACTIVE],
 :containers
 [{:name string,
   :uri string,
   :imageId string,
   :labels [{:name string, :value string}],
   :createTime string}],
 :orgPolicies [{:name string}],
 :canonicalName string,
 :moduleName string,
 :nextSteps string,
 :externalUri string,
 :cloudDlpDataProfile
 {:dataProfile string,
  :parentType [PARENT_TYPE_UNSPECIFIED ORGANIZATION PROJECT]},
 :resourceName string,
 :securityMarks {:name string, :marks object, :canonicalName string},
 :sourceProperties object,
 :iamBindings
 [{:action [ACTION_UNSPECIFIED ADD REMOVE],
   :role string,
   :member string}],
 :muteUpdateTime string,
 :muteInitiator string,
 :cloudDlpInspection
 {:inspectJob string,
  :infoType string,
  :infoTypeCount string,
  :fullScan boolean},
 :notebook
 {:name string,
  :service string,
  :lastAuthor string,
  :notebookUpdateTime string},
 :parentDisplayName string,
 :indicator
 {:ipAddresses [string],
  :domains [string],
  :signatures
  [{:memoryHashSignature
    {:binaryFamily string,
     :detections [{:binary string, :percentPagesMatched number}]},
    :yaraRuleSignature {:yaraRule string},
    :signatureType
    [SIGNATURE_TYPE_UNSPECIFIED
     SIGNATURE_TYPE_PROCESS
     SIGNATURE_TYPE_FILE]}],
  :uris [string]},
 :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
 :files
 [{:path string,
   :size string,
   :sha256 string,
   :hashedSize string,
   :partiallyHashed boolean,
   :contents string,
   :diskPath {:partitionUuid string, :relativePath string}}],
 :mitreAttack
 {:primaryTactic
  [TACTIC_UNSPECIFIED
   RECONNAISSANCE
   RESOURCE_DEVELOPMENT
   INITIAL_ACCESS
   EXECUTION
   PERSISTENCE
   PRIVILEGE_ESCALATION
   DEFENSE_EVASION
   CREDENTIAL_ACCESS
   DISCOVERY
   LATERAL_MOVEMENT
   COLLECTION
   COMMAND_AND_CONTROL
   EXFILTRATION
   IMPACT],
  :primaryTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :additionalTactics
  [[TACTIC_UNSPECIFIED
    RECONNAISSANCE
    RESOURCE_DEVELOPMENT
    INITIAL_ACCESS
    EXECUTION
    PERSISTENCE
    PRIVILEGE_ESCALATION
    DEFENSE_EVASION
    CREDENTIAL_ACCESS
    DISCOVERY
    LATERAL_MOVEMENT
    COLLECTION
    COMMAND_AND_CONTROL
    EXFILTRATION
    IMPACT]],
  :additionalTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :version string},
 :loadBalancers [{:name string}],
 :database
 {:name string,
  :displayName string,
  :userName string,
  :query string,
  :grantees [string],
  :version string},
 :access
 {:serviceAccountDelegationInfo
  [{:principalEmail string, :principalSubject string}],
  :callerIp string,
  :userAgentFamily string,
  :userAgent string,
  :serviceAccountKeyName string,
  :principalSubject string,
  :principalEmail string,
  :serviceName string,
  :methodName string,
  :callerIpGeo {:regionCode string},
  :userName string},
 :eventTime string,
 :connections
 [{:destinationIp string,
   :destinationPort integer,
   :sourceIp string,
   :sourcePort integer,
   :protocol [PROTOCOL_UNSPECIFIED ICMP TCP UDP GRE ESP]}],
 :securityPosture
 {:name string,
  :revisionId string,
  :postureDeploymentResource string,
  :postureDeployment string,
  :changedPolicy string,
  :policySet string,
  :policy string,
  :policyDriftDetails
  [{:field string, :expectedValue string, :detectedValue string}]},
 :groupMemberships
 [{:groupType [GROUP_TYPE_UNSPECIFIED GROUP_TYPE_TOXIC_COMBINATION],
   :groupId string}],
 :processes
 [{:args [string],
   :binary
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :argumentsTruncated boolean,
   :libraries
   [{:path string,
     :size string,
     :sha256 string,
     :hashedSize string,
     :partiallyHashed boolean,
     :contents string,
     :diskPath {:partitionUuid string, :relativePath string}}],
   :script
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :name string,
   :envVariablesTruncated boolean,
   :parentPid string,
   :envVariables [{:name string, :val string}],
   :pid string}],
 :findingClass
 [FINDING_CLASS_UNSPECIFIED
  THREAT
  VULNERABILITY
  MISCONFIGURATION
  OBSERVATION
  SCC_ERROR
  POSTURE_VIOLATION
  TOXIC_COMBINATION],
 :logEntries
 [{:cloudLoggingEntry
   {:insertId string,
    :logId string,
    :resourceContainer string,
    :timestamp string}}],
 :mute [MUTE_UNSPECIFIED MUTED UNMUTED UNDEFINED]}

optional:
updateMask <string> The FieldMask to use when updating the finding resource. This field should not be specified when creating a finding. When updating a finding, an empty mask is treated as updating all mutable fields and replacing source_properties. Individual source_properties can be added/updated by using \"source_properties.\" in the field mask."
  ([name Finding] (projects-sources-findings-patch name Finding nil))
  ([name Finding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Finding})))

(defn projects-sources-findings-updateSecurityMarks
  "Updates security marks.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/findings/updateSecurityMarks

name <string> The relative resource name of the SecurityMarks. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Examples: \"organizations/{organization_id}/assets/{asset_id}/securityMarks\" \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}/securityMarks\".
SecurityMarks:
{:name string, :marks object, :canonicalName string}

optional:
updateMask <string> The FieldMask to use when updating the security marks resource. The field mask must not contain duplicate fields. If empty or set to \"marks\", all marks will be replaced. Individual marks can be updated using \"marks.\".
startTime <string> The time at which the updated SecurityMarks take effect. If not set uses current server time. Updates will be applied to the SecurityMarks that are active immediately preceding this time. Must be earlier or equal to the server time."
  ([name SecurityMarks]
    (projects-sources-findings-updateSecurityMarks
      name
      SecurityMarks
      nil))
  ([name SecurityMarks optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityMarks})))

(defn projects-sources-findings-externalSystems-patch
  "Updates external system. This is for a given finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/sources/findings/externalSystems/patch

name <string> Full resource name of the external system, for example: \"organizations/1234/sources/5678/findings/123456/externalSystems/jira\", \"folders/1234/sources/5678/findings/123456/externalSystems/jira\", \"projects/1234/sources/5678/findings/123456/externalSystems/jira\"
GoogleCloudSecuritycenterV1ExternalSystem:
{:assignees [string],
 :externalSystemUpdateTime string,
 :externalUid string,
 :name string,
 :ticketInfo
 {:id string,
  :assignee string,
  :description string,
  :uri string,
  :status string,
  :updateTime string},
 :caseCloseTime string,
 :caseCreateTime string,
 :status string,
 :caseSla string,
 :casePriority string,
 :caseUri string}

optional:
updateMask <string> The FieldMask to use when updating the external system resource. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1ExternalSystem]
    (projects-sources-findings-externalSystems-patch
      name
      GoogleCloudSecuritycenterV1ExternalSystem
      nil))
  ([name GoogleCloudSecuritycenterV1ExternalSystem optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1ExternalSystem})))

(defn projects-notificationConfigs-create
  "Creates a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/notificationConfigs/create

parent <string> Required. Resource name of the new notification config's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
NotificationConfig:
{:name string,
 :description string,
 :pubsubTopic string,
 :serviceAccount string,
 :streamingConfig {:filter string}}

optional:
configId <string> Required. Unique identifier provided by the client within the parent scope. It must be between 1 and 128 characters and contain alphanumeric characters, underscores, or hyphens only."
  ([parent NotificationConfig]
    (projects-notificationConfigs-create
      parent
      NotificationConfig
      nil))
  ([parent NotificationConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/notificationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NotificationConfig})))

(defn projects-notificationConfigs-delete
  "Deletes a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/notificationConfigs/delete

name <string> Required. Name of the notification config to delete. Its format is \"organizations/[organization_id]/notificationConfigs/[config_id]\", \"folders/[folder_id]/notificationConfigs/[config_id]\", or \"projects/[project_id]/notificationConfigs/[config_id]\"."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-notificationConfigs-get
  "Gets a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/notificationConfigs/get

name <string> Required. Name of the notification config to get. Its format is \"organizations/[organization_id]/notificationConfigs/[config_id]\", \"folders/[folder_id]/notificationConfigs/[config_id]\", or \"projects/[project_id]/notificationConfigs/[config_id]\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-notificationConfigs-list
  "Lists notification configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/notificationConfigs/list

parent <string> Required. The name of the parent in which to list the notification configurations. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (projects-notificationConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/notificationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-notificationConfigs-patch
  " Updates a notification config. The following update fields are allowed: description, pubsub_topic, streaming_config.filter
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/notificationConfigs/patch

name <string> The relative resource name of this notification config. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Example: \"organizations/{organization_id}/notificationConfigs/notify_public_bucket\", \"folders/{folder_id}/notificationConfigs/notify_public_bucket\", or \"projects/{project_id}/notificationConfigs/notify_public_bucket\".
NotificationConfig:
{:name string,
 :description string,
 :pubsubTopic string,
 :serviceAccount string,
 :streamingConfig {:filter string}}

optional:
updateMask <string> The FieldMask to use when updating the notification config. If empty all mutable fields will be updated."
  ([name NotificationConfig]
    (projects-notificationConfigs-patch name NotificationConfig nil))
  ([name NotificationConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NotificationConfig})))

(defn projects-bigQueryExports-get
  "Gets a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/bigQueryExports/get

name <string> Required. Name of the BigQuery export to retrieve. Its format is organizations/{organization}/bigQueryExports/{export_id}, folders/{folder}/bigQueryExports/{export_id}, or projects/{project}/bigQueryExports/{export_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-bigQueryExports-create
  "Creates a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/bigQueryExports/create

parent <string> Required. The name of the parent resource of the new BigQuery export. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1BigQueryExport:
{:name string,
 :description string,
 :filter string,
 :dataset string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string,
 :principal string}

optional:
bigQueryExportId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1BigQueryExport]
    (projects-bigQueryExports-create
      parent
      GoogleCloudSecuritycenterV1BigQueryExport
      nil))
  ([parent GoogleCloudSecuritycenterV1BigQueryExport optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/bigQueryExports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1BigQueryExport})))

(defn projects-bigQueryExports-delete
  "Deletes an existing BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/bigQueryExports/delete

name <string> Required. The name of the BigQuery export to delete. Its format is organizations/{organization}/bigQueryExports/{export_id}, folders/{folder}/bigQueryExports/{export_id}, or projects/{project}/bigQueryExports/{export_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-bigQueryExports-patch
  "Updates a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/bigQueryExports/patch

name <string> The relative resource name of this export. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name. Example format: \"organizations/{organization_id}/bigQueryExports/{export_id}\" Example format: \"folders/{folder_id}/bigQueryExports/{export_id}\" Example format: \"projects/{project_id}/bigQueryExports/{export_id}\" This field is provided in responses, and is ignored when provided in create requests.
GoogleCloudSecuritycenterV1BigQueryExport:
{:name string,
 :description string,
 :filter string,
 :dataset string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string,
 :principal string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1BigQueryExport]
    (projects-bigQueryExports-patch
      name
      GoogleCloudSecuritycenterV1BigQueryExport
      nil))
  ([name GoogleCloudSecuritycenterV1BigQueryExport optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1BigQueryExport})))

(defn projects-bigQueryExports-list
  "Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports under that level are also returned e.g. if requesting BigQuery exports under a folder, then all BigQuery exports immediately under the folder plus the ones created under the projects within the folder are returned.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/bigQueryExports/list

parent <string> Required. The parent, which owns the collection of BigQuery exports. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-bigQueryExports-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/bigQueryExports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-muteConfigs-create
  "Creates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/locations/muteConfigs/create

parent <string> Required. Resource name of the new mute configs's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
muteConfigId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1MuteConfig]
    (projects-locations-muteConfigs-create
      parent
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([parent GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn projects-locations-muteConfigs-delete
  "Deletes an existing mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/locations/muteConfigs/delete

name <string> Required. Name of the mute config to delete. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-muteConfigs-get
  "Gets a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/locations/muteConfigs/get

name <string> Required. Name of the mute config to retrieve. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-muteConfigs-list
  "Lists mute configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/locations/muteConfigs/list

parent <string> Required. The parent, which owns the collection of mute configs. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-muteConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-muteConfigs-patch
  "Updates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/locations/muteConfigs/patch

name <string> This field will be ignored if provided on config creation. Format \"organizations/{organization}/muteConfigs/{mute_config}\" \"folders/{folder}/muteConfigs/{mute_config}\" \"projects/{project}/muteConfigs/{mute_config}\" \"organizations/{organization}/locations/global/muteConfigs/{mute_config}\" \"folders/{folder}/locations/global/muteConfigs/{mute_config}\" \"projects/{project}/locations/global/muteConfigs/{mute_config}\"
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1MuteConfig]
    (projects-locations-muteConfigs-patch
      name
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([name GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn projects-securityHealthAnalyticsSettings-customModules-create
  "Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent, and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the given parent. These modules are enabled by default.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/customModules/create

parent <string> Required. Resource name of the new custom module's parent. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"
GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule:
{:name string,
 :displayName string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :updateTime string,
 :lastEditor string,
 :ancestorModule string,
 :customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string}}"
  [parent
   GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule}))

(defn projects-securityHealthAnalyticsSettings-customModules-delete
  "Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM hierarchy. This method is only supported for resident custom modules.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/customModules/delete

name <string> Required. Name of the custom module to delete. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-securityHealthAnalyticsSettings-customModules-get
  "Retrieves a SecurityHealthAnalyticsCustomModule.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/customModules/get

name <string> Required. Name of the custom module to get. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-securityHealthAnalyticsSettings-customModules-listDescendant
  "Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent and all of the parent’s CRM descendants.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/customModules/listDescendant

parent <string> Required. Name of parent to list descendant custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (projects-securityHealthAnalyticsSettings-customModules-listDescendant
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules:listDescendant",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-securityHealthAnalyticsSettings-customModules-list
  "Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/customModules/list

parent <string> Required. Name of parent to list custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (projects-securityHealthAnalyticsSettings-customModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-securityHealthAnalyticsSettings-customModules-simulate
  "Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/customModules/simulate

parent <string> Required. The relative resource name of the organization, project, or folder. For more information about relative resource names, see [Relative Resource Name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) Example: `organizations/{organization_id}`
SimulateSecurityHealthAnalyticsCustomModuleRequest:
{:customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string},
 :resource
 {:resourceType string,
  :resourceData object,
  :iamPolicyData
  {:version integer,
   :bindings
   [{:role string,
     :members [string],
     :condition
     {:expression string,
      :title string,
      :description string,
      :location string}}],
   :auditConfigs
   [{:service string,
     :auditLogConfigs
     [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
       :exemptedMembers [string]}]}],
   :etag string}}}"
  [parent SimulateSecurityHealthAnalyticsCustomModuleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules:simulate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SimulateSecurityHealthAnalyticsCustomModuleRequest}))

(defn projects-securityHealthAnalyticsSettings-customModules-patch
  "Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update mask. Updating the enablement state is supported on both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name and custom config of a module is supported on resident modules only.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/customModules/patch

name <string> Immutable. The resource name of the custom module. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\" The id {customModule} is server-generated and is not user settable. It will be a numeric id containing 1-20 digits.
GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule:
{:name string,
 :displayName string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :updateTime string,
 :lastEditor string,
 :ancestorModule string,
 :customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string}}

optional:
updateMask <string> The list of fields to be updated. The only fields that can be updated are `enablement_state` and `custom_config`. If empty or set to the wildcard value `*`, both `enablement_state` and `custom_config` are updated."
  ([name
    GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule]
    (projects-securityHealthAnalyticsSettings-customModules-patch
      name
      GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule
      nil))
  ([name
    GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule
    optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body
       GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule})))

(defn projects-securityHealthAnalyticsSettings-effectiveCustomModules-get
  "Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/effectiveCustomModules/get

name <string> Required. Name of the effective custom module to get. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-securityHealthAnalyticsSettings-effectiveCustomModules-list
  "Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/securityHealthAnalyticsSettings/effectiveCustomModules/list

parent <string> Required. Name of parent to list effective custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (projects-securityHealthAnalyticsSettings-effectiveCustomModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/effectiveCustomModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-muteConfigs-create
  "Creates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/muteConfigs/create

parent <string> Required. Resource name of the new mute configs's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
muteConfigId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1MuteConfig]
    (projects-muteConfigs-create
      parent
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([parent GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn projects-muteConfigs-delete
  "Deletes an existing mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/muteConfigs/delete

name <string> Required. Name of the mute config to delete. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-muteConfigs-get
  "Gets a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/muteConfigs/get

name <string> Required. Name of the mute config to retrieve. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-muteConfigs-list
  "Lists mute configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/muteConfigs/list

parent <string> Required. The parent, which owns the collection of mute configs. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-muteConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-muteConfigs-patch
  "Updates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/projects/muteConfigs/patch

name <string> This field will be ignored if provided on config creation. Format \"organizations/{organization}/muteConfigs/{mute_config}\" \"folders/{folder}/muteConfigs/{mute_config}\" \"projects/{project}/muteConfigs/{mute_config}\" \"organizations/{organization}/locations/global/muteConfigs/{mute_config}\" \"folders/{folder}/locations/global/muteConfigs/{mute_config}\" \"projects/{project}/locations/global/muteConfigs/{mute_config}\"
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1MuteConfig]
    (projects-muteConfigs-patch
      name
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([name GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn organizations-getOrganizationSettings
  "Gets the settings for an organization.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/getOrganizationSettings

name <string> Required. Name of the organization to get organization settings for. Its format is \"organizations/[organization_id]/organizationSettings\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-updateOrganizationSettings
  "Updates an organization's settings.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/updateOrganizationSettings

name <string> The relative resource name of the settings. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Example: \"organizations/{organization_id}/organizationSettings\".
OrganizationSettings:
{:name string,
 :enableAssetDiscovery boolean,
 :assetDiscoveryConfig
 {:projectIds [string],
  :inclusionMode [INCLUSION_MODE_UNSPECIFIED INCLUDE_ONLY EXCLUDE],
  :folderIds [string]}}

optional:
updateMask <string> The FieldMask to use when updating the settings resource. If empty all mutable fields will be updated."
  ([name OrganizationSettings]
    (organizations-updateOrganizationSettings
      name
      OrganizationSettings
      nil))
  ([name OrganizationSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body OrganizationSettings})))

(defn organizations-findings-bulkMute
  "Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either an organization, folder or project. The findings matched by the filter will be muted after the LRO is done.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/findings/bulkMute

parent <string> Required. The parent, at which bulk action needs to be applied. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".
BulkMuteFindingsRequest:
{:filter string, :muteAnnotation string}"
  [parent BulkMuteFindingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/findings:bulkMute",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BulkMuteFindingsRequest}))

(defn organizations-eventThreatDetectionSettings-validateCustomModule
  "Validates the given Event Threat Detection custom module.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/validateCustomModule

parent <string> Required. Resource name of the parent to validate the Custom Module under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".
ValidateEventThreatDetectionCustomModuleRequest:
{:rawText string, :type string}"
  [parent ValidateEventThreatDetectionCustomModuleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}:validateCustomModule",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ValidateEventThreatDetectionCustomModuleRequest}))

(defn organizations-eventThreatDetectionSettings-customModules-create
  "Creates a resident Event Threat Detection custom module at the scope of the given Resource Manager parent, and also creates inherited custom modules for all descendants of the given parent. These modules are enabled by default.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/customModules/create

parent <string> Required. The new custom module's parent. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".
EventThreatDetectionCustomModule:
{:description string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :lastEditor string,
 :config object,
 :displayName string,
 :ancestorModule string,
 :name string,
 :type string,
 :updateTime string}"
  [parent EventThreatDetectionCustomModule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EventThreatDetectionCustomModule}))

(defn organizations-eventThreatDetectionSettings-customModules-delete
  "Deletes the specified Event Threat Detection custom module and all of its descendants in the Resource Manager hierarchy. This method is only supported for resident custom modules.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/customModules/delete

name <string> Required. Name of the custom module to delete. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\"."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-eventThreatDetectionSettings-customModules-get
  "Gets an Event Threat Detection custom module.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/customModules/get

name <string> Required. Name of the custom module to get. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-eventThreatDetectionSettings-customModules-listDescendant
  "Lists all resident Event Threat Detection custom modules under the given Resource Manager parent and its descendants.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/customModules/listDescendant

parent <string> Required. Name of the parent to list custom modules under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (organizations-eventThreatDetectionSettings-customModules-listDescendant
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules:listDescendant",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-eventThreatDetectionSettings-customModules-list
  "Lists all Event Threat Detection custom modules for the given Resource Manager parent. This includes resident modules defined at the scope of the parent along with modules inherited from ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/customModules/list

parent <string> Required. Name of the parent to list custom modules under. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (organizations-eventThreatDetectionSettings-customModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-eventThreatDetectionSettings-customModules-patch
  "Updates the Event Threat Detection custom module with the given name based on the given update mask. Updating the enablement state is supported for both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name or configuration of a module is supported for resident modules only. The type of a module cannot be changed.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/customModules/patch

name <string> Immutable. The resource name of the Event Threat Detection custom module. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/customModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/customModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/customModules/{module}\".
EventThreatDetectionCustomModule:
{:description string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :lastEditor string,
 :config object,
 :displayName string,
 :ancestorModule string,
 :name string,
 :type string,
 :updateTime string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name EventThreatDetectionCustomModule]
    (organizations-eventThreatDetectionSettings-customModules-patch
      name
      EventThreatDetectionCustomModule
      nil))
  ([name EventThreatDetectionCustomModule optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body EventThreatDetectionCustomModule})))

(defn organizations-eventThreatDetectionSettings-effectiveCustomModules-get
  "Gets an effective Event Threat Detection custom module at the given level.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/effectiveCustomModules/get

name <string> Required. The resource name of the effective Event Threat Detection custom module. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings/effectiveCustomModules/{module}\". * \"folders/{folder}/eventThreatDetectionSettings/effectiveCustomModules/{module}\". * \"projects/{project}/eventThreatDetectionSettings/effectiveCustomModules/{module}\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-eventThreatDetectionSettings-effectiveCustomModules-list
  "Lists all effective Event Threat Detection custom modules for the given parent. This includes resident modules defined at the scope of the parent along with modules inherited from its ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/eventThreatDetectionSettings/effectiveCustomModules/list

parent <string> Required. Name of the parent to list custom modules for. Its format is: * \"organizations/{organization}/eventThreatDetectionSettings\". * \"folders/{folder}/eventThreatDetectionSettings\". * \"projects/{project}/eventThreatDetectionSettings\".

optional:
pageSize <integer> The maximum number of modules to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (organizations-eventThreatDetectionSettings-effectiveCustomModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/effectiveCustomModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-assets-group
  "Filters an organization's assets and groups them by their specified properties.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/assets/group

parent <string> Required. The name of the parent to group the assets by. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GroupAssetsRequest:
{:filter string,
 :groupBy string,
 :compareDuration string,
 :readTime string,
 :pageToken string,
 :pageSize integer}"
  [parent GroupAssetsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/assets:group",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GroupAssetsRequest}))

(defn organizations-assets-list
  "Lists an organization's assets.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/assets/list

parent <string> Required. The name of the parent resource that contains the assets. The value that you can specify on parent depends on the method in which you specify parent. You can specify one of the following values: \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
filter <string> Expression that defines the filter to apply across assets. The expression is a list of zero or more restrictions combined via logical operators `AND` and `OR`. Parentheses are supported, and `OR` has higher precedence than `AND`. Restrictions have the form ` ` and may have a `-` character in front of them to indicate negation. The fields map to those defined in the Asset resource. Examples include: * name * security_center_properties.resource_name * resource_properties.a_property * security_marks.marks.marka The supported operators are: * `=` for all value types. * `>`, `<`, `>=`, `<=` for integer values. * `:`, meaning substring matching, for strings. The supported value types are: * string literals in quotes. * integer literals without quotes. * boolean literals `true` and `false` without quotes. The following are the allowed field and operator combinations: * name: `=` * update_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `update_time = \"2019-06-10T16:07:18-07:00\"` `update_time = 1560208038000` * create_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `create_time = \"2019-06-10T16:07:18-07:00\"` `create_time = 1560208038000` * iam_policy.policy_blob: `=`, `:` * resource_properties: `=`, `:`, `>`, `<`, `>=`, `<=` * security_marks.marks: `=`, `:` * security_center_properties.resource_name: `=`, `:` * security_center_properties.resource_display_name: `=`, `:` * security_center_properties.resource_type: `=`, `:` * security_center_properties.resource_parent: `=`, `:` * security_center_properties.resource_parent_display_name: `=`, `:` * security_center_properties.resource_project: `=`, `:` * security_center_properties.resource_project_display_name: `=`, `:` * security_center_properties.resource_owners: `=`, `:` For example, `resource_properties.size = 100` is a valid filter string. Use a partial match on the empty string to filter based on a property existing: `resource_properties.my_property : \"\"` Use a negated partial match on the empty string to filter based on a property not existing: `-resource_properties.my_property : \"\"`
orderBy <string> Expression that defines what fields and order to use for sorting. The string value should follow SQL syntax: comma separated list of fields. For example: \"name,resource_properties.a_property\". The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be appended to the field name. For example: \"name desc,resource_properties.a_property\". Redundant space characters in the syntax are insignificant. \"name desc,resource_properties.a_property\" and \" name desc , resource_properties.a_property \" are equivalent. The following fields are supported: name update_time resource_properties security_marks.marks security_center_properties.resource_name security_center_properties.resource_display_name security_center_properties.resource_parent security_center_properties.resource_parent_display_name security_center_properties.resource_project security_center_properties.resource_project_display_name security_center_properties.resource_type
readTime <string> Time used as a reference point when filtering assets. The filter is limited to assets existing at the supplied time and their values are those at that specific time. Absence of this field will default to the API's version of NOW.
compareDuration <string> When compare_duration is set, the ListAssetsResult's \"state_change\" attribute is updated to indicate whether the asset was added, removed, or remained present during the compare_duration period of time that precedes the read_time. This is the time between (read_time - compare_duration) and read_time. The state_change value is derived based on the presence of the asset at the two points in time. Intermediate state changes between the two times don't affect the result. For example, the results aren't affected if the asset is removed and re-created again. Possible \"state_change\" values when compare_duration is specified: * \"ADDED\": indicates that the asset was not present at the start of compare_duration, but present at read_time. * \"REMOVED\": indicates that the asset was present at the start of compare_duration, but not present at read_time. * \"ACTIVE\": indicates that the asset was present at both the start and the end of the time period defined by compare_duration and read_time. If compare_duration is not specified, then the only possible state_change is \"UNUSED\", which will be the state_change set for all assets present at read_time.
fieldMask <string> A field mask to specify the ListAssetsResult fields to be listed in the response. An empty field mask will list all fields.
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (organizations-assets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/assets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-assets-runDiscovery
  "Runs asset discovery. The discovery is tracked with a long-running operation. This API can only be called with limited frequency for an organization. If it is called too frequently the caller will receive a TOO_MANY_REQUESTS error.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/assets/runDiscovery

parent <string> Required. Name of the organization to run asset discovery for. Its format is \"organizations/[organization_id]\".
RunAssetDiscoveryRequest:
object"
  [parent RunAssetDiscoveryRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/assets:runDiscovery",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RunAssetDiscoveryRequest}))

(defn organizations-assets-updateSecurityMarks
  "Updates security marks.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/assets/updateSecurityMarks

name <string> The relative resource name of the SecurityMarks. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Examples: \"organizations/{organization_id}/assets/{asset_id}/securityMarks\" \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}/securityMarks\".
SecurityMarks:
{:name string, :marks object, :canonicalName string}

optional:
updateMask <string> The FieldMask to use when updating the security marks resource. The field mask must not contain duplicate fields. If empty or set to \"marks\", all marks will be replaced. Individual marks can be updated using \"marks.\".
startTime <string> The time at which the updated SecurityMarks take effect. If not set uses current server time. Updates will be applied to the SecurityMarks that are active immediately preceding this time. Must be earlier or equal to the server time."
  ([name SecurityMarks]
    (organizations-assets-updateSecurityMarks name SecurityMarks nil))
  ([name SecurityMarks optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityMarks})))

(defn organizations-sources-create
  "Creates a source.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/create

parent <string> Required. Resource name of the new source's parent. Its format should be \"organizations/[organization_id]\".
Source:
{:name string,
 :displayName string,
 :description string,
 :canonicalName string}"
  [parent Source]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/sources",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Source}))

(defn organizations-sources-getIamPolicy
  "Gets the access control policy on the specified Source.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn organizations-sources-get
  "Gets a source.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/get

name <string> Required. Relative resource name of the source. Its format is \"organizations/[organization_id]/source/[source_id]\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-sources-list
  "Lists all sources belonging to an organization.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/list

parent <string> Required. Resource name of the parent of sources to list. Its format should be \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (organizations-sources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/sources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-sources-setIamPolicy
  "Sets the access control policy on the specified Source.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:version integer,
  :bindings
  [{:role string,
    :members [string],
    :condition
    {:expression string,
     :title string,
     :description string,
     :location string}}],
  :auditConfigs
  [{:service string,
    :auditLogConfigs
    [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
      :exemptedMembers [string]}]}],
  :etag string},
 :updateMask string}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn organizations-sources-testIamPermissions
  "Returns the permissions that a caller has on the specified source.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn organizations-sources-patch
  "Updates a source.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/patch

name <string> The relative resource name of this source. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Example: \"organizations/{organization_id}/sources/{source_id}\"
Source:
{:name string,
 :displayName string,
 :description string,
 :canonicalName string}

optional:
updateMask <string> The FieldMask to use when updating the source resource. If empty all mutable fields will be updated."
  ([name Source] (organizations-sources-patch name Source nil))
  ([name Source optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Source})))

(defn organizations-sources-findings-create
  "Creates a finding. The corresponding source must exist for finding creation to succeed.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/create

parent <string> Required. Resource name of the new finding's parent. Its format should be \"organizations/[organization_id]/sources/[source_id]\".
Finding:
{:description string,
 :category string,
 :externalSystems object,
 :exfiltration
 {:sources [{:name string, :components [string]}],
  :targets [{:name string, :components [string]}],
  :totalExfiltratedBytes string},
 :kernelRootkit
 {:unexpectedFtraceHandler boolean,
  :unexpectedReadOnlyDataModification boolean,
  :name string,
  :unexpectedKernelCodePages boolean,
  :unexpectedCodeModification boolean,
  :unexpectedProcessesInRunqueue boolean,
  :unexpectedSystemCallHandler boolean,
  :unexpectedInterruptHandler boolean,
  :unexpectedKprobeHandler boolean},
 :compliances [{:standard string, :version string, :ids [string]}],
 :kubernetes
 {:pods
  [{:ns string,
    :name string,
    :labels [{:name string, :value string}],
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}],
  :nodes [{:name string}],
  :nodePools [{:name string, :nodes [{:name string}]}],
  :roles
  [{:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
    :ns string,
    :name string}],
  :bindings
  [{:ns string,
    :name string,
    :role
    {:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
     :ns string,
     :name string},
    :subjects
    [{:kind [AUTH_TYPE_UNSPECIFIED USER SERVICEACCOUNT GROUP],
      :ns string,
      :name string}]}],
  :accessReviews
  [{:group string,
    :ns string,
    :name string,
    :resource string,
    :subresource string,
    :verb string,
    :version string}],
  :objects
  [{:group string,
    :kind string,
    :ns string,
    :name string,
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}]},
 :parent string,
 :cloudArmor
 {:securityPolicy {:name string, :type string, :preview boolean},
  :requests
  {:ratio number,
   :shortTermAllowed integer,
   :longTermAllowed integer,
   :longTermDenied integer},
  :adaptiveProtection {:confidence number},
  :attack
  {:volumePps integer, :volumeBps integer, :classification string},
  :threatVector string,
  :duration string},
 :contacts object,
 :application {:baseUri string, :fullUri string},
 :backupDisasterRecovery
 {:applications [string],
  :appliance string,
  :policies [string],
  :backupTemplate string,
  :backupCreateTime string,
  :storagePool string,
  :policyOptions [string],
  :host string,
  :backupType string,
  :profile string},
 :name string,
 :attackExposure
 {:score number,
  :latestCalculationTime string,
  :attackExposureResult string,
  :state [STATE_UNSPECIFIED CALCULATED NOT_CALCULATED],
  :exposedHighValueResourcesCount integer,
  :exposedMediumValueResourcesCount integer,
  :exposedLowValueResourcesCount integer},
 :toxicCombination
 {:attackExposureScore number, :relatedFindings [string]},
 :createTime string,
 :vulnerability
 {:cve
  {:id string,
   :references [{:source string, :uri string}],
   :cvssv3
   {:privilegesRequired
    [PRIVILEGES_REQUIRED_UNSPECIFIED
     PRIVILEGES_REQUIRED_NONE
     PRIVILEGES_REQUIRED_LOW
     PRIVILEGES_REQUIRED_HIGH],
    :availabilityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :baseScore number,
    :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
    :userInteraction
    [USER_INTERACTION_UNSPECIFIED
     USER_INTERACTION_NONE
     USER_INTERACTION_REQUIRED],
    :attackVector
    [ATTACK_VECTOR_UNSPECIFIED
     ATTACK_VECTOR_NETWORK
     ATTACK_VECTOR_ADJACENT
     ATTACK_VECTOR_LOCAL
     ATTACK_VECTOR_PHYSICAL],
    :attackComplexity
    [ATTACK_COMPLEXITY_UNSPECIFIED
     ATTACK_COMPLEXITY_LOW
     ATTACK_COMPLEXITY_HIGH],
    :confidentialityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :integrityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE]},
   :upstreamFixAvailable boolean,
   :impact [RISK_RATING_UNSPECIFIED LOW MEDIUM HIGH CRITICAL],
   :exploitationActivity
   [EXPLOITATION_ACTIVITY_UNSPECIFIED
    WIDE
    CONFIRMED
    AVAILABLE
    ANTICIPATED
    NO_KNOWN],
   :observedInTheWild boolean,
   :zeroDay boolean},
  :offendingPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :fixedPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :securityBulletin
  {:bulletinId string,
   :submissionTime string,
   :suggestedUpgradeVersion string}},
 :state [STATE_UNSPECIFIED ACTIVE INACTIVE],
 :containers
 [{:name string,
   :uri string,
   :imageId string,
   :labels [{:name string, :value string}],
   :createTime string}],
 :orgPolicies [{:name string}],
 :canonicalName string,
 :moduleName string,
 :nextSteps string,
 :externalUri string,
 :cloudDlpDataProfile
 {:dataProfile string,
  :parentType [PARENT_TYPE_UNSPECIFIED ORGANIZATION PROJECT]},
 :resourceName string,
 :securityMarks {:name string, :marks object, :canonicalName string},
 :sourceProperties object,
 :iamBindings
 [{:action [ACTION_UNSPECIFIED ADD REMOVE],
   :role string,
   :member string}],
 :muteUpdateTime string,
 :muteInitiator string,
 :cloudDlpInspection
 {:inspectJob string,
  :infoType string,
  :infoTypeCount string,
  :fullScan boolean},
 :notebook
 {:name string,
  :service string,
  :lastAuthor string,
  :notebookUpdateTime string},
 :parentDisplayName string,
 :indicator
 {:ipAddresses [string],
  :domains [string],
  :signatures
  [{:memoryHashSignature
    {:binaryFamily string,
     :detections [{:binary string, :percentPagesMatched number}]},
    :yaraRuleSignature {:yaraRule string},
    :signatureType
    [SIGNATURE_TYPE_UNSPECIFIED
     SIGNATURE_TYPE_PROCESS
     SIGNATURE_TYPE_FILE]}],
  :uris [string]},
 :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
 :files
 [{:path string,
   :size string,
   :sha256 string,
   :hashedSize string,
   :partiallyHashed boolean,
   :contents string,
   :diskPath {:partitionUuid string, :relativePath string}}],
 :mitreAttack
 {:primaryTactic
  [TACTIC_UNSPECIFIED
   RECONNAISSANCE
   RESOURCE_DEVELOPMENT
   INITIAL_ACCESS
   EXECUTION
   PERSISTENCE
   PRIVILEGE_ESCALATION
   DEFENSE_EVASION
   CREDENTIAL_ACCESS
   DISCOVERY
   LATERAL_MOVEMENT
   COLLECTION
   COMMAND_AND_CONTROL
   EXFILTRATION
   IMPACT],
  :primaryTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :additionalTactics
  [[TACTIC_UNSPECIFIED
    RECONNAISSANCE
    RESOURCE_DEVELOPMENT
    INITIAL_ACCESS
    EXECUTION
    PERSISTENCE
    PRIVILEGE_ESCALATION
    DEFENSE_EVASION
    CREDENTIAL_ACCESS
    DISCOVERY
    LATERAL_MOVEMENT
    COLLECTION
    COMMAND_AND_CONTROL
    EXFILTRATION
    IMPACT]],
  :additionalTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :version string},
 :loadBalancers [{:name string}],
 :database
 {:name string,
  :displayName string,
  :userName string,
  :query string,
  :grantees [string],
  :version string},
 :access
 {:serviceAccountDelegationInfo
  [{:principalEmail string, :principalSubject string}],
  :callerIp string,
  :userAgentFamily string,
  :userAgent string,
  :serviceAccountKeyName string,
  :principalSubject string,
  :principalEmail string,
  :serviceName string,
  :methodName string,
  :callerIpGeo {:regionCode string},
  :userName string},
 :eventTime string,
 :connections
 [{:destinationIp string,
   :destinationPort integer,
   :sourceIp string,
   :sourcePort integer,
   :protocol [PROTOCOL_UNSPECIFIED ICMP TCP UDP GRE ESP]}],
 :securityPosture
 {:name string,
  :revisionId string,
  :postureDeploymentResource string,
  :postureDeployment string,
  :changedPolicy string,
  :policySet string,
  :policy string,
  :policyDriftDetails
  [{:field string, :expectedValue string, :detectedValue string}]},
 :groupMemberships
 [{:groupType [GROUP_TYPE_UNSPECIFIED GROUP_TYPE_TOXIC_COMBINATION],
   :groupId string}],
 :processes
 [{:args [string],
   :binary
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :argumentsTruncated boolean,
   :libraries
   [{:path string,
     :size string,
     :sha256 string,
     :hashedSize string,
     :partiallyHashed boolean,
     :contents string,
     :diskPath {:partitionUuid string, :relativePath string}}],
   :script
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :name string,
   :envVariablesTruncated boolean,
   :parentPid string,
   :envVariables [{:name string, :val string}],
   :pid string}],
 :findingClass
 [FINDING_CLASS_UNSPECIFIED
  THREAT
  VULNERABILITY
  MISCONFIGURATION
  OBSERVATION
  SCC_ERROR
  POSTURE_VIOLATION
  TOXIC_COMBINATION],
 :logEntries
 [{:cloudLoggingEntry
   {:insertId string,
    :logId string,
    :resourceContainer string,
    :timestamp string}}],
 :mute [MUTE_UNSPECIFIED MUTED UNMUTED UNDEFINED]}

optional:
findingId <string> Required. Unique identifier provided by the client within the parent scope. It must be alphanumeric and less than or equal to 32 characters and greater than 0 characters in length."
  ([parent Finding]
    (organizations-sources-findings-create parent Finding nil))
  ([parent Finding optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/findings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Finding})))

(defn organizations-sources-findings-group
  "Filters an organization or source's findings and groups them by their specified properties. To group across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings, /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/group

parent <string> Required. Name of the source to groupBy. Its format is \"organizations/[organization_id]/sources/[source_id]\", folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]. To groupBy across all sources provide a source_id of `-`. For example: organizations/{organization_id}/sources/-, folders/{folder_id}/sources/-, or projects/{project_id}/sources/-
GroupFindingsRequest:
{:filter string,
 :groupBy string,
 :readTime string,
 :compareDuration string,
 :pageToken string,
 :pageSize integer}"
  [parent GroupFindingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/findings:group",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GroupFindingsRequest}))

(defn organizations-sources-findings-list
  "Lists an organization or source's findings. To list across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/list

parent <string> Required. Name of the source the findings belong to. Its format is \"organizations/[organization_id]/sources/[source_id], folders/[folder_id]/sources/[source_id], or projects/[project_id]/sources/[source_id]\". To list across all sources provide a source_id of `-`. For example: organizations/{organization_id}/sources/-, folders/{folder_id}/sources/- or projects/{projects_id}/sources/-

optional:
filter <string> Expression that defines the filter to apply across findings. The expression is a list of one or more restrictions combined via logical operators `AND` and `OR`. Parentheses are supported, and `OR` has higher precedence than `AND`. Restrictions have the form ` ` and may have a `-` character in front of them to indicate negation. Examples include: * name * source_properties.a_property * security_marks.marks.marka The supported operators are: * `=` for all value types. * `>`, `<`, `>=`, `<=` for integer values. * `:`, meaning substring matching, for strings. The supported value types are: * string literals in quotes. * integer literals without quotes. * boolean literals `true` and `false` without quotes. The following field and operator combinations are supported: * name: `=` * parent: `=`, `:` * resource_name: `=`, `:` * state: `=`, `:` * category: `=`, `:` * external_uri: `=`, `:` * event_time: `=`, `>`, `<`, `>=`, `<=` Usage: This should be milliseconds since epoch or an RFC3339 string. Examples: `event_time = \"2019-06-10T16:07:18-07:00\"` `event_time = 1560208038000` * severity: `=`, `:` * workflow_state: `=`, `:` * security_marks.marks: `=`, `:` * source_properties: `=`, `:`, `>`, `<`, `>=`, `<=` For example, `source_properties.size = 100` is a valid filter string. Use a partial match on the empty string to filter based on a property existing: `source_properties.my_property : \"\"` Use a negated partial match on the empty string to filter based on a property not existing: `-source_properties.my_property : \"\"` * resource: * resource.name: `=`, `:` * resource.parent_name: `=`, `:` * resource.parent_display_name: `=`, `:` * resource.project_name: `=`, `:` * resource.project_display_name: `=`, `:` * resource.type: `=`, `:` * resource.folders.resource_folder: `=`, `:` * resource.display_name: `=`, `:`
orderBy <string> Expression that defines what fields and order to use for sorting. The string value should follow SQL syntax: comma separated list of fields. For example: \"name,resource_properties.a_property\". The default sorting order is ascending. To specify descending order for a field, a suffix \" desc\" should be appended to the field name. For example: \"name desc,source_properties.a_property\". Redundant space characters in the syntax are insignificant. \"name desc,source_properties.a_property\" and \" name desc , source_properties.a_property \" are equivalent. The following fields are supported: name parent state category resource_name event_time source_properties security_marks.marks
readTime <string> Time used as a reference point when filtering findings. The filter is limited to findings existing at the supplied time and their values are those at that specific time. Absence of this field will default to the API's version of NOW.
compareDuration <string> When compare_duration is set, the ListFindingsResult's \"state_change\" attribute is updated to indicate whether the finding had its state changed, the finding's state remained unchanged, or if the finding was added in any state during the compare_duration period of time that precedes the read_time. This is the time between (read_time - compare_duration) and read_time. The state_change value is derived based on the presence and state of the finding at the two points in time. Intermediate state changes between the two times don't affect the result. For example, the results aren't affected if the finding is made inactive and then active again. Possible \"state_change\" values when compare_duration is specified: * \"CHANGED\": indicates that the finding was present and matched the given filter at the start of compare_duration, but changed its state at read_time. * \"UNCHANGED\": indicates that the finding was present and matched the given filter at the start of compare_duration and did not change state at read_time. * \"ADDED\": indicates that the finding did not match the given filter or was not present at the start of compare_duration, but was present at read_time. * \"REMOVED\": indicates that the finding was present and matched the filter at the start of compare_duration, but did not match the filter at read_time. If compare_duration is not specified, then the only possible state_change is \"UNUSED\", which will be the state_change set for all findings present at read_time.
fieldMask <string> A field mask to specify the Finding fields to be listed in the response. An empty field mask will list all fields.
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (organizations-sources-findings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/findings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-sources-findings-setState
  "Updates the state of a finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/setState

name <string> Required. The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
SetFindingStateRequest:
{:state [STATE_UNSPECIFIED ACTIVE INACTIVE], :startTime string}"
  [name SetFindingStateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+name}:setState",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetFindingStateRequest}))

(defn organizations-sources-findings-setMute
  "Updates the mute state of a finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/setMute

name <string> Required. The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
SetMuteRequest:
{:mute [MUTE_UNSPECIFIED MUTED UNMUTED UNDEFINED]}"
  [name SetMuteRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+name}:setMute",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetMuteRequest}))

(defn organizations-sources-findings-patch
  "Creates or updates a finding. The corresponding source must exist for a finding creation to succeed.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/patch

name <string> The [relative resource name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) of the finding. Example: \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}\", \"folders/{folder_id}/sources/{source_id}/findings/{finding_id}\", \"projects/{project_id}/sources/{source_id}/findings/{finding_id}\".
Finding:
{:description string,
 :category string,
 :externalSystems object,
 :exfiltration
 {:sources [{:name string, :components [string]}],
  :targets [{:name string, :components [string]}],
  :totalExfiltratedBytes string},
 :kernelRootkit
 {:unexpectedFtraceHandler boolean,
  :unexpectedReadOnlyDataModification boolean,
  :name string,
  :unexpectedKernelCodePages boolean,
  :unexpectedCodeModification boolean,
  :unexpectedProcessesInRunqueue boolean,
  :unexpectedSystemCallHandler boolean,
  :unexpectedInterruptHandler boolean,
  :unexpectedKprobeHandler boolean},
 :compliances [{:standard string, :version string, :ids [string]}],
 :kubernetes
 {:pods
  [{:ns string,
    :name string,
    :labels [{:name string, :value string}],
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}],
  :nodes [{:name string}],
  :nodePools [{:name string, :nodes [{:name string}]}],
  :roles
  [{:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
    :ns string,
    :name string}],
  :bindings
  [{:ns string,
    :name string,
    :role
    {:kind [KIND_UNSPECIFIED ROLE CLUSTER_ROLE],
     :ns string,
     :name string},
    :subjects
    [{:kind [AUTH_TYPE_UNSPECIFIED USER SERVICEACCOUNT GROUP],
      :ns string,
      :name string}]}],
  :accessReviews
  [{:group string,
    :ns string,
    :name string,
    :resource string,
    :subresource string,
    :verb string,
    :version string}],
  :objects
  [{:group string,
    :kind string,
    :ns string,
    :name string,
    :containers
    [{:name string,
      :uri string,
      :imageId string,
      :labels [{:name string, :value string}],
      :createTime string}]}]},
 :parent string,
 :cloudArmor
 {:securityPolicy {:name string, :type string, :preview boolean},
  :requests
  {:ratio number,
   :shortTermAllowed integer,
   :longTermAllowed integer,
   :longTermDenied integer},
  :adaptiveProtection {:confidence number},
  :attack
  {:volumePps integer, :volumeBps integer, :classification string},
  :threatVector string,
  :duration string},
 :contacts object,
 :application {:baseUri string, :fullUri string},
 :backupDisasterRecovery
 {:applications [string],
  :appliance string,
  :policies [string],
  :backupTemplate string,
  :backupCreateTime string,
  :storagePool string,
  :policyOptions [string],
  :host string,
  :backupType string,
  :profile string},
 :name string,
 :attackExposure
 {:score number,
  :latestCalculationTime string,
  :attackExposureResult string,
  :state [STATE_UNSPECIFIED CALCULATED NOT_CALCULATED],
  :exposedHighValueResourcesCount integer,
  :exposedMediumValueResourcesCount integer,
  :exposedLowValueResourcesCount integer},
 :toxicCombination
 {:attackExposureScore number, :relatedFindings [string]},
 :createTime string,
 :vulnerability
 {:cve
  {:id string,
   :references [{:source string, :uri string}],
   :cvssv3
   {:privilegesRequired
    [PRIVILEGES_REQUIRED_UNSPECIFIED
     PRIVILEGES_REQUIRED_NONE
     PRIVILEGES_REQUIRED_LOW
     PRIVILEGES_REQUIRED_HIGH],
    :availabilityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :baseScore number,
    :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
    :userInteraction
    [USER_INTERACTION_UNSPECIFIED
     USER_INTERACTION_NONE
     USER_INTERACTION_REQUIRED],
    :attackVector
    [ATTACK_VECTOR_UNSPECIFIED
     ATTACK_VECTOR_NETWORK
     ATTACK_VECTOR_ADJACENT
     ATTACK_VECTOR_LOCAL
     ATTACK_VECTOR_PHYSICAL],
    :attackComplexity
    [ATTACK_COMPLEXITY_UNSPECIFIED
     ATTACK_COMPLEXITY_LOW
     ATTACK_COMPLEXITY_HIGH],
    :confidentialityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
    :integrityImpact
    [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE]},
   :upstreamFixAvailable boolean,
   :impact [RISK_RATING_UNSPECIFIED LOW MEDIUM HIGH CRITICAL],
   :exploitationActivity
   [EXPLOITATION_ACTIVITY_UNSPECIFIED
    WIDE
    CONFIRMED
    AVAILABLE
    ANTICIPATED
    NO_KNOWN],
   :observedInTheWild boolean,
   :zeroDay boolean},
  :offendingPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :fixedPackage
  {:packageName string,
   :cpeUri string,
   :packageType string,
   :packageVersion string},
  :securityBulletin
  {:bulletinId string,
   :submissionTime string,
   :suggestedUpgradeVersion string}},
 :state [STATE_UNSPECIFIED ACTIVE INACTIVE],
 :containers
 [{:name string,
   :uri string,
   :imageId string,
   :labels [{:name string, :value string}],
   :createTime string}],
 :orgPolicies [{:name string}],
 :canonicalName string,
 :moduleName string,
 :nextSteps string,
 :externalUri string,
 :cloudDlpDataProfile
 {:dataProfile string,
  :parentType [PARENT_TYPE_UNSPECIFIED ORGANIZATION PROJECT]},
 :resourceName string,
 :securityMarks {:name string, :marks object, :canonicalName string},
 :sourceProperties object,
 :iamBindings
 [{:action [ACTION_UNSPECIFIED ADD REMOVE],
   :role string,
   :member string}],
 :muteUpdateTime string,
 :muteInitiator string,
 :cloudDlpInspection
 {:inspectJob string,
  :infoType string,
  :infoTypeCount string,
  :fullScan boolean},
 :notebook
 {:name string,
  :service string,
  :lastAuthor string,
  :notebookUpdateTime string},
 :parentDisplayName string,
 :indicator
 {:ipAddresses [string],
  :domains [string],
  :signatures
  [{:memoryHashSignature
    {:binaryFamily string,
     :detections [{:binary string, :percentPagesMatched number}]},
    :yaraRuleSignature {:yaraRule string},
    :signatureType
    [SIGNATURE_TYPE_UNSPECIFIED
     SIGNATURE_TYPE_PROCESS
     SIGNATURE_TYPE_FILE]}],
  :uris [string]},
 :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
 :files
 [{:path string,
   :size string,
   :sha256 string,
   :hashedSize string,
   :partiallyHashed boolean,
   :contents string,
   :diskPath {:partitionUuid string, :relativePath string}}],
 :mitreAttack
 {:primaryTactic
  [TACTIC_UNSPECIFIED
   RECONNAISSANCE
   RESOURCE_DEVELOPMENT
   INITIAL_ACCESS
   EXECUTION
   PERSISTENCE
   PRIVILEGE_ESCALATION
   DEFENSE_EVASION
   CREDENTIAL_ACCESS
   DISCOVERY
   LATERAL_MOVEMENT
   COLLECTION
   COMMAND_AND_CONTROL
   EXFILTRATION
   IMPACT],
  :primaryTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :additionalTactics
  [[TACTIC_UNSPECIFIED
    RECONNAISSANCE
    RESOURCE_DEVELOPMENT
    INITIAL_ACCESS
    EXECUTION
    PERSISTENCE
    PRIVILEGE_ESCALATION
    DEFENSE_EVASION
    CREDENTIAL_ACCESS
    DISCOVERY
    LATERAL_MOVEMENT
    COLLECTION
    COMMAND_AND_CONTROL
    EXFILTRATION
    IMPACT]],
  :additionalTechniques
  [[TECHNIQUE_UNSPECIFIED
    MASQUERADING
    MATCH_LEGITIMATE_NAME_OR_LOCATION
    BOOT_OR_LOGON_INITIALIZATION_SCRIPTS
    STARTUP_ITEMS
    NETWORK_SERVICE_DISCOVERY
    PROCESS_DISCOVERY
    COMMAND_AND_SCRIPTING_INTERPRETER
    UNIX_SHELL
    PYTHON
    PERMISSION_GROUPS_DISCOVERY
    CLOUD_GROUPS
    APPLICATION_LAYER_PROTOCOL
    DNS
    SOFTWARE_DEPLOYMENT_TOOLS
    VALID_ACCOUNTS
    DEFAULT_ACCOUNTS
    LOCAL_ACCOUNTS
    CLOUD_ACCOUNTS
    PROXY
    EXTERNAL_PROXY
    MULTI_HOP_PROXY
    ACCOUNT_MANIPULATION
    ADDITIONAL_CLOUD_CREDENTIALS
    SSH_AUTHORIZED_KEYS
    ADDITIONAL_CONTAINER_CLUSTER_ROLES
    INGRESS_TOOL_TRANSFER
    NATIVE_API
    BRUTE_FORCE
    SHARED_MODULES
    ACCESS_TOKEN_MANIPULATION
    TOKEN_IMPERSONATION_OR_THEFT
    EXPLOIT_PUBLIC_FACING_APPLICATION
    DOMAIN_POLICY_MODIFICATION
    DATA_DESTRUCTION
    SERVICE_STOP
    INHIBIT_SYSTEM_RECOVERY
    RESOURCE_HIJACKING
    NETWORK_DENIAL_OF_SERVICE
    CLOUD_SERVICE_DISCOVERY
    STEAL_APPLICATION_ACCESS_TOKEN
    ACCOUNT_ACCESS_REMOVAL
    STEAL_WEB_SESSION_COOKIE
    CREATE_OR_MODIFY_SYSTEM_PROCESS
    ABUSE_ELEVATION_CONTROL_MECHANISM
    UNSECURED_CREDENTIALS
    MODIFY_AUTHENTICATION_PROCESS
    IMPAIR_DEFENSES
    DISABLE_OR_MODIFY_TOOLS
    EXFILTRATION_OVER_WEB_SERVICE
    EXFILTRATION_TO_CLOUD_STORAGE
    DYNAMIC_RESOLUTION
    LATERAL_TOOL_TRANSFER
    MODIFY_CLOUD_COMPUTE_INFRASTRUCTURE
    CREATE_SNAPSHOT
    CLOUD_INFRASTRUCTURE_DISCOVERY
    OBTAIN_CAPABILITIES
    ACTIVE_SCANNING
    SCANNING_IP_BLOCKS
    CONTAINER_ADMINISTRATION_COMMAND
    ESCAPE_TO_HOST
    CONTAINER_AND_RESOURCE_DISCOVERY
    STEAL_OR_FORGE_AUTHENTICATION_CERTIFICATES]],
  :version string},
 :loadBalancers [{:name string}],
 :database
 {:name string,
  :displayName string,
  :userName string,
  :query string,
  :grantees [string],
  :version string},
 :access
 {:serviceAccountDelegationInfo
  [{:principalEmail string, :principalSubject string}],
  :callerIp string,
  :userAgentFamily string,
  :userAgent string,
  :serviceAccountKeyName string,
  :principalSubject string,
  :principalEmail string,
  :serviceName string,
  :methodName string,
  :callerIpGeo {:regionCode string},
  :userName string},
 :eventTime string,
 :connections
 [{:destinationIp string,
   :destinationPort integer,
   :sourceIp string,
   :sourcePort integer,
   :protocol [PROTOCOL_UNSPECIFIED ICMP TCP UDP GRE ESP]}],
 :securityPosture
 {:name string,
  :revisionId string,
  :postureDeploymentResource string,
  :postureDeployment string,
  :changedPolicy string,
  :policySet string,
  :policy string,
  :policyDriftDetails
  [{:field string, :expectedValue string, :detectedValue string}]},
 :groupMemberships
 [{:groupType [GROUP_TYPE_UNSPECIFIED GROUP_TYPE_TOXIC_COMBINATION],
   :groupId string}],
 :processes
 [{:args [string],
   :binary
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :argumentsTruncated boolean,
   :libraries
   [{:path string,
     :size string,
     :sha256 string,
     :hashedSize string,
     :partiallyHashed boolean,
     :contents string,
     :diskPath {:partitionUuid string, :relativePath string}}],
   :script
   {:path string,
    :size string,
    :sha256 string,
    :hashedSize string,
    :partiallyHashed boolean,
    :contents string,
    :diskPath {:partitionUuid string, :relativePath string}},
   :name string,
   :envVariablesTruncated boolean,
   :parentPid string,
   :envVariables [{:name string, :val string}],
   :pid string}],
 :findingClass
 [FINDING_CLASS_UNSPECIFIED
  THREAT
  VULNERABILITY
  MISCONFIGURATION
  OBSERVATION
  SCC_ERROR
  POSTURE_VIOLATION
  TOXIC_COMBINATION],
 :logEntries
 [{:cloudLoggingEntry
   {:insertId string,
    :logId string,
    :resourceContainer string,
    :timestamp string}}],
 :mute [MUTE_UNSPECIFIED MUTED UNMUTED UNDEFINED]}

optional:
updateMask <string> The FieldMask to use when updating the finding resource. This field should not be specified when creating a finding. When updating a finding, an empty mask is treated as updating all mutable fields and replacing source_properties. Individual source_properties can be added/updated by using \"source_properties.\" in the field mask."
  ([name Finding]
    (organizations-sources-findings-patch name Finding nil))
  ([name Finding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Finding})))

(defn organizations-sources-findings-updateSecurityMarks
  "Updates security marks.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/updateSecurityMarks

name <string> The relative resource name of the SecurityMarks. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Examples: \"organizations/{organization_id}/assets/{asset_id}/securityMarks\" \"organizations/{organization_id}/sources/{source_id}/findings/{finding_id}/securityMarks\".
SecurityMarks:
{:name string, :marks object, :canonicalName string}

optional:
updateMask <string> The FieldMask to use when updating the security marks resource. The field mask must not contain duplicate fields. If empty or set to \"marks\", all marks will be replaced. Individual marks can be updated using \"marks.\".
startTime <string> The time at which the updated SecurityMarks take effect. If not set uses current server time. Updates will be applied to the SecurityMarks that are active immediately preceding this time. Must be earlier or equal to the server time."
  ([name SecurityMarks]
    (organizations-sources-findings-updateSecurityMarks
      name
      SecurityMarks
      nil))
  ([name SecurityMarks optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body SecurityMarks})))

(defn organizations-sources-findings-externalSystems-patch
  "Updates external system. This is for a given finding.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/sources/findings/externalSystems/patch

name <string> Full resource name of the external system, for example: \"organizations/1234/sources/5678/findings/123456/externalSystems/jira\", \"folders/1234/sources/5678/findings/123456/externalSystems/jira\", \"projects/1234/sources/5678/findings/123456/externalSystems/jira\"
GoogleCloudSecuritycenterV1ExternalSystem:
{:assignees [string],
 :externalSystemUpdateTime string,
 :externalUid string,
 :name string,
 :ticketInfo
 {:id string,
  :assignee string,
  :description string,
  :uri string,
  :status string,
  :updateTime string},
 :caseCloseTime string,
 :caseCreateTime string,
 :status string,
 :caseSla string,
 :casePriority string,
 :caseUri string}

optional:
updateMask <string> The FieldMask to use when updating the external system resource. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1ExternalSystem]
    (organizations-sources-findings-externalSystems-patch
      name
      GoogleCloudSecuritycenterV1ExternalSystem
      nil))
  ([name GoogleCloudSecuritycenterV1ExternalSystem optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1ExternalSystem})))

(defn organizations-notificationConfigs-create
  "Creates a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/notificationConfigs/create

parent <string> Required. Resource name of the new notification config's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
NotificationConfig:
{:name string,
 :description string,
 :pubsubTopic string,
 :serviceAccount string,
 :streamingConfig {:filter string}}

optional:
configId <string> Required. Unique identifier provided by the client within the parent scope. It must be between 1 and 128 characters and contain alphanumeric characters, underscores, or hyphens only."
  ([parent NotificationConfig]
    (organizations-notificationConfigs-create
      parent
      NotificationConfig
      nil))
  ([parent NotificationConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/notificationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NotificationConfig})))

(defn organizations-notificationConfigs-delete
  "Deletes a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/notificationConfigs/delete

name <string> Required. Name of the notification config to delete. Its format is \"organizations/[organization_id]/notificationConfigs/[config_id]\", \"folders/[folder_id]/notificationConfigs/[config_id]\", or \"projects/[project_id]/notificationConfigs/[config_id]\"."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-notificationConfigs-get
  "Gets a notification config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/notificationConfigs/get

name <string> Required. Name of the notification config to get. Its format is \"organizations/[organization_id]/notificationConfigs/[config_id]\", \"folders/[folder_id]/notificationConfigs/[config_id]\", or \"projects/[project_id]/notificationConfigs/[config_id]\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-notificationConfigs-list
  "Lists notification configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/notificationConfigs/list

parent <string> Required. The name of the parent in which to list the notification configurations. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (organizations-notificationConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/notificationConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-notificationConfigs-patch
  " Updates a notification config. The following update fields are allowed: description, pubsub_topic, streaming_config.filter
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/notificationConfigs/patch

name <string> The relative resource name of this notification config. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name Example: \"organizations/{organization_id}/notificationConfigs/notify_public_bucket\", \"folders/{folder_id}/notificationConfigs/notify_public_bucket\", or \"projects/{project_id}/notificationConfigs/notify_public_bucket\".
NotificationConfig:
{:name string,
 :description string,
 :pubsubTopic string,
 :serviceAccount string,
 :streamingConfig {:filter string}}

optional:
updateMask <string> The FieldMask to use when updating the notification config. If empty all mutable fields will be updated."
  ([name NotificationConfig]
    (organizations-notificationConfigs-patch
      name
      NotificationConfig
      nil))
  ([name NotificationConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body NotificationConfig})))

(defn organizations-bigQueryExports-get
  "Gets a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/bigQueryExports/get

name <string> Required. Name of the BigQuery export to retrieve. Its format is organizations/{organization}/bigQueryExports/{export_id}, folders/{folder}/bigQueryExports/{export_id}, or projects/{project}/bigQueryExports/{export_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-bigQueryExports-create
  "Creates a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/bigQueryExports/create

parent <string> Required. The name of the parent resource of the new BigQuery export. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1BigQueryExport:
{:name string,
 :description string,
 :filter string,
 :dataset string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string,
 :principal string}

optional:
bigQueryExportId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1BigQueryExport]
    (organizations-bigQueryExports-create
      parent
      GoogleCloudSecuritycenterV1BigQueryExport
      nil))
  ([parent GoogleCloudSecuritycenterV1BigQueryExport optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/bigQueryExports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1BigQueryExport})))

(defn organizations-bigQueryExports-delete
  "Deletes an existing BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/bigQueryExports/delete

name <string> Required. The name of the BigQuery export to delete. Its format is organizations/{organization}/bigQueryExports/{export_id}, folders/{folder}/bigQueryExports/{export_id}, or projects/{project}/bigQueryExports/{export_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-bigQueryExports-patch
  "Updates a BigQuery export.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/bigQueryExports/patch

name <string> The relative resource name of this export. See: https://cloud.google.com/apis/design/resource_names#relative_resource_name. Example format: \"organizations/{organization_id}/bigQueryExports/{export_id}\" Example format: \"folders/{folder_id}/bigQueryExports/{export_id}\" Example format: \"projects/{project_id}/bigQueryExports/{export_id}\" This field is provided in responses, and is ignored when provided in create requests.
GoogleCloudSecuritycenterV1BigQueryExport:
{:name string,
 :description string,
 :filter string,
 :dataset string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string,
 :principal string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1BigQueryExport]
    (organizations-bigQueryExports-patch
      name
      GoogleCloudSecuritycenterV1BigQueryExport
      nil))
  ([name GoogleCloudSecuritycenterV1BigQueryExport optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1BigQueryExport})))

(defn organizations-bigQueryExports-list
  "Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports under that level are also returned e.g. if requesting BigQuery exports under a folder, then all BigQuery exports immediately under the folder plus the ones created under the projects within the folder are returned.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/bigQueryExports/list

parent <string> Required. The parent, which owns the collection of BigQuery exports. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (organizations-bigQueryExports-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/bigQueryExports",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-muteConfigs-create
  "Creates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/locations/muteConfigs/create

parent <string> Required. Resource name of the new mute configs's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
muteConfigId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1MuteConfig]
    (organizations-locations-muteConfigs-create
      parent
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([parent GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn organizations-locations-muteConfigs-delete
  "Deletes an existing mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/locations/muteConfigs/delete

name <string> Required. Name of the mute config to delete. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-muteConfigs-get
  "Gets a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/locations/muteConfigs/get

name <string> Required. Name of the mute config to retrieve. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-locations-muteConfigs-list
  "Lists mute configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/locations/muteConfigs/list

parent <string> Required. The parent, which owns the collection of mute configs. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (organizations-locations-muteConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-locations-muteConfigs-patch
  "Updates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/locations/muteConfigs/patch

name <string> This field will be ignored if provided on config creation. Format \"organizations/{organization}/muteConfigs/{mute_config}\" \"folders/{folder}/muteConfigs/{mute_config}\" \"projects/{project}/muteConfigs/{mute_config}\" \"organizations/{organization}/locations/global/muteConfigs/{mute_config}\" \"folders/{folder}/locations/global/muteConfigs/{mute_config}\" \"projects/{project}/locations/global/muteConfigs/{mute_config}\"
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1MuteConfig]
    (organizations-locations-muteConfigs-patch
      name
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([name GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn organizations-securityHealthAnalyticsSettings-customModules-create
  "Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent, and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the given parent. These modules are enabled by default.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/customModules/create

parent <string> Required. Resource name of the new custom module's parent. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"
GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule:
{:name string,
 :displayName string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :updateTime string,
 :lastEditor string,
 :ancestorModule string,
 :customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string}}"
  [parent
   GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body
     GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule}))

(defn organizations-securityHealthAnalyticsSettings-customModules-delete
  "Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM hierarchy. This method is only supported for resident custom modules.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/customModules/delete

name <string> Required. Name of the custom module to delete. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\""
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-securityHealthAnalyticsSettings-customModules-get
  "Retrieves a SecurityHealthAnalyticsCustomModule.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/customModules/get

name <string> Required. Name of the custom module to get. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-securityHealthAnalyticsSettings-customModules-listDescendant
  "Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent and all of the parent’s CRM descendants.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/customModules/listDescendant

parent <string> Required. Name of parent to list descendant custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (organizations-securityHealthAnalyticsSettings-customModules-listDescendant
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules:listDescendant",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-securityHealthAnalyticsSettings-customModules-list
  "Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/customModules/list

parent <string> Required. Name of parent to list custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (organizations-securityHealthAnalyticsSettings-customModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/customModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-securityHealthAnalyticsSettings-customModules-simulate
  "Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/customModules/simulate

parent <string> Required. The relative resource name of the organization, project, or folder. For more information about relative resource names, see [Relative Resource Name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) Example: `organizations/{organization_id}`
SimulateSecurityHealthAnalyticsCustomModuleRequest:
{:customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string},
 :resource
 {:resourceType string,
  :resourceData object,
  :iamPolicyData
  {:version integer,
   :bindings
   [{:role string,
     :members [string],
     :condition
     {:expression string,
      :title string,
      :description string,
      :location string}}],
   :auditConfigs
   [{:service string,
     :auditLogConfigs
     [{:logType [LOG_TYPE_UNSPECIFIED ADMIN_READ DATA_WRITE DATA_READ],
       :exemptedMembers [string]}]}],
   :etag string}}}"
  [parent SimulateSecurityHealthAnalyticsCustomModuleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/customModules:simulate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SimulateSecurityHealthAnalyticsCustomModuleRequest}))

(defn organizations-securityHealthAnalyticsSettings-customModules-patch
  "Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update mask. Updating the enablement state is supported on both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name and custom config of a module is supported on resident modules only.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/customModules/patch

name <string> Immutable. The resource name of the custom module. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"folders/{folder}/securityHealthAnalyticsSettings/customModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/customModules/{customModule}\" The id {customModule} is server-generated and is not user settable. It will be a numeric id containing 1-20 digits.
GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule:
{:name string,
 :displayName string,
 :enablementState
 [ENABLEMENT_STATE_UNSPECIFIED ENABLED DISABLED INHERITED],
 :updateTime string,
 :lastEditor string,
 :ancestorModule string,
 :customConfig
 {:predicate
  {:expression string,
   :title string,
   :description string,
   :location string},
  :customOutput
  {:properties
   [{:name string,
     :valueExpression
     {:expression string,
      :title string,
      :description string,
      :location string}}]},
  :resourceSelector {:resourceTypes [string]},
  :severity [SEVERITY_UNSPECIFIED CRITICAL HIGH MEDIUM LOW],
  :description string,
  :recommendation string}}

optional:
updateMask <string> The list of fields to be updated. The only fields that can be updated are `enablement_state` and `custom_config`. If empty or set to the wildcard value `*`, both `enablement_state` and `custom_config` are updated."
  ([name
    GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule]
    (organizations-securityHealthAnalyticsSettings-customModules-patch
      name
      GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule
      nil))
  ([name
    GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule
    optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body
       GoogleCloudSecuritycenterV1SecurityHealthAnalyticsCustomModule})))

(defn organizations-securityHealthAnalyticsSettings-effectiveCustomModules-get
  "Retrieves an EffectiveSecurityHealthAnalyticsCustomModule.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/effectiveCustomModules/get

name <string> Required. Name of the effective custom module to get. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\", \"folders/{folder}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\", or \"projects/{project}/securityHealthAnalyticsSettings/effectiveCustomModules/{customModule}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-securityHealthAnalyticsSettings-effectiveCustomModules-list
  "Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/securityHealthAnalyticsSettings/effectiveCustomModules/list

parent <string> Required. Name of parent to list effective custom modules. Its format is \"organizations/{organization}/securityHealthAnalyticsSettings\", \"folders/{folder}/securityHealthAnalyticsSettings\", or \"projects/{project}/securityHealthAnalyticsSettings\"

optional:
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (organizations-securityHealthAnalyticsSettings-effectiveCustomModules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/effectiveCustomModules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-muteConfigs-create
  "Creates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/muteConfigs/create

parent <string> Required. Resource name of the new mute configs's parent. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", or \"projects/[project_id]\".
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
muteConfigId <string> Required. Unique identifier provided by the client within the parent scope. It must consist of only lowercase letters, numbers, and hyphens, must start with a letter, must end with either a letter or a number, and must be 63 characters or less."
  ([parent GoogleCloudSecuritycenterV1MuteConfig]
    (organizations-muteConfigs-create
      parent
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([parent GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn organizations-muteConfigs-delete
  "Deletes an existing mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/muteConfigs/delete

name <string> Required. Name of the mute config to delete. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-muteConfigs-get
  "Gets a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/muteConfigs/get

name <string> Required. Name of the mute config to retrieve. Its format is organizations/{organization}/muteConfigs/{config_id}, folders/{folder}/muteConfigs/{config_id}, projects/{project}/muteConfigs/{config_id}, organizations/{organization}/locations/global/muteConfigs/{config_id}, folders/{folder}/locations/global/muteConfigs/{config_id}, or projects/{project}/locations/global/muteConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-muteConfigs-list
  "Lists mute configs.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/muteConfigs/list

parent <string> Required. The parent, which owns the collection of mute configs. Its format is \"organizations/[organization_id]\", \"folders/[folder_id]\", \"projects/[project_id]\".

optional:
pageSize <integer> The maximum number of configs to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (organizations-muteConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/muteConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-muteConfigs-patch
  "Updates a mute config.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/muteConfigs/patch

name <string> This field will be ignored if provided on config creation. Format \"organizations/{organization}/muteConfigs/{mute_config}\" \"folders/{folder}/muteConfigs/{mute_config}\" \"projects/{project}/muteConfigs/{mute_config}\" \"organizations/{organization}/locations/global/muteConfigs/{mute_config}\" \"folders/{folder}/locations/global/muteConfigs/{mute_config}\" \"projects/{project}/locations/global/muteConfigs/{mute_config}\"
GoogleCloudSecuritycenterV1MuteConfig:
{:name string,
 :displayName string,
 :description string,
 :filter string,
 :createTime string,
 :updateTime string,
 :mostRecentEditor string}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1MuteConfig]
    (organizations-muteConfigs-patch
      name
      GoogleCloudSecuritycenterV1MuteConfig
      nil))
  ([name GoogleCloudSecuritycenterV1MuteConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1MuteConfig})))

(defn organizations-resourceValueConfigs-batchCreate
  "Creates a ResourceValueConfig for an organization. Maps user's tags to difference resource values for use by the attack path simulation.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/resourceValueConfigs/batchCreate

parent <string> Required. Resource name of the new ResourceValueConfig's parent. The parent field in the CreateResourceValueConfigRequest messages must either be empty or match this field.
BatchCreateResourceValueConfigsRequest:
{:requests
 [{:parent string,
   :resourceValueConfig
   {:description string,
    :resourceLabelsSelector object,
    :name string,
    :createTime string,
    :cloudProvider
    [CLOUD_PROVIDER_UNSPECIFIED
     GOOGLE_CLOUD_PLATFORM
     AMAZON_WEB_SERVICES
     MICROSOFT_AZURE],
    :resourceType string,
    :scope string,
    :updateTime string,
    :sensitiveDataProtectionMapping
    {:highSensitivityMapping
     [RESOURCE_VALUE_UNSPECIFIED HIGH MEDIUM LOW NONE],
     :mediumSensitivityMapping
     [RESOURCE_VALUE_UNSPECIFIED HIGH MEDIUM LOW NONE]},
    :tagValues [string],
    :resourceValue [RESOURCE_VALUE_UNSPECIFIED HIGH MEDIUM LOW NONE]}}]}"
  [parent BatchCreateResourceValueConfigsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+parent}/resourceValueConfigs:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchCreateResourceValueConfigsRequest}))

(defn organizations-resourceValueConfigs-delete
  "Deletes a ResourceValueConfig.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/resourceValueConfigs/delete

name <string> Required. Name of the ResourceValueConfig to delete"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-resourceValueConfigs-get
  "Gets a ResourceValueConfig.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/resourceValueConfigs/get

name <string> Required. Name of the resource value config to retrieve. Its format is organizations/{organization}/resourceValueConfigs/{config_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-resourceValueConfigs-list
  "Lists all ResourceValueConfigs.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/resourceValueConfigs/list

parent <string> Required. The parent, which owns the collection of resource value configs. Its format is \"organizations/[organization_id]\"

optional:
pageSize <integer> The number of results to return. The service may return fewer than this value. If unspecified, at most 10 configs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (organizations-resourceValueConfigs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/resourceValueConfigs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-resourceValueConfigs-patch
  "Updates an existing ResourceValueConfigs with new rules.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/resourceValueConfigs/patch

name <string> Name for the resource value configuration
GoogleCloudSecuritycenterV1ResourceValueConfig:
{:description string,
 :resourceLabelsSelector object,
 :name string,
 :createTime string,
 :cloudProvider
 [CLOUD_PROVIDER_UNSPECIFIED
  GOOGLE_CLOUD_PLATFORM
  AMAZON_WEB_SERVICES
  MICROSOFT_AZURE],
 :resourceType string,
 :scope string,
 :updateTime string,
 :sensitiveDataProtectionMapping
 {:highSensitivityMapping
  [RESOURCE_VALUE_UNSPECIFIED HIGH MEDIUM LOW NONE],
  :mediumSensitivityMapping
  [RESOURCE_VALUE_UNSPECIFIED HIGH MEDIUM LOW NONE]},
 :tagValues [string],
 :resourceValue [RESOURCE_VALUE_UNSPECIFIED HIGH MEDIUM LOW NONE]}

optional:
updateMask <string> The list of fields to be updated. If empty all mutable fields will be updated."
  ([name GoogleCloudSecuritycenterV1ResourceValueConfig]
    (organizations-resourceValueConfigs-patch
      name
      GoogleCloudSecuritycenterV1ResourceValueConfig
      nil))
  ([name GoogleCloudSecuritycenterV1ResourceValueConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudSecuritycenterV1ResourceValueConfig})))

(defn organizations-simulations-get
  "Get the simulation by name or the latest simulation for the given organization.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/simulations/get

name <string> Required. The organization name or simulation name of this simulation Valid format: \"organizations/{organization}/simulations/latest\" \"organizations/{organization}/simulations/{simulation}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-simulations-valuedResources-get
  "Get the valued resource by name
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/simulations/valuedResources/get

name <string> Required. The name of this valued resource Valid format: \"organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-simulations-valuedResources-list
  "Lists the valued resources for a set of simulation results and filter.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/simulations/valuedResources/list

parent <string> Required. Name of parent to list valued resources. Valid formats: \"organizations/{organization}\", \"organizations/{organization}/simulations/{simulation}\" \"organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}\"

optional:
filter <string> The filter expression that filters the valued resources in the response. Supported fields: * `resource_value` supports = * `resource_type` supports =
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000.
orderBy <string> Optional. The fields by which to order the valued resources response. Supported fields: * `exposed_score` * `resource_value` * `resource_type` * `resource` * `display_name` Values should be a comma separated list of fields. For example: `exposed_score,resource_value`. The default sorting order is descending. To specify ascending or descending order for a field, append a \" ASC\" or a \" DESC\" suffix, respectively; for example: `exposed_score DESC`."
  ([parent]
    (organizations-simulations-valuedResources-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/valuedResources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-simulations-valuedResources-attackPaths-list
  "Lists the attack paths for a set of simulation results or valued resources and filter.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/simulations/valuedResources/attackPaths/list

parent <string> Required. Name of parent to list attack paths. Valid formats: \"organizations/{organization}\", \"organizations/{organization}/simulations/{simulation}\" \"organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}\" \"organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}\"

optional:
filter <string> The filter expression that filters the attack path in the response. Supported fields: * `valued_resources` supports =
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (organizations-simulations-valuedResources-attackPaths-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/attackPaths",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-simulations-attackExposureResults-valuedResources-list
  "Lists the valued resources for a set of simulation results and filter.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/simulations/attackExposureResults/valuedResources/list

parent <string> Required. Name of parent to list valued resources. Valid formats: \"organizations/{organization}\", \"organizations/{organization}/simulations/{simulation}\" \"organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}\"

optional:
filter <string> The filter expression that filters the valued resources in the response. Supported fields: * `resource_value` supports = * `resource_type` supports =
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000.
orderBy <string> Optional. The fields by which to order the valued resources response. Supported fields: * `exposed_score` * `resource_value` * `resource_type` * `resource` * `display_name` Values should be a comma separated list of fields. For example: `exposed_score,resource_value`. The default sorting order is descending. To specify ascending or descending order for a field, append a \" ASC\" or a \" DESC\" suffix, respectively; for example: `exposed_score DESC`."
  ([parent]
    (organizations-simulations-attackExposureResults-valuedResources-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/valuedResources",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-simulations-attackExposureResults-attackPaths-list
  "Lists the attack paths for a set of simulation results or valued resources and filter.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/simulations/attackExposureResults/attackPaths/list

parent <string> Required. Name of parent to list attack paths. Valid formats: \"organizations/{organization}\", \"organizations/{organization}/simulations/{simulation}\" \"organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}\" \"organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}\"

optional:
filter <string> The filter expression that filters the attack path in the response. Supported fields: * `valued_resources` supports =
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent]
    (organizations-simulations-attackExposureResults-attackPaths-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/attackPaths",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-simulations-attackPaths-list
  "Lists the attack paths for a set of simulation results or valued resources and filter.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/simulations/attackPaths/list

parent <string> Required. Name of parent to list attack paths. Valid formats: \"organizations/{organization}\", \"organizations/{organization}/simulations/{simulation}\" \"organizations/{organization}/simulations/{simulation}/attackExposureResults/{attack_exposure_result_v2}\" \"organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}\"

optional:
filter <string> The filter expression that filters the attack path in the response. Supported fields: * `valued_resources` supports =
pageSize <integer> The maximum number of results to return in a single response. Default is 10, minimum is 1, maximum is 1000."
  ([parent] (organizations-simulations-attackPaths-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+parent}/attackPaths",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (organizations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://securitycenter.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://securitycenter.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/security/products/security-command-center/v1/docs/organizations/operations/cancel

name <string> The name of the operation resource to be cancelled."
  [name]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://securitycenter.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(ns happygapi2.orgpolicy
  "Organization Policy API
The Organization Policy API allows users to configure governance rules on their Google Cloud resources across the resource hierarchy.
See: https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest"
  (:require [happy.oauth2.client :as client]))

(defn organizations-customConstraints-get
  "Gets a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the custom constraint does not exist.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.customConstraints/get

name <string> Required. Resource name of the custom constraint. See the custom constraint entry for naming requirements."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-customConstraints-patch
  "Updates a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Note: the supplied policy will perform a full overwrite of all fields.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.customConstraints/patch

name <string> Immutable. Name of the constraint. This is unique within the organization. Format of the name should be * `organizations/{organization_id}/customConstraints/{custom_constraint_id}` Example: `organizations/123/customConstraints/custom.createOnlyE2TypeVms` The max length is 70 characters and the minimum length is 1. Note that the prefix `organizations/{organization_id}/customConstraints/` is not counted.
GoogleCloudOrgpolicyV2CustomConstraint:
{:resourceTypes [string],
 :condition string,
 :description string,
 :methodTypes
 [[METHOD_TYPE_UNSPECIFIED
   CREATE
   UPDATE
   DELETE
   REMOVE_GRANT
   GOVERN_TAGS]],
 :actionType [ACTION_TYPE_UNSPECIFIED ALLOW DENY],
 :updateTime string,
 :name string,
 :displayName string}"
  [name GoogleCloudOrgpolicyV2CustomConstraint]
  (client/api-request
    {:method "PATCH",
     :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudOrgpolicyV2CustomConstraint}))

(defn organizations-customConstraints-list
  "Retrieves all of the custom constraints that exist on a particular organization resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.customConstraints/list

parent <string> Required. The target Google Cloud resource that parents the set of custom constraints that will be returned from this call. Must be in one of the following forms: * `organizations/{organization_id}`

optional:
pageSize <integer> Size of the pages to be returned. This is currently unsupported and will be ignored. The server may at any point start using this field to limit page size."
  ([parent] (organizations-customConstraints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://orgpolicy.googleapis.com/v2/{+parent}/customConstraints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-customConstraints-delete
  "Deletes a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.customConstraints/delete

name <string> Required. Name of the custom constraint to delete. See the custom constraint entry for naming rules."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-customConstraints-create
  "Creates a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the organization does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the constraint already exists on the given organization.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.customConstraints/create

parent <string> Required. Must be in the following form: * `organizations/{organization_id}`
GoogleCloudOrgpolicyV2CustomConstraint:
{:resourceTypes [string],
 :condition string,
 :description string,
 :methodTypes
 [[METHOD_TYPE_UNSPECIFIED
   CREATE
   UPDATE
   DELETE
   REMOVE_GRANT
   GOVERN_TAGS]],
 :actionType [ACTION_TYPE_UNSPECIFIED ALLOW DENY],
 :updateTime string,
 :name string,
 :displayName string}"
  [parent GoogleCloudOrgpolicyV2CustomConstraint]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://orgpolicy.googleapis.com/v2/{+parent}/customConstraints",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudOrgpolicyV2CustomConstraint}))

(defn organizations-constraints-list
  "Lists constraints that could be applied on the specified resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.constraints/list

parent <string> Required. The Google Cloud resource that parents the constraint. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
pageSize <integer> Size of the pages to be returned. This is currently unsupported and will be ignored. The server may at any point start using this field to limit page size."
  ([parent] (organizations-constraints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://orgpolicy.googleapis.com/v2/{+parent}/constraints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-policies-get
  "Gets a policy on a resource. If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used with `UpdatePolicy()` to update a policy during read-modify-write.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.policies/get

name <string> Required. Resource name of the policy. See Policy for naming requirements."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-policies-patch
  "Updates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the policy Note: the supplied policy will perform a full overwrite of all fields.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.policies/patch

name <string> Immutable. The resource name of the policy. Must be one of the following forms, where `constraint_name` is the name of the constraint which this policy configures: * `projects/{project_number}/policies/{constraint_name}` * `folders/{folder_id}/policies/{constraint_name}` * `organizations/{organization_id}/policies/{constraint_name}` For example, `projects/123/policies/compute.disableSerialPortAccess`. Note: `projects/{project_id}/policies/{constraint_name}` is also an acceptable name for API requests, but responses will return the name using the equivalent project number.
GoogleCloudOrgpolicyV2Policy:
{:etag string,
 :name string,
 :spec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string},
 :alternate
 {:launch string,
  :spec
  {:reset boolean,
   :inheritFromParent boolean,
   :rules
   [{:enforce boolean,
     :allowAll boolean,
     :denyAll boolean,
     :condition
     {:location string,
      :expression string,
      :title string,
      :description string},
     :values {:deniedValues [string], :allowedValues [string]}}],
   :updateTime string,
   :etag string}},
 :dryRunSpec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string}}

optional:
updateMask <string> Field mask used to specify the fields to be overwritten in the policy by the set. The fields specified in the update_mask are relative to the policy, not the full request."
  ([name GoogleCloudOrgpolicyV2Policy]
    (organizations-policies-patch
      name
      GoogleCloudOrgpolicyV2Policy
      nil))
  ([name GoogleCloudOrgpolicyV2Policy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudOrgpolicyV2Policy})))

(defn organizations-policies-getEffectivePolicy
  "Gets the effective policy on a resource. This is the result of merging policies in the resource hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition` set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.policies/getEffectivePolicy

name <string> Required. The effective policy to compute. See Policy for naming requirements."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://orgpolicy.googleapis.com/v2/{+name}:getEffectivePolicy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-policies-create
  "Creates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy already exists on the given Google Cloud resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.policies/create

parent <string> Required. The Google Cloud resource that will parent the new policy. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`
GoogleCloudOrgpolicyV2Policy:
{:etag string,
 :name string,
 :spec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string},
 :alternate
 {:launch string,
  :spec
  {:reset boolean,
   :inheritFromParent boolean,
   :rules
   [{:enforce boolean,
     :allowAll boolean,
     :denyAll boolean,
     :condition
     {:location string,
      :expression string,
      :title string,
      :description string},
     :values {:deniedValues [string], :allowedValues [string]}}],
   :updateTime string,
   :etag string}},
 :dryRunSpec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string}}"
  [parent GoogleCloudOrgpolicyV2Policy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://orgpolicy.googleapis.com/v2/{+parent}/policies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudOrgpolicyV2Policy}))

(defn organizations-policies-delete
  "Deletes a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or organization policy does not exist.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.policies/delete

name <string> Required. Name of the policy to delete. See the policy entry for naming rules.

optional:
etag <string> Optional. The current etag of policy. If an etag is provided and does not match the current etag of the policy, deletion will be blocked and an ABORTED error will be returned."
  ([name] (organizations-policies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-policies-list
  "Retrieves all of the policies that exist on a particular resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/organizations.policies/list

parent <string> Required. The target Google Cloud resource that parents the set of constraints and policies that will be returned from this call. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
pageSize <integer> Size of the pages to be returned. This is currently unsupported and will be ignored. The server may at any point start using this field to limit page size."
  ([parent] (organizations-policies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://orgpolicy.googleapis.com/v2/{+parent}/policies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-policies-get
  "Gets a policy on a resource. If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used with `UpdatePolicy()` to update a policy during read-modify-write.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/folders.policies/get

name <string> Required. Resource name of the policy. See Policy for naming requirements."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-policies-getEffectivePolicy
  "Gets the effective policy on a resource. This is the result of merging policies in the resource hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition` set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/folders.policies/getEffectivePolicy

name <string> Required. The effective policy to compute. See Policy for naming requirements."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://orgpolicy.googleapis.com/v2/{+name}:getEffectivePolicy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-policies-create
  "Creates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy already exists on the given Google Cloud resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/folders.policies/create

parent <string> Required. The Google Cloud resource that will parent the new policy. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`
GoogleCloudOrgpolicyV2Policy:
{:etag string,
 :name string,
 :spec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string},
 :alternate
 {:launch string,
  :spec
  {:reset boolean,
   :inheritFromParent boolean,
   :rules
   [{:enforce boolean,
     :allowAll boolean,
     :denyAll boolean,
     :condition
     {:location string,
      :expression string,
      :title string,
      :description string},
     :values {:deniedValues [string], :allowedValues [string]}}],
   :updateTime string,
   :etag string}},
 :dryRunSpec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string}}"
  [parent GoogleCloudOrgpolicyV2Policy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://orgpolicy.googleapis.com/v2/{+parent}/policies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudOrgpolicyV2Policy}))

(defn folders-policies-patch
  "Updates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the policy Note: the supplied policy will perform a full overwrite of all fields.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/folders.policies/patch

name <string> Immutable. The resource name of the policy. Must be one of the following forms, where `constraint_name` is the name of the constraint which this policy configures: * `projects/{project_number}/policies/{constraint_name}` * `folders/{folder_id}/policies/{constraint_name}` * `organizations/{organization_id}/policies/{constraint_name}` For example, `projects/123/policies/compute.disableSerialPortAccess`. Note: `projects/{project_id}/policies/{constraint_name}` is also an acceptable name for API requests, but responses will return the name using the equivalent project number.
GoogleCloudOrgpolicyV2Policy:
{:etag string,
 :name string,
 :spec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string},
 :alternate
 {:launch string,
  :spec
  {:reset boolean,
   :inheritFromParent boolean,
   :rules
   [{:enforce boolean,
     :allowAll boolean,
     :denyAll boolean,
     :condition
     {:location string,
      :expression string,
      :title string,
      :description string},
     :values {:deniedValues [string], :allowedValues [string]}}],
   :updateTime string,
   :etag string}},
 :dryRunSpec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string}}

optional:
updateMask <string> Field mask used to specify the fields to be overwritten in the policy by the set. The fields specified in the update_mask are relative to the policy, not the full request."
  ([name GoogleCloudOrgpolicyV2Policy]
    (folders-policies-patch name GoogleCloudOrgpolicyV2Policy nil))
  ([name GoogleCloudOrgpolicyV2Policy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudOrgpolicyV2Policy})))

(defn folders-policies-delete
  "Deletes a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or organization policy does not exist.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/folders.policies/delete

name <string> Required. Name of the policy to delete. See the policy entry for naming rules.

optional:
etag <string> Optional. The current etag of policy. If an etag is provided and does not match the current etag of the policy, deletion will be blocked and an ABORTED error will be returned."
  ([name] (folders-policies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-policies-list
  "Retrieves all of the policies that exist on a particular resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/folders.policies/list

parent <string> Required. The target Google Cloud resource that parents the set of constraints and policies that will be returned from this call. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
pageSize <integer> Size of the pages to be returned. This is currently unsupported and will be ignored. The server may at any point start using this field to limit page size."
  ([parent] (folders-policies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://orgpolicy.googleapis.com/v2/{+parent}/policies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-constraints-list
  "Lists constraints that could be applied on the specified resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/folders.constraints/list

parent <string> Required. The Google Cloud resource that parents the constraint. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
pageSize <integer> Size of the pages to be returned. This is currently unsupported and will be ignored. The server may at any point start using this field to limit page size."
  ([parent] (folders-constraints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://orgpolicy.googleapis.com/v2/{+parent}/constraints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-policies-patch
  "Updates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the policy Note: the supplied policy will perform a full overwrite of all fields.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/projects.policies/patch

name <string> Immutable. The resource name of the policy. Must be one of the following forms, where `constraint_name` is the name of the constraint which this policy configures: * `projects/{project_number}/policies/{constraint_name}` * `folders/{folder_id}/policies/{constraint_name}` * `organizations/{organization_id}/policies/{constraint_name}` For example, `projects/123/policies/compute.disableSerialPortAccess`. Note: `projects/{project_id}/policies/{constraint_name}` is also an acceptable name for API requests, but responses will return the name using the equivalent project number.
GoogleCloudOrgpolicyV2Policy:
{:etag string,
 :name string,
 :spec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string},
 :alternate
 {:launch string,
  :spec
  {:reset boolean,
   :inheritFromParent boolean,
   :rules
   [{:enforce boolean,
     :allowAll boolean,
     :denyAll boolean,
     :condition
     {:location string,
      :expression string,
      :title string,
      :description string},
     :values {:deniedValues [string], :allowedValues [string]}}],
   :updateTime string,
   :etag string}},
 :dryRunSpec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string}}

optional:
updateMask <string> Field mask used to specify the fields to be overwritten in the policy by the set. The fields specified in the update_mask are relative to the policy, not the full request."
  ([name GoogleCloudOrgpolicyV2Policy]
    (projects-policies-patch name GoogleCloudOrgpolicyV2Policy nil))
  ([name GoogleCloudOrgpolicyV2Policy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudOrgpolicyV2Policy})))

(defn projects-policies-getEffectivePolicy
  "Gets the effective policy on a resource. This is the result of merging policies in the resource hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition` set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/projects.policies/getEffectivePolicy

name <string> Required. The effective policy to compute. See Policy for naming requirements."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://orgpolicy.googleapis.com/v2/{+name}:getEffectivePolicy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-policies-delete
  "Deletes a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or organization policy does not exist.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/projects.policies/delete

name <string> Required. Name of the policy to delete. See the policy entry for naming rules.

optional:
etag <string> Optional. The current etag of policy. If an etag is provided and does not match the current etag of the policy, deletion will be blocked and an ABORTED error will be returned."
  ([name] (projects-policies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-policies-create
  "Creates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy already exists on the given Google Cloud resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/projects.policies/create

parent <string> Required. The Google Cloud resource that will parent the new policy. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`
GoogleCloudOrgpolicyV2Policy:
{:etag string,
 :name string,
 :spec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string},
 :alternate
 {:launch string,
  :spec
  {:reset boolean,
   :inheritFromParent boolean,
   :rules
   [{:enforce boolean,
     :allowAll boolean,
     :denyAll boolean,
     :condition
     {:location string,
      :expression string,
      :title string,
      :description string},
     :values {:deniedValues [string], :allowedValues [string]}}],
   :updateTime string,
   :etag string}},
 :dryRunSpec
 {:reset boolean,
  :inheritFromParent boolean,
  :rules
  [{:enforce boolean,
    :allowAll boolean,
    :denyAll boolean,
    :condition
    {:location string,
     :expression string,
     :title string,
     :description string},
    :values {:deniedValues [string], :allowedValues [string]}}],
  :updateTime string,
  :etag string}}"
  [parent GoogleCloudOrgpolicyV2Policy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://orgpolicy.googleapis.com/v2/{+parent}/policies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudOrgpolicyV2Policy}))

(defn projects-policies-list
  "Retrieves all of the policies that exist on a particular resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/projects.policies/list

parent <string> Required. The target Google Cloud resource that parents the set of constraints and policies that will be returned from this call. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
pageSize <integer> Size of the pages to be returned. This is currently unsupported and will be ignored. The server may at any point start using this field to limit page size."
  ([parent] (projects-policies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://orgpolicy.googleapis.com/v2/{+parent}/policies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-policies-get
  "Gets a policy on a resource. If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used with `UpdatePolicy()` to update a policy during read-modify-write.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/projects.policies/get

name <string> Required. Resource name of the policy. See Policy for naming requirements."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://orgpolicy.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-constraints-list
  "Lists constraints that could be applied on the specified resource.
https://cloud.google.com/resource-manager/docs/reference/orgpolicy/rest/v2/projects.constraints/list

parent <string> Required. The Google Cloud resource that parents the constraint. Must be in one of the following forms: * `projects/{project_number}` * `projects/{project_id}` * `folders/{folder_id}` * `organizations/{organization_id}`

optional:
pageSize <integer> Size of the pages to be returned. This is currently unsupported and will be ignored. The server may at any point start using this field to limit page size."
  ([parent] (projects-constraints-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://orgpolicy.googleapis.com/v2/{+parent}/constraints",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

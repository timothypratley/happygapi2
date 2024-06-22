(ns happygapi2.bigquerydatapolicy
  "BigQuery Data Policy API
Allows users to manage BigQuery data policies.
See: https://cloud.google.com/bigquery/docs/column-data-masking"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-dataPolicies-get
  "Gets the data policy specified by its resource name.
https://cloud.google.com/bigquery/docs/column-data-masking

name <string> Required. Resource name of the requested data policy. Format is `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://bigquerydatapolicy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataPolicies-setIamPolicy
  "Sets the IAM policy for the specified data policy.
https://cloud.google.com/bigquery/docs/column-data-masking

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
     "https://bigquerydatapolicy.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-dataPolicies-patch
  "Updates the metadata for an existing data policy. The target data policy can be specified by the resource name.
https://cloud.google.com/bigquery/docs/column-data-masking

name <string> Output only. Resource name of this data policy, in the format of `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`.
DataPolicy:
{:policyTag string,
 :dataMaskingPolicy
 {:predefinedExpression
  [PREDEFINED_EXPRESSION_UNSPECIFIED
   SHA256
   ALWAYS_NULL
   DEFAULT_MASKING_VALUE
   LAST_FOUR_CHARACTERS
   FIRST_FOUR_CHARACTERS
   EMAIL_MASK
   DATE_YEAR_MASK],
  :routine string},
 :name string,
 :dataPolicyType
 [DATA_POLICY_TYPE_UNSPECIFIED
  COLUMN_LEVEL_SECURITY_POLICY
  DATA_MASKING_POLICY],
 :dataPolicyId string}

optional:
updateMask <string> The update mask applies to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If not set, defaults to all of the fields that are allowed to update. Updates to the `name` and `dataPolicyId` fields are not allowed."
  ([name DataPolicy]
    (projects-locations-dataPolicies-patch name DataPolicy nil))
  ([name DataPolicy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://bigquerydatapolicy.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body DataPolicy})))

(defn projects-locations-dataPolicies-testIamPermissions
  "Returns the caller's permission on the specified data policy resource.
https://cloud.google.com/bigquery/docs/column-data-masking

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatapolicy.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-dataPolicies-create
  "Creates a new data policy under a project with the given `dataPolicyId` (used as the display name), policy tag, and data policy type.
https://cloud.google.com/bigquery/docs/column-data-masking

parent <string> Required. Resource name of the project that the data policy will belong to. The format is `projects/{project_number}/locations/{location_id}`.
DataPolicy:
{:policyTag string,
 :dataMaskingPolicy
 {:predefinedExpression
  [PREDEFINED_EXPRESSION_UNSPECIFIED
   SHA256
   ALWAYS_NULL
   DEFAULT_MASKING_VALUE
   LAST_FOUR_CHARACTERS
   FIRST_FOUR_CHARACTERS
   EMAIL_MASK
   DATE_YEAR_MASK],
  :routine string},
 :name string,
 :dataPolicyType
 [DATA_POLICY_TYPE_UNSPECIFIED
  COLUMN_LEVEL_SECURITY_POLICY
  DATA_MASKING_POLICY],
 :dataPolicyId string}"
  [parent DataPolicy]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatapolicy.googleapis.com/v1/{+parent}/dataPolicies",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body DataPolicy}))

(defn projects-locations-dataPolicies-delete
  "Deletes the data policy specified by its resource name.
https://cloud.google.com/bigquery/docs/column-data-masking

name <string> Required. Resource name of the data policy to delete. Format is `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://bigquerydatapolicy.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataPolicies-rename
  "Renames the id (display name) of the specified data policy.
https://cloud.google.com/bigquery/docs/column-data-masking

name <string> Required. Resource name of the data policy to rename. The format is `projects/{project_number}/locations/{location_id}/dataPolicies/{data_policy_id}`
RenameDataPolicyRequest:
{:newDataPolicyId string}"
  [name RenameDataPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatapolicy.googleapis.com/v1/{+name}:rename",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body RenameDataPolicyRequest}))

(defn projects-locations-dataPolicies-getIamPolicy
  "Gets the IAM policy for the specified data policy.
https://cloud.google.com/bigquery/docs/column-data-masking

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigquerydatapolicy.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigquery"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-locations-dataPolicies-list
  "List all of the data policies in the specified parent project.
https://cloud.google.com/bigquery/docs/column-data-masking

parent <string> Required. Resource name of the project for which to list data policies. Format is `projects/{project_number}/locations/{location_id}`.

optional:
pageSize <integer> The maximum number of data policies to return. Must be a value between 1 and 1000. If not set, defaults to 50.
filter <string> Filters the data policies by policy tags that they are associated with. Currently filter only supports \"policy_tag\" based filtering and OR based predicates. Sample filter can be \"policy_tag: projects/1/locations/us/taxonomies/2/policyTags/3\". You may also use wildcard such as \"policy_tag: projects/1/locations/us/taxonomies/2*\". Please note that OR predicates cannot be used with wildcard filters."
  ([parent] (projects-locations-dataPolicies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigquerydatapolicy.googleapis.com/v1/{+parent}/dataPolicies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigquery"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(ns happygapi2.dataplex
  "Cloud Dataplex API
Dataplex API is used to manage the lifecycle of data lakes.
See: https://cloud.google.com/dataplex/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-lookupEntry
  "Looks up a single entry.
https://cloud.google.com/dataplex/docs

name <string> Required. The project to which the request should be attributed in the following form: projects/{project}/locations/{location}.

optional:
view <string> Optional. View for controlling which parts of an entry are to be returned.
aspectTypes <string> Optional. Limits the aspects returned to the provided aspect types. Only works if the CUSTOM view is selected.
paths <string> Optional. Limits the aspects returned to those associated with the provided paths within the Entry. Only works if the CUSTOM view is selected.
entry <string> Required. The resource name of the Entry: projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}."
  ([name] (projects-locations-lookupEntry name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+name}:lookupEntry",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-searchEntries
  "Searches for entries matching given query and scope.
https://cloud.google.com/dataplex/docs

name <string> Required. The project to which the request should be attributed in the following form: projects/{project}/locations/{location}.

optional:
query <string> Required. The query against which entries in scope should be matched.
pageSize <integer> Optional. Pagination.
orderBy <string> Optional. Ordering of the results. Supported options to be added later.
scope <string> Optional. The scope under which the search should be operating. Should either be organizations/ or projects/. If left unspecified, it will default to the organization where the project provided in name is located."
  ([name] (projects-locations-searchEntries name nil))
  ([name optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+name}:searchEntries",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/dataplex/docs

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like \"displayName=tokyo\", and is documented in more detail in AIP-160 (https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/dataplex/docs

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-create
  "Creates an EntryGroup
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the entryGroup, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.
GoogleCloudDataplexV1EntryGroup:
{:description string,
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :transferStatus
 [TRANSFER_STATUS_UNSPECIFIED
  TRANSFER_STATUS_MIGRATED
  TRANSFER_STATUS_TRANSFERRED]}

optional:
entryGroupId <string> Required. EntryGroup identifier.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1EntryGroup]
    (projects-locations-entryGroups-create
      parent
      GoogleCloudDataplexV1EntryGroup
      nil))
  ([parent GoogleCloudDataplexV1EntryGroup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entryGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1EntryGroup})))

(defn projects-locations-entryGroups-patch
  "Updates a EntryGroup resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the EntryGroup, of the form: projects/{project_number}/locations/{location_id}/entryGroups/{entry_group_id}.
GoogleCloudDataplexV1EntryGroup:
{:description string,
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :transferStatus
 [TRANSFER_STATUS_UNSPECIFIED
  TRANSFER_STATUS_MIGRATED
  TRANSFER_STATUS_TRANSFERRED]}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1EntryGroup]
    (projects-locations-entryGroups-patch
      name
      GoogleCloudDataplexV1EntryGroup
      nil))
  ([name GoogleCloudDataplexV1EntryGroup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1EntryGroup})))

(defn projects-locations-entryGroups-delete
  "Deletes a EntryGroup resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the EntryGroup: projects/{project_number}/locations/{location_id}/entryGroups/{entry_group_id}.

optional:
etag <string> Optional. If the client provided etag value does not match the current etag value, the DeleteEntryGroupRequest method returns an ABORTED error response"
  ([name] (projects-locations-entryGroups-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-list
  "Lists EntryGroup resources in a project and location.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the entryGroup location, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.

optional:
pageSize <integer> Optional. Maximum number of EntryGroups to return. The service may return fewer than this value. If unspecified, at most 10 EntryGroups will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-entryGroups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entryGroups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-get
  "Retrieves a EntryGroup resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the EntryGroup: projects/{project_number}/locations/{location_id}/entryGroups/{entry_group_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-entryGroups-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-entryGroups-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-entryGroups-entries-create
  "Creates an Entry.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent Entry Group: projects/{project}/locations/{location}/entryGroups/{entry_group}.
GoogleCloudDataplexV1Entry:
{:name string,
 :entryType string,
 :createTime string,
 :updateTime string,
 :aspects object,
 :parentEntry string,
 :fullyQualifiedName string,
 :entrySource
 {:description string,
  :labels object,
  :system string,
  :displayName string,
  :createTime string,
  :updateTime string,
  :ancestors [{:name string, :type string}],
  :resource string,
  :location string,
  :platform string}}

optional:
entryId <string> Required. Entry identifier. It has to be unique within an Entry Group.Entries corresponding to Google Cloud resources use Entry ID format based on Full Resource Names (https://cloud.google.com/apis/design/resource_names#full_resource_name). The format is a Full Resource Name of the resource without the prefix double slashes in the API Service Name part of Full Resource Name. This allows retrieval of entries using their associated resource name.For example if the Full Resource Name of a resource is //library.googleapis.com/shelves/shelf1/books/book2, then the suggested entry_id is library.googleapis.com/shelves/shelf1/books/book2.It is also suggested to follow the same convention for entries corresponding to resources from other providers or systems than Google Cloud.The maximum size of the field is 4000 characters."
  ([parent GoogleCloudDataplexV1Entry]
    (projects-locations-entryGroups-entries-create
      parent
      GoogleCloudDataplexV1Entry
      nil))
  ([parent GoogleCloudDataplexV1Entry optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Entry})))

(defn projects-locations-entryGroups-entries-patch
  "Updates an Entry.
https://cloud.google.com/dataplex/docs

name <string> Identifier. The relative resource name of the Entry, of the form: projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}.
GoogleCloudDataplexV1Entry:
{:name string,
 :entryType string,
 :createTime string,
 :updateTime string,
 :aspects object,
 :parentEntry string,
 :fullyQualifiedName string,
 :entrySource
 {:description string,
  :labels object,
  :system string,
  :displayName string,
  :createTime string,
  :updateTime string,
  :ancestors [{:name string, :type string}],
  :resource string,
  :location string,
  :platform string}}

optional:
updateMask <string> Optional. Mask of fields to update. To update Aspects, the update_mask must contain the value \"aspects\".If the update_mask is empty, all modifiable fields present in the request will be updated.
allowMissing <boolean> Optional. If set to true and the entry does not exist, it will be created.
deleteMissingAspects <boolean> Optional. If set to true and the aspect_keys specify aspect ranges, any existing aspects from that range not provided in the request will be deleted.
aspectKeys <string> Optional. The map keys of the Aspects which should be modified. Supports the following syntaxes: * - matches aspect on given type and empty path * @path - matches aspect on given type and specified path * * - matches aspects on given type for all paths * *@path - matches aspects of all types on the given pathExisting aspects matching the syntax will not be removed unless delete_missing_aspects is set to true.If this field is left empty, it will be treated as specifying exactly those Aspects present in the request."
  ([name GoogleCloudDataplexV1Entry]
    (projects-locations-entryGroups-entries-patch
      name
      GoogleCloudDataplexV1Entry
      nil))
  ([name GoogleCloudDataplexV1Entry optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Entry})))

(defn projects-locations-entryGroups-entries-delete
  "Deletes an Entry.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the Entry: projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryGroups-entries-list
  "Lists entries within an entry group.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent Entry Group: projects/{project}/locations/{location}/entryGroups/{entry_group}.

optional:
pageSize <integer> 
filter <string> Optional. A filter on the entries to return. Filters are case-sensitive. The request can be filtered by the following fields: entry_type, entry_source.display_name. The comparison operators are =, !=, <, >, <=, >= (strings are compared according to lexical order) The logical operators AND, OR, NOT can be used in the filter. Wildcard \"*\" can be used, but for entry_type the full project id or number needs to be provided. Example filter expressions: \"entry_source.display_name=AnExampleDisplayName\" \"entry_type=projects/example-project/locations/global/entryTypes/example-entry_type\" \"entry_type=projects/example-project/locations/us/entryTypes/a* OR entry_type=projects/another-project/locations/*\" \"NOT entry_source.display_name=AnotherExampleDisplayName\""
  ([parent] (projects-locations-entryGroups-entries-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entries",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryGroups-entries-get
  "Gets a single entry.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the Entry: projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}.

optional:
view <string> Optional. View for controlling which parts of an entry are to be returned.
aspectTypes <string> Optional. Limits the aspects returned to the provided aspect types. Only works if the CUSTOM view is selected.
paths <string> Optional. Limits the aspects returned to those associated with the provided paths within the Entry. Only works if the CUSTOM view is selected."
  ([name] (projects-locations-entryGroups-entries-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-aspectTypes-create
  "Creates an AspectType
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the AspectType, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.
GoogleCloudDataplexV1AspectType:
{:description string,
 :labels object,
 :displayName string,
 :authorization {:alternateUsePermission string},
 :uid string,
 :name string,
 :metadataTemplate
 {:constraints {:required boolean},
  :index integer,
  :name string,
  :recordFields
  [{:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints {:required boolean},
      :index integer,
      :name string,
      :recordFields
      [{:constraints
        GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
        :index integer,
        :name string,
        :recordFields
        [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
        :type string,
        :typeId string,
        :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
        :typeRef string,
        :enumValues
        [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
        :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
        :annotations
        GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
      :type string,
      :typeId string,
      :arrayItems
      {:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
      :typeRef string,
      :enumValues [{:index integer, :name string, :deprecated string}],
      :mapItems
      {:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
      :annotations
      {:deprecated string,
       :displayName string,
       :description string,
       :displayOrder integer,
       :stringType string,
       :stringValues [string]}}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}}],
  :type string,
  :typeId string,
  :arrayItems
  {:constraints {:required boolean},
   :index integer,
   :name string,
   :recordFields
   [{:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}}],
   :type string,
   :typeId string,
   :arrayItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :typeRef string,
   :enumValues [{:index integer, :name string, :deprecated string}],
   :mapItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :annotations
   {:deprecated string,
    :displayName string,
    :description string,
    :displayOrder integer,
    :stringType string,
    :stringValues [string]}},
  :typeRef string,
  :enumValues [{:index integer, :name string, :deprecated string}],
  :mapItems
  {:constraints {:required boolean},
   :index integer,
   :name string,
   :recordFields
   [{:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}}],
   :type string,
   :typeId string,
   :arrayItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :typeRef string,
   :enumValues [{:index integer, :name string, :deprecated string}],
   :mapItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :annotations
   {:deprecated string,
    :displayName string,
    :description string,
    :displayOrder integer,
    :stringType string,
    :stringValues [string]}},
  :annotations
  {:deprecated string,
   :displayName string,
   :description string,
   :displayOrder integer,
   :stringType string,
   :stringValues [string]}},
 :createTime string,
 :etag string,
 :updateTime string,
 :transferStatus
 [TRANSFER_STATUS_UNSPECIFIED
  TRANSFER_STATUS_MIGRATED
  TRANSFER_STATUS_TRANSFERRED]}

optional:
aspectTypeId <string> Required. AspectType identifier.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1AspectType]
    (projects-locations-aspectTypes-create
      parent
      GoogleCloudDataplexV1AspectType
      nil))
  ([parent GoogleCloudDataplexV1AspectType optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/aspectTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1AspectType})))

(defn projects-locations-aspectTypes-patch
  "Updates a AspectType resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the AspectType, of the form: projects/{project_number}/locations/{location_id}/aspectTypes/{aspect_type_id}.
GoogleCloudDataplexV1AspectType:
{:description string,
 :labels object,
 :displayName string,
 :authorization {:alternateUsePermission string},
 :uid string,
 :name string,
 :metadataTemplate
 {:constraints {:required boolean},
  :index integer,
  :name string,
  :recordFields
  [{:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints {:required boolean},
      :index integer,
      :name string,
      :recordFields
      [{:constraints
        GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
        :index integer,
        :name string,
        :recordFields
        [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
        :type string,
        :typeId string,
        :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
        :typeRef string,
        :enumValues
        [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
        :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
        :annotations
        GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
      :type string,
      :typeId string,
      :arrayItems
      {:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
      :typeRef string,
      :enumValues [{:index integer, :name string, :deprecated string}],
      :mapItems
      {:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
      :annotations
      {:deprecated string,
       :displayName string,
       :description string,
       :displayOrder integer,
       :stringType string,
       :stringValues [string]}}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}}],
  :type string,
  :typeId string,
  :arrayItems
  {:constraints {:required boolean},
   :index integer,
   :name string,
   :recordFields
   [{:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}}],
   :type string,
   :typeId string,
   :arrayItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :typeRef string,
   :enumValues [{:index integer, :name string, :deprecated string}],
   :mapItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :annotations
   {:deprecated string,
    :displayName string,
    :description string,
    :displayOrder integer,
    :stringType string,
    :stringValues [string]}},
  :typeRef string,
  :enumValues [{:index integer, :name string, :deprecated string}],
  :mapItems
  {:constraints {:required boolean},
   :index integer,
   :name string,
   :recordFields
   [{:constraints {:required boolean},
     :index integer,
     :name string,
     :recordFields
     [{:constraints
       GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
       :index integer,
       :name string,
       :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
       :type string,
       :typeId string,
       :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :typeRef string,
       :enumValues
       [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
       :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
       :annotations
       GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
     :type string,
     :typeId string,
     :arrayItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :typeRef string,
     :enumValues [{:index integer, :name string, :deprecated string}],
     :mapItems
     {:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
     :annotations
     {:deprecated string,
      :displayName string,
      :description string,
      :displayOrder integer,
      :stringType string,
      :stringValues [string]}}],
   :type string,
   :typeId string,
   :arrayItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :typeRef string,
   :enumValues [{:index integer, :name string, :deprecated string}],
   :mapItems
   {:constraints {:required boolean},
    :index integer,
    :name string,
    :recordFields
    [{:constraints
      GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
      :index integer,
      :name string,
      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
      :type string,
      :typeId string,
      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :typeRef string,
      :enumValues
      [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
      :annotations
      GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations}],
    :type string,
    :typeId string,
    :arrayItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :typeRef string,
    :enumValues [{:index integer, :name string, :deprecated string}],
    :mapItems
    {:constraints
     GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
     :index integer,
     :name string,
     :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
     :type string,
     :typeId string,
     :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :typeRef string,
     :enumValues
     [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
     :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
     :annotations
     GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
    :annotations
    {:deprecated string,
     :displayName string,
     :description string,
     :displayOrder integer,
     :stringType string,
     :stringValues [string]}},
   :annotations
   {:deprecated string,
    :displayName string,
    :description string,
    :displayOrder integer,
    :stringType string,
    :stringValues [string]}},
  :annotations
  {:deprecated string,
   :displayName string,
   :description string,
   :displayOrder integer,
   :stringType string,
   :stringValues [string]}},
 :createTime string,
 :etag string,
 :updateTime string,
 :transferStatus
 [TRANSFER_STATUS_UNSPECIFIED
  TRANSFER_STATUS_MIGRATED
  TRANSFER_STATUS_TRANSFERRED]}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1AspectType]
    (projects-locations-aspectTypes-patch
      name
      GoogleCloudDataplexV1AspectType
      nil))
  ([name GoogleCloudDataplexV1AspectType optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1AspectType})))

(defn projects-locations-aspectTypes-delete
  "Deletes a AspectType resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the AspectType: projects/{project_number}/locations/{location_id}/aspectTypes/{aspect_type_id}.

optional:
etag <string> Optional. If the client provided etag value does not match the current etag value, the DeleteAspectTypeRequest method returns an ABORTED error response"
  ([name] (projects-locations-aspectTypes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-aspectTypes-list
  "Lists AspectType resources in a project and location.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the AspectType location, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.

optional:
pageSize <integer> Optional. Maximum number of AspectTypes to return. The service may return fewer than this value. If unspecified, at most 10 AspectTypes will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request. Filters are case-sensitive. The following formats are supported:labels.key1 = \"value1\" labels:key1 name = \"value\" These restrictions can be coinjoined with AND, OR and NOT conjunctions.
orderBy <string> Optional. Order by fields (name or create_time) for the result. If not specified, the ordering is undefined."
  ([parent] (projects-locations-aspectTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/aspectTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-aspectTypes-get
  "Retrieves a AspectType resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the AspectType: projects/{project_number}/locations/{location_id}/aspectTypes/{aspect_type_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-aspectTypes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-aspectTypes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-aspectTypes-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-aspectTypes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-dataScans-get
  "Gets a DataScan resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the dataScan: projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where project refers to a project_id or project_number and location_id refers to a GCP region.

optional:
view <string> Optional. Select the DataScan view to return. Defaults to BASIC."
  ([name] (projects-locations-dataScans-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataScans-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-dataScans-run
  "Runs an on-demand execution of a DataScan
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the DataScan: projects/{project}/locations/{location_id}/dataScans/{data_scan_id}. where project refers to a project_id or project_number and location_id refers to a GCP region.Only OnDemand data scans are allowed.
GoogleCloudDataplexV1RunDataScanRequest:
object"
  [name GoogleCloudDataplexV1RunDataScanRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}:run",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDataplexV1RunDataScanRequest}))

(defn projects-locations-dataScans-patch
  "Updates a DataScan resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the scan, of the form: projects/{project}/locations/{location_id}/dataScans/{datascan_id}, where project refers to a project_id or project_number and location_id refers to a GCP region.
GoogleCloudDataplexV1DataScan:
{:description string,
 :labels object,
 :displayName string,
 :executionStatus
 {:latestJobStartTime string,
  :latestJobEndTime string,
  :latestJobCreateTime string},
 :uid string,
 :name string,
 :dataProfileResult
 {:rowCount string,
  :profile
  {:fields
   [{:name string,
     :type string,
     :mode string,
     :profile
     {:nullRatio number,
      :distinctRatio number,
      :topNValues
      [GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoTopNValue],
      :stringProfile
      GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoStringFieldInfo,
      :integerProfile
      GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoIntegerFieldInfo,
      :doubleProfile
      GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoDoubleFieldInfo}}]},
  :scannedData
  {:incrementalField {:field string, :start string, :end string}},
  :postScanActionsResult
  {:bigqueryExportResult
   {:state [STATE_UNSPECIFIED SUCCEEDED FAILED SKIPPED],
    :message string}}},
 :createTime string,
 :executionSpec
 {:trigger {:onDemand object, :schedule {:cron string}},
  :field string},
 :type [DATA_SCAN_TYPE_UNSPECIFIED DATA_QUALITY DATA_PROFILE],
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :dataProfileSpec
 {:samplingPercent number,
  :rowFilter string,
  :postScanActions {:bigqueryExport {:resultsTable string}},
  :includeFields {:fieldNames [string]},
  :excludeFields {:fieldNames [string]}},
 :dataQualitySpec
 {:rules
  [{:description string,
    :rangeExpectation
    {:minValue string,
     :maxValue string,
     :strictMinEnabled boolean,
     :strictMaxEnabled boolean},
    :sqlAssertion {:sqlStatement string},
    :name string,
    :ignoreNull boolean,
    :statisticRangeExpectation
    {:statistic [STATISTIC_UNDEFINED MEAN MIN MAX],
     :minValue string,
     :maxValue string,
     :strictMinEnabled boolean,
     :strictMaxEnabled boolean},
    :setExpectation {:values [string]},
    :threshold number,
    :column string,
    :rowConditionExpectation {:sqlExpression string},
    :tableConditionExpectation {:sqlExpression string},
    :dimension string,
    :uniquenessExpectation object,
    :regexExpectation {:regex string},
    :nonNullExpectation object}],
  :samplingPercent number,
  :rowFilter string,
  :postScanActions
  {:bigqueryExport {:resultsTable string},
   :notificationReport
   {:recipients {:emails [string]},
    :scoreThresholdTrigger {:scoreThreshold number},
    :jobFailureTrigger object,
    :jobEndTrigger object}}},
 :dataQualityResult
 {:passed boolean,
  :score number,
  :dimensions
  [{:dimension {:name string}, :passed boolean, :score number}],
  :columns [{:column string, :score number}],
  :rules
  [{:rule
    {:description string,
     :rangeExpectation
     {:minValue string,
      :maxValue string,
      :strictMinEnabled boolean,
      :strictMaxEnabled boolean},
     :sqlAssertion {:sqlStatement string},
     :name string,
     :ignoreNull boolean,
     :statisticRangeExpectation
     {:statistic [STATISTIC_UNDEFINED MEAN MIN MAX],
      :minValue string,
      :maxValue string,
      :strictMinEnabled boolean,
      :strictMaxEnabled boolean},
     :setExpectation {:values [string]},
     :threshold number,
     :column string,
     :rowConditionExpectation {:sqlExpression string},
     :tableConditionExpectation {:sqlExpression string},
     :dimension string,
     :uniquenessExpectation object,
     :regexExpectation {:regex string},
     :nonNullExpectation object},
    :passed boolean,
    :evaluatedCount string,
    :passedCount string,
    :nullCount string,
    :passRatio number,
    :failingRowsQuery string,
    :assertionRowCount string}],
  :rowCount string,
  :scannedData
  {:incrementalField {:field string, :start string, :end string}},
  :postScanActionsResult
  {:bigqueryExportResult
   {:state [STATE_UNSPECIFIED SUCCEEDED FAILED SKIPPED],
    :message string}}},
 :data {:entity string, :resource string}}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1DataScan]
    (projects-locations-dataScans-patch
      name
      GoogleCloudDataplexV1DataScan
      nil))
  ([name GoogleCloudDataplexV1DataScan optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataScan})))

(defn projects-locations-dataScans-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-dataScans-generateDataQualityRules
  "Generates recommended data quality rules based on the results of a data profiling scan.Use the recommendations to build rules for a data quality scan.
https://cloud.google.com/dataplex/docs

name <string> Required. The name must be one of the following: The name of a data scan with at least one successful, completed data profiling job The name of a successful, completed data profiling job (a data scan job where the job type is data profiling)
GoogleCloudDataplexV1GenerateDataQualityRulesRequest:
object"
  [name GoogleCloudDataplexV1GenerateDataQualityRulesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+name}:generateDataQualityRules",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDataplexV1GenerateDataQualityRulesRequest}))

(defn projects-locations-dataScans-create
  "Creates a DataScan resource.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent location: projects/{project}/locations/{location_id} where project refers to a project_id or project_number and location_id refers to a GCP region.
GoogleCloudDataplexV1DataScan:
{:description string,
 :labels object,
 :displayName string,
 :executionStatus
 {:latestJobStartTime string,
  :latestJobEndTime string,
  :latestJobCreateTime string},
 :uid string,
 :name string,
 :dataProfileResult
 {:rowCount string,
  :profile
  {:fields
   [{:name string,
     :type string,
     :mode string,
     :profile
     {:nullRatio number,
      :distinctRatio number,
      :topNValues
      [GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoTopNValue],
      :stringProfile
      GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoStringFieldInfo,
      :integerProfile
      GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoIntegerFieldInfo,
      :doubleProfile
      GoogleCloudDataplexV1DataProfileResultProfileFieldProfileInfoDoubleFieldInfo}}]},
  :scannedData
  {:incrementalField {:field string, :start string, :end string}},
  :postScanActionsResult
  {:bigqueryExportResult
   {:state [STATE_UNSPECIFIED SUCCEEDED FAILED SKIPPED],
    :message string}}},
 :createTime string,
 :executionSpec
 {:trigger {:onDemand object, :schedule {:cron string}},
  :field string},
 :type [DATA_SCAN_TYPE_UNSPECIFIED DATA_QUALITY DATA_PROFILE],
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :dataProfileSpec
 {:samplingPercent number,
  :rowFilter string,
  :postScanActions {:bigqueryExport {:resultsTable string}},
  :includeFields {:fieldNames [string]},
  :excludeFields {:fieldNames [string]}},
 :dataQualitySpec
 {:rules
  [{:description string,
    :rangeExpectation
    {:minValue string,
     :maxValue string,
     :strictMinEnabled boolean,
     :strictMaxEnabled boolean},
    :sqlAssertion {:sqlStatement string},
    :name string,
    :ignoreNull boolean,
    :statisticRangeExpectation
    {:statistic [STATISTIC_UNDEFINED MEAN MIN MAX],
     :minValue string,
     :maxValue string,
     :strictMinEnabled boolean,
     :strictMaxEnabled boolean},
    :setExpectation {:values [string]},
    :threshold number,
    :column string,
    :rowConditionExpectation {:sqlExpression string},
    :tableConditionExpectation {:sqlExpression string},
    :dimension string,
    :uniquenessExpectation object,
    :regexExpectation {:regex string},
    :nonNullExpectation object}],
  :samplingPercent number,
  :rowFilter string,
  :postScanActions
  {:bigqueryExport {:resultsTable string},
   :notificationReport
   {:recipients {:emails [string]},
    :scoreThresholdTrigger {:scoreThreshold number},
    :jobFailureTrigger object,
    :jobEndTrigger object}}},
 :dataQualityResult
 {:passed boolean,
  :score number,
  :dimensions
  [{:dimension {:name string}, :passed boolean, :score number}],
  :columns [{:column string, :score number}],
  :rules
  [{:rule
    {:description string,
     :rangeExpectation
     {:minValue string,
      :maxValue string,
      :strictMinEnabled boolean,
      :strictMaxEnabled boolean},
     :sqlAssertion {:sqlStatement string},
     :name string,
     :ignoreNull boolean,
     :statisticRangeExpectation
     {:statistic [STATISTIC_UNDEFINED MEAN MIN MAX],
      :minValue string,
      :maxValue string,
      :strictMinEnabled boolean,
      :strictMaxEnabled boolean},
     :setExpectation {:values [string]},
     :threshold number,
     :column string,
     :rowConditionExpectation {:sqlExpression string},
     :tableConditionExpectation {:sqlExpression string},
     :dimension string,
     :uniquenessExpectation object,
     :regexExpectation {:regex string},
     :nonNullExpectation object},
    :passed boolean,
    :evaluatedCount string,
    :passedCount string,
    :nullCount string,
    :passRatio number,
    :failingRowsQuery string,
    :assertionRowCount string}],
  :rowCount string,
  :scannedData
  {:incrementalField {:field string, :start string, :end string}},
  :postScanActionsResult
  {:bigqueryExportResult
   {:state [STATE_UNSPECIFIED SUCCEEDED FAILED SKIPPED],
    :message string}}},
 :data {:entity string, :resource string}}

optional:
dataScanId <string> Required. DataScan identifier. Must contain only lowercase letters, numbers and hyphens. Must start with a letter. Must end with a number or a letter. Must be between 1-63 characters. Must be unique within the customer project / location.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1DataScan]
    (projects-locations-dataScans-create
      parent
      GoogleCloudDataplexV1DataScan
      nil))
  ([parent GoogleCloudDataplexV1DataScan optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/dataScans",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataScan})))

(defn projects-locations-dataScans-delete
  "Deletes a DataScan resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the dataScan: projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where project refers to a project_id or project_number and location_id refers to a GCP region."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataScans-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-dataScans-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataScans-list
  "Lists DataScans.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent location: projects/{project}/locations/{location_id} where project refers to a project_id or project_number and location_id refers to a GCP region.

optional:
pageSize <integer> Optional. Maximum number of dataScans to return. The service may return fewer than this value. If unspecified, at most 500 scans will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields (name or create_time) for the result. If not specified, the ordering is undefined."
  ([parent] (projects-locations-dataScans-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/dataScans",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataScans-jobs-get
  "Gets a DataScanJob resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the DataScanJob: projects/{project}/locations/{location_id}/dataScans/{data_scan_id}/jobs/{data_scan_job_id} where project refers to a project_id or project_number and location_id refers to a GCP region.

optional:
view <string> Optional. Select the DataScanJob view to return. Defaults to BASIC."
  ([name] (projects-locations-dataScans-jobs-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataScans-jobs-list
  "Lists DataScanJobs under the given DataScan.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent environment: projects/{project}/locations/{location_id}/dataScans/{data_scan_id} where project refers to a project_id or project_number and location_id refers to a GCP region.

optional:
pageSize <integer> Optional. Maximum number of DataScanJobs to return. The service may return fewer than this value. If unspecified, at most 10 DataScanJobs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. An expression for filtering the results of the ListDataScanJobs request.If unspecified, all datascan jobs will be returned. Multiple filters can be applied (with AND, OR logical operators). Filters are case-sensitive.Allowed fields are: start_time end_timestart_time and end_time expect RFC-3339 formatted strings (e.g. 2018-10-08T18:30:00-07:00).For instance, 'start_time > 2018-10-08T00:00:00.123456789Z AND end_time < 2018-10-09T00:00:00.123456789Z' limits results to DataScanJobs between specified start and end times."
  ([parent] (projects-locations-dataScans-jobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataScans-jobs-generateDataQualityRules
  "Generates recommended data quality rules based on the results of a data profiling scan.Use the recommendations to build rules for a data quality scan.
https://cloud.google.com/dataplex/docs

name <string> Required. The name must be one of the following: The name of a data scan with at least one successful, completed data profiling job The name of a successful, completed data profiling job (a data scan job where the job type is data profiling)
GoogleCloudDataplexV1GenerateDataQualityRulesRequest:
object"
  [name GoogleCloudDataplexV1GenerateDataQualityRulesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+name}:generateDataQualityRules",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDataplexV1GenerateDataQualityRulesRequest}))

(defn projects-locations-governanceRules-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-governanceRules-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-governanceRules-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-governanceRules-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-dataAttributeBindings-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-dataAttributeBindings-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-dataAttributeBindings-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataAttributeBindings-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-dataAttributeBindings-create
  "Create a DataAttributeBinding resource.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent data taxonomy projects/{project_number}/locations/{location_id}
GoogleCloudDataplexV1DataAttributeBinding:
{:description string,
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :paths [{:name string, :attributes [string]}],
 :etag string,
 :updateTime string,
 :resource string,
 :attributes [string]}

optional:
dataAttributeBindingId <string> Required. DataAttributeBinding identifier. * Must contain only lowercase letters, numbers and hyphens. * Must start with a letter. * Must be between 1-63 characters. * Must end with a number or a letter. * Must be unique within the Location.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1DataAttributeBinding]
    (projects-locations-dataAttributeBindings-create
      parent
      GoogleCloudDataplexV1DataAttributeBinding
      nil))
  ([parent GoogleCloudDataplexV1DataAttributeBinding optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/dataAttributeBindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataAttributeBinding})))

(defn projects-locations-dataAttributeBindings-patch
  "Updates a DataAttributeBinding resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the Data Attribute Binding, of the form: projects/{project_number}/locations/{location}/dataAttributeBindings/{data_attribute_binding_id}
GoogleCloudDataplexV1DataAttributeBinding:
{:description string,
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :paths [{:name string, :attributes [string]}],
 :etag string,
 :updateTime string,
 :resource string,
 :attributes [string]}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1DataAttributeBinding]
    (projects-locations-dataAttributeBindings-patch
      name
      GoogleCloudDataplexV1DataAttributeBinding
      nil))
  ([name GoogleCloudDataplexV1DataAttributeBinding optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataAttributeBinding})))

(defn projects-locations-dataAttributeBindings-delete
  "Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be deleted before the DataAttributeBinding can be deleted.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the DataAttributeBinding: projects/{project_number}/locations/{location_id}/dataAttributeBindings/{data_attribute_binding_id}

optional:
etag <string> Required. If the client provided etag value does not match the current etag value, the DeleteDataAttributeBindingRequest method returns an ABORTED error response. Etags must be used when calling the DeleteDataAttributeBinding."
  ([name] (projects-locations-dataAttributeBindings-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataAttributeBindings-list
  "Lists DataAttributeBinding resources in a project and location.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the Location: projects/{project_number}/locations/{location_id}

optional:
pageSize <integer> Optional. Maximum number of DataAttributeBindings to return. The service may return fewer than this value. If unspecified, at most 10 DataAttributeBindings will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request. Filter using resource: filter=resource:\"resource-name\" Filter using attribute: filter=attributes:\"attribute-name\" Filter using attribute in paths list: filter=paths.attributes:\"attribute-name\"
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-dataAttributeBindings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/dataAttributeBindings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataAttributeBindings-get
  "Retrieves a DataAttributeBinding resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the DataAttributeBinding: projects/{project_number}/locations/{location_id}/dataAttributeBindings/{data_attribute_binding_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataTaxonomies-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-dataTaxonomies-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-dataTaxonomies-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataTaxonomies-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-dataTaxonomies-create
  "Create a DataTaxonomy resource.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the data taxonomy location, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.
GoogleCloudDataplexV1DataTaxonomy:
{:description string,
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :attributeCount integer,
 :updateTime string,
 :classCount integer}

optional:
dataTaxonomyId <string> Required. DataTaxonomy identifier. * Must contain only lowercase letters, numbers and hyphens. * Must start with a letter. * Must be between 1-63 characters. * Must end with a number or a letter. * Must be unique within the Project.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1DataTaxonomy]
    (projects-locations-dataTaxonomies-create
      parent
      GoogleCloudDataplexV1DataTaxonomy
      nil))
  ([parent GoogleCloudDataplexV1DataTaxonomy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/dataTaxonomies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataTaxonomy})))

(defn projects-locations-dataTaxonomies-patch
  "Updates a DataTaxonomy resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the DataTaxonomy, of the form: projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}.
GoogleCloudDataplexV1DataTaxonomy:
{:description string,
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :attributeCount integer,
 :updateTime string,
 :classCount integer}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1DataTaxonomy]
    (projects-locations-dataTaxonomies-patch
      name
      GoogleCloudDataplexV1DataTaxonomy
      nil))
  ([name GoogleCloudDataplexV1DataTaxonomy optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataTaxonomy})))

(defn projects-locations-dataTaxonomies-delete
  "Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before the DataTaxonomy can be deleted.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the DataTaxonomy: projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}

optional:
etag <string> Optional. If the client provided etag value does not match the current etag value,the DeleteDataTaxonomy method returns an ABORTED error."
  ([name] (projects-locations-dataTaxonomies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataTaxonomies-list
  "Lists DataTaxonomy resources in a project and location.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the DataTaxonomy location, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.

optional:
pageSize <integer> Optional. Maximum number of DataTaxonomies to return. The service may return fewer than this value. If unspecified, at most 10 DataTaxonomies will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-dataTaxonomies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/dataTaxonomies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataTaxonomies-get
  "Retrieves a DataTaxonomy resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the DataTaxonomy: projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-dataTaxonomies-attributes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-dataTaxonomies-attributes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-dataTaxonomies-attributes-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataTaxonomies-attributes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-dataTaxonomies-attributes-create
  "Create a DataAttribute resource.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent data taxonomy projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}
GoogleCloudDataplexV1DataAttribute:
{:description string,
 :resourceAccessSpec
 {:readers [string], :writers [string], :owners [string]},
 :labels object,
 :dataAccessSpec {:readers [string]},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :attributeCount integer,
 :updateTime string,
 :parentId string}

optional:
dataAttributeId <string> Required. DataAttribute identifier. * Must contain only lowercase letters, numbers and hyphens. * Must start with a letter. * Must be between 1-63 characters. * Must end with a number or a letter. * Must be unique within the DataTaxonomy.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1DataAttribute]
    (projects-locations-dataTaxonomies-attributes-create
      parent
      GoogleCloudDataplexV1DataAttribute
      nil))
  ([parent GoogleCloudDataplexV1DataAttribute optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/attributes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataAttribute})))

(defn projects-locations-dataTaxonomies-attributes-patch
  "Updates a DataAttribute resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the dataAttribute, of the form: projects/{project_number}/locations/{location_id}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}.
GoogleCloudDataplexV1DataAttribute:
{:description string,
 :resourceAccessSpec
 {:readers [string], :writers [string], :owners [string]},
 :labels object,
 :dataAccessSpec {:readers [string]},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :attributeCount integer,
 :updateTime string,
 :parentId string}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1DataAttribute]
    (projects-locations-dataTaxonomies-attributes-patch
      name
      GoogleCloudDataplexV1DataAttribute
      nil))
  ([name GoogleCloudDataplexV1DataAttribute optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1DataAttribute})))

(defn projects-locations-dataTaxonomies-attributes-delete
  "Deletes a Data Attribute resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the DataAttribute: projects/{project_number}/locations/{location_id}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}

optional:
etag <string> Optional. If the client provided etag value does not match the current etag value, the DeleteDataAttribute method returns an ABORTED error response."
  ([name]
    (projects-locations-dataTaxonomies-attributes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataTaxonomies-attributes-list
  "Lists Data Attribute resources in a DataTaxonomy.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the DataTaxonomy: projects/{project_number}/locations/{location_id}/dataTaxonomies/{data_taxonomy_id}

optional:
pageSize <integer> Optional. Maximum number of DataAttributes to return. The service may return fewer than this value. If unspecified, at most 10 dataAttributes will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent]
    (projects-locations-dataTaxonomies-attributes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/attributes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-dataTaxonomies-attributes-get
  "Retrieves a Data Attribute resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the dataAttribute: projects/{project_number}/locations/{location_id}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-lakes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-lakes-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-lakes-create
  "Creates a lake resource.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the lake location, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.
GoogleCloudDataplexV1Lake:
{:description string,
 :serviceAccount string,
 :labels object,
 :metastoreStatus
 {:state [STATE_UNSPECIFIED NONE READY UPDATING ERROR],
  :message string,
  :updateTime string,
  :endpoint string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :metastore {:service string},
 :assetStatus
 {:updateTime string,
  :activeAssets integer,
  :securityPolicyApplyingAssets integer}}

optional:
lakeId <string> Required. Lake identifier. This ID will be used to generate names such as database and dataset names when publishing metadata to Hive Metastore and BigQuery. * Must contain only lowercase letters, numbers and hyphens. * Must start with a letter. * Must end with a number or a letter. * Must be between 1-63 characters. * Must be unique within the customer project / location.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Lake]
    (projects-locations-lakes-create
      parent
      GoogleCloudDataplexV1Lake
      nil))
  ([parent GoogleCloudDataplexV1Lake optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/lakes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Lake})))

(defn projects-locations-lakes-patch
  "Updates a lake resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the lake, of the form: projects/{project_number}/locations/{location_id}/lakes/{lake_id}.
GoogleCloudDataplexV1Lake:
{:description string,
 :serviceAccount string,
 :labels object,
 :metastoreStatus
 {:state [STATE_UNSPECIFIED NONE READY UPDATING ERROR],
  :message string,
  :updateTime string,
  :endpoint string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :metastore {:service string},
 :assetStatus
 {:updateTime string,
  :activeAssets integer,
  :securityPolicyApplyingAssets integer}}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Lake]
    (projects-locations-lakes-patch
      name
      GoogleCloudDataplexV1Lake
      nil))
  ([name GoogleCloudDataplexV1Lake optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Lake})))

(defn projects-locations-lakes-delete
  "Deletes a lake resource. All zones within the lake must be deleted before the lake can be deleted.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the lake: projects/{project_number}/locations/{location_id}/lakes/{lake_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-list
  "Lists lake resources in a project and location.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the lake location, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.

optional:
pageSize <integer> Optional. Maximum number of Lakes to return. The service may return fewer than this value. If unspecified, at most 10 lakes will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-lakes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/lakes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-get
  "Retrieves a lake resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the lake: projects/{project_number}/locations/{location_id}/lakes/{lake_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-zones-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-lakes-zones-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-lakes-zones-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-lakes-zones-create
  "Creates a zone resource within a lake.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_number}/locations/{location_id}/lakes/{lake_id}.
GoogleCloudDataplexV1Zone:
{:description string,
 :labels object,
 :resourceSpec
 {:locationType
  [LOCATION_TYPE_UNSPECIFIED SINGLE_REGION MULTI_REGION]},
 :discoverySpec
 {:enabled boolean,
  :includePatterns [string],
  :excludePatterns [string],
  :csvOptions
  {:headerRows integer,
   :delimiter string,
   :encoding string,
   :disableTypeInference boolean},
  :jsonOptions {:encoding string, :disableTypeInference boolean},
  :schedule string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :type [TYPE_UNSPECIFIED RAW CURATED],
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :assetStatus
 {:updateTime string,
  :activeAssets integer,
  :securityPolicyApplyingAssets integer}}

optional:
zoneId <string> Required. Zone identifier. This ID will be used to generate names such as database and dataset names when publishing metadata to Hive Metastore and BigQuery. * Must contain only lowercase letters, numbers and hyphens. * Must start with a letter. * Must end with a number or a letter. * Must be between 1-63 characters. * Must be unique across all lakes from all locations in a project. * Must not be one of the reserved IDs (i.e. \"default\", \"global-temp\")
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Zone]
    (projects-locations-lakes-zones-create
      parent
      GoogleCloudDataplexV1Zone
      nil))
  ([parent GoogleCloudDataplexV1Zone optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/zones",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Zone})))

(defn projects-locations-lakes-zones-patch
  "Updates a zone resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the zone, of the form: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}.
GoogleCloudDataplexV1Zone:
{:description string,
 :labels object,
 :resourceSpec
 {:locationType
  [LOCATION_TYPE_UNSPECIFIED SINGLE_REGION MULTI_REGION]},
 :discoverySpec
 {:enabled boolean,
  :includePatterns [string],
  :excludePatterns [string],
  :csvOptions
  {:headerRows integer,
   :delimiter string,
   :encoding string,
   :disableTypeInference boolean},
  :jsonOptions {:encoding string, :disableTypeInference boolean},
  :schedule string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :type [TYPE_UNSPECIFIED RAW CURATED],
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :assetStatus
 {:updateTime string,
  :activeAssets integer,
  :securityPolicyApplyingAssets integer}}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Zone]
    (projects-locations-lakes-zones-patch
      name
      GoogleCloudDataplexV1Zone
      nil))
  ([name GoogleCloudDataplexV1Zone optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Zone})))

(defn projects-locations-lakes-zones-delete
  "Deletes a zone resource. All assets within a zone must be deleted before the zone can be deleted.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-zones-list
  "Lists zone resources in a lake.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_number}/locations/{location_id}/lakes/{lake_id}.

optional:
pageSize <integer> Optional. Maximum number of zones to return. The service may return fewer than this value. If unspecified, at most 10 zones will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-lakes-zones-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/zones",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-get
  "Retrieves a zone resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-zones-assets-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-lakes-zones-assets-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-lakes-zones-assets-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-assets-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-lakes-zones-assets-create
  "Creates an asset resource.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}.
GoogleCloudDataplexV1Asset:
{:description string,
 :labels object,
 :resourceSpec
 {:name string,
  :type [TYPE_UNSPECIFIED STORAGE_BUCKET BIGQUERY_DATASET],
  :readAccessMode [ACCESS_MODE_UNSPECIFIED DIRECT MANAGED]},
 :discoverySpec
 {:enabled boolean,
  :includePatterns [string],
  :excludePatterns [string],
  :csvOptions
  {:headerRows integer,
   :delimiter string,
   :encoding string,
   :disableTypeInference boolean},
  :jsonOptions {:encoding string, :disableTypeInference boolean},
  :schedule string},
 :discoveryStatus
 {:state [STATE_UNSPECIFIED SCHEDULED IN_PROGRESS PAUSED DISABLED],
  :message string,
  :updateTime string,
  :lastRunTime string,
  :stats
  {:dataItems string,
   :dataSize string,
   :tables string,
   :filesets string},
  :lastRunDuration string},
 :resourceStatus
 {:state [STATE_UNSPECIFIED READY ERROR],
  :message string,
  :updateTime string,
  :managedAccessIdentity string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :securityStatus
 {:state [STATE_UNSPECIFIED READY APPLYING ERROR],
  :message string,
  :updateTime string}}

optional:
assetId <string> Required. Asset identifier. This ID will be used to generate names such as table names when publishing metadata to Hive Metastore and BigQuery. * Must contain only lowercase letters, numbers and hyphens. * Must start with a letter. * Must end with a number or a letter. * Must be between 1-63 characters. * Must be unique within the zone.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Asset]
    (projects-locations-lakes-zones-assets-create
      parent
      GoogleCloudDataplexV1Asset
      nil))
  ([parent GoogleCloudDataplexV1Asset optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/assets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Asset})))

(defn projects-locations-lakes-zones-assets-patch
  "Updates an asset resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the asset, of the form: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}.
GoogleCloudDataplexV1Asset:
{:description string,
 :labels object,
 :resourceSpec
 {:name string,
  :type [TYPE_UNSPECIFIED STORAGE_BUCKET BIGQUERY_DATASET],
  :readAccessMode [ACCESS_MODE_UNSPECIFIED DIRECT MANAGED]},
 :discoverySpec
 {:enabled boolean,
  :includePatterns [string],
  :excludePatterns [string],
  :csvOptions
  {:headerRows integer,
   :delimiter string,
   :encoding string,
   :disableTypeInference boolean},
  :jsonOptions {:encoding string, :disableTypeInference boolean},
  :schedule string},
 :discoveryStatus
 {:state [STATE_UNSPECIFIED SCHEDULED IN_PROGRESS PAUSED DISABLED],
  :message string,
  :updateTime string,
  :lastRunTime string,
  :stats
  {:dataItems string,
   :dataSize string,
   :tables string,
   :filesets string},
  :lastRunDuration string},
 :resourceStatus
 {:state [STATE_UNSPECIFIED READY ERROR],
  :message string,
  :updateTime string,
  :managedAccessIdentity string},
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :securityStatus
 {:state [STATE_UNSPECIFIED READY APPLYING ERROR],
  :message string,
  :updateTime string}}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Asset]
    (projects-locations-lakes-zones-assets-patch
      name
      GoogleCloudDataplexV1Asset
      nil))
  ([name GoogleCloudDataplexV1Asset optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Asset})))

(defn projects-locations-lakes-zones-assets-delete
  "Deletes an asset resource. The referenced storage resource is detached (default) or deleted based on the associated Lifecycle policy.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the asset: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-zones-assets-list
  "Lists asset resources in a zone.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}.

optional:
pageSize <integer> Optional. Maximum number of asset to return. The service may return fewer than this value. If unspecified, at most 10 assets will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-lakes-zones-assets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/assets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-assets-get
  "Retrieves an asset resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the asset: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-zones-assets-actions-list
  "Lists action resources in an asset.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent asset: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/assets/{asset_id}.

optional:
pageSize <integer> Optional. Maximum number of actions to return. The service may return fewer than this value. If unspecified, at most 10 actions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent]
    (projects-locations-lakes-zones-assets-actions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/actions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-entities-create
  "Create a metadata entity.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}.
GoogleCloudDataplexV1Entity:
{:description string,
 :schema
 {:userManaged boolean,
  :fields
  [{:name string,
    :description string,
    :type
    [TYPE_UNSPECIFIED
     BOOLEAN
     BYTE
     INT16
     INT32
     INT64
     FLOAT
     DOUBLE
     DECIMAL
     STRING
     BINARY
     TIMESTAMP
     DATE
     TIME
     RECORD
     NULL],
    :mode [MODE_UNSPECIFIED REQUIRED NULLABLE REPEATED],
    :fields
    [{:name string,
      :description string,
      :type
      [TYPE_UNSPECIFIED
       BOOLEAN
       BYTE
       INT16
       INT32
       INT64
       FLOAT
       DOUBLE
       DECIMAL
       STRING
       BINARY
       TIMESTAMP
       DATE
       TIME
       RECORD
       NULL],
      :mode [MODE_UNSPECIFIED REQUIRED NULLABLE REPEATED],
      :fields
      [{:name string,
        :description string,
        :type
        [TYPE_UNSPECIFIED
         BOOLEAN
         BYTE
         INT16
         INT32
         INT64
         FLOAT
         DOUBLE
         DECIMAL
         STRING
         BINARY
         TIMESTAMP
         DATE
         TIME
         RECORD
         NULL],
        :mode [MODE_UNSPECIFIED REQUIRED NULLABLE REPEATED],
        :fields [GoogleCloudDataplexV1SchemaSchemaField]}]}]}],
  :partitionFields
  [{:name string,
    :type
    [TYPE_UNSPECIFIED
     BOOLEAN
     BYTE
     INT16
     INT32
     INT64
     FLOAT
     DOUBLE
     DECIMAL
     STRING
     BINARY
     TIMESTAMP
     DATE
     TIME
     RECORD
     NULL]}],
  :partitionStyle [PARTITION_STYLE_UNSPECIFIED HIVE_COMPATIBLE]},
 :format
 {:format
  [FORMAT_UNSPECIFIED
   PARQUET
   AVRO
   ORC
   CSV
   JSON
   IMAGE
   AUDIO
   VIDEO
   TEXT
   TFRECORD
   OTHER
   UNKNOWN],
  :compressionFormat [COMPRESSION_FORMAT_UNSPECIFIED GZIP BZIP2],
  :mimeType string,
  :csv
  {:encoding string,
   :headerRows integer,
   :delimiter string,
   :quote string},
  :json {:encoding string},
  :iceberg {:metadataLocation string}},
 :system [STORAGE_SYSTEM_UNSPECIFIED CLOUD_STORAGE BIGQUERY],
 :catalogEntry string,
 :compatibility
 {:hiveMetastore {:compatible boolean, :reason string},
  :bigquery {:compatible boolean, :reason string}},
 :dataPathPattern string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :type [TYPE_UNSPECIFIED TABLE FILESET],
 :etag string,
 :updateTime string,
 :id string,
 :dataPath string,
 :access {:read [ACCESS_MODE_UNSPECIFIED DIRECT MANAGED]},
 :asset string}

optional:
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Entity]
    (projects-locations-lakes-zones-entities-create
      parent
      GoogleCloudDataplexV1Entity
      nil))
  ([parent GoogleCloudDataplexV1Entity optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entities",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Entity})))

(defn projects-locations-lakes-zones-entities-update
  "Update a metadata entity. Only supports full resource update.
https://cloud.google.com/dataplex/docs

name <string> Output only. The resource name of the entity, of the form: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{id}.
GoogleCloudDataplexV1Entity:
{:description string,
 :schema
 {:userManaged boolean,
  :fields
  [{:name string,
    :description string,
    :type
    [TYPE_UNSPECIFIED
     BOOLEAN
     BYTE
     INT16
     INT32
     INT64
     FLOAT
     DOUBLE
     DECIMAL
     STRING
     BINARY
     TIMESTAMP
     DATE
     TIME
     RECORD
     NULL],
    :mode [MODE_UNSPECIFIED REQUIRED NULLABLE REPEATED],
    :fields
    [{:name string,
      :description string,
      :type
      [TYPE_UNSPECIFIED
       BOOLEAN
       BYTE
       INT16
       INT32
       INT64
       FLOAT
       DOUBLE
       DECIMAL
       STRING
       BINARY
       TIMESTAMP
       DATE
       TIME
       RECORD
       NULL],
      :mode [MODE_UNSPECIFIED REQUIRED NULLABLE REPEATED],
      :fields
      [{:name string,
        :description string,
        :type
        [TYPE_UNSPECIFIED
         BOOLEAN
         BYTE
         INT16
         INT32
         INT64
         FLOAT
         DOUBLE
         DECIMAL
         STRING
         BINARY
         TIMESTAMP
         DATE
         TIME
         RECORD
         NULL],
        :mode [MODE_UNSPECIFIED REQUIRED NULLABLE REPEATED],
        :fields [GoogleCloudDataplexV1SchemaSchemaField]}]}]}],
  :partitionFields
  [{:name string,
    :type
    [TYPE_UNSPECIFIED
     BOOLEAN
     BYTE
     INT16
     INT32
     INT64
     FLOAT
     DOUBLE
     DECIMAL
     STRING
     BINARY
     TIMESTAMP
     DATE
     TIME
     RECORD
     NULL]}],
  :partitionStyle [PARTITION_STYLE_UNSPECIFIED HIVE_COMPATIBLE]},
 :format
 {:format
  [FORMAT_UNSPECIFIED
   PARQUET
   AVRO
   ORC
   CSV
   JSON
   IMAGE
   AUDIO
   VIDEO
   TEXT
   TFRECORD
   OTHER
   UNKNOWN],
  :compressionFormat [COMPRESSION_FORMAT_UNSPECIFIED GZIP BZIP2],
  :mimeType string,
  :csv
  {:encoding string,
   :headerRows integer,
   :delimiter string,
   :quote string},
  :json {:encoding string},
  :iceberg {:metadataLocation string}},
 :system [STORAGE_SYSTEM_UNSPECIFIED CLOUD_STORAGE BIGQUERY],
 :catalogEntry string,
 :compatibility
 {:hiveMetastore {:compatible boolean, :reason string},
  :bigquery {:compatible boolean, :reason string}},
 :dataPathPattern string,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :type [TYPE_UNSPECIFIED TABLE FILESET],
 :etag string,
 :updateTime string,
 :id string,
 :dataPath string,
 :access {:read [ACCESS_MODE_UNSPECIFIED DIRECT MANAGED]},
 :asset string}

optional:
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Entity]
    (projects-locations-lakes-zones-entities-update
      name
      GoogleCloudDataplexV1Entity
      nil))
  ([name GoogleCloudDataplexV1Entity optional]
    (client/api-request
      {:method "PUT",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Entity})))

(defn projects-locations-lakes-zones-entities-delete
  "Delete a metadata entity.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the entity: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}.

optional:
etag <string> Required. The etag associated with the entity, which can be retrieved with a GetEntity request."
  ([name] (projects-locations-lakes-zones-entities-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-entities-get
  "Get a metadata entity.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the entity: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}.

optional:
view <string> Optional. Used to select the subset of entity information to return. Defaults to BASIC."
  ([name] (projects-locations-lakes-zones-entities-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-entities-list
  "List metadata entities in a zone.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}.

optional:
view <string> Required. Specify the entity view to make a partial list request.
pageSize <integer> Optional. Maximum number of entities to return. The service may return fewer than this value. If unspecified, 100 entities will be returned by default. The maximum value is 500; larger values will will be truncated to 500.
filter <string> Optional. The following filter parameters can be added to the URL to limit the entities returned by the API: Entity ID: ?filter=\"id=entityID\" Asset ID: ?filter=\"asset=assetID\" Data path ?filter=\"data_path=gs://my-bucket\" Is HIVE compatible: ?filter=\"hive_compatible=true\" Is BigQuery compatible: ?filter=\"bigquery_compatible=true\""
  ([parent] (projects-locations-lakes-zones-entities-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entities",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-entities-partitions-create
  "Create a metadata partition.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}.
GoogleCloudDataplexV1Partition:
{:name string, :values [string], :location string, :etag string}

optional:
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Partition]
    (projects-locations-lakes-zones-entities-partitions-create
      parent
      GoogleCloudDataplexV1Partition
      nil))
  ([parent GoogleCloudDataplexV1Partition optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/partitions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Partition})))

(defn projects-locations-lakes-zones-entities-partitions-delete
  "Delete a metadata partition.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the partition. format: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}/partitions/{partition_value_path}. The {partition_value_path} segment consists of an ordered sequence of partition values separated by \"/\". All values must be provided.

optional:
etag <string> Optional. The etag associated with the partition."
  ([name]
    (projects-locations-lakes-zones-entities-partitions-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-entities-partitions-get
  "Get a metadata partition of an entity.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the partition: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}/partitions/{partition_value_path}. The {partition_value_path} segment consists of an ordered sequence of partition values separated by \"/\". All values must be provided."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-zones-entities-partitions-list
  "List metadata partitions of an entity.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent entity: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}/entities/{entity_id}.

optional:
pageSize <integer> Optional. Maximum number of partitions to return. The service may return fewer than this value. If unspecified, 100 partitions will be returned by default. The maximum page size is 500; larger values will will be truncated to 500.
filter <string> Optional. Filter the partitions returned to the caller using a key value pair expression. Supported operators and syntax: logic operators: AND, OR comparison operators: <, >, >=, <= ,=, != LIKE operators: The right hand of a LIKE operator supports \".\" and \"*\" for wildcard searches, for example \"value1 LIKE \".*oo.*\" parenthetical grouping: ( )Sample filter expression: `?filter=\"key1 < value1 OR key2 > value2\"Notes: Keys to the left of operators are case insensitive. Partition results are sorted first by creation time, then by lexicographic order. Up to 20 key value filter pairs are allowed, but due to performance considerations, only the first 10 will be used as a filter."
  ([parent]
    (projects-locations-lakes-zones-entities-partitions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/partitions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-zones-actions-list
  "Lists action resources in a zone.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent zone: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/zones/{zone_id}.

optional:
pageSize <integer> Optional. Maximum number of actions to return. The service may return fewer than this value. If unspecified, at most 10 actions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-lakes-zones-actions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/actions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-tasks-get
  "Get task resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the task: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{tasks_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-tasks-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-lakes-tasks-run
  "Run an on demand execution of a Task.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the task: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{task_id}.
GoogleCloudDataplexV1RunTaskRequest:
{:labels object, :args object}"
  [name GoogleCloudDataplexV1RunTaskRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}:run",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDataplexV1RunTaskRequest}))

(defn projects-locations-lakes-tasks-patch
  "Update the task resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the task, of the form: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/ tasks/{task_id}.
GoogleCloudDataplexV1Task:
{:description string,
 :labels object,
 :displayName string,
 :executionStatus
 {:updateTime string,
  :latestJob
  {:labels object,
   :service [SERVICE_UNSPECIFIED DATAPROC],
   :startTime string,
   :uid string,
   :name string,
   :endTime string,
   :retryCount integer,
   :executionSpec
   {:args object,
    :serviceAccount string,
    :project string,
    :maxJobExecutionLifetime string,
    :kmsKey string},
   :state
   [STATE_UNSPECIFIED
    RUNNING
    CANCELLING
    CANCELLED
    SUCCEEDED
    FAILED
    ABORTED],
   :serviceJob string,
   :trigger [TRIGGER_UNSPECIFIED TASK_CONFIG RUN_REQUEST],
   :message string}},
 :uid string,
 :name string,
 :createTime string,
 :executionSpec
 {:args object,
  :serviceAccount string,
  :project string,
  :maxJobExecutionLifetime string,
  :kmsKey string},
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :notebook
 {:notebook string,
  :infrastructureSpec
  {:batch {:executorsCount integer, :maxExecutorsCount integer},
   :containerImage
   {:image string,
    :javaJars [string],
    :pythonPackages [string],
    :properties object},
   :vpcNetwork
   {:network string, :subNetwork string, :networkTags [string]}},
  :fileUris [string],
  :archiveUris [string]},
 :triggerSpec
 {:type [TYPE_UNSPECIFIED ON_DEMAND RECURRING],
  :startTime string,
  :disabled boolean,
  :maxRetries integer,
  :schedule string},
 :spark
 {:mainJarFileUri string,
  :mainClass string,
  :pythonScriptFile string,
  :sqlScriptFile string,
  :sqlScript string,
  :fileUris [string],
  :archiveUris [string],
  :infrastructureSpec
  {:batch {:executorsCount integer, :maxExecutorsCount integer},
   :containerImage
   {:image string,
    :javaJars [string],
    :pythonPackages [string],
    :properties object},
   :vpcNetwork
   {:network string, :subNetwork string, :networkTags [string]}}}}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Task]
    (projects-locations-lakes-tasks-patch
      name
      GoogleCloudDataplexV1Task
      nil))
  ([name GoogleCloudDataplexV1Task optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Task})))

(defn projects-locations-lakes-tasks-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-lakes-tasks-create
  "Creates a task resource within a lake.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_number}/locations/{location_id}/lakes/{lake_id}.
GoogleCloudDataplexV1Task:
{:description string,
 :labels object,
 :displayName string,
 :executionStatus
 {:updateTime string,
  :latestJob
  {:labels object,
   :service [SERVICE_UNSPECIFIED DATAPROC],
   :startTime string,
   :uid string,
   :name string,
   :endTime string,
   :retryCount integer,
   :executionSpec
   {:args object,
    :serviceAccount string,
    :project string,
    :maxJobExecutionLifetime string,
    :kmsKey string},
   :state
   [STATE_UNSPECIFIED
    RUNNING
    CANCELLING
    CANCELLED
    SUCCEEDED
    FAILED
    ABORTED],
   :serviceJob string,
   :trigger [TRIGGER_UNSPECIFIED TASK_CONFIG RUN_REQUEST],
   :message string}},
 :uid string,
 :name string,
 :createTime string,
 :executionSpec
 {:args object,
  :serviceAccount string,
  :project string,
  :maxJobExecutionLifetime string,
  :kmsKey string},
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :notebook
 {:notebook string,
  :infrastructureSpec
  {:batch {:executorsCount integer, :maxExecutorsCount integer},
   :containerImage
   {:image string,
    :javaJars [string],
    :pythonPackages [string],
    :properties object},
   :vpcNetwork
   {:network string, :subNetwork string, :networkTags [string]}},
  :fileUris [string],
  :archiveUris [string]},
 :triggerSpec
 {:type [TYPE_UNSPECIFIED ON_DEMAND RECURRING],
  :startTime string,
  :disabled boolean,
  :maxRetries integer,
  :schedule string},
 :spark
 {:mainJarFileUri string,
  :mainClass string,
  :pythonScriptFile string,
  :sqlScriptFile string,
  :sqlScript string,
  :fileUris [string],
  :archiveUris [string],
  :infrastructureSpec
  {:batch {:executorsCount integer, :maxExecutorsCount integer},
   :containerImage
   {:image string,
    :javaJars [string],
    :pythonPackages [string],
    :properties object},
   :vpcNetwork
   {:network string, :subNetwork string, :networkTags [string]}}}}

optional:
taskId <string> Required. Task identifier.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Task]
    (projects-locations-lakes-tasks-create
      parent
      GoogleCloudDataplexV1Task
      nil))
  ([parent GoogleCloudDataplexV1Task optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/tasks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Task})))

(defn projects-locations-lakes-tasks-delete
  "Delete the task resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the task: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/task/{task_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-tasks-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-lakes-tasks-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-tasks-list
  "Lists tasks under the given lake.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_number}/locations/{location_id}/lakes/{lake_id}.

optional:
pageSize <integer> Optional. Maximum number of tasks to return. The service may return fewer than this value. If unspecified, at most 10 tasks will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-lakes-tasks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/tasks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-tasks-jobs-list
  "Lists Jobs under the given task.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent environment: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{task_id}.

optional:
pageSize <integer> Optional. Maximum number of jobs to return. The service may return fewer than this value. If unspecified, at most 10 jobs will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-lakes-tasks-jobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/jobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-tasks-jobs-get
  "Get job resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the job: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/tasks/{task_id}/jobs/{job_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-tasks-jobs-cancel
  "Cancel jobs running for the task resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the job: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/task/{task_id}/job/{job_id}.
GoogleCloudDataplexV1CancelJobRequest:
object"
  [name GoogleCloudDataplexV1CancelJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudDataplexV1CancelJobRequest}))

(defn projects-locations-lakes-environments-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-lakes-environments-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-lakes-environments-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-environments-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-lakes-environments-create
  "Create an environment resource.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_id}/locations/{location_id}/lakes/{lake_id}.
GoogleCloudDataplexV1Environment:
{:description string,
 :sessionStatus {:active boolean},
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :endpoints {:notebooks string, :sql string},
 :sessionSpec {:maxIdleDuration string, :enableFastStartup boolean},
 :infrastructureSpec
 {:compute
  {:diskSizeGb integer, :nodeCount integer, :maxNodeCount integer},
  :osImage
  {:imageVersion string,
   :javaLibraries [string],
   :pythonPackages [string],
   :properties object}}}

optional:
environmentId <string> Required. Environment identifier. * Must contain only lowercase letters, numbers and hyphens. * Must start with a letter. * Must be between 1-63 characters. * Must end with a number or a letter. * Must be unique within the lake.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Environment]
    (projects-locations-lakes-environments-create
      parent
      GoogleCloudDataplexV1Environment
      nil))
  ([parent GoogleCloudDataplexV1Environment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/environments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Environment})))

(defn projects-locations-lakes-environments-patch
  "Update the environment resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the environment, of the form: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/environment/{environment_id}
GoogleCloudDataplexV1Environment:
{:description string,
 :sessionStatus {:active boolean},
 :labels object,
 :displayName string,
 :uid string,
 :name string,
 :createTime string,
 :state [STATE_UNSPECIFIED ACTIVE CREATING DELETING ACTION_REQUIRED],
 :updateTime string,
 :endpoints {:notebooks string, :sql string},
 :sessionSpec {:maxIdleDuration string, :enableFastStartup boolean},
 :infrastructureSpec
 {:compute
  {:diskSizeGb integer, :nodeCount integer, :maxNodeCount integer},
  :osImage
  {:imageVersion string,
   :javaLibraries [string],
   :pythonPackages [string],
   :properties object}}}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Environment]
    (projects-locations-lakes-environments-patch
      name
      GoogleCloudDataplexV1Environment
      nil))
  ([name GoogleCloudDataplexV1Environment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Environment})))

(defn projects-locations-lakes-environments-delete
  "Delete the environment resource. All the child resources must have been deleted before environment deletion can be initiated.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the environment: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/environments/{environment_id}."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-environments-list
  "Lists environments under the given lake.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_id}/locations/{location_id}/lakes/{lake_id}.

optional:
pageSize <integer> Optional. Maximum number of environments to return. The service may return fewer than this value. If unspecified, at most 10 environments will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request.
orderBy <string> Optional. Order by fields for the result."
  ([parent] (projects-locations-lakes-environments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/environments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-environments-get
  "Get environment resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the environment: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/environments/{environment_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-environments-sessions-list
  "Lists session resources in an environment.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent environment: projects/{project_number}/locations/{location_id}/lakes/{lake_id}/environment/{environment_id}.

optional:
pageSize <integer> Optional. Maximum number of sessions to return. The service may return fewer than this value. If unspecified, at most 10 sessions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request. The following mode filter is supported to return only the sessions belonging to the requester when the mode is USER and return sessions of all the users when the mode is ADMIN. When no filter is sent default to USER mode. NOTE: When the mode is ADMIN, the requester should have dataplex.environments.listAllSessions permission to list all sessions, in absence of the permission, the request fails.mode = ADMIN | USER"
  ([parent]
    (projects-locations-lakes-environments-sessions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/sessions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-contentitems-create
  "Create a content.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_id}/locations/{location_id}/lakes/{lake_id}
GoogleCloudDataplexV1Content:
{:description string,
 :path string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :sqlScript {:engine [QUERY_ENGINE_UNSPECIFIED SPARK]},
 :updateTime string,
 :notebook {:kernelType [KERNEL_TYPE_UNSPECIFIED PYTHON3]},
 :dataText string}

optional:
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Content]
    (projects-locations-lakes-contentitems-create
      parent
      GoogleCloudDataplexV1Content
      nil))
  ([parent GoogleCloudDataplexV1Content optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/contentitems",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Content})))

(defn projects-locations-lakes-contentitems-patch
  "Update a content. Only supports full resource update.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the content, of the form: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}
GoogleCloudDataplexV1Content:
{:description string,
 :path string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :sqlScript {:engine [QUERY_ENGINE_UNSPECIFIED SPARK]},
 :updateTime string,
 :notebook {:kernelType [KERNEL_TYPE_UNSPECIFIED PYTHON3]},
 :dataText string}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Content]
    (projects-locations-lakes-contentitems-patch
      name
      GoogleCloudDataplexV1Content
      nil))
  ([name GoogleCloudDataplexV1Content optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Content})))

(defn projects-locations-lakes-contentitems-delete
  "Delete a content.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the content: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-contentitems-get
  "Get a content resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the content: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}

optional:
view <string> Optional. Specify content view to make a partial request."
  ([name] (projects-locations-lakes-contentitems-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-contentitems-getIamPolicy
  "Gets the access control policy for a contentitem resource. A NOT_FOUND error is returned if the resource does not exist. An empty policy is returned if the resource exists but does not have a policy set on it.Caller must have Google IAM dataplex.content.getIamPolicy permission on the resource.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-lakes-contentitems-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-contentitems-setIamPolicy
  "Sets the access control policy on the specified contentitem resource. Replaces any existing policy.Caller must have Google IAM dataplex.content.setIamPolicy permission on the resource.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-lakes-contentitems-testIamPermissions
  "Returns the caller's permissions on a resource. If the resource does not exist, an empty set of permissions is returned (a NOT_FOUND error is not returned).A caller is not required to have Google IAM permission to make this request.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-lakes-contentitems-list
  "List content.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_id}/locations/{location_id}/lakes/{lake_id}

optional:
pageSize <integer> Optional. Maximum number of content to return. The service may return fewer than this value. If unspecified, at most 10 content will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request. Filters are case-sensitive. The following formats are supported:labels.key1 = \"value1\" labels:key1 type = \"NOTEBOOK\" type = \"SQL_SCRIPT\"These restrictions can be coinjoined with AND, OR and NOT conjunctions."
  ([parent] (projects-locations-lakes-contentitems-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/contentitems",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-content-create
  "Create a content.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_id}/locations/{location_id}/lakes/{lake_id}
GoogleCloudDataplexV1Content:
{:description string,
 :path string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :sqlScript {:engine [QUERY_ENGINE_UNSPECIFIED SPARK]},
 :updateTime string,
 :notebook {:kernelType [KERNEL_TYPE_UNSPECIFIED PYTHON3]},
 :dataText string}

optional:
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1Content]
    (projects-locations-lakes-content-create
      parent
      GoogleCloudDataplexV1Content
      nil))
  ([parent GoogleCloudDataplexV1Content optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/content",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Content})))

(defn projects-locations-lakes-content-patch
  "Update a content. Only supports full resource update.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the content, of the form: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}
GoogleCloudDataplexV1Content:
{:description string,
 :path string,
 :labels object,
 :uid string,
 :name string,
 :createTime string,
 :sqlScript {:engine [QUERY_ENGINE_UNSPECIFIED SPARK]},
 :updateTime string,
 :notebook {:kernelType [KERNEL_TYPE_UNSPECIFIED PYTHON3]},
 :dataText string}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1Content]
    (projects-locations-lakes-content-patch
      name
      GoogleCloudDataplexV1Content
      nil))
  ([name GoogleCloudDataplexV1Content optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1Content})))

(defn projects-locations-lakes-content-delete
  "Delete a content.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the content: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-lakes-content-get
  "Get a content resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the content: projects/{project_id}/locations/{location_id}/lakes/{lake_id}/content/{content_id}

optional:
view <string> Optional. Specify content view to make a partial request."
  ([name] (projects-locations-lakes-content-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-content-getIamPolicy
  "Gets the access control policy for a contentitem resource. A NOT_FOUND error is returned if the resource does not exist. An empty policy is returned if the resource exists but does not have a policy set on it.Caller must have Google IAM dataplex.content.getIamPolicy permission on the resource.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-lakes-content-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-content-setIamPolicy
  "Sets the access control policy on the specified contentitem resource. Replaces any existing policy.Caller must have Google IAM dataplex.content.setIamPolicy permission on the resource.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-lakes-content-testIamPermissions
  "Returns the caller's permissions on a resource. If the resource does not exist, an empty set of permissions is returned (a NOT_FOUND error is not returned).A caller is not required to have Google IAM permission to make this request.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

(defn projects-locations-lakes-content-list
  "List content.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_id}/locations/{location_id}/lakes/{lake_id}

optional:
pageSize <integer> Optional. Maximum number of content to return. The service may return fewer than this value. If unspecified, at most 10 content will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request. Filters are case-sensitive. The following formats are supported:labels.key1 = \"value1\" labels:key1 type = \"NOTEBOOK\" type = \"SQL_SCRIPT\"These restrictions can be coinjoined with AND, OR and NOT conjunctions."
  ([parent] (projects-locations-lakes-content-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/content",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-lakes-actions-list
  "Lists action resources in a lake.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the parent lake: projects/{project_number}/locations/{location_id}/lakes/{lake_id}.

optional:
pageSize <integer> Optional. Maximum number of actions to return. The service may return fewer than this value. If unspecified, at most 10 actions will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-locations-lakes-actions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/actions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.
https://cloud.google.com/dataplex/docs

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/dataplex/docs

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED.
https://cloud.google.com/dataplex/docs

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED.
https://cloud.google.com/dataplex/docs

name <string> The name of the operation resource to be cancelled.
GoogleLongrunningCancelOperationRequest:
object"
  [name GoogleLongrunningCancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleLongrunningCancelOperationRequest}))

(defn projects-locations-entryTypes-create
  "Creates an EntryType
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the EntryType, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.
GoogleCloudDataplexV1EntryType:
{:description string,
 :labels object,
 :system string,
 :displayName string,
 :authorization {:alternateUsePermission string},
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :requiredAspects [{:type string}],
 :typeAliases [string],
 :platform string}

optional:
entryTypeId <string> Required. EntryType identifier.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([parent GoogleCloudDataplexV1EntryType]
    (projects-locations-entryTypes-create
      parent
      GoogleCloudDataplexV1EntryType
      nil))
  ([parent GoogleCloudDataplexV1EntryType optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entryTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1EntryType})))

(defn projects-locations-entryTypes-patch
  "Updates a EntryType resource.
https://cloud.google.com/dataplex/docs

name <string> Output only. The relative resource name of the EntryType, of the form: projects/{project_number}/locations/{location_id}/entryTypes/{entry_type_id}.
GoogleCloudDataplexV1EntryType:
{:description string,
 :labels object,
 :system string,
 :displayName string,
 :authorization {:alternateUsePermission string},
 :uid string,
 :name string,
 :createTime string,
 :etag string,
 :updateTime string,
 :requiredAspects [{:type string}],
 :typeAliases [string],
 :platform string}

optional:
updateMask <string> Required. Mask of fields to update.
validateOnly <boolean> Optional. Only validate the request, but do not perform mutations. The default is false."
  ([name GoogleCloudDataplexV1EntryType]
    (projects-locations-entryTypes-patch
      name
      GoogleCloudDataplexV1EntryType
      nil))
  ([name GoogleCloudDataplexV1EntryType optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudDataplexV1EntryType})))

(defn projects-locations-entryTypes-delete
  "Deletes a EntryType resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the EntryType: projects/{project_number}/locations/{location_id}/entryTypes/{entry_type_id}.

optional:
etag <string> Optional. If the client provided etag value does not match the current etag value, the DeleteEntryTypeRequest method returns an ABORTED error response"
  ([name] (projects-locations-entryTypes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://dataplex.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryTypes-list
  "Lists EntryType resources in a project and location.
https://cloud.google.com/dataplex/docs

parent <string> Required. The resource name of the EntryType location, of the form: projects/{project_number}/locations/{location_id} where location_id refers to a GCP region.

optional:
pageSize <integer> Optional. Maximum number of EntryTypes to return. The service may return fewer than this value. If unspecified, at most 10 EntryTypes will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000.
filter <string> Optional. Filter request. Filters are case-sensitive. The following formats are supported:labels.key1 = \"value1\" labels:key1 name = \"value\" These restrictions can be coinjoined with AND, OR and NOT conjunctions.
orderBy <string> Optional. Order by fields (name or create_time) for the result. If not specified, the ordering is undefined."
  ([parent] (projects-locations-entryTypes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+parent}/entryTypes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryTypes-get
  "Retrieves a EntryType resource.
https://cloud.google.com/dataplex/docs

name <string> Required. The resource name of the EntryType: projects/{project_number}/locations/{location_id}/entryTypes/{entry_type_id}."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://dataplex.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-entryTypes-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being specified. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1SetIamPolicyRequest:
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
  [resource GoogleIamV1SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1SetIamPolicyRequest}))

(defn projects-locations-entryTypes-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy.Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected.Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset.The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1.To learn which resources support conditions in their IAM policies, see the IAM documentation (https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-entryTypes-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://dataplex.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-entryTypes-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/dataplex/docs

resource <string> REQUIRED: The resource for which the policy detail is being requested. See Resource names (https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GoogleIamV1TestIamPermissionsRequest:
{:permissions [string]}"
  [resource GoogleIamV1TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://dataplex.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleIamV1TestIamPermissionsRequest}))

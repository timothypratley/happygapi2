(ns happygapi2.drivelabels
  "Drive Labels API
An API for managing Drive Labels
See: https://developers.google.com/drive/labels/guides/overview"
  (:require [happy.oauth2.client :as client]))

(defn limits-getLabel
  "Get the constraints on the structure of a Label; such as, the maximum number of Fields allowed and maximum length of the label title.
https://developers.google.com/drive/labels/guides/overview

optional:
name <string> Required. Label revision resource name Must be: \"limits/label\""
  ([] (limits-getLabel nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://drivelabels.googleapis.com/v2/limits/label",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

(defn labels-disable
  "Disable a published Label. Disabling a Label will result in a new disabled published revision based on the current published revision. If there is a draft revision, a new disabled draft revision will be created based on the latest draft revision. Older draft revisions will be deleted. Once disabled, a label may be deleted with `DeleteLabel`.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. Label resource name.
GoogleAppsDriveLabelsV2DisableLabelRequest:
{:updateMask string,
 :writeControl {:requiredRevisionId string},
 :useAdminAccess boolean,
 :languageCode string,
 :disabledPolicy {:hideInSearch boolean, :showInApply boolean}}"
  [name GoogleAppsDriveLabelsV2DisableLabelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+name}:disable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2DisableLabelRequest}))

(defn labels-get
  "Get a label by its resource name. Resource name may be any of: * `labels/{id}` - See `labels/{id}@latest` * `labels/{id}@latest` - Gets the latest revision of the label. * `labels/{id}@published` - Gets the current published revision of the label. * `labels/{id}@{revision_id}` - Gets the label at the specified revision ID.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. Label resource name. May be any of: * `labels/{id}` (equivalent to labels/{id}@latest) * `labels/{id}@latest` * `labels/{id}@published` * `labels/{id}@{revision_id}`

optional:
view <string> When specified, only certain fields belonging to the indicated view are returned.
languageCode <string> The BCP-47 language code to use for evaluating localized field labels. When not specified, values in the default configured language are used.
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server verifies that the user is an admin for the label before allowing access."
  ([name] (labels-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://drivelabels.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

(defn labels-updatePermissions
  "Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name.
GoogleAppsDriveLabelsV2LabelPermission:
{:group string,
 :person string,
 :email string,
 :name string,
 :role [LABEL_ROLE_UNSPECIFIED READER APPLIER ORGANIZER EDITOR],
 :audience string}

optional:
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([parent GoogleAppsDriveLabelsV2LabelPermission]
    (labels-updatePermissions
      parent
      GoogleAppsDriveLabelsV2LabelPermission
      nil))
  ([parent GoogleAppsDriveLabelsV2LabelPermission optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/permissions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"],
       :body GoogleAppsDriveLabelsV2LabelPermission})))

(defn labels-enable
  "Enable a disabled Label and restore it to its published state. This will result in a new published revision based on the current disabled published revision. If there is an existing disabled draft revision, a new revision will be created based on that draft and will be enabled.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. Label resource name.
GoogleAppsDriveLabelsV2EnableLabelRequest:
{:writeControl {:requiredRevisionId string},
 :useAdminAccess boolean,
 :languageCode string}"
  [name GoogleAppsDriveLabelsV2EnableLabelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+name}:enable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2EnableLabelRequest}))

(defn labels-create
  "Creates a new Label.
https://developers.google.com/drive/labels/guides/overview

GoogleAppsDriveLabelsV2Label:
{:disabler {:person string},
 :properties {:description string, :title string},
 :appliedCapabilities
 {:canApply boolean, :canRead boolean, :canRemove boolean},
 :appliedLabelPolicy
 {:copyMode
  [COPY_MODE_UNSPECIFIED DO_NOT_COPY ALWAYS_COPY COPY_APPLIABLE]},
 :creator {:person string},
 :publisher {:person string},
 :publishTime string,
 :revisionCreateTime string,
 :name string,
 :fields
 [{:disabler {:person string},
   :properties
   {:displayName string, :insertBeforeField string, :required boolean},
   :appliedCapabilities
   {:canRead boolean, :canSearch boolean, :canWrite boolean},
   :dateOptions
   {:dateFormat string,
    :dateFormatType [DATE_FORMAT_UNSPECIFIED LONG_DATE SHORT_DATE],
    :maxValue {:day integer, :month integer, :year integer},
    :minValue {:day integer, :month integer, :year integer}},
   :creator {:person string},
   :publisher {:person string},
   :integerOptions {:maxValue string, :minValue string},
   :createTime string,
   :schemaCapabilities
   {:canEnable boolean,
    :canDisable boolean,
    :canUpdate boolean,
    :canDelete boolean},
   :queryKey string,
   :lifecycle
   {:disabledPolicy {:hideInSearch boolean, :showInApply boolean},
    :state
    [STATE_UNSPECIFIED UNPUBLISHED_DRAFT PUBLISHED DISABLED DELETED],
    :hasUnpublishedChanges boolean},
   :updateTime string,
   :disableTime string,
   :displayHints
   {:hiddenInSearch boolean,
    :disabled boolean,
    :required boolean,
    :shownInApply boolean},
   :id string,
   :userOptions {:listOptions {:maxEntries integer}},
   :updater {:person string},
   :selectionOptions
   {:listOptions {:maxEntries integer},
    :choices
    [{:disabler {:person string},
      :properties
      {:displayName string,
       :insertBeforeChoice string,
       :description string,
       :badgeConfig GoogleAppsDriveLabelsV2BadgeConfig},
      :appliedCapabilities
      {:canRead boolean, :canSearch boolean, :canSelect boolean},
      :creator {:person string},
      :publisher {:person string},
      :publishTime string,
      :createTime string,
      :schemaCapabilities
      {:canDelete boolean,
       :canEnable boolean,
       :canUpdate boolean,
       :canDisable boolean},
      :lifecycle
      {:disabledPolicy GoogleAppsDriveLabelsV2LifecycleDisabledPolicy,
       :state
       [STATE_UNSPECIFIED
        UNPUBLISHED_DRAFT
        PUBLISHED
        DISABLED
        DELETED],
       :hasUnpublishedChanges boolean},
      :updateTime string,
      :disableTime string,
      :displayHints
      {:hiddenInSearch boolean,
       :badgePriority string,
       :darkBadgeColors GoogleAppsDriveLabelsV2BadgeColors,
       :disabled boolean,
       :shownInApply boolean,
       :badgeColors GoogleAppsDriveLabelsV2BadgeColors},
      :id string,
      :updater {:person string},
      :lockStatus {:locked boolean}}]},
   :textOptions {:minLength integer, :maxLength integer},
   :lockStatus {:locked boolean}}],
 :createTime string,
 :revisionId string,
 :labelType [LABEL_TYPE_UNSPECIFIED SHARED ADMIN GOOGLE_APP],
 :schemaCapabilities
 {:canEnable boolean,
  :canDelete boolean,
  :canUpdate boolean,
  :canDisable boolean},
 :lifecycle
 {:disabledPolicy {:hideInSearch boolean, :showInApply boolean},
  :state
  [STATE_UNSPECIFIED UNPUBLISHED_DRAFT PUBLISHED DISABLED DELETED],
  :hasUnpublishedChanges boolean},
 :customer string,
 :disableTime string,
 :displayHints
 {:priority string,
  :hiddenInSearch boolean,
  :shownInApply boolean,
  :disabled boolean},
 :id string,
 :revisionCreator {:person string},
 :lockStatus {:locked boolean},
 :learnMoreUri string}

optional:
languageCode <string> The BCP-47 language code to use for evaluating localized Field labels in response. When not specified, values in the default configured language will be used.
useAdminAccess <boolean> Set to `true` in order to use the user's admin privileges. The server will verify the user is an admin before allowing access."
  ([GoogleAppsDriveLabelsV2Label]
    (labels-create GoogleAppsDriveLabelsV2Label nil))
  ([GoogleAppsDriveLabelsV2Label optional]
    (client/api-request
      {:method "POST",
       :uri-template "https://drivelabels.googleapis.com/v2/labels",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"],
       :body GoogleAppsDriveLabelsV2Label})))

(defn labels-delete
  "Permanently deletes a Label and related metadata on Drive Items. Once deleted, the Label and related Drive item metadata will be deleted. Only draft Labels, and disabled Labels may be deleted.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. Label resource name.

optional:
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access.
writeControl.requiredRevisionId <string> The revision_id of the label that the write request will be applied to. If this is not the latest revision of the label, the request will not be processed and will return a 400 Bad Request error."
  ([name] (labels-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://drivelabels.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"]})))

(defn labels-list
  "List labels.
https://developers.google.com/drive/labels/guides/overview

optional:
view <string> When specified, only certain fields belonging to the indicated view are returned.
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. This will return all Labels within the customer.
minimumRole <string> Specifies the level of access the user must have on the returned Labels. The minimum role a user must have on a label. Defaults to `READER`.
languageCode <string> The BCP-47 language code to use for evaluating localized field labels. When not specified, values in the default configured language are used.
publishedOnly <boolean> Whether to include only published labels in the results. * When `true`, only the current published label revisions are returned. Disabled labels are included. Returned label resource names reference the published revision (`labels/{id}/{revision_id}`). * When `false`, the current label revisions are returned, which might not be published. Returned label resource names don't reference a specific revision (`labels/{id}`).
pageSize <integer> Maximum number of labels to return per page. Default: 50. Max: 200.
customer <string> The customer to scope this list request to. For example: \"customers/abcd1234\". If unset, will return all labels within the current customer."
  ([] (labels-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://drivelabels.googleapis.com/v2/labels",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

(defn labels-updateLabelCopyMode
  "Updates a Label's `CopyMode`. Changes to this policy are not revisioned, do not require publishing, and take effect immediately.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. The resource name of the Label to update.
GoogleAppsDriveLabelsV2UpdateLabelCopyModeRequest:
{:useAdminAccess boolean,
 :languageCode string,
 :copyMode
 [COPY_MODE_UNSPECIFIED DO_NOT_COPY ALWAYS_COPY COPY_APPLIABLE],
 :view [LABEL_VIEW_BASIC LABEL_VIEW_FULL]}"
  [name GoogleAppsDriveLabelsV2UpdateLabelCopyModeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+name}:updateLabelCopyMode",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2UpdateLabelCopyModeRequest}))

(defn labels-delta
  "Updates a single Label by applying a set of update requests resulting in a new draft revision. The batch update is all-or-nothing: If any of the update requests are invalid, no changes are applied. The resulting draft revision must be published before the changes may be used with Drive Items.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. The resource name of the Label to update.
GoogleAppsDriveLabelsV2DeltaUpdateLabelRequest:
{:writeControl {:requiredRevisionId string},
 :useAdminAccess boolean,
 :languageCode string,
 :requests
 [{:disableField
   {:id string,
    :updateMask string,
    :disabledPolicy {:hideInSearch boolean, :showInApply boolean}},
   :deleteSelectionChoice {:id string, :fieldId string},
   :enableSelectionChoice {:id string, :fieldId string},
   :disableSelectionChoice
   {:fieldId string,
    :updateMask string,
    :id string,
    :disabledPolicy {:hideInSearch boolean, :showInApply boolean}},
   :createSelectionChoice
   {:choice
    {:disabler {:person string},
     :properties
     {:displayName string,
      :insertBeforeChoice string,
      :description string,
      :badgeConfig GoogleAppsDriveLabelsV2BadgeConfig},
     :appliedCapabilities
     {:canRead boolean, :canSearch boolean, :canSelect boolean},
     :creator {:person string},
     :publisher {:person string},
     :publishTime string,
     :createTime string,
     :schemaCapabilities
     {:canDelete boolean,
      :canEnable boolean,
      :canUpdate boolean,
      :canDisable boolean},
     :lifecycle
     {:disabledPolicy GoogleAppsDriveLabelsV2LifecycleDisabledPolicy,
      :state
      [STATE_UNSPECIFIED UNPUBLISHED_DRAFT PUBLISHED DISABLED DELETED],
      :hasUnpublishedChanges boolean},
     :updateTime string,
     :disableTime string,
     :displayHints
     {:hiddenInSearch boolean,
      :badgePriority string,
      :darkBadgeColors GoogleAppsDriveLabelsV2BadgeColors,
      :disabled boolean,
      :shownInApply boolean,
      :badgeColors GoogleAppsDriveLabelsV2BadgeColors},
     :id string,
     :updater {:person string},
     :lockStatus {:locked boolean}},
    :fieldId string},
   :createField
   {:field
    {:disabler {:person string},
     :properties
     {:displayName string,
      :insertBeforeField string,
      :required boolean},
     :appliedCapabilities
     {:canRead boolean, :canSearch boolean, :canWrite boolean},
     :dateOptions
     {:dateFormat string,
      :dateFormatType [DATE_FORMAT_UNSPECIFIED LONG_DATE SHORT_DATE],
      :maxValue GoogleTypeDate,
      :minValue GoogleTypeDate},
     :creator {:person string},
     :publisher {:person string},
     :integerOptions {:maxValue string, :minValue string},
     :createTime string,
     :schemaCapabilities
     {:canEnable boolean,
      :canDisable boolean,
      :canUpdate boolean,
      :canDelete boolean},
     :queryKey string,
     :lifecycle
     {:disabledPolicy GoogleAppsDriveLabelsV2LifecycleDisabledPolicy,
      :state
      [STATE_UNSPECIFIED UNPUBLISHED_DRAFT PUBLISHED DISABLED DELETED],
      :hasUnpublishedChanges boolean},
     :updateTime string,
     :disableTime string,
     :displayHints
     {:hiddenInSearch boolean,
      :disabled boolean,
      :required boolean,
      :shownInApply boolean},
     :id string,
     :userOptions
     {:listOptions GoogleAppsDriveLabelsV2FieldListOptions},
     :updater {:person string},
     :selectionOptions
     {:listOptions GoogleAppsDriveLabelsV2FieldListOptions,
      :choices [GoogleAppsDriveLabelsV2FieldSelectionOptionsChoice]},
     :textOptions {:minLength integer, :maxLength integer},
     :lockStatus {:locked boolean}}},
   :updateSelectionChoiceProperties
   {:id string,
    :properties
    {:displayName string,
     :insertBeforeChoice string,
     :description string,
     :badgeConfig {:color GoogleTypeColor, :priorityOverride string}},
    :fieldId string,
    :updateMask string},
   :enableField {:id string},
   :updateLabel
   {:properties {:description string, :title string},
    :updateMask string},
   :updateField
   {:properties
    {:displayName string,
     :insertBeforeField string,
     :required boolean},
    :updateMask string,
    :id string},
   :updateFieldType
   {:updateMask string,
    :selectionOptions
    {:listOptions {:maxEntries integer},
     :choices
     [{:disabler GoogleAppsDriveLabelsV2UserInfo,
       :properties
       GoogleAppsDriveLabelsV2FieldSelectionOptionsChoiceProperties,
       :appliedCapabilities
       GoogleAppsDriveLabelsV2FieldSelectionOptionsChoiceAppliedCapabilities,
       :creator GoogleAppsDriveLabelsV2UserInfo,
       :publisher GoogleAppsDriveLabelsV2UserInfo,
       :publishTime string,
       :createTime string,
       :schemaCapabilities
       GoogleAppsDriveLabelsV2FieldSelectionOptionsChoiceSchemaCapabilities,
       :lifecycle GoogleAppsDriveLabelsV2Lifecycle,
       :updateTime string,
       :disableTime string,
       :displayHints
       GoogleAppsDriveLabelsV2FieldSelectionOptionsChoiceDisplayHints,
       :id string,
       :updater GoogleAppsDriveLabelsV2UserInfo,
       :lockStatus GoogleAppsDriveLabelsV2LockStatus}]},
    :textOptions {:minLength integer, :maxLength integer},
    :id string,
    :userOptions {:listOptions {:maxEntries integer}},
    :integerOptions {:maxValue string, :minValue string},
    :dateOptions
    {:dateFormat string,
     :dateFormatType [DATE_FORMAT_UNSPECIFIED LONG_DATE SHORT_DATE],
     :maxValue {:day integer, :month integer, :year integer},
     :minValue {:day integer, :month integer, :year integer}}},
   :deleteField {:id string}}],
 :view [LABEL_VIEW_BASIC LABEL_VIEW_FULL]}"
  [name GoogleAppsDriveLabelsV2DeltaUpdateLabelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+name}:delta",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2DeltaUpdateLabelRequest}))

(defn labels-publish
  "Publish all draft changes to the Label. Once published, the Label may not return to its draft state. See `google.apps.drive.labels.v2.Lifecycle` for more information. Publishing a Label will result in a new published revision. All previous draft revisions will be deleted. Previous published revisions will be kept but are subject to automated deletion as needed. Once published, some changes are no longer permitted. Generally, any change that would invalidate or cause new restrictions on existing metadata related to the Label will be rejected. For example, the following changes to a Label will be rejected after the Label is published: * The label cannot be directly deleted. It must be disabled first, then deleted. * Field.FieldType cannot be changed. * Changes to Field validation options cannot reject something that was previously accepted. * Reducing the max entries.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. Label resource name.
GoogleAppsDriveLabelsV2PublishLabelRequest:
{:writeControl {:requiredRevisionId string},
 :languageCode string,
 :useAdminAccess boolean}"
  [name GoogleAppsDriveLabelsV2PublishLabelRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+name}:publish",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2PublishLabelRequest}))

(defn labels-permissions-list
  "Lists a Label's permissions.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name on which Label Permission are listed. Format: labels/{label}

optional:
pageSize <integer> Maximum number of permissions to return per page. Default: 50. Max: 200.
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([parent] (labels-permissions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/permissions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

(defn labels-permissions-create
  "Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name on the Label Permission is created. Format: labels/{label}
GoogleAppsDriveLabelsV2LabelPermission:
{:group string,
 :person string,
 :email string,
 :name string,
 :role [LABEL_ROLE_UNSPECIFIED READER APPLIER ORGANIZER EDITOR],
 :audience string}

optional:
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([parent GoogleAppsDriveLabelsV2LabelPermission]
    (labels-permissions-create
      parent
      GoogleAppsDriveLabelsV2LabelPermission
      nil))
  ([parent GoogleAppsDriveLabelsV2LabelPermission optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/permissions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"],
       :body GoogleAppsDriveLabelsV2LabelPermission})))

(defn labels-permissions-batchDelete
  "Deletes Label permissions. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name shared by all permissions being deleted. Format: labels/{label} If this is set, the parent field in the UpdateLabelPermissionRequest messages must either be empty or match this field.
GoogleAppsDriveLabelsV2BatchDeleteLabelPermissionsRequest:
{:useAdminAccess boolean,
 :requests [{:useAdminAccess boolean, :name string}]}"
  [parent GoogleAppsDriveLabelsV2BatchDeleteLabelPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+parent}/permissions:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2BatchDeleteLabelPermissionsRequest}))

(defn labels-permissions-batchUpdate
  "Updates Label permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name shared by all permissions being updated. Format: labels/{label} If this is set, the parent field in the UpdateLabelPermissionRequest messages must either be empty or match this field.
GoogleAppsDriveLabelsV2BatchUpdateLabelPermissionsRequest:
{:useAdminAccess boolean,
 :requests
 [{:labelPermission
   {:group string,
    :person string,
    :email string,
    :name string,
    :role [LABEL_ROLE_UNSPECIFIED READER APPLIER ORGANIZER EDITOR],
    :audience string},
   :parent string,
   :useAdminAccess boolean}]}"
  [parent GoogleAppsDriveLabelsV2BatchUpdateLabelPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+parent}/permissions:batchUpdate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2BatchUpdateLabelPermissionsRequest}))

(defn labels-permissions-delete
  "Deletes a Label's permission. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. Label Permission resource name.

optional:
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([name] (labels-permissions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://drivelabels.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"]})))

(defn labels-locks-list
  "Lists the LabelLocks on a Label.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. Label on which Locks are applied. Format: labels/{label}

optional:
pageSize <integer> Maximum number of Locks to return per page. Default: 100. Max: 200."
  ([parent] (labels-locks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/locks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

(defn labels-revisions-updatePermissions
  "Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name.
GoogleAppsDriveLabelsV2LabelPermission:
{:group string,
 :person string,
 :email string,
 :name string,
 :role [LABEL_ROLE_UNSPECIFIED READER APPLIER ORGANIZER EDITOR],
 :audience string}

optional:
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([parent GoogleAppsDriveLabelsV2LabelPermission]
    (labels-revisions-updatePermissions
      parent
      GoogleAppsDriveLabelsV2LabelPermission
      nil))
  ([parent GoogleAppsDriveLabelsV2LabelPermission optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/permissions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"],
       :body GoogleAppsDriveLabelsV2LabelPermission})))

(defn labels-revisions-locks-list
  "Lists the LabelLocks on a Label.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. Label on which Locks are applied. Format: labels/{label}

optional:
pageSize <integer> Maximum number of Locks to return per page. Default: 100. Max: 200."
  ([parent] (labels-revisions-locks-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/locks",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

(defn labels-revisions-permissions-batchUpdate
  "Updates Label permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name shared by all permissions being updated. Format: labels/{label} If this is set, the parent field in the UpdateLabelPermissionRequest messages must either be empty or match this field.
GoogleAppsDriveLabelsV2BatchUpdateLabelPermissionsRequest:
{:useAdminAccess boolean,
 :requests
 [{:labelPermission
   {:group string,
    :person string,
    :email string,
    :name string,
    :role [LABEL_ROLE_UNSPECIFIED READER APPLIER ORGANIZER EDITOR],
    :audience string},
   :parent string,
   :useAdminAccess boolean}]}"
  [parent GoogleAppsDriveLabelsV2BatchUpdateLabelPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+parent}/permissions:batchUpdate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2BatchUpdateLabelPermissionsRequest}))

(defn labels-revisions-permissions-list
  "Lists a Label's permissions.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name on which Label Permission are listed. Format: labels/{label}

optional:
pageSize <integer> Maximum number of permissions to return per page. Default: 50. Max: 200.
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([parent] (labels-revisions-permissions-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/permissions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

(defn labels-revisions-permissions-create
  "Updates a Label's permissions. If a permission for the indicated principal doesn't exist, a new Label Permission is created, otherwise the existing permission is updated. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name on the Label Permission is created. Format: labels/{label}
GoogleAppsDriveLabelsV2LabelPermission:
{:group string,
 :person string,
 :email string,
 :name string,
 :role [LABEL_ROLE_UNSPECIFIED READER APPLIER ORGANIZER EDITOR],
 :audience string}

optional:
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([parent GoogleAppsDriveLabelsV2LabelPermission]
    (labels-revisions-permissions-create
      parent
      GoogleAppsDriveLabelsV2LabelPermission
      nil))
  ([parent GoogleAppsDriveLabelsV2LabelPermission optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://drivelabels.googleapis.com/v2/{+parent}/permissions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"],
       :body GoogleAppsDriveLabelsV2LabelPermission})))

(defn labels-revisions-permissions-delete
  "Deletes a Label's permission. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. Label Permission resource name.

optional:
useAdminAccess <boolean> Set to `true` in order to use the user's admin credentials. The server will verify the user is an admin for the Label before allowing access."
  ([name] (labels-revisions-permissions-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://drivelabels.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.labels"]})))

(defn labels-revisions-permissions-batchDelete
  "Deletes Label permissions. Permissions affect the Label resource as a whole, are not revisioned, and do not require publishing.
https://developers.google.com/drive/labels/guides/overview

parent <string> Required. The parent Label resource name shared by all permissions being deleted. Format: labels/{label} If this is set, the parent field in the UpdateLabelPermissionRequest messages must either be empty or match this field.
GoogleAppsDriveLabelsV2BatchDeleteLabelPermissionsRequest:
{:useAdminAccess boolean,
 :requests [{:useAdminAccess boolean, :name string}]}"
  [parent GoogleAppsDriveLabelsV2BatchDeleteLabelPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://drivelabels.googleapis.com/v2/{+parent}/permissions:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/drive.admin.labels"
      "https://www.googleapis.com/auth/drive.labels"],
     :body GoogleAppsDriveLabelsV2BatchDeleteLabelPermissionsRequest}))

(defn users-getCapabilities
  "Gets the user capabilities.
https://developers.google.com/drive/labels/guides/overview

name <string> Required. The resource name of the user. Only \"users/me/capabilities\" is supported.

optional:
customer <string> The customer to scope this request to. For example: \"customers/abcd1234\". If unset, will return settings within the current customer."
  ([name] (users-getCapabilities name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://drivelabels.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/drive.admin.labels"
        "https://www.googleapis.com/auth/drive.admin.labels.readonly"
        "https://www.googleapis.com/auth/drive.labels"
        "https://www.googleapis.com/auth/drive.labels.readonly"]})))

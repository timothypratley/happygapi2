(ns happygapi2.accessapproval
  "Access Approval API
An API for controlling access to data by Google personnel.
See: https://cloud.google.com/assured-workloads/access-approval/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-getAccessApprovalSettings
  "Gets the settings associated with a project, folder, or organization.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/getAccessApprovalSettings

name <string> The name of the AccessApprovalSettings to retrieve. Format: \"{projects|folders|organizations}/{id}/accessApprovalSettings\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-updateAccessApprovalSettings
  "Updates the settings associated with a project, folder, or organization. Settings to update are determined by the value of field_mask.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/updateAccessApprovalSettings

name <string> The resource name of the settings. Format is one of: * \"projects/{project}/accessApprovalSettings\" * \"folders/{folder}/accessApprovalSettings\" * \"organizations/{organization}/accessApprovalSettings\"
AccessApprovalSettings:
{:notificationPubsubTopic string,
 :requestScopeMaxWidthPreference
 [REQUEST_SCOPE_MAX_WIDTH_PREFERENCE_UNSPECIFIED
  ORGANIZATION
  FOLDER
  PROJECT],
 :enrolledAncestor boolean,
 :name string,
 :preferNoBroadApprovalRequests boolean,
 :notificationEmails [string],
 :ancestorHasActiveKeyVersion boolean,
 :preferredRequestExpirationDays integer,
 :invalidKeyVersion boolean,
 :activeKeyVersion string,
 :enrolledServices
 [{:cloudProduct string,
   :enrollmentLevel [ENROLLMENT_LEVEL_UNSPECIFIED BLOCK_ALL]}],
 :requireCustomerVisibleJustification boolean}

optional:
updateMask <string> The update mask applies to the settings. Only the top level fields of AccessApprovalSettings (notification_emails & enrolled_services) are supported. For each field, if it is included, the currently stored value will be entirely overwritten with the value of the field passed in this request. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If this field is left unset, only the notification_emails field will be updated."
  ([name AccessApprovalSettings]
    (projects-updateAccessApprovalSettings
      name
      AccessApprovalSettings
      nil))
  ([name AccessApprovalSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accessapproval.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AccessApprovalSettings})))

(defn projects-deleteAccessApprovalSettings
  "Deletes the settings associated with a project, folder, or organization. This will have the effect of disabling Access Approval for the project, folder, or organization, but only if all ancestors also have Access Approval disabled. If Access Approval is enabled at a higher level of the hierarchy, then Access Approval will still be enabled at this level as the settings are inherited.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/deleteAccessApprovalSettings

name <string> Name of the AccessApprovalSettings to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-getServiceAccount
  "Retrieves the service account that is used by Access Approval to access KMS keys for signing approved approval requests.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/getServiceAccount

name <string> Name of the AccessApprovalServiceAccount to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-approvalRequests-list
  "Lists approval requests associated with a project, folder, or organization. Approval requests can be filtered by state (pending, active, dismissed). The order is reverse chronological.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/approvalRequests/list

parent <string> The parent resource. This may be \"projects/{project}\", \"folders/{folder}\", or \"organizations/{organization}\".

optional:
filter <string> A filter on the type of approval requests to retrieve. Must be one of the following values: * [not set]: Requests that are pending or have active approvals. * ALL: All requests. * PENDING: Only pending requests. * ACTIVE: Only active (i.e. currently approved) requests. * DISMISSED: Only requests that have been dismissed, or requests that are not approved and past expiration. * EXPIRED: Only requests that have been approved, and the approval has expired. * HISTORY: Active, dismissed and expired requests.
pageSize <integer> Requested page size."
  ([parent] (projects-approvalRequests-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accessapproval.googleapis.com/v1/{+parent}/approvalRequests",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-approvalRequests-get
  "Gets an approval request. Returns NOT_FOUND if the request does not exist.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/approvalRequests/get

name <string> The name of the approval request to retrieve. Format: \"{projects|folders|organizations}/{id}/approvalRequests/{approval_request}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-approvalRequests-approve
  "Approves a request and returns the updated ApprovalRequest. Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/approvalRequests/approve

name <string> Name of the approval request to approve.
ApproveApprovalRequestMessage:
{:expireTime string}"
  [name ApproveApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:approve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ApproveApprovalRequestMessage}))

(defn projects-approvalRequests-dismiss
  "Dismisses a request. Returns the updated ApprovalRequest. NOTE: This does not deny access to the resource if another request has been made and approved. It is equivalent in effect to ignoring the request altogether. Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/approvalRequests/dismiss

name <string> Name of the ApprovalRequest to dismiss.
DismissApprovalRequestMessage:
object"
  [name DismissApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:dismiss",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DismissApprovalRequestMessage}))

(defn projects-approvalRequests-invalidate
  "Invalidates an existing ApprovalRequest. Returns the updated ApprovalRequest. NOTE: This does not deny access to the resource if another request has been made and approved. It only invalidates a single approval. Returns FAILED_PRECONDITION if the request exists but is not in an approved state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/projects/approvalRequests/invalidate

name <string> Name of the ApprovalRequest to invalidate.
InvalidateApprovalRequestMessage:
object"
  [name InvalidateApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:invalidate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InvalidateApprovalRequestMessage}))

(defn folders-getAccessApprovalSettings
  "Gets the settings associated with a project, folder, or organization.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/getAccessApprovalSettings

name <string> The name of the AccessApprovalSettings to retrieve. Format: \"{projects|folders|organizations}/{id}/accessApprovalSettings\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-updateAccessApprovalSettings
  "Updates the settings associated with a project, folder, or organization. Settings to update are determined by the value of field_mask.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/updateAccessApprovalSettings

name <string> The resource name of the settings. Format is one of: * \"projects/{project}/accessApprovalSettings\" * \"folders/{folder}/accessApprovalSettings\" * \"organizations/{organization}/accessApprovalSettings\"
AccessApprovalSettings:
{:notificationPubsubTopic string,
 :requestScopeMaxWidthPreference
 [REQUEST_SCOPE_MAX_WIDTH_PREFERENCE_UNSPECIFIED
  ORGANIZATION
  FOLDER
  PROJECT],
 :enrolledAncestor boolean,
 :name string,
 :preferNoBroadApprovalRequests boolean,
 :notificationEmails [string],
 :ancestorHasActiveKeyVersion boolean,
 :preferredRequestExpirationDays integer,
 :invalidKeyVersion boolean,
 :activeKeyVersion string,
 :enrolledServices
 [{:cloudProduct string,
   :enrollmentLevel [ENROLLMENT_LEVEL_UNSPECIFIED BLOCK_ALL]}],
 :requireCustomerVisibleJustification boolean}

optional:
updateMask <string> The update mask applies to the settings. Only the top level fields of AccessApprovalSettings (notification_emails & enrolled_services) are supported. For each field, if it is included, the currently stored value will be entirely overwritten with the value of the field passed in this request. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If this field is left unset, only the notification_emails field will be updated."
  ([name AccessApprovalSettings]
    (folders-updateAccessApprovalSettings
      name
      AccessApprovalSettings
      nil))
  ([name AccessApprovalSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accessapproval.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AccessApprovalSettings})))

(defn folders-deleteAccessApprovalSettings
  "Deletes the settings associated with a project, folder, or organization. This will have the effect of disabling Access Approval for the project, folder, or organization, but only if all ancestors also have Access Approval disabled. If Access Approval is enabled at a higher level of the hierarchy, then Access Approval will still be enabled at this level as the settings are inherited.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/deleteAccessApprovalSettings

name <string> Name of the AccessApprovalSettings to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-getServiceAccount
  "Retrieves the service account that is used by Access Approval to access KMS keys for signing approved approval requests.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/getServiceAccount

name <string> Name of the AccessApprovalServiceAccount to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-approvalRequests-list
  "Lists approval requests associated with a project, folder, or organization. Approval requests can be filtered by state (pending, active, dismissed). The order is reverse chronological.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/approvalRequests/list

parent <string> The parent resource. This may be \"projects/{project}\", \"folders/{folder}\", or \"organizations/{organization}\".

optional:
filter <string> A filter on the type of approval requests to retrieve. Must be one of the following values: * [not set]: Requests that are pending or have active approvals. * ALL: All requests. * PENDING: Only pending requests. * ACTIVE: Only active (i.e. currently approved) requests. * DISMISSED: Only requests that have been dismissed, or requests that are not approved and past expiration. * EXPIRED: Only requests that have been approved, and the approval has expired. * HISTORY: Active, dismissed and expired requests.
pageSize <integer> Requested page size."
  ([parent] (folders-approvalRequests-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accessapproval.googleapis.com/v1/{+parent}/approvalRequests",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-approvalRequests-get
  "Gets an approval request. Returns NOT_FOUND if the request does not exist.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/approvalRequests/get

name <string> The name of the approval request to retrieve. Format: \"{projects|folders|organizations}/{id}/approvalRequests/{approval_request}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-approvalRequests-approve
  "Approves a request and returns the updated ApprovalRequest. Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/approvalRequests/approve

name <string> Name of the approval request to approve.
ApproveApprovalRequestMessage:
{:expireTime string}"
  [name ApproveApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:approve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ApproveApprovalRequestMessage}))

(defn folders-approvalRequests-dismiss
  "Dismisses a request. Returns the updated ApprovalRequest. NOTE: This does not deny access to the resource if another request has been made and approved. It is equivalent in effect to ignoring the request altogether. Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/approvalRequests/dismiss

name <string> Name of the ApprovalRequest to dismiss.
DismissApprovalRequestMessage:
object"
  [name DismissApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:dismiss",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DismissApprovalRequestMessage}))

(defn folders-approvalRequests-invalidate
  "Invalidates an existing ApprovalRequest. Returns the updated ApprovalRequest. NOTE: This does not deny access to the resource if another request has been made and approved. It only invalidates a single approval. Returns FAILED_PRECONDITION if the request exists but is not in an approved state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/folders/approvalRequests/invalidate

name <string> Name of the ApprovalRequest to invalidate.
InvalidateApprovalRequestMessage:
object"
  [name InvalidateApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:invalidate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InvalidateApprovalRequestMessage}))

(defn organizations-getAccessApprovalSettings
  "Gets the settings associated with a project, folder, or organization.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/getAccessApprovalSettings

name <string> The name of the AccessApprovalSettings to retrieve. Format: \"{projects|folders|organizations}/{id}/accessApprovalSettings\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-updateAccessApprovalSettings
  "Updates the settings associated with a project, folder, or organization. Settings to update are determined by the value of field_mask.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/updateAccessApprovalSettings

name <string> The resource name of the settings. Format is one of: * \"projects/{project}/accessApprovalSettings\" * \"folders/{folder}/accessApprovalSettings\" * \"organizations/{organization}/accessApprovalSettings\"
AccessApprovalSettings:
{:notificationPubsubTopic string,
 :requestScopeMaxWidthPreference
 [REQUEST_SCOPE_MAX_WIDTH_PREFERENCE_UNSPECIFIED
  ORGANIZATION
  FOLDER
  PROJECT],
 :enrolledAncestor boolean,
 :name string,
 :preferNoBroadApprovalRequests boolean,
 :notificationEmails [string],
 :ancestorHasActiveKeyVersion boolean,
 :preferredRequestExpirationDays integer,
 :invalidKeyVersion boolean,
 :activeKeyVersion string,
 :enrolledServices
 [{:cloudProduct string,
   :enrollmentLevel [ENROLLMENT_LEVEL_UNSPECIFIED BLOCK_ALL]}],
 :requireCustomerVisibleJustification boolean}

optional:
updateMask <string> The update mask applies to the settings. Only the top level fields of AccessApprovalSettings (notification_emails & enrolled_services) are supported. For each field, if it is included, the currently stored value will be entirely overwritten with the value of the field passed in this request. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If this field is left unset, only the notification_emails field will be updated."
  ([name AccessApprovalSettings]
    (organizations-updateAccessApprovalSettings
      name
      AccessApprovalSettings
      nil))
  ([name AccessApprovalSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://accessapproval.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body AccessApprovalSettings})))

(defn organizations-deleteAccessApprovalSettings
  "Deletes the settings associated with a project, folder, or organization. This will have the effect of disabling Access Approval for the project, folder, or organization, but only if all ancestors also have Access Approval disabled. If Access Approval is enabled at a higher level of the hierarchy, then Access Approval will still be enabled at this level as the settings are inherited.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/deleteAccessApprovalSettings

name <string> Name of the AccessApprovalSettings to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-getServiceAccount
  "Retrieves the service account that is used by Access Approval to access KMS keys for signing approved approval requests.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/getServiceAccount

name <string> Name of the AccessApprovalServiceAccount to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-approvalRequests-list
  "Lists approval requests associated with a project, folder, or organization. Approval requests can be filtered by state (pending, active, dismissed). The order is reverse chronological.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/approvalRequests/list

parent <string> The parent resource. This may be \"projects/{project}\", \"folders/{folder}\", or \"organizations/{organization}\".

optional:
filter <string> A filter on the type of approval requests to retrieve. Must be one of the following values: * [not set]: Requests that are pending or have active approvals. * ALL: All requests. * PENDING: Only pending requests. * ACTIVE: Only active (i.e. currently approved) requests. * DISMISSED: Only requests that have been dismissed, or requests that are not approved and past expiration. * EXPIRED: Only requests that have been approved, and the approval has expired. * HISTORY: Active, dismissed and expired requests.
pageSize <integer> Requested page size."
  ([parent] (organizations-approvalRequests-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://accessapproval.googleapis.com/v1/{+parent}/approvalRequests",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-approvalRequests-get
  "Gets an approval request. Returns NOT_FOUND if the request does not exist.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/approvalRequests/get

name <string> The name of the approval request to retrieve. Format: \"{projects|folders|organizations}/{id}/approvalRequests/{approval_request}\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://accessapproval.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-approvalRequests-approve
  "Approves a request and returns the updated ApprovalRequest. Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/approvalRequests/approve

name <string> Name of the approval request to approve.
ApproveApprovalRequestMessage:
{:expireTime string}"
  [name ApproveApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:approve",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ApproveApprovalRequestMessage}))

(defn organizations-approvalRequests-dismiss
  "Dismisses a request. Returns the updated ApprovalRequest. NOTE: This does not deny access to the resource if another request has been made and approved. It is equivalent in effect to ignoring the request altogether. Returns NOT_FOUND if the request does not exist. Returns FAILED_PRECONDITION if the request exists but is not in a pending state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/approvalRequests/dismiss

name <string> Name of the ApprovalRequest to dismiss.
DismissApprovalRequestMessage:
object"
  [name DismissApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:dismiss",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DismissApprovalRequestMessage}))

(defn organizations-approvalRequests-invalidate
  "Invalidates an existing ApprovalRequest. Returns the updated ApprovalRequest. NOTE: This does not deny access to the resource if another request has been made and approved. It only invalidates a single approval. Returns FAILED_PRECONDITION if the request exists but is not in an approved state.
https://cloud.google.com/assured-workloads/access-approval/docs/reference/rest/v1/organizations/approvalRequests/invalidate

name <string> Name of the ApprovalRequest to invalidate.
InvalidateApprovalRequestMessage:
object"
  [name InvalidateApprovalRequestMessage]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://accessapproval.googleapis.com/v1/{+name}:invalidate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InvalidateApprovalRequestMessage}))

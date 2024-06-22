(ns happygapi2.essentialcontacts
  "Essential Contacts API

See: https://cloud.google.com/resource-manager/docs/managing-notification-contacts"
  (:require [happy.oauth2.client :as client]))

(defn organizations-contacts-patch
  "Updates a contact. Note: A contact's email address cannot be changed.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Output only. The identifier for the contact. Format: {resource_type}/{resource_id}/contacts/{contact_id}
GoogleCloudEssentialcontactsV1Contact:
{:validateTime string,
 :name string,
 :notificationCategorySubscriptions
 [[NOTIFICATION_CATEGORY_UNSPECIFIED
   ALL
   SUSPENSION
   SECURITY
   TECHNICAL
   BILLING
   LEGAL
   PRODUCT_UPDATES
   TECHNICAL_INCIDENTS]],
 :validationState [VALIDATION_STATE_UNSPECIFIED VALID INVALID],
 :email string,
 :languageTag string}

optional:
updateMask <string> Optional. The update mask applied to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name GoogleCloudEssentialcontactsV1Contact]
    (organizations-contacts-patch
      name
      GoogleCloudEssentialcontactsV1Contact
      nil))
  ([name GoogleCloudEssentialcontactsV1Contact optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudEssentialcontactsV1Contact})))

(defn organizations-contacts-delete
  "Deletes a contact.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Required. The name of the contact to delete. Format: organizations/{organization_id}/contacts/{contact_id}, folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-contacts-create
  "Adds a new contact for a resource.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The resource to save this contact for. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
GoogleCloudEssentialcontactsV1Contact:
{:validateTime string,
 :name string,
 :notificationCategorySubscriptions
 [[NOTIFICATION_CATEGORY_UNSPECIFIED
   ALL
   SUSPENSION
   SECURITY
   TECHNICAL
   BILLING
   LEGAL
   PRODUCT_UPDATES
   TECHNICAL_INCIDENTS]],
 :validationState [VALIDATION_STATE_UNSPECIFIED VALID INVALID],
 :email string,
 :languageTag string}"
  [parent GoogleCloudEssentialcontactsV1Contact]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudEssentialcontactsV1Contact}))

(defn organizations-contacts-sendTestMessage
  "Allows a contact admin to send a test message to contact to verify that it has been configured correctly.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

resource <string> Required. The name of the resource to send the test message for. All contacts must either be set directly on this resource or inherited from another resource that is an ancestor of this one. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
GoogleCloudEssentialcontactsV1SendTestMessageRequest:
{:notificationCategory
 [NOTIFICATION_CATEGORY_UNSPECIFIED
  ALL
  SUSPENSION
  SECURITY
  TECHNICAL
  BILLING
  LEGAL
  PRODUCT_UPDATES
  TECHNICAL_INCIDENTS],
 :contacts [string]}"
  [resource GoogleCloudEssentialcontactsV1SendTestMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+resource}/contacts:sendTestMessage",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudEssentialcontactsV1SendTestMessageRequest}))

(defn organizations-contacts-get
  "Gets a single contact.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Required. The name of the contact to retrieve. Format: organizations/{organization_id}/contacts/{contact_id}, folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn organizations-contacts-list
  "Lists the contacts that have been set on a resource.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The parent resource name. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}

optional:
pageSize <integer> Optional. The maximum number of results to return from this request. Non-positive values are ignored. The presence of `next_page_token` in the response indicates that more results might be available. If not specified, the default page_size is 100."
  ([parent] (organizations-contacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-contacts-compute
  "Lists all contacts for the resource that are subscribed to the specified notification categories, including contacts inherited from any parent resources.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The name of the resource to compute contacts for. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}

optional:
pageSize <integer> Optional. The maximum number of results to return from this request. Non-positive values are ignored. The presence of `next_page_token` in the response indicates that more results might be available. If not specified, the default page_size is 100.
notificationCategories <string> The categories of notifications to compute contacts for. If ALL is included in this list, contacts subscribed to any notification category will be returned."
  ([parent] (organizations-contacts-compute parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts:compute",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-contacts-sendTestMessage
  "Allows a contact admin to send a test message to contact to verify that it has been configured correctly.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

resource <string> Required. The name of the resource to send the test message for. All contacts must either be set directly on this resource or inherited from another resource that is an ancestor of this one. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
GoogleCloudEssentialcontactsV1SendTestMessageRequest:
{:notificationCategory
 [NOTIFICATION_CATEGORY_UNSPECIFIED
  ALL
  SUSPENSION
  SECURITY
  TECHNICAL
  BILLING
  LEGAL
  PRODUCT_UPDATES
  TECHNICAL_INCIDENTS],
 :contacts [string]}"
  [resource GoogleCloudEssentialcontactsV1SendTestMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+resource}/contacts:sendTestMessage",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudEssentialcontactsV1SendTestMessageRequest}))

(defn folders-contacts-get
  "Gets a single contact.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Required. The name of the contact to retrieve. Format: organizations/{organization_id}/contacts/{contact_id}, folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-contacts-compute
  "Lists all contacts for the resource that are subscribed to the specified notification categories, including contacts inherited from any parent resources.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The name of the resource to compute contacts for. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}

optional:
notificationCategories <string> The categories of notifications to compute contacts for. If ALL is included in this list, contacts subscribed to any notification category will be returned.
pageSize <integer> Optional. The maximum number of results to return from this request. Non-positive values are ignored. The presence of `next_page_token` in the response indicates that more results might be available. If not specified, the default page_size is 100."
  ([parent] (folders-contacts-compute parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts:compute",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-contacts-list
  "Lists the contacts that have been set on a resource.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The parent resource name. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}

optional:
pageSize <integer> Optional. The maximum number of results to return from this request. Non-positive values are ignored. The presence of `next_page_token` in the response indicates that more results might be available. If not specified, the default page_size is 100."
  ([parent] (folders-contacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn folders-contacts-create
  "Adds a new contact for a resource.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The resource to save this contact for. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
GoogleCloudEssentialcontactsV1Contact:
{:validateTime string,
 :name string,
 :notificationCategorySubscriptions
 [[NOTIFICATION_CATEGORY_UNSPECIFIED
   ALL
   SUSPENSION
   SECURITY
   TECHNICAL
   BILLING
   LEGAL
   PRODUCT_UPDATES
   TECHNICAL_INCIDENTS]],
 :validationState [VALIDATION_STATE_UNSPECIFIED VALID INVALID],
 :email string,
 :languageTag string}"
  [parent GoogleCloudEssentialcontactsV1Contact]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudEssentialcontactsV1Contact}))

(defn folders-contacts-delete
  "Deletes a contact.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Required. The name of the contact to delete. Format: organizations/{organization_id}/contacts/{contact_id}, folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn folders-contacts-patch
  "Updates a contact. Note: A contact's email address cannot be changed.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Output only. The identifier for the contact. Format: {resource_type}/{resource_id}/contacts/{contact_id}
GoogleCloudEssentialcontactsV1Contact:
{:validateTime string,
 :name string,
 :notificationCategorySubscriptions
 [[NOTIFICATION_CATEGORY_UNSPECIFIED
   ALL
   SUSPENSION
   SECURITY
   TECHNICAL
   BILLING
   LEGAL
   PRODUCT_UPDATES
   TECHNICAL_INCIDENTS]],
 :validationState [VALIDATION_STATE_UNSPECIFIED VALID INVALID],
 :email string,
 :languageTag string}

optional:
updateMask <string> Optional. The update mask applied to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name GoogleCloudEssentialcontactsV1Contact]
    (folders-contacts-patch
      name
      GoogleCloudEssentialcontactsV1Contact
      nil))
  ([name GoogleCloudEssentialcontactsV1Contact optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudEssentialcontactsV1Contact})))

(defn projects-contacts-compute
  "Lists all contacts for the resource that are subscribed to the specified notification categories, including contacts inherited from any parent resources.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The name of the resource to compute contacts for. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}

optional:
notificationCategories <string> The categories of notifications to compute contacts for. If ALL is included in this list, contacts subscribed to any notification category will be returned.
pageSize <integer> Optional. The maximum number of results to return from this request. Non-positive values are ignored. The presence of `next_page_token` in the response indicates that more results might be available. If not specified, the default page_size is 100."
  ([parent] (projects-contacts-compute parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts:compute",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-contacts-create
  "Adds a new contact for a resource.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The resource to save this contact for. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
GoogleCloudEssentialcontactsV1Contact:
{:validateTime string,
 :name string,
 :notificationCategorySubscriptions
 [[NOTIFICATION_CATEGORY_UNSPECIFIED
   ALL
   SUSPENSION
   SECURITY
   TECHNICAL
   BILLING
   LEGAL
   PRODUCT_UPDATES
   TECHNICAL_INCIDENTS]],
 :validationState [VALIDATION_STATE_UNSPECIFIED VALID INVALID],
 :email string,
 :languageTag string}"
  [parent GoogleCloudEssentialcontactsV1Contact]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudEssentialcontactsV1Contact}))

(defn projects-contacts-list
  "Lists the contacts that have been set on a resource.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

parent <string> Required. The parent resource name. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}

optional:
pageSize <integer> Optional. The maximum number of results to return from this request. Non-positive values are ignored. The presence of `next_page_token` in the response indicates that more results might be available. If not specified, the default page_size is 100."
  ([parent] (projects-contacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+parent}/contacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-contacts-delete
  "Deletes a contact.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Required. The name of the contact to delete. Format: organizations/{organization_id}/contacts/{contact_id}, folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-contacts-get
  "Gets a single contact.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Required. The name of the contact to retrieve. Format: organizations/{organization_id}/contacts/{contact_id}, folders/{folder_id}/contacts/{contact_id} or projects/{project_id}/contacts/{contact_id}"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-contacts-sendTestMessage
  "Allows a contact admin to send a test message to contact to verify that it has been configured correctly.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

resource <string> Required. The name of the resource to send the test message for. All contacts must either be set directly on this resource or inherited from another resource that is an ancestor of this one. Format: organizations/{organization_id}, folders/{folder_id} or projects/{project_id}
GoogleCloudEssentialcontactsV1SendTestMessageRequest:
{:notificationCategory
 [NOTIFICATION_CATEGORY_UNSPECIFIED
  ALL
  SUSPENSION
  SECURITY
  TECHNICAL
  BILLING
  LEGAL
  PRODUCT_UPDATES
  TECHNICAL_INCIDENTS],
 :contacts [string]}"
  [resource GoogleCloudEssentialcontactsV1SendTestMessageRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://essentialcontacts.googleapis.com/v1/{+resource}/contacts:sendTestMessage",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GoogleCloudEssentialcontactsV1SendTestMessageRequest}))

(defn projects-contacts-patch
  "Updates a contact. Note: A contact's email address cannot be changed.
https://cloud.google.com/resource-manager/docs/managing-notification-contacts

name <string> Output only. The identifier for the contact. Format: {resource_type}/{resource_id}/contacts/{contact_id}
GoogleCloudEssentialcontactsV1Contact:
{:validateTime string,
 :name string,
 :notificationCategorySubscriptions
 [[NOTIFICATION_CATEGORY_UNSPECIFIED
   ALL
   SUSPENSION
   SECURITY
   TECHNICAL
   BILLING
   LEGAL
   PRODUCT_UPDATES
   TECHNICAL_INCIDENTS]],
 :validationState [VALIDATION_STATE_UNSPECIFIED VALID INVALID],
 :email string,
 :languageTag string}

optional:
updateMask <string> Optional. The update mask applied to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name GoogleCloudEssentialcontactsV1Contact]
    (projects-contacts-patch
      name
      GoogleCloudEssentialcontactsV1Contact
      nil))
  ([name GoogleCloudEssentialcontactsV1Contact optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://essentialcontacts.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body GoogleCloudEssentialcontactsV1Contact})))

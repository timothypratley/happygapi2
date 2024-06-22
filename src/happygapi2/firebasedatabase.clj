(ns happygapi2.firebasedatabase
  "Firebase Realtime Database API
The Firebase Realtime Database API enables programmatic provisioning and management of Realtime Database instances.
See: https://firebase.google.com/docs/reference/rest/database/database-management/rest/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-instances-undelete
  "Restores a DatabaseInstance that was previously marked to be deleted. After the delete method is used, DatabaseInstances are set to the DELETED state for 20 days, and will be purged within 30 days. Databases in the DELETED state can be undeleted without losing any data. This method may only be used on a DatabaseInstance in the DELETED state. Purged DatabaseInstances may not be recovered.
https://firebase.google.com/docs/reference/rest/database/database-management/rest/v1beta/projects.locations.instances/undelete

name <string> Required. The fully qualified resource name of the database instance, in the form: `projects/{project-number}/locations/{location-id}/instances/{database-id}`
UndeleteDatabaseInstanceRequest:
object"
  [name UndeleteDatabaseInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasedatabase.googleapis.com/v1beta/{+name}:undelete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body UndeleteDatabaseInstanceRequest}))

(defn projects-locations-instances-get
  "Gets the DatabaseInstance identified by the specified resource name.
https://firebase.google.com/docs/reference/rest/database/database-management/rest/v1beta/projects.locations.instances/get

name <string> Required. The fully qualified resource name of the database instance, in the form: `projects/{project-number}/locations/{location-id}/instances/{database-id}`. `database-id` is a globally unique identifier across all parent collections. For convenience, this method allows you to supply `-` as a wildcard character in place of specific collections under `projects` and `locations`. The resulting wildcarding form of the method is: `projects/-/locations/-/instances/{database-id}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://firebasedatabase.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/firebase"
      "https://www.googleapis.com/auth/firebase.readonly"]}))

(defn projects-locations-instances-reenable
  "Enables a DatabaseInstance. The database must have been disabled previously using DisableDatabaseInstance. The state of a successfully reenabled DatabaseInstance is ACTIVE.
https://firebase.google.com/docs/reference/rest/database/database-management/rest/v1beta/projects.locations.instances/reenable

name <string> Required. The fully qualified resource name of the database instance, in the form: `projects/{project-number}/locations/{location-id}/instances/{database-id}`
ReenableDatabaseInstanceRequest:
object"
  [name ReenableDatabaseInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasedatabase.googleapis.com/v1beta/{+name}:reenable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body ReenableDatabaseInstanceRequest}))

(defn projects-locations-instances-disable
  "Disables a DatabaseInstance. The database can be re-enabled later using ReenableDatabaseInstance. When a database is disabled, all reads and writes are denied, including view access in the Firebase console.
https://firebase.google.com/docs/reference/rest/database/database-management/rest/v1beta/projects.locations.instances/disable

name <string> Required. The fully qualified resource name of the database instance, in the form: `projects/{project-number}/locations/{location-id}/instances/{database-id}`
DisableDatabaseInstanceRequest:
object"
  [name DisableDatabaseInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://firebasedatabase.googleapis.com/v1beta/{+name}:disable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"],
     :body DisableDatabaseInstanceRequest}))

(defn projects-locations-instances-create
  "Requests that a new DatabaseInstance be created. The state of a successfully created DatabaseInstance is ACTIVE. Only available for projects on the Blaze plan. Projects can be upgraded using the Cloud Billing API https://cloud.google.com/billing/reference/rest/v1/projects/updateBillingInfo. Note that it might take a few minutes for billing enablement state to propagate to Firebase systems.
https://firebase.google.com/docs/reference/rest/database/database-management/rest/v1beta/projects.locations.instances/create

parent <string> Required. The parent project for which to create a database instance, in the form: `projects/{project-number}/locations/{location-id}`.
DatabaseInstance:
{:name string,
 :state [LIFECYCLE_STATE_UNSPECIFIED ACTIVE DISABLED DELETED],
 :type
 [DATABASE_INSTANCE_TYPE_UNSPECIFIED DEFAULT_DATABASE USER_DATABASE],
 :databaseUrl string,
 :project string}

optional:
validateOnly <boolean> When set to true, the request will be validated but not submitted.
databaseId <string> The globally unique identifier of the database instance."
  ([parent DatabaseInstance]
    (projects-locations-instances-create parent DatabaseInstance nil))
  ([parent DatabaseInstance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://firebasedatabase.googleapis.com/v1beta/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/firebase"],
       :body DatabaseInstance})))

(defn projects-locations-instances-delete
  "Marks a DatabaseInstance to be deleted. The DatabaseInstance will be set to the DELETED state for 20 days, and will be purged within 30 days. The default database cannot be deleted. IDs for deleted database instances may never be recovered or re-used. The Database may only be deleted if it is already in a DISABLED state.
https://firebase.google.com/docs/reference/rest/database/database-management/rest/v1beta/projects.locations.instances/delete

name <string> Required. The fully qualified resource name of the database instance, in the form: `projects/{project-number}/locations/{location-id}/instances/{database-id}`"
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://firebasedatabase.googleapis.com/v1beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/firebase"]}))

(defn projects-locations-instances-list
  "Lists each DatabaseInstance associated with the specified parent project. The list items are returned in no particular order, but will be a consistent view of the database instances when additional requests are made with a `pageToken`. The resulting list contains instances in any STATE. The list results may be stale by a few seconds. Use GetDatabaseInstance for consistent reads.
https://firebase.google.com/docs/reference/rest/database/database-management/rest/v1beta/projects.locations.instances/list

parent <string> Required. The parent project for which to list database instances, in the form: `projects/{project-number}/locations/{location-id}` To list across all locations, use a parent in the form: `projects/{project-number}/locations/-`

optional:
showDeleted <boolean> Indicate that DatabaseInstances in the `DELETED` state should also be returned.
pageSize <integer> The maximum number of database instances to return in the response. The server may return fewer than this at its discretion. If no value is specified (or too large a value is specified), then the server will impose its own limit."
  ([parent] (projects-locations-instances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://firebasedatabase.googleapis.com/v1beta/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/firebase"
        "https://www.googleapis.com/auth/firebase.readonly"]})))

(ns happygapi2.datamigration
  "Database Migration API
Manage Cloud Database Migration Service resources on Google Cloud Platform.
See: https://cloud.google.com/database-migration/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-fetchStaticIps
  "Fetches a set of static IP addresses that need to be allowlisted by the customer when using the static-IP connectivity method.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations/fetchStaticIps

name <string> Required. The resource name for the location for which static IPs should be returned. Must be in the format `projects/*/locations/*`.

optional:
pageSize <integer> Maximum number of IPs to return."
  ([name] (projects-locations-fetchStaticIps name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+name}:fetchStaticIps",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-migrationJobs-demoteDestination
  "Demotes the destination database to become a read replica of the source. This is applicable for the following migrations: 1. MySQL to Cloud SQL for MySQL 2. PostgreSQL to Cloud SQL for PostgreSQL 3. PostgreSQL to AlloyDB for PostgreSQL.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/demoteDestination

name <string> Name of the migration job resource to demote its destination.
DemoteDestinationRequest:
object"
  [name DemoteDestinationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:demoteDestination",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DemoteDestinationRequest}))

(defn projects-locations-migrationJobs-get
  "Gets details of a single migration job.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/get

name <string> Required. Name of the migration job resource to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-migrationJobs-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/setIamPolicy

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
     "https://datamigration.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-migrationJobs-restart
  "Restart a stopped or failed migration job, resetting the destination instance to its original state and starting the migration process from scratch.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/restart

name <string> Name of the migration job resource to restart.
RestartMigrationJobRequest:
{:skipValidation boolean}"
  [name RestartMigrationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:restart",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RestartMigrationJobRequest}))

(defn projects-locations-migrationJobs-patch
  "Updates the parameters of a single migration job.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/patch

name <string> The name (URI) of this migration job resource, in the form of: projects/{project}/locations/{location}/migrationJobs/{migrationJob}.
MigrationJob:
{:labels object,
 :dumpType [DUMP_TYPE_UNSPECIFIED LOGICAL PHYSICAL],
 :reverseSshConnectivity
 {:vmIp string, :vmPort integer, :vm string, :vpc string},
 :destinationDatabase
 {:provider
  [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
  :engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE]},
 :dumpPath string,
 :displayName string,
 :name string,
 :endTime string,
 :createTime string,
 :phase
 [PHASE_UNSPECIFIED
  FULL_DUMP
  CDC
  PROMOTE_IN_PROGRESS
  WAITING_FOR_SOURCE_WRITES_TO_STOP
  PREPARING_THE_DUMP
  READY_FOR_PROMOTE
  DIFF_BACKUP],
 :type [TYPE_UNSPECIFIED ONE_TIME CONTINUOUS],
 :staticIpConnectivity object,
 :duration string,
 :state
 [STATE_UNSPECIFIED
  MAINTENANCE
  DRAFT
  CREATING
  NOT_STARTED
  RUNNING
  FAILED
  COMPLETED
  DELETING
  STOPPING
  STOPPED
  DELETED
  UPDATING
  STARTING
  RESTARTING
  RESUMING],
 :source string,
 :performanceConfig
 {:dumpParallelLevel
  [DUMP_PARALLEL_LEVEL_UNSPECIFIED MIN OPTIMAL MAX]},
 :dumpFlags {:dumpFlags [{:name string, :value string}]},
 :updateTime string,
 :filter string,
 :sqlserverHomogeneousMigrationJobConfig
 {:backupFilePattern string,
  :databaseBackups
  [{:database string,
    :encryptionOptions
    {:certPath string, :pvkPath string, :pvkPassword string}}],
  :useDiffBackup boolean},
 :error {:code integer, :message string, :details [object]},
 :sourceDatabase
 {:provider
  [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
  :engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE]},
 :cmekKeyName string,
 :vpcPeeringConnectivity {:vpc string},
 :destination string,
 :conversionWorkspace {:name string, :commitId string}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten by the update in the conversion workspace resource.
requestId <string> A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([name MigrationJob]
    (projects-locations-migrationJobs-patch name MigrationJob nil))
  ([name MigrationJob optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body MigrationJob})))

(defn projects-locations-migrationJobs-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-migrationJobs-generateSshScript
  "Generate a SSH configuration script to configure the reverse SSH connectivity.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/generateSshScript

migrationJob <string> Name of the migration job resource to generate the SSH script.
GenerateSshScriptRequest:
{:vm string,
 :vmCreationConfig
 {:vmMachineType string, :vmZone string, :subnet string},
 :vmSelectionConfig {:vmZone string},
 :vmPort integer}"
  [migrationJob GenerateSshScriptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+migrationJob}:generateSshScript",
     :uri-template-args {:migrationJob migrationJob},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateSshScriptRequest}))

(defn projects-locations-migrationJobs-create
  "Creates a new migration job in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/create

parent <string> Required. The parent which owns this collection of migration jobs.
MigrationJob:
{:labels object,
 :dumpType [DUMP_TYPE_UNSPECIFIED LOGICAL PHYSICAL],
 :reverseSshConnectivity
 {:vmIp string, :vmPort integer, :vm string, :vpc string},
 :destinationDatabase
 {:provider
  [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
  :engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE]},
 :dumpPath string,
 :displayName string,
 :name string,
 :endTime string,
 :createTime string,
 :phase
 [PHASE_UNSPECIFIED
  FULL_DUMP
  CDC
  PROMOTE_IN_PROGRESS
  WAITING_FOR_SOURCE_WRITES_TO_STOP
  PREPARING_THE_DUMP
  READY_FOR_PROMOTE
  DIFF_BACKUP],
 :type [TYPE_UNSPECIFIED ONE_TIME CONTINUOUS],
 :staticIpConnectivity object,
 :duration string,
 :state
 [STATE_UNSPECIFIED
  MAINTENANCE
  DRAFT
  CREATING
  NOT_STARTED
  RUNNING
  FAILED
  COMPLETED
  DELETING
  STOPPING
  STOPPED
  DELETED
  UPDATING
  STARTING
  RESTARTING
  RESUMING],
 :source string,
 :performanceConfig
 {:dumpParallelLevel
  [DUMP_PARALLEL_LEVEL_UNSPECIFIED MIN OPTIMAL MAX]},
 :dumpFlags {:dumpFlags [{:name string, :value string}]},
 :updateTime string,
 :filter string,
 :sqlserverHomogeneousMigrationJobConfig
 {:backupFilePattern string,
  :databaseBackups
  [{:database string,
    :encryptionOptions
    {:certPath string, :pvkPath string, :pvkPassword string}}],
  :useDiffBackup boolean},
 :error {:code integer, :message string, :details [object]},
 :sourceDatabase
 {:provider
  [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
  :engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE]},
 :cmekKeyName string,
 :vpcPeeringConnectivity {:vpc string},
 :destination string,
 :conversionWorkspace {:name string, :commitId string}}

optional:
migrationJobId <string> Required. The ID of the instance to create.
requestId <string> Optional. A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([parent MigrationJob]
    (projects-locations-migrationJobs-create parent MigrationJob nil))
  ([parent MigrationJob optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/migrationJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body MigrationJob})))

(defn projects-locations-migrationJobs-start
  "Start an already created migration job.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/start

name <string> Name of the migration job resource to start.
StartMigrationJobRequest:
{:skipValidation boolean}"
  [name StartMigrationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:start",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StartMigrationJobRequest}))

(defn projects-locations-migrationJobs-delete
  "Deletes a single migration job.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/delete

name <string> Required. Name of the migration job resource to delete.

optional:
requestId <string> A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
force <boolean> The destination CloudSQL connection profile is always deleted with the migration job. In case of force delete, the destination CloudSQL replica database is also deleted."
  ([name] (projects-locations-migrationJobs-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-migrationJobs-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-migrationJobs-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-migrationJobs-stop
  "Stops a running migration job.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/stop

name <string> Name of the migration job resource to stop.
StopMigrationJobRequest:
object"
  [name StopMigrationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:stop",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body StopMigrationJobRequest}))

(defn projects-locations-migrationJobs-list
  "Lists migration jobs in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/list

parent <string> Required. The parent which owns this collection of migrationJobs.

optional:
pageSize <integer> The maximum number of migration jobs to return. The service may return fewer than this value. If unspecified, at most 50 migration jobs will be returned. The maximum value is 1000; values above 1000 are coerced to 1000.
filter <string> A filter expression that filters migration jobs listed in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be either =, !=, >, or <. For example, list migration jobs created this year by specifying **createTime %gt; 2020-01-01T00:00:00.000000000Z.** You can also filter nested fields. For example, you could specify **reverseSshConnectivity.vmIp = \"1.2.3.4\"** to select all migration jobs connecting through the specific SSH tunnel bastion.
orderBy <string> Sort the results based on the migration job name. Valid values are: \"name\", \"name asc\", and \"name desc\"."
  ([parent] (projects-locations-migrationJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/migrationJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-migrationJobs-verify
  "Verify a migration job, making sure the destination can reach the source and that all configuration and prerequisites are met.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/verify

name <string> Name of the migration job resource to verify.
VerifyMigrationJobRequest:
{:updateMask string,
 :migrationJob
 {:labels object,
  :dumpType [DUMP_TYPE_UNSPECIFIED LOGICAL PHYSICAL],
  :reverseSshConnectivity
  {:vmIp string, :vmPort integer, :vm string, :vpc string},
  :destinationDatabase
  {:provider
   [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
   :engine
   [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE]},
  :dumpPath string,
  :displayName string,
  :name string,
  :endTime string,
  :createTime string,
  :phase
  [PHASE_UNSPECIFIED
   FULL_DUMP
   CDC
   PROMOTE_IN_PROGRESS
   WAITING_FOR_SOURCE_WRITES_TO_STOP
   PREPARING_THE_DUMP
   READY_FOR_PROMOTE
   DIFF_BACKUP],
  :type [TYPE_UNSPECIFIED ONE_TIME CONTINUOUS],
  :staticIpConnectivity object,
  :duration string,
  :state
  [STATE_UNSPECIFIED
   MAINTENANCE
   DRAFT
   CREATING
   NOT_STARTED
   RUNNING
   FAILED
   COMPLETED
   DELETING
   STOPPING
   STOPPED
   DELETED
   UPDATING
   STARTING
   RESTARTING
   RESUMING],
  :source string,
  :performanceConfig
  {:dumpParallelLevel
   [DUMP_PARALLEL_LEVEL_UNSPECIFIED MIN OPTIMAL MAX]},
  :dumpFlags {:dumpFlags [{:name string, :value string}]},
  :updateTime string,
  :filter string,
  :sqlserverHomogeneousMigrationJobConfig
  {:backupFilePattern string,
   :databaseBackups
   [{:database string,
     :encryptionOptions
     {:certPath string, :pvkPath string, :pvkPassword string}}],
   :useDiffBackup boolean},
  :error {:code integer, :message string, :details [object]},
  :sourceDatabase
  {:provider
   [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
   :engine
   [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE]},
  :cmekKeyName string,
  :vpcPeeringConnectivity {:vpc string},
  :destination string,
  :conversionWorkspace {:name string, :commitId string}}}"
  [name VerifyMigrationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:verify",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body VerifyMigrationJobRequest}))

(defn projects-locations-migrationJobs-resume
  "Resume a migration job that is currently stopped and is resumable (was stopped during CDC phase).
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/resume

name <string> Name of the migration job resource to resume.
ResumeMigrationJobRequest:
{:skipValidation boolean}"
  [name ResumeMigrationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:resume",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ResumeMigrationJobRequest}))

(defn projects-locations-migrationJobs-generateTcpProxyScript
  "Generate a TCP Proxy configuration script to configure a cloud-hosted VM running a TCP Proxy.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/generateTcpProxyScript

migrationJob <string> Name of the migration job resource to generate the TCP Proxy script.
GenerateTcpProxyScriptRequest:
{:vmName string,
 :vmMachineType string,
 :vmZone string,
 :vmSubnet string}"
  [migrationJob GenerateTcpProxyScriptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+migrationJob}:generateTcpProxyScript",
     :uri-template-args {:migrationJob migrationJob},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateTcpProxyScriptRequest}))

(defn projects-locations-migrationJobs-promote
  "Promote a migration job, stopping replication to the destination and promoting the destination to be a standalone database.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.migrationJobs/promote

name <string> Name of the migration job resource to promote.
PromoteMigrationJobRequest:
object"
  [name PromoteMigrationJobRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:promote",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PromoteMigrationJobRequest}))

(defn projects-locations-connectionProfiles-list
  "Retrieves a list of all connection profiles in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/list

parent <string> Required. The parent which owns this collection of connection profiles.

optional:
pageSize <integer> The maximum number of connection profiles to return. The service may return fewer than this value. If unspecified, at most 50 connection profiles will be returned. The maximum value is 1000; values above 1000 are coerced to 1000.
filter <string> A filter expression that filters connection profiles listed in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be either =, !=, >, or <. For example, list connection profiles created this year by specifying **createTime %gt; 2020-01-01T00:00:00.000000000Z**. You can also filter nested fields. For example, you could specify **mySql.username = %lt;my_username%gt;** to list all connection profiles configured to connect with a specific username.
orderBy <string> A comma-separated list of fields to order results according to."
  ([parent] (projects-locations-connectionProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/connectionProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connectionProfiles-get
  "Gets details of a single connection profile.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/get

name <string> Required. Name of the connection profile resource to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-connectionProfiles-create
  "Creates a new connection profile in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/create

parent <string> Required. The parent which owns this collection of connection profiles.
ConnectionProfile:
{:labels object,
 :alloydb
 {:clusterId string,
  :settings
  {:initialUser {:user string, :password string, :passwordSet boolean},
   :vpcNetwork string,
   :labels object,
   :primaryInstanceSettings
   {:id string,
    :machineConfig {:cpuCount integer},
    :databaseFlags object,
    :labels object,
    :privateIp string},
   :encryptionConfig {:kmsKeyName string},
   :databaseVersion
   [DATABASE_VERSION_UNSPECIFIED POSTGRES_14 POSTGRES_15]}},
 :postgresql
 {:ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :password string,
  :networkArchitecture
  [NETWORK_ARCHITECTURE_UNSPECIFIED
   NETWORK_ARCHITECTURE_OLD_CSQL_PRODUCER
   NETWORK_ARCHITECTURE_NEW_CSQL_PRODUCER],
  :privateServiceConnectConnectivity {:serviceAttachment string},
  :username string,
  :staticIpConnectivity object,
  :cloudSqlId string,
  :port integer,
  :host string,
  :alloydbClusterId string,
  :passwordSet boolean},
 :displayName string,
 :name string,
 :createTime string,
 :cloudsql
 {:cloudSqlId string,
  :settings
  {:dataCacheConfig {:dataCacheEnabled boolean},
   :availabilityType
   [SQL_AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
   :tier string,
   :databaseVersion
   [SQL_DATABASE_VERSION_UNSPECIFIED
    MYSQL_5_6
    MYSQL_5_7
    MYSQL_8_0
    MYSQL_8_0_18
    MYSQL_8_0_26
    MYSQL_8_0_27
    MYSQL_8_0_28
    MYSQL_8_0_30
    MYSQL_8_0_31
    MYSQL_8_0_32
    MYSQL_8_0_33
    MYSQL_8_0_34
    MYSQL_8_0_35
    MYSQL_8_0_36
    POSTGRES_9_6
    POSTGRES_11
    POSTGRES_10
    POSTGRES_12
    POSTGRES_13
    POSTGRES_14
    POSTGRES_15
    POSTGRES_16],
   :databaseFlags object,
   :autoStorageIncrease boolean,
   :rootPassword string,
   :zone string,
   :secondaryZone string,
   :storageAutoResizeLimit string,
   :activationPolicy [SQL_ACTIVATION_POLICY_UNSPECIFIED ALWAYS NEVER],
   :ipConfig
   {:enableIpv4 boolean,
    :privateNetwork string,
    :allocatedIpRange string,
    :requireSsl boolean,
    :authorizedNetworks
    [{:value string, :expireTime string, :ttl string, :label string}]},
   :collation string,
   :rootPasswordSet boolean,
   :edition [EDITION_UNSPECIFIED ENTERPRISE ENTERPRISE_PLUS],
   :cmekKeyName string,
   :sourceId string,
   :dataDiskSizeGb string,
   :userLabels object,
   :dataDiskType [SQL_DATA_DISK_TYPE_UNSPECIFIED PD_SSD PD_HDD]},
  :privateIp string,
  :publicIp string,
  :additionalPublicIp string},
 :oracle
 {:ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :privateConnectivity {:privateConnection string},
  :password string,
  :username string,
  :forwardSshConnectivity
  {:hostname string,
   :username string,
   :port integer,
   :password string,
   :privateKey string},
  :port integer,
  :host string,
  :databaseService string,
  :staticServiceIpConnectivity object,
  :passwordSet boolean},
 :state
 [STATE_UNSPECIFIED
  DRAFT
  CREATING
  READY
  UPDATING
  DELETING
  DELETED
  FAILED],
 :updateTime string,
 :error {:code integer, :message string, :details [object]},
 :provider [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
 :mysql
 {:host string,
  :port integer,
  :username string,
  :password string,
  :passwordSet boolean,
  :ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :cloudSqlId string},
 :sqlserver
 {:ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :privateConnectivity {:privateConnection string},
  :password string,
  :privateServiceConnectConnectivity {:serviceAttachment string},
  :username string,
  :staticIpConnectivity object,
  :forwardSshConnectivity
  {:hostname string,
   :username string,
   :port integer,
   :password string,
   :privateKey string},
  :cloudSqlId string,
  :port integer,
  :backups {:gcsBucket string, :gcsPrefix string},
  :host string,
  :passwordSet boolean}}

optional:
connectionProfileId <string> Required. The connection profile identifier.
requestId <string> Optional. A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
validateOnly <boolean> Optional. Only validate the connection profile, but don't create any resources. The default is false. Only supported for Oracle connection profiles.
skipValidation <boolean> Optional. Create the connection profile without validating it. The default is false. Only supported for Oracle connection profiles."
  ([parent ConnectionProfile]
    (projects-locations-connectionProfiles-create
      parent
      ConnectionProfile
      nil))
  ([parent ConnectionProfile optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/connectionProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ConnectionProfile})))

(defn projects-locations-connectionProfiles-patch
  "Update the configuration of a single connection profile.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/patch

name <string> The name of this connection profile resource in the form of projects/{project}/locations/{location}/connectionProfiles/{connectionProfile}.
ConnectionProfile:
{:labels object,
 :alloydb
 {:clusterId string,
  :settings
  {:initialUser {:user string, :password string, :passwordSet boolean},
   :vpcNetwork string,
   :labels object,
   :primaryInstanceSettings
   {:id string,
    :machineConfig {:cpuCount integer},
    :databaseFlags object,
    :labels object,
    :privateIp string},
   :encryptionConfig {:kmsKeyName string},
   :databaseVersion
   [DATABASE_VERSION_UNSPECIFIED POSTGRES_14 POSTGRES_15]}},
 :postgresql
 {:ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :password string,
  :networkArchitecture
  [NETWORK_ARCHITECTURE_UNSPECIFIED
   NETWORK_ARCHITECTURE_OLD_CSQL_PRODUCER
   NETWORK_ARCHITECTURE_NEW_CSQL_PRODUCER],
  :privateServiceConnectConnectivity {:serviceAttachment string},
  :username string,
  :staticIpConnectivity object,
  :cloudSqlId string,
  :port integer,
  :host string,
  :alloydbClusterId string,
  :passwordSet boolean},
 :displayName string,
 :name string,
 :createTime string,
 :cloudsql
 {:cloudSqlId string,
  :settings
  {:dataCacheConfig {:dataCacheEnabled boolean},
   :availabilityType
   [SQL_AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
   :tier string,
   :databaseVersion
   [SQL_DATABASE_VERSION_UNSPECIFIED
    MYSQL_5_6
    MYSQL_5_7
    MYSQL_8_0
    MYSQL_8_0_18
    MYSQL_8_0_26
    MYSQL_8_0_27
    MYSQL_8_0_28
    MYSQL_8_0_30
    MYSQL_8_0_31
    MYSQL_8_0_32
    MYSQL_8_0_33
    MYSQL_8_0_34
    MYSQL_8_0_35
    MYSQL_8_0_36
    POSTGRES_9_6
    POSTGRES_11
    POSTGRES_10
    POSTGRES_12
    POSTGRES_13
    POSTGRES_14
    POSTGRES_15
    POSTGRES_16],
   :databaseFlags object,
   :autoStorageIncrease boolean,
   :rootPassword string,
   :zone string,
   :secondaryZone string,
   :storageAutoResizeLimit string,
   :activationPolicy [SQL_ACTIVATION_POLICY_UNSPECIFIED ALWAYS NEVER],
   :ipConfig
   {:enableIpv4 boolean,
    :privateNetwork string,
    :allocatedIpRange string,
    :requireSsl boolean,
    :authorizedNetworks
    [{:value string, :expireTime string, :ttl string, :label string}]},
   :collation string,
   :rootPasswordSet boolean,
   :edition [EDITION_UNSPECIFIED ENTERPRISE ENTERPRISE_PLUS],
   :cmekKeyName string,
   :sourceId string,
   :dataDiskSizeGb string,
   :userLabels object,
   :dataDiskType [SQL_DATA_DISK_TYPE_UNSPECIFIED PD_SSD PD_HDD]},
  :privateIp string,
  :publicIp string,
  :additionalPublicIp string},
 :oracle
 {:ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :privateConnectivity {:privateConnection string},
  :password string,
  :username string,
  :forwardSshConnectivity
  {:hostname string,
   :username string,
   :port integer,
   :password string,
   :privateKey string},
  :port integer,
  :host string,
  :databaseService string,
  :staticServiceIpConnectivity object,
  :passwordSet boolean},
 :state
 [STATE_UNSPECIFIED
  DRAFT
  CREATING
  READY
  UPDATING
  DELETING
  DELETED
  FAILED],
 :updateTime string,
 :error {:code integer, :message string, :details [object]},
 :provider [DATABASE_PROVIDER_UNSPECIFIED CLOUDSQL RDS AURORA ALLOYDB],
 :mysql
 {:host string,
  :port integer,
  :username string,
  :password string,
  :passwordSet boolean,
  :ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :cloudSqlId string},
 :sqlserver
 {:ssl
  {:type [SSL_TYPE_UNSPECIFIED SERVER_ONLY SERVER_CLIENT],
   :clientKey string,
   :clientCertificate string,
   :caCertificate string},
  :privateConnectivity {:privateConnection string},
  :password string,
  :privateServiceConnectConnectivity {:serviceAttachment string},
  :username string,
  :staticIpConnectivity object,
  :forwardSshConnectivity
  {:hostname string,
   :username string,
   :port integer,
   :password string,
   :privateKey string},
  :cloudSqlId string,
  :port integer,
  :backups {:gcsBucket string, :gcsPrefix string},
  :host string,
  :passwordSet boolean}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten by the update in the conversion workspace resource.
requestId <string> Optional. A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
validateOnly <boolean> Optional. Only validate the connection profile, but don't update any resources. The default is false. Only supported for Oracle connection profiles.
skipValidation <boolean> Optional. Update the connection profile without validating it. The default is false. Only supported for Oracle connection profiles."
  ([name ConnectionProfile]
    (projects-locations-connectionProfiles-patch
      name
      ConnectionProfile
      nil))
  ([name ConnectionProfile optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ConnectionProfile})))

(defn projects-locations-connectionProfiles-delete
  "Deletes a single Database Migration Service connection profile. A connection profile can only be deleted if it is not in use by any active migration jobs.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/delete

name <string> Required. Name of the connection profile resource to delete.

optional:
requestId <string> A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
force <boolean> In case of force delete, the CloudSQL replica database is also deleted (only for CloudSQL connection profile)."
  ([name] (projects-locations-connectionProfiles-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connectionProfiles-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/setIamPolicy

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
     "https://datamigration.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-connectionProfiles-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-connectionProfiles-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-connectionProfiles-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.connectionProfiles/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-privateConnections-create
  "Creates a new private connection in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.privateConnections/create

parent <string> Required. The parent that owns the collection of PrivateConnections.
PrivateConnection:
{:name string,
 :createTime string,
 :updateTime string,
 :labels object,
 :displayName string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  CREATED
  FAILED
  DELETING
  FAILED_TO_DELETE
  DELETED],
 :error {:code integer, :message string, :details [object]},
 :vpcPeeringConfig {:vpcName string, :subnet string}}

optional:
privateConnectionId <string> Required. The private connection identifier.
requestId <string> Optional. A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
skipValidation <boolean> Optional. If set to true, will skip validations."
  ([parent PrivateConnection]
    (projects-locations-privateConnections-create
      parent
      PrivateConnection
      nil))
  ([parent PrivateConnection optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/privateConnections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PrivateConnection})))

(defn projects-locations-privateConnections-get
  "Gets details of a single private connection.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.privateConnections/get

name <string> Required. The name of the private connection to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-privateConnections-list
  "Retrieves a list of private connections in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.privateConnections/list

parent <string> Required. The parent that owns the collection of private connections.

optional:
pageSize <integer> Maximum number of private connections to return. If unspecified, at most 50 private connections that are returned. The maximum value is 1000; values above 1000 are coerced to 1000.
filter <string> A filter expression that filters private connections listed in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be either =, !=, >, or <. For example, list private connections created this year by specifying **createTime %gt; 2021-01-01T00:00:00.000000000Z**.
orderBy <string> Order by fields for the result."
  ([parent] (projects-locations-privateConnections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/privateConnections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateConnections-delete
  "Deletes a single Database Migration Service private connection.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.privateConnections/delete

name <string> Required. The name of the private connection to delete.

optional:
requestId <string> Optional. A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([name] (projects-locations-privateConnections-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateConnections-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.privateConnections/setIamPolicy

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
     "https://datamigration.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-privateConnections-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.privateConnections/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-privateConnections-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-privateConnections-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.privateConnections/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-conversionWorkspaces-rollback
  "Rolls back a conversion workspace to the last committed snapshot.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/rollback

name <string> Required. Name of the conversion workspace resource to roll back to.
RollbackConversionWorkspaceRequest:
object"
  [name RollbackConversionWorkspaceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:rollback",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RollbackConversionWorkspaceRequest}))

(defn projects-locations-conversionWorkspaces-describeConversionWorkspaceRevisions
  "Retrieves a list of committed revisions of a specific conversion workspace.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/describeConversionWorkspaceRevisions

conversionWorkspace <string> Required. Name of the conversion workspace resource whose revisions are listed. Must be in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.

optional:
commitId <string> Optional. Optional filter to request a specific commit ID."
  ([conversionWorkspace]
    (projects-locations-conversionWorkspaces-describeConversionWorkspaceRevisions
      conversionWorkspace
      nil))
  ([conversionWorkspace optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+conversionWorkspace}:describeConversionWorkspaceRevisions",
       :uri-template-args {:conversionWorkspace conversionWorkspace},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-convert
  "Creates a draft tree schema for the destination database.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/convert

name <string> Name of the conversion workspace resource to convert in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.
ConvertConversionWorkspaceRequest:
{:autoCommit boolean, :filter string, :convertFullPath boolean}"
  [name ConvertConversionWorkspaceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:convert",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ConvertConversionWorkspaceRequest}))

(defn projects-locations-conversionWorkspaces-get
  "Gets details of a single conversion workspace.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/get

name <string> Required. Name of the conversion workspace resource to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-conversionWorkspaces-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/setIamPolicy

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
     "https://datamigration.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-conversionWorkspaces-patch
  "Updates the parameters of a single conversion workspace.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/patch

name <string> Full name of the workspace resource, in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.
ConversionWorkspace:
{:latestCommitTime string,
 :latestCommitId string,
 :displayName string,
 :name string,
 :createTime string,
 :hasUncommittedChanges boolean,
 :source
 {:engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE],
  :version string},
 :updateTime string,
 :globalSettings object,
 :destination
 {:engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE],
  :version string}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten by the update in the conversion workspace resource.
requestId <string> A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([name ConversionWorkspace]
    (projects-locations-conversionWorkspaces-patch
      name
      ConversionWorkspace
      nil))
  ([name ConversionWorkspace optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ConversionWorkspace})))

(defn projects-locations-conversionWorkspaces-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-conversionWorkspaces-searchBackgroundJobs
  "Searches/lists the background jobs for a specific conversion workspace. The background jobs are not resources like conversion workspaces or mapping rules, and they can't be created, updated or deleted. Instead, they are a way to expose the data plane jobs log.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/searchBackgroundJobs

conversionWorkspace <string> Required. Name of the conversion workspace resource whose jobs are listed, in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.

optional:
returnMostRecentPerJobType <boolean> Optional. Whether or not to return just the most recent job per job type,
maxSize <integer> Optional. The maximum number of jobs to return. The service may return fewer than this value. If unspecified, at most 100 jobs are returned. The maximum value is 100; values above 100 are coerced to 100.
completedUntilTime <string> Optional. If provided, only returns jobs that completed until (not including) the given timestamp."
  ([conversionWorkspace]
    (projects-locations-conversionWorkspaces-searchBackgroundJobs
      conversionWorkspace
      nil))
  ([conversionWorkspace optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+conversionWorkspace}:searchBackgroundJobs",
       :uri-template-args {:conversionWorkspace conversionWorkspace},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-create
  "Creates a new conversion workspace in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/create

parent <string> Required. The parent which owns this collection of conversion workspaces.
ConversionWorkspace:
{:latestCommitTime string,
 :latestCommitId string,
 :displayName string,
 :name string,
 :createTime string,
 :hasUncommittedChanges boolean,
 :source
 {:engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE],
  :version string},
 :updateTime string,
 :globalSettings object,
 :destination
 {:engine
  [DATABASE_ENGINE_UNSPECIFIED MYSQL POSTGRESQL SQLSERVER ORACLE],
  :version string}}

optional:
conversionWorkspaceId <string> Required. The ID of the conversion workspace to create.
requestId <string> A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([parent ConversionWorkspace]
    (projects-locations-conversionWorkspaces-create
      parent
      ConversionWorkspace
      nil))
  ([parent ConversionWorkspace optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/conversionWorkspaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ConversionWorkspace})))

(defn projects-locations-conversionWorkspaces-delete
  "Deletes a single conversion workspace.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/delete

name <string> Required. Name of the conversion workspace resource to delete.

optional:
requestId <string> A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters.
force <boolean> Force delete the conversion workspace, even if there's a running migration that is using the workspace."
  ([name] (projects-locations-conversionWorkspaces-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-conversionWorkspaces-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-seed
  "Imports a snapshot of the source database into the conversion workspace.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/seed

name <string> Name of the conversion workspace resource to seed with new database structure, in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.
SeedConversionWorkspaceRequest:
{:autoCommit boolean,
 :sourceConnectionProfile string,
 :destinationConnectionProfile string}"
  [name SeedConversionWorkspaceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:seed",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SeedConversionWorkspaceRequest}))

(defn projects-locations-conversionWorkspaces-list
  "Lists conversion workspaces in a given project and location.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/list

parent <string> Required. The parent which owns this collection of conversion workspaces.

optional:
pageSize <integer> The maximum number of conversion workspaces to return. The service may return fewer than this value. If unspecified, at most 50 sets are returned.
filter <string> A filter expression that filters conversion workspaces listed in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be either =, !=, >, or <. For example, list conversion workspaces created this year by specifying **createTime %gt; 2020-01-01T00:00:00.000000000Z.** You can also filter nested fields. For example, you could specify **source.version = \"12.c.1\"** to select all conversion workspaces with source database version equal to 12.c.1."
  ([parent] (projects-locations-conversionWorkspaces-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/conversionWorkspaces",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-commit
  "Marks all the data in the conversion workspace as committed.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/commit

name <string> Required. Name of the conversion workspace resource to commit.
CommitConversionWorkspaceRequest:
{:commitName string}"
  [name CommitConversionWorkspaceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:commit",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CommitConversionWorkspaceRequest}))

(defn projects-locations-conversionWorkspaces-apply
  "Applies draft tree onto a specific destination database.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/apply

name <string> Required. The name of the conversion workspace resource for which to apply the draft tree. Must be in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.
ApplyConversionWorkspaceRequest:
{:filter string,
 :dryRun boolean,
 :autoCommit boolean,
 :connectionProfile string}"
  [name ApplyConversionWorkspaceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+name}:apply",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ApplyConversionWorkspaceRequest}))

(defn projects-locations-conversionWorkspaces-describeDatabaseEntities
  "Describes the database entities tree for a specific conversion workspace and a specific tree type. Database entities are not resources like conversion workspaces or mapping rules, and they can't be created, updated or deleted. Instead, they are simple data objects describing the structure of the client database.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces/describeDatabaseEntities

conversionWorkspace <string> Required. Name of the conversion workspace resource whose database entities are described. Must be in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.

optional:
pageSize <integer> Optional. The maximum number of entities to return. The service may return fewer entities than the value specifies.
tree <string> Required. The tree to fetch.
uncommitted <boolean> Optional. Whether to retrieve the latest committed version of the entities or the latest version. This field is ignored if a specific commit_id is specified.
commitId <string> Optional. Request a specific commit ID. If not specified, the entities from the latest commit are returned.
filter <string> Optional. Filter the returned entities based on AIP-160 standard.
view <string> Optional. Results view based on AIP-157"
  ([conversionWorkspace]
    (projects-locations-conversionWorkspaces-describeDatabaseEntities
      conversionWorkspace
      nil))
  ([conversionWorkspace optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+conversionWorkspace}:describeDatabaseEntities",
       :uri-template-args {:conversionWorkspace conversionWorkspace},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-mappingRules-create
  "Creates a new mapping rule for a given conversion workspace.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces.mappingRules/create

parent <string> Required. The parent which owns this collection of mapping rules.
MappingRule:
{:setTablePrimaryKey {:primaryKeyColumns [string], :primaryKey string},
 :ruleScope
 [DATABASE_ENTITY_TYPE_UNSPECIFIED
  DATABASE_ENTITY_TYPE_SCHEMA
  DATABASE_ENTITY_TYPE_TABLE
  DATABASE_ENTITY_TYPE_COLUMN
  DATABASE_ENTITY_TYPE_CONSTRAINT
  DATABASE_ENTITY_TYPE_INDEX
  DATABASE_ENTITY_TYPE_TRIGGER
  DATABASE_ENTITY_TYPE_VIEW
  DATABASE_ENTITY_TYPE_SEQUENCE
  DATABASE_ENTITY_TYPE_STORED_PROCEDURE
  DATABASE_ENTITY_TYPE_FUNCTION
  DATABASE_ENTITY_TYPE_SYNONYM
  DATABASE_ENTITY_TYPE_DATABASE_PACKAGE
  DATABASE_ENTITY_TYPE_UDT
  DATABASE_ENTITY_TYPE_MATERIALIZED_VIEW
  DATABASE_ENTITY_TYPE_DATABASE],
 :multiColumnDataTypeChange
 {:sourceTextFilter
  {:sourceMinLengthFilter string, :sourceMaxLengthFilter string},
  :sourceDataTypeFilter string,
  :customFeatures object,
  :overrideLength string,
  :overridePrecision integer,
  :overrideFractionalSecondsPrecision integer,
  :newDataType string,
  :sourceNumericFilter
  {:sourceMinScaleFilter integer,
   :sourceMaxScaleFilter integer,
   :sourceMinPrecisionFilter integer,
   :sourceMaxPrecisionFilter integer,
   :numericFilterOption
   [NUMERIC_FILTER_OPTION_UNSPECIFIED
    NUMERIC_FILTER_OPTION_ALL
    NUMERIC_FILTER_OPTION_LIMIT
    NUMERIC_FILTER_OPTION_LIMITLESS]},
  :overrideScale integer},
 :singleColumnChange
 {:customFeatures object,
  :scale integer,
  :precision integer,
  :arrayLength integer,
  :collation string,
  :array boolean,
  :charset string,
  :autoGenerated boolean,
  :udt boolean,
  :dataType string,
  :comment string,
  :length string,
  :setValues [string],
  :fractionalSecondsPrecision integer,
  :nullable boolean},
 :entityMove {:newSchema string},
 :displayName string,
 :revisionCreateTime string,
 :name string,
 :revisionId string,
 :multiEntityRename
 {:newNamePattern string,
  :sourceNameTransformation
  [ENTITY_NAME_TRANSFORMATION_UNSPECIFIED
   ENTITY_NAME_TRANSFORMATION_NO_TRANSFORMATION
   ENTITY_NAME_TRANSFORMATION_LOWER_CASE
   ENTITY_NAME_TRANSFORMATION_UPPER_CASE
   ENTITY_NAME_TRANSFORMATION_CAPITALIZED_CASE]},
 :state [STATE_UNSPECIFIED ENABLED DISABLED DELETED],
 :filterTableColumns
 {:includeColumns [string], :excludeColumns [string]},
 :convertRowidColumn {:onlyIfNoPrimaryKey boolean},
 :conditionalColumnSetValue
 {:sourceTextFilter
  {:sourceMinLengthFilter string, :sourceMaxLengthFilter string},
  :sourceNumericFilter
  {:sourceMinScaleFilter integer,
   :sourceMaxScaleFilter integer,
   :sourceMinPrecisionFilter integer,
   :sourceMaxPrecisionFilter integer,
   :numericFilterOption
   [NUMERIC_FILTER_OPTION_UNSPECIFIED
    NUMERIC_FILTER_OPTION_ALL
    NUMERIC_FILTER_OPTION_LIMIT
    NUMERIC_FILTER_OPTION_LIMITLESS]},
  :valueTransformation
  {:doubleComparison
   {:valueComparison
    [VALUE_COMPARISON_UNSPECIFIED
     VALUE_COMPARISON_IF_VALUE_SMALLER_THAN
     VALUE_COMPARISON_IF_VALUE_SMALLER_EQUAL_THAN
     VALUE_COMPARISON_IF_VALUE_LARGER_THAN
     VALUE_COMPARISON_IF_VALUE_LARGER_EQUAL_THAN],
    :value number},
   :applyHash {:uuidFromBytes object},
   :assignNull object,
   :valueList
   {:valuePresentList
    [VALUE_PRESENT_IN_LIST_UNSPECIFIED
     VALUE_PRESENT_IN_LIST_IF_VALUE_LIST
     VALUE_PRESENT_IN_LIST_IF_VALUE_NOT_LIST],
    :values [string],
    :ignoreCase boolean},
   :assignSpecificValue {:value string},
   :assignMaxValue object,
   :isNull object,
   :intComparison
   {:valueComparison
    [VALUE_COMPARISON_UNSPECIFIED
     VALUE_COMPARISON_IF_VALUE_SMALLER_THAN
     VALUE_COMPARISON_IF_VALUE_SMALLER_EQUAL_THAN
     VALUE_COMPARISON_IF_VALUE_LARGER_THAN
     VALUE_COMPARISON_IF_VALUE_LARGER_EQUAL_THAN],
    :value string},
   :assignMinValue object,
   :roundScale {:scale integer}},
  :customFeatures object},
 :filter
 {:parentEntity string,
  :entityNamePrefix string,
  :entityNameSuffix string,
  :entityNameContains string,
  :entities [string]},
 :singlePackageChange
 {:packageDescription string, :packageBody string},
 :singleEntityRename {:newName string},
 :ruleOrder string,
 :sourceSqlChange {:sqlCode string}}

optional:
mappingRuleId <string> Required. The ID of the rule to create.
requestId <string> A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([parent MappingRule]
    (projects-locations-conversionWorkspaces-mappingRules-create
      parent
      MappingRule
      nil))
  ([parent MappingRule optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/mappingRules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body MappingRule})))

(defn projects-locations-conversionWorkspaces-mappingRules-delete
  "Deletes a single mapping rule.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces.mappingRules/delete

name <string> Required. Name of the mapping rule resource to delete.

optional:
requestId <string> Optional. A unique ID used to identify the request. If the server receives two requests with the same ID, then the second request is ignored. It is recommended to always set this value to a UUID. The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-). The maximum length is 40 characters."
  ([name]
    (projects-locations-conversionWorkspaces-mappingRules-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://datamigration.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-mappingRules-list
  "Lists the mapping rules for a specific conversion workspace.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces.mappingRules/list

parent <string> Required. Name of the conversion workspace resource whose mapping rules are listed in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.

optional:
pageSize <integer> The maximum number of rules to return. The service may return fewer than this value."
  ([parent]
    (projects-locations-conversionWorkspaces-mappingRules-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://datamigration.googleapis.com/v1/{+parent}/mappingRules",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-conversionWorkspaces-mappingRules-get
  "Gets the details of a mapping rule.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces.mappingRules/get

name <string> Required. Name of the mapping rule resource to get. Example: conversionWorkspaces/123/mappingRules/rule123 In order to retrieve a previous revision of the mapping rule, also provide the revision ID. Example: conversionWorkspace/123/mappingRules/rule123@c7cfa2a8c7cfa2a8c7cfa2a8c7cfa2a8"
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://datamigration.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-conversionWorkspaces-mappingRules-import
  "Imports the mapping rules for a given conversion workspace. Supports various formats of external rules files.
https://cloud.google.com/database-migration/docs/reference/rest/v1/projects.locations.conversionWorkspaces.mappingRules/import

parent <string> Required. Name of the conversion workspace resource to import the rules to in the form of: projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.
ImportMappingRulesRequest:
{:rulesFormat
 [IMPORT_RULES_FILE_FORMAT_UNSPECIFIED
  IMPORT_RULES_FILE_FORMAT_HARBOUR_BRIDGE_SESSION_FILE
  IMPORT_RULES_FILE_FORMAT_ORATOPG_CONFIG_FILE],
 :rulesFiles [{:rulesSourceFilename string, :rulesContent string}],
 :autoCommit boolean}"
  [parent ImportMappingRulesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://datamigration.googleapis.com/v1/{+parent}/mappingRules:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ImportMappingRulesRequest}))

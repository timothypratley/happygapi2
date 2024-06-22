(ns happygapi2.sqladmin
  "Cloud SQL Admin API
API for Cloud SQL database instance management
See: https://cloud.google.com/sql/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-instances-rescheduleMaintenance
  "Reschedules the maintenance on the given instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/projects.instances/rescheduleMaintenance

project <string> ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
SqlInstancesRescheduleMaintenanceRequestBody:
{:reschedule
 {:rescheduleType
  [RESCHEDULE_TYPE_UNSPECIFIED
   IMMEDIATE
   NEXT_AVAILABLE_WINDOW
   SPECIFIC_TIME],
  :scheduleTime string}}"
  [project instance SqlInstancesRescheduleMaintenanceRequestBody]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/rescheduleMaintenance",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body SqlInstancesRescheduleMaintenanceRequestBody}))

(defn projects-instances-verifyExternalSyncSettings
  "Verify External primary instance external sync settings.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/projects.instances/verifyExternalSyncSettings

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
SqlInstancesVerifyExternalSyncSettingsRequest:
{:verifyConnectionOnly boolean,
 :syncMode [EXTERNAL_SYNC_MODE_UNSPECIFIED ONLINE OFFLINE],
 :verifyReplicationOnly boolean,
 :mysqlSyncConfig {:initialSyncFlags [{:name string, :value string}]},
 :migrationType [MIGRATION_TYPE_UNSPECIFIED LOGICAL PHYSICAL],
 :syncParallelLevel
 [EXTERNAL_SYNC_PARALLEL_LEVEL_UNSPECIFIED MIN OPTIMAL MAX]}"
  [project instance SqlInstancesVerifyExternalSyncSettingsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/verifyExternalSyncSettings",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body SqlInstancesVerifyExternalSyncSettingsRequest}))

(defn projects-instances-startExternalSync
  "Start External primary instance migration.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/projects.instances/startExternalSync

project <string> ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
SqlInstancesStartExternalSyncRequest:
{:syncMode [EXTERNAL_SYNC_MODE_UNSPECIFIED ONLINE OFFLINE],
 :skipVerification boolean,
 :mysqlSyncConfig {:initialSyncFlags [{:name string, :value string}]},
 :syncParallelLevel
 [EXTERNAL_SYNC_PARALLEL_LEVEL_UNSPECIFIED MIN OPTIMAL MAX],
 :migrationType [MIGRATION_TYPE_UNSPECIFIED LOGICAL PHYSICAL]}"
  [project instance SqlInstancesStartExternalSyncRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/startExternalSync",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body SqlInstancesStartExternalSyncRequest}))

(defn projects-instances-performDiskShrink
  "Perform Disk Shrink on primary instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/projects.instances/performDiskShrink

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
PerformDiskShrinkContext:
{:targetSizeGb string}"
  [project instance PerformDiskShrinkContext]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/performDiskShrink",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body PerformDiskShrinkContext}))

(defn projects-instances-getDiskShrinkConfig
  "Get Disk Shrink Config for a given instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/projects.instances/getDiskShrinkConfig

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/getDiskShrinkConfig",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn projects-instances-resetReplicaSize
  "Reset Replica Size to primary instance disk size.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/projects.instances/resetReplicaSize

project <string> ID of the project that contains the read replica.
instance <string> Cloud SQL read replica instance name.
SqlInstancesResetReplicaSizeRequest:
object"
  [project instance SqlInstancesResetReplicaSizeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/resetReplicaSize",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body SqlInstancesResetReplicaSizeRequest}))

(defn projects-instances-getLatestRecoveryTime
  "Get Latest Recovery Time for a given instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/projects.instances/getLatestRecoveryTime

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/getLatestRecoveryTime",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn sslCerts-createEphemeral
  "Generates a short-lived X509 certificate containing the provided public key and signed by a private key specific to the target instance. Users may use the certificate to authenticate as themselves when connecting to the database.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/sslCerts/createEphemeral

project <string> Project ID of the Cloud SQL project.
instance <string> Cloud SQL instance ID. This does not include the project ID.
SslCertsCreateEphemeralRequest:
{:public_key string, :access_token string}"
  [project instance SslCertsCreateEphemeralRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/createEphemeral",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body SslCertsCreateEphemeralRequest}))

(defn sslCerts-delete
  "Deletes the SSL certificate. For First Generation instances, the certificate remains valid until the instance is restarted.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/sslCerts/delete

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
sha1Fingerprint <string> Sha1 FingerPrint."
  [project instance sha1Fingerprint]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}",
     :uri-template-args
     {:project project,
      :instance instance,
      :sha1Fingerprint sha1Fingerprint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn sslCerts-get
  "Retrieves a particular SSL certificate. Does not include the private key (required for usage). The private key must be saved from the response to initial creation.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/sslCerts/get

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
sha1Fingerprint <string> Sha1 FingerPrint."
  [project instance sha1Fingerprint]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/sslCerts/{sha1Fingerprint}",
     :uri-template-args
     {:project project,
      :instance instance,
      :sha1Fingerprint sha1Fingerprint},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn sslCerts-insert
  "Creates an SSL certificate and returns it along with the private key and server certificate authority. The new certificate will not be usable until the instance is restarted.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/sslCerts/insert

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
SslCertsInsertRequest:
{:commonName string}"
  [project instance SslCertsInsertRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/sslCerts",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body SslCertsInsertRequest}))

(defn sslCerts-list
  "Lists all of the current SSL certificates for the instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/sslCerts/list

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/sslCerts",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn connect-get
  "Retrieves connect settings about a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/connect/get

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.

optional:
readTime <string> Optional. Optional snapshot read timestamp to trade freshness for performance."
  ([project instance] (connect-get project instance nil))
  ([project instance optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/connectSettings",
       :uri-template-args {:project project, :instance instance},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn connect-generateEphemeral
  "Generates a short-lived X509 certificate containing the provided public key and signed by a private key specific to the target instance. Users may use the certificate to authenticate as themselves when connecting to the database.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/connect/generateEphemeral

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
GenerateEphemeralCertRequest:
{:public_key string,
 :access_token string,
 :readTime string,
 :validDuration string}"
  [project instance GenerateEphemeralCertRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}:generateEphemeralCert",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body GenerateEphemeralCertRequest}))

(defn databases-delete
  "Deletes a database from a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/databases/delete

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
database <string> Name of the database to be deleted in the instance."
  [project instance database]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/databases/{database}",
     :uri-template-args
     {:project project, :instance instance, :database database},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn databases-get
  "Retrieves a resource containing information about a database inside a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/databases/get

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
database <string> Name of the database in the instance."
  [project instance database]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/databases/{database}",
     :uri-template-args
     {:project project, :instance instance, :database database},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn databases-insert
  "Inserts a resource containing information about a database inside a Cloud SQL instance. **Note:** You can't modify the default character set and collation.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/databases/insert

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
Database:
{:instance string,
 :name string,
 :selfLink string,
 :etag string,
 :collation string,
 :charset string,
 :project string,
 :kind string,
 :sqlserverDatabaseDetails
 {:compatibilityLevel integer, :recoveryModel string}}"
  [project instance Database]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/databases",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body Database}))

(defn databases-list
  "Lists databases in the specified Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/databases/list

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/databases",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn databases-patch
  "Partially updates a resource containing information about a database inside a Cloud SQL instance. This method supports patch semantics.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/databases/patch

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
database <string> Name of the database to be updated in the instance.
Database:
{:instance string,
 :name string,
 :selfLink string,
 :etag string,
 :collation string,
 :charset string,
 :project string,
 :kind string,
 :sqlserverDatabaseDetails
 {:compatibilityLevel integer, :recoveryModel string}}"
  [project instance database Database]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/databases/{database}",
     :uri-template-args
     {:project project, :instance instance, :database database},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body Database}))

(defn databases-update
  "Updates a resource containing information about a database inside a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/databases/update

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
database <string> Name of the database to be updated in the instance.
Database:
{:instance string,
 :name string,
 :selfLink string,
 :etag string,
 :collation string,
 :charset string,
 :project string,
 :kind string,
 :sqlserverDatabaseDetails
 {:compatibilityLevel integer, :recoveryModel string}}"
  [project instance database Database]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/databases/{database}",
     :uri-template-args
     {:project project, :instance instance, :database database},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body Database}))

(defn instances-failover
  "Initiates a manual failover of a high availability (HA) primary instance to a standby instance, which becomes the primary instance. Users are then rerouted to the new primary. For more information, see the [Overview of high availability](https://cloud.google.com/sql/docs/mysql/high-availability) page in the Cloud SQL documentation. If using Legacy HA (MySQL only), this causes the instance to failover to its failover replica instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/failover

project <string> ID of the project that contains the read replica.
instance <string> Cloud SQL instance ID. This does not include the project ID.
InstancesFailoverRequest:
{:failoverContext {:settingsVersion string, :kind string}}"
  [project instance InstancesFailoverRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/failover",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesFailoverRequest}))

(defn instances-get
  "Retrieves a resource containing information about a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/get

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-insert
  "Creates a new Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/insert

project <string> Project ID of the project to which the newly created Cloud SQL instances should belong.
DatabaseInstance:
{:onPremisesConfiguration
 {:sourceInstance {:name string, :region string, :project string},
  :clientCertificate string,
  :password string,
  :clientKey string,
  :caCertificate string,
  :username string,
  :kind string,
  :dumpFilePath string,
  :hostPort string},
 :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
 :databaseVersion
 [SQL_DATABASE_VERSION_UNSPECIFIED
  MYSQL_5_1
  MYSQL_5_5
  MYSQL_5_6
  MYSQL_5_7
  SQLSERVER_2017_STANDARD
  SQLSERVER_2017_ENTERPRISE
  SQLSERVER_2017_EXPRESS
  SQLSERVER_2017_WEB
  POSTGRES_9_6
  POSTGRES_10
  POSTGRES_11
  POSTGRES_12
  POSTGRES_13
  POSTGRES_14
  POSTGRES_15
  POSTGRES_16
  MYSQL_8_0
  MYSQL_8_0_18
  MYSQL_8_0_26
  MYSQL_8_0_27
  MYSQL_8_0_28
  MYSQL_8_0_29
  MYSQL_8_0_30
  MYSQL_8_0_31
  MYSQL_8_0_32
  MYSQL_8_0_33
  MYSQL_8_0_34
  MYSQL_8_0_35
  MYSQL_8_0_36
  MYSQL_8_0_37
  MYSQL_8_0_38
  MYSQL_8_0_39
  MYSQL_8_0_40
  MYSQL_8_4
  MYSQL_8_4_0
  SQLSERVER_2019_STANDARD
  SQLSERVER_2019_ENTERPRISE
  SQLSERVER_2019_EXPRESS
  SQLSERVER_2019_WEB
  SQLSERVER_2022_STANDARD
  SQLSERVER_2022_ENTERPRISE
  SQLSERVER_2022_EXPRESS
  SQLSERVER_2022_WEB],
 :maxDiskSize string,
 :replicationCluster
 {:psaWriteEndpoint string,
  :failoverDrReplicaName string,
  :drReplica boolean},
 :instanceType
 [SQL_INSTANCE_TYPE_UNSPECIFIED
  CLOUD_SQL_INSTANCE
  ON_PREMISES_INSTANCE
  READ_REPLICA_INSTANCE],
 :rootPassword string,
 :upgradableDatabaseVersions
 [{:majorVersion string, :name string, :displayName string}],
 :currentDiskSize string,
 :gceZone string,
 :name string,
 :masterInstanceName string,
 :createTime string,
 :settings
 {:dataCacheConfig {:dataCacheEnabled boolean},
  :activeDirectoryConfig {:kind string, :domain string},
  :availabilityType [SQL_AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
  :timeZone string,
  :tier string,
  :databaseFlags [{:name string, :value string}],
  :databaseReplicationEnabled boolean,
  :sqlServerAuditConfig
  {:kind string,
   :bucket string,
   :retentionInterval string,
   :uploadInterval string},
  :settingsVersion string,
  :storageAutoResizeLimit string,
  :crashSafeReplicationEnabled boolean,
  :activationPolicy
  [SQL_ACTIVATION_POLICY_UNSPECIFIED ALWAYS NEVER ON_DEMAND],
  :deletionProtectionEnabled boolean,
  :collation string,
  :storageAutoResize boolean,
  :pricingPlan [SQL_PRICING_PLAN_UNSPECIFIED PACKAGE PER_USE],
  :enableDataplexIntegration boolean,
  :locationPreference
  {:followGaeApplication string,
   :zone string,
   :secondaryZone string,
   :kind string},
  :insightsConfig
  {:queryInsightsEnabled boolean,
   :recordClientAddress boolean,
   :recordApplicationTags boolean,
   :queryStringLength integer,
   :queryPlansPerMinute integer},
  :advancedMachineFeatures {:threadsPerCore integer},
  :ipConfiguration
  {:ipv4Enabled boolean,
   :privateNetwork string,
   :requireSsl boolean,
   :authorizedNetworks
   [{:value string,
     :expirationTime string,
     :name string,
     :kind string}],
   :allocatedIpRange string,
   :enablePrivatePathForGoogleCloudServices boolean,
   :sslMode
   [SSL_MODE_UNSPECIFIED
    ALLOW_UNENCRYPTED_AND_ENCRYPTED
    ENCRYPTED_ONLY
    TRUSTED_CLIENT_CERTIFICATE_REQUIRED],
   :pscConfig
   {:pscEnabled boolean, :allowedConsumerProjects [string]}},
  :passwordValidationPolicy
  {:minLength integer,
   :complexity [COMPLEXITY_UNSPECIFIED COMPLEXITY_DEFAULT],
   :reuseInterval integer,
   :disallowUsernameSubstring boolean,
   :passwordChangeInterval string,
   :enablePasswordPolicy boolean,
   :disallowCompromisedCredentials boolean},
  :enableGoogleMlIntegration boolean,
  :kind string,
  :maintenanceWindow
  {:hour integer,
   :day integer,
   :updateTrack [SQL_UPDATE_TRACK_UNSPECIFIED canary stable week5],
   :kind string},
  :edition [EDITION_UNSPECIFIED ENTERPRISE ENTERPRISE_PLUS],
  :backupConfiguration
  {:binaryLogEnabled boolean,
   :startTime string,
   :transactionalLogStorageState
   [TRANSACTIONAL_LOG_STORAGE_STATE_UNSPECIFIED
    DISK
    SWITCHING_TO_CLOUD_STORAGE
    SWITCHED_TO_CLOUD_STORAGE
    CLOUD_STORAGE],
   :pointInTimeRecoveryEnabled boolean,
   :backupRetentionSettings
   {:retentionUnit [RETENTION_UNIT_UNSPECIFIED COUNT],
    :retainedBackups integer},
   :kind string,
   :replicationLogArchivingEnabled boolean,
   :location string,
   :enabled boolean,
   :transactionLogRetentionDays integer},
  :denyMaintenancePeriods
  [{:startDate string, :endDate string, :time string}],
  :dataDiskSizeGb string,
  :replicationType
  [SQL_REPLICATION_TYPE_UNSPECIFIED SYNCHRONOUS ASYNCHRONOUS],
  :userLabels object,
  :dataDiskType
  [SQL_DATA_DISK_TYPE_UNSPECIFIED PD_SSD PD_HDD OBSOLETE_LOCAL_SSD],
  :connectorEnforcement
  [CONNECTOR_ENFORCEMENT_UNSPECIFIED NOT_REQUIRED REQUIRED],
  :authorizedGaeApplications [string]},
 :selfLink string,
 :primaryDnsName string,
 :etag string,
 :ipAddresses
 [{:type
   [SQL_IP_ADDRESS_TYPE_UNSPECIFIED
    PRIMARY
    OUTGOING
    PRIVATE
    MIGRATED_1ST_GEN],
   :ipAddress string,
   :timeToRetire string}],
 :state
 [SQL_INSTANCE_STATE_UNSPECIFIED
  RUNNABLE
  SUSPENDED
  PENDING_DELETE
  PENDING_CREATE
  MAINTENANCE
  FAILED
  ONLINE_MAINTENANCE],
 :ipv6Address string,
 :availableMaintenanceVersions [string],
 :region string,
 :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
 :replicaNames [string],
 :sqlNetworkArchitecture
 [SQL_NETWORK_ARCHITECTURE_UNSPECIFIED
  NEW_NETWORK_ARCHITECTURE
  OLD_NETWORK_ARCHITECTURE],
 :pscServiceAttachmentLink string,
 :geminiConfig
 {:entitled boolean,
  :googleVacuumMgmtEnabled boolean,
  :oomSessionCancelEnabled boolean,
  :activeQueryEnabled boolean,
  :indexAdvisorEnabled boolean,
  :flagRecommenderEnabled boolean},
 :failoverReplica {:name string, :available boolean},
 :satisfiesPzs boolean,
 :dnsName string,
 :project string,
 :kind string,
 :backendType
 [SQL_BACKEND_TYPE_UNSPECIFIED FIRST_GEN SECOND_GEN EXTERNAL],
 :maintenanceVersion string,
 :serviceAccountEmailAddress string,
 :scheduledMaintenance
 {:startTime string,
  :canDefer boolean,
  :canReschedule boolean,
  :scheduleDeadlineTime string},
 :replicaConfiguration
 {:kind string,
  :mysqlReplicaConfiguration
  {:clientCertificate string,
   :sslCipher string,
   :password string,
   :clientKey string,
   :caCertificate string,
   :username string,
   :connectRetryInterval integer,
   :verifyServerCertificate boolean,
   :kind string,
   :dumpFilePath string,
   :masterHeartbeatPeriod string},
  :failoverTarget boolean,
  :cascadableReplica boolean},
 :serverCaCert
 {:instance string,
  :expirationTime string,
  :cert string,
  :createTime string,
  :selfLink string,
  :sha1Fingerprint string,
  :kind string,
  :commonName string,
  :certSerialNumber string},
 :connectionName string,
 :secondaryGceZone string,
 :outOfDiskReport
 {:sqlOutOfDiskState
  [SQL_OUT_OF_DISK_STATE_UNSPECIFIED NORMAL SOFT_SHUTDOWN],
  :sqlMinRecommendedIncreaseSizeGb integer},
 :writeEndpoint string,
 :suspensionReason
 [[SQL_SUSPENSION_REASON_UNSPECIFIED
   BILLING_ISSUE
   LEGAL_ISSUE
   OPERATIONAL_ISSUE
   KMS_KEY_ISSUE]],
 :databaseInstalledVersion string}"
  [project DatabaseInstance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances",
     :uri-template-args {:project project},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body DatabaseInstance}))

(defn instances-demoteMaster
  "Demotes the stand-alone instance to be a Cloud SQL read replica for an external database server.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/demoteMaster

project <string> ID of the project that contains the instance.
instance <string> Cloud SQL instance name.
InstancesDemoteMasterRequest:
{:demoteMasterContext
 {:kind string,
  :verifyGtidConsistency boolean,
  :masterInstanceName string,
  :replicaConfiguration
  {:kind string,
   :mysqlReplicaConfiguration
   {:kind string,
    :username string,
    :password string,
    :clientKey string,
    :clientCertificate string,
    :caCertificate string}},
  :skipReplicationSetup boolean}}"
  [project instance InstancesDemoteMasterRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/demoteMaster",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesDemoteMasterRequest}))

(defn instances-restart
  "Restarts a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/restart

project <string> Project ID of the project that contains the instance to be restarted.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/restart",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-patch
  "Partially updates settings of a Cloud SQL instance by merging the request with the current configuration. This method supports patch semantics.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/patch

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
DatabaseInstance:
{:onPremisesConfiguration
 {:sourceInstance {:name string, :region string, :project string},
  :clientCertificate string,
  :password string,
  :clientKey string,
  :caCertificate string,
  :username string,
  :kind string,
  :dumpFilePath string,
  :hostPort string},
 :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
 :databaseVersion
 [SQL_DATABASE_VERSION_UNSPECIFIED
  MYSQL_5_1
  MYSQL_5_5
  MYSQL_5_6
  MYSQL_5_7
  SQLSERVER_2017_STANDARD
  SQLSERVER_2017_ENTERPRISE
  SQLSERVER_2017_EXPRESS
  SQLSERVER_2017_WEB
  POSTGRES_9_6
  POSTGRES_10
  POSTGRES_11
  POSTGRES_12
  POSTGRES_13
  POSTGRES_14
  POSTGRES_15
  POSTGRES_16
  MYSQL_8_0
  MYSQL_8_0_18
  MYSQL_8_0_26
  MYSQL_8_0_27
  MYSQL_8_0_28
  MYSQL_8_0_29
  MYSQL_8_0_30
  MYSQL_8_0_31
  MYSQL_8_0_32
  MYSQL_8_0_33
  MYSQL_8_0_34
  MYSQL_8_0_35
  MYSQL_8_0_36
  MYSQL_8_0_37
  MYSQL_8_0_38
  MYSQL_8_0_39
  MYSQL_8_0_40
  MYSQL_8_4
  MYSQL_8_4_0
  SQLSERVER_2019_STANDARD
  SQLSERVER_2019_ENTERPRISE
  SQLSERVER_2019_EXPRESS
  SQLSERVER_2019_WEB
  SQLSERVER_2022_STANDARD
  SQLSERVER_2022_ENTERPRISE
  SQLSERVER_2022_EXPRESS
  SQLSERVER_2022_WEB],
 :maxDiskSize string,
 :replicationCluster
 {:psaWriteEndpoint string,
  :failoverDrReplicaName string,
  :drReplica boolean},
 :instanceType
 [SQL_INSTANCE_TYPE_UNSPECIFIED
  CLOUD_SQL_INSTANCE
  ON_PREMISES_INSTANCE
  READ_REPLICA_INSTANCE],
 :rootPassword string,
 :upgradableDatabaseVersions
 [{:majorVersion string, :name string, :displayName string}],
 :currentDiskSize string,
 :gceZone string,
 :name string,
 :masterInstanceName string,
 :createTime string,
 :settings
 {:dataCacheConfig {:dataCacheEnabled boolean},
  :activeDirectoryConfig {:kind string, :domain string},
  :availabilityType [SQL_AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
  :timeZone string,
  :tier string,
  :databaseFlags [{:name string, :value string}],
  :databaseReplicationEnabled boolean,
  :sqlServerAuditConfig
  {:kind string,
   :bucket string,
   :retentionInterval string,
   :uploadInterval string},
  :settingsVersion string,
  :storageAutoResizeLimit string,
  :crashSafeReplicationEnabled boolean,
  :activationPolicy
  [SQL_ACTIVATION_POLICY_UNSPECIFIED ALWAYS NEVER ON_DEMAND],
  :deletionProtectionEnabled boolean,
  :collation string,
  :storageAutoResize boolean,
  :pricingPlan [SQL_PRICING_PLAN_UNSPECIFIED PACKAGE PER_USE],
  :enableDataplexIntegration boolean,
  :locationPreference
  {:followGaeApplication string,
   :zone string,
   :secondaryZone string,
   :kind string},
  :insightsConfig
  {:queryInsightsEnabled boolean,
   :recordClientAddress boolean,
   :recordApplicationTags boolean,
   :queryStringLength integer,
   :queryPlansPerMinute integer},
  :advancedMachineFeatures {:threadsPerCore integer},
  :ipConfiguration
  {:ipv4Enabled boolean,
   :privateNetwork string,
   :requireSsl boolean,
   :authorizedNetworks
   [{:value string,
     :expirationTime string,
     :name string,
     :kind string}],
   :allocatedIpRange string,
   :enablePrivatePathForGoogleCloudServices boolean,
   :sslMode
   [SSL_MODE_UNSPECIFIED
    ALLOW_UNENCRYPTED_AND_ENCRYPTED
    ENCRYPTED_ONLY
    TRUSTED_CLIENT_CERTIFICATE_REQUIRED],
   :pscConfig
   {:pscEnabled boolean, :allowedConsumerProjects [string]}},
  :passwordValidationPolicy
  {:minLength integer,
   :complexity [COMPLEXITY_UNSPECIFIED COMPLEXITY_DEFAULT],
   :reuseInterval integer,
   :disallowUsernameSubstring boolean,
   :passwordChangeInterval string,
   :enablePasswordPolicy boolean,
   :disallowCompromisedCredentials boolean},
  :enableGoogleMlIntegration boolean,
  :kind string,
  :maintenanceWindow
  {:hour integer,
   :day integer,
   :updateTrack [SQL_UPDATE_TRACK_UNSPECIFIED canary stable week5],
   :kind string},
  :edition [EDITION_UNSPECIFIED ENTERPRISE ENTERPRISE_PLUS],
  :backupConfiguration
  {:binaryLogEnabled boolean,
   :startTime string,
   :transactionalLogStorageState
   [TRANSACTIONAL_LOG_STORAGE_STATE_UNSPECIFIED
    DISK
    SWITCHING_TO_CLOUD_STORAGE
    SWITCHED_TO_CLOUD_STORAGE
    CLOUD_STORAGE],
   :pointInTimeRecoveryEnabled boolean,
   :backupRetentionSettings
   {:retentionUnit [RETENTION_UNIT_UNSPECIFIED COUNT],
    :retainedBackups integer},
   :kind string,
   :replicationLogArchivingEnabled boolean,
   :location string,
   :enabled boolean,
   :transactionLogRetentionDays integer},
  :denyMaintenancePeriods
  [{:startDate string, :endDate string, :time string}],
  :dataDiskSizeGb string,
  :replicationType
  [SQL_REPLICATION_TYPE_UNSPECIFIED SYNCHRONOUS ASYNCHRONOUS],
  :userLabels object,
  :dataDiskType
  [SQL_DATA_DISK_TYPE_UNSPECIFIED PD_SSD PD_HDD OBSOLETE_LOCAL_SSD],
  :connectorEnforcement
  [CONNECTOR_ENFORCEMENT_UNSPECIFIED NOT_REQUIRED REQUIRED],
  :authorizedGaeApplications [string]},
 :selfLink string,
 :primaryDnsName string,
 :etag string,
 :ipAddresses
 [{:type
   [SQL_IP_ADDRESS_TYPE_UNSPECIFIED
    PRIMARY
    OUTGOING
    PRIVATE
    MIGRATED_1ST_GEN],
   :ipAddress string,
   :timeToRetire string}],
 :state
 [SQL_INSTANCE_STATE_UNSPECIFIED
  RUNNABLE
  SUSPENDED
  PENDING_DELETE
  PENDING_CREATE
  MAINTENANCE
  FAILED
  ONLINE_MAINTENANCE],
 :ipv6Address string,
 :availableMaintenanceVersions [string],
 :region string,
 :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
 :replicaNames [string],
 :sqlNetworkArchitecture
 [SQL_NETWORK_ARCHITECTURE_UNSPECIFIED
  NEW_NETWORK_ARCHITECTURE
  OLD_NETWORK_ARCHITECTURE],
 :pscServiceAttachmentLink string,
 :geminiConfig
 {:entitled boolean,
  :googleVacuumMgmtEnabled boolean,
  :oomSessionCancelEnabled boolean,
  :activeQueryEnabled boolean,
  :indexAdvisorEnabled boolean,
  :flagRecommenderEnabled boolean},
 :failoverReplica {:name string, :available boolean},
 :satisfiesPzs boolean,
 :dnsName string,
 :project string,
 :kind string,
 :backendType
 [SQL_BACKEND_TYPE_UNSPECIFIED FIRST_GEN SECOND_GEN EXTERNAL],
 :maintenanceVersion string,
 :serviceAccountEmailAddress string,
 :scheduledMaintenance
 {:startTime string,
  :canDefer boolean,
  :canReschedule boolean,
  :scheduleDeadlineTime string},
 :replicaConfiguration
 {:kind string,
  :mysqlReplicaConfiguration
  {:clientCertificate string,
   :sslCipher string,
   :password string,
   :clientKey string,
   :caCertificate string,
   :username string,
   :connectRetryInterval integer,
   :verifyServerCertificate boolean,
   :kind string,
   :dumpFilePath string,
   :masterHeartbeatPeriod string},
  :failoverTarget boolean,
  :cascadableReplica boolean},
 :serverCaCert
 {:instance string,
  :expirationTime string,
  :cert string,
  :createTime string,
  :selfLink string,
  :sha1Fingerprint string,
  :kind string,
  :commonName string,
  :certSerialNumber string},
 :connectionName string,
 :secondaryGceZone string,
 :outOfDiskReport
 {:sqlOutOfDiskState
  [SQL_OUT_OF_DISK_STATE_UNSPECIFIED NORMAL SOFT_SHUTDOWN],
  :sqlMinRecommendedIncreaseSizeGb integer},
 :writeEndpoint string,
 :suspensionReason
 [[SQL_SUSPENSION_REASON_UNSPECIFIED
   BILLING_ISSUE
   LEGAL_ISSUE
   OPERATIONAL_ISSUE
   KMS_KEY_ISSUE]],
 :databaseInstalledVersion string}"
  [project instance DatabaseInstance]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body DatabaseInstance}))

(defn instances-addServerCa
  "Adds a new trusted Certificate Authority (CA) version for the specified instance. Required to prepare for a certificate rotation. If a CA version was previously added but never used in a certificate rotation, this operation replaces that version. There cannot be more than one CA version waiting to be rotated in.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/addServerCa

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/addServerCa",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-stopReplica
  "Stops the replication in the read replica instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/stopReplica

project <string> ID of the project that contains the read replica.
instance <string> Cloud SQL read replica instance name."
  [project instance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/stopReplica",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-update
  "Updates settings of a Cloud SQL instance. Using this operation might cause your instance to restart.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/update

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
DatabaseInstance:
{:onPremisesConfiguration
 {:sourceInstance {:name string, :region string, :project string},
  :clientCertificate string,
  :password string,
  :clientKey string,
  :caCertificate string,
  :username string,
  :kind string,
  :dumpFilePath string,
  :hostPort string},
 :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
 :databaseVersion
 [SQL_DATABASE_VERSION_UNSPECIFIED
  MYSQL_5_1
  MYSQL_5_5
  MYSQL_5_6
  MYSQL_5_7
  SQLSERVER_2017_STANDARD
  SQLSERVER_2017_ENTERPRISE
  SQLSERVER_2017_EXPRESS
  SQLSERVER_2017_WEB
  POSTGRES_9_6
  POSTGRES_10
  POSTGRES_11
  POSTGRES_12
  POSTGRES_13
  POSTGRES_14
  POSTGRES_15
  POSTGRES_16
  MYSQL_8_0
  MYSQL_8_0_18
  MYSQL_8_0_26
  MYSQL_8_0_27
  MYSQL_8_0_28
  MYSQL_8_0_29
  MYSQL_8_0_30
  MYSQL_8_0_31
  MYSQL_8_0_32
  MYSQL_8_0_33
  MYSQL_8_0_34
  MYSQL_8_0_35
  MYSQL_8_0_36
  MYSQL_8_0_37
  MYSQL_8_0_38
  MYSQL_8_0_39
  MYSQL_8_0_40
  MYSQL_8_4
  MYSQL_8_4_0
  SQLSERVER_2019_STANDARD
  SQLSERVER_2019_ENTERPRISE
  SQLSERVER_2019_EXPRESS
  SQLSERVER_2019_WEB
  SQLSERVER_2022_STANDARD
  SQLSERVER_2022_ENTERPRISE
  SQLSERVER_2022_EXPRESS
  SQLSERVER_2022_WEB],
 :maxDiskSize string,
 :replicationCluster
 {:psaWriteEndpoint string,
  :failoverDrReplicaName string,
  :drReplica boolean},
 :instanceType
 [SQL_INSTANCE_TYPE_UNSPECIFIED
  CLOUD_SQL_INSTANCE
  ON_PREMISES_INSTANCE
  READ_REPLICA_INSTANCE],
 :rootPassword string,
 :upgradableDatabaseVersions
 [{:majorVersion string, :name string, :displayName string}],
 :currentDiskSize string,
 :gceZone string,
 :name string,
 :masterInstanceName string,
 :createTime string,
 :settings
 {:dataCacheConfig {:dataCacheEnabled boolean},
  :activeDirectoryConfig {:kind string, :domain string},
  :availabilityType [SQL_AVAILABILITY_TYPE_UNSPECIFIED ZONAL REGIONAL],
  :timeZone string,
  :tier string,
  :databaseFlags [{:name string, :value string}],
  :databaseReplicationEnabled boolean,
  :sqlServerAuditConfig
  {:kind string,
   :bucket string,
   :retentionInterval string,
   :uploadInterval string},
  :settingsVersion string,
  :storageAutoResizeLimit string,
  :crashSafeReplicationEnabled boolean,
  :activationPolicy
  [SQL_ACTIVATION_POLICY_UNSPECIFIED ALWAYS NEVER ON_DEMAND],
  :deletionProtectionEnabled boolean,
  :collation string,
  :storageAutoResize boolean,
  :pricingPlan [SQL_PRICING_PLAN_UNSPECIFIED PACKAGE PER_USE],
  :enableDataplexIntegration boolean,
  :locationPreference
  {:followGaeApplication string,
   :zone string,
   :secondaryZone string,
   :kind string},
  :insightsConfig
  {:queryInsightsEnabled boolean,
   :recordClientAddress boolean,
   :recordApplicationTags boolean,
   :queryStringLength integer,
   :queryPlansPerMinute integer},
  :advancedMachineFeatures {:threadsPerCore integer},
  :ipConfiguration
  {:ipv4Enabled boolean,
   :privateNetwork string,
   :requireSsl boolean,
   :authorizedNetworks
   [{:value string,
     :expirationTime string,
     :name string,
     :kind string}],
   :allocatedIpRange string,
   :enablePrivatePathForGoogleCloudServices boolean,
   :sslMode
   [SSL_MODE_UNSPECIFIED
    ALLOW_UNENCRYPTED_AND_ENCRYPTED
    ENCRYPTED_ONLY
    TRUSTED_CLIENT_CERTIFICATE_REQUIRED],
   :pscConfig
   {:pscEnabled boolean, :allowedConsumerProjects [string]}},
  :passwordValidationPolicy
  {:minLength integer,
   :complexity [COMPLEXITY_UNSPECIFIED COMPLEXITY_DEFAULT],
   :reuseInterval integer,
   :disallowUsernameSubstring boolean,
   :passwordChangeInterval string,
   :enablePasswordPolicy boolean,
   :disallowCompromisedCredentials boolean},
  :enableGoogleMlIntegration boolean,
  :kind string,
  :maintenanceWindow
  {:hour integer,
   :day integer,
   :updateTrack [SQL_UPDATE_TRACK_UNSPECIFIED canary stable week5],
   :kind string},
  :edition [EDITION_UNSPECIFIED ENTERPRISE ENTERPRISE_PLUS],
  :backupConfiguration
  {:binaryLogEnabled boolean,
   :startTime string,
   :transactionalLogStorageState
   [TRANSACTIONAL_LOG_STORAGE_STATE_UNSPECIFIED
    DISK
    SWITCHING_TO_CLOUD_STORAGE
    SWITCHED_TO_CLOUD_STORAGE
    CLOUD_STORAGE],
   :pointInTimeRecoveryEnabled boolean,
   :backupRetentionSettings
   {:retentionUnit [RETENTION_UNIT_UNSPECIFIED COUNT],
    :retainedBackups integer},
   :kind string,
   :replicationLogArchivingEnabled boolean,
   :location string,
   :enabled boolean,
   :transactionLogRetentionDays integer},
  :denyMaintenancePeriods
  [{:startDate string, :endDate string, :time string}],
  :dataDiskSizeGb string,
  :replicationType
  [SQL_REPLICATION_TYPE_UNSPECIFIED SYNCHRONOUS ASYNCHRONOUS],
  :userLabels object,
  :dataDiskType
  [SQL_DATA_DISK_TYPE_UNSPECIFIED PD_SSD PD_HDD OBSOLETE_LOCAL_SSD],
  :connectorEnforcement
  [CONNECTOR_ENFORCEMENT_UNSPECIFIED NOT_REQUIRED REQUIRED],
  :authorizedGaeApplications [string]},
 :selfLink string,
 :primaryDnsName string,
 :etag string,
 :ipAddresses
 [{:type
   [SQL_IP_ADDRESS_TYPE_UNSPECIFIED
    PRIMARY
    OUTGOING
    PRIVATE
    MIGRATED_1ST_GEN],
   :ipAddress string,
   :timeToRetire string}],
 :state
 [SQL_INSTANCE_STATE_UNSPECIFIED
  RUNNABLE
  SUSPENDED
  PENDING_DELETE
  PENDING_CREATE
  MAINTENANCE
  FAILED
  ONLINE_MAINTENANCE],
 :ipv6Address string,
 :availableMaintenanceVersions [string],
 :region string,
 :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
 :replicaNames [string],
 :sqlNetworkArchitecture
 [SQL_NETWORK_ARCHITECTURE_UNSPECIFIED
  NEW_NETWORK_ARCHITECTURE
  OLD_NETWORK_ARCHITECTURE],
 :pscServiceAttachmentLink string,
 :geminiConfig
 {:entitled boolean,
  :googleVacuumMgmtEnabled boolean,
  :oomSessionCancelEnabled boolean,
  :activeQueryEnabled boolean,
  :indexAdvisorEnabled boolean,
  :flagRecommenderEnabled boolean},
 :failoverReplica {:name string, :available boolean},
 :satisfiesPzs boolean,
 :dnsName string,
 :project string,
 :kind string,
 :backendType
 [SQL_BACKEND_TYPE_UNSPECIFIED FIRST_GEN SECOND_GEN EXTERNAL],
 :maintenanceVersion string,
 :serviceAccountEmailAddress string,
 :scheduledMaintenance
 {:startTime string,
  :canDefer boolean,
  :canReschedule boolean,
  :scheduleDeadlineTime string},
 :replicaConfiguration
 {:kind string,
  :mysqlReplicaConfiguration
  {:clientCertificate string,
   :sslCipher string,
   :password string,
   :clientKey string,
   :caCertificate string,
   :username string,
   :connectRetryInterval integer,
   :verifyServerCertificate boolean,
   :kind string,
   :dumpFilePath string,
   :masterHeartbeatPeriod string},
  :failoverTarget boolean,
  :cascadableReplica boolean},
 :serverCaCert
 {:instance string,
  :expirationTime string,
  :cert string,
  :createTime string,
  :selfLink string,
  :sha1Fingerprint string,
  :kind string,
  :commonName string,
  :certSerialNumber string},
 :connectionName string,
 :secondaryGceZone string,
 :outOfDiskReport
 {:sqlOutOfDiskState
  [SQL_OUT_OF_DISK_STATE_UNSPECIFIED NORMAL SOFT_SHUTDOWN],
  :sqlMinRecommendedIncreaseSizeGb integer},
 :writeEndpoint string,
 :suspensionReason
 [[SQL_SUSPENSION_REASON_UNSPECIFIED
   BILLING_ISSUE
   LEGAL_ISSUE
   OPERATIONAL_ISSUE
   KMS_KEY_ISSUE]],
 :databaseInstalledVersion string}"
  [project instance DatabaseInstance]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body DatabaseInstance}))

(defn instances-delete
  "Deletes a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/delete

project <string> Project ID of the project that contains the instance to be deleted.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-releaseSsrsLease
  "Release a lease for the setup of SQL Server Reporting Services (SSRS).
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/releaseSsrsLease

project <string> Required. The project ID that contains the instance.
instance <string> Required. The Cloud SQL instance ID. This doesn't include the project ID. The instance ID contains lowercase letters, numbers, and hyphens, and it must start with a letter. This ID can have a maximum length of 98 characters."
  [project instance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/releaseSsrsLease",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-export
  "Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL dump or CSV file.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/export

project <string> Project ID of the project that contains the instance to be exported.
instance <string> Cloud SQL instance ID. This does not include the project ID.
InstancesExportRequest:
{:exportContext
 {:uri string,
  :databases [string],
  :kind string,
  :sqlExportOptions
  {:tables [string],
   :schemaOnly boolean,
   :mysqlExportOptions {:masterData integer},
   :threads integer,
   :parallel boolean},
  :csvExportOptions
  {:selectQuery string,
   :escapeCharacter string,
   :quoteCharacter string,
   :fieldsTerminatedBy string,
   :linesTerminatedBy string},
  :fileType [SQL_FILE_TYPE_UNSPECIFIED SQL CSV BAK],
  :offload boolean,
  :bakExportOptions
  {:striped boolean,
   :stripeCount integer,
   :bakType [BAK_TYPE_UNSPECIFIED FULL DIFF TLOG],
   :copyOnly boolean,
   :differentialBase boolean}}}"
  [project instance InstancesExportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/export",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InstancesExportRequest}))

(defn instances-demote
  "Demotes an existing standalone instance to be a Cloud SQL read replica for an external database server.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/demote

project <string> Required. ID of the project that contains the instance.
instance <string> Required. Cloud SQL instance name.
InstancesDemoteRequest:
{:demoteContext
 {:kind string, :sourceRepresentativeInstanceName string}}"
  [project instance InstancesDemoteRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/demote",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesDemoteRequest}))

(defn instances-listServerCas
  "Lists all of the trusted Certificate Authorities (CAs) for the specified instance. There can be up to three CAs listed: the CA that was used to sign the certificate that is currently in use, a CA that has been added but not yet used to sign a certificate, and a CA used to sign a certificate that has previously rotated out.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/listServerCas

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/listServerCas",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-promoteReplica
  "Promotes the read replica instance to be an independent Cloud SQL primary instance. Using this operation might cause your instance to restart.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/promoteReplica

project <string> ID of the project that contains the read replica.
instance <string> Cloud SQL read replica instance name.

optional:
failover <boolean> Set to true to invoke a replica failover to the designated DR replica. As part of replica failover, the promote operation attempts to add the original primary instance as a replica of the promoted DR replica when the original primary instance comes back online. If set to false or not specified, then the original primary instance becomes an independent Cloud SQL primary instance. Only applicable to MySQL."
  ([project instance] (instances-promoteReplica project instance nil))
  ([project instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/promoteReplica",
       :uri-template-args {:project project, :instance instance},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn instances-acquireSsrsLease
  "Acquire a lease for the setup of SQL Server Reporting Services (SSRS).
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/acquireSsrsLease

project <string> Required. Project ID of the project that contains the instance (Example: project-id).
instance <string> Required. Cloud SQL instance ID. This doesn't include the project ID. It's composed of lowercase letters, numbers, and hyphens, and it must start with a letter. The total length must be 98 characters or less (Example: instance-id).
InstancesAcquireSsrsLeaseRequest:
{:acquireSsrsLeaseContext
 {:setupLogin string,
  :serviceLogin string,
  :reportDatabase string,
  :duration string}}"
  [project instance InstancesAcquireSsrsLeaseRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/acquireSsrsLease",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesAcquireSsrsLeaseRequest}))

(defn instances-resetSslConfig
  "Deletes all client certificates and generates a new server SSL certificate for the instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/resetSslConfig

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/resetSslConfig",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-list
  "Lists instances under a given project.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/list

project <string> Project ID of the project for which to list Cloud SQL instances.

optional:
filter <string> A filter expression that filters resources listed in the response. The expression is in the form of field:value. For example, 'instanceType:CLOUD_SQL_INSTANCE'. Fields can be nested as needed as per their JSON representation, such as 'settings.userLabels.auto_start:true'. Multiple filter queries are space-separated. For example. 'state:RUNNABLE instanceType:CLOUD_SQL_INSTANCE'. By default, each expression is an AND expression. However, you can include AND and OR expressions explicitly.
maxResults <integer> The maximum number of instances to return. The service may return fewer than this value. If unspecified, at most 500 instances are returned. The maximum value is 1000; values above 1000 are coerced to 1000."
  ([project] (instances-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn instances-clone
  "Creates a Cloud SQL instance as a clone of the source instance. Using this operation might cause your instance to restart.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/clone

project <string> Project ID of the source as well as the clone Cloud SQL instance.
instance <string> The ID of the Cloud SQL instance to be cloned (source). This does not include the project ID.
InstancesCloneRequest:
{:cloneContext
 {:kind string,
  :pitrTimestampMs string,
  :destinationInstanceName string,
  :binLogCoordinates
  {:binLogFileName string, :binLogPosition string, :kind string},
  :pointInTime string,
  :allocatedIpRange string,
  :databaseNames [string],
  :preferredZone string}}"
  [project instance InstancesCloneRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/clone",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesCloneRequest}))

(defn instances-restoreBackup
  "Restores a backup of a Cloud SQL instance. Using this operation might cause your instance to restart.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/restoreBackup

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
InstancesRestoreBackupRequest:
{:restoreBackupContext
 {:kind string,
  :backupRunId string,
  :instanceId string,
  :project string}}"
  [project instance InstancesRestoreBackupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/restoreBackup",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesRestoreBackupRequest}))

(defn instances-startReplica
  "Starts the replication in the read replica instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/startReplica

project <string> ID of the project that contains the read replica.
instance <string> Cloud SQL read replica instance name."
  [project instance]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/startReplica",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn instances-rotateServerCa
  "Rotates the server certificate to one signed by the Certificate Authority (CA) version previously added with the addServerCA method.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/rotateServerCa

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
InstancesRotateServerCaRequest:
{:rotateServerCaContext {:kind string, :nextVersion string}}"
  [project instance InstancesRotateServerCaRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/rotateServerCa",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesRotateServerCaRequest}))

(defn instances-truncateLog
  "Truncate MySQL general and slow query log tables MySQL only.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/truncateLog

project <string> Project ID of the Cloud SQL project.
instance <string> Cloud SQL instance ID. This does not include the project ID.
InstancesTruncateLogRequest:
{:truncateLogContext {:kind string, :logType string}}"
  [project instance InstancesTruncateLogRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/truncateLog",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesTruncateLogRequest}))

(defn instances-switchover
  "Switches over from the primary instance to the designated DR replica instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/switchover

project <string> ID of the project that contains the replica.
instance <string> Cloud SQL read replica instance name.

optional:
dbTimeout <string> Optional. (MySQL only) Cloud SQL instance operations timeout, which is a sum of all database operations. Default value is 10 minutes and can be modified to a maximum value of 24 hours."
  ([project instance] (instances-switchover project instance nil))
  ([project instance optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/switchover",
       :uri-template-args {:project project, :instance instance},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn instances-reencrypt
  "Reencrypt CMEK instance with latest key version.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/reencrypt

project <string> ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
InstancesReencryptRequest:
{:backupReencryptionConfig
 {:backupLimit integer,
  :backupType [BACKUP_TYPE_UNSPECIFIED AUTOMATED ON_DEMAND]}}"
  [project instance InstancesReencryptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/reencrypt",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body InstancesReencryptRequest}))

(defn instances-import
  "Imports data into a Cloud SQL instance from a SQL dump or CSV file in Cloud Storage.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/instances/import

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
InstancesImportRequest:
{:importContext
 {:uri string,
  :database string,
  :kind string,
  :fileType [SQL_FILE_TYPE_UNSPECIFIED SQL CSV BAK],
  :csvImportOptions
  {:table string,
   :columns [string],
   :escapeCharacter string,
   :quoteCharacter string,
   :fieldsTerminatedBy string,
   :linesTerminatedBy string},
  :importUser string,
  :bakImportOptions
  {:encryptionOptions
   {:certPath string, :pvkPath string, :pvkPassword string},
   :striped boolean,
   :noRecovery boolean,
   :recoveryOnly boolean,
   :bakType [BAK_TYPE_UNSPECIFIED FULL DIFF TLOG],
   :stopAt string,
   :stopAtMark string},
  :sqlImportOptions {:threads integer, :parallel boolean}}}"
  [project instance InstancesImportRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/import",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body InstancesImportRequest}))

(defn backupRuns-delete
  "Deletes the backup taken by a backup run.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/delete

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
id <string> The ID of the backup run to delete. To find a backup run ID, use the [list](https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/list) method."
  [project instance id]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/backupRuns/{id}",
     :uri-template-args {:project project, :instance instance, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn backupRuns-get
  "Retrieves a resource containing information about a backup run.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/get

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
id <string> The ID of this backup run."
  [project instance id]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/backupRuns/{id}",
     :uri-template-args {:project project, :instance instance, :id id},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn backupRuns-insert
  "Creates a new backup run on demand.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/insert

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID. This does not include the project ID.
BackupRun:
{:description string,
 :timeZone string,
 :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
 :instance string,
 :startTime string,
 :windowStartTime string,
 :endTime string,
 :enqueuedTime string,
 :selfLink string,
 :type [SQL_BACKUP_RUN_TYPE_UNSPECIFIED AUTOMATED ON_DEMAND],
 :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
 :status
 [SQL_BACKUP_RUN_STATUS_UNSPECIFIED
  ENQUEUED
  OVERDUE
  RUNNING
  FAILED
  SUCCESSFUL
  SKIPPED
  DELETION_PENDING
  DELETION_FAILED
  DELETED],
 :id string,
 :kind string,
 :error {:kind string, :code string, :message string},
 :location string,
 :backupKind [SQL_BACKUP_KIND_UNSPECIFIED SNAPSHOT PHYSICAL]}"
  [project instance BackupRun]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/backupRuns",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body BackupRun}))

(defn backupRuns-list
  "Lists all backup runs associated with the project or a given instance and configuration in the reverse chronological order of the backup initiation time.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/backupRuns/list

project <string> Project ID of the project that contains the instance.
instance <string> Cloud SQL instance ID, or \"-\" for all instances. This does not include the project ID.

optional:
maxResults <integer> Maximum number of backup runs per response."
  ([project instance] (backupRuns-list project instance nil))
  ([project instance optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/backupRuns",
       :uri-template-args {:project project, :instance instance},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn operations-get
  "Retrieves an instance operation that has been performed on an instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/operations/get

project <string> Project ID of the project that contains the instance.
operation <string> Instance operation ID."
  [project operation]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/operations/{operation}",
     :uri-template-args {:project project, :operation operation},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn operations-list
  "Lists all instance operations that have been performed on the given Cloud SQL instance in the reverse chronological order of the start time.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/operations/list

project <string> Project ID of the project that contains the instance.

optional:
instance <string> Cloud SQL instance ID. This does not include the project ID.
maxResults <integer> Maximum number of operations per response."
  ([project] (operations-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/operations",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn operations-cancel
  "Cancels an instance operation that has been performed on an instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/operations/cancel

project <string> Project ID of the project that contains the instance.
operation <string> Instance operation ID."
  [project operation]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/operations/{operation}/cancel",
     :uri-template-args {:project project, :operation operation},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn tiers-list
  "Lists all available machine types (tiers) for Cloud SQL, for example, `db-custom-1-3840`. For more information, see https://cloud.google.com/sql/pricing.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/tiers/list

project <string> Project ID of the project for which to list tiers."
  [project]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/tiers",
     :uri-template-args {:project project},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn flags-list
  "Lists all available database flags for Cloud SQL instances.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/flags/list

optional:
databaseVersion <string> Database type and version you want to retrieve flags for. By default, this method returns flags for all database types and versions."
  ([] (flags-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://sqladmin.googleapis.com/v1/flags",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn users-delete
  "Deletes a user from a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/users/delete

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.

optional:
host <string> Host of the user in the instance.
name <string> Name of the user in the instance."
  ([project instance] (users-delete project instance nil))
  ([project instance optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/users",
       :uri-template-args {:project project, :instance instance},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn users-get
  "Retrieves a resource containing information about a user.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/users/get

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
name <string> User of the instance.

optional:
host <string> Host of a user of the instance."
  ([project instance name] (users-get project instance name nil))
  ([project instance name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/users/{name}",
       :uri-template-args
       {:project project, :instance instance, :name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"]})))

(defn users-insert
  "Creates a new user in a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/users/insert

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
User:
{:instance string,
 :password string,
 :passwordPolicy
 {:allowedFailedAttempts integer,
  :passwordExpirationDuration string,
  :enableFailedAttemptsCheck boolean,
  :status {:locked boolean, :passwordExpirationTime string},
  :enablePasswordVerification boolean},
 :name string,
 :type
 [BUILT_IN
  CLOUD_IAM_USER
  CLOUD_IAM_SERVICE_ACCOUNT
  CLOUD_IAM_GROUP
  CLOUD_IAM_GROUP_USER
  CLOUD_IAM_GROUP_SERVICE_ACCOUNT],
 :etag string,
 :sqlserverUserDetails {:disabled boolean, :serverRoles [string]},
 :host string,
 :project string,
 :kind string,
 :dualPasswordType
 [DUAL_PASSWORD_TYPE_UNSPECIFIED
  NO_MODIFY_DUAL_PASSWORD
  NO_DUAL_PASSWORD
  DUAL_PASSWORD]}"
  [project instance User]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/users",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"],
     :body User}))

(defn users-list
  "Lists users in the specified Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/users/list

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID."
  [project instance]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/users",
     :uri-template-args {:project project, :instance instance},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sqlservice.admin"]}))

(defn users-update
  "Updates an existing user in a Cloud SQL instance.
https://cloud.google.com/sql/docs/mysql/admin-api/rest/v1/users/update

project <string> Project ID of the project that contains the instance.
instance <string> Database instance ID. This does not include the project ID.
User:
{:instance string,
 :password string,
 :passwordPolicy
 {:allowedFailedAttempts integer,
  :passwordExpirationDuration string,
  :enableFailedAttemptsCheck boolean,
  :status {:locked boolean, :passwordExpirationTime string},
  :enablePasswordVerification boolean},
 :name string,
 :type
 [BUILT_IN
  CLOUD_IAM_USER
  CLOUD_IAM_SERVICE_ACCOUNT
  CLOUD_IAM_GROUP
  CLOUD_IAM_GROUP_USER
  CLOUD_IAM_GROUP_SERVICE_ACCOUNT],
 :etag string,
 :sqlserverUserDetails {:disabled boolean, :serverRoles [string]},
 :host string,
 :project string,
 :kind string,
 :dualPasswordType
 [DUAL_PASSWORD_TYPE_UNSPECIFIED
  NO_MODIFY_DUAL_PASSWORD
  NO_DUAL_PASSWORD
  DUAL_PASSWORD]}

optional:
host <string> Optional. Host of the user in the instance.
name <string> Name of the user in the instance."
  ([project instance User] (users-update project instance User nil))
  ([project instance User optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://sqladmin.googleapis.com/v1/projects/{project}/instances/{instance}/users",
       :uri-template-args {:project project, :instance instance},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sqlservice.admin"],
       :body User})))

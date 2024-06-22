(ns happygapi2.bigtableadmin
  "Cloud Bigtable Admin API
Administer your Cloud Bigtable tables and instances.
See: https://cloud.google.com/bigtable/"
  (:require [happy.oauth2.client :as client]))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/bigtable

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn operations-projects-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/bigtable

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (operations-projects-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-instances-get
  "Gets information about an instance.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the requested instance. Values are of the form `projects/{project}/instances/{instance}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-instances-setIamPolicy
  "Sets the access control policy on an instance resource. Replaces any existing policy.
https://cloud.google.com/bigtable

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
     "https://bigtableadmin.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-instances-testIamPermissions
  "Returns permissions that the caller has on the specified instance resource.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-instances-create
  "Create an instance within a project. Note that exactly one of Cluster.serve_nodes and Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is enabled.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the project in which to create the new instance. Values are of the form `projects/{project}`.
CreateInstanceRequest:
{:parent string,
 :instanceId string,
 :instance
 {:name string,
  :displayName string,
  :state [STATE_NOT_KNOWN READY CREATING],
  :type [TYPE_UNSPECIFIED PRODUCTION DEVELOPMENT],
  :labels object,
  :createTime string,
  :satisfiesPzs boolean,
  :satisfiesPzi boolean},
 :clusters object}"
  [parent CreateInstanceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+parent}/instances",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body CreateInstanceRequest}))

(defn projects-instances-update
  "Updates an instance within a project. This method updates only the display name and type for an Instance. To update other Instance properties, such as labels, use PartialUpdateInstance.
https://cloud.google.com/bigtable

name <string> The unique name of the instance. Values are of the form `projects/{project}/instances/a-z+[a-z0-9]`.
Instance:
{:name string,
 :displayName string,
 :state [STATE_NOT_KNOWN READY CREATING],
 :type [TYPE_UNSPECIFIED PRODUCTION DEVELOPMENT],
 :labels object,
 :createTime string,
 :satisfiesPzs boolean,
 :satisfiesPzi boolean}"
  [name Instance]
  (client/api-request
    {:method "PUT",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Instance}))

(defn projects-instances-delete
  "Delete an instance from a project.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the instance to be deleted. Values are of the form `projects/{project}/instances/{instance}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-instances-getIamPolicy
  "Gets the access control policy for an instance resource. Returns an empty policy if an instance exists but does not have a policy set.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-instances-list
  "Lists information about instances in a project.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the project for which a list of instances is requested. Values are of the form `projects/{project}`."
  ([parent] (projects-instances-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/instances",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-instances-partialUpdateInstance
  "Partially updates an instance within a project. This method can modify all fields of an Instance and is the preferred way to update an Instance.
https://cloud.google.com/bigtable

name <string> The unique name of the instance. Values are of the form `projects/{project}/instances/a-z+[a-z0-9]`.
Instance:
{:name string,
 :displayName string,
 :state [STATE_NOT_KNOWN READY CREATING],
 :type [TYPE_UNSPECIFIED PRODUCTION DEVELOPMENT],
 :labels object,
 :createTime string,
 :satisfiesPzs boolean,
 :satisfiesPzi boolean}

optional:
updateMask <string> Required. The subset of Instance fields which should be replaced. Must be explicitly set."
  ([name Instance]
    (projects-instances-partialUpdateInstance name Instance nil))
  ([name Instance optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Instance})))

(defn projects-instances-clusters-create
  "Creates a cluster within an instance. Note that exactly one of Cluster.serve_nodes and Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is enabled.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the instance in which to create the new cluster. Values are of the form `projects/{project}/instances/{instance}`.
Cluster:
{:name string,
 :location string,
 :state [STATE_NOT_KNOWN READY CREATING RESIZING DISABLED],
 :serveNodes integer,
 :clusterConfig
 {:clusterAutoscalingConfig
  {:autoscalingLimits {:minServeNodes integer, :maxServeNodes integer},
   :autoscalingTargets
   {:cpuUtilizationPercent integer,
    :storageUtilizationGibPerNode integer}}},
 :defaultStorageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
 :encryptionConfig {:kmsKeyName string}}

optional:
clusterId <string> Required. The ID to be used when referring to the new cluster within its instance, e.g., just `mycluster` rather than `projects/myproject/instances/myinstance/clusters/mycluster`."
  ([parent Cluster]
    (projects-instances-clusters-create parent Cluster nil))
  ([parent Cluster optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-instances-clusters-get
  "Gets information about a cluster.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the requested cluster. Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-instances-clusters-list
  "Lists information about clusters in an instance.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the instance for which a list of clusters is requested. Values are of the form `projects/{project}/instances/{instance}`. Use `{instance} = '-'` to list Clusters for all Instances in a project, e.g., `projects/myproject/instances/-`."
  ([parent] (projects-instances-clusters-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/clusters",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-instances-clusters-update
  "Updates a cluster within an instance. Note that UpdateCluster does not support updating cluster_config.cluster_autoscaling_config. In order to update it, you must use PartialUpdateCluster.
https://cloud.google.com/bigtable

name <string> The unique name of the cluster. Values are of the form `projects/{project}/instances/{instance}/clusters/a-z*`.
Cluster:
{:name string,
 :location string,
 :state [STATE_NOT_KNOWN READY CREATING RESIZING DISABLED],
 :serveNodes integer,
 :clusterConfig
 {:clusterAutoscalingConfig
  {:autoscalingLimits {:minServeNodes integer, :maxServeNodes integer},
   :autoscalingTargets
   {:cpuUtilizationPercent integer,
    :storageUtilizationGibPerNode integer}}},
 :defaultStorageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
 :encryptionConfig {:kmsKeyName string}}"
  [name Cluster]
  (client/api-request
    {:method "PUT",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body Cluster}))

(defn projects-instances-clusters-partialUpdateCluster
  "Partially updates a cluster within a project. This method is the preferred way to update a Cluster. To enable and update autoscaling, set cluster_config.cluster_autoscaling_config. When autoscaling is enabled, serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to it are ignored. Note that an update cannot simultaneously set serve_nodes to non-zero and cluster_config.cluster_autoscaling_config to non-empty, and also specify both in the update_mask. To disable autoscaling, clear cluster_config.cluster_autoscaling_config, and explicitly set a serve_node count via the update_mask.
https://cloud.google.com/bigtable

name <string> The unique name of the cluster. Values are of the form `projects/{project}/instances/{instance}/clusters/a-z*`.
Cluster:
{:name string,
 :location string,
 :state [STATE_NOT_KNOWN READY CREATING RESIZING DISABLED],
 :serveNodes integer,
 :clusterConfig
 {:clusterAutoscalingConfig
  {:autoscalingLimits {:minServeNodes integer, :maxServeNodes integer},
   :autoscalingTargets
   {:cpuUtilizationPercent integer,
    :storageUtilizationGibPerNode integer}}},
 :defaultStorageType [STORAGE_TYPE_UNSPECIFIED SSD HDD],
 :encryptionConfig {:kmsKeyName string}}

optional:
updateMask <string> Required. The subset of Cluster fields which should be replaced."
  ([name Cluster]
    (projects-instances-clusters-partialUpdateCluster
      name
      Cluster
      nil))
  ([name Cluster optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Cluster})))

(defn projects-instances-clusters-delete
  "Deletes a cluster from an instance.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the cluster to be deleted. Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-instances-clusters-hotTablets-list
  "Lists hot tablets in a cluster, within the time range provided. Hot tablets are ordered based on CPU usage.
https://cloud.google.com/bigtable

parent <string> Required. The cluster name to list hot tablets. Value is in the following form: `projects/{project}/instances/{instance}/clusters/{cluster}`.

optional:
startTime <string> The start time to list hot tablets. The hot tablets in the response will have start times between the requested start time and end time. Start time defaults to Now if it is unset, and end time defaults to Now - 24 hours if it is unset. The start time should be less than the end time, and the maximum allowed time range between start time and end time is 48 hours. Start time and end time should have values between Now and Now - 14 days.
endTime <string> The end time to list hot tablets.
pageSize <integer> Maximum number of results per page. A page_size that is empty or zero lets the server choose the number of items to return. A page_size which is strictly positive will return at most that many items. A negative page_size will cause an error. Following the first request, subsequent paginated calls do not need a page_size field. If a page_size is set in subsequent calls, it must match the page_size given in the first request."
  ([parent] (projects-instances-clusters-hotTablets-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/hotTablets",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instances-clusters-backups-get
  "Gets metadata on a pending or completed Cloud Bigtable Backup.
https://cloud.google.com/bigtable

name <string> Required. Name of the backup. Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-instances-clusters-backups-copy
  "Copy a Cloud Bigtable backup to a new backup in the destination cluster located in the destination instance and project.
https://cloud.google.com/bigtable

parent <string> Required. The name of the destination cluster that will contain the backup copy. The cluster must already exists. Values are of the form: `projects/{project}/instances/{instance}/clusters/{cluster}`.
CopyBackupRequest:
{:backupId string, :sourceBackup string, :expireTime string}"
  [parent CopyBackupRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+parent}/backups:copy",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body CopyBackupRequest}))

(defn projects-instances-clusters-backups-setIamPolicy
  "Sets the access control policy on a Bigtable resource. Replaces any existing policy.
https://cloud.google.com/bigtable

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
     "https://bigtableadmin.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-instances-clusters-backups-patch
  "Updates a pending or completed Cloud Bigtable Backup.
https://cloud.google.com/bigtable

name <string> A globally unique identifier for the backup which cannot be changed. Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}/ backups/_a-zA-Z0-9*` The final segment of the name must be between 1 and 50 characters in length. The backup is stored in the cluster identified by the prefix of the backup name of the form `projects/{project}/instances/{instance}/clusters/{cluster}`.
Backup:
{:sourceBackup string,
 :encryptionInfo
 {:encryptionType
  [ENCRYPTION_TYPE_UNSPECIFIED
   GOOGLE_DEFAULT_ENCRYPTION
   CUSTOMER_MANAGED_ENCRYPTION],
  :encryptionStatus
  {:code integer, :message string, :details [object]},
  :kmsKeyVersion string},
 :startTime string,
 :name string,
 :sizeBytes string,
 :endTime string,
 :state [STATE_UNSPECIFIED CREATING READY],
 :sourceTable string,
 :expireTime string}

optional:
updateMask <string> Required. A mask specifying which fields (e.g. `expire_time`) in the Backup resource should be updated. This mask is relative to the Backup resource, not to the request message. The field mask must always be specified; this prevents any future fields from being erased accidentally by clients that do not know about them."
  ([name Backup]
    (projects-instances-clusters-backups-patch name Backup nil))
  ([name Backup optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-instances-clusters-backups-testIamPermissions
  "Returns permissions that the caller has on the specified Bigtable resource.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-instances-clusters-backups-create
  "Starts creating a new Cloud Bigtable Backup. The returned backup long-running operation can be used to track creation of the backup. The metadata field type is CreateBackupMetadata. The response field type is Backup, if successful. Cancelling the returned operation will stop the creation and delete the backup.
https://cloud.google.com/bigtable

parent <string> Required. This must be one of the clusters in the instance in which this table is located. The backup will be stored in this cluster. Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`.
Backup:
{:sourceBackup string,
 :encryptionInfo
 {:encryptionType
  [ENCRYPTION_TYPE_UNSPECIFIED
   GOOGLE_DEFAULT_ENCRYPTION
   CUSTOMER_MANAGED_ENCRYPTION],
  :encryptionStatus
  {:code integer, :message string, :details [object]},
  :kmsKeyVersion string},
 :startTime string,
 :name string,
 :sizeBytes string,
 :endTime string,
 :state [STATE_UNSPECIFIED CREATING READY],
 :sourceTable string,
 :expireTime string}

optional:
backupId <string> Required. The id of the backup to be created. The `backup_id` along with the parent `parent` are combined as {parent}/backups/{backup_id} to create the full backup name, of the form: `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup_id}`. This string must be between 1 and 50 characters in length and match the regex _a-zA-Z0-9*."
  ([parent Backup]
    (projects-instances-clusters-backups-create parent Backup nil))
  ([parent Backup optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Backup})))

(defn projects-instances-clusters-backups-delete
  "Deletes a pending or completed Cloud Bigtable backup.
https://cloud.google.com/bigtable

name <string> Required. Name of the backup to delete. Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-instances-clusters-backups-getIamPolicy
  "Gets the access control policy for a Bigtable resource. Returns an empty policy if the resource exists but does not have a policy set.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-instances-clusters-backups-list
  "Lists Cloud Bigtable backups. Returns both completed and pending backups.
https://cloud.google.com/bigtable

parent <string> Required. The cluster to list backups from. Values are of the form `projects/{project}/instances/{instance}/clusters/{cluster}`. Use `{cluster} = '-'` to list backups for all clusters in an instance, e.g., `projects/{project}/instances/{instance}/clusters/-`.

optional:
filter <string> A filter expression that filters backups listed in the response. The expression must specify the field name, a comparison operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The comparison operator must be <, >, <=, >=, !=, =, or :. Colon ':' represents a HAS operator which is roughly synonymous with equality. Filter rules are case insensitive. The fields eligible for filtering are: * `name` * `source_table` * `state` * `start_time` (and values are of the format YYYY-MM-DDTHH:MM:SSZ) * `end_time` (and values are of the format YYYY-MM-DDTHH:MM:SSZ) * `expire_time` (and values are of the format YYYY-MM-DDTHH:MM:SSZ) * `size_bytes` To filter on multiple expressions, provide each separate expression within parentheses. By default, each expression is an AND expression. However, you can include AND, OR, and NOT expressions explicitly. Some examples of using filters are: * `name:\"exact\"` --> The backup's name is the string \"exact\". * `name:howl` --> The backup's name contains the string \"howl\". * `source_table:prod` --> The source_table's name contains the string \"prod\". * `state:CREATING` --> The backup is pending creation. * `state:READY` --> The backup is fully created and ready for use. * `(name:howl) AND (start_time < \\\"2018-03-28T14:50:00Z\\\")` --> The backup name contains the string \"howl\" and start_time of the backup is before 2018-03-28T14:50:00Z. * `size_bytes > 10000000000` --> The backup's size is greater than 10GB
orderBy <string> An expression for specifying the sort order of the results of the request. The string value should specify one or more fields in Backup. The full syntax is described at https://aip.dev/132#ordering. Fields supported are: * name * source_table * expire_time * start_time * end_time * size_bytes * state For example, \"start_time\". The default sorting order is ascending. To specify descending order for the field, a suffix \" desc\" should be appended to the field name. For example, \"start_time desc\". Redundant space characters in the syntax are insigificant. If order_by is empty, results will be sorted by `start_time` in descending order starting from the most recently created backup.
pageSize <integer> Number of backups to be returned in the response. If 0 or less, defaults to the server's maximum allowed page size."
  ([parent] (projects-instances-clusters-backups-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/backups",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instances-appProfiles-create
  "Creates an app profile within an instance.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the instance in which to create the new app profile. Values are of the form `projects/{project}/instances/{instance}`.
AppProfile:
{:name string,
 :etag string,
 :description string,
 :multiClusterRoutingUseAny {:clusterIds [string]},
 :singleClusterRouting
 {:clusterId string, :allowTransactionalWrites boolean},
 :priority
 [PRIORITY_UNSPECIFIED PRIORITY_LOW PRIORITY_MEDIUM PRIORITY_HIGH],
 :standardIsolation
 {:priority
  [PRIORITY_UNSPECIFIED PRIORITY_LOW PRIORITY_MEDIUM PRIORITY_HIGH]},
 :dataBoostIsolationReadOnly
 {:computeBillingOwner [COMPUTE_BILLING_OWNER_UNSPECIFIED HOST_PAYS]}}

optional:
appProfileId <string> Required. The ID to be used when referring to the new app profile within its instance, e.g., just `myprofile` rather than `projects/myproject/instances/myinstance/appProfiles/myprofile`.
ignoreWarnings <boolean> If true, ignore safety checks when creating the app profile."
  ([parent AppProfile]
    (projects-instances-appProfiles-create parent AppProfile nil))
  ([parent AppProfile optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/appProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body AppProfile})))

(defn projects-instances-appProfiles-get
  "Gets information about an app profile.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the requested app profile. Values are of the form `projects/{project}/instances/{instance}/appProfiles/{app_profile}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.cluster"
      "https://www.googleapis.com/auth/bigtable.admin.instance"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
      "https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-instances-appProfiles-list
  "Lists information about app profiles in an instance.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the instance for which a list of app profiles is requested. Values are of the form `projects/{project}/instances/{instance}`. Use `{instance} = '-'` to list AppProfiles for all Instances in a project, e.g., `projects/myproject/instances/-`.

optional:
pageSize <integer> Maximum number of results per page. A page_size of zero lets the server choose the number of items to return. A page_size which is strictly positive will return at most that many items. A negative page_size will cause an error. Following the first request, subsequent paginated calls are not required to pass a page_size. If a page_size is set in subsequent calls, it must match the page_size given in the first request."
  ([parent] (projects-instances-appProfiles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/appProfiles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instances-appProfiles-patch
  "Updates an app profile within an instance.
https://cloud.google.com/bigtable

name <string> The unique name of the app profile. Values are of the form `projects/{project}/instances/{instance}/appProfiles/_a-zA-Z0-9*`.
AppProfile:
{:name string,
 :etag string,
 :description string,
 :multiClusterRoutingUseAny {:clusterIds [string]},
 :singleClusterRouting
 {:clusterId string, :allowTransactionalWrites boolean},
 :priority
 [PRIORITY_UNSPECIFIED PRIORITY_LOW PRIORITY_MEDIUM PRIORITY_HIGH],
 :standardIsolation
 {:priority
  [PRIORITY_UNSPECIFIED PRIORITY_LOW PRIORITY_MEDIUM PRIORITY_HIGH]},
 :dataBoostIsolationReadOnly
 {:computeBillingOwner [COMPUTE_BILLING_OWNER_UNSPECIFIED HOST_PAYS]}}

optional:
updateMask <string> Required. The subset of app profile fields which should be replaced. If unset, all fields will be replaced.
ignoreWarnings <boolean> If true, ignore safety checks when updating the app profile."
  ([name AppProfile]
    (projects-instances-appProfiles-patch name AppProfile nil))
  ([name AppProfile optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body AppProfile})))

(defn projects-instances-appProfiles-delete
  "Deletes an app profile from an instance.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the app profile to be deleted. Values are of the form `projects/{project}/instances/{instance}/appProfiles/{app_profile}`.

optional:
ignoreWarnings <boolean> Required. If true, ignore safety checks when deleting the app profile."
  ([name] (projects-instances-appProfiles-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instances-tables-get
  "Gets metadata information about the specified table.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the requested table. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.

optional:
view <string> The view to be applied to the returned table's fields. Defaults to `SCHEMA_VIEW` if unspecified."
  ([name] (projects-instances-tables-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-instances-tables-setIamPolicy
  "Sets the access control policy on a Bigtable resource. Replaces any existing policy.
https://cloud.google.com/bigtable

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
     "https://bigtableadmin.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-instances-tables-patch
  "Updates a specified table.
https://cloud.google.com/bigtable

name <string> The unique name of the table. Values are of the form `projects/{project}/instances/{instance}/tables/_a-zA-Z0-9*`. Views: `NAME_ONLY`, `SCHEMA_VIEW`, `REPLICATION_VIEW`, `STATS_VIEW`, `FULL`
Table:
{:restoreInfo
 {:sourceType [RESTORE_SOURCE_TYPE_UNSPECIFIED BACKUP],
  :backupInfo
  {:backup string,
   :startTime string,
   :endTime string,
   :sourceTable string,
   :sourceBackup string}},
 :columnFamilies object,
 :changeStreamConfig {:retentionPeriod string},
 :name string,
 :clusterStates object,
 :granularity [TIMESTAMP_GRANULARITY_UNSPECIFIED MILLIS],
 :automatedBackupPolicy {:retentionPeriod string, :frequency string},
 :deletionProtection boolean,
 :stats
 {:rowCount string,
  :averageColumnsPerRow number,
  :averageCellsPerColumn number,
  :logicalDataBytes string}}

optional:
updateMask <string> Required. The list of fields to update. A mask specifying which fields (e.g. `change_stream_config`) in the `table` field should be updated. This mask is relative to the `table` field, not to the request message. The wildcard (*) path is currently not supported. Currently UpdateTable is only supported for the following fields: * `change_stream_config` * `change_stream_config.retention_period` * `deletion_protection` If `column_families` is set in `update_mask`, it will return an UNIMPLEMENTED error."
  ([name Table] (projects-instances-tables-patch name Table nil))
  ([name Table optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body Table})))

(defn projects-instances-tables-testIamPermissions
  "Returns permissions that the caller has on the specified Bigtable resource.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-instances-tables-generateConsistencyToken
  "Generates a consistency token for a Table, which can be used in CheckConsistency to check whether mutations to the table that finished before this call started have been replicated. The tokens will be available for 90 days.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the Table for which to create a consistency token. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
GenerateConsistencyTokenRequest:
object"
  [name GenerateConsistencyTokenRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+name}:generateConsistencyToken",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GenerateConsistencyTokenRequest}))

(defn projects-instances-tables-restore
  "Create a new table by restoring from a completed backup. The returned table long-running operation can be used to track the progress of the operation, and to cancel it. The metadata field type is RestoreTableMetadata. The response type is Table, if successful.
https://cloud.google.com/bigtable

parent <string> Required. The name of the instance in which to create the restored table. Values are of the form `projects//instances/`.
RestoreTableRequest:
{:tableId string, :backup string}"
  [parent RestoreTableRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+parent}/tables:restore",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body RestoreTableRequest}))

(defn projects-instances-tables-create
  "Creates a new table in the specified instance. The table can be created with a full set of initial column families, specified in the request.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the instance in which to create the table. Values are of the form `projects/{project}/instances/{instance}`.
CreateTableRequest:
{:tableId string,
 :table
 {:restoreInfo
  {:sourceType [RESTORE_SOURCE_TYPE_UNSPECIFIED BACKUP],
   :backupInfo
   {:backup string,
    :startTime string,
    :endTime string,
    :sourceTable string,
    :sourceBackup string}},
  :columnFamilies object,
  :changeStreamConfig {:retentionPeriod string},
  :name string,
  :clusterStates object,
  :granularity [TIMESTAMP_GRANULARITY_UNSPECIFIED MILLIS],
  :automatedBackupPolicy {:retentionPeriod string, :frequency string},
  :deletionProtection boolean,
  :stats
  {:rowCount string,
   :averageColumnsPerRow number,
   :averageCellsPerColumn number,
   :logicalDataBytes string}},
 :initialSplits [{:key string}]}"
  [parent CreateTableRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+parent}/tables",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body CreateTableRequest}))

(defn projects-instances-tables-modifyColumnFamilies
  "Performs a series of column family modifications on the specified table. Either all or none of the modifications will occur before this method returns, but data requests received prior to that point may see a table where only some modifications have taken effect.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the table whose families should be modified. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
ModifyColumnFamiliesRequest:
{:modifications
 [{:id string,
   :create
   {:gcRule
    {:maxNumVersions integer,
     :maxAge string,
     :intersection {:rules [GcRule]},
     :union {:rules [GcRule]}},
    :stats
    {:averageColumnsPerRow number,
     :averageCellsPerColumn number,
     :logicalDataBytes string},
    :valueType
    {:bytesType {:encoding GoogleBigtableAdminV2TypeBytesEncoding},
     :int64Type {:encoding GoogleBigtableAdminV2TypeInt64Encoding},
     :aggregateType
     {:inputType Type,
      :stateType Type,
      :sum GoogleBigtableAdminV2TypeAggregateSum}}},
   :update
   {:gcRule
    {:maxNumVersions integer,
     :maxAge string,
     :intersection {:rules [GcRule]},
     :union {:rules [GcRule]}},
    :stats
    {:averageColumnsPerRow number,
     :averageCellsPerColumn number,
     :logicalDataBytes string},
    :valueType
    {:bytesType {:encoding GoogleBigtableAdminV2TypeBytesEncoding},
     :int64Type {:encoding GoogleBigtableAdminV2TypeInt64Encoding},
     :aggregateType
     {:inputType Type,
      :stateType Type,
      :sum GoogleBigtableAdminV2TypeAggregateSum}}},
   :drop boolean,
   :updateMask string}],
 :ignoreWarnings boolean}"
  [name ModifyColumnFamiliesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+name}:modifyColumnFamilies",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body ModifyColumnFamiliesRequest}))

(defn projects-instances-tables-delete
  "Permanently deletes a specified table and all of its data.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the table to be deleted. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-instances-tables-getIamPolicy
  "Gets the access control policy for a Bigtable resource. Returns an empty policy if the resource exists but does not have a policy set.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-instances-tables-undelete
  "Restores a specified table which was accidentally deleted.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the table to be restored. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
UndeleteTableRequest:
object"
  [name UndeleteTableRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+name}:undelete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body UndeleteTableRequest}))

(defn projects-instances-tables-dropRowRange
  "Permanently drop/delete a row range from a specified table. The request can specify whether to delete all rows in a table, or only those that match a particular prefix. Note that row key prefixes used here are treated as service data. For more information about how service data is handled, see the [Google Cloud Privacy Notice](https://cloud.google.com/terms/cloud-privacy-notice).
https://cloud.google.com/bigtable

name <string> Required. The unique name of the table on which to drop a range of rows. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
DropRowRangeRequest:
{:rowKeyPrefix string, :deleteAllDataFromTable boolean}"
  [name DropRowRangeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+name}:dropRowRange",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body DropRowRangeRequest}))

(defn projects-instances-tables-checkConsistency
  "Checks replication consistency based on a consistency token, that is, if replication has caught up based on the conditions specified in the token and the check request.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the Table for which to check replication consistency. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
CheckConsistencyRequest:
{:consistencyToken string,
 :standardReadRemoteWrites object,
 :dataBoostReadLocalWrites object}"
  [name CheckConsistencyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+name}:checkConsistency",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body CheckConsistencyRequest}))

(defn projects-instances-tables-list
  "Lists all tables served from a specified instance.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the instance for which tables should be listed. Values are of the form `projects/{project}/instances/{instance}`.

optional:
view <string> The view to be applied to the returned tables' fields. Only NAME_ONLY view (default), REPLICATION_VIEW and ENCRYPTION_VIEW are supported.
pageSize <integer> Maximum number of results per page. A page_size of zero lets the server choose the number of items to return. A page_size which is strictly positive will return at most that many items. A negative page_size will cause an error. Following the first request, subsequent paginated calls are not required to pass a page_size. If a page_size is set in subsequent calls, it must match the page_size given in the first request."
  ([parent] (projects-instances-tables-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/tables",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-instances-tables-authorizedViews-create
  "Creates a new AuthorizedView in a table.
https://cloud.google.com/bigtable

parent <string> Required. This is the name of the table the AuthorizedView belongs to. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.
AuthorizedView:
{:name string,
 :subsetView {:rowPrefixes [string], :familySubsets object},
 :etag string,
 :deletionProtection boolean}

optional:
authorizedViewId <string> Required. The id of the AuthorizedView to create. This AuthorizedView must not already exist. The `authorized_view_id` appended to `parent` forms the full AuthorizedView name of the form `projects/{project}/instances/{instance}/tables/{table}/authorizedView/{authorized_view}`."
  ([parent AuthorizedView]
    (projects-instances-tables-authorizedViews-create
      parent
      AuthorizedView
      nil))
  ([parent AuthorizedView optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/authorizedViews",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body AuthorizedView})))

(defn projects-instances-tables-authorizedViews-list
  "Lists all AuthorizedViews from a specific table.
https://cloud.google.com/bigtable

parent <string> Required. The unique name of the table for which AuthorizedViews should be listed. Values are of the form `projects/{project}/instances/{instance}/tables/{table}`.

optional:
pageSize <integer> Optional. Maximum number of results per page. A page_size of zero lets the server choose the number of items to return. A page_size which is strictly positive will return at most that many items. A negative page_size will cause an error. Following the first request, subsequent paginated calls are not required to pass a page_size. If a page_size is set in subsequent calls, it must match the page_size given in the first request.
view <string> Optional. The resource_view to be applied to the returned AuthorizedViews' fields. Default to NAME_ONLY."
  ([parent]
    (projects-instances-tables-authorizedViews-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+parent}/authorizedViews",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instances-tables-authorizedViews-get
  "Gets information from a specified AuthorizedView.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the requested AuthorizedView. Values are of the form `projects/{project}/instances/{instance}/tables/{table}/authorizedViews/{authorized_view}`.

optional:
view <string> Optional. The resource_view to be applied to the returned AuthorizedView's fields. Default to BASIC."
  ([name] (projects-instances-tables-authorizedViews-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instances-tables-authorizedViews-patch
  "Updates an AuthorizedView in a table.
https://cloud.google.com/bigtable

name <string> Identifier. The name of this AuthorizedView. Values are of the form `projects/{project}/instances/{instance}/tables/{table}/authorizedViews/{authorized_view}`
AuthorizedView:
{:name string,
 :subsetView {:rowPrefixes [string], :familySubsets object},
 :etag string,
 :deletionProtection boolean}

optional:
updateMask <string> Optional. The list of fields to update. A mask specifying which fields in the AuthorizedView resource should be updated. This mask is relative to the AuthorizedView resource, not to the request message. A field will be overwritten if it is in the mask. If empty, all fields set in the request will be overwritten. A special value `*` means to overwrite all fields (including fields not set in the request).
ignoreWarnings <boolean> Optional. If true, ignore the safety checks when updating the AuthorizedView."
  ([name AuthorizedView]
    (projects-instances-tables-authorizedViews-patch
      name
      AuthorizedView
      nil))
  ([name AuthorizedView optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"],
       :body AuthorizedView})))

(defn projects-instances-tables-authorizedViews-delete
  "Permanently deletes a specified AuthorizedView.
https://cloud.google.com/bigtable

name <string> Required. The unique name of the AuthorizedView to be deleted. Values are of the form `projects/{project}/instances/{instance}/tables/{table}/authorizedViews/{authorized_view}`.

optional:
etag <string> Optional. The current etag of the AuthorizedView. If an etag is provided and does not match the current etag of the AuthorizedView, deletion will be blocked and an ABORTED error will be returned."
  ([name] (projects-instances-tables-authorizedViews-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://bigtableadmin.googleapis.com/v2/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
        "https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-instances-tables-authorizedViews-getIamPolicy
  "Gets the access control policy for a Bigtable resource. Returns an empty policy if the resource exists but does not have a policy set.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-instances-tables-authorizedViews-setIamPolicy
  "Sets the access control policy on a Bigtable resource. Replaces any existing policy.
https://cloud.google.com/bigtable

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
     "https://bigtableadmin.googleapis.com/v2/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-instances-tables-authorizedViews-testIamPermissions
  "Returns permissions that the caller has on the specified Bigtable resource.
https://cloud.google.com/bigtable

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://bigtableadmin.googleapis.com/v2/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/bigtable.admin"
      "https://www.googleapis.com/auth/bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-bigtable.admin"
      "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
      "https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/bigtable

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://bigtableadmin.googleapis.com/v2/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/bigtable.admin"
        "https://www.googleapis.com/auth/bigtable.admin.cluster"
        "https://www.googleapis.com/auth/bigtable.admin.instance"
        "https://www.googleapis.com/auth/cloud-bigtable.admin"
        "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
        "https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

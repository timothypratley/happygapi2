(ns happygapi2.deploymentmanager
  "Cloud Deployment Manager V2 API
The Google Cloud Deployment Manager v2 API provides services for configuring, deploying, and viewing Google Cloud services and APIs via templates which specify deployments of Cloud resources.
See: https://cloud.google.com/deployment-manager/docs"
  (:require [happy.oauth2.client :as client]))

(defn deployments-cancelPreview
  "Cancels and removes the preview currently associated with the deployment.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.
DeploymentsCancelPreviewRequest:
{:fingerprint string}"
  [project deployment DeploymentsCancelPreviewRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/cancelPreview",
     :uri-template-args {:project project, :deployment deployment},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/ndev.cloudman"],
     :body DeploymentsCancelPreviewRequest}))

(defn deployments-get
  "Gets information about a specific deployment.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request."
  [project deployment]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}",
     :uri-template-args {:project project, :deployment deployment},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/ndev.cloudman"
      "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}))

(defn deployments-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy.
https://cloud.google.com/deployment-manager/docs

project <string> Project ID for this request.
resource <string> Name or id of the resource for this request.
GlobalSetPolicyRequest:
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
 :bindings
 [{:role string,
   :members [string],
   :condition
   {:expression string,
    :title string,
    :description string,
    :location string}}],
 :etag string}"
  [project resource GlobalSetPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{resource}/setIamPolicy",
     :uri-template-args {:project project, :resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/ndev.cloudman"],
     :body GlobalSetPolicyRequest}))

(defn deployments-insert
  "Creates a deployment and all of the resources described by the deployment manifest.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
Deployment:
{:description string,
 :labels [{:key string, :value string}],
 :name string,
 :operation
 {:description string,
  :creationTimestamp string,
  :startTime string,
  :zone string,
  :name string,
  :targetId string,
  :endTime string,
  :instancesBulkInsertOperationMetadata {:perLocationStatus object},
  :statusMessage string,
  :selfLink string,
  :warnings
  [{:code
    [DEPRECATED_RESOURCE_USED
     NO_RESULTS_ON_PAGE
     UNREACHABLE
     NEXT_HOP_ADDRESS_NOT_ASSIGNED
     NEXT_HOP_INSTANCE_NOT_FOUND
     NEXT_HOP_INSTANCE_NOT_ON_NETWORK
     NEXT_HOP_CANNOT_IP_FORWARD
     NEXT_HOP_NOT_RUNNING
     INJECTED_KERNELS_DEPRECATED
     REQUIRED_TOS_AGREEMENT
     DISK_SIZE_LARGER_THAN_IMAGE_SIZE
     RESOURCE_NOT_DELETED
     SINGLE_INSTANCE_PROPERTY_TEMPLATE
     NOT_CRITICAL_ERROR
     CLEANUP_FAILED
     FIELD_VALUE_OVERRIDEN
     RESOURCE_IN_USE_BY_OTHER_RESOURCE_WARNING
     MISSING_TYPE_DEPENDENCY
     EXTERNAL_API_WARNING
     SCHEMA_VALIDATION_IGNORED
     UNDECLARED_PROPERTIES
     EXPERIMENTAL_TYPE_USED
     DEPRECATED_TYPE_USED
     PARTIAL_SUCCESS
     LARGE_DEPLOYMENT_WARNING
     NEXT_HOP_INSTANCE_HAS_NO_IPV6_INTERFACE
     INVALID_HEALTH_CHECK_FOR_DYNAMIC_WIEGHTED_LB
     LIST_OVERHEAD_QUOTA_EXCEED],
    :message string,
    :data [{:key string, :value string}]}],
  :clientOperationId string,
  :region string,
  :httpErrorStatusCode integer,
  :operationGroupId string,
  :status [PENDING RUNNING DONE],
  :targetLink string,
  :id string,
  :insertTime string,
  :kind string,
  :setCommonInstanceMetadataOperationMetadata
  {:clientOperationId string, :perLocationOperations object},
  :error {:errors [{:code string, :location string, :message string}]},
  :progress integer,
  :user string,
  :httpErrorMessage string,
  :operationType string},
 :selfLink string,
 :update
 {:manifest string,
  :labels [{:key string, :value string}],
  :description string},
 :manifest string,
 :updateTime string,
 :id string,
 :insertTime string,
 :target
 {:config {:content string},
  :imports [{:name string, :content string}]},
 :fingerprint string}

optional:
preview <boolean> If set to true, creates a deployment and creates \"shell\" resources but does not actually instantiate these resources. This allows you to preview what your deployment looks like. After previewing a deployment, you can deploy your resources by making a request with the `update()` method or you can use the `cancelPreview()` method to cancel the preview altogether. Note that the deployment will still exist after you cancel the preview and you must separately delete this deployment if you want to remove it.
createPolicy <string> Sets the policy to use for creating new resources."
  ([project Deployment] (deployments-insert project Deployment nil))
  ([project Deployment optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.cloudman"],
       :body Deployment})))

(defn deployments-patch
  "Patches a deployment and all of the resources described by the deployment manifest.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.
Deployment:
{:description string,
 :labels [{:key string, :value string}],
 :name string,
 :operation
 {:description string,
  :creationTimestamp string,
  :startTime string,
  :zone string,
  :name string,
  :targetId string,
  :endTime string,
  :instancesBulkInsertOperationMetadata {:perLocationStatus object},
  :statusMessage string,
  :selfLink string,
  :warnings
  [{:code
    [DEPRECATED_RESOURCE_USED
     NO_RESULTS_ON_PAGE
     UNREACHABLE
     NEXT_HOP_ADDRESS_NOT_ASSIGNED
     NEXT_HOP_INSTANCE_NOT_FOUND
     NEXT_HOP_INSTANCE_NOT_ON_NETWORK
     NEXT_HOP_CANNOT_IP_FORWARD
     NEXT_HOP_NOT_RUNNING
     INJECTED_KERNELS_DEPRECATED
     REQUIRED_TOS_AGREEMENT
     DISK_SIZE_LARGER_THAN_IMAGE_SIZE
     RESOURCE_NOT_DELETED
     SINGLE_INSTANCE_PROPERTY_TEMPLATE
     NOT_CRITICAL_ERROR
     CLEANUP_FAILED
     FIELD_VALUE_OVERRIDEN
     RESOURCE_IN_USE_BY_OTHER_RESOURCE_WARNING
     MISSING_TYPE_DEPENDENCY
     EXTERNAL_API_WARNING
     SCHEMA_VALIDATION_IGNORED
     UNDECLARED_PROPERTIES
     EXPERIMENTAL_TYPE_USED
     DEPRECATED_TYPE_USED
     PARTIAL_SUCCESS
     LARGE_DEPLOYMENT_WARNING
     NEXT_HOP_INSTANCE_HAS_NO_IPV6_INTERFACE
     INVALID_HEALTH_CHECK_FOR_DYNAMIC_WIEGHTED_LB
     LIST_OVERHEAD_QUOTA_EXCEED],
    :message string,
    :data [{:key string, :value string}]}],
  :clientOperationId string,
  :region string,
  :httpErrorStatusCode integer,
  :operationGroupId string,
  :status [PENDING RUNNING DONE],
  :targetLink string,
  :id string,
  :insertTime string,
  :kind string,
  :setCommonInstanceMetadataOperationMetadata
  {:clientOperationId string, :perLocationOperations object},
  :error {:errors [{:code string, :location string, :message string}]},
  :progress integer,
  :user string,
  :httpErrorMessage string,
  :operationType string},
 :selfLink string,
 :update
 {:manifest string,
  :labels [{:key string, :value string}],
  :description string},
 :manifest string,
 :updateTime string,
 :id string,
 :insertTime string,
 :target
 {:config {:content string},
  :imports [{:name string, :content string}]},
 :fingerprint string}

optional:
createPolicy <string> Sets the policy to use for creating new resources.
deletePolicy <string> Sets the policy to use for deleting resources.
preview <boolean> If set to true, updates the deployment and creates and updates the \"shell\" resources but does not actually alter or instantiate these resources. This allows you to preview what your deployment will look like. You can use this intent to preview how an update would affect your deployment. You must provide a `target.config` with a configuration if this is set to true. After previewing a deployment, you can deploy your resources by making a request with the `update()` or you can `cancelPreview()` to remove the preview altogether. Note that the deployment will still exist after you cancel the preview and you must separately delete this deployment if you want to remove it."
  ([project deployment Deployment]
    (deployments-patch project deployment Deployment nil))
  ([project deployment Deployment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}",
       :uri-template-args {:project project, :deployment deployment},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.cloudman"],
       :body Deployment})))

(defn deployments-testIamPermissions
  "Returns permissions that a caller has on the specified resource.
https://cloud.google.com/deployment-manager/docs

project <string> Project ID for this request.
resource <string> Name or id of the resource for this request.
TestPermissionsRequest:
{:permissions [string]}"
  [project resource TestPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{resource}/testIamPermissions",
     :uri-template-args {:project project, :resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/ndev.cloudman"],
     :body TestPermissionsRequest}))

(defn deployments-update
  "Updates a deployment and all of the resources described by the deployment manifest.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.
Deployment:
{:description string,
 :labels [{:key string, :value string}],
 :name string,
 :operation
 {:description string,
  :creationTimestamp string,
  :startTime string,
  :zone string,
  :name string,
  :targetId string,
  :endTime string,
  :instancesBulkInsertOperationMetadata {:perLocationStatus object},
  :statusMessage string,
  :selfLink string,
  :warnings
  [{:code
    [DEPRECATED_RESOURCE_USED
     NO_RESULTS_ON_PAGE
     UNREACHABLE
     NEXT_HOP_ADDRESS_NOT_ASSIGNED
     NEXT_HOP_INSTANCE_NOT_FOUND
     NEXT_HOP_INSTANCE_NOT_ON_NETWORK
     NEXT_HOP_CANNOT_IP_FORWARD
     NEXT_HOP_NOT_RUNNING
     INJECTED_KERNELS_DEPRECATED
     REQUIRED_TOS_AGREEMENT
     DISK_SIZE_LARGER_THAN_IMAGE_SIZE
     RESOURCE_NOT_DELETED
     SINGLE_INSTANCE_PROPERTY_TEMPLATE
     NOT_CRITICAL_ERROR
     CLEANUP_FAILED
     FIELD_VALUE_OVERRIDEN
     RESOURCE_IN_USE_BY_OTHER_RESOURCE_WARNING
     MISSING_TYPE_DEPENDENCY
     EXTERNAL_API_WARNING
     SCHEMA_VALIDATION_IGNORED
     UNDECLARED_PROPERTIES
     EXPERIMENTAL_TYPE_USED
     DEPRECATED_TYPE_USED
     PARTIAL_SUCCESS
     LARGE_DEPLOYMENT_WARNING
     NEXT_HOP_INSTANCE_HAS_NO_IPV6_INTERFACE
     INVALID_HEALTH_CHECK_FOR_DYNAMIC_WIEGHTED_LB
     LIST_OVERHEAD_QUOTA_EXCEED],
    :message string,
    :data [{:key string, :value string}]}],
  :clientOperationId string,
  :region string,
  :httpErrorStatusCode integer,
  :operationGroupId string,
  :status [PENDING RUNNING DONE],
  :targetLink string,
  :id string,
  :insertTime string,
  :kind string,
  :setCommonInstanceMetadataOperationMetadata
  {:clientOperationId string, :perLocationOperations object},
  :error {:errors [{:code string, :location string, :message string}]},
  :progress integer,
  :user string,
  :httpErrorMessage string,
  :operationType string},
 :selfLink string,
 :update
 {:manifest string,
  :labels [{:key string, :value string}],
  :description string},
 :manifest string,
 :updateTime string,
 :id string,
 :insertTime string,
 :target
 {:config {:content string},
  :imports [{:name string, :content string}]},
 :fingerprint string}

optional:
createPolicy <string> Sets the policy to use for creating new resources.
deletePolicy <string> Sets the policy to use for deleting resources.
preview <boolean> If set to true, updates the deployment and creates and updates the \"shell\" resources but does not actually alter or instantiate these resources. This allows you to preview what your deployment will look like. You can use this intent to preview how an update would affect your deployment. You must provide a `target.config` with a configuration if this is set to true. After previewing a deployment, you can deploy your resources by making a request with the `update()` or you can `cancelPreview()` to remove the preview altogether. Note that the deployment will still exist after you cancel the preview and you must separately delete this deployment if you want to remove it."
  ([project deployment Deployment]
    (deployments-update project deployment Deployment nil))
  ([project deployment Deployment optional]
    (client/api-request
      {:method "PUT",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}",
       :uri-template-args {:project project, :deployment deployment},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.cloudman"],
       :body Deployment})))

(defn deployments-delete
  "Deletes a deployment and all of the resources in the deployment.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.

optional:
deletePolicy <string> Sets the policy to use for deleting resources."
  ([project deployment] (deployments-delete project deployment nil))
  ([project deployment optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}",
       :uri-template-args {:project project, :deployment deployment},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.cloudman"]})))

(defn deployments-getIamPolicy
  "Gets the access control policy for a resource. May be empty if no such policy or resource exists.
https://cloud.google.com/deployment-manager/docs

project <string> Project ID for this request.
resource <string> Name or id of the resource for this request.

optional:
optionsRequestedPolicyVersion <integer> Requested IAM Policy version."
  ([project resource] (deployments-getIamPolicy project resource nil))
  ([project resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{resource}/getIamPolicy",
       :uri-template-args {:project project, :resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/ndev.cloudman"]})))

(defn deployments-stop
  "Stops an ongoing operation. This does not roll back any work that has already been completed, but prevents any new work from being started.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.
DeploymentsStopRequest:
{:fingerprint string}"
  [project deployment DeploymentsStopRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/stop",
     :uri-template-args {:project project, :deployment deployment},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/ndev.cloudman"],
     :body DeploymentsStopRequest}))

(defn deployments-list
  "Lists all deployments for a given project.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.

optional:
maxResults <integer> The maximum number of results per page that should be returned. If the number of available results is larger than `maxResults`, Compute Engine returns a `nextPageToken` that can be used to get the next page of results in subsequent list requests. Acceptable values are `0` to `500`, inclusive. (Default: `500`)
filter <string> A filter expression that filters resources listed in the response. Most Compute resources support two types of filter expressions: expressions that support regular expressions and expressions that follow API improvement proposal AIP-160. These two types of filter expressions cannot be mixed in one request. If you want to use AIP-160, your expression must specify the field name, an operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The operator must be either `=`, `!=`, `>`, `<`, `<=`, `>=` or `:`. For example, if you are filtering Compute Engine instances, you can exclude instances named `example-instance` by specifying `name != example-instance`. The `:*` comparison can be used to test whether a key has been defined. For example, to find all objects with `owner` label use: ``` labels.owner:* ``` You can also filter nested fields. For example, you could specify `scheduling.automaticRestart = false` to include instances only if they are not scheduled for automatic restarts. You can use filtering on nested fields to filter based on resource labels. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (scheduling.automaticRestart = true) (cpuPlatform = \"Intel Skylake\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (cpuPlatform = \"Intel Skylake\") OR (cpuPlatform = \"Intel Broadwell\") AND (scheduling.automaticRestart = true) ``` If you want to use a regular expression, use the `eq` (equal) or `ne` (not equal) operator against a single un-parenthesized expression with or without quotes or against multiple parenthesized expressions. Examples: `fieldname eq unquoted literal` `fieldname eq 'single quoted literal'` `fieldname eq \"double quoted literal\"` `(fieldname1 eq literal) (fieldname2 ne \"literal\")` The literal value is interpreted as a regular expression using Google RE2 library syntax. The literal value must match the entire field. For example, to filter for instances that do not end with name \"instance\", you would use `name ne .*instance`. You cannot combine constraints on multiple fields using regular expressions.
orderBy <string> Sorts list results by a certain order. By default, results are returned in alphanumerical order based on the resource name. You can also sort results in descending order based on the creation timestamp using `orderBy=\"creationTimestamp desc\"`. This sorts results based on the `creationTimestamp` field in reverse chronological order (newest result first). Use this to sort resources like operations so that the newest operation is returned first. Currently, only sorting by `name` or `creationTimestamp desc` is supported."
  ([project] (deployments-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.cloudman"
        "https://www.googleapis.com/auth/ndev.cloudman.readonly"]})))

(defn manifests-get
  "Gets information about a specific manifest.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.
manifest <string> The name of the manifest for this request."
  [project deployment manifest]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/manifests/{manifest}",
     :uri-template-args
     {:project project, :deployment deployment, :manifest manifest},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/ndev.cloudman"
      "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}))

(defn manifests-list
  "Lists all manifests for a given deployment.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.

optional:
maxResults <integer> The maximum number of results per page that should be returned. If the number of available results is larger than `maxResults`, Compute Engine returns a `nextPageToken` that can be used to get the next page of results in subsequent list requests. Acceptable values are `0` to `500`, inclusive. (Default: `500`)
filter <string> A filter expression that filters resources listed in the response. Most Compute resources support two types of filter expressions: expressions that support regular expressions and expressions that follow API improvement proposal AIP-160. These two types of filter expressions cannot be mixed in one request. If you want to use AIP-160, your expression must specify the field name, an operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The operator must be either `=`, `!=`, `>`, `<`, `<=`, `>=` or `:`. For example, if you are filtering Compute Engine instances, you can exclude instances named `example-instance` by specifying `name != example-instance`. The `:*` comparison can be used to test whether a key has been defined. For example, to find all objects with `owner` label use: ``` labels.owner:* ``` You can also filter nested fields. For example, you could specify `scheduling.automaticRestart = false` to include instances only if they are not scheduled for automatic restarts. You can use filtering on nested fields to filter based on resource labels. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (scheduling.automaticRestart = true) (cpuPlatform = \"Intel Skylake\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (cpuPlatform = \"Intel Skylake\") OR (cpuPlatform = \"Intel Broadwell\") AND (scheduling.automaticRestart = true) ``` If you want to use a regular expression, use the `eq` (equal) or `ne` (not equal) operator against a single un-parenthesized expression with or without quotes or against multiple parenthesized expressions. Examples: `fieldname eq unquoted literal` `fieldname eq 'single quoted literal'` `fieldname eq \"double quoted literal\"` `(fieldname1 eq literal) (fieldname2 ne \"literal\")` The literal value is interpreted as a regular expression using Google RE2 library syntax. The literal value must match the entire field. For example, to filter for instances that do not end with name \"instance\", you would use `name ne .*instance`. You cannot combine constraints on multiple fields using regular expressions.
orderBy <string> Sorts list results by a certain order. By default, results are returned in alphanumerical order based on the resource name. You can also sort results in descending order based on the creation timestamp using `orderBy=\"creationTimestamp desc\"`. This sorts results based on the `creationTimestamp` field in reverse chronological order (newest result first). Use this to sort resources like operations so that the newest operation is returned first. Currently, only sorting by `name` or `creationTimestamp desc` is supported."
  ([project deployment] (manifests-list project deployment nil))
  ([project deployment optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/manifests",
       :uri-template-args {:project project, :deployment deployment},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.cloudman"
        "https://www.googleapis.com/auth/ndev.cloudman.readonly"]})))

(defn operations-get
  "Gets information about a specific operation.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
operation <string> The name of the operation for this request."
  [project operation]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/operations/{operation}",
     :uri-template-args {:project project, :operation operation},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/ndev.cloudman"
      "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}))

(defn operations-list
  "Lists all operations for a project.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.

optional:
maxResults <integer> The maximum number of results per page that should be returned. If the number of available results is larger than `maxResults`, Compute Engine returns a `nextPageToken` that can be used to get the next page of results in subsequent list requests. Acceptable values are `0` to `500`, inclusive. (Default: `500`)
filter <string> A filter expression that filters resources listed in the response. Most Compute resources support two types of filter expressions: expressions that support regular expressions and expressions that follow API improvement proposal AIP-160. These two types of filter expressions cannot be mixed in one request. If you want to use AIP-160, your expression must specify the field name, an operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The operator must be either `=`, `!=`, `>`, `<`, `<=`, `>=` or `:`. For example, if you are filtering Compute Engine instances, you can exclude instances named `example-instance` by specifying `name != example-instance`. The `:*` comparison can be used to test whether a key has been defined. For example, to find all objects with `owner` label use: ``` labels.owner:* ``` You can also filter nested fields. For example, you could specify `scheduling.automaticRestart = false` to include instances only if they are not scheduled for automatic restarts. You can use filtering on nested fields to filter based on resource labels. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (scheduling.automaticRestart = true) (cpuPlatform = \"Intel Skylake\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (cpuPlatform = \"Intel Skylake\") OR (cpuPlatform = \"Intel Broadwell\") AND (scheduling.automaticRestart = true) ``` If you want to use a regular expression, use the `eq` (equal) or `ne` (not equal) operator against a single un-parenthesized expression with or without quotes or against multiple parenthesized expressions. Examples: `fieldname eq unquoted literal` `fieldname eq 'single quoted literal'` `fieldname eq \"double quoted literal\"` `(fieldname1 eq literal) (fieldname2 ne \"literal\")` The literal value is interpreted as a regular expression using Google RE2 library syntax. The literal value must match the entire field. For example, to filter for instances that do not end with name \"instance\", you would use `name ne .*instance`. You cannot combine constraints on multiple fields using regular expressions.
orderBy <string> Sorts list results by a certain order. By default, results are returned in alphanumerical order based on the resource name. You can also sort results in descending order based on the creation timestamp using `orderBy=\"creationTimestamp desc\"`. This sorts results based on the `creationTimestamp` field in reverse chronological order (newest result first). Use this to sort resources like operations so that the newest operation is returned first. Currently, only sorting by `name` or `creationTimestamp desc` is supported."
  ([project] (operations-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/operations",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.cloudman"
        "https://www.googleapis.com/auth/ndev.cloudman.readonly"]})))

(defn resources-get
  "Gets information about a single resource.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.
resource <string> The name of the resource for this request."
  [project deployment resource]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/resources/{resource}",
     :uri-template-args
     {:project project, :deployment deployment, :resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"
      "https://www.googleapis.com/auth/ndev.cloudman"
      "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}))

(defn resources-list
  "Lists all resources in a given deployment.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.
deployment <string> The name of the deployment for this request.

optional:
maxResults <integer> The maximum number of results per page that should be returned. If the number of available results is larger than `maxResults`, Compute Engine returns a `nextPageToken` that can be used to get the next page of results in subsequent list requests. Acceptable values are `0` to `500`, inclusive. (Default: `500`)
filter <string> A filter expression that filters resources listed in the response. Most Compute resources support two types of filter expressions: expressions that support regular expressions and expressions that follow API improvement proposal AIP-160. These two types of filter expressions cannot be mixed in one request. If you want to use AIP-160, your expression must specify the field name, an operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The operator must be either `=`, `!=`, `>`, `<`, `<=`, `>=` or `:`. For example, if you are filtering Compute Engine instances, you can exclude instances named `example-instance` by specifying `name != example-instance`. The `:*` comparison can be used to test whether a key has been defined. For example, to find all objects with `owner` label use: ``` labels.owner:* ``` You can also filter nested fields. For example, you could specify `scheduling.automaticRestart = false` to include instances only if they are not scheduled for automatic restarts. You can use filtering on nested fields to filter based on resource labels. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (scheduling.automaticRestart = true) (cpuPlatform = \"Intel Skylake\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (cpuPlatform = \"Intel Skylake\") OR (cpuPlatform = \"Intel Broadwell\") AND (scheduling.automaticRestart = true) ``` If you want to use a regular expression, use the `eq` (equal) or `ne` (not equal) operator against a single un-parenthesized expression with or without quotes or against multiple parenthesized expressions. Examples: `fieldname eq unquoted literal` `fieldname eq 'single quoted literal'` `fieldname eq \"double quoted literal\"` `(fieldname1 eq literal) (fieldname2 ne \"literal\")` The literal value is interpreted as a regular expression using Google RE2 library syntax. The literal value must match the entire field. For example, to filter for instances that do not end with name \"instance\", you would use `name ne .*instance`. You cannot combine constraints on multiple fields using regular expressions.
orderBy <string> Sorts list results by a certain order. By default, results are returned in alphanumerical order based on the resource name. You can also sort results in descending order based on the creation timestamp using `orderBy=\"creationTimestamp desc\"`. This sorts results based on the `creationTimestamp` field in reverse chronological order (newest result first). Use this to sort resources like operations so that the newest operation is returned first. Currently, only sorting by `name` or `creationTimestamp desc` is supported."
  ([project deployment] (resources-list project deployment nil))
  ([project deployment optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/resources",
       :uri-template-args {:project project, :deployment deployment},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.cloudman"
        "https://www.googleapis.com/auth/ndev.cloudman.readonly"]})))

(defn types-list
  "Lists all resource types for Deployment Manager.
https://cloud.google.com/deployment-manager/docs

project <string> The project ID for this request.

optional:
maxResults <integer> The maximum number of results per page that should be returned. If the number of available results is larger than `maxResults`, Compute Engine returns a `nextPageToken` that can be used to get the next page of results in subsequent list requests. Acceptable values are `0` to `500`, inclusive. (Default: `500`)
filter <string> A filter expression that filters resources listed in the response. Most Compute resources support two types of filter expressions: expressions that support regular expressions and expressions that follow API improvement proposal AIP-160. These two types of filter expressions cannot be mixed in one request. If you want to use AIP-160, your expression must specify the field name, an operator, and the value that you want to use for filtering. The value must be a string, a number, or a boolean. The operator must be either `=`, `!=`, `>`, `<`, `<=`, `>=` or `:`. For example, if you are filtering Compute Engine instances, you can exclude instances named `example-instance` by specifying `name != example-instance`. The `:*` comparison can be used to test whether a key has been defined. For example, to find all objects with `owner` label use: ``` labels.owner:* ``` You can also filter nested fields. For example, you could specify `scheduling.automaticRestart = false` to include instances only if they are not scheduled for automatic restarts. You can use filtering on nested fields to filter based on resource labels. To filter on multiple expressions, provide each separate expression within parentheses. For example: ``` (scheduling.automaticRestart = true) (cpuPlatform = \"Intel Skylake\") ``` By default, each expression is an `AND` expression. However, you can include `AND` and `OR` expressions explicitly. For example: ``` (cpuPlatform = \"Intel Skylake\") OR (cpuPlatform = \"Intel Broadwell\") AND (scheduling.automaticRestart = true) ``` If you want to use a regular expression, use the `eq` (equal) or `ne` (not equal) operator against a single un-parenthesized expression with or without quotes or against multiple parenthesized expressions. Examples: `fieldname eq unquoted literal` `fieldname eq 'single quoted literal'` `fieldname eq \"double quoted literal\"` `(fieldname1 eq literal) (fieldname2 ne \"literal\")` The literal value is interpreted as a regular expression using Google RE2 library syntax. The literal value must match the entire field. For example, to filter for instances that do not end with name \"instance\", you would use `name ne .*instance`. You cannot combine constraints on multiple fields using regular expressions.
orderBy <string> Sorts list results by a certain order. By default, results are returned in alphanumerical order based on the resource name. You can also sort results in descending order based on the creation timestamp using `orderBy=\"creationTimestamp desc\"`. This sorts results based on the `creationTimestamp` field in reverse chronological order (newest result first). Use this to sort resources like operations so that the newest operation is returned first. Currently, only sorting by `name` or `creationTimestamp desc` is supported."
  ([project] (types-list project nil))
  ([project optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://deploymentmanager.googleapis.com/deploymentmanager/v2/projects/{project}/global/types",
       :uri-template-args {:project project},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"
        "https://www.googleapis.com/auth/ndev.cloudman"
        "https://www.googleapis.com/auth/ndev.cloudman.readonly"]})))

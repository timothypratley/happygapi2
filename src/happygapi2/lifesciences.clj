(ns happygapi2.lifesciences
  "Cloud Life Sciences API
Cloud Life Sciences is a suite of services and tools for managing, processing, and transforming life sciences data.
See: https://cloud.google.com/life-sciences-solutions"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/life-sciences-solutions

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://lifesciences.googleapis.com/v2beta/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/life-sciences-solutions

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://lifesciences.googleapis.com/v2beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission: * `lifesciences.operations.list`
https://cloud.google.com/life-sciences-solutions

name <string> The name of the operation's parent resource.

optional:
filter <string> A string for filtering Operations. The following filter fields are supported: * createTime: The time this job was created * events: The set of event (names) that have occurred while running the pipeline. The : operator can be used to determine if a particular event has occurred. * error: If the pipeline is running, this value is NULL. Once the pipeline finishes, the value is the standard Google error code. * labels.key or labels.\"key with space\" where key is a label key. * done: If the pipeline is running, this value is false. Once the pipeline finishes, the value is true.
pageSize <integer> The maximum number of results to return. The maximum value is 256."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://lifesciences.googleapis.com/v2beta/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service. Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission: * `lifesciences.operations.get`
https://cloud.google.com/life-sciences-solutions

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://lifesciences.googleapis.com/v2beta/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. Clients may use Operations.GetOperation or Operations.ListOperations to check whether the cancellation succeeded or the operation completed despite cancellation. Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission: * `lifesciences.operations.cancel`
https://cloud.google.com/life-sciences-solutions

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://lifesciences.googleapis.com/v2beta/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-pipelines-run
  "Runs a pipeline. The returned Operation's metadata field will contain a google.cloud.lifesciences.v2beta.Metadata object describing the status of the pipeline execution. The response field will contain a google.cloud.lifesciences.v2beta.RunPipelineResponse object if the pipeline completes successfully. **Note:** Before you can use this method, the *Life Sciences Service Agent* must have access to your project. This is done automatically when the Cloud Life Sciences API is first enabled, but if you delete this permission you must disable and re-enable the API to grant the Life Sciences Service Agent the required permissions. Authorization requires the following [Google IAM](https://cloud.google.com/iam/) permission: * `lifesciences.workflows.run`
https://cloud.google.com/life-sciences-solutions

parent <string> The project and location that this request should be executed against.
RunPipelineRequest:
{:pipeline
 {:actions
  [{:labels object,
    :pidNamespace string,
    :disableStandardErrorCapture boolean,
    :imageUri string,
    :credentials {:keyName string, :cipherText string},
    :mounts [{:disk string, :path string, :readOnly boolean}],
    :disableImagePrefetch boolean,
    :runInBackground boolean,
    :ignoreExitStatus boolean,
    :publishExposedPorts boolean,
    :commands [string],
    :entrypoint string,
    :portMappings object,
    :environment object,
    :timeout string,
    :enableFuse boolean,
    :encryptedEnvironment {:keyName string, :cipherText string},
    :blockExternalNetwork boolean,
    :containerName string,
    :alwaysRun boolean}],
  :resources
  {:regions [string],
   :zones [string],
   :virtualMachine
   {:serviceAccount {:email string, :scopes [string]},
    :labels object,
    :preemptible boolean,
    :dockerCacheImages [string],
    :bootDiskSizeGb integer,
    :reservation string,
    :machineType string,
    :volumes
    [{:volume string,
      :persistentDisk PersistentDisk,
      :existingDisk ExistingDisk,
      :nfsMount NFSMount}],
    :enableStackdriverMonitoring boolean,
    :bootImage string,
    :disks
    [{:name string,
      :sizeGb integer,
      :type string,
      :sourceImage string}],
    :cpuPlatform string,
    :network
    {:network string, :usePrivateAddress boolean, :subnetwork string},
    :accelerators [{:type string, :count string}],
    :nvidiaDriverVersion string}},
  :environment object,
  :encryptedEnvironment {:keyName string, :cipherText string},
  :timeout string},
 :labels object,
 :pubSubTopic string}"
  [parent RunPipelineRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://lifesciences.googleapis.com/v2beta/{+parent}/pipelines:run",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RunPipelineRequest}))

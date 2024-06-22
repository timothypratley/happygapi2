(ns happygapi2.blockchainnodeengine
  "Blockchain Node Engine API

See: https://cloud.google.com/blockchain-node-engine"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blockchainnodeengine.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://blockchainnodeengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.operations/list

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blockchainnodeengine.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://blockchainnodeengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.operations/delete

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://blockchainnodeengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.operations/cancel

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://blockchainnodeengine.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-blockchainNodes-list
  "Lists blockchain nodes in a given project and location.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.blockchainNodes/list

parent <string> Required. Parent value for `ListNodesRequest`.

optional:
pageSize <integer> Requested page size. Server may return fewer items than requested. If unspecified, server will pick an appropriate default.
filter <string> Filtering results.
orderBy <string> Hint for how to order the results."
  ([parent] (projects-locations-blockchainNodes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://blockchainnodeengine.googleapis.com/v1/{+parent}/blockchainNodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-blockchainNodes-get
  "Gets details of a single blockchain node.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.blockchainNodes/get

name <string> Required. The fully qualified name of the blockchain node to fetch. e.g. `projects/my-project/locations/us-central1/blockchainNodes/my-node`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://blockchainnodeengine.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-blockchainNodes-create
  "Creates a new blockchain node in a given project and location.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.blockchainNodes/create

parent <string> Required. Value for parent.
BlockchainNode:
{:privateServiceConnectEnabled boolean,
 :labels object,
 :name string,
 :blockchainType [BLOCKCHAIN_TYPE_UNSPECIFIED ETHEREUM],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  DELETING
  RUNNING
  ERROR
  UPDATING
  REPAIRING
  RECONCILING
  SYNCING],
 :ethereumDetails
 {:nodeType [NODE_TYPE_UNSPECIFIED LIGHT FULL ARCHIVE],
  :apiEnableAdmin boolean,
  :gethDetails
  {:garbageCollectionMode
   [GARBAGE_COLLECTION_MODE_UNSPECIFIED FULL ARCHIVE]},
  :apiEnableDebug boolean,
  :executionClient [EXECUTION_CLIENT_UNSPECIFIED GETH ERIGON],
  :network
  [NETWORK_UNSPECIFIED
   MAINNET
   TESTNET_GOERLI_PRATER
   TESTNET_SEPOLIA
   TESTNET_HOLESKY],
  :validatorConfig
  {:mevRelayUrls [string],
   :managedValidatorClient boolean,
   :beaconFeeRecipient string},
  :consensusClient
  [CONSENSUS_CLIENT_UNSPECIFIED
   LIGHTHOUSE
   ERIGON_EMBEDDED_CONSENSUS_LAYER],
  :additionalEndpoints
  {:beaconApiEndpoint string,
   :beaconPrometheusMetricsApiEndpoint string,
   :executionClientPrometheusMetricsApiEndpoint string}},
 :updateTime string,
 :connectionInfo
 {:endpointInfo
  {:jsonRpcApiEndpoint string, :websocketsApiEndpoint string},
  :serviceAttachment string}}

optional:
blockchainNodeId <string> Required. ID of the requesting object.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent BlockchainNode]
    (projects-locations-blockchainNodes-create
      parent
      BlockchainNode
      nil))
  ([parent BlockchainNode optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://blockchainnodeengine.googleapis.com/v1/{+parent}/blockchainNodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body BlockchainNode})))

(defn projects-locations-blockchainNodes-patch
  "Updates the parameters of a single blockchain node.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.blockchainNodes/patch

name <string> Output only. The fully qualified name of the blockchain node. e.g. `projects/my-project/locations/us-central1/blockchainNodes/my-node`.
BlockchainNode:
{:privateServiceConnectEnabled boolean,
 :labels object,
 :name string,
 :blockchainType [BLOCKCHAIN_TYPE_UNSPECIFIED ETHEREUM],
 :createTime string,
 :state
 [STATE_UNSPECIFIED
  CREATING
  DELETING
  RUNNING
  ERROR
  UPDATING
  REPAIRING
  RECONCILING
  SYNCING],
 :ethereumDetails
 {:nodeType [NODE_TYPE_UNSPECIFIED LIGHT FULL ARCHIVE],
  :apiEnableAdmin boolean,
  :gethDetails
  {:garbageCollectionMode
   [GARBAGE_COLLECTION_MODE_UNSPECIFIED FULL ARCHIVE]},
  :apiEnableDebug boolean,
  :executionClient [EXECUTION_CLIENT_UNSPECIFIED GETH ERIGON],
  :network
  [NETWORK_UNSPECIFIED
   MAINNET
   TESTNET_GOERLI_PRATER
   TESTNET_SEPOLIA
   TESTNET_HOLESKY],
  :validatorConfig
  {:mevRelayUrls [string],
   :managedValidatorClient boolean,
   :beaconFeeRecipient string},
  :consensusClient
  [CONSENSUS_CLIENT_UNSPECIFIED
   LIGHTHOUSE
   ERIGON_EMBEDDED_CONSENSUS_LAYER],
  :additionalEndpoints
  {:beaconApiEndpoint string,
   :beaconPrometheusMetricsApiEndpoint string,
   :executionClientPrometheusMetricsApiEndpoint string}},
 :updateTime string,
 :connectionInfo
 {:endpointInfo
  {:jsonRpcApiEndpoint string, :websocketsApiEndpoint string},
  :serviceAttachment string}}

optional:
updateMask <string> Required. Field mask is used to specify the fields to be overwritten in the Blockchain node resource by the update. The fields specified in the `update_mask` are relative to the resource, not the full request. A field will be overwritten if it is in the mask. If the user does not provide a mask then all fields will be overwritten.
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name BlockchainNode]
    (projects-locations-blockchainNodes-patch name BlockchainNode nil))
  ([name BlockchainNode optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://blockchainnodeengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body BlockchainNode})))

(defn projects-locations-blockchainNodes-delete
  "Deletes a single blockchain node.
https://cloud.google.com/blockchain-node-engine/docs/reference/rest/v1/projects.locations.blockchainNodes/delete

name <string> Required. The fully qualified name of the blockchain node to delete. e.g. `projects/my-project/locations/us-central1/blockchainNodes/my-node`.

optional:
requestId <string> Optional. An optional request ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes after the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-blockchainNodes-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://blockchainnodeengine.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

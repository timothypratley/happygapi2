(ns happygapi2.sasportal
  "SAS Portal API

See: https://developers.google.com/spectrum-access-system/"
  (:require [happy.oauth2.client :as client]))

(defn policies-get
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/policies/get

SasPortalGetPolicyRequest:
{:resource string}"
  [SasPortalGetPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/policies:get",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalGetPolicyRequest}))

(defn policies-test
  "Returns permissions that a caller has on the specified resource.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/policies/test

SasPortalTestPermissionsRequest:
{:permissions [string], :resource string}"
  [SasPortalTestPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/policies:test",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalTestPermissionsRequest}))

(defn policies-set
  "Sets the access control policy on the specified resource. Replaces any existing policy.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/policies/set

SasPortalSetPolicyRequest:
{:policy
 {:assignments [{:members [string], :role string}], :etag string},
 :resource string,
 :disableNotification boolean}"
  [SasPortalSetPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/policies:set",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalSetPolicyRequest}))

(defn nodes-get
  "Returns a requested node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/get

name <string> Required. The name of the node."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn nodes-deployments-delete
  "Deletes a deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/delete

name <string> Required. The name of the deployment."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn nodes-deployments-get
  "Returns a requested deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/get

name <string> Required. The name of the deployment."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn nodes-deployments-move
  "Moves a deployment under another node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/move

name <string> Required. The name of the deployment to move.
SasPortalMoveDeploymentRequest:
{:destination string}"
  [name SasPortalMoveDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMoveDeploymentRequest}))

(defn nodes-deployments-patch
  "Updates an existing deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/patch

name <string> Output only. Resource name.
SasPortalDeployment:
{:sasUserIds [string],
 :frns [string],
 :displayName string,
 :name string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalDeployment]
    (nodes-deployments-patch name SasPortalDeployment nil))
  ([name SasPortalDeployment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalDeployment})))

(defn nodes-deployments-list
  "Lists deployments.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/list

parent <string> Required. The parent resource name, for example, \"nodes/1\", customer/1/nodes/2.

optional:
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no deployments are filtered.
pageSize <integer> The maximum number of deployments to return in the response."
  ([parent] (nodes-deployments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn nodes-deployments-devices-list
  "Lists devices under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/devices/list

parent <string> Required. The name of the parent resource.

optional:
filter <string> The filter expression. The filter should have one of the following formats: \"sn=123454\" or \"display_name=MyDevice\". sn corresponds to serial number of the device. The filter is case insensitive.
pageSize <integer> The maximum number of devices to return in the response. If empty or zero, all devices will be listed. Must be in the range [0, 1000]."
  ([parent] (nodes-deployments-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn nodes-deployments-devices-create
  "Creates a device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/devices/create

parent <string> Required. The name of the parent resource.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}"
  [parent SasPortalDevice]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDevice}))

(defn nodes-deployments-devices-createSigned
  "Creates a signed device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/deployments/devices/createSigned

parent <string> Required. The name of the parent resource.
SasPortalCreateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [parent SasPortalCreateSignedDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices:createSigned",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalCreateSignedDeviceRequest}))

(defn nodes-nodes-delete
  "Deletes a node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/delete

name <string> Required. The name of the node."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn nodes-nodes-move
  "Moves a node under another node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/move

name <string> Required. The name of the node to move.
SasPortalMoveNodeRequest:
{:destination string}"
  [name SasPortalMoveNodeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMoveNodeRequest}))

(defn nodes-nodes-list
  "Lists nodes.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/list

parent <string> Required. The parent resource name, for example, \"nodes/1\".

optional:
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no nodes are filtered.
pageSize <integer> The maximum number of nodes to return in the response."
  ([parent] (nodes-nodes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn nodes-nodes-patch
  "Updates an existing node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/patch

name <string> Output only. Resource name.
SasPortalNode:
{:displayName string, :sasUserIds [string], :name string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalNode] (nodes-nodes-patch name SasPortalNode nil))
  ([name SasPortalNode optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalNode})))

(defn nodes-nodes-create
  "Creates a new node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/create

parent <string> Required. The parent resource name where the node is to be created.
SasPortalNode:
{:displayName string, :sasUserIds [string], :name string}"
  [parent SasPortalNode]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalNode}))

(defn nodes-nodes-get
  "Returns a requested node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/get

name <string> Required. The name of the node."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn nodes-nodes-deployments-create
  "Creates a new deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/deployments/create

parent <string> Required. The parent resource name where the deployment is to be created.
SasPortalDeployment:
{:sasUserIds [string],
 :frns [string],
 :displayName string,
 :name string}"
  [parent SasPortalDeployment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/deployments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDeployment}))

(defn nodes-nodes-deployments-list
  "Lists deployments.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/deployments/list

parent <string> Required. The parent resource name, for example, \"nodes/1\", customer/1/nodes/2.

optional:
pageSize <integer> The maximum number of deployments to return in the response.
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no deployments are filtered."
  ([parent] (nodes-nodes-deployments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn nodes-nodes-devices-createSigned
  "Creates a signed device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/devices/createSigned

parent <string> Required. The name of the parent resource.
SasPortalCreateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [parent SasPortalCreateSignedDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices:createSigned",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalCreateSignedDeviceRequest}))

(defn nodes-nodes-devices-list
  "Lists devices under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/devices/list

parent <string> Required. The name of the parent resource.

optional:
filter <string> The filter expression. The filter should have one of the following formats: \"sn=123454\" or \"display_name=MyDevice\". sn corresponds to serial number of the device. The filter is case insensitive.
pageSize <integer> The maximum number of devices to return in the response. If empty or zero, all devices will be listed. Must be in the range [0, 1000]."
  ([parent] (nodes-nodes-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn nodes-nodes-devices-create
  "Creates a device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/devices/create

parent <string> Required. The name of the parent resource.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}"
  [parent SasPortalDevice]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDevice}))

(defn nodes-nodes-nodes-create
  "Creates a new node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/nodes/create

parent <string> Required. The parent resource name where the node is to be created.
SasPortalNode:
{:displayName string, :sasUserIds [string], :name string}"
  [parent SasPortalNode]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalNode}))

(defn nodes-nodes-nodes-list
  "Lists nodes.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/nodes/nodes/list

parent <string> Required. The parent resource name, for example, \"nodes/1\".

optional:
pageSize <integer> The maximum number of nodes to return in the response.
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no nodes are filtered."
  ([parent] (nodes-nodes-nodes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn nodes-devices-get
  "Gets details about a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/get

name <string> Required. The name of the device."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn nodes-devices-patch
  "Updates a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/patch

name <string> Output only. The resource path name.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalDevice]
    (nodes-devices-patch name SasPortalDevice nil))
  ([name SasPortalDevice optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalDevice})))

(defn nodes-devices-updateSigned
  "Updates a signed device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/updateSigned

name <string> Required. The name of the device to update.
SasPortalUpdateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [name SasPortalUpdateSignedDeviceRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:updateSigned",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalUpdateSignedDeviceRequest}))

(defn nodes-devices-createSigned
  "Creates a signed device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/createSigned

parent <string> Required. The name of the parent resource.
SasPortalCreateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [parent SasPortalCreateSignedDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices:createSigned",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalCreateSignedDeviceRequest}))

(defn nodes-devices-create
  "Creates a device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/create

parent <string> Required. The name of the parent resource.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}"
  [parent SasPortalDevice]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDevice}))

(defn nodes-devices-move
  "Moves a device under another node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/move

name <string> Required. The name of the device to move.
SasPortalMoveDeviceRequest:
{:destination string}"
  [name SasPortalMoveDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMoveDeviceRequest}))

(defn nodes-devices-delete
  "Deletes a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/delete

name <string> Required. The name of the device."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn nodes-devices-list
  "Lists devices under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/list

parent <string> Required. The name of the parent resource.

optional:
pageSize <integer> The maximum number of devices to return in the response. If empty or zero, all devices will be listed. Must be in the range [0, 1000].
filter <string> The filter expression. The filter should have one of the following formats: \"sn=123454\" or \"display_name=MyDevice\". sn corresponds to serial number of the device. The filter is case insensitive."
  ([parent] (nodes-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn nodes-devices-signDevice
  "Signs a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/nodes/devices/signDevice

name <string> Output only. The resource path name.
SasPortalSignDeviceRequest:
{:device
 {:serialNumber string,
  :activeConfig
  {:category
   [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
   :installationParams
   {:antennaDowntilt integer,
    :cpeCbsdIndication boolean,
    :indoorDeployment boolean,
    :eirpCapability integer,
    :heightType
    [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
    :antennaGain number,
    :antennaModel string,
    :horizontalAccuracy number,
    :longitude number,
    :antennaBeamwidth integer,
    :verticalAccuracy number,
    :latitude number,
    :antennaAzimuth integer,
    :height number},
   :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
   :measurementCapabilities
   [[MEASUREMENT_CAPABILITY_UNSPECIFIED
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
   :updateTime string,
   :callSign string,
   :userId string,
   :isSigned boolean,
   :airInterface
   {:radioTechnology
    [RADIO_TECHNOLOGY_UNSPECIFIED
     E_UTRA
     CAMBIUM_NETWORKS
     FOUR_G_BBW_SAA_1
     NR
     DOODLE_CBRS
     CW
     REDLINE
     TARANA_WIRELESS],
    :supportedSpec string},
   :model
   {:firmwareVersion string,
    :name string,
    :vendor string,
    :hardwareVersion string,
    :softwareVersion string}},
  :grantRangeAllowlists
  [{:highFrequencyMhz number, :lowFrequencyMhz number}],
  :displayName string,
  :name string,
  :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
  :deviceMetadata
  {:antennaModel string,
   :nrqzValidated boolean,
   :commonChannelGroup string,
   :nrqzValidation
   {:cpiId string,
    :latitude number,
    :state [STATE_UNSPECIFIED DRAFT FINAL],
    :longitude number,
    :caseId string},
   :interferenceCoordinationGroup string},
  :grants
  [{:moveList
    [{:frequencyRange
      {:highFrequencyMhz number, :lowFrequencyMhz number},
      :dpaId string}],
    :lastHeartbeatTransmitExpireTime string,
    :state
    [GRANT_STATE_UNSPECIFIED
     GRANT_STATE_GRANTED
     GRANT_STATE_TERMINATED
     GRANT_STATE_SUSPENDED
     GRANT_STATE_AUTHORIZED
     GRANT_STATE_EXPIRED],
    :grantId string,
    :frequencyRange
    {:highFrequencyMhz number, :lowFrequencyMhz number},
    :expireTime string,
    :suspensionReason [string],
    :maxEirp number,
    :channelType
    [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
  :preloadedConfig
  {:category
   [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
   :installationParams
   {:antennaDowntilt integer,
    :cpeCbsdIndication boolean,
    :indoorDeployment boolean,
    :eirpCapability integer,
    :heightType
    [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
    :antennaGain number,
    :antennaModel string,
    :horizontalAccuracy number,
    :longitude number,
    :antennaBeamwidth integer,
    :verticalAccuracy number,
    :latitude number,
    :antennaAzimuth integer,
    :height number},
   :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
   :measurementCapabilities
   [[MEASUREMENT_CAPABILITY_UNSPECIFIED
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
   :updateTime string,
   :callSign string,
   :userId string,
   :isSigned boolean,
   :airInterface
   {:radioTechnology
    [RADIO_TECHNOLOGY_UNSPECIFIED
     E_UTRA
     CAMBIUM_NETWORKS
     FOUR_G_BBW_SAA_1
     NR
     DOODLE_CBRS
     CW
     REDLINE
     TARANA_WIRELESS],
    :supportedSpec string},
   :model
   {:firmwareVersion string,
    :name string,
    :vendor string,
    :hardwareVersion string,
    :softwareVersion string}},
  :currentChannels
  [{:frequencyRange
    {:highFrequencyMhz number, :lowFrequencyMhz number},
    :score number}],
  :fccId string}}"
  [name SasPortalSignDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:signDevice",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalSignDeviceRequest}))

(defn customers-provisionDeployment
  "Creates a new SAS deployment through the GCP workflow. Creates a SAS organization if an organization match is not found.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/provisionDeployment

SasPortalProvisionDeploymentRequest:
{:organizationId string,
 :newOrganizationDisplayName string,
 :newDeploymentDisplayName string}"
  [SasPortalProvisionDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/customers:provisionDeployment",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalProvisionDeploymentRequest}))

(defn customers-listLegacyOrganizations
  "Returns a list of legacy organizations.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/listLegacyOrganizations"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/customers:listLegacyOrganizations",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-get
  "Returns a requested customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/get

name <string> Required. The name of the customer."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-migrateOrganization
  "Migrates a SAS organization to the cloud. This will create GCP projects for each deployment and associate them. The SAS Organization is linked to the gcp project that called the command. go/sas-legacy-customer-migration
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/migrateOrganization

SasPortalMigrateOrganizationRequest:
{:organizationId string}"
  [SasPortalMigrateOrganizationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/customers:migrateOrganization",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMigrateOrganizationRequest}))

(defn customers-list
  "Returns a list of requested customers.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/list

optional:
pageSize <integer> The maximum number of customers to return in the response."
  ([] (customers-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/customers",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-patch
  "Updates an existing customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/patch

name <string> Output only. Resource name of the customer.
SasPortalCustomer:
{:sasUserIds [string], :displayName string, :name string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalCustomer]
    (customers-patch name SasPortalCustomer nil))
  ([name SasPortalCustomer optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalCustomer})))

(defn customers-listGcpProjectDeployments
  "Returns a list of SAS deployments associated with current GCP project. Includes whether SAS analytics has been enabled or not.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/listGcpProjectDeployments"
  []
  (client/api-request
    {:method "GET",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/customers:listGcpProjectDeployments",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-setupSasAnalytics
  "Setups the a GCP Project to receive SAS Analytics messages via GCP Pub/Sub with a subscription to BigQuery. All the Pub/Sub topics and BigQuery tables are created automatically as part of this service.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/setupSasAnalytics

SasPortalSetupSasAnalyticsRequest:
{:userId string}"
  [SasPortalSetupSasAnalyticsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/customers:setupSasAnalytics",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalSetupSasAnalyticsRequest}))

(defn customers-nodes-create
  "Creates a new node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/create

parent <string> Required. The parent resource name where the node is to be created.
SasPortalNode:
{:displayName string, :sasUserIds [string], :name string}"
  [parent SasPortalNode]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalNode}))

(defn customers-nodes-move
  "Moves a node under another node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/move

name <string> Required. The name of the node to move.
SasPortalMoveNodeRequest:
{:destination string}"
  [name SasPortalMoveNodeRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMoveNodeRequest}))

(defn customers-nodes-delete
  "Deletes a node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/delete

name <string> Required. The name of the node."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-nodes-get
  "Returns a requested node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/get

name <string> Required. The name of the node."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-nodes-patch
  "Updates an existing node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/patch

name <string> Output only. Resource name.
SasPortalNode:
{:displayName string, :sasUserIds [string], :name string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalNode] (customers-nodes-patch name SasPortalNode nil))
  ([name SasPortalNode optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalNode})))

(defn customers-nodes-list
  "Lists nodes.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/list

parent <string> Required. The parent resource name, for example, \"nodes/1\".

optional:
pageSize <integer> The maximum number of nodes to return in the response.
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no nodes are filtered."
  ([parent] (customers-nodes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-nodes-nodes-list
  "Lists nodes.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/nodes/list

parent <string> Required. The parent resource name, for example, \"nodes/1\".

optional:
pageSize <integer> The maximum number of nodes to return in the response.
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no nodes are filtered."
  ([parent] (customers-nodes-nodes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-nodes-nodes-create
  "Creates a new node.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/nodes/create

parent <string> Required. The parent resource name where the node is to be created.
SasPortalNode:
{:displayName string, :sasUserIds [string], :name string}"
  [parent SasPortalNode]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/nodes",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalNode}))

(defn customers-nodes-deployments-create
  "Creates a new deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/deployments/create

parent <string> Required. The parent resource name where the deployment is to be created.
SasPortalDeployment:
{:sasUserIds [string],
 :frns [string],
 :displayName string,
 :name string}"
  [parent SasPortalDeployment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/deployments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDeployment}))

(defn customers-nodes-deployments-list
  "Lists deployments.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/deployments/list

parent <string> Required. The parent resource name, for example, \"nodes/1\", customer/1/nodes/2.

optional:
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no deployments are filtered.
pageSize <integer> The maximum number of deployments to return in the response."
  ([parent] (customers-nodes-deployments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-nodes-devices-create
  "Creates a device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/devices/create

parent <string> Required. The name of the parent resource.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}"
  [parent SasPortalDevice]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDevice}))

(defn customers-nodes-devices-createSigned
  "Creates a signed device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/devices/createSigned

parent <string> Required. The name of the parent resource.
SasPortalCreateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [parent SasPortalCreateSignedDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices:createSigned",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalCreateSignedDeviceRequest}))

(defn customers-nodes-devices-list
  "Lists devices under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/nodes/devices/list

parent <string> Required. The name of the parent resource.

optional:
pageSize <integer> The maximum number of devices to return in the response. If empty or zero, all devices will be listed. Must be in the range [0, 1000].
filter <string> The filter expression. The filter should have one of the following formats: \"sn=123454\" or \"display_name=MyDevice\". sn corresponds to serial number of the device. The filter is case insensitive."
  ([parent] (customers-nodes-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-devices-get
  "Gets details about a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/get

name <string> Required. The name of the device."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-devices-patch
  "Updates a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/patch

name <string> Output only. The resource path name.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalDevice]
    (customers-devices-patch name SasPortalDevice nil))
  ([name SasPortalDevice optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalDevice})))

(defn customers-devices-updateSigned
  "Updates a signed device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/updateSigned

name <string> Required. The name of the device to update.
SasPortalUpdateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [name SasPortalUpdateSignedDeviceRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:updateSigned",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalUpdateSignedDeviceRequest}))

(defn customers-devices-createSigned
  "Creates a signed device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/createSigned

parent <string> Required. The name of the parent resource.
SasPortalCreateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [parent SasPortalCreateSignedDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices:createSigned",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalCreateSignedDeviceRequest}))

(defn customers-devices-create
  "Creates a device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/create

parent <string> Required. The name of the parent resource.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}"
  [parent SasPortalDevice]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDevice}))

(defn customers-devices-move
  "Moves a device under another node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/move

name <string> Required. The name of the device to move.
SasPortalMoveDeviceRequest:
{:destination string}"
  [name SasPortalMoveDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMoveDeviceRequest}))

(defn customers-devices-delete
  "Deletes a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/delete

name <string> Required. The name of the device."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-devices-list
  "Lists devices under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/list

parent <string> Required. The name of the parent resource.

optional:
filter <string> The filter expression. The filter should have one of the following formats: \"sn=123454\" or \"display_name=MyDevice\". sn corresponds to serial number of the device. The filter is case insensitive.
pageSize <integer> The maximum number of devices to return in the response. If empty or zero, all devices will be listed. Must be in the range [0, 1000]."
  ([parent] (customers-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-devices-signDevice
  "Signs a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/devices/signDevice

name <string> Output only. The resource path name.
SasPortalSignDeviceRequest:
{:device
 {:serialNumber string,
  :activeConfig
  {:category
   [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
   :installationParams
   {:antennaDowntilt integer,
    :cpeCbsdIndication boolean,
    :indoorDeployment boolean,
    :eirpCapability integer,
    :heightType
    [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
    :antennaGain number,
    :antennaModel string,
    :horizontalAccuracy number,
    :longitude number,
    :antennaBeamwidth integer,
    :verticalAccuracy number,
    :latitude number,
    :antennaAzimuth integer,
    :height number},
   :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
   :measurementCapabilities
   [[MEASUREMENT_CAPABILITY_UNSPECIFIED
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
   :updateTime string,
   :callSign string,
   :userId string,
   :isSigned boolean,
   :airInterface
   {:radioTechnology
    [RADIO_TECHNOLOGY_UNSPECIFIED
     E_UTRA
     CAMBIUM_NETWORKS
     FOUR_G_BBW_SAA_1
     NR
     DOODLE_CBRS
     CW
     REDLINE
     TARANA_WIRELESS],
    :supportedSpec string},
   :model
   {:firmwareVersion string,
    :name string,
    :vendor string,
    :hardwareVersion string,
    :softwareVersion string}},
  :grantRangeAllowlists
  [{:highFrequencyMhz number, :lowFrequencyMhz number}],
  :displayName string,
  :name string,
  :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
  :deviceMetadata
  {:antennaModel string,
   :nrqzValidated boolean,
   :commonChannelGroup string,
   :nrqzValidation
   {:cpiId string,
    :latitude number,
    :state [STATE_UNSPECIFIED DRAFT FINAL],
    :longitude number,
    :caseId string},
   :interferenceCoordinationGroup string},
  :grants
  [{:moveList
    [{:frequencyRange
      {:highFrequencyMhz number, :lowFrequencyMhz number},
      :dpaId string}],
    :lastHeartbeatTransmitExpireTime string,
    :state
    [GRANT_STATE_UNSPECIFIED
     GRANT_STATE_GRANTED
     GRANT_STATE_TERMINATED
     GRANT_STATE_SUSPENDED
     GRANT_STATE_AUTHORIZED
     GRANT_STATE_EXPIRED],
    :grantId string,
    :frequencyRange
    {:highFrequencyMhz number, :lowFrequencyMhz number},
    :expireTime string,
    :suspensionReason [string],
    :maxEirp number,
    :channelType
    [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
  :preloadedConfig
  {:category
   [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
   :installationParams
   {:antennaDowntilt integer,
    :cpeCbsdIndication boolean,
    :indoorDeployment boolean,
    :eirpCapability integer,
    :heightType
    [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
    :antennaGain number,
    :antennaModel string,
    :horizontalAccuracy number,
    :longitude number,
    :antennaBeamwidth integer,
    :verticalAccuracy number,
    :latitude number,
    :antennaAzimuth integer,
    :height number},
   :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
   :measurementCapabilities
   [[MEASUREMENT_CAPABILITY_UNSPECIFIED
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
   :updateTime string,
   :callSign string,
   :userId string,
   :isSigned boolean,
   :airInterface
   {:radioTechnology
    [RADIO_TECHNOLOGY_UNSPECIFIED
     E_UTRA
     CAMBIUM_NETWORKS
     FOUR_G_BBW_SAA_1
     NR
     DOODLE_CBRS
     CW
     REDLINE
     TARANA_WIRELESS],
    :supportedSpec string},
   :model
   {:firmwareVersion string,
    :name string,
    :vendor string,
    :hardwareVersion string,
    :softwareVersion string}},
  :currentChannels
  [{:frequencyRange
    {:highFrequencyMhz number, :lowFrequencyMhz number},
    :score number}],
  :fccId string}}"
  [name SasPortalSignDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:signDevice",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalSignDeviceRequest}))

(defn customers-deployments-move
  "Moves a deployment under another node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/move

name <string> Required. The name of the deployment to move.
SasPortalMoveDeploymentRequest:
{:destination string}"
  [name SasPortalMoveDeploymentRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMoveDeploymentRequest}))

(defn customers-deployments-patch
  "Updates an existing deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/patch

name <string> Output only. Resource name.
SasPortalDeployment:
{:sasUserIds [string],
 :frns [string],
 :displayName string,
 :name string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalDeployment]
    (customers-deployments-patch name SasPortalDeployment nil))
  ([name SasPortalDeployment optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalDeployment})))

(defn customers-deployments-delete
  "Deletes a deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/delete

name <string> Required. The name of the deployment."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-deployments-list
  "Lists deployments.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/list

parent <string> Required. The parent resource name, for example, \"nodes/1\", customer/1/nodes/2.

optional:
pageSize <integer> The maximum number of deployments to return in the response.
filter <string> The filter expression. The filter should have the following format: \"DIRECT_CHILDREN\" or format: \"direct_children\". The filter is case insensitive. If empty, then no deployments are filtered."
  ([parent] (customers-deployments-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/deployments",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-deployments-create
  "Creates a new deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/create

parent <string> Required. The parent resource name where the deployment is to be created.
SasPortalDeployment:
{:sasUserIds [string],
 :frns [string],
 :displayName string,
 :name string}"
  [parent SasPortalDeployment]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/deployments",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDeployment}))

(defn customers-deployments-get
  "Returns a requested deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/get

name <string> Required. The name of the deployment."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn customers-deployments-devices-createSigned
  "Creates a signed device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/devices/createSigned

parent <string> Required. The name of the parent resource.
SasPortalCreateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [parent SasPortalCreateSignedDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices:createSigned",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalCreateSignedDeviceRequest}))

(defn customers-deployments-devices-list
  "Lists devices under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/devices/list

parent <string> Required. The name of the parent resource.

optional:
pageSize <integer> The maximum number of devices to return in the response. If empty or zero, all devices will be listed. Must be in the range [0, 1000].
filter <string> The filter expression. The filter should have one of the following formats: \"sn=123454\" or \"display_name=MyDevice\". sn corresponds to serial number of the device. The filter is case insensitive."
  ([parent] (customers-deployments-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"]})))

(defn customers-deployments-devices-create
  "Creates a device under a node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/customers/deployments/devices/create

parent <string> Required. The name of the parent resource.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}"
  [parent SasPortalDevice]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+parent}/devices",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalDevice}))

(defn installer-generateSecret
  "Generates a secret to be used with the ValidateInstaller.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/installer/generateSecret

SasPortalGenerateSecretRequest:
object"
  [SasPortalGenerateSecretRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/installer:generateSecret",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalGenerateSecretRequest}))

(defn installer-validate
  "Validates the identity of a Certified Professional Installer (CPI).
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/installer/validate

SasPortalValidateInstallerRequest:
{:installerId string, :encodedSecret string, :secret string}"
  [SasPortalValidateInstallerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/installer:validate",
     :uri-template-args {},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalValidateInstallerRequest}))

(defn deployments-get
  "Returns a requested deployment.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/deployments/get

name <string> Required. The name of the deployment."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn deployments-devices-get
  "Gets details about a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/deployments/devices/get

name <string> Required. The name of the device."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

(defn deployments-devices-move
  "Moves a device under another node or customer.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/deployments/devices/move

name <string> Required. The name of the device to move.
SasPortalMoveDeviceRequest:
{:destination string}"
  [name SasPortalMoveDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:move",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalMoveDeviceRequest}))

(defn deployments-devices-patch
  "Updates a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/deployments/devices/patch

name <string> Output only. The resource path name.
SasPortalDevice:
{:serialNumber string,
 :activeConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :grantRangeAllowlists
 [{:highFrequencyMhz number, :lowFrequencyMhz number}],
 :displayName string,
 :name string,
 :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
 :deviceMetadata
 {:antennaModel string,
  :nrqzValidated boolean,
  :commonChannelGroup string,
  :nrqzValidation
  {:cpiId string,
   :latitude number,
   :state [STATE_UNSPECIFIED DRAFT FINAL],
   :longitude number,
   :caseId string},
  :interferenceCoordinationGroup string},
 :grants
 [{:moveList
   [{:frequencyRange
     {:highFrequencyMhz number, :lowFrequencyMhz number},
     :dpaId string}],
   :lastHeartbeatTransmitExpireTime string,
   :state
   [GRANT_STATE_UNSPECIFIED
    GRANT_STATE_GRANTED
    GRANT_STATE_TERMINATED
    GRANT_STATE_SUSPENDED
    GRANT_STATE_AUTHORIZED
    GRANT_STATE_EXPIRED],
   :grantId string,
   :frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :expireTime string,
   :suspensionReason [string],
   :maxEirp number,
   :channelType
   [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
 :preloadedConfig
 {:category
  [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
  :installationParams
  {:antennaDowntilt integer,
   :cpeCbsdIndication boolean,
   :indoorDeployment boolean,
   :eirpCapability integer,
   :heightType
   [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
   :antennaGain number,
   :antennaModel string,
   :horizontalAccuracy number,
   :longitude number,
   :antennaBeamwidth integer,
   :verticalAccuracy number,
   :latitude number,
   :antennaAzimuth integer,
   :height number},
  :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
  :measurementCapabilities
  [[MEASUREMENT_CAPABILITY_UNSPECIFIED
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
    MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
  :updateTime string,
  :callSign string,
  :userId string,
  :isSigned boolean,
  :airInterface
  {:radioTechnology
   [RADIO_TECHNOLOGY_UNSPECIFIED
    E_UTRA
    CAMBIUM_NETWORKS
    FOUR_G_BBW_SAA_1
    NR
    DOODLE_CBRS
    CW
    REDLINE
    TARANA_WIRELESS],
   :supportedSpec string},
  :model
  {:firmwareVersion string,
   :name string,
   :vendor string,
   :hardwareVersion string,
   :softwareVersion string}},
 :currentChannels
 [{:frequencyRange {:highFrequencyMhz number, :lowFrequencyMhz number},
   :score number}],
 :fccId string}

optional:
updateMask <string> Fields to be updated."
  ([name SasPortalDevice]
    (deployments-devices-patch name SasPortalDevice nil))
  ([name SasPortalDevice optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://sasportal.googleapis.com/v1alpha1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/sasportal"],
       :body SasPortalDevice})))

(defn deployments-devices-signDevice
  "Signs a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/deployments/devices/signDevice

name <string> Output only. The resource path name.
SasPortalSignDeviceRequest:
{:device
 {:serialNumber string,
  :activeConfig
  {:category
   [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
   :installationParams
   {:antennaDowntilt integer,
    :cpeCbsdIndication boolean,
    :indoorDeployment boolean,
    :eirpCapability integer,
    :heightType
    [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
    :antennaGain number,
    :antennaModel string,
    :horizontalAccuracy number,
    :longitude number,
    :antennaBeamwidth integer,
    :verticalAccuracy number,
    :latitude number,
    :antennaAzimuth integer,
    :height number},
   :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
   :measurementCapabilities
   [[MEASUREMENT_CAPABILITY_UNSPECIFIED
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
   :updateTime string,
   :callSign string,
   :userId string,
   :isSigned boolean,
   :airInterface
   {:radioTechnology
    [RADIO_TECHNOLOGY_UNSPECIFIED
     E_UTRA
     CAMBIUM_NETWORKS
     FOUR_G_BBW_SAA_1
     NR
     DOODLE_CBRS
     CW
     REDLINE
     TARANA_WIRELESS],
    :supportedSpec string},
   :model
   {:firmwareVersion string,
    :name string,
    :vendor string,
    :hardwareVersion string,
    :softwareVersion string}},
  :grantRangeAllowlists
  [{:highFrequencyMhz number, :lowFrequencyMhz number}],
  :displayName string,
  :name string,
  :state [DEVICE_STATE_UNSPECIFIED RESERVED REGISTERED DEREGISTERED],
  :deviceMetadata
  {:antennaModel string,
   :nrqzValidated boolean,
   :commonChannelGroup string,
   :nrqzValidation
   {:cpiId string,
    :latitude number,
    :state [STATE_UNSPECIFIED DRAFT FINAL],
    :longitude number,
    :caseId string},
   :interferenceCoordinationGroup string},
  :grants
  [{:moveList
    [{:frequencyRange
      {:highFrequencyMhz number, :lowFrequencyMhz number},
      :dpaId string}],
    :lastHeartbeatTransmitExpireTime string,
    :state
    [GRANT_STATE_UNSPECIFIED
     GRANT_STATE_GRANTED
     GRANT_STATE_TERMINATED
     GRANT_STATE_SUSPENDED
     GRANT_STATE_AUTHORIZED
     GRANT_STATE_EXPIRED],
    :grantId string,
    :frequencyRange
    {:highFrequencyMhz number, :lowFrequencyMhz number},
    :expireTime string,
    :suspensionReason [string],
    :maxEirp number,
    :channelType
    [CHANNEL_TYPE_UNSPECIFIED CHANNEL_TYPE_GAA CHANNEL_TYPE_PAL]}],
  :preloadedConfig
  {:category
   [DEVICE_CATEGORY_UNSPECIFIED DEVICE_CATEGORY_A DEVICE_CATEGORY_B],
   :installationParams
   {:antennaDowntilt integer,
    :cpeCbsdIndication boolean,
    :indoorDeployment boolean,
    :eirpCapability integer,
    :heightType
    [HEIGHT_TYPE_UNSPECIFIED HEIGHT_TYPE_AGL HEIGHT_TYPE_AMSL],
    :antennaGain number,
    :antennaModel string,
    :horizontalAccuracy number,
    :longitude number,
    :antennaBeamwidth integer,
    :verticalAccuracy number,
    :latitude number,
    :antennaAzimuth integer,
    :height number},
   :state [DEVICE_CONFIG_STATE_UNSPECIFIED DRAFT FINAL],
   :measurementCapabilities
   [[MEASUREMENT_CAPABILITY_UNSPECIFIED
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITH_GRANT
     MEASUREMENT_CAPABILITY_RECEIVED_POWER_WITHOUT_GRANT]],
   :updateTime string,
   :callSign string,
   :userId string,
   :isSigned boolean,
   :airInterface
   {:radioTechnology
    [RADIO_TECHNOLOGY_UNSPECIFIED
     E_UTRA
     CAMBIUM_NETWORKS
     FOUR_G_BBW_SAA_1
     NR
     DOODLE_CBRS
     CW
     REDLINE
     TARANA_WIRELESS],
    :supportedSpec string},
   :model
   {:firmwareVersion string,
    :name string,
    :vendor string,
    :hardwareVersion string,
    :softwareVersion string}},
  :currentChannels
  [{:frequencyRange
    {:highFrequencyMhz number, :lowFrequencyMhz number},
    :score number}],
  :fccId string}}"
  [name SasPortalSignDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:signDevice",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalSignDeviceRequest}))

(defn deployments-devices-updateSigned
  "Updates a signed device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/deployments/devices/updateSigned

name <string> Required. The name of the device to update.
SasPortalUpdateSignedDeviceRequest:
{:encodedDevice string, :installerId string}"
  [name SasPortalUpdateSignedDeviceRequest]
  (client/api-request
    {:method "PATCH",
     :uri-template
     "https://sasportal.googleapis.com/v1alpha1/{+name}:updateSigned",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"],
     :body SasPortalUpdateSignedDeviceRequest}))

(defn deployments-devices-delete
  "Deletes a device.
https://developers.google.com/spectrum-access-system/reference/rest/v1alpha1/deployments/devices/delete

name <string> Required. The name of the device."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://sasportal.googleapis.com/v1alpha1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/sasportal"]}))

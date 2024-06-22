(ns happygapi2.androiddeviceprovisioning
  "Android Device Provisioning Partner API
Automates Android zero-touch enrollment for device resellers, customers, and EMMs.
See: https://developers.google.com/zero-touch/"
  (:require [happy.oauth2.client :as client]))

(defn operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://developers.google.com/zero-touch/reference/rest/v1/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn partners-devices-get
  "Gets a device.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/get

name <string> Required. The device API resource name in the format `partners/[PARTNER_ID]/devices/[DEVICE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn partners-devices-findByOwner
  "Finds devices claimed for customers. The results only contain devices registered to the reseller that's identified by the `partnerId` argument. The customer's devices purchased from other resellers don't appear in the results.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/findByOwner

partnerId <string> Required. The ID of the reseller partner.
FindDevicesByOwnerRequest:
{:customerId [string],
 :googleWorkspaceCustomerId [string],
 :pageToken string,
 :sectionType
 [SECTION_TYPE_UNSPECIFIED
  SECTION_TYPE_SIM_LOCK
  SECTION_TYPE_ZERO_TOUCH],
 :limit string}"
  [partnerId FindDevicesByOwnerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:findByOwner",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body FindDevicesByOwnerRequest}))

(defn partners-devices-getSimLockState
  "Gets a device's SIM lock state.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/getSimLockState

partnerId <string> Required. The ID of the partner.
GetDeviceSimLockStateRequest:
{:deviceIdentifier
 {:manufacturer string,
  :chromeOsAttestedDeviceId string,
  :imei string,
  :model string,
  :serialNumber string,
  :deviceType
  [DEVICE_TYPE_UNSPECIFIED DEVICE_TYPE_ANDROID DEVICE_TYPE_CHROME_OS],
  :meid string}}"
  [partnerId GetDeviceSimLockStateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:getSimLockState",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body GetDeviceSimLockStateRequest}))

(defn partners-devices-findByIdentifier
  "Finds devices by hardware identifiers, such as IMEI.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/findByIdentifier

partnerId <string> Required. The ID of the reseller partner.
FindDevicesByDeviceIdentifierRequest:
{:limit string,
 :deviceIdentifier
 {:manufacturer string,
  :chromeOsAttestedDeviceId string,
  :imei string,
  :model string,
  :serialNumber string,
  :deviceType
  [DEVICE_TYPE_UNSPECIFIED DEVICE_TYPE_ANDROID DEVICE_TYPE_CHROME_OS],
  :meid string},
 :pageToken string}"
  [partnerId FindDevicesByDeviceIdentifierRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:findByIdentifier",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body FindDevicesByDeviceIdentifierRequest}))

(defn partners-devices-unclaim
  "Unclaims a device from a customer and removes it from zero-touch enrollment.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/unclaim

partnerId <string> Required. The ID of the reseller partner.
UnclaimDeviceRequest:
{:deviceIdentifier
 {:manufacturer string,
  :chromeOsAttestedDeviceId string,
  :imei string,
  :model string,
  :serialNumber string,
  :deviceType
  [DEVICE_TYPE_UNSPECIFIED DEVICE_TYPE_ANDROID DEVICE_TYPE_CHROME_OS],
  :meid string},
 :vacationModeExpireTime string,
 :deviceId string,
 :vacationModeDays integer,
 :sectionType
 [SECTION_TYPE_UNSPECIFIED
  SECTION_TYPE_SIM_LOCK
  SECTION_TYPE_ZERO_TOUCH]}"
  [partnerId UnclaimDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:unclaim",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body UnclaimDeviceRequest}))

(defn partners-devices-claimAsync
  "Claims a batch of devices for a customer asynchronously. Adds the devices to zero-touch enrollment. To learn more, read [Long‑running batch operations](/zero-touch/guides/how-it-works#operations).
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/claimAsync

partnerId <string> Required. The ID of the reseller partner.
ClaimDevicesRequest:
{:claims
 [{:preProvisioningToken string,
   :customerId string,
   :configurationId string,
   :sectionType
   [SECTION_TYPE_UNSPECIFIED
    SECTION_TYPE_SIM_LOCK
    SECTION_TYPE_ZERO_TOUCH],
   :deviceMetadata {:entries object},
   :simlockProfileId string,
   :googleWorkspaceCustomerId string,
   :deviceIdentifier
   {:manufacturer string,
    :chromeOsAttestedDeviceId string,
    :imei string,
    :model string,
    :serialNumber string,
    :deviceType
    [DEVICE_TYPE_UNSPECIFIED
     DEVICE_TYPE_ANDROID
     DEVICE_TYPE_CHROME_OS],
    :meid string}}]}"
  [partnerId ClaimDevicesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:claimAsync",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body ClaimDevicesRequest}))

(defn partners-devices-updateMetadataAsync
  "Updates the reseller metadata attached to a batch of devices. This method updates devices asynchronously and returns an `Operation` that can be used to track progress. Read [Long‑running batch operations](/zero-touch/guides/how-it-works#operations). Android Devices only.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/updateMetadataAsync

partnerId <string> Required. The reseller partner ID.
UpdateDeviceMetadataInBatchRequest:
{:updates
 [{:deviceId string,
   :deviceIdentifier
   {:manufacturer string,
    :chromeOsAttestedDeviceId string,
    :imei string,
    :model string,
    :serialNumber string,
    :deviceType
    [DEVICE_TYPE_UNSPECIFIED
     DEVICE_TYPE_ANDROID
     DEVICE_TYPE_CHROME_OS],
    :meid string},
   :deviceMetadata {:entries object}}]}"
  [partnerId UpdateDeviceMetadataInBatchRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:updateMetadataAsync",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body UpdateDeviceMetadataInBatchRequest}))

(defn partners-devices-unclaimAsync
  "Unclaims a batch of devices for a customer asynchronously. Removes the devices from zero-touch enrollment. To learn more, read [Long‑running batch operations](/zero-touch/guides/how-it-works#operations).
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/unclaimAsync

partnerId <string> Required. The reseller partner ID.
UnclaimDevicesRequest:
{:unclaims
 [{:deviceIdentifier
   {:manufacturer string,
    :chromeOsAttestedDeviceId string,
    :imei string,
    :model string,
    :serialNumber string,
    :deviceType
    [DEVICE_TYPE_UNSPECIFIED
     DEVICE_TYPE_ANDROID
     DEVICE_TYPE_CHROME_OS],
    :meid string},
   :vacationModeExpireTime string,
   :vacationModeDays integer,
   :sectionType
   [SECTION_TYPE_UNSPECIFIED
    SECTION_TYPE_SIM_LOCK
    SECTION_TYPE_ZERO_TOUCH],
   :deviceId string}]}"
  [partnerId UnclaimDevicesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:unclaimAsync",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body UnclaimDevicesRequest}))

(defn partners-devices-metadata
  "Updates reseller metadata associated with the device. Android devices only.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/metadata

metadataOwnerId <string> Required. The owner of the newly set metadata. Set this to the partner ID.
deviceId <string> Required. The ID of the device.
UpdateDeviceMetadataRequest:
{:deviceMetadata {:entries object}}"
  [metadataOwnerId deviceId UpdateDeviceMetadataRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+metadataOwnerId}/devices/{+deviceId}/metadata",
     :uri-template-args
     {:deviceId deviceId, :metadataOwnerId metadataOwnerId},
     :query-params {},
     :scopes nil,
     :body UpdateDeviceMetadataRequest}))

(defn partners-devices-claim
  "Claims a device for a customer and adds it to zero-touch enrollment. If the device is already claimed by another customer, the call returns an error.
https://developers.google.com/zero-touch/reference/rest/v1/partners/devices/claim

partnerId <string> Required. The ID of the reseller partner.
ClaimDeviceRequest:
{:simlockProfileId string,
 :sectionType
 [SECTION_TYPE_UNSPECIFIED
  SECTION_TYPE_SIM_LOCK
  SECTION_TYPE_ZERO_TOUCH],
 :customerId string,
 :configurationId string,
 :googleWorkspaceCustomerId string,
 :preProvisioningToken string,
 :deviceMetadata {:entries object},
 :deviceIdentifier
 {:manufacturer string,
  :chromeOsAttestedDeviceId string,
  :imei string,
  :model string,
  :serialNumber string,
  :deviceType
  [DEVICE_TYPE_UNSPECIFIED DEVICE_TYPE_ANDROID DEVICE_TYPE_CHROME_OS],
  :meid string}}"
  [partnerId ClaimDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/devices:claim",
     :uri-template-args {:partnerId partnerId},
     :query-params {},
     :scopes nil,
     :body ClaimDeviceRequest}))

(defn partners-customers-list
  "Lists the customers that are enrolled to the reseller identified by the `partnerId` argument. This list includes customers that the reseller created and customers that enrolled themselves using the portal.
https://developers.google.com/zero-touch/reference/rest/v1/partners/customers/list

partnerId <string> Required. The ID of the reseller partner.

optional:
pageSize <integer> The maximum number of results to be returned. If not specified or 0, all the records are returned."
  ([partnerId] (partners-customers-list partnerId nil))
  ([partnerId optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androiddeviceprovisioning.googleapis.com/v1/partners/{+partnerId}/customers",
       :uri-template-args {:partnerId partnerId},
       :query-params (merge {} optional),
       :scopes nil})))

(defn partners-customers-create
  "Creates a customer for zero-touch enrollment. After the method returns successfully, admin and owner roles can manage devices and EMM configs by calling API methods or using their zero-touch enrollment portal. The customer receives an email that welcomes them to zero-touch enrollment and explains how to sign into the portal.
https://developers.google.com/zero-touch/reference/rest/v1/partners/customers/create

parent <string> Required. The parent resource ID in the format `partners/[PARTNER_ID]` that identifies the reseller.
CreateCustomerRequest:
{:customer
 {:companyId string,
  :skipWelcomeEmail boolean,
  :termsStatus
  [TERMS_STATUS_UNSPECIFIED
   TERMS_STATUS_NOT_ACCEPTED
   TERMS_STATUS_ACCEPTED
   TERMS_STATUS_STALE],
  :name string,
  :ownerEmails [string],
  :googleWorkspaceAccount
  {:preProvisioningTokens [string], :customerId string},
  :languageCode string,
  :companyName string,
  :adminEmails [string]}}"
  [parent CreateCustomerRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/customers",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body CreateCustomerRequest}))

(defn partners-vendors-list
  "Lists the vendors of the partner.
https://developers.google.com/zero-touch/reference/rest/v1/partners/vendors/list

parent <string> Required. The resource name in the format `partners/[PARTNER_ID]`.

optional:
pageSize <integer> The maximum number of results to be returned."
  ([parent] (partners-vendors-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/vendors",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn partners-vendors-customers-list
  "Lists the customers of the vendor.
https://developers.google.com/zero-touch/reference/rest/v1/partners/vendors/customers/list

parent <string> Required. The resource name in the format `partners/[PARTNER_ID]/vendors/[VENDOR_ID]`.

optional:
pageSize <integer> The maximum number of results to be returned."
  ([parent] (partners-vendors-customers-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/customers",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn customers-list
  "Lists the user's customer accounts.
https://developers.google.com/zero-touch/reference/rest/v1/customers/list

optional:
pageSize <integer> The maximum number of customers to show in a page of results. A number between 1 and 100 (inclusive)."
  ([] (customers-list nil))
  ([optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androiddeviceprovisioning.googleapis.com/v1/customers",
       :uri-template-args {},
       :query-params (merge {} optional),
       :scopes nil})))

(defn customers-dpcs-list
  "Lists the DPCs (device policy controllers) that support zero-touch enrollment.
https://developers.google.com/zero-touch/reference/rest/v1/customers/dpcs/list

parent <string> Required. The customer that can use the DPCs in configurations. An API resource name in the format `customers/[CUSTOMER_ID]`."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/dpcs",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil}))

(defn customers-configurations-patch
  "Updates a configuration's field values.
https://developers.google.com/zero-touch/reference/rest/v1/customers/configurations/patch

name <string> Output only. The API resource name in the format `customers/[CUSTOMER_ID]/configurations/[CONFIGURATION_ID]`. Assigned by the server.
Configuration:
{:isDefault boolean,
 :configurationName string,
 :dpcExtras string,
 :name string,
 :customMessage string,
 :contactEmail string,
 :configurationId string,
 :companyName string,
 :forcedResetTime string,
 :dpcResourcePath string,
 :contactPhone string}

optional:
updateMask <string> Required. The field mask applied to the target `Configuration` before updating the fields. To learn more about using field masks, read [FieldMask](/protocol-buffers/docs/reference/google.protobuf#fieldmask) in the Protocol Buffers documentation."
  ([name Configuration]
    (customers-configurations-patch name Configuration nil))
  ([name Configuration optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://androiddeviceprovisioning.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes nil,
       :body Configuration})))

(defn customers-configurations-get
  "Gets the details of a configuration.
https://developers.google.com/zero-touch/reference/rest/v1/customers/configurations/get

name <string> Required. The configuration to get. An API resource name in the format `customers/[CUSTOMER_ID]/configurations/[CONFIGURATION_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn customers-configurations-list
  "Lists a customer's configurations.
https://developers.google.com/zero-touch/reference/rest/v1/customers/configurations/list

parent <string> Required. The customer that manages the listed configurations. An API resource name in the format `customers/[CUSTOMER_ID]`."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/configurations",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil}))

(defn customers-configurations-delete
  "Deletes an unused configuration. The API call fails if the customer has devices with the configuration applied.
https://developers.google.com/zero-touch/reference/rest/v1/customers/configurations/delete

name <string> Required. The configuration to delete. An API resource name in the format `customers/[CUSTOMER_ID]/configurations/[CONFIGURATION_ID]`. If the configuration is applied to any devices, the API call fails."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn customers-configurations-create
  "Creates a new configuration. Once created, a customer can apply the configuration to devices.
https://developers.google.com/zero-touch/reference/rest/v1/customers/configurations/create

parent <string> Required. The customer that manages the configuration. An API resource name in the format `customers/[CUSTOMER_ID]`. This field has custom validation in CreateConfigurationRequestValidator
Configuration:
{:isDefault boolean,
 :configurationName string,
 :dpcExtras string,
 :name string,
 :customMessage string,
 :contactEmail string,
 :configurationId string,
 :companyName string,
 :forcedResetTime string,
 :dpcResourcePath string,
 :contactPhone string}"
  [parent Configuration]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/configurations",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body Configuration}))

(defn customers-devices-list
  "Lists a customer's devices.
https://developers.google.com/zero-touch/reference/rest/v1/customers/devices/list

parent <string> Required. The customer managing the devices. An API resource name in the format `customers/[CUSTOMER_ID]`.

optional:
pageSize <string> The maximum number of devices to show in a page of results. Must be between 1 and 100 inclusive."
  ([parent] (customers-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes nil})))

(defn customers-devices-unclaim
  "Unclaims a device from a customer and removes it from zero-touch enrollment. After removing a device, a customer must contact their reseller to register the device into zero-touch enrollment again.
https://developers.google.com/zero-touch/reference/rest/v1/customers/devices/unclaim

parent <string> Required. The customer managing the device. An API resource name in the format `customers/[CUSTOMER_ID]`.
CustomerUnclaimDeviceRequest:
{:device
 {:deviceIdentifier
  {:manufacturer string,
   :chromeOsAttestedDeviceId string,
   :imei string,
   :model string,
   :serialNumber string,
   :deviceType
   [DEVICE_TYPE_UNSPECIFIED DEVICE_TYPE_ANDROID DEVICE_TYPE_CHROME_OS],
   :meid string},
  :deviceId string}}"
  [parent CustomerUnclaimDeviceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/devices:unclaim",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body CustomerUnclaimDeviceRequest}))

(defn customers-devices-removeConfiguration
  "Removes a configuration from device.
https://developers.google.com/zero-touch/reference/rest/v1/customers/devices/removeConfiguration

parent <string> Required. The customer managing the device in the format `customers/[CUSTOMER_ID]`.
CustomerRemoveConfigurationRequest:
{:device
 {:deviceIdentifier
  {:manufacturer string,
   :chromeOsAttestedDeviceId string,
   :imei string,
   :model string,
   :serialNumber string,
   :deviceType
   [DEVICE_TYPE_UNSPECIFIED DEVICE_TYPE_ANDROID DEVICE_TYPE_CHROME_OS],
   :meid string},
  :deviceId string}}"
  [parent CustomerRemoveConfigurationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/devices:removeConfiguration",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body CustomerRemoveConfigurationRequest}))

(defn customers-devices-get
  "Gets the details of a device.
https://developers.google.com/zero-touch/reference/rest/v1/customers/devices/get

name <string> Required. The device to get. An API resource name in the format `customers/[CUSTOMER_ID]/devices/[DEVICE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes nil}))

(defn customers-devices-applyConfiguration
  "Applies a Configuration to the device to register the device for zero-touch enrollment. After applying a configuration to a device, the device automatically provisions itself on first boot, or next factory reset.
https://developers.google.com/zero-touch/reference/rest/v1/customers/devices/applyConfiguration

parent <string> Required. The customer managing the device. An API resource name in the format `customers/[CUSTOMER_ID]`.
CustomerApplyConfigurationRequest:
{:configuration string,
 :device
 {:deviceIdentifier
  {:manufacturer string,
   :chromeOsAttestedDeviceId string,
   :imei string,
   :model string,
   :serialNumber string,
   :deviceType
   [DEVICE_TYPE_UNSPECIFIED DEVICE_TYPE_ANDROID DEVICE_TYPE_CHROME_OS],
   :meid string},
  :deviceId string}}"
  [parent CustomerApplyConfigurationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://androiddeviceprovisioning.googleapis.com/v1/{+parent}/devices:applyConfiguration",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes nil,
     :body CustomerApplyConfigurationRequest}))

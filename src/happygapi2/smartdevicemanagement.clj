(ns happygapi2.smartdevicemanagement
  "Smart Device Management API
Allow select enterprise partners to access, control, and manage Google and Nest devices programmatically.
See: https://developers.google.com/nest/device-access"
  (:require [happy.oauth2.client :as client]))

(defn enterprises-structures-get
  "Gets a structure managed by the enterprise.
https://developers.google.com/nest/device-access/reference/rest/v1/enterprises.structures/get

name <string> The name of the structure requested. For example: \"enterprises/XYZ/structures/ABC\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://smartdevicemanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/sdm.service"]}))

(defn enterprises-structures-list
  "Lists structures managed by the enterprise.
https://developers.google.com/nest/device-access/reference/rest/v1/enterprises.structures/list

parent <string> The parent enterprise to list structures under. E.g. \"enterprises/XYZ\".

optional:
filter <string> Optional filter to list structures."
  ([parent] (enterprises-structures-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://smartdevicemanagement.googleapis.com/v1/{+parent}/structures",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/sdm.service"]})))

(defn enterprises-structures-rooms-list
  "Lists rooms managed by the enterprise.
https://developers.google.com/nest/device-access/reference/rest/v1/enterprises.structures.rooms/list

parent <string> The parent resource name of the rooms requested. For example: \"enterprises/XYZ/structures/ABC\"."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://smartdevicemanagement.googleapis.com/v1/{+parent}/rooms",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/sdm.service"]}))

(defn enterprises-structures-rooms-get
  "Gets a room managed by the enterprise.
https://developers.google.com/nest/device-access/reference/rest/v1/enterprises.structures.rooms/get

name <string> The name of the room requested. For example: \"enterprises/XYZ/structures/ABC/rooms/123\"."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://smartdevicemanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/sdm.service"]}))

(defn enterprises-devices-executeCommand
  "Executes a command to device managed by the enterprise.
https://developers.google.com/nest/device-access/reference/rest/v1/enterprises.devices/executeCommand

name <string> The name of the device requested. For example: \"enterprises/XYZ/devices/123\"
GoogleHomeEnterpriseSdmV1ExecuteDeviceCommandRequest:
{:command string, :params object}"
  [name GoogleHomeEnterpriseSdmV1ExecuteDeviceCommandRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://smartdevicemanagement.googleapis.com/v1/{+name}:executeCommand",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/sdm.service"],
     :body GoogleHomeEnterpriseSdmV1ExecuteDeviceCommandRequest}))

(defn enterprises-devices-get
  "Gets a device managed by the enterprise.
https://developers.google.com/nest/device-access/reference/rest/v1/enterprises.devices/get

name <string> The name of the device requested. For example: \"enterprises/XYZ/devices/123\""
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://smartdevicemanagement.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/sdm.service"]}))

(defn enterprises-devices-list
  "Lists devices managed by the enterprise.
https://developers.google.com/nest/device-access/reference/rest/v1/enterprises.devices/list

parent <string> The parent enterprise to list devices under. E.g. \"enterprises/XYZ\".

optional:
filter <string> Optional filter to list devices. Filters can be done on: Device custom name (substring match): 'customName=wing'"
  ([parent] (enterprises-devices-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://smartdevicemanagement.googleapis.com/v1/{+parent}/devices",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/sdm.service"]})))

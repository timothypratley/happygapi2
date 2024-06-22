(ns happygapi2.cloudkms
  "Cloud Key Management Service (KMS) API
Manages keys and performs cryptographic operations in a central cloud service, for direct use by other cloud resources and applications. 
See: https://cloud.google.com/security/products/security-key-management"
  (:require [happy.oauth2.client :as client]))

(defn folders-updateAutokeyConfig
  "Updates the AutokeyConfig for a folder. The caller must have both `cloudkms.autokeyConfigs.update` permission on the parent folder and `cloudkms.cryptoKeys.setIamPolicy` permission on the provided key project. A KeyHandle creation in the folder's descendant projects will use this configuration to determine where to create the resulting CryptoKey.
https://cloud.google.com/security/products/security-key-management/v1/docs/folders/updateAutokeyConfig

name <string> Identifier. Name of the AutokeyConfig resource, e.g. `folders/{FOLDER_NUMBER}/autokeyConfig`.
AutokeyConfig:
{:name string, :keyProject string}

optional:
updateMask <string> Required. Masks which fields of the AutokeyConfig to update, e.g. `keyProject`."
  ([name AutokeyConfig]
    (folders-updateAutokeyConfig name AutokeyConfig nil))
  ([name AutokeyConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body AutokeyConfig})))

(defn folders-getAutokeyConfig
  "Returns the AutokeyConfig for a folder.
https://cloud.google.com/security/products/security-key-management/v1/docs/folders/getAutokeyConfig

name <string> Required. Name of the AutokeyConfig resource, e.g. `folders/{FOLDER_NUMBER}/autokeyConfig`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-showEffectiveAutokeyConfig
  "Returns the effective Cloud KMS Autokey configuration for a given project.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/showEffectiveAutokeyConfig

parent <string> Required. Name of the resource project to the show effective Cloud KMS Autokey configuration for. This may be helpful for interrogating the effect of nested folder configurations on a given resource project."
  [parent]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+parent}:showEffectiveAutokeyConfig",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-getEkmConfig
  "Returns the EkmConfig singleton resource for a given project and location.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/getEkmConfig

name <string> Required. The name of the EkmConfig to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-updateEkmConfig
  "Updates the EkmConfig singleton resource for a given project and location.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/updateEkmConfig

name <string> Output only. The resource name for the EkmConfig in the format `projects/*/locations/*/ekmConfig`.
EkmConfig:
{:name string, :defaultEkmConnection string}

optional:
updateMask <string> Required. List of fields to be updated in this request."
  ([name EkmConfig]
    (projects-locations-updateEkmConfig name EkmConfig nil))
  ([name EkmConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body EkmConfig})))

(defn projects-locations-generateRandomBytes
  "Generate random bytes using the Cloud KMS randomness source in the provided location.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/generateRandomBytes

location <string> The project-specific location in which to generate random bytes. For example, \"projects/my-project/locations/us-central1\".
GenerateRandomBytesRequest:
{:lengthBytes integer,
 :protectionLevel
 [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC]}"
  [location GenerateRandomBytesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+location}:generateRandomBytes",
     :uri-template-args {:location location},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body GenerateRandomBytesRequest}))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-keyHandles-create
  "Creates a new KeyHandle, triggering the provisioning of a new CryptoKey for CMEK use with the given resource type in the configured key project and the same location. GetOperation should be used to resolve the resulting long-running operation and get the resulting KeyHandle and CryptoKey.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyHandles/create

parent <string> Required. Name of the resource project and location to create the KeyHandle in, e.g. `projects/{PROJECT_ID}/locations/{LOCATION}`.
KeyHandle:
{:name string, :kmsKey string, :resourceTypeSelector string}

optional:
keyHandleId <string> Optional. Id of the KeyHandle. Must be unique to the resource project and location. If not provided by the caller, a new UUID is used."
  ([parent KeyHandle]
    (projects-locations-keyHandles-create parent KeyHandle nil))
  ([parent KeyHandle optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/keyHandles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body KeyHandle})))

(defn projects-locations-keyHandles-get
  "Returns the KeyHandle.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyHandles/get

name <string> Required. Name of the KeyHandle resource, e.g. `projects/{PROJECT_ID}/locations/{LOCATION}/keyHandles/{KEY_HANDLE_ID}`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-keyHandles-list
  "Lists KeyHandles.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyHandles/list

parent <string> Required. Name of the resource project and location from which to list KeyHandles, e.g. `projects/{PROJECT_ID}/locations/{LOCATION}`.

optional:
filter <string> Optional. Filter to apply when listing KeyHandles, e.g. `resource_type_selector=\"{SERVICE}.googleapis.com/{TYPE}\"`."
  ([parent] (projects-locations-keyHandles-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/keyHandles",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-ekmConnections-list
  "Lists EkmConnections.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/list

parent <string> Required. The resource name of the location associated with the EkmConnections to list, in the format `projects/*/locations/*`.

optional:
pageSize <integer> Optional. Optional limit on the number of EkmConnections to include in the response. Further EkmConnections can subsequently be obtained by including the ListEkmConnectionsResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering).
orderBy <string> Optional. Specify how the results should be sorted. If not specified, the results will be sorted in the default order. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering)."
  ([parent] (projects-locations-ekmConnections-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/ekmConnections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-ekmConnections-get
  "Returns metadata for a given EkmConnection.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/get

name <string> Required. The name of the EkmConnection to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-ekmConnections-create
  "Creates a new EkmConnection in a given Project and Location.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/create

parent <string> Required. The resource name of the location associated with the EkmConnection, in the format `projects/*/locations/*`.
EkmConnection:
{:name string,
 :createTime string,
 :serviceResolvers
 [{:serviceDirectoryService string,
   :endpointFilter string,
   :hostname string,
   :serverCertificates
   [{:serialNumber string,
     :rawDer string,
     :notBeforeTime string,
     :subjectAlternativeDnsNames [string],
     :sha256Fingerprint string,
     :issuer string,
     :notAfterTime string,
     :parsed boolean,
     :subject string}]}],
 :etag string,
 :keyManagementMode [KEY_MANAGEMENT_MODE_UNSPECIFIED MANUAL CLOUD_KMS],
 :cryptoSpacePath string}

optional:
ekmConnectionId <string> Required. It must be unique within a location and match the regular expression `[a-zA-Z0-9_-]{1,63}`."
  ([parent EkmConnection]
    (projects-locations-ekmConnections-create
      parent
      EkmConnection
      nil))
  ([parent EkmConnection optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/ekmConnections",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body EkmConnection})))

(defn projects-locations-ekmConnections-patch
  "Updates an EkmConnection's metadata.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/patch

name <string> Output only. The resource name for the EkmConnection in the format `projects/*/locations/*/ekmConnections/*`.
EkmConnection:
{:name string,
 :createTime string,
 :serviceResolvers
 [{:serviceDirectoryService string,
   :endpointFilter string,
   :hostname string,
   :serverCertificates
   [{:serialNumber string,
     :rawDer string,
     :notBeforeTime string,
     :subjectAlternativeDnsNames [string],
     :sha256Fingerprint string,
     :issuer string,
     :notAfterTime string,
     :parsed boolean,
     :subject string}]}],
 :etag string,
 :keyManagementMode [KEY_MANAGEMENT_MODE_UNSPECIFIED MANUAL CLOUD_KMS],
 :cryptoSpacePath string}

optional:
updateMask <string> Required. List of fields to be updated in this request."
  ([name EkmConnection]
    (projects-locations-ekmConnections-patch name EkmConnection nil))
  ([name EkmConnection optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body EkmConnection})))

(defn projects-locations-ekmConnections-verifyConnectivity
  "Verifies that Cloud KMS can successfully connect to the external key manager specified by an EkmConnection. If there is an error connecting to the EKM, this method returns a FAILED_PRECONDITION status containing structured information as described at https://cloud.google.com/kms/docs/reference/ekm_errors.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/verifyConnectivity

name <string> Required. The name of the EkmConnection to verify."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:verifyConnectivity",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-ekmConnections-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/setIamPolicy

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
     "https://cloudkms.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body SetIamPolicyRequest}))

(defn projects-locations-ekmConnections-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-ekmConnections-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-ekmConnections-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConnections/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-keyRings-list
  "Lists KeyRings.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/list

parent <string> Required. The resource name of the location associated with the KeyRings, in the format `projects/*/locations/*`.

optional:
pageSize <integer> Optional. Optional limit on the number of KeyRings to include in the response. Further KeyRings can subsequently be obtained by including the ListKeyRingsResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering).
orderBy <string> Optional. Specify how the results should be sorted. If not specified, the results will be sorted in the default order. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering)."
  ([parent] (projects-locations-keyRings-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/keyRings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-keyRings-get
  "Returns metadata for a given KeyRing.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/get

name <string> Required. The name of the KeyRing to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-keyRings-create
  "Create a new KeyRing in a given Project and Location.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/create

parent <string> Required. The resource name of the location associated with the KeyRings, in the format `projects/*/locations/*`.
KeyRing:
{:name string, :createTime string}

optional:
keyRingId <string> Required. It must be unique within a location and match the regular expression `[a-zA-Z0-9_-]{1,63}`"
  ([parent KeyRing]
    (projects-locations-keyRings-create parent KeyRing nil))
  ([parent KeyRing optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/keyRings",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body KeyRing})))

(defn projects-locations-keyRings-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/setIamPolicy

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
     "https://cloudkms.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body SetIamPolicyRequest}))

(defn projects-locations-keyRings-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-keyRings-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-keyRings-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-keyRings-cryptoKeys-get
  "Returns metadata for a given CryptoKey, as well as its primary CryptoKeyVersion.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/get

name <string> Required. The name of the CryptoKey to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-keyRings-cryptoKeys-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/setIamPolicy

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
     "https://cloudkms.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body SetIamPolicyRequest}))

(defn projects-locations-keyRings-cryptoKeys-patch
  "Update a CryptoKey.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/patch

name <string> Output only. The resource name for this CryptoKey in the format `projects/*/locations/*/keyRings/*/cryptoKeys/*`.
CryptoKey:
{:labels object,
 :nextRotationTime string,
 :importOnly boolean,
 :primary
 {:reimportEligible boolean,
  :algorithm
  [CRYPTO_KEY_VERSION_ALGORITHM_UNSPECIFIED
   GOOGLE_SYMMETRIC_ENCRYPTION
   AES_128_GCM
   AES_256_GCM
   AES_128_CBC
   AES_256_CBC
   AES_128_CTR
   AES_256_CTR
   RSA_SIGN_PSS_2048_SHA256
   RSA_SIGN_PSS_3072_SHA256
   RSA_SIGN_PSS_4096_SHA256
   RSA_SIGN_PSS_4096_SHA512
   RSA_SIGN_PKCS1_2048_SHA256
   RSA_SIGN_PKCS1_3072_SHA256
   RSA_SIGN_PKCS1_4096_SHA256
   RSA_SIGN_PKCS1_4096_SHA512
   RSA_SIGN_RAW_PKCS1_2048
   RSA_SIGN_RAW_PKCS1_3072
   RSA_SIGN_RAW_PKCS1_4096
   RSA_DECRYPT_OAEP_2048_SHA256
   RSA_DECRYPT_OAEP_3072_SHA256
   RSA_DECRYPT_OAEP_4096_SHA256
   RSA_DECRYPT_OAEP_4096_SHA512
   RSA_DECRYPT_OAEP_2048_SHA1
   RSA_DECRYPT_OAEP_3072_SHA1
   RSA_DECRYPT_OAEP_4096_SHA1
   EC_SIGN_P256_SHA256
   EC_SIGN_P384_SHA384
   EC_SIGN_SECP256K1_SHA256
   EC_SIGN_ED25519
   HMAC_SHA256
   HMAC_SHA1
   HMAC_SHA384
   HMAC_SHA512
   HMAC_SHA224
   EXTERNAL_SYMMETRIC_ENCRYPTION],
  :generateTime string,
  :generationFailureReason string,
  :importFailureReason string,
  :name string,
  :importTime string,
  :createTime string,
  :state
  [CRYPTO_KEY_VERSION_STATE_UNSPECIFIED
   PENDING_GENERATION
   ENABLED
   DISABLED
   DESTROYED
   DESTROY_SCHEDULED
   PENDING_IMPORT
   IMPORT_FAILED
   GENERATION_FAILED
   PENDING_EXTERNAL_DESTRUCTION
   EXTERNAL_DESTRUCTION_FAILED],
  :externalProtectionLevelOptions
  {:externalKeyUri string, :ekmConnectionKeyPath string},
  :importJob string,
  :attestation
  {:format
   [ATTESTATION_FORMAT_UNSPECIFIED
    CAVIUM_V1_COMPRESSED
    CAVIUM_V2_COMPRESSED],
   :content string,
   :certChains
   {:caviumCerts [string],
    :googleCardCerts [string],
    :googlePartitionCerts [string]}},
  :protectionLevel
  [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC],
  :externalDestructionFailureReason string,
  :destroyTime string,
  :destroyEventTime string},
 :purpose
 [CRYPTO_KEY_PURPOSE_UNSPECIFIED
  ENCRYPT_DECRYPT
  ASYMMETRIC_SIGN
  ASYMMETRIC_DECRYPT
  RAW_ENCRYPT_DECRYPT
  MAC],
 :name string,
 :createTime string,
 :rotationPeriod string,
 :versionTemplate
 {:protectionLevel
  [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC],
  :algorithm
  [CRYPTO_KEY_VERSION_ALGORITHM_UNSPECIFIED
   GOOGLE_SYMMETRIC_ENCRYPTION
   AES_128_GCM
   AES_256_GCM
   AES_128_CBC
   AES_256_CBC
   AES_128_CTR
   AES_256_CTR
   RSA_SIGN_PSS_2048_SHA256
   RSA_SIGN_PSS_3072_SHA256
   RSA_SIGN_PSS_4096_SHA256
   RSA_SIGN_PSS_4096_SHA512
   RSA_SIGN_PKCS1_2048_SHA256
   RSA_SIGN_PKCS1_3072_SHA256
   RSA_SIGN_PKCS1_4096_SHA256
   RSA_SIGN_PKCS1_4096_SHA512
   RSA_SIGN_RAW_PKCS1_2048
   RSA_SIGN_RAW_PKCS1_3072
   RSA_SIGN_RAW_PKCS1_4096
   RSA_DECRYPT_OAEP_2048_SHA256
   RSA_DECRYPT_OAEP_3072_SHA256
   RSA_DECRYPT_OAEP_4096_SHA256
   RSA_DECRYPT_OAEP_4096_SHA512
   RSA_DECRYPT_OAEP_2048_SHA1
   RSA_DECRYPT_OAEP_3072_SHA1
   RSA_DECRYPT_OAEP_4096_SHA1
   EC_SIGN_P256_SHA256
   EC_SIGN_P384_SHA384
   EC_SIGN_SECP256K1_SHA256
   EC_SIGN_ED25519
   HMAC_SHA256
   HMAC_SHA1
   HMAC_SHA384
   HMAC_SHA512
   HMAC_SHA224
   EXTERNAL_SYMMETRIC_ENCRYPTION]},
 :keyAccessJustificationsPolicy
 {:allowedAccessReasons
  [[REASON_UNSPECIFIED
    CUSTOMER_INITIATED_SUPPORT
    GOOGLE_INITIATED_SERVICE
    THIRD_PARTY_DATA_REQUEST
    GOOGLE_INITIATED_REVIEW
    CUSTOMER_INITIATED_ACCESS
    GOOGLE_INITIATED_SYSTEM_OPERATION
    REASON_NOT_EXPECTED
    MODIFIED_CUSTOMER_INITIATED_ACCESS
    MODIFIED_GOOGLE_INITIATED_SYSTEM_OPERATION
    GOOGLE_RESPONSE_TO_PRODUCTION_ALERT
    CUSTOMER_AUTHORIZED_WORKFLOW_SERVICING]]},
 :cryptoKeyBackend string,
 :destroyScheduledDuration string}

optional:
updateMask <string> Required. List of fields to be updated in this request."
  ([name CryptoKey]
    (projects-locations-keyRings-cryptoKeys-patch name CryptoKey nil))
  ([name CryptoKey optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body CryptoKey})))

(defn projects-locations-keyRings-cryptoKeys-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-keyRings-cryptoKeys-create
  "Create a new CryptoKey within a KeyRing. CryptoKey.purpose and CryptoKey.version_template.algorithm are required.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/create

parent <string> Required. The name of the KeyRing associated with the CryptoKeys.
CryptoKey:
{:labels object,
 :nextRotationTime string,
 :importOnly boolean,
 :primary
 {:reimportEligible boolean,
  :algorithm
  [CRYPTO_KEY_VERSION_ALGORITHM_UNSPECIFIED
   GOOGLE_SYMMETRIC_ENCRYPTION
   AES_128_GCM
   AES_256_GCM
   AES_128_CBC
   AES_256_CBC
   AES_128_CTR
   AES_256_CTR
   RSA_SIGN_PSS_2048_SHA256
   RSA_SIGN_PSS_3072_SHA256
   RSA_SIGN_PSS_4096_SHA256
   RSA_SIGN_PSS_4096_SHA512
   RSA_SIGN_PKCS1_2048_SHA256
   RSA_SIGN_PKCS1_3072_SHA256
   RSA_SIGN_PKCS1_4096_SHA256
   RSA_SIGN_PKCS1_4096_SHA512
   RSA_SIGN_RAW_PKCS1_2048
   RSA_SIGN_RAW_PKCS1_3072
   RSA_SIGN_RAW_PKCS1_4096
   RSA_DECRYPT_OAEP_2048_SHA256
   RSA_DECRYPT_OAEP_3072_SHA256
   RSA_DECRYPT_OAEP_4096_SHA256
   RSA_DECRYPT_OAEP_4096_SHA512
   RSA_DECRYPT_OAEP_2048_SHA1
   RSA_DECRYPT_OAEP_3072_SHA1
   RSA_DECRYPT_OAEP_4096_SHA1
   EC_SIGN_P256_SHA256
   EC_SIGN_P384_SHA384
   EC_SIGN_SECP256K1_SHA256
   EC_SIGN_ED25519
   HMAC_SHA256
   HMAC_SHA1
   HMAC_SHA384
   HMAC_SHA512
   HMAC_SHA224
   EXTERNAL_SYMMETRIC_ENCRYPTION],
  :generateTime string,
  :generationFailureReason string,
  :importFailureReason string,
  :name string,
  :importTime string,
  :createTime string,
  :state
  [CRYPTO_KEY_VERSION_STATE_UNSPECIFIED
   PENDING_GENERATION
   ENABLED
   DISABLED
   DESTROYED
   DESTROY_SCHEDULED
   PENDING_IMPORT
   IMPORT_FAILED
   GENERATION_FAILED
   PENDING_EXTERNAL_DESTRUCTION
   EXTERNAL_DESTRUCTION_FAILED],
  :externalProtectionLevelOptions
  {:externalKeyUri string, :ekmConnectionKeyPath string},
  :importJob string,
  :attestation
  {:format
   [ATTESTATION_FORMAT_UNSPECIFIED
    CAVIUM_V1_COMPRESSED
    CAVIUM_V2_COMPRESSED],
   :content string,
   :certChains
   {:caviumCerts [string],
    :googleCardCerts [string],
    :googlePartitionCerts [string]}},
  :protectionLevel
  [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC],
  :externalDestructionFailureReason string,
  :destroyTime string,
  :destroyEventTime string},
 :purpose
 [CRYPTO_KEY_PURPOSE_UNSPECIFIED
  ENCRYPT_DECRYPT
  ASYMMETRIC_SIGN
  ASYMMETRIC_DECRYPT
  RAW_ENCRYPT_DECRYPT
  MAC],
 :name string,
 :createTime string,
 :rotationPeriod string,
 :versionTemplate
 {:protectionLevel
  [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC],
  :algorithm
  [CRYPTO_KEY_VERSION_ALGORITHM_UNSPECIFIED
   GOOGLE_SYMMETRIC_ENCRYPTION
   AES_128_GCM
   AES_256_GCM
   AES_128_CBC
   AES_256_CBC
   AES_128_CTR
   AES_256_CTR
   RSA_SIGN_PSS_2048_SHA256
   RSA_SIGN_PSS_3072_SHA256
   RSA_SIGN_PSS_4096_SHA256
   RSA_SIGN_PSS_4096_SHA512
   RSA_SIGN_PKCS1_2048_SHA256
   RSA_SIGN_PKCS1_3072_SHA256
   RSA_SIGN_PKCS1_4096_SHA256
   RSA_SIGN_PKCS1_4096_SHA512
   RSA_SIGN_RAW_PKCS1_2048
   RSA_SIGN_RAW_PKCS1_3072
   RSA_SIGN_RAW_PKCS1_4096
   RSA_DECRYPT_OAEP_2048_SHA256
   RSA_DECRYPT_OAEP_3072_SHA256
   RSA_DECRYPT_OAEP_4096_SHA256
   RSA_DECRYPT_OAEP_4096_SHA512
   RSA_DECRYPT_OAEP_2048_SHA1
   RSA_DECRYPT_OAEP_3072_SHA1
   RSA_DECRYPT_OAEP_4096_SHA1
   EC_SIGN_P256_SHA256
   EC_SIGN_P384_SHA384
   EC_SIGN_SECP256K1_SHA256
   EC_SIGN_ED25519
   HMAC_SHA256
   HMAC_SHA1
   HMAC_SHA384
   HMAC_SHA512
   HMAC_SHA224
   EXTERNAL_SYMMETRIC_ENCRYPTION]},
 :keyAccessJustificationsPolicy
 {:allowedAccessReasons
  [[REASON_UNSPECIFIED
    CUSTOMER_INITIATED_SUPPORT
    GOOGLE_INITIATED_SERVICE
    THIRD_PARTY_DATA_REQUEST
    GOOGLE_INITIATED_REVIEW
    CUSTOMER_INITIATED_ACCESS
    GOOGLE_INITIATED_SYSTEM_OPERATION
    REASON_NOT_EXPECTED
    MODIFIED_CUSTOMER_INITIATED_ACCESS
    MODIFIED_GOOGLE_INITIATED_SYSTEM_OPERATION
    GOOGLE_RESPONSE_TO_PRODUCTION_ALERT
    CUSTOMER_AUTHORIZED_WORKFLOW_SERVICING]]},
 :cryptoKeyBackend string,
 :destroyScheduledDuration string}

optional:
cryptoKeyId <string> Required. It must be unique within a KeyRing and match the regular expression `[a-zA-Z0-9_-]{1,63}`
skipInitialVersionCreation <boolean> If set to true, the request will create a CryptoKey without any CryptoKeyVersions. You must manually call CreateCryptoKeyVersion or ImportCryptoKeyVersion before you can use this CryptoKey."
  ([parent CryptoKey]
    (projects-locations-keyRings-cryptoKeys-create
      parent
      CryptoKey
      nil))
  ([parent CryptoKey optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/cryptoKeys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body CryptoKey})))

(defn projects-locations-keyRings-cryptoKeys-encrypt
  "Encrypts data, so that it can only be recovered by a call to Decrypt. The CryptoKey.purpose must be ENCRYPT_DECRYPT.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/encrypt

name <string> Required. The resource name of the CryptoKey or CryptoKeyVersion to use for encryption. If a CryptoKey is specified, the server will use its primary version.
EncryptRequest:
{:plaintext string,
 :additionalAuthenticatedData string,
 :plaintextCrc32c string,
 :additionalAuthenticatedDataCrc32c string}"
  [name EncryptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:encrypt",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body EncryptRequest}))

(defn projects-locations-keyRings-cryptoKeys-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-keyRings-cryptoKeys-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-keyRings-cryptoKeys-list
  "Lists CryptoKeys.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/list

parent <string> Required. The resource name of the KeyRing to list, in the format `projects/*/locations/*/keyRings/*`.

optional:
pageSize <integer> Optional. Optional limit on the number of CryptoKeys to include in the response. Further CryptoKeys can subsequently be obtained by including the ListCryptoKeysResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
versionView <string> The fields of the primary version to include in the response.
filter <string> Optional. Only include resources that match the filter in the response. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering).
orderBy <string> Optional. Specify how the results should be sorted. If not specified, the results will be sorted in the default order. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering)."
  ([parent] (projects-locations-keyRings-cryptoKeys-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/cryptoKeys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-keyRings-cryptoKeys-updatePrimaryVersion
  "Update the version of a CryptoKey that will be used in Encrypt. Returns an error if called on a key whose purpose is not ENCRYPT_DECRYPT.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/updatePrimaryVersion

name <string> Required. The resource name of the CryptoKey to update.
UpdateCryptoKeyPrimaryVersionRequest:
{:cryptoKeyVersionId string}"
  [name UpdateCryptoKeyPrimaryVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:updatePrimaryVersion",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body UpdateCryptoKeyPrimaryVersionRequest}))

(defn projects-locations-keyRings-cryptoKeys-decrypt
  "Decrypts data that was protected by Encrypt. The CryptoKey.purpose must be ENCRYPT_DECRYPT.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/decrypt

name <string> Required. The resource name of the CryptoKey to use for decryption. The server will choose the appropriate version.
DecryptRequest:
{:ciphertext string,
 :additionalAuthenticatedData string,
 :ciphertextCrc32c string,
 :additionalAuthenticatedDataCrc32c string}"
  [name DecryptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:decrypt",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body DecryptRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-get
  "Returns metadata for a given CryptoKeyVersion.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/get

name <string> Required. The name of the CryptoKeyVersion to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-patch
  "Update a CryptoKeyVersion's metadata. state may be changed between ENABLED and DISABLED using this method. See DestroyCryptoKeyVersion and RestoreCryptoKeyVersion to move between other states.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/patch

name <string> Output only. The resource name for this CryptoKeyVersion in the format `projects/*/locations/*/keyRings/*/cryptoKeys/*/cryptoKeyVersions/*`.
CryptoKeyVersion:
{:reimportEligible boolean,
 :algorithm
 [CRYPTO_KEY_VERSION_ALGORITHM_UNSPECIFIED
  GOOGLE_SYMMETRIC_ENCRYPTION
  AES_128_GCM
  AES_256_GCM
  AES_128_CBC
  AES_256_CBC
  AES_128_CTR
  AES_256_CTR
  RSA_SIGN_PSS_2048_SHA256
  RSA_SIGN_PSS_3072_SHA256
  RSA_SIGN_PSS_4096_SHA256
  RSA_SIGN_PSS_4096_SHA512
  RSA_SIGN_PKCS1_2048_SHA256
  RSA_SIGN_PKCS1_3072_SHA256
  RSA_SIGN_PKCS1_4096_SHA256
  RSA_SIGN_PKCS1_4096_SHA512
  RSA_SIGN_RAW_PKCS1_2048
  RSA_SIGN_RAW_PKCS1_3072
  RSA_SIGN_RAW_PKCS1_4096
  RSA_DECRYPT_OAEP_2048_SHA256
  RSA_DECRYPT_OAEP_3072_SHA256
  RSA_DECRYPT_OAEP_4096_SHA256
  RSA_DECRYPT_OAEP_4096_SHA512
  RSA_DECRYPT_OAEP_2048_SHA1
  RSA_DECRYPT_OAEP_3072_SHA1
  RSA_DECRYPT_OAEP_4096_SHA1
  EC_SIGN_P256_SHA256
  EC_SIGN_P384_SHA384
  EC_SIGN_SECP256K1_SHA256
  EC_SIGN_ED25519
  HMAC_SHA256
  HMAC_SHA1
  HMAC_SHA384
  HMAC_SHA512
  HMAC_SHA224
  EXTERNAL_SYMMETRIC_ENCRYPTION],
 :generateTime string,
 :generationFailureReason string,
 :importFailureReason string,
 :name string,
 :importTime string,
 :createTime string,
 :state
 [CRYPTO_KEY_VERSION_STATE_UNSPECIFIED
  PENDING_GENERATION
  ENABLED
  DISABLED
  DESTROYED
  DESTROY_SCHEDULED
  PENDING_IMPORT
  IMPORT_FAILED
  GENERATION_FAILED
  PENDING_EXTERNAL_DESTRUCTION
  EXTERNAL_DESTRUCTION_FAILED],
 :externalProtectionLevelOptions
 {:externalKeyUri string, :ekmConnectionKeyPath string},
 :importJob string,
 :attestation
 {:format
  [ATTESTATION_FORMAT_UNSPECIFIED
   CAVIUM_V1_COMPRESSED
   CAVIUM_V2_COMPRESSED],
  :content string,
  :certChains
  {:caviumCerts [string],
   :googleCardCerts [string],
   :googlePartitionCerts [string]}},
 :protectionLevel
 [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC],
 :externalDestructionFailureReason string,
 :destroyTime string,
 :destroyEventTime string}

optional:
updateMask <string> Required. List of fields to be updated in this request."
  ([name CryptoKeyVersion]
    (projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-patch
      name
      CryptoKeyVersion
      nil))
  ([name CryptoKeyVersion optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body CryptoKeyVersion})))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-restore
  "Restore a CryptoKeyVersion in the DESTROY_SCHEDULED state. Upon restoration of the CryptoKeyVersion, state will be set to DISABLED, and destroy_time will be cleared.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/restore

name <string> Required. The resource name of the CryptoKeyVersion to restore.
RestoreCryptoKeyVersionRequest:
object"
  [name RestoreCryptoKeyVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:restore",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body RestoreCryptoKeyVersionRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-create
  "Create a new CryptoKeyVersion in a CryptoKey. The server will assign the next sequential id. If unset, state will be set to ENABLED.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/create

parent <string> Required. The name of the CryptoKey associated with the CryptoKeyVersions.
CryptoKeyVersion:
{:reimportEligible boolean,
 :algorithm
 [CRYPTO_KEY_VERSION_ALGORITHM_UNSPECIFIED
  GOOGLE_SYMMETRIC_ENCRYPTION
  AES_128_GCM
  AES_256_GCM
  AES_128_CBC
  AES_256_CBC
  AES_128_CTR
  AES_256_CTR
  RSA_SIGN_PSS_2048_SHA256
  RSA_SIGN_PSS_3072_SHA256
  RSA_SIGN_PSS_4096_SHA256
  RSA_SIGN_PSS_4096_SHA512
  RSA_SIGN_PKCS1_2048_SHA256
  RSA_SIGN_PKCS1_3072_SHA256
  RSA_SIGN_PKCS1_4096_SHA256
  RSA_SIGN_PKCS1_4096_SHA512
  RSA_SIGN_RAW_PKCS1_2048
  RSA_SIGN_RAW_PKCS1_3072
  RSA_SIGN_RAW_PKCS1_4096
  RSA_DECRYPT_OAEP_2048_SHA256
  RSA_DECRYPT_OAEP_3072_SHA256
  RSA_DECRYPT_OAEP_4096_SHA256
  RSA_DECRYPT_OAEP_4096_SHA512
  RSA_DECRYPT_OAEP_2048_SHA1
  RSA_DECRYPT_OAEP_3072_SHA1
  RSA_DECRYPT_OAEP_4096_SHA1
  EC_SIGN_P256_SHA256
  EC_SIGN_P384_SHA384
  EC_SIGN_SECP256K1_SHA256
  EC_SIGN_ED25519
  HMAC_SHA256
  HMAC_SHA1
  HMAC_SHA384
  HMAC_SHA512
  HMAC_SHA224
  EXTERNAL_SYMMETRIC_ENCRYPTION],
 :generateTime string,
 :generationFailureReason string,
 :importFailureReason string,
 :name string,
 :importTime string,
 :createTime string,
 :state
 [CRYPTO_KEY_VERSION_STATE_UNSPECIFIED
  PENDING_GENERATION
  ENABLED
  DISABLED
  DESTROYED
  DESTROY_SCHEDULED
  PENDING_IMPORT
  IMPORT_FAILED
  GENERATION_FAILED
  PENDING_EXTERNAL_DESTRUCTION
  EXTERNAL_DESTRUCTION_FAILED],
 :externalProtectionLevelOptions
 {:externalKeyUri string, :ekmConnectionKeyPath string},
 :importJob string,
 :attestation
 {:format
  [ATTESTATION_FORMAT_UNSPECIFIED
   CAVIUM_V1_COMPRESSED
   CAVIUM_V2_COMPRESSED],
  :content string,
  :certChains
  {:caviumCerts [string],
   :googleCardCerts [string],
   :googlePartitionCerts [string]}},
 :protectionLevel
 [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC],
 :externalDestructionFailureReason string,
 :destroyTime string,
 :destroyEventTime string}"
  [parent CryptoKeyVersion]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+parent}/cryptoKeyVersions",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body CryptoKeyVersion}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-destroy
  "Schedule a CryptoKeyVersion for destruction. Upon calling this method, CryptoKeyVersion.state will be set to DESTROY_SCHEDULED, and destroy_time will be set to the time destroy_scheduled_duration in the future. At that time, the state will automatically change to DESTROYED, and the key material will be irrevocably destroyed. Before the destroy_time is reached, RestoreCryptoKeyVersion may be called to reverse the process.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/destroy

name <string> Required. The resource name of the CryptoKeyVersion to destroy.
DestroyCryptoKeyVersionRequest:
object"
  [name DestroyCryptoKeyVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:destroy",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body DestroyCryptoKeyVersionRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-getPublicKey
  "Returns the public key for the given CryptoKeyVersion. The CryptoKey.purpose must be ASYMMETRIC_SIGN or ASYMMETRIC_DECRYPT.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/getPublicKey

name <string> Required. The name of the CryptoKeyVersion public key to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}/publicKey",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-asymmetricSign
  "Signs data using a CryptoKeyVersion with CryptoKey.purpose ASYMMETRIC_SIGN, producing a signature that can be verified with the public key retrieved from GetPublicKey.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/asymmetricSign

name <string> Required. The resource name of the CryptoKeyVersion to use for signing.
AsymmetricSignRequest:
{:digest {:sha256 string, :sha384 string, :sha512 string},
 :digestCrc32c string,
 :data string,
 :dataCrc32c string}"
  [name AsymmetricSignRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:asymmetricSign",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body AsymmetricSignRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-macSign
  "Signs data using a CryptoKeyVersion with CryptoKey.purpose MAC, producing a tag that can be verified by another source with the same key.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/macSign

name <string> Required. The resource name of the CryptoKeyVersion to use for signing.
MacSignRequest:
{:data string, :dataCrc32c string}"
  [name MacSignRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:macSign",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body MacSignRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-list
  "Lists CryptoKeyVersions.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/list

parent <string> Required. The resource name of the CryptoKey to list, in the format `projects/*/locations/*/keyRings/*/cryptoKeys/*`.

optional:
pageSize <integer> Optional. Optional limit on the number of CryptoKeyVersions to include in the response. Further CryptoKeyVersions can subsequently be obtained by including the ListCryptoKeyVersionsResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
view <string> The fields to include in the response.
filter <string> Optional. Only include resources that match the filter in the response. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering).
orderBy <string> Optional. Specify how the results should be sorted. If not specified, the results will be sorted in the default order. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering)."
  ([parent]
    (projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/cryptoKeyVersions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-rawDecrypt
  "Decrypts data that was originally encrypted using a raw cryptographic mechanism. The CryptoKey.purpose must be RAW_ENCRYPT_DECRYPT.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/rawDecrypt

name <string> Required. The resource name of the CryptoKeyVersion to use for decryption.
RawDecryptRequest:
{:ciphertext string,
 :additionalAuthenticatedData string,
 :initializationVector string,
 :tagLength integer,
 :ciphertextCrc32c string,
 :additionalAuthenticatedDataCrc32c string,
 :initializationVectorCrc32c string}"
  [name RawDecryptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:rawDecrypt",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body RawDecryptRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-macVerify
  "Verifies MAC tag using a CryptoKeyVersion with CryptoKey.purpose MAC, and returns a response that indicates whether or not the verification was successful.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/macVerify

name <string> Required. The resource name of the CryptoKeyVersion to use for verification.
MacVerifyRequest:
{:data string, :dataCrc32c string, :mac string, :macCrc32c string}"
  [name MacVerifyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:macVerify",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body MacVerifyRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-rawEncrypt
  "Encrypts data using portable cryptographic primitives. Most users should choose Encrypt and Decrypt rather than their raw counterparts. The CryptoKey.purpose must be RAW_ENCRYPT_DECRYPT.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/rawEncrypt

name <string> Required. The resource name of the CryptoKeyVersion to use for encryption.
RawEncryptRequest:
{:plaintext string,
 :additionalAuthenticatedData string,
 :plaintextCrc32c string,
 :additionalAuthenticatedDataCrc32c string,
 :initializationVector string,
 :initializationVectorCrc32c string}"
  [name RawEncryptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:rawEncrypt",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body RawEncryptRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-import
  "Import wrapped key material into a CryptoKeyVersion. All requests must specify a CryptoKey. If a CryptoKeyVersion is additionally specified in the request, key material will be reimported into that version. Otherwise, a new version will be created, and will be assigned the next sequential id within the CryptoKey.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/import

parent <string> Required. The name of the CryptoKey to be imported into. The create permission is only required on this key when creating a new CryptoKeyVersion.
ImportCryptoKeyVersionRequest:
{:cryptoKeyVersion string,
 :algorithm
 [CRYPTO_KEY_VERSION_ALGORITHM_UNSPECIFIED
  GOOGLE_SYMMETRIC_ENCRYPTION
  AES_128_GCM
  AES_256_GCM
  AES_128_CBC
  AES_256_CBC
  AES_128_CTR
  AES_256_CTR
  RSA_SIGN_PSS_2048_SHA256
  RSA_SIGN_PSS_3072_SHA256
  RSA_SIGN_PSS_4096_SHA256
  RSA_SIGN_PSS_4096_SHA512
  RSA_SIGN_PKCS1_2048_SHA256
  RSA_SIGN_PKCS1_3072_SHA256
  RSA_SIGN_PKCS1_4096_SHA256
  RSA_SIGN_PKCS1_4096_SHA512
  RSA_SIGN_RAW_PKCS1_2048
  RSA_SIGN_RAW_PKCS1_3072
  RSA_SIGN_RAW_PKCS1_4096
  RSA_DECRYPT_OAEP_2048_SHA256
  RSA_DECRYPT_OAEP_3072_SHA256
  RSA_DECRYPT_OAEP_4096_SHA256
  RSA_DECRYPT_OAEP_4096_SHA512
  RSA_DECRYPT_OAEP_2048_SHA1
  RSA_DECRYPT_OAEP_3072_SHA1
  RSA_DECRYPT_OAEP_4096_SHA1
  EC_SIGN_P256_SHA256
  EC_SIGN_P384_SHA384
  EC_SIGN_SECP256K1_SHA256
  EC_SIGN_ED25519
  HMAC_SHA256
  HMAC_SHA1
  HMAC_SHA384
  HMAC_SHA512
  HMAC_SHA224
  EXTERNAL_SYMMETRIC_ENCRYPTION],
 :importJob string,
 :wrappedKey string,
 :rsaAesWrappedKey string}"
  [parent ImportCryptoKeyVersionRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+parent}/cryptoKeyVersions:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body ImportCryptoKeyVersionRequest}))

(defn projects-locations-keyRings-cryptoKeys-cryptoKeyVersions-asymmetricDecrypt
  "Decrypts data that was encrypted with a public key retrieved from GetPublicKey corresponding to a CryptoKeyVersion with CryptoKey.purpose ASYMMETRIC_DECRYPT.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/asymmetricDecrypt

name <string> Required. The resource name of the CryptoKeyVersion to use for decryption.
AsymmetricDecryptRequest:
{:ciphertext string, :ciphertextCrc32c string}"
  [name AsymmetricDecryptRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+name}:asymmetricDecrypt",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body AsymmetricDecryptRequest}))

(defn projects-locations-keyRings-importJobs-list
  "Lists ImportJobs.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/list

parent <string> Required. The resource name of the KeyRing to list, in the format `projects/*/locations/*/keyRings/*`.

optional:
pageSize <integer> Optional. Optional limit on the number of ImportJobs to include in the response. Further ImportJobs can subsequently be obtained by including the ListImportJobsResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering).
orderBy <string> Optional. Specify how the results should be sorted. If not specified, the results will be sorted in the default order. For more information, see [Sorting and filtering list results](https://cloud.google.com/kms/docs/sorting-and-filtering)."
  ([parent] (projects-locations-keyRings-importJobs-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/importJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-keyRings-importJobs-get
  "Returns metadata for a given ImportJob.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/get

name <string> Required. The name of the ImportJob to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://cloudkms.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"]}))

(defn projects-locations-keyRings-importJobs-create
  "Create a new ImportJob within a KeyRing. ImportJob.import_method is required.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/create

parent <string> Required. The name of the KeyRing associated with the ImportJobs.
ImportJob:
{:generateTime string,
 :name string,
 :createTime string,
 :expireEventTime string,
 :state
 [IMPORT_JOB_STATE_UNSPECIFIED PENDING_GENERATION ACTIVE EXPIRED],
 :publicKey {:pem string},
 :attestation
 {:format
  [ATTESTATION_FORMAT_UNSPECIFIED
   CAVIUM_V1_COMPRESSED
   CAVIUM_V2_COMPRESSED],
  :content string,
  :certChains
  {:caviumCerts [string],
   :googleCardCerts [string],
   :googlePartitionCerts [string]}},
 :expireTime string,
 :importMethod
 [IMPORT_METHOD_UNSPECIFIED
  RSA_OAEP_3072_SHA1_AES_256
  RSA_OAEP_4096_SHA1_AES_256
  RSA_OAEP_3072_SHA256_AES_256
  RSA_OAEP_4096_SHA256_AES_256
  RSA_OAEP_3072_SHA256
  RSA_OAEP_4096_SHA256],
 :protectionLevel
 [PROTECTION_LEVEL_UNSPECIFIED SOFTWARE HSM EXTERNAL EXTERNAL_VPC]}

optional:
importJobId <string> Required. It must be unique within a KeyRing and match the regular expression `[a-zA-Z0-9_-]{1,63}`"
  ([parent ImportJob]
    (projects-locations-keyRings-importJobs-create
      parent
      ImportJob
      nil))
  ([parent ImportJob optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+parent}/importJobs",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"],
       :body ImportJob})))

(defn projects-locations-keyRings-importJobs-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/setIamPolicy

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
     "https://cloudkms.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body SetIamPolicyRequest}))

(defn projects-locations-keyRings-importJobs-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-keyRings-importJobs-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-keyRings-importJobs-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/importJobs/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-ekmConfig-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConfig/setIamPolicy

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
     "https://cloudkms.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body SetIamPolicyRequest}))

(defn projects-locations-ekmConfig-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConfig/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-ekmConfig-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://cloudkms.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloudkms"]})))

(defn projects-locations-ekmConfig-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/ekmConfig/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://cloudkms.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloudkms"],
     :body TestIamPermissionsRequest}))

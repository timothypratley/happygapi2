(ns happygapi2.kmsinventory
  "KMS Inventory API

See: https://cloud.google.com/security/products/security-key-management"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-keyRings-cryptoKeys-getProtectedResourcesSummary
  "Returns aggregate information about the resources protected by the given Cloud KMS CryptoKey. Only resources within the same Cloud organization as the key will be returned. The project that holds the key must be part of an organization in order for this call to succeed.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/locations/keyRings/cryptoKeys/getProtectedResourcesSummary

name <string> Required. The resource name of the CryptoKey."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://kmsinventory.googleapis.com/v1/{+name}/protectedResourcesSummary",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-cryptoKeys-list
  "Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data is sourced from snapshots, meaning it may not completely reflect the actual state of key metadata at call time.
https://cloud.google.com/security/products/security-key-management/v1/docs/projects/cryptoKeys/list

parent <string> Required. The Google Cloud project for which to retrieve key metadata, in the format `projects/*`

optional:
pageSize <integer> Optional. The maximum number of keys to return. The service may return fewer than this value. If unspecified, at most 1000 keys will be returned. The maximum value is 1000; values above 1000 will be coerced to 1000."
  ([parent] (projects-cryptoKeys-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://kmsinventory.googleapis.com/v1/{+parent}/cryptoKeys",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn organizations-protectedResources-search
  "Returns metadata about the resources protected by the given Cloud KMS CryptoKey in the given Cloud organization.
https://cloud.google.com/security/products/security-key-management/v1/docs/organizations/protectedResources/search

scope <string> Required. Resource name of the organization. Example: organizations/123

optional:
pageSize <integer> The maximum number of resources to return. The service may return fewer than this value. If unspecified, at most 500 resources will be returned. The maximum value is 500; values above 500 will be coerced to 500.
cryptoKey <string> Required. The resource name of the CryptoKey.
resourceTypes <string> Optional. A list of resource types that this request searches for. If empty, it will search all the [trackable resource types](https://cloud.google.com/kms/docs/view-key-usage#tracked-resource-types). Regular expressions are also supported. For example: * `compute.googleapis.com.*` snapshots resources whose type starts with `compute.googleapis.com`. * `.*Image` snapshots resources whose type ends with `Image`. * `.*Image.*` snapshots resources whose type contains `Image`. See [RE2](https://github.com/google/re2/wiki/Syntax) for all supported regular expression syntax. If the regular expression does not match any supported resource type, an INVALID_ARGUMENT error will be returned."
  ([scope] (organizations-protectedResources-search scope nil))
  ([scope optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://kmsinventory.googleapis.com/v1/{+scope}/protectedResources:search",
       :uri-template-args {:scope scope},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

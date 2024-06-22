(ns happygapi2.privateca
  "Certificate Authority API
The Certificate Authority Service API is a highly-available, scalable service that enables you to simplify and automate the management of private certificate authorities (CAs) while staying in control of your private keys. 
See: https://cloud.google.com/"
  (:require [happy.oauth2.client :as client]))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-list
  "Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`.
https://cloud.google.com

name <string> The name of the operation's parent resource.

optional:
filter <string> The standard list filter.
pageSize <integer> The standard list page size."
  ([name] (projects-locations-operations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+name}/operations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-delete
  "Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`.
https://cloud.google.com

name <string> The name of the operation resource to be deleted."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-operations-cancel
  "Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`.
https://cloud.google.com

name <string> The name of the operation resource to be cancelled.
CancelOperationRequest:
object"
  [name CancelOperationRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+name}:cancel",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body CancelOperationRequest}))

(defn projects-locations-caPools-get
  "Returns a CaPool.
https://cloud.google.com

name <string> Required. The name of the CaPool to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-caPools-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com

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
     "https://privateca.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-caPools-patch
  "Update a CaPool.
https://cloud.google.com

name <string> Output only. The resource name for this CaPool in the format `projects/*/locations/*/caPools/*`.
CaPool:
{:name string,
 :tier [TIER_UNSPECIFIED ENTERPRISE DEVOPS],
 :issuancePolicy
 {:allowedKeyTypes
  [{:rsa {:minModulusSize string, :maxModulusSize string},
    :ellipticCurve
    {:signatureAlgorithm
     [EC_SIGNATURE_ALGORITHM_UNSPECIFIED
      ECDSA_P256
      ECDSA_P384
      EDDSA_25519]}}],
  :maximumLifetime string,
  :allowedIssuanceModes
  {:allowCsrBasedIssuance boolean, :allowConfigBasedIssuance boolean},
  :baselineValues
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :identityConstraints
  {:celExpression
   {:expression string,
    :title string,
    :description string,
    :location string},
   :allowSubjectPassthrough boolean,
   :allowSubjectAltNamesPassthrough boolean},
  :passthroughExtensions
  {:knownExtensions
   [[KNOWN_CERTIFICATE_EXTENSION_UNSPECIFIED
     BASE_KEY_USAGE
     EXTENDED_KEY_USAGE
     CA_OPTIONS
     POLICY_IDS
     AIA_OCSP_SERVERS
     NAME_CONSTRAINTS]],
   :additionalExtensions [{:objectIdPath [integer]}]}},
 :publishingOptions
 {:publishCaCert boolean,
  :publishCrl boolean,
  :encodingFormat [ENCODING_FORMAT_UNSPECIFIED PEM DER]},
 :labels object}

optional:
updateMask <string> Required. A list of fields to be updated in this request.
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name CaPool] (projects-locations-caPools-patch name CaPool nil))
  ([name CaPool optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CaPool})))

(defn projects-locations-caPools-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-caPools-fetchCaCerts
  "FetchCaCerts returns the current trust anchor for the CaPool. This will include CA certificate chains for all certificate authorities in the ENABLED, DISABLED, or STAGED states.
https://cloud.google.com

caPool <string> Required. The resource name for the CaPool in the format `projects/*/locations/*/caPools/*`.
FetchCaCertsRequest:
{:requestId string}"
  [caPool FetchCaCertsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+caPool}:fetchCaCerts",
     :uri-template-args {:caPool caPool},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body FetchCaCertsRequest}))

(defn projects-locations-caPools-create
  "Create a CaPool.
https://cloud.google.com

parent <string> Required. The resource name of the location associated with the CaPool, in the format `projects/*/locations/*`.
CaPool:
{:name string,
 :tier [TIER_UNSPECIFIED ENTERPRISE DEVOPS],
 :issuancePolicy
 {:allowedKeyTypes
  [{:rsa {:minModulusSize string, :maxModulusSize string},
    :ellipticCurve
    {:signatureAlgorithm
     [EC_SIGNATURE_ALGORITHM_UNSPECIFIED
      ECDSA_P256
      ECDSA_P384
      EDDSA_25519]}}],
  :maximumLifetime string,
  :allowedIssuanceModes
  {:allowCsrBasedIssuance boolean, :allowConfigBasedIssuance boolean},
  :baselineValues
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :identityConstraints
  {:celExpression
   {:expression string,
    :title string,
    :description string,
    :location string},
   :allowSubjectPassthrough boolean,
   :allowSubjectAltNamesPassthrough boolean},
  :passthroughExtensions
  {:knownExtensions
   [[KNOWN_CERTIFICATE_EXTENSION_UNSPECIFIED
     BASE_KEY_USAGE
     EXTENDED_KEY_USAGE
     CA_OPTIONS
     POLICY_IDS
     AIA_OCSP_SERVERS
     NAME_CONSTRAINTS]],
   :additionalExtensions [{:objectIdPath [integer]}]}},
 :publishingOptions
 {:publishCaCert boolean,
  :publishCrl boolean,
  :encodingFormat [ENCODING_FORMAT_UNSPECIFIED PEM DER]},
 :labels object}

optional:
caPoolId <string> Required. It must be unique within a location and match the regular expression `[a-zA-Z0-9_-]{1,63}`
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent CaPool]
    (projects-locations-caPools-create parent CaPool nil))
  ([parent CaPool optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/caPools",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CaPool})))

(defn projects-locations-caPools-delete
  "Delete a CaPool.
https://cloud.google.com

name <string> Required. The resource name for this CaPool in the format `projects/*/locations/*/caPools/*`.

optional:
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
ignoreDependentResources <boolean> Optional. This field allows this pool to be deleted even if it's being depended on by another resource. However, doing so may result in unintended and unrecoverable effects on any dependent resources since the pool will no longer be able to issue certificates."
  ([name] (projects-locations-caPools-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-locations-caPools-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-list
  "Lists CaPools.
https://cloud.google.com

parent <string> Required. The resource name of the location associated with the CaPools, in the format `projects/*/locations/*`.

optional:
pageSize <integer> Optional. Limit on the number of CaPools to include in the response. Further CaPools can subsequently be obtained by including the ListCaPoolsResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response.
orderBy <string> Optional. Specify how the results should be sorted."
  ([parent] (projects-locations-caPools-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/caPools",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-certificates-create
  "Create a new Certificate in a given Project, Location from a particular CaPool.
https://cloud.google.com

parent <string> Required. The resource name of the CaPool associated with the Certificate, in the format `projects/*/locations/*/caPools/*`.
Certificate:
{:revocationDetails
 {:revocationState
  [REVOCATION_REASON_UNSPECIFIED
   KEY_COMPROMISE
   CERTIFICATE_AUTHORITY_COMPROMISE
   AFFILIATION_CHANGED
   SUPERSEDED
   CESSATION_OF_OPERATION
   CERTIFICATE_HOLD
   PRIVILEGE_WITHDRAWN
   ATTRIBUTE_AUTHORITY_COMPROMISE],
  :revocationTime string},
 :labels object,
 :certificateTemplate string,
 :issuerCertificateAuthority string,
 :config
 {:subjectConfig
  {:subject
   {:commonName string,
    :countryCode string,
    :organization string,
    :organizationalUnit string,
    :locality string,
    :province string,
    :streetAddress string,
    :postalCode string},
   :subjectAltName
   {:dnsNames [string],
    :uris [string],
    :emailAddresses [string],
    :ipAddresses [string],
    :customSans
    [{:objectId ObjectId, :critical boolean, :value string}]}},
  :x509Config
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
  :subjectKeyId {:keyId string}},
 :name string,
 :createTime string,
 :subjectMode
 [SUBJECT_REQUEST_MODE_UNSPECIFIED DEFAULT REFLECTED_SPIFFE],
 :updateTime string,
 :pemCertificate string,
 :pemCsr string,
 :lifetime string,
 :certificateDescription
 {:subjectDescription
  {:subject
   {:commonName string,
    :countryCode string,
    :organization string,
    :organizationalUnit string,
    :locality string,
    :province string,
    :streetAddress string,
    :postalCode string},
   :subjectAltName
   {:dnsNames [string],
    :uris [string],
    :emailAddresses [string],
    :ipAddresses [string],
    :customSans
    [{:objectId ObjectId, :critical boolean, :value string}]},
   :hexSerialNumber string,
   :lifetime string,
   :notBeforeTime string,
   :notAfterTime string},
  :x509Description
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
  :subjectKeyId {:keyId string},
  :authorityKeyId {:keyId string},
  :crlDistributionPoints [string],
  :aiaIssuingCertificateUrls [string],
  :certFingerprint {:sha256Hash string}},
 :pemCertificateChain [string]}

optional:
certificateId <string> Optional. It must be unique within a location and match the regular expression `[a-zA-Z0-9_-]{1,63}`. This field is required when using a CertificateAuthority in the Enterprise CertificateAuthority.Tier, but is optional and its value is ignored otherwise.
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
validateOnly <boolean> Optional. If this is true, no Certificate resource will be persisted regardless of the CaPool's tier, and the returned Certificate will not contain the pem_certificate field.
issuingCertificateAuthorityId <string> Optional. The resource ID of the CertificateAuthority that should issue the certificate. This optional field will ignore the load-balancing scheme of the Pool and directly issue the certificate from the CA with the specified ID, contained in the same CaPool referenced by `parent`. Per-CA quota rules apply. If left empty, a CertificateAuthority will be chosen from the CaPool by the service. For example, to issue a Certificate from a Certificate Authority with resource name \"projects/my-project/locations/us-central1/caPools/my-pool/certificateAuthorities/my-ca\", you can set the parent to \"projects/my-project/locations/us-central1/caPools/my-pool\" and the issuing_certificate_authority_id to \"my-ca\"."
  ([parent Certificate]
    (projects-locations-caPools-certificates-create
      parent
      Certificate
      nil))
  ([parent Certificate optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/certificates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Certificate})))

(defn projects-locations-caPools-certificates-get
  "Returns a Certificate.
https://cloud.google.com

name <string> Required. The name of the Certificate to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-caPools-certificates-list
  "Lists Certificates.
https://cloud.google.com

parent <string> Required. The resource name of the location associated with the Certificates, in the format `projects/*/locations/*/caPools/*`.

optional:
pageSize <integer> Optional. Limit on the number of Certificates to include in the response. Further Certificates can subsequently be obtained by including the ListCertificatesResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response. For details on supported filters and syntax, see [Certificates Filtering documentation](https://cloud.google.com/certificate-authority-service/docs/sorting-filtering-certificates#filtering_support).
orderBy <string> Optional. Specify how the results should be sorted. For details on supported fields and syntax, see [Certificates Sorting documentation](https://cloud.google.com/certificate-authority-service/docs/sorting-filtering-certificates#sorting_support)."
  ([parent] (projects-locations-caPools-certificates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/certificates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-certificates-revoke
  "Revoke a Certificate.
https://cloud.google.com

name <string> Required. The resource name for this Certificate in the format `projects/*/locations/*/caPools/*/certificates/*`.
RevokeCertificateRequest:
{:reason
 [REVOCATION_REASON_UNSPECIFIED
  KEY_COMPROMISE
  CERTIFICATE_AUTHORITY_COMPROMISE
  AFFILIATION_CHANGED
  SUPERSEDED
  CESSATION_OF_OPERATION
  CERTIFICATE_HOLD
  PRIVILEGE_WITHDRAWN
  ATTRIBUTE_AUTHORITY_COMPROMISE],
 :requestId string}"
  [name RevokeCertificateRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+name}:revoke",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body RevokeCertificateRequest}))

(defn projects-locations-caPools-certificates-patch
  "Update a Certificate. Currently, the only field you can update is the labels field.
https://cloud.google.com

name <string> Output only. The resource name for this Certificate in the format `projects/*/locations/*/caPools/*/certificates/*`.
Certificate:
{:revocationDetails
 {:revocationState
  [REVOCATION_REASON_UNSPECIFIED
   KEY_COMPROMISE
   CERTIFICATE_AUTHORITY_COMPROMISE
   AFFILIATION_CHANGED
   SUPERSEDED
   CESSATION_OF_OPERATION
   CERTIFICATE_HOLD
   PRIVILEGE_WITHDRAWN
   ATTRIBUTE_AUTHORITY_COMPROMISE],
  :revocationTime string},
 :labels object,
 :certificateTemplate string,
 :issuerCertificateAuthority string,
 :config
 {:subjectConfig
  {:subject
   {:commonName string,
    :countryCode string,
    :organization string,
    :organizationalUnit string,
    :locality string,
    :province string,
    :streetAddress string,
    :postalCode string},
   :subjectAltName
   {:dnsNames [string],
    :uris [string],
    :emailAddresses [string],
    :ipAddresses [string],
    :customSans
    [{:objectId ObjectId, :critical boolean, :value string}]}},
  :x509Config
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
  :subjectKeyId {:keyId string}},
 :name string,
 :createTime string,
 :subjectMode
 [SUBJECT_REQUEST_MODE_UNSPECIFIED DEFAULT REFLECTED_SPIFFE],
 :updateTime string,
 :pemCertificate string,
 :pemCsr string,
 :lifetime string,
 :certificateDescription
 {:subjectDescription
  {:subject
   {:commonName string,
    :countryCode string,
    :organization string,
    :organizationalUnit string,
    :locality string,
    :province string,
    :streetAddress string,
    :postalCode string},
   :subjectAltName
   {:dnsNames [string],
    :uris [string],
    :emailAddresses [string],
    :ipAddresses [string],
    :customSans
    [{:objectId ObjectId, :critical boolean, :value string}]},
   :hexSerialNumber string,
   :lifetime string,
   :notBeforeTime string,
   :notAfterTime string},
  :x509Description
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
  :subjectKeyId {:keyId string},
  :authorityKeyId {:keyId string},
  :crlDistributionPoints [string],
  :aiaIssuingCertificateUrls [string],
  :certFingerprint {:sha256Hash string}},
 :pemCertificateChain [string]}

optional:
updateMask <string> Required. A list of fields to be updated in this request.
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name Certificate]
    (projects-locations-caPools-certificates-patch
      name
      Certificate
      nil))
  ([name Certificate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Certificate})))

(defn projects-locations-caPools-certificateAuthorities-disable
  "Disable a CertificateAuthority.
https://cloud.google.com

name <string> Required. The resource name for this CertificateAuthority in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`.
DisableCertificateAuthorityRequest:
{:requestId string, :ignoreDependentResources boolean}"
  [name DisableCertificateAuthorityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+name}:disable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body DisableCertificateAuthorityRequest}))

(defn projects-locations-caPools-certificateAuthorities-get
  "Returns a CertificateAuthority.
https://cloud.google.com

name <string> Required. The name of the CertificateAuthority to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-caPools-certificateAuthorities-enable
  "Enable a CertificateAuthority.
https://cloud.google.com

name <string> Required. The resource name for this CertificateAuthority in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`.
EnableCertificateAuthorityRequest:
{:requestId string}"
  [name EnableCertificateAuthorityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+name}:enable",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EnableCertificateAuthorityRequest}))

(defn projects-locations-caPools-certificateAuthorities-patch
  "Update a CertificateAuthority.
https://cloud.google.com

name <string> Output only. The resource name for this CertificateAuthority in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`.
CertificateAuthority:
{:labels object,
 :tier [TIER_UNSPECIFIED ENTERPRISE DEVOPS],
 :deleteTime string,
 :gcsBucket string,
 :config
 {:subjectConfig
  {:subject
   {:commonName string,
    :countryCode string,
    :organization string,
    :organizationalUnit string,
    :locality string,
    :province string,
    :streetAddress string,
    :postalCode string},
   :subjectAltName
   {:dnsNames [string],
    :uris [string],
    :emailAddresses [string],
    :ipAddresses [string],
    :customSans
    [{:objectId ObjectId, :critical boolean, :value string}]}},
  :x509Config
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
  :subjectKeyId {:keyId string}},
 :satisfiesPzi boolean,
 :name string,
 :createTime string,
 :keySpec
 {:cloudKmsKeyVersion string,
  :algorithm
  [SIGN_HASH_ALGORITHM_UNSPECIFIED
   RSA_PSS_2048_SHA256
   RSA_PSS_3072_SHA256
   RSA_PSS_4096_SHA256
   RSA_PKCS1_2048_SHA256
   RSA_PKCS1_3072_SHA256
   RSA_PKCS1_4096_SHA256
   EC_P256_SHA256
   EC_P384_SHA384]},
 :type [TYPE_UNSPECIFIED SELF_SIGNED SUBORDINATE],
 :state
 [STATE_UNSPECIFIED
  ENABLED
  DISABLED
  STAGED
  AWAITING_USER_ACTIVATION
  DELETED],
 :subordinateConfig
 {:certificateAuthority string,
  :pemIssuerChain {:pemCertificates [string]}},
 :updateTime string,
 :accessUrls {:caCertificateAccessUrl string, :crlAccessUrls [string]},
 :satisfiesPzs boolean,
 :lifetime string,
 :caCertificateDescriptions
 [{:subjectDescription
   {:subject
    {:commonName string,
     :countryCode string,
     :organization string,
     :organizationalUnit string,
     :locality string,
     :province string,
     :streetAddress string,
     :postalCode string},
    :subjectAltName
    {:dnsNames [string],
     :uris [string],
     :emailAddresses [string],
     :ipAddresses [string],
     :customSans
     [{:objectId ObjectId, :critical boolean, :value string}]},
    :hexSerialNumber string,
    :lifetime string,
    :notBeforeTime string,
    :notAfterTime string},
   :x509Description
   {:keyUsage
    {:baseKeyUsage
     {:decipherOnly boolean,
      :crlSign boolean,
      :encipherOnly boolean,
      :keyAgreement boolean,
      :dataEncipherment boolean,
      :keyEncipherment boolean,
      :certSign boolean,
      :contentCommitment boolean,
      :digitalSignature boolean},
     :extendedKeyUsage
     {:serverAuth boolean,
      :clientAuth boolean,
      :codeSigning boolean,
      :emailProtection boolean,
      :timeStamping boolean,
      :ocspSigning boolean},
     :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
    :caOptions {:isCa boolean, :maxIssuerPathLength integer},
    :policyIds [{:objectIdPath [integer]}],
    :aiaOcspServers [string],
    :nameConstraints
    {:excludedEmailAddresses [string],
     :excludedUris [string],
     :permittedUris [string],
     :critical boolean,
     :permittedDnsNames [string],
     :permittedIpRanges [string],
     :excludedDnsNames [string],
     :permittedEmailAddresses [string],
     :excludedIpRanges [string]},
    :additionalExtensions
    [{:objectId {:objectIdPath [integer]},
      :critical boolean,
      :value string}]},
   :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
   :subjectKeyId {:keyId string},
   :authorityKeyId {:keyId string},
   :crlDistributionPoints [string],
   :aiaIssuingCertificateUrls [string],
   :certFingerprint {:sha256Hash string}}],
 :expireTime string,
 :pemCaCertificates [string]}

optional:
updateMask <string> Required. A list of fields to be updated in this request.
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name CertificateAuthority]
    (projects-locations-caPools-certificateAuthorities-patch
      name
      CertificateAuthority
      nil))
  ([name CertificateAuthority optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CertificateAuthority})))

(defn projects-locations-caPools-certificateAuthorities-create
  "Create a new CertificateAuthority in a given Project and Location.
https://cloud.google.com

parent <string> Required. The resource name of the CaPool associated with the CertificateAuthorities, in the format `projects/*/locations/*/caPools/*`.
CertificateAuthority:
{:labels object,
 :tier [TIER_UNSPECIFIED ENTERPRISE DEVOPS],
 :deleteTime string,
 :gcsBucket string,
 :config
 {:subjectConfig
  {:subject
   {:commonName string,
    :countryCode string,
    :organization string,
    :organizationalUnit string,
    :locality string,
    :province string,
    :streetAddress string,
    :postalCode string},
   :subjectAltName
   {:dnsNames [string],
    :uris [string],
    :emailAddresses [string],
    :ipAddresses [string],
    :customSans
    [{:objectId ObjectId, :critical boolean, :value string}]}},
  :x509Config
  {:keyUsage
   {:baseKeyUsage
    {:decipherOnly boolean,
     :crlSign boolean,
     :encipherOnly boolean,
     :keyAgreement boolean,
     :dataEncipherment boolean,
     :keyEncipherment boolean,
     :certSign boolean,
     :contentCommitment boolean,
     :digitalSignature boolean},
    :extendedKeyUsage
    {:serverAuth boolean,
     :clientAuth boolean,
     :codeSigning boolean,
     :emailProtection boolean,
     :timeStamping boolean,
     :ocspSigning boolean},
    :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
   :caOptions {:isCa boolean, :maxIssuerPathLength integer},
   :policyIds [{:objectIdPath [integer]}],
   :aiaOcspServers [string],
   :nameConstraints
   {:excludedEmailAddresses [string],
    :excludedUris [string],
    :permittedUris [string],
    :critical boolean,
    :permittedDnsNames [string],
    :permittedIpRanges [string],
    :excludedDnsNames [string],
    :permittedEmailAddresses [string],
    :excludedIpRanges [string]},
   :additionalExtensions
   [{:objectId {:objectIdPath [integer]},
     :critical boolean,
     :value string}]},
  :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
  :subjectKeyId {:keyId string}},
 :satisfiesPzi boolean,
 :name string,
 :createTime string,
 :keySpec
 {:cloudKmsKeyVersion string,
  :algorithm
  [SIGN_HASH_ALGORITHM_UNSPECIFIED
   RSA_PSS_2048_SHA256
   RSA_PSS_3072_SHA256
   RSA_PSS_4096_SHA256
   RSA_PKCS1_2048_SHA256
   RSA_PKCS1_3072_SHA256
   RSA_PKCS1_4096_SHA256
   EC_P256_SHA256
   EC_P384_SHA384]},
 :type [TYPE_UNSPECIFIED SELF_SIGNED SUBORDINATE],
 :state
 [STATE_UNSPECIFIED
  ENABLED
  DISABLED
  STAGED
  AWAITING_USER_ACTIVATION
  DELETED],
 :subordinateConfig
 {:certificateAuthority string,
  :pemIssuerChain {:pemCertificates [string]}},
 :updateTime string,
 :accessUrls {:caCertificateAccessUrl string, :crlAccessUrls [string]},
 :satisfiesPzs boolean,
 :lifetime string,
 :caCertificateDescriptions
 [{:subjectDescription
   {:subject
    {:commonName string,
     :countryCode string,
     :organization string,
     :organizationalUnit string,
     :locality string,
     :province string,
     :streetAddress string,
     :postalCode string},
    :subjectAltName
    {:dnsNames [string],
     :uris [string],
     :emailAddresses [string],
     :ipAddresses [string],
     :customSans
     [{:objectId ObjectId, :critical boolean, :value string}]},
    :hexSerialNumber string,
    :lifetime string,
    :notBeforeTime string,
    :notAfterTime string},
   :x509Description
   {:keyUsage
    {:baseKeyUsage
     {:decipherOnly boolean,
      :crlSign boolean,
      :encipherOnly boolean,
      :keyAgreement boolean,
      :dataEncipherment boolean,
      :keyEncipherment boolean,
      :certSign boolean,
      :contentCommitment boolean,
      :digitalSignature boolean},
     :extendedKeyUsage
     {:serverAuth boolean,
      :clientAuth boolean,
      :codeSigning boolean,
      :emailProtection boolean,
      :timeStamping boolean,
      :ocspSigning boolean},
     :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
    :caOptions {:isCa boolean, :maxIssuerPathLength integer},
    :policyIds [{:objectIdPath [integer]}],
    :aiaOcspServers [string],
    :nameConstraints
    {:excludedEmailAddresses [string],
     :excludedUris [string],
     :permittedUris [string],
     :critical boolean,
     :permittedDnsNames [string],
     :permittedIpRanges [string],
     :excludedDnsNames [string],
     :permittedEmailAddresses [string],
     :excludedIpRanges [string]},
    :additionalExtensions
    [{:objectId {:objectIdPath [integer]},
      :critical boolean,
      :value string}]},
   :publicKey {:key string, :format [KEY_FORMAT_UNSPECIFIED PEM]},
   :subjectKeyId {:keyId string},
   :authorityKeyId {:keyId string},
   :crlDistributionPoints [string],
   :aiaIssuingCertificateUrls [string],
   :certFingerprint {:sha256Hash string}}],
 :expireTime string,
 :pemCaCertificates [string]}

optional:
certificateAuthorityId <string> Required. It must be unique within a location and match the regular expression `[a-zA-Z0-9_-]{1,63}`
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent CertificateAuthority]
    (projects-locations-caPools-certificateAuthorities-create
      parent
      CertificateAuthority
      nil))
  ([parent CertificateAuthority optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/certificateAuthorities",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CertificateAuthority})))

(defn projects-locations-caPools-certificateAuthorities-delete
  "Delete a CertificateAuthority.
https://cloud.google.com

name <string> Required. The resource name for this CertificateAuthority in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`.

optional:
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000).
ignoreActiveCertificates <boolean> Optional. This field allows the CA to be deleted even if the CA has active certs. Active certs include both unrevoked and unexpired certs.
skipGracePeriod <boolean> Optional. If this flag is set, the Certificate Authority will be deleted as soon as possible without a 30-day grace period where undeletion would have been allowed. If you proceed, there will be no way to recover this CA.
ignoreDependentResources <boolean> Optional. This field allows this CA to be deleted even if it's being depended on by another resource. However, doing so may result in unintended and unrecoverable effects on any dependent resources since the CA will no longer be able to issue certificates."
  ([name]
    (projects-locations-caPools-certificateAuthorities-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-certificateAuthorities-undelete
  "Undelete a CertificateAuthority that has been deleted.
https://cloud.google.com

name <string> Required. The resource name for this CertificateAuthority in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`.
UndeleteCertificateAuthorityRequest:
{:requestId string}"
  [name UndeleteCertificateAuthorityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+name}:undelete",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UndeleteCertificateAuthorityRequest}))

(defn projects-locations-caPools-certificateAuthorities-list
  "Lists CertificateAuthorities.
https://cloud.google.com

parent <string> Required. The resource name of the CaPool associated with the CertificateAuthorities, in the format `projects/*/locations/*/caPools/*`.

optional:
pageSize <integer> Optional. Limit on the number of CertificateAuthorities to include in the response. Further CertificateAuthorities can subsequently be obtained by including the ListCertificateAuthoritiesResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response.
orderBy <string> Optional. Specify how the results should be sorted."
  ([parent]
    (projects-locations-caPools-certificateAuthorities-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/certificateAuthorities",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-certificateAuthorities-fetch
  "Fetch a certificate signing request (CSR) from a CertificateAuthority that is in state AWAITING_USER_ACTIVATION and is of type SUBORDINATE. The CSR must then be signed by the desired parent Certificate Authority, which could be another CertificateAuthority resource, or could be an on-prem certificate authority. See also ActivateCertificateAuthority.
https://cloud.google.com

name <string> Required. The resource name for this CertificateAuthority in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}:fetch",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-caPools-certificateAuthorities-activate
  "Activate a CertificateAuthority that is in state AWAITING_USER_ACTIVATION and is of type SUBORDINATE. After the parent Certificate Authority signs a certificate signing request from FetchCertificateAuthorityCsr, this method can complete the activation process.
https://cloud.google.com

name <string> Required. The resource name for this CertificateAuthority in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`.
ActivateCertificateAuthorityRequest:
{:pemCaCertificate string,
 :subordinateConfig
 {:certificateAuthority string,
  :pemIssuerChain {:pemCertificates [string]}},
 :requestId string}"
  [name ActivateCertificateAuthorityRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+name}:activate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ActivateCertificateAuthorityRequest}))

(defn projects-locations-caPools-certificateAuthorities-certificateRevocationLists-get
  "Returns a CertificateRevocationList.
https://cloud.google.com

name <string> Required. The name of the CertificateRevocationList to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-caPools-certificateAuthorities-certificateRevocationLists-list
  "Lists CertificateRevocationLists.
https://cloud.google.com

parent <string> Required. The resource name of the location associated with the CertificateRevocationLists, in the format `projects/*/locations/*/caPools/*/certificateAuthorities/*`.

optional:
pageSize <integer> Optional. Limit on the number of CertificateRevocationLists to include in the response. Further CertificateRevocationLists can subsequently be obtained by including the ListCertificateRevocationListsResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response.
orderBy <string> Optional. Specify how the results should be sorted."
  ([parent]
    (projects-locations-caPools-certificateAuthorities-certificateRevocationLists-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/certificateRevocationLists",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-certificateAuthorities-certificateRevocationLists-patch
  "Update a CertificateRevocationList.
https://cloud.google.com

name <string> Output only. The resource name for this CertificateRevocationList in the format `projects/*/locations/*/caPools/*certificateAuthorities/*/ certificateRevocationLists/*`.
CertificateRevocationList:
{:sequenceNumber string,
 :labels object,
 :accessUrl string,
 :name string,
 :createTime string,
 :revisionId string,
 :state [STATE_UNSPECIFIED ACTIVE SUPERSEDED],
 :updateTime string,
 :revokedCertificates
 [{:certificate string,
   :hexSerialNumber string,
   :revocationReason
   [REVOCATION_REASON_UNSPECIFIED
    KEY_COMPROMISE
    CERTIFICATE_AUTHORITY_COMPROMISE
    AFFILIATION_CHANGED
    SUPERSEDED
    CESSATION_OF_OPERATION
    CERTIFICATE_HOLD
    PRIVILEGE_WITHDRAWN
    ATTRIBUTE_AUTHORITY_COMPROMISE]}],
 :pemCrl string}

optional:
updateMask <string> Required. A list of fields to be updated in this request.
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name CertificateRevocationList]
    (projects-locations-caPools-certificateAuthorities-certificateRevocationLists-patch
      name
      CertificateRevocationList
      nil))
  ([name CertificateRevocationList optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CertificateRevocationList})))

(defn projects-locations-caPools-certificateAuthorities-certificateRevocationLists-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com

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
     "https://privateca.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-caPools-certificateAuthorities-certificateRevocationLists-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-caPools-certificateAuthorities-certificateRevocationLists-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-caPools-certificateAuthorities-certificateRevocationLists-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-certificateTemplates-create
  "Create a new CertificateTemplate in a given Project and Location.
https://cloud.google.com

parent <string> Required. The resource name of the location associated with the CertificateTemplate, in the format `projects/*/locations/*`.
CertificateTemplate:
{:description string,
 :labels object,
 :identityConstraints
 {:celExpression
  {:expression string,
   :title string,
   :description string,
   :location string},
  :allowSubjectPassthrough boolean,
  :allowSubjectAltNamesPassthrough boolean},
 :name string,
 :maximumLifetime string,
 :createTime string,
 :passthroughExtensions
 {:knownExtensions
  [[KNOWN_CERTIFICATE_EXTENSION_UNSPECIFIED
    BASE_KEY_USAGE
    EXTENDED_KEY_USAGE
    CA_OPTIONS
    POLICY_IDS
    AIA_OCSP_SERVERS
    NAME_CONSTRAINTS]],
  :additionalExtensions [{:objectIdPath [integer]}]},
 :updateTime string,
 :predefinedValues
 {:keyUsage
  {:baseKeyUsage
   {:decipherOnly boolean,
    :crlSign boolean,
    :encipherOnly boolean,
    :keyAgreement boolean,
    :dataEncipherment boolean,
    :keyEncipherment boolean,
    :certSign boolean,
    :contentCommitment boolean,
    :digitalSignature boolean},
   :extendedKeyUsage
   {:serverAuth boolean,
    :clientAuth boolean,
    :codeSigning boolean,
    :emailProtection boolean,
    :timeStamping boolean,
    :ocspSigning boolean},
   :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
  :caOptions {:isCa boolean, :maxIssuerPathLength integer},
  :policyIds [{:objectIdPath [integer]}],
  :aiaOcspServers [string],
  :nameConstraints
  {:excludedEmailAddresses [string],
   :excludedUris [string],
   :permittedUris [string],
   :critical boolean,
   :permittedDnsNames [string],
   :permittedIpRanges [string],
   :excludedDnsNames [string],
   :permittedEmailAddresses [string],
   :excludedIpRanges [string]},
  :additionalExtensions
  [{:objectId {:objectIdPath [integer]},
    :critical boolean,
    :value string}]}}

optional:
certificateTemplateId <string> Required. It must be unique within a location and match the regular expression `[a-zA-Z0-9_-]{1,63}`
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([parent CertificateTemplate]
    (projects-locations-certificateTemplates-create
      parent
      CertificateTemplate
      nil))
  ([parent CertificateTemplate optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/certificateTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CertificateTemplate})))

(defn projects-locations-certificateTemplates-delete
  "DeleteCertificateTemplate deletes a CertificateTemplate.
https://cloud.google.com

name <string> Required. The resource name for this CertificateTemplate in the format `projects/*/locations/*/certificateTemplates/*`.

optional:
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name] (projects-locations-certificateTemplates-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-certificateTemplates-get
  "Returns a CertificateTemplate.
https://cloud.google.com

name <string> Required. The name of the CertificateTemplate to get."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template "https://privateca.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-certificateTemplates-list
  "Lists CertificateTemplates.
https://cloud.google.com

parent <string> Required. The resource name of the location associated with the CertificateTemplates, in the format `projects/*/locations/*`.

optional:
pageSize <integer> Optional. Limit on the number of CertificateTemplates to include in the response. Further CertificateTemplates can subsequently be obtained by including the ListCertificateTemplatesResponse.next_page_token in a subsequent request. If unspecified, the server will pick an appropriate default.
filter <string> Optional. Only include resources that match the filter in the response.
orderBy <string> Optional. Specify how the results should be sorted."
  ([parent] (projects-locations-certificateTemplates-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+parent}/certificateTemplates",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-certificateTemplates-patch
  "Update a CertificateTemplate.
https://cloud.google.com

name <string> Output only. The resource name for this CertificateTemplate in the format `projects/*/locations/*/certificateTemplates/*`.
CertificateTemplate:
{:description string,
 :labels object,
 :identityConstraints
 {:celExpression
  {:expression string,
   :title string,
   :description string,
   :location string},
  :allowSubjectPassthrough boolean,
  :allowSubjectAltNamesPassthrough boolean},
 :name string,
 :maximumLifetime string,
 :createTime string,
 :passthroughExtensions
 {:knownExtensions
  [[KNOWN_CERTIFICATE_EXTENSION_UNSPECIFIED
    BASE_KEY_USAGE
    EXTENDED_KEY_USAGE
    CA_OPTIONS
    POLICY_IDS
    AIA_OCSP_SERVERS
    NAME_CONSTRAINTS]],
  :additionalExtensions [{:objectIdPath [integer]}]},
 :updateTime string,
 :predefinedValues
 {:keyUsage
  {:baseKeyUsage
   {:decipherOnly boolean,
    :crlSign boolean,
    :encipherOnly boolean,
    :keyAgreement boolean,
    :dataEncipherment boolean,
    :keyEncipherment boolean,
    :certSign boolean,
    :contentCommitment boolean,
    :digitalSignature boolean},
   :extendedKeyUsage
   {:serverAuth boolean,
    :clientAuth boolean,
    :codeSigning boolean,
    :emailProtection boolean,
    :timeStamping boolean,
    :ocspSigning boolean},
   :unknownExtendedKeyUsages [{:objectIdPath [integer]}]},
  :caOptions {:isCa boolean, :maxIssuerPathLength integer},
  :policyIds [{:objectIdPath [integer]}],
  :aiaOcspServers [string],
  :nameConstraints
  {:excludedEmailAddresses [string],
   :excludedUris [string],
   :permittedUris [string],
   :critical boolean,
   :permittedDnsNames [string],
   :permittedIpRanges [string],
   :excludedDnsNames [string],
   :permittedEmailAddresses [string],
   :excludedIpRanges [string]},
  :additionalExtensions
  [{:objectId {:objectIdPath [integer]},
    :critical boolean,
    :value string}]}}

optional:
updateMask <string> Required. A list of fields to be updated in this request.
requestId <string> Optional. An ID to identify requests. Specify a unique request ID so that if you must retry your request, the server will know to ignore the request if it has already been completed. The server will guarantee that for at least 60 minutes since the first request. For example, consider a situation where you make an initial request and the request times out. If you make the request again with the same request ID, the server can check if original operation with the same request ID was received, and if so, will ignore the second request. This prevents clients from accidentally creating duplicate commitments. The request ID must be a valid UUID with the exception that zero UUID is not supported (00000000-0000-0000-0000-000000000000)."
  ([name CertificateTemplate]
    (projects-locations-certificateTemplates-patch
      name
      CertificateTemplate
      nil))
  ([name CertificateTemplate optional]
    (client/api-request
      {:method "PATCH",
       :uri-template "https://privateca.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body CertificateTemplate})))

(defn projects-locations-certificateTemplates-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com

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
     "https://privateca.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-certificateTemplates-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-certificateTemplates-getIamPolicy
      resource
      nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://privateca.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-certificateTemplates-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://privateca.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

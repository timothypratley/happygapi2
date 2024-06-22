(ns happygapi2.binaryauthorization
  "Binary Authorization API
The management interface for Binary Authorization, a service that provides policy-based deployment validation and control for images deployed to Google Kubernetes Engine (GKE), Anthos Service Mesh, Anthos Clusters, and Cloud Run. 
See: https://cloud.google.com/binary-authorization/"
  (:require [happy.oauth2.client :as client]))

(defn projects-getPolicy
  "A policy specifies the attestors that must attest to a container image, before the project is allowed to deploy that image. There is at most one policy per project. All image admission requests are permitted if a project has no policy. Gets the policy for this project. Returns a default policy if the project does not have one.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects/getPolicy

name <string> Required. The resource name of the policy to retrieve, in the format `projects/*/policy`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-updatePolicy
  "Creates or updates a project's policy, and returns a copy of the new policy. A policy is always updated as a whole, to avoid race conditions with concurrent policy enforcement (or management!) requests. Returns `NOT_FOUND` if the project does not exist, `INVALID_ARGUMENT` if the request is malformed.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects/updatePolicy

name <string> Output only. The resource name, in the format `projects/*/policy`. There is at most one policy per project.
Policy:
{:description string,
 :name string,
 :defaultAdmissionRule
 {:evaluationMode
  [EVALUATION_MODE_UNSPECIFIED
   ALWAYS_ALLOW
   REQUIRE_ATTESTATION
   ALWAYS_DENY],
  :requireAttestationsBy [string],
  :enforcementMode
  [ENFORCEMENT_MODE_UNSPECIFIED
   ENFORCED_BLOCK_AND_AUDIT_LOG
   DRYRUN_AUDIT_LOG_ONLY]},
 :etag string,
 :updateTime string,
 :istioServiceIdentityAdmissionRules object,
 :clusterAdmissionRules object,
 :globalPolicyEvaluationMode
 [GLOBAL_POLICY_EVALUATION_MODE_UNSPECIFIED ENABLE DISABLE],
 :kubernetesServiceAccountAdmissionRules object,
 :kubernetesNamespaceAdmissionRules object,
 :admissionWhitelistPatterns [{:namePattern string}]}"
  [name Policy]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Policy}))

(defn projects-platforms-gke-policies-evaluate
  "Evaluates a Kubernetes object versus a GKE platform policy. Returns `NOT_FOUND` if the policy doesn't exist, `INVALID_ARGUMENT` if the policy or request is malformed and `PERMISSION_DENIED` if the client does not have sufficient permissions.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.platforms.gke.policies/evaluate

name <string> Required. The name of the platform policy to evaluate in the format `projects/*/platforms/*/policies/*`.
EvaluateGkePolicyRequest:
{:resource object}"
  [name EvaluateGkePolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}:evaluate",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body EvaluateGkePolicyRequest}))

(defn projects-platforms-policies-create
  "Creates a platform policy, and returns a copy of it. Returns `NOT_FOUND` if the project or platform doesn't exist, `INVALID_ARGUMENT` if the request is malformed, `ALREADY_EXISTS` if the policy already exists, and `INVALID_ARGUMENT` if the policy contains a platform-specific policy that does not match the platform value specified in the URL.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.platforms.policies/create

parent <string> Required. The parent of this platform policy.
PlatformPolicy:
{:name string,
 :description string,
 :gkePolicy
 {:imageAllowlist {:allowPattern [string]},
  :checkSets
  [{:displayName string,
    :scope
    {:kubernetesServiceAccount string, :kubernetesNamespace string},
    :imageAllowlist {:allowPattern [string]},
    :checks
    [{:simpleSigningAttestationCheck
      {:attestationAuthenticators [AttestationAuthenticator],
       :containerAnalysisAttestationProjects [string]},
      :displayName string,
      :imageAllowlist {:allowPattern [string]},
      :vulnerabilityCheck
      {:allowedCves [string],
       :blockedCves [string],
       :maximumUnfixableSeverity
       [MAXIMUM_ALLOWED_SEVERITY_UNSPECIFIED
        BLOCK_ALL
        MINIMAL
        LOW
        MEDIUM
        HIGH
        CRITICAL
        ALLOW_ALL],
       :maximumFixableSeverity
       [MAXIMUM_ALLOWED_SEVERITY_UNSPECIFIED
        BLOCK_ALL
        MINIMAL
        LOW
        MEDIUM
        HIGH
        CRITICAL
        ALLOW_ALL],
       :containerAnalysisVulnerabilityProjects [string]},
      :slsaCheck {:rules [VerificationRule]},
      :imageFreshnessCheck {:maxUploadAgeDays integer},
      :sigstoreSignatureCheck
      {:sigstoreAuthorities [SigstoreAuthority]},
      :alwaysDeny boolean,
      :trustedDirectoryCheck {:trustedDirPatterns [string]}}]}]},
 :updateTime string,
 :etag string}

optional:
policyId <string> Required. The platform policy ID."
  ([parent PlatformPolicy]
    (projects-platforms-policies-create parent PlatformPolicy nil))
  ([parent PlatformPolicy optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://binaryauthorization.googleapis.com/v1/{+parent}/policies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body PlatformPolicy})))

(defn projects-platforms-policies-get
  "Gets a platform policy. Returns `NOT_FOUND` if the policy doesn't exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.platforms.policies/get

name <string> Required. The name of the platform policy to retrieve in the format `projects/*/platforms/*/policies/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-platforms-policies-replacePlatformPolicy
  "Replaces a platform policy. Returns `NOT_FOUND` if the policy doesn't exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.platforms.policies/replacePlatformPolicy

name <string> Output only. The relative resource name of the Binary Authorization platform policy, in the form of `projects/*/platforms/*/policies/*`.
PlatformPolicy:
{:name string,
 :description string,
 :gkePolicy
 {:imageAllowlist {:allowPattern [string]},
  :checkSets
  [{:displayName string,
    :scope
    {:kubernetesServiceAccount string, :kubernetesNamespace string},
    :imageAllowlist {:allowPattern [string]},
    :checks
    [{:simpleSigningAttestationCheck
      {:attestationAuthenticators [AttestationAuthenticator],
       :containerAnalysisAttestationProjects [string]},
      :displayName string,
      :imageAllowlist {:allowPattern [string]},
      :vulnerabilityCheck
      {:allowedCves [string],
       :blockedCves [string],
       :maximumUnfixableSeverity
       [MAXIMUM_ALLOWED_SEVERITY_UNSPECIFIED
        BLOCK_ALL
        MINIMAL
        LOW
        MEDIUM
        HIGH
        CRITICAL
        ALLOW_ALL],
       :maximumFixableSeverity
       [MAXIMUM_ALLOWED_SEVERITY_UNSPECIFIED
        BLOCK_ALL
        MINIMAL
        LOW
        MEDIUM
        HIGH
        CRITICAL
        ALLOW_ALL],
       :containerAnalysisVulnerabilityProjects [string]},
      :slsaCheck {:rules [VerificationRule]},
      :imageFreshnessCheck {:maxUploadAgeDays integer},
      :sigstoreSignatureCheck
      {:sigstoreAuthorities [SigstoreAuthority]},
      :alwaysDeny boolean,
      :trustedDirectoryCheck {:trustedDirPatterns [string]}}]}]},
 :updateTime string,
 :etag string}"
  [name PlatformPolicy]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body PlatformPolicy}))

(defn projects-platforms-policies-list
  "Lists platform policies owned by a project in the specified platform. Returns `INVALID_ARGUMENT` if the project or the platform doesn't exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.platforms.policies/list

parent <string> Required. The resource name of the platform associated with the platform policies using the format `projects/*/platforms/*`.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server picks an appropriate default."
  ([parent] (projects-platforms-policies-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://binaryauthorization.googleapis.com/v1/{+parent}/policies",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-platforms-policies-delete
  "Deletes a platform policy. Returns `NOT_FOUND` if the policy doesn't exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.platforms.policies/delete

name <string> Required. The name of the platform policy to delete, in the format `projects/*/platforms/*/policies/*`.

optional:
etag <string> Optional. Used to prevent deleting the policy when another request has updated it since it was retrieved."
  ([name] (projects-platforms-policies-delete name nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://binaryauthorization.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-attestors-get
  "Gets an attestor. Returns `NOT_FOUND` if the attestor does not exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/get

name <string> Required. The name of the attestor to retrieve, in the format `projects/*/attestors/*`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-attestors-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-attestors-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-attestors-create
  "Creates an attestor, and returns a copy of the new attestor. Returns `NOT_FOUND` if the project does not exist, `INVALID_ARGUMENT` if the request is malformed, `ALREADY_EXISTS` if the attestor already exists.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/create

parent <string> Required. The parent of this attestor.
Attestor:
{:name string,
 :description string,
 :userOwnedGrafeasNote
 {:noteReference string,
  :publicKeys
  [{:comment string,
    :id string,
    :asciiArmoredPgpPublicKey string,
    :pkixPublicKey
    {:publicKeyPem string,
     :signatureAlgorithm
     [SIGNATURE_ALGORITHM_UNSPECIFIED
      RSA_PSS_2048_SHA256
      RSA_SIGN_PSS_2048_SHA256
      RSA_PSS_3072_SHA256
      RSA_SIGN_PSS_3072_SHA256
      RSA_PSS_4096_SHA256
      RSA_SIGN_PSS_4096_SHA256
      RSA_PSS_4096_SHA512
      RSA_SIGN_PSS_4096_SHA512
      RSA_SIGN_PKCS1_2048_SHA256
      RSA_SIGN_PKCS1_3072_SHA256
      RSA_SIGN_PKCS1_4096_SHA256
      RSA_SIGN_PKCS1_4096_SHA512
      ECDSA_P256_SHA256
      EC_SIGN_P256_SHA256
      ECDSA_P384_SHA384
      EC_SIGN_P384_SHA384
      ECDSA_P521_SHA512
      EC_SIGN_P521_SHA512],
     :keyId string}}],
  :delegationServiceAccountEmail string},
 :updateTime string,
 :etag string}

optional:
attestorId <string> Required. The attestors ID."
  ([parent Attestor] (projects-attestors-create parent Attestor nil))
  ([parent Attestor optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://binaryauthorization.googleapis.com/v1/{+parent}/attestors",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Attestor})))

(defn projects-attestors-update
  "Updates an attestor. Returns `NOT_FOUND` if the attestor does not exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/update

name <string> Required. The resource name, in the format: `projects/*/attestors/*`. This field may not be updated.
Attestor:
{:name string,
 :description string,
 :userOwnedGrafeasNote
 {:noteReference string,
  :publicKeys
  [{:comment string,
    :id string,
    :asciiArmoredPgpPublicKey string,
    :pkixPublicKey
    {:publicKeyPem string,
     :signatureAlgorithm
     [SIGNATURE_ALGORITHM_UNSPECIFIED
      RSA_PSS_2048_SHA256
      RSA_SIGN_PSS_2048_SHA256
      RSA_PSS_3072_SHA256
      RSA_SIGN_PSS_3072_SHA256
      RSA_PSS_4096_SHA256
      RSA_SIGN_PSS_4096_SHA256
      RSA_PSS_4096_SHA512
      RSA_SIGN_PSS_4096_SHA512
      RSA_SIGN_PKCS1_2048_SHA256
      RSA_SIGN_PKCS1_3072_SHA256
      RSA_SIGN_PKCS1_4096_SHA256
      RSA_SIGN_PKCS1_4096_SHA512
      ECDSA_P256_SHA256
      EC_SIGN_P256_SHA256
      ECDSA_P384_SHA384
      EC_SIGN_P384_SHA384
      ECDSA_P521_SHA512
      EC_SIGN_P521_SHA512],
     :keyId string}}],
  :delegationServiceAccountEmail string},
 :updateTime string,
 :etag string}"
  [name Attestor]
  (client/api-request
    {:method "PUT",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Attestor}))

(defn projects-attestors-delete
  "Deletes an attestor. Returns `NOT_FOUND` if the attestor does not exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/delete

name <string> Required. The name of the attestors to delete, in the format `projects/*/attestors/*`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-attestors-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-attestors-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://binaryauthorization.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-attestors-list
  "Lists attestors. Returns `INVALID_ARGUMENT` if the project does not exist.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/list

parent <string> Required. The resource name of the project associated with the attestors, in the format `projects/*`.

optional:
pageSize <integer> Requested page size. The server may return fewer results than requested. If unspecified, the server will pick an appropriate default."
  ([parent] (projects-attestors-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://binaryauthorization.googleapis.com/v1/{+parent}/attestors",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-attestors-validateAttestationOccurrence
  "Returns whether the given `Attestation` for the given image URI was signed by the given `Attestor`
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.attestors/validateAttestationOccurrence

attestor <string> Required. The resource name of the Attestor of the occurrence, in the format `projects/*/attestors/*`.
ValidateAttestationOccurrenceRequest:
{:attestation
 {:serializedPayload string,
  :signatures [{:signature string, :publicKeyId string}],
  :jwts [{:compactJwt string}]},
 :occurrenceNote string,
 :occurrenceResourceUri string}"
  [attestor ValidateAttestationOccurrenceRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+attestor}:validateAttestationOccurrence",
     :uri-template-args {:attestor attestor},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ValidateAttestationOccurrenceRequest}))

(defn projects-policy-setIamPolicy
  "Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.policy/setIamPolicy

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
  :etag string}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-policy-getIamPolicy
  "Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.policy/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource] (projects-policy-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://binaryauthorization.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-policy-testIamPermissions
  "Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/projects.policy/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn systempolicy-getPolicy
  "Gets the current system policy in the specified location.
https://cloud.google.com/binary-authorization/docs/reference/rest/v1/systempolicy/getPolicy

name <string> Required. The resource name, in the format `locations/*/policy`. Note that the system policy is not associated with a project."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://binaryauthorization.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

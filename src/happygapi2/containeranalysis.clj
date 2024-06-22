(ns happygapi2.containeranalysis
  "Container Analysis API
This API is a prerequisite for leveraging Artifact Analysis scanning capabilities in both Artifact Registry and with Advanced Vulnerability Insights (runtime scanning) in GKE. In addition, the Container Analysis API is an implementation of the Grafeas API, which enables storing, querying, and retrieval of critical metadata about all of your software artifacts.
See: https://cloud.google.com/artifact-analysis/docs/reference/rest"
  (:require [happy.oauth2.client :as client]))

(defn projects-occurrences-get
  "Gets the specified occurrence.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/get

name <string> Required. The name of the occurrence in the form of `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-occurrences-setIamPolicy
  "Sets the access control policy on the specified note or occurrence. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or an occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:bindings
  [{:members [string],
    :condition
    {:expression string,
     :location string,
     :description string,
     :title string},
    :role string}],
  :etag string,
  :version integer}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-occurrences-patch
  "Updates the specified occurrence.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/patch

name <string> Required. The name of the occurrence in the form of `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`.
Occurrence:
{:noteName string,
 :remediation string,
 :package
 {:architecture [ARCHITECTURE_UNSPECIFIED X86 X64],
  :cpeUri string,
  :name string,
  :version
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string},
  :license {:comments string, :expression string},
  :location
  [{:version
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :cpeUri string,
    :path string}],
  :packageType string},
 :envelope
 {:signatures [{:keyid string, :sig string}],
  :payload string,
  :payloadType string},
 :resourceUri string,
 :discovery
 {:archiveTime string,
  :analysisCompleted {:analysisType [string]},
  :lastScanTime string,
  :analysisStatus
  [ANALYSIS_STATUS_UNSPECIFIED
   PENDING
   SCANNING
   FINISHED_SUCCESS
   COMPLETE
   FINISHED_FAILED
   FINISHED_UNSUPPORTED],
  :continuousAnalysis
  [CONTINUOUS_ANALYSIS_UNSPECIFIED ACTIVE INACTIVE],
  :sbomStatus
  {:sbomState [SBOM_STATE_UNSPECIFIED PENDING COMPLETE],
   :error string},
  :analysisStatusError
  {:code integer, :message string, :details [object]},
  :analysisError [{:code integer, :message string, :details [object]}],
  :cpe string},
 :sbomReference
 {:payload
  {:predicateType string,
   :subject [{:digest object, :name string}],
   :predicate
   {:mimeType string,
    :digest object,
    :location string,
    :referrerId string},
   :_type string},
  :signatures [{:keyid string, :sig string}],
  :payloadType string},
 :name string,
 :createTime string,
 :vulnerability
 {:cvssv3
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH
    ATTACK_COMPLEXITY_MEDIUM],
   :authentication
   [AUTHENTICATION_UNSPECIFIED
    AUTHENTICATION_MULTIPLE
    AUTHENTICATION_SINGLE
    AUTHENTICATION_NONE],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE]},
  :relatedUrls [{:label string, :url string}],
  :type string,
  :cvssVersion
  [CVSS_VERSION_UNSPECIFIED CVSS_VERSION_2 CVSS_VERSION_3],
  :shortDescription string,
  :extraDetails string,
  :cvssScore number,
  :severity [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
  :fixAvailable boolean,
  :vexAssessment
  {:relatedUris [{:label string, :url string}],
   :vulnerabilityId string,
   :state
   [STATE_UNSPECIFIED AFFECTED NOT_AFFECTED FIXED UNDER_INVESTIGATION],
   :justification
   {:details string,
    :justificationType
    [JUSTIFICATION_TYPE_UNSPECIFIED
     COMPONENT_NOT_PRESENT
     VULNERABLE_CODE_NOT_PRESENT
     VULNERABLE_CODE_NOT_IN_EXECUTE_PATH
     VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY
     INLINE_MITIGATIONS_ALREADY_EXIST]},
   :impacts [string],
   :remediations
   [{:details string,
     :remediationType
     [REMEDIATION_TYPE_UNSPECIFIED
      MITIGATION
      NO_FIX_PLANNED
      NONE_AVAILABLE
      VENDOR_FIX
      WORKAROUND],
     :remediationUri {:label string, :url string}}],
   :cve string,
   :noteName string},
  :longDescription string,
  :cvssV2
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH
    ATTACK_COMPLEXITY_MEDIUM],
   :authentication
   [AUTHENTICATION_UNSPECIFIED
    AUTHENTICATION_MULTIPLE
    AUTHENTICATION_SINGLE
    AUTHENTICATION_NONE],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE]},
  :effectiveSeverity
  [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
  :packageIssue
  [{:affectedPackage string,
    :fixedCpeUri string,
    :affectedVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fileLocation [{:filePath string}],
    :affectedCpeUri string,
    :packageType string,
    :fixAvailable boolean,
    :fixedVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fixedPackage string,
    :effectiveSeverity
    [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL]}]},
 :updateTime string,
 :upgrade
 {:package string,
  :distribution
  {:cpeUri string,
   :severity string,
   :cve [string],
   :classification string},
  :parsedVersion
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string},
  :windowsUpdate
  {:kbArticleIds [string],
   :identity {:revision integer, :updateId string},
   :description string,
   :categories [{:categoryId string, :name string}],
   :title string,
   :lastPublishedTimestamp string,
   :supportUrl string}},
 :dsseAttestation
 {:envelope
  {:signatures [{:keyid string, :sig string}],
   :payload string,
   :payloadType string},
  :statement
  {:predicateType string,
   :subject [{:digest object, :name string}],
   :slsaProvenanceZeroTwo
   {:invocation
    {:parameters object,
     :configSource GrafeasV1SlsaProvenanceZeroTwoSlsaConfigSource,
     :environment object},
    :buildType string,
    :materials [{:uri string, :digest object}],
    :buildConfig object,
    :builder {:id string},
    :metadata
    {:completeness GrafeasV1SlsaProvenanceZeroTwoSlsaCompleteness,
     :buildStartedOn string,
     :reproducible boolean,
     :buildFinishedOn string,
     :buildInvocationId string}},
   :provenance
   {:metadata
    {:completeness Completeness,
     :buildInvocationId string,
     :buildStartedOn string,
     :buildFinishedOn string,
     :reproducible boolean},
    :builderConfig {:id string},
    :recipe
    {:environment [object],
     :arguments [object],
     :type string,
     :entryPoint string,
     :definedInMaterial string},
    :materials [string]},
   :slsaProvenance
   {:builder {:id string},
    :metadata
    {:buildStartedOn string,
     :completeness SlsaCompleteness,
     :buildFinishedOn string,
     :buildInvocationId string,
     :reproducible boolean},
    :recipe
    {:arguments object,
     :definedInMaterial string,
     :entryPoint string,
     :environment object,
     :type string},
    :materials [{:uri string, :digest object}]},
   :_type string}},
 :build
 {:intotoProvenance
  {:metadata
   {:completeness
    {:environment boolean, :materials boolean, :arguments boolean},
    :buildInvocationId string,
    :buildStartedOn string,
    :buildFinishedOn string,
    :reproducible boolean},
   :builderConfig {:id string},
   :recipe
   {:environment [object],
    :arguments [object],
    :type string,
    :entryPoint string,
    :definedInMaterial string},
   :materials [string]},
  :inTotoSlsaProvenanceV1
  {:subject [{:digest object, :name string}],
   :predicateType string,
   :_type string,
   :predicate
   {:buildDefinition
    {:internalParameters object,
     :resolvedDependencies [ResourceDescriptor],
     :externalParameters object,
     :buildType string},
    :runDetails
    {:byproducts [ResourceDescriptor],
     :builder ProvenanceBuilder,
     :metadata BuildMetadata}}},
  :provenance
  {:creator string,
   :triggerId string,
   :startTime string,
   :endTime string,
   :createTime string,
   :buildOptions object,
   :builderVersion string,
   :builtArtifacts [{:id string, :checksum string, :names [string]}],
   :commands
   [{:args [string],
     :env [string],
     :name string,
     :id string,
     :waitFor [string],
     :dir string}],
   :logsUri string,
   :id string,
   :sourceProvenance
   {:context
    {:labels object,
     :gerrit GerritSourceContext,
     :git GitSourceContext,
     :cloudRepo CloudRepoSourceContext},
    :additionalContexts
    [{:labels object,
      :gerrit GerritSourceContext,
      :git GitSourceContext,
      :cloudRepo CloudRepoSourceContext}],
    :fileHashes object,
    :artifactStorageSourceUri string},
   :projectId string},
  :intotoStatement
  {:predicateType string,
   :subject [{:digest object, :name string}],
   :slsaProvenanceZeroTwo
   {:invocation
    {:parameters object,
     :configSource GrafeasV1SlsaProvenanceZeroTwoSlsaConfigSource,
     :environment object},
    :buildType string,
    :materials [{:uri string, :digest object}],
    :buildConfig object,
    :builder {:id string},
    :metadata
    {:completeness GrafeasV1SlsaProvenanceZeroTwoSlsaCompleteness,
     :buildStartedOn string,
     :reproducible boolean,
     :buildFinishedOn string,
     :buildInvocationId string}},
   :provenance
   {:metadata
    {:completeness Completeness,
     :buildInvocationId string,
     :buildStartedOn string,
     :buildFinishedOn string,
     :reproducible boolean},
    :builderConfig {:id string},
    :recipe
    {:environment [object],
     :arguments [object],
     :type string,
     :entryPoint string,
     :definedInMaterial string},
    :materials [string]},
   :slsaProvenance
   {:builder {:id string},
    :metadata
    {:buildStartedOn string,
     :completeness SlsaCompleteness,
     :buildFinishedOn string,
     :buildInvocationId string,
     :reproducible boolean},
    :recipe
    {:arguments object,
     :definedInMaterial string,
     :entryPoint string,
     :environment object,
     :type string},
    :materials [{:uri string, :digest object}]},
   :_type string},
  :provenanceBytes string},
 :attestation
 {:jwts [{:compactJwt string}],
  :serializedPayload string,
  :signatures [{:publicKeyId string, :signature string}]},
 :kind
 [NOTE_KIND_UNSPECIFIED
  VULNERABILITY
  BUILD
  IMAGE
  PACKAGE
  DEPLOYMENT
  DISCOVERY
  ATTESTATION
  UPGRADE
  COMPLIANCE
  DSSE_ATTESTATION
  VULNERABILITY_ASSESSMENT
  SBOM_REFERENCE],
 :deployment
 {:userEmail string,
  :address string,
  :undeployTime string,
  :resourceUri [string],
  :platform [PLATFORM_UNSPECIFIED GKE FLEX CUSTOM],
  :deployTime string,
  :config string},
 :image
 {:fingerprint {:v2Name string, :v1Name string, :v2Blob [string]},
  :layerInfo [{:directive string, :arguments string}],
  :baseResourceUrl string,
  :distance integer},
 :compliance
 {:nonComplianceReason string,
  :version
  {:benchmarkDocument string, :version string, :cpeUri string},
  :nonCompliantFiles
  [{:displayCommand string, :reason string, :path string}]}}

optional:
updateMask <string> The fields to update."
  ([name Occurrence] (projects-occurrences-patch name Occurrence nil))
  ([name Occurrence optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Occurrence})))

(defn projects-occurrences-testIamPermissions
  "Returns the permissions that a caller has on the specified note or occurrence. Requires list permission on the project (for example, `containeranalysis.notes.list`). The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-occurrences-create
  "Creates a new occurrence.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/create

parent <string> Required. The name of the project in the form of `projects/[PROJECT_ID]`, under which the occurrence is to be created.
Occurrence:
{:noteName string,
 :remediation string,
 :package
 {:architecture [ARCHITECTURE_UNSPECIFIED X86 X64],
  :cpeUri string,
  :name string,
  :version
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string},
  :license {:comments string, :expression string},
  :location
  [{:version
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :cpeUri string,
    :path string}],
  :packageType string},
 :envelope
 {:signatures [{:keyid string, :sig string}],
  :payload string,
  :payloadType string},
 :resourceUri string,
 :discovery
 {:archiveTime string,
  :analysisCompleted {:analysisType [string]},
  :lastScanTime string,
  :analysisStatus
  [ANALYSIS_STATUS_UNSPECIFIED
   PENDING
   SCANNING
   FINISHED_SUCCESS
   COMPLETE
   FINISHED_FAILED
   FINISHED_UNSUPPORTED],
  :continuousAnalysis
  [CONTINUOUS_ANALYSIS_UNSPECIFIED ACTIVE INACTIVE],
  :sbomStatus
  {:sbomState [SBOM_STATE_UNSPECIFIED PENDING COMPLETE],
   :error string},
  :analysisStatusError
  {:code integer, :message string, :details [object]},
  :analysisError [{:code integer, :message string, :details [object]}],
  :cpe string},
 :sbomReference
 {:payload
  {:predicateType string,
   :subject [{:digest object, :name string}],
   :predicate
   {:mimeType string,
    :digest object,
    :location string,
    :referrerId string},
   :_type string},
  :signatures [{:keyid string, :sig string}],
  :payloadType string},
 :name string,
 :createTime string,
 :vulnerability
 {:cvssv3
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH
    ATTACK_COMPLEXITY_MEDIUM],
   :authentication
   [AUTHENTICATION_UNSPECIFIED
    AUTHENTICATION_MULTIPLE
    AUTHENTICATION_SINGLE
    AUTHENTICATION_NONE],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE]},
  :relatedUrls [{:label string, :url string}],
  :type string,
  :cvssVersion
  [CVSS_VERSION_UNSPECIFIED CVSS_VERSION_2 CVSS_VERSION_3],
  :shortDescription string,
  :extraDetails string,
  :cvssScore number,
  :severity [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
  :fixAvailable boolean,
  :vexAssessment
  {:relatedUris [{:label string, :url string}],
   :vulnerabilityId string,
   :state
   [STATE_UNSPECIFIED AFFECTED NOT_AFFECTED FIXED UNDER_INVESTIGATION],
   :justification
   {:details string,
    :justificationType
    [JUSTIFICATION_TYPE_UNSPECIFIED
     COMPONENT_NOT_PRESENT
     VULNERABLE_CODE_NOT_PRESENT
     VULNERABLE_CODE_NOT_IN_EXECUTE_PATH
     VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY
     INLINE_MITIGATIONS_ALREADY_EXIST]},
   :impacts [string],
   :remediations
   [{:details string,
     :remediationType
     [REMEDIATION_TYPE_UNSPECIFIED
      MITIGATION
      NO_FIX_PLANNED
      NONE_AVAILABLE
      VENDOR_FIX
      WORKAROUND],
     :remediationUri {:label string, :url string}}],
   :cve string,
   :noteName string},
  :longDescription string,
  :cvssV2
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH
    ATTACK_COMPLEXITY_MEDIUM],
   :authentication
   [AUTHENTICATION_UNSPECIFIED
    AUTHENTICATION_MULTIPLE
    AUTHENTICATION_SINGLE
    AUTHENTICATION_NONE],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE]},
  :effectiveSeverity
  [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
  :packageIssue
  [{:affectedPackage string,
    :fixedCpeUri string,
    :affectedVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fileLocation [{:filePath string}],
    :affectedCpeUri string,
    :packageType string,
    :fixAvailable boolean,
    :fixedVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fixedPackage string,
    :effectiveSeverity
    [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL]}]},
 :updateTime string,
 :upgrade
 {:package string,
  :distribution
  {:cpeUri string,
   :severity string,
   :cve [string],
   :classification string},
  :parsedVersion
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string},
  :windowsUpdate
  {:kbArticleIds [string],
   :identity {:revision integer, :updateId string},
   :description string,
   :categories [{:categoryId string, :name string}],
   :title string,
   :lastPublishedTimestamp string,
   :supportUrl string}},
 :dsseAttestation
 {:envelope
  {:signatures [{:keyid string, :sig string}],
   :payload string,
   :payloadType string},
  :statement
  {:predicateType string,
   :subject [{:digest object, :name string}],
   :slsaProvenanceZeroTwo
   {:invocation
    {:parameters object,
     :configSource GrafeasV1SlsaProvenanceZeroTwoSlsaConfigSource,
     :environment object},
    :buildType string,
    :materials [{:uri string, :digest object}],
    :buildConfig object,
    :builder {:id string},
    :metadata
    {:completeness GrafeasV1SlsaProvenanceZeroTwoSlsaCompleteness,
     :buildStartedOn string,
     :reproducible boolean,
     :buildFinishedOn string,
     :buildInvocationId string}},
   :provenance
   {:metadata
    {:completeness Completeness,
     :buildInvocationId string,
     :buildStartedOn string,
     :buildFinishedOn string,
     :reproducible boolean},
    :builderConfig {:id string},
    :recipe
    {:environment [object],
     :arguments [object],
     :type string,
     :entryPoint string,
     :definedInMaterial string},
    :materials [string]},
   :slsaProvenance
   {:builder {:id string},
    :metadata
    {:buildStartedOn string,
     :completeness SlsaCompleteness,
     :buildFinishedOn string,
     :buildInvocationId string,
     :reproducible boolean},
    :recipe
    {:arguments object,
     :definedInMaterial string,
     :entryPoint string,
     :environment object,
     :type string},
    :materials [{:uri string, :digest object}]},
   :_type string}},
 :build
 {:intotoProvenance
  {:metadata
   {:completeness
    {:environment boolean, :materials boolean, :arguments boolean},
    :buildInvocationId string,
    :buildStartedOn string,
    :buildFinishedOn string,
    :reproducible boolean},
   :builderConfig {:id string},
   :recipe
   {:environment [object],
    :arguments [object],
    :type string,
    :entryPoint string,
    :definedInMaterial string},
   :materials [string]},
  :inTotoSlsaProvenanceV1
  {:subject [{:digest object, :name string}],
   :predicateType string,
   :_type string,
   :predicate
   {:buildDefinition
    {:internalParameters object,
     :resolvedDependencies [ResourceDescriptor],
     :externalParameters object,
     :buildType string},
    :runDetails
    {:byproducts [ResourceDescriptor],
     :builder ProvenanceBuilder,
     :metadata BuildMetadata}}},
  :provenance
  {:creator string,
   :triggerId string,
   :startTime string,
   :endTime string,
   :createTime string,
   :buildOptions object,
   :builderVersion string,
   :builtArtifacts [{:id string, :checksum string, :names [string]}],
   :commands
   [{:args [string],
     :env [string],
     :name string,
     :id string,
     :waitFor [string],
     :dir string}],
   :logsUri string,
   :id string,
   :sourceProvenance
   {:context
    {:labels object,
     :gerrit GerritSourceContext,
     :git GitSourceContext,
     :cloudRepo CloudRepoSourceContext},
    :additionalContexts
    [{:labels object,
      :gerrit GerritSourceContext,
      :git GitSourceContext,
      :cloudRepo CloudRepoSourceContext}],
    :fileHashes object,
    :artifactStorageSourceUri string},
   :projectId string},
  :intotoStatement
  {:predicateType string,
   :subject [{:digest object, :name string}],
   :slsaProvenanceZeroTwo
   {:invocation
    {:parameters object,
     :configSource GrafeasV1SlsaProvenanceZeroTwoSlsaConfigSource,
     :environment object},
    :buildType string,
    :materials [{:uri string, :digest object}],
    :buildConfig object,
    :builder {:id string},
    :metadata
    {:completeness GrafeasV1SlsaProvenanceZeroTwoSlsaCompleteness,
     :buildStartedOn string,
     :reproducible boolean,
     :buildFinishedOn string,
     :buildInvocationId string}},
   :provenance
   {:metadata
    {:completeness Completeness,
     :buildInvocationId string,
     :buildStartedOn string,
     :buildFinishedOn string,
     :reproducible boolean},
    :builderConfig {:id string},
    :recipe
    {:environment [object],
     :arguments [object],
     :type string,
     :entryPoint string,
     :definedInMaterial string},
    :materials [string]},
   :slsaProvenance
   {:builder {:id string},
    :metadata
    {:buildStartedOn string,
     :completeness SlsaCompleteness,
     :buildFinishedOn string,
     :buildInvocationId string,
     :reproducible boolean},
    :recipe
    {:arguments object,
     :definedInMaterial string,
     :entryPoint string,
     :environment object,
     :type string},
    :materials [{:uri string, :digest object}]},
   :_type string},
  :provenanceBytes string},
 :attestation
 {:jwts [{:compactJwt string}],
  :serializedPayload string,
  :signatures [{:publicKeyId string, :signature string}]},
 :kind
 [NOTE_KIND_UNSPECIFIED
  VULNERABILITY
  BUILD
  IMAGE
  PACKAGE
  DEPLOYMENT
  DISCOVERY
  ATTESTATION
  UPGRADE
  COMPLIANCE
  DSSE_ATTESTATION
  VULNERABILITY_ASSESSMENT
  SBOM_REFERENCE],
 :deployment
 {:userEmail string,
  :address string,
  :undeployTime string,
  :resourceUri [string],
  :platform [PLATFORM_UNSPECIFIED GKE FLEX CUSTOM],
  :deployTime string,
  :config string},
 :image
 {:fingerprint {:v2Name string, :v1Name string, :v2Blob [string]},
  :layerInfo [{:directive string, :arguments string}],
  :baseResourceUrl string,
  :distance integer},
 :compliance
 {:nonComplianceReason string,
  :version
  {:benchmarkDocument string, :version string, :cpeUri string},
  :nonCompliantFiles
  [{:displayCommand string, :reason string, :path string}]}}"
  [parent Occurrence]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+parent}/occurrences",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body Occurrence}))

(defn projects-occurrences-batchCreate
  "Creates new occurrences in batch.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/batchCreate

parent <string> Required. The name of the project in the form of `projects/[PROJECT_ID]`, under which the occurrences are to be created.
BatchCreateOccurrencesRequest:
{:occurrences
 [{:noteName string,
   :remediation string,
   :package
   {:architecture [ARCHITECTURE_UNSPECIFIED X86 X64],
    :cpeUri string,
    :name string,
    :version
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :license {:comments string, :expression string},
    :location
    [{:version
      {:epoch integer,
       :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
       :name string,
       :inclusive boolean,
       :revision string,
       :fullName string},
      :cpeUri string,
      :path string}],
    :packageType string},
   :envelope
   {:signatures [{:keyid string, :sig string}],
    :payload string,
    :payloadType string},
   :resourceUri string,
   :discovery
   {:archiveTime string,
    :analysisCompleted {:analysisType [string]},
    :lastScanTime string,
    :analysisStatus
    [ANALYSIS_STATUS_UNSPECIFIED
     PENDING
     SCANNING
     FINISHED_SUCCESS
     COMPLETE
     FINISHED_FAILED
     FINISHED_UNSUPPORTED],
    :continuousAnalysis
    [CONTINUOUS_ANALYSIS_UNSPECIFIED ACTIVE INACTIVE],
    :sbomStatus
    {:sbomState [SBOM_STATE_UNSPECIFIED PENDING COMPLETE],
     :error string},
    :analysisStatusError
    {:code integer, :message string, :details [object]},
    :analysisError
    [{:code integer, :message string, :details [object]}],
    :cpe string},
   :sbomReference
   {:payload
    {:predicateType string,
     :subject [{:digest object, :name string}],
     :predicate
     {:mimeType string,
      :digest object,
      :location string,
      :referrerId string},
     :_type string},
    :signatures [{:keyid string, :sig string}],
    :payloadType string},
   :name string,
   :createTime string,
   :vulnerability
   {:cvssv3
    {:privilegesRequired
     [PRIVILEGES_REQUIRED_UNSPECIFIED
      PRIVILEGES_REQUIRED_NONE
      PRIVILEGES_REQUIRED_LOW
      PRIVILEGES_REQUIRED_HIGH],
     :availabilityImpact
     [IMPACT_UNSPECIFIED
      IMPACT_HIGH
      IMPACT_LOW
      IMPACT_NONE
      IMPACT_PARTIAL
      IMPACT_COMPLETE],
     :impactScore number,
     :baseScore number,
     :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
     :userInteraction
     [USER_INTERACTION_UNSPECIFIED
      USER_INTERACTION_NONE
      USER_INTERACTION_REQUIRED],
     :attackVector
     [ATTACK_VECTOR_UNSPECIFIED
      ATTACK_VECTOR_NETWORK
      ATTACK_VECTOR_ADJACENT
      ATTACK_VECTOR_LOCAL
      ATTACK_VECTOR_PHYSICAL],
     :attackComplexity
     [ATTACK_COMPLEXITY_UNSPECIFIED
      ATTACK_COMPLEXITY_LOW
      ATTACK_COMPLEXITY_HIGH
      ATTACK_COMPLEXITY_MEDIUM],
     :authentication
     [AUTHENTICATION_UNSPECIFIED
      AUTHENTICATION_MULTIPLE
      AUTHENTICATION_SINGLE
      AUTHENTICATION_NONE],
     :confidentialityImpact
     [IMPACT_UNSPECIFIED
      IMPACT_HIGH
      IMPACT_LOW
      IMPACT_NONE
      IMPACT_PARTIAL
      IMPACT_COMPLETE],
     :exploitabilityScore number,
     :integrityImpact
     [IMPACT_UNSPECIFIED
      IMPACT_HIGH
      IMPACT_LOW
      IMPACT_NONE
      IMPACT_PARTIAL
      IMPACT_COMPLETE]},
    :relatedUrls [{:label string, :url string}],
    :type string,
    :cvssVersion
    [CVSS_VERSION_UNSPECIFIED CVSS_VERSION_2 CVSS_VERSION_3],
    :shortDescription string,
    :extraDetails string,
    :cvssScore number,
    :severity [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
    :fixAvailable boolean,
    :vexAssessment
    {:relatedUris [{:label string, :url string}],
     :vulnerabilityId string,
     :state
     [STATE_UNSPECIFIED
      AFFECTED
      NOT_AFFECTED
      FIXED
      UNDER_INVESTIGATION],
     :justification
     {:details string,
      :justificationType
      [JUSTIFICATION_TYPE_UNSPECIFIED
       COMPONENT_NOT_PRESENT
       VULNERABLE_CODE_NOT_PRESENT
       VULNERABLE_CODE_NOT_IN_EXECUTE_PATH
       VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY
       INLINE_MITIGATIONS_ALREADY_EXIST]},
     :impacts [string],
     :remediations
     [{:details string,
       :remediationType
       [REMEDIATION_TYPE_UNSPECIFIED
        MITIGATION
        NO_FIX_PLANNED
        NONE_AVAILABLE
        VENDOR_FIX
        WORKAROUND],
       :remediationUri RelatedUrl}],
     :cve string,
     :noteName string},
    :longDescription string,
    :cvssV2
    {:privilegesRequired
     [PRIVILEGES_REQUIRED_UNSPECIFIED
      PRIVILEGES_REQUIRED_NONE
      PRIVILEGES_REQUIRED_LOW
      PRIVILEGES_REQUIRED_HIGH],
     :availabilityImpact
     [IMPACT_UNSPECIFIED
      IMPACT_HIGH
      IMPACT_LOW
      IMPACT_NONE
      IMPACT_PARTIAL
      IMPACT_COMPLETE],
     :impactScore number,
     :baseScore number,
     :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
     :userInteraction
     [USER_INTERACTION_UNSPECIFIED
      USER_INTERACTION_NONE
      USER_INTERACTION_REQUIRED],
     :attackVector
     [ATTACK_VECTOR_UNSPECIFIED
      ATTACK_VECTOR_NETWORK
      ATTACK_VECTOR_ADJACENT
      ATTACK_VECTOR_LOCAL
      ATTACK_VECTOR_PHYSICAL],
     :attackComplexity
     [ATTACK_COMPLEXITY_UNSPECIFIED
      ATTACK_COMPLEXITY_LOW
      ATTACK_COMPLEXITY_HIGH
      ATTACK_COMPLEXITY_MEDIUM],
     :authentication
     [AUTHENTICATION_UNSPECIFIED
      AUTHENTICATION_MULTIPLE
      AUTHENTICATION_SINGLE
      AUTHENTICATION_NONE],
     :confidentialityImpact
     [IMPACT_UNSPECIFIED
      IMPACT_HIGH
      IMPACT_LOW
      IMPACT_NONE
      IMPACT_PARTIAL
      IMPACT_COMPLETE],
     :exploitabilityScore number,
     :integrityImpact
     [IMPACT_UNSPECIFIED
      IMPACT_HIGH
      IMPACT_LOW
      IMPACT_NONE
      IMPACT_PARTIAL
      IMPACT_COMPLETE]},
    :effectiveSeverity
    [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
    :packageIssue
    [{:affectedPackage string,
      :fixedCpeUri string,
      :affectedVersion
      {:epoch integer,
       :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
       :name string,
       :inclusive boolean,
       :revision string,
       :fullName string},
      :fileLocation [{:filePath string}],
      :affectedCpeUri string,
      :packageType string,
      :fixAvailable boolean,
      :fixedVersion
      {:epoch integer,
       :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
       :name string,
       :inclusive boolean,
       :revision string,
       :fullName string},
      :fixedPackage string,
      :effectiveSeverity
      [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL]}]},
   :updateTime string,
   :upgrade
   {:package string,
    :distribution
    {:cpeUri string,
     :severity string,
     :cve [string],
     :classification string},
    :parsedVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :windowsUpdate
    {:kbArticleIds [string],
     :identity {:revision integer, :updateId string},
     :description string,
     :categories [{:categoryId string, :name string}],
     :title string,
     :lastPublishedTimestamp string,
     :supportUrl string}},
   :dsseAttestation
   {:envelope
    {:signatures [{:keyid string, :sig string}],
     :payload string,
     :payloadType string},
    :statement
    {:predicateType string,
     :subject [{:digest object, :name string}],
     :slsaProvenanceZeroTwo
     {:invocation GrafeasV1SlsaProvenanceZeroTwoSlsaInvocation,
      :buildType string,
      :materials [GrafeasV1SlsaProvenanceZeroTwoSlsaMaterial],
      :buildConfig object,
      :builder GrafeasV1SlsaProvenanceZeroTwoSlsaBuilder,
      :metadata GrafeasV1SlsaProvenanceZeroTwoSlsaMetadata},
     :provenance
     {:metadata Metadata,
      :builderConfig BuilderConfig,
      :recipe Recipe,
      :materials [string]},
     :slsaProvenance
     {:builder SlsaBuilder,
      :metadata SlsaMetadata,
      :recipe SlsaRecipe,
      :materials [Material]},
     :_type string}},
   :build
   {:intotoProvenance
    {:metadata
     {:completeness Completeness,
      :buildInvocationId string,
      :buildStartedOn string,
      :buildFinishedOn string,
      :reproducible boolean},
     :builderConfig {:id string},
     :recipe
     {:environment [object],
      :arguments [object],
      :type string,
      :entryPoint string,
      :definedInMaterial string},
     :materials [string]},
    :inTotoSlsaProvenanceV1
    {:subject [{:digest object, :name string}],
     :predicateType string,
     :_type string,
     :predicate
     {:buildDefinition BuildDefinition, :runDetails RunDetails}},
    :provenance
    {:creator string,
     :triggerId string,
     :startTime string,
     :endTime string,
     :createTime string,
     :buildOptions object,
     :builderVersion string,
     :builtArtifacts [{:id string, :checksum string, :names [string]}],
     :commands
     [{:args [string],
       :env [string],
       :name string,
       :id string,
       :waitFor [string],
       :dir string}],
     :logsUri string,
     :id string,
     :sourceProvenance
     {:context SourceContext,
      :additionalContexts [SourceContext],
      :fileHashes object,
      :artifactStorageSourceUri string},
     :projectId string},
    :intotoStatement
    {:predicateType string,
     :subject [{:digest object, :name string}],
     :slsaProvenanceZeroTwo
     {:invocation GrafeasV1SlsaProvenanceZeroTwoSlsaInvocation,
      :buildType string,
      :materials [GrafeasV1SlsaProvenanceZeroTwoSlsaMaterial],
      :buildConfig object,
      :builder GrafeasV1SlsaProvenanceZeroTwoSlsaBuilder,
      :metadata GrafeasV1SlsaProvenanceZeroTwoSlsaMetadata},
     :provenance
     {:metadata Metadata,
      :builderConfig BuilderConfig,
      :recipe Recipe,
      :materials [string]},
     :slsaProvenance
     {:builder SlsaBuilder,
      :metadata SlsaMetadata,
      :recipe SlsaRecipe,
      :materials [Material]},
     :_type string},
    :provenanceBytes string},
   :attestation
   {:jwts [{:compactJwt string}],
    :serializedPayload string,
    :signatures [{:publicKeyId string, :signature string}]},
   :kind
   [NOTE_KIND_UNSPECIFIED
    VULNERABILITY
    BUILD
    IMAGE
    PACKAGE
    DEPLOYMENT
    DISCOVERY
    ATTESTATION
    UPGRADE
    COMPLIANCE
    DSSE_ATTESTATION
    VULNERABILITY_ASSESSMENT
    SBOM_REFERENCE],
   :deployment
   {:userEmail string,
    :address string,
    :undeployTime string,
    :resourceUri [string],
    :platform [PLATFORM_UNSPECIFIED GKE FLEX CUSTOM],
    :deployTime string,
    :config string},
   :image
   {:fingerprint {:v2Name string, :v1Name string, :v2Blob [string]},
    :layerInfo [{:directive string, :arguments string}],
    :baseResourceUrl string,
    :distance integer},
   :compliance
   {:nonComplianceReason string,
    :version
    {:benchmarkDocument string, :version string, :cpeUri string},
    :nonCompliantFiles
    [{:displayCommand string, :reason string, :path string}]}}]}"
  [parent BatchCreateOccurrencesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+parent}/occurrences:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchCreateOccurrencesRequest}))

(defn projects-occurrences-delete
  "Deletes the specified occurrence. For example, use this method to delete an occurrence when the occurrence is no longer applicable for the given resource.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/delete

name <string> Required. The name of the occurrence in the form of `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-occurrences-getVulnerabilitySummary
  "Gets a summary of the number and severity of occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/getVulnerabilitySummary

parent <string> Required. The name of the project to get a vulnerability summary for in the form of `projects/[PROJECT_ID]`.

optional:
filter <string> The filter expression."
  ([parent] (projects-occurrences-getVulnerabilitySummary parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+parent}/occurrences:vulnerabilitySummary",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-occurrences-getIamPolicy
  "Gets the access control policy for a note or an occurrence resource. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-occurrences-list
  "Lists occurrences for the specified project.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/list

parent <string> Required. The name of the project to list occurrences for in the form of `projects/[PROJECT_ID]`.

optional:
pageSize <integer> Number of occurrences to return in the list. Must be positive. Max allowed page size is 1000. If not specified, page size defaults to 20.
filter <string> The filter expression."
  ([parent] (projects-occurrences-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+parent}/occurrences",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-occurrences-getNotes
  "Gets the note attached to the specified occurrence. Consumer projects can use this method to get a note that belongs to a provider project.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.occurrences/getNotes

name <string> Required. The name of the occurrence in the form of `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}/notes",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-occurrences-get
  "Gets the specified occurrence.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.occurrences/get

name <string> Required. The name of the occurrence in the form of `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-occurrences-getVulnerabilitySummary
  "Gets a summary of the number and severity of occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.occurrences/getVulnerabilitySummary

parent <string> Required. The name of the project to get a vulnerability summary for in the form of `projects/[PROJECT_ID]`.

optional:
filter <string> The filter expression."
  ([parent]
    (projects-locations-occurrences-getVulnerabilitySummary
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+parent}/occurrences:vulnerabilitySummary",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-occurrences-list
  "Lists occurrences for the specified project.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.occurrences/list

parent <string> Required. The name of the project to list occurrences for in the form of `projects/[PROJECT_ID]`.

optional:
filter <string> The filter expression.
pageSize <integer> Number of occurrences to return in the list. Must be positive. Max allowed page size is 1000. If not specified, page size defaults to 20."
  ([parent] (projects-locations-occurrences-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+parent}/occurrences",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-occurrences-getNotes
  "Gets the note attached to the specified occurrence. Consumer projects can use this method to get a note that belongs to a provider project.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.occurrences/getNotes

name <string> Required. The name of the occurrence in the form of `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}/notes",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-resources-exportSBOM
  "Generates an SBOM for the given resource.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.resources/exportSBOM

name <string> Required. The name of the resource in the form of `projects/[PROJECT_ID]/resources/[RESOURCE_URL]`.
ExportSBOMRequest:
{:cloudStorageLocation object}"
  [name ExportSBOMRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}:exportSBOM",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportSBOMRequest}))

(defn projects-locations-notes-get
  "Gets the specified note.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.notes/get

name <string> Required. The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-notes-list
  "Lists notes for the specified project.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.notes/list

parent <string> Required. The name of the project to list notes for in the form of `projects/[PROJECT_ID]`.

optional:
pageSize <integer> Number of notes to return in the list. Must be positive. Max allowed page size is 1000. If not specified, page size defaults to 20.
filter <string> The filter expression."
  ([parent] (projects-locations-notes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+parent}/notes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-notes-occurrences-list
  "Lists occurrences referencing the specified note. Provider projects can use this method to get all occurrences across consumer projects referencing the specified note.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.locations.notes.occurrences/list

name <string> Required. The name of the note to list occurrences for in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.

optional:
filter <string> The filter expression.
pageSize <integer> Number of occurrences to return in the list."
  ([name] (projects-locations-notes-occurrences-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+name}/occurrences",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-resources-exportSBOM
  "Generates an SBOM for the given resource.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.resources/exportSBOM

name <string> Required. The name of the resource in the form of `projects/[PROJECT_ID]/resources/[RESOURCE_URL]`.
ExportSBOMRequest:
{:cloudStorageLocation object}"
  [name ExportSBOMRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}:exportSBOM",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ExportSBOMRequest}))

(defn projects-notes-get
  "Gets the specified note.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/get

name <string> Required. The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-notes-setIamPolicy
  "Sets the access control policy on the specified note or occurrence. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or an occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/setIamPolicy

resource <string> REQUIRED: The resource for which the policy is being specified. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
SetIamPolicyRequest:
{:policy
 {:bindings
  [{:members [string],
    :condition
    {:expression string,
     :location string,
     :description string,
     :title string},
    :role string}],
  :etag string,
  :version integer}}"
  [resource SetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-notes-patch
  "Updates the specified note.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/patch

name <string> Required. The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.
Note:
{:relatedUrl [{:label string, :url string}],
 :package
 {:maintainer string,
  :description string,
  :architecture [ARCHITECTURE_UNSPECIFIED X86 X64],
  :license {:comments string, :expression string},
  :name string,
  :packageType string,
  :digest [{:algo string, :digestBytes string}],
  :cpeUri string,
  :url string,
  :distribution
  [{:url string,
    :description string,
    :architecture [ARCHITECTURE_UNSPECIFIED X86 X64],
    :latestVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :cpeUri string,
    :maintainer string}],
  :version
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string}},
 :vulnerabilityAssessment
 {:languageCode string,
  :assessment
  {:impacts [string],
   :relatedUris [{:label string, :url string}],
   :cve string,
   :state
   [STATE_UNSPECIFIED AFFECTED NOT_AFFECTED FIXED UNDER_INVESTIGATION],
   :vulnerabilityId string,
   :shortDescription string,
   :justification
   {:details string,
    :justificationType
    [JUSTIFICATION_TYPE_UNSPECIFIED
     COMPONENT_NOT_PRESENT
     VULNERABLE_CODE_NOT_PRESENT
     VULNERABLE_CODE_NOT_IN_EXECUTE_PATH
     VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY
     INLINE_MITIGATIONS_ALREADY_EXIST]},
   :remediations
   [{:details string,
     :remediationType
     [REMEDIATION_TYPE_UNSPECIFIED
      MITIGATION
      NO_FIX_PLANNED
      NONE_AVAILABLE
      VENDOR_FIX
      WORKAROUND],
     :remediationUri {:label string, :url string}}],
   :longDescription string},
  :shortDescription string,
  :title string,
  :product {:genericUri string, :name string, :id string},
  :longDescription string,
  :publisher
  {:name string,
   :publisherNamespace string,
   :issuingAuthority string}},
 :discovery
 {:analysisKind
  [NOTE_KIND_UNSPECIFIED
   VULNERABILITY
   BUILD
   IMAGE
   PACKAGE
   DEPLOYMENT
   DISCOVERY
   ATTESTATION
   UPGRADE
   COMPLIANCE
   DSSE_ATTESTATION
   VULNERABILITY_ASSESSMENT
   SBOM_REFERENCE]},
 :relatedNoteNames [string],
 :sbomReference {:format string, :version string},
 :expirationTime string,
 :name string,
 :createTime string,
 :vulnerability
 {:windowsDetails
  [{:name string,
    :fixingKbs [{:name string, :url string}],
    :cpeUri string,
    :description string}],
  :cvssV3
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE]},
  :cvssV2
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH
    ATTACK_COMPLEXITY_MEDIUM],
   :authentication
   [AUTHENTICATION_UNSPECIFIED
    AUTHENTICATION_MULTIPLE
    AUTHENTICATION_SINGLE
    AUTHENTICATION_NONE],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE]},
  :cvssVersion
  [CVSS_VERSION_UNSPECIFIED CVSS_VERSION_2 CVSS_VERSION_3],
  :cvssScore number,
  :details
  [{:description string,
    :vendor string,
    :affectedPackage string,
    :sourceUpdateTime string,
    :affectedVersionStart
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fixedCpeUri string,
    :isObsolete boolean,
    :affectedCpeUri string,
    :packageType string,
    :source string,
    :fixedVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :severityName string,
    :affectedVersionEnd
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fixedPackage string}],
  :sourceUpdateTime string,
  :severity [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL]},
 :updateTime string,
 :shortDescription string,
 :upgrade
 {:version
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string},
  :windowsUpdate
  {:kbArticleIds [string],
   :identity {:revision integer, :updateId string},
   :description string,
   :categories [{:categoryId string, :name string}],
   :title string,
   :lastPublishedTimestamp string,
   :supportUrl string},
  :package string,
  :distributions
  [{:cpeUri string,
    :severity string,
    :cve [string],
    :classification string}]},
 :dsseAttestation {:hint {:humanReadableName string}},
 :build {:builderVersion string},
 :attestation {:hint {:humanReadableName string}},
 :kind
 [NOTE_KIND_UNSPECIFIED
  VULNERABILITY
  BUILD
  IMAGE
  PACKAGE
  DEPLOYMENT
  DISCOVERY
  ATTESTATION
  UPGRADE
  COMPLIANCE
  DSSE_ATTESTATION
  VULNERABILITY_ASSESSMENT
  SBOM_REFERENCE],
 :deployment {:resourceUri [string]},
 :image
 {:resourceUrl string,
  :fingerprint {:v2Name string, :v1Name string, :v2Blob [string]}},
 :longDescription string,
 :compliance
 {:version
  [{:benchmarkDocument string, :version string, :cpeUri string}],
  :description string,
  :rationale string,
  :remediation string,
  :cisBenchmark
  {:severity [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
   :profileLevel integer},
  :scanInstructions string,
  :title string,
  :impact string}}

optional:
updateMask <string> The fields to update."
  ([name Note] (projects-notes-patch name Note nil))
  ([name Note optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Note})))

(defn projects-notes-testIamPermissions
  "Returns the permissions that a caller has on the specified note or occurrence. Requires list permission on the project (for example, `containeranalysis.notes.list`). The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body TestIamPermissionsRequest}))

(defn projects-notes-create
  "Creates a new note.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/create

parent <string> Required. The name of the project in the form of `projects/[PROJECT_ID]`, under which the note is to be created.
Note:
{:relatedUrl [{:label string, :url string}],
 :package
 {:maintainer string,
  :description string,
  :architecture [ARCHITECTURE_UNSPECIFIED X86 X64],
  :license {:comments string, :expression string},
  :name string,
  :packageType string,
  :digest [{:algo string, :digestBytes string}],
  :cpeUri string,
  :url string,
  :distribution
  [{:url string,
    :description string,
    :architecture [ARCHITECTURE_UNSPECIFIED X86 X64],
    :latestVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :cpeUri string,
    :maintainer string}],
  :version
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string}},
 :vulnerabilityAssessment
 {:languageCode string,
  :assessment
  {:impacts [string],
   :relatedUris [{:label string, :url string}],
   :cve string,
   :state
   [STATE_UNSPECIFIED AFFECTED NOT_AFFECTED FIXED UNDER_INVESTIGATION],
   :vulnerabilityId string,
   :shortDescription string,
   :justification
   {:details string,
    :justificationType
    [JUSTIFICATION_TYPE_UNSPECIFIED
     COMPONENT_NOT_PRESENT
     VULNERABLE_CODE_NOT_PRESENT
     VULNERABLE_CODE_NOT_IN_EXECUTE_PATH
     VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY
     INLINE_MITIGATIONS_ALREADY_EXIST]},
   :remediations
   [{:details string,
     :remediationType
     [REMEDIATION_TYPE_UNSPECIFIED
      MITIGATION
      NO_FIX_PLANNED
      NONE_AVAILABLE
      VENDOR_FIX
      WORKAROUND],
     :remediationUri {:label string, :url string}}],
   :longDescription string},
  :shortDescription string,
  :title string,
  :product {:genericUri string, :name string, :id string},
  :longDescription string,
  :publisher
  {:name string,
   :publisherNamespace string,
   :issuingAuthority string}},
 :discovery
 {:analysisKind
  [NOTE_KIND_UNSPECIFIED
   VULNERABILITY
   BUILD
   IMAGE
   PACKAGE
   DEPLOYMENT
   DISCOVERY
   ATTESTATION
   UPGRADE
   COMPLIANCE
   DSSE_ATTESTATION
   VULNERABILITY_ASSESSMENT
   SBOM_REFERENCE]},
 :relatedNoteNames [string],
 :sbomReference {:format string, :version string},
 :expirationTime string,
 :name string,
 :createTime string,
 :vulnerability
 {:windowsDetails
  [{:name string,
    :fixingKbs [{:name string, :url string}],
    :cpeUri string,
    :description string}],
  :cvssV3
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED IMPACT_HIGH IMPACT_LOW IMPACT_NONE]},
  :cvssV2
  {:privilegesRequired
   [PRIVILEGES_REQUIRED_UNSPECIFIED
    PRIVILEGES_REQUIRED_NONE
    PRIVILEGES_REQUIRED_LOW
    PRIVILEGES_REQUIRED_HIGH],
   :availabilityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :impactScore number,
   :baseScore number,
   :scope [SCOPE_UNSPECIFIED SCOPE_UNCHANGED SCOPE_CHANGED],
   :userInteraction
   [USER_INTERACTION_UNSPECIFIED
    USER_INTERACTION_NONE
    USER_INTERACTION_REQUIRED],
   :attackVector
   [ATTACK_VECTOR_UNSPECIFIED
    ATTACK_VECTOR_NETWORK
    ATTACK_VECTOR_ADJACENT
    ATTACK_VECTOR_LOCAL
    ATTACK_VECTOR_PHYSICAL],
   :attackComplexity
   [ATTACK_COMPLEXITY_UNSPECIFIED
    ATTACK_COMPLEXITY_LOW
    ATTACK_COMPLEXITY_HIGH
    ATTACK_COMPLEXITY_MEDIUM],
   :authentication
   [AUTHENTICATION_UNSPECIFIED
    AUTHENTICATION_MULTIPLE
    AUTHENTICATION_SINGLE
    AUTHENTICATION_NONE],
   :confidentialityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE],
   :exploitabilityScore number,
   :integrityImpact
   [IMPACT_UNSPECIFIED
    IMPACT_HIGH
    IMPACT_LOW
    IMPACT_NONE
    IMPACT_PARTIAL
    IMPACT_COMPLETE]},
  :cvssVersion
  [CVSS_VERSION_UNSPECIFIED CVSS_VERSION_2 CVSS_VERSION_3],
  :cvssScore number,
  :details
  [{:description string,
    :vendor string,
    :affectedPackage string,
    :sourceUpdateTime string,
    :affectedVersionStart
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fixedCpeUri string,
    :isObsolete boolean,
    :affectedCpeUri string,
    :packageType string,
    :source string,
    :fixedVersion
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :severityName string,
    :affectedVersionEnd
    {:epoch integer,
     :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
     :name string,
     :inclusive boolean,
     :revision string,
     :fullName string},
    :fixedPackage string}],
  :sourceUpdateTime string,
  :severity [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL]},
 :updateTime string,
 :shortDescription string,
 :upgrade
 {:version
  {:epoch integer,
   :kind [VERSION_KIND_UNSPECIFIED NORMAL MINIMUM MAXIMUM],
   :name string,
   :inclusive boolean,
   :revision string,
   :fullName string},
  :windowsUpdate
  {:kbArticleIds [string],
   :identity {:revision integer, :updateId string},
   :description string,
   :categories [{:categoryId string, :name string}],
   :title string,
   :lastPublishedTimestamp string,
   :supportUrl string},
  :package string,
  :distributions
  [{:cpeUri string,
    :severity string,
    :cve [string],
    :classification string}]},
 :dsseAttestation {:hint {:humanReadableName string}},
 :build {:builderVersion string},
 :attestation {:hint {:humanReadableName string}},
 :kind
 [NOTE_KIND_UNSPECIFIED
  VULNERABILITY
  BUILD
  IMAGE
  PACKAGE
  DEPLOYMENT
  DISCOVERY
  ATTESTATION
  UPGRADE
  COMPLIANCE
  DSSE_ATTESTATION
  VULNERABILITY_ASSESSMENT
  SBOM_REFERENCE],
 :deployment {:resourceUri [string]},
 :image
 {:resourceUrl string,
  :fingerprint {:v2Name string, :v1Name string, :v2Blob [string]}},
 :longDescription string,
 :compliance
 {:version
  [{:benchmarkDocument string, :version string, :cpeUri string}],
  :description string,
  :rationale string,
  :remediation string,
  :cisBenchmark
  {:severity [SEVERITY_UNSPECIFIED MINIMAL LOW MEDIUM HIGH CRITICAL],
   :profileLevel integer},
  :scanInstructions string,
  :title string,
  :impact string}}

optional:
noteId <string> Required. The ID to use for this note."
  ([parent Note] (projects-notes-create parent Note nil))
  ([parent Note optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+parent}/notes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Note})))

(defn projects-notes-batchCreate
  "Creates new notes in batch.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/batchCreate

parent <string> Required. The name of the project in the form of `projects/[PROJECT_ID]`, under which the notes are to be created.
BatchCreateNotesRequest:
{:notes object}"
  [parent BatchCreateNotesRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+parent}/notes:batchCreate",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchCreateNotesRequest}))

(defn projects-notes-delete
  "Deletes the specified note.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/delete

name <string> Required. The name of the note in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-notes-getIamPolicy
  "Gets the access control policy for a note or an occurrence resource. Requires `containeranalysis.notes.setIamPolicy` or `containeranalysis.occurrences.setIamPolicy` permission if the resource is a note or occurrence, respectively. The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for occurrences.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
GetIamPolicyRequest:
{:options {:requestedPolicyVersion integer}}"
  [resource GetIamPolicyRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://containeranalysis.googleapis.com/v1/{+resource}:getIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body GetIamPolicyRequest}))

(defn projects-notes-list
  "Lists notes for the specified project.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes/list

parent <string> Required. The name of the project to list notes for in the form of `projects/[PROJECT_ID]`.

optional:
filter <string> The filter expression.
pageSize <integer> Number of notes to return in the list. Must be positive. Max allowed page size is 1000. If not specified, page size defaults to 20."
  ([parent] (projects-notes-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+parent}/notes",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-notes-occurrences-list
  "Lists occurrences referencing the specified note. Provider projects can use this method to get all occurrences across consumer projects referencing the specified note.
https://cloud.google.com/artifact-analysis/docs/reference/rest/v1/projects.notes.occurrences/list

name <string> Required. The name of the note to list occurrences for in the form of `projects/[PROVIDER_ID]/notes/[NOTE_ID]`.

optional:
filter <string> The filter expression.
pageSize <integer> Number of occurrences to return in the list."
  ([name] (projects-notes-occurrences-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://containeranalysis.googleapis.com/v1/{+name}/occurrences",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

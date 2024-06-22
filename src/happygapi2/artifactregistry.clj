(ns happygapi2.artifactregistry
  "Artifact Registry API
Store and manage build artifacts in a scalable and integrated service built on Google infrastructure.
See: https://cloud.google.com/artifact-registry/docs"
  (:require [happy.oauth2.client :as client]))

(defn projects-getProjectSettings
  "Retrieves the Settings for the Project.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/getProjectSettings

name <string> Required. The name of the projectSettings resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-updateProjectSettings
  "Updates the Settings for the Project.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/updateProjectSettings

name <string> The name of the project's settings. Always of the form: projects/{project-id}/projectSettings In update request: never set In response: always set
ProjectSettings:
{:name string,
 :legacyRedirectionState
 [REDIRECTION_STATE_UNSPECIFIED
  REDIRECTION_FROM_GCR_IO_DISABLED
  REDIRECTION_FROM_GCR_IO_ENABLED
  REDIRECTION_FROM_GCR_IO_FINALIZED
  REDIRECTION_FROM_GCR_IO_ENABLED_AND_COPYING
  REDIRECTION_FROM_GCR_IO_PARTIAL_AND_COPYING]}

optional:
updateMask <string> Field mask to support partial updates."
  ([name ProjectSettings]
    (projects-updateProjectSettings name ProjectSettings nil))
  ([name ProjectSettings optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body ProjectSettings})))

(defn projects-locations-getVpcscConfig
  "Retrieves the VPCSC Config for the Project.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/getVpcscConfig

name <string> Required. The name of the VPCSCConfig resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-updateVpcscConfig
  "Updates the VPCSC Config for the Project.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/updateVpcscConfig

name <string> The name of the project's VPC SC Config. Always of the form: projects/{projectID}/locations/{location}/vpcscConfig In update request: never set In response: always set
VPCSCConfig:
{:name string, :vpcscPolicy [VPCSC_POLICY_UNSPECIFIED DENY ALLOW]}

optional:
updateMask <string> Field mask to support partial updates."
  ([name VPCSCConfig]
    (projects-locations-updateVpcscConfig name VPCSCConfig nil))
  ([name VPCSCConfig optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body VPCSCConfig})))

(defn projects-locations-list
  "Lists information about the supported locations for this service.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/list

name <string> The resource that owns the locations collection, if applicable.

optional:
filter <string> A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).
pageSize <integer> The maximum number of results to return. If not set, the service selects a default."
  ([name] (projects-locations-list name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}/locations",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-get
  "Gets information about a location.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/get

name <string> Resource name for the location."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-operations-get
  "Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/operations/get

name <string> The name of the operation resource."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-list
  "Lists repositories.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/list

parent <string> Required. The name of the parent resource whose repositories will be listed.

optional:
pageSize <integer> The maximum number of repositories to return. Maximum page size is 1,000."
  ([parent] (projects-locations-repositories-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/repositories",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-get
  "Gets a repository.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/get

name <string> Required. The name of the repository to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-create
  "Creates a repository. The returned Operation will finish once the repository has been created. Its response will be the created Repository.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/create

parent <string> Required. The name of the parent resource where the repository will be created.
Repository:
{:description string,
 :labels object,
 :format
 [FORMAT_UNSPECIFIED
  DOCKER
  MAVEN
  NPM
  APT
  YUM
  GOOGET
  PYTHON
  KFP
  GO
  GENERIC],
 :mavenConfig
 {:allowSnapshotOverwrites boolean,
  :versionPolicy [VERSION_POLICY_UNSPECIFIED RELEASE SNAPSHOT]},
 :satisfiesPzi boolean,
 :name string,
 :sizeBytes string,
 :mode
 [MODE_UNSPECIFIED
  STANDARD_REPOSITORY
  VIRTUAL_REPOSITORY
  REMOTE_REPOSITORY
  AOSS_REPOSITORY
  ASSURED_OSS_REPOSITORY],
 :createTime string,
 :cleanupPolicyDryRun boolean,
 :updateTime string,
 :virtualRepositoryConfig
 {:upstreamPolicies
  [{:id string, :repository string, :priority integer}]},
 :cleanupPolicies object,
 :dockerConfig {:immutableTags boolean},
 :satisfiesPzs boolean,
 :kmsKeyName string,
 :remoteRepositoryConfig
 {:description string,
  :pythonRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED PYPI],
   :customRepository {:uri string}},
  :npmRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED NPMJS],
   :customRepository {:uri string}},
  :aptRepository
  {:publicRepository
   {:repositoryBase
    [REPOSITORY_BASE_UNSPECIFIED DEBIAN UBUNTU DEBIAN_SNAPSHOT],
    :repositoryPath string},
   :customRepository {:uri string}},
  :disableUpstreamValidation boolean,
  :mavenRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED MAVEN_CENTRAL],
   :customRepository {:uri string}},
  :upstreamCredentials
  {:usernamePasswordCredentials
   {:username string, :passwordSecretVersion string}},
  :dockerRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED DOCKER_HUB],
   :customRepository {:uri string}},
  :yumRepository
  {:publicRepository
   {:repositoryBase
    [REPOSITORY_BASE_UNSPECIFIED
     CENTOS
     CENTOS_DEBUG
     CENTOS_VAULT
     CENTOS_STREAM
     ROCKY
     EPEL],
    :repositoryPath string},
   :customRepository {:uri string}}},
 :disallowUnspecifiedMode boolean}

optional:
repositoryId <string> Required. The repository id to use for this repository."
  ([parent Repository]
    (projects-locations-repositories-create parent Repository nil))
  ([parent Repository optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/repositories",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Repository})))

(defn projects-locations-repositories-patch
  "Updates a repository.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/patch

name <string> The name of the repository, for example: `projects/p1/locations/us-central1/repositories/repo1`. For each location in a project, repository names must be unique.
Repository:
{:description string,
 :labels object,
 :format
 [FORMAT_UNSPECIFIED
  DOCKER
  MAVEN
  NPM
  APT
  YUM
  GOOGET
  PYTHON
  KFP
  GO
  GENERIC],
 :mavenConfig
 {:allowSnapshotOverwrites boolean,
  :versionPolicy [VERSION_POLICY_UNSPECIFIED RELEASE SNAPSHOT]},
 :satisfiesPzi boolean,
 :name string,
 :sizeBytes string,
 :mode
 [MODE_UNSPECIFIED
  STANDARD_REPOSITORY
  VIRTUAL_REPOSITORY
  REMOTE_REPOSITORY
  AOSS_REPOSITORY
  ASSURED_OSS_REPOSITORY],
 :createTime string,
 :cleanupPolicyDryRun boolean,
 :updateTime string,
 :virtualRepositoryConfig
 {:upstreamPolicies
  [{:id string, :repository string, :priority integer}]},
 :cleanupPolicies object,
 :dockerConfig {:immutableTags boolean},
 :satisfiesPzs boolean,
 :kmsKeyName string,
 :remoteRepositoryConfig
 {:description string,
  :pythonRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED PYPI],
   :customRepository {:uri string}},
  :npmRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED NPMJS],
   :customRepository {:uri string}},
  :aptRepository
  {:publicRepository
   {:repositoryBase
    [REPOSITORY_BASE_UNSPECIFIED DEBIAN UBUNTU DEBIAN_SNAPSHOT],
    :repositoryPath string},
   :customRepository {:uri string}},
  :disableUpstreamValidation boolean,
  :mavenRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED MAVEN_CENTRAL],
   :customRepository {:uri string}},
  :upstreamCredentials
  {:usernamePasswordCredentials
   {:username string, :passwordSecretVersion string}},
  :dockerRepository
  {:publicRepository [PUBLIC_REPOSITORY_UNSPECIFIED DOCKER_HUB],
   :customRepository {:uri string}},
  :yumRepository
  {:publicRepository
   {:repositoryBase
    [REPOSITORY_BASE_UNSPECIFIED
     CENTOS
     CENTOS_DEBUG
     CENTOS_VAULT
     CENTOS_STREAM
     ROCKY
     EPEL],
    :repositoryPath string},
   :customRepository {:uri string}}},
 :disallowUnspecifiedMode boolean}

optional:
updateMask <string> The update mask applies to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name Repository]
    (projects-locations-repositories-patch name Repository nil))
  ([name Repository optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Repository})))

(defn projects-locations-repositories-delete
  "Deletes a repository and all of its contents. The returned Operation will finish once the repository has been deleted. It will not have any Operation metadata and will return a google.protobuf.Empty response.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/delete

name <string> Required. The name of the repository to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-setIamPolicy
  "Updates the IAM policy for a given resource.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/setIamPolicy

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
     "https://artifactregistry.googleapis.com/v1/{+resource}:setIamPolicy",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body SetIamPolicyRequest}))

(defn projects-locations-repositories-getIamPolicy
  "Gets the IAM policy for a given resource.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/getIamPolicy

resource <string> REQUIRED: The resource for which the policy is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.

optional:
options.requestedPolicyVersion <integer> Optional. The maximum policy version that will be used to format the policy. Valid values are 0, 1, and 3. Requests specifying an invalid value will be rejected. Requests for policies with any conditional role bindings must specify version 3. Policies with no conditional role bindings may specify any valid value or leave the field unset. The policy in the response might use the policy version that you specified, or it might use a lower policy version. For example, if you specify version 3, but the policy has no conditional role bindings, the response uses version 1. To learn which resources support conditions in their IAM policies, see the [IAM documentation](https://cloud.google.com/iam/help/conditions/resource-policies)."
  ([resource]
    (projects-locations-repositories-getIamPolicy resource nil))
  ([resource optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+resource}:getIamPolicy",
       :uri-template-args {:resource resource},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-testIamPermissions
  "Tests if the caller has a list of permissions on a resource.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/testIamPermissions

resource <string> REQUIRED: The resource for which the policy detail is being requested. See [Resource names](https://cloud.google.com/apis/design/resource_names) for the appropriate value for this field.
TestIamPermissionsRequest:
{:permissions [string]}"
  [resource TestIamPermissionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+resource}:testIamPermissions",
     :uri-template-args {:resource resource},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"],
     :body TestIamPermissionsRequest}))

(defn projects-locations-repositories-googetArtifacts-import
  "Imports GooGet artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/googetArtifacts/import

parent <string> The name of the parent resource where the artifacts will be imported.
ImportGoogetArtifactsRequest:
{:gcsSource {:uris [string], :useWildcards boolean}}"
  [parent ImportGoogetArtifactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/googetArtifacts:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ImportGoogetArtifactsRequest}))

(defn projects-locations-repositories-googetArtifacts-upload
  "Directly uploads a GooGet artifact. The returned Operation will complete once the resources are uploaded. Package, Version, and File resources are created based on the imported artifact. Imported artifacts that conflict with existing resources are ignored.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/googetArtifacts/upload

parent <string> The name of the parent resource where the artifacts will be uploaded.
UploadGoogetArtifactRequest:
object"
  [parent UploadGoogetArtifactRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/googetArtifacts:create",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UploadGoogetArtifactRequest}))

(defn projects-locations-repositories-kfpArtifacts-upload
  "Directly uploads a KFP artifact. The returned Operation will complete once the resource is uploaded. Package, Version, and File resources will be created based on the uploaded artifact. Uploaded artifacts that conflict with existing resources will be overwritten.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/kfpArtifacts/upload

parent <string> The resource name of the repository where the KFP artifact will be uploaded.
UploadKfpArtifactRequest:
{:tags [string], :description string}"
  [parent UploadKfpArtifactRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/kfpArtifacts:create",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UploadKfpArtifactRequest}))

(defn projects-locations-repositories-dockerImages-list
  "Lists docker images.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/dockerImages/list

parent <string> Required. The name of the parent resource whose docker images will be listed.

optional:
pageSize <integer> The maximum number of artifacts to return. Maximum page size is 1,000.
orderBy <string> The field to order the results by."
  ([parent]
    (projects-locations-repositories-dockerImages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/dockerImages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-dockerImages-get
  "Gets a docker image.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/dockerImages/get

name <string> Required. The name of the docker images."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-aptArtifacts-import
  "Imports Apt artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/aptArtifacts/import

parent <string> The name of the parent resource where the artifacts will be imported.
ImportAptArtifactsRequest:
{:gcsSource {:uris [string], :useWildcards boolean}}"
  [parent ImportAptArtifactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/aptArtifacts:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ImportAptArtifactsRequest}))

(defn projects-locations-repositories-aptArtifacts-upload
  "Directly uploads an Apt artifact. The returned Operation will complete once the resources are uploaded. Package, Version, and File resources are created based on the imported artifact. Imported artifacts that conflict with existing resources are ignored.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/aptArtifacts/upload

parent <string> The name of the parent resource where the artifacts will be uploaded.
UploadAptArtifactRequest:
object"
  [parent UploadAptArtifactRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/aptArtifacts:create",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UploadAptArtifactRequest}))

(defn projects-locations-repositories-npmPackages-list
  "Lists npm packages.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/npmPackages/list

parent <string> Required. The name of the parent resource whose npm packages will be listed.

optional:
pageSize <integer> The maximum number of artifacts to return. Maximum page size is 1,000."
  ([parent]
    (projects-locations-repositories-npmPackages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/npmPackages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-npmPackages-get
  "Gets a npm package.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/npmPackages/get

name <string> Required. The name of the npm package."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-pythonPackages-list
  "Lists python packages.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/pythonPackages/list

parent <string> Required. The name of the parent resource whose python packages will be listed.

optional:
pageSize <integer> The maximum number of artifacts to return. Maximum page size is 1,000."
  ([parent]
    (projects-locations-repositories-pythonPackages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/pythonPackages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-pythonPackages-get
  "Gets a python package.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/pythonPackages/get

name <string> Required. The name of the python package."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-mavenArtifacts-list
  "Lists maven artifacts.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/mavenArtifacts/list

parent <string> Required. The name of the parent resource whose maven artifacts will be listed.

optional:
pageSize <integer> The maximum number of artifacts to return. Maximum page size is 1,000."
  ([parent]
    (projects-locations-repositories-mavenArtifacts-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/mavenArtifacts",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-mavenArtifacts-get
  "Gets a maven artifact.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/mavenArtifacts/get

name <string> Required. The name of the maven artifact."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-genericArtifacts-upload
  "Directly uploads a Generic artifact. The returned operation will complete once the resources are uploaded. Package, version, and file resources are created based on the uploaded artifact. Uploaded artifacts that conflict with existing resources will raise an `ALREADY_EXISTS` error.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/genericArtifacts/upload

parent <string> The resource name of the repository where the generic artifact will be uploaded.
UploadGenericArtifactRequest:
{:packageId string, :versionId string, :filename string}"
  [parent UploadGenericArtifactRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/genericArtifacts:create",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UploadGenericArtifactRequest}))

(defn projects-locations-repositories-goModules-upload
  "Directly uploads a Go module. The returned Operation will complete once the Go module is uploaded. Package, Version, and File resources are created based on the uploaded Go module.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/goModules/upload

parent <string> The resource name of the repository where the Go module will be uploaded.
UploadGoModuleRequest:
object"
  [parent UploadGoModuleRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/goModules:create",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UploadGoModuleRequest}))

(defn projects-locations-repositories-files-list
  "Lists files.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/files/list

parent <string> Required. The name of the repository whose files will be listed. For example: \"projects/p1/locations/us-central1/repositories/repo1

optional:
filter <string> An expression for filtering the results of the request. Filter rules are case insensitive. The fields eligible for filtering are: * `name` * `owner` An example of using a filter: * `name=\"projects/p1/locations/us-central1/repositories/repo1/files/a/b/*\"` --> Files with an ID starting with \"a/b/\". * `owner=\"projects/p1/locations/us-central1/repositories/repo1/packages/pkg1/versions/1.0\"` --> Files owned by the version `1.0` in package `pkg1`.
pageSize <integer> The maximum number of files to return. Maximum page size is 1,000.
orderBy <string> The field to order the results by."
  ([parent] (projects-locations-repositories-files-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/files",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-files-get
  "Gets a file.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/files/get

name <string> Required. The name of the file to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-files-download
  "Download a file.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/files/download

name <string> Required. The name of the file to download."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}:download",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-files-delete
  "Deletes a file and all of its content. It is only allowed on generic repositories. The returned operation will complete once the file has been deleted.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/files/delete

name <string> Required. The name of the file to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-packages-list
  "Lists packages.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/list

parent <string> Required. The name of the parent resource whose packages will be listed.

optional:
pageSize <integer> The maximum number of packages to return. Maximum page size is 1,000."
  ([parent] (projects-locations-repositories-packages-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/packages",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-packages-get
  "Gets a package.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/get

name <string> Required. The name of the package to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-packages-delete
  "Deletes a package and all of its versions and tags. The returned operation will complete once the package has been deleted.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/delete

name <string> Required. The name of the package to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-packages-patch
  "Updates a package.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/patch

name <string> The name of the package, for example: `projects/p1/locations/us-central1/repositories/repo1/packages/pkg1`. If the package ID part contains slashes, the slashes are escaped.
Package:
{:name string,
 :displayName string,
 :createTime string,
 :updateTime string,
 :annotations object}

optional:
updateMask <string> The update mask applies to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name Package]
    (projects-locations-repositories-packages-patch name Package nil))
  ([name Package optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Package})))

(defn projects-locations-repositories-packages-versions-list
  "Lists versions.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/versions/list

parent <string> The name of the parent resource whose versions will be listed.

optional:
pageSize <integer> The maximum number of versions to return. Maximum page size is 1,000.
view <string> The view that should be returned in the response.
orderBy <string> Optional. The field to order the results by."
  ([parent]
    (projects-locations-repositories-packages-versions-list
      parent
      nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/versions",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-packages-versions-get
  "Gets a version
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/versions/get

name <string> The name of the version to retrieve.

optional:
view <string> The view that should be returned in the response."
  ([name]
    (projects-locations-repositories-packages-versions-get name nil))
  ([name optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-packages-versions-delete
  "Deletes a version and all of its content. The returned operation will complete once the version has been deleted.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/versions/delete

name <string> The name of the version to delete.

optional:
force <boolean> By default, a version that is tagged may not be deleted. If force=true, the version and any tags pointing to the version are deleted."
  ([name]
    (projects-locations-repositories-packages-versions-delete
      name
      nil))
  ([name optional]
    (client/api-request
      {:method "DELETE",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"]})))

(defn projects-locations-repositories-packages-versions-batchDelete
  "Deletes multiple versions across a repository. The returned operation will complete once the versions have been deleted.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/versions/batchDelete

parent <string> The name of the repository holding all requested versions.
BatchDeleteVersionsRequest:
{:names [string], :validateOnly boolean}"
  [parent BatchDeleteVersionsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/versions:batchDelete",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body BatchDeleteVersionsRequest}))

(defn projects-locations-repositories-packages-tags-list
  "Lists tags.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/tags/list

parent <string> The name of the parent package whose tags will be listed. For example: `projects/p1/locations/us-central1/repositories/repo1/packages/pkg1`.

optional:
filter <string> An expression for filtering the results of the request. Filter rules are case insensitive. The fields eligible for filtering are: * `version` An example of using a filter: * `version=\"projects/p1/locations/us-central1/repositories/repo1/packages/pkg1/versions/1.0\"` --> Tags that are applied to the version `1.0` in package `pkg1`. * `name=\"projects/p1/locations/us-central1/repositories/repo1/packages/pkg1/tags/a%2Fb%2F*\"` --> tags with an ID starting with \"a/b/\". * `name=\"projects/p1/locations/us-central1/repositories/repo1/packages/pkg1/tags/*%2Fb%2Fc\"` --> tags with an ID ending with \"/b/c\". * `name=\"projects/p1/locations/us-central1/repositories/repo1/packages/pkg1/tags/*%2Fb%2F*\"` --> tags with an ID containing \"/b/\".
pageSize <integer> The maximum number of tags to return. Maximum page size is 1,000."
  ([parent]
    (projects-locations-repositories-packages-tags-list parent nil))
  ([parent optional]
    (client/api-request
      {:method "GET",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/tags",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes
       ["https://www.googleapis.com/auth/cloud-platform"
        "https://www.googleapis.com/auth/cloud-platform.read-only"]})))

(defn projects-locations-repositories-packages-tags-get
  "Gets a tag.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/tags/get

name <string> The name of the tag to retrieve."
  [name]
  (client/api-request
    {:method "GET",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes
     ["https://www.googleapis.com/auth/cloud-platform"
      "https://www.googleapis.com/auth/cloud-platform.read-only"]}))

(defn projects-locations-repositories-packages-tags-create
  "Creates a tag.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/tags/create

parent <string> The name of the parent resource where the tag will be created.
Tag:
{:name string, :version string}

optional:
tagId <string> The tag id to use for this repository."
  ([parent Tag]
    (projects-locations-repositories-packages-tags-create
      parent
      Tag
      nil))
  ([parent Tag optional]
    (client/api-request
      {:method "POST",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+parent}/tags",
       :uri-template-args {:parent parent},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Tag})))

(defn projects-locations-repositories-packages-tags-patch
  "Updates a tag.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/tags/patch

name <string> The name of the tag, for example: \"projects/p1/locations/us-central1/repositories/repo1/packages/pkg1/tags/tag1\". If the package part contains slashes, the slashes are escaped. The tag part can only have characters in [a-zA-Z0-9\\-._~:@], anything else must be URL encoded.
Tag:
{:name string, :version string}

optional:
updateMask <string> The update mask applies to the resource. For the `FieldMask` definition, see https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask"
  ([name Tag]
    (projects-locations-repositories-packages-tags-patch name Tag nil))
  ([name Tag optional]
    (client/api-request
      {:method "PATCH",
       :uri-template
       "https://artifactregistry.googleapis.com/v1/{+name}",
       :uri-template-args {:name name},
       :query-params (merge {} optional),
       :scopes ["https://www.googleapis.com/auth/cloud-platform"],
       :body Tag})))

(defn projects-locations-repositories-packages-tags-delete
  "Deletes a tag.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/packages/tags/delete

name <string> The name of the tag to delete."
  [name]
  (client/api-request
    {:method "DELETE",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+name}",
     :uri-template-args {:name name},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"]}))

(defn projects-locations-repositories-yumArtifacts-import
  "Imports Yum (RPM) artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/yumArtifacts/import

parent <string> The name of the parent resource where the artifacts will be imported.
ImportYumArtifactsRequest:
{:gcsSource {:uris [string], :useWildcards boolean}}"
  [parent ImportYumArtifactsRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/yumArtifacts:import",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body ImportYumArtifactsRequest}))

(defn projects-locations-repositories-yumArtifacts-upload
  "Directly uploads a Yum artifact. The returned Operation will complete once the resources are uploaded. Package, Version, and File resources are created based on the imported artifact. Imported artifacts that conflict with existing resources are ignored.
https://cloud.google.com/artifact-registry/docs/reference/rest/v1/projects/locations/repositories/yumArtifacts/upload

parent <string> The name of the parent resource where the artifacts will be uploaded.
UploadYumArtifactRequest:
object"
  [parent UploadYumArtifactRequest]
  (client/api-request
    {:method "POST",
     :uri-template
     "https://artifactregistry.googleapis.com/v1/{+parent}/yumArtifacts:create",
     :uri-template-args {:parent parent},
     :query-params {},
     :scopes ["https://www.googleapis.com/auth/cloud-platform"],
     :body UploadYumArtifactRequest}))
